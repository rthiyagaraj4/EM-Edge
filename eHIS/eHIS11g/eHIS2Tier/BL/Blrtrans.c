
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blrtrans.pc"
};


static unsigned int sqlctx = 1288468915;


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
            void  *sqhstv[33];
   unsigned int   sqhstl[33];
            int   sqhsts[33];
            void  *sqindv[33];
            int   sqinds[33];
   unsigned int   sqharm[33];
   unsigned int   *sqharc[33];
   unsigned short  sqadto[33];
   unsigned short  sqtdso[33];
} sqlstm = {12,33};

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

 static const char *sq0007 = 
"select LONG_DESC  from BL_BLNG_PRT_GRP_LINE_lang_vw where ((PRT_GRP_HDR_CODE\
=:b0 and PRT_GRP_LINE_CODE=:b1) and language_id=:b2)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,180,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,326,0,4,224,0,0,18,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,
123,0,0,3,158,0,4,303,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
158,0,0,4,0,0,30,334,0,0,0,0,0,1,0,
173,0,0,5,91,0,2,342,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
196,0,0,6,0,0,17,411,0,0,1,1,0,1,0,1,9,0,0,
215,0,0,6,0,0,45,430,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
282,0,0,6,0,0,13,822,0,0,33,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,
2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,1,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
429,0,0,8,188,0,4,906,0,0,4,2,0,1,0,2,9,0,0,2,1,0,0,1,9,0,0,1,9,0,0,
460,0,0,7,139,0,9,943,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
487,0,0,7,0,0,13,948,0,0,1,0,0,1,0,2,9,0,0,
506,0,0,9,96,0,4,1217,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
529,0,0,10,165,0,6,1224,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
560,0,0,11,140,0,6,1246,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
587,0,0,12,143,0,6,1317,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/*****************************************************************************/
/*                           BLRTRANS.PC                                     */
/*****************************************************************************/
/* Modified by : VSK -- For BLENH Purpose  18/12/2000						 */
/* Modified by : VSK -- For BLENH Purpose  23/01/2001 TO DISPLAY K RECS 	 */
/*****************************************************************************/
                                      
/*   
#define DEBUG           
*/       
  
#define INIT_MESG "Report Generation In Progress"
#include <stdio.h>
#include <string.h>
#include "gl.h"
#include "bl.h"  

#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define RESOURCE_BUSY (sqlca.sqlcode == -54)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)


 
 
 /* EXEC SQL BEGIN DECLARE SECTION; */ 


    
	/* VARCHAR uid_pwd[41],
	        d_session_id[16],
	        d_pgm_date[14],
            rep_date[20],
            comp_name[50],
            oper_id[21],
			d_facility_id [3],
			nd_facility_id[3],
			nd_temp_date[21],
			nd_temp_date1[21],
			p_language_id[3],
			date_convert[21],
			date_convert1[21],
			nd_loc_date[21],
			nd_loc_date1[21],
	        d_pgm_id[10]; */ 
struct { unsigned short len; unsigned char arr[41]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[3]; } d_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } date_convert1;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[10]; } d_pgm_id;

 
    /* VARCHAR trans_date           [11],
			trans_date_fm		 [17],
			trans_date_to        [17],
	        prt_grp_fm           [6],          
            prt_line_fm          [4],
            prt_grp_to           [6],
            prt_line_to          [4],
            serv_code_fm         [11],
            serv_code_to         [11],  
            nd_rep_opt           [2],
            nd_rep_type          [2],
			l_fm_patient_id		 [21],	
			l_to_patient_id		 [21],
			l_transaction_type	 [3],
			l_confirm_yn		 [3]; */ 
struct { unsigned short len; unsigned char arr[11]; } trans_date;

struct { unsigned short len; unsigned char arr[17]; } trans_date_fm;

struct { unsigned short len; unsigned char arr[17]; } trans_date_to;

struct { unsigned short len; unsigned char arr[6]; } prt_grp_fm;

struct { unsigned short len; unsigned char arr[4]; } prt_line_fm;

struct { unsigned short len; unsigned char arr[6]; } prt_grp_to;

struct { unsigned short len; unsigned char arr[4]; } prt_line_to;

struct { unsigned short len; unsigned char arr[11]; } serv_code_fm;

struct { unsigned short len; unsigned char arr[11]; } serv_code_to;

struct { unsigned short len; unsigned char arr[2]; } nd_rep_opt;

struct { unsigned short len; unsigned char arr[2]; } nd_rep_type;

struct { unsigned short len; unsigned char arr[21]; } l_fm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } l_to_patient_id;

struct { unsigned short len; unsigned char arr[3]; } l_transaction_type;

struct { unsigned short len; unsigned char arr[3]; } l_confirm_yn;


    /* VARCHAR d_trx_doc_ref              [21],
            d_episode_type             [2],
			d_episode_id               [9],
	    	d_visit_id                 [5],
            d_patient_id               [21],
			d_trx_doc_ref_line_num     [5],
			d_trx_doc_ref_seq_num      [5],
            d_prt_grp_hdr_code         [3],
            d_prt_grp_line_code        [3],
            d_package_ind              [2],
            d_package_service_code     [11],
            d_blng_serv_code           [11],
            d_prt_blng_serv_code       [11],
            d_blng_serv_desc           [41],
            d_package_trx_ind          [2],
            d_service_date             [20],
            d_blng_grp_id              [5],
            d_blng_class_code          [3],
            d_bed_class_code           [3],
            d_bill_type_code           [3],
            d_added_by_id              [21],
            d_canadj_reason_text       [51],
            d_serv_item_desc           [41],
            d_serv_item_code           [12],
			d_folio_remarks            [17]; */ 
struct { unsigned short len; unsigned char arr[21]; } d_trx_doc_ref;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[5]; } d_trx_doc_ref_line_num;

struct { unsigned short len; unsigned char arr[5]; } d_trx_doc_ref_seq_num;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[2]; } d_package_ind;

struct { unsigned short len; unsigned char arr[11]; } d_package_service_code;

struct { unsigned short len; unsigned char arr[11]; } d_blng_serv_code;

struct { unsigned short len; unsigned char arr[11]; } d_prt_blng_serv_code;

struct { unsigned short len; unsigned char arr[41]; } d_blng_serv_desc;

struct { unsigned short len; unsigned char arr[2]; } d_package_trx_ind;

struct { unsigned short len; unsigned char arr[20]; } d_service_date;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } d_blng_class_code;

struct { unsigned short len; unsigned char arr[3]; } d_bed_class_code;

struct { unsigned short len; unsigned char arr[3]; } d_bill_type_code;

struct { unsigned short len; unsigned char arr[21]; } d_added_by_id;

struct { unsigned short len; unsigned char arr[51]; } d_canadj_reason_text;

struct { unsigned short len; unsigned char arr[41]; } d_serv_item_desc;

struct { unsigned short len; unsigned char arr[12]; } d_serv_item_code;

struct { unsigned short len; unsigned char arr[17]; } d_folio_remarks;


    /* VARCHAR d_prev_episode_type        [2],
			d_prev_prt_grp_hdr_code    [6],
			d_prev_prt_grp_line_code   [4],
			d_prev_blng_serv_grp       [3],
			l_pk_value		           [100],
		    l_translated_value	       [201]; */ 
