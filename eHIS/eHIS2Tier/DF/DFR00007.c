
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
           char  filnam[51];
};
static const struct sqlcxp sqlfpn =
{
    50,
    "T:\\BL\\Facility Change Modifications\\DF\\DFR00007.PC"
};


static unsigned long sqlctx = 464674387;


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
            void  *sqhstv[43];
   unsigned int   sqhstl[43];
            int   sqhsts[43];
            void  *sqindv[43];
            int   sqinds[43];
   unsigned int   sqharm[43];
   unsigned int   *sqharc[43];
   unsigned short  sqadto[43];
   unsigned short  sqtdso[43];
} sqlstm = {10,43};

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

 static const char *sq0002 = 
"3,'I',4,5)            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,146,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,3094,0,9,616,0,0,43,43,0,1,0,1,9,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,
1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,
0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,
0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,9,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,3,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
223,0,0,2,0,0,13,636,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,
4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
282,0,0,2,0,0,15,662,0,0,0,0,0,1,0,
297,0,0,3,295,0,4,788,0,0,17,3,0,1,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
380,0,0,4,84,0,2,831,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
407,0,0,5,96,0,4,848,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
430,0,0,6,165,0,6,858,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
461,0,0,7,120,0,4,1002,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
};


          
#include <stdio.h>         
#include <string.h> 
#include <bl.h>       
#include <math.h> 

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -100)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define NODATAFOUND sqlca.sqlcode == 1403
#define OERROR          (sqlca.sqlcode < 0)
#define MAX_LINES 42
#define REP_WIDTH 172
#define VER  "VER : 4.10\n"
#define ESC  0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR     l_translated_value	[201],	
		    l_pk_value	[100],

		    nd_curr_pgm_id [15],
		    nd_session_id [16],
		    nd_pgm_date   [25],
		    nd_pwd 	[91],
		    nd_facility_id[3]; */ 
struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[15]; } nd_curr_pgm_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;
	
	
	/* VARCHAR	    nd_from_doctor_id[16],
		    nd_to_doctor_id[16],
		    nd_from_rev_catg_code[11],
		    nd_to_rev_catg_code[11],
		    nd_episode_type[2],
		    nd_episode_split_yn[2],
		    nd_blng_grp_id[6],
		    nd_rev_cust_code[9],
		    nd_repeat_grp_col[2],
		    nd_to_month_year[20],
		    d_acc_entity_name[100],
		    d_user[31],
		    d_curr_date[21],		    
		    d_physician_id[16], 
		    d_prv_physician_id[16], 
		    d_physician_name[16],
		    d_prv_physician_name[16],		    
		    d_rev_catg[16],
		    d_prv_rev_catg[16],
		    d_episode_type[4],
			p_language_id[3]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_from_doctor_id;

struct { unsigned short len; unsigned char arr[16]; } nd_to_doctor_id;

struct { unsigned short len; unsigned char arr[11]; } nd_from_rev_catg_code;

struct { unsigned short len; unsigned char arr[11]; } nd_to_rev_catg_code;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_split_yn;

struct { unsigned short len; unsigned char arr[6]; } nd_blng_grp_id;

struct { unsigned short len; unsigned char arr[9]; } nd_rev_cust_code;

struct { unsigned short len; unsigned char arr[2]; } nd_repeat_grp_col;

struct { unsigned short len; unsigned char arr[20]; } nd_to_month_year;

struct { unsigned short len; unsigned char arr[100]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[21]; } d_curr_date;

struct { unsigned short len; unsigned char arr[16]; } d_physician_id;

struct { unsigned short len; unsigned char arr[16]; } d_prv_physician_id;

struct { unsigned short len; unsigned char arr[16]; } d_physician_name;

struct { unsigned short len; unsigned char arr[16]; } d_prv_physician_name;

struct { unsigned short len; unsigned char arr[16]; } d_rev_catg;

struct { unsigned short len; unsigned char arr[16]; } d_prv_rev_catg;

struct { unsigned short len; unsigned char arr[4]; } d_episode_type;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;
		    

	double	    d_hosp_revenue_amt,
		    d_doctor_share,
		    d_settled_amount,
			d_pre_settled_amount,
			d_cur_settled_amount,
		    d_billed_amt,
		    d_outst_billed_amt,
		    d_outst_unbilled_amt,
		    d_tot_outst_amt,

		    d_rt_hosp_revenue_amt,
		    d_rt_doctor_share,
		    d_rt_billed_amt,
		    d_rt_settled_amount,
			d_pre_rt_settled_amount,
			d_cur_rt_settled_amount,
		    d_rt_outst_billed_amt,
		    d_rt_outst_unbilled_amt,
		    d_rt_tot_outst_amt,

		    d_dt_hosp_revenue_amt,
		    d_dt_doctor_share,
		    d_dt_billed_amt,
		    d_dt_settled_amount,
			d_pre_dt_settled_amount,
			d_cur_dt_settled_amount,
		    d_dt_outst_billed_amt,
		    d_dt_outst_unbilled_amt,
		    d_dt_tot_outst_amt,
		    
		    d_gt_hosp_revenue_amt,
		    d_gt_doctor_share,
		    d_gt_billed_amt,
		    d_gt_settled_amount,
			d_pre_gt_settled_amount,
			d_cur_gt_settled_amount,
		    d_gt_outst_billed_amt,
		    d_gt_outst_unbilled_amt,
		    d_gt_tot_outst_amt;

	char loc_legend[999][201],
		
	     loc_legend90_1[201],
	     loc_legend90_2[201],
	     loc_legend100_1[201],
	     loc_legend100_2[201],
	     loc_legend110_1[201],
	     loc_legend110_2[201],	
	     loc_legend120_1[201],	
	     loc_legend120_2[201],	
	     loc_legend130_1[201],	
	     loc_legend130_2[201],
		 loc_legend135_1[201],	
	     loc_legend135_2[201];
	
	char l_mesg[200],
		g_facility_id[3],
		string_var[200];
	int i,page_no=0,lctr=0, l_line_cnt_for_dtl_rec = 0;
	char filename[500];

	int nd_from_month, nd_to_month, nd_from_year, nd_to_year;

	
	
	int len = 0, r_ctr = 0;

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

FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }


    strcpy(g_pgm_id,"DFR00007");
    strcpy(nd_pwd.arr,argv[1]);
    nd_pwd.len = strlen(nd_pwd.arr);
	 

    /* EXEC sql connect :nd_pwd; */ 

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

	set_meduser_role(); 	

    	strcpy(nd_curr_pgm_id.arr,g_pgm_id); 
    	nd_curr_pgm_id.len = strlen(nd_curr_pgm_id.arr); 

    	strcpy(nd_session_id.arr,argv[2]);
    	nd_session_id.len = strlen(nd_session_id.arr);
    	strcpy(g_session_id,nd_session_id.arr);

    	strcpy(nd_pgm_date.arr,argv[3]);
    	nd_pgm_date.len = strlen(nd_pgm_date.arr);
    	strcpy(g_pgm_date,nd_pgm_date.arr);

    	strcpy(nd_facility_id.arr,argv[4]);
    	nd_facility_id.len = strlen(nd_facility_id.arr);
    	strcpy(g_facility_id,nd_facility_id.arr);	
	
        open_files();
	get_sy_prog_param();
        fetch_legend_value();    
        declare_cur();
        get_header_dtls();

	fprintf(fp,"%c&l1O",ESC); 
	fprintf(fp,"%c&a2L",ESC); 	/* To Set the Left margin  */
	fprintf(fp,"%c(s16H",ESC); 

	print_first_page();	

	process_dtl();	

	end_of_rep();

	fprintf(fp,"%cE",ESC); /* To Reset the Printer */ 

	fclose(fp);
    
 }

 end_of_rep()  
{
	fprintf(fp,"\n%55s***  END OF REPORT ***\n\f"," ");
	fflush(fp);
}

 declare_cur()
 {

       /* EXEC SQL DECLARE DR_PAY_CUR CURSOR FOR
       SELECT a.physician_id physician_id,
       b.short_name physician_name,             
       c.short_desc revenue_category,              
       DECODE(:nd_episode_split_yn,'Y',DECODE(a.episode_type, 
                'E','EM', 'O','OP', 'D','DC', 'I','IP', 'R','EX'),  'All') Episode_Type,              
       sum(nvl(a.net_revenue_amt,0)) hosp_revenue_amt,
       sum(nvl(a.dr_revenue_amt,0)) dr_share_amt,         
       sum(decode(a.billed_flag,'Y',
		decode(greatest(To_Char(a.processing_year,'9999')||to_char(a.processing_month,'FM00'),
				To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00')),
		       To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00'),nvl(a.net_revenue_amt,0)
		       ,0)
	      ,0)) billed_amount,
       sum(decode(a.billed_flag,'Y',
		decode(greatest(To_Char(a.processing_year,'9999')||to_char(a.processing_month,'FM00'),
				To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00')),
		       To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00'),Decode (to_char(a.bill_doc_date ,'yyyy')||To_Char(a.bill_doc_date ,'MM'),LTrim(To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00')),0,nvl(a.settled_amt,0))
		       ,0)
	      ,0)) pre_sett_month,
		  sum(decode(a.billed_flag,'Y',
		decode(greatest(To_Char(a.processing_year,'9999')||to_char(a.processing_month,'FM00'),
				To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00')),
		       To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00'),Decode (to_char(a.bill_doc_date ,'yyyy')||To_Char(a.bill_doc_date ,'MM'),LTrim(To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00')),nvl(a.settled_amt,0),0)
		       ,0)
	      ,0)) cur_sett_month,
	   sum(decode(a.billed_flag,'Y',nvl(a.dr_revenue_amt,0)-decode(greatest(To_Char(a.processing_year,'9999')||to_char(a.processing_month,'FM00'),
				To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00')),
		       To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00'),Decode (to_char(a.bill_doc_date ,'yyyy')||To_Char(a.bill_doc_date ,'MM'),LTrim(To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00')),nvl(a.settled_amt,0),0)
		       ,0)
,0)) outst_billed_amt,
        sum(decode(a.billed_flag,'Y',nvl(a.dr_revenue_amt,0)-decode(greatest(To_Char(a.processing_year,'9999')||to_char(a.processing_month,'FM00'),
				To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00')),
		       To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00'),Decode (to_char(a.bill_doc_date ,'yyyy')||To_Char(a.bill_doc_date ,'MM'),LTrim(To_Char(:nd_to_year,'9999')||to_char(:nd_to_month,'FM00')),0,nvl(a.settled_amt,0))
		       ,0)
,0))   outst_unbilled_amt

FROM df_rev_folio_slmt_vw a,
     sy_physician_mast b,
     df_revenue_category c

WHERE a.operating_facility_id = :nd_facility_id
//AND a.processing_month BETWEEN :nd_from_month AND :nd_to_month
AND a.processing_year||TO_CHAR(a.processing_month,'FM00') 
               BETWEEN :nd_from_year||TO_CHAR(:nd_from_month,'FM00')
	       AND :nd_to_year||to_char(:nd_to_month,'FM00')   
AND a.physician_id BETWEEN NVL(:nd_from_doctor_id,'!!!!!!!!!!!!!!!') 
		   AND NVL(:nd_to_doctor_id,'~~~~~~~~~~~~~~~') 		  
AND a.revenue_category BETWEEN NVL(:nd_from_rev_catg_code,'!!!!!!!!!!') 
		     AND NVL(:nd_to_rev_catg_code,'~~~~~~~~~~') 
AND a.episode_type = decode(:nd_episode_type,'A',a.episode_type,:nd_episode_type)
AND nvl(a.df_trx_status,'X') != 'C'
AND b.facility_id = a.operating_facility_id
AND b.physician_id = a.physician_id
AND c.revenue_category = a.revenue_category
AND a.blng_grp_id  like :nd_blng_grp_id||'%'
AND NVL(a.revenue_cust_code,'X') like :nd_rev_cust_code||'%'
GROUP BY a.physician_id,
       b.short_name,
       c.short_desc,              
       DECODE(:nd_episode_split_yn,'Y',DECODE(a.episode_type, 
                'E','EM', 'O','OP', 'D','DC', 'I','IP', 'R','EX'),'All'),
       DECODE(a.episode_type,'E',1,'O',2,'D',3,'I',4,5)
order BY a.physician_id,
	 c.short_desc,
	 DECODE(a.episode_type,'E',1,'O',2,'D',3,'I',4,5); */ 


}

 process_dtl()
 { 
	open_dr_pay_cur();	

	while(fetch_dr_pay_cur())
	{		
		d_tot_outst_amt = d_outst_billed_amt + d_outst_unbilled_amt;

		if (d_prv_physician_id.arr[0] == '\0' && d_prv_rev_catg.arr[0] == '\0' )		  
		 {
			 print_rec1();
			
		 }
		else if (strcmp(d_physician_id.arr,d_prv_physician_id.arr) == 0 &&
			  strcmp(d_rev_catg.arr,d_prv_rev_catg.arr) == 0)
		 {
			if (l_line_cnt_for_dtl_rec == 1 || nd_repeat_grp_col.arr[0] == 'Y')
			{

				 print_rec1();
			}
			else
			{

				fprintf(fp,"%-15.15s %-15.15s %-17.17s %-10.10s ",			
				"","","",d_episode_type.arr);			

				print_rec2();
			}
		}
		else if (strcmp(d_physician_id.arr,d_prv_physician_id.arr) == 0 &&
			  strcmp(d_rev_catg.arr,d_prv_rev_catg.arr) != 0)
		 {				

				fprintf(fp, "%-15.15s %-15.15s %-17.17s %-10.10s",
					"","","","");					
				print_line('-',112);     							

				fprintf(fp, "%-15.15s %-10.10s %-20.20s-  %-10.10s ",
					"","",d_prv_rev_catg.arr,loc_legend[170]);					

				print_rev_tot();

				next_line(1);		

				fprintf(fp, "%-15.15s %-15.15s %-17.17s %-10.10s",
					"","","","");					
				print_line('-',112);     											
				


			if (l_line_cnt_for_dtl_rec == 1 || nd_repeat_grp_col.arr[0] == 'Y')
			{				
				 print_rec1();
			}
			else
			{
				fprintf(fp,"%-15.15s %-15.15s %-17.17s %-10.10s ",			
				"","",d_rev_catg.arr,d_episode_type.arr);			

				print_rec2();
			}
		}		
		else
		{		

			fprintf(fp, "%-15.15s %-15.15s %-17.17s %-10.10s",
					"","","","");					
			print_line('-',112);     						

			fprintf(fp, "%-15.15s %-10.10s %-20.20s-  %-10.10s ",
					"","",d_prv_rev_catg.arr,loc_legend[170]);					
			print_rev_tot();
					
			next_line(1);		

			fprintf(fp, "%-15.15s %-15.15s %-17.17s %-10.10s",
					"","","","");					
			print_line('-',112);     						
			
			

			fprintf(fp, "%-15.15s  %-32.32s %-10.10s ",
					"",loc_legend[180],"");					

			print_dr_tot();		
			
			next_line(1);		

			fprintf(fp, "%-15.15s %-15.15s %-17.17s %-10.10s",
					"","","","");					
			print_line('-',112);     						

			


			 print_rec1();

		}
		
		next_line(1);		

		d_rt_hosp_revenue_amt = d_rt_hosp_revenue_amt + d_hosp_revenue_amt;
		d_rt_doctor_share     = d_rt_doctor_share + d_doctor_share;
		d_rt_billed_amt	      = d_rt_billed_amt + d_billed_amt;
		d_rt_settled_amount   = d_rt_settled_amount + d_settled_amount;
		d_pre_rt_settled_amount   = d_pre_rt_settled_amount + d_pre_settled_amount;
		d_cur_rt_settled_amount   = d_cur_rt_settled_amount + d_cur_settled_amount;
		d_rt_outst_billed_amt = d_rt_outst_billed_amt + d_outst_billed_amt;
		d_rt_outst_unbilled_amt = d_rt_outst_unbilled_amt + d_outst_unbilled_amt;
		d_rt_tot_outst_amt = d_rt_tot_outst_amt + d_tot_outst_amt;

		d_dt_hosp_revenue_amt = d_dt_hosp_revenue_amt + d_hosp_revenue_amt;
		d_dt_doctor_share     = d_dt_doctor_share + d_doctor_share;
		d_dt_billed_amt	      = d_dt_billed_amt + d_billed_amt;
		d_dt_settled_amount   = d_dt_settled_amount + d_settled_amount;
		d_pre_dt_settled_amount   = d_pre_dt_settled_amount + d_pre_settled_amount;
		d_cur_dt_settled_amount   = d_cur_dt_settled_amount + d_cur_settled_amount;
		d_dt_outst_billed_amt = d_dt_outst_billed_amt + d_outst_billed_amt;
		d_dt_outst_unbilled_amt = d_dt_outst_unbilled_amt + d_outst_unbilled_amt;
		d_dt_tot_outst_amt = d_dt_tot_outst_amt + d_tot_outst_amt;

		d_gt_hosp_revenue_amt = d_gt_hosp_revenue_amt + d_hosp_revenue_amt;
		d_gt_doctor_share     = d_gt_doctor_share + d_doctor_share;
		d_gt_billed_amt	      = d_gt_billed_amt + d_billed_amt;
		d_gt_settled_amount   = d_gt_settled_amount + d_settled_amount;
		d_pre_gt_settled_amount   = d_pre_gt_settled_amount + d_pre_settled_amount;
		d_cur_gt_settled_amount   = d_cur_gt_settled_amount + d_cur_settled_amount;
		d_gt_outst_billed_amt = d_gt_outst_billed_amt + d_outst_billed_amt;
		d_gt_outst_unbilled_amt = d_gt_outst_unbilled_amt + d_outst_unbilled_amt;
		d_gt_tot_outst_amt = d_gt_tot_outst_amt + d_tot_outst_amt;

		strcpy(d_prv_physician_id.arr,d_physician_id.arr);
		d_prv_physician_id.len = strlen(d_prv_physician_id.arr);

		strcpy(d_prv_rev_catg.arr,d_rev_catg.arr);
		d_prv_rev_catg.len = strlen(d_prv_rev_catg.arr);
		
		strcpy(d_prv_physician_name.arr,d_physician_name.arr);
		d_prv_physician_name.len = strlen(d_prv_physician_name.arr);		
		
	
		l_line_cnt_for_dtl_rec = l_line_cnt_for_dtl_rec  + 1;
	}


		fprintf(fp, "%-15.15s %-15.15s %-17.17s %-10.10s",
					"","","","");					
			print_line('-',112);     						

			fprintf(fp, "%-15.15s %-10.10s %-20.20s-  %-10.10s ",
					"","",d_prv_rev_catg.arr,loc_legend[170]);					

			print_rev_tot();		

			next_line(1);		

			fprintf(fp, "%-15.15s %-15.15s %-17.17s %-10.10s",
					"","","","");					
			print_line('-',112);     					

			fprintf(fp, "%-15.15s  %-32.32s %-10.10s ",
					"",loc_legend[180],"");					

			print_dr_tot();		

			next_line(1);		

			fprintf(fp, "%-15.15s %-15.15s %-17.17s %-10.10s",
					"","","","");					
			print_line('-',112);     


			print_grand_tot();
			//next_line(1);		

			fprintf(fp, "\n%-15.15s %-15.15s %-17.17s %-10.10s",
					"","","","");					
			print_line_last('-',112);     			
			

 }

 print_grand_tot()
 {
	fprintf(fp, "%-10.10s  %-37.37s %-10.10s ",
					"",loc_legend[190],"");					
					print_formated(d_gt_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_gt_billed_amt);
					fprintf(fp," ");
					print_formated(d_gt_doctor_share);
					fprintf(fp," ");					
				/*	print_formated(d_gt_settled_amount);
					fprintf(fp," "); */
					print_formated(d_cur_gt_settled_amount);
					fprintf(fp," ");
					print_formated(d_pre_gt_settled_amount);
					fprintf(fp," ");
					print_formated(d_gt_outst_billed_amt);
					fprintf(fp," ");
					print_formated(d_gt_outst_unbilled_amt);
					fprintf(fp," ");
					print_formated(d_gt_tot_outst_amt);
 }

 print_dr_tot()
 {
					print_formated(d_dt_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_dt_billed_amt);
					fprintf(fp," ");
					print_formated(d_dt_doctor_share);
					fprintf(fp," "); 					
				/*	print_formated(d_dt_settled_amount);
					fprintf(fp," ");  */
					print_formated(d_cur_dt_settled_amount);
					fprintf(fp," ");
					print_formated(d_pre_dt_settled_amount);
					fprintf(fp," ");
					print_formated(d_dt_outst_billed_amt);
					fprintf(fp," ");
					print_formated(d_dt_outst_unbilled_amt);
					fprintf(fp," ");
					print_formated(d_dt_tot_outst_amt);

					d_dt_hosp_revenue_amt = 0;
					d_dt_doctor_share = 0;
					d_dt_billed_amt = 0;
					d_dt_settled_amount = 0;
					d_pre_dt_settled_amount = 0;
					d_cur_dt_settled_amount = 0;
					d_dt_outst_billed_amt = 0;
					d_dt_outst_unbilled_amt = 0;
					d_dt_tot_outst_amt = 0;
 }

 print_rev_tot()
 {
					print_formated(d_rt_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_rt_billed_amt);
					fprintf(fp," ");
					print_formated(d_rt_doctor_share);
					fprintf(fp," ");					
				/*	print_formated(d_rt_settled_amount);
					fprintf(fp," ");   */
					
					print_formated(d_cur_rt_settled_amount);
					fprintf(fp," ");
					print_formated(d_pre_rt_settled_amount);
					fprintf(fp," ");
					print_formated(d_rt_outst_billed_amt);
					fprintf(fp," ");
					print_formated(d_rt_outst_unbilled_amt);
					fprintf(fp," ");
					print_formated(d_rt_tot_outst_amt);

					d_rt_hosp_revenue_amt = 0;
					d_rt_doctor_share = 0;
					d_rt_billed_amt = 0;
					d_rt_settled_amount = 0;
					d_pre_rt_settled_amount = 0;
					d_cur_rt_settled_amount = 0;
					d_rt_outst_billed_amt = 0;
					d_rt_outst_unbilled_amt = 0;
					d_rt_tot_outst_amt = 0;
 }

 print_rec1()
 {
		fprintf(fp,"%-15.15s %-15.15s %-17.17s %-10.10s ",			
			d_physician_id.arr,d_physician_name.arr,
			d_rev_catg.arr,d_episode_type.arr);			

			print_formated(d_hosp_revenue_amt);
			fprintf(fp," ");
			print_formated(d_billed_amt);
			fprintf(fp," ");
			print_formated(d_doctor_share);
			fprintf(fp," ");			
		/*	print_formated(d_settled_amount);
			fprintf(fp," ");  */
			
			print_formated(d_cur_settled_amount);
			fprintf(fp," ");
			print_formated(d_pre_settled_amount);
			fprintf(fp," ");
			print_formated(d_outst_billed_amt);
			fprintf(fp," ");
			print_formated(d_outst_unbilled_amt);
			fprintf(fp," ");
			print_formated(d_tot_outst_amt);
 }

