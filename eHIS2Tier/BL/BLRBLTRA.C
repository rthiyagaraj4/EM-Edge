
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
    "C:\\temp\\CRF-0463\\Blrbltra.pc"
};


static unsigned long sqlctx = 1439500611;


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
            void  *sqhstv[26];
   unsigned int   sqhstl[26];
            int   sqhsts[26];
            void  *sqindv[26];
            int   sqinds[26];
   unsigned int   sqharm[26];
   unsigned int   *sqharc[26];
   unsigned short  sqadto[26];
   unsigned short  sqtdso[26];
} sqlstm = {10,26};

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
"select LONG_DESC  from BL_BLNG_SERV where BLNG_SERV_CODE=:b0           ";

 static const char *sq0004 = 
",'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))) and TRUNC(TRX_DATE) between \
NVL(TO_DATE(:b7,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM')) and NVL(TO_DATE(\
:b8,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))) and TRX_FINALIZE_IND='Y') a\
nd (TRX_STATUS is  not null  or REV_ADJ_TRX_IND is  not null )) and NVL(operat\
ing_facility_id,'N')=NVL(:b9,'N')) order by DECODE(:b10,'T',TRUNC(TRX_DATE),TR\
UNC(SERVICE_DATE)),EPISODE_ID,VISIT_ID,TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,TRX_DO\
C_REF_SEQ_NUM            ";

 static const char *sq0005 = 
"select SUBSTR(SHORT_NAME_LOC_LANG,1,16) ,short_name  from MP_PATIENT_MAST wh\
ere PATIENT_ID=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,256,0,0,0,0,0,1,0,
20,0,0,2,239,0,4,286,0,0,14,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
91,0,0,3,84,0,2,326,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
118,0,0,6,71,0,9,414,0,0,1,1,0,1,0,1,9,0,0,
137,0,0,6,0,0,13,422,0,0,1,0,0,1,0,2,9,0,0,
156,0,0,4,1515,0,9,433,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
215,0,0,4,0,0,13,492,0,0,26,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,
0,2,9,0,0,
334,0,0,5,105,0,9,552,0,0,1,1,0,1,0,1,9,0,0,
353,0,0,5,0,0,13,564,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
376,0,0,7,515,0,6,578,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
403,0,0,8,158,0,4,984,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
438,0,0,9,96,0,4,1051,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
461,0,0,10,165,0,6,1058,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
492,0,0,11,144,0,6,1079,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
519,0,0,12,143,0,6,1136,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRBLTRA.PC                                  */
/* AUTHOR                : ANIL.S.RAM                                   */
/* Converted To Windows  : Prasad B G S                4/7/96           */
/* DATE WRITTEN          : 05-APR-1994                                  */
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
#include <gl.h>       
#include <bl.h>                    

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])


/*
#define DEBUG 0
*/


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            date_time                                  [20],
            user_id                                    [40],
            nd_session_id                              [16],
            nd_pgm_date                                [35],
            d_curr_pgm_name                            [15],
            nd_epi_type                                [2],
            nd_rep_ord                                 [2],
            nd_fm_serv_date                            [35],
            nd_to_serv_date                            [35],
            nd_fm_trx_date                             [35],
            nd_to_trx_date                             [35],
			d_facility_id							   [10],
			p_language_id							   [3],
	    nd_fm_episode_id                           [9],
	    nd_to_episode_id                           [9],
	    nd_fm_pat_id                               [21],
	    nd_to_pat_id                               [21],
           d_short_name_full                           [61],
            bl_patient_name_loc_lang                   [61],
            bl_patient_name                            [61],
			bl_patient_name1                           [31],
			l_pk_value									[100],
			l_translated_value							[201],
			nd_temp_date								[21],
			date_convert								[35],
			nd_loc_date									[35],
			nd_temp_date1								[35],
			date_convert1								[35],
			nd_loc_date1								[35],
			nd_facility_id								[3]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[2]; } nd_epi_type;

struct { unsigned short len; unsigned char arr[2]; } nd_rep_ord;

struct { unsigned short len; unsigned char arr[35]; } nd_fm_serv_date;

struct { unsigned short len; unsigned char arr[35]; } nd_to_serv_date;

struct { unsigned short len; unsigned char arr[35]; } nd_fm_trx_date;

struct { unsigned short len; unsigned char arr[35]; } nd_to_trx_date;

struct { unsigned short len; unsigned char arr[10]; } d_facility_id;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_episode_id;

struct { unsigned short len; unsigned char arr[9]; } nd_to_episode_id;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_pat_id;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[31]; } bl_patient_name1;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[35]; } date_convert;

struct { unsigned short len; unsigned char arr[35]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[35]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[35]; } date_convert1;

struct { unsigned short len; unsigned char arr[35]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


