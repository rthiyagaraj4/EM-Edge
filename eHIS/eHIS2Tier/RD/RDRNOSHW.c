
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
           char  filnam[36];
};
static const struct sqlcxp sqlfpn =
{
    35,
    "d:\\work\\proc\\5\\rdrnoshw\\rdrnoshw.pc"
};


static unsigned long sqlctx = 1933443085;


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
            void  *sqhstv[14];
   unsigned int   sqhstl[14];
            int   sqhsts[14];
            void  *sqindv[14];
            int   sqinds[14];
   unsigned int   sqharm[14];
   unsigned int   *sqharc[14];
   unsigned short  sqadto[14];
   unsigned short  sqtdso[14];
} sqlstm = {10,14};

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

 static const char *sq0006 = 
"nd A.REF_SOURCE_TYPE=NVL(:b7,A.REF_SOURCE_TYPE)) and A.REF_SOURCE_CODE betwe\
en NVL(:b8,A.REF_SOURCE_CODE) and NVL(:b9,A.REF_SOURCE_CODE)) and A.APPT_STATU\
S in ('1','2')) order by TRUNC(A.APPT_DATE),A.CLINIC_CODE,to_char(A.APPT_START\
_TIME,'HH24:MI')            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,178,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,212,0,0,0,0,0,1,0,
51,0,0,3,248,0,4,254,0,0,12,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
114,0,0,4,134,0,2,304,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
141,0,0,5,158,0,4,340,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
176,0,0,6,1284,0,9,427,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
231,0,0,6,0,0,13,557,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
302,0,0,7,95,0,4,640,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
329,0,0,8,88,0,4,658,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
356,0,0,9,124,0,4,674,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
387,0,0,10,125,0,4,693,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
418,0,0,11,122,0,4,713,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
449,0,0,12,322,0,6,984,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,3,3,0,0,2,9,0,0,
480,0,0,13,112,0,6,1021,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
503,0,0,14,136,0,6,1034,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/******************************************************************************/
/* OCS MEDICOM VER 1.0                                                        */
/******************************************************************************/
/* PROGRAM NAME     : rdrnoshw.pc                                             */
/* AUTHOR           : VASANT KUMAR                                            */
/* DATE WRITTEN     : 08-MAY-1993                                             */
/*                                                                            */
/* DATE MODIFIED    : 12-MAR-1996                                             */
/*                                                                            */
/* CALLED FROM      : rdrnoshw.inp                                            */
/*                                                                            */
/* INPUT PARAMETERS : USER_ID/PASSWORD                                        */
/*                  : SESSION_ID                                              */
/*                  : PGM_DATE                                                */
/*                  : APPOINTMENT FROM AND TO DATE                            */
/*                  : APPOINTMENT FROM AND TO PHYSICIAN                       */
/*                  : APPOINTMENT FROM AND TO CLINIC                          */
/*                                                                            */
/* TABLES ACCESSED  : SY_PROG_PARAM                                           */
/*                  : SY_ACC_ENTITY                                           */
/*                  : RD_APPT                                                 */
/*                  : SY_PHYSICIAN_MAST                                       */
/*                  : RD_CLINIC                                               */
/*                                                                            */
/* OUTPUT FILE      : rdrnoshw.lis                                            */
/*                                                                            */
/* FUNCTION         : This program prints a Patient Appointment List          */
/*                    For a given SY_PROG_PARAM parameters                    */
/*                                                                            */
/* VERSION          : 1.10.01                                                 */
/* MODIFICATIONS    :                                                         */
/* VERSION          : eHIS 4.1                                                */
/*                                                                            */
/* AUTHOR           : Rajanish Nambiar                                        */
/*                                                                            */
/* DATE MODIFIED    : 06/Aug/2003                                             */
/*                                                                            */
/******************************************************************************/

#include <stdio.h>
#include <gl.h>
#include <math.h>
#include <string.h>

#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define MAX_LINES 41
#define REP_WIDTH 130
#define REP_TITLE "LIST OF APPOINTMENTS FOR NO SHOWS"
#define VER  "VER : 10.2\n"
#define ESC     0x1B

/*
#define DEBUG1
*/
/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR nd_facility_id		   [3],		
		nd_pgm_id    		   [9],		
		uid_pwd		           [122],	/oLength changed from 91 to 122 o/	
		nd_session_id		   [16],
		nd_pgm_date			   [13],	/o Input Parameters       o/

        h_acc_entity_name      [305],	
		h_user                 [31],	//size increased by rvN 0n 26/Aug/2003
		h_sysdate              [17],	/o SY_ACC_ENTITY header access o/

        nd_fr_appt_date        [11],  /o SY_PROG_PARAM Parameters o/
        nd_to_appt_date        [11],
		nd_fr_section_code     [7], 
		nd_to_section_code     [7], 
		nd_fr_clinic_code      [5], 
		nd_to_clinic_code      [5],
		nd_wing_code           [3],
        nd_source_type         [11],
        nd_fr_source_code      [12],
        nd_to_source_code      [13],
		h_wing_desc            [95] , 

        h_physician_name       [95],   /o Desc for the Code access o/
		h_clinic_desc          [95],
		h_section_desc         [90],
		h_exam_desc            [125],

		h_appt_date            [11],
		th_app_date            [11],
		h_appt_time            [6],
		h_section_code         [5],
        h_clinic_code          [5],    /o Cursor Fieldo/
        h_exam_code            [11],	
		h_physician_id         [16],	
		h_durn_time            [6],
		h_appt_fr_time         [6],
        h_source_type          [6],
        h_fr_source_code       [6],
        h_to_source_code       [6],
		p_language_id		   [3],
		date_convert		   [21],
		nd_temp_date		   [21],
		nd_loc_date            [21],
		l_translated_value	   [200], 
		h_appt_to_time         [6],
		h_appt_ref_num         [9],
		h_patient_id           [21],	//size increased by rvN 0n 26/Aug/2003
		h_res_tel_num          [19],
		h_con_tel_num          [19],
		h_short_name_loc_lang  [61],	//size increased by rvN 0n 26/Aug/2003
		h_short_name           [61],	//size increased by rvN 0n 26/Aug/2003

		t_clinic_code          [5],     /o Temperory var for Break o/
		t_appt_date            [11],    /o Control                 o/
		t_section_code         [5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[9]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[122]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[13]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[305]; } h_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } h_user;

