
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/blrhcmem.pc"
};


static unsigned int sqlctx = 1288466611;


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
            void  *sqhstv[13];
   unsigned int   sqhstl[13];
            int   sqhsts[13];
            void  *sqindv[13];
            int   sqinds[13];
   unsigned int   sqharm[13];
   unsigned int   *sqharc[13];
   unsigned short  sqadto[13];
   unsigned short  sqtdso[13];
} sqlstm = {12,13};

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
"VL(:b3,'!!!!') and NVL(:b4,'~~~~')) and b.acc_entity_code in (select acc_ent\
ity_code  from sy_acc_entity where acc_entity_id=:b0)) order by a.customer_cod\
e,a.hcare_appl_num            ";

 static const char *sq0007 = 
"4) and a.scheme_id between NVL(:b5,a.scheme_id) and NVL(:b6,a.scheme_id)) or\
der by a.customer_code,a.hcare_appl_num            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,130,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,65,0,4,153,0,0,1,0,0,1,0,2,9,0,0,
55,0,0,3,32,0,4,157,0,0,1,0,0,1,0,2,9,0,0,
74,0,0,4,94,0,4,161,0,0,3,1,0,1,0,2,9,0,0,2,3,0,0,1,9,0,0,
101,0,0,5,0,0,30,175,0,0,0,0,0,1,0,
116,0,0,6,1208,0,9,376,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
155,0,0,7,1151,0,9,386,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
198,0,0,6,0,0,13,422,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,3,0,0,
265,0,0,7,0,0,13,484,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,3,0,0,
332,0,0,8,515,0,6,511,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
359,0,0,6,0,0,15,547,0,0,0,0,0,1,0,
374,0,0,7,0,0,15,553,0,0,0,0,0,1,0,
};


 /* Preprocessor Directives   */

#include <stdio.h>
#include <string.h>
#include <math.h>
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




//#include <sqlca.h>
//#include <sqlda.h>
#include <bl.h> 
#include <winproc.h>
         
/* Macros */

#define LAST_ROW (sqlca.sqlcode == 1403)
#define OERROR (sqlca.sqlcode < 0) 
#define MAX_LINES 55

/* Declarations */

/* EXEC SQL BEGIN DECLARE SECTION; */ 
	

	/* VARCHAR uid_pwd 				[95],	        
	     	nd_sysdate				[31],
			nd_option				[2],
			nd_facility_id			[3],	
			nd_from_customer_code	[9],
			nd_to_customer_code		[9],  
			nd_from_hcare_scheme	[10],
			nd_to_hcare_scheme		[10],		
			nd_user_id  	        [31],	
			nd_hospital_name		[61],		
			nd_prev_customer_code	[9],
			nd_customer_code		[9],
			nd_customer_name		[16],
			nd_appl_num				[11],   
			nd_employee_id			[11],
			nd_patient_id			[21],
			nd_session_id			[20],
			nd_pgm_date				[30],
                  d_short_name_full             [61],
			nd_patient_name			[61],  
			nd_patient_name1		[31],
			nd_hcare_scheme			[7],
			nd_payment_option		[11],
			nd_hcare_start_date		[12],
			nd_hcare_expiry_date	[12],
			nd_pgm_id				[30]; */ 
struct { unsigned short len; unsigned char arr[95]; } uid_pwd;

struct { unsigned short len; unsigned char arr[31]; } nd_sysdate;

struct { unsigned short len; unsigned char arr[2]; } nd_option;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[9]; } nd_from_customer_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_customer_code;

struct { unsigned short len; unsigned char arr[10]; } nd_from_hcare_scheme;

struct { unsigned short len; unsigned char arr[10]; } nd_to_hcare_scheme;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[61]; } nd_hospital_name;

struct { unsigned short len; unsigned char arr[9]; } nd_prev_customer_code;

struct { unsigned short len; unsigned char arr[9]; } nd_customer_code;

struct { unsigned short len; unsigned char arr[16]; } nd_customer_name;

struct { unsigned short len; unsigned char arr[11]; } nd_appl_num;

struct { unsigned short len; unsigned char arr[11]; } nd_employee_id;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[20]; } nd_session_id;

struct { unsigned short len; unsigned char arr[30]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[31]; } nd_patient_name1;

struct { unsigned short len; unsigned char arr[7]; } nd_hcare_scheme;

