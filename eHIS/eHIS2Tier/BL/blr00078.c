
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
           char  filnam[32];
};
static const struct sqlcxp sqlfpn =
{
    31,
    "C:\\TEMP\\proc\\CRF515\\blr00078.pc"
};


static unsigned long sqlctx = 1278299445;


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
            void  *sqhstv[6];
   unsigned int   sqhstl[6];
            int   sqhsts[6];
            void  *sqindv[6];
            int   sqinds[6];
   unsigned int   sqharm[6];
   unsigned int   *sqharc[6];
   unsigned short  sqadto[6];
   unsigned short  sqtdso[6];
} sqlstm = {10,6};

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

 static const char *sq0007 = 
"select to_char(a.VR_DATE,'dd/mm/yyyy') ,((((to_char(a.VR_DATE,'dd/mm/yyyy')\
||' ')||'(')||a.RECOUPED_VR_NO)||')') ,'251' LEGEND_DEPT ,a.DOC_AMT ,to_char(\
a.DOC_DATE,'dd/mm/yyyy')  from BL_CASH_REFUND_CYCLE_TRN a ,BL_CASH_REFUND_CAS\
HBOOK_CB B where ((((((a.operating_facility_id=:b0 and a.operating_facility_i\
d=b.operating_facility_id) and a.RECOUPED_VR_NO=b.CB_RECOUPED_VR_NO) and a.OB\
_TRN_YN='N') and a.RECOUPED_VR_NO is  not null ) and trunc(b.CB_DATE)<=trunc(\
to_date(:b1,'DD/MM/YYYY'))) and (nvl(a.CHQ_RECEIVED_YN,'N')='N' or (nvl(a.CHQ\
_RECEIVED_YN,'N')='Y' and trunc(a.CHQ_RECEIVED_DATE)>trunc(to_date(:b1,'DD/MM\
/YYYY')))))           ";

 static const char *sq0008 = 
"select to_char(VR_DATE,'dd/mm/yyyy') ,((((to_char(VR_DATE,'dd/mm/yyyy')||' \
')||'(')||RECOUPED_VR_NO)||')') vno ,((((('('||' ')||chq_no)||' ')||TO_CHAR(c\
hq_date,'DD\\MM\\YYYY'))||')') chkno ,'251' LEGEND_DEPT ,DOC_AMT ,DOC_DATE  f\
rom bl_cash_refund_cycle_trn where (((operating_facility_id=:b0 and nvl(CHQ_R\
ECEIVED_YN,'N')='Y') and CHQ_RECEIVED_DATE<=trunc(to_date(:b1,'DD/MM/YYYY')))\
 and (nvl(CHQ_CLEARED_YN,'N')='N' or (nvl(CHQ_CLEARED_YN,'N')='Y' and CHQ_CLE\
ARED_DATE>=trunc(to_date(:b1,'DD/MM/YYYY')))))           ";

 static const char *sq0009 = 
"select to_char(doc_date,'dd/mm/yyyy') ,null  ,'251' LEGEND_DEPT ,abs(doc_am\
t) ,null   from bl_recpt_refund_can_bou_dtl_vw where ((((operating_facility_i\
d=:b0 and doc_date>=TO_DATE((NVL(:b1,'01/01/1900')||' 00:00:00'),'DD/MM/YYYY \
HH24:MI:SS')) and doc_date<=NVL(TO_DATE((:b2||' 23:59:59'),'DD/MM/YYYY HH24:M\
I:SS'),SYSDATE)) and RECPT_REFUND_IND='F') and cash_slmt_flag='Y') order by d\
oc_date            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,206,0,0,0,0,0,1,0,
20,0,0,2,111,0,4,226,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
55,0,0,3,84,0,2,246,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
82,0,0,4,198,0,4,265,0,0,6,1,0,1,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,1,9,
0,0,
121,0,0,5,79,0,4,294,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
144,0,0,6,321,0,4,303,0,0,4,3,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
175,0,0,7,636,0,9,383,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
202,0,0,7,0,0,15,392,0,0,0,0,0,1,0,
217,0,0,8,515,0,9,400,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
244,0,0,8,0,0,15,409,0,0,0,0,0,1,0,
259,0,0,9,402,0,9,417,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
286,0,0,9,0,0,15,426,0,0,0,0,0,1,0,
301,0,0,7,0,0,13,449,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
336,0,0,8,0,0,13,487,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,
0,0,
375,0,0,9,0,0,13,525,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
410,0,0,10,117,0,4,986,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
441,0,0,11,103,0,4,993,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
468,0,0,12,0,0,27,1029,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
499,0,0,13,96,0,4,1119,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
522,0,0,14,162,0,6,1126,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00078.PC                                  */
/* AUTHOR                : Robert Joseph                               */  
/* DATE WRITTEN          : 27/06/2005                                   */      
/************************************************************************/
     


#include <stdio.h>         
#include <string.h> 
#include <bl.h>       
#include <math.h> 

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define MAX_LINES 57
#define REP_WIDTH 80
#define LENGTH_WORDS 80
#define ESC  0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            date_time                                  [20],
            user_id                                    [91],
			nd_pwd									   [91],
            nd_session_id                              [16],
            nd_pgm_date                                [25],
            d_curr_pgm_name                            [15],
			nd_facility 							   [3],
			nd_pre_facility_id						   [3],
			nd_op_facility_id				    	   [3],
			lv_lang_id								   [5],
			legend_cat									[161],
			legend_cat2									[161],
			leg5_leg6									[161],
			leg12_leg13									[161],
			l_translated_value						   [201],
			l_pk_value							       [100],
			p_language_id                              [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[3]; } nd_pre_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_op_facility_id;

