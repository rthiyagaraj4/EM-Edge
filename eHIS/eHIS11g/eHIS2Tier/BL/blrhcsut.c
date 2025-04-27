
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/blrhcsut.pc"
};


static unsigned int sqlctx = 1288467115;


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
            void  *sqhstv[19];
   unsigned int   sqhstl[19];
            int   sqhsts[19];
            void  *sqindv[19];
            int   sqinds[19];
   unsigned int   sqharm[19];
   unsigned int   *sqharc[19];
   unsigned short  sqadto[19];
   unsigned short  sqtdso[19];
} sqlstm = {12,19};

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

 static const char *sq0008 = 
"lect acc_entity_code  from sy_acc_entity where acc_entity_id=a.operating_fac\
ility_id)) and d.patient_id=a.patient_id) and a.blng_grp_id=d.blng_grp_id) and\
 d.doc_type_code=e.doc_type_code) and d.doc_num=e.doc_num) and TRUNC(d.doc_dat\
e) between TRUNC(a.hcare_start_date) and TRUNC(a.hcare_expiry_date)) and d.ope\
rating_facility_id=e.operating_facility_id) and e.package_service_code=f.blng_\
serv_code) and g.cash_counter_code=d.cash_counter_code) and g.operating_facili\
ty_id=d.operating_facility_id) and h.acc_entity_id=d.operating_facility_id) an\
d a.blng_grp_id between NVL(:b1,'!!') and NVL(:b2,'~~')) and a.hcare_appl_num \
between NVL(:b3,'!!!!!!!!!!') and NVL(:b4,'~~~~~~~~~~')) order by customer_cod\
e,HCARE_APPL_NUM,a.patient_id,a.operating_facility_id,d.doc_date            ";

 static const char *sq0009 = 
"patient_id) and a.blng_grp_id=d.blng_grp_id) and d.doc_type_code=e.doc_type_\
code) and d.doc_num=e.doc_num) and TRUNC(d.doc_date) between TRUNC(a.hcare_sta\
rt_date) and TRUNC(a.hcare_expiry_date)) and d.operating_facility_id=e.operati\
ng_facility_id) and e.package_service_code=f.blng_serv_code) and g.cash_counte\
r_code=d.cash_counter_code) and g.operating_facility_id=d.operating_facility_i\
d) and h.acc_entity_id=d.operating_facility_id) and a.blng_grp_id between NVL(\
:b3,'!!') and NVL(:b4,'~~')) and a.hcare_appl_num between NVL(:b5,'!!!!!!!!!!'\
) and NVL(:b6,'~~~~~~~~~~')) order by emp_patient_id,hcare_appl_num,a.patient_\
id,a.operating_facility_id,d.doc_date            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,176,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,191,0,4,202,0,0,10,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
91,0,0,3,116,0,2,234,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
122,0,0,4,65,0,4,259,0,0,1,0,0,1,0,2,9,0,0,
141,0,0,5,32,0,4,264,0,0,1,0,0,1,0,2,9,0,0,
160,0,0,6,75,0,4,269,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
183,0,0,7,0,0,30,301,0,0,0,0,0,1,0,
198,0,0,8,1800,0,9,551,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
233,0,0,9,1695,0,9,562,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
276,0,0,8,0,0,13,613,0,0,19,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
367,0,0,10,508,0,6,653,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
394,0,0,9,0,0,13,726,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,4,0,0,2,4,0,0,2,4,0,0,
481,0,0,11,524,0,6,764,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
508,0,0,12,191,0,4,795,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
543,0,0,8,0,0,15,820,0,0,0,0,0,1,0,
558,0,0,9,0,0,15,826,0,0,0,0,0,1,0,
};


/* Preprocessor Directives  */

#include <stdio.h>
#include <string.h>
#include <bl.h> 
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
#include <winproc.h>

/* Macros */  

#define NODATAFOUND sqlca.sqlcode==1403
#define OERROR (sqlca.sqlcode < 0) 
#define MAX_LINES 55

/* Declarations */

/* EXEC SQL BEGIN DECLARE SECTION; */ 
	

	/* VARCHAR uid_pwd 	        [91],	        
	     	nd_sysdate              [31],		
		nd_facility_id		[4] ,			
		nd_user_id  	        [31],	
		nd_pgm_id		[31],
		nd_hospital_name	[61],				
		
		nd_session_id		[20],
		nd_pgm_date		[30],
		nd_appl_num		[11],
		
		nd_up_to_date		[31],
		nd_from_blng_grp	[3],    
		nd_to_blng_grp		[3],
		nd_from_appln		[11],
		nd_to_appln		[11],
		nd_option		[2],
		nd_hcare_expiry_date	[12]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[31]; } nd_sysdate;

struct { unsigned short len; unsigned char arr[4]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[31]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[61]; } nd_hospital_name;

struct { unsigned short len; unsigned char arr[20]; } nd_session_id;

struct { unsigned short len; unsigned char arr[30]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[11]; } nd_appl_num;

struct { unsigned short len; unsigned char arr[31]; } nd_up_to_date;

struct { unsigned short len; unsigned char arr[3]; } nd_from_blng_grp;

struct { unsigned short len; unsigned char arr[3]; } nd_to_blng_grp;

struct { unsigned short len; unsigned char arr[11]; } nd_from_appln;

struct { unsigned short len; unsigned char arr[11]; } nd_to_appln;

struct { unsigned short len; unsigned char arr[2]; } nd_option;

struct { unsigned short len; unsigned char arr[12]; } nd_hcare_expiry_date;
	

  
        /* VARCHAR d_customer_code	[9],		  
		d_customer_name	[16],			
		d_appln		[11],		
		d_patient_id	[21],				
		d_patient_name  [61],
		d_patient_nam1  [31],
		d_emp_patient_id[21],
		d_emp_patient_name[61],
		d_emp_patient_nam1[61],
            d_short_name_full  [61],
		d_facility	[16],
		d_hcare_scheme	[8],	
		d_ser_code	[11],
		d_ser_name	[16],	
		d_bill_type	[7],
		d_bill_num	[9],	
		d_bill_date	[11],
		d_cash_counter	[16]; */ 
struct { unsigned short len; unsigned char arr[9]; } d_customer_code;

struct { unsigned short len; unsigned char arr[16]; } d_customer_name;

struct { unsigned short len; unsigned char arr[11]; } d_appln;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[31]; } d_patient_nam1;

struct { unsigned short len; unsigned char arr[21]; } d_emp_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_emp_patient_name;

struct { unsigned short len; unsigned char arr[61]; } d_emp_patient_nam1;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[16]; } d_facility;

