
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
    "T:\\BL\\Facility Change Modifications\\DF\\DFR00005.pc"
};


static unsigned long sqlctx = 464674371;


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
            void  *sqhstv[16];
   unsigned int   sqhstl[16];
            int   sqhsts[16];
            void  *sqindv[16];
            int   sqinds[16];
   unsigned int   sqharm[16];
   unsigned int   *sqharc[16];
   unsigned short  sqadto[16];
   unsigned short  sqtdso[16];
} sqlstm = {10,16};

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
"e_type,'E','EM','O','OP','D','DC','I','IP','R','EX'),'All'),DECODE(a.episode\
_type,'E',1,'O',2,'D',3,'I',4,5) order by a.physician_id,c.short_desc,DECODE(a\
.episode_type,'E',1,'O',2,'D',3,'I',4,5)            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,112,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,1230,0,9,496,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,1,3,0,0,
1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
103,0,0,2,0,0,13,516,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,
0,0,2,4,0,0,
146,0,0,2,0,0,15,538,0,0,0,0,0,1,0,
161,0,0,3,253,0,4,657,0,0,16,3,0,1,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
240,0,0,4,84,0,2,697,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
267,0,0,5,96,0,4,713,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
290,0,0,6,165,0,6,721,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
321,0,0,7,120,0,4,836,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
};


          
#include <stdio.h>         
#include <string.h> 
#include <bl.h>       
#include <math.h> 

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -62)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define NODATAFOUND sqlca.sqlcode == 1403
#define OERROR          (sqlca.sqlcode < 0)
#define MAX_LINES 42
#define REP_WIDTH 136
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
			p_language_id [3]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_from_doctor_id;

struct { unsigned short len; unsigned char arr[16]; } nd_to_doctor_id;

struct { unsigned short len; unsigned char arr[11]; } nd_from_rev_catg_code;

struct { unsigned short len; unsigned char arr[11]; } nd_to_rev_catg_code;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_split_yn;

struct { unsigned short len; unsigned char arr[6]; } nd_blng_grp_id;

struct { unsigned short len; unsigned char arr[9]; } nd_rev_cust_code;

struct { unsigned short len; unsigned char arr[2]; } nd_repeat_grp_col;

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

		    d_rt_hosp_revenue_amt,
		    d_rt_doctor_share,
		    d_rt_settled_amount,

		    d_dt_hosp_revenue_amt,
		    d_dt_doctor_share,
		    d_dt_settled_amount,
		    
		    d_gt_hosp_revenue_amt,
		    d_gt_doctor_share,
		    d_gt_settled_amount;

	char loc_legend[999][201],
	     loc_legend100_1[201],
	     loc_legend100_2[201],
	     loc_legend110_1[201],
	     loc_legend110_2[201],	
	     loc_legend90_1[201],
	     loc_legend90_2[201];
	
	char l_mesg[200];
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


    strcpy(g_pgm_id,"DFR00005");
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
	fprintf(fp,"%c(s13H",ESC); 


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
       DECODE(:nd_episode_split_yn,'Y',DECODE(a.episode_type,'E','EM',
							     'O','OP',
							     'D','DC',
							     'I','IP',
							     'R','EX')
				       ,'All') Episode_Type,
       nvl(sum(nvl(a.net_revenue_amt,0)),0) hosp_revenue_amt,
       nvl(sum(nvl(a.dr_revenue_amt,0)),0)  doctor_share,
       nvl(sum(nvl(a.settled_amt,0)),0)     settled_amount
FROM df_rev_folio_slmt_vw a,
     sy_physician_mast b,
     df_revenue_category c
WHERE a.operating_facility_id = :nd_facility_id
//AND a.processing_month BETWEEN :nd_from_month AND :nd_to_month
AND a.processing_year||TO_CHAR(a.processing_month,'FM00') 
      BETWEEN :nd_from_year||TO_CHAR(:nd_from_month,'FM00') 
      AND :nd_to_year||TO_CHAR(:nd_to_month,'FM00')       
//AND nvl(a.df_trx_status,'X') != 'C'
AND a.physician_id BETWEEN NVL(:nd_from_doctor_id,'!!!!!!!!!!!!!!!') 
		   AND NVL(:nd_to_doctor_id,'~~~~~~~~~~~~~~~') 		  
