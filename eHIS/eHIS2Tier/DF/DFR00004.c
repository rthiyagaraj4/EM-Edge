
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
    "C:\\Temp\\DFR00004.pc"
};


static unsigned long sqlctx = 36363835;


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

 static const char *sq0006 = 
"),A.BLNG_SERV_CODE,A.TRX_DATE,A.PATIENT_ID,A.EPISODE_ID,A.VISIT_ID          \
  ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,91,0,2,160,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,170,0,0,0,0,0,1,0,
43,0,0,3,0,0,27,182,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
74,0,0,4,205,0,4,215,0,0,10,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
129,0,0,5,95,0,4,263,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
156,0,0,6,1102,0,9,330,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
199,0,0,6,0,0,15,344,0,0,0,0,0,1,0,
214,0,0,6,0,0,13,389,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
285,0,0,7,158,0,4,836,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
320,0,0,8,96,0,4,922,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
343,0,0,9,165,0,6,929,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 2.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : DFR00004.PC                                  */
/* CALLED FROM           : DFR00004.FMB                                 */
/*                                                                      */
/************************************************************************/

#include <stdio.h>
#include <string.h>
#include <bl.h>

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define	MAX_LINES	42
#define	REP_WIDTH	130
#define ESC     0x1B

#define INIT_MESG "Report Generation is in progress"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name								[120],
            date_time                               [20],
            user_id                                 [40],
            nd_session_id                           [16],
            nd_pgm_date                             [25],
			p_facility_id							[3],
            d_curr_pgm_name                         [15],
			uid_pwd									[20],
				lv_facility_id	   [3],
			fr_doctor				[16],
			d_doctor_name           [16],
			fr_period				[8],
			to_period				[8],
			fr_revenu_cat			[11],
			to_revenu_cat			[11],
			nd_episode_type			[2],
			d_process_mth_year		[10],
			d_revenue_category		[11],
			d_revenue_cate_desc		[16],
			temp_revenue_category   [11],
			temp_process_mth_year   [10],
			temp_physician_id		[16],
			d_blng_serv_code		[11],
			d_trx_date				[11],
			d_patient_id			[21],
			d_episode_id			[9],	
			d_visit_id				[5],
			nd_repeat_grp			[2],
			 l_translated_value		[201],	
			 l_pk_value				[100],
			 P_LANGUAGE_ID [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } p_facility_id;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[20]; } uid_pwd;

struct { unsigned short len; unsigned char arr[3]; } lv_facility_id;

struct { unsigned short len; unsigned char arr[16]; } fr_doctor;

struct { unsigned short len; unsigned char arr[16]; } d_doctor_name;

struct { unsigned short len; unsigned char arr[8]; } fr_period;

struct { unsigned short len; unsigned char arr[8]; } to_period;

struct { unsigned short len; unsigned char arr[11]; } fr_revenu_cat;

struct { unsigned short len; unsigned char arr[11]; } to_revenu_cat;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[10]; } d_process_mth_year;

struct { unsigned short len; unsigned char arr[11]; } d_revenue_category;

struct { unsigned short len; unsigned char arr[16]; } d_revenue_cate_desc;

struct { unsigned short len; unsigned char arr[11]; } temp_revenue_category;

struct { unsigned short len; unsigned char arr[10]; } temp_process_mth_year;

struct { unsigned short len; unsigned char arr[16]; } temp_physician_id;

struct { unsigned short len; unsigned char arr[11]; } d_blng_serv_code;

struct { unsigned short len; unsigned char arr[11]; } d_trx_date;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[2]; } nd_repeat_grp;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[3]; } P_LANGUAGE_ID;

		

int d_qty , d_sub_tot_qty , d_gt_tot_qty ,i;

double  d_gross_amt, d_discount_amt, d_net_amt, d_doct_reve_amt,d_asst_doct_reve_amt ,
		 d_sub_gross_amt , d_sub_discount_amt ,d_sub_net_amt ,
	    d_sub_doct_reve_amt , d_sub_asst_doct_reve_amt ,  d_gt_gross_amt ,
	    d_gt_discount_amt , d_gt_net_amt , d_gt_doct_reve_amt , d_gt_asst_doct_reve_amt;
 
