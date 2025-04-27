
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
           char  filnam[18];
};
static const struct sqlcxp sqlfpn =
{
    17,
    "T:\\BL\\BLR00074.PC"
};


static unsigned long sqlctx = 10093227;


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
            void  *sqhstv[17];
   unsigned int   sqhstl[17];
            int   sqhsts[17];
            void  *sqindv[17];
            int   sqinds[17];
   unsigned int   sqharm[17];
   unsigned int   *sqharc[17];
   unsigned short  sqadto[17];
   unsigned short  sqtdso[17];
} sqlstm = {10,17};

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
"e_code ,a.doc_num ,'C' doc_status ,a.patient_id ,d.short_name patient_name ,\
a.reason_code ,e.action_reason_desc ,a.cancelled_amt doc_amt ,decode(b.bill_dc\
p_ind,'D','DC','BI') doc_nature ,a.added_by_id ,c.doc_date bill_doc_date ,c.do\
c_type_code bill_doc_type_code ,c.doc_num bill_doc_num ,c.bill_tot_amt ,b.doc_\
amt adj_exempt_amt ,c.episode_type  from bl_bill_adj_hdr_canc a ,bl_bill_adj_d\
tl b ,bl_bill_dcp_dtl_vw c ,mp_patient_mast d ,bl_action_reason e where ((((((\
((((a.operating_facility_id=:b0 and a.operating_facility_id=b.operating_facili\
ty_id) and a.doc_type_code=b.doc_type_code) and a.doc_num=b.doc_num) and a.can\
celled_date between to_date((:b1||' 00:00:00'),'dd/mm/yyyy hh24:mi:ss') and to\
_date((:b2||' 23:59:59'),'dd/mm/yyyy hh24:mi:ss')) and a.adjust_exempt_ind=:b3\
) and c.operating_facility_id=b.operating_facility_id) and c.doc_type_code=b.a\
dj_doc_type_code) and c.doc_num=b.adj_doc_num) and d.patient_id=a.patient_id) \
and e.action_reason_code(+)=a.reason_code) order by 1,2,3,4,12,13,14          \
  ";

 static const char *sq0005 = 
"ode ,c.action_reason_desc ,(nvl(a.man_disc_amt,0)+nvl(a.overall_disc_amt,0))\
 disc_amt ,decode(a.bill_status,'D','DC',null ,'BI',a.bill_status) doc_nature \
,b.added_by_id opr_id ,d.added_date ,a.doc_type_code ,a.doc_num ,((nvl(a.bill_\
amt,0)+nvl(man_disc_amt,0))+nvl(overall_disc_amt,0)) bill_amt ,(nvl(a.man_disc\
_amt,0)+nvl(a.overall_disc_amt,0)) disc_amt ,a.episode_type  from bl_bill_hdr \
a ,bl_cancelled_bills d ,mp_patient_mast b ,bl_action_reason c where ((((((a.o\
perating_facility_id=:b0 and a.doc_type_code=d.doc_type_code) and a.doc_num=d.\
doc_number) and d.added_date between to_date((:b1||' 00:00:00'),'dd/mm/yyyy hh\
24:mi:ss') and to_date((:b2||' 23:59:59'),'dd/mm/yyyy hh24:mi:ss')) and (nvl(a\
.man_disc_amt,0)+nvl(a.overall_disc_amt,0))>0) and a.patient_id=b.patient_id) \
and d.reason_code=c.action_reason_code(+)) order by 1,2,3,4            ";

 static const char *sq0006 = 
")) order by 1,2,3,4,12,13,14            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,91,0,2,156,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,164,0,0,0,0,0,1,0,
43,0,0,3,0,0,27,172,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
74,0,0,4,2038,0,9,372,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
121,0,0,5,1873,0,9,379,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
160,0,0,6,2088,0,9,386,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
199,0,0,4,0,0,13,432,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
2,4,0,0,2,9,0,0,
282,0,0,5,0,0,13,458,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
2,4,0,0,2,9,0,0,
365,0,0,6,0,0,13,484,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
2,4,0,0,2,9,0,0,
448,0,0,7,126,0,4,512,0,0,4,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,
479,0,0,8,765,0,4,551,0,0,6,5,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
518,0,0,9,732,0,4,574,0,0,6,5,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
557,0,0,10,1284,0,6,599,0,0,4,4,0,1,0,1,9,0,0,3,9,0,0,1,9,0,0,1,9,0,0,
588,0,0,11,130,0,4,687,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
623,0,0,12,161,0,4,886,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
658,0,0,13,96,0,4,951,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
681,0,0,14,165,0,6,958,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
712,0,0,15,73,0,4,1037,0,0,5,4,0,1,0,1,97,0,0,1,9,0,0,1,97,0,0,1,9,0,0,2,9,0,0,
747,0,0,16,198,0,4,1140,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,
786,0,0,17,0,0,32,1163,0,0,0,0,0,1,0,
};


/************************************************************************/
/* PROGRAM NAME          : BLR00074.PC                                  */
/* DATE WRITTEN          : 05/04/2005                                	*/
/************************************************************************/

#include <stdio.h>  
#include <string.h>
#include <bl.h>   
  
#define OERROR				(sqlca.sqlcode < 0)
#define LAST_ROW			(sqlca.sqlcode == 1403)
#define NOT_FOUND			(sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY			(sqlca.sqlcode == -54)
#define DUPLICATE_KEY			(sqlca.sqlcode == -1)
#define	MAX_LINES			60
#define ESC				0x1B
#define INIT_MESG			"Report Generation is in progress"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR			uid_pwd					[132],
			hosp_name				[120],
			date_time				[20],
			user_id					[31],
			nd_pgm_date				[35],			
			nd_session_id				[40],
			nd_facility_id				[3],
			d_acc_entity_name			[41],
			d_user					[31],
			d_sysdate				[17],
			date					[20]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[31]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[40]; } nd_session_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[20]; } date;

            
/* VARCHAR			l_pk_value			[200],			
			l_from_and_to_date		[71]; */ 
struct { unsigned short len; unsigned char arr[200]; } l_pk_value;

struct { unsigned short len; unsigned char arr[71]; } l_from_and_to_date;


/* VARCHAR 		nd_fr_date			[11],
			nd_to_date			[11],
			nd_option			[2],
			l_sysdate			[20],			
			l_translated_value		[201],
			p_language_id		[3],
			nd_currency			[10],
			d_episode_type			[2],
			d_rev_code			[1000]; */ 
struct { unsigned short len; unsigned char arr[11]; } nd_fr_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[2]; } nd_option;

struct { unsigned short len; unsigned char arr[20]; } l_sysdate;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[10]; } nd_currency;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[1000]; } d_rev_code;



char		filename[200],l_tit1[201],loc_legend_26_27_28_29[100];
char		loc_legend[40][201],
		l_mesg[1000];


int			l_line_no =0;
int			l_page_no =0;
int			i;
int			d_hdr_srlno = 0, d_dtl_srlno = 0, l_rec_ctr = 0;

