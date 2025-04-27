
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
    "C:\\10xdev\\BLR00024.PC"
};


static unsigned long sqlctx = 139592283;


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
            void  *sqhstv[15];
   unsigned int   sqhstl[15];
            int   sqhsts[15];
            void  *sqindv[15];
            int   sqinds[15];
   unsigned int   sqharm[15];
   unsigned int   *sqharc[15];
   unsigned short  sqadto[15];
   unsigned short  sqtdso[15];
} sqlstm = {10,15};

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

 static const char *sq0004 = 
"and c.cash_slmt_flag=decode(:b5,'**'\
,c.cash_slmt_flag,:b5)) order by a.doc_date,a.ext_acct_code            ";

 static const char *sq0005 = 
"and c.cash_slmt_flag=decode(:b5,'**'\
,c.cash_slmt_flag,:b5)) order by a.ext_acct_code,a.doc_date            ";

 static const char *sq0006 = 
"select ((org_doc_type_code||'/')||to_char(org_doc_num)) ,to_char(org_doc_da\
te,'dd/mm/yyyy') ,abs(doc_amt)  from bl_patient_ledger where ((((ad_pr_adj_bi\
ll_doc_type=:b0 and ad_pr_adj_bill_doc_num=:b1) or (org_doc_type_code=:b0 and\
 org_doc_num=:b1)) and nvl(trx_status,'X')<>'C') and recpt_nature_code in ('A\
D','PR','RD'))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,91,0,2050,187,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,2078,196,0,0,0,0,0,1,0,
43,0,0,3,0,0,2075,204,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
74,0,0,4,0,0,2061,352,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
149,0,0,5,0,0,2061,371,0,0,15,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,
224,0,0,6,0,0,2061,428,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,
251,0,0,7,166,0,2052,463,0,0,8,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,
298,0,0,4,1131,0,2057,512,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
341,0,0,5,1131,0,2057,518,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
384,0,0,8,90,0,2052,548,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
411,0,0,6,331,0,2057,580,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
442,0,0,9,161,0,2052,708,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
477,0,0,10,96,0,2052,774,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
500,0,0,11,165,0,2054,781,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
531,0,0,12,73,0,2052,827,0,0,5,4,0,1,0,1,97,0,0,1,9,0,0,1,97,0,0,1,9,0,0,2,9,0,
0,
566,0,0,13,198,0,2052,930,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,1,9,0,0,
605,0,0,14,0,0,2080,953,0,0,0,0,0,1,0,
};



/************************************************************************/
/* PROGRAM NAME          : BLR00024.PC                                  */
/* AUTHOR                : D Ganesh Murthi                              */
/* DATE WRITTEN          : 07/03/2005                                	*/
/*                                                                      */
/* CALLED FROM           :                                              */
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
#define	MAX_LINES	68
//#define ESC     0x1B

#define INIT_MESG "Report Generation is in progress"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR		uid_pwd				[132],
			hosp_name			[120],
			date_time			[20],
			user_id				[20],
			nd_pgm_date			[35],
			nd_facility_name	[31],
			nd_session_id		[16],
			nd_facility_id		[3],
			d_acc_entity_name	[41],
			d_ob_date			[11],
			d_cb_date			[11],
			d_cb_recouped_vr_no [21],
			d_doc_num_ref		[20],
			d_prv_doc_num_ref   [16],			
			d_user				[21],
			d_sysdate			[17],
			date				[20],
			base_currency			[20]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[11]; } d_ob_date;

struct { unsigned short len; unsigned char arr[11]; } d_cb_date;

struct { unsigned short len; unsigned char arr[21]; } d_cb_recouped_vr_no;

struct { unsigned short len; unsigned char arr[20]; } d_doc_num_ref;

struct { unsigned short len; unsigned char arr[16]; } d_prv_doc_num_ref;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } base_currency;

			
			
/* VARCHAR			nd_lang_id		[4],
			nd_from_date    	[11],
			nd_to_date 		[11],
			nd_from_patient_id	[21],
			nd_to_patient_id	[21],
			nd_refund_type		[2],
			nd_order_by		[2],
			p_language_id    [3]; */ 
struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[11]; } nd_from_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[21]; } nd_from_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_patient_id;

struct { unsigned short len; unsigned char arr[2]; } nd_refund_type;

struct { unsigned short len; unsigned char arr[2]; } nd_order_by;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;


/* VARCHAR 	l_pk_value			[200],
			l_translated_value	[201],
			l_from_and_to_date  [120]; */ 
struct { unsigned short len; unsigned char arr[200]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[120]; } l_from_and_to_date;



char		loc_legend[40][201];
char        d_dep_doc_num_arr[7][16];
char        d_dep_date_arr[7][18];

int			l_line_no =0;
int			l_page_no=0;	
int			i,j;
int			sl_no = 1;


/* VARCHAR		d_episode_id		[10],
			d_visit_id			[7],
			d_patient_id		[21],
			d_nric				[21],
			d_payer_name		[61],
			d_patient_name      [61],
			d_mode				[16],
			d_remark            [51],
			d_doc_type_code     [11],
			d_refund_doc		[11],
			d_slmt_doc_ref_desc [21],
			d_ref_doc_date   	[21],
			l_address_line1		[33],
			l_address_line2		[33],
			l_address_line3		[33],
			l_tel_number		[33],
			d_bill_doc_type_code	[11],
			d_bill_doc_number	[11],			
			d_bill_doc		[19],
			d_doc_date		[11],			
			d_dep_doc_num		[16],
			d_dep_date		[11],
			d_recpt_nature		[3],
			ext_acct_code		[11],
			l_sysdate		[20],
			l_hospital_name		[50]; */ 
