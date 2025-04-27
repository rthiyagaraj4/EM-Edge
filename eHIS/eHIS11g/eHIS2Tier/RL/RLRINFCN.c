
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
           char  filnam[59];
};
static const struct sqlcxp sqlfpn =
{
    58,
    "D:\\WORK\\ML-MMOH-CRF-0752.6-US001\\Proc\\RLRINFCN\\RLRINFCN.pc"
};


static unsigned long sqlctx = 1143465221;


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
            void  *sqhstv[7];
   unsigned int   sqhstl[7];
            int   sqhsts[7];
            void  *sqindv[7];
            int   sqinds[7];
   unsigned int   sqharm[7];
   unsigned int   *sqharc[7];
   unsigned short  sqadto[7];
   unsigned short  sqtdso[7];
} sqlstm = {10,7};

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

 static const char *sq0003 = 
"select sequence_no ,organism_code ,antibiotic_code ,sensitivity_ind  from RL\
_INFECTION_LIST_HDR where (added_date=TO_DATE(:b0,'DD/MM/YYYYHH24:MI:SS') and \
OPERATING_FACILITY_ID=:b1) order by organism_code,antibiotic_code,sensitivity_\
ind            ";

 static const char *sq0004 = 
"select PATIENT_ID ,SPECIMEN_NO ,TO_CHAR(ORGANISM_REPORT_DATE,'dd/mm/yyyy hh2\
4:mi')  from RL_INFECTION_LIST_DTL where (sequence_no=:b0 and OPERATING_FACILI\
TY_ID=:b1) order by 1            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,539,133,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,542,199,0,0,0,0,0,1,0,
51,0,0,3,247,0,521,221,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
74,0,0,4,0,0,525,273,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
101,0,0,3,0,0,525,308,0,0,4,0,0,1,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
132,0,0,4,187,0,521,361,0,0,2,2,0,1,0,1,3,0,0,1,9,0,0,
155,0,0,5,222,0,516,391,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,1,9,0,0,
198,0,0,6,122,0,516,428,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
225,0,0,7,122,0,516,449,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
252,0,0,8,234,0,518,491,0,0,2,2,0,1,0,3,9,0,0,1,9,0,0,
275,0,0,9,155,0,518,572,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
298,0,0,10,158,0,516,620,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
333,0,0,3,0,0,527,641,0,0,0,0,0,1,0,
348,0,0,4,187,0,521,646,0,0,2,2,0,1,0,1,3,0,0,1,9,0,0,
371,0,0,11,106,0,516,654,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
398,0,0,12,102,0,516,669,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
425,0,0,13,136,0,516,686,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
460,0,0,14,124,0,516,703,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
495,0,0,15,97,0,516,713,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
522,0,0,16,120,0,518,728,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
545,0,0,17,136,0,518,738,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


#include <stdio.h>   
#include <string.h>
#include "rl.h"
#include "gl.h"
   