/* VARCHAR		d_doc_date[30],
	        d_doc_type_code[15], 
		d_doc_num[20],
		d_doc_status[20],
		d_patient_id[21],
		d_patient_name[61], 
		d_reason_code[10],
		d_action_reason_desc[500], 
		d_doc_nature[5], 
		d_opr_id[31],        
		d_bill_doc_date[30], 
		d_bill_doc_type_code[15], 
		d_bill_doc_num[20],
		d_prv_doc_date[30],
	        d_prv_doc_type_code[15], 
		d_prv_doc_num[20],
		d_prv_doc_status[20],
		d_doc_type[20],
		d_bill_doc_type[20],
		d_reason[1000]; */ 
struct { unsigned short len; unsigned char arr[30]; } d_doc_date;

struct { unsigned short len; unsigned char arr[15]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[20]; } d_doc_num;

struct { unsigned short len; unsigned char arr[20]; } d_doc_status;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[10]; } d_reason_code;

struct { unsigned short len; unsigned char arr[500]; } d_action_reason_desc;

struct { unsigned short len; unsigned char arr[5]; } d_doc_nature;

struct { unsigned short len; unsigned char arr[31]; } d_opr_id;

struct { unsigned short len; unsigned char arr[30]; } d_bill_doc_date;

struct { unsigned short len; unsigned char arr[15]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[20]; } d_bill_doc_num;

struct { unsigned short len; unsigned char arr[30]; } d_prv_doc_date;

struct { unsigned short len; unsigned char arr[15]; } d_prv_doc_type_code;

struct { unsigned short len; unsigned char arr[20]; } d_prv_doc_num;

struct { unsigned short len; unsigned char arr[20]; } d_prv_doc_status;

struct { unsigned short len; unsigned char arr[20]; } d_doc_type;

struct { unsigned short len; unsigned char arr[20]; } d_bill_doc_type;

struct { unsigned short len; unsigned char arr[1000]; } d_reason;

		       

double	d_doc_amt = 0,
	d_bill_tot_amt = 0,
	d_adj_exempt_wo_disc_amt = 0,
	d_tot_adj_amt = 0,
	d_g_tot_adj_amt = 0;

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLR00074.c-arc   1.0   Apr 19 2007 17:05:08   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLR00074.c-arc   1.0   Apr 19 2007 17:05:08   vcm_th  $ sqlda.h 
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

	fetch_prog_param();  

	fetch_hosp_name();

	declare_cursors();

	open_file();

	fetch_legend_value();

	fprintf(fp,"%c",0x0F); // set printer to compressed mode 

	print_report();

	end_of_rep();

	/* EXEC SQL DELETE SY_PROG_PARAM
	WHERE PGM_ID   = 'BLR00074'
	AND SESSION_ID = :nd_session_id
	AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLR00074' and SE\
SSION_ID=:b0) and PGM_DATE=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[0] = (unsigned int  )42;
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
/* EXEC SQL DECLARE ADJ_EXEMPT CURSOR FOR 
SELECT		a.doc_date,
	        a.doc_type_code, 
		a.doc_num,
		' ' doc_status,
		a.patient_id,
		d.short_name patient_name, 
		a.reason_code,
		e.action_reason_desc, 
		a.doc_amt,
		decode(b.bill_dcp_ind,'D','DC','BI') doc_nature, 
		a.added_by_id,        
		c.doc_date bill_doc_date, 
		c.doc_type_code bill_doc_type_code, 
		c.doc_num bill_doc_num,
		c.bill_tot_amt,
		b.doc_amt adj_exempt_amt,
		c.episode_type
FROM bl_bill_adj_hdr a, bl_bill_adj_dtl b, bl_bill_dcp_dtl_vw c, 
     mp_patient_mast d, bl_action_reason e
WHERE a.operating_facility_id = :nd_facility_id
AND a.operating_facility_id = b.operating_facility_id
AND a.doc_type_code = b.doc_type_code
AND a.doc_num = b.doc_num
AND a.doc_date between to_date(:nd_fr_date||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
		   AND to_date(:nd_to_date||' 23:59:59','dd/mm/yyyy hh24:mi:ss') 
AND a.adjust_exempt_ind = :nd_option
AND c.operating_facility_id = b.operating_facility_id
AND c.doc_type_code = b.adj_doc_type_code
AND c.doc_num = b.adj_doc_num
AND d.patient_id = a.patient_id
AND e.action_reason_code(+) = a.reason_code
UNION ALL
SELECT a.cancelled_date,
       a.doc_type_code, 
       a.doc_num,
       'C' doc_status,
       a.patient_id,
       d.short_name patient_name, 
       a.reason_code, 
       e.action_reason_desc, 
       a.cancelled_amt doc_amt,
       decode(b.bill_dcp_ind,'D','DC','BI') doc_nature, 
       a.added_by_id,        
       c.doc_date bill_doc_date, 
       c.doc_type_code bill_doc_type_code, 
       c.doc_num bill_doc_num,
       c.bill_tot_amt,
       b.doc_amt adj_exempt_amt,
       c.episode_type
FROM bl_bill_adj_hdr_canc a, bl_bill_adj_dtl b, bl_bill_dcp_dtl_vw c, 
     mp_patient_mast d, bl_action_reason e
WHERE a.operating_facility_id = :nd_facility_id
AND a.operating_facility_id = b.operating_facility_id
AND a.doc_type_code = b.doc_type_code
AND a.doc_num = b.doc_num
AND a.cancelled_date between to_date(:nd_fr_date||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
			 AND to_date(:nd_to_date||' 23:59:59','dd/mm/yyyy hh24:mi:ss') 
AND a.adjust_exempt_ind = :nd_option
AND c.operating_facility_id = b.operating_facility_id
AND c.doc_type_code = b.adj_doc_type_code
AND c.doc_num = b.adj_doc_num
AND d.patient_id = a.patient_id
AND e.action_reason_code(+) = a.reason_code
ORDER BY 1,2,3,4,12,13,14; */ 


/* EXEC SQL DECLARE BILL_DISC CURSOR FOR 
SELECT nvl(a.bill_disc_date,a.doc_date), 
       a.doc_type_code, 
       a.doc_num,
       ' 'doc_status,
       a.patient_id, 
       b.short_name,
       a.reason_code,
       c.action_reason_desc, 
       nvl(a.man_disc_amt,0)+nvl(a.overall_disc_amt,0) disc_amt,       
       decode(a.bill_status,'D','DC', NULL, 'BI',a.bill_status) doc_nature,              
       nvl(a.bill_disc_by_id,a.added_by_id),        
       a.doc_date,
       a.doc_type_code,
       a.doc_num,
       nvl(a.bill_amt,0)+ nvl(man_disc_amt,0)+nvl(overall_disc_amt,0) bill_amt,
       nvl(a.man_disc_amt,0)+nvl(a.overall_disc_amt,0) disc_amt,       
       a.episode_type       
FROM bl_bill_hdr a, mp_patient_mast b, bl_action_reason c
WHERE a.operating_facility_id = :nd_facility_id
AND a.patient_id = b.patient_id
AND nvl(a.bill_disc_date,a.doc_date) between to_date(:nd_fr_date||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
			 AND to_date(:nd_to_date||' 23:59:59','dd/mm/yyyy hh24:mi:ss') 
AND (nvl(a.man_disc_amt,0)+nvl(a.overall_disc_amt,0)) > 0               
AND a.reason_code = c.action_reason_code(+)
UNION ALL
SELECT d.added_date doc_date, 
       a.doc_type_code, 
       a.doc_num,
       'C' doc_status,
       a.patient_id, 
       b.short_name patient_name,
       d.reason_code,
       c.action_reason_desc,        
       nvl(a.man_disc_amt,0)+nvl(a.overall_disc_amt,0) disc_amt,
       decode(a.bill_status,'D','DC', NULL, 'BI',a.bill_status) doc_nature,       
       b.added_by_id opr_id, 
       d.added_date,
       a.doc_type_code,
       a.doc_num,       
       nvl(a.bill_amt,0)+ nvl(man_disc_amt,0)+nvl(overall_disc_amt,0) bill_amt,
       nvl(a.man_disc_amt,0)+nvl(a.overall_disc_amt,0) disc_amt,
       a.episode_type
FROM bl_bill_hdr a, bl_cancelled_bills d,
     mp_patient_mast b, bl_action_reason c
WHERE a.operating_facility_id = :nd_facility_id
AND a.doc_type_code = d.doc_type_code
AND a.doc_num = d.doc_number	
AND d.added_date between to_date(:nd_fr_date||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
			 AND to_date(:nd_to_date||' 23:59:59','dd/mm/yyyy hh24:mi:ss') 
AND (nvl(a.man_disc_amt,0)+nvl(a.overall_disc_amt,0)) > 0 
AND a.patient_id = b.patient_id
AND d.reason_code = c.action_reason_code(+)
ORDER BY 1,2,3,4; */ 