struct { unsigned short len; unsigned char arr[8]; } d_hcare_scheme;

struct { unsigned short len; unsigned char arr[11]; } d_ser_code;

struct { unsigned short len; unsigned char arr[16]; } d_ser_name;

struct { unsigned short len; unsigned char arr[7]; } d_bill_type;

struct { unsigned short len; unsigned char arr[9]; } d_bill_num;

struct { unsigned short len; unsigned char arr[11]; } d_bill_date;

struct { unsigned short len; unsigned char arr[16]; } d_cash_counter;


	/* VARCHAR d_prev_customer_code	[9],
		d_prev_customer_name	[16],
		d_prev_appln		[11],
		d_prev_patient_id	[21],				
		d_prev_patient_name  	[61],
		d_prev_emp_patient_id	[21],
		d_prev_emp_patient_name	[61],		
		d_prev_emp_patient_nam1	[31],		
		d_prev_hcare_scheme	[8]; */ 
struct { unsigned short len; unsigned char arr[9]; } d_prev_customer_code;

struct { unsigned short len; unsigned char arr[16]; } d_prev_customer_name;

struct { unsigned short len; unsigned char arr[11]; } d_prev_appln;

struct { unsigned short len; unsigned char arr[21]; } d_prev_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_prev_patient_name;

struct { unsigned short len; unsigned char arr[21]; } d_prev_emp_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_prev_emp_patient_name;

struct { unsigned short len; unsigned char arr[31]; } d_prev_emp_patient_nam1;

struct { unsigned short len; unsigned char arr[8]; } d_prev_hcare_scheme;
	
				
  
	double	d_subscription_amt,	
		d_prev_subscription_amt,
		d_gross_amt,
		d_disc_amt ,
		d_net_amt  ,
		d_total_amt = 0;	

	 int nd_status = 0,
	     nd_type   = 0,
	     nd_emp_count = 1;
	
	char    buf[10];
	
	char    nd_filename	        [100];


/* EXEC SQL END DECLARE SECTION; */ 


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
   void prev_cust_det();
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
   void tot_prt();
   void prev_sub_hdr_prt();
   void prev_sub_hdr_prt1();

   void line_check();
   void sub_hdr_prt(); 
   void rec_prt();
   void sub_hdr_prt1(); 
   void rec_prt1();

   


  /* INPUT ARGUMENT CHECK */  




     if (argc < 5)      {
	disp_message(ERR_MESG,"Usage BLRHCSUB uid/passwd@db Session Pgm_date Facility-ID");
	proc_exit();
     }


	
     strcpy(nd_pgm_id.arr, argv[0]);
     nd_pgm_id.len = strlen(nd_pgm_id.arr);   

     strcpy(g_pgm_id,argv[0]);

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



   nd_up_to_date.arr[0]		= '\0';
   nd_from_blng_grp.arr[0]	= '\0';
   nd_to_blng_grp.arr[0]	= '\0';
   nd_from_appln.arr[0]		= '\0';
   nd_to_appln.arr[0]		= '\0';
   nd_option.arr[0]		= '\0';

   nd_up_to_date.len		= 0;
   nd_from_blng_grp.len		= 0;
   nd_to_blng_grp.len		= 0;
   nd_from_appln.len		= 0;
   nd_to_appln.len		= 0;
   nd_option.len		= 0;


  /* EXEC SQL SELECT param1,
		  param2,
		  param3,
		  param4,
		  param5,
		  param6
	   INTO 
		 :nd_up_to_date,
		 :nd_from_blng_grp,
		 :nd_to_blng_grp,
		 :nd_from_appln,
		 :nd_to_appln,
		 :nd_option
	   FROM sy_prog_param
	   WHERE operating_facility_id = :nd_facility_id
	   AND   session_id = :nd_session_id
	   AND   pgm_id     = :nd_pgm_id
	   AND   pgm_date   = :nd_pgm_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select param1 ,param2 ,param3 ,param4 ,param5 ,param6 into \
:b0,:b1,:b2,:b3,:b4,:b5  from sy_prog_param where (((operating_facility_id=:b6\
 and session_id=:b7) and pgm_id=:b8) and pgm_date=:b9)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_up_to_date;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_from_blng_grp;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_blng_grp;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_from_appln;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_appln;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_option;
  sqlstm.sqhstl[5] = (unsigned int  )4;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[6] = (unsigned int  )6;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_session_id;
  sqlstm.sqhstl[7] = (unsigned int  )22;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_pgm_id;
  sqlstm.sqhstl[8] = (unsigned int  )33;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_pgm_date;
  sqlstm.sqhstl[9] = (unsigned int  )32;
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



   nd_up_to_date.arr[nd_up_to_date.len]		= '\0';
   nd_from_blng_grp.arr[nd_from_blng_grp.len]	= '\0';
   nd_to_blng_grp.arr[nd_to_blng_grp.len]	= '\0';
   nd_from_appln.arr[nd_from_appln.len]		= '\0';
   nd_to_appln.arr[nd_to_appln.len]		= '\0';
   nd_option.arr[nd_option.len]			= '\0';

   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   /* EXEC SQL DELETE FRoM sy_prog_param
	    WHERE operating_facility_id = :nd_facility_id
	    AND   session_id = :nd_session_id
	    AND   pgm_id     = :nd_pgm_id
	    AND   pgm_date   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from sy_prog_param  where (((operating_facility_id\
=:b0 and session_id=:b1) and pgm_id=:b2) and pgm_date=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )91;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_pgm_id;
   sqlstm.sqhstl[2] = (unsigned int  )33;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[3] = (unsigned int  )32;
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
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");


/* OUTPUT FILE */

	strcpy(nd_filename,WORKING_DIR);   
	strcat(nd_filename,argv[0]);
	strcat(nd_filename,".lis");
	if((f1 = fopen(nd_filename, "w")) == NULL) 
	{
		 disp_message (ERR_MESG, " Error opening output file ....");
		 proc_exit();
        } 
	

  nd_sysdate.arr[0]       = '\0';  
  nd_sysdate.len = 0;

  /* EXEC SQL SELECT to_char(SYSDATE,'DD/MM/YYYY HH24:MI') INTO :nd_sysdate FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select to_char(SYSDATE,'DD/MM/YYYY HH24:MI') into :b0  from\
 dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )122;
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

  nd_user_id.arr[0]       = '\0';  
  nd_user_id.len = 0;
  /* EXEC SQL SELECT USER INTO :nd_user_id FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select USER into :b0  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )141;
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

  nd_hospital_name.arr[0]	= '\0';       
  nd_hospital_name.len = 0;
  /* EXEC SQL SELECT accounting_name
	   INTO :nd_hospital_name 
	   FROM sy_acc_entity
	   WHERE acc_entity_id = :nd_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select accounting_name into :b0  from sy_acc_entity where a\
cc_entity_id=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )160;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )6;
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



  nd_hospital_name.arr[nd_hospital_name.len]	= '\0';  


/* PROCESS */   


  
   page_hdr();  
   nd_type = 2;
	
   if (strcmp(nd_option.arr,"C") == 0)
	   {    report_process() ;	}
   if (strcmp(nd_option.arr,"E") == 0)
	   {    report_process1();	}
   if (strcmp(nd_option.arr,"O") == 0)
	   {    report_process1();	}
   if (strcmp(nd_option.arr,"A") == 0)
	   { 	report_process2();	}   
   
   fprintf(f1,"\n");	 		
   prt_line(58," "); 
   fprintf(f1,"*** End Of Report ***");
   fprintf(f1, "\n");   	 
	
  
