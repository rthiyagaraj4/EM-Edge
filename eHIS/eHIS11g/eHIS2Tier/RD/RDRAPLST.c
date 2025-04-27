
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RD/RDRAPLST.PC"
};


static unsigned int sqlctx = 1288577387;


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
            void  *sqhstv[20];
   unsigned int   sqhstl[20];
            int   sqhsts[20];
            void  *sqindv[20];
            int   sqinds[20];
   unsigned int   sqharm[20];
   unsigned int   *sqharc[20];
   unsigned short  sqadto[20];
   unsigned short  sqtdso[20];
} sqlstm = {12,20};

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
"_CHAR(A.APPT_START_TIME,'HH24:MI')            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,0,0,30,211,0,0,0,0,0,1,0,
20,0,0,0,0,0,27,229,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
51,0,0,3,209,0,4,277,0,0,9,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
102,0,0,4,134,0,2,323,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
129,0,0,5,165,0,4,360,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
164,0,0,6,1070,0,9,448,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
215,0,0,6,0,0,13,596,0,0,20,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
310,0,0,7,82,0,4,651,0,0,2,1,0,1,0,1,9,0,0,2,4,0,0,
333,0,0,8,63,0,4,677,0,0,2,1,0,1,0,1,9,0,0,2,4,0,0,
356,0,0,9,95,0,4,731,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
383,0,0,10,88,0,4,746,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
410,0,0,11,208,0,4,760,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
441,0,0,12,97,0,4,775,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
468,0,0,13,125,0,4,790,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
499,0,0,14,122,0,4,807,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
530,0,0,15,322,0,6,1093,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,3,3,0,0,2,9,0,0,
561,0,0,16,112,0,6,1130,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
584,0,0,17,136,0,6,1143,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/******************************************************************************/
/* OCS MEDICOM VER 1.0                                                        */
/******************************************************************************/
/* PROGRAM NAME     : rdraplst.pc                                             */
/* AUTHOR           : VASANT KUMAR                                            */
/* DATE WRITTEN     : 08-MAY-1993                                             */
/*                                                                            */
/* DATE MODIFIED    : 12-MAR-1996                                             */
/*                                                                            */
/* CALLED FROM      : rdraplst.inp                                            */
/*                                                                            */
/* INPUT PARAMETERS : USER_ID/PASSWORD                                        */
/*                  : SESSION_ID                                              */
/*                  : PGM_DATE                                                */
/*                  : APPOINTMENT FROM AND TO DATE                            */
/*                  : SECTION CODE                                            */
/*                  : APPOINTMENT FROM AND TO CLINIC                          */
/*                                                                            */
/* TABLES ACCESSED  : SY_PROG_PARAM                                           */
/*                  : SY_ACC_ENTITY                                           */
/*                  : RD_APPT                                                 */
/*                  : SY_PHYSICIAN_MAST                                       */
/*                  : RD_CLINIC                                               */
/*                                                                            */
/* OUTPUT FILE      : rdraplst.lis                                            */
/*                                                                            */
/* FUNCTION         : This program prints a Patient Appointment List          */
/*                    For a given SY_PROG_PARAM parameters                    */
/*                                                                            */
/* VERSION          : 1.10.01                                                 */
/* MODIFICATIONS    :                                                         */
/*                                                                            */
/* VERSION			: eHIS 4.1												  */			
/*                                                                            */
/* AUTHOR           : Rajanish Nambiar                                        */
/*                                                                            */
/* DATE MODIFIED    : 26/Aug/2003                                             */
/*                                                                            */
/******************************************************************************/

#include <stdio.h>
#include <gl.h>
#include <rd.h>
#include <math.h>
#include <string.h>

#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND sqlca.sqlcode==1403
#define MAX_LINES 41
#define REP_WIDTH 130
#define REP_TITLE "LIST OF APPOINTMENTS"
#define VER  "VER : 10.2\n"
#define ESC     0x1B

/*
#define DEBUG1
*/
/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR nd_facility_id		   [3],  
		nd_pgm_id    		   [9],  
		uid_pwd				   [122], /o Length increased from 91 to 122 o/
        nd_session_id		   [16],
		nd_pgm_date			   [13], /o Input Parameters       o/

        h_acc_entity_name      [41],  /o SY_ACC_ENTITY header access o/
		h_user                 [21],
		h_sysdate              [17],

        nd_fr_appt_date        [13],  /o SY_PROG_PARAM Parameters o/
        nd_to_appt_date        [13],
		nd_fr_section_code     [7], 
		nd_to_section_code     [7], 
		nd_fr_clinic_code      [5], 
		nd_to_clinic_code      [5], 
        nd_wing_code           [3],
		h_wing_desc            [91] ,  /o Length changed from 31 to 91 for internationalisationo/

        h_physician_name       [91],   /o Desc for the Code access o/
		h_section_desc         [91],   /o Length changed from 31 to 91 for internationalisationo/
		h_clinic_desc          [91],   /o Length changed from 31 to 91 for internationalisationo/
		h_exam_desc            [41],

		h_appt_date            [11],
		h_appt_time            [6],
		h_section_code         [5],
        h_clinic_code          [5],    /o Cursor Fieldo/
		h_wing_code            [3],
        h_exam_code            [11],
		h_physician_id         [16],	
		h_durn_time            [6],
		h_appt_fr_time         [6],
		h_appt_to_time         [6],
		h_appt_ref_num         [9],
		h_patient_id           [21],	
		h_res_tel_num          [19],
		h_con_tel_num          [19],
		h_short_name_loc_lang  [61],	
		h_short_name           [61],	
	
		h_sex                  [2],
		h_dob                  [11],
		h_ward_code            [5],
		h_bed_num              [9],
		h_ref_source_code      [5],
		h_ref_source_desc      [301],   /oChanged from 31 to 301 for internationalisationo/
	
		t_clinic_code          [5],     /o Temperory var for Break o/
		t_appt_date            [11],    /o Control                 o/
		t_section_code         [5],

		p_language_id		   [3],
		date_convert		   [21],
		nd_temp_date		   [21],
		nd_loc_date            [21],
		l_translated_value	   [200]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[9]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[122]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[13]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[41]; } h_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } h_user;

struct { unsigned short len; unsigned char arr[17]; } h_sysdate;

struct { unsigned short len; unsigned char arr[13]; } nd_fr_appt_date;

