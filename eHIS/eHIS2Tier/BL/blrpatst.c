
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
           char  filnam[22];
};
static const struct sqlcxp sqlfpn =
{
    21,
    "C:\\10xdev\\blrpatst.pc"
};


static unsigned long sqlctx = 139599403;


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

 static const char *sq0010 = 
"select to_char(doc_date,'dd/mm/yyyy hh24:mi') ,((((doc_type_code||'/')||DOC_\
NUMBER)||'/')||DOC_SLNO) ,trx_type ,decode(:b0,'N',debit_amt,decode(sign(outst\
dg_amt),1,outstdg_amt,0)) debit_amt ,decode(:b0,'N',credit_amt,decode(sign(out\
stdg_amt),(-1),((-1)* outstdg_amt),0)) credit_amt ,decode(episode_type,null ,'\
 ','R',' ',((((episode_type||'/')||nvl(to_char(episode_id),' '))||'/')||nvl(to\
_char(visit_id),' '))) ,sign((trunc(doc_date)-to_date(:b2,'dd/mm/yyyy'))) ,out\
stdg_amt  from bl_patient_statement_vw where (patient_id=:b3 and ((:b4='O' and\
 (:b0='N' or ((:b0='Y' and outstdg_amt<>0) and valid_for_outstdg_yn='Y'))) or \
((:b4='A' and outstdg_amt<>0) and valid_for_outstdg_yn='Y'))) order by doc_dat\
e            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,193,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,253,0,0,0,0,0,1,0,
51,0,0,3,71,0,4,321,0,0,2,1,0,1,0,1,9,0,0,2,4,0,0,
74,0,0,4,395,0,4,630,0,0,18,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,
3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,
161,0,0,5,84,0,2,701,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
188,0,0,6,191,0,4,715,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,
9,0,0,
227,0,0,7,155,0,4,752,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,1,9,0,0,
262,0,0,8,123,0,4,783,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
297,0,0,9,176,0,4,818,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,
9,0,0,
336,0,0,10,0,0,15,936,0,0,0,0,0,1,0,
351,0,0,10,713,0,9,941,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,
9,0,0,1,9,0,0,1,1,0,0,
398,0,0,10,0,0,13,969,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,
9,0,0,2,4,0,0,2,4,0,0,
445,0,0,11,79,0,4,1022,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
468,0,0,12,96,0,4,1122,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
491,0,0,13,165,0,6,1129,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
522,0,0,14,215,0,6,1150,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
549,0,0,15,199,0,6,1175,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/*  Output File : blrpatst.lis  */


#include <stdio.h>  
#include <math.h> 
#include <string.h>
#include <bl.h>

#define ONLINE_PRINTING 1 

#define MAX_LINES 60
#define MAX_COL   109
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define ESC     0x1B
#define VER  "VER : 1.10.01\n"

/* EXEC SQL BEGIN DECLARE SECTION; */ 

                                      
/* VARCHAR	    uid_pwd						[50], 
			nd_pgm_id					[30],
			nd_patient_id				[21],
			nd_as_on_date				[15],
			nd_bill_ageing_report_flag	[2],
			nd_outst_bills_only_flag	[2], 
			nd_bill_ageing_report_type	[2],		
			d_acc_entity_name			[41],
			nd_print_option             [2],
			nd_line_text                [1000],
			d_user						[21],
			nd_month_year1              [20],
        	d_sysdate					[20],
			nd_from_date				[12],
			nd_to_date					[12],		
   	  		nd_patient_name				[61],
			nd_national_id				[50],
        	nd_dob						[15],
			nd_area						[16],
			nd_town						[16],
			nd_session_id				[16],
			nd_pgm_date					[20],
			nd_phone					[21],
			d_bill_date1				[15],
			nd_facility_id				 [3],
			l_pk_value					[100],
			l_translated_value			[202],
			p_language_id				[3],
            nd_bill_date				[15]; */ 
struct { unsigned short len; unsigned char arr[50]; } uid_pwd;

struct { unsigned short len; unsigned char arr[30]; } nd_pgm_id;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[15]; } nd_as_on_date;

struct { unsigned short len; unsigned char arr[2]; } nd_bill_ageing_report_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_outst_bills_only_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_bill_ageing_report_type;

struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[2]; } nd_print_option;

struct { unsigned short len; unsigned char arr[1000]; } nd_line_text;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[20]; } nd_month_year1;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate;

struct { unsigned short len; unsigned char arr[12]; } nd_from_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_date;

struct { unsigned short len; unsigned char arr[61]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[50]; } nd_national_id;

struct { unsigned short len; unsigned char arr[15]; } nd_dob;

struct { unsigned short len; unsigned char arr[16]; } nd_area;

struct { unsigned short len; unsigned char arr[16]; } nd_town;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[21]; } nd_phone;

struct { unsigned short len; unsigned char arr[15]; } d_bill_date1;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[202]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[15]; } nd_bill_date;


/* VARCHAR		d_patient_id				[21],
		    d_physician_id				[21],
	        d_bill_date					[15], 
      		d_bill_type					[11],
	        d_trans_det					[15],
	        d_bill_no					[15],
			d_receipt_no				[15],
            rep_date					[20],
            comp_name					[50],
            oper_id						[21],
	        nd_age_bill_num				[15] ; */ 
struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_physician_id;

struct { unsigned short len; unsigned char arr[15]; } d_bill_date;

struct { unsigned short len; unsigned char arr[11]; } d_bill_type;

struct { unsigned short len; unsigned char arr[15]; } d_trans_det;

struct { unsigned short len; unsigned char arr[15]; } d_bill_no;

struct { unsigned short len; unsigned char arr[15]; } d_receipt_no;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[15]; } nd_age_bill_num;


/* VARCHAR		nd_bill_no1					[15],
			nd_bill_date1				[12],
			nd_cons_invoice_ind			[2],
			d_order_date				[12]; */ 