/* CLOSE FILE */

   /* EXEC SQL COMMIT RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )183;
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
   fprintf(f1,"MDL : BL");
   prt_line(42," "); 
   fprintf(f1,"%-31s",nd_hospital_name.arr);
   prt_line(30," "); 
   fprintf(f1,"%-20s",nd_sysdate.arr);           
   fprintf(f1,"\n"); 
   fprintf(f1,"OPR : %-31s",nd_user_id.arr); 
   prt_line(10," ");    
   fprintf(f1,"Healthcare Subscription Utilization Report");
   prt_line(30," "); 
   fprintf(f1,"Page :%-6d",page);           
   fprintf(f1,"\n"); 
   fprintf(f1,"REP : BLRHCSUT"); 
   prt_line(38," "); 
   fprintf(f1,"(UP TO DATE ON %-10.10s)",nd_sysdate.arr); 
   fprintf(f1,"\n"); 
   //prt_line(132,"-");   
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

   fprintf(f1,"		Up To Date				 : %-10.10s",nd_up_to_date.arr);
   fprintf(f1,"\n\n");
   fprintf(f1,"		Billing Group			From	 : %-2.2s",nd_from_blng_grp.arr);
   fprintf(f1,"\n");
   fprintf(f1,"						To	 : %-2.2s",nd_to_blng_grp.arr);
   fprintf(f1,"\n\n");
   fprintf(f1,"		Application No			From	 : %-10.10s",nd_from_appln.arr);
   fprintf(f1,"\n");
   fprintf(f1,"						To	 : %-10.10s",nd_to_appln.arr);
   fprintf(f1,"\n\n");   

   fprintf(f1,"		Selection(Employess / Customers / Others):  ");

   if (strcmp(nd_option.arr,"E") == 0)
   {   fprintf(f1,"Employees");}

   if (strcmp(nd_option.arr,"C") == 0)
   {   fprintf(f1,"Customers");} 
	
   if (strcmp(nd_option.arr,"O") == 0)
   {   fprintf(f1,"Others");} 

   if (strcmp(nd_option.arr,"A") == 0)
   {   fprintf(f1,"All");} 

   fprintf(f1,"\n");    

   line = MAX_LINES + 1; 

}

void prt_hdr_next()
{
   fprintf(f1,"-----------------------------------------------------------------------------------------------------------------------------------------------");
   fprintf(f1,"\n");    
   fprintf(f1,"Facility        Cash Counter    Bill Number     Bill Date  Service             "); 
   fprintf(f1,"       Gross Amount        Discount       Net Amount");
   fprintf(f1,"\n");    
   fprintf(f1,"-----------------------------------------------------------------------------------------------------------------------------------------------");   
   //prt_line(132,"-");  
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
  /* EXEC SQL DECLARE bill_cursor CURSOR FOR   
  		SELECT	a.customer_code					customer_code1,
				b.short_name 					customer_name,
				a.hcare_appl_num				appl_num,
				a.patient_id					patient_id,
				SUBSTR(h.acc_entity_name,1,15)	facility,
				SUBSTR(c.short_name,1,30)		patinet_name,
				SUBSTR(c.short_name,31,60)		patinet_nam1,
                        c.short_name,
				i.short_desc					hcare_scheme,	
				NVL(a.subscription_amt,0)		subscription_amt,
				e.package_service_code			ser_code,
				f.short_desc					ser_name,
				d.doc_type_code					bill_type,
				d.doc_num						bill_num,
				TRUNC(d.doc_date)				bill_date,
				g.short_desc					cash_counter,
				NVL(e.gross_amt,0)				gross_amt,
				NVL(e.serv_disc_amt,0)			disc_amt,
				NVL(e.net_amt,0)				net_amt		
		FROM	         bl_hcare_trn			a,
				ar_customer			b,
				mp_patient_mast			c,
				bl_bill_hdr				d,
				bl_bill_service_line	e,
				bl_blng_serv			f,
				bl_cash_counter			g,
				sy_acc_entity			h,
				bl_health_scheme		i 		
		WHERE	a.customer_code		=	b.cust_code
		AND		a.scheme_id			=	i.scheme_id
		AND		a.patient_id		=	c.patient_id
		AND		a.customer_code		IS 	NOT NULL 	
		AND		a.payment_option	=	'R'
		AND     TRUNC(a.hcare_expiry_date) >= TO_DATE(:nd_up_to_date,'dd/mm/yyyy')
		AND		a.hcare_status		=	'A'	
		AND		b.acc_entity_code IN ( SELECT acc_entity_code FROM sy_acc_entity
						       WHERE acc_entity_id=a.operating_facility_id)
		AND             d.patient_id = 	a.patient_id
		AND 		a.blng_grp_id = d.blng_grp_id
		AND		d.doc_type_code = e.doc_type_code
		AND		d.doc_num	= e.doc_num
		AND             TRUNC(d.doc_date) between TRUNC(a.hcare_start_date)
						  AND 
						  TRUNC(a.hcare_expiry_date)
		AND 		d.operating_facility_id	= e.operating_facility_id
		AND 		e.package_service_code	= f.blng_serv_code
		AND		g.cash_counter_code = d.cash_counter_code
		AND  		g.operating_facility_id = d.operating_facility_id
		AND		h.acc_entity_id	= d.operating_facility_id
		AND		a.blng_grp_id	between NVL(:nd_from_blng_grp,'!!')
						AND	NVL(:nd_to_blng_grp,'~~')
		AND		a.hcare_appl_num between NVL(:nd_from_appln,'!!!!!!!!!!')
						AND 	NVL(:nd_to_appln,'~~~~~~~~~~')
		ORDER BY 	customer_code,
				HCARE_APPL_NUM,
				a.patient_id,
				a.operating_facility_id,
				d.doc_date; */ 

	return;
 }