struct { unsigned short len; unsigned char arr[13]; } nd_to_appt_date;

struct { unsigned short len; unsigned char arr[7]; } nd_fr_section_code;

struct { unsigned short len; unsigned char arr[7]; } nd_to_section_code;

struct { unsigned short len; unsigned char arr[5]; } nd_fr_clinic_code;

struct { unsigned short len; unsigned char arr[5]; } nd_to_clinic_code;

struct { unsigned short len; unsigned char arr[3]; } nd_wing_code;

struct { unsigned short len; unsigned char arr[91]; } h_wing_desc;

struct { unsigned short len; unsigned char arr[91]; } h_physician_name;

struct { unsigned short len; unsigned char arr[91]; } h_section_desc;

struct { unsigned short len; unsigned char arr[91]; } h_clinic_desc;

struct { unsigned short len; unsigned char arr[41]; } h_exam_desc;

struct { unsigned short len; unsigned char arr[11]; } h_appt_date;

struct { unsigned short len; unsigned char arr[6]; } h_appt_time;

struct { unsigned short len; unsigned char arr[5]; } h_section_code;

struct { unsigned short len; unsigned char arr[5]; } h_clinic_code;

struct { unsigned short len; unsigned char arr[3]; } h_wing_code;

struct { unsigned short len; unsigned char arr[11]; } h_exam_code;

struct { unsigned short len; unsigned char arr[16]; } h_physician_id;

struct { unsigned short len; unsigned char arr[6]; } h_durn_time;

struct { unsigned short len; unsigned char arr[6]; } h_appt_fr_time;

struct { unsigned short len; unsigned char arr[6]; } h_appt_to_time;

struct { unsigned short len; unsigned char arr[9]; } h_appt_ref_num;

struct { unsigned short len; unsigned char arr[21]; } h_patient_id;

struct { unsigned short len; unsigned char arr[19]; } h_res_tel_num;

struct { unsigned short len; unsigned char arr[19]; } h_con_tel_num;

struct { unsigned short len; unsigned char arr[61]; } h_short_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } h_short_name;

struct { unsigned short len; unsigned char arr[2]; } h_sex;

struct { unsigned short len; unsigned char arr[11]; } h_dob;

struct { unsigned short len; unsigned char arr[5]; } h_ward_code;

struct { unsigned short len; unsigned char arr[9]; } h_bed_num;

struct { unsigned short len; unsigned char arr[5]; } h_ref_source_code;

struct { unsigned short len; unsigned char arr[301]; } h_ref_source_desc;

struct { unsigned short len; unsigned char arr[5]; } t_clinic_code;

struct { unsigned short len; unsigned char arr[11]; } t_appt_date;

struct { unsigned short len; unsigned char arr[5]; } t_section_code;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[200]; } l_translated_value;


		int i=0,
		time_flag = 0;

float       mths,dys; 

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




#include <winproc.h>
char   string_var[100];
char filename[150];

char loc_legend[999][200];

int line_no = 0;
long page_no = 0;
int first   = 0;

FILE *f1;

float yrs,days;
int   iyrs,imths,idays;
char age[5];

