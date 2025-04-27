
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
           char  filnam[39];
};
static const struct sqlcxp sqlfpn =
{
    38,
    "C:\\gana\\MLVER2\\PROC\\Raised\\Blripdad.pc"
};


static unsigned long sqlctx = 806864181;


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
            void  *sqhstv[19];
   unsigned int   sqhstl[19];
            int   sqhsts[19];
            void  *sqindv[19];
            int   sqinds[19];
   unsigned int   sqharm[19];
   unsigned int   *sqharc[19];
   unsigned short  sqadto[19];
   unsigned short  sqtdso[19];
} sqlstm = {10,19};

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

 static const char *sq0007 = 
"select TRX_DOC_REF ,TRX_DOC_REF_LINE_NUM ,TRX_DOC_REF_SEQ_NUM ,SERV_QTY ,BAS\
E_CHARGE_AMT ,UPD_GROSS_CHARGE_AMT ,UPD_DISC_AMT ,UPD_NET_CHARGE_AMT ,PACKAGE_\
IND ,PACKAGE_TRX_IND ,BLNG_GRP_ID ,BLNG_SERV_CODE ,RATE_CHARGE_FLAG ,NVL(DF_SE\
RVICE_IND,'Z') ,TO_CHAR(SERVICE_DATE,'DD/MM/YYYY HH24:MI') ,PRT_GRP_HDR_CODE ,\
PRT_GRP_LINE_CODE ,PACKAGE_SERVICE_CODE ,TO_CHAR(TRX_DATE,'DD/MM/YYYY')  from \
BL_PATIENT_CHARGES_FOLIO where (((((EPISODE_TYPE in ('I','D') and EPISODE_ID=:\
b0) and PATIENT_ID=:b1) and NVL(TRX_FINALIZE_IND,'N')='Y') and TRX_STATUS is n\
ull ) and NVL(operating_facility_id,'X')=NVL(:b2,'X')) order by TRX_DOC_REF,TR\
X_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,126,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,155,0,0,0,0,0,1,0,
51,0,0,3,150,0,4,171,0,0,7,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
94,0,0,4,84,0,2,190,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
121,0,0,5,98,0,4,208,0,0,3,1,0,1,0,2,1,0,0,2,9,0,0,1,9,0,0,
148,0,0,6,69,0,4,223,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
171,0,0,7,0,0,13,307,0,0,19,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,
4,0,0,2,4,0,0,2,4,0,0,2,1,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,1,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
262,0,0,7,672,0,9,355,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
289,0,0,8,128,0,4,537,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
320,0,0,9,140,0,4,561,0,0,5,4,0,1,0,2,4,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,
355,0,0,10,69,0,4,624,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
378,0,0,11,69,0,4,636,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
};


/*
  #define DEBUG
*/
  
#include <stdio.h>
#include <math.h>
#include <string.h>  
#include "gl.h"
#include "bl.h"
                                        
/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd[41],
	    d_session_id[16],
	    d_pgm_date[14],
            rep_date[20],
            comp_name[50],
            oper_id[21],
			d_facility_id [10],
            d_curr_pgm_name[15]; */ 
struct { unsigned short len; unsigned char arr[41]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[10]; } d_facility_id;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;


    /* VARCHAR nd_episode_id      [9],
	    nd_patient_id      [21],
	    nd_blng_grp_id     [3],

	    d_patient_name            [61],
	    d_trx_doc_ref             [21],
	    d_trx_doc_ref_line_num    [6],
	    d_trx_doc_ref_seq_num     [6],
	    d_blng_grp_id             [3],
	    d_blng_grp_desc           [31],     
	    d_blng_serv_code          [11],
	    d_serv_date               [17],
            d_prt_grp_hdr_code        [3],
            d_prt_grp_line_code       [3],
	    d_package_service_code    [11],
	    d_pkg_serv_code           [11],
	    d_trx_date                [11],
	    d_pkg_serv_desc           [41]; */ 
struct { unsigned short len; unsigned char arr[9]; } nd_episode_id;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[3]; } nd_blng_grp_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[21]; } d_trx_doc_ref;

struct { unsigned short len; unsigned char arr[6]; } d_trx_doc_ref_line_num;

struct { unsigned short len; unsigned char arr[6]; } d_trx_doc_ref_seq_num;

struct { unsigned short len; unsigned char arr[3]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[31]; } d_blng_grp_desc;

struct { unsigned short len; unsigned char arr[11]; } d_blng_serv_code;

