
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
           char  filnam[29];
};
static const struct sqlcxp sqlfpn =
{
    28,
    "C:\\temp\\CRF-0463\\Blrtrsum.pc"
};


static unsigned long sqlctx = 1439503411;


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
            void  *sqhstv[12];
   unsigned int   sqhstl[12];
            int   sqhsts[12];
            void  *sqindv[12];
            int   sqinds[12];
   unsigned int   sqharm[12];
   unsigned int   *sqharc[12];
   unsigned short  sqadto[12];
   unsigned short  sqtdso[12];
} sqlstm = {10,12};

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
"select a.EPISODE_TYPE ,b.PRT_GRP_HDR_CODE ,b.PRT_GRP_LINE_CODE ,count(*)  ,s\
um(NVL(a.UPD_NET_CHARGE_AMT,0)) ,sum(NVL(a.UPD_GROSS_CHARGE_AMT,0)) ,sum(NVL(a\
.UPD_DISC_AMT,0))  from BL_PATIENT_CHARGES_FOLIO a ,BL_BLNG_SERV b ,BL_BLNG_PR\
T_GRP_HDR c where ((((((((A.BLNG_SERV_CODE between nvl(:b0,' ') and nvl(:b1,'~\
~~~~~~~~~') and A.BLNG_GRP_ID between nvl(:b2,' ') and nvl(:b3,'~~')) and A.BL\
NG_SERV_CODE=B.BLNG_SERV_CODE) and B.PRT_GRP_HDR_CODE=C.PRT_GRP_HDR_CODE) and \
TRUNC(A.TRX_DATE) between nvl(TO_DATE(:b4,'DD/MM/YYYY'),to_date('01/01/1000','\
dd/mm/yyyy')) and NVL(TO_DATE(:b5,'DD/MM/YYYY'),to_date('01/12/4000','dd/mm/yy\
yy'))) and NVL(OPERATING_FACILITY_ID,'X')=NVL(:b6,'X')) and ((NVL(PACKAGE_IND,\
'X')='S' or (NVL(PACKAGE_TRX_IND,'X')='Y' and NVL(PACKAGE_IND,'X')='P')) or AV\
AILED_IND in ('U','Y','C'))) and A.TRX_FINALIZE_IND='Y') and NVL(C.INCOME_YN,'\
Y')='Y') group by a.EPISODE_TYPE,b.PRT_GRP_HDR_CODE,b.PRT_GRP_LINE_CODE order \
by a.EPISODE_TYPE,b.PRT_GRP_HDR_CODE,b.PRT_GRP_LINE_CODE            ";

 static const char *sq0007 = 
"select LONG_DESC  from BL_BLNG_PRT_GRP_LINE_lang_vw where ((PRT_GRP_HDR_CODE\
=:b0 and PRT_GRP_LINE_CODE=:b1) and language_id=:b2)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,119,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,242,0,4,160,0,0,12,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
99,0,0,3,158,0,4,209,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
134,0,0,4,0,0,30,240,0,0,0,0,0,1,0,
149,0,0,5,91,0,2,248,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
172,0,0,6,1002,0,9,324,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
215,0,0,6,0,0,13,496,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,4,0,0,2,4,
0,0,2,4,0,0,
258,0,0,7,139,0,9,526,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
285,0,0,7,0,0,13,531,0,0,1,0,0,1,0,2,9,0,0,
304,0,0,8,96,0,4,813,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
327,0,0,9,165,0,6,820,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
358,0,0,10,140,0,6,841,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
385,0,0,11,147,0,6,903,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/*****************************************************************************/
/*Program     :	BLRTRSUM.PC                                                  */
/*Description : Summary of Billing Transactions                              */
/*Author      : PVSS Prasad / 26-May-1997                                    */
/*Modified by : V.Srikanth / 11/04/1999                                      */
/*****************************************************************************/
  
/*
#define DEBUG       
*/                                    

#define REP_WIDTH 120
#define INIT_MESG "Report generation in Progress..."

#include <stdio.h> 
#include <string.h>
#include "gl.h"  
#include "bl.h"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd[91],
		    d_session_id[16],
		    d_pgm_date[35],
            rep_date[35],
            comp_name[50],
            oper_id[21],
			nd_temp_date[35],
			nd_temp_date1[35],
			p_language_id[3],
			date_convert[35],
			date_convert1[35],
			nd_loc_date[35],
			nd_loc_date1[35],
			nd_facility_id[3],
		    d_pgm_id[10]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[35]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[35]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[35]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[35]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[35]; } date_convert;

