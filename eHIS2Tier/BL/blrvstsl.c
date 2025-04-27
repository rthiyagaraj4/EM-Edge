
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
           char  filnam[20];
};
static const struct sqlcxp sqlfpn =
{
    19,
    "C:\\proc\\blrvstsl.pc"
};


static unsigned long sqlctx = 36418923;


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
            void  *sqhstv[10];
   unsigned int   sqhstl[10];
            int   sqhsts[10];
            void  *sqindv[10];
            int   sqinds[10];
   unsigned int   sqharm[10];
   unsigned int   *sqharc[10];
   unsigned short  sqadto[10];
   unsigned short  sqtdso[10];
} sqlstm = {10,10};

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

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,205,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,103,0,4,215,0,0,4,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,
67,0,0,3,154,0,4,223,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,97,0,0,1,9,0,0,1,
9,0,0,
106,0,0,4,102,0,2,248,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
129,0,0,5,197,0,4,271,0,0,7,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
172,0,0,6,321,0,4,294,0,0,10,1,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,3,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
227,0,0,7,70,0,4,333,0,0,2,1,0,1,0,1,9,0,0,2,4,0,0,
250,0,0,8,86,0,4,345,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
277,0,0,9,94,0,4,356,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
304,0,0,10,76,0,4,365,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
327,0,0,11,75,0,4,375,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
350,0,0,12,145,0,4,384,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
381,0,0,13,204,0,4,414,0,0,6,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
420,0,0,14,201,0,4,433,0,0,7,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
463,0,0,15,0,0,30,499,0,0,0,0,0,1,0,
478,0,0,16,0,0,32,531,0,0,0,0,0,1,0,
493,0,0,17,81,0,4,545,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
516,0,0,18,401,0,6,569,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
};


/******************************************************************************/
/* OCS MEDICOM VER 1.0                                                        */
/******************************************************************************/
/* PROGRAM NAME     : blrvstsl.pc                                             */ 
/* AUTHOR           : A.JEEVARATHNAM                                          */
/* DATE WRITTEN     : 01-APR-1998                                             */
/*                                                                            */
/* CALLED FROM      : Visit Registration Form                                 */
/*                                                                            */
/* INPUT PARAMETERS : USER_ID/PASSWORD                                        */
/*                  : SESSION_ID (Ignored)                                    */
/*                  : PGM_DATE   (Ignored)                                    */
/*                  : ADMISSION NO                                            */
/*                  : LAST ADMISSION NO                                       */
/*                  : NOTES LOCATION CODE                                     */
/*                  : CURRENT STATUS                                          */
/*                                                                            */
/*                                                                            */
/* TABLES ACCESSED  : OP_VIST                                                 */
/*        ACCESSED  : MP_PATIENT_MAST                                         */
/*        ACCESSED  : OP_VISIT_TYPE                                           */
/*        ACCESSED  : OP_CLINIC                                                 */
/*                                                                            */
/* OUTPUT FILE      : blrvstsl.lis                                            */
/*                                                                            */
/*                                                                            */
/* FUNCTION         : This program prints Non Paying Patients Visit Slip      */
/*                                                                            */
/*                                                                            */
/* VERSION          : 1.10.01                                                 */
/* MODIFICATIONS    :                                                         */
/*                                                                            */
/******************************************************************************/

/*
#define DEBUG
*/


#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define ESC 0x1B
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <bl.h>  
//#include <op.h>

