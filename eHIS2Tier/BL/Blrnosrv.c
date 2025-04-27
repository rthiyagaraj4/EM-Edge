
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
    "T:\\temp\\Bl\\ganapathy\\JDWORK\\PROC\\Blrnosrv.pc"
};


static unsigned long sqlctx = 1267617653;


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
            void  *sqhstv[15];
   unsigned int   sqhstl[15];
            int   sqhsts[15];
            void  *sqindv[15];
            int   sqinds[15];
   unsigned int   sqharm[15];
   unsigned int   *sqharc[15];
   unsigned short  sqadto[15];
   unsigned short  sqtdso[15];
} sqlstm = {10,15};

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
"select TRUNC(SERVICE_DATE) ,BLNG_SERV_CODE ,UPD_GROSS_CHARGE_AMT ,UPD_DISC_A\
MT ,UPD_NET_CHARGE_AMT  from BL_PATIENT_CHARGES_FOLIO where (((((BLNG_GRP_ID b\
etween :b0 and :b1 and OPERATING_FACILITY_ID=:b2) and TRUNC(SERVICE_DATE) betw\
een TO_DATE(NVL(:b3,'00010101'),'YYYYMMDD') and TO_DATE(NVL(:b4,'47121201'),'Y\
YYYMMDD')) and BLNG_SERV_CODE between NVL(:b5,' ') and NVL(:b6,'~~~~~~')) and \
NVL(PACKAGE_TRX_IND,'N')='N') and ((PACKAGE_IND='S' and :b7='N') or (PACKAGE_I\
ND in ('S','P') and :b7='Y'))) order by BLNG_SERV_CODE,TRUNC(SERVICE_DATE)    \
        ";

 static const char *sq0005 = 
"select SUBSTR(BLNG_SERV_CODE,1,2) ,BLNG_SERV_CODE ,count(*)  ,sum(DECODE(TRX\
_DOC_REF_SEQ_NUM,0,NVL(SERV_QTY,0),0.00)) ,sum(ORG_GROSS_CHARGE_AMT) ,sum(ORG_\
DISC_AMT) ,sum(ORG_NET_CHARGE_AMT)  from BL_PATIENT_CHARGES_FOLIO where (((((B\
LNG_GRP_ID between :b0 and :b1 and OPERATING_FACILITY_ID=:b2) and TRUNC(SERVIC\
E_DATE) between TO_DATE(NVL(:b3,'00010101'),'YYYYMMDD') and TO_DATE(NVL(:b4,'4\
7121201'),'YYYYMMDD')) and BLNG_SERV_CODE between NVL(:b5,' ') and NVL(:b6,'~~\
~~~~')) and NVL(PACKAGE_TRX_IND,'N')='N') and ((PACKAGE_IND='S' and :b7='N') o\
r (PACKAGE_IND in ('S','P') and :b7='Y'))) group by BLNG_SERV_CODE order by BL\
NG_SERV_CODE            ";

 static const char *sq0006 = 
"select LONG_DESC  from BL_BLNG_SERV where BLNG_SERV_CODE=:b0           ";

 static const char *sq0007 = 
"select LONG_DESC ,SHORT_DESC  from BL_BLNG_SERV_GRP where SERV_GRP_CODE=:b0 \
          ";

 static const char *sq0008 = 
"select LONG_DESC ,SHORT_DESC  from BL_BLNG_SERV_GRP where SERV_GRP_CODE=:b0 \
          ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,207,0,0,0,0,0,1,0,
20,0,0,2,335,0,4,240,0,0,15,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
95,0,0,3,84,0,2,275,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
122,0,0,4,552,0,9,379,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
173,0,0,5,646,0,9,391,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
224,0,0,4,0,0,13,418,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
259,0,0,5,0,0,13,449,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,4,0,0,2,4,0,0,2,4,
0,0,2,4,0,0,
302,0,0,6,71,0,9,472,0,0,1,1,0,1,0,1,9,0,0,
321,0,0,6,0,0,13,479,0,0,1,0,0,1,0,2,9,0,0,
340,0,0,7,86,0,9,492,0,0,1,1,0,1,0,1,9,0,0,
359,0,0,7,0,0,13,502,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
382,0,0,8,86,0,9,520,0,0,1,1,0,1,0,1,9,0,0,
401,0,0,8,0,0,13,530,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
424,0,0,9,0,0,27,863,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
455,0,0,10,128,0,4,1032,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
};


  
/************************************************************************/
/* OCS MEDICOM VER 2.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRNOSRV.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 26-AUG-1993                                  */
/* Modified By			 : V. Srikanth									*/
/*						   (Billing Service Summary Func. added)	    */
/* Date Written			 : 18/04/1999									*/
/* Correction Log		 : 27/06/1999  V.Srikanth					    */
/*						   Service Quantity item also added in the      */
/*                         Billing Service Summary Report				*/
/*                                                                      */
/* Modified By			  : VSK for BLENH Purpose                        */
/*                                                                      */
/*                                                                      */
/************************************************************************/
                                                         
#include <stdio.h>       
#include <string.h>
#include "bl.h"
 
#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
     
#define INIT_MESG "Report Generation In Progress"

#define MAX_LINES            55
#define CHARGE_DETAILS       (nd_chg_dtls.arr[0] == 'Y')

/*
#define DEBUG
*/

int lctr = 0,pctr = 0;

FILE *fp;


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd           [91],
            hosp_name         [120],
            date_time         [20],
            user_id           [41],
            d_curr_pgm_name   [15],
            nd_session_id     [16],
            nd_pgm_date       [25],
            nd_fm_date        [17],
            nd_to_date        [17],
            nd_fm_date_prn    [17],
            nd_to_date_prn    [17],
            nd_fm_blng_serv   [11],
            nd_to_blng_serv   [11],
			nd_fm_blng_grp	  [3],
			nd_to_blng_grp	  [3],
            nd_chg_dtls       [2],
            nd_pkg_serv       [2],
			nd_operating_facility_id [3]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[41]; } user_id;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[17]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[17]; } nd_to_date;

struct { unsigned short len; unsigned char arr[17]; } nd_fm_date_prn;

struct { unsigned short len; unsigned char arr[17]; } nd_to_date_prn;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_blng_serv;

struct { unsigned short len; unsigned char arr[11]; } nd_to_blng_serv;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_blng_grp;

struct { unsigned short len; unsigned char arr[3]; } nd_to_blng_grp;

struct { unsigned short len; unsigned char arr[2]; } nd_chg_dtls;