   /* VARCHAR bl_pat_episode_type                         [2],
           bl_pat_episode_id                           [9],
           bl_pat_visit_id                             [5],
           bl_pat_patient_id                           [21],
           bl_pat_trx_date                             [13],
           bl_pat_trx_doc_ref                          [21],
           bl_pat_trx_doc_ref_line_num                 [5],
           bl_pat_trx_doc_ref_seq_num                  [5],
           bl_pat_service_date                         [13],
           bl_pat_service_time                         [6],
           bl_pat_service_qty                          [11],
           bl_pat_upd_gross_charge_amt                 [100],
           bl_pat_upd_disc_amt                         [100],
           bl_pat_upd_net_charge_amt                   [1003],
           bl_pat_trx_status                           [2],
           bl_pat_rev_adj_ind                          [2],
           bl_pat_modified_by                          [21],
           bl_pat_modified_date                        [21],
           bl_pat_org_doc_ref                          [21],
           bl_pat_org_doc_ref_line_num                 [5],
           bl_pat_org_doc_ref_seq_num                  [5],
           bl_pat_canadj_reason_text                   [51],

           bl_pat_cur_date                             [13],
           bl_pat_new_date                             [13],
	   bl_pat_blng_serv_code                       [11],
	   d_blng_serv_desc                            [41]; */ 
struct { unsigned short len; unsigned char arr[2]; } bl_pat_episode_type;

struct { unsigned short len; unsigned char arr[9]; } bl_pat_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_visit_id;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_patient_id;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_trx_date;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_trx_doc_ref;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_trx_doc_ref_line_num;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_trx_doc_ref_seq_num;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_service_date;

struct { unsigned short len; unsigned char arr[6]; } bl_pat_service_time;

struct { unsigned short len; unsigned char arr[11]; } bl_pat_service_qty;

struct { unsigned short len; unsigned char arr[100]; } bl_pat_upd_gross_charge_amt;

struct { unsigned short len; unsigned char arr[100]; } bl_pat_upd_disc_amt;

struct { unsigned short len; unsigned char arr[1003]; } bl_pat_upd_net_charge_amt;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_trx_status;

struct { unsigned short len; unsigned char arr[2]; } bl_pat_rev_adj_ind;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_modified_by;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_modified_date;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_org_doc_ref;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_org_doc_ref_line_num;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_org_doc_ref_seq_num;

struct { unsigned short len; unsigned char arr[51]; } bl_pat_canadj_reason_text;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_cur_date;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_new_date;

struct { unsigned short len; unsigned char arr[11]; } bl_pat_blng_serv_code;

struct { unsigned short len; unsigned char arr[41]; } d_blng_serv_desc;


 double    bl_pat_gross_charge_amt_db,
           bl_pat_disc_amt_db,
           bl_pat_net_charge_amt_db,

           bl_pat_tot_gross_charge_amt,
           bl_pat_tot_disc_amt,
           bl_pat_tot_net_charge_amt,

           bl_vis_tot_gross_charge_amt,
           bl_vis_tot_disc_amt,
           bl_vis_tot_net_charge_amt,

           bl_grn_tot_gross_charge_amt,
           bl_grn_tot_disc_amt,
           bl_grn_tot_net_charge_amt;

	int i;
	
	char g_facility_id[3];

    char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];


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

char       store_concat_visit                          [15],
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
       disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
       proc_exit();
    }
 
    strcpy(g_pgm_id,"BLRBLTRA");

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

    strcpy(nd_facility_id.arr,argv[4]);
   	nd_facility_id.len = strlen(nd_facility_id.arr);
   	strcpy(g_facility_id,nd_facility_id.arr);


    start_prog_msg();

    fetch_prog_param();
	fetch_legend_value();
    declare_cur();
    fetch_hosp_name();
    open_file();
     
    open_cur();

    while(fetch_cur())
    {
       get_blng_serv_desc();
       if (rec_ctr == 0)
       {
          print_rec(0);
          if (nd_rep_ord.arr[0] == 'T')
          {
             strcpy(bl_pat_cur_date.arr,bl_pat_trx_date.arr);
             bl_pat_cur_date.len = strlen(bl_pat_cur_date.arr);
          }
          else
          {
             strcpy(bl_pat_cur_date.arr,bl_pat_service_date.arr);
             bl_pat_cur_date.len = strlen(bl_pat_cur_date.arr);
          }
       }
       if (nd_rep_ord.arr[0] == 'T')
       {
         if (strcmp(bl_pat_cur_date.arr,bl_pat_trx_date.arr))
         {
            print_date_tot();
            print_rec(0);

            strcpy(bl_pat_cur_date.arr,bl_pat_trx_date.arr);
            bl_pat_cur_date.len = strlen(bl_pat_cur_date.arr);
         }
       }
       else
       {
         if (strcmp(bl_pat_cur_date.arr,bl_pat_service_date.arr))
         {
            print_date_tot();
            print_rec(0);

            strcpy(bl_pat_cur_date.arr,bl_pat_service_date.arr);
            bl_pat_cur_date.len = strlen(bl_pat_cur_date.arr);
         }
       }

       rec_ctr++;
       print_rec(2);
     }
     if (rec_ctr)
     {
        print_grand_tot();
        while(lctr < 51)
        {
         fprintf(fp,"\n");
         lctr+=1;
        }
        print_footer();
     }

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

}

