
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00043.PC"
};


static unsigned int sqlctx = 1288460915;


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
            void  *sqhstv[13];
   unsigned int   sqhstl[13];
            int   sqhsts[13];
            void  *sqindv[13];
            int   sqinds[13];
   unsigned int   sqharm[13];
   unsigned int   *sqharc[13];
   unsigned short  sqadto[13];
   unsigned short  sqtdso[13];
} sqlstm = {12,13};

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
"sode_id(+)) and a.patient_id=c.patient_id(+)) and a.episode_type=decode(:b9,\
'A',a.episode_type,:b9)) and a.blng_grp_id=d.blng_grp_id(+)) and nvl(a.bill_st\
atus,'X')<>'C') and ((:b11 in ('R','B') and BILL_TOT_OUTST_AMT>0) or (:b11 in \
('F','B') and BILL_TOT_OUTST_AMT<0))) order by BLNG_GRP_CATG,nvl(a.bed_class_c\
ode,c.cur_bed_class_code)            ";

 static const char *sq0005 = 
"select to_char(reminder_dispatched_date,'dd/mm/yyyy')  from BL_BILLS_FOR_REM\
INDER where ((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) and nvl(REMINDER_NOT_DELIVERE\
D_YN,'N')='N')           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,91,0,2,183,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,192,0,0,0,0,0,1,0,
43,0,0,0,0,0,27,200,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
74,0,0,4,1371,0,9,283,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
141,0,0,4,0,0,13,330,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,
4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
204,0,0,5,179,0,9,363,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
227,0,0,5,0,0,15,374,0,0,0,0,0,1,0,
242,0,0,5,0,0,13,388,0,0,1,0,0,1,0,2,9,0,0,
261,0,0,6,217,0,4,418,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
324,0,0,7,69,0,4,466,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
347,0,0,8,147,0,4,628,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
382,0,0,9,96,0,4,693,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
405,0,0,10,165,0,6,700,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
436,0,0,11,38,0,4,739,0,0,2,1,0,1,0,1,4,0,0,2,4,0,0,
459,0,0,12,38,0,4,766,0,0,2,1,0,1,0,1,4,0,0,2,4,0,0,
482,0,0,13,87,0,4,785,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
509,0,0,14,78,0,4,794,0,0,6,5,0,1,0,1,9,0,0,1,97,0,0,1,9,0,0,1,97,0,0,1,9,0,0,
2,9,0,0,
548,0,0,15,38,0,4,803,0,0,2,1,0,1,0,1,4,0,0,2,4,0,0,
571,0,0,16,73,0,4,821,0,0,5,4,0,1,0,1,97,0,0,1,9,0,0,1,97,0,0,1,9,0,0,2,9,0,0,
606,0,0,17,38,0,4,828,0,0,2,1,0,1,0,1,4,0,0,2,4,0,0,
629,0,0,18,198,0,4,987,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
668,0,0,19,0,0,32,1010,0,0,0,0,0,1,0,
};


	
/************************************************************************/
/* PROGRAM NAME          : BLR00043.PC                                  */
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
#define RESOURCE_BUSY (sqlca.sqlcode == -54)
#define DUPLICATE_KEY (sqlca.sqlcode == -1)
#define	MAX_LINES	60
#define ESC     0x1B

#define INIT_MESG "Report Generation is in progress"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR			uid_pwd					[132],
			hosp_name				[120],
			date_time				[30],
			user_id					[20],
			nd_pgm_date				[35],
			ND_FM_BLNG_GRP_CATG     [41],
			ND_TO_BLNG_GRP_CATG     [41],
			ND_TO_WARD_CODE         [5],
			ND_FM_WARD_CODE         [5],
			ND_FM_BED_CLASS         [3],
			ND_TO_BED_CLASS         [3],
			nd_facility_name			[31],
			nd_session_id				[16],
			nd_facility_id				[3],
			d_acc_entity_name			[41],
			d_user					[21],
			d_sysdate				[17],
			date					[20]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[30]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[41]; } ND_FM_BLNG_GRP_CATG;

struct { unsigned short len; unsigned char arr[41]; } ND_TO_BLNG_GRP_CATG;

struct { unsigned short len; unsigned char arr[5]; } ND_TO_WARD_CODE;

struct { unsigned short len; unsigned char arr[5]; } ND_FM_WARD_CODE;

struct { unsigned short len; unsigned char arr[3]; } ND_FM_BED_CLASS;

struct { unsigned short len; unsigned char arr[3]; } ND_TO_BED_CLASS;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[20]; } date;

			
            
/* VARCHAR		nd_lang_id					[4],
		nd_currency[10]; */ 
struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[10]; } nd_currency;


int dt_len = 0, r_ctr = 0;

double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;	


/* VARCHAR		l_pk_value				[200],
		l_translated_value			[201],
		l_heading_str				[81],
		l_from_and_to_date			[41]; */ 
struct { unsigned short len; unsigned char arr[200]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[81]; } l_heading_str;

struct { unsigned short len; unsigned char arr[41]; } l_from_and_to_date;