struct { unsigned short len; unsigned char arr[2]; } nd_pkg_serv;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;


   /* VARCHAR bl_blng_serv_code                           [11],
           bl_blng_serv_code_desc                      [41],
		   bl_blng_serv_grp_desc                       [16],
		   bl_blng_serv_grp_desc_long                  [41],
           bl_service_date                             [15]; */ 
struct { unsigned short len; unsigned char arr[11]; } bl_blng_serv_code;

struct { unsigned short len; unsigned char arr[41]; } bl_blng_serv_code_desc;

struct { unsigned short len; unsigned char arr[16]; } bl_blng_serv_grp_desc;

struct { unsigned short len; unsigned char arr[41]; } bl_blng_serv_grp_desc_long;

struct { unsigned short len; unsigned char arr[15]; } bl_service_date;


   double  bl_upd_gross_charge_amt,
           bl_upd_disc_amt,
           bl_upd_net_charge_amt,
		   bl_upd_serv_qty,

           bl_upd_gross_charge_amt_tot,
           bl_upd_disc_amt_tot,
           bl_upd_net_charge_amt_tot,
		   bl_upd_serv_qty_tot,

           bl_upd_gross_charge_amt_gtot,
           bl_upd_disc_amt_gtot,
           bl_upd_net_charge_amt_gtot,
		   bl_upd_serv_qty_gtot,

           bl_upd_gross_charge_amt_stot,
           bl_upd_disc_amt_stot,
           bl_upd_net_charge_amt_stot,
		   bl_upd_serv_qty_stot;

   long    bl_pat_no_of_recs = 0,
           bl_pat_no_of_recs_stot = 0,
           bl_pat_no_of_recs_gtot = 0;

   /* VARCHAR pre_blng_serv  [11],
	   pre_serv_grp   [3],
	   pre_serv_grp_1 [3],
           pre_serv_date  [15]; */ 
struct { unsigned short len; unsigned char arr[11]; } pre_blng_serv;

struct { unsigned short len; unsigned char arr[3]; } pre_serv_grp;

struct { unsigned short len; unsigned char arr[3]; } pre_serv_grp_1;

struct { unsigned short len; unsigned char arr[15]; } pre_serv_date;



   char    nd_summary;
   char    string_var [150];
/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/Blrnosrv.c-arc   1.0   Apr 19 2007 17:06:38   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/Blrnosrv.c-arc   1.0   Apr 19 2007 17:06:38   vcm_th  $ sqlda.h 
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

char filename[100];
int  rec_no;
 
void proc_main(argc,argv)
char *argv[];
int argc;
{
 
    strcpy(g_pgm_id,"BLRNOSRV");

    if (sql_connect(argv[1]) == -1)
    {
         disp_message(ORA_MESG,"Error in connecting to Oracle");
         proc_exit();
    }
    strcpy(d_curr_pgm_name.arr,g_pgm_id);
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr);

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

    set_meduser_role();
    
    fetch_prog_param();
    declare_cur();
    fetch_hosp_name();
    open_file();

/*-- Due to a new finctionality added the existing code made conditionally
     intact (undisturbed) VSK 18/04/1999 */
	     
	if (nd_summary == 'N' || nd_summary == 'Y')
	{

	open_cur();

	bl_upd_gross_charge_amt_tot = bl_upd_disc_amt_tot =
    bl_upd_net_charge_amt_tot = rec_no = bl_upd_gross_charge_amt_gtot =
    bl_upd_disc_amt_gtot = bl_upd_net_charge_amt_gtot = bl_pat_no_of_recs = 
    bl_pat_no_of_recs_gtot = 0;
    pre_blng_serv.arr[0] = pre_serv_date.arr[0] = '\0';
    pre_serv_grp.arr[0] = '\0';

    while(fetch_cur())
    {
        if (!rec_no) {
           strcpy(pre_blng_serv.arr,bl_blng_serv_code.arr);
           strcpy(pre_serv_date.arr,bl_service_date.arr);
	   strncpy(pre_serv_grp.arr, bl_blng_serv_code.arr,2);
	}
        
        if (strcmp(pre_blng_serv.arr,bl_blng_serv_code.arr) ||
              strcmp(pre_serv_date.arr,bl_service_date.arr))
        {
            fetch_blng_desc();
            print_rec();
            if (strncmp(pre_serv_grp.arr, bl_blng_serv_code.arr,2))
	      print_sub_tot();
	    strncpy(pre_serv_grp.arr, bl_blng_serv_code.arr,2);
            strcpy(pre_blng_serv.arr,bl_blng_serv_code.arr);
            strcpy(pre_serv_date.arr,bl_service_date.arr);
        }
        bl_pat_no_of_recs++;
        bl_upd_gross_charge_amt_tot += bl_upd_gross_charge_amt; 
        bl_upd_disc_amt_tot += bl_upd_disc_amt;
        bl_upd_net_charge_amt_tot += bl_upd_net_charge_amt;

        rec_no++;
    }
    if (rec_no)
    {
	    
        fetch_blng_desc();

        print_rec();
		print_sub_tot();
        print_total();
    }
    end_of_rep();
	} /* End of Existing functionalities */
	else
	{ 
/*-- New function. SCF 83 VSK 18/04/1999. Billing Service Summary Report */
		
		open_1_cur();
		
		do_report();
		end_of_rep();
	}	
	

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 0;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT failed",0,"");

    return;
}

