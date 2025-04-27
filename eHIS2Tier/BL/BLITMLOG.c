
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
           char  filnam[62];
};
static const struct sqlcxp sqlfpn =
{
    61,
    "C:\\Documents and Settings\\NagarajanD\\Desktop\\BUGS\\BLITMLOG.pc"
};


static unsigned long sqlctx = 728852611;


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
            void  *sqhstv[15];
   unsigned int   sqhstl[15];
            int   sqhsts[15];
            void  *sqindv[15];
            int   sqinds[15];
   unsigned int   sqharm[15];
   unsigned int   *sqharc[15];
   unsigned short  sqadto[15];
   unsigned short  sqtdso[15];
} sqlstm = {10,15};

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

 static const char *sq0004 = 
"select ITEM_CODE ,TO_CHAR(PUBLIC_PRICE) ,TO_CHAR(INPATIENT_PRICE) ,TO_CHAR(O\
UTPATIENT_PRICE) ,TO_CHAR(EXTERNAL_PRICE) ,TO_CHAR(EMERGENCY_PRICE) ,TO_CHAR(D\
AYCARE_PRICE) ,INP_REIMBURSABLE_YN ,INP_REIMBURSABLE_IND ,TO_CHAR(INP_REIMBURS\
ABLE_AMT) ,INP_OVERRIDE_REIMBURSABLE_YN ,OTH_REIMBURSABLE_YN ,OTH_REIMBURSABLE\
_IND ,TO_CHAR(OTH_REIMBURSABLE_AMT) ,OTH_OVERRIDE_REIMBURSABLE_YN  from BL_UPL\
OAD_ITEM_PRICE_EXT            ";

 static const char *sq0005 = 
"select ITEM_CODE  from MM_ITEM where ITEM_CODE=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,101,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,176,0,4,157,0,0,8,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,
83,0,0,3,116,0,2,179,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
114,0,0,4,418,0,9,217,0,0,0,0,0,1,0,
129,0,0,5,61,0,9,224,0,0,1,1,0,1,0,1,9,0,0,
148,0,0,4,0,0,13,241,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
223,0,0,5,0,0,13,282,0,0,1,0,0,1,0,2,9,0,0,
242,0,0,4,0,0,15,290,0,0,0,0,0,1,0,
257,0,0,5,0,0,15,297,0,0,0,0,0,1,0,
272,0,0,6,91,0,4,328,0,0,1,0,0,1,0,2,9,0,0,
291,0,0,7,154,0,4,331,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
318,0,0,8,141,0,4,385,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
349,0,0,9,196,0,6,733,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


#include <stdio.h>
#include <string.h>
#include "bl.h"
#include "gl.h"
         
#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define VIEW_LOG_FILE 1

/* EXEC SQL BEGIN DECLARE SECTION; */ 

    /* VARCHAR hosp_name                              [120],
	    date_time                                  [20],
	    user_id                                    [40],
	    nd_pwd 										[91],
	    nd_session_id                              [16],
	    nd_pgm_date                                [25],
	    d_curr_pgm_name                            [15],
	    nd_operating_facility_id					[3],
	    nd_operating_facility						[3],
	    nd_price_id									[21],
	    nd_fm_date									[11],
		nd_fm_date1									[12],
	    nd_to_date									[11],
	    ERROR_MSG									[2000]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility;

struct { unsigned short len; unsigned char arr[21]; } nd_price_id;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_date1;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[2000]; } ERROR_MSG;
   
 
    /* VARCHAR d_mi_code					[120],
			d_item_code					[61],
			l_pcode						[61],
			d_effe_fm_date				[11],
			l_max_date					[21],
			l_item_code                 [61],
			l_fm_date					[21],
			d_public_price				[6],
			d_inpatient_price			[6],
			d_outpatient_price			[6],
			d_external_price			[6],
			d_emergency_price			[6],
			d_daycare_price				[6],
			nd_temp_date				[20],
			nd_loc_date					[20],
			date_convert				[20],
			nd_lang_id					[4],
			nd_msg1						[2000],
			nd_msg2						[2000],
			nd_msg3						[2000],
			nd_msg4						[2000],
			nd_msg5						[2000],
			nd_msg6						[2000],
			nd_msg7						[2000],
			nd_msg8						[2000],
			nd_msg9						[2000],
			nd_msg10					[2000],
			nd_msg11					[2000],
			nd_msg12					[2000],
			nd_msg13					[2000],
			nd_msg14	  				[2000],
			nd_msg15					[2000],
			nd_msg16					[2000],
			d_inp_reimbursable_yn		[4],
			d_oth_reimbursable_yn		[4],
			d_inp_reimbursable_ind		[4], 
	        d_oth_reimbursable_ind		[4],
			d_oth_reimbursable_amt		[6],
			d_inp_reimbursable_amt		[6], 
			d_inp_override_reimbursable_yn[4],
			d_oth_override_reimbursable_yn[4]; */ 
