
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
    "C:\\proc\\blthcsap.pc"
};


static unsigned long sqlctx = 36416331;


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

 static const char *sq0004 = 
"select a.hcare_appl_num appl_no ,TO_CHAR(a.hcare_appl_date,'DD/MM/YYYY') app\
l_date ,a.patient_id patient_id ,b.short_name patient_name ,d.short_desc hcare\
_scheme ,a.subscription_amt subscription_amt ,DECODE(a.payment_option,'I','IMM\
EDIATE','R','CREDIT BILL','S','ONE TIME DEDUCTION FROM SALARY','L','INSTALMENT\
S') payment_option ,a.customer_code customer_code ,TO_CHAR(a.hcare_start_date,\
'DD/MM/YYYY') hcare_start_date ,TO_CHAR(a.hcare_expiry_date,'DD/MM/YYYY') hcar\
e_expiry_date ,c.hcard_num hcard_num ,a.employee_id employee_num ,NVL(SUBSTR(a\
.action_remarks,1,50),'~') remarks ,a.emp_patient_id emp_patient_id  from bl_h\
care_trn a ,mp_patient_mast b ,bl_patient_fin_dtls c ,bl_health_scheme d where\
 ((((a.hcare_appl_num=:b0 and a.operating_facility_id=:b1) and a.patient_id=b.\
patient_id) and c.patient_id=a.patient_id) and a.scheme_id=d.scheme_id) order \
by a.emp_patient_id desc             ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,114,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,92,0,4,140,0,0,3,1,0,1,0,2,9,0,0,2,3,0,0,1,9,0,0,
63,0,0,3,0,0,30,149,0,0,0,0,0,1,0,
78,0,0,4,893,0,9,232,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
101,0,0,4,0,0,13,305,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
172,0,0,5,157,0,4,341,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
199,0,0,4,0,0,15,356,0,0,0,0,0,1,0,
};



/* Preprocessor Directives  */

#include <stdio.h>
#include <string.h>
#include <math.h>   
//#include <sqlca.h> 
//#include <sqlda.h>
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




#include <bl.h>
#define ONLINE_PRINTING 1


#include <winproc.h>

/* Macros */

#define NODATAFOUND sqlca.sqlcode==1403
#define OERROR (sqlca.sqlcode < 0) 
#define MAX_LINES 55

/* Declarations */


/* EXEC SQL BEGIN DECLARE SECTION; */ 
	

	/* VARCHAR uid_pwd 	        	[91],	        	     
		nd_facility_id			[3] ,
		nd_facility			[3] ,
		nd_appl_num			[21],
		nd_appl_no			[11],     
		nd_currency			[10],
		nd_appl_date			[15],
		nd_patient_id			[21],
		nd_patient_name			[61],
		nd_employee_no			[10] ,
		nd_hcare_scheme			[45],
		nd_payment_option		[40],
		nd_customer_code		[15],
		nd_customer_name		[41],    
		nd_hcare_start_date		[15],
		nd_hcare_expiry_date		[15],
		nd_hcard_num			[41],
		nd_remarks			[101],
		nd_emp_patient_id		[21],
		nd_session			[20],
		l_msg				[50],
		nd_pgm_date			[20]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[21]; } nd_appl_num;

struct { unsigned short len; unsigned char arr[11]; } nd_appl_no;

struct { unsigned short len; unsigned char arr[10]; } nd_currency;

struct { unsigned short len; unsigned char arr[15]; } nd_appl_date;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[61]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[10]; } nd_employee_no;

struct { unsigned short len; unsigned char arr[45]; } nd_hcare_scheme;

struct { unsigned short len; unsigned char arr[40]; } nd_payment_option;

struct { unsigned short len; unsigned char arr[15]; } nd_customer_code;

struct { unsigned short len; unsigned char arr[41]; } nd_customer_name;

struct { unsigned short len; unsigned char arr[15]; } nd_hcare_start_date;

struct { unsigned short len; unsigned char arr[15]; } nd_hcare_expiry_date;

struct { unsigned short len; unsigned char arr[41]; } nd_hcard_num;

struct { unsigned short len; unsigned char arr[101]; } nd_remarks;

struct { unsigned short len; unsigned char arr[21]; } nd_emp_patient_id;

struct { unsigned short len; unsigned char arr[20]; } nd_session;

struct { unsigned short len; unsigned char arr[50]; } l_msg;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;
		
	
	char    nd_filename		        [100];

	long  	nd_fmt_string			    ;

	double	nd_subscription_amt		    ;		

	int page_ct = 0;


/* EXEC SQL END DECLARE SECTION; */ 



		FILE *f1;
		int page = 0;
		int line = 0;