struct { unsigned short len; unsigned char arr[2]; } d_prev_episode_type;

struct { unsigned short len; unsigned char arr[6]; } d_prev_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[4]; } d_prev_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[3]; } d_prev_blng_serv_grp;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

    /* VARCHAR d_prt_grp_line_desc        [41]; */ 
struct { unsigned short len; unsigned char arr[41]; } d_prt_grp_line_desc;


   double   d_serv_qty;

   char     d_trx_status,
			d_rev_adj_trx_ind,
			d_misc_serv_yn,
			explode_pkg;

	char    l_mesg[500];
	char loc_legend[999][201];
	int i;	
   double   d_base_charge_amt,
            d_upd_gross_charge_amt,
            d_upd_disc_amt,
            d_upd_net_charge_amt,
            d_addl_factor_num;

    /* VARCHAR d_curs [2000]; */ 
struct { unsigned short len; unsigned char arr[2000]; } d_curs;


	/* VARCHAR m_ins_pat_ind[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } m_ins_pat_ind;


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

#define REP_WIDTH 237
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+9];

char rep_title[100];

FILE *f1;

int page_no,
    line_no,
    first_line,
    g_count;

char filename[150];

double g_srv_base_amt,
       g_srv_gross_amt,
       g_srv_disc_amt,
       g_srv_net_amt,

       g_prt_base_amt,
       g_prt_gross_amt,
       g_prt_disc_amt,
       g_prt_net_amt,

       g_epi_base_amt,
       g_epi_gross_amt,
       g_epi_disc_amt,
       g_epi_net_amt,

       g_tot_base_amt,
       g_tot_gross_amt,
       g_tot_disc_amt,
       g_tot_net_amt;

void proc_main(argc,argv)
int argc;
char *argv[];
{

    if(argc  < 5) {
        disp_message(ERR_MESG,"Usage BLRTRANS userid/password session_id pgm_date facility_id");
        proc_exit();
    }


    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

    /* EXEC SQL CONNECT :uid_pwd; */ 

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
    sqlstm.sqlcmax = (unsigned int )100;
    sqlstm.sqlcmin = (unsigned int )2;
    sqlstm.sqlcincr = (unsigned int )1;
    sqlstm.sqlctimeout = (unsigned int )0;
    sqlstm.sqlcnowait = (unsigned int )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR) 
	{
		disp_message(ORA_MESG,"Unable to connect to oracle.");
		proc_exit();
    }

	set_meduser_role();
	strcpy(p_language_id.arr,l_language_id.arr);
    p_language_id.len = l_language_id.len;


    trans_date.arr[0]    = '\0';
	trans_date_fm.arr[0]    = '\0';
	trans_date_to.arr[0]    = '\0';
    prt_grp_fm.arr[0]    = '\0';
    prt_line_fm.arr[0]   = '\0';
    prt_grp_to.arr[0]    = '\0';
    prt_line_to.arr[0]   = '\0';
    serv_code_fm.arr[0]  = '\0';
    serv_code_to.arr[0]  = '\0';
    nd_rep_opt.arr[0]    = '\0';
    nd_rep_type.arr[0]   = '\0';

	l_fm_patient_id.arr[0]    = '\0';
	l_to_patient_id.arr[0]    = '\0';
	l_transaction_type.arr[0] = '\0';
	d_facility_id.arr[0]      = '\0';

    trans_date.len     = 0;
	trans_date_fm.len     = 0;
	trans_date_to.len     = 0;
    prt_grp_fm.len     = 0;
    prt_line_fm.len    = 0;
    prt_grp_to.len     = 0;
    prt_line_to.len    = 0;
    serv_code_fm.len   = 0;
    serv_code_to.len   = 0;
    nd_rep_opt.len     = 0;
    nd_rep_type.len    = 0;

    explode_pkg        = '\0';

	/* EXEC SQL SELECT PARAM1,
			PARAM2,
			PARAM3,
			PARAM4,
			PARAM5,
			PARAM6,
			PARAM7,
			PARAM8,
			PARAM9,
			PARAM10,
			PARAM11,
			PARAM12,
			param13,--Added for HMC cust.
			param14,
			param15,
			operating_facility_id
	 INTO   :trans_date,
            :prt_grp_fm,
            :prt_line_fm,
            :prt_grp_to,
            :prt_line_to,
            :serv_code_fm,
            :serv_code_to,
            :nd_rep_opt,
            :nd_rep_type,
			:explode_pkg,
			:trans_date_fm,
			:trans_date_to,
			:l_fm_patient_id,
			:l_to_patient_id,
			:l_transaction_type,
			:d_facility_id
	 FROM   SY_PROG_PARAM
	WHERE   PGM_ID     = 'BLRTRANS'
	  AND   PGM_DATE   = :d_pgm_date
	  AND   SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PARAM\
7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,param13 ,param14 ,param15 ,opera\
ting_facility_id into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:\
b13,:b14,:b15  from SY_PROG_PARAM where ((PGM_ID='BLRTRANS' and PGM_DATE=:b16)\
 and SESSION_ID=TO_NUMBER(:b17))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&trans_date;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&prt_grp_fm;
 sqlstm.sqhstl[1] = (unsigned int  )8;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&prt_line_fm;
 sqlstm.sqhstl[2] = (unsigned int  )6;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&prt_grp_to;
 sqlstm.sqhstl[3] = (unsigned int  )8;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&prt_line_to;
 sqlstm.sqhstl[4] = (unsigned int  )6;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&serv_code_fm;
 sqlstm.sqhstl[5] = (unsigned int  )13;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&serv_code_to;
 sqlstm.sqhstl[6] = (unsigned int  )13;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_rep_opt;
 sqlstm.sqhstl[7] = (unsigned int  )4;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_rep_type;
 sqlstm.sqhstl[8] = (unsigned int  )4;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&explode_pkg;
 sqlstm.sqhstl[9] = (unsigned int  )1;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&trans_date_fm;
 sqlstm.sqhstl[10] = (unsigned int  )19;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&trans_date_to;
 sqlstm.sqhstl[11] = (unsigned int  )19;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&l_fm_patient_id;
 sqlstm.sqhstl[12] = (unsigned int  )23;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&l_to_patient_id;
 sqlstm.sqhstl[13] = (unsigned int  )23;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&l_transaction_type;
 sqlstm.sqhstl[14] = (unsigned int  )5;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[15] = (unsigned int  )5;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[16] = (unsigned int  )16;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&d_session_id;
 sqlstm.sqhstl[17] = (unsigned int  )18;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
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

    trans_date.arr[trans_date.len]     = '\0';
	trans_date_fm.arr[trans_date_fm.len]     = '\0';
	trans_date_to.arr[trans_date_to.len]     = '\0';
    prt_grp_fm.arr[prt_grp_fm.len]     = '\0';
    prt_line_fm.arr[prt_line_fm.len]   = '\0';
    prt_grp_to.arr[prt_grp_to.len]     = '\0';
    prt_line_to.arr[prt_line_to.len]   = '\0';
    serv_code_fm.arr[serv_code_fm.len] = '\0';
    serv_code_to.arr[serv_code_to.len] = '\0';
    nd_rep_opt.arr[nd_rep_opt.len]     = '\0';
    nd_rep_type.arr[nd_rep_type.len]   = '\0';

	l_fm_patient_id.arr[l_fm_patient_id.len]		= '\0';
	l_to_patient_id.arr[l_to_patient_id.len]		= '\0';
	l_transaction_type.arr[l_transaction_type.len]	= '\0';
	d_facility_id.arr[d_facility_id.len]			= '\0';


	strcpy(g_facility_id,d_facility_id.arr);

 // strcpy(file_name,"blrtrans.lis");
    strcpy(filename,WORKING_DIR);
    strcat(filename,"blrtrans.lis");

    //strcpy(rep_title,"TRANSCATION LIST OF : ");
	
	/*strcpy(rep_title,loc_legend[640]);
	disp_message(ERR_MESG,rep_title);
	init_date_temp_var();
	strcpy(date_convert.arr,trans_date.arr);
	fun_change_loc_date();
    strcat(rep_title,date_convert.arr);*/

    if( (f1=fopen(filename,"w")) == NULL) 
	{
        disp_message(ERR_MESG,"Error in opening output file...");
		proc_exit();
    }

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
					TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
			 INTO   :comp_name,
					:rep_date,
					:oper_id
			 FROM   SY_ACC_ENTITY_LANG_VW
			WHERE   acc_entity_id = :d_facility_id
			AND		language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (acc_entity_id=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )123;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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

    comp_name.arr[comp_name.len]	= '\0';
    rep_date.arr[rep_date.len]		= '\0';
    oper_id.arr[oper_id.len]		= '\0';

    page_no	=	1;
    line_no	=	1;
	fetch_legend_value();

    decl_curs();

    put_inp_parm();

    do_report();

    fclose(f1);

    del_parm();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )158;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    return;
}

