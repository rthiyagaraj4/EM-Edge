
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
    "T:\\temp\\Bl\\ganapathy\\JDWORK\\PROC\\Blrservi.pc"
};


static unsigned long sqlctx = 1267617725;


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
            void  *sqhstv[30];
   unsigned int   sqhstl[30];
            int   sqhsts[30];
            void  *sqindv[30];
            int   sqinds[30];
   unsigned int   sqharm[30];
   unsigned int   *sqharc[30];
   unsigned short  sqadto[30];
   unsigned short  sqtdso[30];
} sqlstm = {10,30};

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

 static const char *sq0005 = 
"select a.BLNG_SERV_CODE ,LONG_DESC ,SHORT_DESC ,SERV_GRP_CODE ,SERV_CLASSIFI\
CATION_CODE ,LOC_LANG_LONG_DESC ,LOC_LANG_SHORT_DESC ,PRT_GRP_HDR_CODE ,PRT_GR\
P_LINE_CODE ,DR_FEE_FLAG ,PHYS_CAT_CODE ,SOURCE_MODULE_DEPT_FLAG ,DEPT_CODE ,S\
ERV_LOCN_CODE ,SERV_ANAL_GRP1 ,SERV_ANAL_GRP2 ,DEF_REF_BILL_TYPE_CODE ,DIR_ENT\
RY_FLAG ,SOURCE_MODULE_RATE_FLAG ,RATE_ENTRY_BY_USER_FLAG ,DEF_CHARGE ,b.IP_RA\
TE ,b.OP_RATE ,b.REF_RATE ,b.MIN_CHARGE_AMT ,b.BASE_QTY ,NVL(MISC_SERV_YN,'N')\
 ,NVL(NURSING_SERV_YN,'N') ,a.STATUS ,ICD_CODE  from bl_blng_serv A ,BL_SERV_C\
UST_PC_PRICE b where ((((a.blng_serv_code=b.blng_serv_code and b.CUST_PC_IND='\
S') and trunc(sysdate) between trunc(b.VALID_FROM) and trunc(b.VALID_TO)) and \
A.BLNG_SERV_CODE between NVL(:b0,'!!!!!!!!!!') and NVL(:b1,'~~~~~~~~~')) and (\
((A.STATUS='S' and :b2='S') or (NVL(A.STATUS,'X')<>'S' and :b2='A')) or :b2='L\
')) order by A.BLNG_SERV_CODE            ";

 static const char *sq0006 = 
"select LONG_DESC ,SHORT_DESC  from BL_BLNG_SERV_GRP where SERV_GRP_CODE=:b0 \
          ";

 static const char *sq0007 = 
"select LONG_DESC ,SHORT_DESC  from BL_SERV_CLASSIFICATION where SERV_CLASSIF\
ICATION_CODE=:b0           ";

 static const char *sq0008 = 
"select LONG_DESC  from BL_BLNG_PRT_GRP_LINE where (PRT_GRP_HDR_CODE=:b0 and \
PRT_GRP_LINE_CODE=:b1)           ";

 static const char *sq0009 = 
"select LONG_DESC  from SY_DEPT where (DEPT_CODE=:b0 and OPERATING_FACILITY_I\
D between NVL(ltrim(rtrim(substr(:b1,1,2))),'  ') and NVL(ltrim(rtrim(substr(:\
b2,1,2))),'~~'))           ";

 static const char *sq0010 = 
"select LONG_DESC  from BL_SERVICE_LOCN where (SERV_LOCN_CODE=:b0 and OPERATI\
NG_FACILITY_ID between NVL(ltrim(rtrim(substr(:b1,1,2))),'  ') and NVL(ltrim(r\
trim(substr(:b2,1,2))),'~~'))           ";

 static const char *sq0011 = 
"select LONG_DESC  from BL_BILL_TYPE where BILL_TYPE_CODE=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,30,206,0,0,0,0,0,1,0,
20,0,0,2,128,0,4,215,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
51,0,0,3,193,0,4,242,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,1,9,0,0,1,9,0,0,
102,0,0,4,91,0,2,280,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
125,0,0,5,897,0,9,373,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
160,0,0,5,0,0,13,438,0,0,30,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,
0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
295,0,0,6,86,0,9,513,0,0,1,1,0,1,0,1,9,0,0,
314,0,0,6,0,0,13,517,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
337,0,0,7,103,0,9,535,0,0,1,1,0,1,0,1,9,0,0,
356,0,0,7,0,0,13,539,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
379,0,0,8,109,0,9,554,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
402,0,0,8,0,0,13,558,0,0,1,0,0,1,0,2,9,0,0,
421,0,0,9,181,0,9,572,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
448,0,0,9,0,0,13,576,0,0,1,0,0,1,0,2,9,0,0,
467,0,0,10,194,0,9,590,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
494,0,0,10,0,0,13,594,0,0,1,0,0,1,0,2,9,0,0,
513,0,0,11,71,0,9,608,0,0,1,1,0,1,0,1,9,0,0,
532,0,0,11,0,0,13,612,0,0,1,0,0,1,0,2,9,0,0,
551,0,0,5,0,0,15,1054,0,0,0,0,0,1,0,
566,0,0,6,0,0,15,1055,0,0,0,0,0,1,0,
581,0,0,7,0,0,15,1056,0,0,0,0,0,1,0,
596,0,0,8,0,0,15,1057,0,0,0,0,0,1,0,
611,0,0,9,0,0,15,1058,0,0,0,0,0,1,0,
626,0,0,10,0,0,15,1059,0,0,0,0,0,1,0,
641,0,0,11,0,0,15,1060,0,0,0,0,0,1,0,
656,0,0,12,0,0,27,1140,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.10.01                                                 */
/************************************************************************/
/* PROGRAM NAME          : BLRSERVI.PC                                  */
/* DATE WRITTEN          : 10-MAY-1993                                  */ 
/*                                                                      */
/* CALLED FROM           : BLRPRMST (FORM)                              */
/*                                                                      */
/* FUNCTION              :                                              */ 
/*                                                                      */
/*                                                                      */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */ 
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        BL_BLNG_SERV               Lookup                  */
/*         2.        BL_BLNG_SERV_FOR_GRP       Lookup                  */
/*         3.        BL_BLNG_CLASS              Lookup                  */
/*         4.        BL_BILL_TYPE               Lookup                  */
/*         5.        BL_BLNG_PRT_GRP_LINE       Lookup                  */
/*         6.        SY_DEPT                    Lookup                  */
/*         7.        BL_SERVICE_LOC             Lookup                  */
/*                                                                      */
/*  PARAMETERS                                                          */
/*    REPORT_TYPE - 1 LIST OF BILLING SERVICES                          */
/*                  2 NUMBER OF SERVICES WITHIN A CLASSIFICATION FOR A  */
/*                    SERVICE GROUP                                     */
/*                  3 NUMBER OF SERVICE CLASSIFICATION WITHIN A SERVICE */
/*                    GROUP                                             */
/*                                                                      */
/*    FROM BILLING SERVICE CODE  |  RANGE OF ROWS TO BE SELECTED.       */
/*    TO   BILLING SERVICE CODE  |                                      */
/*    PRINT OPTION -   S - SUSPENDED ROWS ONLY                          */
/*                     A - ACTIVE ROWS ONLY                             */
/*                     L - ALL ROWS                                     */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/************************************************************************/

#include <stdio.h>
#include <math.h>
#include <string.h>
#include "bl.h"           

