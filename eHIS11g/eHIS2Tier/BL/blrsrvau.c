
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/blrsrvau.pc"
};


static unsigned int sqlctx = 1288469267;


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
            void  *sqhstv[42];
   unsigned int   sqhstl[42];
            int   sqhsts[42];
            void  *sqindv[42];
            int   sqinds[42];
   unsigned int   sqharm[42];
   unsigned int   *sqharc[42];
   unsigned short  sqadto[42];
   unsigned short  sqtdso[42];
} sqlstm = {12,42};

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

 static const char *sq0007 = 
"select SHORT_DESC  from BL_BLNG_PRT_GRP_LINE where (PRT_GRP_HDR_CODE=:b0 and\
 PRT_GRP_LINE_CODE=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,148,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,218,0,4,181,0,0,11,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
95,0,0,3,128,0,4,234,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
126,0,0,4,0,0,30,263,0,0,0,0,0,1,0,
141,0,0,5,91,0,2,270,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
164,0,0,6,0,0,17,319,0,0,1,1,0,1,0,1,9,0,0,
183,0,0,6,0,0,45,339,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
226,0,0,6,0,0,45,350,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
265,0,0,7,110,0,9,396,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
288,0,0,7,0,0,13,404,0,0,1,0,0,1,0,2,9,0,0,
307,0,0,6,0,0,13,496,0,0,42,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,4,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
};


     
/************************************************************************/
/* CSS MEDICOM VER 2.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRSRVAU.PC                                  */
/* AUTHOR                : V.SRIKANTH                                   */
/* DATE WRITTEN          : 21/03/1999                                   */
/*                                                                      */
/* FUNCTION              : AUDIT TRAIL FOR BILLING SERVICES             */
/*                                                                      */
/* TABLE DETAILS         : BL_BLNG_SERV_AUDIT_DTLS                      */
/*                         SY_ACC_ENTITY                                */
/*                         SY_PROG_PARAM                                */
/*                                                                      */
/*                                                                      */
/* FUNCTIONS             : decl_curs()                                  */    
/*						   do_report()							        */
/*						   fetch_prt_grp_desc()						    */
/*						   fetch_bl_blng_audit()						*/
/*						   put_hdr()						            */
/*						   put_rec() 								    */
/*						   chk_break()						            */
/*						   put_inp_parm()							    */
/*						   print_end_of_rep()						    */	
/*						   del_parm()						            */
/*						   print_formated()						        */
/*                                                                      */
/*                                                                      */
/************************************************************************/
      
/*
#define DEBUG
*/
        
#include <stdio.h>
#include <string.h>
#include <bl.h>
#define  INIT_MESG "Report Generation In Progress"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd				[41],
  	        d_session_id		[16],
	        d_pgm_date			[14],
	        rep_date			[20],
	        comp_name			[50],
			d_facility_id		[10],
	        oper_id				[21]; */ 
struct { unsigned short len; unsigned char arr[41]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[10]; } d_facility_id;

struct { unsigned short len; unsigned char arr[21]; } oper_id;


    /* VARCHAR trx_date_fm			[17],
			trx_date_to			[17],
			trx_blsrv_fm		[11],
			trx_blsrv_to		[11],
			trx_usrid_fm		[21],
			trx_usrid_to		[21],
			trx_report_ord		[2],
			trx_report_opt		[2]; */ 
struct { unsigned short len; unsigned char arr[17]; } trx_date_fm;

struct { unsigned short len; unsigned char arr[17]; } trx_date_to;

struct { unsigned short len; unsigned char arr[11]; } trx_blsrv_fm;

struct { unsigned short len; unsigned char arr[11]; } trx_blsrv_to;

struct { unsigned short len; unsigned char arr[21]; } trx_usrid_fm;

struct { unsigned short len; unsigned char arr[21]; } trx_usrid_to;

struct { unsigned short len; unsigned char arr[2]; } trx_report_ord;

struct { unsigned short len; unsigned char arr[2]; } trx_report_opt;

    
	/* VARCHAR d_blng_serv_code				[11],
            d_long_desc						[41],
			d_short_desc					[15],
			d_loc_lang_long_desc			[31],
	     	d_loc_lang_short_desc			[17],
			d_serv_grp_code					[3],
   			d_serv_clasfn_code				[4],
			d_prt_grp_hdr_code				[3],
   			d_prt_grp_line_code				[3],
			d_src_mod_dept_flag				[2],
   			d_dept_code						[7],
			d_drfee_flag					[2],
			d_dir_ent_flag					[2],
			d_src_mod_rate_flag				[2],
			d_rate_chg_flag					[2],
			d_def_bill_type_code			[3],
			d_serv_locn_code				[5],
			d_serv_anal_grp1				[7],
			d_serv_anal_grp2				[7],
			d_price_rev_date				[11],
			d_added_by_id					[21],
			d_modified_by_id				[21],
			d_added_date					[11],
			d_modified_date					[11],
			d_status						[2],
			d_phys_cat_code					[14],
			d_misc_serv						[2],
			d_nurse_serv					[2],
			d_trx_date_time					[20],
			d_trx_user_id					[21],
			d_trx_type						[14],
			d_trx_remarks					[31],
			d_prt_grp_desc					[16],
			d_curs							[3000]; */ 
struct { unsigned short len; unsigned char arr[11]; } d_blng_serv_code;

struct { unsigned short len; unsigned char arr[41]; } d_long_desc;

struct { unsigned short len; unsigned char arr[15]; } d_short_desc;

struct { unsigned short len; unsigned char arr[31]; } d_loc_lang_long_desc;

struct { unsigned short len; unsigned char arr[17]; } d_loc_lang_short_desc;

struct { unsigned short len; unsigned char arr[3]; } d_serv_grp_code;

struct { unsigned short len; unsigned char arr[4]; } d_serv_clasfn_code;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[2]; } d_src_mod_dept_flag;

struct { unsigned short len; unsigned char arr[7]; } d_dept_code;

struct { unsigned short len; unsigned char arr[2]; } d_drfee_flag;

struct { unsigned short len; unsigned char arr[2]; } d_dir_ent_flag;

struct { unsigned short len; unsigned char arr[2]; } d_src_mod_rate_flag;

struct { unsigned short len; unsigned char arr[2]; } d_rate_chg_flag;

struct { unsigned short len; unsigned char arr[3]; } d_def_bill_type_code;

struct { unsigned short len; unsigned char arr[5]; } d_serv_locn_code;

struct { unsigned short len; unsigned char arr[7]; } d_serv_anal_grp1;

struct { unsigned short len; unsigned char arr[7]; } d_serv_anal_grp2;

struct { unsigned short len; unsigned char arr[11]; } d_price_rev_date;

struct { unsigned short len; unsigned char arr[21]; } d_added_by_id;

struct { unsigned short len; unsigned char arr[21]; } d_modified_by_id;

struct { unsigned short len; unsigned char arr[11]; } d_added_date;

struct { unsigned short len; unsigned char arr[11]; } d_modified_date;

struct { unsigned short len; unsigned char arr[2]; } d_status;

struct { unsigned short len; unsigned char arr[14]; } d_phys_cat_code;

