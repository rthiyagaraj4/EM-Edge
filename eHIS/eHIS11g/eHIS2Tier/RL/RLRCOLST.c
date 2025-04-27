
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RL/RLRCOLST.pc"
};


static unsigned int sqlctx = 1288614443;


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
            void  *sqhstv[10];
   unsigned int   sqhstl[10];
            int   sqhsts[10];
            void  *sqindv[10];
            int   sqinds[10];
   unsigned int   sqharm[10];
   unsigned int   *sqharc[10];
   unsigned short  sqadto[10];
   unsigned short  sqtdso[10];
} sqlstm = {12,10};

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

 static const char *sq0008 = 
"select 'AA' item_code ,'BB' item_short_desc  from OR_ORDER_LINE            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,283,192,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,102,0,258,235,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
59,0,0,3,0,0,286,241,0,0,0,0,0,1,0,
74,0,0,4,0,0,273,321,0,0,1,1,0,1,0,1,9,0,0,
93,0,0,4,0,0,301,331,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
148,0,0,4,0,0,271,351,0,0,0,0,0,1,0,
163,0,0,4,0,0,269,385,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
214,0,0,5,134,0,260,431,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
245,0,0,6,155,0,262,485,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
268,0,0,7,122,0,260,605,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
295,0,0,8,75,0,265,630,0,0,0,0,0,1,0,
310,0,0,8,0,0,269,684,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
333,0,0,9,96,0,260,708,0,0,1,0,0,1,0,2,9,0,0,
352,0,0,10,99,0,262,730,0,0,1,1,0,1,0,1,9,0,0,
371,0,0,11,136,0,262,740,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


#include <stdio.h>   
#include <string.h>
#include <malloc.h>
#include "gl.h"

#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1
#define INIT_MESG "Collection List"


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd					[41],
	        d_accession_num         [30],
		    d_pgm_date				[31],
            rep_date				[31],
            rep_date1				[31], //added for globalisation
            //comp_name				[50],
			comp_name				[300],
            oper_id					[21],
            d_curr_pgm_name			[15],
			nd_session_id           [30],
			nd_pgm_date             [30],

	        nd_date					[30],
			nd_type					[2],
			l_fm_date_time			[30],
			l_to_date_time			[30],
			nd_fm_order_type_code	[10],
			nd_to_order_type_code	[10],
			nd_source_type			[5],
			nd_fm_source			[10],
			nd_to_source			[10],
			nd_urgency_indicator	[5],
			nd_location_type		[5],
			nd_location_code		[15],
			d_item_code             [15],
			d_item_string			[100],
			l_1						[20],
			l_2						[20]; */ 
struct { unsigned short len; unsigned char arr[41]; } uid_pwd;

struct { unsigned short len; unsigned char arr[30]; } d_accession_num;

struct { unsigned short len; unsigned char arr[31]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } rep_date;

struct { unsigned short len; unsigned char arr[31]; } rep_date1;

struct { unsigned short len; unsigned char arr[300]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[30]; } nd_session_id;

struct { unsigned short len; unsigned char arr[30]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[30]; } nd_date;

struct { unsigned short len; unsigned char arr[2]; } nd_type;

struct { unsigned short len; unsigned char arr[30]; } l_fm_date_time;

struct { unsigned short len; unsigned char arr[30]; } l_to_date_time;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_order_type_code;

struct { unsigned short len; unsigned char arr[10]; } nd_to_order_type_code;

struct { unsigned short len; unsigned char arr[5]; } nd_source_type;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_source;

struct { unsigned short len; unsigned char arr[10]; } nd_to_source;

struct { unsigned short len; unsigned char arr[5]; } nd_urgency_indicator;

struct { unsigned short len; unsigned char arr[5]; } nd_location_type;

struct { unsigned short len; unsigned char arr[15]; } nd_location_code;

struct { unsigned short len; unsigned char arr[15]; } d_item_code;

struct { unsigned short len; unsigned char arr[100]; } d_item_string;