fetch_prog_param()
{
    nd_epi_type.arr[0]               = '\0';
    nd_rep_ord.arr[0]                = '\0';
    nd_fm_serv_date.arr[0]           = '\0';
    nd_to_serv_date.arr[0]           = '\0';
    nd_fm_trx_date.arr[0]            = '\0';
    nd_to_trx_date.arr[0]            = '\0';
    nd_fm_episode_id.arr[0]          = '\0';
    nd_to_episode_id.arr[0]          = '\0';
    nd_fm_pat_id.arr[0]              = '\0';
    nd_to_pat_id.arr[0]              = '\0';

    nd_epi_type.len                  = 0;
    nd_rep_ord.len                   = 0;
    nd_fm_serv_date.len              = 0;
    nd_to_serv_date.len              = 0;
    nd_fm_trx_date.len               = 0;
    nd_to_trx_date.len               = 0;
    nd_fm_episode_id.len             = 0;
    nd_to_episode_id.len             = 0;
    nd_fm_pat_id.len                 = 0;
    nd_to_pat_id.len                 = 0;

   /* EXEC SQL SELECT PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,
                   PARAM6, PARAM7, PARAM8, PARAM9, PARAM10,
				   operating_facility_id
              INTO :nd_epi_type,
                   :nd_rep_ord ,
                   :nd_fm_episode_id,
                   :nd_to_episode_id,
                   :nd_fm_pat_id,
                   :nd_to_pat_id,
                   :nd_fm_serv_date,
                   :nd_to_serv_date,
                   :nd_fm_trx_date,
                   :nd_to_trx_date ,
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
   sqlstm.sqhstv[1] = (         void  *)&nd_rep_ord;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_episode_id;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_episode_id;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_pat_id;
   sqlstm.sqhstl[4] = (unsigned int  )23;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_pat_id;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_serv_date;
   sqlstm.sqhstl[6] = (unsigned int  )37;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_serv_date;
   sqlstm.sqhstl[7] = (unsigned int  )37;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_fm_trx_date;
   sqlstm.sqhstl[8] = (unsigned int  )37;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_to_trx_date;
   sqlstm.sqhstl[9] = (unsigned int  )37;
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
   sqlstm.sqhstl[13] = (unsigned int  )37;
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
    nd_rep_ord.arr[nd_rep_ord.len]                = '\0';
    nd_fm_serv_date.arr[nd_fm_serv_date.len]      = '\0';
    nd_to_serv_date.arr[nd_to_serv_date.len]      = '\0';
    nd_fm_trx_date.arr[nd_fm_trx_date.len]        = '\0';
    nd_to_trx_date.arr[nd_to_trx_date.len]        = '\0';
    nd_fm_episode_id.arr[nd_fm_episode_id.len]    = '\0';
    nd_to_episode_id.arr[nd_to_episode_id.len]    = '\0';
    nd_fm_pat_id.arr[nd_fm_pat_id.len]            = '\0';
    nd_to_pat_id.arr[nd_to_pat_id.len]            = '\0';

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
   sqlstm.sqhstl[2] = (unsigned int  )37;
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

     /* EXEC SQL DECLARE BL_PAT_CHG_FOLIO_CUR CURSOR FOR
               SELECT EPISODE_TYPE,
                      LPAD(TO_CHAR(EPISODE_ID),8,'0'),
                      LPAD(TO_CHAR(VISIT_ID),4,'0'),
                      PATIENT_ID,
                      TRUNC(TRX_DATE),
                      TRUNC(SERVICE_DATE),
                      TO_CHAR(SERVICE_DATE,'HH24:MI'),
                      TRX_DOC_REF,
                      TRX_DOC_REF_LINE_NUM,
                      TRX_DOC_REF_SEQ_NUM,
                      TO_CHAR(NVL(SERV_QTY,0),'999,990.99'),
                      TO_CHAR(NVL(UPD_GROSS_CHARGE_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(UPD_DISC_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(UPD_NET_CHARGE_AMT,0),'999,999,990.99'),
                      TRX_STATUS,
                      REV_ADJ_TRX_IND,
                      ORIG_DOC_REF,
                      ORIG_DOC_REF_LINE_NUM,
                      ORIG_DOC_REF_SEQ_NUM ,
                      CANADJ_REASON_TEXT,
                      MODIFIED_BY_ID,
                      TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI'),
                      NVL(UPD_GROSS_CHARGE_AMT,0),
                      NVL(UPD_DISC_AMT,0),
                      NVL(UPD_NET_CHARGE_AMT,0) ,
		      BLNG_SERV_CODE
                 FROM BL_PATIENT_CHARGES_FOLIO
                WHERE EPISODE_TYPE = NVL(:nd_epi_type,EPISODE_TYPE)
		  AND EPISODE_ID BETWEEN 
			NVL(:nd_fm_episode_id,'0') 
			 AND
		        NVL(:nd_to_episode_id,'99999999')
		  AND PATIENT_ID BETWEEN 
			NVL(:nd_fm_pat_id,'!!!!!!!!!!!!!!!!!!!!') AND
			NVL(:nd_to_pat_id,'~~~~~~~~~~~~~~~~~~~~')
                  AND TRUNC(SERVICE_DATE)
                       BETWEEN 
                        NVL(TO_DATE(:nd_fm_serv_date,'DD/MM/YYYY'),
                             to_date('00010101','YYYYDDMM'))
                         AND
                        NVL(TO_DATE(:nd_to_serv_date,'DD/MM/YYYY'),
                             to_date('47123112','YYYYDDMM'))
                  AND TRUNC(TRX_DATE) BETWEEN 
                        NVL(TO_DATE(:nd_fm_trx_date,'DD/MM/YYYY'),
                             to_date('00010101','YYYYDDMM')) AND
                        NVL(TO_DATE(:nd_to_trx_date,'DD/MM/YYYY'),
                             to_date('47123112','YYYYDDMM'))
                  AND TRX_FINALIZE_IND = 'Y'
                  AND (TRX_STATUS IS NOT NULL OR REV_ADJ_TRX_IND IS NOT NULL)
				  AND NVL(operating_facility_id,'N') = NVL(:d_facility_id,'N')
                ORDER BY DECODE(:nd_rep_ord,'T',TRUNC(TRX_DATE),
                                                TRUNC(SERVICE_DATE)),
                         EPISODE_ID,VISIT_ID,TRX_DOC_REF,
                         TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM; */ 


    /* EXEC SQL DECLARE BL_PAT_NAME_CUR CURSOR FOR
              SELECT SUBSTR(SHORT_NAME_LOC_LANG,1,16),
                   /o  substr(SHORT_NAME,1,30),
					 decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,
                     o/

					  short_name
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :bl_pat_patient_id; */ 


    /* EXEC SQL DECLARE BL_BLNG_SERV_CUR CURSOR FOR
	      SELECT LONG_DESC
		FROM BL_BLNG_SERV
	       WHERE BLNG_SERV_CODE = :bl_pat_blng_serv_code; */ 


}

