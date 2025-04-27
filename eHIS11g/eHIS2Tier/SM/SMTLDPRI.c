
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
           char  filnam[36];
};
static const struct sqlcxp sqlfpn =
{
    35,
    "D:\\Curr_FormObj\\SM-proc\\SMTLDPRI.pc"
};


static unsigned int sqlctx = 1818424323;


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
            void  *sqhstv[4];
   unsigned int   sqhstl[4];
            int   sqhsts[4];
            void  *sqindv[4];
            int   sqinds[4];
   unsigned int   sqharm[4];
   unsigned int   *sqharc[4];
   unsigned short  sqadto[4];
   unsigned short  sqtdso[4];
} sqlstm = {12,4};

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

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,871,0,0,
5,0,0,0,0,0,27,205,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,245,0,0,0,0,0,1,0,
51,0,0,3,75,0,2,273,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
74,0,0,4,108,0,3,704,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


/*****************************************************************************************
*
*	Name			SMTLDPRI.PC
*
*	Author			K S Sundar
*
*	Purpose			To load the printers information into
*					SY_PRINT_DRIVERS table.
*
*   ===============================================================
*	Input Parameters							Mandatory/Optional
*   ===============================================================
*	1. DB Connect String (User/Password@DBName)	M
*	2. Workstation Id							M
*	3. SessionID								M
*	4. DateTime	 								M
*	5. Printer Type								M
*      (Local/Shared/Installed/Remote/All)
*	   Note: Installed = Local + Shared
*
*	Agrument separator is space
*
*   ====================
*	Modification History  
*   ===============================================================
*	Date		Person		Remarks
*   ===============================================================
*	Sep 19,2002	K S Sundar	Created.
*
*	Apr 24,2003	K S Sundar	1. Debug.H and DebugProc.H removed
*							2. Debug.C added
*							3. New Debug.H added
*							4. Calls related to debug renamed as Trace
*							5. Reference to WORKING_DIR removed as it is not being used.
*
*	Apr 26,2003	K S Sundar	1. get_output_directory procedure is removed as
*							   no log file is getting created.
*
*	Oct 7,2003	K S Sundar	1. FileStat values spooled to tracing log.
*							2. Printer Driver is not required anymore.
*							   Hence, all the references to prniter driver is removed.
*****************************************************************************************/

# include <windows.h>
# include <winspool.h>
# include <malloc.h>
# include <assert.h>
# include <stdio.h>
# include <stdlib.h>
# include <conio.h>
#include <ctype.h>
#include <time.h>
#include <sys/types.h>
#include <sys/stat.h>
# include <debug.h>

# if defined (WIN32)
	#define IS_WIN32 TRUE
# else
	#define IS_WIN32 FALSE
# endif

# define IS_NT		IS_WIN32 && (BOOL) (GetVersion() < 0x80000000)
# define IS_WIN32S	IS_WIN32 && (BOOL) (!(IS_NT) && (LOBYTE(LOWORD(GetVersion())) < 4 ))
# define IS_WIN95	(BOOL) (!(IS_NT) && !(IS_WIN32S)) && IS_WIN32


/* EXEC SQL BEGIN DECLARE SECTION; */ 

	/* varchar  bv_uid_pwd[132]; */ 
struct { unsigned short len; unsigned char arr[132]; } bv_uid_pwd;

	/* varchar  bv_session_id[20]; */ 
struct { unsigned short len; unsigned char arr[20]; } bv_session_id;

	/* varchar  bv_session_datetime[15]; */ 
struct { unsigned short len; unsigned char arr[15]; } bv_session_datetime;

	/* varchar  bv_printer_type[4]; */ 
struct { unsigned short len; unsigned char arr[4]; } bv_printer_type;


	/* varchar  bv_printer_name[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } bv_printer_name;

	/* varchar  bv_routed_printer_name[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } bv_routed_printer_name;

	/* varchar  bv_routed_queue_name[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } bv_routed_queue_name;

	/* varchar  bv_port_name[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } bv_port_name;


	/* varchar  l_workstation_id[31],
		   l_user_id[31],
		   l_error_text[501]; */ 
