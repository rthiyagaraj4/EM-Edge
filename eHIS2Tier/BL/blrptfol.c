
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
           char  filnam[20];
};
static const struct sqlcxp sqlfpn =
{
    19,
    "C:\\proc\\Blrptfol.pc"
};


static unsigned long sqlctx = 36417707;


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
            void  *sqhstv[34];
   unsigned int   sqhstl[34];
            int   sqhsts[34];
            void  *sqindv[34];
            int   sqinds[34];
   unsigned int   sqharm[34];
   unsigned int   *sqharc[34];
   unsigned short  sqadto[34];
   unsigned short  sqtdso[34];
} sqlstm = {10,34};

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
"PATIENT_ID,PACKAGE_IND,PACKAGE_SERVICE_CODE,TRUNC(TRX_DATE),TRX_DOC_REF,TRX_\
DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM            ";

 static const char *sq0005 = 
"select decode(:b0,'en',substr(short_name,1,30),substr(SHORT_NAME_LOC_LANG,1,\
30)) ,null   from MP_PATIENT_MAST where PATIENT_ID=:b1           ";

 static const char *sq0006 = 
"select LONG_DESC  from BL_BLNG_GRP_lang_vw where (BLNG_GRP_ID=:b0 and langua\
ge_id=:b1)           ";

 static const char *sq0007 = 
"select LOC_LANG_LONG_DESC  from BL_PACKAGE_HDR where PACKAGE_CODE=:b0       \
    ";

 static const char *sq0008 = 
"select LONG_DESC  from BL_BLNG_SERV_lang_vw where (BLNG_SERV_CODE=:b0 and la\
nguage_id=:b1)           ";

 static const char *sq0009 = 
"select SHORT_DESC  from BL_BLNG_CLASS_lang_vw where (BLNG_CLASS_CODE=:b0 and\
 language_id=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,228,0,0,0,0,0,1,0,
20,0,0,2,239,0,4,260,0,0,14,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
91,0,0,3,84,0,2,299,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
118,0,0,4,2172,0,9,492,0,0,22,22,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
221,0,0,4,0,0,13,558,0,0,34,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,
0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
372,0,0,5,141,0,9,633,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
395,0,0,5,0,0,13,645,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
418,0,0,10,515,0,6,659,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
445,0,0,6,97,0,9,690,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
468,0,0,6,0,0,13,697,0,0,1,0,0,1,0,2,9,0,0,
487,0,0,7,80,0,9,716,0,0,1,1,0,1,0,1,9,0,0,
506,0,0,7,0,0,13,720,0,0,1,0,0,1,0,2,9,0,0,
525,0,0,8,101,0,9,728,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
548,0,0,8,0,0,13,732,0,0,1,0,0,1,0,2,9,0,0,
567,0,0,9,104,0,9,745,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
590,0,0,9,0,0,13,752,0,0,1,0,0,1,0,2,9,0,0,
609,0,0,11,117,0,4,1024,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
632,0,0,12,158,0,4,1125,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
667,0,0,13,96,0,4,1175,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
690,0,0,14,165,0,6,1182,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
721,0,0,15,140,0,6,1203,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
748,0,0,16,147,0,6,1264,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                */
/************************************************************************/
/* PROGRAM NAME           : BLRPTFOL.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 22-AUG-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
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
#include "gl.h"             
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
#define ESC 0x1B    
#define REP_WIDTH 122 

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            date_time                                  [20],
            user_id                                    [40],
            nd_epi_type                                [2],
            nd_session_id                              [16],
            nd_pgm_date                                [25],
            d_curr_pgm_name                            [15], 
			nd_admission_type						   [3],
            nd_fm_date                                 [21],
            nd_to_date                                 [21],
            nd_fm_epi_no                               [9],
            nd_to_epi_no                               [9],
            nd_fm_visit_no                             [5],
            nd_to_visit_no                             [5],
			nd_temp_date                               [21],
			p_language_id							   [3],
			date_convert							   [21],
			nd_loc_date								   [21],
			nd_temp_date1                              [21],
			date_convert1							   [21],
			nd_loc_date1							   [21],
			nd_facility_id							   [3],
            nd_fm_patient_id                           [21],
            nd_to_patient_id                           [21],
			d_facility_id							   [10],
			nd_episode_type								[10],
			l_added_by_id							   [30],
			l_added_by_date							   [30],
			l_modified_by_id						   [30],
			l_modified_by_date						   [30],
            
			bl_patient_name_loc_lang                   [61],
            bl_patient_name                            [61],
            d_short_name_full                           [61],
			bl_patient_name1						   [31],  
            bl_blng_long_desc                          [31],  
            bl_pkg_long_desc                           [41],
            bl_blng_class_desc                         [16]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[2]; } nd_epi_type;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_admission_type;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[21]; } nd_to_date;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_epi_no;

struct { unsigned short len; unsigned char arr[9]; } nd_to_epi_no;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_visit_no;

struct { unsigned short len; unsigned char arr[5]; } nd_to_visit_no;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[21]; } date_convert1;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_patient_id;

struct { unsigned short len; unsigned char arr[10]; } d_facility_id;

struct { unsigned short len; unsigned char arr[10]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[30]; } l_added_by_id;

struct { unsigned short len; unsigned char arr[30]; } l_added_by_date;

struct { unsigned short len; unsigned char arr[30]; } l_modified_by_id;

struct { unsigned short len; unsigned char arr[30]; } l_modified_by_date;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[31]; } bl_patient_name1;

struct { unsigned short len; unsigned char arr[31]; } bl_blng_long_desc;

struct { unsigned short len; unsigned char arr[41]; } bl_pkg_long_desc;

struct { unsigned short len; unsigned char arr[16]; } bl_blng_class_desc;


   /* VARCHAR bl_pat_episode_type                         [2], 
           bl_pat_episode_id                           [9],
           bl_pat_visit_id                             [5],
           bl_pat_patient_id                           [21],
           bl_pat_blng_grp_id                          [5],
           bl_pat_package_ind                          [2],
           bl_pat_package_service_code                 [11],
           bl_pat_trx_date                             [13],
           bl_pat_trx_doc_ref                          [21],
           bl_pat_trx_doc_ref_line_num                 [5],
           bl_pat_trx_doc_ref_seq_num                  [5],
           bl_pat_service_date                         [21],
           bl_pat_base_charge_amt                      [23],
           bl_pat_upd_gross_charge_amt                 [23],
           bl_pat_upd_disc_amt                         [23],
           bl_pat_upd_net_charge_amt                   [23],
           bl_pat_module_id                            [3],
           bl_pat_source_doc_ref                       [21],
           bl_pat_source_doc_date                      [13],
		   bl_pat_serv_item_desc                       [41],
           bl_pat_trx_status                           [2],
           bl_pat_rev_adj_trx_ind                      [2],
           bl_pat_blng_class_code                      [3],
           bl_pat_canadj_reason_text                   [51],
		   l_pk_value								   [100],
		   l_translated_value						   [201],
           bl_pat_concat_visit                         [26],
           bl_pat_concat_pkg                           [10]; */ 
struct { unsigned short len; unsigned char arr[2]; } bl_pat_episode_type;

struct { unsigned short len; unsigned char arr[9]; } bl_pat_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_visit_id;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_patient_id;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_blng_grp_id;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_package_ind;

struct { unsigned short len; unsigned char arr[11]; } bl_pat_package_service_code;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_trx_date;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_trx_doc_ref;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_trx_doc_ref_line_num;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_trx_doc_ref_seq_num;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_service_date;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_base_charge_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_upd_gross_charge_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_upd_disc_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_upd_net_charge_amt;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_module_id;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_source_doc_ref;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_source_doc_date;

struct { unsigned short len; unsigned char arr[41]; } bl_pat_serv_item_desc;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_trx_status;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_rev_adj_trx_ind;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_blng_class_code;

struct { unsigned short len; unsigned char arr[51]; } bl_pat_canadj_reason_text;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[26]; } bl_pat_concat_visit;

