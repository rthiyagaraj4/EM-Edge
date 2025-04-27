
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
           char  filnam[45];
};
static const struct sqlcxp sqlfpn =
{
    44,
    "D:\\Issues\\Facility name chgs\\rep\\Blrdlrev.pc"
};


static unsigned long sqlctx = 1529988645;


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
            void  *sqhstv[14];
   unsigned int   sqhstl[14];
            int   sqhsts[14];
            void  *sqindv[14];
            int   sqinds[14];
   unsigned int   sqharm[14];
   unsigned int   *sqharc[14];
   unsigned short  sqadto[14];
   unsigned short  sqtdso[14];
} sqlstm = {10,14};

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

 static const char *sq0006 = 
"select NVL(A.ORG_NET_CHARGE_AMT,0) ,A.BLNG_GRP_ID ,TO_CHAR(A.TRX_DATE,'YYYY\
MMDD') ,A.EPISODE_TYPE ,A.OPERATING_FACILITY_ID  from BL_PATIENT_CHARGES_FOLI\
O A ,BL_BLNG_PRT_GRP_HDR B where (((((A.OPERATING_FACILITY_ID between NVL(:b0\
,'!!') and NVL(:b1,'~~') and A.TRX_DATE between TO_DATE(:b2,'YYYYMMDD') and T\
O_DATE(:b3,'YYYYMMDD')) and NVL(A.TRX_FINALIZE_IND,'N')='Y') and NVL(A.CONFIR\
MED_YN,'N')='Y') and A.PRT_GRP_HDR_CODE=B.PRT_GRP_HDR_CODE) and NVL(B.INCOME_\
YN,'N')='Y') order by A.OPERATING_FACILITY_ID,EPISODE_TYPE,BLNG_GRP_ID,TRUNC(\
TRX_DATE)            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,146,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,270,0,4,184,0,0,14,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
107,0,0,3,158,0,4,240,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
142,0,0,4,0,0,30,274,0,0,0,0,0,1,0,
157,0,0,5,91,0,2,281,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
180,0,0,6,558,0,9,318,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
211,0,0,7,105,0,4,344,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
238,0,0,6,0,0,13,591,0,0,5,0,0,1,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
273,0,0,8,96,0,4,627,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
300,0,0,9,73,0,4,730,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
323,0,0,10,96,0,4,849,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
346,0,0,11,105,0,4,853,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
369,0,0,12,165,0,6,861,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
400,0,0,13,49,0,4,874,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
427,0,0,14,140,0,6,888,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
454,0,0,15,64,0,4,947,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
477,0,0,16,69,0,4,951,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
};


/*****************************************************************************/
/*                            BLRDLREV.PC                                     */
/*****************************************************************************/
/* Created by Aldrin for AMH on 15/12/1996*/

/*                                        
 #define DEBUG
*/                                  
  
#define ESC 0x1B            
#define REP_WIDTH 80
#define INIT_MESG "Report Generation In Progress"
#include <stdio.h>
#include <string.h>
#include "bl.h"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd[91],
		    d_session_id[16],  
		    d_pgm_date[14],
            rep_date[20],
            comp_name[50],   
			l_comp_name[50],
            oper_id[21],
		    d_pgm_id[10]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[50]; } l_comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[10]; } d_pgm_id;

 	 
    /* VARCHAR nd_fr_last_yrd_date           [9],
            nd_to_last_yrd_date           [9],
			nd_fr_yrd_date                [9],
            nd_to_yrd_date                [9],            
			nd_fr_mth_date                [9],
            nd_to_mth_date                [9],  
            nd_fr_cur_mth_date            [9],
            nd_to_cur_mth_date            [9],
            nd_report_type                [2], 
			l_rep_date					  [25],
			l_len_value                   [9],
			 nd_fr_param_date              [9],
             nd_to_param_date              [9],            
			 nd_operating_facility_id      [3],
			 nd_fr_facility                [3],
			 nd_to_facility                [3],
			 nd_pre_facility_id			   [3],

             nd_episode_type               [2],
			 l_pk_value		    [100],
			 l_translated_value	[201],
			 p_language_id		[3],
			 nd_facility_id	    [3],

			 nd_temp_date[21],
			 nd_loc_date[21],
			 date_convert[21],
			 language_id[3],
			 user_id[10]; */ 
struct { unsigned short len; unsigned char arr[9]; } nd_fr_last_yrd_date;

struct { unsigned short len; unsigned char arr[9]; } nd_to_last_yrd_date;

struct { unsigned short len; unsigned char arr[9]; } nd_fr_yrd_date;

struct { unsigned short len; unsigned char arr[9]; } nd_to_yrd_date;

struct { unsigned short len; unsigned char arr[9]; } nd_fr_mth_date;

struct { unsigned short len; unsigned char arr[9]; } nd_to_mth_date;

struct { unsigned short len; unsigned char arr[9]; } nd_fr_cur_mth_date;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cur_mth_date;

