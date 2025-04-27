
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RD/RDRITCON.PC"
};


static unsigned int sqlctx = 1288578267;


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
            void  *sqhstv[9];
   unsigned int   sqhstl[9];
            int   sqhsts[9];
            void  *sqindv[9];
            int   sqinds[9];
   unsigned int   sqharm[9];
   unsigned int   *sqharc[9];
   unsigned short  sqadto[9];
   unsigned short  sqtdso[9];
} sqlstm = {12,9};

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
"select SECTION_CODE ,A.STORE_TYPE ,STORE_CODE ,A.ITEM_CODE ,sum(ACTUAL_QUANT\
ITY)  from RD_ITEMS_CONSUMED A ,RD_REQUEST B ,RD_ITEMS C where (((((((((A.OPER\
ATING_FACILITY_ID=B.OPERATING_FACILITY_ID and A.OPERATING_FACILITY_ID=:b0) and\
 A.REQUEST_NUM=B.REQUEST_NUM) and A.ITEM_CODE=C.ITEM_CODE) and B.WING_CODE=:b1\
) and C.STORE_TYPE in ('CN','DR')) and REQUEST_DATE between TO_DATE((:b2||' 00\
:00'),'DD/MM/YYYY HH24:MI') and TO_DATE((:b3||' 23:59'),'DD/MM/YYYY HH24:MI'))\
 and B.SECTION_CODE=:b4) and A.STORE_TYPE in ('PS','DR')) and A.STORE_TYPE=dec\
ode(:b5,'PS','PS','DR','DR','BO',A.STORE_TYPE)) group by SECTION_CODE,A.STORE_\
TYPE,STORE_CODE,A.ITEM_CODE order by SECTION_CODE,A.STORE_TYPE,STORE_CODE,A.IT\
EM_CODE            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,167,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,202,0,0,0,0,0,1,0,
51,0,0,3,190,0,4,234,0,0,9,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
102,0,0,4,127,0,2,270,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
133,0,0,5,165,0,4,304,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
168,0,0,6,719,0,9,369,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
207,0,0,6,0,0,13,505,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
242,0,0,7,105,0,4,567,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
273,0,0,8,95,0,4,584,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
300,0,0,9,122,0,4,640,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
331,0,0,10,322,0,6,878,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,3,3,0,0,2,9,0,0,
362,0,0,11,112,0,6,915,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
385,0,0,12,136,0,6,928,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/******************************************************************************/
/* OCS MEDICOM VER 1.0                                                        */
/******************************************************************************/
/* PROGRAM NAME     : rdritcon.pc                                             */
/* AUTHOR           : VASANT KUMAR	                                      */
/* DATE WRITTEN     : 10-MAY-1993                                             */
/*                                                                            */
/* CALLED FROM      : rdritcon.inp                                            */
/*                                                                            */
/* INPUT PARAMETERS : USER_ID/PASSWORD                                        */
/*                  : SESSION_ID                                              */
/*                  : PGM_DATE                                                */
/*                  : APPOINTMENT FROM AND TO DATE                            */
/*                  : APPOINTMENT FROM AND TO CLINIC                          */
/*                                                                            */
/* TABLES ACCESSED  : SY_PROG_PARAM                                           */
/*                  : SY_ACC_ENTITY                                           */
/*                  : RD_REQUEST                                              */
/*                  : RD_EXAMS_REQUESTED                                      */
/*                  : SY_PHYSICIAN_MAST                                       */
/*                  : RD_CLINIC                                               */
/*                                                                            */
/* OUTPUT FILE      : rdritcon.lis                                            */
/*                                                                            */
/*                                                                            */
/* FUNCTION         : This program prints a Appointments statistics by Clinic */
/*                    for Inpatients and outpatients                          */
/*                    For a given SY_PROG_PARAM parameters                    */
/*                                                                            */
/* VERSION          : 1.10.01                                                 */
/* MODIFICATIONS    :                                                         */
/*                                                                            */
/* VERSION          : eHIS 4.1                                                */
/*                                                                            */
/* MODIFIED by      : 
/*                                                                            */
/* DATE MODIFIED    : 23/Aug/2003                                             */
/*                                                                            */
/******************************************************************************/