struct { unsigned short len; unsigned char arr[10]; } d_episode_id;

struct { unsigned short len; unsigned char arr[7]; } d_visit_id;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_nric;

struct { unsigned short len; unsigned char arr[61]; } d_payer_name;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[16]; } d_mode;

struct { unsigned short len; unsigned char arr[51]; } d_remark;

struct { unsigned short len; unsigned char arr[11]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[11]; } d_refund_doc;

struct { unsigned short len; unsigned char arr[21]; } d_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[21]; } d_ref_doc_date;

struct { unsigned short len; unsigned char arr[33]; } l_address_line1;

struct { unsigned short len; unsigned char arr[33]; } l_address_line2;

struct { unsigned short len; unsigned char arr[33]; } l_address_line3;

struct { unsigned short len; unsigned char arr[33]; } l_tel_number;

struct { unsigned short len; unsigned char arr[11]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[11]; } d_bill_doc_number;

struct { unsigned short len; unsigned char arr[19]; } d_bill_doc;

struct { unsigned short len; unsigned char arr[11]; } d_doc_date;

struct { unsigned short len; unsigned char arr[16]; } d_dep_doc_num;

struct { unsigned short len; unsigned char arr[11]; } d_dep_date;

struct { unsigned short len; unsigned char arr[3]; } d_recpt_nature;

struct { unsigned short len; unsigned char arr[11]; } ext_acct_code;

struct { unsigned short len; unsigned char arr[20]; } l_sysdate;

struct { unsigned short len; unsigned char arr[50]; } l_hospital_name;


double   d_refund_amt;
double   d_bill_tot_amt;
double   d_oth_doc_amt;
double   d_dep_amount;
double	 d_sum_dep_amt=0;
double	 d_sum_bill_amt=0;
double	 d_sum_refund_amt=0;

double   d_vouch_amt;
double   d_dep_amount_arr[7];

char filename[200];
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

	nd_session_id.len = 0;
	nd_session_id.arr[nd_session_id.len] = '\0';

	strcpy(nd_session_id.arr,argv[2]);
	nd_session_id.len = strlen(nd_session_id.arr);
	nd_session_id.arr[nd_session_id.len] = '\0'; 

	nd_pgm_date.len = 0;
	nd_pgm_date.arr[nd_pgm_date.len] = '\0';
   
	strcpy(nd_pgm_date.arr,argv[3]);
	nd_pgm_date.len = strlen(nd_pgm_date.arr);
	nd_pgm_date.arr[nd_pgm_date.len] = '\0';

	strcpy(nd_facility_id.arr,argv[4]);
	nd_facility_id.len = strlen(nd_facility_id.arr);
	nd_facility_id.arr[nd_facility_id.len] = '\0';

	if(sql_connect() == -1)
	{
		disp_message(ERR_MESG,"Error in connecting to Oracle\n");
		if (uid_pwd.len == 0)
			disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
		proc_exit();
	}

	set_meduser_role();

    strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;


	fetch_prog_param();

    declare_cursors();

    fetch_hosp_name();
    
    open_file();

    fetch_legend_value();

    fprintf(fp,"%c",0x0F); // set printer to compressed mode 

    print_report();

    end_of_rep();

    fprintf(fp,"%c",0x12); /*** Set Dot-matrix Printer to Normal Mode ***/

	/* EXEC SQL DELETE SY_PROG_PARAM
            WHERE PGM_ID   = 'BLR00024'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLR00024' and S\
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
 sqlstm.sqhstl[1] = (unsigned int  )37;
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
  sqlstm.sqhstl[0] = (unsigned int  )134;
  sqlstm.sqhsts[0] = (         int  )134;
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

declare_cursors()
{

/* EXEC SQL DECLARE REFUND_VOUCHER_DETAILS1 CURSOR FOR 
SELECT		a.patient_id, 
		a.episode_id, 
		a.payer_name, 
		c.short_desc,
		a.slmt_doc_ref_desc,
		a.doc_type_code ||'/'|| a.doc_number refund_doc,
		to_char(a.doc_date,'dd/mm/yyyy'),
		a.bill_doc_type_code || '/' || a.bill_doc_number bill_number, 
		to_char(b.doc_date,'dd/mm/yyyy'), 
		b.bill_amt bill_amt,
		abs(a.doc_amt) refund_amt, 
		a.recpt_nature_code,
		a.ext_acct_code,
		a.bill_doc_type_code,
		a.bill_doc_number,
		a.doc_type_code, 
		a.doc_number
FROM	BL_RECEIPT_REFUND_HDRDTL_VW a, 
	bl_bill_hdr b,
	bl_slmt_type c  
WHERE	a.operating_facility_id = :nd_facility_id
AND     a.operating_facility_id = b.operating_facility_id(+)
AND     a.bill_doc_type_code    = b.doc_type_code(+)
AND     a.bill_doc_number       = b.doc_num(+)
AND     a.slmt_type_code        = c.slmt_type_code 
AND	a.doc_date BETWEEN to_date(:nd_from_date||' 00:00:00','dd/mm/yyyy hh24:mi:ss')
	AND to_date(:nd_to_date||' 23:59:59','dd/mm/yyyy hh24:mi:ss')
AND     nvl(a.cancelled_ind,'N')= 'N'
AND	a.recpt_refund_ind      = 'F'
AND	nvl(a.patient_id,'!!!!!!!!!!!!!!!!!!!!') between nvl(:nd_from_patient_id,'!!!!!!!!!!!!!!!!!!!!')
	and nvl(:nd_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
AND     c.cash_slmt_flag = decode(:nd_refund_type,'**',c.cash_slmt_flag,:nd_refund_type)
Order By a.doc_date,a.ext_acct_code; */ 



