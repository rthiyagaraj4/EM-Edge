
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
           char  filnam[54];
};
static const struct sqlcxp sqlfpn =
{
    53,
    "D:\\Issues\\Facility name chgs\\rep\\BLRACTBG\\BLRACTBG.PC"
};


static unsigned long sqlctx = 1670560333;


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
            void  *sqhstv[18];
   unsigned int   sqhstl[18];
            int   sqhsts[18];
            void  *sqindv[18];
            int   sqinds[18];
   unsigned int   sqharm[18];
   unsigned int   *sqharc[18];
   unsigned short  sqadto[18];
   unsigned short  sqtdso[18];
} sqlstm = {10,18};

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

 static const char *sq0008 = 
"ty_id between :b8 and :b9) and a.cas\
h_counter_code between DECODE(:b10,'LOWEST','!!',:b10) and DECODE(:b12,'HIGHE\
ST','~~',:b12)) and b.blng_serv_code between DECODE(:b14,'LOWEST','!!',:b14) \
and DECODE(:b16,'HIGHEST','~~',:b16)) order by 1,2,3 )  group by facility_id,\
cash_cntr_code,blng_serv_desc           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,91,0,2,147,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,155,0,0,0,0,0,1,0,
43,0,0,3,0,0,27,163,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
74,0,0,4,331,0,4,185,0,0,16,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1,9,0,0,
153,0,0,5,165,0,4,235,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
188,0,0,6,138,0,4,253,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
219,0,0,7,184,0,4,272,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
246,0,0,8,1331,0,9,394,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
333,0,0,8,0,0,13,409,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,2,4,0,0,
384,0,0,8,0,0,15,425,0,0,0,0,0,1,0,
399,0,0,9,96,0,4,659,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
422,0,0,10,165,0,6,666,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
453,0,0,11,143,0,6,687,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 2.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRACTBG.PC                                  */
/* AUTHOR                : RAJANISH NAMBIAR                             */
/* DATE WRITTEN          : 22/4/2003                                    */
/* CALLED FROM           : BLRACTBG.fmb                                 */
/************************************************************************/

#include <stdio.h>   
#include <string.h>
#include <bl.h>  

#define OERROR			(sqlca.sqlcode < 0)
#define NODATA_FOUND	(sqlca.sqlcode == 1403)
#define NOT_FOUND		(sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY   (sqlca.sqlcode == -54)
#define DUPLICATE_KEY   (sqlca.sqlcode == -1)
#define ROW_COUNT       (sqlca.sqlerrd[2])
#define MAX_LINES		42
#define ESC				0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                   [120],
            date_time                   [20],
            user_id                     [91],
            nd_pwd                      [91],
            nd_session_id               [16],
            nd_pgm_date                 [25],
            d_curr_pgm_name             [15],
			nd_temp_date				[21],
			p_language_id				[3],
			date_convert				[21],
			nd_loc_date					[21],
			nd_facility_id              [3],
            
/o pp ---> values obtained from sy_prog_pram o/
			pp_fm_date					[12], 
			pp_to_date					[12],
			pp_fm_facility              [3],
			pp_to_facility              [3],
            pp_fm_cashcounter           [8],
            pp_to_cashcounter           [8],
			pp_fm_blng_srv				[11],
			pp_to_blng_srv				[11],
			pp_1_blng_grp				[8],
			pp_2_blng_grp				[8],
			pp_3_blng_grp				[8],
			pp_4_blng_grp				[8],
			pp_5_blng_grp				[8],
			pp_6_blng_grp				[8],

 /o cv ---> values obtained from cursor  o/
            cv_facility					[3],
			cv_cash_counter_code        [5],	
			cv_blng_grp                [11],
			cv_blng_serv_code		   [11],
			cv_service_desc			   [41], 
			cv_chk_val				    [3],
						
			cv_cash_cntr_name			[41],
			cv_facility_name			[41], //CHANGED FROM 31 TO 41
			l_pk_value					[100],
		    l_translated_value	        [201],
			prv_facility		         [3],
			prv_cash_counter_code	     [5]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[12]; } pp_fm_date;

struct { unsigned short len; unsigned char arr[12]; } pp_to_date;

struct { unsigned short len; unsigned char arr[3]; } pp_fm_facility;

struct { unsigned short len; unsigned char arr[3]; } pp_to_facility;

struct { unsigned short len; unsigned char arr[8]; } pp_fm_cashcounter;

struct { unsigned short len; unsigned char arr[8]; } pp_to_cashcounter;

