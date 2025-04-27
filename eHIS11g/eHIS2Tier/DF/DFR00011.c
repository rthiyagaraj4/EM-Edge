
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/DF/DFR00011.pc"
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

 static const char *sq0002 = 
"select a.processing_month ,a.processing_year ,a.physician_id ,b.full_name ,a\
.contract_ref ,to_char(a.contract_period_from,'dd/mm/yyyy') ,to_char(a.contrac\
t_period_to,'dd/mm/yyyy') ,a.revenue_amt_ytlm ,a.revenue_amt_cur_month ,a.sett\
led_amt_ytlm ,a.settled_amt_cur_month ,a.pmnt_amt_ytlm_paid ,a.payable_amt_cur\
_month ,a.pmnt_amt_cur_month_paid ,a.pmnt_doc_type_code ,a.pmnt_doc_number ,a.\
pmnt_doc_line_num ,to_char(a.pmnt_doc_date,'dd/mm/yyyy')  from df_monthly_pmnt\
_by_contract a ,sy_physician_mast b where ((((a.operating_facility_id=:b0 and \
a.physician_id between NVL(:b1,'!!!!!!!!!!!!!!!') and NVL(:b2,'~~~~~~~~~~~~~~~\
')) and a.contract_ref between NVL(:b3,'!!!!!!!!!!!!!!!!!!!!') and NVL(:b4,'~~\
~~~~~~~~~~~~~~~~~~')) and b.facility_id=a.operating_facility_id) and a.physici\
an_id=b.physician_id) order by a.physician_id,a.contract_ref,a.contract_period\
_from,a.processing_year,a.processing_month            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,121,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,910,0,9,415,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
71,0,0,2,0,0,13,451,0,0,18,0,0,1,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,
158,0,0,2,0,0,15,489,0,0,0,0,0,1,0,
173,0,0,3,135,0,4,561,0,0,7,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
216,0,0,4,84,0,2,582,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
243,0,0,5,96,0,4,597,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
266,0,0,6,165,0,6,605,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
297,0,0,7,120,0,4,737,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
};


          
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
#define NODATAFOUND sqlca.sqlcode == 1403
#define OERROR          (sqlca.sqlcode < 0)
#define MAX_LINES 42
#define REP_WIDTH 154
#define VER  "VER : 4.10\n"
#define ESC  0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR     l_translated_value	[201],	
		    l_pk_value	[100],

		    nd_curr_pgm_id [15],
		    nd_session_id [16],
		    nd_pgm_date   [25],
		    nd_pwd 	[91],
		    nd_facility_id[3],
			p_language_id[5]; */ 
struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[15]; } nd_curr_pgm_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[5]; } p_language_id;


	/* VARCHAR	nd_from_doctor_id[16],
		    nd_to_doctor_id[16],
			nd_from_contract_ref[21],
			nd_to_contract_ref[21],

		    d_acc_entity_name[31],
		    d_user[31],
		    d_curr_date[21],		    
		    
			d_doctor_id[16],
			d_doctor_name[31],
			d_contract_ref[21],
			d_contract_from[12],
			d_contract_to[12],
			d_pmnt_doc_type[7],
			d_pmnt_doc_num[9],
			d_pmnt_doc_line_num[5],
			d_pmnt_doc_date[12],
			
			temp_doctor_id[16],
			temp_contract_ref[21]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_from_doctor_id;

struct { unsigned short len; unsigned char arr[16]; } nd_to_doctor_id;

struct { unsigned short len; unsigned char arr[21]; } nd_from_contract_ref;

struct { unsigned short len; unsigned char arr[21]; } nd_to_contract_ref;

struct { unsigned short len; unsigned char arr[31]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[21]; } d_curr_date;

struct { unsigned short len; unsigned char arr[16]; } d_doctor_id;

struct { unsigned short len; unsigned char arr[31]; } d_doctor_name;

struct { unsigned short len; unsigned char arr[21]; } d_contract_ref;

struct { unsigned short len; unsigned char arr[12]; } d_contract_from;

struct { unsigned short len; unsigned char arr[12]; } d_contract_to;

struct { unsigned short len; unsigned char arr[7]; } d_pmnt_doc_type;

struct { unsigned short len; unsigned char arr[9]; } d_pmnt_doc_num;

struct { unsigned short len; unsigned char arr[5]; } d_pmnt_doc_line_num;

struct { unsigned short len; unsigned char arr[12]; } d_pmnt_doc_date;

struct { unsigned short len; unsigned char arr[16]; } temp_doctor_id;

struct { unsigned short len; unsigned char arr[21]; } temp_contract_ref;


	double	d_share_rev_tlm_amt = 0,
			d_share_rev_cur_amt = 0,
			d_settle_tlm_amt = 0,
			d_settle_cur_amt = 0,
			d_paid_tlm_amt = 0,
			d_paid_cur_amt = 0,
			d_payable_cur_amt = 0,

			d_share_rev_cur_tot = 0,
			d_settle_cur_tot = 0,
			d_payable_cur_tot = 0,
			d_paid_cur_tot = 0,

			c_share_rev_cur_tot = 0,
			c_settle_cur_tot = 0,
			c_payable_cur_tot = 0,
			c_paid_cur_tot = 0,

			g_share_rev_cur_tot = 0,
			g_settle_cur_tot = 0,
			g_payable_cur_tot = 0,
			g_paid_cur_tot = 0;

	char loc_legend[999][201],
	     loc_legend170_1[201],
	     loc_legend170_2[201],
	     loc_legend180_1[201],
	     loc_legend180_2[201],	
	     loc_legend210_1[201],
	     loc_legend210_2[201];
	
	char l_mesg[200];
	int i,page_no=0,lctr=0;
	char filename[500];

	int nd_from_month, nd_to_month, nd_from_year, nd_to_year,
		d_month, d_year, temp_month, temp_year;

	
	int first = 0, len = 0, r_ctr = 0;

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


    strcpy(g_pgm_id,"DFR00011");
    strcpy(nd_pwd.arr,argv[1]);
    nd_pwd.len = strlen(nd_pwd.arr);
	 

    /* EXEC sql connect :nd_pwd; */ 

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
    sqlstm.sqlcmax = (unsigned int )100;
    sqlstm.sqlcmin = (unsigned int )2;
    sqlstm.sqlcincr = (unsigned int )1;
    sqlstm.sqlctimeout = (unsigned int )0;
    sqlstm.sqlcnowait = (unsigned int )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

  
	  
	if (sqlca.sqlcode < 0 )
	{
		disp_message(ORA_MESG,"Error in connecting to Oracle");
		proc_exit();
	}

	set_meduser_role(); 

	strcpy(p_language_id.arr,l_language_id.arr);
    p_language_id.len = l_language_id.len;

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
	fprintf(fp,"%c&a3L",ESC);
	fprintf(fp,"%c(s15H",ESC); 

	print_first_page();

	print_rec();

	close_dr_pay_cur();

	end_of_rep();

	fclose(fp);

	fprintf(fp,"%cE",ESC); /* To Reset the Printer */ 
    
 }

end_of_rep()  
{
	fprintf(fp,"\n%66s***  END OF REPORT ***\n"," ");
	fflush(fp);
}

declare_cur()
{

 /* EXEC SQL DECLARE DR_PAY_CUR CURSOR FOR
       select a.processing_month, a.processing_year, a.physician_id, 
			b.full_name,
			a.contract_ref, to_char(a.contract_period_from,'dd/mm/yyyy'), 
			to_char(a.contract_period_to,'dd/mm/yyyy'),
			a.revenue_amt_ytlm, a.revenue_amt_cur_month,
			a.settled_amt_ytlm, a.settled_amt_cur_month, 
			a.pmnt_amt_ytlm_paid, a.payable_amt_cur_month,
			a.pmnt_amt_cur_month_paid, a.pmnt_doc_type_code,
			a.pmnt_doc_number, a.pmnt_doc_line_num, 
			to_char(a.pmnt_doc_date,'dd/mm/yyyy')
from df_monthly_pmnt_by_contract a,
     sy_physician_mast b
WHERE a.operating_facility_id = :nd_facility_id
AND a.physician_id BETWEEN NVL(:nd_from_doctor_id,'!!!!!!!!!!!!!!!') 
		   AND NVL(:nd_to_doctor_id,'~~~~~~~~~~~~~~~') 	
AND a.contract_ref between NVL(:nd_from_contract_ref,'!!!!!!!!!!!!!!!!!!!!') 
		   AND NVL(:nd_to_contract_ref,'~~~~~~~~~~~~~~~~~~~~') 
AND b.facility_id = a.operating_facility_id
AND a.physician_id = b.physician_id
ORDER BY a.physician_id, a.contract_ref, a.contract_period_from, a.processing_year, a.processing_month; */ 


if (OERROR)
         err_mesg("DECLARE cursor DR_PAY_CUR failed",0,"");

}

