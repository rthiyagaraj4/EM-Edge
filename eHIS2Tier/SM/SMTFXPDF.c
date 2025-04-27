
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
           char  filnam[40];
};
static const struct sqlcxp sqlfpn =
{
    39,
    "D:\\SampleProcProgs\\SMTFXPDF\\SMTFXPDF.pc"
};


static unsigned long sqlctx = 611075339;


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
            void  *sqhstv[12];
   unsigned int   sqhstl[12];
            int   sqhsts[12];
            void  *sqindv[12];
            int   sqinds[12];
   unsigned int   sqharm[12];
   unsigned int   *sqharc[12];
   unsigned short  sqadto[12];
   unsigned short  sqtdso[12];
} sqlstm = {10,12};

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
"select PDF_FILE_NAME  from SM_PDF_GENERATE_REQUEST where (REQUEST_STATUS is \
 not null  and (SYSDATE-PDF_GENERATION_DATE)>=2)           ";

 static const char *sq0010 = 
"select REQUEST_SRL_NO ,MAIL_REQUEST_SRL_NO ,OPERATING_FACILITY_ID ,USER_ID ,\
WORKSTATION_ID ,REPORT_ID ,ROWID ,REPORT_TYPE ,REPORT_TEXT ,PDF_NAME ,REQUEST_\
STATUS ,PDF_PASSWORD  from SM_PDF_GENERATE_REQUEST where (operating_facility_i\
d=decode(:b0,'*A',operating_facility_id,:b0) and request_status is null )     \
      ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,261,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,83,0,6,304,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
59,0,0,3,76,0,4,345,0,0,1,0,0,1,0,2,3,0,0,
78,0,0,4,260,0,4,389,0,0,6,4,0,1,0,2,1,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
117,0,0,5,129,0,4,446,0,0,1,0,0,1,0,2,3,0,0,
136,0,0,6,135,0,9,477,0,0,0,0,0,1,0,
151,0,0,6,0,0,13,494,0,0,1,0,0,1,0,2,9,0,0,
170,0,0,6,0,0,15,507,0,0,0,0,0,1,0,
185,0,0,7,111,0,2,516,0,0,0,0,0,1,0,
200,0,0,8,0,0,29,530,0,0,0,0,0,1,0,
215,0,0,9,109,0,6,581,0,0,1,1,0,1,0,2,9,0,0,
234,0,0,10,316,0,9,632,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
257,0,0,0,0,0,69,689,0,0,1,1,0,1,0,3,112,0,0,
276,0,0,0,0,0,109,691,0,0,1,1,0,1,0,3,112,2,0,
295,0,0,10,0,0,13,698,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,112,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
358,0,0,10,0,0,15,728,0,0,0,0,0,1,0,
373,0,0,11,124,0,6,797,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,3,9,0,0,3,9,0,0,
404,0,0,0,0,0,114,861,0,0,2,1,0,1,0,1,112,0,0,2,3,0,7,
427,0,0,0,0,0,103,863,0,0,1,1,0,1,0,3,112,0,0,
446,0,0,0,0,0,110,895,0,0,5,4,0,1,0,3,68,0,0,1,112,0,0,1,3,0,0,3,1,0,0,0,10,0,
0,
481,0,0,0,0,0,102,908,0,0,1,1,0,1,0,3,112,0,0,
500,0,0,0,0,0,98,910,0,0,1,1,0,1,0,3,112,0,0,
519,0,0,0,0,0,77,912,0,0,1,1,0,1,0,3,112,0,0,
538,0,0,12,89,0,6,924,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
561,0,0,13,85,0,4,1011,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
584,0,0,14,120,0,5,1026,0,0,3,3,0,1,0,1,1,0,0,1,1,0,0,1,9,0,0,
611,0,0,15,139,0,5,1037,0,0,3,3,0,1,0,1,1,0,0,1,1,0,0,1,9,0,0,
638,0,0,16,93,0,5,1048,0,0,1,1,0,1,0,1,9,0,0,
657,0,0,17,0,0,29,1064,0,0,0,0,0,1,0,
};


