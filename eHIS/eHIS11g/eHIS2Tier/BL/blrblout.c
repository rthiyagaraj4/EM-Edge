
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/blrblout.pc"
};


static unsigned int sqlctx = 1288466795;


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
            void  *sqhstv[17];
   unsigned int   sqhstl[17];
            int   sqhsts[17];
            void  *sqindv[17];
            int   sqinds[17];
   unsigned int   sqharm[17];
   unsigned int   *sqharc[17];
   unsigned short  sqadto[17];
   unsigned short  sqtdso[17];
} sqlstm = {12,17};

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
"_num            ";

 static const char *sq0007 = 
"de,a.hcare_appl_num            ";

 static const char *sq0008 = 
"nion select a.customer_code customer_code ,'A' customer_name ,a.hcare_appl_n\
um appl_num ,TO_CHAR(a.hcare_appl_date,'dd/mm/yyyy') appl_date ,TO_CHAR(a.acti\
on_date,'dd/mm/yyyy') effective_date ,a.employee_id employee_id ,a.patient_id \
patient_id ,c.short_name ,SUBSTR(c.short_name,1,30) patinet_name ,SUBSTR(c.sho\
rt_name,31,60) patinet_name1 ,'Regular' hcare_scheme ,DECODE(a.payment_option,\
'I','Immediate','R','Credit','S','Salary Ded.','L','Instalment') Payment ,TO_C\
HAR(a.hcare_start_date,'dd/mm/yyyy') hcare_start_date ,TO_CHAR(a.hcare_expiry_\
date,'dd/mm/yyyy') hcare_expiry_date ,a.subscription_amt subscription_amt ,NVL\
(a.no_of_dependents,0) no_of_dependant ,DECODE(a.employee_id,null ,'O','E') ap\
pl_type  from bl_hcare_trn a ,mp_patient_mast c where (((((a.patient_id=c.pati\
ent_id and a.emp_patient_id is null ) and a.hcare_status='A') and a.customer_c\
ode is null ) and trunc(a.hcare_expiry_date)>=trunc(SYSDATE)) and a.operating_\
facility_id=:b0) order by 15,1,3            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,143,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,65,0,4,168,0,0,1,0,0,1,0,2,9,0,0,
55,0,0,3,32,0,4,171,0,0,1,0,0,1,0,2,9,0,0,
74,0,0,4,94,0,4,174,0,0,3,1,0,1,0,2,9,0,0,2,3,0,0,1,9,0,0,
101,0,0,5,0,0,30,206,0,0,0,0,0,1,0,
116,0,0,6,1028,0,9,485,0,0,1,1,0,1,0,1,9,0,0,
135,0,0,7,1055,0,9,495,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
162,0,0,8,2002,0,9,505,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
185,0,0,6,0,0,13,517,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
2,3,0,0,
264,0,0,7,0,0,13,557,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
2,3,0,0,
343,0,0,8,0,0,13,600,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
2,3,0,0,2,9,0,0,
426,0,0,9,515,0,6,638,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
453,0,0,6,0,0,15,673,0,0,0,0,0,1,0,
468,0,0,7,0,0,15,679,0,0,0,0,0,1,0,
483,0,0,8,0,0,15,684,0,0,0,0,0,1,0,
498,0,0,10,96,0,4,971,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
521,0,0,11,165,0,6,978,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};



/* Preprocessor Directives  */

#include <stdio.h>   
#include <string.h>
#include <math.h>

/* Macros */  

#define INIT_MESG "Report Generation In Progress"
#define NODATAFOUND sqlca.sqlcode==1403 
#define OERROR (sqlca.sqlcode < 0) 
#define MAX_LINES 55

/* Declarations */

