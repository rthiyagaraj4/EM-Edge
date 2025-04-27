
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLRGLDDE.pc"
};


static unsigned int sqlctx = 1288466691;


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
            void  *sqhstv[16];
   unsigned int   sqhstl[16];
            int   sqhsts[16];
            void  *sqindv[16];
            int   sqinds[16];
   unsigned int   sqharm[16];
   unsigned int   *sqharc[16];
   unsigned short  sqadto[16];
   unsigned short  sqtdso[16];
} sqlstm = {12,16};

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
",'',:b8),'~~'),2,'~')) group by a.operating_facility_id,d.acc_entity_name,a.\
cash_counter_code,e.short_desc,no_of_decimal,b.nationality_code,c.DFLT_NATIONA\
LITY_CODE,a.hcard_status_initial,a.hcard_expiry_date_final)  group by facility\
_id,facility_name,cash_counter_id,cash_counter_desc,fmt_string order by 1,4   \
         ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,159,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,191,0,4,193,0,0,10,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
91,0,0,3,116,0,2,225,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
122,0,0,4,65,0,4,238,0,0,1,0,0,1,0,2,9,0,0,
141,0,0,5,32,0,4,243,0,0,1,0,0,1,0,2,9,0,0,
160,0,0,6,75,0,4,248,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
183,0,0,7,0,0,30,260,0,0,0,0,0,1,0,
198,0,0,8,2367,0,9,483,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
253,0,0,8,0,0,13,514,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,
3,0,0,2,4,0,0,2,3,0,0,2,4,0,0,2,3,0,0,2,4,0,0,2,3,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
2,4,0,0,
332,0,0,8,0,0,15,545,0,0,0,0,0,1,0,
};



/* Preprocessor Directives  */

#include <stdio.h>
#include <string.h>
#include <math.h>
//#include <sqlca.h>  
//#include <sqlda.h>   
#include <bl.h>




/* Macros */

#define NODATAFOUND sqlca.sqlcode==1403
#define OERROR (sqlca.sqlcode < 0) 
#define MAX_LINES 55

/* Declarations */

/* EXEC SQL BEGIN DECLARE SECTION; */ 
	

	/* VARCHAR uid_pwd 	        [95],	        
	     	nd_sysdate              [31],
		nd_from_facility_id	[4],		
		nd_to_facility_id	[4],		
		nd_from_cash_counter_id	[4],
		nd_to_cash_counter_id	[4],
		nd_cash_counter_id	[3],
		nd_cash_counter_desc	[31],
		nd_from_doc_date	[31],
		nd_to_doc_date		[31],	
		nd_user_id  	        [31],	
		nd_hospital_name	[61],
		nd_facility_id		[3] ,		
		nd_facility_name	[60],				
		nd_session_id		[20],
		nd_pgm_date		[30],
		nd_p_facility_id	[4],
		nd_prev_facility_id     [3] ,
		nd_prev_facility_name	[31],	
		nd_pgm_id		[20]; */ 
struct { unsigned short len; unsigned char arr[95]; } uid_pwd;

struct { unsigned short len; unsigned char arr[31]; } nd_sysdate;

struct { unsigned short len; unsigned char arr[4]; } nd_from_facility_id;

struct { unsigned short len; unsigned char arr[4]; } nd_to_facility_id;

struct { unsigned short len; unsigned char arr[4]; } nd_from_cash_counter_id;

struct { unsigned short len; unsigned char arr[4]; } nd_to_cash_counter_id;

struct { unsigned short len; unsigned char arr[3]; } nd_cash_counter_id;

struct { unsigned short len; unsigned char arr[31]; } nd_cash_counter_desc;

struct { unsigned short len; unsigned char arr[31]; } nd_from_doc_date;

struct { unsigned short len; unsigned char arr[31]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[61]; } nd_hospital_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[60]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[20]; } nd_session_id;

struct { unsigned short len; unsigned char arr[30]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[4]; } nd_p_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_prev_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_prev_facility_name;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_id;


	
	char    nd_filename	        [100];

	long  	nd_fmt_string		    ,
		nd_prev_fmt_string	    ,
		nd_local_ct		    ,		
		nd_gcc_ct		    ,		
		nd_arabs_ct		    ,		
		nd_other_ct		    ;

        long	nd_fc_local_ct		    ,		
		nd_fc_gcc_ct		    ,		
		nd_fc_arabs_ct		    ,		
		nd_fc_other_ct		    ;	

	long   	nd_gt_local_ct		    ,	
		nd_gt_gcc_ct		    ,	
		nd_gt_arabs_ct		    ,	
		nd_gt_other_ct		    ;
	
	double	nd_daily_amt		    ,
		nd_doc_amount		    ,		
		nd_local_amt		    ,		
		nd_gcc_amt		    ,		
		nd_arabs_amt		    ,		
		nd_other_amt		    ,
		nd_temp_amt		    ,
		nd_perm_amt		    ;

	double	nd_fc_daily_amt		    ,
		nd_fc_doc_amount	    ,		
		nd_fc_local_amt		    ,		
		nd_fc_gcc_amt		    ,		
		nd_fc_arabs_amt		    ,		
		nd_fc_other_amt		    ,
		nd_fc_temp_amt		    ,
		nd_fc_perm_amt		    ;

	double	nd_gt_daily_amt		    ,
		nd_gt_doc_amount	    ,		
		nd_gt_local_amt		    ,
		nd_gt_gcc_amt		    ,
		nd_gt_arabs_amt		    ,
		nd_gt_other_amt		    ,
		nd_gt_temp_amt		    ,
		nd_gt_perm_amt		    ;	

	int	doc_check = 0;


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
int page = 0;
int line = 0;

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
   int  fetch_cursor();
   void sub_hdr_prev_prt();
  
   void report_process();
   void line_check();
   void init_cc_variables();
   void init_fc_variables();
   void init_gt_variables();
   void sub_hdr_prt();
   void rec_prt();
   void fc_rec_prt();
   void gt_rec_prt();

