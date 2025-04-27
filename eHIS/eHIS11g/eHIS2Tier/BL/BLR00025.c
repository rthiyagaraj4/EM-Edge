
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00025.PC"
};


static unsigned int sqlctx = 1288460899;


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
            void  *sqhstv[9];
   unsigned int   sqhstl[9];
            int   sqhsts[9];
            void  *sqindv[9];
            int   sqinds[9];
   unsigned int   sqharm[9];
   unsigned int   *sqharc[9];
   unsigned short  sqadto[9];
   unsigned short  sqtdso[9];
} sqlstm = {12,9};

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

 static const char *sq0004 = 
"select a.doc_type_code ,a.doc_num ,to_char(a.admission_date,'dd/mm/yyyy') ,t\
o_char(nvl(c.discharge_date_time,sysdate),'dd/mm/yyyy') ,b.national_id_num ,a.\
patient_id ,a.bill_amt ,decode((nvl(DEPOSIT_ADJ_AMT,0)+nvl(PREPAY_ADJ_AMT,0)),\
0,0,(nvl(DEPOSIT_ADJ_AMT,0)+nvl(PREPAY_ADJ_AMT,0))) deposit_amt ,a.BILL_TOT_OU\
TST_AMT outstdg_amt  from bl_bill_dcp_dtl_vw a ,mp_patient_mast b ,BL_ENCOUNTE\
R_FOR_QRY_VW c where ((((((((a.patient_id=b.patient_id and a.episode_type=c.ep\
isode_type(+)) and a.episode_id=c.episode_id(+)) and nvl(a.visit_id,9999)=nvl(\
c.visit_id(+),9999)) and a.episode_type=decode(:b0,'A',a.episode_type,:b0)) an\
d a.patient_id between nvl(:b2,'!!!!!!!!!!!!!!!!!!!!') and nvl(:b3,'~~~~~~~~~~\
~~~~~~~~~~')) and nvl(BILL_TOT_OUTST_AMT,0)<0) and nvl(bill_status,'X')<>'C') \
and ((:b4 in ('D','B') and (nvl(deposit_adj_amt,0)+nvl(prepay_adj_amt,0))<>0) \
or (:b4 in ('O','B') and (nvl(deposit_adj_amt,0)+nvl(prepay_adj_amt,0))=0))) o\
rder by a.patient_id            ";

 static const char *sq0005 = 
"select ((((ORG_DOC_TYPE_CODE||'/')||ORG_DOC_NUM)||' ')||ORG_DOC_DATE)  from \
bl_patient_ledger where (((AD_PR_ADJ_BILL_DOC_TYPE=:b0 and AD_PR_ADJ_BILL_DOC_\
NUM=:b1) and RECPT_NATURE_CODE in ('AD','PR')) and nvl(TRX_STATUS,'X')<>'C')  \
         ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,91,0,2,156,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,165,0,0,0,0,0,1,0,
43,0,0,0,0,0,27,174,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
74,0,0,4,966,0,9,231,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
113,0,0,5,241,0,9,249,0,0,2,2,0,1,0,1,9,0,0,1,3,0,0,
136,0,0,4,0,0,13,274,0,0,9,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,4,0,0,2,4,0,0,2,4,0,0,
187,0,0,5,0,0,13,305,0,0,1,0,0,1,0,2,9,0,0,
206,0,0,6,142,0,4,332,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,
9,0,0,
245,0,0,7,57,0,4,500,0,0,1,0,0,1,0,2,9,0,0,
264,0,0,8,147,0,4,526,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
299,0,0,9,69,0,4,626,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
322,0,0,10,166,0,4,633,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,
365,0,0,11,127,0,4,679,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
404,0,0,12,96,0,4,711,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
427,0,0,13,162,0,6,718,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* PROGRAM NAME          : BLR00025.PC                                  */
/* AUTHOR                : D Ganesh Murthi                              */
/* DATE WRITTEN          : 15/02/2005                                	*/
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
#define	MAX_LINES	60
#define ESC     0x1B