struct { unsigned short len; unsigned char arr[5]; } lv_lang_id;

struct { unsigned short len; unsigned char arr[161]; } legend_cat;

struct { unsigned short len; unsigned char arr[161]; } legend_cat2;

struct { unsigned short len; unsigned char arr[161]; } leg5_leg6;

struct { unsigned short len; unsigned char arr[161]; } leg12_leg13;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;


/* VARCHAR    d_cb_date                    [16],
			p_cb_date					[31],
			nd_as_on_dt[31],
		   d_base_currency				[7],
		   subcur						[7]; */ 
struct { unsigned short len; unsigned char arr[16]; } d_cb_date;

struct { unsigned short len; unsigned char arr[31]; } p_cb_date;

struct { unsigned short len; unsigned char arr[31]; } nd_as_on_dt;

struct { unsigned short len; unsigned char arr[7]; } d_base_currency;

struct { unsigned short len; unsigned char arr[7]; } subcur;


/* VARCHAR		d_vr_date					[16],
			d_recouped_vr_no			[60],
			d_legend_dept				[4],
			d_doc_date					[16]; */ 
struct { unsigned short len; unsigned char arr[16]; } d_vr_date;

struct { unsigned short len; unsigned char arr[60]; } d_recouped_vr_no;

struct { unsigned short len; unsigned char arr[4]; } d_legend_dept;

struct { unsigned short len; unsigned char arr[16]; } d_doc_date;


double  	d_doc_amt;



/* VARCHAR		d1_vr_date					[16],
			d1_recouped_vr_no			[60],
			d1_recouped_chk_no			[60],
			d1_legend_dept				[4],
			d1_doc_date					[16]; */ 
struct { unsigned short len; unsigned char arr[16]; } d1_vr_date;

struct { unsigned short len; unsigned char arr[60]; } d1_recouped_vr_no;

struct { unsigned short len; unsigned char arr[60]; } d1_recouped_chk_no;

struct { unsigned short len; unsigned char arr[4]; } d1_legend_dept;

struct { unsigned short len; unsigned char arr[16]; } d1_doc_date;


double  	d1_doc_amt;



/* VARCHAR		d2_vr_date					[16],
			d2_recouped_vr_no			[11],
			d2_legend_dept				[4],
			d2_doc_date					[26],
			nd_st_date[30]; */ 
struct { unsigned short len; unsigned char arr[16]; } d2_vr_date;

struct { unsigned short len; unsigned char arr[11]; } d2_recouped_vr_no;

struct { unsigned short len; unsigned char arr[4]; } d2_legend_dept;

struct { unsigned short len; unsigned char arr[26]; } d2_doc_date;

struct { unsigned short len; unsigned char arr[30]; } nd_st_date;


double  	d2_doc_amt,tot_ref_amt=0;



double   d_cb_voting_limit_amt=0,d_cb_voucher_in_hand_amt=0,
		 d_cb_chq_in_hand_amt=0,d_cb_cash_in_hand_amt=0;		

		
	int     i,first,sl_no=1,sl_no1=1,sl_no2=1;

char   amt_in_words	[10][133]; 

char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[200];

int ctr = 0,  len = 0;
int r_ctr = 0,r1_ctr = 0,r_ctr6 = 0;
char l_string[300];
char cl_string[300];
char  cl_string6[300];
char cl1_string[300];


char string_var[200];
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


int    lctr = 0,pctr = 0,nvalid = 0,ncancel = 0;

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
 
	
    strcpy(g_pgm_id,"BLR00078");
    strcpy(nd_pwd.arr,argv[1]);
	nd_pwd.len = strlen(nd_pwd.arr);
	
	conn_sql();
	 
	set_meduser_role(); 

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

	strcpy(p_language_id.arr,l_language_id.arr);
    p_language_id.len = l_language_id.len;

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);
   
   	    strcpy(nd_facility.arr,argv[4]);
    	nd_facility.len = strlen(nd_facility.arr);
    	strcpy(g_facility_id,nd_facility.arr);
      


   fn_fetch_parameters();

   fn_fetch_hosp_name();

   fn_fetch_dep_acc_dtls();

fn_fetch_refund_amt();
     fetch_legend_value();

   fn_open_file();

 
   fn_print_settings();

   fn_print_header();

   fn_print_body();
 

   declare_rp_pymnt();
  
   open_rp_pymnt_cur();

    do_rp_pymnt();
   
   close_rp_pymnt_cur();


   open_rp_pymnt1_cur();

   do_rp_pymnt1();
   
   close_rp_pymnt1_cur();


   open_rp_pymnt2_cur();

   do_rp_pymnt2();
   
   close_rp_pymnt2_cur();


  fflush(fp);
  fclose(fp);
  fprintf(fp,"%cE",ESC);		// To reset the printer





    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 0;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
      err_mesg("COMMIT WORK RELEASE failed",0,"");

}