/* EXEC SQL DECLARE BILL_WO CURSOR FOR 
SELECT a.doc_date,
       a.doc_type_code, 
       a.doc_num,
       ' ' doc_status,       
       b.patient_id, 
       d.short_name patient_name, 
       b.appr_rejn_reason_code, 
       e.action_reason_desc,        
       0 tot_wo_amt,
       decode(b.status,'D','DC','BI') doc_nature, 
       a.added_by_id OPR_ID, 
       c.doc_date bill_doc_date, 
       c.doc_type_code bill_doc_type_code, 
       c.doc_num bill_doc_num,       
       c.bill_tot_amt,       
       b.wo_approved_amt,
       c.episode_type
FROM bl_wo_request_hdr a, bl_wo_request_dtl b, bl_bill_dcp_dtl_vw c, 
     mp_patient_mast d, bl_action_reason e
WHERE a.operating_facility_id = :nd_facility_id
AND a.operating_facility_id = b.operating_facility_id
AND a.doc_type_code = b.doc_type_code
AND a.doc_num = b.doc_num
AND a.doc_date between to_date(:nd_fr_date||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
		   AND to_date(:nd_to_date||' 23:59:59','dd/mm/yyyy hh24:mi:ss') 
AND nvl(b.wo_approved_yn,'N') = 'Y' 
AND c.operating_facility_id = b.operating_facility_id
AND c.doc_type_code = b.org_doc_type_code
AND c.doc_num = b.org_doc_num
AND d.patient_id = b.patient_id
AND e.action_reason_code = b.appr_rejn_reason_code(+)
UNION ALL
SELECT a.doc_date, 
       a.doc_type_code, 
       a.doc_num,
       'C' doc_status,       
       b.patient_id, 
       d.short_name patient_name, 
       a.reason_code, 
       e.action_reason_desc,        
       0 tot_wo_amt,
       decode(b.status,'D','DC','BI') doc_nature, 
       a.added_by_id, 
       c.doc_date bill_doc_date, 
       c.doc_type_code bill_doc_type_code, 
       c.doc_num bill_doc_num,       
       c.bill_tot_amt,       
       b.wo_approved_amt doc_wo_amt,
       c.episode_type
FROM bl_wo_request_canc_dtl a, bl_wo_request_dtl b, bl_bill_dcp_dtl_vw c, 
     mp_patient_mast d, bl_action_reason e
WHERE a.operating_facility_id = :nd_facility_id
AND a.operating_facility_id = b.operating_facility_id
AND a.doc_type_code = b.doc_type_code
AND a.doc_num = b.doc_num
AND a.doc_slno = b.doc_slno
AND a.doc_date between to_date(:nd_fr_date||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
		   AND to_date(:nd_to_date||' 23:59:59','dd/mm/yyyy hh24:mi:ss') 
AND nvl(b.wo_approved_yn,'N') = 'Y' 
AND c.operating_facility_id = b.operating_facility_id
AND c.doc_type_code = b.org_doc_type_code
AND c.doc_num = b.org_doc_num
AND d.patient_id = b.patient_id
AND e.action_reason_code = b.appr_rejn_reason_code(+)
ORDER BY 1,2,3,4,12,13,14; */ 



