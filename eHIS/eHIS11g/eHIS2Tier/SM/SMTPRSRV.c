
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
           char  filnam[39];
};
static const struct sqlcxp sqlfpn =
{
    38,
    "d:\\ravis\\rl10x\\--64160\\11g\\smtprsrv.pc"
};


static unsigned long sqlctx = 25836107;


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
            void  *sqhstv[13];
   unsigned int   sqhstl[13];
            int   sqhsts[13];
            void  *sqindv[13];
            int   sqinds[13];
   unsigned int   sqharm[13];
   unsigned int   *sqharc[13];
   unsigned short  sqadto[13];
   unsigned short  sqtdso[13];
} sqlstm = {10,13};

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

 static const char *sq0011 = 
"select ONLINE_PRINT_FILE_NAME  from SY_REPORT_PRINT_REQUEST where (PRINT_SUC\
CESS_YN is  not null  and (SYSDATE-PRINT_DATE)>=2)           ";

 static const char *sq0016 = 
"select operating_facility_id ,module_id ,online_print_name ,online_print_fil\
e_name ,dest_locn_type ,dest_locn_code ,to_char(print_date,'DDMMYYYYHH24MI') ,\
rowid ,ws_no ,print_server_id ,printer_name ,dest_queue_name  from SY_REPORT_P\
RINT_REQUEST where ((((operating_facility_id=decode(:b0,'*A',operating_facilit\
y_id,:b0) and print_priority=decode(:b2,0,print_priority,:b2)) and ((:b4='*A' \
or (:b4='RLRRSENQ' and online_print_name like 'RLR%')) or (:b4='BLRRSENQ' and \
online_print_name like 'BL%'))) or (:b4='O' and WS_NO in (select WS_NO  from R\
L_RESULT_PRINT_OP_WSNO where OPERATING_FACILITY_ID=DECODE(:b0,'*A',OPERATING_F\
ACILITY_ID,:b0)))) or (((:b4='N' and WS_NO not  in (select WS_NO  from RL_RESU\
LT_PRINT_OP_WSNO where OPERATING_FACILITY_ID=DECODE(:b0,'*A',OPERATING_FACILIT\
Y_ID,:b0))) and PRINT_IMMEDIATE_YN='Y') and PRINT_SUCCESS_YN is null ))       \
    ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,275,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,83,0,6,319,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
59,0,0,3,76,0,4,413,0,0,1,0,0,1,0,2,3,0,0,
78,0,0,4,260,0,4,457,0,0,6,4,0,1,0,2,1,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
117,0,0,5,87,0,4,529,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
140,0,0,6,141,0,2,557,0,0,1,1,0,1,0,1,9,0,0,
159,0,0,7,61,0,4,576,0,0,1,0,0,1,0,2,9,0,0,
178,0,0,8,201,0,3,589,0,0,6,6,0,1,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
217,0,0,9,0,0,30,619,0,0,0,0,0,1,0,
232,0,0,10,122,0,4,689,0,0,1,0,0,1,0,2,3,0,0,
251,0,0,11,137,0,9,719,0,0,0,0,0,1,0,
266,0,0,11,0,0,13,736,0,0,1,0,0,1,0,2,9,0,0,
285,0,0,11,0,0,15,749,0,0,0,0,0,1,0,
300,0,0,12,256,0,2,761,0,0,0,0,0,1,0,
315,0,0,13,104,0,2,782,0,0,0,0,0,1,0,
330,0,0,14,0,0,29,796,0,0,0,0,0,1,0,
345,0,0,15,109,0,6,838,0,0,1,1,0,1,0,2,9,0,0,
364,0,0,16,860,0,9,908,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
431,0,0,16,0,0,13,971,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
494,0,0,16,0,0,15,1001,0,0,0,0,0,1,0,
509,0,0,17,124,0,6,1074,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,3,9,0,0,3,9,0,0,
540,0,0,18,93,0,5,1255,0,0,1,1,0,1,0,1,9,0,0,
559,0,0,19,91,0,5,1267,0,0,1,1,0,1,0,1,9,0,0,
578,0,0,20,72,0,5,1277,0,0,1,1,0,1,0,1,9,0,0,
597,0,0,21,0,0,29,1292,0,0,0,0,0,1,0,
};


/************************************************************************************
*    
*	Name			SMTPRSRV.PC
*
*	Author			MEDICOM R&D Team, Muscat.
*
*	Purpose			MEDICOM Print Server
*					to handle server based print routing.
*
*   =================================================================================
*	Input Parameters		 					Remarks
*   =================================================================================
*	1. DB Connect String (User/Password@DBName)	Mandatory
*	2. Date Time								Mandatory
*	3. Session Id								Mandatory
*	4. Facility ID								Mandatory
*	5. Priority ID								Mandatory
*	6. Serviced Request ID						Mandatory
*
*   =================================================================================
*	Modification History  
*   =================================================================================
*	Date			Person		Remarks
*   =================================================================================
*
*	20/4/2003	    Aparna k	Upgraded for EH
*
*	May 10, 2003	K S Sundar	1. Standardized
*								2. Additional parameters (Priority ID and 
*								   Serviced Request ID) are handled for 
*								   selecting appropriate print request.
*								3. Program restarting is disabled as it is not required.
*
*   July 8 2003    Aparna K     Error while printing corrected when parameters passed
*								facility ID as '*A'  - for ALL
*								priority as 0 - For ALL
*								serviced request as '*A'  -- for ALL
*								Changed the cursor to get print requests with decode 
*								function.
*
*	Sep 17,2003		K S Sundar	Calls to RegisterError modified to pass
*								additional arguments.
*
*	Sep 05,2004		N K Nanjayan In ProcessPendingRequests function
*								 Version check has been included.
*								 Based on the MEDICOM version 
*								 Working directory is fetched.
*
*	Dec 12,2005		S. Sundar	 For enabling explicit printing,
*								 we read print_server_id, printer_name and dest_queue_name
*								 from sy_report_print_request. If columns are NOT NULL,
*								 instead of calling WSPrintDocument, we directly call SMTPRINT
*								 to print.
*	OCT 7,2016		Ravi Shankar	against GHL-SCF-1120
************************************************************************************/

/*
* Include header files.
*/

# include <windows.h>
# include <winuser.h>
# include <winspool.h>
# include <malloc.h>
# include <assert.h>
# include <stdio.h>
# include <dos.h>
# include <crtdbg.h>
# include <stdlib.h>
# include <conio.h>
# include <string.h>
# include <time.h>
# include <sys/stat.h>
# include <debug.h>
# include <process.h>

/*
* Define constants.
*/

# define MAXNUM 750
# define COLLATE 1
# define OERROR			(sqlca.sqlcode < 0)
# define RESOURCE_BUSY  (sqlca.sqlcode == 54)
# define NODATAFOUND sqlca.sqlcode==1403

# if defined (WIN32)
	#define IS_WIN32 TRUE
# else
	#define IS_WIN32 FALSE
# endif

# define IS_NT		IS_WIN32 && (BOOL) (GetVersion() < 0x80000000)
# define IS_WIN32S	IS_WIN32 && (BOOL) (!(IS_NT) && (LOBYTE(LOWORD(GetVersion())) < 4 ))
# define IS_WIN95	(BOOL) (!(IS_NT) && !(IS_WIN32S)) && IS_WIN32