fetch_prog_param()
{
   nd_fm_date.arr[0]       = '\0';
   nd_to_date.arr[0]       = '\0';
   nd_fm_date_prn.arr[0]       = '\0';
   nd_to_date_prn.arr[0]       = '\0';
   nd_fm_blng_serv.arr[0]  = '\0';
   nd_to_blng_serv.arr[0]  = '\0';
   nd_chg_dtls.arr[0]      = '\0';
   nd_pkg_serv.arr[0]      = '\0';
   nd_fm_blng_grp.arr[0]		=	'\0';
   nd_to_blng_grp.arr[0]		=	'\0';
   nd_operating_facility_id.arr[0] = '\0';

   nd_fm_date.len          = 0;
   nd_to_date.len          = 0;
   nd_fm_date_prn.len          = 0;
   nd_to_date_prn.len          = 0;
   nd_fm_blng_serv.len     = 0;
   nd_to_blng_serv.len     = 0;
   nd_chg_dtls.len         = 0;
   nd_pkg_serv.len         = 0;
   nd_fm_blng_grp.len		=	0;
   nd_to_blng_grp.len		=	0;   
   nd_operating_facility_id.len = 0;

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,PARAM7,
                   TO_CHAR(TO_DATE(PARAM1,'YYYYMMDD'),'DD/MM/YYYY'),
                   TO_CHAR(TO_DATE(PARAM2,'YYYYMMDD'),'DD/MM/YYYY'),
				   PARAM8,PARAM9
              INTO :nd_operating_facility_id,
			       :nd_fm_date,      :nd_to_date,  :nd_fm_blng_serv,
                   :nd_to_blng_serv, :nd_chg_dtls, :nd_pkg_serv, :nd_summary,
                   :nd_fm_date_prn,  :nd_to_date_prn, :nd_fm_blng_grp,
				   :nd_to_blng_grp
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,TO_CHAR(TO_DATE(PARAM1,'YYYYMMDD'),'DD/MM/YYYY') ,\
TO_CHAR(TO_DATE(PARAM2,'YYYYMMDD'),'DD/MM/YYYY') ,PARAM8 ,PARAM9 into :b0,:b1,\
:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11  from SY_PROG_PARAM where ((PGM_ID=:\
b12 and SESSION_ID=:b13) and PGM_DATE=:b14)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )20;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[1] = (unsigned int  )19;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[2] = (unsigned int  )19;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_blng_serv;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_blng_serv;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_chg_dtls;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_pkg_serv;
   sqlstm.sqhstl[6] = (unsigned int  )4;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_summary;
   sqlstm.sqhstl[7] = (unsigned int  )1;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_fm_date_prn;
   sqlstm.sqhstl[8] = (unsigned int  )19;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_to_date_prn;
   sqlstm.sqhstl[9] = (unsigned int  )19;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_fm_blng_grp;
   sqlstm.sqhstl[10] = (unsigned int  )5;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_to_blng_grp;
   sqlstm.sqhstl[11] = (unsigned int  )5;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[12] = (unsigned int  )17;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[13] = (unsigned int  )18;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[14] = (unsigned int  )27;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
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

   nd_fm_date.arr[nd_fm_date.len] = '\0';
   nd_to_date.arr[nd_to_date.len] = '\0';
   nd_fm_blng_serv.arr[nd_fm_blng_serv.len] = '\0';
   nd_to_blng_serv.arr[nd_to_blng_serv.len] = '\0';
   nd_chg_dtls.arr[nd_chg_dtls.len] = '\0';
   nd_pkg_serv.arr[nd_pkg_serv.len] = '\0';
   nd_fm_date_prn.arr[nd_fm_date_prn.len] = '\0';
   nd_to_date_prn.arr[nd_to_date_prn.len] = '\0';
   nd_fm_blng_grp.arr[nd_fm_blng_grp.len]		=	'\0';
   nd_to_blng_grp.arr[nd_to_blng_grp.len]		=	'\0';
   nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';

   strcpy(g_facility_id, nd_operating_facility_id.arr);

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
                  WHERE PGM_ID     = :d_curr_pgm_name
                    AND SESSION_ID = :nd_session_id
                    AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 15;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )95;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
}

declare_cur()
{
/* 
	Select Statement corrected by Venkat
	on 20/09/1999 by adding
	TRUNC(SERVICE_DATE) instead of SERVICE_DATE 
	in WHERE clause
 */

     /* EXEC SQL DECLARE BL_PATIENT_CHG_FOLIO_CUR CURSOR FOR
               SELECT TRUNC(SERVICE_DATE),
                      BLNG_SERV_CODE,
                      UPD_GROSS_CHARGE_AMT,
                      UPD_DISC_AMT,
                      UPD_NET_CHARGE_AMT
                 FROM BL_PATIENT_CHARGES_FOLIO
                WHERE BLNG_GRP_ID BETWEEN :nd_fm_blng_grp AND :nd_to_blng_grp AND
				      OPERATING_FACILITY_ID = :nd_operating_facility_id AND
//				      TO_DATE(SERVICE_DATE) BETWEEN
					  TRUNC(SERVICE_DATE) BETWEEN
                       TO_DATE(NVL(:nd_fm_date,'00010101'),'YYYYMMDD')
                      AND
                       TO_DATE(NVL(:nd_to_date,'47121201'),'YYYYMMDD')
                      AND BLNG_SERV_CODE  BETWEEN
                       NVL(:nd_fm_blng_serv,' ')
                      AND
                       NVL(:nd_to_blng_serv,'~~~~~~')
                      AND NVL(PACKAGE_TRX_IND,'N') = 'N'
                      AND ((PACKAGE_IND = 'S' AND :nd_pkg_serv = 'N')
                          OR PACKAGE_IND IN ('S','P') AND :nd_pkg_serv = 'Y')
                 ORDER BY BLNG_SERV_CODE,TRUNC(SERVICE_DATE); */ 

//			  TO_DATE(SERVICE_DATE,'DD-MON-YYYY');


/*-- SCF 83 AH requirement VSK 18/04/1999. Folio Cursor--------- */
/*-- SCF 327 AH requirement adding serv_qty also. VSK 28/06/1999 */


/* 
	Select Statement below is corrected by Venkat
	on 20/09/1999 by adding
	TRUNC(SERVICE_DATE) instead of SERVICE_DATE 
	in WHERE clause
 */


     /* EXEC SQL DECLARE BL_PATIENT_CHG_FOLIO_1_CUR CURSOR FOR
               SELECT SUBSTR(BLNG_SERV_CODE,1,2),
                      BLNG_SERV_CODE,
                      COUNT(*),
/oBLENH VSK o/		  SUM(DECODE(TRX_DOC_REF_SEQ_NUM,0,NVL(SERV_QTY,0),0.00)),
					  SUM(ORG_GROSS_CHARGE_AMT),
					  SUM(ORG_DISC_AMT),
					  SUM(ORG_NET_CHARGE_AMT)
                 FROM BL_PATIENT_CHARGES_FOLIO
                WHERE BLNG_GRP_ID BETWEEN :nd_fm_blng_grp AND :nd_to_blng_grp AND
				      OPERATING_FACILITY_ID = :nd_operating_facility_id AND
					  TRUNC(SERVICE_DATE) BETWEEN
                       TO_DATE(NVL(:nd_fm_date,'00010101'),'YYYYMMDD')
                      AND
                       TO_DATE(NVL(:nd_to_date,'47121201'),'YYYYMMDD')
                      AND BLNG_SERV_CODE  BETWEEN
                       NVL(:nd_fm_blng_serv,' ')
                      AND
                       NVL(:nd_to_blng_serv,'~~~~~~')
                      AND NVL(PACKAGE_TRX_IND,'N') = 'N'
                      AND ((PACKAGE_IND = 'S' AND :nd_pkg_serv = 'N')
                          OR PACKAGE_IND IN ('S','P') AND :nd_pkg_serv = 'Y')
					  GROUP BY BLNG_SERV_CODE
                      ORDER BY BLNG_SERV_CODE; */ 




     /* EXEC SQL DECLARE BL_BLGN_SERV_CUR CURSOR FOR
               SELECT LONG_DESC
                 FROM BL_BLNG_SERV
                WHERE BLNG_SERV_CODE = :pre_blng_serv; */ 


     
     /* EXEC SQL DECLARE BL_BLNG_SERV_GRP_CUR CURSOR FOR
               SELECT LONG_DESC,
		      SHORT_DESC
                 FROM BL_BLNG_SERV_GRP
                WHERE SERV_GRP_CODE = :pre_serv_grp; */ 


/*-- Cursor for Service group desc VSK 18/04/1999 */

	 /* EXEC SQL DECLARE BL_BLNG_SERV_GRP_1_CUR CURSOR FOR
               SELECT LONG_DESC,
		      SHORT_DESC
                 FROM BL_BLNG_SERV_GRP
                WHERE SERV_GRP_CODE = :pre_serv_grp_1; */ 

}

