
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RD/RDRFLDBL.pc"
};


static unsigned int sqlctx = 1288577179;


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
            void  *sqhstv[8];
   unsigned int   sqhstl[8];
            int   sqhsts[8];
            void  *sqindv[8];
            int   sqinds[8];
   unsigned int   sqharm[8];
   unsigned int   *sqharc[8];
   unsigned short  sqadto[8];
   unsigned short  sqtdso[8];
} sqlstm = {12,8};

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

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,154,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,146,0,4,190,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,
0,0,
75,0,0,3,105,0,4,202,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
102,0,0,4,138,0,4,215,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
133,0,0,5,219,0,4,228,0,0,8,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,1,9,0,0,
180,0,0,6,0,0,30,336,0,0,0,0,0,1,0,
195,0,0,7,0,0,32,341,0,0,0,0,0,1,0,
210,0,0,8,95,0,4,357,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
233,0,0,9,105,0,4,365,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
260,0,0,10,105,0,4,373,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
287,0,0,11,322,0,6,442,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,3,3,0,0,2,9,0,0,
318,0,0,12,112,0,6,479,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
341,0,0,13,136,0,6,492,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/************************************************************************************/
/* Medicom-eHIS 4.1																	*/
/*																					*/
/************************************************************************************/
/*	Program Name     : RDRFLDBL														*/
/*																					*/
/*	Author           : Rajanish Nambiar												*/
/*																					*/
/*	Date Created     : 06th Jan, 2004												*/
/*																					*/
/*	Called Forms     :																*/
/*																					*/
/*	Input Parameters : PGM_ID, USER_ID/PASSWORD, SESSION_ID, PGM_DATE, FACILITY_ID	*/
/*                     FOLDER_NO, PRINTER_TYPE										*/
/*																					*/
/*	Function		 : This program print Folder Label with BarCode					*/
/*																					*/
/*																					*/
/*	Date	  			Modified By			Reason									*/
/*  --------------		----------------    ---------------------------------------	*/
/*  06th Jan, 2004 		Rajanish Nambiar    Created									*/
/*																					*/
/************************************************************************************/

#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1

#include <stdio.h>  
#include <string.h>
#include <gl.h>
#include <math.h>

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR nd_pgm_id			[9],
		uid_pwd				[122], /o Length changed from 91 to 122 o/
		nd_session_id		[16],
        nd_pgm_date			[13],
		nd_facility_id		[3],
		nd_no_copy			[2],
		nd_printer_type		[2],
		nd_folder_no		[21],

		d_patient_id		[21],
		d_facility_id		[3],
		d_storage_locn_code	[7],
		d_pat_name			[181],  /oLength changed from 61 to 181 for internationalisationo/
        d_nat_id            [21], 
		d_alt_id1_type      [5], 
		d_alt_id1_no        [21], 
		d_alt_id2_type      [5], 
		d_alt_id2_no        [21],
		
        d_id_val			[301],  /oLength changed from 37 to 301 for internationalisationo/
		d_date_of_birth		[11],
		d_national_id_num	[16],
		d_sex				[2],
		d_facility_nm       [301],  /oLength changed from 31 to 301 for internationalisationo/
		d_storage_nm		[301],  /oLength changed from 31 to 301 for internationalisationo/

		p_language_id		   [3]
	,   date_convert		   [21],
		nd_temp_date		   [21],
		nd_loc_date            [21],
		l_translated_value	   [200]; */ 
struct { unsigned short len; unsigned char arr[9]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[122]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[13]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[2]; } nd_no_copy;

struct { unsigned short len; unsigned char arr[2]; } nd_printer_type;

struct { unsigned short len; unsigned char arr[21]; } nd_folder_no;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[3]; } d_facility_id;

struct { unsigned short len; unsigned char arr[7]; } d_storage_locn_code;

struct { unsigned short len; unsigned char arr[181]; } d_pat_name;

struct { unsigned short len; unsigned char arr[21]; } d_nat_id;

struct { unsigned short len; unsigned char arr[5]; } d_alt_id1_type;

