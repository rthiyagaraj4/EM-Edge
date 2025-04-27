
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blrincad.pc"
};


static unsigned int sqlctx = 1288466987;


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
            void  *sqhstv[22];
   unsigned int   sqhstl[22];
            int   sqhsts[22];
            void  *sqindv[22];
            int   sqinds[22];
   unsigned int   sqharm[22];
   unsigned int   *sqharc[22];
   unsigned short  sqadto[22];
   unsigned short  sqtdso[22];
} sqlstm = {12,22};

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

 static const char *sq0010 = 
"select FULL_NAME  from SY_PHYSICIAN_MAST where PHYSICIAN_ID=:b0           ";

 static const char *sq0009 = 
"select LONG_DESC  from SY_DEPT where (DEPT_CODE=:b0 and OPERATING_FACILITY_I\
D=:b1)           ";

 static const char *sq0008 = 
"select LONG_DESC  from SY_DEPT where (DEPT_CODE=:b0 and OPERATING_FACILITY_I\
D=:b1)           ";

 static const char *sq0006 = 
"select LONG_DESC  from BL_BLNG_SERV where BLNG_SERV_CODE=:b0           ";

 static const char *sq0007 = 
"select LONG_DESC  from BL_PACKAGE_HDR where PACKAGE_CODE=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,0,0,30,250,0,0,0,0,0,1,0,
20,0,0,2,128,0,4,265,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
51,0,0,3,371,0,4,316,0,0,22,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
154,0,0,4,91,0,2,375,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
177,0,0,5,0,0,17,432,0,0,1,1,0,1,0,1,97,0,0,
196,0,0,5,0,0,45,444,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
259,0,0,5,0,0,45,453,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
314,0,0,5,0,0,13,517,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,
381,0,0,10,74,0,9,798,0,0,1,1,0,1,0,1,9,0,0,
400,0,0,10,0,0,13,799,0,0,1,0,0,1,0,2,9,0,0,
419,0,0,9,93,0,9,810,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
442,0,0,9,0,0,13,811,0,0,1,0,0,1,0,2,9,0,0,
461,0,0,8,93,0,9,822,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
484,0,0,8,0,0,13,823,0,0,1,0,0,1,0,2,9,0,0,
503,0,0,6,71,0,9,836,0,0,1,1,0,1,0,1,9,0,0,
522,0,0,6,0,0,13,837,0,0,1,0,0,1,0,2,9,0,0,
541,0,0,7,71,0,9,841,0,0,1,1,0,1,0,1,9,0,0,
560,0,0,7,0,0,13,842,0,0,1,0,0,1,0,2,9,0,0,
579,0,0,0,0,0,27,929,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
610,0,0,12,96,0,4,1027,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
633,0,0,13,165,0,6,1034,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/*  OCS MEDICOM VER 1.10.01                                              */
/************************************************************************/
/* PROGRAM NAME          : BLRINCAD.PC                                  */
/* DATE WRITTEN          : 04-SEP-1993                                  */ 
/*                                                                      */
/* CALLED FROM           : BLRINCAL (FORM)                              */
/*                                                                      */
/* FUNCTION              :                                              */ 
/*                                                                      */ 
/*                                                                      */
/*                                                                      */ 
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        BL_SRV_INC_SUM_DTL         Query                   */
/*         2.        BL_PKG_INC_SUM_DTL         Query                   */
/*         3.        BL_BLNG_SERV               Query                   */
/*         4.        BL_PACKAGE_HDR             Lookup                  */
/*         5.        SY_DEPT                    Lookup                  */
/*         6.        SY_PHYSICIAN_MAST          Lookup                  */
/*         7.        SY_PROG_PARAM              Query/Delete            */
/*                                                                      */
/*  PARAMETERS                                                          */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/************************************************************************/
                                

#include <stdio.h>
#include <string.h>
#include "bl.h" 

#define OERROR (sqlca.sqlcode < 0)

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define INIT_MESG "Report Generatin In Progress"

/*
#define DEBUG 0
*/

#define MAXLINES 55

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd                      [132],
           hosp_name                    [120],
           date_time                    [20],
           user_id                      [30],
           nd_session_id                [16],
           nd_pgm_date                  [35],
		   l_pk_value					[100],
		   l_translated_value			[201],
		   p_language_id				[3],
		   nd_facility_id				[3]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[30]; } user_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;



   /* VARCHAR nd_pkg_serv_flag             [2],
           nd_rep_flag                  [2],
           nd_fm_blng_serv              [11],
           nd_to_blng_serv              [11],
           nd_fm_ac_dept                [7],
           nd_to_ac_dept                [7],
           nd_fm_or_dept                [7],
           nd_to_or_dept                [7],
           nd_fm_dr                     [7],
           nd_to_dr                     [7],
           nd_fm_date                   [11],
           nd_to_date                   [11],
           nd_fm_month                  [3],
           nd_to_month                  [3],
           nd_fm_year                   [3],
           nd_to_year                   [3],
		   nd_operating_facility_id     [3],
		   nd_fr_facility               [3],
		   nd_to_facility               [3],
		   nd_rep_option                [2],
		   nd_op_facility_id            [3],
		   nd_pre_facility_id           [3]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_pkg_serv_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_rep_flag;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_blng_serv;

struct { unsigned short len; unsigned char arr[11]; } nd_to_blng_serv;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_ac_dept;

struct { unsigned short len; unsigned char arr[7]; } nd_to_ac_dept;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_or_dept;

struct { unsigned short len; unsigned char arr[7]; } nd_to_or_dept;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_dr;

struct { unsigned short len; unsigned char arr[7]; } nd_to_dr;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_date;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_month;

struct { unsigned short len; unsigned char arr[3]; } nd_to_month;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_year;

struct { unsigned short len; unsigned char arr[3]; } nd_to_year;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_fr_facility;

struct { unsigned short len; unsigned char arr[3]; } nd_to_facility;

struct { unsigned short len; unsigned char arr[2]; } nd_rep_option;

struct { unsigned short len; unsigned char arr[3]; } nd_op_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_pre_facility_id;

  
   /* VARCHAR incsum_serv_pkg_code         [11],
           incsum_acct_dept_code        [7],
           incsum_orig_dept_code        [7],
           incsum_physician_id          [16],
           incsum_serv_date             [11],
           incsum_episode_type          [2],
           incsum_blng_class_code       [3],
           incsum_bed_class_code        [3]; */ 