struct { unsigned short len; unsigned char arr[17]; } d_serv_date;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[11]; } d_package_service_code;

struct { unsigned short len; unsigned char arr[11]; } d_pkg_serv_code;

struct { unsigned short len; unsigned char arr[11]; } d_trx_date;

struct { unsigned short len; unsigned char arr[41]; } d_pkg_serv_desc;


    double  d_serv_qty,
	    d_base_charge_amt,
	    d_upd_gross_charge_amt,
	    d_upd_disc_amt,
	    d_upd_net_charge_amt,
	    d_ip_disc_perc;

    char    d_package_ind,
	    d_package_trx_ind,
	    d_rate_charge_flag,
	    d_df_service_ind,
	    d_disc_app_yn;

    int     d_flag;

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRIPDAD.C-arc   1.0   Apr 19 2007 17:06:28   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLRIPDAD.C-arc   1.0   Apr 19 2007 17:06:28   vcm_th  $ sqlda.h 
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

#define REP_WIDTH 169
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1];

double mtot_service_gross = 0,
       mtot_service_disc  = 0,
       mtot_service_net   = 0,
       mdisc_amt          = 0,
       mnet_amt           = 0,
       g_tot_gross        = 0,
       g_tot_disc         = 0,
       g_tot_net          = 0;

char rep_title[] = "ADJUSTMENTS DUE TO CHANGE IN BILLING GROUP";

FILE *f1;

int page_no,
    line_no,
    first_line,
    g_count;

char filename[150];

char p_trx_doc_ref[21],
     p_trx_doc_ref_line_num[6],
     p_package_ind,
     p_blng_grp_id[7], 
     p_blng_serv_code[11],
     p_serv_date[17],
     p_prt_grp_hdr_code[3],
     p_prt_grp_line_code[3],
     p_package_service_code[11],
     p_trx_date[11];

double p_serv_qty;

void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc < 5) {
        disp_message(ERR_MESG,"BLRIPDAD : Usage BLRIPDAD userid/password session_id pgm_date facility_id");
        proc_exit();
    }

    strcpy(g_pgm_id,"BLRIPDAD");

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

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
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	set_meduser_role();

    if(OERROR) {
        disp_message(ORA_MESG,"Unable to connect to oracle.");
        proc_exit();
    }

    fetch_prog_param();
    fetch_sys_info();

    strcpy(filename,WORKING_DIR);
    strcat(filename,"blripdad.lis");

    if( (f1=fopen(filename,"w")) == NULL) {
        disp_message(ERR_MESG,"Error in opening output file...");
	proc_exit();
    }

    page_no=1;
    line_no=1;

    decl_curs();

    do_report();

    fclose(f1);

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    return;
}

