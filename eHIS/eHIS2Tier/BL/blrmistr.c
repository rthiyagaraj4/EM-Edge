
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
    "C:\\proc\\Blrmistr.pc"
};


static unsigned long sqlctx = 36417163;


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
            void  *sqhstv[17];
   unsigned int   sqhstl[17];
            int   sqhsts[17];
            void  *sqindv[17];
            int   sqinds[17];
   unsigned int   sqharm[17];
   unsigned int   *sqharc[17];
   unsigned short  sqadto[17];
   unsigned short  sqtdso[17];
} sqlstm = {10,17};

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
"RX_DATE),A.BLNG_SERV_CODE            ";

 static const char *sq0006 = 
"select SHORT_DESC  from BL_BLNG_SERV_GRP_lang_vw where (SERV_GRP_CODE=:b0 an\
d language_id=:b1)           ";

 static const char *sq0005 = 
"select decode(:b0,'en',substr(short_name,1,30),substr(SHORT_NAME_LOC_LANG,1,\
30)) ,null   from MP_PATIENT_MAST where PATIENT_ID=:b1           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,216,0,0,0,0,0,1,0,
20,0,0,2,174,0,4,237,0,0,9,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
71,0,0,3,84,0,2,265,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
98,0,0,4,1061,0,9,339,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
137,0,0,4,0,0,13,382,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,4,0,0,
220,0,0,6,105,0,9,426,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
243,0,0,6,0,0,13,434,0,0,1,0,0,1,0,2,9,0,0,
262,0,0,5,141,0,9,446,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
285,0,0,5,0,0,13,458,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
308,0,0,7,512,0,6,472,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
335,0,0,8,117,0,4,693,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
358,0,0,9,158,0,4,765,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
393,0,0,10,96,0,4,825,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
416,0,0,11,165,0,6,832,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
447,0,0,12,140,0,6,857,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
474,0,0,13,143,0,6,916,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRMISTR.PC                                  */
/* AUTHOR                : ANIL.S.RAM                                   */
/* DATE WRITTEN          : 13-APR-1994                                  */
/*                                                                      */
/* CALLED FROM            :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                        */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*          1.  BL_PATIENT_CHARGES_FOLIO          Input                 */  
/*          2.  MP_PATIENT_MAST                   Input                 */
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
/*
#define DEBUG 0
*/
#define ESC 0x1B   

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            date_time                                  [20],
            user_id                                    [40],
            nd_session_id                              [16],
            nd_pgm_date                                [25],
            d_curr_pgm_name                            [15],
            nd_epi_type                                [2],
            nd_fm_trx_date                             [11],
            nd_to_trx_date                             [11],
            nd_fm_blng_serv                            [11],
            nd_to_blng_serv                            [11],
			d_facility_id							   [10],
			p_language_id							   [3],
			nd_temp_date							   [21],
			date_convert							   [21],
			nd_loc_date								   [21],
			nd_temp_date1							   [21],
			date_convert1							   [21],
			nd_loc_date1							   [21],
			nd_facility_id							   [3],
            d_short_name_full                          [61],
            bl_patient_name_loc_lang                   [61],
            bl_patient_name                            [61],
			nd_episode_type								[30],
			bl_patient_nam1                            [61],

            bl_blng_grp_desc                           [40]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[2]; } nd_epi_type;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_trx_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_trx_date;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_blng_serv;

struct { unsigned short len; unsigned char arr[11]; } nd_to_blng_serv;

struct { unsigned short len; unsigned char arr[10]; } d_facility_id;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[21]; } date_convert1;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[30]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_nam1;

