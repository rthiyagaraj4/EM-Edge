
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00079.PC"
};


static unsigned int sqlctx = 1288461011;


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

 static const char *sq0005 = 
"_CODE,a.DOC_TYPE_CODE)=b.doc_type_code and nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER)=b\
.doc_num) and a.DOCUMENT_NATURE in ('BI','DC')) and a.doc_date<=nvl(to_date((:\
b0||'23:59:59'),'DD/MM/YYYY hh24:mi:ss'),sysdate)) and a.patient_id=c.patient_\
id) and CEIL((NVL(TO_DATE(:b0,'DD/MM/YYYY'),SYSDATE)-nvl(b.DOC_DATE,a.doc_date\
))) between :b2 and :b3) and NVL(b.blng_grp_id,'X')=d.blng_grp_id(+)) and B.BI\
LL_TOT_AMT>0) group by SUBSTR(blcommon.get_reln_code(a.patient_id),1,10),nvl(d\
.BLNG_GRP_CATG,'**'),a.patient_id,c.short_name,nvl(b.bed_class_code,'**'),nvl(\
a.episode_type,'R'),nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE),nvl(a.ADJ_DOC_NUM\
,a.DOC_NUMBER) having ((sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT))+(sum(DECODE(a.TRX_\
TYPE,'WRITEOFF',a.CREDIT_AMT,'CANC-WRITEOFF',a.CREDIT_AMT,0))-sum(DECODE(a.TRX\
_TYPE,'WRITEOFF',a.DEBIT_AMT,'CANC-WRITEOFF',a.DEBIT_AMT,0))))>0)  group by ci\
tizen,BLNG_GRP_CATG,patient_id,patient_name,bed_class_code,episode_type order \
by citizen,BLNG_GRP_CATG,patient_id            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,119,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,169,0,4,150,0,0,8,3,0,1,0,2,9,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,
83,0,0,3,84,0,2,176,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
110,0,0,4,73,0,4,259,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
133,0,0,5,2005,0,9,360,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,
164,0,0,5,0,0,15,369,0,0,0,0,0,1,0,
179,0,0,5,0,0,13,393,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,4,0,0,2,4,0,0,2,4,0,0,
230,0,0,6,188,0,4,464,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
269,0,0,7,0,0,32,481,0,0,0,0,0,1,0,
284,0,0,8,96,0,4,669,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
307,0,0,9,162,0,6,677,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00046.PC                                  */
/* AUTHOR                : Deepali                               */  
/* DATE WRITTEN          : 15/06/2005                                   */      
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
#define NODATAFOUND sqlca.sqlcode == 1403
#define OERROR          (sqlca.sqlcode < 0)
#define MAX_LINES 44
#define REP_WIDTH 168				//132
//#define VER  "VER : 4.10\n"
#define ESC  0x1B
/*
#define DEBUG 0
*/


/* EXEC SQL BEGIN DECLARE SECTION; */ 



