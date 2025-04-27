
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
           char  filnam[29];
};
static const struct sqlcxp sqlfpn =
{
    28,
    "d:\\ehis\\smtckpri\\smtckpri.pc"
};


static unsigned long sqlctx = 1348776259;


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
            void  *sqhstv[4];
   unsigned int   sqhstl[4];
            int   sqhsts[4];
            void  *sqindv[4];
            int   sqinds[4];
   unsigned int   sqharm[4];
   unsigned int   *sqharc[4];
   unsigned short  sqadto[4];
   unsigned short  sqtdso[4];
} sqlstm = {10,4};

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

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,214,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,116,0,4,300,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
67,0,0,3,103,0,5,367,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
94,0,0,4,0,0,29,381,0,0,0,0,0,1,0,
109,0,0,5,103,0,5,408,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
136,0,0,6,0,0,29,422,0,0,0,0,0,1,0,
151,0,0,7,88,0,5,502,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
174,0,0,8,0,0,29,515,0,0,0,0,0,1,0,
};


/*******************************************************************************************
*  
*	Name			SMTCKPRI.PC
*
*	Author			K  S Sundar 
*
*	Purpose			Checks if the specified printer is valid 
*					or not.
*
*	Steps			Reads SY_PRINT_DRIVER table (Key SessionID , DateTime)
*
*					If record found,
*						Open the printer (SY_PRINTER_DRIVER.PRINTER_NAME)
*						If Success,
*							Update SY_PRINT_DRIVER.DEST_PORT_NAME = "Success"
*						Else
*							Update SY_PRINT_DRIVER.DEST_PORT_NAME = "Failure"
*							Register the error
*					Else
*						Register the error.
*					Return.
*
*   ===============================================================
*	Input Parameters							Mandatory/Optional
*   ===============================================================
*	1. DB Connect String (User/Password@DBName)	M
*	2. Workstation Id							M
*	3. SessionID								M
*	4. DateTime	 								M
*
*	Agrument separator is space
*
*   ====================
*	Modification History  
*   ===============================================================
*	Date		Person		Remarks
*   ===============================================================
*	Sep 28,2002	S Sundar	Created.
*
*	Apr 23,2003	S Sundar	1. Debug.H and DebugProc.H removed
*							2. Debug.C added
*							3. New Debug.H added
*							4. Calls related to debug renamed as Trace
*							5. Reference to WORKING_DIR removed as it is not being used.
*
*	Apr 26,2003	S Sundar	1. get_output_directory procedure is removed as
*							   no log file is getting created.
*
*	Jun 23,2003	Nanjayan	1. bv_error_text Data Length has been 
*							   increased from 64 to 501 as 
*							   SY_PRINT_DRIVERS.ERROR_TEXT is to be
*							   modified as VARCHAR2(500).
*							2. For Downward compatibility, SMRMDUSR.C
*							   has been changed. 
*							   Hence, new version is re-attached.
*
*	Oct 7, 2003	S Sundar	1. Printer driver is not required anymore.
*							   Hence, all the references to printer driver
*							   is removed.
*
*	Jun 2, 2004	S Sundar	1. When this program invoked by SMTPRDOC,
*							   fetching of SY_PRINT_DRIVERS.NUM_OF_PAGES
*							   by SMTPRDOC, sometimes, does not work good.
*							   That is, even if NUM_OF_PAGES is 1, sometimes,
*							   SMTPRDOC fetches 0. Hence, decided to check
*							   for return value instead of SY_PRINT_DRIVERS.NUM_OF_PAGES.
*
*	Sep 21,2005	S Sundar	1. set_meduser_role() is called after EnableOrDisableTracing().
*							   So tracing is not enabled at all yielding -942 Error
*								when reading sy_pgm_events_ctl table.
*								set_meduer_role() is moved before EnableOrDisableTracing().
*
*******************************************************************************************/