struct { unsigned short len; unsigned char arr[2]; } nd_report_type;

struct { unsigned short len; unsigned char arr[25]; } l_rep_date;

struct { unsigned short len; unsigned char arr[9]; } l_len_value;

struct { unsigned short len; unsigned char arr[9]; } nd_fr_param_date;

struct { unsigned short len; unsigned char arr[9]; } nd_to_param_date;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_fr_facility;

struct { unsigned short len; unsigned char arr[3]; } nd_to_facility;

struct { unsigned short len; unsigned char arr[3]; } nd_pre_facility_id;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[3]; } language_id;

struct { unsigned short len; unsigned char arr[10]; } user_id;

            

    /* VARCHAR  d_blng_grp_id                [5],
             d_prev_blng_id               [5],
             d_trx_date                   [9],
             d_episode_type               [2],
			 d_operating_facility_id      [3],
			 d_prv_opr_facility_id		  [3]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[5]; } d_prev_blng_id;

struct { unsigned short len; unsigned char arr[9]; } d_trx_date;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[3]; } d_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } d_prv_opr_facility_id;

    
    /* VARCHAR  d_prev_episode_type          [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } d_prev_episode_type;

    
    /* VARCHAR  d_prt_grp_desc               [40]; */ 
struct { unsigned short len; unsigned char arr[40]; } d_prt_grp_desc;

       
        char  stmt_s1					  [500];     
	    char filename[150];
		char x_msg[200];
		char loc_legend[999][201];
		char l_mesg[200],temp[100];


     double  d_upd_net_charge_amt;

	 int i;
int line_no;

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

FILE *f1;

int page_no;
   

char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1];
	 


char rep_title[60] = "DAILY REVENUE REPORT FOR -";
char rep_title1[60];

double p_tot_today     =0,
       p_month         =0,
       p_ytd           =0,
       p_last_mtd      =0,
       p_last_ytd      =0,
       p_epi_tot_today =0,
       p_epi_month     =0,
       p_epi_ytd       =0,
       p_epi_last_mtd  =0,
       p_epi_last_ytd  =0,
       g_tot_today     =0,
       g_month         =0,
       g_ytd           =0,
       g_last_mtd      =0,
       g_last_ytd      =0;