#define INIT_MESG       "Non Paying Patients Slip Printing ..."
#define ONLINE_PRINTING 1

    
/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd                         [42],

	    /o from OP_VISIT      o/
	    d_patient_id                        [21],
	    d_visit_regn_date_time              [20],

		nd_session_id                       [16],
		nd_pgm_date                         [16],
		nd_sys_date							[16],
		
		d_trx_based		                    [2],
        d_printer_type                      [2],

		d_blng_grp_id                       [3],
		nd_facility_id						[3],
		nd_exemp_upto_date					[15],
		d_cashfacility_id					[3],
		nd_calling_pgm_id					[10],
		nd_cahier_position					[100],
		nd_file_name						[100],
	    
	    /o from MP_PATIENT_MAST  o/
	    d_sex                               [2],
	    d_dob                               [15],
	    d_short_name                        [61],
	    d_first_name_loc_lang               [21],
	    d_last_name_loc_lang                [21],
	    d_mar_status_code                   [2],
		d_added_by_id						[20],
		nd_cashier_name						[100],
	    d_ref_episode_type			[3],
	    d_ref_episode_id			[10],
	    d_ref_visit_id			[3],
	    d_hosp_fee_exm_yn			[3],
	    d_med_fee_exm_yn			[3],
	    d_national_id_num                   [16],

		/o from OP_CLINIC  o/	    
		d_clinic_code                       [5],
		d_clinic_desc                       [16], 

		/o from OP_VISIT_TYPE  o/	    
		d_visit_type_code                   [3],
		d_visit_type_desc                   [16],
		
 
	    /o from MP_MARITAL_STATUS  o/
	    d_mar_status_desc                   [16],

	    /o from NT_LOCATION  o/
	    d_note_loc_desc                     [16],

	    /o dummy for Current Status Desc o/
	    d_current_status_desc               [16],

	    /o Parameters passed    o/
	    d_episode_id                        [9],
	    d_visit_id                          [5],
	    
	    /o from SY_ACC_ENTITY o/
	    d_header                            [61]; */ 
struct { unsigned short len; unsigned char arr[42]; } uid_pwd;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[20]; } d_visit_regn_date_time;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[16]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[16]; } nd_sys_date;

struct { unsigned short len; unsigned char arr[2]; } d_trx_based;

struct { unsigned short len; unsigned char arr[2]; } d_printer_type;

struct { unsigned short len; unsigned char arr[3]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[15]; } nd_exemp_upto_date;

struct { unsigned short len; unsigned char arr[3]; } d_cashfacility_id;

struct { unsigned short len; unsigned char arr[10]; } nd_calling_pgm_id;

struct { unsigned short len; unsigned char arr[100]; } nd_cahier_position;

struct { unsigned short len; unsigned char arr[100]; } nd_file_name;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[15]; } d_dob;

struct { unsigned short len; unsigned char arr[61]; } d_short_name;

struct { unsigned short len; unsigned char arr[21]; } d_first_name_loc_lang;

struct { unsigned short len; unsigned char arr[21]; } d_last_name_loc_lang;

struct { unsigned short len; unsigned char arr[2]; } d_mar_status_code;

struct { unsigned short len; unsigned char arr[20]; } d_added_by_id;

struct { unsigned short len; unsigned char arr[100]; } nd_cashier_name;

struct { unsigned short len; unsigned char arr[3]; } d_ref_episode_type;

struct { unsigned short len; unsigned char arr[10]; } d_ref_episode_id;

struct { unsigned short len; unsigned char arr[3]; } d_ref_visit_id;

struct { unsigned short len; unsigned char arr[3]; } d_hosp_fee_exm_yn;

struct { unsigned short len; unsigned char arr[3]; } d_med_fee_exm_yn;

struct { unsigned short len; unsigned char arr[16]; } d_national_id_num;

struct { unsigned short len; unsigned char arr[5]; } d_clinic_code;

struct { unsigned short len; unsigned char arr[16]; } d_clinic_desc;

struct { unsigned short len; unsigned char arr[3]; } d_visit_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_visit_type_desc;

struct { unsigned short len; unsigned char arr[16]; } d_mar_status_desc;

struct { unsigned short len; unsigned char arr[16]; } d_note_loc_desc;

struct { unsigned short len; unsigned char arr[16]; } d_current_status_desc;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[61]; } d_header;


	    /* Calculated fields */
		

		/* VARCHAR  nd_user_name[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } nd_user_name;


int    nd_trunc_total_months;
float  nd_total_months,
       nd_days_old;

char   string_var[70];
char   filename[150];
char	nd_online_yn[1];
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

FILE *f1;

int page_no,
    nd_age_years  = 0,
    nd_age_months = 0,
    nd_age_days   = 0;

char outstr[100];

char  *format_amt();      /* function in comma.c   */