struct { unsigned short len; unsigned char arr[10]; } bl_pat_concat_pkg;


 double    bl_pat_base_charge_amt_db,
           bl_pat_gross_charge_amt_db,
           bl_pat_disc_amt_db,
           bl_pat_net_charge_amt_db,

           bl_pkg_tot_base_charge_amt,
           bl_pkg_tot_gross_charge_amt,
           bl_pkg_tot_disc_amt,
           bl_pkg_tot_net_charge_amt,

           bl_vis_tot_base_charge_amt,
           bl_vis_tot_gross_charge_amt,
           bl_vis_tot_disc_amt,
           bl_vis_tot_net_charge_amt,
		   
           bl_grn_tot_base_charge_amt,
           bl_grn_tot_gross_charge_amt,
           bl_grn_tot_disc_amt,
           bl_grn_tot_net_charge_amt;



		char loc_legend[999][201];
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

char       store_concat_visit                          [26],
           store_concat_pkg                            [10];

int    lctr = 0,pctr = 0;

FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    int rec_ctr = 0, trn_ctr = 0, page_skip = 0;

    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();
    }
 
    strcpy(g_pgm_id,"BLRPTFOL");

    if (sql_connect(argv[1]) == -1)
    {
        disp_message(ORA_MESG,"Error in connecting to Oracle\n");
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
          print_rec(0);
          print_rec(1);
          strcpy(store_concat_visit,bl_pat_concat_visit.arr);
          strcpy(store_concat_pkg,bl_pat_concat_pkg.arr);
       }
       if (strcmp(store_concat_visit,bl_pat_concat_visit.arr))
       {
            print_epi_vis_tot(1);
            strcpy(store_concat_visit,bl_pat_concat_visit.arr);
            strcpy(store_concat_pkg,bl_pat_concat_pkg.arr);
       }
       else if (strcmp(store_concat_pkg,bl_pat_concat_pkg.arr))
       {
            print_pak_tot(1);
            strcpy(store_concat_pkg,bl_pat_concat_pkg.arr);
       }

       rec_ctr++;
       print_rec(2);
     }
     if (rec_ctr)
        print_grand_tot();

    end_of_rep();
    end_prog_msg();

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
         err_mesg("COMMIT WORK RELEASE failed",0,"");

    return;
}

