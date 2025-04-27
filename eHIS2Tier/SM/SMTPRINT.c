
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
           char  filnam[54];
};
static const struct sqlcxp sqlfpn =
{
    53,
    "d:\\ehis\\smtprint\\10x\\modified program_10x\\smtprint.pc"
};


static unsigned long sqlctx = 1446270789;


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
5,0,0,1,0,0,27,325,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,103,0,6,1197,0,0,1,1,0,1,0,2,3,0,0,
55,0,0,3,0,0,17,1212,0,0,1,1,0,1,0,1,9,0,0,
74,0,0,3,0,0,45,1240,0,0,1,1,0,1,0,1,9,0,0,
93,0,0,3,0,0,13,1251,0,0,1,0,0,1,0,2,9,0,0,
112,0,0,3,0,0,15,1264,0,0,0,0,0,1,0,
};


/********************************************************************************
*       
*	Name			SMTPRINT.PC
*
*	Author			K S Sundar
*
*	Purpose			To print the document.
*
*   ===============================================================
*	Input Parameters							Mandatory/Optional
*   ===============================================================
*	1.  DB Connect String (User/Password@DBName)M
*	2.  Workstation ID							M
*	3.  Facility Id								M
*	4.  Module Id								M
*	5.  Document Id								M
*	6.  Report File Name (with full path)		M
*	7.  Location Type							M
*	8.  Location Code							M
*	9.  Printer ID								M
*	10. Printer Name							M
*	11. Queue Name								M
*	12. Number of copies						O
*	13. From Page Number						O
*	14. To Page Number							O
*    
*	Agrument separator is ";"
*
*   ============================================================================
*	Modification History  
*   ============================================================================
*	Date		Person		Remarks
*   ============================================================================
*	Sep 25,2002	K S Sundar	Created.
*
*	Apr 23,2003	K S Sundar	1. Debug.H and DebugProc.H removed
*							2. Debug.C added
*							3. New Debug.H added
*							3. Calls related to debug renamed as Trace
*							4. get_workstation_id procedure is removed.
*							5. exit(1) when the program is NOT successful
*							   exit(0) when the program is successful.
*							6. WORKING_DIR is removed as it is not being used.
*
*	Apr 26,2003	K S Sundar	1. get_output_directory procedure is removed as
*							   no log file is getting created.
*
*	Sep 06,2003	K S Sundar	1. File (EXE) details shown in tracing log.
*
*	Sep 16,2003	K S Sundar	1. Memory for lpData reinitialized after each page
*								is printed.
*							2. Check if memory allocation (realloc function)
*								is success.
*							Above changes are done as a result of bug reported from GP
*							site. When a report of more 200 pages is printed, after printing
*							210 pages, the program raises "Illegal operation" error and aborted.
*
*	Sep 17,2003	K S Sundar	Calls to RegisterError modified to pass the additional
*							arguments.
*							PrinterID and QueueName - Two input arguments added
*							to pass registererror calls.
*	Nov 13,2003 Nanjayan    1. New function GetReportType()has been added, If 
*							   version is 2.1 then, for the respective report 
*							   batch_file_name value is fetched from table
*							   sy_online_print_id and if value is LOCAL,
*							   local_print_document is invoked to print the file.
*							   NOTE:
*							   =====
*							   In 4.1 Version sy_online_print_id is view,it don't
*							   have column batch_file_name.
*
*							2. New function local_print_document has been included
*							   Internally it call eHISPrint.exe(VB Program)when the
*							   batch_file_name value from sy_online_print_id is LOCAL.
*
*   July 17,2008 K. Pramodini get_sleep function is added after the printing to make the process
*                             sleep for 2 secs. (For MF-SCF-0015)
*							  Memory allocated dynamically for PRINTER_INFO_2 type variable for windows "Dont Send" error 
*
********************************************************************************/

# include <windows.h>
# include <winspool.h>
# include <assert.h>
# include <stdio.h>
# include <malloc.h>
# include <stdlib.h>
# include <conio.h>
# include <string.h>
# include <time.h>
# include <sys/types.h>
# include <sys/stat.h>
# include <Debug.h>

# if defined (WIN32)
	#define IS_WIN32 TRUE
# else
	#define IS_WIN32 FALSE
# endif

# define IS_NT		IS_WIN32 && (BOOL) (GetVersion() < 0x80000000)
# define IS_WIN32S	IS_WIN32 && (BOOL) (!(IS_NT) && (LOBYTE(LOWORD(GetVersion())) < 4 ))
# define IS_WIN95	(BOOL) (!(IS_NT) && !(IS_WIN32S)) && IS_WIN32
# define MAXNUM 750

/* EXEC SQL BEGIN DECLARE SECTION; */ 

	/* varchar  BVUidPwd[132]; */ 
struct { unsigned short len; unsigned char arr[132]; } BVUidPwd;

	/* varchar  BVPrinterID[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVPrinterID;

	/* varchar  BVPrinterName[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVPrinterName;

	/* varchar  BVQueueName[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVQueueName;

	/* varchar  BVReportFileName[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVReportFileName;


	/* varchar  BVMachineName[32]; */ 
struct { unsigned short len; unsigned char arr[32]; } BVMachineName;

	/* varchar	 bv_report_type[16]; */ 
struct { unsigned short len; unsigned char arr[16]; } bv_report_type;
			// LOCAL or Standard
	/* varchar	 BVReportType[50]; */ 
struct { unsigned short len; unsigned char arr[50]; } BVReportType;

	/* varchar	 BVSelectStmt[150]; */ 
