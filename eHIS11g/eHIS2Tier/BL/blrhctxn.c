
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/blrhctxn.pc"
};


static unsigned int sqlctx = 1288467147;


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
            void  *sqhstv[18];
   unsigned int   sqhstl[18];
            int   sqhsts[18];
            void  *sqindv[18];
            int   sqinds[18];
   unsigned int   sqharm[18];
   unsigned int   *sqharc[18];
   unsigned short  sqadto[18];
   unsigned short  sqtdso[18];
} sqlstm = {12,18};

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
"  from sy_user where user_id=USER)) and a.cash_counter_code is  not null ) a\
nd trunc(a.doc_date)=to_date(:b0,'DD/MM/YYYY')) and ((((a.hcard_status_initial\
='P' or (a.hcard_status_initial='T' and a.hcard_expiry_date_final is  not null\
 )) and :b1='P') or ((a.hcard_status_initial='T' and a.hcard_expiry_date_final\
 is null ) and :b1='T')) or (a.hcard_status_initial is  not null  and :b1='A')\
)) and a.hcard_trx_type=decode(:b4,'A',a.hcard_trx_type,:b4)) and ((a.hcard_st\
atus_initial='T' and a.hcard_trx_type<>'P') or a.hcard_status_initial='P')) an\
d a.operating_facility_id between RPAD(NVL(DECODE(:b6,'~F1','',:b6),'!!'),2,'!\
') and RPAD(NVL(DECODE(:b8,'~F2','',:b8),'~~'),2,'~')) and a.cash_counter_code\
 between RPAD(NVL(DECODE(:b10,'~C1','',:b10),'!!'),2,'!') and RPAD(NVL(DECODE(\
:b12,'~C2','',:b12),'~~'),2,'~')) and a.shift_id between TO_NUMBER(DECODE(:b14\
,'~S1','0',:b14)) and TO_NUMBER(DECODE(:b16,'~S2','9',:b16))) order by e.acc_e\
ntity_name,d.short_desc,a.shift_id,a.doc_type_code,a.doc_number            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,136,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,230,0,4,178,0,0,13,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
103,0,0,3,116,0,2,220,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
134,0,0,4,65,0,4,231,0,0,1,0,0,1,0,2,9,0,0,
153,0,0,5,32,0,4,236,0,0,1,0,0,1,0,2,9,0,0,
172,0,0,6,75,0,4,241,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
195,0,0,7,0,0,30,253,0,0,0,0,0,1,0,
210,0,0,8,2033,0,9,456,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
297,0,0,8,0,0,13,500,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,3,0,0,
384,0,0,9,512,0,6,539,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
411,0,0,8,0,0,15,571,0,0,0,0,0,1,0,
};



/* Preprocessor Directives  */

#include <stdio.h>
#include <string.h>
#include <math.h>
//#include <sqlca.h>      
//include <sqlda.h>
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




#include <bl.h>
#include <winproc.h>

/* Macros */

#define NODATAFOUND sqlca.sqlcode==1403
#define OERROR (sqlca.sqlcode < 0) 
#define MAX_LINES 55

/* Declarations */

/* EXEC SQL BEGIN DECLARE SECTION; */ 
	

	/* VARCHAR uid_pwd 				[95],	        
	     	nd_sysdate              [31],
			nd_user_id  	        [31],	
			nd_hospital_name		[61],
			nd_report_date			[31],
			nd_from_facility_id		[4] ,		
			nd_to_facility_id		[4] ,		
			nd_facility_id		[4] ,
			nd_facility		[31],
			nd_from_cash_counter_id	[4] ,    
			nd_to_cash_counter_id	[4] ,
			nd_cash_counter_id	[4] ,
			nd_cash_counter		[31],
			nd_from_shift		[4] ,
			nd_to_shift		[4] ,	
			nd_shift		[4] ,		
			nd_from_trn_type	[4] ,
			nd_trn_type		[16],
			nd_from_hcard_status	[4] ,
			nd_hcard_status		[20],
			nd_session_id		[20],
			nd_pgm_date		[30],
			nd_p_facility_id	[4],
			nd_pgm_id		[20],
                  d_short_name_full       [61],
			nd_patient_id		[21],
			nd_patient_name		[61],
			nd_patient_nam1		[61],
			nd_nationality		[16],
			nd_doc_date		[31],
			nd_doc_type		[10] ,
			nd_hcard_num		[21],								
		
			nd_prev_cash_counter_id [4] ,		
			nd_prev_cash_counter 	[31] ,		
			nd_prev_facility_id     [4] ,
			nd_prev_facility	[31],
			nd_prev_shift		[4] ; */ 
struct { unsigned short len; unsigned char arr[95]; } uid_pwd;

struct { unsigned short len; unsigned char arr[31]; } nd_sysdate;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[61]; } nd_hospital_name;

struct { unsigned short len; unsigned char arr[31]; } nd_report_date;

struct { unsigned short len; unsigned char arr[4]; } nd_from_facility_id;

struct { unsigned short len; unsigned char arr[4]; } nd_to_facility_id;