print_rec()
{
	open_dr_pay_cur();	

	while(fetch_dr_pay_cur())
	{	
		if(strcmp(temp_doctor_id.arr, d_doctor_id.arr) != 0)
		{
			if(first != 0)
			{
				check_line(6);
				print_contract_total();
				print_dr_total();
				next_line(1);
			}

			check_line(2);

			fprintf(fp,"%s: %s  %s", loc_legend[6],d_doctor_id.arr, d_doctor_name.arr);
			next_line(1);
			next_line(1);

			temp_doctor_id.arr[0] = '\0';
			temp_doctor_id.len = 0;

			strcpy(temp_doctor_id.arr, d_doctor_id.arr);
			temp_doctor_id.len = strlen(temp_doctor_id.arr);

			temp_doctor_id.arr[temp_doctor_id.len] = '\0';

			contract_change();
		}

		if (strcmp(temp_contract_ref.arr, d_contract_ref.arr) != 0)
		{
			if (first != 0)
				print_contract_total();

			contract_change();
		}

		check_line(1);

		first = 1;

		fprintf(fp,"%-2.2d/%-4.4d    ",d_month, d_year);

		print_formated(d_share_rev_tlm_amt);
		print_formated(d_share_rev_cur_amt);
		print_formated(d_settle_tlm_amt);
		print_formated(d_settle_cur_amt);
		print_formated(d_paid_tlm_amt);
		print_formated(d_payable_cur_amt);
		print_formated(d_paid_cur_amt);

		fprintf(fp,"%6s/%-8s/%-4s %-10.10s",d_pmnt_doc_type.arr,
							d_pmnt_doc_num.arr, d_pmnt_doc_line_num.arr,
							d_pmnt_doc_date.arr);

		d_share_rev_cur_tot += d_share_rev_cur_amt;
		d_settle_cur_tot	+= d_settle_cur_amt;
		d_payable_cur_tot	+= d_payable_cur_amt;
		d_paid_cur_tot		+= d_paid_cur_amt;

		c_share_rev_cur_tot += d_share_rev_cur_amt;
		c_settle_cur_tot	+= d_settle_cur_amt;
		c_payable_cur_tot	+= d_payable_cur_amt;
		c_paid_cur_tot		+= d_paid_cur_amt;

		g_share_rev_cur_tot += d_share_rev_cur_amt;
		g_settle_cur_tot	+= d_settle_cur_amt;
		g_payable_cur_tot	+= d_payable_cur_amt;
		g_paid_cur_tot		+= d_paid_cur_amt;


		next_line(1);
	}

	check_line(9);
	print_contract_total();
	print_dr_total();
	print_grand_total();

}

contract_change()
{
	check_line(2);

	fprintf(fp,"%s: %-20.20s         %s: %s %s %s", loc_legend[11], d_contract_ref.arr, 
				loc_legend[10], d_contract_from.arr, loc_legend[9], d_contract_to.arr);
	next_line(1);
	next_line(1);

	temp_contract_ref.arr[0] = '\0';
	temp_contract_ref.len = 0;

	strcpy(temp_contract_ref.arr, d_contract_ref.arr);
	temp_contract_ref.len = strlen(temp_contract_ref.arr);

	temp_contract_ref.arr[temp_contract_ref.len] = '\0';
}

print_dr_total()
{
	check_line(2);

	fprintf(fp,"%16.16s %10s",loc_legend[25]," ");

	print_formated(d_share_rev_cur_tot);
	horz_skip(16);
	print_formated(d_settle_cur_tot);
	horz_skip(16);
	print_formated(d_payable_cur_tot);
	print_formated(d_paid_cur_tot);
	next_line(1);

	horz_skip(18);
	print_line('-',REP_WIDTH-18);
	next_line(1);

	d_share_rev_cur_tot = 0;
	d_settle_cur_tot	= 0;
	d_payable_cur_tot	= 0;
	d_paid_cur_tot		= 0;
}