void dec_cursor1()
{ 

  /* EXEC SQL DECLARE bill_cursor1 CURSOR FOR   
  		SELECT		a.emp_patient_id			emp_patient_id,
				a.hcare_appl_num				appl_num,
				a.patient_id					patient_id,
				SUBSTR(h.acc_entity_name,1,15)	facility,
				SUBSTR(c.short_name,1,30)		patinet_name,
				SUBSTR(c.short_name,31,60)		patinet_nam1,
                        c.short_name,
				i.short_desc					hcare_scheme,	
				NVL(a.subscription_amt,0)		subscription_amt,
				e.package_service_code			ser_code,
				f.short_desc					ser_name,
				d.doc_type_code					bill_type,
				d.doc_num						bill_num,
				TRUNC(d.doc_date)				bill_date,
				g.short_desc					cash_counter,
				NVL(e.gross_amt,0)				gross_amt,
				NVL(e.serv_disc_amt,0)			disc_amt,
				NVL(e.net_amt,0)				net_amt
		
		FROM	bl_hcare_trn			a,				
				mp_patient_mast				c,
				bl_bill_hdr				d,
				bl_bill_service_line	e,
				bl_blng_serv			f,
				bl_cash_counter			g,
				sy_acc_entity			h,
				bl_health_scheme		i

		WHERE	a.patient_id		=	c.patient_id
		AND		a.scheme_id			=	i.scheme_id
		AND ((          :nd_option		='E'
				AND a.employee_id	IS 	NOT NULL 	
				AND a.payment_option	<>	'R')
		    OR
		     (          :nd_option		='O'
				AND a.employee_id	IS 	NULL 	
				AND a.customer_code	IS      NULL))		 
		AND     TRUNC(a.hcare_expiry_date) 	>=	TO_DATE(:nd_up_to_date,'dd/mm/yyyy')
		AND		a.hcare_status		=	'A'	
		AND             d.patient_id = 	a.patient_id
		AND 		a.blng_grp_id = d.blng_grp_id
		AND		d.doc_type_code = e.doc_type_code
		AND		d.doc_num	= e.doc_num
		AND             TRUNC(d.doc_date) between TRUNC(a.hcare_start_date)
						  AND 
						  TRUNC(a.hcare_expiry_date)
		AND 		d.operating_facility_id	= e.operating_facility_id
		AND 		e.package_service_code	= f.blng_serv_code
		AND		g.cash_counter_code = d.cash_counter_code
		AND  		g.operating_facility_id = d.operating_facility_id
		AND		h.acc_entity_id	= d.operating_facility_id
		AND		a.blng_grp_id	between NVL(:nd_from_blng_grp,'!!')
						AND	NVL(:nd_to_blng_grp,'~~')
		AND		a.hcare_appl_num between 										 		NVL(:nd_from_appln,'!!!!!!!!!!')
						AND 	
						NVL(:nd_to_appln,'~~~~~~~~~~')
		ORDER BY 	emp_patient_id,
				hcare_appl_num,
				a.patient_id,
				a.operating_facility_id,
				d.doc_date; */ 

		return;
 }