struct { unsigned short len; unsigned char arr[120]; } d_mi_code;

struct { unsigned short len; unsigned char arr[61]; } d_item_code;

struct { unsigned short len; unsigned char arr[61]; } l_pcode;

struct { unsigned short len; unsigned char arr[11]; } d_effe_fm_date;

struct { unsigned short len; unsigned char arr[21]; } l_max_date;

struct { unsigned short len; unsigned char arr[61]; } l_item_code;

struct { unsigned short len; unsigned char arr[21]; } l_fm_date;

struct { unsigned short len; unsigned char arr[6]; } d_public_price;

struct { unsigned short len; unsigned char arr[6]; } d_inpatient_price;

struct { unsigned short len; unsigned char arr[6]; } d_outpatient_price;

struct { unsigned short len; unsigned char arr[6]; } d_external_price;

struct { unsigned short len; unsigned char arr[6]; } d_emergency_price;

struct { unsigned short len; unsigned char arr[6]; } d_daycare_price;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[20]; } date_convert;

struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg1;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg2;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg3;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg4;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg5;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg6;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg7;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg8;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg9;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg10;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg11;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg12;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg13;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg14;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg15;

struct { unsigned short len; unsigned char arr[2000]; } nd_msg16;

struct { unsigned short len; unsigned char arr[4]; } d_inp_reimbursable_yn;

struct { unsigned short len; unsigned char arr[4]; } d_oth_reimbursable_yn;

struct { unsigned short len; unsigned char arr[4]; } d_inp_reimbursable_ind;

struct { unsigned short len; unsigned char arr[4]; } d_oth_reimbursable_ind;

struct { unsigned short len; unsigned char arr[6]; } d_oth_reimbursable_amt;

struct { unsigned short len; unsigned char arr[6]; } d_inp_reimbursable_amt;

struct { unsigned short len; unsigned char arr[4]; } d_inp_override_reimbursable_yn;

struct { unsigned short len; unsigned char arr[4]; } d_oth_override_reimbursable_yn;


    
    char filename[150];
	int	l_pr_id,l_cnt,l_err;

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
 
    strcpy(g_pgm_id,"BLITMLOG");

    strcpy(nd_pwd.arr,argv[1]);
    nd_pwd.len = strlen(nd_pwd.arr);

	/* EXEC SQL CONNECT :nd_pwd; */ 

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


	if(OERROR)
    {
		disp_message(ERR_MESG,"Error in connecting to Oracle");
		proc_exit();
    }

	set_meduser_role();

	strcpy(nd_lang_id.arr,l_language_id.arr);
    nd_lang_id.len = l_language_id.len;
	

	strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

    strcpy(nd_operating_facility_id.arr,argv[4]);
    nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);  



    strcpy(g_facility_id,nd_operating_facility_id.arr);    

    fetch_prog_param();

	declare_cursor();

	open_cursor();

	open_file();

	declare_cursor1();

	create_log_file();

	close_cursor();

	close_file();

}

