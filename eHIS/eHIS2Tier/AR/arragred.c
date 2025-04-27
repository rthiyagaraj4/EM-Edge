
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
    "T:\\BL\\CRF-0120\\AR\\WIP\\Proc\\Arragred.pc"
};


static unsigned long sqlctx = 1150833013;


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
            void  *sqhstv[24];
   unsigned int   sqhstl[24];
            int   sqhsts[24];
            void  *sqindv[24];
            int   sqinds[24];
   unsigned int   sqharm[24];
   unsigned int   *sqharc[24];
   unsigned short  sqadto[24];
   unsigned short  sqtdso[24];
} sqlstm = {10,24};

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
"select CUST_CODE ,LONG_NAME ,CUST_ALPHA_CODE  from AR_CUSTOMER where ((((((C\
UST_CODE between NVL(:b0,'        ') and NVL(:b1,'~~~~~~~~') and (:b2='N' or N\
VL(PAT_COM_FLAG,'N')='Y')) and CUST_TYPE_CODE between NVL(:b3,'  ') and NVL(:b\
4,'~~')) and CUST_GROUP_CODE between NVL(:b5,'  ') and NVL(:b6,'~~')) and NVL(\
ANALYSIS_1_CODE,'X') between NVL(:b7,'        ') and NVL(:b8,'~~~~~~~~')) and \
NVL(ANALYSIS_2_CODE,'X') between NVL(:b9,'        ') and NVL(:b10,'~~~~~~~~'))\
 and NVL(ANALYSIS_3_CODE,'X') between NVL(:b11,'        ') and NVL(:b12,'~~~~~\
~~~')) order by CUST_CODE            ";

 static const char *sq0006 = 
"select CUST_CODE ,LONG_NAME ,CUST_ALPHA_CODE  from AR_CUSTOMER where ((((((C\
UST_ALPHA_CODE between NVL(:b0,'        ') and NVL(:b1,'~~~~~~~~') and (:b2='N\
' or NVL(PAT_COM_FLAG,'N')='Y')) and CUST_TYPE_CODE between NVL(:b3,'  ') and \
NVL(:b4,'~~')) and CUST_GROUP_CODE between NVL(:b5,'  ') and NVL(:b6,'~~')) an\
d NVL(ANALYSIS_1_CODE,'X') between NVL(:b7,'        ') and NVL(:b8,'~~~~~~~~')\
) and NVL(ANALYSIS_2_CODE,'X') between NVL(:b9,'        ') and NVL(:b10,'~~~~~\
~~~')) and NVL(ANALYSIS_3_CODE,'X') between NVL(:b11,'        ') and NVL(:b12,\
'~~~~~~~~')) order by CUST_ALPHA_CODE,CUST_CODE            ";

 static const char *sq0007 = 
"select A.CUST_CODE ,A.LONG_NAME ,A.CUST_ALPHA_CODE ,sum(B.PENDING_AMT)  from\
 AR_CUSTOMER A ,AR_PENDING_DOC B where ((A.CUST_CODE=B.CUST_CODE and A.CUST_CO\
DE between NVL(:b0,'        ') and NVL(:b1,'~~~~~~~~')) and (:b2='N' or NVL(A.\
PAT_COM_FLAG,'N')='Y')) group by A.CUST_CODE,A.LONG_NAME,A.CUST_ALPHA_CODE hav\
ing sum(B.PENDING_AMT)<>0 order by 4 desc             ";

 static const char *sq0008 = 
"select CUST_CODE ,LONG_NAME ,CUST_ALPHA_CODE  from AR_CUSTOMER where ((((((C\
UST_CODE between NVL(:b0,'        ') and NVL(:b1,'~~~~~~~~') and (:b2='N' or N\
VL(PAT_COM_FLAG,'N')='Y')) and CUST_TYPE_CODE between NVL(:b3,'  ') and NVL(:b\
4,'~~')) and CUST_GROUP_CODE between NVL(:b5,'  ') and NVL(:b6,'~~')) and NVL(\
ANALYSIS_1_CODE,'X') between NVL(:b7,'        ') and NVL(:b8,'~~~~~~~~')) and \
NVL(ANALYSIS_2_CODE,'X') between NVL(:b9,'        ') and NVL(:b10,'~~~~~~~~'))\
 and NVL(ANALYSIS_3_CODE,'X') between NVL(:b11,'        ') and NVL(:b12,'~~~~~\
~~~')) order by CUST_CODE            ";

 static const char *sq0009 = 
"select CUST_CODE ,LONG_NAME ,CUST_ALPHA_CODE  from AR_CUSTOMER where ((((((C\
UST_ALPHA_CODE between NVL(:b0,'        ') and NVL(:b1,'~~~~~~~~') and (:b2='N\
' or NVL(PAT_COM_FLAG,'N')='Y')) and CUST_TYPE_CODE between NVL(:b3,'  ') and \
NVL(:b4,'~~')) and CUST_GROUP_CODE between NVL(:b5,'  ') and NVL(:b6,'~~')) an\
d NVL(ANALYSIS_1_CODE,'X') between NVL(:b7,'        ') and NVL(:b8,'~~~~~~~~')\
) and NVL(ANALYSIS_2_CODE,'X') between NVL(:b9,'        ') and NVL(:b10,'~~~~~\
~~~')) and NVL(ANALYSIS_3_CODE,'X') between NVL(:b11,'        ') and NVL(:b12,\
'~~~~~~~~')) order by CUST_ALPHA_CODE,CUST_CODE            ";

 static const char *sq0010 = 
"select A.CUST_CODE ,A.LONG_NAME ,A.CUST_ALPHA_CODE ,sum(B.PENDING_AMT)  from\
 AR_CUSTOMER A ,AR_PENDING_DOC B where ((A.CUST_CODE=B.CUST_CODE and A.CUST_CO\
DE between NVL(:b0,'        ') and NVL(:b1,'~~~~~~~~')) and (:b2='N' or NVL(A.\
PAT_COM_FLAG,'N')='Y')) group by A.CUST_CODE,A.LONG_NAME,A.CUST_ALPHA_CODE hav\
ing sum(B.PENDING_AMT)<>0 order by 4 desc             ";

 static const char *sq0011 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(NVL(BASE_DATE,DOC_DATE),'DD/MM/YYYY')\
 ,TO_CHAR(DUE_DATE,'DD/MM/YYYY') ,NVL(PENDING_AMT,0) ,SIGN(PENDING_AMT) ,DECOD\
E(SIGN(NVL(PENDING_AMT,0)),(-1),(-NVL(PENDING_AMT,0)),NVL(PENDING_AMT,0)) ,CUS\
T_REF ,PATIENT_ID ,CEIL((NVL(TO_DATE(:b0,'DD/MM/YYYY'),SYSDATE)-NVL(BASE_DATE,\
DOC_DATE))) ,CEIL((NVL(TO_DATE(:b0,'DD/MM/YYYY'),SYSDATE)-DUE_DATE))  from AR_\
PENDING_DOC where (CUST_CODE=:b2 and NVL(DOC_DATE,SYSDATE)<=NVL(TO_DATE(:b0,'D\
D/MM/YYYY'),SYSDATE)) order by PATIENT_ID,DOC_TYPE_CODE,DOC_NUM            ";

 static const char *sq0012 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(NVL(BASE_DATE,DOC_DATE),'DD/MM/YYYY')\
 ,TO_CHAR(DUE_DATE,'DD/MM/YYYY') ,NVL(PENDING_AMT,0) ,SIGN(PENDING_AMT) ,DECOD\
E(SIGN(NVL(PENDING_AMT,0)),(-1),(-NVL(PENDING_AMT,0)),NVL(PENDING_AMT,0)) ,CUS\
T_REF ,PATIENT_ID ,CEIL((NVL(TO_DATE(:b0,'DD/MM/YYYY'),SYSDATE)-NVL(BASE_DATE,\
DOC_DATE))) ,CEIL((NVL(TO_DATE(:b0,'DD/MM/YYYY'),SYSDATE)-DUE_DATE))  from AR_\
PENDING_DOC where (CUST_CODE=:b2 and NVL(DOC_DATE,SYSDATE)<=NVL(TO_DATE(:b0,'D\
D/MM/YYYY'),SYSDATE)) order by DOC_TYPE_CODE,DOC_NUM            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,91,0,2,237,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,246,0,0,0,0,0,1,0,
43,0,0,3,200,0,4,261,0,0,7,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,
0,0,1,9,0,0,
86,0,0,4,475,0,4,322,0,0,24,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
197,0,0,5,581,0,9,900,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
264,0,0,6,603,0,9,931,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
331,0,0,7,364,0,9,961,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
358,0,0,8,581,0,9,995,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
425,0,0,9,603,0,9,1026,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
492,0,0,10,364,0,9,1057,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
519,0,0,5,0,0,13,1133,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
546,0,0,6,0,0,13,1142,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
573,0,0,7,0,0,13,1150,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
604,0,0,8,0,0,13,1163,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
631,0,0,9,0,0,13,1172,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
658,0,0,10,0,0,13,1180,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
689,0,0,11,541,0,9,1205,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
720,0,0,12,530,0,9,1212,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
751,0,0,11,0,0,13,1244,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
2,3,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,
810,0,0,12,0,0,13,1261,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
2,3,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,
869,0,0,13,278,0,4,1314,0,0,7,4,0,1,0,2,4,0,0,2,3,0,0,2,4,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
912,0,0,14,69,0,4,1443,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
935,0,0,15,0,0,27,1851,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
};


/* Date :- 17-FEB-93     */
                                                  
#include <stdio.h>
#include <string.h>
#include "gl.h" 
/*
#define OERROR (sqlca.sqlcode < 0)
*/         
                                       
#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define ESC 0x1B
/* 
#define DEBUG 0                 
*/
                  
/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd         [132],
           hosp_name       [120],
           date_time       [20],
           user_id         [20],
           nd_pgm_date     [35],
           nd_rep_type     [3],
           nd_pat_details  [3]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } nd_rep_type;

struct { unsigned short len; unsigned char arr[3]; } nd_pat_details;


  int      nd_age_slot1,
           nd_age_slot2,
           nd_age_slot3;

   /* VARCHAR nd_facility_id                [3],
	   nd_session_id                 [16],
           nd_fm_cust_code               [12],
           nd_to_cust_code               [12],
           nd_fm_alpha_code              [11],
           nd_to_alpha_code              [11],
           nd_age_method                 [3],
           nd_cutoff_date                [12],
           pr_cutoff_date                [12],
		   nd_fm_cust_type [3],
           nd_to_cust_type [3],
           nd_fm_cust_group[3],
           nd_to_cust_group[3],
           nd_fm_anal_cd1  [9],
           nd_to_anal_cd1  [9],
           nd_fm_anal_cd2  [9],
           nd_to_anal_cd2  [9],
           nd_fm_anal_cd3  [9],
           nd_to_anal_cd3  [9],
		   p_language_id			      [3],

           nd_order                      [11]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_cust_code;

struct { unsigned short len; unsigned char arr[12]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[11]; } nd_fm_alpha_code;

struct { unsigned short len; unsigned char arr[11]; } nd_to_alpha_code;

struct { unsigned short len; unsigned char arr[3]; } nd_age_method;

struct { unsigned short len; unsigned char arr[12]; } nd_cutoff_date;

struct { unsigned short len; unsigned char arr[12]; } pr_cutoff_date;

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

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[11]; } nd_order;
 

   /* VARCHAR ar_customer_cust_code         [9],
           ar_customer_long_name         [101],  -- CRF-0120
           ar_customer_short_name        [61],  -- CRF-0120
	   ar_customer_alpha_code        [11], 
	   ar_customer_pend_amt_dummy    [20],

           ar_pend_doc_type_code         [7], 
           ar_pend_doc_num               [9],
           ar_pend_base_date             [12],
           ar_pend_due_date              [12],
           ar_pend_cust_ref              [16],
           ar_pend_patient_id            [21],
           mp_pat_short_name             [31]; */ 
