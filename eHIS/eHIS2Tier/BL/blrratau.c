
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
    "T:\\temp\\Bl\\ganapathy\\JDWORK\\PROC\\Blrratau.pc"
};


static unsigned long sqlctx = 1267618285;


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
            void  *sqhstv[16];
   unsigned int   sqhstl[16];
            int   sqhsts[16];
            void  *sqindv[16];
            int   sqinds[16];
   unsigned int   sqharm[16];
   unsigned int   *sqharc[16];
   unsigned short  sqadto[16];
   unsigned short  sqtdso[16];
} sqlstm = {10,16};

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
"select BLNG_SERV_CODE_FROM ,BLNG_SERV_CODE_TO ,SERV_ANAL_GRP1_FROM ,SERV_ANA\
L_GRP1_TO ,SERV_ANAL_GRP2_FROM ,SERV_ANAL_GRP2_TO ,MARKUP_CRITERIA_FLAG ,TO_CH\
AR(MARKUP_DEF_CHARGE,'999,999,990.99') ,TO_CHAR(MARKUP_IP_RATE,'999,990.99') ,\
TO_CHAR(MARKUP_OP_RATE,'999,990.99') ,TO_CHAR(MARKUP_REF_RATE,'999,990.99') ,T\
O_CHAR(RECORDS_READ_NUM,'999,999,990') ,TO_CHAR(RECORDS_UPDATED_NUM,'999,999,9\
90') ,TO_CHAR(RECORDS_NOT_UPDATED_NUM,'999,999,990') ,MODIFIED_BY_ID ,TO_CHAR(\
MODIFIED_DATE,'DD/MM/YYYY HH24:MI')  from BL_RATE_AUDIT_HDR where MODIFIED_DAT\
E between TO_DATE(:b0,'DD/MM/YYYY HH24:MI') and TO_DATE(:b1,'DD/MM/YYYY HH24:M\
I') order by MODIFIED_DATE,MODIFIED_BY_ID            ";

 static const char *sq0005 = 
"select BLNG_SERV_CODE ,TO_CHAR(NVL(OLD_DEF_CHARGE,0),'999,999,990.99') ,TO_C\
HAR(NVL(OLD_IP_RATE,0),'999,990.99') ,TO_CHAR(NVL(OLD_OP_RATE,0),'999,990.99')\
 ,TO_CHAR(NVL(OLD_REF_RATE,0),'999,990.99') ,TO_CHAR(NVL(NEW_DEF_CHARGE,0),'99\
9,999,990.99') ,TO_CHAR(NVL(NEW_IP_RATE,0),'999,990.99') ,TO_CHAR(NVL(NEW_OP_R\
ATE,0),'999,990.99') ,TO_CHAR(NVL(NEW_REF_RATE,0),'999,990.99') ,MODIFICATION_\
STATUS ,MODIFICATION_MODE ,MODIFIED_BY_ID ,TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY H\
H24:MI')  from BL_RATE_AUDIT_DTL where (((MODIFIED_DATE=NVL(TO_DATE(:b0,'DD/MM\
/YYYY HH24:MI'),MODIFIED_DATE) and MODIFIED_BY_ID=NVL(:b1,MODIFIED_BY_ID)) and\
 MODIFICATION_STATUS=NVL(:b2,MODIFICATION_STATUS)) and MODIFICATION_MODE=NVL(:\
b3,MODIFICATION_MODE)) order by BLNG_SERV_CODE            ";

 static const char *sq0006 = 
"select LONG_DESC  from BL_BLNG_SERV where BLNG_SERV_CODE=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,180,0,0,0,0,0,1,0,
20,0,0,2,218,0,4,208,0,0,11,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
79,0,0,3,91,0,2,247,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
102,0,0,4,675,0,9,318,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
125,0,0,5,758,0,9,325,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
156,0,0,4,0,0,13,375,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,
235,0,0,5,0,0,13,445,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
302,0,0,7,128,0,4,576,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
333,0,0,6,71,0,9,684,0,0,1,1,0,1,0,1,9,0,0,
352,0,0,6,0,0,13,691,0,0,1,0,0,1,0,2,9,0,0,
371,0,0,8,74,0,4,706,0,0,4,3,0,1,0,1,9,0,0,1,3,0,0,1,3,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRRATAU.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 24-JUL-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION              :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */  
/*                                                                      */
/*          1.         BL_RATE_AUDIT_HDR         Read                   */
/*          2.         BL_RATE_AUDIT_DTL         Read                   */
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
#define INIT_MESG "Report Generation In Progress"

int lctr = 0,pctr = 0;