print_contract_total()
{
	check_line(3);

	horz_skip(18);
	print_line('-',REP_WIDTH-18);
	next_line(1);

	fprintf(fp,"%16.16s %10s",loc_legend[26]," ");

	print_formated(c_share_rev_cur_tot);
	horz_skip(16);
	print_formated(c_settle_cur_tot);
	horz_skip(16);
	print_formated(c_payable_cur_tot);
	print_formated(c_paid_cur_tot);
	next_line(1);

	horz_skip(18);
	print_line('-',REP_WIDTH-18);
	next_line(1);

	c_share_rev_cur_tot = 0;
	c_settle_cur_tot	= 0;
	c_payable_cur_tot	= 0;
	c_paid_cur_tot		= 0;
}

print_grand_total()
{
	check_line(4);

	fprintf(fp,"%16.16s %10s",loc_legend[27]," ");

	print_formated(g_share_rev_cur_tot);
	horz_skip(16);
	print_formated(g_settle_cur_tot);
	horz_skip(16);
	print_formated(g_payable_cur_tot);
	print_formated(g_paid_cur_tot);
	next_line(1);

	horz_skip(18);
	print_line('-',REP_WIDTH-18);
	next_line(1);
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
        fprintf(fp,"%15s ",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%15s ",str_amt);
    }

}