int first = 0;
							             
		
int rep_len=0;
                       	
char filename[150];
char string_var[200];
char  loc_legend[999][201];
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

int    lctr = 0,pctr = 0;

FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    if (argc < 4)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }

	strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

 
    if (sql_connect() == -1)
    {
        disp_message(ORA_MESG,"Error in connecting to Oracle");
        proc_exit();
    }



    if (sqlca.sqlcode < 0 )
	{
        disp_message(ORA_MESG,"Error in connecting to Oracle");
        proc_exit();
    }

	set_meduser_role(); 

	strcpy(P_LANGUAGE_ID.arr,l_language_id.arr);
	P_LANGUAGE_ID.len = l_language_id.len;

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    
    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);

		 strcpy(lv_facility_id.arr, argv[4]);
    lv_facility_id.len = strlen(lv_facility_id.arr);
    strcpy(g_facility_id, lv_facility_id.arr);

    
   fetch_prog_param();


   declare_cursor();


    open_det_cur();


    open_file();


	 fprintf(fp,"%c&l1O",ESC); /* Set Landscape*/ 
	 fprintf(fp,"%c&a2L",ESC); 	/* To Set the Left margin */
	 fprintf(fp,"%c(s15H",ESC); 	/* To set the font 	*/
	 rep_len=160;
	
		
    fetch_legend_value();

	fetch_hosp_name();

	print_first_page();


    do_report();

	

	close_det_cur();

	/* EXEC SQL DELETE SY_PROG_PARAM
            WHERE PGM_ID   = 'DFR00004'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='DFR00004' and SE\
SSION_ID=:b0) and PGM_DATE=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
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
 sqlstm.sqhstl[1] = (unsigned int  )27;
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
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");

    end_prog_msg();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )28;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");


    end_of_rep();

}


sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )43;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )22;
  sqlstm.sqhsts[0] = (         int  )22;
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
      return(-1);
  return(0);
}

fetch_prog_param()
{
		fr_doctor.arr[0]			= '\0';	
		fr_period.arr[0]			= '\0';
		to_period.arr[0]			= '\0';
		fr_revenu_cat.arr[0]		= '\0';
		to_revenu_cat.arr[0]		= '\0';
		nd_episode_type.arr[0]		= '\0';
		p_facility_id.arr[0]		= '\0';
		nd_repeat_grp.arr[0]		= '\0';
				


		fr_doctor.len					= 0 ;	
		fr_period.len					= 0 ;
		to_period.len					= 0 ;
		fr_revenu_cat.len				= 0 ;
		to_revenu_cat.len				= 0 ;
		nd_episode_type.len				= 0 ;
		p_facility_id.len				= 0;
		nd_repeat_grp.len				= 0 ;
		
		



    /* EXEC SQL SELECT OPERATING_FACILITY_ID,
					PARAM1,
					PARAM2,
					PARAM3,
					PARAM4,
					PARAM5,
				    PARAM6,
					PARAM7
              INTO	:p_facility_id,
					:fr_doctor,	
					:fr_period,
					:to_period,
					:fr_revenu_cat,
					:to_revenu_cat,
					:nd_episode_type,
					:nd_repeat_grp
            FROM SY_PROG_PARAM
            WHERE PGM_ID   = 'DFR00004'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PAR\
AM4 ,PARAM5 ,PARAM6 ,PARAM7 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_PROG\
_PARAM where ((PGM_ID='DFR00004' and SESSION_ID=:b8) and PGM_DATE=:b9)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )74;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&p_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&fr_doctor;
    sqlstm.sqhstl[1] = (unsigned int  )18;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&fr_period;
    sqlstm.sqhstl[2] = (unsigned int  )10;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&to_period;
    sqlstm.sqhstl[3] = (unsigned int  )10;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&fr_revenu_cat;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&to_revenu_cat;
    sqlstm.sqhstl[5] = (unsigned int  )13;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_repeat_grp;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[8] = (unsigned int  )18;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[9] = (unsigned int  )27;
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

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");
	
			
			p_facility_id.arr[p_facility_id.len] = '\0';
			fr_doctor.arr[fr_doctor.len] = '\0' ;	
			fr_period.arr[fr_period.len] = '\0';
			to_period.arr[to_period.len] = '\0';
			fr_revenu_cat.arr[fr_revenu_cat.len] = '\0';
			to_revenu_cat.arr[to_revenu_cat.len] = '\0';
			nd_episode_type.arr[nd_episode_type.len] = '\0' ;
			nd_repeat_grp.arr[nd_repeat_grp.len]	 = '\0';
			
			


}

get_doct_desc()
{

	d_doctor_name.arr[0]  = '\0';
	d_doctor_name.len  = 0;

	/* EXEC SQL SELECT SHORT_NAME
	         INTO   :d_doctor_name
	FROM     SY_PHYSICIAN_MAST 
	WHERE    FACILITY_ID = :p_facility_id
	AND      PHYSICIAN_ID = :fr_doctor ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_NAME into :b0  from SY_PHYSICIAN_MAST where (FA\
CILITY_ID=:b1 and PHYSICIAN_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )129;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doctor_name;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&fr_doctor;
 sqlstm.sqhstl[2] = (unsigned int  )18;
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



	d_doctor_name.arr[d_doctor_name.len] = '\0';
	
	if (OERROR)
        err_mesg("SELECT failed on table SY_PHYSICIAN_MAST",0,"");

  if (NOT_FOUND)
        err_mesg("No Record found in SY_PHYSICIAN_MAST",0,"");
}
		
declare_cursor()
{

   /* EXEC SQL DECLARE DF_SUMM_CUR CURSOR FOR
   SELECT	A.REVENUE_CATEGORY, 
			C.SHORT_DESC, 
			A.PROCESSING_MONTH||'/'||A.PROCESSING_YEAR, 
			A.BLNG_SERV_CODE, 
			to_char(A.TRX_DATE, 'DD/MM/YYYY'),
			A.PATIENT_ID, 
			A.EPISODE_ID, 
			A.VISIT_ID, 
			SUM(NVL(A.SERV_QTY,0)) QTY,
			SUM(NVL(A.GROSS_AMT,0)) GROSS_AMT, 
			SUM(NVL(A.DISCOUNT_AMT,0)) DISCOUNT_AMT, 
			SUM(NVL(A.NET_REVENUE_AMT,0)) NET_AMT, 
			SUM(NVL(A.DR_REVENUE_AMT,0)) DR_REVENUE_AMT, 
			SUM(NVL(A.SPLIT_AMT,0)) ASST_DOC_REV_AMT
			FROM df_rev_folio_slmt_vw A, DF_REVENUE_CATEGORY C
			WHERE A.REVENUE_CATEGORY      = C.REVENUE_CATEGORY
			AND   A.PHYSICIAN_ID          = :fr_doctor
			AND   A.REVENUE_CATEGORY BETWEEN NVL(:fr_revenu_cat, '!!!!!!!!!!') AND NVL(:to_revenu_cat, '~~~~~~~~~~')
			AND   TO_DATE(A.PROCESSING_MONTH||'/'||A.PROCESSING_YEAR , 'MM/YYYY') BETWEEN to_date(:fr_period , 'MM/YYYY') AND TO_DATE(:to_period , 'MM/YYYY')
			AND   A.EPISODE_TYPE = DECODE(:nd_episode_type, 'A', A.EPISODE_TYPE, :nd_episode_type)
			--AND    NVL(A.DF_TRX_STATUS, 'N') != 'C'
			GROUP BY A.REVENUE_CATEGORY, 
					 C.SHORT_DESC, 
					 A.PROCESSING_MONTH||'/'||A.PROCESSING_YEAR, 
					 A.BLNG_SERV_CODE, 
					 A.TRX_DATE, 
					 A.PATIENT_ID, 
					 A.EPISODE_ID, 
					 A.VISIT_ID
			ORDER BY A.REVENUE_CATEGORY, 
					 A.PROCESSING_MONTH||'/'||A.PROCESSING_YEAR, 
					 A.BLNG_SERV_CODE, 
					 A.TRX_DATE,
					 A.PATIENT_ID, 
					 A.EPISODE_ID, 
					 A.VISIT_ID ; */ 

     
	if(OERROR)
		err_mesg("DECLARE failed on cursor DF_SUMM_CUR",0,""); 


 
	
}