void proc_main(argc,argv)
int argc;
char *argv[];
{
	
    //disp_message(ERR_MESG,"calling........");

	if(argc != 5) 
	{
		disp_message(ERR_MESG,"BLRDLREV : Usage BLRDLREV userid/password session_id pgm_date facility_id \n");
		proc_exit();
	}

	strcpy(uid_pwd.arr,argv[1]);
	uid_pwd.len = strlen(uid_pwd.arr);

	strcpy(d_session_id.arr,argv[2]);
	d_session_id.len = strlen(d_session_id.arr);

	strcpy(d_pgm_date.arr,argv[3]);
	d_pgm_date.len = strlen(d_pgm_date.arr);

	strcpy(nd_facility_id.arr,argv[4]);
    nd_facility_id.len = strlen(nd_facility_id.arr);
    //strcpy(g_facility_id,nd_facility_id.arr);
  

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
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR) 
	{
		disp_message(ORA_MESG,"Unable to connect to oracle.\n");
		proc_exit();
	}

    
	set_meduser_role();
     	strcpy(p_language_id.arr,l_language_id.arr);
    	p_language_id.len = l_language_id.len;

	
	fetch_legend_value();

	nd_fr_last_yrd_date.arr[0]    = '\0';
	nd_to_last_yrd_date.arr[0]    = '\0';
	nd_fr_yrd_date.arr[0]         = '\0';
	nd_to_yrd_date.arr[0]         = '\0';   
	nd_fr_mth_date.arr[0]         = '\0';
	nd_to_mth_date.arr[0]         = '\0';   
	nd_fr_cur_mth_date.arr[0]     = '\0';
	nd_to_cur_mth_date.arr[0]     = '\0';   
	nd_report_type.arr[0]         = '\0';   
	nd_operating_facility_id.arr[0] = '\0';

	nd_fr_last_yrd_date.len       = 0;
	nd_to_last_yrd_date.len       = 0;
	nd_fr_yrd_date.len            = 0;
	nd_to_yrd_date.len            = 0;   
	nd_fr_mth_date.len            = 0;
	nd_to_mth_date.len            = 0;   
	nd_fr_cur_mth_date.len        = 0;
	nd_to_cur_mth_date.len        = 0;   
	nd_report_type.len            = 0;   
	nd_operating_facility_id.len  = 0;
	
	/* EXEC SQL SELECT OPERATING_FACILITY_ID,
					 PARAM1,
 	        		 PARAM2,
 	        		 PARAM3,
 	        		 PARAM4,
 	        		 PARAM5,
 	        		 PARAM6,
 	        		 PARAM7,
 	        		 PARAM8,
 	        		 PARAM9,
					 PARAM16,
					 PARAM17
 			  INTO   :nd_operating_facility_id,
					 :nd_fr_last_yrd_date,
					 :nd_to_last_yrd_date,
					 :nd_fr_mth_date,
					 :nd_to_mth_date,
					 :nd_fr_yrd_date,
					 :nd_to_yrd_date,
					 :nd_fr_cur_mth_date,
					 :nd_to_cur_mth_date,
					 :nd_report_type,
					 :nd_fr_facility,
					 :nd_to_facility
			  FROM   SY_PROG_PARAM
			  WHERE  PGM_ID     = 'BLRDLREV'
			  AND    PGM_DATE   = :d_pgm_date
			  AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM\
4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM16 ,PARAM17 into :b0,:b1,:b2,\
:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11  from SY_PROG_PARAM where ((PGM_ID='BLR\
DLREV' and PGM_DATE=:b12) and SESSION_ID=TO_NUMBER(:b13))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_fr_last_yrd_date;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_to_last_yrd_date;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_fr_mth_date;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_to_mth_date;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_fr_yrd_date;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_to_yrd_date;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_fr_cur_mth_date;
 sqlstm.sqhstl[7] = (unsigned int  )11;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_to_cur_mth_date;
 sqlstm.sqhstl[8] = (unsigned int  )11;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_report_type;
 sqlstm.sqhstl[9] = (unsigned int  )4;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_fr_facility;
 sqlstm.sqhstl[10] = (unsigned int  )5;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_to_facility;
 sqlstm.sqhstl[11] = (unsigned int  )5;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[12] = (unsigned int  )16;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&d_session_id;
 sqlstm.sqhstl[13] = (unsigned int  )18;
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



	//sprintf(l_mesg,"nd_operating_facility_id : %s    nd_fr_last_yrd_date : %s    nd_to_last_yrd_date : %s   nd_fr_mth_date : %s     nd_to_mth_date : %s    nd_fr_yrd_date : %s     nd_to_yrd_date : %s    nd_fr_cur_mth_date : %s     nd_to_cur_mth_date : %s    nd_report_type : %s    nd_fr_facility : %s    nd_to_facility : %s",nd_operating_facility_id.arr,nd_fr_last_yrd_date.arr,nd_to_last_yrd_date.arr,nd_fr_mth_date.arr,nd_to_mth_date.arr,nd_fr_yrd_date.arr,nd_to_yrd_date.arr,nd_fr_cur_mth_date.arr,nd_to_cur_mth_date.arr,nd_report_type.arr,nd_fr_facility.arr,nd_to_facility.arr);

 
	 nd_fr_last_yrd_date.arr[nd_fr_last_yrd_date.len]    = '\0';
	 nd_to_last_yrd_date.arr[nd_to_last_yrd_date.len]    = '\0';
	 nd_fr_yrd_date.arr[nd_fr_yrd_date.len]              = '\0';
	 nd_to_yrd_date.arr[nd_to_yrd_date.len]              = '\0';   
	 nd_fr_mth_date.arr[nd_fr_mth_date.len] 	         = '\0';
	 nd_to_mth_date.arr[nd_to_mth_date.len]  		     = '\0';   
	 nd_fr_cur_mth_date.arr[nd_fr_cur_mth_date.len]      = '\0';
	 nd_to_cur_mth_date.arr[nd_to_cur_mth_date.len]      = '\0';   
	 nd_report_type.arr[nd_report_type.len]		         = '\0';   
 
 
	if(OERROR || NO_DATA_FOUND)
		err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");
	
	strcpy(filename,WORKING_DIR);
    strcat(filename,"blrdlrev.lis");
    strcpy(g_facility_id, nd_operating_facility_id.arr);

    if((f1=fopen(filename,"w")) == NULL) 
	{
        disp_message(ERR_MESG,"Error in opening output file...\n");
        proc_exit();
    }

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
				    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
		     INTO   :comp_name,
				    :rep_date,
				    :oper_id
		     FROM   SY_ACC_ENTITY_lang_vw
			 WHERE  ACC_ENTITY_ID = :nd_operating_facility_id
			 AND		language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24\
:MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID\
=:b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )107;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&p_language_id;
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



    if(OERROR)
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] 	= '\0';
    rep_date.arr[rep_date.len] 		= '\0';
    oper_id.arr[oper_id.len] 		= '\0';

    page_no=1;
    line_no=1;

    fetch_legend_value();

    decl_curs();

    fprintf(f1,"%c&l1O",ESC);   /* To Print Landscape           */
	fprintf(f1,"%c&a7L",ESC); 	/* To Set the Left margin  		*/
    fprintf(f1,"%c(s14H",ESC); 	/* To set the font size			*/
    
    do_report();

    fclose(f1);

    del_parm();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )142;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    return;
    
}

