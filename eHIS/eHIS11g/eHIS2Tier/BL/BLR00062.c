
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00062.pc"
};


static unsigned int sqlctx = 1288460939;


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
            void  *sqhstv[14];
   unsigned int   sqhstl[14];
            int   sqhsts[14];
            void  *sqindv[14];
            int   sqinds[14];
   unsigned int   sqharm[14];
   unsigned int   *sqharc[14];
   unsigned short  sqadto[14];
   unsigned short  sqtdso[14];
} sqlstm = {12,14};

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
"(DISCHARGED_YN,'N')='Y') or (((c.discharge_billing_stage='1' and NVL(A.DISCH\
ARGE_BILL_GEN_IND,'N')='N') and A.epIsode_id in (select episode_id  from BL_IP\
_DISCHARGE_ADVICE_VW where nvl(DIS_ADV_STATUS,'0')<>'9')) and nvl(DISCHARGED_Y\
N,'N')='N'))) order by DECODE(:b9,'B',A.BLNG_GRP_ID,'W',D.CUR_WARD_CODE,'C',E.\
BLNG_GRP_CATG,TO_CHAR(a.DISCHARGE_DATE_TIME,'YYYY/MM/DD'))            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,125,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,225,0,4,168,0,0,14,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
107,0,0,3,84,0,2,202,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
134,0,0,4,0,0,30,340,0,0,0,0,0,1,0,
149,0,0,5,1404,0,9,385,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
204,0,0,5,0,0,15,393,0,0,0,0,0,1,0,
219,0,0,5,0,0,13,424,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
282,0,0,6,66,0,4,462,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
305,0,0,7,69,0,4,474,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
328,0,0,8,188,0,4,490,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
359,0,0,9,64,0,4,512,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
382,0,0,10,82,0,4,523,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
409,0,0,11,73,0,4,535,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
432,0,0,12,162,0,4,570,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
467,0,0,13,0,0,32,586,0,0,0,0,0,1,0,
482,0,0,14,96,0,4,1030,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
505,0,0,15,162,0,6,1037,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00062.PC                                  */
/* AUTHOR                : Robert Joseph                               */  
/* DATE WRITTEN          : 19/03/2005                                   */      
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
#define MAX_LINES 40
#define REP_WIDTH 180
#define VER  "VER : 4.10\n"
#define ESC  0x1B
/*
#define DEBUG 0
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 



/* VARCHAR     hosp_name                       [120],
			date							[20],
            date_time                       [20],
			d_acc_entity_name			[61],
			d_user						[31],
			d_sysdate					[20],
			nd_facility_id				[3],
            user_id                         [91],
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
			nd_facility				        [3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[61]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

/* VARCHAR     nd_blng_grp_f					[5],
            nd_blng_grp_t					[5],
			nd_ward_f						[5],
			nd_ward_t						[5], 
			nd_order						[3],
			d_blng_grp_id					[5],
	        d_description					[16],
			d_patient_id					[21],
			d_patient						[61],	
            d_episode_id					[9],
			d_cur_ward_code					[5],
			d_ward							[16],
			d_admission_date_time			[21],
			d_discharge_bill_date_time		[21],
			d_cust_code						[9],
			d_cust_name						[16],
			d_blng_catg						 [16],
			nd_dischrg_dt_f					[12],
			nd_dischrg_dt_t					[12],
			nd_blng_grp_catg_f				[5],
			nd_blng_grp_catg_t				[5],

			blng_grp_id						[5],
			d_discharge_yn					[2],
			d_encounter_id					[13],
			d_disc_adv_time					[21],
			nd_discharged_adv_date           [21],	
            cur_ward_code                    [5],
			d_discharge_billing_stage		  [2],	
			d_curr_date						[11],	
			l_translated_value				[201],	
			l_pk_value						[100],
			p_language_id                   [3],
			d_billing_grp_catg				[4],
			billing_grp_catg				[16],
			discharge_bill_date_time		[21],
			nd_date_frm_flag				[2],
			nd_temp_var						[100],
			nd_date_to_flag					[2]; */ 
struct { unsigned short len; unsigned char arr[5]; } nd_blng_grp_f;

struct { unsigned short len; unsigned char arr[5]; } nd_blng_grp_t;

struct { unsigned short len; unsigned char arr[5]; } nd_ward_f;

struct { unsigned short len; unsigned char arr[5]; } nd_ward_t;

struct { unsigned short len; unsigned char arr[3]; } nd_order;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[16]; } d_description;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_cur_ward_code;

struct { unsigned short len; unsigned char arr[16]; } d_ward;

struct { unsigned short len; unsigned char arr[21]; } d_admission_date_time;

struct { unsigned short len; unsigned char arr[21]; } d_discharge_bill_date_time;

struct { unsigned short len; unsigned char arr[9]; } d_cust_code;

struct { unsigned short len; unsigned char arr[16]; } d_cust_name;

struct { unsigned short len; unsigned char arr[16]; } d_blng_catg;

struct { unsigned short len; unsigned char arr[12]; } nd_dischrg_dt_f;

struct { unsigned short len; unsigned char arr[12]; } nd_dischrg_dt_t;

struct { unsigned short len; unsigned char arr[5]; } nd_blng_grp_catg_f;

struct { unsigned short len; unsigned char arr[5]; } nd_blng_grp_catg_t;

struct { unsigned short len; unsigned char arr[5]; } blng_grp_id;

struct { unsigned short len; unsigned char arr[2]; } d_discharge_yn;

struct { unsigned short len; unsigned char arr[13]; } d_encounter_id;

struct { unsigned short len; unsigned char arr[21]; } d_disc_adv_time;

struct { unsigned short len; unsigned char arr[21]; } nd_discharged_adv_date;

struct { unsigned short len; unsigned char arr[5]; } cur_ward_code;

struct { unsigned short len; unsigned char arr[2]; } d_discharge_billing_stage;

struct { unsigned short len; unsigned char arr[11]; } d_curr_date;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[4]; } d_billing_grp_catg;

struct { unsigned short len; unsigned char arr[16]; } billing_grp_catg;

struct { unsigned short len; unsigned char arr[21]; } discharge_bill_date_time;

struct { unsigned short len; unsigned char arr[2]; } nd_date_frm_flag;