/* INPUT ARGUMENT CHECK */

       if(argc != 5) 
     {
	     disp_message(ORA_MESG, "Usage BLRGLDDE uid/passwd@db Session Pgm-Date Facility");
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

     strcpy(nd_p_facility_id.arr, argv[4]);
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

	  	  nd_from_facility_id.arr[0]	= '\0';
		  nd_to_facility_id.arr[0]	= '\0';
		  nd_from_cash_counter_id.arr[0]= '\0';
		  nd_to_cash_counter_id.arr[0]	= '\0';
		  nd_from_doc_date.arr[0]	= '\0';
		  nd_to_doc_date.arr[0]		= '\0';
  	  
		  nd_from_facility_id.len	= 0;
		  nd_to_facility_id.len 	= 0;
		  nd_from_cash_counter_id.len 	= 0;
		  nd_to_cash_counter_id.len 	= 0;
		  nd_from_doc_date.len 		= 0;
		  nd_to_doc_date.len 		= 0;

  /* EXEC SQL SELECT PARAM1,
		  PARAM2,
		  PARAM3,
		  PARAM4,
		  PARAM5,
                  PARAM6
	  INTO    :nd_from_facility_id,
		  :nd_to_facility_id,
		  :nd_from_cash_counter_id,
		  :nd_to_cash_counter_id,
		  :nd_from_doc_date,
		  :nd_to_doc_date 
	  FROM    sy_prog_param
          WHERE   operating_facility_id = :nd_p_facility_id
	  AND 	  session_id = :nd_session_id
	  AND     pgm_date   = :nd_pgm_date
	  AND     pgm_id     = :nd_pgm_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 into \
:b0,:b1,:b2,:b3,:b4,:b5  from sy_prog_param where (((operating_facility_id=:b6\
 and session_id=:b7) and pgm_date=:b8) and pgm_id=:b9)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_from_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )6;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_to_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )6;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_from_cash_counter_id;
  sqlstm.sqhstl[2] = (unsigned int  )6;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_to_cash_counter_id;
  sqlstm.sqhstl[3] = (unsigned int  )6;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_from_doc_date;
  sqlstm.sqhstl[4] = (unsigned int  )33;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_date;
  sqlstm.sqhstl[5] = (unsigned int  )33;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_p_facility_id;
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
  sqlstm.sqhstv[8] = (         void  *)&nd_pgm_date;
  sqlstm.sqhstl[8] = (unsigned int  )32;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_pgm_id;
  sqlstm.sqhstl[9] = (unsigned int  )22;
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



   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");
    
     	 
     nd_from_facility_id.len = strlen(nd_from_facility_id.arr);      	 
     nd_to_facility_id.len = strlen(nd_to_facility_id.arr);      	 
     nd_from_cash_counter_id.len = strlen(nd_from_cash_counter_id.arr);      	 
     nd_to_cash_counter_id.len = strlen(nd_to_cash_counter_id.arr);      	 
     nd_from_doc_date.len = strlen(nd_from_doc_date.arr);      	 
     nd_to_doc_date.len = strlen(nd_to_doc_date.arr);      	    	

  /* EXEC SQL DELETE FROM sy_prog_param 
          WHERE   operating_facility_id = :nd_p_facility_id
	  AND 	  session_id = :nd_session_id
	  AND     pgm_date   = :nd_pgm_date
	  AND     pgm_id     = :nd_pgm_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from sy_prog_param  where (((operating_facility_id=\
:b0 and session_id=:b1) and pgm_date=:b2) and pgm_id=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )91;
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

	
  nd_sysdate.arr[0] = '\0';
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
  
  nd_user_id.arr[0] = '\0';
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
       
  nd_hospital_name.arr[0] = '\0';
  nd_hospital_name.len	  = 0;
  /* EXEC SQL SELECT accounting_name INTO :nd_hospital_name FROM sy_acc_entity
           WHERE acc_entity_id = :nd_p_facility_id; */ 

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
	prt_hdr();
	if (doc_check == 0)
		{sub_hdr_prt();}
	else
		{sub_hdr_prev_prt();}	
   }
   else
   {fprintf(f1,"\n");}
   doc_check=1;
}       