#define INIT_MESG "Report Generation is in progress"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR		uid_pwd				[132],
			hosp_name			[120],
			nd_currency		[10],
			nd_refund_type[2],
			date_time			[20],
			user_id				[20],
			nd_pgm_date			[35],
			nd_facility_name	[31],
			nd_session_id		[16],
			nd_facility_id		[3]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[10]; } nd_currency;

struct { unsigned short len; unsigned char arr[2]; } nd_refund_type;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

            
/* VARCHAR		nd_lang_id			[4],
			l_pk_value			[200],  
			l_translated_value	[201]; */ 
struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[200]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;


int			l_line_no =0;
int			l_page_no =0;
int			i;    

/* VARCHAR   	d_patient_name          [61],
			d_ln1_res_add			[41],
			d_ln2_res_add			[41],
			d_ln3_res_add			[41],
			d_ln4_res_add			[41],
			d_res_postal_code		[11],
			cur_date                [11],
			d_res_country_code		[11]; */ 
struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[41]; } d_ln1_res_add;

struct { unsigned short len; unsigned char arr[41]; } d_ln2_res_add;

struct { unsigned short len; unsigned char arr[41]; } d_ln3_res_add;

struct { unsigned short len; unsigned char arr[41]; } d_ln4_res_add;

struct { unsigned short len; unsigned char arr[11]; } d_res_postal_code;

struct { unsigned short len; unsigned char arr[11]; } cur_date;

struct { unsigned short len; unsigned char arr[11]; } d_res_country_code;


/* VARCHAR		nd_episode_type			[2],
			nd_pat_from				[21],
			nd_pat_to				[21],
			l_sysdate				[20],
			l_hospital_name			[50]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[21]; } nd_pat_from;

struct { unsigned short len; unsigned char arr[21]; } nd_pat_to;

struct { unsigned short len; unsigned char arr[20]; } l_sysdate;

struct { unsigned short len; unsigned char arr[50]; } l_hospital_name;


/* VARCHAR     d_bill_doc_dtls         [31],
            d_bill_doc_type_code    [7],
			d_admission_date        [11],
			d_discharge_date_time	[21],
			d_national_id_num		[31],
			d_patient_id			[21]; */ 
struct { unsigned short len; unsigned char arr[31]; } d_bill_doc_dtls;

struct { unsigned short len; unsigned char arr[7]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[11]; } d_admission_date;

struct { unsigned short len; unsigned char arr[21]; } d_discharge_date_time;

struct { unsigned short len; unsigned char arr[31]; } d_national_id_num;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;


/* VARCHAR     d_hosp_name				[60],
			d_address1				[60],
			d_address2				[60],
			d_telnum				[21],
			d_address3				[60]; */ 
struct { unsigned short len; unsigned char arr[60]; } d_hosp_name;

struct { unsigned short len; unsigned char arr[60]; } d_address1;

struct { unsigned short len; unsigned char arr[60]; } d_address2;

struct { unsigned short len; unsigned char arr[21]; } d_telnum;

struct { unsigned short len; unsigned char arr[60]; } d_address3;

 
double		d_bill_amt,
			d_deposit_amt,
			d_outstdg_amt;
double		l_start_point;