struct { unsigned short len; unsigned char arr[15]; } nd_bill_no1;

struct { unsigned short len; unsigned char arr[12]; } nd_bill_date1;

struct { unsigned short len; unsigned char arr[2]; } nd_cons_invoice_ind;

struct { unsigned short len; unsigned char arr[12]; } d_order_date;


/* VARCHAR		nd_resp_for_bill_payment	[31],
			nd_credit_doc_ref			[16],
			nd_practice_num				[16],
			p_ws_no						[16]; */ 
struct { unsigned short len; unsigned char arr[31]; } nd_resp_for_bill_payment;

struct { unsigned short len; unsigned char arr[16]; } nd_credit_doc_ref;

struct { unsigned short len; unsigned char arr[16]; } nd_practice_num;

struct { unsigned short len; unsigned char arr[16]; } p_ws_no;



int			nd_ageing_days1,
			nd_cut1_bills=0,
			nd_cut2_bills=0,
			nd_cut3_bills=0,
			nd_cut4_bills=0,
			nd_total_bills=0,
			nd_cts_flag = 0,
			bill_ct		= 0,
			nd_cut_bills =0,
			i,
			hl = 95,
			initialise=1,
			age_analysis=1;		
		
double		nd_bill_tot_amt1,
			nd_cut1_amt =0,
			nd_cut2_amt =0,
			nd_cut3_amt =0,
			nd_cut4_amt =0,
			nd_cut1s_amt =0,
			nd_cut2s_amt =0,
			nd_cut3s_amt =0,
			nd_cut4s_amt =0,
			nd_age_tot   =0,
			nd_dcp_tot   =0,
			nd_ar_tot    =0,
			nd_grand_tot =0;

/* VARCHAR 	nd_mail_add1[31],
			nd_mail_add2[31],
			nd_mail_add3[31],
			nd_mail_add4[31],
			nd_postal_code[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } nd_mail_add1;

struct { unsigned short len; unsigned char arr[31]; } nd_mail_add2;

struct { unsigned short len; unsigned char arr[31]; } nd_mail_add3;

struct { unsigned short len; unsigned char arr[31]; } nd_mail_add4;

struct { unsigned short len; unsigned char arr[31]; } nd_postal_code;


/* varchar     nd_month_year[10]; */ 
struct { unsigned short len; unsigned char arr[10]; } nd_month_year;


double 		d_debit			 = 0,
    		d_credit		 = 0,
			d_prev_balance   = 0,
			nd_ct            = 0,
			nd_cut_range     = 0,
			d_balance         =0;

int 		nd_order_catg,
			nd_total_bills1 = 0,
			nd_cut1,
			nd_cut2,
	        nd_counter = 0,
			nd_cut3;
double		nd_days;

char		filename[150],sex,txn_type,nd_online_print_yn;

/* VARCHAR     doc_date[21],
            nd_prev_date[15],
            doc_det[20],
			trx_type[15],
			episode_det[20]; */ 
struct { unsigned short len; unsigned char arr[21]; } doc_date;

struct { unsigned short len; unsigned char arr[15]; } nd_prev_date;

struct { unsigned short len; unsigned char arr[20]; } doc_det;

struct { unsigned short len; unsigned char arr[15]; } trx_type;

struct { unsigned short len; unsigned char arr[20]; } episode_det;


/* Varchar		nd_cut1_str[30],
			nd_cut2_str[30],
			nd_cut3_str[30],
			nd_cut4_str[30],
			str_temp[500],
			currency[7]; */ 
struct { unsigned short len; unsigned char arr[30]; } nd_cut1_str;

struct { unsigned short len; unsigned char arr[30]; } nd_cut2_str;

struct { unsigned short len; unsigned char arr[30]; } nd_cut3_str;

struct { unsigned short len; unsigned char arr[30]; } nd_cut4_str;

struct { unsigned short len; unsigned char arr[500]; } str_temp;

struct { unsigned short len; unsigned char arr[7]; } currency;


/* VARCHAR     nd_temp_date[20],
			nd_loc_date	[20],
			date_convert[20]; */ 
struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[20]; } date_convert;



double      debit_amt=0,
            credit_amt=0,
			sign_ind = 0,
			tot_debit_amt=0,
			tot_credit_amt=0,
			open_bal=1;

char	loc_legend[999][201];

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA;
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

int   line=0, 
      page=1,
	spaces=0;

FILE *f1;
 
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

void proc_main(argc, argv)
int argc;
char *argv[];
{
   if(argc < 4) 
   {
     disp_message(ERR_MESG,"Usage blrpatst uid/passwd session_id pgm_date");
     proc_exit();
   }
    
    strcpy(nd_pgm_id.arr, argv[0]);
    nd_pgm_id.len = strlen(nd_pgm_id.arr);


   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 

   strcpy(nd_facility_id.arr, argv[4]);
   nd_facility_id.len = strlen(nd_facility_id.arr); 
   
   /* EXEC SQL CONNECT :uid_pwd; */ 

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
   sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
   sqlstm.sqhstl[0] = (unsigned int  )52;
   sqlstm.sqhsts[0] = (         int  )52;
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


   if (OERROR)
   { disp_message(ORA_MESG,"Connect failed");
     proc_exit();
   }

    set_meduser_role();

    strcpy(p_language_id.arr,l_language_id.arr);
    p_language_id.len = l_language_id.len;

    fetch_legend_value();

    get_sy_prog_param();        

    strcpy(filename,WORKING_DIR);
    strcat(filename,nd_pgm_id.arr);
    if (nd_online_print_yn == 'N')
    {
	strcat(filename,"_");
	strcat(filename,nd_patient_id.arr);
    }
    strcat(filename,".lis");

   if((f1 = fopen(filename, "w")) == NULL) {
     disp_message(ERR_MESG,"Error opening output file");
     proc_exit();
     } 

   get_header_dtls();
    
   nd_cts_flag = 0;

   rep_bill_process_out();


 
 if(nd_bill_ageing_report_flag.arr[0]=='Y')
 {
   if(line+6>MAX_LINES)
   {
    fprintf(f1,"\f");	
    line = 0;
    page = page +1;
    page_hdr('Y','A');
  }
  else
   {
    page_hdr('N','A');
   }

    rep_bill_process_age();
 }
   fclose(f1);
   
   if (nd_online_print_yn == 'Y')
   {
	printdoc();
   }

   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )36;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   return;
}   