del_parm()
{

    /* EXEC SQL DELETE SY_PROG_PARAM
         WHERE  PGM_ID     = 'BLRTRANS' 
         AND    PGM_DATE   = :d_pgm_date
         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRTRANS' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )173;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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

    strcpy(d_curs.arr," SELECT TRX_DOC_REF, TRX_DOC_REF_LINE_NUM, \
    TRX_DOC_REF_SEQ_NUM, EPISODE_TYPE, PATIENT_ID, EPISODE_ID, \
    VISIT_ID, PRT_GRP_HDR_CODE, PRT_GRP_LINE_CODE, PACKAGE_IND, \
    PACKAGE_SERVICE_CODE, BLNG_SERV_CODE, PACKAGE_TRX_IND,SERV_QTY, \
    BASE_CHARGE_AMT, UPD_GROSS_CHARGE_AMT, UPD_DISC_AMT, UPD_NET_CHARGE_AMT, \
    TO_CHAR(SERVICE_DATE,'DD/MM/YYYY HH24:MI'), BLNG_GRP_ID, \
    BLNG_CLASS_CODE, ADDL_FACTOR_NUM, BED_CLASS_CODE, BILL_TYPE_CODE, \
    ADDED_BY_ID,TRX_STATUS,REV_ADJ_TRX_IND,CANADJ_REASON_TEXT , \
    SUBSTR(SERV_ITEM_CODE,1,10), SERV_ITEM_DESC, \
	INS_PKG_PAT_IND, \
	DECODE(NVL(CONFIRMED_YN,'N'),'Y','C','N','I'), \
    SUBSTR(FOLIO_REMARKS,1,16) FROM BL_PATIENT_CHARGES_FOLIO \
    WHERE TRX_DATE BETWEEN TO_DATE(:l_fm_trans_date,'DD/MM/YYYY HH24:MI') \
	AND TO_DATE(:l_to_trans_date,'DD/MM/YYYY HH24:MI') \
    AND     TRX_FINALIZE_IND = 'Y' \
    AND     RPAD(PRT_GRP_HDR_CODE,2,' ')||PRT_GRP_LINE_CODE BETWEEN  \
    	    RPAD(NVL(:l_prt_grp_fm,'!!'),2,' ')||NVL(:l_prt_line_fm,'!!') \
	        AND \
	    RPAD(NVL(:l_prt_grp_to,'~~'),2,' ')||NVL(:l_prt_line_to,'~~') \
    AND     BLNG_SERV_CODE BETWEEN NVL(:l_serv_code_fm,'!!!!!!')  \
	    AND NVL(:l_serv_code_to,'~~~~~~') \
	AND patient_id BETWEEN NVL(:l_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!') \
	                   AND NVL(:l_to_patient_id,'~~~~~~~~~~~~~~~~~~~~') \
	AND NVL(confirmed_yn,'N') = decode(:l_transaction_type,'C','Y','I','N','B',NVL(confirmed_yn,'N')) \
	AND NVL(operating_facility_id,'X') = NVL(:d_facility_id,'X')\
    AND     ( (:explode_pkg = 'Y' AND NVL(PACKAGE_TRX_IND,'X')  = 'N') OR \
	      (:explode_pkg = 'N' AND  \
	          ( NVL(PACKAGE_IND,'X')      = 'S' OR \
	           ( NVL(PACKAGE_TRX_IND,'X')  = 'Y' AND \
	             NVL(PACKAGE_IND,'X')      = 'P' \
	           ) OR \
			   ( AVAILED_IND IN('U','Y') \ )))) ");


    if(nd_rep_type.arr[0] == 'A')   
    {
       strcat(d_curs.arr,
       " AND (TRX_STATUS IS NOT NULL AND REV_ADJ_TRX_IND IS NOT NULL) ");
    }

    strcat(d_curs.arr,
     "ORDER BY EPISODE_TYPE,PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE, \
	   SUBSTR(BLNG_SERV_CODE,1,2),");

    if(nd_rep_opt.arr[0] == '1') 
	strcat(d_curs.arr,"EPISODE_ID");
    else
	strcat(d_curs.arr,"TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,TRX_DOC_REF_SEQ_NUM");

    d_curs.len = strlen(d_curs.arr);

	//sprintf(l_mesg,"%s",d_curs.arr);
	//disp_message(ERR_MESG,l_mesg);


    /* EXEC SQL PREPARE TRANS_LIST FROM :d_curs; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )196;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_curs;
    sqlstm.sqhstl[0] = (unsigned int  )2002;
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
		err_mesg("PREPARE failed on TRANS_LIST",0,"");
	

    /* EXEC SQL DECLARE TRANS_LIST_CUR CURSOR FOR TRANS_LIST; */ 



    if(OERROR)
	err_mesg("DECLARE failed on TRANS_LIST_CUR",0,"");

    /* EXEC SQL DECLARE PRT_GRP_LINE_CUR CURSOR FOR
	     SELECT  LONG_DESC 
	     FROM    BL_BLNG_PRT_GRP_LINE_lang_vw
	     WHERE   PRT_GRP_HDR_CODE  = :d_prt_grp_hdr_code
		 AND     PRT_GRP_LINE_CODE = :d_prt_grp_line_code
		 AND	 language_id=:p_language_id; */ 


   /* EXEC SQL OPEN TRANS_LIST_CUR USING
                 :trans_date_fm,
				 :trans_date_to,
	             :prt_grp_fm,
                 :prt_line_fm,
                 :prt_grp_to,
                 :prt_line_to,
                 :serv_code_fm,
                 :serv_code_to,
				 :l_fm_patient_id,
				 :l_to_patient_id,
				 :l_transaction_type,
				 :d_facility_id,
		         :explode_pkg; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 18;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )215;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&trans_date_fm;
   sqlstm.sqhstl[0] = (unsigned int  )19;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&trans_date_to;
   sqlstm.sqhstl[1] = (unsigned int  )19;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&prt_grp_fm;
   sqlstm.sqhstl[2] = (unsigned int  )8;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&prt_line_fm;
   sqlstm.sqhstl[3] = (unsigned int  )6;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&prt_grp_to;
   sqlstm.sqhstl[4] = (unsigned int  )8;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&prt_line_to;
   sqlstm.sqhstl[5] = (unsigned int  )6;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&serv_code_fm;
   sqlstm.sqhstl[6] = (unsigned int  )13;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&serv_code_to;
   sqlstm.sqhstl[7] = (unsigned int  )13;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_fm_patient_id;
   sqlstm.sqhstl[8] = (unsigned int  )23;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&l_to_patient_id;
   sqlstm.sqhstl[9] = (unsigned int  )23;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&l_transaction_type;
   sqlstm.sqhstl[10] = (unsigned int  )5;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[11] = (unsigned int  )5;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&explode_pkg;
   sqlstm.sqhstl[12] = (unsigned int  )1;
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







    if(OERROR)
	err_mesg("OPEN failed on cursor TRANS_LIST_CUR",0,"");


}


do_report()
{

    int cnt,hdr_cnt,first;

    int episode_change,prt_grp_change;


    hdr_cnt=0;
    line_no = 1;
    g_count = 1;
    put_hdr();

    init_prev_values();
    init_srv_totals();
    init_prt_totals();
    init_epi_totals();
    init_grand_totals();

    first = 1;

    while(fetch_trans_list()) 
	{
		episode_change = 0;
		prt_grp_change = 0;

		if(episode_brk()) 
		{
			if(!first) 
			{
				print_srv_totals();
				print_prt_totals();
				print_epi_totals();
				chk_break(56);
			}

			chk_break(1);
			fprintf(f1,"    %-17.17s       : %s\n\n",loc_legend[220],d_episode_type.arr);
            
			line_no +=2;
			chk_break(1);
			fetch_prt_line_desc();
			fprintf(f1,"%9.9s %-14.14s    : %5s/%3s  %-40s\n\n",loc_legend[130],loc_legend[140],d_prt_grp_hdr_code.arr, d_prt_grp_line_code.arr,d_prt_grp_line_desc.arr);

			line_no += 2;

			episode_change = 1;

		} /* end of episode break */

		if(prt_grp_line_brk()) 
		{
			if(!first && !episode_change) 
			{
				print_srv_totals();
				print_prt_totals();
			}

			if(!episode_change) 
			{
				chk_break(1);
				fetch_prt_line_desc();
				line_no = 1;
				g_count = 1;
				++page_no;
				put_hdr();
				fprintf(f1,"%9.9s %-14.14s    : %5s/%3s  %-40s\n\n",loc_legend[130],loc_legend[140],d_prt_grp_hdr_code.arr, d_prt_grp_line_code.arr,d_prt_grp_line_desc.arr);

				line_no += 2;
			}

			prt_grp_change = 1;

		} /* end of prt_grp_line_brk() */

		if(blng_serv_grp_brk()) 
		{
			if(!first && !prt_grp_change)
			{
				/*	The following if condition has been put to avoid unnecessary 
					zero total without any transaction at the time of control break of
					episode type and service group together.  VSK 27/12/1998  */

				if (g_srv_gross_amt != 0 || g_srv_disc_amt != 0 || g_srv_net_amt != 0)
				{
					print_srv_totals();
				}
			}

		} /* end of if blng_serv_grp_brk() */

		first = 0;
		hdr_cnt = 1;

		print_rec();

		g_srv_base_amt   += d_base_charge_amt;
		g_srv_gross_amt  += d_upd_gross_charge_amt;
		g_srv_disc_amt   += d_upd_disc_amt;
		g_srv_net_amt    += d_upd_net_charge_amt;

		g_prt_base_amt   += d_base_charge_amt;
		g_prt_gross_amt  += d_upd_gross_charge_amt;
		g_prt_disc_amt   += d_upd_disc_amt;
		g_prt_net_amt    += d_upd_net_charge_amt;

		g_epi_base_amt   += d_base_charge_amt;
		g_epi_gross_amt  += d_upd_gross_charge_amt;
		g_epi_disc_amt   += d_upd_disc_amt;
		g_epi_net_amt    += d_upd_net_charge_amt;

		g_tot_base_amt   += d_base_charge_amt;
		g_tot_gross_amt  += d_upd_gross_charge_amt;
		g_tot_disc_amt   += d_upd_disc_amt;
		g_tot_net_amt    += d_upd_net_charge_amt;

		copy_val();

    } /* end of while fetch trans list */

    if(hdr_cnt) 
	{
		print_srv_totals();
		print_prt_totals();
		print_epi_totals();
		print_grand_totals();
    }

    print_end_of_rep();

}