struct { unsigned short len; unsigned char arr[4]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_facility;

struct { unsigned short len; unsigned char arr[4]; } nd_from_cash_counter_id;

struct { unsigned short len; unsigned char arr[4]; } nd_to_cash_counter_id;

struct { unsigned short len; unsigned char arr[4]; } nd_cash_counter_id;

struct { unsigned short len; unsigned char arr[31]; } nd_cash_counter;

struct { unsigned short len; unsigned char arr[4]; } nd_from_shift;

struct { unsigned short len; unsigned char arr[4]; } nd_to_shift;

struct { unsigned short len; unsigned char arr[4]; } nd_shift;

struct { unsigned short len; unsigned char arr[4]; } nd_from_trn_type;

struct { unsigned short len; unsigned char arr[16]; } nd_trn_type;

struct { unsigned short len; unsigned char arr[4]; } nd_from_hcard_status;

struct { unsigned short len; unsigned char arr[20]; } nd_hcard_status;

struct { unsigned short len; unsigned char arr[20]; } nd_session_id;

struct { unsigned short len; unsigned char arr[30]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[4]; } nd_p_facility_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[61]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[61]; } nd_patient_nam1;

struct { unsigned short len; unsigned char arr[16]; } nd_nationality;

struct { unsigned short len; unsigned char arr[31]; } nd_doc_date;

struct { unsigned short len; unsigned char arr[10]; } nd_doc_type;

struct { unsigned short len; unsigned char arr[21]; } nd_hcard_num;

struct { unsigned short len; unsigned char arr[4]; } nd_prev_cash_counter_id;

struct { unsigned short len; unsigned char arr[31]; } nd_prev_cash_counter;

struct { unsigned short len; unsigned char arr[4]; } nd_prev_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_prev_facility;

struct { unsigned short len; unsigned char arr[4]; } nd_prev_shift;

		
	
	char    nd_filename	        [100];

	long	nd_doc_no		    ,
		nd_fmt_string		    ,
		nd_prev_fmt_string	    ;		
	
	double	nd_doc_amt		=0  ,		
		nd_shift_amt		=0  ,
		nd_cash_counter_amt	=0  ,
		nd_facility_amt		=0  ,
		nd_gt_amt		=0  ;	
	int     doc_check = 0;

/* EXEC SQL END DECLARE SECTION; */ 


FILE *f1;
int page = 0;
int line = 0;
char prev_cash_counter_id[2];
char prev_facility_id    [2];