int d_bill_doc_num;
char		loc_legend[50][201];
char		filename[200];
char		string_var[200];

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

    strcpy(nd_lang_id.arr,l_language_id.arr);
	nd_lang_id.len = l_language_id.len; 

	fetch_prog_param();
    
	declare_cursors();

	fetch_hosp_name();

	fetch_hosp_address();
    
    open_file();

	fetch_legend_value();

    print_report();  

    //end_of_rep();
   

	/* EXEC SQL DELETE SY_PROG_PARAM
            WHERE PGM_ID   = 'BLR00025'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLR00025' and SE\
SSION_ID=:b0) and PGM_DATE=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )28;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");

fclose(fp);
}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )43;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
  sqlstm.sqlcmax = (unsigned int )100;
  sqlstm.sqlcmin = (unsigned int )2;
  sqlstm.sqlcincr = (unsigned int )1;
  sqlstm.sqlctimeout = (unsigned int )0;
  sqlstm.sqlcnowait = (unsigned int )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}

declare_cursors()
{
/* EXEC SQL DECLARE MAIN_CUR CURSOR FOR 
select	a.doc_type_code,
	    a.doc_num,
		to_char(a.admission_date,'dd/mm/yyyy'), 
		to_char(nvl(c.discharge_date_time,sysdate),'dd/mm/yyyy'),
		b.national_id_num,
		a.patient_id,
		a.bill_amt, 
		decode(nvl(DEPOSIT_ADJ_AMT,0)+nvl(PREPAY_ADJ_AMT,0),0,0,nvl(DEPOSIT_ADJ_AMT,0)+nvl(PREPAY_ADJ_AMT,0)) deposit_amt,
		a.BILL_TOT_OUTST_AMT outstdg_amt
from	bl_bill_dcp_dtl_vw a, 
		mp_patient_mast b, 
		BL_ENCOUNTER_FOR_QRY_VW c
where	a.patient_id=b.patient_id
and		a.episode_type=c.episode_type(+)
and		a.episode_id=c.episode_id(+)
and		nvl(a.visit_id,9999)=nvl(c.visit_id(+),9999)
and     a.episode_type = decode(:nd_episode_type,'A',a.episode_type,:nd_episode_type)
and		a.patient_id between nvl(:nd_pat_from,'!!!!!!!!!!!!!!!!!!!!')
and		nvl(:nd_pat_to,'~~~~~~~~~~~~~~~~~~~~')	
and		nvl(BILL_TOT_OUTST_AMT,0) < 0
and nvl(bill_status,'X') != 'C'
and (
     (:nd_refund_type in ('D','B') and (nvl(deposit_adj_amt,0)+nvl(prepay_adj_amt,0)) != 0)
     or
     (:nd_refund_type in ('O','B') and (nvl(deposit_adj_amt,0)+nvl(prepay_adj_amt,0)) = 0)     
     )

order by a.patient_id; */ 
     

/*
decode(nvl(DEPOSIT_ADJ_AMT,0)+nvl(PREPAY_ADJ_AMT,0),0,'Adjustment Bill',nvl(DEPOSIT_ADJ_AMT,0)+nvl(PREPAY_ADJ_AMT,0)) deposit_amt,a.BILL_TOT_OUTST_AMT outstdg_amt

EXEC SQL DECLARE MULTIPLE_DEP CURSOR FOR
select ORG_DOC_TYPE_CODE||'/'||ORG_DOC_NUM||' '||ORG_DOC_DATE
from bl_patient_ledger
where trx_type_code in (5,6) 
and (AD_PR_ADJ_BILL_DOC_TYPE  = :d_bill_doc_type_code
AD_PR_ADJ_BILL_DOC_NUM    = :d_bill_doc_num )
or
(ALL_DOC_TYPE_CODE = :d_bill_doc_type_code
 ALL_DOC_num       = :d_bill_doc_num);
*/





