
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RD/RDRCLEXM.PC"
};


static unsigned int sqlctx = 1288577187;


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

 static const char *sq0006 = 
"select A.CLINIC_CODE ,A.EXAM_CODE ,sum(A.TOTAL_APPT_BOOKED) ,sum(A.TOTAL_ATT\
ENDED) ,sum(A.TOTAL_NO_SHOW)  from RD_APPT_STATS A ,RD_CLINIC B where ((((((((\
((A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID and A.OPERATING_FACILITY_ID=\
:b0) and A.CLINIC_CODE=B.CLINIC_CODE) and A.SECTION_CODE=B.SECTION_CODE) and T\
RUNC(A.CLINIC_DATE) between TO_DATE(:b1,'DD/MM/YYYY') and TO_DATE(:b2,'DD/MM/Y\
YYY')) and A.CLINIC_CODE=B.CLINIC_CODE) and A.SECTION_CODE=B.SECTION_CODE) and\
 B.WING_CODE=:b3) and A.CLINIC_CODE between :b4 and :b5) and A.SECTION_CODE=:b\
6) and A.EXAM_CODE between :b7 and :b8) group by A.CLINIC_CODE,A.EXAM_CODE    \
       ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,171,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,216,0,0,0,0,0,1,0,
51,0,0,3,234,0,4,256,0,0,11,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
110,0,0,4,134,0,2,301,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
137,0,0,5,158,0,4,336,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
172,0,0,6,629,0,9,400,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
223,0,0,6,0,0,13,515,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,3,0,0,
258,0,0,7,88,0,4,577,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
285,0,0,8,95,0,4,593,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
312,0,0,9,125,0,4,610,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
343,0,0,10,122,0,4,630,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
374,0,0,11,322,0,6,912,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,3,3,0,0,2,9,0,0,
405,0,0,12,112,0,6,947,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
428,0,0,13,136,0,6,960,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};



/******************************************************************************/
/* OCS MEDICOM VER 1.0                                                        */
/******************************************************************************/
/* PROGRAM NAME     : rdrclexm.pc                                             */
/* AUTHOR           : VASANT KUMAR	                                      */
/* DATE WRITTEN     : 10-MAY-1993                                             */
/*                                                                            */
/* CALLED FROM      : rdrclexm.inp                                            */
/*                                                                            */
/* INPUT PARAMETERS : USER_ID/PASSWORD                                        */
/*                  : SESSION_ID                                              */
/*                  : PGM_DATE                                                */
/*                  : APPOINTMENT FROM AND TO DATE                            */
/*                  : APPOINTMENT FROM AND TO CLINIC                          */
/*                                                                            */
/* TABLES ACCESSED  : SY_PROG_PARAM                                           */
/*                  : SY_ACC_ENTITY                                           */
/*                  : RD_APPT_STATS                                           */
/*                  : SY_PHYSICIAN_MAST                                       */
/*                  : RD_CLINIC                                               */
/*                                                                            */
/* OUTPUT FILE      : rdrclexm.lis                                            */
/*                                                                            */
/*                                                                            */
/* FUNCTION         : This program prints a Appointments statistics by Clinic */
/*                    for Inpatients and outpatients                          */
/*                    For a given SY_PROG_PARAM parameters                    */
/*                                                                            */
/* VERSION          : 1.10.01                                                 */
/* MODIFICATIONS    :                                                         */
/* VERSION          : eHIS 4.1                                                */
/*                                                                            */
/* AUTHOR           : Rajanish Nambiar                                        */
/*                                                                            */
/* DATE MODIFIED    : 08/Aug/2003                                             */
/*                                                                            */
/******************************************************************************/

#include <stdio.h>
#include <math.h>
#include "gl.h"
#include <string.h>

#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND sqlca.sqlcode==1403
#define MAX_LINES 55
#define REP_WIDTH 80
#define REP_TITLE "APPOINTMENTS STATISTICS"
#define VER  "VER : 10.2\n"
#define ESC  0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR nd_facility_id		   [3],  --added by rvN 0n 06/Aug/2003
			nd_pgm_id    		   [9],  --added by rvN 0n 06/Aug/2003
		//	uid_pwd		           [91], --size increased by rvN 0n 06/Aug/2003
			uid_pwd		           [122], /o Length increased from 91 to 122 o/
			nd_session_id		   [16],
			nd_pgm_date			   [13], /o Input Parameters       o/

			h_acc_entity_name      [61],  /o SY_ACC_ENTITY header access o/
			h_user                 [31],
			h_sysdate              [17],

			nd_fr_appt_date        [13],  /o SY_PROG_PARAM Parameters o/
			nd_to_appt_date        [13],
			nd_fr_clinic_code      [5], 
			nd_to_clinic_code      [5], 
			nd_fr_section_code     [5], 
			nd_to_section_code     [5], 
			nd_fr_exam_code        [11],
			nd_to_exam_code        [11],
			nd_wing_code           [3],
			h_wing_desc            [91] ,

			o_section_desc         [91],   /o Desc for the Code access o/
			o_clinic_desc          [46],
			o_exam_desc            [121],

			o_clinic_code          [5],    /o Cursor Fieldo/
			o_section_code         [7],
			o_appt_date            [11],
			o_exam_code            [11],
			
			t_clinic_code          [5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[9]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[122]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[13]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[61]; } h_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } h_user;