# include <windows.h>
# include <winspool.h>
# include <malloc.h>
# include <assert.h>
# include <stdio.h>
# include <stdlib.h>
# include <conio.h>
# include <string.h>
# include <time.h>
#include <time.h>
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

# define PRINTER_OK		1				// Printer Status 
# define PRINTER_NOT_OK 0				// Printer Status 

/* EXEC SQL BEGIN DECLARE SECTION; */ 

	/* varchar  bv_uid_pwd[132]; */ 
struct { unsigned short len; unsigned char arr[132]; } bv_uid_pwd;

	/* varchar  bv_session_id[20]; */ 
struct { unsigned short len; unsigned char arr[20]; } bv_session_id;

//	varchar  bv_session_datetime[15]; /***** Commented for the TIMESTAMP ISSUE in Billing *****/
	/* varchar  bv_session_datetime[50]; */ 
struct { unsigned short len; unsigned char arr[50]; } bv_session_datetime;


	/* varchar  bv_routed_printer_name[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } bv_routed_printer_name;

	/* varchar  bv_routed_port[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } bv_routed_port;

	/* varchar  bv_error_text[501]; */ 
struct { unsigned short len; unsigned char arr[501]; } bv_error_text;


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





/*
*	global decalrations;
*/

HANDLE	gv_hPrinter;					// Printer handle
void	ValidatePrinter();				// Validate the printer
BOOL	GetPrinterJobStatus(JOB_INFO_2 **ppJobInfo, int *pcJobs, DWORD *pStatus); 
int		GetPrinterStatus();				// Get the printer status.
int		IsPrinterValid;


/*
* WinMain
*/
int WINAPI WinMain(HINSTANCE  hInstance,HINSTANCE  hPrevInstance,LPSTR  lpCmdLine, int  nShowCmd)
{
	/*
	* Declare local variables.
	*/
	struct _stat LVFileStat;
	int LVResult;
	char *LVStrBuf;

	char LVFunctionName[64];
	char sep[3]=" ";
	char *lv_uid_pwd, *lv_session_id, *lv_session_datetime;
	char *lv_ws_no;
	int  lv_ret_flag;
	char tmpbuf[500];

	/*
	* Initialize variables.
	*/
	bv_uid_pwd.arr[0] = '\0';
	bv_uid_pwd.len =0;
	bv_session_id.arr[0] = '\0';
	bv_session_id.len =0;
	bv_session_datetime.arr[0] = '\0';
	bv_session_datetime.len =0;

	/*
	* Read command line parameters.
	*/
	lv_uid_pwd=strtok(lpCmdLine,sep);
	lv_ws_no=strtok(NULL,sep);
	lv_session_id=strtok(NULL,sep);
	lv_session_datetime=strtok(NULL,sep);

	if (lv_uid_pwd == NULL || lv_ws_no==NULL || lv_session_id==NULL || lv_session_datetime==NULL)
	{
		MessageBox(NULL,"Usage Connect_String Workstation_id sessionid datetime ","MEDICOM: Validating Printer",MB_OK );
		exit(1);
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

	
	strcpy(GVProgramID, "SMTCKPRI");	
	
	/*
	* Connect to database
	*/
	/* EXEC SQL CONNECT :bv_uid_pwd; */ 

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
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if(OERROR)
	{
		MessageBox(hwnd,"Unable to connect to oracle.","MEDICOM: Validating Printer",MB_OK|MB_ICONSTOP);
		exit(1);
	}


	/*	
	 * Following code for setting meduser role is added by C. Ganesan on 26/10/2002 at 19:00
	 * Following code was moved by S. Sundar on 21/09/2005 at 16:00
	 */
	set_meduser_role();


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
			LVStrBuf = strtok(ctime(&LVFileStat.st_mtime),"\n");	
			sprintf(GVTraceMsg,"File Name=[%Fs]  TimeStamp=[%s]  Size=[%ld Bytes]", _pgmptr, LVStrBuf , LVFileStat.st_size );
			Trace(LVFunctionName,GVTraceMsg);
		}

		sprintf(GVTraceMsg,"uid_pwd=[%s]    sessionid=[%s]    datetime=[%s]",bv_uid_pwd.arr, bv_session_id.arr, bv_session_datetime.arr);
		Trace(LVFunctionName,GVTraceMsg);
	}


	ValidatePrinter();			

	if (IS_TRACING)
	{ 
		sprintf(GVTraceMsg,"End Is Printer Valid?=[%d]", IsPrinterValid);
		Trace(LVFunctionName,GVTraceMsg);
	}

	if (IsPrinterValid)
	{
		exit(0);
	}
	else
	{
		exit (-1);
	}

} // Winmain


