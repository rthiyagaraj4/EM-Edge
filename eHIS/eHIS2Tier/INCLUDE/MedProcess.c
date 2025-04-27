
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
           char  filnam[43];
};
static const struct sqlcxp sqlfpn =
{
    42,
    "D:\\WORK\\ML-MMOH-CRF-0578\\DGB\\MedProcess.pc"
};


static unsigned long sqlctx = 1466745923;


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
            void  *sqhstv[1];
   unsigned int   sqhstl[1];
            int   sqhsts[1];
            void  *sqindv[1];
            int   sqinds[1];
   unsigned int   sqharm[1];
   unsigned int   *sqharc[1];
   unsigned short  sqadto[1];
   unsigned short  sqtdso[1];
} sqlstm = {10,1};

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
};


/******************************************************************
* 
*	Name			MedProcess.PC
*
*	Author			K S Sundar
*
*	Purpose			Call SMTPRDOC.EXE
*
*   ====================
*	Modification History  
*   ===============================================================
*	Date		Person		Remarks
*   ===============================================================
*	Apr 28,2003	K S Sundar	Created
*
*	Sep 02,2003	K S Sundar	WSPrintDocument Procedure added.
*							Replica of PrintDocument with two more
*							parameters:
*							1. WorkstationID
*							2. ReportOutputDir
*
*******************************************************************/

/*
* Header Files.
*/

#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <windows.h>
#include <winuser.h>
#include <process.h>
#include <time.h>
#include <string.h>
#include <debug.h>  

/*
* Declare other variables and functions.
*/

int PrintDocument   (char *, char *, char *, char *, char *, char *, char *, char *, int, int, int);
//int WSPrintDocument (char *, char *, char *, char *, char *, char *, char *, char *, int, int, int, char *, char *);//commented for ML-MMOH-CRF-0578
int WSPrintDocument (char *, char *, char *, char *, char *, char *, char *, char *, int, int, int, char *, char *,char * ); //added for ML-MMOH-CRF-0578

/*******************************************************************************************
*
* Function 	PrintDocument
* 
* Author 	K S Sundar
*
* Date 		Dec 12, 2002
*
* Purpose 	Invokes SMTPRDOC.EXE
*
*******************************************************************************************/

int PrintDocument(PUidPwd, PSessionID, PFacilityID, PModuleID, PDocumentID, PFileNames, PLocationTypes, PLocationCodes, PNumOfCopies, PPageFrom, PPageTo)
char	*PUidPwd;
char	*PSessionID;
char	*PFacilityID;
char	*PModuleID;
char	*PDocumentID;
char	*PFileNames;
char	*PLocationTypes;
char	*PLocationCodes;
int		PNumOfCopies;
int		PPageFrom;
int		PPageTo;

{

	char	LVCommandLine [500];			// Command line string
	int     LVPrintStatus;
	char	LVFunctionName[64];
	char	LVWorkstationID[50];
	char	LVReportOutputDir[121];
	
	char	LVndprinterid[121];//added for ML-MMOH-CRF-0578
	
	
	/*
	* Enable or disable tracing.
	*/
	strcpy(GVProgramID,"MEDPROC");
	EnableOrDisableTracing();


	if (IS_TRACING) 
	{
		strcpy(LVFunctionName,"PrintDocument");
		Trace(LVFunctionName,"Begin");
	}

	strcpy(LVWorkstationID,"$#@#$");

	strcpy(LVReportOutputDir,"$#@#$");

	if (IS_TRACING)
	{
		sprintf(GVTraceMsg,"PUidPwd=[%s] PSessionID=[%s] PFacilityID=[%s] PDocumentID=[%s] PFileNames=[%s] PLocationTypes=[%s] PLocationCodes =[%s] PNumOfCopies =[%d] PPageFrom =[%d] PPageTo=[%d] ",
		PUidPwd, PSessionID, PFacilityID, PDocumentID, PFileNames, PLocationTypes,PLocationCodes, PNumOfCopies,PPageTo,PPageFrom);
		Trace(LVFunctionName,GVTraceMsg);
	}


	if (IS_TRACING) 
	{
	   Trace(LVFunctionName,"Calling WSPrintDocument...");
	}

    WSPrintDocument(PUidPwd, PSessionID, PFacilityID, PModuleID, PDocumentID, PFileNames, PLocationTypes, PLocationCodes, PNumOfCopies, PPageFrom, PPageTo, LVWorkstationID, LVReportOutputDir,LVndprinterid); //added LVndprinterid for ML-MMOH-CRF-0578

	if (IS_TRACING) Trace(LVFunctionName,"End");
	return (LVPrintStatus);
	
} /* int PrintDocument(PUidPwd, PSessionID, PPGMDateTime, PFacilityID, PModuleID, PDocumentID, PFileNames, PLocationTypes, PLocationCodes, PNumOfCopies, PPageFrom, PPageTo) */


/*******************************************************************************************
*
* Function 	WSPrintDocument
* 
* Author 	N K Nanjayan
*
* Date 		13 Aug 2003
*
* Purpose 	Invokes SMTPRDOC.EXE
*
*******************************************************************************************/