struct { unsigned short len; unsigned char arr[2]; } d_misc_serv;

struct { unsigned short len; unsigned char arr[2]; } d_nurse_serv;

struct { unsigned short len; unsigned char arr[20]; } d_trx_date_time;

struct { unsigned short len; unsigned char arr[21]; } d_trx_user_id;

struct { unsigned short len; unsigned char arr[14]; } d_trx_type;

struct { unsigned short len; unsigned char arr[31]; } d_trx_remarks;

struct { unsigned short len; unsigned char arr[16]; } d_prt_grp_desc;

struct { unsigned short len; unsigned char arr[3000]; } d_curs;



    double  d_ip_rate,
			d_op_rate,
			d_rf_rate,
			d_min_chg_amt,
			d_base_qty,
			d_serv_old_ip_rate,
			d_serv_old_op_rate,
			d_serv_old_rf_rate,
			d_old_min_chg_amt,
			d_def_chg;

	char	filename						[150];
    char	string_var						[150];
	char	l_mesg							[150];

	int cnt,rec_cnt,brk,g_hdr_cnt;

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

FILE *f1;

int		page_no,
		lno,
		g_hdr_cnt;
	
void proc_main(argc,argv)
int argc;
char *argv[];
{
    if(argc < 5) 
	{
		disp_message(ERR_MESG,"Usage BLRSRVAU userid/password session_id pgm_date facility_id \n");
		proc_exit();
    }

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

    strcpy(g_pgm_id,"BLRSRVAU");
    strcpy(g_pgm_date,argv[3]);

    /* EXEC SQL CONNECT :uid_pwd; */ 

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
    sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )43;
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



	set_meduser_role();

    if(OERROR) 
	{
		disp_message(ORA_MESG,"Unable to connect to oracle.\n");
		proc_exit();
    }

    start_prog_msg();

    trx_date_fm.arr [0]			        = '\0';
    trx_date_to.arr [0]		            = '\0';
    trx_blsrv_fm.arr[0]				    = '\0';
	trx_blsrv_to.arr[0]				    = '\0';
    trx_usrid_fm.arr[0]				    = '\0';    
    trx_usrid_to.arr[0]				    = '\0';    
	trx_report_opt.arr[0]				= '\0';
	trx_report_ord.arr[0]				= '\0';
	
	trx_date_fm.len						= 0;
    trx_date_to.len						= 0;
    trx_blsrv_fm.len			        = 0;
	trx_blsrv_to.len			        = 0;
    trx_usrid_fm.len			        = 0;
    trx_usrid_to.len			        = 0;
	trx_report_opt.len					= 0;
	trx_report_ord.len					= 0;

	//sprintf(l_mesg,"Session Id %s   Pgm Date  %s  ",d_session_id.arr,d_pgm_date.arr);
	//disp_message(ERR_MESG,l_mesg);

	/* EXEC SQL SELECT PARAM1,
					PARAM2, 
					PARAM3, 
					PARAM4, 
					PARAM5, 
					PARAM6, 
					PARAM7,
					PARAM8,
					operating_facility_id
		 INTO	   :trx_date_fm,
				   :trx_date_to,
				   :trx_blsrv_fm,
				   :trx_blsrv_to,
				   :trx_usrid_fm,
				   :trx_usrid_to,
				   :trx_report_ord,
				   :trx_report_opt,
				   :d_facility_id
		 FROM   SY_PROG_PARAM
		 WHERE  PGM_ID     = 'BLRSRVAU'
		 AND    PGM_DATE   = :d_pgm_date
		 AND    SESSION_ID = :d_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PARAM\
7 ,PARAM8 ,operating_facility_id into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  fro\
m SY_PROG_PARAM where ((PGM_ID='BLRSRVAU' and PGM_DATE=:b9) and SESSION_ID=:b1\
0)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&trx_date_fm;
 sqlstm.sqhstl[0] = (unsigned int  )19;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&trx_date_to;
 sqlstm.sqhstl[1] = (unsigned int  )19;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&trx_blsrv_fm;
 sqlstm.sqhstl[2] = (unsigned int  )13;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&trx_blsrv_to;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&trx_usrid_fm;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&trx_usrid_to;
 sqlstm.sqhstl[5] = (unsigned int  )23;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&trx_report_ord;
 sqlstm.sqhstl[6] = (unsigned int  )4;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&trx_report_opt;
 sqlstm.sqhstl[7] = (unsigned int  )4;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[8] = (unsigned int  )12;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[9] = (unsigned int  )16;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_session_id;
 sqlstm.sqhstl[10] = (unsigned int  )18;
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



    if(OERROR || NO_DATA_FOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");

    trx_date_fm.arr[trx_date_fm.len]				= '\0';
	trx_date_to.arr[trx_date_to.len]				= '\0';
	trx_blsrv_fm.arr[trx_blsrv_fm.len]				= '\0';
	trx_blsrv_to.arr[trx_blsrv_to.len]				= '\0';
	trx_usrid_fm.arr[trx_usrid_fm.len]				= '\0';
	trx_usrid_to.arr[trx_usrid_to.len]				= '\0';
	trx_report_ord.arr[trx_report_ord.len]			= '\0';
	trx_report_opt.arr[trx_report_opt.len]			= '\0';
	
	d_facility_id.arr[d_facility_id.len]			= '\0';
	strcpy(g_facility_id, d_facility_id.arr);

   
    strcpy(filename,WORKING_DIR);
    strcat(filename,"blrsrvau.lis");

    if( (f1=fopen(filename,"w")) == NULL) 
	{
		disp_message(ERR_MESG,"Error in opening output file...\n");
		proc_exit();
    }


	//sprintf(l_mesg,"Facility id    %s ",d_facility_id.arr);
	//disp_message(ERR_MESG,l_mesg);


    /* EXEC SQL SELECT ACC_ENTITY_NAME,
					TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
					USER 
	     INTO		:comp_name,
					:rep_date,
					:oper_id
	     FROM		SY_ACC_ENTITY
		WHERE		acc_entity_id = :d_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )95;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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
    sqlstm.sqhstv[3] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )12;
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
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr [rep_date.len]  = '\0';
    oper_id.arr  [oper_id.len]	 = '\0';

	//sprintf(l_mesg,"Co Name %s  Rep Date %s  Oper Id %s ",comp_name.arr,rep_date.arr,oper_id.arr);
	//disp_message(ERR_MESG,l_mesg);

    page_no=1;
    lno=1;

    decl_curs();
    put_inp_parm();
    do_report();

    fclose(f1);
    del_parm();
    end_prog_msg();
    /* EXEC SQL COMMIT RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )126;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    return;
}

del_parm()
{
    /* EXEC SQL DELETE SY_PROG_PARAM
	 WHERE  PGM_ID     = 'BLRSRVAU' 
	 AND    PGM_DATE   = :d_pgm_date
	 AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRSRVAU' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )141;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
    sqlstm.sqhstl[0] = (unsigned int  )16;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_session_id;
    sqlstm.sqhstl[1] = (unsigned int  )18;
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
	err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 
}


decl_curs()
{

strcpy(d_curs.arr,"SELECT  BLNG_SERV_CODE,LONG_DESC,SHORT_DESC, \
LOC_LANG_LONG_DESC, \
LOC_LANG_SHORT_DESC, \
SERV_GRP_CODE, \
SERV_CLASSIFICATION_CODE, \
PRT_GRP_HDR_CODE, \
PRT_GRP_LINE_CODE, \
SOURCE_MODULE_DEPT_FLAG,\
DEPT_CODE, \
DR_FEE_FLAG,DIR_ENTRY_FLAG,	SOURCE_MODULE_RATE_FLAG, \
RATE_ENTRY_BY_USER_FLAG,DEF_CHARGE,	DEF_REF_BILL_TYPE_CODE,	IP_RATE, \
OP_RATE,REF_RATE,MIN_CHARGE_AMT,BASE_QTY,SERV_LOCN_CODE, \
SERV_ANAL_GRP1,	SERV_ANAL_GRP2,	OLD_IP_RATE,OLD_OP_RATE, \
OLD_REF_RATE,OLD_MIN_CHARGE_AMT,PRICE_REVISED_DATE,	ADDED_BY_ID, \
MODIFIED_BY_ID,	TO_CHAR(ADDED_DATE,'DD/MM/YYYY'), \
TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY'),STATUS, \
DECODE(PHYS_CAT_CODE,'A','ASSOCIATE','R','RESIDENT'), \
MISC_SERV_YN,NURSING_SERV_YN, \
TO_CHAR(TRX_DATE_TIME,'DD/MM/YYYY HH24:MI:SS'),	TRX_USER_ID, \
DECODE(TRX_TYPE,'C','CREATED','M','MODIFIED'),	TRX_REMARKS \
FROM		BL_BLNG_SERV_AUDIT_DTLS \
WHERE		BLNG_SERV_CODE BETWEEN :trx_blsrv_fm and :trx_blsrv_to AND \
TRX_DATE_TIME  BETWEEN TO_DATE(:trx_date_fm,'DD/MM/YYYY HH24:MI') and \
TO_DATE(:trx_date_to,'DD/MM/YYYY HH24:MI') AND \
TRX_USER_ID    BETWEEN :trx_usrid_fm and  :trx_usrid_to ");

if ((trx_report_opt.arr[0] == 'C') || (trx_report_opt.arr[0] == 'M'))
	strcat (d_curs.arr," AND TRX_TYPE  = :trx_report_opt ");

if (trx_report_ord.arr[0] == 'S')
	strcat(d_curs.arr," ORDER BY BLNG_SERV_CODE ");
else
	strcat(d_curs.arr," ORDER BY TRX_DATE_TIME ");

d_curs.len = strlen(d_curs.arr);

/* EXEC SQL PREPARE TRANS_LIST FROM :d_curs; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )164;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_curs;
sqlstm.sqhstl[0] = (unsigned int  )3002;
sqlstm.sqhsts[0] = (         int  )0;
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



if(OERROR)
	err_mesg("PREPARE failed on TRANS_LIST",0,"");

/* EXEC SQL DECLARE TRANS_LIST_CUR CURSOR FOR TRANS_LIST; */ 


