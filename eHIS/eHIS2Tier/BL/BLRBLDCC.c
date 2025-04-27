
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
           char  filnam[30];
};
static const struct sqlcxp sqlfpn =
{
    29,
    "D:\\Issues\\22985_1\\BLRBLDCC.PC"
};


static unsigned long sqlctx = 1240316317;


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
            void  *sqhstv[19];
   unsigned int   sqhstl[19];
            int   sqhsts[19];
            void  *sqindv[19];
            int   sqinds[19];
   unsigned int   sqharm[19];
   unsigned int   *sqharc[19];
   unsigned short  sqadto[19];
   unsigned short  sqtdso[19];
} sqlstm = {10,19};

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

 static const char *sq0012 = 
"NG_GRP_ID between DECODE(:b8,'LOWEST','!!',:b8) and DECODE(:b10,'HIGHEST','~\
~',:b10)) and b.blng_serv_code between DECODE(:b12,'LOWEST','!!',:b12) and DEC\
ODE(:b14,'HIGHEST','~~',:b14)) and (((a.bill_nature_code='C' and :b16='CASH') \
or (a.bill_nature_code='A' and :b16='CREDIT')) or (a.bill_nature_code is  not \
null  and :b16='BOTH'))) order by 1,2,3,5,6,10            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,91,0,2,157,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,165,0,0,0,0,0,1,0,
43,0,0,3,0,0,27,173,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
74,0,0,4,357,0,4,219,0,0,13,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
141,0,0,5,165,0,4,267,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
176,0,0,6,94,0,4,292,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
203,0,0,7,515,0,6,314,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
230,0,0,8,138,0,4,351,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
261,0,0,9,96,0,4,371,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
288,0,0,10,184,0,4,390,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
315,0,0,11,159,0,4,411,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
346,0,0,12,1392,0,9,549,0,0,19,19,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
437,0,0,12,0,0,13,590,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
2,9,0,0,2,9,0,0,
520,0,0,12,0,0,15,635,0,0,0,0,0,1,0,
535,0,0,13,96,0,4,887,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
558,0,0,14,165,0,6,894,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
589,0,0,15,143,0,6,915,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
616,0,0,16,146,0,6,971,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 2.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRBLDCC.PC                                  */
/* AUTHOR                : RAJANISH NAMBIAR                             */
/* DATE WRITTEN          : 31/3/2003                                    */
/* CALLED FROM           : BLRBLDCC.fmb                                 */
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
			nd_temp_date1				[21],
			date_convert1				[21],
			nd_loc_date1				[21],
			nd_facility_id              [3],
            
/o pp ---> values obtained from sy_prog_pram o/
			pp_fm_date                  [12],
            pp_to_date                  [12],
			pp_fm_facility              [8],
			pp_to_facility              [8],
            pp_fm_cashcounter           [8],
            pp_to_cashcounter           [8],
			pp_fm_blng_grp				[8],
			pp_to_blng_grp				[8],
			pp_fm_blng_srv				[10],
			pp_to_blng_srv				[10],
			pp_show_bill				[8],
		
 /o cv ---> values obtained from cursor  o/
            cv_facility					 [3],
			cv_cash_counter_code         [5],	
			cv_serv_grp_code			 [3],
			cv_group_desc				[41],
			cv_doc_type_code			 [7],
			cv_doc_num					 [9],
			cv_doc_date                 [11],
			cv_bill_nature_code			 [7],
			cv_patient_id				[21],
			cv_blng_serv_code			[11],
			cv_service_desc				[41], 
			cv_episode_type				 [2],
			cv_episode_id				 [9],
			cv_visit_id					 [9],
			cv_admission_date			[11],
			cv_blng_grp_id				 [7],
			d_short_name_full                   [61],
			cv_patient_name				[61], 
			cv_patient_name1			[31], 
			cv_patient_loc_name			[31], 
			cv_cash_cntr_name			[41],
			cv_blng_grp_desc			[41],
			cv_facility_name			[41], //changed from 31 to 41
			cv_discharge_date			[11],

			prv_facility		         [3],
			prv_cash_counter_code	     [5],
			prv_srv_group				 [3],
			l_pk_value		    [100],
		   l_translated_value	    [201]; */ 
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

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[21]; } date_convert1;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[12]; } pp_fm_date;

struct { unsigned short len; unsigned char arr[12]; } pp_to_date;

struct { unsigned short len; unsigned char arr[8]; } pp_fm_facility;

struct { unsigned short len; unsigned char arr[8]; } pp_to_facility;

struct { unsigned short len; unsigned char arr[8]; } pp_fm_cashcounter;

struct { unsigned short len; unsigned char arr[8]; } pp_to_cashcounter;

struct { unsigned short len; unsigned char arr[8]; } pp_fm_blng_grp;

struct { unsigned short len; unsigned char arr[8]; } pp_to_blng_grp;

struct { unsigned short len; unsigned char arr[10]; } pp_fm_blng_srv;

struct { unsigned short len; unsigned char arr[10]; } pp_to_blng_srv;

struct { unsigned short len; unsigned char arr[8]; } pp_show_bill;

struct { unsigned short len; unsigned char arr[3]; } cv_facility;

struct { unsigned short len; unsigned char arr[5]; } cv_cash_counter_code;

struct { unsigned short len; unsigned char arr[3]; } cv_serv_grp_code;

struct { unsigned short len; unsigned char arr[41]; } cv_group_desc;

struct { unsigned short len; unsigned char arr[7]; } cv_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } cv_doc_num;

struct { unsigned short len; unsigned char arr[11]; } cv_doc_date;