/* EXEC SQL BEGIN DECLARE SECTION; */ 
	

	/* VARCHAR uid_pwd 	        [91],	        
	     	nd_sysdate              [31],
		nd_option		[2] ,
		nd_facility_id		[3] ,			
		nd_user_id  	        [31],	  
		nd_hospital_name	[61],		
		nd_prev_customer_code	[9] ,
		nd_prev_customer_name	[16],   
		nd_customer_code	[9] ,
		nd_customer_name	[16],    
		nd_appl_num		[11],
		nd_employee_id		[11],       
		nd_patient_id		[11],
            d_short_name_full       [61],
		nd_patient_name		[61],
		nd_patient_name1    [31],
		nd_hcare_scheme		[7] ,
		nd_payment_option	[11],
		nd_hcare_start_date	[12],
		nd_hcare_appl_date	[12],
		nd_hcare_effective_date [12],
		nd_app_type		[2] ,
		nd_hcare_expiry_date	[12],
		l_pk_value		    [100],
		p_language_id		[3],
	    l_translated_value	    [201]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[31]; } nd_sysdate;

struct { unsigned short len; unsigned char arr[2]; } nd_option;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[61]; } nd_hospital_name;

struct { unsigned short len; unsigned char arr[9]; } nd_prev_customer_code;

struct { unsigned short len; unsigned char arr[16]; } nd_prev_customer_name;

struct { unsigned short len; unsigned char arr[9]; } nd_customer_code;

struct { unsigned short len; unsigned char arr[16]; } nd_customer_name;

struct { unsigned short len; unsigned char arr[11]; } nd_appl_num;

struct { unsigned short len; unsigned char arr[11]; } nd_employee_id;

struct { unsigned short len; unsigned char arr[11]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[31]; } nd_patient_name1;

struct { unsigned short len; unsigned char arr[7]; } nd_hcare_scheme;

struct { unsigned short len; unsigned char arr[11]; } nd_payment_option;

struct { unsigned short len; unsigned char arr[12]; } nd_hcare_start_date;

struct { unsigned short len; unsigned char arr[12]; } nd_hcare_appl_date;

struct { unsigned short len; unsigned char arr[12]; } nd_hcare_effective_date;

struct { unsigned short len; unsigned char arr[2]; } nd_app_type;

struct { unsigned short len; unsigned char arr[12]; } nd_hcare_expiry_date;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

	    		
	char    buf[10];
	
	double	nd_subscription_amt	  =0,		
			nd_tot_amt		  =0,
			nd_grand_tot_amt	  =0;

	long	nd_fmt_string		  =0,
		nd_no_of_dependant	  =0,
		nd_tot_appl		  =0,
		nd_grand_tot_appl	  =0;

	int i;
	
	char g_facility_id[3];

    char nd_filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];


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

	FILE 	*f1;
	int	page = 0;
	int	line = 0;
	int     cust_count = 0;
	int     emp_count  = 0;
        int     other_count = 0;

void proc_main(argc, argv)
	int	argc;
	char	*argv[];
{    
   void prt_line(int l, char spl_symbol[1]);

   void prt_hdr_initial();
   void prt_hdr_next();
   void prt_hdr();    
   void page_hdr();
   void dec_cursor();
   void open_cursor();
   void close_cursor();
   int  fetch_cursor();

   void dec_cursor1();
   void open_cursor1();
   void close_cursor1();   
   int  fetch_cursor1();

   void dec_cursor2();
   void open_cursor2();
   void close_cursor2();   
   int  fetch_cursor2();

  
   void report_process();
   void report_process1();
   void report_process2();
   void grand_tot_prt();
   void tot_prt();
   void prev_sub_hdr_prt();
  
   void line_check();
   void sub_hdr_prt(); 
   void rec_prt();
   

/* INPUT ARGUMENT CHECK */

     if(argc != 5) 
     {
	disp_message(ORA_MESG, "Usage BLRBLOUT uid/passwd@db Operating-Facility-ID Option");
	proc_exit();
     }
 
     strcpy(uid_pwd.arr, argv[1]);
     uid_pwd.len = strlen(uid_pwd.arr);      
   	 
     strcpy(nd_facility_id.arr, argv[2]);
     nd_facility_id.len = strlen(nd_facility_id.arr);      
   
     strcpy(nd_option.arr, argv[3]);
     nd_option.len = strlen(nd_option.arr);      	 

	 strcpy(nd_facility_id.arr,argv[4]);
     nd_facility_id.len = strlen(nd_facility_id.arr);
     strcpy(g_facility_id,nd_facility_id.arr);


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

  strcpy(p_language_id.arr,l_language_id.arr);

  fetch_legend_value();