#define NODATAFOUND (sqlca.sqlcode == 1403)
#define OERROR (sqlca.sqlcode < 0) 
#define ESC 0x1B
#define MAX_LINES 55
#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1 
/* EXEC SQL BEGIN DECLARE SECTION; */ 
    

    /* VARCHAR		nd_operating_facility_id   [3],
	            uid_pwd			           [91],
				nd_session_id			   [50],
				//comp_name		           [161],
				comp_name		           [300],
				oper_id			           [21],
				rep_date		           [20],
				rep_date1		           [20], //added for globalisation

	/o variables for command line paramters o/							 
				d_source_type		[2],
				d_source_code		[12],
				d_source_desc		[100], /oModified By Manoj S for ML-MMOH-CRF-0752.6o/	
				d_organism_code		[5],
				d_organism_desc		[41],
				d_antibiotic_code	[5],
				d_antibiotic_desc	[41],
				d_sensitivity_ind	[2],

	/o variables for cursor informations o/
				d_patient_id			[21],		
				d_specimen_no			[21],
				d_group_test_code		[11],
				d_test_code				[11],

	/o for additional informations rl_request_header and mp_patient_mast/rl_patient_mast o/
				d_episode_type			[2],
				d_episode_no			[9],
				d_tfr_visit_no			[5],
				d_organism_report_date  [20],
				d_organism_report_date1  [20], //added for globalisation
				d_date					[25],
				rl_ordered_facility_id	[3],

				d_patient_name			[240],
				d_patient_name_1		[240],
				d_patient_name_2		[240],
				d_patient_name_3		[240],
				d_patient_name_4		[240],
		/o**************** added for globalisation **********o/

		l_translated_value		[600],
		language_id				[5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[50]; } nd_session_id;

struct { unsigned short len; unsigned char arr[300]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date1;

struct { unsigned short len; unsigned char arr[2]; } d_source_type;

struct { unsigned short len; unsigned char arr[12]; } d_source_code;

struct { unsigned short len; unsigned char arr[100]; } d_source_desc;

struct { unsigned short len; unsigned char arr[5]; } d_organism_code;

struct { unsigned short len; unsigned char arr[41]; } d_organism_desc;

struct { unsigned short len; unsigned char arr[5]; } d_antibiotic_code;

struct { unsigned short len; unsigned char arr[41]; } d_antibiotic_desc;

struct { unsigned short len; unsigned char arr[2]; } d_sensitivity_ind;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[11]; } d_group_test_code;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[9]; } d_episode_no;

struct { unsigned short len; unsigned char arr[5]; } d_tfr_visit_no;

struct { unsigned short len; unsigned char arr[20]; } d_organism_report_date;

struct { unsigned short len; unsigned char arr[20]; } d_organism_report_date1;

struct { unsigned short len; unsigned char arr[25]; } d_date;

struct { unsigned short len; unsigned char arr[3]; } rl_ordered_facility_id;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_1;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_2;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_3;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_4;

struct { unsigned short len; unsigned char arr[600]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;

		/***************** added for globalisation ***********/
				
long	organism_count = 0;
long    d_sequence_no	= 0;
int   l_count = 0;

int i; // added for globalisation

/* EXEC SQL END DECLARE SECTION; */ 


int		l_len = 30;
char	l_delimeter;

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





#include <winproc.h>

#define REP_WIDTH 80
#define VER  "VER : 1.10.01\n"
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1],
	 hdr_line6[REP_WIDTH+1],
	 hdr_line7[REP_WIDTH+1];

//char rep_title1[] = "Infection Control Report";
char rep_title1[200]; //added for globalisation
char rep_title2[200];

char d_sensitivity_desc	[15];

FILE *f1;

char string_var[100] ;
char local_legend[50][600]; // added for globalisation

int i, 
	page_no = 0,
    line_no = 0;

char l_string[300];

char filename[150];

void proc_main(argc,argv)
int argc;
char *argv[];
{
    if(argc < 5) {
        disp_message(ERR_MESG,"RLRINFCN : Usage RLRINFCN userid/password source_type source_code date \n");
        proc_exit();
    } 
  
    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
	

    strcpy(nd_operating_facility_id.arr, argv[5]);
	nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);
	
	strcpy(d_source_type.arr,argv[6]);
    d_source_type.len = strlen(d_source_type.arr);

	strcpy(d_source_code.arr,argv[7]);
    d_source_code.len = strlen(d_source_code.arr);


	strcpy(d_date.arr,argv[8]);
    d_date.len = strlen(d_date.arr);

	/* EXEC SQL CONNECT :uid_pwd; */ 

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
 sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
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
}



    if(OERROR)
	 {
        disp_message(ORA_MESG,"Unable to connect to oracle.\n");
		disp_message(ORA_MESG,sqlca.sqlerrm.sqlerrmc);
        proc_exit();
     } 
    
	set_meduser_role();
/******* from here added for globalisation ********/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
    get_legend_value(32);
/******* upto here added for globalisation ********/

    fetch_sys_info();
	
    strcpy(filename,WORKING_DIR);
    strcat(filename,"rlrinfcn.lis");

    if( (f1=fopen(filename,"w")) == NULL) 
	{
        disp_message(ERR_MESG,"Errors in opening output file...\n"); 
		proc_exit();
    }  
	else
	{
	     fprintf(f1,"%c&k4S",ESC);
	}

	decl_cur();
	do_report();

    //fprintf(f1,"%c&|3O",ESC);
	fprintf(f1,"%cE",ESC);
    fclose(f1);