rep_bill_process_out()
{   
   get_pat_dtls();  
   page_hdr('Y','O');    
   txn_type='O';
   declare_cursor_stat_out();
   open_cursor_stat_out();
   
    while(fetch_cursor_stat_out())
   {
    line_check('Y','O');
    if((open_bal==1) && sign_ind>=0)
    {
     put_bal('O','O');
     open_bal=0;
    }

    tot_debit_amt=tot_debit_amt+debit_amt;
    tot_credit_amt=tot_credit_amt+credit_amt;
    
	if(doc_date.arr[0]!='\0')
	 {
	   init_date_temp_var();
       strcpy(date_convert.arr,doc_date.arr);
       fun_change_loc_date();
     }	  

	if(!open_bal)
    {
             
    fprintf(f1,"%-17.17s %-17.17s%-15.15s ",date_convert.arr,doc_det.arr,trx_type.arr);
    print_formated_out(debit_amt,'N');    
    print_formated_out(credit_amt,'N');
    print_formated_out(tot_debit_amt - tot_credit_amt,'Y');
    fprintf(f1," %-20.20s",episode_det.arr);
    fprintf(f1,"\n");
    line=line+1;
    }
   }
   put_bal('C','O');
   close_cursor_stat_out();  
}

rep_bill_process_age()
{   
    txn_type='A';
    declare_cursor_stat_out();
    open_cursor_stat_out();
    open_bal=1;
   
    while(fetch_cursor_stat_out())
   {
    nd_cut1_amt=0;
    nd_cut2_amt=0;
    nd_cut3_amt=0;
    nd_cut4_amt=0;

    line_check('Y','A');
    if((open_bal==1) && sign_ind>=0)
    {
     put_bal('O','A');
     open_bal=0;
    }

    /* EXEC SQL  Select sysdate - to_date(:doc_date,'dd/mm/yyyy hh24:mi')
         into :nd_days
   from dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (sysdate-to_date(:b0,'dd/mm/yyyy hh24:mi')) into :\
b1  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )51;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&doc_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_days;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
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
   { 
     disp_message(ORA_MESG,"Select failed from dual");
     proc_exit();
   }
  
   if (nd_days <=nd_cut1)
     {
      nd_cut1_amt=d_balance;
      nd_cut1s_amt=nd_cut1s_amt+d_balance;
      }
   else if (nd_days <=nd_cut2)
    {
     nd_cut2_amt=d_balance;
     nd_cut2s_amt=nd_cut2s_amt+d_balance;
    }
   else if (nd_days <=nd_cut3) 
    {
     nd_cut3_amt=d_balance;
     nd_cut3s_amt=nd_cut3s_amt+d_balance;
    }
   else
    {
     nd_cut4_amt=d_balance;
     nd_cut4s_amt=nd_cut4s_amt+d_balance;
    }
    
    if(doc_date.arr[0]!='\0')
     {
	   init_date_temp_var();
       strcpy(date_convert.arr,doc_date.arr);
       fun_change_loc_date();
     }	  

  
    if(!open_bal && nd_bill_ageing_report_type.arr[0]=='D') 
    {

	
    fprintf(f1,"%-17.17s %-17.17s%-15.15s ",date_convert.arr,doc_det.arr,trx_type.arr);
    print_formated_age(nd_cut1_amt,'Y');    
    print_formated_age(nd_cut2_amt,'Y');
    print_formated_age(nd_cut3_amt,'Y'); 
    print_formated_age(nd_cut4_amt,'Y'); 
    fprintf(f1,"\n");
    line=line+1;
    }

   }
   put_bal('S','A');
   close_cursor_stat_out();  
}




line_check(char header,char trx_type)
{
   if (line  > MAX_LINES)
   {
    put_bal('E',trx_type);//Carry Forward 
    fprintf(f1,"\f");	
    line = 0;
    page = page +1;
    page_hdr(header,trx_type);	
    put_bal('B',trx_type);//Brought Forward
   }       
}

page_hdr(char header,char trx_type)
{

if (initialise)
{
 fprintf(f1,"%cE",ESC);
 fprintf(f1,"%c&l0O",ESC); 	/* To Print in Portait Mode 		*/
 fprintf(f1,"%c&a2L",ESC); 	/* To Set the Left margin  		*/
 fprintf(f1,"%c(s14H",ESC); 	/* To set the font 			*/
 initialise=0;
}


if(header=='Y')
{
//spaces=(MAX_COL - comp_name.len)/2; COMMNETED BY SAIKIRAN FOR 21441
 fprintf(f1,"\n");
/*spaces=spaces-10;
 prt_line(spaces," "); COMMNETED BY SAIKIRAN FOR 21441 */
 
 fun_centre(comp_name.arr,110);
 fprintf(f1,"%-36.36s",comp_name.arr);
/*fprintf(f1,"%30s",comp_name.arr);
 spaces=(MAX_COL - 16) - (spaces+30);
 prt_line(spaces," ");COMMNETED BY SAIKIRAN FOR 21441 */

 if(rep_date.arr[0]!='\0')
 {
   init_date_temp_var();
   strcpy(date_convert.arr,rep_date.arr);
   fun_change_loc_date();
  }
 fprintf(f1,"%13.13s","");
 fprintf(f1,"%-s\n",date_convert.arr);
 /*spaces=(MAX_COL - (nd_patient_name.len+strlen(loc_legend[1])))/2;
 prt_line(spaces," ");COMMNETED BY SAIKIRAN FOR 21441 */

 //fprintf(f1,"STATEMENT OF ACCOUNT FOR:%-30.30s",nd_patient_name.arr);
 //fprintf(f1,"%s:%s",loc_legend[1],nd_patient_name.arr);COMMNETED BY SAIKIRAN FOR 21441
 fun_centre(loc_legend[1],90);
 fprintf(f1,"%-s",loc_legend[1]);
 fprintf(f1,":%-19.19s ",nd_patient_name.arr);
  
 
  if (strcmp(nd_month_year.arr,"01/1900")==0) 
   {
 	  fprintf(f1,"%-4.4s:%-6.6s %4.4s",loc_legend[25],loc_legend[24]," ");
  }
 else
 {
   fprintf(f1,"%-4.4s: %-s %4.4s",loc_legend[25],nd_month_year.arr," ");
 } 
/* spaces=(MAX_COL-15 ) - (spaces+nd_patient_name.len+strlen(loc_legend[1]));
 prt_line(spaces," ");COMMNETED BY SAIKIRAN FOR 21441*/

//fprintf(f1,"Page :%3d\n",page);
 fprintf(f1," %-4.4s:%3d\n",loc_legend[2],page); 


 replicate(hl,MAX_COL);
 fprintf(f1,"\n");
 line = line + 4;
 //fprintf(f1,"Patient No      : %-20.20s ",nd_patient_id.arr);
 fprintf(f1,"%-16.16s: %-20.20s ",loc_legend[3],nd_patient_id.arr);

 //fprintf(f1," National Id : %-20.20s ",nd_national_id.arr);
 fprintf(f1,"%-13.13s: %-20.20s ",loc_legend[4],nd_national_id.arr);

 //fprintf(f1," DOB : %-10.10s ",nd_dob.arr);

 if(nd_dob.arr[0]!='\0')
 {
   init_date_temp_var();
   strcpy(date_convert.arr,nd_dob.arr);
   fun_change_loc_date1();
  }

 fprintf(f1,"%-5.5s: %-10.10s ",loc_legend[5],date_convert.arr);

 //DOB
 if(sex=='M')
   fprintf(f1,"%-5.5s: %s",loc_legend[6],loc_legend[22]);
 else
   fprintf(f1,"%-5.5s: %s",loc_legend[6],loc_legend[23]);

 fprintf(f1,"\n");
 nd_ct = 0;
 //fprintf(f1,"Patient Address : ");
 fprintf(f1,"%-16.16s: ",loc_legend[7]);
 line = line + 2;

  if (nd_mail_add1.arr[0])
     {
      nd_ct = 1;
      fprintf(f1,"%-30.30s",nd_mail_add1.arr);
      line = line + 1;
      fprintf(f1,"\n");
      }
  if (nd_mail_add2.arr[0])
     {
      nd_ct = 1;
      if (nd_ct == 1 )
      {
      fprintf(f1,"                  %-30s",nd_mail_add2.arr);
      }
      else
      {
      fprintf(f1,"%-30.30s",nd_mail_add2.arr);
      }
      line = line + 1;
      fprintf(f1,"\n");
     }
  if (nd_mail_add3.arr[0])
     {
      nd_ct = 1;
      if (nd_ct == 1 )
      {
       fprintf(f1,"                  %-30s",nd_mail_add3.arr);
      }
      else
      {
       fprintf(f1,"%-30.30s",nd_mail_add3.arr);
      }
      line = line + 1;
      fprintf(f1,"\n");
      }
  if (nd_mail_add4.arr[0])
     {
      nd_ct = 1;
      if (nd_ct == 1)
      {
       fprintf(f1,"                  %-30s",nd_mail_add4.arr);
      }
      else
      {
      fprintf(f1,"%-30.30s",nd_mail_add4.arr);
      }	
      line = line + 1;
      fprintf(f1,"\n");
     }
     
     if  (nd_ct==0) 
     {
      fprintf(f1,"\n"); 
      line=line+1;
     }
      replicate(hl,MAX_COL);
      fprintf(f1,"\n"); 
      line = line + 2;
 }    

 if(trx_type=='O') //Oustanding Balance
 {
//   fprintf(f1,"Trx Date          Document        Trx Type                Debit        Credit         Balance  Encounter");               
   fprintf(f1,"%-18.18s%-17.17s%-15.15s%15.15s %13.13s%14.13s   %s",
           loc_legend[8],loc_legend[9],loc_legend[10],loc_legend[11],loc_legend[12],loc_legend[13],loc_legend[14]
	   );
   fprintf(f1,"\n"); 
   fprintf(f1,"                                                    %s        %s             %s            ",currency.arr,currency.arr,currency.arr);               
   fprintf(f1,"\n"); 
   replicate(hl,MAX_COL);
   fprintf(f1,"\n"); 
   line = line + 3;
 }

 if(trx_type=='A') //Ageing Analysis 
 {

   if(age_analysis)
   {
   //fprintf(f1,"Ageing Analysis :");
   fprintf(f1,"%-16.16s:",loc_legend[19]);
   fprintf(f1,"\n"); 
   replicate(hl,MAX_COL);
   fprintf(f1,"\n"); 
   line = line + 2;
   age_analysis=0;
   }

   //fprintf(f1,"Trx Date          Document        Trx Type        ");
   fprintf(f1,"%-18.18s%-17.17s%-16.16s",loc_legend[8],loc_legend[9],loc_legend[10]);
   fprintf(f1,"%13s%14s%14s%14s",nd_cut1_str.arr,nd_cut2_str.arr,nd_cut3_str.arr,nd_cut4_str.arr);
   fprintf(f1,"\n"); 
   fprintf(f1,"                                                ");
   fprintf(f1,"%14s%14s%14s%14s",currency.arr,currency.arr,currency.arr,currency.arr);
   fprintf(f1,"\n"); 
   replicate(hl,MAX_COL);
   fprintf(f1,"\n"); 
   line = line + 3;
 }


}