fetch_prog_param()
{

    nd_episode_id.arr[0]   = '\0';
    nd_patient_id.arr[0]   = '\0';
    nd_blng_grp_id.arr[0]  = '\0';

    nd_episode_id.len      = 0;
    nd_patient_id.len      = 0;
    nd_blng_grp_id.len     = 0;

   /* EXEC SQL SELECT PARAM1,
		   PARAM2,
		   PARAM3,
		   operating_facility_id
              INTO :nd_episode_id,
                   :nd_patient_id,
                   :nd_blng_grp_id,
				   :d_facility_id
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :d_session_id
               AND PGM_DATE   = :d_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,operating_facility_id into \
:b0,:b1,:b2,:b3  from SY_PROG_PARAM where ((PGM_ID=:b4 and SESSION_ID=:b5) and\
 PGM_DATE=:b6)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_episode_id;
   sqlstm.sqhstl[0] = (unsigned int  )11;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_blng_grp_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
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
   sqlstm.sqhstv[4] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[4] = (unsigned int  )17;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_session_id;
   sqlstm.sqhstl[5] = (unsigned int  )18;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_pgm_date;
   sqlstm.sqhstl[6] = (unsigned int  )16;
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

   if (NO_DATA_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :d_session_id
               AND PGM_DATE   = :d_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )94;
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
   sqlstm.sqhstv[1] = (         void  *)&d_session_id;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_pgm_date;
   sqlstm.sqhstl[2] = (unsigned int  )16;
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

    nd_episode_id.arr[nd_episode_id.len]    = '\0';
    nd_patient_id.arr[nd_patient_id.len]    = '\0';
    nd_blng_grp_id.arr[nd_blng_grp_id.len]  = '\0';
	d_facility_id.arr[d_facility_id.len]	= '\0';
	strcpy(g_facility_id, d_facility_id.arr);

    d_disc_app_yn = '\0';
    d_blng_grp_desc.arr[0] = '\0';
    d_blng_grp_desc.len    = 0;

    /* EXEC SQL SELECT NVL(SERV_DISC_APPL_IND,'N'),
		    LONG_DESC
	     INTO   :d_disc_app_yn,
		    :d_blng_grp_desc
	     FROM   BL_BLNG_GRP
	     WHERE  BLNG_GRP_ID = :nd_blng_grp_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(SERV_DISC_APPL_IND,'N') ,LONG_DESC into :b0,:b\
1  from BL_BLNG_GRP where BLNG_GRP_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )121;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_disc_app_yn;
    sqlstm.sqhstl[0] = (unsigned int  )1;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_desc;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_blng_grp_id;
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
	err_mesg("SELECT failed on table BL_BLNG_GRP",0,"");

    d_blng_grp_desc.arr[d_blng_grp_desc.len]  = '\0';

    d_patient_name.arr[0]  = '\0';
    d_patient_name.len     = 0;

    /* EXEC SQL SELECT SHORT_NAME
	     INTO   :d_patient_name
	     FROM   MP_PATIENT_MAST
	     WHERE  PATIENT_ID = :nd_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_NAME into :b0  from MP_PATIENT_MAST where PA\
TIENT_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )148;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
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



    if(OERROR)
	err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");
   
    d_patient_name.arr[d_patient_name.len] = '\0';


}


decl_curs()
{

    /* EXEC SQL DECLARE PATIENT_FOLIO_CUR CURSOR FOR
              SELECT TRX_DOC_REF,
		     TRX_DOC_REF_LINE_NUM,
		     TRX_DOC_REF_SEQ_NUM,
                     SERV_QTY,
		     BASE_CHARGE_AMT,
		     UPD_GROSS_CHARGE_AMT,
		     UPD_DISC_AMT,
                     UPD_NET_CHARGE_AMT,
		     PACKAGE_IND,
		     PACKAGE_TRX_IND,
                     BLNG_GRP_ID,
		     BLNG_SERV_CODE,
		     RATE_CHARGE_FLAG,
                     NVL(DF_SERVICE_IND,'Z'),
		     TO_CHAR(SERVICE_DATE,'DD/MM/YYYY HH24:MI'),
                     PRT_GRP_HDR_CODE,
                     PRT_GRP_LINE_CODE,
                     PACKAGE_SERVICE_CODE,
		     TO_CHAR(TRX_DATE,'DD/MM/YYYY')
                FROM BL_PATIENT_CHARGES_FOLIO 
               WHERE EPISODE_TYPE IN ('I','D') 
	         AND EPISODE_ID   = :nd_episode_id
                 AND PATIENT_ID   = :nd_patient_id
                 AND NVL(TRX_FINALIZE_IND,'N') = 'Y'
                 AND TRX_STATUS IS NULL
		 AND NVL(operating_facility_id,'X') = NVL(:d_facility_id,'X')
               ORDER BY TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,
                        TRX_DOC_REF_SEQ_NUM; */ 

}