print_rec2()
{
			print_formated(d_hosp_revenue_amt);
			fprintf(fp," ");
			print_formated(d_billed_amt);
			fprintf(fp," ");
			print_formated(d_doctor_share);
			fprintf(fp," ");			
		/*	print_formated(d_settled_amount);
			fprintf(fp," "); */
			
			print_formated(d_cur_settled_amount);
			fprintf(fp," ");
			print_formated(d_pre_settled_amount);
			fprintf(fp," ");
			print_formated(d_outst_billed_amt);
			fprintf(fp," ");
			print_formated(d_outst_unbilled_amt);
			fprintf(fp," ");
			print_formated(d_tot_outst_amt);

}

print_formated(loc_amount)
double loc_amount;
{
    char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
	strcat(s_amt," CR");
        sprintf(str_amt,"%13s",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%13s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%13s",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%13s",str_amt);
    }

}

open_dr_pay_cur() 
{
	/* EXEC SQL OPEN DR_PAY_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.physician_id physician_id ,b.short_name physician_name ,c.short\
_desc revenue_category ,DECODE(:b0,'Y',DECODE(a.episode_type,'E','EM','O','O\
P','D','DC','I','IP','R','EX'),'All') Episode_Type ,sum(nvl(a.net_revenue_am\
t,0)) hosp_revenue_amt ,sum(nvl(a.dr_revenue_amt,0)) dr_share_amt ,sum(decod\
e(a.billed_flag,'Y',decode(greatest((To_Char(a.processing_year,'9999')||to_c\
har(a.processing_month,'FM00')),(To_Char(:b1,'9999')||to_char(:b2,'FM00'))),\
(To_Char(:b1,'9999')||to_char(:b2,'FM00')),nvl(a.net_revenue_amt,0),0),0)) b\
illed_amount ,sum(decode(a.billed_flag,'Y',decode(greatest((To_Char(a.proces\
sing_year,'9999')||to_char(a.processing_month,'FM00')),(To_Char(:b1,'9999')|\
|to_char(:b2,'FM00'))),(To_Char(:b1,'9999')||to_char(:b2,'FM00')),Decode((to\
_char(a.bill_doc_date,'yyyy')||To_Char(a.bill_doc_date,'MM')),LTrim((To_Char\
(:b1,'9999')||to_char(:b2,'FM00'))),0,nvl(a.settled_amt,0)),0),0)) pre_sett_\
month ,sum(decode(a.billed_flag,'Y',decode(greatest((To_Char(a.processing_ye\
ar,'9999')||to_char(a.processing_month,'");
 sqlbuft((void **)0, 
   "FM00')),(To_Char(:b1,'9999')||to_char(:b2,'FM00'))),(To_Char(:b1,'9999')\
||to_char(:b2,'FM00')),Decode((to_char(a.bill_doc_date,'yyyy')||To_Char(a.bi\
ll_doc_date,'MM')),LTrim((To_Char(:b1,'9999')||to_char(:b2,'FM00'))),nvl(a.s\
ettled_amt,0),0),0),0)) cur_sett_month ,sum(decode(a.billed_flag,'Y',(nvl(a.\
dr_revenue_amt,0)-decode(greatest((To_Char(a.processing_year,'9999')||to_cha\
r(a.processing_month,'FM00')),(To_Char(:b1,'9999')||to_char(:b2,'FM00'))),(T\
o_Char(:b1,'9999')||to_char(:b2,'FM00')),Decode((to_char(a.bill_doc_date,'yy\
yy')||To_Char(a.bill_doc_date,'MM')),LTrim((To_Char(:b1,'9999')||to_char(:b2\
,'FM00'))),nvl(a.settled_amt,0),0),0)),0)) outst_billed_amt ,sum(decode(a.bi\
lled_flag,'Y',(nvl(a.dr_revenue_amt,0)-decode(greatest((To_Char(a.processing\
_year,'9999')||to_char(a.processing_month,'FM00')),(To_Char(:b1,'9999')||to_\
char(:b2,'FM00'))),(To_Char(:b1,'9999')||to_char(:b2,'FM00')),Decode((to_cha\
r(a.bill_doc_date,'yyyy')||To_Char(a.bill_doc_date,'MM')),LTrim((To_Char(:b1\
,'9999')||to_char(:b2,'FM00'))),0,nvl(a.");
 sqlbuft((void **)0, 
   "settled_amt,0)),0)),0)) outst_unbilled_amt  from df_rev_folio_slmt_vw a \
,sy_physician_mast b ,df_revenue_category c where ((((((((((a.operating_faci\
lity_id=:b29 and (a.processing_year||TO_CHAR(a.processing_month,'FM00')) bet\
ween (:b30||TO_CHAR(:b31,'FM00')) and (:b1||to_char(:b2,'FM00'))) and a.phys\
ician_id between NVL(:b34,'!!!!!!!!!!!!!!!') and NVL(:b35,'~~~~~~~~~~~~~~~')\
) and a.revenue_category between NVL(:b36,'!!!!!!!!!!') and NVL(:b37,'~~~~~~\
~~~~')) and a.episode_type=decode(:b38,'A',a.episode_type,:b38)) and nvl(a.d\
f_trx_status,'X')<>'C') and b.facility_id=a.operating_facility_id) and b.phy\
sician_id=a.physician_id) and c.revenue_category=a.revenue_category) and a.b\
lng_grp_id like (:b40||'%')) and NVL(a.revenue_cust_code,'X') like (:b41||'%\
')) group by a.physician_id,b.short_name,c.short_desc,DECODE(:b0,'Y',DECODE(\
a.episode_type,'E','EM','O','OP','D','DC','I','IP','R','EX'),'All'),DECODE(a\
.episode_type,'E',1,'O',2,'D',3,'I',4,5) order by a.physician_id,c.short_des\
c,DECODE(a.episode_type,'E',1,'O',2,'D',");
 sqlstm.stmt = sq0002;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_episode_split_yn;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[15] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[16] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[17] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[18] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[19] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[20] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[21] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[22] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[23] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[24] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[25] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[26] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[27] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[28] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[29] = (unsigned int  )5;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&nd_from_year;
 sqlstm.sqhstl[30] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)&nd_from_month;
 sqlstm.sqhstl[31] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[31] = (         int  )0;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
 sqlstm.sqhstv[32] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[32] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[32] = (         int  )0;
 sqlstm.sqindv[32] = (         void  *)0;
 sqlstm.sqinds[32] = (         int  )0;
 sqlstm.sqharm[32] = (unsigned int  )0;
 sqlstm.sqadto[32] = (unsigned short )0;
 sqlstm.sqtdso[32] = (unsigned short )0;
 sqlstm.sqhstv[33] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[33] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[33] = (         int  )0;
 sqlstm.sqindv[33] = (         void  *)0;
 sqlstm.sqinds[33] = (         int  )0;
 sqlstm.sqharm[33] = (unsigned int  )0;
 sqlstm.sqadto[33] = (unsigned short )0;
 sqlstm.sqtdso[33] = (unsigned short )0;
 sqlstm.sqhstv[34] = (         void  *)&nd_from_doctor_id;
 sqlstm.sqhstl[34] = (unsigned int  )18;
 sqlstm.sqhsts[34] = (         int  )0;
 sqlstm.sqindv[34] = (         void  *)0;
 sqlstm.sqinds[34] = (         int  )0;
 sqlstm.sqharm[34] = (unsigned int  )0;
 sqlstm.sqadto[34] = (unsigned short )0;
 sqlstm.sqtdso[34] = (unsigned short )0;
 sqlstm.sqhstv[35] = (         void  *)&nd_to_doctor_id;
 sqlstm.sqhstl[35] = (unsigned int  )18;
 sqlstm.sqhsts[35] = (         int  )0;
 sqlstm.sqindv[35] = (         void  *)0;
 sqlstm.sqinds[35] = (         int  )0;
 sqlstm.sqharm[35] = (unsigned int  )0;
 sqlstm.sqadto[35] = (unsigned short )0;
 sqlstm.sqtdso[35] = (unsigned short )0;
 sqlstm.sqhstv[36] = (         void  *)&nd_from_rev_catg_code;
 sqlstm.sqhstl[36] = (unsigned int  )13;
 sqlstm.sqhsts[36] = (         int  )0;
 sqlstm.sqindv[36] = (         void  *)0;
 sqlstm.sqinds[36] = (         int  )0;
 sqlstm.sqharm[36] = (unsigned int  )0;
 sqlstm.sqadto[36] = (unsigned short )0;
 sqlstm.sqtdso[36] = (unsigned short )0;
 sqlstm.sqhstv[37] = (         void  *)&nd_to_rev_catg_code;
 sqlstm.sqhstl[37] = (unsigned int  )13;
 sqlstm.sqhsts[37] = (         int  )0;
 sqlstm.sqindv[37] = (         void  *)0;
 sqlstm.sqinds[37] = (         int  )0;
 sqlstm.sqharm[37] = (unsigned int  )0;
 sqlstm.sqadto[37] = (unsigned short )0;
 sqlstm.sqtdso[37] = (unsigned short )0;
 sqlstm.sqhstv[38] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[38] = (unsigned int  )4;
 sqlstm.sqhsts[38] = (         int  )0;
 sqlstm.sqindv[38] = (         void  *)0;
 sqlstm.sqinds[38] = (         int  )0;
 sqlstm.sqharm[38] = (unsigned int  )0;
 sqlstm.sqadto[38] = (unsigned short )0;
 sqlstm.sqtdso[38] = (unsigned short )0;
 sqlstm.sqhstv[39] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[39] = (unsigned int  )4;
 sqlstm.sqhsts[39] = (         int  )0;
 sqlstm.sqindv[39] = (         void  *)0;
 sqlstm.sqinds[39] = (         int  )0;
 sqlstm.sqharm[39] = (unsigned int  )0;
 sqlstm.sqadto[39] = (unsigned short )0;
 sqlstm.sqtdso[39] = (unsigned short )0;
 sqlstm.sqhstv[40] = (         void  *)&nd_blng_grp_id;
 sqlstm.sqhstl[40] = (unsigned int  )8;
 sqlstm.sqhsts[40] = (         int  )0;
 sqlstm.sqindv[40] = (         void  *)0;
 sqlstm.sqinds[40] = (         int  )0;
 sqlstm.sqharm[40] = (unsigned int  )0;
 sqlstm.sqadto[40] = (unsigned short )0;
 sqlstm.sqtdso[40] = (unsigned short )0;
 sqlstm.sqhstv[41] = (         void  *)&nd_rev_cust_code;
 sqlstm.sqhstl[41] = (unsigned int  )11;
 sqlstm.sqhsts[41] = (         int  )0;
 sqlstm.sqindv[41] = (         void  *)0;
 sqlstm.sqinds[41] = (         int  )0;
 sqlstm.sqharm[41] = (unsigned int  )0;
 sqlstm.sqadto[41] = (unsigned short )0;
 sqlstm.sqtdso[41] = (unsigned short )0;
 sqlstm.sqhstv[42] = (         void  *)&nd_episode_split_yn;
 sqlstm.sqhstl[42] = (unsigned int  )4;
 sqlstm.sqhsts[42] = (         int  )0;
 sqlstm.sqindv[42] = (         void  *)0;
 sqlstm.sqinds[42] = (         int  )0;
 sqlstm.sqharm[42] = (unsigned int  )0;
 sqlstm.sqadto[42] = (unsigned short )0;
 sqlstm.sqtdso[42] = (unsigned short )0;
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
		err_mesg("OPEN failed on cursor DR_PAY_CUR",0,"");

}



fetch_dr_pay_cur()
{
	d_physician_id.arr[0] = '\0';
	d_physician_name.arr[0] = '\0';
	d_rev_catg.arr[0] = '\0';
	d_episode_type.arr[0] = '\0';
	
	d_physician_id.len = 0;
	d_physician_name.len = 0;
	d_rev_catg.len = 0;
	d_episode_type.len = 0;	

	/* EXEC SQL FETCH DR_PAY_CUR
             INTO :d_physician_id, 
		  :d_physician_name,
		  :d_rev_catg,
		  :d_episode_type,
		  :d_hosp_revenue_amt,
		  :d_doctor_share,
		  :d_billed_amt,
		  :d_pre_settled_amount,
		  :d_cur_settled_amount,
		  :d_outst_billed_amt,
		  :d_outst_unbilled_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )223;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_physician_id;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_physician_name;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_rev_catg;
 sqlstm.sqhstl[2] = (unsigned int  )18;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[3] = (unsigned int  )6;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_hosp_revenue_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_doctor_share;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_billed_amt;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_pre_settled_amount;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_cur_settled_amount;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_outst_billed_amt;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_outst_unbilled_amt;
 sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
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
		err_mesg("FETCH failed on cursor DR_PAY_CUR ",0,"");

	d_physician_id.arr[d_physician_id.len] = '\0';
	d_physician_name.arr[d_physician_name.len] = '\0';
	d_rev_catg.arr[d_rev_catg.len] = '\0';
	d_episode_type.arr[d_episode_type.len] = '\0';	

	return(LAST_ROW?0:1);
}

close_dr_pay_cur()
{
	/* EXEC SQL CLOSE DR_PAY_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )282;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}



 print_first_page()
{
	print_page_title();
        fprintf(fp,"\nVER : 4.1\n");
   	fprintf(fp,"\n\n\n      INPUT PARAMETERS :\n");
	fprintf(fp,"      ----------------\n");  	

	fprintf(fp,"%35s : %-d/%-d\n",  "Period From",nd_from_month,nd_from_year);
	fprintf(fp,"%35s : %-d/%-d\n\n","         To",nd_to_month,nd_to_year);

	fprintf(fp,"%35s : %-s\n",  "Doctor Id From",nd_from_doctor_id.arr);
	fprintf(fp,"%35s : %-s\n\n","            To",nd_to_doctor_id.arr);

	fprintf(fp,"%35s : %-s\n",  "Revenue Category From",nd_from_rev_catg_code.arr);
	fprintf(fp,"%35s : %-s\n\n","                   To",nd_to_rev_catg_code.arr);
	
	fprintf(fp,"%35s : ","Episode Type");
	

	if ( nd_episode_type.arr[0] == 'A') 
		fprintf(fp,"%-s","All");
	else if ( nd_episode_type.arr[0] == 'E') 
		fprintf(fp,"%-s","Emergency");
	else if ( nd_episode_type.arr[0] == 'O') 
		fprintf(fp,"%-s","Outpatient");	
	else if ( nd_episode_type.arr[0] == 'D') 
		fprintf(fp,"%-s","Daycare");
	else if ( nd_episode_type.arr[0] == 'I') 
		fprintf(fp,"%-s","Inpatient");
	else if ( nd_episode_type.arr[0] == 'R') 
		fprintf(fp,"%-s","External");

	fprintf(fp,"\n\n");
	
	fprintf(fp,"%35s : %-s\n\n",  "Episode Split",nd_episode_split_yn.arr);
	fprintf(fp,"%35s : %-s\n\n",  "Billing Group",nd_blng_grp_id.arr);
	fprintf(fp,"%35s : %-s\n\n",  "Revenue Customer",nd_rev_cust_code.arr);
	fprintf(fp,"%35s : %-s\n\n",  "Repeat Grouped Columns",nd_repeat_grp_col.arr);	
	
        next_page();  
  

}

next_page() 
{
  
	fprintf(fp,"\n");
	fprintf(fp,"\f");
	lctr=0;
	fprintf(fp,"\n"); 

	l_line_cnt_for_dtl_rec = 1;

	// Used for Sub-title - printing to first line each page
	 
	print_page_title();
	print_column_title();  	
	
	
}

print_column_title()
 {



      fprintf(fp,"%-15.15s %-15.15s %-17.17s %-10.10s %13.13s %13.13s %13.13s %13.13s %13.13s     %-s ",
      loc_legend[60],loc_legend[70],loc_legend[80],loc_legend90_1,loc_legend100_1,loc_legend120_1,loc_legend110_1,loc_legend130_1,loc_legend135_1,loc_legend[140]);
 
      next_line(1);

      fprintf(fp,"%-15.15s %-15.15s %-17.17s %-10.10s %13.13s %13.13s %13.13s %13.13s %13.13s %13.13s %13.13s %13.13s ",
      "","","",loc_legend90_2,loc_legend100_2,loc_legend120_2,loc_legend110_2,loc_legend130_2,loc_legend135_2,loc_legend[150],loc_legend[160],loc_legend[170]);


      next_line(1);
      print_line('-',REP_WIDTH);         


 }


 open_files()
 {

	strcpy(filename,WORKING_DIR);
	strcat(filename,"DFR00007.lis");

	if ((fp = fopen(filename,"w")) == NULL)
	{
		disp_message(ERR_MESG,"Error in opening file DFR00007.lis");
		proc_exit();
	}

 }

 get_sy_prog_param()
 {	
	nd_from_doctor_id.arr[0] = '\0';
	nd_to_doctor_id.arr[0] = '\0';
	nd_from_rev_catg_code.arr[0] = '\0';
	nd_to_rev_catg_code.arr[0] = '\0';	
	nd_episode_type.arr[0] = '\0';	
	nd_episode_split_yn.arr[0] = '\0';
	nd_blng_grp_id.arr[0] = '\0';
	nd_rev_cust_code.arr[0] = '\0';
	nd_repeat_grp_col.arr[0] = '\0';
	nd_to_month_year.arr[0] = '\0';

	nd_from_doctor_id.len = 0;
	nd_to_doctor_id.len = 0;
	nd_from_rev_catg_code.len = 0;
	nd_to_rev_catg_code.len = 0;
	nd_episode_type.len = 0;
	nd_episode_split_yn.len = 0;
	nd_blng_grp_id.len = 0;
	nd_rev_cust_code.len = 0;
	nd_repeat_grp_col.len = 0;
	nd_to_month_year.len = 0;
			
        /* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,
			PARAM7,PARAM8,PARAM9,PARAM10, PARAM11,
			PARAM12,PARAM13,
			LPAD(PARAM2,2,'0')||'/'||PARAM4
		 INTO	:nd_from_month, 
			:nd_to_month,
			:nd_from_year, 
			:nd_to_year,
			:nd_from_doctor_id,
			:nd_to_doctor_id,
			:nd_from_rev_catg_code,
			:nd_to_rev_catg_code,			
			:nd_episode_type,
			:nd_episode_split_yn,
			:nd_blng_grp_id,
			:nd_rev_cust_code,
			:nd_repeat_grp_col,
			:nd_to_month_year
		FROM SY_PROG_PARAM
                WHERE PGM_ID   = :nd_curr_pgm_id
                AND SESSION_ID = :nd_session_id
                AND PGM_DATE   = :nd_pgm_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 43;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6\
 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,((LPAD(PARAM2,2,\
'0')||'/')||PARAM4) into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b1\
2,:b13  from SY_PROG_PARAM where ((PGM_ID=:b14 and SESSION_ID=:b15) and PGM_DA\
TE=:b16)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )297;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_from_month;
        sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_to_month;
        sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_from_year;
        sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_to_year;
        sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&nd_from_doctor_id;
        sqlstm.sqhstl[4] = (unsigned int  )18;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&nd_to_doctor_id;
        sqlstm.sqhstl[5] = (unsigned int  )18;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&nd_from_rev_catg_code;
        sqlstm.sqhstl[6] = (unsigned int  )13;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&nd_to_rev_catg_code;
        sqlstm.sqhstl[7] = (unsigned int  )13;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&nd_episode_type;
        sqlstm.sqhstl[8] = (unsigned int  )4;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&nd_episode_split_yn;
        sqlstm.sqhstl[9] = (unsigned int  )4;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&nd_blng_grp_id;
        sqlstm.sqhstl[10] = (unsigned int  )8;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&nd_rev_cust_code;
        sqlstm.sqhstl[11] = (unsigned int  )11;
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&nd_repeat_grp_col;
        sqlstm.sqhstl[12] = (unsigned int  )4;
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&nd_to_month_year;
        sqlstm.sqhstl[13] = (unsigned int  )22;
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
        sqlstm.sqhstv[14] = (         void  *)&nd_curr_pgm_id;
        sqlstm.sqhstl[14] = (unsigned int  )17;
        sqlstm.sqhsts[14] = (         int  )0;
        sqlstm.sqindv[14] = (         void  *)0;
        sqlstm.sqinds[14] = (         int  )0;
        sqlstm.sqharm[14] = (unsigned int  )0;
        sqlstm.sqadto[14] = (unsigned short )0;
        sqlstm.sqtdso[14] = (unsigned short )0;
        sqlstm.sqhstv[15] = (         void  *)&nd_session_id;
        sqlstm.sqhstl[15] = (unsigned int  )18;
        sqlstm.sqhsts[15] = (         int  )0;
        sqlstm.sqindv[15] = (         void  *)0;
        sqlstm.sqinds[15] = (         int  )0;
        sqlstm.sqharm[15] = (unsigned int  )0;
        sqlstm.sqadto[15] = (unsigned short )0;
        sqlstm.sqtdso[15] = (unsigned short )0;
        sqlstm.sqhstv[16] = (         void  *)&nd_pgm_date;
        sqlstm.sqhstl[16] = (unsigned int  )27;
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



	if (OERROR)
		err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

	if (NODATAFOUND)
		err_mesg("No Record found in SY_PROG_PARAM",0,"");
	


	nd_from_doctor_id.arr[nd_from_doctor_id.len] = '\0';
	nd_to_doctor_id.arr[nd_to_doctor_id.len] = '\0';
	nd_from_rev_catg_code.arr[nd_from_rev_catg_code.len] = '\0';
	nd_to_rev_catg_code.arr[nd_to_rev_catg_code.len] = '\0';	
	nd_episode_type.arr[nd_episode_type.len] = '\0';	
	nd_episode_split_yn.arr[nd_episode_split_yn.len] = '\0';
	nd_blng_grp_id.arr[nd_blng_grp_id.len] = '\0';
	nd_rev_cust_code.arr[nd_rev_cust_code.len] = '\0';
	nd_repeat_grp_col.arr[nd_repeat_grp_col.len] = '\0';
	nd_to_month_year.arr[nd_to_month_year.len] = '\0';


	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :nd_curr_pgm_id
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION_I\
D=:b1) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )380;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_curr_pgm_id;
 sqlstm.sqhstl[0] = (unsigned int  )17;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[2] = (unsigned int  )27;
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
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");   
}


fetch_legend_value()
{
	
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('DFR00007.LEGEND_'||
				LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		         INTO :l_pk_value
			 FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 43;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('DFR00007.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )407;
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
			blcommon.get_local_lang_desc(
				:nd_facility_id,
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
  sqlstm.arrsiz = 43;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )430;
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


	// WRAP

	r_ctr = 0;
	if (strlen(loc_legend[90]) > 0)
		split_text(loc_legend[90],10,loc_legend90_1,&r_ctr);
	if (strlen(loc_legend[90]) >= 10)	
		split_text(loc_legend[90],10,loc_legend90_2,&r_ctr);

	r_ctr = 0;
	if (strlen(loc_legend[100]) > 0)
		split_text(loc_legend[100],15,loc_legend100_1,&r_ctr);
	if (strlen(loc_legend[100]) >= 15)	
		split_text(loc_legend[100],15,loc_legend100_2,&r_ctr);

	r_ctr = 0;
	if (strlen(loc_legend[110]) > 0)
		split_text(loc_legend[110],15,loc_legend110_1,&r_ctr);
	if (strlen(loc_legend[110]) >= 15)	
		split_text(loc_legend[110],15,loc_legend110_2,&r_ctr);
	
	r_ctr = 0;
	if (strlen(loc_legend[120]) > 0)
		split_text(loc_legend[120],15,loc_legend120_1,&r_ctr);
	if (strlen(loc_legend[120]) >= 15)	
		split_text(loc_legend[120],15,loc_legend120_2,&r_ctr);
	
	r_ctr = 0;

	if (strlen(loc_legend[130]) > 0)
		split_text(loc_legend[130],15,loc_legend130_1,&r_ctr);

	if (strlen(loc_legend[130]) >= 15)	
		split_text(loc_legend[130],15,loc_legend130_2,&r_ctr);
		r_ctr = 0;
	if (strlen(loc_legend[135]) > 0)
		split_text(loc_legend[135],15,loc_legend135_1,&r_ctr);
	if (strlen(loc_legend[135]) >= 15)	
		split_text(loc_legend[135],15,loc_legend135_2,&r_ctr);


}

next_line(skip) /* will check for MAX LINE before printing totals */		
int skip;
 {
	if ((lctr + skip) >= MAX_LINES)
	{
		next_page(); 
	}
	else
	{
		fprintf(fp,"\n"); ++lctr; 
		        /*     fprintf(fp,"LNNO:%2d",lno); */
	}
 }
        


print_page_title()
  {

	int hosp_nm_len,date1_len, rep_title_len = 10,
	    s1, s2,date_len,user_len,
	    pgm_len,sub_title_len;

	char v_rep_title[200],v_as_on_date[12],v_sub_title[200],v_title[200],
	     v_title1[200];
   
	fprintf(fp,"%3.3s : DF",loc_legend[10]);
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(fp,"%s", d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	date1_len=4; //strlen(loc_legend[40]);
	horz_skip(s2-date1_len-13);
	fprintf(fp,"%4.4s : %s", loc_legend[40],d_curr_date.arr);
    
	next_line(1);
	
	fprintf(fp,"%3.3s : %s", loc_legend[20],d_user.arr); 	 
	

	next_line(1);

	fprintf(fp,"%3.3s : %s",loc_legend[30],nd_curr_pgm_id.arr);
        pgm_len=strlen(nd_curr_pgm_id.arr);	
	
	strcpy(v_sub_title,loc_legend[200]);
	sub_title_len = strlen(v_sub_title);

	strcat(v_sub_title," ");
	sub_title_len = strlen(v_sub_title);

	strcat(v_sub_title,nd_to_month_year.arr);
	sub_title_len = strlen(v_sub_title);


	s1 = (REP_WIDTH-sub_title_len)/2;
   	horz_skip(s1-pgm_len-6);
        fprintf(fp,"%s",v_sub_title);

        s2 = (REP_WIDTH-s1-sub_title_len);
	horz_skip(s2-17);
	fprintf(fp,"%4.4s : %-10d",loc_legend[50],++page_no);
	next_line(1);  
   
	lctr = 3;
	print_line('-',REP_WIDTH); 
	//next_line(1);

}


get_header_dtls()
{
	d_acc_entity_name.arr[0] = '\0';
	d_user.arr[0] = '\0';
	d_curr_date.arr[0] = '\0';

	d_acc_entity_name.len = 0;
	d_user.len = 0;
	d_curr_date.len = 0;

	/* EXEC SQL SELECT acc_entity_name, user, to_char(sysdate, 'DD/MM/YYYY')
	INTO :d_acc_entity_name,:d_user, :d_curr_date
        FROM SY_ACC_ENTITY
	WHERE acc_entity_id = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 43;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select acc_entity_name ,user ,to_char(sysdate,'DD/MM/YYYY') \
into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )461;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
 sqlstm.sqhstl[0] = (unsigned int  )102;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_user;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_curr_date;
 sqlstm.sqhstl[2] = (unsigned int  )23;
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
		err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	if (NODATAFOUND)
		err_mesg("No Record found in SY_ACC_ENTITY",0,"");

	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len] = '\0';
	d_curr_date.arr[d_curr_date.len] = '\0';

}

print_line(ch,n) /* this is to obtain required characters */
  char ch;
	int n;
	{
		if ((lctr + 1) >= MAX_LINES)
		{
			next_page(); 
		}
		else
		{
			int i;
			for(i=0;i<n;i++)
			fprintf(fp,"%c",ch);  fprintf(fp,"\n");++lctr;
		}

	}




print_line_last(ch,n) /* this is to obtain required characters */
  char ch;
	int n;
	{
		
	
			int i;
			for(i=0;i<n;i++)
			fprintf(fp,"%c",ch);  fprintf(fp,"\n");++lctr;
	

	}
	

     
horz_skip(num) /* this is to obtain required blank space */
int num;
	{
	int i;
	for(i=0;i<num;i++)fprintf(fp," ");
	}