void	ProcessPendingRequests(void);		
void	PurgeOldRequests(void);
int		RestartProgram(void);					

HWND		hwnd;
WNDCLASS	wndclass;

char GVErrorMessage[200];
char GVArguments[512];
char GVPgmName[64];
char GVCmd[1024];
int  GVSpawnReturnCode = 1;
int  GVIsPrintSuccess = 0;
int  GVIsTracing;
int  RestartInterval;				// Assign BVRestartInterval

/*
* Declare SQL bind variables.
*/
/* EXEC SQL BEGIN DECLARE SECTION; */ 

	/* varchar		BVComputerName[16]; */ 
struct { unsigned short len; unsigned char arr[16]; } BVComputerName;
			// For Program Tracing

	int		 BVElapsedTime;				// To get the elapsed time since last start of the program.
	char	 BVMachineName[16];
	/* varchar	 bv_cmd_line [200]; */ 
struct { unsigned short len; unsigned char arr[200]; } bv_cmd_line;
			// Command line string
	/* varchar	 BVStartedByID [21]; */ 
struct { unsigned short len; unsigned char arr[21]; } BVStartedByID;

	/* varchar	 bv_next_start_time [15]; */ 
struct { unsigned short len; unsigned char arr[15]; } bv_next_start_time;


	/* varchar  BVUidPwd[132]; */ 
struct { unsigned short len; unsigned char arr[132]; } BVUidPwd;
				// i/p parameter
	/* varchar	 BVModuleID [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } BVModuleID;
		
	/* varchar  BVDateTime[22]; */ 
struct { unsigned short len; unsigned char arr[22]; } BVDateTime;
			// i/p parameter
	/* varchar  BVSessionID[20]; */ 
struct { unsigned short len; unsigned char arr[20]; } BVSessionID;
			// i/p parameter		
	/* varchar	 BVFacilityID [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } BVFacilityID;
			// i/p parameter
	/* varchar	 BVPriorityID [4]; */ 
struct { unsigned short len; unsigned char arr[4]; } BVPriorityID;
			// i/p parameter
	/* varchar	 BVServicedRequestID[32]; */ 
struct { unsigned short len; unsigned char arr[32]; } BVServicedRequestID;
	// i/p parameter

	/* varchar	 BVDocumentID [8]; */ 
struct { unsigned short len; unsigned char arr[8]; } BVDocumentID;
		/* Required for RegisterError */
	/* varchar	 BVModuleID1[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } BVModuleID1;
		/* Required for RegisterError */

	/* varchar  BVRowID[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } BVRowID;


	/* varchar	 BVRequestFacilityID [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } BVRequestFacilityID;
			// Added by Aparna -- Cursor parameter 
	/* varchar	 BVWorkstationID[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVWorkstationID;

	/* varchar  BVOnlinePrintFileName[152]; */ 
struct { unsigned short len; unsigned char arr[152]; } BVOnlinePrintFileName;

	/* varchar  BVOnlinePrintName[10]; */ 
struct { unsigned short len; unsigned char arr[10]; } BVOnlinePrintName;

	/* varchar  BVLocationType[4]; */ 
struct { unsigned short len; unsigned char arr[4]; } BVLocationType;
			
	/* varchar  BVLocationCode[8]; */ 
struct { unsigned short len; unsigned char arr[8]; } BVLocationCode;
			
	/* varchar  BVPrintDate[22]; */ 
struct { unsigned short len; unsigned char arr[22]; } BVPrintDate;

	/* varchar  BVWs_No[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } BVWs_No;
				
	/* varchar  BVPrinter_ID[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } BVPrinter_ID;
				
	/* varchar  BVPrinter_Name[61]; */ 
struct { unsigned short len; unsigned char arr[61]; } BVPrinter_Name;
				
	/* varchar  BVDest_Queue_Name[61]; */ 
struct { unsigned short len; unsigned char arr[61]; } BVDest_Queue_Name;
				
	/* varchar  BVPgmID[22]; */ 
struct { unsigned short len; unsigned char arr[22]; } BVPgmID;

	/* varchar  BVParameterID[50]; */ 
struct { unsigned short len; unsigned char arr[50]; } BVParameterID;

	/* varchar  BVRestartInterval[8]; */ 
struct { unsigned short len; unsigned char arr[8]; } BVRestartInterval;
 
	/* varchar  BVErrorText[200]; */ 
struct { unsigned short len; unsigned char arr[200]; } BVErrorText;


	/* varchar  BV_Error_Text[501]; */ 
struct { unsigned short len; unsigned char arr[501]; } BV_Error_Text;

    /* varchar  BVReport_Output_Dir[120]; */ 
struct { unsigned short len; unsigned char arr[120]; } BVReport_Output_Dir;

    /* varchar  BVerror_text[501]; */ 