struct { unsigned short len; unsigned char arr[17]; } h_sysdate;

struct { unsigned short len; unsigned char arr[13]; } nd_fr_appt_date;

struct { unsigned short len; unsigned char arr[13]; } nd_to_appt_date;

struct { unsigned short len; unsigned char arr[5]; } nd_fr_clinic_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_clinic_code;

struct { unsigned short len; unsigned char arr[5]; } nd_fr_section_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_section_code;

struct { unsigned short len; unsigned char arr[11]; } nd_fr_exam_code;

struct { unsigned short len; unsigned char arr[11]; } nd_to_exam_code;

struct { unsigned short len; unsigned char arr[3]; } nd_wing_code;

struct { unsigned short len; unsigned char arr[91]; } h_wing_desc;

struct { unsigned short len; unsigned char arr[91]; } o_section_desc;

struct { unsigned short len; unsigned char arr[46]; } o_clinic_desc;

struct { unsigned short len; unsigned char arr[121]; } o_exam_desc;

struct { unsigned short len; unsigned char arr[5]; } o_clinic_code;

struct { unsigned short len; unsigned char arr[7]; } o_section_code;

struct { unsigned short len; unsigned char arr[11]; } o_appt_date;

struct { unsigned short len; unsigned char arr[11]; } o_exam_code;

struct { unsigned short len; unsigned char arr[5]; } t_clinic_code;
     /* Temperory var for Break */

	/* VARCHAR	p_language_id		   [3],
			date_convert		   [21],
			nd_temp_date		   [21],
			nd_loc_date            [21],
			l_translated_value	   [200]; */ 
struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[200]; } l_translated_value;


			int line_no=0, page_no=0;
		
			int i=0;
			int time_flag = 0;

			long total_appt_booked,
				 total_attended,
				 total_noshow;

			long sec_total_booked    = 0,
			     sec_total_attended  = 0,
			     sec_total_noshow    = 0;

			long cl_total_booked     = 0,
			     cl_total_attended   = 0,
			     cl_total_noshow     = 0;

			long date_total_booked   = 0,
			     date_total_attended = 0,
			     date_total_noshow   = 0,
				 
				 gr_total_booked     = 0,
			     gr_total_attended   = 0,
			     gr_total_noshow     = 0;

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

char string_var[100];
char filename[150];

char loc_legend[999][200];
             
FILE *f1;

void proc_main(argc, argv)
int argc;
char *argv[];
{
	void get_params(),
         get_header_dtls(),
         dclr_appt_cur(),
         do_report();

	if(argc != 6) {
		int i = 0;
		disp_message(ERR_MESG,"Usage rdrclexm uid/passwd session_id pgm_date\n");
		disp_message(ERR_MESG,"Exiting due to Mismatch of input parameters\007\007\007");
		sprintf(string_var,"No of Parameters is <%d>\n",argc);
		disp_message(ERR_MESG,string_var); 
		disp_message(ERR_MESG,"The following are the parameters :-\n");
		for(i=0;i<argc;i++) sprintf(string_var,"argv[ %d ] ---> <%s>\n",i,argv[i]);
		disp_message(ERR_MESG,string_var);
		proc_exit();
	}

	strcpy(nd_pgm_id.arr, argv[0]);
	nd_pgm_id.len = strlen(nd_pgm_id.arr); 

	strcpy(uid_pwd.arr, argv[1]);
	uid_pwd.len = strlen(uid_pwd.arr); 

	strcpy(nd_session_id.arr, argv[2]);
	nd_session_id.len = strlen(nd_session_id.arr); 

	strcpy(nd_pgm_date.arr, argv[3]);
	nd_pgm_date.len = strlen(nd_pgm_date.arr); 

	strcpy(nd_facility_id.arr, argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);

	strcpy(OUTPUT_FILE_NAME, argv[5]);
	
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
 sqlstm.sqhstl[0] = (unsigned int  )124;
 sqlstm.sqhsts[0] = (         int  )124;
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

  

	if (OERROR) {
		disp_message(ERR_MESG,"USERID/PASSWORD failed to Connect\n");
		proc_exit();
	}

	set_meduser_role();

	/*Code Included for internationalization*/
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;
	
	/*printf("RDRCLEXM : Program Started.\n\n");  */
	strcpy(filename,WORKING_DIR);
	//strcat(filename,"rdrclexm.lis");
	strcat(filename,OUTPUT_FILE_NAME);

	if((f1 = fopen(filename, "w")) == NULL) {
		disp_message(ERR_MESG,".... Error opening output file ....\n");
		proc_exit();
	} 

	#ifdef DEBUG
    disp_message(ORA_MESG,"Connected to ORACLE as user: %s \n", uid_pwd.arr);
    
    sprintf(string_var,"nd_session_id = %s\n", nd_session_id.arr);
    disp_message(ERR_MESG,string_var);
    sprintf(string_var,"nd_pgm_date = %s\n", nd_pgm_date.arr);
    disp_message(ERR_MESG,string_var);
	#endif  
   
	fprintf(f1,"%c&k4S",ESC);
	fprintf(f1,"%c&a7L",ESC);/*for landscape printing by rvNambiar on 26/Aug/2003 */

	get_params();

	fetch_legend_value();

	get_header_dtls();

	dclr_appt_cur();
	
	do_report();

	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	/*-------------- Check for any error and No data found ----------------------*/
	if (OERROR) {
		disp_message(ERR_MESG,"COMMIT failed\n" );
		proc_exit();
	}
	/*-------------------------- End of Error Check ------------------------------*/

	fclose(f1);

	/*printf("RDRCLEXM : Program Ended.\n\n");*/
	
	return;

}   

