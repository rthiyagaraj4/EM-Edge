
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/blr00086.pc"
};


static unsigned int sqlctx = 1288461003;


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
" a.blng_grp_catg ,b.clinic_code ,0 ,to_char(SYSDATE,'YYYYMM') ,0  from bl_bl\
ng_grp_catg a ,op_clinic_his_vw b where :b0='EM' order by 1,2            ";

 static const char *sq0006 = 
"select distinct DECODE(:b0,'DI',NVL(BED_CLASS_CODE,'**'),'EM',NVL(CLINIC_COD\
E,'**'),'**') bed_class  from BL_BILL_DCP_DTL_VW where (((operating_facility_i\
d=:b1 and to_char(doc_date,'YYYYMM')=TO_CHAR(TO_DATE(:b2,'MON-RRRR'),'YYYYMM')\
) and (doc_type_code||doc_num) not  in (select (B.DOC_TYPE_CODE||B.DOC_NUMBER)\
  from BL_CANCELLED_BILLS B where TO_CHAR(B.ADDED_DATE,'YYYYMM')=TO_CHAR(TO_DA\
TE(:b2,'MON-RRRR'),'YYYYMM'))) and (EPISODE_TYPE=decode(:b0,'DI','I','EM','O',\
'R') or EPISODE_TYPE=decode(:b0,'DI','D','EM','E','R'))) union select bed_clas\
s_code  from ip_bed_class where :b0='DI' union select clinic_code  from op_cli\
nic_his_vw where :b0='EM' order by 1            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,101,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,179,0,4,134,0,0,7,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
79,0,0,3,84,0,2,158,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
106,0,0,4,0,0,30,192,0,0,0,0,0,1,0,
121,0,0,5,1173,0,9,278,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
172,0,0,5,0,0,15,288,0,0,0,0,0,1,0,
187,0,0,6,670,0,9,297,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
234,0,0,6,0,0,15,307,0,0,0,0,0,1,0,
249,0,0,5,0,0,13,328,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,4,0,0,
284,0,0,7,98,0,4,350,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
307,0,0,6,0,0,13,368,0,0,1,0,0,1,0,2,9,0,0,
326,0,0,8,589,0,4,382,0,0,8,6,0,1,0,2,3,0,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
373,0,0,9,86,0,4,463,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
396,0,0,10,92,0,4,479,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
419,0,0,11,162,0,4,668,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
454,0,0,12,0,0,32,684,0,0,0,0,0,1,0,
469,0,0,13,96,0,4,841,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
492,0,0,14,162,0,6,848,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00086.PC                                  */
/* AUTHOR                : Robert Joseph                               */  
/* DATE WRITTEN          : 07/05/2005                                   */      
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
#define MAX_LINES 42
#define REP_WIDTH 156
#define VER  "VER : 4.10\n"
#define ESC  0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 



/* VARCHAR     hosp_name           [120],
	        date			    [20],
            date_time           [20],
			d_acc_entity_name	[61],
			d_user			    [31],
			d_sysdate			[20],
			d_curr_date			[20],
			nd_facility_id		[3],
	        user_id             [91],
		    nd_pwd 			    [91],
            nd_session_id       [16],
            nd_pgm_date         [25],
            d_curr_pgm_name     [15],
			nd_facility			[3],
			l_translated_value	[201],
			p_language_id		[3],
			l_pk_value			[100]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[61]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate;

struct { unsigned short len; unsigned char arr[20]; } d_curr_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;



/* VARCHAR	    nd_month_year		    [9],
			nd_det_option		    [3],
		    nd_sum_option		    [3],
			nd_month				[30],
			d_blng_grp_catg			[5],
			nd_blng_grp_catg		[5],
			d_doc_type_code			[7],
			d_doc_date				[16],
			d_bed_clinic_code		[8],
			d_bed_class				[8],
			d_description			[30],
			d_bed_class_desc		[15],
			d_clinic_desc			[15]; */ 
struct { unsigned short len; unsigned char arr[9]; } nd_month_year;

struct { unsigned short len; unsigned char arr[3]; } nd_det_option;

struct { unsigned short len; unsigned char arr[3]; } nd_sum_option;