FILE *fp;


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name        [135],
            date_time        [20],
            user_id          [40],
            nd_session_id    [16],
            nd_pgm_date      [25],
            d_curr_pgm_name  [15],
            nd_rep_type      [2],
            nd_mod_date_fm   [17],
            nd_mod_date_to   [17],
            nd_mod_status    [2],
            nd_mod_mode      [2],
            nd_bill_serv_fm  [11],
            nd_bill_serv_to  [11],
		    nd_facility_id   [3],
		    nd_ws_no         [31]; */ 
struct { unsigned short len; unsigned char arr[135]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[2]; } nd_rep_type;

struct { unsigned short len; unsigned char arr[17]; } nd_mod_date_fm;

struct { unsigned short len; unsigned char arr[17]; } nd_mod_date_to;

struct { unsigned short len; unsigned char arr[2]; } nd_mod_status;

struct { unsigned short len; unsigned char arr[2]; } nd_mod_mode;

struct { unsigned short len; unsigned char arr[11]; } nd_bill_serv_fm;

struct { unsigned short len; unsigned char arr[11]; } nd_bill_serv_to;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_ws_no;



   /* VARCHAR bl_au_blng_serv_code_from                   [11],
           bl_au_blng_serv_code_to                     [11],
           bl_au_serv_anal_grp1_from                   [7],
           bl_au_serv_anal_grp1_to                     [7],
           bl_au_serv_anal_grp2_from                   [7],
           bl_au_serv_anal_grp2_to                     [7],
           bl_au_markup_criteria_flag                  [2],
           bl_au_markup_def_charge                     [23],
           bl_au_markup_ip_rate                        [23],
           bl_au_markup_op_rate                        [23],
           bl_au_markup_ref_rate                       [23],
           bl_au_records_read_num                      [23],
           bl_au_records_updated_num                   [23],
           bl_au_records_not_update_num               [23],
           bl_au_modified_by_id                        [21],
           bl_au_modified_date_time                    [19]; */ 
struct { unsigned short len; unsigned char arr[11]; } bl_au_blng_serv_code_from;

struct { unsigned short len; unsigned char arr[11]; } bl_au_blng_serv_code_to;

struct { unsigned short len; unsigned char arr[7]; } bl_au_serv_anal_grp1_from;

struct { unsigned short len; unsigned char arr[7]; } bl_au_serv_anal_grp1_to;

struct { unsigned short len; unsigned char arr[7]; } bl_au_serv_anal_grp2_from;

struct { unsigned short len; unsigned char arr[7]; } bl_au_serv_anal_grp2_to;

struct { unsigned short len; unsigned char arr[2]; } bl_au_markup_criteria_flag;

struct { unsigned short len; unsigned char arr[23]; } bl_au_markup_def_charge;

struct { unsigned short len; unsigned char arr[23]; } bl_au_markup_ip_rate;

struct { unsigned short len; unsigned char arr[23]; } bl_au_markup_op_rate;

struct { unsigned short len; unsigned char arr[23]; } bl_au_markup_ref_rate;

struct { unsigned short len; unsigned char arr[23]; } bl_au_records_read_num;

struct { unsigned short len; unsigned char arr[23]; } bl_au_records_updated_num;

struct { unsigned short len; unsigned char arr[23]; } bl_au_records_not_update_num;

struct { unsigned short len; unsigned char arr[21]; } bl_au_modified_by_id;

struct { unsigned short len; unsigned char arr[19]; } bl_au_modified_date_time;


   /* VARCHAR bl_dtl_blng_serv_code                       [11],
           bl_dtl_old_def_charge                       [23],
           bl_dtl_old_ip_rate                          [23],
           bl_dtl_old_op_rate                          [23],
           bl_dtl_old_ref_rate                         [23],
           bl_dtl_new_def_charge                       [23],
           bl_dtl_new_ip_rate                          [23],
           bl_dtl_new_op_rate                          [23],
           bl_dtl_new_ref_rate                         [23],
           bl_dtl_modification_status                  [2],
           bl_dtl_modification_mode                    [2],
           bl_dtl_modified_by_id                       [21],
           bl_dtl_modified_date_time                   [19],
           nd_blng_serv_long_desc                      [41],
           rec_ctr_str                                 [20]; */ 
struct { unsigned short len; unsigned char arr[11]; } bl_dtl_blng_serv_code;

struct { unsigned short len; unsigned char arr[23]; } bl_dtl_old_def_charge;

struct { unsigned short len; unsigned char arr[23]; } bl_dtl_old_ip_rate;

struct { unsigned short len; unsigned char arr[23]; } bl_dtl_old_op_rate;

struct { unsigned short len; unsigned char arr[23]; } bl_dtl_old_ref_rate;

struct { unsigned short len; unsigned char arr[23]; } bl_dtl_new_def_charge;

struct { unsigned short len; unsigned char arr[23]; } bl_dtl_new_ip_rate;

struct { unsigned short len; unsigned char arr[23]; } bl_dtl_new_op_rate;

struct { unsigned short len; unsigned char arr[23]; } bl_dtl_new_ref_rate;

