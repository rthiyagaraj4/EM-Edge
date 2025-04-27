
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
           char  filnam[38];
};
static const struct sqlcxp sqlfpn =
{
    37,
    "T:\\BL\\CRF-0120\\AR\\WIP\\Proc\\Arrstmt.pc"
};


static unsigned long sqlctx = 1572068683;


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

 static const char *sq0006 = 
"       ') and NVL(:b11,'~~~~~~~~')) and NVL(ANALYSIS_3_CODE,'X') between NVL\
(:b12,'        ') and NVL(:b13,'~~~~~~~~')) order by CUST_CODE            ";

 static const char *sq0007 = 
"VL(:b10,'        ') and NVL(:b11,'~~~~~~~~')) and NVL(ANALYSIS_3_CODE,'X') b\
etween NVL(:b12,'        ') and NVL(:b13,'~~~~~~~~')) order by CUST_ALPHA_CODE\
,CUST_CODE            ";

 static const char *sq0008 = 
" by DOC_DATE,DOC_TYPE_CODE,DOC_NUM            ";

 static const char *sq0009 = 
"select LTRIM(SUBSTR(((RTRIM(TITLE_CODE)||' ')||SHORT_NAME),1,27))  from MP_P\
ATIENT_MAST where PATIENT_ID=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,438,0,4,245,0,0,22,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
108,0,0,2,90,0,2,364,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
131,0,0,3,0,0,30,373,0,0,0,0,0,1,0,
146,0,0,4,241,0,4,388,0,0,9,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,3,0,0,1,9,0,0,
197,0,0,5,135,0,4,410,0,0,5,0,0,1,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,
232,0,0,6,1174,0,9,662,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
303,0,0,7,1200,0,9,668,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
374,0,0,6,0,0,13,703,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,1,0,0,2,9,0,0,
437,0,0,7,0,0,13,721,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,1,0,0,2,9,0,0,
500,0,0,8,1070,0,9,756,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
527,0,0,8,0,0,13,818,0,0,30,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,3,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,3,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
662,0,0,10,278,0,4,913,0,0,5,4,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
697,0,0,9,119,0,9,949,0,0,1,1,0,1,0,1,9,0,0,
716,0,0,9,0,0,13,954,0,0,1,0,0,1,0,2,9,0,0,
735,0,0,11,0,0,27,1191,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
};


/* Date :- 21-MAR-93    */
 
#include <stdio.h>
#include <string.h>
#include <gl.h>                     
                                                 
#define OERROR (sqlca.sqlcode < 0)

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define DEST_NAME "arrstmt.lis"
                  
#define MAX_LINES 23                  

#define LEGEND 1

#define LENGTH_WORDS 65  /* ADDED ON 02/12/1999 */


#define SKIP_1  7
#define SKIP_2  1
#define SKIP_3  9
#define SKIP_4  40
#define SKIP_5  18
#define SKIP_6  08
#define SKIP_7  109
#define SKIP_8  88
#define SKIP_9  1
#define SKIP_10 98
#define SKIP_11 02
#define SKIP_12 34

#define DOUBLE_WIDTH 0x0E
#define EMPHASIZED_START 0x45
#define EMPHASIZED_END 0x46
#define ESC 0x1B

/*
#define DEBUG 0
*/                


/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd      [132],
           hosp_name    [120],
           date_time    [20],
           user_id      [20],
           nd_pgm_date  [35]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;


   /* VARCHAR nd_facility_id                [3],
		   nd_session_id                 [16],
           nd_fm_cust_code               [12],
           nd_to_cust_code               [12],
           nd_fm_alpha_code              [11],
           nd_to_alpha_code              [11],
           nd_stmt_freq_code             [3],
           nd_patient_det                [3],
           nd_zero_bal_flag              [3],
           nd_cutoff_date                [13],
           cut_off_dt_prn                [13],
           nd_rep_order_flg              [3],
   		   nd_fm_cust_type				 [3],
           nd_to_cust_type				 [3],
           nd_fm_cust_group				 [3],
           nd_to_cust_group				 [3],
           nd_fm_anal_cd1				 [9],
           nd_to_anal_cd1				 [9],
           nd_fm_anal_cd2				 [9],
           nd_to_anal_cd2				 [9],
           nd_fm_anal_cd3				 [9],
           nd_to_anal_cd3				 [9],
 		   currency						 [7], /o ADDED ON 02/12/1999 o/
		   subcur						 [7],
           d_cust_cust_code              [9],
           d_cust_long_name_chinese      [101],   /o CRF-0120  o/
           d_cust_short_name_chinese     [101],   /o CRF-0120  o/
           d_cust_add1_desc_chinese      [61],
           d_cust_add2_desc_chinese      [61],
           d_cust_add3_desc_chinese      [61],
           d_cust_zip_desc_chinese       [31],
           d_cust_contact_name           [101],   /o CRF-0120  o/
           d_cust_contact_name_ttl       [61],   /o CRF-0120  o/
           d_tel_num                     [31],
           d_ar_pend_doc_type_code       [7],
           d_ar_pend_doc_num             [9],
           d_ar_pend_doc_date            [12],
           d_ar_pend_bill_num            [9],
           d_ar_pend_bill_doc_type_code  [7],
           d_ar_pend_patient_id          [21],
           d_ar_pend_cust_ref            [16],
           d_ar_mp_patient_name          [31],
		   d_ar_pend_narration           [51],
		   d_misc_cust_long_name         [101],   /o CRF-0120  o/
		   d_misc_cust_short_name        [61],   /o CRF-0120  o/
		   d_misc_cust_add1_desc         [61],
		   d_misc_cust_add2_desc         [61],
		   d_misc_cust_add3_desc         [61],
		   d_misc_cust_zip_desc          [31],
		   d_misc_cust_long_name_chi     [101],   /o CRF-0120  o/
		   d_misc_cust_short_name_chi    [101],   /o CRF-0120  o/
		   d_misc_cust_add1_desc_chi     [61],
		   d_misc_cust_add2_desc_chi     [61],
		   d_misc_cust_add3_desc_chi     [61],
		   d_misc_cust_zip_desc_chi      [31],
           d_misc_cust_contact_name      [101],   /o CRF-0120  o/
           d_misc_cust_contact_name_ttl  [61],   /o CRF-0120  o/
	   	   d_ar_pend_bill_type_code      [3],
           d_misc_tel_num                [31]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_cust_code;

struct { unsigned short len; unsigned char arr[12]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_alpha_code;

struct { unsigned short len; unsigned char arr[11]; } nd_to_alpha_code;

struct { unsigned short len; unsigned char arr[3]; } nd_stmt_freq_code;

struct { unsigned short len; unsigned char arr[3]; } nd_patient_det;

struct { unsigned short len; unsigned char arr[3]; } nd_zero_bal_flag;

struct { unsigned short len; unsigned char arr[13]; } nd_cutoff_date;

struct { unsigned short len; unsigned char arr[13]; } cut_off_dt_prn;

struct { unsigned short len; unsigned char arr[3]; } nd_rep_order_flg;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_cust_type;

struct { unsigned short len; unsigned char arr[3]; } nd_to_cust_type;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_cust_group;

struct { unsigned short len; unsigned char arr[3]; } nd_to_cust_group;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_anal_cd1;

struct { unsigned short len; unsigned char arr[9]; } nd_to_anal_cd1;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_anal_cd2;

struct { unsigned short len; unsigned char arr[9]; } nd_to_anal_cd2;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_anal_cd3;

struct { unsigned short len; unsigned char arr[9]; } nd_to_anal_cd3;

struct { unsigned short len; unsigned char arr[7]; } currency;

struct { unsigned short len; unsigned char arr[7]; } subcur;

struct { unsigned short len; unsigned char arr[9]; } d_cust_cust_code;

struct { unsigned short len; unsigned char arr[101]; } d_cust_long_name_chinese;

struct { unsigned short len; unsigned char arr[101]; } d_cust_short_name_chinese;

struct { unsigned short len; unsigned char arr[61]; } d_cust_add1_desc_chinese;

struct { unsigned short len; unsigned char arr[61]; } d_cust_add2_desc_chinese;

struct { unsigned short len; unsigned char arr[61]; } d_cust_add3_desc_chinese;

struct { unsigned short len; unsigned char arr[31]; } d_cust_zip_desc_chinese;

struct { unsigned short len; unsigned char arr[101]; } d_cust_contact_name;

struct { unsigned short len; unsigned char arr[61]; } d_cust_contact_name_ttl;

struct { unsigned short len; unsigned char arr[31]; } d_tel_num;

struct { unsigned short len; unsigned char arr[7]; } d_ar_pend_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_ar_pend_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_ar_pend_doc_date;

struct { unsigned short len; unsigned char arr[9]; } d_ar_pend_bill_num;

struct { unsigned short len; unsigned char arr[7]; } d_ar_pend_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[21]; } d_ar_pend_patient_id;

struct { unsigned short len; unsigned char arr[16]; } d_ar_pend_cust_ref;

struct { unsigned short len; unsigned char arr[31]; } d_ar_mp_patient_name;

struct { unsigned short len; unsigned char arr[51]; } d_ar_pend_narration;

struct { unsigned short len; unsigned char arr[101]; } d_misc_cust_long_name;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_short_name;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_add1_desc;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_add2_desc;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_add3_desc;

struct { unsigned short len; unsigned char arr[31]; } d_misc_cust_zip_desc;

struct { unsigned short len; unsigned char arr[101]; } d_misc_cust_long_name_chi;

struct { unsigned short len; unsigned char arr[101]; } d_misc_cust_short_name_chi;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_add1_desc_chi;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_add2_desc_chi;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_add3_desc_chi;

struct { unsigned short len; unsigned char arr[31]; } d_misc_cust_zip_desc_chi;

struct { unsigned short len; unsigned char arr[101]; } d_misc_cust_contact_name;

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_contact_name_ttl;

struct { unsigned short len; unsigned char arr[3]; } d_ar_pend_bill_type_code;

struct { unsigned short len; unsigned char arr[31]; } d_misc_tel_num;


   /* VARCHAR p_language_id				 [4]; */ 
