
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/DF/DFR00003.pc"
};


static unsigned int sqlctx = 1288451635;


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

 static const char *sq0005 = 
"ween NVL(:b10,'!!!!!!!!') and NVL(:b11,'~~~~~~~~')) and A.EPISODE_TYPE=DECOD\
E(:b1,'A',A.EPISODE_TYPE,:b1)) group by A.PHYSICIAN_ID,B.SHORT_NAME,A.REVENUE_\
CATEGORY,C.SHORT_DESC,DECODE(:b0,'Y',DECODE(A.EPISODE_TYPE,'I','Inpatient','D'\
,'Daycare','O','Outpatient','E','Emergency','R','External'),DECODE(:b1,'I','In\
patient','D','Daycare','O','Outpatient','E','Emergency','R','External','A','  \
  All')) order by 1            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,91,0,2,168,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,178,0,0,0,0,0,1,0,
43,0,0,0,0,0,27,190,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
74,0,0,4,273,0,4,235,0,0,16,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1,9,0,0,
153,0,0,5,1443,0,9,339,0,0,16,16,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
232,0,0,5,0,0,15,353,0,0,0,0,0,1,0,
247,0,0,5,0,0,13,391,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,
0,0,2,4,0,0,2,4,0,0,
294,0,0,6,158,0,4,1022,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
329,0,0,7,96,0,4,1107,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
352,0,0,8,165,0,6,1114,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 2.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : DFR00003.PC                                  */
/* CALLED FROM           : DFR00003.FMB                                 */
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
#define	MAX_LINES	41
#define	REP_WIDTH	130
#define ESC     0x1B
  
#define INIT_MESG "Report Generation is in progress"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name								[120],
            date_time                               [20],
            user_id                                 [40],
            nd_session_id                           [16],
            nd_pgm_date                             [25],
            d_curr_pgm_name                         [15],
			uid_pwd									[20],
			lv_facility_id	   [3],
			fr_doctor				[16],
			to_doctor				[16],
			fr_period				[8],
			to_period				[8],
			fr_revenu_cat			[11],
			to_revenu_cat			[11],
			fr_blng_grp				[5],
			to_blng_grp				[5],
			fr_revenu_cust			[9],
			to_revenu_cust			[9],
			nd_episode_type			[2],
			nd_brk_episode_type		[2],
			d_physician_id			[16],
			d_short_name			[16],
			d_process_mth_year		[10],
			d_revenue_category		[11],
			d_revenue_cate_desc		[16],
			temp_revenue_category   [11],
			temp_process_mth_year   [10],
			temp_physician_id		[16],
			d_sort_order_mth_yr_phy [25],
		    d_episode_type			[12],
			nd_repeat_grp			[2],
			nd_percent_col          [2],
			nd_percent_col_desc     [4],
			 l_translated_value		[201],	
			 l_pk_value				[100],
			 P_LANGUAGE_ID [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[20]; } uid_pwd;

struct { unsigned short len; unsigned char arr[3]; } lv_facility_id;

struct { unsigned short len; unsigned char arr[16]; } fr_doctor;

struct { unsigned short len; unsigned char arr[16]; } to_doctor;

struct { unsigned short len; unsigned char arr[8]; } fr_period;

struct { unsigned short len; unsigned char arr[8]; } to_period;

struct { unsigned short len; unsigned char arr[11]; } fr_revenu_cat;

struct { unsigned short len; unsigned char arr[11]; } to_revenu_cat;

struct { unsigned short len; unsigned char arr[5]; } fr_blng_grp;

struct { unsigned short len; unsigned char arr[5]; } to_blng_grp;

struct { unsigned short len; unsigned char arr[9]; } fr_revenu_cust;

struct { unsigned short len; unsigned char arr[9]; } to_revenu_cust;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[2]; } nd_brk_episode_type;

struct { unsigned short len; unsigned char arr[16]; } d_physician_id;

struct { unsigned short len; unsigned char arr[16]; } d_short_name;

struct { unsigned short len; unsigned char arr[10]; } d_process_mth_year;

struct { unsigned short len; unsigned char arr[11]; } d_revenue_category;

struct { unsigned short len; unsigned char arr[16]; } d_revenue_cate_desc;

struct { unsigned short len; unsigned char arr[11]; } temp_revenue_category;

struct { unsigned short len; unsigned char arr[10]; } temp_process_mth_year;

struct { unsigned short len; unsigned char arr[16]; } temp_physician_id;

struct { unsigned short len; unsigned char arr[25]; } d_sort_order_mth_yr_phy;

struct { unsigned short len; unsigned char arr[12]; } d_episode_type;

