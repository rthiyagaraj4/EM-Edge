
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
           char  filnam[42];
};
static const struct sqlcxp sqlfpn =
{
    41,
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blrrsenq.PC"
};


static unsigned int sqlctx = 1288468835;


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
            void  *sqhstv[11];
   unsigned int   sqhstl[11];
            int   sqhsts[11];
            void  *sqindv[11];
            int   sqinds[11];
   unsigned int   sqharm[11];
   unsigned int   *sqharc[11];
   unsigned short  sqadto[11];
   unsigned short  sqtdso[11];
} sqlstm = {12,11};

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

 static const char *sq0003 = 
"select a.operating_facility_id ,b.processing_interval ,FLOOR((((sysdate-a.st\
arted_date)* 24)* 60)) ,a.machine_name ,a.started_by_id ,TO_CHAR(sysdate,'ddmm\
yyhh24miss') ,TO_NUMBER(to_char(sysdate,'hh24mi'))  from sy_bg_process_control\
 a ,sy_prog_id b where ((a.pgm_id=b.pgm_id and a.started_date is  not null ) a\
nd TO_CHAR(a.started_date,'DDMMYYHH24MISS')=:b0)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,0,0,30,233,0,0,0,0,0,1,0,
20,0,0,0,0,0,27,246,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
51,0,0,3,369,0,9,409,0,0,1,1,0,1,0,1,9,0,0,
70,0,0,3,0,0,13,417,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,3,0,0,
113,0,0,4,182,0,5,434,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
136,0,0,3,0,0,15,457,0,0,0,0,0,1,0,
151,0,0,5,0,0,29,459,0,0,0,0,0,1,0,
166,0,0,6,0,0,29,539,0,0,0,0,0,1,0,
181,0,0,7,43,0,4,610,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
204,0,0,8,44,0,4,615,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
227,0,0,9,46,0,4,620,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
254,0,0,10,72,0,4,625,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
277,0,0,11,820,0,6,692,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,1,0,0,2,9,0,0,
308,0,0,12,493,0,6,735,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
351,0,0,13,306,0,4,790,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,
398,0,0,14,279,0,4,870,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
441,0,0,15,279,0,4,951,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
484,0,0,16,73,0,5,1105,0,0,1,1,0,1,0,1,9,0,0,
503,0,0,17,56,0,2,1129,0,0,1,1,0,1,0,1,9,0,0,
522,0,0,18,371,0,3,1236,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,
569,0,0,19,467,0,6,1285,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,
0,3,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,3,3,0,0,3,3,0,0,
628,0,0,20,470,0,6,1349,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,3,9,0,0,2,9,0,0,3,9,0,0,
2,9,0,0,2,1,0,0,
671,0,0,21,75,0,4,1403,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
694,0,0,22,82,0,4,1435,0,0,1,0,0,1,0,2,9,0,0,
713,0,0,23,119,0,4,1442,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
740,0,0,24,142,0,3,1489,0,0,4,4,0,1,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRRSENQ                                     */
/* DESCRIPTION		 : Printer Server Report 		        */
/* AUTHOR                : S. Sheelvant                                 */
/* DATE WRITTEN          : 12-DEC-1998                                  */
/* MODIFIED BY           : D. GANESH MURTHI 				*/
/* MODIFIED ON		 : 20-APR-2003		  			*/
/************************************************************************/

#include <stdio.h>
#include <string.h>
#include <bl1.h>
#include <windows.h>       
#include <winspool.h>
#include <malloc.h>
#include <debug.h>

#define OERROR 		(sqlca.sqlcode < 0)
#define NOT_FOUND 	(sqlca.sqlerrd[2] == 0)
#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define RESOURCE_BUSY	(sqlca.sqlcode == -54)
#define max_lines   50

#define RESTART_INTERVAL 2
#define RESTART_TIME     500

#define ESC 0x1B
#define SEP 0xFA   

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR	uid_pwd				[132],  
			d_curr_pgm_name     [15],
			nd_file_name        [151],
			today				[20],
			nd_file_no          [150],
			d_user_id_pwd       [100],
 			d_facility_id       [3],
			nd_facility_id      [3],
			er_msg              [71],
			nd_fm_doc_type  	[31],
			nd_fm_doc_num		[31],
			nd_to_doc_type		[31],
			nd_to_doc_num		[31],
			nd_fm_doc_date		[31],
			nd_to_doc_date		[31],
			trx_type 			[2],
			row_id				[100],
			d_cashfacility_id	[3],

    			nd_reprint_yn		[2],
			discount_print_yn	[2],
			sett_print_yn		[2]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[151]; } nd_file_name;

struct { unsigned short len; unsigned char arr[20]; } today;

struct { unsigned short len; unsigned char arr[150]; } nd_file_no;

struct { unsigned short len; unsigned char arr[100]; } d_user_id_pwd;

struct { unsigned short len; unsigned char arr[3]; } d_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[71]; } er_msg;

struct { unsigned short len; unsigned char arr[31]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[31]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[31]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[31]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[31]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[31]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[2]; } trx_type;

struct { unsigned short len; unsigned char arr[100]; } row_id;

struct { unsigned short len; unsigned char arr[3]; } d_cashfacility_id;

struct { unsigned short len; unsigned char arr[2]; } nd_reprint_yn;

struct { unsigned short len; unsigned char arr[2]; } discount_print_yn;

struct { unsigned short len; unsigned char arr[2]; } sett_print_yn;


	int		k  = 0, 
			l_report_id_len = 0;

	/* VARCHAR		nd_patient_id        [21],	 
			nd_rowid		[31],
			bl_ctl_sp_no	            [10],
			bl_ctl_source_code	    [5],
			bl_hdr_urgent_indicator  [2],
			bl_print_result_sect_yn	[2],
			d_sleep_secs			[10],
			d_machine_name   		[40],
			d_started_by_id			[20],
			sy_user_id				[30],
			sy_session_id			[30],
			sy_req_date				[30],
			sy_machine_name			[16],
			sy_ws_no				[15],
			sy_rowid				[31],
			sy_acc_entity_name 		[81],
           
			p_uid_pwd				[151], 
			p_print_name			[100], 
			p_loc_type				[10],
			p_loc_code				[100],
			p_rep_file				[151],
			p_print_mode			[10],
			   
			prg_start_date			[30],  
			d_next_start_date		[30],
			d_cmd_line				[4000],
			d_act_cmd_line			[1000],
			d_exe_name				[10],
			d_rem_param				[100],
			d_report_id				[20],
		    l_seq_num				[10],

		    bl_printer_for_urgent_yn [2]; */ 
struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[31]; } nd_rowid;

struct { unsigned short len; unsigned char arr[10]; } bl_ctl_sp_no;

struct { unsigned short len; unsigned char arr[5]; } bl_ctl_source_code;

struct { unsigned short len; unsigned char arr[2]; } bl_hdr_urgent_indicator;

struct { unsigned short len; unsigned char arr[2]; } bl_print_result_sect_yn;

struct { unsigned short len; unsigned char arr[10]; } d_sleep_secs;

struct { unsigned short len; unsigned char arr[40]; } d_machine_name;

struct { unsigned short len; unsigned char arr[20]; } d_started_by_id;

struct { unsigned short len; unsigned char arr[30]; } sy_user_id;

struct { unsigned short len; unsigned char arr[30]; } sy_session_id;

struct { unsigned short len; unsigned char arr[30]; } sy_req_date;

struct { unsigned short len; unsigned char arr[16]; } sy_machine_name;

struct { unsigned short len; unsigned char arr[15]; } sy_ws_no;

struct { unsigned short len; unsigned char arr[31]; } sy_rowid;

struct { unsigned short len; unsigned char arr[81]; } sy_acc_entity_name;

struct { unsigned short len; unsigned char arr[151]; } p_uid_pwd;

struct { unsigned short len; unsigned char arr[100]; } p_print_name;

struct { unsigned short len; unsigned char arr[10]; } p_loc_type;

struct { unsigned short len; unsigned char arr[100]; } p_loc_code;

struct { unsigned short len; unsigned char arr[151]; } p_rep_file;

struct { unsigned short len; unsigned char arr[10]; } p_print_mode;

struct { unsigned short len; unsigned char arr[30]; } prg_start_date;

struct { unsigned short len; unsigned char arr[30]; } d_next_start_date;

struct { unsigned short len; unsigned char arr[4000]; } d_cmd_line;

struct { unsigned short len; unsigned char arr[1000]; } d_act_cmd_line;

struct { unsigned short len; unsigned char arr[10]; } d_exe_name;

struct { unsigned short len; unsigned char arr[100]; } d_rem_param;

struct { unsigned short len; unsigned char arr[20]; } d_report_id;

struct { unsigned short len; unsigned char arr[10]; } l_seq_num;

struct { unsigned short len; unsigned char arr[2]; } bl_printer_for_urgent_yn;

	
   int d_time_interval =0,
       d_starting_time =0,
       er_msg_type =0,
       source_copies =1;
	   

   int	page_length = 50, 
	v_lno, 
	LENGTH_WORDS, 
	v_pno, 
	no_of_times;
   
   char l_should_print_yn;
   char nd_f_name[151];
   char l_mesg[300];

   char l_print_request_yn = 'Y',l_report_tool_ind = 'C',temp[200];
   
   /* VARCHAR l_printer_ids[1000],
	   l_printer_names[1000],
	   l_printer_types[1000],
	   l_queue_names[1000],
	   l_no_of_copies[1000],
	   l_errortext[1000],
	   l_logo_yniflaser[1000],
	   LOGO_DIR[1000],
	   l_logo_name[1000],
	   l_sy_prog_id[10],
	   l_errorlevel[10],	   
	   l_sysmessageid[10]; */ 
struct { unsigned short len; unsigned char arr[1000]; } l_printer_ids;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_names;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_types;

struct { unsigned short len; unsigned char arr[1000]; } l_queue_names;

struct { unsigned short len; unsigned char arr[1000]; } l_no_of_copies;

struct { unsigned short len; unsigned char arr[1000]; } l_errortext;

struct { unsigned short len; unsigned char arr[1000]; } l_logo_yniflaser;

struct { unsigned short len; unsigned char arr[1000]; } LOGO_DIR;

struct { unsigned short len; unsigned char arr[1000]; } l_logo_name;

struct { unsigned short len; unsigned char arr[10]; } l_sy_prog_id;

struct { unsigned short len; unsigned char arr[10]; } l_errorlevel;

struct { unsigned short len; unsigned char arr[10]; } l_sysmessageid;


   int	   l_dmp = 0, l_lsr = 0;

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





#include<winproc.h>

FILE *fp;
int   err_flag = 0;
int   copy = 0;
int   MAX_LINES = 27;

char nd_repo_file_name[151];

char val_strng[1000], string_var[1000];     

int i = 0;
     
DWORD sleep_sec = 0;

int last_page = 0;
char LVFunctionName[64];

void proc_main(argc,argv)
char *argv[];
int argc;
{
	char sep[3]=" ";
	char *lv_uid_pwd, *lv_session_id, *lv_session_datetime;
	char *lv_ws_no;
	int  lv_ret_flag;
	char tmpbuf[500];

	int rec_found = 0;  
   
	if (argc < 3)
	{ ins_message(ERR_MESG,"Usage : Blrrsenq uid/password start_date facility_id");
      proc_exit();
	}
 
	strcpy(d_user_id_pwd.arr,argv[1]);

	strcpy(g_pgm_id,"BLRRSENQ");
	strcpy(d_curr_pgm_name.arr,g_pgm_id); 
	d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 
	strcpy(prg_start_date.arr,argv[2]);
   
	prg_start_date.len = strlen(argv[2]);

	strcpy(sy_session_id.arr,argv[3]);
	sy_session_id.len = strlen(sy_session_id.arr);

	if(sql_connect(argv[1]) == -1)
	{ ins_message(ORA_MESG,"Error in connecting to Oracle");
      proc_exit();
	}

	set_meduser_role();

    strcpy(GVProgramID, "BLRRSENQ");
	EnableOrDisableTracing();

	if (IS_TRACING) 
	{	strcpy(LVFunctionName, "MainProc()");
		Trace(LVFunctionName, "Begin");
	}
  
	strcpy(d_facility_id.arr,argv[4]); 
	d_facility_id.len = strlen(d_facility_id.arr);
	d_facility_id.arr[d_facility_id.len] = '\0';

	strcpy(g_facility_id, d_facility_id.arr);
	strcpy(g_session_id, sy_session_id.arr);  

	declare_cursor();

	rec_found = get_sleep_secs();

	if(rec_found)
	{
		if (IS_TRACING) 
		{
			Trace(LVFunctionName," before get_company_name()");
		}
	   
		get_company_name();

   		if (IS_TRACING) 
		{
			Trace(LVFunctionName,"after get_company_name ");
			Trace(LVFunctionName,"before process_rec() ");
		}

		process_rec();
	  
   		if (IS_TRACING) 
		{
			Trace(LVFunctionName,"after process_rec() ");
			Trace(LVFunctionName,"End Main Proc");
		}

	}
   
	// ##To be removed
	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 0;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
		ins_message(ORA_MESG,"ROLLBACK WORK RELEASE failed");
	
	return;
}

sql_connect(l_nd_ap_uid_pwd)
char l_nd_ap_uid_pwd[];
{
  strcpy(uid_pwd.arr,l_nd_ap_uid_pwd);
  uid_pwd.len = strlen(uid_pwd.arr);

  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )20;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
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



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}

declare_cursor()
{
   /* EXEC SQL DECLARE bg_process_cursor
			 CURSOR 
				FOR 
			 SELECT a.operating_facility_id,
					b.processing_interval ,
					FLOOR((sysdate-a.started_date)*24*60),
					a.machine_name,
					a.started_by_id,
					TO_CHAR(sysdate,'ddmmyyhh24miss'),
					TO_NUMBER(to_char(sysdate,'hh24mi'))
			   FROM	sy_bg_process_control a, 
					sy_prog_id b
			  WHERE a.pgm_id = b.pgm_id
				AND a.started_date IS NOT NULL
				AND TO_CHAR(a.started_date,'DDMMYYHH24MISS') = :prg_start_date; */ 


   if (OERROR)
       ins_message(ORA_MESG,"Select failed on table SY_REPORT_GENERATE_REQUEST");
}