print_rec()
{

    char s_base_amt[20], s_gross_amt[20], s_disc_amt[20], s_net_amt[20];
    char s_status;


    if(d_rev_adj_trx_ind)
	s_status = d_rev_adj_trx_ind;
    else
	s_status = d_trx_status;

    print_formated(s_base_amt,  d_base_charge_amt);
    print_formated(s_gross_amt, d_upd_gross_charge_amt);
    print_formated(s_disc_amt,  d_upd_disc_amt);
    print_formated(s_net_amt,   d_upd_net_charge_amt);


    chk_break(1);  
	init_date_temp_var();
	strcpy(date_convert1.arr,d_service_date.arr);
	fun_change_loc_date1();
	//fprintf(f1,"%-8s %4s %-20s %-2s %-2s  %1s %-10s %-40s %-18s %7.2lf %2.4lf %1s %-16s %14s %14s %14s %-21s  %c   %c  %-8s    %1s\n",
      fprintf(f1,"%-8s %4s %-20s %-4s %-2s  %1s    %-10s %-37.37s %-16s %7.2lf %2.4lf %2s %-16s %14s %14s %14s %-21s  %c   %c  %-8s    %1s\n",
	    d_episode_id.arr, d_visit_id.arr, d_patient_id.arr, 
	    d_blng_grp_id.arr, d_bed_class_code.arr, d_package_ind.arr,
	    d_prt_blng_serv_code.arr, d_blng_serv_desc.arr,date_convert1.arr, 
            d_serv_qty,d_addl_factor_num,m_ins_pat_ind.arr, d_folio_remarks.arr, s_gross_amt, 
	    s_disc_amt, s_net_amt, d_trx_doc_ref.arr,d_trx_status,
	    d_rev_adj_trx_ind, d_added_by_id.arr,l_confirm_yn.arr);
	
    if(d_canadj_reason_text.len)
    {
      fprintf(f1,"%-50s\n",d_canadj_reason_text.arr);
      line_no ++;
    }

    line_no ++;


/*
    fprintf(fp,"99999999 9999 XXXXXXXXXX XX XX  X   XXXXXX  DD/MM/YY HH:MI 999 99.9999 999,999,999.99 999,999,999.99 999,999,999.99 999,999,999.99 XXXXXXXXXXXXXXXXXXXX/XXXX/XXXX  XXXXXXXXXX");
*/

}