prt_line(int line_length, char spl_symbol[1])
{  
 int i;  
  for(i=1;i<=line_length;i=i+1)
	 {fprintf(f1,spl_symbol);}
}


get_sy_prog_param()
{
   nd_patient_id.arr[0]='\0';
   nd_as_on_date.arr[0]='\0';
   nd_bill_ageing_report_flag.arr[0]='\0';
   nd_outst_bills_only_flag.arr[0]='\0';
   nd_bill_ageing_report_type.arr[0]='\0';
   nd_month_year.arr[0]='\0';
   nd_cut1_str.arr[0]='\0';
   nd_cut2_str.arr[0]='\0';
   nd_cut3_str.arr[0]='\0';
   nd_cut4_str.arr[0]='\0';
   p_ws_no.arr[0]='\0';

   nd_patient_id.len=0;
   nd_as_on_date.len=0;
   nd_bill_ageing_report_flag.len=0;
   nd_outst_bills_only_flag.len=0;
   nd_bill_ageing_report_type.len=0;
   nd_month_year.len=0;
   nd_cut1_str.len=0;
   nd_cut2_str.len=0;
   nd_cut3_str.len=0;
   nd_cut4_str.len=0;
   p_ws_no.len=0;



   nd_cut1 = 0;
   nd_cut2 = 0;
   nd_cut3 = 0;
  
   


  /* EXEC SQL  SELECT 
		   PARAM1,
		   PARAM2,
		   PARAM3,
		   NVL(PARAM4,0),
		   NVL(PARAM5,0),
		   NVL(PARAM6,0),
		   '<='||NVL(PARAM4,0),
		   '<='||NVL(PARAM5,0),
                   '<='||NVL(PARAM6,0),
                   '>'||NVL(PARAM6,0),
		   PARAM7,
		   PARAM8,
                   substr(PARAM7,4,7),
		   param9,
		   NVL(param10,'Y')
            INTO 
		   :nd_patient_id,
   		   :nd_bill_ageing_report_flag,
		   :nd_bill_ageing_report_type,
		   :nd_cut1,
		   :nd_cut2,
		   :nd_cut3,
		   :nd_cut1_str,
                   :nd_cut2_str,
		   :nd_cut3_str,
		   :nd_cut4_str,
		   :nd_from_date,
		   :nd_outst_bills_only_flag,
		   :nd_month_year,
		   :p_ws_no,
		   :nd_online_print_yn
            FROM   SY_PROG_PARAM
	    WHERE  PGM_ID = upper(:nd_pgm_id) 
  	    AND    SESSION_ID = TO_NUMBER(:nd_session_id)
	    AND    PGM_DATE = :nd_pgm_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,NVL(PARAM4,0) ,NVL(PARAM5,0)\
 ,NVL(PARAM6,0) ,('<='||NVL(PARAM4,0)) ,('<='||NVL(PARAM5,0)) ,('<='||NVL(PARA\
M6,0)) ,('>'||NVL(PARAM6,0)) ,PARAM7 ,PARAM8 ,substr(PARAM7,4,7) ,param9 ,NVL(\
param10,'Y') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,\
:b14  from SY_PROG_PARAM where ((PGM_ID=upper(:b15) and SESSION_ID=TO_NUMBER(:\
b16)) and PGM_DATE=:b17)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )74;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_bill_ageing_report_flag;
  sqlstm.sqhstl[1] = (unsigned int  )4;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_bill_ageing_report_type;
  sqlstm.sqhstl[2] = (unsigned int  )4;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_cut1;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_cut2;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_cut3;
  sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_cut1_str;
  sqlstm.sqhstl[6] = (unsigned int  )32;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_cut2_str;
  sqlstm.sqhstl[7] = (unsigned int  )32;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_cut3_str;
  sqlstm.sqhstl[8] = (unsigned int  )32;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_cut4_str;
  sqlstm.sqhstl[9] = (unsigned int  )32;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_from_date;
  sqlstm.sqhstl[10] = (unsigned int  )14;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_outst_bills_only_flag;
  sqlstm.sqhstl[11] = (unsigned int  )4;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_month_year;
  sqlstm.sqhstl[12] = (unsigned int  )12;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&p_ws_no;
  sqlstm.sqhstl[13] = (unsigned int  )18;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_online_print_yn;
  sqlstm.sqhstl[14] = (unsigned int  )1;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_pgm_id;
  sqlstm.sqhstl[15] = (unsigned int  )32;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_session_id;
  sqlstm.sqhstl[16] = (unsigned int  )18;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&nd_pgm_date;
  sqlstm.sqhstl[17] = (unsigned int  )22;
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
      {   disp_message(ORA_MESG,"Oracle error at get_sy_prog_param() occured");
	  proc_exit();
      }

    if (NODATAFOUND)
      {   
       disp_message(ORA_MESG,"No Record Found in sy_prog_param");
       proc_exit();
      }


    nd_patient_id.arr[nd_patient_id.len]='\0';
    nd_as_on_date.arr[nd_as_on_date.len]='\0';
    nd_bill_ageing_report_flag.arr[nd_bill_ageing_report_flag.len]='\0';
    nd_bill_ageing_report_type.arr[nd_bill_ageing_report_type.len]='\0';
    nd_outst_bills_only_flag.arr[nd_outst_bills_only_flag.len]='\0';
    nd_facility_id.arr[nd_facility_id.len]='\0';
    nd_from_date.arr[nd_from_date.len] = '\0';   
    nd_to_date.arr[nd_to_date.len] = '\0';
    nd_month_year.arr[nd_month_year.len]='\0';
    nd_cut1_str.arr[nd_cut1_str.len]='\0';
    nd_cut2_str.arr[nd_cut1_str.len]='\0';
    nd_cut3_str.arr[nd_cut1_str.len]='\0';
    nd_cut4_str.arr[nd_cut1_str.len]='\0';
    p_ws_no.arr[p_ws_no.len]='\0';

    strcpy(g_facility_id, nd_facility_id.arr);

    strcat(nd_cut1_str.arr,loc_legend[20]);
    strcat(nd_cut2_str.arr,loc_legend[20]);
    strcat(nd_cut3_str.arr,loc_legend[20]);
    strcat(nd_cut4_str.arr,loc_legend[20]);


    /* EXEC SQL DELETE FROM sy_prog_param
    WHERE PGM_ID   = :nd_pgm_id
    AND SESSION_ID = :nd_session_id
    AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from sy_prog_param  where ((PGM_ID=:b0 and SESSIO\
N_ID=:b1) and PGM_DATE=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )161;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_pgm_id;
    sqlstm.sqhstl[0] = (unsigned int  )32;
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
    sqlstm.sqhstl[2] = (unsigned int  )22;
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
      {   disp_message(ORA_MESG,"Oracle error at get_sy_prog_param() occured");
	  proc_exit();
      }

    currency.arr[0]='\0';  
    currency.len=0;
    
	/* EXEC SQL SELECT ACC_ENTITY_NAME,
		            TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER,
		            '('||BASE_CURRENCY||')'
	     INTO       :comp_name,
					:rep_date,
					:oper_id,
					:currency
	     FROM   SY_ACC_ENTITY_LANG_VW
		 WHERE  ACC_ENTITY_ID = :nd_facility_id
		 AND    LANGUAGE_ID   = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'\
) ,USER ,(('('||BASE_CURRENCY)||')') into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY_\
LANG_VW where (ACC_ENTITY_ID=:b4 and LANGUAGE_ID=:b5)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )188;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&comp_name;
 sqlstm.sqhstl[0] = (unsigned int  )52;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rep_date;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&oper_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&currency;
 sqlstm.sqhstl[3] = (unsigned int  )9;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[4] = (unsigned int  )5;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&p_language_id;
 sqlstm.sqhstl[5] = (unsigned int  )5;
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



    if(OERROR)
      {   disp_message(ORA_MESG,"Oracle error while fetching from SY ACC ENTITY");
	  proc_exit();
      }


    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';
    currency.arr[currency.len] = '\0';

     return;
}

get_pat_dtls()
{
     nd_patient_name.arr[0] = '\0';
     nd_national_id.arr[0] = '\0';

     nd_dob.arr[0] = '\0';

     nd_patient_name.len = 0;
     nd_national_id.len = 0;
     nd_dob.len = 0;

     /* EXEC SQL 
     SELECT MP.SHORT_NAME, TO_CHAR(MP.DATE_OF_BIRTH, 'DD/MM/YYYY'), SEX, MP.NATIONAL_ID_NUM	
     INTO :nd_patient_name, :nd_dob, :sex, :nd_national_id
     FROM MP_PATIENT_MAST MP
     WHERE MP.PATIENT_ID = :nd_patient_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 18;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select MP.SHORT_NAME ,TO_CHAR(MP.DATE_OF_BIRTH,'DD/MM/YY\
YY') ,SEX ,MP.NATIONAL_ID_NUM into :b0,:b1,:b2,:b3  from MP_PATIENT_MAST MP wh\
ere MP.PATIENT_ID=:b4";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )227;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_patient_name;
     sqlstm.sqhstl[0] = (unsigned int  )63;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_dob;
     sqlstm.sqhstl[1] = (unsigned int  )17;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&sex;
     sqlstm.sqhstl[2] = (unsigned int  )1;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_national_id;
     sqlstm.sqhstl[3] = (unsigned int  )52;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_patient_id;
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



     nd_patient_name.arr[nd_patient_name.len] = 0;
     nd_national_id.arr[nd_national_id.len] = '\0';
     nd_dob.arr[nd_dob.len] = 0;

    if (OERROR)
     { disp_message(ORA_MESG,"Select failed in MP_PATIENT_MAST");
       proc_exit();
     }
   if (NODATAFOUND)
     { disp_message(ORA_MESG,"No record found in MP_PATIENT_MAST");
       proc_exit();
    }

  nd_mail_add1.arr[0] 	= '\0';
  nd_mail_add2.arr[0] 	= '\0';
  nd_mail_add3.arr[0] 	= '\0';
  nd_mail_add4.arr[0] 	= '\0';
  nd_postal_code.arr[0] = '\0';

  nd_mail_add1.len 	= 0;
  nd_mail_add2.len 	= 0;
  nd_mail_add3.len 	= 0;
  nd_mail_add4.len 	= 0;
  nd_postal_code.len 	= 0;

  /* EXEC SQL     SELECT
		      LN1_RES_ADD,
		      LN2_RES_ADD,
		      LN3_RES_ADD,
		      LN4_RES_ADD
               INTO 
		      :nd_mail_add1,
		      :nd_mail_add2,
		      :nd_mail_add3,
		      :nd_mail_add4
	       FROM MP_PAT_OTHER_DTLS 
               WHERE PATIENT_ID = :nd_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LN1_RES_ADD ,LN2_RES_ADD ,LN3_RES_ADD ,LN4_RES_ADD i\
nto :b0,:b1,:b2,:b3  from MP_PAT_OTHER_DTLS where PATIENT_ID=:b4";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )262;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_mail_add1;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_mail_add2;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_mail_add3;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_mail_add4;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_patient_id;
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



  nd_mail_add1.arr[nd_mail_add1.len] 		= '\0';
  nd_mail_add2.arr[nd_mail_add2.len] 		= '\0';
  nd_mail_add3.arr[nd_mail_add3.len] 		= '\0';
  nd_mail_add4.arr[nd_mail_add4.len] 		= '\0';
  nd_postal_code.arr[nd_postal_code.len] 	= '\0';

  return;
}

get_header_dtls()
{

   d_acc_entity_name.arr[0] = '\0';
   d_user.arr[0] = '\0';
   d_sysdate.arr[0] = '\0';
   nd_practice_num.arr[0] = '\0';

   d_acc_entity_name.len = 0;
   d_user.len = 0;
   d_sysdate.len = 0;
   nd_practice_num.len = 0;

   /* EXEC SQL SELECT ACC_ENTITY_NAME, 
		   USER,
		   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI'),
		   PRACTICE_NUM   
	    INTO :d_acc_entity_name,
		 :d_user,
		 :d_sysdate,
		 :nd_practice_num
        FROM SY_ACC_ENTITY_lang_vw
		WHERE acc_entity_id =:nd_facility_id
		and language_id=:p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY \
HH24:MI') ,PRACTICE_NUM into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY_lang_vw where\
 (acc_entity_id=:b4 and language_id=:b5)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )297;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_user;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_sysdate;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_practice_num;
   sqlstm.sqhstl[3] = (unsigned int  )18;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&p_language_id;
   sqlstm.sqhstl[5] = (unsigned int  )5;
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
   { disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured");
     proc_exit();
   }

  d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
  d_user.arr[d_user.len]                       = '\0';
  d_sysdate.arr[d_sysdate.len]                 = '\0';
  nd_practice_num.arr[nd_practice_num.len]     = '\0';

}

print_formated_out(loc_amount,print_dr_cr)
double loc_amount;
char   print_dr_cr;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
	    l_ltrim(s_amt);
        fprintf(f1,"%14s",str_amt);
	if(print_dr_cr=='Y')
	    fprintf(f1,"%s","CR");
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
		l_ltrim(s_amt);
        fprintf(f1,"%14s",str_amt);
	if (print_dr_cr=='Y')
  	fprintf(f1,"%s","DR");
    }

}

print_formated_age(loc_amount,print_dr_cr)
double loc_amount;
char   print_dr_cr;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%12s",s_amt);
	l_ltrim(s_amt);
        fprintf(f1,"%12s",str_amt);
	if (print_dr_cr=='Y')
	  fprintf(f1,"%s","CR");
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%12s",s_amt);
		l_ltrim(s_amt);
        fprintf(f1,"%12s",str_amt);
	if (print_dr_cr=='Y')
  	fprintf(f1,"%s","DR");
    }

}


declare_cursor_stat_out()
{
/* EXEC SQL DECLARE pat_stat_vw CURSOR FOR
	SELECT  to_char(doc_date,'dd/mm/yyyy hh24:mi'),
	        doc_type_code||'/'||DOC_NUMBER||'/'||DOC_SLNO,
		trx_type,
		decode(:nd_outst_bills_only_flag,'N',debit_amt,
		          decode(sign(outstdg_amt),1,outstdg_amt,0)) debit_amt,
		decode(:nd_outst_bills_only_flag,'N',credit_amt,
		          decode(sign(outstdg_amt),-1,(-1)*outstdg_amt,0)) credit_amt,
		decode(episode_type,Null,' ','R',' ',
		       episode_type||'/'||nvl(to_char(episode_id),' ')||'/'||nvl(to_char(visit_id),' ')),
		sign(trunc(doc_date) - to_date(:nd_from_date,'dd/mm/yyyy')),
                outstdg_amt		
from     bl_patient_statement_vw 
	 where  patient_id=:nd_patient_id 
	 and  (  
	       ( :txn_type='O' and 
	         ( :nd_outst_bills_only_flag='N' Or 
	           (:nd_outst_bills_only_flag='Y'  And outstdg_amt<>0 AND valid_for_outstdg_yn = 'Y' )
	         )
      	       )  
	       OR
	       ( :txn_type='A' and  outstdg_amt<>0  AND valid_for_outstdg_yn = 'Y' 
	       )
              )	order by doc_date; */ 
 
         
 if (OERROR)
  { 
    disp_message(ORA_MESG,"Declare Failed in pat_stat_vw");
    proc_exit();
  }
}

