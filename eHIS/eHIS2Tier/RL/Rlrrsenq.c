
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
           char  filnam[41];
};
static const struct sqlcxp sqlfpn =
{
    40,
    "D:\\WORK\\MO-CRF-20101.5\\70262\\Rlrrsenq.pc"
};


static unsigned long sqlctx = 1958134115;


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

 static const char *sq0022 = 
"(NVL(:b2,'*A')='*A' or (:b2='O' and SY_REPORT_GENERATE_REQUEST.WS_NO in (sel\
ect WS_NO  from RL_RESULT_PRINT_OP_WSNO where OPERATING_FACILITY_ID=DECODE(:b0\
,'*A',OPERATING_FACILITY_ID,:b0)))) or (:b2='N' and SY_REPORT_GENERATE_REQUEST\
.WS_NO not  in (select WS_NO  from RL_RESULT_PRINT_OP_WSNO where OPERATING_FAC\
ILITY_ID=DECODE(:b0,'*A',OPERATING_FACILITY_ID,:b0)))))           ";

 static const char *sq0025 = 
"select test_code  from RL_OLE_RESULT_TEXT where (((((patient_id=:b0 and spec\
imen_no=TO_NUMBER(:b1)) and operating_facility_id=:b2) and group_test_code in \
(select test_code  from RL_REQUEST_DETAIL where ((((patient_id=:b0 and specime\
n_no=TO_NUMBER(:b1)) and operating_facility_id=:b2) and NVL(cancelled_yn,'N')<\
>'Y') and (((NVL(result_status,'O') in ('R','P') or (:b6='N' and RESULT_PRINTE\
D_DATE=to_date(:b7,'DD/MM/YYYY HH24:MI:SS'))) or (test_code in (select test_co\
de  from RL_TEST_CODE where (NVL(profile_yn,'N')='Y' and NVL(group_test_yn,'N'\
)='Y')) and (NVL(result_status,'O')='O' or (NVL(result_status,'O') in ('A') an\
d released_date is  not null )))) or (NVL(preliminary_release_yn,'N')='Y' and \
NVL(result_status,'O') in ('A')))))) and test_code in (select test_code  from \
RL_TEST_CODE where NVL(inhibit_report_yn,'N')<>'Y')) and ROWNUM=1) order by te\
st_code            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,542,189,0,0,0,0,0,1,0,
20,0,0,2,76,0,516,235,0,0,1,0,0,1,0,2,9,0,0,
39,0,0,3,292,0,516,244,0,0,6,1,0,1,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,1,
9,0,0,
78,0,0,4,92,0,514,295,0,0,0,0,0,1,0,
93,0,0,5,0,0,541,305,0,0,0,0,0,1,0,
108,0,0,6,76,0,516,359,0,0,1,0,0,1,0,2,9,0,0,
127,0,0,7,320,0,516,368,0,0,7,2,0,1,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
1,9,0,0,1,9,0,0,
170,0,0,8,490,0,516,433,0,0,10,9,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
225,0,0,9,0,0,541,525,0,0,0,0,0,1,0,
240,0,0,10,245,0,518,543,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
275,0,0,11,53,0,517,560,0,0,1,1,0,1,0,1,9,0,0,
294,0,0,12,48,0,516,577,0,0,1,0,0,1,0,2,9,0,0,
313,0,0,13,0,0,539,715,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
344,0,0,14,0,0,543,729,0,0,0,0,0,1,0,
359,0,0,15,178,0,515,742,0,0,6,6,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
398,0,0,16,0,0,541,752,0,0,0,0,0,1,0,
413,0,0,17,157,0,516,765,0,0,3,2,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,
440,0,0,18,287,0,515,774,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
471,0,0,19,175,0,517,786,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
498,0,0,20,0,0,541,795,0,0,0,0,0,1,0,
513,0,0,21,103,0,516,829,0,0,1,0,0,1,0,2,9,0,0,
532,0,0,22,1400,0,521,888,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
583,0,0,22,0,0,527,907,0,0,0,0,0,1,0,
598,0,0,22,0,0,525,955,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
657,0,0,23,97,0,516,993,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
684,0,0,24,122,0,516,1020,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
711,0,0,25,875,0,521,1068,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
758,0,0,25,0,0,527,1089,0,0,0,0,0,1,0,
773,0,0,25,0,0,525,1113,0,0,1,0,0,1,0,2,9,0,0,
792,0,0,26,68,0,516,1136,0,0,1,0,0,1,0,2,9,0,0,
811,0,0,27,58,0,516,1153,0,0,1,0,0,1,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.6                                                  */
/************************************************************************/
/* PROGRAM NAME          : RLRRSENQ                                     */
/* DESCRIPTION             : Test Results report                             */
/* AUTHOR                : S. Sheelvant                                 */
/* DATE WRITTEN          : 11-SEP-1998                                  */
/* MODIFIED BY           : S.SHEELVANT                                     */
/* MODIFIED ON             : 12-DEC-1998                                    */
/************************************************************************/

#include <stdio.h>
#include <string.h>  
//#include "gl.h"
#include "rl.h"
#define NODATAFOUND                (sqlca.sqlcode == 1403)
#define OERROR                     (sqlca.sqlcode < 0)
#define LAST_ROW                 (sqlca.sqlcode == 1403)
#define NOT_FOUND                 (sqlca.sqlerrd[2] == 0)
#define TABLE_ALREADY_EXISTS    (sqlca.sqlcode == -955)
#define RESOURCE_BUSY            (sqlca.sqlcode == -54)

#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1
#define RESTART_INTERVAL 2
#define RESTART_TIME 500
#define INIT_MESG ""

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR nd_operating_facility_id         [5],
           nd_facility_id                    [5],
              nd_priority                        [5],
           uid_pwd                            [1320],
           d_curr_pgm_name                  [15],
           nd_file_name                     [151],
           d_user_id_pwd                    [150],
           d_next_start_date                [30],
           today                            [20],
           d_sleep_secs                        [10],
           d_cmd_line                        [200],
           d_machine_name                    [40],
           d_started_by_id                    [51],
           prg_start_date                    [35],
           er_msg                           [171],
           er_msg_num                        [1500]; */ 
struct { unsigned short len; unsigned char arr[5]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[5]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[5]; } nd_priority;

struct { unsigned short len; unsigned char arr[1320]; } uid_pwd;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[151]; } nd_file_name;

struct { unsigned short len; unsigned char arr[150]; } d_user_id_pwd;

struct { unsigned short len; unsigned char arr[30]; } d_next_start_date;

struct { unsigned short len; unsigned char arr[20]; } today;

struct { unsigned short len; unsigned char arr[10]; } d_sleep_secs;

struct { unsigned short len; unsigned char arr[200]; } d_cmd_line;

struct { unsigned short len; unsigned char arr[40]; } d_machine_name;

struct { unsigned short len; unsigned char arr[51]; } d_started_by_id;

struct { unsigned short len; unsigned char arr[35]; } prg_start_date;

struct { unsigned short len; unsigned char arr[171]; } er_msg;

struct { unsigned short len; unsigned char arr[1500]; } er_msg_num;


    /* VARCHAR sy_user_id        [601],
           sy_session_id        [300],
           sy_req_date            [30],
           sy_machine_name      [600],
           sy_ws_no             [450],
           sy_rowid                [301],
           sql_stmt                [4000]; */ 
struct { unsigned short len; unsigned char arr[601]; } sy_user_id;

struct { unsigned short len; unsigned char arr[300]; } sy_session_id;