struct { unsigned short len; unsigned char arr[150]; } BVSelectStmt;


	/* varchar  BVWorkstationID[31],
			 BVFacilityID[3],
			 BVModuleID[3],
			 BVDocumentID[11],
			 BVLocationType[2],
			 BVLocationCode[7],

			 d_sleep_secs[10]; */ 
struct { unsigned short len; unsigned char arr[31]; } BVWorkstationID;

struct { unsigned short len; unsigned char arr[3]; } BVFacilityID;

struct { unsigned short len; unsigned char arr[3]; } BVModuleID;

struct { unsigned short len; unsigned char arr[11]; } BVDocumentID;

struct { unsigned short len; unsigned char arr[2]; } BVLocationType;

struct { unsigned short len; unsigned char arr[7]; } BVLocationCode;

struct { unsigned short len; unsigned char arr[10]; } d_sleep_secs;
				//For storing sleep secs

	int		 BVVersion21YN;

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





DWORD sleep_sec = 0;

/*
*	global decalrations;
*/
HANDLE			hPrinter;
/* Commented and memory allocated dynamically for PRINTER_INFO_2 type variable
PRINTER_INFO_2 	pPrinterInfo[100]; */
PRINTER_INFO_2 	*pPrinterInfo = NULL;		
DWORD			cByteNeeded,cByteUsed,dwBytesWritten,dwReq,dwUsd;

FILE *fp;


char	gv_machine_name[32];
char	gv_err_msg[132];
char	*GVFromPage;
char	*GVToPage;
char	*GVNoOfCopies;
char	*GVDocName;
char	*GV_Doc_Name;
char	GV_Sep[5]= "\\";
int		GVFromPageNumber;
int		GVToPageNumber;
int		GVNoOfCopiesNumber;
int		GVCtr;

char	*GVReportFileName;

char	*gv_ws_no,   *gv_facility_id,  *gv_module_id,  *gv_document_id;

int		print_document();				// Print document.

int		LocalPrintDocument();			// Local Print document.(For Printing Arabic)

int 	GetReportType();				// Get report type either LOCAL or STANDARD

char	err_text[250], err[150];