void prt_hdr_initial()
{     
   line = 0;    
   page = page +1;
   fprintf(f1,"\n");       
   fprintf(f1,"MDL : BL");
   prt_line(45," "); 
   fprintf(f1,"%-60s",nd_hospital_name.arr);
   prt_line(27," "); 
   fprintf(f1,"%-20s",nd_sysdate.arr);           
   fprintf(f1,"\n"); 
   fprintf(f1,"OPR : %-31s",nd_user_id.arr); 
   prt_line(10," ");    
   fprintf(f1,"Location wise Health Card Summary for a Period");               
   prt_line(20," "); 
   fprintf(f1,"Page :%4d",page);           
   fprintf(f1,"\n"); 
   fprintf(f1,"REP : BLRGLDDE"); 
   fprintf(f1,"\n"); 
   prt_line(132,"-");     
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

   fprintf(f1,"			TRANSACTION DATE FROM : %-30s",nd_from_doc_date.arr);
   fprintf(f1,"\n");    	
   fprintf(f1,"			                   TO : %-30s",nd_to_doc_date.arr);
   fprintf(f1,"\n");    
   fprintf(f1,"\n");    

   if (strcmp(nd_from_facility_id.arr,"~F1") == 0)
   {  fprintf(f1,"			FACILITY ID      FROM :  /"); }
   else
   {  fprintf(f1,"			FACILITY ID      FROM : %-3s",nd_from_facility_id.arr);}

   fprintf(f1,"\n");    

   if (strcmp(nd_to_facility_id.arr,"~F2") == 0)
   {  fprintf(f1,"				           TO :  /"); }
   else
   {  fprintf(f1,"				           TO : %-3s",nd_to_facility_id.arr);}

   fprintf(f1,"\n");    
   fprintf(f1,"\n");    


   if (strcmp(nd_from_cash_counter_id.arr,"~C1") == 0)
   {  fprintf(f1,"			CASH COUNTER     FROM :  / ");}
   else
   {  fprintf(f1,"			CASH COUNTER     FROM : %-3s",nd_from_cash_counter_id.arr);}
   fprintf(f1,"\n");    

   if (strcmp(nd_to_cash_counter_id.arr,"~C2") == 0)
   {   fprintf(f1,"			                   TO :  /");}
   else
   {fprintf(f1,"			                   TO : %-3s",nd_to_cash_counter_id.arr);}  
   fprintf(f1, "\n");   


   line = MAX_LINES + 1; 
   
}

	
void prt_hdr()
{     
   line = 0;    
   page = page +1;
   fprintf(f1,"\n");       
   fprintf(f1,"MDL : BL");
   prt_line(45," "); 
   fprintf(f1,"%-60s",nd_hospital_name.arr);
   prt_line(27," "); 
   fprintf(f1,"%-16s",nd_sysdate.arr);           
   fprintf(f1,"\n"); 
   fprintf(f1,"OPR : %-31s",nd_user_id.arr); 
   prt_line(10," ");    
   fprintf(f1,"Location wise Health Card Summary for a Period");
   prt_line(20," "); 
   fprintf(f1,"Page :%4d",page);           
   fprintf(f1,"\n"); 
   fprintf(f1,"REP : BLRGLDDE"); 
   prt_line(25," ");    
   fprintf(f1,"      ( FOR THE PERIOD FROM %-11s TO %-11s )",nd_from_doc_date.arr,nd_to_doc_date.arr);
   prt_line(35," "); 
   fprintf(f1,"\n"); 
   prt_line(132,"-");     
   fprintf(f1,"\n");    
   fprintf(f1,"               -----Locals------  -------GCC-------  ------Arabs------  -----Others------                ----------Total-----------");
   fprintf(f1, "\n");   
   fprintf(f1,"Cash Counter    No        Amount   No        Amount   No        Amount   No        Amount         Total     Temporary     Permanent");
	       
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

  /* EXEC SQL DECLARE hcard_cursor CURSOR FOR   
  SELECT 	Facility_id,
       		facility_name,	
	        cash_counter_id,
  		cash_counter_desc,    
		fmt_string	 ,
     	        SUM(nvl(local,0)) 		local_ct ,
       		SUM(nvl(local_amt,0)) 		local_amt,
       		SUM(nvl(gcc,0))			gcc_ct   ,
       		SUM(nvl(gcc_amt,0))		gcc_amt  ,
       		SUM(nvl(arabs,0))		arabs_ct ,
       		SUM(nvl(arabs_amt,0))		arabs_amt,
       		SUM(nvl(other,0)) 		other_ct ,       
       		SUM(nvl(other_amt,0)) 		other_amt,
       		SUM(nvl(local_amt,0))+
       		SUM(nvl(other_amt,0))		total_amt,	
       		SUM(nvl(temp_amt,0)) 		Temp_amt ,
       		SUM(nvl(perm1_amt,0)+
        	    nvl(perm2_amt,0)) 		Perm_amt       
  FROM	       
  (SELECT a.operating_facility_id facility_id,
       d.acc_entity_name    facility_name,
       e.short_desc	    cash_counter_desc, 
       a.cash_counter_code  cash_counter_id,       
       no_of_decimal        fmt_string,       
       DecodE(b.nationality_code,c.DFLT_NATIONALITY_CODE,Count(a.doc_number)) Local,
       DecodE(b.nationality_code,c.DFLT_NATIONALITY_CODE,sum(nvl(a.doc_amt,0))) Local_Amt,
       0	Gcc,
       0	Gcc_Amt,
       0	Arabs,
       0	Arabs_Amt,       
       DecodE(b.nationality_code,c.DFLT_NATIONALITY_CODE,0,Count(a.doc_number)) Other,
       DecodE(b.nationality_code,c.DFLT_NATIONALITY_CODE,0,sum(nvl(a.doc_amt,0))) Other_Amt,          
       Decode(a.hcard_expiry_date_final,NULL,Decode(a.hcard_status_initial,'P',sum(a.doc_amt))) 
       Perm1_amt,	
       Decode(a.hcard_expiry_date_final,NULL,0,SUM(nvl(a.doc_amt,0))) 
       Perm2_amt,	       
       Decode(a.hcard_expiry_date_final,NULL,Decode(a.hcard_status_initial,'T',sum(nvl(a.doc_amt,0)))) Temp_amt	
FROM   bl_health_Card_trn  a,
       mp_patient_mast         b,
       mp_param_his_vw		   c,
       sy_acc_entity	   d,
       bl_cash_counter     e
WHERE  a.patient_id  		=	b.patient_id
AND    b.nationality_code	=	c.DFLT_NATIONALITY_CODE(+)
AND    a.operating_facility_id  =       d.acc_entity_id
AND    a.operating_facility_id  =       e.operating_facility_id
AND    a.cash_counter_code      =       e.cash_counter_code
AND    a.cash_counter_code IS NOT NULL 
AND    a.operating_facility_id IN (SELECT facility_id 
				FROM sy_user 
				WHERE user_id = USER)
AND    to_char(a.doc_date,'DD/MM/YYYY')    BETWEEN :nd_from_doc_date AND :nd_to_doc_date  
AND    a.operating_facility_id BETWEEN 
	RPAD(NVL(DECODE(:nd_from_facility_id,'~F1','',:nd_from_facility_id),'!!') ,2,'!')
	AND 
	RPAD(NVL(DECODE(:nd_to_facility_id,'~F2','',:nd_to_facility_id),'~~'),2,'~')	
	
AND    a.cash_counter_code BETWEEN 
	RPAD(NVL(DECODE(:nd_from_cash_counter_id,'~C1','',:nd_from_cash_counter_id),'!!'),2,'!')
	AND 
	RPAD(NVL(DECODE(:nd_to_cash_counter_id,'~C2','',:nd_to_cash_counter_id),'~~'),2,'~')

GROUP BY a.operating_facility_id,
	 d.acc_entity_name,
	 a.cash_counter_code,
	 e.short_desc,
	 no_of_decimal,        
	 b.nationality_code,
         c.DFLT_NATIONALITY_CODE,
         a.hcard_status_initial,
         a.hcard_expiry_date_final
)
GROUP BY facility_id,
	 facility_name,
	 cash_counter_id,
	 cash_counter_desc,
 	 fmt_string
	
ORDER BY 1,4; */ 


 return;
 }

