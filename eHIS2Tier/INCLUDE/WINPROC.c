
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
           char  filnam[44];
};
static const struct sqlcxp sqlfpn =
{
    43,
    "D:\\Application\\eHIS2Tier\\INCLUDE\\WINPROC.PC"
};


static unsigned long sqlctx = 764951779;


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
            void  *sqhstv[5];
   unsigned int   sqhstl[5];
            int   sqhsts[5];
            void  *sqindv[5];
            int   sqinds[5];
   unsigned int   sqharm[5];
   unsigned int   *sqharc[5];
   unsigned short  sqadto[5];
   unsigned short  sqtdso[5];
} sqlstm = {10,5};

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
5,0,0,1,0,0,27,281,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,97,0,6,292,0,0,1,1,0,1,0,2,3,0,0,
55,0,0,3,0,0,32,354,0,0,0,0,0,1,0,
70,0,0,4,85,0,6,403,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
93,0,0,5,134,0,6,463,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,3,9,0,0,3,9,0,0,
128,0,0,6,109,0,6,550,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,3,9,0,0,3,9,0,0,
159,0,0,7,0,0,30,596,0,0,0,0,0,1,0,
174,0,0,8,0,0,32,601,0,0,0,0,0,1,0,
};


#include <process.h>
#include <windows.h>  
#include <stdlib.h> 
#include <dos.h>
#include <crtdbg.h>
#include <assert.h>
#include <time.h>

#define MAX_APPNAME_STRING		20
#define PC_START				1
#define PC_END				2
#define INFO_MESG				3
#define ERR_MESG				4
#define ORA_MESG				5  
#define DISP_MESG				6  


extern SQLDA *sqlald();

/********************************************************************/
/*                   SQL Declaration Section                        */
/*	Added by C. Ganesan on 24/10/2002 for reading Pro*C output	  */
/*	directory information
/********************************************************************/

/*Modified by shanmugam on 16/01/07 for internationlization */
/*Modification :-  l_language_id is added*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 

	/* VARCHAR l_uid_pwd[91],
		  l_user_id[31],
		  l_facility_id[3],
		  l_workstation_id[31],
		  l_dir_name[120],
		  l_param_id[31],
		  l_proc_viewer[120],
		  l_error_text[501],
		  l_language_id[4]; */ 
struct { unsigned short len; unsigned char arr[91]; } l_uid_pwd;

struct { unsigned short len; unsigned char arr[31]; } l_user_id;

struct { unsigned short len; unsigned char arr[3]; } l_facility_id;

struct { unsigned short len; unsigned char arr[31]; } l_workstation_id;

struct { unsigned short len; unsigned char arr[120]; } l_dir_name;

struct { unsigned short len; unsigned char arr[31]; } l_param_id;

struct { unsigned short len; unsigned char arr[120]; } l_proc_viewer;

struct { unsigned short len; unsigned char arr[501]; } l_error_text;

struct { unsigned short len; unsigned char arr[4]; } l_language_id;


int		  newversion;		/* Added by C. Ganesan on 25/05/2003 at 16:00
						   for checking the MEDICOM version */

/* EXEC SQL END DECLARE SECTION; */ 



/********************************************************************/
/*                   Windows Declaration Section                    */
/********************************************************************/

char szAppName[ MAX_APPNAME_STRING + 1 ];  

#ifdef __BORLANDC__
#pragma warn -par							 /*Turn off the warnings*/
#pragma warn -aus
LRESULT CALLBACK SampleWndProc(HWND, UINT, WPARAM, LPARAM);
#else
long FAR PASCAL SampleWndProc(HWND, unsigned, WORD, LONG);
#endif

BOOL ProcessOracleErrorCode(HWND);
BOOL SampleInit(HANDLE);

void proc_main (int, char **);
void disp_message ( int, char *);
void open_log_file();
void proc_exit();
void get_init_variables_old();
void get_init_variables_new();