/******** commented on 29.06.2003 and replaced with new standard

   	print_online(uid_pwd.arr,"RLRINFCN","O", "","rlrinfcn.lis","S");

**************************/

    

///////////////////////////////////////  

					 PrintDocument
						   (
							uid_pwd.arr,		//char	*PUidPwd;
							nd_session_id.arr,	//char	*PSessionID;
							nd_operating_facility_id.arr,	//char	*PFacilityID;
							"RL",				//char	*PModuleID;
							"RLRINFCN",			//char	*PDocumentID;
							filename,			//char	*POnlinePrintFileNames;
							"O",				//char	*PLocationTypes;
							"",				//char	*PLocationCodes;
							1,					//int		PNumOfCopies;
							1,					//int		PPageFrom;
							9999					//int		PPageTo;
						   );
						   
///////////////////////////////////////

	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	
    return;
}


declare_control_cursor()
{
    /* EXEC SQL DECLARE CONTROL_CURSOR CURSOR FOR
		SELECT sequence_no, organism_code, antibiotic_code, sensitivity_ind
		  FROM RL_INFECTION_LIST_HDR
		 WHERE added_date = TO_DATE(:d_date, 'DD/MM/YYYYHH24:MI:SS')
		 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		 ORDER BY organism_code, antibiotic_code, sensitivity_ind; */ 


/*
			SOURCE_CODE =	 :d_source_code
		   AND SOURCE_TYPE =	 :d_source_type;
//		   AND NVL(total_report_count, 0) > NVL(organism_count, 0);

*/

	/* EXEC SQL OPEN control_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0003;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_date;
 sqlstm.sqhstl[0] = (unsigned int  )27;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
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
		{
			disp_message(ERR_MESG,"Error declaring cursor");
			disp_message(ERR_MESG,sqlca.sqlerrm.sqlerrmc);
			proc_exit();
		}
}

decl_cur()
{
    /* EXEC SQL DECLARE STAT_CURSOR CURSOR FOR
			SELECT PATIENT_ID,SPECIMEN_NO,TO_CHAR(ORGANISM_REPORT_DATE, 'dd/mm/yyyy hh24:mi')
		  FROM RL_INFECTION_LIST_DTL
		 WHERE sequence_no = :d_sequence_no
		 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		 ORDER BY 1; */ 

		 
/**		 
		 SOURCE_CODE =	 :d_source_code
		   AND SOURCE_TYPE =	 :d_source_type
		   AND ORGANISM_CODE =	 :d_organism_code
           AND ANTIBIOTIC_CODE = :d_antibiotic_code
		   AND SENSITIVITY_IND = :d_sensitivity_ind
	  ORDER BY 1;
***/

		if (OERROR)	    
		{
			disp_message(ERR_MESG,"Error declaring cursor");
			disp_message(ERR_MESG,sqlca.sqlerrm.sqlerrmc);
			proc_exit();
		}
}