get_blng_serv_desc()
{
    /* EXEC SQL OPEN BL_BLNG_SERV_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )118;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_pat_blng_serv_code;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor BL_BLNG_SERV_CUR",0,"");

    d_blng_serv_desc.arr[0]  = '\0';
    d_blng_serv_desc.len     = 0;

    /* EXEC SQL FETCH BL_BLNG_SERV_CUR 
	      INTO :d_blng_serv_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )137;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_desc;
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
	err_mesg("FETCH failed on cursor BL_BLNG_SERV_CUR",0,"");

    d_blng_serv_desc.arr[d_blng_serv_desc.len]  = '\0';
}

open_cur()
{
    /* EXEC SQL OPEN BL_PAT_CHG_FOLIO_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 14;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select EPISODE_TYPE ,LPAD(TO_CHAR(EPISODE_ID),8,'0') ,LPAD(TO_CHAR(VI\
SIT_ID),4,'0') ,PATIENT_ID ,TRUNC(TRX_DATE) ,TRUNC(SERVICE_DATE) ,TO_CHAR(SE\
RVICE_DATE,'HH24:MI') ,TRX_DOC_REF ,TRX_DOC_REF_LINE_NUM ,TRX_DOC_REF_SEQ_NU\
M ,TO_CHAR(NVL(SERV_QTY,0),'999,990.99') ,TO_CHAR(NVL(UPD_GROSS_CHARGE_AMT,0\
),'999,999,990.99') ,TO_CHAR(NVL(UPD_DISC_AMT,0),'999,999,990.99') ,TO_CHAR(\
NVL(UPD_NET_CHARGE_AMT,0),'999,999,990.99') ,TRX_STATUS ,REV_ADJ_TRX_IND ,OR\
IG_DOC_REF ,ORIG_DOC_REF_LINE_NUM ,ORIG_DOC_REF_SEQ_NUM ,CANADJ_REASON_TEXT \
,MODIFIED_BY_ID ,TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI') ,NVL(UPD_GROSS_\
CHARGE_AMT,0) ,NVL(UPD_DISC_AMT,0) ,NVL(UPD_NET_CHARGE_AMT,0) ,BLNG_SERV_COD\
E  from BL_PATIENT_CHARGES_FOLIO where (((((((EPISODE_TYPE=NVL(:b0,EPISODE_T\
YPE) and EPISODE_ID between NVL(:b1,'0') and NVL(:b2,'99999999')) and PATIEN\
T_ID between NVL(:b3,'!!!!!!!!!!!!!!!!!!!!') and NVL(:b4,'~~~~~~~~~~~~~~~~~~\
~~')) and TRUNC(SERVICE_DATE) between NVL(TO_DATE(:b5,'DD/MM/YYYY'),to_date(\
'00010101','YYYYDDMM')) and NVL(TO_DATE(:b6");
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )156;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_fm_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_episode_id;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_pat_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_pat_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_fm_serv_date;
    sqlstm.sqhstl[5] = (unsigned int  )37;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_serv_date;
    sqlstm.sqhstl[6] = (unsigned int  )37;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_fm_trx_date;
    sqlstm.sqhstl[7] = (unsigned int  )37;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_to_trx_date;
    sqlstm.sqhstl[8] = (unsigned int  )37;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[9] = (unsigned int  )12;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_rep_ord;
    sqlstm.sqhstl[10] = (unsigned int  )4;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
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
bl_pat_trx_date.arr[0]                                            = '\0';
bl_pat_trx_doc_ref.arr[0]                                         = '\0';
bl_pat_trx_doc_ref_line_num.arr[0]                                = '\0';
bl_pat_trx_doc_ref_seq_num.arr[0]                                 = '\0';
bl_pat_service_date.arr[0]                                        = '\0';
bl_pat_service_time.arr[0]                                        = '\0';
bl_pat_service_qty.arr[0]                                         = '\0';
bl_pat_upd_gross_charge_amt.arr[0]                                = '\0';
bl_pat_upd_disc_amt.arr[0]                                        = '\0';
bl_pat_upd_net_charge_amt.arr[0]                                  = '\0';
bl_pat_org_doc_ref.arr[0]                                         = '\0';
bl_pat_org_doc_ref_line_num.arr[0]                                = '\0';
bl_pat_org_doc_ref_seq_num.arr[0]                                 = '\0';
bl_pat_trx_status.arr[0]                                          = '\0';
bl_pat_rev_adj_ind.arr[0]                                         = '\0';
bl_pat_canadj_reason_text.arr[0]                                  = '\0';
bl_pat_modified_by.arr[0]                                         = '\0';
bl_pat_modified_date.arr[0]                                       = '\0';
bl_pat_blng_serv_code.arr[0]                                      = '\0';

bl_pat_episode_type.len                                           = 0;
bl_pat_episode_id.len                                             = 0;
bl_pat_visit_id.len                                               = 0;
bl_pat_patient_id.len                                             = 0;
bl_pat_trx_date.len                                               = 0;
bl_pat_trx_doc_ref.len                                            = 0;
bl_pat_trx_doc_ref_line_num.len                                   = 0;
bl_pat_trx_doc_ref_seq_num.len                                    = 0;
bl_pat_service_date.len                                           = 0;
bl_pat_service_time.len                                           = 0;
bl_pat_service_qty.len                                            = 0;
bl_pat_upd_gross_charge_amt.len                                   = 0;
bl_pat_upd_disc_amt.len                                           = 0;
bl_pat_upd_net_charge_amt.len                                     = 0;
bl_pat_org_doc_ref.len                                            = 0;
bl_pat_org_doc_ref_line_num.len                                   = 0;
bl_pat_org_doc_ref_seq_num.len                                    = 0;
bl_pat_trx_status.len                                             = 0;
bl_pat_rev_adj_ind.len                                            = 0;
bl_pat_canadj_reason_text.len                                     = 0;
bl_pat_modified_by.len                                            = 0;
bl_pat_modified_date.len                                          = 0;
bl_pat_blng_serv_code.len                                         = 0;

bl_pat_gross_charge_amt_db                                        = 0;
bl_pat_disc_amt_db                                                = 0;
bl_pat_net_charge_amt_db                                          = 0;

     /* EXEC SQL FETCH BL_PAT_CHG_FOLIO_CUR
               INTO :bl_pat_episode_type,
                    :bl_pat_episode_id,
                    :bl_pat_visit_id,
                    :bl_pat_patient_id,
                    :bl_pat_trx_date,
                    :bl_pat_service_date,
                    :bl_pat_service_time,
                    :bl_pat_trx_doc_ref,
                    :bl_pat_trx_doc_ref_line_num,
                    :bl_pat_trx_doc_ref_seq_num,
                    :bl_pat_service_qty,
                    :bl_pat_upd_gross_charge_amt,
                    :bl_pat_upd_disc_amt,
                    :bl_pat_upd_net_charge_amt,
                    :bl_pat_trx_status,
                    :bl_pat_rev_adj_ind,
                    :bl_pat_org_doc_ref,
                    :bl_pat_org_doc_ref_line_num,
                    :bl_pat_org_doc_ref_seq_num,
                    :bl_pat_canadj_reason_text,
                    :bl_pat_modified_by,
                    :bl_pat_modified_date,
                    :bl_pat_gross_charge_amt_db,
                    :bl_pat_disc_amt_db,
                    :bl_pat_net_charge_amt_db,
                    :bl_pat_blng_serv_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 26;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )215;
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
     sqlstm.sqhstv[4] = (         void  *)&bl_pat_trx_date;
     sqlstm.sqhstl[4] = (unsigned int  )15;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_pat_service_date;
     sqlstm.sqhstl[5] = (unsigned int  )15;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_pat_service_time;
     sqlstm.sqhstl[6] = (unsigned int  )8;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_pat_trx_doc_ref;
     sqlstm.sqhstl[7] = (unsigned int  )23;
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
     sqlstm.sqhstv[10] = (         void  *)&bl_pat_service_qty;
     sqlstm.sqhstl[10] = (unsigned int  )13;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_pat_upd_gross_charge_amt;
     sqlstm.sqhstl[11] = (unsigned int  )102;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_pat_upd_disc_amt;
     sqlstm.sqhstl[12] = (unsigned int  )102;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_pat_upd_net_charge_amt;
     sqlstm.sqhstl[13] = (unsigned int  )1005;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_pat_trx_status;
     sqlstm.sqhstl[14] = (unsigned int  )4;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_pat_rev_adj_ind;
     sqlstm.sqhstl[15] = (unsigned int  )4;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_pat_org_doc_ref;
     sqlstm.sqhstl[16] = (unsigned int  )23;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&bl_pat_org_doc_ref_line_num;
     sqlstm.sqhstl[17] = (unsigned int  )7;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&bl_pat_org_doc_ref_seq_num;
     sqlstm.sqhstl[18] = (unsigned int  )7;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&bl_pat_canadj_reason_text;
     sqlstm.sqhstl[19] = (unsigned int  )53;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&bl_pat_modified_by;
     sqlstm.sqhstl[20] = (unsigned int  )23;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&bl_pat_modified_date;
     sqlstm.sqhstl[21] = (unsigned int  )23;
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
     sqlstm.sqhstv[25] = (         void  *)&bl_pat_blng_serv_code;
     sqlstm.sqhstl[25] = (unsigned int  )13;
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
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
	bl_pat_trx_date.arr[bl_pat_trx_date.len]                                 = '\0';
	bl_pat_trx_doc_ref.arr[bl_pat_trx_doc_ref.len]                           = '\0';
	bl_pat_trx_doc_ref_line_num.arr[bl_pat_trx_doc_ref_line_num.len]         = '\0';
	bl_pat_trx_doc_ref_seq_num.arr[bl_pat_trx_doc_ref_seq_num.len]           = '\0';
	bl_pat_service_date.arr[bl_pat_service_date.len]                         = '\0';
	bl_pat_service_time.arr[bl_pat_service_time.len]                         = '\0';
	bl_pat_service_qty.arr[bl_pat_service_qty.len]                           = '\0';
	bl_pat_upd_gross_charge_amt.arr[bl_pat_upd_gross_charge_amt.len]         = '\0';
	bl_pat_upd_disc_amt.arr[bl_pat_upd_disc_amt.len]                         = '\0';
	bl_pat_upd_net_charge_amt.arr[bl_pat_upd_net_charge_amt.len]             = '\0';
	bl_pat_org_doc_ref.arr[bl_pat_org_doc_ref.len]                           = '\0';
	bl_pat_org_doc_ref_line_num.arr[bl_pat_org_doc_ref_line_num.len]         = '\0';
	bl_pat_org_doc_ref_seq_num.arr[bl_pat_org_doc_ref_seq_num.len]           = '\0';
	bl_pat_trx_status.arr[bl_pat_trx_status.len]                             = '\0';
	bl_pat_rev_adj_ind.arr[bl_pat_rev_adj_ind.len]                           = '\0';
	bl_pat_canadj_reason_text.arr[bl_pat_canadj_reason_text.len]             = '\0';
	bl_pat_modified_by.arr[bl_pat_modified_by.len]                           = '\0';
	bl_pat_modified_date.arr[bl_pat_modified_date.len]                       = '\0';
	bl_pat_blng_serv_code.arr[bl_pat_blng_serv_code.len]                     = '\0';

    return(LAST_ROW?0:1);
}

fetch_dtls()
{
   /* EXEC SQL OPEN BL_PAT_NAME_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 26;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0005;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )334;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_pat_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )23;
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
    sqlstm.arrsiz = 26;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )353;
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
sqlstm.arrsiz = 26;
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
sqlstm.offset = (unsigned int  )376;
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


}


print_rec(ind)
int ind;
{
  if (ind == 0)
  {
      if (lctr+2 > 51)
      {
        print_footer();
        print_head();
      }

      if (nd_rep_ord.arr[0] == 'T')
		if(bl_pat_trx_date.arr[0]!='\0')
		{
		init_date_temp_var1();                              
	    strcpy(date_convert1.arr,bl_pat_trx_date.arr);            
	    fun_change_loc_date1();
        fprintf(fp,"%8.8s   : %-10.10s\n",loc_legend[210],date_convert1.arr);

		}
      else
	  if(bl_pat_service_date.arr[0]!='\0')
	  {
		init_date_temp_var1();                              
	    strcpy(date_convert1.arr,bl_pat_service_date.arr);            
	    fun_change_loc_date1();
        fprintf(fp,"%9.9s  : %-10.10s\n",loc_legend[460],date_convert1.arr);

	  }
	  
     fprintf(fp,"\n");
     lctr+=2;
   }
   else
   {

     if (lctr+4 > 51)
     {
        print_footer();
        print_head();
     }

     fetch_dtls();
     if (nd_rep_ord.arr[0] == 'S')
	 {
		init_date_temp_var1();                              
		strcpy(date_convert1.arr,bl_pat_trx_date.arr);            
		fun_change_loc_date1();	
        fprintf(fp,"  %-10s ",date_convert1.arr);
		}		
     else
	 {
		init_date_temp_var1();                              
		strcpy(date_convert1.arr,bl_pat_service_date.arr);            
		fun_change_loc_date1();
        fprintf(fp,"  %-10s ",date_convert1.arr);
     fprintf(fp,"%-5s ",bl_pat_service_time.arr);
	 }		 
/*     fprintf(fp,"%-20s/%-4s/%-4s %s/%-8s/%-4s %s %s %s %s %s   %s\n",
                bl_pat_trx_doc_ref.arr,
                bl_pat_trx_doc_ref_line_num.arr,
                bl_pat_trx_doc_ref_seq_num.arr,
                bl_pat_episode_type.arr,
                bl_pat_episode_id.arr,
                bl_pat_visit_id.arr,
                bl_pat_service_qty.arr,
                bl_pat_upd_gross_charge_amt.arr,
                bl_pat_upd_disc_amt.arr,
                bl_pat_upd_net_charge_amt.arr,
                bl_pat_trx_status.arr,
                bl_pat_rev_adj_ind.arr);*/

     fprintf(fp,"%-20s/%-4s/%-4s %s/%-8s/%-4s %s  ",
                bl_pat_trx_doc_ref.arr,
                bl_pat_trx_doc_ref_line_num.arr,
                bl_pat_trx_doc_ref_seq_num.arr,
                bl_pat_episode_type.arr,
                bl_pat_episode_id.arr,
                bl_pat_visit_id.arr,
                bl_pat_service_qty.arr);
	print_formated(bl_pat_gross_charge_amt_db);
	fprintf(fp," ");
	print_formated(bl_pat_disc_amt_db);
	fprintf(fp," ");
	print_formated(bl_pat_net_charge_amt_db);

	fprintf(fp," %s   %s\n",bl_pat_trx_status.arr,bl_pat_rev_adj_ind.arr);
	    init_date_temp_var();                              
		strcpy(date_convert.arr,bl_pat_modified_date.arr);            
		fun_change_loc_date();
     fprintf(fp,"  %-20s %-29.29s %-42.42s %-20s %-16s\n",
                bl_pat_patient_id.arr,
                bl_patient_name.arr,
                bl_pat_canadj_reason_text.arr,
                bl_pat_modified_by.arr,
                date_convert.arr);
	
if(strlen(bl_patient_name1.arr) > 2)
{
 fprintf(fp,"%24s %s \n"," ",bl_patient_name1.arr);
 lctr++;
}


     if (bl_pat_org_doc_ref.len) 
       fprintf(fp,"      %-20s/%-4s/%-4s  %-10s %-40s\n\n",
                bl_pat_org_doc_ref.arr,
                bl_pat_org_doc_ref_line_num.arr,
                bl_pat_org_doc_ref_seq_num.arr,
		bl_pat_blng_serv_code.arr,
		d_blng_serv_desc.arr);
     else
       fprintf(fp,"      %-20s/%-4s/%-4s  %-10s %-40s\n\n",
                " ", " ", " ",
		bl_pat_blng_serv_code.arr,
		d_blng_serv_desc.arr);
  
     lctr+=4;
    
     if (bl_pat_rev_adj_ind.len) 
     {
       bl_pat_tot_gross_charge_amt += bl_pat_gross_charge_amt_db;
       bl_pat_tot_disc_amt         += bl_pat_disc_amt_db;
       bl_pat_tot_net_charge_amt   += bl_pat_net_charge_amt_db;
     }
   }
   fflush(fp);
}