#define OERROR (sqlca.sqlcode < 0)

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define INIT_MESG "Report Generation In Progress"
 
/*
#define DEBUG 0    
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /*  COMMAND LINE ARGUMENTS */
   /* VARCHAR uid_pwd         [132],
           nd_session_id   [16],
           nd_pgm_date     [15]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[15]; } nd_pgm_date;

   /*----------------------------------------------*/


   /*   PARAMETERS   */
   /* VARCHAR nd_report_type                [2],
   /o-- size for the blng_serv_codes was [6] now changed to [7] which is 
        correct because the size of blng_serv_code is 6. VSK 21/02/1999 o/
           nd_fr_blng_code               [11],
           nd_to_blng_code               [11],
           nd_print_option               [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_report_type;

struct { unsigned short len; unsigned char arr[11]; } nd_fr_blng_code;

struct { unsigned short len; unsigned char arr[11]; } nd_to_blng_code;

struct { unsigned short len; unsigned char arr[2]; } nd_print_option;


   /*----------------------------------------------*/
   /*  OTHER HOST VARIABLES   */

   /* VARCHAR nd_blng_serv_code              [11],
           nd_long_desc                   [41],
           nd_short_desc                  [16],
           nd_loc_lang_long_desc          [31],
           nd_loc_lang_short_desc         [17],
           nd_serv_grp_code               [3],
           nd_serv_grp_long_desc          [41],
           nd_serv_grp_short_desc         [16],
           nd_serv_classification_code    [4],
           nd_serv_class_long_desc        [41],
           nd_serv_class_short_desc       [16],
           nd_prt_grp_hdr_code            [3],
           nd_prt_grp_line_code           [3],
           nd_prt_long_desc               [41],
           nd_source_module_dept_flag     [2],
           nd_dept_code                   [7],
           nd_dept_long_desc              [41],                  
           nd_dr_fee_flag                 [2],
           nd_phys_cat_code               [2],
           nd_assy_serv_flag              [2],
           nd_serv_independent_use_flag   [2],
           nd_dir_entry_flag              [2],
           nd_source_module_rate_flag     [2],
           nd_rate_entry_by_user_flag     [2],
           nd_ip_applicable_flag          [2],
           nd_op_applicable_flag          [2],
           nd_ref_applicable_flag         [2],
           nd_ref_bill_type_code          [3],
           nd_bill_type_desc              [31],
           nd_serv_locn_code              [5],
           nd_serv_locn_desc              [31],
           nd_serv_anal_grp1              [7],
           nd_serv_anal_grp2              [7],
           nd_status                      [2],
           nd_nursing_serv_yn             [2],
           nd_misc_serv_yn                [2],
		   nd_icd_code					  [11],
		   nd_operating_facility_id       [3],
		   nd_fr_opr_facility             [3],
		   nd_to_opr_facility			  [3]; */ 
struct { unsigned short len; unsigned char arr[11]; } nd_blng_serv_code;

struct { unsigned short len; unsigned char arr[41]; } nd_long_desc;

struct { unsigned short len; unsigned char arr[16]; } nd_short_desc;

struct { unsigned short len; unsigned char arr[31]; } nd_loc_lang_long_desc;

struct { unsigned short len; unsigned char arr[17]; } nd_loc_lang_short_desc;

struct { unsigned short len; unsigned char arr[3]; } nd_serv_grp_code;

struct { unsigned short len; unsigned char arr[41]; } nd_serv_grp_long_desc;

struct { unsigned short len; unsigned char arr[16]; } nd_serv_grp_short_desc;

struct { unsigned short len; unsigned char arr[4]; } nd_serv_classification_code;

struct { unsigned short len; unsigned char arr[41]; } nd_serv_class_long_desc;

struct { unsigned short len; unsigned char arr[16]; } nd_serv_class_short_desc;

struct { unsigned short len; unsigned char arr[3]; } nd_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } nd_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[41]; } nd_prt_long_desc;

struct { unsigned short len; unsigned char arr[2]; } nd_source_module_dept_flag;

struct { unsigned short len; unsigned char arr[7]; } nd_dept_code;

struct { unsigned short len; unsigned char arr[41]; } nd_dept_long_desc;

struct { unsigned short len; unsigned char arr[2]; } nd_dr_fee_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_phys_cat_code;

struct { unsigned short len; unsigned char arr[2]; } nd_assy_serv_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_serv_independent_use_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_dir_entry_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_source_module_rate_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_rate_entry_by_user_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_ip_applicable_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_op_applicable_flag;

struct { unsigned short len; unsigned char arr[2]; } nd_ref_applicable_flag;

struct { unsigned short len; unsigned char arr[3]; } nd_ref_bill_type_code;

struct { unsigned short len; unsigned char arr[31]; } nd_bill_type_desc;

struct { unsigned short len; unsigned char arr[5]; } nd_serv_locn_code;

struct { unsigned short len; unsigned char arr[31]; } nd_serv_locn_desc;

struct { unsigned short len; unsigned char arr[7]; } nd_serv_anal_grp1;

struct { unsigned short len; unsigned char arr[7]; } nd_serv_anal_grp2;

struct { unsigned short len; unsigned char arr[2]; } nd_status;

struct { unsigned short len; unsigned char arr[2]; } nd_nursing_serv_yn;

struct { unsigned short len; unsigned char arr[2]; } nd_misc_serv_yn;

struct { unsigned short len; unsigned char arr[11]; } nd_icd_code;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_fr_opr_facility;

struct { unsigned short len; unsigned char arr[3]; } nd_to_opr_facility;

         
   double
           nd_ip_rate,                   
           nd_op_rate,                  
           nd_ref_rate,               
           nd_min_charge_amt,          
           nd_base_qty;                

   short   ind_fr_blng_code,
           ind_to_blng_code;
        
   /* VARCHAR user_id                       [91],
           hosp_name                     [120],
           date_time                     [20]; */ 
struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;


    double nd_def_charge;
	char string_var[150];
/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/Blrservi.c-arc   1.0   Apr 19 2007 17:07:10   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/Blrservi.c-arc   1.0   Apr 19 2007 17:07:10   vcm_th  $ sqlda.h 
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

FILE *fp;
char filename[150];
int lctr = 0,pctr = 0, pend_doc_ctr = 0,tot_grp = 0,tot_class = 0;

char old_serv_grp_code[3],
     old_serv_classification_code[4];

char first_record = 'Y',
     serv_group_change  = 'Y';

long no_serv_groups           = 0,
     no_serv_classifications  = 0,
     no_blng_servs            = 0;

char rep_name[3][70] = { "              BILLING SERVICES - DETAIL",
               "           BILLING SERVICES WITHIN CLASSIFICATION",
               "             CLASSIFICATIONS WITHIN SERVICE GROUP" };

char rep_file_name[3][9] = { "BLRSERV1", "BLRSERV2", "BLRSERV3" };

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

   strcpy(g_pgm_id,"BLRSERVI");

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   sql_connect();

   set_meduser_role();

    /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   fetch_param();
   start_prog_msg();
   fetch_desc();
   declare_cursors();
   if (strcmp(nd_report_type.arr,"1") == 0) 
      report1();
   else if (strcmp(nd_report_type.arr,"2") == 0)
      report2();
   else if (strcmp(nd_report_type.arr,"3") == 0) 
      report3();
   pend_doc_ctr = 0;
   close_cursors();
   delete_param();
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



   strcpy(g_pgm_id,"BLRSERVI");

    return;
}