struct { unsigned short len; unsigned char arr[2]; } bl_dtl_modification_status;

struct { unsigned short len; unsigned char arr[2]; } bl_dtl_modification_mode;

struct { unsigned short len; unsigned char arr[21]; } bl_dtl_modified_by_id;

struct { unsigned short len; unsigned char arr[19]; } bl_dtl_modified_date_time;

struct { unsigned short len; unsigned char arr[41]; } nd_blng_serv_long_desc;

struct { unsigned short len; unsigned char arr[20]; } rec_ctr_str;



    char   nd_old_blng_serv_code                       [11];
	char filename[30];

    long   rec_ctr = 0,
           dtl_rec_ctr = 0;

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/blrratau.c-arc   1.0   Apr 19 2007 17:06:54   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/blrratau.c-arc   1.0   Apr 19 2007 17:06:54   vcm_th  $ sqlda.h 
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
 
    strcpy(g_pgm_id,"BLRRATAU");

    if (sql_connect(argv[1]) == -1)
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

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

    start_prog_msg();

    fetch_prog_param();

    declare_cur();
    fetch_hosp_name();
    open_file();

    if (nd_rep_type.arr[0] != 'D')
    {
        open_cur_hdr();
        while(fetch_cur())
        {
          int dtl_ctr = 0;
          rec_ctr++;
          if (nd_rep_type.arr[0] != 'S')
          {
               if (nd_rep_type.arr[0] == 'B')
                    print_hdr();
               open_cur_dtl();
               while (fetch_dtl())
                  print_dtl(++dtl_ctr);
               dtl_rec_ctr+=dtl_ctr;
          }
          if (nd_rep_type.arr[0] == 'S')
               print_hdr();
        }
    }
    else
    {
          int dtl_ctr = 0;
          rec_ctr++;
          open_cur_dtl();
          while (fetch_dtl())
             print_dtl(++dtl_ctr);
          dtl_rec_ctr+=dtl_ctr;
    }
    end_of_rep();
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



    return;
}