/* VARCHAR     hosp_name                       [120],
			date							[20],
            date_time                       [20],
			d_acc_entity_name				[61],
			d_user							[31],
			d_head_name						[31],
			d_sysdate						[20],
			d_curr_date						[20],
			nd_facility_id					[3],
            user_id                         [91],
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
            nd_facility				        [3],
			nd_as_on_date					[15],
			d_episode_type					[2],
			d_patient_id					[21],
			d_patient_name					[61],
			nd_patient_id                   [21],
			d_doc_type_code					[6],
			d_citizen						[10], 

			nd_pre_citizen					[10],     
			nd_pre_blng_grp_catg			[5],
			d_blng_grp_catg					[5],
			d_blng_grp_catg_desc			[31],
			d_bed_class						[3],
			l_translated_value				[201],	
			p_language_id  				[3],
			l_pk_value						[100]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[61]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[31]; } d_head_name;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate;

struct { unsigned short len; unsigned char arr[20]; } d_curr_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[15]; } nd_as_on_date;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[6]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_citizen;

struct { unsigned short len; unsigned char arr[10]; } nd_pre_citizen;

struct { unsigned short len; unsigned char arr[5]; } nd_pre_blng_grp_catg;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_catg;

struct { unsigned short len; unsigned char arr[31]; } d_blng_grp_catg_desc;

struct { unsigned short len; unsigned char arr[3]; } d_bed_class;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;


	int i,sl_no=1,page_no=0;
	
	long   	nd_days1=0,
			nd_days2=0,
			nd_days3=0,
			nd_days4=0,
            nd_days5=0,
			doc_date=0,
			nd_from_days=0,
			nd_to_days=0,
			nd_from_year, 
			nd_to_year;

	double d_episode_id,d_visit_id,d_doc_num ;

    double  d_bil_out_amt=0,d_bil_write_off_amt=0,d_bil_tot_ot_amt=0,
			d_bil_out_amt_tot=0, d_bil_write_off_amt_tot=0, d_bil_tot_amt_tot=0,
			grn_tot_tot_amt=0,grn_tot_writeoff_amt=0,grn_tot_outst_amt=0;

	char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];

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

char string_var [100];

int    lctr = 0,pctr = 0,nvalid = 0,ncancel = 0, recctr = 1, ftime = 0, bgftime = 0;


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

	strcpy(g_pgm_id,"BLR00079");
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

    	strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    	d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    	strcpy(nd_session_id.arr,argv[2]);
    	nd_session_id.len = strlen(nd_session_id.arr);
    	strcpy(g_session_id,nd_session_id.arr);

    	strcpy(nd_pgm_date.arr,argv[3]);
    	nd_pgm_date.len = strlen(nd_pgm_date.arr);
    	strcpy(g_pgm_date,nd_pgm_date.arr);

    	strcpy(nd_facility.arr,argv[4]);
    	nd_facility.len = strlen(nd_facility.arr);
    	strcpy(g_facility_id,nd_facility.arr);

	    strcpy(p_language_id.arr,l_language_id.arr);        
	    p_language_id.len = l_language_id.len;


	nd_as_on_date.arr[0]				= '\0';	
						
    /* EXEC SQL SELECT	PARAM1, to_number(PARAM2), to_number(PARAM3), PARAM4,PARAM5	
			 INTO :nd_as_on_date, :nd_from_days, :nd_to_days,
				  :nd_from_year, :nd_to_year		
			 FROM SY_PROG_PARAM
			 WHERE PGM_ID   = :d_curr_pgm_name
			 AND   SESSION_ID = :nd_session_id
			 AND   PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PARAM1 ,to_number(PARAM2) ,to_number(PARAM3) ,PARA\
M4 ,PARAM5 into :b0,:b1,:b2,:b3,:b4  from SY_PROG_PARAM where ((PGM_ID=:b5 and\
 SESSION_ID=:b6) and PGM_DATE=:b7)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_as_on_date;
    sqlstm.sqhstl[0] = (unsigned int  )17;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_from_days;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_days;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_from_year;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_year;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_curr_pgm_name;
    sqlstm.sqhstl[5] = (unsigned int  )17;
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
    sqlstm.sqhstl[7] = (unsigned int  )27;
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




	
	/*sprintf(string_var , "nd fromdays %4d" , nd_from_days);
	disp_message(ERR_MESG, string_var);

	sprintf(string_var , "nd to days %4d" , nd_to_days);
	disp_message(ERR_MESG, string_var);*/


   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");


   nd_as_on_date.arr[nd_as_on_date.len]				='\0';			
       
   /* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )83;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");

    open_files();

    declare_cur();

	get_header_dtls();

	fetch_legend_value();

	 fprintf(fp,"%c&l1O",ESC); /* Set Landscape*/ 
 	 fprintf(fp, "%c(s17H", ESC);/* Reduce the font size*/
	 fprintf(fp,"%c&a4L",ESC); 	/* To Set the Left margin  		*/

   print_param();

   open_det_cur();

   nd_pre_citizen.arr[0] = '\0';
   nd_pre_blng_grp_catg.arr[0] = '\0';

   while(fetch_det_cur())
   {


       if (!nd_pre_citizen.arr)
         {

          strcpy(nd_pre_citizen.arr,d_citizen.arr);
          strcpy(nd_pre_blng_grp_catg.arr,d_blng_grp_catg.arr);
         }

       if (strcmp(nd_pre_citizen.arr,d_citizen.arr)!=0) 
          {	
	    
            strcpy(nd_pre_citizen.arr,d_citizen.arr);
			
			if(bgftime != 0)
			  print_bg_catg_tot();
			  			
			if (ftime != 0)
			   next_page();

            //fprintf(fp,"%-12s :  %s\n" ,loc_legend[7], d_citizen.arr);          

	    if (strcmp(d_citizen.arr,"NATIONALS") == 0)
		fprintf(fp,"%-12s :  %s\n" ,loc_legend[7], loc_legend[20]);          
	    else if (strcmp(d_citizen.arr,"OTHERS") == 0)
		fprintf(fp,"%-12s :  %s\n" ,loc_legend[7], loc_legend[21]);          
	    else if (strcmp(d_citizen.arr,"UNRESTRICTED") == 0)
		fprintf(fp,"%-12s :  %s\n" ,loc_legend[7], loc_legend[22]);       
	    else
		fprintf(fp,"%-12s :  %s\n" ,loc_legend[7], d_citizen.arr);          


            lctr++;
            nd_pre_blng_grp_catg.arr[0] = '\0';	    
	  		ftime++;
			bgftime = 0;
          }

       if (strcmp(nd_pre_blng_grp_catg.arr,d_blng_grp_catg.arr)!=0)
          {	
		    if(bgftime != 0)
			  print_bg_catg_tot();
            strcpy(nd_pre_blng_grp_catg.arr,d_blng_grp_catg.arr);
			fprintf(fp,"\n");
  
			d_blng_grp_catg_desc.arr[0] = '\0';	    
			if (strcmp(d_blng_grp_catg.arr, "**")==0)
			{
			   strcpy(d_blng_grp_catg_desc.arr, "Not specified");
               fprintf(fp,"%-22s  :  %2s - %-30s\n" ,loc_legend[14], d_blng_grp_catg.arr, d_blng_grp_catg_desc.arr);          
			}
		    else
			{

			   /* EXEC SQL SELECT SHORT_DESC
					 INTO   :d_blng_grp_catg_desc
					 FROM   BL_BLNG_GRP_CATG
					 WHERE  BLNG_GRP_CATG = :d_blng_grp_catg; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 8;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select SHORT_DESC into :b0  from BL_BLNG_GRP_CATG where\
 BLNG_GRP_CATG=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )110;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_catg_desc;
      sqlstm.sqhstl[0] = (unsigned int  )33;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_catg;
      sqlstm.sqhstl[1] = (unsigned int  )7;
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

			   
			   d_blng_grp_catg_desc.arr[d_blng_grp_catg_desc.len]	= '\0';	
               fprintf(fp,"%-22s  :  %2s - %-30s\n" ,loc_legend[14], d_blng_grp_catg.arr, d_blng_grp_catg_desc.arr);   
 
       
			}
			

			lctr++;
			recctr = 1;
			bgftime++;
          }

		print_rec();

   }

    if(bgftime != 0)

	  print_bg_catg_tot();

print_grand_tot();

    print_end();


	fprintf(fp,"%cE",ESC); /* To Reset the Printer */

 }

open_files()
{

    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00079.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00079.lis");
       proc_exit();
    }

}

declare_cur()
{
	

	/* EXEC SQL DECLARE DET_CUR CURSOR FOR
	select citizen,BLNG_GRP_CATG,patient_id,patient_name, bed_class_code,episode_type,
	sum(Bill_Outst_amt), sum(WO_Amt), sum(TOT_AMT)
	from (
	select SUBSTR(blcommon.get_reln_code(a.patient_id),1,10) citizen,
       nvl(d.BLNG_GRP_CATG, '**') BLNG_GRP_CATG, a.patient_id patient_id,
	    c.short_name patient_name,
	   nvl(b.bed_class_code,'**') bed_class_code, nvl(a.episode_type,'R') episode_type,    
	   nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE) doc_type,
	   nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER) doc_num ,
       sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT) Bill_Outst_amt,
       sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,
                           'CANC-WRITEOFF',a.CREDIT_AMT,0)) -
       sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,
                           'CANC-WRITEOFF',a.DEBIT_AMT,0)) WO_Amt,
       (sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT)
       + (sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,
                           'CANC-WRITEOFF',a.CREDIT_AMT,0)) -
       sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,
                           'CANC-WRITEOFF',a.DEBIT_AMT,0))))TOT_AMT
	from  BL_PATIENT_STATEMENT_VW a, bl_bill_dcp_dtl_vw b, mp_patient_mast c,
		  BL_BLNG_GRP_BY_CATG d
	where nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE) = b.doc_type_code
	and   nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER) = b.doc_num
	and   a.DOCUMENT_NATURE IN ('BI','DC')
	and   a.doc_date <= nvl(to_date(:nd_as_on_date||'23:59:59','DD/MM/YYYY hh24:mi:ss'),sysdate)
	and   a.patient_id = c.patient_id
	and   CEIL(NVL(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),SYSDATE) - nvl(b.DOC_DATE,a.doc_date))
		  between :nd_from_days and :nd_to_days
        and   NVL(b.blng_grp_id,'X') = d.blng_grp_id(+)
	 AND B.BILL_TOT_AMT > 0   /o Added by robert to avoid negative bills as per discussiono/
	group by SUBSTR(blcommon.get_reln_code(a.patient_id),1,10),
	nvl(d.BLNG_GRP_CATG,'**'),
	a.patient_id, c.short_name, nvl(b.bed_class_code,'**'),nvl(a.episode_type,'R'),
	nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE),
	nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER)
	having (sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT)
		   + (sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,
	                    'CANC-WRITEOFF',a.CREDIT_AMT,0)) -
			sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,
                           'CANC-WRITEOFF',a.DEBIT_AMT,0)))) > 0
	)
	group by citizen,BLNG_GRP_CATG,patient_id,patient_name, bed_class_code,episode_type
	ORDER BY citizen, 
			 BLNG_GRP_CATG, patient_id; */ 


}

open_det_cur()
{
   /* EXEC SQL OPEN DET_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select citizen ,BLNG_GRP_CATG ,patient_id ,patient_name ,bed_class_cod\
e ,episode_type ,sum(Bill_Outst_amt) ,sum(WO_Amt) ,sum(TOT_AMT)  from (selec\
t SUBSTR(blcommon.get_reln_code(a.patient_id),1,10) citizen ,nvl(d.BLNG_GRP_\
CATG,'**') BLNG_GRP_CATG ,a.patient_id patient_id ,c.short_name patient_name\
 ,nvl(b.bed_class_code,'**') bed_class_code ,nvl(a.episode_type,'R') episode\
_type ,nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE) doc_type ,nvl(a.ADJ_DOC_NUM,\
a.DOC_NUMBER) doc_num ,(sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT)) Bill_Outst_amt ,\
(sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,'CANC-WRITEOFF',a.CREDIT_AMT,\
0))-sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,'CANC-WRITEOFF',a.DEBIT_AMT\
,0))) WO_Amt ,((sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT))+(sum(DECODE(a.TRX_TYPE,'\
WRITEOFF',a.CREDIT_AMT,'CANC-WRITEOFF',a.CREDIT_AMT,0))-sum(DECODE(a.TRX_TYP\
E,'WRITEOFF',a.DEBIT_AMT,'CANC-WRITEOFF',a.DEBIT_AMT,0)))) TOT_AMT  from BL_\
PATIENT_STATEMENT_VW a ,bl_bill_dcp_dtl_vw b ,mp_patient_mast c ,BL_BLNG_GRP\
_BY_CATG d where (((((((nvl(a.ADJ_DOC_TYPE");
   sqlstm.stmt = sq0005;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )133;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_as_on_date;
   sqlstm.sqhstl[0] = (unsigned int  )17;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_as_on_date;
   sqlstm.sqhstl[1] = (unsigned int  )17;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_from_days;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_days;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
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
        err_mesg("OPEN failed on cursor DET_CUR",0,"");
}


close_det_cur()
{

	/* EXEC SQL CLOSE DET_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )164;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}

fetch_det_cur()
{ 

        d_citizen.arr[0]			= '\0';	   
		d_blng_grp_catg.arr[0]      = '\0';
        d_patient_id.arr[0]			= '\0';	  
		d_patient_name.arr[0]       = '\0';
		d_bed_class.arr[0]			= '\0';
        d_episode_type.arr[0]		= '\0';
        d_citizen.len			= 0;
		d_blng_grp_catg.len		= 0;
		d_patient_id.len		= 0;
		d_patient_name.len		= 0;
		d_bed_class.len			= 0;
		d_episode_type.len      =0;

		d_bil_out_amt			= 0;
		d_bil_write_off_amt		= 0;
		d_bil_tot_ot_amt		= 0;	   

	/* EXEC SQL FETCH  DET_CUR INTO 
		:d_citizen,
		:d_blng_grp_catg,
		:d_patient_id,
		:d_patient_name,
		:d_bed_class,
		:d_episode_type,			
		:d_bil_out_amt,
		:d_bil_write_off_amt,
		:d_bil_tot_ot_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )179;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_citizen;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_catg;
 sqlstm.sqhstl[1] = (unsigned int  )7;
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
 sqlstm.sqhstv[3] = (         void  *)&d_patient_name;
 sqlstm.sqhstl[3] = (unsigned int  )63;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_bed_class;
 sqlstm.sqhstl[4] = (unsigned int  )5;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_bil_out_amt;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_bil_write_off_amt;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_bil_tot_ot_amt;
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



	
	

	if (OERROR)
		err_mesg("FETCH failed on cursor DET_CUR ",0,"");	


    d_citizen.arr[d_citizen.len]					= '\0';	
	d_blng_grp_catg.arr[d_blng_grp_catg.len]		= '\0';
	d_patient_id.arr[d_patient_id.len]				= '\0';
	d_patient_name.arr[d_patient_name.len]			= '\0';
	d_bed_class.arr[d_bed_class.len]				= '\0';
	d_episode_type.arr[d_episode_type.len]			= '\0';

	/*recctr++;*/

	return(LAST_ROW?0:1);   
}

print_rec()
{

    if (lctr > 40)
	   next_page();

    fprintf(fp,"%4d ",recctr);
    fprintf(fp,"%-20s %-60s %-2s",d_patient_id.arr,d_patient_name.arr, d_bed_class.arr);

	fprintf(fp,"             ");
    print_formated(d_bil_tot_ot_amt);
	fprintf(fp,"  ");
	print_formated(d_bil_write_off_amt);
	fprintf(fp,"  ");
     print_formated(d_bil_out_amt);
    fprintf(fp,"\n");

	lctr++;
	recctr++;

	d_bil_out_amt_tot	    += d_bil_out_amt;
	d_bil_write_off_amt_tot += d_bil_write_off_amt;
	d_bil_tot_amt_tot	    += d_bil_tot_ot_amt;

}


get_header_dtls()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    d_acc_entity_name.arr[0] ='\0';
    d_curr_date.arr[0]   ='\0';
	d_user.arr[0] ='\0';
    d_sysdate.arr[0] ='\0';
	d_head_name.arr[0] ='\0';
    d_acc_entity_name.len =0;
    d_curr_date.len   =0;
	d_user.len =0;
    d_sysdate.len =0;
	d_head_name.len=0;

	/* EXEC SQL SELECT upper(ACC_ENTITY_NAME), /o description of the institution o/
				   USER, TO_CHAR(SYSDATE, 'DD/MM/YYYY'),TO_CHAR(SYSDATE, 'HH24:MI:SS'),HEAD_OF_COMPANY_NAME
             INTO :d_acc_entity_name,
				  :d_user, :d_sysdate,:d_curr_date,d_head_name
			 FROM SY_ACC_ENTITY
			 WHERE acc_entity_id = :nd_facility; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,USER ,TO_CHAR(SYSDATE,'DD/MM/\
YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') ,HEAD_OF_COMPANY_NAME into :b0,:b1,:b2,:\
b3,:b4  from SY_ACC_ENTITY where acc_entity_id=:b5";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )230;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
 sqlstm.sqhstl[0] = (unsigned int  )63;
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
 sqlstm.sqhstl[2] = (unsigned int  )22;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_curr_date;
 sqlstm.sqhstl[3] = (unsigned int  )22;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_head_name;
 sqlstm.sqhstl[4] = (unsigned int  )33;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_facility;
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
	d_curr_date.arr[d_curr_date.len]			 = '\0';
	d_head_name.arr[d_head_name.len]			 = '\0';

   
	return;
	err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )269;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	proc_exit();
}


print_page_title()
{

	int hosp_nm_len,date1_len, rep_title_len = 10,v_title_len,v_title1_len, s1, s2,date_len,user_len,pgm_len,sub_title_len;
	char v_rep_title[200],v_as_on_date[12],v_sub_title[200],v_title[200],v_title1[200];
   
	fprintf(fp,"MDL : BL");
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(fp,"%s", d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	date1_len=strlen(loc_legend[3]);
	horz_skip(s2-date1_len-12);
	fprintf(fp,"%s: %s", loc_legend[3],d_sysdate.arr);
    
	next_line(1);
	
	fprintf(fp,"OPR : %s", d_user.arr); 	
        user_len=strlen(d_user.arr);
	strcpy(v_rep_title,loc_legend[1]);
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	 strcpy(v_as_on_date,nd_as_on_date.arr);
	date_len= strlen(v_as_on_date);
	horz_skip(s1-user_len-6);
	fprintf(fp,"%s  %10s",v_rep_title,v_as_on_date);
   	s2 = (REP_WIDTH-s1-rep_title_len-date_len);
	horz_skip(s2-24);
	fprintf(fp,"%9s : %10s",loc_legend[2],d_curr_date.arr);
	next_line(1);

	fprintf(fp,"REP : %s",d_curr_pgm_name.arr);
        pgm_len=strlen(d_curr_pgm_name.arr);
	
	//sprintf(v_sub_title, "PERIOD FROM  : %2d - %2d year",nd_from_year,nd_to_year); 

	sprintf(v_sub_title, "%s  : %2d - %2d %-s",loc_legend[19],nd_from_year,nd_to_year,loc_legend[18]); 

	//strcpy(v_sub_title,d_head_name.arr);

	sub_title_len = strlen(v_sub_title);
	s1 = (REP_WIDTH-sub_title_len)/2;
   	horz_skip(s1-pgm_len-6);
	fprintf(fp,"%s",v_sub_title);

        s2 = (REP_WIDTH-s1-sub_title_len-5);
	    horz_skip(s2-19);
		fprintf(fp,"%11s : %10d",loc_legend[4],++page_no);
	next_line(1);
	//fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 			*/

    //fprintf(fp,"%c(s-3B",ESC); /* release bold style */
   
	lctr = 6;
	print_line('-',REP_WIDTH); next_line(1);

	
}