if(OERROR)
	err_mesg("DECLARE failed on TRANS_LIST_CUR",0,"");


/* EXEC SQL DECLARE BL_PRT_GRP_DESC_CUR CURSOR FOR
			   SELECT   SHORT_DESC   
			   FROM     BL_BLNG_PRT_GRP_LINE
			   WHERE    PRT_GRP_HDR_CODE = :d_prt_grp_hdr_code AND
			            PRT_GRP_LINE_CODE = :d_prt_grp_line_code; */ 


if ((trx_report_opt.arr[0] == 'C') || (trx_report_opt.arr[0] == 'M'))
{

/* EXEC SQL OPEN TRANS_LIST_CUR USING
                 :trx_blsrv_fm,
				 :trx_blsrv_to,
	             :trx_date_fm,
                 :trx_date_to,
                 :trx_usrid_fm,
                 :trx_usrid_to,
                 :trx_report_opt; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )183;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqcmod = (unsigned int )0;
sqlstm.sqhstv[0] = (         void  *)&trx_blsrv_fm;
sqlstm.sqhstl[0] = (unsigned int  )13;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&trx_blsrv_to;
sqlstm.sqhstl[1] = (unsigned int  )13;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&trx_date_fm;
sqlstm.sqhstl[2] = (unsigned int  )19;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&trx_date_to;
sqlstm.sqhstl[3] = (unsigned int  )19;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&trx_usrid_fm;
sqlstm.sqhstl[4] = (unsigned int  )23;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&trx_usrid_to;
sqlstm.sqhstl[5] = (unsigned int  )23;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&trx_report_opt;
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


}
else
{
/* EXEC SQL OPEN TRANS_LIST_CUR USING
                 :trx_blsrv_fm,
				 :trx_blsrv_to,
	             :trx_date_fm,
                 :trx_date_to,
                 :trx_usrid_fm,
                 :trx_usrid_to; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )226;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqcmod = (unsigned int )0;
sqlstm.sqhstv[0] = (         void  *)&trx_blsrv_fm;
sqlstm.sqhstl[0] = (unsigned int  )13;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&trx_blsrv_to;
sqlstm.sqhstl[1] = (unsigned int  )13;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&trx_date_fm;
sqlstm.sqhstl[2] = (unsigned int  )19;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&trx_date_to;
sqlstm.sqhstl[3] = (unsigned int  )19;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&trx_usrid_fm;
sqlstm.sqhstl[4] = (unsigned int  )23;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&trx_usrid_to;
sqlstm.sqhstl[5] = (unsigned int  )23;
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


}

if(OERROR)
	err_mesg("OPEN failed on cursor TRANS_LIST_CUR",0,"");

}


do_report()
{
    
    char s_amt[20];
    lno = 0;
	g_hdr_cnt = 0;
	cnt = 0;
	rec_cnt = 0;
		
    while(fetch_bl_blng_audit()) 
	{
		if (!g_hdr_cnt)
		{
			put_hdr();
			g_hdr_cnt = 1;
		}
		cnt = 1;
		fetch_prt_grp_desc();		
		put_rec();
/*-- Record counter is added to display the No of records picked after
     report execution VSK 02/05/1999 */
		rec_cnt++;
		chk_break(1);
	}
	print_end_of_rep();
}