char  loc_concat_str[65],
      eng_concat_str[65];

void proc_main(argc,argv)
int argc;

char *argv[];
{
   
  if(argc < 6) 
  {
      disp_message(ERR_MESG,"blrvstsl : Usage - blrvstsl userid/password Sess_ID, Pgm_date, Episode_id,Visit_id");
      proc_exit();
  }


    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(nd_session_id.arr, argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr); 

    strcpy(nd_pgm_date.arr, argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr); 

    strcpy(nd_facility_id.arr, argv[4]);
    nd_facility_id.len = strlen(nd_facility_id.arr);

    strcpy(nd_calling_pgm_id.arr, argv[5]);
    nd_calling_pgm_id.len = strlen(nd_calling_pgm_id.arr);
 
    if (argc > 6) 
   		strcpy(nd_file_name.arr,argv[6]);
	else 
		strcpy(nd_file_name.arr,"blrvstsl.lis");

	   nd_file_name.len = strlen(nd_file_name.arr);
	   nd_file_name.arr[nd_file_name.len] = '\0';
    

      strcpy(filename,WORKING_DIR);
      strcat(filename,nd_file_name.arr);

    if( (f1=fopen(filename,"w")) == NULL) 
	{
 	    disp_message(ERR_MESG,"Error in opening output file...");
	    proc_exit();
    }



	fprintf(f1,"%c(s11H",ESC);


    
    strcpy(outstr,"CONNECT failed for Oracle"); 

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

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
    sqlstm.sqhstl[0] = (unsigned int  )44;
    sqlstm.sqhsts[0] = (         int  )44;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



    set_meduser_role();

    if (OERROR) {
       disp_message ( ORA_MESG, "USERID/PASSWORD failed to Connect");
       proc_exit();
   }

                                                         
 	/* EXEC SQL SELECT to_char(sysdate,'dd/mm/yyyy HH24:MI'),substr(:uid_pwd,1,INSTR(:uid_pwd,'/')-1) into 
        	      nd_sys_date,nd_user_name from dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select to_char(sysdate,'dd/mm/yyyy HH24:MI') ,substr(:b0,1,\
(INSTR(:b0,'/')-1)) into :b2,:b3  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )44;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_sys_date;
  sqlstm.sqhstl[2] = (unsigned int  )18;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_user_name;
  sqlstm.sqhstl[3] = (unsigned int  )33;
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


        	      
        	      
  	nd_user_name.arr[nd_user_name.len] = '\0';
	nd_sys_date.arr[nd_sys_date.len] = '\0';  
	
	
    /* EXEC SQL SELECT  PARAM1,PARAM2, 
					 PARAM3,
					 PARAM30
              INTO   :d_episode_id,
					 :d_visit_id, 
					 :nd_exemp_upto_date,
					 :nd_online_yn
              FROM   SY_PROG_PARAM 
              WHERE    PGM_ID        = 'BLRVSTSL' 
	            AND    SESSION_ID    = to_number(:nd_session_id)
	            AND    PGM_DATE      = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM30 into :b0,:b1,:b2,:\
b3  from SY_PROG_PARAM where ((PGM_ID='BLRVSTSL' and SESSION_ID=to_number(:b4)\
) and PGM_DATE=:b5)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )67;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_visit_id;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_exemp_upto_date;
    sqlstm.sqhstl[2] = (unsigned int  )17;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)nd_online_yn;
    sqlstm.sqhstl[3] = (unsigned int  )1;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[4] = (unsigned int  )18;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[5] = (unsigned int  )18;
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




    if (NODATAFOUND)
	   {
	       strcpy(outstr,"NO_DATA_FOUND for SY_PROG_PARAM"); 
           goto err_exit;
       	   }

    if (OERROR) 
	   {
	       disp_message ( ORA_MESG, "SELECT failed, for SY_PROG_PARAM");
           goto err_exit;
	   }

    /* EXEC SQL DELETE SY_PROG_PARAM
		   WHERE  PGM_ID      =  'BLRVSTSL' 
		   AND    SESSION_ID  = to_number(:nd_session_id)
		   AND    PGM_DATE    = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRVSTSL' and\
 SESSION_ID=to_number(:b0)) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )106;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[1] = (unsigned int  )18;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}




   if (OERROR) {
      disp_message ( ORA_MESG, "DELETE failed on SY_PROG_PARAM");
      proc_exit();
      }

   if (NODATAFOUND) {
      disp_message ( ERR_MESG, "No Data Found in the SY_PROG_PARAM");
      proc_exit();
      }



	/*------------------Start of Select Statements --------------------------*/

    /*  Select from OP_VISIT  */

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT PATIENT_ID,   /o PATIENT ID  o/
	                CLINIC_CODE, 
				    TO_CHAR(VISIT_REGN_DATE_TIME,'DD/MM/YYYY HH24:MI'),
					VISIT_TYPE_CODE 
      	       INTO :d_patient_id,
			        :d_clinic_code,   
			        :d_visit_regn_date_time,
					:d_visit_type_code 
         	   FROM OP_VISIT      
	           WHERE  EPISODE_ID = :d_episode_id AND
		              VISIT_ID   = :d_visit_id   AND
					  FACILITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PATIENT_ID ,CLINIC_CODE ,TO_CHAR(VISIT_REGN_DATE_T\
IME,'DD/MM/YYYY HH24:MI') ,VISIT_TYPE_CODE into :b0,:b1,:b2,:b3  from OP_VISIT\
 where ((EPISODE_ID=:b4 and VISIT_ID=:b5) and FACILITY_ID=:b6)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )129;
    sqlstm.selerr = (unsigned short)1;
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
    sqlstm.sqhstv[1] = (         void  *)&d_clinic_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_visit_regn_date_time;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_visit_type_code;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_visit_id;
    sqlstm.sqhstl[5] = (unsigned int  )7;
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

 
		    
	    d_patient_id.arr[d_patient_id.len]                      = '\0';
  	    d_visit_regn_date_time.arr[d_visit_regn_date_time.len]  = '\0';
		d_clinic_code.arr[d_clinic_code.len]                    = '\0';
        d_visit_type_code.arr[d_visit_type_code.len]            = '\0';