struct { unsigned short len; unsigned char arr[11]; } nd_payment_option;

struct { unsigned short len; unsigned char arr[12]; } nd_hcare_start_date;

struct { unsigned short len; unsigned char arr[12]; } nd_hcare_expiry_date;

struct { unsigned short len; unsigned char arr[30]; } nd_pgm_id;
		
	
	   char nd_filename				[100];     

	 double	nd_subscription_amt,tot_subscription_amt,g_tot_subscription_amt;   

	   long	nd_fmt_string		  =0,
			nd_no_of_dependant	  =0;

/* EXEC SQL END DECLARE SECTION; */ 

FILE 	*f1;
int	page = 0;
int	line = 0;

void proc_main(argc, argv)
	int	argc;
	char	*argv[];
{    
	void prt_line(int l, char spl_symbol[1]);
	void prt_hdr_initial();
	void prt_hdr_next();
	void prt_hdr();    
	void dec_cursor();
	void open_cursor();
	void close_cursor();
	int  fetch_cursor();
	
	void dec_cursor1();
	void open_cursor1();
	void close_cursor1();   
	int  fetch_cursor1();
	  
	void report_process();
	void report_process1();
  
	void line_check();
	void page_hdr();
	 
	void sub_hdr_prt(); 
	void rec_prt();
/* INPUT ARGUMENT CHECK */
     if(argc < 9) 
   
     {
		disp_message(ORA_MESG, "Usage BLRHCMEM uid/passwd@db Session Pgm-Date Operating-Facility-ID Option 	From-Customer To-Customer From-Scheme To-Scheme");
		proc_exit();
     }
	   
	strcpy(nd_pgm_id.arr, argv[0]);
    nd_pgm_id.len = strlen(nd_pgm_id.arr);   
    
    strcpy(uid_pwd.arr, argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);   

    strcpy(nd_session_id.arr, argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);      	 
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr, argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);      	 
    strcpy(g_pgm_date,nd_pgm_date.arr);   
   	 
	strcpy(nd_facility_id.arr, argv[5]);
    nd_facility_id.len = strlen(nd_facility_id.arr);      
    strcpy(g_facility_id,nd_facility_id.arr);

    strcpy(nd_option.arr, argv[6]);
    nd_option.len = strlen(nd_option.arr);      	 

    strcpy(nd_from_customer_code.arr, argv[7]);
    nd_from_customer_code.len = strlen(nd_from_customer_code.arr);      	 

    strcpy(nd_to_customer_code.arr, argv[8]);
    nd_to_customer_code.len = strlen(nd_to_customer_code.arr);      	 

	strcpy(nd_from_hcare_scheme.arr, argv[9]);
    nd_from_hcare_scheme.len = strlen(nd_from_hcare_scheme.arr);      	 

    strcpy(nd_to_hcare_scheme.arr, argv[10]);
    nd_to_hcare_scheme.len = strlen(nd_to_hcare_scheme.arr);      	 

/* DB LOGIN */
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
 sqlstm.sqhstl[0] = (unsigned int  )97;
 sqlstm.sqhsts[0] = (         int  )97;
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
    	disp_message (ORA_MESG, "UserId / Password failed to Connect");
        proc_exit();  
    }	  	

	set_meduser_role();

/* OUTPUT FILE */

	strcpy(nd_filename,WORKING_DIR);   
	strcat(nd_filename,argv[0]);
	strcat(nd_filename,".lis");
	if((f1 = fopen(nd_filename, "w")) == NULL) 
	{
		 disp_message (ERR_MESG, " Error opening output file ....");
		 proc_exit();
    } 
	
	nd_sysdate.arr[0]     = '\0';  
	nd_sysdate.len		  = 0;

	/* EXEC SQL SELECT to_char(SYSDATE,'DD/MM/YYYY HH24:MI') INTO :nd_sysdate FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select to_char(SYSDATE,'DD/MM/YYYY HH24:MI') into :b0  from \
dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_sysdate;
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


	nd_sysdate.arr[nd_sysdate.len]  = '\0';  
	nd_user_id.arr[0]				= '\0';  
	nd_user_id.len					= 0;
	/* EXEC SQL SELECT USER INTO :nd_user_id FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select USER into :b0  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )55;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_user_id;
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


	nd_user_id.arr[nd_user_id.len]  = '\0';  
	nd_hospital_name.arr[0]			= '\0';         
	nd_hospital_name.len			= 0;
	/* EXEC SQL SELECT accounting_name, no_of_decimal 
	   INTO :nd_hospital_name, nd_fmt_string
	   FROM sy_acc_entity
	   WHERE acc_entity_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select accounting_name ,no_of_decimal into :b0,:b1  from sy_\
acc_entity where acc_entity_id=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )74;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_hospital_name;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_fmt_string;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
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
}


	nd_hospital_name.arr[nd_hospital_name.len]	= '\0';  

/* PROCESS */   
   page_hdr();  
   if (strcmp(nd_option.arr,"C") == 0)
	   { report_process() ;}
   else
	   { report_process1();}
  