get_sleep_secs()
{
	/*
	
	According to suggestion by Mr. Kuila, Instead of givng seperate SELECT, INSERT and DELETE,
	CURSOR is declared in declaration session, with in which the Update Statement will be given.

	Instead of Insertion and deletion, update will be the effective process and hence 
	changed.

	Modified on 03/02/2004
    
	d_sleep_secs.arr[0] 	= '\0';
	d_machine_name.arr[0] 	= '\0';
	d_started_by_id.arr[0] 	= '\0';
	d_next_start_date.arr[0]= '\0';

	d_sleep_secs.len	= 0;
	d_machine_name.len	= 0;
	d_started_by_id.len	= 0;
	d_next_start_date.len	= 0;

	_flushall();
 
	 EXEC SQL SELECT a.operating_facility_id,
					 b.processing_interval ,
					 floor((sysdate-a.started_date)*24*60),
					 a.machine_name,
					 a.started_by_id,
					 to_char(sysdate,'ddmmyyhh24miss'),
					 to_number(to_char(sysdate,'hh24mi'))
			   INTO	:d_facility_id,
					:d_sleep_secs,
					:d_time_interval,
					:d_machine_name,
					:d_started_by_id,
					:d_next_start_date,
					:d_starting_time
			   FROM	SY_BG_PROCESS_CONTROL A, sy_prog_id B
			  WHERE A.PGM_ID = B.PGM_ID	
				AND a.PGM_ID = 'BLRRSENQ'
				AND a.STARTED_DATE IS NOT NULL
				AND TO_CHAR(a.STARTED_DATE,'DDMMYYHH24MISS') = :prg_start_date;

	d_facility_id.arr[d_facility_id.len] = '\0';
	d_sleep_secs.arr[d_sleep_secs.len] = '\0';
	d_machine_name.arr[d_machine_name.len] = '\0';
	d_started_by_id.arr[d_started_by_id.len] = '\0';
	d_next_start_date.arr[d_next_start_date.len] = '\0';

    sprintf(val_strng,"[%s]-facl [%s]-sleep sec [%s]-machinename [%s]-start_by [%s]-nextstartdt, [%s] prgst_date ",
	     d_facility_id.arr, d_sleep_secs.arr,  d_machine_name.arr,
         d_started_by_id.arr, d_next_start_date.arr, prg_start_date.arr);
  
   	if (IS_TRACING) 
	{
			Trace(LVFunctionName,val_strng);
	}

	if (d_time_interval > RESTART_INTERVAL)
	{		 
		EXEC SQL INSERT INTO SY_BG_PROCESS_CONTROL	 (OPERATING_FACILITY_ID  ,
													  PGM_ID                 ,
													  MACHINE_NAME           ,
													  STARTED_BY_ID          ,
													  STARTED_DATE           ,
													  PRIORITY               ,
													  SERVICED_REQUESTS      )
					VALUES							 (:d_facility_id,
													  'BLRRSENQ',
													  :d_machine_name,
													  :d_started_by_id,
													  TO_DATE(:d_next_start_date, 'ddmmyyhh24miss'),
													  3,
													  'BLRRSENQ');  
		if (OERROR)
			sprintf(val_strng,"[%s]-facl [%s]-machine_name [%s]-started_by [%s]-machinename [%s]-start_by [%s]-nextstartdt",
								d_facility_id.arr, d_machine_name.arr,
								d_started_by_id.arr, d_next_start_date.arr);

   		if (IS_TRACING) 
		{
			Trace(LVFunctionName,val_strng);
		}

			  
		EXEC SQL DELETE 
		           FROM SY_BG_PROCESS_CONTROL 
				  WHERE PGM_ID='BLRRSENQ'
					AND STARTED_DATE IS NOT NULL
					AND STARTED_DATE <= TO_DATE(:prg_start_date,'DDMMYYHH24MISS');

		sprintf(val_strng," IN delete [%s]-prg_start_date",prg_start_date.arr);
   		if (IS_TRACING) 
		{
				Trace(LVFunctionName,val_strng);
		}

		d_sleep_secs.arr[d_sleep_secs.len] = '\0';
		d_machine_name.arr[d_machine_name.len] = '\0';
		d_started_by_id.arr[d_started_by_id.len] = '\0';
		d_next_start_date.arr[d_next_start_date.len]='\0';


		EXEC SQL COMMIT;

		strcpy(prg_start_date.arr,d_next_start_date.arr);
		prg_start_date.len = strlen(prg_start_date.arr);

		sprintf(val_strng," new value [%s]-prg_start_date",prg_start_date.arr);
   		if (IS_TRACING) 
		{
				Trace(LVFunctionName,val_strng);
		}
	}

	if(NOT_FOUND) 
	{
		return FALSE;
	}
	else 
	{
		d_sleep_secs.arr[d_sleep_secs.len] = '\0';
        sleep_sec = (DWORD) atol(d_sleep_secs.arr);
		sleep_sec = atol(d_sleep_secs.arr);
	    return TRUE;
	}   
	*/

   	if (IS_TRACING) 
	{
			Trace(LVFunctionName," BEGIN get_sleep_secs() ");
	}

	/* EXEC SQL OPEN bg_process_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0003;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&prg_start_date;
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



	d_facility_id.arr[0]		= '\0';
	d_sleep_secs.arr[0] 		= '\0';
	d_machine_name.arr[0] 		= '\0';
	d_started_by_id.arr[0] 		= '\0';
	d_next_start_date.arr[0]	= '\0';

	/* EXEC SQL FETCH bg_process_cursor
	          INTO :d_facility_id,
				   :d_sleep_secs,
				   :d_time_interval,
				   :d_machine_name,
				   :d_started_by_id,
				   :d_next_start_date,
				   :d_starting_time; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )70;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_sleep_secs;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_time_interval;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_machine_name;
 sqlstm.sqhstl[3] = (unsigned int  )42;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_started_by_id;
 sqlstm.sqhstl[4] = (unsigned int  )22;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_next_start_date;
 sqlstm.sqhstl[5] = (unsigned int  )32;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_starting_time;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
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



	d_facility_id.arr[d_facility_id.len]		= '\0';
	d_sleep_secs.arr[d_sleep_secs.len]			= '\0';
	d_machine_name.arr[d_machine_name.len]		= '\0';
	d_started_by_id.arr[d_started_by_id.len]	= '\0';
	d_next_start_date.arr[d_next_start_date.len]= '\0';

	if (d_time_interval > RESTART_INTERVAL)
	{
		/* EXEC SQL UPDATE sy_bg_process_control
					SET started_date = TO_DATE(:d_next_start_date, 'ddmmyyhh24miss')
				  WHERE pgm_id = 'BLRRSENQ'					
				    AND started_date IS NOT NULL
					AND TO_CHAR(started_date,'DDMMYYHH24MISS') = :prg_start_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update sy_bg_process_control  set started_date=TO_DATE(:b0,\
'ddmmyyhh24miss') where ((pgm_id='BLRRSENQ' and started_date is  not null ) an\
d TO_CHAR(started_date,'DDMMYYHH24MISS')=:b1)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )113;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_next_start_date;
  sqlstm.sqhstl[0] = (unsigned int  )32;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&prg_start_date;
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




		if (OERROR)
		{
			ins_message(ORA_MESG,"Select failed on table SY_REPORT_GENERATE_REQUEST");
			return 0;
		}

		strcpy(prg_start_date.arr,d_next_start_date.arr);
		prg_start_date.len = strlen(prg_start_date.arr);

		if (IS_TRACING) 
		{
			Trace(LVFunctionName," END get_sleep_secs() ");
		}

	}

	/* EXEC SQL CLOSE bg_process_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )136;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	/* EXEC SQL COMMIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )151;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
	{
		ins_message(ORA_MESG,"ERROR CLOSING bg_process_cursor");
		return 0;
	}

	if(NOT_FOUND) 
	{
		return FALSE;
	}
	else 
	{
		d_sleep_secs.arr[d_sleep_secs.len] = '\0';
        sleep_sec = (DWORD) atol(d_sleep_secs.arr);
		sleep_sec = atol(d_sleep_secs.arr);
	    return TRUE;
	}   
}

process_rec()
{  
	int i = 0;
	int j = 0,corr_stat = 0;
	int sy_prg_param_found =0;
	int record_exist = 0;
	char test[6],group_test[6];
	_flushall();

    if (IS_TRACING) 
	{
			Trace(LVFunctionName," Start In process_rec() ");
	}

	 
	while (get_sleep_secs())
	{	//-----1
		_flushall();
		record_exist = fetch_sy_bg_rep_gen_req_u();
		if (!record_exist)
	   		record_exist = fetch_sy_bg_rep_gen_req_s();

		if (!record_exist)
	   		record_exist = fetch_sy_bg_rep_gen_req();

		while (record_exist)
		{ //---2
			if (!get_sleep_secs()) 
				break;
              
			MAX_LINES = (page_length - 5) ; 
			
			/*	if (fetch_sy_prog_param())
			{*/	
			//---3
			err_flag = 0;
		       	      
			gen_file_name();
             		 
			_flushall();
		
		    print_report();

		    _flushall();

				print_job();

		    _flushall();

			if(err_flag)
			{
				update_sy_bg_rep_gen_req();
			}
			else
			{
				delete_sy_bg_rep_gen_req();
				/*delete_sy_prog_param();*/
            }
   
            /* EXEC SQL COMMIT WORK; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 12;
            sqlstm.arrsiz = 7;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )166;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)4352;
            sqlstm.occurs = (unsigned int  )0;
            sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



 			/*} //-----3*/

			/*sprintf(string_var,"after request count increment=%d\n",request_count);
			disp_message(ORA_MESG,string_var);*/

			record_exist = fetch_sy_bg_rep_gen_req_u();
			if (!record_exist)
	   			record_exist = fetch_sy_bg_rep_gen_req_s();

			if (!record_exist)
	   			record_exist = fetch_sy_bg_rep_gen_req();

        }//---2
		   
        if (sleep_sec)  
           Sleep(sleep_sec);
    } //---1

    if (IS_TRACING) 
	{
		Trace(LVFunctionName,"End In process_rec() ");
	}
}