strcpy(g_facility_id,nd_facility_id.arr);     

    /* Select from MP_PATIENT_MAST    */

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT SHORT_NAME,
		       TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),  
		       TO_CHAR(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)),
		       TO_CHAR(TRUNC(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH))),
		       SEX,                    /o SEX                 o/
		       FIRST_NAME_LOC_LANG,    /o FIRST_NAME_LOC_LANG o/
		       LAST_NAME_LOC_LANG,     /o LAST_NAME_LOC_LANG  o/
		       NATIONAL_ID_NUM,        /o NATIONAL_ID_NUM     o/
		       MAR_STATUS_CODE

	     INTO  :d_short_name,
		       :d_dob,
		       :nd_total_months,
		       :nd_trunc_total_months,
		       :d_sex,        
		       :d_first_name_loc_lang,
		       :d_last_name_loc_lang,
		       :d_national_id_num,
		       :d_mar_status_code

	     FROM   MP_PATIENT_MAST
	     WHERE  PATIENT_ID = :d_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_NAME ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,T\
O_CHAR(MONTHS_BETWEEN(SYSDATE,DATE_OF_BIRTH)) ,TO_CHAR(TRUNC(MONTHS_BETWEEN(SY\
SDATE,DATE_OF_BIRTH))) ,SEX ,FIRST_NAME_LOC_LANG ,LAST_NAME_LOC_LANG ,NATIONAL\
_ID_NUM ,MAR_STATUS_CODE into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  from MP_PAT\
IENT_MAST where PATIENT_ID=:b9";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )172;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_short_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_dob;
    sqlstm.sqhstl[1] = (unsigned int  )17;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_total_months;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(float);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_trunc_total_months;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_sex;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_first_name_loc_lang;
    sqlstm.sqhstl[5] = (unsigned int  )23;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_last_name_loc_lang;
    sqlstm.sqhstl[6] = (unsigned int  )23;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_national_id_num;
    sqlstm.sqhstl[7] = (unsigned int  )18;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_mar_status_code;
    sqlstm.sqhstl[8] = (unsigned int  )4;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[9] = (unsigned int  )23;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



    d_short_name.arr[d_short_name.len]                     = '\0';
    d_dob.arr[d_dob.len]                                   = '\0';
    d_sex.arr[d_sex.len]                                   = '\0';
    d_first_name_loc_lang.arr[d_first_name_loc_lang.len]   = '\0';
    d_last_name_loc_lang.arr[d_last_name_loc_lang.len]     = '\0';
    d_national_id_num.arr[d_national_id_num.len]           = '\0';
    d_mar_status_code.arr[d_mar_status_code.len]           = '\0';

    
  /* calculating the age in terms of days, months and days */
  nd_age_years  = (int) floor(nd_trunc_total_months / 12.0);
  nd_age_months = (int) floor(nd_trunc_total_months - (nd_age_years * 12)); 

  if ((nd_age_years == 0) && (nd_age_months == 0)){
  /* if the patient is less than a month old */
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT TRUNC(SYSDATE - TO_DATE(:d_dob, 'DD/MM/YYYY'))
               INTO :nd_days_old
               FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TRUNC((SYSDATE-TO_DATE(:b0,'DD/MM/YYYY'))) into :b\
1  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )227;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_dob;
    sqlstm.sqhstl[0] = (unsigned int  )17;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_days_old;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


    nd_age_days = (int) nd_days_old;
   }
   /* if the patient is more than a month old */
   else nd_age_days   = (int) floor((nd_total_months - nd_trunc_total_months) * 31);