void proc_main(argc, argv)
int argc;
char *argv[];
{    
   void prt_line(int l, char spl_symbol[1]);
   void prt_hdr_initial();
   void prt_hdr();    
   void dec_cursor();
   void open_cursor();
   void close_cursor();
   void sub_hdr_prev_prt();
   int  fetch_cursor();
  
   void report_process();
   void line_check();
   void sub_hdr_prt();
   void rec_prt();
   void shift_rec_prt();
   void cash_rec_prt();
   void fc_rec_prt();

/* INPUT ARGUMENT CHECK */

  
 if(argc < 6) 
     {
       disp_message(ORA_MESG, "Usage BLRHCTXN uid/passwd@db Session Pgm-Date  Facility ");
       proc_exit();
     }

     strcpy(nd_pgm_id.arr, argv[0]);
     nd_pgm_id.len = strlen(nd_pgm_id.arr); 
     strcpy(g_pgm_id,nd_pgm_id.arr);

     strcpy(uid_pwd.arr, argv[1]);
     uid_pwd.len = strlen(uid_pwd.arr); 
    	
     strcpy(nd_session_id.arr, argv[2]);
     nd_session_id.len = strlen(nd_session_id.arr);      	 
     strcpy(g_session_id,nd_session_id.arr);

     strcpy(nd_pgm_date.arr, argv[3]);
     nd_pgm_date.len = strlen(nd_pgm_date.arr);      	 
     strcpy(g_pgm_date,nd_pgm_date.arr);

     strcpy(nd_p_facility_id.arr, argv[5]);
     nd_p_facility_id.len = strlen(nd_p_facility_id.arr);      	 
     strcpy(g_facility_id,nd_p_facility_id.arr);
   
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

		  nd_report_date.arr[0] = '\0';
		  nd_from_facility_id.arr[0] = '\0';
		  nd_to_facility_id.arr[0] = '\0';
		  nd_from_cash_counter_id.arr[0] = '\0';
		  nd_to_cash_counter_id.arr[0] = '\0';
		  nd_from_shift.arr[0] = '\0';
		  nd_to_shift.arr[0] = '\0';
		  nd_from_hcard_status.arr[0] = '\0';
		  nd_from_trn_type.arr[0] = '\0';

		  nd_report_date.len = 0;
		  nd_from_facility_id.len = 0;
		  nd_to_facility_id.len = 0;
		  nd_from_cash_counter_id.len = 0;
		  nd_to_cash_counter_id.len = 0;
		  nd_from_shift.len = 0;
		  nd_to_shift.len = 0;
		  nd_from_hcard_status.len = 0;
		  nd_from_trn_type.len = 0;

  /* EXEC SQL SELECT PARAM1,
		  PARAM2,
		  PARAM3,
		  PARAM4,
		  PARAM5,
                  PARAM6,
		  PARAM7,
		  PARAM8,
		  PARAM9
	  INTO    :nd_report_date,
		  :nd_from_facility_id,
		  :nd_to_facility_id,
		  :nd_from_cash_counter_id,
		  :nd_to_cash_counter_id,
		  :nd_from_shift,
		  :nd_to_shift,
		  :nd_from_hcard_status, 
		  :nd_from_trn_type
	  FROM    sy_prog_param
          WHERE   operating_facility_id = :nd_p_facility_id
	  AND 	  session_id = :nd_session_id
	  AND     pgm_date   = :nd_pgm_date
	  AND     pgm_id     = :nd_pgm_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PARA\
M7 ,PARAM8 ,PARAM9 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  from sy_prog_para\
m where (((operating_facility_id=:b9 and session_id=:b10) and pgm_date=:b11) a\
nd pgm_id=:b12)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_report_date;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_from_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )6;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )6;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_from_cash_counter_id;
  sqlstm.sqhstl[3] = (unsigned int  )6;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_cash_counter_id;
  sqlstm.sqhstl[4] = (unsigned int  )6;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_from_shift;
  sqlstm.sqhstl[5] = (unsigned int  )6;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_shift;
  sqlstm.sqhstl[6] = (unsigned int  )6;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_from_hcard_status;
  sqlstm.sqhstl[7] = (unsigned int  )6;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_from_trn_type;
  sqlstm.sqhstl[8] = (unsigned int  )6;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_p_facility_id;
  sqlstm.sqhstl[9] = (unsigned int  )6;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_session_id;
  sqlstm.sqhstl[10] = (unsigned int  )22;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_pgm_date;
  sqlstm.sqhstl[11] = (unsigned int  )32;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_pgm_id;
  sqlstm.sqhstl[12] = (unsigned int  )22;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

 
     nd_report_date.len = strlen(nd_report_date.arr);      	 	    
     nd_from_facility_id.len = strlen(nd_from_facility_id.arr);      	 
     nd_to_facility_id.len = strlen(nd_to_facility_id.arr);      	 
     nd_from_cash_counter_id.len = strlen(nd_from_cash_counter_id.arr);  
     nd_to_cash_counter_id.len = strlen(nd_to_cash_counter_id.arr);      
     nd_from_shift.len = strlen(nd_from_shift.arr);      	 
     nd_to_shift.len = strlen(nd_to_shift.arr);      	 
     nd_from_hcard_status.len = strlen(nd_from_hcard_status.arr);      	 
     nd_from_trn_type.len = strlen(nd_from_trn_type.arr);      	 

  /* EXEC SQL DELETE FROM sy_prog_param 
          WHERE   operating_facility_id = :nd_p_facility_id
	  AND 	  session_id = :nd_session_id
	  AND     pgm_date   = :nd_pgm_date
	  AND     pgm_id     = :nd_pgm_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from sy_prog_param  where (((operating_facility_id=\
:b0 and session_id=:b1) and pgm_date=:b2) and pgm_id=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )103;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_p_facility_id;
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
  sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
  sqlstm.sqhstl[2] = (unsigned int  )32;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_pgm_id;
  sqlstm.sqhstl[3] = (unsigned int  )22;
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


  nd_sysdate.arr[0]		= '\0';  
  nd_sysdate.len		= 0;
  /* EXEC SQL SELECT to_char(SYSDATE,'DD/MM/YYYY HH24:MI') INTO :nd_sysdate FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select to_char(SYSDATE,'DD/MM/YYYY HH24:MI') into :b0  from\
 dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )134;
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
  
  nd_user_id.arr[0]		= '\0';  
  nd_user_id.len		=0;
  /* EXEC SQL SELECT USER INTO :nd_user_id FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select USER into :b0  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )153;
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
       
  nd_hospital_name.arr[0] = '\0';
  nd_hospital_name.len = 0;
  /* EXEC SQL SELECT accounting_name INTO :nd_hospital_name FROM sy_acc_entity
           WHERE acc_entity_id = :nd_p_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select accounting_name into :b0  from sy_acc_entity where a\
cc_entity_id=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )172;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_p_facility_id;
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
   
  
   prt_hdr_initial();    
   report_process(); 
  
/* CLOSE FILE */
   /* EXEC SQL COMMIT RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 13;
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

 
   fclose(f1);   
   return;   
}

void line_check()
{
   if (line > MAX_LINES)
   {
	fprintf(f1,"\f");	
	prt_hdr();
	if (doc_check == 0)
	{ sub_hdr_prt();}
        else
	{ sub_hdr_prev_prt();}
   }
	doc_check = 1;
}       

void prt_hdr_initial()
{     
   line = 0;    
   page = page +1;
   fprintf(f1,"\n");       
   fprintf(f1,"MDL : BL");
   prt_line(40," "); 
   fprintf(f1,"%-31s",nd_hospital_name.arr);
   prt_line(30," "); 
   fprintf(f1,"%-20s",nd_sysdate.arr);           
   fprintf(f1,"\n"); 
   fprintf(f1,"OPR : %-31s",nd_user_id.arr); 
   prt_line(10," ");    
   fprintf(f1,"Health Card Receipts by Transaction Type");
   prt_line(25," "); 
   fprintf(f1,"Page :%5d",page);           
   fprintf(f1,"\n"); 
   fprintf(f1,"REP : BLRHCTXN"); 
   fprintf(f1,"					    (FOR THE DATE %-3s)",nd_report_date.arr);
   fprintf(f1,"\n"); 
   prt_line(132,"-");     
   fprintf(f1,"\n");    
   fprintf(f1,"VER : 4.1");
   fprintf(f1,"\n");    
   fprintf(f1,"\n");    
   fprintf(f1,"\n");    
   fprintf(f1,"		INPUT PARAMETERS:");
   fprintf(f1,"\n");    
   fprintf(f1,"		------------------------------");    
   fprintf(f1,"\n");    
   fprintf(f1,"\n");    
   fprintf(f1,"			DATE                 : %-30s",nd_report_date.arr);
   fprintf(f1,"\n");    	
   fprintf(f1,"\n");    

   if (strcmp(nd_from_facility_id.arr,"~F1") == 0)
   fprintf(f1,"			FACILITY ID     FROM : LOWEST\n"); 
   else
   fprintf(f1,"			FACILITY ID     FROM : %-3s\n",nd_from_facility_id.arr);
   if (strcmp(nd_to_facility_id.arr,"~F2") == 0)
   fprintf(f1,"			FACILITY ID       TO : HIGHEST\n\n"); 
   else
   fprintf(f1,"			FACILITY ID       TO : %-3s\n\n",nd_to_facility_id.arr);
   if (strcmp(nd_from_cash_counter_id.arr,"~C1") == 0)
   fprintf(f1,"			CASH COUNTER    FROM : LOWEST\n");
   else
   fprintf(f1,"			CASH COUNTER    FROM : %-3s\n",nd_from_cash_counter_id.arr);
   if (strcmp(nd_to_cash_counter_id.arr,"~C2") == 0)
   fprintf(f1,"			CASH COUNTER      TO : HIGHEST\n\n");
   else
   fprintf(f1,"			CASH COUNTER      TO : %-3s\n\n",nd_to_cash_counter_id.arr);
   if (strcmp(nd_from_shift.arr,"~S1") == 0)
   fprintf(f1,"			SHIFT NUMBER    FROM : LOWEST\n");
   else
   fprintf(f1,"			SHIFT NUMBER    FROM : %-2s\n",nd_from_shift.arr);
   if (strcmp(nd_to_shift.arr,"~S2") == 0)
   fprintf(f1,"			SHIFT NUMBER      TO : HIGHEST\n\n");
   else
   fprintf(f1,"			SHIFT NUMBER      TO : %-2s\n\n",nd_to_shift.arr);
 
   if (strcmp(nd_from_hcard_status.arr,"P") == 0)
   {fprintf(f1,"			HEALTH CARD STATUS   : PERMANENT");}
   if (strcmp(nd_from_hcard_status.arr,"T") == 0)
   {fprintf(f1,"			HEALTH CARD STATUS   : TEMPORARY");}
   if (strcmp(nd_from_hcard_status.arr,"A") == 0)
   {fprintf(f1,"			HEALTH CARD STATUS   : ALL");}
   fprintf(f1,"\n");    
   fprintf(f1,"\n");    
  
   if (strcmp(nd_from_trn_type.arr,"N") == 0)
   {   fprintf(f1,"			TRANSACTION TYPE     : NEW");}
   if (strcmp(nd_from_trn_type.arr,"R") == 0)
   {   fprintf(f1,"			TRANSACTION TYPE     : RENEW");}
   if (strcmp(nd_from_trn_type.arr,"P") == 0)
   {   fprintf(f1,"			TRANSACTION TYPE     : REPLACEMENT");}

   fprintf(f1,"\n");    

   line = MAX_LINES + 1; 
   
}   
	
void prt_hdr()
{     
   line = 0;    
   page = page + 1;   
   fprintf(f1,"\n");       
   fprintf(f1,"MDL : BL");
   prt_line(40," "); 
   fprintf(f1,"%-30s",nd_hospital_name.arr);
   prt_line(30," "); 
   fprintf(f1,"%-16s",nd_sysdate.arr);           
   fprintf(f1,"\n"); 
   fprintf(f1,"OPR : %-31s",nd_user_id.arr); 
   prt_line(10," ");    
   fprintf(f1,"Health Card Receipts by Transaction Type");
   prt_line(25," "); 
   fprintf(f1,"Page :%5d",page);           
   fprintf(f1,"\n"); 
   fprintf(f1,"REP : BLRHCTXN"); 
   prt_line(20," ");    
   fprintf(f1,"     		   ( FOR THE DATE %-11s )",nd_report_date.arr);
   prt_line(35," "); 
   fprintf(f1,"\n"); 
   prt_line(132,"-");     
   fprintf(f1,"\n");    
   fprintf(f1,"Receipt Doc     Date      Health Card           Patient ID           Name              Nationality       Amount Trans. Status");
   fprintf(f1, "\n");   
   fprintf(f1,"Type / Number		   Number                                                                                Type ");
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
{ /* EXEC SQL DECLARE hcard_cursor CURSOR FOR   
  SELECT	a.patient_id			patient_id	,
	substr(b.short_name,1,15)				patient_name	,
	substr(b.short_name,16,60)        patient_nam1,
      b.short_name,
	c.nationality				nationality	,
	TRUNC(a.doc_date)			doc_date	,
	a.doc_type_code				doc_type	,
	a.doc_number				doc_no		,
	a.hcard_num				hcard_num	,	
	a.doc_amt				doc_amt		,
	decode(a.hcard_trx_type,'N','New','R','Renew','P','Replc.')	trn_type	,
	decode(a.hcard_expiry_date_final,NULL,
	       decode(a.hcard_status_initial,'T','Temporary','P','Permanent'),'Permanent') hcard_status	,
	e.acc_entity_name			facility	,
	a.operating_facility_id		facility_id	,
	d.short_desc				cash_counter	,
	a.cash_counter_code			casd_counter_id ,
	a.shift_id					shift		,
	e.no_of_decimal				fmt_string		
FROM	bl_health_card_trn	a	,
	mp_patient_mast		b	,
	mp_country_his_vw		c	, 
	bl_cash_counter		d	,
	sy_acc_entity		e	
WHERE	a.patient_id	    =	b.patient_id
AND	b.nationality_code  =   c.country_code
AND	a.cash_counter_code =   d.cash_counter_code
AND	e.acc_entity_id	    =	a.operating_facility_id   
AND     a.operating_facility_id = d.operating_facility_id
AND     a.operating_facility_id IN (SELECT facility_id 
				FROM sy_user WHERE user_id = USER)
AND	a.cash_counter_code IS NOT NULL
AND	trunc(a.doc_date)	    =  to_date(:nd_report_date,'DD/MM/YYYY')
AND	(((a.hcard_status_initial='P' OR (a.hcard_status_initial='T'
	  				 AND a.hcard_expiry_date_final IS NOT NULL))
					 AND :nd_from_hcard_status='P')
	OR
	(a.hcard_status_initial	 ='T'	 AND a.hcard_expiry_date_final IS NULL
				 	 AND :nd_from_hcard_status='T')
	OR
	(a.hcard_status_initial	 IS 	 NOT NULL AND :nd_from_hcard_status = 'A'))
and  a.hcard_trx_type = (decode(:nd_from_trn_type,'A',a.hcard_trx_type, :nd_from_trn_type))
and  ((a.hcard_status_initial = 'T' and a.hcard_trx_type <> 'P' ) OR
      (a.hcard_status_initial = 'P' ))
AND    a.operating_facility_id BETWEEN 
	RPAD(NVL(DECODE(:nd_from_facility_id,'~F1','',:nd_from_facility_id),'!!') ,2,'!')
	AND 
	RPAD(NVL(DECODE(:nd_to_facility_id,'~F2','',:nd_to_facility_id),'~~'),2,'~')	
AND    a.cash_counter_code BETWEEN 
	RPAD(NVL(DECODE(:nd_from_cash_counter_id,'~C1','',:nd_from_cash_counter_id),'!!'),2,'!')
	AND 
	RPAD(NVL(DECODE(:nd_to_cash_counter_id,'~C2','',:nd_to_cash_counter_id),'~~'),2,'~')
AND    a.shift_id BETWEEN 
	TO_NUMBER(DECODE(:nd_from_shift,'~S1','0',:nd_from_shift))
	AND 
	TO_NUMBER(DECODE(:nd_to_shift,'~S2','9',:nd_to_shift))
ORDER BY e.acc_entity_name,	d.short_desc,a.shift_id,a.doc_type_code,a.doc_number; */ 

 return;
 }  