fetch_folio()
{

    d_trx_doc_ref.arr[0]            = '\0';
    d_trx_doc_ref_line_num.arr[0]   = '\0';
    d_trx_doc_ref_seq_num.arr[0]    = '\0';
    d_blng_grp_id.arr[0]            = '\0';
    d_blng_serv_code.arr[0]         = '\0';
    d_serv_date.arr[0]              = '\0';
    d_prt_grp_hdr_code.arr[0]       = '\0';
    d_prt_grp_line_code.arr[0]      = '\0';
    d_package_service_code.arr[0]   = '\0';
    d_trx_date.arr[0]               = '\0';

    d_trx_doc_ref.len               = 0;
    d_trx_doc_ref_line_num.len      = 0;
    d_trx_doc_ref_seq_num.len       = 0;
    d_blng_grp_id.len               = 0;
    d_blng_serv_code.len            = 0;
    d_serv_date.len                 = 0;
    d_prt_grp_hdr_code.len          = 0;
    d_prt_grp_line_code.len         = 0;
    d_package_service_code.len      = 0;
    d_trx_date.len                  = 0;

    d_serv_qty               = 0;
    d_base_charge_amt        = 0;
    d_upd_gross_charge_amt   = 0;
    d_upd_disc_amt           = 0;
    d_upd_net_charge_amt     = 0;

    d_package_ind            = '\0';
    d_package_trx_ind        = '\0';
    d_rate_charge_flag       = '\0';
    d_df_service_ind         = '\0';

    /* EXEC SQL FETCH PATIENT_FOLIO_CUR 
	     INTO  :d_trx_doc_ref,
		   :d_trx_doc_ref_line_num,
		   :d_trx_doc_ref_seq_num,
                   :d_serv_qty,
		   :d_base_charge_amt,
		   :d_upd_gross_charge_amt,
		   :d_upd_disc_amt,
                   :d_upd_net_charge_amt,
		   :d_package_ind,
		   :d_package_trx_ind,
                   :d_blng_grp_id,
		   :d_blng_serv_code,
		   :d_rate_charge_flag,
                   :d_df_service_ind,
		   :d_serv_date,
                   :d_prt_grp_hdr_code,
                   :d_prt_grp_line_code,
                   :d_package_service_code,
                   :d_trx_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 19;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )171;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_trx_doc_ref;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_trx_doc_ref_line_num;
    sqlstm.sqhstl[1] = (unsigned int  )8;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_trx_doc_ref_seq_num;
    sqlstm.sqhstl[2] = (unsigned int  )8;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_serv_qty;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_base_charge_amt;
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
    sqlstm.sqhstv[7] = (         void  *)&d_upd_net_charge_amt;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_package_ind;
    sqlstm.sqhstl[8] = (unsigned int  )1;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_package_trx_ind;
    sqlstm.sqhstl[9] = (unsigned int  )1;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[10] = (unsigned int  )5;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[11] = (unsigned int  )13;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_rate_charge_flag;
    sqlstm.sqhstl[12] = (unsigned int  )1;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_df_service_ind;
    sqlstm.sqhstl[13] = (unsigned int  )1;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_serv_date;
    sqlstm.sqhstl[14] = (unsigned int  )19;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_prt_grp_hdr_code;
    sqlstm.sqhstl[15] = (unsigned int  )5;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_prt_grp_line_code;
    sqlstm.sqhstl[16] = (unsigned int  )5;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&d_package_service_code;
    sqlstm.sqhstl[17] = (unsigned int  )13;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_trx_date;
    sqlstm.sqhstl[18] = (unsigned int  )13;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
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
	err_mesg("FETCH failed on cursor PATIENT_FOLIO_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_trx_doc_ref.arr[d_trx_doc_ref.len]                    = '\0';
    d_trx_doc_ref_line_num.arr[d_trx_doc_ref_line_num.len]  = '\0';
    d_trx_doc_ref_seq_num.arr[d_trx_doc_ref_seq_num.len]    = '\0';
    d_blng_grp_id.arr[d_blng_grp_id.len]                    = '\0';
    d_blng_serv_code.arr[d_blng_serv_code.len]              = '\0';
    d_serv_date.arr[d_serv_date.len]                        = '\0';
    d_prt_grp_hdr_code.arr[d_prt_grp_hdr_code.len]          = '\0';
    d_prt_grp_line_code.arr[d_prt_grp_line_code.len]        = '\0';
    d_package_service_code.arr[d_package_service_code.len]  = '\0';
    d_trx_date.arr[d_trx_date.len]                          = '\0';

    return 1;
}


do_report()
{
    int first = 1;

    put_hdr();

    /* EXEC SQL OPEN PATIENT_FOLIO_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 19;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )262;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )12;
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
	err_mesg("OPEN failed on cursor PATIENT_FOLIO_CUR",0,"");

    while(fetch_folio()) {

	if(d_package_trx_ind == 'Y') {
	    p_serv_qty = d_serv_qty;
	    continue;
	}

	if(first) {
            strcpy(p_trx_doc_ref, d_trx_doc_ref.arr);
            strcpy(p_trx_doc_ref_line_num, d_trx_doc_ref_line_num.arr);
            p_package_ind = d_package_ind;
	    first = 0;
	}

	if(strcmp(p_trx_doc_ref, d_trx_doc_ref.arr) ||
	   strcmp(p_trx_doc_ref_line_num, d_trx_doc_ref_line_num.arr)) {

	    print_rec();
            mtot_service_gross = 0;
            mtot_service_disc  = 0;
            mtot_service_net   = 0;

            strcpy(p_trx_doc_ref, d_trx_doc_ref.arr);
            strcpy(p_trx_doc_ref_line_num, d_trx_doc_ref_line_num.arr);
            p_package_ind = d_package_ind;
	}

/*
	if(d_package_trx_ind == 'N') {
*/

	if(d_disc_app_yn == 'Y' && d_rate_charge_flag == 'R') {
	       if(!get_serv_disc(1))
	           if(!get_serv_disc(2))
	               if(!get_serv_disc(3))
			   err_mesg("Service Discount not found",1,"");

                mdisc_amt = ceil(d_upd_gross_charge_amt * d_ip_disc_perc / 100);
                mnet_amt  = d_upd_gross_charge_amt - mdisc_amt;
	}
	else {
            mdisc_amt = d_upd_disc_amt;
            mnet_amt  = d_upd_net_charge_amt;
	}

        mtot_service_gross = mtot_service_gross + d_upd_gross_charge_amt;
        mtot_service_disc  = mtot_service_disc  + mdisc_amt;
        mtot_service_net   = mtot_service_net   + mnet_amt;

        strcpy(p_blng_grp_id, d_blng_grp_id.arr);
        strcpy(p_blng_serv_code, d_blng_serv_code.arr);
        strcpy(p_serv_date, d_serv_date.arr);
        strcpy(p_trx_date, d_trx_date.arr);
        strcpy(p_prt_grp_hdr_code, d_prt_grp_hdr_code.arr);
        strcpy(p_prt_grp_line_code, d_prt_grp_line_code.arr);
        strcpy(p_package_service_code, d_package_service_code.arr);

	if(d_package_ind != 'Y')
	    p_serv_qty = d_serv_qty;

    }

    if(!first) {
	 print_rec();
	 print_tot();
	 print_end_of_rep();
    }
}