/* OUTPUT FILE */

	strcpy(nd_filename,WORKING_DIR);   
	strcat(nd_filename,argv[0]);
	strcat(nd_filename,".lis");
	if((f1 = fopen(nd_filename, "w")) == NULL) 
	{
		 disp_message (ERR_MESG, " Error opening output file ....");
		 proc_exit();
        } 
	

  /* EXEC SQL SELECT to_char(SYSDATE,'DD/MM/YYYY HH24:MI') INTO :nd_sysdate FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select to_char(SYSDATE,'DD/MM/YYYY HH24:MI') into :b0  from\
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


  nd_sysdate.arr[nd_sysdate.len]       = '\0';  
  
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


  nd_user_id.arr[nd_user_id.len]       = '\0';  
       
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
  sqlstm.stmt = "select accounting_name ,no_of_decimal into :b0,:b1  from sy\
_acc_entity where acc_entity_id=:b2";
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
   if (strcmp(nd_option.arr,"E") == 0)
	   { report_process1();}
   if (strcmp(nd_option.arr,"O") == 0)
	   { report_process1();}

   if (strcmp(nd_option.arr,"A") == 0)
	   { report_process2();}
   
   grand_tot_prt();
   fprintf(f1,"\n");	 		
   prt_line(58," "); 
   fprintf(f1,"*** End Of Report ***");
   fprintf(f1, "\n");   	 
	
  
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

 
   fclose(f1);   
   return;   
}

void line_check()
{
   if (line > MAX_LINES)
   {
	fprintf(f1,"\f");	    
	page_hdr();
   }
}       

void page_hdr()
{
   prt_hdr();
   if (page==1)
   { prt_hdr_initial();
    }
   else
   { prt_hdr_next();}
 }


void prt_hdr()
{     
   line = 0;    
   page = page +1;
   fprintf(f1,"\n");       
   fprintf(f1,"MDL : %2s",loc_legend[150]);
   prt_line(42," "); 
   fprintf(f1,"%-31s",nd_hospital_name.arr);
   prt_line(30," "); 
   fprintf(f1,"%-20s",nd_sysdate.arr);           
   fprintf(f1,"\n"); 
   fprintf(f1,"OPR : %-31s",nd_user_id.arr); 
   prt_line(13," ");    
   fprintf(f1,"%s",loc_legend[50]);
   prt_line(32," "); 
   fprintf(f1,"%4s :%-4d",loc_legend[30],page);           
   fprintf(f1,"\n"); 
   fprintf(f1,"REP : %8s",loc_legend[40]); 
   prt_line(40," "); 
   fprintf(f1,"AS ON %-10.10s",nd_sysdate.arr); 
   fprintf(f1,"\n"); 
   prt_line(132,"-");   
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

   fprintf(f1,"		%s  ",loc_legend[80]);

   if (strcmp(nd_option.arr,"E") == 0)
   {   fprintf(f1,"%10s",loc_legend[90]);}

   if (strcmp(nd_option.arr,"C") == 0)
   {   fprintf(f1,"%10s",loc_legend[100]);} 
	
   if (strcmp(nd_option.arr,"O") == 0)
   {   fprintf(f1,"%6s",loc_legend[110]);} 

   if (strcmp(nd_option.arr,"A") == 0)
   {   fprintf(f1,"All");} 

   fprintf(f1,"\n");    

   line = MAX_LINES + 1; 

}

	
void prt_hdr_next()
{
   fprintf(f1,"\n");    
   fprintf(f1,"%9s  %4s       %11s %10s  %s                         ",loc_legend[130],loc_legend[140],loc_legend[160],loc_legend[170],loc_legend[180]);  
   fprintf(f1,"    %14s   %7s %6s  %6s      %9s ",loc_legend[190],loc_legend[200],loc_legend[210],loc_legend[210],loc_legend[220]);
   fprintf(f1,"\n");    
   prt_line(73," ");        
   fprintf(f1,"             %6s            %6s  %6s %4s %4s      ",loc_legend[230],loc_legend[240],loc_legend[250],loc_legend[140],loc_legend[140]);
   fprintf(f1, "\n");   
   prt_line(132,"-");  
   fprintf(f1, "\n");     
}

void prt_line(int line_length, char spl_symbol[1])
{  
 int i;  
  for(i=1;i<=line_length;i=i+1)
	 {fprintf(f1,spl_symbol);}
}

void dec_cursor()
{ 
  /* EXEC SQL DECLARE hcare_cursor CURSOR FOR   
  		SELECT	a.customer_code				 customer_code ,
				b.short_name 				customer_name,
				a.hcare_appl_num			appl_num,
				TO_CHAR(a.hcare_appl_date,'dd/mm/yyyy') appl_date,
				TO_CHAR(a.action_date,'dd/mm/yyyy')	effective_date,
				a.employee_id				employee_id,
				a.patient_id				patient_id,
                        c.short_name,
				SUBSTR(c.short_name,1,30)
									patinet_name,
			    SUBSTR(c.short_name,31,60)
									patinet_name1,
				'Regular'		hcare_scheme,	
				DECODE(a.payment_option,'I','Immediate',
							'R','Credit',
				                        'S','Salary Ded.',
							'L','Instalment')
									Payment,
				TO_CHAR(a.hcare_start_date,'dd/mm/yyyy')
									hcare_start_date,
				TO_CHAR(a.hcare_expiry_date,'dd/mm/yyyy')
									hcare_expiry_date,
				a.subscription_amt			subscription_amt,
				NVL(a.no_of_dependents,0)
									no_of_dependant		
		FROM		bl_hcare_trn				a,
				ar_customer				b, 
				mp_patient_mast 				c
		WHERE		a.customer_code		=	b.cust_code
		AND		a.patient_id		=	c.patient_id
		AND		a.emp_patient_id	IS 	NULL		
		AND		a.customer_code		IS 	NOT NULL 	
		AND		a.payment_option	=	'R'
		AND             a.hcare_expiry_date 	>=	SYSDATE
		AND		a.hcare_status		=	'A'
		AND		a.operating_facility_id = 	:nd_facility_id
		ORDER BY 	a.customer_code,
				a.hcare_appl_num; */ 


		return;
 }

void dec_cursor1()
{ 

  /* EXEC SQL DECLARE hcare_cursor1 CURSOR FOR   
  		SELECT		a.customer_code				customer_code,
				''	 				customer_name,
				a.hcare_appl_num			appl_num,							TO_CHAR(a.hcare_appl_date,'dd/mm/yyyy') appl_date,
				TO_CHAR(a.action_date,'dd/mm/yyyy')	effective_date,
				a.employee_id				employee_id,
				a.patient_id				patient_id,
                        c.short_name,
				SUBSTR(c.short_name,1,30)
									patinet_name,
				SUBSTR(c.short_name,31,60)
									patinet_name1,
				'Regular' 			hcare_scheme,	
				DECODE(a.payment_option,'I','Immediate',
							'R','Credit',
				                        'S','Salary Ded.',
							'L','Instalment')
									Payment,
				TO_CHAR(a.hcare_start_date,'dd/mm/yyyy')
									hcare_start_date,
				TO_CHAR(a.hcare_expiry_date,'dd/mm/yyyy')
									hcare_expiry_date,
				a.subscription_amt			subscription_amt,
				NVL(a.no_of_dependents,0)
									no_of_dependant		
		FROM		bl_hcare_trn				a,
				mp_patient_mast				c
		WHERE		a.patient_id		=	c.patient_id
		AND		a.emp_patient_id	IS 	NULL
		AND		a.hcare_status		=	'A'
		AND		((:nd_option	 	=	'E'
				AND a.employee_id	IS NOT NULL
				AND a.payment_option    <> 'R')
				OR
				(:nd_option	 	=	'O'
				AND a.employee_id	IS     NULL
				AND a.customer_code	IS     NULL))	
		AND             a.hcare_expiry_date 	>=     SYSDATE
		AND		a.operating_facility_id = :nd_facility_id		
		ORDER BY 	a.customer_code,a.hcare_appl_num; */ 

	
	 	return;
 }

