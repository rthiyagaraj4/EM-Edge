
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
           char  filnam[42];
};
static const struct sqlcxp sqlfpn =
{
    41,
    "D:\\Application\\eHIS2Tier\\INCLUDE\\Debug.pc"
};


static unsigned long sqlctx = 1956248925;


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
            void  *sqhstv[11];
   unsigned int   sqhstl[11];
            int   sqhsts[11];
            void  *sqindv[11];
            int   sqinds[11];
   unsigned int   sqharm[11];
   unsigned int   *sqharc[11];
   unsigned short  sqadto[11];
   unsigned short  sqtdso[11];
} sqlstm = {10,11};

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
5,0,0,1,73,0,4,166,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
28,0,0,2,137,0,3,181,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,
63,0,0,3,0,0,29,209,0,0,0,0,0,1,0,
78,0,0,4,224,0,6,296,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
137,0,0,5,157,0,4,353,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
172,0,0,6,159,0,4,377,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
203,0,0,7,47,0,2,416,0,0,1,1,0,1,0,1,9,0,0,
222,0,0,8,67,0,2,422,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
245,0,0,9,63,0,4,457,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
};


/****************************************************************************************************
*
*	Name			Debug.PC 
*
*	Author			K S Sundar
*
*	Purpose			Common routines
*
*					1. RegisterError			To register the error in MEDICOM.
*					2. Trace					To update tracing log (SY_PGM_EVENTS_LOG).
*					3. EnableOrDisableTracing	To enable or disable tracing for the given program.
*					4. GetLastErrorMessage		To get the last error message
*					5. GetMEDICOMMessage		To get message text from MEDICOM.MESSAGE
*
*	****************
*	Important Notes:
*	****************
*	INTERACTIVE_MESSAGING is disabled. To enable it, WINPROC.H needs
*	to be included as disp_message function is used to display the 
*	message interactively - K S Sundar (Apr 23, 2003).
*
*   ====================
*	Modification History  
*   ===============================================================
*	Date		Person			Remarks
*   ===============================================================
*	Apr 22,2003	K S Sundar		Created
*							
*	Jun 30,2003	N K Nanjayan	INSERT INTO SY_PGM_EVENTS_LOG is modified:
*								Column-list added.
*
*	Sep 16,2003	K S Sundar		RegisterError Procedure modified:
*								Following new arguments added and passed 
*								to APPPRINT.register_error:
*								1. PReportFileName
*								2. PLocationType
*								3. PLocationCode
*								4. PPrinterID
*								5. PPrinterName
*								6. PQueueName
****************************************************************************************************/

/*
* Header Files.
*/
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <windows.h>
#include <time.h>
#include <string.h>
#include <Debug.h>

/*
* Define constants
*/
# define ORACLE_ERROR				(sqlca.sqlcode < 0)
# define ORACLE_RESOURCE_BUSY		(sqlca.sqlcode == 54)
# define ORACLE_NODATAFOUND 		(sqlca.sqlcode == 1403)
# define ORACLE_NULLCOLUMNFETCHED 	(sqlca.sqlcode == 1405)
# define ERR_MESG     				0

/*
* Declare Bind variables
*/
/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* varchar BVMsgID[16]; */ 
struct { unsigned short len; unsigned char arr[16]; } BVMsgID;
				// Message ID
	/* varchar BVMsgText[100]; */ 
struct { unsigned short len; unsigned char arr[100]; } BVMsgText;
				// Message Text
	/* varchar BVPGMID[30]; */ 
struct { unsigned short len; unsigned char arr[30]; } BVPGMID;
				// Program ID
	/* varchar BVFunctionName[30]; */ 
struct { unsigned short len; unsigned char arr[30]; } BVFunctionName;
			// For Program Tracing
	/* varchar BVTraceMsg[1024]; */ 
struct { unsigned short len; unsigned char arr[1024]; } BVTraceMsg;
			// For Program Tracing	
	/* varchar BVTracingYN[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } BVTracingYN;
				// For Program Tracing
	/* varchar BVInteractiveTracingYN[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } BVInteractiveTracingYN;
	// For Program Tracing
	/* varchar BVPurgeAlwaysYN[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } BVPurgeAlwaysYN;
			// For Program Tracing
	/* varchar BVComputerName[16]; */ 