/* EXEC SQL OPEN MAIN_CUR; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 6;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = sq0004;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )74;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqcmod = (unsigned int )0;
sqlstm.sqhstv[0] = (         void  *)&nd_episode_type;
sqlstm.sqhstl[0] = (unsigned int  )4;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
sqlstm.sqhstl[1] = (unsigned int  )4;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_pat_from;
sqlstm.sqhstl[2] = (unsigned int  )23;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nd_pat_to;
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
sqlstm.sqhstv[5] = (         void  *)&nd_refund_type;
sqlstm.sqhstl[5] = (unsigned int  )4;
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
	  err_mesg("OPEN failed on cursor MAIN_CUR",0,"");


}

get_multiple_dep_cur()
 {
 /* EXEC SQL DECLARE MULTIPLE_DEP CURSOR FOR
 select ORG_DOC_TYPE_CODE||'/'||ORG_DOC_NUM||' '||ORG_DOC_DATE
from bl_patient_ledger
	where AD_PR_ADJ_BILL_DOC_TYPE  = :d_bill_doc_type_code
	  and AD_PR_ADJ_BILL_DOC_NUM   = :d_bill_doc_num  
	  and RECPT_NATURE_CODE IN('AD','PR')    
      and nvl(TRX_STATUS,'X') != 'C'; */ 



    /* EXEC SQL OPEN MULTIPLE_DEP; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 6;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )113;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_bill_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_bill_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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
         err_mesg("OPEN failed on cursor MULTIPLE_DEP",0,"");

  }

fetch_main_cur()
{
    d_bill_doc_type_code.arr[0]   = '\0';
    d_admission_date.arr[0]       = '\0';
    d_discharge_date_time.arr[0]  = '\0';
	d_national_id_num.arr[0]      = '\0';
	d_patient_id.arr[0]			  = '\0';
     
	d_bill_doc_type_code.len	  = 0;
    d_admission_date.len          = 0;
	d_discharge_date_time.len     = 0;
	d_national_id_num.len         = 0;
	d_patient_id.len			  = 0;

    d_bill_amt					  = 0;
	d_deposit_amt				  = 0;
    d_outstdg_amt				  = 0;
	d_bill_doc_num				  = 0;

    /* EXEC SQL FETCH MAIN_CUR 
	         INTO  
	   :d_bill_doc_type_code,
       :d_bill_doc_num ,
       :d_admission_date,
	   :d_discharge_date_time,
	   :d_national_id_num,
	   :d_patient_id,
	   :d_bill_amt,
	   :d_deposit_amt,
	   :d_outstdg_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )136;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_bill_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_bill_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_admission_date;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_discharge_date_time;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_national_id_num;
    sqlstm.sqhstl[4] = (unsigned int  )33;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[5] = (unsigned int  )23;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_bill_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_deposit_amt;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_outstdg_amt;
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


 
    if(OERROR)
	err_mesg("FETCH failed on cursor MAIN_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;
    d_bill_doc_type_code.arr[d_bill_doc_type_code.len]     = '\0';
	d_admission_date.arr[d_admission_date.len]             = '\0';
	d_discharge_date_time.arr[d_discharge_date_time.len]   = '\0';
    d_national_id_num.arr[d_national_id_num.len]		   = '\0';
	d_patient_id.arr[d_patient_id.len]					   = '\0';

    return 1;
}

fetch_multiple_dep_cur()
 {
   d_bill_doc_dtls.arr[0]     ='\0'; 
   d_bill_doc_dtls.len        =0;

    /* EXEC SQL FETCH MULTIPLE_DEP
	         INTO  :d_bill_doc_dtls; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )187;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_bill_doc_dtls;
    sqlstm.sqhstl[0] = (unsigned int  )33;
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
	     err_mesg("FETCH failed on cursor  MULTIPLE_DEP",0,"");
      if(NO_DATA_FOUND)
	 return 0;
   d_bill_doc_dtls.arr[d_bill_doc_dtls.len]     = '\0';

   return 1;
 }

  
fetch_prog_param()
{
    
    nd_episode_type.arr[0]     ='\0'; 
	nd_pat_from.arr[0]		   ='\0';
	nd_pat_to.arr[0]		   ='\0';
	nd_refund_type.arr[0] = '\0';

    nd_episode_type.len        =0;
	nd_pat_from.len			   =0;
	nd_pat_to.len			   =0;
	nd_refund_type.len = 0;
  
 
   /* EXEC SQL SELECT  PARAM1,PARAM2, PARAM3, PARAM4
            INTO    :nd_episode_type, :nd_pat_from, :nd_pat_to, :nd_refund_type
            FROM    SY_PROG_PARAM
            WHERE PGM_ID   = 'BLR00025'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 into :b0,:b1,:b2,:b3\
  from SY_PROG_PARAM where ((PGM_ID='BLR00025' and SESSION_ID=:b4) and PGM_DAT\
E=:b5)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )206;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_episode_type;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_pat_from;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_pat_to;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_refund_type;
   sqlstm.sqhstl[3] = (unsigned int  )4;
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

	nd_episode_type.arr[nd_episode_type.len]	= '\0';
	nd_pat_from.arr[nd_pat_from.len]	= '\0';
	nd_pat_to.arr[nd_pat_to.len]	= '\0';
	nd_refund_type.arr[nd_refund_type.len] = '\0';
}

end_of_rep()
{
	fprintf(fp,"      ***  END OF REPORT ***\n\f");
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00025.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00025.lis");
       proc_exit();
    }
}

print_page_title()
{

   fprintf(fp,"\f");
/*

	double l_report_width;
	double l_letter_heading_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width; 	

	l_line_no=0;
	l_page_no++;

	fprintf(fp,"%c&k4S",ESC); 	// To Set compressed mode 
	
	l_report_width=85;
	l_letter_heading_length = strlen(loc_legend[1]);

	//Code for Line 1
	//l_start_point=ceill((l_report_width/2)-(l_letter_heading_length/2));
	fprintf(fp,"\n");	
	print_spaces(l_start_point);
	fprintf(fp,"%s \n\n",loc_legend[1]);
	l_line_no = l_line_no + 4;*/
}