fetch_stat_cursor()
{
  d_patient_id.arr[0]		      = '\0';
  d_specimen_no.arr[0]			  = '\0';
  d_organism_report_date.arr[0]   = '\0'; 
  d_group_test_code.arr[0]		  = '\0';
  d_test_code.arr[0]			  = '\0';

  d_patient_id.len				= 0;
  d_specimen_no.len				= 0;
  d_organism_report_date.len    = 0; 
  d_group_test_code.len		    = 0;
  d_test_code.len				= 0;


  /* EXEC SQL FETCH STAT_CURSOR INTO  :d_patient_id,
								   :d_specimen_no,
								   :d_organism_report_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )74;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_specimen_no;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_organism_report_date;
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


							
  if (OERROR)	    
	{
		disp_message(ERR_MESG,"Error fetching cursor");
		disp_message(ERR_MESG,sqlca.sqlerrm.sqlerrmc);
		proc_exit();
	}

    			
  if (NODATAFOUND)
       return 0;

  d_patient_id.arr[d_patient_id.len]						= '\0';
  d_specimen_no.arr[d_specimen_no.len]						= '\0';
  d_organism_report_date.arr[d_organism_report_date.len]	= '\0'; 
  d_group_test_code.arr[d_group_test_code.len]				= '\0';
  d_test_code.arr[d_test_code.len]							= '\0';

 
  return 1;
}

fetch_control_cursor()
{

   d_organism_code.arr[0]	= '\0';
   d_organism_code.len		= 0;
   d_antibiotic_code.arr[0] = '\0';
   d_antibiotic_code.len	= 0;
   d_sensitivity_ind.arr[0]	= '\0';
   d_sensitivity_ind.len	= 0;

  /* EXEC SQL FETCH control_cursor INTO :d_sequence_no,   
									:d_organism_code,
									:d_antibiotic_code,
									:d_sensitivity_ind; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )101;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_sequence_no;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_organism_code;
  sqlstm.sqhstl[1] = (unsigned int  )7;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_antibiotic_code;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_sensitivity_ind;
  sqlstm.sqhstl[3] = (unsigned int  )4;
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


							
  if (OERROR)	    
	{
		disp_message(ERR_MESG,"Error fetching cursor control");
		disp_message(ERR_MESG,sqlca.sqlerrm.sqlerrmc);
		proc_exit();
	}

    			
  if (NODATAFOUND)
       return 0;


		d_organism_code.arr[d_organism_code.len]	= '\0';
		d_antibiotic_code.arr[d_antibiotic_code.len] = '\0';
		d_sensitivity_ind.arr[d_sensitivity_ind.len]	= '\0';
   	

 
  return 1;
}


do_report()
{
	int still_record_left;

    
    

	declare_control_cursor();

	while(fetch_control_cursor())
	{

/**************************
		if (d_sensitivity_ind.arr[0] == 'S')
			strcpy(d_sensitivity_desc, "Sensitive");
		else if (d_sensitivity_ind.arr[0] == 'R')
			strcpy(d_sensitivity_desc, "Resistant");
		else if (d_sensitivity_ind.arr[0] == 'I')
			strcpy(d_sensitivity_desc, "Intermediate");
		else if (d_sensitivity_ind.arr[0] == 'N')
			strcpy(d_sensitivity_desc, "Negative");
		else if (d_sensitivity_ind.arr[0] == 'P')
			strcpy(d_sensitivity_desc, "Positive");
**************************/
		chk_break(60);		

		/* EXEC SQL OPEN STAT_CURSOR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0004;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )132;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_sequence_no;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
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



   		while(fetch_stat_cursor())
		{	
			get_pat_dtls();
			chk_break(2);
			print_rec();
		}

		close_stat_cursor();
	
	}

	close_control_cursor();
}


get_pat_dtls()
{
	d_episode_type.arr[0]	= '\0';
	d_episode_type.len		= 0;
	d_episode_no.arr[0]	    = '\0';
	d_episode_no.len		= 0;
	d_tfr_visit_no.arr[0]   = '\0'; 
	d_tfr_visit_no.len		= 0;
	d_organism_report_date.arr[0] = '\0';
	d_organism_report_date.len = 0;
	rl_ordered_facility_id.arr[0]	= '\0';
	rl_ordered_facility_id.len	= 0;

	/* EXEC SQL 
			SELECT EPISODE_TYPE,EPISODE_NO,TFR_VISIT_NO,TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI'),
					OPERATING_FACILITY_ID
			  INTO	:d_episode_type,
					:d_episode_no,
					:d_tfr_visit_no,
					:d_organism_report_date,
					:rl_ordered_facility_id
			  FROM RL_REQUEST_HEADER
			 WHERE SPECIMEN_NO = :d_specimen_no
			 AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select EPISODE_TYPE ,EPISODE_NO ,TFR_VISIT_NO ,TO_CHAR(SPEC_\
REGD_DATE_TIME,'DD/MM/YYYY HH24:MI') ,OPERATING_FACILITY_ID into :b0,:b1,:b2,:\
b3,:b4  from RL_REQUEST_HEADER where (SPECIMEN_NO=:b5 and OPERATING_FACILITY_I\
D=:b6)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )155;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_episode_no;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_tfr_visit_no;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_organism_report_date;
 sqlstm.sqhstl[3] = (unsigned int  )22;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&rl_ordered_facility_id;
 sqlstm.sqhstl[4] = (unsigned int  )5;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_specimen_no;
 sqlstm.sqhstl[5] = (unsigned int  )23;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[6] = (unsigned int  )5;
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



    if(OERROR)
	 {
        disp_message(ORA_MESG,"get_pat_dtls (1st select) failed ");
		disp_message(ORA_MESG,sqlca.sqlerrm.sqlerrmc);
        proc_exit();
     } 

	d_episode_type.arr[d_episode_type.len]	 = '\0';
	d_episode_no.arr[d_episode_no.len]	     = '\0';
	d_tfr_visit_no.arr[d_tfr_visit_no.len]   = '\0'; 
	d_organism_report_date.arr[d_organism_report_date.len] = '\0';
	rl_ordered_facility_id.arr[rl_ordered_facility_id.len] = '\0';

	if ( strcmp(d_episode_type.arr, "R") == 0) 
		do_ref_patient();
	else
		do_mp_patient();

}

do_mp_patient()
{
	d_patient_name.arr[0] = '\0';
	d_patient_name.len = 0;

	/* EXEC SQL
	SELECT DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG) SHORT_NAME
	  INTO :d_patient_name
	  FROM MP_PATIENT_MAST
	 WHERE PATIENT_ID = :d_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_LOC_LANG) \
SHORT_NAME into :b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )198;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqhstl[1] = (unsigned int  )242;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
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

   

	if (OERROR)
        disp_message(ERR_MESG, "SELECT failed on DO_MP_PATIENT table MP_PATIENT_MAST ");

    if (NODATAFOUND)
       disp_message(ERR_MESG, "No Record found in MP_PATIENT_MAST"); 

	d_patient_name.arr[d_patient_name.len] = '\0';
}


do_ref_patient()
{
	d_patient_name.arr[0] = '\0';
	d_patient_name.len = 0;

	/* EXEC SQL
	SELECT DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG) SHORT_NAME
	  INTO :d_patient_name
	  FROM RL_PATIENT_MAST
	 WHERE PATIENT_ID = :d_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_LOC_LANG) \
SHORT_NAME into :b1  from RL_PATIENT_MAST where PATIENT_ID=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )225;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqhstl[1] = (unsigned int  )242;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
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


	 /* AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */

	if (OERROR)
        disp_message(ERR_MESG, "SELECT failed on DO_REF_PATIENT table RL_PATIENT_MAST ");

    if (NODATAFOUND)
	    disp_message(ERR_MESG, "No Record found in RL_PATIENT_MAST"); 

	d_patient_name.arr[d_patient_name.len] = '\0';
}