void proc_main(argc, argv)
int argc;
char *argv[];
  {
	void get_params(),
         get_header_dtls(),
         dclr_appt_cur(),
         do_report();

		//printf ( "RDRAPLST : Program Started.\n\n" );

    if ( argc != 6 ) 
       {
          int i = 0;

          disp_message(ERR_MESG,"Usage oaraplst uid/passwd session_id pgm_date\n");
          disp_message(ERR_MESG,"Exiting due to Mismatch of input parameters\007\007\007");
          sprintf(string_var,"No of Parameters is <%d>\n",argc);
          disp_message(ERR_MESG,string_var); 
          disp_message(ERR_MESG,"The following are the parameters :-\n");

          for ( i = 0; i < argc; i++ ) 
	      sprintf ( string_var,"argv [ %d ] ---> <%s>\n", i, argv [i] );
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

	strcpy(OUTPUT_FILE_NAME,argv[5]);
	
	connect_sql();

	set_meduser_role();

	/*Code Included for internationalization*/
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;

	open_file();

	fprintf(f1,"%c&k4S",ESC);
	fprintf(f1,"%c&l1O",ESC); 
	fprintf(f1,"%c&a5L",ESC);/*for resetting to default mode  */

    get_params();

	fetch_legend_value();
 
    get_header_dtls();

    dclr_appt_cur();

    do_report();

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


/*-------------- Check for any error and No data found ----------------------*/
     if ( OERROR ) 
       {
          disp_message(ERR_MESG, "COMMIT failed\n" );
          proc_exit();
       }
/*-------------------------- End of Error Check ------------------------------*/
     fclose (f1);
	/* printf ( "RDRAPLST : Program Ended.\n\n" );*/
     return;
  }   


/*	************************** Sub Programs	************************** */

connect_sql()
{
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

  
	if ( OERROR ) 
       {
          disp_message ( ERR_MESG,"USERID/PASSWORD failed to Connect\n" );
          proc_exit();
       }
}

open_file()
{
	strcpy(filename,WORKING_DIR);
	//strcat(filename,"rdraplst.lis");
	strcat(filename,OUTPUT_FILE_NAME);
     if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
       {
		  disp_message(ERR_MESG, ".... Error opening output file ....\n" );
          proc_exit();
       } 
}

/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                 */
void get_params()
  {
      nd_wing_code.arr [0]            = '\0';
	  nd_fr_appt_date.arr [0]         = '\0';
      nd_to_appt_date.arr [0]         = '\0';
      nd_to_section_code.arr [0]      = '\0';
      nd_fr_section_code.arr [0]      = '\0';
      nd_to_clinic_code.arr [0]       = '\0';
      nd_fr_clinic_code.arr [0]       = '\0';

      nd_wing_code.len       = 0;
	  nd_fr_appt_date.len    = 0;
      nd_to_appt_date.len    = 0;
      nd_fr_section_code.len = 0;
      nd_to_section_code.len = 0;
      nd_to_clinic_code.len  = 0;
      nd_fr_clinic_code.len  = 0;

	/*disp_message(ERR_MESG,nd_pgm_id.arr); 
	disp_message(ERR_MESG,uid_pwd.arr); 
	disp_message(ERR_MESG,nd_session_id.arr); 
	disp_message(ERR_MESG,nd_pgm_date.arr); 
	disp_message(ERR_MESG,nd_facility_id.arr); */


   /* read the parameter record */
      /* EXEC SQL SELECT PARAM1,
	         	      PARAM2,
				      PARAM3,
				      PARAM4,
				      PARAM5,
					  PARAM6 
				 INTO :nd_wing_code ,
					  :nd_fr_section_code,
					  :nd_fr_clinic_code,
					  :nd_to_clinic_code,
					  :nd_fr_appt_date,
					  :nd_to_appt_date
				 FROM SY_PROG_PARAM
			    WHERE OPERATING_FACILITY_ID = :nd_facility_id
				  AND PGM_ID                = 'RDRAPLST'
				  AND SESSION_ID            =  TO_NUMBER (:nd_session_id )
				  AND PGM_DATE              =  :nd_pgm_date; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 9;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 i\
nto :b0,:b1,:b2,:b3,:b4,:b5  from SY_PROG_PARAM where (((OPERATING_FACILITY_ID\
=:b6 and PGM_ID='RDRAPLST') and SESSION_ID=TO_NUMBER(:b7)) and PGM_DATE=:b8)";
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
      sqlstm.sqhstl[4] = (unsigned int  )15;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&nd_to_appt_date;
      sqlstm.sqhstl[5] = (unsigned int  )15;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
      sqlstm.sqhstl[6] = (unsigned int  )5;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&nd_session_id;
      sqlstm.sqhstl[7] = (unsigned int  )18;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&nd_pgm_date;
      sqlstm.sqhstl[8] = (unsigned int  )15;
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

      if ( OERROR ) 
	{
           disp_message (ERR_MESG, "SELECT failed on SY_PROG_PARAM\n" );
           proc_exit();
        }

      if (NO_DATA_FOUND) 
	{
           disp_message (ERR_MESG, "No Data Found in the SY_PROG_PARAM\n" );
           proc_exit();
        }



/*-------------------------- End of Error Check ------------------------------*/

      nd_wing_code.arr [ nd_wing_code.len ]               = '\0';
      nd_fr_section_code.arr [ nd_fr_section_code.len ]   = '\0';
      nd_to_section_code.arr [ nd_to_section_code.len ]   = '\0';
      nd_fr_clinic_code.arr [ nd_fr_clinic_code.len ]     = '\0';
      nd_to_clinic_code.arr [ nd_to_clinic_code.len ]     = '\0';
      nd_fr_appt_date.arr [ nd_fr_appt_date.len ]         = '\0';
      nd_to_appt_date.arr [ nd_to_appt_date.len ]         = '\0';

  /* delete the parameter record */
      /* EXEC SQL DELETE SY_PROG_PARAM
				WHERE OPERATING_FACILITY_ID = :nd_facility_id
				  AND PGM_ID                = 'RDRAPLST'
				  AND SESSION_ID            =  TO_NUMBER (:nd_session_id )
				  AND PGM_DATE              =  :nd_pgm_date; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 9;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((OPERATING_FACILITY\
_ID=:b0 and PGM_ID='RDRAPLST') and SESSION_ID=TO_NUMBER(:b1)) and PGM_DATE=:b2\
)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )102;
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
     h_acc_entity_name.arr [0]   = '\0';
     h_user.arr [0]              = '\0';
     h_sysdate.arr [0]           = '\0';
     
     h_acc_entity_name.len = 0;
     h_user.len            = 0;
     h_sysdate.len         = 0;

     /*For internationlization SY_ACC_ENTITY table is changed to SY_ACC_ENTITY_LANG_VW*/
	 /* EXEC SQL SELECT upper(ACC_ENTITY_NAME), 
	         	     USER,
				     TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
		        INTO :h_acc_entity_name,
			 	     :h_user,
				     :h_sysdate
                FROM SY_ACC_ENTITY_lang_vw
			   WHERE ACC_ENTITY_ID = :nd_facility_id
			   AND   LANGUAGE_ID   = :p_language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,USER ,TO_CHAR(SYSDATE,'DD/MM\
/YYYY HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY\
_ID=:b3 and LANGUAGE_ID=:b4)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )129;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&h_acc_entity_name;
  sqlstm.sqhstl[0] = (unsigned int  )43;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&h_user;
  sqlstm.sqhstl[1] = (unsigned int  )23;
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
					 B.WING_CODE,
                     A.EXAM_CODE,
		             A.REF_PHYS_ID,
                     TO_CHAR(TO_DATE(TO_NUMBER(TO_CHAR(A.APPT_END_TIME,'SSSSS')) -
                     TO_NUMBER(TO_CHAR(A.APPT_START_TIME,'SSSSS')),'SSSSS'),
                                                               'HH24:MI'),
				     TO_CHAR(A.APPT_START_TIME,'HH24:MI'),
				     TO_CHAR(A.APPT_END_TIME,'HH24:MI'),
				     A.APPT_REF_NUM,
				     A.PATIENT_ID,
				     A.RES_TELEPHONE_NUM,
				     A.OTHER_CONTACT_NUM,
				     SUBSTR(A.SHORT_NAME_LOC_LANG,1,16),
				     A.SHORT_NAME,
				     A.SEX,
				     TO_CHAR(A.DATE_OF_BIRTH,'DD/MM/YYYY'),
				     A.WARD_CODE,
				     A.BED_NUM,
				     A.REF_SOURCE_CODE
              FROM   RD_APPT A ,RD_CLINIC B
              WHERE  A.OPERATING_FACILITY_ID = :nd_facility_id
			  AND    A.SECTION_CODE = DECODE(:nd_fr_section_code,'!!!!',A.SECTION_CODE,:nd_fr_section_code) 
              AND    B.WING_CODE    = DECODE(:nd_wing_code,'!!',B.WING_CODE,:nd_wing_code)
			  AND    TRUNC(A.APPT_DATE) BETWEEN TO_DATE(:nd_fr_appt_date, 'DD/MM/YYYY')
		             AND TO_DATE(:nd_to_appt_date, 'DD/MM/YYYY')
              AND    A.CLINIC_CODE BETWEEN :nd_fr_clinic_code AND :nd_to_clinic_code
			  AND    A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
              AND    A.SECTION_CODE = B.SECTION_CODE
			  AND    A.CLINIC_CODE  = B.CLINIC_CODE
			  ORDER BY TRUNC(A.APPT_DATE), 
			           B.WING_CODE,
				       A.SECTION_CODE,
				       A.CLINIC_CODE,
				       TO_CHAR(A.APPT_START_TIME, 'HH24:MI'); */ 


/*-------------- Check for any error and No data found ----------------------*/

     if (OERROR) 
       {
          disp_message (ORA_MESG, "CURSOR declaration failed on APPT_CUR\n" );
        /*  printf ( "%s\n",sqlca.sqlerrm.sqlerrmc );*/
          
          proc_exit();
       }

/*------------------------- End of Error Check -------------------------------*/

     /* EXEC SQL OPEN APPT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 9;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlbuft((void **)0, 
       "select TO_CHAR(A.APPT_DATE,'DD/MM/YYYY') ,A.SECTION_CODE ,A.CLINIC_C\
ODE ,B.WING_CODE ,A.EXAM_CODE ,A.REF_PHYS_ID ,TO_CHAR(TO_DATE((TO_NUMBER(TO_\
CHAR(A.APPT_END_TIME,'SSSSS'))-TO_NUMBER(TO_CHAR(A.APPT_START_TIME,'SSSSS'))\
),'SSSSS'),'HH24:MI') ,TO_CHAR(A.APPT_START_TIME,'HH24:MI') ,TO_CHAR(A.APPT_\
END_TIME,'HH24:MI') ,A.APPT_REF_NUM ,A.PATIENT_ID ,A.RES_TELEPHONE_NUM ,A.OT\
HER_CONTACT_NUM ,SUBSTR(A.SHORT_NAME_LOC_LANG,1,16) ,A.SHORT_NAME ,A.SEX ,TO\
_CHAR(A.DATE_OF_BIRTH,'DD/MM/YYYY') ,A.WARD_CODE ,A.BED_NUM ,A.REF_SOURCE_CO\
DE  from RD_APPT A ,RD_CLINIC B where (((((((A.OPERATING_FACILITY_ID=:b0 and\
 A.SECTION_CODE=DECODE(:b1,'!!!!',A.SECTION_CODE,:b1)) and B.WING_CODE=DECOD\
E(:b3,'!!',B.WING_CODE,:b3)) and TRUNC(A.APPT_DATE) between TO_DATE(:b5,'DD/\
MM/YYYY') and TO_DATE(:b6,'DD/MM/YYYY')) and A.CLINIC_CODE between :b7 and :\
b8) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and A.SECTION_CODE=\
B.SECTION_CODE) and A.CLINIC_CODE=B.CLINIC_CODE) order by TRUNC(A.APPT_DATE)\
,B.WING_CODE,A.SECTION_CODE,A.CLINIC_CODE,TO");
     sqlstm.stmt = sq0006;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )164;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_fr_section_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_fr_section_code;
     sqlstm.sqhstl[2] = (unsigned int  )9;
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
     sqlstm.sqhstv[4] = (         void  *)&nd_wing_code;
     sqlstm.sqhstl[4] = (unsigned int  )5;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_fr_appt_date;
     sqlstm.sqhstl[5] = (unsigned int  )15;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_to_appt_date;
     sqlstm.sqhstl[6] = (unsigned int  )15;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_fr_clinic_code;
     sqlstm.sqhstl[7] = (unsigned int  )7;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_to_clinic_code;
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



/*-------------- Check for any error and No data found ----------------------*/

     if (OERROR)
       {
          disp_message (ORA_MESG, "OPEN failed on APPT_CUR\n" );
         /* printf ( "%s\n",sqlca.sqlerrm.sqlerrmc );*/
          
          proc_exit();
       }

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
	  get_ref_source_desc(),
          get_clinic_desc(),
          print_hdr(),
          print_col_heading(),
          print_hdr_detl();

     int fetch_appt_cur();
     int still_rec_left, posted = 0;
     int i = 1;

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
	       
          if ( strcmp ( t_appt_date.arr, h_appt_date.arr ) != 0 ||
	       strcmp ( t_section_code.arr, h_section_code.arr ) != 0 )
          {
	       fprintf ( f1, "\f" );

               print_page_header();
	       print_hdr ();
	       print_col_heading ();
               print_hdr_detl();

               strcpy ( t_appt_date.arr, h_appt_date.arr );
	       strcpy ( t_section_code.arr, h_section_code.arr );
	       strcpy ( t_clinic_code.arr, h_clinic_code.arr );
          }
          else if ( strcmp ( t_clinic_code.arr, h_clinic_code.arr ) != 0 )
               {
                  if ( (line_no + 6) > MAX_LINES )
	          {
	             fprintf ( f1, "\f" );

                     print_page_header();
	             print_hdr ();
                  }
	          print_col_heading ();
                  print_hdr_detl();

                  strcpy ( t_clinic_code.arr, h_clinic_code.arr );
               }
          else if ( (line_no + 6) > MAX_LINES )
	       {
	           fprintf ( f1, "\f" );
  
                   print_page_header();
	           print_hdr ();
	           print_col_heading ();
                   print_hdr_detl();
               }
            else 
               print_hdr_detl();
     }

     print_end_of_rep();
  }

