
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/blrhccur.pc"
};


static unsigned int sqlctx = 1288466587;


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
"select a.patient_id patient_id ,d.episode_id adm_no ,a.hcard_num hcard_num ,\
To_CHAR(a.hcard_expiry_date,'DD/MM/YYYY') expiry_date ,ROUND((a.hcard_expiry_d\
ate-SYSDATE)) eos_days ,b.short_desc blng_group ,substr(c.short_name,1,30) Pat\
_name ,substr(c.short_name,31,60) Pat_name1 ,c.short_name ,g.nationality natio\
nality ,to_char(d.admission_date_time,'dd/mm/yyyy hh24:mi') adm_date ,f.short_\
desc ward ,d.cur_bed_num bed  from bl_patient_fin_dtls a ,bl_blng_grp b ,mp_pa\
tient_mast c ,ip_episode d ,ip_ward f ,mp_country_his_vw g where (((((((((((a.\
hcard_num is  not null  and d.facility_id=:b0) and f.facility_id=d.facility_id\
) and g.country_code=c.nationality_code) and a.hcard_expiry_date>TRUNC(SYSDATE\
)) and b.blng_grp_id=a.blng_grp_id) and c.patient_id=a.patient_id) and nvl(c.S\
TATUS,'~')<>'S') and d.patient_id=a.patient_id) and d.episode_status='0') and \
f.ward_code=d.cur_ward_code) and ROUND((a.hcard_expiry_date-SYSDATE))<=:b1) or\
der by a.hcard_expiry_date            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,116,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,65,0,4,139,0,0,1,0,0,1,0,2,9,0,0,
55,0,0,3,32,0,4,145,0,0,1,0,0,1,0,2,9,0,0,
74,0,0,4,75,0,4,149,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
97,0,0,5,0,0,30,161,0,0,0,0,0,1,0,
112,0,0,6,972,0,9,303,0,0,2,2,0,1,0,1,9,0,0,1,3,0,0,
135,0,0,6,0,0,13,338,0,0,13,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
202,0,0,7,515,0,6,368,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
229,0,0,8,111,0,4,400,0,0,3,2,0,1,0,2,3,0,0,1,9,0,0,1,3,0,0,
256,0,0,6,0,0,15,414,0,0,0,0,0,1,0,
};


 
/* Preprocessor Directives    */

#include <stdio.h>
#include <string.h>
#include <process.h> 
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




#include <bl.h>
#include <winproc.h>

/* Macros */

#define NODATAFOUND sqlca.sqlcode==1403
#define OERROR (sqlca.sqlcode < 0) 
#define MAX_LINES 27

/* Declarations */

/* EXEC SQL BEGIN DECLARE SECTION; */ 
	

	/* VARCHAR uid_pwd 	        [95],	        
	     	nd_sysdate              [31],		
		nd_user_id  	        [31],	
		nd_hospital_name	[61],
		nd_ward			[16],
		nd_bed			[9] ,
		nd_patient_id		[21],
            d_short_name_full       [61],
		nd_patient_name		[61],
        nd_patient_name1		[61],
		nd_blng_grp		[16],
		nd_hcard_no		[21],
		nd_nationality		[5] ,
		nd_exp_date		[11],
		nd_adm_date		[20],
		nd_session_id		[25],
		nd_pgm_date		[31],
		nd_pgm_id		[20],
		nd_p_facility_id	[4],
		nd_cut_day		[5] ; */ 
struct { unsigned short len; unsigned char arr[95]; } uid_pwd;

struct { unsigned short len; unsigned char arr[31]; } nd_sysdate;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[61]; } nd_hospital_name;

struct { unsigned short len; unsigned char arr[16]; } nd_ward;

struct { unsigned short len; unsigned char arr[9]; } nd_bed;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[61]; } nd_patient_name1;

struct { unsigned short len; unsigned char arr[16]; } nd_blng_grp;

struct { unsigned short len; unsigned char arr[21]; } nd_hcard_no;

struct { unsigned short len; unsigned char arr[5]; } nd_nationality;