fetch_prog_param()
{

nd_rep_type.arr[0]       = '\0';
nd_mod_date_fm.arr[0]    = '\0';
nd_mod_date_to.arr[0]    = '\0';
nd_mod_status.arr[0]     = '\0';
nd_mod_mode.arr[0]       = '\0';
nd_bill_serv_fm.arr[0]   = '\0';
nd_bill_serv_to.arr[0]   = '\0';
nd_facility_id.arr[0]      = '\0'; 
nd_ws_no.arr[0]            = '\0';

nd_rep_type.len          = 0;
nd_mod_date_fm.len       = 0;
nd_mod_date_to.len       = 0;
nd_mod_status.len        = 0;
nd_mod_mode.len          = 0;
nd_bill_serv_fm.len      = 0;
nd_bill_serv_to.len      = 0;
nd_facility_id.len         = 0; 
nd_ws_no.len               = 0;

   /* EXEC SQL SELECT operating_facility_id,
                   PARAM1,
				   PARAM2,
				   PARAM3,
				   PARAM4,
				   PARAM5,
				   PARAM6,
				   PARAM7,
				   PARAM8
              INTO :nd_facility_id,
			       :nd_rep_type,   
				   :nd_mod_date_fm, 
				   :nd_mod_date_to,
                   :nd_mod_status, 
				   :nd_mod_mode,    
				   :nd_bill_serv_fm,
                   :nd_bill_serv_to,
				   :nd_ws_no
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'BLRRATAU'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  f\
rom SY_PROG_PARAM where ((PGM_ID='BLRRATAU' and SESSION_ID=:b9) and PGM_DATE=:\
b10)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )20;
   sqlstm.selerr = (unsigned short)1;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_rep_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_mod_date_fm;
   sqlstm.sqhstl[2] = (unsigned int  )19;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_mod_date_to;
   sqlstm.sqhstl[3] = (unsigned int  )19;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_mod_status;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_mod_mode;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_bill_serv_fm;
   sqlstm.sqhstl[6] = (unsigned int  )13;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_bill_serv_to;
   sqlstm.sqhstl[7] = (unsigned int  )13;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[8] = (unsigned int  )33;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[10] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_rep_type.arr[nd_rep_type.len]               = '\0';
   nd_mod_date_fm.arr[nd_mod_date_fm.len]         = '\0';
   nd_mod_date_to.arr[nd_mod_date_to.len]         = '\0';
   nd_mod_status.arr[nd_mod_status.len]           = '\0';
   nd_mod_mode.arr[nd_mod_mode.len]               = '\0';
   nd_bill_serv_fm.arr[nd_bill_serv_fm.len]       = '\0';
   nd_bill_serv_to.arr[nd_bill_serv_to.len]       = '\0';
   nd_facility_id.arr[nd_facility_id.len]         = '\0';
   strcpy(g_facility_id,nd_facility_id.arr);  

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = 'BLRRATAU'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRRATAU' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )79;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_pgm_date;
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



   if (OERROR)
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");
}

declare_cur()
{

     /* EXEC SQL DECLARE BL_RATE_HDR_CUR CURSOR FOR
               SELECT BLNG_SERV_CODE_FROM,
                      BLNG_SERV_CODE_TO,
                      SERV_ANAL_GRP1_FROM,
                      SERV_ANAL_GRP1_TO,
                      SERV_ANAL_GRP2_FROM,
                      SERV_ANAL_GRP2_TO,
                      MARKUP_CRITERIA_FLAG,
                      TO_CHAR(MARKUP_DEF_CHARGE,'999,999,990.99'),
                      TO_CHAR(MARKUP_IP_RATE,'999,990.99'),
                      TO_CHAR(MARKUP_OP_RATE,'999,990.99'),
                      TO_CHAR(MARKUP_REF_RATE,'999,990.99'),
                      TO_CHAR(RECORDS_READ_NUM,'999,999,990'),
                      TO_CHAR(RECORDS_UPDATED_NUM,'999,999,990'),
                      TO_CHAR(RECORDS_NOT_UPDATED_NUM,'999,999,990'),
                      MODIFIED_BY_ID,
                      TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI')
                 FROM BL_RATE_AUDIT_HDR
                WHERE MODIFIED_DATE BETWEEN
                          TO_DATE(:nd_mod_date_fm,'DD/MM/YYYY HH24:MI')
                      AND
                          TO_DATE(:nd_mod_date_to,'DD/MM/YYYY HH24:MI')
                ORDER BY MODIFIED_DATE,MODIFIED_BY_ID; */ 


     /* EXEC SQL DECLARE BL_RATE_DTL_CUR CURSOR FOR
               SELECT BLNG_SERV_CODE,
                      TO_CHAR(NVL(OLD_DEF_CHARGE,0),'999,999,990.99'),
                      TO_CHAR(NVL(OLD_IP_RATE,0),'999,990.99'),
                      TO_CHAR(NVL(OLD_OP_RATE,0),'999,990.99'),
                      TO_CHAR(NVL(OLD_REF_RATE,0),'999,990.99'),
                      TO_CHAR(NVL(NEW_DEF_CHARGE,0),'999,999,990.99'),
                      TO_CHAR(NVL(NEW_IP_RATE,0),'999,990.99'),
                      TO_CHAR(NVL(NEW_OP_RATE,0),'999,990.99'),
                      TO_CHAR(NVL(NEW_REF_RATE,0),'999,990.99'),
                      MODIFICATION_STATUS,
                      MODIFICATION_MODE,
                      MODIFIED_BY_ID,
                      TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI')
                 FROM BL_RATE_AUDIT_DTL
                WHERE MODIFIED_DATE = 
                            NVL(TO_DATE(:bl_au_modified_date_time,
                                            'DD/MM/YYYY HH24:MI'),
                                           MODIFIED_DATE)
                  AND MODIFIED_BY_ID      = NVL(:bl_au_modified_by_id,
                                           MODIFIED_BY_ID)
                  AND MODIFICATION_STATUS = NVL(:nd_mod_status,
                                                 MODIFICATION_STATUS)
                  AND MODIFICATION_MODE   = NVL(:nd_mod_mode,MODIFICATION_MODE)
                ORDER BY BLNG_SERV_CODE; */ 


     /* EXEC SQL DECLARE BL_BLNG_DESC_CUR CURSOR FOR
               SELECT LONG_DESC
                 FROM BL_BLNG_SERV
                WHERE BLNG_SERV_CODE = :bl_dtl_blng_serv_code; */ 


}