/* -------------------------- End of Report function -------------------------*/

/* fetches the next record from APPT_CUR     */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_appt_cur()
  {
     h_appt_date.arr[0]                = '\0';
     h_section_code.arr[0]             = '\0';
     h_clinic_code.arr[0]              = '\0';
	 h_wing_code.arr[0]                = '\0';
     h_exam_code.arr[0]                = '\0';
     h_physician_id.arr[0]             = '\0';
     h_appt_time.arr[0]                = '\0';
     h_appt_fr_time.arr[0]             = '\0';
     h_appt_to_time.arr[0]             = '\0';
     h_appt_ref_num.arr[0]             = '\0';
     h_patient_id.arr[0]               = '\0';
     h_res_tel_num.arr[0]              = '\0';
     h_con_tel_num.arr[0]              = '\0';
     h_short_name_loc_lang.arr[0]      = '\0';
     h_short_name.arr[0]               = '\0';
     h_sex.arr[0]                      = '\0';
     h_dob.arr[0]                      = '\0';
     h_ward_code.arr[0]                = '\0';
     h_bed_num.arr[0]                  = '\0';
     h_ref_source_code.arr[0]          = '\0';

     h_appt_date.len                   = 0;
     h_section_code.len                = 0;
     h_clinic_code.len                 = 0;
	 h_wing_code.len                   = 0;
     h_exam_code.len                   = 0;
     h_physician_id.len                = 0;
     h_appt_time.len                   = 0;
     h_appt_fr_time.len                = 0;
     h_appt_to_time.len                = 0;
     h_appt_ref_num.len                = 0;
     h_patient_id.len                  = 0;
     h_res_tel_num.len                 = 0;
     h_con_tel_num.len                 = 0;
     h_short_name_loc_lang.len         = 0;
     h_short_name.len                  = 0;
     h_sex.len                         = 0;
     h_dob.len                         = 0;
     h_ward_code.len                   = 0;
     h_bed_num.len                     = 0;
     h_ref_source_code.len             = 0;

     /* EXEC SQL FETCH  APPT_CUR 
              INTO   :h_appt_date,
		     :h_section_code,
	         :h_clinic_code,
			 :h_wing_code,
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
		     :h_short_name,
             :h_sex,
             :h_dob,
             :h_ward_code,
             :h_bed_num,
             :h_ref_source_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 20;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )215;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
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
     sqlstm.sqhstv[3] = (         void  *)&h_wing_code;
     sqlstm.sqhstl[3] = (unsigned int  )5;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&h_exam_code;
     sqlstm.sqhstl[4] = (unsigned int  )13;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&h_physician_id;
     sqlstm.sqhstl[5] = (unsigned int  )18;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&h_appt_time;
     sqlstm.sqhstl[6] = (unsigned int  )8;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&h_appt_fr_time;
     sqlstm.sqhstl[7] = (unsigned int  )8;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&h_appt_to_time;
     sqlstm.sqhstl[8] = (unsigned int  )8;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&h_appt_ref_num;
     sqlstm.sqhstl[9] = (unsigned int  )11;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&h_patient_id;
     sqlstm.sqhstl[10] = (unsigned int  )23;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&h_res_tel_num;
     sqlstm.sqhstl[11] = (unsigned int  )21;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&h_con_tel_num;
     sqlstm.sqhstl[12] = (unsigned int  )21;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&h_short_name_loc_lang;
     sqlstm.sqhstl[13] = (unsigned int  )63;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&h_short_name;
     sqlstm.sqhstl[14] = (unsigned int  )63;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&h_sex;
     sqlstm.sqhstl[15] = (unsigned int  )4;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&h_dob;
     sqlstm.sqhstl[16] = (unsigned int  )13;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&h_ward_code;
     sqlstm.sqhstl[17] = (unsigned int  )7;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&h_bed_num;
     sqlstm.sqhstl[18] = (unsigned int  )11;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&h_ref_source_code;
     sqlstm.sqhstl[19] = (unsigned int  )7;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
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
          disp_message(ORA_MESG,"FETCH failed on cursor APPT_CUR\n");
          sprintf (string_var, "%s\n",sqlca.sqlerrm.sqlerrmc );
          disp_message(ERR_MESG,string_var);
          proc_exit();
       }

     if (NO_DATA_FOUND)
       return 0;

     h_appt_date.arr[h_appt_date.len]                       = '\0';
     h_section_code.arr[h_section_code.len]                 = '\0';
     h_clinic_code.arr[h_clinic_code.len]                   = '\0';
	 h_wing_code.arr[h_wing_code.len]                       = '\0';
     h_exam_code.arr[h_exam_code.len]                       = '\0';
     h_physician_id.arr[h_physician_id.len]                 = '\0';
     h_appt_time.arr[h_appt_time.len]                       = '\0';
     h_appt_fr_time.arr[h_appt_fr_time.len]                 = '\0';
     h_appt_to_time.arr[h_appt_to_time.len]                 = '\0';
     h_appt_ref_num.arr[h_appt_ref_num.len]                 = '\0';
     h_patient_id.arr[h_patient_id.len]                     = '\0';
     h_res_tel_num.arr[h_res_tel_num.len]                   = '\0';
     h_con_tel_num.arr[h_con_tel_num.len]                   = '\0';
     h_short_name_loc_lang.arr[h_short_name_loc_lang.len]   = '\0';
     h_short_name.arr[h_short_name.len]                     = '\0';
     h_sex.arr[h_sex.len]                                   = '\0';
     h_dob.arr[h_dob.len]                                   = '\0';
     h_ward_code.arr[h_ward_code.len]                       = '\0';
     h_bed_num.arr[h_bed_num.len]                           = '\0';
     h_ref_source_code.arr[h_ref_source_code.len]           = '\0';

     yrs= mths= days= imths= iyrs= idays= 0;
     /* EXEC SQL SELECT ABS(MONTHS_BETWEEN(SYSDATE,
                         TO_DATE(:h_dob,'DD/MM/YYYY')))
	      INTO   :mths
	      FROM   DUAL; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 20;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select ABS(MONTHS_BETWEEN(SYSDATE,TO_DATE(:b0,'DD/MM/YYY\
Y'))) into :b1  from DUAL ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )310;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&h_dob;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&mths;
     sqlstm.sqhstl[1] = (unsigned int  )sizeof(float);
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



     age[0] = '\0';

     if(mths > 1 && mths <= 24) {
         imths = mths;
         sprintf(age,"%dM",imths);
     }
     else {
       if(mths > 1) {
           yrs= days=0;
           imths = mths;
        
           if (imths > 0)
               yrs = (int)mths/12;
        
           iyrs = yrs;
           imths = imths - (iyrs * 12);
           
           days = (mths - (int)mths) * 31;
           idays = days;
       }
       else {
            /* EXEC SQL SELECT (SYSDATE - TO_DATE(:h_dob,'DD/MM/YYYY'))
	             INTO   :dys
	             FROM   DUAL; */ 

{
            struct sqlexd sqlstm;
            sqlstm.sqlvsn = 12;
            sqlstm.arrsiz = 20;
            sqlstm.sqladtp = &sqladt;
            sqlstm.sqltdsp = &sqltds;
            sqlstm.stmt = "select (SYSDATE-TO_DATE(:b0,'DD/MM/YYYY')) into :\
b1  from DUAL ";
            sqlstm.iters = (unsigned int  )1;
            sqlstm.offset = (unsigned int  )333;
            sqlstm.selerr = (unsigned short)1;
            sqlstm.cud = sqlcud0;
            sqlstm.sqlest = (unsigned char  *)&sqlca;
            sqlstm.sqlety = (unsigned short)4352;
            sqlstm.occurs = (unsigned int  )0;
            sqlstm.sqhstv[0] = (         void  *)&h_dob;
            sqlstm.sqhstl[0] = (unsigned int  )13;
            sqlstm.sqhsts[0] = (         int  )0;
            sqlstm.sqindv[0] = (         void  *)0;
            sqlstm.sqinds[0] = (         int  )0;
            sqlstm.sqharm[0] = (unsigned int  )0;
            sqlstm.sqadto[0] = (unsigned short )0;
            sqlstm.sqtdso[0] = (unsigned short )0;
            sqlstm.sqhstv[1] = (         void  *)&dys;
            sqlstm.sqhstl[1] = (unsigned int  )sizeof(float);
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


            idays = dys;
        }
    
        if(iyrs != 0)
            sprintf(age,"%dY",iyrs);
        else if(imths != 0)
            sprintf(age,"%dM",imths);
        else
            sprintf(age,"%dD",idays);
     }

     return 1;
  }