print_letter_detail()
{
	
    fprintf(fp,"%c(s3B",ESC);  
	fprintf(fp,"%c(s9H",ESC);  
	l_start_point=(63-strlen(d_hosp_name.arr))/2;
	print_spaces(l_start_point);
    fprintf(fp,"     %s\n",d_hosp_name.arr);
	l_start_point=(63-(strlen(d_address1.arr)+strlen(d_address2.arr)))/2;
	print_spaces(l_start_point);
    fprintf(fp,"     %s %s\n",d_address1.arr,d_address2.arr);
	l_start_point=(63-(strlen(d_address3.arr)+strlen(d_telnum.arr)+7))/2;
	print_spaces(l_start_point);
    fprintf(fp,"     %s Phone: %s\n",d_address3.arr, d_telnum.arr);
	fprintf(fp,"\n");
	fprintf(fp,"%c(s0B",ESC); 
	fprintf(fp,"%c(s11H",ESC);  
	fprintf(fp,"%-65.65s %s %s\n"," ",loc_legend[47],cur_date.arr);
    fprintf(fp,"     %-60.60s \n",d_patient_name.arr);
    fprintf(fp,"     %-40.40s \n",d_ln1_res_add.arr);
	fprintf(fp,"     %-40.40s \n",d_ln2_res_add.arr);
	fprintf(fp,"     %-40.40s \n",d_ln3_res_add.arr);
	fprintf(fp,"     %-40.40s \n",d_ln4_res_add.arr);
	fprintf(fp,"\n\n");
	fprintf(fp,"     %s\n\n",loc_legend[1]);
	fprintf(fp,"     %s %s ", loc_legend[2], loc_legend[3]);
	 print_deposit_dtls();
	//fprintf(fp,"%s \n\n", d_bill_doc_dtls.arr);
	fprintf(fp,"     %s %s\n\n",loc_legend[4], loc_legend[5]);
	fprintf(fp,"     2.	  %s %s\n", loc_legend[6], loc_legend[7]);
	fprintf(fp,"          %s ", loc_legend[8]);
	fprintf(fp,"%s ",nd_currency.arr);
	print_formated_tr(d_outstdg_amt);      
    fprintf(fp," %s %s\n", loc_legend[10], loc_legend[11]);
    fprintf(fp,"          %s ", loc_legend[12]);
    fprintf(fp,"%s ", nd_currency.arr);
    print_formated_tr(d_bill_amt);
    fprintf(fp," %s %s ", loc_legend[13], loc_legend[14]);
    fprintf(fp,"%-10.10s %s %-10.10s.\n\n", d_admission_date.arr,loc_legend[48],d_discharge_date_time.arr);
    fprintf(fp,"     3.	  %s %s %s \n", loc_legend[15], loc_legend[16], loc_legend[17]);
    fprintf(fp,"          %s\n", loc_legend[18]);
    fprintf(fp,"   	     i)    %s\n", loc_legend[19]);
    fprintf(fp,"  	     ii)   %s\n", loc_legend[20]);
    fprintf(fp,"	     iii)  %s %s\n", loc_legend[21], loc_legend[22]);
    fprintf(fp,"	     iv)   %s\n\n", loc_legend[23]);
    fprintf(fp,"     4.	  %s %s %s\n", loc_legend[24], loc_legend[25], loc_legend[26]);
    fprintf(fp,"          %s %s %s ", loc_legend[27], loc_legend[28], d_hosp_name.arr); 
    fprintf(fp,"%s\n", loc_legend[30]);
    fprintf(fp,"          %s %s %s ",loc_legend[31], loc_legend[32],loc_legend[33]);
    fprintf(fp,"%s \n", loc_legend[34]);					
    fprintf(fp,"          %s %s \n\n", loc_legend[35], loc_legend[36]);  
    fprintf(fp,"     %s\n\n", loc_legend[37]);
    fprintf(fp,"     %s\n\n", loc_legend[38]);
    fprintf(fp,"     %s\n", loc_legend[39]);
	fprintf(fp,"     %s\n", loc_legend[40]);
	fprintf(fp,"     %s\n", loc_legend[41]);
	fprintf(fp,"     %s\n", loc_legend[42]);    
	fprintf(fp,"     %s\n", loc_legend[43]);
	fprintf(fp,"     %s\n\n\n", d_hosp_name.arr);
	fprintf(fp,"     %s %s\n", loc_legend[45], loc_legend[46]);
/*	l_line_no+61;
	check_page_break();*/
	fprintf(fp,"\f\n");
}