fetch_prog_param()
{
	nd_operating_facility.arr[0]	= '\0';
	nd_fm_date.arr[0]			= '\0';
	nd_to_date.arr[0]			= '\0';
	nd_price_id.arr[0]			= '\0';
	
  /* EXEC SQL SELECT PARAM1,
			PARAM2,
			PARAM3, 
			PARAM4 
	   INTO	:nd_operating_facility,
			:nd_fm_date,
			:nd_to_date,
			:nd_price_id
	   FROM SY_PROG_PARAM
	   WHERE OPERATING_FACILITY_ID   = :nd_operating_facility_id
		 AND   PGM_ID                = :d_curr_pgm_name
		 AND   TO_CHAR(SESSION_ID)   = :nd_session_id
		 AND   PGM_DATE              = :nd_pgm_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 8;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 into :b0,:b1,:b2,:b3 \
 from SY_PROG_PARAM where (((OPERATING_FACILITY_ID=:b4 and PGM_ID=:b5) and TO_\
CHAR(SESSION_ID)=:b6) and PGM_DATE=:b7)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_price_id;
  sqlstm.sqhstl[3] = (unsigned int  )23;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[4] = (unsigned int  )5;
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

	if (NOT_FOUND)
		err_mesg("No Record found in SY_PROG_PARAM",0,"");

      
   /* EXEC SQL DELETE SY_PROG_PARAM WHERE OPERATING_FACILITY_ID =  :nd_operating_facility_id
		 AND   PGM_ID                = :d_curr_pgm_name
		 AND   SESSION_ID            = :nd_session_id
		 AND   PGM_DATE              = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((OPERATING_FACILITY_ID\
=:b0 and PGM_ID=:b1) and SESSION_ID=:b2) and PGM_DATE=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )83;
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
   sqlstm.sqhstv[1] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[1] = (unsigned int  )17;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[2] = (unsigned int  )18;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[3] = (unsigned int  )27;
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
	err_mesg("DELETION failed on table SY_PROG_PARAM",0,"");
}

declare_cursor()
{
	/* EXEC SQL DECLARE C_BL_UPLOAD CURSOR FOR 
		SELECT	ITEM_CODE,
			TO_CHAR(PUBLIC_PRICE),
			TO_CHAR(INPATIENT_PRICE),
			TO_CHAR(OUTPATIENT_PRICE),
			TO_CHAR(EXTERNAL_PRICE),
			TO_CHAR(EMERGENCY_PRICE),
			TO_CHAR(DAYCARE_PRICE),
			INP_REIMBURSABLE_YN,
			INP_REIMBURSABLE_IND, 
			TO_CHAR(INP_REIMBURSABLE_AMT), 
			INP_OVERRIDE_REIMBURSABLE_YN, 
			OTH_REIMBURSABLE_YN, 
			OTH_REIMBURSABLE_IND, 
			TO_CHAR(OTH_REIMBURSABLE_AMT), 
			OTH_OVERRIDE_REIMBURSABLE_YN
		FROM	BL_UPLOAD_ITEM_PRICE_EXT; */ 
 
}

declare_cursor1()
{
	/* EXEC SQL DECLARE C_MM_UPLOAD CURSOR FOR
		SELECT ITEM_CODE FROM MM_ITEM WHERE ITEM_CODE =:d_item_code; */ 

}
 