struct { unsigned short len; unsigned char arr[35]; } date_convert1;

struct { unsigned short len; unsigned char arr[35]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[35]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[10]; } d_pgm_id;


    /* VARCHAR nd_fm_trans_date           [35],
            nd_to_trans_date           [35],
			nd_fm_t_dt                 [35],
            nd_to_t_dt                 [35],
			nd_fm_blng_grp			   [10],
			nd_to_blng_grp			   [10],
			nd_fm_blng_serv			   [20],
			nd_to_blng_serv			   [20],
            nd_fm_episode_id           [9],
            nd_to_episode_id           [9],
			d_facility_id			   [3]; */ 
struct { unsigned short len; unsigned char arr[35]; } nd_fm_trans_date;

struct { unsigned short len; unsigned char arr[35]; } nd_to_trans_date;

struct { unsigned short len; unsigned char arr[35]; } nd_fm_t_dt;

struct { unsigned short len; unsigned char arr[35]; } nd_to_t_dt;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_blng_grp;

struct { unsigned short len; unsigned char arr[10]; } nd_to_blng_grp;

struct { unsigned short len; unsigned char arr[20]; } nd_fm_blng_serv;

struct { unsigned short len; unsigned char arr[20]; } nd_to_blng_serv;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_episode_id;

struct { unsigned short len; unsigned char arr[9]; } nd_to_episode_id;

struct { unsigned short len; unsigned char arr[3]; } d_facility_id;

            
    
    char    nd_print_opt, nd_report_opt;

    /* VARCHAR d_episode_type             [2],
            d_prt_grp_hdr_code         [6],
			l_pk_value		           [100],
		    l_translated_value	       [201],
            d_prt_grp_line_code        [4]; */ 
struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[6]; } d_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[4]; } d_prt_grp_line_code;


    /* VARCHAR d_prev_episode_type        [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } d_prev_episode_type;


    /* VARCHAR d_prt_grp_line_desc        [41]; */ 
struct { unsigned short len; unsigned char arr[41]; } d_prt_grp_line_desc;


   double   d_upd_net_charge_amt,
            d_upd_gross_charge_amt,
            d_upd_disc_amt;

   long     d_no_of_trans;

	char     string_var[200];
int i;

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

int page_no,
    line_no,
    first_line,
    g_count;

char filename[150];
	char loc_legend[999][201];
	
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1];

char rep_title[] = "SUMMARY OF BILLING TRANSACTIONS WITH DISCOUNTS";

double g_epi_net_amt,
       g_epi_gross_amt,
       g_epi_disc_amt,
       g_tot_net_amt,
       g_tot_gross_amt,
       g_tot_disc_amt;

long   g_epi_no_of_trans,
       g_tot_no_of_trans;

void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc < 5) {
        disp_message(ERR_MESG,"Usage BLRTRSUM userid/password session_id pgm_date facility_id \n");
        proc_exit();
    }


    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);
    
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

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

    nd_fm_trans_date.arr[0]		=	'\0';
    nd_to_trans_date.arr[0]		=	'\0';
    nd_fm_t_dt.arr[0]			=	'\0';
    nd_to_t_dt.arr[0]			=	'\0';
    nd_fm_blng_grp.arr[0]		=	'\0';
	nd_to_blng_grp.arr[0]		=	'\0';
	nd_fm_blng_serv.arr[0]		=	'\0';
	nd_to_blng_serv.arr[0]		=	'\0';
	
    nd_fm_trans_date.len    =	0;
    nd_to_trans_date.len    =	0;
    nd_fm_t_dt.len			=	0;
    nd_to_t_dt.len			=	0;
	nd_fm_blng_grp.len		=	0;
	nd_to_blng_grp.len		=	0;
	nd_fm_blng_serv.len		=	0;
	nd_to_blng_serv.len		=	0;
	