fetch_prog_param() 
{
    nd_epi_type.arr[0]          = '\0';
    nd_fm_date.arr[0]           = '\0';
    nd_to_date.arr[0]           = '\0';
    nd_fm_epi_no.arr[0]         = '\0';
    nd_to_epi_no.arr[0]         = '\0';
    nd_fm_visit_no.arr[0]       = '\0';
    nd_to_visit_no.arr[0]       = '\0';
    nd_fm_patient_id.arr[0]     = '\0';
    nd_to_patient_id.arr[0]     = '\0';
	nd_admission_type.arr[0]	= '\0';

    nd_epi_type.len             = 0;
    nd_fm_date.len              = 0;
    nd_to_date.len              = 0;
    nd_fm_epi_no.len            = 0;
    nd_to_epi_no.len            = 0;
    nd_fm_visit_no.len          = 0;
    nd_to_visit_no.len          = 0;
    nd_fm_patient_id.len        = 0;
    nd_to_patient_id.len        = 0;
	nd_admission_type.len		= 0;

   /* EXEC SQL SELECT PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,
                   PARAM6,PARAM7,PARAM8,PARAM9, PARAM10,operating_facility_id
              INTO :nd_epi_type,
                   :nd_fm_epi_no,
                   :nd_to_epi_no,
                   :nd_fm_visit_no,
                   :nd_to_visit_no,
                   :nd_fm_patient_id,
                   :nd_to_patient_id,
                   :nd_fm_date,
                   :nd_to_date,
				   :nd_admission_type,
				   :d_facility_id
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,PARAM8 ,PARAM9 ,PARAM10 ,operating_facility_id into :b0,:b1,:b2,:b3,:b4,:\
b5,:b6,:b7,:b8,:b9,:b10  from SY_PROG_PARAM where ((PGM_ID=:b11 and SESSION_ID\
=:b12) and PGM_DATE=:b13)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )20;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_epi_type;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_epi_no;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_epi_no;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_visit_no;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_visit_no;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fm_patient_id;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_patient_id;
   sqlstm.sqhstl[6] = (unsigned int  )23;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[7] = (unsigned int  )23;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[8] = (unsigned int  )23;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_admission_type;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[10] = (unsigned int  )12;
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

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

    nd_epi_type.arr[nd_epi_type.len]              = '\0';
    nd_fm_date.arr[nd_fm_date.len]                = '\0';
    nd_to_date.arr[nd_to_date.len]                = '\0';
    nd_fm_epi_no.arr[nd_fm_epi_no.len]            = '\0';
    nd_to_epi_no.arr[nd_to_epi_no.len]            = '\0';
    nd_fm_visit_no.arr[nd_fm_visit_no.len]        = '\0';
    nd_to_visit_no.arr[nd_to_visit_no.len]        = '\0';
    nd_fm_patient_id.arr[nd_fm_patient_id.len]    = '\0';
    nd_to_patient_id.arr[nd_to_patient_id.len]    = '\0';

	d_facility_id.arr[d_facility_id.len]		  = '\0';
	strcpy(g_facility_id, d_facility_id.arr);


   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 14;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )91;
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

     /*EXEC SQL DECLARE BL_PAT_CHG_FOLIO_CUR CURSOR FOR
               SELECT EPISODE_TYPE,
                      EPISODE_ID,
                      VISIT_ID,
                      PATIENT_ID,
                      BLNG_GRP_ID,
                      PACKAGE_IND,
                      PACKAGE_SERVICE_CODE,
                      TO_CHAR(TRX_DATE,'DD/MM/YYYY'),
                      TRX_DOC_REF,
                      TRX_DOC_REF_LINE_NUM,
                      TRX_DOC_REF_SEQ_NUM,
                      TO_CHAR(SERVICE_DATE,'DD/MM/YYYY HH24:MI'),
                      TO_CHAR(NVL(BASE_CHARGE_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(UPD_GROSS_CHARGE_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(UPD_DISC_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(UPD_NET_CHARGE_AMT,0),'999,999,990.99'),
                      MODULE_ID,
                      SOURCE_DOC_REF,
                      TO_CHAR(SOURCE_DOC_DATE,'DD/MM/YYYY'),
                      BLNG_CLASS_CODE,
                      PACKAGE_IND||PACKAGE_SERVICE_CODE,
                      EPISODE_TYPE||EPISODE_ID||VISIT_ID||PATIENT_ID,
                      NVL(BASE_CHARGE_AMT,0),
                      NVL(UPD_GROSS_CHARGE_AMT,0),
                      NVL(UPD_DISC_AMT,0),
                      NVL(UPD_NET_CHARGE_AMT,0),
					  SERV_ITEM_DESC,
                      TRX_STATUS,
                      REV_ADJ_TRX_IND,
                      CANADJ_REASON_TEXT,  
					  added_by_id,
					  to_char(added_date,'DD/MM/YYYY HH24:MI'),
					  decode(trx_status,'C',modified_by_id,NULL),
					  decode(trx_status,'C',to_char(modified_date,'DD/MM/YYYY HH24:MI'),NULL)
                 FROM BL_PATIENT_CHARGES_FOLIO
                WHERE TRX_DATE >=  TO_DATE(:nd_fm_date,'DD/MM/YYYY')
				  AND TRX_DATE <=  TO_DATE(:nd_to_date,'DD/MM/YYYY')
				  AND    (
					 ( EPISODE_TYPE = :nd_epi_type and :nd_admission_type='N') //is null
				  or ( :nd_epi_type = 'I' and :nd_admission_type is not null and 
	   				episode_id in (select episode_id from ip_episode   b
	  			 			where admission_type_code = :nd_admission_type))
					)
				  AND EPISODE_ID >= NVL(:nd_fm_epi_no,0) 
                  AND EPISODE_ID <= NVL(:nd_to_epi_no,99999999)     
				  AND VISIT_ID	 >= NVL(:nd_fm_visit_no,0) 
                  AND VISIT_ID	 <= NVL(:nd_to_visit_no,9999)
				  AND PATIENT_ID >= NVL(:nd_fm_patient_id,'!!!!!!!!!!') 
                  AND PATIENT_ID <= NVL(:nd_to_patient_id,'~~~~~~~~~~')
				  AND TRX_FINALIZE_IND = 'Y'
				  AND NVL(operating_facility_id,'X') = NVL(:d_facility_id,'X')
                  AND ((PACKAGE_IND = 'P' AND PACKAGE_TRX_IND = 'Y') OR PACKAGE_IND = 'S')
                ORDER 
				   BY EPISODE_TYPE,	
					  EPISODE_ID,
					  VISIT_ID,
					  PATIENT_ID,
                      PACKAGE_IND,
					  PACKAGE_SERVICE_CODE,
					  TRUNC(TRX_DATE),TRX_DOC_REF,
                      TRX_DOC_REF_LINE_NUM,
					  TRX_DOC_REF_SEQ_NUM;*/



		/* EXEC SQL DECLARE BL_PAT_CHG_FOLIO_CUR CURSOR FOR
               SELECT EPISODE_TYPE,
                      EPISODE_ID,
                      VISIT_ID,
                      PATIENT_ID,
                      BLNG_GRP_ID,
                      PACKAGE_IND,
                      PACKAGE_SERVICE_CODE,
                      TO_CHAR(TRX_DATE,'DD/MM/YYYY'),
                      TRX_DOC_REF,
                      TRX_DOC_REF_LINE_NUM,
                      TRX_DOC_REF_SEQ_NUM,
                      TO_CHAR(SERVICE_DATE,'DD/MM/YYYY HH24:MI'),
                      TO_CHAR(NVL(BASE_CHARGE_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(UPD_GROSS_CHARGE_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(UPD_DISC_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(UPD_NET_CHARGE_AMT,0),'999,999,990.99'),
                      MODULE_ID,
                      SOURCE_DOC_REF,
                      TO_CHAR(SOURCE_DOC_DATE,'DD/MM/YYYY'),
                      BLNG_CLASS_CODE,
                      PACKAGE_IND||PACKAGE_SERVICE_CODE,
                      EPISODE_TYPE||EPISODE_ID||VISIT_ID||PATIENT_ID,
                      NVL(BASE_CHARGE_AMT,0),
                      NVL(UPD_GROSS_CHARGE_AMT,0),
                      NVL(UPD_DISC_AMT,0),
                      NVL(UPD_NET_CHARGE_AMT,0),
					  SERV_ITEM_DESC,
                      TRX_STATUS,
                      REV_ADJ_TRX_IND,
                      CANADJ_REASON_TEXT,  
					  added_by_id,
					  to_char(added_date,'DD/MM/YYYY HH24:MI'),
					  decode(trx_status,'C',modified_by_id,NULL),
					  decode(trx_status,'C',to_char(modified_date,'DD/MM/YYYY HH24:MI'),NULL)
                 FROM BL_PATIENT_CHARGES_FOLIO
                WHERE TRX_DATE >=  TO_DATE(:nd_fm_date,'DD/MM/YYYY')
				  AND TRX_DATE <=  TO_DATE(:nd_to_date,'DD/MM/YYYY')
				  AND (
						( EPISODE_TYPE = :nd_epi_type and nvl(:nd_admission_type,'N') ='N')
							or ( :nd_epi_type = 'I' and :nd_admission_type ='Y' and 
								package_trx_ind is not null and 
	   						episode_id in (select distinct episode_id from BL_PATIENT_CHARGES_FOLIO   b
	  			 			where TRX_DATE >=  TO_DATE(:nd_fm_date,'DD/MM/YYYY')
							AND TRX_DATE <=  TO_DATE(:nd_to_date,'DD/MM/YYYY')
							AND EPISODE_ID >= NVL(:nd_fm_epi_no,0) 
							AND EPISODE_ID <= NVL(:nd_to_epi_no,99999999)     
							AND VISIT_ID	 >= NVL(:nd_fm_visit_no,0) 
							AND VISIT_ID	 <= NVL(:nd_to_visit_no,9999)
							AND PATIENT_ID >= NVL(:nd_fm_patient_id,'!!!!!!!!!!') 
							AND PATIENT_ID <= NVL(:nd_to_patient_id,'~~~~~~~~~~')
				  			AND TRX_FINALIZE_IND = 'Y'
							AND TRX_STATUS IS NULL 
				  			AND NVL(operating_facility_id,'X') = NVL(:d_facility_id,'X'))))
				  AND (EPISODE_ID >= NVL(:nd_fm_epi_no,0) 
                  AND EPISODE_ID <= NVL(:nd_to_epi_no,99999999) )    
				  AND (VISIT_ID	 >= NVL(:nd_fm_visit_no,0) 
                  AND VISIT_ID	 <= NVL(:nd_to_visit_no,9999))
				  AND (PATIENT_ID >= NVL(:nd_fm_patient_id,'!!!!!!!!!!') 
                  AND PATIENT_ID <= NVL(:nd_to_patient_id,'~~~~~~~~~~'))
				  AND TRX_FINALIZE_IND = 'Y'
				  AND NVL(operating_facility_id,'X') = NVL(:d_facility_id,'X')
                  AND ((PACKAGE_IND = 'P' AND PACKAGE_TRX_IND = 'Y') OR PACKAGE_IND = 'S')
                ORDER 
				   BY EPISODE_TYPE,	
					  EPISODE_ID,
					  VISIT_ID,
					  PATIENT_ID,
                      PACKAGE_IND,
					  PACKAGE_SERVICE_CODE,
					  TRUNC(TRX_DATE),TRX_DOC_REF,
                      TRX_DOC_REF_LINE_NUM,
					  TRX_DOC_REF_SEQ_NUM; */ 



    /* EXEC SQL DECLARE BL_PAT_NAME_CUR CURSOR FOR
              //SELECT SUBSTR(SHORT_NAME_LOC_LANG,1,16),   prad
                   /o  substr(SHORT_NAME,1,30),
					 decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname2 ,
                     o/
				//	  short_name   prad
		SELECT 
			decode(:p_language_id,'en', substr(short_name,1,30),substr(SHORT_NAME_LOC_LANG,1,30)),
			null
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :bl_pat_patient_id; */ 


    /* EXEC SQL DECLARE BL_BLNG_GRP_CUR CURSOR FOR
              SELECT LONG_DESC
                FROM BL_BLNG_GRP_lang_vw
               WHERE BLNG_GRP_ID = :bl_pat_blng_grp_id
			   and language_id=:p_language_id; */ 


    /* EXEC SQL DECLARE BL_PACKAGE_HDR_CUR CURSOR FOR
              SELECT LOC_LANG_LONG_DESC
                FROM BL_PACKAGE_HDR
               WHERE PACKAGE_CODE = :bl_pat_package_service_code; */ 

			   

    /* EXEC SQL DECLARE BL_BLNG_SERV_CUR CURSOR FOR
              SELECT LONG_DESC
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select EPISODE_TYPE ,EPISODE_ID ,VISIT_ID ,PATIENT_ID ,BLNG_GRP_ID ,P\
ACKAGE_IND ,PACKAGE_SERVICE_CODE ,TO_CHAR(TRX_DATE,'DD/MM/YYYY') ,TRX_DOC_RE\
F ,TRX_DOC_REF_LINE_NUM ,TRX_DOC_REF_SEQ_NUM ,TO_CHAR(SERVICE_DATE,'DD/MM/YY\
YY HH24:MI') ,TO_CHAR(NVL(BASE_CHARGE_AMT,0),'999,999,990.99') ,TO_CHAR(NVL(\
UPD_GROSS_CHARGE_AMT,0),'999,999,990.99') ,TO_CHAR(NVL(UPD_DISC_AMT,0),'999,\
999,990.99') ,TO_CHAR(NVL(UPD_NET_CHARGE_AMT,0),'999,999,990.99') ,MODULE_ID\
 ,SOURCE_DOC_REF ,TO_CHAR(SOURCE_DOC_DATE,'DD/MM/YYYY') ,BLNG_CLASS_CODE ,(P\
ACKAGE_IND||PACKAGE_SERVICE_CODE) ,(((EPISODE_TYPE||EPISODE_ID)||VISIT_ID)||\
PATIENT_ID) ,NVL(BASE_CHARGE_AMT,0) ,NVL(UPD_GROSS_CHARGE_AMT,0) ,NVL(UPD_DI\
SC_AMT,0) ,NVL(UPD_NET_CHARGE_AMT,0) ,SERV_ITEM_DESC ,TRX_STATUS ,REV_ADJ_TR\
X_IND ,CANADJ_REASON_TEXT ,added_by_id ,to_char(added_date,'DD/MM/YYYY HH24:\
MI') ,decode(trx_status,'C',modified_by_id,null ) ,decode(trx_status,'C',to_\
char(modified_date,'DD/MM/YYYY HH24:MI'),null )  from BL_PATIENT_CHARGES_FOL\
IO where ((((((((TRX_DATE>=TO_DATE(:b0,'DD/");
    sqlbuft((void **)0, 
      "MM/YYYY') and TRX_DATE<=TO_DATE(:b1,'DD/MM/YYYY')) and ((EPISODE_TYPE\
=:b2 and nvl(:b3,'N')='N') or (((:b2='I' and :b3='Y') and package_trx_ind is\
  not null ) and episode_id in (select distinct episode_id  from BL_PATIENT_\
CHARGES_FOLIO b where ((((((((((TRX_DATE>=TO_DATE(:b0,'DD/MM/YYYY') and TRX_\
DATE<=TO_DATE(:b1,'DD/MM/YYYY')) and EPISODE_ID>=NVL(:b8,0)) and EPISODE_ID<\
=NVL(:b9,99999999)) and VISIT_ID>=NVL(:b10,0)) and VISIT_ID<=NVL(:b11,9999))\
 and PATIENT_ID>=NVL(:b12,'!!!!!!!!!!')) and PATIENT_ID<=NVL(:b13,'~~~~~~~~~\
~')) and TRX_FINALIZE_IND='Y') and TRX_STATUS is null ) and NVL(operating_fa\
cility_id,'X')=NVL(:b14,'X')))))) and (EPISODE_ID>=NVL(:b8,0) and EPISODE_ID\
<=NVL(:b9,99999999))) and (VISIT_ID>=NVL(:b10,0) and VISIT_ID<=NVL(:b11,9999\
))) and (PATIENT_ID>=NVL(:b12,'!!!!!!!!!!') and PATIENT_ID<=NVL(:b13,'~~~~~~\
~~~~'))) and TRX_FINALIZE_IND='Y') and NVL(operating_facility_id,'X')=NVL(:b\
14,'X')) and ((PACKAGE_IND='P' and PACKAGE_TRX_IND='Y') or PACKAGE_IND='S'))\
 order by EPISODE_TYPE,EPISODE_ID,VISIT_ID,");
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )118;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_epi_type;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_admission_type;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_epi_type;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_admission_type;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[6] = (unsigned int  )23;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_fm_epi_no;
    sqlstm.sqhstl[8] = (unsigned int  )11;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_to_epi_no;
    sqlstm.sqhstl[9] = (unsigned int  )11;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_fm_visit_no;
    sqlstm.sqhstl[10] = (unsigned int  )7;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_to_visit_no;
    sqlstm.sqhstl[11] = (unsigned int  )7;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_fm_patient_id;
    sqlstm.sqhstl[12] = (unsigned int  )23;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_to_patient_id;
    sqlstm.sqhstl[13] = (unsigned int  )23;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[14] = (unsigned int  )12;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_fm_epi_no;
    sqlstm.sqhstl[15] = (unsigned int  )11;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_to_epi_no;
    sqlstm.sqhstl[16] = (unsigned int  )11;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_fm_visit_no;
    sqlstm.sqhstl[17] = (unsigned int  )7;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_to_visit_no;
    sqlstm.sqhstl[18] = (unsigned int  )7;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_fm_patient_id;
    sqlstm.sqhstl[19] = (unsigned int  )23;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&nd_to_patient_id;
    sqlstm.sqhstl[20] = (unsigned int  )23;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[21] = (unsigned int  )12;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
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
	bl_pat_episode_type.arr[0]                                        = '\0';
	bl_pat_episode_id.arr[0]                                          = '\0';
	bl_pat_visit_id.arr[0]                                            = '\0';
	bl_pat_patient_id.arr[0]                                          = '\0';
	bl_pat_blng_grp_id.arr[0]                                         = '\0';
	bl_pat_package_ind.arr[0]                                         = '\0';
	bl_pat_package_service_code.arr[0]                                = '\0';
	bl_pat_trx_date.arr[0]                                            = '\0';
	bl_pat_trx_doc_ref.arr[0]                                         = '\0';
	bl_pat_trx_doc_ref_line_num.arr[0]                                = '\0';
	bl_pat_trx_doc_ref_seq_num.arr[0]                                 = '\0';
	bl_pat_service_date.arr[0]                                        = '\0';
	bl_pat_base_charge_amt.arr[0]                                     = '\0';
	bl_pat_upd_gross_charge_amt.arr[0]                                = '\0';
	bl_pat_upd_disc_amt.arr[0]                                        = '\0';
	bl_pat_upd_net_charge_amt.arr[0]                                  = '\0';
	bl_pat_module_id.arr[0]                                           = '\0';
	bl_pat_source_doc_ref.arr[0]                                      = '\0';
	bl_pat_source_doc_date.arr[0]                                     = '\0';
	bl_pat_blng_class_code.arr[0]                                     = '\0';
	bl_pat_concat_visit.arr[0]                                        = '\0';
	bl_pat_concat_pkg.arr[0]                                          = '\0';
	bl_pat_serv_item_desc.arr[0]                                      = '\0';
	bl_pat_trx_status.arr[0]                                          = '\0';
	bl_pat_rev_adj_trx_ind.arr[0]                                     = '\0';
	bl_pat_canadj_reason_text.arr[0]                                  = '\0';

	bl_pat_episode_type.len                                           = 0;
	bl_pat_episode_id.len                                             = 0;
	bl_pat_visit_id.len                                               = 0;
	bl_pat_patient_id.len                                             = 0;
	bl_pat_blng_grp_id.len                                            = 0;
	bl_pat_package_ind.len                                            = 0;
	bl_pat_package_service_code.len                                   = 0;
	bl_pat_trx_date.len                                               = 0;
	bl_pat_trx_doc_ref.len                                            = 0;
	bl_pat_trx_doc_ref_line_num.len                                   = 0;
	bl_pat_trx_doc_ref_seq_num.len                                    = 0;
	bl_pat_service_date.len                                           = 0;
	bl_pat_base_charge_amt.len                                        = 0;
	bl_pat_upd_gross_charge_amt.len                                   = 0;
	bl_pat_upd_disc_amt.len                                           = 0;
	bl_pat_upd_net_charge_amt.len                                     = 0;
	bl_pat_module_id.len                                              = 0;
	bl_pat_source_doc_ref.len                                         = 0;
	bl_pat_source_doc_date.len                                        = 0;
	bl_pat_blng_class_code.len                                        = 0;
	bl_pat_concat_visit.len                                           = 0;
	bl_pat_concat_pkg.len                                             = 0;
	bl_pat_serv_item_desc.len                                         = 0;
	bl_pat_trx_status.len                                             = 0;
	bl_pat_rev_adj_trx_ind.len                                        = 0;
	bl_pat_canadj_reason_text.len                                     = 0;

	bl_pat_base_charge_amt_db                                         = 0;
	bl_pat_gross_charge_amt_db                                        = 0;
	bl_pat_disc_amt_db                                                = 0;
	bl_pat_net_charge_amt_db                                          = 0;

     /* EXEC SQL FETCH BL_PAT_CHG_FOLIO_CUR
               INTO :bl_pat_episode_type,
                    :bl_pat_episode_id,
                    :bl_pat_visit_id,
                    :bl_pat_patient_id,
                    :bl_pat_blng_grp_id,
                    :bl_pat_package_ind,
                    :bl_pat_package_service_code,
                    :bl_pat_trx_date,
                    :bl_pat_trx_doc_ref,
                    :bl_pat_trx_doc_ref_line_num,
                    :bl_pat_trx_doc_ref_seq_num,
                    :bl_pat_service_date,
                    :bl_pat_base_charge_amt,
                    :bl_pat_upd_gross_charge_amt,
                    :bl_pat_upd_disc_amt,
                    :bl_pat_upd_net_charge_amt,
                    :bl_pat_module_id,
                    :bl_pat_source_doc_ref,
                    :bl_pat_source_doc_date,
                    :bl_pat_blng_class_code,
                    :bl_pat_concat_pkg,
                    :bl_pat_concat_visit,
                    :bl_pat_base_charge_amt_db,
                    :bl_pat_gross_charge_amt_db,
                    :bl_pat_disc_amt_db,
                    :bl_pat_net_charge_amt_db,
                    :bl_pat_serv_item_desc,
                    :bl_pat_trx_status,
                    :bl_pat_rev_adj_trx_ind,
                    :bl_pat_canadj_reason_text,
					:l_added_by_id,
					:l_added_by_date,
					:l_modified_by_id,
					:l_modified_by_date; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 34;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )221;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_pat_episode_type;
     sqlstm.sqhstl[0] = (unsigned int  )4;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_pat_episode_id;
     sqlstm.sqhstl[1] = (unsigned int  )11;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_pat_visit_id;
     sqlstm.sqhstl[2] = (unsigned int  )7;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_pat_patient_id;
     sqlstm.sqhstl[3] = (unsigned int  )23;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_pat_blng_grp_id;
     sqlstm.sqhstl[4] = (unsigned int  )7;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_pat_package_ind;
     sqlstm.sqhstl[5] = (unsigned int  )4;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_pat_package_service_code;
     sqlstm.sqhstl[6] = (unsigned int  )13;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_pat_trx_date;
     sqlstm.sqhstl[7] = (unsigned int  )15;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_pat_trx_doc_ref;
     sqlstm.sqhstl[8] = (unsigned int  )23;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_pat_trx_doc_ref_line_num;
     sqlstm.sqhstl[9] = (unsigned int  )7;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_pat_trx_doc_ref_seq_num;
     sqlstm.sqhstl[10] = (unsigned int  )7;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_pat_service_date;
     sqlstm.sqhstl[11] = (unsigned int  )23;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_pat_base_charge_amt;
     sqlstm.sqhstl[12] = (unsigned int  )25;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_pat_upd_gross_charge_amt;
     sqlstm.sqhstl[13] = (unsigned int  )25;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_pat_upd_disc_amt;
     sqlstm.sqhstl[14] = (unsigned int  )25;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_pat_upd_net_charge_amt;
     sqlstm.sqhstl[15] = (unsigned int  )25;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_pat_module_id;
     sqlstm.sqhstl[16] = (unsigned int  )5;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&bl_pat_source_doc_ref;
     sqlstm.sqhstl[17] = (unsigned int  )23;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&bl_pat_source_doc_date;
     sqlstm.sqhstl[18] = (unsigned int  )15;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&bl_pat_blng_class_code;
     sqlstm.sqhstl[19] = (unsigned int  )5;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&bl_pat_concat_pkg;
     sqlstm.sqhstl[20] = (unsigned int  )12;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&bl_pat_concat_visit;
     sqlstm.sqhstl[21] = (unsigned int  )28;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&bl_pat_base_charge_amt_db;
     sqlstm.sqhstl[22] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&bl_pat_gross_charge_amt_db;
     sqlstm.sqhstl[23] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&bl_pat_disc_amt_db;
     sqlstm.sqhstl[24] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqhstv[25] = (         void  *)&bl_pat_net_charge_amt_db;
     sqlstm.sqhstl[25] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
     sqlstm.sqhstv[26] = (         void  *)&bl_pat_serv_item_desc;
     sqlstm.sqhstl[26] = (unsigned int  )43;
     sqlstm.sqhsts[26] = (         int  )0;
     sqlstm.sqindv[26] = (         void  *)0;
     sqlstm.sqinds[26] = (         int  )0;
     sqlstm.sqharm[26] = (unsigned int  )0;
     sqlstm.sqadto[26] = (unsigned short )0;
     sqlstm.sqtdso[26] = (unsigned short )0;
     sqlstm.sqhstv[27] = (         void  *)&bl_pat_trx_status;
     sqlstm.sqhstl[27] = (unsigned int  )4;
     sqlstm.sqhsts[27] = (         int  )0;
     sqlstm.sqindv[27] = (         void  *)0;
     sqlstm.sqinds[27] = (         int  )0;
     sqlstm.sqharm[27] = (unsigned int  )0;
     sqlstm.sqadto[27] = (unsigned short )0;
     sqlstm.sqtdso[27] = (unsigned short )0;
     sqlstm.sqhstv[28] = (         void  *)&bl_pat_rev_adj_trx_ind;
     sqlstm.sqhstl[28] = (unsigned int  )4;
     sqlstm.sqhsts[28] = (         int  )0;
     sqlstm.sqindv[28] = (         void  *)0;
     sqlstm.sqinds[28] = (         int  )0;
     sqlstm.sqharm[28] = (unsigned int  )0;
     sqlstm.sqadto[28] = (unsigned short )0;
     sqlstm.sqtdso[28] = (unsigned short )0;
     sqlstm.sqhstv[29] = (         void  *)&bl_pat_canadj_reason_text;
     sqlstm.sqhstl[29] = (unsigned int  )53;
     sqlstm.sqhsts[29] = (         int  )0;
     sqlstm.sqindv[29] = (         void  *)0;
     sqlstm.sqinds[29] = (         int  )0;
     sqlstm.sqharm[29] = (unsigned int  )0;
     sqlstm.sqadto[29] = (unsigned short )0;
     sqlstm.sqtdso[29] = (unsigned short )0;
     sqlstm.sqhstv[30] = (         void  *)&l_added_by_id;
     sqlstm.sqhstl[30] = (unsigned int  )32;
     sqlstm.sqhsts[30] = (         int  )0;
     sqlstm.sqindv[30] = (         void  *)0;
     sqlstm.sqinds[30] = (         int  )0;
     sqlstm.sqharm[30] = (unsigned int  )0;
     sqlstm.sqadto[30] = (unsigned short )0;
     sqlstm.sqtdso[30] = (unsigned short )0;
     sqlstm.sqhstv[31] = (         void  *)&l_added_by_date;
     sqlstm.sqhstl[31] = (unsigned int  )32;
     sqlstm.sqhsts[31] = (         int  )0;
     sqlstm.sqindv[31] = (         void  *)0;
     sqlstm.sqinds[31] = (         int  )0;
     sqlstm.sqharm[31] = (unsigned int  )0;
     sqlstm.sqadto[31] = (unsigned short )0;
     sqlstm.sqtdso[31] = (unsigned short )0;
     sqlstm.sqhstv[32] = (         void  *)&l_modified_by_id;
     sqlstm.sqhstl[32] = (unsigned int  )32;
     sqlstm.sqhsts[32] = (         int  )0;
     sqlstm.sqindv[32] = (         void  *)0;
     sqlstm.sqinds[32] = (         int  )0;
     sqlstm.sqharm[32] = (unsigned int  )0;
     sqlstm.sqadto[32] = (unsigned short )0;
     sqlstm.sqtdso[32] = (unsigned short )0;
     sqlstm.sqhstv[33] = (         void  *)&l_modified_by_date;
     sqlstm.sqhstl[33] = (unsigned int  )32;
     sqlstm.sqhsts[33] = (         int  )0;
     sqlstm.sqindv[33] = (         void  *)0;
     sqlstm.sqinds[33] = (         int  )0;
     sqlstm.sqharm[33] = (unsigned int  )0;
     sqlstm.sqadto[33] = (unsigned short )0;
     sqlstm.sqtdso[33] = (unsigned short )0;
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

	bl_pat_episode_type.arr[bl_pat_episode_type.len]                         = '\0';
	bl_pat_episode_id.arr[bl_pat_episode_id.len]                             = '\0';
	bl_pat_visit_id.arr[bl_pat_visit_id.len]                                 = '\0';
	bl_pat_patient_id.arr[bl_pat_patient_id.len]                             = '\0';
	bl_pat_blng_grp_id.arr[bl_pat_blng_grp_id.len]                           = '\0';
	bl_pat_package_ind.arr[bl_pat_package_ind.len]                           = '\0';
	bl_pat_package_service_code.arr[bl_pat_package_service_code.len]         = '\0';
	bl_pat_trx_date.arr[bl_pat_trx_date.len]                                 = '\0';
	bl_pat_trx_doc_ref.arr[bl_pat_trx_doc_ref.len]                           = '\0';
	bl_pat_trx_doc_ref_line_num.arr[bl_pat_trx_doc_ref_line_num.len]         = '\0';
	bl_pat_service_date.arr[bl_pat_service_date.len]                         = '\0';
	bl_pat_trx_doc_ref_seq_num.arr[bl_pat_trx_doc_ref_seq_num.len]           = '\0';
	bl_pat_base_charge_amt.arr[bl_pat_base_charge_amt.len]                   = '\0';
	bl_pat_upd_gross_charge_amt.arr[bl_pat_upd_gross_charge_amt.len]         = '\0';
	bl_pat_upd_disc_amt.arr[bl_pat_upd_disc_amt.len]                         = '\0';
	bl_pat_upd_net_charge_amt.arr[bl_pat_upd_net_charge_amt.len]             = '\0';
	bl_pat_module_id.arr[bl_pat_module_id.len]                               = '\0';
	bl_pat_source_doc_ref.arr[bl_pat_source_doc_ref.len]                     = '\0';
	bl_pat_source_doc_date.arr[bl_pat_source_doc_date.len]                   = '\0';
	bl_pat_blng_class_code.arr[bl_pat_blng_class_code.len]                   = '\0';
	bl_pat_concat_visit.arr[bl_pat_concat_visit.len]                         = '\0';
	bl_pat_concat_pkg.arr[bl_pat_concat_pkg.len]                             = '\0';
	bl_pat_serv_item_desc.arr[bl_pat_serv_item_desc.len]                     = '\0';
	bl_pat_trx_status.arr[bl_pat_trx_status.len]                             = '\0';
	bl_pat_rev_adj_trx_ind.arr[bl_pat_rev_adj_trx_ind.len]                   = '\0';
	bl_pat_canadj_reason_text.arr[bl_pat_canadj_reason_text.len]             = '\0';
	l_added_by_id.arr[l_added_by_id.len]									 = '\0';	
	l_added_by_date.arr[l_added_by_date.len]								 = '\0';
	l_modified_by_id.arr[l_modified_by_id.len]								 = '\0';
	l_modified_by_date.arr[l_modified_by_date.len]							 = '\0';
    
	return(LAST_ROW?0:1);
}

fetch_dtls()
{
   /* EXEC SQL OPEN BL_PAT_NAME_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 34;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0005;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )372;
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 34;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )395;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
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
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 34;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ; \
BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str2\
 ) ; IF str2 IS NOT NULL THEN :bl_patient_name := str2 ; END IF ; blcommon . s\
plit_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS NO\
T NULL THEN :bl_patient_name1 := str2 ; END IF ; blcommon . split_words ( :d_s\
hort_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :bl_p\
atient_name1 := :bl_patient_name1 || str2 ; end if ; END ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )418;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
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
sqlstm.sqhstl[2] = (unsigned int  )33;
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 34;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )445;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_pat_blng_grp_id;
    sqlstm.sqhstl[0] = (unsigned int  )7;
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 34;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )468;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
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


}

fetch_serv_desc()  
{

    bl_pkg_long_desc.arr[0]                                           = '\0';
    bl_pkg_long_desc.len                                              = 0;

    if (bl_pat_package_ind.arr[0] == 'P')  //  if its panel 
    {
        /* EXEC SQL OPEN BL_PACKAGE_HDR_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 34;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0007;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )487;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
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
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 34;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )506;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
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
   else if (bl_pat_package_ind.arr[0] == 'S')   //if its service 
   {
        /* EXEC SQL OPEN BL_BLNG_SERV_CUR; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 34;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = sq0008;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )525;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
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
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 34;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )548;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
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

fetch_dtls1()
{
    /* EXEC SQL OPEN BL_BLNG_CLASS_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 34;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )567;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 34;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )590;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
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

print_rec(ind)
int ind;
{

  if (ind == 0)
  {
      fetch_dtls(); //to fetch the patient name  and bliing desc 
      if (lctr > 35) //51
          print_head();

      fprintf(fp,"%-16.16s   :  %1s ",loc_legend[220],bl_pat_episode_type.arr);
      switch (bl_pat_episode_type.arr[0])
      {
         case 'I' : fprintf(fp,"%-6.6s",loc_legend[360]);
                    break;

         case 'D' : fprintf(fp,"%-6.6s",loc_legend[350]);
                    break;

         case 'O' : fprintf(fp,"%-6.6s",loc_legend[340]);
                    break;

         case 'E' : fprintf(fp,"%-6.6s",loc_legend[330]);
                     break;

         case 'R' : fprintf(fp,"%-6.6s",loc_legend[430]);
                    break;

         default  : fprintf(fp,"   ");
                    break;
      }  
	  if(bl_pat_episode_type.arr[0] =='O' ||bl_pat_episode_type.arr[0] =='E')
	  {
      fprintf(fp,"               %-15.15s : %-8s        %-13.13s : %-4s\n",loc_legend[100],bl_pat_episode_id.arr,loc_legend[110],bl_pat_visit_id.arr);
      }
	  else if(bl_pat_episode_type.arr[0] =='I' ||bl_pat_episode_type.arr[0] =='D')
	  {
      fprintf(fp,"               %-15.15s : %-8s        \n",loc_legend[100],bl_pat_episode_id.arr);
      }

	  fprintf(fp,"%-15.15s    :  %-20s %-16.16s %-30.30s\n",loc_legend[90],
				bl_pat_patient_id.arr,
                bl_patient_name_loc_lang.arr,
                bl_patient_name.arr);
      if(strlen(bl_patient_name1.arr) > 2)
		{
		 fprintf(fp,"%55s %s \n"," ",bl_patient_name1.arr);
		 lctr++;
        }

  
     fprintf(fp,"%-18.18s :  %-4s %-30s\n",loc_legend[420],
                bl_pat_blng_grp_id.arr, bl_blng_long_desc.arr);
     lctr+=5;
   }
   else if (ind == 1)
   {
     if (lctr > 37) //53
          print_head();

     fetch_serv_desc();  //fetch the desc of  panel or Service 

     fprintf(fp,"%-19.19s:  %1s %-10s %-40s\n\n",loc_legend[410],
                bl_pat_package_ind.arr,
                bl_pat_package_service_code.arr,
                bl_pkg_long_desc.arr);
     lctr+=2;
   }
   else if (ind == 2)
   {
      if (lctr > 36) //52
          print_head();

     fetch_dtls1();            //to fetch the Billing class desc 
	 /*fprintf(fp,"   %-10s %-20s/%-4s/%-4s  %-16s             ",
	 //%s %s %s %s 
                date_convert.arr,
                bl_pat_trx_doc_ref.arr,
                bl_pat_trx_doc_ref_line_num.arr,
                bl_pat_trx_doc_ref_seq_num.arr,
                bl_pat_service_date.arr);*/
	
	if(bl_pat_trx_date.arr[0]!='\0')
	{
	   init_date_temp_var();
       strcpy(date_convert.arr,bl_pat_trx_date.arr);
	   fun_change_loc_date();
	  
	   }
	   fprintf(fp,"   %-10s %-20s/%-4s/%-4s  ",
	            date_convert.arr,
                bl_pat_trx_doc_ref.arr,
                bl_pat_trx_doc_ref_line_num.arr,
                bl_pat_trx_doc_ref_seq_num.arr);
				
	if(bl_pat_service_date.arr[0]!='\0')
	{
	   init_date_temp_var();
       strcpy(date_convert1.arr,bl_pat_service_date.arr);
	   fun_change_loc_date1();

	   }
       fprintf(fp,"%-16s%-13s",  date_convert1.arr,"");
	   
				print_formated(bl_pat_base_charge_amt_db);
				//fprintf(fp," ");
				print_formated(bl_pat_gross_charge_amt_db);
				//fprintf(fp," ");
                print_formated(bl_pat_disc_amt_db);
				//fprintf(fp," ");
                print_formated(bl_pat_net_charge_amt_db);
				
	fprintf(fp,"   %1s   %1s\n\
               %-2s  %-40.40s  %-2s %-15.15s      %-50.50s\n",
                bl_pat_trx_status.arr,
                bl_pat_rev_adj_trx_ind.arr,
                bl_pat_module_id.arr,
                bl_pat_serv_item_desc.arr,
                bl_pat_blng_class_code.arr,
                bl_blng_class_desc.arr,
                bl_pat_canadj_reason_text.arr);

 //fprintf(fp,"   %-30s             %-25s                   %-30s %-25s\n\n",l_added_by_id.arr,l_added_by_date.arr,l_modified_by_id.arr, l_modified_by_date.arr);
	 init_date_temp_var();
     strcpy(date_convert1.arr,l_added_by_date.arr);
	 fun_change_loc_date1();
	 fprintf(fp,"   %-30s             %-25s ",l_added_by_id.arr,date_convert1.arr);
	if(l_modified_by_date.arr[0]!='\0')
	{
	 init_date_temp_var();
     strcpy(date_convert1.arr,l_modified_by_date.arr);
	 fun_change_loc_date1();
	 }
	 fprintf(fp,"                   %-30s %-25s\n\n",l_modified_by_id.arr, date_convert1.arr);
	 lctr+=4;

     bl_pkg_tot_base_charge_amt  += bl_pat_base_charge_amt_db;
     bl_pkg_tot_gross_charge_amt += bl_pat_gross_charge_amt_db;
     bl_pkg_tot_disc_amt         += bl_pat_disc_amt_db;
     bl_pkg_tot_net_charge_amt   += bl_pat_net_charge_amt_db;
   }

   fflush(fp);
}