void open_cursor()
{ 
 /* EXEC SQL OPEN bill_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.customer_code customer_code1 ,b.short_name customer_name ,a.hca\
re_appl_num appl_num ,a.patient_id patient_id ,SUBSTR(h.acc_entity_name,1,15\
) facility ,SUBSTR(c.short_name,1,30) patinet_name ,SUBSTR(c.short_name,31,6\
0) patinet_nam1 ,c.short_name ,i.short_desc hcare_scheme ,NVL(a.subscription\
_amt,0) subscription_amt ,e.package_service_code ser_code ,f.short_desc ser_\
name ,d.doc_type_code bill_type ,d.doc_num bill_num ,TRUNC(d.doc_date) bill_\
date ,g.short_desc cash_counter ,NVL(e.gross_amt,0) gross_amt ,NVL(e.serv_di\
sc_amt,0) disc_amt ,NVL(e.net_amt,0) net_amt  from bl_hcare_trn a ,ar_custom\
er b ,mp_patient_mast c ,bl_bill_hdr d ,bl_bill_service_line e ,bl_blng_serv\
 f ,bl_cash_counter g ,sy_acc_entity h ,bl_health_scheme i where (((((((((((\
((((((((a.customer_code=b.cust_code and a.scheme_id=i.scheme_id) and a.patie\
nt_id=c.patient_id) and a.customer_code is  not null ) and a.payment_option=\
'R') and TRUNC(a.hcare_expiry_date)>=TO_DATE(:b0,'dd/mm/yyyy')) and a.hcare_\
status='A') and b.acc_entity_code in (se");
 sqlstm.stmt = sq0008;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )198;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_up_to_date;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_from_blng_grp;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_to_blng_grp;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_from_appln;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_appln;
 sqlstm.sqhstl[4] = (unsigned int  )13;
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


 if (sqlca.sqlcode < 0) 
	 {	disp_message (ERR_MESG, "Open bill Cursor Failed");
       		proc_exit();
	 } 

 	return;
 }

void open_cursor1()
{ 
 /* EXEC SQL OPEN bill_cursor1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.emp_patient_id emp_patient_id ,a.hcare_appl_num appl_num ,a.pat\
ient_id patient_id ,SUBSTR(h.acc_entity_name,1,15) facility ,SUBSTR(c.short_\
name,1,30) patinet_name ,SUBSTR(c.short_name,31,60) patinet_nam1 ,c.short_na\
me ,i.short_desc hcare_scheme ,NVL(a.subscription_amt,0) subscription_amt ,e\
.package_service_code ser_code ,f.short_desc ser_name ,d.doc_type_code bill_\
type ,d.doc_num bill_num ,TRUNC(d.doc_date) bill_date ,g.short_desc cash_cou\
nter ,NVL(e.gross_amt,0) gross_amt ,NVL(e.serv_disc_amt,0) disc_amt ,NVL(e.n\
et_amt,0) net_amt  from bl_hcare_trn a ,mp_patient_mast c ,bl_bill_hdr d ,bl\
_bill_service_line e ,bl_blng_serv f ,bl_cash_counter g ,sy_acc_entity h ,bl\
_health_scheme i where ((((((((((((((((a.patient_id=c.patient_id and a.schem\
e_id=i.scheme_id) and (((:b0='E' and a.employee_id is  not null ) and a.paym\
ent_option<>'R') or ((:b0='O' and a.employee_id is null ) and a.customer_cod\
e is null ))) and TRUNC(a.hcare_expiry_date)>=TO_DATE(:b2,'dd/mm/yyyy')) and\
 a.hcare_status='A') and d.patient_id=a.");
 sqlstm.stmt = sq0009;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )233;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_up_to_date;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_from_blng_grp;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_blng_grp;
 sqlstm.sqhstl[4] = (unsigned int  )5;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_from_appln;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_to_appln;
 sqlstm.sqhstl[6] = (unsigned int  )13;
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
	 {	disp_message (ERR_MESG, "Open bill Cursor Failed");
       		proc_exit();
	 } 

 	 return;
 }


int fetch_cursor()
{ 

	d_customer_code.arr[0]	=  '\0';
	d_customer_name.arr[0]  =  '\0';
 	d_appln.arr[0]		=  '\0';
	d_patient_id.arr[0]	=  '\0';
	d_facility.arr[0]	=  '\0';
	d_patient_name.arr[0]	=  '\0';
	d_patient_nam1.arr[0]	=  '\0';
	d_hcare_scheme.arr[0]	=  '\0';	
	d_ser_code.arr[0]	=  '\0';
	d_ser_name.arr[0]	=  '\0';
	d_bill_type.arr[0]	=  '\0';
	d_bill_num.arr[0]	=  '\0';
	d_bill_date.arr[0]	=  '\0';
	d_cash_counter.arr[0] =  '\0';

	d_customer_code.len = 0;
	d_customer_name.len = 0;
 	d_appln.len 	    = 0;
	d_patient_id.len    = 0;
	d_facility.len	    = 0;
	d_patient_name.len  = 0;
	d_patient_nam1.len  = 0;
	d_hcare_scheme.len  =0;
	d_ser_code.len = 0;
	d_ser_name.len = 0;
	d_bill_type.len = 0;
	d_bill_num.len = 0;
	d_bill_date.len = 0;
	d_cash_counter.len = 0;


	d_subscription_amt	= 0;
	d_gross_amt 		= 0;
	d_disc_amt  		= 0;
 	d_net_amt   		= 0;


  /* EXEC SQL FETCH bill_cursor INTO
		 :d_customer_code,
		 :d_customer_name,
		 :d_appln,
		 :d_patient_id,
		 :d_facility,
		 :d_patient_name,
		 :d_patient_nam1,
             :d_short_name_full,
		 :d_hcare_scheme,	
		 :d_subscription_amt,
		 :d_ser_code,
		 :d_ser_name,
		 :d_bill_type,
		 :d_bill_num,
		 :d_bill_date,
		 :d_cash_counter,
		 :d_gross_amt,
		 :d_disc_amt,
		 :d_net_amt; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 19;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )276;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_customer_code;
  sqlstm.sqhstl[0] = (unsigned int  )11;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_customer_name;
  sqlstm.sqhstl[1] = (unsigned int  )18;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_appln;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[3] = (unsigned int  )23;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_facility;
  sqlstm.sqhstl[4] = (unsigned int  )18;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_patient_name;
  sqlstm.sqhstl[5] = (unsigned int  )63;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_patient_nam1;
  sqlstm.sqhstl[6] = (unsigned int  )33;
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
  sqlstm.sqhstv[8] = (         void  *)&d_hcare_scheme;
  sqlstm.sqhstl[8] = (unsigned int  )10;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_subscription_amt;
  sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_ser_code;
  sqlstm.sqhstl[10] = (unsigned int  )13;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_ser_name;
  sqlstm.sqhstl[11] = (unsigned int  )18;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_bill_type;
  sqlstm.sqhstl[12] = (unsigned int  )9;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_bill_num;
  sqlstm.sqhstl[13] = (unsigned int  )11;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_bill_date;
  sqlstm.sqhstl[14] = (unsigned int  )13;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&d_cash_counter;
  sqlstm.sqhstl[15] = (unsigned int  )18;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_gross_amt;
  sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&d_disc_amt;
  sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&d_net_amt;
  sqlstm.sqhstl[18] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
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



	d_customer_code.arr[d_customer_code.len]	=  '\0';
	d_customer_name.arr[d_customer_name.len]        =  '\0';
 	d_appln.arr[d_appln.len]			=  '\0';
	d_patient_id.arr[d_patient_id.len]		=  '\0';
	d_facility.arr[d_facility.len]			=  '\0';
	d_patient_name.arr[d_patient_name.len]		=  '\0';
	d_patient_nam1.arr[d_patient_nam1.len]		=  '\0';
	d_hcare_scheme.arr[d_hcare_scheme.len]		=  '\0';	
	d_ser_code.arr[d_ser_code.len]			=  '\0';
	d_ser_name.arr[d_ser_name.len]			=  '\0';
	d_bill_type.arr[d_bill_type.len]		=  '\0';
	d_bill_num.arr[d_bill_num.len]		=  '\0';
	d_bill_date.arr[d_bill_date.len]		=  '\0';
	d_cash_counter.arr[d_cash_counter.len]		 =  '\0';
	d_short_name_full.arr[d_short_name_full.len]     =  '\0';	


    if (NODATAFOUND)
	return 0;
  /* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :d_patient_nam1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_patient_nam1    := :d_patient_nam1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 19;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) \
; BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , st\
r2 ) ; IF str2 IS NOT NULL THEN :d_patient_name := str2 ; END IF ; blcommon . \
split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS N\
OT NULL THEN :d_patient_nam1 := str2 ; END IF ; blcommon . split_words ( :d_sh\
ort_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :d_pat\
ient_nam1 := :d_patient_nam1 || str2 ; end if ; END ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )367;
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
  sqlstm.sqhstv[1] = (         void  *)&d_patient_name;
  sqlstm.sqhstl[1] = (unsigned int  )63;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_patient_nam1;
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


       d_patient_name.arr[d_patient_name.len]  = '\0';
       d_patient_nam1.arr[d_patient_nam1.len]  = '\0';

       	nd_status = 1;
        return 1;
 }

int fetch_cursor1()
{ 


	d_emp_patient_id.arr[0]	=  '\0';
 	d_appln.arr[0]		=  '\0';
	d_patient_id.arr[0]	=  '\0';
	d_facility.arr[0]	=  '\0';
	d_patient_name.arr[0]	=  '\0';
	d_patient_nam1.arr[0]	=  '\0';
	d_hcare_scheme.arr[0]	=  '\0';	
	d_ser_code.arr[0]	=  '\0';
	d_ser_name.arr[0]	=  '\0';
	d_bill_type.arr[0]	=  '\0';
	d_bill_num.arr[0]	=  '\0';
	d_bill_date.arr[0]	=  '\0';
	d_cash_counter.arr[0] =  '\0';

	d_emp_patient_id.len = 0;
 	d_appln.len 	    = 0;
	d_patient_id.len    = 0;
	d_facility.len	    = 0;
	d_patient_name.len  = 0;
	d_patient_nam1.len  = 0;
	d_hcare_scheme.len  =0;
	d_ser_code.len = 0;
	d_ser_name.len = 0;
	d_bill_type.len = 0;
	d_bill_num.len = 0;
	d_bill_date.len = 0;
	d_cash_counter.len = 0;


	d_subscription_amt	= 0;
	d_gross_amt 		= 0;
	d_disc_amt  		= 0;
 	d_net_amt   		= 0;


  /* EXEC SQL FETCH bill_cursor1 INTO
		 :d_emp_patient_id,
		 :d_appln,
		 :d_patient_id,
		 :d_facility,
		 :d_patient_name,
		 :d_patient_nam1,
             :d_short_name_full,
		 :d_hcare_scheme,	
		 :d_subscription_amt,
		 :d_ser_code,
		 :d_ser_name,
		 :d_bill_type,
		 :d_bill_num,
		 :d_bill_date,
		 :d_cash_counter,
		 :d_gross_amt,
		 :d_disc_amt,
		 :d_net_amt; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 19;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )394;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_emp_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_appln;
  sqlstm.sqhstl[1] = (unsigned int  )13;
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
  sqlstm.sqhstv[3] = (         void  *)&d_facility;
  sqlstm.sqhstl[3] = (unsigned int  )18;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_patient_name;
  sqlstm.sqhstl[4] = (unsigned int  )63;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_patient_nam1;
  sqlstm.sqhstl[5] = (unsigned int  )33;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_short_name_full;
  sqlstm.sqhstl[6] = (unsigned int  )63;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_hcare_scheme;
  sqlstm.sqhstl[7] = (unsigned int  )10;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_subscription_amt;
  sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_ser_code;
  sqlstm.sqhstl[9] = (unsigned int  )13;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_ser_name;
  sqlstm.sqhstl[10] = (unsigned int  )18;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_bill_type;
  sqlstm.sqhstl[11] = (unsigned int  )9;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_bill_num;
  sqlstm.sqhstl[12] = (unsigned int  )11;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_bill_date;
  sqlstm.sqhstl[13] = (unsigned int  )13;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_cash_counter;
  sqlstm.sqhstl[14] = (unsigned int  )18;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&d_gross_amt;
  sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_disc_amt;
  sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&d_net_amt;
  sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
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



	d_emp_patient_id.arr[d_emp_patient_id.len]	=  '\0';
 	d_appln.arr[d_appln.len]			=  '\0';
	d_patient_id.arr[d_patient_id.len]		=  '\0';
	d_facility.arr[d_facility.len]			=  '\0';
	d_patient_name.arr[d_patient_name.len]		=  '\0';
	d_patient_nam1.arr[d_patient_nam1.len]		=  '\0';
	d_hcare_scheme.arr[d_hcare_scheme.len]		=  '\0';	
	d_ser_code.arr[d_ser_code.len]			=  '\0';
	d_ser_name.arr[d_ser_name.len]			=  '\0';
	d_bill_type.arr[d_bill_type.len]		=  '\0';
	d_bill_num.arr[d_bill_num.len]			=  '\0';
	d_bill_date.arr[d_bill_date.len]		=  '\0';
	d_cash_counter.arr[d_cash_counter.len]		 =  '\0';
      d_short_name_full.arr[d_short_name_full.len]     =  '\0';
	d_emp_patient_name.arr[0]			=  '\0';		
	d_emp_patient_nam1.arr[0]			=  '\0';		
	d_emp_patient_name.len				= 0;
	d_emp_patient_nam1.len				= 0;
 /* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_emp_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :d_emp_patient_nam1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_emp_patient_nam1    := :d_emp_patient_nam1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ;\
 BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str\
2 ) ; IF str2 IS NOT NULL THEN :d_emp_patient_name := str2 ; END IF ; blcommon\
 . split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 I\
S NOT NULL THEN :d_emp_patient_nam1 := str2 ; END IF ; blcommon . split_words \
( :d_short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN\
 :d_emp_patient_nam1 := :d_emp_patient_nam1 || str2 ; end if ; END ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )481;
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
 sqlstm.sqhstv[1] = (         void  *)&d_emp_patient_name;
 sqlstm.sqhstl[1] = (unsigned int  )63;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_emp_patient_nam1;
 sqlstm.sqhstl[2] = (unsigned int  )63;
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


       d_emp_patient_name.arr[d_emp_patient_name.len]  = '\0';
       d_emp_patient_nam1.arr[d_emp_patient_nam1.len]  = '\0';


	/* EXEC SQL SELECT SUBSTR(short_name,1,30), decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,
                      short_name
	INTO :d_emp_patient_name,
		 :d_emp_patient_nam1,
            :d_short_name_full
		 FROM mp_patient_mast
		 WHERE patient_id = NVL(:d_emp_patient_id,:d_patient_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SUBSTR(short_name,1,30) ,decode(substr(short_name,31,\
60),null ,' ',substr(short_name,31,60)) shortname1 ,short_name into :b0,:b1,:b\
2  from mp_patient_mast where patient_id=NVL(:b3,:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )508;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_emp_patient_name;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_emp_patient_nam1;
 sqlstm.sqhstl[1] = (unsigned int  )63;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_short_name_full;
 sqlstm.sqhstl[2] = (unsigned int  )63;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_emp_patient_id;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[4] = (unsigned int  )23;
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


	
	d_emp_patient_name.arr[d_emp_patient_name.len]	=  '\0';		
	d_emp_patient_nam1.arr[d_emp_patient_nam1.len]	=  '\0';		
      d_short_name_full.arr[d_short_name_full.len]    =  '\0';


    if (NODATAFOUND)
	return 0;
 

	nd_status = 1;
        return 1;

 }


void close_cursor()
{ 
 /* EXEC SQL close bill_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )543;
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
 /* EXEC SQL CLOSE bill_cursor1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )558;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 return;
 }

print_formated(loc_amount)
double loc_amount;
{
    char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
        format_amt(s_amt);        
        sprintf(str_amt,"%15s",s_amt);
        fprintf(f1,"%-15sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);
        format_amt(s_amt);        
        sprintf(str_amt,"%15s",s_amt);
        fprintf(f1,"%-15s ",str_amt);
        }
}

void sub_hdr_prt()

{	
	fprintf(f1,"Application No: %-10.10s",d_appln.arr); 		
        fprintf(f1," ");
	fprintf(f1,"Patient: %-20.20s %-30.30s",d_patient_id.arr,d_patient_name.arr); 		
        fprintf(f1," ");
	fprintf(f1,"Scheme: %-8.8s",d_hcare_scheme.arr); 		
        fprintf(f1," ");
	fprintf(f1,"Amount: ");
	print_formated(d_subscription_amt);
   	fprintf(f1,"\n\n");
  
   if(strlen(d_patient_nam1.arr) > 2)
	{
	fprintf(f1,"%56s %s \n\n"," ",d_patient_nam1.arr);
	}
   else
   {fprintf(f1,"\n");}

	line = line +2;
	line_check();   
}

void sub_hdr_prt1()

{	if (strcmp(nd_option.arr,"E") == 0 )
	{
	if (nd_emp_count == 1 )
	{
	    nd_emp_count = 0;
	fprintf(f1,"Application No: %-10.10s",d_appln.arr); 		
        fprintf(f1," ");
	if (d_emp_patient_id.arr[0])
	{
	fprintf(f1,"Patient: %-20.20s %-30.30s",d_emp_patient_id.arr,d_emp_patient_name.arr); 		
	}
	else
	{fprintf(f1,"Patient: %-20.20s %-30.30s",d_patient_id.arr,d_patient_name.arr); 
	}		

        fprintf(f1," ");
	fprintf(f1,"Scheme: %-8.8s",d_hcare_scheme.arr); 		
        fprintf(f1," ");
	fprintf(f1,"Amount: ");
	print_formated(d_subscription_amt);
	fprintf(f1,"\n");

   if (d_emp_patient_id.arr[0])
   {
		if(strlen(d_emp_patient_nam1.arr) > 2)
		{
		fprintf(f1,"%40s %s \n\n"," ",d_emp_patient_nam1.arr);
		line++;
		}
		else  fprintf(f1,"\n");
	}
	else
	{
		if(strlen(d_patient_nam1.arr) > 2)
		{
		fprintf(f1,"%40s %s \n\n"," ",d_patient_nam1.arr);
		line++;
		}
		else  fprintf(f1,"\n");
    }

	line = line + 2 ;
	line_check();
	}
	fprintf(f1,"Patient       : %-20.20s %-30.30s", d_patient_id.arr,d_patient_name.arr);
   	fprintf(f1,"\n");
    if(strlen(d_patient_nam1.arr) > 2)
	{
	 fprintf(f1,"%36s %s \n\n"," ",d_patient_nam1.arr);
	 line++;
	}
	else fprintf(f1,"\n");



	line = line +2;
	line_check();   }


	if (strcmp(nd_option.arr,"O") == 0 )
	{		
	fprintf(f1,"Application No: %-10.10s",d_appln.arr); 		
        fprintf(f1," ");
	fprintf(f1,"Patient: %-20.20s %-30.30s",d_patient_id.arr,d_patient_name.arr); 		
        fprintf(f1," ");
	fprintf(f1,"Scheme: %-8.8s",d_hcare_scheme.arr); 		
        fprintf(f1," ");
	fprintf(f1,"Amount: ");
	print_formated(d_subscription_amt);	
	fprintf(f1,"\n");

	if(strlen(d_patient_nam1.arr) > 2)
	{
	fprintf(f1,"%31s %s \n\n"," ",d_patient_nam1.arr);
	}
	else fprintf(f1,"\n");


	line = line +2;
	line_check();   
	}
   }

	
void prev_sub_hdr_prt()

{	
	fprintf(f1,"Application No: %-10.10s",d_prev_appln.arr); 		
        fprintf(f1," ");
	fprintf(f1,"Patient: %-20.20s %-33.33s",d_prev_patient_id.arr,d_prev_patient_name.arr); 	
        fprintf(f1," ");
	fprintf(f1,"Scheme: %-8.8s",d_prev_hcare_scheme.arr); 		
        fprintf(f1," ");
	fprintf(f1,"Amount: ");
	print_formated(d_prev_subscription_amt);
	
   	fprintf(f1,"\n\n");
	line = line +2;
	line_check();   
}

void prev_sub_hdr_prt1()

{	if (strcmp(nd_option.arr,"E") == 0 )   
	{
	fprintf(f1,"Application No: %-10.10s",d_prev_appln.arr); 		
        fprintf(f1," ");
       	if (d_prev_emp_patient_id.arr[0])
	{
	fprintf(f1,"Patient: %-20.20s 			%-33.33s", 							d_prev_emp_patient_id.arr,d_prev_emp_patient_name.arr); 		
	}
	else
	{
	fprintf(f1,"Patient: %-20.20s 			%-33.33s", 							d_prev_patient_id.arr,d_prev_patient_name.arr); 		
	}
	
        fprintf(f1," ");
	fprintf(f1,"Scheme: %-8.8s",d_prev_hcare_scheme.arr); 		
        fprintf(f1," ");
	fprintf(f1,"Amount: ");
	print_formated(d_prev_subscription_amt);

	fprintf(f1,"\n\n");

	fprintf(f1,"Patient       : %-20.20s -41.41s", 								d_prev_patient_id.arr,d_prev_patient_name.arr);
	
		
   	fprintf(f1,"\n\n");
	line = line +4;
	line_check();   
	}
	else
	{
	fprintf(f1,"Application No: %-10.10s",d_prev_appln.arr); 		
        fprintf(f1," ");
	fprintf(f1,"Patient: %-20.20s 			%-33.33s", 						d_prev_patient_id.arr,d_prev_patient_name.arr); 	
        fprintf(f1," ");
	fprintf(f1,"Scheme: %-8.8s",d_prev_hcare_scheme.arr); 		
        fprintf(f1," ");
	fprintf(f1,"Amount: ");
	print_formated(d_prev_subscription_amt);	
		
   	fprintf(f1,"\n\n");
	line = line +2;
	line_check();   
	}
}



void rec_prt()
{
       
	fprintf(f1,"%-15.15s "	,	d_facility.arr);	
	fprintf(f1,"%-15.15s "	,	d_cash_counter.arr);		
        fprintf(f1,"%-6.6s/%-8.8s ",	d_bill_type.arr,d_bill_num.arr);
	fprintf(f1,"%-10.105s "	,	d_bill_date.arr);		
	fprintf(f1,"%-10.6s/%-15.15s ",	d_ser_code.arr,d_ser_name.arr);
	print_formated(d_gross_amt);
	fprintf(f1," ");
	print_formated(d_disc_amt);
	fprintf(f1," ");
	print_formated(d_net_amt);
	fprintf(f1," ");
        d_total_amt  = d_total_amt + d_net_amt;
        fprintf(f1,"\n");

	line = line + 1;	
	line_check();
}

void prev_cust_det()
{
        strcpy(d_prev_customer_code.arr,d_customer_code.arr);
	d_prev_customer_code.len = strlen(d_prev_customer_code.arr);					

	strcpy(d_prev_customer_name.arr,d_customer_name.arr);
	d_prev_customer_name.len = strlen(d_prev_customer_name.arr);					

	strcpy(d_prev_patient_id.arr,d_patient_id.arr);
	d_prev_patient_id.len = strlen(d_prev_patient_id.arr);

	strcpy(d_prev_patient_name.arr,d_patient_name.arr);
	d_prev_patient_name.len = strlen(d_prev_patient_name.arr);

	strcpy(d_prev_appln.arr,d_appln.arr);	
	d_prev_appln.len = strlen(d_prev_appln.arr);

	strcpy(d_prev_hcare_scheme.arr,d_hcare_scheme.arr);
	d_prev_hcare_scheme.len = strlen(d_prev_hcare_scheme.arr);

	d_prev_subscription_amt	= d_subscription_amt;
}


void prev_emp_det()
{
        
	strcpy(d_prev_emp_patient_id.arr,d_emp_patient_id.arr);
	d_prev_emp_patient_id.len = strlen(d_prev_emp_patient_id.arr);

	strcpy(d_prev_emp_patient_name.arr,d_emp_patient_name.arr);
	d_prev_emp_patient_name.len = strlen(d_prev_emp_patient_name.arr);

	strcpy(d_prev_patient_id.arr,d_patient_id.arr);
	d_prev_patient_id.len = strlen(d_prev_patient_id.arr);

	strcpy(d_prev_patient_name.arr,d_patient_name.arr);
	d_prev_patient_name.len = strlen(d_prev_patient_name.arr);

	strcpy(d_prev_appln.arr,d_appln.arr);	
	d_prev_appln.len = strlen(d_prev_appln.arr);

	strcpy(d_prev_hcare_scheme.arr,d_hcare_scheme.arr);
	d_prev_hcare_scheme.len = strlen(d_prev_hcare_scheme.arr);

	d_prev_subscription_amt	= d_subscription_amt;
}

void tot_prt()
   {
	fprintf(f1,"\n");
	prt_line(107," ");
	fprintf(f1,"Total :  ");
	print_formated(d_total_amt);	
	d_total_amt = 0;
	fprintf(f1,"\n");
	fprintf(f1,"\n");
	line = line +2;
	line_check();
    }


void report_process()
{        
    int fetch_cursor_check;	
	nd_status = 0;
	dec_cursor();
	open_cursor();	    
	line_check();  
        fetch_cursor_check = fetch_cursor();			
	prev_cust_det();

	line_check();          	

  while(fetch_cursor_check)  {  	
     if (strcmp(d_prev_customer_code.arr,d_customer_code.arr) == 0)        {	 
	
	if (strcmp(d_prev_appln.arr,d_appln.arr) == 0)
	{	
	 if (line == 0 || nd_type == 1)		
	  { fprintf(f1,"Customer     : %-8.8s %-15.15s",d_customer_code.arr,d_customer_name.arr); 
	    fprintf(f1,"\n\n");
	    line = line +2;
	    sub_hdr_prt();
	   }
	    rec_prt();
	}
	else
	{  if (line == 0 )
	  	{ fprintf(f1,"Customer     : %-8.8s 15.15s", 								d_customer_code.arr,d_customer_name.arr); 
		   fprintf(f1,"\n\n");
		    line = line +2;
		  prev_sub_hdr_prt();} 
	    	  tot_prt();
          if (line > (MAX_LINES-6))
          	{ line = MAX_LINES +1;
	    	  line_check();	
		}	
	       	  sub_hdr_prt();
		  rec_prt();
       }
	}        
			
     else
       { 
	
          if (line == 0 )
	  	{ fprintf(f1,"Customer: %-8.8s %-15.15s", 									d_prev_customer_code.arr,d_prev_customer_name.arr); 
		     fprintf(f1,"\n\n");
		  line = line +2;
		  prev_sub_hdr_prt();} 
	    	  tot_prt();		
          if (line > (MAX_LINES-6))
          	{ line = MAX_LINES +1;
	    	  line_check();	
		}	
	       	  sub_hdr_prt();
		  rec_prt();
       }        
        prev_cust_det();
	nd_type = nd_type + 1;
        fetch_cursor_check = fetch_cursor();	             
     }
	if (nd_status == 1)
	{tot_prt();}	

	close_cursor();
  }


void report_process1()
{ 
 int fetch_cursor_check;	
	nd_status = 0;

	dec_cursor1();

	open_cursor1();	

	line_check();  

        fetch_cursor_check = fetch_cursor1();			

	prev_emp_det();

	line_check();          	

  while(fetch_cursor_check)  {  	
	
	if (strcmp(d_prev_appln.arr,d_appln.arr) == 0)
	{	
	 if (line == 0 || nd_type == 1) 		
	  { if (strcmp(nd_option.arr,"E") == 0 )
		{fprintf(f1,"Employees");}
	    else
		{fprintf(f1,"Others");}		
	    fprintf(f1,"\n\n");
	    line = line +2;
	    sub_hdr_prt1();
	   }
	    rec_prt();
	}
	else
	{  	nd_emp_count = 1;
		if (line == 0 )
	  { if (strcmp(nd_option.arr,"E") == 0 )
		{fprintf(f1,"Employees");}
	    else
		{fprintf(f1,"Others");}		

	    fprintf(f1,"\n\n");
	    line = line +2;
	    prev_sub_hdr_prt1();
	   }
	    tot_prt();
          if (line > (MAX_LINES-6))
          	{ line = MAX_LINES +1;
	    	  line_check();	
		}	
	       	  sub_hdr_prt1();
		  rec_prt();
       }	
			
        prev_emp_det();
	nd_type = nd_type + 1;
        fetch_cursor_check = fetch_cursor1();	             
     }
	if (nd_status == 1)
	{tot_prt();}	
	close_cursor1();	
	return;
  }


void report_process2()
{        
   nd_status = 0;
   nd_type = 1;
   strcpy(nd_option.arr,"E");   
   report_process1();

   nd_status = 0;
   nd_type = 1;
   strcpy(nd_option.arr,"C");   
   report_process();

   nd_status = 0;
   nd_type = 1;
   strcpy(nd_option.arr,"O"); 
   report_process1();

   return;
  }