HINSTANCE hInst = NULL;					// Handle to the application instance
HWND hWnd = NULL;						// Handle to the application main window

static HDC         hdc;
static PAINTSTRUCT ps;
static RECT        rect;

char               tstrCmdLine[256];
char               *pstrCmdLine[50];
char               LOG_FILE_NAME[150]; 
char               OUTPUT_FILE_NAME[150]; 
char               REP_FILE_NAME[150]; 
char               PROCESS_NAME[10]; 
char               WORKING_DIR[80];
char               line_char[80];
char	  	       exe_file_name[75]; 
char               szProcView[80];
int			 noparam=0;
int			 first_time=1;

FILE               *log_fp;



/********************************************************************/
/*                   Pro*C and Windows Code.                        */
/********************************************************************/

/*
 * SampleInit
 *
 * Do startup initialization for the sample application.
 */

BOOL SampleInit(in_hInst)
HANDLE in_hInst;
{
   WNDCLASS SampleClass;

    lstrcpy ( (LPSTR)szAppName, "WinProc");

    SampleClass.style = CS_HREDRAW | CS_VREDRAW;
    SampleClass.lpfnWndProc = (WNDPROC)SampleWndProc;
    SampleClass.cbClsExtra = 0;
    SampleClass.cbWndExtra = 0;
    SampleClass.hIcon = NULL;
    SampleClass.hInstance = in_hInst;
    SampleClass.hCursor = NULL;
    SampleClass.hbrBackground = (HBRUSH) GetStockObject (LTGRAY_BRUSH);
    SampleClass.lpszMenuName = NULL;
    SampleClass.lpszClassName = szAppName;
    if (!RegisterClass(&SampleClass))
        return FALSE;

    return( TRUE );

} /*SampleInit*/

/*
 *WinMain
*/

int WINAPI WinMain (
               HINSTANCE hInstance,     // Handle to the current instance
               HINSTANCE hPrevInstance, // Handle to the previous instance
               LPWSTR lpszCmdLine,      // Pointer to the command line
               int cmdShow)             //  Shows the state of the window

{ 

    MSG msg;
	
    if (hPrevInstance)
        return( FALSE );

    if (!SampleInit(hInstance))
        return( FALSE );

    hInst = hInstance;

    hWnd = CreateWindow(szAppName,
                        NULL,
                        WS_POPUP | WS_DLGFRAME,  // Window style
                        170,
                        190,
                        300,
                        100,
                        NULL,
                        NULL,
                        hInst,
                        (LPWSTR) lpszCmdLine);

    ShowWindow(hWnd, SW_SHOWNORMAL);
    UpdateWindow(hWnd);

    while (GetMessage(&msg, NULL, 0, 0)) 
    	{
        	TranslateMessage(&msg);
	        DispatchMessage(&msg);
        } /*while*/

    return(msg.wParam );

} /*WinMain*/

/*
 *SampleWndProc
*/

LRESULT CALLBACK SampleWndProc(HWND hWnd, UINT message, WPARAM wParam,
    LPARAM lParam)