/* EXEC SQL DECLARE REFUND_VOUCHER_DETAILS2 CURSOR FOR 
SELECT		a.patient_id, 
		a.episode_id, 
		a.payer_name, 
		c.short_desc,
		a.slmt_doc_ref_desc,
		a.doc_type_code ||'/'|| a.doc_number refund_doc,
		to_char(a.doc_date,'dd/mm/yyyy'),
		a.bill_doc_type_code || '/' || a.bill_doc_number bill_number, 
		to_char(b.doc_date,'dd/mm/yyyy'), 
		b.bill_amt bill_amt,
		abs(a.doc_amt) refund_amt, 
		a.recpt_nature_code,
		a.ext_acct_code,
		a.bill_doc_type_code,
		a.bill_doc_number,
		a.doc_type_code, 
		a.doc_number
FROM	BL_RECEIPT_REFUND_HDRDTL_VW a, 
	bl_bill_hdr b,
	bl_slmt_type c  
WHERE	a.operating_facility_id = :nd_facility_id
AND     a.operating_facility_id = b.operating_facility_id(+)
AND     a.bill_doc_type_code    = b.doc_type_code(+)
AND     a.bill_doc_number       = b.doc_num(+)
AND     a.slmt_type_code        = c.slmt_type_code 
AND	a.doc_date BETWEEN to_date(:nd_from_date||' 00:00:00','dd/mm/yyyy hh24:mi:ss')
	AND to_date(:nd_to_date||' 23:59:59','dd/mm/yyyy hh24:mi:ss')
AND     nvl(a.cancelled_ind,'N')= 'N'
AND	a.recpt_refund_ind      = 'F'
AND	nvl(a.patient_id,'!!!!!!!!!!!!!!!!!!!!') between nvl(:nd_from_patient_id,'!!!!!!!!!!!!!!!!!!!!')
	and nvl(:nd_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
AND     c.cash_slmt_flag = decode(:nd_refund_type,'**',c.cash_slmt_flag,:nd_refund_type)
Order By a.ext_acct_code,a.doc_date; */ 




/* EXEC SQL  DECLARE  DEP_DETAILS CURSOR FOR
SELECT    org_doc_type_code ||'/'|| to_char(org_doc_num), 
	  to_char(org_doc_date,'dd/mm/yyyy'),
	  abs(doc_amt)
FROM      bl_patient_ledger
WHERE    (
	   (
	   ad_pr_adj_bill_doc_type     =  :d_bill_doc_type_code AND
	   ad_pr_adj_bill_doc_num      =  :d_bill_doc_number
	   )
	 OR
	   (
	    org_doc_type_code = :d_bill_doc_type_code AND 
	    org_doc_num = :d_bill_doc_number 
	   )	 
	 )
AND	  nvl(trx_status,'X')   !=  'C'
AND recpt_nature_code in ( 'AD','PR','RD'); */ 


}