struct { unsigned short len; unsigned char arr[100]; } nd_temp_var;

struct { unsigned short len; unsigned char arr[2]; } nd_date_to_flag;


	int i,sl_no=1;
	double d_amount ;
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

int    lctr = 0,pctr = 0,nvalid = 0,ncancel = 0;
int    first = 1,r_fst = 1,slno =0;
int   line_no = 0, 
      prt_ln_cnt,
      print_column_heading,
      page_no = 0;
	 


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
 
    strcpy(g_pgm_id,"BLR00062");
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

        strcpy(p_language_id.arr,l_language_id.arr);
	    p_language_id.len = l_language_id.len;

    	strcpy(nd_pgm_date.arr,argv[3]);
    	nd_pgm_date.len = strlen(nd_pgm_date.arr);
    	strcpy(g_pgm_date,nd_pgm_date.arr);

    	strcpy(nd_facility.arr,argv[4]);
    	nd_facility.len = strlen(nd_facility.arr);
    	strcpy(g_facility_id,nd_facility.arr);


			nd_blng_grp_f.arr[0]		= '\0';				
            nd_blng_grp_t.arr[0]		= '\0';			
			nd_ward_f.arr[0]			= '\0';					
			nd_ward_t.arr[0]			= '\0';					
			nd_order.arr[0]				= '\0';					

			nd_blng_grp_f.len		= 0;			
            nd_blng_grp_t.len		= 0;		
			nd_ward_f.len			= 0;				
			nd_ward_t.len			= 0;			
			nd_order.len			= 0;
		
			
        /* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,PARAM7,PARAM8,PARAM9,PARAM10,PARAM11
				INTO	:nd_blng_grp_f,
						:nd_blng_grp_t,
						:nd_ward_f,
						:nd_ward_t,
						:nd_order,
						:nd_dischrg_dt_f,
						:nd_dischrg_dt_t,
						:nd_blng_grp_catg_f,
						:nd_blng_grp_catg_t,
						:nd_date_frm_flag,
						:nd_date_to_flag
					FROM SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 14;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6\
 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b\
7,:b8,:b9,:b10  from SY_PROG_PARAM where ((PGM_ID=:b11 and SESSION_ID=:b12) an\
d PGM_DATE=:b13)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )36;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_blng_grp_f;
        sqlstm.sqhstl[0] = (unsigned int  )7;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_blng_grp_t;
        sqlstm.sqhstl[1] = (unsigned int  )7;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_ward_f;
        sqlstm.sqhstl[2] = (unsigned int  )7;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_ward_t;
        sqlstm.sqhstl[3] = (unsigned int  )7;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&nd_order;
        sqlstm.sqhstl[4] = (unsigned int  )5;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&nd_dischrg_dt_f;
        sqlstm.sqhstl[5] = (unsigned int  )14;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&nd_dischrg_dt_t;
        sqlstm.sqhstl[6] = (unsigned int  )14;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&nd_blng_grp_catg_f;
        sqlstm.sqhstl[7] = (unsigned int  )7;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&nd_blng_grp_catg_t;
        sqlstm.sqhstl[8] = (unsigned int  )7;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&nd_date_frm_flag;
        sqlstm.sqhstl[9] = (unsigned int  )4;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&nd_date_to_flag;
        sqlstm.sqhstl[10] = (unsigned int  )4;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&d_curr_pgm_name;
        sqlstm.sqhstl[11] = (unsigned int  )17;
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&nd_session_id;
        sqlstm.sqhstl[12] = (unsigned int  )18;
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&nd_pgm_date;
        sqlstm.sqhstl[13] = (unsigned int  )27;
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
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


			nd_blng_grp_f.arr[nd_blng_grp_f.len]				='\0';			
            nd_blng_grp_t.arr[nd_blng_grp_t.len]				='\0';		
			nd_ward_f.arr[nd_ward_f.len]						='\0';				
			nd_ward_t.arr[nd_ward_t.len]						='\0';				
			nd_order.arr[nd_order.len]							='\0';
			nd_dischrg_dt_f.arr[nd_dischrg_dt_f.len]			='\0';				
			nd_dischrg_dt_t.arr[nd_dischrg_dt_t.len]			='\0';				
			nd_blng_grp_catg_f.arr[nd_blng_grp_catg_f.len]		='\0';
			nd_blng_grp_catg_t.arr[nd_blng_grp_catg_t.len]		='\0';

	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION_I\
D=:b1) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )107;
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
   

	declare_cur();

    get_header_dtls();

	fetch_legend_value();

    open_file();

    open_pat_dis_cur() ;

    fprintf(fp,"%c",0x0F); // set printer to compressed mode 

   print_page_header();
   // print_head();

   if(strcmp(nd_order.arr,"B")==0)
    {
	while (fetch_discharge_dtl())
       {
	    get_discharge_adv_date();   		  
	    get_cust_name();


			 if (strcmp(blng_grp_id.arr,d_blng_grp_id.arr) != 0)
				{
			      fetch_blng_grp();
				  fetch_ward();
				  fetch_patient_name();
				  fetch_blng_grp_catg();
				  print_rec(0);
				  strcpy(blng_grp_id.arr,d_blng_grp_id.arr);
				}
			 else
				{
				  fetch_ward();
				  fetch_patient_name();	
				  fetch_blng_grp_catg();			  
				  print_rec(1);
        		  strcpy(blng_grp_id.arr,d_blng_grp_id.arr);
				}
        }
		print_end_of_rep();
     }
   else if(strcmp(nd_order.arr,"W")==0)
     {
	   while (fetch_discharge_dtl())
          {
		    get_discharge_adv_date();
		    get_cust_name();
            if (strcmp(cur_ward_code.arr,d_cur_ward_code.arr) != 0)
				{
				  fetch_ward();
			      fetch_patient_name();
				  fetch_blng_grp();
				  fetch_blng_grp_catg();
				  disp_rec(0);
				  strcpy(cur_ward_code.arr,d_cur_ward_code.arr);
				}
			else
				{
				  fetch_patient_name();
				  fetch_blng_grp();	
				  fetch_blng_grp_catg();		  
				  disp_rec(1);
				  strcpy(cur_ward_code.arr,d_cur_ward_code.arr);
				}
         }

      print_end_of_rep();
     }
	    
    else if(strcmp(nd_order.arr,"C")==0)
     {
	   while (fetch_discharge_dtl())
          {
		    get_discharge_adv_date();
		    get_cust_name();
            if (strcmp(billing_grp_catg.arr,d_billing_grp_catg.arr) != 0)
				{
				  
				  fetch_blng_grp_catg();
				  fetch_ward();
			      fetch_patient_name();
				  fetch_blng_grp();
				  disp_rec1(0);
				  strcpy(billing_grp_catg.arr,d_billing_grp_catg.arr);
				}
			else
				{
				  fetch_patient_name();
				   fetch_ward();
				  fetch_blng_grp();			  
				  disp_rec1(1);
				  strcpy(billing_grp_catg.arr,d_billing_grp_catg.arr);
				}
         }

      print_end_of_rep();
     }
	 else
		{
		 while (fetch_discharge_dtl())
		    {
			    get_discharge_adv_date();
			    get_cust_name();
		       if (strcmp(discharge_bill_date_time.arr,d_discharge_bill_date_time.arr) != 0)
					{
					  fetch_ward();
				      fetch_patient_name();
					  fetch_blng_grp();
					  fetch_blng_grp_catg();
					  disp_rec2(0);
					  strcpy(discharge_bill_date_time.arr,d_discharge_bill_date_time.arr);
					}
				else
					{
					 fetch_ward();
					  fetch_patient_name();
					  fetch_blng_grp();	
					  fetch_blng_grp_catg();		  
					  disp_rec2(1);
					  strcpy(discharge_bill_date_time.arr,d_discharge_bill_date_time.arr);
					}
			 }

		 print_end_of_rep();
	  }


 /* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )134;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");

fprintf(fp,"%c",0x12); /*** Set Dot-matrix Printer to Normal Mode ***/

 }


 declare_cur()
{

	/* EXEC SQL DECLARE PATIENT_DISCHARGE_CUR CURSOR FOR 
	select E.BLNG_GRP_CATG,A.BLNG_GRP_ID, a.PATIENT_ID,
	a.EPISODE_ID, D.CUR_WARD_CODE,
	to_char(a.ADMISSION_DATE_TIME,'DD/MM/YYYY'),
	TO_CHAR(a.DISCHARGE_DATE_TIME,'DD/MM/YYYY') ,
	A.CUST_CODE, D.ENCOUNTER_ID,
	NVL(A.DISCHARGED_YN,'N'),
	NVL(A.TOT_UNBLD_AMT,0)-NVL(A.TOT_UNADJ_DEP_AMT,0) -NVL(A.TOT_UNADJ_PREP_AMT,0)AMOUNT,
	C.discharge_billing_stage   
	FROM   BL_EPISODE_FIN_DTLS A , BL_PARAMETERS C, IP_EPISODE D , BL_BLNG_GRP_BY_CATG E
	WHERE A.OPERATING_FACILITY_ID = :nd_facility
	AND A.EPISODE_TYPE IN( 'I','D')
	AND A.EPISODE_ID   = D.EPISODE_ID
	AND A.OPERATING_FACILITY_ID = D.FACILITY_ID
	AND D.FACILITY_ID = C.OPERATING_FACILITY_ID
	AND A.BLNG_GRP_ID = E.BLNG_GRP_ID
	AND A.BLNG_GRP_ID BETWEEN  NVL(:nd_blng_grp_f,'!!') AND NVL(:nd_blng_grp_t,'~~') 
	AND D.CUR_WARD_CODE BETWEEN NVL(:nd_ward_f,'!!!!') and NVL(:nd_ward_t,'~~~~')
	AND trunc(a.DISCHARGE_DATE_TIME) BETWEEN to_date(:nd_dischrg_dt_f,'DD-MON-YYYY') AND to_date(:nd_dischrg_dt_t,'DD-MON-YYYY')
	AND E.BLNG_GRP_CATG BETWEEN  NVL(:nd_blng_grp_catg_f,'!') AND NVL(:nd_blng_grp_catg_t,'~')
	AND ((C.discharge_billing_stage ='2'  AND NVL(A.DISCHARGE_BILL_GEN_IND,'N') = 'N'
	and nvl(DISCHARGED_YN,'N') = 'Y'  )
	or (c.discharge_billing_stage ='1' and NVL(A.DISCHARGE_BILL_GEN_IND,'N') = 'N'
	and A.epIsode_id in (select episode_id from BL_IP_DISCHARGE_ADVICE_VW
	where nvl(DIS_ADV_STATUS,'0') != '9')and nvl(DISCHARGED_YN,'N') = 'N'))
	ORDER BY DECODE(:nd_order,'B',A.BLNG_GRP_ID,'W',D.CUR_WARD_CODE,'C',E.BLNG_GRP_CATG,TO_CHAR(a.DISCHARGE_DATE_TIME,'YYYY/MM/DD')); */ 


  }
	