struct { unsigned short len; unsigned char arr[30]; } sy_req_date;

struct { unsigned short len; unsigned char arr[600]; } sy_machine_name;

struct { unsigned short len; unsigned char arr[450]; } sy_ws_no;

struct { unsigned short len; unsigned char arr[301]; } sy_rowid;

struct { unsigned short len; unsigned char arr[4000]; } sql_stmt;



    /* VARCHAR d_oracle_report_yn[5]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_oracle_report_yn;

    
    //-- 29052014 Sandeep K Gujje 29-MAY-2014
    /* VARCHAR nd_result_printed_date[21],         
            rl_report_entire_spec_yn[2],
            rl_note_type_test[50]; */ 
struct { unsigned short len; unsigned char arr[21]; } nd_result_printed_date;

struct { unsigned short len; unsigned char arr[2]; } rl_report_entire_spec_yn;

struct { unsigned short len; unsigned char arr[50]; } rl_note_type_test;

    //-----------
    
    //-- 22072014 Sandeep K Gujje 24-JUL-2014
    /* VARCHAR l_customer_id    [10]; */ 
struct { unsigned short len; unsigned char arr[10]; } l_customer_id;
    

    int v_count = 0;

        int l_count = 0;
   int     no_of_dtl_recs = 0,
           d_time_interval =0,
           d_starting_time =0,
           er_msg_type = 0;

    int l_restart_time = 0;

/***** ADDED ON 05/11/2002 BACKGROUND PROCESS MONITOR **********/
    int p_count = 0;
/***** UPTO HERE ADDED ON 05/11/2002 BACKGROUND PROCESS MONITOR **********/

    /* VARCHAR    language_id            [5]; */ 
struct { unsigned short len; unsigned char arr[5]; } language_id;

    
/************* ADDED ON 04/01/2013 AGAINST CA NOTE HTML PRINTING *************/    
    /* VARCHAR d_report_tool    [5],
        d_patient_id        [50],
        d_specimen_no        [30],
        d_section_code        [5],
        d_vdb_user            [100],
        d_password            [200],
        d_connect_string    [2000],
        d_facility_id        [5],
        d_param7            [10],
        d_param8            [20],
        d_param30            [10],
	BVServicedRequestID	[32]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_report_tool;

struct { unsigned short len; unsigned char arr[50]; } d_patient_id;

struct { unsigned short len; unsigned char arr[30]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[5]; } d_section_code;

struct { unsigned short len; unsigned char arr[100]; } d_vdb_user;

struct { unsigned short len; unsigned char arr[200]; } d_password;

struct { unsigned short len; unsigned char arr[2000]; } d_connect_string;

struct { unsigned short len; unsigned char arr[5]; } d_facility_id;

struct { unsigned short len; unsigned char arr[10]; } d_param7;

struct { unsigned short len; unsigned char arr[20]; } d_param8;

struct { unsigned short len; unsigned char arr[10]; } d_param30;

struct { unsigned short len; unsigned char arr[32]; } BVServicedRequestID;
 //Ravi Shankar, 07/10/2016, IN-62208

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





#include<winproc.h>

DWORD sleep_sec = 0;


int err_flag = 0;

int request_count = 0;
char err_num[10];
char string_var[2000];

/************* ADDED ON 04/01/2013 AGAINST CA NOTE HTML PRINTING *************/    
l_command_line[3000];


void proc_main(argc,argv)
char *argv[];
int argc;
{
   
   int rec_found = 0;

   if (argc < 6)
   {
      //ins_message(ERR_MESG,"Usage : rlrrsenq uid/password start_date");
      disp_message(ERR_MESG,"Usage : rlrrsenq uid/password start_date");
      proc_exit();
   }

   strcpy(d_user_id_pwd.arr,argv[1]);

   strcpy(g_pgm_id,"RLRRSENQ");

   strcpy(d_curr_pgm_name.arr,g_pgm_id); 
   d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

/*********** 21.06.2003   
   strcpy(prg_start_date.arr,argv[2]);
   prg_start_date.len = strlen(argv[2]);  
***************/  

   strcpy(nd_facility_id.arr, argv[4]);
   nd_facility_id.len = strlen(nd_facility_id.arr);

   strcpy(nd_priority.arr, argv[5]);
   nd_priority.len = strlen(nd_priority.arr);

   //Ravi Shankar, 07/10/2016, IN-62208
   strcpy(BVServicedRequestID.arr,argv[6]);
   BVServicedRequestID.len = strlen(BVServicedRequestID.arr);
   /////////

   
   if(sql_connect(argv[1]) == -1)
   {
      //ins_message(ORA_MESG,"Error in connecting to Oracle");
      disp_message(ORA_MESG,"Error in connecting to Oracle rlrrsenq");
      proc_exit();
   }
   
   set_meduser_role();
   
   //--22072014 Sandeep K Gujje 24-JUL-2014
   get_site_customer_id();
   
   //--disp_message(ERR_MESG, l_customer_id.arr);

    if (OERROR)
         ins_message(ORA_MESG,"SET ROLE issue");


/********* This part added for globalisation on 29.11.2012 by Srinivasarao V***************************/
    strcpy(language_id.arr,l_language_id.arr);
    language_id.len =l_language_id.len;
    language_id.arr[l_language_id.len]='\0';
/********* This part added for globalisation ***************************/
         
         
   rec_found = get_sleep_secs();

   if(rec_found)
   {

      process_rec();
   }

   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 0;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if (OERROR)
     ins_message(ORA_MESG,"ROLLBACK WORK RELEASE failed");

   return;
}

get_restart_time()
{
    
     l_restart_time = 0;

/****************** 21.06.2003 since this field not available in rl_param

     EXEC SQL SELECT NVL(TO_NUMBER(TO_CHAR(restart_time, 'HH24MI')), 500)
     INTO :l_restart_time
     FROM RL_PARAM;
************************/  
     if (OERROR)
        ins_message(ORA_MESG,"Error Found in RL_PARAM 2");

      if(NOT_FOUND) 
         ins_message(ORA_MESG,"Select failed on RL_PARAM 2 --> No Data Found");


 }