struct { unsigned short len; unsigned char arr[11]; } nd_exp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_adm_date;

struct { unsigned short len; unsigned char arr[25]; } nd_session_id;

struct { unsigned short len; unsigned char arr[31]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[4]; } nd_p_facility_id;

struct { unsigned short len; unsigned char arr[5]; } nd_cut_day;
	

	char    nd_filename	        [100];

	long 	nd_srl_no		,
		nd_adm_no		,
		nd_eos_day		,

		nd_cut_off_day		;



/* EXEC SQL END DECLARE SECTION; */ 


	FILE 	*f1;
	int	page = 0;
	int	line = 0;

void proc_main(argc, argv)
		int 	argc;
		char 	*argv[];
{    
   void prt_line(int l, char spl_symbol[1]);
   void prt_hdr_initial();
   void prt_hdr();    
   void dec_cursor();
   void open_cursor();
   void close_cursor();
   int  fetch_cursor();  
   void report_process();
   void line_check();
   

/* INPUT ARGUMENT CHECK */

     if(argc != 7) 
     {
	     disp_message(ORA_MESG, "Usage BLRLSBIL uid/passwd@db Session Pgm-Date Cut-Off-Days Facility");
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

	
     strcpy(nd_cut_day.arr,argv[5]);
     nd_cut_day.len = strlen(nd_cut_day.arr); 

     strcpy(nd_p_facility_id.arr, argv[6]);
     nd_p_facility_id.len = strlen(nd_p_facility_id.arr);      	 

     strcpy(g_facility_id,nd_p_facility_id.arr);

     nd_cut_off_day = atoi(nd_cut_day.arr);

       
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
	
  nd_sysdate.arr[0]		= '\0';  
  nd_sysdate.len		= 0;

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

  nd_user_id.arr[0]		= '\0';  
  nd_user_id.len		=0;
  
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

  nd_hospital_name.arr[nd_hospital_name.len]	= '\0';        
  /* EXEC SQL SELECT accounting_name INTO :nd_hospital_name FROM sy_acc_entity
           WHERE acc_entity_id = :nd_p_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select accounting_name into :b0  from sy_acc_entity where a\
cc_entity_id=:b1";
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
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )97;
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
   }
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
   fprintf(f1,"Current Inpatients – Health Card Status");               
   prt_line(25," "); 
   fprintf(f1,"Page :%4d",page);           
   fprintf(f1,"\n"); 
   fprintf(f1,"REP : BLRHCCUR"); 
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

   fprintf(f1,"			Cut off Days : %-5d",nd_cut_off_day);
   fprintf(f1,"\n");    

   line = MAX_LINES + 1; 
   line_check();	
}

	
void prt_hdr()
{     
   line = 0;    
   page = page +1;
   fprintf(f1,"\n");       
   fprintf(f1,"MDL : BL");
   prt_line(40," "); 
   fprintf(f1,"%-30s",nd_hospital_name.arr);
   prt_line(30," "); 
   fprintf(f1,"%-16s",nd_sysdate.arr);           
   fprintf(f1,"\n"); 
   fprintf(f1,"OPR : %-31s",nd_user_id.arr); 
   prt_line(10," ");    
   fprintf(f1,"Current Inpatients – Health Card Status");
   prt_line(25," "); 
   fprintf(f1,"Page :%4d",page);           
   fprintf(f1,"\n"); 
   fprintf(f1,"REP : BLRHCCUR"); 
   prt_line(25," ");    
   fprintf(f1,"        ( Expired / Expiring in %-5d day(s) )",nd_cut_off_day);
   prt_line(35," "); 
   fprintf(f1,"\n"); 
   prt_line(132,"-");     
   fprintf(f1,"\n");    
   fprintf(f1,"Admission/    Ward            Bed      Patient Id           Name                    Health Card No Expiry Date Admission Date&Time");
   fprintf(f1, "\n");   
   fprintf(f1,"Trf No.						   Billing Group 	 	     Nationality    Eos Day(s)");
	       
   fprintf(f1, "\n");   
   prt_line(132,"-");  
   fprintf(f1, "\n");   
   line = line + 7;  
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
  SELECT	a.patient_id 		patient_id	,
		d.episode_id		adm_no		,		
		a.hcard_num  		hcard_num 	,
		To_CHAR(a.hcard_expiry_date,'DD/MM/YYYY')
			   	        expiry_date	,
		ROUND(a.hcard_expiry_date-SYSDATE)
					eos_days	,
		b.short_desc		blng_group	,
		/osubstr(c.short_name,1,23)		Pat_name	,
		substr(c.short_name,24,60)      Pat_name1 ,
          o/
		  substr(c.short_name,1,30)		Pat_name	,
		substr(c.short_name,31,60)      Pat_name1 ,
		    c.short_name,
		g.nationality nationality	,
		to_char(d.admission_date_time,'dd/mm/yyyy hh24:mi')
					adm_date,
		f.short_desc		ward		,
		d.cur_bed_num		bed		 
  FROM		bl_patient_fin_dtls	a	,
		bl_blng_grp		b	,	
		mp_patient_mast	c	,	    
		ip_episode		d	,   
		ip_ward			f	,   
		mp_country_his_vw		g
  WHERE		a.hcard_num IS NOT NULL  
  AND           d.facility_id =       :nd_p_facility_id
  AND           f.facility_id =       d.facility_id  
  AND		g.country_code		=       c.nationality_code 	
  AND		a.hcard_expiry_date > TRUNC(SYSDATE)
  AND	 	b.blng_grp_id		=	a.blng_grp_id
  AND		c.patient_id		=	a.patient_id
  AND		nvl(c.STATUS,'~')	<>	'S'	
  AND		d.patient_id		=	a.patient_id
  AND		d.episode_status	=	'0'  
  AND		f.ward_code		=	d.cur_ward_code
  AND		ROUND(a.hcard_expiry_date-SYSDATE) <= :nd_cut_off_day
  ORDER BY 	a.hcard_expiry_date; */ 

  return;

 }

void open_cursor()
{ 
 /* EXEC SQL OPEN hcard_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )112;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_p_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )6;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_cut_off_day;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
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
 {     disp_message (ORA_MESG, "Open HCard Cursor Failed");
       proc_exit();
 } 
 return;
 }

int fetch_cursor()
{ 

    nd_patient_id.arr[0]		= '\0';
    nd_hcard_no.arr[0]		 	= '\0';
    nd_exp_date.arr[0]			= '\0';
    nd_blng_grp.arr[0]			= '\0';
    nd_patient_name.arr[0]		= '\0';
	nd_patient_name1.arr[0]		= '\0';
    nd_nationality.arr[0]		= '\0';
    nd_adm_date.arr[0]			= '\0';
    nd_ward.arr[0]		        = '\0';
    nd_bed.arr[0]		        = '\0';

    nd_patient_id.len		= 0;
    nd_hcard_no.len	 	= 0;
    nd_exp_date.len		= 0;
    nd_blng_grp.len		= 0;
    nd_patient_name.len		= 0;
	nd_patient_name1.len		= 0;
    nd_nationality.len		= 0;
    nd_adm_date.len		= 0;
    nd_ward.len		        = 0;
    nd_bed.len		        = 0;



  /* EXEC SQL FETCH hcard_cursor 
	   INTO :nd_patient_id		,
		:nd_adm_no		,		
		:nd_hcard_no		,
		:nd_exp_date		,
		:nd_eos_day		,
		:nd_blng_grp		,
		:nd_patient_name	,
		:nd_patient_name1   ,
            :d_short_name_full,
		:nd_nationality		,
		:nd_adm_date		,
		:nd_ward		,
		:nd_bed			; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )135;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_adm_no;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_hcard_no;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_exp_date;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_eos_day;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_blng_grp;
  sqlstm.sqhstl[5] = (unsigned int  )18;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_patient_name;
  sqlstm.sqhstl[6] = (unsigned int  )63;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_patient_name1;
  sqlstm.sqhstl[7] = (unsigned int  )63;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_short_name_full;
  sqlstm.sqhstl[8] = (unsigned int  )63;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_nationality;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_adm_date;
  sqlstm.sqhstl[10] = (unsigned int  )22;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_ward;
  sqlstm.sqhstl[11] = (unsigned int  )18;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_bed;
  sqlstm.sqhstl[12] = (unsigned int  )11;
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



    if (NODATAFOUND)
    return 0;

    nd_patient_id.arr[nd_patient_id.len]		= '\0';
    nd_hcard_no.arr[nd_hcard_no.len]		 	= '\0';
    nd_exp_date.arr[nd_exp_date.len]			= '\0';
    nd_blng_grp.arr[nd_blng_grp.len]			= '\0';
    nd_patient_name.arr[nd_patient_name.len]		= '\0';
	nd_patient_name1.arr[nd_patient_name1.len]		= '\0';
    nd_nationality.arr[nd_nationality.len]		= '\0';
    nd_adm_date.arr[nd_adm_date.len]			= '\0';
    nd_ward.arr[nd_ward.len]			        = '\0';
    nd_bed.arr[nd_bed.len]			        = '\0';
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
    sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 \
) ; BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , \
str2 ) ; IF str2 IS NOT NULL THEN :nd_patient_name := str2 ; END IF ; blcommon\
 . split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 I\
S NOT NULL THEN :nd_patient_name1 := str2 ; END IF ; blcommon . split_words ( \
:d_short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :\
nd_patient_name1 := :nd_patient_name1 || str2 ; end if ; END ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )202;
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
       nd_patient_name1.arr[nd_patient_name1.len]  = '\0';

    nd_srl_no = '\0';    

    /* EXEC SQL SELECT		trn_srl_num INTO :nd_srl_no
	     FROM		bl_ip_adt_trn_vw 
	     WHERE 		patient_id = :nd_patient_id 
	     AND		episode_id = :nd_adm_no
	     AND		trn_type = 'T'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select trn_srl_num into :b0  from bl_ip_adt_trn_vw where \
((patient_id=:b1 and episode_id=:b2) and trn_type='T')";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )229;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_srl_no;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_adm_no;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
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

   	


    return 1;	

    
 }

void close_cursor()
{ 
 /* EXEC SQL CLOSE hcard_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )256;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 return;
 }
	

void report_process()
{        
    int fetch_cursor_check;

	line_check();

	dec_cursor();
	open_cursor();	    	

        fetch_cursor_check = fetch_cursor();   
         
  while(fetch_cursor_check)    
  {

	fprintf(f1,"%-8d",nd_adm_no,nd_srl_no); 		
        if (nd_srl_no != 0)
        {fprintf(f1,"/-%4d",nd_srl_no);}
	else
        {fprintf(f1,"     ");}   
	fprintf(f1," %-15s"  ,nd_ward.arr);
	fprintf(f1," %-8s"   ,nd_bed.arr);
	fprintf(f1," %-20.20s",nd_patient_id.arr);
	fprintf(f1," %-23.23s"  ,nd_patient_name.arr);
	fprintf(f1," %-14.14s"  ,nd_hcard_no.arr);
	fprintf(f1," %-11s"  ,nd_exp_date.arr);
	fprintf(f1," %-20s"  ,nd_adm_date.arr);	
        fprintf(f1, "\n");   	

	if(strlen(nd_patient_name1.arr) > 2)
	{
	 fprintf(f1,"%48s %s \n"," ",nd_patient_name1.arr);
	 line++;
	}
	prt_line(49," ");
	fprintf(f1," %-15s"  ,nd_blng_grp.arr);	
	prt_line(18," ");
	fprintf(f1," %-15s"  ,nd_nationality.arr);	
	prt_line(8," ");
	fprintf(f1," %-8d"  ,nd_eos_day);		
        fprintf(f1, "\n");   	
	line = line + 1;	
	line_check();
        fetch_cursor_check = fetch_cursor();      
  }
 	 fprintf(f1,"\n");
	 fprintf(f1,"\n");
	 prt_line(58," "); 
	 fprintf(f1,"*** End Of Report ***");
         fprintf(f1, "\n");   	 
	 close_cursor();
}