/*-- Billing Service and Billing Group range captured by VSK on 11/04/1999
     as per the requirement of SCF-084 from AH */

	/* EXEC SQL SELECT PARAM1,
					PARAM2,
					PARAM3,
					PARAM4,
					PARAM5,
					PARAM6,
					PARAM7,
					PARAM8,
					PARAM9,
					operating_facility_id
			 INTO   :nd_fm_trans_date,
	                :nd_to_trans_date,
					:nd_fm_t_dt,
					:nd_to_t_dt,
					:nd_fm_blng_grp,
					:nd_to_blng_grp,
					:nd_fm_blng_serv,
					:nd_to_blng_serv,
					:nd_report_opt,
					:d_facility_id
			 FROM   SY_PROG_PARAM
			 WHERE  PGM_ID     = 'BLRTRSUM'  
			 AND    PGM_DATE   = :d_pgm_date
			 AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PARAM\
7 ,PARAM8 ,PARAM9 ,operating_facility_id into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,\
:b8,:b9  from SY_PROG_PARAM where ((PGM_ID='BLRTRSUM' and PGM_DATE=:b10) and S\
ESSION_ID=TO_NUMBER(:b11))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_fm_trans_date;
 sqlstm.sqhstl[0] = (unsigned int  )37;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_to_trans_date;
 sqlstm.sqhstl[1] = (unsigned int  )37;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_fm_t_dt;
 sqlstm.sqhstl[2] = (unsigned int  )37;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_to_t_dt;
 sqlstm.sqhstl[3] = (unsigned int  )37;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_fm_blng_grp;
 sqlstm.sqhstl[4] = (unsigned int  )12;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_to_blng_grp;
 sqlstm.sqhstl[5] = (unsigned int  )12;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_fm_blng_serv;
 sqlstm.sqhstl[6] = (unsigned int  )22;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_to_blng_serv;
 sqlstm.sqhstl[7] = (unsigned int  )22;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_report_opt;
 sqlstm.sqhstl[8] = (unsigned int  )1;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[9] = (unsigned int  )5;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[10] = (unsigned int  )37;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_session_id;
 sqlstm.sqhstl[11] = (unsigned int  )18;
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



    if(OERROR || NO_DATA_FOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM",0,"");

    nd_fm_trans_date.arr[nd_fm_trans_date.len]  =	'\0';
    nd_to_trans_date.arr[nd_to_trans_date.len]  =	'\0';  
	nd_fm_t_dt.arr[nd_fm_t_dt.len]				=	'\0';
    nd_to_t_dt.arr[nd_to_t_dt.len]				=	'\0';
	nd_fm_blng_grp.arr[nd_fm_blng_grp.len]		=	'\0';
	nd_to_blng_grp.arr[nd_to_blng_grp.len]		=	'\0';
	nd_fm_blng_serv.arr[nd_fm_blng_serv.len]	=	'\0';
	nd_to_blng_serv.arr[nd_to_blng_serv.len]	=	'\0';
	d_facility_id.arr[d_facility_id.len]		=	'\0';
	strcpy(g_facility_id, d_facility_id.arr);



    strcpy(filename,WORKING_DIR);
    strcat(filename,"blrtrsum.lis");

    if( (f1=fopen(filename,"w")) == NULL) {
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
			WHERE   acc_entity_id = :d_facility_id
			AND		language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (acc_entity_id=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )99;
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
    sqlstm.sqhstl[1] = (unsigned int  )37;
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

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';

    page_no=1; 
    line_no=1;
 fetch_legend_value();
    decl_curs();

    if (nd_report_opt == 'O')
		put_inp_parm();

    do_report();

    fclose(f1);

    del_parm();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )134;
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
	         WHERE  PGM_ID     = 'BLRTRSUM' 
	         AND    PGM_DATE   = :d_pgm_date
	         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRTRSUM' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )149;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
    sqlstm.sqhstl[0] = (unsigned int  )37;
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
 char chk_1[400];

/*-- Billing Service and Billing Group range added by VSK on 09/04/1999
     as per the requirement of SCF-084 from AH */

   sprintf(chk_1,"[%s]-blng_servfm[%s]to [%s]fm_grp[%s]to_grp[%s]-fmdate[%s]-todate",
            nd_fm_blng_serv.arr,nd_to_blng_serv.arr,nd_fm_blng_grp.arr,
	        nd_to_blng_grp.arr,nd_fm_trans_date.arr, nd_to_trans_date.arr);