void open_cursor()
{ 
 /* EXEC SQL OPEN hcard_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select Facility_id ,facility_name ,cash_counter_id ,cash_counter_desc ,f\
mt_string ,sum(nvl(local,0)) local_ct ,sum(nvl(local_amt,0)) local_amt ,sum(\
nvl(gcc,0)) gcc_ct ,sum(nvl(gcc_amt,0)) gcc_amt ,sum(nvl(arabs,0)) arabs_ct \
,sum(nvl(arabs_amt,0)) arabs_amt ,sum(nvl(other,0)) other_ct ,sum(nvl(other_\
amt,0)) other_amt ,(sum(nvl(local_amt,0))+sum(nvl(other_amt,0))) total_amt ,\
sum(nvl(temp_amt,0)) Temp_amt ,sum((nvl(perm1_amt,0)+nvl(perm2_amt,0))) Perm\
_amt  from (select a.operating_facility_id facility_id ,d.acc_entity_name fa\
cility_name ,e.short_desc cash_counter_desc ,a.cash_counter_code cash_counte\
r_id ,no_of_decimal fmt_string ,DecodE(b.nationality_code,c.DFLT_NATIONALITY\
_CODE,count(a.doc_number)) Local ,DecodE(b.nationality_code,c.DFLT_NATIONALI\
TY_CODE,sum(nvl(a.doc_amt,0))) Local_Amt ,0 Gcc ,0 Gcc_Amt ,0 Arabs ,0 Arabs\
_Amt ,DecodE(b.nationality_code,c.DFLT_NATIONALITY_CODE,0,count(a.doc_number\
)) Other ,DecodE(b.nationality_code,c.DFLT_NATIONALITY_CODE,0,sum(nvl(a.doc_\
amt,0))) Other_Amt ,Decode(a.hcard_expir");
 sqlbuft((void **)0, 
   "y_date_final,null ,Decode(a.hcard_status_initial,'P',sum(a.doc_amt))) Pe\
rm1_amt ,Decode(a.hcard_expiry_date_final,null ,0,sum(nvl(a.doc_amt,0))) Per\
m2_amt ,Decode(a.hcard_expiry_date_final,null ,Decode(a.hcard_status_initial\
,'T',sum(nvl(a.doc_amt,0)))) Temp_amt  from bl_health_Card_trn a ,mp_patient\
_mast b ,mp_param_his_vw c ,sy_acc_entity d ,bl_cash_counter e where (((((((\
((a.patient_id=b.patient_id and b.nationality_code=c.DFLT_NATIONALITY_CODE(+\
)) and a.operating_facility_id=d.acc_entity_id) and a.operating_facility_id=\
e.operating_facility_id) and a.cash_counter_code=e.cash_counter_code) and a.\
cash_counter_code is  not null ) and a.operating_facility_id in (select faci\
lity_id  from sy_user where user_id=USER)) and to_char(a.doc_date,'DD/MM/YYY\
Y') between :b0 and :b1) and a.operating_facility_id between RPAD(NVL(DECODE\
(:b2,'~F1','',:b2),'!!'),2,'!') and RPAD(NVL(DECODE(:b4,'~F2','',:b4),'~~'),\
2,'~')) and a.cash_counter_code between RPAD(NVL(DECODE(:b6,'~C1','',:b6),'!\
!'),2,'!') and RPAD(NVL(DECODE(:b8,'~C2'");
 sqlstm.stmt = sq0008;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )198;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_from_doc_date;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_date;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_from_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )6;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_from_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )6;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_facility_id;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_to_facility_id;
 sqlstm.sqhstl[5] = (unsigned int  )6;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_from_cash_counter_id;
 sqlstm.sqhstl[6] = (unsigned int  )6;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_from_cash_counter_id;
 sqlstm.sqhstl[7] = (unsigned int  )6;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_to_cash_counter_id;
 sqlstm.sqhstl[8] = (unsigned int  )6;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_to_cash_counter_id;
 sqlstm.sqhstl[9] = (unsigned int  )6;
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


  if (OERROR)
        err_mesg("Open HCard Cursor Failed",0,"");

 
 return;
 }
int fetch_cursor()
{ 

		nd_facility_id.arr[0]		=	'\0';
		nd_facility_name.arr[0]		=	'\0';
		nd_cash_counter_id.arr[0]	=	'\0';
		nd_cash_counter_desc.arr[0]	=	'\0';
		nd_fmt_string			=	0;
		nd_local_ct			=	0;
		nd_local_amt 			=	0;
		nd_gcc_ct 			=	0;
		nd_gcc_amt			=	0;		
		nd_arabs_ct			=	0;	
		nd_arabs_amt			=	0;
		nd_other_ct			=	0;
		nd_other_amt			=	0;
		nd_daily_amt			=	0;
		nd_temp_amt			=	0;
		nd_perm_amt			=	0;
		nd_facility_id.len 		= 	0;
		nd_facility_name.len 		= 	0;
		nd_cash_counter_id.len 		= 	0;
		nd_cash_counter_desc.len 	= 	0;
  
  /* EXEC SQL FETCH hcard_cursor 
	   INTO :nd_facility_id		,
		:nd_facility_name	,
		:nd_cash_counter_id	,
		:nd_cash_counter_desc	,		
		:nd_fmt_string		,
		:nd_local_ct		,
		:nd_local_amt		,
		:nd_gcc_ct		,
		:nd_gcc_amt		,
		:nd_arabs_ct		,
		:nd_arabs_amt		,
		:nd_other_ct		,
		:nd_other_amt		,	
		:nd_daily_amt		,
		:nd_temp_amt		,
		:nd_perm_amt		; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )253;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_facility_name;
  sqlstm.sqhstl[1] = (unsigned int  )62;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_cash_counter_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_cash_counter_desc;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_fmt_string;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_local_ct;
  sqlstm.sqhstl[5] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_local_amt;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_gcc_ct;
  sqlstm.sqhstl[7] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_gcc_amt;
  sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_arabs_ct;
  sqlstm.sqhstl[9] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_arabs_amt;
  sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_other_ct;
  sqlstm.sqhstl[11] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_other_amt;
  sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_daily_amt;
  sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_temp_amt;
  sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_perm_amt;
  sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
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

    nd_facility_id.arr[nd_facility_id.len]		= '\0';
    nd_cash_counter_id.arr[nd_cash_counter_id.len] 	= '\0';
    nd_facility_name.arr[nd_facility_name.len]		= '\0';
    nd_cash_counter_desc.arr[nd_cash_counter_desc.len]  = '\0';

    return 1;
 }

void close_cursor()
{ 
 /* EXEC SQL CLOSE hcard_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )332;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 return;
 }

void init_fc_variables()
{	
	 nd_fc_local_ct 	= 0;
	 nd_fc_local_amt 	= 0;
	 nd_fc_gcc_ct	 	= 0;
	 nd_fc_gcc_amt	 	= 0;
 	 nd_fc_arabs_ct	 	= 0;
	 nd_fc_arabs_amt 	= 0;
	 nd_fc_other_ct 	= 0;
	 nd_fc_other_amt 	= 0;
	 nd_fc_daily_amt 	= 0;
	 nd_fc_temp_amt 	= 0;
	 nd_fc_perm_amt 	= 0;	  
}
void init_gt_variables()
{	
	 nd_gt_local_ct 	= 0;
	 nd_gt_local_amt 	= 0;
	 nd_gt_gcc_ct	 	= 0;
	 nd_gt_gcc_amt	 	= 0;
 	 nd_gt_arabs_ct	 	= 0;
	 nd_gt_arabs_amt 	= 0;
	 nd_gt_other_ct 	= 0;
	 nd_gt_other_amt 	= 0;
	 nd_gt_daily_amt 	= 0;
	 nd_gt_temp_amt 	= 0;
	 nd_gt_perm_amt 	= 0;	  
}

void sub_hdr_prt()

{	fprintf(f1,"Facility Id  : %-3s" ,nd_facility_id.arr); 		
        fprintf(f1," - ");
	fprintf(f1,"%-60s" ,nd_facility_name.arr); 		
       	fprintf(f1,"\n");
	fprintf(f1,"\n");	
}

void sub_hdr_prev_prt()

{	fprintf(f1,"Facility Id  : %-3s" ,nd_prev_facility_id.arr); 		
        fprintf(f1," - ");
	fprintf(f1,"%-60s" ,nd_prev_facility_name.arr); 		
       	fprintf(f1,"\n");
	fprintf(f1,"\n");	
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
        sprintf(str_amt,"%14s",s_amt);        
        fprintf(f1,"%14s",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);        
        format_amt(s_amt);	
        sprintf(str_amt,"%14s",s_amt);
        fprintf(f1,"%14s",str_amt);
        }
}


void rec_prt()
{
/*
    if  (nd_fmt_string == 3 ) 
     {
	fprintf(f1,"%-13.13s" 	,nd_cash_counter_desc.arr); 		
        fprintf(f1,"%5d"  	,nd_local_ct);
	fprintf(f1,"%14.3f" 	,nd_local_amt);
        fprintf(f1,"%5d"  	,nd_gcc_ct);
	fprintf(f1,"%14.3f" 	,nd_gcc_amt);
        fprintf(f1,"%5d"  	,nd_arabs_ct);
	fprintf(f1,"%14.3f" 	,nd_arabs_amt);
        fprintf(f1,"%5d"  	,nd_other_ct);
	fprintf(f1,"%14.3f" 	,nd_other_amt);
	fprintf(f1,"%14.3f"  	,nd_daily_amt);
        fprintf(f1,"%14.3f"  	,nd_temp_amt);
 	fprintf(f1,"%14.3f" 	,nd_perm_amt);	
       }
     else
       {
	fprintf(f1,"%-13.13s" 	,nd_cash_counter_desc.arr); 		
        fprintf(f1,"%5d"  	,nd_local_ct);
	fprintf(f1,"%14.2f" 	,nd_local_amt);
        fprintf(f1,"%5d"  	,nd_gcc_ct);
	fprintf(f1,"%14.2f" 	,nd_gcc_amt);
        fprintf(f1,"%5d"  	,nd_arabs_ct);
	fprintf(f1,"%14.2f" 	,nd_arabs_amt);
        fprintf(f1,"%5d"  	,nd_other_ct);
	fprintf(f1,"%14.2f" 	,nd_other_amt);
	fprintf(f1,"%14.2f"  	,nd_daily_amt);
        fprintf(f1,"%14.2f"  	,nd_temp_amt);
	fprintf(f1,"%14.2f" 	,nd_perm_amt);	
	}	 
*/

	fprintf(f1,"%-13.13s" 	,nd_cash_counter_desc.arr); 		

        fprintf(f1,"%5d"  	,nd_local_ct);
	print_formated(nd_local_amt);

        fprintf(f1,"%5d"  	,nd_gcc_ct);
	print_formated(nd_gcc_amt);

        fprintf(f1,"%5d"  	,nd_arabs_ct);	
	print_formated(nd_arabs_amt);

        fprintf(f1,"%5d"  	,nd_other_ct);
	print_formated(nd_other_amt);

	print_formated(nd_daily_amt);
	print_formated(nd_temp_amt);
       	print_formated(nd_perm_amt);

	line = line + 1;	
	line_check();
}	