/* VARCHAR		nd_episode_type					[2],
    		nd_from_date					[30],
    		nd_end_date					[30],
		d_doc_type_code	[30],
		d_doc_num[30],
		nd_bill_option					[10],
		p_language_id               [3]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[30]; } nd_from_date;

struct { unsigned short len; unsigned char arr[30]; } nd_end_date;

struct { unsigned short len; unsigned char arr[30]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[30]; } d_doc_num;

struct { unsigned short len; unsigned char arr[10]; } nd_bill_option;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;



/* VARCHAR		d_bill_doc					[31],
		d_bill_doc_type_code				[20],
		d_bill_doc_num					[20],
		d_bill_date					[31],
    		d_national_id_num				[31],
    		d_blng_grp_catg					[5],
		d_prv_blng_grp_catg				[5],
    		d_bed_class_code				[3],
		d_prev_bed_class				[3],    		
		d_patient_name					[61],
		d_patient_id					[21],
		d_episode_id					[11],
		d_visit_id					[10],
		d_blng_grp_catg_desc				[41],
    		d_reminder_dispatched_date			[31]; */ 
struct { unsigned short len; unsigned char arr[31]; } d_bill_doc;

struct { unsigned short len; unsigned char arr[20]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[20]; } d_bill_doc_num;

struct { unsigned short len; unsigned char arr[31]; } d_bill_date;

struct { unsigned short len; unsigned char arr[31]; } d_national_id_num;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_catg;

struct { unsigned short len; unsigned char arr[5]; } d_prv_blng_grp_catg;

struct { unsigned short len; unsigned char arr[3]; } d_bed_class_code;

struct { unsigned short len; unsigned char arr[3]; } d_prev_bed_class;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[11]; } d_episode_id;

struct { unsigned short len; unsigned char arr[10]; } d_visit_id;

struct { unsigned short len; unsigned char arr[41]; } d_blng_grp_catg_desc;

struct { unsigned short len; unsigned char arr[31]; } d_reminder_dispatched_date;

	char	d_reminder_dispatched_date_arr			[11][20];

char		loc_legend					[40][201],
		loc_legend_1					[200],
		l_str1[100],
		l_str2[100],
		l_str3[100],
		l_mesg[1000];


   
double		d_bill_amt,  d_net_settled_amt,  d_outstdg_amt,tot_d_outstdg_amt=0;

int l_line_no =0;
int l_page_no =0;
int i,l_rec_ctr = 0;  
int srlno =1;

/* VARCHAR 	l_fr_ward_code				[6],
			l_sysdate			[20],
			l_hospital_name			[50]; */ 
struct { unsigned short len; unsigned char arr[6]; } l_fr_ward_code;

struct { unsigned short len; unsigned char arr[20]; } l_sysdate;

struct { unsigned short len; unsigned char arr[50]; } l_hospital_name;



