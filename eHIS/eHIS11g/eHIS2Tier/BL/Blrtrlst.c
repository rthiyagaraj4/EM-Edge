
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blrtrlst.pc"
};


static unsigned int sqlctx = 1288469355;


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
            void  *sqhstv[30];
   unsigned int   sqhstl[30];
            int   sqhsts[30];
            void  *sqindv[30];
            int   sqinds[30];
   unsigned int   sqharm[30];
   unsigned int   *sqharc[30];
   unsigned short  sqadto[30];
   unsigned short  sqtdso[30];
} sqlstm = {12,30};

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
":b4,'~~~~~~~~~~~~~~~~~~~~')) and NVL(confirmed_yn,'N')=decode(:b5,'C','Y','I\
','N','B',NVL(confirmed_yn,'N'))) and NVL(operating_facility_id,'X')=NVL(:b6,'\
X')) and ((((((NVL(:b7,'O')='B' and FOLIO_REMARKS in ('BED CHARGES','ROUNDING \
FEE','STD CONSUMABLES','BED CHARGES AT DISCHARGE','ROUNDING FEE AT DISCHARGE',\
'STD CONSUMABLES AT DISCHARGE')) or (NVL(:b7,'O')='O' and EPISODE_TYPE='O')) o\
r (NVL(:b7,'O')='I' and EPISODE_TYPE='I')) or (NVL(:b7,'O')='A' and 1=1)) or (\
NVL(:b7,'O')='E' and EPISODE_TYPE='E')) or (NVL(:b7,'O')='D' and EPISODE_TYPE=\
'D'))) and TRX_FINALIZE_IND='Y') order by TRX_DOC_REF,TRX_DOC_REF_LINE_NUM    \
        ";

 static const char *sq0006 = 
"select decode(:b0,'en',substr(short_name,1,30),substr(SHORT_NAME_LOC_LANG,1,\
30)) ,null   from MP_PATIENT_MAST where PATIENT_ID=:b1           ";

 static const char *sq0007 = 
"select LONG_DESC  from BL_BLNG_GRP_LANG_VW where (BLNG_GRP_ID=:b0 and langua\
ge_id=:b1)           ";

 static const char *sq0010 = 
"select SHORT_DESC  from BL_BLNG_CLASS_lang_vw where (BLNG_CLASS_CODE=:b0 and\
 language_id=:b1)           ";

 static const char *sq0008 = 
"select SHORT_DESC  from BL_PACKAGE_HDR where PACKAGE_CODE=:b0           ";

 static const char *sq0009 = 
"select SHORT_DESC  from BL_BLNG_SERV_lang_vw where (BLNG_SERV_CODE=:b0 and l\
anguage_id=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,159,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,220,0,0,0,0,0,1,0,
51,0,0,3,212,0,4,245,0,0,12,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
114,0,0,4,84,0,2,279,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
141,0,0,5,1654,0,9,419,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
208,0,0,5,0,0,13,484,0,0,30,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,
0,2,1,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
343,0,0,6,141,0,9,550,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
366,0,0,6,0,0,13,563,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
389,0,0,11,515,0,6,577,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
416,0,0,7,97,0,9,607,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
439,0,0,7,0,0,13,615,0,0,1,0,0,1,0,2,9,0,0,
458,0,0,10,104,0,9,623,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
481,0,0,10,0,0,13,631,0,0,1,0,0,1,0,2,9,0,0,
500,0,0,8,72,0,9,647,0,0,1,1,0,1,0,1,9,0,0,
519,0,0,8,0,0,13,653,0,0,1,0,0,1,0,2,9,0,0,
538,0,0,9,102,0,9,661,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
561,0,0,9,0,0,13,666,0,0,1,0,0,1,0,2,9,0,0,
580,0,0,12,158,0,4,1023,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
615,0,0,13,140,0,6,1064,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
642,0,0,14,96,0,4,1121,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
665,0,0,15,165,0,6,1128,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRTRLST.PC                                     */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 23-AUG-1993                                  */
/* DATE MODIFIED		 : VSK -- FOR BLENH PURPOSE 18/12/2000          */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                        */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
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
/*
#define DEBUG 0
*/
  

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
	    date_time                                  [20],
	    user_id                                    [40],
		nd_pwd									   [100],
	    nd_session_id                              [16],
	    nd_pgm_date                                [25],
	    d_curr_pgm_name                            [15],
	    nd_fm_date                                 [12],
	    nd_to_date                                 [12],
	    nd_serv_ind                                [2],
	    nd_fm_date_prn                             [12],
	    nd_to_date_prn                             [12],
        d_short_name_full                         [61],
	    bl_patient_name_loc_lang                   [61],
	    bl_patient_name                            [61],
		bl_patient_name1                           [61],
	    bl_blng_long_desc                          [31],
	    bl_pkg_long_desc                           [41],
	    bl_blng_class_desc                         [16],
		date_convert							   [21],
		nd_temp_date                               [21],
		nd_loc_date									[21],
		l_fm_patient_id								[21],
		l_to_patient_id								[21],
		p_language_id								[3],
		d_facility_id								[10],
		l_transaction_type							[3],
		l_pk_value		                            [100],
		nd_facility_id                              [3],
		l_translated_value	                        [201],
		l_confirm_yn								[3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[100]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_date;

struct { unsigned short len; unsigned char arr[2]; } nd_serv_ind;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_date_prn;

struct { unsigned short len; unsigned char arr[12]; } nd_to_date_prn;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name1;

struct { unsigned short len; unsigned char arr[31]; } bl_blng_long_desc;

struct { unsigned short len; unsigned char arr[41]; } bl_pkg_long_desc;

struct { unsigned short len; unsigned char arr[16]; } bl_blng_class_desc;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } l_fm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } l_to_patient_id;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[10]; } d_facility_id;

struct { unsigned short len; unsigned char arr[3]; } l_transaction_type;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } l_confirm_yn;


   /* VARCHAR bl_pat_trx_date                             [13],
		bl_pat_trx_doc_ref                          [21],
		bl_pat_patient_id                           [21],
		bl_pat_episode_type                         [2],
		bl_pat_episode_id                           [9],
		bl_pat_visit_id                             [5],
		bl_pat_blng_grp_id                          [3],
		bl_pat_blng_class_code                      [3],
		bl_pat_trx_doc_ref_line_num                 [5],
		bl_pat_trx_doc_ref_seq_num                  [5],
		bl_pat_package_ind                          [2],
		bl_pat_package_service_code                 [11],
		bl_pat_serv_qty                             [23],
		bl_pat_base_charge_amt                      [23],
		bl_pat_upd_gross_charge_amt                 [23],
		bl_pat_upd_disc_amt                         [23],
		bl_pat_upd_net_charge_amt                   [23],
		bl_pat_service_date                         [21],
		bl_pat_serv_item_code                       [21],
		bl_pat_serv_item_desc                       [41],
		bl_pat_physician_id                         [16],
		bl_pat_canadj_reason_text                   [51]; */ 
struct { unsigned short len; unsigned char arr[13]; } bl_pat_trx_date;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_trx_doc_ref;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_patient_id;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_episode_type;