/*
*
* Function		ValidatePrinter
* Author		S Sundar
* Purpose		To validate the printer (SY_PRINT_DRIVERS.PRINTER_NAME).
*			
*/
void ValidatePrinter()
{	
	char		LVFunctionName[64];
	char		lv_printer_name[128];
	int			lv_printer_status;
	DOC_INFO_1	LVDocument;
	DWORD		LVPrintJob;
	
	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "ValidatePrinter()");
		Trace(LVFunctionName,"Begin");
		Trace(LVFunctionName,"Reading SY_PRINT_DRIVERS for printer details ...");
	}
	
	IsPrinterValid = 0;

	/*
	* Get the printer name from SY_PRINT_DRIVERS table.
	*/
	/* EXEC SQL
	SELECT printer_name, dest_port_name
	INTO   :bv_routed_printer_name, :bv_routed_port
	FROM   sy_print_drivers
	WHERE  session_id    = :bv_session_id
	AND    add_date_time = :bv_session_datetime; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select printer_name ,dest_port_name into :b0,:b1  from sy_pr\
int_drivers where (session_id=:b2 and add_date_time=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bv_routed_printer_name;
 sqlstm.sqhstl[0] = (unsigned int  )66;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bv_routed_port;
 sqlstm.sqhstl[1] = (unsigned int  )66;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bv_session_id;
 sqlstm.sqhstl[2] = (unsigned int  )22;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bv_session_datetime;
 sqlstm.sqhstl[3] = (unsigned int  )52;
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
		sprintf(GVTraceMsg,"Error at Select SY_PRINT_DRVIERS() : %s",sqlca.sqlerrm.sqlerrmc);
		if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return;
	}

	if(NO_DATA_FOUND) 
	{
		sprintf(GVTraceMsg,"No record found in SY_PRINT_DRVIERS() for checking!!!");
		if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return;
	}

	bv_routed_printer_name.arr[bv_routed_printer_name.len]='\0';
	bv_routed_printer_name.len=strlen(bv_routed_printer_name.arr);

	bv_routed_port.arr[bv_routed_port.len]='\0';
	bv_routed_port.len=strlen(bv_routed_port.arr);


	if (IS_TRACING) 
	{
		sprintf(GVTraceMsg, "Printer=[%s] Port=[%s]", bv_routed_printer_name.arr,  bv_routed_port.arr);
		Trace(LVFunctionName,GVTraceMsg);
	}
	if (IS_TRACING) Trace(LVFunctionName,"Check if printer is valid");


	/*
	* Check if printer is valid. Use OpenPrinter to check for validity.
	*/
	lv_printer_status = PRINTER_OK;
	strcpy(lv_printer_name, bv_routed_printer_name.arr);
	if (IS_TRACING) Trace(LVFunctionName,"Calling OpenPrinter ...");
	if(!OpenPrinter(lv_printer_name,&gv_hPrinter,NULL))
	{
		GetLastErrorMessage();

		lv_printer_status = PRINTER_NOT_OK;

		/*
		*
		* If the name of the printer is renamed after installed in MEDICOM
		* then OpenPrinter will fail.
		* Hence, Check for the port. 
		* If port is "LPT%". If yes, then skip error reporting.
		* 
		*/
		if (strncmp(bv_routed_port.arr,"LPT", 3) != 0)
		{
			sprintf (GVTraceMsg, "OpenPrinter() Failed with error: %s", GVLastErrorMessage);
			if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);

			bv_error_text.arr[0] = '\0';
			strcpy(bv_error_text.arr,GVTraceMsg);
			bv_error_text.len = strlen(bv_error_text.arr);

			/* EXEC SQL 
			UPDATE sy_print_drivers
			SET    num_of_pages		= 0,
				   error_text		= :bv_error_text
			WHERE  session_id		= :bv_session_id
			AND    add_date_time	= :bv_session_datetime; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update sy_print_drivers  set num_of_pages=0,error_text=:b0\
 where (session_id=:b1 and add_date_time=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )67;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bv_error_text;
   sqlstm.sqhstl[0] = (unsigned int  )503;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bv_session_id;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&bv_session_datetime;
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



			if (OERROR | NO_DATA_FOUND)
			{
				sprintf(GVTraceMsg,"Error at Update SY_PRINT_DRVIERS() : %s",sqlca.sqlerrm.sqlerrmc);
				if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
				if (IS_TRACING) Trace(LVFunctionName,"End");
				return;
			}
			/* EXEC SQL COMMIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )94;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (IS_TRACING) Trace(LVFunctionName,"End");
			return;
		} //if (strcmp(bv_routed_port.arr,"LPT") != 0)
	}

	/*
	* Assign dummy values to LVDocument. Only for using
	* in StartDocPrinter function.
	*/
	//LVDocument.pDocName	   = "Dummy"; 
	LVDocument.pDocName	   = ""; 
    LVDocument.pOutputFile = NULL; 
    LVDocument.pDatatype   = NULL; 

	if (IS_TRACING) Trace(LVFunctionName,"Calling StartDocPrinter ...");
	if((LVPrintJob=StartDocPrinter(gv_hPrinter,1,(LPSTR)&LVDocument))==0)
	{	
		GetLastErrorMessage();
		sprintf(GVTraceMsg,"APP-SY2437 %s - %s",bv_routed_printer_name.arr,GVLastErrorMessage);
		if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);

			bv_error_text.arr[0] = '\0';
			strcpy(bv_error_text.arr,GVTraceMsg);
			bv_error_text.len = strlen(bv_error_text.arr);

			/* EXEC SQL 
			UPDATE sy_print_drivers
			SET    num_of_pages		= 0,
				   error_text		= :bv_error_text
			WHERE  session_id		= :bv_session_id
			AND    add_date_time	= :bv_session_datetime; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update sy_print_drivers  set num_of_pages=0,error_text=:b0\
 where (session_id=:b1 and add_date_time=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )109;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bv_error_text;
   sqlstm.sqhstl[0] = (unsigned int  )503;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bv_session_id;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&bv_session_datetime;
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



			if (OERROR | NO_DATA_FOUND)
			{
				sprintf(GVTraceMsg,"Error at Update SY_PRINT_DRVIERS() : %s",sqlca.sqlerrm.sqlerrmc);
				if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
				if (IS_TRACING) Trace(LVFunctionName,"End");
				return;
			}
			/* EXEC SQL COMMIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )136;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
	}

	/*
	* Abort printing.
	*/	
	if (IS_TRACING) Trace(LVFunctionName,"Calling AbortPrinter ...");
	if (AbortPrinter(gv_hPrinter) == 0)
	{
		GetLastErrorMessage();
		sprintf(GVTraceMsg,"Error at AbortPrinter() : [%s]", GVLastErrorMessage);
		if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
	}

	/*
	* Close printer.
	*/	
	if (IS_TRACING) Trace(LVFunctionName,"Calling ClosePrinter ...");
	if (ClosePrinter(gv_hPrinter) == 0)
	{
		GetLastErrorMessage();
		sprintf(GVTraceMsg,"Error at ClosePrinter() : [%s]", GVLastErrorMessage);
		if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
	}

	/*
	* If lv_printer_status == PRINTER_NOT_OK,
	* it means, OpenPrinter() failed and port is "LPT%"
	* In such case, check whethter driver is installed.
	*/
	if (lv_printer_status == PRINTER_NOT_OK)
	{
		if (IS_TRACING) Trace(LVFunctionName,"OpenPrinter() failed!! Port is LPT%. Check for driver");	
	}

	/*
	* Now, we know that printer is valid.
	* Check for printer status - READY or NOT READY for printing
	* Following code is commented by Sundar
	* as the status returned was always NULL.
	if (IS_TRACING) Trace(LVFunctionName,"Check if printer is ready for printing.");
	if (!GetPrinterStatus())
	{
		if (IS_TRACING) Trace(LVFunctionName,"Updating SY_PRINT_DRIVERS ... Printer is NOT ready.");

		bv_error_text.arr[0] = '\0';
		strcpy(bv_error_text.arr,"Printer is NOT Ready");
		bv_error_text.arr[bv_error_text.len]='\0';
		bv_error_text.len=strlen(bv_error_text.arr);

		EXEC SQL 
		UPDATE sy_print_drivers
		SET    num_of_pages		= 0,
			   error_text		= :bv_error_text
		WHERE  session_id		= :bv_session_id
		AND    add_date_time	= :bv_session_datetime;

		if(OERROR) 
		{
			sprintf(GVTraceMsg,"Error at Update SY_PRINT_DRVIERS() : %s",sqlca.sqlerrm.sqlerrmc);
			if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName,"End");
			return;
		}

		if (IS_TRACING) Trace(LVFunctionName,"End");
		return;
	}
	*/

	/*
	* Printer is valid and ready for printing.
	* Return SUCCESS flag.
	*/
	if (IS_TRACING) Trace(LVFunctionName,"Updating SY_PRINT_DRIVERS ... Printer is valid and ready for printing.");
	IsPrinterValid = 1;

	/* EXEC SQL 
	UPDATE sy_print_drivers
	SET    num_of_pages		= 1
	WHERE  session_id		= :bv_session_id
	AND    add_date_time	= :bv_session_datetime; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update sy_print_drivers  set num_of_pages=1 where (session_i\
d=:b0 and add_date_time=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )151;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqhstl[1] = (unsigned int  )52;
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



	if(OERROR) 
	{
		sprintf(GVTraceMsg,"Error at Update SY_PRINT_DRVIERS() : %s",sqlca.sqlerrm.sqlerrmc);
		if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return;
	}
	/* EXEC SQL COMMIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )174;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




	if (IS_TRACING) Trace(LVFunctionName,"End");
	return;

} //ValidatePrinter


/*
*
* Function		GetPrinterStatus
* Author		S Sundar
* Purpose		To check if printer is ready.
*			
int GetPrinterStatus()
{
	char				LVFunctionName[64];
	DOC_INFO_1			di;
	DWORD				dwJob;
	HDC       hDC;

	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "GetPrinterStatus");
		Trace(LVFunctionName,"Begin");
	}

  // Get the DC using the RAW.DRV driver
  if( (hDC = CreateDC( "RAW", NULL, "LPT1", NULL ) ) == NULL )
    return FALSE;


	di.pDocName	   = "c:\tab.sql"; 
    di.pOutputFile = NULL; 
    di.pDatatype   = NULL; 

	if (IS_TRACING) Trace(LVFunctionName,"StartDoc");
	if((dwJob=StartDoc(gv_hPrinter,1,(LPSTR)&di))==0)
	if (1)
	{	
		if (IS_TRACING) Trace(LVFunctionName,"StartDoc Failed.");
		GetLastErrorMessage();
		sprintf (GVTraceMsg, "StartDoc() Failed with error: %s", GVLastErrorMessage);
		if (IS_TRACING) Trace(LVFunctionName,GVTraceMsg);
	}


	if (IS_TRACING) Trace(LVFunctionName,"End");
	return 1;

}
*/