struct { unsigned short len; unsigned char arr[501]; } BVerror_text;

	/* varchar  BVUserId[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } BVUserId;

   	/* varchar	 BVNewVersionYN[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } BVNewVersionYN;
   	// TO check the MEDICOM version


	
	long	 BVSleepTime;
	int      BVNoOfPendingRequests;

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
* Main Window program
*/
int WINAPI WinMain(HINSTANCE  hInstance,HINSTANCE  hPrevInstance,
    LPSTR  lpCmdLine,int  nShowCmd)
{
	char LVFunctionName[30];
	char LVSeparator[3]= " " ;
	char *LVUidPwd,*LVDateTime, *LVSessionID,*LVFacilityID, *LVPriorityID, *LVServicedRequestID;
	int  LVContinue=1;
   	char LVMachineName[20];
	DWORD LVMachineNo = 20;
	struct _stat LVFileStat;
	int LVResult;
	char *LVStrBuf;
	   
	/*
	* Initialize Parameters.
	*/
	BVUidPwd.arr[0]				= '\0';
	BVSessionID.arr[0]			= '\0';
	BVDateTime.arr[0]			= '\0';
	BVFacilityID.arr[0]			= '\0';
	BVPriorityID.arr[0]			= '\0';
	BVServicedRequestID.arr[0]	= '\0';

	BVUidPwd.len				= 0;
	BVDateTime.len				= 0;
	BVSessionID.len				= 0;
	BVFacilityID.len			= 0;
	BVPriorityID.len			= 0;
	BVServicedRequestID.len		= 0;

	/*
	* Load parameters into local variables.
	*/
	LVUidPwd			= strtok(lpCmdLine,LVSeparator);
	LVDateTime			= strtok(NULL,LVSeparator);
	LVSessionID			= strtok(NULL,LVSeparator);
	LVFacilityID		= strtok(NULL,LVSeparator);
	LVPriorityID		= strtok(NULL,LVSeparator);
	LVServicedRequestID	= strtok(NULL,LVSeparator);
	
	/*
	* Exit if any mandatory parameter is missing.
	*/
	if(LVUidPwd==NULL || LVDateTime==NULL || LVSessionID==NULL || LVFacilityID==NULL || LVPriorityID==NULL || LVServicedRequestID==NULL )
	{
		exit(0);
	}
	
	/*
	* Assign parameters to bind variables.
	*/
	strcpy(BVUidPwd.arr,LVUidPwd);
	BVUidPwd.len = strlen(BVUidPwd.arr);

	strcpy(BVDateTime.arr,LVDateTime);
	BVDateTime.len = strlen(BVDateTime.arr);

	strcpy(BVSessionID.arr,LVSessionID);
	BVSessionID.len = strlen(BVSessionID.arr);

	strcpy(BVFacilityID.arr,LVFacilityID);
	BVFacilityID.len = strlen(BVFacilityID.arr);

	strcpy(BVPriorityID.arr,LVPriorityID);
	BVPriorityID.len = strlen(BVPriorityID.arr);

	strcpy(BVServicedRequestID.arr,LVServicedRequestID);
	BVServicedRequestID.len = strlen(BVServicedRequestID.arr);
	
	/*
	* BVDocumentID and BVModuleID1 - Required for RegisterError().
	* Not input parameters.
	*/
	strcpy(BVDocumentID.arr,"SMTPRSRV");			
	BVDocumentID.len = strlen(BVDocumentID.arr);	
	strcpy(BVModuleID1.arr,"SM");			
	BVModuleID1.len = strlen(BVModuleID1.arr);	

	/*
	* Create Window
	*/
	wndclass.style			= CS_HREDRAW | CS_VREDRAW;
	wndclass.lpfnWndProc    = NULL;
	wndclass.cbClsExtra		= 0;
	wndclass.cbWndExtra		= 0;
	wndclass.hInstance		= hInstance;
	wndclass.hIcon			= NULL;  //LoadIcon ( NULL, IDI_APPLICATION );
	wndclass.hCursor		= NULL;  //LoadCursor ( NULL, IDC_ARROW);
//	wndclass.hbrBackground	= GetStockObject (WHITE_BRUSH);
	wndclass.hbrBackground	= (HBRUSH) GetStockObject (LTGRAY_BRUSH);
	wndclass.lpszMenuName	= NULL;
	wndclass.lpszClassName	= "Printing Pc";
	RegisterClass ( &wndclass );

	hwnd = CreateWindow("Print Server",(LPSTR)NULL,
                         WS_POPUP | WS_DLGFRAME,170,190,300,100,
                         (HWND)NULL,(HMENU)NULL,(HANDLE)hInstance,
						 (LPSTR) lpCmdLine);

	/*
	* Connect to database.
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
		exit(0);
	}

	set_meduser_role();

	/*
	* Enable or disable tracing.
	*/
	strcpy(GVProgramID , "SMTPRSRV");	
	EnableOrDisableTracing();
	GVIsTracing = IS_TRACING; // For later usage


	/*
	* Display arguments.
	*/
	if (IS_TRACING)
	{
		strcpy(LVFunctionName,"WinMain");		
		Trace(LVFunctionName,"Begin");

		LVResult = _stat(_pgmptr, &LVFileStat);
		if (LVResult == 0)
		{	
			LVStrBuf = strtok(ctime( &LVFileStat.st_mtime ),"\n");	
			sprintf(GVTraceMsg,"File Name=[%Fs]  TimeStamp=[%s]  Size=[%ld Bytes]", _pgmptr, LVStrBuf , LVFileStat.st_size );
			Trace(LVFunctionName,GVTraceMsg);
		}


		sprintf(GVTraceMsg,"BVUidPwd=[%s] BVDateTime=[%s] BVSessionID=[%s] BVFacilityID=[%s] BVPriorityID=[%s] BVServicedRequestID=[%s]",
		BVUidPwd.arr, BVDateTime.arr, BVSessionID.arr, BVFacilityID.arr, BVPriorityID.arr, BVServicedRequestID.arr);
		Trace(LVFunctionName,GVTraceMsg);
	}

	/*
	* Get workstation id.
	*/
	BVWorkstationID.arr[0] = '\0';	
	BVWorkstationID.len = 0;
	/* EXEC SQL EXECUTE 
	BEGIN 
		WORKSTATION.get_workstation_id
		(
			:BVFacilityID,
			:BVWorkstationID
		);
	END ;
	END-EXEC ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin WORKSTATION . get_workstation_id ( :BVFacilityID , :BV\
WorkstationID ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&BVFacilityID;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&BVWorkstationID;
 sqlstm.sqhstl[1] = (unsigned int  )66;
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

 		

	if ORACLE_ERROR 
	{
		sprintf(GVTraceMsg,"Error at WORKSTATION.get_workstation_id: [%s]",sqlca.sqlerrm.sqlerrmc);
		RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName, "End");
		return 0;
	}

	BVWorkstationID.arr[BVWorkstationID.len] = '\0';
	if (IS_TRACING)
	{
		sprintf(GVTraceMsg,"BVWorkstationID=[%s]",BVWorkstationID.arr);
		Trace(LVFunctionName,GVTraceMsg);
	}

	/*
	* Restarting is not required as this program is fetching records
	* from a single cursor and a separate program is being called
	* for printing purpose. 
	*
	* Hence the following code is commented.
	*
	* Comment - Begin
	*
	*
	BVRestartInterval.arr[0]	= '\0';	
	BVRestartInterval.len		= 0;
	
	BVErrorText.arr[0]			= '\0';	
	BVErrorText.len				= 0;

	BVParameterID.arr[0]		= '\0';	
	BVParameterID.len			= 0;
	strcpy(BVParameterID.arr,"RESTARTINTERVAL");

	EXEC SQL EXECUTE 
	BEGIN 
		workstation.get_ws_param
		(
			:BVWorkstationID,
			:BVParameterID,
			:BVRestartInterval,
			:BVErrorText
		);
	END;
	END-EXEC; 	

	BVRestartInterval.arr[BVRestartInterval.len]    = '\0'; 
	BVErrorText.arr[BVErrorText.len]				= '\0'; 

	if (IS_TRACING)
	{
		sprintf(GVTraceMsg,"RestartInterval=[%s] ErrorText=[%s]",BVRestartInterval.arr, BVErrorText.arr);
		Trace(LVFunctionName,GVTraceMsg);
	}

	RestartInterval = 30;
	if (BVRestartInterval.arr != NULL)
		RestartInterval = atoi(BVRestartInterval.arr);

	if (IS_TRACING)
	{
		sprintf(GVTraceMsg,"Restart Interval=[%s]", RestartInterval );
		Trace(LVFunctionName,GVTraceMsg);
	}
	*
	* Comment - End
	*/

	/*
	*  Get computer name.
	*/
	GetComputerName(LVMachineName, &LVMachineNo);
	strcpy(BVComputerName.arr, LVMachineName);
	BVComputerName.len = strlen(BVComputerName.arr);
	if (IS_TRACING)
	{
		sprintf(GVTraceMsg,"BVComputerName=[%s]", BVComputerName.arr);
		Trace(LVFunctionName,GVTraceMsg);
	}

	/*
	*  Get sleep time.
	*/
	/* EXEC SQL 
	SELECT 	processing_interval
	INTO	:BVSleepTime
	FROM	sy_prog_id
	WHERE	pgm_id = 'SMTPRSRV'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select processing_interval into :b0  from sy_prog_id where p\
gm_id='SMTPRSRV'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )59;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&BVSleepTime;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
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
		sprintf(GVTraceMsg,"Error at SELECT from sy_prog_id : [%s]",sqlca.sqlerrm.sqlerrmc);
		RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
		BVSleepTime = 0;
	}
	else if ORACLE_NODATAFOUND
	{
		BVSleepTime = 0;
	}
	
	if (IS_TRACING)
	{
		sprintf(GVTraceMsg,"BVSleepTime=[%d]", BVSleepTime);
		Trace(LVFunctionName,GVTraceMsg);
	}

	/*
	* Start processing (loop)
	*/
	LVContinue = 1;
	while(LVContinue == 1)
	{
		
		if (IS_TRACING) Trace (LVFunctionName,"Calling ProcessPendingRequests() ...");
		ProcessPendingRequests();

		if (IS_TRACING) Trace (LVFunctionName,"Calling PurgeOldRequests() ...");
		PurgeOldRequests();

		if (IS_TRACING) 
		{
			sprintf(GVTraceMsg,"Sleeping for %d msecs...", BVSleepTime);
			Trace (LVFunctionName, GVTraceMsg);
		}
		Sleep(BVSleepTime);

		if (IS_TRACING) Trace (LVFunctionName,"Checking whether process is to be continued ...");
		/* EXEC SQL 
		SELECT	machine_name, started_by_id
		INTO	:BVMachineName, :BVStartedByID
		FROM	SY_BG_PROCESS_CONTROL
		WHERE	operating_facility_id = :BVFacilityID
		AND		pgm_id  = 'SMTPRSRV' 
		AND		priority = :BVPriorityID
		AND		serviced_requests = :BVServicedRequestID
		AND		STARTED_DATE IS NOT NULL 
		AND		TO_CHAR(STARTED_DATE,'DDMMYYHH24MISS') = :BVDateTime; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select machine_name ,started_by_id into :b0,:b1  from SY_BG\
_PROCESS_CONTROL where (((((operating_facility_id=:b2 and pgm_id='SMTPRSRV') a\
nd priority=:b3) and serviced_requests=:b4) and STARTED_DATE is  not null ) an\
d TO_CHAR(STARTED_DATE,'DDMMYYHH24MISS')=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )78;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)BVMachineName;
  sqlstm.sqhstl[0] = (unsigned int  )16;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&BVStartedByID;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&BVFacilityID;
  sqlstm.sqhstl[2] = (unsigned int  )4;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&BVPriorityID;
  sqlstm.sqhstl[3] = (unsigned int  )6;
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
  sqlstm.sqhstv[5] = (         void  *)&BVDateTime;
  sqlstm.sqhstl[5] = (unsigned int  )24;
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



		if(ORACLE_NODATAFOUND || ORACLE_ERROR)
		{
			LVContinue = 0;
		}

		/*
		* Restarting is not required as this program is processing 
		* records from a single cursor and also a separate program 
		* is being  called for printing purpose. Hence, call to 
		* RestartProgram is commented.
		*
		if (LVContinue == 1)
		{						
			LVContinue = RestartProgram();
		}
		*
		*/

	} /* while(LVContinue == 1) */

	if (IS_TRACING)
	{
		sprintf(GVTraceMsg,"Background process is not running. Program aborting.");
		Trace(LVFunctionName,GVTraceMsg);
		Trace(LVFunctionName,"End");
	}

	exit(0);

} /* End of WinMain */