open_cur()
{
    /* EXEC SQL OPEN BL_PATIENT_CHG_FOLIO_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )122;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_blng_grp;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_blng_grp;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[3] = (unsigned int  )19;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[4] = (unsigned int  )19;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_fm_blng_serv;
    sqlstm.sqhstl[5] = (unsigned int  )13;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_blng_serv;
    sqlstm.sqhstl[6] = (unsigned int  )13;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_pkg_serv;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_pkg_serv;
    sqlstm.sqhstl[8] = (unsigned int  )4;
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
        err_mesg("OPEN failed on cursor BL_PATIENT_CHG_FOLIO_CUR",0,"");

}


/*-- SCF 83 VSK 18/04/1999 Open folio cursor */

open_1_cur()
{
    /* EXEC SQL OPEN BL_PATIENT_CHG_FOLIO_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )173;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_blng_grp;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_blng_grp;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[3] = (unsigned int  )19;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[4] = (unsigned int  )19;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_fm_blng_serv;
    sqlstm.sqhstl[5] = (unsigned int  )13;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_blng_serv;
    sqlstm.sqhstl[6] = (unsigned int  )13;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_pkg_serv;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_pkg_serv;
    sqlstm.sqhstl[8] = (unsigned int  )4;
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
        err_mesg("OPEN failed on cursor BL_PATIENT_CHG_FOLIO_1_CUR",0,"");

}


end_of_rep()
{
fprintf(fp,"\n                                                      ***  END OF REPORT ***\n\f");
fclose(fp);
}

fetch_cur()
{

bl_blng_serv_code.arr[0]                                          = '\0';
bl_service_date.arr[0]                                            = '\0';

bl_blng_serv_code.len                                             = 0;
bl_service_date.len                                               = 0;

bl_upd_gross_charge_amt                                           = 0;
bl_upd_disc_amt                                                   = 0;
bl_upd_net_charge_amt                                             = 0;

     /* EXEC SQL FETCH BL_PATIENT_CHG_FOLIO_CUR
               INTO :bl_service_date,
                    :bl_blng_serv_code,
                    :bl_upd_gross_charge_amt,
                    :bl_upd_disc_amt,
                    :bl_upd_net_charge_amt; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )224;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_service_date;
     sqlstm.sqhstl[0] = (unsigned int  )17;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_blng_serv_code;
     sqlstm.sqhstl[1] = (unsigned int  )13;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_upd_gross_charge_amt;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_upd_disc_amt;
     sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_upd_net_charge_amt;
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



    if (OERROR)
       err_mesg("Error while fetching BL_PATIENT_CHG_FOLIO_CUR",0,"");

bl_service_date.arr[bl_service_date.len]                                 = '\0';
bl_blng_serv_code.arr[bl_blng_serv_code.len]                             = '\0';

    return (LAST_ROW?0:1);
}


/*-- SCF 83 VSK 18/04/1999 Fetch Folio Cursor */

fetch_1_cur()
{

pre_blng_serv.arr[0]                                          = '\0';
pre_serv_grp.arr[0]                                           = '\0';

pre_blng_serv.len                                             = 0;
pre_serv_grp.len                                              = 0;

bl_pat_no_of_recs = 0;
bl_upd_serv_qty = 0.0;

     /* EXEC SQL FETCH BL_PATIENT_CHG_FOLIO_1_CUR
               INTO :pre_serv_grp,
					:pre_blng_serv,
					:bl_pat_no_of_recs,
					:bl_upd_serv_qty,
					:bl_upd_gross_charge_amt,
                    :bl_upd_disc_amt,
                    :bl_upd_net_charge_amt; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )259;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&pre_serv_grp;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&pre_blng_serv;
     sqlstm.sqhstl[1] = (unsigned int  )13;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_no_of_recs;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_upd_serv_qty;
     sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_upd_gross_charge_amt;
     sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_upd_disc_amt;
     sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_upd_net_charge_amt;
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



    if (OERROR)
       err_mesg("Error while fetching BL_PATIENT_CHG_FOLIO_1_CUR",0,"");

pre_blng_serv.arr[pre_blng_serv.len]                            = '\0';
pre_serv_grp.arr[pre_serv_grp.len]                              = '\0';

    return (LAST_ROW?0:1);
}


fetch_blng_desc()
{
     pre_blng_serv.len  =   strlen(pre_blng_serv.arr);

     /* EXEC SQL OPEN BL_BLGN_SERV_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0006;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )302;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&pre_blng_serv;
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


     if (OERROR)
         err_mesg("OPEN failed on cursor BL_BLNG_SERV_CUR",0,"");

     bl_blng_serv_code_desc.arr[0]  = '\0';
     bl_blng_serv_code_desc.len     = 0;

     /* EXEC SQL FETCH BL_BLGN_SERV_CUR
               INTO :bl_blng_serv_code_desc; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )321;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_blng_serv_code_desc;
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


     if (OERROR)
         err_mesg("FETCH failed on cursor BL_BLNG_SERV_CUR",0,"");

     bl_blng_serv_code_desc.arr[bl_blng_serv_code_desc.len] = '\0';
}

fetch_serv_grp_desc()
{
	
     pre_serv_grp.len = strlen(pre_serv_grp.arr);

     /* EXEC SQL OPEN BL_BLNG_SERV_GRP_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0007;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )340;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&pre_serv_grp;
     sqlstm.sqhstl[0] = (unsigned int  )5;
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


     if (OERROR)
         err_mesg("OPEN failed on cursor BL_BLNG_SERV_GRP_CUR",0,"");

     bl_blng_serv_grp_desc.arr[0]  = '\0';
     bl_blng_serv_grp_desc.len     = 0;

     bl_blng_serv_grp_desc_long.arr[0]  = '\0';
     bl_blng_serv_grp_desc_long.len     = 0;

     /* EXEC SQL FETCH BL_BLNG_SERV_GRP_CUR
               INTO :bl_blng_serv_grp_desc_long,
	            :bl_blng_serv_grp_desc; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )359;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_blng_serv_grp_desc_long;
     sqlstm.sqhstl[0] = (unsigned int  )43;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_blng_serv_grp_desc;
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


     if (OERROR)
         err_mesg("FETCH failed on cursor BL_BLNG_SERV_GRP_CUR",0,"");

     bl_blng_serv_grp_desc.arr[bl_blng_serv_grp_desc.len]  = '\0';
     bl_blng_serv_grp_desc_long.arr[bl_blng_serv_grp_desc_long.len]  = '\0';

}

/*-- SCF 83 VSK 18/04/1999 Fetch Service Group description */

fetch_serv_grp_desc_1()
{
	
     pre_serv_grp_1.len = strlen(pre_serv_grp_1.arr);

     /* EXEC SQL OPEN BL_BLNG_SERV_GRP_1_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0008;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )382;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&pre_serv_grp_1;
     sqlstm.sqhstl[0] = (unsigned int  )5;
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


     if (OERROR)
         err_mesg("OPEN failed on cursor BL_BLNG_SERV_GRP_1_CUR",0,"");

     bl_blng_serv_grp_desc.arr[0]  = '\0';
     bl_blng_serv_grp_desc.len     = 0;

     bl_blng_serv_grp_desc_long.arr[0]  = '\0';
     bl_blng_serv_grp_desc_long.len     = 0;

     /* EXEC SQL FETCH BL_BLNG_SERV_GRP_1_CUR
               INTO :bl_blng_serv_grp_desc_long,
	            :bl_blng_serv_grp_desc; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 15;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )401;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_blng_serv_grp_desc_long;
     sqlstm.sqhstl[0] = (unsigned int  )43;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_blng_serv_grp_desc;
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


     if (OERROR)
         err_mesg("FETCH failed on cursor BL_BLNG_SERV_GRP_1_CUR",0,"");

     bl_blng_serv_grp_desc.arr[bl_blng_serv_grp_desc.len]  = '\0';
     bl_blng_serv_grp_desc_long.arr[bl_blng_serv_grp_desc_long.len]  = '\0';

}

open_file()
{
   strcat(filename,CHARGE_DETAILS?"blrnosrv.lis":"blrnosrv.lis");

   if ((fp = fopen(filename,"w")) == NULL)
   {
       disp_message(ERR_MESG,"Error in opening file BLRNOSRV.LIS");
       proc_exit();
   }    
   strcpy(OUTPUT_FILE_NAME,filename);
   print_title();
   print_head();
}

  
print_rec()
{

 if(nd_summary == 'N') {
     fprintf(fp,"%-10s %-40s %-10s ",
           pre_blng_serv.arr,
           bl_blng_serv_code_desc.arr,
           pre_serv_date.arr);

     if (!CHARGE_DETAILS)
          print_formated1(bl_pat_no_of_recs);
     else 
     {
          print_formated1(bl_pat_no_of_recs);
          fprintf(fp,"  ");
          print_formated(bl_upd_gross_charge_amt_tot, fp);
          fprintf(fp,"  ");
          print_formated(bl_upd_disc_amt_tot, fp);
          fprintf(fp,"  ");
          print_formated(bl_upd_net_charge_amt_tot, fp);
     }
     fprintf(fp,"\n");
     page_break(1);

 }

bl_upd_gross_charge_amt_gtot += bl_upd_gross_charge_amt_tot;
bl_upd_disc_amt_gtot         += bl_upd_disc_amt_tot;
bl_upd_net_charge_amt_gtot   += bl_upd_net_charge_amt_tot;
bl_pat_no_of_recs_gtot       += bl_pat_no_of_recs;

bl_upd_gross_charge_amt_stot += bl_upd_gross_charge_amt_tot;
bl_upd_disc_amt_stot         += bl_upd_disc_amt_tot;
bl_upd_net_charge_amt_stot   += bl_upd_net_charge_amt_tot;
bl_pat_no_of_recs_stot       += bl_pat_no_of_recs;

bl_pat_no_of_recs = bl_upd_gross_charge_amt_tot = bl_upd_disc_amt_tot =
bl_upd_net_charge_amt_tot = 0;

}
// $$$$$$$$$$$$$$$$$
print_sub_tot()
{
   fflush(fp);
   fetch_serv_grp_desc();
if(nd_summary == 'Y') {
     fprintf(fp,"%-6s %-40s      ",
           pre_serv_grp.arr,
           bl_blng_serv_grp_desc_long.arr);

     if (!CHARGE_DETAILS)
          print_formated1(bl_pat_no_of_recs_stot);
     else 
     {
          print_formated1(bl_pat_no_of_recs_stot);
          fprintf(fp,"  ");
          print_formated(bl_upd_gross_charge_amt_stot, fp);
          fprintf(fp,"  ");
          print_formated(bl_upd_disc_amt_stot, fp);
          fprintf(fp,"  ");
          print_formated(bl_upd_net_charge_amt_stot, fp);
     }
     fprintf(fp,"\n");
     page_break(1);

}
else {
    fprintf(fp,"\n");
    page_break(4);
    fprintf(fp,
    "                                                                     ----------------------------------------------------------------\n");
    
       fprintf(fp,"Sub Total for Billing Service Group : %2s  %-15s :",
               pre_serv_grp.arr,bl_blng_serv_grp_desc.arr);
       fflush(fp);
       print_formated1(bl_pat_no_of_recs_stot);
       fprintf(fp,"  ");
       fflush(fp);
       if CHARGE_DETAILS
       {
          print_formated(bl_upd_gross_charge_amt_stot, fp);
          fprintf(fp,"  ");
          print_formated(bl_upd_disc_amt_stot, fp);
          fprintf(fp,"  ");
          print_formated(bl_upd_net_charge_amt_stot, fp);
       }
    fprintf(fp,
    "\n                                                                     ================================================================\n");
}
   fprintf(fp,"\n");
   fflush(fp);

bl_upd_gross_charge_amt_stot = bl_upd_disc_amt_stot =  
bl_upd_net_charge_amt_stot   = bl_pat_no_of_recs_stot = 0;

}

print_total()
{
   fprintf(fp,"\n");
   fflush(fp);
   page_break(4);
if(nd_summary == 'Y') {
    fprintf(fp,
    "---------------------------------------------------------------------------------------------------------------------------\n");
   fprintf(fp,"                                TOTAL           ");
}
else {
    fprintf(fp,
    "-------------------------------------------------------------------------------------------------------------------------------------\n");
   fprintf(fp,"                                TOTAL                      ");
}  

   fflush(fp);
   print_formated1(bl_pat_no_of_recs_gtot);
   fprintf(fp,"  ");
   fflush(fp);
   if CHARGE_DETAILS
   {
      print_formated(bl_upd_gross_charge_amt_gtot, fp);
      fprintf(fp,"  ");
      print_formated(bl_upd_disc_amt_gtot, fp);
      fprintf(fp,"  ");
      print_formated(bl_upd_net_charge_amt_gtot, fp);
   }
if(nd_summary == 'Y')
fprintf(fp,
"\n---------------------------------------------------------------------------------------------------------------------------\n");
else
fprintf(fp,
"\n-------------------------------------------------------------------------------------------------------------------------------------\n");
   fprintf(fp,"\n\n");
   fflush(fp);
}


/*-- SCF 83 VSK 18/04/1999  Body of the Report */

do_report()
{
	int fst;

	bl_upd_gross_charge_amt = bl_upd_disc_amt = bl_upd_net_charge_amt = 0;
	bl_upd_gross_charge_amt_tot = bl_upd_disc_amt_tot =
    bl_upd_net_charge_amt_tot = rec_no = bl_upd_gross_charge_amt_gtot =
    bl_upd_disc_amt_gtot = bl_upd_net_charge_amt_gtot = bl_pat_no_of_recs = 
    bl_pat_no_of_recs_gtot = bl_pat_no_of_recs_stot = 0;
	bl_upd_serv_qty = bl_upd_serv_qty_tot = bl_upd_serv_qty_gtot = bl_upd_serv_qty_stot =0;
    pre_blng_serv.arr[0] = pre_serv_date.arr[0] = '\0';
    pre_serv_grp.arr[0] = '\0';
	pre_serv_grp_1.arr[0] = '\0';

	fst = 1;
	
	while(fetch_1_cur())
	{
		
		if (fst)
		{
			strcpy(pre_serv_grp_1.arr,pre_serv_grp.arr);
			fst = 0;
		}

		
		if (strcmp( pre_serv_grp_1.arr,pre_serv_grp.arr) != 0)
		{
			prt_sub_total();
			strcpy(pre_serv_grp_1.arr,pre_serv_grp.arr);
		}

		fetch_blng_desc();

        fprintf(fp,"%-10s %-40s ", pre_blng_serv.arr, 
								  bl_blng_serv_code_desc.arr);

        if (!CHARGE_DETAILS)
		{
		  print_formated1(bl_pat_no_of_recs);
		  fprintf(fp,"   ");
          print_formated(bl_upd_serv_qty, fp); /* Added by VSK 28/06/1999 */
		}
        else 
		{
          print_formated1(bl_pat_no_of_recs);
          print_formated(bl_upd_serv_qty, fp); /* Added by VSK 28/06/1999 */
          fprintf(fp,"  ");
          print_formated(bl_upd_gross_charge_amt, fp);
          fprintf(fp,"  ");
          print_formated(bl_upd_disc_amt, fp);
          fprintf(fp,"  ");
          print_formated(bl_upd_net_charge_amt, fp);
		}
		fprintf(fp,"\n");

		bl_pat_no_of_recs_stot		 += bl_pat_no_of_recs;
		bl_upd_serv_qty_stot		 += bl_upd_serv_qty;
		bl_upd_gross_charge_amt_stot += bl_upd_gross_charge_amt;
		bl_upd_disc_amt_stot		 += bl_upd_disc_amt;
		bl_upd_net_charge_amt_stot	 += bl_upd_net_charge_amt;

		page_break(1);

	}
	prt_sub_total();
	prt_grand_total();
}

/*-- SCF 83 VSK 18/04/1999 Print Subtotal for every break of Service Group */

prt_sub_total()
{
   fflush(fp);
   fetch_serv_grp_desc_1();
   fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
   fprintf(fp,"%-6s %-40s ",
           pre_serv_grp_1.arr,
           bl_blng_serv_grp_desc_long.arr);

     if (!CHARGE_DETAILS)
	 {
          print_formated1(bl_pat_no_of_recs_stot);
		  fprintf(fp,"   ");
          print_formated(bl_upd_serv_qty_stot, fp); /* Added by VSK 28/06/1999 */
	 }
     else 
     {
          print_formated1(bl_pat_no_of_recs_stot);
          print_formated(bl_upd_serv_qty_stot, fp); /* Added by VSK 28/06/1999 */
          fprintf(fp,"  ");
          print_formated(bl_upd_gross_charge_amt_stot, fp);
          fprintf(fp,"  ");
          print_formated(bl_upd_disc_amt_stot, fp);
          fprintf(fp,"  ");
          print_formated(bl_upd_net_charge_amt_stot, fp);
    }
	 fprintf(fp,"\n");
     fprintf(fp,
     "-------------------------------------------------------------------------------------------------------------------------------------\n");
     fprintf(fp,"\n");
     page_break(4);


     fflush(fp);
	 
	 bl_upd_gross_charge_amt_gtot += bl_upd_gross_charge_amt_stot;
	 bl_upd_serv_qty_gtot		  += bl_upd_serv_qty_stot;
	 bl_upd_disc_amt_gtot		  += bl_upd_disc_amt_stot;
	 bl_upd_net_charge_amt_gtot   += bl_upd_net_charge_amt_stot;
	 bl_pat_no_of_recs_gtot       += bl_pat_no_of_recs_stot;
	 
	 bl_upd_gross_charge_amt_stot  = bl_upd_disc_amt_stot = bl_upd_serv_qty_stot =   
	 bl_upd_net_charge_amt_stot    = bl_pat_no_of_recs_stot = 0;
}

/*-- SCF 83 VSK 18/04/1999 Print Grand total */

prt_grand_total()
{
   fflush(fp);
  
   fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
   fprintf(fp,"%-6s %-40s ",
           " ","         GRAND TOTAL ----->  ");

   if (!CHARGE_DETAILS)
   {
          print_formated1(bl_pat_no_of_recs_gtot);
		  fprintf(fp,"   ");
          print_formated(bl_upd_serv_qty_gtot, fp); /* Added by VSK 28/06/1999 */
   }
   else 
   {
          print_formated1(bl_pat_no_of_recs_gtot);
          print_formated(bl_upd_serv_qty_gtot, fp); /* Added by VSK 28/06/1999 */
          fprintf(fp,"  ");
          print_formated(bl_upd_gross_charge_amt_gtot, fp);
          fprintf(fp,"  ");
          print_formated(bl_upd_disc_amt_gtot, fp);
          fprintf(fp,"  ");
          print_formated(bl_upd_net_charge_amt_gtot, fp);
   }
   fprintf(fp,"\n");
   fprintf(fp,
   "-------------------------------------------------------------------------------------------------------------------------------------\n");
   fprintf(fp,"\n");
   page_break(4);


   fflush(fp);
	 
   
   bl_upd_gross_charge_amt_gtot  = bl_upd_disc_amt_gtot =  bl_upd_serv_qty_gtot =
   bl_upd_net_charge_amt_gtot    = bl_pat_no_of_recs_gtot = 0;
}


sql_connect(l_uid)
char l_uid[];
{
  /* EXEC SQL BEGIN DECLARE SECTION; */ 

       /* VARCHAR l_d_ap_uid_pwd[75]; */ 
struct { unsigned short len; unsigned char arr[75]; } l_d_ap_uid_pwd;

   /* EXEC SQL END DECLARE SECTION; */ 

    strcpy(l_d_ap_uid_pwd.arr,l_uid);
    l_d_ap_uid_pwd.len = strlen(l_d_ap_uid_pwd.arr);

    /* EXEC SQL CONNECT :l_d_ap_uid_pwd; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )10;
    sqlstm.offset = (unsigned int  )424;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&l_d_ap_uid_pwd;
    sqlstm.sqhstl[0] = (unsigned int  )77;
    sqlstm.sqhsts[0] = (         int  )77;
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



print_title()
{
if (nd_summary != 'B')
{
fprintf(fp,
"MDL : BL                                         %-30s                                      %-18s\n",
hosp_name.arr,date_time.arr);
fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                              %-45s                                 PAGE : %4d\n",
CHARGE_DETAILS?"BLRNOSRV":"BLRNOSRQ",
CHARGE_DETAILS?"BILLING SERVICES BY DATE WITH CHARGE DETAILS":
"        BILLING SERVICES BY DATE",
++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
}
else
{

/*-- SCF 83 VSK 18/04/1999 Print Title*/
    fprintf(fp,
    "MDL : BL                                         %-30s                                      %-15s\n",
    hosp_name.arr,date_time.arr);
    fprintf(fp,"OPR : %-10s \n", user_id.arr);
    fprintf(fp,
	"REP : %-8s                              %-45s                                 PAGE : %4d\n",
	CHARGE_DETAILS?"BLRNOSRV":"BLRNOSRQ",
	CHARGE_DETAILS?"BILLING SERVICE SUMMARY WITH CHARGE DETAILS":
	"        BILLING SERVICE SUMMARY ",
	++pctr);
    fprintf(fp,
    "-------------------------------------------------------------------------------------------------------------------------------------\n");
}
fprintf(fp,"VER : 4.1\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");
fprintf(fp,"             SERVICE DATE      FROM  : %s\n",nd_fm_date_prn.arr);
fprintf(fp,"                               TO    : %s\n\n",nd_to_date_prn.arr);

if (nd_fm_blng_grp.arr[0] == '!')
	fprintf(fp,"             BILLING GROUP     FROM  : %s\n"," ");
else
	fprintf(fp,"             BILLING GROUP     FROM  : %s\n",nd_fm_blng_grp.arr);

if (nd_to_blng_grp.arr[0] == '~')
	fprintf(fp,"                               TO    : %s\n\n"," ");
else
	fprintf(fp,"                               TO    : %s\n\n",nd_to_blng_grp.arr);

fprintf(fp,"             BILLING SERVICE   FROM  : %s\n",nd_fm_blng_serv.arr);
fprintf(fp,"                               TO    : %s\n\n",nd_to_blng_serv.arr);
fprintf(fp,"                     CHARGE DETAILS? : %s\n\n",nd_chg_dtls.arr);
fprintf(fp,"             INCLUDE PACKAGE SERVICE : %s\n\n",nd_pkg_serv.arr);

if (nd_summary == 'N')
fprintf(fp,"             SUMMARY REPORT          : %s\n","Billing Service Detail");
else if (nd_summary == 'Y')
fprintf(fp,"             SUMMARY REPORT          : %s\n","Billing Service Group Summary");
else if (nd_summary == 'B')
fprintf(fp,"             SUMMARY REPORT          : %s\n","Billing Service Summary");
}

print_head()
{

if(nd_summary == 'Y') {
    fprintf(fp,
    "\fMDL : BL                                    %-30s                                   %-18s\n",
    hosp_name.arr,date_time.arr);
    fprintf(fp,"OPR : %-10s \n", user_id.arr);
    fprintf(fp,
    "REP : %-8s                         %-45s                            PAGE : %4d\n",
    CHARGE_DETAILS?"BLRNOSRV":"BLRNOSRQ",
    CHARGE_DETAILS?"BILLING SERVICES BY DATE WITH CHARGE DETAILS":
    "        BILLING SERVICES BY DATE",
    ++pctr);

    fprintf(fp,
    "---------------------------------------------------------------------------------------------------------------------------\n");
    if CHARGE_DETAILS
    fprintf(fp,
    "BLNG SERV GROUP & DESCRIPTION                                NO.        GROSS CHG.          DISC AMT          NET CHG.\n");
    else
    fprintf(fp,
    "BLNG SERV & DESCRIPTION                                     NO.\n");
    fprintf(fp,
    "---------------------------------------------------------------------------------------------------------------------------\n");
}
else if (nd_summary == 'N')
{
    fprintf(fp,
    "\fMDL : BL                                         %-30s                                        %-15s\n",
    hosp_name.arr,date_time.arr);
    fprintf(fp,"OPR : %-10s \n", user_id.arr);
    fprintf(fp,
    "REP : %-8s                              %-45s                                 PAGE : %4d\n",
    CHARGE_DETAILS?"BLRNOSRV":"BLRNOSRQ",
    CHARGE_DETAILS?"BILLING SERVICES BY DATE WITH CHARGE DETAILS":
    "        BILLING SERVICES BY DATE",
    ++pctr);

    fprintf(fp,
    "-------------------------------------------------------------------------------------------------------------------------------------\n");
    if CHARGE_DETAILS
    fprintf(fp,
    "BLNG SERV & DESCRIPTION                         SERVICE DT              NO.        GROSS CHG.          DISC AMT          NET CHG.\n");
    else
    fprintf(fp,
    "BLNG SERV & DESCRIPTION                         SERVICE DT             NO.\n");
    fprintf(fp,
    "-------------------------------------------------------------------------------------------------------------------------------------\n");
}
else if (nd_summary == 'B')
{

/*-- SCF 83 VSK 18/04/1999 Print header */

    fprintf(fp,
    "\fMDL : BL                                         %-30s                                      %-15s\n",
    hosp_name.arr,date_time.arr);
    fprintf(fp,"OPR : %-10s \n", user_id.arr);
    
	if (CHARGE_DETAILS)
	{
		fprintf(fp,
		"REP : %-8s                           %-45s                                    PAGE : %4d\n",
		"BLRNOSRV", "      BILLING SERVICE SUMMARY WITH CHARGE DETAILS",  ++pctr);
		fprintf(fp,
		"-------------------------------------------------------------------------------------------------------------------------------------\n");
		fprintf(fp,
		"BLNG SERV & DESCRIPTION                            NO.OF TRANS.       SERV.QTY.        GROSS CHG.          DISC AMT          NET CHG.\n");
	}
    else
	{
		fprintf(fp,
		"REP : %-8s                           %-45s                                    PAGE : %4d\n",
		"BLRNOSRV", "      BILLING SERVICE SUMMARY ",  ++pctr);
		fprintf(fp,
		"-------------------------------------------------------------------------------------------------------------------------------------\n");
		fprintf(fp,
		"BLNG SERV & DESCRIPTION                            NO.OF TRANS.          SERV.QTY.\n");
	}
    fprintf(fp,
    "-------------------------------------------------------------------------------------------------------------------------------------\n");
}

fflush(fp);
lctr = 7;
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;
    /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, :date_time, :user_id
               FROM SY_ACC_ENTITY
			   WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 15;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )455;
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
    sqlstm.sqhstl[2] = (unsigned int  )43;
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
}
/*
print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (loc_amount >= 0)
   {
      sprintf(out_str,"%15.2f",loc_amount);
      ltrim(out_str);l_put_comma(out_str);
      sprintf(out_str1,"%15s",out_str);
      fprintf(fp,"%-15s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%15.2f",-loc_amount);
      ltrim(out_str);l_put_comma(out_str);
      sprintf(out_str1,"%15s",out_str);
      fprintf(fp,"%-15s-",out_str1);
   }
}
*/

print_formated(loc_amount,fp)
double loc_amount;
FILE *fp;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
        ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt,"-");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);
                ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt," ");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%-14s ",str_amt);
        }
}