//	disp_message(ERR_MESG,chk_1);
  	 
    /* EXEC SQL DECLARE TRANS_LIST_CUR CURSOR FOR
	     SELECT  a.EPISODE_TYPE, 
			     b.PRT_GRP_HDR_CODE,
			     b.PRT_GRP_LINE_CODE, 
			     COUNT(*),
			     SUM(NVL(a.UPD_NET_CHARGE_AMT,0)),
			     SUM(NVL(a.UPD_GROSS_CHARGE_AMT,0)),
			     SUM(NVL(a.UPD_DISC_AMT,0))
	      FROM   BL_PATIENT_CHARGES_FOLIO a, BL_BLNG_SERV b , 
	             BL_BLNG_PRT_GRP_HDR c 
          WHERE  A.BLNG_SERV_CODE BETWEEN nvl(:nd_fm_blng_serv,' ') 
		               AND nvl(:nd_to_blng_serv,'~~~~~~~~~~')
		    AND  A.BLNG_GRP_ID BETWEEN nvl(:nd_fm_blng_grp,' ') AND 
			                       nvl(:nd_to_blng_grp,'~~')
		    AND  A.BLNG_SERV_CODE = B.BLNG_SERV_CODE    AND    
				 B.PRT_GRP_HDR_CODE = C.PRT_GRP_HDR_CODE    AND    
				 TRUNC(A.TRX_DATE) BETWEEN 
				 nvl(TO_DATE(:nd_fm_trans_date,'DD/MM/YYYY'),
				     to_date('01/01/1000','dd/mm/yyyy'))
				  	AND 
				 NVL(TO_DATE(:nd_to_trans_date,'DD/MM/YYYY'),
				     to_date('01/12/4000','dd/mm/yyyy'))
		    AND     
				 NVL(OPERATING_FACILITY_ID,'X') = NVL(:d_facility_id,'X')	
			AND   ( NVL(PACKAGE_IND,'X')      = 'S' 
					 OR   
	               ( NVL(PACKAGE_TRX_IND,'X')  = 'Y' AND 
	                 NVL(PACKAGE_IND,'X')      = 'P')  
				   OR 
				   (AVAILED_IND IN('U','Y','C') )
				 ) 
			AND  A.TRX_FINALIZE_IND = 'Y'            
			AND  NVL(C.INCOME_YN,'Y') = 'Y'
            GROUP BY a.EPISODE_TYPE,b.PRT_GRP_HDR_CODE,b.PRT_GRP_LINE_CODE
			ORDER BY a.EPISODE_TYPE,b.PRT_GRP_HDR_CODE,b.PRT_GRP_LINE_CODE; */ 


				 
	      /* Changed after discussion with eric 29/11/94 - print services
		 only (exclude packages and its components)
	      AND    ( NVL(PACKAGE_IND,'X')      = 'S' OR
	               ( NVL(PACKAGE_TRX_IND,'X')  = 'Y' AND 
	                 NVL(PACKAGE_IND,'X')      = 'P'
		       )
		     )
	      */


    /* EXEC SQL DECLARE PRT_GRP_LINE_CUR CURSOR FOR
		     SELECT  LONG_DESC 
		     FROM    BL_BLNG_PRT_GRP_LINE_lang_vw
		     WHERE   PRT_GRP_HDR_CODE  = :d_prt_grp_hdr_code
		     AND     PRT_GRP_LINE_CODE = :d_prt_grp_line_code
			 AND		language_id=:p_language_id; */ 


   /* EXEC SQL OPEN TRANS_LIST_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )172;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fm_blng_serv;
   sqlstm.sqhstl[0] = (unsigned int  )22;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_blng_serv;
   sqlstm.sqhstl[1] = (unsigned int  )22;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_blng_grp;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_grp;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_trans_date;
   sqlstm.sqhstl[4] = (unsigned int  )37;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_trans_date;
   sqlstm.sqhstl[5] = (unsigned int  )37;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[6] = (unsigned int  )5;
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
	err_mesg("OPEN failed on cursor TRANS_LIST_CUR",0,"");
}


do_report()
{

    int cnt,hdr_cnt,first;

    int episode_change;


    hdr_cnt=0;
    line_no = 1;
    g_count = 1;
    put_hdr();

    init_prev_values();
    init_epi_totals();
    init_grand_totals();


    first = 1;

    while(fetch_trans_list()) {
	episode_change = 0;

	if(episode_brk()) {
	    if(!first) {
		print_epi_totals();
	    }

	    chk_break(1);
        if(d_episode_type.arr[0]=='I')
		{
          fprintf(f1,"%18.18s        : %s\n\n",loc_legend[220],"Inpatient");
		  }
        else if(d_episode_type.arr[0]=='O')
		{
          fprintf(f1,"%18.18s        : %s\n\n",loc_legend[220],"Outpatient");
		  }
        else if(d_episode_type.arr[0]=='E')
		{
          fprintf(f1,"%18.18s        : %s\n\n",loc_legend[220],"Emergency");
		  }
		 else if(d_episode_type.arr[0]=='D')
		{
          fprintf(f1,"%18.18s        : %s\n\n",loc_legend[220],"Daycare");
		  }
		else
		{
          fprintf(f1,"%18.18s        : %s\n\n",loc_legend[220],"Referral");
		  }

	    //fprintf(f1,"%18.18s        : %s\n\n",loc_legend[220],d_episode_type.arr);

	    line_no +=2;

	    /*
	    fprintf(f1,"%8.8s %-14.14s    : %2s/%2s  %-40s\n\n",loc_legend[130],loc_legend[140],
			d_prt_grp_hdr_code.arr, d_prt_grp_line_code.arr,
			d_prt_grp_line_desc.arr);

	    line_no += 2;
	    */
	    episode_change = 1;

	} /* end of episode break */

	first = 0;
	hdr_cnt = 1;
	print_rec();
       g_epi_net_amt    += d_upd_net_charge_amt;
       g_epi_gross_amt  += d_upd_gross_charge_amt;
       g_epi_disc_amt   += d_upd_disc_amt;

       g_tot_net_amt    += d_upd_net_charge_amt;
       g_tot_gross_amt  += d_upd_gross_charge_amt;
       g_tot_disc_amt   += d_upd_disc_amt;

       g_epi_no_of_trans += d_no_of_trans;
       g_tot_no_of_trans += d_no_of_trans;

       copy_val();

    } /* end of while fetch trans list */

    if(hdr_cnt) {
	print_epi_totals();
	print_grand_totals();

    }

    print_end_of_rep();

}