void open_cursor()
{ 
 /* EXEC SQL OPEN hcard_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.patient_id patient_id ,substr(b.short_name,1,15) patient_name ,\
substr(b.short_name,16,60) patient_nam1 ,b.short_name ,c.nationality nationa\
lity ,TRUNC(a.doc_date) doc_date ,a.doc_type_code doc_type ,a.doc_number doc\
_no ,a.hcard_num hcard_num ,a.doc_amt doc_amt ,decode(a.hcard_trx_type,'N','\
New','R','Renew','P','Replc.') trn_type ,decode(a.hcard_expiry_date_final,nu\
ll ,decode(a.hcard_status_initial,'T','Temporary','P','Permanent'),'Permanen\
t') hcard_status ,e.acc_entity_name facility ,a.operating_facility_id facili\
ty_id ,d.short_desc cash_counter ,a.cash_counter_code casd_counter_id ,a.shi\
ft_id shift ,e.no_of_decimal fmt_string  from bl_health_card_trn a ,mp_patie\
nt_mast b ,mp_country_his_vw c ,bl_cash_counter d ,sy_acc_entity e where (((\
((((((((((a.patient_id=b.patient_id and b.nationality_code=c.country_code) a\
nd a.cash_counter_code=d.cash_counter_code) and e.acc_entity_id=a.operating_\
facility_id) and a.operating_facility_id=d.operating_facility_id) and a.oper\
ating_facility_id in (select facility_id");
 sqlstm.stmt = sq0008;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )210;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_report_date;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_from_hcard_status;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_from_hcard_status;
 sqlstm.sqhstl[2] = (unsigned int  )6;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_from_hcard_status;
 sqlstm.sqhstl[3] = (unsigned int  )6;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_from_trn_type;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_from_trn_type;
 sqlstm.sqhstl[5] = (unsigned int  )6;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_from_facility_id;
 sqlstm.sqhstl[6] = (unsigned int  )6;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_from_facility_id;
 sqlstm.sqhstl[7] = (unsigned int  )6;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_to_facility_id;
 sqlstm.sqhstl[8] = (unsigned int  )6;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_to_facility_id;
 sqlstm.sqhstl[9] = (unsigned int  )6;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_from_cash_counter_id;
 sqlstm.sqhstl[10] = (unsigned int  )6;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_from_cash_counter_id;
 sqlstm.sqhstl[11] = (unsigned int  )6;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_to_cash_counter_id;
 sqlstm.sqhstl[12] = (unsigned int  )6;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_to_cash_counter_id;
 sqlstm.sqhstl[13] = (unsigned int  )6;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_from_shift;
 sqlstm.sqhstl[14] = (unsigned int  )6;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_from_shift;
 sqlstm.sqhstl[15] = (unsigned int  )6;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_to_shift;
 sqlstm.sqhstl[16] = (unsigned int  )6;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&nd_to_shift;
 sqlstm.sqhstl[17] = (unsigned int  )6;
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



 if (sqlca.sqlcode < 0) 
 {     disp_message (ORA_MESG, "Open HCard Cursor Failed");
       proc_exit();
 }
 
 return;
 }
int fetch_cursor()
{ 
		nd_patient_id.arr[0] ='\0';
		nd_patient_name.arr[0] ='\0';
		nd_patient_nam1.arr[0] ='\0';
		nd_nationality.arr[0] ='\0';
		nd_doc_date.arr[0] ='\0';
		nd_doc_type.arr[0] ='\0';
		nd_doc_no	= 0;
		nd_hcard_num.arr[0] ='\0';
		nd_doc_amt=0;
		nd_trn_type.arr[0] ='\0';	
		nd_hcard_status.arr[0] ='\0';
		nd_facility.arr[0] ='\0';
		nd_facility_id	.arr[0] ='\0';
		nd_cash_counter.arr[0] ='\0';
		nd_cash_counter_id.arr[0] ='\0';
		nd_shift.arr[0] ='\0';
		nd_fmt_string	= 0;

		nd_patient_id.len = 0;
		nd_patient_name.len = 0;
		nd_patient_nam1.len = 0;
		nd_nationality.len = 0;
		nd_doc_date.len = 0;
		nd_doc_type.len = 0;
		nd_hcard_num.len = 0;
		nd_trn_type.len = 0;
		nd_hcard_status.len = 0;
		nd_facility.len = 0;
		nd_facility_id.len = 0;
		nd_cash_counter.len = 0;
		nd_cash_counter_id.len = 0;
		nd_shift.len = 0;

  /* EXEC SQL FETCH hcard_cursor 
	   INTO :nd_patient_id		,
		:nd_patient_name	,
		:nd_patient_nam1	,
            :d_short_name_full ,
		:nd_nationality		,
		:nd_doc_date		,
		:nd_doc_type		,	
		:nd_doc_no		,
		:nd_hcard_num		,
		:nd_doc_amt		,
		:nd_trn_type		,
		:nd_hcard_status	,
		:nd_facility		,
		:nd_facility_id		,
		:nd_cash_counter	,	
		:nd_cash_counter_id	,
		:nd_shift		,
		:nd_fmt_string		; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )297;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
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
  sqlstm.sqhstv[2] = (         void  *)&nd_patient_nam1;
  sqlstm.sqhstl[2] = (unsigned int  )63;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_short_name_full;
  sqlstm.sqhstl[3] = (unsigned int  )63;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_nationality;
  sqlstm.sqhstl[4] = (unsigned int  )18;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_doc_date;
  sqlstm.sqhstl[5] = (unsigned int  )33;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_doc_type;
  sqlstm.sqhstl[6] = (unsigned int  )12;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_doc_no;
  sqlstm.sqhstl[7] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_hcard_num;
  sqlstm.sqhstl[8] = (unsigned int  )23;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_doc_amt;
  sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_trn_type;
  sqlstm.sqhstl[10] = (unsigned int  )18;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_hcard_status;
  sqlstm.sqhstl[11] = (unsigned int  )22;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_facility;
  sqlstm.sqhstl[12] = (unsigned int  )33;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[13] = (unsigned int  )6;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_cash_counter;
  sqlstm.sqhstl[14] = (unsigned int  )33;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_cash_counter_id;
  sqlstm.sqhstl[15] = (unsigned int  )6;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_shift;
  sqlstm.sqhstl[16] = (unsigned int  )6;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&nd_fmt_string;
  sqlstm.sqhstl[17] = (unsigned int  )sizeof(long);
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



    if (NODATAFOUND)
    return 0;    
  
    nd_patient_id.arr[nd_patient_id.len]		= '\0'; 
    nd_patient_name.arr[nd_patient_name.len]		= '\0'; 
	nd_patient_nam1.arr[nd_patient_nam1.len]		= '\0'; 
    nd_nationality.arr[nd_nationality.len]		= '\0'; 
    nd_doc_date.arr[nd_doc_date.len]			= '\0'; 
    nd_doc_type.arr[nd_doc_type.len]			= '\0';
    nd_hcard_num.arr[nd_hcard_num.len]			= '\0';
    nd_trn_type.arr[nd_trn_type.len]			= '\0';
    nd_hcard_status.arr[nd_hcard_status.len]		= '\0';   
    nd_facility.arr[nd_facility.len]			= '\0';
    nd_facility_id.arr[nd_facility_id.len]		= '\0';
    nd_cash_counter.arr[nd_cash_counter.len]	 	= '\0';
    nd_cash_counter_id.arr[nd_cash_counter_id.len] 	= '\0';
    nd_shift.arr[nd_shift.len]				= '\0';
    d_short_name_full.arr[d_short_name_full.len]               = '\0';
 
   /* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
    
   BEGIN
     blcommon.split_words(:d_short_name_full,15,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :nd_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,15,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :nd_patient_nam1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,15,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :nd_patient_nam1    := :nd_patient_nam1 || str2;
       end if;
     
 END;
  END;
       
   END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 )\
 ; BEGIN blcommon . split_words ( :d_short_name_full , 15 , '*' , 1 , str1 , s\
tr2 ) ; IF str2 IS NOT NULL THEN :nd_patient_name := str2 ; END IF ; blcommon \
. split_words ( :d_short_name_full , 15 , '*' , 2 , str1 , str2 ) ; IF str2 IS\
 NOT NULL THEN :nd_patient_nam1 := str2 ; END IF ; blcommon . split_words ( :d\
_short_name_full , 15 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :nd\
_patient_nam1 := :nd_patient_nam1 || str2 ; end if ; END ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )384;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_patient_nam1;
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


       nd_patient_name.arr[nd_patient_name.len]  = '\0';
       nd_patient_nam1.arr[nd_patient_nam1.len]  = '\0';

    return 1;
 }

void close_cursor()
{ 
 /* EXEC SQL CLOSE hcard_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )411;
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
	fprintf(f1,"Facility: %-60s" ,nd_facility.arr); 		
	fprintf(f1,"Cash Counter: %-15s",nd_cash_counter.arr); 	
	fprintf(f1,"  Shift: %-2s",nd_shift.arr); 
	fprintf(f1, "\n");   
	fprintf(f1, "\n");   
}

void sub_hdr_prev_prt()
{
	fprintf(f1,"Facility: %-60s" ,nd_prev_facility.arr); 		
	fprintf(f1,"Cash Counter: %-15s",nd_prev_cash_counter.arr); 	
	fprintf(f1,"  Shift: %-2s",nd_prev_shift.arr); 
	fprintf(f1, "\n");   
	fprintf(f1, "\n");   
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
        sprintf(str_amt,"%8s",s_amt);        
        fprintf(f1,"%8s",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);        
        format_amt(s_amt);	
        sprintf(str_amt,"%8s",s_amt);
        fprintf(f1,"%8s",str_amt);
        }
}

   
void rec_prt()
{
		fprintf(f1,"%-6s/%8d"	,nd_doc_type.arr,nd_doc_no);			
	        fprintf(f1," %-10s"  	,nd_doc_date.arr);
		fprintf(f1," %-20.20s" 	,nd_hcard_num.arr);
	        fprintf(f1," %-20.20s" 	,nd_patient_id.arr);
		fprintf(f1," %-15.15s" 	,nd_patient_name.arr);		
	        fprintf(f1," %-15s  "  	,nd_nationality.arr);
		print_formated(nd_doc_amt);
	        fprintf(f1," %-5.5s"  	,nd_trn_type.arr);
		fprintf(f1,"  %-10s" 	,nd_hcard_status.arr);
	        fprintf(f1, "\n");   	

     if(strlen(nd_patient_nam1.arr) > 2)
	{
	 fprintf(f1,"%68s %s \n"," ",nd_patient_nam1.arr);
	}
}  
   
void shift_rec_prt()
{
/*	if (nd_prev_fmt_string == 3)
        {
	fprintf(f1,"Shift Total	           %8.3f",nd_shift_amt);
	}
        else
	{fprintf(f1,"Shift Total	          %8.2f",nd_shift_amt);}
*/
	fprintf(f1,"Shift Total                  ");
	print_formated(nd_shift_amt);

}