print_column_title()
 {

  fprintf(fp, "%-4s%-23s%-60s%-5s%20s   %15s   %15s %15s",
  loc_legend[5],loc_legend[6],loc_legend[8],loc_legend[9],loc_legend[10],loc_legend[11],
  loc_legend[12],loc_legend[13]);
  next_line(1);

  print_line('-',REP_WIDTH);
  next_line(1);

 }


print_param()
{
  print_page_title();

//  fprintf(fp,"VER 4.1\n");
 
  fprintf(fp,"\n\n\n\n");
  fprintf(fp,"        ");
  fprintf(fp,"INPUT PARAMETERS :\n");
  fprintf(fp,"        ");
  fprintf(fp,"------------------\n\n");

  fprintf(fp,"                AS ON DATE   : %s\n",nd_as_on_date.arr);  
  fprintf(fp,"                PERIOD FROM  : %2d - %2d year",nd_from_year,nd_to_year);

  next_page();
}


check_line(skip) /* will check for MAX LINE before printing totals */
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
	if ((lctr + skip) > MAX_LINES)
	{
		next_page(); 
	}
	else
	{
		fprintf(fp,"\n"); ++lctr; 
	}
}

next_page() /* will move the cursor to next page */
{
  
	fprintf(fp,"\n");
	fprintf(fp,"\f");
	lctr=0;
	fprintf(fp,"\n"); 
	 
	print_page_title();
	print_column_title();  	
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

print_end()
{
  fprintf(fp,"\n \n");
  fprintf(fp,"                                                   **   END  OF  REPORT   ** ");
  //next_line(1);
  fflush(fp);
  fclose(fp);
}


print_formated(loc_amount)
double loc_amount;
{
	char s_amt[50], str_amt[50];	

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
        fprintf(fp,"%14s  ",str_amt);
    }
}  



fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00079.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00079.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )284;
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )307;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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


print_bg_catg_tot()
{
    /*if (lctr > 52)
       print_head(1);*/

    fprintf(fp,"%69s                                 --------------   ---------------    ---------------\n"," ");
    //fprintf(fp,"%60sTOTAL                                     "," ");
	fprintf(fp,"%96s      ",loc_legend[15]);
	    print_formated(d_bil_tot_amt_tot); fprintf(fp,"  ");
    print_formated(d_bil_write_off_amt_tot); fprintf(fp,"  ");
    print_formated(d_bil_out_amt_tot);
    fprintf(fp,"\n");
    fprintf(fp,"%69s                                 --------------   ---------------    --------------\n"," ");
    lctr +=3;
  calc_grand_tot();
     /*grn_tot_tot_amt_db       += epi_tot_tot_amt_db;
     grn_tot_hosp_tot_amt_db  += epi_tot_hosp_tot_amt_db;
     grn_tot_drfee_tot_amt_db += epi_tot_drfee_tot_amt_db;*/

     d_bil_out_amt_tot        = 0;
     d_bil_write_off_amt_tot   = 0;
     d_bil_tot_amt_tot  = 0;
}

calc_grand_tot()
{
 grn_tot_tot_amt += d_bil_tot_amt_tot;
grn_tot_writeoff_amt  += d_bil_write_off_amt_tot;
    grn_tot_outst_amt += d_bil_out_amt_tot;
}

print_grand_tot()
 {

   // fprintf(fp,"%69s                                 --------------   ---------------    ---------------\n"," ");
    //fprintf(fp,"%60sGRAND TOTAL                               "," ");
	fprintf(fp,"%96s      ",loc_legend[16]);
	    print_formated(grn_tot_tot_amt); fprintf(fp,"  ");
    print_formated(grn_tot_writeoff_amt); fprintf(fp,"  ");
    print_formated(grn_tot_outst_amt);
    fprintf(fp,"\n");
    fprintf(fp,"%69s                                 --------------   ---------------    --------------\n"," ");
    lctr +=3;
  }