print_rec()
{
/************* not required **************
		get_antibiotic_desc();

		if (d_sensitivity_ind.arr[0] == 'S')
			strcpy(d_sensitivity_desc, "Sensitive");
		else if (d_sensitivity_ind.arr[0] == 'R')
			strcpy(d_sensitivity_desc, "Resistant");
		else if (d_sensitivity_ind.arr[0] == 'I')
			strcpy(d_sensitivity_desc, "Intermediate");
		else if (d_sensitivity_ind.arr[0] == 'N')
			strcpy(d_sensitivity_desc, "Negative");
		else if (d_sensitivity_ind.arr[0] == 'P')
			strcpy(d_sensitivity_desc, "Positive");
************ upto here ****************************/

		l_delimeter = ' ';
		rl_split_text(d_patient_name.arr, l_delimeter, l_len, d_patient_name_1.arr,
			          d_patient_name_2.arr, d_patient_name_3.arr, d_patient_name_4.arr);

		fprintf(f1,"%-21.21s%-31.31s%10.10s/%-9.9s\n",
				d_patient_id.arr,d_patient_name_1.arr,d_tfr_visit_no.arr,d_episode_no.arr);
        fprintf(f1,"%-21.21s%-31.31s\n"," ",d_patient_name_2.arr);
		
		/* EXEC SQL EXECUTE
			DECLARE
				t_date   date;
			BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_organism_report_date,'DD/MM/YYYY HH24:MI'), :language_id , t_date);
				:d_organism_report_date := to_char(t_date,'DD/MM/YYYY HH24:MI');
			END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_LO\
CALE_DATE ( to_date ( :d_organism_report_date , 'DD/MM/YYYY HH24:MI' ) , :lang\
uage_id , t_date ) ; :d_organism_report_date := to_char ( t_date , 'DD/MM/YYYY\
 HH24:MI' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )252;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_organism_report_date;
  sqlstm.sqhstl[0] = (unsigned int  )22;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&language_id;
  sqlstm.sqhstl[1] = (unsigned int  )7;
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



		fprintf(f1,"%-16.16s%s\n", d_specimen_no.arr, d_organism_report_date1.arr);

		line_no += 3;

		organism_count ++;
}



chk_break(int nol)
{
	if ((line_no + nol) >= MAX_LINES) 
	{
       line_no = 1;
	   page_no ++;
	   form_hdr();
	   rep_hdr();
	   col_heading();
 	}
}

col_heading()
{
    //fprintf(f1, "Patient ID           Name                           Visit Id/Episode No\n");
    fprintf(f1, "%-10.10s           %-10.10s                     %-18.18s\n",local_legend[1], local_legend[2], local_legend[3]);//added for globalisation
	//fprintf(f1, "Specimen No     Date\n");
	fprintf(f1, "%-11.11s     %-4.4s\n", local_legend[4], local_legend[5]); //added for globalisation
	fprintf(f1, "--------------------------------------------------------------------------------\n");
	line_no += 3;
}

rep_hdr()
{
	
  get_source_desc();
//  get_antibiotic_desc();
  get_organism_desc();

  //fprintf(f1, "Source      : %-4.4s %s\n", d_source_code.arr, d_source_desc.arr);
  fprintf(f1, "%-12.12s: %-4.4s %s\n", local_legend[6], d_source_code.arr, d_source_desc.arr);//added for globalisation
/*  fprintf(f1, "Organism    : %-4.4s %s\n\n", d_organism_code.arr, 
											d_organism_desc.arr);
*/
  fprintf(f1, "%-12.12s: %-4.4s %s\n\n", local_legend[7], d_organism_code.arr, 
											d_organism_desc.arr); //added for globalisation
//fprintf(f1, "Antibiotic  : %-4.4s %s\n", d_antibiotic_code.arr,
//											d_antibiotic_desc.arr);

//  fprintf(f1, "Sensitivity : %s\n\n", d_sensitivity_desc);

  line_no += 3;

}