print_tot()
{
    char s_gross_amt[20],
	 s_disc_amt[20],
	 s_net_amt[20];

    chk_break(3);

    print_formated(s_gross_amt, g_tot_gross);
    print_formated(s_disc_amt , g_tot_disc);
    print_formated(s_net_amt  , g_tot_net);

    fprintf(f1,"%125s-------------- -------------- --------------\n","");
    fprintf(f1,"%125s %14s %14s %14s\n", "",s_gross_amt, s_disc_amt, s_net_amt);
    fprintf(f1,"%125s============== ============== ==============\n","");

    line_no += 3;
}

chk_break(nol)
int nol;
{

	if(line_no+nol >= 55) {
           line_no = 1;
	   g_count = 1;
	   put_hdr();
	}

}

print_end_of_rep()
{
    int col;
    char buff[REP_WIDTH+1];

    memset(buff,' ',REP_WIDTH+1);
    col = (int)(REP_WIDTH-19)/2;

    strcpy(buff+col,"** END OF REPORT **",19);
    fprintf(f1,"\n%s\n",buff);
}

put_hdr()
{

    form_hdr();
    fprintf(f1,"BLNG PKG/ SERVICE                                          PRT GRP/                                                                   GROSS       DISCOUNT            NET\n");
    fprintf(f1,"GRP  SRV  CODE    DESCRIPTION                              PRT LINE TRX REFERENCE        TRX DATE   SERVICE DATE/TIME  QTY           AMOUNT         AMOUNT         AMOUNT\n");

/*
		xx    x   xxxxxx  xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxxx     xxxxxxxxxxxxxxxxxxxx dd/mm/yyyy dd/mm/yyyy hh24:mi 99.99 999,999,990.99 999,999,990.99 999,999,990.99
*/

    fprintf(f1,"%s\n",hdr_line4);
    fprintf(f1,"ADMISSION NUMBER : %s %s\n",nd_episode_id.arr, d_patient_name.arr);
    fprintf(f1,"BILLING GROUP    : %s %s\n", nd_blng_grp_id.arr, d_blng_grp_desc.arr);
    fprintf(f1,"\n");
    line_no=11;

}

form_hdr()
{

    static int first = 1;
    char buf[15];
    int col;

    if(first) {
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
	memset(hdr_line4,'-',REP_WIDTH);
	hdr_line4[REP_WIDTH] = '\0';

        strncpy(hdr_line1,"MDL : BL",8);
        col = (int)(REP_WIDTH-strlen(comp_name.arr))/2;
        strncpy(hdr_line1+col,comp_name.arr,strlen(comp_name.arr));
        col = (REP_WIDTH-strlen(rep_date.arr));
        strcpy(hdr_line1+col,rep_date.arr);
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,oper_id.arr);

    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : BLRIPDAD",14);
    col = (int)(REP_WIDTH-strlen(rep_title))/2;
    strncpy(hdr_line3+col,rep_title,strlen(rep_title));
    sprintf(buf,"PAGE : %4d",page_no++);
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);

    if(first)
        fprintf(f1,"%s\n",hdr_line1);
    else
        fprintf(f1,"\f%s\n",hdr_line1);
    fprintf(f1,"%s\n",hdr_line2);
    fprintf(f1,"%s\n",hdr_line3);
    fprintf(f1,"%s\n",hdr_line4);

    first = 0;
}            