/************************************************************************************
*    
*	Name			SMTFXPDF.PC
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
*	
*
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
# include <oci.h>

/*
* Define constants.
*/
# define OERROR			(sqlca.sqlcode < 0)
# define RESOURCE_BUSY  (sqlca.sqlcode == 54)
# define NODATAFOUND sqlca.sqlcode==1403

void	ProcessPDF(void);		
void	PurgeOldRequests(void);
int		RestartProgram(void);					

HWND		hwnd;
WNDCLASS	wndclass;

char GVErrorMessage[200];
char GVArguments[512];
char GVPgmName[64];
char GVCmd[1024];
int  GVSpawnReturnCode = 1;
int  GVIsCreationSuccess = 0;
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
	char	 BVMachneNme[16];
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

	//varchar  BVRowID[31];

	//varchar	 BVRequestFacilityID [2];			// Added by Aparna -- Cursor parameter 
	/* varchar	 BVWorkstationID[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVWorkstationID;

	/* varchar  BVFileName[152]; */ 
struct { unsigned short len; unsigned char arr[152]; } BVFileName;

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

	/* varchar  BVRequestSerialNumber[15]; */ 
struct { unsigned short len; unsigned char arr[15]; } BVRequestSerialNumber;

	/* varchar  BVMailRequestSerialNo[15]; */ 
struct { unsigned short len; unsigned char arr[15]; } BVMailRequestSerialNo;

	/* varchar  BVRequestFacilityID[3]; */ 
struct { unsigned short len; unsigned char arr[3]; } BVRequestFacilityID;

	/* varchar  BVUserID[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } BVUserID;

	/* varchar  BVMachineName[16]; */ 
struct { unsigned short len; unsigned char arr[16]; } BVMachineName;

	/* varchar  BVWorkStationID[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } BVWorkStationID;

	/* varchar  BVProgramID[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } BVProgramID;

	/* varchar  BVRowID[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } BVRowID;

	/* varchar  BVReportType[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } BVReportType;

	/* varchar  BVPdfName[150]; */ 
struct { unsigned short len; unsigned char arr[150]; } BVPdfName;

	/* varchar  BVRequestStatus[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } BVRequestStatus;

	/* varchar  BVPdfPassword[65]; */ 
struct { unsigned short len; unsigned char arr[65]; } BVPdfPassword;

	/* varchar  BVPassword[65]; */ 
struct { unsigned short len; unsigned char arr[65]; } BVPassword;

	/* varchar GVRequestStatus[50]; */ 