struct { unsigned short len; unsigned char arr[31]; } l_workstation_id;

struct { unsigned short len; unsigned char arr[31]; } l_user_id;

struct { unsigned short len; unsigned char arr[501]; } l_error_text;


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





/*
*	global decalrations;
*/

DWORD				gv_dwSizeNeeded;		// Used in EnumPrinters().
DWORD				gv_dwNumItems;			// Used in EnumPrinters().
DWORD				gv_dwItem;				// Used in EnumPrinters().
LPPRINTER_INFO_2	gv_lpInfo_2 = NULL;		// Used in EnumPrinters().


int  LoadPrintersInfo(void);			// Load printers info
int  LoadLocalPrintersInfo(void);	// Load local printers info
int  LoadSharedPrintersInfo(void);	// Load shared printers info
int  LoadRemotePrintersInfo(void);	// Load remote printers info
int  LoadIntoMEDICOM(void);					// Load into MEDICOM

/*
* WinMain
*/
int WINAPI WinMain(HINSTANCE  hInstance,HINSTANCE  hPrevInstance,LPSTR  lpCmdLine, int  nShowCmd)
{
	/*
	* Declare local variables.
	*/
	char LVFunctionName[64];
	char sep[3]=" ";
	char *lv_uid_pwd, *lv_session_id, *lv_session_datetime, *lv_printer_type;
	char *lv_ws_no;

	int  v_ret_flag;

	char tmpbuf[500];
	struct _stat LVFileStat;
	int LVResult;
	char *LVStrBuf;


	/*
	* Initialize variables.
	*/
	bv_uid_pwd.arr[0] = '\0';
	bv_uid_pwd.len =0;
	bv_session_id.arr[0] = '\0';
	bv_session_id.len =0;
	bv_session_datetime.arr[0] = '\0';
	bv_session_datetime.len =0;
	bv_printer_type.arr[0] = '\0';
	bv_printer_type.len =0;

	/*
	* Read command line parameters.
	*/
	lv_uid_pwd=strtok(lpCmdLine,sep);
	lv_ws_no=strtok(NULL,sep);
	lv_session_id=strtok(NULL,sep);
	lv_session_datetime=strtok(NULL,sep);
	lv_printer_type=strtok(NULL,sep);

	if (lv_uid_pwd == NULL || lv_ws_no==NULL || lv_session_id==NULL || lv_session_datetime==NULL || lv_printer_type==NULL)
	{
		MessageBox(NULL,"Usage filename uid/pwd sessionid datetime printer_type","MEDICOM: Loading Printer Information",MB_OK );
		exit(0);
	}

	strcpy(bv_uid_pwd.arr,lv_uid_pwd);
	bv_uid_pwd.len = strlen(bv_uid_pwd.arr);

	strcpy(l_workstation_id.arr,lv_ws_no);
	l_workstation_id.len = strlen(l_workstation_id.arr);
	l_workstation_id.arr[l_workstation_id.len]='\0';

	strcpy(bv_session_id.arr,lv_session_id);
	bv_session_id.len = strlen(bv_session_id.arr);
	strcpy(bv_session_datetime.arr,lv_session_datetime);
	bv_session_datetime.len = strlen(bv_session_datetime.arr);
	strcpy(bv_printer_type.arr,lv_printer_type);
	bv_printer_type.len = strlen(bv_printer_type.arr);

	if	(
			(strcmp(bv_printer_type.arr,"L") != 0) &&	// Local Printers
			(strcmp(bv_printer_type.arr,"S") != 0) &&	// Shared Printers
			(strcmp(bv_printer_type.arr,"I") != 0) &&	// Installed (Local + Shared) Printers
			(strcmp(bv_printer_type.arr,"R") != 0) &&	// Remote Printers
			(strcmp(bv_printer_type.arr,"A") != 0)		// All Printers
		)
	{
		MessageBox(NULL,"Invalid printer type. Valid values are (L)ocal (S)hared (R)emote and (A)ll","MEDICOM: Loading Printer Information",MB_OK | MB_ICONINFORMATION);
		exit(0);

	}

	/*
	* Create Window
	*/
	wndclass.style			= CS_HREDRAW | CS_VREDRAW;
	wndclass.lpfnWndProc    = NULL;
	wndclass.cbClsExtra		= 0;
	wndclass.cbWndExtra		= 0;
	wndclass.hInstance		= hInstance;
	wndclass.hIcon			= LoadIcon ( NULL, IDI_APPLICATION );
	wndclass.hCursor		= LoadCursor ( NULL, IDC_ARROW);
	wndclass.hbrBackground	= GetStockObject (WHITE_BRUSH);
	wndclass.lpszMenuName	= NULL;
	wndclass.lpszClassName	= "Drivers";
	RegisterClass ( &wndclass );

	hwnd = CreateWindow("Read Printer Details",(LPSTR)NULL,
                         WS_POPUP | WS_DLGFRAME,170,190,300,100,
                         (HWND)NULL,(HMENU)NULL,(HANDLE)hInstance,
						 (LPSTR) lpCmdLine);


	strcpy(GVProgramID, "SMTLDPRI");	

	/*
	* Connect to database
	*/
	/* EXEC SQL CONNECT :bv_uid_pwd; */ 

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
 sqlstm.sqhstv[0] = (         void  *)&bv_uid_pwd;
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
 sqlstm.sqlcmax = (unsigned int )100;
 sqlstm.sqlcmin = (unsigned int )2;
 sqlstm.sqlcincr = (unsigned int )1;
 sqlstm.sqlctimeout = (unsigned int )0;
 sqlstm.sqlcnowait = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if(OERROR)
	{
		MessageBox(hwnd,"Unable to connect to oracle.","Error",MB_OK|MB_ICONSTOP);
		exit(0);
	}

	/*
	* Enable or disable tracing.
	*/
	EnableOrDisableTracing();

	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "WinMain");
		Trace(LVFunctionName,"Begin");

		LVResult = _stat(_pgmptr, &LVFileStat);
		if (LVResult == 0)
		{	
			LVStrBuf = strtok(ctime( &LVFileStat.st_mtime ),"\n");	
			sprintf(GVTraceMsg,"File Name=[%Fs]  TimeStamp=[%s]  Size=[%ld Bytes]", _pgmptr, LVStrBuf , LVFileStat.st_size );
			Trace(LVFunctionName,GVTraceMsg);
		}


		sprintf(GVTraceMsg,"uid_pwd=[%s]    sessionid=[%s]    datetime=[%s]    printertype=[%s]",bv_uid_pwd.arr, bv_session_id.arr, bv_session_datetime.arr, bv_printer_type.arr);
		Trace(LVFunctionName,GVTraceMsg);
	}

	/*	
	* Following code for setting meduser role is added by C. Ganesan on 26/10/2002 at 19:00
	*
	*/
	set_meduser_role();

	v_ret_flag = LoadPrintersInfo();			
	if (v_ret_flag)
	{	
		if (IS_TRACING) Trace(LVFunctionName,"End");
		/* EXEC SQL COMMIT WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}

	/*
	* Terminate the program
	*/

	return 1;
} /* Winmain */