/*  Fetch all description Fields    */
    

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT SHORT_DESC   
		   	   INTO :d_clinic_desc
          	   FROM OP_CLINIC       
	           WHERE CLINIC_CODE  = :d_clinic_code
			   and  FACILITY_ID  = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_DESC into :b0  from OP_CLINIC where (CLINIC_\
CODE=:b1 and FACILITY_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )250;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_clinic_desc;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_clinic_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
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

 
	    
    d_clinic_desc.arr[d_clinic_desc.len]  = '\0';



    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT SHORT_DESC  
		   	   INTO :d_visit_type_desc
          	   FROM OP_VISIT_TYPE   
	           WHERE FACILITY_ID = :nd_facility_id and
			   VISIT_TYPE_CODE  = :d_visit_type_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_DESC into :b0  from OP_VISIT_TYPE where (FAC\
ILITY_ID=:b1 and VISIT_TYPE_CODE=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )277;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_visit_type_desc;
    sqlstm.sqhstl[0] = (unsigned int  )18;
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
    sqlstm.sqhstv[2] = (         void  *)&d_visit_type_code;
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

 
	    
	    d_visit_type_desc.arr[d_visit_type_desc.len]  = '\0';
        
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT SHORT_DESC     
	           INTO   :d_mar_status_desc    
	           FROM   MP_MARITAL_STATUS 
	           WHERE  MAR_STATUS_CODE = :d_mar_status_code ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_DESC into :b0  from MP_MARITAL_STATUS where \