struct { unsigned short len; unsigned char arr[4]; } p_language_id;

           
char       d_misc_customer_flag,
	   	   d_chinese_reporting_flag,
   		   amt_in_words	 [10][133]; /* ADDED ON 02/12/1999 */

double     d_ar_pend_pending_amt,
           d_ar_pend_payable_amt,
           d_ar_pend_alloc_amt,
           d_ar_pend_negative_amt,

           tot_payable_amt,
           tot_alloc_amt,
           tot_pending_amt,
		   tot_pending_amt1,
           nd_open_credit,

           amt_slot1,
           amt_slot2,
           amt_slot3,
           amt_slot4,
           amt_slot5;

int d_ar_pend_sign_amt,
    nd_age_slot1,
    nd_age_slot2,
    nd_age_slot3,
    nd_age_slot4,
    nd_age_slot5,
	no_of_decimal;
    
long  age_days;    

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





#include "winproc.h"

FILE *fp;
int lctr = 0,pctr =0;
int cust_lctr = 0, cust_pctr = 0;

int open_print_flag = 0;
char filename[150];

void proc_main(argc,argv)
char *argv[];
int argc;
{
	strcpy(filename,WORKING_DIR);
	strcpy(OUTPUT_FILE_NAME,argv[5]);
	strcat(filename,OUTPUT_FILE_NAME);

	//strcat(filename,DEST_NAME);

   if (argc != 6)
   {
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"ARRSTMT");  
   

   if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle");
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd");
      proc_exit();
   }

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);
   strcpy(g_facility_id,argv[4]);

   set_meduser_role();
   strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   nd_fm_cust_code.arr[0]        = '\0';
   nd_to_cust_code.arr[0]        = '\0';
   nd_fm_alpha_code.arr[0]       = '\0';
   nd_to_alpha_code.arr[0]       = '\0';
   nd_stmt_freq_code.arr[0]      = '\0';
   nd_patient_det.arr[0]         = '\0';
   nd_zero_bal_flag.arr[0]       = '\0';
   nd_cutoff_date.arr[0]         = '\0';
   nd_rep_order_flg.arr[0]       = '\0';

   nd_fm_cust_type.arr[0]        = '\0';
   nd_to_cust_type.arr[0]        = '\0';
   nd_fm_cust_group.arr[0]       = '\0';
   nd_to_cust_group.arr[0]       = '\0';
   nd_fm_anal_cd1.arr[0]         = '\0';
   nd_to_anal_cd1.arr[0]         = '\0';
   nd_fm_anal_cd2.arr[0]         = '\0';
   nd_to_anal_cd2.arr[0]         = '\0';
   nd_fm_anal_cd3.arr[0]         = '\0';
   nd_to_anal_cd3.arr[0]         = '\0';

   nd_fm_cust_type.len           = 0;
   nd_to_cust_type.len           = 0;
   nd_fm_cust_group.len          = 0;
   nd_to_cust_group.len          = 0;
   nd_fm_anal_cd1.len            = 0;
   nd_to_anal_cd1.len            = 0;
   nd_fm_anal_cd2.len            = 0;
   nd_to_anal_cd2.len            = 0;
   nd_fm_anal_cd3.len            = 0;
   nd_to_anal_cd3.len            = 0;
   nd_fm_cust_code.len           = 0;
   nd_to_cust_code.len           = 0;
   nd_fm_alpha_code.len          = 0;
   nd_to_alpha_code.len          = 0;
   nd_stmt_freq_code.len         = 0;
   nd_patient_det.len            = 0;
   nd_zero_bal_flag.len          = 0;
   nd_cutoff_date.len            = 0;
   nd_rep_order_flg.len          = 0;

   /* EXEC SQL SELECT operating_facility_id,
				   NVL(PARAM1,'!!!!!!!!'),NVL(PARAM2,'~~~~~~~~'),
                   NVL(PARAM3,'!!!!!!!!!!'),NVL(PARAM4,'~~~~~~~~~~'),
                   PARAM5,PARAM6,PARAM7,PARAM8,
                   PARAM9,
   				   PARAM11,
                   PARAM12,
                   PARAM13,
                   PARAM14,
                   PARAM15,
                   PARAM16,
                   PARAM17,
                   PARAM18,
                   PARAM19,
				   PARAM20

              INTO :nd_facility_id,
				   :nd_fm_cust_code,
                   :nd_to_cust_code,
                   :nd_fm_alpha_code,
                   :nd_to_alpha_code,
                   :nd_stmt_freq_code,
                   :nd_zero_bal_flag,
                   :nd_patient_det,
                   :nd_cutoff_date,
                   :nd_rep_order_flg,
                   :nd_fm_cust_type,
				   :nd_to_cust_type,
                   :nd_fm_cust_group,
                   :nd_to_cust_group,
                   :nd_fm_anal_cd1,
                   :nd_to_anal_cd1,
                   :nd_fm_anal_cd2,
                   :nd_to_anal_cd2,
                   :nd_fm_anal_cd3,
                   :nd_to_anal_cd3

              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARRSTMT'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,NVL(PARAM1,'!!!!!!!!') ,NVL(\
PARAM2,'~~~~~~~~') ,NVL(PARAM3,'!!!!!!!!!!') ,NVL(PARAM4,'~~~~~~~~~~') ,PARAM5\
 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 ,PARAM15 \
,PARAM16 ,PARAM17 ,PARAM18 ,PARAM19 ,PARAM20 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,\
:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19  from SY_PROG_PA\
RAM where ((PGM_ID='ARRSTMT' and SESSION_ID=:b20) and PGM_DATE=:b21)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_cust_code;
   sqlstm.sqhstl[1] = (unsigned int  )14;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_alpha_code;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_alpha_code;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_stmt_freq_code;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_zero_bal_flag;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_patient_det;
   sqlstm.sqhstl[7] = (unsigned int  )5;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_cutoff_date;
   sqlstm.sqhstl[8] = (unsigned int  )15;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_rep_order_flg;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_fm_cust_type;
   sqlstm.sqhstl[10] = (unsigned int  )5;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_to_cust_type;
   sqlstm.sqhstl[11] = (unsigned int  )5;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_fm_cust_group;
   sqlstm.sqhstl[12] = (unsigned int  )5;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_to_cust_group;
   sqlstm.sqhstl[13] = (unsigned int  )5;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_fm_anal_cd1;
   sqlstm.sqhstl[14] = (unsigned int  )11;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_to_anal_cd1;
   sqlstm.sqhstl[15] = (unsigned int  )11;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_fm_anal_cd2;
   sqlstm.sqhstl[16] = (unsigned int  )11;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_to_anal_cd2;
   sqlstm.sqhstl[17] = (unsigned int  )11;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_fm_anal_cd3;
   sqlstm.sqhstl[18] = (unsigned int  )11;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_to_anal_cd3;
   sqlstm.sqhstl[19] = (unsigned int  )11;
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

   nd_fm_cust_code.arr[nd_fm_cust_code.len]        = '\0';
   nd_to_cust_code.arr[nd_to_cust_code.len]        = '\0';
   nd_fm_alpha_code.arr[nd_fm_alpha_code.len]      = '\0';
   nd_to_alpha_code.arr[nd_to_alpha_code.len]      = '\0';
   nd_stmt_freq_code.arr[nd_stmt_freq_code.len]    = '\0';
   nd_patient_det.arr[nd_patient_det.len]          = '\0';
   nd_zero_bal_flag.arr[nd_zero_bal_flag.len]      = '\0';
   nd_cutoff_date.arr[nd_cutoff_date.len]          = '\0';
   nd_rep_order_flg.arr[nd_rep_order_flg.len]      = '\0';
   nd_fm_cust_type.arr[nd_fm_cust_type.len]        = '\0';
   nd_to_cust_type.arr[nd_to_cust_type.len]        = '\0';
   nd_fm_cust_group.arr[nd_fm_cust_group.len]      = '\0';
   nd_to_cust_group.arr[nd_to_cust_group.len]      = '\0';
   nd_fm_anal_cd1.arr[nd_fm_anal_cd1.len]          = '\0';
   nd_to_anal_cd1.arr[nd_to_anal_cd1.len]          = '\0';
   nd_fm_anal_cd2.arr[nd_fm_anal_cd2.len]          = '\0';
   nd_to_anal_cd2.arr[nd_to_anal_cd2.len]          = '\0';
   nd_fm_anal_cd3.arr[nd_fm_anal_cd3.len]          = '\0';
   nd_to_anal_cd3.arr[nd_to_anal_cd3.len]          = '\0';


   start_prog_msg();

   fetch_detls();

   open_files();
   
   declare_cursors();

   while(fetch_customer())
   {
        cust_lctr = cust_pctr = 0;

        open_pending_doc();

       if(d_misc_customer_flag == 'Y') {

            while(fetch_pending_doc())
            {
		if(equal(d_ar_pend_pending_amt,(double)0) &&
		   nd_zero_bal_flag.arr[0] EQ 'N')
		   continue;
                cust_lctr = cust_pctr = 0;
                print_page_head();
                fetch_patient_name();
                process_ageing();
                print_details();
                print_footer();
            }

       }
       else {

            while(fetch_pending_doc())
            {
		if(equal(d_ar_pend_pending_amt,(double)0) &&
		   nd_zero_bal_flag.arr[0] EQ 'N')
		   continue;

                if (cust_pctr == 0)
                    print_page_head();
                fetch_patient_name();
                process_ageing();
                print_details();
            }
            if (cust_pctr != 0)
                print_footer();
	}
    
   }

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
                  WHERE PGM_ID     = 'ARRSTMT'
                    AND SESSION_ID = :nd_session_id
                    AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARRSTMT' and S\
ESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )108;
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

   fclose(fp);
   end_prog_msg();
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )131;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_detls()
{
   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   user_id.arr[0]        = '\0';
   cut_off_dt_prn.arr[0] = '\0';

   hosp_name.len      = 0;
   date_time.len      = 0;
   user_id.len        = 0;
   cut_off_dt_prn.len = 0;

   /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY'),
                   USER,
                   TO_CHAR(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'),'DD/MM/YYYY'),
   				   BASE_CURRENCY,BASE_CURRENCY_DEC,    /o ADDED ON 02/12/1999 o/
				   nvl(no_of_decimal,2)
              INTO :hosp_name, :date_time, :user_id,
                   :cut_off_dt_prn,:currency,:subcur,:no_of_decimal
              FROM SY_ACC_ENTITY
			 WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,USE\
R ,TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'DD/MM/YYYY') ,BASE_CURRENCY ,BASE_CURREN\
CY_DEC ,nvl(no_of_decimal,2) into :b1,:b2,:b3,:b4,:b5,:b6,:b7  from SY_ACC_ENT\
ITY where ACC_ENTITY_ID=:b8";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )146;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_cutoff_date;
   sqlstm.sqhstl[0] = (unsigned int  )15;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&hosp_name;
   sqlstm.sqhstl[1] = (unsigned int  )122;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&date_time;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&user_id;
   sqlstm.sqhstl[3] = (unsigned int  )22;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&cut_off_dt_prn;
   sqlstm.sqhstl[4] = (unsigned int  )15;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&currency;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&subcur;
   sqlstm.sqhstl[6] = (unsigned int  )9;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&no_of_decimal;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[8] = (unsigned int  )5;
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
         err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   user_id.arr[user_id.len]               = '\0';
   cut_off_dt_prn.arr[cut_off_dt_prn.len] = '\0';

   currency.arr[currency.len]			  = '\0'; /* ADDED ON 02/12/1999 */
   subcur.arr[subcur.len]				  = '\0';


   /* EXEC SQL SELECT DAYS_AGE_SLOT_1, DAYS_AGE_SLOT_2,
                   DAYS_AGE_SLOT_3, DAYS_AGE_SLOT_4,
                   DAYS_AGE_SLOT_5
              INTO :nd_age_slot1, :nd_age_slot2,
                   :nd_age_slot3, :nd_age_slot4,
                   :nd_age_slot5
              FROM AR_PARAMETER; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DAYS_AGE_SLOT_1 ,DAYS_AGE_SLOT_2 ,DAYS_AGE_SLOT_3 ,\
DAYS_AGE_SLOT_4 ,DAYS_AGE_SLOT_5 into :b0,:b1,:b2,:b3,:b4  from AR_PARAMETER ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )197;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_age_slot1;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_age_slot2;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_age_slot3;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_age_slot4;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_age_slot5;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
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
         err_mesg("SELECT failed on table AR_PARAMETER",0,"");
 
   if (NOT_FOUND)
         err_mesg("Record not found in AR_PARAMETER",0,"");
}

open_files()
{
   char		text_msg[101];
   if ((fp = fopen(filename,"w")) == NULL)
   {
        sprintf(text_msg,"Error While Opening File %s",filename);
		err_mesg(text_msg,0,"");
		err_mesg("\nError while opening File arrstmt.lis\n",0,"");
        exit(0);
   }

}

print_page_head()
{ 
int i=0;
static int g_first = 1;
   pctr++;

   cust_lctr = 0;
   cust_pctr++;

   if (cust_pctr > 1)
      print_balance1(); 

   if(!g_first)
       fprintf(fp,"\f");

   g_first=0; 

   fprintf(fp,"%c",0x12); /**** Set Printer to Normal Mode ****/

   for (i=0;i<SKIP_1;i++) fprintf(fp,"\n");

   if (LEGEND)
   {
      for (i=0;i<SKIP_12;i++) fprintf(fp," ");
      fprintf(fp,"%c%cS T A T E M E N T\n",ESC,EMPHASIZED_START);
      for (i=0;i<SKIP_12;i++) fprintf(fp," ");
      fprintf(fp,"-----------------\n");
      for (i=0;i<SKIP_12;i++) fprintf(fp," ");
      fprintf(fp,"AS AT ");
   }
   else
   {
      fprintf(fp,"\n");
      fprintf(fp,"\n");
      for (i=0;i<SKIP_12;i++) fprintf(fp," ");
      fprintf(fp,"      ");
   }

   fprintf(fp,"%s%c%c\n",cut_off_dt_prn.arr,ESC,EMPHASIZED_END);

   for (i=0;i<SKIP_2;i++) fprintf(fp,"\n");
   
   for (i=0;i<SKIP_3;i++) fprintf(fp," ");
   fprintf(fp,"%-8s",d_cust_cust_code.arr);
   for (i=0;i<SKIP_4;i++) fprintf(fp," ");
   if (LEGEND)
      fprintf(fp,"DATE : ");
   else
      fprintf(fp,"       ");
   fprintf(fp,"%s\n",date_time.arr);
   for (i=0;i<SKIP_3;i++) fprintf(fp," ");
   fprintf(fp,"%-40.40s\n",d_cust_long_name_chinese.arr);

   for (i=0;i<SKIP_3;i++) fprintf(fp," ");
   fprintf(fp,"%-30.30s",d_cust_add1_desc_chinese.arr);

   for (i=0;i<SKIP_5;i++) fprintf(fp," ");
   if (LEGEND)
      fprintf(fp,"PAGE : ");
   else
      fprintf(fp,"       ");
   fprintf(fp,"%2d\n",cust_pctr);

   for (i=0;i<SKIP_3;i++) fprintf(fp," ");
   fprintf(fp,"%-30.30s\n",d_cust_add2_desc_chinese.arr);

   for (i=0;i<SKIP_3;i++) fprintf(fp," ");
   fprintf(fp,"%-30.30s\n",d_cust_add3_desc_chinese.arr);

   for (i=0;i<SKIP_3;i++) fprintf(fp," ");
   fprintf(fp,"%-30.30s\n",d_cust_zip_desc_chinese.arr);

   for (i=0;i<4;i++) fprintf(fp,"\n");
   for (i=0;i<SKIP_3;i++) fprintf(fp," ");

   if (LEGEND)
      fprintf(fp,"Tel  : ");
   else
      fprintf(fp,"       ");
   fprintf(fp,"%s \n", d_tel_num.arr);
      
   for (i=0;i<SKIP_3;i++) fprintf(fp," ");
   if (LEGEND)
      fprintf(fp,"ATTN : ");
   else
      fprintf(fp,"       ");
   fprintf(fp,"%s, %s \n", 
              d_cust_contact_name.arr,
              d_cust_contact_name_ttl.arr);
   for (i=0;i<3;i++) fprintf(fp,"\n");
   fflush(fp);
   fprintf(fp,"%c",0x0F); /*** set printer to compressed mode ***/
   if (LEGEND)
   {
fprintf(fp,"-------------------------------------------------------------------------------------------------------------------------------------------\n");

fprintf(fp,"DOC DATE   DOC         DOC     BILL DOC.   PATIENT    NAME OF PATIENT            D.VOUCHER           DEBIT AMT     ALLOC AMT    O/S AMOUNT\n");
fprintf(fp,"           TYPE        NO.      NO. TYPE   NO.                                                                                 (%s)\n",currency.arr);

fprintf(fp,"-------------------------------------------------------------------------------------------------------------------------------------------\n");
   }
     if (cust_pctr > 1)
     { 
        print_balance2();
     }
}