form_hdr()
{
    static int first = 1;
    char buf[15];
    int col;

    if(first)
	 {
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
		memset(hdr_line5,'-',REP_WIDTH);
		hdr_line5[REP_WIDTH] = '\0';


        strncpy(hdr_line1,"MDL : RL",8);
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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DATE . GET\
_CURRENT_DATE ( :language_id ) ; :rep_date1 := to_char ( t_date , 'DD/MM/YYYY \
HH24:MI' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )275;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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



        col = (REP_WIDTH-(strlen(rep_date1.arr)+3));
        strcpy(hdr_line1+col,rep_date1.arr);
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,oper_id.arr);

     }

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : RLRINFCN",14);
    strcpy(rep_title1,local_legend[8]); //added for globalisation
    col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
    //sprintf(buf,"PAGE : %4d",page_no++);
    sprintf(buf,"%-4.4s : %4d",local_legend[9], page_no++); //added for globalisation
    strcpy(hdr_line3+(REP_WIDTH-(strlen(buf)+5)),buf);


    if(first)
        fprintf(f1,"%s\n",hdr_line1);
    else
		{
			fprintf(f1,"\n");	
			fprintf(f1,"\f%s\n",hdr_line1);
		}      

    fprintf(f1,"%s\n",hdr_line2);
    fprintf(f1,"%s\n",hdr_line3);
	fprintf(f1,"%s\n",hdr_line5);

	line_no += 4;
	first = 0;
   }
 

fetch_sys_info()
{

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
					TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
			INTO   :comp_name,
				   :rep_date,
				   :oper_id
	     FROM   SY_ACC_ENTITY_lang_vw
           WHERE ACC_ENTITY_ID = :nd_operating_facility_id
		   and language_id = :language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )298;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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
    sqlstm.sqhstl[1] = (unsigned int  )22;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&language_id;
    sqlstm.sqhstl[4] = (unsigned int  )7;
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



    if(OERROR)
	    disp_message(ERR_MESG, "SELECT failed on table  SY_ACC_ENTITY");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len]	 = '\0';
    oper_id.arr[oper_id.len]     = '\0';
}