void    get_sleep();                    // sleep for 2 secs
/*
* WinMain
*/
int WINAPI WinMain(HINSTANCE  hInstance,HINSTANCE  hPrevInstance,LPSTR  lpCmdLine, int  nShowCmd)
{
	/*
	* Declare local variables.
	*/
	struct _stat LVFileStat;
	int			 LVResult;
	char		 *LVStrBuf;

	char	LVFunctionName[64];
	char	sep[3]=";";
	char	*LVUidPwd;
	char	*LVPrinterID;
	char	*LVPrinterName;
	char	*LVQueueName;
	char	*LVReportFileName;
	char	*LVLocationType; 
	char	*LVLocationCode;
	char	LV_Str[3] = ".";
	char	LV_DOCName[40];
	int		lv_ret_flag;
	int		LVContinue=1;
	DWORD	lv_machine_no = 20;
	char	lv_machine_name[32];
	char	tmpbuf[500];

	/*
	* Read command line parameters.
	*/
	LVUidPwd=strtok(lpCmdLine,sep);
	gv_ws_no=strtok(NULL,sep);
	gv_facility_id=strtok(NULL,sep);
	gv_module_id=strtok(NULL,sep);
	gv_document_id=strtok(NULL,sep);
	LVReportFileName=strtok(NULL,sep);
	LVLocationType=strtok(NULL,sep);
	LVLocationCode=strtok(NULL,sep);
	LVPrinterID=strtok(NULL,sep);
	LVPrinterName=strtok(NULL,sep);
	LVQueueName=strtok(NULL,sep);
	GVNoOfCopies=strtok(NULL,sep);
	GVFromPage=strtok(NULL,sep);
	GVToPage=strtok(NULL,sep);

	/*
	* Exit if any mandatory parameter is missing.
	*/
	if (LVUidPwd==NULL       || LVPrinterID==NULL || LVPrinterName==NULL || 
		LVQueueName==NULL || LVReportFileName==NULL ||
		gv_ws_no==NULL       || gv_facility_id==NULL  || gv_module_id==NULL        ||
		gv_document_id==NULL || LVLocationType==NULL     || LVLocationCode==NULL)
	{
		strcpy (tmpbuf, "Usage:SMTPRINT;uid/pwd@connect;workstation_id;facility_id;");
		strcat (tmpbuf, "module_id;document_id;report_file_name;loc_type;loc_code;");
		strcat (tmpbuf, "printer_id;printer_name;queue_name");
		MessageBox(hwnd, tmpbuf, "Information", MB_OK | MB_ICONINFORMATION);
		return 0;
	} 

	/*
	* Capture command line parameters.
	*/
	BVUidPwd.arr[0] = '\0';
	BVUidPwd.len =0;
	strcpy(BVUidPwd.arr,LVUidPwd);
	BVUidPwd.len = strlen(BVUidPwd.arr);

	BVPrinterID.arr[0] = '\0';
	BVPrinterID.len =0;
	strcpy(BVPrinterID.arr,LVPrinterID);
	BVPrinterID.len = strlen(BVPrinterID.arr);

	BVPrinterName.arr[0] = '\0';
	BVPrinterName.len =0;
	strcpy(BVPrinterName.arr,LVPrinterName);
	BVPrinterName.len = strlen(BVPrinterName.arr);

	BVQueueName.arr[0] = '\0';
	BVQueueName.len =0;
	strcpy(BVQueueName.arr,LVQueueName);
	BVQueueName.len = strlen(BVQueueName.arr);

	BVReportFileName.arr[0] = '\0';
	BVReportFileName.len =0;
	strcpy(BVReportFileName.arr,LVReportFileName);
	BVReportFileName.len = strlen(BVReportFileName.arr);

	BVMachineName.arr[0] = '\0';
	BVMachineName.len =0;

	strcpy(BVWorkstationID.arr, gv_ws_no);
	BVWorkstationID.len = strlen (BVWorkstationID.arr);
	BVWorkstationID.arr[BVWorkstationID.len]='\0';

	strcpy(BVFacilityID.arr, gv_facility_id);
	BVFacilityID.len = strlen (BVFacilityID.arr);

	strcpy(BVModuleID.arr, gv_module_id);
	BVModuleID.len = strlen (BVModuleID.arr);

	strcpy(BVDocumentID.arr, gv_document_id);
	BVDocumentID.len = strlen (BVDocumentID.arr);

	strcpy(BVLocationType.arr, LVLocationType);
	BVLocationType.len = strlen (BVLocationType.arr);

	strcpy(BVLocationCode.arr, LVLocationCode);
	BVLocationCode.len = strlen (BVLocationCode.arr);

	if ((GVFromPage!=NULL) && (strcmp(GVFromPage,"0") != 0))
		GVFromPageNumber = atoi(GVFromPage);
	else
		GVFromPageNumber = 1;

	if ((GVToPage!=NULL) && (strcmp(GVToPage,"0") != 0))
		GVToPageNumber  = atoi(GVToPage);
	else
		GVToPageNumber  = 9999;

	if ((GVNoOfCopies!=NULL) && (strcmp(GVNoOfCopies,"0") != 0))
		GVNoOfCopiesNumber = atoi(GVNoOfCopies);
	else
		GVNoOfCopiesNumber = 1;


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

	/*
	* Connect to database
	*/
	/* EXEC SQL CONNECT :BVUidPwd; */ 

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
 sqlstm.sqhstv[0] = (         void  *)&BVUidPwd;
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


	if(sqlca.sqlcode < 0)
	{
		MessageBox(hwnd,"Unable to connect to oracle.","Error",MB_OK|MB_ICONSTOP);
		exit(1);
	}

	/*	
	* Following code for setting meduser role is added by C. Ganesan on 26/10/2002 at 19:00
	*
	*/
	set_meduser_role();

	d_sleep_secs.arr[0] = '\0';
	d_sleep_secs.len=0;
    
	strcpy(d_sleep_secs.arr, "2000");

	d_sleep_secs.len=strlen(d_sleep_secs.arr);
	d_sleep_secs.arr[d_sleep_secs.len]='\0';

	/*
	* Enable or disable tracing.
	*/
	strcpy(GVProgramID, "SMTPRINT");	
	strcpy(LVFunctionName, "WinMain()");	
	EnableOrDisableTracing();

	GVReportFileName=(char *)malloc(80*sizeof(char));
	strcpy (GVReportFileName,LVReportFileName);

	if (IS_TRACING)
	{
		Trace(LVFunctionName,"Begin");

		LVResult = _stat(_pgmptr, &LVFileStat);
		if (LVResult == 0)
		{	
			LVStrBuf = strtok(ctime(&LVFileStat.st_mtime),"\n");	
			sprintf(GVTraceMsg,"File Name=[%Fs]  TimeStamp=[%s]  Size=[%ld Bytes]", _pgmptr, LVStrBuf , LVFileStat.st_size );
			Trace(LVFunctionName,GVTraceMsg);
		}

		sprintf(GVTraceMsg,"BVUidPwd=[%s] BVPrinterID=[%s] BVPrinterName=[%s] BVQueueName=[%s] GVReportFileName=[%s] GVNoOfCopiesNumber=[%d]  GVFromPageNumber=[%d] GVToPageNumber=[%d]",
			BVUidPwd.arr, BVPrinterID.arr, BVPrinterName.arr,BVQueueName.arr, GVReportFileName, GVNoOfCopiesNumber, GVFromPageNumber, GVToPageNumber);
		Trace(LVFunctionName,GVTraceMsg);
	}


	/*
	* Get the machine name.
	* This will be used to while logging the error in
	* SY_ONLINE_PRINT_ERROR_LOG table.
	*/ 
	if (IS_TRACING) Trace(LVFunctionName,"Getting computer name ...");
	GetComputerName(lv_machine_name, &lv_machine_no);
	strcpy(BVMachineName.arr, lv_machine_name);
	BVMachineName.len = strlen(BVMachineName.arr);
	if (IS_TRACING) 
	{
		sprintf(GVTraceMsg, "Machine name=[%s]", BVMachineName.arr);
		Trace(LVFunctionName,GVTraceMsg);
	}

	/*
	* Write debug information on workstation identifier.
	*/ 
	if (IS_TRACING) 
	{
		sprintf(GVTraceMsg, "Workstation number=[%s]", BVWorkstationID.arr);
		Trace(LVFunctionName,GVTraceMsg);
	}

	/*
	* Check the existence of the report file.
	*/
	if (IS_TRACING) 
	{
		sprintf(GVTraceMsg, "Checking if [%s] exists ...", GVReportFileName);
		Trace(LVFunctionName,GVTraceMsg);
	}


	if ((fp = fopen (GVReportFileName, "r")) == NULL)
	{
		GetMEDICOMMessage("SY2435",gv_err_msg);
		sprintf (GVTraceMsg, "APP-SY2435 %s", gv_err_msg);
		RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
		if (IS_TRACING) 
		{
			Trace(LVFunctionName,"File not exists");
			Trace(LVFunctionName,"End");
		}
		free(GVReportFileName);
		exit(1);
	}
	if (IS_TRACING) Trace(LVFunctionName,"File exists!!");
	GetReportType();
	if (strcmp(BVReportType.arr,"LOCAL")==0 && (BVVersion21YN ==1))
	{
	   if (IS_TRACING) 
		{
	  		Trace(LVFunctionName,"Calling local_print_document();");
		}
		LocalPrintDocument();
	}
	else
	{
		/*
		Print the document.
		*/ 
		if (IS_TRACING) 
		{
			Trace(LVFunctionName,"Calling print_document();");
		}

		for(GVCtr=1;GVCtr<=GVNoOfCopiesNumber;GVCtr++) 
			print_document();

	}
   if (IS_TRACING) 
   {
	  	Trace(LVFunctionName,"End");
   }

	/*
	* Exit the program
	* exit(0) is succesful exit.
	*/
	exit(0);

} // Winmain