open_dr_pay_cur() 
{
	/* EXEC SQL OPEN DR_PAY_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0002;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_from_doctor_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_to_doctor_id;
 sqlstm.sqhstl[2] = (unsigned int  )18;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_from_contract_ref;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_contract_ref;
 sqlstm.sqhstl[4] = (unsigned int  )23;
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



	if(OERROR)	   
		err_mesg("OPEN failed on cursor DR_PAY_CUR",0,"");
}

fetch_dr_pay_cur()
{
	d_doctor_id.arr[0]			= '\0';
	d_doctor_name.arr[0]		= '\0';
	d_contract_ref.arr[0]		= '\0';
	d_contract_from.arr[0]		= '\0';
	d_contract_to.arr[0]		= '\0';
	d_pmnt_doc_type.arr[0]		= '\0';
	d_pmnt_doc_num.arr[0]		= '\0';
	d_pmnt_doc_line_num.arr[0]	= '\0';
	d_pmnt_doc_date.arr[0]		= '\0';

	d_doctor_id.len			= 0;
	d_doctor_name.len		= 0;
	d_contract_ref.len		= 0;
	d_contract_from.len		= 0;
	d_contract_to.len		= 0;
	d_pmnt_doc_type.len		= 0;
	d_pmnt_doc_num.len		= 0;
	d_pmnt_doc_line_num.len	= 0;
	d_pmnt_doc_date.len		= 0;

	d_share_rev_tlm_amt		= 0;
	d_share_rev_cur_amt		= 0;
	d_settle_tlm_amt		= 0;
	d_settle_cur_amt		= 0;
	d_paid_tlm_amt			= 0;
	d_payable_cur_amt		= 0;
	d_paid_cur_amt			= 0;

	/* EXEC SQL FETCH DR_PAY_CUR 
             INTO :d_month,
			:d_year,
			:d_doctor_id, 
			:d_doctor_name,
			:d_contract_ref,
			:d_contract_from,
			:d_contract_to,
			:d_share_rev_tlm_amt,
			:d_share_rev_cur_amt,
			:d_settle_tlm_amt,
			:d_settle_cur_amt,
			:d_paid_tlm_amt,
			:d_payable_cur_amt,
			:d_paid_cur_amt,
			:d_pmnt_doc_type,
			:d_pmnt_doc_num,
			:d_pmnt_doc_line_num,
			:d_pmnt_doc_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )71;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_month;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_year;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_doctor_id;
 sqlstm.sqhstl[2] = (unsigned int  )18;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_doctor_name;
 sqlstm.sqhstl[3] = (unsigned int  )33;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_contract_ref;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_contract_from;
 sqlstm.sqhstl[5] = (unsigned int  )14;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_contract_to;
 sqlstm.sqhstl[6] = (unsigned int  )14;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_share_rev_tlm_amt;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_share_rev_cur_amt;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_settle_tlm_amt;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_settle_cur_amt;
 sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_paid_tlm_amt;
 sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_payable_cur_amt;
 sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&d_paid_cur_amt;
 sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&d_pmnt_doc_type;
 sqlstm.sqhstl[14] = (unsigned int  )9;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&d_pmnt_doc_num;
 sqlstm.sqhstl[15] = (unsigned int  )11;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&d_pmnt_doc_line_num;
 sqlstm.sqhstl[16] = (unsigned int  )7;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&d_pmnt_doc_date;
 sqlstm.sqhstl[17] = (unsigned int  )14;
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
		err_mesg("FETCH failed on cursor DR_PAY_CUR ",0,"");

	d_doctor_id.arr[d_doctor_id.len]				= '\0';
	d_doctor_name.arr[d_doctor_name.len]			= '\0';
	d_contract_ref.arr[d_contract_ref.len]			= '\0';
	d_contract_from.arr[d_contract_from.len]		= '\0';
	d_contract_to.arr[d_contract_to.len]			= '\0';
	d_pmnt_doc_type.arr[d_pmnt_doc_type.len]		= '\0';
	d_pmnt_doc_num.arr[d_pmnt_doc_num.len]			= '\0';
	d_pmnt_doc_line_num.arr[d_pmnt_doc_line_num.len]= '\0';
	d_pmnt_doc_date.arr[d_pmnt_doc_date.len]		= '\0';

	return(LAST_ROW?0:1);
}

close_dr_pay_cur()
{
	/* EXEC SQL CLOSE DR_PAY_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )158;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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

	fprintf(fp,"%30.30s %10.10s : %-s\n",loc_legend[6],loc_legend[8],nd_from_doctor_id.arr);
	fprintf(fp,"%41.41s : %-s\n\n",loc_legend[9],nd_to_doctor_id.arr);

	fprintf(fp,"%30.30s %10.10s : %-s\n",loc_legend[11],loc_legend[8],nd_from_contract_ref.arr);
	fprintf(fp,"%41.41s : %-s\n\n",loc_legend[9],nd_to_contract_ref.arr);

	fprintf(fp,"\n");	
	
    next_page();
}

next_page() 
{
	fprintf(fp,"\n");
	fprintf(fp,"\f");
	lctr=0;
	 
	print_page_title();
	print_column_title();	
}

print_column_title()
{
      fprintf(fp,"%10s %-31.31s %-31.31s %-15.15s %-15.15s %-15.15s %-30.30s",
	  " ",loc_legend[14],loc_legend[15],loc_legend[16],loc_legend[17],loc_legend[16], loc_legend[18]);

      next_line(1);

      fprintf(fp, "%-10.10s %15.15s %15.15s %15.15s %15.15s %15.15s %15.15s %15.15s %-20.20s %-10.10s",
	  loc_legend[24],loc_legend[19],loc_legend[20],loc_legend[19],loc_legend[20],loc_legend[19],loc_legend[20],loc_legend[20],loc_legend[21],loc_legend[22]);

      next_line(1);
      print_line('-',REP_WIDTH);
	  next_line(1);
}

open_files()
{
	strcpy(filename,WORKING_DIR);
	strcat(filename,"DFR00011.lis");

	if ((fp = fopen(filename,"w")) == NULL)
	{
		disp_message(ERR_MESG,"Error in opening file DFR00011.lis");
		proc_exit();
	}
}

get_sy_prog_param()
 {
	nd_from_doctor_id.arr[0] = '\0';
	nd_to_doctor_id.arr[0] = '\0';

	nd_from_contract_ref.arr[0] = '\0';
	nd_to_contract_ref.arr[0]	= '\0';

	nd_from_contract_ref.len = 0;
	nd_to_contract_ref.len = 0;

	nd_from_doctor_id.len =0;
	nd_to_doctor_id.len =0;
			
    /* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,PARAM4
	 INTO	:nd_from_doctor_id,
			:nd_to_doctor_id,
			:nd_from_contract_ref,
			:nd_to_contract_ref
	FROM SY_PROG_PARAM
            WHERE PGM_ID   = :nd_curr_pgm_id
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 into :b0,:b1,:b2,:b\
3  from SY_PROG_PARAM where ((PGM_ID=:b4 and SESSION_ID=:b5) and PGM_DATE=:b6)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )173;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_doctor_id;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_doctor_id;
    sqlstm.sqhstl[1] = (unsigned int  )18;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_from_contract_ref;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_contract_ref;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_curr_pgm_id;
    sqlstm.sqhstl[4] = (unsigned int  )17;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[5] = (unsigned int  )18;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[6] = (unsigned int  )27;
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
		err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

	if (NODATAFOUND)
		err_mesg("No Record found in SY_PROG_PARAM",0,"");
	
	nd_from_doctor_id.arr[nd_from_doctor_id.len] = '\0';
	nd_to_doctor_id.arr[nd_to_doctor_id.len] = '\0';
	nd_from_contract_ref.arr[nd_from_contract_ref.len] = '\0';
	nd_to_contract_ref.arr[nd_to_contract_ref.len]	= '\0';

	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :nd_curr_pgm_id
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION_I\
D=:b1) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )216;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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

		/* EXEC SQL SELECT LTRIM(RTRIM('DFR00011.LEGEND_'||
				LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		         INTO :l_pk_value
			 FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('DFR00011.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )243;
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )266;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
  sqlstm.sqhstl[3] = (unsigned int  )7;
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
	if (strlen(loc_legend[170]) > 0)
	split_text(loc_legend[170],5,loc_legend170_1,&r_ctr);
	if (strlen(loc_legend[170]) > 5)	
	split_text(loc_legend[170],5,loc_legend170_2,&r_ctr);

	r_ctr = 0;
	if (strlen(loc_legend[180]) > 0)
	split_text(loc_legend[180],15,loc_legend180_1,&r_ctr);
	if (strlen(loc_legend[180]) > 15)	
	split_text(loc_legend[180],15,loc_legend180_2,&r_ctr);

	r_ctr = 0;
	if (strlen(loc_legend[210]) > 0)
	split_text(loc_legend[210],15,loc_legend210_1,&r_ctr);
	if (strlen(loc_legend[210]) > 15)	
	split_text(loc_legend[210],15,loc_legend210_2,&r_ctr);
	

}

check_line(skip) 
int skip;
{
	if ((lctr + skip) >= MAX_LINES)
	{
		next_page();
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
		fprintf(fp,"\n"); ++lctr; 
	}
 }
        
print_page_title()
  {

	int hosp_nm_len,date1_len, rep_title_len = 10,
	    s1, s2,date_len,user_len,
	    pgm_len,sub_title_len;

	char v_rep_title[200],v_as_on_date[12],v_sub_title[200],v_title[200],
	     v_title1[200];
   
	fprintf(fp,"\n%3.3s : DF",loc_legend[1]);
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(fp,"%s", d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	date1_len=4; //strlen(loc_legend[4]);
	horz_skip(s2-date1_len-13);
	fprintf(fp,"%4.4s : %s", loc_legend[4],d_curr_date.arr);
    
	next_line(1);
	
	fprintf(fp,"%3.3s : %s", loc_legend[2],d_user.arr); 	
        
	//user_len=strlen(d_user.arr);
	//strcpy(v_rep_title," ");
	//rep_title_len = strlen(v_rep_title);
	//s1 = (REP_WIDTH-rep_title_len)/2;
	//strcpy(v_as_on_date,nd_as_on_date.arr);
	//date_len= strlen(v_as_on_date);
	//horz_skip(s1-user_len-6);
	//fprintf(fp,"%s",v_rep_title);
   	//s2 = (REP_WIDTH-s1-rep_title_len);
	//horz_skip(s2-24);
	//fprintf(fp,"%9s : %10s",loc_legend[220],d_curr_date.arr);

	next_line(1);

	fprintf(fp,"%3.3s : %s",loc_legend[3],nd_curr_pgm_id.arr);
        pgm_len=strlen(nd_curr_pgm_id.arr);	 
	
	strcpy(v_sub_title,loc_legend[23]);

	sub_title_len = strlen(v_sub_title);
	s1 = (REP_WIDTH-sub_title_len)/2;
   	horz_skip(s1-pgm_len-6);
        fprintf(fp,"%s",v_sub_title);

        s2 = (REP_WIDTH-s1-sub_title_len);
	horz_skip(s2-17);
	fprintf(fp,"%4.4s : %-10d",loc_legend[5],++page_no);
	next_line(1);  
   
	lctr = 4;
	print_line('-',REP_WIDTH); 
	next_line(1);

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
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select acc_entity_name ,user ,to_char(sysdate,'DD/MM/YYYY') \
into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )297;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
 sqlstm.sqhstl[0] = (unsigned int  )33;
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
	int i;
	for(i=0;i<n;i++)
	fprintf(fp,"%c",ch);
	}
     
horz_skip(num) /* this is to obtain required blank space */
int num;
	{
	int i;
	for(i=0;i<num;i++)fprintf(fp," ");
	}