/*--------------------------- End of Appointment Fetch ---------------------*/      
/* to print the detailed record with to horizontal summeries */
void print_hdr_detl()
{
	fprintf(f1,"%5s-",h_appt_fr_time.arr);
    fprintf(f1,"%5s ",h_appt_to_time.arr);
    fprintf(f1,"%-8s ", h_appt_ref_num.arr);
    fprintf(f1,"%-20s ",h_patient_id.arr);
	fprintf(f1,"%-30s ", h_short_name.arr);
	fprintf(f1,"%-30s ", h_short_name_loc_lang.arr);
    fprintf(f1,"%2s/%-4s  ", h_sex.arr, age);
    fprintf(f1,"%-18s \n",h_con_tel_num.arr);
	get_physician_name();
    if(strlen(h_ref_source_code.arr) && !strlen(h_physician_name.arr))
	get_ref_source_desc();

    horz_skip(42);
	fprintf(f1,"%-4s %-8s",h_ward_code.arr, h_bed_num.arr); 
	horz_skip(18);		 
	fprintf(f1,"%-30s",strlen(h_physician_name.arr)? h_physician_name.arr:
					       h_ref_source_desc.arr);
	horz_skip(9);
	fprintf(f1,"%-18s \n",h_res_tel_num.arr);
/*
    fprintf(f1, "%-30s\n",h_physician_name.arr);
*/
    get_exam_desc ();
	//fprintf ( f1, "            EXAM : %-40s\n", h_exam_desc.arr );
	fprintf ( f1, "%30s : %-40s\n", loc_legend[17], h_exam_desc.arr );
	print_line('-',REP_WIDTH);
	line_no += 4;
}