struct { unsigned short len; unsigned char arr[9]; } ar_customer_cust_code;

struct { unsigned short len; unsigned char arr[101]; } ar_customer_long_name;

struct { unsigned short len; unsigned char arr[61]; } ar_customer_short_name;

struct { unsigned short len; unsigned char arr[11]; } ar_customer_alpha_code;

struct { unsigned short len; unsigned char arr[20]; } ar_customer_pend_amt_dummy;

struct { unsigned short len; unsigned char arr[7]; } ar_pend_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } ar_pend_doc_num;

struct { unsigned short len; unsigned char arr[12]; } ar_pend_base_date;

struct { unsigned short len; unsigned char arr[12]; } ar_pend_due_date;

struct { unsigned short len; unsigned char arr[16]; } ar_pend_cust_ref;

struct { unsigned short len; unsigned char arr[21]; } ar_pend_patient_id;

struct { unsigned short len; unsigned char arr[31]; } mp_pat_short_name;


    int    ar_pend_sign_amt,
           ar_pend_cuttoff_base_dt,
           ar_pend_cuttoff_due_dt,
	   nd_no_of_decimal;

   double ar_pend_pending_amt,
          ar_pend_negative_amt;


   char string_var[100];
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

double nd_open_credit,
       nd_outstanding_amt,
       bal_amt_not_yet_due,
       bal_amt_slot1,
       bal_amt_slot2,
       bal_amt_slot3,       

       pat_d_outstanding_amt,
       pat_d_not_yet_due_amt,
       pat_d_open_credit,
       pat_d_amt_slot1,
       pat_d_amt_slot2,
       pat_d_amt_slot3,
       
       cus_d_outstanding_amt,
       cus_d_not_yet_due_amt,
       cus_d_open_credit,
       cus_d_amt_slot1,
       cus_d_amt_slot2,
       cus_d_amt_slot3,
       
       rep_d_outstanding_amt,
       rep_d_not_yet_due_amt,
       rep_d_open_credit,
       rep_d_amt_slot1,
       rep_d_amt_slot2,
       rep_d_amt_slot3;

char old_patient_id     [21];

char string_var[100];
FILE *fp;
int lctr = 0,pctr =0, pend_doc_ctr = 0;
int age_days = 0;

char filename[150];

void proc_main(argc,argv)
char *argv[];
int argc;
{
 char mesg1[50];
 strcpy(filename,WORKING_DIR);

 strcpy(OUTPUT_FILE_NAME,argv[5]);

   if (argc != 7)
   {
    int i = 0;
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }

   strcpy(g_pgm_id,"ARRAGRDP");

   strcpy(nd_rep_type.arr,argv[6]);

   if (nd_rep_type.arr[0] == 'P')
     strcpy(g_pgm_id,"ARRAGRDP");
   else if (nd_rep_type.arr[0] == 'C')
      strcpy(g_pgm_id,"ARRAGRDC");
   else
      strcpy(g_pgm_id,"ARRAGRDS");

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle");
      sprintf(mesg1,"Error is %s\n",sqlca.sqlerrm.sqlerrmc);
      disp_message(ERR_MESG,mesg1);
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd");
      proc_exit();
   }

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);  

   set_meduser_role();
   
    	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);
 
   fetch_param();
   start_prog_msg();
   fetch_desc();
   open_files();
   declare_cursors();
   pend_doc_ctr = 0;

   while(fetch_customer())
   {
        old_patient_id[0]     = '\0';
        pend_doc_ctr = 0;

        open_pending_doc();

        while(fetch_pending_doc())
        {

		   /*-- This PROCEDURE  is to take the exact outstanding amt as of cutoff
                date for the customer aging.  VSK 26/10/1998 ---- */
			
		   fetch_ar_cust_trn();

/*---- Added by Venkat on 10/02/2000 ------------*/
     if(ar_pend_pending_amt == 0)
	 continue;
/*-----------------------------------------------*/
		    
           age_days = (nd_age_method.arr[0]  == 'B')?
                           ar_pend_cuttoff_base_dt:
                           ar_pend_cuttoff_due_dt;
  
           if ( (age_days >= 0 && nd_age_method.arr[0] == 'B')||
		(nd_age_method.arr[0] != 'B'))
           {
               pend_doc_ctr++;
               if (pend_doc_ctr == 1)
                   print_cust_det();

               if (strcmp(old_patient_id,ar_pend_patient_id.arr))
               {
                    if (strlen(old_patient_id))
                    {
                         print_pat_footer();
                    }
                    print_pat_det();
                    strcpy(old_patient_id,ar_pend_patient_id.arr);
                }
                process_det();
                print_det_line();
            }
        }
        if (pend_doc_ctr > 0)
        {
              print_pat_footer();
              print_cus_footer();
        }
    }
    print_report_footer();
    print_end();

    /* EXEC SQL DELETE FROM SY_PROG_PARAM
                   WHERE PGM_ID     = 'ARRAGRED'
                     AND SESSION_ID = :nd_session_id
                     AND PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARRAGRED' and\
 SESSION_ID=:b0) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )5;
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

    end_prog_msg();
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )28;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_desc()
{
   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   user_id.arr[0]        = '\0';
   pr_cutoff_date.arr[0] = '\0';

   hosp_name.len      = 0;
   date_time.len      = 0;
   user_id.len        = 0;
   pr_cutoff_date.len = 0;

   /* EXEC SQL SELECT ACCOUNTING_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                   USER,TO_CHAR(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'),'DD/MM/YYYY'),
		   NO_OF_DECIMAL
              INTO :hosp_name, :date_time, :user_id,
                   :pr_cutoff_date,:nd_no_of_decimal
              FROM SY_ACC_ENTITY
			 WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER ,TO_CHAR(TO_DATE(:b0,'DD/MM/YYYY'),'DD/MM/YYYY') ,NO_OF_DECIMAL into\
 :b1,:b2,:b3,:b4,:b5  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b6";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )43;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_cutoff_date;
   sqlstm.sqhstl[0] = (unsigned int  )14;
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
   sqlstm.sqhstv[4] = (         void  *)&pr_cutoff_date;
   sqlstm.sqhstl[4] = (unsigned int  )14;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_no_of_decimal;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[6] = (unsigned int  )5;
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
         err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]			= '\0';
   date_time.arr[date_time.len]			= '\0';
   user_id.arr[user_id.len]			= '\0';
   pr_cutoff_date.arr[pr_cutoff_date.len]	= '\0';

}

fetch_param()
{
   nd_fm_cust_code.arr[0]        = '\0';
   nd_to_cust_code.arr[0]        = '\0';
   nd_fm_alpha_code.arr[0]       = '\0';
   nd_to_alpha_code.arr[0]       = '\0';
   nd_order.arr[0]               = '\0';
   nd_age_method.arr[0]          = '\0';
   nd_cutoff_date.arr[0]         = '\0';
   nd_pat_details.arr[0]         = '\0';
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


   nd_fm_cust_code.len           = 0;
   nd_to_cust_code.len           = 0;
   nd_fm_alpha_code.len          = 0;
   nd_to_alpha_code.len          = 0;
   nd_order.len                  = 0;
   nd_age_method.len             = 0;
   nd_cutoff_date.len            = 0;
   nd_pat_details.len            = 0;
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



   /* EXEC SQL SELECT operating_facility_id,
					PARAM1,
					PARAM2,
					PARAM3,
					PARAM4,
					NVL(PARAM5,'D'),
					NVL(PARAM6,SYSDATE),
					NVL(TO_NUMBER(PARAM7),0),
					NVL(TO_NUMBER(PARAM8),0),
					NVL(TO_NUMBER(PARAM9),0),
					PARAM10,
					PARAM11,
					PARAM12,
					PARAM13,
					PARAM14,
					PARAM15,
					PARAM16,
					PARAM17,
					PARAM18,
					PARAM19,
					PARAM20,
					PARAM21
              INTO :nd_facility_id,
				   :nd_fm_cust_code,
                   :nd_to_cust_code,
                   :nd_fm_alpha_code,
                   :nd_to_alpha_code,
                   :nd_age_method,
                   :nd_cutoff_date,
                   :nd_age_slot1,
                   :nd_age_slot2,
                   :nd_age_slot3,
                   :nd_order,
                   :nd_pat_details,
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
             WHERE PGM_ID     = 'ARRAGRED'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,NVL(PARAM5,'D') ,NVL(PARAM6,SYSDATE) ,NVL(TO_NUMBER(PARAM7),0) ,NVL(TO_NUM\
BER(PARAM8),0) ,NVL(TO_NUMBER(PARAM9),0) ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,\
PARAM14 ,PARAM15 ,PARAM16 ,PARAM17 ,PARAM18 ,PARAM19 ,PARAM20 ,PARAM21 into :b\
0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,\
:b18,:b19,:b20,:b21  from SY_PROG_PARAM where ((PGM_ID='ARRAGRED' and SESSION_\
ID=:b22) and PGM_DATE=:b23)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )86;
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
   sqlstm.sqhstv[5] = (         void  *)&nd_age_method;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_cutoff_date;
   sqlstm.sqhstl[6] = (unsigned int  )14;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_age_slot1;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_age_slot2;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_age_slot3;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_order;
   sqlstm.sqhstl[10] = (unsigned int  )13;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_pat_details;
   sqlstm.sqhstl[11] = (unsigned int  )5;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_fm_cust_type;
   sqlstm.sqhstl[12] = (unsigned int  )5;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_to_cust_type;
   sqlstm.sqhstl[13] = (unsigned int  )5;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_fm_cust_group;
   sqlstm.sqhstl[14] = (unsigned int  )5;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_to_cust_group;
   sqlstm.sqhstl[15] = (unsigned int  )5;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_fm_anal_cd1;
   sqlstm.sqhstl[16] = (unsigned int  )11;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_to_anal_cd1;
   sqlstm.sqhstl[17] = (unsigned int  )11;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_fm_anal_cd2;
   sqlstm.sqhstl[18] = (unsigned int  )11;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_to_anal_cd2;
   sqlstm.sqhstl[19] = (unsigned int  )11;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_fm_anal_cd3;
   sqlstm.sqhstl[20] = (unsigned int  )11;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_to_anal_cd3;
   sqlstm.sqhstl[21] = (unsigned int  )11;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[22] = (unsigned int  )18;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[23] = (unsigned int  )37;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
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
   nd_age_method.arr[nd_age_method.len]            = '\0';
   nd_cutoff_date.arr[nd_cutoff_date.len]          = '\0';
   nd_order.arr[nd_order.len]                      = '\0';
   nd_pat_details.arr[nd_pat_details.len]          = '\0';
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

  
  
}

open_files()
{
  //char file_name[50], err_stmt[70];  
  char err_stmt[70];

   if (nd_rep_type.arr[0] == 'P')
     {
		//strcpy(filename,"arragrdp.lis");
		//strcat(filename,"arragrdp.lis");
		//strcpy(OUTPUT_FILE_NAME, "arragrdp.lis");
		strcat(filename,OUTPUT_FILE_NAME);
     }
   else if (nd_rep_type.arr[0] == 'C')
     {
		//strcpy(filename,"arragrdc.lis");
		//strcat(filename,"arragrdc.lis");
		//strcpy(OUTPUT_FILE_NAME, "arragrdc.lis");
		  strcat(filename,OUTPUT_FILE_NAME);
     }
   else if (nd_rep_type.arr[0] == 'S')
     {
		//strcpy(filename,"arragrds.lis");
		//strcat(filename,"arragrds.lis");
		//strcpy(OUTPUT_FILE_NAME, "arragrds.lis");
		  strcat(filename,OUTPUT_FILE_NAME);
     }

   if ((fp = fopen(filename,"w")) == NULL)
   {
        sprintf(err_stmt,"Error while opening File %s",filename);
        err_mesg(err_stmt,0,"");
        proc_exit();
   }

   print_title();
   print_head();

} 

print_title() 
{ 
 void print_hospital_name();  
{ 
  if (nd_rep_type.arr[0] == 'S')
  {
/*  fprintf(fp,
"\n\nMDL : AR                                          %-30s                                                      %-15s\n",
      hosp_name.arr,date_time.arr);*/ 
      fprintf(fp,"%cM",ESC); 
      fprintf(fp,"\n");
      print_hospital_name(151,"AR",hosp_name.arr,date_time.arr);

  }
  else if (nd_rep_type.arr[0] != 'S')
  {  
/*    fprintf(fp,
"\n\nMDL : AR                                          %-30s                                                %-15s\n",
      hosp_name.arr,date_time.arr);*/
       fprintf(fp,"%cM",ESC); 
       fprintf(fp,"\n");
       print_hospital_name(144,"AR",hosp_name.arr,date_time.arr);
  }


}
     fprintf(fp,

"OPR : %-10s                                            %s\n",
user_id.arr,(nd_rep_type.arr[0] == 'P')?"AGEING ANALYSIS REPORT":"");