/*
*
*	Function	RestartProgram
*
*	Author		K S Sundar
*
*	Date		Sep 17, 2002
*
*	Purpose		This is to restart the new instance of the program. 
*				At each specified restart interval,
*				1. Deletes record from SY_BG_PROCESS_CONTROL for the current run.
*				2. Inserts a news record into SY_BG_PROCESS_CONTROL for the next run.
*				3. Starts the new instance.
*				4. Aborts the current instance.
*
*/
int RestartProgram(void)
{

	char LVFunctionName[30];

	if (IS_TRACING) 
	{
		strcpy(LVFunctionName,"RestartProgram()");
		Trace(LVFunctionName,"Begin");
	}
	
	/* 
	* Get the elapsed time since the last start 
	*/
	/* EXEC SQL 
	SELECT floor(abs(sysdate - TO_DATE(:BVDateTime,'DDMMYYHH24MISS')) * 1440)
	INTO BVElapsedTime
	FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select floor((abs((sysdate-TO_DATE(:b0,'DDMMYYHH24MISS')))* \
1440)) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )117;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&BVDateTime;
 sqlstm.sqhstl[0] = (unsigned int  )24;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&BVElapsedTime;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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



	if ORACLE_ERROR 
	{
		sprintf(GVTraceMsg,"Error at SELECT from dual : [%s]",sqlca.sqlerrm.sqlerrmc);
		RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","Calculate Elapsed Time", GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName, "End");
		return 0;
	}

	if (IS_TRACING)
	{
		sprintf(GVTraceMsg,"Elapsed time since last start = %d minutes", BVElapsedTime);
		Trace(LVFunctionName,GVTraceMsg);
	}

	if (BVElapsedTime > RestartInterval)
	{
		
		if (IS_TRACING)
		{
			sprintf(GVTraceMsg,"Elapsed time is greater than restart interval!!! Restarting ...");
			Trace(LVFunctionName,GVTraceMsg);
		}

		/* EXEC SQL DELETE sy_bg_process_control
		WHERE pgm_id = 'SMTPRSRV'
		AND   started_date is not null
		AND   started_date = TO_DATE(:BVDateTime,'DDMMYYHH24MISS'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from sy_bg_process_control  where ((pgm_id='SMTPRSR\
V' and started_date is  not null ) and started_date=TO_DATE(:b0,'DDMMYYHH24MIS\
S'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )140;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&BVDateTime;
  sqlstm.sqhstl[0] = (unsigned int  )24;
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



		if (ORACLE_ERROR)
		{
			sprintf(GVTraceMsg,"Error at DELETE from sy_bg_process_control : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","Calculate Elapsed Time", GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName, "End");
			return 0;
		}

		if (IS_TRACING)
		{
			sprintf(GVTraceMsg,"Record removed from sy_bg_process_control");
			Trace(LVFunctionName,GVTraceMsg);
		}

		/* EXEC SQL
		SELECT to_char(sysdate,'ddmmyyhh24miss')
		INTO   bv_next_start_time
		FROM   dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select to_char(sysdate,'ddmmyyhh24miss') into :b0  from dua\
l ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )159;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bv_next_start_time;
  sqlstm.sqhstl[0] = (unsigned int  )17;
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



		if (ORACLE_ERROR)
		{
			sprintf(GVTraceMsg,"Error at SELECT from dual : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","Calculate Elapsed Time", GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName, "End");
			return 0;
		}

		/* EXEC SQL
		INSERT INTO SY_BG_PROCESS_CONTROL
		(
			operating_facility_id,
			pgm_id,                 
			machine_name,           
			started_by_id,          
			started_date,           
			priority,               
			serviced_requests      
		)
		VALUES
		(	
			:BVFacilityID,
			'SMTPRSRV',
			:BVMachineName,
			:BVStartedByID,
			to_date(:bv_next_start_time, 'ddmmyyhh24miss'),
			:BVPriorityID,
			:BVServicedRequestID
		); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into SY_BG_PROCESS_CONTROL (operating_facility_id,pg\
m_id,machine_name,started_by_id,started_date,priority,serviced_requests) value\
s (:b0,'SMTPRSRV',:b1,:b2,to_date(:b3,'ddmmyyhh24miss'),:b4,:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )178;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&BVFacilityID;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)BVMachineName;
  sqlstm.sqhstl[1] = (unsigned int  )16;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&BVStartedByID;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&bv_next_start_time;
  sqlstm.sqhstl[3] = (unsigned int  )17;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&BVPriorityID;
  sqlstm.sqhstl[4] = (unsigned int  )6;
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



		if (ORACLE_ERROR)
		{
			sprintf(GVTraceMsg,"Error at INSERT into SY_BG_PROCESS_CONTROL : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","Calculate Elapsed Time", GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName, "End");
			return 0;
		}
		
		/* EXEC SQL COMMIT WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )217;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		/* Frame the command to be executed */
		bv_cmd_line.arr[0] = '\0';
	    strcat(bv_cmd_line.arr,"SMTPRSRV");
		strcat(bv_cmd_line.arr," ");
		strcat(bv_cmd_line.arr,BVUidPwd.arr);
		strcat(bv_cmd_line.arr," ");
		strcat(bv_cmd_line.arr,bv_next_start_time.arr);
		strcat(bv_cmd_line.arr," ");
		strcat(bv_cmd_line.arr,BVSessionID .arr);
		strcat(bv_cmd_line.arr," ");
		strcat(bv_cmd_line.arr,BVFacilityID .arr);

		bv_cmd_line.arr[strlen(bv_cmd_line.arr)] = '\0';		


		/* Invoke the next instance of SMTPRSRV */

		if (IS_TRACING)
	    {
			sprintf(GVTraceMsg,bv_cmd_line.arr);
			Trace(LVFunctionName,GVTraceMsg);
	    }

		WinExec(bv_cmd_line.arr, SW_SHOWNORMAL);

		if (IS_TRACING) Trace(LVFunctionName,"End");

		/* Exit the current session */
		exit (0);
	}
	
	return 1;

}	/* End of RestartProgram */