struct { unsigned short len; unsigned char arr[16]; } BVComputerName;
			// For Program Tracing
	int		BVSeqNo;					// For Program Tracing

	/* VARCHAR BVWorkstationID[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVWorkstationID;

 	/* VARCHAR BVFacilityID[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVFacilityID;

 	/* VARCHAR BVModuleID[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVModuleID;

 	/* VARCHAR BVDocumentID[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVDocumentID;

	/* VARCHAR BVReportFileName[256]; */ 
struct { unsigned short len; unsigned char arr[256]; } BVReportFileName;

 	/* VARCHAR BVLocationType[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVLocationType;

	/* VARCHAR BVLocationCode[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVLocationCode;

	/* VARCHAR BVPrinterID[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVPrinterID;

	/* VARCHAR BVPrinterName[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVPrinterName;

	/* VARCHAR BVQueueName[64]; */ 
struct { unsigned short len; unsigned char arr[64]; } BVQueueName;


 	/* VARCHAR BVErrorText[1024]; */ 
struct { unsigned short len; unsigned char arr[1024]; } BVErrorText;
  		// APPPRINT.Get_Routing_Printers Database Procedure

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






/*******************************************************************************************
*
* Function 	GetLastErrorMessage
* 
* Author 	K S Sundar
*
* Date 		Dec 17, 2002
*
* Purpose 	Fetches the error message of GetLastError.
*
*******************************************************************************************/

void GetLastErrorMessage()
{
	LPVOID lpMsgBuf;	

	strcpy(GVLastErrorMessage,"");

	FormatMessage
	( 
		FORMAT_MESSAGE_ALLOCATE_BUFFER | 
		FORMAT_MESSAGE_FROM_SYSTEM | 
		FORMAT_MESSAGE_IGNORE_INSERTS,
		NULL,
		GetLastError(),
		MAKELANGID(LANG_NEUTRAL, SUBLANG_DEFAULT), // Default language
		(LPTSTR) &lpMsgBuf,
		0,
		NULL 
	);
	
	strcpy(GVLastErrorMessage,"");
	sprintf(GVLastErrorMessage,"%d-%s", GetLastError(), lpMsgBuf);
	strtok(GVLastErrorMessage,"\n");

} /* GetLastErrorMessage */


/*******************************************************************************************
*
* Function 	Trace
* 
* Author 	K S Sundar
*
* Date 		Dec 12, 2002
*
* Purpose 	Writes the tracing message to SY_PGM_EVENTS_LOG table.
*
*******************************************************************************************/