void fc_rec_prt()
{
    fprintf(f1,"Fac.Total    ");
   /*
    if  (nd_prev_fmt_string == 3 ) 
     {
	 fprintf(f1,"%5d"  	,nd_fc_local_ct);
   	 fprintf(f1,"%14.3f" 	,nd_fc_local_amt);
         fprintf(f1,"%5d"  	,nd_fc_gcc_ct);
	 fprintf(f1,"%14.3f" 	,nd_fc_gcc_amt);
         fprintf(f1,"%5d"  	,nd_fc_arabs_ct);
	 fprintf(f1,"%14.3f" 	,nd_fc_arabs_amt);
         fprintf(f1,"%5d"  	,nd_fc_other_ct);
	 fprintf(f1,"%14.3f" 	,nd_fc_other_amt);	 
	 fprintf(f1,"%14.3f"  	,nd_fc_daily_amt);
         fprintf(f1,"%14.3f"  	,nd_fc_temp_amt);
	 fprintf(f1,"%14.3f" 	,nd_fc_perm_amt);		

      }

     else
     {
         fprintf(f1,"%5d"  	,nd_fc_local_ct);
   	 fprintf(f1,"%14.2f" 	,nd_fc_local_amt);
         fprintf(f1,"%5d"  	,nd_fc_gcc_ct);
	 fprintf(f1,"%14.2f" 	,nd_fc_gcc_amt);
         fprintf(f1,"%5d"  	,nd_fc_arabs_ct);
	 fprintf(f1,"%14.2f" 	,nd_fc_arabs_amt);
         fprintf(f1,"%5d"  	,nd_fc_other_ct);
	 fprintf(f1,"%14.2f" 	,nd_fc_other_amt);	 
	 fprintf(f1,"%14.2f"  	,nd_fc_daily_amt);
         fprintf(f1,"%14.2f"  	,nd_fc_temp_amt);	
	 fprintf(f1,"%14.2f" 	,nd_fc_perm_amt);	
       }
	*/

         fprintf(f1,"%5d"  	,nd_fc_local_ct);
	 print_formated(nd_fc_local_amt);

         fprintf(f1,"%5d"  	,nd_fc_gcc_ct);
	 print_formated(nd_fc_gcc_amt);

         fprintf(f1,"%5d"  	,nd_fc_arabs_ct);
	 print_formated(nd_fc_arabs_amt);

         fprintf(f1,"%5d"  	,nd_fc_other_ct);
	 print_formated(nd_fc_other_amt);

	 print_formated(nd_fc_daily_amt);	
	 print_formated(nd_fc_temp_amt);
	 print_formated(nd_fc_perm_amt);

	
	 line = line + 1;
	 line_check();
}