struct { unsigned short len; unsigned char arr[17]; } h_sysdate;

struct { unsigned short len; unsigned char arr[11]; } nd_fr_appt_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_appt_date;

struct { unsigned short len; unsigned char arr[7]; } nd_fr_section_code;

struct { unsigned short len; unsigned char arr[7]; } nd_to_section_code;

struct { unsigned short len; unsigned char arr[5]; } nd_fr_clinic_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_clinic_code;

struct { unsigned short len; unsigned char arr[3]; } nd_wing_code;

struct { unsigned short len; unsigned char arr[11]; } nd_source_type;

struct { unsigned short len; unsigned char arr[12]; } nd_fr_source_code;

struct { unsigned short len; unsigned char arr[13]; } nd_to_source_code;

struct { unsigned short len; unsigned char arr[95]; } h_wing_desc;

struct { unsigned short len; unsigned char arr[95]; } h_physician_name;

struct { unsigned short len; unsigned char arr[95]; } h_clinic_desc;

struct { unsigned short len; unsigned char arr[90]; } h_section_desc;

struct { unsigned short len; unsigned char arr[125]; } h_exam_desc;

struct { unsigned short len; unsigned char arr[11]; } h_appt_date;

struct { unsigned short len; unsigned char arr[11]; } th_app_date;

struct { unsigned short len; unsigned char arr[6]; } h_appt_time;

struct { unsigned short len; unsigned char arr[5]; } h_section_code;

struct { unsigned short len; unsigned char arr[5]; } h_clinic_code;

struct { unsigned short len; unsigned char arr[11]; } h_exam_code;

struct { unsigned short len; unsigned char arr[16]; } h_physician_id;

struct { unsigned short len; unsigned char arr[6]; } h_durn_time;

struct { unsigned short len; unsigned char arr[6]; } h_appt_fr_time;

struct { unsigned short len; unsigned char arr[6]; } h_source_type;

struct { unsigned short len; unsigned char arr[6]; } h_fr_source_code;

struct { unsigned short len; unsigned char arr[6]; } h_to_source_code;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[200]; } l_translated_value;

struct { unsigned short len; unsigned char arr[6]; } h_appt_to_time;

struct { unsigned short len; unsigned char arr[9]; } h_appt_ref_num;

struct { unsigned short len; unsigned char arr[21]; } h_patient_id;

struct { unsigned short len; unsigned char arr[19]; } h_res_tel_num;

struct { unsigned short len; unsigned char arr[19]; } h_con_tel_num;

struct { unsigned short len; unsigned char arr[61]; } h_short_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } h_short_name;

struct { unsigned short len; unsigned char arr[5]; } t_clinic_code;

struct { unsigned short len; unsigned char arr[11]; } t_appt_date;

struct { unsigned short len; unsigned char arr[5]; } t_section_code;

		int i=0;
		int time_flag = 0;
		char loc_legend[999][200];

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




#include <winproc.h>
char string_var[100];
char filename[150];

int line_no = 0;
int page_no = 0;
int first   = 0;

char p_line[133] = "-----------------------------------------------------------------------------------------------------------------------------------\n";

FILE *f1;