{                            

	char  module_name[75], *ptr;

    switch (message) {

        case WM_CREATE :
            hInst = ((LPCREATESTRUCT) lParam)->hInstance;

	        /* Command line copy */
            strcpy ( tstrCmdLine, (LPSTR)
			(((LPCREATESTRUCT) lParam)->lpCreateParams));
                                                                 
			
            return TRUE;
	    case WM_PAINT :     
	      if ( first_time )
	       {      
		    first_time = 0;		 
    	    /* Command line parsing */		    
			GetModuleFileName ( hInst, exe_file_name, sizeof(exe_file_name));
			strcpy ( module_name, exe_file_name);
			ptr = strtok ( module_name, "\\");
			pstrCmdLine[noparam] = ptr;			
			while ((ptr = strtok (0, "\\")) != NULL )
				   pstrCmdLine[noparam] = ptr;       
            	pstrCmdLine[++noparam] = strtok ( tstrCmdLine, " ");
            	while ( ( pstrCmdLine[++noparam] = strtok (0 , " ") ) != NULL ) 
				;

		/********************************************************************/
		/*	Added following code to assign user information for connecting*/
		/*	to Oracle database, which will be used for retrieving 	  */
		/*	workstation, directory and Pro*C viewer information form 	  */
		/*	database									  */
 		/********************************************************************/
			strcpy ( l_uid_pwd.arr, pstrCmdLine[1]); 
			l_uid_pwd.len = strlen (l_uid_pwd.arr);
			l_uid_pwd.arr[l_uid_pwd.len] = '\0';

		/********************************************************************/
		/*	Added following code to assign facility identifier information*/
		/*	which will be used for retrieving workstation identifier based*/
		/*	on facility.								  */
		/*	Code added by C. Ganesan on 24/03/2003 at 15:10			  */
 		/********************************************************************/
			strcpy ( l_facility_id.arr, pstrCmdLine[4]); 
			l_facility_id.len = strlen (l_facility_id.arr);
			l_facility_id.arr[l_facility_id.len] = '\0';

       	    hdc = BeginPaint ( hWnd, &ps );
		    SetBkColor ( hdc, RGB(192,192,192) );  
		    SetTextColor ( hdc, RGB(0,0,0) );
		    GetClientRect ( hWnd, &rect );
		    open_log_file();     
                OUTPUT_FILE_NAME[0] = '\0';
            
            #ifdef INIT_MESG
               disp_message ( PC_START, INIT_MESG );
            #else                        
		       disp_message ( PC_START, "Process started.  Please wait ...");
            #endif           
	 	    proc_main(noparam, pstrCmdLine);      /* Calling Pro*C program */                       
		    disp_message ( PC_END, "Process Successfully Completed."); 	    
		    EndPaint ( hWnd, &ps );
	       }
	       break;
        case WM_CLOSE :
            fclose ( log_fp);
            DestroyWindow (hWnd);
            break; /* Let this pass thru so default operation can occur. */
        case WM_DESTROY :
            PostQuitMessage(0);
            break;			
        default:
            break;
        } /*switch*/
    /* Performs default operation. */
    return(DefWindowProc(hWnd, message, wParam, lParam) );
} /*SampleWndProc*/

void open_log_file ()
{  
 char uid[31];
 char tmpbuf[128];
 char sql_operation[100];


      disp_message ( PC_START, "Process Initialization" );

/********************************************************************/
/*			    Connect to Database    	       	        */
/********************************************************************/

	strcpy (sql_operation, "CONNENT");

  	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


   	/* EXEC SQL CONNECT :l_uid_pwd; */ 

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
    sqlstm.sqhstv[0] = (         void  *)&l_uid_pwd;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}

  


/********************************************************************/
/*			    Check the MEDICOM Version    		        */
/********************************************************************/

	strcpy (sql_operation, "VERSION");

  	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL EXECUTE
	BEGIN
		IF sm_installation_tab_check THEN 
		   :newversion := 1; /o If sm_installation table exists - 4.1 Standards o/
		ELSE
		   :newversion := 0; /o If sm_installation table not exists - 2.1 Standards o/
		END IF;
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin IF sm_installation_tab_check THEN :newversion := 1 ; E\
LSE :newversion := 0 ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&newversion;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}

			


/***********************************************************************/
/* Based on MEDICOM Version Read values from table or from MEDICOM.INI */
/***********************************************************************/

	if (!newversion)	/* If sm_installation table is not exists - 2.1 Standards */
	{
		get_init_variables_old();
	}
	else			/* If sm_installation table exists - 4.1 Standards */
	{
		get_init_variables_new();
	}			/* End of MEDICOM version checking logic */