if ( nd_option.arr[0] == 'A' || nd_option.arr[0] == 'E')
{
	/* EXEC SQL OPEN ADJ_EXEMPT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.doc_date ,a.doc_type_code ,a.doc_num ,' ' doc_status ,a.patient\
_id ,d.short_name patient_name ,a.reason_code ,e.action_reason_desc ,a.doc_a\
mt ,decode(b.bill_dcp_ind,'D','DC','BI') doc_nature ,a.added_by_id ,c.doc_da\
te bill_doc_date ,c.doc_type_code bill_doc_type_code ,c.doc_num bill_doc_num\
 ,c.bill_tot_amt ,b.doc_amt adj_exempt_amt ,c.episode_type  from bl_bill_adj\
_hdr a ,bl_bill_adj_dtl b ,bl_bill_dcp_dtl_vw c ,mp_patient_mast d ,bl_actio\
n_reason e where ((((((((((a.operating_facility_id=:b0 and a.operating_facil\
ity_id=b.operating_facility_id) and a.doc_type_code=b.doc_type_code) and a.d\
oc_num=b.doc_num) and a.doc_date between to_date((:b1||' 00:00:00'),'dd/mm/y\
yyy hh24:mi:ss') and to_date((:b2||' 23:59:59'),'dd/mm/yyyy hh24:mi:ss')) an\
d a.adjust_exempt_ind=:b3) and c.operating_facility_id=b.operating_facility_\
id) and c.doc_type_code=b.adj_doc_type_code) and c.doc_num=b.adj_doc_num) an\
d d.patient_id=a.patient_id) and e.action_reason_code(+)=a.reason_code) unio\
n all select a.cancelled_date ,a.doc_typ");
 sqlstm.stmt = sq0004;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )74;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_fr_date;
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
 sqlstm.sqhstv[3] = (         void  *)&nd_option;
 sqlstm.sqhstl[3] = (unsigned int  )4;
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
 sqlstm.sqhstv[5] = (         void  *)&nd_fr_date;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_to_date;
 sqlstm.sqhstl[6] = (unsigned int  )13;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_option;
 sqlstm.sqhstl[7] = (unsigned int  )4;
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



		if(OERROR)	   
		  err_mesg("OPEN failed on cursor ADJ_EXEMPT",0,"");
}
else if ( nd_option.arr[0] == 'D')
{
	/* EXEC SQL OPEN BILL_DISC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select nvl(a.bill_disc_date,a.doc_date) ,a.doc_type_code ,a.doc_num ,' '\
 doc_status ,a.patient_id ,b.short_name ,a.reason_code ,c.action_reason_desc\
 ,(nvl(a.man_disc_amt,0)+nvl(a.overall_disc_amt,0)) disc_amt ,decode(a.bill_\
status,'D','DC',null ,'BI',a.bill_status) doc_nature ,nvl(a.bill_disc_by_id,\
a.added_by_id) ,a.doc_date ,a.doc_type_code ,a.doc_num ,((nvl(a.bill_amt,0)+\
nvl(man_disc_amt,0))+nvl(overall_disc_amt,0)) bill_amt ,(nvl(a.man_disc_amt,\
0)+nvl(a.overall_disc_amt,0)) disc_amt ,a.episode_type  from bl_bill_hdr a ,\
mp_patient_mast b ,bl_action_reason c where ((((a.operating_facility_id=:b0 \
and a.patient_id=b.patient_id) and nvl(a.bill_disc_date,a.doc_date) between \
to_date((:b1||' 00:00:00'),'dd/mm/yyyy hh24:mi:ss') and to_date((:b2||' 23:5\
9:59'),'dd/mm/yyyy hh24:mi:ss')) and (nvl(a.man_disc_amt,0)+nvl(a.overall_di\
sc_amt,0))>0) and a.reason_code=c.action_reason_code(+)) union all select d.\
added_date doc_date ,a.doc_type_code ,a.doc_num ,'C' doc_status ,a.patient_i\
d ,b.short_name patient_name ,d.reason_c");
 sqlstm.stmt = sq0005;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )121;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_fr_date;
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
 sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_fr_date;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
 sqlstm.sqhstl[5] = (unsigned int  )13;
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
		  err_mesg("OPEN failed on cursor BILL_DISC",0,"");
}
else if ( nd_option.arr[0] == 'W')
{
	/* EXEC SQL OPEN BILL_WO; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.doc_date ,a.doc_type_code ,a.doc_num ,' ' doc_status ,b.patient\
_id ,d.short_name patient_name ,b.appr_rejn_reason_code ,e.action_reason_des\
c ,0 tot_wo_amt ,decode(b.status,'D','DC','BI') doc_nature ,a.added_by_id OP\
R_ID ,c.doc_date bill_doc_date ,c.doc_type_code bill_doc_type_code ,c.doc_nu\
m bill_doc_num ,c.bill_tot_amt ,b.wo_approved_amt ,c.episode_type  from bl_w\
o_request_hdr a ,bl_wo_request_dtl b ,bl_bill_dcp_dtl_vw c ,mp_patient_mast \
d ,bl_action_reason e where ((((((((((a.operating_facility_id=:b0 and a.oper\
ating_facility_id=b.operating_facility_id) and a.doc_type_code=b.doc_type_co\
de) and a.doc_num=b.doc_num) and a.doc_date between to_date((:b1||' 00:00:00\
'),'dd/mm/yyyy hh24:mi:ss') and to_date((:b2||' 23:59:59'),'dd/mm/yyyy hh24:\
mi:ss')) and nvl(b.wo_approved_yn,'N')='Y') and c.operating_facility_id=b.op\
erating_facility_id) and c.doc_type_code=b.org_doc_type_code) and c.doc_num=\
b.org_doc_num) and d.patient_id=b.patient_id) and e.action_reason_code=b.app\
r_rejn_reason_code(+)) union all select ");
 sqlbuft((void **)0, 
   "a.doc_date ,a.doc_type_code ,a.doc_num ,'C' doc_status ,b.patient_id ,d.\
short_name patient_name ,a.reason_code ,e.action_reason_desc ,0 tot_wo_amt ,\
decode(b.status,'D','DC','BI') doc_nature ,a.added_by_id ,c.doc_date bill_do\
c_date ,c.doc_type_code bill_doc_type_code ,c.doc_num bill_doc_num ,c.bill_t\
ot_amt ,b.wo_approved_amt doc_wo_amt ,c.episode_type  from bl_wo_request_can\
c_dtl a ,bl_wo_request_dtl b ,bl_bill_dcp_dtl_vw c ,mp_patient_mast d ,bl_ac\
tion_reason e where (((((((((((a.operating_facility_id=:b0 and a.operating_f\
acility_id=b.operating_facility_id) and a.doc_type_code=b.doc_type_code) and\
 a.doc_num=b.doc_num) and a.doc_slno=b.doc_slno) and a.doc_date between to_d\
ate((:b1||' 00:00:00'),'dd/mm/yyyy hh24:mi:ss') and to_date((:b2||' 23:59:59\
'),'dd/mm/yyyy hh24:mi:ss')) and nvl(b.wo_approved_yn,'N')='Y') and c.operat\
ing_facility_id=b.operating_facility_id) and c.doc_type_code=b.org_doc_type_\
code) and c.doc_num=b.org_doc_num) and d.patient_id=b.patient_id) and e.acti\
on_reason_code=b.appr_rejn_reason_code(+");
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )160;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_fr_date;
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
 sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_fr_date;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
 sqlstm.sqhstl[5] = (unsigned int  )13;
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
		  err_mesg("OPEN failed on cursor BILL_WO",0,"");
}

}

fetch_cursors()
{
	d_doc_date.arr[0] = '\0';
	d_doc_type_code.arr[0] = '\0';
	d_doc_num.arr[0] = '\0';
	d_doc_status.arr[0] = '\0';
	d_patient_id.arr[0] = '\0';
	d_patient_name.arr[0] = '\0';
	d_reason_code.arr[0] = '\0';
	d_action_reason_desc.arr[0] = '\0';	
	d_doc_nature.arr[0] = '\0';
	d_opr_id.arr[0] = '\0';
	d_bill_doc_date.arr[0] = '\0';
	d_bill_doc_type_code.arr[0] = '\0';
	d_bill_doc_num.arr[0] = '\0';
	d_episode_type.arr[0] = '\0';

	d_doc_date.len = 0;
	d_doc_type_code.len = 0;
	d_doc_num.len = 0;
	d_doc_status.len = 0;
	d_patient_id.len = 0;
	d_patient_name.len = 0;
	d_reason_code.len = 0;
	d_action_reason_desc.len = 0;
	d_doc_nature.len = 0;
	d_opr_id.len = 0;
	d_bill_doc_date.len = 0;
	d_bill_doc_type_code.len = 0;
	d_bill_doc_num.len = 0;
	d_episode_type.len = 0;

	d_bill_tot_amt = 0;
	d_adj_exempt_wo_disc_amt =0;
	d_doc_amt = 0;

if ( nd_option.arr[0] == 'A' || nd_option.arr[0] == 'E' )
{
    /* EXEC SQL FETCH ADJ_EXEMPT INTO  
		:d_doc_date,
	        :d_doc_type_code, 
		:d_doc_num,
		:d_doc_status,
		:d_patient_id,
		:d_patient_name, 
		:d_reason_code,
		:d_action_reason_desc, 
		:d_doc_amt,
		:d_doc_nature, 
		:d_opr_id,        
		:d_bill_doc_date, 
		:d_bill_doc_type_code, 
		:d_bill_doc_num,
		:d_bill_tot_amt,
		:d_adj_exempt_wo_disc_amt,
		:d_episode_type; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )199;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_doc_date;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )17;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_doc_num;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_doc_status;
    sqlstm.sqhstl[3] = (unsigned int  )22;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_patient_name;
    sqlstm.sqhstl[5] = (unsigned int  )63;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_reason_code;
    sqlstm.sqhstl[6] = (unsigned int  )12;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_action_reason_desc;
    sqlstm.sqhstl[7] = (unsigned int  )502;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_doc_amt;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_doc_nature;
    sqlstm.sqhstl[9] = (unsigned int  )7;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_opr_id;
    sqlstm.sqhstl[10] = (unsigned int  )33;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_bill_doc_date;
    sqlstm.sqhstl[11] = (unsigned int  )32;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_bill_doc_type_code;
    sqlstm.sqhstl[12] = (unsigned int  )17;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_bill_doc_num;
    sqlstm.sqhstl[13] = (unsigned int  )22;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_bill_tot_amt;
    sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_adj_exempt_wo_disc_amt;
    sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[16] = (unsigned int  )4;
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


		

    if(OERROR)
	err_mesg("FETCH failed on cursor ADJ_EXEMPT",0,"");
}

else if ( nd_option.arr[0] == 'D' )
{
    /* EXEC SQL FETCH BILL_DISC INTO  
		:d_doc_date,
	        :d_doc_type_code, 
		:d_doc_num,
		:d_doc_status,
		:d_patient_id,
		:d_patient_name, 
		:d_reason_code,
		:d_action_reason_desc, 
		:d_doc_amt,
		:d_doc_nature, 
		:d_opr_id,        
		:d_bill_doc_date, 
		:d_bill_doc_type_code, 
		:d_bill_doc_num,
		:d_bill_tot_amt,
		:d_adj_exempt_wo_disc_amt,
		:d_episode_type; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )282;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_doc_date;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )17;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_doc_num;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_doc_status;
    sqlstm.sqhstl[3] = (unsigned int  )22;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_patient_name;
    sqlstm.sqhstl[5] = (unsigned int  )63;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_reason_code;
    sqlstm.sqhstl[6] = (unsigned int  )12;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_action_reason_desc;
    sqlstm.sqhstl[7] = (unsigned int  )502;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_doc_amt;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_doc_nature;
    sqlstm.sqhstl[9] = (unsigned int  )7;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_opr_id;
    sqlstm.sqhstl[10] = (unsigned int  )33;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_bill_doc_date;
    sqlstm.sqhstl[11] = (unsigned int  )32;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_bill_doc_type_code;
    sqlstm.sqhstl[12] = (unsigned int  )17;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_bill_doc_num;
    sqlstm.sqhstl[13] = (unsigned int  )22;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_bill_tot_amt;
    sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_adj_exempt_wo_disc_amt;
    sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[16] = (unsigned int  )4;
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


		

    if(OERROR)
	err_mesg("FETCH failed on cursor BILL_DISC",0,"");
}

else if ( nd_option.arr[0] == 'W' )
{
    /* EXEC SQL FETCH BILL_WO INTO  
		:d_doc_date,
	        :d_doc_type_code, 
		:d_doc_num,
		:d_doc_status,
		:d_patient_id,
		:d_patient_name, 
		:d_reason_code,
		:d_action_reason_desc, 
		:d_doc_amt,  // Always zero will come, Below query will give exact amount/
		:d_doc_nature,   
		:d_opr_id,        
		:d_bill_doc_date, 
		:d_bill_doc_type_code, 
		:d_bill_doc_num,
		:d_bill_tot_amt,
		:d_adj_exempt_wo_disc_amt,
		:d_episode_type; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )365;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_doc_date;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )17;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_doc_num;
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_doc_status;
    sqlstm.sqhstl[3] = (unsigned int  )22;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_patient_name;
    sqlstm.sqhstl[5] = (unsigned int  )63;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_reason_code;
    sqlstm.sqhstl[6] = (unsigned int  )12;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_action_reason_desc;
    sqlstm.sqhstl[7] = (unsigned int  )502;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_doc_amt;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_doc_nature;
    sqlstm.sqhstl[9] = (unsigned int  )7;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_opr_id;
    sqlstm.sqhstl[10] = (unsigned int  )33;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_bill_doc_date;
    sqlstm.sqhstl[11] = (unsigned int  )32;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_bill_doc_type_code;
    sqlstm.sqhstl[12] = (unsigned int  )17;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_bill_doc_num;
    sqlstm.sqhstl[13] = (unsigned int  )22;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_bill_tot_amt;
    sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_adj_exempt_wo_disc_amt;
    sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[16] = (unsigned int  )4;
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


		

    if(OERROR)
	err_mesg("FETCH failed on cursor BILL_WO",0,"");
}

    if(NO_DATA_FOUND)
	return 0;


	/* EXEC SQL SELECT TO_CHAR(TO_DATE(:d_doc_date,'DD-MON-YY'),'DD/MM/YYYY'),
			TO_CHAR(TO_DATE(:d_bill_doc_date,'DD-MON-YY'),'DD/MM/YYYY')	
		INTO :d_doc_date,:d_bill_doc_date 
		FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(TO_DATE(:b0,'DD-MON-YY'),'DD/MM/YYYY') ,TO_CH\
AR(TO_DATE(:b1,'DD-MON-YY'),'DD/MM/YYYY') into :b0,:b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )448;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_date;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_bill_doc_date;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_doc_date;
 sqlstm.sqhstl[2] = (unsigned int  )32;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_bill_doc_date;
 sqlstm.sqhstl[3] = (unsigned int  )32;
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

			

	d_doc_date.arr[d_doc_date.len] = '\0';
	d_doc_type_code.arr[d_doc_type_code.len] = '\0'; 
	d_doc_num.arr[d_doc_num.len] = '\0';
	d_doc_status.arr[d_doc_status.len] = '\0';
	d_patient_id.arr[d_patient_id.len] = '\0';
	d_patient_name.arr[d_patient_name.len] = '\0'; 
	d_reason_code.arr[d_reason_code.len] = '\0';
	d_action_reason_desc.arr[d_action_reason_desc.len] = '\0'; 	
	d_doc_nature.arr[d_doc_nature.len] = '\0'; 
	d_opr_id.arr[d_opr_id.len] = '\0';        
	d_bill_doc_date.arr[d_bill_doc_date.len] ='\0'; 
	d_bill_doc_type_code.arr[d_bill_doc_type_code.len] = '\0'; 	
	d_bill_doc_num.arr[d_bill_doc_num.len] = '\0';
	d_episode_type.arr[d_episode_type.len] = '\0';
	
	
	sprintf(d_doc_type.arr,"%s/%s",d_doc_type_code.arr,d_doc_num.arr);
	sprintf(d_bill_doc_type.arr,"%s/%s",d_bill_doc_type_code.arr,d_bill_doc_num.arr);
	sprintf(d_reason.arr,"%s/%s",d_reason_code.arr,d_action_reason_desc.arr);

	get_rev_code();	
	

    return 1;

}
get_tot_wo_amt()
{
	if ( nd_option.arr[0] == 'W' )
	{
		if (d_doc_status.arr[0] == 'C')
		{
			d_doc_amt= 0;

			/* EXEC SQL SELECT SUM(NVL(b.wo_approved_amt,0)) INTO :d_doc_amt
			FROM bl_wo_request_canc_dtl a, bl_wo_request_dtl b, bl_bill_dcp_dtl_vw c, 
			     mp_patient_mast d, bl_action_reason e
			WHERE a.operating_facility_id = :nd_facility_id
			AND a.doc_type_code = :d_doc_type_code
			AND a.doc_num = :d_doc_num
			AND a.operating_facility_id = b.operating_facility_id
			AND a.doc_type_code = b.doc_type_code
			AND a.doc_num = b.doc_num
			AND a.doc_slno = b.doc_slno
			AND a.doc_date between to_date(:nd_fr_date||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
			AND to_date(:nd_to_date||' 23:59:59','dd/mm/yyyy hh24:mi:ss') 
			AND nvl(b.wo_approved_yn,'N') = 'Y' 
			AND c.operating_facility_id = b.operating_facility_id
			AND c.doc_type_code = b.org_doc_type_code
			AND c.doc_num = b.org_doc_num
			AND d.patient_id = b.patient_id
			AND e.action_reason_code = b.appr_rejn_reason_code(+); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select sum(NVL(b.wo_approved_amt,0)) into :b0  from bl_wo_\
request_canc_dtl a ,bl_wo_request_dtl b ,bl_bill_dcp_dtl_vw c ,mp_patient_mast\
 d ,bl_action_reason e where (((((((((((((a.operating_facility_id=:b1 and a.do\
c_type_code=:b2) and a.doc_num=:b3) and a.operating_facility_id=b.operating_fa\
cility_id) and a.doc_type_code=b.doc_type_code) and a.doc_num=b.doc_num) and a\
.doc_slno=b.doc_slno) and a.doc_date between to_date((:b4||' 00:00:00'),'dd/mm\
/yyyy hh24:mi:ss') and to_date((:b5||' 23:59:59'),'dd/mm/yyyy hh24:mi:ss')) an\
d nvl(b.wo_approved_yn,'N')='Y') and c.operating_facility_id=b.operating_facil\
ity_id) and c.doc_type_code=b.org_doc_type_code) and c.doc_num=b.org_doc_num) \
and d.patient_id=b.patient_id) and e.action_reason_code=b.appr_rejn_reason_cod\
e(+))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )479;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_doc_amt;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
   sqlstm.sqhstv[2] = (         void  *)&d_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )17;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )22;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fr_date;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[5] = (unsigned int  )13;
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
		else
		{
			d_doc_amt= 0;

			/* EXEC SQL SELECT SUM(NVL(b.wo_approved_amt,0)) INTO :d_doc_amt
			FROM bl_wo_request_hdr a, bl_wo_request_dtl b, 
			     bl_bill_dcp_dtl_vw c, mp_patient_mast d, 
			     bl_action_reason e
			WHERE a.operating_facility_id = :nd_facility_id
			AND a.doc_type_code = :d_doc_type_code
			AND a.doc_num = :d_doc_num
			AND a.operating_facility_id = b.operating_facility_id
			AND a.doc_type_code = b.doc_type_code
			AND a.doc_num = b.doc_num
			AND a.doc_date between to_date(:nd_fr_date||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
				   AND to_date(:nd_to_date||' 23:59:59','dd/mm/yyyy hh24:mi:ss') 
			AND nvl(b.wo_approved_yn,'N') = 'Y' 
			AND c.operating_facility_id = b.operating_facility_id
			AND c.doc_type_code = b.org_doc_type_code
			AND c.doc_num = b.org_doc_num
			AND d.patient_id = b.patient_id
			AND e.action_reason_code = b.appr_rejn_reason_code(+); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select sum(NVL(b.wo_approved_amt,0)) into :b0  from bl_wo_\
request_hdr a ,bl_wo_request_dtl b ,bl_bill_dcp_dtl_vw c ,mp_patient_mast d ,b\
l_action_reason e where ((((((((((((a.operating_facility_id=:b1 and a.doc_type\
_code=:b2) and a.doc_num=:b3) and a.operating_facility_id=b.operating_facility\
_id) and a.doc_type_code=b.doc_type_code) and a.doc_num=b.doc_num) and a.doc_d\
ate between to_date((:b4||' 00:00:00'),'dd/mm/yyyy hh24:mi:ss') and to_date((:\
b5||' 23:59:59'),'dd/mm/yyyy hh24:mi:ss')) and nvl(b.wo_approved_yn,'N')='Y') \
and c.operating_facility_id=b.operating_facility_id) and c.doc_type_code=b.org\
_doc_type_code) and c.doc_num=b.org_doc_num) and d.patient_id=b.patient_id) an\
d e.action_reason_code=b.appr_rejn_reason_code(+))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )518;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_doc_amt;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
   sqlstm.sqhstv[2] = (         void  *)&d_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )17;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )22;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fr_date;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[5] = (unsigned int  )13;
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
	}

}

get_rev_code()
{
	/* EXEC SQL EXECUTE
	DECLARE
		CURSOR c1(l_catg Varchar2, l_epi_type Varchar2) is 
			SELECT account_code 
			FROM bl_rev_acct_by_receipt_type
			WHERE rcpt_nature_code = :d_doc_nature
			AND category = l_catg
			AND episode_type = l_epi_type
			AND status is null
			ORDER BY 1;
		l_ctr1 number := 0;		
		l_nat VARCHAR2(20);
	BEGIN
		:d_rev_code := null;		

		l_nat := BLCOMMON.GET_RELN_CODE(:d_patient_id);

		FOR i IN c1(l_nat,:d_episode_type) LOOP
			l_ctr1 := l_ctr1 + 1;
			if l_ctr1 = 1 then
				:d_rev_code := i.account_code;
			else
				:d_rev_code := :d_rev_code||','||i.account_code;
			end if;		
		END LOOP;

		
		if :d_rev_code is null then 

			FOR i in c1(l_nat,'U') LOOP
				l_ctr1 := l_ctr1 + 1;
				if l_ctr1 = 1 then
					:d_rev_code := i.account_code;
				else
					:d_rev_code := :d_rev_code||','||i.account_code;
				end if;
			END LOOP;	

		end if;

		

		if :d_rev_code is null then 

			FOR i in c1('UNRESTRICTED',:d_episode_type) LOOP
				l_ctr1 := l_ctr1 + 1;
				if l_ctr1 = 1 then
					:d_rev_code := i.account_code;
				else
					:d_rev_code := :d_rev_code||','||i.account_code;
				end if;
			END LOOP;	

		end if;



		if :d_rev_code is null then 

			FOR i in c1('UNRESTRICTED','U') LOOP
				l_ctr1 := l_ctr1 + 1;
				if l_ctr1 = 1 then
					:d_rev_code := i.account_code;
				else
					:d_rev_code := :d_rev_code||','||i.account_code;
				end if;
			END LOOP;	

		end if;


	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "declare CURSOR c1 ( l_catg Varchar2 , l_epi_type Varchar2 ) is SELECT ac\
count_code FROM bl_rev_acct_by_receipt_type WHERE rcpt_nature_code = :d_doc_\
nature AND category = l_catg AND episode_type = l_epi_type AND status is nul\
l ORDER BY 1 ; l_ctr1 number := 0 ; l_nat VARCHAR2 ( 20 ) ; BEGIN :d_rev_cod\
e := null ; l_nat := BLCOMMON . GET_RELN_CODE ( :d_patient_id ) ; FOR i IN c\
1 ( l_nat , :d_episode_type ) LOOP l_ctr1 := l_ctr1 + 1 ; if l_ctr1 = 1 then\
 :d_rev_code := i . account_code ; else :d_rev_code := :d_rev_code || ',' ||\
 i . account_code ; end if ; END LOOP ; if :d_rev_code is null then FOR i in\
 c1 ( l_nat , 'U' ) LOOP l_ctr1 := l_ctr1 + 1 ; if l_ctr1 = 1 then :d_rev_co\
de := i . account_code ; else :d_rev_code := :d_rev_code || ',' || i . accou\
nt_code ; end if ; END LOOP ; end if ; if :d_rev_code is null then FOR i in \
c1 ( 'UNRESTRICTED' , :d_episode_type ) LOOP l_ctr1 := l_ctr1 + 1 ; if l_ctr\
1 = 1 then :d_rev_code := i . account_code ; else :d_rev_code := :d_rev_code\
 || ',' || i . account_code ; end if ; E");
 sqlstm.stmt = "ND LOOP ; end if ; if :d_rev_code is null then FOR i in c1 (\
 'UNRESTRICTED' , 'U' ) LOOP l_ctr1 := l_ctr1 + 1 ; if l_ctr1 = 1 then :d_rev_\
code := i . account_code ; else :d_rev_code := :d_rev_code || ',' || i . accou\
nt_code ; end if ; END LOOP ; end if ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )557;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_nature;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_rev_code;
 sqlstm.sqhstl[1] = (unsigned int  )1002;
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
 sqlstm.sqhstv[3] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[3] = (unsigned int  )4;
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

fetch_prog_param()
{
    nd_option.arr[0]	  ='\0';
    nd_fr_date.arr[0]     ='\0'; 
    nd_to_date.arr[0]     ='\0';

    nd_option.len	  = 0;	
    nd_fr_date.len        = 0;
    nd_to_date.len        = 0;
 
    /* EXEC SQL SELECT  PARAM1,PARAM2, PARAM3
             INTO :nd_option,:nd_fr_date, :nd_to_date
             FROM SY_PROG_PARAM
             WHERE PGM_ID   = 'BLR00074'
             AND SESSION_ID = :nd_session_id
             AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 into :b0,:b1,:b2  from SY_P\
ROG_PARAM where ((PGM_ID='BLR00074' and SESSION_ID=:b3) and PGM_DATE=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )588;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_option;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_fr_date;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[3] = (unsigned int  )42;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[4] = (unsigned int  )37;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

	nd_option.arr[nd_option.len]	= '\0';
	nd_fr_date.arr[nd_fr_date.len]	= '\0';
	nd_to_date.arr[nd_to_date.len]	= '\0';

}

end_of_rep()
{   
    fprintf(fp,"\n");
    fprintf(fp,"%105s***  END OF REPORT ***\n\f"," ");

    fprintf(fp,"%c",0x12); /*** Set Dot-matrix Printer to Normal Mode ***/
    
    fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
    strcat(filename,"BLR00074.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00074.lis");
       proc_exit();
    }
}