struct { unsigned short len; unsigned char arr[11]; } pp_fm_blng_srv;

struct { unsigned short len; unsigned char arr[11]; } pp_to_blng_srv;

struct { unsigned short len; unsigned char arr[8]; } pp_1_blng_grp;

struct { unsigned short len; unsigned char arr[8]; } pp_2_blng_grp;

struct { unsigned short len; unsigned char arr[8]; } pp_3_blng_grp;

struct { unsigned short len; unsigned char arr[8]; } pp_4_blng_grp;

struct { unsigned short len; unsigned char arr[8]; } pp_5_blng_grp;

struct { unsigned short len; unsigned char arr[8]; } pp_6_blng_grp;

struct { unsigned short len; unsigned char arr[3]; } cv_facility;

struct { unsigned short len; unsigned char arr[5]; } cv_cash_counter_code;

struct { unsigned short len; unsigned char arr[11]; } cv_blng_grp;

struct { unsigned short len; unsigned char arr[11]; } cv_blng_serv_code;

struct { unsigned short len; unsigned char arr[41]; } cv_service_desc;

struct { unsigned short len; unsigned char arr[3]; } cv_chk_val;

struct { unsigned short len; unsigned char arr[41]; } cv_cash_cntr_name;

struct { unsigned short len; unsigned char arr[41]; } cv_facility_name;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } prv_facility;

struct { unsigned short len; unsigned char arr[5]; } prv_cash_counter_code;

			
     double cv_sum1	= 0, cv_sum2 = 0, cv_sum3 = 0, cv_sum4 = 0, 
			cv_sum5	= 0, cv_sum6 = 0, cv_sum7 = 0, cv_sum8 = 0,
			cc_sum1	= 0, cc_sum2 = 0, cc_sum3 = 0, cc_sum4 = 0, 
			cc_sum5	= 0, cc_sum6 = 0, cc_blsr_tot=0,
			fc_sum1	= 0, fc_sum2 = 0, fc_sum3 = 0, fc_sum4 = 0, 
			fc_sum5	= 0, fc_sum6 = 0, fc_blsr_tot=0,
			gr_sum1	= 0, gr_sum2 = 0, gr_sum3 = 0, gr_sum4 = 0, 
			gr_sum5	= 0, gr_sum6 = 0, gr_blsr_tot=0,
			blsr_total = 0;			

char filename[150];
char loc_legend[999][201];
char string_var[200];
char g_facility_id[3];
	int i;	

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

int i = 0, lctr = 0, pctr = 0, first = 1;

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
	
    strcpy(g_pgm_id,"BLRACTBG");
    strcpy(nd_pwd.arr,argv[1]);
	nd_pwd.len = strlen(nd_pwd.arr);
	
	conn_sql();
	 
	set_meduser_role(); 
	strcpy(p_language_id.arr,l_language_id.arr);
    p_language_id.len = l_language_id.len;

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

	strcpy(g_facility_id,argv[4]);
	strcpy(nd_facility_id.arr,argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);

	fetch_legend_value();
	fetch_hosp_name();

	fetch_prog_param();
   
    open_file();
	fprintf(fp,"%c&l1O",ESC); fprintf(fp,"%c&k2S",ESC);

	print_title();
	
	print_head();

	get_val(); 

	horz_skip(79); fprintf(fp,"*****   %-15s   *****",loc_legend[210]);
	fprintf(fp,"%c&l0O",ESC); fprintf(fp,"%cE",ESC); fflush(fp); fclose(fp);
	/* EXEC SQL DELETE FROM SY_PROG_PARAM
              WHERE PGM_ID     = 'BLRACTBG'
                AND SESSION_ID = :nd_session_id
                AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRACTBG' and S\
ESSION_ID=:b0) and PGM_DATE=:b1)";
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


	return;
}

/*	****************************	Sub Programs	****************************	*/

conn_sql()
{
	/* EXEC sql connect :nd_pwd; */ 

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
 sqlstm.sqhstv[0] = (         void  *)&nd_pwd;
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


	  if (sqlca.sqlcode < 0 )
	   {
        disp_message(ORA_MESG,"Error in connecting to Oracle");
        proc_exit();
       }
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLRACTBG.lis");
	if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLRACTBG.lis"); proc_exit();
    }
}