AND a.blng_grp_id like :nd_blng_grp_id||'%'
AND nvl(a.revenue_cust_code,'X') like :nd_rev_cust_code||'%'
AND a.episode_type = decode(:nd_episode_type,'A',a.episode_type,:nd_episode_type)
AND a.operating_facility_id = b.facility_id
AND a.physician_id = b.physician_id
AND a.revenue_category = c.revenue_category
GROUP BY a.physician_id, 
         b.short_name,       
         c.short_desc,                            
         DECODE(:nd_episode_split_yn,'Y',DECODE(a.episode_type,'E','EM',
							     'O','OP',
							     'D','DC',
							     'I','IP',
							     'R','EX')
				       ,'All'),
	DECODE(a.episode_type,'E',1,'O',2,'D',3,'I',4,5)
				     
ORDER BY a.physician_id,
	 c.short_desc,
	 DECODE(a.episode_type,'E',1,'O',2,'D',3,'I',4,5); */ 

}

 process_dtl()
 {
	open_dr_pay_cur();	

	while(fetch_dr_pay_cur())
	{	
		if (d_prv_physician_id.arr[0] == '\0' && d_prv_rev_catg.arr[0] == '\0' )		  
		 {
			fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					d_physician_id.arr,d_physician_name.arr,
					d_rev_catg.arr,d_episode_type.arr);					
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
		 }
		 else if (strcmp(d_physician_id.arr,d_prv_physician_id.arr) == 0 &&
			  strcmp(d_rev_catg.arr,d_prv_rev_catg.arr) == 0)
		 {
			if (l_line_cnt_for_dtl_rec == 1 || nd_repeat_grp_col.arr[0] == 'Y')
			{

				fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					d_physician_id.arr,d_physician_name.arr,
					d_rev_catg.arr,d_episode_type.arr);					
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
			}
			else
			{

				fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					"","","",d_episode_type.arr);					
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
			}
		}
		else if (strcmp(d_physician_id.arr,d_prv_physician_id.arr) == 0 &&
			  strcmp(d_rev_catg.arr,d_prv_rev_catg.arr) != 0)
		 {

			//	if ((lctr + 3) > MAX_LINES)
			//	     next_line(3);	
		

				fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					"","","","");					
				print_line('-',62);     							

				fprintf(fp, "%-15.15s %-15.15s %-24.24s- %-15.15s ",
					"","",
					d_prv_rev_catg.arr,loc_legend[130]);					
					print_formated(d_rt_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_rt_doctor_share);
					fprintf(fp," ");
					print_formated(d_rt_settled_amount);

				next_line(1);		

				fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					"","","","");					
				print_line('-',62);     							

				d_rt_hosp_revenue_amt = 0;
				d_rt_doctor_share = 0;
				d_rt_settled_amount = 0;



			if (l_line_cnt_for_dtl_rec == 1 || nd_repeat_grp_col.arr[0] == 'Y')
			{				
				fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					d_physician_id.arr,d_physician_name.arr,
					d_rev_catg.arr,d_episode_type.arr);			
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
			}
			else
			{
				fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					"","",
					d_rev_catg.arr,d_episode_type.arr);					
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);
			}
		}		
		else
		{


			//if ((lctr + 3) > MAX_LINES)
			//	     next_line(3);

			fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					"","","","");					
			print_line('-',62);     						

			fprintf(fp, "%-15.15s %-15.15s %-24.24s- %-15.15s ",
					"","",
					d_prv_rev_catg.arr,loc_legend[130]);					
					print_formated(d_rt_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_rt_doctor_share);
					fprintf(fp," ");
					print_formated(d_rt_settled_amount);

			next_line(1);		

			fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					"","","","");					
			print_line('-',62);     						


			d_rt_hosp_revenue_amt = 0;
			d_rt_doctor_share = 0;
			d_rt_settled_amount = 0;			

			//if ((lctr + 2) > MAX_LINES)
			  //    next_line(2);

			fprintf(fp, "%-15.15s %-10.10s %-30.30s %-15.15s ",
					"","",loc_legend[140],"");					
					print_formated(d_dt_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_dt_doctor_share);
					fprintf(fp," ");
					print_formated(d_dt_settled_amount);
			next_line(1);		

			fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					"","","","");					
			print_line('-',62);     						

			d_dt_hosp_revenue_amt = 0;
			d_dt_doctor_share = 0;
			d_dt_settled_amount = 0;			


			fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					d_physician_id.arr,d_physician_name.arr,
					d_rev_catg.arr,d_episode_type.arr);					
					print_formated(d_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_doctor_share);
					fprintf(fp," ");
					print_formated(d_settled_amount);

		}
		
		next_line(1);		

		d_rt_hosp_revenue_amt = d_rt_hosp_revenue_amt + d_hosp_revenue_amt;
		d_rt_doctor_share     = d_rt_doctor_share + d_doctor_share;
		d_rt_settled_amount   = d_rt_settled_amount + d_settled_amount;

		d_dt_hosp_revenue_amt = d_dt_hosp_revenue_amt + d_hosp_revenue_amt;
		d_dt_doctor_share     = d_dt_doctor_share + d_doctor_share;
		d_dt_settled_amount   = d_dt_settled_amount + d_settled_amount;

		d_gt_hosp_revenue_amt = d_gt_hosp_revenue_amt + d_hosp_revenue_amt;
		d_gt_doctor_share     = d_gt_doctor_share + d_doctor_share;
		d_gt_settled_amount   = d_gt_settled_amount + d_settled_amount;

		strcpy(d_prv_physician_id.arr,d_physician_id.arr);
		d_prv_physician_id.len = strlen(d_prv_physician_id.arr);

		strcpy(d_prv_rev_catg.arr,d_rev_catg.arr);
		d_prv_rev_catg.len = strlen(d_prv_rev_catg.arr);
		
		strcpy(d_prv_physician_name.arr,d_physician_name.arr);
		d_prv_physician_name.len = strlen(d_prv_physician_name.arr);		
		
	
		l_line_cnt_for_dtl_rec = l_line_cnt_for_dtl_rec  + 1;
	}

		//if ((lctr + 3) > MAX_LINES)
		//	next_line(3);

		fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					"","","","");					
			print_line('-',62);     						

			fprintf(fp, "%-15.15s %-15.15s %-24.24s- %-15.15s ",
					"","",
					d_prv_rev_catg.arr,loc_legend[130]);					
					print_formated(d_rt_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_rt_doctor_share);
					fprintf(fp," ");
					print_formated(d_rt_settled_amount);

			next_line(1);		

			fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					"","","","");					
			print_line('-',62);     					



			//if ((lctr + 2) > MAX_LINES)
			//	     next_line(2);


			fprintf(fp, "%-15.15s %-10.10s %-30.30s %-15.15s ",
					"","",loc_legend[140],"");					
					print_formated(d_dt_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_dt_doctor_share);
					fprintf(fp," ");
					print_formated(d_dt_settled_amount);

			next_line(1);		

			fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					"","","","");					
			print_line('-',62);     
			

			//if ((lctr + 2) > MAX_LINES)
			  //   next_line(2);

			fprintf(fp, "%-15.15s %-20.20s %-20.20s %-15.15s ",
					"",loc_legend[150],"","");					
					print_formated(d_gt_hosp_revenue_amt);
					fprintf(fp," ");
					print_formated(d_gt_doctor_share);
					fprintf(fp," ");
					print_formated(d_gt_settled_amount);
			//next_line(1);		

			fprintf(fp, "\n%-15.15s %-20.20s %-20.20s %-15.15s ",
					"","","","");					
			print_line_last('-',62);     			
			
	
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
        sprintf(str_amt,"%20s",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%20s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%20s",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%20s",str_amt);
    }

}