open_cur_hdr()
{
    /* EXEC SQL OPEN BL_RATE_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )102;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_mod_date_fm;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_mod_date_to;
    sqlstm.sqhstl[1] = (unsigned int  )19;
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


    if (OERROR)  err_mesg("OPEN failed on cursor BL_RATE_HDR_CUR",0,"");

}

open_cur_dtl()
{
    /* EXEC SQL OPEN BL_RATE_DTL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )125;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_au_modified_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )21;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_au_modified_by_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_mod_status;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_mod_mode;
    sqlstm.sqhstl[3] = (unsigned int  )4;
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


    if (OERROR)  err_mesg("OPEN failed on cursor BL_RATE_DTL_CUR",0,"");

}

end_of_rep()
{
fprintf(fp,"\n\n            TOTAL NUMBER OF RECORDS PRINTED : ");
print_formated();
fprintf(fp,"\n                                                      ***  END OF REPORT ***\n");
}

fetch_cur()
{

bl_au_blng_serv_code_from.arr[0]                                  = '\0';
bl_au_blng_serv_code_to.arr[0]                                    = '\0';
bl_au_serv_anal_grp1_from.arr[0]                                  = '\0';
bl_au_serv_anal_grp1_to.arr[0]                                    = '\0';
bl_au_serv_anal_grp2_from.arr[0]                                  = '\0';
bl_au_serv_anal_grp2_to.arr[0]                                    = '\0';
bl_au_markup_criteria_flag.arr[0]                                 = '\0';
bl_au_markup_def_charge.arr[0]                                    = '\0';
bl_au_markup_ip_rate.arr[0]                                       = '\0';
bl_au_markup_op_rate.arr[0]                                       = '\0';
bl_au_markup_ref_rate.arr[0]                                      = '\0';
bl_au_records_read_num.arr[0]                                     = '\0';
bl_au_records_updated_num.arr[0]                                  = '\0';
bl_au_records_not_update_num.arr[0]                              = '\0';
bl_au_modified_by_id.arr[0]                                       = '\0';
bl_au_modified_date_time.arr[0]                                   = '\0';

bl_au_blng_serv_code_from.len                                     = 0;
bl_au_blng_serv_code_to.len                                       = 0;
bl_au_serv_anal_grp1_from.len                                     = 0;
bl_au_serv_anal_grp1_to.len                                       = 0;
bl_au_serv_anal_grp2_from.len                                     = 0;
bl_au_serv_anal_grp2_to.len                                       = 0;
bl_au_markup_criteria_flag.len                                    = 0;
bl_au_markup_def_charge.len                                       = 0;
bl_au_markup_ip_rate.len                                          = 0;
bl_au_markup_op_rate.len                                          = 0;
bl_au_markup_ref_rate.len                                         = 0;
bl_au_records_read_num.len                                        = 0;
bl_au_records_updated_num.len                                     = 0;
bl_au_records_not_update_num.len                                 = 0;
bl_au_modified_by_id.len                                          = 0;
bl_au_modified_date_time.len                                      = 0;


     /* EXEC SQL FETCH BL_RATE_HDR_CUR
               INTO :bl_au_blng_serv_code_from,
                    :bl_au_blng_serv_code_to,
                    :bl_au_serv_anal_grp1_from,
                    :bl_au_serv_anal_grp1_to,
                    :bl_au_serv_anal_grp2_from,
                    :bl_au_serv_anal_grp2_to,
                    :bl_au_markup_criteria_flag,
                    :bl_au_markup_def_charge,
                    :bl_au_markup_ip_rate,
                    :bl_au_markup_op_rate,
                    :bl_au_markup_ref_rate,
                    :bl_au_records_read_num,
                    :bl_au_records_updated_num,
                    :bl_au_records_not_update_num,
                    :bl_au_modified_by_id,
                    :bl_au_modified_date_time; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 16;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )156;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_au_blng_serv_code_from;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_au_blng_serv_code_to;
     sqlstm.sqhstl[1] = (unsigned int  )13;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_au_serv_anal_grp1_from;
     sqlstm.sqhstl[2] = (unsigned int  )9;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_au_serv_anal_grp1_to;
     sqlstm.sqhstl[3] = (unsigned int  )9;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_au_serv_anal_grp2_from;
     sqlstm.sqhstl[4] = (unsigned int  )9;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_au_serv_anal_grp2_to;
     sqlstm.sqhstl[5] = (unsigned int  )9;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_au_markup_criteria_flag;
     sqlstm.sqhstl[6] = (unsigned int  )4;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_au_markup_def_charge;
     sqlstm.sqhstl[7] = (unsigned int  )25;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_au_markup_ip_rate;
     sqlstm.sqhstl[8] = (unsigned int  )25;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_au_markup_op_rate;
     sqlstm.sqhstl[9] = (unsigned int  )25;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_au_markup_ref_rate;
     sqlstm.sqhstl[10] = (unsigned int  )25;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_au_records_read_num;
     sqlstm.sqhstl[11] = (unsigned int  )25;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_au_records_updated_num;
     sqlstm.sqhstl[12] = (unsigned int  )25;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_au_records_not_update_num;
     sqlstm.sqhstl[13] = (unsigned int  )25;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_au_modified_by_id;
     sqlstm.sqhstl[14] = (unsigned int  )23;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_au_modified_date_time;
     sqlstm.sqhstl[15] = (unsigned int  )21;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
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



    if (OERROR) err_mesg("Error while fetching BL_RATE_HDR_CUR",0,"");

bl_au_blng_serv_code_from.arr[bl_au_blng_serv_code_from.len]             = '\0';
bl_au_blng_serv_code_to.arr[bl_au_blng_serv_code_to.len]                 = '\0';
bl_au_serv_anal_grp1_from.arr[bl_au_serv_anal_grp1_from.len]             = '\0';
bl_au_serv_anal_grp1_to.arr[bl_au_serv_anal_grp1_to.len]                 = '\0';
bl_au_serv_anal_grp2_from.arr[bl_au_serv_anal_grp2_from.len]             = '\0';
bl_au_serv_anal_grp2_to.arr[bl_au_serv_anal_grp2_to.len]                 = '\0';
bl_au_markup_criteria_flag.arr[bl_au_markup_criteria_flag.len]           = '\0';
bl_au_markup_def_charge.arr[bl_au_markup_def_charge.len]                 = '\0';
bl_au_markup_ip_rate.arr[bl_au_markup_ip_rate.len]                       = '\0';
bl_au_markup_op_rate.arr[bl_au_markup_op_rate.len]                       = '\0';
bl_au_markup_ref_rate.arr[bl_au_markup_ref_rate.len]                     = '\0';
bl_au_records_read_num.arr[bl_au_records_read_num.len]                   = '\0';
bl_au_records_updated_num.arr[bl_au_records_updated_num.len]             = '\0';
bl_au_records_not_update_num.arr[bl_au_records_not_update_num.len]     = '\0';
bl_au_modified_by_id.arr[bl_au_modified_by_id.len]                       = '\0';
bl_au_modified_date_time.arr[bl_au_modified_date_time.len]               = '\0';

  return(LAST_ROW?0:1);
}

fetch_dtl()
{
bl_dtl_blng_serv_code.arr[0]                                      = '\0';
bl_dtl_old_def_charge.arr[0]                                      = '\0';
bl_dtl_old_ip_rate.arr[0]                                         = '\0';
bl_dtl_old_op_rate.arr[0]                                         = '\0';
bl_dtl_old_ref_rate.arr[0]                                        = '\0';
bl_dtl_new_def_charge.arr[0]                                      = '\0';
bl_dtl_new_ip_rate.arr[0]                                         = '\0';
bl_dtl_new_op_rate.arr[0]                                         = '\0';
bl_dtl_new_ref_rate.arr[0]                                        = '\0';
bl_dtl_modification_status.arr[0]                                 = '\0';
bl_dtl_modification_mode.arr[0]                                   = '\0';
bl_dtl_modified_by_id.arr[0]                                      = '\0';
bl_dtl_modified_date_time.arr[0]                                  = '\0';

bl_dtl_blng_serv_code.len                                         = 0;
bl_dtl_old_def_charge.len                                         = 0;
bl_dtl_old_ip_rate.len                                            = 0;
bl_dtl_old_op_rate.len                                            = 0;
bl_dtl_old_ref_rate.len                                           = 0;
bl_dtl_new_def_charge.len                                         = 0;
bl_dtl_new_ip_rate.len                                            = 0;
bl_dtl_new_op_rate.len                                            = 0;
bl_dtl_new_ref_rate.len                                           = 0;
bl_dtl_modification_status.len                                    = 0;
bl_dtl_modification_mode.len                                      = 0;
bl_dtl_modified_by_id.len                                         = 0;
bl_dtl_modified_date_time.len                                     = 0;

     /* EXEC SQL FETCH BL_RATE_DTL_CUR
               INTO :bl_dtl_blng_serv_code,
                    :bl_dtl_old_def_charge,
                    :bl_dtl_old_ip_rate,
                    :bl_dtl_old_op_rate,
                    :bl_dtl_old_ref_rate,
                    :bl_dtl_new_def_charge,
                    :bl_dtl_new_ip_rate,
                    :bl_dtl_new_op_rate,
                    :bl_dtl_new_ref_rate,
                    :bl_dtl_modification_status,
                    :bl_dtl_modification_mode,
                    :bl_dtl_modified_by_id,
                    :bl_dtl_modified_date_time; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 16;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )235;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_dtl_blng_serv_code;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_dtl_old_def_charge;
     sqlstm.sqhstl[1] = (unsigned int  )25;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_dtl_old_ip_rate;
     sqlstm.sqhstl[2] = (unsigned int  )25;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_dtl_old_op_rate;
     sqlstm.sqhstl[3] = (unsigned int  )25;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_dtl_old_ref_rate;
     sqlstm.sqhstl[4] = (unsigned int  )25;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_dtl_new_def_charge;
     sqlstm.sqhstl[5] = (unsigned int  )25;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_dtl_new_ip_rate;
     sqlstm.sqhstl[6] = (unsigned int  )25;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_dtl_new_op_rate;
     sqlstm.sqhstl[7] = (unsigned int  )25;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_dtl_new_ref_rate;
     sqlstm.sqhstl[8] = (unsigned int  )25;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_dtl_modification_status;
     sqlstm.sqhstl[9] = (unsigned int  )4;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_dtl_modification_mode;
     sqlstm.sqhstl[10] = (unsigned int  )4;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_dtl_modified_by_id;
     sqlstm.sqhstl[11] = (unsigned int  )23;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_dtl_modified_date_time;
     sqlstm.sqhstl[12] = (unsigned int  )21;
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
         err_mesg("FETCH failed on cursor BL_RATE_DTL_CUR",0,"");

bl_dtl_blng_serv_code.arr[bl_dtl_blng_serv_code.len]                     = '\0';
bl_dtl_old_def_charge.arr[bl_dtl_old_def_charge.len]                     = '\0';
bl_dtl_old_ip_rate.arr[bl_dtl_old_ip_rate.len]                           = '\0';
bl_dtl_old_op_rate.arr[bl_dtl_old_op_rate.len]                           = '\0';
bl_dtl_old_ref_rate.arr[bl_dtl_old_ref_rate.len]                         = '\0';
bl_dtl_new_def_charge.arr[bl_dtl_new_def_charge.len]                     = '\0';
bl_dtl_new_ip_rate.arr[bl_dtl_new_ip_rate.len]                           = '\0';
bl_dtl_new_op_rate.arr[bl_dtl_new_op_rate.len]                           = '\0';
bl_dtl_new_ref_rate.arr[bl_dtl_new_ref_rate.len]                         = '\0';
bl_dtl_modification_status.arr[bl_dtl_modification_status.len]           = '\0';
bl_dtl_modification_mode.arr[bl_dtl_modification_mode.len]               = '\0';
bl_dtl_modified_by_id.arr[bl_dtl_modified_by_id.len]                     = '\0';
bl_dtl_modified_date_time.arr[bl_dtl_modified_date_time.len]             = '\0';

   return(LAST_ROW?0:1);
}

open_file()
{


	strcpy(filename,WORKING_DIR);
    strcat(filename,"blrratau.lis");


    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrratau.lis");
       proc_exit();
    }
    print_title();
    print_head();
}


print_title()
{
fprintf(fp,
"\fMDL : BL                                         %-30s                                        %-16s\n",
hosp_name.arr,date_time.arr);
fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                  %-50s%-15s                         PAGE : %4d\n",
"BLRRATAU","AUDIT TRAIL OF SERVICE RATE/CHARGE MODIFICATION - ",
(nd_rep_type.arr[0] == 'S')?"SUMMARY":
(nd_rep_type.arr[0] == 'D')?"DETAIL":"SUMMARY/DETAIL",
++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 1.10.01\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");
fprintf(fp,"                REPORT TYPE            : %s\n\n",nd_rep_type.arr);
fprintf(fp,"                MODIFICATION DATE FROM : %s\n",nd_mod_date_fm.arr);
fprintf(fp,"                                  TO   : %s\n\n",nd_mod_date_to.arr);

if (nd_rep_type.arr[0] != 'S')
{
fprintf(fp,"                MODIFICATION STATUS    : %s\n\n",nd_mod_status.arr);
fprintf(fp,"                MODIFICATION MODE      : %s\n\n",nd_mod_mode.arr);
fprintf(fp,"                BILLING SERVICE   FROM : %s\n\n",nd_bill_serv_fm.arr);
fprintf(fp,"                                  TO   : %s\n\n",nd_bill_serv_to.arr);
}
}
print_head()
{
fprintf(fp,
"\fMDL : BL                                         %-30s                                        %-16s\n",
hosp_name.arr,date_time.arr);
fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                  %-50s%-15s                         PAGE : %4d\n",
"BLRRATAU","AUDIT TRAIL OF SERVICE RATE/CHARGE MODIFICATION - ",
(nd_rep_type.arr[0] == 'S')?"SUMMARY":
(nd_rep_type.arr[0] == 'D')?"DETAIL":"SUMMARY/DETAIL",
++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
if (nd_rep_type.arr[0] != 'D')
{
fprintf(fp,
"MODIFN DATE TIME MODIFIED BY          BILLING SERVICE    ANALYSIS GRP 1    ANALYSIS GRP 2    MK\n");
/***********
"DD/MM/YYYY HH:MI 12345678901234567890 XXXXXX - XXXXXX XXXXXX - XXXXXX XXXXXX - XXXXXX    
********/
fprintf(fp,
"                                        FROM   - TO       FROM   - TO        FROM   - TO     CR\n");
fprintf(fp,
"                      DEF CHARGE          IP RATE       OP RATE      REF RATE         REC READ    REC UPDATED   REC NOT UPDATED\n");
}
else
{
   fprintf(fp,"BLNG SERV DESCRIPTION                              STATUS MODE\n");
}
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fflush(fp);
lctr = 8;
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
               FROM SY_ACC_ENTITY
			   WHERE acc_entity_id = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )302;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&hosp_name;
    sqlstm.sqhstl[0] = (unsigned int  )137;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
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