/*
* Function		LoadPrintersInfo
* Author		K S Sundar
* Purpose		To load printer information
*/
int LoadPrintersInfo()
{
	char LVFunctionName[64];

	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "LoadPrintersInfo()");
		Trace(LVFunctionName,"Begin");
	}
	
	/* Delete records from SY_PRINT_DRVIERS, if any. */
	if (IS_TRACING) Trace(LVFunctionName,"Delete from SY_PRINT_DRIVERS");
	/* EXEC SQL
	DELETE sy_print_drivers
	WHERE  session_id = :bv_session_id
	AND    add_date_time = :bv_session_datetime; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from sy_print_drivers  where (session_id=:b0 and ad\
d_date_time=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bv_session_id;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bv_session_datetime;
 sqlstm.sqhstl[1] = (unsigned int  )17;
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
	{
		sprintf(GVTraceMsg,"Delete from SY_PRINT_DRVIERS failed. : %s",sqlca.sqlerrm.sqlerrmc);
		if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
		return 0;
	}

	if (strcmp(bv_printer_type.arr,"L") == 0)
	{
		LoadLocalPrintersInfo();
	}
	else if (strcmp(bv_printer_type.arr,"S") == 0)
	{
		LoadSharedPrintersInfo();
	}
	else if (strcmp(bv_printer_type.arr,"I") == 0)
	{
		LoadLocalPrintersInfo();
		LoadSharedPrintersInfo();
	}
	else if (strcmp(bv_printer_type.arr,"R") == 0)
	{
		LoadRemotePrintersInfo();
	}
	else
	{
		LoadLocalPrintersInfo();
		LoadSharedPrintersInfo();
		LoadRemotePrintersInfo();
	}

	if (IS_TRACING) Trace(LVFunctionName,"End");

	return 1;

} //LoadPrintersInfo


/*
* Function		LoadLocalPrintersInfo
* Author		K S Sundar
* Purpose		To check or load local printers information
*/
int LoadLocalPrintersInfo()
{
	char LVFunctionName[64];

	/*
	*  Spool debug log
	*/
	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "LoadLocalPrintersInfo()");
		Trace(LVFunctionName,"Begin");
	}

	/* Get buffer size */
	if (IS_TRACING) Trace(LVFunctionName,"Get buffer size");
	EnumPrinters 
	( 
		PRINTER_ENUM_LOCAL, 
		NULL, 
		2, 
		NULL, 
		0, 
		&gv_dwSizeNeeded, 
		&gv_dwNumItems 
	);

	/* Allocate memory */
	if (IS_TRACING) Trace(LVFunctionName,"Allocate memory ");
	gv_lpInfo_2 = (LPPRINTER_INFO_2)HeapAlloc ( GetProcessHeap (), HEAP_ZERO_MEMORY, gv_dwSizeNeeded );
	if ( gv_lpInfo_2 == NULL )
	{
		if (IS_TRACING) Trace(LVFunctionName,"Not Enough Memory");
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
		
	}


	/* Enumerate printers */
	if (IS_TRACING) Trace(LVFunctionName,"Enumerate printers ");
	if (EnumPrinters 
		( 
			PRINTER_ENUM_LOCAL,		// what to enumerate
			NULL,					// printer name (NULL for all)
			2,						// level
			(LPBYTE)gv_lpInfo_2,			// buffer
			gv_dwSizeNeeded,			// size of buffer
			&gv_dwSizeNeeded,			// returns size
			&gv_dwNumItems				// return num. items
		) == 0 
	   )
	{
		GetLastErrorMessage();
		sprintf (GVTraceMsg, "EnumPrinters() Failed with error: %s", GVLastErrorMessage);
		if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
	}

	/* Check or Load printers information */
	if (IS_TRACING) Trace(LVFunctionName,"Load printers information");
	for ( gv_dwItem = 0; gv_dwItem < gv_dwNumItems; gv_dwItem++ )
	{
		if (IS_TRACING) 
		{
			sprintf(GVTraceMsg,"PrinterName=[%s] Serverame=[%s] PortName=[%s] ShareName=[%s] Location=[%s]", 
				gv_lpInfo_2[gv_dwItem].pPrinterName, gv_lpInfo_2[gv_dwItem].pServerName, gv_lpInfo_2[gv_dwItem].pPortName, gv_lpInfo_2[gv_dwItem].pShareName, gv_lpInfo_2[gv_dwItem].pLocation);
			Trace(LVFunctionName,GVTraceMsg);
		}

		bv_printer_name.arr[0] = '\0';
		bv_printer_name.len =0;
		bv_port_name.arr[0] = '\0';
		bv_port_name.len =0;

		strcpy(bv_printer_name.arr,gv_lpInfo_2[gv_dwItem].pPrinterName);
		bv_printer_name.len = strlen(bv_printer_name.arr);
		strcpy(bv_port_name.arr,gv_lpInfo_2[gv_dwItem].pPortName);
		bv_port_name.len = strlen(bv_port_name.arr);

	
		if (!LoadIntoMEDICOM())
		{
			if (IS_TRACING) Trace(LVFunctionName,"End");
			return 0;
		}

	}

	/* Free memory */
	HeapFree ( GetProcessHeap (), 0, gv_lpInfo_2 );

	
	if (IS_TRACING) Trace(LVFunctionName,"End");
	return 1;
} //LoadLocalPrintersInfo