struct { unsigned short len; unsigned char arr[9]; } bl_pat_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_visit_id;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_blng_class_code;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_trx_doc_ref_line_num;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_trx_doc_ref_seq_num;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_package_ind;

struct { unsigned short len; unsigned char arr[11]; } bl_pat_package_service_code;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_serv_qty;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_base_charge_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_upd_gross_charge_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_upd_disc_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_upd_net_charge_amt;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_service_date;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_serv_item_code;

struct { unsigned short len; unsigned char arr[41]; } bl_pat_serv_item_desc;

struct { unsigned short len; unsigned char arr[16]; } bl_pat_physician_id;

struct { unsigned short len; unsigned char arr[51]; } bl_pat_canadj_reason_text;


 char   bl_pat_trx_status,
		bl_pat_rev_adj_trx_ind;   

 double bl_pat_base_charge_amt_db,
		bl_pat_gross_charge_amt_db,
		bl_pat_disc_amt_db,
		bl_pat_net_charge_amt_db,

		bl_ref_tot_base_charge_amt,
		bl_ref_tot_gross_charge_amt,
		bl_ref_tot_disc_amt,
		bl_ref_tot_net_charge_amt,

		bl_grn_tot_base_charge_amt,
		bl_grn_tot_gross_charge_amt,
		bl_grn_tot_disc_amt,
		bl_grn_tot_net_charge_amt;

/* VARCHAR m_ins_pat_ind[20]; */ 
struct { unsigned short len; unsigned char arr[20]; } m_ins_pat_ind;


char	l_mesg[200];
char loc_legend[999][201];
char x_msg[200];

  int i;	
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

char   store_doc_ref              [21];
char   store_line_num             [21];

FILE *fp;

int rec_ctr = 0,dtl_ctr = 0;
int dtl_head = 0;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    
    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
       proc_exit();
    }
 
    strcpy(g_pgm_id,"BLRTRLST");

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
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )102;
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
    p_language_id.len = l_language_id.len;

    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

    start_prog_msg();

    fetch_prog_param();
	fetch_legend_value();
    declare_cur();
    fetch_hosp_name();
    open_file();
     
    open_cur();
	

    while(fetch_cur())
    {

       if (rec_ctr == 0)
       {
		  strcpy(store_line_num,bl_pat_trx_doc_ref_line_num.arr);
		  strcpy(store_doc_ref,bl_pat_trx_doc_ref.arr);
		  print_rec(0);
	      //print_rec(1);
       }
       if (strcmp(store_doc_ref,bl_pat_trx_doc_ref.arr))
       {
			print_doc_tot();
			print_rec(0);
			store_line_num[0] = '\0';
			strcpy(store_doc_ref,bl_pat_trx_doc_ref.arr);
       }
       print_rec(1);
       rec_ctr++;
     
	 }
     
	 if (rec_ctr)
		print_grand_tot();

    end_of_rep();
    end_prog_msg();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
	 err_mesg("COMMIT WORK RELEASE failed",0,"");

    return;
}