void dec_cursor2()
{ 

  /* EXEC SQL DECLARE hcare_cursor2 CURSOR FOR   
		SELECT		a.customer_code				customer_code,
				b.short_name 				customer_name,
				a.hcare_appl_num			appl_num,
				TO_CHAR(a.hcare_appl_date,'dd/mm/yyyy') appl_date,
				TO_CHAR(a.action_date,'dd/mm/yyyy')	effective_date,
				a.employee_id				employee_id,
				a.patient_id				patient_id,
                        c.short_name,
				SUBSTR(c.short_name,1,30)
									patient_name,  
				SUBSTR(c.short_name,31,60)
									patient_name1,
				'Regular'			hcare_scheme,	
				DECODE(a.payment_option,'I','Immediate',
							'R','Credit',
				                        'S','Salary Ded.',
							'L','Instalment')
									Payment,
				TO_CHAR(a.hcare_start_date,'dd/mm/yyyy')
									hcare_start_date,
				TO_CHAR(a.hcare_expiry_date,'dd/mm/yyyy')
									hcare_expiry_date,
				a.subscription_amt			subscription_amt,
				NVL(a.no_of_dependents,0)
									no_of_dependant,
				DECODE(a.customer_code,NULL,'','C')	appl_type
		FROM		bl_hcare_trn				a,
				ar_customer				b,
				mp_patient_mast				c
		WHERE		a.customer_code		=	b.cust_code
		AND		a.patient_id		=	c.patient_id
		AND		a.emp_patient_id	IS 	NULL		
		AND		a.customer_code		IS 	NOT NULL 	
		AND		a.payment_option	=	'R'
		AND             a.hcare_expiry_date 	>=	SYSDATE
		AND		a.hcare_status		=	'A'
		AND		a.operating_facility_id = 	:nd_facility_id  		
		
		UNION

		SELECT		a.customer_code				customer_code,
				'A'	 				customer_name,
				a.hcare_appl_num			appl_num,							TO_CHAR(a.hcare_appl_date,'dd/mm/yyyy') appl_date,
				TO_CHAR(a.action_date,'dd/mm/yyyy')	effective_date,
				a.employee_id				employee_id,
				a.patient_id				patient_id,
                        c.short_name,
				SUBSTR(c.short_name,1,30)
									patinet_name,
				SUBSTR(c.short_name,31,60)
									patinet_name1,
				'Regular'			hcare_scheme,	
				DECODE(a.payment_option,'I','Immediate',
							'R','Credit',
				                        'S','Salary Ded.',
							'L','Instalment')
									Payment,
				TO_CHAR(a.hcare_start_date,'dd/mm/yyyy')
									hcare_start_date,
				TO_CHAR(a.hcare_expiry_date,'dd/mm/yyyy')
									hcare_expiry_date,
				a.subscription_amt			subscription_amt,
				NVL(a.no_of_dependents,0)		no_of_dependant,						
				DECODE(a.employee_id,NULL,'O','E')      appl_type
		FROM    bl_hcare_trn				a,
				mp_patient_mast				c
		WHERE		a.patient_id		=	c.patient_id
		AND		a.emp_patient_id	IS 	NULL
		AND		a.hcare_status		=	'A'
		AND 		a.customer_code	IS     NULL
		AND             trunc(a.hcare_expiry_date) 	>=     trunc(SYSDATE)
		AND		a.operating_facility_id = :nd_facility_id		
		ORDER BY 	15,1,3; */ 

	
	 	return;
 }