/*
*
* Function  local_print_document
* Author    N K Nanjayan
* Purpose   To print the document containing Local Language.
*
*/
int LocalPrintDocument()
{
	char	*lv_file_name; 
	char	*lv_err_file_name; 
	char	*lv_err_str; 
	char	*lv_printer_name;
	char	*lv_queue_name;
	char	lv_cmd[256];
	char	LVFunctionName[64];
	char	wordir[20];
	char	LV_Str[3] = ".";
	char	LV_DOCName[40];
	char	*lv_tmpstr, *lv_tmpstr2;
	DWORD	dw;
	FILE	*cmdfp;
	FILE	*errfp;
	char	cmdfilename[100], WorkingDir[100];

	
    STARTUPINFO si;
    PROCESS_INFORMATION pi;

	if (IS_TRACING) 
	{
		strcpy(LVFunctionName, "LocalPrintDocument()"); 
		Trace(LVFunctionName,"Begin");
	}

    ZeroMemory( &si, sizeof(si) );
    si.cb = sizeof(si);
    ZeroMemory( &pi, sizeof(pi) );

	/*
	* Get the file name.
	*/
	lv_file_name=(char *)malloc(201*sizeof(char));
	strcpy(lv_file_name,"");
	strcpy(lv_file_name,BVReportFileName.arr);
	GVDocName	=strtok(lv_file_name,GV_Sep);
	while(GVDocName !=NULL)
	{
	//Get next token:
	if (strstr(GVDocName,LV_Str) != NULL)
	{
		strcpy(LV_DOCName,"");
		strcat(LV_DOCName,GVDocName);
		exit;
	}
	GVDocName = strtok( NULL, GV_Sep);
	}

	strcpy(lv_file_name,LV_DOCName);
	GetPrivateProfileStringA("Reports","Dir","",wordir,sizeof(wordir),"eHIS.ini");

	/*
	* Get the printer name.
	*/
	lv_printer_name=(char *)malloc(100*sizeof(char));
	strcpy(lv_printer_name,"");
	strcpy(lv_printer_name,BVPrinterName.arr);
	
	BVPrinterName.arr[0]='\0';
	BVPrinterName.len = strlen(BVPrinterName.arr);

	/*
	* Get the queue name.
	*/
	lv_queue_name=(char *)malloc(100*sizeof(char));
	strcpy(lv_queue_name,"");
	strcpy(lv_queue_name,BVQueueName.arr);
	lv_tmpstr=strtok(lv_queue_name, "\\\\");
	lv_tmpstr2=strtok(NULL, "\\");

	if (IS_TRACING) 
	{
		sprintf(GVTraceMsg, "File=<%s>    Printer=<%s>", lv_file_name, lv_printer_name); 
		Trace(LVFunctionName,GVTraceMsg);
	}

	/*
	* Set the report type.
	* LOCAL means the report is having local language characters.
	* Only for LOCAL Language eHISPrint is Called
	*/
	strcpy(bv_report_type.arr,"");
	strcpy(bv_report_type.arr,"LOCAL");
	bv_report_type.len = strlen(bv_report_type.arr);

	/*
	* Create CMD file.
	*/
	if (IS_TRACING) Trace(LVFunctionName,"Initializing for eHISPrint.EXE ...");
    GetPrivateProfileStringA("Reports","Dir","",WorkingDir,sizeof(WorkingDir),"eHIS.ini");
	sprintf(cmdfilename, "%seHISPRINT.CMD", WorkingDir);
	cmdfp =	fopen (cmdfilename, "w");
	if (IS_TRACING) 
	{
		sprintf(GVTraceMsg, "eHISPrint.EXE;BVDocumentID[%s];WorkingDir[%s];lv_file_name[%s];lv_printer_name[%s];GVNoOfCopiesNumber[%d];bv_report_type[%s]",BVDocumentID.arr,WorkingDir,lv_file_name,lv_printer_name,GVNoOfCopiesNumber, bv_report_type.arr);
		Trace(LVFunctionName,GVTraceMsg);
	}

	fprintf(cmdfp,"eHISPrint.EXE;%s;%s;%s;%s;%d;%s",BVDocumentID.arr,WorkingDir,lv_file_name,lv_printer_name,GVNoOfCopiesNumber, bv_report_type.arr);
	fclose(cmdfp);

	/* Start the child process.  */
	if (IS_TRACING) Trace(LVFunctionName,"Calling eHISPrint.EXE ...");
    if( !CreateProcess
		( 
			NULL,			// No module name (use command line). 
			"eHISPrint.EXE",	// Command line. 
			NULL,			// Process handle not inheritable. 
			NULL,			// Thread handle not inheritable. 
			FALSE,			// Set handle inheritance to FALSE. 
			0,				// No creation flags. 
			NULL,			// Use parent's environment block. 
			NULL,			// Use parent's starting directory. 
			&si,			// Pointer to STARTUPINFO structure.
			&pi				// Pointer to PROCESS_INFORMATION structure.
		)
    ) 
    {
        if (IS_TRACING) 
		{
			Trace(LVFunctionName, GVTraceMsg);
		}
    }
	else
	{
		if (IS_TRACING) Trace(LVFunctionName, "eHISPrint.EXE run successfully!!");

		/* Check for any errors if any */
		lv_err_file_name=(char *)malloc(201*sizeof(char));
		sprintf(lv_err_file_name,"%s%s.Err",WorkingDir,BVDocumentID.arr);
		if ((errfp = fopen (lv_err_file_name, "r")) == NULL)
		{
			/* 
				Error file not available!!
				That means, there was no error reported from eHISPrint.EXE 
			*/
		}
		else
		{
			/*
				Error file available.
				Read the contents and Log in MEDICOM.
			*/
			lv_err_str=(char *)malloc(700*sizeof(char));
			fgets(lv_err_str,MAXNUM,errfp);
			if (IS_TRACING) Trace(LVFunctionName, lv_err_str);
			fclose(errfp);

			//get_message("SY2437",err);
			//sprintf(err_text,"APP-SY2437 %s - %s - %s", BV_Rep_File_Name.arr, err, lv_err_str);
			//LogTheError(1,1);
		}

	}

	/* Wait until child process exits. */
    WaitForSingleObject( pi.hProcess, INFINITE );

	/* Close process and thread handles. */
    CloseHandle( pi.hProcess );
    CloseHandle( pi.hThread );


	/* Read ERR file (if any) and write MEDICOM */
	// Continue  here.

	if (IS_TRACING) 
	{
		Trace(LVFunctionName,"End");
	}

	get_sleep();   //Function is added for sleeping process for MF-SCF-0015

	return 1;

} /* End of LocalPrintDocument() */


