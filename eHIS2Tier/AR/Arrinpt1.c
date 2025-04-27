
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
           char  filnam[35];
};
static const struct sqlcxp sqlfpn =
{
    34,
    "T:\\BL\\MEDICITY_POSTING\\Arrinpt1.pc"
};


static unsigned long sqlctx = 1447597155;


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
            void  *sqhstv[35];
   unsigned int   sqhstl[35];
            int   sqhsts[35];
            void  *sqindv[35];
            int   sqinds[35];
   unsigned int   sqharm[35];
   unsigned int   *sqharc[35];
   unsigned short  sqadto[35];
   unsigned short  sqtdso[35];
} sqlstm = {10,35};

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
"'47123112','YYYYDDMM'))) order by DOC_TYPE_CODE,DOC_NUM            ";

 static const char *sq0010 = 
"select DECODE(CHINESE_REPORTING_FLAG,'Y',LONG_NAME_CHINESE,LONG_NAME) ,DECOD\
E(CHINESE_REPORTING_FLAG,'Y',SHORT_NAME_CHINESE,SHORT_NAME) ,DECODE(CHINESE_RE\
PORTING_FLAG,'Y',ADD1_DESC_CHINESE,ADD1_DESC) ,DECODE(CHINESE_REPORTING_FLAG,'\
Y',ADD2_DESC_CHINESE,ADD2_DESC) ,DECODE(CHINESE_REPORTING_FLAG,'Y',ADD3_DESC_C\
HINESE,ADD3_DESC) ,DECODE(CHINESE_REPORTING_FLAG,'Y',ZIP_DESC_CHINESE,ZIP_DESC\
) ,CONTACT_NAME ,CONTACT_NAME_TITLE ,MISC_CUSTOMER_FLAG ,CHINESE_REPORTING_FLA\
G  from AR_CUSTOMER where CUST_CODE=:b0           ";

 static const char *sq0006 = 
"select A.PATIENT_ID ,A.BILL_DOC_TYPE_CODE ,A.BILL_NUM ,TO_CHAR(A.BILL_DATE,'\
DD/MM/YYYY') ,A.AMOUNT  from AR_PATIENT_DTLS A ,AR_INV_HDR B where ((((A.DOC_T\
YPE_CODE=:b0 and A.DOC_NUM=:b1) and A.DOC_TYPE_CODE=B.DOC_TYPE_CODE) and A.DOC\
_NUM=B.DOC_NUM) and NVL(B.POSTED_FLAG,'N')='Y') union select A.PATIENT_ID ,A.D\
OC_TYPE_CODE BILL_DOC_TYPE_CODE ,A.DOC_NUM BILL_NUM ,TO_CHAR(A.DOC_DATE,'DD/MM\
/YYYY') BILL_DATE ,A.DOC_AMT AMOUNT  from AR_PAT_BILLS_TEMP A ,AR_INV_HDR B wh\
ere ((((A.AR_INVOICE_DOC_TYPE_CODE=:b0 and A.AR_INVOICE_DOC_NUM=:b1) and A.AR_\
INVOICE_DOC_TYPE_CODE=B.DOC_TYPE_CODE) and A.AR_INVOICE_DOC_NUM=B.DOC_NUM) and\
 NVL(B.POSTED_FLAG,'N')='N') order by 2,3            ";

 static const char *sq0008 = 
"select PATIENT_ID ,BILL_DOC_TYPE_CODE ,BILL_NUM ,TO_CHAR(BILL_DATE,'DD/MM/YY\
YY') ,REMARKS ,LAB_TEST ,AMOUNT  from AR_PATIENT_DTLS where (DOC_TYPE_CODE=:b0\
 and DOC_NUM=:b1) order by BILL_DATE,2,3            ";

 static const char *sq0009 = 
"select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,DOC_REF ,DOC_\
AMT  from AR_EXT_SALES_DP_DTLS where (AR_INVOICE_DOC_TYPE_CODE=:b0 and AR_INVO\
ICE_DOC_NUM=:b1) order by DOC_TYPE_CODE,DOC_NUM            ";

 static const char *sq0007 = 
"select PATIENT_ID ,BILL_DOC_TYPE_CODE ,BILL_NUM ,TO_CHAR(BILL_DATE,'DD/MM/YY\
YY') ,GROSS_AMT  from AR_INV_HDR where ((DOC_TYPE_CODE=:b0 and DOC_NUM=:b1) an\
d BILL_NUM is  not null )           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,227,0,4,255,0,0,11,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
64,0,0,2,91,0,2,461,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
87,0,0,3,0,0,30,473,0,0,0,0,0,1,0,
102,0,0,4,181,0,4,493,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
3,0,0,1,9,0,0,
145,0,0,5,1091,0,9,693,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
184,0,0,5,0,0,13,783,0,0,35,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,
339,0,0,10,516,0,9,862,0,0,1,1,0,1,0,1,9,0,0,
358,0,0,10,0,0,13,887,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,1,0,0,
413,0,0,6,675,0,9,947,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
444,0,0,8,206,0,9,957,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
467,0,0,8,0,0,13,987,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,4,0,0,
510,0,0,9,213,0,9,1065,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
533,0,0,9,0,0,13,1093,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
568,0,0,6,0,0,13,1139,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
603,0,0,7,190,0,9,1167,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
626,0,0,7,0,0,13,1195,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
661,0,0,11,82,0,4,1407,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
684,0,0,12,82,0,4,1414,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
707,0,0,13,136,0,4,1436,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
742,0,0,14,77,0,4,1467,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
765,0,0,15,53,0,5,1664,0,0,1,1,0,1,0,1,9,0,0,
784,0,0,16,0,0,29,1670,0,0,0,0,0,1,0,
799,0,0,17,0,0,27,1693,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : ARRINPT1.PC                                  */
/* AUTHOR                : YESHODA ERAPPA                               */
/* DATE WRITTEN          : 17/OCT/2002                                  */
/* MODIFIED BY           : MUTHU.K.S                                    */
/*                         03/JUNE/2003                                 */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.        AR_INV_HDR               Query/Update              */
/*         2.        AR_PATINET_DTLS             Query                  */
/*         3.        SY_PROG_CONTROL           Update/Lookup            */
/*         4.        SY_PROG_MESG                Insert                 */
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


/*
#define OERROR (sqlca.sqlcode < 0)
*/

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define DEST_NAME "arrinpt1.lis"

#define PAT_LINES 27

#define LEGEND 1

#define  ESC 0x1B

#define LENGTH_WORDS 75  
/*
#define DEBUG 1 
*/
char string_var[100];
int split_text(char *str1,int number1,char *str2,int number);  


/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd      [132],
           hosp_name    [120],
           date_time    [20],
		   cur_str      [8],
		   sub_cur_str  [8],
		   user_id      [20],
           nd_pgm_date  [35],
		   p_language_id [3]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[8]; } cur_str;