struct { unsigned short len; unsigned char arr[40]; } bl_blng_grp_desc;



   /* VARCHAR bl_pat_episode_type                         [2],
           bl_pat_episode_id                           [9],
           bl_pat_visit_id                             [5],
           bl_pat_patient_id                           [21],
           bl_pat_trx_date                             [13],
           bl_pat_trx_doc_ref                          [21],
           bl_pat_trx_doc_ref_line_num                 [5],
           bl_pat_trx_doc_ref_seq_num                  [5],
           bl_pat_service_item_desc                    [41],
           bl_pat_service_grp                          [3],
           bl_pat_service_code                         [11],
           bl_pat_service_date                         [11],
           bl_pat_service_time                         [6],
           bl_pat_service_qty                          [11],
           bl_pat_upd_net_charge_amt                   [23],
           bl_pat_added_by_id                          [21],
		   bl_pat_cur_date                             [12],
           bl_pat_cur_grp                              [3],
		   l_pk_value								   [100],
		   l_translated_value						   [201]; */ 
struct { unsigned short len; unsigned char arr[2]; } bl_pat_episode_type;

struct { unsigned short len; unsigned char arr[9]; } bl_pat_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_visit_id;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_patient_id;

struct { unsigned short len; unsigned char arr[13]; } bl_pat_trx_date;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_trx_doc_ref;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_trx_doc_ref_line_num;

struct { unsigned short len; unsigned char arr[5]; } bl_pat_trx_doc_ref_seq_num;

struct { unsigned short len; unsigned char arr[41]; } bl_pat_service_item_desc;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_service_grp;

struct { unsigned short len; unsigned char arr[11]; } bl_pat_service_code;

struct { unsigned short len; unsigned char arr[11]; } bl_pat_service_date;

struct { unsigned short len; unsigned char arr[6]; } bl_pat_service_time;

struct { unsigned short len; unsigned char arr[11]; } bl_pat_service_qty;

struct { unsigned short len; unsigned char arr[23]; } bl_pat_upd_net_charge_amt;

struct { unsigned short len; unsigned char arr[21]; } bl_pat_added_by_id;

struct { unsigned short len; unsigned char arr[12]; } bl_pat_cur_date;

struct { unsigned short len; unsigned char arr[3]; } bl_pat_cur_grp;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;


 double    bl_pat_net_charge_amt_db,
           bl_grp_tot_net_charge_amt,
           bl_dat_tot_net_charge_amt,
           bl_grn_tot_net_charge_amt,
		   l_net_charge_amt;

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
       exit(0);
    }
 
    strcpy(g_pgm_id,"BLRMISTR");

    if (sql_connect(argv[1]) == -1)
    {
        disp_message(ORA_MESG,"Error in connecting to Oracle\n");
        exit(0);
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
          strcpy(bl_pat_cur_date.arr,bl_pat_trx_date.arr);
          bl_pat_cur_date.len = strlen(bl_pat_cur_date.arr);

          strcpy(bl_pat_cur_grp.arr,bl_pat_service_grp.arr);
          bl_pat_cur_grp.len = strlen(bl_pat_cur_grp.arr);

          print_rec(0);
       }

       if (strcmp(bl_pat_cur_date.arr,bl_pat_trx_date.arr))
       {
          print_date_tot();

          strcpy(bl_pat_cur_date.arr,bl_pat_trx_date.arr);
          bl_pat_cur_date.len = strlen(bl_pat_cur_date.arr);

          strcpy(bl_pat_cur_grp.arr,bl_pat_service_grp.arr);
          bl_pat_cur_grp.len = strlen(bl_pat_cur_grp.arr);

          print_rec(0);
       }
       else if (strcmp(bl_pat_cur_grp.arr,bl_pat_service_grp.arr))
       {
          print_grp_tot();

          strcpy(bl_pat_cur_grp.arr,bl_pat_service_grp.arr);
          bl_pat_cur_grp.len = strlen(bl_pat_cur_grp.arr);

          print_rec(0);
       }

       rec_ctr++;
       if (lctr+3 > 35) //55
       {
          print_head();
          print_rec(0);
       }
       print_rec(2);
     }
     if (rec_ctr)
	 {
        print_grand_tot();
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

    return;
}