print_rec()
{

    char s_net_amt[1200], s_gross_amt[1200], s_disc_amt[1200];
    print_formated(s_net_amt,   d_upd_net_charge_amt);
    print_formated(s_gross_amt, d_upd_gross_charge_amt);
    print_formated(s_disc_amt,  d_upd_disc_amt);
    chk_break(1);
    fprintf(f1,"    %-5s / %-3s       %-40.40s      %4ld    %15s %15s %15s\n",
		d_prt_grp_hdr_code.arr, d_prt_grp_line_code.arr,
		d_prt_grp_line_desc.arr,d_no_of_trans,s_gross_amt,
		s_disc_amt, s_net_amt);

    line_no ++;

/*
               "    XX / XX       XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX     9999       999,999,990.99"
*/

}    

print_epi_totals()
{
    char  s_net_amt[1200], s_gross_amt[1200], s_disc_amt[1200];

    print_formated(s_net_amt,   g_epi_net_amt);
    print_formated(s_gross_amt, g_epi_gross_amt);
    print_formated(s_disc_amt,  g_epi_disc_amt);

    chk_break(3);
    fprintf(f1,"                                                           ----------------------------------------------------------------\n");
    fprintf(f1,"           %-17.17s                       :               %5.5ld    %15.15s %15.15s %15.15s\n",loc_legend[200], g_epi_no_of_trans,s_gross_amt,s_disc_amt,s_net_amt);
    fprintf(f1,"                                                           ================================================================\n\n\n");

    line_no += 6;
    init_epi_totals();
}

print_grand_totals()
{
    char s_net_amt[1200], s_gross_amt[1200], s_disc_amt[1200];

    print_formated(s_net_amt,   g_tot_net_amt);
    print_formated(s_gross_amt, g_tot_gross_amt);
    print_formated(s_disc_amt,  g_tot_disc_amt);

    chk_break(3);
    fprintf(f1,"                                                           ----------------------------------------------------------------\n");
    fprintf(f1,"          %-16.16s                        :                %5.5ld    %15.15s %15.15s %15.15s\n",loc_legend[190], g_tot_no_of_trans,s_gross_amt,s_disc_amt,s_net_amt);
    fprintf(f1,"                                                           ================================================================\n");

    line_no += 4;
}