print_report()
{

    if (IS_TRACING) 
	{
		Trace(LVFunctionName,"Begin In print_report() ");
	}


		//sprintf(string_var,"orig cmd line : %s",d_cmd_line.arr);
		//disp_message(ERR_MESG,string_var);
		
		k = strlen(d_cmd_line.arr)- 9;
		l_report_id_len = strlen(d_cmd_line.arr)- 7;
		// last 8 chars are report id

		d_act_cmd_line.arr[0]	 = '\0';
		d_act_cmd_line.len = 0;		

		l_sy_prog_id.arr[0] = '\0';
		l_sy_prog_id.len = 0;
		
		d_exe_name.arr[0]	= '\0';
		d_exe_name.len = 0;

		d_rem_param.arr[0]	= '\0';
		d_rem_param.len = 0;


		d_report_id.arr[0] = '\0';
		d_report_id.len = 0;

		
	
		/*
		EXEC SQL SELECT SUBSTR(:d_cmd_line,1,8),
						SUBSTR(:d_cmd_line,10,8),
						SUBSTR(:d_cmd_line,19,:k), 
						rtrim(ltrim(SUBSTR(rtrim(ltrim(:d_cmd_line)),-8)))
				 into :l_sy_prog_id, :d_exe_name, :d_rem_param, :d_report_id
				 FROM DUAL;
	
		*/
				
	    
		/* EXEC SQL SELECT SUBSTR(:d_cmd_line,1,8)
					
				  into :l_sy_prog_id
		FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SUBSTR(:b0,1,8) into :b1  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )181;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_cmd_line;
  sqlstm.sqhstl[0] = (unsigned int  )4002;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_sy_prog_id;
  sqlstm.sqhstl[1] = (unsigned int  )12;
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



		/* EXEC SQL SELECT SUBSTR(:d_cmd_line,10,8)
					
				  into :d_exe_name
		FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SUBSTR(:b0,10,8) into :b1  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )204;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_cmd_line;
  sqlstm.sqhstl[0] = (unsigned int  )4002;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_exe_name;
  sqlstm.sqhstl[1] = (unsigned int  )12;
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



		/* EXEC SQL SELECT SUBSTR(:d_cmd_line,19,:k) 
						
				  into :d_rem_param
		FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SUBSTR(:b0,19,:b1) into :b2  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )227;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_cmd_line;
  sqlstm.sqhstl[0] = (unsigned int  )4002;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&k;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_rem_param;
  sqlstm.sqhstl[2] = (unsigned int  )102;
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



        /* EXEC SQL SELECT rtrim(ltrim(SUBSTR(rtrim(ltrim(:d_cmd_line)),-8)))
					
				  into :d_report_id
		FROM DUAL; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 7;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select rtrim(ltrim(SUBSTR(rtrim(ltrim(:b0)),(-8)))) i\
nto :b1  from DUAL ";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )254;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_cmd_line;
        sqlstm.sqhstl[0] = (unsigned int  )4002;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_report_id;
        sqlstm.sqhstl[1] = (unsigned int  )22;
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


		

	

		/*
		EXEC SQL SELECT SUBSTR(:d_cmd_line,1,8),
					SUBSTR(:d_cmd_line,10,:k), 
					rtrim(ltrim(SUBSTR(rtrim(ltrim(:d_cmd_line)),-8)))
				  into :d_exe_name, :d_rem_param, :d_report_id
		FROM DUAL;
		*/	
		
		l_sy_prog_id.arr[l_sy_prog_id.len] = '\0';
		d_exe_name.arr[strlen(d_exe_name.arr)] = '\0';
		d_rem_param.arr[strlen(d_rem_param.arr)] = '\0';
		d_report_id.arr[d_report_id.len] = '\0';
		
	

		sprintf(d_act_cmd_line.arr,"%s %s %s %s",d_exe_name.arr,
						d_user_id_pwd.arr,d_rem_param.arr,nd_file_no.arr);

		d_cmd_line.arr[0]	 = '\0';
		d_cmd_line.len = 0;		
										
		d_act_cmd_line.len = strlen(d_act_cmd_line.arr);
		d_act_cmd_line.arr[d_act_cmd_line.len] = '\0';


    if (IS_TRACING) 
	{
		Trace(LVFunctionName,"IN command line");
	}

		get_report_tool();   // Will decide PROC / REPORT WRITER

		if (l_report_tool_ind == 'R')
		{
		      
			   call_submit_report();
		}

		else
		{
		
			system(d_act_cmd_line.arr);
		}
		

	//	exit(0); 
  

    if (IS_TRACING) 
	{
		Trace(LVFunctionName,"End In print_report() ");
	}
        
		
}