/* CLOSE FILE */
   /* EXEC SQL COMMIT RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )101;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 
   fclose(f1); return;   
}

void line_check()
{
   if (line > MAX_LINES)
   {
	fprintf(f1,"\f"); page_hdr();
   }
}       

void page_hdr()
{
   prt_hdr();
   if (page==1)
   {
		prt_hdr_initial();
   }
   else
   { 
		prt_hdr_next();
   }
}

void prt_hdr()
{     
   line = 0;    
   page = page +1;
   fprintf(f1,"\n");       
   fprintf(f1,"MDL : BL");
   prt_line(42," "); 
   fprintf(f1,"%-31s",nd_hospital_name.arr);
   prt_line(30," "); 
   fprintf(f1,"%-20s",nd_sysdate.arr);           
   fprintf(f1,"\n"); 
   fprintf(f1,"OPR : %-31s",nd_user_id.arr); 
   prt_line(10," ");    
   fprintf(f1,"Active Members of Healthcare Scheme");
   prt_line(32," "); 
   fprintf(f1,"Page :%-4d",page);           
   fprintf(f1,"\n"); 
   fprintf(f1,"REP : BLRHCMEM"); 
   prt_line(40," "); 
   fprintf(f1,"AS ON %-10.10s",nd_sysdate.arr); 
   fprintf(f1,"\n"); 
   prt_line(142,"-");     
 }
void prt_hdr_initial()
{
   fprintf(f1,"\n");    
   fprintf(f1,"VER : 4.1");
   fprintf(f1,"\n");    
   fprintf(f1,"\n");    
   fprintf(f1,"\n");    
   fprintf(f1,"		INPUT PARAMETERS:");
   fprintf(f1,"\n");    
   fprintf(f1,"		-----------------");    
   fprintf(f1,"\n");    
   fprintf(f1,"\n");    

   fprintf(f1,"		Selection(Employess / Customers / Others):  ");

   if (strcmp(nd_option.arr,"E") == 0)
   {   fprintf(f1,"Employees");}

   if (strcmp(nd_option.arr,"C") == 0)
   {   fprintf(f1,"Customers");} 
	
   if (strcmp(nd_option.arr,"O") == 0)
   {   fprintf(f1,"Others");} 

   fprintf(f1,"\n");           

   if (strcmp(nd_from_customer_code.arr,"!!!!!!!!") == 0)
   {  fprintf(f1,"		Customer			    From : LOWEST"); }
   else
   {  fprintf(f1,"		Customer			    From : %-9s",
								nd_from_customer_code.arr);}
   fprintf(f1,"\n");    

   if (strcmp(nd_to_customer_code.arr,"~~~~~~~~") == 0)
   {  fprintf(f1,"					   	    To   : HIGHEST"); }
   else
   {  fprintf(f1,"   				            	    To   : %-9s",
								nd_to_customer_code.arr);}
   fprintf(f1,"\n");    
   if (strcmp(nd_from_hcare_scheme.arr,"!!!!") == 0)
   fprintf(f1,"		H/Care Scheme			    From : LOWEST");
   else
   fprintf(f1,"		H/Care Scheme			    From : %-4s", nd_from_hcare_scheme.arr);
   fprintf(f1,"\n");    
   if (strcmp(nd_to_hcare_scheme.arr,"~~~~") == 0)
   fprintf(f1,"						    To   : HIGHEST");
   else
   fprintf(f1,"						    To   : %-4s", nd_to_hcare_scheme.arr);
   fprintf(f1,"\n");    
   line = MAX_LINES + 1; 
}
	  
void prt_hdr_next()
{
   fprintf(f1,"\n");    
   fprintf(f1,"Appln. No            Employee ID Patient ID           Name                     Scheme  ");	     fprintf(f1,"Payment     Start Date End Date        Amount  Members");
   fprintf(f1, "\n");   
   prt_line(142,"-");  
   fprintf(f1, "\n");     
}

void prt_line(int line_length, char spl_symbol[1])
{  
 int i;  
  for(i=1;i<=line_length;i=i+1)
	 {fprintf(f1,spl_symbol);}
}
     
void dec_cursor() /* include bl_health_scheme to get short_desc by passin
					 scheme_id		byRVN on 06/05/03*/
{ 
  /* EXEC SQL DECLARE hcare_cursor CURSOR FOR   
  	   SELECT a.customer_code	 customer_code,
			  b.short_name 	 customer_name,
			  a.hcare_appl_num appl_num,
			  a.employee_id	 employee_id,
			  a.patient_id	 patient_id,
			  SUBSTR(c.short_name,1,32) patinet_name,
			  substr(c.short_name,33,60) patient_nam1,
			  d.short_desc hcare_scheme,	
			  DECODE(a.payment_option,'I','Immediate','R','Credit','S','Salary Ded','L','Instalment') Payment,
			  TO_CHAR(a.hcare_start_date,'dd/mm/yyyy') hcare_start_date,
			  TO_CHAR(a.hcare_expiry_date,'dd/mm/yyyy') hcare_expiry_date,
			  a.subscription_amt subscription_amt,
			  NVL(a.no_of_dependents,0) no_of_dependant		
		 FROM bl_hcare_trn a, ar_customer b, mp_patient_mast c, bl_health_scheme d
		WHERE a.customer_code				=	b.cust_code
		  AND a.patient_id					=	c.patient_id  
		  AND a.emp_patient_id				IS 	NULL
		  AND a.customer_code				IS 	NOT NULL 	
		  AND a.payment_option				=	'R'
		  AND a.scheme_id					=	d.scheme_id
		  AND TRUNC(a.hcare_expiry_date) 	>=	TRUNC(SYSDATE)
		  AND a.hcare_status				=	'A'
		  AND a.operating_facility_id		= 	:nd_facility_id
		  AND a.customer_code BETWEEN NVL(:nd_from_customer_code,'!!!!!!!!')
								  AND NVL(:nd_to_customer_code,'~~~~~~~~')
		  AND a.scheme_id BETWEEN NVL(:nd_from_hcare_scheme,'!!!!') 
		   				      AND NVL(:nd_to_hcare_scheme,'~~~~')
		  AND b.acc_entity_code IN (SELECT acc_entity_code 
									  FROM sy_acc_entity
									 WHERE acc_entity_id = :nd_facility_id)
	 
	 ORDER BY a.customer_code, a.hcare_appl_num; */ 

	 return;
 }