print_srv_totals()
{
    char s_base_amt[20], s_gross_amt[20], s_disc_amt[20], s_net_amt[20];
    

    print_formated(s_base_amt,  g_srv_base_amt);
    print_formated(s_gross_amt, g_srv_gross_amt);
    print_formated(s_disc_amt,  g_srv_disc_amt);
    print_formated(s_net_amt,   g_srv_net_amt);
    
	

    chk_break(3);

      
    fprintf(f1,"                                                           ");
    fprintf(f1,"                                                          ");
    fprintf(f1,"                             ----------------------------------------------\n");
    fprintf(f1,"                                            ");
    fprintf(f1,"                                   %17.17s %-19.19s %-9.9s       :  %s          %14s %14s %14s\n",loc_legend[210],loc_legend[110],loc_legend[230],
        d_prev_blng_serv_grp.arr,s_gross_amt, s_disc_amt, s_net_amt);
    fprintf(f1,"                                                           ");
    fprintf(f1,"                                                          ");
    fprintf(f1,"                             ==============================================\n\n");

    line_no += 4;
	
    init_srv_totals();
}

print_prt_totals()
{
    char s_base_amt[20], s_gross_amt[20], s_disc_amt[20], s_net_amt[20];


    print_formated(s_base_amt,  g_prt_base_amt);
    print_formated(s_gross_amt, g_prt_gross_amt);
    print_formated(s_disc_amt,  g_prt_disc_amt);
    print_formated(s_net_amt,   g_prt_net_amt);



    chk_break(3);


    fprintf(f1,"                                                           ");
    fprintf(f1,"                                                          ");
    fprintf(f1,"                             ----------------------------------------------\n");
    fprintf(f1,"                                            ");
    fprintf(f1,"                                   %17.17s %-9.9s %-14.14s            :              %14s %14s %14s\n",loc_legend[210],loc_legend[130],loc_legend[140],
                s_gross_amt, s_disc_amt, s_net_amt);
    fprintf(f1,"                                                           ");
    fprintf(f1,"                                                          ");
    fprintf(f1,"                             ==============================================\n\n");

    line_no += 4;


    init_prt_totals();

}

print_epi_totals()
{
    char s_base_amt[20], s_gross_amt[20], s_disc_amt[20], s_net_amt[20];


    print_formated(s_base_amt,  g_epi_base_amt);
    print_formated(s_gross_amt, g_epi_gross_amt);
    print_formated(s_disc_amt,  g_epi_disc_amt);
    print_formated(s_net_amt,   g_epi_net_amt);

    chk_break(3);
    

	fprintf(f1,"                                                           ");
    fprintf(f1,"                                                          ");
    fprintf(f1,"                             ----------------------------------------------\n");
    fprintf(f1,"                                            ");
    fprintf(f1,"                                       %-17.17s                                 :              %14s %14s %14s\n",loc_legend[200],
                s_gross_amt, s_disc_amt, s_net_amt);
    fprintf(f1,"                                                           ");
    fprintf(f1,"                                                          ");
    fprintf(f1,"                             ==============================================\n\n");

    line_no += 4;


    init_epi_totals();
}

print_grand_totals()
{
    char s_base_amt[20], s_gross_amt[20], s_disc_amt[20], s_net_amt[20];

	 
    print_formated(s_base_amt,  g_tot_base_amt);
    print_formated(s_gross_amt, g_tot_gross_amt);
    print_formated(s_disc_amt,  g_tot_disc_amt);
    print_formated(s_net_amt,   g_tot_net_amt);



    chk_break(3);


    fprintf(f1,"                                                           ");
    fprintf(f1,"                                                          ");
    fprintf(f1,"                             ----------------------------------------------\n");
    fprintf(f1,"                                            ");
    fprintf(f1,"                                       %-15.15s                                   :              %14s %14s %14s\n",loc_legend[190],
                s_gross_amt, s_disc_amt, s_net_amt);
    fprintf(f1,"                                                           ");
    fprintf(f1,"                                                          ");
    fprintf(f1,"                             ==============================================\n\n");


    line_no += 4;

}