get_report_tool()
{

	/* EXEC SQL EXECUTE
	DECLARE
		l_sys_mesg_id VARCHAR2(10);
		l_err_level VARCHAR2(10);
		l_err_text VARCHAR2(1000);
		l_document_value blcommon.rectype_Tab;
		l_logo_yn VARCHAR2(1) := 'N';		
	BEGIN
		blcommon.get_doc_print_format_Tab(
     			:nd_facility_id,
			:d_report_id,
			l_document_value,
			l_sys_mesg_id,
			l_err_level,
			l_err_text);	

		FOR i IN l_document_value.FIRST..l_document_value.LAST LOOP
			
			if  l_document_value(i).id = 'LOGO_YN' then 
				l_logo_yn := l_document_value(i).value;
			end if;	

			if l_document_value(i).id = 'REPORT_TOOL_IND' then 
				:l_report_tool_ind := NVL(l_document_value(i).value,'C');
			end if;		 	

			if l_document_value(i).id = 'LOGO_FILE_NAME' then 
				:l_logo_name := l_document_value(i).value;
			end if;		
		END LOOP;		

		IF NVL(l_logo_yn,'N') = 'N' then 
			:l_logo_name := NULL;
		END IF;	

		
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare l_sys_mesg_id VARCHAR2 ( 10 ) ; l_err_level VARCHAR2\
 ( 10 ) ; l_err_text VARCHAR2 ( 1000 ) ; l_document_value blcommon . rectype_T\
ab ; l_logo_yn VARCHAR2 ( 1 ) := 'N' ; BEGIN blcommon . get_doc_print_format_T\
ab ( :nd_facility_id , :d_report_id , l_document_value , l_sys_mesg_id , l_err\
_level , l_err_text ) ; FOR i IN l_document_value . FIRST .. l_document_value \
. LAST LOOP if l_document_value ( i ) . id = 'LOGO_YN' then l_logo_yn := l_doc\
ument_value ( i ) . value ; end if ; if l_document_value ( i ) . id = 'REPORT_\
TOOL_IND' then :l_report_tool_ind := NVL ( l_document_value ( i ) . value , 'C\
' ) ; end if ; if l_document_value ( i ) . id = 'LOGO_FILE_NAME' then :l_logo_\
name := l_document_value ( i ) . value ; end if ; END LOOP ; IF NVL ( l_logo_y\
n , 'N' ) = 'N' then :l_logo_name := NULL ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )277;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_report_id;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_report_tool_ind;
 sqlstm.sqhstl[2] = (unsigned int  )1;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_logo_name;
 sqlstm.sqhstl[3] = (unsigned int  )1002;
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

call_submit_report()
{

/* EXEC SQL EXECUTE	
DECLARE
	l_print_status BOOLEAN;
	p_error_text VARCHAR2(4000);
BEGIN

	APPPRINT.SUBMIT_ORACLE_REPORT
			 (:sy_ws_no,
			  :nd_facility_id,
			  'BL',
			  NVL(:d_report_id,'BLRRSENQ'),
			  'P', --p_report_option
			  '',  --p_outputfile_format
			  '',  --p_outputfile_name
			  'O',
			  ' ', --p_location_code
			  NULL, --:l_printer_names,
			  NULL,
			  NULL, --p_page_from
			  NULL, --p_page_to
			  NULL, --p_print_mode
			  'P_LOGO_NAME='||:l_logo_name||'+'||'P_PGM_ID='||:l_sy_prog_id||'+'
			  ||'P_PGM_DATE='||:sy_req_date||'+'||'P_SESSION_ID='||:sy_session_id||'+'||
			  'P_OPERATING_FACILITY_ID='||:nd_facility_id, 
			  l_print_status, --OUT BOOLEAN,
			  p_error_text);							  


END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare l_print_status BOOLEAN ; p_error_text VARCHAR2 ( 4000\
 ) ; BEGIN APPPRINT . SUBMIT_ORACLE_REPORT ( :sy_ws_no , :nd_facility_id , 'BL\
' , NVL ( :d_report_id , 'BLRRSENQ' ) , 'P' , '' , '' , 'O' , ' ' , NULL , NUL\
L , NULL , NULL , NULL , 'P_LOGO_NAME=' || :l_logo_name || '+' || 'P_PGM_ID=' \
|| :l_sy_prog_id || '+' || 'P_PGM_DATE=' || :sy_req_date || '+' || 'P_SESSION_\
ID=' || :sy_session_id || '+' || 'P_OPERATING_FACILITY_ID=' || :nd_facility_id\
 , l_print_status , p_error_text ) ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )308;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&sy_ws_no;
sqlstm.sqhstl[0] = (unsigned int  )17;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
sqlstm.sqhstl[1] = (unsigned int  )5;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&d_report_id;
sqlstm.sqhstl[2] = (unsigned int  )22;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&l_logo_name;
sqlstm.sqhstl[3] = (unsigned int  )1002;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&l_sy_prog_id;
sqlstm.sqhstl[4] = (unsigned int  )12;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&sy_req_date;
sqlstm.sqhstl[5] = (unsigned int  )32;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&sy_session_id;
sqlstm.sqhstl[6] = (unsigned int  )32;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
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

fetch_sy_bg_rep_gen_req_u()
{
if (IS_TRACING) 
	{
			Trace(LVFunctionName," Start In fetch_sy_bg_rep_gen_req_u() ");
	}

	sy_user_id.arr[0] 		= '\0';
	sy_session_id.arr[0] 	= '\0';
	sy_req_date.arr[0]      = '\0';
	sy_machine_name.arr[0]  = '\0';
	sy_ws_no.arr[0]			= '\0';
	sy_rowid.arr[0]			= '\0';
	d_cmd_line.arr[0]		= '\0';
	
	sy_session_id.len		= 0;
	sy_user_id.len	        = 0;
	sy_req_date.len         = 0;
	sy_machine_name.len     = 0;
	sy_ws_no.len            = 0;
	sy_rowid.len            = 0;
	d_cmd_line.len			= 0;

/* EXEC SQL 
	SELECT	OPERATING_FACILITY_ID,
			SESSION_ID,
			USER_ID,
			TO_CHAR(REQUEST_DATE,'DDMMYYHH24MISS'),
			MACHINE_NAME,
			WS_NO,
			ROWID,
			CMD_LINE_ARG
	INTO	:nd_facility_id,
			:sy_session_id,
            :sy_user_id,
            :sy_req_date,
			:sy_machine_name,
			:sy_ws_no,
			:sy_rowid,
			:d_cmd_line
	 FROM	SY_REPORT_GENERATE_REQUEST
	 WHERE	PGM_ID = 'BLRRSENQ'
			AND REQUEST_STATUS IS NULL
			AND NVL(URGENT_INDICATOR,' ') = 'U'
	 AND 	ROWNUM = 1; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 8;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select OPERATING_FACILITY_ID ,SESSION_ID ,USER_ID ,TO_CHAR(RE\
QUEST_DATE,'DDMMYYHH24MISS') ,MACHINE_NAME ,WS_NO ,ROWID ,CMD_LINE_ARG into :b\
0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_REPORT_GENERATE_REQUEST where (((PGM_ID\
='BLRRSENQ' and REQUEST_STATUS is null ) and NVL(URGENT_INDICATOR,' ')='U') an\
d ROWNUM=1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )351;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
sqlstm.sqhstl[0] = (unsigned int  )5;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&sy_session_id;
sqlstm.sqhstl[1] = (unsigned int  )32;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&sy_user_id;
sqlstm.sqhstl[2] = (unsigned int  )32;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&sy_req_date;
sqlstm.sqhstl[3] = (unsigned int  )32;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&sy_machine_name;
sqlstm.sqhstl[4] = (unsigned int  )18;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&sy_ws_no;
sqlstm.sqhstl[5] = (unsigned int  )17;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&sy_rowid;
sqlstm.sqhstl[6] = (unsigned int  )33;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&d_cmd_line;
sqlstm.sqhstl[7] = (unsigned int  )4002;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
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
         ins_message(ORA_MESG,"Select failed on table SY_REPORT_GENERATE_REQUEST");

      if(NOT_FOUND) 
      	  return FALSE;
      else 
	  {
          	sy_user_id.arr[sy_user_id.len] = '\0';
          	sy_session_id.arr[sy_session_id.len] = '\0';
          	sy_rowid.arr[sy_rowid.len] = '\0';
          	sy_req_date.arr[sy_req_date.len] = '\0';
		sy_machine_name.arr[sy_machine_name.len] = '\0';
		sy_ws_no.arr[sy_ws_no.len] = '\0';
		sy_rowid.arr[sy_rowid.len] = '\0';

		d_cmd_line.len = strlen(d_cmd_line.arr);
		d_cmd_line.arr[d_cmd_line.len] = '\0';


   	      return TRUE;
	  }


if (IS_TRACING) 
	{
			Trace(LVFunctionName," End In fetch_sy_bg_rep_gen_req_u() ");
	}
}

/*------------------------*/

fetch_sy_bg_rep_gen_req_s()
{

if (IS_TRACING) 
	{
			Trace(LVFunctionName," Start In fetch_sy_bg_rep_gen_req_s() ");
	}

	sy_user_id.arr[0] 		= '\0';
	sy_session_id.arr[0] 	= '\0';
	sy_req_date.arr[0]      = '\0';
	sy_machine_name.arr[0]  = '\0';
	sy_ws_no.arr[0]			= '\0';
	sy_rowid.arr[0]			= '\0';
	d_cmd_line.arr[0]		= '\0';

	sy_session_id.len		= 0;
	sy_user_id.len	        = 0;
	sy_req_date.len         = 0;
	sy_machine_name.len     = 0;
	sy_ws_no.len            = 0;
	sy_rowid.len            = 0;
	d_cmd_line.len			= 0;
	

/* EXEC SQL SELECT SESSION_ID,
		USER_ID,
		TO_CHAR(REQUEST_DATE,'DDMMYYHH24MISS'),
		MACHINE_NAME,
		WS_NO,
		ROWID,
		CMD_LINE_ARG
	 INTO	:sy_session_id,
            :sy_user_id,
            :sy_req_date,
			:sy_machine_name,
			:sy_ws_no,
			:sy_rowid,
			:d_cmd_line
	 FROM	SY_REPORT_GENERATE_REQUEST
	 WHERE	PGM_ID = 'BLRRSENQ'
	 AND 	REQUEST_STATUS IS NULL
	 AND 	NVL(URGENT_INDICATOR,' ') = 'S'
	 AND 	ROWNUM = 1; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 8;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select SESSION_ID ,USER_ID ,TO_CHAR(REQUEST_DATE,'DDMMYYHH24M\
ISS') ,MACHINE_NAME ,WS_NO ,ROWID ,CMD_LINE_ARG into :b0,:b1,:b2,:b3,:b4,:b5,:\
b6  from SY_REPORT_GENERATE_REQUEST where (((PGM_ID='BLRRSENQ' and REQUEST_STA\
TUS is null ) and NVL(URGENT_INDICATOR,' ')='S') and ROWNUM=1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )398;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&sy_session_id;
sqlstm.sqhstl[0] = (unsigned int  )32;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&sy_user_id;
sqlstm.sqhstl[1] = (unsigned int  )32;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&sy_req_date;
sqlstm.sqhstl[2] = (unsigned int  )32;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&sy_machine_name;
sqlstm.sqhstl[3] = (unsigned int  )18;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&sy_ws_no;
sqlstm.sqhstl[4] = (unsigned int  )17;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&sy_rowid;
sqlstm.sqhstl[5] = (unsigned int  )33;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&d_cmd_line;
sqlstm.sqhstl[6] = (unsigned int  )4002;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
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



	/*sprintf(string_var,"after select SY_REPORT_GENERATE_REQUEST...urgent ind..S..sysessionid=%s",sy_session_id.arr);
	disp_message(ORA_MESG,string_var);*/
			

      if(OERROR)
         ins_message(ORA_MESG,"Select failed on table SY_REPORT_GENERATE_REQUEST");

      if(NOT_FOUND) 
      	  return FALSE;
      else 
	  {
          	sy_user_id.arr[sy_user_id.len]			= '\0';
          	sy_session_id.arr[sy_session_id.len]	= '\0';
          	sy_rowid.arr[sy_rowid.len]				= '\0';
          	sy_req_date.arr[sy_req_date.len]		= '\0';
			sy_machine_name.arr[sy_machine_name.len]= '\0';
			sy_ws_no.arr[sy_ws_no.len]				= '\0';
			sy_rowid.arr[sy_rowid.len]				= '\0';

			d_cmd_line.len = strlen(d_cmd_line.arr);
			d_cmd_line.arr[d_cmd_line.len]			= '\0';

		

   	      return TRUE;
	  }


if (IS_TRACING) 
	{
			Trace(LVFunctionName," End In fetch_sy_bg_rep_gen_req_s() ");
	}

}

/*-------------------------------*/

fetch_sy_bg_rep_gen_req()
{

if (IS_TRACING) 
	{
			Trace(LVFunctionName," Start In fetch_sy_bg_rep_gen_req()");
	}

	sy_user_id.arr[0] 		= '\0';
	sy_session_id.arr[0] 	= '\0';
	sy_req_date.arr[0]      = '\0';
	sy_machine_name.arr[0]  = '\0';
	sy_ws_no.arr[0]		    = '\0';
	sy_rowid.arr[0]		    = '\0';
	d_cmd_line.arr[0]		= '\0';

	sy_session_id.len	    = 0;
	sy_user_id.len	        = 0;
	sy_req_date.len         = 0;
	sy_machine_name.len     = 0;
	sy_ws_no.len            = 0;
	sy_rowid.len            = 0;
	d_cmd_line.len			= 0;

/* EXEC SQL SELECT
		SESSION_ID,
		USER_ID,
		TO_CHAR(REQUEST_DATE,'DDMMYYHH24MISS'),
		MACHINE_NAME,
		WS_NO,
		ROWID,
		CMD_LINE_ARG
	 INTO  :sy_session_id,
           :sy_user_id,
           :sy_req_date,
		   :sy_machine_name,
		   :sy_ws_no,
		   :sy_rowid,
		   :d_cmd_line
	 FROM	SY_REPORT_GENERATE_REQUEST
	 WHERE	PGM_ID = 'BLRRSENQ'
	 AND 	REQUEST_STATUS IS NULL
	 AND 	NVL(URGENT_INDICATOR,' ') = 'R'
	 AND 	ROWNUM = 1; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 8;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select SESSION_ID ,USER_ID ,TO_CHAR(REQUEST_DATE,'DDMMYYHH24M\
ISS') ,MACHINE_NAME ,WS_NO ,ROWID ,CMD_LINE_ARG into :b0,:b1,:b2,:b3,:b4,:b5,:\
b6  from SY_REPORT_GENERATE_REQUEST where (((PGM_ID='BLRRSENQ' and REQUEST_STA\
TUS is null ) and NVL(URGENT_INDICATOR,' ')='R') and ROWNUM=1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )441;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&sy_session_id;
sqlstm.sqhstl[0] = (unsigned int  )32;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&sy_user_id;
sqlstm.sqhstl[1] = (unsigned int  )32;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&sy_req_date;
sqlstm.sqhstl[2] = (unsigned int  )32;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&sy_machine_name;
sqlstm.sqhstl[3] = (unsigned int  )18;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&sy_ws_no;
sqlstm.sqhstl[4] = (unsigned int  )17;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&sy_rowid;
sqlstm.sqhstl[5] = (unsigned int  )33;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&d_cmd_line;
sqlstm.sqhstl[6] = (unsigned int  )4002;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
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


			
/*sprintf(string_var,"after select SY_REPORT_GENERATE_REQUEST...urgent ind..R..sysessionid=%s",sy_session_id.arr);
disp_message(ORA_MESG,string_var);*/

      if(OERROR)
         ins_message(ORA_MESG,"Select failed on table SY_REPORT_GENERATE_REQUEST");

      if(NOT_FOUND) 
      	  return FALSE;
      else 
	  {
          	sy_user_id.arr[sy_user_id.len]			= '\0';
          	sy_session_id.arr[sy_session_id.len]	= '\0';
          	sy_rowid.arr[sy_rowid.len]				= '\0';
          	sy_req_date.arr[sy_req_date.len]		= '\0';
			sy_machine_name.arr[sy_machine_name.len]= '\0';
			sy_ws_no.arr[sy_ws_no.len]				= '\0';
			sy_rowid.arr[sy_rowid.len]				= '\0';

			d_cmd_line.len = strlen(d_cmd_line.arr);
			d_cmd_line.arr[d_cmd_line.len]			= '\0';

   	      return TRUE;
	  }


if (IS_TRACING) 
	{
			Trace(LVFunctionName," End In fetch_sy_bg_rep_gen_req()");
	}
}
/*------------------------------AS PER ENHANCEMENT IT IS COMMENTED------------------------
fetch_sy_prog_param()
{
if (IS_TRACING) 
	{
			Trace(LVFunctionName," Start In fetch_sy_prog_param()");
	}

   nd_fm_doc_type.arr[0]    = '\0';
   nd_fm_doc_num.arr[0]     = '\0';
   nd_fm_doc_date.arr[0]    = '\0';
   nd_to_doc_type.arr[0]    = '\0';
   nd_to_doc_num.arr[0]     = '\0';
   nd_to_doc_date.arr[0]    = '\0';
   trx_type.arr[0]			= '\0';

   nd_fm_doc_type.len       = 0;
   nd_fm_doc_num.len        = 0;
   nd_fm_doc_date.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_to_doc_num.len        = 0;
   nd_to_doc_date.len       = 0;
   trx_type.len		    = 0;
   nd_rowid.arr[0]	= '\0';
   nd_rowid.len = 0;


   EXEC SQL SELECT OPERATING_FACILITY_ID,
                   NVL(PARAM1,'HGBIOP'),
				   nvl(PARAM2,0),
				   NVL(PARAM3,'HGBIOP'),
                   nvl(PARAM4,99999999),
				   NVL(PARAM5,SYSDATE),
				   NVL(PARAM6,SYSDATE),
				   NVL(PARAM7,'O'),
				   NVL(PARAM8,'Y'),
				   NVL(PARAM9,'N'), NVL(PARAM10,'N'),
				   NVL(PARAM22,operating_facility_id),
				   rowid
            INTO   :d_facility_id,
			       :nd_fm_doc_type, 
				   :nd_fm_doc_num,
                   :nd_to_doc_type, 
				   :nd_to_doc_num, 
   				   :nd_fm_doc_date, :nd_to_doc_date,
   				   :trx_type, :nd_reprint_yn, 
				   :discount_print_yn, :sett_print_yn,
				   :d_cashfacility_id,
				   	:nd_rowid
              FROM SY_PROG_PARAM
              WHERE PGM_ID     = 'BLRRSENQ'
              AND SESSION_ID = :sy_session_id
              AND PGM_DATE   = :sy_req_date;

  //disp_message(ERR_MESG,nd_to_doc_num.arr);
 
  
   d_facility_id.arr[d_facility_id.len]    = '\0';   
   nd_fm_doc_type.arr[nd_fm_doc_type.len]    = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]      = '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]    = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]      = '\0';
   nd_fm_doc_date.arr[nd_fm_doc_date.len]    = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]    = '\0';
   d_cashfacility_id.arr[d_cashfacility_id.len] = '\0';
   trx_type.arr[trx_type.len]	  	     = '\0';


      if (OERROR)
	  {
         ins_message(ORA_MESG,"Select failed on table SY_PROG_PARAM");		 
		 update_sy_bg_rep_gen_req();
		 err_flag = 1;
	   }

      if (NOT_FOUND) 
	  {	
		err_flag = 1;
		update_sy_bg_rep_gen_req();
		return 0;
	  }
	      


if (IS_TRACING) 
	{
			Trace(LVFunctionName," End In fetch_sy_prog_param()");
	}

	return 1;
}

*/
/*-----------------------------------------------------------*/

update_sy_bg_rep_gen_req()
{

if (IS_TRACING) 
	{
			Trace(LVFunctionName," Start In update_sy_bg_rep_gen_req()");
	}

   /* EXEC SQL UPDATE SY_REPORT_GENERATE_REQUEST
               SET REQUEST_STATUS = 'E'
			 WHERE ROWID = :sy_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "update SY_REPORT_GENERATE_REQUEST  set REQUEST_STATUS='E' \
where ROWID=:b0";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )484;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&sy_rowid;
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


   if(OERROR) 
      ins_message(ERR_MESG,"Failed in upd_sy_bg_rep_gen_req()");       

if (IS_TRACING) 
	{
			Trace(LVFunctionName," End In update_sy_bg_rep_gen_req()");
	}

}
/*------------------------------------------------------------*/
delete_sy_bg_rep_gen_req()
{
   char test[100];

if (IS_TRACING) 
	{
			Trace(LVFunctionName," Start In delete_sy_bg_rep_gen_req()");
	}



   /* EXEC SQL DELETE FROM SY_REPORT_GENERATE_REQUEST
             WHERE ROWID = :sy_rowid; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_REPORT_GENERATE_REQUEST  where ROWID=:b0";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )503;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&sy_rowid;
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


   if(OERROR) 
      ins_message(ERR_MESG,"Failed in delete_sy_bg_rep_gen_req");


if (IS_TRACING) 
	{
			Trace(LVFunctionName," End In delete_sy_bg_rep_gen_req()");
	}


}
/*------------------------------------------------------------*/
/*
delete_sy_prog_param()
{  

if (IS_TRACING) 
	{
			Trace(LVFunctionName," Start In delete_sy_bg_rep_gen_req()");
			
		}


  EXEC SQL DELETE FROM SY_PROG_PARAM
			 WHERE PGM_ID     = 'BLRRSENQ'
              AND SESSION_ID = :sy_session_id
              AND PGM_DATE   = :sy_req_date;

   if(OERROR) 
      ins_message(ERR_MESG,"Failed in delete_sy_prog_param");

 if (IS_TRACING) 
	{
			Trace(LVFunctionName," End In delete_sy_bg_rep_gen_req()");
			
		}


}
*/
/*----------------------------------------------------------*/
print_job()
{
	char er_cd[10];
	char print_yn = 'Y';
	int i;   

if (IS_TRACING) 
	{
		Trace(LVFunctionName," Start In print_job()");
	}

	 p_uid_pwd.arr[0] = '\0';
	 p_print_name.arr[0] = '\0';
	 p_loc_code.arr[0] = '\0';
	 p_loc_type.arr[0] = '\0';
	 
	 p_rep_file.arr[0] = '\0';
	 p_print_mode.arr[0] = '\0';

	 p_uid_pwd.len = 0;
	 p_print_name.len = 0;
	 p_loc_code.len = 0;
	 p_loc_type.len = 0;
	 p_rep_file.len = 0;
	 p_print_mode.len = 0;

	strcpy(p_uid_pwd.arr,uid_pwd.arr);
	p_uid_pwd.len = strlen(uid_pwd.arr);

	strcpy(p_print_name.arr,"BLRRSENQ");
	p_print_name.len = strlen(p_print_name.arr);

   	 strcpy(p_loc_type.arr,trx_type.arr);
   	 p_loc_type.len = strlen(p_loc_type.arr);

	strcpy(p_rep_file.arr,nd_f_name);
	p_rep_file.len = strlen(nd_f_name);

	strcpy(p_print_mode.arr,"S");
	p_print_mode.len = strlen(p_print_mode.arr);


	get_print_request();  /* decides whether print request is required or not */

//disp_message(ERR_MESG,"AFTER get_print_request");
//sprintf(temp,"%c",l_print_request_yn);
//disp_message(ERR_MESG,temp);

//sprintf(temp,"%c",l_report_tool_ind);
//disp_message(ERR_MESG,temp);



	//if (print_yn == 'Y')   
	//if (l_print_request_yn == 'Y' || l_report_tool_ind != 'R')   	

	if (l_report_tool_ind != 'R' && l_print_request_yn == 'Y')   	
	{
	  strcpy(p_loc_type.arr,"O");
	  p_loc_type.len = strlen(p_loc_type.arr);

		for( i = 0; i < source_copies; i++)
		{

		 /* EXEC SQL
	          INSERT INTO SY_REPORT_PRINT_REQUEST
			  (OPERATING_FACILITY_ID,
			   USER_ID,MACHINE_NAME,WS_NO,MODULE_ID,ONLINE_PRINT_NAME,
			   DEST_LOCN_TYPE,DEST_LOCN_CODE,ONLINE_PRINT_FILE_NAME,
			   PRINT_MODE,REQUEST_DATE,PROCESS_TYPE,PRINT_IMMEDIATE_YN,
			   PRINT_PRIORITY,SELECTION_CRITERIA)
		  VALUES
			  (:nd_facility_id,
			   :sy_user_id,:sy_machine_name,:sy_ws_no,'BL',NVL(:d_report_id,'BLRRSENQ'),
			   :p_loc_type,  NULL ,:p_rep_file,
			   'S',SYSDATE, 'S', 'Y', 
			   DECODE(:bl_hdr_urgent_indicator,'U','1','3'),
			   NULL
			  ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_REPORT_PRINT_REQUEST (OPERATING_FACILITY_ID\
,USER_ID,MACHINE_NAME,WS_NO,MODULE_ID,ONLINE_PRINT_NAME,DEST_LOCN_TYPE,DEST_LO\
CN_CODE,ONLINE_PRINT_FILE_NAME,PRINT_MODE,REQUEST_DATE,PROCESS_TYPE,PRINT_IMME\
DIATE_YN,PRINT_PRIORITY,SELECTION_CRITERIA) values (:b0,:b1,:b2,:b3,'BL',NVL(:\
b4,'BLRRSENQ'),:b5,null ,:b6,'S',SYSDATE,'S','Y',DECODE(:b7,'U','1','3'),null \
)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )522;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&sy_user_id;
   sqlstm.sqhstl[1] = (unsigned int  )32;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&sy_machine_name;
   sqlstm.sqhstl[2] = (unsigned int  )18;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&sy_ws_no;
   sqlstm.sqhstl[3] = (unsigned int  )17;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_report_id;
   sqlstm.sqhstl[4] = (unsigned int  )22;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&p_loc_type;
   sqlstm.sqhstl[5] = (unsigned int  )12;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&p_rep_file;
   sqlstm.sqhstl[6] = (unsigned int  )153;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&bl_hdr_urgent_indicator;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
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
		    disp_message(ERR_MESG,sqlca.sqlerrm.sqlerrmc);
		    ins_message(ERR_MESG,"Insert Failed on SY_REPORT_PRINT_REQUEST");
		}
       
     sprintf(val_strng,"[%s]-fac.[%s]usrid[%s]macnam[%s]wsno[%s]loctype,[%s]rpfile ",
			d_facility_id.arr, sy_user_id.arr,sy_machine_name.arr,sy_ws_no.arr,
			p_loc_type.arr,p_rep_file.arr);
	
		
	  //disp_message(ERR_MESG,val_strng);				
	
			_flushall();		
	}  
  }
	

if (IS_TRACING) 
	{
		Trace(LVFunctionName," End In print_job()");
	}

}			   

/*----------------------------------------------------------*/


get_print_request()
{     
	l_errortext.arr[0] = '\0';
	l_errortext.len = 0;

	/* EXEC SQL EXECUTE
	BEGIN

	     APPPRINT.GET_ROUTING_PRINTERS(
		:sy_ws_no,
		:nd_facility_id,
		'BL',
		NVL(:d_report_id,'BLRRSENQ'),
		'O',
		' ',
		:l_printer_ids,
		:l_printer_names,
		:l_printer_types ,
		:l_queue_names,
		:l_no_of_copies,
		:l_errortext);		 

		:l_dmp := NVL(instr(:l_printer_types,'D'),0);
		:l_lsr := NVL(instr(:l_printer_types,'S'),0);			 

		if :l_dmp != 0 and :l_lsr != 0 then 
		   :l_dmp := 0;
		   --if there is one laser, then output will be laser
		end if;	

		if :l_dmp = 0 and :l_lsr = 0 then 
		   :l_lsr := 1;
		   --Default is Laser Format
		end if;	 				
		
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin APPPRINT . GET_ROUTING_PRINTERS ( :sy_ws_no , :nd_faci\
lity_id , 'BL' , NVL ( :d_report_id , 'BLRRSENQ' ) , 'O' , ' ' , :l_printer_id\
s , :l_printer_names , :l_printer_types , :l_queue_names , :l_no_of_copies , :\
l_errortext ) ; :l_dmp := NVL ( instr ( :l_printer_types , 'D' ) , 0 ) ; :l_ls\
r := NVL ( instr ( :l_printer_types , 'S' ) , 0 ) ; if :l_dmp != 0 and :l_lsr \
!= 0 then :l_dmp := 0 ; end if ; if :l_dmp = 0 and :l_lsr = 0 then :l_lsr := 1\
 ; end if ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )569;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sy_ws_no;
 sqlstm.sqhstl[0] = (unsigned int  )17;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_report_id;
 sqlstm.sqhstl[2] = (unsigned int  )22;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_printer_ids;
 sqlstm.sqhstl[3] = (unsigned int  )1002;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_printer_names;
 sqlstm.sqhstl[4] = (unsigned int  )1002;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_printer_types;
 sqlstm.sqhstl[5] = (unsigned int  )1002;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_queue_names;
 sqlstm.sqhstl[6] = (unsigned int  )1002;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_no_of_copies;
 sqlstm.sqhstl[7] = (unsigned int  )1002;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_errortext;
 sqlstm.sqhstl[8] = (unsigned int  )1002;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_dmp;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_lsr;
 sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
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

	

//disp_message(ERR_MESG,"after APPPRINT");	
//disp_message(ERR_MESG,l_printer_ids.arr);	
//disp_message(ERR_MESG,l_printer_names.arr);	
//disp_message(ERR_MESG,l_printer_types.arr);



	  if (l_errortext.arr[0] != '\0')
	  {    	
		ins_message(ERR_MESG,l_errortext.arr);
		l_errortext.arr[0] = '\0';
		l_errortext.len = 0;

	  }
	

	  l_logo_yniflaser.arr[0] = 'N';
	  
	  l_errorlevel.arr[0] = '\0';
	  l_errorlevel.len = 0;

	  l_sysmessageid.arr[0] = '\0';
	  l_sysmessageid.len = 0;

	  l_errortext.arr[0] = '\0';
	  l_errortext.len = 0;
	

	  if (l_lsr != 0 && l_dmp == 0)
	  {	   	  

		   /* EXEC SQL EXECUTE	
		   BEGIN									

			BLOPIN.GET_PRINT_SETUP_COL_VALUE(
				:nd_facility_id,
				:d_exe_name,
				'PRINT_LOGO_YN_IF_LASER',
				:l_logo_yniflaser,
				:l_errorlevel,
				:l_sysmessageid,
				:l_errortext) ;			
				
			:l_logo_yniflaser := nvl(:l_logo_yniflaser,'N');			

			if :l_logo_yniflaser = 'Y' then 
				:l_print_request_yn := 'N';
			else
				:l_print_request_yn := 'Y';
			end if;
			

			if :l_sysmessageid is not null then
				:l_errorlevel := '10';
				:l_errortext := blcommon.get_error_text(:l_sysmessageid);
			end if;			
		   

		   END;
		   END-EXEC; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "begin BLOPIN . GET_PRINT_SETUP_COL_VALUE ( :nd_facility_\
id , :d_exe_name , 'PRINT_LOGO_YN_IF_LASER' , :l_logo_yniflaser , :l_errorleve\
l , :l_sysmessageid , :l_errortext ) ; :l_logo_yniflaser := nvl ( :l_logo_ynif\
laser , 'N' ) ; if :l_logo_yniflaser = 'Y' then :l_print_request_yn := 'N' ; e\
lse :l_print_request_yn := 'Y' ; end if ; if :l_sysmessageid is not null then \
:l_errorlevel := '10' ; :l_errortext := blcommon . get_error_text ( :l_sysmess\
ageid ) ; end if ; END ;";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )628;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_exe_name;
     sqlstm.sqhstl[1] = (unsigned int  )12;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&l_logo_yniflaser;
     sqlstm.sqhstl[2] = (unsigned int  )1002;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&l_errorlevel;
     sqlstm.sqhstl[3] = (unsigned int  )12;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&l_sysmessageid;
     sqlstm.sqhstl[4] = (unsigned int  )12;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&l_errortext;
     sqlstm.sqhstl[5] = (unsigned int  )1002;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&l_print_request_yn;
     sqlstm.sqhstl[6] = (unsigned int  )1;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
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


		   if (strcmp(l_errorlevel.arr,"10") == 0 && l_errortext.arr[0] != '\0')
		   {
			ins_message(ERR_MESG,l_errortext.arr);
			l_errorlevel.arr[0] = '\0';
			l_errorlevel.len = 0;

			l_sysmessageid.arr[0] = '\0';
			l_sysmessageid.len = 0;

			l_errortext.arr[0] = '\0';
			l_errortext.len = 0;
		   }
	    }	    
	  
}

get_company_name()
{

	if (IS_TRACING) 
	{
			Trace(LVFunctionName," Start In get_company_name()");
	}


    /* EXEC SQL  SELECT ACC_ENTITY_NAME  
	      INTO   :sy_acc_entity_name
	      FROM   SY_ACC_ENTITY
	      WHERE  ACC_ENTITY_ID = :d_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME into :b0  from SY_ACC_ENTITY where\
 ACC_ENTITY_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )671;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sy_acc_entity_name;
    sqlstm.sqhstl[0] = (unsigned int  )83;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
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
         ins_message(ORA_MESG,"Select failed on table SY_ACC_ENTITY");

    sy_acc_entity_name.arr[sy_acc_entity_name.len] = '\0'; 

if (IS_TRACING) 
	{
			Trace(LVFunctionName," End In get_company_name()");
	}


}
/*-----------------------------------------------------*/
gen_file_name()
{

if (IS_TRACING) 
	{
		Trace(LVFunctionName," Start In ggen_file_name()");
	}

     nd_file_name.arr[0]   = '\0';
     nd_file_name.len      = 0;
	 nd_file_no.arr[0] = '\0';
	 nd_file_no.len = 0;
	 l_seq_num.arr[0] = '\0';

     /* EXEC SQL SELECT LTRIM(RTRIM(TO_CHAR(BL_PRT_SRV_SEQ.NEXTVAL,'00009')))
				INTO :l_seq_num
				FROM dual; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select LTRIM(RTRIM(TO_CHAR(BL_PRT_SRV_SEQ.nextval ,'0000\
9'))) into :b0  from dual ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )694;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&l_seq_num;
     sqlstm.sqhstl[0] = (unsigned int  )12;
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



	 l_seq_num.arr[l_seq_num.len] = '\0';	
	

 	  /* EXEC SQL SELECT  'BL'||LTRIM(RTRIM(SUBSTR(:sy_machine_name,1,30)))||to_char(sysdate,'yyyymmddsssss')||:l_seq_num||'.lis'
			  INTO    :nd_file_no
	          FROM 	DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (((('BL'||LTRIM(RTRIM(SUBSTR(:b0,1,30))))||to_char\
(sysdate,'yyyymmddsssss'))||:b1)||'.lis') into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )713;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sy_machine_name;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&l_seq_num;
    sqlstm.sqhstl[1] = (unsigned int  )12;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_file_no;
    sqlstm.sqhstl[2] = (unsigned int  )152;
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


	 
	 //sprintf(l_mesg,"1  File Name :   %s",nd_file_no.arr);
	 //disp_message(ERR_MESG,l_mesg);
	  
     if (OERROR)  
         ins_message(ORA_MESG,"Select failed from DUAL");
      
     nd_file_no.arr[nd_file_no.len] = '\0';

     sprintf(nd_file_name.arr,"%s%s", WORKING_DIR,nd_file_no.arr);

	 strcpy(nd_f_name,nd_file_name.arr);
/*
     if ((fp = fopen(nd_file_name.arr,"w")) == NULL)
     {
         ins_message(ERR_MESG,"Error while opening file BL PRINT FILE in gen_file_name");
         proc_exit();
     }

*/

if (IS_TRACING) 
	{
			Trace(LVFunctionName," End In ggen_file_name()");
	}


}

ins_message(int msg_type,char msg[])
{

if (IS_TRACING) 
	{
			Trace(LVFunctionName," Start In ins_message(int msg_type,char msg[])");
	}

   er_msg.arr[0] = '\0';
   er_msg.len = 0;
   er_msg_type = 0;
   strcpy(er_msg.arr,msg);
   er_msg.len = strlen(msg);
   er_msg_type = msg_type;

   /* EXEC SQL
   INSERT INTO SY_PROG_MSG
          (PGM_ID,MSG_TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE)
   VALUES 
          ('BLRRSENQ',:er_msg_type,NULL,:er_msg,SYSDATE,:sy_session_id,
		   :sy_req_date); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_MSG (PGM_ID,MSG_TYPE,MSG_NUM,MSG_DESC,\
MSG_DATE_TIME,SESSION_ID,PGM_DATE) values ('BLRRSENQ',:b0,null ,:b1,SYSDATE,:b\
2,:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )740;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&er_msg_type;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&er_msg;
   sqlstm.sqhstl[1] = (unsigned int  )73;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&sy_session_id;
   sqlstm.sqhstl[2] = (unsigned int  )32;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&sy_req_date;
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




if (IS_TRACING) 
	{
			Trace(LVFunctionName," End In ins_message(int msg_type,char msg[])");
	}


}