struct { unsigned short len; unsigned char arr[2]; } nd_repeat_grp;

struct { unsigned short len; unsigned char arr[2]; } nd_percent_col;

struct { unsigned short len; unsigned char arr[4]; } nd_percent_col_desc;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[3]; } P_LANGUAGE_ID;


int d_qty ,d_process_mth , d_process_year,i;

double  d_hosp_reve, d_dr_reve ,
		sub_tot_category_hosp_reve , sub_tot_category_dr_reve ,	sub_tot_mth_yr_hosp_reve,
		sub_tot_mth_yr_dr_reve ,doct_tot_hosp_reve, doct_tot_dr_reve, grand_tot_hosp_reve,
		grand_tot_dr_reve, dr_rev_perc ;
 
int first = 0;
							             
		
int rep_len=0;
                       	
char filename[150];
char string_var[200];
char  loc_legend[999][201];
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
	 fprintf(fp,"%c(s14H",ESC); 	/* To set the font 	*/

	 if(strcmp(nd_percent_col.arr,"Y")==0)
	    rep_len=142;
	 else
	    rep_len=124;
	
		fetch_legend_value();
    
	fetch_hosp_name();

	print_first_page();


    do_report();

	

	close_det_cur();

	/* EXEC SQL DELETE SY_PROG_PARAM
            WHERE PGM_ID   = 'DFR00003'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='DFR00003' and SE\
SSION_ID=:b0) and PGM_DATE=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )28;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )43;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
  sqlstm.sqlcmax = (unsigned int )100;
  sqlstm.sqlcmin = (unsigned int )2;
  sqlstm.sqlcincr = (unsigned int )1;
  sqlstm.sqlctimeout = (unsigned int )0;
  sqlstm.sqlcnowait = (unsigned int )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}

fetch_prog_param()
{
		fr_doctor.arr[0]			= '\0';	
		to_doctor.arr[0]			= '\0';
		fr_period.arr[0]			= '\0';
		to_period.arr[0]			= '\0';
		fr_revenu_cat.arr[0]		= '\0';
		to_revenu_cat.arr[0]		= '\0';
		fr_blng_grp.arr[0]			= '\0';
		to_blng_grp.arr[0]			= '\0';
		fr_revenu_cust.arr[0]		= '\0';
		to_revenu_cust.arr[0]		= '\0';	
		nd_episode_type.arr[0]		= '\0';
		nd_brk_episode_type.arr[0]	= '\0';
		nd_repeat_grp.arr[0]		= '\0';
		nd_percent_col.arr[0]      = '\0';
		


		fr_doctor.len					= 0 ;	
		to_doctor.len					= 0 ;
		fr_period.len					= 0 ;
		to_period.len					= 0 ;
		fr_revenu_cat.len				= 0 ;
		to_revenu_cat.len				= 0 ;
		fr_blng_grp.len					= 0 ;
		to_blng_grp.len					= 0 ;
		fr_revenu_cust.len				= 0 ;
		to_revenu_cust.len				= 0 ;	
		nd_episode_type.len				= 0 ;
		nd_brk_episode_type.len			= 0 ;
		nd_repeat_grp.len				= 0 ;
		nd_percent_col.len              = 0 ;

		



    /* EXEC SQL SELECT PARAM1,
					PARAM2,
					PARAM3,
					PARAM4,
					PARAM5,
				    PARAM6,
					PARAM7,
					PARAM8,
					PARAM9,
					PARAM10,
					PARAM11,
					PARAM12,
					PARAM13,
					PARAM14
              INTO	:fr_doctor,	
					:to_doctor,
					:fr_period,
					:to_period,
					:fr_revenu_cat,
					:to_revenu_cat,
					:fr_blng_grp,
					:to_blng_grp,
					:fr_revenu_cust,
					:to_revenu_cust	,
					:nd_episode_type,
					:nd_brk_episode_type,
					:nd_repeat_grp,
					:nd_percent_col
            FROM SY_PROG_PARAM
            WHERE PGM_ID   = 'DFR00003'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PA\
RAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 into :b0,:b1\
,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13  from SY_PROG_PARAM where\
 ((PGM_ID='DFR00003' and SESSION_ID=:b14) and PGM_DATE=:b15)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )74;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&fr_doctor;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&to_doctor;
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
    sqlstm.sqhstv[6] = (         void  *)&fr_blng_grp;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&to_blng_grp;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&fr_revenu_cust;
    sqlstm.sqhstl[8] = (unsigned int  )11;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&to_revenu_cust;
    sqlstm.sqhstl[9] = (unsigned int  )11;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[10] = (unsigned int  )4;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_brk_episode_type;
    sqlstm.sqhstl[11] = (unsigned int  )4;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_repeat_grp;
    sqlstm.sqhstl[12] = (unsigned int  )4;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_percent_col;
    sqlstm.sqhstl[13] = (unsigned int  )4;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[14] = (unsigned int  )18;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[15] = (unsigned int  )27;
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



   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");
	
			
			fr_doctor.arr[fr_doctor.len] = '\0' ;	
			to_doctor.arr[to_doctor.len] = '\0';
			fr_period.arr[fr_period.len] = '\0';
			to_period.arr[to_period.len] = '\0';
			fr_revenu_cat.arr[fr_revenu_cat.len] = '\0';
			to_revenu_cat.arr[to_revenu_cat.len] = '\0';
			fr_blng_grp.arr[fr_blng_grp.len] = '\0';
			to_blng_grp.arr[to_blng_grp.len] = '\0';
			fr_revenu_cust.arr[fr_revenu_cust.len] = '\0';
			to_revenu_cust.arr[to_revenu_cust.len] = '\0';	
			nd_episode_type.arr[nd_episode_type.len] = '\0' ;
			nd_brk_episode_type.arr[nd_brk_episode_type.len] ='\0';
			nd_repeat_grp.arr[nd_repeat_grp.len] = '\0';
			nd_percent_col.arr[nd_percent_col.len] = '\0';

			


}
		
declare_cursor()
{

   /* EXEC SQL DECLARE DF_SUMM_CUR CURSOR FOR
   SELECT A.PHYSICIAN_ID, 
          B.SHORT_NAME,
		   A.REVENUE_CATEGORY, 
		  C.SHORT_DESC REV_CATG_DESC,
          DECODE(:nd_brk_episode_type, 'Y', DECODE(A.EPISODE_TYPE , 'I' , 'Inpatient' , 'D' , 'Daycare' , 'O' , 'Outpatient' , 'E' , 'Emergency' , 'R' , 'External' ), DECODE(:nd_episode_type , 'I' , 'Inpatient' , 'D' , 'Daycare' , 'O' , 'Outpatient' , 'E' , 'Emergency' , 'R' , 'External' , 'A' , '    All')) EPISODE_TYPE , 
          SUM( NVL(A.SERV_QTY,0)) QTY, 
          SUM(NVL(A.NET_REVENUE_AMT,0)) HOSP_REV, 
          SUM(NVL(A.DR_REVENUE_AMT,0)) DR_REV
FROM   df_rev_folio_slmt_vw A, SY_PHYSICIAN_MAST B,
       DF_REVENUE_CATEGORY C
WHERE  A.OPERATING_FACILITY_ID = B.FACILITY_ID
AND    A.PHYSICIAN_ID = B.PHYSICIAN_ID
AND    A.REVENUE_CATEGORY = C.REVENUE_CATEGORY
AND    A.PHYSICIAN_ID BETWEEN NVL(:fr_doctor, '!!!!!!!!!!!!!!!') 
                      AND NVL(:to_doctor, '~~~~~~~~~~~~~~~')
AND    TO_DATE(A.PROCESSING_MONTH||'/'||A.PROCESSING_YEAR , 'MM/YYYY') BETWEEN to_date(:fr_period , 'MM/YYYY') AND TO_DATE(:to_period , 'MM/YYYY')
AND    A.REVENUE_CATEGORY BETWEEN NVL(:fr_revenu_cat, '!!!!!!!!!!') AND NVL(:to_revenu_cat, '~~~~~~~~~~')
AND    A.BLNG_GRP_ID BETWEEN NVL(:fr_blng_grp, '!!') AND NVL(:to_blng_grp, '~~')
AND    NVL(A.REVENUE_CUST_CODE, '!!!!!!!!') BETWEEN NVL(:fr_revenu_cust, '!!!!!!!!') 
                                            AND NVL(:to_revenu_cust, '~~~~~~~~')
AND    A.EPISODE_TYPE = DECODE(:nd_episode_type, 'A', A.EPISODE_TYPE, :nd_episode_type)
--AND    NVL(A.DF_TRX_STATUS, 'N') != 'C'
GROUP BY A.PHYSICIAN_ID, 
         B.SHORT_NAME,
		 A.REVENUE_CATEGORY, 
		 C.SHORT_DESC, 
         DECODE(:nd_brk_episode_type, 'Y', DECODE(A.EPISODE_TYPE , 'I' , 'Inpatient' , 'D' , 'Daycare' , 'O' , 'Outpatient' , 'E' , 'Emergency' , 'R' , 'External' ), DECODE(:nd_episode_type , 'I' , 'Inpatient' , 'D' , 'Daycare' , 'O' , 'Outpatient' , 'E' , 'Emergency' , 'R' , 'External' , 'A' , '    All')) 
         ORDER BY   1 ; */ 

     
	if(OERROR)
		err_mesg("DECLARE failed on cursor DF_SUMM_CUR",0,""); 


 
	
}