/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                 */
void get_params()
{
   nd_fr_appt_date.len         = 0;
   nd_to_appt_date.len         = 0;
   nd_to_section_code.len      = 0;
   nd_fr_section_code.len      = 0;
   nd_to_clinic_code.len       = 0;
   nd_fr_clinic_code.len       = 0;
   nd_fr_exam_code.len         = 0;
   nd_to_exam_code.len         = 0;

   nd_fr_appt_date.arr[nd_fr_appt_date.len]         = '\0';
   nd_to_appt_date.arr[nd_to_appt_date.len]         = '\0';
   nd_to_section_code.arr[nd_to_section_code.len]   = '\0';
   nd_fr_section_code.arr[nd_fr_section_code.len]   = '\0';
   nd_to_clinic_code.arr[nd_to_clinic_code.len]     = '\0';
   nd_fr_clinic_code.arr[nd_fr_clinic_code.len]     = '\0';
   nd_fr_exam_code.arr[nd_fr_exam_code.len]         = '\0';
   nd_to_exam_code.arr[nd_to_exam_code.len]         = '\0';

   /* read the parameter record */
   /* EXEC SQL SELECT PARAM1,
		   PARAM2,
		   PARAM3,
		   PARAM4,
		   PARAM5,
		   PARAM6,
		   PARAM7,
		   PARAM8
	 INTO  :nd_wing_code,
		   :nd_fr_section_code,
		   :nd_fr_appt_date,
		   :nd_to_appt_date,
    	   :nd_fr_clinic_code,
		   :nd_to_clinic_code,
		   :nd_fr_exam_code,
           :nd_to_exam_code
		   
     FROM  SY_PROG_PARAM
	 WHERE OPERATING_FACILITY_ID = :nd_facility_id
	 AND   PGM_ID                = 'RDRCLEXM'
	 AND   SESSION_ID            = TO_NUMBER(:nd_session_id)
	 AND   PGM_DATE              = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,PARAM8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_PROG_PARAM where (((\
OPERATING_FACILITY_ID=:b8 and PGM_ID='RDRCLEXM') and SESSION_ID=TO_NUMBER(:b9)\
) and PGM_DATE=:b10)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_wing_code;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fr_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fr_appt_date;
   sqlstm.sqhstl[2] = (unsigned int  )15;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_appt_date;
   sqlstm.sqhstl[3] = (unsigned int  )15;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fr_clinic_code;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_clinic_code;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fr_exam_code;
   sqlstm.sqhstl[6] = (unsigned int  )13;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_exam_code;
   sqlstm.sqhstl[7] = (unsigned int  )13;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[8] = (unsigned int  )5;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[10] = (unsigned int  )15;
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



/*-------------- Check for any error and No data found ----------------------*/
   if (OERROR) {
      disp_message(ERR_MESG,"SELECT failed on SY_PROG_PARAM\n" );
      proc_exit();
      }

   if (NO_DATA_FOUND) {
      disp_message(ERR_MESG,"No Data Found in the SY_PROG_PARAM\n");
      proc_exit();
      }
/*-------------------------- End of Error Check ------------------------------*/
   nd_wing_code.arr[nd_wing_code.len]               = '\0';
   nd_fr_appt_date.arr[nd_fr_appt_date.len]         = '\0';
   nd_to_appt_date.arr[nd_to_appt_date.len]         = '\0';
   nd_to_section_code.arr[nd_to_section_code.len]   = '\0';
   nd_fr_section_code.arr[nd_fr_section_code.len]   = '\0';
   nd_to_clinic_code.arr[nd_to_clinic_code.len]     = '\0';
   nd_fr_clinic_code.arr[nd_fr_clinic_code.len]     = '\0';
   nd_fr_exam_code.arr[nd_fr_exam_code.len]         = '\0';
   nd_to_exam_code.arr[nd_to_exam_code.len]         = '\0';

  /* delete the parameter record */
  /* EXEC SQL DELETE SY_PROG_PARAM
		   WHERE OPERATING_FACILITY_ID = :nd_facility_id
		   AND   PGM_ID                = 'RDRCLEXM'
		   AND   SESSION_ID            = TO_NUMBER(:nd_session_id)
		   AND   PGM_DATE              = :nd_pgm_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((OPERATING_FACILITY_ID=\
:b0 and PGM_ID='RDRCLEXM') and SESSION_ID=TO_NUMBER(:b1)) and PGM_DATE=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )110;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_session_id;
  sqlstm.sqhstl[1] = (unsigned int  )18;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
  sqlstm.sqhstl[2] = (unsigned int  )15;
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



/*-------------- Check for any error and No data found ----------------------*/

   if (OERROR) {
      disp_message(ERR_MESG,"DELETE failed on SY_PROG_PARAM\n");
      proc_exit();
      }

   if (NO_DATA_FOUND) {
      disp_message(ERR_MESG,"No Data Found in the SY_PROG_PARAM\n");
      proc_exit();
      }

/*------------------------- End of Error Check -------------------------------*/

  return;

}
 