print_formated2(loc_amount)
double loc_amount;
{
   char out_str[10],out_str1[10];

   if (loc_amount >= 0)
   {
      sprintf(out_str,"%7.2f",loc_amount);
      ltrim(out_str);l_put_comma(out_str);
      sprintf(out_str1,"%10s",out_str);
      fprintf(fp,"%-10s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%7.2f",-loc_amount);
      ltrim(out_str);l_put_comma(out_str);
      sprintf(out_str1,"%10s",out_str);
      fprintf(fp,"%-10s-",out_str1);
   }
}


print_formated1(loc_amount)
long loc_amount;
{
   char out_str[30],out_str1[30];

   if (loc_amount >= 0)
   {
      sprintf(out_str,"%15ld",loc_amount);
      strcat(out_str,".00");
      ltrim(out_str);put_comma1(out_str);
      sprintf(out_str1,"%15s",out_str);
      fprintf(fp,"%-15s ",out_str1);
   }
}

l_put_comma(str)
char *str;
{
  int i,l,m,a,b,c;
  float j,k;
  char arr[120],o_arr[120],l_str1[10],minus[2];
  strcpy(minus,"");
  if (str[0] == '-')
  {
     str[0] = ' ';
     strcpy(minus,"-");
  }
  ltrim(str); 
  strcpy(arr,str);
  strncpy(l_str1,arr + (strlen(arr) - 2),2);
  l_str1[2] = '\0';
  arr[strlen(str)-3] = '\0';
  i = strlen(arr);
  j = i;
  k = j/3;
  l = k;
  m = i - (l*3);
  if (i > 3)
  {
      for (a=0;a<m;a++)
         o_arr[a] = arr[a];
   if (m)
   {
     o_arr[m] = ','; b=m+1;
   }
   else b = m;
  for (c=1,a=m;arr[a]!= '\0';a++,b++)
  {
     o_arr[b] = arr[a]; 
     c++;
     if (c > 3 && arr[a+1] != '\0')
     {
       o_arr[++b] = ','; c = 1;
     }
   }
   o_arr[b] = '\0';
  }
  else
      strcpy(o_arr,arr);
  sprintf(str,"%s%s.%s",minus,o_arr,l_str1);
}