void gt_rec_prt()
{
 fprintf(f1,"Grand Total  ");

/*  if  (nd_prev_fmt_string == 3 ) 
    {
         fprintf(f1,"%5d"  	,nd_gt_local_ct);
   	 fprintf(f1,"%14.3f" 	,nd_gt_local_amt);
         fprintf(f1,"%5d"  	,nd_gt_gcc_ct);
	 fprintf(f1,"%14.3f" 	,nd_gt_gcc_amt);
         fprintf(f1,"%5d"  	,nd_gt_arabs_ct);
	 fprintf(f1,"%14.3f" 	,nd_gt_arabs_amt);
         fprintf(f1,"%5d"  	,nd_gt_other_ct);
	 fprintf(f1,"%14.3f" 	,nd_gt_other_amt);	 
	 fprintf(f1,"%14.3f"  	,nd_gt_daily_amt);
         fprintf(f1,"%14.3f"  	,nd_gt_temp_amt);
	 fprintf(f1,"%14.3f" 	,nd_gt_perm_amt);	
      }
      else
	{
         fprintf(f1,"%5d"  	,nd_gt_local_ct);
   	 fprintf(f1,"%14.2f" 	,nd_gt_local_amt);
         fprintf(f1,"%5d"  	,nd_gt_gcc_ct);
	 fprintf(f1,"%14.2f" 	,nd_gt_gcc_amt);
         fprintf(f1,"%5d"  	,nd_gt_arabs_ct);
	 fprintf(f1,"%14.2f" 	,nd_gt_arabs_amt);
         fprintf(f1,"%5d"  	,nd_gt_other_ct);
	 fprintf(f1,"%14.2f" 	,nd_gt_other_amt);	 
	 fprintf(f1,"%14.2f"  	,nd_gt_daily_amt);
         fprintf(f1,"%14.2f"  	,nd_gt_temp_amt);
	 fprintf(f1,"%14.2f" 	,nd_gt_perm_amt);	
	}
*/
         fprintf(f1,"%5d"  	,nd_gt_local_ct);
	 print_formated(nd_gt_local_amt);

         fprintf(f1,"%5d"  	,nd_gt_gcc_ct);
	 print_formated(nd_gt_gcc_amt);

         fprintf(f1,"%5d"  	,nd_gt_arabs_ct);
	 print_formated(nd_gt_arabs_amt);

         fprintf(f1,"%5d"  	,nd_gt_other_ct);	 
	 print_formated(nd_gt_other_amt);	 
	 
	 print_formated(nd_gt_daily_amt);
	 print_formated(nd_gt_temp_amt);
	 print_formated(nd_gt_perm_amt);

}