declare_cursors()
{
    /* EXEC SQL DECLARE AR_CUSTOMER_CUR1 CURSOR FOR
        SELECT CUST_CODE,
               NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',LONG_NAME_CHINESE,LONG_NAME),' '),
               NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',SHORT_NAME_CHINESE,SHORT_NAME),' '),
               NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ADD1_DESC_CHINESE,ADD1_DESC),' '),
               NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ADD2_DESC_CHINESE,ADD2_DESC),' '),
               NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ADD3_DESC_CHINESE,ADD3_DESC),' '),
               NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ZIP_DESC_CHINESE,ZIP_DESC),' '),
               NVL(CONTACT_NAME,' '),
               NVL(CONTACT_NAME_TITLE,' '),
	       NVL(MISC_CUSTOMER_FLAG,' '),
	       NVL(CHINESE_REPORTING_FLAG,' '),
	       TEL_NUM
          FROM AR_CUSTOMER
         WHERE STMT_FREQ_CODE = NVL(:nd_stmt_freq_code,'W')
           AND CUST_CODE BETWEEN 
                    NVL(:nd_fm_cust_code,'        ')
                AND NVL(:nd_to_cust_code,'~~~~~~~~')
            AND NVL(PAT_COM_FLAG,'X') = DECODE(:nd_patient_det,'Y','Y',
                                          NVL(PAT_COM_FLAG,'X'))
			AND CUST_TYPE_CODE BETWEEN NVL(:nd_fm_cust_type,'  ')
                AND NVL(:nd_to_cust_type,'~~')
           AND CUST_GROUP_CODE BETWEEN NVL(:nd_fm_cust_group,'  ')
                AND NVL(:nd_to_cust_group,'~~')
           AND NVL(ANALYSIS_1_CODE,'X')
               BETWEEN NVL(:nd_fm_anal_cd1,'        ')
                 AND NVL(:nd_to_anal_cd1,'~~~~~~~~')
           AND NVL(ANALYSIS_2_CODE,'X')
               BETWEEN NVL(:nd_fm_anal_cd2,'        ')
                 AND NVL(:nd_to_anal_cd2,'~~~~~~~~')
           AND NVL(ANALYSIS_3_CODE,'X')
               BETWEEN NVL(:nd_fm_anal_cd3,'        ')
                 AND NVL(:nd_to_anal_cd3,'~~~~~~~~')
			   ORDER BY CUST_CODE; */ 


      /* EXEC SQL DECLARE AR_CUSTOMER_CUR2 CURSOR FOR
        SELECT CUST_CODE,
               NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',LONG_NAME_CHINESE,LONG_NAME),' '),
               NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',SHORT_NAME_CHINESE,SHORT_NAME),' '),
               NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ADD1_DESC_CHINESE,ADD1_DESC),' '),
               NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ADD2_DESC_CHINESE,ADD2_DESC),' '),
               NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ADD3_DESC_CHINESE,ADD3_DESC),' '),
               NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ZIP_DESC_CHINESE,ZIP_DESC),' '),
               NVL(CONTACT_NAME,' '),
               NVL(CONTACT_NAME_TITLE,' '),
	       NVL(MISC_CUSTOMER_FLAG,' '),
	       NVL(CHINESE_REPORTING_FLAG,' '),
	       TEL_NUM
          FROM AR_CUSTOMER
         WHERE STMT_FREQ_CODE = NVL(:nd_stmt_freq_code,'W')
           AND CUST_ALPHA_CODE BETWEEN 
                    NVL(:nd_fm_alpha_code,'          ')
                AND NVL(:nd_to_alpha_code,'~~~~~~~~~~')
            AND NVL(PAT_COM_FLAG,'X') = DECODE(:nd_patient_det,'Y','Y',
                                          NVL(PAT_COM_FLAG,'X'))
			AND CUST_TYPE_CODE BETWEEN NVL(:nd_fm_cust_type,'  ')
                AND NVL(:nd_to_cust_type,'~~')
           AND CUST_GROUP_CODE BETWEEN NVL(:nd_fm_cust_group,'  ')
                AND NVL(:nd_to_cust_group,'~~')
           AND NVL(ANALYSIS_1_CODE,'X')  
               BETWEEN NVL(:nd_fm_anal_cd1,'        ')
                 AND NVL(:nd_to_anal_cd1,'~~~~~~~~')
           AND NVL(ANALYSIS_2_CODE,'X')
               BETWEEN NVL(:nd_fm_anal_cd2,'        ')
                 AND NVL(:nd_to_anal_cd2,'~~~~~~~~')
           AND NVL(ANALYSIS_3_CODE,'X')
               BETWEEN NVL(:nd_fm_anal_cd3,'        ')
                 AND NVL(:nd_to_anal_cd3,'~~~~~~~~')
          ORDER BY CUST_ALPHA_CODE,CUST_CODE; */ 

      
    /* EXEC SQL DECLARE AR_PENDING_DOC_CUR CURSOR FOR
              SELECT DOC_TYPE_CODE,
                     DOC_NUM,
                     TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                     NVL(BILL_NUM,0),
                     NVL(BILL_DOC_TYPE_CODE,' '),
                     NVL(PATIENT_ID,' '),
                     NVL(CUST_REF,' '),
                     NVL(CEIL(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY') - NVL(BASE_DATE,DOC_DATE)),0),
                     NVL(PENDING_AMT,0), NVL(PAYABLE_AMT,0),
                     NVL(PENDING_AMT,0) - NVL(PAYABLE_AMT,0),
                     SIGN(PENDING_AMT),
                     DECODE(SIGN(NVL(PENDING_AMT,0)),-1,-NVL(PENDING_AMT,0),
                     NVL(PENDING_AMT,0)),
					 NVL(MISC_CUST_LONG_NAME,' '),
					 NVL(MISC_CUST_SHORT_NAME,' '),
					 NVL(MISC_CUST_ADD1_DESC,' '),
					 NVL(MISC_CUST_ADD2_DESC,' '),
					 NVL(MISC_CUST_ADD3_DESC,' '),
					 NVL(MISC_CUST_ZIP_DESC,' '),
					 NVL(MISC_CUST_LONG_NAME_CHINESE,' '),
					 NVL(MISC_CUST_SHORT_NAME_CHINESE,' '),
					 NVL(MISC_CUST_ADD1_DESC_CHINESE,' '),
					 NVL(MISC_CUST_ADD2_DESC_CHINESE,' '),
					 NVL(MISC_CUST_ADD3_DESC_CHINESE,' '),
					 NVL(MISC_CUST_ZIP_DESC_CHINESE,' '),
					 NVL(CONTACT_NAME,' '),
					 NVL(CONTACT_NAME_TITLE,' '),
					 NVL(BILL_TYPE_CODE,' '),
					 NVL(SUBSTR(NARRATION,1,26),' '),
					 TEL_NUM
	            FROM AR_PENDING_DOC
	           WHERE CUST_CODE = :d_cust_cust_code
                 AND NVL(DOC_DATE,BASE_DATE) <= to_date(:nd_cutoff_date,'DD/MM/YYYY')
               ORDER BY DOC_DATE,DOC_TYPE_CODE,DOC_NUM; */ 


    /* EXEC SQL DECLARE AR_PATIENT_CUR CURSOR FOR
              SELECT LTRIM(SUBSTR(RTRIM(TITLE_CODE)||' '||SHORT_NAME,1,27))
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :d_ar_pend_patient_id; */ 

     

    if (nd_rep_order_flg.arr[0] == 'C')
    {
         /* EXEC SQL OPEN AR_CUSTOMER_CUR1; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 22;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlbuft((void **)0, 
           "select CUST_CODE ,NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',LONG_NAM\
E_CHINESE,LONG_NAME),' ') ,NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',SHORT_NAME_\
CHINESE,SHORT_NAME),' ') ,NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ADD1_DESC_CH\
INESE,ADD1_DESC),' ') ,NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ADD2_DESC_CHINE\
SE,ADD2_DESC),' ') ,NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ADD3_DESC_CHINESE,\
ADD3_DESC),' ') ,NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ZIP_DESC_CHINESE,ZIP_\
DESC),' ') ,NVL(CONTACT_NAME,' ') ,NVL(CONTACT_NAME_TITLE,' ') ,NVL(MISC_CUS\
TOMER_FLAG,' ') ,NVL(CHINESE_REPORTING_FLAG,' ') ,TEL_NUM  from AR_CUSTOMER \
where (((((((STMT_FREQ_CODE=NVL(:b0,'W') and CUST_CODE between NVL(:b1,'    \
    ') and NVL(:b2,'~~~~~~~~')) and NVL(PAT_COM_FLAG,'X')=DECODE(:b3,'Y','Y'\
,NVL(PAT_COM_FLAG,'X'))) and CUST_TYPE_CODE between NVL(:b4,'  ') and NVL(:b\
5,'~~')) and CUST_GROUP_CODE between NVL(:b6,'  ') and NVL(:b7,'~~')) and NV\
L(ANALYSIS_1_CODE,'X') between NVL(:b8,'        ') and NVL(:b9,'~~~~~~~~')) \
and NVL(ANALYSIS_2_CODE,'X') between NVL(:b10,' ");
         sqlstm.stmt = sq0006;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )232;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&nd_stmt_freq_code;
         sqlstm.sqhstl[0] = (unsigned int  )5;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&nd_fm_cust_code;
         sqlstm.sqhstl[1] = (unsigned int  )14;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&nd_to_cust_code;
         sqlstm.sqhstl[2] = (unsigned int  )14;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&nd_patient_det;
         sqlstm.sqhstl[3] = (unsigned int  )5;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&nd_fm_cust_type;
         sqlstm.sqhstl[4] = (unsigned int  )5;
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&nd_to_cust_type;
         sqlstm.sqhstl[5] = (unsigned int  )5;
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&nd_fm_cust_group;
         sqlstm.sqhstl[6] = (unsigned int  )5;
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&nd_to_cust_group;
         sqlstm.sqhstl[7] = (unsigned int  )5;
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&nd_fm_anal_cd1;
         sqlstm.sqhstl[8] = (unsigned int  )11;
         sqlstm.sqhsts[8] = (         int  )0;
         sqlstm.sqindv[8] = (         void  *)0;
         sqlstm.sqinds[8] = (         int  )0;
         sqlstm.sqharm[8] = (unsigned int  )0;
         sqlstm.sqadto[8] = (unsigned short )0;
         sqlstm.sqtdso[8] = (unsigned short )0;
         sqlstm.sqhstv[9] = (         void  *)&nd_to_anal_cd1;
         sqlstm.sqhstl[9] = (unsigned int  )11;
         sqlstm.sqhsts[9] = (         int  )0;
         sqlstm.sqindv[9] = (         void  *)0;
         sqlstm.sqinds[9] = (         int  )0;
         sqlstm.sqharm[9] = (unsigned int  )0;
         sqlstm.sqadto[9] = (unsigned short )0;
         sqlstm.sqtdso[9] = (unsigned short )0;
         sqlstm.sqhstv[10] = (         void  *)&nd_fm_anal_cd2;
         sqlstm.sqhstl[10] = (unsigned int  )11;
         sqlstm.sqhsts[10] = (         int  )0;
         sqlstm.sqindv[10] = (         void  *)0;
         sqlstm.sqinds[10] = (         int  )0;
         sqlstm.sqharm[10] = (unsigned int  )0;
         sqlstm.sqadto[10] = (unsigned short )0;
         sqlstm.sqtdso[10] = (unsigned short )0;
         sqlstm.sqhstv[11] = (         void  *)&nd_to_anal_cd2;
         sqlstm.sqhstl[11] = (unsigned int  )11;
         sqlstm.sqhsts[11] = (         int  )0;
         sqlstm.sqindv[11] = (         void  *)0;
         sqlstm.sqinds[11] = (         int  )0;
         sqlstm.sqharm[11] = (unsigned int  )0;
         sqlstm.sqadto[11] = (unsigned short )0;
         sqlstm.sqtdso[11] = (unsigned short )0;
         sqlstm.sqhstv[12] = (         void  *)&nd_fm_anal_cd3;
         sqlstm.sqhstl[12] = (unsigned int  )11;
         sqlstm.sqhsts[12] = (         int  )0;
         sqlstm.sqindv[12] = (         void  *)0;
         sqlstm.sqinds[12] = (         int  )0;
         sqlstm.sqharm[12] = (unsigned int  )0;
         sqlstm.sqadto[12] = (unsigned short )0;
         sqlstm.sqtdso[12] = (unsigned short )0;
         sqlstm.sqhstv[13] = (         void  *)&nd_to_anal_cd3;
         sqlstm.sqhstl[13] = (unsigned int  )11;
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
            err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR1",0,"");
    }
    else
    {
         /* EXEC SQL OPEN AR_CUSTOMER_CUR2; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 22;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlbuft((void **)0, 
           "select CUST_CODE ,NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',LONG_NAM\
E_CHINESE,LONG_NAME),' ') ,NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',SHORT_NAME_\
CHINESE,SHORT_NAME),' ') ,NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ADD1_DESC_CH\
INESE,ADD1_DESC),' ') ,NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ADD2_DESC_CHINE\
SE,ADD2_DESC),' ') ,NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ADD3_DESC_CHINESE,\
ADD3_DESC),' ') ,NVL(DECODE(CHINESE_REPORTING_FLAG,'Y',ZIP_DESC_CHINESE,ZIP_\
DESC),' ') ,NVL(CONTACT_NAME,' ') ,NVL(CONTACT_NAME_TITLE,' ') ,NVL(MISC_CUS\
TOMER_FLAG,' ') ,NVL(CHINESE_REPORTING_FLAG,' ') ,TEL_NUM  from AR_CUSTOMER \
where (((((((STMT_FREQ_CODE=NVL(:b0,'W') and CUST_ALPHA_CODE between NVL(:b1\
,'          ') and NVL(:b2,'~~~~~~~~~~')) and NVL(PAT_COM_FLAG,'X')=DECODE(:\
b3,'Y','Y',NVL(PAT_COM_FLAG,'X'))) and CUST_TYPE_CODE between NVL(:b4,'  ') \
and NVL(:b5,'~~')) and CUST_GROUP_CODE between NVL(:b6,'  ') and NVL(:b7,'~~\
')) and NVL(ANALYSIS_1_CODE,'X') between NVL(:b8,'        ') and NVL(:b9,'~~\
~~~~~~')) and NVL(ANALYSIS_2_CODE,'X') between N");
         sqlstm.stmt = sq0007;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )303;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&nd_stmt_freq_code;
         sqlstm.sqhstl[0] = (unsigned int  )5;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&nd_fm_alpha_code;
         sqlstm.sqhstl[1] = (unsigned int  )13;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&nd_to_alpha_code;
         sqlstm.sqhstl[2] = (unsigned int  )13;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&nd_patient_det;
         sqlstm.sqhstl[3] = (unsigned int  )5;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&nd_fm_cust_type;
         sqlstm.sqhstl[4] = (unsigned int  )5;
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&nd_to_cust_type;
         sqlstm.sqhstl[5] = (unsigned int  )5;
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&nd_fm_cust_group;
         sqlstm.sqhstl[6] = (unsigned int  )5;
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&nd_to_cust_group;
         sqlstm.sqhstl[7] = (unsigned int  )5;
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&nd_fm_anal_cd1;
         sqlstm.sqhstl[8] = (unsigned int  )11;
         sqlstm.sqhsts[8] = (         int  )0;
         sqlstm.sqindv[8] = (         void  *)0;
         sqlstm.sqinds[8] = (         int  )0;
         sqlstm.sqharm[8] = (unsigned int  )0;
         sqlstm.sqadto[8] = (unsigned short )0;
         sqlstm.sqtdso[8] = (unsigned short )0;
         sqlstm.sqhstv[9] = (         void  *)&nd_to_anal_cd1;
         sqlstm.sqhstl[9] = (unsigned int  )11;
         sqlstm.sqhsts[9] = (         int  )0;
         sqlstm.sqindv[9] = (         void  *)0;
         sqlstm.sqinds[9] = (         int  )0;
         sqlstm.sqharm[9] = (unsigned int  )0;
         sqlstm.sqadto[9] = (unsigned short )0;
         sqlstm.sqtdso[9] = (unsigned short )0;
         sqlstm.sqhstv[10] = (         void  *)&nd_fm_anal_cd2;
         sqlstm.sqhstl[10] = (unsigned int  )11;
         sqlstm.sqhsts[10] = (         int  )0;
         sqlstm.sqindv[10] = (         void  *)0;
         sqlstm.sqinds[10] = (         int  )0;
         sqlstm.sqharm[10] = (unsigned int  )0;
         sqlstm.sqadto[10] = (unsigned short )0;
         sqlstm.sqtdso[10] = (unsigned short )0;
         sqlstm.sqhstv[11] = (         void  *)&nd_to_anal_cd2;
         sqlstm.sqhstl[11] = (unsigned int  )11;
         sqlstm.sqhsts[11] = (         int  )0;
         sqlstm.sqindv[11] = (         void  *)0;
         sqlstm.sqinds[11] = (         int  )0;
         sqlstm.sqharm[11] = (unsigned int  )0;
         sqlstm.sqadto[11] = (unsigned short )0;
         sqlstm.sqtdso[11] = (unsigned short )0;
         sqlstm.sqhstv[12] = (         void  *)&nd_fm_anal_cd3;
         sqlstm.sqhstl[12] = (unsigned int  )11;
         sqlstm.sqhsts[12] = (         int  )0;
         sqlstm.sqindv[12] = (         void  *)0;
         sqlstm.sqinds[12] = (         int  )0;
         sqlstm.sqharm[12] = (unsigned int  )0;
         sqlstm.sqadto[12] = (unsigned short )0;
         sqlstm.sqtdso[12] = (unsigned short )0;
         sqlstm.sqhstv[13] = (         void  *)&nd_to_anal_cd3;
         sqlstm.sqhstl[13] = (unsigned int  )11;
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
            err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR2",0,"");
     }

}

fetch_customer()
{

d_cust_cust_code.arr[0]                = '\0';
d_cust_long_name_chinese.arr[0]        = '\0';
d_cust_short_name_chinese.arr[0]       = '\0';
d_cust_add1_desc_chinese.arr[0]        = '\0';
d_cust_add2_desc_chinese.arr[0]        = '\0';
d_cust_add3_desc_chinese.arr[0]        = '\0';
d_cust_zip_desc_chinese.arr[0]         = '\0';
d_cust_contact_name.arr[0]             = '\0';
d_cust_contact_name_ttl.arr[0]         = '\0';
d_tel_num.arr[0]                       = '\0';
d_misc_customer_flag                   = '\0';
d_chinese_reporting_flag               = '\0';

d_cust_cust_code.len                   = 0;
d_cust_long_name_chinese.len           = 0;
d_cust_short_name_chinese.len          = 0;
d_cust_add1_desc_chinese.len           = 0;
d_cust_add2_desc_chinese.len           = 0;
d_cust_add3_desc_chinese.len           = 0;
d_cust_zip_desc_chinese.len            = 0;
d_cust_contact_name.len                = 0;
d_cust_contact_name_ttl.len          = 0;

    if (nd_rep_order_flg.arr[0] == 'C')
    {
        /* EXEC SQL FETCH AR_CUSTOMER_CUR1
                  INTO :d_cust_cust_code,
                       :d_cust_long_name_chinese,
                       :d_cust_short_name_chinese,
                       :d_cust_add1_desc_chinese,
                       :d_cust_add2_desc_chinese,
                       :d_cust_add3_desc_chinese,
                       :d_cust_zip_desc_chinese,
                       :d_cust_contact_name,
                       :d_cust_contact_name_ttl,
				       :d_misc_customer_flag,
				       :d_chinese_reporting_flag,
				       :d_tel_num; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 22;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )374;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_cust_cust_code;
        sqlstm.sqhstl[0] = (unsigned int  )11;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_cust_long_name_chinese;
        sqlstm.sqhstl[1] = (unsigned int  )103;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_cust_short_name_chinese;
        sqlstm.sqhstl[2] = (unsigned int  )103;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_cust_add1_desc_chinese;
        sqlstm.sqhstl[3] = (unsigned int  )63;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&d_cust_add2_desc_chinese;
        sqlstm.sqhstl[4] = (unsigned int  )63;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&d_cust_add3_desc_chinese;
        sqlstm.sqhstl[5] = (unsigned int  )63;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&d_cust_zip_desc_chinese;
        sqlstm.sqhstl[6] = (unsigned int  )33;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&d_cust_contact_name;
        sqlstm.sqhstl[7] = (unsigned int  )103;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&d_cust_contact_name_ttl;
        sqlstm.sqhstl[8] = (unsigned int  )63;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&d_misc_customer_flag;
        sqlstm.sqhstl[9] = (unsigned int  )1;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&d_chinese_reporting_flag;
        sqlstm.sqhstl[10] = (unsigned int  )1;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&d_tel_num;
        sqlstm.sqhstl[11] = (unsigned int  )33;
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
            err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR1",0,"");
     }
     else
     {
        /* EXEC SQL FETCH AR_CUSTOMER_CUR2
                  INTO :d_cust_cust_code,
                       :d_cust_long_name_chinese,
                       :d_cust_short_name_chinese,
                       :d_cust_add1_desc_chinese,
                       :d_cust_add2_desc_chinese,
                       :d_cust_add3_desc_chinese,
                       :d_cust_zip_desc_chinese,
                       :d_cust_contact_name,
                       :d_cust_contact_name_ttl,
				       :d_misc_customer_flag,
				       :d_chinese_reporting_flag,
				       :d_tel_num; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 22;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )437;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_cust_cust_code;
        sqlstm.sqhstl[0] = (unsigned int  )11;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_cust_long_name_chinese;
        sqlstm.sqhstl[1] = (unsigned int  )103;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&d_cust_short_name_chinese;
        sqlstm.sqhstl[2] = (unsigned int  )103;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&d_cust_add1_desc_chinese;
        sqlstm.sqhstl[3] = (unsigned int  )63;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&d_cust_add2_desc_chinese;
        sqlstm.sqhstl[4] = (unsigned int  )63;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&d_cust_add3_desc_chinese;
        sqlstm.sqhstl[5] = (unsigned int  )63;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&d_cust_zip_desc_chinese;
        sqlstm.sqhstl[6] = (unsigned int  )33;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&d_cust_contact_name;
        sqlstm.sqhstl[7] = (unsigned int  )103;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&d_cust_contact_name_ttl;
        sqlstm.sqhstl[8] = (unsigned int  )63;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&d_misc_customer_flag;
        sqlstm.sqhstl[9] = (unsigned int  )1;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&d_chinese_reporting_flag;
        sqlstm.sqhstl[10] = (unsigned int  )1;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&d_tel_num;
        sqlstm.sqhstl[11] = (unsigned int  )33;
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
            err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR2",0,"");
     }
d_cust_cust_code.arr[d_cust_cust_code.len]                    = '\0';
d_cust_long_name_chinese.arr[d_cust_long_name_chinese.len]    = '\0';
d_cust_short_name_chinese.arr[d_cust_short_name_chinese.len]  = '\0';
d_cust_add1_desc_chinese.arr[d_cust_add1_desc_chinese.len]    = '\0';
d_cust_add2_desc_chinese.arr[d_cust_add2_desc_chinese.len]    = '\0';
d_cust_add3_desc_chinese.arr[d_cust_add3_desc_chinese.len]    = '\0';
d_cust_zip_desc_chinese.arr[d_cust_zip_desc_chinese.len]      = '\0';
d_cust_contact_name.arr[d_cust_contact_name.len]              = '\0';
d_tel_num.arr[d_tel_num.len]                                  = '\0';
d_cust_contact_name_ttl.arr[d_cust_contact_name_ttl.len]  = '\0';

   if (LAST_ROW)
       return(0);
   else
       return(1);
}

open_pending_doc()
{
    /* EXEC SQL OPEN AR_PENDING_DOC_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,NVL(BI\
LL_NUM,0) ,NVL(BILL_DOC_TYPE_CODE,' ') ,NVL(PATIENT_ID,' ') ,NVL(CUST_REF,' \
') ,NVL(CEIL((TO_DATE(:b0,'DD/MM/YYYY')-NVL(BASE_DATE,DOC_DATE))),0) ,NVL(PE\
NDING_AMT,0) ,NVL(PAYABLE_AMT,0) ,(NVL(PENDING_AMT,0)-NVL(PAYABLE_AMT,0)) ,S\
IGN(PENDING_AMT) ,DECODE(SIGN(NVL(PENDING_AMT,0)),(-1),(-NVL(PENDING_AMT,0))\
,NVL(PENDING_AMT,0)) ,NVL(MISC_CUST_LONG_NAME,' ') ,NVL(MISC_CUST_SHORT_NAME\
,' ') ,NVL(MISC_CUST_ADD1_DESC,' ') ,NVL(MISC_CUST_ADD2_DESC,' ') ,NVL(MISC_\
CUST_ADD3_DESC,' ') ,NVL(MISC_CUST_ZIP_DESC,' ') ,NVL(MISC_CUST_LONG_NAME_CH\
INESE,' ') ,NVL(MISC_CUST_SHORT_NAME_CHINESE,' ') ,NVL(MISC_CUST_ADD1_DESC_C\
HINESE,' ') ,NVL(MISC_CUST_ADD2_DESC_CHINESE,' ') ,NVL(MISC_CUST_ADD3_DESC_C\
HINESE,' ') ,NVL(MISC_CUST_ZIP_DESC_CHINESE,' ') ,NVL(CONTACT_NAME,' ') ,NVL\
(CONTACT_NAME_TITLE,' ') ,NVL(BILL_TYPE_CODE,' ') ,NVL(SUBSTR(NARRATION,1,26\
),' ') ,TEL_NUM  from AR_PENDING_DOC where (CUST_CODE=:b1 and NVL(DOC_DATE,B\
ASE_DATE)<=to_date(:b0,'DD/MM/YYYY')) order");
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )500;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_cutoff_date;
    sqlstm.sqhstl[0] = (unsigned int  )15;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_cust_cust_code;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_cutoff_date;
    sqlstm.sqhstl[2] = (unsigned int  )15;
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
         err_mesg("OPEN failed on cursor AR_PENDING_DOC_CUR",0,"");
}

fetch_pending_doc()
{

d_ar_pend_doc_type_code.arr[0]            = '\0';
d_ar_pend_doc_num.arr[0]                  = '\0';
d_ar_pend_doc_date.arr[0]                 = '\0';
d_ar_pend_bill_num.arr[0]                 = '\0';
d_ar_pend_bill_doc_type_code.arr[0]       = '\0';
d_ar_pend_patient_id.arr[0]               = '\0';
d_ar_pend_cust_ref.arr[0]                 = '\0';
d_misc_cust_long_name.arr[0]       = '\0';
d_misc_cust_short_name.arr[0]      = '\0';
d_misc_cust_add1_desc.arr[0]       = '\0';
d_misc_cust_add2_desc.arr[0]       = '\0';
d_misc_cust_add3_desc.arr[0]       = '\0';
d_misc_cust_zip_desc.arr[0]        = '\0';
d_misc_cust_long_name_chi.arr[0]   = '\0';
d_misc_cust_short_name_chi.arr[0]  = '\0';
d_misc_cust_add1_desc_chi.arr[0]   = '\0';
d_misc_cust_add2_desc_chi.arr[0]   = '\0';
d_misc_cust_add3_desc_chi.arr[0]   = '\0';
d_misc_cust_zip_desc_chi.arr[0]    = '\0';
d_misc_cust_contact_name.arr[0]    = '\0';
d_misc_cust_contact_name_ttl.arr[0]= '\0';
d_misc_tel_num.arr[0]              = '\0';
d_ar_pend_bill_type_code.arr[0]    = '\0';
d_ar_pend_narration.arr[0]		   = '\0';

d_ar_pend_pending_amt              = 0;
d_ar_pend_payable_amt              = 0;
d_ar_pend_alloc_amt                = 0;
age_days						   = 0;
d_ar_pend_doc_type_code.len        = 0;
d_ar_pend_doc_num.len              = 0;
d_ar_pend_doc_date.len             = 0;
d_ar_pend_bill_num.len             = 0;
d_ar_pend_bill_doc_type_code.len   = 0;
d_ar_pend_patient_id.len           = 0;
d_ar_pend_cust_ref.len             = 0;
d_misc_cust_long_name.len          = 0;
d_misc_cust_short_name.len         = 0;
d_misc_cust_add1_desc.len          = 0;
d_misc_cust_add2_desc.len          = 0;
d_misc_cust_add3_desc.len          = 0;
d_misc_cust_zip_desc.len           = 0;
d_misc_cust_long_name_chi.len      = 0;
d_misc_cust_short_name_chi.len     = 0;
d_misc_cust_add1_desc_chi.len      = 0;
d_misc_cust_add2_desc_chi.len      = 0;
d_misc_cust_add3_desc_chi.len      = 0;
d_misc_cust_zip_desc_chi.len       = 0;
d_misc_cust_contact_name.len       = 0;
d_misc_cust_contact_name_ttl.len   = 0;
d_misc_tel_num.len                 = 0;
d_ar_pend_bill_type_code.len       = 0;
d_ar_pend_narration.len            = 0;

    /* EXEC SQL FETCH AR_PENDING_DOC_CUR
              INTO :d_ar_pend_doc_type_code,
                   :d_ar_pend_doc_num,
                   :d_ar_pend_doc_date,
                   :d_ar_pend_bill_num,
                   :d_ar_pend_bill_doc_type_code,
                   :d_ar_pend_patient_id,
                   :d_ar_pend_cust_ref,
                   :age_days,
                   :d_ar_pend_pending_amt,
                   :d_ar_pend_payable_amt,
                   :d_ar_pend_alloc_amt,
                   :d_ar_pend_sign_amt,
                   :d_ar_pend_negative_amt,
				   :d_misc_cust_long_name,
				   :d_misc_cust_short_name,
				   :d_misc_cust_add1_desc,
				   :d_misc_cust_add2_desc,
				   :d_misc_cust_add3_desc,
				   :d_misc_cust_zip_desc,
				   :d_misc_cust_long_name_chi,
				   :d_misc_cust_short_name_chi,
				   :d_misc_cust_add1_desc_chi,
				   :d_misc_cust_add2_desc_chi,
				   :d_misc_cust_add3_desc_chi,
				   :d_misc_cust_zip_desc_chi,
                   :d_misc_cust_contact_name,
                   :d_misc_cust_contact_name_ttl,
                   :d_ar_pend_bill_type_code,
                   :d_ar_pend_narration,
                   :d_misc_tel_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )527;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_pend_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_ar_pend_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_ar_pend_doc_date;
    sqlstm.sqhstl[2] = (unsigned int  )14;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_ar_pend_bill_num;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_ar_pend_bill_doc_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_ar_pend_patient_id;
    sqlstm.sqhstl[5] = (unsigned int  )23;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_ar_pend_cust_ref;
    sqlstm.sqhstl[6] = (unsigned int  )18;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&age_days;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_ar_pend_pending_amt;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_ar_pend_payable_amt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_ar_pend_alloc_amt;
    sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_ar_pend_sign_amt;
    sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_ar_pend_negative_amt;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_misc_cust_long_name;
    sqlstm.sqhstl[13] = (unsigned int  )103;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_misc_cust_short_name;
    sqlstm.sqhstl[14] = (unsigned int  )63;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_misc_cust_add1_desc;
    sqlstm.sqhstl[15] = (unsigned int  )63;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_misc_cust_add2_desc;
    sqlstm.sqhstl[16] = (unsigned int  )63;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&d_misc_cust_add3_desc;
    sqlstm.sqhstl[17] = (unsigned int  )63;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_misc_cust_zip_desc;
    sqlstm.sqhstl[18] = (unsigned int  )33;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&d_misc_cust_long_name_chi;
    sqlstm.sqhstl[19] = (unsigned int  )103;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&d_misc_cust_short_name_chi;
    sqlstm.sqhstl[20] = (unsigned int  )103;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&d_misc_cust_add1_desc_chi;
    sqlstm.sqhstl[21] = (unsigned int  )63;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&d_misc_cust_add2_desc_chi;
    sqlstm.sqhstl[22] = (unsigned int  )63;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&d_misc_cust_add3_desc_chi;
    sqlstm.sqhstl[23] = (unsigned int  )63;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&d_misc_cust_zip_desc_chi;
    sqlstm.sqhstl[24] = (unsigned int  )33;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&d_misc_cust_contact_name;
    sqlstm.sqhstl[25] = (unsigned int  )103;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&d_misc_cust_contact_name_ttl;
    sqlstm.sqhstl[26] = (unsigned int  )63;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&d_ar_pend_bill_type_code;
    sqlstm.sqhstl[27] = (unsigned int  )5;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&d_ar_pend_narration;
    sqlstm.sqhstl[28] = (unsigned int  )53;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&d_misc_tel_num;
    sqlstm.sqhstl[29] = (unsigned int  )33;
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
         err_mesg("FETCH failed on cursor AR_PENDING_DOC_CUR",0,"");

  if (LAST_ROW)
      return(0);

d_ar_pend_doc_type_code.arr[d_ar_pend_doc_type_code.len] = '\0';
d_ar_pend_doc_num.arr[d_ar_pend_doc_num.len] = '\0';
d_ar_pend_doc_date.arr[d_ar_pend_doc_date.len] = '\0';
d_ar_pend_bill_num.arr[d_ar_pend_bill_num.len] = '\0';
d_ar_pend_bill_doc_type_code.arr[d_ar_pend_bill_doc_type_code.len] = '\0';
d_ar_pend_patient_id.arr[d_ar_pend_patient_id.len] = '\0';
d_ar_pend_cust_ref.arr[d_ar_pend_cust_ref.len] = '\0';
d_misc_cust_long_name.arr[d_misc_cust_long_name.len] = '\0';
d_misc_cust_short_name.arr[d_misc_cust_short_name.len] = '\0';
d_misc_cust_add1_desc.arr[d_misc_cust_add1_desc.len] = '\0';
d_misc_cust_add2_desc.arr[d_misc_cust_add2_desc.len] = '\0';
d_misc_cust_add3_desc.arr[d_misc_cust_add3_desc.len] = '\0';
d_misc_cust_zip_desc.arr[d_misc_cust_zip_desc.len] = '\0';
d_misc_cust_long_name_chi.arr[d_misc_cust_long_name_chi.len] = '\0';
d_misc_cust_short_name_chi.arr[d_misc_cust_short_name_chi.len] = '\0';
d_misc_cust_add1_desc_chi.arr[d_misc_cust_add1_desc_chi.len] = '\0';
d_misc_cust_add2_desc_chi.arr[d_misc_cust_add2_desc_chi.len] = '\0';
d_misc_cust_add3_desc_chi.arr[d_misc_cust_add3_desc_chi.len] = '\0';
d_misc_cust_zip_desc_chi.arr[d_misc_cust_zip_desc_chi.len] = '\0';
d_misc_cust_contact_name.arr[d_misc_cust_contact_name.len]  = '\0';
d_misc_cust_contact_name_ttl.arr[d_misc_cust_contact_name_ttl.len]  = '\0';
d_ar_pend_bill_type_code.arr[d_ar_pend_bill_type_code.len]   = '\0';
d_ar_pend_narration.arr[d_ar_pend_narration.len]  = '\0';
d_misc_tel_num.arr[d_misc_tel_num.len] = '\0';

if(d_misc_customer_flag == 'Y') {
    if(d_chinese_reporting_flag == 'Y') {
	strcpy(d_cust_long_name_chinese.arr,d_misc_cust_long_name_chi.arr);
	strcpy(d_cust_short_name_chinese.arr,d_misc_cust_short_name_chi.arr);
	strcpy(d_cust_add1_desc_chinese.arr,d_misc_cust_add1_desc_chi.arr);
	strcpy(d_cust_add2_desc_chinese.arr,d_misc_cust_add2_desc_chi.arr);
	strcpy(d_cust_add3_desc_chinese.arr,d_misc_cust_add3_desc_chi.arr);
	strcpy(d_cust_zip_desc_chinese.arr,d_misc_cust_zip_desc_chi.arr);
    }
    else {
	strcpy(d_cust_long_name_chinese.arr,d_misc_cust_long_name.arr);
	strcpy(d_cust_short_name_chinese.arr,d_misc_cust_short_name.arr);
	strcpy(d_cust_add1_desc_chinese.arr,d_misc_cust_add1_desc.arr);
	strcpy(d_cust_add2_desc_chinese.arr,d_misc_cust_add2_desc.arr);
	strcpy(d_cust_add3_desc_chinese.arr,d_misc_cust_add3_desc.arr);
	strcpy(d_cust_zip_desc_chinese.arr,d_misc_cust_zip_desc.arr);
    }

    strcpy(d_cust_contact_name.arr,d_misc_cust_contact_name.arr);
    strcpy(d_cust_contact_name_ttl.arr,d_misc_cust_contact_name_ttl.arr);
    strcpy(d_tel_num.arr, d_misc_tel_num.arr);
    
    d_cust_long_name_chinese.len = strlen(d_cust_long_name_chinese.arr);
    d_cust_short_name_chinese.len = strlen(d_cust_short_name_chinese.arr);
    d_cust_add1_desc_chinese.len = strlen(d_cust_add1_desc_chinese.arr);
    d_cust_add2_desc_chinese.len = strlen(d_cust_add2_desc_chinese.arr);
    d_cust_add3_desc_chinese.len = strlen(d_cust_add3_desc_chinese.arr);
    d_cust_zip_desc_chinese.len = strlen(d_cust_zip_desc_chinese.arr);
    d_cust_contact_name.len = strlen(d_cust_contact_name.arr);
    d_cust_contact_name_ttl.len = strlen(d_cust_contact_name_ttl.arr);
}


    /* EXEC SQL SELECT NVL(SUM(NVL(AMOUNT,0)),0) 
             INTO   :d_ar_pend_alloc_amt
		     FROM   AR_CUST_TRN
		     WHERE  CUST_CODE = :d_cust_cust_code
		     AND    ORG_DOC_TYPE_CODE = :d_ar_pend_doc_type_code
		     AND    ORG_DOC_NUM       = :d_ar_pend_doc_num
		     AND    RPAD(ORG_DOC_TYPE_CODE,6,' ')||TO_CHAR(ORG_DOC_NUM) <>
	         RPAD(DOC_TYPE_CODE,6,' ')||TO_CHAR(DOC_NUM)
		     AND    DOC_DATE <= TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 30;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select NVL(sum(NVL(AMOUNT,0)),0) into :b0  from AR_CUST_T\
RN where ((((CUST_CODE=:b1 and ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NUM=:b3) and\
 (RPAD(ORG_DOC_TYPE_CODE,6,' ')||TO_CHAR(ORG_DOC_NUM))<>(RPAD(DOC_TYPE_CODE,6,\
' ')||TO_CHAR(DOC_NUM))) and DOC_DATE<=TO_DATE(:b4,'DD/MM/YYYY'))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )662;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_pend_alloc_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_cust_cust_code;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_ar_pend_doc_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_ar_pend_doc_num;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_cutoff_date;
    sqlstm.sqhstl[4] = (unsigned int  )15;
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
	err_mesg("SELECT failed on table AR_CUST_TRN",0,"");

    d_ar_pend_pending_amt = d_ar_pend_payable_amt + d_ar_pend_alloc_amt;

    if(d_ar_pend_pending_amt < 0)
	d_ar_pend_sign_amt = -1;
    else if(d_ar_pend_pending_amt > 0)
	d_ar_pend_sign_amt = 1;
    else
        d_ar_pend_sign_amt = 0;

    d_ar_pend_negative_amt = (d_ar_pend_negative_amt > 0) ? 
			     d_ar_pend_negative_amt : 
			     d_ar_pend_negative_amt * -1;

 return(1);
}

fetch_patient_name()
{

d_ar_mp_patient_name.arr[0] = '\0';
d_ar_mp_patient_name.len    = 0;

     /* EXEC SQL OPEN AR_PATIENT_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 30;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0009;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )697;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_ar_pend_patient_id;
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
         err_mesg("OPEN failed on cursor AR_PATIENT_CUR",0,"");

     /* EXEC SQL FETCH AR_PATIENT_CUR
               INTO :d_ar_mp_patient_name; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 30;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )716;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_ar_mp_patient_name;
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
         err_mesg("FETCH failed on cursor AR_PATIENT_CUR",0,"");

    if(NO_DATA_FOUND)
	strcpy(d_ar_mp_patient_name.arr,d_ar_pend_narration.arr);
    else
       d_ar_mp_patient_name.arr[d_ar_mp_patient_name.len] = '\0';

}

print_details()
{
  char out_str[35],out_str1[35],misc_flag;
 
  if (cust_lctr > MAX_LINES) print_page_head();

  fprintf(fp,"%-10.10s %-6.6s %8.8s %8.8s %-6.6s %-10.10s %-26.26s %-15.15s",
					                  d_ar_pend_doc_date.arr,
					                  d_ar_pend_doc_type_code.arr,
					                  d_ar_pend_doc_num.arr,
					                  d_ar_pend_bill_num.arr,
					                  d_ar_pend_bill_doc_type_code.arr,
					                  d_ar_pend_patient_id.arr,
					                  d_ar_mp_patient_name.arr,
					                  d_ar_pend_cust_ref.arr);


   print_formated(d_ar_pend_payable_amt);
   print_formated(d_ar_pend_alloc_amt);
   print_formated(d_ar_pend_pending_amt);
   fprintf(fp,"\n");
   cust_lctr ++;

   tot_payable_amt   += d_ar_pend_payable_amt;
   tot_alloc_amt     += d_ar_pend_alloc_amt;
   tot_pending_amt   += d_ar_pend_pending_amt;

}

print_balance1()
{
 int i = 0;

    if (LEGEND)
       for (i=0;i<139;i++) fprintf(fp,"-");
    fprintf(fp,"\n");
    for (i=0;i<SKIP_7;i++) fprintf(fp," ");
    fprintf(fp,"C/F BALANCE  : ");
    print_formated(tot_pending_amt);
    fprintf(fp,"\n");
}
    
print_balance2()
{
 int i = 0;
    cust_lctr ++;
    for (i=0;i<SKIP_7;i++) fprintf(fp," ");
    fprintf(fp,"B/F BALANCE  : ");
    print_formated(tot_pending_amt);
    fprintf(fp,"\n");
}

print_footer()
{
 int i = 0;

 int no_of_lines; /* ADDED ON 02/12/1999 */

    for(i=0; i<10; i++) amt_in_words[i][0] = '\0';


    if (cust_lctr >= MAX_LINES) 
       print_page_head();

    for (i=cust_lctr;i<MAX_LINES-3;i++) fprintf(fp,"\n");
    if (LEGEND)
        for (i=0;i<139;i++) fprintf(fp,"-");
    fprintf(fp,"\n");
    for (i=0;i<SKIP_8;i++) fprintf(fp," ");
    if (LEGEND)
        fprintf(fp,"TOTAL : ");
    else
        fprintf(fp,"        ");

    print_formated(tot_payable_amt);
    print_formated(tot_alloc_amt);
    print_formated(tot_pending_amt);
    fprintf(fp,"\n");
    for (i=0;i<SKIP_9;i++) fprintf(fp,"\n");
    for (i=0;i<SKIP_10;i++) fprintf(fp," ");
    if (LEGEND)
        fprintf(fp,"TOTAL OUTSTANDING       : ");
    else
        fprintf(fp,"                          ");
    print_formated(tot_pending_amt);

	/*  added on 02/12/1999*/

     tot_pending_amt1 = tot_pending_amt;
   if (tot_pending_amt < 0.00)
     tot_pending_amt1 = (-1)*tot_pending_amt;   
  
   if(equal(tot_pending_amt,0.00)) 
	no_of_lines=0;
    else
	   	no_of_lines = print_in_words(tot_pending_amt1,LENGTH_WORDS,subcur.arr,amt_in_words,no_of_decimal);

    if (tot_pending_amt != 0) 
       fprintf(fp,"\nAMOUNT IN WORDS : %-6s",currency.arr);
	   
	for (i =0;i<no_of_lines;i++)
   	    fprintf(fp," %s",amt_in_words[i]);

   

    fprintf(fp,"\n");
    for (i=0;i<SKIP_10;i++) fprintf(fp," ");
    if (LEGEND)
        fprintf(fp,"                           =============");
    else
        fprintf(fp,"                                        ");
    print_ageing();
    tot_payable_amt  = 0;
    tot_alloc_amt    = 0;
    tot_pending_amt  = 0;

    fprintf(fp,"%c",0x12); /*** reset printer to normal mode ***/
}

print_ageing()
{
int i = 0;
    for (i=0;i<SKIP_11;i++) fprintf(fp,"\n");
    for (i=0;i<139;i++) fprintf(fp,"-");
    fprintf(fp,"\n");
    if (LEGEND)
       fprintf(fp,"TOTAL OUTSTANDING    OPEN CREDITS   ");
    else
       fprintf(fp,"                                    ");

    fprintf(fp,"%3d-%-3d",0, nd_age_slot1);
    if (LEGEND)
       fprintf(fp," DAYS     ");
    else
       fprintf(fp,"          ");

    fprintf(fp,"%3d-%-3d",nd_age_slot1+1,nd_age_slot2);
    if (LEGEND)
       fprintf(fp," DAYS     ");
    else
       fprintf(fp,"          ");

    fprintf(fp,"%3d-%-3d",nd_age_slot2+1,nd_age_slot3);
    if (LEGEND)
       fprintf(fp," DAYS     ");
    else
       fprintf(fp,"          ");

    fprintf(fp,"%3d-%-3d",nd_age_slot3+1,nd_age_slot4);
    if (LEGEND)
       fprintf(fp," DAYS     ");
    else
       fprintf(fp,"          ");

    fprintf(fp," > %-3d",nd_age_slot4);
    if (LEGEND)
       fprintf(fp," DAYS     ");
    else
       fprintf(fp,"          ");
    fprintf(fp,"\n");

    fprintf(fp,"   ");
    disp_message(INFO_MESG,"TOTAl PENDIng AMT");
    print_formated(tot_pending_amt);
    disp_message(INFO_MESG,"AFER TOTAl PENDIng AMT");
    fprintf(fp,"  ");
    print_formated(nd_open_credit);
    fprintf(fp," ");
    print_formated(amt_slot1);
    fprintf(fp,"   ");
    print_formated(amt_slot2);
    fprintf(fp,"   ");
    print_formated(amt_slot3);
    fprintf(fp,"   ");
    print_formated(amt_slot4);
    fprintf(fp,"  ");
    print_formated(amt_slot5);
    fprintf(fp,"\n");

    for (i=0;i<139;i++) fprintf(fp,"-");
    fprintf(fp,"\n");
    fprintf(fp,"REMARK : Please disregard this statement if payment has been made after the statement date.\n");

    tot_pending_amt  = 0;
    nd_open_credit   = 0;
    amt_slot1        = 0;
    amt_slot2        = 0;
    amt_slot3        = 0;
    amt_slot4        = 0;
    amt_slot5        = 0;
}

process_ageing()
{
   if (d_ar_pend_sign_amt != 1)
        nd_open_credit    += d_ar_pend_negative_amt;
   else if (d_ar_pend_sign_amt != 0)
   {
     if (age_days <= nd_age_slot1)
         amt_slot1    += d_ar_pend_pending_amt;
     else if (age_days >= nd_age_slot1 + 1 && age_days <= nd_age_slot2)
         amt_slot2    += d_ar_pend_pending_amt;
     else if (age_days >= nd_age_slot2 + 1 && age_days <= nd_age_slot3)
         amt_slot3    += d_ar_pend_pending_amt;
     else if (age_days >= nd_age_slot3 + 1 && age_days <= nd_age_slot4)
         amt_slot4    += d_ar_pend_pending_amt;
     else if (age_days >= nd_age_slot4 + 1)
         amt_slot5    += d_ar_pend_pending_amt;
   }
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
  sqlstm.offset = (unsigned int  )735;
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
      return(-1);
  return(0);
}

rtrim(l_str)
char *l_str;
{
  while (*l_str != '\0') *l_str++;
  l_str--;
  while (*l_str == ' ') *l_str--;
  *(l_str+1) = '\0';
} 

print_formated(loc_amount)
double loc_amount;
{
   char out_str[20],out_str1[20];

   if (no_of_decimal == 3)
      sprintf(out_str,"%10.3f",loc_amount);
   else
      sprintf(out_str,"%10.2f",loc_amount);

      format_amt(out_str,no_of_decimal);


	if (loc_amount == 0)
	fprintf(fp,"%-13s"," ");
	 
	else if (loc_amount > 0)
	{
	  fprintf(fp,"%14s",out_str);
	}
	else
	{
  	  fprintf(fp,"%14s-",out_str);

	}


/*
   if (loc_amount == 0)
      fprintf(fp,"%-14s"," ");
   else if (loc_amount > 0)
   {
      sprintf(out_str,"%10.2f",loc_amount);
      format_amt(out_str);
      disp_message(INFO_MESG,out_str);
      sprintf(out_str1,"%13s",out_str);
      fprintf(fp,"%-13s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%10.2f",-loc_amount);
      format_amt(out_str);
      sprintf(out_str1,"%13s",out_str);
      fprintf(fp,"%-13s-",out_str1);
   }
*/
}