void cash_rec_prt()
{/*
	if (nd_prev_fmt_string == 3)
        {
	fprintf(f1,"Cash Counter Total	   %8.3f",nd_cash_counter_amt);
	}
        else
	{fprintf(f1,"Cash Counter Total	  %8.2f",nd_cash_counter_amt);}*/
	fprintf(f1,"Cash Counter Total           ");
	print_formated(nd_cash_counter_amt);

}

void fc_rec_prt()
{
	/*if (nd_prev_fmt_string == 3)
        {
	fprintf(f1,"Facility Total	           %8.3f",nd_facility_amt);
	}
        else
	{fprintf(f1,"Facility Total	          %8.2f",nd_facility_amt);}*/

	fprintf(f1,"Facility Total               ");
	print_formated(nd_facility_amt);

}

void report_process()
{        
    int fetch_cursor_check;
	dec_cursor();
	open_cursor();	    	
        fetch_cursor_check = fetch_cursor();
	strcpy(nd_prev_facility_id.arr,nd_facility_id.arr); 
 	strcpy(nd_prev_facility.arr,nd_facility.arr); 	        
	
	nd_prev_facility_id.len = strlen(nd_prev_facility_id.arr);      	 
	nd_prev_facility.len = strlen(nd_prev_facility.arr);      	 

        strcpy(nd_prev_cash_counter_id.arr,nd_cash_counter_id.arr);		
        strcpy(nd_prev_cash_counter.arr,nd_cash_counter.arr);		

	nd_prev_cash_counter_id.len = strlen(nd_prev_cash_counter_id.arr);      
	nd_prev_cash_counter.len = strlen(nd_prev_cash_counter.arr);       
        strcpy(nd_prev_shift.arr,nd_shift.arr);               

	nd_prev_shift.len = strlen(nd_prev_shift.arr); 

    	nd_prev_fmt_string = nd_fmt_string;     	 
         doc_check = 0;
	line_check();
         
  while(fetch_cursor_check)    {  
     if (strcmp(nd_prev_facility_id.arr,nd_facility_id.arr) == 0)
     { if (strcmp(nd_prev_cash_counter_id.arr,nd_cash_counter_id.arr) == 0)
       {if (strcmp(nd_prev_shift.arr,nd_shift.arr) == 0)
	{	rec_prt();
	
		line = line + 1;	
		line_check();
	}
	else
	{	
	fprintf(f1,"\n");   	        
	line = line + 1;
	doc_check = 1;
	line_check();

	prt_line(73," ");
	shift_rec_prt();
  	fprintf(f1,"\n");   	        

	nd_shift_amt = 0;
         	
        fprintf(f1, "\n");   	 	         
	line = line + 1;	
	doc_check = 0;
	line_check();

	if (line < MAX_LINES-3)
        {
	if (line != 0 )
	{sub_hdr_prt();}
	}
	else
	{ line = MAX_LINES +1;
	  doc_check = 0;
	  line_check();
        }

      rec_prt();
	line = line + 1;	
	line_check();
	}
        }
   else
	{

	fprintf(f1,"\n");   	        
	line = line + 1;
        doc_check = 1;
	line_check();

	prt_line(73," ");
	shift_rec_prt();
  	fprintf(f1,"\n");   	        
	prt_line(73," ");

	cash_rec_prt();
  	fprintf(f1,"\n");   	        

	nd_shift_amt 		= 0;
	nd_cash_counter_amt	= 0;
         	
        fprintf(f1, "\n");   	 	         
	line = line + 1;	
	doc_check = 0;
	line_check();
         
	if (line < MAX_LINES-3)
        {
	if (line != 0 )
	{sub_hdr_prt();}
	}
	else
	{ line = MAX_LINES +1;
	  doc_check = 0;
	  line_check();
        }
	  rec_prt();
	line = line + 1;	
	line_check();
	}
	}
     else
     {
	fprintf(f1,"\n");   	        
	line = line + 1;
	doc_check = 1;
	line_check();
	prt_line(73," ");

	shift_rec_prt();
  	fprintf(f1,"\n");   	        
	prt_line(73," ");

	cash_rec_prt();
  	fprintf(f1,"\n");   	        
	prt_line(73," ");

	fc_rec_prt();
	fprintf(f1,"\n");   	        


	nd_shift_amt 		= 0;
	nd_cash_counter_amt	= 0;
	nd_facility_amt		= 0;
         	
        fprintf(f1, "\n");   	 	         
	line = line + 1;	
	doc_check = 0;
	line_check();

        line = MAX_LINES +1; 

	if (line < MAX_LINES-3)
        {
	if (line != 0 )
	{sub_hdr_prt();}
	}
	else
	{ line = MAX_LINES +1;
	  doc_check = 0;
	  line_check();
        }

	rec_prt();
	line = line + 1;	
	line_check();
        }
	
 	nd_facility_amt		= nd_facility_amt 	+ nd_doc_amt;
 	nd_cash_counter_amt	= nd_cash_counter_amt	+ nd_doc_amt;
	nd_shift_amt		= nd_shift_amt	 	+ nd_doc_amt;	
	nd_gt_amt		= nd_gt_amt		+ nd_doc_amt;

	strcpy(nd_prev_facility_id.arr,nd_facility_id.arr);  	
	strcpy(nd_prev_facility.arr,nd_facility.arr);  	
	nd_prev_facility_id.len = strlen(nd_prev_facility_id.arr);      	 
	nd_prev_facility.len = strlen(nd_prev_facility.arr);      	 
        strcpy(nd_prev_cash_counter_id.arr,nd_cash_counter_id.arr);		
        strcpy(nd_prev_cash_counter.arr,nd_cash_counter.arr);		
	nd_prev_cash_counter_id.len = strlen(nd_prev_cash_counter_id.arr);      	 
	nd_prev_cash_counter.len = strlen(nd_prev_cash_counter.arr);      	 
        strcpy(nd_prev_shift.arr,nd_shift.arr);        
	nd_prev_shift.len = strlen(nd_prev_shift.arr);      	 
	
	nd_prev_fmt_string = nd_fmt_string;     	 
	
        fetch_cursor_check = fetch_cursor();	 		
   } 	

	fprintf(f1, "\n");   	        
	line = line + 1;
	doc_check = 0;
	line_check();
	prt_line(73," ");
	shift_rec_prt();
  	fprintf(f1,"\n");   	        
	line = line + 1;
	doc_check = 0;
	line_check();
	prt_line(73," ");

	cash_rec_prt();
  	fprintf(f1,"\n");   	        
	line = line + 1;
	doc_check = 0;
	line_check();
	prt_line(73," ");

	fc_rec_prt();
	fprintf(f1,"\n");   	        
	line = line + 1;
	doc_check = 0;
	line_check();
	prt_line(73," ");
	/*
	if (nd_prev_fmt_string == 3)
        {
	fprintf(f1,"Grand Total 	           %8.3f",nd_gt_amt); }
        else
	{
	fprintf(f1,"Grand Total 	          %8.2f",nd_gt_amt); 	
	}*/
	
	fprintf(f1,"Grand Total                  ");
	print_formated(nd_gt_amt); 	


        fprintf(f1,"\n");   	     	        
  
 	 
	 fprintf(f1,"\n");
	 prt_line(58," "); 
	 fprintf(f1,"*** End Of Report ***");
         fprintf(f1, "\n");   	 
	 close_cursor();
}