void Trace(char *function_name, char *msg)
{

	strcpy(BVPGMID.arr,GVProgramID);
	BVPGMID.len = strlen(BVPGMID.arr);

	strcpy(BVFunctionName.arr,function_name);
	BVFunctionName.len = strlen(BVFunctionName.arr);

	strcpy(BVTraceMsg.arr,msg);
	BVTraceMsg.len = strlen(BVTraceMsg.arr);

	//if (IS_INTERACTIVE_TRACING) disp_message(ERR_MESG,msg);

	/*
	* Get the maximum seqno.
	*/
	BVSeqNo = 0;
	/* EXEC SQL SELECT MAX(NVL(SEQNO,0))
		 INTO   :BVSeqNo
		 FROM   sy_pgm_events_log
	 WHERE  PGMID = :BVPGMID; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select max(NVL(SEQNO,0)) into :b0  from sy_pgm_events_log wh\
ere PGMID=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&BVSeqNo;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&BVPGMID;
 sqlstm.sqhstl[1] = (unsigned int  )32;
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



	if(sqlca.sqlcode < 0)
	{
		sprintf(GVTraceMsg,"SELECT ON sy_pgm_events_log failed : %s",sqlca.sqlerrm.sqlerrmc);
		//if (IS_INTERACTIVE_TRACING) disp_message(ERR_MESG,GVTraceMsg);
	}

	/*
	* Insert the record in sy_pgm_events_log table.
	*/
	BVSeqNo = BVSeqNo + 1;
	/* EXEC SQL 
	INSERT INTO sy_pgm_events_log
	(
		dbuserid,
		pgmid, 
		machineid, 
		seqno, 
		timestamp, 
		functionname, 
		message
	)
	VALUES
	(
		USER, 
		:BVPGMID, 
		:BVComputerName, 
		:BVSeqNo, 
		SYSDATE, :
		BVFunctionName, 
		:BVTraceMsg
	); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "insert into sy_pgm_events_log (dbuserid,pgmid,machineid,seqn\
o, timestamp ,functionname,message) values (USER,:b0,:b1,:b2,SYSDATE,:b3,:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )28;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&BVPGMID;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&BVComputerName;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&BVSeqNo;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&BVFunctionName;
 sqlstm.sqhstl[3] = (unsigned int  )32;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&BVTraceMsg;
 sqlstm.sqhstl[4] = (unsigned int  )1026;
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



	if(sqlca.sqlcode < 0)
	{
		sprintf(GVTraceMsg,"INSERT ON sy_pgm_events_log failed : %s",sqlca.sqlerrm.sqlerrmc);
		//if (IS_INTERACTIVE_TRACING) disp_message(ERR_MESG,GVTraceMsg);
	}
	else
		/* EXEC SQL COMMIT; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )63;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}


/*******************************************************************************************
*
* Function 	RegisterError
* 
* Author 	K S Sundar
*
* Date 		Dec 12, 2002
*
* Purpose 	1. Calls APPPRINT.register_error backend procedure 
*			   to register the error
*			2. Call Trace function to insert the error in tracing log.
*
*******************************************************************************************/
void RegisterError
(
	char *PFacilityID, 
	char *PModuleID, 
	char *PWorkstationID, 
	char *PDocumentID,
	char *PReportFileName,	 
	char *PLocationType,	 
	char *PLocationCode,	 
	char *PPrinterID,	 
	char *PPrinterName,	 
	char *PQueueName, 
	char *PFunctionName, 
	char *PMsg
)
{ 
	char LVFunctionName[64];
	
	strcpy(LVFunctionName,"RegisterError");

	if (IS_TRACING) Trace(LVFunctionName,"Begin");

	strcpy(BVFacilityID.arr,PFacilityID);
	BVFacilityID.len = strlen(BVFacilityID.arr);

	strcpy(BVModuleID.arr,PModuleID);
	BVModuleID.len = strlen(BVModuleID.arr);

	strcpy(BVWorkstationID.arr,PWorkstationID);
	BVWorkstationID.len = strlen(BVWorkstationID.arr);

	strcpy(BVDocumentID.arr,PDocumentID);
	BVDocumentID.len = strlen(BVDocumentID.arr);
	
	strcpy(BVReportFileName.arr,PReportFileName);
	BVReportFileName.len = strlen(BVReportFileName.arr);

	strcpy(BVLocationType.arr,PLocationType);
	BVLocationType.len = strlen(BVLocationType.arr);

	strcpy(BVLocationCode.arr,PLocationCode);
	BVLocationCode.len = strlen(BVLocationCode.arr);

	strcpy(BVPrinterID.arr,PPrinterID);
	BVPrinterID.len = strlen(BVPrinterID.arr);

	strcpy(BVPrinterName.arr,PPrinterName);
	BVPrinterName.len = strlen(BVPrinterName.arr);

	strcpy(BVQueueName.arr,PQueueName);
	BVQueueName.len = strlen(BVQueueName.arr);

	BVErrorText.arr[0] = '\0';
	BVErrorText.arr[BVErrorText.len] = 0;    /* added by Aparna */

	if (strcmp(PMsg,"") == 0)
	{
		if (ORACLE_ERROR || ORACLE_RESOURCE_BUSY || ORACLE_NODATAFOUND)
			sprintf(BVErrorText.arr,"Error at %s : <%s>", PFunctionName, sqlca.sqlerrm.sqlerrmc);
		else
			sprintf(BVErrorText.arr,"Error at %s",PFunctionName);  /* added p_functionName by aparna*/
	}
	else
	{
		/* Blank Message. Get oracle error message */
		strcpy(BVErrorText.arr,PMsg);
	}
	BVErrorText.len = strlen(BVErrorText.arr);
	if (IS_TRACING) Trace(LVFunctionName,BVErrorText.arr);

	/* EXEC SQL EXECUTE 
	BEGIN 
		APPPRINT.register_error
		(
			:BVFacilityID,
			:BVModuleID,
			:BVWorkstationID,
			:BVDocumentID,
			:BVReportFileName,
			:BVLocationType,
			:BVLocationCode,
			:BVPrinterID,
			:BVPrinterName,
			:BVQueueName,
			:BVErrorText	
		);
    	   END ;
	END-EXEC ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin APPPRINT . register_error ( :BVFacilityID , :BVModuleI\
D , :BVWorkstationID , :BVDocumentID , :BVReportFileName , :BVLocationType , :\
BVLocationCode , :BVPrinterID , :BVPrinterName , :BVQueueName , :BVErrorText )\
 ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )78;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&BVFacilityID;
 sqlstm.sqhstl[0] = (unsigned int  )66;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&BVModuleID;
 sqlstm.sqhstl[1] = (unsigned int  )66;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&BVWorkstationID;
 sqlstm.sqhstl[2] = (unsigned int  )66;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&BVDocumentID;
 sqlstm.sqhstl[3] = (unsigned int  )66;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&BVReportFileName;
 sqlstm.sqhstl[4] = (unsigned int  )258;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&BVLocationType;
 sqlstm.sqhstl[5] = (unsigned int  )66;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&BVLocationCode;
 sqlstm.sqhstl[6] = (unsigned int  )66;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&BVPrinterID;
 sqlstm.sqhstl[7] = (unsigned int  )66;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&BVPrinterName;
 sqlstm.sqhstl[8] = (unsigned int  )66;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&BVQueueName;
 sqlstm.sqhstl[9] = (unsigned int  )66;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&BVErrorText;
 sqlstm.sqhstl[10] = (unsigned int  )1026;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
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

 		


	if (IS_TRACING) Trace(LVFunctionName,"End");

} // void RegisterError

/*******************************************************************************************
*
* Function 	EnableOrDisableTracing
* 
* Author 	K S Sundar
*
* Date 		Dec 12, 2002
*
* Purpose 	1. Reads SY_PGM_EVENTS_CTL table
*			2. Enables or disables tracing.
*
*******************************************************************************************/

void EnableOrDisableTracing()
{
   	char	LVMachineName[20];
	DWORD	LVMachineNo = 20;
	int		LVAllMachinesYN = 0;

	strcpy(BVPGMID.arr,GVProgramID);
	BVPGMID.len = strlen(BVPGMID.arr);

	/*
	*  Get the computer name.
	*/
	GetComputerName(LVMachineName, &LVMachineNo );
	strcpy(BVComputerName.arr, LVMachineName);
	BVComputerName.len = strlen(BVComputerName.arr);

	/*
	*  Check if tracing is ON for this program for this machine id.
	*/
	strcpy(BVTracingYN.arr,"");
	/* EXEC SQL 
	SELECT NVL(tracingyn,'N'), NVL(interactivetracingyn,'N'), NVL(purgealwaysyn,'N')
	INTO   :BVTracingYN, :BVInteractiveTracingYN, :BVPurgeAlwaysYN
	FROM   sy_pgm_events_ctl
	WHERE  PGMID = :BVPGMID
	AND    MACHINEID = :BVComputerName; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(tracingyn,'N') ,NVL(interactivetracingyn,'N') ,NV\
L(purgealwaysyn,'N') into :b0,:b1,:b2  from sy_pgm_events_ctl where (PGMID=:b3\
 and MACHINEID=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )137;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&BVTracingYN;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&BVInteractiveTracingYN;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&BVPurgeAlwaysYN;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&BVPGMID;
 sqlstm.sqhstl[3] = (unsigned int  )32;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&BVComputerName;
 sqlstm.sqhstl[4] = (unsigned int  )18;
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



	BVTracingYN.len = strlen(BVTracingYN.arr);
	BVInteractiveTracingYN.len = strlen(BVInteractiveTracingYN.arr);
	BVPurgeAlwaysYN.len = strlen(BVPurgeAlwaysYN.arr);

	if(sqlca.sqlcode < 0 || sqlca.sqlcode == 1403 || _stricmp(BVTracingYN.arr,"N")==0)
	{
		IS_TRACING = 0;
	}
	else
		IS_TRACING = 1;

	if (sqlca.sqlcode == 1403)	// Tracing is not on for this machine.
	{
		/*
		*  Check if tracing is ON for this program (for all machines).
		*/
		strcpy(BVTracingYN.arr,"");
		/* EXEC SQL 
		SELECT NVL(tracingyn,'N'), NVL(interactivetracingyn,'N'), NVL(purgealwaysyn,'N')
		INTO   :BVTracingYN, :BVInteractiveTracingYN, :BVPurgeAlwaysYN
		FROM   sy_pgm_events_ctl
		WHERE  PGMID	 = :BVPGMID
		AND    machineid = 'ALL'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(tracingyn,'N') ,NVL(interactivetracingyn,'N') ,N\
VL(purgealwaysyn,'N') into :b0,:b1,:b2  from sy_pgm_events_ctl where (PGMID=:b\
3 and machineid='ALL')";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )172;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&BVTracingYN;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&BVInteractiveTracingYN;
  sqlstm.sqhstl[1] = (unsigned int  )4;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&BVPurgeAlwaysYN;
  sqlstm.sqhstl[2] = (unsigned int  )4;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&BVPGMID;
  sqlstm.sqhstl[3] = (unsigned int  )32;
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



		BVTracingYN.len = strlen(BVTracingYN.arr);
		BVInteractiveTracingYN.len = strlen(BVInteractiveTracingYN.arr);
		BVPurgeAlwaysYN.len = strlen(BVPurgeAlwaysYN.arr);


		if(sqlca.sqlcode < 0 || sqlca.sqlcode == 1403 || _stricmp(BVTracingYN.arr,"N")==0)
			IS_TRACING = 0;
		else
		{
			IS_TRACING = 1;
			LVAllMachinesYN = 1;
		}

	}

	if (IS_TRACING)
	{
		/*
		* Enable or disable interactive tracing.
		*/
		if (strcmp(BVInteractiveTracingYN.arr,"Y") == 0)
			IS_INTERACTIVE_TRACING = 1;
		else
			IS_INTERACTIVE_TRACING = 0;

		/*
		* Purge tracing records for PrintDocument program if purging is enabled.
		*/
		if (strcmp(BVPurgeAlwaysYN.arr,"Y") == 0)
		{
			if (LVAllMachinesYN)
			{
				/* EXEC SQL 
				DELETE  sy_pgm_events_log
				WHERE   PGMID = :BVPGMID; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from sy_pgm_events_log  where PGMID=:b0";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )203;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&BVPGMID;
    sqlstm.sqhstl[0] = (unsigned int  )32;
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
				/* EXEC SQL 
				DELETE  sy_pgm_events_log
				WHERE   PGMID = :BVPGMID
				AND     MACHINEID = :BVComputerName; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from sy_pgm_events_log  where (PGMID=:b0 and MACH\
INEID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )222;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&BVPGMID;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&BVComputerName;
    sqlstm.sqhstl[1] = (unsigned int  )18;
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


			}
		}
	}

} /* void EnableOrDisableTracing() */



/*
*
* Function  GetMEDICOMMessage
* Author    K S Sundar
* Purpose   To get the MEDICOM error message.
*
*/
void GetMEDICOMMessage(l_errid, l_msg_desc)
char *l_errid, *l_msg_desc;
{
	char LVFunctionName[64];

	if (IS_TRACING)
	{
		strcpy(LVFunctionName, "GetMEDICOMMessage()");
		Trace(LVFunctionName,"Begin");
	}

	BVMsgID.arr[0] = '\0';
	strcpy(BVMsgID.arr,l_errid);
	BVMsgID.len = strlen(BVMsgID.arr);

	strcpy(BVMsgText.arr,"");
	/* EXEC SQL 
	SELECT MESSAGE_TEXT
	INTO   :BVMsgText
	FROM   MESSAGE
	WHERE  MESSAGE_ID = :BVMsgID; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select MESSAGE_TEXT into :b0  from MESSAGE where MESSAGE_ID=\
:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )245;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&BVMsgText;
 sqlstm.sqhstl[0] = (unsigned int  )102;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&BVMsgID;
 sqlstm.sqhstl[1] = (unsigned int  )18;
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



	if(sqlca.sqlcode < 0 || sqlca.sqlcode == 1403)
	{
		strcpy(l_msg_desc,sqlca.sqlerrm.sqlerrmc);
		sprintf(l_errid,"%d",sqlca.sqlcode);
	}
	else 
	{
		BVMsgText.arr[BVMsgText.len] = '\0';
		strcpy(l_msg_desc,BVMsgText.arr);
	}

	if (IS_TRACING) Trace(LVFunctionName,l_msg_desc);
	if (IS_TRACING) Trace(LVFunctionName,"End");

}