/*--------------------------- get the header details -------------------------*/
void get_header_dtls()
{
  h_acc_entity_name.len  = 0;
  h_user.len             = 0;
  h_sysdate.len          = 0;

  h_acc_entity_name.arr[h_acc_entity_name.len]   = '\0';
  h_user.arr[h_user.len]                         = '\0';
  h_sysdate.arr[h_sysdate.len]                   = '\0';

   /* EXEC SQL SELECT ACC_ENTITY_NAME, USER,
				   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
			INTO   :h_acc_entity_name, :h_user,
				   :h_sysdate
            FROM   SY_ACC_ENTITY_LANG_VW
			WHERE  acc_entity_id = :nd_facility_id
			AND    language_id  = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (acc_entity_id=:b\
3 and language_id=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )137;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&h_acc_entity_name;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&h_user;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&h_sysdate;
   sqlstm.sqhstl[2] = (unsigned int  )19;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&p_language_id;
   sqlstm.sqhstl[4] = (unsigned int  )5;
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



/*-------------- Check for any error and No data found ----------------------*/
   if (OERROR) {
      disp_message(ERR_MESG,"SELECT failed on SY_ACC_ENTITY\n");
      proc_exit();
      }

   if (NO_DATA_FOUND) {
      disp_message(ERR_MESG,"No Data Found in the SY_ACC_ENTITY\n");
      proc_exit();
      }
/*------------------------- End of Error Check -------------------------------*/
  h_acc_entity_name.arr[h_acc_entity_name.len]   = '\0';
  h_user.arr[h_user.len]                         = '\0';
  h_sysdate.arr[h_sysdate.len]                   = '\0';

  return;
}
/*------------------------- End of Header access -----------------------------*/

/*------------------------- Appointments Cursor ------------------------------*/
void dclr_appt_cur()
{
  /* EXEC SQL DECLARE  APPT_CUR CURSOR FOR
                    SELECT A.CLINIC_CODE,
			               A.EXAM_CODE,
			               SUM(A.TOTAL_APPT_BOOKED),
			               SUM(A.TOTAL_ATTENDED),
                           SUM(A.TOTAL_NO_SHOW)
                    FROM   RD_APPT_STATS A , RD_CLINIC B
                    WHERE  A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
					AND    A.OPERATING_FACILITY_ID = :nd_facility_id
					AND    A.CLINIC_CODE = B.CLINIC_CODE
					AND    A.SECTION_CODE = B.SECTION_CODE
					AND    TRUNC(A.CLINIC_DATE) BETWEEN 
						   TO_DATE(:nd_fr_appt_date, 'DD/MM/YYYY')
						   AND 
						   TO_DATE(:nd_to_appt_date, 'DD/MM/YYYY')
			        AND    A.CLINIC_CODE = B.CLINIC_CODE
					AND    A.SECTION_CODE = B.SECTION_CODE
					AND    B.WING_CODE    = :nd_wing_code
                    AND    A.CLINIC_CODE BETWEEN
						   :nd_fr_clinic_code AND :nd_to_clinic_code
                    AND    A.SECTION_CODE = :nd_fr_section_code
                    AND    A.EXAM_CODE BETWEEN
						   :nd_fr_exam_code AND :nd_to_exam_code
                 GROUP BY A.CLINIC_CODE,
                             A.EXAM_CODE; */ 

/*-------------- Check for any error and No data found ----------------------*/

   if (OERROR) {
      disp_message(ERR_MESG,"SELECT failed on OA_APPT\n");
      proc_exit();
      }

/*------------------------- End of Error Check -------------------------------*/

  /* EXEC SQL OPEN APPT_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0006;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )172;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_fr_appt_date;
  sqlstm.sqhstl[1] = (unsigned int  )15;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_appt_date;
  sqlstm.sqhstl[2] = (unsigned int  )15;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_wing_code;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_fr_clinic_code;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_to_clinic_code;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_fr_section_code;
  sqlstm.sqhstl[6] = (unsigned int  )7;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fr_exam_code;
  sqlstm.sqhstl[7] = (unsigned int  )13;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_exam_code;
  sqlstm.sqhstl[8] = (unsigned int  )13;
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



/*-------------- Check for any error and No data found ----------------------*/

   if (OERROR) {
      disp_message(ERR_MESG,"OPEN failed on APPT_CUR\n");
      proc_exit();
      }

/*------------------------- End of Error Check -------------------------------*/
  return;
/*------------------------- End of Appt Cursor -------------------------------*/
}