fn_fetch_parameters()
{
	p_cb_date.arr[0] = '\0';
	
	p_cb_date.len = 0;

	nd_as_on_dt.arr[0] = '\0';
	nd_as_on_dt.len = 0;
		  

	/* EXEC SQL SELECT param1,
			param2
		 INTO :p_cb_date, :nd_as_on_dt
		 FROM   sy_prog_param
            WHERE PGM_ID   = :d_curr_pgm_name
                 AND SESSION_ID = :nd_session_id
                 AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select param1 ,param2 into :b0,:b1  from sy_prog_param wher\
e ((PGM_ID=:b2 and SESSION_ID=:b3) and PGM_DATE=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )20;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_cb_date;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_as_on_dt;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_curr_pgm_name;
 sqlstm.sqhstl[2] = (unsigned int  )17;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[3] = (unsigned int  )18;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[4] = (unsigned int  )27;
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
		err_mesg("SELECT failed on table SY_PROG_PARAM.", 0, "");

	if (NOT_FOUND)
        err_mesg("No record found in SY_PROG_PARAM.", 0, "");

	p_cb_date.arr[p_cb_date.len] = '\0';
	nd_as_on_dt.arr[nd_as_on_dt.len] = '\0';


	/* EXEC SQL DELETE sy_prog_param
             WHERE PGM_ID   = :d_curr_pgm_name
                 AND SESSION_ID = :nd_session_id
                 AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from sy_prog_param  where ((PGM_ID=:b0 and SESSION_\
ID=:b1) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )55;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_curr_pgm_name;
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
		err_mesg("DELETE failed on table SY_PROG_PARAM.", 0, "");
}




fn_fetch_dep_acc_dtls()
{

	d_cb_date.arr[0] = '\0';
	d_cb_date.len = 0;


	/* EXEC SQL Select 
				CB_DATE,
				CB_VOTING_LIMIT_AMT,
				CB_VOUCHER_IN_HAND_AMT,
				CB_CHQ_IN_HAND_AMT  ,
				CB_CASH_IN_HAND_AMT          
			   INTO  
			        :d_cb_date,
					:d_cb_voting_limit_amt,
					:d_cb_voucher_in_hand_amt,
					:d_cb_chq_in_hand_amt,
					:d_cb_cash_in_hand_amt										
				From BL_CASH_REFUND_CASHBOOK_CB
		    	Where to_char(CB_DATE,'DD/MM/YYYY')=:p_cb_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select CB_DATE ,CB_VOTING_LIMIT_AMT ,CB_VOUCHER_IN_HAND_AMT\
 ,CB_CHQ_IN_HAND_AMT ,CB_CASH_IN_HAND_AMT into :b0,:b1,:b2,:b3,:b4  from BL_C\
ASH_REFUND_CASHBOOK_CB where to_char(CB_DATE,'DD/MM/YYYY')=:b5";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )82;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_cb_date;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_cb_voting_limit_amt;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_cb_voucher_in_hand_amt;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_cb_chq_in_hand_amt;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_cb_cash_in_hand_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&p_cb_date;
 sqlstm.sqhstl[5] = (unsigned int  )33;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
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
		err_mesg("SELECT failed from table BL_CASH_REFUND_CASHBOOK_CB", 0, "");

	d_cb_date.arr[d_cb_date.len] = '\0';
		 
}


fn_fetch_refund_amt()
{
		
	nd_st_date.arr[0] = '\0';
	nd_st_date.len = 0;

	/* EXEC SQL SELECT to_char(to_date(:p_cb_date,'dd/mm/yyyy')+1,'dd/mm/yyyy') into :nd_st_date
	FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select to_char((to_date(:b0,'dd/mm/yyyy')+1),'dd/mm/yyyy') \
into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )121;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_cb_date;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_st_date;
 sqlstm.sqhstl[1] = (unsigned int  )32;
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
	err_mesg("SELECT failed from table DUAL", 0, "");

	nd_st_date.arr[nd_st_date.len] = '\0';

	
	/* EXEC SQL SELECT SUM(abs(doc_amt)) INTO :tot_ref_amt
	FROM bl_recpt_refund_can_bou_dtl_vw
	WHERE operating_facility_id = :nd_facility 
	AND doc_date >= TO_DATE(NVL(:nd_st_date,'01/01/1900')||' 00:00:00','DD/MM/YYYY HH24:MI:SS')
	AND doc_date <= NVL(TO_DATE(:nd_as_on_dt||' 23:59:59','DD/MM/YYYY HH24:MI:SS'),SYSDATE)
	AND RECPT_REFUND_IND ='F'
	AND cash_slmt_flag ='Y'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select sum(abs(doc_amt)) into :b0  from bl_recpt_refund_can\
_bou_dtl_vw where ((((operating_facility_id=:b1 and doc_date>=TO_DATE((NVL(:b\
2,'01/01/1900')||' 00:00:00'),'DD/MM/YYYY HH24:MI:SS')) and doc_date<=NVL(TO_\
DATE((:b3||' 23:59:59'),'DD/MM/YYYY HH24:MI:SS'),SYSDATE)) and RECPT_REFUND_I\
ND='F') and cash_slmt_flag='Y')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )144;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&tot_ref_amt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
 sqlstm.sqhstv[2] = (         void  *)&nd_st_date;
 sqlstm.sqhstl[2] = (unsigned int  )32;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_as_on_dt;
 sqlstm.sqhstl[3] = (unsigned int  )33;
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
	err_mesg("SELECT failed from table BL_RECPT_REFUND_CAN_BOU_DTL_VW", 0, "");


	}

fn_open_file()
{
    strcpy(filename, WORKING_DIR);
	strcat(filename, "BLR00078.lis");

    if ((fp = fopen(filename, "w")) == NULL)
    {
		disp_message(ERR_MESG, "Error in opening file BLR00078.lis");
		proc_exit();
    }
}




declare_rp_pymnt()
  {

 /* EXEC SQL DECLARE RP_PYMNT CURSOR FOR 
  Select  to_char(a.VR_DATE,'dd/mm/yyyy'), to_char( a.VR_DATE,'dd/mm/yyyy')||' '||'('||a.RECOUPED_VR_NO||')', '251'LEGEND_DEPT, a.DOC_AMT, to_char(a.DOC_DATE,'dd/mm/yyyy')
	From BL_CASH_REFUND_CYCLE_TRN a, BL_CASH_REFUND_CASHBOOK_CB B
	Where  a.operating_facility_id = :nd_facility
	AND a.operating_facility_id = b.operating_facility_id
	AND a.RECOUPED_VR_NO = b.CB_RECOUPED_VR_NO
	And a.OB_TRN_YN='N'
	And a.RECOUPED_VR_NO is not null
	and trunc(b.CB_DATE) <= trunc(to_date(:p_cb_date,'DD/MM/YYYY'))
	and 
	(    
	nvl(a.CHQ_RECEIVED_YN,'N') = 'N' or
	( nvl(a.CHQ_RECEIVED_YN,'N') = 'Y' and trunc(a.CHQ_RECEIVED_DATE) > trunc(to_date(:p_cb_date,'DD/MM/YYYY')) ) ); */ 





 /* EXEC SQL DECLARE RP_PYMNT1 CURSOR FOR 
	Select  to_char(VR_DATE,'dd/mm/yyyy'),
	to_char(VR_DATE,'dd/mm/yyyy')||' '||'('||RECOUPED_VR_NO||')' vno,
	'('||' '||chq_no||' '||TO_CHAR(chq_date,'DD\MM\YYYY')||')' chkno,
	--to_char(VR_DATE,'dd/mm/yyyy')||' '||'('||RECOUPED_VR_NO||')'||'('||' '||chq_no||' '||TO_CHAR(chq_date,'DD\MM\YYYY')||')',
	'251' LEGEND_DEPT, DOC_AMT, DOC_DATE
	from 	 bl_cash_refund_cycle_trn
	where  operating_facility_id = :nd_facility
	and	 nvl(CHQ_RECEIVED_YN,'N') = 'Y' 
	and    CHQ_RECEIVED_DATE <= trunc(to_date(:p_cb_date,'DD/MM/YYYY'))
	and 
	(
	nvl(CHQ_CLEARED_YN,'N')='N' or 
	nvl(CHQ_CLEARED_YN,'N')='Y' 
	and CHQ_CLEARED_DATE >= trunc(to_date(:p_cb_date,'DD/MM/YYYY'))); */ 


/* EXEC SQL DECLARE RP_PYMNT2 CURSOR FOR 
	SELECT to_char(doc_date,'dd/mm/yyyy'), null, '251' LEGEND_DEPT, abs(doc_amt), null
	FROM bl_recpt_refund_can_bou_dtl_vw
	WHERE operating_facility_id = :nd_facility 
	AND doc_date >= TO_DATE(NVL(:nd_st_date,'01/01/1900')||' 00:00:00','DD/MM/YYYY HH24:MI:SS')
	AND doc_date <= NVL(TO_DATE(:nd_as_on_dt||' 23:59:59','DD/MM/YYYY HH24:MI:SS'),SYSDATE)
	AND RECPT_REFUND_IND ='F'
	AND cash_slmt_flag ='Y'
	ORDER BY doc_date; */ 
	

  }


  open_rp_pymnt_cur()
{
   /* EXEC SQL OPEN RP_PYMNT; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )175;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&p_cb_date;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_cb_date;
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


		if (OERROR)
        err_mesg("OPEN failed on cursor RP_PYMNT",0,"");
}


close_rp_pymnt_cur()
{

	/* EXEC SQL CLOSE RP_PYMNT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )202;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}



  open_rp_pymnt1_cur()
{
   /* EXEC SQL OPEN RP_PYMNT1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0008;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )217;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&p_cb_date;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_cb_date;
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


		if (OERROR)
        err_mesg("OPEN failed on cursor RP_PYMNT1",0,"");
}


close_rp_pymnt1_cur()
{

	/* EXEC SQL CLOSE RP_PYMNT1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )244;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}



  open_rp_pymnt2_cur()
{
   /* EXEC SQL OPEN RP_PYMNT2; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0009;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )259;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_st_date;
   sqlstm.sqhstl[1] = (unsigned int  )32;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_as_on_dt;
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


		if (OERROR)
        err_mesg("OPEN failed on cursor RP_PYMNT2",0,"");
}


close_rp_pymnt2_cur()
{

	/* EXEC SQL CLOSE RP_PYMNT2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )286;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}




fetch_rp_pymnt()
  {

			d_vr_date.arr[0]			 = '\0';				
			d_recouped_vr_no.arr[0]		 = '\0';		
			d_legend_dept.arr[0]		 = '\0';			
			d_doc_date.arr[0]			 = '\0';				
		 	d_doc_amt					 = 0;

       
	   		d_vr_date.len			=0;				
			d_recouped_vr_no.len	=0;			
			d_legend_dept.len		=0;				
			d_doc_date.len			=0;					
		 

   /* EXEC SQL FETCH  RP_PYMNT INTO 
            :d_vr_date ,
			:d_recouped_vr_no,
			:d_legend_dept,
			:d_doc_amt,
			:d_doc_date ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )301;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_vr_date;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_recouped_vr_no;
   sqlstm.sqhstl[1] = (unsigned int  )62;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_legend_dept;
   sqlstm.sqhstl[2] = (unsigned int  )6;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_doc_amt;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_doc_date;
   sqlstm.sqhstl[4] = (unsigned int  )18;
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
		err_mesg("FETCH failed on cursor  RP_PYMNT ",0,"");	

		d_vr_date.arr[d_vr_date.len]				 = '\0';				
		d_recouped_vr_no.arr[d_recouped_vr_no.len]	 = '\0';		
		d_legend_dept.arr[d_legend_dept.len]		 = '\0';			
	    d_doc_date.arr[d_doc_date.len]				 = '\0';	

	return(LAST_ROW?0:1);   
  }



fetch_rp_pymnt1()
  {

			d1_vr_date.arr[0]			 = '\0';				
			d1_recouped_vr_no.arr[0]		 = '\0';		
			d1_legend_dept.arr[0]		 = '\0';			
			d1_doc_date.arr[0]			 = '\0';
			d1_recouped_chk_no.arr[0]	 = 	'\0';			
		 	d1_doc_amt					 = 0;

       
	   		d1_vr_date.len			=0;				
			d1_recouped_vr_no.len	=0;			
			d1_legend_dept.len		=0;				
			d1_doc_date.len			=0;	
			d1_recouped_chk_no.len  =0;				
		 

   /* EXEC SQL FETCH  RP_PYMNT1 INTO 
            :d1_vr_date ,
			:d1_recouped_vr_no,
			:d1_recouped_chk_no,
			:d1_legend_dept,
			:d1_doc_amt,
			:d1_doc_date ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )336;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d1_vr_date;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d1_recouped_vr_no;
   sqlstm.sqhstl[1] = (unsigned int  )62;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d1_recouped_chk_no;
   sqlstm.sqhstl[2] = (unsigned int  )62;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d1_legend_dept;
   sqlstm.sqhstl[3] = (unsigned int  )6;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d1_doc_amt;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d1_doc_date;
   sqlstm.sqhstl[5] = (unsigned int  )18;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
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
		err_mesg("FETCH failed on cursor  RP_PYMNT1 ",0,"");	

		d1_vr_date.arr[d1_vr_date.len]					= '\0';				
		d1_recouped_vr_no.arr[d1_recouped_vr_no.len]	= '\0';
		d1_recouped_chk_no.arr[d1_recouped_chk_no.len]  = '\0';		
		d1_legend_dept.arr[d1_legend_dept.len]			= '\0';			
	    d1_doc_date.arr[d1_doc_date.len]				= '\0';	

	return(LAST_ROW?0:1);   
  }



fetch_rp_pymnt2()
  {

			d2_vr_date.arr[0]			 = '\0';				
			d2_recouped_vr_no.arr[0]		 = '\0';		
			d2_legend_dept.arr[0]		 = '\0';			
			d2_doc_date.arr[0]			 = '\0';				
		 	d2_doc_amt					 = 0;

       
	   		d2_vr_date.len			=0;				
			d2_recouped_vr_no.len	=0;			
			d2_legend_dept.len		=0;				
			d2_doc_date.len			=0;					
		 

   /* EXEC SQL FETCH  RP_PYMNT2 INTO 
            :d2_vr_date ,
			:d2_recouped_vr_no,
			:d2_legend_dept,
			:d2_doc_amt,
			:d2_doc_date ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )375;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d2_vr_date;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d2_recouped_vr_no;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d2_legend_dept;
   sqlstm.sqhstl[2] = (unsigned int  )6;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d2_doc_amt;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d2_doc_date;
   sqlstm.sqhstl[4] = (unsigned int  )28;
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
		err_mesg("FETCH failed on cursor  RP_PYMNT2 ",0,"");	

		d2_vr_date.arr[d2_vr_date.len]					= '\0';				
		d2_recouped_vr_no.arr[d2_recouped_vr_no.len]	= '\0';		
		d2_legend_dept.arr[d2_legend_dept.len]			= '\0';			
	    d2_doc_date.arr[d2_doc_date.len]				= '\0';	

	return(LAST_ROW?0:1);   
  }



 do_rp_pymnt()
   {
   next_page();
   print_head_page2();
   
   while(fetch_rp_pymnt())
     {
 
     fprintf(fp," %-6d%16s%11s       ",sl_no,d_vr_date.arr,d_legend_dept.arr);
	 print_formated(d_doc_amt);
     fprintf(fp,"%15s",d_vr_date.arr);
    next_line(1);
  sl_no=sl_no+1;

	 }
	
   }

 do_rp_pymnt1()
   {
      next_page();
   print_head_page3();
   while(fetch_rp_pymnt1())
     {
        
	 fprintf(fp," %-6d%16s%11s       ",sl_no1,d1_vr_date.arr,d1_legend_dept.arr);
	 print_formated(d1_doc_amt);

     fprintf(fp,"%15s",d1_recouped_vr_no.arr);
      next_line(1);

     fprintf(fp,"%57s%15s"," ",d1_recouped_chk_no.arr);
     //fprintf(fp,"%15s",d1_vr_date.arr);
    next_line(1);
  
  sl_no1=sl_no1+1;
	
   	 }
  }


 do_rp_pymnt2()
   {
      next_page();
   print_head_page4();
   while(fetch_rp_pymnt2())
     {
        
	 fprintf(fp," %-6d%16s%11s       ",sl_no2,d2_vr_date.arr,d2_legend_dept.arr);
	 print_formated(d2_doc_amt);
     fprintf(fp,"%15s",d2_doc_date.arr);
	    next_line(1);
  
  sl_no2=sl_no2+1;
	
   	 }
  }



print_head_page2()
 {
 int sp1=0;
fprintf(fp,"%c(s10H",ESC); 		// To set the font
fprintf(fp,"%c(s3B",ESC); 	// To set bold style
next_line(1);
	fprintf(fp,"%-15s",loc_legend[14]);
  next_line(3);
		sp1 = (REP_WIDTH-(strlen(loc_legend[12])+strlen(loc_legend[13])))/2;
	horz_skip(sp1);
	fprintf(fp,"%s%-s",loc_legend[12],loc_legend[13]);
fprintf(fp,"%c(s-3B",ESC);	// To release bold style
fprintf(fp,"%c(s12H",ESC); 		// To set the font
  next_line(2);
	print_line('-',REP_WIDTH);

	fprintf(fp,"%-18s  %7s %26s   %-s"," ",loc_legend[33]," ",loc_legend[36]);
  next_line(1);
	fprintf(fp,"%-6s ----------------------------------%14s  %-s",loc_legend[32],loc_legend[35],loc_legend[37]);
  next_line(1);
	fprintf(fp,"%-6s %13s     %16s "," ",loc_legend[27],loc_legend[34]);
  next_line(1);
	print_line('-',REP_WIDTH);
 }	   

print_head_page3()
 {
 int sp1=0;
 next_line(1);
	fprintf(fp,"%c(s10H",ESC); 		// To set the font
	fprintf(fp,"%c(s3B",ESC); 	// To set bold style
	fprintf(fp,"%-15s",loc_legend[16]);
  next_line(3);
		 sp1 = (REP_WIDTH-strlen(loc_legend[31]))/2;
	horz_skip(sp1);
	fprintf(fp,"%s",loc_legend[31]);
fprintf(fp,"%c(s-3B",ESC);	// To release bold style
fprintf(fp,"%c(s12H",ESC); 		// To set the font
  next_line(2);
	print_line('-',REP_WIDTH);

	fprintf(fp,"%-18s  %7s %26s   %-s"," ",loc_legend[33]," ",loc_legend[36]);
  next_line(1);
	fprintf(fp,"%-6s ----------------------------------%14s  %-s",loc_legend[32],loc_legend[35],loc_legend[37]);
  next_line(1);
	fprintf(fp,"%-6s %13s     %16s "," ",loc_legend[27],loc_legend[34]);
  next_line(1);
	print_line('-',REP_WIDTH);

 }	

print_head_page4()
 {
 int sp2=0;
 next_line(1);
	fprintf(fp,"%c(s10H",ESC); 		// To set the font
	fprintf(fp,"%c(s3B",ESC); 	// To set bold style
	fprintf(fp,"%-15s",loc_legend[42]);
  next_line(3);
		 sp2 = (REP_WIDTH-strlen(loc_legend[43]))/2;
	horz_skip(sp2);
	fprintf(fp,"%s",loc_legend[43]);
fprintf(fp,"%c(s-3B",ESC);	// To release bold style
fprintf(fp,"%c(s12H",ESC); 		// To set the font
  next_line(2);
	print_line('-',REP_WIDTH);

	fprintf(fp,"%-18s  %7s %26s   %-s"," ",loc_legend[33]," ",loc_legend[36]);
  next_line(1);
	fprintf(fp,"%-6s ----------------------------------%14s  %-s",loc_legend[32],loc_legend[35],loc_legend[37]);
  next_line(1);
	fprintf(fp,"%-6s %13s     %16s "," ",loc_legend[27],loc_legend[34]);
  next_line(1);
	print_line('-',REP_WIDTH);

 }


fn_print_header()
{
 int rep_title_len=0,s1=0;
  char v_rep_title[200];

fprintf(fp,"%c(s10H",ESC); 		// To set the font
fprintf(fp,"%c(s3B",ESC); 	// To set bold style

    fprintf(fp,"%8s ",d_curr_pgm_name.arr);
		strcpy(v_rep_title,loc_legend[1]);
		rep_title_len = strlen(v_rep_title);
		s1 = (REP_WIDTH-rep_title_len)/2;
    fprintf(fp,"%-s",loc_legend[1]);

fprintf(fp,"%c(s12H",ESC); 		// To set the font
fprintf(fp,"%c(s-3B",ESC);	// To release bold style

  next_line(2);

		s1 = (REP_WIDTH-strlen(loc_legend[2])-strlen(hosp_name.arr))/2;
    fprintf(fp,"%s ",loc_legend[2]);

fprintf(fp,"%c(s10H",ESC); 		// To set the font
fprintf(fp,"%c(s3B",ESC); 	// To set bold style

    fprintf(fp,"%-s",hosp_name.arr);

 next_line(5);
        s1 = (REP_WIDTH-strlen(loc_legend[3]))/2;
	horz_skip(s1-3);
	fprintf(fp,"%s",loc_legend[3]);

 next_line(2);

	    s1 = (REP_WIDTH-strlen(loc_legend[4]))/2;
	horz_skip(s1-8);
	fprintf(fp,"%s %-s",loc_legend[4],nd_as_on_dt.arr);

 next_line(4);

 fprintf(fp,"%c(s12H",ESC); 		// To set the font
 fprintf(fp,"%c(s-3B",ESC);	// To release bold style

 }
	    
fn_print_body()
 {
	int s1=0,no_of_lines,len;
  
		s1 = (REP_WIDTH-strlen(loc_legend[5])-strlen(loc_legend[6]))/2;
	  
	  
	  //fprintf(fp,"%s %-s",loc_legend[5],loc_legend[6]); 
	  /***updated 19/11/05****/
	                       /******from here*****/

	//strcpy(legend_cat.arr,strcat(loc_legend[5],loc_legend[6]));

	//fprintf(fp,"%-65.65s",legend_cat.arr);

	 //fprintf(fp,"%-80.80s",loc_legend[5]);
	 // next_line(1);
	 //fprintf(fp,"%-65.65s",loc_legend[6]);


leg5_leg6.arr[0] ='\0';
leg5_leg6.len=0;

strcpy(leg5_leg6.arr,loc_legend[5]);
strcat(leg5_leg6.arr,loc_legend[6]);

       len = strlen(leg5_leg6.arr);
	              if(len>65)
				    {
				while(r_ctr6 < len)
					  {	
						split_text(leg5_leg6.arr,80,cl_string6,&r_ctr6);
						fprintf(fp,"%-s",cl_string6);
						if(strlen(cl_string6)>65)
						next_line(1);
						strcpy(cl_string6,"");  
					   }

                     }
					else
					  	fprintf(fp,"%-s",leg5_leg6.arr);

 
      /******up to  here(split to 2 lines)*****/

	  print_formated(d_cb_cash_in_hand_amt);

	  fprintf(fp,"%-s",d_base_currency.arr);
	 next_line(1);

	  fprintf(fp,"(%-s:",loc_legend[7]);

    if(equal(d_cb_cash_in_hand_amt,0.00)) 
			no_of_lines=0;
    else
		   	no_of_lines = print_in_words(d_cb_cash_in_hand_amt,LENGTH_WORDS,subcur.arr,amt_in_words);

  	for (i =0;i<no_of_lines;i++)
   	    fprintf(fp," %s) ",amt_in_words[i]);
	 next_line(1);

	//	fprintf(fp,"%-s",loc_legend[8]);

/****modified on 19/11/05********/

legend_cat.arr[0] = '\0';
legend_cat.len=0;


  strcpy(legend_cat.arr,loc_legend[8]);

  	len = strlen(legend_cat.arr);
				while(r_ctr < len)
					{	
						split_text(legend_cat.arr,80,cl_string,&r_ctr);
						fprintf(fp,"%-80.80s",cl_string);
						strcpy(cl_string,"");  
						next_line(1);
					}


    
/****modified on 19/11/05 up to here********/


	 next_line(3);

		horz_skip(4);
		fprintf(fp," a)   %-52s",loc_legend[10]);
	    horz_skip(3);

		fprintf(fp,"%s",d_base_currency.arr);
		print_formated(d_cb_voting_limit_amt);

	 next_line(2);
		horz_skip(10);

 fprintf(fp,"%c(s3B",ESC); 	// To set bold style
		fprintf(fp,"%s",loc_legend[11]);
 fprintf(fp,"%c(s-3B",ESC);	// To release bold style
	 next_line(2);
		horz_skip(4);

leg12_leg13.arr[0] = '\0';
leg12_leg13.len=0;

		strcpy(leg12_leg13.arr,loc_legend[12]);
		strcat(leg12_leg13.arr,loc_legend[13]);

		fprintf(fp," b)   %-70s",leg12_leg13.arr);


	 next_line(1);
		horz_skip(10);
		fprintf(fp,"%-35.35s ",loc_legend[14]);

		//	s1=strlen(loc_legend[12])+ strlen(loc_legend[13])-strlen(loc_legend[14])-17;
		//horz_skip(s1);

		fprintf(fp,"%s",d_base_currency.arr);
		print_formated(d_cb_voucher_in_hand_amt);
	 next_line(2);

		horz_skip(4);
		fprintf(fp," c)   %-70.70s",loc_legend[15]);
	 next_line(1);


		horz_skip(10);
		fprintf(fp,"%-35.35s ",loc_legend[16]);
			//s1=strlen(loc_legend[12])+ strlen(loc_legend[13])-strlen(loc_legend[16])-17;
		//horz_skip(s1);
		fprintf(fp,"%s",d_base_currency.arr);
		print_formated(d_cb_chq_in_hand_amt);
			//s1=strlen(loc_legend[12])+ strlen(loc_legend[13])+29;
		//horz_skip(90-s1);
		/* commented on 02/08/06
          horz_skip(3);
		fprintf(fp,"%s",d_base_currency.arr);
		print_formated(d_cb_voucher_in_hand_amt+d_cb_chq_in_hand_amt);
		*/
	 next_line(2);


horz_skip(4);
		fprintf(fp," d)   %-70.70s",loc_legend[41]);
	 next_line(1);

	

	horz_skip(10);
		fprintf(fp,"%-35.35s ",loc_legend[42]);
		//horz_skip(19);
		fprintf(fp,"%s",d_base_currency.arr);
		print_formated(tot_ref_amt);
		//adeded on 02/08/06
		horz_skip(3);
		fprintf(fp,"%s",d_base_currency.arr);
		print_formated(d_cb_voucher_in_hand_amt+d_cb_chq_in_hand_amt+tot_ref_amt);
	 next_line(2);




		horz_skip(10);
		fprintf(fp,"%-50s",loc_legend[17]);
		horz_skip(5);
		fprintf(fp,"%s",d_base_currency.arr);
		print_formated(d_cb_voting_limit_amt-(d_cb_voucher_in_hand_amt+d_cb_chq_in_hand_amt+tot_ref_amt));
	next_line(3);



 fprintf(fp,"%c(s3B",ESC); 	// To set bold style
		fprintf(fp,"%s",loc_legend[18]);
 fprintf(fp,"%c(s-3B",ESC);	// To release bold style
 
	next_line(2);
		horz_skip(4);
		fprintf(fp," a)   %-50s",loc_legend[19]);
		horz_skip(5);
		fprintf(fp,"%s",d_base_currency.arr);
		print_formated(d_cb_cash_in_hand_amt-tot_ref_amt);

		// - tot_ref_amt on 02/08/06
	next_line(3);
		//horz_skip(13);


		//fprintf(fp,"%-s",loc_legend[20]);




  /*****20/11/2005******/



legend_cat2.arr[0] = '\0';
legend_cat2.len=0;


  strcpy(legend_cat2.arr,loc_legend[20]);

  	len = strlen(legend_cat2.arr);
				while(r1_ctr < len)
					{	
						split_text(legend_cat2.arr,75,cl1_string,&r1_ctr);
						horz_skip(10);
						fprintf(fp,"%-75.75s",cl1_string);
						strcpy(cl1_string,"");  
						next_line(1);
					}



   /*****UP TO HERE ******/


	next_line(3);
		fprintf(fp,"%-s",loc_legend[21]);
		horz_skip(35);
		fprintf(fp,"%-s",loc_legend[22]);
	next_line(1);
		fprintf(fp,"%-s",loc_legend[23]);
	next_line(4);
		fprintf(fp,"%-15s :..............",loc_legend[24]);
		horz_skip(20);
		fprintf(fp,"%-15s :..............",loc_legend[24]);
	next_line(2);
		fprintf(fp,"%-15s :..............",loc_legend[25]);
		horz_skip(20);
		fprintf(fp,"%-15s :..............",loc_legend[25]);
    next_line(2);
		fprintf(fp,"%-15s :..............",loc_legend[26]);
		horz_skip(20);
		fprintf(fp,"%-15s :..............",loc_legend[26]);
	next_line(2);
		fprintf(fp,"%-15s :..............",loc_legend[27]);
		horz_skip(20);
		fprintf(fp,"%-15s :..............",loc_legend[27]);
		next_line(1);
  }

  