print_deposit_dtls()
{
 int dep_cnt=0,sp_cnt=0;

	while(fetch_multiple_dep_cur())
	{
	dep_cnt=dep_cnt+1;
	sp_cnt=sp_cnt+strlen(d_bill_doc_dtls.arr);
	if(dep_cnt==1)
	     {
	      fprintf(fp,"%s", d_bill_doc_dtls.arr);
		  sp_cnt=0;	
	     }
	 else if(dep_cnt==2 || sp_cnt>=70)
	  {
	    sp_cnt=0;
       fprintf(fp,",\n     %s", d_bill_doc_dtls.arr);
	    sp_cnt=sp_cnt+strlen(d_bill_doc_dtls.arr);
	  }
	else 
	   {
	  fprintf(fp,",%s", d_bill_doc_dtls.arr);
	    //sp_cnt=sp_cnt+strlen(d_bill_doc_dtls.arr);
	    }
    }
		fprintf(fp," \n\n");
        dep_cnt=0;sp_cnt=0;
}

print_report()
{
  cur_date.arr[0] = '\0';
  cur_date.len    = 0;
  
    /* EXEC SQL
	         select to_char(sysdate,'dd/mm/yyyy') into :cur_date from dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select to_char(sysdate,'dd/mm/yyyy') into :b0  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )245;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&cur_date;
    sqlstm.sqhstl[0] = (unsigned int  )13;
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



  // cur_date.arr[cur_date.len] = '\0';*/

 //print_page_title();
	while(fetch_main_cur())
	{
		fetch_pat_address();
		get_multiple_dep_cur();
		print_letter_detail();
	}

}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    nd_currency.arr[0] = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;
    nd_currency.len = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME, 
				  TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
				  USER,
				  base_currency
         INTO	 :hosp_name, :date_time, :user_id,:nd_currency
         FROM	 SY_ACC_ENTITY
		 where   acc_entity_id= :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER ,base_currency into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY where acc_e\
ntity_id=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )264;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_currency;
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
nd_currency.arr[nd_currency.len] = '\0';
}
  
print_formated(loc_amount)
double loc_amount;
{
    char s_amt[30], str_amt[30];	
    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
	    //strcat(s_amt,"-");
        sprintf(str_amt,"%10s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%10sCr",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%10s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%10s",str_amt);
    }
}

print_formated_tr(loc_amount)
double loc_amount;
{
    char s_amt[30], str_amt[30];	
    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%s",s_amt);
	l_ltrim(s_amt);
        fprintf(fp,"%sCR",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%s",str_amt);
    }
}