/*
* Function		LoadSharedPrintersInfo
* Author		K S Sundar
* Purpose		To load shared printers information
*/
int LoadSharedPrintersInfo()
{
	char LVFunctionName[64];
	char *lv_tmpstr;
	char tmpbuf[500];

	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "LoadSharedPrintersInfo()");
		Trace(LVFunctionName,"Begin");
	}

	/* Get buffer size */
	if (IS_TRACING) Trace(LVFunctionName,"get buffer size");
	EnumPrinters 
	( 
		PRINTER_ENUM_CONNECTIONS, 
		NULL, 
		2, 
		NULL, 
		0, 
		&gv_dwSizeNeeded, 
		&gv_dwNumItems 
	);

	/* Allocate memory */
	if (IS_TRACING) Trace(LVFunctionName,"Allocate memory ");
	gv_lpInfo_2 = (LPPRINTER_INFO_2)HeapAlloc ( GetProcessHeap (), HEAP_ZERO_MEMORY, gv_dwSizeNeeded );
	if ( gv_lpInfo_2 == NULL )
	{
		if (IS_TRACING) Trace(LVFunctionName,"Not Enough Memory");
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
		
	}

	/* Enumerate printers */
	if (IS_TRACING) Trace(LVFunctionName,"Enumerate printers ");
	if (EnumPrinters 
		( 
			PRINTER_ENUM_CONNECTIONS,		// what to enumerate
			NULL,					// printer name (NULL for all)
			2,						// level
			(LPBYTE)gv_lpInfo_2,			// buffer
			gv_dwSizeNeeded,			// size of buffer
			&gv_dwSizeNeeded,			// returns size
			&gv_dwNumItems				// return num. items
		) == 0 
	   )
	{
		GetLastErrorMessage();
		sprintf (GVTraceMsg, "EnumPrinters() Failed with error: %s", GVLastErrorMessage);
		if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
	}

	/* Load printers information */
	if (IS_TRACING) Trace(LVFunctionName,"Load printers information");
	for ( gv_dwItem = 0; gv_dwItem < gv_dwNumItems; gv_dwItem++ )
	{
		if (IS_TRACING) 
		{
			sprintf(GVTraceMsg,"PrinterName=[%s] Serverame=[%s] PortName=[%s] ShareName=[%s] Location=[%s]", 
			gv_lpInfo_2[gv_dwItem].pPrinterName, gv_lpInfo_2[gv_dwItem].pServerName, gv_lpInfo_2[gv_dwItem].pPortName, gv_lpInfo_2[gv_dwItem].pShareName, gv_lpInfo_2[gv_dwItem].pLocation);
			Trace(LVFunctionName,GVTraceMsg);
		}

		bv_printer_name.arr[0] = '\0';
		bv_printer_name.len =0;
		bv_port_name.arr[0] = '\0';
		bv_port_name.len =0;

		//strcpy(bv_printer_name.arr,gv_lpInfo_2[gv_dwItem].pShareName ||' on '|| strstr(gv_lpInfo_2[gv_dwItem].pServerName ,3,strlen(gv_lpInfo_2[gv_dwItem].pServerName)-2));
		

/*
		sprintf (tmpbuf, "Printer Name: %s", gv_lpInfo_2[gv_dwItem].pPrinterName);
   		MessageBox ( hwnd, tmpbuf, "Error", MB_OK|MB_ICONSTOP);
*/

		
		if ( strncmp (gv_lpInfo_2[gv_dwItem].pPortName, "LPT", 3) ) 
		{
			strcpy(bv_port_name.arr,gv_lpInfo_2[gv_dwItem].pPrinterName);
			bv_port_name.len = strlen(bv_port_name.arr);
		}
		else
		{
			/*
			 * Check whether the printer is shared printer or local printer
			 * by checking the servername
			 *
			 */

			if ( gv_lpInfo_2[gv_dwItem].pServerName == NULL )
			{
				strcpy(bv_port_name.arr,gv_lpInfo_2[gv_dwItem].pPortName);
				bv_port_name.len = strlen(bv_port_name.arr);
			}
			else
			{
				strcpy(bv_port_name.arr,gv_lpInfo_2[gv_dwItem].pServerName);
				strcat(bv_port_name.arr,"\\");
				strcat(bv_port_name.arr,gv_lpInfo_2[gv_dwItem].pShareName);
				bv_port_name.len = strlen(bv_port_name.arr);
			}

		}

		/*
		* K S Sundar on Oct 7, 2003
		* Printer name is always Driver name On Server Name.
		*/
		lv_tmpstr=strtok(gv_lpInfo_2[gv_dwItem].pPrinterName,"\\");
		sprintf(GVTraceMsg, "%s on %s",gv_lpInfo_2[gv_dwItem].pDriverName , lv_tmpstr);
		strcpy(bv_printer_name.arr,GVTraceMsg);
		bv_printer_name.len = strlen(bv_printer_name.arr);


		if (!LoadIntoMEDICOM())
		{
			if (IS_TRACING) Trace(LVFunctionName,"End");
			return 0;
		}

	}


	/* Free memory */
	HeapFree ( GetProcessHeap (), 0, gv_lpInfo_2 );
	

	
	if (IS_TRACING) Trace(LVFunctionName,"End");
	return 1;
} //LoadSharedPrintersInfo