put_comma1(str)
char *str;
{
  int i,l,m,a,b,c;
  float j,k;
  char arr[120],o_arr[120],l_str1[10],minus[2];
  strcpy(minus,"");
  if (str[0] == '-')
  {
     str[0] = ' ';
     strcpy(minus,"-");
  }
  ltrim(str); 
  strcpy(arr,str);
  strncpy(l_str1,arr + (strlen(arr) - 2),2);
  l_str1[2] = '\0';
  arr[strlen(str)-3] = '\0';
  i = strlen(arr);
  j = i;
  k = j/3;
  l = k;
  m = i - (l*3);
  if (i > 3)
  {
      for (a=0;a<m;a++)
         o_arr[a] = arr[a];
   if (m)
   {
     o_arr[m] = ','; b=m+1;
   }
   else b = m;
  for (c=1,a=m;arr[a]!= '\0';a++,b++)
  {
     o_arr[b] = arr[a]; 
     c++;
     if (c > 3 && arr[a+1] != '\0')
     {
       o_arr[++b] = ','; c = 1;
     }
   }
   o_arr[b] = '\0';
  }
  else
      strcpy(o_arr,arr);
  sprintf(str,"%s%s",minus,o_arr);
}

page_break(skip)
int skip;
{
   lctr+= skip;
   if  (lctr > MAX_LINES)
      print_head();
}

ltrim(l_str)
char *l_str;
{
   char *ptr;
   ptr = l_str;
   while (*ptr== ' ') ptr++;
   for(;*ptr!='\0';ptr++,l_str++)
    *l_str = *ptr;
   *l_str = '\0';
}

rtrim(l_str)
char *l_str;
{
  while (*l_str != '\0') *l_str++;
  l_str--;
  while (*l_str == ' ') *l_str--;
  *(l_str+1) = '\0';
}