{
  if (nd_rep_type.arr[0] == 'S')
  {
  fprintf(fp,
"REP : %-8s                                             %-28s                                                     PAGE : %4d\n",

    g_pgm_id,
    (nd_rep_type.arr[0] == 'P')? "(FOR PATIENT LEVEL ANALYSIS ONLY)":
     "    AGEING ANALYSIS REPORT",
     ++pctr);
  }
  else if (nd_rep_type.arr[0] != 'S')
 {
   fprintf(fp,
"REP : %-8s                                          %-28s                                            PAGE : %4d\n",
    g_pgm_id,
    (nd_rep_type.arr[0] == 'P')? "(FOR PATIENT LEVEL ANALYSIS ONLY)":
     "     AGEING ANALYSIS REPORT      ",
     ++pctr);

 }
} 
 {
  if (nd_rep_type.arr[0] != 'S')
  {
fprintf(fp,
"------------------------------------------------------------------------------------------------------------------------------------------------\n");
  }
  else if (nd_rep_type.arr[0] == 'S')
  {
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
  }
 }
//fprintf(fp,"VER : 1.10.01\n");
  fflush(fp);

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");

/*fprintf(fp,"                REPORT ORDER        : %-10s\n\n",
(nd_order.arr[0]  =='C')?"CUST CODE":"ALPHA CODE");

fprintf(fp,"                %-10s     FROM : %-10s\n",
(nd_order.arr[0]  =='C')?"CUST CODE":"ALPHA CODE",
(nd_order.arr[0]  =='C')?nd_fm_cust_code.arr:nd_fm_alpha_code.arr); 

fprintf(fp,"                %-10s     TO   : %-10s\n\n","",
(nd_order.arr[0]  =='C')?nd_to_cust_code.arr:nd_to_alpha_code.arr); */


   

 if (nd_order.arr[0]  =='C')
 {
    fprintf(fp,"                REPORT ORDER        : CUST CODE\n\n");
    fprintf(fp,"                CUST CODE  FROM     : %-10s\n",nd_fm_cust_code.arr );
	fprintf(fp,"                             TO     : %-10s\n\n",nd_to_cust_code.arr);
 }
 if (nd_order.arr[0]  =='A')
 {
    fprintf(fp,"                REPORT ORDER        : ALPHA CODE\n\n");
    fprintf(fp,"                ALPHA CODE  FROM    : %-10s \n",nd_fm_alpha_code.arr );
	fprintf(fp,"                              TO    : %-10s\n\n", nd_to_alpha_code.arr);
 }
 if (nd_order.arr[0]  =='O')
 {
    fprintf(fp,"                REPORT ORDER        : OUTSTANDING AMOUNT\n\n");
    fprintf(fp,"                CUST CODE FROM      : %-10s\n",nd_fm_cust_code.arr );
	fprintf(fp,"                            TO      : %-10s\n\n",nd_to_cust_code.arr);
 }

fprintf(fp,"                CUST TYPE      FROM : %s\n",nd_fm_cust_type.arr);
fprintf(fp,"                               TO   : %s\n\n",nd_to_cust_type.arr);
fprintf(fp,"                CUST GROUP     FROM : %s\n",nd_fm_cust_group.arr);
fprintf(fp,"                               TO   : %s\n\n",nd_to_cust_group.arr);
fprintf(fp,"                ANALYSIS CODE1 FROM : %s\n",nd_fm_anal_cd1.arr);
fprintf(fp,"                               TO   : %s\n\n",nd_to_anal_cd1.arr);
fprintf(fp,"                ANALYSIS CODE2 FROM : %s\n",nd_fm_anal_cd2.arr);
fprintf(fp,"                               TO   : %s\n\n",nd_to_anal_cd2.arr);
fprintf(fp,"                ANALYSIS CODE3 FROM : %s\n",nd_fm_anal_cd3.arr);
fprintf(fp,"                               TO   : %s\n\n",nd_to_anal_cd3.arr);

fprintf(fp,"                AGEING           BY : %s\n\n",
(nd_age_method.arr[0]  =='D')?"DUE DATE":"BASE DATE"); 
fprintf(fp,"                CUT-OFF DATE        : %s\n\n",pr_cutoff_date.arr);
fprintf(fp,"                AGEING SLOT 1(DAYS) : %d\n\n",nd_age_slot1);
fprintf(fp,"                AGEING SLOT 2(DAYS) : %d\n\n",nd_age_slot2);
fprintf(fp,"                AGEING SLOT 3(DAYS) : %d\n\n",nd_age_slot3);
fprintf(fp,"                REPORT TYPE         : %s\n\n",
   (nd_rep_type.arr[0] == 'P' || nd_rep_type.arr[0] == 'C')?"DETAIL":"SUMMARY");
fprintf(fp,"                PATIENT DETAILS     : %s\n\n",
   (nd_rep_type.arr[0] == 'P')?"PATIENT LEVEL ANALYSIS":(nd_rep_type.arr[0] == 'C')? 
   "ALL CUSTOMERS":
   (nd_pat_details.arr[0] =='Y')?"PATIENT LEVEL ANALYSIS":"ALL CUSTOMERS");

  fflush(fp);
}

    
print_head()  
{
 {
  void print_hospital_name();
  if (nd_rep_type.arr[0] == 'S')
  {
  /*  
fprintf(fp,
"\fMDL : AR                                          %-30s                                                      %-15s\n",
      hosp_name.arr,date_time.arr);
  */
      fprintf(fp,"%cM",ESC); 
      fprintf(fp,"\f");
      print_hospital_name(151,"AR",hosp_name.arr,date_time.arr);

     fprintf(fp,
"OPR : %-10s                                   %s\n",
user_id.arr,(nd_rep_type.arr[0] == 'P')?"AGEING ANALYSIS REPORT":"");
  fprintf(fp,
"REP : %-8s                                           %-28s                                                       PAGE : %4d\n",
    g_pgm_id,
    (nd_rep_type.arr[0] == 'P')?"(FOR PATIENT LEVEL ANALYSIS ONLY)":
                                "      AGEING ANALYSIS REPORT",
    ++pctr);
  } 
  else if (nd_rep_type.arr[0] != 'S')
  {
 
/*  fprintf(fp,
"\fMDL : AR                                          %-30s                                                %-15s\n",
      hosp_name.arr,date_time.arr);*/
    fprintf(fp,"%cM",ESC); 
    fprintf(fp,"\f");
    print_hospital_name(144,"AR",hosp_name.arr,date_time.arr);


     fprintf(fp,
"OPR : %-10s                                            %s\n",
user_id.arr,(nd_rep_type.arr[0] == 'P')?"AGEING ANALYSIS REPORT":"");

  fprintf(fp,
"REP : %-8s                                          %-28s                                            PAGE : %4d\n\n",
    g_pgm_id,
    (nd_rep_type.arr[0] == 'P')?"(FOR PATIENT LEVEL ANALYSIS ONLY)":
                                "     AGEING ANALYSIS REPORT      ",
    ++pctr);
  }
 } 
//fprintf(fp,
//"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

  if (nd_rep_type.arr[0] != 'S')
  { 
fprintf(fp,
"------------------------------------------------------------------------------------------------------------------------------------------------\n");
 
fprintf(fp,
"DOC TYPE & NO   BASE DATE     OUTSTANDING    NOT YET DUE    OPEN CREDIT  REFERENCE        DUE DATE      AGE SLOT 1     AGE SLOT 2     AGE SLOT 3\n");
fprintf(fp,
"                                   AMOUNT         AMOUNT                                              %3d-%-3d DAYS    %3d-%-3d DAYS  %3d-%-3d DAYS\n",
     0, nd_age_slot1,
     nd_age_slot1+1, nd_age_slot2,
     nd_age_slot2+1, nd_age_slot3);
fprintf(fp,
"                                                                                                                                     & above\n");                                                          
fprintf(fp,
"------------------------------------------------------------------------------------------------------------------------------------------------\n");

   } 
   else
   {
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------------------------\n");

/* -- Only for Alpha the legend Alphacode should be there and for customer
      It should not be there VSK 26/10/1998 ---- */
 
if (nd_order.arr[0] != 'A')
{

fprintf(fp,
"CUSTOMER CUSTOMER NAME                                           OUTSTANDING    NOT YET DUE           OPEN     AGE SLOT 1     AGE SLOT 2     AGE SLOT 3\n");

fprintf(fp,
"CODE                                                                  AMOUNT         AMOUNT         CREDIT   %3d-%-3d DAYS   %3d-%-3d DAYS   %3d-%-3d DAYS\n",
     0, nd_age_slot1,
     nd_age_slot1+1, nd_age_slot2,
     nd_age_slot2+1, nd_age_slot3);
fprintf(fp,
"                                                                                                                                            & above\n");                                                          
}
if (nd_order.arr[0] == 'A'){

fprintf(fp,
"CUSTOMER CUSTOMER NAME                             ALPHA         OUTSTANDING    NOT YET DUE           OPEN     AGE SLOT 1     AGE SLOT 2     AGE SLOT 3\n");

fprintf(fp,
"CODE                                               CODE               AMOUNT         AMOUNT         CREDIT   %3d-%-3d DAYS   %3d-%-3d DAYS   %3d-%-3d DAYS\n",
     0, nd_age_slot1,
     nd_age_slot1+1, nd_age_slot2,
     nd_age_slot2+1, nd_age_slot3);
fprintf(fp,
"                                                                                                                                            & above\n");                                                          
}

fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
   }
 
//fprintf(fp,
//"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

  fflush(fp);
  lctr = 9;
}