fetch_desc()
{
   /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                   USER
              INTO :hosp_name, :date_time, :user_id
              FROM SY_ACC_ENTITY
			  WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )20;
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
   sqlstm.sqhstl[2] = (unsigned int  )93;
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

fetch_param()
{
    nd_report_type.arr[0]  = '\0';
    nd_fr_blng_code.arr[0] = '\0';
    nd_to_blng_code.arr[0] = '\0';
    nd_print_option.arr[0] = '\0';

    nd_report_type.len     = 0;
    nd_fr_blng_code.len    = 0;
    nd_to_blng_code.len    = 0;
    nd_print_option.len    = 0;

   /* EXEC SQL SELECT  OPERATING_FACILITY_ID,
					PARAM1,
                    PARAM2,
                    PARAM3,
                    PARAM4,
					PARAM5,
					PARAM6
            INTO    :nd_operating_facility_id,
					:nd_report_type,
/o-- wrong receiving items has been given now been corrected VSK 21/02/1999
					:nd_fr_blng_code:ind_fr_blng_code,
                    :nd_to_blng_code:ind_to_blng_code,o/
                    :nd_fr_blng_code,
                    :nd_to_blng_code,
                    :nd_print_option,
					:nd_fr_opr_facility,
					:nd_to_opr_facility
            FROM    SY_PROG_PARAM
            WHERE   PGM_ID     = 'BLRSERVI'
            AND     SESSION_ID = :nd_session_id
            AND     PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from SY_PROG_PARAM where \
((PGM_ID='BLRSERVI' and SESSION_ID=:b7) and PGM_DATE=:b8)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_report_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fr_blng_code;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_blng_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_print_option;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fr_opr_facility;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_opr_facility;
   sqlstm.sqhstl[6] = (unsigned int  )5;
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
   sqlstm.sqhstl[8] = (unsigned int  )17;
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
    
   nd_report_type.arr[nd_report_type.len]     = '\0';
   nd_fr_blng_code.arr[nd_fr_blng_code.len]   = '\0';
   nd_to_blng_code.arr[nd_to_blng_code.len]   = '\0';
   nd_print_option.arr[nd_print_option.len]   = '\0';

   strcpy(g_facility_id, nd_operating_facility_id.arr);
}

delete_param()
{
   /* EXEC SQL DELETE
            FROM    SY_PROG_PARAM
            WHERE   PGM_ID     = 'BLRSERVI'
            AND     SESSION_ID = :nd_session_id
            AND     PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRSERVI' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )102;
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
   sqlstm.sqhstl[1] = (unsigned int  )17;
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
declare_cursors()
{

/* EXEC SQL DECLARE BL_BLNG_SERV_CUR CURSOR FOR 
                  SELECT a.BLNG_SERV_CODE,
                LONG_DESC,
                SHORT_DESC,
                SERV_GRP_CODE,
                SERV_CLASSIFICATION_CODE,
                LOC_LANG_LONG_DESC,
                LOC_LANG_SHORT_DESC,
                PRT_GRP_HDR_CODE,
                PRT_GRP_LINE_CODE,
                DR_FEE_FLAG,
                PHYS_CAT_CODE,
                SOURCE_MODULE_DEPT_FLAG,
                DEPT_CODE,
                SERV_LOCN_CODE,
                SERV_ANAL_GRP1,
                SERV_ANAL_GRP2,
                DEF_REF_BILL_TYPE_CODE,
                DIR_ENTRY_FLAG,
                SOURCE_MODULE_RATE_FLAG,
                RATE_ENTRY_BY_USER_FLAG,
                DEF_CHARGE,
                b.IP_RATE,
                b.OP_RATE,
                b.REF_RATE,
                b.MIN_CHARGE_AMT,
                b.BASE_QTY,  
                NVL(MISC_SERV_YN,'N'),
                NVL(NURSING_SERV_YN,'N'),
                a.STATUS ,
		ICD_CODE       
         FROM   bl_blng_serv A, BL_SERV_CUST_PC_PRICE b
 	 WHERE  a.blng_serv_code = b.blng_serv_code
 	 and    b.CUST_PC_IND    = 'S'
 	 AND    trunc(sysdate) between trunc(b.VALID_FROM) and trunc(b.VALID_TO)
	 AND    A.BLNG_SERV_CODE BETWEEN NVL(:nd_fr_blng_code,'!!!!!!!!!!')
                                   AND NVL(:nd_to_blng_code, '~~~~~~~~~')
         AND    ((A.STATUS = 'S' AND :nd_print_option = 'S') OR
                 (NVL(A.STATUS,'X') != 'S' AND :nd_print_option = 'A') OR
                 (:nd_print_option = 'L'))
       ORDER BY A.BLNG_SERV_CODE; */ 


/* EXEC SQL DECLARE BL_BLNG_SERV_GRP_CUR CURSOR FOR
         SELECT LONG_DESC, SHORT_DESC 
         FROM   BL_BLNG_SERV_GRP
         WHERE  SERV_GRP_CODE = :nd_serv_grp_code; */ 


/* EXEC SQL DECLARE BL_SERV_CLASSIFICATION_CUR CURSOR FOR
         SELECT LONG_DESC, SHORT_DESC
         FROM   BL_SERV_CLASSIFICATION
         WHERE  SERV_CLASSIFICATION_CODE = :nd_serv_classification_code; */ 


/* EXEC SQL DECLARE BL_BLNG_PRT_GRP_LINE_CUR CURSOR FOR
         SELECT LONG_DESC 
         FROM   BL_BLNG_PRT_GRP_LINE
         WHERE  PRT_GRP_HDR_CODE  = :nd_prt_grp_hdr_code 
         AND    PRT_GRP_LINE_CODE = :nd_prt_grp_line_code; */ 


/* EXEC SQL DECLARE SY_DEPT_CUR CURSOR FOR
         SELECT LONG_DESC 
         FROM   SY_DEPT 
         WHERE  DEPT_CODE = :nd_dept_code
		 AND    OPERATING_FACILITY_ID BETWEEN
		             NVL(ltrim(rtrim(substr(:nd_fr_opr_facility,1,2))),'  ')
				AND  NVL(ltrim(rtrim(substr(:nd_to_opr_facility,1,2))),'~~'); */ 


/* EXEC SQL DECLARE BL_SERVICE_LOCN_CUR CURSOR FOR
         SELECT LONG_DESC
         FROM   BL_SERVICE_LOCN
         WHERE  SERV_LOCN_CODE = :nd_serv_locn_code
		 AND    OPERATING_FACILITY_ID BETWEEN 
				NVL(ltrim(rtrim(substr(:nd_fr_opr_facility,1,2))),'  ')
				AND  NVL(ltrim(rtrim(substr(:nd_to_opr_facility,1,2))),'~~'); */ 


 /* EXEC SQL DECLARE BL_BILL_TYPE_CUR CURSOR FOR
          SELECT LONG_DESC 
          FROM   BL_BILL_TYPE
          WHERE  BILL_TYPE_CODE  = :nd_ref_bill_type_code; */ 

}