print_pak_tot(l_flg)
int l_flg;
{
    if (lctr > 36) //52
       print_head();

    fprintf(fp,"%74s    --------------- ----------------- ----------------- -----------------\n"," ");
    fprintf(fp,"%38s%-19.19s                  "," ",loc_legend[210]);
	//fprintf(fp,"%38s                %-19.19s  "," ",loc_legend[210]);
    print_formated(bl_pkg_tot_base_charge_amt);// fprintf(fp," ");
    print_formated(bl_pkg_tot_gross_charge_amt);// fprintf(fp," ");
    print_formated(bl_pkg_tot_disc_amt);// fprintf(fp," ");
    print_formated(bl_pkg_tot_net_charge_amt);
    fprintf(fp,"\n");
    fprintf(fp,"%74s    --------------- ----------------- ----------------- -----------------\n"," ");
    lctr +=3;

     bl_vis_tot_base_charge_amt  += bl_pkg_tot_base_charge_amt;
     bl_vis_tot_gross_charge_amt += bl_pkg_tot_gross_charge_amt;
     bl_vis_tot_disc_amt         += bl_pkg_tot_disc_amt;
     bl_vis_tot_net_charge_amt   += bl_pkg_tot_net_charge_amt;

     bl_pkg_tot_base_charge_amt = 0;
     bl_pkg_tot_gross_charge_amt = 0;
     bl_pkg_tot_disc_amt = 0;
     bl_pkg_tot_net_charge_amt = 0;

    if (l_flg)
       print_rec(1);
}