fetch_prog_param()
{


	/* EXEC SQL SELECT PARAM1, 
	                         PARAM2, 
				 PARAM3, 
				 PARAM4,
                                 NVL(PARAM5,'LOWEST'),
				 NVL(PARAM6,'HIGHEST'),
				 NVL(PARAM7,'LOWEST'),
				 NVL(PARAM8,'HIGHEST'),
				 PARAM9, 
				 PARAM10, 
				 PARAM11, 
				 PARAM12, 
				 PARAM13, 
				 PARAM14
               INTO	         :pp_fm_date,
	                         :pp_to_date,
				 :pp_fm_facility,
				 :pp_to_facility,
				 :pp_fm_cashcounter,
				 :pp_to_cashcounter,
				 :pp_fm_blng_srv,
				 :pp_to_blng_srv,
				 :pp_1_blng_grp,
				 :pp_2_blng_grp, 
				 :pp_3_blng_grp,
				 :pp_4_blng_grp, 
				 :pp_5_blng_grp, 
				 :pp_6_blng_grp
			   FROM SY_PROG_PARAM
              WHERE PGM_ID     = 'BLRACTBG' 
			    AND SESSION_ID = :nd_session_id 
                AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,NVL(PARAM5,'LOWEST')\
 ,NVL(PARAM6,'HIGHEST') ,NVL(PARAM7,'LOWEST') ,NVL(PARAM8,'HIGHEST') ,PARAM9 \
,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 into :b0,:b1,:b2,:b3,:b4,:b5,:b6\
,:b7,:b8,:b9,:b10,:b11,:b12,:b13  from SY_PROG_PARAM where ((PGM_ID='BLRACTBG\
' and SESSION_ID=:b14) and PGM_DATE=:b15)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )74;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&pp_fm_date;
 sqlstm.sqhstl[0] = (unsigned int  )14;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&pp_to_date;
 sqlstm.sqhstl[1] = (unsigned int  )14;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&pp_fm_facility;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&pp_to_facility;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&pp_fm_cashcounter;
 sqlstm.sqhstl[4] = (unsigned int  )10;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&pp_to_cashcounter;
 sqlstm.sqhstl[5] = (unsigned int  )10;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&pp_fm_blng_srv;
 sqlstm.sqhstl[6] = (unsigned int  )13;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&pp_to_blng_srv;
 sqlstm.sqhstl[7] = (unsigned int  )13;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&pp_1_blng_grp;
 sqlstm.sqhstl[8] = (unsigned int  )10;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&pp_2_blng_grp;
 sqlstm.sqhstl[9] = (unsigned int  )10;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&pp_3_blng_grp;
 sqlstm.sqhstl[10] = (unsigned int  )10;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&pp_4_blng_grp;
 sqlstm.sqhstl[11] = (unsigned int  )10;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&pp_5_blng_grp;
 sqlstm.sqhstl[12] = (unsigned int  )10;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&pp_6_blng_grp;
 sqlstm.sqhstl[13] = (unsigned int  )10;
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

	if (NODATA_FOUND)
	    err_mesg("No Record found in SY_PROG_PARAM",0,"");
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT UPPER(ACC_ENTITY_NAME), TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY_lang_vw
			  WHERE ACC_ENTITY_ID = :nd_facility_id
			  AND		language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select UPPER(ACC_ENTITY_NAME) ,TO_CHAR(SYSDATE,'DD/MM/YY\
YY HH24:MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_EN\
TITY_ID=:b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )153;
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
    sqlstm.sqhstl[2] = (unsigned int  )93;
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
    sqlstm.sqhstv[4] = (         void  *)&p_language_id;
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

get_cash_cntr_name()
{
   cv_cash_cntr_name.arr[0]	= '\0';
    cv_cash_cntr_name.len		= 0;

	/* EXEC SQL 
	SELECT SHORT_DESC
	  INTO :cv_cash_cntr_name
	  FROM BL_CASH_COUNTER_LANG_VW
	 WHERE CASH_COUNTER_CODE = :cv_cash_counter_code
	   AND OPERATING_FACILITY_ID = :cv_facility
	   and language_id=:p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_DESC into :b0  from BL_CASH_COUNTER_LANG_VW wh\
ere ((CASH_COUNTER_CODE=:b1 and OPERATING_FACILITY_ID=:b2) and language_id=:b\
3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )188;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cv_cash_cntr_name;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&cv_cash_counter_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&cv_facility;
 sqlstm.sqhstl[2] = (unsigned int  )5;
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



    if(OERROR)
        err_mesg("SELECTION failed on table BL_CASH_COUNTER",0,"");
	  
	cv_cash_cntr_name.arr[cv_cash_cntr_name.len]  = '\0';
}

get_facility_name()
{
	cv_facility_name.arr[0]		= '\0';
    cv_facility_name.len		= 0;

	/* EXEC SQL 
	SELECT a.acc_entity_name name
        INTO     cv_facility_name
	FROM   SY_ACC_ENTITY_lang_vw a, SY_USER b
	WHERE b.facility_id   = a.acc_entity_id
	AND     b.user_id  = USER
	AND     a.acc_entity_id = :pp_fm_facility
	AND		language_id=:p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select a.acc_entity_name name into :b0  from SY_ACC_ENTITY_\
lang_vw a ,SY_USER b where (((b.facility_id=a.acc_entity_id and b.user_id=USE\
R) and a.acc_entity_id=:b1) and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )219;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cv_facility_name;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&pp_fm_facility;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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


	
	if(OERROR)
        err_mesg("SELECTION failed on table SY_ACC_ENTITY & SY_USER",0,"");
	  
	cv_facility_name.arr[cv_facility_name.len]  = '\0';
}

print_title()
{
	common_head();
	fprintf(fp,"VER : 2.10.01"); next_line();;
	next_line();; next_line();; next_line();; horz_skip(35); 
	fprintf(fp,"%-15s :",loc_legend[80]); 
	next_line();; horz_skip(35); 
	fprintf(fp,"----------------"); 
	next_line();; next_line();; horz_skip(50);
	init_date_temp_var();                              
    strcpy(date_convert.arr,pp_fm_date.arr);            
	fun_change_loc_date();
	fprintf(fp,"%-15.15s   %-5.5s: %-10.10s",loc_legend[90],loc_legend[100],date_convert.arr);
 	next_line();; horz_skip(50);
	init_date_temp_var();                              
    strcpy(date_convert.arr,pp_to_date.arr);            
	fun_change_loc_date();
	fprintf(fp,"                    %-3.3s: %-10.10s",loc_legend[110],date_convert.arr);
	next_line();; next_line();; horz_skip(50);
	fprintf(fp,"%-15.15s   %-5.5s: %-8.8s",loc_legend[120],loc_legend[100],pp_fm_facility.arr);
 	next_line();; horz_skip(50);
	fprintf(fp,"                    %-3.3s: %-8.8s",loc_legend[110],pp_to_facility.arr);
	next_line();; next_line();; horz_skip(50);
	fprintf(fp,"%-15.15s   %-5.5s: %-8.8s",loc_legend[130],loc_legend[100],pp_fm_cashcounter.arr);
	next_line();; horz_skip(50);
	fprintf(fp,"                    %-3.3s: %-8.8s",loc_legend[110],pp_to_cashcounter.arr);
	next_line();; next_line();; horz_skip(50);
	fprintf(fp,"%-15.15s   %-5.5s: %-10.10s",loc_legend[140],loc_legend[100],pp_fm_blng_srv.arr);
 	next_line();; horz_skip(50);
	fprintf(fp,"                    %-3.3s: %-10.10s",loc_legend[110],pp_to_blng_srv.arr);
	next_line();; next_line();; horz_skip(50);
	fprintf(fp,"%-15.15s        : ",loc_legend[150]);
 	fprintf(fp,"%-4.4s",pp_1_blng_grp.arr); horz_skip(2);
	fprintf(fp,"%-4.4s",pp_2_blng_grp.arr); horz_skip(2);
	fprintf(fp,"%-4.4s",pp_3_blng_grp.arr); horz_skip(2);
	fprintf(fp,"%-4.4s",pp_4_blng_grp.arr); horz_skip(2);
	fprintf(fp,"%-4.4s",pp_5_blng_grp.arr); horz_skip(2);
	fprintf(fp,"%-4.4s",pp_6_blng_grp.arr);
	next_line();; fprintf(fp,"\f");
}

print_head()
{
	common_head(); 
	fprintf(fp,"%-16.16s",loc_legend[140]); horz_skip(7);
	fprintf(fp,"%16.16s",pp_1_blng_grp.arr); horz_skip(9);
	fprintf(fp,"%16.16s",pp_2_blng_grp.arr); horz_skip(9);
	fprintf(fp,"%16.16s",pp_3_blng_grp.arr); horz_skip(9);
	fprintf(fp,"%16.16s",pp_4_blng_grp.arr); horz_skip(9);
	fprintf(fp,"%16.16s",pp_5_blng_grp.arr); horz_skip(9);
	fprintf(fp,"%16.16s",pp_6_blng_grp.arr); horz_skip(9);
	fprintf(fp,"%16.16s",loc_legend[160]); next_line();;dash_line(); 
}

common_head()
{
	lctr =1; fprintf(fp,"\n");fprintf(fp,"%-3.3s : %-2s",loc_legend[10],loc_legend[20]); horz_skip(73);
	//fprintf(fp,"%-30.30s",hosp_name.arr); horz_skip(61);
	fprintf(fp,"%-30s",hosp_name.arr); horz_skip(61);
	init_date_temp_var();                              
    strcpy(date_convert.arr,date_time.arr);            
	fun_change_loc_date();
	fprintf(fp,"%-16s",date_convert.arr); next_line();;
	fprintf(fp,"%-3.3s : %-10s",loc_legend[50], user_id.arr); next_line();;
	fprintf(fp,"%-3.3s : %-8s",loc_legend[60],loc_legend[30]); horz_skip(60); 
	fprintf(fp,"%-40.40s",loc_legend[40]); horz_skip(58);
	fprintf(fp,"%-5.5s : %4d",loc_legend[70],++pctr); next_line(); dash_line(); 
}

dec_SEL_CUR()
{
	/* EXEC SQL DECLARE SEL_CUR CURSOR FOR 
	SELECT facility_id, cash_cntr_code,blng_serv_desc,
	   	   sum(sum1), sum(sum2), sum(sum3), sum(sum4), sum(sum5), sum(sum6)	   											  				 			 			 		   							
	  FROM(SELECT a.operating_facility_id facility_id,
				  a.cash_counter_code cash_cntr_code,
				  c.short_desc blng_serv_desc,
				  a.blng_grp_id blng_grp_id,
				  decode(a.blng_grp_id ,:pp_1_blng_grp, b.upd_net_charge_amt,0) sum1,
				  decode(a.blng_grp_id ,:pp_2_blng_grp, b.upd_net_charge_amt,0) sum2,
			      decode(a.blng_grp_id ,:pp_3_blng_grp, b.upd_net_charge_amt,0) sum3,
			      decode(a.blng_grp_id ,:pp_4_blng_grp, b.upd_net_charge_amt,0) sum4,
  				  decode(a.blng_grp_id ,:pp_5_blng_grp, b.upd_net_charge_amt,0) sum5,
				  decode(a.blng_grp_id ,:pp_6_blng_grp, b.upd_net_charge_amt,0) sum6		  				  				  				  
			 FROM bl_bill_hdr a,
	 	          bl_patient_charges_folio b ,
                  bl_blng_serv c ,
                  bl_blng_serv_grp d
			WHERE a.doc_type_code = b.bill_doc_type_code
			  AND a.doc_num = b.bill_doc_num
			  AND b.blng_serv_code = c.blng_serv_code
			  AND c.serv_grp_code = d.serv_grp_code
			  AND NVL(bill_status,'~') <> 'C'
			  AND a.operating_facility_id = b.operating_facility_id
			  
			  AND trunc(a.doc_date) BETWEEN to_date(:pp_fm_date,'dd/mm/yyyy') AND to_date(:pp_to_date,'dd/mm/yyyy')
			  AND a.operating_facility_id BETWEEN :pp_fm_facility AND :pp_to_facility	
			  AND a.cash_counter_code BETWEEN DECODE(:pp_fm_cashcounter,'LOWEST','!!',:pp_fm_cashcounter) 
			  							                                          AND DECODE(:pp_to_cashcounter,'HIGHEST','~~',:pp_to_cashcounter)
		      AND b.blng_serv_code BETWEEN DECODE(:pp_fm_blng_srv,'LOWEST','!!',:pp_fm_blng_srv)
			  	  				  	                                       AND DECODE(:pp_to_blng_srv,'HIGHEST','~~',:pp_to_blng_srv)
		 ORDER BY 1,2,3)
	GROUP BY facility_id, cash_cntr_code,blng_serv_desc; */ 

}