/*------------------------- Fetching from Appt Cursor ------------------------*/
void do_report()
{
  void  print_page_header(),
	print_rep_header(),
	print_hdr(),
	print_detl_rec(),
	get_clinic_desc(),
	get_exam_desc(),
	get_section_desc();

  int fetch_appt_cur();
  int first = 1, posted = 0;

  print_rep_header(); /* once for the report */

  /*---------------------- read the first cursor record ----------------------*/

  get_section_desc();

  while(fetch_appt_cur()){

     if (first)
     {
        strcpy(t_clinic_code.arr, o_clinic_code.arr);
        t_clinic_code.len = o_clinic_code.len;
        print_page_header();
        print_hdr();
        first = 0;
     }

     if (strcmp(t_clinic_code.arr,o_clinic_code.arr) != 0)
     {
        if (line_no+3 > MAX_LINES)
        {
           fprintf(f1,"");
           print_page_header();
           print_hdr();
        }                  
        print_clinic_total();

        strcpy(t_clinic_code.arr, o_clinic_code.arr);
        t_clinic_code.len = o_clinic_code.len;

        if ( line_no > MAX_LINES )
        {
           fprintf(f1,"");
           print_page_header();
           print_hdr();
        }
        else
        {
           print_room_hdr();
        }
     }

     if(line_no >= MAX_LINES){
        fprintf(f1,"");
        print_page_header();
        print_hdr();
     }

     print_detl_rec();
     line_no += 1;

/*------------------------------- Total Room -------------------------------*/
     cl_total_booked   = total_appt_booked   + cl_total_booked;
     cl_total_attended = total_attended + cl_total_attended;
     cl_total_noshow   = total_noshow   + cl_total_noshow;

/*------------------------------- Total Section ----------------------------*/
     sec_total_booked   = sec_total_booked   + total_appt_booked;
     sec_total_attended = sec_total_attended + total_attended;
     sec_total_noshow   = sec_total_noshow   + total_noshow;

  }

  if ( ( line_no + 6 ) > MAX_LINES )
  {
     fprintf(f1,"");
     print_page_header();
     print_hdr();
  }

  print_clinic_total();
  print_section_total();
  print_end_of_rep();
}
/* -------------------------- End of Report function -------------------------*/