struct { unsigned short len; unsigned char arr[7]; } cv_bill_nature_code;

struct { unsigned short len; unsigned char arr[21]; } cv_patient_id;

struct { unsigned short len; unsigned char arr[11]; } cv_blng_serv_code;

struct { unsigned short len; unsigned char arr[41]; } cv_service_desc;

struct { unsigned short len; unsigned char arr[2]; } cv_episode_type;

struct { unsigned short len; unsigned char arr[9]; } cv_episode_id;

struct { unsigned short len; unsigned char arr[9]; } cv_visit_id;

struct { unsigned short len; unsigned char arr[11]; } cv_admission_date;

struct { unsigned short len; unsigned char arr[7]; } cv_blng_grp_id;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } cv_patient_name;

struct { unsigned short len; unsigned char arr[31]; } cv_patient_name1;

struct { unsigned short len; unsigned char arr[31]; } cv_patient_loc_name;

struct { unsigned short len; unsigned char arr[41]; } cv_cash_cntr_name;

struct { unsigned short len; unsigned char arr[41]; } cv_blng_grp_desc;

struct { unsigned short len; unsigned char arr[41]; } cv_facility_name;

struct { unsigned short len; unsigned char arr[11]; } cv_discharge_date;

struct { unsigned short len; unsigned char arr[3]; } prv_facility;

struct { unsigned short len; unsigned char arr[5]; } prv_cash_counter_code;

struct { unsigned short len; unsigned char arr[3]; } prv_srv_group;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;


     double cv_net_chrg_amt             =	0,
			srv_grp_total		        =	0,
			cc_total			        =	0,
			grand_tot					=	0,
            fac_total					=	0;
			
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

int i  = 0, lctr  = 0, pctr  = 0, first = 1, p_cnt =1;

FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    if (argc < 2)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }
	
    strcpy(g_pgm_id,"BLRBLDCC");
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
   
    open_file(); fprintf(fp,"%c&l1O",ESC); fprintf(fp,"%c&k2S",ESC); 
	 
	print_title(); print_head();

	get_val();
	
	horz_skip(79); fprintf(fp,"*****   End of Report   *****");
	fprintf(fp,"%c&l0O",ESC); fprintf(fp,"%cE",ESC); fflush(fp); fclose(fp);
		
		/* EXEC SQL DELETE FROM SY_PROG_PARAM
              WHERE PGM_ID     = 'BLRBLDCC'
                AND SESSION_ID = :nd_session_id
                AND PGM_DATE   = :nd_pgm_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 2;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRBLDCC' and S\
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
	strcat(filename,"BLRBLDCC.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLRBLDCC.lis");
       proc_exit();
    }
}

fetch_prog_param()
{
	pp_fm_cashcounter.arr[0]		= '\0';
	pp_to_cashcounter.arr[0]		= '\0';
	pp_fm_date.arr[0]				= '\0';
    pp_to_date.arr[0]				= '\0';
	pp_fm_facility.arr[0]			= '\0';
	pp_to_facility.arr[0]			= '\0';
    pp_fm_blng_grp.arr[0]			= '\0';
	pp_to_blng_grp.arr[0]			= '\0';
	pp_fm_blng_srv.arr[0]			= '\0';
	pp_to_blng_srv.arr[0]			= '\0';
	pp_show_bill.arr[0]				= '\0';

	pp_fm_cashcounter.len			= 0;
	pp_to_cashcounter.len			= 0;
	pp_fm_date.len					= 0;
	pp_to_date.len					= 0;
	pp_fm_facility.len				= 0;
	pp_to_facility.len				= 0;
	pp_fm_blng_grp.len				= 0;
	pp_to_blng_grp.len				= 0;
	pp_fm_blng_srv.len				= 0;
	pp_to_blng_srv.len				= 0;
	pp_show_bill.len				= 0;

    /* EXEC SQL SELECT PARAM1,PARAM2,PARAM3,PARAM4,
                    NVL(PARAM5,'LOWEST'),NVL(PARAM6,'HIGHEST'),
					NVL(PARAM7,'LOWEST'),NVL(PARAM8,'HIGHEST'),
                    NVL(PARAM9,'LOWEST'),NVL(PARAM10,'HIGHEST'), 
					DECODE(PARAM11,'C','CASH','R','CREDIT','BOTH')
               INTO	:pp_fm_date,:pp_to_date,
					:pp_fm_facility,:pp_to_facility,
					:pp_fm_cashcounter,:pp_to_cashcounter,
					:pp_fm_blng_grp,:pp_to_blng_grp,
					:pp_fm_blng_srv,:pp_to_blng_srv,
					:pp_show_bill
               FROM SY_PROG_PARAM
              WHERE PGM_ID     = 'BLRBLDCC'
			    AND SESSION_ID = :nd_session_id
                AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,NVL(PARAM5,'LOWEST\
') ,NVL(PARAM6,'HIGHEST') ,NVL(PARAM7,'LOWEST') ,NVL(PARAM8,'HIGHEST') ,NVL(PA\
RAM9,'LOWEST') ,NVL(PARAM10,'HIGHEST') ,DECODE(PARAM11,'C','CASH','R','CREDIT'\
,'BOTH') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10  from SY_PROG_PARAM\
 where ((PGM_ID='BLRBLDCC' and SESSION_ID=:b11) and PGM_DATE=:b12)";
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
    sqlstm.sqhstl[2] = (unsigned int  )10;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&pp_to_facility;
    sqlstm.sqhstl[3] = (unsigned int  )10;
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
    sqlstm.sqhstv[6] = (         void  *)&pp_fm_blng_grp;
    sqlstm.sqhstl[6] = (unsigned int  )10;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&pp_to_blng_grp;
    sqlstm.sqhstl[7] = (unsigned int  )10;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&pp_fm_blng_srv;
    sqlstm.sqhstl[8] = (unsigned int  )12;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&pp_to_blng_srv;
    sqlstm.sqhstl[9] = (unsigned int  )12;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&pp_show_bill;
    sqlstm.sqhstl[10] = (unsigned int  )10;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[11] = (unsigned int  )18;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[12] = (unsigned int  )27;
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
	{
		err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");
	}

	if (NODATA_FOUND)
	{
	   err_mesg("No Record found in SY_PROG_PARAM",0,"");
	}
	pp_fm_cashcounter.arr[pp_fm_cashcounter.len]	= '\0';
	pp_to_cashcounter.arr[pp_to_cashcounter.len]	= '\0';
    pp_fm_date.arr[pp_fm_date.len]					= '\0';
    pp_to_date.arr[pp_to_date.len]					= '\0';
	pp_fm_facility.arr[pp_fm_facility.len]			= '\0';
	pp_to_facility.arr[pp_to_facility.len]			= '\0';
    pp_fm_blng_grp.arr[pp_fm_blng_grp.len]			= '\0';
	pp_to_blng_grp.arr[pp_to_blng_grp.len]			= '\0';
	pp_fm_blng_srv.arr[pp_fm_blng_srv.len]			= '\0';
	pp_to_blng_srv.arr[pp_to_blng_srv.len]			= '\0';
	pp_show_bill.arr[pp_show_bill.len]				= '\0';	
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
			  AND language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select UPPER(ACC_ENTITY_NAME) ,TO_CHAR(SYSDATE,'DD/MM/YYY\
Y HH24:MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTI\
TY_ID=:b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )141;
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



    if (OERROR) 
	{
		err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");
	}
	hosp_name.arr[hosp_name.len]           = '\0';
	date_time.arr[date_time.len]           = '\0';
	user_id.arr[user_id.len]               = '\0';
}

get_patient_name()	
{
	cv_patient_name.arr[0]			 = '\0';
	cv_patient_name1.arr[0]			 = '\0';
	cv_patient_loc_name.arr[0]		 = '\0';
    
	cv_patient_name.len				 = 0;
	cv_patient_name1.len				 = 0;
	cv_patient_loc_name.len			 = 0;

	/* EXEC SQL 
		SELECT /osubstr(SHORT_NAME,1,30),
		       decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1, 
			   o/
			   SHORT_NAME_LOC_LANG,short_name
	      INTO 
		  /ocv_patient_name,
		  cv_patient_name1,o/
		   cv_patient_loc_name ,
		   d_short_name_full
		  FROM MP_PATIENT_MAST
	     WHERE PATIENT_ID = :cv_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_NAME_LOC_LANG ,short_name into :b0,:b1  from MP\
_PATIENT_MAST where PATIENT_ID=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )176;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cv_patient_loc_name;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_short_name_full;
 sqlstm.sqhstl[1] = (unsigned int  )63;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&cv_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
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
	{
		err_mesg("SELECTION failed on table MP_PATIENT_MAST_CUR",0,"");
	}
    cv_patient_name.arr[cv_patient_name.len]			= '\0';
	    cv_patient_name1.arr[cv_patient_name1.len]			= '\0';
	cv_patient_loc_name.arr[cv_patient_loc_name.len]    = '\0';
    d_short_name_full.arr[d_short_name_full.len]               = '\0';
 
/* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :cv_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :cv_patient_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :cv_patient_name1    := :cv_patient_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 13;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ; \
BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str2\
 ) ; IF str2 IS NOT NULL THEN :cv_patient_name := str2 ; END IF ; blcommon . s\
plit_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS NO\
T NULL THEN :cv_patient_name1 := str2 ; END IF ; blcommon . split_words ( :d_s\
hort_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :cv_p\
atient_name1 := :cv_patient_name1 || str2 ; end if ; END ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )203;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
sqlstm.sqhstl[0] = (unsigned int  )63;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&cv_patient_name;
sqlstm.sqhstl[1] = (unsigned int  )63;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&cv_patient_name1;
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


       cv_patient_name.arr[cv_patient_name.len]  = '\0';
       cv_patient_name1.arr[cv_patient_name1.len]  = '\0';

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
	   AND		language_id=:p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_DESC into :b0  from BL_CASH_COUNTER_LANG_VW whe\
re ((CASH_COUNTER_CODE=:b1 and OPERATING_FACILITY_ID=:b2) and language_id=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )230;
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
    { 
		err_mesg("SELECTION failed on table BL_CASH_COUNTER",0,"");
	}
	cv_cash_cntr_name.arr[cv_cash_cntr_name.len]  = '\0';
}

get_blng_grp_desc()
{
	cv_blng_grp_desc.arr[0]	= '\0';
    cv_blng_grp_desc.len	= 0;

	/* EXEC SQL 
	SELECT short_desc
	  INTO cv_blng_grp_desc	 
	  FROM BL_BLNG_GRP_LANG_VW
     WHERE blng_grp_id = :cv_blng_grp_id
	 AND		language_id=:p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from BL_BLNG_GRP_LANG_VW where (\
blng_grp_id=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )261;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cv_blng_grp_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&cv_blng_grp_id;
 sqlstm.sqhstl[1] = (unsigned int  )9;
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
	{
        err_mesg("SELECTION failed on table BL_BLNG_GRP",0,"");
	}	  
	cv_blng_grp_desc.arr[cv_blng_grp_desc.len]  = '\0';
}
       
get_facility_name()   
{
	cv_facility_name.arr[0]		= '\0';    
    cv_facility_name.len		= 0;

	/* EXEC SQL 
	SELECT a.acc_entity_name name
	  INTO cv_facility_name
	  FROM SY_ACC_ENTITY_lang_vw a, SY_USER b
	 WHERE b.facility_id   = a.acc_entity_id
	   AND b.user_id  = USER
	   AND a.acc_entity_id = :pp_fm_facility
	   AND		language_id=:p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select a.acc_entity_name name into :b0  from SY_ACC_ENTITY_l\
ang_vw a ,SY_USER b where (((b.facility_id=a.acc_entity_id and b.user_id=USER)\
 and a.acc_entity_id=:b1) and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )288;
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
 sqlstm.sqhstl[1] = (unsigned int  )10;
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
	{
		err_mesg("SELECTION failed on table SY_ACC_ENTITY & SM_FACILITY_FOR_USER",0,"");
	}	  
	cv_facility_name.arr[cv_facility_name.len]  = '\0';
}

get_discharge_date()
{
	cv_discharge_date.arr[0]		= '\0';
    cv_discharge_date.len		= 0;

	/* EXEC SQL 
	SELECT to_char(discharge_date_time,'dd/mm/yyyy')
	  INTO cv_discharge_date
	  FROM BL_EPISODE_FIN_DTLS
	 WHERE operating_facility_id = :nd_facility_id
	   AND episode_type          = :cv_episode_type
	   AND episode_id            = :cv_episode_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select to_char(discharge_date_time,'dd/mm/yyyy') into :b0  f\
rom BL_EPISODE_FIN_DTLS where ((operating_facility_id=:b1 and episode_type=:b2\
) and episode_id=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )315;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cv_discharge_date;
 sqlstm.sqhstl[0] = (unsigned int  )13;
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
 sqlstm.sqhstv[2] = (         void  *)&cv_episode_type;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&cv_episode_id;
 sqlstm.sqhstl[3] = (unsigned int  )11;
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
	{
		err_mesg("SELECTION failed on table SY_ACC_ENTITY & SM_FACILITY_FOR_USER",0,"");
	}	  
	cv_discharge_date.arr[cv_discharge_date.len]  = '\0';
}

print_title()
{
	common_head(); 	dash_line();
	//fprintf(fp,"VER : 2.10.01"); 
	next_line();

	next_line(); next_line(); next_line(); horz_skip(35); 
	fprintf(fp,"%15s",loc_legend[80]); next_line(); horz_skip(35); 
	fprintf(fp,"----------------"); 
	
	next_line(); next_line(); horz_skip(50);
		init_date_temp_var();
		strcpy(date_convert.arr,pp_fm_date.arr);
		if (date_convert.arr[0]!='\0')
		{
		fun_change_loc_date();
		fprintf(fp,"%-15.15s        %-5.5s: %-10.10s",loc_legend[90],loc_legend[100],date_convert.arr);
		}
 	next_line(); horz_skip(50);
		init_date_temp_var();
 
		strcpy(date_convert.arr,pp_to_date.arr);
		if(date_convert.arr[0]!='\0')
		{
		fun_change_loc_date();
	    fprintf(fp,"                         %-3.3s: %-10.10s",loc_legend[110],date_convert.arr);
         }
	next_line(); next_line(); horz_skip(50);
	fprintf(fp,"%-15.15s        %-5.5s: %-8.8s",loc_legend[120],loc_legend[100],pp_fm_facility.arr);
 	next_line(); horz_skip(50);
	fprintf(fp,"                         %-3.3s: %-8.8s",loc_legend[110],pp_to_facility.arr);
		
	next_line(); next_line(); horz_skip(50);
	fprintf(fp,"%-15.15s        %-5.5s: %-8.8s",loc_legend[130],loc_legend[100],pp_fm_cashcounter.arr);
	next_line(); horz_skip(50);
	fprintf(fp,"                         %-3.3s: %-8.8s",loc_legend[110],pp_to_cashcounter.arr);
	
	next_line(); next_line(); horz_skip(50);
	fprintf(fp,"%-15.15s        %-5.5s: %-8.8s",loc_legend[150],loc_legend[100],pp_fm_blng_grp.arr);
 	next_line(); horz_skip(50);
	fprintf(fp,"                         %-3.3s: %-8.8s",loc_legend[110],pp_to_blng_grp.arr);
	
	next_line(); next_line(); horz_skip(50);
	fprintf(fp,"%-15.15s        %-5.5s: %-10.10s",loc_legend[140],loc_legend[100],pp_fm_blng_srv.arr);
 	next_line(); horz_skip(50);
	fprintf(fp,"                         %-3.3s: %-10.10s",loc_legend[110],pp_to_blng_srv.arr);

	
	next_line(); next_line(); horz_skip(50);
	fprintf(fp,"%-15.15s             : %-8.8s",loc_legend[160],pp_show_bill.arr);
 	
	fprintf(fp,"\f");
}

print_head()
{
	common_head(); 
}

common_head()
{
	lctr =1; fprintf(fp,"\n");fprintf(fp,"%-5.5s : %-2.2s",loc_legend[10],loc_legend[20]); horz_skip(73);
	//fprintf(fp,"%-30.30s",hosp_name.arr); horz_skip(61);
	fprintf(fp,"%-30s",hosp_name.arr); horz_skip(61);
		init_date_temp_var();
		strcpy(date_convert.arr,date_time.arr);
		if(date_convert.arr[0]!='\0')
		{
		fun_change_loc_date();
		fprintf(fp,"%-16s",date_convert.arr); 
		}
		next_line();
	fprintf(fp,"%-5.5s : %-10s",loc_legend[50], user_id.arr); next_line();
	fprintf(fp,"%-5.5s : %-8s",loc_legend[60],loc_legend[30]); horz_skip(65);
	fprintf(fp,"%-35.35s",loc_legend[40]); horz_skip(58);
	fprintf(fp,"%-5.5s: %4d",loc_legend[70],++pctr); next_line(); 
}

dec_sel_cur() 
{

	/* EXEC SQL DECLARE SEL_CUR CURSOR FOR 
	SELECT a.operating_facility_id, a.cash_counter_code ,
           d.serv_grp_code, d.short_desc ,
           a.doc_type_code, LTRIM(TO_CHAR(a.doc_num,'00000009')), 
		   TO_CHAR(a.doc_date,'dd/mm/yyyy'),
		   decode(a.bill_nature_code,'A','CREDIT','C','CASH'),
		   a.patient_id, b.blng_serv_code, c.short_desc,
		   a.episode_type, a.episode_id, 
		   LTRIM(TO_CHAR(a.visit_id,'0009')), b.upd_net_charge_amt,			   
		   TO_CHAR(a.admission_date,'dd/mm/yyyy'), a.blng_grp_id blg_grp_id
	  FROM bl_bill_hdr a,
 	       bl_patient_charges_folio b ,
           bl_blng_serv c ,
		   bl_blng_serv_grp d
	 WHERE a.doc_type_code = b.bill_doc_type_code 
       AND a.doc_num = b.bill_doc_num  
       AND b.blng_serv_code = c.blng_serv_code 
       AND c.serv_grp_code = d.serv_grp_code 
       AND NVL(bill_status,'~') <> 'C'  
	   AND NVL(trx_status,'~')<>'C'
       AND a.operating_facility_id = b.operating_facility_id
	   AND TRUNC(a.doc_date) BETWEEN to_date(:pp_fm_date,'dd/mm/yyyy') AND to_date(:pp_to_date,'dd/mm/yyyy')
	   AND a.operating_facility_id BETWEEN :pp_fm_facility AND :pp_to_facility
	   AND a.cash_counter_code BETWEEN DECODE(:pp_fm_cashcounter,'LOWEST','!!',:pp_fm_cashcounter) 
	   	   					   	   AND DECODE(:pp_to_cashcounter,'HIGHEST','~~',:pp_to_cashcounter)
	   --AND d.serv_grp_code BETWEEN DECODE(:pp_fm_blng_grp,'LOWEST','!!',:pp_fm_blng_grp) 
	   --   				   	   AND DECODE(:pp_to_blng_grp,'HIGHEST','~~',:pp_to_blng_grp)
	   AND b.BLNG_GRP_ID BETWEEN DECODE(:pp_fm_blng_grp,'LOWEST','!!',:pp_fm_blng_grp) 
	       				   AND DECODE(:pp_to_blng_grp,'HIGHEST','~~',:pp_to_blng_grp)
	   AND b.blng_serv_code BETWEEN DECODE(:pp_fm_blng_srv,'LOWEST','!!',:pp_fm_blng_srv) 
	   	   					    AND DECODE(:pp_to_blng_srv,'HIGHEST','~~',:pp_to_blng_srv)
	   AND ((a.bill_nature_code = 'C' AND :pp_show_bill = 'CASH')   OR
            (a.bill_nature_code = 'A' AND :pp_show_bill = 'CREDIT') OR
       		(a.bill_nature_code IS NOT NULL AND :pp_show_bill = 'BOTH'))
  
  ORDER BY 1,2,3,5,6,10; */ 


}


