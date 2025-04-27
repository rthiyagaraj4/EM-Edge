
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
           char  filnam[24];
};
static const struct sqlcxp sqlfpn =
{
    23,
    "d:\\test\\11g\\smtbgrep.pc"
};


static unsigned long sqlctx = 586690411;


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
            void  *sqhstv[10];
   unsigned int   sqhstl[10];
            int   sqhsts[10];
            void  *sqindv[10];
            int   sqinds[10];
   unsigned int   sqharm[10];
   unsigned int   *sqharc[10];
   unsigned short  sqadto[10];
   unsigned short  sqtdso[10];
} sqlstm = {10,10};

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

 static const char *sq0012 = 
"select operating_facility_id ,ws_no ,cmd_line_arg ,rowid ,UPPER(pgm_id) ,SUB\
STR(cmd_line_arg,(INSTR(cmd_line_arg,' ',1,1)+1),(INSTR(cmd_line_arg,' ',1,2)-\
INSTR(cmd_line_arg,' ',1,1))) uid_pwd  from SY_REPORT_GENERATE_REQUEST where (\
(((OPERATING_FACILITY_ID=DECODE(:b0,'*A',OPERATING_FACILITY_ID,:b0) and ((((((\
(:b2='*A' or (:b2='L' and ((pgm_id like 'RLR%' or pgm_id like 'BTR%') or pgm_i\
d like 'BDR%'))) or (:b2='M' and pgm_id like 'MP%')) or (:b2='*BD' and pgm_id \
like 'BDR%')) or (:b2='*RL' and pgm_id like 'RLR%')) or ((:b2='BD_U' and pgm_i\
d like 'BDRLBPRN') and NVL(INSTR(CMD_LINE_ARG,'BDRUNTLB',1),0)>0)) or ((:b2='B\
D_B' and pgm_id like 'BDRLBPRN') and NVL(INSTR(CMD_LINE_ARG,'BDRUNTLB',1),0)=0\
)) or (:b2='*BT' and pgm_id like 'BTR%'))) and UPPER(pgm_id) not  in (select p\
gm_id  from SY_PROG_ID )) and request_status is null ) and cmd_line_arg is  no\
t null ) order by request_date,print_seq_no            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,159,0,0,0,0,0,1,0,
20,0,0,2,76,0,4,182,0,0,1,0,0,1,0,2,9,0,0,
39,0,0,3,322,0,4,191,0,0,7,2,0,1,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,9,
0,0,1,9,0,0,
82,0,0,4,0,0,29,269,0,0,0,0,0,1,0,
97,0,0,5,0,0,27,300,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
128,0,0,6,181,0,3,319,0,0,5,5,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
163,0,0,7,0,0,29,327,0,0,0,0,0,1,0,
178,0,0,8,157,0,4,337,0,0,3,2,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,
205,0,0,9,287,0,3,346,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
236,0,0,10,175,0,5,368,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
263,0,0,11,0,0,29,377,0,0,0,0,0,1,0,
278,0,0,12,911,0,9,436,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
333,0,0,12,0,0,15,446,0,0,0,0,0,1,0,
348,0,0,13,1377,0,6,460,0,0,4,4,0,1,0,3,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
379,0,0,12,0,0,13,539,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,
418,0,0,14,56,0,2,580,0,0,1,1,0,1,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.6                                                  */
/************************************************************************/
/* PROGRAM NAME          : SMTBGREP                                     */
/* DESCRIPTION		     : Test Results report 							*/
/* AUTHOR                : S. Sheelvant                                 */
/* DATE WRITTEN          : 11-SEP-1998                                  */
/* MODIFIED BY           : C. DINESH 									*/
/* MODIFIED ON			 : 12-DEC-1998			 						*/
/* Modification History													*/
/* =====================================================================*/
/* Date			WhoDoneIt		Remarks									*/
/* =====================================================================*/
/* Jan 10,05	Sundar			While invokging spawnlp command,        */
/*								for RLRCOLBL, workstation id was added  */
/*								This  has been removed.					*/
/* Apr 25,06	Sai Dutt		Added validate_uid_pwd() To get pwd     */
/*								from sy_user if the user changes his    */
/*								pwd after submiting  the request.       */
/* Aug 07,08	pramodini		Validate_uid_pwd() moved inside while   */
/*								loop									*/
/* Sept 25 13   Srinivasarao V  Modified get_sleep_secs procedure       */		
/************************************************************************/