struct { unsigned short len; unsigned char arr[11]; } incsum_serv_pkg_code;

struct { unsigned short len; unsigned char arr[7]; } incsum_acct_dept_code;

struct { unsigned short len; unsigned char arr[7]; } incsum_orig_dept_code;

struct { unsigned short len; unsigned char arr[16]; } incsum_physician_id;

struct { unsigned short len; unsigned char arr[11]; } incsum_serv_date;

struct { unsigned short len; unsigned char arr[2]; } incsum_episode_type;

struct { unsigned short len; unsigned char arr[3]; } incsum_blng_class_code;

struct { unsigned short len; unsigned char arr[3]; } incsum_bed_class_code;


   /* VARCHAR serv_pkg_desc                [41],
           acc_dept_desc                [41],
           org_dept_desc                [41],
           physician_name               [31]; */ 
struct { unsigned short len; unsigned char arr[41]; } serv_pkg_desc;

struct { unsigned short len; unsigned char arr[41]; } acc_dept_desc;

struct { unsigned short len; unsigned char arr[41]; } org_dept_desc;

struct { unsigned short len; unsigned char arr[31]; } physician_name;


   double  incsum_base_charge = 0,
           incsum_gross_charge = 0,
           incsum_disc_amt = 0,
           incsum_net_charge = 0;

   char    sql_stmt                     [2000];
   char    string_var                   [100];

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

char   old_serv_pkg_code         [11],
       old_acct_dept_code        [7],
       old_orig_dept_code        [7],
       old_physician_id          [16],
       old_serv_date             [11],
       old_episode_type          [2],
       old_serv_pkg_desc         [41],
       old_acc_dept_desc         [41],
       old_org_dept_desc         [41],
       old_physician_name        [31];
	   
double doctot_base_charge = 0,
       doctot_gross_charge = 0,
       doctot_disc_amt = 0,
       doctot_net_charge = 0,
       orgtot_base_charge = 0,
       orgtot_gross_charge = 0,
       orgtot_disc_amt = 0,
       orgtot_net_charge = 0,
       acctot_base_charge = 0,
       acctot_gross_charge = 0,
       acctot_disc_amt = 0,
       acctot_net_charge = 0,
       boptot_base_charge = 0,
       boptot_gross_charge = 0,
       boptot_disc_amt = 0,
       boptot_net_charge = 0,
       epitot_base_charge = 0,
       epitot_gross_charge = 0,
       epitot_disc_amt = 0,
       epitot_net_charge = 0,
       reptot_base_charge = 0,
       reptot_gross_charge = 0,
       reptot_disc_amt = 0,
       reptot_net_charge = 0;

FILE *fp;
int lctr = 0,pctr =0;
int detail_ctr = 0;      

void fetch_desc(),
     fetch_param(),
     delete_param(),
     declare_cursors(),
     open_files(),
     print_title(),
     print_head(),
     print_doc_head(),
     print_org_head(),
     print_break_footer(char *brk, 
                        double base_charge_tot, 
                        double gross_charge_tot,
                        double disc_amt_tot,
                        double net_charge_tot),
     print_detail(),
     print_all_breaks(int i),
     init_old(),
     print_end(),
     sql_connect(),
     ltrim(char *str),
     print_formated(double amount),
     list_args(int arg_cnt,char **arg_list);

int fetch_inc_sum(),
    check_break();

void proc_main(int argc,char **argv)
{
   int brkindex;

   if (argc != 5)
   {
      list_args(argc, argv);
      exit(0);
   }

   strcpy(g_pgm_id,"BLRINCAD");

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(nd_facility_id.arr,argv[4]);
   nd_facility_id.len = strlen(nd_facility_id.arr);
   strcpy(g_facility_id,nd_facility_id.arr);


   sql_connect();

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);
 
   set_meduser_role();
   
	strcpy(p_language_id.arr,l_language_id.arr);

	fetch_legend_value();
   fetch_param();
   delete_param();
   start_prog_msg();
   fetch_desc();
   open_files();
   declare_cursors();
   detail_ctr = 0;
   print_title();
   init_old();
   while(fetch_inc_sum())
   {
      brkindex = check_break();
      print_all_breaks(brkindex);
      detail_ctr ++;
      print_detail();
   }
   if (detail_ctr > 0)
   {
      print_all_breaks(6);
   }
   print_end();
   end_prog_msg();
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 0;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   return;
}