fetch_prog_param()
{
    nd_epi_type.arr[0]               = '\0';
    nd_fm_trx_date.arr[0]            = '\0';
    nd_to_trx_date.arr[0]            = '\0';
    nd_fm_blng_serv.arr[0]           = '\0';
    nd_to_blng_serv.arr[0]           = '\0';

    nd_epi_type.len                  = 0;
    nd_fm_blng_serv.len              = 0;
    nd_to_blng_serv.len              = 0;
    nd_fm_trx_date.len               = 0;
    nd_to_trx_date.len               = 0;

   /* EXEC SQL SELECT PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,
				   operating_facility_id
              INTO :nd_epi_type,
                   :nd_fm_trx_date,
                   :nd_to_trx_date,
                   :nd_fm_blng_serv,
                   :nd_to_blng_serv,
				   :d_facility_id
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,operating_f\
acility_id into :b0,:b1,:b2,:b3,:b4,:b5  from SY_PROG_PARAM where ((PGM_ID=:b6\
 and SESSION_ID=:b7) and PGM_DATE=:b8)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_trx_date;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_trx_date;
   sqlstm.sqhstl[2] = (unsigned int  )13;
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
   sqlstm.sqhstv[5] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[5] = (unsigned int  )12;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[6] = (unsigned int  )17;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[7] = (unsigned int  )18;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[8] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

    nd_epi_type.arr[nd_epi_type.len]              = '\0';
    nd_fm_blng_serv.arr[nd_fm_blng_serv.len]      = '\0';
    nd_to_blng_serv.arr[nd_to_blng_serv.len]      = '\0';
    nd_fm_trx_date.arr[nd_fm_trx_date.len]        = '\0';
    nd_to_trx_date.arr[nd_to_trx_date.len]        = '\0';

	d_facility_id.arr[d_facility_id.len]		  = '\0';
	strcpy(g_facility_id, d_facility_id.arr);

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )71;
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

     /* EXEC SQL DECLARE BL_PAT_CHG_FOLIO_CUR CURSOR FOR
               SELECT EPISODE_TYPE,
                      LPAD(TO_CHAR(EPISODE_ID),8,'0'),
                      LPAD(TO_CHAR(VISIT_ID),4,'0'),
                      PATIENT_ID,
                      TO_CHAR(TRUNC(TRX_DATE),'DD/MM/YYYY'),
                      TO_CHAR(TRUNC(SERVICE_DATE),'DD/MM/YYYY'),
                      TO_CHAR(SERVICE_DATE,'HH24:MI'),
                      TRX_DOC_REF,
                      LPAD(TO_CHAR(TRX_DOC_REF_LINE_NUM),4,'0'),
                      LPAD(TO_CHAR(TRX_DOC_REF_SEQ_NUM),4,'0'),
                      SUBSTR(A.BLNG_SERV_CODE,1,2),
                      A.BLNG_SERV_CODE,
                      SERV_ITEM_DESC,
                      TO_CHAR(NVL(SERV_QTY,0),'999,990.99'),
                      TO_CHAR(NVL(UPD_NET_CHARGE_AMT,0)),
                      A.ADDED_BY_ID,
                      NVL(UPD_NET_CHARGE_AMT,0) 
                 FROM BL_PATIENT_CHARGES_FOLIO A,BL_BLNG_SERV B
                WHERE A.BLNG_SERV_CODE=B.BLNG_SERV_CODE
				  AND EPISODE_TYPE = NVL(:nd_epi_type,EPISODE_TYPE)
                  AND A.BLNG_SERV_CODE 
				  
                      BETWEEN NVL(:nd_fm_blng_serv,'!!!!!!')  AND
                              NVL(:nd_to_blng_serv,'~~~~~~')
                  AND TRUNC(TRX_DATE)
                       BETWEEN 
                        NVL(TO_DATE(:nd_fm_trx_date,'DD/MM/YYYY'),
                             to_date('00010101','YYYYDDMM'))
                         AND
                        NVL(TO_DATE(:nd_to_trx_date,'DD/MM/YYYY'),
                             to_date('47123112','YYYYDDMM'))
                  AND TRX_FINALIZE_IND = 'Y'
                  AND TRX_STATUS IS NULL 
                  AND PACKAGE_IND = 'S'
				  AND NVL(B.MISC_SERV_YN,'N') = 'Y'
                  //AND DF_SERVICE_IND IN ('M','O')
				  AND NVL(operating_facility_id,'N') = NVL(:d_facility_id,'N')
                ORDER BY TRUNC(TRX_DATE),A.BLNG_SERV_CODE; */ 


    /* EXEC SQL DECLARE BL_PAT_NAME_CUR CURSOR FOR
              //SELECT SUBSTR(SHORT_NAME_LOC_LANG,1,16),
                    /o substr(SHORT_NAME,1,30),
					 decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,
                      o/
				//	           short_name
				SELECT 
				  	decode(:p_language_id,'en', substr(short_name,1,30),substr(SHORT_NAME_LOC_LANG,1,30)),
					null
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :bl_pat_patient_id; */ 


    /* EXEC SQL DECLARE BL_BLNG_GRP_CUR CURSOR FOR
              SELECT SHORT_DESC
                FROM BL_BLNG_SERV_GRP_lang_vw
               WHERE SERV_GRP_CODE = :bl_pat_service_grp
			   AND language_id=:p_language_id; */ 

} 
  