#include <stdio.h>   
#include <string.h>
#include <windows.h>       
#include <winuser.h>

#define NODATAFOUND				(sqlca.sqlcode == 1403)
#define OERROR 					(sqlca.sqlcode < 0)
#define LAST_ROW 				(sqlca.sqlcode == 1403)
#define NOT_FOUND 				(sqlca.sqlerrd[2] == 0)
#define TABLE_ALREADY_EXISTS	(sqlca.sqlcode == -955)
#define RESOURCE_BUSY			(sqlca.sqlcode == -54)

#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1
#define RESTART_INTERVAL 2
#define RESTART_TIME 500
#define INIT_MESG ""


/* EXEC SQL BEGIN DECLARE SECTION; */ 
    

   /* VARCHAR uid_pwd[132],
           d_curr_pgm_name                  [15],
		   nd_operating_facility_id			[3],
           nd_facility_id		 			[3],
           nd_file_name                     [151],
		   d_user_id_pwd					[50],
		   d_next_start_date				[30],
		   today							[20],
		   d_sleep_secs						[10],
		   d_cmd_line						[200],
		   d_machine_name				    [40],
		   d_started_by_id					[21],
		   prg_start_date					[30],
		   er_msg                           [71],
		   sy_user_id						[30],
           sy_session_id					[30],
           sy_req_date						[30],
		   sy_online_report_name			[10],
		   sy_ws_no							[30],
		   sy_rowid							[50],
		   sy_pgm_id						[50],
		   sy_cmd_line_arg				    [1000], //changed from 300 to 1000
		   sy_uid_pwd						[300], // 24.04.2006 Added by Sai Dutt
		   sy_error_msg 					[2000], // 24.04.2006 Added by Sai Dutt

		   BVServicedRequestID				[32]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[151]; } nd_file_name;

struct { unsigned short len; unsigned char arr[50]; } d_user_id_pwd;

struct { unsigned short len; unsigned char arr[30]; } d_next_start_date;

struct { unsigned short len; unsigned char arr[20]; } today;

struct { unsigned short len; unsigned char arr[10]; } d_sleep_secs;

struct { unsigned short len; unsigned char arr[200]; } d_cmd_line;

struct { unsigned short len; unsigned char arr[40]; } d_machine_name;

struct { unsigned short len; unsigned char arr[21]; } d_started_by_id;

struct { unsigned short len; unsigned char arr[30]; } prg_start_date;

struct { unsigned short len; unsigned char arr[71]; } er_msg;

struct { unsigned short len; unsigned char arr[30]; } sy_user_id;

struct { unsigned short len; unsigned char arr[30]; } sy_session_id;

struct { unsigned short len; unsigned char arr[30]; } sy_req_date;

struct { unsigned short len; unsigned char arr[10]; } sy_online_report_name;

struct { unsigned short len; unsigned char arr[30]; } sy_ws_no;

struct { unsigned short len; unsigned char arr[50]; } sy_rowid;

struct { unsigned short len; unsigned char arr[50]; } sy_pgm_id;

struct { unsigned short len; unsigned char arr[1000]; } sy_cmd_line_arg;

struct { unsigned short len; unsigned char arr[300]; } sy_uid_pwd;

struct { unsigned short len; unsigned char arr[2000]; } sy_error_msg;

struct { unsigned short len; unsigned char arr[32]; } BVServicedRequestID;
 



	int v_count = 0;


   int     no_of_dtl_recs = 0,
		   d_time_interval =0,
		   d_starting_time =0,
           er_msg_type = 0;

	int l_restart_time = 0;

/***** ADDED ON 05/11/2002 BACKGROUND PROCESS MONITOR **********/
	int p_count = 0;