open_blngserv()
{
  /* EXEC SQL OPEN BL_BLNG_SERV_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 9;
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
  sqlstm.sqhstv[0] = (         void  *)&nd_fr_blng_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_to_blng_code;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_print_option;
  sqlstm.sqhstl[2] = (unsigned int  )4;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_print_option;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_print_option;
  sqlstm.sqhstl[4] = (unsigned int  )4;
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
     err_mesg("OPEN failed on cursor BL_BLNG_SERV_CUR",0," ");
}

fetch_blngserv()
{
  nd_blng_serv_code.arr[0]              = '\0';
  nd_long_desc.arr[0]                   = '\0';
  nd_short_desc.arr[0]                  = '\0';
  nd_serv_grp_code.arr[0]               = '\0';
  nd_serv_classification_code.arr[0]    = '\0'; 
  nd_loc_lang_long_desc.arr[0]          = '\0';
  nd_loc_lang_short_desc.arr[0]         = '\0';
  nd_prt_grp_hdr_code.arr[0]            = '\0';
  nd_prt_grp_line_code.arr[0]           = '\0';
  nd_dr_fee_flag.arr[0]                 = '\0';
  nd_phys_cat_code.arr[0]               = '\0';
  nd_source_module_dept_flag.arr[0]     = '\0';
  nd_dept_code.arr[0]                   = '\0';
  nd_serv_locn_code.arr[0]              = '\0';
  nd_serv_anal_grp1.arr[0]              = '\0';
  nd_serv_anal_grp2.arr[0]              = '\0';
  nd_ref_bill_type_code.arr[0]          = '\0';
  nd_dir_entry_flag.arr[0]              = '\0';
  nd_source_module_rate_flag.arr[0]     = '\0';
  nd_rate_entry_by_user_flag.arr[0]     = '\0';
  nd_misc_serv_yn.arr[0]                = '\0';
  nd_nursing_serv_yn.arr[0]             = '\0';
  nd_status.arr[0]                      = '\0';
  nd_icd_code.arr[0]					= '\0';

  nd_blng_serv_code.len              = 0;
  nd_long_desc.len                   = 0;
  nd_short_desc.len                  = 0;
  nd_serv_grp_code.len               = 0;
  nd_serv_classification_code.len    = 0; 
  nd_loc_lang_long_desc.len          = 0;
  nd_loc_lang_short_desc.len         = 0;
  nd_prt_grp_hdr_code.len            = 0;
  nd_prt_grp_line_code.len           = 0;
  nd_dr_fee_flag.len                 = 0;
  nd_phys_cat_code.len               = 0;
  nd_source_module_dept_flag.len     = 0;
  nd_dept_code.len                   = 0;
  nd_serv_locn_code.len              = 0;
  nd_serv_anal_grp1.len              = 0;
  nd_serv_anal_grp2.len              = 0;
  nd_ref_bill_type_code.len          = 0;
  nd_dir_entry_flag.len              = 0;
  nd_source_module_rate_flag.len     = 0;
  nd_rate_entry_by_user_flag.len     = 0;
  nd_nursing_serv_yn.len             = 0;
  nd_misc_serv_yn.len                = 0;
  nd_status.len                      = 0;
  nd_icd_code.len                    = 0;

  nd_def_charge                     = 0;
  nd_ip_rate                        = 0;
  nd_op_rate                        = 0;
  nd_ref_rate                       = 0;
  nd_min_charge_amt                 = 0;
  nd_base_qty                       = 0;

      
  /* EXEC SQL FETCH BL_BLNG_SERV_CUR INTO 
                   :nd_blng_serv_code,
                   :nd_long_desc,
                   :nd_short_desc,
                   :nd_serv_grp_code,                
                   :nd_serv_classification_code,
                   :nd_loc_lang_long_desc,
                   :nd_loc_lang_short_desc,        
                   :nd_prt_grp_hdr_code,
                   :nd_prt_grp_line_code,
                   :nd_dr_fee_flag,
                   :nd_phys_cat_code,
                   :nd_source_module_dept_flag,
                   :nd_dept_code,
                   :nd_serv_locn_code,
                   :nd_serv_anal_grp1,
                   :nd_serv_anal_grp2,
                   :nd_ref_bill_type_code,
                   :nd_dir_entry_flag,
                   :nd_source_module_rate_flag,
                   :nd_rate_entry_by_user_flag,
                   :nd_def_charge,
                   :nd_ip_rate,
                   :nd_op_rate,
                   :nd_ref_rate,
                   :nd_min_charge_amt,    
                   :nd_base_qty,
                   :nd_misc_serv_yn,
                   :nd_nursing_serv_yn,
                   :nd_status,
				   :nd_icd_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )160;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_blng_serv_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_long_desc;
  sqlstm.sqhstl[1] = (unsigned int  )43;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_short_desc;
  sqlstm.sqhstl[2] = (unsigned int  )18;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_serv_grp_code;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_serv_classification_code;
  sqlstm.sqhstl[4] = (unsigned int  )6;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_loc_lang_long_desc;
  sqlstm.sqhstl[5] = (unsigned int  )33;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_loc_lang_short_desc;
  sqlstm.sqhstl[6] = (unsigned int  )19;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_prt_grp_hdr_code;
  sqlstm.sqhstl[7] = (unsigned int  )5;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_prt_grp_line_code;
  sqlstm.sqhstl[8] = (unsigned int  )5;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_dr_fee_flag;
  sqlstm.sqhstl[9] = (unsigned int  )4;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_phys_cat_code;
  sqlstm.sqhstl[10] = (unsigned int  )4;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_source_module_dept_flag;
  sqlstm.sqhstl[11] = (unsigned int  )4;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_dept_code;
  sqlstm.sqhstl[12] = (unsigned int  )9;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_serv_locn_code;
  sqlstm.sqhstl[13] = (unsigned int  )7;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_serv_anal_grp1;
  sqlstm.sqhstl[14] = (unsigned int  )9;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_serv_anal_grp2;
  sqlstm.sqhstl[15] = (unsigned int  )9;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_ref_bill_type_code;
  sqlstm.sqhstl[16] = (unsigned int  )5;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&nd_dir_entry_flag;
  sqlstm.sqhstl[17] = (unsigned int  )4;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&nd_source_module_rate_flag;
  sqlstm.sqhstl[18] = (unsigned int  )4;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)&nd_rate_entry_by_user_flag;
  sqlstm.sqhstl[19] = (unsigned int  )4;
  sqlstm.sqhsts[19] = (         int  )0;
  sqlstm.sqindv[19] = (         void  *)0;
  sqlstm.sqinds[19] = (         int  )0;
  sqlstm.sqharm[19] = (unsigned int  )0;
  sqlstm.sqadto[19] = (unsigned short )0;
  sqlstm.sqtdso[19] = (unsigned short )0;
  sqlstm.sqhstv[20] = (         void  *)&nd_def_charge;
  sqlstm.sqhstl[20] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[20] = (         int  )0;
  sqlstm.sqindv[20] = (         void  *)0;
  sqlstm.sqinds[20] = (         int  )0;
  sqlstm.sqharm[20] = (unsigned int  )0;
  sqlstm.sqadto[20] = (unsigned short )0;
  sqlstm.sqtdso[20] = (unsigned short )0;
  sqlstm.sqhstv[21] = (         void  *)&nd_ip_rate;
  sqlstm.sqhstl[21] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[21] = (         int  )0;
  sqlstm.sqindv[21] = (         void  *)0;
  sqlstm.sqinds[21] = (         int  )0;
  sqlstm.sqharm[21] = (unsigned int  )0;
  sqlstm.sqadto[21] = (unsigned short )0;
  sqlstm.sqtdso[21] = (unsigned short )0;
  sqlstm.sqhstv[22] = (         void  *)&nd_op_rate;
  sqlstm.sqhstl[22] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[22] = (         int  )0;
  sqlstm.sqindv[22] = (         void  *)0;
  sqlstm.sqinds[22] = (         int  )0;
  sqlstm.sqharm[22] = (unsigned int  )0;
  sqlstm.sqadto[22] = (unsigned short )0;
  sqlstm.sqtdso[22] = (unsigned short )0;
  sqlstm.sqhstv[23] = (         void  *)&nd_ref_rate;
  sqlstm.sqhstl[23] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[23] = (         int  )0;
  sqlstm.sqindv[23] = (         void  *)0;
  sqlstm.sqinds[23] = (         int  )0;
  sqlstm.sqharm[23] = (unsigned int  )0;
  sqlstm.sqadto[23] = (unsigned short )0;
  sqlstm.sqtdso[23] = (unsigned short )0;
  sqlstm.sqhstv[24] = (         void  *)&nd_min_charge_amt;
  sqlstm.sqhstl[24] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[24] = (         int  )0;
  sqlstm.sqindv[24] = (         void  *)0;
  sqlstm.sqinds[24] = (         int  )0;
  sqlstm.sqharm[24] = (unsigned int  )0;
  sqlstm.sqadto[24] = (unsigned short )0;
  sqlstm.sqtdso[24] = (unsigned short )0;
  sqlstm.sqhstv[25] = (         void  *)&nd_base_qty;
  sqlstm.sqhstl[25] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[25] = (         int  )0;
  sqlstm.sqindv[25] = (         void  *)0;
  sqlstm.sqinds[25] = (         int  )0;
  sqlstm.sqharm[25] = (unsigned int  )0;
  sqlstm.sqadto[25] = (unsigned short )0;
  sqlstm.sqtdso[25] = (unsigned short )0;
  sqlstm.sqhstv[26] = (         void  *)&nd_misc_serv_yn;
  sqlstm.sqhstl[26] = (unsigned int  )4;
  sqlstm.sqhsts[26] = (         int  )0;
  sqlstm.sqindv[26] = (         void  *)0;
  sqlstm.sqinds[26] = (         int  )0;
  sqlstm.sqharm[26] = (unsigned int  )0;
  sqlstm.sqadto[26] = (unsigned short )0;
  sqlstm.sqtdso[26] = (unsigned short )0;
  sqlstm.sqhstv[27] = (         void  *)&nd_nursing_serv_yn;
  sqlstm.sqhstl[27] = (unsigned int  )4;
  sqlstm.sqhsts[27] = (         int  )0;
  sqlstm.sqindv[27] = (         void  *)0;
  sqlstm.sqinds[27] = (         int  )0;
  sqlstm.sqharm[27] = (unsigned int  )0;
  sqlstm.sqadto[27] = (unsigned short )0;
  sqlstm.sqtdso[27] = (unsigned short )0;
  sqlstm.sqhstv[28] = (         void  *)&nd_status;
  sqlstm.sqhstl[28] = (unsigned int  )4;
  sqlstm.sqhsts[28] = (         int  )0;
  sqlstm.sqindv[28] = (         void  *)0;
  sqlstm.sqinds[28] = (         int  )0;
  sqlstm.sqharm[28] = (unsigned int  )0;
  sqlstm.sqadto[28] = (unsigned short )0;
  sqlstm.sqtdso[28] = (unsigned short )0;
  sqlstm.sqhstv[29] = (         void  *)&nd_icd_code;
  sqlstm.sqhstl[29] = (unsigned int  )13;
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
     err_mesg("FETCH failed on cursor BL_BLNG_SERV_CUR",0," ");


  nd_blng_serv_code.arr[nd_blng_serv_code.len]                     = '\0';
  nd_long_desc.arr[nd_long_desc.len]                               = '\0';
  nd_short_desc.arr[nd_short_desc.len]                             = '\0';
  nd_serv_grp_code.arr[nd_serv_grp_code.len]                       = '\0';
  nd_serv_classification_code.arr[nd_serv_classification_code.len] = '\0'; 
  nd_loc_lang_long_desc.arr[nd_loc_lang_long_desc.len]             = '\0';
  nd_loc_lang_short_desc.arr[nd_loc_lang_short_desc.len]           = '\0';
  nd_prt_grp_hdr_code.arr[nd_prt_grp_hdr_code.len]                 = '\0';
  nd_prt_grp_line_code.arr[nd_prt_grp_line_code.len]               = '\0';
  nd_dr_fee_flag.arr[nd_dr_fee_flag.len]                           = '\0';
  nd_phys_cat_code.arr[nd_phys_cat_code.len]                       = '\0';
  nd_source_module_dept_flag.arr[nd_source_module_dept_flag.len]   = '\0';
  nd_dept_code.arr[nd_dept_code.len]                               = '\0';
  nd_serv_locn_code.arr[nd_serv_locn_code.len]                     = '\0';
  nd_serv_anal_grp1.arr[nd_serv_anal_grp1.len]                     = '\0';
  nd_serv_anal_grp2.arr[nd_serv_anal_grp2.len]                     = '\0';
  nd_ref_bill_type_code.arr[nd_ref_bill_type_code.len]             = '\0';
  nd_dir_entry_flag.arr[nd_dir_entry_flag.len]                     = '\0';
  nd_source_module_rate_flag.arr[nd_source_module_rate_flag.len]   = '\0';
  nd_rate_entry_by_user_flag.arr[nd_rate_entry_by_user_flag.len]   = '\0';
  nd_misc_serv_yn.arr[nd_misc_serv_yn.len]                         = '\0';
  nd_nursing_serv_yn.arr[nd_nursing_serv_yn.len]                   = '\0';
  nd_status.arr[nd_status.len]                                     = '\0';
  nd_icd_code.arr[nd_icd_code.len]								   = '\0';

  if (LAST_ROW) 
      return (0);
  else  
      return(1);
}

get_blng_serv_grp_desc()
{
   nd_serv_grp_long_desc.arr[0]  =  '\0';
   nd_serv_grp_long_desc.len     =  0;

   nd_serv_grp_short_desc.arr[0] =  '\0';
   nd_serv_grp_short_desc.len    =  0;

   /* EXEC SQL OPEN BL_BLNG_SERV_GRP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )295;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_serv_grp_code;
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
      err_mesg("OPEN failed on cursor BL_BLNG_SERV_GRP_CUR", 0," ");

   /* EXEC SQL FETCH BL_BLNG_SERV_GRP_CUR
            INTO   :nd_serv_grp_long_desc, nd_serv_grp_short_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )314;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_serv_grp_long_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_serv_grp_short_desc;
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
      err_mesg("FETCH failed on cursor BL_BLNG_SERV_GRP_CUR", 0," ");

   nd_serv_grp_long_desc.arr[nd_serv_grp_long_desc.len]   = '\0';
   nd_serv_grp_short_desc.arr[nd_serv_grp_short_desc.len] = '\0';

}

get_blng_serv_class_desc()
{
   nd_serv_class_long_desc.arr[0]  =  '\0';
   nd_serv_class_long_desc.len     =  0;

   nd_serv_class_short_desc.arr[0]  =  '\0';
   nd_serv_class_short_desc.len     =  0;

   /* EXEC SQL OPEN BL_SERV_CLASSIFICATION_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )337;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_serv_classification_code;
   sqlstm.sqhstl[0] = (unsigned int  )6;
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
      err_mesg("OPEN failed on cursor BL_SERV_CLASSIFICATION_CUR", 0," ");

   /* EXEC SQL FETCH BL_SERV_CLASSIFICATION_CUR
            INTO  :nd_serv_class_long_desc, nd_serv_class_short_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )356;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_serv_class_long_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_serv_class_short_desc;
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
      err_mesg("FETCH failed on cursor BL_SERV_CLASSIFICATION_CUR", 0," ");

   nd_serv_class_long_desc.arr[nd_serv_class_long_desc.len]     = '\0';
   nd_serv_class_short_desc.arr[nd_serv_class_short_desc.len]   = '\0';

}  

get_prt_line_desc()
{
   nd_prt_long_desc.arr[0]  = '\0';
   nd_prt_long_desc.len     = 0;

   /* EXEC SQL OPEN BL_BLNG_PRT_GRP_LINE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0008;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )379;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_prt_grp_hdr_code;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_prt_grp_line_code;
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
      err_mesg("OPEN failed on cursor BL_BLNG_PRT_GRP_LINE_CUR", 0," ");

   /* EXEC SQL FETCH BL_BLNG_PRT_GRP_LINE_CUR
            INTO  :nd_prt_long_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )402;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_prt_long_desc;
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
      err_mesg("FETCH failed on cursor BL_BLNG_PRT_GRP_LINE_CUR", 0," ");

   nd_prt_long_desc.arr[nd_prt_long_desc.len] = '\0';

}  

get_sy_dept_desc()  
{
   nd_dept_long_desc.arr[0]    = '\0';
   nd_dept_long_desc.len       =  0;

   /* EXEC SQL OPEN SY_DEPT_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0009;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )421;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_dept_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fr_opr_facility;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_opr_facility;
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
      err_mesg("OPEN failed on cursor SY_DEPT_CUR", 0," ");

   /* EXEC SQL FETCH SY_DEPT_CUR
            INTO  :nd_dept_long_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )448;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_dept_long_desc;
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
      err_mesg("FETCH failed on cursor SY_DEPT_CUR", 0," ");
 
   nd_dept_long_desc.arr[nd_dept_long_desc.len]  = '\0';
   
}

get_service_locn_desc()
{
   nd_serv_locn_desc.arr[0] = '\0';
   nd_serv_locn_desc.len    = 0;

   /* EXEC SQL OPEN BL_SERVICE_LOCN_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0010;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )467;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_serv_locn_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fr_opr_facility;
   sqlstm.sqhstl[1] = (unsigned int  )5;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_opr_facility;
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
      err_mesg("OPEN failed on cursor BL_SERVICE_LOCN_CUR", 0," ");

   /* EXEC SQL FETCH BL_SERVICE_LOCN_CUR
            INTO  :nd_serv_locn_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )494;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_serv_locn_desc;
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
      err_mesg("FETCH failed on cursor BL_SERVICE_LOCN_CUR", 0," ");
 
   nd_serv_locn_desc.arr[nd_serv_locn_desc.len] = '\0';

}

get_bill_type_desc()
{
   nd_bill_type_desc.arr[0] = '\0';
   nd_bill_type_desc.len    = 0;

   /* EXEC SQL OPEN BL_BILL_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0011;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )513;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_ref_bill_type_code;
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
      err_mesg("OPEN failed on cursor BL_BILL_TYPE_CUR", 0," ");

   /* EXEC SQL FETCH BL_BILL_TYPE_CUR
            INTO  :nd_bill_type_desc; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )532;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_bill_type_desc;
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
      err_mesg("FETCH failed on cursor BL_BILL_TYPE_CUR", 0," ");

   nd_bill_type_desc.arr[nd_bill_type_desc.len] = '\0';

}

/***************************  Report Type  1  *********************************/
report1()
{
/*-- commented the following line due to not opening the report on editor
     VSK 22/02/1999 */
//   strcpy(filename,WORKING_DIR);
   strcat(filename,"blrserv1.lis");
   open_file(filename);
   open_blngserv();
   print_report_title(1);
   first_record = 'Y';
   no_blng_servs = 0;
   no_serv_classifications = 0;
   no_serv_groups = 0;
   print_page_header1();
   while(fetch_blngserv())
   {
       get_blng_serv_grp_desc();
       get_blng_serv_class_desc();
       get_prt_line_desc();
       get_sy_dept_desc();
       get_service_locn_desc();
       get_bill_type_desc();
       print_serv_group1(); 
       print_serv_classification();
       print_report1_detail();
       first_record = 'N';
   }
   print_detail_footer1();
   print_class_footer1();
   print_end1();
}

print_serv_group1()
{
  if (strcmp(old_serv_grp_code, nd_serv_grp_code.arr))
  {
     serv_group_change = 'Y';
     print_detail_footer1();
     print_class_footer1();
     if (lctr > 54) print_page_header1();
     fprintf(fp,"SERVICE GROUP : %-3.3s %-40.40s %-15.15s\n\n", 
                              nd_serv_grp_code.arr,
                              nd_serv_grp_long_desc.arr,
                              nd_serv_grp_short_desc.arr);
     no_serv_groups++;
     strcpy(old_serv_grp_code, nd_serv_grp_code.arr);
     lctr += 2;
  }
}

print_serv_classification()
{
  if (strcmp(nd_serv_classification_code.arr,old_serv_classification_code))
  {
     if (serv_group_change != 'Y')
         print_detail_footer1();
     if (lctr > 54) print_page_header1();

     fprintf(fp,"SERVICE CLASSIFICATION : %-3.3s %-40.40s %-15.15s\n\n", 
                              nd_serv_classification_code.arr,
                              nd_serv_class_long_desc.arr,
                              nd_serv_class_short_desc.arr);
     no_serv_classifications++;
     strcpy(old_serv_classification_code, nd_serv_classification_code.arr);
     lctr += 2;
  }
  serv_group_change = 'N';
}

print_report1_detail()
{
  print_serv_classification();
  if (lctr > 55 - 6)
     print_page_header1();

  fflush(fp);
  fprintf(fp,"  %-10s %-40.40s  %-15.15s  %-30.30s  %-16.16s\n",
                  nd_blng_serv_code.arr, nd_long_desc.arr, nd_short_desc.arr,
                  nd_loc_lang_long_desc.arr, nd_loc_lang_short_desc.arr);
  fprintf(fp,"%-6.6s     %-2.2s-%-2.2s          %-40.40s  ",
                  " ", nd_prt_grp_hdr_code.arr, nd_prt_grp_line_code.arr,
                  nd_prt_long_desc.arr);
    fprintf(fp,"%-1.1s       %-1.1s       %-1.1s        %-6.6s %-40.40s\n",
                         nd_dr_fee_flag.arr, nd_phys_cat_code.arr,
                         nd_source_module_dept_flag.arr,
                         nd_dept_code.arr, nd_dept_long_desc.arr);
  fprintf(fp,"%-6.6s     %-4.4s       %-30.30s  %-6.6s         %-6.6s         ",
                  " ", nd_serv_locn_code.arr, nd_serv_locn_desc.arr,
                  nd_serv_anal_grp1.arr, nd_serv_anal_grp2.arr);
  fprintf(fp, "%-2.2s         %-30.30s\n",
                  nd_ref_bill_type_code.arr, nd_bill_type_desc.arr);
  fprintf(fp,"%-6.6s     %-1.1s             %-1.1s        %-1.1s         ",
                   " ", nd_dir_entry_flag.arr, nd_source_module_rate_flag.arr,
                   nd_rate_entry_by_user_flag.arr);
  print_formated(nd_def_charge); fprintf(fp,"\n");
  fprintf(fp,"%-6.6s     ", " ");
                print_formated(nd_ip_rate); fprintf(fp,"  ");
                print_formated(nd_op_rate); fprintf(fp,"  ");
                print_formated(nd_ref_rate); fprintf(fp,"  ");
                print_formated(nd_min_charge_amt); fprintf(fp,"  ");
                print_formated(nd_base_qty);
                fprintf(fp," %-1.1s           ", nd_misc_serv_yn.arr);
                fprintf(fp," %-1.1s", nd_nursing_serv_yn.arr);
                fprintf(fp,"            %-1.1s\n", nd_status.arr);
                fprintf(fp,"            %-10.1s\n", nd_icd_code.arr);

  fprintf(fp,"\n");
  no_blng_servs++;
  lctr += 6;
}

print_class_footer1()
{
     if (first_record == 'N')
     {
        if (lctr > 54) print_page_header1();

        fprintf(fp,"\t\tTOTAL NUMBER OF SERVICE CLASSIFICATIONS : %6ld\n\n", 
                                                      no_serv_classifications);
        no_serv_classifications = 0;
        no_blng_servs = 0;
        lctr += 2;
     }
}

print_detail_footer1()
{
     if (first_record == 'N')
     {
        if (lctr > 54) print_page_header1();

        fprintf(fp,"\t\tTOTAL NUMBER OF SERVICES : %6ld\n\n", no_blng_servs);
        no_blng_servs = 0;
        lctr += 2;
     }
}

print_page_header1()
{
  fflush(fp);
  fprintf(fp, "\f\n\nMDL : BL %-43s %-30s %-31s %-15s\n",
                           " ", hosp_name.arr," ", date_time.arr);
  fprintf(fp, "OPR : %-10s %-20s %s\n",
  user_id.arr," ",rep_name[0]);
  fprintf(fp, "REP : %-8s %-105s PAGE : %4d\n",
                  "BLRSERV1", " ", ++pctr);
  fprintf(fp, "%s%s%s\n",
              "------------------------------------------------------------",
              "--------------------------------------------------------------------",
              "------------");
  fprintf(fp, "BLNG CODE  DESCRIPTION                               ");
     fprintf(fp, "SHORT DESC.      LOCAL   DESCRIPTION             ");
     fprintf(fp, "LOCAL   SHORT DESC\n");
  fprintf(fp, "%-9.9s  PRT GRP  LINE  ", " ");
     fprintf(fp, "DESCRIPTION                               ");
     fprintf(fp, "DR FEE  DR CAT  SM DEPT  DEPT   DESCRIPTION\n");
  fprintf(fp, "%-9.9s  SERV LOCN  DESCRIPTION %-20.20s", " ", " ");
     fprintf(fp, "ANALYSIS GRP1  ANALYSIS GRP2  BILL TYPE  DESCRIPTION\n");
  fprintf(fp,"%-9.9s  DIRECT ENTRY  SM RATE  RATE/CHG           DEF CHG\n"," ");
  fprintf(fp, "%-9.9s         IP RATE          OP RATE"," ");
     fprintf(fp, "    REFERRAL RATE       MIN CHARGE");
     fprintf(fp, "         QUANTITY  MISC SERV ?  NURSING SERV ?  STATUS  ICD CODE\n");
fprintf(fp,"----------------------------------------------------------------%s",
    "----------------------------------------------------------------------------\n\n");
  lctr = 13;
}

print_end1()
{
  if (lctr > 55 - 7) print_page_header1();
  fprintf(fp,"\n\t\tTOTAL NO OF SERVICE GROUPS : %6ld\n",no_serv_groups);
  if (lctr > 55 - 5) print_page_header1();
  fprintf(fp, "\n\n\n %-52s **   END  OF  REPORT   ** \n\n", " ");
  fflush(fp);
  fclose(fp);
}

/**  End of Report 1 Routines **/

/********************************  Report 2 ***********************************/
report2()
{
/*-- commented the following line due to not opening the report on editor
     VSK 22/02/1999 */
//   strcpy(filename,WORKING_DIR);
     strcat(filename,"blrserv2.lis");
     open_file(filename);
     print_report_title(2);
     print_page_header2();
     first_record = 'Y';
     no_blng_servs = 0;
     no_serv_classifications = 0;
     no_serv_groups = 0;
     open_blngserv();
     while(fetch_blngserv())
     {
         print_serv_group2();
         print_report2_detail();
         first_record = 'N';
     }
     print_detail_footer2();
     print_class_footer2();
     print_end2();
}

print_serv_group2()
{
  if (strcmp(old_serv_grp_code, nd_serv_grp_code.arr))
  {
     serv_group_change = 'Y';
     print_detail_footer2();
     print_class_footer2();

     if (lctr > 54) print_page_header1();
     fprintf(fp,"SERVICE GROUP : %-3.3s %-40.40s %-15.15s\n\n", 
                              nd_serv_grp_code.arr,
                              nd_serv_grp_long_desc.arr,
                              nd_serv_grp_short_desc.arr);
     no_serv_groups++;
     strcpy(old_serv_grp_code, nd_serv_grp_code.arr);
     lctr += 2;
  }
}

print_class_footer2()
{
     if (first_record == 'N')
     {
        if (lctr > 54) print_page_header2();
        fprintf(fp,"\t\tTOTAL NUMBER OF SERVICE CLASSIFICATIONS : %6ld\n\n", 
                                                 no_serv_classifications);
        lctr += 2;
        no_serv_classifications = 0;
     }
}

print_detail_footer2()
{
     if (first_record == 'N')
     {
        if (lctr > 54) print_page_header2();
        fprintf(fp,"           %6ld\n", no_blng_servs);
        lctr += 1;
     }
}

print_report2_detail()
{
  print_serv_group2();
  if (strcmp(nd_serv_classification_code.arr,old_serv_classification_code))
  {
     if (serv_group_change != 'Y')
        print_detail_footer2();
     if (lctr > 54) print_page_header2();

     get_blng_serv_class_desc();
     fprintf(fp,"                    %-3.3s            %-40.40s  %-15.15s", 
                              nd_serv_classification_code.arr,
                              nd_serv_class_long_desc.arr,
                              nd_serv_class_short_desc.arr);
     no_serv_classifications++;
     no_blng_servs = 0;
     strcpy(old_serv_classification_code, nd_serv_classification_code.arr);
  }
  serv_group_change = 'N';
  no_blng_servs++;
}

/* Page Heading */
print_page_header2()
{
  fprintf(fp, "\f\n\nMDL : BL %-43s %-30s %-31s %-15s\n",
                           " ", hosp_name.arr," ", date_time.arr);
  fprintf(fp, "OPR : %-10s %-20s %s\n",
   user_id.arr," ",
   "BILLING SERVICES WITHIN CLASSIFICATION");
  fprintf(fp, "REP : %-8s %-105s PAGE : %4d\n",
                  "BLRSERV2", " ", ++pctr);
  fprintf(fp, "%s%s%s\n",
              "------------------------------------------------------------",
              "------------------------------------------------------------",
              "------------");
  fprintf(fp,"\n");
  fprintf(fp,"%19.19s SERVICE CLASS  DESCRIPTION %30.30s"," "," ");
  fprintf(fp,"SHORT DESC        TOTAL SERVICES\n");
  fprintf(fp,"--------------------------------------------------------------%s",
   "----------------------------------------------------------------------\n");
  fprintf(fp,"\n");
  fflush(fp);
  lctr = 10;
  fflush(fp);
}

print_end2()
{
  if (lctr > 55 - 7) print_page_header2();
  fprintf(fp,"\n\t\tTOTAL NO OF SERVICE GROUPS : %6ld\n",no_serv_groups);
  if (lctr > 55 - 5) print_page_header2();
  fprintf(fp, "\n\n\n %-52s **   END  OF  REPORT   ** \n\n", " ");
  fflush(fp);
  fclose(fp);
}

/** End of Report 2 Routines **/

/******************************** Report 3 ************************************/
report3()
{
/*-- commented the following line due to not opening the report on editor
     VSK 22/02/1999 */
//   strcpy(filename,WORKING_DIR);
    strcat(filename,"blrserv3.lis");
    open_file(filename);
    print_report_title(3); 
    print_page_header3();
    first_record = 'Y';
    no_blng_servs = 0;
    no_serv_classifications = 0;
    no_serv_groups = 0;
    open_blngserv();
    while (fetch_blngserv())
          print_report3_detail();
    if (first_record == 'N')
    {
       fprintf(fp," %15.15s %6ld\n\n", " ", no_serv_classifications);
       lctr += 2;
    }
    print_end3();
}

print_report3_detail()
{
  
  if (strcmp(nd_serv_grp_code.arr,old_serv_grp_code))
  {
     get_blng_serv_grp_desc();
     if (first_record == 'N')
     {
        fprintf(fp," %15.15s %6ld\n", " ", no_serv_classifications);
        lctr += 1;
     }
     if (lctr > 54) print_page_header3();

     fprintf(fp,"%-2.2s             %-40.40s  %-15.15s",
                                          nd_serv_grp_code.arr,
                                          nd_serv_grp_long_desc.arr,
                                          nd_serv_grp_short_desc.arr);
     no_serv_groups++;
     no_serv_classifications = 0;
     no_blng_servs = 0;
     strcpy(old_serv_grp_code, nd_serv_grp_code.arr);
  }

  if (strcmp(nd_serv_classification_code.arr,old_serv_classification_code))
  {
     no_serv_classifications++;
     no_blng_servs = 0;
     strcpy(old_serv_classification_code, nd_serv_classification_code.arr);
  }

  first_record = 'N';
}
    
print_page_header3()
{
  fprintf(fp, "\f\n\nMDL : BL %-43s %-30s %-31s %-15s\n",
                           " ", hosp_name.arr," ", date_time.arr);
  fprintf(fp, "OPR : %-10s %-20s %s\n",
  user_id.arr," ","CLASSIFICATIONS WITHIN SERVICE GROUP");
  fprintf(fp, "REP : %-8s %-105s PAGE : %4d\n",
                  "BLRSERV3", " ", ++pctr);
  fprintf(fp, "%s%s%s\n",
              "------------------------------------------------------------",
              "------------------------------------------------------------",
              "------------");
fprintf(fp,"\n");
fprintf(fp,"SERVICE GROUP  DESCRIPTION %30.30s", " ");
fprintf(fp,"SHORT DESC       TOTAL CLASSIFICATIONS\n");
fprintf(fp,"\n");
fprintf(fp, "%s%s%s\n",
              "------------------------------------------------------------",
              "------------------------------------------------------------",
              "------------");
fflush(fp);
lctr = 9;
}

/* Report Footer */
print_end3()
{
  if (lctr > 55 - 7) print_page_header3();
  fprintf(fp,"\n\t\tTOTAL NO OF SERVICE GROUPS : %6ld\n",no_serv_groups);
  if (lctr > 55 - 5) print_page_header3();
  fprintf(fp, "\n\n\n %-52s **   END  OF  REPORT   ** \n\n", " ");
  fflush(fp);
  fclose(fp);
}


/** End of Report 3 Routines **/

print_report_title(rep_type)
int rep_type;
{
  fflush(fp);
  fprintf(fp, "\n\nMDL : BL %-43s %-30s %-31s %-15s\n",
                           " ", hosp_name.arr," ", date_time.arr);
  fprintf(fp, "OPR : %-10s %-20s %s\n",
  user_id.arr," ",rep_name[rep_type-1]);
  fprintf(fp, "REP : %-8s %-105s PAGE : %4d\n",
                  rep_file_name[rep_type-1], " ", ++pctr);
  fprintf(fp, "%s%s%s\n",
              "------------------------------------------------------------",
              "------------------------------------------------------------",
              "------------");
  fprintf(fp,"VER : 1.10.01\n");
  fflush(fp);
  
  fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n");
  fprintf(fp,"        ----------------\n\n");


  fprintf(fp,"                REPORT TYPE       : %s\n\n", nd_report_type.arr);
  fprintf(fp,"                FROM BILLING CODE : %s\n\n", nd_fr_blng_code.arr);
  fprintf(fp,"                TO   BILLING CODE : %s\n\n", nd_to_blng_code.arr);
  fprintf(fp,"                PRINT OPTION      : %s\n\n", nd_print_option.arr);

  fflush(fp);
}

close_cursors()
{
   /* EXEC SQL CLOSE BL_BLNG_SERV_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )551;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   /* EXEC SQL CLOSE BL_BLNG_SERV_GRP_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )566;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   /* EXEC SQL CLOSE BL_SERV_CLASSIFICATION_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )581;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   /* EXEC SQL CLOSE BL_BLNG_PRT_GRP_LINE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )596;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   /* EXEC SQL CLOSE SY_DEPT_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )611;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   /* EXEC SQL CLOSE BL_SERVICE_LOCN_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )626;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   /* EXEC SQL CLOSE BL_BILL_TYPE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 30;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )641;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

/*****************************************************************************/
/*                        General Purpose Routines                           */

print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (loc_amount == 0)
      fprintf(fp,"%-14s "," ");
   else if (loc_amount > 0)
   {
      sprintf(out_str,"%11.2f",loc_amount);
      ltrim(out_str);put_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%11.2f",-loc_amount);
      ltrim(out_str);put_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s-",out_str1);
   }
}

print_formated_tot(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (loc_amount == 0)
      fprintf(fp,"            0.00");
   else if (loc_amount > 0)
   {
      sprintf(out_str,"%12.2f",loc_amount);
      ltrim(out_str);put_comma(out_str);
      sprintf(out_str1,"%16s",out_str);
      fprintf(fp,"%-16s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%12.2f",-loc_amount);
      ltrim(out_str);put_comma(out_str);
      sprintf(out_str1,"%17s",out_str);
      fprintf(fp,"%-17s-",out_str1);
   }
}

open_file(file_name)
char *file_name;
{
   char err_stmt[80];

   if ((fp = fopen(file_name,"w")) == NULL)
   {
        sprintf(err_stmt,"Error while opening File %s",file_name);
        err_mesg(err_stmt,0,"");
        proc_exit();
   }
   strcpy(OUTPUT_FILE_NAME,file_name);
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

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 30;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )656;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



  if (sqlca.sqlcode < 0)
  {
      disp_message(ERR_MESG,"Error in connecting to Oracle");
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
      proc_exit();
  }
}

/*   This function now included in err_mesg 
put_comma(str)
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