fetch_prog_param()
{
    nd_fm_date.arr[0]           = '\0';
    nd_to_date.arr[0]           = '\0';
    nd_serv_ind.arr[0]          = '\0';
    nd_fm_date_prn.arr[0]           = '\0';
    nd_to_date_prn.arr[0]           = '\0';

    nd_fm_date.len              = 0;
    nd_to_date.len              = 0;
    nd_serv_ind.len             = 0;
    nd_fm_date_prn.len              = 0;
    nd_to_date_prn.len              = 0;

/*-- Y2K correction. Format introduced for 'FROM AND TO' Date prn variable
     as DD/MM/YYYY in form itself. So, no need to format again below also
	 VSK 15/11/1999 */

   /* EXEC SQL SELECT PARAM1,PARAM2,PARAM3,PARAM1,PARAM2,
//		   TO_CHAR(TO_DATE(PARAM1,'DD-MON-YY'),'DD/MM/YYYY'),
//		   TO_CHAR(TO_DATE(PARAM2,'DD-MON-YY'),'DD/MM/YYYY')
			param4, param5, param6, operating_facility_id	
	      INTO :nd_fm_date,
		   :nd_to_date,
		   :nd_serv_ind,
		   :nd_fm_date_prn,
		   :nd_to_date_prn,
		   :l_fm_patient_id,
		   :l_to_patient_id,
		   :l_transaction_type,
		   :d_facility_id
	      FROM SY_PROG_PARAM
	     WHERE PGM_ID     = :d_curr_pgm_name
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM1 ,PARAM2 ,param4 ,par\
am5 ,param6 ,operating_facility_id into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  f\
rom SY_PROG_PARAM where ((PGM_ID=:b9 and SESSION_ID=:b10) and PGM_DATE=:b11)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[0] = (unsigned int  )14;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_serv_ind;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_date_prn;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_date_prn;
   sqlstm.sqhstl[4] = (unsigned int  )14;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_fm_patient_id;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_to_patient_id;
   sqlstm.sqhstl[6] = (unsigned int  )23;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_transaction_type;
   sqlstm.sqhstl[7] = (unsigned int  )5;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[8] = (unsigned int  )12;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[9] = (unsigned int  )17;
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
   sqlstm.sqhstl[11] = (unsigned int  )27;
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

    nd_fm_date.arr[nd_fm_date.len]                = '\0';
    nd_to_date.arr[nd_to_date.len]                = '\0';
    nd_serv_ind.arr[nd_serv_ind.len] = '\0';
    nd_fm_date_prn.arr[nd_fm_date_prn.len]                = '\0';
    nd_to_date_prn.arr[nd_to_date_prn.len]                = '\0';
	d_facility_id.arr[d_facility_id.len]                = '\0';

	strcpy(g_facility_id, d_facility_id.arr);

   /* EXEC SQL DELETE SY_PROG_PARAM
	     WHERE PGM_ID     = :d_curr_pgm_name
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )114;
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
   
}

declare_cur()
{

	/*Y2K correction. Format introduced for 'FROM AND TO' Date 
	as DD/MM/YYYY VSK 15/11/1999 */

     /* EXEC SQL DECLARE BL_PAT_CHG_FOLIO_CUR CURSOR FOR
	   SELECT TO_CHAR(TRUNC(TRX_DATE),'DD/MM/YYYY'),
		      TRX_DOC_REF,
		      PATIENT_ID,
		      EPISODE_TYPE,
		      EPISODE_ID,
		      VISIT_ID,
		      BLNG_GRP_ID,
		      BLNG_CLASS_CODE,
		      TRX_DOC_REF_LINE_NUM,
		      TRX_DOC_REF_SEQ_NUM,
		      PACKAGE_IND,
		      PACKAGE_SERVICE_CODE,
		      TO_CHAR(NVL(SERV_QTY,0),'999,990.99MI'),
		      TO_CHAR(NVL(BASE_CHARGE_AMT,0),'999,999,990.99MI'),
		      TO_CHAR(NVL(UPD_GROSS_CHARGE_AMT,0),'999,999,990.99MI'),
		      TO_CHAR(NVL(UPD_DISC_AMT,0),'999,999,990.99MI'),
		      TO_CHAR(NVL(UPD_NET_CHARGE_AMT,0),'999,999,990.99MI'),
		      TO_CHAR(SERVICE_DATE,'DD/MM/YYYY HH24:MI'),
		      SERV_ITEM_CODE,
			  decode(:p_language_id,'en', substr(SERV_ITEM_DESC,1,30),substr(SERV_ITEM_DESC_OTH_LANG,1,30)),
		      //SERV_ITEM_DESC,
		      PHYSICIAN_ID,
		      NVL(BASE_CHARGE_AMT,0),
		      NVL(UPD_GROSS_CHARGE_AMT,0),
		      NVL(UPD_DISC_AMT,0), 
		      NVL(UPD_NET_CHARGE_AMT,0),
			  TRX_STATUS,
			  REV_ADJ_TRX_IND,
			  CANADJ_REASON_TEXT,
			  INS_PKG_PAT_IND,
			  DECODE(NVL(CONFIRMED_YN,'N'),'Y','C','N','I')
		 FROM BL_PATIENT_CHARGES_FOLIO
		WHERE TRUNC(TRX_DATE) BETWEEN TO_DATE(:nd_fm_date,'DD/MM/YYYY')
						   AND TO_DATE(:nd_to_date,'DD/MM/YYYY')
		  AND patient_id BETWEEN NVL(:l_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!')
		  				     AND NVL(:l_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
		  AND NVL(confirmed_yn,'N') = decode(:l_transaction_type,'C','Y','I','N','B',NVL(confirmed_yn,'N'))
		  AND NVL(operating_facility_id,'X') = NVL(:d_facility_id,'X')
		  AND	(
					(
						NVL(:nd_serv_ind,'O') = 'B' 
						AND 
						FOLIO_REMARKS IN ( 'BED CHARGES','ROUNDING FEE','STD CONSUMABLES',
				 						   'BED CHARGES AT DISCHARGE', 'ROUNDING FEE AT DISCHARGE',
										   'STD CONSUMABLES AT DISCHARGE')					  
					)
					OR
					(
						NVL(:nd_serv_ind,'O') = 'O' 
						AND
						EPISODE_TYPE = 'O'
					)
					OR
					(
						NVL(:nd_serv_ind,'O') = 'I' 
						AND
						EPISODE_TYPE = 'I'
					)
					OR
					(
						NVL(:nd_serv_ind,'O') = 'A'
						AND 
						1=1 
					) 
                                        OR  //EPNH 30/10/2004
					(
						NVL(:nd_serv_ind,'O') = 'E' 
						AND
						EPISODE_TYPE = 'E'
					)
					OR  //EPNH 30/10/2004
					(
						NVL(:nd_serv_ind,'O') = 'D' 
						AND
						EPISODE_TYPE = 'D'
					)

				)
		  AND TRX_FINALIZE_IND = 'Y'
		ORDER 
		   BY TRX_DOC_REF,
			  TRX_DOC_REF_LINE_NUM; */ 


    /* EXEC SQL DECLARE BL_PAT_NAME_CUR CURSOR FOR
	      SELECT 
		  //SUBSTR(SHORT_NAME_LOC_LANG,1,16),
		     /osubstr(SHORT_NAME,1,30),
			   decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname2,
               o/
			     //short_name
				 
			decode(:p_language_id,'en', substr(short_name,1,30),substr(SHORT_NAME_LOC_LANG,1,30)),
			null
		FROM MP_PATIENT_MAST
	       WHERE PATIENT_ID = :bl_pat_patient_id; */ 


    /* EXEC SQL DECLARE BL_BLNG_GRP_CUR CURSOR FOR
	      SELECT LONG_DESC
		FROM BL_BLNG_GRP_LANG_VW
	       WHERE BLNG_GRP_ID = :bl_pat_blng_grp_id
		   AND language_id=:p_language_id; */ 


    /* EXEC SQL DECLARE BL_PACKAGE_HDR_CUR CURSOR FOR
	      SELECT SHORT_DESC
		FROM BL_PACKAGE_HDR
	       WHERE PACKAGE_CODE = :bl_pat_package_service_code; */ 



    /* EXEC SQL DECLARE BL_BLNG_SERV_CUR CURSOR FOR
	      SELECT SHORT_DESC
		FROM BL_BLNG_SERV_lang_vw
	       WHERE BLNG_SERV_CODE = :bl_pat_package_service_code
		   and language_id=:p_language_id; */ 


    /* EXEC SQL DECLARE BL_BLNG_CLASS_CUR CURSOR FOR
	      SELECT SHORT_DESC
		FROM BL_BLNG_CLASS_lang_vw
	       WHERE BLNG_CLASS_CODE = :bl_pat_blng_class_code
		   and language_id=:p_language_id; */ 

}