print_epi_vis_tot(l_flg)
int l_flg;
{
    print_pak_tot(0);

    if (lctr > 36) //52
       print_head();

    fprintf(fp,"%74s    --------------- ----------------- ----------------- -----------------\n"," ");
    fprintf(fp,"%38s%-19.19s                  "," ",loc_legend[200]);
    print_formated(bl_vis_tot_base_charge_amt);// fprintf(fp," ");
    print_formated(bl_vis_tot_gross_charge_amt);// fprintf(fp," ");
    print_formated(bl_vis_tot_disc_amt);// fprintf(fp," ");
    print_formated(bl_vis_tot_net_charge_amt);
    fprintf(fp,"\n");
    fprintf(fp,"%74s    --------------- ----------------- ----------------- -----------------\n"," ");
    lctr +=3;

    bl_grn_tot_base_charge_amt  += bl_vis_tot_base_charge_amt;
    bl_grn_tot_gross_charge_amt += bl_vis_tot_gross_charge_amt;
    bl_grn_tot_disc_amt         += bl_vis_tot_disc_amt;
    bl_grn_tot_net_charge_amt   += bl_vis_tot_net_charge_amt;

    bl_vis_tot_base_charge_amt = 0;
    bl_vis_tot_gross_charge_amt = 0;
    bl_vis_tot_disc_amt = 0;
    bl_vis_tot_net_charge_amt = 0;

    if (l_flg)
    {
       print_head();
       print_rec(0);
    }
}