open_dr_pay_cur() 
{
	/* EXEC SQL OPEN DR_PAY_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.physician_id physician_id ,b.short_name physician_name ,c.short\
_desc revenue_category ,DECODE(:b0,'Y',DECODE(a.episode_type,'E','EM','O','O\
P','D','DC','I','IP','R','EX'),'All') Episode_Type ,nvl(sum(nvl(a.net_revenu\
e_amt,0)),0) hosp_revenue_amt ,nvl(sum(nvl(a.dr_revenue_amt,0)),0) doctor_sh\
are ,nvl(sum(nvl(a.settled_amt,0)),0) settled_amount  from df_rev_folio_slmt\
_vw a ,sy_physician_mast b ,df_revenue_category c where ((((((((a.operating_\
facility_id=:b1 and (a.processing_year||TO_CHAR(a.processing_month,'FM00')) \
between (:b2||TO_CHAR(:b3,'FM00')) and (:b4||TO_CHAR(:b5,'FM00'))) and a.phy\
sician_id between NVL(:b6,'!!!!!!!!!!!!!!!') and NVL(:b7,'~~~~~~~~~~~~~~~'))\
 and a.blng_grp_id like (:b8||'%')) and nvl(a.revenue_cust_code,'X') like (:\
b9||'%')) and a.episode_type=decode(:b10,'A',a.episode_type,:b10)) and a.ope\
rating_facility_id=b.facility_id) and a.physician_id=b.physician_id) and a.r\
evenue_category=c.revenue_category) group by a.physician_id,b.short_name,c.s\
hort_desc,DECODE(:b0,'Y',DECODE(a.episod");
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
 sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
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
 sqlstm.sqhstv[3] = (         void  *)&nd_from_month;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_year;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_to_month;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_from_doctor_id;
 sqlstm.sqhstl[6] = (unsigned int  )18;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_to_doctor_id;
 sqlstm.sqhstl[7] = (unsigned int  )18;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_blng_grp_id;
 sqlstm.sqhstl[8] = (unsigned int  )8;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_rev_cust_code;
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
 sqlstm.sqhstv[11] = (         void  *)&nd_episode_type;
 sqlstm.sqhstl[11] = (unsigned int  )4;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_episode_split_yn;
 sqlstm.sqhstl[12] = (unsigned int  )4;
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
		  :d_settled_amount; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )103;
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
 sqlstm.sqhstv[6] = (         void  *)&d_settled_amount;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
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
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )146;
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
	fprintf(fp,"%35s : %-4.4s\n\n",  "Billing Group",nd_blng_grp_id.arr);
	fprintf(fp,"%35s : %-s\n\n",  "Revenue Customer",nd_rev_cust_code.arr);
	
	
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
      fprintf(fp,"%-15.15s %-20.20s %-20.20s %-15.15s %20.20s %20.20s %20.20s ",
      loc_legend[60],loc_legend[70],loc_legend[80],loc_legend90_1,loc_legend100_1,loc_legend110_1,loc_legend[120]);

      next_line(1);

      fprintf(fp,"%-15.15s %-20.20s %-20.20s %-15.15s %20.20s %20.20s %20.20s ",
      "","","",loc_legend90_2,loc_legend100_2,loc_legend110_2,"");

      next_line(1);
      print_line('-',REP_WIDTH);         

 }


 open_files()
 {

	strcpy(filename,WORKING_DIR);
	strcat(filename,"DFR00005.lis");

	if ((fp = fopen(filename,"w")) == NULL)
	{
		disp_message(ERR_MESG,"Error in opening file DFR00005.lis");
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

	nd_from_doctor_id.len = 0;
	nd_to_doctor_id.len = 0;
	nd_from_rev_catg_code.len = 0;
	nd_to_rev_catg_code.len = 0;
	nd_episode_type.len = 0;
	nd_episode_split_yn.len = 0;
	nd_blng_grp_id.len = 0;
	nd_rev_cust_code.len = 0;
	nd_repeat_grp_col.len = 0;
			
        /* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,
			PARAM7,PARAM8,PARAM9,PARAM10, PARAM11,
			PARAM12,PARAM13
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
			:nd_repeat_grp_col
		FROM SY_PROG_PARAM
                WHERE PGM_ID   = :nd_curr_pgm_id
                AND SESSION_ID = :nd_session_id
                AND PGM_DATE   = :nd_pgm_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 16;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6\
 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 into :b0,:b1,:b2,\
:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12  from SY_PROG_PARAM where ((PGM_ID=\
:b13 and SESSION_ID=:b14) and PGM_DATE=:b15)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )161;
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
        sqlstm.sqhstv[13] = (         void  *)&nd_curr_pgm_id;
        sqlstm.sqhstl[13] = (unsigned int  )17;
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


	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :nd_curr_pgm_id
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION_I\
D=:b1) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )240;
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

		/* EXEC SQL SELECT LTRIM(RTRIM('DFR00005.LEGEND_'||
				LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		         INTO :l_pk_value
			 FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('DFR00005.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )267;
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
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )290;
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
	if (strlen(loc_legend[100]) > 0)
		split_text(loc_legend[100],20,loc_legend100_1,&r_ctr);
	if (strlen(loc_legend[100]) >= 20)	
		split_text(loc_legend[100],20,loc_legend100_2,&r_ctr);

	r_ctr = 0;
	if (strlen(loc_legend[110]) > 0)
		split_text(loc_legend[110],20,loc_legend110_1,&r_ctr);
	if (strlen(loc_legend[110]) >= 20)	
		split_text(loc_legend[110],20,loc_legend110_2,&r_ctr);

	r_ctr = 0;
	if (strlen(loc_legend[90]) > 0)
		split_text(loc_legend[90],15,loc_legend90_1,&r_ctr);
	if (strlen(loc_legend[90]) >= 15)	
		split_text(loc_legend[90],15,loc_legend90_2,&r_ctr);

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
	
	strcpy(v_sub_title,loc_legend[160]);

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
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select acc_entity_name ,user ,to_char(sysdate,'DD/MM/YYYY') \
into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )321;
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