open_pat_dis_cur() 
  {

	/* EXEC SQL OPEN PATIENT_DISCHARGE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select E.BLNG_GRP_CATG ,A.BLNG_GRP_ID ,a.PATIENT_ID ,a.EPISODE_ID ,D.CUR\
_WARD_CODE ,to_char(a.ADMISSION_DATE_TIME,'DD/MM/YYYY') ,TO_CHAR(a.DISCHARGE\
_DATE_TIME,'DD/MM/YYYY') ,A.CUST_CODE ,D.ENCOUNTER_ID ,NVL(A.DISCHARGED_YN,'\
N') ,((NVL(A.TOT_UNBLD_AMT,0)-NVL(A.TOT_UNADJ_DEP_AMT,0))-NVL(A.TOT_UNADJ_PR\
EP_AMT,0)) AMOUNT ,C.discharge_billing_stage  from BL_EPISODE_FIN_DTLS A ,BL\
_PARAMETERS C ,IP_EPISODE D ,BL_BLNG_GRP_BY_CATG E where ((((((((((A.OPERATI\
NG_FACILITY_ID=:b0 and A.EPISODE_TYPE in ('I','D')) and A.EPISODE_ID=D.EPISO\
DE_ID) and A.OPERATING_FACILITY_ID=D.FACILITY_ID) and D.FACILITY_ID=C.OPERAT\
ING_FACILITY_ID) and A.BLNG_GRP_ID=E.BLNG_GRP_ID) and A.BLNG_GRP_ID between \
NVL(:b1,'!!') and NVL(:b2,'~~')) and D.CUR_WARD_CODE between NVL(:b3,'!!!!')\
 and NVL(:b4,'~~~~')) and trunc(a.DISCHARGE_DATE_TIME) between to_date(:b5,'\
DD-MON-YYYY') and to_date(:b6,'DD-MON-YYYY')) and E.BLNG_GRP_CATG between NV\
L(:b7,'!') and NVL(:b8,'~')) and (((C.discharge_billing_stage='2' and NVL(A.\
DISCHARGE_BILL_GEN_IND,'N')='N') and nvl");
 sqlstm.stmt = sq0005;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )149;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_blng_grp_f;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_blng_grp_t;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_ward_f;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_ward_t;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_dischrg_dt_f;
 sqlstm.sqhstl[5] = (unsigned int  )14;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_dischrg_dt_t;
 sqlstm.sqhstl[6] = (unsigned int  )14;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_blng_grp_catg_f;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_blng_grp_catg_t;
 sqlstm.sqhstl[8] = (unsigned int  )7;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_order;
 sqlstm.sqhstl[9] = (unsigned int  )5;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
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
        err_mesg("OPEN failed on cursor PATIENT_DISCHARGE_CUR",0,"");
   }

close_pat_dis_cur()
   {

	/* EXEC SQL CLOSE PATIENT_DISCHARGE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )204;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
	}

fetch_discharge_dtl()
{

			d_blng_grp_id.arr[0]			= '\0';				
	        d_description.arr[0]			= '\0';				
			d_patient_id.arr[0]				= '\0';							
            d_episode_id.arr[0]				= '\0';				
			d_cur_ward_code.arr[0]			= '\0';					
			d_admission_date_time.arr[0]	= '\0';			
			d_discharge_bill_date_time.arr[0]	= '\0';		
			d_cust_code.arr[0]				= '\0';					
            d_discharge_yn.arr[0]			=  '\0';
            d_encounter_id.arr[0]					=  '\0';
			d_discharge_billing_stage.arr[0]		= '\0';
			d_billing_grp_catg.arr[0] ='\0';	
			d_blng_grp_id.len		=0;				
	      			
			d_patient_id.len		=0;					
            d_episode_id.len		=0;					
			d_cur_ward_code.len		=0;					
			d_admission_date_time.len		=0;				
			d_discharge_bill_date_time.len		=0;			
			d_cust_code.len		=0;	
			d_encounter_id.len	=0;					
			d_discharge_yn.len	=0;
			d_discharge_billing_stage.len =0;
			d_billing_grp_catg.len =0;
   /* EXEC SQL FETCH PATIENT_DISCHARGE_CUR 
               INTO 
			:d_billing_grp_catg,
            :d_blng_grp_id,				
			:d_patient_id,					
            :d_episode_id,						
			:d_cur_ward_code,							
			:d_admission_date_time,				
			:d_discharge_bill_date_time,				
			:d_cust_code,
			:d_encounter_id,
			:d_discharge_yn,
			:d_amount,
			 :d_discharge_billing_stage; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )219;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_billing_grp_catg;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_id;
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
   sqlstm.sqhstv[3] = (         void  *)&d_episode_id;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_cur_ward_code;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_admission_date_time;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_discharge_bill_date_time;
   sqlstm.sqhstl[6] = (unsigned int  )23;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_cust_code;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_encounter_id;
   sqlstm.sqhstl[8] = (unsigned int  )15;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_discharge_yn;
   sqlstm.sqhstl[9] = (unsigned int  )4;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_amount;
   sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_discharge_billing_stage;
   sqlstm.sqhstl[11] = (unsigned int  )4;
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
       err_mesg("FETCH failed on cursor PATIENT_DISCHARGE_CUR",0,"");	

			d_billing_grp_catg.arr[d_billing_grp_catg.len]	= '\0';	
     	    d_blng_grp_id.arr[d_blng_grp_id.len]	= '\0';								
			d_patient_id.arr[d_patient_id.len]		= '\0';						
            d_episode_id.arr[d_episode_id.len]		= '\0';							
			d_cur_ward_code.arr[d_cur_ward_code.len]		= '\0';						
			d_admission_date_time.arr[d_admission_date_time.len] = '\0';						
			d_discharge_bill_date_time.arr[d_discharge_bill_date_time.len]		= '\0';				
			d_cust_code.arr[d_cust_code.len]	= '\0';	
			d_encounter_id.arr[d_encounter_id.len] = '\0';
			d_discharge_yn.arr[d_discharge_yn.len]	='\0';
			d_discharge_billing_stage.arr[d_discharge_billing_stage.len]  = '\0';	
		
			
		return(LAST_ROW?0:1);
}

fetch_blng_grp()
	{
	    d_description.arr[0]  ='\0';
        d_description.len		=0;	
	/* EXEC SQL SELECT  SHORT_DESC into :d_description FROM BL_BLNG_GRP 
	          WHERE blng_grp_id=:d_blng_grp_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_DESC into :b0  from BL_BLNG_GRP where blng_grp_\
id=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )282;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_description;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_id;
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
	}


fetch_patient_name()
    {
             d_patient.arr[0]  ='\0';
             d_patient.len		=0;

	 /* EXEC SQL SELECT SHORT_NAME INTO
			   :d_patient
                FROM MP_PATIENT_MAST
                WHERE PATIENT_ID = :d_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SHORT_NAME into :b0  from MP_PATIENT_MAST where PATI\
ENT_ID=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )305;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_patient;
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



			 d_patient.arr[d_patient.len] ='\0';
   }


get_discharge_adv_date()
 {
   if(strcmp(d_discharge_yn.arr,"N")==0)
    {
	     d_disc_adv_time.arr[0]		='\0';       
         d_disc_adv_time.len		=0;

    /* EXEC SQL SELECT to_char(DIS_ADV_DATE_TIME,'dd/mm/yyyy') INTO :d_disc_adv_time 
             FROM BL_IP_DISCHARGE_ADVICE_VW 
	     WHERE facility_id=:nd_facility
	     AND PATIENT_ID=:d_patient_id
	     AND encounter_id=:d_encounter_id
	     AND nvl(dis_adv_status,'!') != '9'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select to_char(DIS_ADV_DATE_TIME,'dd/mm/yyyy') into :b0  \
from BL_IP_DISCHARGE_ADVICE_VW where (((facility_id=:b1 and PATIENT_ID=:b2) an\
d encounter_id=:b3) and nvl(dis_adv_status,'!')<>'9')";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )328;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_disc_adv_time;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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
    sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_encounter_id;
    sqlstm.sqhstl[3] = (unsigned int  )15;
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



          d_disc_adv_time.arr[d_disc_adv_time.len]	='\0';

     strcpy(nd_discharged_adv_date.arr,d_disc_adv_time.arr);

    }

   else
      strcpy(nd_discharged_adv_date.arr,d_discharge_bill_date_time.arr);
  }

 get_cust_name()
 {
	d_cust_name.arr[0] = '\0';
		d_cust_name.len = 0;

		/* EXEC SQL select short_name into :d_cust_name
			 from ar_customer 
			 where cust_code = :d_cust_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select short_name into :b0  from ar_customer where cust_cod\
e=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )359;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_cust_name;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_cust_code;
  sqlstm.sqhstl[1] = (unsigned int  )11;
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


		d_cust_name.arr[d_cust_name.len] = '\0';
 }

fetch_ward()
	{
                d_ward.arr[0]		='\0';
				d_ward.len			=0;

      /* EXEC SQL SELECT SHORT_DESC INTO :d_ward FROM IP_WARD WHERE
			   FACILITY_ID=:nd_facility 
			   AND WARD_CODE=:d_cur_ward_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 14;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select SHORT_DESC into :b0  from IP_WARD where (FACILIT\
Y_ID=:b1 and WARD_CODE=:b2)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )382;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_ward;
      sqlstm.sqhstl[0] = (unsigned int  )18;
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
      sqlstm.sqhstv[2] = (         void  *)&d_cur_ward_code;
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



				d_ward.arr[d_ward.len]		='\0';

	}
// ADDED FOR CRF-346  BY RAVIKIRAN SHRIHARI ON 21/04/2009 START
fetch_blng_grp_catg()
	{
		d_blng_catg.arr[0]    ='\0';
		d_blng_catg.len		  =0;
		/* EXEC SQL SELECT SHORT_DESC INTO  :billing_grp_catg  FROM BL_BLNG_GRP_CATG
				 WHERE  BLNG_GRP_CATG = :d_billing_grp_catg; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SHORT_DESC into :b0  from BL_BLNG_GRP_CATG where BLN\
G_GRP_CATG=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )409;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&billing_grp_catg;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_billing_grp_catg;
  sqlstm.sqhstl[1] = (unsigned int  )6;
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


				 
		billing_grp_catg.arr[billing_grp_catg.len]     ='\0';
	}

// ADDED FOR CRF-346  BY RAVIKIRAN SHRIHARI ON 21/04/2009  END

	open_file()
{

    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00062.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00062.lis");
       proc_exit();
    }
	
}


get_header_dtls()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    d_acc_entity_name.arr[0] ='\0';
    d_curr_date.arr[0]   ='\0';
	d_user.arr[0] ='\0';
    d_sysdate.arr[0] ='\0';
    d_acc_entity_name.len =0;
    d_curr_date.len   =0;
	d_user.len =0;
    d_sysdate.len =0;

	/* EXEC SQL SELECT upper(ACC_ENTITY_NAME), /o description of the institution o/
		   USER, TO_CHAR(SYSDATE, 'DD/MM/YYYY'),TO_CHAR(SYSDATE, 'HH24:MI:SS')
      INTO :d_acc_entity_name,
		   :d_user, :d_sysdate,:d_curr_date
      FROM SY_ACC_ENTITY
	 WHERE acc_entity_id = :nd_facility; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,USER ,TO_CHAR(SYSDATE,'DD/MM/\
YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY\
 where acc_entity_id=:b4";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )432;
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
 sqlstm.sqhstl[3] = (unsigned int  )13;
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
	d_curr_date.arr[d_curr_date.len]			 = '\0';

   
	return;
	err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )467;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	proc_exit();
}

print_head()
{

     print_page_title();
  	 //print_line('-',130);
	// next_line(1);
     if(strcmp(nd_order.arr,"B")==0) 
	print_billing_head();
     else if(strcmp(nd_order.arr,"W")==0) 
	 print_ward_head();
     else if(strcmp(nd_order.arr,"C")==0) 
	 print_catg_head(); 
	 else 
	 print_date_head();	  
     print_line('-',REP_WIDTH); 
     next_line(1);
  }

print_page_title()
  {

	int hosp_nm_len, rep_title_len = 10, s1, s2,date_len,user_len,pgm_len;
	char v_rep_title[200],v_as_on_date[12];
	
	fprintf(fp,"MDL : BL");
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	//horz_skip(s1-18);
	fprintf(fp,"%-38.38s %-28.28s"," ",d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	//horz_skip(s2-14);
	fprintf(fp,"%61.61s %-12s: %s", " ",loc_legend[14],d_sysdate.arr);
    
	fprintf(fp,"\n");
	
	fprintf(fp,"OPR : %-10.10s", d_user.arr); 	
        user_len=strlen(d_user.arr);
	if (strcmp(d_discharge_billing_stage.arr,"1")==0)
	strcpy(v_rep_title,loc_legend[21]);
	else
    strcpy(v_rep_title,loc_legend[1]);	

	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	//horz_skip(s1-user_len-6);
	fprintf(fp,"%-30.30s %-52.52s"," ",v_rep_title);


	s2 = (REP_WIDTH-s1-52);
	//horz_skip(s2-14);
		fprintf(fp,"%-37.37s %-12s:%9s\n"," ",loc_legend[15],d_curr_date.arr);



	
	fprintf(fp,"REP : %-10.10s",d_curr_pgm_name.arr);
    pgm_len=strlen(d_curr_pgm_name.arr);
	strcpy(v_as_on_date,d_sysdate.arr);
	date_len= strlen(v_as_on_date);
	s1 = (REP_WIDTH-date_len-5)/2;
	//horz_skip(s1-pgm_len);
	//horz_skip(s2-11);
	
	 fprintf(fp,"%-30.30s %-6.6s "," ",loc_legend[23]);
	 fprintf(fp,"%-20.20s",v_as_on_date);
        s2 = (REP_WIDTH-s1-date_len-5);
	    horz_skip(s2-20);
		fprintf(fp,"%-12s: %-d\n",loc_legend[16],++page_no);

	lctr = 4;

	print_line('-',REP_WIDTH); next_line(1);

	
}

//-----------
print_page_header()
{
int l1;
fprintf (fp,"%c&l1O",ESC);
fprintf (fp, "%c(s17H", ESC);
//fprintf (fp,"%cg", ESC);
  print_page_title();
 // fprintf(fp,"VER       : 4.1 ");
   next_line(1);
  //print_line('-',REP_WIDTH);
  next_line(1);
  next_line(1);next_line(1);next_line(1);next_line(1);next_line(1);
  fprintf(fp,"           INPUT PARAMETER ");
  next_line(1);
  fprintf(fp,"           --------------- ");
    next_line(1);
  //l1=(REP_WIDTH-25)/2;
  horz_skip(25);
    if(strcmp(nd_date_frm_flag.arr,"N")==0)
		  
	   if (strcmp(nd_date_to_flag.arr,"N")==0)
	
			fprintf(fp,"  %-22s : %-12s ",loc_legend[10],loc_legend[24]);
	   else
		
			fprintf(fp,"  %-22s : %-5s %-10s %-3s %-15s",loc_legend[10],loc_legend[17],loc_legend[26],loc_legend[18],nd_dischrg_dt_t.arr);
   	
    else
	   if (strcmp(nd_date_to_flag.arr,"N")==0) 
	    fprintf(fp,"  %-22s : %-5s %-10s %-3s %-15s",loc_legend[10],loc_legend[17],nd_dischrg_dt_f.arr,loc_legend[18],loc_legend[27]);
   
	   else
	  fprintf(fp,"  %-22s : %-5s %-10s %-3s %-15s",loc_legend[10],loc_legend[17],nd_dischrg_dt_f.arr,loc_legend[18],nd_dischrg_dt_t.arr);
	 
   next_line(1);

   
  horz_skip(25);
    if(strcmp(nd_blng_grp_catg_f.arr,"!!!!")==0)
		  
	   if (strcmp(nd_blng_grp_catg_t.arr,"~~~~")==0)
	
			fprintf(fp,"  %-22.22s : %-12s ",loc_legend[25],loc_legend[24]);
	   else
		
			fprintf(fp,"  %-22.22s : %-5s %-10s %-3s %-10s",loc_legend[25],loc_legend[17],loc_legend[26],loc_legend[18],nd_blng_grp_catg_t.arr);
   	
    else
	   if (strcmp(nd_blng_grp_catg_t.arr,"~~~~")==0) 
	    fprintf(fp,"  %-22.22s : %-5s %-10s %-3s %-10s",loc_legend[25],loc_legend[17],nd_blng_grp_catg_f.arr,loc_legend[18],loc_legend[27]);
   
	   else
	  fprintf(fp,"  %-22.22s : %-5s %-10s %-3s %-10s",loc_legend[25],loc_legend[17],nd_blng_grp_catg_f.arr,loc_legend[18],nd_blng_grp_catg_t.arr);
	 
   next_line(1);

  horz_skip(25);
    if(strcmp(nd_blng_grp_f.arr,"!!!!")==0)
		  
	   if (strcmp(nd_blng_grp_t.arr,"~~~~")==0)
	
			fprintf(fp,"  %-22.22s : %-12s ",loc_legend[2],loc_legend[24]);
	   else
		
			fprintf(fp,"  %-22.22s : %-5s %-10s %-3s %-10s",loc_legend[2],loc_legend[17],loc_legend[26],loc_legend[18],nd_blng_grp_t.arr);
   	
    else
	   if (strcmp(nd_blng_grp_t.arr,"~~~~")==0) 
	    fprintf(fp,"  %-22.22s : %-5s %-10s %-3s %-10s",loc_legend[2],loc_legend[17],nd_blng_grp_f.arr,loc_legend[18],loc_legend[27]);
   
	   else
	  fprintf(fp,"  %-22.22s : %-5s %-10s %-3s %-10s",loc_legend[2],loc_legend[17],nd_blng_grp_f.arr,loc_legend[18],nd_blng_grp_t.arr);
	 
   next_line(1);
  
   horz_skip(25);
   /* if(strcmp(nd_ward_f.arr,"!!!!" )== 0)                                 
      fprintf(fp,"  %-16.16s : %-12s ",loc_legend[7],loc_legend[24]);
    else
      fprintf(fp,"  %-16.16s : %-5s %-5s %-3s %-5s",loc_legend[7],loc_legend[17],nd_ward_f.arr,loc_legend[18],nd_ward_t.arr);
   next_line(1);
   horz_skip(25);
    if(strcmp(nd_order.arr,"B")==0)
      fprintf(fp,"  %-16.16s : %-9s",loc_legend[19],loc_legend[2]);
	else
      fprintf(fp,"  %-16.16s : %-9s",loc_legend[19],loc_legend[7]);*/


    if(strcmp(nd_ward_f.arr,"!!!!")==0)
		  
	   if (strcmp(nd_ward_t.arr,"~~~~")==0)
	
			fprintf(fp,"  %-22.22s : %-12s ",loc_legend[7],loc_legend[24]);
	   else
		
			fprintf(fp,"  %-22.22s : %-5s %-10s %-3s %-10s",loc_legend[7],loc_legend[17],loc_legend[26],loc_legend[18],nd_ward_t.arr);
   	
    else
	   if (strcmp(nd_ward_t.arr,"~~~~")==0) 
	    fprintf(fp,"  %-22.22s : %-5s %-10s %-3s %-10s",loc_legend[7],loc_legend[17],nd_ward_f.arr,loc_legend[18],loc_legend[27]);
   
	   else
	  fprintf(fp,"  %-22.22s : %-5s %-10s %-3s %-10s",loc_legend[7],loc_legend[17],nd_ward_f.arr,loc_legend[18],nd_ward_t.arr);
	 
   next_line(1);
   horz_skip(25);
    if(strcmp(nd_order.arr,"B")==0)
      fprintf(fp,"  %-22.22s : %-9s",loc_legend[19],loc_legend[2]);
	else if(strcmp(nd_order.arr,"W")==0)
      fprintf(fp,"  %-22.22s : %-9s",loc_legend[19],loc_legend[7]);
    else if(strcmp(nd_order.arr,"C")==0)
      fprintf(fp,"  %-22.22s : %-9s",loc_legend[19],loc_legend[25]);
    else 
      fprintf(fp,"  %-22.22s : %-9s",loc_legend[19],loc_legend[10]);



       next_page();

}