print_hdr()
{
     char l_form_str[100];
     strcpy(l_form_str,"%-16s %-20s %-10s %-10s %-6s   %-6s    %-6s   %-6s  %s\n");
     fprintf(fp,l_form_str,
     bl_au_modified_date_time.arr,
     bl_au_modified_by_id.arr,
     bl_au_blng_serv_code_from.arr,
     bl_au_blng_serv_code_to.arr,
     bl_au_serv_anal_grp1_from.arr,
     bl_au_serv_anal_grp1_to.arr,
     bl_au_serv_anal_grp2_from.arr,
     bl_au_serv_anal_grp2_to.arr,
     bl_au_markup_criteria_flag.arr);

     strcpy(l_form_str,"%-16s %15s      %10s   %10s   %10s     %11s   %11s      %11s\n");

     fprintf(fp,l_form_str,
     " ",
     bl_au_markup_def_charge.arr,
     bl_au_markup_ip_rate.arr,
     bl_au_markup_op_rate.arr,
     bl_au_markup_ref_rate.arr,
     bl_au_records_read_num.arr,
     bl_au_records_updated_num.arr,
     bl_au_records_not_update_num.arr);

     fflush(fp);
}

print_dtl(dtl_ctr)
int dtl_ctr;
{
   char l_form_str[100];
   if (lctr > 52)
   {
       print_head();
       if (nd_rep_type.arr[0] == 'B')
            print_dtl_head();
   }
   else if (dtl_ctr == 1 && nd_rep_type.arr[0] == 'B')
          print_dtl_head();

   if (nd_rep_type.arr[0] == 'B')
       fprintf(fp,"        ");

   strcpy(l_form_str,"%-10s %-40s %s      %s \n");

   if (nd_old_blng_serv_code[0] == '\0' ||
       strcmp(nd_old_blng_serv_code,bl_dtl_blng_serv_code.arr) != 0);
   {
       strcpy(nd_old_blng_serv_code,bl_dtl_blng_serv_code.arr);
       fetch_blng_desc();
   }

   fprintf(fp,l_form_str,
      bl_dtl_blng_serv_code.arr,
      nd_blng_serv_long_desc.arr,
      bl_dtl_modification_status.arr,
      bl_dtl_modification_mode.arr);

   lctr++;
   if (nd_rep_type.arr[0] == 'B') fprintf(fp,"        ");

   fprintf(fp,"          DEF CHARGE        IP RATE        OP RATE       REF RATE\n");

   if (nd_rep_type.arr[0] == 'B') fprintf(fp,"        ");

   fprintf(fp,"OLD  %14s    %10s    %10s    %10s\n",
      bl_dtl_old_def_charge.arr,
      bl_dtl_old_ip_rate.arr,
      bl_dtl_old_op_rate.arr,
      bl_dtl_old_ref_rate.arr);

   if (nd_rep_type.arr[0] == 'B') fprintf(fp,"        ");

   fprintf(fp,"NEW  %14s    %10s    %10s    %10s\n\n",
      bl_dtl_new_def_charge.arr,
      bl_dtl_new_ip_rate.arr,
      bl_dtl_new_op_rate.arr,
      bl_dtl_new_ref_rate.arr);
       
   lctr+= 4;
   fflush(fp);
}