/*
*
* Function  print_document
* Author    K S Sundar
* Purpose   To print the document.
*
*/
int print_document()
{
	char LVFunctionName[64];
	int pageno=0,last_ocur=0;
	int change, ct_page, frst_char=0, len;
	int found, char_found, brk_found;
	int j=0,i=0,no_page=0,no_line=0, first_line;
	char *str,*lpData;
	DOC_INFO_1 di;
	DWORD  dwJob,dwBytesWritten,dwReq,dwUsd;
	/* Commented and memory allocated dynamically for PRINTER_INFO_2 type variable
	PRINTER_INFO_2 	pPrinterInfo[100]; */
    PRINTER_INFO_2 *pInfo2 = NULL;
	char ch;

	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "print_document()");
		Trace(LVFunctionName,"Begin");
	}

	/*
	* Check the existence of the printer.
	*/
	if (IS_TRACING) Trace(LVFunctionName,"OpenPrinter");
	if(! OpenPrinter(BVPrinterName.arr,&hPrinter,NULL))
	{
		GetMEDICOMMessage("SY2437",gv_err_msg);
		sprintf(GVTraceMsg,"APP-SY2437 %s",gv_err_msg);
		RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		free(BVPrinterName.arr);
		free(GVReportFileName);
		return 0;
	}
	
	/*
	* Get the attributes of the printer.
	*/
	if (IS_TRACING) Trace(LVFunctionName,"GetPrinter 1");
	if (IS_TRACING) Trace(LVFunctionName,"Before GetPrinter 1"); /* GopiKannan */
	if(! GetPrinter(hPrinter,2,NULL,0,&dwReq))
	{
		if(GetLastError() != ERROR_INSUFFICIENT_BUFFER)
		{
		    GetMEDICOMMessage("SY2437",gv_err_msg);
	           sprintf(GVTraceMsg,"APP-SY2437 %s",gv_err_msg);
			RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName,"End");
			return 0;
		}
	}
	
	/* Code added on 17.07.08 */
	pInfo2 = (PRINTER_INFO_2 *) malloc(dwReq);
	if(!(pInfo2))
		return 0;
	//Upto here

	/*
	* Get the attributes of the printer.
	*/
	if (IS_TRACING) Trace(LVFunctionName,"GetPrinter 2");
	/*if(! GetPrinter(hPrinter,2,(LPBYTE)pInfo2,dwReq,&dwReq)) */
	
	if (IS_TRACING) Trace(LVFunctionName,"Before GetPrinter 2"); /* GopiKannan */
	if(! GetPrinter(hPrinter,2,(LPBYTE)pInfo2,dwReq,&dwUsd)) /* Added by Gopi Kannan for ML-SD-SCF-3322 Printer */
	{
		{
		    GetMEDICOMMessage("SY2437",gv_err_msg);
	        sprintf(GVTraceMsg,"APP-SY2437 %s",gv_err_msg);
			RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName,"End");
			return 0;
		}
	}
	
	if (IS_TRACING) Trace(LVFunctionName,"Outside-1 GetPrinter 2 "); /* GopiKannan */
	
	di.pDocName	   = BVReportFileName.arr; 
    di.pOutputFile = NULL; 
    di.pDatatype   = NULL; 
	
	/*
	* Check if there is any Printer Error.
	*/
	if (IS_TRACING) Trace(LVFunctionName,"Check for Printer Errors");
	if(IsPrinterError(hPrinter)==1)
	{
		GetMEDICOMMessage("SY2436", gv_err_msg);
		sprintf(GVTraceMsg,"APP-SY2436 %s - %s",BVPrinterName.arr,gv_err_msg);
		RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
	}

	/*
	* Start the printing.
	*/
	if (IS_TRACING) Trace(LVFunctionName,"StartDocPrinter");
	if((dwJob=StartDocPrinter(hPrinter,1,(LPSTR)&di))==0)
	{	
		GetLastErrorMessage();
		sprintf(GVTraceMsg,"APP-SY2437 %s - %s",BVPrinterName.arr,GVLastErrorMessage);
		RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
	}

	if (IS_TRACING) Trace(LVFunctionName,"StartPagePrinter");
	if (!StartPagePrinter(hPrinter))
	{ 
		EndDocPrinter(hPrinter);
		ClosePrinter(hPrinter);
		GetMEDICOMMessage("SY2437", gv_err_msg);
		sprintf(GVTraceMsg,"APP-SY2437 %s - %s",BVPrinterName.arr,gv_err_msg);
		RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
	}

	/*
	* Open file.
	*/
	if (IS_TRACING) 
	{
		sprintf(GVTraceMsg,"Opening file [%s] ...", GVReportFileName);
		Trace(LVFunctionName,GVTraceMsg);
	}

	if ((fp = fopen (GVReportFileName, "rb")) == NULL)
	{
		GetLastErrorMessage();
		sprintf(GVTraceMsg,"Unable to open file [%s] : [%s] ",GVReportFileName,GVLastErrorMessage);
		RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
	}

	/*
	* Decide the from/to page and number of copies to be printed
	*/
	str = (char *) malloc (MAXNUM * sizeof(char));	 
	lpData = (char *) malloc (MAXNUM * sizeof(char));	 
	strcpy(lpData,"\0");

	if (IS_TRACING)
	{ 
		sprintf(GVTraceMsg, "NumOfCopies=[%d]   FromPage=[%d]    ToPage=[%d]", GVNoOfCopiesNumber, GVFromPageNumber, GVToPageNumber);
		Trace(LVFunctionName,GVTraceMsg);
	}



	for(;fgets(str,MAXNUM,fp);) //Start For1
	{	

		found=0;

		/*		
		* Suppress the first empty page.
		*/

        if ( (first_line == 1) && (str[0] == 12) )
		{
			i = 1;
		}
		else
			i = 0;
		
		

		for(;str[i];i++)  // Start For2
		
  		 if (str[i]==12) //Start If2
		 {

		    found = 1;
			pageno = pageno++;

			strncat(lpData,str,i+1);

			if(pageno >= GVFromPageNumber && pageno <= GVToPageNumber)
		    {

				/*		
				* In Lexmark Printers, the page is not terminate with PAGE BREAK,
				* last page is not printing and it goes to waiting mode. 
				* In HP, no problem for the same
				* To avoid the Waiting Mode problem in Lexmark, Here we are 
				* including PAGE BREAK externally.
				*/

				len = strlen(lpData);
		
				if (len > 3)
				{
					if (lpData[len-1] != 12) 
						strcat(lpData,"\f");
				}

				if(!WritePrinter(hPrinter,lpData,strlen(lpData),&dwBytesWritten))
				{
					EndPagePrinter(hPrinter);
					EndDocPrinter(hPrinter);
					GetMEDICOMMessage("SY2437", gv_err_msg);
					sprintf(GVTraceMsg,"APP-SY2437 %s - %s",BVPrinterName.arr,gv_err_msg);
					RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
					if (IS_TRACING) Trace(LVFunctionName,"End");
				    return 0;
				}

				if(!EndPagePrinter(hPrinter))
				{
					EndDocPrinter(hPrinter);
					GetMEDICOMMessage("SY2437", gv_err_msg);
					sprintf(GVTraceMsg,"APP-SY2437 %s - %s",BVPrinterName.arr,gv_err_msg);
					RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
					if (IS_TRACING) Trace(LVFunctionName,"End");
				    return 0;
				}

				if (!StartPagePrinter(hPrinter))
				{ 
					EndDocPrinter(hPrinter);
					GetMEDICOMMessage("SY2437", gv_err_msg);
					sprintf(GVTraceMsg,"APP-SY2437 %s - %s",BVPrinterName.arr,gv_err_msg);
					RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
					if (IS_TRACING) Trace(LVFunctionName,"End");
				    return 0;
				}

				if (IS_TRACING)
				{
					sprintf(GVTraceMsg, "Page %d printed", pageno);
					Trace(LVFunctionName, GVTraceMsg);
				}
					
		
			}//END PAGE COUNT
			 strcpy(lpData,"\0");
			 strcpy(lpData,str+(i+1));

			/*
			* Re-initialize the buffer (lpData).
			*/
			free (lpData);
			if ((lpData = (char *) malloc (MAXNUM * sizeof (char))) == NULL)	 
			{
				MessageBox(hwnd, "Unable to allocate memory !!", "Error", MB_OK);
			    return 0;
			}
			strcpy(lpData,"\0");

		  }//END IF2

		if(found==0)
		{

			/*
			*	Suppress first page break 
			*/
			if ( (first_line == 1) && (str[0] == 12) )
			{
			  strcat(lpData, str+1);
			}
			else
			{
			  strcat(lpData,str);
			}

			if ((lpData = realloc (lpData, _msize(lpData) +(MAXNUM * sizeof(char)))) == NULL)	 
			{
				MessageBox(hwnd, "Unable to allocate memory !!", "Error", MB_OK);
			    return 0;
			}

		}

		first_line = 2;

	}//End For1

	pageno++;
	fclose(fp);

    if(pageno >= GVFromPageNumber && pageno<= GVToPageNumber) //end Page no count
    {
	  //strcat(lpData,"\f"); //Commented by Sathya(19/8/98)for Page eject control
		
		char_found = 0;
		brk_found  = 0;

		len = strlen(lpData);

		// In Lexmark Printers, the page is not terminate with PAGE BREAK,
		// last page is not printing and it goes to waiting mode. 
		// In HP, no problem for the same
		// To avoid the Waiting Mode problem in Lexmark, Here we are 
		// including PAGE BREAK externally.

		for (i=0; lpData[i] != '\0' ; i++)
		{

            ch = lpData[i];

			if( ((ch>64) && (ch<91)) ||
                ((ch>47) && (ch<58)) )
            {
                char_found = 1;
            }

            if (ch == 12)
                brk_found = 1;

            if( (ch == '.') && (lpData[i+1] == 'E') )
                brk_found = 1;

		}

      if ( (char_found == 1) &&
	  	   (brk_found  == 0) )
            strcat(lpData,"\f"); // FOR TESTING

  	  //MessageBox(hwnd, lpData,"Inside Extra Print",MB_OK|MB_ICONSTOP);
	  
	  
		if(!WritePrinter(hPrinter,lpData,strlen(lpData),&dwBytesWritten))
		{
			EndPagePrinter(hPrinter);
			EndDocPrinter(hPrinter);
			ClosePrinter(hPrinter);
			free(str );
			free(lpData);
			GetMEDICOMMessage("SY2437", gv_err_msg);
			sprintf(GVTraceMsg,"APP-SY2437 %s - %s",BVPrinterName.arr,gv_err_msg);
			RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName,"End");
			return 0;
		}


		if(!EndPagePrinter(hPrinter))
		{
			EndPagePrinter(hPrinter);
			EndDocPrinter(hPrinter);
			ClosePrinter(hPrinter);
			free(str);
			free(lpData);
			GetMEDICOMMessage("SY2437", gv_err_msg);
			sprintf(GVTraceMsg,"APP-SY2437 %s - %s",BVPrinterName.arr,gv_err_msg);
			RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName,"End");
			return 0;
		}
	 
    }

	if (!EndDocPrinter(hPrinter))
	{ 
		ClosePrinter(hPrinter);
		free(str);
		free(lpData);
		GetMEDICOMMessage("SY2437", gv_err_msg);
		sprintf(GVTraceMsg,"APP-SY2437 %s - %s",BVPrinterName.arr,gv_err_msg);
		RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, BVReportFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrinterID.arr,  BVPrinterName.arr, BVQueueName.arr, LVFunctionName, GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 0;
	}

	
	if (IS_TRACING) 
	{
		sprintf(GVTraceMsg, "Total number of pages=[%d]", pageno-1);
		Trace(LVFunctionName,GVTraceMsg);
		Trace(LVFunctionName,"Close Printer");
	}
	ClosePrinter(hPrinter);

	free(BVPrinterName.arr);

	if(str)
		free(str);
	if(lpData)
		free(lpData);

	if (IS_TRACING) Trace(LVFunctionName,"End");

	get_sleep();   //Function is added for sleeping process for MF-SCF-0015

	return 1;

} // print_document