//----------------

print_billing_head()
 {


 fprintf(fp,"%-19.19s %-5.5s %-20.20s %-9.9s %-16.16s %-21.21s %-22.22s %-14.14s %-15.15s %-13.13s %14.14s",loc_legend[2],loc_legend[3],loc_legend[4],loc_legend[5],loc_legend[6],loc_legend[25],loc_legend[7],loc_legend[8],loc_legend[10],loc_legend[12],loc_legend[13]); 
 next_line(1);
 /*
 if(strcmp(d_discharge_billing_stage.arr,"1")==0)
  {
 fprintf(fp,"%-19.19s%-75.75s%-21.21s%-11.11s%-11.11s%-9.9s" ," "," "," ",loc_legend[14],loc_legend[11],loc_legend[22]);
  next_line(1);
 fprintf(fp,"%127.127s%-21.21s"," ",loc_legend[14]);
   }
 else
fprintf(fp,"%-19.19s%-75.75s%-21.21s%-11.11s%-11.11s%-9.9s" ," "," "," ",loc_legend[14],loc_legend[14],loc_legend[22]);
 next_line(1);
 */
 
 }	 

print_ward_head()
 {
 
 fprintf(fp,"%-19.19s %-5.5s %-20.20s %-9.9s %-16.16s %-22.22s %-21.21s %-14.14s %-15.15s %-13.13s %14.14s",loc_legend[7],loc_legend[3],loc_legend[4],loc_legend[5],loc_legend[6],loc_legend[25],loc_legend[2],loc_legend[8],loc_legend[10],loc_legend[12],loc_legend[13]); 
 next_line(1);
 /*
 if(strcmp(d_discharge_billing_stage.arr,"1")==0)
  {
 fprintf(fp,"%-21.21s%-75.75s%-19.19s%-11.11s%-11.11s%-9.9s" ," "," "," ",loc_legend[14],loc_legend[11],loc_legend[22]);
  next_line(1);
 fprintf(fp,"%129.129s%-19.19s"," ",loc_legend[14]);
   }
 else
fprintf(fp,"%-21.21s%-75.75s%-191.9s%-11.11s%-11.11s%-9.9s" ," "," "," ",loc_legend[14],loc_legend[14],loc_legend[22]);
 next_line(1);
 */

 }	
 
 print_catg_head()
 {


  fprintf(fp,"%-22.22s  %-5.5s %-20.20s %-9.9s %-16.16s %-19.19s %-20.20s %-14.14s %-15.15s %-13.13s %14.14s",loc_legend[25],loc_legend[3],loc_legend[4],loc_legend[5],loc_legend[6],loc_legend[7],loc_legend[2],loc_legend[8],loc_legend[10],loc_legend[12],loc_legend[13]); 
  next_line(1);
 }

 print_date_head()
 {


 fprintf(fp,"%-18.18s %-4.4s %-20.20s %-9.9s %-15.15s %-21.21s %-21.21s  %-20.20s %-15.15s %-10.10s %14.14s",loc_legend[10],loc_legend[3],loc_legend[4],loc_legend[5],loc_legend[6],loc_legend[25],loc_legend[2],loc_legend[7],loc_legend[8],loc_legend[12],loc_legend[13]); 
 next_line(1);

 
 }
