
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
           char  filnam[37];
};
static const struct sqlcxp sqlfpn =
{
    36,
    "T:\\BL\\ver remov\\blr0023a\\BLR0023A.PC"
};


static unsigned long sqlctx = 1476915987;


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
            void  *sqhstv[13];
   unsigned int   sqhstl[13];
            int   sqhsts[13];
            void  *sqindv[13];
            int   sqinds[13];
   unsigned int   sqharm[13];
   unsigned int   *sqharc[13];
   unsigned short  sqadto[13];
   unsigned short  sqtdso[13];
} sqlstm = {10,13};

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
"tween TO_DATE((:b5||' 00:00:00'),'DD/MM/YYYY HH24:MI:SS') and TO_DATE((:b6||\
' 23:59:59'),'DD/MM/YYYY HH24:MI:SS')) and a.recpt_refund_ind='F') order by a.\
patient_id            ";

 static const char *sq0005 = 
"select ((org_doc_type_code||'/')||to_char(org_doc_num)) ,abs(doc_amt)  from \
bl_patient_ledger where ((((ad_pr_adj_bill_doc_type=:b0 and ad_pr_adj_bill_doc\
_num=:b1) or (org_doc_type_code=:b0 and org_doc_num=:b1)) and nvl(trx_status,'\
X')<>'C') and recpt_nature_code in ('AD','PR'))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,91,0,2,172,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,181,0,0,0,0,0,1,0,
43,0,0,3,0,0,27,189,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
74,0,0,4,0,0,13,291,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,
141,0,0,6,69,0,4,332,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
164,0,0,7,172,0,4,360,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,
207,0,0,8,75,0,4,397,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
230,0,0,5,0,0,13,420,0,0,2,0,0,1,0,2,9,0,0,2,4,0,0,
253,0,0,9,142,0,4,450,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,
9,0,0,
292,0,0,4,1200,0,9,501,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
335,0,0,5,290,0,9,544,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
366,0,0,10,161,0,4,783,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
401,0,0,11,73,0,4,901,0,0,5,4,0,1,0,1,97,0,0,1,9,0,0,1,97,0,0,1,9,0,0,2,9,0,0,
436,0,0,12,198,0,4,992,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
475,0,0,13,0,0,32,1015,0,0,0,0,0,1,0,
490,0,0,14,96,0,4,1026,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
513,0,0,15,165,0,6,1033,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* PROGRAM NAME          : BLR0023A.PC                                  */
/* AUTHOR                : D Ganesh Murthi                              */
/* DATE WRITTEN          : 15/02/2005                                	*/
/*                                                                      */
/*                                                                      */
/************************************************************************/
#include <stdio.h>
#include <string.h>
#include <bl.h>
  
#define OERROR				 (sqlca.sqlcode		< 0)
#define LAST_ROW			 (sqlca.sqlcode    == 1403)
#define NOT_FOUND			 (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode	   == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode	   == -1)
#define	MAX_LINES			 60
#define ESC					 0x1B

#define INIT_MESG "Report Generation is in progress"

/* EXEC SQL BEGIN DECLARE SECTION; */ 



	/* VARCHAR		uid_pwd				[132],
			hosp_name			[120],
			date_time			[20],
			user_id				[20],
			nd_pgm_date			[35],
			nd_facility_name		[31],
			nd_session_id			[16],
			nd_facility_id			[3]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


	/* VARCHAR d_acc_entity_name			[41],
			d_user				[21],
			d_sysdate			[17],
			date				[20],
			d_currency[10]; */ 
struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[10]; } d_currency;

            
	/* VARCHAR	nd_lang_id			[4]; */ 
struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;


	/* VARCHAR l_pk_value			[200],
			l_translated_value	[201],
			l_from_and_to_date  [61]; */ 
struct { unsigned short len; unsigned char arr[200]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[61]; } l_from_and_to_date;
    

	/* VARCHAR l_episode_type		[2],
			l_refund_type		[4],
			l_fr_date			[11],
			l_to_date			[11],
			d_episode_id		[10],
			d_visit_id		[10],
			d_patient_id		[21],
			d_payer_name		[61],
			d_remark            [51],
			d_ref_doc_type_code     [11],
			d_refund_doc		[11],
			d_ref_doc_date   	[21],
			l_address_line1		[33],
			l_address_line2		[33],
			l_address_line3		[33],
			l_tel_number		[33],
			d_bill_doc_type_code[11],			
			d_bill_doc_number	[19],
			d_bill_doc_date			[11],
			d_ref_doc_num           [11],
			d_oth_doc_type_code	[9],
			d_oth_doc_number	[11],
			d_oth_doc_date		[11],
			d_ln1_res_add		[41],
			d_ln2_res_add		[41],
			d_ln3_res_add		[41],
			d_ln4_res_add		[41],
			d_res_postal_code	[11],
			d_res_country_code	[11],
			d_res_country_name	[50],
			d_dep_doc_num		[18],
			d_recpt_nature		[3],
			l_sysdate			[20],
			l_hospital_name		[50],
			p_language_id       [3] ; */ 