/**********************************
print_title() 
{ 

{ 
if (nd_rep_type.arr[0] == 'S')
  {
  fprintf(fp,
"\n\nMDL : AR                                         %-30s                                                                                   %-15s\n",
      hosp_name.arr,date_time.arr);
  }
  else if (nd_rep_type.arr[0] != 'S')
  {  
    fprintf(fp,
"\n\nMDL : AR                                         %-30s                                             %-15s\n",
      hosp_name.arr,date_time.arr);
  }
}  
     fprintf(fp,
"OPR : %-10s                                   %s\n",
user_id.arr,(nd_rep_type.arr[0] == 'P')?"AGEING ANALYSIS REPORT":"");
{
  if (nd_rep_type.arr[0] == 'S')
  {
  fprintf(fp,
"REP : %-8s                                 %-28s                                                                                             PAGE : %4d\n",
    g_pgm_id,
    (nd_rep_type.arr[0] == 'P')? "(FOR PATIENT LEVEL ANALYSIS ONLY)":
     "     AGEING ANALYSIS REPORT",
     ++pctr);
  }
  else if (nd_rep_type.arr[0] != 'S')
 {
   fprintf(fp,
"REP : %-8s                                  %-28s                                                   PAGE : %4d\n",
    g_pgm_id,
    (nd_rep_type.arr[0] == 'P')? "(FOR PATIENT LEVEL ANALYSIS ONLY)":
     "     AGEING ANALYSIS REPORT",
     ++pctr);
 }
} 
 {
  if (nd_rep_type.arr[0] != 'S')
  {
fprintf(fp,
"------------------------------------------------------------------------------------------------------------------------------------------------\n");
  }
  else if (nd_rep_type.arr[0] == 'S')
  {
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
  }
 }
fprintf(fp,"VER : 1.10.01\n");
  fflush(fp);

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");
fprintf(fp,"                REPORT ORDER        : %-10s\n\n",
(nd_order.arr[0]  =='C')?"CUST CODE":"ALPHA CODE");
fprintf(fp,"                %-10s     FROM : %-10s\n",
(nd_order.arr[0]  =='C')?"CUST CODE":"ALPHA CODE",
(nd_order.arr[0]  =='C')?nd_fm_cust_code.arr:nd_fm_alpha_code.arr); 
fprintf(fp,"                %-10s     TO   : %-10s\n\n","",
(nd_order.arr[0]  =='C')?nd_to_cust_code.arr:nd_to_alpha_code.arr); 



fprintf(fp,"                CUST TYPE      FROM : %s\n",nd_fm_cust_type.arr);
fprintf(fp,"                               TO   : %s\n\n",nd_to_cust_type.arr);
fprintf(fp,"                CUST GROUP     FROM : %s\n",nd_fm_cust_group.arr);
fprintf(fp,"                               TO   : %s\n\n",nd_to_cust_group.arr);
fprintf(fp,"                ANALYSIS CODE1 FROM : %s\n",nd_fm_anal_cd1.arr);
fprintf(fp,"                               TO   : %s\n\n",nd_to_anal_cd1.arr);
fprintf(fp,"                ANALYSIS CODE2 FROM : %s\n",nd_fm_anal_cd2.arr);
fprintf(fp,"                               TO   : %s\n\n",nd_to_anal_cd2.arr);
fprintf(fp,"                ANALYSIS CODE3 FROM : %s\n",nd_fm_anal_cd3.arr);
fprintf(fp,"                               TO   : %s\n\n",nd_to_anal_cd3.arr);


fprintf(fp,"                AGEING           BY : %s\n\n",
(nd_age_method.arr[0]  =='D')?"DUE DATE":"BASE DATE"); 
fprintf(fp,"                CUT-OFF DATE        : %s\n\n",pr_cutoff_date.arr);
fprintf(fp,"                AGEING SLOT 1(DAYS) : %d\n\n",nd_age_slot1);
fprintf(fp,"                AGEING SLOT 2(DAYS) : %d\n\n",nd_age_slot2);
fprintf(fp,"                AGEING SLOT 3(DAYS) : > %d\n\n",nd_age_slot2);
fprintf(fp,"                REPORT TYPE         : %s\n\n",
   (nd_rep_type.arr[0] == 'P' || nd_rep_type.arr[0] == 'C')?"DETAIL":"SUMMARY");
fprintf(fp,"                PATIENT DETAILS     : %s\n\n",
   (nd_rep_type.arr[0] == 'P')?"PATIENT LEVEL ANALYSIS":(nd_rep_type.arr[0] == 'C')?
   "ALL CUSTOMERS":
   (nd_pat_details.arr[0] =='Y')?"PATIENT LEVEL ANALYSIS":"ALL CUSTOMERS");

  fflush(fp);
}
   
print_head()
{
 {
  if (nd_rep_type.arr[0] == 'S')
  {
  fprintf(fp,
"\fMDL : AR                                         %-30s                                                                                   %-15s\n",
      hosp_name.arr,date_time.arr);
     fprintf(fp,
"OPR : %-10s                                   %s\n",
user_id.arr,(nd_rep_type.arr[0] == 'P')?"AGEING ANALYSIS REPORT":"");
  fprintf(fp,
"REP : %-8s                                  %-28s                                                                                           PAGE : %4d\n",
    g_pgm_id,
    (nd_rep_type.arr[0] == 'P')?"(FOR PATIENT LEVEL ANALYSIS ONLY)":
                                "     AGEING ANALYSIS REPORT",
    ++pctr);
  }
  else if (nd_rep_type.arr[0] != 'S')
  {
  fprintf(fp,
"\fMDL : AR                                         %-30s                                      %-15s\n",
      hosp_name.arr,date_time.arr);
     fprintf(fp,
"OPR : %-10s                                   %s\n",
user_id.arr,(nd_rep_type.arr[0] == 'P')?"AGEING ANALYSIS REPORT":"");
  fprintf(fp,
"REP : %-8s                                  %-28s                                              PAGE : %4d\n",
    g_pgm_id,
    (nd_rep_type.arr[0] == 'P')?"(FOR PATIENT LEVEL ANALYSIS ONLY)":
                                "     AGEING ANALYSIS REPORT",
    ++pctr);
  }
 }
//fprintf(fp,
//"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

  if (nd_rep_type.arr[0] != 'S')
  {
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------------------------\n");

fprintf(fp,
"DOC TYPE & NO   BASE DATE        OUTSTANDING    NOT YET DUE           OPEN     AGE SLOT 1     AGE SLOT 2     AGE SLOT 3\n");
fprintf(fp,
"REFERENCE        DUE DATE             AMOUNT         AMOUNT         CREDIT   %3d-%-3d DAYS   %3d-%-3d DAYS   > %-3d DAYS\n",
     0, nd_age_slot1,
     nd_age_slot1, nd_age_slot2,
     nd_age_slot2, nd_age_slot3);

fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------------------------\n");

   }
   else
   {
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

fprintf(fp,
"CUSTOMER                                                         OUTSTANDING    NOT YET DUE           OPEN     AGE SLOT 1     AGE SLOT 2     AGE SLOT 3\n");
fprintf(fp,
"CODE                                                                  AMOUNT         AMOUNT         CREDIT   %3d-%-3d DAYS   %3d-%-3d DAYS   > %-3d DAYS\n",
     0, nd_age_slot1,
     nd_age_slot1, nd_age_slot2,
     nd_age_slot2, nd_age_slot3);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
   }

//fprintf(fp,
//"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

  fflush(fp);
  lctr = 8;
}
*********************************************/


print_end()   
{
fprintf(fp,
"\n\n\n                                                              **   END  OF  REPORT   ** \n\n");
fprintf(fp,"%c@",ESC);
  fflush(fp);
  fclose(fp);
}