/*------ Gets the Section Description  ---------------------------------------*/
void get_section_desc()
{
     h_section_desc.arr [0] = '\0';
     h_section_desc.len     = 0;
     /* EXEC SQL SELECT LONG_DESC
				INTO :h_section_desc  
				FROM RD_SECTION_LANG_VW             /oChanged to lang_vw table for internationalisationo/
			   WHERE SECTION_CODE = :h_section_code
			   AND    LANGUAGE_ID = :p_language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 20;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select LONG_DESC into :b0  from RD_SECTION_LANG_VW where\
 (SECTION_CODE=:b1 and LANGUAGE_ID=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )356;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&h_section_desc;
     sqlstm.sqhstl[0] = (unsigned int  )93;
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

	
     h_section_desc.arr[h_section_desc.len] = '\0';
     return;
}
/*-------------------- End of Section Description  ---------------------------*/
 
/*-------------------- Get Exam Description ----------------------------------*/
get_exam_desc ()
{
     h_exam_desc.arr [0] = '\0';
     h_exam_desc.len     = 0;
     /* EXEC SQL SELECT LONG_DESC
				INTO :h_exam_desc
				FROM RD_EXAMINATION
			   WHERE EXAM_CODE = :h_exam_code
			   AND   LANGUAGE_ID = :p_language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 20;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select LONG_DESC into :b0  from RD_EXAMINATION where (EX\
AM_CODE=:b1 and LANGUAGE_ID=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )383;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&h_exam_desc;
     sqlstm.sqhstl[0] = (unsigned int  )43;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&h_exam_code;
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


     h_exam_desc.arr [ h_exam_desc.len ] = '\0';
}
/*-------------------------- End of Exam Description ------------------------*/

/*------ gets the Physician name for the physician ID -----------------------*/
void get_physician_name()
{
    h_physician_name.arr [0] = '\0';
    h_physician_name.len     = 0;
	/* EXEC SQL SELECT A.PRACTITIONER_NAME
			   INTO :h_physician_name
			   FROM AM_PRACTITIONER_LANG_VW A,AM_PRACT_FOR_FACILITY B		   /oChanged to lang_vw table for internationalisationo/
			  WHERE B.FACILITY_ID = :nd_facility_id
			    AND A.PRACTITIONER_ID = :h_physician_id
				AND A.PRACTITIONER_ID = B.PRACTITIONER_ID
				AND LANGUAGE_ID = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select A.PRACTITIONER_NAME into :b0  from AM_PRACTITIONER_LA\
NG_VW A ,AM_PRACT_FOR_FACILITY B where (((B.FACILITY_ID=:b1 and A.PRACTITIONER\
_ID=:b2) and A.PRACTITIONER_ID=B.PRACTITIONER_ID) and LANGUAGE_ID=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )410;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&h_physician_name;
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
 sqlstm.sqhstv[2] = (         void  *)&h_physician_id;
 sqlstm.sqhstl[2] = (unsigned int  )18;
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

	
	h_physician_name.arr[h_physician_name.len] = '\0';
	return;
}

void get_ref_source_desc()
{
	h_ref_source_desc.arr[0]   = '\0';
    h_ref_source_desc.len      = 0;
	/* EXEC SQL SELECT LONG_DESC
               INTO :h_ref_source_desc
			   FROM SY_REFERRAL_LANG_VW             /oChanged to lang_vw table for internationalisationo/
			  WHERE REFERRAL_CODE = :h_ref_source_code
			  AND LANGUAGE_ID = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_DESC into :b0  from SY_REFERRAL_LANG_VW where (R\
EFERRAL_CODE=:b1 and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )441;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&h_ref_source_desc;
 sqlstm.sqhstl[0] = (unsigned int  )303;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&h_ref_source_code;
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


	h_ref_source_desc.arr[h_ref_source_desc.len]   = '\0';
	return;
}
/*-------------------- End of physician Name ---------------------------------*/

/*------ gets the Clinic desc for the Clinic code ----------------------------*/
void get_clinic_desc()
{
    h_clinic_desc.arr [0] = '\0';
	h_clinic_desc.len     = 0;
	/* EXEC SQL SELECT LONG_DESC
               INTO :h_clinic_desc
	           FROM RD_CLINIC_LANG_VW              /oChanged to lang_vw table for internationalisationo/
	          WHERE OPERATING_FACILITY_ID = :nd_facility_id
			    AND CLINIC_CODE = :h_clinic_code
				AND LANGUAGE_ID = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_DESC into :b0  from RD_CLINIC_LANG_VW where ((OP\
ERATING_FACILITY_ID=:b1 and CLINIC_CODE=:b2) and LANGUAGE_ID=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )468;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&h_clinic_desc;
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
 sqlstm.sqhstv[2] = (         void  *)&h_clinic_code;
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

	
	h_clinic_desc.arr [ h_clinic_desc.len ] = '\0';
	return;
}
/*-------------------- End of clinic Desc ------------------------------------*/

/*------ gets the Wing desc for the Wing code ----------------------------*/
void get_wing_desc()
{
  
	h_wing_desc.arr [0]		= '\0';
	h_wing_desc.len			= 0;
	/* EXEC SQL SELECT LONG_DESC
			   INTO :h_wing_desc
			   FROM RD_WINGS_LANG_VW			  /oChanged to lang_vw table for internationalisationo/				
			  WHERE OPERATING_FACILITY_ID = :nd_facility_id
			    AND WING_CODE = :h_wing_code
				AND LANGUAGE_ID = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_DESC into :b0  from RD_WINGS_LANG_VW where ((OPE\
RATING_FACILITY_ID=:b1 and WING_CODE=:b2) and LANGUAGE_ID=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )499;
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
 sqlstm.sqhstv[2] = (         void  *)&h_wing_code;
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
     char fr_appt_date_desc [11],
		  to_appt_date_desc [11];
     char fr_section_code_desc [8],
          to_section_code_desc [8];
     char fr_clinic_code_desc [8], 
		  to_clinic_code_desc[8];

     char nd_wing_desc [5];
     char nd_section_desc [5];

     if ( strcmp ( nd_wing_code.arr, "!!" ) == 0 )
       //strcpy ( nd_wing_desc, "ALL" );
	   strcpy(nd_wing_desc,loc_legend[16]);
     else 
       strcpy ( nd_wing_desc, nd_wing_code.arr );

	 if ( strcmp ( nd_fr_section_code.arr, "!!!!" ) == 0 )
       //strcpy ( nd_section_desc, "ALL" );
	   strcpy(nd_section_desc,loc_legend[16]);
     else 
       strcpy ( nd_section_desc, nd_fr_section_code.arr );

	 if ( strcmp ( nd_fr_clinic_code.arr, "!!!!" ) == 0 )
       //strcpy ( fr_clinic_code_desc, "LOWEST" );
	   strcpy ( fr_clinic_code_desc, loc_legend[10] );
     else strcpy ( fr_clinic_code_desc, nd_fr_clinic_code.arr );

     if ( strcmp ( nd_to_clinic_code.arr, "~~~~" ) == 0 )
       //strcpy ( to_clinic_code_desc, "HIGHEST" );
		strcpy ( to_clinic_code_desc, loc_legend[11] );
     else
       strcpy ( to_clinic_code_desc, nd_to_clinic_code.arr );

     if ( strcmp ( nd_fr_appt_date.arr, "01/01/1800" ) == 0 )
       //strcpy ( fr_appt_date_desc, "LOWEST" );
	   strcpy ( fr_appt_date_desc, loc_legend[10] );
     else
	 {
       //strcpy ( fr_appt_date_desc, nd_fr_appt_date.arr );
	   init_date_temp_var();
	   strcpy ( date_convert.arr, nd_fr_appt_date.arr );
	   time_flag = 0;
       fun_change_loc_date();
	   strcpy ( fr_appt_date_desc, date_convert.arr );
     }
    
     if ( strcmp ( nd_to_appt_date.arr, "31/12/4712" ) == 0 )
       //strcpy ( to_appt_date_desc, "HIGHEST" );
	   strcpy ( to_appt_date_desc, loc_legend[11] );
     else 
	 {
      // strcpy ( to_appt_date_desc, nd_to_appt_date.arr );
	  init_date_temp_var();
	  strcpy ( date_convert.arr, nd_to_appt_date.arr );
	  time_flag = 0;
      fun_change_loc_date();
	  strcpy ( to_appt_date_desc, date_convert.arr );
     }

     print_page_header();

     fprintf(f1,VER);
     fprintf(f1,"\n\n\n\n");
     fprintf(f1,"        ");
     //fprintf(f1,"INPUT PARAMETERS :\n");
     fprintf(f1,"%s :\n",loc_legend[3]);
     fprintf(f1,"        ");
     fprintf(f1,"------------------\n\n");
     fprintf(f1,"                ");
     //fprintf(f1,"APPOINTMENT DATE FROM         : %s\n", fr_appt_date_desc);
	 fprintf(f1,"%-30s : %s\n",loc_legend[4], fr_appt_date_desc);
     fprintf(f1,"                ");
     //fprintf(f1,"                 TO           : %s\n", to_appt_date_desc);
	 fprintf(f1,"%20s           : %s\n", loc_legend[5],to_appt_date_desc);
     fprintf(f1,"\n");
     fprintf(f1,"                ");
     //fprintf(f1,"WING CODE                     : %s\n\n",nd_wing_desc);
	 fprintf(f1,"%-30s : %s\n\n",loc_legend[6],nd_wing_desc);
     fprintf(f1,"                ");
	 //fprintf(f1,"SECTION CODE                  : %s\n\n",nd_section_desc );
	 fprintf(f1,"%-30s : %s\n\n",loc_legend[7],nd_section_desc );
     fprintf(f1,"                ");
     //fprintf(f1,"STUDY LOCATION   FROM         : %s\n", fr_clinic_code_desc);
	 fprintf(f1,"%-30s : %s\n", loc_legend[8],fr_clinic_code_desc);
     fprintf(f1,"                ");
     //fprintf(f1,"                 TO           : %s\n", to_clinic_code_desc);
	 fprintf(f1,"%20s           : %s\n", loc_legend[5],to_clinic_code_desc);
     fprintf(f1,"\f");
  }

/* to print page headers the header details */ 
void print_page_header()
{
	int hosp_nm_len, rep_title_len = 10, s1, s2;
	char v_rep_title[200];
	
	char fr_appt_date_desc[11],
  	     to_appt_date_desc[11];
	
	page_no = page_no + 1;
	 
    if ( strcmp ( nd_fr_appt_date.arr, "01/01/1800" ) == 0)
		//strcpy ( fr_appt_date_desc, "LOWEST" );
		strcpy ( fr_appt_date_desc, loc_legend[10] );
	else 
	{
		//strcpy(fr_appt_date_desc, nd_fr_appt_date.arr);
		init_date_temp_var();
		strcpy(date_convert.arr,nd_fr_appt_date.arr);
		time_flag = 0;
		fun_change_loc_date();
		strcpy(fr_appt_date_desc,date_convert.arr);
	}

	if ( strcmp ( nd_to_appt_date.arr, "31/12/4712" ) == 0 )
		//strcpy ( to_appt_date_desc, "HIGHEST" );
		strcpy ( to_appt_date_desc, loc_legend[11] );
	else 
	{
		//strcpy(to_appt_date_desc, nd_to_appt_date.arr);
		init_date_temp_var();
		strcpy(date_convert.arr,nd_to_appt_date.arr);
		time_flag = 0;
		fun_change_loc_date();
		strcpy(to_appt_date_desc,date_convert.arr);
	}

	fprintf(f1,"MDL : RD");
    hosp_nm_len  =  h_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(f1,"%s", h_acc_entity_name.arr);
    s2 = (REP_WIDTH-s1-hosp_nm_len);
	horz_skip(s2-16);

    //Date converted for internationalization   
    init_date_temp_var();
	strcpy(date_convert.arr,h_sysdate.arr);
	time_flag = 1;
    fun_change_loc_date();

	//fprintf(f1,"%s", h_sysdate.arr);
	fprintf(f1,"%s", date_convert.arr);
    
	fprintf(f1,"\n"); fprintf(f1,"OPR : %s", h_user.arr); fprintf(f1,"\n");
    
	fprintf(f1,"REP : RDRAPLST");
	
	//strcpy(v_rep_title,REP_TITLE);
	strcpy(v_rep_title,loc_legend[1]);

	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-14);
	//fprintf(f1,"%s",REP_TITLE);
	fprintf(f1,"%s",loc_legend[1]);

	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-10);
	//fprintf(f1,"PAGE :%4d\n",page_no);
	fprintf(f1,"%s :%4d\n",loc_legend[2],page_no);

	fprintf(f1,"                                         ");  
	//fprintf(f1,"FOR THE PERIOD FROM : %-10s", fr_appt_date_desc);
	fprintf(f1,"%s : %-10s", loc_legend[9],fr_appt_date_desc);
    //fprintf(f1,"  TO : %-10s", to_appt_date_desc);
	fprintf(f1," %s : %-10s", loc_legend[5],to_appt_date_desc);
    fprintf(f1,"\n");  
    
	print_line('-',REP_WIDTH);
	
	line_no = 5;
}

/*------------------------------ Name Header ---------------------------------*/
void print_hdr()
  {
     get_section_desc();
	 get_wing_desc();

   /*fprintf(f1,"Appointment Date : %s\n",h_appt_date.arr); 
     fprintf(f1,"Wing             : %-30s\n",h_wing_desc.arr);
	 fprintf(f1,"Section          : %-6s %-30s", h_section_code.arr,h_section_desc.arr);*/

	 fprintf(f1,"%-30s : %s\n",loc_legend[12],h_appt_date.arr); 
     fprintf(f1,"%-30s : %-30s\n",loc_legend[13],h_wing_desc.arr);
	 fprintf(f1,"%-30s : %-6s %-30s", loc_legend[14],h_section_code.arr,h_section_desc.arr);

     line_no += 3;
  }
/*------------------------------ End Header ----------------------------------*/

/*------------------------------ column Header -------------------------------*/
/* print the heading */
void print_col_heading()
  {
     get_clinic_desc();
     fprintf(f1,"\n%-30s : %-4s   %-30s\n",loc_legend[15],h_clinic_code.arr,h_clinic_desc.arr);
	 print_line('-',REP_WIDTH);
   /*fprintf(f1, "Period      Ref. No. Patient No.           Name                                                         Sex/Age Contact Phone(s)\n");
	 fprintf(f1, "                                           Ward/Bed                      Referral Doctor/Source\n");*/
   /*fprintf(f1, "12345678901 12345678 12345678901234567890 123456789012345678901234567890 123456789012345678901234567890 1/1234  123456789012345678");
     fprintf(f1, "                                             1234567890123               123456789012345678");*/

	 fprintf(f1, "%6s%14s%11s%14s%66s%17s\n",loc_legend[18],loc_legend[19],loc_legend[20],loc_legend[21],loc_legend[22],loc_legend[23]);
	 fprintf(f1, "%49s%45s\n",loc_legend[24],loc_legend[25]);	 

	 print_line('-',REP_WIDTH);
	 line_no += 6;
}
/*------------------------------ end Header ----------------------------------*/

print_end_of_rep()
{
	int col;
	fprintf(f1,"\n");    
	for (col = 0; col < (REP_WIDTH -27)/2; col++)
	fprintf(f1," "); 
	//fprintf(f1,"*****  End of Report  *****");
	fprintf(f1,"*****  %s  *****",loc_legend[26]);
	fprintf(f1,"%cE",ESC);
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

/******************************************************************************/

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
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ,\
 t_date ) ; IF :time_flag = 1 THEN :nd_loc_date := to_char ( t_date , 'DD/MM/Y\
YYY HH24:MI' ) ; :time_flag := 0 ; ELSE :nd_loc_date := to_char ( t_date , 'DD\
/MM/YYYY' ) ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )530;
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
  	   sm_populate_report_legend.fetch_legend(:nd_facility_id,:p_language_id,'RDRAPLST.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin sm_populate_report_legend . fetch_legend ( :nd_facilit\
y_id , :p_language_id , 'RDRAPLST.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )561;
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
       :l_translated_value := GET_LEGEND(LTRIM(RTRIM('RDRAPLST.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
DRAPLST.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )584;
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


#undef DEBUG
#undef NODATAFOUND
#undef OERROR
#undef MAX_LINES
#undef VER