open_det_cur()
{
	/* EXEC SQL OPEN DF_SUMM_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select A.PHYSICIAN_ID ,B.SHORT_NAME ,A.REVENUE_CATEGORY ,C.SHORT_DESC RE\
V_CATG_DESC ,DECODE(:b0,'Y',DECODE(A.EPISODE_TYPE,'I','Inpatient','D','Dayca\
re','O','Outpatient','E','Emergency','R','External'),DECODE(:b1,'I','Inpatie\
nt','D','Daycare','O','Outpatient','E','Emergency','R','External','A','    A\
ll')) EPISODE_TYPE ,sum(NVL(A.SERV_QTY,0)) QTY ,sum(NVL(A.NET_REVENUE_AMT,0)\
) HOSP_REV ,sum(NVL(A.DR_REVENUE_AMT,0)) DR_REV  from df_rev_folio_slmt_vw A\
 ,SY_PHYSICIAN_MAST B ,DF_REVENUE_CATEGORY C where ((((((((A.OPERATING_FACIL\
ITY_ID=B.FACILITY_ID and A.PHYSICIAN_ID=B.PHYSICIAN_ID) and A.REVENUE_CATEGO\
RY=C.REVENUE_CATEGORY) and A.PHYSICIAN_ID between NVL(:b2,'!!!!!!!!!!!!!!!')\
 and NVL(:b3,'~~~~~~~~~~~~~~~')) and TO_DATE(((A.PROCESSING_MONTH||'/')||A.P\
ROCESSING_YEAR),'MM/YYYY') between to_date(:b4,'MM/YYYY') and TO_DATE(:b5,'M\
M/YYYY')) and A.REVENUE_CATEGORY between NVL(:b6,'!!!!!!!!!!') and NVL(:b7,'\
~~~~~~~~~~')) and A.BLNG_GRP_ID between NVL(:b8,'!!') and NVL(:b9,'~~')) and\
 NVL(A.REVENUE_CUST_CODE,'!!!!!!!!') bet");
 sqlstm.stmt = sq0005;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )153;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_brk_episode_type;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[1] = (unsigned int  )4;
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
 sqlstm.sqhstv[3] = (         void  *)&to_doctor;
 sqlstm.sqhstl[3] = (unsigned int  )18;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&fr_period;
 sqlstm.sqhstl[4] = (unsigned int  )10;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&to_period;
 sqlstm.sqhstl[5] = (unsigned int  )10;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&fr_revenu_cat;
 sqlstm.sqhstl[6] = (unsigned int  )13;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&to_revenu_cat;
 sqlstm.sqhstl[7] = (unsigned int  )13;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&fr_blng_grp;
 sqlstm.sqhstl[8] = (unsigned int  )7;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&to_blng_grp;
 sqlstm.sqhstl[9] = (unsigned int  )7;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&fr_revenu_cust;
 sqlstm.sqhstl[10] = (unsigned int  )11;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&to_revenu_cust;
 sqlstm.sqhstl[11] = (unsigned int  )11;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[12] = (unsigned int  )4;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[13] = (unsigned int  )4;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_brk_episode_type;
 sqlstm.sqhstl[14] = (unsigned int  )4;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[15] = (unsigned int  )4;
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



		if(OERROR)
			err_mesg("OPEN failed on cursor DF_SUMM_CUR",0,""); 


			
 
}


close_det_cur()
{

	/* EXEC SQL CLOSE DF_SUMM_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )232;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	 
    
}

  
fetch_df_summ_cur()
{

		d_physician_id.arr[0]		= '\0';
		d_short_name.arr[0]			= '\0';
		d_process_mth_year.arr[0]	= '\0';
		d_revenue_category.arr[0]	= '\0';
		d_revenue_cate_desc.arr[0]	= '\0';
		d_episode_type.arr[0]		= '\0';
		d_sort_order_mth_yr_phy.arr[0] = '\0';

		d_physician_id.len			= 0;
		d_short_name.len			= 0;
		d_process_mth_year.len		= 0;
		d_revenue_category.len		= 0;
		d_revenue_cate_desc.len		= 0;
		d_episode_type.len			= 0;
		d_sort_order_mth_yr_phy.len = 0;



		d_qty = 0; 
		d_hosp_reve = 0 ;
		d_dr_reve = 0;
		d_process_mth = 0;
		d_process_year = 0;





	/* EXEC SQL FETCH DF_SUMM_CUR
               INTO 
				:d_physician_id,
				:d_short_name,
				:d_revenue_category,
				:d_revenue_cate_desc,
				:d_episode_type,
				:d_qty,
				:d_hosp_reve,
				:d_dr_reve ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )247;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_physician_id;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_short_name;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_revenue_category;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_revenue_cate_desc;
 sqlstm.sqhstl[3] = (unsigned int  )18;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[4] = (unsigned int  )14;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_qty;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_hosp_reve;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_dr_reve;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
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
}




	if (OERROR)
            err_mesg("FETCH failed on cursor DF_SUMM_CUR",0,"");


	d_physician_id.arr[d_physician_id.len] = '\0';
	d_short_name.arr[d_short_name.len] = '\0';
	d_process_mth_year.arr[d_process_mth_year.len] = '\0' ;
	d_revenue_category.arr[d_revenue_category.len] = '\0' ;
	d_revenue_cate_desc.arr[d_revenue_cate_desc.len] = '\0';
	d_episode_type.arr[d_episode_type.len] = '\0' ;
	d_sort_order_mth_yr_phy.arr[d_sort_order_mth_yr_phy.len] = '\0' ;
	

  
	
	return(LAST_ROW?0:1);

  }




open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"DFR00003.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file DFR00003.lis");
       proc_exit();
    }
}



do_report()
{

print_head();


   
  if (strcmp(nd_brk_episode_type.arr, "Y") ==0)
       process_for_doctor();
  
  if (strcmp(nd_brk_episode_type.arr, "N") ==0)
	  process_for_doctor_no_brk();

   

  

  
}


process_for_doctor()
{

	first =0;
	while(fetch_df_summ_cur())
	{
	check_line(1);
		if ((strcmp(temp_revenue_category.arr,d_revenue_category.arr)!=0)    || (strcmp(temp_physician_id.arr,d_physician_id.arr)!=0))
		{
			if (first == 1) 
			{ 
				print_rev_sub_tot();
			} 
		}


		if(strcmp(temp_physician_id.arr,d_physician_id.arr)!=0) 
		{
			if (first == 1)
			{
				print_doc_sub_tot();

			}

			if (lctr >= MAX_LINES)
			{
				next_page();
				fprintf(fp,"%-15s %-15s ",d_physician_id.arr,d_short_name.arr); 

			}
			else
				fprintf(fp,"%-15s %-15s ",d_physician_id.arr,d_short_name.arr); 
		}
		else
		{
		  if(strcmp(nd_repeat_grp.arr,"Y")==0)
		   fprintf(fp,"%-15s %-15s ",d_physician_id.arr,d_short_name.arr); 
		   else
			fprintf(fp,"%-15s %-15s "," " , " ");
		}

		

		if ((strcmp(temp_revenue_category.arr,d_revenue_category.arr)!=0)    || (strcmp(temp_physician_id.arr,d_physician_id.arr)!=0))
		{
			if (lctr >= MAX_LINES)
			{
				next_page();
				fprintf(fp,"%-15s %-15s ",d_physician_id.arr,d_short_name.arr);
				fprintf(fp,"  %-10s %-15s ",  d_revenue_category.arr ,d_revenue_cate_desc.arr );
			}	
			else
				fprintf(fp,"  %-10s(%-15s)",  d_revenue_category.arr ,d_revenue_cate_desc.arr );

		}
		else
		{
		if(strcmp(nd_repeat_grp.arr,"Y")==0)
		   fprintf(fp,"  %-10s(%-15s)",  d_revenue_category.arr ,d_revenue_cate_desc.arr );
		else
			fprintf(fp,"  %-10s %-15s ",  " " ," " );
		}
		fprintf(fp ,"%-10s     %4d " , d_episode_type.arr , d_qty);

		
		fprintf(fp,"%10s"," ");
		print_formated(d_hosp_reve);
		fprintf(fp,"%2s"," ");
		print_formated(d_dr_reve);

        if(strcmp(nd_percent_col.arr,"Y")==0)	
         {
			if (d_hosp_reve != 0)
		    dr_rev_perc = (d_dr_reve /  d_hosp_reve) * 100;

		    fprintf(fp , "  ");
		    print_formated(dr_rev_perc);
          }


		fprintf(fp, "\n");
		lctr = lctr + 1 ;

		first=1;

		strcpy(temp_revenue_category.arr,d_revenue_category.arr);
		strcpy(temp_physician_id.arr,d_physician_id.arr);

		

		sub_tot_category_hosp_reve = sub_tot_category_hosp_reve + d_hosp_reve ;
		sub_tot_category_dr_reve   =  sub_tot_category_dr_reve + d_dr_reve;


		
		doct_tot_hosp_reve = doct_tot_hosp_reve + d_hosp_reve ;
		doct_tot_dr_reve =  doct_tot_dr_reve + d_dr_reve;

		grand_tot_hosp_reve = grand_tot_hosp_reve + d_hosp_reve ;
		grand_tot_dr_reve   =  grand_tot_dr_reve + d_dr_reve;


	}

	 
	print_rev_sub_tot();
	print_doc_sub_tot();
	grant_tot();


	end_of_rep();

}

process_for_doctor_no_brk()
{

	first =0;
	while(fetch_df_summ_cur())
	{
		 
check_line(1);

		if(strcmp(temp_physician_id.arr,d_physician_id.arr)!=0) 
		{
			if (first == 1)
			{
				print_doc_sub_tot();

			}

			if (lctr >= MAX_LINES)
			{
				next_page();
				fprintf(fp,"%-15s %-15s ",d_physician_id.arr,d_short_name.arr); 

			}
			else
				fprintf(fp,"%-15s %-15s ",d_physician_id.arr,d_short_name.arr); 
		}
		else
		{
		if(strcmp(nd_repeat_grp.arr,"Y")==0)
		   fprintf(fp,"%-15s %-15s ",d_physician_id.arr,d_short_name.arr); 
         else
			fprintf(fp,"%-15s %-15s "," " , " ");
		}

		

	

		fprintf(fp,"  %-10s(%-15s)",  d_revenue_category.arr ,d_revenue_cate_desc.arr );
		fprintf(fp ,"%-10s     %4d " , d_episode_type.arr , d_qty);

        fprintf(fp,"%10s"," ");
		print_formated(d_hosp_reve);
		fprintf(fp,"%2s"," ");
		print_formated(d_dr_reve);

        if(strcmp(nd_percent_col.arr,"Y")==0)	
         {
			if (d_hosp_reve != 0)
				dr_rev_perc = (d_dr_reve /  d_hosp_reve) * 100;

		    fprintf(fp , "  ");
		    print_formated(dr_rev_perc);
          }


		fprintf(fp, "\n");
		lctr = lctr + 1 ;

		first=1;

		strcpy(temp_revenue_category.arr,d_revenue_category.arr);
		strcpy(temp_physician_id.arr,d_physician_id.arr);

		

		sub_tot_category_hosp_reve = sub_tot_category_hosp_reve + d_hosp_reve ;
		sub_tot_category_dr_reve   =  sub_tot_category_dr_reve + d_dr_reve;


		
		doct_tot_hosp_reve = doct_tot_hosp_reve + d_hosp_reve ;
		doct_tot_dr_reve =  doct_tot_dr_reve + d_dr_reve;

		grand_tot_hosp_reve = grand_tot_hosp_reve + d_hosp_reve ;
		grand_tot_dr_reve   =  grand_tot_dr_reve + d_dr_reve;


	}

	 
	
	print_doc_sub_tot();
	grant_tot();


	end_of_rep();

}




 
print_rev_sub_tot() 
{
    check_line(3);
    horz_skip(61) ;
	if(strcmp(nd_percent_col.arr,"Y")==0)
	   print_line('-',81);
    else
	   print_line('-',63); 

    fprintf(fp, "\n");


    fprintf(fp , "%46s %-16s %-10s - %-5s" , " " ,loc_legend[34],temp_revenue_category.arr,loc_legend[20]) ;

	//fprintf(fp , "%46s Revenue Category %-10s - Total" , " " ,temp_revenue_category.arr) ;

    fprintf(fp , "         ");
	print_formated(sub_tot_category_hosp_reve);
	fprintf(fp , "%2s" , " ");
	print_formated(sub_tot_category_dr_reve);
    fprintf(fp, "\n");
	
    sub_tot_category_hosp_reve = 0;
	sub_tot_category_dr_reve = 0;

	horz_skip(61) ;
	if(strcmp(nd_percent_col.arr,"Y")==0)
	   print_line('-',81);
    else
	   print_line('-',63); 

    fprintf(fp, "\n");

	lctr = lctr + 3;
}



print_doc_sub_tot()
{
check_line(3);
   if (strcmp(nd_brk_episode_type.arr, "N") ==0) 
   {
		horz_skip(61) ;
		if(strcmp(nd_percent_col.arr,"Y")==0)
		   print_line('-',81);
		else
			print_line('-',63); 

		fprintf(fp, "\n");
		lctr = lctr+1;
    

   }


    fprintf(fp , "%40s %-16s %-15s - %-6s" , " " ,loc_legend[36],temp_physician_id.arr,loc_legend[20]) ;

	//fprintf(fp , "%40s Doctor           %-15s -  Total" , " " ,temp_physician_id.arr) ;
	fprintf(fp , "%9s" , " " );
	print_formated(doct_tot_hosp_reve);
	fprintf(fp , "%2s" , " " );
	print_formated(doct_tot_dr_reve);
    fprintf(fp, "\n");
	
	horz_skip(61) ;
	if(strcmp(nd_percent_col.arr,"Y")==0)
	   print_line('=',81);
    else
	   print_line('=',63); 


    fprintf(fp, "\n");
    doct_tot_hosp_reve = 0;
    doct_tot_dr_reve = 0;

	lctr = lctr+2;

}
grant_tot()
{
check_line(3);
	//fprintf(fp , "%33s Grand Total                     " , " ");
	  fprintf(fp , "%33s %-32s" , " ",loc_legend[25]);
	fprintf(fp , "%25s" , " ");
	print_formated(grand_tot_hosp_reve);
	fprintf(fp , "%2s" , " ");
	print_formated(grand_tot_dr_reve);
    fprintf(fp, "\n");
	
	print_line('-',rep_len);
    fprintf(fp, "\n");
	grand_tot_hosp_reve = 0;
	grand_tot_dr_reve = 0 ;
}


print_first_page()
{

int hosp_nm_len, rep_title_len = 10, s1,date_len,pgm_len;

lctr=0;

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
 
   	fprintf(fp,"%-4s: %s",loc_legend[3],"DFR00003");
 
	rep_title_len = 58;
	s1 = (rep_len-rep_title_len)/2;
	horz_skip(s1-7);
      

  fprintf(fp,"%s-%-s",loc_legend[6],loc_legend[7]);

	//fprintf(fp,"%s","Doctor Share by Revenue Category - Consolidated");
	
	 

    s1 = (rep_len-s1-58);
	horz_skip(s1-18);

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



if (strcmp(fr_doctor.arr, "!!!!!!!!!!!!!!!")  == 0)
fprintf(fp,"%24s  %-7s  : %s",loc_legend[11],loc_legend[26],loc_legend[9]);
else
fprintf(fp,"%24s  %-7s  : %s",loc_legend[11],loc_legend[26],fr_doctor.arr);

fprintf(fp, "\n");
fprintf(fp, "\n");

if (strcmp(to_doctor.arr, "~~~~~~~~~~~~~~~")  == 0)
fprintf(fp,"%24s  %-7s  : %s",loc_legend[11],loc_legend[27],loc_legend[10]);
else
fprintf(fp,"%24s  %-7s  : %s",loc_legend[11],loc_legend[27],to_doctor.arr);

fprintf(fp, "\n");
fprintf(fp, "\n");

fprintf(fp,"%24s  %-7s  : %s",loc_legend[12],loc_legend[26],fr_period.arr);
fprintf(fp, "\n");
fprintf(fp, "\n");

fprintf(fp,"%24s  %-7s  : %s",loc_legend[12],loc_legend[27],to_period.arr);
fprintf(fp, "\n");
fprintf(fp, "\n");

if (strcmp(fr_revenu_cat.arr, "!!!!!!!!!!")  == 0)
fprintf(fp,"%24s  %-7s  : %s",loc_legend[13],loc_legend[26],loc_legend[9]);
else
fprintf(fp,"%24s  %-7s  : %s",loc_legend[13],loc_legend[26],fr_revenu_cat.arr);

fprintf(fp, "\n");
fprintf(fp, "\n");

if (strcmp(to_revenu_cat.arr, "~~~~~~~~~~")  == 0)
fprintf(fp,"%24s  %-7s  : %s",loc_legend[13],loc_legend[27],loc_legend[10]);
else
fprintf(fp,"%24s  %-7s  : %s",loc_legend[13],loc_legend[27],to_revenu_cat.arr);

fprintf(fp, "\n");
fprintf(fp, "\n");

if (strcmp(fr_blng_grp.arr, "!!")  == 0)
fprintf(fp,"%24s  %-7s  : %s",loc_legend[14],loc_legend[26],loc_legend[9]);
else
fprintf(fp,"%24s  %-7s  : %s",loc_legend[14],loc_legend[26],fr_blng_grp.arr);

fprintf(fp, "\n");
fprintf(fp, "\n");

if (strcmp(to_blng_grp.arr, "~~")  == 0)
fprintf(fp,"%24s  %-7s  : %s",loc_legend[14],loc_legend[27],loc_legend[10]);
else
fprintf(fp,"%24s  %-7s  : %s",loc_legend[14],loc_legend[27],to_blng_grp.arr);


fprintf(fp, "\n");
fprintf(fp, "\n");

if (strcmp(fr_revenu_cust.arr, "!!!!!!!!")  == 0)
fprintf(fp,"%24s  %-7s  : %s",loc_legend[15],loc_legend[26],loc_legend[9]);
else
fprintf(fp,"%24s  %-7s  : %s",loc_legend[15],loc_legend[26],fr_revenu_cust.arr);

fprintf(fp, "\n");
fprintf(fp, "\n");

if (strcmp(to_revenu_cust.arr, "~~~~~~~~")  == 0)
fprintf(fp,"%24s  %-7s  : %s",loc_legend[15],loc_legend[27],loc_legend[10]);
else
fprintf(fp,"%24s  %-7s  : %s",loc_legend[15],loc_legend[27],to_revenu_cust.arr);

fprintf(fp, "\n");
fprintf(fp, "\n");


if (strcmp(nd_episode_type.arr,"E")==0)
fprintf(fp,"%33s  : %-s",loc_legend[16],loc_legend[31]);

if (strcmp(nd_episode_type.arr,"O")==0)
fprintf(fp,"%33s  : %-s",loc_legend[16],loc_legend[30]);

if (strcmp(nd_episode_type.arr,"I")==0)
fprintf(fp,"%33s  : %-s",loc_legend[16],loc_legend[28]);

if (strcmp(nd_episode_type.arr,"R")==0)
fprintf(fp,"%33s  : %-s",loc_legend[16],loc_legend[32]);

if (strcmp(nd_episode_type.arr,"D")==0)
fprintf(fp,"%33s  : %-s",loc_legend[16],loc_legend[29]);

if (strcmp(nd_episode_type.arr,"A")==0)
fprintf(fp,"%33s  : %-s",loc_legend[16],loc_legend[33]);


fprintf(fp, "\n");
fprintf(fp, "\n");

if (strcmp(nd_brk_episode_type.arr,"Y")==0)
fprintf(fp,"%19s %-s"," ",loc_legend[17]);

fprintf(fp, "\n");
fprintf(fp, "\n");

if (strcmp(nd_percent_col.arr,"Y")==0)
   strcpy(nd_percent_col_desc.arr,"YES");
else
   strcpy(nd_percent_col_desc.arr , "NO");   
  
fprintf(fp,"%33s  : %-s",loc_legend[38],nd_percent_col_desc.arr);



fprintf(fp, "\n");
fprintf(fp, "\n");



fprintf(fp,"\n\f");

}




print_head()
{
int hosp_nm_len, rep_title_len = 10, s1,date_len,pgm_len;

    lctr=0;

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


 
 	fprintf(fp,"%-4s: %s",loc_legend[3],"DFR00003");

 
	rep_title_len = 58;
	s1 = (rep_len-rep_title_len)/2;
	horz_skip(s1-7);
      
	  fprintf(fp,"%s-%-s",loc_legend[6],loc_legend[7]);

	
	  

    s1 = (rep_len-s1-58);
	horz_skip(s1-18);

		fprintf(fp,"%-s: %4d",loc_legend[5],++pctr);

  fprintf(fp, "\n");

print_line('-',rep_len);
fprintf(fp, "\n");

if(strcmp(nd_percent_col.arr,"Y")==0)	
	fprintf(fp , "%-33s %-26s %-13s %8s %22s %17s %17s",loc_legend[36],loc_legend[34],loc_legend[35],loc_legend[21],loc_legend[22],loc_legend[23],loc_legend[37]);
else
    fprintf(fp , "%-33s %-26s %-13s %8s %22s %17s",loc_legend[36],loc_legend[34],loc_legend[35],loc_legend[21],loc_legend[22],loc_legend[23]); 

//fprintf(fp , "Doctor                            Revenue Category           Episode Type    Qty      Hospital Revenue Amt  Doctor Share Amt");
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
             FROM SY_ACC_ENTITY_lang_vw
			 WHERE acc_entity_id=:lv_facility_id
			 AND LANGUAGE_ID =:P_LANGUAGE_ID; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (acc_entity_id=:\
b3 and LANGUAGE_ID=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )294;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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
        sprintf(str_amt,"%14s ",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%14s ",str_amt);
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

		/* EXEC SQL SELECT LTRIM(RTRIM('DFR00003.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('DFR00003.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )329;
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :lv_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :P_LANGUAGE_ID ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )352;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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