fetch_trans_list()
{
	m_ins_pat_ind.arr[0] = '\0';
    d_trx_doc_ref.arr[0]  = '\0';
    d_episode_type.arr[0]  = '\0';
    d_episode_id.arr[0]  = '\0';
    d_visit_id.arr[0]  = '\0';
    d_patient_id.arr[0]  = '\0';
    d_trx_doc_ref_line_num.arr[0]  = '\0';
    d_trx_doc_ref_seq_num.arr[0]  = '\0';
    d_prt_grp_hdr_code.arr[0]  = '\0';
    d_prt_grp_line_code.arr[0]  = '\0';
    d_package_ind.arr[0]  = '\0';
    d_package_service_code.arr[0]  = '\0';
    d_blng_serv_code.arr[0]  = '\0';
    d_prt_blng_serv_code.arr[0]  = '\0';
    d_package_trx_ind.arr[0]  = '\0';
    d_service_date.arr[0]  = '\0';
    d_blng_grp_id.arr[0]  = '\0';
    d_blng_class_code.arr[0]  = '\0';
    d_bed_class_code.arr[0]  = '\0';
    d_bill_type_code.arr[0]  = '\0';
    d_added_by_id.arr[0]  = '\0';
    d_canadj_reason_text.arr[0]  = '\0';
    d_serv_item_code.arr[0]  = '\0';
    d_serv_item_desc.arr[0]  = '\0';
    d_folio_remarks.arr[0]  = '\0';
	l_confirm_yn.arr[0]	   = '\0';	

    d_trx_status       = '\0';
    d_rev_adj_trx_ind  = '\0';

	m_ins_pat_ind.len = 0;
    d_trx_doc_ref.len     = 0;
    d_episode_type.len     = 0;
    d_episode_id.len     = 0;
    d_visit_id.len     = 0;
    d_patient_id.len     = 0;
    d_trx_doc_ref_line_num.len     = 0;
    d_trx_doc_ref_seq_num.len     = 0;
    d_prt_grp_hdr_code.len     = 0;
    d_prt_grp_line_code.len     = 0;
    d_package_ind.len     = 0;
    d_package_service_code.len     = 0;
    d_blng_serv_code.len     = 0;
    d_prt_blng_serv_code.len     = 0;
    d_package_trx_ind.len     = 0;
    d_service_date.len     = 0;
    d_blng_grp_id.len     = 0;
    d_blng_class_code.len     = 0;
    d_bed_class_code.len     = 0;
    d_bill_type_code.len     = 0;
    d_added_by_id.len     = 0;
    d_canadj_reason_text.len     = 0;
    d_serv_item_code.len     = 0;
    d_serv_item_desc.len     = 0;
    d_folio_remarks.len     = 0;

   d_serv_qty    = 0;

   d_base_charge_amt         = 0;
   d_upd_gross_charge_amt    = 0;
   d_upd_disc_amt            = 0;
   d_upd_net_charge_amt      = 0;
   d_addl_factor_num         = 0;


    /* EXEC SQL FETCH TRANS_LIST_CUR INTO
                   :d_trx_doc_ref,
                   :d_trx_doc_ref_line_num,
                   :d_trx_doc_ref_seq_num,
                   :d_episode_type,
                   :d_patient_id,
                   :d_episode_id,
                   :d_visit_id,
                   :d_prt_grp_hdr_code,
                   :d_prt_grp_line_code,
                   :d_package_ind,
                   :d_package_service_code,
                   :d_blng_serv_code,
                   :d_package_trx_ind,
                   :d_serv_qty,
                   :d_base_charge_amt,
                   :d_upd_gross_charge_amt,
                   :d_upd_disc_amt,
                   :d_upd_net_charge_amt,
                   :d_service_date,
                   :d_blng_grp_id,
                   :d_blng_class_code,
                   :d_addl_factor_num,
                   :d_bed_class_code,
                   :d_bill_type_code,
                   :d_added_by_id,
                   :d_trx_status,
                   :d_rev_adj_trx_ind,
                   :d_canadj_reason_text,
                   :d_serv_item_code,
                   :d_serv_item_desc,
				   :m_ins_pat_ind,
				   :l_confirm_yn,
                   :d_folio_remarks; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 33;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )282;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_trx_doc_ref;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_trx_doc_ref_line_num;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_trx_doc_ref_seq_num;
    sqlstm.sqhstl[2] = (unsigned int  )7;
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
    sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_visit_id;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_prt_grp_hdr_code;
    sqlstm.sqhstl[7] = (unsigned int  )5;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_prt_grp_line_code;
    sqlstm.sqhstl[8] = (unsigned int  )5;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_package_ind;
    sqlstm.sqhstl[9] = (unsigned int  )4;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_package_service_code;
    sqlstm.sqhstl[10] = (unsigned int  )13;
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
    sqlstm.sqhstv[12] = (         void  *)&d_package_trx_ind;
    sqlstm.sqhstl[12] = (unsigned int  )4;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_serv_qty;
    sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_base_charge_amt;
    sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_upd_gross_charge_amt;
    sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_upd_disc_amt;
    sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&d_upd_net_charge_amt;
    sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_service_date;
    sqlstm.sqhstl[18] = (unsigned int  )22;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[19] = (unsigned int  )7;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&d_blng_class_code;
    sqlstm.sqhstl[20] = (unsigned int  )5;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&d_addl_factor_num;
    sqlstm.sqhstl[21] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&d_bed_class_code;
    sqlstm.sqhstl[22] = (unsigned int  )5;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&d_bill_type_code;
    sqlstm.sqhstl[23] = (unsigned int  )5;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&d_added_by_id;
    sqlstm.sqhstl[24] = (unsigned int  )23;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&d_trx_status;
    sqlstm.sqhstl[25] = (unsigned int  )1;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&d_rev_adj_trx_ind;
    sqlstm.sqhstl[26] = (unsigned int  )1;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&d_canadj_reason_text;
    sqlstm.sqhstl[27] = (unsigned int  )53;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&d_serv_item_code;
    sqlstm.sqhstl[28] = (unsigned int  )14;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&d_serv_item_desc;
    sqlstm.sqhstl[29] = (unsigned int  )43;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&m_ins_pat_ind;
    sqlstm.sqhstl[30] = (unsigned int  )4;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&l_confirm_yn;
    sqlstm.sqhstl[31] = (unsigned int  )5;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqhstv[32] = (         void  *)&d_folio_remarks;
    sqlstm.sqhstl[32] = (unsigned int  )19;
    sqlstm.sqhsts[32] = (         int  )0;
    sqlstm.sqindv[32] = (         void  *)0;
    sqlstm.sqinds[32] = (         int  )0;
    sqlstm.sqharm[32] = (unsigned int  )0;
    sqlstm.sqadto[32] = (unsigned short )0;
    sqlstm.sqtdso[32] = (unsigned short )0;
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

    d_trx_doc_ref.arr[d_trx_doc_ref.len]  = '\0';
    d_episode_type.arr[d_episode_type.len]  = '\0';
    d_episode_id.arr[d_episode_id.len]  = '\0';
    d_visit_id.arr[d_visit_id.len]  = '\0';
    d_patient_id.arr[d_patient_id.len]  = '\0';
    d_trx_doc_ref_line_num.arr[d_trx_doc_ref_line_num.len]  = '\0';
    d_trx_doc_ref_seq_num.arr[d_trx_doc_ref_seq_num.len]  = '\0';
    d_prt_grp_hdr_code.arr[d_prt_grp_hdr_code.len]  = '\0';
    d_prt_grp_line_code.arr[d_prt_grp_line_code.len]  = '\0';
    d_package_ind.arr[d_package_ind.len]  = '\0';
    d_package_service_code.arr[d_package_service_code.len]  = '\0';
    d_blng_serv_code.arr[d_blng_serv_code.len]  = '\0';
    d_package_trx_ind.arr[d_package_trx_ind.len]  = '\0';
    d_service_date.arr[d_service_date.len]  = '\0';
    d_blng_grp_id.arr[d_blng_grp_id.len]  = '\0';
    d_blng_class_code.arr[d_blng_class_code.len]  = '\0';
    d_bed_class_code.arr[d_bed_class_code.len]  = '\0';
    d_bill_type_code.arr[d_bill_type_code.len]  = '\0';
    d_added_by_id.arr[d_added_by_id.len]  = '\0';
    d_canadj_reason_text.arr[d_canadj_reason_text.len]  = '\0';
    d_serv_item_code.arr[d_serv_item_code.len]  = '\0';
    d_serv_item_desc.arr[d_serv_item_desc.len]  = '\0';
    d_folio_remarks.arr[d_folio_remarks.len]  = '\0';
	m_ins_pat_ind.arr[m_ins_pat_ind.len] = '\0';
	l_confirm_yn.arr[l_confirm_yn.len] = '\0';

    strcpy(d_prt_blng_serv_code.arr, d_blng_serv_code.arr);

	//Commented to display description always..irrespecitve of any conditions.

  /*  if(d_package_ind.arr[0] == 'P'&& explode_pkg == 'N') {
        EXEC SQL SELECT LONG_DESC,
		        'N'
	         INTO   :d_blng_serv_desc,
		        :d_misc_serv_yn
	         FROM   BL_PACKAGE_HDR
	         WHERE  PACKAGE_CODE = :d_blng_serv_code;

        if(OERROR)
	    err_mesg("SELECT failed on table BL_PACKAGE_HDR",0,"");
    }
    else {   */

        /* EXEC SQL SELECT A.LONG_DESC,
		                NVL(MISC_SERV_YN,'N')
	         INTO   :d_blng_serv_desc,
		            :d_misc_serv_yn
	         FROM   BL_BLNG_SERV_lang_vw A,
					BL_BLNG_SERV B
	         WHERE  A.BLNG_SERV_CODE = B.BLNG_SERV_CODE
			 AND	A.BLNG_SERV_CODE = :d_blng_serv_code
			 and 	language_id=:p_language_id; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 33;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select A.LONG_DESC ,NVL(MISC_SERV_YN,'N') into :b0,:b\
1  from BL_BLNG_SERV_lang_vw A ,BL_BLNG_SERV B where ((A.BLNG_SERV_CODE=B.BLNG\
_SERV_CODE and A.BLNG_SERV_CODE=:b2) and language_id=:b3)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )429;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_desc;
        sqlstm.sqhstl[0] = (unsigned int  )43;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_misc_serv_yn;
        sqlstm.sqhstl[1] = (unsigned int  )1;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_blng_serv_code;
        sqlstm.sqhstl[2] = (unsigned int  )13;
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



        if(OERROR)
	    err_mesg("SELECT failed on table BL_BLNG_SERV",0,"");
    //}
    d_blng_serv_desc.arr[d_blng_serv_desc.len]  = '\0';


    if(d_misc_serv_yn == 'Y') {
	strcpy(d_blng_serv_desc.arr, d_serv_item_desc.arr);
    }


    if(d_serv_item_code.arr[0]) {
      strcpy(d_prt_blng_serv_code.arr, d_serv_item_code.arr);
      strcpy(d_blng_serv_desc.arr, d_serv_item_desc.arr);
    }

    return 1;


}

fetch_prt_line_desc()
{

    d_prt_grp_line_desc.arr[0]  = '\0';
    d_prt_grp_line_desc.len     = 0;

    /* EXEC SQL OPEN PRT_GRP_LINE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 33;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )460;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_hdr_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prt_grp_line_code;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor PRT_GRP_LINE_CUR",0,"");

    /* EXEC SQL FETCH PRT_GRP_LINE_CUR
	     INTO  :d_prt_grp_line_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 33;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )487;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
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

/* fprintf(f1,"                                   BL BED PKG  SERVICE                                           SERVICE                  ADDL.  I/P Ind.  REMARKS            GROSS       DISCOUNT            NET                                        TRAN\n");
   fprintf(f1,"ADM NO.  VST. PATIENT NO           GP CLS IND  CODE & DESCRIPTION                               DATE / TIME           QTY FACTOR                             AMOUNT         AMOUNT         AMOUNT  TRANSACTION REF       STS ADJ USER ID TYPE\n");*/
put_hdr()
{
    form_hdr();
    fprintf(f1,"                                   %2.2s %-3.3s %-4.4s %-11.11s                                      %-11.11s              %6.6s %-11.11s  %-10.10s %9.9s     %12.12s    %8.8s                                          %-6.6s \n",loc_legend[150],loc_legend[270],loc_legend[280],loc_legend[290],loc_legend[290],loc_legend[450],loc_legend[460],loc_legend[470],loc_legend[480],loc_legend[490],loc_legend[500],loc_legend[510]);
	fprintf(f1,"%-8.8s %-4.4s %-20.20s %-2.2s %-3.3s %-4.4s %-48.48s %-15.15s %16.16s %16s%16.16s %14.14s %14.14s  %-20.20s %4.4s %3.3s %7.7s %5.5s\n",loc_legend[170],loc_legend[180],loc_legend[90],loc_legend[240],loc_legend[250],loc_legend[260],loc_legend[160],loc_legend[370],loc_legend[380]," ",loc_legend[390],loc_legend[390],loc_legend[390],loc_legend[400],loc_legend[410],loc_legend[420],loc_legend[430],loc_legend[440]);
    fprintf(f1,"%s\n",hdr_line4);

    fprintf(f1,"\n\n");
    line_no=9;
}

chk_break(nol)
int nol;
{
	if(line_no+nol >= 55) 
	{
       line_no = 1;
	   g_count = 1;
           ++page_no;
	   put_hdr();
	}
}

put_inp_parm()
{
    form_hdr();
	
    fprintf(f1,"VER : 4.1\n");
    fprintf(f1,"\n\n\n\n");
    fprintf(f1,"\t%-22s\n",loc_legend[550]);
    fprintf(f1,"\t--------------------\n\n");
	if ((prt_grp_fm.arr[0] && prt_line_fm.arr[0] )== '\0')
    fprintf(f1,"\t\t%-10.10s %-14.14s %-8.8s : %-10s\n",loc_legend[130],loc_legend[140],loc_legend[60],loc_legend[610]);
	else
	fprintf(f1,"\t\t%-10.10s %-14.14s %-8.8s : %2s/%2s\n",loc_legend[130],loc_legend[140],loc_legend[60],prt_grp_fm.arr,prt_line_fm.arr);
	if ((prt_grp_to.arr[0] && prt_line_to.arr[0] )== '\0')
    fprintf(f1,"\t\t                          %-6.6s   : %-10s\n\n",loc_legend[70],loc_legend[620]);
	else
	fprintf(f1,"\t\t                          %-6.6s   : %2s/%2s\n\n",loc_legend[70],prt_grp_to.arr,prt_line_to.arr);
    if(serv_code_fm.arr[0]=='\0')
	fprintf(f1,"\t\t%-20.20s      %-9.9s: %-10.10s\n",loc_legend[110],loc_legend[60],loc_legend[610]);
	else
	fprintf(f1,"\t\t%-20.20s      %-9.9s: %s\n",loc_legend[110],loc_legend[60], serv_code_fm.arr);
	if(serv_code_to.arr[0]=='\0')
    fprintf(f1,"\t\t                          %-6.6s   : %-10s\n\n",loc_legend[70], loc_legend[620]);
	else
	fprintf(f1,"\t\t                          %-6.6s   : %s\n\n",loc_legend[70], serv_code_to.arr);

    if(l_fm_patient_id.arr[0]=='\0')
	fprintf(f1,"\t\t%-15.15s           %-9.9s: %-10s\n",loc_legend[90],loc_legend[60],loc_legend[610]);
	else
//	fprintf(f1,"\t\t%-15.15s           %-9.9s: %20s\n",loc_legend[90],loc_legend[60],l_fm_patient_id.arr);commented by saikiran
	fprintf(f1,"\t\t%-15.15s           %-9.9s: %-20s\n",loc_legend[90],loc_legend[60],l_fm_patient_id.arr);


	if(l_to_patient_id.arr[0]=='\0')
    fprintf(f1,"\t\t                          %-6.6s   : %-10s\n\n",loc_legend[70],loc_legend[620]);
	else
//	fprintf(f1,"\t\t                          %-6.6s   : %20s\n\n",loc_legend[70],l_to_patient_id.arr);commented by saikiran
	fprintf(f1,"\t\t                          %-6.6s   : %-20s\n\n",loc_legend[70],l_to_patient_id.arr);


    fprintf(f1,"\t\t%-20.20s               : %1s\n",loc_legend[80], l_transaction_type.arr);
    fprintf(f1,"\t\t(%-25.25s     %-25.25s     %-20.20s)\n\n",loc_legend[340],loc_legend[350],loc_legend[360]);

    fprintf(f1,"\t\t%-15.15s                    : %1s\n",loc_legend[100], nd_rep_opt.arr);
    fprintf(f1,"\t\t(%-25.25s     %-25.25s)\n\n",loc_legend[320],loc_legend[330]);

    fprintf(f1,"\t\t%-15.15s                    : %1s\n",loc_legend[120], nd_rep_type.arr);
    fprintf(f1,"\t\t(%-25.25s     %-25.25s)\n",loc_legend[300],loc_legend[310]);

    ++page_no;

}

print_end_of_rep()
{
    fprintf(f1,"                                                    ** %16s **                                                             \n",loc_legend[630]);
}

init_prev_values()
{
    d_prev_episode_type.arr[0]       = '\0';
    d_prev_prt_grp_hdr_code.arr[0]   = '\0';
    d_prev_prt_grp_line_code.arr[0]  = '\0';
    d_prev_blng_serv_grp.arr[0]      = '\0';

    d_prev_episode_type.len			 = 0;
    d_prev_prt_grp_hdr_code.len      = 0;
    d_prev_prt_grp_line_code.len     = 0;
    d_prev_blng_serv_grp.len         = 0;
}

copy_val()
{
    strcpy(d_prev_episode_type.arr,d_episode_type.arr);
    strcpy(d_prev_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr);
    strcpy(d_prev_prt_grp_line_code.arr,d_prt_grp_line_code.arr);
    strncpy(d_prev_blng_serv_grp.arr,d_blng_serv_code.arr,2);

    d_prev_episode_type.len         = strlen(d_prev_episode_type.arr);
    d_prev_prt_grp_hdr_code.len     = strlen(d_prev_prt_grp_hdr_code.arr);
    d_prev_prt_grp_line_code.len    = strlen(d_prev_prt_grp_line_code.arr);
    d_prev_blng_serv_grp.len        = strlen(d_prev_blng_serv_grp.arr);
}

episode_brk()
{
    return (strcmp(d_prev_episode_type.arr,d_episode_type.arr));
}

prt_grp_line_brk()
{

    return (strcmp(d_prev_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr) ||
            strcmp(d_prev_prt_grp_line_code.arr,d_prt_grp_line_code.arr));

}

blng_serv_grp_brk()
{
    return(strncmp(d_prev_blng_serv_grp.arr,d_blng_serv_code.arr,2));

}

init_srv_totals()
{

       g_srv_base_amt  = 0;
       g_srv_gross_amt  = 0;
       g_srv_disc_amt  = 0;
       g_srv_net_amt  = 0;
}

init_prt_totals()
{

       g_prt_base_amt  = 0;
       g_prt_gross_amt  = 0;
       g_prt_disc_amt  = 0;
       g_prt_net_amt  = 0;
}

init_epi_totals()
{

       g_epi_base_amt  = 0;
       g_epi_gross_amt  = 0;
       g_epi_disc_amt  = 0;
       g_epi_net_amt  = 0;
}

init_grand_totals()
{
       g_tot_base_amt  = 0;
       g_tot_gross_amt  = 0;
       g_tot_disc_amt  = 0;
       g_tot_net_amt  = 0;
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
    char buf[15];
    int col;

    if(first) {
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
	memset(hdr_line4,'-',REP_WIDTH+9);
	hdr_line4[REP_WIDTH] = '\0';

        //strncpy(hdr_line1,"MDL : BL",8);  
		strcpy(hdr_line1,loc_legend[560]);
		strcat(hdr_line1, " : "); //added by saikiran
		strcat(hdr_line1,loc_legend[600]);  
	   	//col = (int)(REP_WIDTH-strlen(comp_name.arr))/2;  //pradeep
        //strncpy(hdr_line1+col,comp_name.arr,strlen(comp_name.arr));///PRADEEP
        //col = (REP_WIDTH-strlen(rep_date.arr)); //pradeep
		
		init_date_temp_var();
	
		strcpy(date_convert.arr,rep_date.arr);
		fun_change_loc_date();
        //strcpy(hdr_line1+col,date_convert.arr); Pradeep
//		disp_message(ERR_MESG,"1");
//			disp_message(ERR_MESG,hdr_line1+col);

       // strncpy(hdr_line2,"OPR :",5);
	    strcpy(hdr_line2,loc_legend[570]);
		strcat(hdr_line2, " : "); //added by saikiran
		strcat(hdr_line2,oper_id.arr);
        //strcpy(hdr_line2+6,oper_id.arr);

    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    //strncpy(hdr_line3,"REP : BLRTRANS",14);
	strcpy(hdr_line3,loc_legend[580]);
	strcat(hdr_line3," : ");//added by saikiran
	strcat(hdr_line3,loc_legend[40]);  
    col = (int)(REP_WIDTH-strlen(rep_title))/2;
    //strncpy(hdr_line3+col,rep_title,strlen(rep_title));
	strcat(loc_legend[640]," ");
	strcpy(hdr_line3+col,loc_legend[640],strlen(loc_legend[640]));
    //sprintf(buf,"%s : %4d",loc_legend[30],page_no);
    //strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);

	init_date_temp_var();
	strcpy(date_convert.arr,trans_date.arr);
	fun_change_loc_date();
    strcat(hdr_line3+col,date_convert.arr);


    if(first)
        //fprintf(f1,"%-13.13s                              %s \n",hdr_line1,hdr_line1+col);
		fprintf(f1,"%-13.13s                              %-25s                                                                        %-12s\n",hdr_line1,comp_name.arr,date_convert.arr);
		
    else
		
       // fprintf(f1,"\f%-13.13s                               %s \n",hdr_line1,hdr_line1+col);
	    fprintf(f1,"\f%-13.13s                               %-25s                                                                    %-12s\n",hdr_line1,comp_name.arr,date_convert.arr);
	//disp_message(ERR_MESG,hdr_line1+col);	
    fprintf(f1,"%-18.18s\n",hdr_line2);
    fprintf(f1,"%-20.20s                  %s                                                                         %s : %4d\n",hdr_line3,hdr_line3+col,loc_legend[30],page_no);
    fprintf(f1,"%s\n",hdr_line4);

    first = 0;
}



fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRTRANS.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 33;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRTRANS.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )506;
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
  sqlstm.arrsiz = 33;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )529;
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
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 33;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )560;
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
date_convert1.arr[0] = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
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

fun_change_loc_date1()
{

strcpy(nd_temp_date1.arr,date_convert1.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);


get_local_date1();

strcpy(date_convert1.arr,nd_loc_date1.arr); 

}

get_local_date1()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date1  date;
	
	BEGIN
	
	  
      :nd_loc_date1 :=sm_convert_date_2t(to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:p_language_id); 	
		
	//	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date1);  
      
	 //:nd_loc_date1 := to_char(t_date1,'DD/MM/YYYY HH24:MI');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 33;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date1 date ; BEGIN :nd_loc_date1 := sm_convert_dat\
e_2t ( to_date ( :nd_temp_date1 , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; \
END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )587;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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