declare_cursors()
{
   if (nd_rep_type.arr[0] == 'P' || nd_rep_type.arr[0] == 'C')
   {
      if (nd_order.arr[0]  =='C')
      {
         /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
                   SELECT CUST_CODE, LONG_NAME, CUST_ALPHA_CODE
                     FROM AR_CUSTOMER
                    WHERE CUST_CODE BETWEEN NVL(:nd_fm_cust_code,'        ')
                      AND NVL(:nd_to_cust_code,'~~~~~~~~')
                      AND (
					        :nd_pat_details = 'N'
                       OR   NVL(PAT_COM_FLAG,'N') = 'Y'
                           )
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


         /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 24;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = sq0005;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )197;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&nd_fm_cust_code;
         sqlstm.sqhstl[0] = (unsigned int  )14;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&nd_to_cust_code;
         sqlstm.sqhstl[1] = (unsigned int  )14;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&nd_pat_details;
         sqlstm.sqhstl[2] = (unsigned int  )5;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&nd_fm_cust_type;
         sqlstm.sqhstl[3] = (unsigned int  )5;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&nd_to_cust_type;
         sqlstm.sqhstl[4] = (unsigned int  )5;
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&nd_fm_cust_group;
         sqlstm.sqhstl[5] = (unsigned int  )5;
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&nd_to_cust_group;
         sqlstm.sqhstl[6] = (unsigned int  )5;
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&nd_fm_anal_cd1;
         sqlstm.sqhstl[7] = (unsigned int  )11;
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&nd_to_anal_cd1;
         sqlstm.sqhstl[8] = (unsigned int  )11;
         sqlstm.sqhsts[8] = (         int  )0;
         sqlstm.sqindv[8] = (         void  *)0;
         sqlstm.sqinds[8] = (         int  )0;
         sqlstm.sqharm[8] = (unsigned int  )0;
         sqlstm.sqadto[8] = (unsigned short )0;
         sqlstm.sqtdso[8] = (unsigned short )0;
         sqlstm.sqhstv[9] = (         void  *)&nd_fm_anal_cd2;
         sqlstm.sqhstl[9] = (unsigned int  )11;
         sqlstm.sqhsts[9] = (         int  )0;
         sqlstm.sqindv[9] = (         void  *)0;
         sqlstm.sqinds[9] = (         int  )0;
         sqlstm.sqharm[9] = (unsigned int  )0;
         sqlstm.sqadto[9] = (unsigned short )0;
         sqlstm.sqtdso[9] = (unsigned short )0;
         sqlstm.sqhstv[10] = (         void  *)&nd_to_anal_cd2;
         sqlstm.sqhstl[10] = (unsigned int  )11;
         sqlstm.sqhsts[10] = (         int  )0;
         sqlstm.sqindv[10] = (         void  *)0;
         sqlstm.sqinds[10] = (         int  )0;
         sqlstm.sqharm[10] = (unsigned int  )0;
         sqlstm.sqadto[10] = (unsigned short )0;
         sqlstm.sqtdso[10] = (unsigned short )0;
         sqlstm.sqhstv[11] = (         void  *)&nd_fm_anal_cd3;
         sqlstm.sqhstl[11] = (unsigned int  )11;
         sqlstm.sqhsts[11] = (         int  )0;
         sqlstm.sqindv[11] = (         void  *)0;
         sqlstm.sqinds[11] = (         int  )0;
         sqlstm.sqharm[11] = (unsigned int  )0;
         sqlstm.sqadto[11] = (unsigned short )0;
         sqlstm.sqtdso[11] = (unsigned short )0;
         sqlstm.sqhstv[12] = (         void  *)&nd_to_anal_cd3;
         sqlstm.sqhstl[12] = (unsigned int  )11;
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
            err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR",0,"");
      }
      if (nd_order.arr[0]  =='A')
      {
         /* EXEC SQL DECLARE AR_CUSTOMER_CUR_ALPH CURSOR FOR
                   SELECT CUST_CODE, LONG_NAME, CUST_ALPHA_CODE
                     FROM AR_CUSTOMER
                    WHERE CUST_ALPHA_CODE BETWEEN NVL(:nd_fm_alpha_code,'        ')
                      AND NVL(:nd_to_alpha_code,'~~~~~~~~')
                      AND (
					        :nd_pat_details = 'N'
                       OR   NVL(PAT_COM_FLAG,'N') = 'Y'
                          )
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


         /* EXEC SQL OPEN AR_CUSTOMER_CUR_ALPH; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 24;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = sq0006;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )264;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&nd_fm_alpha_code;
         sqlstm.sqhstl[0] = (unsigned int  )13;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&nd_to_alpha_code;
         sqlstm.sqhstl[1] = (unsigned int  )13;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&nd_pat_details;
         sqlstm.sqhstl[2] = (unsigned int  )5;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&nd_fm_cust_type;
         sqlstm.sqhstl[3] = (unsigned int  )5;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&nd_to_cust_type;
         sqlstm.sqhstl[4] = (unsigned int  )5;
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&nd_fm_cust_group;
         sqlstm.sqhstl[5] = (unsigned int  )5;
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&nd_to_cust_group;
         sqlstm.sqhstl[6] = (unsigned int  )5;
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&nd_fm_anal_cd1;
         sqlstm.sqhstl[7] = (unsigned int  )11;
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&nd_to_anal_cd1;
         sqlstm.sqhstl[8] = (unsigned int  )11;
         sqlstm.sqhsts[8] = (         int  )0;
         sqlstm.sqindv[8] = (         void  *)0;
         sqlstm.sqinds[8] = (         int  )0;
         sqlstm.sqharm[8] = (unsigned int  )0;
         sqlstm.sqadto[8] = (unsigned short )0;
         sqlstm.sqtdso[8] = (unsigned short )0;
         sqlstm.sqhstv[9] = (         void  *)&nd_fm_anal_cd2;
         sqlstm.sqhstl[9] = (unsigned int  )11;
         sqlstm.sqhsts[9] = (         int  )0;
         sqlstm.sqindv[9] = (         void  *)0;
         sqlstm.sqinds[9] = (         int  )0;
         sqlstm.sqharm[9] = (unsigned int  )0;
         sqlstm.sqadto[9] = (unsigned short )0;
         sqlstm.sqtdso[9] = (unsigned short )0;
         sqlstm.sqhstv[10] = (         void  *)&nd_to_anal_cd2;
         sqlstm.sqhstl[10] = (unsigned int  )11;
         sqlstm.sqhsts[10] = (         int  )0;
         sqlstm.sqindv[10] = (         void  *)0;
         sqlstm.sqinds[10] = (         int  )0;
         sqlstm.sqharm[10] = (unsigned int  )0;
         sqlstm.sqadto[10] = (unsigned short )0;
         sqlstm.sqtdso[10] = (unsigned short )0;
         sqlstm.sqhstv[11] = (         void  *)&nd_fm_anal_cd3;
         sqlstm.sqhstl[11] = (unsigned int  )11;
         sqlstm.sqhsts[11] = (         int  )0;
         sqlstm.sqindv[11] = (         void  *)0;
         sqlstm.sqinds[11] = (         int  )0;
         sqlstm.sqharm[11] = (unsigned int  )0;
         sqlstm.sqadto[11] = (unsigned short )0;
         sqlstm.sqtdso[11] = (unsigned short )0;
         sqlstm.sqhstv[12] = (         void  *)&nd_to_anal_cd3;
         sqlstm.sqhstl[12] = (unsigned int  )11;
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
             err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR_ALPH",0,"");
      }
	  if (nd_order.arr[0]  =='O')
      {
/*

         EXEC SQL DECLARE AR_CUSTOMER_CUR_OUTSTG CURSOR FOR
                     SELECT CUST_CODE, LONG_NAME, CUST_ALPHA_CODE
                     FROM AR_CUSTOMER
                    WHERE CUST_CODE BETWEEN NVL(:nd_fm_cust_code,'        ')
                      AND NVL(:nd_to_cust_code,'~~~~~~~~')
                      AND (:nd_pat_details = 'N'
                       OR NVL(PAT_COM_FLAG,'N') = 'Y'
                         )
                     ORDER BY OUTSTANDING_BALANCE_AMT DESC;
*/
         /* EXEC SQL DECLARE AR_CUSTOMER_CUR_OUTSTG CURSOR FOR
					SELECT A.CUST_CODE, A.LONG_NAME, A.CUST_ALPHA_CODE , SUM(B.PENDING_AMT)
					FROM AR_CUSTOMER A, AR_PENDING_DOC B
					WHERE A.CUST_CODE = B.CUST_CODE
					AND A.CUST_CODE BETWEEN NVL(:nd_fm_cust_code,'        ')
					AND NVL(:nd_to_cust_code,'~~~~~~~~')
					AND (:nd_pat_details = 'N'
					OR NVL(A.PAT_COM_FLAG,'N') = 'Y'    )
					GROUP BY A.CUST_CODE,A.LONG_NAME,A.CUST_ALPHA_CODE
					HAVING SUM(B.PENDING_AMT) != 0
					ORDER BY 4  DESC; */ 

         /* EXEC SQL OPEN AR_CUSTOMER_CUR_OUTSTG; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 24;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = sq0007;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )331;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&nd_fm_cust_code;
         sqlstm.sqhstl[0] = (unsigned int  )14;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&nd_to_cust_code;
         sqlstm.sqhstl[1] = (unsigned int  )14;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&nd_pat_details;
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
             err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR_OUTSTG",0,"");
      }
   }
   else
   {
      if (nd_order.arr[0]  =='C')
      {
         /* EXEC SQL DECLARE AR_CUSTOMER_CUR_SUM CURSOR FOR
                   SELECT CUST_CODE, LONG_NAME, CUST_ALPHA_CODE
                     FROM AR_CUSTOMER
                    WHERE CUST_CODE BETWEEN NVL(:nd_fm_cust_code,'        ')
                      AND NVL(:nd_to_cust_code,'~~~~~~~~')
                      AND (
					        :nd_pat_details = 'N'
                       OR   NVL(PAT_COM_FLAG,'N') = 'Y'
                           )
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


         /* EXEC SQL OPEN AR_CUSTOMER_CUR_SUM; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 24;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = sq0008;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )358;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&nd_fm_cust_code;
         sqlstm.sqhstl[0] = (unsigned int  )14;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&nd_to_cust_code;
         sqlstm.sqhstl[1] = (unsigned int  )14;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&nd_pat_details;
         sqlstm.sqhstl[2] = (unsigned int  )5;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&nd_fm_cust_type;
         sqlstm.sqhstl[3] = (unsigned int  )5;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&nd_to_cust_type;
         sqlstm.sqhstl[4] = (unsigned int  )5;
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&nd_fm_cust_group;
         sqlstm.sqhstl[5] = (unsigned int  )5;
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&nd_to_cust_group;
         sqlstm.sqhstl[6] = (unsigned int  )5;
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&nd_fm_anal_cd1;
         sqlstm.sqhstl[7] = (unsigned int  )11;
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&nd_to_anal_cd1;
         sqlstm.sqhstl[8] = (unsigned int  )11;
         sqlstm.sqhsts[8] = (         int  )0;
         sqlstm.sqindv[8] = (         void  *)0;
         sqlstm.sqinds[8] = (         int  )0;
         sqlstm.sqharm[8] = (unsigned int  )0;
         sqlstm.sqadto[8] = (unsigned short )0;
         sqlstm.sqtdso[8] = (unsigned short )0;
         sqlstm.sqhstv[9] = (         void  *)&nd_fm_anal_cd2;
         sqlstm.sqhstl[9] = (unsigned int  )11;
         sqlstm.sqhsts[9] = (         int  )0;
         sqlstm.sqindv[9] = (         void  *)0;
         sqlstm.sqinds[9] = (         int  )0;
         sqlstm.sqharm[9] = (unsigned int  )0;
         sqlstm.sqadto[9] = (unsigned short )0;
         sqlstm.sqtdso[9] = (unsigned short )0;
         sqlstm.sqhstv[10] = (         void  *)&nd_to_anal_cd2;
         sqlstm.sqhstl[10] = (unsigned int  )11;
         sqlstm.sqhsts[10] = (         int  )0;
         sqlstm.sqindv[10] = (         void  *)0;
         sqlstm.sqinds[10] = (         int  )0;
         sqlstm.sqharm[10] = (unsigned int  )0;
         sqlstm.sqadto[10] = (unsigned short )0;
         sqlstm.sqtdso[10] = (unsigned short )0;
         sqlstm.sqhstv[11] = (         void  *)&nd_fm_anal_cd3;
         sqlstm.sqhstl[11] = (unsigned int  )11;
         sqlstm.sqhsts[11] = (         int  )0;
         sqlstm.sqindv[11] = (         void  *)0;
         sqlstm.sqinds[11] = (         int  )0;
         sqlstm.sqharm[11] = (unsigned int  )0;
         sqlstm.sqadto[11] = (unsigned short )0;
         sqlstm.sqtdso[11] = (unsigned short )0;
         sqlstm.sqhstv[12] = (         void  *)&nd_to_anal_cd3;
         sqlstm.sqhstl[12] = (unsigned int  )11;
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
            err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR_SUM",0,"");
      }
      if (nd_order.arr[0]  =='A')
      {
         /* EXEC SQL DECLARE AR_CUSTOMER_CUR_ALPH_SUM CURSOR FOR
                   SELECT CUST_CODE, LONG_NAME, CUST_ALPHA_CODE
                     FROM AR_CUSTOMER
                    WHERE CUST_ALPHA_CODE BETWEEN NVL(:nd_fm_alpha_code,'        ')
                      AND NVL(:nd_to_alpha_code,'~~~~~~~~')
                      AND (
					        :nd_pat_details = 'N'
                       OR NVL(PAT_COM_FLAG,'N') = 'Y'
                          )
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


         /* EXEC SQL OPEN AR_CUSTOMER_CUR_ALPH_SUM; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 24;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = sq0009;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )425;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&nd_fm_alpha_code;
         sqlstm.sqhstl[0] = (unsigned int  )13;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&nd_to_alpha_code;
         sqlstm.sqhstl[1] = (unsigned int  )13;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&nd_pat_details;
         sqlstm.sqhstl[2] = (unsigned int  )5;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&nd_fm_cust_type;
         sqlstm.sqhstl[3] = (unsigned int  )5;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&nd_to_cust_type;
         sqlstm.sqhstl[4] = (unsigned int  )5;
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&nd_fm_cust_group;
         sqlstm.sqhstl[5] = (unsigned int  )5;
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&nd_to_cust_group;
         sqlstm.sqhstl[6] = (unsigned int  )5;
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&nd_fm_anal_cd1;
         sqlstm.sqhstl[7] = (unsigned int  )11;
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&nd_to_anal_cd1;
         sqlstm.sqhstl[8] = (unsigned int  )11;
         sqlstm.sqhsts[8] = (         int  )0;
         sqlstm.sqindv[8] = (         void  *)0;
         sqlstm.sqinds[8] = (         int  )0;
         sqlstm.sqharm[8] = (unsigned int  )0;
         sqlstm.sqadto[8] = (unsigned short )0;
         sqlstm.sqtdso[8] = (unsigned short )0;
         sqlstm.sqhstv[9] = (         void  *)&nd_fm_anal_cd2;
         sqlstm.sqhstl[9] = (unsigned int  )11;
         sqlstm.sqhsts[9] = (         int  )0;
         sqlstm.sqindv[9] = (         void  *)0;
         sqlstm.sqinds[9] = (         int  )0;
         sqlstm.sqharm[9] = (unsigned int  )0;
         sqlstm.sqadto[9] = (unsigned short )0;
         sqlstm.sqtdso[9] = (unsigned short )0;
         sqlstm.sqhstv[10] = (         void  *)&nd_to_anal_cd2;
         sqlstm.sqhstl[10] = (unsigned int  )11;
         sqlstm.sqhsts[10] = (         int  )0;
         sqlstm.sqindv[10] = (         void  *)0;
         sqlstm.sqinds[10] = (         int  )0;
         sqlstm.sqharm[10] = (unsigned int  )0;
         sqlstm.sqadto[10] = (unsigned short )0;
         sqlstm.sqtdso[10] = (unsigned short )0;
         sqlstm.sqhstv[11] = (         void  *)&nd_fm_anal_cd3;
         sqlstm.sqhstl[11] = (unsigned int  )11;
         sqlstm.sqhsts[11] = (         int  )0;
         sqlstm.sqindv[11] = (         void  *)0;
         sqlstm.sqinds[11] = (         int  )0;
         sqlstm.sqharm[11] = (unsigned int  )0;
         sqlstm.sqadto[11] = (unsigned short )0;
         sqlstm.sqtdso[11] = (unsigned short )0;
         sqlstm.sqhstv[12] = (         void  *)&nd_to_anal_cd3;
         sqlstm.sqhstl[12] = (unsigned int  )11;
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
             err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR_ALPH_SUM",0,"");
      }
      if (nd_order.arr[0]  =='O')
      {
/*
         EXEC SQL DECLARE AR_CUSTOMER_CUR_OUTSTG_SUM CURSOR FOR
                   SELECT CUST_CODE, LONG_NAME, CUST_ALPHA_CODE
                     FROM AR_CUSTOMER
                    WHERE CUST_CODE BETWEEN NVL(:nd_fm_cust_code,'        ')
                      AND NVL(:nd_to_cust_code,'~~~~~~~~')
                      AND 
                         (:nd_pat_details = 'N'
                       OR NVL(PAT_COM_FLAG,'N') = 'Y'
                         )
                    ORDER BY OUTSTANDING_BALANCE_AMT DESC;

*/
         /* EXEC SQL DECLARE AR_CUSTOMER_CUR_OUTSTG_SUM CURSOR FOR
				SELECT A.CUST_CODE, A.LONG_NAME, A.CUST_ALPHA_CODE , SUM(B.PENDING_AMT)
				FROM AR_CUSTOMER A, AR_PENDING_DOC B
				WHERE A.CUST_CODE = B.CUST_CODE
				AND A.CUST_CODE BETWEEN NVL(:nd_fm_cust_code,'        ')
				AND NVL(:nd_to_cust_code,'~~~~~~~~')
				AND (:nd_pat_details = 'N'
				OR NVL(A.PAT_COM_FLAG,'N') = 'Y' )
				GROUP BY A.CUST_CODE,A.LONG_NAME,A.CUST_ALPHA_CODE
				HAVING SUM(B.PENDING_AMT) != 0
				ORDER BY 4  DESC; */ 

         /* EXEC SQL OPEN AR_CUSTOMER_CUR_OUTSTG_SUM; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 24;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = sq0010;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )492;
         sqlstm.selerr = (unsigned short)1;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&nd_fm_cust_code;
         sqlstm.sqhstl[0] = (unsigned int  )14;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&nd_to_cust_code;
         sqlstm.sqhstl[1] = (unsigned int  )14;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&nd_pat_details;
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
            err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR_OUTSTG_SUM",0,"");
      }

   }

   if (nd_rep_type.arr[0] == 'P')
   {
         /* EXEC SQL DECLARE AR_PEND_CUR CURSOR FOR
                   SELECT DOC_TYPE_CODE,
                          DOC_NUM,
                          TO_CHAR(NVL(BASE_DATE,DOC_DATE),'DD/MM/YYYY'),
                          TO_CHAR(DUE_DATE,'DD/MM/YYYY'),
                          NVL(PENDING_AMT,0),
                          SIGN(PENDING_AMT),
                         DECODE(SIGN(NVL(PENDING_AMT,0)),-1,-NVL(PENDING_AMT,0),
                                NVL(PENDING_AMT,0)),
                          CUST_REF,
                          PATIENT_ID, 
               CEIL(NVL(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'),SYSDATE) - NVL(BASE_DATE,DOC_DATE)),
               CEIL(NVL(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'),SYSDATE) - DUE_DATE)
                    FROM  AR_PENDING_DOC
                   WHERE CUST_CODE = :ar_customer_cust_code
            /o       AND   PENDING_AMT != 0  o/ /o Commented by Venkat on 10/2/2000 o/
		   AND   NVL(DOC_DATE,SYSDATE) <= 
			     NVL(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'),SYSDATE)
                   ORDER  BY PATIENT_ID, DOC_TYPE_CODE, DOC_NUM; */ 

    }
    else
    {               
         
         /* EXEC SQL DECLARE AR_PEND_CUR_SUM CURSOR FOR
                   SELECT DOC_TYPE_CODE,
                          DOC_NUM,
                          TO_CHAR(NVL(BASE_DATE,DOC_DATE),'DD/MM/YYYY'),
                          TO_CHAR(DUE_DATE,'DD/MM/YYYY'),
                          NVL(PENDING_AMT,0),
                          SIGN(PENDING_AMT),
                         DECODE(SIGN(NVL(PENDING_AMT,0)),-1,-NVL(PENDING_AMT,0),
                                NVL(PENDING_AMT,0)),
                          CUST_REF,
                          PATIENT_ID, 
               CEIL(NVL(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'),SYSDATE) - NVL(BASE_DATE,DOC_DATE)),
               CEIL(NVL(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'),SYSDATE) - DUE_DATE)
                    FROM  AR_PENDING_DOC
                   WHERE CUST_CODE = :ar_customer_cust_code
             /o      AND   PENDING_AMT != 0  o/ /o Commented by Venkat on 10/2/2000 o/
		   AND   NVL(DOC_DATE,SYSDATE) <= 
			     NVL(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'),SYSDATE)
                   ORDER  BY DOC_TYPE_CODE, DOC_NUM; */ 

    }
        if (OERROR)
            err_mesg("DECLARE failed on table AR_PENDING_DOC",0,"");

}       