void dec_cursor1()/* include bl_health_scheme to get short_desc by passin
					 scheme_id		byRVN on 06/05/03*/
{ 

  /* EXEC SQL DECLARE hcare_cursor1 CURSOR FOR   
  	SELECT	a.customer_code				customer_code,
			''	 						customer_name,
			a.hcare_appl_num			appl_num,
			a.employee_id				employee_id,
			a.patient_id				patient_id,
                
			SUBSTR(c.short_name,1,32) patinet_name,
			SUBSTR(c.short_name,33,60) patinet_name1,
			d.short_desc				hcare_scheme,	
			DECODE(a.payment_option,'I','Immediate','R','Credit','S','Salary Ded.','L','Instalment') Payment,
			TO_CHAR(a.hcare_start_date,'dd/mm/yyyy' ) hcare_start_date,
			TO_CHAR(a.hcare_expiry_date,'dd/mm/yyyy') hcare_expiry_date,
			a.subscription_amt			subscription_amt,
			NVL(a.no_of_dependents,0) no_of_dependant		
	   FROM	bl_hcare_trn				a,
				mp_patient_mast				c,
				bl_health_scheme d
	  
	  WHERE	a.patient_id				=	c.patient_id
		AND	a.emp_patient_id			IS 	NULL
		AND	a.hcare_status				=	'A'
		AND a.scheme_id					=	d.scheme_id
		AND	((:nd_option	 			=	'E'
			   AND a.employee_id IS NOT NULL
			   AND a.payment_option    <> 'R') OR
			 (:nd_option	 	=	'O'
			   AND a.employee_id IS     NULL
			   AND a.customer_code IS     NULL))	
		AND trunc(a.hcare_expiry_date) 	>=     TRUNC(SYSDATE)
		AND a.customer_code BETWEEN nvl(:nd_from_customer_code,'!!!!!!!!')
								AND nvl(:nd_to_customer_code,'~~~~~~~~')
		AND	a.operating_facility_id		= :nd_facility_id		
		AND	a.scheme_id BETWEEN NVL(:nd_from_hcare_scheme,a.scheme_id) 
							AND NVL(:nd_to_hcare_scheme,a.scheme_id)
		
		ORDER BY a.customer_code,a.hcare_appl_num; */ 

		return;
 }