/***** UPTO HERE ADDED ON 05/11/2002 BACKGROUND PROCESS MONITOR **********/

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





#include<winproc.h>

DWORD sleep_sec = 0;
DWORD thread1 = 0;
HANDLE hw1, hw2;
char string_var[500];
char g_pgm_id[10];
char prg_name [10];
char sep = " ";

int err_flag = 0;

int request_count = 0;
void proc_main(argc,argv)
char *argv[];
int argc;
{
     
   int rec_found = 0;

   if (argc < 5)
   {
      ins_message(ERR_MESG,"Usage : smtbgrep uid/password start_date");
      proc_exit();
   }

   strcpy(d_user_id_pwd.arr,argv[1]);

   strcpy(g_pgm_id,"SMTBGREP");
   strcpy(d_curr_pgm_name.arr,g_pgm_id); 
   d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

   strcpy(prg_start_date.arr,argv[3]);
   
   prg_start_date.len = strlen(argv[3]);

    strcpy(nd_facility_id.arr, argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);

	BVServicedRequestID.arr[0]	= '\0';
    BVServicedRequestID.len		= 0;

	strcpy(BVServicedRequestID.arr,argv[6]);
	BVServicedRequestID.len = strlen(BVServicedRequestID.arr);


   if(sql_connect(argv[1]) == -1)
   {
      ins_message(ORA_MESG,"Error in connecting to Oracle");
      proc_exit();
   }


   set_meduser_role();  


   rec_found = get_sleep_secs();

   if(rec_found)
   {

      process_rec();
   }


   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 0;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   if (OERROR)
     ins_message(ORA_MESG,"ROLLBACK WORK RELEASE failed");
   return;
}
/*------------------------------------------------------*/
get_sleep_secs()
{
    d_sleep_secs.arr[0] = '\0';
	d_machine_name.arr[0] = '\0';
	d_started_by_id.arr[0] = '\0';
	d_next_start_date.arr[0]='\0';

	d_sleep_secs.len		= 0;
	d_machine_name.len		= 0;
	d_started_by_id.len		= 0;
	d_next_start_date.len	= 0;

	_flushall();


/********* added on 28.06.2003 *************/

    /* EXEC SQL
     SELECT processing_interval
	   INTO :d_sleep_secs
	   FROM SY_PROG_ID
	  WHERE PGM_ID = 'SMTBGREP'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 1;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select processing_interval into :b0  from SY_PROG_ID wher\
e PGM_ID='SMTBGREP'";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )20;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_sleep_secs;
    sqlstm.sqhstl[0] = (unsigned int  )12;
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



/*************** upto here **************/


    /* EXEC SQL  SELECT	floor((sysdate-started_date)*24*60),
						machine_name,
						started_by_id,
						to_char(sysdate,'ddmmyyyyhh24miss'),
						to_number(to_char(sysdate,'hh24mi'))
				INTO	:d_time_interval,
						:d_machine_name,
						:d_started_by_id,
						:d_next_start_date,
						:d_starting_time
				FROM	SY_BG_PROCESS_CONTROL
				WHERE	OPERATING_FACILITY_ID = :nd_facility_id
				AND     PGM_ID = 'SMTBGREP'
				AND		STARTED_DATE IS NOT NULL
				AND		SERVICED_REQUESTS = :BVServicedRequestID; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select floor((((sysdate-started_date)* 24)* 60)) ,machine\
_name ,started_by_id ,to_char(sysdate,'ddmmyyyyhh24miss') ,to_number(to_char(s\
ysdate,'hh24mi')) into :b0,:b1,:b2,:b3,:b4  from SY_BG_PROCESS_CONTROL where (\
((OPERATING_FACILITY_ID=:b5 and PGM_ID='SMTBGREP') and STARTED_DATE is  not nu\
ll ) and SERVICED_REQUESTS=:b6)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )39;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_time_interval;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_machine_name;
    sqlstm.sqhstl[1] = (unsigned int  )42;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_started_by_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_next_start_date;
    sqlstm.sqhstl[3] = (unsigned int  )32;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_starting_time;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&BVServicedRequestID;
    sqlstm.sqhstl[6] = (unsigned int  )34;
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

 ///added on 25.09.2013 against issue reported by Siriraj.

////////// 28.06.2003 commented  	AND		STARTED_DATE = TO_DATE(:prg_start_date,	'DDMMYYHH24MISS');

    d_sleep_secs.arr[d_sleep_secs.len] = '\0';
	d_machine_name.arr[d_machine_name.len] = '\0';
	d_started_by_id.arr[d_started_by_id.len] = '\0';
	d_next_start_date.arr[d_next_start_date.len]='\0';

    

	if(NOT_FOUND) 
	{
		  return FALSE;
	}
	if (OERROR)
        ins_message(ORA_MESG,"Error Found in get_sleep_secs");
	else 
	{
		d_sleep_secs.arr[d_sleep_secs.len] = '\0';
        sleep_sec = (DWORD) atol(d_sleep_secs.arr);
	    return TRUE;
	}    
}
/*----------------------------------------------------------*/
process_rec()
{  
   int i = 0;
   int j = 0,corr_stat = 0;
   int sy_prg_param_found =0;
   int record_exist = 0;
   int termstat;

   char test[11],group_test[11];

   _flushall();

   request_count = 1;

   declare_curs();

  
   while (get_sleep_secs())
   { 
  
		insert_process_monitor();

	   _flushall();

		request_count = 1;         

		open_curs();

		while (fetch_curs())
		{
			/* validate_uid_pwd function moved here by pramodini on 07.08.08*/
			validate_uid_pwd();

			_spawnlp(_P_WAIT, sy_pgm_id.arr, sy_cmd_line_arg.arr, NULL);

			request_count++;
			
			delete_bg_rec();

			/* EXEC SQL COMMIT WORK; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )82;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (request_count > 11)
				break;

		   if(!get_sleep_secs())
				break;


		}
		close_curs();

		 _flushall();
  		  fflush(NULL);	 
		  fflush(stdin);

         if (sleep_sec)
             Sleep(sleep_sec);

			 
    }

}
/*------------------------------------------------------------*/

sql_connect(l_nd_ap_uid_pwd)
char l_nd_ap_uid_pwd[];
{
  strcpy(uid_pwd.arr,l_nd_ap_uid_pwd);
  uid_pwd.len = strlen(uid_pwd.arr);

  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )97;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )134;
  sqlstm.sqhsts[0] = (         int  )134;
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



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}
/*-----------------------------------------------------*/
ins_message(int msg_type,char msg[])
{
   er_msg.arr[0] = '\0';
   er_msg.len = 0;
   
   er_msg_type = 0;

   strcpy(er_msg.arr,msg);
   er_msg.len = strlen(msg);
 
   er_msg_type = msg_type;

   /* EXEC SQL INSERT INTO SY_PROG_MSG
          (OPERATING_FACILITY_ID,PGM_ID,MSG_TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE)
   VALUES 
          (:nd_operating_facility_id,'SMTBGREP',:er_msg_type,NULL,substr(:er_msg,1,70),SYSDATE,:sy_session_id,
		   :sy_req_date); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_MSG (OPERATING_FACILITY_ID,PGM_ID,MSG_\
TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) values (:b0,'SMTBGREP\
',:b1,null ,substr(:b2,1,70),SYSDATE,:b3,:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )128;
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
   sqlstm.sqhstv[1] = (         void  *)&er_msg_type;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&er_msg;
   sqlstm.sqhstl[2] = (unsigned int  )73;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&sy_session_id;
   sqlstm.sqhstl[3] = (unsigned int  )32;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&sy_req_date;
   sqlstm.sqhstl[4] = (unsigned int  )32;
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



   err_flag = 1;

   /* EXEC SQL COMMIT WORK; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )163;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}
/*------------------------------------------------------------*/
insert_process_monitor()
{
	
	p_count = 0;


	/* EXEC SQL SELECT COUNT(1)
			 INTO :p_count
			 FROM RL_ANALYZER_PROGRAMS_LOG
			 WHERE OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,
										:nd_facility_id)
			 AND   analyzer_name = 'SMTBGREP'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from RL_ANALYZER_PROGRAMS_LOG wher\
e (OPERATING_FACILITY_ID=DECODE(:b1,'*A',OPERATING_FACILITY_ID,:b1) and analyz\
er_name='SMTBGREP')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )178;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_count;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
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



	if (p_count == 0)
	{
		/* EXEC SQL INSERT INTO RL_ANALYZER_PROGRAMS_LOG
					(operating_facility_id,
					 analyzer_name, 
					 machine_name, 
					 last_run_at,
					 ADDED_AT_WS_NO, 
					 ADDED_FACILITY_ID, 
					 MODIFIED_AT_WS_NO,
					 MODIFIED_FACILITY_ID)
				 VALUES
					(:nd_facility_id,
				     'SMTBGREP', 
					 :d_machine_name, 
					 SYSDATE,
					 sys_context('USERENV','IP_ADDRESS'),
					 :nd_operating_facility_id,
					 sys_context('USERENV','IP_ADDRESS'),
					 :nd_operating_facility_id); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into RL_ANALYZER_PROGRAMS_LOG (operating_facility_id\
,analyzer_name,machine_name,last_run_at,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIF\
IED_AT_WS_NO,MODIFIED_FACILITY_ID) values (:b0,'SMTBGREP',:b1,SYSDATE,sys_cont\
ext('USERENV','IP_ADDRESS'),:b2,sys_context('USERENV','IP_ADDRESS'),:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )205;
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
  sqlstm.sqhstv[1] = (         void  *)&d_machine_name;
  sqlstm.sqhstl[1] = (unsigned int  )42;
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



	}
	else
	{
		/* EXEC SQL UPDATE RL_ANALYZER_PROGRAMS_LOG
				 SET last_run_at = SYSDATE,
						machine_name = :d_machine_name
				 WHERE OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,
																		:nd_facility_id)
				 AND   analyzer_name = 'SMTBGREP'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update RL_ANALYZER_PROGRAMS_LOG  set last_run_at=SYSDATE,ma\
chine_name=:b0 where (OPERATING_FACILITY_ID=DECODE(:b1,'*A',OPERATING_FACILITY\
_ID,:b1) and analyzer_name='SMTBGREP')";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )236;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_machine_name;
  sqlstm.sqhstl[0] = (unsigned int  )42;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
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

	

	}

	/* EXEC SQL COMMIT WORK; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )263;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
        ins_message(ORA_MESG,"Error Found in insert_process_monitor");

}
/*------------------------------------------------------------*/
declare_curs()
{
//disp_message(ERR_MESG,"in declare curs");

	/* EXEC SQL DECLARE bg_report_curs CURSOR FOR
///////28.06.2003			SELECT ws_no, cmd_line_arg, online_report_name, rowid
			SELECT operating_facility_id, ws_no, cmd_line_arg, rowid, UPPER(pgm_id),
			SUBSTR(cmd_line_arg, INSTR(cmd_line_arg,' ', 1, 1) + 1, INSTR(cmd_line_arg,' ', 1, 2) - INSTR(cmd_line_arg,' ', 1, 1)) uid_pwd
			FROM SY_REPORT_GENERATE_REQUEST
		    WHERE OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,
                          											:nd_facility_id)
			AND     (:BVServicedRequestID = '*A'
	        OR (:BVServicedRequestID = 'L' AND ( (pgm_id LIKE 'RLR%' ) 
						OR   (pgm_id LIKE 'BTR%' )
						OR   (pgm_id LIKE 'BDR%' ) )
		   )
			OR (:BVServicedRequestID = 'M' AND pgm_id LIKE 'MP%')
			OR (:BVServicedRequestID = '*BD' AND pgm_id LIKE 'BDR%')
			OR (:BVServicedRequestID = '*RL' AND pgm_id LIKE 'RLR%')
			OR (:BVServicedRequestID = 'BD_U' AND pgm_id LIKE 'BDRLBPRN' 
					AND NVL(INSTR(CMD_LINE_ARG,  'BDRUNTLB', 1), 0) > 0)
			OR (:BVServicedRequestID = 'BD_B' AND pgm_id LIKE 'BDRLBPRN' 
					AND NVL(INSTR(CMD_LINE_ARG,  'BDRUNTLB', 1), 0) = 0)
			OR (:BVServicedRequestID = '*BT' AND pgm_id LIKE 'BTR%')
			)
///	OR (:BVServicedRequestID = '*BT' AND pgm_id LIKE 'BTR%')
///// 30.06.2003		    AND pgm_id  IN ('RLRSPCLB','RLRCOLBL')
		    AND UPPER(pgm_id)  NOT IN (SELECT pgm_id  FROM SY_PROG_ID)
		    AND request_status IS NULL
		    AND cmd_line_arg IS NOT NULL		// Ravi Shankar, 19/08/2016, IN-61369
			ORDER BY request_date, print_seq_no; */ 
			// order by clause added on 04/03/2009
//			ORDER BY request_date;			//order by clause added on 16.10.08

	/********** 28.06.2003
			WHERE report_generate_date < SYSDATE
			ORDER BY added_date, priority_indicator;   
	************/  
		
	
	if (OERROR)
	{
        ins_message(ORA_MESG,"Error Found in declare_curs....>");

		sprintf(string_var,"Error Found in declare_curs %s",sqlca.sqlerrm.sqlerrmc);
        ///ins_message(ORA_MESG,"Error Found in declare_curs");
		ins_message(ORA_MESG,string_var);
	}
}
/*------------------------------------------------------------*/
open_curs()
{ 
	
	/* EXEC SQL OPEN bg_report_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0012;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )278;
 sqlstm.selerr = (unsigned short)1;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&BVServicedRequestID;
 sqlstm.sqhstl[2] = (unsigned int  )34;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&BVServicedRequestID;
 sqlstm.sqhstl[3] = (unsigned int  )34;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&BVServicedRequestID;
 sqlstm.sqhstl[4] = (unsigned int  )34;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&BVServicedRequestID;
 sqlstm.sqhstl[5] = (unsigned int  )34;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&BVServicedRequestID;
 sqlstm.sqhstl[6] = (unsigned int  )34;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&BVServicedRequestID;
 sqlstm.sqhstl[7] = (unsigned int  )34;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&BVServicedRequestID;
 sqlstm.sqhstl[8] = (unsigned int  )34;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&BVServicedRequestID;
 sqlstm.sqhstl[9] = (unsigned int  )34;
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
        ins_message(ORA_MESG,"Error Found in open_curs");

}
/*------------------------------------------------------------*/
close_curs()
{
	
	/* EXEC SQL CLOSE bg_report_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )333;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
        ins_message(ORA_MESG,"Error Found in close_curs");

}
/*------------------------------------------------------------*/
/*-- Start -- Added by Sai Dutt on 24.04.2006 to get pwd from from sy_user if the --
  ------------user changes his pwd after submiting the request.--*/
validate_uid_pwd()
{

  sy_error_msg.arr[0]			    = '\0';

  /* EXEC SQL EXECUTE 
  DECLARE
    lv_user_id               VARCHAR2(60);
    lv_password              VARCHAR2(500);
    lv_actual_password       VARCHAR2(500);
    lv_conn_string           VARCHAR2(500);
	lv_replace_sy_uid_pwd    VARCHAR2(2000);
	lv_sy_cmd_line_arg		 VARCHAR2(2000);
  BEGIN 
    lv_sy_cmd_line_arg := :sy_cmd_line_arg;
    IF INSTR(:sy_uid_pwd, '/', 1) > 0 AND INSTR(:sy_uid_pwd, '@', 1) > 0 THEN
      lv_user_id := SUBSTR(:sy_uid_pwd, 1, INSTR(:sy_uid_pwd, '/', 1) -1 );
      lv_password := SUBSTR(:sy_uid_pwd, INSTR(:sy_uid_pwd, '/', 1) + 1,  INSTR(:sy_uid_pwd, '@', 1) - INSTR(:sy_uid_pwd, '/', 1) - 1);
      lv_conn_string := SUBSTR(:sy_uid_pwd, INSTR(:sy_uid_pwd, '@', 1) + 1 );

      IF upper(lv_user_id) <> 'APPLUSER' THEN   
        SELECT App_Password.Decrypt(password)
        INTO   lv_actual_password
        FROM   sy_user
        WHERE  user_id = lv_user_id
        AND    facility_id = :nd_operating_facility_id;
	  
	    :sy_error_msg := '1';
        IF lv_password <> lv_actual_password THEN
          lv_replace_sy_uid_pwd := lv_user_id ||'/'|| lv_actual_password ||'@'|| lv_conn_string;
		
		  SELECT REPLACE(lv_sy_cmd_line_arg, :sy_uid_pwd, lv_replace_sy_uid_pwd)
		  INTO   :sy_cmd_line_arg
		  FROM   DUAL;

        END IF;
      END IF;
	END IF;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      :sy_error_msg := lv_user_id||'-'||:nd_operating_facility_id|| '- User Id does not exists in the User Setup';
    WHEN OTHERS THEN
      :sy_error_msg := 'Problem in User Master' ||SQLERRM;
  END; 
  END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "declare lv_user_id VARCHAR2 ( 60 ) ; lv_password VARCHAR2 ( 500 ) ; lv_\
actual_password VARCHAR2 ( 500 ) ; lv_conn_string VARCHAR2 ( 500 ) ; lv_repl\
ace_sy_uid_pwd VARCHAR2 ( 2000 ) ; lv_sy_cmd_line_arg VARCHAR2 ( 2000 ) ; BE\
GIN lv_sy_cmd_line_arg := :sy_cmd_line_arg ; IF INSTR ( :sy_uid_pwd , '/' , \
1 ) > 0 AND INSTR ( :sy_uid_pwd , '@' , 1 ) > 0 THEN lv_user_id := SUBSTR ( \
:sy_uid_pwd , 1 , INSTR ( :sy_uid_pwd , '/' , 1 ) -1 ) ; lv_password := SUBS\
TR ( :sy_uid_pwd , INSTR ( :sy_uid_pwd , '/' , 1 ) + 1 , INSTR ( :sy_uid_pwd\
 , '@' , 1 ) -INSTR ( :sy_uid_pwd , '/' , 1 ) -1 ) ; lv_conn_string := SUBST\
R ( :sy_uid_pwd , INSTR ( :sy_uid_pwd , '@' , 1 ) + 1 ) ; IF upper ( lv_user\
_id ) <> 'APPLUSER' THEN SELECT App_Password . Decrypt ( password ) INTO lv_\
actual_password FROM sy_user WHERE user_id = lv_user_id AND facility_id = :n\
d_operating_facility_id ; :sy_error_msg := '1' ; IF lv_password <> lv_actual\
_password THEN lv_replace_sy_uid_pwd := lv_user_id || '/' || lv_actual_passw\
ord || '@' || lv_conn_string ; SELECT REP");
  sqlstm.stmt = "LACE ( lv_sy_cmd_line_arg , :sy_uid_pwd , lv_replace_sy_uid\
_pwd ) INTO :sy_cmd_line_arg FROM DUAL ; END IF ; END IF ; END IF ; EXCEPTION \
WHEN NO_DATA_FOUND THEN :sy_error_msg := lv_user_id || '-' || :nd_operating_fa\
cility_id || '- User Id does not exists in the User Setup' ; WHEN OTHERS THEN \
:sy_error_msg := 'Problem in User Master' || SQLERRM ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )348;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&sy_cmd_line_arg;
  sqlstm.sqhstl[0] = (unsigned int  )1002;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&sy_uid_pwd;
  sqlstm.sqhstl[1] = (unsigned int  )302;
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
  sqlstm.sqhstv[3] = (         void  *)&sy_error_msg;
  sqlstm.sqhstl[3] = (unsigned int  )2002;
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
         ins_message(ORA_MESG,"User Id doesnot exists in User Setup or Ora Error");

  sy_uid_pwd.arr[sy_uid_pwd.len]					   = '\0'; 
  sy_error_msg.arr[sy_error_msg.len]				   = '\0'; 
  sy_cmd_line_arg.arr[sy_cmd_line_arg.len]			   = '\0'; 
  if (strlen(sy_error_msg.arr) > 1 )
  {
    ins_message(ORA_MESG, sy_error_msg.arr);
  }

}
/*-- Start -- Added by Sai Dutt on 24.04.2006 to get pwd from from sy_user if the --
  ------------user changes his pwd after submiting the request.--*/

/*------------------------------------------------------------*/
fetch_curs()
{
	
////// 28.06.2003 commented	sy_online_report_name.arr[0] 		= '\0';
	nd_operating_facility_id.arr[0] 	= '\0';  //// 28.06.2003 added
	sy_cmd_line_arg.arr[0]			    = '\0';
	sy_ws_no.arr[0]						= '\0';
	sy_rowid.arr[0]						= '\0';
	sy_pgm_id.arr[0]					= '\0';
	sy_uid_pwd.arr[0]					= '\0'; // 24.04.2006 Added by Sai Dutt

/////  28.06.2003 	sy_online_report_name.len			= 0;
	nd_operating_facility_id.len		= 0;
	sy_cmd_line_arg.len					= 0;
	sy_ws_no.len						= 0;
	sy_rowid.len						= 0;
	sy_pgm_id.len						= 0;
	sy_uid_pwd.len						= 0; // 24.04.2006 Added by Sai Dutt



	/* EXEC SQL FETCH bg_report_curs INTO	
				:nd_operating_facility_id, 		
				:sy_ws_no, 
                :sy_cmd_line_arg,
				:sy_rowid,
				:sy_pgm_id,
				:sy_uid_pwd; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )379;
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
 sqlstm.sqhstv[1] = (         void  *)&sy_ws_no;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&sy_cmd_line_arg;
 sqlstm.sqhstl[2] = (unsigned int  )1002;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&sy_rowid;
 sqlstm.sqhstl[3] = (unsigned int  )52;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&sy_pgm_id;
 sqlstm.sqhstl[4] = (unsigned int  )52;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&sy_uid_pwd;
 sqlstm.sqhstl[5] = (unsigned int  )302;
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


			

      if(OERROR)
         ins_message(ORA_MESG,"Select failed on table SY_REPORT_GENERATE_REQUEST");

////// 28.06.2003      sy_online_report_name.arr[sy_online_report_name.len] = '\0';

      nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
      sy_cmd_line_arg.arr[sy_cmd_line_arg.len]			   = '\0';
	  sy_ws_no.arr[sy_ws_no.len]						   = '\0';
	  sy_rowid.arr[sy_rowid.len]						   = '\0';
	  sy_pgm_id.arr[sy_pgm_id.len]						   = '\0';
	  sy_uid_pwd.arr[sy_uid_pwd.len]					   = '\0'; // 24.04.2006 Added by Sai Dutt

	/* Commented by pramodini on 07.08.08 
	Issue:
		Currently fetch_curs() is executing the loop 11 times though there is no data or data is less than 12 records also. 

	Reason:
		validate_uid_pwd() is being called inside fetch_curs(); since fetch_curs() loop condition checks for LAST_ROW and 
	this was always getting value 1; this is because of validate_uid_pwd() has a select statment which will always return a row 
	(sqlca.sqlcode = 0); hence in turn it returns 1 for LAST_ROW .

	Resolution:
		validate_uid_pwd() function is commented in fetch_curs() and moved within the main loop.

	//validate_uid_pwd();                        */

    return (LAST_ROW?0:1);

}
/*------------------------------------------------------------*/
delete_bg_rec()
{
	/* EXEC SQL DELETE FROM SY_REPORT_GENERATE_REQUEST
			 WHERE rowid = :sy_rowid; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_REPORT_GENERATE_REQUEST  where rowid=:b0";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )418;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sy_rowid;
 sqlstm.sqhstl[0] = (unsigned int  )52;
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



      if(OERROR)
         ins_message(ORA_MESG,"delete failed on table SY_REPORT_GENERATE_REQUEST");

}
/*------------------------------------------------------------*/