fetch_customer()
{

   ar_customer_cust_code.arr     [0] = '\0';
   ar_customer_long_name.arr     [0] = '\0';
   ar_customer_short_name.arr    [0] = '\0';
   ar_customer_alpha_code.arr    [0] = '\0';

   ar_customer_cust_code.len         = 0;
   ar_customer_long_name.len         = 0;
   ar_customer_short_name.len        = 0;
   ar_customer_alpha_code.len        = 0;

   if (nd_rep_type.arr[0] == 'P' || nd_rep_type.arr[0] == 'C')
   {
       if (nd_order.arr[0]  =='C')
       {
           /* EXEC SQL FETCH AR_CUSTOMER_CUR
                     INTO :ar_customer_cust_code, :ar_customer_long_name,
                          :ar_customer_alpha_code; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 24;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )519;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
           sqlstm.sqhstl[0] = (unsigned int  )11;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&ar_customer_long_name;
           sqlstm.sqhstl[1] = (unsigned int  )103;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&ar_customer_alpha_code;
           sqlstm.sqhstl[2] = (unsigned int  )13;
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
                 err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR",0,"");
        }
        if (nd_order.arr[0]  =='A')
        {
           /* EXEC SQL FETCH AR_CUSTOMER_CUR_ALPH
                     INTO :ar_customer_cust_code, :ar_customer_long_name,
                          :ar_customer_alpha_code; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 24;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )546;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
           sqlstm.sqhstl[0] = (unsigned int  )11;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&ar_customer_long_name;
           sqlstm.sqhstl[1] = (unsigned int  )103;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&ar_customer_alpha_code;
           sqlstm.sqhstl[2] = (unsigned int  )13;
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
               err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR_ALPH",0,"");
         }
		 if (nd_order.arr[0]  =='O')
         {
           /* EXEC SQL FETCH AR_CUSTOMER_CUR_OUTSTG
                     INTO :ar_customer_cust_code, :ar_customer_long_name,
                          :ar_customer_alpha_code,
						  :ar_customer_pend_amt_dummy; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 24;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )573;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
           sqlstm.sqhstl[0] = (unsigned int  )11;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&ar_customer_long_name;
           sqlstm.sqhstl[1] = (unsigned int  )103;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&ar_customer_alpha_code;
           sqlstm.sqhstl[2] = (unsigned int  )13;
           sqlstm.sqhsts[2] = (         int  )0;
           sqlstm.sqindv[2] = (         void  *)0;
           sqlstm.sqinds[2] = (         int  )0;
           sqlstm.sqharm[2] = (unsigned int  )0;
           sqlstm.sqadto[2] = (unsigned short )0;
           sqlstm.sqtdso[2] = (unsigned short )0;
           sqlstm.sqhstv[3] = (         void  *)&ar_customer_pend_amt_dummy;
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
                 err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR_OUTSTG",0,"");
         }
    }
    else
    {
       if (nd_order.arr[0]  =='C')
       {
           /* EXEC SQL FETCH AR_CUSTOMER_CUR_SUM
                     INTO :ar_customer_cust_code, :ar_customer_long_name,
                          :ar_customer_alpha_code; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 24;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )604;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
           sqlstm.sqhstl[0] = (unsigned int  )11;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&ar_customer_long_name;
           sqlstm.sqhstl[1] = (unsigned int  )103;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&ar_customer_alpha_code;
           sqlstm.sqhstl[2] = (unsigned int  )13;
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
                 err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR_SUM",0,"");
        }
        if (nd_order.arr[0]  =='A')
        {
           /* EXEC SQL FETCH AR_CUSTOMER_CUR_ALPH_SUM
                     INTO :ar_customer_cust_code, :ar_customer_long_name,
                          :ar_customer_alpha_code; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 24;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )631;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
           sqlstm.sqhstl[0] = (unsigned int  )11;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&ar_customer_long_name;
           sqlstm.sqhstl[1] = (unsigned int  )103;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&ar_customer_alpha_code;
           sqlstm.sqhstl[2] = (unsigned int  )13;
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
               err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR_ALPH_SUM",0,"");
         }
		 if (nd_order.arr[0]  =='O')
         {
           /* EXEC SQL FETCH AR_CUSTOMER_CUR_OUTSTG_SUM
                     INTO :ar_customer_cust_code, :ar_customer_long_name,
                          :ar_customer_alpha_code,
						  :ar_customer_pend_amt_dummy; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 10;
           sqlstm.arrsiz = 24;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )658;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)256;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&ar_customer_cust_code;
           sqlstm.sqhstl[0] = (unsigned int  )11;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&ar_customer_long_name;
           sqlstm.sqhstl[1] = (unsigned int  )103;
           sqlstm.sqhsts[1] = (         int  )0;
           sqlstm.sqindv[1] = (         void  *)0;
           sqlstm.sqinds[1] = (         int  )0;
           sqlstm.sqharm[1] = (unsigned int  )0;
           sqlstm.sqadto[1] = (unsigned short )0;
           sqlstm.sqtdso[1] = (unsigned short )0;
           sqlstm.sqhstv[2] = (         void  *)&ar_customer_alpha_code;
           sqlstm.sqhstl[2] = (unsigned int  )13;
           sqlstm.sqhsts[2] = (         int  )0;
           sqlstm.sqindv[2] = (         void  *)0;
           sqlstm.sqinds[2] = (         int  )0;
           sqlstm.sqharm[2] = (unsigned int  )0;
           sqlstm.sqadto[2] = (unsigned short )0;
           sqlstm.sqtdso[2] = (unsigned short )0;
           sqlstm.sqhstv[3] = (         void  *)&ar_customer_pend_amt_dummy;
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
                 err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR_OUTSTG_SUM",0,"");
         }
    }

    ar_customer_cust_code.arr[ar_customer_cust_code.len]   = '\0';
    ar_customer_long_name.arr[ar_customer_long_name.len]   = '\0';
    ar_customer_short_name.arr[ar_customer_short_name.len] = '\0';
    ar_customer_alpha_code.arr[ar_customer_alpha_code.len] = '\0';

    if (LAST_ROW)
       return(0);
    else
       return(1);
}

open_pending_doc()
{
   if (nd_rep_type.arr[0] == 'P')
   {
       /* EXEC SQL OPEN AR_PEND_CUR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 24;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0011;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )689;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_cutoff_date;
       sqlstm.sqhstl[0] = (unsigned int  )14;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_cutoff_date;
       sqlstm.sqhstl[1] = (unsigned int  )14;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&ar_customer_cust_code;
       sqlstm.sqhstl[2] = (unsigned int  )11;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_cutoff_date;
       sqlstm.sqhstl[3] = (unsigned int  )14;
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
             err_mesg("OPEN failed on cursor AR_PEND_CUR",0,"");
   }
   else
   {
       /* EXEC SQL OPEN AR_PEND_CUR_SUM; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 24;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0012;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )720;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_cutoff_date;
       sqlstm.sqhstl[0] = (unsigned int  )14;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_cutoff_date;
       sqlstm.sqhstl[1] = (unsigned int  )14;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&ar_customer_cust_code;
       sqlstm.sqhstl[2] = (unsigned int  )11;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_cutoff_date;
       sqlstm.sqhstl[3] = (unsigned int  )14;
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
             err_mesg("OPEN failed on cursor AR_PEND_CUR_SUM",0,"");
   }

}

fetch_pending_doc()
{
ar_pend_doc_type_code.arr[0]       = '\0';
ar_pend_doc_num.arr[0]             = '\0';
ar_pend_base_date.arr[0]            = '\0';
ar_pend_due_date.arr[0]            = '\0';
ar_pend_cust_ref.arr[0]            = '\0';
ar_pend_patient_id.arr[0]          = '\0';

ar_pend_doc_type_code.len          = 0;
ar_pend_doc_num.len                = 0;
ar_pend_base_date.len               = 0;
ar_pend_due_date.len               = 0;
ar_pend_cust_ref.len               = 0;
ar_pend_patient_id.len             = 0;

ar_pend_sign_amt                   = 0;
ar_pend_cuttoff_base_dt            = 0;
ar_pend_cuttoff_due_dt             = 0;
ar_pend_pending_amt                = 0;
ar_pend_negative_amt               = 0;

   if (nd_rep_type.arr[0] == 'P')
   {
      /* EXEC SQL FETCH AR_PEND_CUR
                INTO :ar_pend_doc_type_code,
                     :ar_pend_doc_num,
                     :ar_pend_base_date,
                     :ar_pend_due_date,
                     :ar_pend_pending_amt,
                     :ar_pend_sign_amt,
                     :ar_pend_negative_amt,
                     :ar_pend_cust_ref,
                     :ar_pend_patient_id, 
                     :ar_pend_cuttoff_base_dt,
                     :ar_pend_cuttoff_due_dt; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 24;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )751;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&ar_pend_doc_type_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&ar_pend_doc_num;
      sqlstm.sqhstl[1] = (unsigned int  )11;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&ar_pend_base_date;
      sqlstm.sqhstl[2] = (unsigned int  )14;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&ar_pend_due_date;
      sqlstm.sqhstl[3] = (unsigned int  )14;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&ar_pend_pending_amt;
      sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&ar_pend_sign_amt;
      sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&ar_pend_negative_amt;
      sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&ar_pend_cust_ref;
      sqlstm.sqhstl[7] = (unsigned int  )18;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&ar_pend_patient_id;
      sqlstm.sqhstl[8] = (unsigned int  )23;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&ar_pend_cuttoff_base_dt;
      sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&ar_pend_cuttoff_due_dt;
      sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
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
            err_mesg("FETCH failed on cursor AR_PEND_CUR",0,"");
   } 
   else
   {
      /* EXEC SQL FETCH AR_PEND_CUR_SUM
                INTO :ar_pend_doc_type_code,
                     :ar_pend_doc_num,
                     :ar_pend_base_date,
                     :ar_pend_due_date,
                     :ar_pend_pending_amt,
                     :ar_pend_sign_amt,
                     :ar_pend_negative_amt,
                     :ar_pend_cust_ref,
                     :ar_pend_patient_id, 
                     :ar_pend_cuttoff_base_dt,
                     :ar_pend_cuttoff_due_dt; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 24;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )810;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&ar_pend_doc_type_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&ar_pend_doc_num;
      sqlstm.sqhstl[1] = (unsigned int  )11;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&ar_pend_base_date;
      sqlstm.sqhstl[2] = (unsigned int  )14;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&ar_pend_due_date;
      sqlstm.sqhstl[3] = (unsigned int  )14;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&ar_pend_pending_amt;
      sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&ar_pend_sign_amt;
      sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&ar_pend_negative_amt;
      sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&ar_pend_cust_ref;
      sqlstm.sqhstl[7] = (unsigned int  )18;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&ar_pend_patient_id;
      sqlstm.sqhstl[8] = (unsigned int  )23;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&ar_pend_cuttoff_base_dt;
      sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&ar_pend_cuttoff_due_dt;
      sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
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
            err_mesg("FETCH failed on cursor AR_PEND_CUR_SUM",0,"");    
            
                  
    }

ar_pend_doc_type_code.arr[ar_pend_doc_type_code.len]     = '\0';
ar_pend_doc_num.arr[ar_pend_doc_num.len]                 = '\0';
ar_pend_base_date.arr[ar_pend_base_date.len]               = '\0';
ar_pend_due_date.arr[ar_pend_due_date.len]               = '\0';
ar_pend_cust_ref.arr[ar_pend_cust_ref.len]               = '\0';
ar_pend_patient_id.arr[ar_pend_patient_id.len]           = '\0';


   if (LAST_ROW)
      return(0);
   else
      return(1);
}



/*-- This PROCEDURE  is to take the exact outstanding amt as of cutoff
     date for the customer aging.  VSK 26/10/1998 ---- */

fetch_ar_cust_trn()
{

ar_pend_sign_amt                   = 0;
ar_pend_pending_amt                = 0;
ar_pend_negative_amt               = 0;


// sprintf(string_var,"Doc Type/Doc Num ->%s %s",ar_pend_doc_type_code.arr,ar_pend_doc_num.arr);
// disp_message(ERR_MESG,string_var);
// sprintf(string_var,"Pending Amt ->%lf",ar_pend_negative_amt);
// disp_message(ERR_MESG,string_var);


/* EXEC SQL SELECT  SUM(NVL(AMOUNT,0)), SIGN(SUM(NVL(AMOUNT,0))),
		 DECODE(SIGN(SUM(NVL(AMOUNT,0))),-1,-SUM(NVL(AMOUNT,0)),SUM(NVL(AMOUNT,0))) 
		 INTO ar_pend_pending_amt,            
		      ar_pend_sign_amt,                   
			  ar_pend_negative_amt            
	     FROM    AR_CUST_TRN
	     WHERE   CUST_CODE = :ar_customer_cust_code
	     AND     ORG_DOC_TYPE_CODE = :ar_pend_doc_type_code
	     AND     ORG_DOC_NUM       = :ar_pend_doc_num
	     AND     DOC_DATE <= TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'); */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 24;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select sum(NVL(AMOUNT,0)) ,SIGN(sum(NVL(AMOUNT,0))) ,DECODE(S\
IGN(sum(NVL(AMOUNT,0))),(-1),(-sum(NVL(AMOUNT,0))),sum(NVL(AMOUNT,0))) into :b\
0,:b1,:b2  from AR_CUST_TRN where (((CUST_CODE=:b3 and ORG_DOC_TYPE_CODE=:b4) \
and ORG_DOC_NUM=:b5) and DOC_DATE<=TO_DATE(:b6,'DD/MM/YYYY'))";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )869;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&ar_pend_pending_amt;
sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&ar_pend_sign_amt;
sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&ar_pend_negative_amt;
sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&ar_customer_cust_code;
sqlstm.sqhstl[3] = (unsigned int  )11;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&ar_pend_doc_type_code;
sqlstm.sqhstl[4] = (unsigned int  )9;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&ar_pend_doc_num;
sqlstm.sqhstl[5] = (unsigned int  )11;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&nd_cutoff_date;
sqlstm.sqhstl[6] = (unsigned int  )14;
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
   err_mesg("SELECT failed on cursor AR_CUST_TRN_CUR",0,"");

return(0);

}



process_det()
{
    age_days = 0;

    nd_open_credit             = 0;
    nd_outstanding_amt         = 0;
	bal_amt_not_yet_due        = 0;
    bal_amt_slot1              = 0;
    bal_amt_slot2              = 0;
    bal_amt_slot3              = 0;
    
    age_days = (nd_age_method.arr[0]  == 'B')?
                    ar_pend_cuttoff_base_dt:
                    ar_pend_cuttoff_due_dt;

    if(age_days >= 0) 
	{
    
        if (ar_pend_sign_amt != 1)
        {
               nd_open_credit     = ar_pend_negative_amt;
               pat_d_open_credit += ar_pend_negative_amt;
        }
        else if (ar_pend_sign_amt != 0)
        {
            nd_outstanding_amt     = ar_pend_pending_amt;
            pat_d_outstanding_amt += ar_pend_pending_amt;
    
    
            if (age_days >= 0 && age_days <= nd_age_slot1)
            {
                  bal_amt_slot1     = ar_pend_pending_amt;
                  pat_d_amt_slot1   += ar_pend_pending_amt;
            }
            else if (age_days >= nd_age_slot1 + 1 && age_days <= nd_age_slot2)
            {
                  bal_amt_slot2     = ar_pend_pending_amt;
                  pat_d_amt_slot2  += ar_pend_pending_amt;
            }
            else if (age_days >= nd_age_slot2 + 1)
            {
                  bal_amt_slot3     = ar_pend_pending_amt;
                  pat_d_amt_slot3  += ar_pend_pending_amt;
            }
        }

    }    
    
    else {
        if (ar_pend_sign_amt != 1)
           {
               nd_open_credit     = ar_pend_negative_amt;
               pat_d_open_credit += ar_pend_negative_amt;
           }
	else   {
            nd_outstanding_amt     = ar_pend_pending_amt;
	        pat_d_not_yet_due_amt += ar_pend_pending_amt;
			bal_amt_not_yet_due   += ar_pend_pending_amt;
            pat_d_outstanding_amt += ar_pend_pending_amt;
	       } 
	     }
	
}
    
print_cust_det()
{
  if (lctr > 55) print_head();

  if (nd_rep_type.arr[0] != 'S')
  {
//18-feb-98 --       fprintf(fp,"CUSTOMER   : %-8s   %-40s  %-10s\n\n\n",
      fprintf(fp,"CUSTOMER   : %-8s   %-40s  %-10s\n\n",
               ar_customer_cust_code.arr,
               ar_customer_long_name.arr,
               ar_customer_alpha_code.arr);
      lctr+=2;
//18-feb-98 --      lctr+=3;
  }
  else
  {
//   {
   if (nd_rep_type.arr[0] == 'S')
     if (nd_order.arr[0] != 'A')
     {      fprintf(fp,"%-8.8s %-40.40s             ",
                  ar_customer_cust_code.arr,
                  ar_customer_long_name.arr);
     }
     else if (nd_order.arr[0] == 'A')
     {      fprintf(fp,"%-8.8s %-40.40s  %-10.10s ",
                  ar_customer_cust_code.arr,
                  ar_customer_long_name.arr,
                  ar_customer_alpha_code.arr);
     }
//   }     
    /*  lctr+=2;    */
   }
}

print_pat_det()
{
  if (nd_rep_type.arr[0] != 'P')
          return(0);
  if (lctr > 55) print_head();

  mp_pat_short_name.arr[0] = '\0';
  mp_pat_short_name.len    = 0;


  /* EXEC SQL SELECT SHORT_NAME
             INTO :mp_pat_short_name
             FROM MP_PATIENT_MAST
            WHERE PATIENT_ID = :ar_pend_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SHORT_NAME into :b0  from MP_PATIENT_MAST where PATI\
ENT_ID=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )912;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&mp_pat_short_name;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&ar_pend_patient_id;
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
         err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");

mp_pat_short_name.arr[mp_pat_short_name.len] = '\0';

  fprintf(fp,"PATIENT ID : %-10s   %-40s\n\n",
               ar_pend_patient_id.arr,mp_pat_short_name.arr);
  lctr+= 2;
}

print_pat_footer()
{
  if (nd_rep_type.arr[0] == 'P')
  {
  if (lctr > 55) print_head();
  fprintf(fp,
"                          ----------------------------------------------------------------------------------------------------------------------\n");
  fprintf(fp,
"PATIENT TOTALS         :   "); 

/************ Display order change -- Sridharan - 22/1/98 **********/
   print_formated(pat_d_outstanding_amt - pat_d_open_credit); fprintf(fp," ");
   print_formated(pat_d_not_yet_due_amt); fprintf(fp," ");
/******************************************************************/
   print_formated(pat_d_open_credit); fprintf(fp," ");
   fprintf(fp," %-15s %-10s ", " "," ");
   print_formated(pat_d_amt_slot1);   fprintf(fp," ");
   print_formated(pat_d_amt_slot2);   fprintf(fp," ");
   print_formated(pat_d_amt_slot3);   fprintf(fp,"\n");
  fprintf(fp,
"                          ----------------------------------------------------------------------------------------------------------------------\n\n");
  lctr += 4;
 
   }  
   cus_d_outstanding_amt += pat_d_outstanding_amt;
   cus_d_not_yet_due_amt += pat_d_not_yet_due_amt;
   cus_d_open_credit     += pat_d_open_credit;
   cus_d_amt_slot1       += pat_d_amt_slot1;
   cus_d_amt_slot2       += pat_d_amt_slot2;
   cus_d_amt_slot3       += pat_d_amt_slot3;
   

   pat_d_outstanding_amt = 0;
   pat_d_not_yet_due_amt = 0;
   pat_d_open_credit     = 0;
   pat_d_amt_slot1       = 0;
   pat_d_amt_slot2       = 0;
   pat_d_amt_slot3       = 0;
   
}

print_cus_footer()
{
  if (nd_rep_type.arr[0] != 'S')
  {
  if (lctr > 55) print_head();
  fprintf(fp,
"                          ----------------------------------------------------------------------------------------------------------------------\n");
  fprintf(fp,
"CUSTOMER TOTALS        :   ");

/********** Column dicplay change  -- Sridharan -- 22/1/98 **********/

   print_formated(cus_d_outstanding_amt - cus_d_open_credit); fprintf(fp," ");
   print_formated(cus_d_not_yet_due_amt); fprintf(fp," ");

/*******************************************************************/

   print_formated(cus_d_open_credit); fprintf(fp," ");
   fprintf(fp,"                            ");
   print_formated(cus_d_amt_slot1);   fprintf(fp," ");
   print_formated(cus_d_amt_slot2);   fprintf(fp," ");
   print_formated(cus_d_amt_slot3);   fprintf(fp,"\n\n");
  fprintf(fp,

"                          ----------------------------------------------------------------------------------------------------------------------\n\n");

  lctr += 5;
//18-feb-98 --   lctr += 6;
/*
  if (lctr > 55) print_head();
  fprintf(fp,"         NET BALANCE   :    ");
   print_formated(cus_d_outstanding_amt - cus_d_open_credit); fprintf(fp,"\n");

  fprintf(fp,"                          ");
  fprintf(fp," ---------------\n\n");
  lctr += 3;
*/

/*
   fprintf(fp,
"                       CREDITS:");
   print_formated(cus_d_open_credit); fprintf(fp,"\n");
   fprintf(fp,
"                          -----------------\n\n");
*/
   }
   else
   {
     if (lctr > 55) print_head();

/******** Commented for alignment -- Sridharan - 22/1/98 ************/
//     fprintf(fp,"                              ");
/********************************************************************/

/********** Column dicplay change  -- Sridharan -- 22/1/98 **********/

     print_formated(cus_d_outstanding_amt - cus_d_open_credit); fprintf(fp," ");
     print_formated(cus_d_not_yet_due_amt); fprintf(fp," ");

/********************************************************************/

     print_formated(cus_d_open_credit); fprintf(fp," ");
     print_formated(cus_d_amt_slot1);   fprintf(fp," ");
     print_formated(cus_d_amt_slot2);   fprintf(fp," ");
     print_formated(cus_d_amt_slot3);   fprintf(fp,"\n\n");
//     lctr += 2;
     lctr += 2;
   }

/*
   fprintf(fp,
"                       CREDITS:");
   print_formated(cus_d_open_credit); fprintf(fp,"\n");
   fprintf(fp,
"                          -----------------\n\n");
*/
   rep_d_outstanding_amt += cus_d_outstanding_amt;
   rep_d_not_yet_due_amt += cus_d_not_yet_due_amt;
   rep_d_open_credit     += cus_d_open_credit;
   rep_d_amt_slot1       += cus_d_amt_slot1;
   rep_d_amt_slot2       += cus_d_amt_slot2;
   rep_d_amt_slot3       += cus_d_amt_slot3;
   
   cus_d_outstanding_amt = 0;
   cus_d_not_yet_due_amt = 0;
   cus_d_open_credit     = 0;
   cus_d_amt_slot1       = 0;
   cus_d_amt_slot2       = 0;
   cus_d_amt_slot3       = 0;
   
}


print_report_footer()
{
  if (lctr > 55) print_head();
	
{
if (nd_rep_type.arr[0] == 'S')
 {
    if (nd_order.arr[0] == 'C')
    {
fprintf(fp,
"                          -----------------------------------------------------------------------------------------------------------------------------\n");

fprintf(fp,
"GRAND TOTALS           :                                      ");
    }
else if (nd_order.arr[0] == 'A')
    {
fprintf(fp,
"                          -----------------------------------------------------------------------------------------------------------------------------\n");

fprintf(fp,
"GRAND TOTALS           :                                      ");
    }
else if (nd_order.arr[0] == 'O')
    {
fprintf(fp,
"                          -----------------------------------------------------------------------------------------------------------------------------\n");

fprintf(fp,
"GRAND TOTALS           :                                      ");
    }
 }
else if (nd_rep_type.arr[0] != 'S')   
{
fprintf(fp,
"                          ----------------------------------------------------------------------------------------------------------------------\n");

fprintf(fp,
"GRAND TOTALS         :     ");
//yes"GRAND TOTALS           :                                      ");
}
}


/****    Column display interchanged by Sridharan - 12/Jan/1998    ***/

   print_formated(rep_d_outstanding_amt - rep_d_open_credit); fprintf(fp," ");
   print_formated(rep_d_not_yet_due_amt); fprintf(fp," ");
   
/****    ******************************************************    ***/
if (nd_rep_type.arr[0] != 'S')
{
   print_formated(rep_d_open_credit); fprintf(fp," ");
   fprintf(fp,"                            ");
   print_formated(rep_d_amt_slot1);   fprintf(fp," ");
   print_formated(rep_d_amt_slot2);   fprintf(fp," ");
   print_formated(rep_d_amt_slot3);   fprintf(fp,"\n");
 }

 if (nd_rep_type.arr[0] == 'S')
{
   print_formated(rep_d_open_credit); fprintf(fp," ");
   print_formated(rep_d_amt_slot1);   fprintf(fp," ");
   print_formated(rep_d_amt_slot2);   fprintf(fp," ");
   print_formated(rep_d_amt_slot3);   fprintf(fp,"\n");
 }

/******/
{
if (nd_rep_type.arr[0] == 'S')
  {
fprintf(fp,
"                          -----------------------------------------------------------------------------------------------------------------------------\n");
  }
else if (nd_rep_type.arr[0] != 'S')
  {
fprintf(fp,
"                          ----------------------------------------------------------------------------------------------------------------------\n");
  }  
}  
/*****/
//fprintf(fp,
//"                          ---------------------------------------------------------------------------------------------------------------------------\n");
/*
   fprintf(fp,"         NET BALANCE   :    ");
   print_formated(rep_d_outstanding_amt - rep_d_open_credit);
   fprintf(fp,"\n");
   fprintf(fp,"                         ");
   fprintf(fp,"-----------------\n\n");
*/
/*
   fprintf(fp,
"                       CREDITS:");
   print_formated(rep_d_open_credit); fprintf(fp,"\n");
   fprintf(fp,
"                          -----------------\n\n");
*/
}



print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (nd_no_of_decimal == 3)
    sprintf(out_str,"%11.3f",loc_amount);
   else
    sprintf(out_str,"%11.2f",loc_amount);
  
    format_amt(out_str,nd_no_of_decimal);
  
   if (loc_amount == 0)
      fprintf(fp,"%14s"," ");
   else if (loc_amount > 0 )
        fprintf(fp,"%14s",out_str);
    else 
        fprintf(fp,"%13s-",out_str);
/*
   else if (loc_amount > 0)
   {
      
      sprintf(out_str,"%11.2f",loc_amount);
      ltrim(out_str);
	  
	  put_comma(out_str);
	  //format_amt(out_str);
	  	  
	  sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s",out_str1);
   }
   else
   {
      sprintf(out_str,"%11.2f",-loc_amount);
      ltrim(out_str);

	  put_comma(out_str);
	  //format_amt(out_str);
      
	  sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s-",out_str1);
   }
*/
}

print_det_line()
{
   char out_str[30],out_str1[30];

   if (nd_rep_type.arr[0] == 'S')
          return(0);
   if (lctr > 55) print_head();

//   if(age_days >= 0) {

       fprintf(fp,"%-6s %8s %-10s ",
               ar_pend_doc_type_code.arr,
               ar_pend_doc_num.arr,
               ar_pend_base_date.arr);
    
/*********  Column display change  -- Sridharan -- 22/1/98 ********/
       print_formated(nd_outstanding_amt); fprintf(fp," ");
//       print_formated((double)0); fprintf(fp," ");
       print_formated(bal_amt_not_yet_due); fprintf(fp," ");
/*****************************************************************/

       print_formated(nd_open_credit);  fprintf(fp," ");

        fprintf(fp," %-15s %-10s ",
           ar_pend_cust_ref.arr, ar_pend_due_date.arr);

       print_formated(bal_amt_slot1);   fprintf(fp," ");
       print_formated(bal_amt_slot2);   fprintf(fp," ");
       print_formated(bal_amt_slot3);   fprintf(fp,"\n");
	    fprintf(fp,"\n");
//   }             
   /*
   else {
       fprintf(fp,"%-6s %8s %-10s    ",
               ar_pend_doc_type_code.arr,
               ar_pend_doc_num.arr,
               ar_pend_base_date.arr);
    
       print_formated(nd_outstanding_amt); fprintf(fp," ");
       print_formated((double)0); fprintf(fp," ");
       print_formated(nd_open_credit);  fprintf(fp,"\n");
   }
   */
   // 18-FEB-98 -- fprintf(fp,"%-15s %-10s\n\n",
   /*fprintf(fp,"%-15s %-10s\n",
           ar_pend_cust_ref.arr, ar_pend_due_date.arr);*/
   fflush(fp);
   //18-FEB-98 --lctr +=3;
   lctr +=3;
  
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



void print_hospital_name(nd_rep_width    ,
                         nd_mod_id       ,
                         nd_hospital_name,
                         nd_date          )
int  nd_rep_width;
char nd_mod_id[3];
char nd_hospital_name[31];
char nd_date[17];
{
	int i = 0 , pos = 0 , len = 0, len_date = 0 , pos_date = 0, len1=0;

    /*Find the length of Hospital Name*/
    for(len = 0; nd_hospital_name[len] != '\0'; len++);

    /*Find the length of Date*/
    for(len_date = 0; nd_date[len_date] != '\0'; len_date++);

    len1 = (len % 2);
    if (len1 == 0)
       len1=9;
    else
       len1=10;


    len = len / 2;

    pos = (nd_rep_width / 2	) - len;

	pos_date = nd_rep_width - len_date;

	fprintf(fp,"MDL : %2s",nd_mod_id);

	for(i = len1; i < pos ; fprintf(fp," "),i++);

	fprintf(fp,"%s",nd_hospital_name);

	for(i = i + (len * 2) ; i < pos_date + 1; fprintf(fp," "),i++);

    fprintf(fp,"%s\n",nd_date);
}






sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 24;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )935;
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