MAR_STATUS_CODE=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )304;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_mar_status_desc;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_mar_status_code;
    sqlstm.sqhstl[1] = (unsigned int  )4;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



        d_mar_status_desc.arr[d_mar_status_desc.len]   = '\0';
  
        
    
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT ACC_ENTITY_NAME
	           INTO :d_header
	           FROM SY_ACC_ENTITY
			   WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME into :b0  from SY_ACC_ENTITY where\
 ACC_ENTITY_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )327;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_header;
    sqlstm.sqhstl[0] = (unsigned int  )63;
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



    d_header.arr[d_header.len]                              = '\0'; 
	          
        
        /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 
 
        /* EXEC SQL SELECT  BLNG_GRP_ID
		           INTO  :d_blng_grp_id
	               FROM  BL_VISIT_FIN_DTLS 
		           WHERE OPERATING_FACILITY_ID = :nd_facility_id
				     AND EPISODE_ID    = to_number(:d_episode_id) 
		             AND VISIT_ID      = to_number(:d_visit_id); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 10;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select BLNG_GRP_ID into :b0  from BL_VISIT_FIN_DTLS w\
here ((OPERATING_FACILITY_ID=:b1 and EPISODE_ID=to_number(:b2)) and VISIT_ID=t\
o_number(:b3))";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )350;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_id;
        sqlstm.sqhstl[0] = (unsigned int  )5;
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
        sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
        sqlstm.sqhstl[2] = (unsigned int  )11;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
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
        if (sqlca.sqlcode < 0) goto err_exit;
}


	 
    
       d_blng_grp_id.arr[d_blng_grp_id.len]                = '\0';

    		 
       if (NODATAFOUND) 
	   {
		   strcpy(outstr,"NO_DATA_FOUND for BL_VISIT_FIN_DTLS"); 
           goto err_exit;
	   }

    if (OERROR) 
	   {
           strcpy(outstr,"SELECT failed for BL_VISIT_FIN_DTLS"); 
           goto err_exit;
	   }
    

	 d_ref_episode_type.arr[0] ='\0';
	 d_ref_episode_type.len=0;
	 d_ref_episode_id.arr[0] ='\0';
	 d_ref_episode_id.len=0;
	 d_ref_visit_id.arr[0] ='\0';
	 d_ref_visit_id.len=0;
      /* EXEC SQL SELECT  EXM_REF_EPISODE_TYPE,EXM_REF_EPISODE_ID,EXM_REF_VISIT_ID
		 INTO  :d_ref_episode_type,:d_ref_episode_id,:d_ref_visit_id
	         FROM  BL_VISIT_EXM_FIN_DTLS 
		 WHERE OPERATING_FACILITY_ID = :nd_facility_id
		 AND EPISODE_ID    = to_number(:d_episode_id) 
		 AND VISIT_ID      = to_number(:d_visit_id); */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 10;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select EXM_REF_EPISODE_TYPE ,EXM_REF_EPISODE_ID ,EXM_RE\