fetch_trans_list()
{

    d_episode_type.arr[0]  = '\0';
    d_prt_grp_hdr_code.arr[0]  = '\0';  
    d_prt_grp_line_code.arr[0]  = '\0';

    d_episode_type.len     = 0;
    d_prt_grp_hdr_code.len     = 0;
    d_prt_grp_line_code.len     = 0;


    d_upd_net_charge_amt      = 0;
    d_upd_gross_charge_amt    = 0;
    d_upd_disc_amt            = 0;
    d_no_of_trans             = 0;


    /* EXEC SQL FETCH TRANS_LIST_CUR INTO
                   :d_episode_type,
                   :d_prt_grp_hdr_code,
                   :d_prt_grp_line_code,
				   :d_no_of_trans,
				   :d_upd_net_charge_amt,
                   :d_upd_gross_charge_amt,
                   :d_upd_disc_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )215;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prt_grp_hdr_code;
    sqlstm.sqhstl[1] = (unsigned int  )8;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_prt_grp_line_code;
    sqlstm.sqhstl[2] = (unsigned int  )6;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_no_of_trans;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_upd_net_charge_amt;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_upd_gross_charge_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_upd_disc_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
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
	err_mesg("FETCH failed on cursor TRANS_LIST_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_episode_type.arr[d_episode_type.len]  = '\0';
    d_prt_grp_hdr_code.arr[d_prt_grp_hdr_code.len]  = '\0';
    d_prt_grp_line_code.arr[d_prt_grp_line_code.len]  = '\0';

    fetch_prt_line_desc();

    return 1;
}

fetch_prt_line_desc()
{

    d_prt_grp_line_desc.arr[0]  = '\0';
    d_prt_grp_line_desc.len     = 0;

    /* EXEC SQL OPEN PRT_GRP_LINE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )258;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_hdr_code;
    sqlstm.sqhstl[0] = (unsigned int  )8;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prt_grp_line_code;
    sqlstm.sqhstl[1] = (unsigned int  )6;
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
	err_mesg("OPEN failed on cursor PRT_GRP_LINE_CUR",0,"");

    /* EXEC SQL FETCH PRT_GRP_LINE_CUR
	     INTO  :d_prt_grp_line_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )285;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_line_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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
	err_mesg("FETCH failed on cursor PRT_GRP_LINE_CUR",0,"");

    d_prt_grp_line_desc.arr[d_prt_grp_line_desc.len]  = '\0';

}


put_hdr()
{

    form_hdr();

  //fprintf(f1,"PRINT GROUP/LINE  PRINT LINE DESCRIPTION                    NO. OF TRANS       GROSS AMT       DISC AMT        NET AMT\n");

    fprintf(f1,"---------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"%-6.6s%11.11s %-6.6s %-26.26s   %17.17s  %17.17s %15.15s %15.15s\n",loc_legend[130],loc_legend[140],loc_legend[130],loc_legend[160],loc_legend[170],loc_legend[90],loc_legend[120],loc_legend[180]);
    fprintf(f1,"---------------------------------------------------------------------------------------------------------------------------\n");

/*
               "    XX / XX       XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX     9999       999,999,990.99 999,999,990.99 999,999,990.99"
*/


    fprintf(f1,"\n\n");    
    
    line_no=8;

}

chk_break(nol)
int nol;
{

	if(line_no+nol >= 55) {
           fprintf(f1,"");
           line_no = 1;
	   g_count = 1;
           ++page_no;
	   put_hdr();
	}

}