/********************************************************************/
/*	Updated code for reading workstation, directory, Pro*C viewer */
/*	ends here. Code updated by C. Ganesan on 25/05/2003 at 16:45  */
/********************************************************************/

	sprintf ( LOG_FILE_NAME, "%s%s.LOG",WORKING_DIR,strtok(pstrCmdLine[0], "."));
	
	if ( pstrCmdLine[1] != NULL )
	   strcpy ( uid, pstrCmdLine[1] );   
      else
    	   uid[0] = '\0';		
	
	memset ( line_char, '_', 79);   
	line_char[79] = '\0';

	if ((log_fp = fopen(LOG_FILE_NAME, "w")) == NULL )
	{
	   disp_message ( ERR_MESG, "Log File Opening Error...");
	   proc_exit();
	}     
	fprintf ( log_fp, "%34s IBA Health\n", " " );
	fprintf ( log_fp, "%34s =======\n\n", " " );
	fprintf ( log_fp, "%30s Process Log File\n", " " );
	fprintf ( log_fp, "%30s ================\n\n", " " );
      strcpy  ( PROCESS_NAME,  strtok(pstrCmdLine[0], ".") );	
	fprintf ( log_fp, " Process Name : %s ", PROCESS_NAME );
	_strdate( tmpbuf );
	fprintf ( log_fp, " \t\t\t Created on : %s ",
											tmpbuf); 
	_strtime( tmpbuf );
	fprintf ( log_fp, "%s\n",tmpbuf); 
										
	fprintf ( log_fp, " User id      : %s\n", strtok( uid, "/" ));	
	fprintf ( log_fp, "%79s\n\n",line_char);
 	return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )55;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (sqlca.sqlcode == 1405 )
   {
	if (!strcmp (sql_operation, "VERSION") )
		sprintf (tmpbuf, "Unable to get MEDICOM version");
   }
   else
	sprintf (tmpbuf, "Error occured in open_log_file : %s", sqlca.sqlerrm.sqlerrmc );

   MessageBox ( hWnd, tmpbuf, "Error", MB_OK|MB_ICONSTOP);
   exit(0);
}   

void get_init_variables_old()
{
/********************************************************************/
/*	Read Pro*C Output directory and Pro*C viewer from MEDICOM.INI */
/********************************************************************/

     	GetPrivateProfileStringA("Reports","Dir","",WORKING_DIR,sizeof(WORKING_DIR),"medicom.ini");
	GetPrivateProfileStringA("Reports","proc","",szProcView,sizeof(szProcView),"medicom.ini");
}