close_cursor_stat_out()
{
/* EXEC SQL CLOSE pat_stat_vw; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 18;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )336;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

open_cursor_stat_out()
{
 /* EXEC SQL OPEN pat_stat_vw; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0010;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )351;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_outst_bills_only_flag;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_outst_bills_only_flag;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_from_date;
 sqlstm.sqhstl[2] = (unsigned int  )14;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_patient_id;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&txn_type;
 sqlstm.sqhstl[4] = (unsigned int  )1;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_outst_bills_only_flag;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_outst_bills_only_flag;
 sqlstm.sqhstl[6] = (unsigned int  )4;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&txn_type;
 sqlstm.sqhstl[7] = (unsigned int  )1;
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
  { disp_message(ORA_MESG,"Open Failed pat_stat_vw");
    proc_exit();
  }
}


fetch_cursor_stat_out()
{

  debit_amt =0;
  credit_amt=0;
  sign_ind  =0;
  d_balance = 0;

  doc_date.arr[0] = '\0';
  doc_det.arr[0] = '\0';
  trx_type.arr[0] = '\0';
  episode_det.arr[0] = '\0';


  doc_date.len=0;
  doc_det.len=0;
  trx_type.len=0;
  episode_det.len=0;


  /* EXEC SQL FETCH pat_stat_vw INTO 	
       :doc_date,
	   :doc_det,
	   :trx_type,
	   :debit_amt,
	   :credit_amt,
	   :episode_det,
	   :sign_ind,
	   :d_balance; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )398;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&doc_date;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&doc_det;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&trx_type;
  sqlstm.sqhstl[2] = (unsigned int  )17;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&debit_amt;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&credit_amt;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&episode_det;
  sqlstm.sqhstl[5] = (unsigned int  )22;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&sign_ind;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_balance;
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
  { 
    disp_message(ORA_MESG,"Fetch Failed in pat_stat_vw");
    proc_exit();
  }

 if (NODATAFOUND)
    return 0;

  doc_date.arr[doc_date.len]  = '\0';
  doc_det.arr[doc_det.len]    = '\0';
  trx_type.arr[trx_type.len]  = '\0';
  episode_det.arr[episode_det.len]  = '\0';

    return 1;
}


put_bal(char type,char trx_type)
{

//type 'C' CLosing Balance, 'E' Carry Forward , 'S' Brought Forward, 'O' opening Balance
//trx_type 'O' Oustatnding 'A' 'Age analysis'

if(type=='C') //Closing Balance
{
replicate(hl,MAX_COL);
//fprintf(f1,"\n                                  Closing Balance");
fprintf(f1,"\n%50.50s ",loc_legend[18]);
line=line+1;
}
else if(type=='S') //Summary
{
replicate(hl,MAX_COL);
//fprintf(f1,"\n                                  Summary        ");
fprintf(f1,"\n%42.42s         ",loc_legend[21]);
line=line+1;
}
else if(type=='O')//Opening Balance
{
nd_prev_date.arr[0]='\0';
nd_prev_date.len=0;

/* EXEC SQL select to_char(to_date(:nd_from_date,'dd/mm/yyyy')-1,'dd/mm/yyyy')
         into   :nd_prev_date 
	     from   dual; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 18;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select to_char((to_date(:b0,'dd/mm/yyyy')-1),'dd/mm/yyyy') in\
to :b1  from dual ";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )445;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_from_date;
sqlstm.sqhstl[0] = (unsigned int  )14;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_prev_date;
sqlstm.sqhstl[1] = (unsigned int  )17;
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


nd_prev_date.arr[nd_prev_date.len]='\0';

//fprintf(f1,"%-10.10s                        Opening Balance",nd_prev_date.arr);
 if(nd_prev_date.arr[0]!='\0')
 {
   init_date_temp_var();
   strcpy(date_convert.arr,nd_prev_date.arr);
   fun_change_loc_date1();
  }

//fprintf(f1,"%-10.10s%40.40s ",date_convert.arr,loc_legend[15]); COMMENTED BY SAIKIRAN FOR 21441
fprintf(f1,"%-10.10s%40.40s ","",loc_legend[15]);
}
else if(type=='B') //Brought Forward
{
//fprintf(f1,"                                  Brought Forward");
fprintf(f1,"%49.49s ",loc_legend[17]);
}
else //Carry FOrward
{
replicate(hl,MAX_COL);
//fprintf(f1,"\n                                  Carry  Forward ");
fprintf(f1,"\n%48.48s ",loc_legend[16]);
line=line+1;
}

if (trx_type=='O')
{
print_formated_out(tot_debit_amt,'N');    
print_formated_out(tot_credit_amt,'N');
print_formated_out(tot_debit_amt-tot_credit_amt,'Y');
}

if (trx_type=='A')
{
print_formated_age(nd_cut1s_amt,'Y');    
print_formated_age(nd_cut2s_amt,'Y');
print_formated_age(nd_cut3s_amt,'Y'); 
print_formated_age(nd_cut4s_amt,'Y'); 
}


fprintf(f1,"\n");
line=line+1;

//CLosing Or C/F or summary 
if (type=='C' || type=='E' || type=='S')
{
replicate(hl,MAX_COL);
fprintf(f1,"\n");
line=line+1;
}


}

replicate(printchar,no_of_times)
int printchar;
int no_of_times;
{
int i;
    for (i = 0; i < no_of_times; i++)
	    
	    fprintf(f1,"%c",printchar);
	   	          
  	return;
}


printdoc()
{

WSPrintDocument
(
uid_pwd.arr,			//char	*PUidPwd;
nd_session_id.arr,		//char	*PSessionID;
nd_facility_id.arr,	//char	*PFacilityID;
"BL",					//char	*PModuleID;
"BLRPATST",	//char	*PDocumentID;
filename,				//char	*POnlinePrintFileNames;
"O",					//char	*PLocationTypes;
" ",					//char	*PLocationCodes;
1,						//int	PNumOfCopies;
1,						//int	PPageFrom;
9999,					//int	PPageTo;
p_ws_no.arr, 
" "
);

}
 
fetch_legend_value()
{
	for(i=1;i<=27;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRPATST.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 18;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRPATST.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )468;
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
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )491;
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
  sqlstm.sqhstl[2] = (unsigned int  )204;
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
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);

		 :nd_loc_date := to_char(t_date,'DD/MM/YYYY HH24:MI');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ,\
 t_date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY HH24:MI' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )522;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_language_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[2] = (unsigned int  )22;
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

get_local_date1()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY'),:p_language_id,t_date);

		 :nd_loc_date := to_char(t_date,'DD/MM/YYYY');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY' ) , :p_language_id , t_date \
) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )549;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_language_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[2] = (unsigned int  )22;
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
nd_temp_date.arr[nd_temp_date.len]='\0';

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 
}

fun_change_loc_date1()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);
nd_temp_date.arr[nd_temp_date.len]='\0';

get_local_date1();

strcpy(date_convert.arr,nd_loc_date.arr); 
}

fun_centre(v_text,v_size)
{
int l_length,i;
l_length=strlen(v_text);
for (i=0;i<(v_size-l_length)/2;i++)
{
 if(nd_print_option.arr[0]=='R')
 strcat(nd_line_text.arr," ");
 else
 fprintf(f1," ");
}
}

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER

