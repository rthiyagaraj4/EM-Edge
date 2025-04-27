/****************************************************************************************
 *																						*
 *  Copyright (c) by 1993, Computer Software & Solutions LLC. Sultanate of Oman. 		*
 * 			          All Rights Reserved Worldwide.									*
 *																						*
 *  Name    : Debug.h																*
 *																						*
 *  Purpose : This header is to declare common variables used for debugging.
 *																						*
 *  Owner   : STDS and IFS Group of MEDICOM Product										*
 *																						*
 *  DD/MM/YYYY  Modified by      Reason													*
 *  ----------  -----------      ------													*
 *  23/04/2003  K S Sundar		Created													*
 *																						*
 ****************************************************************************************/

/*
* Variables required for creating window. 
*/
HWND		hwnd;
MSG			msg;
WNDCLASS 	wndclass;

/*
* Declare tracing variables and functions.
*/
char	GVTraceMsg[1000];
char	GVLastErrorMessage[512];
int		IS_TRACING;
int		IS_INTERACTIVE_TRACING; 
char	GVProgramID[16];

void	Trace(char *function_name, char *msg);
void	EnableOrDisableTracing(void);
void	GetLastErrorMessage(void);
void	RegisterError(char *PFacilityID, char *PModuleID, char *PWorkstationID, char *PDocumentID, char *PFunctionName, char *PMsg);
int		InvokeProcess (char *, char *);

/*
* Oracle Error Codes
*/
#define OERROR						(sqlca.sqlcode < 0)
#define NO_DATA_FOUND				sqlca.sqlcode==1403
#define NODATAFOUND					sqlca.sqlcode==1403
#define ORACLE_ERROR				(sqlca.sqlcode < 0)
#define ORACLE_RESOURCE_BUSY		(sqlca.sqlcode == 54)
#define ORACLE_NODATAFOUND 			(sqlca.sqlcode == 1403)
#define ORACLE_NULLCOLUMNFETCHED 	(sqlca.sqlcode == 1405)