void get_init_variables_new()
{
 char sql_operation[100];
 char tmpbuf[128];


/*********************************************************************/
/*	Updated code for reading workstation, directory, Pro*C viewer  */
/*	from tables. Code updated by C. Ganesan on 25/05/2003 at 16:45 */
/*********************************************************************/

	set_meduser_role();

	strcpy (sql_operation, "WORKSTATION");

/*
	sprintf (tmpbuf, "Facility Id: %s", l_facility_id.arr);
	MessageBox ( hWnd, tmpbuf, "Note", MB_OK);
*/

/********************************************************************/
/*			Reading Workstation Identifier 			  */
/********************************************************************/

	/* EXEC SQL EXECUTE
	BEGIN
		workstation.get_workstation_id (:l_facility_id, :l_workstation_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin workstation . get_workstation_id ( :l_facility_id , :l\
_workstation_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )70;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_workstation_id;
 sqlstm.sqhstl[1] = (unsigned int  )33;
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

			

	l_workstation_id.arr[l_workstation_id.len] = '\0';

/*
	sprintf (tmpbuf, "Workstation Id: %s", l_workstation_id.arr);
	MessageBox ( hWnd, tmpbuf, "Note", MB_OK);
*/

/********************************************************************/
/*			Reading Pro*C Output Directory 			  */
/*	Copy some temporary value to l_error_text.arr to avoid 	  */
/*	Fetched Column Value is Null Error                 		  */
/********************************************************************/

	strcpy (l_error_text.arr, "$test$");
	l_error_text.len = strlen (l_error_text.arr);
	l_error_text.arr[l_error_text.len] = '\0';

	strcpy (l_dir_name.arr, "$test$");
	l_dir_name.len = strlen (l_dir_name.arr);
	l_dir_name.arr[l_dir_name.len] = '\0';


	strcpy (l_user_id.arr, strtok (l_uid_pwd.arr, "/")); 

/*
	sprintf (tmpbuf, "User Name: %s", l_user_id.arr);
	MessageBox ( hWnd, tmpbuf, "Note", MB_OK);
*/

	l_user_id.len = strlen (l_user_id.arr);
	l_user_id.arr[l_user_id.len] = '\0';

/*Added by shanmugam on 16/01/07 for internatilization */
/*Purpose :- initlization of newly added variable l_language_id */

	strcpy (l_language_id.arr, "$$");
	l_language_id.len = strlen (l_language_id.arr);
	l_language_id.arr[l_language_id.len] = '\0';

/*
	sprintf (tmpbuf, "Language ID: %s", l_language_id.arr);
	MessageBox ( hWnd, tmpbuf, "Note", MB_OK);
*/

/* Ends here */


	strcpy (sql_operation, "DIRECTORY");

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


/*Modified by shanmugam on 16/01/07 for internationlization*/
/*Modification :- l_language_id variable is included according to the db procedure*/

	/* EXEC SQL EXECUTE
	BEGIN
		appprint.get_report_output_directory (
			:l_user_id,
			:l_workstation_id,
			:l_language_id,
			:l_dir_name,
			:l_error_text);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin appprint . get_report_output_directory ( :l_user_id , \
:l_workstation_id , :l_language_id , :l_dir_name , :l_error_text ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )93;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_user_id;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_workstation_id;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_language_id;
 sqlstm.sqhstl[2] = (unsigned int  )6;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_dir_name;
 sqlstm.sqhstl[3] = (unsigned int  )122;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_error_text;
 sqlstm.sqhstl[4] = (unsigned int  )503;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}

			


/********************************************************************/
/*	Check the return value of l_error_text.arr and if it is	  */
/*	not equal to the Passed temporary value, raise an error       */
/********************************************************************/

	l_error_text.arr[l_error_text.len] = '\0';
	if ( (l_error_text.len > 0) && (strcmp (l_error_text.arr, "$test$")) )
	{
	   sprintf (tmpbuf, "Error in Open_log_file (): %s", l_error_text.arr);
	   MessageBox ( hWnd, tmpbuf, "Error", MB_OK|MB_ICONSTOP);
	   exit(0);
	}

/********************************************************************/
/*	Assign read directory information to WORKING_DIR varaiable    */
/********************************************************************/
/*
	sprintf (tmpbuf, "Directory Name: %s", l_dir_name.arr);
	MessageBox ( hWnd, tmpbuf, "Note", MB_OK);

*/

	l_dir_name.arr[l_dir_name.len] = '\0';
	if ( (l_dir_name.len > 0) && (!strcmp (l_dir_name.arr, "$test$")) )
	{
	   sprintf (tmpbuf, "Report Directory Name not defined for %s Application User and/or %s Workstation",
				l_user_id.arr, l_workstation_id.arr);
	   MessageBox ( hWnd, tmpbuf, "Error", MB_OK|MB_ICONSTOP);
	   exit(0);
	}


	strcpy (WORKING_DIR, l_dir_name.arr);

/********************************************************************/
/* Added by Shanmugam on 16/01/07 for internationlization		  */
/* Purpose :- Check the return value of l_language_id.arr 		  */	 
/********************************************************************/
/*
	sprintf (tmpbuf, "Language ID: %s", l_language_id.arr);
	MessageBox ( hWnd, tmpbuf, "Note", MB_OK);
*/

	l_language_id.arr[l_language_id.len] = '\0';
	if ( (l_language_id.len > 0) && (!strcmp (l_language_id.arr, "$$")) )
	{
	   sprintf (tmpbuf, "Language ID is not defined for %s Application User ",l_user_id.arr);
	   MessageBox ( hWnd, tmpbuf, "Error", MB_OK|MB_ICONSTOP);
	   exit(0);
	}
/* Ends Here */


/********************************************************************/
/*			Reading Pro*C Output Viewer Tool			  */
/*	Copy some temporary value to l_error_text.arr to avoid 	  */
/*	Fetched Column Value is Null Error                 		  */
/********************************************************************/

	strcpy (l_error_text.arr, "$test$");
	l_error_text.len = strlen (l_error_text.arr);
	l_error_text.arr[l_error_text.len] = '\0';

	strcpy (l_proc_viewer.arr, "$test$");
	l_proc_viewer.len = strlen (l_proc_viewer.arr);
	l_proc_viewer.arr[l_proc_viewer.len] = '\0';

	strcpy (l_param_id.arr, "PROC");
	l_param_id.len = strlen (l_param_id.arr);
	l_param_id.arr[l_param_id.len] = '\0';

	strcpy (sql_operation, "PROC");

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL EXECUTE
	BEGIN
		workstation.get_ws_param (
				:l_workstation_id,
				:l_param_id,
				:l_proc_viewer,
				:l_error_text);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin workstation . get_ws_param ( :l_workstation_id , :l_pa\
ram_id , :l_proc_viewer , :l_error_text ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )128;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_workstation_id;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_param_id;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_proc_viewer;
 sqlstm.sqhstl[2] = (unsigned int  )122;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_error_text;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}

			