open_det_cur()
{
	/* EXEC SQL OPEN DF_SUMM_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select A.REVENUE_CATEGORY ,C.SHORT_DESC ,((A.PROCESSING_MONTH||'/')||A.P\
ROCESSING_YEAR) ,A.BLNG_SERV_CODE ,to_char(A.TRX_DATE,'DD/MM/YYYY') ,A.PATIE\
NT_ID ,A.EPISODE_ID ,A.VISIT_ID ,sum(NVL(A.SERV_QTY,0)) QTY ,sum(NVL(A.GROSS\
_AMT,0)) GROSS_AMT ,sum(NVL(A.DISCOUNT_AMT,0)) DISCOUNT_AMT ,sum(NVL(A.NET_R\
EVENUE_AMT,0)) NET_AMT ,sum(NVL(A.DR_REVENUE_AMT,0)) DR_REVENUE_AMT ,sum(NVL\
(A.SPLIT_AMT,0)) ASST_DOC_REV_AMT  from df_rev_folio_slmt_vw A ,DF_REVENUE_C\
ATEGORY C where ((((A.REVENUE_CATEGORY=C.REVENUE_CATEGORY and A.PHYSICIAN_ID\
=:b0) and A.REVENUE_CATEGORY between NVL(:b1,'!!!!!!!!!!') and NVL(:b2,'~~~~\
~~~~~~')) and TO_DATE(((A.PROCESSING_MONTH||'/')||A.PROCESSING_YEAR),'MM/YYY\
Y') between to_date(:b3,'MM/YYYY') and TO_DATE(:b4,'MM/YYYY')) and A.EPISODE\
_TYPE=DECODE(:b5,'A',A.EPISODE_TYPE,:b5)) group by A.REVENUE_CATEGORY,C.SHOR\
T_DESC,((A.PROCESSING_MONTH||'/')||A.PROCESSING_YEAR),A.BLNG_SERV_CODE,A.TRX\
_DATE,A.PATIENT_ID,A.EPISODE_ID,A.VISIT_ID order by A.REVENUE_CATEGORY,((A.P\
ROCESSING_MONTH||'/')||A.PROCESSING_YEAR");
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )156;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&fr_doctor;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&fr_revenu_cat;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&to_revenu_cat;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&fr_period;
 sqlstm.sqhstl[3] = (unsigned int  )10;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&to_period;
 sqlstm.sqhstl[4] = (unsigned int  )10;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[6] = (unsigned int  )4;
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



		if(OERROR)
			err_mesg("OPEN failed on cursor DF_SUMM_CUR",0,""); 


			
 
}


close_det_cur()
{

	/* EXEC SQL CLOSE DF_SUMM_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
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



	 
    
}

  
fetch_df_summ_cur()
{

		 
		d_process_mth_year.arr[0]	= '\0';
		d_revenue_category.arr[0]	= '\0';
		d_revenue_cate_desc.arr[0]	= '\0';
		d_blng_serv_code.arr[0]		= '\0';
		d_trx_date.arr[0]			= '\0';
		d_patient_id.arr[0]			= '\0';
		d_episode_id.arr[0]			= '\0';
		d_visit_id.arr[0]			= '\0';
 
 

		 
		d_process_mth_year.len		= 0;
		d_revenue_category.len		= 0;
		d_revenue_cate_desc.len		= 0;
		d_blng_serv_code.len		= 0;
		d_trx_date.len				= 0;
		d_patient_id.len			= 0;
		d_episode_id.len			= 0;
		d_visit_id.len				= 0;
	 


		d_qty						= 0; 
		d_gross_amt					= 0;
		d_discount_amt				= 0;
		d_net_amt					= 0;
		d_doct_reve_amt				= 0;
		d_asst_doct_reve_amt		= 0;
	 




	/* EXEC SQL FETCH DF_SUMM_CUR
               INTO 
				:d_revenue_category,
				:d_revenue_cate_desc,
				:d_process_mth_year,
				:d_blng_serv_code,
				:d_trx_date,
				:d_patient_id,
				:d_episode_id,
				:d_visit_id,
				:d_qty,
				:d_gross_amt,
				:d_discount_amt,
				:d_net_amt,
				:d_doct_reve_amt,
				:d_asst_doct_reve_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )214;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_revenue_category;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_revenue_cate_desc;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_process_mth_year;
 sqlstm.sqhstl[2] = (unsigned int  )12;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_code;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_trx_date;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[5] = (unsigned int  )23;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_episode_id;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_visit_id;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_qty;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_gross_amt;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_discount_amt;
 sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_net_amt;
 sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_doct_reve_amt;
 sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&d_asst_doct_reve_amt;
 sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
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




	if (OERROR)
            err_mesg("FETCH failed on cursor DF_SUMM_CUR",0,"");


 
	d_process_mth_year.arr[d_process_mth_year.len]		= '\0' ;
	d_revenue_category.arr[d_revenue_category.len]		= '\0' ;
	d_revenue_cate_desc.arr[d_revenue_cate_desc.len]	= '\0';
	d_blng_serv_code.arr[d_blng_serv_code.len]			= '\0';
	d_trx_date.arr[d_trx_date.len]						= '\0';
	d_patient_id.arr[d_patient_id.len]					= '\0';
	d_episode_id.arr[d_episode_id.len]					= '\0';
	d_visit_id.arr[d_visit_id.len]						= '\0';
 
	

  
	
	return(LAST_ROW?0:1);

  }




open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"DFR00004.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file DFR00004.lis");
       proc_exit();
    }
}



do_report()
{

print_head();

process_for_doctor();
  

  
}


process_for_doctor()
{

	first =0;
	while(fetch_df_summ_cur())
	{
	check_line(1);
		if (strcmp(temp_revenue_category.arr,d_revenue_category.arr)!=0) 
		{
			if (first == 1) 
			{ 
				print_rev_sub_tot();
			} 
		}


		
		if (strcmp(temp_revenue_category.arr,d_revenue_category.arr)!=0) 
		{
					//fprintf(fp,"Revenue category : %-10s(%-15s)",  d_revenue_category.arr ,d_revenue_cate_desc.arr );
					fprintf(fp,"%-16s : %-10s(%-15s)",loc_legend[13], d_revenue_category.arr ,d_revenue_cate_desc.arr );

					fprintf(fp , "\n" );
					lctr = lctr + 1 ;
		
		}


		if (lctr >= MAX_LINES)
		{
			next_page();
			fprintf(fp,"%-16s : %-10s(%-15s)", loc_legend[13], d_revenue_category.arr ,d_revenue_cate_desc.arr );
			fprintf(fp , "\n" );
			lctr = lctr + 1 ;
			print_details();
		}
		else
		{
			print_details();
		}	
	
		

		first=1;

		strcpy(temp_revenue_category.arr,d_revenue_category.arr);
		
		d_sub_tot_qty = d_sub_tot_qty + d_qty; 
		d_sub_gross_amt = d_sub_gross_amt + d_gross_amt;
		d_sub_discount_amt = d_sub_discount_amt +  d_discount_amt;
		d_sub_net_amt = d_sub_net_amt + d_net_amt;
		d_sub_doct_reve_amt =  d_sub_doct_reve_amt + d_doct_reve_amt;
		d_sub_asst_doct_reve_amt  = d_sub_asst_doct_reve_amt + d_asst_doct_reve_amt;

		d_gt_tot_qty = d_gt_tot_qty + d_qty; 
		d_gt_gross_amt = d_gt_gross_amt + d_gross_amt;
		d_gt_discount_amt = d_gt_discount_amt +  d_discount_amt;
		d_gt_net_amt = d_gt_net_amt + d_net_amt;
		d_gt_doct_reve_amt =  d_gt_doct_reve_amt + d_doct_reve_amt;
		d_gt_asst_doct_reve_amt  = d_gt_asst_doct_reve_amt + d_asst_doct_reve_amt;

		 


	}

	 
	print_rev_sub_tot();
	grant_tot();


	end_of_rep();

}



print_details()
{
check_line(1);
fprintf(fp ,"%-7s  ", d_process_mth_year.arr);
fprintf(fp ,"%-10s  ", d_blng_serv_code.arr);
fprintf(fp ,"%-10s  ", d_trx_date.arr); 
fprintf(fp ,"%-20s  ", d_patient_id.arr);
fprintf(fp ,"%8s  ", d_episode_id.arr);
fprintf(fp ,"%4s    ", d_visit_id.arr);
fprintf(fp ,"%3d  ", d_qty);
print_formated(d_gross_amt);
print_formated(d_discount_amt);
print_formated(d_net_amt);
fprintf(fp,"   ");
print_formated(d_doct_reve_amt);
print_formated(d_asst_doct_reve_amt);
fprintf(fp, "\n");
lctr = lctr + 1 ;

}

 
print_rev_sub_tot() 
{
    check_line(3);
    horz_skip(54) ;
	print_line('-',106);
    fprintf(fp, "\n");

	//fprintf(fp , "%26s Revenue Category - %-10s - Total " , " " ,temp_revenue_category.arr) ;

	fprintf(fp , "%26.26s %-16.16s - %-10.10s - %5.5s " , " " ,loc_legend[13],temp_revenue_category.arr,loc_legend[15]) ;

    fprintf(fp , "       ");
	fprintf(fp ,"%4d  ",d_sub_tot_qty);
	print_formated(d_sub_gross_amt);
	print_formated(d_sub_discount_amt);
	print_formated(d_sub_net_amt);
	fprintf(fp,"   ");
	print_formated(d_sub_doct_reve_amt);
	print_formated(d_sub_asst_doct_reve_amt);
	
    fprintf(fp, "\n");
	
    
	d_sub_tot_qty = 0;
	d_sub_gross_amt = 0;
	d_sub_discount_amt = 0;
	d_sub_net_amt = 0;
	d_sub_doct_reve_amt = 0;
	d_sub_asst_doct_reve_amt = 0 ;

	horz_skip(54) ;
	print_line('=',106);
    fprintf(fp, "\n");

	lctr = lctr + 3;
}



grant_tot()
{
   check_line(3);
	//fprintf(fp , "%26s Grand Total                     " , " ");
	fprintf(fp , "%26.26s %31.31s" , " ",loc_legend[38]);
	fprintf(fp , "              ");
	
	fprintf(fp ,"%4d  ",d_gt_tot_qty);
	print_formated(d_gt_gross_amt);
	print_formated(d_gt_discount_amt);
	print_formated(d_gt_net_amt);
	fprintf(fp,"   ");
	print_formated(d_gt_doct_reve_amt);
	print_formated(d_gt_asst_doct_reve_amt);

    fprintf(fp, "\n");
	
	print_line('-',rep_len);
    fprintf(fp, "\n");

	d_gt_tot_qty = 0;
	d_gt_gross_amt = 0;
	d_gt_discount_amt = 0;
	d_gt_net_amt = 0;
	d_gt_doct_reve_amt = 0;
	d_gt_asst_doct_reve_amt = 0;
	  
}


print_first_page()
{

int hosp_nm_len, rep_title_len = 10, s1,date_len,pgm_len;

lctr=0;
get_doct_desc();

fprintf(fp, "\n");
 	fprintf(fp,"%-4s: DF",loc_legend[1]);
	hosp_nm_len  =  hosp_name.len;
	s1 = (rep_len-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(fp,"%s", hosp_name.arr);
	s1 = (rep_len-s1-hosp_nm_len);
	horz_skip(s1-24);

		fprintf(fp,"%-s: %s",loc_legend[4],date_time.arr);
		 

  fprintf(fp, "\n");

	fprintf(fp,"%-4s: %s",loc_legend[2],user_id.arr); 

  fprintf(fp, "\n");
 
   	fprintf(fp,"%-4s: %s",loc_legend[3],"DFR00004");
 

  
	rep_title_len = 66;
	s1 = (rep_len-rep_title_len)/2;
	horz_skip(s1);

    fprintf(fp, "%22s : %-15s %-15s - %-8s " ,loc_legend[6], fr_doctor.arr ,d_doctor_name.arr,loc_legend[7]);

	
	 
    horz_skip(7);

  		fprintf(fp,"%-s: %4d",loc_legend[5],++pctr);

    fprintf(fp, "\n");

print_line('-',rep_len);
fprintf(fp, "\n");
fprintf(fp, "\n");
fprintf(fp,"VER : 4.1");
fprintf(fp, "\n");
fflush(fp);
fprintf(fp, "\n");
fprintf(fp, "\n");
fprintf(fp, "\n");
fprintf(fp, "\n");
fprintf(fp,"        INPUT PARAMETERS :");
fprintf(fp, "\n");
fprintf(fp,"        ----------------");
fprintf(fp, "\n");
fprintf(fp, "\n");


fprintf(fp,"%25s        : %s",loc_legend[8],fr_doctor.arr);

fprintf(fp, "\n");
fprintf(fp, "\n");



fprintf(fp,"%24s   %5s : %s",loc_legend[11],loc_legend[26],fr_period.arr);

fprintf(fp, "\n");
fprintf(fp, "\n");

fprintf(fp,"%24s   %5s : %s",loc_legend[11],loc_legend[27],to_period.arr);

fprintf(fp, "\n");
fprintf(fp, "\n");

if (strcmp(fr_revenu_cat.arr, "!!!!!!!!!!")  == 0)
fprintf(fp,"%24s   %5s : %s",loc_legend[13],loc_legend[26],loc_legend[9]);
else
fprintf(fp,"%24s   %5s : %s",loc_legend[13],loc_legend[26],fr_revenu_cat.arr);

fprintf(fp, "\n");
fprintf(fp, "\n");

if (strcmp(to_revenu_cat.arr, "~~~~~~~~~~")  == 0)
fprintf(fp,"%24s   %5s : %s",loc_legend[13],loc_legend[27],loc_legend[10]);
else
fprintf(fp,"%24s   %5s : %s",loc_legend[13],loc_legend[27],to_revenu_cat.arr);

fprintf(fp, "\n");
fprintf(fp, "\n");



if (strcmp(nd_episode_type.arr,"E")==0)
fprintf(fp,"%31s  : %-s",loc_legend[14],loc_legend[31]);

if (strcmp(nd_episode_type.arr,"O")==0)
fprintf(fp,"%31s  : %-s",loc_legend[14],loc_legend[30]);

if (strcmp(nd_episode_type.arr,"I")==0)
fprintf(fp,"%31s  : %-s",loc_legend[14],loc_legend[28]);

if (strcmp(nd_episode_type.arr,"R")==0)
fprintf(fp,"%31s  : %-s",loc_legend[14],loc_legend[32]);

if (strcmp(nd_episode_type.arr,"D")==0)
fprintf(fp,"%31s  : %-s",loc_legend[14],loc_legend[29]);

if (strcmp(nd_episode_type.arr,"A")==0)
fprintf(fp,"%31s  : %-s",loc_legend[14],loc_legend[33]);



fprintf(fp, "\n");
fprintf(fp, "\n");




fprintf(fp,"\n\f");

}




print_head()
{
int hosp_nm_len, rep_title_len = 10, s1,date_len,pgm_len;

    lctr=0;

	get_doct_desc();


fprintf(fp, "\n");
 	fprintf(fp,"%-4s: DF",loc_legend[1]);
	hosp_nm_len  =  hosp_name.len;
	s1 = (rep_len-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(fp,"%s", hosp_name.arr);
	s1 = (rep_len-s1-hosp_nm_len);
	horz_skip(s1-24);

		fprintf(fp,"%-s: %s",loc_legend[4],date_time.arr);
		 

  fprintf(fp, "\n");

	fprintf(fp,"%-4s: %s",loc_legend[2],user_id.arr); 

  fprintf(fp, "\n");
 
   	fprintf(fp,"%-4s: %s",loc_legend[3],"DFR00004");
 

  
	rep_title_len = 66;
	
	s1 = (rep_len-rep_title_len)/2;
	horz_skip(s1);

       fprintf(fp, "%22s : %-15s %-15s - %-8s " ,loc_legend[6], fr_doctor.arr ,d_doctor_name.arr,loc_legend[7]);



	
	 
         horz_skip(7);


  	fprintf(fp,"%-s: %4d",loc_legend[5],++pctr);

    fprintf(fp, "\n");



print_line('-',rep_len);
fprintf(fp, "\n");

//fprintf(fp , "Period   Billing     Trx.Date    Patient Date        Episode ID  Visit   Serv           Gross            Disc             Net     Doctor's Share    Asst. Doctor");

fprintf(fp , "%-8s %-11s %-11s %-19s %-11s %-6s %-5s %15s %15s %15s%19s %15s",loc_legend[11],loc_legend[17],loc_legend[19],loc_legend[20],loc_legend[21],loc_legend[22],loc_legend[23],loc_legend[24],loc_legend[25],loc_legend[34],loc_legend[35],loc_legend[39]);


fprintf(fp, "\n");
fprintf(fp , "%9s%-11s %44s%4s%7s  %15s %15s %15s%19s %15s"," ",loc_legend[18]," ",loc_legend[42],loc_legend[41],loc_legend[36],loc_legend[36],loc_legend[36],loc_legend[40],loc_legend[40]);
//fprintf(fp , "         Service                                                    ID    Qty          Amount          Amount          Amount             Amount    Share Amount");
fprintf(fp, "\n");
print_line('-',rep_len);
fprintf(fp, "\n");
lctr = 7 ;

}

 



fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;
    /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),USER
             INTO :hosp_name, :date_time, :user_id
             FROM SY_ACC_ENTITY_LANG_VW
			 WHERE acc_entity_id =:lv_facility_id
			 and LANGUAGE_ID=:P_LANGUAGE_ID ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (acc_entity_id=:\
b3 and LANGUAGE_ID=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )285;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&hosp_name;
    sqlstm.sqhstl[0] = (unsigned int  )122;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&date_time;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&user_id;
    sqlstm.sqhstl[2] = (unsigned int  )42;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&lv_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&P_LANGUAGE_ID;
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



       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

hosp_name.arr[hosp_name.len]           = '\0';
date_time.arr[date_time.len]           = '\0';
user_id.arr[user_id.len]               = '\0';
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
        sprintf(str_amt,"%15s",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%15s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%15s",str_amt);
    }

}             


check_line(skip) /* will check for MAX LINE before printing totals */
int skip;
{
	if ((lctr + skip) >= MAX_LINES)
	{
		next_page(); 
	}
}

next_page() /* will move the cursor to next page */
{
  
	fprintf(fp,"\n\f");
    print_head();
	
  
  	
}

print_line(ch,n) /* this is to obtain required characters */
  char ch;
  int n;
{
	int i;
	for(i=0;i<n;i++)
	fprintf(fp,"%c",ch);  //fprintf(fp,"\n");
	 
}

horz_skip(num) /* this is to obtain required blank space */
int num;
{
	int i;
	for(i=0;i<num;i++)fprintf(fp," ");
}

/*--------- OVER -------------*/




fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('DFR00004.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('DFR00004.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )320;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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
			blcommon.get_local_lang_desc(:lv_facility_id,
										'SM',
										'SM_LANG_LEGEND',
										'DFLT_LEGEND_VALUE',
										:l_pk_value,
										:l_translated_value,
										:P_LANGUAGE_ID);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :lv_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :P_LANGUAGE_ID ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )343;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_facility_id;
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
  sqlstm.sqhstv[3] = (         void  *)&P_LANGUAGE_ID;
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







end_of_rep()
 {

int  s1;

    lctr=0;

   fprintf(fp, "\n");
   	s1 = (rep_len-22)/2;
   horz_skip(s1);
  fprintf(fp,"***  END OF REPORT ***");

    fclose(fp);
  fprintf(fp,"%cE",ESC); /* To Reset the Printer */ 
  fflush(fp);
 }