print_detail()
{ 	
   l_rec_ctr = l_rec_ctr + 1;   
   
   if ( d_doc_status.arr[0] == 'C' )
	d_g_tot_adj_amt = d_g_tot_adj_amt - d_adj_exempt_wo_disc_amt;
   else
	d_g_tot_adj_amt = d_g_tot_adj_amt + d_adj_exempt_wo_disc_amt;

   if (
      ( d_prv_doc_date.arr[0] == '\0' && d_prv_doc_type_code.arr[0] == '\0' 
        && d_prv_doc_num.arr[0] == '\0' && d_prv_doc_status.arr[0] == '\0' ) ||
	( strcmp(d_prv_doc_date.arr,d_doc_date.arr) != 0 && d_prv_doc_date.arr[0] != '\0' ) ||
	( strcmp(d_prv_doc_type_code.arr,d_doc_type_code.arr) != 0 && d_prv_doc_type_code.arr[0] != '\0' ) ||
	( strcmp(d_prv_doc_num.arr,d_doc_num.arr) != 0 && d_prv_doc_num.arr[0] != '\0')||
	( strcmp(d_prv_doc_status.arr,d_doc_status.arr) != 0 && d_prv_doc_status.arr[0] != '\0')	
      )	
      { 
	strcpy(d_prv_doc_date.arr,d_doc_date.arr);
	strcpy(d_prv_doc_type_code.arr,d_doc_type_code.arr);
	strcpy(d_prv_doc_num.arr,d_doc_num.arr);
	strcpy(d_prv_doc_status.arr,d_doc_status.arr);

	if ( l_rec_ctr != 1 )	
	{
	   print_sub_tot();
	}
	d_tot_adj_amt = 0;	

	get_tot_wo_amt(); // Getting total WO Amount.

	d_hdr_srlno = d_hdr_srlno + 1;	
	print_hdr_rec();
	l_line_no++;
	check_page_break();
	
	print_sub_header();
	d_dtl_srlno = 1;
	print_dtl_rec();
	l_line_no++;
	check_page_break();
	
      }

     else
     {	
	strcpy(d_prv_doc_date.arr,d_doc_date.arr);
	strcpy(d_prv_doc_type_code.arr,d_doc_type_code.arr);
	strcpy(d_prv_doc_num.arr,d_doc_num.arr);
	strcpy(d_prv_doc_status.arr,d_doc_status.arr);

	d_dtl_srlno = d_dtl_srlno + 1;

	print_dtl_rec();
	l_line_no++;
	check_page_break();
     }
}