// This is to check the Printer & Job status of the printer
int IsPrinterError(HANDLE hPrinter)
{ 
	JOB_INFO_2  *pJobs;
	int			cJobs,i;
	DWORD		dwPrinterStatus;
	char	err[100];
	char	LVFunctionName[64];

	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "IsPrinterError()");
		Trace(LVFunctionName,"Begin");
	}


	if(!GetJobs(hPrinter,&pJobs,&cJobs,&dwPrinterStatus))
	   return 0;

	if(dwPrinterStatus & (PRINTER_STATUS_ERROR |
					PRINTER_STATUS_PAPER_JAM |
					PRINTER_STATUS_PAPER_PROBLEM |
					PRINTER_STATUS_NOT_AVAILABLE |
					PRINTER_STATUS_NO_TONER |
					PRINTER_STATUS_OUT_OF_MEMORY |
					PRINTER_STATUS_USER_INTERVENTION))
	{
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return 1;
	}

	// This is to check the jobs status of the printer
	/*	
	for( i=0; i<cJobs;i++)
	{

		if(pJobs[i].Status & JOB_STATUS_PRINTING)
		{
			if( pJobs[i].Status & (JOB_STATUS_ERROR | JOB_STATUS_BLOCKED_DEVQ ))
			{
				return 1;
			}
		}
	}
	*/

	if (IS_TRACING) Trace(LVFunctionName,"End");

	return 0;

}