struct { unsigned short len; unsigned char arr[30]; } nd_month;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_catg;

struct { unsigned short len; unsigned char arr[5]; } nd_blng_grp_catg;

struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_doc_date;

struct { unsigned short len; unsigned char arr[8]; } d_bed_clinic_code;

struct { unsigned short len; unsigned char arr[8]; } d_bed_class;

struct { unsigned short len; unsigned char arr[30]; } d_description;

struct { unsigned short len; unsigned char arr[15]; } d_bed_class_desc;

struct { unsigned short len; unsigned char arr[15]; } d_clinic_desc;

		

 long d_bill_cnt,sum_cnt,overall_cnt;

char        d_bed_clinic_code_arr[100][8],
			d_bill_amt_arr[100][15];
int			i, j,cntarr=0,lctr=0,page_no=0,cnt=0;

double d_bill_amt=0,sum_amount=0,overall_amt=0;

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
 
    strcpy(g_pgm_id,"BLR00086");
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
      
	    nd_month_year.arr[0]	     = '\0';				
        nd_det_option.arr[0]		 = '\0';			
	    nd_sum_option.arr[0]		 = '\0';
		nd_month.arr[0]				 =  '\0';

		/* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,to_char(to_date(PARAM1,'MON-YYYY'),'fmMonth YYYY')
		             INTO 
					:nd_month_year,
				    :nd_det_option,
				    :nd_sum_option,
					:nd_month
					  FROM SY_PROG_PARAM
                 WHERE PGM_ID   = :d_curr_pgm_name
                 AND SESSION_ID = :nd_session_id
                 AND PGM_DATE   = :nd_pgm_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,to_char(to_date(PARAM1,'MON-\
YYYY'),'fmMonth YYYY') into :b0,:b1,:b2,:b3  from SY_PROG_PARAM where ((PGM_ID\
=:b4 and SESSION_ID=:b5) and PGM_DATE=:b6)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_month_year;
  sqlstm.sqhstl[0] = (unsigned int  )11;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_det_option;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_sum_option;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_month;
  sqlstm.sqhstl[3] = (unsigned int  )32;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_curr_pgm_name;
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


		 nd_month_year.arr[nd_month_year.len]		='\0';			
		 nd_det_option.arr[nd_det_option.len]		='\0';		
		 nd_sum_option.arr[nd_sum_option.len]		='\0';
		 nd_month.arr[nd_month.len]					='\0';	


		 	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSIO\
N_ID=:b1) and PGM_DATE=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )79;
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



    	declare_cursor();

        
    	get_header_dtls();
	

	    fetch_legend_value();
        
		open_file();

	

		        
         fprintf(fp,"%c&l1O",ESC); /* Set Landscape*/ 
		 fprintf(fp,"%c&a4L",ESC); 	/* To Set the Left margin  		*/
		 fprintf(fp,"%c(s14H",ESC); 	/* To set the font 	*/

     
      print_header();
      	open_bill_dtl_cur();
		
       do_report();
          close_bill_dtl_cur();
    
	       /* EXEC SQL COMMIT WORK RELEASE; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 7;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )106;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");

print_end_of_rep();
	   }
	    
declare_cursor()
{

 /* EXEC SQL DECLARE BILL_DTL_CUR CURSOR FOR 
 SELECT nvl(c.blng_grp_catg,'**') blngcatg,
        DECODE(:nd_det_option,'DI',nvl(a.bed_class_code,'**'),'EM',NVL(a.clinic_code,'**'),'**') bedclinic,
	nvl(count(doc_num),0) doc_num_cnt,
	to_char(A.doc_date,'YYYYMM') trx_date,
	sum(bill_amt) bill_amt 
 FROM bl_bill_dcp_dtl_vw a,
      bl_blng_grp_by_catg c
 WHERE a.operating_facility_id = :nd_facility
 AND to_char(A.doc_date,'YYYYMM') =( TO_CHAR(TO_DATE(:nd_month_year,'MON-RRRR'),'YYYYMM'))
 AND a.blng_grp_id = c.blng_grp_id(+)
 AND A.doc_type_code||a.doc_num NOT IN(SELECT B.DOC_TYPE_CODE||B.DOC_NUMBER FROM BL_CANCELLED_BILLS B WHERE
     TO_CHAR(B.ADDED_DATE,'YYYYMM')=( TO_CHAR(TO_DATE(:nd_month_year,'MON-RRRR'),'YYYYMM')))
	  
 AND (A.EPISODE_TYPE =decode(:nd_det_option,'DI','I','EM','O','R')
      OR
      A.EPISODE_TYPE =decode(:nd_det_option,'DI','D','EM','E','R')
      ) 
 GROUP BY nvl(c.blng_grp_catg,'**'),
       DECODE(:nd_det_option,'DI',nvl(a.bed_class_code,'**'),'EM',NVL(a.clinic_code,'**'),'**'),to_char(A.doc_date,'YYYYMM')

 UNION ALL

 SELECT a.blng_grp_catg,
        b.bed_class_code,
	0,to_char(SYSDATE,'YYYYMM'),0
 FROM bl_blng_grp_catg a, ip_bed_class b    
 // Join condiiton is not required. This query is used for showing zero values
 WHERE :nd_det_option = 'DI'

 UNION ALL

 SELECT a.blng_grp_catg,
        b.clinic_code,
	0,to_char(SYSDATE,'YYYYMM'),0
 FROM bl_blng_grp_catg a, op_clinic_his_vw b
 // Join condiiton is not required. This query is used for showing zero values
 WHERE :nd_det_option = 'EM'

 ORDER BY 1,2; */ 


 /* EXEC SQL DECLARE BED_CLASS_CUR CURSOR FOR 
 SELECT DISTINCT(DECODE(:nd_det_option,'DI',NVL(BED_CLASS_CODE,'**'),'EM',NVL(CLINIC_CODE,'**'),'**')) bed_class
 FROM BL_BILL_DCP_DTL_VW
 WHERE operating_facility_id =  :nd_facility
 AND to_char(doc_date,'YYYYMM') =( TO_CHAR(TO_DATE(:nd_month_year,'MON-RRRR'),'YYYYMM'))
 AND doc_type_code||doc_num NOT IN(SELECT B.DOC_TYPE_CODE||B.DOC_NUMBER FROM BL_CANCELLED_BILLS B WHERE
 TO_CHAR(B.ADDED_DATE,'YYYYMM')=( TO_CHAR(TO_DATE(:nd_month_year,'MON-RRRR'),'YYYYMM')))
	  
 AND (EPISODE_TYPE =decode(:nd_det_option,'DI','I','EM','O','R')
      OR
      EPISODE_TYPE =decode(:nd_det_option,'DI','D','EM','E','R')
      )	   

 UNION

  SELECT bed_class_code	
  FROM ip_bed_class
  WHERE :nd_det_option = 'DI'

 UNION

  SELECT clinic_code
  FROM op_clinic_his_vw
  WHERE :nd_det_option = 'EM'

  ORDER BY 1; */ 


}




open_bill_dtl_cur() 
	{

	/* EXEC SQL OPEN BILL_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select nvl(c.blng_grp_catg,'**') blngcatg ,DECODE(:b0,'DI',nvl(a.bed_cla\
ss_code,'**'),'EM',NVL(a.clinic_code,'**'),'**') bedclinic ,nvl(count(doc_nu\
m),0) doc_num_cnt ,to_char(A.doc_date,'YYYYMM') trx_date ,sum(bill_amt) bill\
_amt  from bl_bill_dcp_dtl_vw a ,bl_blng_grp_by_catg c where ((((a.operating\
_facility_id=:b1 and to_char(A.doc_date,'YYYYMM')=TO_CHAR(TO_DATE(:b2,'MON-R\
RRR'),'YYYYMM')) and a.blng_grp_id=c.blng_grp_id(+)) and (A.doc_type_code||a\
.doc_num) not  in (select (B.DOC_TYPE_CODE||B.DOC_NUMBER)  from BL_CANCELLED\
_BILLS B where TO_CHAR(B.ADDED_DATE,'YYYYMM')=TO_CHAR(TO_DATE(:b2,'MON-RRRR'\
),'YYYYMM'))) and (A.EPISODE_TYPE=decode(:b0,'DI','I','EM','O','R') or A.EPI\
SODE_TYPE=decode(:b0,'DI','D','EM','E','R'))) group by nvl(c.blng_grp_catg,'\
**'),DECODE(:b0,'DI',nvl(a.bed_class_code,'**'),'EM',NVL(a.clinic_code,'**')\
,'**'),to_char(A.doc_date,'YYYYMM') union all select a.blng_grp_catg ,b.bed_\
class_code ,0 ,to_char(SYSDATE,'YYYYMM') ,0  from bl_blng_grp_catg a ,ip_bed\
_class b where :b0='DI' union all select");
 sqlstm.stmt = sq0005;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )121;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_facility;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_month_year;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_month_year;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[4] = (unsigned int  )5;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[5] = (unsigned int  )5;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[7] = (unsigned int  )5;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[8] = (unsigned int  )5;
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
        err_mesg("OPEN failed on cursor BILL_DTL_CUR",0,"");

	}


close_bill_dtl_cur()
   {

	/* EXEC SQL CLOSE BILL_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )172;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
	}



open_bed_class_cur() 
	{

	/* EXEC SQL OPEN BED_CLASS_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )187;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_facility;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_month_year;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_month_year;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[4] = (unsigned int  )5;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[5] = (unsigned int  )5;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[7] = (unsigned int  )5;
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
        err_mesg("OPEN failed on cursor BED_CLASS_CUR",0,"");

	}


close_bed_class_cur()
   {

	/* EXEC SQL CLOSE BED_CLASS_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )234;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
	}




fetch_bill_dtl_cur()
  {

  d_blng_grp_catg.arr[0]		='\0';
  d_doc_date.arr[0]				='\0';  
  d_bed_clinic_code.arr[0]		='\0';
  d_bill_cnt =0;

 d_bill_amt=0;
  d_blng_grp_catg.len			= 0;
  d_doc_date.len				= 0;  
  d_bed_clinic_code.len			= 0;


 /* EXEC SQL FETCH BILL_DTL_CUR INTO
			:d_blng_grp_catg,
			:d_bed_clinic_code,
			:d_bill_cnt,
			:d_doc_date,
			:d_bill_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )249;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_catg;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_bed_clinic_code;
 sqlstm.sqhstl[1] = (unsigned int  )10;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_bill_cnt;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_doc_date;
 sqlstm.sqhstl[3] = (unsigned int  )18;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_bill_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
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


			


  d_blng_grp_catg.arr[d_blng_grp_catg.len]		='\0';
  d_bed_clinic_code.arr[d_bed_clinic_code.len]	='\0';
  d_doc_date.arr[d_doc_date.len]				='\0'; 
  
 return(LAST_ROW?0:1);

 }

fetch_blng_grp_catg()
	{
		d_description.arr[0]  = '\0';
		d_description.len     = 0;	
		
	          /* EXEC SQL SELECT  nvl(SHORT_DESC,'**Not Specified**') into :d_description FROM BL_BLNG_GRP_CATG 
	          WHERE BLNG_GRP_CATG=:d_blng_grp_catg; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 12;
           sqlstm.arrsiz = 9;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "select nvl(SHORT_DESC,'**Not Specified**') into :b\
0  from BL_BLNG_GRP_CATG where BLNG_GRP_CATG=:b1";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )284;
           sqlstm.selerr = (unsigned short)1;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)4352;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&d_description;
           sqlstm.sqhstl[0] = (unsigned int  )32;
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


       
               d_description.arr[d_description.len]	= '\0';
	    if(strcmp(d_blng_grp_catg.arr,"**")==0)
		   strcpy(d_description.arr,"**Not Specified**");
		else if(strcmp(d_blng_grp_catg.arr,"\0")==0)  
		     strcpy(d_description.arr," "); 		   	
	}

 
fetch_bed_class_cur()
  {

  d_bed_class.arr[0]			='\0';
  d_bed_class.len			= 0;


     /* EXEC SQL FETCH BED_CLASS_CUR INTO
			:d_bed_class; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 9;
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
     sqlstm.sqhstv[0] = (         void  *)&d_bed_class;
     sqlstm.sqhstl[0] = (unsigned int  )10;
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



  d_bed_class.arr[d_bed_class.len]		='\0';
   return(LAST_ROW?0:1);

 }



fetch_amt_summary()
 {
 sum_amount=0;
 sum_cnt=0;
	/* EXEC SQL SELECT	 nvl(count(a.doc_num),0),SUM(NVL(a.BILL_AMT,0)) 
		             INTO 
                       :sum_cnt,
		   :sum_amount
                       FROM bl_bill_dcp_dtl_vw a,
         bl_blng_grp_by_catg c
 WHERE a.operating_facility_id = :nd_facility
   AND to_char(A.doc_date,'YYYYMM') =( TO_CHAR(TO_DATE(:nd_month_year,'MON-RRRR'),'YYYYMM'))
   AND a.blng_grp_id = c.blng_grp_id(+)
   AND A.doc_type_code||a.doc_num NOT IN(SELECT DOC_TYPE_CODE||DOC_NUM FROM BL_CANCELLED_BILLS WHERE
      TO_CHAR(ADDED_DATE,'YYYYMM')=( TO_CHAR(TO_DATE(:nd_month_year,'MON-RRRR'),'YYYYMM')))
   AND (A.EPISODE_TYPE =decode(:nd_sum_option,'DI','I','EM','O','R')
       OR
		A.EPISODE_TYPE =decode(:nd_sum_option,'DI','D','EM','E','R')
	   ) 
   AND nvl(c.blng_grp_catg,'**')=:d_blng_grp_catg; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select nvl(count(a.doc_num),0) ,sum(NVL(a.BILL_AMT,0)) into \
:b0,:b1  from bl_bill_dcp_dtl_vw a ,bl_blng_grp_by_catg c where (((((a.operati\
ng_facility_id=:b2 and to_char(A.doc_date,'YYYYMM')=TO_CHAR(TO_DATE(:b3,'MON-R\
RRR'),'YYYYMM')) and a.blng_grp_id=c.blng_grp_id(+)) and (A.doc_type_code||a.d\
oc_num) not  in (select (DOC_TYPE_CODE||DOC_NUM)  from BL_CANCELLED_BILLS wher\
e TO_CHAR(ADDED_DATE,'YYYYMM')=TO_CHAR(TO_DATE(:b3,'MON-RRRR'),'YYYYMM'))) and\
 (A.EPISODE_TYPE=decode(:b5,'DI','I','EM','O','R') or A.EPISODE_TYPE=decode(:b\
5,'DI','D','EM','E','R'))) and nvl(c.blng_grp_catg,'**')=:b7)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )326;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&sum_cnt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&sum_amount;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_facility;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_month_year;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_month_year;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_sum_option;
 sqlstm.sqhstl[5] = (unsigned int  )5;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_sum_option;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_blng_grp_catg;
 sqlstm.sqhstl[7] = (unsigned int  )7;
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



     


  
}

 print_header()
 {
open_bed_class_cur() ;
   print_page_title();   

  print_line('-',REP_WIDTH);

  fprintf(fp,"%60s "," ");
    if(strcmp(nd_det_option.arr,"DI")==0)
	   fprintf(fp,"%-s(%-s)--->",loc_legend[7],loc_legend[10]);
    else if(strcmp(nd_det_option.arr,"EM")==0)
       fprintf(fp,"%-s(%-s)--->",loc_legend[8],loc_legend[11]);
     else
	    fprintf(fp,"%-s --->",loc_legend[9]);
     next_line(1);

    fprintf(fp,"%-30s%-30s",loc_legend[12],loc_legend[13]);

    i=1;
	 while(fetch_bed_class_cur())
     {
	 strcpy(d_bed_clinic_code_arr[i],d_bed_class.arr);
	 
	  if(strcmp(nd_det_option.arr,"DI")==0)
	  {
	  fetch_bed_class();
      fprintf(fp,"%15s ",d_bed_class_desc.arr);	
	   }
	  else if(strcmp(nd_det_option.arr,"EM")==0)
	   {
         fetch_clinic_code();
          fprintf(fp,"%15s ",d_clinic_desc.arr);	
	   }
	 i++;
     }  
	 cntarr=i;   


 if(strcmp(nd_sum_option.arr,"DI")==0)
	   fprintf(fp,"          %20s",loc_legend[7]);
    else if(strcmp(nd_sum_option.arr,"EM")==0)
       fprintf(fp,"          %20s",loc_legend[8]);
     else
	   fprintf(fp,"          %20s",loc_legend[9]);

    fprintf(fp," %15s",loc_legend[15]);
	next_line(1);	
	close_bed_class_cur();

	print_line('-',REP_WIDTH);
  }

fetch_clinic_code()
{

		d_clinic_desc.arr[0]  = '\0';
		d_clinic_desc.len     = 0;	
		
	          /* EXEC SQL SELECT  nvl(SHORT_DESC,'*NotSpecified*') into :d_clinic_desc 
			  FROM OP_CLINIC 
	          WHERE CLINIC_CODE=:d_bed_class; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 12;
           sqlstm.arrsiz = 9;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "select nvl(SHORT_DESC,'*NotSpecified*') into :b0  \
from OP_CLINIC where CLINIC_CODE=:b1";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )373;
           sqlstm.selerr = (unsigned short)1;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)4352;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&d_clinic_desc;
           sqlstm.sqhstl[0] = (unsigned int  )17;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&d_bed_class;
           sqlstm.sqhstl[1] = (unsigned int  )10;
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


       
               d_clinic_desc.arr[d_clinic_desc.len]	= '\0';
	    if(strcmp(d_bed_class.arr,"**")==0)
		   strcpy(d_clinic_desc.arr,"*NotSpecified*");		   	
	}


fetch_bed_class()
{

		d_bed_class_desc.arr[0]  = '\0';
		d_bed_class_desc.len     = 0;	
		
	          /* EXEC SQL SELECT  nvl(SHORT_DESC,'*NotSpecified*') into :d_bed_class_desc 
			  FROM IP_BED_CLASS 
	          WHERE BED_CLASS_CODE=:d_bed_class; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 12;
           sqlstm.arrsiz = 9;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "select nvl(SHORT_DESC,'*NotSpecified*') into :b0  \
from IP_BED_CLASS where BED_CLASS_CODE=:b1";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )396;
           sqlstm.selerr = (unsigned short)1;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)4352;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&d_bed_class_desc;
           sqlstm.sqhstl[0] = (unsigned int  )17;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&d_bed_class;
           sqlstm.sqhstl[1] = (unsigned int  )10;
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


       
               d_bed_class_desc.arr[d_bed_class_desc.len]	= '\0';
	    if(strcmp(d_bed_class.arr,"**")==0)
		   strcpy(d_bed_class_desc.arr,"*NotSpecified*");		   	
	}


do_report()
{
    int c=0,fld_cnt=0;
    char r_amt[15];
    char strvar[100];
    nd_blng_grp_catg.arr[0]= '\0';
    nd_blng_grp_catg.len=0;
 while (fetch_bill_dtl_cur())	
	{               
  if (strcmp(nd_blng_grp_catg.arr,d_blng_grp_catg.arr)==0)
	{
	
	for(i=c;i<=cntarr;i++)
	  {
	 if(strcmp(d_bed_clinic_code_arr[i],d_bed_clinic_code.arr)==0)
	   {
		overall_amt=overall_amt+d_bill_amt;
		copy_amount(d_bill_amt);
	        sprintf(strvar,"%d",d_bill_cnt);
		fprintf(fp,"%15s ",strvar);
		overall_cnt=overall_cnt+d_bill_cnt;
		c=i+1;
		fld_cnt=fld_cnt+1;
        break;
	   }	    
		 else
		    {
			// fprintf(fp,"%15s "," ");
			//fld_cnt=fld_cnt+1;
			 }
		}

 		 }
   else
     {
	  if(cnt==0)
	   {
         print_blng_catg();
         fprintf(fp,"%-30s",loc_legend[17]);
        }
       else
	     {
		  horz_skip((cntarr-fld_cnt)*15+(cntarr-fld_cnt));
          	   fld_cnt=0;
		    sprintf(strvar,"%d",sum_cnt);
			fprintf(fp,"%14s",strvar);
          
		  overall_cnt=overall_cnt+sum_cnt;
		  sprintf(strvar,"%d",overall_cnt);
			fprintf(fp," %15s ",strvar);
             overall_cnt=0;
			 	next_line(1);
          fprintf(fp,"%30s%-30s"," ",loc_legend[18]);
		  for(i=1;i<=cntarr;i++)
			{
			
		  	fprintf(fp,"%15s ",d_bill_amt_arr[i]);
			
			}
            
             print_formated(sum_amount);
            	overall_amt=overall_amt+sum_amount;
              
				 print_formated(overall_amt);
				 overall_amt=0;
				 	next_line(1);
					next_line(1);
        //***********************************
		  for (i=1;i<=cntarr; i++)
			{
			for (j=0;j<=cntarr;j++)
			{
				d_bill_amt_arr[i][j] = '\0';
			}
			} 
		
	//************************************
	  print_blng_catg();
         fprintf(fp,"%-30s",loc_legend[17]);
	     }
		for(i=1;i<=cntarr;i++)
		 {

		if(strcmp(d_bed_clinic_code_arr[i],d_bed_clinic_code.arr)==0)
		    {	
             sprintf(strvar,"%d",d_bill_cnt);
			  fprintf(fp,"%15s ",strvar);
         	  	overall_amt=overall_amt+d_bill_amt;
				overall_cnt=overall_cnt+d_bill_cnt;
			 	copy_amount(d_bill_amt);	  
			c=i+1;
			fld_cnt=fld_cnt+1;
			break;
			}  
		  else
		    {
			 //   fprintf(fp,"%15s "," ");
		           // fld_cnt=fld_cnt+1;
				}
		 }
		   
        }
		nd_blng_grp_catg.arr[0]='\0';
		nd_blng_grp_catg.len=0;
                strcpy(nd_blng_grp_catg.arr,d_blng_grp_catg.arr);
                nd_blng_grp_catg.arr[d_blng_grp_catg.len]='\0';
    
	 cnt=cnt+1;
	 fetch_amt_summary();	
 }
   horz_skip((cntarr-fld_cnt)*15+(cntarr-fld_cnt));
     sprintf(strvar,"%d",sum_cnt);
			fprintf(fp,"%14s",strvar);
      overall_cnt=overall_cnt+sum_cnt;
      
		 sprintf(strvar,"%d",overall_cnt);
			fprintf(fp," %15s",strvar);
         overall_cnt=0;
		 	next_line(1);
  fprintf(fp,"%30s%-30s"," ",loc_legend[18]);
		  for(i=1;i<=cntarr;i++)
			{
		  	fprintf(fp,"%15s ",d_bill_amt_arr[i]);
			
			}
          
 print_formated(sum_amount);
 overall_amt=overall_amt+sum_amount;
  print_formated(overall_amt);
  overall_amt=0;
  		next_line(1);
		next_line(1);
  		print_line('-',REP_WIDTH);

print_footer();
}

print_footer()
  {

 fprintf(fp,"%6s  1)  %s ",loc_legend[19],loc_legend[20]);
 	next_line(1);
  fprintf(fp,"%12s%s "," ",loc_legend[21]);
  	next_line(1);
  fprintf(fp,"%12s%s "," ",loc_legend[22]);
  	next_line(1);
  fprintf(fp,"%12s%s "," ",loc_legend[23]);
  	next_line(1);
	next_line(1);

 fprintf(fp,"%6s  2)  %s "," ",loc_legend[25]);
 	next_line(1);
  fprintf(fp,"%12s%s "," ",loc_legend[26]);
  	next_line(1);
  fprintf(fp,"%12s%s "," ",loc_legend[27]);
  	next_line(1);

  }

print_blng_catg()
  {
  fetch_blng_grp_catg();
	fprintf(fp,"%-30s",d_description.arr);
  }



get_header_dtls()
  {
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	    d_acc_entity_name.arr[0]	=  '\0';
	    d_curr_date.arr[0]		=  '\0';
	    d_user.arr[0]		=  '\0';
	    d_sysdate.arr[0]		=  '\0';
	    d_acc_entity_name.len	=  0;
	    d_curr_date.len		=  0;
	    d_user.len			=  0;
	    d_sysdate.len		=  0;

	/* EXEC SQL SELECT upper(ACC_ENTITY_NAME), /o description of the institution o/
		   USER, TO_CHAR(SYSDATE, 'DD/MM/YYYY'),TO_CHAR(SYSDATE, 'HH24:MI:SS')
			INTO :d_acc_entity_name,
			     :d_user, :d_sysdate,:d_curr_date
			FROM SY_ACC_ENTITY
			WHERE acc_entity_id = :nd_facility; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,USER ,TO_CHAR(SYSDATE,'DD/MM/\
YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY\
 where acc_entity_id=:b4";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )419;
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
 sqlstm.sqhstv[4] = (         void  *)&nd_facility;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


    
	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len]                       = '\0';
	d_sysdate.arr[d_sysdate.len]                 = '\0';
	d_curr_date.arr[d_curr_date.len]	     = '\0';

   
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
 sqlstm.offset = (unsigned int  )454;
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
   
	int hosp_nm_len, rep_title_len = 10, s1, s2,date_len,user_len,pgm_len;
	char v_rep_title[200],v_as_on_date[12];
	fprintf(fp,"MDL : BL");
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(fp,"%s", d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);

	horz_skip(s2-(strlen(loc_legend[5])+strlen(d_sysdate.arr)+3));
	fprintf(fp,"%s : %s", loc_legend[5],d_sysdate.arr);
    
		next_line(1);
	
	fprintf(fp,"OPR : %s", d_user.arr); 	
     user_len=strlen(d_user.arr);
    strcpy(v_rep_title,loc_legend[1]);	

	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-user_len-6);
	fprintf(fp,"%s",v_rep_title);


	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-(strlen(loc_legend[6])+strlen(d_curr_date.arr)+5));
		fprintf(fp,"%s : %s",loc_legend[6],d_curr_date.arr);
			next_line(1);



	
	fprintf(fp,"REP : %s",d_curr_pgm_name.arr);
        pgm_len=strlen(d_curr_pgm_name.arr);
	strcpy(v_as_on_date,nd_month.arr);
	date_len= strlen(v_as_on_date);
	s1 = (REP_WIDTH-12-date_len)/2;

	
	//horz_skip(s1-14-pgm_len);
	horz_skip(s1-pgm_len-6);
    fprintf(fp,"%s %s",loc_legend[3],v_as_on_date);

        s2 = (REP_WIDTH-s1-date_len-strlen(loc_legend[3]));
	    horz_skip(s2-(14+strlen(loc_legend[4])));
		fprintf(fp,"%s : %-d",loc_legend[4],++page_no);
			next_line(1);

	lctr = 3;

	
}


 	open_file()
{

    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00086.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00086.lis");
       proc_exit();
    }
	
}

	      

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[15], str_amt[15];	

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
	if ((lctr + skip) >= MAX_LINES)
	{
		next_page(); 
	}
	else
	{
		fprintf(fp,"\n"); ++lctr; /*     fprintf(fp,"LNNO:%2d",lno); */
	}
 }
        
next_page() /* will move the cursor to next page */
{
	fprintf(fp,"\n");
	fprintf(fp,"\f");
	fprintf(fp,"\n");
	lctr=2;

	print_header(); 	
}
     
              
print_line(ch,n) /* this is to obtain required characters */
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


fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';
     
		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00086.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00086.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )469;
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
  sqlstm.offset = (unsigned int  )492;
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




copy_amount(loc_amount)
double loc_amount;
{
	char s_amt[15], str_amt[15];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
       // fprintf(fp,"%14sCR",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
       // fprintf(fp,"%14s  ",str_amt);
    }

  strcpy(d_bill_amt_arr[i],str_amt);
} 


print_end_of_rep()
{
	int col;
    next_line(1);
	horz_skip((REP_WIDTH-23)/2);
	fprintf(fp,"***  END OF REPORT  ***");
	fflush(fp);
    fclose(fp);
  fprintf(fp,"%cE",ESC); /* To Reset the Printer */
}
/****************************************************************************/