print_date_tot()
{
    if (lctr+4 > 51)
    {
       print_footer();
       print_head();
    }

    fprintf(fp,"%78s--------------- --------------- ---------------\n"," ");
    fprintf(fp,"%43s%16s                    "," ",loc_legend[450]);
    print_formated(bl_pat_tot_gross_charge_amt); fprintf(fp," ");
    print_formated(bl_pat_tot_disc_amt); fprintf(fp," ");
    print_formated(bl_pat_tot_net_charge_amt);
    fprintf(fp,"\n");
    fprintf(fp,"%78s--------------- --------------- ---------------\n"," ");
    fprintf(fp,"\n");
    lctr +=4;

    bl_grn_tot_gross_charge_amt += bl_pat_tot_gross_charge_amt;
    bl_grn_tot_disc_amt         += bl_pat_tot_disc_amt;
    bl_grn_tot_net_charge_amt   += bl_pat_tot_net_charge_amt;

    bl_pat_tot_gross_charge_amt = 0;
    bl_pat_tot_disc_amt = 0;
    bl_pat_tot_net_charge_amt = 0;

}

print_grand_tot()
{
    print_date_tot();

    if (lctr+3 > 51)
    {
       print_footer();
       print_head();
    }

    fprintf(fp,"%78s--------------- --------------- ---------------\n"," ");
    fprintf(fp,"%43s%11s                         "," ",loc_legend[440]);
    print_formated(bl_grn_tot_gross_charge_amt); fprintf(fp," ");
    print_formated(bl_grn_tot_disc_amt); fprintf(fp," ");
    print_formated(bl_grn_tot_net_charge_amt);
    fprintf(fp,"\n");
    fprintf(fp,"%78s--------------- --------------- ---------------\n"," ");
    lctr +=3;

}