struct { unsigned short len; unsigned char arr[2]; } l_episode_type;

struct { unsigned short len; unsigned char arr[4]; } l_refund_type;

struct { unsigned short len; unsigned char arr[11]; } l_fr_date;

struct { unsigned short len; unsigned char arr[11]; } l_to_date;

struct { unsigned short len; unsigned char arr[10]; } d_episode_id;

struct { unsigned short len; unsigned char arr[10]; } d_visit_id;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_payer_name;

struct { unsigned short len; unsigned char arr[51]; } d_remark;

struct { unsigned short len; unsigned char arr[11]; } d_ref_doc_type_code;

struct { unsigned short len; unsigned char arr[11]; } d_refund_doc;

struct { unsigned short len; unsigned char arr[21]; } d_ref_doc_date;

struct { unsigned short len; unsigned char arr[33]; } l_address_line1;

struct { unsigned short len; unsigned char arr[33]; } l_address_line2;

struct { unsigned short len; unsigned char arr[33]; } l_address_line3;

struct { unsigned short len; unsigned char arr[33]; } l_tel_number;

struct { unsigned short len; unsigned char arr[11]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[19]; } d_bill_doc_number;

struct { unsigned short len; unsigned char arr[11]; } d_bill_doc_date;

struct { unsigned short len; unsigned char arr[11]; } d_ref_doc_num;

struct { unsigned short len; unsigned char arr[9]; } d_oth_doc_type_code;

struct { unsigned short len; unsigned char arr[11]; } d_oth_doc_number;

struct { unsigned short len; unsigned char arr[11]; } d_oth_doc_date;

struct { unsigned short len; unsigned char arr[41]; } d_ln1_res_add;

struct { unsigned short len; unsigned char arr[41]; } d_ln2_res_add;

struct { unsigned short len; unsigned char arr[41]; } d_ln3_res_add;

struct { unsigned short len; unsigned char arr[41]; } d_ln4_res_add;

struct { unsigned short len; unsigned char arr[11]; } d_res_postal_code;

struct { unsigned short len; unsigned char arr[11]; } d_res_country_code;

struct { unsigned short len; unsigned char arr[50]; } d_res_country_name;

struct { unsigned short len; unsigned char arr[18]; } d_dep_doc_num;

struct { unsigned short len; unsigned char arr[3]; } d_recpt_nature;

struct { unsigned short len; unsigned char arr[20]; } l_sysdate;

struct { unsigned short len; unsigned char arr[50]; } l_hospital_name;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

 
char		loc_legend[40][201];
char        d_dep_doc_num_arr[7][20],l_mesg[1000];

int			l_line_no =0;
int			l_page_no =0;
int			i, j;
int         d_rownum;
int         srlno = 1;

double   d_refund_amt;
double   d_bill_tot_amt;
double   d_oth_doc_amt;
double   d_dep_amount;
double   d_dep_amount_arr[10];

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

int lctr = 0,pctr = 0;

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

	strcpy(p_language_id.arr,l_language_id.arr);
    p_language_id.len = l_language_id.len; 

	if(sql_connect() == -1)
	{
		disp_message(ERR_MESG,"Error in connecting to Oracle\n");
		if (uid_pwd.len == 0)
			disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
		proc_exit();
	}

    set_meduser_role();

    declare_cursors();

    fetch_prog_param();

    fetch_hosp_name();

    open_file();

    open_cursors();

    fetch_legend_value();
    print_param_header();
    print_report();

    end_of_rep();

	/* EXEC SQL DELETE SY_PROG_PARAM
            WHERE PGM_ID   = 'BLR0023A'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLR0023A' and SE\
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
/* EXEC SQL DECLARE DEP_REFUND_MAIN CURSOR FOR 
SELECT	 a.patient_id, 
	 decode(a.episode_type,'R',null,a.episode_id),
	 decode(a.episode_type,'E',a.visit_id,'O',a.visit_id,null),
	 a.payer_name, 
	 a.doc_type_code,
	 a.doc_number,
	 TO_CHAR(a.doc_date,'DD/MM/YYYY') refund_date,
	 a.bill_doc_type_code ref_against_doc_type, 
	 a.bill_doc_number ref_against_doc_num, 
	 TO_CHAR(b.doc_date,'DD/MM/YYYY') bill_date, 
	 b.bill_amt bill_amount,
         abs(a.doc_amt) refund_amt, 
	 a.recpt_nature_code recpt_nature_code
FROM	 BL_RECEIPT_REFUND_HDRDTL_VW a, bl_bill_hdr b
WHERE	 a.operating_facility_id	= :nd_facility_id
AND      a.operating_facility_id	= b.operating_facility_id(+)
AND      a.bill_doc_type_code		= b.doc_type_code(+)
AND      a.bill_doc_number		= b.doc_num(+)
AND	 nvl(a.cancelled_ind,'N')	= 'N'
AND	 a.episode_type	= decode(:l_episode_type,'A',a.episode_type, :l_episode_type)
AND	( 
	(
	   :l_refund_type in ('D','B') and ((a.recpt_nature_code in ('BI','DC')
	                            and (nvl(b.prepay_adj_amt,0) + 
				        nvl(b.deposit_adj_amt,0)) > 0
					and nvl(b.bill_status,'X') != 'C')
				     or a.recpt_nature_code in ('AD','RD')
				    )
	  )
	  or
	 (
	   :l_refund_type in ('O','B') and a.recpt_nature_code in ('MI')

	  )
        )

AND	 a.doc_date BETWEEN TO_DATE(:l_fr_date||' 00:00:00','DD/MM/YYYY HH24:MI:SS')
			AND TO_DATE(:l_to_date||' 23:59:59','DD/MM/YYYY HH24:MI:SS')
AND	 a.recpt_refund_ind = 'F'
Order By a.patient_id; */ 