/***************** Database Access & Updation Functions ***********************/
void fetch_desc()
{
   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   user_id.arr[0]        = '\0';

   hosp_name.len      = 0;
   date_time.len      = 0;
   user_id.len        = 0;

   /* EXEC SQL SELECT ACCOUNTING_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                   USER
              INTO :hosp_name, :date_time, :user_id
              FROM SY_ACC_ENTITY
			  WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )20;
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
   sqlstm.sqhstl[2] = (unsigned int  )32;
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



   if (OERROR)
         err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   user_id.arr[user_id.len]               = '\0';

}

void fetch_param()
{
   nd_pkg_serv_flag.arr[0] = '\0';
   nd_rep_flag.arr[0]      = '\0';
   nd_fm_blng_serv.arr[0]  = '\0';
   nd_to_blng_serv.arr[0]  = '\0';
   nd_fm_ac_dept.arr[0]    = '\0';
   nd_to_ac_dept.arr[0]    = '\0';
   nd_fm_or_dept.arr[0]    = '\0';
   nd_to_or_dept.arr[0]    = '\0';
   nd_fm_dr.arr[0]         = '\0';
   nd_to_dr.arr[0]         = '\0';
   nd_fm_date.arr[0]       = '\0';
   nd_to_date.arr[0]       = '\0';
   nd_fm_month.arr[0]      = '\0';
   nd_to_month.arr[0]      = '\0';
   nd_fm_year.arr[0]       = '\0';
   nd_to_year.arr[0]       = '\0';

   nd_pkg_serv_flag.len    = 0;
   nd_rep_flag.len         = 0;
   nd_fm_blng_serv.len     = 0;
   nd_to_blng_serv.len     = 0;
   nd_fm_ac_dept.len       = 0;
   nd_to_ac_dept.len       = 0;
   nd_fm_or_dept.len       = 0;
   nd_to_or_dept.len       = 0;
   nd_fm_dr.len            = 0;
   nd_to_dr.len            = 0;
   nd_fm_date.len          = 0;
   nd_to_date.len          = 0;
   nd_fm_month.len         = 0;
   nd_to_month.len         = 0;
   nd_fm_year.len          = 0;
   nd_to_year.len          = 0;

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,PARAM2,PARAM3, PARAM4, PARAM5,
                   PARAM6,PARAM7,PARAM8, PARAM9, PARAM10, 
                   PARAM11,PARAM12,PARAM13, PARAM14, PARAM15, PARAM16,
				   PARAM17, PARAM18, PARAM19
              INTO :nd_operating_facility_id,
				   :nd_pkg_serv_flag,
                   :nd_rep_flag,
                   :nd_fm_blng_serv,
                   :nd_to_blng_serv,
                   :nd_fm_ac_dept,
                   :nd_to_ac_dept,
                   :nd_fm_or_dept,
                   :nd_to_or_dept,
                   :nd_fm_dr,
                   :nd_to_dr,
                   :nd_fm_date,
                   :nd_to_date,
                   :nd_fm_month,
                   :nd_to_month,
                   :nd_fm_year,
                   :nd_to_year,
				   :nd_fr_facility,
				   :nd_to_facility,
				   :nd_rep_option
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'BLRINCAD'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13\
 ,PARAM14 ,PARAM15 ,PARAM16 ,PARAM17 ,PARAM18 ,PARAM19 into :b0,:b1,:b2,:b3,:b\
4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19  from \
SY_PROG_PARAM where ((PGM_ID='BLRINCAD' and SESSION_ID=:b20) and PGM_DATE=:b21\
)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_pkg_serv_flag;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_rep_flag;
   sqlstm.sqhstl[2] = (unsigned int  )4;
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
   sqlstm.sqhstv[5] = (         void  *)&nd_fm_ac_dept;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_ac_dept;
   sqlstm.sqhstl[6] = (unsigned int  )9;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fm_or_dept;
   sqlstm.sqhstl[7] = (unsigned int  )9;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_or_dept;
   sqlstm.sqhstl[8] = (unsigned int  )9;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_fm_dr;
   sqlstm.sqhstl[9] = (unsigned int  )9;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_to_dr;
   sqlstm.sqhstl[10] = (unsigned int  )9;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[11] = (unsigned int  )13;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[12] = (unsigned int  )13;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_fm_month;
   sqlstm.sqhstl[13] = (unsigned int  )5;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_to_month;
   sqlstm.sqhstl[14] = (unsigned int  )5;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_fm_year;
   sqlstm.sqhstl[15] = (unsigned int  )5;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_to_year;
   sqlstm.sqhstl[16] = (unsigned int  )5;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_fr_facility;
   sqlstm.sqhstl[17] = (unsigned int  )5;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_to_facility;
   sqlstm.sqhstl[18] = (unsigned int  )5;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_rep_option;
   sqlstm.sqhstl[19] = (unsigned int  )4;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[20] = (unsigned int  )18;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[21] = (unsigned int  )37;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_pkg_serv_flag.arr[nd_pkg_serv_flag.len] = '\0';
   nd_rep_flag.arr[nd_rep_flag.len]           = '\0';
   nd_fm_blng_serv.arr[nd_fm_blng_serv.len]   = '\0';
   nd_to_blng_serv.arr[nd_to_blng_serv.len]   = '\0';
   nd_fm_ac_dept.arr[nd_fm_ac_dept.len]       = '\0';
   nd_to_ac_dept.arr[nd_to_ac_dept.len]       = '\0';
   nd_fm_or_dept.arr[nd_fm_or_dept.len]       = '\0';
   nd_to_or_dept.arr[nd_to_or_dept.len]       = '\0';
   nd_fm_dr.arr[nd_fm_dr.len]                 = '\0';
   nd_to_dr.arr[nd_to_dr.len]                 = '\0';
   nd_fm_date.arr[nd_fm_date.len]             = '\0';
   nd_to_date.arr[nd_to_date.len]             = '\0';
   nd_fm_month.arr[nd_fm_month.len]           = '\0';
   nd_to_month.arr[nd_to_month.len]           = '\0';
   nd_fm_year.arr[nd_fm_year.len]             = '\0';
   nd_to_year.arr[nd_to_year.len]             = '\0';

   strcpy(g_facility_id, nd_operating_facility_id.arr);

}

void delete_param()
{
    /* EXEC SQL DELETE FROM SY_PROG_PARAM
                   WHERE PGM_ID     = 'BLRINCAD'
                     AND SESSION_ID = :nd_session_id
                     AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRINCAD' and\
 SESSION_ID=:b0) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )154;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
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
    sqlstm.sqhstl[1] = (unsigned int  )37;
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

void declare_cursors()
{
   if (nd_pkg_serv_flag.arr[0]=='S') 
   {
      strcpy(sql_stmt,"SELECT BLNG_SERV_CODE, ACCT_DEPT_CODE, ORIG_DEPT_CODE, \
      PHYSICIAN_ID, TRUNC(SERV_DATE), EPISODE_TYPE, \
      BLNG_CLASS_CODE, BED_CLASS_CODE, BASE_CHARGE, GROSS_CHARGE, DISC_AMT, \
      GROSS_CHARGE - DISC_AMT, \
      OPERATING_FACILITY_ID   \
      FROM BL_SRV_INC_SUM_DTL \
      WHERE TRUNC(SERV_DATE) \
      BETWEEN TO_DATE(NVL(:nd_fm_date,'01/01/1800'), 'DD/MM/YYYY') \
      AND TO_DATE(NVL(:nd_to_date,'01/01/4712'),'DD/MM/YYYY') \
      AND BLNG_SERV_CODE BETWEEN NVL(:nd_fm_blng_serv, '      ') \
          AND NVL(:nd_to_blng_serv,'~~~~~~') \
      AND ACCT_DEPT_CODE BETWEEN NVL(:nd_fm_ac_dept,  '      ') \
           AND NVL(:nd_to_ac_dept,'~~~~~~') \
      AND ORIG_DEPT_CODE BETWEEN NVL(:nd_fm_or_dept, '      ') \
          AND NVL(:nd_to_or_dept,'~~~~~~') \
      AND PHYSICIAN_ID BETWEEN NVL(:nd_fm_dr, '      ') \
          AND NVL(:nd_to_dr,'~~~~~~') \
      AND OPERATING_FACILITY_ID BETWEEN :nd_fr_facility and :nd_to_facility \
      ORDER BY EPISODE_TYPE, BLNG_SERV_CODE, ACCT_DEPT_CODE, ORIG_DEPT_CODE, \
               PHYSICIAN_ID, TRUNC(SERV_DATE) ");
   }
   else 
   {
      strcpy(sql_stmt,"SELECT PACKAGE_CODE, NULL, ORIG_DEPT_CODE, \
      PHYSICIAN_ID, TRUNC(SERV_DATE), EPISODE_TYPE, \
      BLNG_CLASS_CODE, BED_CLASS_CODE, BASE_CHARGE, GROSS_CHARGE, DISC_AMT, \
      GROSS_CHARGE - DISC_AMT,  \
	  OPERATING_FACILITY_ID   \
      FROM BL_PKG_INC_SUM_DTL \
      WHERE TRUNC(SERV_DATE) \
      BETWEEN TO_DATE(NVL(:nd_fm_date,'01/01/1800'), 'DD/MM/YYYY') \
      AND TO_DATE(NVL(:nd_to_date,'01/01/4712'),'DD/MM/YYYY') \
      AND PACKAGE_CODE BETWEEN NVL(:nd_fm_blng_serv, '      ') \
          AND NVL(:nd_to_blng_serv,'~~~~~~') \
      AND ORIG_DEPT_CODE BETWEEN NVL(:nd_fm_or_dept, '      ') \
          AND NVL(:nd_to_or_dept,'~~~~~~') \
      AND PHYSICIAN_ID BETWEEN NVL(:nd_fm_dr, '      ') \
          AND NVL(:nd_to_dr,'~~~~~~') \
      AND OPERATING_FACILITY_ID BETWEEN :nd_fr_facility AND :nd_to_facility \
      ORDER BY EPISODE_TYPE, PACKAGE_CODE, ORIG_DEPT_CODE, PHYSICIAN_ID, \
               TRUNC(SERV_DATE) ");
   }

   /* EXEC SQL PREPARE S FROM :sql_stmt; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )177;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)sql_stmt;
   sqlstm.sqhstl[0] = (unsigned int  )2000;
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
      err_mesg("PREPARE failed on statment S",0,"");

   /* EXEC SQL DECLARE INC_SUM_DTL_CUR CURSOR FOR S; */ 


   if (OERROR)
      err_mesg("DECLARE failed on CURSOR INC_SUM_DTL_CUR",0,"");

   if (nd_pkg_serv_flag.arr[0]=='S') 
   {
       /* EXEC SQL OPEN INC_SUM_DTL_CUR USING :nd_fm_date,      :nd_to_date,
                                           :nd_fm_blng_serv, :nd_to_blng_serv,
                                           :nd_fm_ac_dept,   :nd_to_ac_dept,
                                           :nd_fm_or_dept,   :nd_to_or_dept,
                                           :nd_fm_dr,        :nd_to_dr,
										   :nd_fr_facility,  :nd_to_facility; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 22;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )196;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_fm_date;
       sqlstm.sqhstl[0] = (unsigned int  )13;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
       sqlstm.sqhstl[1] = (unsigned int  )13;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_fm_blng_serv;
       sqlstm.sqhstl[2] = (unsigned int  )13;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_serv;
       sqlstm.sqhstl[3] = (unsigned int  )13;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_fm_ac_dept;
       sqlstm.sqhstl[4] = (unsigned int  )9;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_to_ac_dept;
       sqlstm.sqhstl[5] = (unsigned int  )9;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&nd_fm_or_dept;
       sqlstm.sqhstl[6] = (unsigned int  )9;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&nd_to_or_dept;
       sqlstm.sqhstl[7] = (unsigned int  )9;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&nd_fm_dr;
       sqlstm.sqhstl[8] = (unsigned int  )9;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&nd_to_dr;
       sqlstm.sqhstl[9] = (unsigned int  )9;
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


   }
   else
   {
       /* EXEC SQL OPEN INC_SUM_DTL_CUR USING :nd_fm_date,      :nd_to_date,
                                           :nd_fm_blng_serv, :nd_to_blng_serv,
                                           :nd_fm_or_dept,   :nd_to_or_dept,
                                           :nd_fm_dr,        :nd_to_dr,
										   :nd_fr_facility,  :nd_to_facility; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 22;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )259;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_fm_date;
       sqlstm.sqhstl[0] = (unsigned int  )13;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
       sqlstm.sqhstl[1] = (unsigned int  )13;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_fm_blng_serv;
       sqlstm.sqhstl[2] = (unsigned int  )13;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_serv;
       sqlstm.sqhstl[3] = (unsigned int  )13;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_fm_or_dept;
       sqlstm.sqhstl[4] = (unsigned int  )9;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_to_or_dept;
       sqlstm.sqhstl[5] = (unsigned int  )9;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&nd_fm_dr;
       sqlstm.sqhstl[6] = (unsigned int  )9;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&nd_to_dr;
       sqlstm.sqhstl[7] = (unsigned int  )9;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&nd_fr_facility;
       sqlstm.sqhstl[8] = (unsigned int  )5;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&nd_to_facility;
       sqlstm.sqhstl[9] = (unsigned int  )5;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
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


   }

   if (OERROR)
      err_mesg("OPEN failed on cursor INC_SUM_DTL_CUR",0,"");

   /* EXEC SQL DECLARE BL_BLNG_SERV_CUR CURSOR FOR 
   SELECT LONG_DESC
   FROM   BL_BLNG_SERV
   WHERE  BLNG_SERV_CODE = :incsum_serv_pkg_code; */ 


   /* EXEC SQL DECLARE BL_PACKAGE_HDR_CUR CURSOR FOR 
   SELECT LONG_DESC
   FROM   BL_PACKAGE_HDR
   WHERE  PACKAGE_CODE = :incsum_serv_pkg_code; */ 


   /* EXEC SQL DECLARE SY_AC_DEPT_CUR CURSOR FOR
   SELECT LONG_DESC
   FROM   SY_DEPT
   WHERE  DEPT_CODE = :incsum_acct_dept_code
   AND    OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 


   /* EXEC SQL DECLARE SY_ORG_DEPT_CUR CURSOR FOR
   SELECT LONG_DESC
   FROM   SY_DEPT
   WHERE  DEPT_CODE = :incsum_orig_dept_code
   AND    OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 


   /* EXEC SQL DECLARE SY_PHYSICIAN_MAST_CUR CURSOR FOR
   SELECT FULL_NAME
   FROM   SY_PHYSICIAN_MAST
   WHERE  PHYSICIAN_ID = :incsum_physician_id; */ 


}

int fetch_inc_sum()
{
      incsum_serv_pkg_code.arr[0]   = '\0';
      incsum_acct_dept_code.arr[0]  = '\0';
      incsum_orig_dept_code.arr[0]  = '\0';
      incsum_physician_id.arr[0]    = '\0';
      incsum_serv_date.arr[0]       = '\0';
      incsum_episode_type.arr[0]    = '\0';
      incsum_blng_class_code.arr[0] = '\0';
      incsum_bed_class_code.arr[0]  = '\0';

      incsum_serv_pkg_code.len      = 0;
      incsum_acct_dept_code.len     = 0;
      incsum_orig_dept_code.len     = 0;
      incsum_physician_id.len       = 0;
      incsum_serv_date.len          = 0;
      incsum_episode_type.len       = 0;
      incsum_blng_class_code.len    = 0;
      incsum_bed_class_code.len     = 0;

      incsum_base_charge  = (double) 0;
      incsum_gross_charge = (double) 0;
      incsum_disc_amt     = (double) 0;
      incsum_net_charge   = (double) 0;

      /* EXEC SQL FETCH INC_SUM_DTL_CUR
               INTO  :incsum_serv_pkg_code,
                     :incsum_acct_dept_code,
                     :incsum_orig_dept_code,
                     :incsum_physician_id,
                     :incsum_serv_date,
                     :incsum_episode_type,
                     :incsum_blng_class_code,
                     :incsum_bed_class_code,
                     :incsum_base_charge,
                     :incsum_gross_charge,
                     :incsum_disc_amt,
                     :incsum_net_charge,
					 :nd_op_facility_id; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 22;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )314;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&incsum_serv_pkg_code;
      sqlstm.sqhstl[0] = (unsigned int  )13;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&incsum_acct_dept_code;
      sqlstm.sqhstl[1] = (unsigned int  )9;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&incsum_orig_dept_code;
      sqlstm.sqhstl[2] = (unsigned int  )9;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&incsum_physician_id;
      sqlstm.sqhstl[3] = (unsigned int  )18;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&incsum_serv_date;
      sqlstm.sqhstl[4] = (unsigned int  )13;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&incsum_episode_type;
      sqlstm.sqhstl[5] = (unsigned int  )4;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&incsum_blng_class_code;
      sqlstm.sqhstl[6] = (unsigned int  )5;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&incsum_bed_class_code;
      sqlstm.sqhstl[7] = (unsigned int  )5;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&incsum_base_charge;
      sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&incsum_gross_charge;
      sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&incsum_disc_amt;
      sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&incsum_net_charge;
      sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&nd_op_facility_id;
      sqlstm.sqhstl[12] = (unsigned int  )5;
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
            err_mesg("FETCH failed on cursor INC_SUM_DTL_CUR",0,"");

      if (LAST_ROW)
          return(0);

      incsum_serv_pkg_code.arr[incsum_serv_pkg_code.len]     = '\0';
      incsum_acct_dept_code.arr[incsum_acct_dept_code.len]   = '\0';
      incsum_orig_dept_code.arr[incsum_orig_dept_code.len]   = '\0';
      incsum_physician_id.arr[incsum_physician_id.len]       = '\0';
      incsum_serv_date.arr[incsum_serv_date.len]             = '\0';
      incsum_episode_type.arr[incsum_episode_type.len]       = '\0';
      incsum_blng_class_code.arr[incsum_blng_class_code.len] = '\0';
      incsum_bed_class_code.arr[incsum_bed_class_code.len]   = '\0';

      return(1);
}

/*********************** File Handling & Printing Functions *******************/
void open_files()
{
  // char *file_name = "blrincad.lis", err_stmt[70];
	strcpy(filename,WORKING_DIR);
    strcat(filename,"blrincad.lis");

   if ((fp = fopen(filename,"w")) == NULL)
   {
     // sprintf(err_stmt,"Error while opening File %s",file_name);
     // err_mesg(err_stmt,0,"");
	  sprintf(string_var,"Error while opening File %s",filename);
      disp_message(ERR_MESG,string_var);
        exit(0);
   }

}

void print_title()
{
  fprintf(fp, "\n\nMDL : %2s %43s %-30s %30s  %-15s\n",loc_legend[150],
      " ", hosp_name.arr," ", date_time.arr);
  fprintf(fp, "OPR : %-25s                 %24s %14s\n",
     user_id.arr,loc_legend[50],
     ((nd_pkg_serv_flag.arr[0]=='S')?loc_legend[80]:loc_legend[90]));
  fprintf(fp, "REP : %-8s %45s  %-28s %29s %4s : %4d\n",loc_legend[40], " ", 
    loc_legend[100], "",loc_legend[30], ++pctr);
  fprintf(fp, "%s%s%s\n",
            "--------------------------------------------------------",
            "--------------------------------------------------------",
            "--------------------");
  fprintf(fp,"VER : 1.10.01\n");
  fflush(fp);

  fprintf(fp,"\n\n\n\n        INPUT PARAMETERS \n        ----------------\n\n");
  fprintf(fp," %14s %20s : %s\n\n"," ",loc_legend[110], nd_pkg_serv_flag.arr);

  if (nd_pkg_serv_flag.arr[0]=='S')
  {
   fprintf(fp," %14s %15s %4s : %-10s\n"," ",loc_legend[120],loc_legend[60], nd_fm_blng_serv.arr); 
   fprintf(fp," %14s                 %2s   : %-10s\n\n"," ",loc_legend[70],nd_to_blng_serv.arr);
   fprintf(fp," %14s %15s %4s : %-10s\n"," ",loc_legend[120],loc_legend[60], nd_fm_ac_dept.arr); 
   fprintf(fp," %14s                 %2s   : %-10s\n\n"," ",loc_legend[70],nd_to_ac_dept.arr);
  }
  else
  {
   fprintf(fp," %14s %12s    %4s : %-10s\n"," ",loc_legend[140],loc_legend[60], nd_fm_blng_serv.arr); 
   fprintf(fp," %14s                 %2s   : %-10s\n\n"," ",loc_legend[70],nd_to_blng_serv.arr);
  }

  fprintf(fp," %14s %15s %4s : %-10s\n"," ",loc_legend[160],loc_legend[60], nd_fm_or_dept.arr); 
  fprintf(fp," %14s                 %2s   : %-10s\n\n"," ",loc_legend[70],nd_to_or_dept.arr);
  fprintf(fp," %14s %6s          %4s : %-10s\n"," ",loc_legend[170],loc_legend[60], nd_fm_dr.arr); 
  fprintf(fp," %14s                 %2s   : %-10s\n\n"," ",loc_legend[70],nd_to_dr.arr);
  fprintf(fp," %14s %8s        %4s : %-3s\n"," ",loc_legend[180],loc_legend[60], nd_fr_facility.arr); 
  fprintf(fp," %14s                 %2s   : %-3s\n\n"," ",loc_legend[70],nd_to_facility.arr);
  fprintf(fp," %14s %12s    %4s : %-10s\n"," ",loc_legend[190],loc_legend[60], nd_fm_date.arr); 
  fprintf(fp," %14s                 %2s   : %-10s\n\n"," ",loc_legend[70],nd_to_date.arr);

  fflush(fp);
}

void print_head()
{
  fprintf(fp, "\f\n\nMDL : %2s %43s %-30s %30s  %-18s\n",loc_legend[150],
      " ", hosp_name.arr," ", date_time.arr);
  fprintf(fp, "OPR : %-25s                 %24s %14s\n",
     user_id.arr,loc_legend[50],
     ((nd_pkg_serv_flag.arr[0]=='S')?loc_legend[80]:loc_legend[90]));
  fprintf(fp, "REP : %-8s %45s  %-28s %29s %4s : %4d\n\n",loc_legend[40], " ",
    loc_legend[100]," ",loc_legend[30], ++pctr);

   switch (old_episode_type[0]) {
   case 'I' :
     fprintf(fp, "%12s : %13s\n\n",loc_legend[200],loc_legend[210]); break;
   case 'D' :
     fprintf(fp, "%12s : %10s\n\n",loc_legend[200],loc_legend[220]); break;
   case 'O' :
     fprintf(fp, "%12s : %14s\n\n",loc_legend[200],loc_legend[230]); break;
   case 'E' :
     fprintf(fp, "%12s : %12s\n\n",loc_legend[200],loc_legend[240]); break;
   case 'R' :
     fprintf(fp, "%12s : %20s\n\n",loc_legend[200],loc_legend[250]); break;
  }
  fprintf(fp, "%s%s%s\n",
            "--------------------------------------------------------",
            "--------------------------------------------------------",
            "--------------------");
  fprintf(fp, " %47s %4s          %11s       %12s"," ",loc_legend[260],loc_legend[270],loc_legend[280]);
  fprintf(fp, "           %8s         %10s\n",loc_legend[290],loc_legend[300]);

  fprintf(fp, "%s%s%s\n",
            "--------------------------------------------------------",
            "--------------------------------------------------------",
            "--------------------");

  if (strcmp(nd_rep_option.arr, "B") == 0)
  {
    if (!nd_pre_facility_id.arr)
	   strcpy(nd_pre_facility_id.arr,nd_op_facility_id.arr);

    if (strcmp(nd_pre_facility_id.arr,nd_op_facility_id.arr)!=0) 
      {
        strcpy(nd_pre_facility_id.arr,nd_op_facility_id.arr);
        fprintf(fp," %11s :  %2s\n",loc_legend[390] ,nd_op_facility_id.arr);          
        lctr++;
      }
   }

  fprintf(fp, "%s : %-6.6s %-40.40s",
      (nd_pkg_serv_flag.arr[0]=='S')?loc_legend[80]:loc_legend[90],
      old_serv_pkg_code, old_serv_pkg_desc);
  if (nd_pkg_serv_flag.arr[0]=='S')
      fprintf(fp, "     %8s : %-6.6s  %40.40s\n",loc_legend[330], old_acct_dept_code,
                                                       old_acc_dept_desc);

  else fprintf(fp, "\n");
  fflush(fp);
  lctr = 13;
}

void print_end()
{
  if (lctr > MAXLINES - 6) print_head();

  if (pctr==1)
  {
      fprintf(fp, "\f\n\nMDL : %2s %43s %-30s %30s  %-18s\n",loc_legend[150],
          " ", hosp_name.arr," ", date_time.arr);
      fprintf(fp, "OPR : %-25s                 %s %s\n",
         user_id.arr,loc_legend[50],
         ((nd_pkg_serv_flag.arr[0]=='S')?loc_legend[80]:loc_legend[90]));
      fprintf(fp, "REP : %-8s %45s  %-28s %29s %4s : %4d\n\n", g_pgm_id, " ",
        loc_legend[100]," ",loc_legend[30], ++pctr);
      fprintf(fp, "%s%s%s\n",
            "--------------------------------------------------------",
            "--------------------------------------------------------",
            "--------------------");
      fprintf(fp, " %47s %4s          %11s       %12s"," ",loc_legend[260],loc_legend[270],loc_legend[280]);
      fprintf(fp, "           %8s         %10s\n",loc_legend[290],loc_legend[300]);

      fprintf(fp, "%s%s%s\n",
            "--------------------------------------------------------",
            "--------------------------------------------------------",
            "--------------------");
  }

  fprintf(fp, "\n\n\n %52s **   END  OF  REPORT   ** \n\n", " ");
  fflush(fp);
  fclose(fp);
}

void init_old()
{
    old_serv_pkg_code[0]  = '\0';
    old_acct_dept_code[0] = '\0';
    old_orig_dept_code[0] = '\0';
    old_physician_id[0]   = '\0';
    old_serv_date[0]      = '\0';
    old_episode_type[0]   = '\0';
    old_serv_pkg_desc[0]  = '\0';
    old_acc_dept_desc[0]  = '\0';
    old_org_dept_desc[0]  = '\0';
    old_physician_name[0] = '\0';
}

void print_all_breaks(int i)
{

  if (detail_ctr)
  {
    if (i > 0)
    {
         print_break_footer("loc_legend[340]        ", doctot_base_charge, 
           doctot_gross_charge, doctot_disc_amt, doctot_net_charge);
         doctot_base_charge  = (double) 0; doctot_gross_charge = (double) 0;
         doctot_disc_amt     = (double) 0; doctot_net_charge   = (double) 0;
    }
    if (i > 1)
    {
         print_break_footer("loc_legend[350]       ", orgtot_base_charge,
            orgtot_gross_charge, orgtot_disc_amt, orgtot_net_charge);
         orgtot_base_charge  = (double) 0; orgtot_gross_charge = (double) 0;
         orgtot_disc_amt     = (double) 0; orgtot_net_charge   = (double) 0;
    }
    if (i > 2)
    {
         if (nd_pkg_serv_flag.arr[0]=='S')
            print_break_footer("loc_legend[330]        ", acctot_base_charge,
               acctot_gross_charge, acctot_disc_amt, acctot_net_charge);
         acctot_base_charge  = (double) 0; acctot_gross_charge = (double) 0;
         acctot_disc_amt     = (double) 0; acctot_net_charge   = (double) 0;
    }
    if (i > 3)
    {
         print_break_footer((nd_pkg_serv_flag.arr[0]=='S')?
            loc_legend[80]:loc_legend[90], boptot_base_charge,
            boptot_gross_charge, boptot_disc_amt, boptot_net_charge);
         boptot_base_charge  = (double) 0; boptot_gross_charge = (double) 0;
         boptot_disc_amt     = (double) 0; boptot_net_charge   = (double) 0;
    }
    if (i > 4)
    {
         print_break_footer("loc_legend[200]    ", epitot_base_charge,
            epitot_gross_charge, epitot_disc_amt, epitot_net_charge);
         epitot_base_charge  = (double) 0; epitot_gross_charge = (double) 0;
         epitot_disc_amt     = (double) 0; epitot_net_charge   = (double) 0;
    }
    if (i > 5)
    {
         print_break_footer("loc_legend[360]           ", reptot_base_charge,
            reptot_gross_charge, reptot_disc_amt, reptot_net_charge);
    }
  }

  doctot_base_charge   += incsum_base_charge;
  doctot_gross_charge  += incsum_gross_charge;
  doctot_disc_amt      += incsum_disc_amt;
  doctot_net_charge    += incsum_net_charge;
  orgtot_base_charge   += incsum_base_charge;
  orgtot_gross_charge  += incsum_gross_charge;
  orgtot_disc_amt      += incsum_disc_amt;
  orgtot_net_charge    += incsum_net_charge;
  acctot_base_charge   += incsum_base_charge;
  acctot_gross_charge  += incsum_gross_charge;
  acctot_disc_amt      += incsum_disc_amt;
  acctot_net_charge    += incsum_net_charge;
  boptot_base_charge   += incsum_base_charge;
  boptot_gross_charge  += incsum_gross_charge;
  boptot_disc_amt      += incsum_disc_amt;
  boptot_net_charge    += incsum_net_charge;
  epitot_base_charge   += incsum_base_charge;
  epitot_gross_charge  += incsum_gross_charge;
  epitot_disc_amt      += incsum_disc_amt;
  epitot_net_charge    += incsum_net_charge;
  reptot_base_charge   += incsum_base_charge;
  reptot_gross_charge  += incsum_gross_charge;
  reptot_disc_amt      += incsum_disc_amt;
  reptot_net_charge    += incsum_net_charge;


   /******************  Get the Descriptions if codes are changed ************/

    if (i > 0)
    {
        if(strcmp(old_physician_id, incsum_physician_id.arr)!=0)
        {
             physician_name.arr[0] = '\0'; physician_name.len = 0; 
             /* EXEC SQL OPEN SY_PHYSICIAN_MAST_CUR; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 22;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.stmt = sq0010;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )381;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqcmod = (unsigned int )0;
             sqlstm.sqhstv[0] = (         void  *)&incsum_physician_id;
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


             /* EXEC SQL FETCH SY_PHYSICIAN_MAST_CUR INTO :physician_name; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 22;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )400;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&physician_name;
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


             physician_name.arr[physician_name.len] = '\0'; 
             strcpy(old_physician_id, incsum_physician_id.arr); 
             strcpy(old_physician_name, physician_name.arr); 
        }
    }
    if (i > 1)
    {
        if(strcmp(old_orig_dept_code, incsum_orig_dept_code.arr)!=0)
        {
             org_dept_desc.arr[0] = '\0'; org_dept_desc.len = 0; 
             /* EXEC SQL OPEN SY_ORG_DEPT_CUR; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 22;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.stmt = sq0009;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )419;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqcmod = (unsigned int )0;
             sqlstm.sqhstv[0] = (         void  *)&incsum_orig_dept_code;
             sqlstm.sqhstl[0] = (unsigned int  )9;
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


             /* EXEC SQL FETCH SY_ORG_DEPT_CUR INTO :org_dept_desc; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 22;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )442;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&org_dept_desc;
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


             org_dept_desc.arr[org_dept_desc.len] = '\0'; 
             strcpy(old_orig_dept_code, incsum_orig_dept_code.arr); 
             strcpy(old_org_dept_desc, org_dept_desc.arr); 
        }
    }
    if (i > 2)
    {
        if(strcmp(old_acct_dept_code, incsum_acct_dept_code.arr)!=0)
        {
             acc_dept_desc.arr[0] = '\0'; acc_dept_desc.len = 0; 
             /* EXEC SQL OPEN SY_AC_DEPT_CUR; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 22;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.stmt = sq0008;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )461;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqcmod = (unsigned int )0;
             sqlstm.sqhstv[0] = (         void  *)&incsum_acct_dept_code;
             sqlstm.sqhstl[0] = (unsigned int  )9;
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


             /* EXEC SQL FETCH SY_AC_DEPT_CUR INTO :acc_dept_desc; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 22;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )484;
             sqlstm.selerr = (unsigned short)1;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlstm.sqfoff = (           int )0;
             sqlstm.sqfmod = (unsigned int )2;
             sqlstm.sqhstv[0] = (         void  *)&acc_dept_desc;
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


             acc_dept_desc.arr[acc_dept_desc.len] = '\0'; 
             strcpy(old_acct_dept_code, incsum_acct_dept_code.arr);
             strcpy(old_acc_dept_desc, acc_dept_desc.arr); 
        }
    }
    if (i > 3)        
    {
        if(strcmp(old_serv_pkg_code, incsum_serv_pkg_code.arr)!=0)
        {
             serv_pkg_desc.arr[0] = '\0'; serv_pkg_desc.len = 0; 
             if (nd_pkg_serv_flag.arr[0]=='S')
             {
                /* EXEC SQL OPEN BL_BLNG_SERV_CUR; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 12;
                sqlstm.arrsiz = 22;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.stmt = sq0006;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )503;
                sqlstm.selerr = (unsigned short)1;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)4352;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqcmod = (unsigned int )0;
                sqlstm.sqhstv[0] = (         void  *)&incsum_serv_pkg_code;
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


                /* EXEC SQL FETCH BL_BLNG_SERV_CUR INTO :serv_pkg_desc; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 12;
                sqlstm.arrsiz = 22;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )522;
                sqlstm.selerr = (unsigned short)1;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)4352;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqfoff = (           int )0;
                sqlstm.sqfmod = (unsigned int )2;
                sqlstm.sqhstv[0] = (         void  *)&serv_pkg_desc;
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


             }
             else
             {
                /* EXEC SQL OPEN BL_PACKAGE_HDR_CUR; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 12;
                sqlstm.arrsiz = 22;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.stmt = sq0007;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )541;
                sqlstm.selerr = (unsigned short)1;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)4352;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqcmod = (unsigned int )0;
                sqlstm.sqhstv[0] = (         void  *)&incsum_serv_pkg_code;
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


                /* EXEC SQL FETCH BL_PACKAGE_HDR_CUR INTO :serv_pkg_desc; */ 

{
                struct sqlexd sqlstm;
                sqlstm.sqlvsn = 12;
                sqlstm.arrsiz = 22;
                sqlstm.sqladtp = &sqladt;
                sqlstm.sqltdsp = &sqltds;
                sqlstm.iters = (unsigned int  )1;
                sqlstm.offset = (unsigned int  )560;
                sqlstm.selerr = (unsigned short)1;
                sqlstm.cud = sqlcud0;
                sqlstm.sqlest = (unsigned char  *)&sqlca;
                sqlstm.sqlety = (unsigned short)4352;
                sqlstm.occurs = (unsigned int  )0;
                sqlstm.sqfoff = (           int )0;
                sqlstm.sqfmod = (unsigned int )2;
                sqlstm.sqhstv[0] = (         void  *)&serv_pkg_desc;
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


             }
             serv_pkg_desc.arr[serv_pkg_desc.len] = '\0'; 
             strcpy(old_serv_pkg_code, incsum_serv_pkg_code.arr);
             strcpy(old_serv_pkg_desc, serv_pkg_desc.arr); 
        }
    }
    if ((i == 5) && (strcmp(old_episode_type, incsum_episode_type.arr)!=0))
           strcpy(old_episode_type, incsum_episode_type.arr);
  if (i==6) return;
  if (i > 2) print_head();
  if (i > 1) print_org_head();
  if (i > 0) print_doc_head();
}

int check_break()
{
   if(strcmp(old_episode_type, incsum_episode_type.arr)!=0)
          return 5;
   else if(strcmp(old_serv_pkg_code, incsum_serv_pkg_code.arr)!=0)
          return 4;
   else if(strcmp(old_acct_dept_code, incsum_acct_dept_code.arr)!=0)
          return 3;
   else if(strcmp(old_orig_dept_code, incsum_orig_dept_code.arr)!=0)
          return 2;
   else if(strcmp(old_physician_id, incsum_physician_id.arr)!=0)
          return 1;
   return 0;
}

void print_doc_head()
{
   if (lctr > MAXLINES - 1) print_head();
   
   fprintf(fp,"        %6s           : %-6.6s  %-30.30s\n",loc_legend[340], 
        old_physician_id, old_physician_name); 
   lctr++;
}

void print_org_head()
{
   if (lctr > MAXLINES - 1) print_head();
   
   fprintf(fp,"        %16s : %-6.6s  %-40.40s\n",loc_legend[370],
        old_orig_dept_code, old_org_dept_desc); 
   lctr++;
}

void print_detail()
{
   if (lctr > MAXLINES - 1) print_head();

   fprintf(fp,"%47s  %-10.10s ", "", incsum_serv_date.arr);
      print_formated(incsum_base_charge);  fprintf(fp, "    ");
      print_formated(incsum_gross_charge); fprintf(fp, "    ");
      print_formated(incsum_disc_amt);     fprintf(fp, "    ");
      print_formated(incsum_net_charge);   fprintf(fp, "\n");

   fflush(fp);
   lctr ++;
}

void print_break_footer(char *brk,
                        double base_charge_tot,
                        double gross_charge_tot,
                        double disc_amt_tot,
                        double net_charge_tot)
{
     if (lctr > MAXLINES - 5) print_head();
     fprintf(fp, "%58s%s%s\n", "",
            "------------------------------------------------------",
            "--------------------");
     fprintf(fp, " %30s %-15.15s %5s       ", "", brk,loc_legend[380]);
     print_formated(base_charge_tot);  fprintf(fp,"    ");
     print_formated(gross_charge_tot); fprintf(fp,"    ");
     print_formated(disc_amt_tot);     fprintf(fp,"    ");
     print_formated(net_charge_tot);   fprintf(fp,"\n");
     fprintf(fp, "%58s%s%s\n\n", "",
            "------------------------------------------------------",
            "--------------------");

     lctr += 4;
}

/************************** General Purpose Functions *************************/
void sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )579;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )134;
  sqlstm.sqhsts[0] = (         int  )134;
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



  if (sqlca.sqlcode < 0)
  {
      disp_message(ORA_MESG,"Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
      exit(0);
  }
}

void print_formated(double loc_amount)
{
   char out_str[30],out_str1[30];

   if (loc_amount == 0)
      fprintf(fp,"%14s ","0.00");
   else if (loc_amount > 0)
   {
      sprintf(out_str,"%11.2f",loc_amount);
      ltrim(out_str);format_amt(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%11.2f",-loc_amount);
      ltrim(out_str);format_amt(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s-",out_str1);
   }
}

void ltrim(char *l_str)
{
   char *ptr;
   ptr = l_str;
   while (*ptr== ' ') ptr++;
   for(;*ptr!='\0';ptr++,l_str++)
    *l_str = *ptr;
   *l_str = '\0';
}

/* This function is now included in err_mesg 
void put_comma(str)
char *str;
{
  int i,l,m,a,b,c;
  float j,k;
  char arr[120],o_arr[120],l_str1[10];
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
   sprintf(str,"%s.%s",o_arr,l_str1);
}
*/

void list_args(int arg_cnt, char **arg_list)
{
   int i;

   disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRINCAD.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRINCAD.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )610;
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
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )633;
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