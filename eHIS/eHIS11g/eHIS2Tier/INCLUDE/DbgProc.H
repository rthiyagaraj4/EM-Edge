/******************************************************************
*
*	Name			DbgProc.H
*
*	Author			K S Sundar
*
*	Purpose			Declares procedures used in DEBUG.H
*					This file is a substitute for WinProc.H
*					Pro*C Programs that are not included with
*					WinrProc.H need to include this header file.
*
*	Creation Date	Sep 23, 2002
*
*   ==============
*	Coding History  
*   ===============================================================
*	Date		Person		Remarks
*   ===============================================================
*	Sep 23,2002	K S Sundar	Created.
*
*******************************************************************/

#include <process.h>
#include <windows.h>  
#include <stdlib.h> 
#include <dos.h>
#include <crtdbg.h>
#include <assert.h>
#include <time.h>

/*
* Variables required for creating window. 
*/
HWND		hwnd;
MSG			msg;
WNDCLASS 	wndclass;

/*
* Variables
*/ 
FILE               *log_fp;
char               LOG_FILE_NAME[150]; 
char  		 WORKING_DIR[120]; 
char               szProcView[80];


void enable_or_disable_debugging(char *p_debug_program_name);
void open_log_file(char *p_program_name, char *p_uid_pwd);
void close_log_file();



/*
*
* Function  open_log_file()
* Author    K S Sundar
* Purpose   To open the  log file.
*
*/
void open_log_file(char *p_program_name, char *p_uid_pwd)
{  
	char    line_char[80];
	char	*v_uid;
	char	*v_pwd;
	char	*v_dbname;
	char	v_tmpbuf[128];
	time_t	ltime;					/* Current time */


	v_uid=strtok(p_uid_pwd,"/");
	v_pwd=strtok(NULL,"@");
	v_dbname=strtok(NULL,"");

	/*	
	 * Following code for reading MEDICOM.INI is updated by C. Ganesan on 26/10/2002 at 19:00
	 * to read information from database 
	 *
 	
	GetPrivateProfileStringA("Reports","Dir","",WORKING_DIR,sizeof(WORKING_DIR),"medicom.ini");
 	 *
	 */

	sprintf ( LOG_FILE_NAME, "%s%s.LOG",WORKING_DIR,p_program_name);

	memset ( line_char, '_', 79);   
	line_char[79] = '\0';

	if ((log_fp = fopen(LOG_FILE_NAME, "w")) == NULL )
	{
		MessageBox ( hwnd, "Log File Opening Error!! Program aborting ...", "Error", MB_OK|MB_ICONSTOP);
		exit(0);
	}     

	fprintf ( log_fp, "%34s MEDICOM\n", " " );
	fprintf ( log_fp, "%34s =======\n\n", " " );
	fprintf ( log_fp, "%30s Process Log File\n", " " );
	fprintf ( log_fp, "%30s ================\n\n", " " );
	fprintf ( log_fp, " Process Name : %s ", p_program_name);
    time( &ltime );
	fprintf ( log_fp, " \t\t Created on : %s",ctime( &ltime )); 
	_strtime( v_tmpbuf );
	fprintf ( log_fp, " User id      : %s\n", v_uid);	
	fprintf ( log_fp, " Database     : %s\n", v_dbname);	
	fprintf ( log_fp, "%79s\n\n",line_char);

	/*
	* Enable or disable debugging.
	*/
	enable_or_disable_debugging(p_program_name);

 	return;
}   


void close_log_file()
{  
	char    line_char[80];

	memset ( line_char, '_', 79);   
	line_char[79] = '\0';

	fprintf ( log_fp, "%79s\n\n%27s *** End of Log File ***\n\n",
			           line_char, " ");	
	fflush (log_fp);
	
	fclose (log_fp);              

 	return;
}   