/* EXEC SQL  DECLARE  DEP_DETAILS CURSOR FOR
SELECT    org_doc_type_code ||'/'|| to_char(org_doc_num), abs(doc_amt)
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
AND recpt_nature_code in ( 'AD','PR'); */ 


}


fetch_cur()
{
    d_episode_id.arr[0]			 = '\0';
    d_visit_id.arr[0]			 = '\0';
    d_patient_id.arr[0]			 = '\0';
    d_payer_name.arr[0]			 = '\0';
    d_remark.arr[0]				 = '\0';
    d_ref_doc_type_code.arr[0]		 = '\0';
    d_ref_doc_num.arr[0]			 = '\0';
    d_ref_doc_date.arr[0]		 = '\0';
    d_bill_doc_type_code.arr[0]  = '\0';
    d_bill_doc_number.arr[0]     = '\0';
    d_bill_doc_date.arr[0]			 = '\0';
    d_recpt_nature.arr[0]		 = '\0';

    d_episode_id.len			 = 0;
    d_visit_id.len				 = 0;
    d_patient_id.len			 = 0;
    d_payer_name.len			 = 0;
    d_remark.len				 = 0;
    d_ref_doc_type_code.len			 = 0;
    d_ref_doc_num.len				 = 0;
    d_ref_doc_date.len			 = 0;
    d_bill_doc_type_code.len     = 0;
    d_bill_doc_number.len        = 0;
    d_bill_doc_date.len				 = 0;
    d_recpt_nature.len			 = 0;

    d_refund_amt				 = 0;
    d_bill_tot_amt				 = 0;

    /* EXEC SQL FETCH DEP_REFUND_MAIN 
	     INTO  
		   :d_patient_id,
		   :d_episode_id,
		   :d_visit_id,
		   :d_payer_name,
		   :d_ref_doc_type_code,
		   :d_ref_doc_num,
		   :d_ref_doc_date,
		   :d_bill_doc_type_code,
		   :d_bill_doc_number,
		   :d_bill_doc_date,
		   :d_bill_tot_amt,
		   :d_refund_amt,
		   :d_recpt_nature; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
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
    sqlstm.sqhstv[2] = (         void  *)&d_visit_id;
    sqlstm.sqhstl[2] = (unsigned int  )12;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_payer_name;
    sqlstm.sqhstl[3] = (unsigned int  )63;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_ref_doc_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_ref_doc_num;
    sqlstm.sqhstl[5] = (unsigned int  )13;
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
    sqlstm.sqhstv[7] = (         void  *)&d_bill_doc_type_code;
    sqlstm.sqhstl[7] = (unsigned int  )13;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_bill_doc_number;
    sqlstm.sqhstl[8] = (unsigned int  )21;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_bill_doc_date;
    sqlstm.sqhstl[9] = (unsigned int  )13;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_bill_tot_amt;
    sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_refund_amt;
    sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_recpt_nature;
    sqlstm.sqhstl[12] = (unsigned int  )5;
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
	err_mesg("FETCH failed on cursor DEP_REFUND_MAIN",0,"");

    if(NO_DATA_FOUND)
		return 0;

    d_episode_id.arr[d_episode_id.len]					= '\0';
    d_visit_id.arr[d_visit_id.len]					= '\0';
    d_patient_id.arr[d_patient_id.len]					= '\0';
    d_payer_name.arr[d_payer_name.len]					= '\0';
    d_ref_doc_date.arr[d_ref_doc_date.len]				= '\0';
    d_remark.arr[d_remark.len]						= '\0';
    d_ref_doc_type_code.arr[d_ref_doc_type_code.len]			= '\0';
	d_refund_doc.arr[d_refund_doc.len]				= '\0';
	d_ref_doc_date.arr[d_ref_doc_date.len]				= '\0';
    d_bill_doc_type_code.arr[d_bill_doc_type_code.len]			= '\0';
    d_bill_doc_number.arr[d_bill_doc_number.len]			= '\0';
    d_bill_doc_date.arr[d_bill_doc_date.len]				= '\0';
	d_recpt_nature.arr[d_recpt_nature.len]				= '\0';

	
    if (d_patient_id.arr[0] != '\0' && d_payer_name.arr[0] == '\0')
    {
	/* EXEC SQL select short_name into :d_payer_name 
	     FROM mp_patient_mast
	     WHERE patient_id = :d_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_name into :b0  from mp_patient_mast where patie\
nt_id=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )141;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_payer_name;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
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



	d_payer_name.arr[d_payer_name.len] = '\0';
    }
    
    return 1;
}


fetch_pat_address()
{
    d_ln1_res_add.arr[0]		 = '\0';
    d_ln2_res_add.arr[0]         = '\0';
    d_ln3_res_add.arr[0]		 = '\0';
    d_ln4_res_add.arr[0]		 = '\0';
    d_res_postal_code.arr[0]     = '\0';
    d_res_country_code.arr[0]    = '\0';

    d_ln1_res_add.len			 = 0;
	d_ln2_res_add.len            = 0;
    d_ln3_res_add.len			 = 0;
    d_ln4_res_add.len			 = 0;
    d_res_postal_code.len        = 0;
    d_res_country_code.len       = 0;


/* EXEC SQL  
SELECT	   ln1_mail_add, 
	   ln2_mail_add, 
	   ln3_mail_add, 
	   ln4_mail_add, 
	   mail_postal_code, 
	   mail_country_code
INTO       :d_ln1_res_add,
	   :d_ln2_res_add,
	   :d_ln3_res_add,
	   :d_ln4_res_add,
           :d_res_postal_code,
	   :d_res_country_code
FROM mp_pat_other_dtls
WHERE patient_id = :d_patient_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 13;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select ln1_mail_add ,ln2_mail_add ,ln3_mail_add ,ln4_mail_add\
 ,mail_postal_code ,mail_country_code into :b0,:b1,:b2,:b3,:b4,:b5  from mp_pa\
t_other_dtls where patient_id=:b6";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )164;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_ln1_res_add;
sqlstm.sqhstl[0] = (unsigned int  )43;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&d_ln2_res_add;
sqlstm.sqhstl[1] = (unsigned int  )43;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&d_ln3_res_add;
sqlstm.sqhstl[2] = (unsigned int  )43;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&d_ln4_res_add;
sqlstm.sqhstl[3] = (unsigned int  )43;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&d_res_postal_code;
sqlstm.sqhstl[4] = (unsigned int  )13;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&d_res_country_code;
sqlstm.sqhstl[5] = (unsigned int  )13;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&d_patient_id;
sqlstm.sqhstl[6] = (unsigned int  )23;
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
	err_mesg("FETCH failed on cursor PAT_ADDRESS",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_ln1_res_add.arr[d_ln1_res_add.len]               = '\0';
    d_ln2_res_add.arr[d_ln2_res_add.len]               = '\0';
    d_ln3_res_add.arr[d_ln3_res_add.len]               = '\0';
    d_ln4_res_add.arr[d_ln4_res_add.len]	       = '\0';
    d_res_postal_code.arr[d_res_postal_code.len]       = '\0';
    d_res_country_code.arr[d_res_country_code.len]     = '\0';


    if ( d_res_country_code.arr[0] != '\0')
    {
	d_res_country_name.arr[0] = '\0';
	d_res_country_name.len = 0;

	/* EXEC SQL select country_name into :d_res_country_name
		 from mp_country_his_vw
		 where country_code = :d_res_country_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select country_name into :b0  from mp_country_his_vw where c\
ountry_code=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )207;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_res_country_name;
 sqlstm.sqhstl[0] = (unsigned int  )52;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_res_country_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
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



	if(OERROR)
	err_mesg("FETCH failed on MP_COUNTRY_HIS_VW",0,"");

	d_res_country_name.arr[d_res_country_name.len] = '\0';
     }  



    return 1;

}

fetch_dep_dtls()
{
    d_dep_doc_num.arr[0]	= '\0';
    d_dep_doc_num.len		= 0;
    d_dep_amount		= 0;

    
	/* EXEC SQL FETCH DEP_DETAILS 
	INTO  :d_dep_doc_num, 
	      :d_dep_amount; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )230;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_dep_doc_num;
 sqlstm.sqhstl[0] = (unsigned int  )20;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_dep_amount;
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



         
		if(OERROR)
		err_mesg("FETCH failed on cursor fetch_dep_dtls",0,"");

		if(NO_DATA_FOUND)
		return 0;
	
    d_dep_doc_num.arr[d_dep_doc_num.len] = '\0';
   
    return 1;

}


fetch_prog_param()
{
    l_episode_type.arr[0]	 ='\0'; 
    l_refund_type.arr[0]	 ='\0';
    l_fr_date.arr[0]		 ='\0';
    l_to_date.arr[0]		 ='\0';

    l_episode_type.len           = 0;
    l_refund_type.len            = 0;
    l_fr_date.len		 = 0;
    l_to_date.len		 = 0;
 
   /* EXEC SQL SELECT PARAM1,PARAM2,PARAM3,PARAM4
            INTO :l_episode_type, :l_refund_type, :l_fr_date, :l_to_date
            FROM  SY_PROG_PARAM
            WHERE PGM_ID   = 'BLR0023A'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 into :b0,:b1,:b2,:b3\
  from SY_PROG_PARAM where ((PGM_ID='BLR0023A' and SESSION_ID=:b4) and PGM_DAT\
E=:b5)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )253;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_episode_type;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_refund_type;
   sqlstm.sqhstl[1] = (unsigned int  )6;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_fr_date;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_to_date;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[4] = (unsigned int  )18;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[5] = (unsigned int  )37;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

	l_episode_type.arr[l_episode_type.len]	= '\0';
	l_refund_type.arr[l_refund_type.len]	= '\0';
	l_fr_date.arr[l_fr_date.len]			= '\0';
    l_to_date.arr[l_to_date.len]			= '\0';
}
  

end_of_rep()
{
	fprintf(fp,"\n%55s***  END OF REPORT ***\n\f"," ");
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR0023A.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR0023A.lis");
       proc_exit();
    }
}

open_cursors()
{
/*  EXEC SQL OPEN REFUND_OTHER;

	if(OERROR)
	err_mesg("OPEN failed on cursor REFUND_OTHER",0,"");

	EXEC SQL OPEN REFUND_BI;

	if(OERROR)
	err_mesg("OPEN failed on cursor REFUND_BI",0,"");
*/

	/* EXEC SQL OPEN DEP_REFUND_MAIN; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.patient_id ,decode(a.episode_type,'R',null ,a.episode_id) ,deco\
de(a.episode_type,'E',a.visit_id,'O',a.visit_id,null ) ,a.payer_name ,a.doc_\
type_code ,a.doc_number ,TO_CHAR(a.doc_date,'DD/MM/YYYY') refund_date ,a.bil\
l_doc_type_code ref_against_doc_type ,a.bill_doc_number ref_against_doc_num \
,TO_CHAR(b.doc_date,'DD/MM/YYYY') bill_date ,b.bill_amt bill_amount ,abs(a.d\
oc_amt) refund_amt ,a.recpt_nature_code recpt_nature_code  from BL_RECEIPT_R\
EFUND_HDRDTL_VW a ,bl_bill_hdr b where ((((((((a.operating_facility_id=:b0 a\
nd a.operating_facility_id=b.operating_facility_id(+)) and a.bill_doc_type_c\
ode=b.doc_type_code(+)) and a.bill_doc_number=b.doc_num(+)) and nvl(a.cancel\
led_ind,'N')='N') and a.episode_type=decode(:b1,'A',a.episode_type,:b1)) and\
 ((:b3 in ('D','B') and (((a.recpt_nature_code in ('BI','DC') and (nvl(b.pre\
pay_adj_amt,0)+nvl(b.deposit_adj_amt,0))>0) and nvl(b.bill_status,'X')<>'C')\
 or a.recpt_nature_code in ('AD','RD'))) or (:b3 in ('O','B') and a.recpt_na\
ture_code in ('MI')))) and a.doc_date be");
 sqlstm.stmt = sq0004;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )292;
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
 sqlstm.sqhstv[1] = (         void  *)&l_episode_type;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_episode_type;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_refund_type;
 sqlstm.sqhstl[3] = (unsigned int  )6;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_refund_type;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_fr_date;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_to_date;
 sqlstm.sqhstl[6] = (unsigned int  )13;
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
	err_mesg("OPEN failed on cursor DEP_REFUND_MAIN",0,"");


	
	/*EXEC SQL OPEN PAT_ADDRESS;

	if(OERROR)	   
	err_mesg("OPEN failed on cursor PAT_ADDRESS",0,"");*/
}