print_grand_tot()
{
    print_epi_vis_tot(0);

    if (lctr > 36) //52
       print_head();

    fprintf(fp,"%74s    --------------- ----------------- ----------------- -----------------\n"," ");
    fprintf(fp,"%38s%-16.16s                     "," ",loc_legend[190]);
    print_formated(bl_grn_tot_base_charge_amt); //fprintf(fp," ");
    print_formated(bl_grn_tot_gross_charge_amt);// fprintf(fp," ");
    print_formated(bl_grn_tot_disc_amt);// fprintf(fp," ");
    print_formated(bl_grn_tot_net_charge_amt);
    fprintf(fp,"\n");
    fprintf(fp,"%74s    --------------- ----------------- ----------------- -----------------\n"," ");
    lctr +=3;
}

end_of_rep()
{
fprintf(fp,"\n\n                                                      ***  %-18s ***\n",loc_legend[480]);
fflush(fp);
}

open_file()
{
	char filename[150];
    strcpy(filename,WORKING_DIR);
    strcat(filename,"blrptfol.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrptfol.lis");
       proc_exit();
    }

    print_title();
    print_head();
}

print_title()
{
nd_episode_type.arr[0] ='\0';
nd_episode_type.len =0;

 	init_date_temp_var();
    strcpy(date_convert1.arr,date_time.arr);
	fun_change_loc_date1();

fprintf(fp,"%c&l1O",ESC);   /* To Print Landscape           */
fprintf(fp,"%c(s14H",ESC); 	/* To set the font size			*/

/* EXEC SQL SELECT DECODE(:nd_epi_type,'I','Inpatient','O','Outpatient','R','External','E','Emergency','D','Daycare') 
    into :nd_episode_type from dual; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 34;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select DECODE(:b0,'I','Inpatient','O','Outpatient','R','Exter\
nal','E','Emergency','D','Daycare') into :b1  from dual ";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )609;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_epi_type;
sqlstm.sqhstl[0] = (unsigned int  )4;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
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




	fprintf(fp,"%6.6s : %-5.5s%45s%-32s                      %20s\n",loc_legend[270],loc_legend[150],"  ",hosp_name.arr,date_convert1.arr);
	fprintf(fp,"%6.6s : %-10s \n",loc_legend[460], user_id.arr);
	fprintf(fp,"%6.6s : %-12.12s                           %40s                       %15.15s : %4d\n",loc_legend[470],loc_legend[40],loc_legend[50],loc_legend[30],++pctr);
	fprintf(fp,"-------------------------------------------------------------------------------------------------------------------------------------\n");
	fprintf(fp,"%6.6s : 4.1\n",loc_legend[500]);
	fflush(fp);

	fprintf(fp,"\n\n\n\n        %22s :\n        -----------------------\n\n",loc_legend[450]);
	fprintf(fp,"                  %-20.20s                   : %s\n\n",loc_legend[220],nd_episode_type.arr);

  
	if(nd_epi_type.arr[0] =='I' ||nd_epi_type.arr[0] =='O'||nd_epi_type.arr[0] =='D'||nd_epi_type.arr[0] =='E')
	{
	if(nd_fm_epi_no.arr[0] == '\0')
	fprintf(fp,"                  %-20.20s        %-10.10s : %-10s\n",loc_legend[100],loc_legend[60],loc_legend[510]);
	else
	fprintf(fp,"                  %-20.20s        %-10.10s : %s\n",loc_legend[100],loc_legend[60],nd_fm_epi_no.arr);
	if(nd_to_epi_no.arr[0] == '\0')
    fprintf(fp,"                                              %-10.10s : %-12s\n\n",loc_legend[70],loc_legend[520]);
	else
	fprintf(fp,"                                              %-10.10s : %s\n\n",loc_legend[70],nd_to_epi_no.arr);
    }
	if(nd_epi_type.arr[0] =='O' ||nd_epi_type.arr[0] =='E')
	{
	if(nd_fm_visit_no.arr[0] == '\0')
	fprintf(fp,"                  %-20.20s        %-10.10s : %-10s\n",loc_legend[110],loc_legend[60],loc_legend[510]);
	else
	fprintf(fp,"                  %-20.20s        %-10.10s : %s\n",loc_legend[110],loc_legend[60],nd_fm_visit_no.arr);
	if(nd_to_visit_no.arr[0] == '\0')
	fprintf(fp,"                                              %-10.10s : %-12s\n\n",loc_legend[70],loc_legend[520]);
	else
	fprintf(fp,"                                              %-10.10s : %s\n\n",loc_legend[70],nd_to_visit_no.arr);
    }
	if(nd_fm_patient_id.arr[0] == '\0')
	fprintf(fp,"                  %-20.20s        %-10.10s : %-10s\n",loc_legend[90],loc_legend[60],loc_legend[510]);
	else
	fprintf(fp,"                  %-20.20s        %-10.10s : %s\n",loc_legend[90],loc_legend[60],nd_fm_patient_id.arr);
	if(nd_to_patient_id.arr[0] == '\0')
	fprintf(fp,"                                              %-10.10s : %-12s\n\n",loc_legend[70],loc_legend[520]);
	else
	fprintf(fp,"                                              %-10.10s : %s\n\n",loc_legend[70],nd_to_patient_id.arr);
	if(nd_fm_date.arr[0] != '\0')
	{
	 init_date_temp_var();
     strcpy(date_convert.arr,nd_fm_date.arr);
	 fun_change_loc_date();
	fprintf(fp,"                  %-10.10s                  %-10.10s : %s\n",loc_legend[80],loc_legend[60],date_convert.arr);
	}

	else

	fprintf(fp,"                  %-10.10s                  %-10.10s : %s\n",loc_legend[80],loc_legend[60],loc_legend[510]);

	 if(nd_to_date.arr[0] != '\0')
	 {
	 init_date_temp_var();
     strcpy(date_convert.arr,nd_to_date.arr);
	 fun_change_loc_date();
	fprintf(fp,"                                              %-10.10s : %s\n\n",loc_legend[70],date_convert.arr);
	}

	else

	fprintf(fp,"                                              %-10.10s : %s\n\n",loc_legend[70],loc_legend[520]);
nd_episode_type.arr[nd_episode_type.len] = '\0';
}


print_head()
{
/*fprintf(fp,"   %10.10s TRX DOC REF/LINE                SERVICE DATE TIME               BASE CHARGE    GROSS CHARGE        DISC AMT      NET CHARGE  STAT REV/\n");
	fprintf(fp,"              MDL  SERVICE ITEM DESC                         BILLING CLASS      CANCEL/ADJUSTMENT  REMARKS                                      ADJ\n");
	fprintf(fp,"   SERVICE REQUESTED BY                       SERVICE REQUEST DATE TIME       CANCELLED BY                       CANCELLED DATE TIME               \n");*/
	init_date_temp_var();
    strcpy(date_convert1.arr,date_time.arr);
	fun_change_loc_date1();
	fprintf(fp,"\f%6.6s : %-5.5s                                                           %-30s                                        %-15s\n",loc_legend[270],loc_legend[150],hosp_name.arr,date_convert1.arr);
	fprintf(fp,"%6.6s : %-10s \n",loc_legend[460], user_id.arr);
	fprintf(fp,"%6.6s : %-12.12s                                   %46s                                          %-8.8s : %4d\n",loc_legend[470],loc_legend[40],loc_legend[50],loc_legend[30],++pctr);
	fprintf(fp,"-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	fprintf(fp,"   %-10.10s %-15.15s%-15.15s  %-11.11s%-7.7s%-7.7s  %20.20s %17.17s %17.17s %17.17s %9.9s/  \n",loc_legend[120],loc_legend[130],loc_legend[140],loc_legend[160],loc_legend[80],loc_legend[170],loc_legend[180],loc_legend[230],loc_legend[240],loc_legend[250],loc_legend[260]);
	fprintf(fp,"              %4.4s %-11.11s %-25.25s    %-20.20s %21.21s  %-25.25s   %23.23s\n",loc_legend[270],loc_legend[160],loc_legend[280],loc_legend[290],loc_legend[300],loc_legend[310],loc_legend[320]);
	fprintf(fp,"   %-11.11s %-20.20s           %-9.9s %-10.10s %-6.6s %-6.6s     %15.15s %-5.5s              %12.12s %-6.6s %-6.6s       \n",loc_legend[160],loc_legend[370],loc_legend[160],loc_legend[380],loc_legend[80],loc_legend[170],loc_legend[390],loc_legend[400],loc_legend[390],loc_legend[80],loc_legend[170]);
	fprintf(fp,"-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	fflush(fp);
	lctr = 11;
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

    /* EXEC SQL SELECT ACC_ENTITY_NAME, 
					TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, 
					:date_time, 
					:user_id
               FROM SY_ACC_ENTITY_LANG_VW
			  WHERE acc_entity_id = :d_facility_id
			  and language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 34;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (acc_entity_id=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )632;
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
   char out_str[30],out_str1[30];

   if (loc_amount >= 0)
   {
      /*sprintf(out_str,"%15.2f",loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);*/

      put_val(out_str1,loc_amount);
      format_amt(out_str1);
      fprintf(fp,"%18s",out_str1);
   }
   else
   {
      /*sprintf(out_str,"%15.2f",-loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);*/

      put_val(out_str1,-loc_amount);
      format_amt(out_str1);
	  fprintf(fp,"%17s-",out_str1);
   }
}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRPTFOL.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 34;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRPTFOL.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )667;
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
  sqlstm.arrsiz = 34;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )690;
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
	  
       	//get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
	   //:nd_loc_date := to_char(t_date,'DD/MM/YYYY');
	
	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 34;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )721;
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
date_convert1.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;
date_convert1.len = 0;

}


fun_change_loc_date()
{
//date_convert.arr[date_convert.len]='\0';
strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 
//date_convert.arr[date_convert.len]='\0';
}






get_local_date1()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date1  date;
	
	BEGIN
	
	  
	  :nd_loc_date1 :=sm_convert_datetime_2t(to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:p_language_id);
       	//get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date1);  
      
	   //:nd_loc_date1 := to_char(t_date1,'DD/MM/YYYY HH24:MI');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 34;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date1 date ; BEGIN :nd_loc_date1 := sm_convert_dat\
etime_2t ( to_date ( :nd_temp_date1 , 'DD/MM/YYYY HH24:MI' ) , :p_language_id \
) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )748;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_loc_date1;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_temp_date1;
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

                     



fun_change_loc_date1()
{

strcpy(nd_temp_date1.arr,date_convert1.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);


get_local_date1();

strcpy(date_convert1.arr,nd_loc_date1.arr); 

}