/*
*
*	Function	PurgeOldRequests
*
*	Author		K S Sundar
*
*	Date		May 11, 2003
*
*	Purpose		Purges the following for processed requests, 
*					which are older than 2 days:
*				1. Physical files
*				2. Error Log from SY_ONLINE_PRINT_ERROR_LOG
*				3. Print requsts from SY_REPORT_PRINT_REQUSTS
*
*/
void PurgeOldRequests(void)
{

	char LVFunctionName[30];
	int LVContinue = 1;
	BVNoOfPendingRequests  = 0;

	if (IS_TRACING) 
	{
		strcpy(LVFunctionName,"PurgeOldRequests()");
		Trace(LVFunctionName,"Begin");
	}

	/*
	* Find out if there is any processed requests older
	* than 2 days.
	*/
	/* EXEC SQL  
	SELECT	COUNT(*) 
	INTO	:BVNoOfPendingRequests 
	FROM	SY_REPORT_PRINT_REQUEST
	WHERE	PRINT_SUCCESS_YN IS NOT NULL 
	AND		SYSDATE - PRINT_DATE >= 2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(*)  into :b0  from SY_REPORT_PRINT_REQUEST wher\
e (PRINT_SUCCESS_YN is  not null  and (SYSDATE-PRINT_DATE)>=2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )232;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&BVNoOfPendingRequests;
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



	if (BVNoOfPendingRequests == 0)
	{
		if (IS_TRACING) Trace(LVFunctionName,"Nothing to purge !!");
	}
	else
	{
		if (IS_TRACING) Trace(LVFunctionName,"Purging old files.");

		/* EXEC SQL  
		DECLARE DEL_CUR CURSOR  FOR
		SELECT  ONLINE_PRINT_FILE_NAME
		FROM    SY_REPORT_PRINT_REQUEST
		WHERE   PRINT_SUCCESS_YN IS NOT NULL 
		AND		SYSDATE - PRINT_DATE >= 2; */ 

		if ORACLE_ERROR 
		{
			sprintf(GVTraceMsg,"Error at DECLARE cursor : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName, "End");
			return 0;
		}


		/* EXEC SQL OPEN DEL_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0011;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )251;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 
		if ORACLE_ERROR 
		{
			sprintf(GVTraceMsg,"Error at OPEN cursor : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName, "End");
			return 0;
		}

		/*
		* Purge the physical files which are older than 2 days.
		*/
		while(LVContinue!=0)
		{
			BVOnlinePrintFileName.arr[0] = '\0';
			BVOnlinePrintFileName.len    = 0;

			/* EXEC SQL FETCH DEL_CUR INTO :BVOnlinePrintFileName; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )266;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&BVOnlinePrintFileName;
   sqlstm.sqhstl[0] = (unsigned int  )154;
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



			if (ORACLE_ERROR || ORACLE_NODATAFOUND)
			{
				/*
				* Register error
				*/
				if ORACLE_ERROR 
				{
					sprintf(GVTraceMsg,"Error at FETCH cursor : [%s]",sqlca.sqlerrm.sqlerrmc);
					RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
				}
				LVContinue = 0;
				/* EXEC SQL CLOSE DEL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )285;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			}
			else
			{
				BVOnlinePrintFileName.arr[BVOnlinePrintFileName.len] = '\0';
				DeleteFile(BVOnlinePrintFileName.arr);
			}
		}

		/*
		* Purge error logs older than 2 days.
		*/
		/* EXEC SQL 
		DELETE 
		FROM	SY_ONLINE_PRINT_ERROR_LOG
		WHERE	( ONLINE_PRINT_NAME, user_id, ONLINE_PRINT_FILE_NAME )
					IN ( SELECT ONLINE_PRINT_NAME, user_id, ONLINE_PRINT_FILE_NAME 
						 FROM   SY_REPORT_PRINT_REQUEST 
						 WHERE  PRINT_SUCCESS_YN IS NOT NULL 
						 AND	SYSDATE - PRINT_DATE >= 2 
						); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from SY_ONLINE_PRINT_ERROR_LOG  where (ONLINE_PRINT\
_NAME,user_id,ONLINE_PRINT_FILE_NAME) in (select ONLINE_PRINT_NAME ,user_id ,O\
NLINE_PRINT_FILE_NAME  from SY_REPORT_PRINT_REQUEST where (PRINT_SUCCESS_YN is\
  not null  and (SYSDATE-PRINT_DATE)>=2))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )300;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (ORACLE_ERROR)
		{
			sprintf(GVTraceMsg,"Error at DELETE from SY_ONLINE_PRINT_ERROR_LOG : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","Calculate Elapsed Time", GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName, "End");
			return 0;
		}

		/*
		* Purge print requests older than 2 days.
		*/
		/* EXEC SQL 
		DELETE 
		FROM	SY_REPORT_PRINT_REQUEST
		WHERE	PRINT_SUCCESS_YN IS NOT NULL 
		AND 	SYSDATE - PRINT_DATE >= 2; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from SY_REPORT_PRINT_REQUEST  where (PRINT_SUCCESS_\
YN is  not null  and (SYSDATE-PRINT_DATE)>=2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )315;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (ORACLE_ERROR)
		{
			sprintf(GVTraceMsg,"Error at DELETE from SY_REPORT_PRINT_REQUEST : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","Calculate Elapsed Time", GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName, "End");
			return 0;
		}

		/* EXEC SQL COMMIT; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )330;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}

	if (IS_TRACING) Trace(LVFunctionName,"End");

} /* End of PurgeOldRequests */

/*
*
*	Function	ProcessPendingRequests
*
*	Author		K S Sundar
*
*	Date		May 11, 2003
*
*	Purpose		Processes the pending requests as follows:
*
*				For each pending print request,
*				1. Prints the document
*				2. Updates SY_REPORT_PRINT_REQUEST.PRINT_SUCCESS_YN with printing status 
*
*/
void ProcessPendingRequests(void)
{

	FILE *fp;
	int		LVContinue,i;
	int		LVRequestCtr;
	char	LVFunctionName[30];
	char	*wordir;
	int	 LVProcessReturnCode;

	if (IS_TRACING) 
	{
		strcpy(LVFunctionName,"ProcessPendingRequests");
		Trace(LVFunctionName,"Begin");
	} 
	
	BVNewVersionYN.arr[0] = '\0';
	BVNewVersionYN.len = 0;
	strcpy(BVNewVersionYN.arr,"N");
	if (IS_TRACING) Trace(LVFunctionName,"Checking Medicom Version ...");
		/* EXEC SQL EXECUTE 
   		BEGIN 
			IF sm_installation_tab_check THEN
				:BVNewVersionYN := 'Y';
			ELSE
				:BVNewVersionYN := 'N';
			END IF;
		END ;
   		END-EXEC ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin IF sm_installation_tab_check THEN :BVNewVersionYN := \
'Y' ; ELSE :BVNewVersionYN := 'N' ; END IF ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )345;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&BVNewVersionYN;
  sqlstm.sqhstl[0] = (unsigned int  )4;
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


		BVNewVersionYN.len = strlen(BVNewVersionYN.arr);
	
	if (IS_TRACING)
	{
		sprintf(GVTraceMsg,"Medicom Version=[%s]",BVNewVersionYN.arr);
		Trace(LVFunctionName, GVTraceMsg);
	}

	/*
	* Declare cursor for pending print requests.
	*/

	/* added by aparna
		Decode function for operating facility ID and priority value 
		for all priority changed from '*A' to 0 
	*/

	/* EXEC SQL  
	DECLARE REQUEST_CUR CURSOR  FOR
	SELECT  operating_facility_id,
			module_id,
			online_print_name,
			online_print_file_name,
			dest_locn_type,
			dest_locn_code, 
			to_char(print_date, 'DDMMYYYYHH24MI'),
			rowid,
			ws_no,
			print_server_id,							-- Added by S. Sundar on Dec 12, 2005
			printer_name,								-- for checking explicit printing.
			dest_queue_name
	FROM    SY_REPORT_PRINT_REQUEST
	WHERE   operating_facility_id = decode(:BVFacilityID,'*A',operating_facility_id ,:BVFacilityID)
	AND		print_priority = decode(:BVPriorityID, 0,print_priority,:BVPriorityID)
//	AND		online_print_name = decode(:BVServicedRequestID,'*A',online_print_name ,:BVServicedRequestID)  //commented to support multiple billing services
	 AND     (:BVServicedRequestID = '*A'
	          OR (:BVServicedRequestID = 'RLRRSENQ' AND online_print_name LIKE 'RLR%')
			  OR (:BVServicedRequestID = 'BLRRSENQ' AND online_print_name LIKE 'BL%'))
		//Ravi Shankar, 07/10/2016, IN-62208
		OR (:BVServicedRequestID = 'O' 
		AND WS_NO IN (SELECT WS_NO FROM RL_RESULT_PRINT_OP_WSNO WHERE OPERATING_FACILITY_ID = DECODE(:BVFacilityID,'*A',OPERATING_FACILITY_ID,:BVFacilityID)) )
		OR (:BVServicedRequestID = 'N' 
		AND WS_NO NOT IN (SELECT WS_NO FROM RL_RESULT_PRINT_OP_WSNO WHERE OPERATING_FACILITY_ID = DECODE(:BVFacilityID,'*A',OPERATING_FACILITY_ID,:BVFacilityID)) )
		//////////////
	AND		PRINT_IMMEDIATE_YN = 'Y' 
	// Following code is changed by K S Sundar on Sep 01, 2003
	//AND		(PRINT_SUCCESS_YN IS NULL OR PRINT_SUCCESS_YN  = 'N')
	AND		PRINT_SUCCESS_YN IS NULL; */ 
 
	//ORDER	BY PRINT_PRIORITY;
	
	if ORACLE_ERROR 
	{
		sprintf(GVTraceMsg,"Error at DECLARE cursor : [%s]",sqlca.sqlerrm.sqlerrmc);
		RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName, "End");
		return 0;
	}

	/*
	* Open cursor.
	*/
	/* EXEC SQL OPEN REQUEST_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0016;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )364;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&BVFacilityID;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&BVFacilityID;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&BVPriorityID;
 sqlstm.sqhstl[2] = (unsigned int  )6;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&BVPriorityID;
 sqlstm.sqhstl[3] = (unsigned int  )6;
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
 sqlstm.sqhstv[8] = (         void  *)&BVFacilityID;
 sqlstm.sqhstl[8] = (unsigned int  )4;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&BVFacilityID;
 sqlstm.sqhstl[9] = (unsigned int  )4;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&BVServicedRequestID;
 sqlstm.sqhstl[10] = (unsigned int  )34;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&BVFacilityID;
 sqlstm.sqhstl[11] = (unsigned int  )4;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&BVFacilityID;
 sqlstm.sqhstl[12] = (unsigned int  )4;
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

 
	if ORACLE_ERROR 
	{
		sprintf(GVTraceMsg,"Error at OPEN cursor : [%s]",sqlca.sqlerrm.sqlerrmc);
		RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
		if (IS_TRACING) Trace(LVFunctionName, "End");
		return 0;
	}

	LVRequestCtr = 0;
	LVContinue = 1;

	while(LVContinue == 1)
	{
		
		/*
		* Initialize the bind variables.
				*/

		BVRequestFacilityID.arr[0]	= '\0';
		BVRequestFacilityID.len		= 0;

		BVModuleID.arr[0]			= '\0';
		BVModuleID.len				= 0;

		BVOnlinePrintName.arr[0]	= '\0';
		BVOnlinePrintName.len		= 0;

		BVOnlinePrintFileName.arr[0]= '\0';
		BVOnlinePrintFileName.len   = 0;
				
		BVLocationType.arr[0]       = '\0';
		BVLocationType.len          = 0;

		BVLocationCode.arr[0]       = '\0';
		BVLocationCode.len          = 0;

		BVPrintDate.arr[0]			= '\0';
		BVPrintDate.len				= 0;

		BVRowID.arr[0]				= '\0';
		BVRowID.len					= 0;

		BVWs_No.arr[0]				= '\0';
		BVWs_No.len					= 0;

		BVPrinter_ID.arr[0]			= '\0';
		BVPrinter_ID.len			= 0;

		BVPrinter_Name.arr[0]		= '\0';
		BVPrinter_Name.len			= 0;

		BVDest_Queue_Name.arr[0]	= '\0';
		BVDest_Queue_Name.len		= 0;

		/*
		* Fetch the record.
		*/
		/* Added by aparna
		   fetching operating facility id into new variable BVRequestFacilityID
		   which is passed as a parameter to printDocument.
		*/

		/* EXEC SQL 
		FETCH REQUEST_CUR INTO 
			:BVRequestFacilityID,
			:BVModuleID,
			:BVOnlinePrintName,
			:BVOnlinePrintFileName,
			:BVLocationType,
			:BVLocationCode,
			:BVPrintDate,
			:BVRowID,
			:BVWs_No,
			:BVPrinter_ID,
			:BVPrinter_Name,
			:BVDest_Queue_Name; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )431;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&BVRequestFacilityID;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&BVModuleID;
  sqlstm.sqhstl[1] = (unsigned int  )4;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&BVOnlinePrintName;
  sqlstm.sqhstl[2] = (unsigned int  )12;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&BVOnlinePrintFileName;
  sqlstm.sqhstl[3] = (unsigned int  )154;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&BVLocationType;
  sqlstm.sqhstl[4] = (unsigned int  )6;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&BVLocationCode;
  sqlstm.sqhstl[5] = (unsigned int  )10;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&BVPrintDate;
  sqlstm.sqhstl[6] = (unsigned int  )24;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&BVRowID;
  sqlstm.sqhstl[7] = (unsigned int  )33;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&BVWs_No;
  sqlstm.sqhstl[8] = (unsigned int  )33;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&BVPrinter_ID;
  sqlstm.sqhstl[9] = (unsigned int  )33;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&BVPrinter_Name;
  sqlstm.sqhstl[10] = (unsigned int  )63;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&BVDest_Queue_Name;
  sqlstm.sqhstl[11] = (unsigned int  )63;
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



		if (ORACLE_ERROR || ORACLE_NODATAFOUND)
		{
			/*
			* Register if error.
			*/
			if ORACLE_ERROR 
			{
				sprintf(GVTraceMsg,"Error at FETCH cursor : [%s]",sqlca.sqlerrm.sqlerrmc);
				RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
			}

			/*
			* No more records. Exit.
			*/
			LVContinue = 0;
			/* EXEC SQL CLOSE REQUEST_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )494;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		}
		else
		{
			/*
			* Process the record.
			*/
			LVRequestCtr = LVRequestCtr + 1;

			BVRequestFacilityID.arr[BVRequestFacilityID.len]		= '\0'; 
			BVModuleID.arr[BVModuleID.len]							= '\0'; 
			BVOnlinePrintName.arr[BVOnlinePrintName.len]			= '\0'; 
			BVOnlinePrintFileName.arr[BVOnlinePrintFileName.len]	= '\0'; 
			BVLocationType.arr[BVLocationType.len]					= '\0'; 
			BVLocationCode.arr[BVLocationCode.len]					= '\0'; 
			BVPrintDate.arr[BVPrintDate.len]						= '\0'; 
			BVRowID.arr[BVRowID.len]								= '\0'; 
			BVWs_No.arr[BVWs_No.len]								= '\0';
			BVPrinter_ID.arr[BVPrinter_ID.len]						= '\0';
			BVPrinter_Name.arr[BVPrinter_Name.len]					= '\0';
			BVDest_Queue_Name.arr[BVDest_Queue_Name.len]			= '\0';

			if (IS_TRACING) 
			{	
				sprintf(GVTraceMsg,"BVRequestFacilityID=[%s] BVModuleID=[%s] BVOnlinePrintName=[%s] BVOnlinePrintFileName=[%s] BVLocationType=[%s] BVLocationCode=[%s] BVPrintDate=[%s] BVRowID=[%s] BVWs_No=[%s] BVPrinter_ID=[%s] BVPrinter_Name=[%s] BVDest_Queue_Name=[%s]",
				BVRequestFacilityID.arr ,BVModuleID.arr, BVOnlinePrintName.arr, BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, BVPrintDate.arr, BVRowID.arr, BVWs_No.arr, BVPrinter_ID.arr, BVPrinter_Name.arr, BVDest_Queue_Name.arr);
				Trace(LVFunctionName,GVTraceMsg);
			}


			GVIsPrintSuccess = 0;

			/********************************************************************/
			/*			Reading Pro*C Output Directory 			  */
			/*	Copy some temporary value to BVerror_text.arr to avoid 	  */
			/*	Fetched Column Value is Null Error                 		  */
			/********************************************************************/

			strcpy (BVerror_text.arr, "$test$");
			BVerror_text.len = strlen (BVerror_text.arr);
			BVerror_text.arr[BVerror_text.len] = '\0';

			strcpy (BVReport_Output_Dir.arr, "$test$");
			BVReport_Output_Dir.len = strlen (BVReport_Output_Dir.arr);
			BVReport_Output_Dir.arr[BVReport_Output_Dir.len] = '\0';


			strcpy (BVUserId.arr, BVUidPwd.arr); 
			strcpy (BVUserId.arr, strtok (BVUserId.arr, "/")); 
			BVUserId.len = strlen (BVUserId.arr);
			BVUserId.arr[BVUserId.len] = '\0';

			if (IS_TRACING)
			{
				sprintf(GVTraceMsg,"Calling get_report_output_directory ... BVUserId=[%s] BVWorkstationID=[%s] BVNewVersionYN=[%s]...", BVUserId.arr, BVWorkstationID.arr,BVNewVersionYN.arr );
				Trace(LVFunctionName, GVTraceMsg);
			}
			if (strcmp(BVNewVersionYN.arr,"N") == 0)
			{	
				wordir=(char*) malloc(200* sizeof(char));
				i=GetPrivateProfileString("Reports","dir","",wordir,200,"medicom.ini");
				wordir[i]='\0';
				strcpy(BVReport_Output_Dir.arr,wordir);
				BVReport_Output_Dir.len = strlen(BVReport_Output_Dir.arr);
				if (IS_TRACING)
				{
					sprintf(GVTraceMsg,"BVReport_Output_Dir=[%s]",BVReport_Output_Dir.arr);
					Trace(LVFunctionName,GVTraceMsg);
				}

			}
			else
			{
				/* EXEC SQL EXECUTE
				BEGIN
					appprint.get_report_output_directory (
						:BVUserId,
						:BVWorkstationID,
						:BVReport_Output_Dir,
						:BVerror_text);
				END;
				END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin appprint . get_report_output_directory ( :BVUserId \
, :BVWorkstationID , :BVReport_Output_Dir , :BVerror_text ) ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )509;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&BVUserId;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&BVWorkstationID;
    sqlstm.sqhstl[1] = (unsigned int  )66;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&BVReport_Output_Dir;
    sqlstm.sqhstl[2] = (unsigned int  )122;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&BVerror_text;
    sqlstm.sqhstl[3] = (unsigned int  )503;
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
			if (IS_TRACING)
			{
				sprintf(GVTraceMsg,"BVUserId = [%s] BVWorkstationID=[%s]  BVReport_Output_Dir=[%s]  BVerror_text=[%s]  ",BVUserId.arr,BVWorkstationID.arr,BVReport_Output_Dir.arr,BVerror_text.arr);
				Trace(LVFunctionName,GVTraceMsg);
			}
			/********************************************************************/
			/*	Check the return value of BVerror_text.arr and if it is	  */
			/*	not equal to the Passed temporary value, raise an error       */
			/********************************************************************/

			BVerror_text.arr[BVerror_text.len] = '\0';
			if ( (BVerror_text.len > 0) && (strcmp (BVerror_text.arr, "$test$")) )
			{
			   sprintf (GVTraceMsg, "Error in Open_log_file (): %s", BVerror_text.arr);
			   RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVOnlinePrintName.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "",LVFunctionName, GVTraceMsg);
			   break;
			}

			BVReport_Output_Dir.arr[BVReport_Output_Dir.len] = '\0';
			if ( (BVReport_Output_Dir.len > 0) && (!strcmp (BVReport_Output_Dir.arr, "$test$")) )
			{
				sprintf (GVTraceMsg, "Report Directory Name not defined for %s Application User and/or %s Workstation",
					BVUserId.arr, BVReport_Output_Dir.arr);
				RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVOnlinePrintName.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "",LVFunctionName, GVTraceMsg);
				break;
			}

			if (sqlca.sqlcode == 1405 )
			{
				sprintf (GVTraceMsg, "Report Output Directory not defined");
				if (IS_TRACING)
				{
					sprintf(GVTraceMsg,"Report Output Directory not defined");
					RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVOnlinePrintName.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "",LVFunctionName, GVTraceMsg);
					break;
				}
			}

			/*
			* Check if the file exists.
			* Call PrintDocument if file exists.
			*/
			if ((fp = fopen (BVOnlinePrintFileName.arr, "r")) == NULL)
			{
				GetMEDICOMMessage("SY2435",GVErrorMessage);
				sprintf (GVTraceMsg, "APP-SY2435 %s", GVErrorMessage);
				RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVOnlinePrintName.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "",LVFunctionName, GVTraceMsg);
			}
			else
			{ 
				fclose(fp);

				/*
				* Following code is added by S. Sundar on Dec 12, 2005
				* to enable explicit printing
				*/

				if (BVPrinter_ID.len > 0)
				{
					/* Explicit Printing */
					if (IS_TRACING) 
					{
						sprintf(GVTraceMsg,"Calling SMTPRINT ...");
						Trace(LVFunctionName,GVTraceMsg);
					} 

					/*
					* Assign " " to BVLocationCode if NULL
					* This is a requirement of SMTPRINT.
					*/
					if (strlen(BVLocationCode.arr) == 0)
					{
						strcpy(BVLocationCode.arr," ");
						BVLocationCode.len = strlen(BVLocationCode.arr);
					}

					strcpy(GVPgmName, "SMTPRINT");
					sprintf
					(
						GVArguments, " %s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%d;%d;%d", 
						BVUidPwd.arr, BVWorkstationID.arr, BVFacilityID.arr, 
						BVModuleID.arr, BVDocumentID.arr, BVOnlinePrintFileName.arr,
						BVLocationType.arr, BVLocationCode.arr, 
						BVPrinter_ID.arr,
						BVPrinter_Name.arr,
						BVDest_Queue_Name.arr,
						1, 
						1, 
						9999
					);

					if (IS_TRACING)
					{
						sprintf(GVCmd,"Calling %s%s",GVPgmName, GVArguments);
						Trace(LVFunctionName, GVCmd);
					}

					LVProcessReturnCode = InvokeProcess(GVPgmName, GVArguments);
					if (LVProcessReturnCode)	// 1=Success   0=Failure
						GVIsPrintSuccess = 1;	// 1=Success   0=Failure
					else
						GVIsPrintSuccess = 0;

				}
				else
				{
					if (IS_TRACING) 
					{
						sprintf(GVTraceMsg,"Calling Print Document ...");
						Trace(LVFunctionName,GVTraceMsg);
					} 

					/*
					* Call WSPrintDocument function to print the document.
					* BVWs_No passes WORKSTATION NO of user who submit the
					* print job.

					* BVReport_Output_Dir pass the, Report Out Put Directory
					* for the current Worksation.Ie,, where the SMTPRSRV
					* process is running.
					*/
					GVSpawnReturnCode =  WSPrintDocument 
					(
							BVUidPwd.arr,
							BVSessionID.arr,
							BVRequestFacilityID.arr,
							BVModuleID.arr,
							BVOnlinePrintName.arr,
							BVOnlinePrintFileName.arr,
							BVLocationType.arr,
							BVLocationCode.arr,
							1,
							1,
							99,
							BVWs_No.arr,
							BVReport_Output_Dir.arr
					);
				
					if (!GVSpawnReturnCode)
						GVIsPrintSuccess = 1;
					else
						GVIsPrintSuccess = 0;

				}


				if (IS_TRACING)
				{
					sprintf(GVTraceMsg,"Printing Success?=[%d]",GVIsPrintSuccess);
					Trace(LVFunctionName,GVTraceMsg);
				}
			}

			/*
			* Reset GVProramID, since it is a global
			* variable.
			*/
			strcpy(GVProgramID , "SMTPRSRV");						
			IS_TRACING = GVIsTracing;

			/*
			* Update SY_REPORT_PRINT_REQUEST with printing status.
			* PRINT_SUCCESS_YN = 'Y' if success
			* PRINT_SUCCESS_YN = 'N' if failed
			*/
			if (GVIsPrintSuccess)
			{
				if (BVPrintDate.len != 0)
				{
					if (IS_TRACING) Trace(LVFunctionName,"Updating SY_REPORT_PRINT_REQUEST.PRINT_SUCCESS_YN to Y");
					/* EXEC SQL 
					UPDATE	SY_REPORT_PRINT_REQUEST
					SET		PRINT_SUCCESS_YN = 'Y',
							REPRINT_DATE = SYSDATE
					WHERE	Rowid = :BVRowID; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 13;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update SY_REPORT_PRINT_REQUEST  set PRINT_SUCCESS_YN='Y'\
,REPRINT_DATE=SYSDATE where Rowid=:b0";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )540;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&BVRowID;
     sqlstm.sqhstl[0] = (unsigned int  )33;
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


				}
				else
				{
					/* 
					* Printed through REPRINT option of Administer function 
					*/
					if (IS_TRACING) Trace(LVFunctionName,"Updating SY_REPORT_PRINT_REQUEST.PRINT_SUCCESS_YN to Y, REPRINT_DATE to SYSDATE");
					/* EXEC SQL 
					UPDATE	SY_REPORT_PRINT_REQUEST
					SET		PRINT_SUCCESS_YN = 'Y',
							PRINT_DATE = SYSDATE
					WHERE	Rowid = :BVRowID; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 13;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "update SY_REPORT_PRINT_REQUEST  set PRINT_SUCCESS_YN='Y'\
,PRINT_DATE=SYSDATE where Rowid=:b0";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )559;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&BVRowID;
     sqlstm.sqhstl[0] = (unsigned int  )33;
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


				}
			}
			else
			{
				if (IS_TRACING) Trace(LVFunctionName,"Updating SY_REPORT_PRINT_REQUEST.PRINT_SUCCESS_YN to N");
				/* EXEC SQL 
				UPDATE	SY_REPORT_PRINT_REQUEST
				SET		PRINT_SUCCESS_YN = 'N'
				WHERE	Rowid = :BVRowID; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update SY_REPORT_PRINT_REQUEST  set PRINT_SUCCESS_YN='N' \
where Rowid=:b0";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )578;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&BVRowID;
    sqlstm.sqhstl[0] = (unsigned int  )33;
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


			}
			if (OERROR || NODATAFOUND ||  RESOURCE_BUSY ) 
			{
				sprintf(GVTraceMsg,"Error UPDATE sy_report_print_request : [%s]",sqlca.sqlerrm.sqlerrmc);
				RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVOnlinePrintName.arr,  BVOnlinePrintFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "",LVFunctionName, GVTraceMsg);
			}
		}

		/*
		* Save the changes.
		*/
		/* EXEC SQL COMMIT; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )597;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	} /* while(LVContinue == 1) */

	if (LVRequestCtr == 0)
	{
		if (IS_TRACING) Trace(LVFunctionName,"No pending requests !!");
	}

	if (IS_TRACING)  Trace(LVFunctionName,"End");

} /* End of ProcessPendingRequests */