check_page_break()
{
	if (l_line_no >= 60)	
	{
		//print_page_title();
		 fprintf(fp,"\f");
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


fetch_pat_address()
{
    d_patient_name.arr[0]        = '\0';
    d_ln1_res_add.arr[0]		 = '\0';
	d_ln2_res_add.arr[0]         = '\0';
    d_ln3_res_add.arr[0]		 = '\0';
    d_ln4_res_add.arr[0]		 = '\0';
    d_res_postal_code.arr[0]     = '\0';
    d_res_country_code.arr[0]    = '\0';

	d_patient_name.len			 = 0;
    d_ln1_res_add.len			 = 0;
	d_ln2_res_add.len            = 0;
    d_ln3_res_add.len			 = 0;
    d_ln4_res_add.len			 = 0;
    d_res_postal_code.len        = 0;
    d_res_country_code.len       = 0;


 /* EXEC SQL
      SELECT short_name 
	  INTO   :d_patient_name
	  FROM   MP_Patient_Mast
	  WHERE  patient_id = :d_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_name into :b0  from MP_Patient_Mast where patie\
nt_id=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )299;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_patient_name;
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




/* EXEC SQL  
	 SELECT	ln1_res_add, ln2_res_add, ln3_res_add, ln4_res_add, res_postal_code, res_country_code
	 INTO   d_ln1_res_add,
		   :d_ln2_res_add,
		   :d_ln3_res_add,
		   :d_ln4_res_add,
           :d_res_postal_code,
		   :d_res_country_code
	 FROM	mp_pat_other_dtls
	 WHERE  patient_id = :d_patient_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 9;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select ln1_res_add ,ln2_res_add ,ln3_res_add ,ln4_res_add ,re\
s_postal_code ,res_country_code into :b0,:b1,:b2,:b3,:b4,:b5  from mp_pat_othe\
r_dtls where patient_id=:b6";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )322;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
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

    d_patient_name.arr[d_patient_name.len]             = '\0';

    d_ln1_res_add.arr[d_ln1_res_add.len]               = '\0';
    d_ln2_res_add.arr[d_ln2_res_add.len]               = '\0';
    d_ln3_res_add.arr[d_ln3_res_add.len]               = '\0';
    d_ln4_res_add.arr[d_ln4_res_add.len]			   = '\0';
    d_res_postal_code.arr[d_res_postal_code.len]	   = '\0';
    d_res_country_code.arr[d_res_country_code.len]     = '\0';

    return 1;

}


fetch_hosp_address()
{
    d_hosp_name.arr[0]        = '\0';
    d_address1.arr[0]		 = '\0';
	d_address2.arr[0]         = '\0';
    d_address3.arr[0]		 = '\0';
	d_telnum.arr[0]			 = '\0';
 
	d_hosp_name.len			 = 0;
    d_address1.len			 = 0;
	d_address2.len            = 0;
    d_address3.len			 = 0;
	d_telnum.len			=0;
 
	/* EXEC SQL  
	select  acc_entity_name, ln1_add, ln2_add, ln3_add, tel_num
	into    :d_hosp_name,
	        :d_address1,
			:d_address2,
			:d_address3,
			:d_telnum
	from	SY_ACC_ENTITY
	where   acc_entity_id= :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select acc_entity_name ,ln1_add ,ln2_add ,ln3_add ,tel_num i\
nto :b0,:b1,:b2,:b3,:b4  from SY_ACC_ENTITY where acc_entity_id=:b5";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )365;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_hosp_name;
 sqlstm.sqhstl[0] = (unsigned int  )62;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_address1;
 sqlstm.sqhstl[1] = (unsigned int  )62;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_address2;
 sqlstm.sqhstl[2] = (unsigned int  )62;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_address3;
 sqlstm.sqhstl[3] = (unsigned int  )62;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_telnum;
 sqlstm.sqhstl[4] = (unsigned int  )23;
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
}

          

    if(OERROR)
	err_mesg("FETCH failed on cursor HOSP_ADDRESS",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_hosp_name.arr[d_hosp_name.len]             = '\0';

    d_address1.arr[d_address1.len]               = '\0';
    d_address2.arr[d_address2.len]               = '\0';
    d_address3.arr[d_address3.len]               = '\0';
	d_telnum.arr[d_telnum.len]					 = '\0';
    return 1;

}  


fetch_legend_value()
{
    for(i=1;i<50;i++)
	{	l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00025.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		         INTO :l_pk_value
				 FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00025.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )404;
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
							:nd_lang_id);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :nd_lang_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )427;
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
  sqlstm.sqhstv[3] = (         void  *)&nd_lang_id;
  sqlstm.sqhstl[3] = (unsigned int  )6;
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