print_rec(ind)
int ind;
 {
   if (ind == 0)
     { 	
      slno=1;
      if (lctr > 40)
	    print_head();
		//fprintf(fp,"%-3.3s%-16.16s%-4d%-21.21s%-9.9s%-40.40s %-5.5s%-16.16s%-14.14s%-14.14s%-16.16s",d_blng_grp_id.arr,d_description.arr,slno,d_patient_id.arr,d_episode_id.arr,d_patient.arr,d_cur_ward_code.arr,d_ward.arr,d_admission_date_time.arr,nd_discharged_adv_date.arr,d_cust_name.arr);
		fprintf(fp,"%-3.3s %-16.16s %-4d %-20.20s %-9.9s %-16.16s %-5.5s %-15.15s %-5.5s %-16.16s %-14.14s %-15.15s %-14.14s",d_blng_grp_id.arr,d_description.arr,slno,d_patient_id.arr,d_episode_id.arr,d_patient.arr,d_billing_grp_catg.arr,billing_grp_catg.arr,d_cur_ward_code.arr,d_ward.arr,d_admission_date_time.arr,nd_discharged_adv_date.arr,d_cust_name.arr);
		print_formated(d_amount);
		next_line(1);
      
     }
   else
     {
    slno=slno+1;
       if (lctr > 40)
        print_head();
	//	fprintf(fp,"%-3.3s%-16.16s%-4d%-21.21s%-9.9s%-40.40s %-5.5s%-16.16s%-14.14s%-14.14s%-16.16s"," "," ",slno,d_patient_id.arr,d_episode_id.arr,d_patient.arr,d_cur_ward_code.arr,d_ward.arr,d_admission_date_time.arr,nd_discharged_adv_date.arr,d_cust_name.arr);
		fprintf(fp,"%-3.3s %-16.16s %-4d %-20.20s %-9.9s %-16.16s %-5.5s %-15.15s %-5.5s %-16.16s %-14.14s %-15.15s %-14.14s"," "," ",slno,d_patient_id.arr,d_episode_id.arr,d_patient.arr,d_billing_grp_catg.arr,billing_grp_catg.arr,d_cur_ward_code.arr,d_ward.arr,d_admission_date_time.arr,nd_discharged_adv_date.arr,d_cust_name.arr);
		print_formated(d_amount);
		next_line(1);
	 }
  }
  