void report_process()
{        
    int fetch_cursor_check;
	dec_cursor();
	open_cursor();	    
	doc_check = 0;
        fetch_cursor_check = fetch_cursor();
        
        strcpy(nd_prev_facility_id.arr,nd_facility_id.arr);  	
	nd_prev_facility_id.len = strlen(nd_prev_facility_id.arr);

	nd_prev_fmt_string = nd_fmt_string;

	doc_check = 0;
	line_check();  

        init_fc_variables();
        init_gt_variables();
         
  while(fetch_cursor_check)  {  
     if (strcmp(nd_prev_facility_id.arr,nd_facility_id.arr) == 0)
       { rec_prt();}
  else
	{
	 if (line != 0)
	{ line = line +1;
	  doc_check=1;
	  line_check();}

	 fc_rec_prt();

 	 init_fc_variables();
	
	 doc_check = 0; 	 	
	 line = MAX_LINES + 1;
	 //line = line + 1;
	//line_check();
         

         if ( line > MAX_LINES-3 )
	 {  line = MAX_LINES + 1;
	    line_check();}	 	
	 else
	 {
	 if (line != 0 )
	 { line = line +1;
	   line_check();
	   sub_hdr_prt();}	 
	 }
	
         rec_prt();
	}
	
	nd_fc_local_ct	= nd_fc_local_ct + nd_local_ct;
	nd_fc_local_amt	= nd_fc_local_amt + nd_local_amt;
	nd_fc_gcc_ct	= nd_fc_gcc_ct + nd_gcc_ct;
	nd_fc_gcc_amt	= nd_fc_gcc_amt + nd_gcc_amt;
	nd_fc_arabs_ct	= nd_fc_arabs_ct + nd_arabs_ct;
	nd_fc_arabs_amt	= nd_fc_arabs_amt + nd_arabs_amt;
	nd_fc_other_ct	= nd_fc_other_ct + nd_other_ct;
	nd_fc_other_amt	= nd_fc_other_amt + nd_other_amt;
	nd_fc_daily_amt = nd_fc_local_amt + nd_fc_gcc_amt + nd_fc_arabs_amt + nd_fc_other_amt;
	nd_fc_temp_amt	= nd_fc_temp_amt + nd_temp_amt;
	nd_fc_perm_amt	= nd_fc_perm_amt + nd_perm_amt;	
	
	nd_gt_local_ct	= nd_gt_local_ct + nd_local_ct;
	nd_gt_local_amt	= nd_gt_local_amt + nd_local_amt;
	nd_gt_gcc_ct	= nd_gt_gcc_ct + nd_gcc_ct;
	nd_gt_gcc_amt	= nd_gt_gcc_amt + nd_gcc_amt;
	nd_gt_arabs_ct	= nd_gt_arabs_ct + nd_arabs_ct;
	nd_gt_arabs_amt	= nd_gt_arabs_amt + nd_arabs_amt;
	nd_gt_other_ct	= nd_gt_other_ct + nd_other_ct;
	nd_gt_other_amt	= nd_gt_other_amt + nd_other_amt;
	nd_gt_daily_amt = nd_gt_local_amt + nd_gt_gcc_amt + nd_gt_arabs_amt + nd_gt_other_amt;
	nd_gt_temp_amt	= nd_gt_temp_amt + nd_temp_amt;
	nd_gt_perm_amt	= nd_gt_perm_amt + nd_perm_amt;	

        strcpy(nd_prev_facility_id.arr,nd_facility_id.arr);  	
	nd_prev_facility_id.len = strlen(nd_prev_facility_id.arr);

	nd_prev_fmt_string = nd_fmt_string;

        fetch_cursor_check = fetch_cursor();	 	
	
   } 
         

	 if ( line > MAX_LINES-3 )
	 {  line = MAX_LINES + 1;
	    doc_check = 0;
	    line_check();}	 	
	 else
	 {
	 if (line != 0 )
	 { fprintf(f1,"\n");}	 
	 }	

 	 fc_rec_prt();
	
	 line = line + 1;
	 line_check();

	 gt_rec_prt();
	 fprintf(f1,"\n");	
 	 fprintf(f1,"\n");
	 prt_line(58," "); 
	 fprintf(f1,"*** End Of Report ***");
         fprintf(f1, "\n");   	 
	 close_cursor();
}