open_SEL_CUR()
{
    /* EXEC SQL OPEN SEL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0,
      "select facility_id ,cash_cntr_code ,blng_serv_desc ,sum(sum1) ,sum(su\
m2) ,sum(sum3) ,sum(sum4) ,sum(sum5) ,sum(sum6)  from (select a.operating_fa\
cility_id facility_id ,a.cash_counter_code cash_cntr_code ,c.short_desc blng\
_serv_desc ,a.blng_grp_id blng_grp_id ,decode(a.blng_grp_id,:b0,b.upd_net_ch\
arge_amt,0) sum1 ,decode(a.blng_grp_id,:b1,b.upd_net_charge_amt,0) sum2 ,dec\
ode(a.blng_grp_id,:b2,b.upd_net_charge_amt,0) sum3 ,decode(a.blng_grp_id,:b3\
,b.upd_net_charge_amt,0) sum4 ,decode(a.blng_grp_id,:b4,b.upd_net_charge_amt\
,0) sum5 ,decode(a.blng_grp_id,:b5,b.upd_net_charge_amt,0) sum6  from bl_bil\
l_hdr a ,bl_patient_charges_folio b ,bl_blng_serv c ,bl_blng_serv_grp d wher\
e (((((((((a.doc_type_code=b.bill_doc_type_code and a.doc_num=b.bill_doc_num\
) and b.blng_serv_code=c.blng_serv_code) and c.serv_grp_code=d.serv_grp_code\
) and NVL(bill_status,'~')<>'C') and a.operating_facility_id=b.operating_fac\
ility_id) and trunc(a.doc_date) between to_date(:b6,'dd/mm/yyyy') and to_dat\
e(:b7,'dd/mm/yyyy')) and a.operating_facili");
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )246;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&pp_1_blng_grp;
    sqlstm.sqhstl[0] = (unsigned int  )10;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&pp_2_blng_grp;
    sqlstm.sqhstl[1] = (unsigned int  )10;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&pp_3_blng_grp;
    sqlstm.sqhstl[2] = (unsigned int  )10;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&pp_4_blng_grp;
    sqlstm.sqhstl[3] = (unsigned int  )10;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&pp_5_blng_grp;
    sqlstm.sqhstl[4] = (unsigned int  )10;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&pp_6_blng_grp;
    sqlstm.sqhstl[5] = (unsigned int  )10;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&pp_fm_date;
    sqlstm.sqhstl[6] = (unsigned int  )14;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&pp_to_date;
    sqlstm.sqhstl[7] = (unsigned int  )14;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&pp_fm_facility;
    sqlstm.sqhstl[8] = (unsigned int  )5;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&pp_to_facility;
    sqlstm.sqhstl[9] = (unsigned int  )5;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&pp_fm_cashcounter;
    sqlstm.sqhstl[10] = (unsigned int  )10;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&pp_fm_cashcounter;
    sqlstm.sqhstl[11] = (unsigned int  )10;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&pp_to_cashcounter;
    sqlstm.sqhstl[12] = (unsigned int  )10;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&pp_to_cashcounter;
    sqlstm.sqhstl[13] = (unsigned int  )10;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&pp_fm_blng_srv;
    sqlstm.sqhstl[14] = (unsigned int  )13;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&pp_fm_blng_srv;
    sqlstm.sqhstl[15] = (unsigned int  )13;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&pp_to_blng_srv;
    sqlstm.sqhstl[16] = (unsigned int  )13;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&pp_to_blng_srv;
    sqlstm.sqhstl[17] = (unsigned int  )13;
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


    if (OERROR)
      err_mesg("OPEN failed on cursor SEL_CUR",0,"");
}

fetch_SEL_CUR()
{
	cv_facility.arr[0]					= '\0';
	cv_cash_counter_code.arr[0]	    	= '\0';
	cv_service_desc.arr[0]	    		= '\0';

	cv_facility.len						= 0;
	cv_cash_counter_code.len			= 0;
	cv_service_desc.len					= 0;
	
	/* EXEC SQL FETCH SEL_CUR INTO 
							:cv_facility,:cv_cash_counter_code,:cv_service_desc,
							:cv_sum1,:cv_sum2,:cv_sum3,:cv_sum4,:cv_sum5,:cv_sum6; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )333;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cv_facility;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&cv_cash_counter_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&cv_service_desc;
 sqlstm.sqhstl[2] = (unsigned int  )43;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&cv_sum1;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&cv_sum2;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&cv_sum3;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&cv_sum4;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&cv_sum5;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&cv_sum6;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
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


							
	cv_facility.arr[cv_facility.len]							= '\0';
	cv_cash_counter_code.arr[cv_cash_counter_code.len]			= '\0';
	cv_service_desc.arr[cv_service_desc.len]					= '\0';
		
	if (OERROR)
		err_mesg("FETCH failed on cursor SEL_CUR",0,"");

    return(NODATA_FOUND?0:1);
}

close_SEL_CUR()
{
    /* EXEC SQL CLOSE SEL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )384;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("CLOSE failed on cursor SEL_CUR",0,"");
}

get_val()
{ 
    dec_SEL_CUR(); open_SEL_CUR(); 
	prv_facility.arr[0]					= '\0';
	prv_cash_counter_code.arr[0]		= '\0';
	
    prv_facility.len					= 0;
	prv_cash_counter_code.len			= 0;
	
	while(fetch_SEL_CUR())
	{
		get_cash_cntr_name();
		get_facility_name();
		if (strcmp(prv_facility.arr,cv_facility.arr)!=0)
		{	
			if (first == 1)
			{					
				first = 0; print_grp_hd(); print_val();
			}
			else
			{
				print_cc_tot(); print_fc_tot();
				print_grp_hd(); print_val();
			}
		}
		else if (strcmp(prv_cash_counter_code.arr,cv_cash_counter_code.arr)!=0)
		{
			print_cc_tot(); check_line(2);
			fprintf(fp,"%-15.15s : %-4.4s",loc_legend[130],cv_cash_counter_code.arr); fprintf(fp," - "); 
			fprintf(fp,"%-41.41s",cv_cash_cntr_name.arr);
			next_line();; next_line();; print_val();
		}
		else if (strcmp(prv_cash_counter_code.arr,cv_cash_counter_code.arr)==0)
		{
			print_val();
		}
		strcpy(prv_facility.arr,cv_facility.arr);
		strcpy(prv_cash_counter_code.arr,cv_cash_counter_code.arr);
	}
	print_cc_tot(); print_fc_tot(); print_gr_tot(); 
	fflush(fp); close_SEL_CUR();
}

print_grp_hd()
{
	fprintf(fp,"%-15.15s     : %-2.2s",loc_legend[170],cv_facility.arr); fprintf(fp,"-"); 
	//fprintf(fp,"%-30.30s",cv_facility_name.arr); next_line();
	fprintf(fp,"%-30s",cv_facility_name.arr); next_line();
	fprintf(fp,"%-15.15s : %-4.4s",loc_legend[130],cv_cash_counter_code.arr); fprintf(fp," - "); 
	fprintf(fp,"%-41.41s",cv_cash_cntr_name.arr); next_line(); next_line();;
}

print_val()
{
	blsr_total = cv_sum1+cv_sum2+cv_sum3+cv_sum4+cv_sum5+cv_sum6;
	cum_cc();
	fprintf(fp,"%-20.20s",cv_service_desc.arr); horz_skip(4);
	print_formated_amt(cv_sum1); horz_skip(9);
	print_formated_amt(cv_sum2); horz_skip(9);
	print_formated_amt(cv_sum3); horz_skip(9);
	print_formated_amt(cv_sum4); horz_skip(9);
	print_formated_amt(cv_sum5); horz_skip(9);
	print_formated_amt(cv_sum6); horz_skip(9);
	print_formated_amt(blsr_total); next_line();
}

cum_cc()
{
	cc_sum1=cc_sum1+cv_sum1; cc_sum2=cc_sum2+cv_sum2;
	cc_sum3=cc_sum3+cv_sum3; cc_sum4=cc_sum4+cv_sum4; 
	cc_sum5=cc_sum5+cv_sum5; cc_sum6=cc_sum6+cv_sum6; 
	cc_blsr_tot=cc_blsr_tot+blsr_total;
}
print_cc_tot()
{
	check_line(2); dash_line(); 
	fprintf(fp,"%17.17s",loc_legend[180]); horz_skip(7);
	print_formated_amt(cc_sum1); horz_skip(9);
	print_formated_amt(cc_sum2); horz_skip(9);
	print_formated_amt(cc_sum3); horz_skip(9);
	print_formated_amt(cc_sum4); horz_skip(9);
	print_formated_amt(cc_sum5); horz_skip(9);
	print_formated_amt(cc_sum6); horz_skip(9);
	print_formated_amt(cc_blsr_tot); 
	next_line(); dash_line(); cum_fc(); reset_cc();
}

cum_fc()
{
	fc_sum1=fc_sum1+cc_sum1; fc_sum2=fc_sum2+cc_sum2; fc_sum3=fc_sum3+cc_sum3;
	fc_sum4=fc_sum4+cc_sum4; fc_sum5=fc_sum5+cc_sum5; fc_sum6=fc_sum6+cc_sum6; 
	fc_blsr_tot=fc_blsr_tot+cc_blsr_tot;
}

print_fc_tot()
{
	check_line(1);
	fprintf(fp,"%17.17s",loc_legend[190]); horz_skip(7);
	print_formated_amt(fc_sum1); horz_skip(9);
	print_formated_amt(fc_sum2); horz_skip(9);
	print_formated_amt(fc_sum3); horz_skip(9);
	print_formated_amt(fc_sum4); horz_skip(9);
	print_formated_amt(fc_sum5); horz_skip(9);
	print_formated_amt(fc_sum6); horz_skip(9);
	print_formated_amt(fc_blsr_tot); 
	next_line(); dash_line(); cum_gr(); reset_fc();
}

cum_gr()
{
	gr_sum1=gr_sum1+fc_sum1; gr_sum2=gr_sum2+fc_sum2; gr_sum3=gr_sum3+fc_sum3;
	gr_sum4=gr_sum4+fc_sum4; gr_sum5=gr_sum5+fc_sum5; gr_sum6=gr_sum6+fc_sum6; 
	gr_blsr_tot=gr_blsr_tot+fc_blsr_tot;
}

print_gr_tot()
{
	check_line(1);
	fprintf(fp,"%17.17s",loc_legend[200]); horz_skip(7);
	print_formated_amt(gr_sum1); horz_skip(9);
	print_formated_amt(gr_sum2); horz_skip(9);
	print_formated_amt(gr_sum3); horz_skip(9);
	print_formated_amt(gr_sum4); horz_skip(9);
	print_formated_amt(gr_sum5); horz_skip(9);
	print_formated_amt(gr_sum6); horz_skip(9);
	print_formated_amt(gr_blsr_tot); next_line(); dash_line(); 
}

reset_cc()
{
	cc_sum1	= 0, cc_sum2 = 0, cc_sum3 = 0, cc_sum4 = 0, 
	cc_sum5	= 0, cc_sum6 = 0, cc_blsr_tot=0;
}

reset_fc()
{
	fc_sum1	= 0, fc_sum2 = 0, fc_sum3 = 0, fc_sum4 = 0, 
	fc_sum5	= 0, fc_sum6 = 0, fc_blsr_tot=0;
	reset_cc();
}

check_line(skip) /* will check for MAX LINE before printing totals */
int skip;
{
 	if ((lctr + skip) > (MAX_LINES-1))
	{
		nxt_page(); 
	}
}

next_line() /* will check for MAX LINE before printing totals */		
{
	if (lctr > (MAX_LINES-1))
	{
		nxt_page(); 
	}
	else
	{
		fprintf(fp,"\n"); ++lctr; /* fprintf(fp,"%2d",lctr); */
	}
}

nxt_page() /* will move the cursor to next page */
{
	fprintf(fp,"\f");  print_head(); 	
}

horz_skip(num) /* will move as many number of blank spaces as passed 
                  by parameter */
int num;
{
	for(i=0;i<num;i++)fprintf(fp," "); 
}

dash_line() /* will prodce give number of dash's */
{
	for(i=0;i<188;i++)fprintf(fp,"-"); next_line();
}

/*print_formated_amt(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30], fstr_amt[30];
    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        	       
        sprintf(str_amt,"%16s",s_amt);				
		strcpy(fstr_amt,"-");
		strcat(fstr_amt,str_amt);		
		sprintf(str_amt,"%16s",fstr_amt);		
        fprintf(fp,"%16s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%16s",s_amt);
        fprintf(fp,"%16s",str_amt);
     }
} */

print_formated_amt(l_amt)
double l_amt;
{
	char  s_amt[15];

    if(l_amt < 0)
	{
        put_val(s_amt,-l_amt);
        format_amt(s_amt);
        strcat(s_amt,"-");  
		fprintf(fp,"%16s",s_amt);
    }
    else 
	{
        put_val(s_amt,l_amt);
        format_amt(s_amt);
        strcat(s_amt," ");
		fprintf(fp,"%16s",s_amt);
    }
}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRACTBG.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRACTBG.LEGEND_'||LTRIM(RTRIM(TO_CHA\
R(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )399;
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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , '\
SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_va\
lue , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )422;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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

get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	
	  
       //	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
	  // :nd_loc_date := to_char(t_date,'DD/MM/YYYY');
		   
	:nd_loc_date :=  	sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI:SS'),:p_language_id);  


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date\
_2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI:SS' ) , :p_language_id ) \
; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )453;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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


        

		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");

}

                     
init_date_temp_var()
{
nd_temp_date.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
date_convert.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;
}


fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);


get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}

/*		*************************	End of Program   *************************		*/