/*
* Function		LoadRemotePrintersInfo
* Author		K S Sundar
* Purpose		To load remote printers information
*/
int LoadRemotePrintersInfo()
{
	LPPRINTER_INFO_1	lpInfo_1 = NULL;		// Used in EnumPrinters().
	char LVFunctionName[64];
	char v_sep[3] = ",";
	char *v_printer_description;
	char *v_driver_name;

	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "LoadRemotePrintersInfo()");
		Trace(LVFunctionName,"Begin");
	}


	/* Get buffer size */
	if (IS_TRACING) Trace(LVFunctionName,"get buffer size");
	EnumPrinters 
	( 
		PRINTER_ENUM_REMOTE, 
		//PRINTER_ENUM_NETWORK, 
		NULL, 
		1, 
		NULL, 
		0, 
		&gv_dwSizeNeeded, 
		&gv_dwNumItems 
	);

	/* Allocate memory */
	if (IS_TRACING) Trace(LVFunctionName,"Allocate memory ");
	lpInfo_1 = (LPPRINTER_INFO_1)HeapAlloc ( GetProcessHeap (), HEAP_ZERO_MEMORY, gv_dwSizeNeeded );
	if ( lpInfo_1 == NULL )
	{
		if (IS_TRACING) Trace(LVFunctionName,"Not enough memory");
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
		
	}

	/* Enumerate printers */
	if (IS_TRACING) Trace(LVFunctionName,"Enumerate printers ");
	if (EnumPrinters 
		( 
			PRINTER_ENUM_REMOTE,		// what to enumerate
			//PRINTER_ENUM_NETWORK, 
			NULL,					// printer name (NULL for all)
			1,						// level
			(LPBYTE)lpInfo_1,			// buffer
			gv_dwSizeNeeded,			// size of buffer
			&gv_dwSizeNeeded,			// returns size
			&gv_dwNumItems				// return num. items
		) == 0 
	   )
	{
		GetLastErrorMessage();
		sprintf (GVTraceMsg, "EnumPrinters() Failed with error: %s", GVLastErrorMessage);
		if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
	}

	/* Load printers information */
	if (IS_TRACING) Trace(LVFunctionName,"Load printers information");
	for ( gv_dwItem = 0; gv_dwItem < gv_dwNumItems; gv_dwItem++ )
	{
		v_printer_description = strtok(lpInfo_1[gv_dwItem].pDescription,v_sep);
		v_driver_name = strtok(NULL,v_sep);

		if (IS_TRACING) 
		{
			sprintf(GVTraceMsg,"pName=[%s]    pDescription=[%s]    DriverName=[%s]    Comment=[%s]", 
				lpInfo_1[gv_dwItem].pName, lpInfo_1[gv_dwItem].pDescription, v_driver_name, lpInfo_1[gv_dwItem].pComment);
			Trace(LVFunctionName,GVTraceMsg);
		}

		/* Load into MEDICOM only if driver name is not null */
		if (v_driver_name != NULL)
		{
			bv_printer_name.arr[0] = '\0';
			bv_printer_name.len =0;
			bv_port_name.arr[0] = '\0';
			bv_port_name.len =0;


			//strcpy(lv_tmpstr,lpInfo_1[gv_dwItem].pName);
			//lv_tmpstr=strtok(lv_tmpstr.pName,"\\");
			//sprintf(GVTraceMsg, "%s on %s",lv_tmpstr, lv_tmpstr);
			//strcpy(bv_printer_name.arr,GVTraceMsg);
			strcpy(bv_printer_name.arr,lpInfo_1[gv_dwItem].pName);
			bv_printer_name.len = strlen(bv_printer_name.arr);
			
			if (!LoadIntoMEDICOM())
			{
				if (IS_TRACING) Trace(LVFunctionName,"End");
				return 0;
			}
		}

	}


	/* Free memory */
	HeapFree ( GetProcessHeap (), 0, lpInfo_1);
	


	if (IS_TRACING) Trace(LVFunctionName,"End");
	return 1;
} //LoadRemotePrintersInfo