fetch_cursors()
{
    d_episode_id.arr[0]			 = '\0';
    d_patient_id.arr[0]			 = '\0';
    d_payer_name.arr[0]			 = '\0';
    d_remark.arr[0]				 = '\0';
	d_doc_type_code.arr[0]		 = '\0';
	d_doc_num_ref.arr[0]			 = '\0';
    d_ref_doc_date.arr[0]		 = '\0';
	d_bill_doc_type_code.arr[0]  = '\0';
	d_bill_doc_number.arr[0]     = '\0';
	
	d_bill_doc.arr[0] = '\0';
    d_doc_date.arr[0]			 = '\0';
	d_recpt_nature.arr[0]		 = '\0';
	ext_acct_code.arr[0]		 = '\0';
	d_mode.arr[0]				 = '\0';
	d_slmt_doc_ref_desc.arr[0]	 = '\0';

    d_episode_id.len			 = 0;
    d_patient_id.len			 = 0;
    d_payer_name.len			 = 0;
    d_remark.len				 = 0;
    d_doc_type_code.len			 = 0;
    d_doc_num_ref.len				 = 0;
    d_ref_doc_date.len			 = 0;
    d_bill_doc_type_code.len     = 0;
	d_bill_doc_number.len        = 0;
	d_bill_doc.len = 0;
    d_doc_date.len				 = 0;
	d_recpt_nature.len			 = 0;
	ext_acct_code.len			 = 0;
	d_mode.len					 = 0;
	d_slmt_doc_ref_desc.len		 = 0;
	

    d_refund_amt				 = 0;
	d_bill_tot_amt				 = 0;

    if (nd_order_by.arr[0] == '1')
    {
		/* EXEC SQL FETCH REFUND_VOUCHER_DETAILS1 INTO  
		   :d_patient_id,
		   :d_episode_id,
		   :d_payer_name,
		   :d_mode,
		   :d_slmt_doc_ref_desc,
		   :d_doc_num_ref,
		   :d_ref_doc_date,
		   :d_bill_doc,
		   :d_doc_date,
		   :d_bill_tot_amt,
		   :d_refund_amt,
		   :d_recpt_nature,
		   :ext_acct_code,
		   :d_bill_doc_type_code,
		   :d_bill_doc_number; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )74;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[1] = (unsigned int  )12;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_payer_name;
  sqlstm.sqhstl[2] = (unsigned int  )63;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_mode;
  sqlstm.sqhstl[3] = (unsigned int  )18;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_slmt_doc_ref_desc;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_doc_num_ref;
  sqlstm.sqhstl[5] = (unsigned int  )22;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_ref_doc_date;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_bill_doc;
  sqlstm.sqhstl[7] = (unsigned int  )21;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_doc_date;
  sqlstm.sqhstl[8] = (unsigned int  )13;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_bill_tot_amt;
  sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_refund_amt;
  sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_recpt_nature;
  sqlstm.sqhstl[11] = (unsigned int  )5;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&ext_acct_code;
  sqlstm.sqhstl[12] = (unsigned int  )13;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_bill_doc_type_code;
  sqlstm.sqhstl[13] = (unsigned int  )13;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_bill_doc_number;
  sqlstm.sqhstl[14] = (unsigned int  )13;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
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
		/* EXEC SQL FETCH REFUND_VOUCHER_DETAILS2 INTO  
		   :d_patient_id,
		   :d_episode_id,
		   :d_payer_name,
		   :d_mode,
		   :d_slmt_doc_ref_desc,
		   :d_doc_num_ref,
		   :d_ref_doc_date,
		   :d_bill_doc,
		   :d_doc_date,
		   :d_bill_tot_amt,
		   :d_refund_amt,
		   :d_recpt_nature,
		   :ext_acct_code,
		   :d_bill_doc_type_code,
		   :d_bill_doc_number; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )149;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[1] = (unsigned int  )12;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_payer_name;
  sqlstm.sqhstl[2] = (unsigned int  )63;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_mode;
  sqlstm.sqhstl[3] = (unsigned int  )18;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_slmt_doc_ref_desc;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_doc_num_ref;
  sqlstm.sqhstl[5] = (unsigned int  )22;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_ref_doc_date;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_bill_doc;
  sqlstm.sqhstl[7] = (unsigned int  )21;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_doc_date;
  sqlstm.sqhstl[8] = (unsigned int  )13;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_bill_tot_amt;
  sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_refund_amt;
  sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_recpt_nature;
  sqlstm.sqhstl[11] = (unsigned int  )5;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&ext_acct_code;
  sqlstm.sqhstl[12] = (unsigned int  )13;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_bill_doc_type_code;
  sqlstm.sqhstl[13] = (unsigned int  )13;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_bill_doc_number;
  sqlstm.sqhstl[14] = (unsigned int  )13;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
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

   
    if(OERROR)
		err_mesg("FETCH failed on cursor REFUND_VOUCHER_DETAILS",0,"");
     

    if(NO_DATA_FOUND)
		return 0;

    d_episode_id.arr[d_episode_id.len]					= '\0';
    d_patient_id.arr[d_patient_id.len]					= '\0';
    d_payer_name.arr[d_payer_name.len]					= '\0';
    d_ref_doc_date.arr[d_ref_doc_date.len]				= '\0';
    d_remark.arr[d_remark.len]							= '\0';
    d_doc_type_code.arr[d_doc_type_code.len]			= '\0';
    d_refund_doc.arr[d_refund_doc.len]					= '\0';
    d_ref_doc_date.arr[d_ref_doc_date.len]				= '\0';
    d_bill_doc_type_code.arr[d_bill_doc_type_code.len]  = '\0';
    d_bill_doc_number.arr[d_bill_doc_number.len]        = '\0';
    d_bill_doc.arr[d_bill_doc.len] = '\0';
    d_doc_date.arr[d_doc_date.len]						= '\0';
    d_recpt_nature.arr[d_recpt_nature.len]				= '\0';
    ext_acct_code.arr[ext_acct_code.len]				= '\0';
    d_mode.arr[d_mode.len]								= '\0';
    d_slmt_doc_ref_desc.arr[d_slmt_doc_ref_desc.len]	= '\0';

    
    
    return 1;
}

fetch_dep_dtls()
{
    d_dep_doc_num.arr[0]		 = '\0';
	d_dep_date.arr[0]			 = '\0';
    d_dep_doc_num.len			 = 0;
	d_dep_date.len               = 0;
    d_dep_amount				 = 0;

   		/* EXEC SQL FETCH DEP_DETAILS 
		INTO  :d_dep_doc_num, 
			  :d_dep_date,
			  :d_dep_amount; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )224;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_dep_doc_num;
     sqlstm.sqhstl[0] = (unsigned int  )18;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_dep_date;
     sqlstm.sqhstl[1] = (unsigned int  )13;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_dep_amount;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
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
		err_mesg("FETCH failed on cursor fetch_dep_dtls",0,"");

	if(NO_DATA_FOUND)
		return 0;
	
    d_dep_doc_num.arr[d_dep_doc_num.len] = '\0';
	d_dep_date.arr[d_dep_date.len]       = '\0';
   
    return 1;
}



fetch_prog_param()
{
    nd_from_date.arr[0]     ='\0'; 
    nd_to_date.arr[0]     ='\0';
    nd_from_patient_id.arr[0] = '\0';
    nd_to_patient_id.arr[0] = '\0';
    nd_refund_type.arr[0] = '\0';
    nd_order_by.arr[0] = '\0';

    nd_from_date.len           = 0;
    nd_to_date.len           = 0;
    nd_from_patient_id.len = 0;
    nd_to_patient_id.len = 0;
    nd_refund_type.len = 0;
    nd_order_by.len = 0;
 
    /* EXEC SQL SELECT  PARAM1, PARAM2, PARAM3, PARAM4,
		     PARAM5, PARAM6
             INTO    :nd_from_date,:nd_to_date,:nd_from_patient_id, :nd_to_patient_id,
		     :nd_refund_type, :nd_order_by		
             FROM	 SY_PROG_PARAM
             WHERE	 PGM_ID   = 'BLR00024'
             AND	 SESSION_ID = :nd_session_id
             AND	 PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 in\
to :b0,:b1,:b2,:b3,:b4,:b5  from SY_PROG_PARAM where ((PGM_ID='BLR00024' and \
SESSION_ID=:b6) and PGM_DATE=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )251;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_from_date;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_from_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_patient_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_refund_type;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_order_by;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[6] = (unsigned int  )18;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[7] = (unsigned int  )37;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

	nd_from_date.arr[nd_from_date.len]	= '\0';
	nd_to_date.arr[nd_to_date.len]	= '\0';
	nd_from_patient_id.arr[nd_from_patient_id.len] ='\0';
	nd_to_patient_id.arr[nd_to_patient_id.len] ='\0';
	nd_refund_type.arr[nd_refund_type.len] = '\0';
	nd_order_by.arr[nd_order_by.len] = '\0';

}

end_of_rep()
{					   
	fprintf(fp,"\n %87s***  END OF REPORT ***\n\f"," ");
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
    strcat(filename,"BLR00024.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00024.lis");
       proc_exit();
    }
}
  
print_report()
{
  print_page_title();

  
   if (nd_order_by.arr[0] == '1')
   {
   /* EXEC SQL OPEN REFUND_VOUCHER_DETAILS1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0,
     "select a.patient_id ,a.episode_id ,a.payer_name ,c.short_desc ,a.slmt_\
doc_ref_desc ,((a.doc_type_code||'/')||a.doc_number) refund_doc ,to_char(a.d\
oc_date,'dd/mm/yyyy') ,((a.bill_doc_type_code||'/')||a.bill_doc_number) bill\
_number ,to_char(b.doc_date,'dd/mm/yyyy') ,b.bill_amt bill_amt ,abs(a.doc_am\
t) refund_amt ,a.recpt_nature_code ,a.ext_acct_code ,a.bill_doc_type_code ,a\
.bill_doc_number ,a.doc_type_code ,a.doc_number  from BL_RECEIPT_REFUND_HDRD\
TL_VW a ,bl_bill_hdr b ,bl_slmt_type c where (((((((((a.operating_facility_i\
d=:b0 and a.operating_facility_id=b.operating_facility_id(+)) and a.bill_doc\
_type_code=b.doc_type_code(+)) and a.bill_doc_number=b.doc_num(+)) and a.slm\
t_type_code=c.slmt_type_code) and a.doc_date between to_date((:b1||' 00:00:0\
0'),'dd/mm/yyyy hh24:mi:ss') and to_date((:b2||' 23:59:59'),'dd/mm/yyyy hh24\
:mi:ss')) and nvl(a.cancelled_ind,'N')='N') and a.recpt_refund_ind='F') and \
nvl(a.patient_id,'!!!!!!!!!!!!!!!!!!!!') between nvl(:b3,'!!!!!!!!!!!!!!!!!!\
!!') and nvl(:b4,'~~~~~~~~~~~~~~~~~~~~')) ");
   sqlstm.stmt = sq0004;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )298;
   sqlstm.selerr = (unsigned short)1;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_from_date;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_from_patient_id;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_patient_id;
   sqlstm.sqhstl[4] = (unsigned int  )23;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_refund_type;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_refund_type;
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
	  err_mesg("OPEN failed on cursor REFUND_VOUCHER_DETAILS1",0,"");
    }
   else
   {
	/* EXEC SQL OPEN REFUND_VOUCHER_DETAILS2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0,
   "select a.patient_id ,a.episode_id ,a.payer_name ,c.short_desc ,a.slmt_do\
c_ref_desc ,((a.doc_type_code||'/')||a.doc_number) refund_doc ,to_char(a.doc\
_date,'dd/mm/yyyy') ,((a.bill_doc_type_code||'/')||a.bill_doc_number) bill_n\
umber ,to_char(b.doc_date,'dd/mm/yyyy') ,b.bill_amt bill_amt ,abs(a.doc_amt)\
 refund_amt ,a.recpt_nature_code ,a.ext_acct_code ,a.bill_doc_type_code ,a.b\
ill_doc_number ,a.doc_type_code ,a.doc_number  from BL_RECEIPT_REFUND_HDRDTL\
_VW a ,bl_bill_hdr b ,bl_slmt_type c where (((((((((a.operating_facility_id=\
:b0 and a.operating_facility_id=b.operating_facility_id(+)) and a.bill_doc_t\
ype_code=b.doc_type_code(+)) and a.bill_doc_number=b.doc_num(+)) and a.slmt_\
type_code=c.slmt_type_code) and a.doc_date between to_date((:b1||' 00:00:00'\
),'dd/mm/yyyy hh24:mi:ss') and to_date((:b2||' 23:59:59'),'dd/mm/yyyy hh24:m\
i:ss')) and nvl(a.cancelled_ind,'N')='N') and a.recpt_refund_ind='F') and nv\
l(a.patient_id,'!!!!!!!!!!!!!!!!!!!!') between nvl(:b3,'!!!!!!!!!!!!!!!!!!!!\
') and nvl(:b4,'~~~~~~~~~~~~~~~~~~~~')) ");
 sqlstm.stmt = sq0005;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )341;
 sqlstm.selerr = (unsigned short)1;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_from_date;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_from_patient_id;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_patient_id;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_refund_type;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_refund_type;
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
	  err_mesg("OPEN failed on cursor REFUND_VOUCHER_DETAILS2",0,"");
   }

   
   while(fetch_cursors())  
  {


   for (i=1;i<=6; i++)
	 {
	   for (j=0;j<=18;j++)
	   	{
		d_dep_doc_num_arr[i][j] = '\0';
		d_dep_date_arr[i][j] = '\0';
		}
		d_dep_amount_arr[i] = 0;
         }


   fprintf(fp,"%5d %-15.15s %-21.21s ",sl_no, d_doc_num_ref.arr,d_ref_doc_date.arr);
   d_prv_doc_num_ref.arr[0] = '\0';
   d_prv_doc_num_ref.len =  0;

   d_patient_name.arr[0]   = '\0';
   d_nric.arr[0] = '\0';
   d_nric.len    = 0;
   d_patient_name.len  =0;

   /* EXEC SQL select short_name, national_id_num
   into   :d_patient_name, :d_nric
   from   mp_patient_mast
   where  patient_id = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select short_name ,national_id_num into :b0,:b1  from mp_\
patient_mast where patient_id=:b2";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )384;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_patient_name;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_nric;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
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



   d_nric.arr[d_nric.len] = '\0';
   d_patient_name.arr[d_patient_name.len]= '\0';

	if (d_patient_name.arr[0] == '\0')
		strcpy(d_patient_name.arr,d_payer_name.arr);
  

	fprintf(fp,"%-20.20s %-60.60s %-15.15s ",d_patient_id.arr,d_patient_name.arr, d_mode.arr);


     if (strcmp(d_recpt_nature.arr, "BI") == 0 || strcmp(d_recpt_nature.arr, "DC") == 0)
     {
	if (d_bill_doc.arr[0] == '\0')
		fprintf(fp,"%-29.29s"," ");
	else
	{
		fprintf(fp,"%-14.14s",d_bill_doc.arr);
		print_formated(d_bill_tot_amt);
		 d_sum_bill_amt=d_sum_bill_amt+d_bill_tot_amt;

	}
      }
      else
		fprintf(fp,"%-29.29s"," "); 

 	fprintf(fp,"  ");
	
    /* EXEC SQL OPEN DEP_DETAILS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )411;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_bill_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_bill_doc_number;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_bill_doc_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_bill_doc_number;
    sqlstm.sqhstl[3] = (unsigned int  )13;
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
	err_mesg("OPEN failed on cursor DEP_DETAILS",0,"");

     
	 i=1;
	 while (fetch_dep_dtls())
	 {
	   	strcpy(d_dep_doc_num_arr[i],d_dep_doc_num.arr);
		strcpy(d_dep_date_arr[i],d_dep_date.arr);
		d_dep_amount_arr[i] = d_dep_amount;
		i++;
		d_sum_dep_amt=d_sum_dep_amt+d_dep_amount;

	 }

	if (d_dep_doc_num_arr[1][0] == '\0')  
		fprintf(fp," %-16.16s %-14.14s "," ", " ");
	else
	{
		fprintf(fp," %-16.16s ",d_dep_doc_num_arr[1]);
		print_formated(d_dep_amount_arr[1]);
	}

	fprintf(fp," ");
	
	print_formated(d_refund_amt);
	d_sum_refund_amt=d_sum_refund_amt+d_refund_amt;

	fprintf(fp," %-10.10s\n", ext_acct_code.arr);

	fprintf(fp,"%43.43s %-20.20s %-60.60s %-15.15s %-14.14s %14.14s   %-16.16s\n",
	 " ",d_episode_id.arr, d_nric.arr,d_slmt_doc_ref_desc.arr,d_doc_date.arr, " ",d_dep_date_arr[1]);


	l_line_no++;  
	l_line_no++; 
	check_page_break();	


	if (d_dep_doc_num_arr[2][0] != '\0')
	{   
	   fprintf(fp,"%5.5s %-15.15s %-21.21s "," "," "," ");   
	   fprintf(fp,"%-20.20s %-60.60s %-15.15s %-29.29s ", " ", " "," "," ");	 
	   
	   fprintf(fp,"  %-16.16s ",d_dep_doc_num_arr[2]);
	   print_formated(d_dep_amount_arr[2]);   
	 

	   fprintf(fp,"                ");
	   fprintf(fp," %-10.10s\n", " ");
	   fprintf(fp,"%43.43s %-20.20s %-60.60s %-15.15s %-14.14s %14.14s   %-16.16s\n",
		 " "," "," "," "," ", " ",d_dep_date_arr[2]);
	   l_line_no++; 
	   l_line_no++; 
	   check_page_break();	
	}

	if (d_dep_doc_num_arr[3][0] != '\0')
	{   
	   fprintf(fp,"%5.5s %-15.15s %-21.21s "," "," "," ");   
	   fprintf(fp,"%-20.20s %-60.60s %-15.15s %-29.29s ", " ", " "," "," ");	 
	   
	   fprintf(fp,"  %-16.16s ",d_dep_doc_num_arr[3]);
	   print_formated(d_dep_amount_arr[3]);   
	 

	   fprintf(fp,"                ");
	   fprintf(fp," %-10.10s\n", " ");
	   fprintf(fp,"%43.43s %-20.20s %-60.60s %-15.15s %-14.14s %14.14s   %-16.16s\n",
		 " "," "," "," "," ", " ",d_dep_date_arr[3]);
	   l_line_no++; 
	   l_line_no++; 
	   check_page_break();	
	}

	if (d_dep_doc_num_arr[4][0] != '\0')
	{   
	   fprintf(fp,"%5.5s %-15.15s %-21.21s "," "," "," ");   
	   fprintf(fp,"%-20.20s %-60.60s %-15.15s %-29.29s ", " ", " "," "," ");	 
	   
	   fprintf(fp,"  %-16.16s ",d_dep_doc_num_arr[4]);
	   print_formated(d_dep_amount_arr[4]);   
	 

	   fprintf(fp,"                ");
	   fprintf(fp," %-10.10s\n", " ");
	   fprintf(fp,"%43.43s %-20.20s %-60.60s %-15.15s %-14.14s %14.14s   %-16.16s\n",
		 " "," "," "," "," ", " ",d_dep_date_arr[4]);
	   l_line_no++; 
	   l_line_no++; 
	   check_page_break();	
	}
	sl_no++;	
	}
	 print_line(232);
		fprintf(fp,"\n"); 
		l_line_no = l_line_no+1;
		
    //fprintf(fp,"%43.43s %-20.20s %-60.60s %-15.15s %-14.14s %14.14s   %16.16s ",
	//	 " "," "," "," "," ", " ",loc_legend[23]);

    fprintf(fp,"%150.150s",loc_legend[23]);
    fprintf(fp,"%6s"," ");
	print_formated(d_sum_bill_amt);
     fprintf(fp,"%20s"," ");
    print_formated(d_sum_dep_amt);
    fprintf(fp,"%1s"," ");
    print_formated(d_sum_refund_amt);

  		fprintf(fp,"\n");
         print_line(232);
		fprintf(fp,"\n"); 
		l_line_no = l_line_no+2;
}
  
fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    base_currency.arr[0] = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;
    base_currency.len = 0;

    /* EXEC SQL   SELECT ACC_ENTITY_NAME, 
			   TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
			   USER,
			   '('||BASE_CURRENCY||')'
         INTO  :hosp_name, :date_time, :user_id,
	       :base_currency
         FROM  SY_ACC_ENTITY
		 where acc_entity_id = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24\
:MI') ,USER ,(('('||BASE_CURRENCY)||')') into :b0,:b1,:b2,:b3  from SY_ACC_EN\
TITY where acc_entity_id=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )442;
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
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&base_currency;
    sqlstm.sqhstl[3] = (unsigned int  )22;
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
base_currency.arr[base_currency.len]   = '\0';
}


print_formated(loc_amount)
double loc_amount;
{
    char s_amt[30], str_amt[30];	
    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
	  //  strcat(s_amt,"-");
        sprintf(str_amt,"-%s",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%15s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%15s",str_amt);
    }
}

check_page_break()
{
	if (l_line_no >= 60)	
	{
	    l_line_no =1;
		fprintf(fp,"\n\f");
		print_page_title();
	}
}


print_spaces(l_length)
double l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(fp," ");
	}
}
  
fetch_legend_value()
{
    for(i=1;i<30;i++)
	{	l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00024.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		         INTO :l_pk_value
				 FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00024.LEGEND_'||LTRIM(RTRIM(TO_CHA\
R(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )477;
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
  sqlstm.sqhstl[1] = (unsigned int  )202;
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
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , '\
SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_va\
lue , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )500;
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
  sqlstm.sqhstl[1] = (unsigned int  )202;
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

print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width;
	
	l_report_width=225;    

        get_header_dtls();  
        

	l_acc_entity_length = strlen(d_acc_entity_name.arr);

	//Code for Line 1
	l_start_point=(l_report_width-l_acc_entity_length)/2;
	fprintf(fp,"MDL           : BL");
	l_start_point=l_start_point-18;
	print_spaces(l_start_point);
	fprintf(fp,"%s",d_acc_entity_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(19+strlen(date.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[18],date.arr);

	//Code for Line 2  
	l_from_and_to_date.arr[0] = '\0';
	/* EXEC SQL SELECT :loc_legend[1]||' '|| :nd_from_date ||' '|| :loc_legend[19] ||' '|| :nd_to_date
	           INTO :l_from_and_to_date
	           FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 15;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ((((((:b0||' ')||:b1)||' ')||:b2)||' ')||:b3) into :\
b4  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )531;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)loc_legend[1];
 sqlstm.sqhstl[0] = (unsigned int  )201;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_from_date;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)loc_legend[19];
 sqlstm.sqhstl[2] = (unsigned int  )201;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_to_date;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_from_and_to_date;
 sqlstm.sqhstl[4] = (unsigned int  )122;
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


	l_from_and_to_date.arr[l_from_and_to_date.len] = '\0';
	l_start_point=0;
	l_start_point=(l_report_width-(strlen(l_from_and_to_date.arr)))/2;
	fprintf(fp,"OPR           : %s",d_user.arr);
	l_start_point=l_start_point-(strlen(d_user.arr)+16);
	print_spaces(l_start_point);
	fprintf(fp,"%s ",l_from_and_to_date.arr);
	l_comp_name_end_point=l_start_point+(strlen(d_user.arr)+16)+strlen(l_from_and_to_date.arr);
	l_start_point=(l_report_width-(21+strlen(date_time.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[15],date_time.arr);

	//Code for Line 3
	l_start_point=0;
	l_start_point=(l_report_width/2);
	fprintf(fp,"%-14.14s: BLR00024",loc_legend[17]);
	l_start_point=l_start_point-24;
	print_spaces(l_start_point);
	l_comp_name_end_point=l_start_point+24;
	l_start_point=(l_report_width-(18+11)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %d\n",loc_legend[16],++l_page_no);

	l_line_no= l_line_no + 3;
	print_page_header();	
	
}  

print_page_header()
{    
	print_line(232);  
	fprintf(fp,"\n");

	if (l_page_no == 1)
	{
		//fprintf(fp,"VER		: 4.1\n\n\n\n");
		fprintf(fp,"\n\n\n\n");
		fprintf(fp,"		INPUT PARAMETER\n");
		fprintf(fp,"		---------------\n\n");
		if (nd_from_patient_id.arr[0]=='\0')
		fprintf(fp,"		PATIENT ID FROM		: %s\n","LOWEST");
		else
		fprintf(fp,"		PATIENT ID FROM		: %s\n",nd_from_patient_id.arr);
		if (nd_to_patient_id.arr[0]=='\0')
		fprintf(fp,"			     TO		: %s\n","HIGEST");
		else
		fprintf(fp,"			     TO		: %s\n",nd_to_patient_id.arr);
		fprintf(fp,"		      FROM DATE		: %s\n",nd_from_date.arr);
		fprintf(fp,"			     TO		: %s\n",nd_to_date.arr);
		
		if (nd_refund_type.arr[0] == 'Y')
		fprintf(fp,"		    REFUND TYPE		: CASH");
		else if (nd_refund_type.arr[0] == 'B')
		fprintf(fp,"		    REFUND TYPE		: CHEQUE");
		else if (nd_refund_type.arr[0] == 'A')
		fprintf(fp,"		    REFUND TYPE		: CREDIT CARD");
		else if (nd_refund_type.arr[0] == 'D')
		fprintf(fp,"		    REFUND TYPE		: AUTOPAY");
		else if (nd_refund_type.arr[0] == 'C')
		fprintf(fp,"		    REFUND TYPE		: OTHERS");
		else 
		fprintf(fp,"		    REFUND TYPE		: ALL");

		fprintf(fp,"\n");

		if (nd_order_by.arr[0] == 1)
		fprintf(fp,"		       ORDER BY		: Refund Date /  Account Code\n");
		else
		fprintf(fp,"		       ORDER BY		: Account Code / Refund Date\n");

		l_line_no = 60;
		check_page_break();


	}
	else
	{
		fprintf(fp,"%5.5s %-15.15s %-21.21s %-20.20s %-60.60s %-15.15s %-14.14s %14.14s   %-16.16s %15.15s %15.15s %-10.10s\n",
		loc_legend[20],loc_legend[2],loc_legend[3],loc_legend[4],loc_legend[6],loc_legend[8],loc_legend[9],loc_legend[10],loc_legend[11], loc_legend[12], loc_legend[13], loc_legend[14]);	

		fprintf(fp,"%43.43s %-20.20s %-60.60s %-15.15s %-14.14s %14.14s   %-16.16s %15.15s %15.15s %-10.10s\n",
		 " ",loc_legend[5], loc_legend[7], " ","",base_currency.arr,loc_legend[22],base_currency.arr,base_currency.arr,"");

		print_line(232);
		fprintf(fp,"\n"); 
		l_line_no = l_line_no+4;
	}
}

print_line(l_length)
int l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(fp,"-");
	}
}
get_header_dtls()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
				    USER,
				    TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI'),
					TO_CHAR(SYSDATE,'DD/MM/YYYY'),
					TO_CHAR(SYSDATE,'HH24:MI:SS')
		      INTO :d_acc_entity_name,
			  	   :d_user,
				   :d_sysdate,
				   :date,
				   :date_time
              FROM SY_ACC_ENTITY
			 WHERE acc_entity_id = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYY\
Y HH24:MI') ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') int\
o :b0,:b1,:b2,:b3,:b4  from SY_ACC_ENTITY where acc_entity_id=:b5";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )566;
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
    sqlstm.sqhstl[2] = (unsigned int  )19;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&date;
    sqlstm.sqhstl[3] = (unsigned int  )22;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&date_time;
    sqlstm.sqhstl[4] = (unsigned int  )22;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len]                       = '\0';
	d_sysdate.arr[d_sysdate.len]                 = '\0';
    date.arr[date.len]							 = '\0';
    date_time.arr[date_time.len]				 = '\0';	

	return;
  
	err_exit:
	   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )605;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   disp_message(ERR_MESG,"Oracle error at get_header_dtls() occured....");
	   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
	   proc_exit();
}  