struct { unsigned short len; unsigned char arr[21]; } d_alt_id1_no;

struct { unsigned short len; unsigned char arr[5]; } d_alt_id2_type;

struct { unsigned short len; unsigned char arr[21]; } d_alt_id2_no;

struct { unsigned short len; unsigned char arr[301]; } d_id_val;

struct { unsigned short len; unsigned char arr[11]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[16]; } d_national_id_num;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[301]; } d_facility_nm;

struct { unsigned short len; unsigned char arr[301]; } d_storage_nm;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[200]; } l_translated_value;


		int i=0,
			time_flag = 0;

char   string_var [100];

float  mths,dys; 

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

FILE *f1;

char filename[150];

char loc_legend[999][200];

void proc_main(argc,argv)
int argc;
char *argv[];
{
	char  *command;
	int	  i;
	float yrs,days;
	int   iyrs,imths,idays;
	char  age[5];
	void get_type();


	if(argc < 7) {
		disp_message(ERR_MESG,"RDRFLDBL : Usage - RDRFLDBL uid/pwd request_num\n");
        proc_exit();
	}
		
	strcpy(filename,WORKING_DIR);
	strcat(filename,"RDRFLDBL.lis");

	if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
	{
		disp_message(ERR_MESG,"Error in opening output file...\n");
		proc_exit();
    }
	
	/*disp_message(ERR_MESG, "START");
	disp_message(ERR_MESG, argv[0]);
	disp_message(ERR_MESG, "0");
	disp_message(ERR_MESG, argv[1]);
	disp_message(ERR_MESG, "1");
	disp_message(ERR_MESG, argv[2]);
	disp_message(ERR_MESG, "2");
	disp_message(ERR_MESG, argv[3]);
	disp_message(ERR_MESG, "3");
	disp_message(ERR_MESG, argv[4]);
	disp_message(ERR_MESG, "4");
	disp_message(ERR_MESG, argv[5]);
	disp_message(ERR_MESG, "5");
	disp_message(ERR_MESG, argv[6]);
	disp_message(ERR_MESG, "6");
	disp_message(ERR_MESG, "END");*/

	strcpy(nd_pgm_id.arr,argv[0]);
    nd_pgm_id.len = strlen(nd_pgm_id.arr);
		
	strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);
		
	strcpy(nd_session_id.arr, argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr); 
	     
    strcpy(nd_pgm_date.arr, argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
	     
    strcpy(nd_facility_id.arr, argv[4]);
    nd_facility_id.len = strlen(nd_facility_id.arr); 
		 
	strcpy(nd_folder_no.arr,argv[5]);
    nd_folder_no.len = strlen(nd_folder_no.arr);
	
    strcpy(nd_printer_type.arr,argv[6]);
    nd_printer_type.len = strlen(nd_printer_type.arr);
	
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


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
    if (sqlca.sqlcode < 0) goto err_exit;
}


	
	set_meduser_role();

	/*Code Included for internationalization*/
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;

	fetch_legend_value();


    d_patient_id.arr[0]			= '\0';
	d_patient_id.len			= 0;
    d_pat_name.arr[0]			= '\0';
	d_pat_name.len				= 0;

    d_nat_id.arr[0]			= '\0'; 
    d_nat_id.len				= 0;
	d_alt_id1_type.arr[0]			= '\0'; 
	d_alt_id1_type.len				= 0;
	d_alt_id1_no.arr[0]			= '\0'; 
	d_alt_id1_no.len				= 0;
	d_alt_id2_type.arr[0]			= '\0'; 
	d_alt_id2_type.len				= 0;
	d_alt_id2_no.arr[0]			= '\0';
	d_alt_id2_no.arr[0]			= '\0';

    d_facility_id.arr[0]		= '\0';
	d_facility_id.len			= 0;
	d_storage_locn_code.arr[0]	= '\0';
	d_storage_locn_code.len		= 0;
	d_facility_nm.arr[0]		= '\0';
	d_facility_nm.len			= 0;
	d_storage_nm.arr[0]			= '\0';
	d_storage_nm.len			= 0;

	/* EXEC SQL select folder_no, patient_id, facility_id, storage_locn_code
			   into :nd_folder_no, :d_patient_id, :d_facility_id, :d_storage_locn_code
               from rd_records_index
			  where facility_id = :nd_facility_id
			    and folder_no   = :nd_folder_no; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select folder_no ,patient_id ,facility_id ,storage_locn_code\
 into :b0,:b1,:b2,:b3  from rd_records_index where (facility_id=:b4 and folder\
_no=:b0)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_folder_no;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_storage_locn_code;
 sqlstm.sqhstl[3] = (unsigned int  )9;
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
 sqlstm.sqhstv[5] = (         void  *)&nd_folder_no;
 sqlstm.sqhstl[5] = (unsigned int  )23;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	if(NO_DATA_FOUND)
	{
		disp_message(ERR_MESG,"No Data found in RD_RECORDS_INDEX");
		proc_exit();
    }

	/* EXEC SQL select acc_entity_name
			   into d_facility_nm   
	           from sy_acc_entity_LANG_VW
			  where acc_entity_id = :d_facility_id
			  AND   LANGUAGE_ID = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select acc_entity_name into :b0  from sy_acc_entity_LANG_VW \
where (acc_entity_id=:b1 and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )75;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_facility_nm;
 sqlstm.sqhstl[0] = (unsigned int  )303;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


	
	if(NO_DATA_FOUND)
	{
		disp_message(ERR_MESG,"No Data found in SY_ACC_ENTITY");
		proc_exit();
    }

	
	/* EXEC SQL select long_desc 	
			   into d_storage_nm		
	           from rd_records_store_LANG_VW
			  where operating_facility_id = :nd_facility_id
			    and storage_locn_code     = :d_storage_locn_code
				AND LANGUAGE_ID = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from rd_records_store_LANG_VW whe\
re ((operating_facility_id=:b1 and storage_locn_code=:b2) and LANGUAGE_ID=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )102;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_storage_nm;
 sqlstm.sqhstl[0] = (unsigned int  )303;
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
 sqlstm.sqhstv[2] = (         void  *)&d_storage_locn_code;
 sqlstm.sqhstl[2] = (unsigned int  )9;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


					
	if(NO_DATA_FOUND)
	{
		disp_message(ERR_MESG,"No Data found in RD_RECORDS_STORE");
		proc_exit();
    }
	
	/* EXEC SQL SELECT DECODE(:p_language_id,'en',SHORT_NAME,SHORT_NAME_LOC_LANG) , 
					NATIONAL_ID_NUM, ALTERNATE_ID_TYPE, ALTERNATE_ID_NUM, ALTERNATE_ID2_TYPE, ALTERNATE_ID2_NUM
					//, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),SEX, NATIONAL_ID_NUM 
			   INTO :d_pat_name, 
				    d_nat_id, d_alt_id1_type, d_alt_id1_no, d_alt_id2_type, d_alt_id2_no
					//, :d_date_of_birth, :d_sex, :d_national_id_num   
			   FROM MP_PATIENT_MAST //, MP_PARAM
			  WHERE PATIENT_ID = :d_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,SHORT_NAME_LOC_LANG) ,NATI\
ONAL_ID_NUM ,ALTERNATE_ID_TYPE ,ALTERNATE_ID_NUM ,ALTERNATE_ID2_TYPE ,ALTERNAT\
E_ID2_NUM into :b1,:b2,:b3,:b4,:b5,:b6  from MP_PATIENT_MAST where PATIENT_ID=\
:b7";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )133;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_language_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_pat_name;
 sqlstm.sqhstl[1] = (unsigned int  )183;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_nat_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_alt_id1_type;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_alt_id1_no;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_alt_id2_type;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_alt_id2_no;
 sqlstm.sqhstl[6] = (unsigned int  )23;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_patient_id;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



    d_patient_id.arr[d_patient_id.len]			= '\0';
    d_pat_name.arr[d_pat_name.len]				= '\0';
    d_nat_id.arr[d_nat_id.len]					= '\0'; 
	d_alt_id1_type.arr[d_alt_id1_type.len]		= '\0'; 
	d_alt_id1_no.arr[d_alt_id1_no.len]			= '\0'; 
	d_alt_id2_type.arr[d_alt_id2_type.len]		= '\0'; 
	d_alt_id2_no.arr[d_alt_id2_no.len]			= '\0';
    nd_folder_no.arr[nd_folder_no.len]					= '\0';
	d_facility_id.arr[d_facility_id.len]				= '\0';
	d_storage_locn_code.arr[d_storage_locn_code.len]    = '\0';
	d_facility_nm.arr[d_facility_nm.len]				= '\0';
	d_storage_nm.arr[d_storage_nm.len]					= '\0';

    /*yrs= mths= days= imths= iyrs= idays= 0;
    EXEC SQL SELECT ABS(MONTHS_BETWEEN(SYSDATE,TO_DATE(:d_date_of_birth,'DD/MM/YYYY')))
			   INTO :mths
	           FROM DUAL;
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
			EXEC SQL SELECT (SYSDATE - TO_DATE(:d_date_of_birth,'DD/MM/YYYY'))
					   INTO :dys
	                   FROM DUAL;
			idays = dys;
        }
		if(iyrs != 0)
			sprintf(age,"%dY",iyrs);
        else if(imths != 0)
            sprintf(age,"%dM",imths);
        else
            sprintf(age,"%dD",idays);
	}*/

get_type();

  //fprintf(f1,"Folder No.  : %s \n",nd_folder_no.arr);
	fprintf(f1,"%-12s: %s \n",loc_legend[1],nd_folder_no.arr);
	print_barcode(f1, nd_folder_no.arr, 0, 0, 40, 150, atoi(nd_printer_type.arr));
	fprintf(f1,"\n");
  //fprintf(f1,"Patient ID  : %s \n",d_patient_id.arr);
	fprintf(f1,"%-12s: %s \n",loc_legend[2],d_patient_id.arr);
  //fprintf(f1,"      Name  : %s \n",d_pat_name.arr);
	fprintf(f1,"%11s : %s \n",loc_legend[3],d_pat_name.arr);

if (strlen(d_nat_id.arr) > 0 ) {
	   fprintf(f1,"%-12s: %s \n",d_id_val.arr, d_nat_id.arr);
}
else if (strlen(d_nat_id.arr) == 0 ) {

	if (strlen(d_alt_id1_no.arr) > 0 ) {
	   fprintf(f1,"%-12s: %s \n",d_id_val.arr, d_alt_id1_no.arr);
    }
	else if (strlen(d_alt_id1_no.arr) == 0 )  {
		if (strlen(d_alt_id2_no.arr) > 0 ) {
			fprintf(f1,"%-12s: %s \n",d_id_val.arr, d_alt_id2_no.arr);
		}
	}
} 


  //fprintf(f1,"Facility    : %s \n",d_facility_nm.arr);
	fprintf(f1,"%-12s: %s \n",loc_legend[4],d_facility_nm.arr);
  //fprintf(f1,"Storage Locn: %s \n",d_storage_nm.arr);
	fprintf(f1,"%-12s: %s \n",loc_legend[5],d_storage_nm.arr);
		
	fclose(f1);
	
	
	PrintDocument
	(
		uid_pwd.arr,
		nd_session_id.arr,
		nd_facility_id.arr,
		"RD",
		"RDRFLDBL",
		filename,
		"O",
		" ",
		1,
		1,
		99
	);
			
	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )180;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )195;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ORA_MESG,"Oracle error occured...\n");
    sprintf(string_var,"%s\n",sqlca.sqlerrm.sqlerrmc);
    disp_message(ORA_MESG,string_var);
    proc_exit();

}

void get_type()
{
  
  d_id_val.arr [0]   = '\0';
  d_id_val.len       = 0;

 if (strlen(d_nat_id.arr) > 0 ) {

	   /* EXEC SQL SELECT NAT_ID_PROMPT
			  INTO :d_id_val
			  FROM MP_PARAM_LANG_VW
			 WHERE MODULE_ID = 'MP'
			 AND   LANGUAGE_ID = :p_language_id ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NAT_ID_PROMPT into :b0  from MP_PARAM_LANG_VW wher\
e (MODULE_ID='MP' and LANGUAGE_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )210;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_id_val;
    sqlstm.sqhstl[0] = (unsigned int  )303;
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


 }
 else if (strlen(d_nat_id.arr) == 0 ) {
     if (strlen(d_alt_id1_no.arr) > 0 ) {
			  /* EXEC SQL SELECT SHORT_DESC
			  INTO :d_id_val
			  FROM MP_ALTERNATE_ID_TYPE_LANG_VW
			 WHERE ALT_ID_TYPE = :d_alt_id1_type 
			 AND   LANGUAGE_ID = :p_language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select SHORT_DESC into :b0  from MP_ALTERNATE_ID_TYPE_LA\
NG_VW where (ALT_ID_TYPE=:b1 and LANGUAGE_ID=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )233;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_id_val;
     sqlstm.sqhstl[0] = (unsigned int  )303;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_alt_id1_type;
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

        
     }
	 else if (strlen(d_alt_id1_no.arr) == 0 ) {
	      if (strlen(d_alt_id2_no.arr) > 0 ) {
			  /* EXEC SQL SELECT SHORT_DESC
			  INTO :d_id_val
			  FROM MP_ALTERNATE_ID_TYPE_LANG_VW
			  WHERE ALT_ID_TYPE = :d_alt_id2_type
			  AND   LANGUAGE_ID = :p_language_id ; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select SHORT_DESC into :b0  from MP_ALTERNATE_ID_TYPE_LA\
NG_VW where (ALT_ID_TYPE=:b1 and LANGUAGE_ID=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )260;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_id_val;
     sqlstm.sqhstl[0] = (unsigned int  )303;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_alt_id2_type;
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


	 
	      }
	 }
 }

   

/*   if ((d_nat_id.arr != '') &&  (d_alt_id1_no.arr=='') &&  (d_alt_id2_no.arr == '')) {
	   EXEC SQL SELECT NAT_ID_PROMPT
			  INTO :d_id_val
			  FROM MP_PARAM_LANG_VW
			 WHERE MODULE_ID = 'MP'
			 AND   LANGUAGE_ID = :p_langauge_id ;
   }
   else if (d_alt_id1_no.arr != '' && d_nat_id.arr == '' ) {
	   EXEC SQL SELECT SHORT_DESC
			  INTO :d_id_val
			  FROM MP_ALTERNATE_ID_TYPE_LANG_VW
			 WHERE ALT_ID_TYPE = :d_alt_id1_no
			 AND   LANGUAGE_ID = :p_language_id ;	
   }
   else if (d_alt_id2_no.arr != '' && d_nat_id.arr == '' && d_alt_id1_no.arr == '' ) {
	   EXEC SQL SELECT SHORT_DESC
			  INTO :d_id_val
			  FROM MP_ALTERNATE_ID_TYPE_LANG_VW
			 WHERE ALT_ID_TYPE = :d_alt_id2_no 
			 AND   LANGUAGE_ID = :p_language_id;	
   }

*/
  d_id_val.arr [ d_id_val.len ] = '\0';
  //return;
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
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . CONVERT_TO_LOC\
ALE_DATE ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ,\
 t_date ) ; IF :time_flag = 1 THEN :nd_loc_date := to_char ( t_date , 'DD/MM/Y\
YYY HH24:MI' ) ; :time_flag := 0 ; ELSE :nd_loc_date := to_char ( t_date , 'DD\
/MM/YYYY' ) ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )287;
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
  	   sm_populate_report_legend.fetch_legend(:nd_facility_id,:p_language_id,'RDRFLDBL.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin sm_populate_report_legend . fetch_legend ( :nd_facilit\
y_id , :p_language_id , 'RDRFLDBL.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )318;
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
       :l_translated_value := GET_LEGEND(LTRIM(RTRIM('RDRFLDBL.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
DRFLDBL.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )341;
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