disp_rec(ind)
int ind;
{
  if (ind == 0)
  { 	
       slno=1;
      if (lctr > 40)
	   print_head();
	   	
       //fprintf(fp,"%-5.5s%-16.16s%-4d%-21.21s%-9.9s%-40.40s %-3.3s%-16.16s%-14.14s%-14.14s%-16.16s",d_cur_ward_code.arr,d_ward.arr,slno,d_patient_id.arr,d_episode_id.arr,d_patient.arr,d_blng_grp_id.arr,d_description.arr,d_admission_date_time.arr,nd_discharged_adv_date.arr,d_cust_name.arr);
	   	fprintf(fp,"%-3.3s %-16.16s %-4d %-20.20s %-9.9s %-16.16s %-5.5s %-15.15s %-5.5s %-16.16s %-14.14s %-15.15s %-14.14s",d_cur_ward_code.arr,d_ward.arr,slno,d_patient_id.arr,d_episode_id.arr,d_patient.arr,d_billing_grp_catg.arr,billing_grp_catg.arr,d_blng_grp_id.arr,d_description.arr,d_admission_date_time.arr,nd_discharged_adv_date.arr,d_cust_name.arr);
	
	   print_formated(d_amount);
	   next_line(1);
      
  }
 else
    {
      slno=slno+1;
        if (lctr > 40)
        print_head();
	//	fprintf(fp,"%-5.5s%-16.16s%-4d%-21.21s%-9.9s%-40.40s %-3.3s%-16.16s%-14.14s%-14.14s%-16.16s"," "," ",slno,d_patient_id.arr,d_episode_id.arr,d_patient.arr,d_blng_grp_id.arr,d_description.arr,d_admission_date_time.arr,nd_discharged_adv_date.arr,d_cust_name.arr);
		fprintf(fp,"%-3.3s %-16.16s %-4d %-20.20s %-9.9s %-16.16s %-5.5s %-15.15s %-5.5s %-16.16s %-14.14s %-15.15s %-14.14s"," "," ",slno,d_patient_id.arr,d_episode_id.arr,d_patient.arr,d_billing_grp_catg.arr,billing_grp_catg.arr,d_blng_grp_id.arr,d_description.arr,d_admission_date_time.arr,nd_discharged_adv_date.arr,d_cust_name.arr);
		print_formated(d_amount);
		next_line(1);
	}
    } 