/*
*
* Function  LoadIntoMEDICOM
* Author    K S Sundar
* Purpose   Loads printer information into MEDICOM.
*
*/
int LoadIntoMEDICOM()
{
	char LVFunctionName[64];

	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "LoadIntoMEDICOM()");
		Trace(LVFunctionName,"Begin");
	}

	/* Insert into SY_PRINT_DRIVERS */
	if (IS_TRACING) 
	{
		sprintf(GVTraceMsg, "bv_session_id=[%s] bv_session_datetime=[%s] bv_printer_name=[%s] bv_port_name=[%s]",
			bv_session_id.arr,bv_session_datetime.arr,bv_printer_name.arr,bv_port_name.arr);
		Trace(LVFunctionName,GVTraceMsg);
	}
	
	/* EXEC SQL 
	INSERT INTO SY_PRINT_DRIVERS
	(
		SESSION_ID, ADD_DATE_TIME,	PRINTER_NAME, DEST_PORT_NAME
	)
	VALUES
	( 
		:bv_session_id,:bv_session_datetime, :bv_printer_name,:bv_port_name
	); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into SY_PRINT_DRIVERS (SESSION_ID,ADD_DATE_TIME,PRIN\
TER_NAME,DEST_PORT_NAME) values (:b0,:b1,:b2,:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )74;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bv_session_id;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bv_session_datetime;
 sqlstm.sqhstl[1] = (unsigned int  )17;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bv_printer_name;
 sqlstm.sqhstl[2] = (unsigned int  )66;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bv_port_name;
 sqlstm.sqhstl[3] = (unsigned int  )66;
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
	{
		sprintf(GVTraceMsg,"Insert into SY_PRINT_DRVIERS failed. : %s",sqlca.sqlerrm.sqlerrmc);
		if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
	}

	if (IS_TRACING) Trace(LVFunctionName,"End");
	return 1;

} // LoadIntoMEDICOM