put_inp_parm()
{
    form_hdr();


/*if (nd_fm_t_dt.arr[0] == '\0')
		strcpy(nd_fm_t_dt.arr,loc_legend[240]);
	
	if (nd_to_t_dt.arr[0]=='\0')
	    strcpy(nd_to_t_dt.arr,loc_legend[230]);*/

    fprintf(f1,"----------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"%6.6s : 2.10.01\n",loc_legend[320]);
    fprintf(f1,"\n\n\n\n");
    fprintf(f1,"\t%22.22s\n",loc_legend[270]);
    fprintf(f1,"\t      --------------------\n\n");  


	if (nd_fm_t_dt.arr[0] != '\0')
		{
	 	  init_date_temp_var();
          strcpy(date_convert.arr,nd_fm_t_dt.arr);
		  fun_change_loc_date();
		fprintf(f1,"\t\t%-20.20s %-10.10s : %s\n",loc_legend[80],loc_legend[60],date_convert.arr);
		}
	else
		  
		fprintf(f1,"\t\t%-20.20s %-10.10s : %-10s\n",loc_legend[80],loc_legend[60],loc_legend[240]);

	if (nd_to_t_dt.arr[0]!='\0')
	{
		  init_date_temp_var();
          strcpy(date_convert.arr,nd_to_t_dt.arr);
		  fun_change_loc_date();

		fprintf(f1,"\t\t                     %-8.8s   : %s\n\n",loc_legend[70],date_convert.arr);
		}		
	else

	    fprintf(f1,"\t\t                     %-8.8s   : %-12s\n\n",loc_legend[70],loc_legend[230]);

    /*fprintf(f1,"\t\tTRANSACTION DATE FROM : %s\n",nd_fm_t_dt.arr);
    fprintf(f1,"\t\t                 TO   : %s\n\n",nd_to_t_dt.arr);
	*/
	

	if(strcmp(nd_fm_blng_grp.arr, "!!") == 0)
		
		fprintf(f1,"\t\t%-20.20s %-10.10s : %-10s\n",loc_legend[100],loc_legend[60],loc_legend[240]);
	else
		fprintf(f1,"\t\t%-20.20s %-10.10s : %s\n",loc_legend[100],loc_legend[60],nd_fm_blng_grp.arr);
		

	if(strcmp(nd_to_blng_grp.arr, "~~") == 0)
		
		fprintf(f1,"\t\t%-20.20s %-10.10s : %-10s\n\n",loc_legend[100],loc_legend[70],loc_legend[230]);
	else
		fprintf(f1,"\t\t%-20.20s %-10.10s : %s\n\n",loc_legend[100],loc_legend[70],nd_to_blng_grp.arr);
	
	if(strcmp(nd_fm_blng_serv.arr, "!!!") == 0)
		
		fprintf(f1,"\t\t%-20.20s %-10.10s : %-10s\n",loc_legend[110],loc_legend[60],loc_legend[240]);
	else
		fprintf(f1,"\t\t%-20.20s %-10.10s : %s\n",loc_legend[110],loc_legend[60],nd_fm_blng_serv.arr);

	if(strcmp(nd_to_blng_serv.arr, "~~~") == 0)
	
		fprintf(f1,"\t\t%-20.20s %-10.10s : %-10s\n\n",loc_legend[110],loc_legend[70],loc_legend[230]);
	else
		fprintf(f1,"\t\t%-20.20s %-10.10s : %s\n\n",loc_legend[110],loc_legend[70],nd_to_blng_serv.arr);
    
    fprintf(f1,"");
    ++page_no;

}

print_end_of_rep()
{
    fprintf(f1,"\n\n                                                    ** %-20s **                                                             \n",loc_legend[310]);
}

init_prev_values()
{

    d_prev_episode_type.arr[0]  = '\0';

    d_prev_episode_type.len     = 0;

}

copy_val()
{

    strcpy(d_prev_episode_type.arr,d_episode_type.arr);

    d_prev_episode_type.len         = strlen(d_prev_episode_type.arr);

}

episode_brk()
{
    return (strcmp(d_prev_episode_type.arr,d_episode_type.arr));
}


init_epi_totals()
{

       g_epi_net_amt    = 0;
       g_epi_gross_amt  = 0;
       g_epi_disc_amt   = 0;
       g_epi_no_of_trans  = 0;
}

init_grand_totals()
{
       g_tot_net_amt   = 0;
       g_tot_gross_amt = 0;
       g_tot_disc_amt  = 0;
       g_tot_no_of_trans  = 0;
}

print_formated(s_amt, l_amt)
double l_amt;
char *s_amt;
{

    if(l_amt < 0){
        put_val(s_amt,-l_amt);
        format_amt(s_amt);
        strcat(s_amt,"-");
    }
    else {
        put_val(s_amt,l_amt);
        format_amt(s_amt);
        strcat(s_amt," ");
    }
}

form_hdr()
{

    static int first = 1;
    char buf[17];
    char ctmp[100];
	char dtmp[100];
	
    int col;

   /* if (nd_fm_t_dt.arr[0] == '!!')
		strcpy(nd_fm_t_dt.arr,loc_legend[240]);
	
	if (nd_to_t_dt.arr[0]=='~~')
	    strcpy(nd_to_t_dt.arr,loc_legend[230]);*/

    if(first) {
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);

       		
        //strncpy(hdr_line1,"MDL : BL",8);	
		strcpy(hdr_line1,loc_legend[280]);
		strcat(hdr_line1, " : ");
		strcat(hdr_line1,loc_legend[150]);	
        col = (int)(REP_WIDTH-strlen(comp_name.arr))/2;
        strncpy(hdr_line1+col,comp_name.arr,strlen(comp_name.arr));
        col = (REP_WIDTH-strlen(rep_date.arr));
		  init_date_temp_var();
          strcpy(date_convert1.arr,rep_date.arr);
		  fun_change_loc_date1(); 
 
        //strncpy(hdr_line2,"OPR :",5);
		//strcpy(hdr_line2+6,oper_id.arr);
		strcpy(hdr_line2,loc_legend[290]);
		strcat(hdr_line2, " : ");
        strcat(hdr_line2,oper_id.arr);

	
	first = 0;
    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    //strncpy(hdr_line3,"REP : BLRTRSUM",14);
	strcpy(hdr_line3,loc_legend[300]);
	strcat(hdr_line3, " : ");
	strcat(hdr_line3,loc_legend[40]); 

    col = (int)(REP_WIDTH-strlen(rep_title))/2;
	strncpy(hdr_line3+col,loc_legend[50],strlen(rep_title));
    //strncpy(hdr_line3+col,rep_title,strlen(rep_title));
    sprintf(buf,"%10.10s: %4d",loc_legend[30],page_no); //prad
    strcpy(hdr_line3+(REP_WIDTH-16),buf);                //prad

    fprintf(f1,"%-9.9s%-36s%-62.62s%s\n",hdr_line1,"",hdr_line1+col,date_convert1.arr);
    fprintf(f1,"%-15.15s \n",hdr_line2);
  //fprintf(f1,"%-15.15s         %-56s %-6.6s:%4d \n",hdr_line3,hdr_line3+col,loc_legend[30],page_no);
	fprintf(f1,"%-30.30s          %-40s\n",hdr_line3,hdr_line3+col);

    
//sprintf(ctmp,"TRANSACTION DATE FROM : %s TO %s",nd_fm_t_dt.arr,
      //            nd_to_t_dt.arr);

    memset(hdr_line4,' ',REP_WIDTH+1);
	if (nd_fm_t_dt.arr[0] != '\0')
	{
	init_date_temp_var();
    strcpy(date_convert.arr,nd_fm_t_dt.arr);
	fun_change_loc_date();
    sprintf(ctmp,"%40.40s %-5s : %s ",loc_legend[80],loc_legend[60],date_convert.arr);
	}
	else
	sprintf(ctmp,"%40.40s %-5s : %s ",loc_legend[80],loc_legend[60],loc_legend[240]);
	if (nd_to_t_dt.arr[0] != '\0')
	{
	init_date_temp_var();
    strcpy(date_convert.arr,nd_to_t_dt.arr);
	fun_change_loc_date();
	sprintf(dtmp," %3s : %s",loc_legend[70],date_convert.arr);
	}
	else
	sprintf(dtmp," %3s : %-12s",loc_legend[70],loc_legend[230]);
    col = (int)(REP_WIDTH-strlen(ctmp))/2;
    strncpy(hdr_line4+col,ctmp,strlen(ctmp));
    //fprintf(f1,"%s\n",hdr_line4); 
	fprintf(f1,"               %s %s\n",ctmp,dtmp); 
}


fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRTRSUM.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRTRSUM.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )304;
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



		l_pk_value.arr[l_pk_value.len]	= '\0';
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
  sqlstm.arrsiz = 12;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )327;
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



		l_translated_value.arr[l_translated_value.len] = '\0';
		strcpy(loc_legend[i],l_translated_value.arr);
	}
}