/********************************************************************/
/*	Check the return value of l_error_text.arr and if it is	  */
/*	not equal to the Passed temporary value, raise an error       */
/********************************************************************/

	l_error_text.arr[l_error_text.len] = '\0';
	if ( (l_error_text.len > 0) && (strcmp (l_error_text.arr, "$test$")) )
	{
	   sprintf (tmpbuf, "Error while reading Pro*C Viewer: %s", l_error_text.arr);
	   MessageBox ( hWnd, tmpbuf, "Error", MB_OK|MB_ICONSTOP);
	   exit(0);
	}

/********************************************************************/
/*	Assign read Pro*C Viewer information to szProcView varaiable  */
/********************************************************************/

/*
	sprintf (tmpbuf, "Pro*C Viewer: %s", l_proc_viewer.arr);
	MessageBox ( hWnd, tmpbuf, "Note", MB_OK);
*/

	l_proc_viewer.arr[l_proc_viewer.len] = '\0';
	if ( (l_proc_viewer.len > 0) && (!strcmp (l_proc_viewer.arr, "$test$")) )
	{
	   sprintf (tmpbuf, "Default Pro*C Viewer is not defined and/or Pro*C Viewer is not defined for % Workstation", 
					l_workstation_id.arr);
	   MessageBox ( hWnd, tmpbuf, "Error", MB_OK|MB_ICONSTOP);
	   exit(0);
	}

	strcpy (szProcView, l_proc_viewer.arr);

	strcpy (sql_operation, "COMMIT");

	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )159;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
 if (sqlca.sqlcode < 0) goto err_exit;
}


	return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
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



   if (sqlca.sqlcode == 1405 )
   {
	if (!strcmp (sql_operation, "WORKSTATION") )
		sprintf (tmpbuf, "Unable to get Workstation Identifier");
	else if (!strcmp (sql_operation, "DIRECTORY") )
		sprintf (tmpbuf, "Report Output Directory not defined");
	else if (!strcmp (sql_operation, "PROC") )
		sprintf (tmpbuf, "Pro*C Report Viewer not defined");
   }
   else
	sprintf (tmpbuf, "Error occured in get_init_variables_new() : %s", 
									sqlca.sqlerrm.sqlerrmc );

   MessageBox ( hWnd, tmpbuf, "Error", MB_OK|MB_ICONSTOP);
   exit(0);

}


void disp_message ( type, text )
int type;
char *text;
{  
char msg_text[200];
char cmd_str[150]; 
int ret_val;
	
	switch ( type ) {
		case PC_START :
			 DrawText ( hdc, text, -1, &rect, DT_SINGLELINE | DT_CENTER |
													DT_VCENTER );
		      /* Following line is added by C. Ganesan on 16/06/2002 at 21:30 to fix 
			   refresh issue on Pro*C display box */

			 ValidateRect (hWnd, &ps);

			 return;
		case PC_END :                       
	      	 fprintf ( log_fp, "%79s\n\n%27s *** End of Log File ***\n\n",
			           line_char, " ");		
	    	 fclose(log_fp);              

#ifndef ONLINE_PRINTING                
#ifdef VIEW_LOG_FILE
			sprintf ( msg_text, "Process Successful. \n\n Press OK to view log file.");										

			if ( MessageBox ( hWnd, msg_text, "Note", MB_OKCANCEL) == IDOK )   
			{
    			   sprintf ( cmd_str, "%s %s",szProcView,LOG_FILE_NAME );		    
			   ret_val = WinExec(cmd_str, SW_SHOWNORMAL);	    
	    		   if ( ret_val < 32 )
	    		      MessageBox (hWnd, "Error in opening log file.", "error", MB_OK);
			}   
#else     
           if ( strlen(OUTPUT_FILE_NAME) > 0 )
	          sprintf ( REP_FILE_NAME, "%s%s",WORKING_DIR,OUTPUT_FILE_NAME );
           else
 	          sprintf ( REP_FILE_NAME, "%s%s.LIS",WORKING_DIR,PROCESS_NAME ); 

			sprintf ( msg_text, "Process Successful. \n\n Press OK to view report.");										
			if ( MessageBox ( hWnd, msg_text, "Note", MB_OKCANCEL) == IDOK )   
			{
    			   sprintf ( cmd_str, "%s %s",szProcView,REP_FILE_NAME );		    
			   ret_val = WinExec(cmd_str, SW_SHOWNORMAL);	    
	    		   if ( ret_val < 32 )
	    		      MessageBox (hWnd, "Error in opening report.", "Error", MB_OK);
			}   
#endif          
#endif  

	 		SendMessage (hWnd, WM_CLOSE, 0, 0L );
			return;
		case INFO_MESG :
			fprintf ( log_fp, "%s\n",text);			 
			return;
		case ERR_MESG :
			fprintf ( log_fp, "%s\n", text );
			MessageBox ( hWnd, text, "Error", MB_ICONSTOP );			
			return;         
		case ORA_MESG :
			strcat ( text, "\n\n");
			strcat ( text, sqlca.sqlerrm.sqlerrmc );
			fprintf ( log_fp, "%s\n",  text );
			MessageBox ( hWnd, text, "Oracle Error", MB_ICONSTOP );			
			return;			
		case DISP_MESG :
			fprintf ( log_fp, "%s\n", text );
			MessageBox ( hWnd, text, "Information", MB_OK|MB_ICONINFORMATION );			
			return;    			
		default :
			return;        
                    }  /* End of switch */                    
}


void proc_exit ()
{ 
char log_str[175];
char cmd_str[150];                                     
int ret_val;                                

	fprintf ( log_fp, "%79s\n\n%27s *** End of Log File ***\n\n",
							line_char, " ");			
    	fclose(log_fp);
	sprintf ( log_str, "Process Unsuccessful. \n\n Press OK to view error log file.");										

	 if ( MessageBox ( hWnd, log_str, "Note", MB_OKCANCEL) == IDOK )
	 {                      
	   	sprintf ( cmd_str, "%s %s",szProcView,LOG_FILE_NAME );		    
		ret_val = WinExec (cmd_str, SW_SHOWNORMAL);	  
	    	if ( ret_val < 32 )
	    	   MessageBox (hWnd, "Error in opening log file.", 
							"error", MB_OK);
 	 }   
	SendMessage (hWnd, WM_CLOSE, 0, 0L );
        exit (0);
}       
                                                         	