print_hdr_rec()
{
	fprintf(fp,"%5d %-15.15s %-15.15s %-20.20s %-50.50s %-50.50s ",
		d_hdr_srlno,d_doc_date.arr,d_doc_type.arr,d_patient_id.arr,
		d_patient_name.arr,d_reason.arr);
	print_formated(d_doc_amt);

	if ( d_doc_status.arr[0] == 'C' )
		fprintf(fp," %-10.10s %-30.30s \n","CANCELLED",d_opr_id.arr);				
	else
		fprintf(fp," %-10.10s %-30.30s \n",d_doc_status.arr,d_opr_id.arr);				
	
	
}

print_dtl_rec()
{
	d_tot_adj_amt = d_tot_adj_amt + d_adj_exempt_wo_disc_amt;

	fprintf(fp,"%-97.97s"," ");
	fprintf(fp,"%5d %-15.15s %-15.15s ",d_dtl_srlno,d_bill_doc_date.arr,
					    d_bill_doc_type.arr);
	fprintf(fp,"     ");
	print_formated(d_bill_tot_amt);
	fprintf(fp,"      ");
	print_formated(d_adj_exempt_wo_disc_amt);	
	

	fprintf(fp," %-s\n",d_rev_code.arr);	//Revenue Code	  	
	
}