void open_cursor()
{ 
 /* EXEC SQL OPEN hcare_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.customer_code customer_code ,b.short_name customer_name ,a.hcar\
e_appl_num appl_num ,a.employee_id employee_id ,a.patient_id patient_id ,SUB\
STR(c.short_name,1,32) patinet_name ,substr(c.short_name,33,60) patient_nam1\
 ,d.short_desc hcare_scheme ,DECODE(a.payment_option,'I','Immediate','R','Cr\
edit','S','Salary Ded','L','Instalment') Payment ,TO_CHAR(a.hcare_start_date\
,'dd/mm/yyyy') hcare_start_date ,TO_CHAR(a.hcare_expiry_date,'dd/mm/yyyy') h\
care_expiry_date ,a.subscription_amt subscription_amt ,NVL(a.no_of_dependent\
s,0) no_of_dependant  from bl_hcare_trn a ,ar_customer b ,mp_patient_mast c \
,bl_health_scheme d where (((((((((((a.customer_code=b.cust_code and a.patie\
nt_id=c.patient_id) and a.emp_patient_id is null ) and a.customer_code is  n\
ot null ) and a.payment_option='R') and a.scheme_id=d.scheme_id) and TRUNC(a\
.hcare_expiry_date)>=TRUNC(SYSDATE)) and a.hcare_status='A') and a.operating\
_facility_id=:b0) and a.customer_code between NVL(:b1,'!!!!!!!!') and NVL(:b\
2,'~~~~~~~~')) and a.scheme_id between N");
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )116;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_from_customer_code;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_to_customer_code;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_from_hcare_scheme;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_hcare_scheme;
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
	 {	disp_message (ORA_MESG, "Open HCare Cursor Failed");
       		proc_exit();
	 } 
	 return;
}

void open_cursor1()
{ 
 /* EXEC SQL OPEN hcare_cursor1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.customer_code customer_code ,'' customer_name ,a.hcare_appl_num\
 appl_num ,a.employee_id employee_id ,a.patient_id patient_id ,SUBSTR(c.shor\
t_name,1,32) patinet_name ,SUBSTR(c.short_name,33,60) patinet_name1 ,d.short\
_desc hcare_scheme ,DECODE(a.payment_option,'I','Immediate','R','Credit','S'\
,'Salary Ded.','L','Instalment') Payment ,TO_CHAR(a.hcare_start_date,'dd/mm/\
yyyy') hcare_start_date ,TO_CHAR(a.hcare_expiry_date,'dd/mm/yyyy') hcare_exp\
iry_date ,a.subscription_amt subscription_amt ,NVL(a.no_of_dependents,0) no_\
of_dependant  from bl_hcare_trn a ,mp_patient_mast c ,bl_health_scheme d whe\
re ((((((((a.patient_id=c.patient_id and a.emp_patient_id is null ) and a.hc\
are_status='A') and a.scheme_id=d.scheme_id) and (((:b0='E' and a.employee_i\
d is  not null ) and a.payment_option<>'R') or ((:b0='O' and a.employee_id i\
s null ) and a.customer_code is null ))) and trunc(a.hcare_expiry_date)>=TRU\
NC(SYSDATE)) and a.customer_code between nvl(:b2,'!!!!!!!!') and nvl(:b3,'~~\
~~~~~~')) and a.operating_facility_id=:b");
 sqlstm.stmt = sq0007;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )155;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_option;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_option;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_from_customer_code;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_to_customer_code;
 sqlstm.sqhstl[3] = (unsigned int  )11;
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
 sqlstm.sqhstv[5] = (         void  *)&nd_from_hcare_scheme;
 sqlstm.sqhstl[5] = (unsigned int  )12;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_to_hcare_scheme;
 sqlstm.sqhstl[6] = (unsigned int  )12;
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


 if (sqlca.sqlcode < 0) 
	 {	disp_message (ORA_MESG, "Open HCare Cursor1 Failed");
       		proc_exit();
	 } 
	 return;
}

int fetch_cursor()
{ 
		nd_customer_code.arr[0]		= '\0';
		nd_customer_name.arr[0]		= '\0';
		nd_appl_num.arr[0]			= '\0';
		nd_employee_id.arr[0]		= '\0';
		nd_patient_id.arr[0]		='\0';
		nd_patient_name.arr[0]		='\0';
		nd_patient_name1.arr[0]		='\0';
		nd_hcare_scheme.arr[0]		= '\0';
		nd_payment_option.arr[0]	= '\0';
		nd_hcare_start_date.arr[0]	= '\0';
		nd_hcare_expiry_date.arr[0]	= '\0';

		nd_subscription_amt			= 0;
		nd_no_of_dependant			= 0;
		nd_customer_code.len		= 0;
		nd_customer_name.len		= 0;
		nd_appl_num.len				= 0;
		nd_employee_id.len			= 0;
		nd_patient_id.len			= 0;
		nd_patient_name.len			= 0;
		nd_patient_name1.len			= 0;
		nd_hcare_scheme.len			= 0;
		nd_payment_option.len		= 0;
		nd_hcare_start_date.len		= 0;
		nd_hcare_expiry_date.len	= 0;
  
  /* EXEC SQL FETCH hcare_cursor     
			INTO :nd_customer_code,    :nd_customer_name,
				 :nd_appl_num,		   :nd_employee_id,
				 :nd_patient_id ,      :nd_patient_name,
				 :nd_patient_name1,
				 :nd_hcare_scheme,     :nd_payment_option,
				 :nd_hcare_start_date, :nd_hcare_expiry_date,
				 :nd_subscription_amt, :nd_no_of_dependant; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )198;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&nd_customer_code;
  sqlstm.sqhstl[0] = (unsigned int  )11;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_customer_name;
  sqlstm.sqhstl[1] = (unsigned int  )18;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_appl_num;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_employee_id;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_patient_name;
  sqlstm.sqhstl[5] = (unsigned int  )63;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_patient_name1;
  sqlstm.sqhstl[6] = (unsigned int  )33;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_hcare_scheme;
  sqlstm.sqhstl[7] = (unsigned int  )9;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_payment_option;
  sqlstm.sqhstl[8] = (unsigned int  )13;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_hcare_start_date;
  sqlstm.sqhstl[9] = (unsigned int  )14;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_hcare_expiry_date;
  sqlstm.sqhstl[10] = (unsigned int  )14;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_subscription_amt;
  sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_no_of_dependant;
  sqlstm.sqhstl[12] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
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
     err_mesg("FETCH failed on BL_RECEIPT_REFUND_DTL_CUR",0,"");

   if (LAST_ROW) return (0);
   
    nd_customer_code.arr[nd_customer_code.len]			= '\0';
    nd_customer_name.arr[nd_customer_name.len]			= '\0';
    nd_appl_num.arr[nd_appl_num.len]					= '\0';
    nd_employee_id.arr[nd_employee_id.len]				= '\0';
    nd_patient_id.arr[nd_patient_id.len] 				= '\0';
    nd_patient_name.arr[nd_patient_name.len] 			= '\0';
	nd_patient_name1.arr[nd_patient_name1.len] 			= '\0';
    nd_hcare_scheme.arr[nd_hcare_scheme.len] 			= '\0';
    nd_payment_option.arr[nd_payment_option.len]		= '\0';
    nd_hcare_start_date.arr[nd_hcare_start_date.len]	= '\0';
    nd_hcare_expiry_date.arr[nd_hcare_expiry_date.len] 	= '\0';
    
 
  
	return 1;
 }


int fetch_cursor1()
{ 
	nd_customer_code.arr[0]		= '\0';
	nd_customer_name.arr[0]		= '\0';
	nd_appl_num.arr[0]			= '\0';
	nd_employee_id.arr[0]		= '\0';
	nd_patient_id.arr[0]		= '\0';
	nd_patient_name.arr[0]		= '\0';
	nd_patient_name1.arr[0]		= '\0';
	nd_hcare_scheme.arr[0]		= '\0';
	nd_payment_option.arr[0]	= '\0';
	nd_hcare_start_date.arr[0]	= '\0';
	nd_hcare_expiry_date.arr[0]	= '\0';

	nd_subscription_amt			= 0;
	nd_no_of_dependant			= 0;

	nd_customer_code.len		= 0;
	nd_customer_name.len		= 0;
	nd_appl_num.len				= 0;
	nd_employee_id.len			= 0;
	nd_patient_id.len			= 0;
	nd_patient_name.len			= 0;
	nd_patient_name1.len			= 0;
	nd_hcare_scheme.len			= 0;
	nd_payment_option.len		= 0;
	nd_hcare_start_date.len		= 0;
	nd_hcare_expiry_date.len	= 0;

  /* EXEC SQL FETCH hcare_cursor1 
			INTO :nd_customer_code,	:nd_customer_name,
				 :nd_appl_num,		:nd_employee_id,
				 :nd_patient_id ,	:nd_patient_name,
				 :nd_patient_name1,
				 :nd_hcare_scheme,	:nd_payment_option,
				 :nd_hcare_start_date,:nd_hcare_expiry_date,
				 :nd_subscription_amt,:nd_no_of_dependant; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )265;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&nd_customer_code;
  sqlstm.sqhstl[0] = (unsigned int  )11;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_customer_name;
  sqlstm.sqhstl[1] = (unsigned int  )18;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_appl_num;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_employee_id;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_patient_name;
  sqlstm.sqhstl[5] = (unsigned int  )63;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_patient_name1;
  sqlstm.sqhstl[6] = (unsigned int  )33;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_hcare_scheme;
  sqlstm.sqhstl[7] = (unsigned int  )9;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_payment_option;
  sqlstm.sqhstl[8] = (unsigned int  )13;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_hcare_start_date;
  sqlstm.sqhstl[9] = (unsigned int  )14;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_hcare_expiry_date;
  sqlstm.sqhstl[10] = (unsigned int  )14;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_subscription_amt;
  sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_no_of_dependant;
  sqlstm.sqhstl[12] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
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
      err_mesg("FETCH failed on BL_RECEIPT_REFUND_DTL_CUR",0,"");

   if (LAST_ROW) return (0);
   	
	nd_customer_code.arr[nd_customer_code.len]			= '\0';
    nd_customer_name.arr[nd_customer_name.len]	 		= '\0';
    nd_appl_num.arr[nd_appl_num.len]					= '\0';
    nd_employee_id.arr[nd_employee_id.len]				= '\0';
    nd_patient_id.arr[nd_patient_id.len] 				= '\0';
    nd_patient_name.arr[nd_patient_name.len] 			= '\0';
	nd_patient_name1.arr[nd_patient_name1.len] 			= '\0';
    nd_hcare_scheme.arr[nd_hcare_scheme.len] 			= '\0';
    nd_payment_option.arr[nd_payment_option.len]		= '\0';
    nd_hcare_start_date.arr[nd_hcare_start_date.len]	= '\0';
    nd_hcare_expiry_date.arr[nd_hcare_expiry_date.len] 	= '\0';
    d_short_name_full.arr[d_short_name_full.len]               = '\0';
 
 /* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :nd_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :nd_patient_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :nd_patient_name1    := :nd_patient_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ;\
 BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str\
2 ) ; IF str2 IS NOT NULL THEN :nd_patient_name := str2 ; END IF ; blcommon . \
split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS N\
OT NULL THEN :nd_patient_name1 := str2 ; END IF ; blcommon . split_words ( :d_\
short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :nd_\
patient_name1 := :nd_patient_name1 || str2 ; end if ; END ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )332;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_patient_name;
 sqlstm.sqhstl[1] = (unsigned int  )63;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_patient_name1;
 sqlstm.sqhstl[2] = (unsigned int  )33;
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


       nd_patient_name.arr[nd_patient_name.len]  = '\0';
       nd_patient_name1.arr[nd_patient_name1.len]  = '\0';


    return 1;
 }

void close_cursor()
{ 
 /* EXEC SQL CLOSE hcare_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )359;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 return;
 }

void close_cursor1()
{ 
 /* EXEC SQL CLOSE hcare_cursor1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )374;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 return;
 }

void sub_hdr_prt()
{	fprintf(f1,"Customer  : %-9s" ,nd_customer_code.arr); 		
        fprintf(f1," - ");
	fprintf(f1,"%-60s" 	      ,nd_customer_name.arr); 		
       	fprintf(f1,"\n");
   	fprintf(f1,"\n");
	line = line +2;
	line_check();
}
	
print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
        format_amt(s_amt);
		strcat(s_amt,"-");
        sprintf(str_amt,"%10s",s_amt);        
        fprintf(f1,"%10s",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);        
        format_amt(s_amt);	
        sprintf(str_amt,"%10s",s_amt);
        fprintf(f1,"%10s",str_amt);
        }
}

void tot_prt()
{
fprintf(f1,"%-114s        ----------\n"," ");
fprintf(f1,"%-114s Total :"," ");
print_formated(tot_subscription_amt);
fprintf(f1,"\n");
fprintf(f1,"%-114s        ----------\n"," ");
g_tot_subscription_amt=g_tot_subscription_amt+tot_subscription_amt;
tot_subscription_amt= 0;
line=line+3;
}

void g_tot_prt()
{
fprintf(f1,"%-114s        ----------\n"," ");
fprintf(f1,"%-108s Grand Total :"," ");
print_formated(g_tot_subscription_amt);
fprintf(f1,"\n");
fprintf(f1,"%-114s        ----------\n"," ");
g_tot_subscription_amt= 0;
line=line+3;
}

void rec_prt()
{
       {fprintf(f1,"%-20.20s "	,nd_appl_num.arr);	
        fprintf(f1,"%-10s  "  	,nd_employee_id.arr);
		fprintf(f1,"%-20.20s  "	,nd_patient_id.arr);
        fprintf(f1,"%-23.23s " 	,nd_patient_name.arr);
		fprintf(f1,"%-7s " 	,nd_hcare_scheme.arr);
        fprintf(f1,"%-11s "  	,nd_payment_option.arr);
		fprintf(f1,"%-10s " 	,nd_hcare_start_date.arr);
        fprintf(f1,"%-11s "  	,nd_hcare_expiry_date.arr);
		print_formated(nd_subscription_amt);
		fprintf(f1,"  %7d"  	,nd_no_of_dependant);
        fprintf(f1,"\n");

tot_subscription_amt=tot_subscription_amt+nd_subscription_amt;
if(strlen(nd_patient_name1.arr) > 2)
{
 fprintf(f1,"%50s %s \n"," ",nd_patient_name1.arr);
 line++;
}

     }

	line = line + 1;	
	line_check();
}


void report_process()
{ 
	int fetch_cursor_check;
	dec_cursor();
	open_cursor();	    
	fetch_cursor_check = fetch_cursor();
    strcpy(nd_prev_customer_code.arr,nd_customer_code.arr);
	nd_prev_customer_code.len = strlen(nd_prev_customer_code.arr);
	line_check();  	
         
  while(fetch_cursor_check)  {  
     if (strcmp(nd_prev_customer_code.arr,nd_customer_code.arr) == 0)
       { 
	   if (line == 0)
       sub_hdr_prt();
	   rec_prt();
	   }
     else
       { 
	        tot_prt();
			if (line > (MAX_LINES-3))
		 	{ 
			line = MAX_LINES +1;
	    	line_check();	
			}	 
	
			//if (line == 0 ) 
			sub_hdr_prt();
			rec_prt();        
		}
        strcpy(nd_prev_customer_code.arr,nd_customer_code.arr);
        nd_prev_customer_code.len = strlen(nd_prev_customer_code.arr);
        fetch_cursor_check = fetch_cursor();		
     } 	
	 tot_prt();
	 g_tot_prt();
	 fprintf(f1,"\n");	 		
	 prt_line(58," "); 
	 fprintf(f1,"*** End Of Report ***");
         fprintf(f1, "\n");   	 
	 close_cursor();
}

void report_process1()
{        
    int fetch_cursor_check;
	dec_cursor1();
	open_cursor1();	    
    fetch_cursor_check = fetch_cursor1();        

	line_check();  
         
  while(fetch_cursor_check)  
       {  
        rec_prt();      
        fetch_cursor_check = fetch_cursor1();	 	
	    } 	
     tot_prt();
	 fprintf(f1,"\n");
	 prt_line(58," "); 
	 fprintf(f1,"*** End Of Report ***");
         fprintf(f1, "\n");   	 
	 close_cursor1();
}