struct { unsigned short len; unsigned char arr[50]; } GVRequestStatus;

	
	long	 BVSleepTime;
	int      BVNoOfPendingRequests;

	/* Variables to read clob data */

	OCIClobLocator *BVReportText;
	int clob_len=0 , offset = 1;

	/*buffer to store the BLOB value and then write to the file from*/
		
	unsigned int amt=0 ;
	unsigned char buffer[500] ;
	
	/* EXEC SQL VAR buffer IS VARCHAR2(500); */ 


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
	strcpy(BVDocumentID.arr,"SMTFXPDF");			
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
	wndclass.lpszClassName	= "Generating Pdf";
	RegisterClass ( &wndclass );

	hwnd = CreateWindow("Fax Print Server",(LPSTR)NULL,
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
	strcpy(GVProgramID , "SMTFXPDF");	
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
		RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
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
	WHERE	pgm_id = 'SMTFXPDF'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select processing_interval into :b0  from sy_prog_id where p\
gm_id='SMTFXPDF'";
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
		RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
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
		
		if (IS_TRACING) Trace (LVFunctionName,"Calling ProcessPDF() ...");
		ProcessPDF();

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
		INTO	:BVMachneNme, :BVStartedByID
		FROM	SY_BG_PROCESS_CONTROL
		WHERE	operating_facility_id = :BVFacilityID
		AND		pgm_id  = 'SMTFXPDF' 
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
_PROCESS_CONTROL where (((((operating_facility_id=:b2 and pgm_id='SMTFXPDF') a\
nd priority=:b3) and serviced_requests=:b4) and STARTED_DATE is  not null ) an\
d TO_CHAR(STARTED_DATE,'DDMMYYHH24MISS')=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )78;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)BVMachneNme;
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
*	Function	PurgeOldRequests
*
*	Author		K S Sundar
*
*	Date		May 11, 2003
*
*	Purpose		Purges the following for processed requests, 
*					which are older than 2 days:
*				1. Physical files
*				3. Print requsts from SM_PDF_GENERATE_REQUST
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

	/* EXEC SQL  
	SELECT	COUNT(*) 
	INTO	:BVNoOfPendingRequests 
	FROM	SM_PDF_GENERATE_REQUEST
	WHERE	REQUEST_STATUS IS NOT NULL 
	AND		SYSDATE - PDF_GENERATION_DATE >= 2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(*)  into :b0  from SM_PDF_GENERATE_REQUEST wher\
e (REQUEST_STATUS is  not null  and (SYSDATE-PDF_GENERATION_DATE)>=2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )117;
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
		SELECT  PDF_FILE_NAME
		FROM    SM_PDF_GENERATE_REQUEST
		WHERE   REQUEST_STATUS IS NOT NULL 
		AND		SYSDATE - PDF_GENERATION_DATE >= 2; */ 
  

		if ORACLE_ERROR 
		{
			sprintf(GVTraceMsg,"Error at DECLARE cursor : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
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
  sqlstm.stmt = sq0006;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )136;
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
			RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
			if (IS_TRACING) Trace(LVFunctionName, "End");
			return 0;
		}

		/*
		* Purge the physical files which are older than 2 days.
		*/
		while(LVContinue!=0)
		{
			BVFileName.arr[0] = '\0';
			BVFileName.len    = 0;

			/* EXEC SQL FETCH DEL_CUR INTO :BVFileName; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )151;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&BVFileName;
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
					RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
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
    sqlstm.offset = (unsigned int  )170;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			}
			else
			{
				BVFileName.arr[BVFileName.len] = '\0';
				DeleteFile(BVFileName.arr);
			}
		}

		/* EXEC SQL 
		DELETE 
		FROM	SM_PDF_GENERATE_REQUEST
		WHERE	REQUEST_STATUS IS NOT NULL 
		AND 	SYSDATE - PDF_GENERATION_DATE >= 2; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from SM_PDF_GENERATE_REQUEST  where (REQUEST_STATUS\
 is  not null  and (SYSDATE-PDF_GENERATION_DATE)>=2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )185;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (ORACLE_ERROR)
		{
			sprintf(GVTraceMsg,"Error at DELETE from SM_PDF_GENERATE_REQUEST : [%s]",sqlca.sqlerrm.sqlerrmc);
			RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","Calculate Elapsed Time", GVTraceMsg);
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
  sqlstm.offset = (unsigned int  )200;
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
*	Function	ProcessPDF
*
*	Author		K S Sundar
*
*	Date		May 11, 2003
*
*	Purpose		Processes the pending requests as follows:
*
*				For each fax mail to be sent,
*				1. Creates a PDF file by taking the data from the ( SM_PDF_GENERATE_REQUEST ) table.
*				2. Updates SM_PDF_GENERATE_REQUEST.REQUEST_STATUS with file creation status. 
*
*/
void ProcessPDF(void)
{
	/* Variables used for text file creation of PDF */

	/* EXEC SQL BEGIN DECLARE SECTION; */ 

		char in_filename[80] = "\0";
	    char out_filename[80] = "\0";
	/* EXEC SQL END DECLARE SECTION; */ 


	FILE *fp;
	//Upto here
	
	int		LVContinue,i;
	int		LVRequestCtr;
	char	LVFunctionName[30];
	char	*wordir;
	int	 LVProcessReturnCode;

	if (IS_TRACING) 
	{
		strcpy(LVFunctionName,"ProcessPDF");
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
  sqlstm.offset = (unsigned int  )215;
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
	* Declare cursor for pending PDF requests.
	*/

	/* EXEC SQL  
	DECLARE REQUEST_CUR CURSOR  FOR
	SELECT  REQUEST_SRL_NO,
			MAIL_REQUEST_SRL_NO,
			OPERATING_FACILITY_ID,
			USER_ID,
			WORKSTATION_ID,
			REPORT_ID,
			ROWID,
			REPORT_TYPE,
			REPORT_TEXT,
			PDF_NAME,
			REQUEST_STATUS,
			PDF_PASSWORD
	FROM    SM_PDF_GENERATE_REQUEST
	WHERE   operating_facility_id = decode(:BVFacilityID,'*A',operating_facility_id ,:BVFacilityID)
	AND		request_status IS NULL; */ 


	if ORACLE_ERROR 
	{
		sprintf(GVTraceMsg,"Error at DECLARE cursor : [%s]",sqlca.sqlerrm.sqlerrmc);
		RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
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
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0010;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )234;
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
		RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
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

		BVRequestSerialNumber.arr[0]= '\0';
		BVRequestSerialNumber.len	= 0;

		BVMailRequestSerialNo.arr[0]= '\0';
		BVMailRequestSerialNo.len	= 0;

		BVRequestFacilityID.arr[0]	= '\0';
		BVRequestFacilityID.len		= 0;

		BVUserID.arr[0]				= '\0';
		BVUserID.len				= 0;

		BVMachineName.arr[0]		= '\0';
		BVMachineName.len			= 0;

		BVWorkStationID.arr[0]		= '\0';
		BVWorkStationID.len			= 0;

		BVProgramID.arr[0]			= '\0';
		BVProgramID.len				= 0;

		BVRowID.arr[0]				= '\0';
		BVRowID.len					= 0;

		BVReportType.arr[0]			= '\0';
		BVReportType.len			= 0;

		BVPdfName.arr[0]			= '\0';
		BVPdfName.len				= 0;

		BVRequestStatus.arr[0]		= '\0';
		BVRequestStatus.len			= 0;

		BVPdfPassword.arr[0]		= '\0';
		BVPdfPassword.len			= 0;

			/* Allocate the CLOB host variable and select a CLOB which we will READ */

			/* EXEC SQL ALLOCATE :BVReportText ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )257;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&BVReportText;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(void *);
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


	
			/* EXEC SQL LOB OPEN :BVReportText READ WRITE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )276;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&BVReportText;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(void *);
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


			// Upto Here

		/*
		* Fetch the record.
		*/

		/* EXEC SQL 
		FETCH REQUEST_CUR INTO 
			:BVRequestSerialNumber,
			:BVMailRequestSerialNo,
			:BVRequestFacilityID,	
			:BVUserID,						
			:BVWorkStationID,		
			:BVProgramID,			
			:BVRowID,
			:BVReportType,			
			:BVReportText,			
			:BVPdfName,				
			:BVRequestStatus,
			:BVPdfPassword; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )295;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&BVRequestSerialNumber;
  sqlstm.sqhstl[0] = (unsigned int  )17;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&BVMailRequestSerialNo;
  sqlstm.sqhstl[1] = (unsigned int  )17;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&BVRequestFacilityID;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&BVUserID;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&BVWorkStationID;
  sqlstm.sqhstl[4] = (unsigned int  )33;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&BVProgramID;
  sqlstm.sqhstl[5] = (unsigned int  )33;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&BVRowID;
  sqlstm.sqhstl[6] = (unsigned int  )33;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&BVReportType;
  sqlstm.sqhstl[7] = (unsigned int  )4;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&BVReportText;
  sqlstm.sqhstl[8] = (unsigned int  )sizeof(void *);
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&BVPdfName;
  sqlstm.sqhstl[9] = (unsigned int  )152;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&BVRequestStatus;
  sqlstm.sqhstl[10] = (unsigned int  )4;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&BVPdfPassword;
  sqlstm.sqhstl[11] = (unsigned int  )67;
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
				RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
			}
	
			/*
			* No more records. Exit.
			*/
			LVContinue = 0;
			/* EXEC SQL CLOSE REQUEST_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )358;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		}
		else
		{
			BVRequestSerialNumber.arr[BVRequestSerialNumber.len]	= '\0';
			BVPdfName.arr[BVPdfName.len]							= '\0';
			
			BVRequestFacilityID.arr[BVRequestFacilityID.len]		= '\0'; 
			BVUserID.arr[BVUserID.len]								= '\0'; 
			BVWorkStationID.arr[BVWorkStationID.len]				= '\0'; 
			BVProgramID.arr[BVProgramID.len]						= '\0'; 
			BVRowID.arr[BVRowID.len]								= '\0';
			BVRequestStatus.arr[BVRequestStatus.len]				= '\0';
			BVReportType.arr[BVReportType.len]						= '\0';
			BVPdfPassword.arr[BVPdfPassword.len]					= '\0';

			if (IS_TRACING) 
			{	
				sprintf(GVTraceMsg,"BVRequestSerialNumber=[%s] BVRequestFacilityID=[%s] BVUserID=[%s] BVWorkStationID=[%s] BVProgramID=[%s] BVReportType=[%s] ",
				BVRequestSerialNumber.arr ,BVRequestFacilityID.arr, BVUserID.arr, BVWorkStationID.arr, BVProgramID.arr, BVReportType.arr);
				Trace(LVFunctionName,GVTraceMsg);
			}

			/*
			* Process the record.
			*/

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
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin appprint . get_report_output_directory ( :BVUserId \
, :BVWorkstationID , :BVReport_Output_Dir , :BVerror_text ) ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )373;
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
			   RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVOnlinePrintName.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "",LVFunctionName, GVTraceMsg);
			   break;
			}

			BVReport_Output_Dir.arr[BVReport_Output_Dir.len] = '\0';
			if ( (BVReport_Output_Dir.len > 0) && (!strcmp (BVReport_Output_Dir.arr, "$test$")) )
			{
				sprintf (GVTraceMsg, "Report Directory Name not defined for %s Application User and/or %s Workstation",
					BVUserId.arr, BVReport_Output_Dir.arr);
				RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVOnlinePrintName.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "",LVFunctionName, GVTraceMsg);
				break;
			}

			if (sqlca.sqlcode == 1405 )
			{
				sprintf (GVTraceMsg, "Report Output Directory not defined");
				if (IS_TRACING)
				{
					sprintf(GVTraceMsg,"Report Output Directory not defined");
					RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVOnlinePrintName.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "",LVFunctionName, GVTraceMsg);
					break;
				}
			}

			//Upto Here (ReportOutputDirectory)
						
			strcpy(in_filename,"\0");

			strcpy(in_filename, BVReport_Output_Dir.arr);
			strcat(in_filename, BVPdfName.arr);
			strcat(in_filename, "-");
			strcat(in_filename, BVRequestSerialNumber.arr);
			
			if  ( strcmp(strlwr(BVReportType.arr),"t") == 0 )  
				strcat(in_filename, ".txt");
			else
				strcat(in_filename, ".html");
			
			/* --- Handling the clob variable --- */
			/* EXEC SQL LOB DESCRIBE :BVReportText GET LENGTH into :clob_len; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )404;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&BVReportText;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(void *);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&clob_len;
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



			/* EXEC SQL LOB ENABLE BUFFERING :BVReportText; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )427;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&BVReportText;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(void *);
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

 
				
			fp = fopen ( in_filename, "w" );

			if(fp == NULL)
			{
				if (IS_TRACING) 
				{
					sprintf(GVTraceMsg,"Error while opening file ...");
					Trace(LVFunctionName,GVTraceMsg);
				} 	
			}
			else
			{	
				if (IS_TRACING) 
				{
					sprintf(GVTraceMsg,"File Opened successfully ...");
					Trace(LVFunctionName,GVTraceMsg);
				}
			}
			
			if (clob_len < 500) 
				amt = clob_len;
			else
				amt = 500 ;

			offset = 1;
			clob_len = clob_len + 1;

			while (offset < clob_len)
			{

				/* EXEC SQL LOB READ :amt FROM :BVReportText AT :offset INTO :buffer; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )446;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&BVReportText;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(void *);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&offset;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)buffer;
    sqlstm.sqhstl[3] = (unsigned int  )500;
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


								
				fwrite(buffer, 1, amt, fp);

				offset = offset + amt;
										
				if ((clob_len-offset) < 500) 
					amt = (clob_len - offset);
				else
					amt = 500 ;

			}

			/* EXEC SQL LOB DISABLE BUFFERING :BVReportText; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )481;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&BVReportText;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(void *);
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

 

			/* EXEC SQL LOB CLOSE :BVReportText; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )500;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&BVReportText;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(void *);
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

 

			/* EXEC SQL FREE :BVReportText; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )519;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&BVReportText;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(void *);
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

 

			fclose(fp);

			/* --- Upto Here --- */

			LVRequestCtr = LVRequestCtr + 1;
	
			/* Getting decrypted password */
			BVPassword.arr[0]		= '\0';
			BVPassword.len			= 0;
			
			/* EXEC SQL EXECUTE   
				BEGIN    
					SELECT APP_PASSWORD.DECRYPT(:BVPdfPassword) 
					INTO :BVPassword
					FROM DUAL;
				END;
			END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin SELECT APP_PASSWORD . DECRYPT ( :BVPdfPassword ) INT\
O :BVPassword FROM DUAL ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )538;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&BVPdfPassword;
   sqlstm.sqhstl[0] = (unsigned int  )67;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&BVPassword;
   sqlstm.sqhstl[1] = (unsigned int  )67;
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



			if (IS_TRACING)
			{
				sprintf(GVTraceMsg,"BVUserId = [%s] BVWorkstationID=[%s]  BVPdfPassword=[%s] ",BVUserId.arr,BVWorkstationID.arr,BVPdfPassword.arr);
				Trace(LVFunctionName,GVTraceMsg);
			}

			BVPassword.arr[BVPassword.len] = '\0';

			GVIsCreationSuccess = 0;

			/*Report Output Directory part moved to front */

			/*
			* Check if the file exists.
			* Call PrintDocument if file exists.
			*/
			if ((fp = fopen (in_filename, "r")) == NULL)
			{
				GetMEDICOMMessage("SY2435",GVErrorMessage);
				sprintf (GVTraceMsg, "APP-SY2435 %s", GVErrorMessage);
				RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVOnlinePrintName.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "",LVFunctionName, GVTraceMsg);
			}
			else
			{ 
				fclose(fp);

				if (IS_TRACING) 
				{
					sprintf(GVTraceMsg,"Calling PDFUtility Program ...");
					Trace(LVFunctionName,GVTraceMsg);
				} 
				
				strcpy(out_filename,"\0");

				strcpy(out_filename, BVReport_Output_Dir.arr);
				strcat(out_filename, BVPdfName.arr);
				strcat(out_filename, "-");
				strcat(out_filename, BVRequestSerialNumber.arr);
				strcat(out_filename,".pdf");
					
				sprintf
				(
					GVArguments, "%s %s %s %s %s %s %s",
					"java","sam", in_filename, out_filename, BVReportType.arr, BVPassword.arr, BVRequestSerialNumber.arr
				);
					
				if (IS_TRACING)
				{
					sprintf(GVCmd,"Calling %s",GVArguments);
					Trace(LVFunctionName, GVCmd);
				}

				LVProcessReturnCode = system(GVArguments);
					
				if (LVProcessReturnCode)	// 1=Success   0=Failure
					GVIsCreationSuccess = 0;	// 1=Success   0=Failure
				else
					GVIsCreationSuccess = 1;

			}

			if (IS_TRACING)
			{
				sprintf(GVTraceMsg,"Creation Success?=[%d]",GVIsCreationSuccess);
				Trace(LVFunctionName,GVTraceMsg);
			}
			/*
			* Reset GVProramID, since it is a global
			* variable.
			*/
			strcpy(GVProgramID , "SMTFXPDF");						
			IS_TRACING = GVIsTracing;

			/*
			* Update SM_PDF_GENERATE_REQUEST with creation status.
			* REQUEST_STATUS = 'Y' if success
			* REQUEST_STATUS = 'E' if failed
			*/
			
			/* EXEC SQL 
			SELECT 	REQUEST_STATUS
			INTO	:GVRequestStatus
			FROM	SM_PDF_GENERATE_REQUEST
			WHERE	REQUEST_SRL_NO = :BVRequestSerialNumber; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select REQUEST_STATUS into :b0  from SM_PDF_GENERATE_REQUE\
ST where REQUEST_SRL_NO=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )561;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&GVRequestStatus;
   sqlstm.sqhstl[0] = (unsigned int  )52;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&BVRequestSerialNumber;
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

 

			if ORACLE_ERROR 
			{
				sprintf(GVTraceMsg,"Error at SELECT request status SM_PDF_GENERATE_REQUEST : [%s]",sqlca.sqlerrm.sqlerrmc);
				RegisterError(BVFacilityID.arr, BVModuleID1.arr, BVWorkstationID.arr, BVDocumentID.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "","WORKSTATION.get_workstation_id", GVTraceMsg);
				BVSleepTime = 0;
			}
			
			if ( strcmp(GVRequestStatus.arr,"Y") == 0)
			{
				/* EXEC SQL 
				UPDATE	SM_PDF_GENERATE_REQUEST
				SET		PDF_GENERATION_DATE = SYSDATE,
						TXT_HTML_FILE_NAME = :in_filename,
						PDF_FILE_NAME = :out_filename
				WHERE	Rowid = :BVRowID; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update SM_PDF_GENERATE_REQUEST  set PDF_GENERATION_DATE=S\
YSDATE,TXT_HTML_FILE_NAME=:b0,PDF_FILE_NAME=:b1 where Rowid=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )584;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)in_filename;
    sqlstm.sqhstl[0] = (unsigned int  )80;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)out_filename;
    sqlstm.sqhstl[1] = (unsigned int  )80;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&BVRowID;
    sqlstm.sqhstl[2] = (unsigned int  )33;
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


	
				/* Delete the intermediate file(txt/html) once the pdf is generated */
				DeleteFile(in_filename);

				if (IS_TRACING) Trace(LVFunctionName,"Updating SM_REPORT_FAX_MAIL_REQUEST.ATTACHMENT_REQUEST_STATUS to S");
				/* EXEC SQL 
				UPDATE	SM_REPORT_FAX_MAIL_REQUEST
				SET		ATTACHMENT_FILE_NAME = :out_filename,
						REPORT_FILE_NAME = :out_filename,
						ATTACHMENT_REQUEST_STATUS = 'S'							
				WHERE	REQUEST_SRL_NO = :BVMailRequestSerialNo; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update SM_REPORT_FAX_MAIL_REQUEST  set ATTACHMENT_FILE_NA\
ME=:b0,REPORT_FILE_NAME=:b0,ATTACHMENT_REQUEST_STATUS='S' where REQUEST_SRL_NO\
=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )611;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)out_filename;
    sqlstm.sqhstl[0] = (unsigned int  )80;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)out_filename;
    sqlstm.sqhstl[1] = (unsigned int  )80;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&BVMailRequestSerialNo;
    sqlstm.sqhstl[2] = (unsigned int  )17;
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
			else
			{
				if (IS_TRACING) Trace(LVFunctionName,"Updating SM_REPORT_FAX_MAIL_REQUEST.REQUEST_STATUS to E");
				/* EXEC SQL 
				UPDATE	SM_REPORT_FAX_MAIL_REQUEST
				SET		ATTACHMENT_REQUEST_STATUS = 'E'
				WHERE	REQUEST_SRL_NO = :BVMailRequestSerialNo; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update SM_REPORT_FAX_MAIL_REQUEST  set ATTACHMENT_REQUEST\
_STATUS='E' where REQUEST_SRL_NO=:b0";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )638;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&BVMailRequestSerialNo;
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



			}
			if (OERROR || NODATAFOUND ||  RESOURCE_BUSY ) 
			{
				sprintf(GVTraceMsg,"Error UPDATE SM_PDF_GENERATE_REQUEST : [%s]",sqlca.sqlerrm.sqlerrmc);
				RegisterError(BVFacilityID.arr, BVModuleID.arr, BVWorkstationID.arr, BVOnlinePrintName.arr,  BVFileName.arr, BVLocationType.arr, BVLocationCode.arr, "", "", "",LVFunctionName, GVTraceMsg);
			}
		}

		/*
		* Save the changes.
		*/
		/* EXEC SQL COMMIT; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )657;
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

} /* End of ProcessPDF */