del_parm()
{
    /* EXEC SQL DELETE SY_PROG_PARAM
	         WHERE  PGM_ID     = 'BLRDLREV' 
	         AND    PGM_DATE   = :d_pgm_date
	         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRDLREV' an\
d PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )157;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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
    /* EXEC SQL DECLARE REV_DTL_LIST_CUR 
	        CURSOR 
			   FOR
	        SELECT  NVL(A.ORG_NET_CHARGE_AMT,0),
	                A.BLNG_GRP_ID,
	                TO_CHAR(A.TRX_DATE,'YYYYMMDD'),
	                A.EPISODE_TYPE ,
					A.OPERATING_FACILITY_ID
	        FROM    BL_PATIENT_CHARGES_FOLIO A,
					BL_BLNG_PRT_GRP_HDR B
	        WHERE   A.OPERATING_FACILITY_ID 
			BETWEEN NVL(:nd_fr_facility,'!!')
			AND     NVL(:nd_to_facility,'~~')
			AND		A.TRX_DATE
	        BETWEEN TO_DATE(:nd_fr_last_yrd_date,'YYYYMMDD')
	        AND     TO_DATE(:nd_to_cur_mth_date,'YYYYMMDD')
			AND     NVL(A.TRX_FINALIZE_IND,'N') = 'Y'
			AND		NVL(A.CONFIRMED_YN,'N')		= 'Y'
			AND		A.PRT_GRP_HDR_CODE			= B.PRT_GRP_HDR_CODE
			AND		NVL(B.INCOME_YN,'N')		= 'Y'
	        ORDER   
			BY		A.OPERATING_FACILITY_ID,
					EPISODE_TYPE,
					BLNG_GRP_ID,
					TRUNC(TRX_DATE); */ 

   
   /* EXEC SQL OPEN REV_DTL_LIST_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )180;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fr_facility;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_facility;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fr_last_yrd_date;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_cur_mth_date;
   sqlstm.sqhstl[3] = (unsigned int  )11;
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
       err_mesg("OPEN failed on cursor REV_LIST_CUR",0,"");
}

do_report()
{
 int first = 1;
 put_hdr();

	while(fetch_dtl_trans_list()) 
	{

	  if (!nd_pre_facility_id.arr)
      {
	   		strcpy(nd_pre_facility_id.arr,d_operating_facility_id.arr);
      }
      
	  if (strcmp(nd_pre_facility_id.arr,d_operating_facility_id.arr)!=0) 
      {
			chk_break(2);
			strcpy(nd_pre_facility_id.arr,d_operating_facility_id.arr);
			
			l_comp_name.arr[0] = '\0';

			/* EXEC SQL SELECT ACC_ENTITY_NAME
					 INTO   :l_comp_name
					 FROM   SY_ACC_ENTITY_lang_vw
					 WHERE  ACC_ENTITY_ID = :nd_operating_facility_id
					 and language_id=:p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME into :b0  from SY_ACC_ENTITY_lang_\
vw where (ACC_ENTITY_ID=:b1 and language_id=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )211;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_comp_name;
   sqlstm.sqhstl[0] = (unsigned int  )52;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_language_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
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



			l_comp_name.arr[l_comp_name.len] = '\0';

			fprintf(f1,"%18s  :  %-40.40s\n\n" ,loc_legend[190],l_comp_name.arr);          
			line_no++;line_no++;
      }

      if (first ==1) 
	  {
		  d_prev_episode_type.arr[0]    = '\0';   
		  d_prev_episode_type.len       = 0;
          d_prev_blng_id.arr[0]         = '\0';   
          d_prev_blng_id.len            = 0;                 


          strcpy(d_prev_episode_type.arr,d_episode_type.arr);
          strcpy(d_prev_blng_id.arr,d_blng_grp_id.arr);

          d_prev_episode_type.len       = d_episode_type.len;
          d_prev_episode_type.arr[d_prev_episode_type.len]    = '\0';   
          d_prev_blng_id.len            = d_blng_grp_id.len;
          d_prev_blng_id.arr[d_prev_blng_id.len]              = '\0';   
          
          if (strcmp(d_episode_type.arr,"I") == 0)
             fprintf(f1,"%9s         ",loc_legend[170]);
          else if (strcmp(d_episode_type.arr,"D") == 0)		//31/10/2004
             fprintf(f1,"\n%7s           ",loc_legend[180]);
          else if(strcmp(d_episode_type.arr,"O") == 0)
             fprintf(f1,"\n%10s        ",loc_legend[140]);
          else if(strcmp(d_episode_type.arr,"E") == 0)
             fprintf(f1,"\n%9s         ",loc_legend[150]);
          else if(strcmp(d_episode_type.arr,"R") == 0)
             fprintf(f1,"\n%8s          ",loc_legend[160]);
       
	      if (strcmp(nd_report_type.arr,"D") == 0)
                fprintf(f1,"\n\n");
       }  
       else 
       {
           if (strcmp(d_prev_episode_type.arr,d_episode_type.arr) !=0 ) 
		   {
	          d_prev_episode_type.arr[0]    = '\0';   
    	      d_prev_episode_type.len       = 0;
              
              strcpy(d_prev_episode_type.arr,d_episode_type.arr);
              
              d_prev_episode_type.len      	= d_episode_type.len;
              d_prev_episode_type.arr[d_prev_episode_type.len]    = '\0';   
              
              print_rec();
              d_prev_blng_id.arr[0]         = '\0';   
  	          d_prev_blng_id.len            = 0;                 
              
              strcpy(d_prev_blng_id.arr,d_blng_grp_id.arr);
	          
	          d_prev_blng_id.len            = d_blng_grp_id.len;
    	      d_prev_blng_id.arr[d_prev_blng_id.len]              = '\0';   
    	      
              init_variables(); 
              print_epi_totals();
              first = 1;

              if(strcmp(d_episode_type.arr,"O") == 0)
                 fprintf(f1,"\n%10.10s        ",loc_legend[140]);
              else if (strcmp(d_episode_type.arr,"E") == 0)
                 fprintf(f1,"\n%9.9s         ",loc_legend[150]);
              else if(strcmp(d_episode_type.arr,"R") == 0)
                 fprintf(f1,"\n%8.8s          ",loc_legend[160]);
              else if(strcmp(d_episode_type.arr,"I") == 0)
                 fprintf(f1,"\n%9.9s         ",loc_legend[170]);
              else if(strcmp(d_episode_type.arr,"D") == 0)
                 fprintf(f1,"\n%7.7s           ",loc_legend[180]);


              

              if (strcmp(nd_report_type.arr,"D") == 0)
				 fprintf(f1,"\n\n");
           }
           else 
		   {
			 if(strcmp(d_prev_blng_id.arr,d_blng_grp_id.arr)!=0 )
			 {
				print_rec();
				init_variables(); 
				d_prev_blng_id.arr[0]         = '\0';   
        		d_prev_blng_id.len            = 0;                 
				strcpy(d_prev_blng_id.arr,d_blng_grp_id.arr);
				d_prev_blng_id.len            = d_blng_grp_id.len;
      			d_prev_blng_id.arr[d_prev_blng_id.len] = '\0';   
			 }  
           } 
       }
       first = 0;

      // Today 

      if (strcmp(d_trx_date.arr,nd_to_yrd_date.arr)==0)
         p_tot_today  =  p_tot_today + d_upd_net_charge_amt;
      

	  // Month 
	  if ((strcmp(d_trx_date.arr,nd_fr_cur_mth_date.arr)>=0)  &&
	      (strcmp(d_trx_date.arr,nd_to_cur_mth_date.arr)<=0))
  	 	  p_month  =  p_month + d_upd_net_charge_amt;        
  	 	  
  	 	  
	  // YTD 
	  if ((strcmp(d_trx_date.arr,nd_fr_yrd_date.arr)>=0)  &&
	      (strcmp(d_trx_date.arr,nd_to_yrd_date.arr)<=0))
 		  p_ytd  =  p_ytd + d_upd_net_charge_amt;        
	   
    
      // last MTD 
	  if ((strcmp(d_trx_date.arr,nd_fr_mth_date.arr)>=0)  &&
	      (strcmp(d_trx_date.arr,nd_to_mth_date.arr)<=0)) 
          p_last_mtd  =  p_last_mtd + d_upd_net_charge_amt;
                 
	   
	  // last YTD 
      if ((strcmp(d_trx_date.arr,nd_fr_last_yrd_date.arr)>=0) &&
	      (strcmp(d_trx_date.arr,nd_to_last_yrd_date.arr)<=0))
 		  p_last_ytd  =  p_last_ytd + d_upd_net_charge_amt;  

	} 
    
	//disp_message(ERR_MESG,"End of While Loop");
	
	strcpy(d_prev_blng_id.arr,d_blng_grp_id.arr);
	print_rec();             
	print_epi_totals();	

	chk_break(3);
    fprintf(f1,"-------------------------------------------------------------------------------------------------\n");
	print_grand_totals();
    fprintf(f1,"\n-------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n                               *** %15s ***\n",loc_legend[220]);
}

init_variables ()
{
 p_tot_today =0;
 p_month 	 =0;
 p_ytd 	 	 =0;  
 p_last_mtd  =0;
 p_last_ytd  =0;
}

print_rec()
{
  if (strcmp(nd_report_type.arr,"D") == 0)
  {
	  
	chk_break(2);
	fetch_prt_line_desc();
	fprintf(f1,"%-15.15s   ",d_prt_grp_desc.arr);
	print_line();
	
	 //for(line_no;line_no<=35;line_no++){ fprintf(f1,"\n");}
	fprintf(f1,"\n"); 
	
	 line_no++;

  }  
   
  compute_episode_total();
} 

compute_episode_total()
{
	 p_epi_tot_today  = p_epi_tot_today   + p_tot_today;
	 p_epi_month      = p_epi_month       + p_month;
	 p_epi_ytd        = p_epi_ytd         + p_ytd;
	 p_epi_last_mtd   = p_epi_last_mtd    + p_last_mtd;
	 p_epi_last_ytd   = p_epi_last_ytd    + p_last_ytd;

	//sprintf(l_mesg,"COMPUTE_EPISODE_TOTAL   %f",p_epi_ytd);
	 //disp_message(ERR_MESG,l_mesg);

} 

print_epi_totals()
{
	int i;

	chk_break(4);

	//sprintf(l_mesg,"PRINT_EPISODE_TOTAL   %f",p_epi_tot_today);
	//disp_message(ERR_MESG,l_mesg);

	 if (strcmp(nd_report_type.arr,"D") == 0)
	 {
	
		 for (i=0;i<REP_WIDTH+17;i++)
			fprintf(f1,"-"); 
		 fprintf(f1,"\n");

		fprintf(f1,"%9.9s:        ",loc_legend[210]);
	
	 }

	 print_formated(p_epi_tot_today);
	 print_formated(p_epi_month);
	 print_formated(p_epi_ytd);
	 print_formated(p_epi_last_mtd);
	 print_formated(p_epi_last_ytd); 
	 fprintf(f1,"\n");
	
	 compute_grand_tot();
	 init_epi_totals();
}

compute_grand_tot()
{
	 g_tot_today  = p_epi_tot_today + g_tot_today;
	 g_month      = p_epi_month     + g_month;
	 g_ytd        = p_epi_ytd       + g_ytd;
	 g_last_mtd   = p_epi_last_mtd  + g_last_mtd;
	 g_last_ytd   = p_epi_last_ytd  + g_last_ytd;
} 

init_epi_totals()
{
	 p_epi_tot_today =0;
	 p_epi_month 	 =0;
	 p_epi_ytd 		 =0;
	 p_epi_last_mtd  =0;
	 p_epi_last_ytd  =0;
}

print_grand_totals()
{
	 fprintf(f1,"%8.8s          ",loc_legend[200]);
	 print_formated(g_tot_today);
	 print_formated(g_month);
	 print_formated(g_ytd);
	 print_formated(g_last_mtd);
	 print_formated(g_last_ytd);
}

fetch_dtl_trans_list()
{
	/* EXEC SQL FETCH REV_DTL_LIST_CUR INTO
				   	 :d_upd_net_charge_amt,
					 :d_blng_grp_id,
					 :d_trx_date, 
					 :d_episode_type,
					 :d_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )238;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_upd_net_charge_amt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
 sqlstm.sqhstv[2] = (         void  *)&d_trx_date;
 sqlstm.sqhstl[2] = (unsigned int  )11;
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
 sqlstm.sqhstv[4] = (         void  *)&d_operating_facility_id;
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

 
 
	if(OERROR)
		err_mesg("FETCH failed on cursor TRANS_LIST_CUR",0,"");
    
	if(NO_DATA_FOUND)
		return 0;

	d_blng_grp_id.arr[d_blng_grp_id.len]   = '\0';
	d_trx_date.arr[d_trx_date.len]         = '\0';
	d_episode_type.arr[d_episode_type.len] = '\0';

	return 1;
}


chk_break(nol)
int nol;
{
  if(line_no+nol >= 35)   
  {
     fprintf(f1,"");
     line_no = 1;
     ++page_no;
     put_hdr();
  }  
}

fetch_prt_line_desc()
{
	  d_prt_grp_desc.arr[0]  = '\0';
	  /* EXEC SQL SELECT SHORT_DESC
			   INTO  :d_prt_grp_desc
			   FROM BL_BLNG_GRP_lang_vw
			   WHERE  BLNG_GRP_ID = :d_prev_blng_id
			   and language_id=:p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from BL_BLNG_GRP_lang_vw wher\
e (BLNG_GRP_ID=:b1 and language_id=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )273;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_desc;
   sqlstm.sqhstl[0] = (unsigned int  )42;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_prev_blng_id;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_language_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
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
		err_mesg("FETCH failed on cursor PRT_GRP_LINE_CUR",0,"");
	  d_prt_grp_desc.arr[d_prt_grp_desc.len]  = '\0';
}
/*fprintf(f1,"                       %8.8s %-16.16s%9.9s  %12.12s   %7.7s \n",  loc_legend[80],loc_legend[90],loc_legend[100],loc_legend[110],loc_legend[120]);
    fprintf(f1,"                                                                %8s    %8s \n", loc_legend[130],loc_legend[100]);*/

put_hdr()
{

    form_hdr();
//              01234567890123456789012345678901234567890123456789012345678901234567890123456789
    fprintf(f1,"-------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"                           %5.5s      %13.13s     %5.5s          %7.7s         %4.4s \n",  loc_legend[80],loc_legend[90],loc_legend[100],loc_legend[110],loc_legend[120]);
    fprintf(f1,"                                                                        %5.5s         %5.5s \n", loc_legend[130],loc_legend[100]);
	/*fprintf(f1,"%25.25s%6.6s   %13.13s    %6.6s      %7.7s       %5.5s \n"," ",loc_legend[80],loc_legend[90],loc_legend[100],loc_legend[110],loc_legend[120]);
    fprintf(f1,"                                                               %9.9s    %9.9s \n", loc_legend[130],loc_legend[100]);*/
    fprintf(f1,"-------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n");
    line_no=8;
  
}

/*print_formated(loc_amount)
double loc_amount;
{
	 char s_amt[100];
	 char ss[100];  			
	 if (loc_amount <0)
      {
	     	 sprintf(s_amt,"%f",loc_amount);
			 //put_val(s_amt,-loc_amount);
			 format_amt(s_amt);
			 strcpy(ss,"-"); 
             strcat(ss,s_amt); 
             //strcpy(s_amt,ss); 
             //	disp_message(ERR_MESG,s_amt);
			 fprintf(f1,"%14.14s",ss);
	   }
	   else
	   {
			 sprintf(s_amt,"%f",loc_amount);
			 //put_val(s_amt,loc_amount);
			 format_amt(s_amt);
			 fprintf(f1,"%14.14s",s_amt); 
		}
}*/

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30], fstr_amt[30];
    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        	       
        sprintf(str_amt,"%s",s_amt);				
		strcpy(fstr_amt,"-");
		strcat(fstr_amt,str_amt);		
		sprintf(str_amt,"%16s",fstr_amt);		
        fprintf(f1,"%16s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%16s",s_amt);
        fprintf(f1,"%16s",str_amt);
     }
} 