F_VISIT_ID into :b0,:b1,:b2  from BL_VISIT_EXM_FIN_DTLS where ((OPERATING_FACI\
LITY_ID=:b3 and EPISODE_ID=to_number(:b4)) and VISIT_ID=to_number(:b5))";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )381;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_ref_episode_type;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_ref_episode_id;
      sqlstm.sqhstl[1] = (unsigned int  )12;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_ref_visit_id;
      sqlstm.sqhstl[2] = (unsigned int  )5;
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
      sqlstm.sqhstv[4] = (         void  *)&d_episode_id;
      sqlstm.sqhstl[4] = (unsigned int  )11;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&d_visit_id;
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
      if (sqlca.sqlcode < 0) goto err_exit;
}


    
	d_ref_episode_type.arr[d_ref_episode_type.len] = '\0';
	d_ref_episode_id.arr[d_ref_episode_id.len] = '\0';
	d_ref_visit_id.arr[d_ref_visit_id.len] = '\0';
	 
	 d_hosp_fee_exm_yn.arr[0] ='\0';
	 d_hosp_fee_exm_yn.len=0;
	 d_med_fee_exm_yn.arr[0] ='\0';
	 d_med_fee_exm_yn.len=0;
	 
	 d_added_by_id.arr[0] ='\0';
	 d_added_by_id.len=0;

    /* EXEC SQL SELECT  HOSP_FEE_EXEMPTED_YN,MED_FEE_EXEMPTED_YN,added_by_id
		INTO  :d_hosp_fee_exm_yn,:d_med_fee_exm_yn,:d_added_by_id
	               FROM  BL_VISIT_EXM_FIN_DTLS 
		       WHERE OPERATING_FACILITY_ID = :nd_facility_id
			AND episode_type=:d_ref_episode_type
			AND EPISODE_ID    = :d_ref_episode_id
		        AND VISIT_ID      = :d_ref_visit_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select HOSP_FEE_EXEMPTED_YN ,MED_FEE_EXEMPTED_YN ,added_b\
y_id into :b0,:b1,:b2  from BL_VISIT_EXM_FIN_DTLS where (((OPERATING_FACILITY_\
ID=:b3 and episode_type=:b4) and EPISODE_ID=:b5) and VISIT_ID=:b6)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )420;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_hosp_fee_exm_yn;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_med_fee_exm_yn;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_added_by_id;
    sqlstm.sqhstl[2] = (unsigned int  )22;
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
    sqlstm.sqhstv[4] = (         void  *)&d_ref_episode_type;
    sqlstm.sqhstl[4] = (unsigned int  )5;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_ref_episode_id;
    sqlstm.sqhstl[5] = (unsigned int  )12;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_ref_visit_id;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


	 
	 d_hosp_fee_exm_yn.arr[d_hosp_fee_exm_yn.len] = '\0';
	 d_med_fee_exm_yn.arr[d_med_fee_exm_yn.len] = '\0';
	 d_added_by_id.arr[d_added_by_id.len] = '\0';


/*-------------------End of Select Statements--------------------------------*/
  
   /* Line 1 Details  */  
	fprintf(f1,"%-54.54s Date : %-16s\n"," ",nd_sys_date.arr);       
    fprintf(f1,"%-28.28s %s\n"," ",d_header.arr);
	fprintf(f1,"               VISIT SLIP - CREDIT / NON PAYING PATIENT \n");
    fprintf(f1,"\n");          
    fprintf(f1,"Patient No   : %-20s ",d_patient_id.arr);
    fprintf(f1,"%-18.18s Visit No   : %-8s/"," ",d_episode_id.arr);
	fprintf(f1,"%-4s \n",d_visit_id.arr);
    fprintf(f1,"Patient Name : %-40.40s",d_short_name.arr);
    fprintf(f1,"Visit Date : %-16s\n",d_visit_regn_date_time.arr);
	fprintf(f1,"ID No        : %-15s ",d_national_id_num.arr);
    fprintf(f1,"%-23.23s Visit Type : %-15s\n"," ",d_visit_type_desc.arr);
    fprintf(f1,"Fin Class    : %-2s",d_blng_grp_id.arr);
    fprintf(f1,"%-37.37s Clinic     : %-15s    \n"," ",d_clinic_desc.arr);
    fprintf(f1,"__________________________________________________________________________________\n");

    // fprintf(f1,"  Visit Charge Exempted upto %s",nd_exemp_upto_date.arr );  	 //commented by vani dated on 21/12/2009
  	
       
	   /*********added by vani*** dated on 21/12/2009******/

       if(strcmp(d_hosp_fee_exm_yn.arr,"Y")==0)
       fprintf(f1,"\n  Hospital Fee Exempted upto %s\n",nd_exemp_upto_date.arr );

		
       if(strcmp(d_med_fee_exm_yn.arr,"Y")==0)
       fprintf(f1,"  Medical Fee Exempted upto %s",nd_exemp_upto_date.arr );

	  fprintf(f1,"\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	  fprintf(f1,"__________________________________________________________________________________\n");
      fprintf(f1,"\n\n");
	  fprintf(f1,"%-27.27s %23.23s----------------------------\n"," ","Signature");
	  fprintf(f1,"\n\n");
	  fprintf(f1,"%-41.41s %-s :"," ","Prepared BY"); 

	  get_cashier_name();
	  get_cashier_designation();
	  
	  if(strcmp(nd_cahier_position.arr,"\0")!=0)	  
	  fprintf(f1,"\n%-42.42s (%-s) :"," ",nd_cahier_position.arr); 


   /******************upto here ***********/


    /* Skip Page  */
    fprintf(f1,"");
    
/*-------------------End of Printing Statements------------------------------*/

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )463;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
    if (sqlca.sqlcode < 0) goto err_exit;
}




	fprintf(f1,"%c(sl0H",ESC);

    fclose(f1);