struct { unsigned short len; unsigned char arr[20]; } l_1;

struct { unsigned short len; unsigned char arr[20]; } l_2;

			

    /* VARCHAR d_source_code			[7],
			d_patient_id			[20],
			d_bed_num				[15],
			d_episode_id			[15],
			d_patient_name			[61],
			d_order_type_code		[6],
			d_order_id				[20],
			nd_trx_ind              [2],
			d_lab_section_code		[6],
            d_request_num           [21]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_source_code;

struct { unsigned short len; unsigned char arr[20]; } d_patient_id;

struct { unsigned short len; unsigned char arr[15]; } d_bed_num;

struct { unsigned short len; unsigned char arr[15]; } d_episode_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[6]; } d_order_type_code;

struct { unsigned short len; unsigned char arr[20]; } d_order_id;

struct { unsigned short len; unsigned char arr[2]; } nd_trx_ind;

struct { unsigned short len; unsigned char arr[6]; } d_lab_section_code;

struct { unsigned short len; unsigned char arr[21]; } d_request_num;


	/* VARCHAR sql_stmt				[6000]; */ 
struct { unsigned short len; unsigned char arr[6000]; } sql_stmt;


	/***************added for globalisation*************************/
	/* varchar		l_translated_value		 [500],
	language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;


	int i;
	/***************added for globalisation*************************/

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





#include "winproc.h"

/* EXEC ORACLE OPTION(HOLD_CURSOR = YES); */ 


//EXEC ORACLE OPTION(REBIND = NO);

#define REP_WIDTH 80
#define VER  "VER : 1.10.01\n"
#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND (sqlca.sqlcode == 1403)


char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];

char string_var[1000];
char local_legend[35][500];//added for globalisation

//char rep_title1[] = "COLLECTION LIST";
char rep_title1[40] ; //added for globalisation
char rep_title2[30];
char item_title[30];

int end_pgm_control = 0;

FILE *f1;

int page_no,
    line_no;

char filename[150];

char d_string[100];