get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	
	  :nd_loc_date :=sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id);

       //	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
	   //:nd_loc_date := to_char(t_date,'DD/MM/YYYY');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )358;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[0] = (unsigned int  )37;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[1] = (unsigned int  )37;
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
nd_temp_date1.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
nd_loc_date1.arr[0]  = '\0';
date_convert.arr[0] = '\0';
date_convert1.arr[0] = '\0';

nd_temp_date.len = 0;
nd_temp_date1.len = 0;
nd_loc_date.len  = 0;
nd_loc_date1.len  = 0;
date_convert.len = 0;
date_convert1.len = 0;
}


fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);


get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}


get_local_date1()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date1  date;
	
	BEGIN
	
	  :nd_loc_date1 :=sm_convert_datetime_2t(to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:p_language_id);
       
	   //	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date1);  
      
	   //:nd_loc_date1 := to_char(t_date1,'DD/MM/YYYY HH24:MI');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 12;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date1 date ; BEGIN :nd_loc_date1 := sm_convert_dat\
etime_2t ( to_date ( :nd_temp_date1 , 'DD/MM/YYYY HH24:MI' ) , :p_language_id \
) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )385;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date1;
 sqlstm.sqhstl[0] = (unsigned int  )37;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date1;
 sqlstm.sqhstl[1] = (unsigned int  )37;
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

                     

fun_change_loc_date1()
{

strcpy(nd_temp_date1.arr,date_convert1.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);


get_local_date1();

strcpy(date_convert1.arr,nd_loc_date1.arr); 

}