/*------------------------------------------------------*/
get_sleep_secs_old()
{
    d_sleep_secs.arr[0] = '\0'; 
    d_machine_name.arr[0] = '\0';
    d_started_by_id.arr[0] = '\0';
    d_next_start_date.arr[0]='\0';

    d_sleep_secs.len        = 0;
    d_machine_name.len        = 0;
    d_started_by_id.len        = 0;
    d_next_start_date.len    = 0;

    _flushall();

    get_restart_time();

/********* added on 19.06.2003 *************/

    /* EXEC SQL
     SELECT processing_interval
       INTO :d_sleep_secs
       FROM SY_PROG_ID
      WHERE PGM_ID = 'RLRRSENQ'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 1;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select processing_interval into :b0  from SY_PROG_ID wher\
e PGM_ID='RLRRSENQ'";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )20;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_sleep_secs;
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



/*************** upto here **************/


    /* EXEC SQL  SELECT    floor((sysdate-started_date)*24*60),
                        machine_name,
                        started_by_id,
                        to_char(sysdate,'ddmmyyhh24miss'),
                        to_number(to_char(sysdate,'hh24mi'))
                INTO    :d_time_interval,
                        :d_machine_name,
                        :d_started_by_id,
                        :d_next_start_date,
                        :d_starting_time
                FROM    SY_BG_PROCESS_CONTROL
                WHERE    OPERATING_FACILITY_ID = :nd_facility_id
                AND     PGM_ID = 'RLRRSENQ'
                AND        STARTED_DATE IS NOT NULL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select floor((((sysdate-started_date)* 24)* 60)) ,machine\
_name ,started_by_id ,to_char(sysdate,'ddmmyyhh24miss') ,to_number(to_char(sys\
date,'hh24mi')) into :b0,:b1,:b2,:b3,:b4  from SY_BG_PROCESS_CONTROL where ((O\
PERATING_FACILITY_ID=:b5 and PGM_ID='RLRRSENQ') and STARTED_DATE is  not null \
)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )39;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_time_interval;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_machine_name;
    sqlstm.sqhstl[1] = (unsigned int  )42;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_started_by_id;
    sqlstm.sqhstl[2] = (unsigned int  )53;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_next_start_date;
    sqlstm.sqhstl[3] = (unsigned int  )32;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_starting_time;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )7;
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



///////// 21.06.2003 AND        STARTED_DATE = TO_DATE(:prg_start_date,    'DDMMYYHH24MISS');

    d_sleep_secs.arr[d_sleep_secs.len] = '\0';
    d_machine_name.arr[d_machine_name.len] = '\0';
    d_started_by_id.arr[d_started_by_id.len] = '\0';
    d_next_start_date.arr[d_next_start_date.len]='\0';

    
//     if((d_time_interval > RESTART_INTERVAL) && (d_starting_time == RESTART_TIME))

//    if (((d_time_interval > RESTART_INTERVAL) && (d_starting_time == l_restart_time)) || request_count > 25)

    if ((d_time_interval > RESTART_INTERVAL) && (d_starting_time == l_restart_time))
    {
        
        request_count = 1;
        /***********************************
          Commented for batch compilation error

         EXEC SQL
            INSERT INTO SY_BG_PROCESS_CONTROL
            VALUES(    :nd_facility_id,
                    'RLRRSENQ',
                    :d_machine_name,
                    :d_started_by_id,
                    TO_DATE(:d_next_start_date, 'ddmmyyhh24miss'),
                    :nd_priority,
                    null);
          ***************************************/ 
    
          if (OERROR)
          {
                    disp_message(ORA_MESG,"insert failed");
          }
 

        /* EXEC SQL
            DELETE FROM SY_BG_PROCESS_CONTROL 
                WHERE PGM_ID='RLRRSENQ'
                AND STARTED_DATE IS NOT NULL; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 6;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "delete  from SY_BG_PROCESS_CONTROL  where (PGM_ID='RL\
RRSENQ' and STARTED_DATE is  not null )";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )78;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



/*************** 21.06.2003
                AND STARTED_DATE=TO_DATE(:prg_start_date,
                                   'DDMMYYHH24MISS');
*****************/

        /* EXEC SQL COMMIT WORK; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 6;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )93;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




        d_cmd_line.arr[0] = '\0';
        d_cmd_line.len      = 0;

        strcpy(d_cmd_line.arr,"RLRRSENQ");
        strcat(d_cmd_line.arr," ");
        strcat(d_cmd_line.arr,d_user_id_pwd.arr);
        strcat(d_cmd_line.arr," ");
        strcat(d_cmd_line.arr,d_next_start_date.arr);


        d_cmd_line.arr[strlen(d_cmd_line.arr)] = '\0';        

/******* IN WINDOWS 2000 SYSTEM COMMAND WILL NOT GIVE BACK THE CONTROL *****/    
//        system(d_cmd_line.arr);


        WinExec(d_cmd_line.arr, SW_SHOWNORMAL);            
        exit(0);

        
    }

    if(NOT_FOUND) 
    {
          return FALSE;
    }
    else 
    {
        d_sleep_secs.arr[d_sleep_secs.len] = '\0';
        sleep_sec = (DWORD) atol(d_sleep_secs.arr);
        return TRUE;
    }    
}
/*----------------------------------------------------------*/
get_sleep_secs()
{
    d_sleep_secs.arr[0] = '\0'; 
    d_machine_name.arr[0] = '\0';
    d_started_by_id.arr[0] = '\0';
    d_next_start_date.arr[0]='\0';

    d_sleep_secs.len        = 0;
    d_machine_name.len        = 0;
    d_started_by_id.len        = 0;
    d_next_start_date.len    = 0;

    _flushall();


/********* added on 19.06.2003 *************/

    /* EXEC SQL
     SELECT processing_interval
       INTO :d_sleep_secs
       FROM SY_PROG_ID
      WHERE PGM_ID = 'RLRRSENQ'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select processing_interval into :b0  from SY_PROG_ID wher\
e PGM_ID='RLRRSENQ'";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )108;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_sleep_secs;
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



/*************** upto here **************/


    /* EXEC SQL  SELECT    floor((sysdate-started_date)*24*60),
                        machine_name,
                        started_by_id,
                        to_char(sysdate,'ddmmyyhh24miss'),
                        to_number(to_char(sysdate,'hh24mi'))
                INTO    :d_time_interval,
                        :d_machine_name,
                        :d_started_by_id,
                        :d_next_start_date,
                        :d_starting_time
                FROM    SY_BG_PROCESS_CONTROL
                WHERE    OPERATING_FACILITY_ID = :nd_facility_id
                AND     PGM_ID = 'RLRRSENQ'
                AND        STARTED_DATE IS NOT NULL
		AND	SERVICED_REQUESTS = :BVServicedRequestID; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select floor((((sysdate-started_date)* 24)* 60)) ,machine\
_name ,started_by_id ,to_char(sysdate,'ddmmyyhh24miss') ,to_number(to_char(sys\
date,'hh24mi')) into :b0,:b1,:b2,:b3,:b4  from SY_BG_PROCESS_CONTROL where (((\
OPERATING_FACILITY_ID=:b5 and PGM_ID='RLRRSENQ') and STARTED_DATE is  not null\
 ) and SERVICED_REQUESTS=:b6)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )127;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_time_interval;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_machine_name;
    sqlstm.sqhstl[1] = (unsigned int  )42;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_started_by_id;
    sqlstm.sqhstl[2] = (unsigned int  )53;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_next_start_date;
    sqlstm.sqhstl[3] = (unsigned int  )32;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_starting_time;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )7;
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

	//Ravi Shankar, 07/10/2016, IN-62208

    d_sleep_secs.arr[d_sleep_secs.len] = '\0';
    d_machine_name.arr[d_machine_name.len] = '\0';
    d_started_by_id.arr[d_started_by_id.len] = '\0';
    d_next_start_date.arr[d_next_start_date.len]='\0';

    

    if(NOT_FOUND) 
    {
          return FALSE;
    }
    else 
    {
        d_sleep_secs.arr[d_sleep_secs.len] = '\0';
        sleep_sec = (DWORD) atol(d_sleep_secs.arr);
        return TRUE;
    }    

   if (OERROR)
         ins_message(ORA_MESG,"Get Sleep Secs failed");

}

/*----------------------------------------------------------*/
process_rec()
{  
   int i = 0;
   int j = 0,corr_stat = 0;
   int sy_prg_param_found =0;
   int record_exist = 0;
   char test[11],group_test[11];
   /* 12022014 Sandeep K Gujje 12-FEB-2014 */
   FILE *ofp;
   char filename[500];
    /* ----------- */   
   _flushall();

   request_count = 31;

   while (get_sleep_secs())
   { 
  
  
// time being it is commented against SCF MF-SCF-239 on 18/06/09   
//        insert_process_monitor();

       _flushall(); 

  
       /* EXEC SQL SELECT COUNT(1)
       INTO :v_count
       FROM SY_REPORT_GENERATE_REQUEST
       WHERE OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,
                                                                  :nd_facility_id)
       AND pgm_id = 'RLRRSENQ'
       AND request_status IS NULL
       //Ravi Shankar, 07/10/2016, IN-62208
       AND     (:BVServicedRequestID = '*A'
	        OR (:BVServicedRequestID = 'O' 
		AND WS_NO IN (SELECT WS_NO FROM RL_RESULT_PRINT_OP_WSNO WHERE OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,:nd_facility_id)) )
		OR (:BVServicedRequestID = 'N' 
		AND WS_NO NOT IN (SELECT WS_NO FROM RL_RESULT_PRINT_OP_WSNO WHERE OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,:nd_facility_id)) )
		   ); */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 10;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select count(1) into :b0  from SY_REPORT_GENERATE_REQU\
EST where (((OPERATING_FACILITY_ID=DECODE(:b1,'*A',OPERATING_FACILITY_ID,:b1) \
and pgm_id='RLRRSENQ') and request_status is null ) and ((:b3='*A' or (:b3='O'\
 and WS_NO in (select WS_NO  from RL_RESULT_PRINT_OP_WSNO where OPERATING_FACI\
LITY_ID=DECODE(:b1,'*A',OPERATING_FACILITY_ID,:b1)))) or (:b3='N' and WS_NO no\
t  in (select WS_NO  from RL_RESULT_PRINT_OP_WSNO where OPERATING_FACILITY_ID=\
DECODE(:b1,'*A',OPERATING_FACILITY_ID,:b1)))))";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )170;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&v_count;
       sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
       sqlstm.sqhstl[1] = (unsigned int  )7;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
       sqlstm.sqhstl[2] = (unsigned int  )7;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&BVServicedRequestID;
       sqlstm.sqhstl[3] = (unsigned int  )34;
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
       sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
       sqlstm.sqhstl[5] = (unsigned int  )7;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
       sqlstm.sqhstl[6] = (unsigned int  )7;
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
       sqlstm.sqhstv[8] = (         void  *)&nd_facility_id;
       sqlstm.sqhstl[8] = (unsigned int  )7;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&nd_facility_id;
       sqlstm.sqhstl[9] = (unsigned int  )7;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
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


	//////////////
/********** 23.06.2003 added the following to get the session id **************/

       if (v_count > 0)
       {

            check_oracle_report_yn();
            
            //--disp_message(ERR_MESG, d_oracle_report_yn.arr);
            
            //--disp_message(ERR_MESG, l_customer_id.arr);
            
            if (strcmp(d_oracle_report_yn.arr, "Y") == 0)
            {
                
                sm_db_info_dtls();
                declare_html_curs();
                while(fetch_html_curs()) 
                {
                    //-- 29052014 Sandeep K Gujje 29052014 -- Added to avoid generating .bat file everytime 
                    //-- generating only when html result available for the specimen
                    open_note_type();
                    
                    while(fetch_note_type())
                    {
                    //------------
                        
                        //disp_message(ERR_MESG, "fetch_note_type loop"); 
                        
                        strcpy(l_command_line, "");
                        
                        sprintf(l_command_line, "java PrintFile %s %s %s RLRSENQE %s %s %s %s %s %s %s %s %s %s %s",
                                            d_specimen_no.arr, d_facility_id.arr, d_patient_id.arr, 
                                            d_section_code.arr, language_id.arr, d_param7.arr, d_param8.arr, d_param30.arr,
                                            sy_user_id.arr, d_vdb_user.arr, d_password.arr, d_connect_string.arr, 
                                            sy_ws_no.arr, sy_session_id.arr);
                                            
                        /* -- 12022014 Sandeep K Gujje 12-FEB-2014 */
                        /* -- writing l_command_line to bat file and executing the bat file to run java file since when we run directly the cmd is not taking the class path set in print server  */
                        
                        sprintf(filename, "%s%s%s%s%s%s", "C:\\eHIS\\Reports\\", d_facility_id.arr, d_specimen_no.arr, "_", sy_session_id.arr, ".bat");
                                            
                        ofp = fopen(filename,"w");  
                            
                        if (ofp==NULL)
                        {
                            sprintf(string_var,"File Opening-w Error");
                            ins_message(ORA_MESG, string_var);
                            return 0;
                        }    
                        
                        fprintf(ofp,"SET CLASSPATH=O:\\PROC;O:\\PROC\\ojdbc6.jar;"); 
                        fprintf(ofp,"\n");
                        fprintf(ofp, "%s", l_command_line);
                        fprintf(ofp,"\n");
                        
                        fclose(ofp);
                        
                        sprintf(l_command_line, "cmd /c %s", filename);

                        /* ------------ */                                            

                        //disp_message(ERR_MESG, l_command_line);

                        // Frame the string for Java arguments
                        
                        // call the java program
                        WinExec(l_command_line, SW_HIDE);

						//commented belwo stmt and moved to after rl_submit_report for 70076
						
                       /*EXEC SQL UPDATE SY_PROG_PARAM
                                   SET PARAM25 = 'P'
                                 WHERE ROWID = :sy_rowid;*/

                       if(OERROR) 
                          ins_message(ERR_MESG,"Failed in Update Sy_prog_param for param25 with P");       

                        /* EXEC SQL COMMIT; */ 

{
                        struct sqlexd sqlstm;
                        sqlstm.sqlvsn = 10;
                        sqlstm.arrsiz = 10;
                        sqlstm.sqladtp = &sqladt;
                        sqlstm.sqltdsp = &sqltds;
                        sqlstm.iters = (unsigned int  )1;
                        sqlstm.offset = (unsigned int  )225;
                        sqlstm.cud = sqlcud0;
                        sqlstm.sqlest = (unsigned char  *)&sqlca;
                        sqlstm.sqlety = (unsigned short)256;
                        sqlstm.occurs = (unsigned int  )0;
                        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


                    
                    }
                    
                    //-- 29052014 Sandeep K Gujje 29-MAY-2014
                    close_note_type();
                    //-------------
                }
                
                close_html_curs();
                
                // -- 22072014 Sandeep K Gujje 22-JUL-2014 Commented 
                // -- }
                        
                
                d_oracle_report_yn.arr[0] = '\0';
                d_oracle_report_yn.len    = 0;

                /* EXEC SQL EXECUTE
                DECLARE
                        p_error_text VARCHAR2(4000);
                BEGIN
                        RL_SUBMIT_REPORT('P', NULL, NULL, 'O', NULL, NULL, NULL, 
                                        'RLRRSENQ', 'RL',
                                        :nd_facility_id, :sy_ws_no, :language_id, :d_oracle_report_yn,
                                                //Ravi Shankar, 09/08/2018, IN-68351
						//p_error_text);
						p_error_text, :BVServicedRequestID);
						///////////
						

                END;
                END-EXEC; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 10;
                sqlstm.arrsiz = 10;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.stmt = "declare p_error_text VARCHAR2 ( 4000 ) ; BEGI\
N RL_SUBMIT_REPORT ( 'P' , NULL , NULL , 'O' , NULL , NULL , NULL , 'RLRRSENQ'\
 , 'RL' , :nd_facility_id , :sy_ws_no , :language_id , :d_oracle_report_yn , p\
_error_text , :BVServicedRequestID ) ; END ;";
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )240;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)256;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
                sqlstm.sqhstl[0] = (unsigned int  )7;
                sqlstm.sqhsts[0] = (         int  )0;
                sqlstm.sqindv[0] = (         void  *)0;
                sqlstm.sqinds[0] = (         int  )0;
                sqlstm.sqharm[0] = (unsigned int  )0;
                sqlstm.sqadto[0] = (unsigned short )0;
                sqlstm.sqtdso[0] = (unsigned short )0;
                sqlstm.sqhstv[1] = (         void  *)&sy_ws_no;
                sqlstm.sqhstl[1] = (unsigned int  )452;
                sqlstm.sqhsts[1] = (         int  )0;
                sqlstm.sqindv[1] = (         void  *)0;
                sqlstm.sqinds[1] = (         int  )0;
                sqlstm.sqharm[1] = (unsigned int  )0;
                sqlstm.sqadto[1] = (unsigned short )0;
                sqlstm.sqtdso[1] = (unsigned short )0;
                sqlstm.sqhstv[2] = (         void  *)&language_id;
                sqlstm.sqhstl[2] = (unsigned int  )7;
                sqlstm.sqhsts[2] = (         int  )0;
                sqlstm.sqindv[2] = (         void  *)0;
                sqlstm.sqinds[2] = (         int  )0;
                sqlstm.sqharm[2] = (unsigned int  )0;
                sqlstm.sqadto[2] = (unsigned short )0;
                sqlstm.sqtdso[2] = (unsigned short )0;
                sqlstm.sqhstv[3] = (         void  *)&d_oracle_report_yn;
                sqlstm.sqhstl[3] = (unsigned int  )7;
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


				
				//added for 70076
						/* EXEC SQL UPDATE SY_PROG_PARAM
                                   SET PARAM25 = 'P'
                                 WHERE ROWID = :sy_rowid; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 10;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "update SY_PROG_PARAM  set PARAM25='P' where ROWID=:b0";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )275;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&sy_rowid;
      sqlstm.sqhstl[0] = (unsigned int  )303;
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



                d_oracle_report_yn.arr[d_oracle_report_yn.len] = '\0';
                
               // -- 22072014 Sandeep K Gujje 22-JUL-2014 Commented and added },else if
               // -- if (strcmp(d_oracle_report_yn.arr, "Y") != 0)
           }
           else if ((strcmp(d_oracle_report_yn.arr, "Y") != 0) && (strcmp(l_customer_id.arr, "ALMO") != 0))
           {


            sy_session_id.arr[0]        = '\0';
            sy_session_id.len        = 0;

            //EXEC SQL SELECT TO_CHAR(USERENV('SESSIONID'))
            /* EXEC SQL SELECT USERENV('SESSIONID')
                INTO   :sy_session_id
                FROM   DUAL; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 10;
            sqlstm.arrsiz = 10;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "select USERENV('SESSIONID') into :b0  from DUAL ";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )294;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)256;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&sy_session_id;
            sqlstm.sqhstl[0] = (unsigned int  )302;
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



            sy_session_id.arr[sy_session_id.len]        = '\0';

            strcpy(d_cmd_line.arr,"RLRSENQ1");
            strcat(d_cmd_line.arr," ");
            strcat(d_cmd_line.arr,d_user_id_pwd.arr);
            strcat(d_cmd_line.arr," ");
            strcat(d_cmd_line.arr, sy_session_id.arr);
            strcat(d_cmd_line.arr," ");
            strcat(d_cmd_line.arr, sy_session_id.arr);
            strcat(d_cmd_line.arr," ");
            strcat(d_cmd_line.arr, nd_facility_id.arr); 
            strcat(d_cmd_line.arr," ");
            strcat(d_cmd_line.arr, nd_priority.arr); 
	    //Ravi Shankar, 07/10/2016, IN-62208
	    strcat(d_cmd_line.arr," ");
            strcat(d_cmd_line.arr, BVServicedRequestID.arr); 
	    //////////////
            

            ////SS disp_message(ERR_MESG, d_cmd_line.arr);

            /******** commented on 06.04.2005 
                    WinExec(d_cmd_line.arr, SW_SHOWNORMAL); 
            **************/

            _spawnlp(_P_WAIT, "RLRSENQ1", d_cmd_line.arr, NULL);                         
        }    
     }

/*******************************************
// time being it is commented against SCF MF-SCF-239 on 18/06/09   
        else     
        {
           sy_session_id.arr[0]        = '\0';
           sy_session_id.len        = 0;

           EXEC SQL SELECT COUNT(1)
           INTO :v_count
           FROM SY_REPORT_GENERATE_REQUEST
           WHERE OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,
                                        :nd_facility_id)

           AND pgm_id IN ('RLRRSENQ')
           AND NVL(request_status, 'O') = 'E';

           sy_session_id.arr[sy_session_id.len]        = '\0'; 

           if (v_count > 0 )
           {

                strcpy(d_cmd_line.arr,"RLRSENQ1"); 
                strcat(d_cmd_line.arr," ");
                strcat(d_cmd_line.arr,d_user_id_pwd.arr);
                strcat(d_cmd_line.arr," ");
                strcat(d_cmd_line.arr, sy_session_id.arr);
                strcat(d_cmd_line.arr," ");
                strcat(d_cmd_line.arr, sy_session_id.arr);
                strcat(d_cmd_line.arr," ");
                strcat(d_cmd_line.arr, nd_facility_id.arr);
                strcat(d_cmd_line.arr," ");
                strcat(d_cmd_line.arr, nd_priority.arr); 
                strcat(d_cmd_line.arr," ");
                strcat(d_cmd_line.arr, "RLRRSENQ");
                strcat(d_cmd_line.arr," ");
                strcat(d_cmd_line.arr, "F");   

                _spawnlp(_P_WAIT, "RLRSENQ1", d_cmd_line.arr, NULL);

           }


        }
*****time being it is commented against SCF MF-SCF-239 on 18/06/09  ****************/



/************** NOT REQUIRED INCLUDED IN RLRSENQ1.PC *************
        else
        {
           EXEC SQL SELECT COUNT(*)
           INTO :v_count
           FROM SY_REPORT_GENERATE_REQUEST
           WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
           AND pgm_id IN ('RLRRSENQ', 'RLRSENQ1')
           AND request_status = 'E';
        
           if (v_count > 0)
           {
                declare_sy_curs();
                while(fetch_sy_curs())
                {
                    update_sy_curs();
                }    
                close_sy_curs();

                declare_sy_curs_e();
                while(fetch_sy_curs_e())
                {
                    delete_sy_curs();
                    delete_sy_prog_param();
                }    
                close_sy_curs_e();

                EXEC SQL COMMIT WORK;
           }
        }

************** upto here NOT REQUIRED INCLUDED IN RLRSENQ1.PC *************/

         _flushall();
            fflush(NULL);     
          fflush(stdin);
        
          free_variables();

         if (sleep_sec)
             Sleep(sleep_sec);

    //     request_count++;
    
        if (OERROR)
             ins_message(ORA_MESG,"Process_rec failed");
         
    }

}
/*------------------------------------------------------------*/

sql_connect(l_nd_ap_uid_pwd)
char l_nd_ap_uid_pwd[];
{
  strcpy(uid_pwd.arr,l_nd_ap_uid_pwd);
  uid_pwd.len = strlen(uid_pwd.arr);

  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )20;
  sqlstm.offset = (unsigned int  )313;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )1322;
  sqlstm.sqhsts[0] = (         int  )1322;
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



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}
/*-----------------------------------------------------*/
ins_message(int msg_type,char msg[])
{
   er_msg.arr[0] = '\0';
   er_msg.len = 0;
   
   er_msg_type = 0;

   /* EXEC SQL ROLLBACK ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )344;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   strcpy(er_msg.arr,msg);
   er_msg.len = strlen(msg);
 
   er_msg_type = msg_type;

   sprintf(err_num,"%d",sqlca.sqlcode);

   strcpy(er_msg_num.arr, err_num);
   er_msg_num.len = strlen(er_msg_num.arr);


   /* EXEC SQL INSERT INTO SY_PROG_MSG
          (OPERATING_FACILITY_ID,PGM_ID,MSG_TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE)
   VALUES 
          //(DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,:nd_facility_id)
          (:nd_facility_id
            ,'RLRRSENQ',:er_msg_type,SUBSTR(:er_msg_num,1,6), :er_msg, SYSDATE, :sy_session_id,
           :sy_req_date); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_MSG (OPERATING_FACILITY_ID,PGM_ID,MSG_\
TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) values (:b0,'RLRRSENQ\
',:b1,SUBSTR(:b2,1,6),:b3,SYSDATE,:b4,:b5)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )359;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&er_msg_type;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&er_msg_num;
   sqlstm.sqhstl[2] = (unsigned int  )1502;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&er_msg;
   sqlstm.sqhstl[3] = (unsigned int  )173;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&sy_session_id;
   sqlstm.sqhstl[4] = (unsigned int  )302;
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



   err_flag = 1;

   /* EXEC SQL COMMIT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )398;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}





}
/*-----------------------------------------------------*/
/*------------------------------------------------------------*/
insert_process_monitor()
{
    
    p_count = 0;


    /* EXEC SQL SELECT COUNT(1)
             INTO :p_count
             FROM RL_ANALYZER_PROGRAMS_LOG
             WHERE OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,
                                        :nd_facility_id)
             AND analyzer_name = 'RLRRSENQ'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(1) into :b0  from RL_ANALYZER_PROGRAMS_LOG w\
here (OPERATING_FACILITY_ID=DECODE(:b1,'*A',OPERATING_FACILITY_ID,:b1) and ana\
lyzer_name='RLRRSENQ')";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )413;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&p_count;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )7;
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



    if (p_count == 0)
    {
        /* EXEC SQL INSERT INTO RL_ANALYZER_PROGRAMS_LOG
                    (operating_facility_id,analyzer_name, machine_name, last_run_at,
                    ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)
                 VALUES
                    //(DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,:nd_facility_id)
                    (:nd_facility_id
                            ,'RLRRSENQ',:d_machine_name, SYSDATE,
                     sys_context('USERENV','IP_ADDRESS'),:nd_operating_facility_id,
                     sys_context('USERENV','IP_ADDRESS'),:nd_operating_facility_id); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 10;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "insert into RL_ANALYZER_PROGRAMS_LOG (operating_facil\
ity_id,analyzer_name,machine_name,last_run_at,ADDED_AT_WS_NO,ADDED_FACILITY_ID\
,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (:b0,'RLRRSENQ',:b1,SYSDATE,sy\
s_context('USERENV','IP_ADDRESS'),:b2,sys_context('USERENV','IP_ADDRESS'),:b2)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )440;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
        sqlstm.sqhstl[0] = (unsigned int  )7;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_machine_name;
        sqlstm.sqhstl[1] = (unsigned int  )42;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[2] = (unsigned int  )7;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[3] = (unsigned int  )7;
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
    else
    {
        /* EXEC SQL UPDATE RL_ANALYZER_PROGRAMS_LOG
                 SET last_run_at = SYSDATE,
                     machine_name = :d_machine_name
                 WHERE OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,
                                                                        :nd_facility_id)
                 AND analyzer_name = 'RLRRSENQ'; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 10;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "update RL_ANALYZER_PROGRAMS_LOG  set last_run_at=SYSD\
ATE,machine_name=:b0 where (OPERATING_FACILITY_ID=DECODE(:b1,'*A',OPERATING_FA\
CILITY_ID,:b1) and analyzer_name='RLRRSENQ')";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )471;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_machine_name;
        sqlstm.sqhstl[0] = (unsigned int  )42;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
        sqlstm.sqhstl[1] = (unsigned int  )7;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
        sqlstm.sqhstl[2] = (unsigned int  )7;
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

    /* EXEC SQL COMMIT WORK; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )498;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

   

}
/*------------------------------------------------------------*/
free_variables()
{
          free(sy_user_id.arr);
          free(sy_session_id.arr);
          free(sy_req_date.arr);
          free(sy_machine_name.arr);
          free(sy_ws_no.arr);
          free(sy_rowid.arr);

          free(uid_pwd.arr);
          free(d_curr_pgm_name.arr);
          free(nd_file_name.arr);
          free(d_user_id_pwd.arr);
          free(d_next_start_date.arr);
          free(today.arr);
          free(d_cmd_line.arr);
             free(d_machine_name.arr);
          free(d_started_by_id.arr);
          free(prg_start_date.arr);
          free(er_msg.arr);


}
/*-----------------------------------------------------*/
check_oracle_report_yn()
{

    d_report_tool.arr[0]        = '\0';
    d_report_tool.len            = 0;
    
    /* EXEC SQL SELECT NVL(REPORT_TOOL_BM, 'C')
            INTO :d_report_tool
            FROM SM_REPORT
            WHERE MODULE_ID = 'RL'
           AND REPORT_ID = 'RLRRSENQ'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(REPORT_TOOL_BM,'C') into :b0  from SM_REPORT w\
here (MODULE_ID='RL' and REPORT_ID='RLRRSENQ')";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )513;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_report_tool;
    sqlstm.sqhstl[0] = (unsigned int  )7;
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


     
    d_report_tool.arr[d_report_tool.len]    =     '\0';
    
     if (NODATAFOUND);

            d_oracle_report_yn.arr[0] = '\0';
            d_oracle_report_yn.len    = 0;
     
     if (strcmp(d_report_tool.arr, "R") == 0 )
        strcpy(d_oracle_report_yn.arr, "Y");
     else
        strcpy(d_oracle_report_yn.arr, "N");
    
    d_oracle_report_yn.len = strlen(d_oracle_report_yn.arr);
    
}


/*-----------------------------------------------------*/
declare_html_curs()
{

    /* EXEC SQL DECLARE RL_PRINT_HTML_CURS CURSOR FOR
        SELECT SY_REPORT_GENERATE_REQUEST.session_id,
                SY_REPORT_GENERATE_REQUEST.ws_no,
                SY_REPORT_GENERATE_REQUEST.user_id, 
                NVL(SY_PROG_PARAM.param7, '~'), 
                NVL(SY_PROG_PARAM.param8, '~!'),
                NVL(SY_PROG_PARAM.param30, '1'),
                SY_PROG_PARAM.param1 AS patient_id, SY_PROG_PARAM.param2 AS specimen_no, 
                SY_PROG_PARAM.param5 AS section_code,
                SY_REPORT_GENERATE_REQUEST.operating_facility_id,
                SY_PROG_PARAM.ROWID 
        FROM SY_REPORT_GENERATE_REQUEST, SY_PROG_PARAM
        WHERE SY_REPORT_GENERATE_REQUEST.OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',
                            SY_REPORT_GENERATE_REQUEST.OPERATING_FACILITY_ID,
                                :nd_facility_id)
        AND SY_REPORT_GENERATE_REQUEST.pgm_id = 'RLRRSENQ'
        AND SY_REPORT_GENERATE_REQUEST.operating_facility_id = SY_PROG_PARAM.operating_facility_id
        AND SY_REPORT_GENERATE_REQUEST.pgm_id = SY_PROG_PARAM.pgm_id
        AND SY_REPORT_GENERATE_REQUEST.session_id = SY_PROG_PARAM.session_id
        AND TO_CHAR(SY_REPORT_GENERATE_REQUEST.request_date, 'DDMMYYHH24MISS') = SY_PROG_PARAM.pgm_date
        AND SY_REPORT_GENERATE_REQUEST.request_status IS NULL
        AND SY_PROG_PARAM.param25 IS NULL
	//Ravi Shankar, 09/08/2018, IN-68351
       AND     (NVL(:BVServicedRequestID,'*A') = '*A'
	        OR (:BVServicedRequestID = 'O' 
		AND SY_REPORT_GENERATE_REQUEST.WS_NO IN (SELECT WS_NO FROM RL_RESULT_PRINT_OP_WSNO WHERE OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,:nd_facility_id)) )
		OR (:BVServicedRequestID = 'N' 
		AND SY_REPORT_GENERATE_REQUEST.WS_NO NOT IN (SELECT WS_NO FROM RL_RESULT_PRINT_OP_WSNO WHERE OPERATING_FACILITY_ID = DECODE(:nd_facility_id,'*A',OPERATING_FACILITY_ID,:nd_facility_id)) )
		   ); */ 

	//////////////

        
    /* EXEC SQL OPEN RL_PRINT_HTML_CURS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select SY_REPORT_GENERATE_REQUEST.session_id ,SY_REPORT_GENERATE_REQU\
EST.ws_no ,SY_REPORT_GENERATE_REQUEST.user_id ,NVL(SY_PROG_PARAM.param7,'~')\
 ,NVL(SY_PROG_PARAM.param8,'~!') ,NVL(SY_PROG_PARAM.param30,'1') ,SY_PROG_PA\
RAM.param1 patient_id ,SY_PROG_PARAM.param2 specimen_no ,SY_PROG_PARAM.param\
5 section_code ,SY_REPORT_GENERATE_REQUEST.operating_facility_id ,SY_PROG_PA\
RAM.rowid   from SY_REPORT_GENERATE_REQUEST ,SY_PROG_PARAM where ((((((((SY_\
REPORT_GENERATE_REQUEST.OPERATING_FACILITY_ID=DECODE(:b0,'*A',SY_REPORT_GENE\
RATE_REQUEST.OPERATING_FACILITY_ID,:b0) and SY_REPORT_GENERATE_REQUEST.pgm_i\
d='RLRRSENQ') and SY_REPORT_GENERATE_REQUEST.operating_facility_id=SY_PROG_P\
ARAM.operating_facility_id) and SY_REPORT_GENERATE_REQUEST.pgm_id=SY_PROG_PA\
RAM.pgm_id) and SY_REPORT_GENERATE_REQUEST.session_id=SY_PROG_PARAM.session_\
id) and TO_CHAR(SY_REPORT_GENERATE_REQUEST.request_date,'DDMMYYHH24MISS')=SY\
_PROG_PARAM.pgm_date) and SY_REPORT_GENERATE_REQUEST.request_status is null \
) and SY_PROG_PARAM.param25 is null ) and (");
    sqlstm.stmt = sq0022;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )532;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&BVServicedRequestID;
    sqlstm.sqhstl[2] = (unsigned int  )34;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&BVServicedRequestID;
    sqlstm.sqhstl[3] = (unsigned int  )34;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )7;
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
    sqlstm.sqhstv[7] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_facility_id;
    sqlstm.sqhstl[8] = (unsigned int  )7;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
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



    if (RESOURCE_BUSY)
    {
        ins_message(ORA_MESG,"OPEN failed resource busy RL_PRINT_HTML_CURS");
    }

    if (OERROR)
    {
         ins_message(ORA_MESG,"OPEN failed on cursor RL_PRINT_HTML_CURS");
    }        

}

/*-----------------------------------------------------*/
close_html_curs()
{
 
 
    /* EXEC SQL CLOSE RL_PRINT_HTML_CURS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )583;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




    if (RESOURCE_BUSY)
    {
        ins_message(ORA_MESG,"CLOSE failed resource busy RL_PRINT_HTML_CURS");
    }

    if (OERROR)
    {
         ins_message(ORA_MESG,"CLOSE failed on cursor RL_PRINT_HTML_CURS");
    }


}

/*-----------------------------------------------------*/
fetch_html_curs()
{
    d_patient_id.arr[0]              = '\0';
    d_specimen_no.arr[0]          = '\0';
    d_section_code.arr[0]          = '\0';
    d_param7.arr[0]                  = '\0';
    d_param8.arr[0]                  = '\0';
    d_param30.arr[0]              = '\0';
    d_facility_id.arr[0]          = '\0';
    
    
    sy_session_id.arr[0]          = '\0';
    sy_ws_no.arr[0]                  = '\0';
    sy_user_id.arr[0]              = '\0';
  
    sy_rowid.arr[0]                  = '\0';
        
    d_patient_id.len                    = 0;
    d_specimen_no.len                    = 0;
    d_section_code.len                    = 0;
    d_param7.len                        = 0;
    d_param8.len                        = 0;
    d_param30.len                        = 0;
    d_facility_id.len                    = 0;
  
    sy_session_id.len                    = 0;
    sy_ws_no.len                        = 0;
    sy_user_id.len                        = 0;

    sy_rowid.len                        = 0;

    /* EXEC SQL FETCH RL_PRINT_HTML_CURS
              INTO :sy_session_id, :sy_ws_no, :sy_user_id,
                :d_param7, :d_param8, :d_param30,
                :d_patient_id, :d_specimen_no, :d_section_code, :d_facility_id,:sy_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )598;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&sy_session_id;
    sqlstm.sqhstl[0] = (unsigned int  )302;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&sy_ws_no;
    sqlstm.sqhstl[1] = (unsigned int  )452;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&sy_user_id;
    sqlstm.sqhstl[2] = (unsigned int  )603;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_param7;
    sqlstm.sqhstl[3] = (unsigned int  )12;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_param8;
    sqlstm.sqhstl[4] = (unsigned int  )22;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_param30;
    sqlstm.sqhstl[5] = (unsigned int  )12;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[6] = (unsigned int  )52;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_specimen_no;
    sqlstm.sqhstl[7] = (unsigned int  )32;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_section_code;
    sqlstm.sqhstl[8] = (unsigned int  )7;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[9] = (unsigned int  )7;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&sy_rowid;
    sqlstm.sqhstl[10] = (unsigned int  )303;
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





    if (OERROR)
        ins_message(ORA_MESG,"FETCH failed on cursor RL_PRINT_HTML_CURS");

    d_patient_id.arr[d_patient_id.len]                            = '\0';
    d_specimen_no.arr[d_specimen_no.len]                        = '\0';
    d_section_code.arr[d_section_code.len]                        = '\0';
    d_param7.arr[d_param7.len]                                    = '\0';
    d_param8.arr[d_param8.len]                                    = '\0';
    d_param30.arr[d_param30.len]                                = '\0';    
    d_facility_id.arr[d_facility_id.len]                        = '\0';
    
    sy_session_id.arr[sy_session_id.len]                        = '\0';
    sy_ws_no.arr[sy_ws_no.len]                                    = '\0';
    sy_user_id.arr[sy_user_id.len]                                = '\0';
    
    sy_rowid.arr[sy_rowid.len]                                    = '\0';

    return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/
sm_db_info_dtls()
{
    d_vdb_user.arr[0]            = '\0';
    d_password.arr[0]            = '\0';
    d_connect_string.arr[0]        = '\0';
    
    d_vdb_user.len                = 0;
    d_password.len                = 0;
    d_connect_string.len        = 0;
    

    /* EXEC SQL SELECT user_id, app_password.decrypt(password), connect_string 
        INTO :d_vdb_user, :d_password, :d_connect_string
        FROM SM_DB_INFO; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select user_id ,app_password.decrypt(password) ,connect_s\
tring into :b0,:b1,:b2  from SM_DB_INFO ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )657;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_vdb_user;
    sqlstm.sqhstl[0] = (unsigned int  )102;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_password;
    sqlstm.sqhstl[1] = (unsigned int  )202;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_connect_string;
    sqlstm.sqhstl[2] = (unsigned int  )2002;
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


        
    if (NODATAFOUND);

    if (OERROR)
        ins_message(ORA_MESG,"SELECT failed on cursor SM_DB_INFO");

    
    d_vdb_user.arr[d_vdb_user.len]                = '\0';
    d_password.arr[d_password.len]                = '\0';
    d_connect_string.arr[d_connect_string.len]    = '\0';
    
}
//-- 29052014 Sandeep K Gujje 29-MAY-2014 -- Added open_note_type ,fetch_note_type ,close_note_type  , set_printed_date_time functions
/*-----------------------------------------------------*/
open_note_type()
{
    //disp_message(ERR_MESG,"open_note_type");
    
    rl_report_entire_spec_yn.arr[0] = '\0';
    rl_report_entire_spec_yn.len    = 0;
    
    //disp_message(ERR_MESG, d_section_code.arr);
    //disp_message(ERR_MESG, d_facility_id.arr);
    
    /* EXEC SQL SELECT NVL(report_entire_spec_yn,'N')
            INTO :rl_report_entire_spec_yn
            FROM RL_SECTION_CTL
            WHERE section_code = :d_section_code
            AND operating_facility_id = :d_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(report_entire_spec_yn,'N') into :b0  from RL_S\
ECTION_CTL where (section_code=:b1 and operating_facility_id=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )684;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_report_entire_spec_yn;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_section_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )7;
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



    rl_report_entire_spec_yn.arr[rl_report_entire_spec_yn.len]    = '\0';
    
    //disp_message(ERR_MESG, rl_report_entire_spec_yn.arr); 
    set_printed_date_time();

    /* EXEC SQL DECLARE RL_NOTE_TYPE_CUR CURSOR FOR
        SELECT test_code 
        FROM  RL_OLE_RESULT_TEXT
        WHERE patient_id = :d_patient_id
        AND specimen_no = TO_NUMBER(:d_specimen_no)
        AND operating_facility_id = :d_facility_id
        AND group_test_code IN 
                (SELECT test_code 
                FROM RL_REQUEST_DETAIL
                WHERE patient_id = :d_patient_id
                AND specimen_no = TO_NUMBER(:d_specimen_no)
                AND operating_facility_id = :d_facility_id
                AND NVL(cancelled_yn, 'N') <> 'Y'                     
                AND (NVL(result_status, 'O') IN ('R', 'P')
                        OR (:rl_report_entire_spec_yn= 'N' AND 
                               RESULT_PRINTED_DATE = to_date(:nd_result_printed_date,'DD/MM/YYYY HH24:MI:SS') )
                        OR (test_code in (SELECT test_code 
                                        FROM RL_TEST_CODE
                                        WHERE  NVL(profile_yn, 'N') = 'Y'
                                        AND    NVL(group_test_yn, 'N') = 'Y'
                            )  
                AND ( NVL(result_status,'O') = 'O' 
                        OR (NVL(result_status,'O') IN ('A') AND released_date IS NOT NULL))
                    )
                        OR (NVL(preliminary_release_yn,'N') = 'Y' AND NVL(result_status,'O') IN ('A')) 
                    )
                )
        AND test_code in (SELECT test_code 
                          FROM RL_TEST_CODE
                          WHERE  NVL(inhibit_report_yn, 'N') <> 'Y'
                          )  
		AND ROWNUM=1 //added for MO-CRF-20102.5(70262)
        ORDER BY test_code; */ 
        
    
    //disp_message(ERR_MESG, "after declaring cursor"); 


    /* EXEC SQL OPEN RL_NOTE_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0025;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )711;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )52;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_specimen_no;
    sqlstm.sqhstl[1] = (unsigned int  )32;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[3] = (unsigned int  )52;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_specimen_no;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&rl_report_entire_spec_yn;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_result_printed_date;
    sqlstm.sqhstl[7] = (unsigned int  )23;
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


    
    //disp_message(ERR_MESG, "cursor opened"); 

    if (RESOURCE_BUSY)
    {
        ins_message(ORA_MESG,"OPEN failed resource busy RL_NOTE_TYPE_CUR");
    }

    if (OERROR)
    {
         ins_message(ORA_MESG,"OPEN failed on cursor RL_NOTE_TYPE_CUR");
    }


}

close_note_type()
{
 
    //disp_message(ERR_MESG, "close_note_type"); 
    /* EXEC SQL CLOSE RL_NOTE_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )758;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    //disp_message(ERR_MESG, "closed close_note_type"); 

    if (RESOURCE_BUSY)
    {
        ins_message(ORA_MESG,"CLOSE failed resource busy RL_NOTE_TYPE_CUR");
    }

    if (OERROR)
    {
         ins_message(ORA_MESG,"CLOSE failed on cursor RL_NOTE_TYPE_CUR");
    }


}


fetch_note_type()
{
    //disp_message(ERR_MESG, "fetch_note_type"); 
    rl_note_type_test.arr[0]              = '\0';
    rl_note_type_test.len                    = 0;
  

    /* EXEC SQL FETCH RL_NOTE_TYPE_CUR
              INTO :rl_note_type_test; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )773;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&rl_note_type_test;
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


              
    //disp_message(ERR_MESG, "after fetched fetch_note_type"); 



    if (OERROR)
        ins_message(ORA_MESG,"FETCH failed on cursor RL_NOTE_TYPE_CUR");

    rl_note_type_test.arr[rl_note_type_test.len]                            = '\0';
    
    //disp_message(ERR_MESG, "end fetch_note_type"); 
    
    return (LAST_ROW?0:1);
}

set_printed_date_time()
{
 //disp_message(ERR_MESG, "set_printed_date_time"); 
 /* Trapping the result printed date/time into a variable */
 nd_result_printed_date.arr[0] = '\0';
 nd_result_printed_date.len = 0;
 /* EXEC SQL SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS') 
            INTO :nd_result_printed_date
            FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS') into :b0  fr\
om DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )792;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_result_printed_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
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

  
 nd_result_printed_date.arr[nd_result_printed_date.len] = '\0';
 
 //disp_message(ERR_MESG, nd_result_printed_date.arr); 

 return;

}

// -- 22072014 Sandeep K Gujje 24-JUL-2014
get_site_customer_id()
{
    l_customer_id.arr[0]        = '\0';
    l_customer_id.len        = 0;

    /* EXEC SQL SELECT NVL(customer_id, '!!')
        INTO l_customer_id
        FROM SM_SITE_PARAM; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(customer_id,'!!') into :b0  from SM_SITE_PARAM\
 ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )811;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_customer_id;
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



    l_customer_id.arr[l_customer_id.len]    = '\0';

    if (NODATAFOUND);

    if (OERROR);

}