void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc > 21) 
	{

        disp_message(ERR_MESG,"rlrcolst : Usage RLRCOLST userid/password \n");
        proc_exit();
    }

    strcpy(g_pgm_id,"RLRCOLST");

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

	strcpy(nd_date.arr, argv[2]);
	nd_date.len = strlen(nd_date.arr);

	strcpy(nd_type.arr, argv[3]);
	nd_type.len = strlen(nd_type.arr);

	strcpy(l_fm_date_time.arr, argv[4]);
	l_fm_date_time.len = strlen(l_fm_date_time.arr);

	strcpy(l_to_date_time.arr, argv[5]);
	l_to_date_time.len = strlen(l_to_date_time.arr);

	strcpy(nd_fm_order_type_code.arr, argv[6]);
	nd_fm_order_type_code.len = strlen(nd_fm_order_type_code.arr);
	
	strcpy(nd_to_order_type_code.arr, argv[7]);
	nd_to_order_type_code.len = strlen(nd_to_order_type_code.arr);

	strcpy(nd_source_type.arr, argv[8]);
	nd_source_type.len = strlen(nd_source_type.arr);

	strcpy(nd_fm_source.arr, argv[9]);
	nd_fm_source.len = strlen(nd_fm_source.arr);

	strcpy(nd_to_source.arr, argv[10]);
	nd_to_source.len = strlen(nd_to_source.arr);

	strcpy(l_1.arr, argv[11]);
	l_1.len = strlen(l_1.arr);

	strcpy(l_2.arr, argv[12]);
	l_2.len = strlen(l_2.arr);

	strcpy(nd_urgency_indicator.arr, argv[13]);
	nd_urgency_indicator.len = strlen(nd_urgency_indicator.arr);

	strcpy(nd_location_type.arr, argv[14]);
	nd_location_type.len = strlen(nd_location_type.arr);

	strcpy(nd_location_code.arr, argv[15]);
	nd_location_code.len = strlen(nd_location_code.arr);

	strcpy(nd_session_id.arr, argv[16]);
	nd_session_id.len = strlen(nd_session_id.arr);

	strcpy(nd_pgm_date.arr, argv[17]);
	nd_pgm_date.len = strlen(nd_pgm_date.arr);

	/*** Debug Messages
	sprintf(string_var, "nd_date %s nd_type %s l_fm_date_time %s  l_to_date_time %s  nd_fm_order_type_code  %s", nd_date.arr, nd_type.arr,
	                    l_fm_date_time.arr , l_to_date_time.arr , nd_fm_order_type_code.arr);
   	disp_message(ERR_MESG, string_var);
	
	sprintf(string_var, "nd_to_order_type_code %s nd_source_type %s nd_fm_source %s  nd_to_source %s ", nd_to_order_type_code.arr ,  nd_source_type.arr , nd_fm_source.arr,
	                     nd_to_source.arr);
	disp_message(ERR_MESG, string_var);

    sprintf(string_var, "l_1 %s l_2 %s nd_urgency_indicator %s  nd_location_type %s nd_location_code %s",
	                     l_1.arr , l_2.arr ,nd_urgency_indicator.arr ,nd_location_type.arr ,nd_location_code.arr);
	disp_message(ERR_MESG, string_var);
	
	sprintf(string_var, "nd_session_id %s nd_pgm_date %s",
	                     nd_session_id.arr ,  nd_pgm_date.arr);
    disp_message(ERR_MESG, string_var);

	***/

	/* EXEC SQL CONNECT :uid_pwd; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )10;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )43;
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



    if(OERROR) 
	{
        disp_message(ORA_MESG,"Unable to connect to oracle.\n");
        proc_exit();
    }

    fetch_sys_info();

    strcpy(filename,WORKING_DIR);
    strcat(filename,"rlrcolst.lis");


    if( (f1=fopen(filename,"w")) == NULL)
	{
        disp_message(ERR_MESG,"Error in opening output file...\n");
		proc_exit();
    }

    page_no=1;
    line_no=1;

/*********************** added for globalisation ******************************/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
/*********************** added for globalisation ******************************/

	get_legend_value(33); //added for globalisation

	declare_collection_curs();

    do_report();


    print_end_of_rep();

	get_trans_ind();

    fclose(f1);


	/* EXEC SQL  DELETE sy_prog_param
			  WHERE  pgm_id = 'RLRCOLST'
			  AND	 session_id = TO_NUMBER(:nd_session_id)
			  AND	 pgm_date    = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from sy_prog_param  where ((pgm_id='RLRCOLST' and se\
ssion_id=TO_NUMBER(:b0)) and pgm_date=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_pgm_date;
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




    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )59;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



/**** commented for compilation with srdv
	if (nd_location_type.arr[0]	== '!') 
		print_online(uid_pwd.arr,"RLRCOLST", "O"," ","rlrcolst.lis","S");
	else
		print_online(uid_pwd.arr,"RLRCOLST",nd_location_type.arr,nd_location_code.arr,"rlrcolst.lis","S");
*/    
/******** CHANGED ON 01/12/2002 AGAINST SCF - 279 OF KN **********
	if (strcmp(nd_trx_ind.arr,"Y") == 0)
	{
		print_online(uid_pwd.arr,"RLRCOLST",nd_location_type.arr,nd_location_code.arr,"rlrcolst.lis","S");
	}
	else
	{
       print_online(uid_pwd.arr,"RLRCOLST","O"," ","rlrcolst.lis","S");
	}
******** UPTO HERE CHANGED ON 01/12/2002 AGAINST SCF - 279 OF KN **********/

    return;

}

                  
/********************* DECLARE COLLECTION CURSOR ************************/
declare_collection_curs()
{
   
	strcpy(sql_stmt.arr, " SELECT A.source_code, A.patient_id, A.order_type_code, A.order_id, A.request_num, A.episode_id, A.lab_section_code");
    
	strcat(sql_stmt.arr, ", D.accession_num "); //shh
	
	 if (nd_type.arr[0] == 'W')
		strcat(sql_stmt.arr, ", B.cur_bed_num ");
	 else
		strcat(sql_stmt.arr, ", '!' ");
	
	strcat(sql_stmt.arr, " FROM OR_ORDER A");

	 if (nd_type.arr[0] == 'W')
		strcat(sql_stmt.arr, ", IP_EPISODE B");
     
	 strcat(sql_stmt.arr, ", OR_ORDER_LINE_LB C");

     strcat(sql_stmt.arr, ", OR_ORDER_LINE D");
	 
	 strcat(sql_stmt.arr, "	WHERE  ((A.order_id , A.order_type_code)  IN (SELECT param1  , param2 \
						                     FROM  sy_prog_param \
											 WHERE pgm_id = 'RLRCOLST' \
											 AND   session_id = TO_NUMBER(:nd_session_id) \
											 AND   pgm_date   = :nd_pgm_date)) ");

	 if (nd_type.arr[0] == 'W')
	 {
  
	     strcat(sql_stmt.arr, " AND A.patient_id = B.patient_id \
			    	AND A.episode_id = B.episode_id \
					AND B.discharge_date_time IS NULL ");

	}

	strcat(sql_stmt.arr, " AND A.ORDER_ID = C.ORDER_ID \
					AND A.ORDER_ID = D.ORDER_ID \
					AND C.ORDER_LINE_NUM = 1 \
					AND D.ORDER_LINE_NO = 1 \
					AND A.order_type_code BETWEEN NVL(:nd_fm_order_type_code, '!!') AND \
										NVL(:nd_to_order_type_code, '~~') \
					AND A.source_type = DECODE(:nd_source_type, '!', A.source_type, :nd_source_type) \
					AND A.source_code BETWEEN :nd_fm_source AND :nd_to_source \
					AND A.urgency_indicator = DECODE(:nd_urgency_indicator, 'A', A.urgency_indicator, \
													:nd_urgency_indicator) ");

	 if (nd_type.arr[0] == 'W')
		strcat(sql_stmt.arr, " ORDER BY A.source_code, B.cur_bed_num, A.order_date_time ");    
	 else
		strcat(sql_stmt.arr, " ORDER BY A.patient_id, A.order_date_time, A.source_code ");    

	sql_stmt.len = strlen(sql_stmt.arr);


	/* EXEC SQL PREPARE sr1 FROM :sql_stmt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )74;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sql_stmt;
 sqlstm.sqhstl[0] = (unsigned int  )6002;
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

 
	/* EXEC SQL DECLARE collect_cur CURSOR FOR sr1; */ 
		


	if (OERROR)
	{	

        err_mesg("DECLAR failed on cursor collect_cursor",0,"");
	}

    /* EXEC SQL OPEN collect_cur USING :nd_session_id,:nd_pgm_date,
				:nd_fm_order_type_code, :nd_to_order_type_code, :nd_source_type,
				:nd_source_type,
				:nd_fm_source, :nd_to_source, 
				:nd_urgency_indicator,
				:nd_urgency_indicator; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )93;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[1] = (unsigned int  )32;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fm_order_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )12;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_order_type_code;
    sqlstm.sqhstl[3] = (unsigned int  )12;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_source_type;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_source_type;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_fm_source;
    sqlstm.sqhstl[6] = (unsigned int  )12;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_to_source;
    sqlstm.sqhstl[7] = (unsigned int  )12;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_urgency_indicator;
    sqlstm.sqhstl[8] = (unsigned int  )7;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_urgency_indicator;
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



	if (OERROR)
	{	

		err_mesg("OPEN failed on cursor collect_cursor",0,"");
	}


}

/********************* CLOSE TEST CURSOR ************************/
close_collection_cursor()
{
	
	/* EXEC SQL CLOSE collect_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )148;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
        err_mesg("CLOSE failed on cursor collect_cursor",0,"");


}

/********************* FETCH TEST CURSOR ************************/
fetch_collection_cursor()
{
	
	d_source_code.arr[0]		= '\0';
	d_source_code.len			= 0;
	
	d_accession_num.arr[0]		= '\0';
	d_accession_num.len			= 0;

	d_patient_id.arr[0]			= '\0';
	d_patient_id.len			= 0;
	d_order_type_code.arr[0]	= '\0';
	d_order_type_code.len		= 0;
	d_order_id.arr[0]			= '\0';
	d_order_id.len				= 0;
	d_request_num.arr[0]		= '\0';
	d_request_num.len			= 0;
	d_episode_id.arr[0]			= '\0';
	d_episode_id.len			= 0;
	d_lab_section_code.arr[0]	= '\0';
	d_lab_section_code.len		= 0;
	d_bed_num.arr[0]			= '\0';
	d_bed_num.len				= 0;


	/* EXEC SQL FETCH collect_cur
			 INTO :d_source_code, :d_patient_id, :d_order_type_code,
				:d_order_id,:d_request_num, :d_episode_id, :d_lab_section_code,
				:d_accession_num,:d_bed_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )163;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_source_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_order_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )8;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_order_id;
 sqlstm.sqhstl[3] = (unsigned int  )22;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_request_num;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_episode_id;
 sqlstm.sqhstl[5] = (unsigned int  )17;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_lab_section_code;
 sqlstm.sqhstl[6] = (unsigned int  )8;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_accession_num;
 sqlstm.sqhstl[7] = (unsigned int  )32;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_bed_num;
 sqlstm.sqhstl[8] = (unsigned int  )17;
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



	if(OERROR)
	    err_mesg("FETCH failed on cursor TEST_CURSOR CURSOR",0,"");

	d_source_code.arr[d_source_code.len]			= '\0';
	
	d_accession_num.arr[d_accession_num.len]		= '\0';
	
	d_patient_id.arr[d_patient_id.len]				= '\0';
	d_order_type_code.arr[d_order_type_code.len]	= '\0';
	d_order_id.arr[d_order_id.len]					= '\0';
	d_request_num.arr[d_request_num.len]			= '\0';
	d_episode_id.arr[d_episode_id.len]				= '\0';
	d_lab_section_code.arr[d_lab_section_code.len]	= '\0';
	d_bed_num.arr[d_bed_num.len]					= '\0';


    if(NO_DATA_FOUND)
		return 0;
	return 1;

}


/********************* PRINT END OF REPORT ************************/
print_end_of_rep()
{
    int col;
    char buff[REP_WIDTH+1];

    memset(buff,' ',REP_WIDTH+1);
    col = (int)(REP_WIDTH-19)/2;

    strncpy(buff+col,"** END OF REPORT **",19);
    fprintf(f1,"\n%s\n",buff);
	fprintf(f1,"\f");
}

/********************* FETCH HOSPITAL NAME ************************/
fetch_sys_info()
{

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
		    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
	     INTO   :comp_name,
		    :rep_date,
		    :oper_id
	     FROM   SY_ACC_ENTITY_lang_vw
		 where language_id = :language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where language_id=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )214;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&comp_name;
    sqlstm.sqhstl[0] = (unsigned int  )302;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rep_date;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&oper_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&language_id;
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



    if(OERROR)
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';
}

/********************* CHECK PAGE BREAK ************************/
chk_break(nol)
int nol;
{

	if(line_no + nol >= 63)
	{
       line_no = 1;
	   form_hdr();
	   line_no += 5;
	   put_hdr();
	}
}

/********************* FORM HDR ************************/
form_hdr()
{

    static int first = 1;
    char buf[15];
    int col;

        strcpy(rep_title2,"DATE : ");
        strcat(rep_title2, nd_date.arr);

    if(first) 
	{
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
        memset(hdr_line4,' ',REP_WIDTH+1);
		memset(hdr_line5,'-',REP_WIDTH);
		hdr_line5[REP_WIDTH] = '\0';

        strncpy(hdr_line1,"MDL : OR",8);
        col = (int)(REP_WIDTH-strlen(comp_name.arr))/2;
        strncpy(hdr_line1+col,comp_name.arr,strlen(comp_name.arr));

		/* EXEC SQL EXECUTE
			DECLARE
				t_date   date;
			BEGIN
				t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
				:rep_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');	
			END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE . GET\
_CURRENT_DATE ( :language_id ) ; :rep_date1 := to_char ( t_date , 'DD/MM/YYYY \
HH24:MI' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )245;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&language_id;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&rep_date1;
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



        col = (REP_WIDTH-strlen(rep_date1.arr));
        strcpy(hdr_line1+col-4,rep_date1.arr);
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,oper_id.arr);

    }

    memset(hdr_line3,' ',REP_WIDTH+1);
    strncpy(hdr_line3,"REP : RLRCOLST",14);
	strcpy(rep_title1, local_legend[1]); //added for globalisation
    col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
 //   sprintf(buf,"PAGE : %4d",page_no++);
    sprintf(buf,"%-4.4s : %4d",local_legend[2],page_no++); //added for globalisation
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf))-4,buf);

    col = (int)(REP_WIDTH-strlen(rep_title2))/2;
    strcpy(hdr_line4+col,rep_title2);

    if(first)
        fprintf(f1,"%s\n",hdr_line1);
    else
        fprintf(f1,"\f%s\n",hdr_line1);

    fprintf(f1,"%s\n",hdr_line2);
    fprintf(f1,"%s\n",hdr_line3);
    fprintf(f1,"%s\n",hdr_line4);
    fprintf(f1,"%s\n",hdr_line5);

    first = 0;
}

/********************* REPORT HEADER ************************/
put_hdr()
{
   
//   fprintf(f1,"Source Bed No     Episode Id Patient ID    Name                 Order No                 ");
   fprintf(f1,"%-6.6s %-6.6s     %-10.10s %-10.10s    %-4.4s                 %-8.8s                 ",
			local_legend[3], local_legend[4], local_legend[5], local_legend[6], local_legend[7], local_legend[8]);
   fprintf(f1, "\n");
//   fprintf(f1,"Specimen No");
   fprintf(f1,"%s", local_legend[9]); //added for globalisation
   fprintf(f1, "\n");
//   fprintf(f1,"Tests");
   fprintf(f1,"%s", local_legend[10]); //added for globalisation
   fprintf(f1, "\n");
   fprintf(f1, "--------------------------------------------------------------------------------");
   fprintf(f1, "\n");

   line_no = line_no + 4;

}

do_report()
{

   form_hdr();
   line_no += 5;
   put_hdr();

   while(fetch_collection_cursor())
   {
	  
	  print_records();

   }		

   close_collection_cursor();

}

print_records()
{

	get_patient_name();

	chk_break(1);

    if (strcmp(d_bed_num.arr, "!") == 0)
		strcpy(d_bed_num.arr ,"");

	fprintf(f1, "%-4.4s   %-8.8s   %-8.8s   %-13.13s %-20.20s %-3.3s %-10.10s",
					d_source_code.arr, d_bed_num.arr,d_episode_id.arr,
					d_patient_id.arr, d_patient_name.arr, 
//					d_order_type_code.arr, d_order_id.arr, d_request_num.arr);
					d_order_type_code.arr, d_order_id.arr);
	fprintf(f1, "\n");
	fprintf(f1, "%-15.15s \n",d_accession_num.arr);

	get_item_string();

	fprintf(f1, "\n");
/**
    if (strcmp(d_bed_num.arr, "!") != 0)
		fprintf(f1, "%-8.8s\n", d_bed_num.arr);
	 else
		fprintf(f1, "\n");
**/
	line_no++;
	line_no++;
	line_no++;

}

get_patient_name()
{

	d_patient_name.arr[0]		= '\0';
	d_patient_name.len			= 0;

	/* EXEC SQL SELECT DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG) short_name
			 INTO :d_patient_name
			 FROM MP_PATIENT_MAST
			 WHERE patient_id = :d_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_LOC_LANG) \
short_name into :b1  from MP_PATIENT_MAST where patient_id=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )268;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&language_id;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_patient_name;
 sqlstm.sqhstl[1] = (unsigned int  )63;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )22;
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



	if (NO_DATA_FOUND);

	d_patient_name.arr[d_patient_name.len]		= '\0';

}

get_item_string()
{

	int i = 0;
	int flg = 0;

	/* EXEC SQL DECLARE item_curs CURSOR FOR
			 /oSELECT item_code, item_short_desc
			 FROM OR_ORDER_LINE
			 WHERE order_type_code = :d_order_type_code
			 AND order_id = :d_order_id;
			o/
			SELECT 'AA' item_code, 'BB' item_short_desc
			 FROM OR_ORDER_LINE; */ 

	/* EXEC SQL OPEN item_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0008;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )295;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	strcpy(d_string, "");

	while(fetch_item_curs())
	{

		if (i == 0)
		{
			flg  = 1;
			strcpy(d_string, d_item_string.arr);
		}
		else
		{
			if ((80 - strlen(d_string)) > strlen(d_item_string.arr))
			{
			flg  = 1;
			strcat(d_string, ",");
			strcat(d_string, d_item_string.arr);
			}
			else
			{
			flg  = 0;
			fprintf(f1, "%-60.60s \n", d_string);
			strcpy(d_string, "");
			line_no++;
			}
		}

/**
		if (i > 4)
			break;
**/
		i++;
	}

	if (flg == 1)
	{
		fprintf(f1, "%-60.60s \n", d_string);
		strcpy(d_string, "");
		line_no++;
	}

}

/********************* FETCH ITEM CURSOR ************************/
fetch_item_curs()
{
	
	d_item_code.arr[0]     = '\0';
	d_item_code.len        = 0;
	d_item_string.arr[0]   = '\0';
	d_item_string.len	   = 0;

	/* EXEC SQL FETCH item_curs
			 INTO :d_item_code, :d_item_string; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )310;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_item_code;
 sqlstm.sqhstl[0] = (unsigned int  )17;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_item_string;
 sqlstm.sqhstl[1] = (unsigned int  )102;
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



	if(OERROR)
	    err_mesg("FETCH failed on cursor ITEM_CURSOR CURSOR",0,"");

	d_item_code.arr[d_item_code.len]      = '\0';
	d_item_string.arr[d_item_string.len]  = '\0';


    if(NO_DATA_FOUND)
		return 0;

	return 1;

}

/**************************select transaction based or not ***************/
get_trans_ind()
{
	
	nd_trx_ind.arr[0]		= '\0';
	nd_trx_ind.len		= 0;

	/* EXEC SQL  SELECT TRANSACTION_BASED_YN 
	          INTO   :nd_trx_ind
	          FROM   sy_online_print_id
              WHERE  ONLINE_PRINT_NAME = 'RLRCOLST'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TRANSACTION_BASED_YN into :b0  from sy_online_print_i\
d where ONLINE_PRINT_NAME='RLRCOLST'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )333;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_trx_ind;
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



	if(OERROR)
	    err_mesg("SELECT failed on  SY_ON_LINE_PRINT_ID",0,"");

	nd_trx_ind.arr[nd_trx_ind.len]			= '\0';


    if(NO_DATA_FOUND)
		return 0;

		
	return 1;

}


get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND ('DF',:language_id,'RLRCOLST.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( 'DF' , :lan\
guage_id , 'RLRCOLST.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )352;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&language_id;
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



	for (i=1; i<=cou; i++)
	{
	l_translated_value.arr[0]		= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRCOLST.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRCOLST.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )371;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )502;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&i;
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


	
	l_translated_value.arr[l_translated_value.len] = '\0';

	//sp_message(ERR_MESG,l_translated_value.arr);

	strcpy(local_legend[i],l_translated_value.arr);
	}
 }