void proc_main(argc, argv)
int argc;
char *argv[];
{
	void get_params(),
		 get_header_dtls(),
		 dclr_appt_cur(),
		 do_report();

	/*printf ( "RDRNOSHW : Program Started.\n\n" );      */

	if ( argc != 6 ) 
		{
		   int i = 0;

		   disp_message(ERR_MESG,"Usage oaraplst uid/passwd session_id pgm_date\n");
		   disp_message(ERR_MESG,"Exiting due to Mismatch of input parameters\007\007\007");
		   sprintf(string_var,"No of Parameters is <%d>\n",argc); 
		   disp_message(ERR_MESG,string_var);
		   disp_message(ERR_MESG,"The following are the parameters :-\n");

		   for ( i = 0; i < argc; i++ ) 
			sprintf (string_var, "argv [ %d ] ---> <%s>\n", i, argv [i] );
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
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

  

	if ( OERROR ) 
    {
       disp_message (ERR_MESG, "USERID/PASSWORD failed to Connect\n" );
       proc_exit();
    }
   	
	set_meduser_role();	
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;
	
	strcpy(filename,WORKING_DIR);
	//strcat(filename, "rdrnoshw.lis");
	strcat(filename,OUTPUT_FILE_NAME);
	if ( ( f1 = fopen (filename, "w" ) ) == NULL ) 
	{
		disp_message (ERR_MESG, ".... Error opening output file ....\n" );
		proc_exit();
	} 
	  
 	fprintf(f1,"%c&k4S",ESC);
	fprintf(f1,"%c&l1O",ESC); 
	fprintf(f1,"%c&a5L",ESC);/*for landscape printing by rvNambiar on 26/Aug/2003 */

	get_params();
	fetch_legend_value();
	
	get_header_dtls();
	
	dclr_appt_cur();
	
	do_report();

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



/*-------------- Check for any error and No data found ----------------------*/
     if ( OERROR ) 
       {
          disp_message(ERR_MESG, "COMMIT failed\n" );
          proc_exit();
       }
/*-------------------------- End of Error Check ------------------------------*/
     fclose (f1);
  /*   printf ( "RDRNOSHW : Program Ended.\n\n" );     */
     return;
  }   


/*	**********************	Sub Program'S	*********************	*/


/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                */
void get_params()
  {
      nd_to_section_code.len       = 0;
      nd_fr_section_code.len       = 0;
      nd_to_clinic_code.len        = 0;
      nd_fr_clinic_code.len        = 0;
      nd_fr_appt_date.len          = 0;
      nd_to_appt_date.len          = 0;
      nd_source_type.len           = 0;
      nd_fr_source_code.len        = 0;
      nd_to_source_code.len        = 0;
      nd_to_section_code.arr [ nd_to_section_code.len ]   = '\0';
      nd_fr_section_code.arr [ nd_fr_section_code.len ]   = '\0';
      nd_to_clinic_code.arr [ nd_to_clinic_code.len ]     = '\0';
      nd_fr_clinic_code.arr [ nd_fr_clinic_code.len ]     = '\0';
      nd_fr_appt_date.arr [ nd_fr_appt_date.len ]         = '\0';
      nd_to_appt_date.arr [ nd_to_appt_date.len ]         = '\0';
      nd_source_type.arr  [ nd_source_type.len ]          = '\0';
      nd_fr_source_code.arr[nd_fr_source_code.len]        = '\0';
      nd_to_source_code.arr[nd_to_source_code.len]        = '\0';

   /* read the parameter record */
      /* EXEC SQL SELECT PARAM1,
	         	      PARAM2,
				      PARAM3,
				      PARAM4,
				      PARAM5,
					  PARAM6,
                             PARAM8,
                             PARAM9,
                             PARAM10
	       INTO   :nd_wing_code,
		          :nd_fr_section_code,
			      :nd_fr_clinic_code,
			      :nd_to_clinic_code,
	              :nd_fr_appt_date,
			      :nd_to_appt_date,
                    :nd_source_type,
                    :nd_fr_source_code,
                    :nd_to_source_code
           FROM   SY_PROG_PARAM
	       WHERE  operating_facility_id = :nd_facility_id
		   AND    PGM_ID = 'RDRNOSHW'
	       AND    SESSION_ID = TO_NUMBER ( :nd_session_id )
	       AND    PGM_DATE   = :nd_pgm_date; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 12;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,\
PARAM8 ,PARAM9 ,PARAM10 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  from SY_PROG\
_PARAM where (((operating_facility_id=:b9 and PGM_ID='RDRNOSHW') and SESSION_I\
D=TO_NUMBER(:b10)) and PGM_DATE=:b11)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )51;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
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
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_fr_clinic_code;
      sqlstm.sqhstl[2] = (unsigned int  )7;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&nd_to_clinic_code;
      sqlstm.sqhstl[3] = (unsigned int  )7;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&nd_fr_appt_date;
      sqlstm.sqhstl[4] = (unsigned int  )13;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&nd_to_appt_date;
      sqlstm.sqhstl[5] = (unsigned int  )13;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&nd_source_type;
      sqlstm.sqhstl[6] = (unsigned int  )13;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&nd_fr_source_code;
      sqlstm.sqhstl[7] = (unsigned int  )14;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&nd_to_source_code;
      sqlstm.sqhstl[8] = (unsigned int  )15;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&nd_facility_id;
      sqlstm.sqhstl[9] = (unsigned int  )5;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&nd_session_id;
      sqlstm.sqhstl[10] = (unsigned int  )18;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&nd_pgm_date;
      sqlstm.sqhstl[11] = (unsigned int  )15;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
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

      if ( OERROR ) 
	{
           disp_message(ERR_MESG, "SELECT failed on SY_PROG_PARAM\n" );
           proc_exit();
        }

      if (NO_DATA_FOUND) 
	{
           disp_message ( ERR_MESG,"No Data Found in the SY_PROG_PARAM\n" );
           proc_exit();
        }

/*-------------------------- End of Error Check ------------------------------*/
      nd_wing_code.arr [ nd_wing_code.len ]               = '\0';
      nd_fr_section_code.arr [ nd_fr_section_code.len ]   = '\0';
      nd_to_clinic_code.arr [ nd_to_clinic_code.len ]     = '\0';
      nd_fr_clinic_code.arr [ nd_fr_clinic_code.len ]     = '\0';
      nd_fr_appt_date.arr [ nd_fr_appt_date.len ]         = '\0';
      nd_to_appt_date.arr [ nd_to_appt_date.len ]         = '\0';
      nd_source_type.arr  [ nd_source_type.len ]          = '\0';
      nd_fr_source_code.arr[nd_fr_source_code.len]        = '\0';
      nd_to_source_code.arr[nd_to_source_code.len]        = '\0';

  /* delete the parameter record */
      /* EXEC SQL DELETE SY_PROG_PARAM
	       WHERE  operating_facility_id = :nd_facility_id
		   AND    PGM_ID = 'RDRNOSHW'
	       AND    SESSION_ID = TO_NUMBER ( :nd_session_id )
	       AND    PGM_DATE   = :nd_pgm_date; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 12;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((operating_facility\
_id=:b0 and PGM_ID='RDRNOSHW') and SESSION_ID=TO_NUMBER(:b1)) and PGM_DATE=:b2\
)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )114;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
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

      if (OERROR) 
	{
           disp_message(ERR_MESG,"DELETE failed on SY_PROG_PARAM\n");
           proc_exit();
        }

      if (NO_DATA_FOUND)
	{
           disp_message(ERR_MESG,"No Data Found in the SY_PROG_PARAM\n");
           proc_exit();
        }

/*------------------------- End of Error Check -------------------------------*/

      return;
  }
 
/*--------------------------- get the header details -------------------------*/
void get_header_dtls()
  {
     h_acc_entity_name.len    = 0;
     h_user.len               = 0;
     h_sysdate.len            = 0;

     h_acc_entity_name.arr [ h_acc_entity_name.len ]   = '\0';
     h_user.arr [ h_user.len ]                         = '\0';
     h_sysdate.arr [ h_sysdate.len ]                   = '\0';

     /* EXEC SQL SELECT ACC_ENTITY_NAME, 
	         	     USER,
				     TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
		      INTO   :h_acc_entity_name,
			 	     :h_user,
				     :h_sysdate
              FROM   SY_ACC_ENTITY_LANG_VW
			  WHERE language_id=:p_language_id and  acc_entity_id = :nd_facility_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYY\
Y HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (language_id=:b\
3 and acc_entity_id=:b4)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )141;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&h_acc_entity_name;
     sqlstm.sqhstl[0] = (unsigned int  )307;
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
     sqlstm.sqhstv[3] = (         void  *)&p_language_id;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
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

     if (OERROR)
       {
          disp_message(ERR_MESG,"SELECT failed on SY_ACC_ENTITY\n");
          proc_exit();
       }

     if (NO_DATA_FOUND)
       {
          disp_message(ERR_MESG,"No Data Found in the SY_ACC_ENTITY\n");
          proc_exit();
       }

/*------------------------- End of Error Check -------------------------------*/

     h_acc_entity_name.arr [ h_acc_entity_name.len ]   = '\0';
     h_user.arr [ h_user.len ]                         = '\0';
     h_sysdate.arr [ h_sysdate.len ]                   = '\0';

     return;
  }
/*------------------------- End of Header access -----------------------------*/

/*------------------------- Appointments Cursor ------------------------------*/
void dclr_appt_cur()
  {

     /* EXEC SQL DECLARE  APPT_CUR CURSOR FOR
              SELECT TO_CHAR(A.APPT_DATE,'DD/MM/YYYY'),
				     A.SECTION_CODE,
		             A.CLINIC_CODE,
                     A.EXAM_CODE,
		             A.REF_PHYS_ID, //A.REQ_PHYS_ID,
                     TO_CHAR(TO_DATE(TO_NUMBER(TO_CHAR(A.APPT_END_TIME,'SSSSS')) -
                     TO_NUMBER(TO_CHAR(A.APPT_START_TIME,'SSSSS')),'SSSSS'),'HH24:MI'),
				     TO_CHAR(A.APPT_START_TIME,'HH24:MI'),
				     TO_CHAR(A.APPT_END_TIME,'HH24:MI'),
				     A.APPT_REF_NUM,
				     A.PATIENT_ID,
				     A.RES_TELEPHONE_NUM,
				     A.OTHER_CONTACT_NUM,
				     SUBSTR(A.SHORT_NAME_LOC_LANG,1,16),
				     A.SHORT_NAME
              FROM   RD_APPT A , RD_CLINIC B
              WHERE  A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
			  AND    A.SECTION_CODE = B.SECTION_CODE 
			  AND    A.CLINIC_CODE  = B.CLINIC_CODE
			  AND    A.OPERATING_FACILITY_ID = :nd_facility_id
			  AND    TO_DATE(TO_CHAR(APPT_DATE,'DD/MM/YYYY')||TO_CHAR(APPT_END_TIME,'HH24:MI'), 'DD/MM/YYYY HH24:MI')  <= SYSDATE
				AND    TO_DATE(TO_CHAR(APPT_DATE,'DD/MM/YYYY')||TO_CHAR(APPT_END_TIME,'HH24:MI'), 'DD/MM/YYYY HH24:MI') 
				BETWEEN TO_DATE(:nd_fr_appt_date||' 00:00', 'DD/MM/YYYY HH24:MI')
				AND     TO_DATE(:nd_to_appt_date||' 23:59', 'DD/MM/YYYY HH24:MI')
/o			  AND    TRUNC(A.APPT_DATE) BETWEEN 
					 TO_DATE(:nd_fr_appt_date, 'DD/MM/YYYY')
		             AND 	 TO_DATE(:nd_to_appt_date, 'DD/MM/YYYY')o/
              AND    A.SECTION_CODE = :nd_fr_section_code
			  AND    B.WING_CODE    = :nd_wing_code 
              AND    A.CLINIC_CODE BETWEEN 
			         :nd_fr_clinic_code  AND :nd_to_clinic_code
              AND    A.REF_SOURCE_TYPE = NVL(:nd_source_type,A.REF_SOURCE_TYPE)
              AND    A.REF_SOURCE_CODE BETWEEN NVL(:nd_fr_source_code,A.REF_SOURCE_CODE ) AND NVL(:nd_to_source_code,A.REF_SOURCE_CODE)
              AND    A.APPT_STATUS IN ('1', '2')
               ORDER BY TRUNC(A.APPT_DATE), 
     	       A.CLINIC_CODE,
		       to_char(A.APPT_START_TIME, 'HH24:MI'); */ 

			   

/*-------------- Check for any error and No data found ----------------------*/

     if (OERROR) 
       {
          disp_message ( ERR_MESG,"SELECT failed on RD_APPT\n" );
          proc_exit();
       }

/*------------------------- End of Error Check -------------------------------*/

     /* EXEC SQL OPEN APPT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 12;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlbuft((void **)0, 
       "select TO_CHAR(A.APPT_DATE,'DD/MM/YYYY') ,A.SECTION_CODE ,A.CLINIC_C\
ODE ,A.EXAM_CODE ,A.REF_PHYS_ID ,TO_CHAR(TO_DATE((TO_NUMBER(TO_CHAR(A.APPT_E\
ND_TIME,'SSSSS'))-TO_NUMBER(TO_CHAR(A.APPT_START_TIME,'SSSSS'))),'SSSSS'),'H\
H24:MI') ,TO_CHAR(A.APPT_START_TIME,'HH24:MI') ,TO_CHAR(A.APPT_END_TIME,'HH2\
4:MI') ,A.APPT_REF_NUM ,A.PATIENT_ID ,A.RES_TELEPHONE_NUM ,A.OTHER_CONTACT_N\
UM ,SUBSTR(A.SHORT_NAME_LOC_LANG,1,16) ,A.SHORT_NAME  from RD_APPT A ,RD_CLI\
NIC B where (((((((((((A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID and A\
.SECTION_CODE=B.SECTION_CODE) and A.CLINIC_CODE=B.CLINIC_CODE) and A.OPERATI\
NG_FACILITY_ID=:b0) and TO_DATE((TO_CHAR(APPT_DATE,'DD/MM/YYYY')||TO_CHAR(AP\
PT_END_TIME,'HH24:MI')),'DD/MM/YYYY HH24:MI')<=SYSDATE) and TO_DATE((TO_CHAR\
(APPT_DATE,'DD/MM/YYYY')||TO_CHAR(APPT_END_TIME,'HH24:MI')),'DD/MM/YYYY HH24\
:MI') between TO_DATE((:b1||' 00:00'),'DD/MM/YYYY HH24:MI') and TO_DATE((:b2\
||' 23:59'),'DD/MM/YYYY HH24:MI')) and A.SECTION_CODE=:b3) and B.WING_CODE=:\
b4) and A.CLINIC_CODE between :b5 and :b6) a");
     sqlstm.stmt = sq0006;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )176;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_fr_appt_date;
     sqlstm.sqhstl[1] = (unsigned int  )13;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_to_appt_date;
     sqlstm.sqhstl[2] = (unsigned int  )13;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_fr_section_code;
     sqlstm.sqhstl[3] = (unsigned int  )9;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_wing_code;
     sqlstm.sqhstl[4] = (unsigned int  )5;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_fr_clinic_code;
     sqlstm.sqhstl[5] = (unsigned int  )7;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_to_clinic_code;
     sqlstm.sqhstl[6] = (unsigned int  )7;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_source_type;
     sqlstm.sqhstl[7] = (unsigned int  )13;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_fr_source_code;
     sqlstm.sqhstl[8] = (unsigned int  )14;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_to_source_code;
     sqlstm.sqhstl[9] = (unsigned int  )15;
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



/*-------------- Check for any error and No data found ----------------------*/

     if (OERROR)
       {
          disp_message (ERR_MESG, "OPEN failed on APPT_CUR\n" );
          proc_exit();
       }

/*------------------------- End of Error Check -------------------------------*/

     return;
/*------------------------- End of Appt Cursor -------------------------------*/
  }

/*------------------------- Fetching from Appt Cursor ------------------------*/
void do_report()
  {
     void print_page_header(),
          print_rep_header(),
          get_section_desc(),
		  get_physician_name (),
          get_clinic_desc(),
          print_hdr(),
          print_col_heading(),
          print_hdr_detl();

     int fetch_appt_cur();
     int still_rec_left, posted = 0;

     print_rep_header(); /* once for the report */

     line_no = 0;
     first = 1;

  /*---------------------- read the first cursor record ----------------------*/

     while ( fetch_appt_cur () )
       {
	  if (first)
	    {
               print_page_header();
	       print_hdr ();
	       print_col_heading ();

               strcpy(t_appt_date.arr, h_appt_date.arr);
               strcpy(t_section_code.arr, h_section_code.arr);
               strcpy(t_clinic_code.arr, h_clinic_code.arr);

	       first = 0;
            }
/*	       fprintf(f1,"The appointmet date is: %s \n and h_appt_date is:  %s\n",t_appt_date.arr, h_appt_date.arr ) ;*/
          if ( strcmp ( t_appt_date.arr, h_appt_date.arr ) != 0 ||
	       strcmp ( t_section_code.arr, h_section_code.arr ) != 0 ||
	       strcmp ( t_clinic_code.arr, h_clinic_code.arr ) != 0 )
            {
               strcpy(t_appt_date.arr, h_appt_date.arr);
               strcpy(t_section_code.arr, h_section_code.arr);
               strcpy(t_clinic_code.arr, h_clinic_code.arr);


	       fprintf ( f1, "\f" );

               print_page_header();
	       print_hdr ();
	       print_col_heading ();
               print_hdr_detl();
            }
          else
	    if ( line_no + 6 > MAX_LINES )
	      {
	         fprintf ( f1, "\f" );

                 print_page_header();
	         print_hdr ();
	         print_col_heading ();
                 print_hdr_detl();
              } 
            else 
              print_hdr_detl();
          
          line_no += 2;
       }    
     print_end_of_rep();
  }
/*--------------------------- End of Report function -------------------------*/

/* fetches the next record from APPT_CUR     */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_appt_cur()
  {
     h_appt_date.len                    = 0;
     h_section_code.len                 = 0;
     h_clinic_code.len                  = 0;
     h_exam_code.len                    = 0;
     h_physician_id.len                 = 0;
     h_appt_time.len                    = 0;
     h_appt_fr_time.len                 = 0;
     h_appt_to_time.len                 = 0;
     h_source_type.len                  = 0;
     h_fr_source_code.len                = 0;
     h_to_source_code.len               = 0;
     h_appt_ref_num.len                 = 0;
     h_patient_id.len                   = 0;
     h_res_tel_num.len                  = 0;
     h_con_tel_num.len                  = 0;
     h_short_name_loc_lang.len          = 0;
     h_short_name.len                   = 0;


     h_appt_date.arr[h_appt_date.len]                       = '\0';
     h_section_code.arr[h_section_code.len]                 = '\0';
     h_clinic_code.arr[h_clinic_code.len]                   = '\0';
     h_exam_code.arr[h_exam_code.len]                       = '\0';
     h_physician_id.arr[h_physician_id.len]                 = '\0';
     h_appt_time.arr[h_appt_time.len]                       = '\0';
     h_appt_fr_time.arr[h_appt_fr_time.len]                 = '\0';
     h_appt_to_time.arr[h_appt_to_time.len]                 = '\0';
     h_source_type.arr [h_source_type.len]                  = '\0';
     h_fr_source_code.arr[h_fr_source_code.len]               = '\0';
     h_to_source_code.arr[h_to_source_code.len]             = '\0';
     h_appt_ref_num.arr[h_appt_ref_num.len]                 = '\0';
     h_patient_id.arr[h_patient_id.len]                     = '\0';
     h_res_tel_num.arr[h_res_tel_num.len]                   = '\0';
     h_con_tel_num.arr[h_con_tel_num.len]                   = '\0';
     h_short_name_loc_lang.arr[h_short_name_loc_lang.len]   = '\0';
     h_short_name.arr[h_short_name.len]                     = '\0';

     /* EXEC SQL FETCH APPT_CUR INTO
                 :h_appt_date,
			     :h_section_code,
	             :h_clinic_code,
                 :h_exam_code,
			     :h_physician_id,
                 :h_appt_time,
			     :h_appt_fr_time,
			     :h_appt_to_time,
			     :h_appt_ref_num,
			     :h_patient_id,
			     :h_res_tel_num,
			     :h_con_tel_num,
			     :h_short_name_loc_lang,
			     :h_short_name; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )231;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&h_appt_date;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&h_section_code;
     sqlstm.sqhstl[1] = (unsigned int  )7;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&h_clinic_code;
     sqlstm.sqhstl[2] = (unsigned int  )7;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&h_exam_code;
     sqlstm.sqhstl[3] = (unsigned int  )13;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&h_physician_id;
     sqlstm.sqhstl[4] = (unsigned int  )18;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&h_appt_time;
     sqlstm.sqhstl[5] = (unsigned int  )8;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&h_appt_fr_time;
     sqlstm.sqhstl[6] = (unsigned int  )8;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&h_appt_to_time;
     sqlstm.sqhstl[7] = (unsigned int  )8;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&h_appt_ref_num;
     sqlstm.sqhstl[8] = (unsigned int  )11;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&h_patient_id;
     sqlstm.sqhstl[9] = (unsigned int  )23;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&h_res_tel_num;
     sqlstm.sqhstl[10] = (unsigned int  )21;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&h_con_tel_num;
     sqlstm.sqhstl[11] = (unsigned int  )21;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&h_short_name_loc_lang;
     sqlstm.sqhstl[12] = (unsigned int  )63;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&h_short_name;
     sqlstm.sqhstl[13] = (unsigned int  )63;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
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
          disp_message(ORA_MESG,"FETCH failed on APPT_CUR\n");
          proc_exit();
       }

     if (NO_DATA_FOUND)
       return 0;

     h_appt_date.arr[h_appt_date.len]                       = '\0';
     h_section_code.arr[h_section_code.len]                 = '\0';
     h_clinic_code.arr[h_clinic_code.len]                   = '\0';
     h_exam_code.arr[h_exam_code.len]                       = '\0';
     h_physician_id.arr[h_physician_id.len]                 = '\0';
     h_appt_time.arr[h_appt_time.len]                       = '\0';
     h_appt_fr_time.arr[h_appt_fr_time.len]                 = '\0';
     h_source_type.arr [h_source_type.len]                  = '\0';
     h_fr_source_code.arr[h_fr_source_code.len]               = '\0';
     h_to_source_code.arr[h_to_source_code.len]             = '\0';
     h_appt_to_time.arr[h_appt_to_time.len]                 = '\0';
     h_appt_ref_num.arr[h_appt_ref_num.len]                 = '\0';
     h_patient_id.arr[h_patient_id.len]                     = '\0';
     h_res_tel_num.arr[h_res_tel_num.len]                   = '\0';
     h_con_tel_num.arr[h_con_tel_num.len]                   = '\0';
     h_short_name_loc_lang.arr[h_short_name_loc_lang.len]   = '\0';
     h_short_name.arr[h_short_name.len]                     = '\0';

     return 1;
  }
/*--------------------------- End of Appointment Fetch ---------------------*/      

/* to print the detailed record with to horizontal summeries */
void print_hdr_detl()
{
	fprintf(f1,"%5s-",h_appt_fr_time.arr);
    fprintf(f1,"%5s     ",h_appt_to_time.arr);
    fprintf(f1,"%5s   ",h_appt_time.arr);
    fprintf(f1,"%8s  " , h_appt_ref_num.arr);

    fprintf(f1,"%-20s  ",h_patient_id.arr);
	/*fprintf(f1,"%-16s ", h_short_name_loc_lang.arr); */
	fprintf(f1,"%-60.60s  ", h_short_name.arr);
    
    get_physician_name ();
	fprintf(f1,"\n");

    horz_skip(16);
	fprintf(f1,"%-15s  %-30s", h_physician_id.arr, h_physician_name.arr);
	horz_skip(5);
    fprintf(f1,"%-18s ", h_res_tel_num.arr);
    fprintf(f1,"%-18s\n", h_con_tel_num.arr);

    get_exam_desc ();
	//fprintf ( f1, "EXAM : %-11s  %-40s\n", h_exam_code.arr, h_exam_desc.arr );
	fprintf ( f1, "%-4s : %-11s  %-40s\n",loc_legend[29], h_exam_code.arr, h_exam_desc.arr );
	print_line('_',REP_WIDTH);
    line_no += 4;
}

/*------ Gets the Section Description  ---------------------------------------*/
void get_section_desc()
{
   h_section_desc.len = 0;

   h_section_desc.arr[h_section_desc.len] = '\0';

   /* EXEC SQL SELECT LONG_DESC
            INTO   :h_section_desc  
	    FROM   RD_SECTION_LANG_VW
	    WHERE language_id=:p_language_id and  SECTION_CODE = :h_section_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from RD_SECTION_LANG_VW where (\
language_id=:b1 and SECTION_CODE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )302;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&h_section_desc;
   sqlstm.sqhstl[0] = (unsigned int  )92;
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
   sqlstm.sqhstv[2] = (         void  *)&h_section_code;
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

	

   h_section_desc.arr[h_section_desc.len] = '\0';

   return;
}
/*-------------------- End of Section Description  ---------------------------*/
 
/*-------------------- Get Exam Description ----------------------------------*/
get_exam_desc ()
  {
     h_exam_desc.len = 0;

     h_exam_desc.arr [ h_exam_desc.len ] = '\0';

     /* EXEC SQL SELECT LONG_DESC
	      INTO   :h_exam_desc
	      FROM   RD_EXAMINATION
	      WHERE language_id=:p_language_id and   EXAM_CODE = :h_exam_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 14;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select LONG_DESC into :b0  from RD_EXAMINATION where (la\
nguage_id=:b1 and EXAM_CODE=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )329;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&h_exam_desc;
     sqlstm.sqhstl[0] = (unsigned int  )127;
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
     sqlstm.sqhstv[2] = (         void  *)&h_exam_code;
     sqlstm.sqhstl[2] = (unsigned int  )13;
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



     h_exam_desc.arr [ h_exam_desc.len ] = '\0';
  }
/*-------------------------- End of Exam Description ------------------------*/

/*------ gets the Physician name for the physician ID -----------------------*/
void get_physician_name()
{
  h_physician_name.len = 0;

  h_physician_name.arr[h_physician_name.len] = '\0';

   /* EXEC SQL SELECT 	FULL_NAME
            INTO    :h_physician_name
			FROM    SY_PHYSICIAN_MAST_LANG_VW
			WHERE language_id=:p_language_id and   FACILITY_ID  = :nd_facility_id
			AND     PHYSICIAN_ID = :h_physician_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select FULL_NAME into :b0  from SY_PHYSICIAN_MAST_LANG_VW \
where ((language_id=:b1 and FACILITY_ID=:b2) and PHYSICIAN_ID=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )356;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&h_physician_name;
   sqlstm.sqhstl[0] = (unsigned int  )97;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&h_physician_id;
   sqlstm.sqhstl[3] = (unsigned int  )18;
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

	

  h_physician_name.arr[h_physician_name.len] = '\0';

  return;
}
/*-------------------- End of physician Name ---------------------------------*/

/*------ gets the Clinic desc for the Clinic code ----------------------------*/
void get_clinic_desc()
{
  h_clinic_desc.len = 0;

  h_clinic_desc.arr [ h_clinic_desc.len ] = '\0';
  
   /* EXEC SQL SELECT 	LONG_DESC
            INTO    :h_clinic_desc
			FROM    RD_CLINIC_LANG_VW
			WHERE  language_id=:p_language_id and  operating_facility_id = :nd_facility_id
			AND		CLINIC_CODE = :h_clinic_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from RD_CLINIC_LANG_VW where ((\
language_id=:b1 and operating_facility_id=:b2) and CLINIC_CODE=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )387;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&h_clinic_desc;
   sqlstm.sqhstl[0] = (unsigned int  )97;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&h_clinic_code;
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

	

  h_clinic_desc.arr [ h_clinic_desc.len ] = '\0';

  return;
}
/*-------------------- End of clinic Desc ------------------------------------*/


/*------ gets the Wing desc for the Wing code ----------------------------*/
void get_wing_desc()
{
  
  h_wing_desc.arr [0]   = '\0';
  h_wing_desc.len     = 0;

   /* EXEC SQL SELECT 	LONG_DESC
			INTO    :h_wing_desc
			FROM    RD_WINGS_LANG_VW
			WHERE language_id=:p_language_id and   operating_facility_id = :nd_facility_id
			AND		WING_CODE = :nd_wing_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from RD_WINGS_LANG_VW where ((l\
anguage_id=:b1 and operating_facility_id=:b2) and WING_CODE=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )418;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&h_wing_desc;
   sqlstm.sqhstl[0] = (unsigned int  )97;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
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
     char fr_appt_date_desc [11],
	  to_appt_date_desc [11];
     char fr_section_code_desc [8],
          to_section_code_desc [8];
     char fr_clinic_code_desc [8], 
	  to_clinic_code_desc[8];
	  char referral_type_desc[15],
		   fr_referral_code_desc[15],
		   to_referral_code_desc[15];

     if ( strcmp ( nd_fr_section_code.arr, "!!!!" ) == 0 )
       strcpy ( fr_section_code_desc,loc_legend[16]);
     else
       strcpy ( fr_section_code_desc, nd_fr_section_code.arr );

     if ( strcmp ( nd_to_section_code.arr, "~~~~" ) == 0 )
       strcpy ( to_section_code_desc,loc_legend[17]);
     else
       strcpy ( to_section_code_desc, nd_to_section_code.arr );

     if ( strcmp ( nd_fr_clinic_code.arr, "!!!!" ) == 0 )
       strcpy ( fr_clinic_code_desc,loc_legend[16]);
     else strcpy ( fr_clinic_code_desc, nd_fr_clinic_code.arr );

     if ( strcmp ( nd_to_clinic_code.arr, "~~~~" ) == 0 )
       strcpy ( to_clinic_code_desc,loc_legend[17]);
     else
       strcpy ( to_clinic_code_desc, nd_to_clinic_code.arr );

     if ( strcmp ( nd_fr_appt_date.arr, "01/01/1800" ) == 0 )
       strcpy ( fr_appt_date_desc,loc_legend[16]);
     else
       strcpy ( fr_appt_date_desc, nd_fr_appt_date.arr );
    
     if ( strcmp ( nd_to_appt_date.arr, "31/12/4712" ) == 0 )
       strcpy ( to_appt_date_desc,loc_legend[17]);
     else 
       strcpy ( to_appt_date_desc, nd_to_appt_date.arr );

	
	if ( strcmp ( nd_fr_source_code.arr, "!!!!" ) == 0 )
       strcpy ( fr_referral_code_desc,loc_legend[16]);
     else
       strcpy ( fr_referral_code_desc, nd_fr_source_code.arr );

     if ( strcmp ( nd_to_source_code.arr, "~~~~" ) == 0 )
       strcpy ( to_referral_code_desc,loc_legend[17]);
     else
       strcpy ( to_referral_code_desc, nd_to_source_code.arr );

	 if ( strcmp ( nd_source_type.arr, "") == 0)
		strcpy ( referral_type_desc,loc_legend[18]);
	 else if ( strcmp ( nd_source_type.arr, "C") == 0)
        strcpy ( referral_type_desc,loc_legend[19]);
     else if ( strcmp ( nd_source_type.arr, "W") == 0)
        strcpy ( referral_type_desc,loc_legend[20]);
     else if ( strcmp ( nd_source_type.arr, "R") == 0)
        strcpy ( referral_type_desc,loc_legend[21] );
	 else
        strcpy ( referral_type_desc, nd_source_type.arr );
	

     print_page_header();

     fprintf(f1,VER);
     fprintf(f1,"\n\n\n\n");
     fprintf(f1,"        ");
    // fprintf(f1,"INPUT PARAMETERS :\n");
     fprintf(f1,"%-25s  :\n",loc_legend[1]);
     fprintf(f1,"        ");
     fprintf(f1,"__________________\n\n");
     fprintf(f1,"                ");
     fprintf(f1,"%-25s : %s\n",loc_legend[2], fr_appt_date_desc);
     fprintf(f1,"                ");
     fprintf(f1,"%-25s : %s\n",loc_legend[3], to_appt_date_desc);
     fprintf(f1,"\n");
	 fprintf(f1,"                ");
     fprintf(f1,"%-25s : %s\n",loc_legend[4], nd_wing_code.arr);
     fprintf(f1,"\n");
	 fprintf(f1,"                ");
     fprintf(f1,"%-25s : %s\n",loc_legend[5], fr_section_code_desc);
     fprintf(f1,"\n");
     fprintf(f1,"                ");
     fprintf(f1,"%-25s : %s\n",loc_legend[6], fr_clinic_code_desc);
     fprintf(f1,"                ");
     fprintf(f1,"%-25s : %s\n",loc_legend[7], to_clinic_code_desc);
	 fprintf(f1,"\n");
     fprintf(f1,"                ");


	 fprintf(f1,"%-25s : %s\n",loc_legend[8], referral_type_desc);
     fprintf(f1,"\n");
     fprintf(f1,"                ");
     fprintf(f1,"%-25s : %s\n",loc_legend[9], fr_referral_code_desc);
     fprintf(f1,"                ");
     fprintf(f1,"%-25s : %s\n",loc_legend[3], to_referral_code_desc);


     fprintf(f1,"\f");

  }


/* to print page headers the header details */ 
void print_page_header()
{
	int hosp_nm_len, rep_title_len = 10, s1, s2;
	char v_rep_title[200];

	char fr_appt_date_desc[11],
		 to_appt_date_desc[11];

	if ( strcmp ( nd_fr_appt_date.arr, "01/01/1800" ) == 0)
		strcpy ( fr_appt_date_desc,loc_legend[16] );
	else 
		strcpy(fr_appt_date_desc, nd_fr_appt_date.arr);

	if ( strcmp ( nd_to_appt_date.arr, "31/12/4712" ) == 0 )
		strcpy ( to_appt_date_desc,loc_legend[17]);
	else 
		strcpy(to_appt_date_desc, nd_to_appt_date.arr);

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
	strcpy(v_rep_title,REP_TITLE);
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-14);
//	fprintf(f1,"%s",REP_TITLE);
    fprintf(f1,"%s",loc_legend[15]);
	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-10);
//	fprintf(f1,"PAGE :%4d\n",++page_no);
    fprintf(f1,"%-5s:%4d\n",loc_legend[30],++page_no);
    
	fprintf(f1,"                                          ");  
    fprintf(f1,"%20s: %-10s",loc_legend[10], fr_appt_date_desc);
    fprintf(f1," %4s: %-10s",loc_legend[3], to_appt_date_desc);
    fprintf(f1,"\n");
	print_line('_',REP_WIDTH);
    line_no = 5;
  }

/*------------------------------ Name Header ---------------------------------*/
void print_hdr()
  {
     get_clinic_desc();
     get_section_desc();
	 get_wing_desc();
    init_date_temp_var();
	strcpy(date_convert.arr,h_appt_date.arr);
	time_flag = 1;
	fun_change_loc_date();
     //fprintf(f1,"%-20s : %s\n",loc_legend[11],h_appt_date.arr); 
	 fprintf(f1,"%-20s : %s\n",loc_legend[11],date_convert.arr); 
	 fprintf(f1,"%-20s : %-30s\n",loc_legend[12],h_wing_desc.arr);
     fprintf(f1,"%-20s : %-6s %-30s\n",loc_legend[13], h_section_code.arr,h_section_desc.arr);
     fprintf(f1,"%-20s : %-4s   %-30s\n",loc_legend[14],h_clinic_code.arr,h_clinic_desc.arr);

     line_no += 5;
}
/*------------------------------ End Header ----------------------------------*/

/*------------------------------ column Header -------------------------------*/
/* print the heading */
void print_col_heading()
{
    print_line('_',REP_WIDTH);
	//fprintf(f1, "<-- Period -->  Durn    Ref. No.  ");
	fprintf(f1, "%-16s%-8s%-10s",loc_legend[22],loc_legend[23],loc_legend[24]);
    //fprintf(f1,"%-20s  ","Patient No.");
	fprintf(f1,"%-20s  ",loc_legend[25]);
    //fprintf(f1,"Name"); fprintf(f1,"\n");
	fprintf(f1,loc_legend[26]); fprintf(f1,"\n");
	
	horz_skip(16);
	//fprintf(f1,"%s","Doctor Requested");
	  fprintf(f1,"%s",loc_legend[27]);  
    horz_skip(5);
	//fprintf(f1,"                               <-------- Contact Phone(s) ----------->\n");
	fprintf(f1,"%-1s\n",loc_legend[28]);
    print_line('_',REP_WIDTH);
	line_no += 4;
}

/*------------------------------ end Header ----------------------------------*/

print_end_of_rep()
{
    horz_skip(45);
	fprintf(f1,"*****   End of Report   *****");
	fprintf(f1,"%cE",ESC); /*for resetting to default mode by 
							  rvNambiar on 26/Aug/2003 */
} 

/*************************************************************************/

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
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ,\
 t_date ) ; IF :time_flag = 1 THEN :nd_loc_date := to_char ( t_date , 'DD/MM/Y\
YYY HH24:MI' ) ; :time_flag := 0 ; ELSE :nd_loc_date := to_char ( t_date , 'DD\
/MM/YYYY' ) ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )449;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
  	   sm_populate_report_legend.fetch_legend(:nd_facility_id,:p_language_id,'RDRNOSHW.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin sm_populate_report_legend . fetch_legend ( :nd_facilit\
y_id , :p_language_id , 'RDRNOSHW.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )480;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
       :l_translated_value := GET_LEGEND(LTRIM(RTRIM('RDRNOSHW.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
DRNOSHW.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )503;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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




/******************************************************************************/

#undef DEBUG
#undef NODATAFOUND
#undef OERROR
#undef MAX_LINES
#undef VER