print_sub_tot()
{
	fprintf(fp,"%-97.97s"," ");
	print_line(100);fprintf(fp,"\n");

	fprintf(fp,"%-135.135s "," ");
	fprintf(fp,"%-25.25s",loc_legend[31]);
	print_formated(d_tot_adj_amt);
	fprintf(fp,"\n");
	
	print_line(232);fprintf(fp,"\n");

	l_line_no = l_line_no + 3;
	check_page_break();

}

print_grand_tot()
{	
	fprintf(fp,"%-135.135s "," ");
	fprintf(fp,"%-25.25s",loc_legend[32]);
	print_formated(d_g_tot_adj_amt);
	fprintf(fp,"\n");
	
	print_line(232);fprintf(fp,"\n");

	//l_line_no = l_line_no + 3;
	//check_page_break();

}

print_report()
{
    print_page_title();      
    

    d_prv_doc_date.arr[0] = '\0';
    d_prv_doc_date.len = 0;

    d_prv_doc_type_code.arr[0] = '\0';
    d_prv_doc_type_code.len = 0;

    d_prv_doc_num.arr[0] = '\0';
    d_prv_doc_num.len = 0;
    
    while(fetch_cursors())
    {	
	print_detail();
    }
    print_sub_tot();
    print_grand_tot();

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
    nd_currency.len  = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME, 
	     TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
	     USER, '('||BASE_CURRENCY||')'
             INTO :hosp_name, :date_time, :user_id, :nd_currency
             FROM SY_ACC_ENTITY
	     WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER ,(('('||BASE_CURRENCY)||')') into :b0,:b1,:b2,:b3  from SY_ACC_ENTI\
TY where ACC_ENTITY_ID=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )623;
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
    sqlstm.sqhstl[2] = (unsigned int  )33;
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
	nd_currency.arr[nd_currency.len]       = '\0';
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
	        l_line_no = 0;
		fprintf(fp,"\f\n");
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
    for(i=1;i<40;i++)
	{	
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00074.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		         INTO :l_pk_value
			 FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00074.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )658;
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
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )681;
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
	int    l_page_width;
	
	l_report_width=228;
	get_header_dtls();	

	l_acc_entity_length = strlen(d_acc_entity_name.arr);

	//Code for Line 1
	l_start_point=(l_report_width/2)-(l_acc_entity_length/2);
	//fprintf(fp,"MDL           : BL");
	fprintf(fp,"%-13.13s : BL",loc_legend[1]);
	l_start_point=l_start_point-18;
	print_spaces(l_start_point);
	fprintf(fp,"%-s",d_acc_entity_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(15+strlen(date.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[4],date.arr);

	//Code for Line 2  
	l_start_point=0;

	if (nd_option.arr[0] == 'A')		
		strcpy(l_tit1,loc_legend[7]);
	else if (nd_option.arr[0] == 'W')
		strcpy(l_tit1,loc_legend[8]);
	else if (nd_option.arr[0] == 'E')
		strcpy(l_tit1,loc_legend[9]);
	else if (nd_option.arr[0] == 'D')
		strcpy(l_tit1,loc_legend[10]);


	l_start_point=(l_report_width/2)-((strlen(l_tit1))/2);
	//fprintf(fp,"OPR           : %s",d_user.arr);
	fprintf(fp,"%-13.13s : %s",loc_legend[2],d_user.arr);
	l_start_point=l_start_point-(strlen(d_user.arr)+16);
	print_spaces(l_start_point);

	

	fprintf(fp,"%-s",l_tit1);

	l_comp_name_end_point=l_start_point+(strlen(d_user.arr)+16)+strlen(l_tit1);
	l_start_point=(l_report_width-(17+strlen(date_time.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp," %-15.15s : %s\n",loc_legend[5],date_time.arr);

	//Code for Line 3

	l_start_point=0;
	l_from_and_to_date.arr[0] = '\0';
	
	if (l_page_no != 0 )
	{

		/* EXEC SQL SELECT :loc_legend[11]||' '||:nd_fr_date ||' '|| :loc_legend[12] ||' '|| :nd_to_date
			 INTO :l_from_and_to_date
			 FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select ((((((:b0||' ')||:b1)||' ')||:b2)||' ')||:b3) into :\
b4  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )712;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)loc_legend[11];
  sqlstm.sqhstl[0] = (unsigned int  )201;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_fr_date;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)loc_legend[12];
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
  sqlstm.sqhstl[4] = (unsigned int  )73;
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
	}

	l_start_point=(l_report_width/2)-((strlen(l_from_and_to_date.arr))/2);
	fprintf(fp,"%-14.14s: BLR00074",loc_legend[3]);
	l_start_point=l_start_point-24;
	print_spaces(l_start_point);
	fprintf(fp,"%-s",l_from_and_to_date.arr);
	l_comp_name_end_point=l_start_point+24+strlen(l_from_and_to_date.arr);
	l_start_point=(l_report_width-(17+7)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %d\n",loc_legend[6],++l_page_no);	
		
	l_line_no= l_line_no + 3;
	print_page_header();	
}  

print_page_header()
{	
	int k = 0;

	print_line(232);   
	fprintf(fp,"\n");  

	if (l_page_no == 1)
	{
		fprintf(fp,"VER		: 4.1\n\n\n\n");	
		fprintf(fp,"		INPUT PARAMETER\n");	
		fprintf(fp,"		---------------\n\n");	
		if (nd_option.arr[0] == 'A')
		fprintf(fp,"			OPTION		: Adjustment\n");	
		else if (nd_option.arr[0] == 'E')
		fprintf(fp,"			OPTION		: Exemption\n");	
		else if (nd_option.arr[0] == 'W')
		fprintf(fp,"			OPTION		: Write-off\n");	
		else if (nd_option.arr[0] == 'D')
		fprintf(fp,"			OPTION		: Discount\n");	
		
		fprintf(fp,"			FROM DATE	: %s\n",nd_fr_date.arr);	
		fprintf(fp,"			TO DATE	        : %s\n",nd_to_date.arr);	

		l_line_no = 60;
		check_page_break();
	}
	else
	{
		fprintf(fp,"%5.5s %-15.15s %-15.15s %-20.20s %-50.50s %-50.50s %15.15s %-10.10s %-30.30s %-12.12s\n",
		loc_legend[13],loc_legend[14],loc_legend[15],loc_legend[16],loc_legend[17],loc_legend[18],loc_legend[19],
		loc_legend[20], loc_legend[21],loc_legend[22],loc_legend[23]);		

		fprintf(fp,"%5.5s %-15.15s %-15.15s %-20.20s %-50.50s %-50.50s %15.15s %-10.10s %-30.30s %-12.12s\n",
		"","","","","","",nd_currency.arr,"","","","");		

		print_line(232);
		fprintf(fp,"\n");
		l_line_no = l_line_no+4;		
		
	}
}


print_sub_header()
{	
	fprintf(fp,"%-97.97s"," ");
	print_line(100);fprintf(fp,"\n");

	if ( nd_option.arr[0] == 'A')
		strcpy(loc_legend_26_27_28_29,loc_legend[26]);
	else if ( nd_option.arr[0] == 'W')
		strcpy(loc_legend_26_27_28_29,loc_legend[27]);
	else if ( nd_option.arr[0] == 'E')
		strcpy(loc_legend_26_27_28_29,loc_legend[28]);
	else if ( nd_option.arr[0] == 'D')
		strcpy(loc_legend_26_27_28_29,loc_legend[29]);

	fprintf(fp,"%-97.97s"," ");
	fprintf(fp,"%5.5s %-15.15s %-15.15s %20.20s %20.20s %-20.20s\n",
		loc_legend[13],loc_legend[23],loc_legend[24],loc_legend[25],loc_legend_26_27_28_29,loc_legend[30]);		

	fprintf(fp,"%-97.97s"," ");
	print_line(100);fprintf(fp,"\n");
	l_line_no = l_line_no+3;
	check_page_break();
	
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
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY\
 HH24:MI') ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') into \
:b0,:b1,:b2,:b3,:b4  from SY_ACC_ENTITY where acc_entity_id=:b5";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )747;
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
    sqlstm.sqhstl[1] = (unsigned int  )33;
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
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )786;
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