char filename[200];
char string_var[200];

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
    
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;

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

    fetch_prog_param();

    fetch_hosp_name();

    declare_cursors();

    open_file();

	fetch_legend_value();
    
	print_report();

    end_of_rep();

	/* EXEC SQL DELETE SY_PROG_PARAM
            WHERE PGM_ID   = 'BLR00043'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLR00043' and SE\
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
   
   /*
	EXEC SQL DECLARE UNSTLD_BILLS_IP CURSOR FOR 
		 select a.doc_type_code||'/'||a.doc_num  bill_doc,
			to_char(a.doc_date,'dd/mm/yyyy') bill_date,
			NVL(b.national_id_num,b.alternate_id_num),
			a.bill_tot_amt, 
			nvl(bill_paid_amt,0) net_settled_amt,
			a.BILL_TOT_OUTST_AMT outstdg_amt, 
			d.BLNG_GRP_CATG, 
			nvl(a.bed_class_code,c.cur_bed_class_code),
			a.patient_id ,
			a.EPISODE_ID||' '||decode(a.visit_id,0,'',a.visit_id),
			a.doc_type_code,
			a.doc_num
		from 	bl_bill_dcp_dtl_vw a, 
			mp_patient_mast b, 
			bl_encounter_for_qry_vw c, 
			bl_blng_grp_by_catg d
		where   a.operating_facility_id = :nd_facility_id
		and 	a.doc_date between to_date(nvl(:nd_from_date,'01/01/1900')||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
			and to_date(nvl(:nd_end_date,'31/12/4000')||' 23:59:59','dd/mm/yyyy hh24:mi:ss')
		and     a.patient_id = b.patient_id
		and     a.operating_facility_id = c.facility_id(+)		
		and 	a.episode_type = c.episode_type(+)
		and 	a.episode_id = c.episode_id(+)
		and 	nvl(a.visit_id,9999) = nvl(c.visit_id(+),9999)
		and     a.episode_type = decode(:nd_episode_type,'A', a.episode_type, :nd_episode_type)
		and 	a.blng_grp_id = d.blng_grp_id(+)					
		and	nvl(a.bill_status,'X') != 'C'
		and 	(( :nd_bill_option in ('R','B') and BILL_TOT_OUTST_AMT > 0)
		         or ( :nd_bill_option in ('F','B') and BILL_TOT_OUTST_AMT < 0)
			 )		
		 order by BLNG_GRP_CATG, nvl(a.bed_class_code,c.cur_bed_class_code);
		 */

		 /* EXEC SQL DECLARE UNSTLD_BILLS_IP CURSOR FOR 
		 select a.doc_type_code||'/'||a.doc_num  bill_doc,
			to_char(a.doc_date,'dd/mm/yyyy') bill_date,
			NVL(b.national_id_num,b.alternate_id_num),
			a.bill_tot_amt, 
			nvl(bill_paid_amt,0) net_settled_amt,
			a.BILL_TOT_OUTST_AMT outstdg_amt, 
			d.BLNG_GRP_CATG, 
			nvl(a.bed_class_code,c.cur_bed_class_code),
			a.patient_id ,
			a.EPISODE_ID||' '||decode(a.visit_id,0,'',a.visit_id),
			a.doc_type_code,
			a.doc_num
		from 	bl_bill_dcp_dtl_vw a, 
			mp_patient_mast b, 
			ip_episode c, 
			bl_blng_grp_by_catg d
		where   a.operating_facility_id = :nd_facility_id
		AND     nvl(c.cur_bed_class_code,'1') BETWEEN nvl(:ND_FM_BED_CLASS,'!!') AND nvl(:ND_TO_BED_CLASS, '~~')  /o CRF-350.o/
		AND     nvl(c.cur_ward_code,'1') BETWEEN nvl(:ND_FM_WARD_CODE,'!!!!') AND nvl(:ND_TO_WARD_CODE,'~~~~')   /o CRF-350.o/
		AND     nvl(d.blng_grp_catg,'1') BETWEEN nvl(:ND_FM_BLNG_GRP_CATG,'!!!!!!!!!!!!') AND nvl(:ND_TO_BLNG_GRP_CATG,'~~~~~~~~~~~~')  /o CRF-350.o/
		and 	a.doc_date between to_date(nvl(:nd_from_date,'01/01/1900')||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
			and to_date(nvl(:nd_end_date,'31/12/4000')||' 23:59:59','dd/mm/yyyy hh24:mi:ss')
		and     a.patient_id = b.patient_id
		and     a.operating_facility_id = c.facility_id(+)				
		and 	a.episode_id = c.episode_id(+)		
		and	a.patient_id = c.patient_id(+)
		and     a.episode_type = decode(:nd_episode_type,'A', a.episode_type, :nd_episode_type)
		and 	a.blng_grp_id = d.blng_grp_id(+)					
		and	nvl(a.bill_status,'X') != 'C'
		and 	(( :nd_bill_option in ('R','B') and BILL_TOT_OUTST_AMT > 0)
		         or ( :nd_bill_option in ('F','B') and BILL_TOT_OUTST_AMT < 0)
			 )		
		 order by BLNG_GRP_CATG, nvl(a.bed_class_code,c.cur_bed_class_code); */ 




/* EXEC SQL OPEN UNSTLD_BILLS_IP; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 13;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlbuft((void **)0, 
  "select ((a.doc_type_code||'/')||a.doc_num) bill_doc ,to_char(a.doc_date,'\
dd/mm/yyyy') bill_date ,NVL(b.national_id_num,b.alternate_id_num) ,a.bill_to\
t_amt ,nvl(bill_paid_amt,0) net_settled_amt ,a.BILL_TOT_OUTST_AMT outstdg_am\
t ,d.BLNG_GRP_CATG ,nvl(a.bed_class_code,c.cur_bed_class_code) ,a.patient_id\
 ,((a.EPISODE_ID||' ')||decode(a.visit_id,0,'',a.visit_id)) ,a.doc_type_code\
 ,a.doc_num  from bl_bill_dcp_dtl_vw a ,mp_patient_mast b ,ip_episode c ,bl_\
blng_grp_by_catg d where ((((((((((((a.operating_facility_id=:b0 and nvl(c.c\
ur_bed_class_code,'1') between nvl(:b1,'!!') and nvl(:b2,'~~')) and nvl(c.cu\
r_ward_code,'1') between nvl(:b3,'!!!!') and nvl(:b4,'~~~~')) and nvl(d.blng\
_grp_catg,'1') between nvl(:b5,'!!!!!!!!!!!!') and nvl(:b6,'~~~~~~~~~~~~')) \
and a.doc_date between to_date((nvl(:b7,'01/01/1900')||' 00:00:00'),'dd/mm/y\
yyy hh24:mi:ss') and to_date((nvl(:b8,'31/12/4000')||' 23:59:59'),'dd/mm/yyy\
y hh24:mi:ss')) and a.patient_id=b.patient_id) and a.operating_facility_id=c\
.facility_id(+)) and a.episode_id=c.epi");
sqlstm.stmt = sq0004;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )74;
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
sqlstm.sqhstv[1] = (         void  *)&ND_FM_BED_CLASS;
sqlstm.sqhstl[1] = (unsigned int  )5;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&ND_TO_BED_CLASS;
sqlstm.sqhstl[2] = (unsigned int  )5;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&ND_FM_WARD_CODE;
sqlstm.sqhstl[3] = (unsigned int  )7;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&ND_TO_WARD_CODE;
sqlstm.sqhstl[4] = (unsigned int  )7;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&ND_FM_BLNG_GRP_CATG;
sqlstm.sqhstl[5] = (unsigned int  )43;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&ND_TO_BLNG_GRP_CATG;
sqlstm.sqhstl[6] = (unsigned int  )43;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&nd_from_date;
sqlstm.sqhstl[7] = (unsigned int  )32;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&nd_end_date;
sqlstm.sqhstl[8] = (unsigned int  )32;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)&nd_episode_type;
sqlstm.sqhstl[9] = (unsigned int  )4;
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
sqlstm.sqhstv[11] = (         void  *)&nd_bill_option;
sqlstm.sqhstl[11] = (unsigned int  )12;
sqlstm.sqhsts[11] = (         int  )0;
sqlstm.sqindv[11] = (         void  *)0;
sqlstm.sqinds[11] = (         int  )0;
sqlstm.sqharm[11] = (unsigned int  )0;
sqlstm.sqadto[11] = (unsigned short )0;
sqlstm.sqtdso[11] = (unsigned short )0;
sqlstm.sqhstv[12] = (         void  *)&nd_bill_option;
sqlstm.sqhstl[12] = (unsigned int  )12;
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
	  err_mesg("OPEN failed on cursor UNSTLD_BILLS_IP",0,"");


/* EXEC SQL DECLARE REM_DETAILS CURSOR FOR
	SELECT to_char(reminder_dispatched_date,'dd/mm/yyyy') 
	FROM BL_BILLS_FOR_REMINDER
	WHERE DOC_TYPE_CODE = :d_doc_type_code
	and DOC_NUM = :d_doc_num
	and nvl(REMINDER_NOT_DELIVERED_YN,'N') = 'N'; */ 


}