BOOL GetJobs(HANDLE hPrinter, JOB_INFO_2 **ppJobInfo, int *pcJobs, DWORD *pStatus)
{ 

	DWORD cByteNeeded, nReturned,cByteUsed;
	JOB_INFO_2 *pJobStorage =  NULL;
	PRINTER_INFO_2  *pPrinterInfo = NULL;

	char LVFunctionName[64];

	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "GetJobs()");
		Trace(LVFunctionName,"Begin");
	}


	if(!GetPrinter(hPrinter,2,NULL,0,&cByteNeeded))
	{
		if(GetLastError() != ERROR_INSUFFICIENT_BUFFER)
		  return FALSE;
	}

	pPrinterInfo = (PRINTER_INFO_2 *) malloc(cByteNeeded);
	if(!(pPrinterInfo))
		return FALSE;

	if(!GetPrinter(hPrinter,2,(LPSTR)pPrinterInfo,cByteNeeded,&cByteUsed))
	{
		free(pPrinterInfo);
		pPrinterInfo = NULL;
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return FALSE;
	}

	if(!EnumJobs(hPrinter,0,pPrinterInfo->cJobs,2,NULL,0,&cByteNeeded,&nReturned))
	{
		if(GetLastError() != ERROR_INSUFFICIENT_BUFFER)
		{
			free(pPrinterInfo);
			pPrinterInfo = NULL;
			if (IS_TRACING) Trace(LVFunctionName,"End");
			return FALSE;
		}
	}

	pJobStorage = (JOB_INFO_2 *)malloc(cByteNeeded);
	if(!pJobStorage)
	{
		free(pPrinterInfo);
		pPrinterInfo = NULL;
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return FALSE;
	}

	ZeroMemory(pJobStorage,cByteNeeded);
	if(!EnumJobs(hPrinter,0,pPrinterInfo->cJobs,2,(LPBYTE)pJobStorage,
				cByteNeeded,(LPDWORD)&cByteUsed,(LPDWORD)&nReturned))
	{
		free(pPrinterInfo);
		free(pJobStorage);
		pJobStorage = NULL;
		pPrinterInfo = NULL;
		if (IS_TRACING) Trace(LVFunctionName,"End");
		return FALSE;
	}

	*pcJobs = pPrinterInfo->cJobs;
	*pStatus = pPrinterInfo->Status;
	*ppJobInfo = pJobStorage;
	free(pPrinterInfo);

	if (IS_TRACING) Trace(LVFunctionName,"End");

	return TRUE;

}