form_hdr()
{
    static int first = 1;
    char buf[5];
    int col;
	  if(first) 
	{
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
 
        strcpy(hdr_line1,loc_legend[230]);
		strcat(hdr_line1," : ");
	    strcat(hdr_line1,loc_legend[70]);
        col = (int)(REP_WIDTH-strlen(comp_name.arr))/2;

        strncpy(hdr_line1+col,comp_name.arr,strlen(comp_name.arr));
        //col = (REP_WIDTH-strlen(rep_date.arr));
        //strcpy(hdr_line1+col,rep_date.arr);
    
        strcpy(hdr_line2,loc_legend[240]);
		strcat(hdr_line2," : ");
        strcat(hdr_line2,oper_id.arr);
//  moved from down to inside the if clause  by Ravikiran S
	l_rep_date.arr[0] = '\0';

	/* EXEC SQL SELECT TO_CHAR(TO_DATE(:nd_to_mth_date,'YYYYMMDD'),'DD/MM/YYYY')
	           INTO :l_rep_date
			   FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(TO_DATE(:b0,'YYYYMMDD'),'DD/MM/YYYY') into :\
b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )300;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_to_mth_date;
 sqlstm.sqhstl[0] = (unsigned int  )11;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_rep_date;
 sqlstm.sqhstl[1] = (unsigned int  )27;
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


     	l_rep_date.arr[l_rep_date.len] = '\0';
		init_date_temp_var();
        strcpy(date_convert.arr,rep_date.arr);
        fun_change_loc_date();
		        //fprintf(f1,"%s                      %30         %12.12s :%11.11s\n",hdr_line1,hdr_line1+col,loc_legend[10],date_convert.arr);
		fprintf(f1,"%s                      %30s         %12.12s :%11.11s\n",hdr_line1,hdr_line1+col,loc_legend[10],date_convert.arr);
 
	//	first = 0;
    }

/*	l_rep_date.arr[0] = '\0';

	EXEC SQL SELECT TO_CHAR(TO_DATE(:nd_to_mth_date,'YYYYMMDD'),'DD/MM/YYYY')
	           INTO :l_rep_date
			   FROM dual;
	l_rep_date.arr[l_rep_date.len] = '\0';
*/
   memset(hdr_line3,' ',REP_WIDTH+1);

	//strcat(rep_title1,l_rep_date.arr);


    if (strcmp(nd_report_type.arr,"D") == 0)
	{
		strcpy(rep_title1,loc_legend[260]);
        strcat(rep_title1,loc_legend[60]);
	}
    else
    {
	    strcat(rep_title1,loc_legend[260]);
        strcat(rep_title1,loc_legend[50]);
	} 
    strncpy(hdr_line3,"REP : ",6);
	strncpy(hdr_line3+6,loc_legend[40],strlen(loc_legend[40]));/* Modified by Pradeep 28-09-2006*/
    col = (int)(REP_WIDTH+10-strlen(rep_title1))/2;
	strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
	//sprintf(buf,"%-5s %4d",loc_legend[30],page_no);
    //strcpy(hdr_line3+(REP_WIDTH-5),buf);
/*		init_date_temp_var();
        strcpy(date_convert.arr,rep_date.arr);
        fun_change_loc_date(); 
    fprintf(f1,"%s                         %-25.25s                          %12.12s\n",hdr_line1,hdr_line1+col,date_convert.arr);
   */

    fprintf(f1,"%-14s \n",hdr_line2);
		init_date_temp_var();
        strcpy(date_convert.arr,l_rep_date.arr);
        fun_change_loc_date();
    fprintf(f1,"%-3.3s : %-8.8s             %30.30s %12.12s              %5.5s %4d\n",loc_legend[250],loc_legend[40],hdr_line3+col+6,date_convert.arr,loc_legend[30],page_no); 
}


print_line()
{
	 print_formated(p_tot_today);
	 print_formated(p_month);
	 print_formated(p_ytd);
	 print_formated(p_last_mtd);
	 print_formated(p_last_ytd);
	
	 
}

filbuf(buf, fil_char, size)
char	*buf;
char	fil_char;
int	size;
{
  int ix;

  for (ix = 0; ix < size; ix++)
    buf[ix] = fil_char;
}


/*
fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		EXEC SQL SELECT LTRIM(RTRIM('BLRDLREV.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual;

		l_pk_value.arr[l_pk_value.len]	= '\0';
		l_translated_value.arr[0]		= '\0';

		EXEC SQL EXECUTE
		BEGIN
			blcommon.get_local_lang_desc(:nd_facility_id,
										'SM',
										'SM_LANG_LEGEND',
										'DFLT_LEGEND_VALUE',
										:l_pk_value,
										:l_translated_value,
										:p_language_id);
		END;
		END-EXEC;

		l_translated_value.arr[l_translated_value.len] = '\0';
		strcpy(loc_legend[i],l_translated_value.arr);
	}
}
*/


fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';
		l_len_value.arr[0] = '\0';


		/* EXEC SQL SELECT LTRIM(RTRIM('BLRDLREV.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRDLREV.LEGEND_'||LTRIM(RTRIM(TO_CHA\
R(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )323;
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



		/* EXEC SQL SELECT length(column_value) INTO :l_len_value 
		           FROM sm_record_trans_data 
				   WHERE language_id ='en' AND Pk_value = :l_pk_value; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select length(column_value) into :b0  from sm_record_trans\
_data where (language_id='en' and Pk_value=:b1)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )346;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_len_value;
  sqlstm.sqhstl[0] = (unsigned int  )11;
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
		l_len_value.arr[l_len_value.len]= '\0';
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
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , '\
SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_va\
lue , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )369;
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



		/* EXEC SQL SELECT substr(:l_translated_value,1,(:l_len_value+4))  
		          INTO :l_translated_value
		          FROM DUAL; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 14;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select substr(:b0,1,(:b1+4)) into :b0  from DUAL ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )400;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
  sqlstm.sqhstl[0] = (unsigned int  )203;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_len_value;
  sqlstm.sqhstl[1] = (unsigned int  )11;
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
	get_p_language_id();
 	

	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	//	get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);

	//	:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

		   :nd_loc_date := sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id);  


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date\
_2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; E\
ND ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )427;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_language_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
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


get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 
}

	


get_p_language_id()
{
	p_language_id.arr[0] = '\0';
	user_id.arr[0]     = '\0';
	
	p_language_id.len = 0;
	user_id.len     = 0;
	
	/* EXEC SQL SELECT  USER INTO :user_id  FROM SY_ACC_ENTITY WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select USER into :b0  from SY_ACC_ENTITY where ACC_ENTITY_I\
D=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )454;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&user_id;
 sqlstm.sqhstl[0] = (unsigned int  )12;
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
		err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

	/* EXEC SQL SELECT LANGUAGE_ID INTO :p_language_id FROM SM_APPL_USER where APPL_USER_ID = :user_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 14;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LANGUAGE_ID into :b0  from SM_APPL_USER where APPL_U\
SER_ID=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )477;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_language_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&user_id;
 sqlstm.sqhstl[1] = (unsigned int  )12;
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
        err_mesg("SELECTING LANGUAGE_ID failed",0,"");
}

//	strcat(rep_title,l_rep_date.arr);

    /*if (strcmp(nd_report_type.arr,"D") == 0)
	{
		strcat(rep_title," -");
        strcat(rep_title,loc_legend[60]);
	}
    else
    {
	    strcat(rep_title," -");
        strcat(rep_title,loc_legend[50]);
	}

    strncpy(hdr_line3,"REP : ",6);
	strncpy(hdr_line3+6,loc_legend[40],strlen(loc_legend[40]));// Modified by Pradeep 28-09-2006
    col = (int)(REP_WIDTH+10-strlen(rep_title))/2;
	strncpy(hdr_line3+col,rep_title,strlen(rep_title));
	sprintf(buf,"%4d",page_no);
    strcpy(hdr_line3+(REP_WIDTH-5),buf);*/