#include <stdio.h>
#include <math.h>
#include "gl.h"
#include <string.h>

#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND sqlca.sqlcode==1403
#define MAX_LINES 41
#define REP_WIDTH 82
#define REP_TITLE "STOCK ITEMS CONSUMED (CONTRASTS/DRUGS)"
#define REP_TITLE_1 "STOCK ITEMS CONSUMED (CONSUMABLES)"
#define VER  "VER : 10.2\n"
#define ESC  0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR nd_facility_id		   [3],  
			nd_pgm_id    		   [9],  
			uid_pwd		           [122], /o Length changed from 91 to 122 o/ 
			nd_session_id		   [16],
			nd_pgm_date			   [13], 
			nd_store_type          [10],  //Input Parameters

	        h_acc_entity_name      [301],  /o SY_ACC_ENTITY header access o/
			h_user                 [31],
			h_sysdate              [17],

			nd_section_code        [5],	  /o SY_PROG_PARAM Parameters o/
			nd_fr_date             [11],
			nd_to_date             [11],
			nd_wing_code           [3],
			h_wing_desc            [91],  /oLength changed from 31 to 91 for internationalisationo/
			nd_store_desc		   [50],
			
			h_section_desc         [91],  /o Desc for the Code access o/
			h_store_type_desc      [48],  /oLength changed from 16 to 48 for internationalisationo/
			h_store_code_desc      [31],
			h_item_desc            [121], /oLength changed from 41 to 121 for internationalisationo/

			h_section_code         [3],
			h_store_type           [3],   
     		h_store_code           [5],
   			h_item_code            [21],
     		h_item_type_code       [5],
			h_item_units           [13],  /oLength changed from 5 to 13 for internationalisationo/
			
			t_store_type           [3],     /o Temperory var for Break o/
			t_store_code           [7],     /o Temperory var for Break o/
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

struct { unsigned short len; unsigned char arr[10]; } nd_store_type;

struct { unsigned short len; unsigned char arr[301]; } h_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } h_user;

struct { unsigned short len; unsigned char arr[17]; } h_sysdate;

struct { unsigned short len; unsigned char arr[5]; } nd_section_code;

struct { unsigned short len; unsigned char arr[11]; } nd_fr_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[3]; } nd_wing_code;

struct { unsigned short len; unsigned char arr[91]; } h_wing_desc;

struct { unsigned short len; unsigned char arr[50]; } nd_store_desc;

struct { unsigned short len; unsigned char arr[91]; } h_section_desc;

struct { unsigned short len; unsigned char arr[48]; } h_store_type_desc;

struct { unsigned short len; unsigned char arr[31]; } h_store_code_desc;

struct { unsigned short len; unsigned char arr[121]; } h_item_desc;

struct { unsigned short len; unsigned char arr[3]; } h_section_code;

struct { unsigned short len; unsigned char arr[3]; } h_store_type;

struct { unsigned short len; unsigned char arr[5]; } h_store_code;

struct { unsigned short len; unsigned char arr[21]; } h_item_code;

struct { unsigned short len; unsigned char arr[5]; } h_item_type_code;

struct { unsigned short len; unsigned char arr[13]; } h_item_units;

struct { unsigned short len; unsigned char arr[3]; } t_store_type;

struct { unsigned short len; unsigned char arr[7]; } t_store_code;

struct { unsigned short len; unsigned char arr[5]; } t_section_code;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[200]; } l_translated_value;


			int i=0,
			    time_flag = 0;

	double  h_actual_quantity;

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





#include "winproc.h";
char string_var[100];
char filename[150];

char fr_appt_date_desc[11], to_appt_date_desc[11];

char loc_legend[999][200];

int line_no = 0;
int page_no = 0;

FILE *f1;

void proc_main(argc, argv)
int argc;
char *argv[];
{
	void get_params(),
		 get_header_dtls(),
         dclr_appt_cur(),
         do_report();
	/*  printf("RDRITCON : Program Started.\n\n");      */


    if (argc != 6) 
    {
        int i = 0;
		disp_message(ERR_MESG,"Usage rdritcon uid/passwd session_id pgm_date\n");
        disp_message(ERR_MESG,"Exiting due to Mismatch of input parameters\007\007\007");
        sprintf(string_var,"No of Parameters is <%d>\n",argc); 
        disp_message(ERR_MESG,string_var);
        disp_message(ERR_MESG,"The following are the parameters :-\n");

        for ( i = 0; i < argc; i++ ) 
		sprintf(string_var,"argv[ %d ] ---> <%s>\n",i,argv[i]);
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
	
/*	strcpy(nd_store_type.arr, argv[6]);
	nd_store_type.len = strlen(nd_store_type.arr);
*/
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

  

    if (OERROR) 
      {
         disp_message(ERR_MESG,"USERID/PASSWORD failed to Connect\n");
          proc_exit();
      }

	set_meduser_role();

	/*Code Included for internationalization*/
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;
 
    strcpy(filename,WORKING_DIR);
	//strcat(filename,"rdritcon.lis");
	strcat(filename,OUTPUT_FILE_NAME);
    if ((f1 = fopen(filename, "w")) == NULL) 
    {
         disp_message(ERR_MESG,".... Error opening output file ....\n");
         exit(1);
    } 

	get_params();

	fetch_legend_value();

    get_header_dtls();

    dclr_appt_cur();

	fprintf(f1,"%c&k4S",ESC); fprintf(f1,"%c&a7L",ESC);
   
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
	if (OERROR) 
    {
		disp_message(ERR_MESG,"COMMIT failed\n");
        proc_exit();
	}
	/*-------------------------- End of Error Check ------------------------------*/
	
	fclose(f1);
	/*   printf("RDRITCON : Program Ended.\n\n");         */
    return;
}   



/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                 */
void get_params()
  {
     nd_fr_date.arr [0]      = '\0';
     nd_to_date.arr [0]      = '\0';
     nd_section_code.arr [0] = '\0';
     nd_store_type.arr [0]	 = '\0';

     nd_fr_date.len       = 0;
     nd_to_date.len       = 0;
     nd_section_code.len  = 0;
     nd_store_type.len    = 0;

   /* read the parameter record */
     /* EXEC SQL SELECT PARAM1,
		             PARAM2,
		             PARAM3,
					 PARAM4, PARAM6
				INTO :nd_fr_date,
		             :nd_to_date,
	                 :nd_section_code ,
					 :nd_wing_code, :nd_store_type
				FROM SY_PROG_PARAM
			   WHERE OPERATING_FACILITY_ID  = :nd_facility_id
			     AND PGM_ID					= :nd_pgm_id
				 AND SESSION_ID				= TO_NUMBER(:nd_session_id)
				 AND PGM_DATE				= :nd_pgm_date; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 9;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM6 into :b0,:\
b1,:b2,:b3,:b4  from SY_PROG_PARAM where (((OPERATING_FACILITY_ID=:b5 and PGM_\
ID=:b6) and SESSION_ID=TO_NUMBER(:b7)) and PGM_DATE=:b8)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )51;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_fr_date;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
     sqlstm.sqhstl[1] = (unsigned int  )13;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_section_code;
     sqlstm.sqhstl[2] = (unsigned int  )7;
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
     sqlstm.sqhstv[4] = (         void  *)&nd_store_type;
     sqlstm.sqhstl[4] = (unsigned int  )12;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
     sqlstm.sqhstl[5] = (unsigned int  )5;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_pgm_id;
     sqlstm.sqhstl[6] = (unsigned int  )11;
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

   if (OERROR) 
     {
        disp_message(ERR_MESG,"SELECT failed on SY_PROG_PARAM\n");
         proc_exit();
     }

   if (NO_DATA_FOUND)
     {
        disp_message(ERR_MESG,"No Data Found in the SY_PROG_PARAM\n");
         proc_exit();
     }

   nd_section_code.arr[nd_section_code.len] = '\0';
   nd_fr_date.arr[nd_fr_date.len]           = '\0';
   nd_to_date.arr[nd_to_date.len]           = '\0';
   nd_store_type.arr[nd_store_type.len]		= '\0';
/*-------------------------- End of Error Check ------------------------------*/


  /* delete the parameter record */
   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE OPERATING_FACILITY_ID  = :nd_facility_id
			   AND PGM_ID				  = :nd_pgm_id
			   AND SESSION_ID			  = TO_NUMBER(:nd_session_id)
			   AND PGM_DATE				  = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((OPERATING_FACILITY_ID\
=:b0 and PGM_ID=:b1) and SESSION_ID=TO_NUMBER(:b2)) and PGM_DATE=:b3)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_pgm_id;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[2] = (unsigned int  )18;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[3] = (unsigned int  )15;
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
     h_acc_entity_name.len   = 0;
     h_user.len              = 0;
     h_sysdate.len           = 0;

     h_acc_entity_name.arr[h_acc_entity_name.len]   = '\0';
     h_user.arr[h_user.len]                         = '\0';
     h_sysdate.arr[h_sysdate.len]                   = '\0';

     /* EXEC SQL SELECT UPPER(ACC_ENTITY_NAME), USER,
		             TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
	            INTO :h_acc_entity_name,:h_user,
					 :h_sysdate
				FROM SY_ACC_ENTITY_LANG_VW
			   WHERE ACC_ENTITY_ID  = :nd_facility_id
			   AND   LANGUAGE_ID = :p_language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 9;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select UPPER(ACC_ENTITY_NAME) ,USER ,TO_CHAR(SYSDATE,'DD\
/MM/YYYY HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC_ENT\
ITY_ID=:b3 and LANGUAGE_ID=:b4)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )133;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&h_acc_entity_name;
     sqlstm.sqhstl[0] = (unsigned int  )303;
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

    h_acc_entity_name.arr[h_acc_entity_name.len]   = '\0';
    h_user.arr[h_user.len]                         = '\0';
    h_sysdate.arr[h_sysdate.len]                   = '\0';

	return;
}
/*------------------------- End of Header access -----------------------------*/

/*------------------------- Appointments Cursor ------------------------------*/
void dclr_appt_cur()
{
     /* EXEC SQL DECLARE ITEM_CUR CURSOR FOR
			   SELECT SECTION_CODE, A.STORE_TYPE, STORE_CODE, A.ITEM_CODE, SUM(ACTUAL_QUANTITY)
			     FROM RD_ITEMS_CONSUMED A , RD_REQUEST B ,RD_ITEMS C //, RD_CLINIC C commented by rvN as per chandra's instr. on 03rd Nov 2003
			    WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
				//AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID
				  AND A.OPERATING_FACILITY_ID = :nd_facility_id
				  AND A.REQUEST_NUM  = B.REQUEST_NUM 
				  AND A.ITEM_CODE    = C.ITEM_CODE
				  AND B.WING_CODE    =  :nd_wing_code
				//AND B.WING_CODE    =  C.WING_CODE
				//AND B.CLINIC_CODE  = C.CLINIC_CODE
				//AND B.SECTION_CODE = B.SECTION_CODE
				  AND C.STORE_TYPE IN ('CN', 'DR')   // DR added by shashi on 24/02/05
				  AND REQUEST_DATE BETWEEN TO_DATE(:nd_fr_date||' 00:00', 'DD/MM/YYYY HH24:MI') 
					  AND TO_DATE(:nd_to_date||' 23:59', 'DD/MM/YYYY HH24:MI') 
				  AND B.SECTION_CODE = :nd_section_code
				  AND A.STORE_TYPE IN ('PS', 'DR')  // condition added by shashi on 24/02/05
				  AND A.STORE_TYPE = decode(:nd_store_type,'PS','PS','DR','DR','BO',A.STORE_TYPE)
			    GROUP BY SECTION_CODE, A.STORE_TYPE, STORE_CODE, A.ITEM_CODE
				ORDER BY SECTION_CODE, A.STORE_TYPE, STORE_CODE, A.ITEM_CODE; */ 


	/*-------------- Check for any error and No data found ----------------------*/

    if (OERROR) 
    {
		disp_message(ERR_MESG,"SELECT failed on RD_REQUEST\n");
        proc_exit();
	}
	/*------------------------- End of Error Check -------------------------------*/

    /* EXEC SQL OPEN ITEM_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )168;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_wing_code;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fr_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_section_code;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_store_type;
    sqlstm.sqhstl[5] = (unsigned int  )12;
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


	/*-------------- Check for any error and No data found ----------------------*/
	if (OERROR) 
    {
		disp_message(ERR_MESG,"OPEN failed on REQUEST_CUR\n");
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
		 print_hdr(),
	     print_col_heading(),
	     print_detl_rec(),
	     get_store_type_desc(),
	     get_item_desc(),
	     get_section_desc();

	 int fetch_appt_cur();

     int still_rec_left, posted = 0;

     print_rep_header(); /* once for the report */

     print_page_header();

	/*---------------------- read the first cursor record ----------------------*/
    still_rec_left = fetch_appt_cur();
    print_hdr();
    print_col_heading();
    line_no = 15;

    while ( still_rec_left )
	{
		strcpy(t_section_code.arr, nd_section_code.arr);
        strcpy(t_store_type.arr, h_store_type.arr);
        strcpy(t_store_code.arr, h_store_code.arr);
		
		print_detl_rec();
		
        line_no += 1;

        if (line_no >= MAX_LINES)
        {
			page_skip();
            print_col_heading(); 
		}
		/*--------------------------- read the next cursor record --------------------*/
        still_rec_left = fetch_appt_cur();

        if ((strcmp(nd_section_code.arr, t_section_code.arr) != 0) && 
		     still_rec_left )
	    {
			page_skip();
            print_col_heading(); 
	    } 
		else
	    if ((strcmp(h_store_type.arr, t_store_type.arr) != 0) 
			 && still_rec_left )
		{
	        if ( (line_no + 7 ) > 55 )
				page_skip();
			else
		    {
				fprintf(f1,"\n");
	            print_line('_',REP_WIDTH);
                print_store_type_hdr ();
                print_store_code_hdr ();
			}
			line_no += 7;
		}
        else
	    if ((strcmp(h_store_code.arr, t_store_code.arr) != 0) 
			 && still_rec_left )
		{
			if ( (line_no + 4 ) > 55 )
				page_skip();
			else
			{
				fprintf(f1,"\n");
                print_store_code_hdr ();
			}
			line_no += 4;
		}
/* -------------------------- processing for break group ---------------------*/
		if (line_no >= MAX_LINES)
		{
			page_skip();
            print_col_heading(); 
        }
      }
    fprintf(f1,"\n");
	print_line('_',REP_WIDTH);
    horz_skip(25);
    //fprintf(f1,"********   End of Report   *********");
	fprintf(f1,"********   %s   *********",loc_legend[20]);
	fprintf(f1,"%cE",ESC); /*for resetting to default mode */
    
}

/* -------------------------- End of Report function -------------------------*/

/*--------------------------- Page Skip --------------------------------------*/
page_skip()
{
	page_no += 1;
    line_no = 11;
    fprintf(f1,"\f");
	print_page_header();
    print_hdr();
}
/*--------------------------- End of Page Skip -------------------------------*/

/* fetches the next record from REQUEST_CUR     */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_appt_cur()
  {
     h_section_code.len               = 0;
	 h_store_type.len                 = 0;
     h_store_code.len                 = 0;
     h_item_code.len                  = 0;
     h_item_type_code.len             = 0;
     
	 h_section_code.arr[h_section_code.len]             = '\0';
	 h_store_type.arr[h_store_type.len]                 = '\0';
     h_store_code.arr[h_store_code.len]                 = '\0';
     h_item_code.arr [h_item_code.len]                  = '\0';
     h_item_type_code.arr[h_item_type_code.len]         = '\0';

     /* EXEC SQL FETCH ITEM_CUR INTO
			     :h_section_code,
				 :h_store_type,
			     :h_store_code,  
			     :h_item_code,
			     :h_actual_quantity; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 9;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )207;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&h_section_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&h_store_type;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&h_store_code;
     sqlstm.sqhstl[2] = (unsigned int  )7;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&h_item_code;
     sqlstm.sqhstl[3] = (unsigned int  )23;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&h_actual_quantity;
     sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
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



     if (OERROR) 
       {
          disp_message(ERR_MESG,"FETCH failed\n");
           proc_exit();
       }

     if (NO_DATA_FOUND)
       return 0;
	 
	 h_section_code.arr[h_section_code.len]             = '\0';
     h_store_type.arr[h_store_type.len]                 = '\0';
     h_store_code.arr[h_store_code.len]                 = '\0';
     h_item_code.arr [h_item_code.len]                  = '\0';
     h_item_type_code.arr[h_item_type_code.len]         = '\0';

     return 1;
  }
       
/* to print the detailed record with to horizontal summeries */
void print_detl_rec()
{
     get_item_desc ();

     fprintf(f1,"%-20s %-40s ", h_item_code.arr, h_item_desc.arr);
     fprintf(f1,"%-5s    ", h_item_units.arr);
     fprintf(f1,"%11.2lf   \n", h_actual_quantity);
   
}


/*----------------------------- Get Exam Desc --------------------------------*/
void get_item_desc ()
  {
     h_item_units.arr[0] = '\0';
     h_item_desc.arr[0]  = '\0';

     h_item_units.len    = 0;
     h_item_desc.len     = 0;

     
     /*if (strcmp(h_store_type.arr,"PS") == 0)
       {
          EXEC SQL SELECT LONG_DESC,STK_UOM_CODE
					 INTO :h_item_desc,:h_item_units
	                 FROM PS_ITEM
	                WHERE ITEM_CODE = :h_item_code;
       }
     else
       {
          EXEC SQL SELECT LONG_DESC,STK_UOM_CODE
					 INTO :h_item_desc, :h_item_units
					 FROM ST_ITEM
					WHERE  ITEM_CODE = :h_item_code;
       }*/ 

	/* EXEC SQL SELECT SHORT_DESC, UOM_CODE
	           INTO :h_item_desc, :h_item_units
	           FROM RD_ITEMS_LANG_VW
	          WHERE ITEM_CODE = :h_item_code
			  AND   LANGUAGE_ID = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_DESC ,UOM_CODE into :b0,:b1  from RD_ITEMS_LANG\
_VW where (ITEM_CODE=:b2 and LANGUAGE_ID=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )242;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&h_item_desc;
 sqlstm.sqhstl[0] = (unsigned int  )123;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&h_item_units;
 sqlstm.sqhstl[1] = (unsigned int  )15;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&h_item_code;
 sqlstm.sqhstl[2] = (unsigned int  )23;
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



     h_item_desc.arr [ h_item_desc.len ] = '\0';
     h_item_units.arr [ h_item_units.len ] = '\0';
  }
/*----------------------------- End Exam Desc -------------------------------*/

/*----------------------------- Get Section Desc ----------------------------*/
void get_section_desc()
  {
     h_section_desc.arr [0] = '\0';
     h_section_desc.len     = 0;

     /* EXEC SQL SELECT LONG_DESC
                INTO :h_section_desc
	            FROM RD_SECTION_LANG_VW
	           WHERE SECTION_CODE = :nd_section_code
			   AND   LANGUAGE_ID = :p_language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 9;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select LONG_DESC into :b0  from RD_SECTION_LANG_VW where\
 (SECTION_CODE=:b1 and LANGUAGE_ID=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )273;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
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
/*----------------------------- End Section Desc ----------------------------*/


/*------ gets the Clinic desc for the Clinic code ----------------------------*/
void get_store_type_desc()
  {
     h_store_type_desc.arr[0] = '\0';
     h_store_code_desc.arr[0] = '\0';

     h_store_type_desc.len    = 0;
     h_store_code_desc.len    = 0;
  
     if (strcmp(h_store_type.arr,"PS") == 0)
       //strcpy(h_store_type_desc.arr, "Pharmacy Stock");
	   strcpy(h_store_type_desc.arr, loc_legend[15]);
     else
       if (strcmp(h_store_type.arr,"ST") == 0)
         //strcpy(h_store_type_desc.arr, "General Stock");
		 strcpy(h_store_type_desc.arr, loc_legend[16]);
     
     /*if (strcmp(h_store_type.arr,"PS") == 0)
       {
          EXEC SQL SELECT LONG_DESC
                     INTO :h_store_code_desc
	                 FROM PS_STORE 
		   WHERE  STORE_CODE = :h_store_code;	
       }
     else
       {
          EXEC SQL SELECT SHORT_DESC
                     INTO :h_store_code_desc
	                 FROM  MM_STORE  //ST_STORE  changed by shashi on 24/02/2005
		   WHERE  STORE_CODE = :h_store_code;	
       }*/

     h_store_code_desc.arr[h_store_code_desc.len] = '\0';
     return;
  }
/*-------------------- End of clinic Desc ------------------------------------*/

/*------ gets the Wing desc for the Wing code ----------------------------*/
void get_wing_desc()
{
  
  h_wing_desc.arr [0]   = '\0';
  h_wing_desc.len       = 0;

   /* EXEC SQL SELECT LONG_DESC
			  INTO :h_wing_desc
			  FROM RD_WINGS_LANG_VW
			 WHERE OPERATING_FACILITY_ID = :nd_facility_id
			   AND WING_CODE = :nd_wing_code
			   AND LANGUAGE_ID = :p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_DESC into :b0  from RD_WINGS_LANG_VW where ((O\
PERATING_FACILITY_ID=:b1 and WING_CODE=:b2) and LANGUAGE_ID=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )300;
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

     if (strcmp(nd_fr_date.arr, "01/01/1800") == 0)
       //strcpy(fr_appt_date_desc, "LOWEST");
	   strcpy(fr_appt_date_desc, loc_legend[13]);
     else 
     {
	    //strcpy(fr_appt_date_desc, nd_fr_date.arr);
		init_date_temp_var();
		strcpy(date_convert.arr, nd_fr_date.arr);
		time_flag = 0;
        fun_change_loc_date();
		strcpy(fr_appt_date_desc, date_convert.arr);
     }
    
     if (strcmp(nd_to_date.arr, "31/12/4712") == 0)
       //strcpy(to_appt_date_desc, "HIGHEST");
	   strcpy(to_appt_date_desc, loc_legend[14]);
     else
	 {
       //strcpy(to_appt_date_desc, nd_to_date.arr);
	   init_date_temp_var();
	   strcpy(date_convert.arr, nd_to_date.arr);
	   time_flag = 0;
       fun_change_loc_date();
	   strcpy(to_appt_date_desc, date_convert.arr);
     }

     print_page_header();

	nd_store_desc.len       = 0;
	nd_store_desc.arr [0]   = '\0';

	if (!strcmp(nd_store_type.arr,"DR"))
		strcpy(nd_store_desc.arr, "DRUG");
	else if (!strcmp(nd_store_type.arr,"PS"))	
		strcpy(nd_store_desc.arr, "OTHER CONSUMABLES");


     fprintf(f1,VER);
     fprintf(f1,"\n\n\n\n");
     fprintf(f1,"        ");
   //fprintf(f1,"INPUT PARAMETERS :\n");
	 fprintf(f1,"%s :\n",loc_legend[4]);
     fprintf(f1,"        ");
     print_line('_',18); fprintf(f1 ,"\n");
	 fprintf(f1,"                ");
   //fprintf(f1,"REQUEST DATE     FROM  : %s\n", fr_appt_date_desc);
	 fprintf(f1,"%-25s : %s\n", loc_legend[5],fr_appt_date_desc);
     fprintf(f1,"                ");
   //fprintf(f1,"                 TO    : %s\n", to_appt_date_desc);
	 fprintf(f1,"%19s       : %s\n", loc_legend[6],to_appt_date_desc);
     fprintf(f1,"\n");
     fprintf(f1,"                ");
   //fprintf(f1,"WING CODE              : %s\n\n", nd_wing_code.arr);
	 fprintf(f1,"%-25s : %s\n\n", loc_legend[7],nd_wing_code.arr);
     fprintf(f1,"                ");
   //fprintf(f1,"SECTION CODE           : %s\n", nd_section_code.arr);
	 fprintf(f1,"%-25s : %s\n", loc_legend[8],nd_section_code.arr);
//     fprintf(f1,"                ");
//     fprintf(f1,"STORE TYPE             : %s\n", nd_store_desc.arr);
     fprintf(f1,"\f");

  }


/* to print page headers the header details */ 
void print_page_header()
{
	int hosp_nm_len, rep_title_len = 10, s1, s2;
	char v_rep_title[200];
	char nd_rep_title[200];
		
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

	if (!strcmp(nd_store_type.arr,"DR"))
		//strcpy(v_rep_title,REP_TITLE);
		strcpy(v_rep_title,loc_legend[1]);
	else if (!strcmp(nd_store_type.arr,"PS"))	
		//strcpy(v_rep_title,REP_TITLE_1);
		strcpy(v_rep_title,loc_legend[2]);

	
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-14);
	if (!strcmp(nd_store_type.arr,"DR"))
		//fprintf(f1,"%s",REP_TITLE);
		fprintf(f1,"%s",loc_legend[1]);
	
	if (!strcmp(nd_store_type.arr,"PS"))
		//fprintf(f1,"%s",REP_TITLE_1);
		fprintf(f1,"%s",loc_legend[2]);

//	fprintf(f1,"%s",REP_TITLE);
	
	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-10);
	//fprintf(f1,"PAGE :%4d\n",++page_no);
	fprintf(f1,"%s :%4d\n",loc_legend[3],++page_no);
    
	print_line('_',REP_WIDTH);
}

/*------------------------------ Name Header ---------------------------------*/
void print_hdr()
{
    get_section_desc();
	get_wing_desc();
	
  /*fprintf(f1,"Wing             : %-30s\n",h_wing_desc.arr);
    fprintf(f1,"Section          : %-4s %-30s\n",nd_section_code.arr, h_section_desc.arr);
    get_store_type_desc();
    fprintf(f1,"Store Type       : %-4s %-30s\n", h_store_type.arr, h_store_type_desc.arr);
    fprintf(f1,"Store            : %-4s %-30s\n", h_store_code.arr, h_store_code_desc.arr);*/

	fprintf(f1,"%-25s : %-30s\n", loc_legend[9],h_wing_desc.arr);
    fprintf(f1,"%-25s : %-4s %-30s\n", loc_legend[10],nd_section_code.arr, h_section_desc.arr);
    get_store_type_desc();
    fprintf(f1,"%-25s : %-4s %-30s\n", loc_legend[11],h_store_type.arr, h_store_type_desc.arr);
    fprintf(f1,"%-25s : %-4s %-30s\n", loc_legend[12],h_store_code.arr, h_store_code_desc.arr);
}
/*------------------------------ End Header ----------------------------------*/

print_store_type_hdr ()
{
	get_store_type_desc();
//	print_line('_',REP_WIDTH);
  //fprintf(f1,"Store Type       : %-4s %-30s\n", h_store_type.arr, h_store_type_desc.arr);
    fprintf(f1,"%-18s : %-4s %-30s\n", loc_legend[11],h_store_type.arr, h_store_type_desc.arr);
//	fprintf(f1,"\n");
}

print_store_code_hdr ()
{
	get_store_type_desc();
  //fprintf(f1,"Store            : %-4s %-30s\n", h_store_code.arr, h_store_code_desc.arr);
	fprintf(f1,"%-18s : %-4s %-30s\n", loc_legend[12],h_store_code.arr, h_store_code_desc.arr);
	print_line('_',REP_WIDTH);
}

/*------------------------------ column Header -------------------------------*/
/* print the heading */
void print_col_heading()
{
    print_line('_',REP_WIDTH);
  //fprintf(f1, "%-61s ","Item Code & Description");    
  //fprintf(f1, "Units   Qty Consumed\n");
    fprintf(f1, "%-61s ",loc_legend[17]);
	fprintf(f1, "%-8s%-12s\n",loc_legend[18],loc_legend[19]);
    print_line('_',REP_WIDTH);
}
/*--------------------------------- End Header -------------------------------*/

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
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ,\
 t_date ) ; IF :time_flag = 1 THEN :nd_loc_date := to_char ( t_date , 'DD/MM/Y\
YYY HH24:MI' ) ; :time_flag := 0 ; ELSE :nd_loc_date := to_char ( t_date , 'DD\
/MM/YYYY' ) ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )331;
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
  	   sm_populate_report_legend.fetch_legend(:nd_facility_id,:p_language_id,'RDRITCON.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin sm_populate_report_legend . fetch_legend ( :nd_facilit\
y_id , :p_language_id , 'RDRITCON.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )362;
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
       :l_translated_value := GET_LEGEND(LTRIM(RTRIM('RDRITCON.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
DRITCON.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )385;
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