fetch_sys_info()
{    

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
		    TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
	     INTO   :comp_name,
		    :rep_date,
		    :oper_id
	     FROM   SY_ACC_ENTITY
		WHERE   acc_entity_id =  :d_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 19;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )289;
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
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';
}

get_serv_disc(flag)
int flag;
{
    d_flag = flag;
    d_ip_disc_perc = 0;


    /* EXEC SQL SELECT IP_DISC_PERC
               INTO :d_ip_disc_perc
               FROM BL_BLNG_SERV_FOR_GRP
              WHERE BLNG_GRP_ID       = :nd_blng_grp_id
                AND BLNG_SERV_CODE    = DECODE(:d_flag,1,:d_blng_serv_code,
					2,SUBSTR(:d_blng_serv_code,1,2),'ALL'); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 19;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select IP_DISC_PERC into :b0  from BL_BLNG_SERV_FOR_GRP w\
here (BLNG_GRP_ID=:b1 and BLNG_SERV_CODE=DECODE(:b2,1,:b3,2,SUBSTR(:b3,1,2),'A\
LL'))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )320;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ip_disc_perc;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_blng_grp_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_flag;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
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
	err_mesg("SELECT failed on table BL_BLNG_SERV_FOR_GRP",0,"");

    if(NO_DATA_FOUND)
	return 0;

    return 1;
}

print_rec()
{
    char s_gross_amt[20],
	 s_disc_amt[20],
	 s_net_amt[20];

    chk_break(1);
    get_pkg_serv_desc();

    fprintf(f1,"%-2s    %c   %-10s  %-40s %-2s%-2s     %-20s %-10s %-16s %5.2lf    ",
     p_blng_grp_id,
     p_package_ind,
     (p_package_ind == 'P')? p_package_service_code:p_blng_serv_code,
     d_pkg_serv_desc.arr,
     p_prt_grp_hdr_code,
     p_prt_grp_line_code,
     p_trx_doc_ref,
     p_trx_date,
     p_serv_date,
     p_serv_qty);


     print_formated(s_gross_amt, mtot_service_gross);
     print_formated(s_disc_amt , mtot_service_disc);
     print_formated(s_net_amt  , mtot_service_net);

     g_tot_gross += mtot_service_gross;
     g_tot_disc  += mtot_service_disc;
     g_tot_net   += mtot_service_net;

     fprintf(f1,"%14s %14s %14s\n", s_gross_amt, s_disc_amt, s_net_amt);

     line_no ++;
}

get_pkg_serv_desc()
{

    d_pkg_serv_desc.arr[0] = '\0';
    d_pkg_serv_desc.len    = 0;

    if(p_package_ind == 'P')
	{

	strcpy(d_pkg_serv_code.arr, p_package_service_code);
        d_pkg_serv_code.len = strlen(d_pkg_serv_code.arr);

	/* EXEC SQL SELECT LONG_DESC 
		   INTO :d_pkg_serv_desc
		   FROM BL_PACKAGE_HDR
		  WHERE PACKAGE_CODE = :d_pkg_serv_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_DESC into :b0  from BL_PACKAGE_HDR where PACKAGE\
_CODE=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )355;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_pkg_serv_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_pkg_serv_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
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
	    err_mesg("SELECT failed on table BL_PACKAGE_HDR",0,"");
    }
    else {
	strcpy(d_pkg_serv_code.arr, p_blng_serv_code);
        d_pkg_serv_code.len = strlen(d_pkg_serv_code.arr);

	/* EXEC SQL SELECT LONG_DESC 
		   INTO :d_pkg_serv_desc
		   FROM BL_BLNG_SERV
		  WHERE BLNG_SERV_CODE = :d_pkg_serv_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_DESC into :b0  from BL_BLNG_SERV where BLNG_SERV\
_CODE=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )378;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_pkg_serv_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_pkg_serv_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
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
	    err_mesg("SELECT failed on table BL_BLNG_SERV",0,"");
    }
                       
    d_pkg_serv_desc.arr[d_pkg_serv_desc.len] = '\0';
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