void open_cursor()
{ 
 /* EXEC SQL OPEN hcare_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.customer_code customer_code ,b.short_name customer_name ,a.hcar\
e_appl_num appl_num ,TO_CHAR(a.hcare_appl_date,'dd/mm/yyyy') appl_date ,TO_C\
HAR(a.action_date,'dd/mm/yyyy') effective_date ,a.employee_id employee_id ,a\
.patient_id patient_id ,c.short_name ,SUBSTR(c.short_name,1,30) patinet_name\
 ,SUBSTR(c.short_name,31,60) patinet_name1 ,'Regular' hcare_scheme ,DECODE(a\
.payment_option,'I','Immediate','R','Credit','S','Salary Ded.','L','Instalme\
nt') Payment ,TO_CHAR(a.hcare_start_date,'dd/mm/yyyy') hcare_start_date ,TO_\
CHAR(a.hcare_expiry_date,'dd/mm/yyyy') hcare_expiry_date ,a.subscription_amt\
 subscription_amt ,NVL(a.no_of_dependents,0) no_of_dependant  from bl_hcare_\
trn a ,ar_customer b ,mp_patient_mast c where (((((((a.customer_code=b.cust_\
code and a.patient_id=c.patient_id) and a.emp_patient_id is null ) and a.cus\
tomer_code is  not null ) and a.payment_option='R') and a.hcare_expiry_date>\
=SYSDATE) and a.hcare_status='A') and a.operating_facility_id=:b0) order by \
a.customer_code,a.hcare_appl");
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
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.customer_code customer_code ,'' customer_name ,a.hcare_appl_num\
 appl_num ,TO_CHAR(a.hcare_appl_date,'dd/mm/yyyy') appl_date ,TO_CHAR(a.acti\
on_date,'dd/mm/yyyy') effective_date ,a.employee_id employee_id ,a.patient_i\
d patient_id ,c.short_name ,SUBSTR(c.short_name,1,30) patinet_name ,SUBSTR(c\
.short_name,31,60) patinet_name1 ,'Regular' hcare_scheme ,DECODE(a.payment_o\
ption,'I','Immediate','R','Credit','S','Salary Ded.','L','Instalment') Payme\
nt ,TO_CHAR(a.hcare_start_date,'dd/mm/yyyy') hcare_start_date ,TO_CHAR(a.hca\
re_expiry_date,'dd/mm/yyyy') hcare_expiry_date ,a.subscription_amt subscript\
ion_amt ,NVL(a.no_of_dependents,0) no_of_dependant  from bl_hcare_trn a ,mp_\
patient_mast c where (((((a.patient_id=c.patient_id and a.emp_patient_id is \
null ) and a.hcare_status='A') and (((:b0='E' and a.employee_id is  not null\
 ) and a.payment_option<>'R') or ((:b0='O' and a.employee_id is null ) and a\
.customer_code is null ))) and a.hcare_expiry_date>=SYSDATE) and a.operating\
_facility_id=:b2) order by a.customer_co");
 sqlstm.stmt = sq0007;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )135;
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


 if (sqlca.sqlcode < 0) 
	 {	disp_message (ORA_MESG, "Open HCare Cursor1 Failed");
       		proc_exit();
	 } 
	 return;
 }

void open_cursor2()
{ 
 /* EXEC SQL OPEN hcare_cursor2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.customer_code customer_code ,b.short_name customer_name ,a.hcar\
e_appl_num appl_num ,TO_CHAR(a.hcare_appl_date,'dd/mm/yyyy') appl_date ,TO_C\
HAR(a.action_date,'dd/mm/yyyy') effective_date ,a.employee_id employee_id ,a\
.patient_id patient_id ,c.short_name ,SUBSTR(c.short_name,1,30) patient_name\
 ,SUBSTR(c.short_name,31,60) patient_name1 ,'Regular' hcare_scheme ,DECODE(a\
.payment_option,'I','Immediate','R','Credit','S','Salary Ded.','L','Instalme\
nt') Payment ,TO_CHAR(a.hcare_start_date,'dd/mm/yyyy') hcare_start_date ,TO_\
CHAR(a.hcare_expiry_date,'dd/mm/yyyy') hcare_expiry_date ,a.subscription_amt\
 subscription_amt ,NVL(a.no_of_dependents,0) no_of_dependant ,DECODE(a.custo\
mer_code,null ,'','C') appl_type  from bl_hcare_trn a ,ar_customer b ,mp_pat\
ient_mast c where (((((((a.customer_code=b.cust_code and a.patient_id=c.pati\
ent_id) and a.emp_patient_id is null ) and a.customer_code is  not null ) an\
d a.payment_option='R') and a.hcare_expiry_date>=SYSDATE) and a.hcare_status\
='A') and a.operating_facility_id=:b0) u");
 sqlstm.stmt = sq0008;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )162;
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
}


 if (sqlca.sqlcode < 0) 
	 {	disp_message (ORA_MESG, "Open HCare Cursor2 Failed");
       		proc_exit();
	 } 
	 return;
 }



int fetch_cursor()
{ 
  /* EXEC SQL FETCH hcare_cursor 
	   INTO :nd_customer_code,
		:nd_customer_name,
		:nd_appl_num,
		:nd_hcare_appl_date,
		:nd_hcare_effective_date,
		:nd_employee_id,
		:nd_patient_id ,
            :d_short_name_full,
		:nd_patient_name,
		:nd_patient_name1,
		:nd_hcare_scheme,	
		:nd_payment_option,
		:nd_hcare_start_date,
		:nd_hcare_expiry_date,
		:nd_subscription_amt,
		:nd_no_of_dependant; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )185;
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
  sqlstm.sqhstv[3] = (         void  *)&nd_hcare_appl_date;
  sqlstm.sqhstl[3] = (unsigned int  )14;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_hcare_effective_date;
  sqlstm.sqhstl[4] = (unsigned int  )14;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_employee_id;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_short_name_full;
  sqlstm.sqhstl[7] = (unsigned int  )63;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_patient_name;
  sqlstm.sqhstl[8] = (unsigned int  )63;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_patient_name1;
  sqlstm.sqhstl[9] = (unsigned int  )33;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_hcare_scheme;
  sqlstm.sqhstl[10] = (unsigned int  )9;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_payment_option;
  sqlstm.sqhstl[11] = (unsigned int  )13;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_hcare_start_date;
  sqlstm.sqhstl[12] = (unsigned int  )14;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_hcare_expiry_date;
  sqlstm.sqhstl[13] = (unsigned int  )14;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_subscription_amt;
  sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_no_of_dependant;
  sqlstm.sqhstl[15] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
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



    if (NODATAFOUND)
    return 0;

    nd_customer_code.arr[nd_customer_code.len]		= '\0';
    nd_customer_name.arr[nd_customer_name.len]	 	= '\0';
    nd_appl_num.arr[nd_appl_num.len]			= '\0';
    nd_employee_id.arr[nd_employee_id.len]		= '\0';
    nd_patient_id.arr[nd_patient_id.len] 		= '\0';
    nd_patient_name.arr[nd_patient_name.len] 		= '\0';
	nd_patient_name1.arr[nd_patient_name1.len] 		= '\0';
    nd_hcare_scheme.arr[nd_hcare_scheme.len] 		= '\0';
    nd_payment_option.arr[nd_payment_option.len]	= '\0';
    nd_hcare_start_date.arr[nd_hcare_start_date.len]	= '\0';
    nd_hcare_expiry_date.arr[nd_hcare_expiry_date.len] 	= '\0';
     d_short_name_full.arr[d_short_name_full.len]               = '\0';
 

    return 1;
 }

int fetch_cursor1()
{ 
  /* EXEC SQL FETCH hcare_cursor1 
	   INTO :nd_customer_code,
		:nd_customer_name,
		:nd_appl_num,
		:nd_hcare_appl_date,
		:nd_hcare_effective_date,
		:nd_employee_id,
		:nd_patient_id,
            :d_short_name_full,
		:nd_patient_name,
		:nd_patient_name1,
		:nd_hcare_scheme,	
		:nd_payment_option,
		:nd_hcare_start_date,
		:nd_hcare_expiry_date,
		:nd_subscription_amt,
		:nd_no_of_dependant; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )264;
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
  sqlstm.sqhstv[3] = (         void  *)&nd_hcare_appl_date;
  sqlstm.sqhstl[3] = (unsigned int  )14;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_hcare_effective_date;
  sqlstm.sqhstl[4] = (unsigned int  )14;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_employee_id;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_short_name_full;
  sqlstm.sqhstl[7] = (unsigned int  )63;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_patient_name;
  sqlstm.sqhstl[8] = (unsigned int  )63;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_patient_name1;
  sqlstm.sqhstl[9] = (unsigned int  )33;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_hcare_scheme;
  sqlstm.sqhstl[10] = (unsigned int  )9;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_payment_option;
  sqlstm.sqhstl[11] = (unsigned int  )13;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_hcare_start_date;
  sqlstm.sqhstl[12] = (unsigned int  )14;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_hcare_expiry_date;
  sqlstm.sqhstl[13] = (unsigned int  )14;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_subscription_amt;
  sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_no_of_dependant;
  sqlstm.sqhstl[15] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
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



    if (NODATAFOUND)
    return 0;

    nd_customer_code.arr[nd_customer_code.len]		= '\0';
    nd_customer_name.arr[nd_customer_name.len]	 	= '\0';
    nd_appl_num.arr[nd_appl_num.len]			= '\0';
    nd_hcare_appl_date.arr[nd_hcare_appl_date.len]	= '\0';
    nd_hcare_effective_date.arr[nd_hcare_effective_date.len]
							= '\0';
    nd_employee_id.arr[nd_employee_id.len]		= '\0';
    nd_patient_id.arr[nd_patient_id.len] 		= '\0';
    nd_patient_name.arr[nd_patient_name.len] 		= '\0';
	nd_patient_name1.arr[nd_patient_name1.len] 		= '\0';

    nd_hcare_scheme.arr[nd_hcare_scheme.len] 		= '\0';
    nd_payment_option.arr[nd_payment_option.len]	= '\0';
    nd_hcare_start_date.arr[nd_hcare_start_date.len]	= '\0';
    nd_hcare_expiry_date.arr[nd_hcare_expiry_date.len] 	= '\0';
         d_short_name_full.arr[d_short_name_full.len]               = '\0';
 
    return 1;
 }

int fetch_cursor2()
{ 
  /* EXEC SQL FETCH hcare_cursor2 
	   INTO :nd_customer_code,
		:nd_customer_name,
		:nd_appl_num,  
		:nd_hcare_appl_date,
		:nd_hcare_effective_date,
		:nd_employee_id,
		:nd_patient_id,
            :d_short_name_full,
		:nd_patient_name,
		:nd_patient_name1,
		:nd_hcare_scheme,	
		:nd_payment_option,
		:nd_hcare_start_date,
		:nd_hcare_expiry_date,  
		:nd_subscription_amt,
		:nd_no_of_dependant,
		:nd_app_type	   ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )343;
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
  sqlstm.sqhstv[3] = (         void  *)&nd_hcare_appl_date;
  sqlstm.sqhstl[3] = (unsigned int  )14;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_hcare_effective_date;
  sqlstm.sqhstl[4] = (unsigned int  )14;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_employee_id;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_short_name_full;
  sqlstm.sqhstl[7] = (unsigned int  )63;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_patient_name;
  sqlstm.sqhstl[8] = (unsigned int  )63;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_patient_name1;
  sqlstm.sqhstl[9] = (unsigned int  )33;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_hcare_scheme;
  sqlstm.sqhstl[10] = (unsigned int  )9;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_payment_option;
  sqlstm.sqhstl[11] = (unsigned int  )13;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_hcare_start_date;
  sqlstm.sqhstl[12] = (unsigned int  )14;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_hcare_expiry_date;
  sqlstm.sqhstl[13] = (unsigned int  )14;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_subscription_amt;
  sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_no_of_dependant;
  sqlstm.sqhstl[15] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_app_type;
  sqlstm.sqhstl[16] = (unsigned int  )4;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
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



    if (NODATAFOUND)
    return 0;

    nd_customer_code.arr[nd_customer_code.len]		= '\0';
    nd_customer_name.arr[nd_customer_name.len]	 	= '\0';
    nd_appl_num.arr[nd_appl_num.len]			= '\0';
    nd_hcare_appl_date.arr[nd_hcare_appl_date.len]	= '\0';
    nd_hcare_effective_date.arr[nd_hcare_effective_date.len]
							= '\0';
    nd_employee_id.arr[nd_employee_id.len]		= '\0';
    nd_patient_id.arr[nd_patient_id.len] 		= '\0';
    nd_patient_name.arr[nd_patient_name.len] 		= '\0';
	nd_patient_name1.arr[nd_patient_name1.len] 		= '\0';
    nd_hcare_scheme.arr[nd_hcare_scheme.len] 		= '\0';
    nd_payment_option.arr[nd_payment_option.len]	= '\0';
    nd_hcare_start_date.arr[nd_hcare_start_date.len]	= '\0';
    nd_hcare_expiry_date.arr[nd_hcare_expiry_date.len] 	= '\0';
    nd_app_type.arr[nd_app_type.len]		 	= '\0';
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
sqlstm.arrsiz = 17;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ; \
BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str2\
 ) ; IF str2 IS NOT NULL THEN :nd_patient_name := str2 ; END IF ; blcommon . s\
plit_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS NO\
T NULL THEN :nd_patient_name1 := str2 ; END IF ; blcommon . split_words ( :d_s\
hort_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :nd_p\
atient_name1 := :nd_patient_name1 || str2 ; end if ; END ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )426;
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
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )453;
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
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )468;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 return;
 }
void close_cursor2()
{ 
 /* EXEC SQL CLOSE hcare_cursor2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )483;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 return;
 }


void sub_hdr_prt()

{	
	fprintf(f1,"%8s  : %-9s",loc_legend[310] ,nd_customer_code.arr); 		
        fprintf(f1," - ");
	fprintf(f1,"%-60s" 	      ,nd_customer_name.arr); 		
       	fprintf(f1,"\n");
   	fprintf(f1,"\n");
	line = line +2;
	line_check();
}
	
void prev_sub_hdr_prt()

{	
	fprintf(f1,"%8s  : %-9s",loc_legend[310] ,nd_prev_customer_code.arr); 		
        fprintf(f1," - ");
	fprintf(f1,"%-60s" 	      ,nd_prev_customer_name.arr); 		
       	fprintf(f1,"\n");
   	fprintf(f1,"\n");
	line = line +2;
	line_check();
}


void rec_prt()
{
       {fprintf(f1,"%-10s "	,nd_appl_num.arr);	
	fprintf(f1,"%-10s "	,nd_hcare_appl_date.arr);		
        fprintf(f1,"%-10s  "  	,nd_employee_id.arr);
	fprintf(f1,"%-20s " 	,nd_patient_id.arr);
        fprintf(f1,"%-30.30s " 	,nd_patient_name.arr);
    if (nd_fmt_string == 3)
	{fprintf(f1,"%10.3f " 	,nd_subscription_amt);}
    else
	{fprintf(f1,"%10.2f " 	,nd_subscription_amt);}

	fprintf(f1,"%-11s"  	,nd_payment_option.arr);
	fprintf(f1,"  %4d "  	,nd_no_of_dependant);

	fprintf(f1,"%-7s " 	,nd_hcare_scheme.arr);
        
	fprintf(f1,"%-10s  " 	,nd_hcare_start_date.arr);
        fprintf(f1,"%-10s "  	,nd_hcare_expiry_date.arr);

        nd_tot_appl = nd_tot_appl + 1;
        nd_tot_amt  = nd_tot_amt + nd_subscription_amt;
	nd_grand_tot_appl = nd_grand_tot_appl + 1;
	nd_grand_tot_amt  = nd_grand_tot_amt + nd_subscription_amt; 

        fprintf(f1,"\n");
	
	if(strlen(nd_patient_name1.arr) > 2)
	{
	fprintf(f1,"%50s %s \n"," ",nd_patient_name1.arr);
	line++;
	}


     }

	line = line + 1;	
	line_check();
}

void tot_prt()
   {
	fprintf(f1,"\n");
	prt_line(30," ");
	fprintf(f1,"%25s  %-7d",loc_legend[320],nd_tot_appl);
       	fprintf(f1,"  %s    ",loc_legend[330]);
	if (nd_fmt_string == 3)
		{fprintf(f1,"%10.3f " 	,nd_tot_amt);}
	else
		{fprintf(f1,"%10.2f " 	,nd_tot_amt);}
	
	nd_tot_appl = 0;
        nd_tot_amt  = 0;
	fprintf(f1,"\n");
	fprintf(f1,"\n");
	line = line +3;
	line_check();
    }


void grand_tot_prt()
   {	
	prt_line(30," ");
	fprintf(f1,"%11s                %-7d",loc_legend[340],nd_grand_tot_appl);
       	fprintf(f1,"  %s    ",loc_legend[330]);
	if (nd_fmt_string == 3)
		{fprintf(f1,"%10.3f " 	,nd_grand_tot_amt);}
	else
		{fprintf(f1,"%10.2f " 	,nd_grand_tot_amt);}
	
	fprintf(f1,"\n");
	line = line +2;
	line_check();

    }


void report_process()
{        
    int fetch_cursor_check;
	dec_cursor();
	open_cursor();	    
	line_check();  
        fetch_cursor_check = fetch_cursor();
        strcpy(nd_prev_customer_code.arr,nd_customer_code.arr);
        strcpy(nd_prev_customer_name.arr,nd_customer_name.arr);
	line_check();          
  while(fetch_cursor_check)  {  
     if (strcmp(nd_prev_customer_code.arr,nd_customer_code.arr) == 0)
        { 
	 if (line == 0 )
	  {  sub_hdr_prt();}
	     rec_prt();}	
     else
       { 
	
          if (line == 0 )
	  	{ prev_sub_hdr_prt();} 
	    	  tot_prt();		
          if (line > (MAX_LINES-3))
          	{ line = MAX_LINES +1;
	    	  line_check();	
		}	
	       	  sub_hdr_prt();
		  rec_prt();
       }        
        strcpy(nd_prev_customer_code.arr,nd_customer_code.arr);
        strcpy(nd_prev_customer_name.arr,nd_customer_name.arr);
        fetch_cursor_check = fetch_cursor();	             
     }
 	tot_prt();	
	close_cursor();
  }

void report_process1()
{        
    int fetch_cursor_check;
	dec_cursor1();
	open_cursor1();	    
        fetch_cursor_check = fetch_cursor1();        

	line_check();  
         
  while(fetch_cursor_check)  {  
 
	rec_prt();      
        fetch_cursor_check = fetch_cursor1();	 	
	
       }
	tot_prt(); 	
	close_cursor1();
}

void report_process2()
{        
	int fetch_cursor_check;
	cust_count = 0;
 	emp_count = 0;
	other_count = 0;
	
	dec_cursor2();
	open_cursor2();	    
        fetch_cursor_check = fetch_cursor2();
        strcpy(nd_prev_customer_code.arr,nd_customer_code.arr);
        strcpy(nd_prev_customer_name.arr,nd_customer_name.arr);
	line_check();  
         
  while(fetch_cursor_check)  {  
  if (strcmp(nd_app_type.arr,"C") == 0 )   
  {
     if (strcmp(nd_prev_customer_code.arr,nd_customer_code.arr) == 0)
        { 
	 if (line == 0 )
            {  
	       if (cust_count == 0)
	       {	
	       fprintf(f1,"%10s",loc_legend[100]);
	       fprintf(f1,"\n");		
       	       fprintf(f1,"\n");	
	       line = line + 2;
	       line_check();	   }
		
		sub_hdr_prt();}
	     	rec_prt();
	}	
     else
       { 	
          if (line == 0 )
	  	{ prev_sub_hdr_prt();} 
	    	  tot_prt();		
          if (line > (MAX_LINES-3))
          	{ line = MAX_LINES +1;
	    	  line_check();	
		}	
	       	  sub_hdr_prt();
		  rec_prt();
       }        
	strcpy(nd_prev_customer_code.arr,nd_customer_code.arr);
        strcpy(nd_prev_customer_name.arr,nd_customer_name.arr);        
	cust_count = cust_count + 1;
     }

    if (strcmp(nd_app_type.arr,"E") == 0 )
    { 
       if (line > (MAX_LINES-3))
          	{ line = MAX_LINES +1;
	    	  line_check();			  
		}	
      if (line == 0 && cust_count > 0 && emp_count == 0 )
      { sub_hdr_prt();
	tot_prt();} 
  
      if (line != 0 && cust_count > 0 && emp_count == 0 )
      { tot_prt();} 

      if (line == 0 || emp_count == 0)	
      {fprintf(f1,"%10s",loc_legend[90]);
       fprintf(f1,"\n");		
       fprintf(f1,"\n");	
       line = line + 2;
       line_check();}
       
       rec_prt();      
       emp_count = emp_count + 1;

     }

    if (strcmp(nd_app_type.arr,"O") == 0 )
    {        
    
      if (line > (MAX_LINES-3))
          	{ line = MAX_LINES +1;
	    	  line_check();			  
		}	
      if (line == 0 && cust_count > 0 && emp_count == 0 && other_count == 0 )
      { sub_hdr_prt();
	tot_prt();} 
  
      if (line != 0 && cust_count > 0 && emp_count == 0 && other_count == 0)
      { tot_prt();} 
  
      if (line == 0 && emp_count > 0  &&  other_count == 0 )
      { 
	    fprintf(f1,"%10s",loc_legend[90]);
	    fprintf(f1,"\n");		
            fprintf(f1,"\n");	
            line = line + 2;
            line_check();
	    tot_prt();} 
  
      if (line != 0 && emp_count > 0 && other_count == 0)
      { tot_prt();} 
      

      if (line == 0 || other_count == 0)	
      {fprintf(f1,"%6s",loc_legend[110]);
       fprintf(f1,"\n");		
       fprintf(f1,"\n");	
       line = line + 2;
       line_check();}
       other_count = other_count + 1;       
       rec_prt();      
     }        
         
        fetch_cursor_check = fetch_cursor2();	                   
    }
   
	tot_prt();       
	close_cursor2();
  }

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRBLOUT.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRBLOUT.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )498;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&i;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_pk_value;
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



		l_pk_value.arr[l_pk_value.len]	= '\0';
		l_translated_value.arr[0]		= '\0';

		/* EXEC SQL EXECUTE
		BEGIN
			blcommon.get_local_lang_desc(:nd_facility_id,
										'SM',
										'SM_LANG_LEGEND',
										'DFLT_LEGEND_VALUE',
										:l_pk_value,
										:l_translated_value,
										:p_language_id);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )521;
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
  sqlstm.sqhstv[1] = (         void  *)&l_pk_value;
  sqlstm.sqhstl[1] = (unsigned int  )102;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_translated_value;
  sqlstm.sqhstl[2] = (unsigned int  )203;
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



		l_translated_value.arr[l_translated_value.len] = '\0';
		strcpy(loc_legend[i],l_translated_value.arr);
	}
}