int GetReportType()
{
	char	LVFunctionName[64];

	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "GetReportType()");
		Trace(LVFunctionName,"Begin");
	}

	/*
	* Initialize Report Type, Version
	*/
	BVReportType.arr[0] = '\0';
	BVReportType.len	=0;
	strcpy(BVReportType.arr,"STANDARD");
	BVReportType.len = strlen(BVReportType.arr);

	/* EXEC SQL EXECUTE
		BEGIN
			IF SM_INSTALLATION_TAB_CHECK THEN
				:BVVersion21YN := 1;
			ELSE
				:BVVersion21YN := 1;
			END IF;
		END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin IF SM_INSTALLATION_TAB_CHECK THEN :BVVersion21YN := 1 \
; ELSE :BVVersion21YN := 1 ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&BVVersion21YN;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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



	if (BVVersion21YN ==1)
	{
		strcpy(BVSelectStmt.arr,"SELECT NVL(UPPER(batch_file_name),'STANDARD') FROM sy_online_print_id WHERE online_print_name = :v1");
		BVSelectStmt.len = strlen(BVSelectStmt.arr);

		/* EXEC SQL PREPARE prepare_statement FROM :BVSelectStmt; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )55;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&BVSelectStmt;
  sqlstm.sqhstl[0] = (unsigned int  )152;
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


	if (IS_TRACING)
	{
		sprintf(GVTraceMsg, "SELECT NVL(UPPER(batch_file_name),'STANDARD') FROM sy_online_print_id WHERE online_print_name =[%s]",BVDocumentID.arr);
		Trace(LVFunctionName,GVTraceMsg);
	}

		if ORACLE_ERROR
		{
			sprintf(GVTraceMsg,"Error at PREPARE Statement : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, "Prepare Statement", GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName, "End");
			strcpy(BVReportType.arr,"STANDARD");
			BVReportType.len = strlen(BVReportType.arr);
			return 0;
		}

		/* EXEC SQL DECLARE cursor1 CURSOR FOR prepare_statement; */ 

		if ORACLE_ERROR
		{
			sprintf(GVTraceMsg,"Error at DECLARE cursor : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, "Declare Cursor", GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName, "End");
			strcpy(BVReportType.arr,"STANDARD");
			BVReportType.len = strlen(BVReportType.arr);
			return 0;
		}
		
		/* EXEC SQL OPEN cursor1 USING :BVDocumentID; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )74;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&BVDocumentID;
  sqlstm.sqhstl[0] = (unsigned int  )13;
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


		if ORACLE_ERROR
		{
			sprintf(GVTraceMsg,"Error at OPEN cursor : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, "Open Cursor", GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName, "End");
			strcpy(BVReportType.arr,"STANDARD");
			BVReportType.len = strlen(BVReportType.arr);
			return 0;
		}

		/* EXEC SQL FETCH cursor1 INTO :BVReportType; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )93;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&BVReportType;
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


		BVReportType.arr[BVReportType.len] = '\0';
		if (ORACLE_ERROR || ORACLE_NODATAFOUND)
		{
			/*
			* Register error
			*/
			if ORACLE_ERROR
			{
				sprintf(GVTraceMsg,"Error at FETCH cursor : [%s]",sqlca.sqlerrm.sqlerrmc);
				RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, "Fetch Cursor", GVTraceMsg);
			}
		}
		/* EXEC SQL CLOSE cursor1; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )112;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		
		if ORACLE_ERROR
		{
			sprintf(GVTraceMsg,"Error at OPEN cursor : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVDocumentID.arr, "Open Cursor", GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName, "End");
			BVReportType.len = strlen(BVReportType.arr);
			return 0;
		}

	}

	if (IS_TRACING)
	{
		sprintf(GVTraceMsg, "LOCAL/STANDARD Report=[%s]  BVVersion21YN=[%d]", BVReportType.arr, BVVersion21YN);
		Trace(LVFunctionName,GVTraceMsg);
		Trace(LVFunctionName, "End");
	}
	return(0);
}//GetReportType

void get_sleep()
{
 
  sleep_sec = (DWORD) atol(d_sleep_secs.arr);

           if (sleep_sec)
             Sleep(sleep_sec);
}