fetch_cursor()
{
    d_bill_doc.arr[0]        = '\0';
    d_national_id_num.arr[0]        = '\0';
    d_blng_grp_catg.arr[0]       = '\0';
    d_bed_class_code.arr[0]        = '\0';
    d_reminder_dispatched_date.arr[0]           = '\0';
    d_bill_date.arr[0]         ='\0';    
    d_episode_id.arr[0]        = '\0';
    d_visit_id.arr[0] = '\0';

    d_patient_id.arr[0]        = '\0';
    d_doc_type_code.arr[0]	= '\0';
    d_doc_num.arr[0]		= '\0';

    d_bill_doc.len           = 0;
    d_national_id_num.len           = 0;
    d_blng_grp_catg.len          = 0;
    d_bed_class_code.len           = 0;    
    d_reminder_dispatched_date.len              = 0;
    d_bill_date.len              = 0;
    d_episode_id.len            =0;
    d_visit_id.len = 0;
    d_patient_id.len            =0;
    d_doc_type_code.len = 0;
    d_doc_num.len       = 0;

    d_bill_amt         = 0;
    d_net_settled_amt  = 0;
    d_outstdg_amt      = 0;
	

    /* EXEC SQL FETCH UNSTLD_BILLS_IP  
	     INTO  
		:d_bill_doc,
		:d_bill_date,
		:d_national_id_num,
		:d_bill_amt, 
		:d_net_settled_amt,
		:d_outstdg_amt, 
		:d_blng_grp_catg,
		:d_bed_class_code,
		:d_patient_id,
		:d_episode_id,
		:d_doc_type_code,
		:d_doc_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )141;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_bill_doc;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_bill_date;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_national_id_num;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_bill_amt;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_net_settled_amt;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_outstdg_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_blng_grp_catg;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_bed_class_code;
    sqlstm.sqhstl[7] = (unsigned int  )5;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[9] = (unsigned int  )13;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_doc_type_code;
    sqlstm.sqhstl[10] = (unsigned int  )32;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_doc_num;
    sqlstm.sqhstl[11] = (unsigned int  )32;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
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
	err_mesg("FETCH failed on cursor UNSTLD_BILLS_IP",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_bill_doc.arr[d_bill_doc.len]               = '\0';
    d_national_id_num.arr[d_national_id_num.len]               = '\0';
    d_blng_grp_catg.arr[d_blng_grp_catg.len]               = '\0';
    d_bed_class_code.arr[d_bed_class_code.len]     = '\0';
    d_reminder_dispatched_date.arr[d_reminder_dispatched_date.len]                 = '\0';
    d_bill_date.arr[d_bill_date.len]  = '\0';
    d_patient_id.arr[d_patient_id.len]  = '\0';
    d_episode_id.arr[d_episode_id.len]  = '\0';
    d_visit_id.arr[d_visit_id.len] = '\0';
    d_doc_type_code.arr[d_doc_type_code.len] = '\0';
    d_doc_num.arr[d_doc_num.len] = '\0';

    /* EXEC SQL OPEN REM_DETAILS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )204;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
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


     if(OERROR)	   
     err_mesg("OPEN failed on cursor REM_DETAILS",0,"");

     i=1;
     while(fetch_rem_dtls())
     {
	strcpy(d_reminder_dispatched_date_arr[i],d_reminder_dispatched_date.arr);	
	i++;
     }     	

     /* EXEC SQL CLOSE REM_DETAILS; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 13;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )227;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     if(OERROR)	   
     err_mesg("CLOSE failed on cursor REM_DETAILS",0,"");
   
    return 1;
}

fetch_rem_dtls()
{
    d_reminder_dispatched_date.arr[0]	= '\0';
    d_reminder_dispatched_date.len	= 0;


    
	/* EXEC SQL FETCH REM_DETAILS 
	INTO  :d_reminder_dispatched_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )242;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_reminder_dispatched_date;
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
	err_mesg("FETCH failed on cursor fetch_rem_dtls",0,"");

	if(NO_DATA_FOUND)
	return 0;
	
    d_reminder_dispatched_date.arr[d_reminder_dispatched_date.len] = '\0';
   
    return 1;

}

fetch_prog_param()
{
    
    nd_episode_type.arr[0]		='\0'; 
    nd_from_date.arr[0]			='\0';
    nd_end_date.arr[0]			='\0';
    nd_bill_option.arr[0]		='\0';
  
    nd_episode_type.len         = 0;
    nd_from_date.len		= 0;
    nd_end_date.len		= 0;
    nd_bill_option.len		= 0;
 
 
   /* EXEC SQL SELECT  PARAM1,PARAM2,PARAM3, PARAM4, PARAM5, PARAM6, PARAM7, PARAM8, PARAM9, PARAM10
            INTO    :nd_episode_type, :nd_from_date,:nd_end_date, :nd_bill_option, :ND_FM_BLNG_GRP_CATG, :ND_TO_BLNG_GRP_CATG,
					:ND_FM_WARD_CODE, :ND_TO_WARD_CODE, :ND_FM_BED_CLASS, :ND_TO_BED_CLASS
            FROM	SY_PROG_PARAM
            WHERE	PGM_ID   = 'BLR00043'
            AND		SESSION_ID = :nd_session_id
            AND		PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,PARAM8 ,PARAM9 ,PARAM10 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9  fro\
m SY_PROG_PARAM where ((PGM_ID='BLR00043' and SESSION_ID=:b10) and PGM_DATE=:b\
11)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )261;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_from_date;
   sqlstm.sqhstl[1] = (unsigned int  )32;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_end_date;
   sqlstm.sqhstl[2] = (unsigned int  )32;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_bill_option;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&ND_FM_BLNG_GRP_CATG;
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&ND_TO_BLNG_GRP_CATG;
   sqlstm.sqhstl[5] = (unsigned int  )43;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&ND_FM_WARD_CODE;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&ND_TO_WARD_CODE;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&ND_FM_BED_CLASS;
   sqlstm.sqhstl[8] = (unsigned int  )5;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&ND_TO_BED_CLASS;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[10] = (unsigned int  )18;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[11] = (unsigned int  )37;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
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
	nd_from_date.arr[nd_from_date.len]	= '\0';
	nd_end_date.arr[nd_end_date.len] = '\0';
	nd_bill_option.arr[nd_bill_option.len] = '\0';
	
}  

end_of_rep()  
{
	fprintf(fp,"\n%55s***  END OF REPORT ***\n\f"," ");
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00043.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00043.lis");
       proc_exit();
    }
}



print_detail()
{

       d_patient_name.arr[0] = '\0';
       d_patient_name.len    = 0;

       /* EXEC SQL select short_name 
                into   :d_patient_name
		from   mp_patient_mast
 		where  PATIENT_ID = :d_patient_id; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 13;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select short_name into :b0  from mp_patient_mast where\
 PATIENT_ID=:b1";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )324;
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



	d_patient_name.arr[d_patient_name.len]  ='\0';

        fprintf(fp,"%5d %-20.20s %-15.15s %-30.30s ",
		    srlno,d_patient_id.arr, d_bill_doc.arr, d_national_id_num.arr);
	
	print_formated(d_bill_amt);
	fprintf(fp," ");
	print_formated(d_net_settled_amt);
	fprintf(fp,"   ");
	print_formated(d_outstdg_amt);
	tot_d_outstdg_amt=tot_d_outstdg_amt+d_outstdg_amt;
        fprintf(fp,"%-10.10s \n",d_reminder_dispatched_date_arr[1]);	

	fprintf(fp,"%5.5s %-20.20s %-15.15s %-79.79s ", 
        	" ",d_episode_id.arr,d_bill_date.arr, d_patient_name.arr);

	
	//fprintf(fp,"                 ");	
	//fprintf(fp,"                 ");
	//fprintf(fp,"               ");
        fprintf(fp,"%-10.10s \n",d_reminder_dispatched_date_arr[2]);
	
	l_line_no++;		
	l_line_no++;	
	check_page_break();

	for (i=3;i<=10;i++)
	{
	if (d_reminder_dispatched_date_arr[i][0] != '\0' )
	{
		fprintf(fp,"%5.5s %-20.20s %-15.15s %-30.30s ", 
			" ","","","");

		
		fprintf(fp,"                 ");	
		fprintf(fp,"                 ");
		fprintf(fp,"               ");
		fprintf(fp,"%-10.10s \n",d_reminder_dispatched_date_arr[i]);	

		l_line_no++;		
		check_page_break();
	}

	}
	srlno++;
	for (i=1;i<=10; i++)
	{	
		d_reminder_dispatched_date_arr[i][0] = '\0';
	}	
	
}

print_report()
{  
	d_prev_bed_class.arr[0] = '\0';
	d_prev_bed_class.len = 0;	
        d_prv_blng_grp_catg.arr[0] = '\0';
	d_prv_blng_grp_catg.len=0;

	for (i=1;i<=10; i++)
	{	
		d_reminder_dispatched_date_arr[i][0] = '\0';
	}	

	while(fetch_cursor())
	{  
	   l_rec_ctr = l_rec_ctr + 1;


	   if (d_prv_blng_grp_catg.arr[0] == '\0')
	   {
		   if (d_blng_grp_catg.arr[0] != '\0')
			{strcpy( d_prv_blng_grp_catg.arr,d_blng_grp_catg.arr);
			 strcpy( d_prev_bed_class.arr,d_bed_class_code.arr);
			 
			 d_prv_blng_grp_catg.len = strlen(d_prv_blng_grp_catg.arr);
			 d_prev_bed_class.len = strlen(d_prev_bed_class.arr);


			 l_line_no=0;
			 
			 print_page_title();
			 print_detail();
			}
			else
			 print_detail();
	      }
        
	      else
	      {
		   
		   if (strcmp(d_prv_blng_grp_catg.arr,d_blng_grp_catg.arr) != 0)
		      {
			    strcpy(d_prv_blng_grp_catg.arr,d_blng_grp_catg.arr);
			    d_prv_blng_grp_catg.len = strlen(d_prv_blng_grp_catg.arr);
               
			   srlno=0;
			   fprintf(fp,"\n%84s%24s"," ",loc_legend[26]);
			   print_formated(tot_d_outstdg_amt);
              
			
		   		fprintf(fp,"\f\n");
				tot_d_outstdg_amt=0;
				l_line_no=0;
				srlno=1;
				print_page_title();  
				print_detail();
                   }
		   else 
		    if (strcmp(d_prev_bed_class.arr, d_bed_class_code.arr) != 0)
		     {  strcpy(d_prev_bed_class.arr,d_bed_class_code.arr);

			d_prev_bed_class.len = strlen(d_prev_bed_class.arr);

           
			 			   srlno=0;
			   fprintf(fp,"\n%84s%24s"," ",loc_legend[26]);
			   print_formated(tot_d_outstdg_amt);
			  
				fprintf(fp,"\f\n");
				tot_d_outstdg_amt=0;
				l_line_no=0;
				srlno=1;
				print_page_title();  
				print_detail();
		     }
           else
           if ((strcmp(d_prev_bed_class.arr, d_bed_class_code.arr) == 0) &&  (strcmp(d_prv_blng_grp_catg.arr,d_blng_grp_catg.arr) == 0))
		      print_detail();
		  }
	} 



	if (l_rec_ctr == 0 ) 
	{
		print_page_title();  
	}

              fprintf(fp,"\n%84s%24s"," ",loc_legend[26]);
			 print_formated(tot_d_outstdg_amt);
			   	
//fprintf(fp,"								                   Total Outstanding Amount: ");
//print_formated(tot_d_outstdg_amt);	
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
	 USER, BASE_CURRENCY
         INTO :hosp_name, :date_time, :user_id, :nd_currency
         FROM SY_ACC_ENTITY
	 WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER ,BASE_CURRENCY into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY where ACC_E\
NTITY_ID=:b4";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )347;
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
    sqlstm.sqhstl[1] = (unsigned int  )32;
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
	  //  strcat(s_amt,"-");
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
    for(i=1;i<50;i++)
	{	l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00043.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		         INTO :l_pk_value
				 FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00043.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )382;
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
							:p_language_id);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )405;
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
	/*
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;	
	*/

	int l_page_width;
	
	l_report_width=132;

	get_header_dtls();

	l_acc_entity_length = strlen(d_acc_entity_name.arr);

	//Code for Line 1

	l_start_point=(l_report_width/2)-(l_acc_entity_length/2);

	/* exec sql select round(:l_start_point) into :l_start_point from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select round(:b0) into :b0  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )436;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_start_point;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_start_point;
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

	if ( nd_episode_type.arr[0] == 'I' || nd_episode_type.arr[0] == 'D' )
		strcpy(loc_legend_1,loc_legend[1]);
	else if ( nd_episode_type.arr[0] == 'O')
		strcpy(loc_legend_1,loc_legend[22]);
	else if ( nd_episode_type.arr[0] == 'E')		
		strcpy(loc_legend_1,loc_legend[23]);
	else if ( nd_episode_type.arr[0] == 'R')		
		strcpy(loc_legend_1,loc_legend[24]);
	else if ( nd_episode_type.arr[0] == 'A')
		strcpy(loc_legend_1,loc_legend[25]);

	l_start_point=(l_report_width/2)-((strlen(loc_legend_1))/2);

	/* exec sql select round(:l_start_point) into :l_start_point from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select round(:b0) into :b0  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )459;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_start_point;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_start_point;
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



	fprintf(fp,"OPR           : %s",d_user.arr);
	l_start_point=l_start_point-(strlen(d_user.arr)+16);
	print_spaces(l_start_point);	
	fprintf(fp,"%s",loc_legend_1);	
	l_comp_name_end_point=l_start_point+(strlen(d_user.arr)+16)+strlen(loc_legend_1);
	l_start_point=(l_report_width-(17+strlen(date_time.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[12],date_time.arr);

	//Code for Line 3
	l_start_point=0;
        l_heading_str.arr[0] = '\0';
	l_heading_str.len=0;

        d_blng_grp_catg_desc.arr[0] = '\0';
	d_blng_grp_catg_desc.len    = 0;

	/* EXEC SQL select :d_blng_grp_catg||' '||short_desc 
	     into   :d_blng_grp_catg_desc
	     from   bl_blng_grp_catg
	     where  blng_grp_catg = :d_blng_grp_catg; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ((:b0||' ')||short_desc) into :b1  from bl_blng_grp_c\
atg where blng_grp_catg=:b0";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )482;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_catg;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_catg_desc;
 sqlstm.sqhstl[1] = (unsigned int  )43;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_blng_grp_catg;
 sqlstm.sqhstl[2] = (unsigned int  )7;
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



	d_blng_grp_catg_desc.arr[d_blng_grp_catg_desc.len];

	if (l_page_no > 0)
	{
	/* EXEC SQL SELECT DECODE(:d_bed_class_code,' ','',						
		 :loc_legend[17]|| :d_bed_class_code ||' ' )||:loc_legend[18] || :d_blng_grp_catg_desc
	         INTO :l_heading_str FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ((DECODE(:b0,' ','',((:b1||:b0)||' '))||:b3)||:b4) in\
to :b5  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )509;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_bed_class_code;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)loc_legend[17];
 sqlstm.sqhstl[1] = (unsigned int  )201;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_bed_class_code;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)loc_legend[18];
 sqlstm.sqhstl[3] = (unsigned int  )201;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_blng_grp_catg_desc;
 sqlstm.sqhstl[4] = (unsigned int  )43;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_heading_str;
 sqlstm.sqhstl[5] = (unsigned int  )83;
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

	l_heading_str.arr[l_heading_str.len] = '\0';

	l_start_point=(l_report_width/2)-((strlen(l_heading_str.arr))/2);

	/* exec sql select round(:l_start_point) into :l_start_point from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select round(:b0) into :b0  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )548;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_start_point;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_start_point;
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



	fprintf(fp,"%-14.14s: BLR00043",loc_legend[14]);
	l_start_point=l_start_point-24;
	print_spaces(l_start_point);
	fprintf(fp,"%s",l_heading_str.arr);
	l_comp_name_end_point=l_start_point+24+(strlen(l_heading_str.arr));
	l_start_point=(l_report_width-(15+10)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %d\n",loc_legend[13],++l_page_no);


	//Code for Line 4


        l_from_and_to_date.arr[0] = '\0';
	l_from_and_to_date.len = 0;

	/* EXEC SQL SELECT :loc_legend[19]||' '|| :nd_from_date || ' ' ||:loc_legend[20]||' '|| :nd_end_date
                 INTO :l_from_and_to_date FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ((((((:b0||' ')||:b1)||' ')||:b2)||' ')||:b3) into :b\
4  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )571;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)loc_legend[19];
 sqlstm.sqhstl[0] = (unsigned int  )201;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_from_date;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)loc_legend[20];
 sqlstm.sqhstl[2] = (unsigned int  )201;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_end_date;
 sqlstm.sqhstl[3] = (unsigned int  )32;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_from_and_to_date;
 sqlstm.sqhstl[4] = (unsigned int  )43;
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

	/* exec sql select round(:l_start_point) into :l_start_point from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select round(:b0) into :b0  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )606;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_start_point;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_start_point;
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



	print_spaces(l_start_point);
	fprintf(fp,"%s",l_from_and_to_date.arr);
        fprintf(fp,"\n");

	l_line_no= l_line_no + 4;
	print_page_header();	

}
    
print_page_header()
{
     if (l_page_no == 1)
     {
	print_line(136);
	fprintf(fp,"\n");
	//fprintf(fp,"VER : 4.1\n");

	fprintf(fp,"\n");
	fprintf(fp,"\n");
	fprintf(fp,"\n");
	fprintf(fp,"\n");
	fprintf(fp,"		INPUT PARAMETERS\n");
	fprintf(fp,"		----------------\n\n");

	fprintf(fp,"			");
	fprintf(fp,"EPISODE TYPE                :");
	if (nd_episode_type.arr[0] == 'A')
		fprintf(fp,"ALL");
	else 	
		fprintf(fp,"%s",nd_episode_type.arr);
	
	fprintf(fp,"\n");
	
	fprintf(fp,"			");
	fprintf(fp,"OPTION		            :");
	if (nd_bill_option.arr[0] == 'R')
		fprintf(fp,"HOSPITAL RECEIVABLE");
	else if (nd_bill_option.arr[0] == 'F')
		fprintf(fp,"HOSPITAL REFUNDABLE");
	else
		fprintf(fp,"BOTH");

		
	fprintf(fp,"\n");
	fprintf(fp,"\n");	
	fprintf(fp,"			");
	fprintf(fp,"BILL DATE FROM              :");
	fprintf(fp,"%s",nd_from_date.arr);
	fprintf(fp,"\n");
	fprintf(fp,"			");
	fprintf(fp,"	    TO              :");
	fprintf(fp,"%s",nd_end_date.arr);
	fprintf(fp,"\n");
	fprintf(fp,"\n");
	fprintf(fp,"			");

    if (ND_FM_BLNG_GRP_CATG.arr[0] == '\0')
	fprintf(fp,"%s%s",loc_legend[29],loc_legend[31]);
	else
	fprintf(fp,"%s%s",loc_legend[29],ND_FM_BLNG_GRP_CATG.arr);

	fprintf(fp,"\n");
	fprintf(fp,"			");
    if (ND_TO_BLNG_GRP_CATG.arr[0] == '\0')
	fprintf(fp,"%s%s",loc_legend[28],loc_legend[32]);
	else
	fprintf(fp,"%s%s",loc_legend[28],ND_TO_BLNG_GRP_CATG.arr);


	fprintf(fp,"\n");
	fprintf(fp,"\n");
	fprintf(fp,"			");
	if ((nd_episode_type.arr[0] == 'I') || (nd_episode_type.arr[0] == 'D'))
	{
    if (ND_FM_WARD_CODE.arr[0] == '\0')
	fprintf(fp,"%s%s",loc_legend[30],loc_legend[31]);
	else
	fprintf(fp,"%s%s",loc_legend[30],ND_FM_WARD_CODE.arr);
	
	fprintf(fp,"\n");
	fprintf(fp,"			");
    if (ND_TO_WARD_CODE.arr[0] == '\0')
	fprintf(fp,"%s%s",loc_legend[33],loc_legend[32]);
	else
	fprintf(fp,"%s%s",loc_legend[33],ND_TO_WARD_CODE.arr);
	
	fprintf(fp,"\n");
	fprintf(fp,"\n");
	fprintf(fp,"			");
    if (ND_FM_BED_CLASS.arr[0] == '\0') 
	fprintf(fp,"%s%s",loc_legend[27],loc_legend[31]);
	else
	fprintf(fp,"%s%s",loc_legend[27],ND_FM_BED_CLASS.arr);
	
	fprintf(fp,"\n");
	fprintf(fp,"			");
    if (ND_TO_BED_CLASS.arr[0] == '\0')
	fprintf(fp,"%s%s",loc_legend[33],loc_legend[32]);
	else
	fprintf(fp,"%s%s",loc_legend[33],ND_TO_BED_CLASS.arr);
    fprintf(fp,"			");
}	

   // fprintf(fp,"\f\n");
//	fprintf(fp,"\f\n");
	fprintf(fp,"\f\n");
	print_page_title();
	
     }
     else
     {
     
     /*	
	strcpy(l_mesg,loc_legend[10]);	
	EXEC SQL EXECUTE
	BEGIN
		blcommon.split_words(:l_mesg,13,'*',1,:l_str1,:l_str2);
		blcommon.split_words(:l_mesg,13,'*',2,:l_str1,:l_str3);       

		:l_str2 := ltrim(rtrim(:l_str2));
		:l_str3 := ltrim(rtrim(:l_str3));
	END;
	END-EXEC;	
      */

	dt_len = strlen(loc_legend[10]);
	split_text(loc_legend[10],13,l_str1,&r_ctr);
	if (dt_len > 13)
		split_text(loc_legend[10],13,l_str2,&r_ctr);
	

	print_line(136);
	fprintf(fp,"\n");
	fprintf(fp,"%5.5s %-20.20s %-15.15s %-25.25s %19.19s %15.15s %17.17s %-13.13s \n",
	loc_legend[21],loc_legend[2],loc_legend[3],loc_legend[5],loc_legend[7],loc_legend[8],loc_legend[9],l_str1);	

	sprintf(l_mesg,"(%s)",nd_currency.arr);
	fprintf(fp,"      %-20.20s %-15.15s %-30.30s %14.14s %15.15s %17.17s %-13.13s \n",
	loc_legend[15],loc_legend[4],loc_legend[6],l_mesg,l_mesg,l_mesg,l_str2);	

	print_line(136);    
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
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY\
 HH24:MI') ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') into \
:b0,:b1,:b2,:b3,:b4  from SY_ACC_ENTITY where acc_entity_id=:b5";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )629;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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
    sqlstm.sqhstl[4] = (unsigned int  )32;
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
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )668;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   disp_message(ERR_MESG,"Oracle error at get_header_dtls() occured....");
	   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
	   proc_exit();
}    