close_control_cursor()
{
	/* EXEC SQL CLOSE control_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )333;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

close_stat_cursor()
{
	/* EXEC SQL OPEN stat_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0004;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )348;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_sequence_no;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
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


}

get_antibiotic_desc()
{
	d_antibiotic_desc.arr[0]		= '\0';
	d_antibiotic_desc.len			= 0;
	
	/* EXEC SQL SELECT long_desc
			 INTO :d_antibiotic_desc
			 FROM RL_ANTIBIOTIC_CODE_lang_vw
			 WHERE antibiotic_code = :d_antibiotic_code
			 and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_ANTIBIOTIC_CODE_lang_vw w\
here (antibiotic_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )371;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_antibiotic_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_antibiotic_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
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




	d_antibiotic_desc.arr[d_antibiotic_desc.len]	= '\0';
}

get_organism_desc()
{
	d_organism_desc.arr[0]		= '\0';
	d_organism_desc.len			= 0;
	
	/* EXEC SQL SELECT long_desc
			 INTO :d_organism_desc
			 FROM RL_ORGANISM_CODE_lang_vw
			 WHERE organism_code = :d_organism_code
			 and language_id = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_ORGANISM_CODE_lang_vw whe\
re (organism_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )398;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_organism_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_organism_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
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




	d_organism_desc.arr[d_organism_desc.len]	= '\0';
}

get_source_desc()
{
	d_source_desc.arr[0]		= '\0';
	d_source_desc.len			= 0;
	
	if (d_source_type.arr[0] == 'W')
	{
		/* EXEC SQL 
		/oSELECT long_desc
				 INTO :d_source_desc
				 FROM IP_WARD
				 WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
				 AND ward_code = :d_source_code;
		o/
		SELECT long_desc
				 INTO :d_source_desc
				 FROM IP_NURSING_UNIT_LANG_VW
				 WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
				 AND NURSING_UNIT_code = :d_source_code
				 and language_id = :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select long_desc into :b0  from IP_NURSING_UNIT_LANG_VW whe\
re ((FACILITY_ID=nvl(:b1,:b2) and NURSING_UNIT_code=:b3) and language_id=:b4)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )425;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_source_desc;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&rl_ordered_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_source_code;
  sqlstm.sqhstl[3] = (unsigned int  )14;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&language_id;
  sqlstm.sqhstl[4] = (unsigned int  )7;
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



	}
	else if (d_source_type.arr[0] == 'C')
	{
		/* EXEC SQL SELECT long_desc
				 INTO :d_source_desc
				 FROM OP_CLINIC_lang_vw
				 WHERE FACILITY_ID = nvl(:rl_ordered_facility_id,:nd_operating_facility_id)
				    AND clinic_code = :d_source_code
					and language_id = :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select long_desc into :b0  from OP_CLINIC_lang_vw where ((F\
ACILITY_ID=nvl(:b1,:b2) and clinic_code=:b3) and language_id=:b4)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )460;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_source_desc;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&rl_ordered_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_source_code;
  sqlstm.sqhstl[3] = (unsigned int  )14;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&language_id;
  sqlstm.sqhstl[4] = (unsigned int  )7;
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



	}
	else 
	{
		/* EXEC SQL SELECT long_desc
				 INTO :d_source_desc
				 FROM RL_REFERRAL_lang_vw
				 WHERE referral_code = :d_source_code
				 and language_id = :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select long_desc into :b0  from RL_REFERRAL_lang_vw where (\
referral_code=:b1 and language_id=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )495;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_source_desc;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_source_code;
  sqlstm.sqhstl[1] = (unsigned int  )14;
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

	d_source_desc.arr[d_source_desc.len]	= '\0';

}

/****************************** added for globalisation *****************************/
get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRINFCN.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRINFCN.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )522;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&language_id;
 sqlstm.sqhstl[1] = (unsigned int  )7;
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



	for (i=1; i<=cou; i++)
	{
	l_translated_value.arr[0]		= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRINFCN.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRINFCN.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )545;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )602;
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