open_cur()   
{
    /* EXEC SQL OPEN BL_PAT_CHG_FOLIO_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select EPISODE_TYPE ,LPAD(TO_CHAR(EPISODE_ID),8,'0') ,LPAD(TO_CHAR(VI\
SIT_ID),4,'0') ,PATIENT_ID ,TO_CHAR(TRUNC(TRX_DATE),'DD/MM/YYYY') ,TO_CHAR(T\
RUNC(SERVICE_DATE),'DD/MM/YYYY') ,TO_CHAR(SERVICE_DATE,'HH24:MI') ,TRX_DOC_R\
EF ,LPAD(TO_CHAR(TRX_DOC_REF_LINE_NUM),4,'0') ,LPAD(TO_CHAR(TRX_DOC_REF_SEQ_\
NUM),4,'0') ,SUBSTR(A.BLNG_SERV_CODE,1,2) ,A.BLNG_SERV_CODE ,SERV_ITEM_DESC \
,TO_CHAR(NVL(SERV_QTY,0),'999,990.99') ,TO_CHAR(NVL(UPD_NET_CHARGE_AMT,0)) ,\
A.ADDED_BY_ID ,NVL(UPD_NET_CHARGE_AMT,0)  from BL_PATIENT_CHARGES_FOLIO A ,B\
L_BLNG_SERV B where ((((((((A.BLNG_SERV_CODE=B.BLNG_SERV_CODE and EPISODE_TY\
PE=NVL(:b0,EPISODE_TYPE)) and A.BLNG_SERV_CODE between NVL(:b1,'!!!!!!') and\
 NVL(:b2,'~~~~~~')) and TRUNC(TRX_DATE) between NVL(TO_DATE(:b3,'DD/MM/YYYY'\
),to_date('00010101','YYYYDDMM')) and NVL(TO_DATE(:b4,'DD/MM/YYYY'),to_date(\
'47123112','YYYYDDMM'))) and TRX_FINALIZE_IND='Y') and TRX_STATUS is null ) \
and PACKAGE_IND='S') and NVL(B.MISC_SERV_YN,'N')='Y') and NVL(operating_faci\
lity_id,'N')=NVL(:b5,'N')) order by TRUNC(T");
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )98;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_fm_blng_serv;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_blng_serv;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_trx_date;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_trx_date;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )12;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
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
bl_pat_service_item_desc.arr[0]                                   = '\0';
bl_pat_service_grp.arr[0]                                         = '\0';
bl_pat_service_code.arr[0]                                        = '\0';
bl_pat_service_date.arr[0]                                        = '\0';
bl_pat_service_time.arr[0]                                        = '\0';
bl_pat_service_qty.arr[0]                                         = '\0';
bl_pat_upd_net_charge_amt.arr[0]                                  = '\0';
bl_pat_added_by_id.arr[0]                                         = '\0';

bl_pat_episode_type.len                                           = 0;
bl_pat_episode_id.len                                             = 0;
bl_pat_visit_id.len                                               = 0;
bl_pat_patient_id.len                                             = 0;
bl_pat_trx_date.len                                               = 0;
bl_pat_trx_doc_ref.len                                            = 0;
bl_pat_trx_doc_ref_line_num.len                                   = 0;
bl_pat_trx_doc_ref_seq_num.len                                    = 0;
bl_pat_service_item_desc.len                                      = 0;
bl_pat_service_grp.len                                            = 0;
bl_pat_service_date.len                                           = 0;
bl_pat_service_code.len                                           = 0;
bl_pat_service_time.len                                           = 0;
bl_pat_service_qty.len                                            = 0;
bl_pat_upd_net_charge_amt.len                                     = 0;
bl_pat_added_by_id.len                                            = 0;

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
                    :bl_pat_service_grp,
                    :bl_pat_service_code,
                    :bl_pat_service_item_desc,
                    :bl_pat_service_qty,
                    :bl_pat_upd_net_charge_amt,
                    :bl_pat_added_by_id,
                    :bl_pat_net_charge_amt_db; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )137;
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
     sqlstm.sqhstl[5] = (unsigned int  )13;
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
     sqlstm.sqhstv[10] = (         void  *)&bl_pat_service_grp;
     sqlstm.sqhstl[10] = (unsigned int  )5;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_pat_service_code;
     sqlstm.sqhstl[11] = (unsigned int  )13;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_pat_service_item_desc;
     sqlstm.sqhstl[12] = (unsigned int  )43;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_pat_service_qty;
     sqlstm.sqhstl[13] = (unsigned int  )13;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_pat_upd_net_charge_amt;
     sqlstm.sqhstl[14] = (unsigned int  )25;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_pat_added_by_id;
     sqlstm.sqhstl[15] = (unsigned int  )23;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_pat_net_charge_amt_db;
     sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
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
	bl_pat_service_grp.arr[bl_pat_service_grp.len]                           = '\0';
	bl_pat_service_code.arr[bl_pat_service_code.len]                         = '\0';
	bl_pat_service_item_desc.arr[bl_pat_service_item_desc.len]               = '\0';
	bl_pat_service_date.arr[bl_pat_service_date.len]                         = '\0';
	bl_pat_service_time.arr[bl_pat_service_time.len]                         = '\0';
	bl_pat_service_qty.arr[bl_pat_service_qty.len]                           = '\0';
	bl_pat_upd_net_charge_amt.arr[bl_pat_upd_net_charge_amt.len]             = '\0';
	bl_pat_added_by_id.arr[bl_pat_added_by_id.len]                           = '\0';

    return(LAST_ROW?0:1);
}

fetch_grp_desc()
{
   /* EXEC SQL OPEN BL_BLNG_GRP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )220;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_pat_service_grp;
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

   bl_blng_grp_desc.arr[0]                    = '\0';

   bl_blng_grp_desc.len                       = 0;

    /* EXEC SQL FETCH BL_BLNG_GRP_CUR
              INTO :bl_blng_grp_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )243;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_blng_grp_desc;
    sqlstm.sqhstl[0] = (unsigned int  )42;
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

    bl_blng_grp_desc.arr[bl_blng_grp_desc.len] = '\0';

}

fetch_dtls()
{
   /* EXEC SQL OPEN BL_PAT_NAME_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0005;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )262;
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
   bl_patient_nam1.arr[0]                    = '\0';

   bl_patient_name_loc_lang.len              = 0;
   bl_patient_name.len                       = 0;
   bl_patient_nam1.len                       = 0;

    /* EXEC SQL FETCH BL_PAT_NAME_CUR
              INTO :bl_patient_name_loc_lang,
                   /o:bl_patient_name,
				   :bl_patient_nam1,o/
                           :d_short_name_full; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )285;
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
	bl_patient_nam1.arr[bl_patient_nam1.len] = '\0';
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
         :bl_patient_nam1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_patient_nam1    := :bl_patient_nam1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 17;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ; \
BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str2\
 ) ; IF str2 IS NOT NULL THEN :bl_patient_name := str2 ; END IF ; blcommon . s\
plit_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS NO\
T NULL THEN :bl_patient_nam1 := str2 ; END IF ; blcommon . split_words ( :d_sh\
ort_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :bl_pa\
tient_nam1 := :bl_patient_nam1 || str2 ; end if ; END ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )308;
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
sqlstm.sqhstv[2] = (         void  *)&bl_patient_nam1;
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
       bl_patient_nam1.arr[bl_patient_nam1.len]  = '\0';


}


print_rec(ind)
int ind;
{
  if (ind == 0)
  {
    if (lctr+2 > 35)  //35
       print_head();

    fetch_grp_desc();

	init_date_temp_var();
	strcpy(date_convert1.arr,bl_pat_cur_date.arr);
	fun_change_loc_date1();

    fprintf(fp,"%-12.12s   : %-10s",loc_legend[260],date_convert1.arr);
    fprintf(fp,"        ");
    fprintf(fp,"%17.17s : %-2s",loc_legend[250],bl_pat_cur_grp.arr);
    fprintf(fp,"  %-40.40s\n",bl_blng_grp_desc.arr);
	
	fprintf(fp,"\n");
    lctr+=2;

  }
  else 
  {

     fetch_dtls();

	 fprintf(fp,"  ");
	init_date_temp_var();
	strcpy(date_convert1.arr,bl_pat_service_date.arr);
	fun_change_loc_date1();
	
     fprintf(fp,"%-8s/%-4s %-20s %-10s %-40.40s %-10s %-5s %s ",
                bl_pat_episode_id.arr,
                bl_pat_visit_id.arr,
                bl_pat_patient_id.arr,
                bl_pat_service_code.arr,
                bl_pat_service_item_desc.arr,
                date_convert1.arr,
                bl_pat_service_time.arr,
                bl_pat_service_qty.arr);
                //bl_pat_upd_net_charge_amt.arr);
	
	//Added during HMC customization.

	 print_formated(bl_pat_net_charge_amt_db);
	 fprintf(fp,"\n");

	 //Added during HMC customization.	
//	 bl_patient_name

	 fprintf(fp,"%18s"," ");

     fprintf(fp,"%-30.30s   %-20s/%-4s/%-4s    %-20s\n",
                bl_patient_name_loc_lang.arr,
                bl_pat_trx_doc_ref.arr,
                bl_pat_trx_doc_ref_line_num.arr,
                bl_pat_trx_doc_ref_seq_num.arr,
                bl_pat_added_by_id.arr);

     fprintf(fp,"\n");

	if(strlen(bl_patient_nam1.arr) > 2)
	{
	fprintf(fp,"%-30.30s \n",bl_patient_nam1.arr);
	lctr++;
	}

     lctr+=3;

     bl_grp_tot_net_charge_amt   += bl_pat_net_charge_amt_db;

   }

   fflush(fp);
}

print_grp_tot()
{

    if (lctr+4 > 35) //55
    {
       print_head();
       print_rec(0);
    }

    fprintf(fp,"%118s---------------\n"," ");
    fprintf(fp,"%83s%-27.27s         "," ",loc_legend[240]);
    print_formated(bl_grp_tot_net_charge_amt);
    fprintf(fp,"\n");
    fprintf(fp,"%118s---------------\n"," ");
    fprintf(fp,"\n");
    lctr +=4;

    bl_dat_tot_net_charge_amt   += bl_grp_tot_net_charge_amt;

    bl_grp_tot_net_charge_amt = 0;

}

print_date_tot()
{
    print_grp_tot();
	

    if (lctr+4 > 35)  //55
    {
       print_head();
       print_rec(0);
    }

    fprintf(fp,"%118s---------------\n"," ");
    fprintf(fp,"%83s%-27.27s         "," ",loc_legend[230]);
    print_formated(bl_dat_tot_net_charge_amt);
    fprintf(fp,"\n");
    fprintf(fp,"%118s---------------\n"," ");
    fprintf(fp,"\n");
    lctr +=4;

    bl_grn_tot_net_charge_amt   += bl_dat_tot_net_charge_amt;

    bl_dat_tot_net_charge_amt = 0;

}

print_grand_tot()
{
    print_date_tot();

    if (lctr+3 > 35)  //55
    {
       print_head();
       print_rec(0);
    }

    fprintf(fp,"%118s---------------\n"," ");
    fprintf(fp,"%83s%-17.17s                   "," ",loc_legend[190]);
    print_formated(bl_grn_tot_net_charge_amt);
    fprintf(fp,"\n");
    fprintf(fp,"%118s---------------\n"," ");
    lctr +=3;
}

end_of_rep()
{
	fprintf(fp,"\n\n                                                      *** %-18s ***\n",loc_legend[360]);
	fflush(fp);
}

open_file()
{
	char filename[30];
		strcpy(filename,WORKING_DIR);
		strcat(filename,"blrmistr.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrmistr.lis");
       proc_exit();
    }
    print_title();
    print_head();
}

print_title()
{
		fprintf(fp,"%c&l1O",ESC); 		// To print in land scape mode
		fprintf(fp,"%c(s14H",ESC); 	/* To set the font size			*/
nd_episode_type.arr[0] ='\0';
nd_episode_type.len=0;
init_date_temp_var();
strcpy(date_convert.arr,date_time.arr);
fun_change_loc_date();
fprintf(fp,
"%-6.6s : %-5.5s                                         %-30s                                       %-18s\n",loc_legend[310],loc_legend[150],
hosp_name.arr,date_convert.arr);
fprintf(fp,"%-6.6s : %-10s \n",loc_legend[320],user_id.arr);
fprintf(fp,
"%-6.6s : %-12.12s                       %-55.55s                     %8.8s :%4d\n",loc_legend[330],
loc_legend[40],loc_legend[50],loc_legend[30],++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"%6.6s : 4.1\n",loc_legend[370]);
fflush(fp);

fprintf(fp,"\n\n\n\n        %-22s :\n        ---------------------\n\n",loc_legend[300]);
/* EXEC SQL SELECT decode(:nd_epi_type,'I','Inpatient','D','Daycare','E','Emergency','O','Outpatient','R','External')
         into :nd_episode_type from dual; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 17;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select decode(:b0,'I','Inpatient','D','Daycare','E','Emergenc\
y','O','Outpatient','R','External') into :b1  from dual ";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )335;
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
sqlstm.sqhstl[1] = (unsigned int  )32;
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



fprintf(fp,"                  %-17.17s                 : %s\n\n",loc_legend[220],nd_episode_type.arr);
if(nd_fm_trx_date.arr[0] !='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_fm_trx_date.arr);
fun_change_loc_date();
fprintf(fp,"                  %-15.15s        %-10.10s : %s\n",loc_legend[120],loc_legend[60],date_convert.arr);
}
else
fprintf(fp,"                  %-15.15s        %-10.10s : %s\n",loc_legend[120],loc_legend[60],loc_legend[340]);
if(nd_to_trx_date.arr[0] !='\0')
{
init_date_temp_var();
strcpy(date_convert.arr,nd_to_trx_date.arr);
fun_change_loc_date();
fprintf(fp,"                                         %-8.8s   : %s\n\n",loc_legend[70],date_convert.arr);
}
else
fprintf(fp,"                                         %-8.8s   : %s\n\n",loc_legend[70],loc_legend[350]);

if(nd_fm_blng_serv.arr[0] == '\0')
fprintf(fp,"                  %-15.15s        %-10.10s : %-10.10s\n",loc_legend[160],loc_legend[60],loc_legend[340]);
else
fprintf(fp,"                  %-15.15s        %-10.10s : %s\n",loc_legend[160],loc_legend[60],nd_fm_blng_serv.arr);
if(nd_to_blng_serv.arr[0] == '\0')
fprintf(fp,"                                         %-8.8s   : %-12.12s\n\n",loc_legend[70],loc_legend[350]);
else
fprintf(fp,"                                         %-8.8s   : %s\n\n",loc_legend[70],nd_to_blng_serv.arr);
nd_episode_type.arr[nd_episode_type.len]='\0';
}


print_head()
{
init_date_temp_var();
strcpy(date_convert.arr,date_time.arr);
fun_change_loc_date();
fprintf(fp,
"\f%-6.6s : %-5.5s                                         %-30s                                       %-15s\n",loc_legend[310],loc_legend[150],
hosp_name.arr,date_convert.arr);
fprintf(fp,"%-6.6s : %-10s \n",loc_legend[320], user_id.arr);
fprintf(fp,
"%-6.6s : %-12.12s                       %-55.55s                     %8.8s :%4d\n",loc_legend[330],
loc_legend[40],loc_legend[50],loc_legend[30],++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,
"  %-14.14s %-17.17s   %-17.17s&%-33.33s %-18.18s %-11.11s %13.13s\n",loc_legend[80],loc_legend[90],loc_legend[100],loc_legend[110],loc_legend[130],loc_legend[140],loc_legend[170]);
fprintf(fp,
"                  %-30.30s   %-30.30s    %-15.15s \n",loc_legend[180],loc_legend[200],loc_legend[210]);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fflush(fp);
lctr = 7;
}
/*
fprintf(fp,
"  Episode Dtls    Patient No         Blng Serv Code & Serv Item Description             Service Date/Time  Service Qty     Net Charge\n");
fprintf(fp,
"                  Patient Name                     Trx Doc Ref/Line                  Added By \n");*/
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
               FROM SY_ACC_ENTITY_lang_vw
			  WHERE acc_entity_id = :d_facility_id
			  AND language_id =:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (acc_entity_id=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )358;
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

/*print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (loc_amount >= 0)
   {
      sprintf(out_str,"%15.2f",loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%14s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%15.2f",-loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%14s-",out_str1);
   }
} */ //Old commented and added below during HMC customization.

print_formated(l_amt)
double l_amt;
{
	char  s_amt[15];

    if(l_amt < 0)
	{
        put_val(s_amt,-l_amt);
        format_amt(s_amt);
		fprintf(fp,"%14s-",s_amt);
    }
    else 
	{
        put_val(s_amt,l_amt);
        format_amt(s_amt);
		fprintf(fp,"%14s ",s_amt);
    }
}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRMISTR.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRMISTR.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )393;
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
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )416;
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
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )447;
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

		//get_locale_date.CONVERT_TO_LOCALE_DATE (to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date1);  
      
		 //:nd_loc_date1 := to_char(t_date1,'DD-MON-YYYY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date1 date ; BEGIN :nd_loc_date1 := sm_convert_dat\
e_2t ( to_date ( :nd_temp_date1 , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; \
END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )474;
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