print_rep()
{
   
	for (i=1;i<=10; i++)
	{
	for (j=0;j<=10;j++)
	{
	d_dep_doc_num_arr[i][j] = '\0';
	}
	d_dep_amount_arr[i] = 0;
	}        

     fprintf(fp,"%5d %-20.20s ",srlno, d_patient_id.arr);
	 fprintf(fp,"%-10.10s %-8.8s",d_episode_id.arr,d_visit_id.arr);
				 
     if (strcmp(d_recpt_nature.arr, "BI") == 0 || strcmp(d_recpt_nature.arr, "DC") == 0)
     {
	if (d_bill_doc_number.arr[0] == '\0')
	{
		fprintf(fp,"%-18.18s "," ");
	}
	else
	{
		sprintf(l_mesg,"%s/%s",d_bill_doc_type_code.arr,d_bill_doc_number.arr);
		fprintf(fp,"%-18.18s ",l_mesg);
	}  
     }  
     else
	fprintf(fp,"%-18.18s "," ");

     /* EXEC SQL OPEN DEP_DETAILS; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 13;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0005;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )335;
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
     sqlstm.sqhstl[1] = (unsigned int  )21;
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
     sqlstm.sqhstl[3] = (unsigned int  )21;
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
     while(fetch_dep_dtls())
     {
	strcpy(d_dep_doc_num_arr[i],d_dep_doc_num.arr);
	d_dep_amount_arr[i] = d_dep_amount;
	i++;
     }     	
 
     if (d_dep_doc_num_arr[1][0] == '\0')  
     {
        fprintf(fp,"%-15.15s"," ");
	fprintf(fp,"%-18.18s "," ");     
     }
     else
     {
	print_formated(d_dep_amount_arr[1]);
	fprintf(fp,"%-18.18s ",d_dep_doc_num_arr[1]);
     }

    	
    fprintf(fp,"   ");
    print_formated(d_refund_amt);
    
    sprintf(l_mesg,"%s/%s",d_ref_doc_type_code.arr,d_ref_doc_num.arr);

    fprintf(fp,"%-18.18s\n",l_mesg);

    l_line_no = l_line_no+1;      

    //2

    fprintf(fp,"%5s %-40.40s "," ",d_payer_name.arr);  
    
    if (d_bill_doc_date.arr[0] == '\0')
		fprintf(fp,"%-18.18s "," ");
    else
	   fprintf(fp,"%-18.18s ",d_bill_doc_date.arr);

    if ( d_dep_amount_arr[2] == 0 ) 
		fprintf(fp,"%-15.15s", " ");
	else  
		print_formated(d_dep_amount_arr[2]);	
 
    if (d_dep_doc_num_arr[2][0] == '\0')
	fprintf(fp,"%-18.18s "," ");
    else
	fprintf(fp,"%-18.18s ",d_dep_doc_num_arr[2]);

    fprintf(fp,"%-18.18s","");
    fprintf(fp,"%-10s",d_ref_doc_date.arr);
	
    fprintf(fp,"\n");
    l_line_no = l_line_no+1;  
	
    fetch_pat_address();

    //3

    if ( d_ln1_res_add.arr[0] != '\0' || d_dep_amount_arr[3] != 0 ||
         d_dep_doc_num_arr[3][0] != '\0' || d_bill_tot_amt != 0 )
    {						
	    fprintf(fp,"      %-40.40s ",d_ln1_res_add.arr);

	    if (d_bill_tot_amt != 0)
		print_formated_lr(d_bill_tot_amt);
	    else
		fprintf(fp,"%-15.15s"," ");

	    fprintf(fp,"    ");      	

	    if (d_dep_amount_arr[3] == 0 )
		fprintf(fp,"%-15.15s"," ");
	    else
	    { 	
		print_formated(d_dep_amount_arr[3]);	
	    }

	    if (d_dep_doc_num_arr[3][0] == '\0')
		{
		  fprintf(fp,"%-18.18s "," ");
		}
		else
		{
		 fprintf(fp,"%-18.18s ",d_dep_doc_num_arr[3]);
		}
			
	    fprintf(fp,"\n");
	    l_line_no = l_line_no+1;  
    }
    // 4

    if ( d_ln2_res_add.arr[0] != '\0' || d_dep_amount_arr[4] != 0 ||
         d_dep_doc_num_arr[4][0] != '\0' )
    {
	fprintf(fp,"      %-40.40s ",d_ln2_res_add.arr);
	fprintf(fp,"%-18.18s "," ");

	if ( d_dep_amount_arr[4] == 0 )
		fprintf(fp,"%-15.15s"," " );
	else
	{	
		print_formated(d_dep_amount_arr[4]);	
	}
 
    if (d_dep_doc_num_arr[4][0] == '\0')
	{
	  fprintf(fp,"%-18.18s "," ");
	}
	else
        {
	 fprintf(fp,"%-18.18s ",d_dep_doc_num_arr[4]);
	}
	
	fprintf(fp,"\n");
	l_line_no = l_line_no+1;  
    }

    //5
    
     if ( d_ln3_res_add.arr[0] != '\0' || d_dep_amount_arr[5]!= 0 ||
         d_dep_doc_num_arr[5][0] != '\0' )
      {
	fprintf(fp,"      %-40.40s ",d_ln3_res_add.arr);
	fprintf(fp,"%-18.18s "," ");

	if ( d_dep_amount_arr[5] == 0 ) 
		fprintf(fp,"%-15.15s"," ");
	else
	{
	  print_formated(d_dep_amount_arr[5]);	
	}
 
	if (d_dep_doc_num_arr[5][0] == '\0')
	{
	  fprintf(fp,"%-18.18s "," ");
	} 
	else
	{
	 fprintf(fp,"%-18.18s ",d_dep_doc_num_arr[5]);
	}
	
	fprintf(fp,"\n");
	l_line_no = l_line_no+1;  
      }

      //6
	
      if ( d_ln4_res_add.arr[0] != '\0' || d_dep_amount_arr[6] != 0 ||
         d_dep_doc_num_arr[6][0] != '\0'
	 )
      {       

	fprintf(fp,"      %-40.40s ",d_ln4_res_add.arr);
	fprintf(fp,"%-18.18s "," ");

	if ( d_dep_amount_arr[6]== 0 ) 
		fprintf(fp,"%-15.15s"," ");
	else
	{
		print_formated(d_dep_amount_arr[6]);	
	}
 
        if (d_dep_doc_num_arr[6][0] == '\0')
	{
	  fprintf(fp,"%-18.18s "," ");
	}
	else
        {
	 fprintf(fp,"%-18.18s ",d_dep_doc_num_arr[6]);
	}
	
	fprintf(fp,"\n");
	l_line_no = l_line_no+1;  	
      }

      //7

      if ( d_res_country_name.arr[0] != '\0' || d_res_postal_code.arr[0] != '\0' || 
          d_dep_amount_arr[7] != 0  || d_dep_doc_num_arr[7][0] != '\0')
        {
	sprintf(l_mesg, "%-s  %-s ", d_res_postal_code.arr, d_res_country_name.arr);
	fprintf(fp,"      %-40.40s ",l_mesg);
	fprintf(fp,"%-18.18s "," ");

	if ( d_dep_amount_arr[7]== 0 ) 
		fprintf(fp,"%-15.15s"," ");
	else
	{
		print_formated(d_dep_amount_arr[7]);	
	}
 
        if (d_dep_doc_num_arr[7][0] == '\0')
	{
	  fprintf(fp,"%-18.18s "," ");
	}
	else
        {
	 fprintf(fp,"%-18.18s ",d_dep_doc_num_arr[7]);
	}
	
	fprintf(fp,"\n");
	l_line_no = l_line_no+1;  	
       }    

	fprintf(fp,"\n");
		
	l_line_no = l_line_no+1;  
	check_page_break();

}

print_report()
{
		print_page_header();

	while(fetch_cur())
	{
		print_rep();
		srlno++;
	}

}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    d_currency.arr[0] = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;
    d_currency.len   = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
		    USER, '('||BASE_CURRENCY||')'
    INTO :hosp_name, :date_time, :user_id, :d_currency
    FROM SY_ACC_ENTITY    
    WHERE acc_entity_id = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER ,(('('||BASE_CURRENCY)||')') into :b0,:b1,:b2,:b3  from SY_ACC_ENTI\
TY where acc_entity_id=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )366;
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
    sqlstm.sqhstv[3] = (         void  *)&d_currency;
    sqlstm.sqhstl[3] = (unsigned int  )12;
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
	d_currency.arr[d_currency.len]         = '\0';
}

print_formated(loc_amount)
double loc_amount;
{
    char s_amt[30], str_amt[30];	
    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
//	    strcat(s_amt,"-");
        sprintf(str_amt,"%14s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%14s-",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%14s ",str_amt);
    }
}  


print_formated_lr(loc_amount)
double loc_amount;
{
    char s_amt[30], str_amt[30];	
    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%-s-",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%-15s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%-s",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%-14s ",str_amt);
    }
}  

check_page_break()
{
	if (l_line_no >= 61)	
	{  
		l_line_no = 0;
		fprintf(fp,"\f\n");    
		print_page_header();
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

print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width;
	
	l_report_width=132;

    get_header_dtls();    

	l_acc_entity_length = strlen(d_acc_entity_name.arr);

	//Code for Line 1
	l_start_point=(l_report_width/2)-(l_acc_entity_length/2);
	fprintf(fp,"MDL           : BL");
	l_start_point=l_start_point-18;
	print_spaces(l_start_point);
	fprintf(fp,"%s",d_acc_entity_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(15+strlen(date.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[11],date.arr);

	//Code for Line 2  
	l_start_point=0;
	l_start_point=(l_report_width/2)-((strlen(loc_legend[1]))/2);
	fprintf(fp,"OPR           : %s",d_user.arr);
	l_start_point=l_start_point-(strlen(d_user.arr)+16);
	print_spaces(l_start_point);
	fprintf(fp,"%s",loc_legend[1]);
	l_comp_name_end_point=l_start_point+(strlen(d_user.arr)+16)+strlen(loc_legend[1]);
	l_start_point=(l_report_width-(17+strlen(date_time.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp," %-15.15s : %s\n",loc_legend[12],date_time.arr);

	//Code for Line 3
	l_from_and_to_date.arr[0] = '\0';
	/* EXEC SQL SELECT :loc_legend[15]||' '|| :l_fr_date || ' '||:loc_legend[18] ||' ' || :l_to_date
	           INTO :l_from_and_to_date
	           FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ((((((:b0||' ')||:b1)||' ')||:b2)||' ')||:b3) into :b\
4  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )401;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)loc_legend[15];
 sqlstm.sqhstl[0] = (unsigned int  )201;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_fr_date;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)loc_legend[18];
 sqlstm.sqhstl[2] = (unsigned int  )201;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_to_date;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_from_and_to_date;
 sqlstm.sqhstl[4] = (unsigned int  )63;
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
	l_start_point=(l_report_width/2)-((strlen(l_from_and_to_date.arr))/2);
	fprintf(fp,"%-14.14s: BLR0023A",loc_legend[14]);
	l_start_point=l_start_point-24;
	print_spaces(l_start_point);
	fprintf(fp,"%s",l_from_and_to_date.arr);
	l_comp_name_end_point=l_start_point+24+strlen(l_from_and_to_date.arr);
	l_start_point=(l_report_width-(17+7)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %d\n",loc_legend[13],++l_page_no);

	//Code for Line 4
	/*
	l_start_point=0;
	l_start_point=(l_report_width/2)-((strlen(loc_legend[1]))/2);
	print_spaces(l_start_point);
	fprintf(fp,"%s \n",loc_legend[17]);
	l_comp_name_end_point=l_start_point+strlen(loc_legend[17]);
	*/

	//l_line_no= l_line_no + 4;

	l_line_no= l_line_no + 3;
   //	print_page_header();	
	
}
//-----------
print_param_header()
{
int l1,rep_width=132;

  print_page_title();
  print_line(136);
  fprintf(fp,"\n\n\n\n\n");
  //fprintf(fp,"%12sVER: 4.1 \n"," ");
  fprintf(fp,"%12sINPUT PARAMETER \n"," ");
  fprintf(fp,"%12s--------------- \n"," ");
  

    if(strcmp(l_episode_type.arr,"A")==0)
      fprintf(fp,"%12s %-20s: %-5s \n"," ",loc_legend[23],loc_legend[24]);
     else     
      fprintf(fp,"%12s %-20s: %-5s \n"," ",loc_legend[23],l_episode_type.arr);  
  
      if(strcmp(l_refund_type.arr,"D") ==0)  	                                
      fprintf(fp,"%12s %-20s: %-15s\n "," ",loc_legend[25],loc_legend[26]);
      
	  if(strcmp(l_refund_type.arr,"O") ==0)  	                                
      fprintf(fp,"%12s %-20s: %-15s\n "," ",loc_legend[25],loc_legend[27]);
       
	  if(strcmp(l_refund_type.arr,"B") ==0)  	                                
      fprintf(fp,"%12s %-20s: %-11s\n "," ",loc_legend[25],loc_legend[28]);

      fprintf(fp,"%12s%-20s %-11s%-2s %-14s"," ",loc_legend[16],l_fr_date.arr,loc_legend[18],l_to_date.arr);


     fprintf(fp,"\f");

}

//----------------

print_page_header()
{
   print_page_title();
	print_line(136);
	fprintf(fp,"\n");
	fprintf(fp,"%5.5s %-40.40s %-16.16s %16.16s %-18.18s %17.17s %-18.18s\n", loc_legend[19],loc_legend[2],loc_legend[3],loc_legend[7],loc_legend[8],loc_legend[9],loc_legend[20]);	
	fprintf(fp,"%5.5s %-40.40s %-16.16s %16.16s %-18.18s %17.17s %-18.18s\n"," ",loc_legend[4], loc_legend[11],d_currency.arr,"","",loc_legend[10]);	
	fprintf(fp,"%5.5s %-40.40s %-s%s \n"," ",loc_legend[5], loc_legend[6], d_currency.arr);		
	print_line(136);
	fprintf(fp,"\n");
	l_line_no = l_line_no+5;
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
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY\
 HH24:MI') ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') into \
:b0,:b1,:b2,:b3,:b4  from SY_ACC_ENTITY where acc_entity_id=:b5";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )436;
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
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )475;
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

fetch_legend_value()
{
    for(i=1;i<50;i++)
	{	l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR0023A.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		         INTO :l_pk_value
				 FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR0023A.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )490;
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
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )513;
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