struct { unsigned short len; unsigned char arr[8]; } sub_cur_str;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;


   /* VARCHAR nd_facility_id   [3],
		   nd_session_id    [16],
           nd_fm_doc_type   [7],
           nd_to_doc_type   [7],
           nd_fm_doc_num    [10],
           nd_to_doc_num    [10],
           nd_fm_doc_date   [12],
           nd_to_doc_date   [12],
		   d_operating_facility_id [3],

           d_ar_inv_doc_type_code      [7],
           d_ar_inv_doc_num            [10],
           d_ar_inv_doc_date           [12],
		   d_ar_inv_due_date           [12],
           d_ar_inv_cust_code          [9],
		   d_ar_pmnt_terms_code        [3],
           d_ar_inv_patient_id         [21],
           d_ar_inv_bill_doc_type_code [7],
           d_ar_inv_bill_num           [10],
           d_ar_inv_cust_ref           [16],
           d_ar_inv_narration          [51],
           d_ar_inv_rowid              [31],

           d_ar_cust_long_name         [101],  -- CRF-0120
           d_ar_cust_short_name        [61],  -- CRF-0120
           d_ar_cust_add1_desc         [61],  -- CRF-0120
           d_ar_cust_add2_desc         [61],  -- CRF-0120
           d_ar_cust_add3_desc         [61],  -- CRF-0120
           d_ar_cust_zip_desc          [31],
           d_ar_cust_contact_name      [101],  -- CRF-0120
           d_ar_cust_contact_title[61],  -- CRF-0120

           d_ar_pat_patient_id         [21],
		   d_ar_pat_patient_name       [100],
           d_ar_pat_bill_doc_type_code [7],
           d_ar_pat_bill_num           [10],
           d_ar_pat_bill_date          [12],
           d_ar_pat_remarks            [16],
		   d_ar_pat_lab_test           [16],


		   d_dp_invoice_yn             [2],
		   d_ar_dp_doc_type_code       [7],
		   d_ar_dp_doc_num             [9],
		   d_ar_dp_doc_date			   [12],
		   d_ar_dp_doc_ref			   [11],
		   
		   d_ar_cssd_doc_type_code	   [7],
		   d_ar_cssd_doc_num		   [9],
		   d_ar_cssd_doc_date		   [12],	

           d_ar_mp_patient_name        [100],
		   d_ar_mp_patient_title       [9],

		   d_misc_cust_long_name       [101],  -- CRF-0120
		   d_misc_cust_short_name      [101],  -- CRF-0120
		   d_misc_cust_add1_desc       [61],
		   d_misc_cust_add2_desc       [61],
		   d_misc_cust_add3_desc       [61],
		   d_misc_cust_zip_desc        [31],

		   d_misc_cust_long_name_chi   [101],  -- CRF-0120
		   d_misc_cust_short_name_chi  [101],  -- CRF-0120
		   d_misc_cust_add1_desc_chi   [61],
		   d_misc_cust_add2_desc_chi   [61],
		   d_misc_cust_add3_desc_chi   [61],
		   d_misc_cust_zip_desc_chi    [31],
		   d_misc_cust_contact_name      [101],  -- CRF-0120
           d_misc_cust_contact_title[61],  -- CRF-0120
		   d_module_id   [3],
		   d_consolidated_yn [2],
		   d_print_flag  [2],
		   d_episode_type   [2],
     	   cond_amount                   [500],
		    d_episode_id  [9],
			d_preprinted_flag  [2],
			d_rep_option  [2]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[10]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[3]; } d_operating_facility_id;

struct { unsigned short len; unsigned char arr[7]; } d_ar_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_ar_inv_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_ar_inv_doc_date;

struct { unsigned short len; unsigned char arr[12]; } d_ar_inv_due_date;

struct { unsigned short len; unsigned char arr[9]; } d_ar_inv_cust_code;

struct { unsigned short len; unsigned char arr[3]; } d_ar_pmnt_terms_code;

struct { unsigned short len; unsigned char arr[21]; } d_ar_inv_patient_id;

struct { unsigned short len; unsigned char arr[7]; } d_ar_inv_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_ar_inv_bill_num;

struct { unsigned short len; unsigned char arr[16]; } d_ar_inv_cust_ref;

struct { unsigned short len; unsigned char arr[51]; } d_ar_inv_narration;

struct { unsigned short len; unsigned char arr[31]; } d_ar_inv_rowid;

struct { unsigned short len; unsigned char arr[101]; } d_ar_cust_long_name;

struct { unsigned short len; unsigned char arr[61]; } d_ar_cust_short_name;

struct { unsigned short len; unsigned char arr[61]; } d_ar_cust_add1_desc;

struct { unsigned short len; unsigned char arr[61]; } d_ar_cust_add2_desc;

struct { unsigned short len; unsigned char arr[61]; } d_ar_cust_add3_desc;

struct { unsigned short len; unsigned char arr[31]; } d_ar_cust_zip_desc;

struct { unsigned short len; unsigned char arr[101]; } d_ar_cust_contact_name;

struct { unsigned short len; unsigned char arr[61]; } d_ar_cust_contact_title;

struct { unsigned short len; unsigned char arr[21]; } d_ar_pat_patient_id;

struct { unsigned short len; unsigned char arr[100]; } d_ar_pat_patient_name;

struct { unsigned short len; unsigned char arr[7]; } d_ar_pat_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_ar_pat_bill_num;

struct { unsigned short len; unsigned char arr[12]; } d_ar_pat_bill_date;

struct { unsigned short len; unsigned char arr[16]; } d_ar_pat_remarks;

struct { unsigned short len; unsigned char arr[16]; } d_ar_pat_lab_test;

struct { unsigned short len; unsigned char arr[2]; } d_dp_invoice_yn;

struct { unsigned short len; unsigned char arr[7]; } d_ar_dp_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_ar_dp_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_ar_dp_doc_date;

struct { unsigned short len; unsigned char arr[11]; } d_ar_dp_doc_ref;

struct { unsigned short len; unsigned char arr[7]; } d_ar_cssd_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_ar_cssd_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_ar_cssd_doc_date;

struct { unsigned short len; unsigned char arr[100]; } d_ar_mp_patient_name;

struct { unsigned short len; unsigned char arr[9]; } d_ar_mp_patient_title;

struct { unsigned short len; unsigned char arr[101]; } d_misc_cust_long_name;

struct { unsigned short len; unsigned char arr[101]; } d_misc_cust_short_name;

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

struct { unsigned short len; unsigned char arr[61]; } d_misc_cust_contact_title;

struct { unsigned short len; unsigned char arr[3]; } d_module_id;

struct { unsigned short len; unsigned char arr[2]; } d_consolidated_yn;

struct { unsigned short len; unsigned char arr[2]; } d_print_flag;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[500]; } cond_amount;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[2]; } d_preprinted_flag;

struct { unsigned short len; unsigned char arr[2]; } d_rep_option;


char       d_misc_customer_flag,
	   d_chinese_reporting_flag,
	   amt_in_words	 [10][133],
	   corder_str    [81]; 


int d_markup_perc, nd_no_of_dec;

double      d_ar_inv_payable_amt,
            d_ar_inv_gross_amt,
			d_ar_inv_discount_amt,
			d_ar_pat_amount,
			d_ar_pat_amt_paid,
			d_ar_inv_markup_amt ,    
			d_invoice_amt,
			d_ar_cssd_doc_amt, 
			d_ar_dp_doc_amt;

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
int inv_lctr = 0,inv_pctr = 0,lab_flag = 0,pat_lctr = 0;
int first ;
int no_of_lines;  
int inc ;
int nstart ;


double tot_amount;

int i = 0;
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
      disp_message(ERR_MESG,"Not enough Parameters for running this program\n");
      disp_message(ERR_MESG,"Exiting...\n\007\007\007\007\007\007\007\007");
      proc_exit();
   }


   strcpy(uid_pwd.arr,argv[1]); 
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"ARRINPT1");

   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
         disp_message(ORA_MESG,"Null oracle uid/pwd\n\n\n");
      proc_exit();
   }
 
#ifdef DEBUG
  disp_message(INFO_MESG,"After connecting to oracle...\n");
#endif
   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   set_meduser_role();

 strcpy(p_language_id.arr,l_language_id.arr);
p_language_id.len = l_language_id.len;
  
   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   nd_fm_doc_type.arr[0]    = '\0';
   nd_fm_doc_num.arr[0]     = '\0';
   nd_fm_doc_date.arr[0]    = '\0';
   nd_to_doc_type.arr[0]    = '\0';
   nd_to_doc_num.arr[0]     = '\0';
   nd_to_doc_date.arr[0]    = '\0';
   d_preprinted_flag.arr[0]  = '\0';
   d_rep_option.arr[0]  ='\0';


   nd_fm_doc_type.len       = 0;
   nd_fm_doc_num.len        = 0;
   nd_fm_doc_date.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_to_doc_num.len        = 0;
   nd_to_doc_date.len       = 0;
   d_preprinted_flag.len    = 0;
   d_rep_option.len         = 0;    

   /* EXEC SQL SELECT operating_facility_id,
				   PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6, nvl(PARAM7 , 'N'),
				   PARAM8
              INTO :nd_facility_id,
				   :nd_fm_doc_type, :nd_fm_doc_num, :nd_fm_doc_date,
                   :nd_to_doc_type, :nd_to_doc_num, :nd_to_doc_date,
				   :d_preprinted_flag , :d_rep_option
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'ARRINPT1'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,nvl(PARAM7,'N') ,PARAM8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:\
b7,:b8  from SY_PROG_PARAM where ((PGM_ID='ARRINPT1' and SESSION_ID=:b9) and P\
GM_DATE=:b10)";
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
   sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_type;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_type;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[5] = (unsigned int  )12;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_date;
   sqlstm.sqhstl[6] = (unsigned int  )14;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_preprinted_flag;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_rep_option;
   sqlstm.sqhstl[8] = (unsigned int  )4;
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
   sqlstm.sqhstl[10] = (unsigned int  )37;
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

   nd_fm_doc_type.arr[nd_fm_doc_type.len]    = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]      = '\0';
   nd_fm_doc_date.arr[nd_fm_doc_date.len]    = '\0';
   nd_to_doc_type.arr[nd_to_doc_type.len]    = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]      = '\0';
   nd_to_doc_date.arr[nd_to_doc_date.len]    = '\0';
   d_preprinted_flag.arr[d_preprinted_flag.len] = '\0';
   d_rep_option.arr[d_rep_option.len] = '\0';

#ifdef DEBUG
   sprintf(string_var,"fr type is <%d> - <%s>\n",nd_fm_doc_type.len ,nd_fm_doc_type.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to type is <%d> - <%s>\n",nd_to_doc_type.len ,nd_to_doc_type.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"fr num  is <%d> - <%s>\n",nd_fm_doc_num.len ,nd_fm_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to num  is <%d> - <%s>\n",nd_to_doc_num.len ,nd_to_doc_num.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"fr dt   is <%d> - <%s>\n",nd_fm_doc_date.len ,nd_fm_doc_date.arr);
   disp_message(INFO_MESG,string_var);
   sprintf(string_var,"to dt   is <%d> - <%s>\n",nd_to_doc_date.len ,nd_to_doc_date.arr);
   disp_message(INFO_MESG,string_var);
#endif


   fetch_detls();

   open_files();
   
   declare_cursors();

   while(fetch_inv_hdr())
   {

      fetch_cust_det(); 
      print_page_head();
	  

	  if (strcmp(d_module_id.arr , "AR") == 0)
	  {
         
	     if (strcmp(d_ar_inv_bill_num.arr , "\0") == 0)
         {
             print_ar_inv();

		 }
		 else
		 {

		      open_patient_inv_dtls();
		      while(fetch_patient_inv_dtls())
		      {
                  print_patient_inv_head();
				  get_patient_name();
				  print_pat_dtls();
				  
		      }
		 
		 }


	   }  /* end of AR */
	   else if (strcmp(d_module_id.arr , "RL") == 0)
	   {
         
               if (lctr == 12)
				{
				    fprintf(fp, "                                                       C/F  ");
	                print_formated_tot(tot_amount);
	                fprintf(fp,"\n");
                    fprintf(fp, "\f");
                    print_page_head();
				    print_patient_lab_head();
				 }

               print_patient_lab_head();
			   open_lab_dtls();
			   while(fetch_lab_dtls())
		      {
                print_lab_dtls();

              }

	   }

	   //08/02/2008
	 /*  else if (strcmp(d_module_id.arr , "SS") == 0)
	   {        
               print_cssd_head();
		  
		 open_cssd_dtls();  
			  while(fetch_cssd_dtls())  
		       {
                 if (lctr == 12) 
				 {
				    fprintf(fp, "                                                       C/F  ");
	                print_formated_tot(tot_amount);
	                fprintf(fp,"\n");
                    fprintf(fp, "\f");
                    print_page_head();
				    print_cssd_head();
				 }
				 print_cssd_dtls();
              }

	   }*//* End of SS */

	   
	   else if ((strcmp(d_module_id.arr , "ST") == 0) && (strcmp(d_dp_invoice_yn.arr , "Y") == 0))
	   {

                if (lctr == 12)
				{
				    fprintf(fp, "                                                       C/F  ");
	                print_formated_tot(tot_amount);
	                fprintf(fp,"\n");
                    fprintf(fp, "\f");
                    print_page_head();
				    print_dp_head();
				 }

               print_dp_head();
			   open_dp_dtls();
			   while(fetch_dp_dtls())
		      {
                print_dp_dtls();

              }

	   }
	   else
	   {
         
           print_patient_inv_head();
		   open_patient_dtls();
		   open_patient_inv_dtls();		   

		   if (strcmp(d_consolidated_yn.arr, "Y") == 0)
		   {		      

			  while(fetch_patient_dtls())
		      {
                     
			     if (lctr == 12)
				 {
				    fprintf(fp, "                                                       C/F  ");
	                print_formated_tot(tot_amount); 
	                fprintf(fp,"\n");
                    fprintf(fp, "\f");
                    print_page_head();
				    print_patient_inv_head();
				  }
                  get_patient_name();
				  get_episode_id();
				  print_pat_dtls();
		      }

		   }
		   else
           {

              while(fetch_patient_inv_dtls())
		      {
               
                  get_patient_name();
				  get_episode_id();
				  print_pat_dtls();
		      }

           }

		   
		} /* end of is not AR */

  
       get_markup_percent();
	   print_inv_tot();
     
      

	   if (strcmp(d_rep_option.arr , "P") == 0)
	   {
	       update_invoice();
		}
       fprintf(fp, "\f");

   }/* end of while ar_inv_hdr*/

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
                  WHERE PGM_ID     = 'ARRINPT1'
                    AND SESSION_ID = :nd_session_id
                    AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='ARRINPT1' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )64;
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


/*
   end_prog_msg();
   end_prog_control();
*/
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )87;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   fclose(fp);
   return;
}


fetch_detls()
{
   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   cur_str.arr[0]        = '\0';
   sub_cur_str.arr[0]    = '\0';
   user_id.arr[0]        = '\0';

   hosp_name.len      = 0;
   date_time.len      = 0;
   cur_str.len		  = 0;
   sub_cur_str.len    = 0;
   user_id.len        = 0;

   /* EXEC SQL SELECT ACCOUNTING_NAME, 
                   TO_CHAR(SYSDATE,'DD/MM/YYYY'), 
				   BASE_CURRENCY,
                   USER,BASE_CURRENCY_DEC,
				   NO_OF_DECIMAL
              INTO :hosp_name, 
			       :date_time, 
				   :cur_str, 
				   :user_id,
				   :sub_cur_str,
				   :nd_no_of_dec 
              FROM SY_ACC_ENTITY
			 WHERE ACC_ENTITY_ID = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,BAS\
E_CURRENCY ,USER ,BASE_CURRENCY_DEC ,NO_OF_DECIMAL into :b0,:b1,:b2,:b3,:b4,:b\
5  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b6";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )102;
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
   sqlstm.sqhstv[2] = (         void  *)&cur_str;
   sqlstm.sqhstl[2] = (unsigned int  )10;
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
   sqlstm.sqhstv[4] = (         void  *)&sub_cur_str;
   sqlstm.sqhstl[4] = (unsigned int  )10;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_no_of_dec;
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

   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   cur_str.arr[cur_str.len]				  = '\0';
   sub_cur_str.arr[sub_cur_str.len]       = '\0';
   user_id.arr[user_id.len]               = '\0';

}

open_files()
{
   char		text_msg[101];
   if ((fp = fopen(filename,"w")) == NULL)
   {
        sprintf(text_msg,"Error While Opening File %s",filename);
		err_mesg(text_msg,0,"");
		//err_mesg("\nError while opening File arrrmltr.lis\n",0,"");
        proc_exit();
   }

#ifdef DEBUG
   disp_message(INFO_MESG,"After opening file\n");
#endif
}

declare_cursors() 
{
#ifdef DEBUG
   disp_message(INFO_MESG,"Inside declare cursors\n");
#endif

   /* EXEC SQL DECLARE AR_INV_HDR_CUR CURSOR FOR
             SELECT OPERATING_FACILITY_ID,
					DOC_TYPE_CODE,
                    DOC_NUM,
                    TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
					TO_CHAR(DUE_DATE, 'DD/MM/YYYY'),
                    CUST_CODE,
					PMNT_TERMS_CODE,
                    PATIENT_ID,
                    BILL_DOC_TYPE_CODE,
                    BILL_NUM,
                    CUST_REF,
                    NARRATION,
					NVL(GROSS_AMT,0),
					NVL(DISCOUNT_AMT,0),
					NVL(MARKUP_AMT,0),
                    NVL(PAYABLE_AMT,0),
					MISC_CUST_LONG_NAME,
					MISC_CUST_SHORT_NAME,
					MISC_CUST_ADD1_DESC,
					MISC_CUST_ADD2_DESC,
					MISC_CUST_ADD3_DESC,
					MISC_CUST_ZIP_DESC,
					MISC_CUST_LONG_NAME_CHINESE,
					MISC_CUST_SHORT_NAME_CHINESE,
					MISC_CUST_ADD1_DESC_CHINESE,
					MISC_CUST_ADD2_DESC_CHINESE,
					MISC_CUST_ADD3_DESC_CHINESE,
					MISC_CUST_ZIP_DESC_CHINESE,
					CONTACT_NAME,
					CONTACT_NAME_TITLE,
					ROWID,
					MODULE_ID,
					nvl(CONSOLIDATED_INV_YN, 'N'),
					NVL(PRINT_FLAG,'N'),
					NVL(DP_INVOICE_YN , 'N')
               FROM AR_INV_HDR
              WHERE DOC_TYPE_CODE >= NVL(:nd_fm_doc_type,'      ')
                AND DOC_TYPE_CODE <= NVL(:nd_to_doc_type,'~~~~~~')
                AND DOC_NUM       >= NVL(:nd_fm_doc_num,0)
                AND DOC_NUM       <= NVL(:nd_to_doc_num,99999999)
                AND NVL(DOC_DATE,SYSDATE)      >= 
                    NVL(TO_DATE(:nd_fm_doc_date,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))
                AND NVL(DOC_DATE,SYSDATE)      <= 
                    NVL(TO_DATE(:nd_to_doc_date,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))
                ORDER BY DOC_TYPE_CODE,DOC_NUM; */ 

 
   /* COMMENTED ON 1/12/2003 TO ACCOMODATE TEMPORARY ADHOC FUNCTION.
   EXEC SQL DECLARE AR_PATIENT_DTLS_CUR CURSOR FOR
               SELECT PATIENT_ID,
                      BILL_DOC_TYPE_CODE,
                      BILL_NUM,
                      TO_CHAR(BILL_DATE,'DD/MM/YYYY'),
                      AMOUNT
                FROM  AR_PATIENT_DTLS
               WHERE  DOC_TYPE_CODE = :d_ar_inv_doc_type_code
                 AND   DOC_NUM       = :d_ar_inv_doc_num
				 ORDER BY 2,3;
    */

	/* ADDED ON 1/12/2003 TO ACCOMODATE TEMPORARY ADHOC FUNCTION*/

	/* EXEC SQL DECLARE AR_PATIENT_DTLS_CUR CURSOR FOR
	               SELECT A.PATIENT_ID,
                          A.BILL_DOC_TYPE_CODE,  
                          A.BILL_NUM,
                          TO_CHAR(A.BILL_DATE,'DD/MM/YYYY'),
                          A.AMOUNT
                     FROM AR_PATIENT_DTLS A, AR_INV_HDR B
                    WHERE A.DOC_TYPE_CODE = :d_ar_inv_doc_type_code
                      AND A.DOC_NUM       = :d_ar_inv_doc_num
                      AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE
                      AND A.DOC_NUM       = B.DOC_NUM
                      AND NVL(B.POSTED_FLAG,'N') = 'Y'  
              UNION
                   SELECT A.PATIENT_ID,
                          A.DOC_TYPE_CODE BILL_DOC_TYPE_CODE,  
                          A.DOC_NUM BILL_NUM,
                          TO_CHAR(A.DOC_DATE,'DD/MM/YYYY') BILL_DATE,
                          A.DOC_AMT AMOUNT
                     FROM AR_PAT_BILLS_TEMP A, AR_INV_HDR B
                    WHERE A.AR_INVOICE_DOC_TYPE_CODE  = :d_ar_inv_doc_type_code
                      AND A.AR_INVOICE_DOC_NUM        = :d_ar_inv_doc_num
                      AND A.AR_INVOICE_DOC_TYPE_CODE  = B.DOC_TYPE_CODE
                      AND A.AR_INVOICE_DOC_NUM        = B.DOC_NUM
                      AND NVL(B.POSTED_FLAG,'N') = 'N'
                    ORDER BY 2,3 ; */ 

          
    /* EXEC SQL DECLARE AR_PATIENT_DTLS_INV_CUR CURSOR FOR
                SELECT PATIENT_ID ,
				       BILL_DOC_TYPE_CODE,
                       BILL_NUM,
                       TO_CHAR(BILL_DATE,'DD/MM/YYYY'),
                       GROSS_AMT
                  FROM  AR_INV_HDR
				  WHERE DOC_TYPE_CODE = :d_ar_inv_doc_type_code
                  AND   DOC_NUM       = :d_ar_inv_doc_num
				  AND   BILL_NUM IS NOT NULL; */ 



   /* EXEC SQL DECLARE AR_LAB_DTLS_CUR CURSOR FOR
               SELECT PATIENT_ID,
                      BILL_DOC_TYPE_CODE,
                      BILL_NUM,
                      TO_CHAR(BILL_DATE,'DD/MM/YYYY'),
					  REMARKS,
					  LAB_TEST,
                      AMOUNT
                FROM  AR_PATIENT_DTLS
               WHERE  DOC_TYPE_CODE = :d_ar_inv_doc_type_code
                 AND   DOC_NUM       = :d_ar_inv_doc_num
				 ORDER BY BILL_DATE , 2,3; */ 




   /* EXEC SQL DECLARE AR_DP_DTLS_CUR CURSOR FOR
        SELECT   DOC_TYPE_CODE ,         
				 DOC_NUM        ,        
				 TO_CHAR(DOC_DATE , 'DD/MM/YYYY'),
				 DOC_REF                ,
				 DOC_AMT
		FROM     AR_EXT_SALES_DP_DTLS
		WHERE    AR_INVOICE_DOC_TYPE_CODE  = :d_ar_inv_doc_type_code
	    AND		 AR_INVOICE_DOC_NUM        = :d_ar_inv_doc_num    
		ORDER BY DOC_TYPE_CODE, DOC_NUM; */ 


 //08/02/2008 
 /* EXEC SQL DECLARE AR_CSSD_DTLS_CUR CURSOR FOR
		SELECT   B.DOC_TYPE_CODE,B.DOC_NUM,A.DOC_DATE,
			     SUM(B.ROF_COST) ROF_COST 
		  FROM   SS_ROF_HDR A, SS_ROF_DTL B
		 WHERE   A.DOC_TYPE_CODE=B.DOC_TYPE_CODE 
		   AND   A.DOC_NO = B.DOC_NUM 
		   AND   B.AR_INVOICE_DOC_TYPE_CODE = :d_ar_inv_doc_type_code
		   AND   B.AR_INVOICE_DOC_NUM       = :d_ar_inv_doc_num
      GROUP BY   B.DOC_TYPE_CODE,B.DOC_NUM,A.DOC_DATE ; */  //08/02/2008

   
    /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
        SELECT DECODE(CHINESE_REPORTING_FLAG,'Y',LONG_NAME_CHINESE,LONG_NAME),
               DECODE(CHINESE_REPORTING_FLAG,'Y',SHORT_NAME_CHINESE,SHORT_NAME),
               DECODE(CHINESE_REPORTING_FLAG,'Y',ADD1_DESC_CHINESE,ADD1_DESC),
               DECODE(CHINESE_REPORTING_FLAG,'Y',ADD2_DESC_CHINESE,ADD2_DESC),
               DECODE(CHINESE_REPORTING_FLAG,'Y',ADD3_DESC_CHINESE,ADD3_DESC),
               DECODE(CHINESE_REPORTING_FLAG,'Y',ZIP_DESC_CHINESE,ZIP_DESC),
               CONTACT_NAME,
               CONTACT_NAME_TITLE,
	       MISC_CUSTOMER_FLAG,
	       CHINESE_REPORTING_FLAG
          FROM AR_CUSTOMER
         WHERE CUST_CODE = :d_ar_inv_cust_code; */ 


    
    /* EXEC SQL OPEN AR_INV_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select OPERATING_FACILITY_ID ,DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DAT\
E,'DD/MM/YYYY') ,TO_CHAR(DUE_DATE,'DD/MM/YYYY') ,CUST_CODE ,PMNT_TERMS_CODE \
,PATIENT_ID ,BILL_DOC_TYPE_CODE ,BILL_NUM ,CUST_REF ,NARRATION ,NVL(GROSS_AM\
T,0) ,NVL(DISCOUNT_AMT,0) ,NVL(MARKUP_AMT,0) ,NVL(PAYABLE_AMT,0) ,MISC_CUST_\
LONG_NAME ,MISC_CUST_SHORT_NAME ,MISC_CUST_ADD1_DESC ,MISC_CUST_ADD2_DESC ,M\
ISC_CUST_ADD3_DESC ,MISC_CUST_ZIP_DESC ,MISC_CUST_LONG_NAME_CHINESE ,MISC_CU\
ST_SHORT_NAME_CHINESE ,MISC_CUST_ADD1_DESC_CHINESE ,MISC_CUST_ADD2_DESC_CHIN\
ESE ,MISC_CUST_ADD3_DESC_CHINESE ,MISC_CUST_ZIP_DESC_CHINESE ,CONTACT_NAME ,\
CONTACT_NAME_TITLE ,ROWID ,MODULE_ID ,nvl(CONSOLIDATED_INV_YN,'N') ,NVL(PRIN\
T_FLAG,'N') ,NVL(DP_INVOICE_YN,'N')  from AR_INV_HDR where (((((DOC_TYPE_COD\
E>=NVL(:b0,'      ') and DOC_TYPE_CODE<=NVL(:b1,'~~~~~~')) and DOC_NUM>=NVL(\
:b2,0)) and DOC_NUM<=NVL(:b3,99999999)) and NVL(DOC_DATE,SYSDATE)>=NVL(TO_DA\
TE(:b4,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))) and NVL(DOC_DATE,SYSDA\
TE)<=NVL(TO_DATE(:b5,'DD/MM/YYYY'),to_date(");
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )145;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_doc_type;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fm_doc_num;
    sqlstm.sqhstl[2] = (unsigned int  )12;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_doc_num;
    sqlstm.sqhstl[3] = (unsigned int  )12;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_date;
    sqlstm.sqhstl[4] = (unsigned int  )14;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_date;
    sqlstm.sqhstl[5] = (unsigned int  )14;
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
         err_mesg("OPEN failed on cursor AR_INV_HDR_CUR",0,"");

}

fetch_inv_hdr()
{

d_operating_facility_id.arr[0]  = '\0';
d_ar_inv_doc_type_code.arr[0]      = '\0';
d_ar_inv_doc_num.arr[0]            = '\0';
d_ar_inv_doc_date.arr[0]           = '\0';
d_ar_inv_due_date.arr[0]           = '\0';
d_ar_inv_cust_code.arr[0]          = '\0';
d_ar_pmnt_terms_code.arr[0]        = '\0';
d_ar_inv_patient_id.arr[0]         = '\0';
d_ar_inv_bill_doc_type_code.arr[0] = '\0';
d_ar_inv_bill_num.arr[0]           = '\0';
d_ar_inv_cust_ref.arr[0]           = '\0';
d_ar_inv_narration.arr[0]          = '\0';
d_ar_inv_rowid.arr[0]              = '\0';
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
d_misc_cust_contact_title.arr[0]  = '\0';
d_module_id.arr[0] = '\0';
d_consolidated_yn.arr[0] = '\0';
d_print_flag.arr[0] = '\0';
d_dp_invoice_yn.arr[0] = '\0';


d_operating_facility_id.len = 0;
d_ar_inv_doc_type_code.len         = 0;
d_ar_inv_doc_num.len               = 0;
d_ar_inv_doc_date.len              = 0;
d_ar_inv_due_date.len = 0;
d_ar_inv_cust_code.len             = 0;
d_ar_pmnt_terms_code.len           = 0;
d_ar_inv_patient_id.len            = 0;
d_ar_inv_bill_doc_type_code.len    = 0;
d_ar_inv_bill_num.len              = 0;
d_ar_inv_cust_ref.len              = 0;
d_ar_inv_narration.len             = 0;
d_ar_inv_rowid.len                 = 0;
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
d_misc_cust_contact_title.len  = 0;
d_module_id.len = 0;
d_consolidated_yn.len = 0;
d_print_flag.len = 0;
d_dp_invoice_yn.len = 0;

d_ar_inv_payable_amt               = 0;
d_ar_inv_gross_amt                 = 0;
d_ar_inv_discount_amt              = 0;
d_ar_inv_markup_amt                = 0;
d_invoice_amt                      = 0;
tot_amount                         = 0;

pctr = 0;
lctr = 0;
no_of_lines  = 0;  
inc          = 0;
nstart       = 0;



    /* EXEC SQL FETCH AR_INV_HDR_CUR
              INTO :d_operating_facility_id,
			       :d_ar_inv_doc_type_code,
                   :d_ar_inv_doc_num,
                   :d_ar_inv_doc_date,
				   :d_ar_inv_due_date,
                   :d_ar_inv_cust_code,
				   :d_ar_pmnt_terms_code,
                   :d_ar_inv_patient_id,
                   :d_ar_inv_bill_doc_type_code,
                   :d_ar_inv_bill_num,
                   :d_ar_inv_cust_ref,
                   :d_ar_inv_narration,
                   :d_ar_inv_gross_amt,
                   :d_ar_inv_discount_amt,
				   :d_ar_inv_markup_amt,
                   :d_ar_inv_payable_amt,
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
                   :d_misc_cust_contact_title,
                   :d_ar_inv_rowid,
				   :d_module_id,
				   :d_consolidated_yn,
				   :d_print_flag ,
				   :d_dp_invoice_yn; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )184;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_ar_inv_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )9;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_ar_inv_doc_num;
    sqlstm.sqhstl[2] = (unsigned int  )12;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_ar_inv_doc_date;
    sqlstm.sqhstl[3] = (unsigned int  )14;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_ar_inv_due_date;
    sqlstm.sqhstl[4] = (unsigned int  )14;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_ar_inv_cust_code;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_ar_pmnt_terms_code;
    sqlstm.sqhstl[6] = (unsigned int  )5;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_ar_inv_patient_id;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_ar_inv_bill_doc_type_code;
    sqlstm.sqhstl[8] = (unsigned int  )9;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_ar_inv_bill_num;
    sqlstm.sqhstl[9] = (unsigned int  )12;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_ar_inv_cust_ref;
    sqlstm.sqhstl[10] = (unsigned int  )18;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_ar_inv_narration;
    sqlstm.sqhstl[11] = (unsigned int  )53;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_ar_inv_gross_amt;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_ar_inv_discount_amt;
    sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_ar_inv_markup_amt;
    sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_ar_inv_payable_amt;
    sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_misc_cust_long_name;
    sqlstm.sqhstl[16] = (unsigned int  )103;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&d_misc_cust_short_name;
    sqlstm.sqhstl[17] = (unsigned int  )103;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_misc_cust_add1_desc;
    sqlstm.sqhstl[18] = (unsigned int  )63;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&d_misc_cust_add2_desc;
    sqlstm.sqhstl[19] = (unsigned int  )63;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&d_misc_cust_add3_desc;
    sqlstm.sqhstl[20] = (unsigned int  )63;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&d_misc_cust_zip_desc;
    sqlstm.sqhstl[21] = (unsigned int  )33;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&d_misc_cust_long_name_chi;
    sqlstm.sqhstl[22] = (unsigned int  )103;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&d_misc_cust_short_name_chi;
    sqlstm.sqhstl[23] = (unsigned int  )103;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&d_misc_cust_add1_desc_chi;
    sqlstm.sqhstl[24] = (unsigned int  )63;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&d_misc_cust_add2_desc_chi;
    sqlstm.sqhstl[25] = (unsigned int  )63;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&d_misc_cust_add3_desc_chi;
    sqlstm.sqhstl[26] = (unsigned int  )63;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&d_misc_cust_zip_desc_chi;
    sqlstm.sqhstl[27] = (unsigned int  )33;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&d_misc_cust_contact_name;
    sqlstm.sqhstl[28] = (unsigned int  )103;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&d_misc_cust_contact_title;
    sqlstm.sqhstl[29] = (unsigned int  )63;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&d_ar_inv_rowid;
    sqlstm.sqhstl[30] = (unsigned int  )33;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&d_module_id;
    sqlstm.sqhstl[31] = (unsigned int  )5;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqhstv[32] = (         void  *)&d_consolidated_yn;
    sqlstm.sqhstl[32] = (unsigned int  )4;
    sqlstm.sqhsts[32] = (         int  )0;
    sqlstm.sqindv[32] = (         void  *)0;
    sqlstm.sqinds[32] = (         int  )0;
    sqlstm.sqharm[32] = (unsigned int  )0;
    sqlstm.sqadto[32] = (unsigned short )0;
    sqlstm.sqtdso[32] = (unsigned short )0;
    sqlstm.sqhstv[33] = (         void  *)&d_print_flag;
    sqlstm.sqhstl[33] = (unsigned int  )4;
    sqlstm.sqhsts[33] = (         int  )0;
    sqlstm.sqindv[33] = (         void  *)0;
    sqlstm.sqinds[33] = (         int  )0;
    sqlstm.sqharm[33] = (unsigned int  )0;
    sqlstm.sqadto[33] = (unsigned short )0;
    sqlstm.sqtdso[33] = (unsigned short )0;
    sqlstm.sqhstv[34] = (         void  *)&d_dp_invoice_yn;
    sqlstm.sqhstl[34] = (unsigned int  )4;
    sqlstm.sqhsts[34] = (         int  )0;
    sqlstm.sqindv[34] = (         void  *)0;
    sqlstm.sqinds[34] = (         int  )0;
    sqlstm.sqharm[34] = (unsigned int  )0;
    sqlstm.sqadto[34] = (unsigned short )0;
    sqlstm.sqtdso[34] = (unsigned short )0;
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
         err_mesg("FETCH failed on cursor AR_INV_HDR_CUR",0,"");

d_operating_facility_id.arr[d_operating_facility_id.len] = '\0';
d_ar_inv_doc_type_code.arr[d_ar_inv_doc_type_code.len] = '\0';
d_ar_inv_doc_num.arr[d_ar_inv_doc_num.len] = '\0';
d_ar_inv_doc_date.arr[d_ar_inv_doc_date.len] = '\0';
d_ar_inv_due_date.arr[d_ar_inv_due_date.len] = '\0';
d_ar_inv_cust_code.arr[d_ar_inv_cust_code.len] = '\0';
d_ar_pmnt_terms_code.arr[d_ar_pmnt_terms_code.len]   = '\0';
d_ar_inv_patient_id.arr[d_ar_inv_patient_id.len] = '\0';
d_ar_inv_bill_doc_type_code.arr[d_ar_inv_bill_doc_type_code.len] = '\0';
d_ar_inv_bill_num.arr[d_ar_inv_bill_num.len] = '\0';
d_ar_inv_cust_ref.arr[d_ar_inv_cust_ref.len] = '\0';
d_ar_inv_narration.arr[d_ar_inv_narration.len] = '\0';
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
d_misc_cust_contact_title.arr[d_misc_cust_contact_title.len]  = '\0';
d_module_id.arr[d_module_id.len] = '\0';
d_consolidated_yn.arr[d_consolidated_yn.len] = '\0';
d_print_flag.arr[d_print_flag.len] = '\0';
d_dp_invoice_yn.arr[d_dp_invoice_yn.len] = '\0';

   if (LAST_ROW)
       return (0);
   else
       return (1);

}

fetch_cust_det()
{
    /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0010;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )339;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_inv_cust_code;
    sqlstm.sqhstl[0] = (unsigned int  )11;
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
         err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR",0,"");

    d_ar_cust_long_name.arr[0]          = '\0';
    d_ar_cust_short_name.arr[0]         = '\0';
    d_ar_cust_add1_desc.arr[0]          = '\0';
    d_ar_cust_add2_desc.arr[0]          = '\0';
    d_ar_cust_add3_desc.arr[0]          = '\0';
    d_ar_cust_zip_desc.arr[0]           = '\0';
    d_ar_cust_contact_name.arr[0]       = '\0';
    d_ar_cust_contact_title.arr[0] = '\0';
    d_misc_customer_flag                = '\0';
    d_chinese_reporting_flag            = '\0';

    d_ar_cust_long_name.len             = 0;
    d_ar_cust_short_name.len            = 0;
    d_ar_cust_add1_desc.len             = 0;
    d_ar_cust_add2_desc.len             = 0;
    d_ar_cust_add3_desc.len             = 0;
    d_ar_cust_zip_desc.len              = 0;
    d_ar_cust_contact_name.len          = 0;
    d_ar_cust_contact_title.len    = 0;

    /* EXEC SQL FETCH AR_CUSTOMER_CUR
              INTO :d_ar_cust_long_name,
                   :d_ar_cust_short_name,
                   :d_ar_cust_add1_desc,
                   :d_ar_cust_add2_desc,
                   :d_ar_cust_add3_desc,
                   :d_ar_cust_zip_desc,
                   :d_ar_cust_contact_name,
                   :d_ar_cust_contact_title,
		   :d_misc_customer_flag,
		   :d_chinese_reporting_flag; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )358;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_cust_long_name;
    sqlstm.sqhstl[0] = (unsigned int  )103;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_ar_cust_short_name;
    sqlstm.sqhstl[1] = (unsigned int  )63;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_ar_cust_add1_desc;
    sqlstm.sqhstl[2] = (unsigned int  )63;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_ar_cust_add2_desc;
    sqlstm.sqhstl[3] = (unsigned int  )63;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_ar_cust_add3_desc;
    sqlstm.sqhstl[4] = (unsigned int  )63;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_ar_cust_zip_desc;
    sqlstm.sqhstl[5] = (unsigned int  )33;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_ar_cust_contact_name;
    sqlstm.sqhstl[6] = (unsigned int  )103;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_ar_cust_contact_title;
    sqlstm.sqhstl[7] = (unsigned int  )63;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_misc_customer_flag;
    sqlstm.sqhstl[8] = (unsigned int  )1;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_chinese_reporting_flag;
    sqlstm.sqhstl[9] = (unsigned int  )1;
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



     if (OERROR)
         err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR",0,"");

d_ar_cust_long_name.arr[d_ar_cust_long_name.len] = '\0';
d_ar_cust_short_name.arr[d_ar_cust_short_name.len] = '\0';
d_ar_cust_add1_desc.arr[d_ar_cust_add1_desc.len] = '\0';
d_ar_cust_add2_desc.arr[d_ar_cust_add2_desc.len] = '\0';
d_ar_cust_add3_desc.arr[d_ar_cust_add3_desc.len] = '\0';
d_ar_cust_zip_desc.arr[d_ar_cust_zip_desc.len] = '\0';
d_ar_cust_contact_name.arr[d_ar_cust_contact_name.len] = '\0';
d_ar_cust_contact_title.arr[d_ar_cust_contact_title.len] = '\0';

if(d_misc_customer_flag == 'Y') {
    if(d_chinese_reporting_flag == 'Y') {
	strcpy(d_ar_cust_long_name.arr,d_misc_cust_long_name_chi.arr);
	strcpy(d_ar_cust_short_name.arr,d_misc_cust_short_name_chi.arr);
	strcpy(d_ar_cust_add1_desc.arr,d_misc_cust_add1_desc_chi.arr);
	strcpy(d_ar_cust_add2_desc.arr,d_misc_cust_add2_desc_chi.arr);
	strcpy(d_ar_cust_add3_desc.arr,d_misc_cust_add3_desc_chi.arr);
	strcpy(d_ar_cust_zip_desc.arr,d_misc_cust_zip_desc_chi.arr);
    }
    else {
	strcpy(d_ar_cust_long_name.arr,d_misc_cust_long_name.arr);
	strcpy(d_ar_cust_short_name.arr,d_misc_cust_short_name.arr);
	strcpy(d_ar_cust_add1_desc.arr,d_misc_cust_add1_desc.arr);
	strcpy(d_ar_cust_add2_desc.arr,d_misc_cust_add2_desc.arr);
	strcpy(d_ar_cust_add3_desc.arr,d_misc_cust_add3_desc.arr);
	strcpy(d_ar_cust_zip_desc.arr,d_misc_cust_zip_desc.arr);
    }

    strcpy(d_ar_cust_contact_name.arr,d_misc_cust_contact_name.arr);
    strcpy(d_ar_cust_contact_title.arr,d_misc_cust_contact_title.arr);

    d_ar_cust_long_name.len = strlen(d_ar_cust_long_name.arr);
    d_ar_cust_short_name.len = strlen(d_ar_cust_short_name.arr);
    d_ar_cust_add1_desc.len = strlen(d_ar_cust_add1_desc.arr);
    d_ar_cust_add2_desc.len = strlen(d_ar_cust_add2_desc.arr);
    d_ar_cust_add3_desc.len = strlen(d_ar_cust_add3_desc.arr);
    d_ar_cust_zip_desc.len = strlen(d_ar_cust_zip_desc.arr);
    d_ar_cust_contact_name.len = strlen(d_ar_cust_contact_name.arr);
    d_ar_cust_contact_title.len = strlen(d_ar_cust_contact_title.arr);
}

}


open_patient_dtls()
{
   /* EXEC SQL OPEN AR_PATIENT_DTLS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 35;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )413;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_inv_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_inv_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )12;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_ar_inv_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ar_inv_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )12;
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
         err_mesg("OPEN failed on cursor AR_PATIENT_DTLS_CUR",0,"");

}


open_lab_dtls()
{
   /* EXEC SQL OPEN AR_LAB_DTLS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 35;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0008;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )444;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_inv_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_inv_doc_num;
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



   if (OERROR)
         err_mesg("OPEN failed on cursor AR_LAB_DTLS_CUR",0,"");

}


fetch_lab_dtls()
{
d_ar_pat_patient_id.arr[0]         = '\0';
d_ar_pat_bill_doc_type_code.arr[0] = '\0';
d_ar_pat_bill_num.arr[0]           = '\0';
d_ar_pat_bill_date.arr[0]          = '\0';
d_ar_pat_remarks.arr[0]            = '\0';
d_ar_pat_lab_test.arr[0]           = '\0';
d_ar_pat_patient_name.arr[0]       = '\0';

d_ar_pat_patient_id.len            = 0;
d_ar_pat_bill_doc_type_code.len    = 0;
d_ar_pat_bill_num.len              = 0;
d_ar_pat_bill_date.len             = 0;
d_ar_pat_remarks.len               = 0;
d_ar_pat_lab_test.len              = 0;
d_ar_pat_patient_name.len          = 0;

d_ar_pat_amount                    = 0;



   /* EXEC SQL FETCH AR_LAB_DTLS_CUR
             INTO :d_ar_pat_patient_id,
                  :d_ar_pat_bill_doc_type_code,
                  :d_ar_pat_bill_num,
                  :d_ar_pat_bill_date,
				  :d_ar_pat_remarks,
				  :d_ar_pat_lab_test,
                  :d_ar_pat_amount; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 35;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )467;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_pat_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_pat_bill_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_ar_pat_bill_num;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ar_pat_bill_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_ar_pat_remarks;
   sqlstm.sqhstl[4] = (unsigned int  )18;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_ar_pat_lab_test;
   sqlstm.sqhstl[5] = (unsigned int  )18;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_ar_pat_amount;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
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
         err_mesg("FETCH failed on cursor AR_LAB_DTLS_CUR",0,"");

d_ar_pat_patient_id.arr[d_ar_pat_patient_id.len] = '\0';
d_ar_pat_patient_name.arr[d_ar_pat_patient_name.len] = '\0';
d_ar_pat_bill_doc_type_code.arr[d_ar_pat_bill_doc_type_code.len] = '\0';
d_ar_pat_bill_num.arr[d_ar_pat_bill_num.len] = '\0';
d_ar_pat_bill_date.arr[d_ar_pat_bill_date.len] = '\0';
d_ar_pat_remarks.arr[d_ar_pat_remarks.len] = '\0';
d_ar_pat_lab_test.arr[d_ar_pat_lab_test.len] = '\0';

  if (LAST_ROW)
      return (0);
  else
      return (1);
}

//08/02/2008 

/*open_cssd_dtls()
{
   EXEC SQL OPEN AR_CSSD_DTLS_CUR;

   if (OERROR)
         err_mesg("OPEN failed on cursor AR_CSSD_DTLS_CUR",0,"");

}

fetch_cssd_dtls()
{


	d_ar_cssd_doc_type_code.arr[0]	 = '\0';
	d_ar_cssd_doc_num.arr[0]		 = '\0';
	d_ar_cssd_doc_date.arr[0]		 = '\0';

	d_ar_cssd_doc_type_code.len		= 0;
	d_ar_cssd_doc_num.len			= 0;
	d_ar_cssd_doc_date.len			= 0;

	d_ar_cssd_doc_amt = 0;


   EXEC SQL FETCH AR_CSSD_DTLS_CUR
             INTO	:d_ar_cssd_doc_type_code,
					:d_ar_cssd_doc_num,
					:d_ar_cssd_doc_date,					
					:d_ar_cssd_doc_amt;

   if (OERROR)
         err_mesg("FETCH failed on cursor AR_CSSD_DTLS_CUR",0,"");

	d_ar_cssd_doc_type_code.arr[d_ar_cssd_doc_type_code.len] = '\0';
	d_ar_cssd_doc_num.arr[d_ar_cssd_doc_num.len]			 = '\0';
	d_ar_cssd_doc_date.arr[d_ar_cssd_doc_date.len]			 = '\0';	


  if (LAST_ROW)
      return (0);
  else
      return (1);
}


*/  

//08/02/2008
open_dp_dtls()
{
   /* EXEC SQL OPEN AR_DP_DTLS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 35;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0009;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )510;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_inv_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_inv_doc_num;
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



   if (OERROR)
         err_mesg("OPEN failed on cursor AR_DP_DTLS_CUR",0,"");

}


fetch_dp_dtls()
{


	d_ar_dp_doc_type_code.arr[0] = '\0';
	d_ar_dp_doc_num.arr[0]		 = '\0';
	d_ar_dp_doc_date.arr[0]		 = '\0';
	d_ar_dp_doc_ref.arr[0]		 = '\0';



	d_ar_dp_doc_type_code.len	= 0;
	d_ar_dp_doc_num.len			= 0;
	d_ar_dp_doc_date.len		= 0;
	d_ar_dp_doc_ref.len			= 0;

	d_ar_dp_doc_amt = 0;



   /* EXEC SQL FETCH AR_DP_DTLS_CUR
             INTO	:d_ar_dp_doc_type_code,
					:d_ar_dp_doc_num,
					:d_ar_dp_doc_date,
					:d_ar_dp_doc_ref,
					:d_ar_dp_doc_amt; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 35;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )533;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_dp_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_dp_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_ar_dp_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ar_dp_doc_ref;
   sqlstm.sqhstl[3] = (unsigned int  )13;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_ar_dp_doc_amt;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
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
         err_mesg("FETCH failed on cursor AR_DP_DTLS_CUR",0,"");

	d_ar_dp_doc_type_code.arr[d_ar_dp_doc_type_code.len] = '\0';
	d_ar_dp_doc_num.arr[d_ar_dp_doc_num.len]			 = '\0';
	d_ar_dp_doc_date.arr[d_ar_dp_doc_date.len]			 = '\0';
	d_ar_dp_doc_ref.arr[d_ar_dp_doc_ref.len]			 = '\0';


  if (LAST_ROW)
      return (0);
  else
      return (1);
}





fetch_patient_dtls()
{
d_ar_pat_patient_id.arr[0]         = '\0';
d_ar_pat_bill_doc_type_code.arr[0] = '\0';
d_ar_pat_bill_num.arr[0]           = '\0';
d_ar_pat_bill_date.arr[0]          = '\0';
d_ar_pat_remarks.arr[0]            = '\0';
d_ar_pat_lab_test.arr[0]           = '\0';
d_ar_pat_patient_name.arr[0]       = '\0';

d_ar_pat_patient_id.len            = 0;
d_ar_pat_bill_doc_type_code.len    = 0;
d_ar_pat_bill_num.len              = 0;
d_ar_pat_bill_date.len             = 0;
d_ar_pat_remarks.len               = 0;
d_ar_pat_lab_test.len              = 0;
d_ar_pat_patient_name.len          = 0;

d_ar_pat_amount                    = 0;

   /* EXEC SQL FETCH AR_PATIENT_DTLS_CUR
             INTO :d_ar_pat_patient_id,
                  :d_ar_pat_bill_doc_type_code,
                  :d_ar_pat_bill_num,
                  :d_ar_pat_bill_date,
                  :d_ar_pat_amount; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 35;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )568;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_pat_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_pat_bill_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_ar_pat_bill_num;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ar_pat_bill_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_ar_pat_amount;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
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
         err_mesg("FETCH failed on cursor AR_PATIENT_DTLS_CUR",0,"");

d_ar_pat_patient_id.arr[d_ar_pat_patient_id.len] = '\0';
d_ar_pat_patient_name.arr[d_ar_pat_patient_name.len] = '\0';
d_ar_pat_bill_doc_type_code.arr[d_ar_pat_bill_doc_type_code.len] = '\0';
d_ar_pat_bill_num.arr[d_ar_pat_bill_num.len] = '\0';
d_ar_pat_bill_date.arr[d_ar_pat_bill_date.len] = '\0';
d_ar_pat_remarks.arr[d_ar_pat_remarks.len] = '\0';
d_ar_pat_lab_test.arr[d_ar_pat_lab_test.len] = '\0';


  if (LAST_ROW)
      return (0);
  else
      return (1);
}

open_patient_inv_dtls()
{
                 
    /* EXEC SQL OPEN AR_PATIENT_DTLS_INV_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )603;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_inv_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_ar_inv_doc_num;
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



   if (OERROR)
         err_mesg("OPEN failed on cursor AR_PATIENT_DTLS_INV_CUR",0,"");

}


fetch_patient_inv_dtls()
{
d_ar_pat_patient_id.arr[0]         = '\0';
d_ar_pat_bill_doc_type_code.arr[0] = '\0';
d_ar_pat_bill_num.arr[0]           = '\0';
d_ar_pat_bill_date.arr[0]          = '\0';
d_ar_pat_remarks.arr[0]            = '\0';
d_ar_pat_lab_test.arr[0]           = '\0';
d_ar_pat_patient_name.arr[0]       = '\0';

d_ar_pat_patient_id.len            = 0;
d_ar_pat_bill_doc_type_code.len    = 0;
d_ar_pat_bill_num.len              = 0;
d_ar_pat_bill_date.len             = 0;
d_ar_pat_remarks.len               = 0;
d_ar_pat_lab_test.len              = 0;
d_ar_pat_patient_name.len          = 0;

d_ar_pat_amount                    = 0;

   /* EXEC SQL FETCH AR_PATIENT_DTLS_INV_CUR
             INTO :d_ar_pat_patient_id,
                  :d_ar_pat_bill_doc_type_code,
                  :d_ar_pat_bill_num,
                  :d_ar_pat_bill_date,
                  :d_ar_pat_amount; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 35;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )626;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_ar_pat_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_pat_bill_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_ar_pat_bill_num;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_ar_pat_bill_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_ar_pat_amount;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
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
         err_mesg("FETCH failed on cursor AR_PATIENT_DTLS_INV_CUR",0,"");

d_ar_pat_patient_id.arr[d_ar_pat_patient_id.len] = '\0';
d_ar_pat_patient_name.arr[d_ar_pat_patient_name.len] = '\0';
d_ar_pat_bill_doc_type_code.arr[d_ar_pat_bill_doc_type_code.len] = '\0';
d_ar_pat_bill_num.arr[d_ar_pat_bill_num.len] = '\0';
d_ar_pat_bill_date.arr[d_ar_pat_bill_date.len] = '\0';
d_ar_pat_remarks.arr[d_ar_pat_remarks.len] = '\0';
d_ar_pat_lab_test.arr[d_ar_pat_lab_test.len] = '\0';

  if (LAST_ROW)
      return (0);
  else
      return (1);
}




print_page_head()
{


pctr += 1;
lctr = 0;

if (strcmp(d_print_flag.arr, "Y") == 0)
{

		if (strcmp(d_rep_option.arr , "P") == 0)
		   fprintf(fp, "%c(s4H", ESC);
		
		fprintf(fp , "  ** DUPLICATE ** ");
		
		if (strcmp(d_rep_option.arr , "P") == 0)
		    fprintf(fp, "%c(s10H", ESC);
		
		fprintf(fp ,"\n\n");  


                      
		if (strcmp(d_preprinted_flag.arr , "Y") == 0)
		{

		fprintf(fp , "                                                         NO: %-6s/%-8s\n\n",
		   d_ar_inv_doc_type_code.arr, d_ar_inv_doc_num.arr);
		}
		else
		{

		fprintf(fp , "                                    INVOICE              NO: %-6s/%-8s\n\n",
		   d_ar_inv_doc_type_code.arr, d_ar_inv_doc_num.arr);
		}


}
else
{

		if (strcmp(d_preprinted_flag.arr , "Y") == 0)
		{
		fprintf(fp , "                                                         NO: %-6s/%-8s\n\n",
		   d_ar_inv_doc_type_code.arr, d_ar_inv_doc_num.arr);

		}
		else
		{
		fprintf(fp , "                                    INVOICE              NO: %-6s/%-8s\n\n",
		   d_ar_inv_doc_type_code.arr, d_ar_inv_doc_num.arr);
		}

	}

if (strcmp(d_module_id.arr , "RL") == 0)
{

  fprintf(fp,"                  (For Patient Services - Lab Charges)       DATE:%10s\n\n",
  d_ar_inv_doc_date.arr);
}
else if ((strcmp(d_module_id.arr , "BL") == 0) || (strcmp(d_ar_inv_bill_num.arr , "\0") != 0))
{

  fprintf(fp,"                              (For Patient Services)         DATE:%10s\n\n",
  d_ar_inv_doc_date.arr);
}
else if (strcmp(d_module_id.arr , "SS") == 0)
{

  fprintf(fp,"                              (For CSSD Services)            DATE:%10s\n\n",
  d_ar_inv_doc_date.arr);
} 

else if (strcmp(d_module_id.arr , "ST") == 0)
{

  fprintf(fp,"                  (For External Sales - From Stock)          DATE:%10s\n\n",
  d_ar_inv_doc_date.arr);
}

else
{

fprintf(fp,"                                                             DATE:%10s\n\n",
  d_ar_inv_doc_date.arr);
}


fprintf(fp,"                                                         DUE DATE:%10s\n\n",
d_ar_inv_due_date.arr);

fprintf(fp,"   %-8s   ",d_ar_inv_cust_code.arr);
fprintf(fp,"%-40s\n",d_ar_cust_long_name.arr);
fprintf(fp,"              %-30s\n",d_ar_cust_add1_desc.arr);
fprintf(fp,"              %-30s\n",d_ar_cust_add2_desc.arr);
fprintf(fp,"              %-30s\n\n",d_ar_cust_add3_desc.arr);
   
   
fprintf(fp,"ATTN : MR.%-40s\n",d_ar_cust_contact_name.arr);   
   
fprintf(fp,"          %-40s",d_ar_cust_contact_title.arr);

fprintf(fp,"       Ref : %-15s\n\n",d_ar_inv_cust_ref.arr);

if (strcmp(d_preprinted_flag.arr , "N") == 0)
{
	fprintf(fp,"------------------------------------------------------------------------------\n");
}
else
{
fprintf(fp,"\n");
}

   

#ifdef DEBUG
    disp_message(INFO_MESG,"completed print_page_head\n");
    fflush(fp);
#endif
}



print_patient_inv_head()
{
	if (strcmp(d_preprinted_flag.arr , "N") == 0)
	{   
	   fprintf(fp, "BILL DATE  BILL NUMBER     EPISODE     PATIENT NAME                BILL AMOUNT\n");
	   fprintf(fp,"------------------------------------------------------------------------------\n\n");
	}
	else
	{
	fprintf(fp,"\n\n");
	} 
}


print_patient_lab_head()
{
	if (strcmp(d_preprinted_flag.arr , "N") == 0)
	{   
	   fprintf(fp, "LAB DATE    CHARGE SLIP/NO   REFERENCE        LAB TEST             BILL AMOUNT\n");
	   fprintf(fp,"------------------------------------------------------------------------------\n\n");
	}
	else
	{
	fprintf(fp,"\n\n");
	}
}
print_cssd_head()
{
	if (strcmp(d_preprinted_flag.arr , "N") == 0)
	{   
	   fprintf(fp, "DOC DATE     DOC NUMBER                                                 AMOUNT\n"); 
	   fprintf(fp,"------------------------------------------------------------------------------\n\n");
	}
	else
	{
	fprintf(fp,"\n\n");
	}
}

print_dp_head()
{
	if (strcmp(d_preprinted_flag.arr , "N") == 0)
	{   
	   fprintf(fp, "DOC TYPE CODE / NUM  DATE        REFERENCE                              AMOUNT\n");
	   fprintf(fp,"------------------------------------------------------------------------------\n\n");
	}
	else
	{
	fprintf(fp,"\n\n");
	}
}


get_patient_name() 
{
   
    d_ar_mp_patient_name.arr[0]   = '\0';
	d_ar_mp_patient_name.len      = 0; 


  if (strcmp(d_module_id.arr , "BL") == 0)
    {
		/* EXEC SQL SELECT SUBSTR(SHORT_NAME ,1,25)
				   INTO :d_ar_mp_patient_name
	               FROM MP_PATIENT_MAST
	              WHERE PATIENT_ID = :d_ar_pat_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 35;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SUBSTR(SHORT_NAME,1,25) into :b0  from MP_PATIENT_MA\
ST where PATIENT_ID=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )661;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_ar_mp_patient_name;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_ar_pat_patient_id;
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


    }
  else
    {
		/* EXEC SQL SELECT SUBSTR(SHORT_NAME ,1,25)
			       INTO   :d_ar_mp_patient_name
	               FROM MP_PATIENT_MAST
	              WHERE PATIENT_ID = :d_ar_inv_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 35;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SUBSTR(SHORT_NAME,1,25) into :b0  from MP_PATIENT_MA\
ST where PATIENT_ID=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )684;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_ar_mp_patient_name;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_ar_inv_patient_id;
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


    }

   d_ar_mp_patient_name.arr[d_ar_mp_patient_name.len] = '\0';

    if(OERROR)
	err_mesg("SELECT failed on MP_PATIENT_MAST",0,"");

}


get_episode_id()
{
   
    d_episode_type.arr[0]   = '\0';
	d_episode_type.len      = 0;
	d_episode_id.arr[0]     = '\0';
	d_episode_id.len        = 0;

    /* EXEC SQL SELECT EPISODE_TYPE, 
	                EPISODE_ID
			 INTO   :d_episode_type,
	                :d_episode_id
	       FROM BL_BILL_HDR
	       WHERE doc_type_code = :d_ar_pat_bill_doc_type_code
           AND   doc_num       = :d_ar_pat_bill_num
		   AND   operating_facility_id = :d_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select EPISODE_TYPE ,EPISODE_ID into :b0,:b1  from BL_BIL\
L_HDR where ((doc_type_code=:b2 and doc_num=:b3) and operating_facility_id=:b4\
)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )707;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_ar_pat_bill_doc_type_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_ar_pat_bill_num;
    sqlstm.sqhstl[3] = (unsigned int  )12;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_operating_facility_id;
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




   d_episode_type.arr[d_episode_type.len] = '\0';
   d_episode_id.arr[d_episode_id.len] = '\0';

    if(OERROR)
	err_mesg("SELECT failed on BL_BILL_HDR",0,"");

}
get_markup_percent()
{

d_markup_perc = 0 ;
/* Commented on 13-08-2003 by Muthu
   EXEC SQL
         SELECT C.MARKUP_PERC 
		 into   :d_markup_perc
		 FROM  AR_CUSTOMER A , AR_CUST_GROUP B , AR_PMNT_TERMS C
         WHERE A.CUST_CODE =  :d_ar_inv_cust_code
         AND   A.CUST_GROUP_CODE =  B.CUST_GROUP_CODE
         AND   B.PMNT_TERMS_CODE =  C.PMNT_TERMS_CODE;
*/ 
/* Added on 13-08-2003 by Muthu  */
   /* EXEC SQL
         SELECT C.MARKUP_PERC 
		 into   :d_markup_perc
		 FROM  AR_PMNT_TERMS C
         WHERE PMNT_TERMS_CODE = :d_ar_pmnt_terms_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 35;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select C.MARKUP_PERC into :b0  from AR_PMNT_TERMS C where \
PMNT_TERMS_CODE=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )742;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_markup_perc;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_ar_pmnt_terms_code;
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


	if(OERROR)
	err_mesg("SELECT failed on AR_PMNT_TERMS",0,"");

}
 
print_pat_dtls()
{

  if ((lctr == 0) && (pctr > 1))
  {
       fprintf(fp, "                                                       B/F  ");
	   print_formated_tot(tot_amount);
	   fprintf(fp,"\n");
	   

  } 
 

  fprintf(fp, "%-10s" ,d_ar_pat_bill_date.arr);
  fprintf(fp, " %-6s/%-8s" ,d_ar_pat_bill_doc_type_code.arr ,d_ar_pat_bill_num.arr);
  fprintf(fp, " %-1s/%-8s" ,d_episode_type.arr ,d_episode_id.arr);
  fprintf(fp, " %-25s ", d_ar_mp_patient_name.arr);
  print_formated(d_ar_pat_amount);
   fprintf(fp,"\n");
   
   tot_amount += d_ar_pat_amount;

   lctr += 1;

   
}

print_lab_dtls()
{

  if ((lctr == 0) && (pctr > 1))
  {
       fprintf(fp, "                                                       B/F ");
	   print_formated_tot(tot_amount);
	   fprintf(fp,"\n");
	   

  }



  fprintf(fp, "%-10s " ,d_ar_pat_bill_date.arr);
  fprintf(fp, " %-6s/%-8s " ,d_ar_pat_bill_doc_type_code.arr ,d_ar_pat_bill_num.arr);
  fprintf(fp, " %-15s " ,d_ar_pat_remarks.arr);
  fprintf(fp, " %-15s   ", d_ar_pat_lab_test.arr);
  print_formated(d_ar_pat_amount);
   fprintf(fp,"\n");
   
   tot_amount += d_ar_pat_amount;

   lctr += 1;

   
}

print_cssd_dtls()
{

  if ((lctr == 0) && (pctr > 1))
  {
       fprintf(fp, "                                                       B/F  ");
	   print_formated_tot(tot_amount);
	   fprintf(fp,"\n");
	   

  }
  
  fprintf(fp, "%-10s " ,d_ar_cssd_doc_date.arr);
  fprintf(fp, "  %-6s / %-8s                                  " ,d_ar_cssd_doc_type_code.arr ,d_ar_cssd_doc_num.arr);  
  
  print_formated(d_ar_cssd_doc_amt);
  fprintf(fp,"\n");
   
   tot_amount += d_ar_cssd_doc_amt;

   lctr += 1;

    
}

print_dp_dtls()
{

  if ((lctr == 0) && (pctr > 1))
  {
       fprintf(fp, "                                                       B/F  ");
	   print_formated_tot(tot_amount);
	   fprintf(fp,"\n");
	   

  }


  
  fprintf(fp, " %-6s / %-8s   " ,d_ar_dp_doc_type_code.arr ,d_ar_dp_doc_num.arr);
  fprintf(fp, "%-10s " ,d_ar_dp_doc_date.arr);
  fprintf(fp, " %-10s                     " ,d_ar_dp_doc_ref.arr);
  print_formated(d_ar_dp_doc_amt);
   fprintf(fp,"\n");
   
   tot_amount += d_ar_dp_doc_amt;

   lctr += 1;

    
}


print_inv_tot()
{  

   fprintf(fp ,"                                                                --------------\n");
   fprintf(fp,"                                                     TOTAL ");
   print_formated_tot(tot_amount);
   fprintf(fp, "\n");
   fprintf(fp ,"                                                                --------------\n");
   fprintf(fp,"                                           LESS   DISCOUNT      ");
   print_formated( d_ar_inv_discount_amt);
   fprintf(fp, "\n");
   fprintf(fp ,"                                                                --------------\n");
   
   fprintf(fp,"                                               MARKUP %3d" , d_markup_perc);
   fprintf(fp,"%%      "); 

   print_formated( d_ar_inv_markup_amt);
   fprintf(fp, "\n");
   fprintf(fp ,"                                                                --------------\n");

   d_invoice_amt = tot_amount + d_ar_inv_markup_amt - d_ar_inv_discount_amt;

   fprintf(fp,"                                            INVOICE AMOUNT      ");
   print_formated( d_invoice_amt);
   fprintf(fp, "\n");
   fprintf(fp ,"                                                                --------------\n"); 
 
       
    no_of_lines = print_in_words(d_invoice_amt,LENGTH_WORDS,sub_cur_str.arr,amt_in_words,nd_no_of_dec );
	
	strcpy(cond_amount.arr,cur_str.arr);
	strcat (cond_amount.arr," ");

       

	for (i =0;i<no_of_lines;i++)
   	 { 
	    if (i==0) strcat(cond_amount.arr,amt_in_words[i]);
		else      strcpy(cond_amount.arr,amt_in_words[i]);
	    fprintf(fp,"%s\n",cond_amount.arr);	
      }
 
  
/* 
	if (d_invoice_amt != 0) 
	{
        inc = 0;
        nstart = 0;

      while (inc < strlen(cond_amount.arr))
     {
       corder_str[0] = '\0'; 
       inc = nstart + inc;
       nstart = split_text(cond_amount.arr,80,corder_str,inc);  
       inc = inc + 1;
       fprintf(fp,"%s",corder_str);
       fprintf(fp,"\n");
     }
	}

*/
 
} 


print_ar_inv()
{
     fprintf( fp ,"%-50s              ", d_ar_inv_narration.arr);
	 print_formated(d_ar_inv_gross_amt);
	 fprintf(fp , "\n");

     tot_amount += d_ar_inv_gross_amt ;
}


 
update_invoice()
{

    /* EXEC SQL UPDATE AR_INV_HDR
                SET PRINT_FLAG = 'Y'
              WHERE ROWID = :d_ar_inv_rowid; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update AR_INV_HDR  set PRINT_FLAG='Y' where ROWID=:b0";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )765;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_ar_inv_rowid;
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
         err_mesg("UPDATE failed on table AR_INV_HDR",0,"");

    /* EXEC SQL COMMIT WORK; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )784;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT failed",0,""); 
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
  sqlstm.arrsiz = 35;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )799;
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
   char out_str[30];

   if (nd_no_of_dec == 3)
      sprintf(out_str,"%14.3f",loc_amount);
   else
      sprintf(out_str,"%14.2f",loc_amount);
				
      //format_amt(out_str,nd_no_of_dec);
         if (loc_amount >= 0)
		    fprintf(fp,"%14s ",out_str);
         else
		    fprintf(fp,"%14s- ",out_str);
}  
  
print_formated_tot(loc_amount)
double loc_amount; 
{ 
   char out_str[30]; 

   if (nd_no_of_dec == 3)
      sprintf(out_str,"%19.3f",loc_amount);
   else
      sprintf(out_str,"%19.2f",loc_amount);

      //format_amt(out_str,nd_no_of_dec);
         if (loc_amount >= 0)
		    fprintf(fp,"%19s ",out_str);
         else
		    fprintf(fp,"%19s- ",out_str);


}