print_dtl_head()
{
   fprintf(fp,"        BLNG SERV DESCRIPTION                              STATUS MODE\n\n");
   fflush(fp);
   lctr+=2;
}

fetch_blng_desc()
{
   /* EXEC SQL OPEN BL_BLNG_DESC_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )333;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_dtl_blng_serv_code;
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
         err_mesg("OPEN failed on cursor BL_BLNG_DESC_CUR",0,"");

   nd_blng_serv_long_desc.arr[0]  = '\0';
   nd_blng_serv_long_desc.len     = 0;

   /* EXEC SQL FETCH BL_BLNG_DESC_CUR
             INTO :nd_blng_serv_long_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )352;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_blng_serv_long_desc;
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
         err_mesg("FETCH failed on cursor BL_BLNG_DESC_CUR",0,"");

    nd_blng_serv_long_desc.arr[nd_blng_serv_long_desc.len] = '\0';
}

print_formated()
{

    rec_ctr_str.arr[0] = '\0';
    rec_ctr_str.len    = 0;

    /* EXEC SQL SELECT TO_CHAR(DECODE(:nd_rep_type,'D',:dtl_rec_ctr,:rec_ctr),
                         '999,999,990')
               INTO :rec_ctr_str
               FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(DECODE(:b0,'D',:b1,:b2),'999,999,990') int\
o :b3  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )371;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_rep_type;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&dtl_rec_ctr;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&rec_ctr;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&rec_ctr_str;
    sqlstm.sqhstl[3] = (unsigned int  )22;
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



   if (OERROR)
         err_mesg("SELECT failed on table DUAL",0,"");

   rec_ctr_str.arr[rec_ctr_str.len]     = '\0';

   fprintf(fp,"%s\n",rec_ctr_str.arr);
   fflush(fp);
}