fetch_prt_grp_desc()
{

    /* EXEC SQL OPEN BL_PRT_GRP_DESC_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )265;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_hdr_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prt_grp_line_code;
    sqlstm.sqhstl[1] = (unsigned int  )5;
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
	err_mesg("OPEN failed on cursor BL_PRT_GRP_DESC_CUR",0,"");

    d_prt_grp_desc.arr[0]  = '\0';
    d_prt_grp_desc.len     = 0;

    /* EXEC SQL FETCH BL_PRT_GRP_DESC_CUR
	     INTO  :d_prt_grp_desc ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )288;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_desc;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor BL_PRT_GRP_DESC_CUR",0,"");

    d_prt_grp_desc.arr[d_prt_grp_desc.len]  = '\0';


}


fetch_bl_blng_audit()
{
	d_blng_serv_code.arr[0]				=	'\0';
    d_long_desc.arr[0]					=	'\0';
	d_short_desc.arr[0]					=	'\0';
	d_loc_lang_long_desc.arr[0]			=	'\0';
	d_loc_lang_short_desc.arr[0]		=	'\0';
	d_serv_grp_code.arr[0]				=	'\0';
   	d_serv_clasfn_code.arr[0]			=	'\0';
	d_prt_grp_hdr_code.arr[0]			=	'\0';
   	d_prt_grp_line_code.arr[0]			=	'\0';
	d_src_mod_dept_flag.arr[0]			=	'\0';
   	d_dept_code.arr[0]					=	'\0';
	d_drfee_flag.arr[0]					=	'\0';
	d_dir_ent_flag.arr[0]				=	'\0';
	d_src_mod_rate_flag.arr[0]			=	'\0';
	d_rate_chg_flag.arr[0]				=	'\0';
	d_def_bill_type_code.arr[0]			=	'\0';
	d_serv_locn_code.arr[0]				=	'\0';
	d_serv_anal_grp1.arr[0]				=	'\0';
	d_serv_anal_grp2.arr[0]				=	'\0';
	d_price_rev_date.arr[0]				=	'\0';
	d_added_by_id.arr[0]				=	'\0';
	d_modified_by_id.arr[0]				=	'\0';
	d_added_date.arr[0]					=	'\0';
	d_modified_date.arr[0]				=	'\0';
	d_status.arr[0]						=	'\0';
	d_phys_cat_code.arr[0]				=	'\0';
	d_misc_serv.arr[0]					=	'\0';
	d_nurse_serv.arr[0]					=	'\0';
	d_trx_date_time.arr[0]				=	'\0';
	d_trx_user_id.arr[0]				=	'\0';
	d_trx_type.arr[0]					=	'\0';
	d_trx_remarks.arr[0]				=	'\0';

	d_blng_serv_code.len				=	0;
    d_long_desc.len						=	0;
	d_short_desc.len					=	0;
	d_loc_lang_long_desc.len			=	0;
	d_loc_lang_short_desc.len			=	0;
	d_serv_grp_code.len					=	0;
   	d_serv_clasfn_code.len				=	0;
	d_prt_grp_hdr_code.len				=	0;
   	d_prt_grp_line_code.len				=	0;
	d_src_mod_dept_flag.len				=	0;
   	d_dept_code.len						=	0;
	d_drfee_flag.len					=	0;
	d_dir_ent_flag.len					=	0;
	d_src_mod_rate_flag.len				=	0;
	d_rate_chg_flag.len					=	0;
	d_def_bill_type_code.len			=	0;
	d_serv_locn_code.len				=	0;
	d_serv_anal_grp1.len				=	0;
	d_serv_anal_grp2.len				=	0;
	d_price_rev_date.len				=	0;
	d_added_by_id.len					=	0;
	d_modified_by_id.len				=	0;
	d_added_date.len					=	0;
	d_modified_date.len					=	0;
	d_status.len						=	0;
	d_phys_cat_code.len					=	0;
	d_misc_serv.len						=	0;
	d_nurse_serv.len					=	0;
	d_trx_date_time.len					=	0;
	d_trx_user_id.len					=	0;
	d_trx_type.len						=	0;
	d_trx_remarks.len					=	0;

    d_ip_rate							=	0;
	d_op_rate							=	0;
	d_rf_rate							=	0;
	d_min_chg_amt						=	0;
	d_base_qty							=	0;
    d_serv_old_ip_rate					=	0;
	d_serv_old_op_rate					=	0;
	d_serv_old_rf_rate					=	0;
	d_old_min_chg_amt					=	0;
	d_def_chg							=	0;


         /* EXEC SQL FETCH TRANS_LIST_CUR
	          INTO  :d_blng_serv_code,
					:d_long_desc,
					:d_short_desc,
					:d_loc_lang_long_desc,
					:d_loc_lang_short_desc,
					:d_serv_grp_code,
					:d_serv_clasfn_code,
					:d_prt_grp_hdr_code,
					:d_prt_grp_line_code,
					:d_src_mod_dept_flag,
					:d_dept_code,
					:d_drfee_flag,
					:d_dir_ent_flag,
					:d_src_mod_rate_flag,
					:d_rate_chg_flag,
					:d_def_chg,
					:d_def_bill_type_code,   
					:d_ip_rate,
					:d_op_rate,
					:d_rf_rate,
					:d_min_chg_amt,
					:d_base_qty,
					:d_serv_locn_code,
					:d_serv_anal_grp1,
					:d_serv_anal_grp2,
					:d_serv_old_ip_rate,
					:d_serv_old_op_rate,
					:d_serv_old_rf_rate,
					:d_old_min_chg_amt,
					:d_price_rev_date,
					:d_added_by_id,
					:d_modified_by_id,
					:d_added_date,
					:d_modified_date,
					:d_status,
					:d_phys_cat_code,
					:d_misc_serv,
					:d_nurse_serv,
					:d_trx_date_time,
					:d_trx_user_id,
					:d_trx_type,
					:d_trx_remarks; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 12;
         sqlstm.arrsiz = 42;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )307;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)4352;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqfoff = (           int )0;
         sqlstm.sqfmod = (unsigned int )2;
         sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_code;
         sqlstm.sqhstl[0] = (unsigned int  )13;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&d_long_desc;
         sqlstm.sqhstl[1] = (unsigned int  )43;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&d_short_desc;
         sqlstm.sqhstl[2] = (unsigned int  )17;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&d_loc_lang_long_desc;
         sqlstm.sqhstl[3] = (unsigned int  )33;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&d_loc_lang_short_desc;
         sqlstm.sqhstl[4] = (unsigned int  )19;
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&d_serv_grp_code;
         sqlstm.sqhstl[5] = (unsigned int  )5;
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&d_serv_clasfn_code;
         sqlstm.sqhstl[6] = (unsigned int  )6;
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&d_prt_grp_hdr_code;
         sqlstm.sqhstl[7] = (unsigned int  )5;
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&d_prt_grp_line_code;
         sqlstm.sqhstl[8] = (unsigned int  )5;
         sqlstm.sqhsts[8] = (         int  )0;
         sqlstm.sqindv[8] = (         void  *)0;
         sqlstm.sqinds[8] = (         int  )0;
         sqlstm.sqharm[8] = (unsigned int  )0;
         sqlstm.sqadto[8] = (unsigned short )0;
         sqlstm.sqtdso[8] = (unsigned short )0;
         sqlstm.sqhstv[9] = (         void  *)&d_src_mod_dept_flag;
         sqlstm.sqhstl[9] = (unsigned int  )4;
         sqlstm.sqhsts[9] = (         int  )0;
         sqlstm.sqindv[9] = (         void  *)0;
         sqlstm.sqinds[9] = (         int  )0;
         sqlstm.sqharm[9] = (unsigned int  )0;
         sqlstm.sqadto[9] = (unsigned short )0;
         sqlstm.sqtdso[9] = (unsigned short )0;
         sqlstm.sqhstv[10] = (         void  *)&d_dept_code;
         sqlstm.sqhstl[10] = (unsigned int  )9;
         sqlstm.sqhsts[10] = (         int  )0;
         sqlstm.sqindv[10] = (         void  *)0;
         sqlstm.sqinds[10] = (         int  )0;
         sqlstm.sqharm[10] = (unsigned int  )0;
         sqlstm.sqadto[10] = (unsigned short )0;
         sqlstm.sqtdso[10] = (unsigned short )0;
         sqlstm.sqhstv[11] = (         void  *)&d_drfee_flag;
         sqlstm.sqhstl[11] = (unsigned int  )4;
         sqlstm.sqhsts[11] = (         int  )0;
         sqlstm.sqindv[11] = (         void  *)0;
         sqlstm.sqinds[11] = (         int  )0;
         sqlstm.sqharm[11] = (unsigned int  )0;
         sqlstm.sqadto[11] = (unsigned short )0;
         sqlstm.sqtdso[11] = (unsigned short )0;
         sqlstm.sqhstv[12] = (         void  *)&d_dir_ent_flag;
         sqlstm.sqhstl[12] = (unsigned int  )4;
         sqlstm.sqhsts[12] = (         int  )0;
         sqlstm.sqindv[12] = (         void  *)0;
         sqlstm.sqinds[12] = (         int  )0;
         sqlstm.sqharm[12] = (unsigned int  )0;
         sqlstm.sqadto[12] = (unsigned short )0;
         sqlstm.sqtdso[12] = (unsigned short )0;
         sqlstm.sqhstv[13] = (         void  *)&d_src_mod_rate_flag;
         sqlstm.sqhstl[13] = (unsigned int  )4;
         sqlstm.sqhsts[13] = (         int  )0;
         sqlstm.sqindv[13] = (         void  *)0;
         sqlstm.sqinds[13] = (         int  )0;
         sqlstm.sqharm[13] = (unsigned int  )0;
         sqlstm.sqadto[13] = (unsigned short )0;
         sqlstm.sqtdso[13] = (unsigned short )0;
         sqlstm.sqhstv[14] = (         void  *)&d_rate_chg_flag;
         sqlstm.sqhstl[14] = (unsigned int  )4;
         sqlstm.sqhsts[14] = (         int  )0;
         sqlstm.sqindv[14] = (         void  *)0;
         sqlstm.sqinds[14] = (         int  )0;
         sqlstm.sqharm[14] = (unsigned int  )0;
         sqlstm.sqadto[14] = (unsigned short )0;
         sqlstm.sqtdso[14] = (unsigned short )0;
         sqlstm.sqhstv[15] = (         void  *)&d_def_chg;
         sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[15] = (         int  )0;
         sqlstm.sqindv[15] = (         void  *)0;
         sqlstm.sqinds[15] = (         int  )0;
         sqlstm.sqharm[15] = (unsigned int  )0;
         sqlstm.sqadto[15] = (unsigned short )0;
         sqlstm.sqtdso[15] = (unsigned short )0;
         sqlstm.sqhstv[16] = (         void  *)&d_def_bill_type_code;
         sqlstm.sqhstl[16] = (unsigned int  )5;
         sqlstm.sqhsts[16] = (         int  )0;
         sqlstm.sqindv[16] = (         void  *)0;
         sqlstm.sqinds[16] = (         int  )0;
         sqlstm.sqharm[16] = (unsigned int  )0;
         sqlstm.sqadto[16] = (unsigned short )0;
         sqlstm.sqtdso[16] = (unsigned short )0;
         sqlstm.sqhstv[17] = (         void  *)&d_ip_rate;
         sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[17] = (         int  )0;
         sqlstm.sqindv[17] = (         void  *)0;
         sqlstm.sqinds[17] = (         int  )0;
         sqlstm.sqharm[17] = (unsigned int  )0;
         sqlstm.sqadto[17] = (unsigned short )0;
         sqlstm.sqtdso[17] = (unsigned short )0;
         sqlstm.sqhstv[18] = (         void  *)&d_op_rate;
         sqlstm.sqhstl[18] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[18] = (         int  )0;
         sqlstm.sqindv[18] = (         void  *)0;
         sqlstm.sqinds[18] = (         int  )0;
         sqlstm.sqharm[18] = (unsigned int  )0;
         sqlstm.sqadto[18] = (unsigned short )0;
         sqlstm.sqtdso[18] = (unsigned short )0;
         sqlstm.sqhstv[19] = (         void  *)&d_rf_rate;
         sqlstm.sqhstl[19] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[19] = (         int  )0;
         sqlstm.sqindv[19] = (         void  *)0;
         sqlstm.sqinds[19] = (         int  )0;
         sqlstm.sqharm[19] = (unsigned int  )0;
         sqlstm.sqadto[19] = (unsigned short )0;
         sqlstm.sqtdso[19] = (unsigned short )0;
         sqlstm.sqhstv[20] = (         void  *)&d_min_chg_amt;
         sqlstm.sqhstl[20] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[20] = (         int  )0;
         sqlstm.sqindv[20] = (         void  *)0;
         sqlstm.sqinds[20] = (         int  )0;
         sqlstm.sqharm[20] = (unsigned int  )0;
         sqlstm.sqadto[20] = (unsigned short )0;
         sqlstm.sqtdso[20] = (unsigned short )0;
         sqlstm.sqhstv[21] = (         void  *)&d_base_qty;
         sqlstm.sqhstl[21] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[21] = (         int  )0;
         sqlstm.sqindv[21] = (         void  *)0;
         sqlstm.sqinds[21] = (         int  )0;
         sqlstm.sqharm[21] = (unsigned int  )0;
         sqlstm.sqadto[21] = (unsigned short )0;
         sqlstm.sqtdso[21] = (unsigned short )0;
         sqlstm.sqhstv[22] = (         void  *)&d_serv_locn_code;
         sqlstm.sqhstl[22] = (unsigned int  )7;
         sqlstm.sqhsts[22] = (         int  )0;
         sqlstm.sqindv[22] = (         void  *)0;
         sqlstm.sqinds[22] = (         int  )0;
         sqlstm.sqharm[22] = (unsigned int  )0;
         sqlstm.sqadto[22] = (unsigned short )0;
         sqlstm.sqtdso[22] = (unsigned short )0;
         sqlstm.sqhstv[23] = (         void  *)&d_serv_anal_grp1;
         sqlstm.sqhstl[23] = (unsigned int  )9;
         sqlstm.sqhsts[23] = (         int  )0;
         sqlstm.sqindv[23] = (         void  *)0;
         sqlstm.sqinds[23] = (         int  )0;
         sqlstm.sqharm[23] = (unsigned int  )0;
         sqlstm.sqadto[23] = (unsigned short )0;
         sqlstm.sqtdso[23] = (unsigned short )0;
         sqlstm.sqhstv[24] = (         void  *)&d_serv_anal_grp2;
         sqlstm.sqhstl[24] = (unsigned int  )9;
         sqlstm.sqhsts[24] = (         int  )0;
         sqlstm.sqindv[24] = (         void  *)0;
         sqlstm.sqinds[24] = (         int  )0;
         sqlstm.sqharm[24] = (unsigned int  )0;
         sqlstm.sqadto[24] = (unsigned short )0;
         sqlstm.sqtdso[24] = (unsigned short )0;
         sqlstm.sqhstv[25] = (         void  *)&d_serv_old_ip_rate;
         sqlstm.sqhstl[25] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[25] = (         int  )0;
         sqlstm.sqindv[25] = (         void  *)0;
         sqlstm.sqinds[25] = (         int  )0;
         sqlstm.sqharm[25] = (unsigned int  )0;
         sqlstm.sqadto[25] = (unsigned short )0;
         sqlstm.sqtdso[25] = (unsigned short )0;
         sqlstm.sqhstv[26] = (         void  *)&d_serv_old_op_rate;
         sqlstm.sqhstl[26] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[26] = (         int  )0;
         sqlstm.sqindv[26] = (         void  *)0;
         sqlstm.sqinds[26] = (         int  )0;
         sqlstm.sqharm[26] = (unsigned int  )0;
         sqlstm.sqadto[26] = (unsigned short )0;
         sqlstm.sqtdso[26] = (unsigned short )0;
         sqlstm.sqhstv[27] = (         void  *)&d_serv_old_rf_rate;
         sqlstm.sqhstl[27] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[27] = (         int  )0;
         sqlstm.sqindv[27] = (         void  *)0;
         sqlstm.sqinds[27] = (         int  )0;
         sqlstm.sqharm[27] = (unsigned int  )0;
         sqlstm.sqadto[27] = (unsigned short )0;
         sqlstm.sqtdso[27] = (unsigned short )0;
         sqlstm.sqhstv[28] = (         void  *)&d_old_min_chg_amt;
         sqlstm.sqhstl[28] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[28] = (         int  )0;
         sqlstm.sqindv[28] = (         void  *)0;
         sqlstm.sqinds[28] = (         int  )0;
         sqlstm.sqharm[28] = (unsigned int  )0;
         sqlstm.sqadto[28] = (unsigned short )0;
         sqlstm.sqtdso[28] = (unsigned short )0;
         sqlstm.sqhstv[29] = (         void  *)&d_price_rev_date;
         sqlstm.sqhstl[29] = (unsigned int  )13;
         sqlstm.sqhsts[29] = (         int  )0;
         sqlstm.sqindv[29] = (         void  *)0;
         sqlstm.sqinds[29] = (         int  )0;
         sqlstm.sqharm[29] = (unsigned int  )0;
         sqlstm.sqadto[29] = (unsigned short )0;
         sqlstm.sqtdso[29] = (unsigned short )0;
         sqlstm.sqhstv[30] = (         void  *)&d_added_by_id;
         sqlstm.sqhstl[30] = (unsigned int  )23;
         sqlstm.sqhsts[30] = (         int  )0;
         sqlstm.sqindv[30] = (         void  *)0;
         sqlstm.sqinds[30] = (         int  )0;
         sqlstm.sqharm[30] = (unsigned int  )0;
         sqlstm.sqadto[30] = (unsigned short )0;
         sqlstm.sqtdso[30] = (unsigned short )0;
         sqlstm.sqhstv[31] = (         void  *)&d_modified_by_id;
         sqlstm.sqhstl[31] = (unsigned int  )23;
         sqlstm.sqhsts[31] = (         int  )0;
         sqlstm.sqindv[31] = (         void  *)0;
         sqlstm.sqinds[31] = (         int  )0;
         sqlstm.sqharm[31] = (unsigned int  )0;
         sqlstm.sqadto[31] = (unsigned short )0;
         sqlstm.sqtdso[31] = (unsigned short )0;
         sqlstm.sqhstv[32] = (         void  *)&d_added_date;
         sqlstm.sqhstl[32] = (unsigned int  )13;
         sqlstm.sqhsts[32] = (         int  )0;
         sqlstm.sqindv[32] = (         void  *)0;
         sqlstm.sqinds[32] = (         int  )0;
         sqlstm.sqharm[32] = (unsigned int  )0;
         sqlstm.sqadto[32] = (unsigned short )0;
         sqlstm.sqtdso[32] = (unsigned short )0;
         sqlstm.sqhstv[33] = (         void  *)&d_modified_date;
         sqlstm.sqhstl[33] = (unsigned int  )13;
         sqlstm.sqhsts[33] = (         int  )0;
         sqlstm.sqindv[33] = (         void  *)0;
         sqlstm.sqinds[33] = (         int  )0;
         sqlstm.sqharm[33] = (unsigned int  )0;
         sqlstm.sqadto[33] = (unsigned short )0;
         sqlstm.sqtdso[33] = (unsigned short )0;
         sqlstm.sqhstv[34] = (         void  *)&d_status;
         sqlstm.sqhstl[34] = (unsigned int  )4;
         sqlstm.sqhsts[34] = (         int  )0;
         sqlstm.sqindv[34] = (         void  *)0;
         sqlstm.sqinds[34] = (         int  )0;
         sqlstm.sqharm[34] = (unsigned int  )0;
         sqlstm.sqadto[34] = (unsigned short )0;
         sqlstm.sqtdso[34] = (unsigned short )0;
         sqlstm.sqhstv[35] = (         void  *)&d_phys_cat_code;
         sqlstm.sqhstl[35] = (unsigned int  )16;
         sqlstm.sqhsts[35] = (         int  )0;
         sqlstm.sqindv[35] = (         void  *)0;
         sqlstm.sqinds[35] = (         int  )0;
         sqlstm.sqharm[35] = (unsigned int  )0;
         sqlstm.sqadto[35] = (unsigned short )0;
         sqlstm.sqtdso[35] = (unsigned short )0;
         sqlstm.sqhstv[36] = (         void  *)&d_misc_serv;
         sqlstm.sqhstl[36] = (unsigned int  )4;
         sqlstm.sqhsts[36] = (         int  )0;
         sqlstm.sqindv[36] = (         void  *)0;
         sqlstm.sqinds[36] = (         int  )0;
         sqlstm.sqharm[36] = (unsigned int  )0;
         sqlstm.sqadto[36] = (unsigned short )0;
         sqlstm.sqtdso[36] = (unsigned short )0;
         sqlstm.sqhstv[37] = (         void  *)&d_nurse_serv;
         sqlstm.sqhstl[37] = (unsigned int  )4;
         sqlstm.sqhsts[37] = (         int  )0;
         sqlstm.sqindv[37] = (         void  *)0;
         sqlstm.sqinds[37] = (         int  )0;
         sqlstm.sqharm[37] = (unsigned int  )0;
         sqlstm.sqadto[37] = (unsigned short )0;
         sqlstm.sqtdso[37] = (unsigned short )0;
         sqlstm.sqhstv[38] = (         void  *)&d_trx_date_time;
         sqlstm.sqhstl[38] = (unsigned int  )22;
         sqlstm.sqhsts[38] = (         int  )0;
         sqlstm.sqindv[38] = (         void  *)0;
         sqlstm.sqinds[38] = (         int  )0;
         sqlstm.sqharm[38] = (unsigned int  )0;
         sqlstm.sqadto[38] = (unsigned short )0;
         sqlstm.sqtdso[38] = (unsigned short )0;
         sqlstm.sqhstv[39] = (         void  *)&d_trx_user_id;
         sqlstm.sqhstl[39] = (unsigned int  )23;
         sqlstm.sqhsts[39] = (         int  )0;
         sqlstm.sqindv[39] = (         void  *)0;
         sqlstm.sqinds[39] = (         int  )0;
         sqlstm.sqharm[39] = (unsigned int  )0;
         sqlstm.sqadto[39] = (unsigned short )0;
         sqlstm.sqtdso[39] = (unsigned short )0;
         sqlstm.sqhstv[40] = (         void  *)&d_trx_type;
         sqlstm.sqhstl[40] = (unsigned int  )16;
         sqlstm.sqhsts[40] = (         int  )0;
         sqlstm.sqindv[40] = (         void  *)0;
         sqlstm.sqinds[40] = (         int  )0;
         sqlstm.sqharm[40] = (unsigned int  )0;
         sqlstm.sqadto[40] = (unsigned short )0;
         sqlstm.sqtdso[40] = (unsigned short )0;
         sqlstm.sqhstv[41] = (         void  *)&d_trx_remarks;
         sqlstm.sqhstl[41] = (unsigned int  )33;
         sqlstm.sqhsts[41] = (         int  )0;
         sqlstm.sqindv[41] = (         void  *)0;
         sqlstm.sqinds[41] = (         int  )0;
         sqlstm.sqharm[41] = (unsigned int  )0;
         sqlstm.sqadto[41] = (unsigned short )0;
         sqlstm.sqtdso[41] = (unsigned short )0;
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
		err_mesg("FETCH failed on cursor BL_BLNG_SERV_AUDIT_CUR",0,"");

    if(NO_DATA_FOUND)
		return 0;

	d_blng_serv_code.arr[d_blng_serv_code.len]				=	'\0';
    d_long_desc.arr[d_long_desc.len]						=	'\0';
	d_short_desc.arr[d_short_desc.len]						=	'\0';
	d_loc_lang_long_desc.arr[d_loc_lang_long_desc.len]		=	'\0';
	d_loc_lang_short_desc.arr[d_loc_lang_short_desc.len]	=	'\0';
	d_serv_grp_code.arr[d_serv_grp_code.len]				=	'\0';
   	d_serv_clasfn_code.arr[d_serv_clasfn_code.len]			=	'\0';
	d_prt_grp_hdr_code.arr[d_prt_grp_hdr_code.len]			=	'\0';
   	d_prt_grp_line_code.arr[d_prt_grp_line_code.len]		=	'\0';
	d_src_mod_dept_flag.arr[d_src_mod_dept_flag.len]		=	'\0';
   	d_dept_code.arr[d_dept_code.len]						=	'\0';
	d_drfee_flag.arr[d_drfee_flag.len]						=	'\0';
	d_dir_ent_flag.arr[d_dir_ent_flag.len]					=	'\0';
	d_src_mod_rate_flag.arr[d_src_mod_rate_flag.len]		=	'\0';
	d_rate_chg_flag.arr[d_rate_chg_flag.len]				=	'\0';
	d_def_bill_type_code.arr[d_def_bill_type_code.len]		=	'\0';
	d_serv_locn_code.arr[d_serv_locn_code.len]				=	'\0';
	d_serv_anal_grp1.arr[d_serv_anal_grp1.len]				=	'\0';
	d_serv_anal_grp2.arr[d_serv_anal_grp2.len]				=	'\0';
	d_price_rev_date.arr[d_price_rev_date.len]				=	'\0';
	d_added_by_id.arr[d_added_by_id.len]					=	'\0';
	d_modified_by_id.arr[d_modified_by_id.len]				=	'\0';
	d_added_date.arr[d_added_date.len]						=	'\0';
	d_modified_date.arr[d_modified_date.len]				=	'\0';
	d_status.arr[d_status.len]								=	'\0';
	d_phys_cat_code.arr[d_phys_cat_code.len]				=	'\0';
	d_misc_serv.arr[d_misc_serv.len]						=	'\0';
	d_nurse_serv.arr[d_nurse_serv.len]						=	'\0';
	d_trx_date_time.arr[d_trx_date_time.len]				=	'\0';
	d_trx_user_id.arr[d_trx_user_id.len]					=	'\0';
	d_trx_type.arr[d_trx_type.len]							=	'\0';
	d_trx_remarks.arr[d_trx_remarks.len]					=	'\0';

    return 1;

}


put_hdr()
{
    fprintf(f1,"MDL : BL        %30s%30s%22s                %s\n"," ",comp_name.arr," ",rep_date.arr);
    fprintf(f1,"OPR : %s\n",oper_id.arr);
    fprintf(f1,"REP : BLRSRVAU                                   AUDIT TRAIL FOR BILLING SERVICE                                       PAGE : %4d\n",page_no);
    fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n");
    lno=6;

}

put_rec() 
{
    char s_amt[20];

//  First Line Details    
	fprintf(f1,"Billing Serv.  : ");
	fprintf(f1,"%-10s  %-15s",d_blng_serv_code.arr,d_short_desc.arr);
	fprintf(f1,"                        Rates             New           Old    Direct Entry     : ");
	fprintf(f1,"%s",d_dir_ent_flag.arr);
	fprintf(f1,"\n");

//  Second Line Details
	fprintf(f1,"Long Desc      : ");
	fprintf(f1,"%-40s",d_long_desc.arr);
	fprintf(f1,"          IP  : ");
	put_val(s_amt,d_ip_rate);
    format_amt(s_amt);
	fprintf(f1,"%12s",s_amt);
	fprintf(f1,"  ");
	put_val(s_amt,d_serv_old_ip_rate);
    format_amt(s_amt);
	fprintf(f1,"%12s",s_amt);
	fprintf(f1,"    Rate Fm Source   : ");
	fprintf(f1,"%s",d_src_mod_rate_flag.arr);
	fprintf(f1,"\n");

//  Third Line Details
	fprintf(f1,"Long Desc(Loc) : ");
	fprintf(f1,"%30s",d_loc_lang_long_desc.arr);
	fprintf(f1,"                    OP  : ");
	put_val(s_amt,d_op_rate);
    format_amt(s_amt);
	fprintf(f1,"%12s",s_amt);
	fprintf(f1,"  ");
	put_val(s_amt,d_serv_old_op_rate);
    format_amt(s_amt);
	fprintf(f1,"%12s",s_amt);
	fprintf(f1,"    Rate/Charge      : ");
	fprintf(f1,"%s",d_rate_chg_flag.arr);
	fprintf(f1,"\n");

//  Forth Line Details
	fprintf(f1,"Short Desc(Loc): ");
	fprintf(f1,"%16s",d_loc_lang_short_desc.arr);
	fprintf(f1,"                                  RF  : ");
	put_val(s_amt,d_rf_rate);
    format_amt(s_amt);
	fprintf(f1,"%12s",s_amt);
	fprintf(f1,"  ");
	put_val(s_amt,d_serv_old_rf_rate);
    format_amt(s_amt);
	fprintf(f1,"%12s",s_amt);
	fprintf(f1,"    Doctor Fees      : ");
	fprintf(f1,"%s",d_drfee_flag.arr);
	fprintf(f1,"\n");

//  Fifth Line Details
	fprintf(f1,"Base Qty       : ");
	put_val(s_amt,d_base_qty);
    format_amt(s_amt);
	fprintf(f1,"%-12s",s_amt);
	fprintf(f1,"     Dflt Chg: ");
	put_val(s_amt,d_def_chg);
    format_amt(s_amt);
	fprintf(f1,"%-12s",s_amt);
	fprintf(f1,"     Min.Chrg  : ");
	put_val(s_amt,d_min_chg_amt);
    format_amt(s_amt);
	fprintf(f1,"%12s",s_amt);
	fprintf(f1,"  ");
	put_val(s_amt,d_old_min_chg_amt);
    format_amt(s_amt);
	fprintf(f1,"%12s",s_amt);
	fprintf(f1,"    Misc. Service    : ");
	fprintf(f1,"%s",d_misc_serv.arr);
	fprintf(f1,"\n");

//  Sixth Line Details
	fprintf(f1,"Serv.Grp/Clasfn: ");
	fprintf(f1,"%2s/%3s",d_serv_grp_code.arr,d_serv_clasfn_code.arr);
	fprintf(f1,"   Ref Bill Type Cd: ");
	fprintf(f1,"%2s",d_def_bill_type_code.arr);
	fprintf(f1,"    Service Loc.Cd/Anal1/Anal2 : ");
	fprintf(f1,"%4s/%6s/%6s",d_serv_locn_code.arr,d_serv_anal_grp1.arr,d_serv_anal_grp2.arr);
	fprintf(f1,"      Nursing Service  : ");
	fprintf(f1,"%s",d_nurse_serv.arr);
	fprintf(f1,"\n");

//  Seventh Line Details
	fprintf(f1,"A/C Dept Fm.Src: ");
	fprintf(f1,"%s",d_src_mod_dept_flag.arr);
	fprintf(f1,"           A/C Dept Code: ");
	fprintf(f1,"%-6s",d_dept_code.arr);
	fprintf(f1,"           Print Group/Line: ");
	fprintf(f1,"%2s/%2s/%-15s",d_prt_grp_hdr_code.arr,d_prt_grp_line_code.arr,d_prt_grp_desc.arr);
	fprintf(f1,"   Status           : ");
	fprintf(f1,"%s",d_status.arr);
	fprintf(f1,"\n");

//  Eighth Line Details
	fprintf(f1,"Price Rev.Date : ");
	fprintf(f1,"%-10s",d_price_rev_date.arr);
	fprintf(f1,"  Added Id/Date: ");
	fprintf(f1,"%-20s / %-10s",d_added_by_id.arr,d_added_date.arr);
	fprintf(f1,"  Modified Id/Date : ");
	fprintf(f1,"%-20s / %-10s",d_modified_by_id.arr,d_modified_date.arr);
	fprintf(f1,"\n");

//  Nineth Line Details
	fprintf(f1,"Trx.Date.Time  : ");
	fprintf(f1,"%-20s",d_trx_date_time.arr);
	fprintf(f1," User: ");
	fprintf(f1,"%-20s",d_trx_user_id.arr);
	fprintf(f1,"           Trx. Type : ");
	fprintf(f1,"%-12s",d_trx_type.arr);
	fprintf(f1,"\n");

//  Tenth Line Details
	fprintf(f1,"Remarks        : ");
	fprintf(f1,"%-30s",d_trx_remarks.arr);
	fprintf(f1,"                          Phys.Cat.Cd : ");
	fprintf(f1,"%-12s",d_phys_cat_code.arr);
	fprintf(f1,"\n\n");

	lno +=11;

}


chk_break(nol)
int nol;
{
	if(lno+nol >= 55) 
	{
	   fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------\n");
	   fprintf(f1,"");
	   lno = 1;
	   ++page_no;
	   put_hdr();
	}
}

put_inp_parm()
{
    fprintf(f1,"MDL : BL        %30s%30s%22s                %s\n"," ",comp_name.arr," ",rep_date.arr);
    fprintf(f1,"OPR : %s\n",oper_id.arr);
    fprintf(f1,"REP : BLRSRVAU                                   AUDIT TRAIL FOR BILLING SERVICE                                       PAGE : %4d\n",page_no);
    fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n");
    fprintf(f1,"VER : 4.1\n");
    fprintf(f1,"\n\n\n\n");
    fprintf(f1,"\tINPUT PARAMETERS\n");
    fprintf(f1,"\t----------------\n\n");
	
	if (trx_blsrv_fm.arr[0] == '!') 
	    fprintf(f1,"\t\tBILLING SERVICES      FROM : LOWEST\n");
	else
		fprintf(f1,"\t\tBILLING SERVICES      FROM : %s\n",trx_blsrv_fm.arr);

	if (trx_blsrv_to.arr[0] == '~') 
		fprintf(f1,"\t\t                        TO : HIGHEST\n\n");
	else
		fprintf(f1,"\t\t                        TO : %s\n\n",trx_blsrv_to.arr);

    fprintf(f1,"\t\tTRANSACTION DATE      FROM : %s\n",trx_date_fm.arr);
    fprintf(f1,"\t\t                        TO : %s\n\n",trx_date_to.arr);

	if (trx_usrid_fm.arr[0] == '!') 
		fprintf(f1,"\t\tUSER ID               FROM : LOWEST\n");
	else
		fprintf(f1,"\t\tUSER ID               FROM : %s\n",trx_usrid_fm.arr);
    
	if (trx_usrid_to.arr[0] == '~') 
		fprintf(f1,"\t\t                        TO : HIGHEST\n\n");
	else
		fprintf(f1,"\t\t                        TO : %s\n\n",trx_usrid_to.arr);
	
	if (trx_report_ord.arr[0] == 'S')
        fprintf(f1,"\t\tREPORT ORDER               : Billing Service\n\n");
	else
	    fprintf(f1,"\t\tREPORT ORDER               : Transaction Date\n\n");
	
	if (trx_report_opt.arr[0] == 'C')
        fprintf(f1,"\t\tREPORT OPTION              : New Records    \n\n");
	else if (trx_report_opt.arr[0] == 'M')
	    fprintf(f1,"\t\tREPORT OPTION              : Modified Records\n\n");
	else
	    fprintf(f1,"\t\tREPORT OPTION              : All Records     \n\n");
    
	fprintf(f1,"");
    ++page_no;

}


print_end_of_rep()
{

/*-- No of records printed after the report VSK 02/05/1999*/

	if (cnt == 1)
	{
	 fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------\n");
	 fprintf(f1,"No of Records     :    %d\n\n",rec_cnt);
     fprintf(f1,"\n\n                                                    ** END OF REPORT **                                                             \n\f");
	}
	else
	{
	 put_hdr();
	 fprintf(f1,"No of Records     :    %d\n\n",rec_cnt);
     fprintf(f1,"\n\n                                                    ** END OF REPORT **                                                             \n\f");
	}
}


print_formated(loc_amount)
double loc_amount;
{
	char s_amt[20];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
        format_amt(s_amt);
        strcat(s_amt,"-");
    }
    else 
	{
        put_val(s_amt,loc_amount);
        format_amt(s_amt);
        strcat(s_amt," ");
    }

	fprintf(f1,"%12s \n",s_amt); 
}                                

/****************************** O  V  E  R *******************************/   