int WSPrintDocument(PUidPwd, PSessionID, PFacilityID, PModuleID, PDocumentID, PFileNames, PLocationTypes, PLocationCodes, PNumOfCopies, PPageFrom, PPageTo, PWorkstationID, PReportOutputDir,PRndprinterid ) //added PRndprinterid,PRndqueuename for ML-MMOH-CF-0578)
char	*PUidPwd;
char	*PSessionID;
char	*PFacilityID;
char	*PModuleID;
char	*PDocumentID;
char	*PFileNames;
char	*PLocationTypes;
char	*PLocationCodes;
int		PNumOfCopies;
int		PPageFrom;
int		PPageTo;
char	*PWorkstationID;
char	*PReportOutputDir;

char	*PRndprinterid; //added for ML-MMOH-CF-0578


{

	char	LVCommandLine [500];			// Command line string
	int     LVPrintStatus;
	char	LVFunctionName[64];
	char	LVWorkstationID[50];
	char	LVReportOutputDir[121];
	
	
	
	/*
	* Enable or disable tracing.
	*/
	strcpy(GVProgramID,"MEDPROC");
	EnableOrDisableTracing();

	if (IS_TRACING) 
	{
		strcpy(LVFunctionName,"WSPrintDocument");
		Trace(LVFunctionName,"Begin");
	}


	/* added by aparna to handle null location code  */

	if (strlen(PLocationCodes) == 0)
	{
	   strcpy(PLocationCodes,"~");
	}

		if (IS_TRACING)
	{
		sprintf(GVTraceMsg,"PUidPwd=[%s] PSessionID=[%s] PFacilityID=[%s] PDocumentID=[%s] PFileNames=[%s] PLocationTypes=[%s] PLocationCodes =[%s] PNumOfCopies =[%d] PPageFrom =[%d] PPageTo=[%d] PWorkstationID =[%s] PReportOutputDir =[%s]",
		PUidPwd, PSessionID, PFacilityID, PDocumentID, PFileNames, PLocationTypes,PLocationCodes, PNumOfCopies,PPageTo,PPageFrom, PWorkstationID,PReportOutputDir);
		Trace(LVFunctionName,GVTraceMsg);
	}

	sprintf (LVCommandLine, 
				"%s %s;%s;%s;%s;%s;%s;%s;%s;%d;%d;%d;%s;%s;%s", 
				"SMTPRDOC", 
				PUidPwd, 
				PSessionID,
				PFacilityID, 
				PModuleID, 
				PDocumentID,
				PFileNames, 
				PLocationTypes, 
				PLocationCodes,
				PNumOfCopies, 
				PPageFrom, 
				PPageTo,
				PWorkstationID,
				PReportOutputDir,
				PRndprinterid //added for ML-MMOH-CF-0578
				
			);

	if (IS_TRACING) Trace(LVFunctionName,LVCommandLine);

	if (IS_TRACING) Trace(LVFunctionName,"Calling SMTPRDOC ...");
	LVPrintStatus =  _spawnlp( _P_WAIT, "SMTPRDOC", LVCommandLine, NULL) ;

	if (IS_TRACING) 
	{
		if (LVPrintStatus)
			sprintf(GVTraceMsg,"Printing Not Success!!");
		else
			sprintf(GVTraceMsg,"Printing Success !!");

		Trace(LVFunctionName,GVTraceMsg);
	}

	if (IS_TRACING) Trace(LVFunctionName,"End");
	return (LVPrintStatus);
	
} /* int PrintDocument(PUidPwd, PSessionID, PPGMDateTime, PFacilityID, PModuleID, PDocumentID, PFileNames, PLocationTypes, PLocationCodes, PNumOfCopies, PPageFrom, PPageTo) */
/*******************************************************************************************
*
* Function 	InvokeProcess
* 
* Author 	K S Sundar
*
* Date 		Dec 17, 2002
*
* Purpose 	Invokes Pro*C application.
*
*******************************************************************************************/

int InvokeProcess(char *PPGMName, char *PArguments)
{
	char LVCmd[1024];
	char LVFunctionName[30];
	int  LVWinExecReturnCode;
	
	if (IS_TRACING)
	{
		strcpy(LVFunctionName,"InvokeProcess");
		Trace(LVFunctionName,"Begin");
	}

	sprintf(LVCmd,"%s%s", PPGMName, PArguments);
	
	if (IS_TRACING) Trace( LVFunctionName, LVCmd);
	
	LVWinExecReturnCode = _spawnlp( _P_WAIT, PPGMName, LVCmd, NULL) ;

	if (IS_TRACING) 
	{
		if (LVWinExecReturnCode = 0)
			sprintf(GVTraceMsg,"Command Success");
		else
			sprintf(GVTraceMsg,"Command NOT Success!!");
		Trace( LVFunctionName, GVTraceMsg);

		strcpy(LVFunctionName,"InvokeProcess");
		Trace( LVFunctionName,"End");
	}
}