open_sel_cur()
{
    /* EXEC SQL OPEN SEL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 19;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select a.operating_facility_id ,a.cash_counter_code ,d.serv_grp_code \
,d.short_desc ,a.doc_type_code ,LTRIM(TO_CHAR(a.doc_num,'00000009')) ,TO_CHA\
R(a.doc_date,'dd/mm/yyyy') ,decode(a.bill_nature_code,'A','CREDIT','C','CASH\
') ,a.patient_id ,b.blng_serv_code ,c.short_desc ,a.episode_type ,a.episode_\
id ,LTRIM(TO_CHAR(a.visit_id,'0009')) ,b.upd_net_charge_amt ,TO_CHAR(a.admis\
sion_date,'dd/mm/yyyy') ,a.blng_grp_id blg_grp_id  from bl_bill_hdr a ,bl_pa\
tient_charges_folio b ,bl_blng_serv c ,bl_blng_serv_grp d where ((((((((((((\
a.doc_type_code=b.bill_doc_type_code and a.doc_num=b.bill_doc_num) and b.bln\
g_serv_code=c.blng_serv_code) and c.serv_grp_code=d.serv_grp_code) and NVL(b\
ill_status,'~')<>'C') and NVL(trx_status,'~')<>'C') and a.operating_facility\
_id=b.operating_facility_id) and TRUNC(a.doc_date) between to_date(:b0,'dd/m\
m/yyyy') and to_date(:b1,'dd/mm/yyyy')) and a.operating_facility_id between \
:b2 and :b3) and a.cash_counter_code between DECODE(:b4,'LOWEST','!!',:b4) a\
nd DECODE(:b6,'HIGHEST','~~',:b6)) and b.BL");
    sqlstm.stmt = sq0012;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )346;
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
    sqlstm.sqhstl[2] = (unsigned int  )10;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&pp_to_facility;
    sqlstm.sqhstl[3] = (unsigned int  )10;
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
    sqlstm.sqhstv[5] = (         void  *)&pp_fm_cashcounter;
    sqlstm.sqhstl[5] = (unsigned int  )10;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&pp_to_cashcounter;
    sqlstm.sqhstl[6] = (unsigned int  )10;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&pp_to_cashcounter;
    sqlstm.sqhstl[7] = (unsigned int  )10;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&pp_fm_blng_grp;
    sqlstm.sqhstl[8] = (unsigned int  )10;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&pp_fm_blng_grp;
    sqlstm.sqhstl[9] = (unsigned int  )10;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&pp_to_blng_grp;
    sqlstm.sqhstl[10] = (unsigned int  )10;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&pp_to_blng_grp;
    sqlstm.sqhstl[11] = (unsigned int  )10;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&pp_fm_blng_srv;
    sqlstm.sqhstl[12] = (unsigned int  )12;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&pp_fm_blng_srv;
    sqlstm.sqhstl[13] = (unsigned int  )12;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&pp_to_blng_srv;
    sqlstm.sqhstl[14] = (unsigned int  )12;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&pp_to_blng_srv;
    sqlstm.sqhstl[15] = (unsigned int  )12;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&pp_show_bill;
    sqlstm.sqhstl[16] = (unsigned int  )10;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&pp_show_bill;
    sqlstm.sqhstl[17] = (unsigned int  )10;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&pp_show_bill;
    sqlstm.sqhstl[18] = (unsigned int  )10;
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


    if (OERROR)
		err_mesg("OPEN failed on cursor SEL_CUR",0,"");
}

fetch_sel_cur()
{
	cv_facility.arr[0]					= '\0';
	cv_cash_counter_code.arr[0]	    	= '\0';
	cv_serv_grp_code.arr[0]				= '\0';
	cv_group_desc.arr[0]				= '\0';
	cv_doc_type_code.arr[0]				= '\0';
	cv_doc_num.arr[0]				 	= '\0';
	cv_doc_date.arr[0]	    			= '\0';
	cv_bill_nature_code.arr[0]	    	= '\0';
	cv_patient_id.arr[0]	    		= '\0';
	cv_blng_serv_code.arr[0]	    	= '\0';
	cv_episode_type.arr[0]				= '\0';
	cv_episode_id.arr[0]	    		= '\0';
	cv_visit_id.arr[0]	    			= '\0';
	cv_admission_date.arr[0]	    	= '\0';
	cv_blng_grp_id.arr[0]	    		= '\0';
	cv_service_desc.arr[0]	    		= '\0';
	
	cv_facility.len						= 0;
	cv_cash_counter_code.len			= 0;
	cv_serv_grp_code.len				= 0;
	cv_group_desc.len					= 0;
	cv_doc_type_code.len				= 0;
	cv_doc_num.len						= 0;
	cv_doc_date.len						= 0;
	cv_bill_nature_code.len				= 0;
	cv_patient_id.len					= 0;
	cv_blng_serv_code.len				= 0;
	cv_episode_type.len					= 0;
	cv_episode_id.len					= 0;
	cv_visit_id.len						= 0;
	cv_admission_date.len				= 0;
	cv_blng_grp_id.len					= 0;
	cv_service_desc.len					= 0;

	/* EXEC SQL FETCH SEL_CUR INTO 
							:cv_facility,
							:cv_cash_counter_code,
							:cv_serv_grp_code,
							:cv_group_desc,
							:cv_doc_type_code,
							:cv_doc_num,
							:cv_doc_date,
							:cv_bill_nature_code,
							:cv_patient_id,
							:cv_blng_serv_code,
							:cv_service_desc,							
							:cv_episode_type,
							:cv_episode_id,
							:cv_visit_id,
							:cv_net_chrg_amt,
							:cv_admission_date,
							:cv_blng_grp_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )437;
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
 sqlstm.sqhstv[2] = (         void  *)&cv_serv_grp_code;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&cv_group_desc;
 sqlstm.sqhstl[3] = (unsigned int  )43;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&cv_doc_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )9;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&cv_doc_num;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&cv_doc_date;
 sqlstm.sqhstl[6] = (unsigned int  )13;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&cv_bill_nature_code;
 sqlstm.sqhstl[7] = (unsigned int  )9;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&cv_patient_id;
 sqlstm.sqhstl[8] = (unsigned int  )23;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&cv_blng_serv_code;
 sqlstm.sqhstl[9] = (unsigned int  )13;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&cv_service_desc;
 sqlstm.sqhstl[10] = (unsigned int  )43;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&cv_episode_type;
 sqlstm.sqhstl[11] = (unsigned int  )4;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&cv_episode_id;
 sqlstm.sqhstl[12] = (unsigned int  )11;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&cv_visit_id;
 sqlstm.sqhstl[13] = (unsigned int  )11;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&cv_net_chrg_amt;
 sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&cv_admission_date;
 sqlstm.sqhstl[15] = (unsigned int  )13;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&cv_blng_grp_id;
 sqlstm.sqhstl[16] = (unsigned int  )9;
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


 
	cv_facility.arr[cv_facility.len]							= '\0';
	cv_cash_counter_code.arr[cv_cash_counter_code.len]			= '\0';
	cv_serv_grp_code.arr[cv_serv_grp_code.len]					= '\0';
	cv_group_desc.arr[cv_group_desc.len]						= '\0';
	cv_doc_type_code.arr[cv_doc_type_code.len]					= '\0';
	cv_doc_num.arr[cv_doc_num.len]								= '\0';
	cv_doc_date.arr[cv_doc_date.len]							= '\0';
	cv_bill_nature_code.arr[cv_bill_nature_code.len]			= '\0';
	cv_patient_id.arr[cv_patient_id.len]						= '\0';
	cv_blng_serv_code.arr[cv_blng_serv_code.len]				= '\0';
	cv_episode_type.arr[cv_episode_type.len]					= '\0';
	cv_episode_id.arr[cv_episode_id.len]						= '\0';
	cv_visit_id.arr[cv_visit_id.len]							= '\0';
	cv_admission_date.arr[cv_admission_date.len]				= '\0';
	cv_blng_grp_id.arr[cv_blng_grp_id.len]						= '\0';
	cv_service_desc.arr[cv_service_desc.len]					= '\0';
	
	if (OERROR)
	{
		err_mesg("FETCH failed on cursor SEL_CUR",0,"");
	}
    return(NODATA_FOUND?0:1);
}

close_sel_cur()
{
    /* EXEC SQL CLOSE SEL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 19;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )520;
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
	dec_sel_cur(); open_sel_cur(); 	
    
	prv_facility.arr[0]					= '\0';
	prv_cash_counter_code.arr[0]		= '\0';
	prv_srv_group.arr[0]				= '\0';

    prv_facility.len					= 0;
	prv_cash_counter_code.len			= 0;
	prv_srv_group.len					= 0;

	while(fetch_sel_cur())
	{
		get_patient_name(); get_cash_cntr_name();
		get_blng_grp_desc(); get_facility_name(); get_discharge_date();
		if (strcmp(prv_facility.arr,cv_facility.arr)!=0)
		{	
			if (first == 1)
			{					
				first = 0;  print_grp_hd();  print_cash_cntr_val(); print_val();
			}
			else
			{
				print_fc_tot();	next_page();
				print_cash_cntr_val(); print_val();
			}
		}
		else if (strcmp(prv_cash_counter_code.arr,cv_cash_counter_code.arr)!=0)
		{
			print_cc_tot(); print_cash_cntr_val();						
			print_val();
		}
		else if (strcmp(prv_srv_group.arr,cv_serv_grp_code.arr)!=0)
		{
			print_sg_tot(); print_srv_grp_val();
			print_val();		
		}
		else if (strcmp(prv_srv_group.arr,cv_serv_grp_code.arr)==0)
		{
			print_val();
		}	
		strcpy(prv_facility.arr,cv_facility.arr);
		strcpy(prv_cash_counter_code.arr,cv_cash_counter_code.arr);
		strcpy(prv_srv_group.arr,cv_serv_grp_code.arr);
	}
	print_fc_tot(); check_line(1);
	fprintf(fp,"%172.172s",loc_legend[300]); print_formated_amt(grand_tot); 
	next_line(); dash_line(); fflush(fp); close_sel_cur();
}

cum_sg()
{
	srv_grp_total	= srv_grp_total + cv_net_chrg_amt;
	cc_total		= cc_total		+ cv_net_chrg_amt;
    fac_total		= fac_total		+ cv_net_chrg_amt;
}

print_sg_tot()
{
	check_line(2);  dash_line(); 
	fprintf(fp,"%172.172s",loc_legend[310]);
	print_formated_amt(srv_grp_total); 
	reset_sg();	next_line(); dash_line();
}

print_cc_tot()
{
	print_sg_tot(); check_line(1); 
	fprintf(fp,"%172.172s",loc_legend[330]);
	print_formated_amt(cc_total); 
	reset_cc(); next_line();  dash_line();
}

print_fc_tot()
{
	print_cc_tot(); check_line(1);
	fprintf(fp,"%172.172s",loc_legend[320]);
	print_formated_amt(fac_total);  
	reset_fc(); next_line(); dash_line();
}

reset_sg()
{
	srv_grp_total = 0;
}

reset_cc()
{
	srv_grp_total = 0; cc_total = 0;
}
   
reset_fc()
{
	grand_tot = grand_tot + fac_total; reset_cc(); fac_total = 0;
}

print_grp_hd()
{
	next_line(); fprintf(fp,"%-10.10s : %-2.2s",loc_legend[170],cv_facility.arr); fprintf(fp,"-"); 
	//fprintf(fp,"%-30.30s",cv_facility_name.arr); next_line(); dash_line();
	fprintf(fp,"%-30s",cv_facility_name.arr); next_line(); dash_line();
	fprintf(fp,"%-15.15s",loc_legend[180]); horz_skip(2);
	fprintf(fp,"%-10.10s",loc_legend[190]); horz_skip(2);
	fprintf(fp,"%-11.11s",loc_legend[200]); horz_skip(2);
	fprintf(fp,"%-20.20s",loc_legend[210]); horz_skip(2);
	//fprintf(fp,"%-30.30s",loc_legend[220]); horz_skip(32);
	fprintf(fp,"%-29.29s",loc_legend[220]); horz_skip(2);
	fprintf(fp,"%-10.10s",loc_legend[230]); horz_skip(2);
	fprintf(fp,"%-15.15s",loc_legend[240]); horz_skip(2);
	fprintf(fp,"%-28.28s"," "); horz_skip(2);
	fprintf(fp,"%-15.15s",loc_legend[250]); horz_skip(2);
	fprintf(fp,"%16.16s",loc_legend[260]); next_line();

	horz_skip(42); fprintf(fp,"%-14.14s",loc_legend[280]); horz_skip(8);
	fprintf(fp,"%-14.14s",loc_legend[270]); horz_skip(17);
	fprintf(fp,"%-18.18s",loc_legend[150]); next_line(); dash_line();
	}

print_val()
{
	fprintf(fp,"%-6.6s",cv_doc_type_code.arr); fprintf(fp,"/"); 
	fprintf(fp,"%-8.8s",cv_doc_num.arr); horz_skip(2); 
		  init_date_temp_var();
          strcpy(date_convert.arr,cv_doc_date.arr);
		  if(date_convert.arr[0]!='\0')
		  {
	      fun_change_loc_date();
		  fprintf(fp,"%-10.10s",date_convert.arr); 
		  }
		  horz_skip(2);
	fprintf(fp,"%-11.11s",cv_bill_nature_code.arr); horz_skip(2);
	fprintf(fp,"%-20.20s",cv_patient_id.arr); horz_skip(2);
//	fprintf(fp,"%-30.30s",cv_patient_name.arr); horz_skip(1); commented for 22985

	fprintf(fp,"%-30.30s",cv_patient_loc_name.arr); horz_skip(1);
	fprintf(fp,"%-10.10s",cv_blng_serv_code.arr); horz_skip(2);
	fprintf(fp,"%-45.45s",cv_service_desc.arr); horz_skip(2);
	fprintf(fp,"%-1.1s",cv_episode_type.arr); fprintf(fp,"/"); 
	fprintf(fp,"%-8.8s",cv_episode_id.arr);  fprintf(fp,"/"); 
	fprintf(fp,"%-4.4s",cv_visit_id.arr); horz_skip(2);
	print_formated_amt(cv_net_chrg_amt); next_line();

if(strlen(cv_patient_name1.arr) > 2)
{
 fprintf(fp,"%63s %s \n"," ",cv_patient_name1.arr);
}
		if(cv_admission_date.arr[0]!='\0')
		{
	      init_date_temp_var();                              
	      strcpy(date_convert.arr,cv_admission_date.arr);    
	      fun_change_loc_date();
		  }
	horz_skip(42); fprintf(fp,"%-14.14s",date_convert.arr); horz_skip(8); 
       if(cv_discharge_date.arr[0]!='\0')
		{
		  init_date_temp_var1();                              
	      strcpy(date_convert1.arr,cv_discharge_date.arr);      
	      fun_change_loc_date1();
		}
	fprintf(fp,"%-14.14s",date_convert1.arr); horz_skip(17);
	
	fprintf(fp,"%-4.4s",cv_blng_grp_id.arr); fprintf(fp,"-");
	fprintf(fp,"%-15.15s",cv_blng_grp_desc.arr); cum_sg(); next_line(); 
}

print_cash_cntr_val()
{	
	fprintf(fp,"%-15.15s",loc_legend[130]);
	fprintf(fp,"%-4.4s",cv_cash_counter_code.arr); fprintf(fp," - "); 
	fprintf(fp,"%-41.41s",cv_cash_cntr_name.arr); next_line(); print_srv_grp_val(); 
}

print_srv_grp_val()
{
	fprintf(fp,"%-15.15s : ",loc_legend[290]);
	fprintf(fp,"%-2.2s",cv_serv_grp_code.arr); fprintf(fp," - ");
	fprintf(fp,"%-41.41s",cv_group_desc.arr); next_line(); next_line();
}

check_line(skip) /* will check for MAX LINE before printing totals */
int skip;
{
	if ((lctr + skip) > (MAX_LINES-1))
	{
		next_page(); 
	}
}

next_line() /* will check for MAX LINE before printing totals */		
{
	if (lctr > (MAX_LINES-1))
	{
		next_page(); 
	}
	else
	{
		fprintf(fp,"\n"); ++lctr;  //fprintf(fp,"%2d",lctr); 
	}
}

next_page() /* will move the cursor to next page */
{
	fprintf(fp,"\f");  print_head(); print_grp_hd();	
}

horz_skip(num)
	int num;
{
	for(i=0;i<num;i++)fprintf(fp," ");
}

dash_line()
{
	for(i=0;i<188;i++)fprintf(fp,"-");next_line();
}

print_formated_amt(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30], fstr_amt[30];
    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        	       
        sprintf(str_amt,"%s",s_amt);				
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
} 


fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRBLDCC.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 19;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRBLDCC.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )535;
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
  sqlstm.arrsiz = 19;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )558;
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
	
	  
//       	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
//	   :nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	:nd_loc_date :=  	sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI:SS'),:p_language_id);  

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI:SS' ) , :p_language_id ) ; \
END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )589;
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

//------------
get_local_date1()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date1  date;
	
	BEGIN
	
	  
      // 	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date1,'DD/MM/RRRR'),:p_language_id,t_date1);  
      
	  // :nd_loc_date1 := to_char(t_date1,'DD/MM/RRRR');
	
	:nd_loc_date1 :=  	sm_convert_date_2t(to_date(:nd_temp_date1,'DD/MM/RRRR HH24:MI:SS'),:p_language_id);  

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date1 date ; BEGIN :nd_loc_date1 := sm_convert_dat\
e_2t ( to_date ( :nd_temp_date1 , 'DD/MM/RRRR HH24:MI:SS' ) , :p_language_id )\
 ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )616;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date1;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date1;
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

  // HH24:MI                   
init_date_temp_var1()
{
nd_temp_date1.arr[0] = '\0';
nd_loc_date1.arr[0]  = '\0';
date_convert1.arr[0] = '\0';

nd_temp_date1.len = 0;
nd_loc_date1.len  = 0;
date_convert1.len = 0;
}

  
fun_change_loc_date1()
{

strcpy(nd_temp_date1.arr,date_convert1.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);


get_local_date1();


strcpy(date_convert1.arr,nd_loc_date1.arr);


}

/*	****************************	End of Program	****************************	*/