if (nd_online_yn == 'Y')

{
	   PrintDocument
	   (
		uid_pwd.arr,		//char	*PUidPwd;
		nd_session_id.arr,	//char	*PSessionID;
		nd_facility_id.arr,	//char	*PFacilityID;
		"BL",				//char	*PModuleID;
		nd_calling_pgm_id.arr,			//char	*PDocumentID;
		filename,			//char	*POnlinePrintFileNames;
		"O",				//char	*PLocationTypes;
		" ",				//char	*PLocationCodes;
		1,					//int		PNumOfCopies;
		1,					//int		PPageFrom;
		9999					//int		PPageTo;
		);
}


    return(0);

err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )478;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ERR_MESG,"Oracle error occured...");
    disp_message(ORA_MESG,sqlca.sqlerrm.sqlerrmc);
    return;
}

get_cashier_name()
{

  nd_cashier_name.arr[0]='\0';
  nd_cashier_name.len	  =0; 

  

  /* EXEC SQL SELECT DISTINCT APPL_USER_NAME
  INTO  :nd_cashier_name
  FROM   SM_APPL_USER
  WHERE  APPL_USER_ID=:d_added_by_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select distinct APPL_USER_NAME into :b0  from SM_APPL_USER \
where APPL_USER_ID=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )493;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_cashier_name;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_added_by_id;
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


 
  if (OERROR)
	  { 
		disp_message (ERR_MESG,"FETCH FAILED FROM SM_APPL_USER TABLE");
	  }
 
  nd_cashier_name.arr[nd_cashier_name.len]='\0';
   
} 

/* Getting designation of cashier */

get_cashier_designation()
{
 
 
 nd_cahier_position.arr[0] ='\0';
 nd_cahier_position.len	   = 0;


 /* EXEC SQL EXECUTE
    
	DECLARE
    nd_func_role  VARCHAR2(3);
	
	BEGIN
		
		SELECT FUNC_ROLE 
		INTO nd_func_role
        FROM SM_APPL_USER
		WHERE  APPL_USER_ID=:d_added_by_id;
       

		//IF nd_func_role='O' THEN

		SELECT long_desc 
		INTO :nd_cahier_position
		FROM sm_appl_user a,am_other_staff b,am_other_staff_type C
		WHERE a.appl_user_id=:d_added_by_id
		AND a.FUNC_ROLE='O'
		AND b.OTHER_STAFF_ID = a.FUNC_ROLE_ID
		AND c.OTHER_STAFF_TYPE = b.OTHER_STAFF_TYPE;

	//	END IF;



	END;

END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare nd_func_role VARCHAR2 ( 3 ) ; BEGIN SELECT FUNC_ROLE\
 INTO nd_func_role FROM SM_APPL_USER WHERE APPL_USER_ID = :d_added_by_id ; SEL\
ECT long_desc INTO :nd_cahier_position FROM sm_appl_user a , am_other_staff b \
, am_other_staff_type C WHERE a . appl_user_id = :d_added_by_id AND a . FUNC_R\
OLE = 'O' AND b . OTHER_STAFF_ID = a . FUNC_ROLE_ID AND c . OTHER_STAFF_TYPE =\
 b . OTHER_STAFF_TYPE ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )516;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_added_by_id;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_cahier_position;
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


 
    
    nd_cahier_position.arr[nd_cahier_position.len]='\0';

 if (OERROR)
	  { 
		disp_message (ERR_MESG,"FETCH FAILED FROM SM_APPL_USER TABLE");
	  }

 
}     