fn_fetch_hosp_name()
{
	hosp_name.arr[0] = '\0';		
	hosp_name.len    = 0;
	d_base_currency.arr[0] = '\0';	
	subcur.arr[0] = '\0';	
    d_base_currency.len    = 0;
	subcur.len    = 0;
	
	if (strcmp(lv_lang_id.arr, "US") == 0) 
	{
		/* EXEC SQL SELECT acc_entity_name,BASE_CURRENCY,BASE_CURRENCY_DEC
				 INTO   :hosp_name,:d_base_currency,:subcur
				 FROM   sy_acc_entity
				 WHERE  acc_entity_id = :nd_facility; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select acc_entity_name ,BASE_CURRENCY ,BASE_CURRENCY_DEC i\
nto :b0,:b1,:b2  from sy_acc_entity where acc_entity_id=:b3";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )410;
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
  sqlstm.sqhstv[1] = (         void  *)&d_base_currency;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&subcur;
  sqlstm.sqhstl[2] = (unsigned int  )9;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_facility;
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


	}
	else
	{
		/* EXEC SQL SELECT acc_entity_name_loc_lang,BASE_CURRENCY
				 INTO   :hosp_name,:d_base_currency
				 FROM   sy_acc_entity
				 WHERE  acc_entity_id = :nd_facility; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select acc_entity_name_loc_lang ,BASE_CURRENCY into :b0,:b\
1  from sy_acc_entity where acc_entity_id=:b2";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )441;
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
  sqlstm.sqhstv[1] = (         void  *)&d_base_currency;
  sqlstm.sqhstl[1] = (unsigned int  )9;
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


	}

	if (OERROR)
		err_mesg("SELECT failed while fetching hospital name.", 0, "");

	hosp_name.arr[hosp_name.len] = '\0';
	d_base_currency.arr[d_base_currency.len] = '\0';
	subcur.arr[subcur.len] = '\0';		
}


fn_print_settings()
{
	fprintf(fp,"%c(s0P",ESC);		// To fix the primary spacing
	fprintf(fp,"%c&l0O",ESC); 		// To print in portait mode
//	fprintf(fp,"%c(s4099T",ESC);	// To set the font name	
	fprintf(fp,"%c&l8D",ESC); 		// To set vertical lines per inch
	fprintf(fp,"%c&a2L",ESC); 		// To set the left margin
	fprintf(fp,"%c&l6E",ESC); 		// To set the top margin
	fprintf(fp,"%c(s12H",ESC); 		// To set the font
	
	//fprintf(fp,"%c&l0H",ESC);		// To eject page
	//fprintf(fp,"%cE",ESC);		// To reset the printer
	//fprintf(fp,"%c&d0D",ESC);		// To set underline mode
	//fprintf(fp,"%c&d@",ESC);		// To release underline mode
	//fprintf(fp,"%c(s3B",ESC); 	// To set bold style
	//fprintf(fp,"%c(s-3B",ESC);	// To release bold style
}


conn_sql()
{
	/* EXEC sql connect :nd_pwd; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )10;
 sqlstm.offset = (unsigned int  )468;
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



next_line(skip) /* will check for MAX LINE before printing totals */		
int skip;
 {
	if ((lctr + skip) >= MAX_LINES)
	{
		next_page(); 
	}
	else
	{
   for(i=0;i<skip;i++)
		fprintf(fp,"\n"); ++lctr; /*     fprintf(fp,"LNNO:%2d",lno); */
	}
 }
        
next_page() /* will move the cursor to next page */
{
 lctr=0;
	fprintf(fp,"\n");
	fprintf(fp,"\f");
		fprintf(fp,"\n");
		lctr=1;

	//print_head(); 	
}
     

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[15], str_amt[15];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
	    fprintf(fp,"%14sCR",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%14s",str_amt);
    }

}  
 
  
 
	  
	 
	 
	  
	  
	        
print_line(ch,n) /* this is to obtain required characters */
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


fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';
     
		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00078.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00078.LEGEND_'||LTRIM(RTRIM(TO_CHA\
R(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )499;
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
			blcommon.get_local_lang_desc(:nd_facility,
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
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM'\
 , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value\
 , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )522;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
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