open_cursor()
{
	/* EXEC SQL OPEN C_BL_UPLOAD; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0004;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )114;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
        err_mesg("OPEN failed on cursor C_BL_UPLOAD",0,"");
}

open_cursor1()
{
	/* EXEC SQL OPEN C_MM_UPLOAD; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0005;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )129;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_item_code;
 sqlstm.sqhstl[0] = (unsigned int  )63;
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
        err_mesg("OPEN failed on cursor C_BL_UPLOAD",0,"");
}

fetch_cursor()
{
	d_item_code.arr[0]			= '\0';
	d_public_price.arr[0]		= '\0';
	d_inpatient_price.arr[0]	= '\0';
	d_outpatient_price.arr[0]	= '\0';
	d_external_price.arr[0]		= '\0';
	d_emergency_price.arr[0]	= '\0';
	d_daycare_price.arr[0]		= '\0';



	/* EXEC SQL FETCH C_BL_UPLOAD INTO	
				:d_item_code,
				:d_public_price,
				:d_inpatient_price,
				:d_outpatient_price,
				:d_external_price,
				:d_emergency_price,
				:d_daycare_price,
				:d_inp_reimbursable_yn,
				:d_inp_reimbursable_ind		, 
				:d_inp_reimbursable_amt		,
				:d_inp_override_reimbursable_yn,
			    :d_oth_reimbursable_yn			,
				:d_oth_reimbursable_ind		,
				:d_oth_reimbursable_amt		, 
				:d_oth_override_reimbursable_yn; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )148;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_item_code;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_public_price;
 sqlstm.sqhstl[1] = (unsigned int  )8;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_inpatient_price;
 sqlstm.sqhstl[2] = (unsigned int  )8;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_outpatient_price;
 sqlstm.sqhstl[3] = (unsigned int  )8;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_external_price;
 sqlstm.sqhstl[4] = (unsigned int  )8;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_emergency_price;
 sqlstm.sqhstl[5] = (unsigned int  )8;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_daycare_price;
 sqlstm.sqhstl[6] = (unsigned int  )8;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_inp_reimbursable_yn;
 sqlstm.sqhstl[7] = (unsigned int  )6;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_inp_reimbursable_ind;
 sqlstm.sqhstl[8] = (unsigned int  )6;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_inp_reimbursable_amt;
 sqlstm.sqhstl[9] = (unsigned int  )8;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_inp_override_reimbursable_yn;
 sqlstm.sqhstl[10] = (unsigned int  )6;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_oth_reimbursable_yn;
 sqlstm.sqhstl[11] = (unsigned int  )6;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_oth_reimbursable_ind;
 sqlstm.sqhstl[12] = (unsigned int  )6;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&d_oth_reimbursable_amt;
 sqlstm.sqhstl[13] = (unsigned int  )8;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&d_oth_override_reimbursable_yn;
 sqlstm.sqhstl[14] = (unsigned int  )6;
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



	d_item_code.arr[d_item_code.len]				= '\0';
	d_public_price.arr[d_public_price.len]			= '\0';
	d_inpatient_price.arr[d_inpatient_price.len]	= '\0';
	d_outpatient_price.arr[d_outpatient_price.len]	= '\0';
	d_external_price.arr[d_external_price.len]		= '\0';
	d_emergency_price.arr[d_emergency_price.len]	= '\0';
	d_daycare_price.arr[d_daycare_price.len]		= '\0';
	d_inp_reimbursable_yn.arr[d_inp_reimbursable_yn.len] = '\0';
	d_oth_reimbursable_yn.arr[d_oth_reimbursable_yn.len]= '\0';
	d_inp_reimbursable_ind.arr[d_inp_reimbursable_ind.len]= '\0';
	d_oth_reimbursable_ind.arr[d_oth_reimbursable_ind.len]= '\0';
	d_oth_reimbursable_amt.arr[d_oth_reimbursable_amt.len]= '\0';
	d_inp_reimbursable_amt.arr[d_inp_reimbursable_amt.len]= '\0';
	d_inp_override_reimbursable_yn.arr[d_inp_override_reimbursable_yn.len]= '\0';
	d_oth_override_reimbursable_yn.arr[d_oth_override_reimbursable_yn.len]= '\0';
	if (OERROR)
        err_mesg("FETCH failed on cursor C_BL_UPLOAD",0,"");
   return(LAST_ROW?0:1);
}

fetch_cursor1()
{
	d_mi_code.arr[0] = '\0';
    d_mi_code.len =0;
	/* EXEC SQL FETCH C_MM_UPLOAD INTO :d_mi_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )223;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_mi_code;
 sqlstm.sqhstl[0] = (unsigned int  )122;
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


    d_mi_code.arr[d_mi_code.len] = '\0';
	if (OERROR)
        err_mesg("FETCH failed on cursor C_BL_UPLOAD",0,"");
}
	
close_cursor()
{
	/* EXEC SQL CLOSE C_BL_UPLOAD; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )242;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
        err_mesg("CLOSE failed on cursor C_BL_UPLOAD",0,"");
}

close_cursor1()
{
	/* EXEC SQL CLOSE C_MM_UPLOAD; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )257;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
        err_mesg("CLOSE failed on cursor C_BL_UPLOAD",0,"");
}

open_file()
{
    strcpy(filename,WORKING_DIR);
    strcat(filename,"BLITMLOG.log");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLITMLOG.log");
       proc_exit();
    }
}

close_file()
{
	fflush(fp);
	fclose(fp);
}

create_log_file()
{
    
    l_max_date.arr[0] = '\0';
	l_fm_date.arr[0]  = '\0';

	l_cnt = 0;

	/* EXEC SQL SELECT TO_CHAR(MAX(effective_from_date),'DD-MON-YYYY')INTO :l_max_date FROM  BL_ST_ITEM_BY_PERIOD; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(max(effective_from_date),'DD-MON-YYYY') into \
:b0  from BL_ST_ITEM_BY_PERIOD ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )272;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_max_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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


		

	/* EXEC SQL SELECT TO_CHAR(MAX(EFFECTIVE_FROM_DATE),'DD-MON-YYYY'), ITEM_CODE 
 		INTO :l_fm_date ,	:l_item_code 
 		FROM  BL_ST_ITEM_BY_PERIOD 
 		WHERE EFFECTIVE_FROM_DATE < :nd_fm_date
		group by ITEM_CODE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(max(EFFECTIVE_FROM_DATE),'DD-MON-YYYY') ,ITEM\
_CODE into :b0,:b1  from BL_ST_ITEM_BY_PERIOD where EFFECTIVE_FROM_DATE<:b2 gr\
oup by ITEM_CODE";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )291;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_fm_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_item_code;
 sqlstm.sqhstl[1] = (unsigned int  )63;
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



	//EXEC SQL SELECT COUNT(*)                      //Comment on 03/01/2008
 	//	INTO :l_cnt                                 //Comment on 03/01/2008
 	//	FROM  BL_ST_ITEM_BY_PERIOD                  //Comment on 03/01/2008
 	//	WHERE EFFECTIVE_FROM_DATE >= :nd_fm_date;   //Comment on 03/01/2008

	if (l_cnt > 0)
	{
		
		if(l_max_date.arr[0]!='\0')
		{

		  init_date_temp_var();
		  strcpy(date_convert.arr,l_max_date.arr);
		  fun_change_loc_date();
		  strcpy(l_max_date.arr,nd_loc_date.arr);

		 } 


		strcat(nd_msg1.arr,"Definition Already Exists with Effective From Date");
		strcat(nd_msg1.arr,", Item: ");
		strcat(nd_msg1.arr,l_item_code.arr);
		strcat(nd_msg1.arr,", Max Date: ");
		strcat(nd_msg1.arr,l_max_date.arr);
		strcat(nd_msg1.arr,"Cannot be proceed, Please cancel the record/Enter manually");
		disp_message(ERR_MESG,nd_msg1.arr);
		strcpy(nd_msg1.arr,"");
        l_err =1;
		//disp_message(ERR_MESG,"Definition Already Exists with Effective From Date");
		//disp_message(ERR_MESG,l_item_code.arr);
		//disp_message(ERR_MESG,l_max_date.arr);
		//disp_message(ERR_MESG,"Cannot be proceed, Please cancel the record/Enter manually");


	}
	else
	{

		while (fetch_cursor())
		{
			open_cursor1();
			fetch_cursor1();
			close_cursor1();

			if (strcmp(d_item_code.arr,d_mi_code.arr) == 0)
			{
				l_pr_id = 0;

				/* EXEC SQL SELECT COUNT(*) INTO :l_pr_id
					FROM	BL_ST_ITEM_BY_PERIOD 
					WHERE	OPERATING_FACILITY_ID =:nd_operating_facility_id AND
						ITEM_CODE =:d_item_code AND
						TRUNC(EFFECTIVE_FROM_DATE) = :nd_fm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(*)  into :b0  from BL_ST_ITEM_BY_PERIOD wher\
e ((OPERATING_FACILITY_ID=:b1 and ITEM_CODE=:b2) and TRUNC(EFFECTIVE_FROM_DATE\
)=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )318;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_pr_id;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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
    sqlstm.sqhstv[2] = (         void  *)&d_item_code;
    sqlstm.sqhstl[2] = (unsigned int  )63;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[3] = (unsigned int  )13;
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
					err_mesg("SELECT Count Failed",0,"");

//added on 3/1/2008

				if (l_pr_id == 1)
				{

					strcat(nd_msg2.arr,"Definition Already Exists with this Effective From Date");
					strcat(nd_msg2.arr,", Item: ");
					strcat(nd_msg2.arr,d_item_code.arr);
					strcat(nd_msg2.arr,", Eff. From Date: ");
					strcat(nd_msg2.arr,nd_fm_date.arr);
					disp_message(ERR_MESG,nd_msg2.arr);
					strcpy(nd_msg2.arr,"");
					l_err =1;
					//disp_message(ERR_MESG,"Definition Already Exists with this Effective From Date");
					//disp_message(ERR_MESG,"Item: ");					
					//disp_message(ERR_MESG,d_item_code.arr);
					//disp_message(ERR_MESG,"Eff. From Date: ");
					//disp_message(ERR_MESG,nd_fm_date.arr);

				
				}

//added on 3/1/2008

				if (l_pr_id > 1)
				{
					fprintf(fp,"%-s%-s%-sThis Item is not defined\n\n",nd_operating_facility_id.arr,d_item_code.arr);
					proc_exit();
				}
                
				if (strlen(d_item_code.arr))
				{
					if (!strlen(d_inpatient_price.arr))
					{
					
						strcat(nd_msg3.arr,"Inpatient Price is not defined for the Facility: ");
						strcat(nd_msg3.arr,nd_operating_facility.arr);
						strcat(nd_msg3.arr,", Item: ");
						strcat(nd_msg3.arr,d_item_code.arr);
						strcat(nd_msg3.arr,", Eff. From Date: ");
						strcat(nd_msg3.arr,nd_fm_date.arr);
						disp_message(ERR_MESG,nd_msg3.arr);
						strcpy(nd_msg3.arr,"");
						l_err =1;
						//disp_message(ERR_MESG,"Inpatient Price is not defined for the Facility: ");
						//disp_message(ERR_MESG,nd_operating_facility.arr);
						//disp_message(ERR_MESG,"Item: ");
						//disp_message(ERR_MESG,d_item_code.arr);
						//disp_message(ERR_MESG,"Eff. From Date: ");
						//disp_message(ERR_MESG,nd_fm_date.arr);


					}
					
					if (!strlen(d_outpatient_price.arr))
					{

						strcat(nd_msg4.arr,"Outpatient Price is not defined for the Facility: ");
						strcat(nd_msg4.arr,nd_operating_facility.arr);
						strcat(nd_msg4.arr,", Item: ");
						strcat(nd_msg4.arr,d_item_code.arr);
						strcat(nd_msg4.arr,", Eff. From Date: ");
						strcat(nd_msg4.arr,nd_fm_date.arr);
						disp_message(ERR_MESG,nd_msg4.arr);
						strcpy(nd_msg4.arr,"");
						l_err =1;
						//disp_message(ERR_MESG,"Outpatient Price is not defined for the Facility: ");
						//disp_message(ERR_MESG,nd_operating_facility.arr);
						//disp_message(ERR_MESG,"Item: ");
						//disp_message(ERR_MESG,d_item_code.arr);
						//disp_message(ERR_MESG,"Eff. From Date: ");
						//disp_message(ERR_MESG,nd_fm_date.arr);

					}
					
					if (!strlen(d_external_price.arr))
					{


						strcat(nd_msg5.arr,"External Price is not defined for the Facility: ");
						strcat(nd_msg5.arr,nd_operating_facility.arr);
						strcat(nd_msg5.arr,", Item: ");
						strcat(nd_msg5.arr,d_item_code.arr);
						strcat(nd_msg5.arr,", Eff. From Date: ");
						strcat(nd_msg5.arr,nd_fm_date.arr);
						disp_message(ERR_MESG,nd_msg5.arr);
						strcpy(nd_msg5.arr,"");
						l_err =1;
						//disp_message(ERR_MESG,"External Price is not defined for the Facility: ");
						//disp_message(ERR_MESG,nd_operating_facility.arr);
						//disp_message(ERR_MESG,"Item: ");
						//disp_message(ERR_MESG,d_item_code.arr);
						//disp_message(ERR_MESG,"Eff. From Date: ");
						//disp_message(ERR_MESG,nd_fm_date.arr);

					}
					
					if (!strlen(d_emergency_price.arr))
					{

						strcat(nd_msg6.arr,"Emergency Price is not defined for the Facility: ");
						strcat(nd_msg6.arr,nd_operating_facility.arr);
						strcat(nd_msg6.arr,", Item: ");
						strcat(nd_msg6.arr,d_item_code.arr);
						strcat(nd_msg6.arr,", Eff. From Date: ");
						strcat(nd_msg6.arr,nd_fm_date.arr);
						disp_message(ERR_MESG,nd_msg6.arr);
						strcpy(nd_msg6.arr,"");
						l_err =1;
						//disp_message(ERR_MESG,"Emergency Price is not defined for the Facility: ");
						//disp_message(ERR_MESG,nd_operating_facility.arr);
						//disp_message(ERR_MESG,"Item: ");
						//disp_message(ERR_MESG,d_item_code.arr);
						//disp_message(ERR_MESG,"Eff. From Date: ");
						//disp_message(ERR_MESG,nd_fm_date.arr);

					}
					
					if (!strlen(d_daycare_price.arr))
					{
						
						strcat(nd_msg7.arr,"Daycare Price is not defined for the Facility: ");
						strcat(nd_msg7.arr,nd_operating_facility.arr);
						strcat(nd_msg7.arr,", Item: ");
						strcat(nd_msg7.arr,d_item_code.arr);
						strcat(nd_msg7.arr,", Eff. From Date: ");
						strcat(nd_msg7.arr,nd_fm_date.arr);
						disp_message(ERR_MESG,nd_msg7.arr);
						strcpy(nd_msg7.arr,"");
						l_err =1;
						//disp_message(ERR_MESG,"Daycare Price is not defined for the Facility: ");
						//disp_message(ERR_MESG,nd_operating_facility.arr);
						//disp_message(ERR_MESG,"Item: ");
						//disp_message(ERR_MESG,d_item_code.arr);
						//disp_message(ERR_MESG,"Eff. From Date: ");
						//disp_message(ERR_MESG,nd_fm_date.arr);

					}



			      if (strcmp(d_inp_reimbursable_yn.arr,"Y")!=0)
				   {
				     if (strcmp(d_inp_reimbursable_yn.arr,"N")!=0)
					   {  
					      if (strlen(d_inp_reimbursable_yn.arr))
						   {
									strcat(nd_msg16.arr,"Invalid value for Inpatient/Daycare Reimbursable for the Facility: ");
									strcat(nd_msg16.arr,nd_operating_facility.arr);
									strcat(nd_msg16.arr,", Item: ");
									strcat(nd_msg16.arr,d_item_code.arr);
									disp_message(ERR_MESG,nd_msg16.arr);
									strcpy(nd_msg16.arr,"");
									l_err =1;
							}
						}
					}
				if (strcmp(d_inp_reimbursable_ind.arr,"F")!=0)
				   {
				     if (strcmp(d_inp_reimbursable_ind.arr,"P")!=0)
					   {  
					      if (strcmp(d_inp_reimbursable_ind.arr,"N")!=0)
						   {
									strcat(nd_msg9.arr,"Invalid value for Inpatient/Daycare Reimbursable Indicator for the Facility: ");
									strcat(nd_msg9.arr,nd_operating_facility.arr);
									strcat(nd_msg9.arr,", Item: ");
									strcat(nd_msg9.arr,d_item_code.arr);
									disp_message(ERR_MESG,nd_msg9.arr);
									strcpy(nd_msg9.arr,"");
									l_err =1;
							}
						}
					}

				 if (strcmp(d_inp_reimbursable_ind.arr,"P")==0) 
				 {
				   if (d_inp_reimbursable_amt.arr<=0 || !strlen(d_inp_reimbursable_amt.arr))
				 {
				 	                strcat(nd_msg10.arr,"Amount cannot be less than 0 or Null for Inpatient/Daycare Reimbursable where Reimbursable Indicator is P for the Facility: ");
									strcat(nd_msg10.arr,nd_operating_facility.arr);
									strcat(nd_msg10.arr,", Item: ");
									strcat(nd_msg10.arr,d_item_code.arr);
									disp_message(ERR_MESG,nd_msg10.arr);
									strcpy(nd_msg10.arr,"");
									l_err =1;
				}
				}
			      if (strcmp(d_inp_override_reimbursable_yn.arr,"Y")!=0)
				   {
				     if (strcmp(d_inp_override_reimbursable_yn.arr,"N")!=0)
					   {  
					      if (strlen(d_inp_override_reimbursable_yn.arr))
						   {
									strcat(nd_msg11.arr,"Invalid value for Inpatient/Daycare Override Reimbursable for the Facility: ");
									strcat(nd_msg11.arr,nd_operating_facility.arr);
									strcat(nd_msg11.arr,", Item: ");
									strcat(nd_msg11.arr,d_item_code.arr);
									disp_message(ERR_MESG,nd_msg11.arr);
									strcpy(nd_msg11.arr,"");
									l_err =1;
							}
						}
					}
					if (strcmp(d_oth_reimbursable_yn.arr,"Y")!=0)
				   {
				     if (strcmp(d_oth_reimbursable_yn.arr,"N")!=0)
					   {  
					      if (strlen(d_oth_reimbursable_yn.arr))
						   {
									strcat(nd_msg12.arr,"Invalid value for Outpatient Reimbursable for the Facility: ");
									strcat(nd_msg12.arr,nd_operating_facility.arr);
									strcat(nd_msg12.arr,", Item: ");
									strcat(nd_msg12.arr,d_item_code.arr);
									disp_message(ERR_MESG,nd_msg12.arr);
									strcpy(nd_msg12.arr,"");
									l_err =1;
							}
						}
					}
				//if (!strcmp(d_oth_reimbursable_ind.arr,"F"))
				   {
				     if (strcmp(d_oth_reimbursable_ind.arr,"P")!=0)
					   {  
					      if (strcmp(d_oth_reimbursable_ind.arr,"N")!=0)
						   {
									strcat(nd_msg13.arr,"Invalid value for Outpatient Reimbursable Indicator for the Facility: ");
									strcat(nd_msg13.arr,nd_operating_facility.arr);
									strcat(nd_msg13.arr,", Item: ");
									strcat(nd_msg13.arr,d_item_code.arr);
									strcat(nd_msg13.arr,", Eff. From Date: ");
									strcat(nd_msg13.arr,nd_fm_date.arr);
									disp_message(ERR_MESG,nd_msg13.arr);
									strcpy(nd_msg13.arr,"");
									l_err =1;
							}
						}
					}

				 if (strcmp(d_oth_reimbursable_ind.arr,"P")==0) 
				 {
				  if (d_oth_reimbursable_amt.arr<=0 || !strlen(d_oth_reimbursable_amt.arr))
				 {
				 	                strcat(nd_msg14.arr,"Amount cannot be less than 0 or Null for Outpatient Reimbursable where Reimbursable Indicator is P for the Facility: ");
									strcat(nd_msg14.arr,nd_operating_facility.arr);
									strcat(nd_msg14.arr,", Item: ");
									strcat(nd_msg14.arr,d_item_code.arr);
									strcat(nd_msg14.arr,", Eff. From Date: ");
									strcat(nd_msg14.arr,nd_fm_date.arr);
									disp_message(ERR_MESG,nd_msg14.arr);
									strcpy(nd_msg14.arr,"");
									l_err =1;
				}
				}
			      if (strcmp(d_oth_override_reimbursable_yn.arr,"Y")!=0)
				   {
				     if (strcmp(d_oth_override_reimbursable_yn.arr,"N")!=0)
					   {  
					      if (strlen(d_oth_override_reimbursable_yn.arr))
						   {
									strcat(nd_msg15.arr,"Invalid value for Outpatient Override Reimbursable for the Facility: ");
									strcat(nd_msg15.arr,nd_operating_facility.arr);
									strcat(nd_msg15.arr,", Item: ");
									strcat(nd_msg15.arr,d_item_code.arr);
									strcat(nd_msg15.arr,", Eff. From Date: ");
									strcat(nd_msg15.arr,nd_fm_date.arr);
									disp_message(ERR_MESG,nd_msg15.arr);
									strcpy(nd_msg15.arr,"");
									l_err =1;
							}
						}
					}


				}
				else
				{
				proc_exit();
				}
			 }
			 else 
			 {


				strcat(nd_msg8.arr,"Invalid Item");
				strcat(nd_msg8.arr,d_item_code.arr);
				strcat(nd_msg8.arr," Found in External Table");
 				disp_message(ERR_MESG,nd_msg8.arr);
				strcpy(nd_msg8.arr,"");
				l_err =1;
				//disp_message(ERR_MESG,"Invalid Item");
				//disp_message(ERR_MESG,d_item_code.arr);
				//disp_message(ERR_MESG,"Found in External Table");

		
			 }

				d_item_code.arr[d_item_code.len]				= '\0';
				d_public_price.arr[d_public_price.len]			= '\0';
				d_inpatient_price.arr[d_inpatient_price.len]	= '\0';
				d_outpatient_price.arr[d_outpatient_price.len]	= '\0';
				d_external_price.arr[d_external_price.len]		= '\0';
				d_emergency_price.arr[d_emergency_price.len]	= '\0';
				d_daycare_price.arr[d_daycare_price.len]		= '\0';
		}
		
	}
/*	if (l_err =1)
	{
	proc_exit();
	}*/
}


init_date_temp_var()
{

nd_temp_date.arr[0] =  '\0';
nd_loc_date.arr[0]  =  '\0';
date_convert.arr[0] =  '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;

}

fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date();

}

get_local_date()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY'),:nd_lang_id,t_date);

		 :nd_loc_date:= to_char(t_date,'DD/MM/YYYY');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY' ) , :nd_lang_id , t_date ) ;\
 :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )349;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
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