disp_rec1(ind)
int ind;
{
  if (ind == 0)
  { 	
       slno=1;
      if (lctr > 40)
	   print_head();
	   	
       	fprintf(fp,"%-3.3s %-20.20s %-4d %-20.20s %-9.9s %-16.16s %-3.3s %-15.15s %-3.3s %-16.16s %-14.14s %-15.15s %-14.14s",d_billing_grp_catg.arr,billing_grp_catg.arr,slno,d_patient_id.arr,d_episode_id.arr,d_patient.arr,d_cur_ward_code.arr,d_ward.arr,d_blng_grp_id.arr,d_description.arr,d_admission_date_time.arr,nd_discharged_adv_date.arr,d_cust_name.arr);
	
	   print_formated(d_amount);
	   next_line(1);
      
  }
 else
    {
      slno=slno+1;
        if (lctr > 40)
        print_head();
		fprintf(fp,"%-3.3s %-20.20s %-4d %-20.20s %-9.9s %-16.16s %-3.3s %-15.15s %-3.3s %-16.16s %-14.14s %-15.15s %-14.14s"," "," ",slno,d_patient_id.arr,d_episode_id.arr,d_patient.arr,d_cur_ward_code.arr,d_ward.arr,d_blng_grp_id.arr,d_description.arr,d_admission_date_time.arr,nd_discharged_adv_date.arr,d_cust_name.arr);
		print_formated(d_amount);
		next_line(1);
	}
    } 
  
disp_rec2(ind)
int ind;
{
  if (ind == 0)
  { 	
       slno=1;
      if (lctr > 40)
	   print_head();
	   	
       	fprintf(fp,"%-18.18s %-4d %-20.20s %-9.9s %-15.15s %-5.5s %-15.15s %-5.5s %-16.16s %-3.3s %-16.16s %-15.15s %-11.11s",nd_discharged_adv_date.arr,slno,d_patient_id.arr,d_episode_id.arr,d_patient.arr,d_billing_grp_catg.arr,billing_grp_catg.arr,d_blng_grp_id.arr,d_description.arr,d_cur_ward_code.arr,d_ward.arr,d_admission_date_time.arr,d_cust_name.arr);
	
	   print_formated(d_amount);
	   next_line(1);
      
  }
 else
    {
      slno=slno+1;
        if (lctr > 40)
        print_head();
		fprintf(fp,"%-18.18s %-4d %-20.20s %-9.9s %-15.15s %-5.5s %-15.15s %-5.5s %-16.16s %-3.3s %-16.16s %-15.15s %-11.11s"," ",slno,d_patient_id.arr,d_episode_id.arr,d_patient.arr,d_billing_grp_catg.arr,billing_grp_catg.arr,d_blng_grp_id.arr,d_description.arr,d_cur_ward_code.arr,d_ward.arr,d_admission_date_time.arr,d_cust_name.arr);
			print_formated(d_amount);
		next_line(1);
	}
    } 
   	
/****************************************************************************/
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
		fprintf(fp,"\n"); ++lctr; //fprintf(fp,"LNNO:%2d",lctr); 
	}
}

next_page() /* will move the cursor to next page */
{
	fprintf(fp,"\n");
	fprintf(fp,"\f");
	fprintf(fp,"\n");  
	print_head(); 	
}

/*************************************************************************/
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

fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00062.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00062.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )482;
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
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )505;
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



/*************************************************************************/
print_end_of_rep()
{
	int col;
    next_line(1);
	//for (col = 0; col < (90 -23)/2; col++)
	//fprintf(fp," "); 
	horz_skip((REP_WIDTH-23)/2);
	fprintf(fp,"***  END OF REPORT  ***");
	fflush(fp);
    fclose(fp);
	//fprintf(fp,"%cE",ESC);
}
/****************************************************************************/

   