/* fetches the next record from APPT_CUR     */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_appt_cur()
{
  o_clinic_code.len                  = 0;
  o_exam_code.len                    = 0;

  o_clinic_code.arr[o_clinic_code.len]                   = '\0';
  o_exam_code.arr[o_exam_code.len]                       = '\0';

  /* EXEC SQL FETCH APPT_CUR INTO
	                  :o_clinic_code,
			  :o_exam_code,
			  :total_appt_booked,
			  :total_attended,
			  :total_noshow; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )223;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&o_clinic_code;
  sqlstm.sqhstl[0] = (unsigned int  )7;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&o_exam_code;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&total_appt_booked;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&total_attended;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&total_noshow;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(long);
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



   if (OERROR) {
      disp_message(ERR_MESG,"FETCH failed on cursor APPT_CUR\n");
      proc_exit();
      }

  if (NO_DATA_FOUND)
      return 0;

  o_clinic_code.arr[o_clinic_code.len]                   = '\0';
  o_exam_code.arr[o_exam_code.len]                       = '\0';

  return 1;
}
       
/* to print the detailed record with to horizontal summeries */
void print_detl_rec()
{
    get_exam_desc ();

    fprintf(f1,"%-11s  %-41s ", o_exam_code.arr, o_exam_desc.arr);
    fprintf(f1,"%4d  ",total_appt_booked);
    fprintf(f1,"%5d  ",total_attended);
    fprintf(f1,"%8d\n",total_noshow);
}

print_section_total()
{ 
    print_line('_',REP_WIDTH);
	//fprintf(f1,"                                     Section Total : ");
	fprintf(f1,"%50s : ",loc_legend[21]);
    fprintf(f1,"%6d      ",sec_total_booked);
    fprintf(f1,"%1d      ",sec_total_attended);
    fprintf(f1,"%4d\n",sec_total_noshow);
	print_line('_',REP_WIDTH); fprintf(f1,"\n");
}

/*-------------------------------- Clinic Total ------------------------------*/
print_clinic_total()
{
//fprintf(f1,"\n                                        Room Total : ");
fprintf(f1,"\n%50s : ",loc_legend[22]);
fprintf(f1,"%6d      ",cl_total_booked);
fprintf(f1,"%ld      ",cl_total_attended);
fprintf(f1,"%4d\n\n",cl_total_noshow);
      cl_total_booked     = 0;
      cl_total_attended   = 0;
      cl_total_noshow     = 0;
}

/*----------------------------- Get Exam Desc --------------------------------*/
void get_exam_desc ()
  {
     o_exam_desc.arr[0]  = '\0';
     o_exam_desc.len     = 0;

     /* EXEC SQL SELECT LONG_DESC
	      INTO   :o_exam_desc
	      FROM   RD_EXAMINATION
	      WHERE  EXAM_CODE = :o_exam_code
		  AND    language_id = :p_language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 11;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select LONG_DESC into :b0  from RD_EXAMINATION where (EX\
AM_CODE=:b1 and language_id=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )258;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&o_exam_desc;
     sqlstm.sqhstl[0] = (unsigned int  )123;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&o_exam_code;
     sqlstm.sqhstl[1] = (unsigned int  )13;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&p_language_id;
     sqlstm.sqhstl[2] = (unsigned int  )5;
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



     o_exam_desc.arr [ o_exam_desc.len ] = '\0';
  }
/*----------------------------- End Exam Desc -------------------------------*/

void get_section_desc()
{
  o_section_desc.len = 0;

  o_section_desc.arr[o_section_desc.len] = '\0';

   /* EXEC SQL SELECT 	LONG_DESC
            INTO        :o_section_desc
	    FROM        RD_SECTION_lang_vw
	    WHERE       SECTION_CODE = :nd_fr_section_code
		AND			language_id = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from RD_SECTION_lang_vw where (\
SECTION_CODE=:b1 and language_id=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )285;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&o_section_desc;
   sqlstm.sqhstl[0] = (unsigned int  )93;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fr_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_language_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
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

	

  o_section_desc.arr[o_section_desc.len] = '\0';

  return;
}

/*------ gets the Clinic desc for the Clinic code ----------------------------*/
void get_clinic_desc()
{
   o_clinic_desc.arr[0] = '\0';
   o_clinic_desc.len    = 0;
  
   /* EXEC SQL SELECT LONG_DESC
            INTO   :o_clinic_desc
			FROM   RD_CLINIC_lang_vw
			WHERE  OPERATING_FACILITY_ID = :nd_facility_id
			AND	   CLINIC_CODE = :t_clinic_code
			AND    language_id = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from RD_CLINIC_lang_vw where ((\
OPERATING_FACILITY_ID=:b1 and CLINIC_CODE=:b2) and language_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )312;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&o_clinic_desc;
   sqlstm.sqhstl[0] = (unsigned int  )48;
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
   sqlstm.sqhstv[2] = (         void  *)&t_clinic_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&p_language_id;
   sqlstm.sqhstl[3] = (unsigned int  )5;
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

	

  o_clinic_desc.arr[o_clinic_desc.len] = '\0';

  return;
}
/*-------------------- End of clinic Desc ------------------------------------*/

/*------ gets the Wing desc for the Wing code ----------------------------*/
void get_wing_desc()
{
  
  h_wing_desc.arr [0]   = '\0';
  h_wing_desc.len     = 0;

   /* EXEC SQL SELECT LONG_DESC
			INTO   :h_wing_desc
			FROM   RD_WINGS_lang_vw
			WHERE  OPERATING_FACILITY_ID = :nd_facility_id
			AND	   WING_CODE = :nd_wing_code
			AND    language_id = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from RD_WINGS_lang_vw where ((O\
PERATING_FACILITY_ID=:b1 and WING_CODE=:b2) and language_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )343;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&h_wing_desc;
   sqlstm.sqhstl[0] = (unsigned int  )93;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_wing_code;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&p_language_id;
   sqlstm.sqhstl[3] = (unsigned int  )5;
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

	

  h_wing_desc.arr [ h_wing_desc.len ] = '\0';
  return;
}

/*-------------------- End of Wing Desc ------------------------------------*/


/*-------------------- to print the header page for the report ---------------*/

void print_rep_header()
{
  char fr_appt_date_desc[11], to_appt_date_desc[11];
  char fr_section_code_desc[8], to_section_code_desc[8];
  char fr_clinic_code_desc[8], to_clinic_code_desc[8];
  char fr_exam_code_desc[11], to_exam_code_desc[11];

  if(strcmp(nd_fr_section_code.arr, "!!!!") == 0)
	/* Legend[5]  -- LOWEST  */
    strcpy(fr_section_code_desc, loc_legend[5]);
    else strcpy(fr_section_code_desc, nd_fr_section_code.arr);

  if(strcmp(nd_to_section_code.arr, "~~~~") == 0)
	/* Legend[6]  -- HIGHEST  */
    strcpy(to_section_code_desc, loc_legend[6]);
    else strcpy(to_section_code_desc, nd_to_section_code.arr);

  if(strcmp(nd_fr_clinic_code.arr, "!!!!") == 0)
	/* Legend[5]  -- LOWEST  */
    strcpy(fr_clinic_code_desc, loc_legend[5]);
    else strcpy(fr_clinic_code_desc, nd_fr_clinic_code.arr);

  if(strcmp(nd_to_clinic_code.arr, "~~~~") == 0)
	/* Legend[6]  -- HIGHEST  */
    strcpy(to_clinic_code_desc, loc_legend[6]);
    else strcpy(to_clinic_code_desc, nd_to_clinic_code.arr);

  if(strcmp(nd_fr_exam_code.arr, "!!!!!!!!!!!") == 0)
	/* Legend[5]  -- LOWEST  */
    strcpy(fr_exam_code_desc, loc_legend[5]);
    else strcpy(fr_exam_code_desc, nd_fr_exam_code.arr);

  if(strcmp(nd_to_exam_code.arr, "~~~~~~~~~~~") == 0)
	/* Legend[6]  -- HIGHEST  */
    strcpy(to_exam_code_desc, loc_legend[6]);
    else strcpy(to_exam_code_desc, nd_to_exam_code.arr);

  if(strcmp(nd_fr_appt_date.arr, "01/01/1800") == 0)
	/* Legend[5]  -- LOWEST  */
    strcpy(fr_appt_date_desc, loc_legend[5]);
   else 
	{
		//strcpy(fr_appt_date_desc, nd_fr_appt_date.arr);
		init_date_temp_var();
		strcpy(date_convert.arr,nd_fr_appt_date.arr);
		time_flag = 0;
		fun_change_loc_date();
		strcpy(fr_appt_date_desc, date_convert.arr);
    }

  if(strcmp(nd_to_appt_date.arr, "31/12/4712") == 0)
	/* Legend[6]  -- HIGHEST  */
    strcpy(to_appt_date_desc, loc_legend[6]);
    else 
	{
		//strcpy(to_appt_date_desc, nd_to_appt_date.arr);
		init_date_temp_var();
		strcpy(date_convert.arr,nd_to_appt_date.arr);
		time_flag = 0;
		fun_change_loc_date();
		strcpy(to_appt_date_desc, date_convert.arr);
	}
  print_page_header();

  fprintf(f1,VER);
  fprintf(f1,"\n\n\n\n");
  fprintf(f1,"        ");
  /* legend[7]  --  INPUT PARAMETERS  */
  fprintf(f1,"%s :\n",loc_legend[7]);
  fprintf(f1,"        ");
  fprintf(f1 ,"__________________\n\n");

 /* fprintf(f1,"------------------\n\n"); */
  fprintf(f1,"                ");
  //fprintf(f1,"APPOINTMENT DATE FROM         : %s\n", fr_appt_date_desc);
  fprintf(f1,"%-23.23s %-8s: %s\n",loc_legend[8],loc_legend[3], fr_appt_date_desc);
  fprintf(f1,"                ");
  //fprintf(f1,"                 TO           : %s\n", to_appt_date_desc);
  fprintf(f1,"%-23.23s %-8s: %s\n","",loc_legend[4],to_appt_date_desc);
  fprintf(f1,"\n");
  fprintf(f1,"                ");
  //fprintf(f1,"WING CODE                     : %s\n", nd_wing_code.arr);
  fprintf(f1,"%-32.32s: %s\n",loc_legend[9], nd_wing_code.arr);
  fprintf(f1,"\n");
  fprintf(f1,"                ");
  //fprintf(f1,"SECTION CODE                  : %s\n", nd_fr_section_code.arr);
  fprintf(f1,"%-32.32s: %s\n", loc_legend[10],nd_fr_section_code.arr);
  fprintf(f1,"\n");
  fprintf(f1,"                ");
  //fprintf(f1,"ROOM CODE        FROM         : %s\n", fr_clinic_code_desc);
  fprintf(f1,"%-23.23s %-8s: %s\n",loc_legend[11],loc_legend[3], fr_clinic_code_desc);
  fprintf(f1,"                ");
  //fprintf(f1,"                 TO           : %s\n", to_clinic_code_desc);
  fprintf(f1,"%-23.23s %-8s: %s\n","",loc_legend[4], to_clinic_code_desc);
  fprintf(f1,"\n");
  fprintf(f1,"                ");
  //fprintf(f1,"EXAM   CODE      FROM         : %s\n", fr_exam_code_desc);
  fprintf(f1,"%-23.23s %-8s: %s\n", loc_legend[12],loc_legend[3],fr_exam_code_desc);
  fprintf(f1,"                ");
  //fprintf(f1,"                 TO           : %s\n", to_exam_code_desc);
  fprintf(f1,"%-23.23s %-8s: %s\n","",loc_legend[4],to_exam_code_desc);
  fprintf(f1,"");
 }

/* to print page headers the header details */ 
void print_page_header()
{
	int hosp_nm_len, rep_title_len = 10, s1, s2;
	char v_rep_title[200];
	
	char fr_appt_date_desc[11], to_appt_date_desc[11];

	if(strcmp(nd_fr_appt_date.arr, "01/01/1800") == 0)
		/*  legend[5]  --  LOWEST  */
		strcpy(fr_appt_date_desc, loc_legend[5]);
	else 
	{
		//strcpy(fr_appt_date_desc, nd_fr_appt_date.arr);
		init_date_temp_var();
		strcpy(date_convert.arr,nd_fr_appt_date.arr);
		time_flag = 0;
		fun_change_loc_date();
		strcpy(fr_appt_date_desc, date_convert.arr);
	}

	if(strcmp(nd_to_appt_date.arr, "31/12/4712") == 0)
		/*  legend[6]  -- HIGHEST  */
		strcpy(to_appt_date_desc, loc_legend[6]);
	else
	{
		//strcpy(to_appt_date_desc, nd_to_appt_date.arr);
		init_date_temp_var();
		strcpy(date_convert.arr,nd_to_appt_date.arr);
		time_flag = 0;
		fun_change_loc_date(); 
		strcpy(to_appt_date_desc, date_convert.arr);
	}

	page_no ++;

	fprintf(f1,"MDL : RD");                                                
	hosp_nm_len  =  h_acc_entity_name.len;                                 
	s1 = (REP_WIDTH-hosp_nm_len)/2;                                        
	horz_skip(s1-8);                                                       
	fprintf(f1,"%s", h_acc_entity_name.arr);                               
	s2 = (REP_WIDTH-s1-hosp_nm_len);                                       
	horz_skip(s2-16); 
	
	init_date_temp_var();
	strcpy(date_convert.arr,h_sysdate.arr);
	time_flag = 1;
    fun_change_loc_date();
	//fprintf(f1,"%s", h_sysdate.arr);                                       
	fprintf(f1,"%s", date_convert.arr);
                                                                       
	fprintf(f1,"\n"); fprintf(f1,"OPR : %s", h_user.arr); fprintf(f1,"\n");
                                                                       
	fprintf(f1,"REP : %s",nd_pgm_id.arr); 
	
	/* legend[1] --  APPOINTMENTS STATISTICS */
	strcpy(v_rep_title,loc_legend[1]);                                         
	rep_title_len = strlen(v_rep_title);                                   
	s1 = (REP_WIDTH-rep_title_len)/2;                                      
	horz_skip(s1-14);                                                      
	//fprintf(f1,"%s",REP_TITLE);     
	fprintf(f1,"%s",v_rep_title);     
	                                       
	s2 = (REP_WIDTH-s1-rep_title_len);                                     
	horz_skip(s2-10);
	/*  legend[2]  -- PAGE  */
	fprintf(f1,"%s :%4d\n",loc_legend[2], ++page_no);                                                      
	//fprintf(f1,"PAGE :%4d\n",++page_no);
                                                                       
	fprintf(f1,"                        ");
	/*  legend[3]  -- FROM ;  legend[4]  --  TO   */  
	fprintf(f1,"%s : %-10s", loc_legend[3],fr_appt_date_desc);
	fprintf(f1," %s : %-10s", loc_legend[4], to_appt_date_desc);
	fprintf(f1,"\n");
	
	print_line('_',REP_WIDTH);
	
	line_no = 5;
}

/*------------------------------ Name Header ---------------------------------*/
void print_hdr()

{
	get_wing_desc();
	/*  legend[13]   -- Wing   */
	fprintf(f1,"%-17.17s: %-30s\n\n",loc_legend[13],h_wing_desc.arr);
	/*  legend[14]   -- Section   */
	fprintf(f1,"%-17.17s: %-4s %-30s\n\n",loc_legend[14],nd_fr_section_code.arr, o_section_desc.arr);
	//fprintf(f1,"Examination Code & Description                        Booked  Attended  No Show\n");
	fprintf(f1,"%-53.53s %-7.7s %-9.9s %-s\n",loc_legend[15],loc_legend[16],loc_legend[17],loc_legend[18]);
	print_line('_',REP_WIDTH); fprintf(f1,"\n");
	print_room_hdr();
	line_no += 5;
}
/*------------------------------ End Header ----------------------------------*/

print_room_hdr()
{
   get_clinic_desc();
   fprintf(f1,"%-17.17s: %-4s %-30s\n\n",loc_legend[20],t_clinic_code.arr, o_clinic_desc.arr);
   line_no += 2;
}

/*---------------------------------------------------------------------------*/

print_end_of_rep()
{
    horz_skip(25);
	/*  legend[19]  -- End of Report  */
	fprintf(f1,"***** %s *****",loc_legend[19]);
	fprintf(f1,"%cE",ESC); /*for resetting to default mode by 
							  rvNambiar on 26/Aug/2003 */
} 

print_line(ch,n) /* this is to obtain required characters */
  char ch;
  int n;
{
	int i;
	for(i=0;i<n;i++)
	fprintf(f1,"%c",ch);  fprintf(f1,"\n");
}

horz_skip(num) /* this is to obtain required blank space */
int num;
{
	int i;
	for(i=0;i<num;i++)fprintf(f1," ");
}


/*   Code is defined for Internatinlization  */
init_date_temp_var()
{
nd_temp_date.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
date_convert.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;
}


fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);
nd_temp_date.arr[nd_temp_date.len]='\0';

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}

get_local_date()
{


	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;

	
	BEGIN
	  
       	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);

		IF :time_flag = 1 THEN
		   :nd_loc_date := to_char(t_date,'DD/MM/YYYY HH24:MI');
		   :time_flag := 0;
		ELSE
	       :nd_loc_date := to_char(t_date,'DD/MM/YYYY');
		END IF;
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ,\
 t_date ) ; IF :time_flag = 1 THEN :nd_loc_date := to_char ( t_date , 'DD/MM/Y\
YYY HH24:MI' ) ; :time_flag := 0 ; ELSE :nd_loc_date := to_char ( t_date , 'DD\
/MM/YYYY' ) ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )374;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_language_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&time_flag;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[3] = (unsigned int  )23;
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



		nd_loc_date.arr[nd_loc_date.len]='\0';		     

		if (OERROR)
		disp_message(ERR_MESG,"Date conversion failed...\n");
        //err_mesg("SELECTING Date failed",0,"");

}

fetch_legend_value()
{
	
	int i=0;
	/* EXEC SQL EXECUTE
	BEGIN	      
  	   sm_populate_report_legend.fetch_legend(:nd_facility_id,:p_language_id,'RDRCLEXM.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin sm_populate_report_legend . fetch_legend ( :nd_facilit\
y_id , :p_language_id , 'RDRCLEXM.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )405;
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
 sqlstm.sqhstv[1] = (         void  *)&p_language_id;
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





	for (i=1; i<=100; i++)
	{

	l_translated_value.arr[0]		= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN
       :l_translated_value := GET_LEGEND(LTRIM(RTRIM('RDRCLEXM.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
DRCLEXM.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )428;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )202;
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

	//disp_message(ERR_MESG,l_translated_value.arr);

	strcpy(loc_legend[i],l_translated_value.arr);

	}

}


/*---------------------------------------------------------------------------*/

#undef DEBUG
#undef NODATAFOUND
#undef OERROR
#undef MAX_LINES
#undef VER
#undef REP_WIDTH
#undef REP_TITLE