end_of_rep()
{
fprintf(fp,"\n\n                                                      ***  %-13s***\n",loc_legend[530]);
fflush(fp);
}

open_file()
{

    strcpy(filename,WORKING_DIR);
	strcat(filename,"blrbltra.lis");
    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrbltra.lis");
       proc_exit();
    }
    print_title();
    print_head();
}

print_title()
{
      init_date_temp_var();                            
	  strcpy(date_convert.arr,date_time.arr);           
	  fun_change_loc_date(); 
fprintf(fp,"\f%-3.3s : %2s                                         %-40.40s                                    %-16.16s\n",loc_legend[480],loc_legend[150],
hosp_name.arr,date_convert.arr);
fprintf(fp,"%-3.3s : %-10s \n",loc_legend[490],user_id.arr);
fprintf(fp,
"%-3.3s : %-8.8s                       %s                                   %4s : %4d\n",loc_legend[500],
loc_legend[40],loc_legend[50],loc_legend[30],++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        %-16.16s :\n        ----------------\n\n",loc_legend[470]);

	if(strcmp(nd_epi_type.arr,"I")==0)
	{
		fprintf(fp,"                  %12.12s         : %11s\n\n",loc_legend[80],loc_legend[90]);				
	}
	else if(strcmp(nd_epi_type.arr,"O")==0)
	{
		fprintf(fp,"                  %12.12s         : %12s\n\n",loc_legend[80],loc_legend[100]);
	}
	else if(strcmp(nd_epi_type.arr,"R")==0)
	{
		fprintf(fp,"                  %12.12s         : %8s\n\n",loc_legend[80],loc_legend[110]);
	}
        else if(strcmp(nd_epi_type.arr,"D")==0)
	{
		fprintf(fp,"                  %12.12s         : %8s\n\n",loc_legend[80],loc_legend[120]);
	}
        else if(strcmp(nd_epi_type.arr,"E")==0)
	{
		fprintf(fp,"                  %12.12s         : %9s\n\n",loc_legend[80],loc_legend[130]);
	}



	if(strcmp(nd_rep_ord.arr,"T")==0)
	{
		fprintf(fp,"                  %12.12s         : %16s\n\n",loc_legend[140],loc_legend[160]);
	}
	else if(strcmp(nd_rep_ord.arr,"S")==0)
	{
		fprintf(fp,"                  %12.12s         : %12s\n\n",loc_legend[140],loc_legend[170]);
	}

if(nd_fm_episode_id.arr[0] == '\0')
fprintf(fp,"                  %10s      %4s : %s\n",loc_legend[180],loc_legend[60],loc_legend[510]);
else
fprintf(fp,"                  %10s      %4s : %s\n",loc_legend[180],loc_legend[60],nd_fm_episode_id.arr);
if(nd_to_episode_id.arr[0] == '\0')
fprintf(fp,"                                  %2s   : %s\n\n",loc_legend[70],loc_legend[520]);
else
fprintf(fp,"                                  %2s   : %s\n\n",loc_legend[70],nd_to_episode_id.arr);
if(nd_fm_pat_id.arr[0] == '\0')
fprintf(fp,"                  %10s      %4s : %s\n",loc_legend[200],loc_legend[60],loc_legend[510]);
else
fprintf(fp,"                  %10s      %4s : %s\n",loc_legend[200],loc_legend[60],nd_fm_pat_id.arr);
if(nd_to_pat_id.arr[0] == '\0')
fprintf(fp,"                                  %2s   : %s\n\n",loc_legend[70],loc_legend[520]);
else
fprintf(fp,"                                  %2s   : %s\n\n",loc_legend[70],nd_to_pat_id.arr);

if(nd_fm_serv_date.arr[0] == '\0')
fprintf(fp,"                  %12s    %4s : %s\n",loc_legend[170],loc_legend[60],loc_legend[510]);
else
{
	 init_date_temp_var();                            
	 strcpy(date_convert1.arr,nd_fm_serv_date.arr);           
	 fun_change_loc_date1(); 
fprintf(fp,"                  %12s    %4s : %s\n",loc_legend[170],loc_legend[60],date_convert1.arr);
}

if(nd_to_serv_date.arr[0] == '\0')
fprintf(fp,"                                  %2s   : %s\n\n",loc_legend[70],loc_legend[520]);
else
{
	 init_date_temp_var();                            
	 strcpy(date_convert1.arr,nd_to_serv_date.arr);           
	 fun_change_loc_date1(); 
fprintf(fp,"                                  %2s   : %s\n\n",loc_legend[70],date_convert1.arr);
}

if(nd_fm_trx_date.arr[0] == '\0')
fprintf(fp,"                  %8s        %4s : %s\n",loc_legend[190],loc_legend[60],loc_legend[510]);
else
{
	 init_date_temp_var();                            
	 strcpy(date_convert1.arr,nd_fm_trx_date.arr);           
	 fun_change_loc_date1(); 
fprintf(fp,"                  %8s        %4s : %s\n",loc_legend[190],loc_legend[60],date_convert1.arr);
}

if(nd_to_trx_date.arr[0] == '\0')
fprintf(fp,"                                  %2s   : %s\n\n",loc_legend[70],loc_legend[520]);
else
{
	 init_date_temp_var();                            
	 strcpy(date_convert1.arr,nd_to_trx_date.arr);           
	 fun_change_loc_date1();
fprintf(fp,"                                  %2s   : %s\n\n",loc_legend[70],date_convert1.arr);
}

}


print_head()
{
      init_date_temp_var();                            
	  strcpy(date_convert.arr,date_time.arr);           
	  fun_change_loc_date(); 
fprintf(fp,
"\f%-3.3s : %2s                                         %-40.40s                                    %-16s\n",loc_legend[480],loc_legend[150],
hosp_name.arr,date_convert.arr);
fprintf(fp,"%-3.3s : %-10s \n",loc_legend[490],user_id.arr);
fprintf(fp,
"%-3.3s : %-8s                       %s                                   %4s : %4d\n",loc_legend[500],
loc_legend[40],loc_legend[50],loc_legend[30],++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
if (nd_rep_ord.arr[0] == 'S')
{
  fprintf(fp,
  "  %8.8s   %4.4s  %7.7s %8.8s               %15.15s    %8.8s           %5.5s            %4.4s             %11.11s\n",loc_legend[210],loc_legend[220],loc_legend[230],loc_legend[240],loc_legend[250],loc_legend[260],loc_legend[270],loc_legend[280],loc_legend[290]);
}
else
{
  fprintf(fp,
"  %14.14s   %7.7s %8.8s               %15.15s    %8.8s          %5.5s           %4.4s        %11.11s\n",loc_legend[300],loc_legend[230],loc_legend[240],loc_legend[250],loc_legend[260],loc_legend[270],loc_legend[280],loc_legend[290]);
}
fprintf(fp,
"  %-20.20s %18.18s        %30.30s                 %11.11s         %13.13s  \n",loc_legend[310],loc_legend[320],loc_legend[330],loc_legend[340],loc_legend[350]);
fprintf(fp,
"      %17.17s               %28.28s\n",loc_legend[360],loc_legend[370]);
/*
"      xxxxxxxxxxxxxxxxxxxx/xxxx/xxxx  xxxxxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
*/
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fflush(fp);
lctr = 12;
}

print_footer()
{

fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"%24.24s    ; %14.14s)\n",loc_legend[380],loc_legend[390]);
fprintf(fp,"%27.27s ; %13.13s; %14s; ",loc_legend[400],loc_legend[410],loc_legend[420]);
fprintf(fp,"%27.27s\n",loc_legend[430]);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");

fflush(fp);

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

    /* EXEC SQL SELECT ACC_ENTITY_NAME, 
					TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, 
					:date_time, 
					:user_id
               FROM SY_ACC_ENTITY_lang_vw
			  WHERE acc_entity_id = :d_facility_id
			  AND	language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 26;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (acc_entity_id=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )403;
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



       if (OERROR) 
			err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

		hosp_name.arr[hosp_name.len]           = '\0';
		date_time.arr[date_time.len]           = '\0';
		user_id.arr[user_id.len]               = '\0';
}

/*print_formated(loc_amount)
double loc_amount;
{
   char out_str[300],out_str1[300];

   if (loc_amount >= 0)
   {
      sprintf(out_str,"%15.2f",loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%15.2f",-loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s-",out_str1);
   }
}*/

print_formated(l_amt)
double l_amt;
{
	char  s_amt[50];

    if(l_amt < 0)
	{
        put_val(s_amt,-l_amt);
        format_amt(s_amt);
        strcat(s_amt,"-");  
		fprintf(fp,"%14s",s_amt);
    }
    else 
	{
        put_val(s_amt,l_amt);
        format_amt(s_amt);
        strcat(s_amt," ");
		fprintf(fp,"%14s",s_amt);
    }
}


fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRBLTRA.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 26;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRBLTRA.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )438;
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
  sqlstm.arrsiz = 26;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )461;
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
	
	  
	  :nd_loc_date :=sm_convert_datetime_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id);

       	//get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
	   //:nd_loc_date := to_char(t_date,'DD/MM/YYYY HH24:MI');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 26;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_datet\
ime_2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ;\
 END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )492;
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


get_local_date1()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date1  date;
	
	BEGIN
	
	  
	  :nd_loc_date1 :=sm_convert_date_2t(to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:p_language_id);
       	//get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date1,'DD/MON/RRRR HH24:MI'),:p_language_id,t_date1);  
      
	   //:nd_loc_date1 := to_char(t_date1,'DD/MM/RRRR');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 26;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date1 date ; BEGIN :nd_loc_date1 := sm_convert_dat\
e_2t ( to_date ( :nd_temp_date1 , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; \
END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )519;
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

init_date_temp_var1()
{
nd_temp_date1.arr[0] = '\0';
nd_loc_date1.arr[0]  = '\0';
date_convert1.arr[0] = '\0';

nd_temp_date1.len = 0;
nd_loc_date1.len  = 0;
date_convert1.len = 0;
}
                     

fun_change_loc_date1()
{

strcpy(nd_temp_date1.arr,date_convert1.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);


get_local_date1();

strcpy(date_convert1.arr,nd_loc_date1.arr); 

}