open_cur()
{
    /* EXEC SQL OPEN BL_PAT_CHG_FOLIO_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select TO_CHAR(TRUNC(TRX_DATE),'DD/MM/YYYY') ,TRX_DOC_REF ,PATIENT_ID\
 ,EPISODE_TYPE ,EPISODE_ID ,VISIT_ID ,BLNG_GRP_ID ,BLNG_CLASS_CODE ,TRX_DOC_\
REF_LINE_NUM ,TRX_DOC_REF_SEQ_NUM ,PACKAGE_IND ,PACKAGE_SERVICE_CODE ,TO_CHA\
R(NVL(SERV_QTY,0),'999,990.99MI') ,TO_CHAR(NVL(BASE_CHARGE_AMT,0),'999,999,9\
90.99MI') ,TO_CHAR(NVL(UPD_GROSS_CHARGE_AMT,0),'999,999,990.99MI') ,TO_CHAR(\
NVL(UPD_DISC_AMT,0),'999,999,990.99MI') ,TO_CHAR(NVL(UPD_NET_CHARGE_AMT,0),'\
999,999,990.99MI') ,TO_CHAR(SERVICE_DATE,'DD/MM/YYYY HH24:MI') ,SERV_ITEM_CO\
DE ,decode(:b0,'en',substr(SERV_ITEM_DESC,1,30),substr(SERV_ITEM_DESC_OTH_LA\
NG,1,30)) ,PHYSICIAN_ID ,NVL(BASE_CHARGE_AMT,0) ,NVL(UPD_GROSS_CHARGE_AMT,0)\
 ,NVL(UPD_DISC_AMT,0) ,NVL(UPD_NET_CHARGE_AMT,0) ,TRX_STATUS ,REV_ADJ_TRX_IN\
D ,CANADJ_REASON_TEXT ,INS_PKG_PAT_IND ,DECODE(NVL(CONFIRMED_YN,'N'),'Y','C'\
,'N','I')  from BL_PATIENT_CHARGES_FOLIO where (((((TRUNC(TRX_DATE) between \
TO_DATE(:b1,'DD/MM/YYYY') and TO_DATE(:b2,'DD/MM/YYYY') and patient_id betwe\
en NVL(:b3,'!!!!!!!!!!!!!!!!!!!!') and NVL(");
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )141;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&p_language_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[1] = (unsigned int  )14;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[2] = (unsigned int  )14;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&l_fm_patient_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&l_to_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&l_transaction_type;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[6] = (unsigned int  )12;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_serv_ind;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_serv_ind;
    sqlstm.sqhstl[8] = (unsigned int  )4;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_serv_ind;
    sqlstm.sqhstl[9] = (unsigned int  )4;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_serv_ind;
    sqlstm.sqhstl[10] = (unsigned int  )4;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_serv_ind;
    sqlstm.sqhstl[11] = (unsigned int  )4;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_serv_ind;
    sqlstm.sqhstl[12] = (unsigned int  )4;
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


    if (OERROR)
	 err_mesg("OPEN failed on cursor BL_PAT_CHG_FOLIO_CUR",0,"");
}

fetch_cur()
{

	m_ins_pat_ind.arr[0] = '\0';
	bl_pat_trx_date.arr[0]                                            = '\0';
	bl_pat_trx_doc_ref.arr[0]                                         = '\0';
	bl_pat_patient_id.arr[0]                                          = '\0';
	bl_pat_episode_type.arr[0]                                        = '\0';
	bl_pat_episode_id.arr[0]                                          = '\0';
	bl_pat_visit_id.arr[0]                                            = '\0';
	bl_pat_blng_grp_id.arr[0]                                         = '\0';
	bl_pat_blng_class_code.arr[0]                                     = '\0';
	bl_pat_trx_doc_ref_line_num.arr[0]                                = '\0';
	bl_pat_trx_doc_ref_seq_num.arr[0]                                 = '\0';
	bl_pat_package_ind.arr[0]                                         = '\0';
	bl_pat_package_service_code.arr[0]                                = '\0';
	bl_pat_serv_qty.arr[0]                                            = '\0';
	bl_pat_base_charge_amt.arr[0]                                     = '\0';
	bl_pat_upd_gross_charge_amt.arr[0]                                = '\0';
	bl_pat_upd_disc_amt.arr[0]                                        = '\0';
	bl_pat_upd_net_charge_amt.arr[0]                                  = '\0';
	bl_pat_service_date.arr[0]                                        = '\0';
	bl_pat_serv_item_code.arr[0]                                      = '\0';
	bl_pat_serv_item_desc.arr[0]                                      = '\0';
	bl_pat_physician_id.arr[0]                                        = '\0';
	bl_pat_canadj_reason_text.arr[0]                                  = '\0';

	bl_pat_trx_status       = '\0';
	bl_pat_rev_adj_trx_ind  = '\0';

	bl_pat_trx_date.len                                               = 0;
	bl_pat_trx_doc_ref.len                                            = 0;
	bl_pat_patient_id.len                                             = 0;
	bl_pat_episode_type.len                                           = 0;
	bl_pat_episode_id.len                                             = 0;
	bl_pat_visit_id.len                                               = 0;
	bl_pat_blng_grp_id.len                                            = 0;
	bl_pat_blng_class_code.len                                        = 0;
	bl_pat_trx_doc_ref_line_num.len                                   = 0;
	bl_pat_trx_doc_ref_seq_num.len                                    = 0;
	bl_pat_package_ind.len                                            = 0;
	bl_pat_package_service_code.len                                   = 0;
	bl_pat_serv_qty.len                                               = 0;
	bl_pat_base_charge_amt.len                                        = 0;
	bl_pat_upd_gross_charge_amt.len                                   = 0;
	bl_pat_upd_disc_amt.len                                           = 0;
	bl_pat_upd_net_charge_amt.len                                     = 0;
	bl_pat_service_date.len                                           = 0;
	bl_pat_serv_item_code.len                                         = 0;
	bl_pat_serv_item_desc.len                                         = 0;
	bl_pat_physician_id.len                                           = 0;
	bl_pat_canadj_reason_text.len                                     = 0;
	m_ins_pat_ind.len = 0;
	bl_pat_base_charge_amt_db                                         = 0;
	bl_pat_gross_charge_amt_db                                        = 0;
	bl_pat_disc_amt_db                                                = 0;
	bl_pat_net_charge_amt_db                                          = 0;



     /* EXEC SQL FETCH BL_PAT_CHG_FOLIO_CUR
	       INTO :bl_pat_trx_date,
		    :bl_pat_trx_doc_ref,
		    :bl_pat_patient_id,
		    :bl_pat_episode_type,
		    :bl_pat_episode_id,
		    :bl_pat_visit_id,
		    :bl_pat_blng_grp_id,
		    :bl_pat_blng_class_code,
		    :bl_pat_trx_doc_ref_line_num,
		    :bl_pat_trx_doc_ref_seq_num,
		    :bl_pat_package_ind,
		    :bl_pat_package_service_code,
		    :bl_pat_serv_qty,
		    :bl_pat_base_charge_amt,
		    :bl_pat_upd_gross_charge_amt,
		    :bl_pat_upd_disc_amt,
		    :bl_pat_upd_net_charge_amt,
		    :bl_pat_service_date,
		    :bl_pat_serv_item_code,
		    :bl_pat_serv_item_desc,
		    :bl_pat_physician_id,
		    :bl_pat_base_charge_amt_db,
		    :bl_pat_gross_charge_amt_db,
		    :bl_pat_disc_amt_db,
		    :bl_pat_net_charge_amt_db,
		    :bl_pat_trx_status,
		    :bl_pat_rev_adj_trx_ind,
		    :bl_pat_canadj_reason_text,
			:m_ins_pat_ind,
			:l_confirm_yn; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 30;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )208;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_trx_date;
     sqlstm.sqhstl[0] = (unsigned int  )15;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_trx_doc_ref;
     sqlstm.sqhstl[1] = (unsigned int  )23;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_patient_id;
     sqlstm.sqhstl[2] = (unsigned int  )23;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_pat_episode_type;
     sqlstm.sqhstl[3] = (unsigned int  )4;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_pat_episode_id;
     sqlstm.sqhstl[4] = (unsigned int  )11;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_pat_visit_id;
     sqlstm.sqhstl[5] = (unsigned int  )7;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_pat_blng_grp_id;
     sqlstm.sqhstl[6] = (unsigned int  )5;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_pat_blng_class_code;
     sqlstm.sqhstl[7] = (unsigned int  )5;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_pat_trx_doc_ref_line_num;
     sqlstm.sqhstl[8] = (unsigned int  )7;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_pat_trx_doc_ref_seq_num;
     sqlstm.sqhstl[9] = (unsigned int  )7;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_pat_package_ind;
     sqlstm.sqhstl[10] = (unsigned int  )4;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_pat_package_service_code;
     sqlstm.sqhstl[11] = (unsigned int  )13;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_pat_serv_qty;
     sqlstm.sqhstl[12] = (unsigned int  )25;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_pat_base_charge_amt;
     sqlstm.sqhstl[13] = (unsigned int  )25;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_pat_upd_gross_charge_amt;
     sqlstm.sqhstl[14] = (unsigned int  )25;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_pat_upd_disc_amt;
     sqlstm.sqhstl[15] = (unsigned int  )25;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_pat_upd_net_charge_amt;
     sqlstm.sqhstl[16] = (unsigned int  )25;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&bl_pat_service_date;
     sqlstm.sqhstl[17] = (unsigned int  )23;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&bl_pat_serv_item_code;
     sqlstm.sqhstl[18] = (unsigned int  )23;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&bl_pat_serv_item_desc;
     sqlstm.sqhstl[19] = (unsigned int  )43;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&bl_pat_physician_id;
     sqlstm.sqhstl[20] = (unsigned int  )18;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&bl_pat_base_charge_amt_db;
     sqlstm.sqhstl[21] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&bl_pat_gross_charge_amt_db;
     sqlstm.sqhstl[22] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&bl_pat_disc_amt_db;
     sqlstm.sqhstl[23] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&bl_pat_net_charge_amt_db;
     sqlstm.sqhstl[24] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqhstv[25] = (         void  *)&bl_pat_trx_status;
     sqlstm.sqhstl[25] = (unsigned int  )1;
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
     sqlstm.sqhstv[26] = (         void  *)&bl_pat_rev_adj_trx_ind;
     sqlstm.sqhstl[26] = (unsigned int  )1;
     sqlstm.sqhsts[26] = (         int  )0;
     sqlstm.sqindv[26] = (         void  *)0;
     sqlstm.sqinds[26] = (         int  )0;
     sqlstm.sqharm[26] = (unsigned int  )0;
     sqlstm.sqadto[26] = (unsigned short )0;
     sqlstm.sqtdso[26] = (unsigned short )0;
     sqlstm.sqhstv[27] = (         void  *)&bl_pat_canadj_reason_text;
     sqlstm.sqhstl[27] = (unsigned int  )53;
     sqlstm.sqhsts[27] = (         int  )0;
     sqlstm.sqindv[27] = (         void  *)0;
     sqlstm.sqinds[27] = (         int  )0;
     sqlstm.sqharm[27] = (unsigned int  )0;
     sqlstm.sqadto[27] = (unsigned short )0;
     sqlstm.sqtdso[27] = (unsigned short )0;
     sqlstm.sqhstv[28] = (         void  *)&m_ins_pat_ind;
     sqlstm.sqhstl[28] = (unsigned int  )22;
     sqlstm.sqhsts[28] = (         int  )0;
     sqlstm.sqindv[28] = (         void  *)0;
     sqlstm.sqinds[28] = (         int  )0;
     sqlstm.sqharm[28] = (unsigned int  )0;
     sqlstm.sqadto[28] = (unsigned short )0;
     sqlstm.sqtdso[28] = (unsigned short )0;
     sqlstm.sqhstv[29] = (         void  *)&l_confirm_yn;
     sqlstm.sqhstl[29] = (unsigned int  )5;
     sqlstm.sqhsts[29] = (         int  )0;
     sqlstm.sqindv[29] = (         void  *)0;
     sqlstm.sqinds[29] = (         int  )0;
     sqlstm.sqharm[29] = (unsigned int  )0;
     sqlstm.sqadto[29] = (unsigned short )0;
     sqlstm.sqtdso[29] = (unsigned short )0;
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
	 err_mesg("FETCH failed on cursor BL_PAT_CHG_FOLIO_CUR",0,"");

	bl_pat_trx_date.arr[bl_pat_trx_date.len]                                 = '\0';
	bl_pat_trx_doc_ref.arr[bl_pat_trx_doc_ref.len]                           = '\0';
	bl_pat_patient_id.arr[bl_pat_patient_id.len]                             = '\0';
	bl_pat_episode_type.arr[bl_pat_episode_type.len]                         = '\0';
	bl_pat_episode_id.arr[bl_pat_episode_id.len]                             = '\0';
	bl_pat_visit_id.arr[bl_pat_visit_id.len]                                 = '\0';
	bl_pat_blng_grp_id.arr[bl_pat_blng_grp_id.len]                           = '\0';
	bl_pat_blng_class_code.arr[bl_pat_blng_class_code.len]                   = '\0';
	bl_pat_trx_doc_ref_line_num.arr[bl_pat_trx_doc_ref_line_num.len]         = '\0';
	bl_pat_trx_doc_ref_seq_num.arr[bl_pat_trx_doc_ref_seq_num.len]           = '\0';
	bl_pat_package_ind.arr[bl_pat_package_ind.len]                           = '\0';
	bl_pat_package_service_code.arr[bl_pat_package_service_code.len]         = '\0';
	bl_pat_serv_qty.arr[bl_pat_serv_qty.len]                                 = '\0';
	bl_pat_base_charge_amt.arr[bl_pat_base_charge_amt.len]                   = '\0';
	bl_pat_upd_gross_charge_amt.arr[bl_pat_upd_gross_charge_amt.len]         = '\0';
	bl_pat_upd_disc_amt.arr[bl_pat_upd_disc_amt.len]                         = '\0';
	bl_pat_upd_net_charge_amt.arr[bl_pat_upd_net_charge_amt.len]             = '\0';
	bl_pat_service_date.arr[bl_pat_service_date.len]                         = '\0';
	bl_pat_serv_item_code.arr[bl_pat_serv_item_code.len]                     = '\0';
	bl_pat_serv_item_desc.arr[bl_pat_serv_item_desc.len]                     = '\0';
	bl_pat_physician_id.arr[bl_pat_physician_id.len]                         = '\0';
	bl_pat_canadj_reason_text.arr[bl_pat_canadj_reason_text.len]             = '\0';
	m_ins_pat_ind.arr[m_ins_pat_ind.len] = '\0';
	l_confirm_yn.arr[l_confirm_yn.len] = '\0';

    return(LAST_ROW?0:1);
}

fetch_dtls()    
{
   /* EXEC SQL OPEN BL_PAT_NAME_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )343;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&p_language_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&bl_pat_patient_id;
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

  

   if (OERROR)
		err_mesg("OPEN failed on cursor BL_PAT_NAME_CUR",0,"");

   bl_patient_name_loc_lang.arr[0]           = '\0';
   bl_patient_name.arr[0]                    = '\0';
   bl_patient_name1.arr[0]                    = '\0';

   bl_patient_name_loc_lang.len              = 0;
   bl_patient_name.len                       = 0;
   bl_patient_name1.len                       = 0;

   /* EXEC SQL FETCH BL_PAT_NAME_CUR
	         INTO :bl_patient_name_loc_lang,
		          /o:bl_patient_name,
				  :bl_patient_name1,o/
                  :d_short_name_full; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )366;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&bl_patient_name_loc_lang;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_short_name_full;
   sqlstm.sqhstl[1] = (unsigned int  )63;
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
		err_mesg("FETCH failed on cursor BL_PAT_NAME_CUR",0,"");

   bl_patient_name_loc_lang.arr[bl_patient_name_loc_lang.len] = '\0';
   bl_patient_name.arr[bl_patient_name.len] = '\0';
   bl_patient_name1.arr[bl_patient_name1.len] = '\0';
   d_short_name_full.arr[d_short_name_full.len]               = '\0';
 
  /* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :bl_patient_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_patient_name1    := :bl_patient_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) \
; BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , st\
r2 ) ; IF str2 IS NOT NULL THEN :bl_patient_name := str2 ; END IF ; blcommon .\
 split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS \
NOT NULL THEN :bl_patient_name1 := str2 ; END IF ; blcommon . split_words ( :d\
_short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :bl\
_patient_name1 := :bl_patient_name1 || str2 ; end if ; END ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )389;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
  sqlstm.sqhstl[0] = (unsigned int  )63;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bl_patient_name;
  sqlstm.sqhstl[1] = (unsigned int  )63;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&bl_patient_name1;
  sqlstm.sqhstl[2] = (unsigned int  )63;
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


       bl_patient_name.arr[bl_patient_name.len]  = '\0';
       bl_patient_name1.arr[bl_patient_name1.len]  = '\0';

   /* EXEC SQL OPEN BL_BLNG_GRP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )416;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_pat_blng_grp_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&p_language_id;
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
		err_mesg("OPEN failed on cursor BL_BLNG_GRP_CUR",0,"");

    bl_blng_long_desc.arr[0]                                          = '\0';
    bl_blng_long_desc.len                                             = 0;

    /* EXEC SQL FETCH BL_BLNG_GRP_CUR
	         INTO :bl_blng_long_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )439;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_blng_long_desc;
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



	if (OERROR)
		err_mesg("FETCH failed on cursor BL_BLNG_GRP_CUR",0,"");

	bl_blng_long_desc.arr[bl_blng_long_desc.len]                       = '\0';

    /* EXEC SQL OPEN BL_BLNG_CLASS_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0010;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )458;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_pat_blng_class_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&p_language_id;
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
		err_mesg("OPEN failed on cursor BL_BLNG_CLASS_CUR",0,"");

    bl_blng_class_desc.arr[0]                                          = '\0';
    bl_blng_class_desc.len                                             = 0;

    /* EXEC SQL FETCH BL_BLNG_CLASS_CUR
	      INTO :bl_blng_class_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )481;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_blng_class_desc;
    sqlstm.sqhstl[0] = (unsigned int  )18;
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
		err_mesg("FETCH failed on cursor BL_BLNG_CLASS_CUR",0,"");

	bl_blng_class_desc.arr[bl_blng_class_desc.len]                       = '\0';
}

fetch_dtls1()
{
    bl_pkg_long_desc.arr[0]     = '\0';
    bl_pkg_long_desc.len		= 0;

    if (bl_pat_package_ind.arr[0] == 'P')
    {
		/* EXEC SQL OPEN BL_PACKAGE_HDR_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0008;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )500;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_pat_package_service_code;
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
			err_mesg("OPEN failed on cursor BL_PACKAGE_HDR_CUR",0,"");
   
	
		/* EXEC SQL FETCH BL_PACKAGE_HDR_CUR
				  INTO :bl_pkg_long_desc; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )519;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&bl_pkg_long_desc;
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
			err_mesg("FETCH failed on cursor BL_PACKAGE_HDR_CUR",0,"");
	}
	else if (bl_pat_package_ind.arr[0] == 'S')
	{
		/* EXEC SQL OPEN BL_BLNG_SERV_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0009;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )538;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_pat_package_service_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&p_language_id;
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
			err_mesg("OPEN failed on cursor BL_BLNG_SERV_CUR",0,"");
   
		/* EXEC SQL FETCH BL_BLNG_SERV_CUR
			     INTO :bl_pkg_long_desc; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )561;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&bl_pkg_long_desc;
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
	}

	bl_pkg_long_desc.arr[bl_pkg_long_desc.len]                      = '\0';
}

print_rec(ind)
int ind;
{

	char s_status;


	if (ind == 0)
	{
		fetch_dtls();
		if (lctr > 51)
			print_head();
	    init_date_temp_var();
		strcpy(date_convert.arr,bl_pat_trx_date.arr);
		if (date_convert.arr[0]!='\0')
		{
		fun_change_loc_date();
		}
 		fprintf(fp,"%-10s %-20s %-20s %-16.16s %-30.30s %1s %8s %4s\n",
		date_convert.arr,
		bl_pat_trx_doc_ref.arr,
		bl_pat_patient_id.arr,
		bl_patient_name_loc_lang.arr,
		bl_patient_name.arr,
		bl_pat_episode_type.arr,
		bl_pat_episode_id.arr,
		bl_pat_visit_id.arr);

		if(strlen(bl_patient_name1.arr) > 2)
	  {
		fprintf(fp,"%69s %s \n"," ",bl_patient_name1.arr);
		lctr++;
	  }


		fprintf(fp,"%4s %-24.24s  %-2s %-15s           %s\n",
		bl_pat_blng_grp_id.arr,
		bl_blng_long_desc.arr,
		bl_pat_blng_class_code.arr,
		bl_blng_class_desc.arr,
		l_confirm_yn.arr);



		lctr+=2;

		
		if(dtl_head)
			print_det_head();
	}
	else
	{
		fetch_dtls1();
		if (lctr > 50)
		{
			print_head();
			print_det_head();
		}
		
		if (strcmp(store_line_num,bl_pat_trx_doc_ref_line_num.arr))
		{
			dtl_ctr = 0;
			strcpy(store_line_num,bl_pat_trx_doc_ref_line_num.arr);
		}
		
		if (dtl_ctr == 0)
		{
			fprintf(fp,"\n");
			lctr++;
		}

		if(bl_pat_rev_adj_trx_ind)
			s_status = bl_pat_rev_adj_trx_ind;
		else
			s_status = bl_pat_trx_status;

     
	        	//fprintf(fp,"%-10s%4s %4s %1s %-10s %-15s  %1s %s ",
					//fprintf(fp,"%-5s%4s %4s %1s %-10s %-15s %1s %s ",
		//fprintf(fp,"%-5s%4s %4s %1s %-10s %-18.18s %1s %s ",
		fprintf(fp,"%-5s%4.4s %4.4s %1s    %-10s%-13.13s %1s  %s ",
	       " ",
	       (dtl_ctr==0)?bl_pat_trx_doc_ref_line_num.arr:" ",
	       bl_pat_trx_doc_ref_seq_num.arr,
	       bl_pat_package_ind.arr,
	       bl_pat_package_service_code.arr,
	       bl_pkg_long_desc.arr,
		   m_ins_pat_ind.arr,
	       bl_pat_serv_qty.arr);
	       print_formated(bl_pat_base_charge_amt_db);
		   fprintf(fp," ");
	       print_formated(bl_pat_gross_charge_amt_db);
		   fprintf(fp," ");
	       print_formated(bl_pat_disc_amt_db);
		   fprintf(fp," ");
	       print_formated(bl_pat_net_charge_amt_db);
	       fprintf(fp,"  %c   %c\n",bl_pat_trx_status, bl_pat_rev_adj_trx_ind);
		//fprintf(fp,"%-10s%-15s%-16s %-6s  %-50s\n"," "," ",bl_pat_service_date.arr,bl_pat_physician_id.arr,bl_pat_canadj_reason_text.arr);
	    init_date_temp_var();
		strcpy(date_convert.arr,bl_pat_service_date.arr);
		if (date_convert.arr[0]!='\0')
		{
		fun_change_loc_date();
		} 
		fprintf(fp,"%-5s%-15s%-16s %-6s  %-50s\n"," "," ",date_convert.arr,bl_pat_physician_id.arr,bl_pat_canadj_reason_text.arr);

		dtl_ctr++;
		if (bl_pat_serv_item_code.len != 0)
		{
			fprintf(fp,"%-10s%-12s%-20s %-40s\n"," "," ",bl_pat_serv_item_code.arr,bl_pat_serv_item_desc.arr);
			lctr++;
		}
		lctr+=2;

		bl_ref_tot_base_charge_amt  += bl_pat_base_charge_amt_db;
		bl_ref_tot_gross_charge_amt += bl_pat_gross_charge_amt_db;
		bl_ref_tot_disc_amt         += bl_pat_disc_amt_db;
		bl_ref_tot_net_charge_amt   += bl_pat_net_charge_amt_db;
	}

	fflush(fp);
}

print_doc_tot()
{
    if (lctr > 52)
       print_head();

    fprintf(fp,"%59s---------------  --------------  --------------  --------------\n"," ");
    fprintf(fp,"%26s%13.13s                    "," ",loc_legend[52]);
    print_formated(bl_ref_tot_base_charge_amt); fprintf(fp," ");
    print_formated(bl_ref_tot_gross_charge_amt); fprintf(fp," ");
    print_formated(bl_ref_tot_disc_amt); fprintf(fp," ");
    print_formated(bl_ref_tot_net_charge_amt);
    fprintf(fp,"\n");
    fprintf(fp,"%59s---------------  --------------  --------------  --------------\n\n"," ");
    lctr +=4;

     bl_grn_tot_base_charge_amt  += bl_ref_tot_base_charge_amt;
     bl_grn_tot_gross_charge_amt += bl_ref_tot_gross_charge_amt;
     bl_grn_tot_disc_amt         += bl_ref_tot_disc_amt;
     bl_grn_tot_net_charge_amt   += bl_ref_tot_net_charge_amt;

     bl_ref_tot_base_charge_amt = 0;
     bl_ref_tot_gross_charge_amt = 0;
     bl_ref_tot_disc_amt = 0;
     bl_ref_tot_net_charge_amt = 0;
}

print_grand_tot()
{
    print_doc_tot();

    if (lctr > 52)
       print_head();

    fprintf(fp,"%59s---------------  --------------  --------------  --------------\n"," ");
    fprintf(fp,"%26s%19.19s              "," ",loc_legend[53]);
    print_formated(bl_grn_tot_base_charge_amt); fprintf(fp," ");
    print_formated(bl_grn_tot_gross_charge_amt); fprintf(fp," ");
    print_formated(bl_grn_tot_disc_amt); fprintf(fp," ");
    print_formated(bl_grn_tot_net_charge_amt);
    fprintf(fp,"\n");
    fprintf(fp,"%59s---------------  --------------  --------------  --------------\n\n"," ");
    lctr +=3;
}

end_of_rep()
{
fprintf(fp,"\n\n                                                      ***%15.15s***\n",loc_legend[54]);
fflush(fp);
}

open_file()
{
char filename[30];
	strcpy(filename,WORKING_DIR);
    strcat(filename,"blrtrlst.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrtrlst.lis");
       proc_exit();
    }
    print_title();
    print_head();
}


/***** Printing of the Title    **********/

print_title()
{
    init_date_temp_var();
	strcpy(date_convert.arr,date_time.arr);
	fun_change_loc_date();
 	fprintf(fp,"\f%-6.6s : %-5s                                         %-30s                                     %-15s\n",loc_legend[02],loc_legend[5],hosp_name.arr,date_convert.arr);
	fprintf(fp,"%-6.6s : %-10s \n",loc_legend[3], user_id.arr);
	fprintf(fp,"%-6.6s : %-10.10s                              %-50.50s                   %8.8s: %4d\n",loc_legend[4],loc_legend[7],loc_legend[8],loc_legend[6],++pctr);
    init_date_temp_var();
	strcpy(date_convert.arr,nd_fm_date_prn.arr);
	fun_change_loc_date();
 	fprintf(fp,"                                             (%5s : %10s ",loc_legend[16],date_convert.arr);
	init_date_temp_var();
	strcpy(date_convert.arr,nd_to_date_prn.arr);
	fun_change_loc_date();
 	fprintf(fp,"  %5.5s : %10s)\n",loc_legend[17],date_convert.arr);

	if (nd_serv_ind.arr[0] == 'A')
		fprintf(fp,"%-20.20s\n",loc_legend[9]);
	else if (nd_serv_ind.arr[0] == 'O')
		fprintf(fp,"%-33.33s\n",loc_legend[10]);
	else if (nd_serv_ind.arr[0] == 'E')
		fprintf(fp,"%-26.26s\n",loc_legend[11]);        
	else if (nd_serv_ind.arr[0] == 'I')
		fprintf(fp,"%-26.26s\n",loc_legend[12]);
        else if (nd_serv_ind.arr[0] == 'D')
		fprintf(fp,"%-26.26s\n",loc_legend[13]);
	else if (nd_serv_ind.arr[0] == 'B')
		fprintf(fp,"%-35.35s\n",loc_legend[14]);
    
	fprintf(fp,"-------------------------------------------------------------------------------------------------------------------------------------\n");
	fprintf(fp,"%6.6s : 4.1\n",loc_legend[55]);
	fflush(fp);

	fprintf(fp,"\n\n\n\n        %-22s :\n        -----------------\n\n",loc_legend[01]);
    init_date_temp_var();
	strcpy(date_convert.arr,nd_fm_date_prn.arr);
	fun_change_loc_date();
 	fprintf(fp,"                  %-10.10s           %-10.10s : %s\n",loc_legend[15],loc_legend[16],date_convert.arr);
	init_date_temp_var();
	strcpy(date_convert.arr,nd_to_date_prn.arr);
	fun_change_loc_date();
 	fprintf(fp,"                                       %-10.10s : %s\n\n",loc_legend[17],date_convert.arr);
	if(l_fm_patient_id.arr[0]=='\0')
	fprintf(fp,"                  %-15.15s      %-10.10s : %-10s\n",loc_legend[18],loc_legend[16],loc_legend[50]);
	else
	fprintf(fp,"                  %-15.15s      %-10.10s : %-20s\n",loc_legend[18],loc_legend[16],l_fm_patient_id.arr);
	if(l_to_patient_id.arr[0]=='\0')
	fprintf(fp,"                                       %-10.10s : %-10s\n\n",loc_legend[17],loc_legend[51]);
	else
		fprintf(fp,"                                       %-10.10s : %-20s\n\n",loc_legend[17],l_to_patient_id.arr);

	fprintf(fp,"                  %-20.20s            : %1s\n",loc_legend[19],l_transaction_type.arr);
	fprintf(fp,"                  (%-15.15s     %-17.17s     %-12.12s)\n\n",loc_legend[21],loc_legend[22],loc_legend[23]);

	if (nd_serv_ind.arr[0] == 'A')
   		fprintf(fp,"                  %-25.25s       : %s\n\n",loc_legend[20],loc_legend[9]);
		//fprintf(fp,"%-20.20s\n",loc_legend[9]);
	else if (nd_serv_ind.arr[0] == 'O')
		//fprintf(fp,"%-33.33s\n",loc_legend[10]);
		   fprintf(fp,"                  %-25.25s       : %s\n\n",loc_legend[20],loc_legend[10]);	 
	else if (nd_serv_ind.arr[0] == 'E')
	     //fprintf(fp,"%-26.26s\n",loc_legend[11]);        
		 		   fprintf(fp,"                  %-25.25s       : %s\n\n",loc_legend[20],loc_legend[11]);	 
	else if (nd_serv_ind.arr[0] == 'I')
		//fprintf(fp,"%-26.26s\n",loc_legend[12]);
		 	   fprintf(fp,"                  %-25.25s       : %s\n\n",loc_legend[20],loc_legend[12]);	 
        else if (nd_serv_ind.arr[0] == 'D')
		//fprintf(fp,"%-26.26s\n",loc_legend[13]);
				  fprintf(fp,"                  %-25.25s       : %s\n\n",loc_legend[20],loc_legend[13]);	 
	else if (nd_serv_ind.arr[0] == 'B')
		//fprintf(fp,"%-35.35s\n",loc_legend[14]);
				  fprintf(fp,"                  %-25.25s       : %s\n\n",loc_legend[20],loc_legend[14]);	 
  

	//fprintf(fp,"                  %-25.25s       : %s\n\n",loc_legend[20],nd_serv_ind.arr);

}

/***** Printing of the Header    **********/    
print_head()
{
	init_date_temp_var();
	strcpy(date_convert.arr,date_time.arr);
	fun_change_loc_date();
 	fprintf(fp,
	"\f%-6.6s : %-5s                                         %-30s                                     %-15s\n",loc_legend[02],loc_legend[05],
	hosp_name.arr,date_convert.arr);
	fprintf(fp,"%-6.6s : %-10s \n",loc_legend[03], user_id.arr);
	fprintf(fp,
	"%-6.6s : %-10.10s                              %-50.50s                   %8.8s: %4d\n",loc_legend[04],loc_legend[07],
	loc_legend[8],loc_legend[06],++pctr);
	init_date_temp_var();
	strcpy(date_convert.arr,nd_fm_date_prn.arr);
	fun_change_loc_date();
 	fprintf(fp,"                                              (%5s : %-10s ",loc_legend[16],date_convert.arr);
	init_date_temp_var();
	strcpy(date_convert.arr,nd_to_date_prn.arr);
	fun_change_loc_date();
 	fprintf(fp,"  %5.5s : %10s)\n",loc_legend[17],date_convert.arr);
	if (nd_serv_ind.arr[0] == 'A')
		fprintf(fp,"%-20.20s\n",loc_legend[9]);
	else if (nd_serv_ind.arr[0] == 'O')
		fprintf(fp,"%-33.33s\n",loc_legend[10]);
	else if (nd_serv_ind.arr[0] == 'E')
		fprintf(fp,"%-26.26s\n",loc_legend[11]);
	else if (nd_serv_ind.arr[0] == 'I')
		fprintf(fp,"%-26.26s\n",loc_legend[12]);
	else if (nd_serv_ind.arr[0] == 'D')
		fprintf(fp,"%-26.26s\n",loc_legend[13]);
	else if (nd_serv_ind.arr[0] == 'B')
		fprintf(fp,"%-35.35s\n",loc_legend[14]);

 /*   fprintf(fp,"TRX DATE   TRX DOC REF          PATIENT NO & NAME                                                 EPISODE DTLS\n");
   	  fprintf(fp,"           BILLING GROUP                   BILLING CLASS   TRN TYPE\n");*/


	
	fprintf(fp,"-------------------------------------------------------------------------------------------------------------------------------------\n");
	fprintf(fp,"%-10.10s %-16.16s     %-35.35s                               %-25.25s\n",loc_legend[24],loc_legend[25],loc_legend[26],loc_legend[27]);
	fprintf(fp,"%-20.20s     %20.20s        %-15.15s\n",loc_legend[28],loc_legend[29],loc_legend[30]);
	fprintf(fp,"-------------------------------------------------------------------------------------------------------------------------------------\n");
	fflush(fp);
	lctr = 11;
	dtl_head = 1;
}

print_det_head()
{
	if (lctr > 52)
		 print_head();
      /*fprintf(fp,"%-10sLINE  SEQ SRV  SERV DESCRIPTION         SERVICE QTY            BASE           GROSS            DISC             NET\n"," ");
        fprintf(fp,"%-10s NUM  NUM IND  SERVICE DATE  DOCTOR  I/P Ind.                   CHG             CHG             AMT             CHG STS ADJ   \n"," ");*/

 fprintf(fp,"%-5s--------------------------------------------------------------------------------------------------------------------------------\n"," ");
 fprintf(fp,"%-5s%4.4s %4.4s %3.3s  %-23.23s %13.13s    %13.13s   %13.13s   %13.13s   %13.13s %4.4s %-6.6s\n"," ",loc_legend[31],loc_legend[33],loc_legend[34],loc_legend[36],loc_legend[37],loc_legend[38],loc_legend[39],loc_legend[40],loc_legend[41],loc_legend[47],loc_legend[48]);
 fprintf(fp,"%-5s%4.4s %4.4s %3.3s  %-13.13s %7.7s %-15.15s      %11.11s     %11.11s    %12.12s   %13.13s\n"," ",loc_legend[32],loc_legend[32],loc_legend[35],loc_legend[42],loc_legend[43],loc_legend[44],loc_legend[45],loc_legend[45],loc_legend[46],loc_legend[45]);
 fprintf(fp,"%-5s               %-40.40s\n"," ",loc_legend[49]);
 fprintf(fp,"%-5s--------------------------------------------------------------------------------------------------------------------------------\n"," ");

	lctr+=3;
	dtl_head = 0;
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

/*-- Y2K correction. Format introduced for year as YYYY instead of YY 
     VSK 15/11/1999 */

    /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
		    USER
	     INTO :hosp_name, :date_time, :user_id
	     FROM SY_ACC_ENTITY_lang_vw
		WHERE acc_entity_id = :d_facility_id
		and language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (acc_entity_id=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )580;
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
    sqlstm.sqhstl[2] = (unsigned int  )42;
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



       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

hosp_name.arr[hosp_name.len]           = '\0';
date_time.arr[date_time.len]           = '\0';
user_id.arr[user_id.len]               = '\0';
}

      
print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount); 
        format_amt(s_amt); 
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%13sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount); 
        format_amt(s_amt); 
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%15s",str_amt);
        }
}


get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	  
	     :nd_loc_date :=sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id);
       	//get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
	   //:nd_loc_date := to_char(t_date,'DD/MM/YYYY');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 30;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )615;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
nd_temp_date.arr[nd_temp_date.len]='\0';

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}


fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRTRLST.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRTRLST.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )642;
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )665;
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