void proc_main(argc, argv)
	int argc;
	char *argv[];
{    
   void prt_line(int l, char spl_symbol[1]);
   void dec_cursor();
   void open_cursor();
   void close_cursor();
   int  fetch_cursor();
  
   void report_process();
   void line_check();
   

/* INPUT ARGUMENT CHECK */

      if(argc < 6) 
     {
	     disp_message(ORA_MESG, "Usage BLTHCSAP Uid/Passwd@DB Session Pgm-Date  Operating-Facility Appl-No");
	     proc_exit();
     }

     strcpy(uid_pwd.arr, argv[1]);
     uid_pwd.len = strlen(uid_pwd.arr);      	 

     strcpy(nd_session.arr, argv[2]);
     nd_session.len = strlen(nd_session.arr);      	  
     strcpy(g_session_id,nd_session.arr);

     strcpy(nd_pgm_date.arr, argv[3]);
     nd_pgm_date.len = strlen(nd_pgm_date.arr);      	  
     strcpy(g_pgm_date,nd_pgm_date.arr);

     strcpy(nd_facility_id.arr, argv[4]);
     nd_facility_id.len = strlen(nd_facility_id.arr);      	  


     strcpy(nd_facility.arr,nd_facility_id.arr);
     nd_facility.len = strlen(nd_facility.arr);      	  
     strcpy(g_facility_id,nd_facility.arr);

     strcpy(nd_appl_num.arr,argv[6]);
     nd_appl_num.len = strlen(nd_appl_num.arr);    
	 
   
/* DB LOGIN */

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


    if (OERROR) 
    {
    	disp_message (ORA_MESG, "USERID/PASSWORD failed to Connect");
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

/* PROCESS */   


    nd_currency.arr[0] = '\0';
    nd_currency.len = 0;

    /* EXEC SQL SELECT base_currency ,no_of_decimal INTO :nd_currency,:nd_fmt_string 
	     FROM sy_acc_entity
	     WHERE acc_entity_id = :nd_facility; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select base_currency ,no_of_decimal into :b0,:b1  from sy\
_acc_entity where acc_entity_id=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_currency;
    sqlstm.sqhstl[0] = (unsigned int  )12;
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
    sqlstm.sqhstv[2] = (         void  *)&nd_facility;
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


   nd_currency.arr[nd_currency.len] = '\0';  

   report_process(); 
  
   /* CLOSE FILE */

   /* EXEC SQL COMMIT RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )63;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 
   fclose(f1);   

	
   PrintDocument   
   (
		uid_pwd.arr,		//char	*PUidPwd;
		nd_session.arr,			//char	*PSessionID;
		nd_facility.arr,	//char	*PFacilityID;
		"BL",				//char	*PModuleID;
		"BLTHCSAP",			//char	*PDocumentID;
		nd_filename,			//char	*POnlinePrintFileNames;
		"O",				//char	*PLocationTypes;
		"",				//char	*PLocationCodes;
		1,					//int		PNumOfCopies;
		1,					//int		PPageFrom;
		99					//int		PPageTo;
	);


  


   return;
   
}

void line_check()
{
   if (line > MAX_LINES)   
    {
      fprintf(f1,"\f");	
	  page_ct = 0;}
}       
	
void prt_line(int line_length, char spl_symbol[1])
{  
 int i;  
  for(i=1;i<=line_length;i=i+1)
	 {fprintf(f1,spl_symbol);}
}

void dec_cursor()
{   

  /* EXEC SQL DECLARE Hcare_cursor CURSOR FOR   	 
 
	SELECT	a.hcare_appl_num			appl_no,
		TO_CHAR(a.hcare_appl_date,'DD/MM/YYYY')	appl_date,
		a.patient_id			 patient_id,
		b.short_name		 patient_name,
		d.short_desc                hcare_scheme,
		a.subscription_amt			subscription_amt,
		DECODE(a.payment_option,'I','IMMEDIATE',
					'R','CREDIT BILL',
					'S','ONE TIME DEDUCTION FROM SALARY',
					'L','INSTALMENTS')					
							payment_option,
		a.customer_code				customer_code,
		TO_CHAR(a.hcare_start_date,'DD/MM/YYYY') hcare_start_date,
		TO_CHAR(a.hcare_expiry_date,'DD/MM/YYYY') hcare_expiry_date,
		c.hcard_num				hcard_num,
		a.employee_id				employee_num,
		NVL(SUBSTR(a.action_remarks,1,50),'~') 		remarks,
		a.emp_patient_id			emp_patient_id
	FROM 
		bl_hcare_trn a,
		mp_patient_mast   b,   
		bl_patient_fin_dtls c,
		bl_health_scheme   d
	WHERE   a.hcare_appl_num 	= :nd_appl_num
	AND	a.operating_facility_id = :nd_facility
	AND	a.patient_id 		= b.patient_id
	AND	c.patient_id 		= a.patient_id
	AND a.scheme_id         = d.scheme_id
	ORDER BY a.emp_patient_id DESC; */ 
	
			/*DECODE(a.hcare_scheme,'R','REGULAR',  'S','SPECIAL')	 	*/

 return;
 }

void open_cursor()
{ 
 /* EXEC SQL OPEN hcare_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0004;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )78;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_appl_num;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_facility;
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
 {     disp_message (ORA_MESG, "Open HCare Cursor Failed");
       proc_exit();
 }

 
 return;
 }

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30], fstr_amt[30];


    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        
        sprintf(str_amt,"%14s",s_amt);				
		ltrim (str_amt);		
		rtrim (str_amt);		
		strcpy(fstr_amt,"(-)");
		strcat(fstr_amt,str_amt);		
		ltrim (fstr_amt);		
		rtrim (fstr_amt);
		sprintf(str_amt,"%15s",fstr_amt);		
        fprintf(f1,"%15s ",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(f1,"%15s ",str_amt);
        }
	}                        



int fetch_cursor()
{ 

		nd_appl_no.arr[0] = '\0';
		nd_appl_date.arr[0] = '\0';
		nd_patient_id.arr[0] = '\0';
		nd_patient_name.arr[0] = '\0';
		nd_hcare_scheme.arr[0] = '\0';
		nd_subscription_amt = 0;
		nd_payment_option.arr[0] = '\0';
		nd_customer_code.arr[0] = '\0';
		nd_hcare_start_date.arr[0] = '\0';
		nd_hcare_expiry_date.arr[0] = '\0';
		nd_hcard_num.arr[0] = '\0';
		nd_employee_no.arr[0] = '\0';
		nd_remarks.arr[0] = '\0';
		nd_emp_patient_id.arr[0] = '\0';

		nd_appl_no.len = 0;
		nd_appl_date.len = 0;
		nd_patient_id.len = 0;
		nd_patient_name.len = 0;
		nd_hcare_scheme.len = 0;
		nd_payment_option.len = 0;
		nd_customer_code.len = 0;
		nd_hcare_start_date.len = 0;
		nd_hcare_expiry_date.len = 0;
		nd_hcard_num.len = 0;
		nd_employee_no.len = 0;
		nd_remarks.len = 0;
		nd_emp_patient_id.len = 0;

  /* EXEC SQL FETCH hcare_cursor 
	   INTO	:nd_appl_no		,
		:nd_appl_date		,
		:nd_patient_id		,
		:nd_patient_name	,
		:nd_hcare_scheme	,
		:nd_subscription_amt	,
		:nd_payment_option	,
		:nd_customer_code	,
		:nd_hcare_start_date	,
		:nd_hcare_expiry_date	,
		:nd_hcard_num		,
		:nd_employee_no		,
		:nd_remarks		,
		:nd_emp_patient_id	; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )101;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_appl_no;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_appl_date;
  sqlstm.sqhstl[1] = (unsigned int  )17;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_patient_name;
  sqlstm.sqhstl[3] = (unsigned int  )63;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_hcare_scheme;
  sqlstm.sqhstl[4] = (unsigned int  )47;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_subscription_amt;
  sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_payment_option;
  sqlstm.sqhstl[6] = (unsigned int  )42;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_customer_code;
  sqlstm.sqhstl[7] = (unsigned int  )17;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_hcare_start_date;
  sqlstm.sqhstl[8] = (unsigned int  )17;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_hcare_expiry_date;
  sqlstm.sqhstl[9] = (unsigned int  )17;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_hcard_num;
  sqlstm.sqhstl[10] = (unsigned int  )43;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_employee_no;
  sqlstm.sqhstl[11] = (unsigned int  )12;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_remarks;
  sqlstm.sqhstl[12] = (unsigned int  )103;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_emp_patient_id;
  sqlstm.sqhstl[13] = (unsigned int  )23;
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



    if (NODATAFOUND)
		return 0;

    nd_appl_no.arr[nd_appl_no.len]			= '\0';
    nd_appl_date.arr[nd_appl_date.len]			= '\0';
    nd_patient_id.arr[nd_patient_id.len]		= '\0';
    nd_patient_name.arr[nd_patient_name.len]		= '\0';
    nd_hcare_scheme.arr[nd_hcare_scheme.len]		= '\0';    
    nd_payment_option.arr[nd_payment_option.len]	= '\0';	
    nd_customer_code.arr[nd_customer_code.len]		= '\0';
    nd_hcare_start_date.arr[nd_hcare_start_date.len]	= '\0';
    nd_hcare_expiry_date.arr[nd_hcare_expiry_date.len]	= '\0';
    nd_hcard_num.arr[nd_hcard_num.len]			= '\0';
    nd_employee_no.arr[nd_employee_no.len	]	= '\0';
    nd_remarks.arr[nd_remarks.len]			= '\0';
    nd_emp_patient_id.arr[nd_emp_patient_id.len]	= '\0';

    nd_customer_name.arr[0]		= '\0';
    nd_customer_name.len = 0;

    /* EXEC SQL SELECT long_name INTO :nd_customer_name 
	     FROM   ar_customer
	     WHERE  cust_code = :nd_customer_code
	     AND acc_entity_code in ( select acc_entity_code from sy_acc_entity
		where acc_entity_id = :nd_facility); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select long_name into :b0  from ar_customer where (cust_c\
ode=:b1 and acc_entity_code in (select acc_entity_code  from sy_acc_entity whe\
re acc_entity_id=:b2))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )172;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_customer_name;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_customer_code;
    sqlstm.sqhstl[1] = (unsigned int  )17;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_facility;
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



    nd_customer_name.arr[nd_customer_name.len]		= '\0';

    return 1;

 }


void close_cursor()
{ 
 /* EXEC SQL CLOSE hcare_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )199;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 return;
 }


void report_process()
{        
    int fetch_cursor_check;
	dec_cursor();
	open_cursor();	    	
        fetch_cursor_check = fetch_cursor();        
	
	fprintf(f1,"\n");
	fprintf(f1,"HMC Healthcare Programme\n");
	fprintf(f1,"-----------------------------------------------------------------------");
	fprintf(f1,"\n");
	fprintf(f1,"Application No.		: %-10s\n"	,nd_appl_num.arr);
	fprintf(f1,"Patient Id / Name	: %-10s %-41s\n"													,nd_patient_id.arr,nd_patient_name.arr);
	fprintf(f1,"HMC Employee No.	: %-10s\n"		,nd_employee_no.arr);
	fprintf(f1,"Healthcare Scheme	: %-10s\n"		,nd_hcare_scheme.arr);
	/*
	if (nd_fmt_string == 3)
        {  
	fprintf(f1,"Amount		        : %-15.3f\n"	,nd_subscription_amt);
	}
	else
	{
	fprintf(f1,"Amount                      : %-15.2f\n"	,nd_subscription_amt);
	}
        */
        fprintf(f1,"Amount ( %-10s )	: ",nd_currency.arr);

        print_formated(nd_subscription_amt);
	fprintf(f1,"\n");

	fprintf(f1,"Payment Option 	        : %-25s\n"	,nd_payment_option.arr);
	fprintf(f1,"Customer		: %-40s\n"		,nd_customer_name.arr);
	fprintf(f1,"Healthcare Start Date	: %-15s\n"	,nd_hcare_start_date.arr);

	fprintf(f1,"Healthcare Expiry Date	: %-15s\n"												       		,nd_hcare_expiry_date.arr);       

	line = line + 9 ;

	if (strcmp(nd_remarks.arr,"~") != 0)
	{
	fprintf(f1,"Remarks			: %-65.65s\n"		,nd_remarks.arr);      
	line = line +1 ; 	
	}	 

     fetch_cursor_check = fetch_cursor();        
         
  while(fetch_cursor_check)  
	{

	if ( page_ct == 0 )
	{
	fprintf(f1,"\nDependants\n");
	fprintf(f1,"-----------------------------------------------------------------------\n");
	fprintf(f1,"Patient Id  Name                                    Health Card No. \n");
	fprintf(f1,"-----------------------------------------------------------------------\n");
    }
    
	page_ct = 1;
	 
	fprintf(f1,"%-12.12s",nd_patient_id.arr);
	fprintf(f1,"%-43.43s",nd_patient_name.arr);
	fprintf(f1,"%-20.20s",nd_hcard_num.arr);	    
	fprintf(f1,"\n");
 	line = line +1;
	line_check();
    fetch_cursor_check = fetch_cursor();	 	

	}	
	fprintf(f1,"\n-----------------------------------------------------------------------\n");

	close_cursor();
}
