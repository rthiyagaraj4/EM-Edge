
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
           char  filnam[25];
};
static const struct sqlcxp sqlfpn =
{
    24,
    "D:\\QT\\ar_proc\\IN_POST.PC"
};


static unsigned long sqlctx = 1179348683;


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
            void  *sqhstv[58];
   unsigned int   sqhstl[58];
            int   sqhsts[58];
            void  *sqindv[58];
            int   sqinds[58];
   unsigned int   sqharm[58];
   unsigned int   *sqharc[58];
   unsigned short  sqadto[58];
   unsigned short  sqtdso[58];
} sqlstm = {10,58};

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

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,1352,0,3,279,0,0,56,56,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
244,0,0,2,269,0,3,409,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
307,0,0,3,293,0,3,447,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
350,0,0,4,241,0,5,487,0,0,5,5,0,1,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,9,0,0,
385,0,0,5,328,0,5,500,0,0,8,8,0,1,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
432,0,0,6,131,0,5,532,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
455,0,0,7,1776,0,4,671,0,0,58,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
};


#include <stdio.h>
#include <math.h>

                       

#define OERROR (sqlca.sqlcode < 0)

#define LAST_ROW (sqlca.sqlcode == 1403) //Win Comp. 1403 ===== > 100

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define TABLE_ALREADY_EXISTS (sqlca.sqlcode == -955)

/* EXEC SQL BEGIN DECLARE SECTION; */ 


  /* VARCHAR   l_doc_type_code    [7], 
            l_doc_num          [9],
            l_doc_date         [12],
            l_doc_date_chking  [12],
            l_cust_code        [9],
            l_pmnt_terms_code  [3],
            l_billing_group    [3],
            l_patient_id       [21],
            l_episode_type     [2],
            l_episode_id       [9],
            l_visit_id         [5],

           l_hdr_acc_entity_code                [5],
           l_hdr_last_line_num                  [5],
           l_hdr_narration                      [51],
           l_hdr_base_date                      [12],
           l_hdr_due_date                       [12],
           l_hdr_gross_amt                      [16],
		   l_markup_amt                         [16],
           l_hdr_discount_amt                   [16],
           l_hdr_currency_code                  [8],
           l_hdr_exchg_rate                     [16],
           l_hdr_settlement_date                [12],
           l_hdr_settlement_perc                [6],
           l_hdr_cust_ref                       [16],
           l_hdr_bill_doc_type_code             [7],
           l_hdr_bill_num                       [9],
           l_hdr_bill_date                      [13],
           l_hdr_doctor_fee_amt                 [16],
           l_hdr_post_month                     [3],
           l_hdr_post_year                      [5],
           l_hdr_misc_cust_long_name            [41],
           l_hdr_misc_cust_short_name           [16],
           l_hdr_misc_cust_add1_desc            [31],
           l_hdr_misc_cust_add2_desc            [31],
           l_hdr_misc_cust_add3_desc            [31],
           l_hdr_misc_cust_zip_desc             [31],
           l_hdr_cust_long_name_locl    [41],
           l_hdr_cust_short_name_locl   [16],
           l_hdr_cust_add1_desc_locl    [31],
           l_hdr_cust_add2_desc_locl    [31],
           l_hdr_cust_add3_desc_locl    [31],
           l_hdr_cust_zip_desc_locl     [31],
           l_hdr_tel_num                        [31],
           l_hdr_contact_name                   [41],
           l_hdr_contact_name_title             [41],
           l_hdr_error_flag                     [2],
           l_ar_interface_code                    [2],
           nd_last_inv_doc_date                 [12],
		   l_consolidated_yn      [2],
           l_module_id           [3],
           hdr_rowid_passed                     [31]; */ 
struct { unsigned short len; unsigned char arr[7]; } l_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_doc_num;

struct { unsigned short len; unsigned char arr[12]; } l_doc_date;

struct { unsigned short len; unsigned char arr[12]; } l_doc_date_chking;

struct { unsigned short len; unsigned char arr[9]; } l_cust_code;

struct { unsigned short len; unsigned char arr[3]; } l_pmnt_terms_code;

struct { unsigned short len; unsigned char arr[3]; } l_billing_group;

struct { unsigned short len; unsigned char arr[21]; } l_patient_id;

struct { unsigned short len; unsigned char arr[2]; } l_episode_type;

struct { unsigned short len; unsigned char arr[9]; } l_episode_id;

struct { unsigned short len; unsigned char arr[5]; } l_visit_id;

struct { unsigned short len; unsigned char arr[5]; } l_hdr_acc_entity_code;

struct { unsigned short len; unsigned char arr[5]; } l_hdr_last_line_num;

struct { unsigned short len; unsigned char arr[51]; } l_hdr_narration;

struct { unsigned short len; unsigned char arr[12]; } l_hdr_base_date;

struct { unsigned short len; unsigned char arr[12]; } l_hdr_due_date;

struct { unsigned short len; unsigned char arr[16]; } l_hdr_gross_amt;

struct { unsigned short len; unsigned char arr[16]; } l_markup_amt;

struct { unsigned short len; unsigned char arr[16]; } l_hdr_discount_amt;

struct { unsigned short len; unsigned char arr[8]; } l_hdr_currency_code;

struct { unsigned short len; unsigned char arr[16]; } l_hdr_exchg_rate;

struct { unsigned short len; unsigned char arr[12]; } l_hdr_settlement_date;

struct { unsigned short len; unsigned char arr[6]; } l_hdr_settlement_perc;

struct { unsigned short len; unsigned char arr[16]; } l_hdr_cust_ref;

struct { unsigned short len; unsigned char arr[7]; } l_hdr_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } l_hdr_bill_num;

struct { unsigned short len; unsigned char arr[13]; } l_hdr_bill_date;

struct { unsigned short len; unsigned char arr[16]; } l_hdr_doctor_fee_amt;

struct { unsigned short len; unsigned char arr[3]; } l_hdr_post_month;

struct { unsigned short len; unsigned char arr[5]; } l_hdr_post_year;

struct { unsigned short len; unsigned char arr[41]; } l_hdr_misc_cust_long_name;

struct { unsigned short len; unsigned char arr[16]; } l_hdr_misc_cust_short_name;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_misc_cust_add1_desc;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_misc_cust_add2_desc;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_misc_cust_add3_desc;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_misc_cust_zip_desc;

struct { unsigned short len; unsigned char arr[41]; } l_hdr_cust_long_name_locl;

struct { unsigned short len; unsigned char arr[16]; } l_hdr_cust_short_name_locl;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_cust_add1_desc_locl;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_cust_add2_desc_locl;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_cust_add3_desc_locl;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_cust_zip_desc_locl;

struct { unsigned short len; unsigned char arr[31]; } l_hdr_tel_num;

struct { unsigned short len; unsigned char arr[41]; } l_hdr_contact_name;

struct { unsigned short len; unsigned char arr[41]; } l_hdr_contact_name_title;

struct { unsigned short len; unsigned char arr[2]; } l_hdr_error_flag;

struct { unsigned short len; unsigned char arr[2]; } l_ar_interface_code;

struct { unsigned short len; unsigned char arr[12]; } nd_last_inv_doc_date;

struct { unsigned short len; unsigned char arr[2]; } l_consolidated_yn;

struct { unsigned short len; unsigned char arr[3]; } l_module_id;

struct { unsigned short len; unsigned char arr[31]; } hdr_rowid_passed;

 
   /* VARCHAR  l_hdr_main_acc1_code              [8],
            l_hdr_main_acc2_code              [8],
            l_hdr_dept_code                   [8],
            l_hdr_product_group_code          [4],
            l_hdr_product_line_code           [8],
            l_hdr_subledger_group_code        [4],
            l_hdr_subledger_line_code         [12],
            l_hdr_bill_type_code              [3]; */ 
struct { unsigned short len; unsigned char arr[8]; } l_hdr_main_acc1_code;

struct { unsigned short len; unsigned char arr[8]; } l_hdr_main_acc2_code;

struct { unsigned short len; unsigned char arr[8]; } l_hdr_dept_code;

struct { unsigned short len; unsigned char arr[4]; } l_hdr_product_group_code;

struct { unsigned short len; unsigned char arr[8]; } l_hdr_product_line_code;

struct { unsigned short len; unsigned char arr[4]; } l_hdr_subledger_group_code;

struct { unsigned short len; unsigned char arr[12]; } l_hdr_subledger_line_code;

struct { unsigned short len; unsigned char arr[3]; } l_hdr_bill_type_code;

 double    l_payable_amt;

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA;
 */ 
/*
 * $Header:   E:/MEDICOM-MASTER/archives/MEDICOM-eHIS5/MEDSRC/AR/IN_POST.C-arc   1.0   Nov 16 2005 16:13:30   Administrator  $ sqlca.h 
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


ar_inv_posting(rowid,ar_interface,last_inv_doc_date)
char rowid[],ar_interface[],last_inv_doc_date[];
{
   strcpy(hdr_rowid_passed.arr,rowid);
   hdr_rowid_passed.len = strlen(hdr_rowid_passed.arr);

   strcpy(l_ar_interface_code.arr,ar_interface);
   l_ar_interface_code.len = strlen(l_ar_interface_code.arr);

   strcpy(nd_last_inv_doc_date.arr,last_inv_doc_date);
   nd_last_inv_doc_date.len = strlen(nd_last_inv_doc_date.arr);
   
   select_rec();
/************      Commented on  30-jan-93 for removal of audits ...
  EXEC SQL INSERT INTO AR_AUDIT_INV_HDR
           (
               ACC_ENTITY_CODE,
               DOC_TYPE_CODE,
               DOC_NUM,
               LAST_LINE_NUM,
               CUST_CODE,
               DOC_DATE,
               NARRATION,
               BASE_DATE,
               DUE_DATE,
               GROSS_AMT,
               PAYABLE_AMT,
               DISCOUNT_AMT,
               CURRENCY_CODE,
               EXCHG_RATE,
               PMNT_TERMS_CODE,
               SETTLEMENT_DATE,
               SETTLEMENT_PERC,
               CUST_REF,
               PATIENT_ID,
               BILLING_GROUP,
               BILL_DOC_TYPE_CODE,
               BILL_NUM,
               BILL_DATE,
               DOCTOR_FEE_AMT,
               MAIN_ACC1_CODE,
               MAIN_ACC2_CODE,
               SUBLEDGER_GROUP_CODE,
               SUBLEDGER_LINE_CODE,
               DEPT_CODE,
               PRODUCT_GROUP_CODE,
               PRODUCT_LINE_CODE,
               POST_MONTH,
               POST_YEAR,
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
               TEL_NUM,
               CONTACT_NAME,
               CONTACT_NAME_TITLE,
               ERROR_FLAG,
               MAIN_ACC1_CODE_NEW,
               MAIN_ACC2_CODE_NEW,
               SUBLEDGER_GROUP_CODE_NEW,
               SUBLEDGER_LINE_CODE_NEW,
               DEPT_CODE_NEW,
               PRODUCT_GROUP_CODE_NEW,
               PRODUCT_LINE_CODE_NEW,
               INTERFACE_FLAG,
               POSTED_DATE,
               POSTED_BY_ID
             )
       VALUES
             ( 
                  :l_hdr_acc_entity_code                   ,
                  :l_doc_type_code,
                  :l_doc_num,
                  :l_hdr_last_line_num                     ,
                  :l_cust_code,
                  TO_DATE(:l_doc_date,'DD/MM/YYYY'),
                  :l_hdr_narration                          ,
                  :l_hdr_base_date                          ,
                  :l_hdr_due_date                           ,
                  :l_hdr_gross_amt                          ,
                  :l_payable_amt                        ,
                  :l_hdr_discount_amt                       ,
                  :l_hdr_currency_code                     ,
                  :l_hdr_exchg_rate                         ,
                  :l_pmnt_terms_code,
                  :l_hdr_settlement_date                    ,
                  :l_hdr_settlement_perc                   ,
                  :l_hdr_cust_ref                           ,
                  :l_patient_id                           ,
                  :l_billing_group                           ,
                  :l_hdr_bill_doc_type_code                ,
                  :l_hdr_bill_num                          ,
                  :l_hdr_bill_date                          ,
                  :l_hdr_doctor_fee_amt                     ,
                  :l_hdr_main_acc1_code,
                  :l_hdr_main_acc2_code,
                  :l_hdr_subledger_group_code,
                  :l_hdr_subledger_line_code,
                  :l_hdr_dept_code,
                  :l_hdr_product_group_code,
                  :l_hdr_product_line_code,
                  :l_hdr_post_month                        ,
                  :l_hdr_post_year                         ,
                  :l_hdr_misc_cust_long_name                ,
                  :l_hdr_misc_cust_short_name               ,
                  :l_hdr_misc_cust_add1_desc                ,
                  :l_hdr_misc_cust_add2_desc                ,
                  :l_hdr_misc_cust_add3_desc                ,
                  :l_hdr_misc_cust_zip_desc                 ,
                  :l_hdr_cust_long_name_locl        ,
                  :l_hdr_cust_short_name_locl       ,
                  :l_hdr_cust_add1_desc_locl        ,
                  :l_hdr_cust_add2_desc_locl        ,
                  :l_hdr_cust_add3_desc_locl        ,
                  :l_hdr_cust_zip_desc_locl         ,
                  :l_hdr_tel_num                            ,
                  :l_hdr_contact_name                       ,
                  :l_hdr_contact_name_title                 ,
                  :l_hdr_error_flag  ,
                  :l_hdr_main_acc1_code,
                  :l_hdr_main_acc2_code,
                  :l_hdr_subledger_group_code,
                  :l_hdr_subledger_line_code,
                  :l_hdr_dept_code,
                  :l_hdr_product_group_code,
                  :l_hdr_product_line_code,
                  DECODE(:l_ar_interface_code,'O','Y','N'),
                  SYSDATE,
                  USER
                );

    if (OERROR)
         err_mesg("INSERT failed on table AR_AUDIT_INV_HDR",0,"");

EXEC SQL INSERT INTO AR_AUDIT_INV_LINE
             (
               ACC_ENTITY_CODE,
               DOC_TYPE_CODE,
               DOC_NUM,
               LINE_NUM,
               MAIN_ACC1_CODE,
               MAIN_ACC2_CODE,
               SUBLEDGER_GROUP_CODE,
               SUBLEDGER_LINE_CODE,
               DEPT_CODE,
               PRODUCT_GROUP_CODE,
               PRODUCT_LINE_CODE,
               AMT_FOREIGN,
               AMT_LOCAL,
               NARRATION,
               MAIN_ACC1_CODE_NEW,
               MAIN_ACC2_CODE_NEW,
               SUBLEDGER_GROUP_CODE_NEW,
               SUBLEDGER_LINE_CODE_NEW,
               DEPT_CODE_NEW,
               PRODUCT_GROUP_CODE_NEW,
               PRODUCT_LINE_CODE_NEW
             )
        SELECT 
               ACC_ENTITY_CODE,
               DOC_TYPE_CODE,
               DOC_NUM,
               LINE_NUM,
               MAIN_ACC1_CODE,
               MAIN_ACC2_CODE,
               SUBLEDGER_GROUP_CODE,
               SUBLEDGER_LINE_CODE,
               DEPT_CODE,
               PRODUCT_GROUP_CODE,
               PRODUCT_LINE_CODE,
               AMT_FOREIGN,
               AMT_LOCAL,
               NARRATION,
               MAIN_ACC1_CODE,
               MAIN_ACC2_CODE,
               SUBLEDGER_GROUP_CODE,
               SUBLEDGER_LINE_CODE,
               DEPT_CODE,
               PRODUCT_GROUP_CODE,
               PRODUCT_LINE_CODE
         FROM  AR_INV_LINE
        WHERE  DOC_TYPE_CODE = :l_doc_type_code
          AND  DOC_NUM       = :l_doc_num;

      if (OERROR)
         err_mesg("INSERT failed on table AR_AUDIT_INV_LINE",0,"");
************************/

 /* EXEC SQL INSERT INTO AR_PENDING_DOC
        (
         ACC_ENTITY_CODE,
         DOC_TYPE_CODE,
         DOC_NUM,
         LAST_DOC_LINE_NUM,
         CUST_CODE,
         DOC_DATE,
         NARRATION,
         BASE_DATE,
         DUE_DATE,
         GROSS_AMT,
         PAYABLE_AMT,
         DISCOUNT_AMT,
         PENDING_AMT,
         ALLOCATED_AMT,
         CURRENCY_CODE,
         EXCHG_RATE,
         PMNT_TERMS_CODE,
         SETTLEMENT_DATE,
         SETTLEMENT_PERC,
         CUST_REF,
	     EPISODE_TYPE,
	     EPISODE_ID,
	     VISIT_ID,
         PATIENT_ID,
         BILLING_GROUP,
         BILL_NUM,
         BILL_DATE,
         DOCTOR_FEE_AMT,
         MAIN_ACC1_CODE,
         MAIN_ACC2_CODE,
         SUBLEDGER_GROUP_CODE,
         SUBLEDGER_LINE_CODE,
         DEPT_CODE,
         PRODUCT_GROUP_CODE,
         PRODUCT_LINE_CODE,
         POST_MONTH,
         POST_YEAR,
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
         TEL_NUM,
         CONTACT_NAME,
         CONTACT_NAME_TITLE,
         ERROR_FLAG,
         BILL_DOC_TYPE_CODE,
         BILL_TYPE_CODE,
         TRN_TYPE_CODE,
         LAST_UPD_DATE,
		 MODULE_ID ,             
         CONSOLIDATED_INV_YN ,
		 MARKUP_AMT   
       )
    VALUES
       (
         :l_hdr_acc_entity_code,
         :l_doc_type_code,
         :l_doc_num,
         1,
         :l_cust_code,
         TO_DATE(:l_doc_date,'DD/MM/YYYY'),
         :l_hdr_narration,
         TO_DATE(:l_hdr_base_date,'DD/MM/YYYY'),
         TO_DATE(:l_hdr_due_date,'DD/MM/YYYY'),
         :l_hdr_gross_amt,
         :l_payable_amt,
         :l_hdr_discount_amt,
         :l_payable_amt,
         0,
         :l_hdr_currency_code,
         :l_hdr_exchg_rate,
         :l_pmnt_terms_code,
         TO_DATE(:l_hdr_settlement_date,'DD/MM/YYYY'),
         :l_hdr_settlement_perc,
         :l_hdr_cust_ref,
         :l_episode_type,
         :l_episode_id,
         :l_visit_id,
         :l_patient_id,
         :l_billing_group,
         :l_hdr_bill_num,
         TO_DATE(:l_hdr_bill_date,'DD/MM/YYYY'),
         :l_hdr_doctor_fee_amt,
         :l_hdr_main_acc1_code,
         :l_hdr_main_acc2_code,
         :l_hdr_subledger_group_code,
         :l_hdr_subledger_line_code,
         :l_hdr_dept_code,
         :l_hdr_product_group_code,
         :l_hdr_product_line_code,
         :l_hdr_post_month,
         :l_hdr_post_year,
         :l_hdr_misc_cust_long_name,
         :l_hdr_misc_cust_short_name,
         :l_hdr_misc_cust_add1_desc,
         :l_hdr_misc_cust_add2_desc,
         :l_hdr_misc_cust_add3_desc,
         :l_hdr_misc_cust_zip_desc,
         :l_hdr_cust_long_name_locl,
         :l_hdr_cust_short_name_locl,
         :l_hdr_cust_add1_desc_locl,
         :l_hdr_cust_add2_desc_locl,
         :l_hdr_cust_add3_desc_locl,
         :l_hdr_cust_zip_desc_locl,
         :l_hdr_tel_num,
         :l_hdr_contact_name,
         :l_hdr_contact_name_title,
         :l_hdr_error_flag,
         :l_hdr_bill_doc_type_code,
         :l_hdr_bill_type_code,
         '1',
         SYSDATE,
		 :l_module_id,
		 :l_consolidated_yn   ,
		 :l_markup_amt
         ); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 56;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "insert into AR_PENDING_DOC (ACC_ENTITY_CODE,DOC_TYPE_CODE,DOC_NUM,LAST_D\
OC_LINE_NUM,CUST_CODE,DOC_DATE,NARRATION,BASE_DATE,DUE_DATE,GROSS_AMT,PAYABL\
E_AMT,DISCOUNT_AMT,PENDING_AMT,ALLOCATED_AMT,CURRENCY_CODE,EXCHG_RATE,PMNT_T\
ERMS_CODE,SETTLEMENT_DATE,SETTLEMENT_PERC,CUST_REF,EPISODE_TYPE,EPISODE_ID,V\
ISIT_ID,PATIENT_ID,BILLING_GROUP,BILL_NUM,BILL_DATE,DOCTOR_FEE_AMT,MAIN_ACC1\
_CODE,MAIN_ACC2_CODE,SUBLEDGER_GROUP_CODE,SUBLEDGER_LINE_CODE,DEPT_CODE,PROD\
UCT_GROUP_CODE,PRODUCT_LINE_CODE,POST_MONTH,POST_YEAR,MISC_CUST_LONG_NAME,MI\
SC_CUST_SHORT_NAME,MISC_CUST_ADD1_DESC,MISC_CUST_ADD2_DESC,MISC_CUST_ADD3_DE\
SC,MISC_CUST_ZIP_DESC,MISC_CUST_LONG_NAME_CHINESE,MISC_CUST_SHORT_NAME_CHINE\
SE,MISC_CUST_ADD1_DESC_CHINESE,MISC_CUST_ADD2_DESC_CHINESE,MISC_CUST_ADD3_DE\
SC_CHINESE,MISC_CUST_ZIP_DESC_CHINESE,TEL_NUM,CONTACT_NAME,CONTACT_NAME_TITL\
E,ERROR_FLAG,BILL_DOC_TYPE_CODE,BILL_TYPE_CODE,TRN_TYPE_CODE,LAST_UPD_DATE,M\
ODULE_ID,CONSOLIDATED_INV_YN,MARKUP_AMT) values (:b0,:b1,:b2,1,:b3,TO_DATE(:\
b4,'DD/MM/YYYY'),:b5,TO_DATE(:b6,'DD/MM/");
 sqlstm.stmt = "YYYY'),TO_DATE(:b7,'DD/MM/YYYY'),:b8,:b9,:b10,:b9,0,:b12,:b1\
3,:b14,TO_DATE(:b15,'DD/MM/YYYY'),:b16,:b17,:b18,:b19,:b20,:b21,:b22,:b23,TO_D\
ATE(:b24,'DD/MM/YYYY'),:b25,:b26,:b27,:b28,:b29,:b30,:b31,:b32,:b33,:b34,:b35,\
:b36,:b37,:b38,:b39,:b40,:b41,:b42,:b43,:b44,:b45,:b46,:b47,:b48,:b49,:b50,:b5\
1,:b52,'1',SYSDATE,:b53,:b54,:b55)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_hdr_acc_entity_code;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_doc_num;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_cust_code;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_doc_date;
 sqlstm.sqhstl[4] = (unsigned int  )14;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_hdr_narration;
 sqlstm.sqhstl[5] = (unsigned int  )53;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_hdr_base_date;
 sqlstm.sqhstl[6] = (unsigned int  )14;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_hdr_due_date;
 sqlstm.sqhstl[7] = (unsigned int  )14;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_hdr_gross_amt;
 sqlstm.sqhstl[8] = (unsigned int  )18;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_payable_amt;
 sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_hdr_discount_amt;
 sqlstm.sqhstl[10] = (unsigned int  )18;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&l_payable_amt;
 sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&l_hdr_currency_code;
 sqlstm.sqhstl[12] = (unsigned int  )10;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&l_hdr_exchg_rate;
 sqlstm.sqhstl[13] = (unsigned int  )18;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&l_pmnt_terms_code;
 sqlstm.sqhstl[14] = (unsigned int  )5;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&l_hdr_settlement_date;
 sqlstm.sqhstl[15] = (unsigned int  )14;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&l_hdr_settlement_perc;
 sqlstm.sqhstl[16] = (unsigned int  )8;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&l_hdr_cust_ref;
 sqlstm.sqhstl[17] = (unsigned int  )18;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&l_episode_type;
 sqlstm.sqhstl[18] = (unsigned int  )4;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&l_episode_id;
 sqlstm.sqhstl[19] = (unsigned int  )11;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&l_visit_id;
 sqlstm.sqhstl[20] = (unsigned int  )7;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&l_patient_id;
 sqlstm.sqhstl[21] = (unsigned int  )23;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&l_billing_group;
 sqlstm.sqhstl[22] = (unsigned int  )5;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&l_hdr_bill_num;
 sqlstm.sqhstl[23] = (unsigned int  )11;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&l_hdr_bill_date;
 sqlstm.sqhstl[24] = (unsigned int  )15;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&l_hdr_doctor_fee_amt;
 sqlstm.sqhstl[25] = (unsigned int  )18;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&l_hdr_main_acc1_code;
 sqlstm.sqhstl[26] = (unsigned int  )10;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&l_hdr_main_acc2_code;
 sqlstm.sqhstl[27] = (unsigned int  )10;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&l_hdr_subledger_group_code;
 sqlstm.sqhstl[28] = (unsigned int  )6;
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&l_hdr_subledger_line_code;
 sqlstm.sqhstl[29] = (unsigned int  )14;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&l_hdr_dept_code;
 sqlstm.sqhstl[30] = (unsigned int  )10;
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)&l_hdr_product_group_code;
 sqlstm.sqhstl[31] = (unsigned int  )6;
 sqlstm.sqhsts[31] = (         int  )0;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
 sqlstm.sqhstv[32] = (         void  *)&l_hdr_product_line_code;
 sqlstm.sqhstl[32] = (unsigned int  )10;
 sqlstm.sqhsts[32] = (         int  )0;
 sqlstm.sqindv[32] = (         void  *)0;
 sqlstm.sqinds[32] = (         int  )0;
 sqlstm.sqharm[32] = (unsigned int  )0;
 sqlstm.sqadto[32] = (unsigned short )0;
 sqlstm.sqtdso[32] = (unsigned short )0;
 sqlstm.sqhstv[33] = (         void  *)&l_hdr_post_month;
 sqlstm.sqhstl[33] = (unsigned int  )5;
 sqlstm.sqhsts[33] = (         int  )0;
 sqlstm.sqindv[33] = (         void  *)0;
 sqlstm.sqinds[33] = (         int  )0;
 sqlstm.sqharm[33] = (unsigned int  )0;
 sqlstm.sqadto[33] = (unsigned short )0;
 sqlstm.sqtdso[33] = (unsigned short )0;
 sqlstm.sqhstv[34] = (         void  *)&l_hdr_post_year;
 sqlstm.sqhstl[34] = (unsigned int  )7;
 sqlstm.sqhsts[34] = (         int  )0;
 sqlstm.sqindv[34] = (         void  *)0;
 sqlstm.sqinds[34] = (         int  )0;
 sqlstm.sqharm[34] = (unsigned int  )0;
 sqlstm.sqadto[34] = (unsigned short )0;
 sqlstm.sqtdso[34] = (unsigned short )0;
 sqlstm.sqhstv[35] = (         void  *)&l_hdr_misc_cust_long_name;
 sqlstm.sqhstl[35] = (unsigned int  )43;
 sqlstm.sqhsts[35] = (         int  )0;
 sqlstm.sqindv[35] = (         void  *)0;
 sqlstm.sqinds[35] = (         int  )0;
 sqlstm.sqharm[35] = (unsigned int  )0;
 sqlstm.sqadto[35] = (unsigned short )0;
 sqlstm.sqtdso[35] = (unsigned short )0;
 sqlstm.sqhstv[36] = (         void  *)&l_hdr_misc_cust_short_name;
 sqlstm.sqhstl[36] = (unsigned int  )18;
 sqlstm.sqhsts[36] = (         int  )0;
 sqlstm.sqindv[36] = (         void  *)0;
 sqlstm.sqinds[36] = (         int  )0;
 sqlstm.sqharm[36] = (unsigned int  )0;
 sqlstm.sqadto[36] = (unsigned short )0;
 sqlstm.sqtdso[36] = (unsigned short )0;
 sqlstm.sqhstv[37] = (         void  *)&l_hdr_misc_cust_add1_desc;
 sqlstm.sqhstl[37] = (unsigned int  )33;
 sqlstm.sqhsts[37] = (         int  )0;
 sqlstm.sqindv[37] = (         void  *)0;
 sqlstm.sqinds[37] = (         int  )0;
 sqlstm.sqharm[37] = (unsigned int  )0;
 sqlstm.sqadto[37] = (unsigned short )0;
 sqlstm.sqtdso[37] = (unsigned short )0;
 sqlstm.sqhstv[38] = (         void  *)&l_hdr_misc_cust_add2_desc;
 sqlstm.sqhstl[38] = (unsigned int  )33;
 sqlstm.sqhsts[38] = (         int  )0;
 sqlstm.sqindv[38] = (         void  *)0;
 sqlstm.sqinds[38] = (         int  )0;
 sqlstm.sqharm[38] = (unsigned int  )0;
 sqlstm.sqadto[38] = (unsigned short )0;
 sqlstm.sqtdso[38] = (unsigned short )0;
 sqlstm.sqhstv[39] = (         void  *)&l_hdr_misc_cust_add3_desc;
 sqlstm.sqhstl[39] = (unsigned int  )33;
 sqlstm.sqhsts[39] = (         int  )0;
 sqlstm.sqindv[39] = (         void  *)0;
 sqlstm.sqinds[39] = (         int  )0;
 sqlstm.sqharm[39] = (unsigned int  )0;
 sqlstm.sqadto[39] = (unsigned short )0;
 sqlstm.sqtdso[39] = (unsigned short )0;
 sqlstm.sqhstv[40] = (         void  *)&l_hdr_misc_cust_zip_desc;
 sqlstm.sqhstl[40] = (unsigned int  )33;
 sqlstm.sqhsts[40] = (         int  )0;
 sqlstm.sqindv[40] = (         void  *)0;
 sqlstm.sqinds[40] = (         int  )0;
 sqlstm.sqharm[40] = (unsigned int  )0;
 sqlstm.sqadto[40] = (unsigned short )0;
 sqlstm.sqtdso[40] = (unsigned short )0;
 sqlstm.sqhstv[41] = (         void  *)&l_hdr_cust_long_name_locl;
 sqlstm.sqhstl[41] = (unsigned int  )43;
 sqlstm.sqhsts[41] = (         int  )0;
 sqlstm.sqindv[41] = (         void  *)0;
 sqlstm.sqinds[41] = (         int  )0;
 sqlstm.sqharm[41] = (unsigned int  )0;
 sqlstm.sqadto[41] = (unsigned short )0;
 sqlstm.sqtdso[41] = (unsigned short )0;
 sqlstm.sqhstv[42] = (         void  *)&l_hdr_cust_short_name_locl;
 sqlstm.sqhstl[42] = (unsigned int  )18;
 sqlstm.sqhsts[42] = (         int  )0;
 sqlstm.sqindv[42] = (         void  *)0;
 sqlstm.sqinds[42] = (         int  )0;
 sqlstm.sqharm[42] = (unsigned int  )0;
 sqlstm.sqadto[42] = (unsigned short )0;
 sqlstm.sqtdso[42] = (unsigned short )0;
 sqlstm.sqhstv[43] = (         void  *)&l_hdr_cust_add1_desc_locl;
 sqlstm.sqhstl[43] = (unsigned int  )33;
 sqlstm.sqhsts[43] = (         int  )0;
 sqlstm.sqindv[43] = (         void  *)0;
 sqlstm.sqinds[43] = (         int  )0;
 sqlstm.sqharm[43] = (unsigned int  )0;
 sqlstm.sqadto[43] = (unsigned short )0;
 sqlstm.sqtdso[43] = (unsigned short )0;
 sqlstm.sqhstv[44] = (         void  *)&l_hdr_cust_add2_desc_locl;
 sqlstm.sqhstl[44] = (unsigned int  )33;
 sqlstm.sqhsts[44] = (         int  )0;
 sqlstm.sqindv[44] = (         void  *)0;
 sqlstm.sqinds[44] = (         int  )0;
 sqlstm.sqharm[44] = (unsigned int  )0;
 sqlstm.sqadto[44] = (unsigned short )0;
 sqlstm.sqtdso[44] = (unsigned short )0;
 sqlstm.sqhstv[45] = (         void  *)&l_hdr_cust_add3_desc_locl;
 sqlstm.sqhstl[45] = (unsigned int  )33;
 sqlstm.sqhsts[45] = (         int  )0;
 sqlstm.sqindv[45] = (         void  *)0;
 sqlstm.sqinds[45] = (         int  )0;
 sqlstm.sqharm[45] = (unsigned int  )0;
 sqlstm.sqadto[45] = (unsigned short )0;
 sqlstm.sqtdso[45] = (unsigned short )0;
 sqlstm.sqhstv[46] = (         void  *)&l_hdr_cust_zip_desc_locl;
 sqlstm.sqhstl[46] = (unsigned int  )33;
 sqlstm.sqhsts[46] = (         int  )0;
 sqlstm.sqindv[46] = (         void  *)0;
 sqlstm.sqinds[46] = (         int  )0;
 sqlstm.sqharm[46] = (unsigned int  )0;
 sqlstm.sqadto[46] = (unsigned short )0;
 sqlstm.sqtdso[46] = (unsigned short )0;
 sqlstm.sqhstv[47] = (         void  *)&l_hdr_tel_num;
 sqlstm.sqhstl[47] = (unsigned int  )33;
 sqlstm.sqhsts[47] = (         int  )0;
 sqlstm.sqindv[47] = (         void  *)0;
 sqlstm.sqinds[47] = (         int  )0;
 sqlstm.sqharm[47] = (unsigned int  )0;
 sqlstm.sqadto[47] = (unsigned short )0;
 sqlstm.sqtdso[47] = (unsigned short )0;
 sqlstm.sqhstv[48] = (         void  *)&l_hdr_contact_name;
 sqlstm.sqhstl[48] = (unsigned int  )43;
 sqlstm.sqhsts[48] = (         int  )0;
 sqlstm.sqindv[48] = (         void  *)0;
 sqlstm.sqinds[48] = (         int  )0;
 sqlstm.sqharm[48] = (unsigned int  )0;
 sqlstm.sqadto[48] = (unsigned short )0;
 sqlstm.sqtdso[48] = (unsigned short )0;
 sqlstm.sqhstv[49] = (         void  *)&l_hdr_contact_name_title;
 sqlstm.sqhstl[49] = (unsigned int  )43;
 sqlstm.sqhsts[49] = (         int  )0;
 sqlstm.sqindv[49] = (         void  *)0;
 sqlstm.sqinds[49] = (         int  )0;
 sqlstm.sqharm[49] = (unsigned int  )0;
 sqlstm.sqadto[49] = (unsigned short )0;
 sqlstm.sqtdso[49] = (unsigned short )0;
 sqlstm.sqhstv[50] = (         void  *)&l_hdr_error_flag;
 sqlstm.sqhstl[50] = (unsigned int  )4;
 sqlstm.sqhsts[50] = (         int  )0;
 sqlstm.sqindv[50] = (         void  *)0;
 sqlstm.sqinds[50] = (         int  )0;
 sqlstm.sqharm[50] = (unsigned int  )0;
 sqlstm.sqadto[50] = (unsigned short )0;
 sqlstm.sqtdso[50] = (unsigned short )0;
 sqlstm.sqhstv[51] = (         void  *)&l_hdr_bill_doc_type_code;
 sqlstm.sqhstl[51] = (unsigned int  )9;
 sqlstm.sqhsts[51] = (         int  )0;
 sqlstm.sqindv[51] = (         void  *)0;
 sqlstm.sqinds[51] = (         int  )0;
 sqlstm.sqharm[51] = (unsigned int  )0;
 sqlstm.sqadto[51] = (unsigned short )0;
 sqlstm.sqtdso[51] = (unsigned short )0;
 sqlstm.sqhstv[52] = (         void  *)&l_hdr_bill_type_code;
 sqlstm.sqhstl[52] = (unsigned int  )5;
 sqlstm.sqhsts[52] = (         int  )0;
 sqlstm.sqindv[52] = (         void  *)0;
 sqlstm.sqinds[52] = (         int  )0;
 sqlstm.sqharm[52] = (unsigned int  )0;
 sqlstm.sqadto[52] = (unsigned short )0;
 sqlstm.sqtdso[52] = (unsigned short )0;
 sqlstm.sqhstv[53] = (         void  *)&l_module_id;
 sqlstm.sqhstl[53] = (unsigned int  )5;
 sqlstm.sqhsts[53] = (         int  )0;
 sqlstm.sqindv[53] = (         void  *)0;
 sqlstm.sqinds[53] = (         int  )0;
 sqlstm.sqharm[53] = (unsigned int  )0;
 sqlstm.sqadto[53] = (unsigned short )0;
 sqlstm.sqtdso[53] = (unsigned short )0;
 sqlstm.sqhstv[54] = (         void  *)&l_consolidated_yn;
 sqlstm.sqhstl[54] = (unsigned int  )4;
 sqlstm.sqhsts[54] = (         int  )0;
 sqlstm.sqindv[54] = (         void  *)0;
 sqlstm.sqinds[54] = (         int  )0;
 sqlstm.sqharm[54] = (unsigned int  )0;
 sqlstm.sqadto[54] = (unsigned short )0;
 sqlstm.sqtdso[54] = (unsigned short )0;
 sqlstm.sqhstv[55] = (         void  *)&l_markup_amt;
 sqlstm.sqhstl[55] = (unsigned int  )18;
 sqlstm.sqhsts[55] = (         int  )0;
 sqlstm.sqindv[55] = (         void  *)0;
 sqlstm.sqinds[55] = (         int  )0;
 sqlstm.sqharm[55] = (unsigned int  )0;
 sqlstm.sqadto[55] = (unsigned short )0;
 sqlstm.sqtdso[55] = (unsigned short )0;
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
         err_mesg("INSERT failed on table AR_PENDING_DOC",0,"");
   
   /* EXEC SQL INSERT INTO AR_CUST_TRN
        (
          ACC_ENTITY_CODE,
          CUST_CODE,
          ORG_DOC_TYPE_CODE,
          ORG_DOC_NUM,
          LINE_NUM,
          DOC_TYPE_CODE,
          DOC_NUM,
          DOC_DATE,
          NARRATION,
          AMOUNT,
          CUST_REF,
          TRN_TYPE_CODE,
		  POST_MONTH,
		  POST_YEAR
       )
    VALUES
       (
          :l_hdr_acc_entity_code,
          :l_cust_code,
          :l_doc_type_code,
          :l_doc_num,
          1,
          :l_doc_type_code,
          :l_doc_num,
          TO_DATE(:l_doc_date,'DD/MM/YYYY'),
          :l_hdr_narration,
          :l_payable_amt,
          :l_hdr_cust_ref,
         '1',
		 :l_hdr_post_month,
         :l_hdr_post_year
        ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into AR_CUST_TRN (ACC_ENTITY_CODE,CUST_CODE,ORG_DOC\
_TYPE_CODE,ORG_DOC_NUM,LINE_NUM,DOC_TYPE_CODE,DOC_NUM,DOC_DATE,NARRATION,AMOUN\
T,CUST_REF,TRN_TYPE_CODE,POST_MONTH,POST_YEAR) values (:b0,:b1,:b2,:b3,1,:b2,:\
b3,TO_DATE(:b6,'DD/MM/YYYY'),:b7,:b8,:b9,'1',:b10,:b11)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )244;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_hdr_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_cust_code;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )9;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_doc_type_code;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_doc_num;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_doc_date;
   sqlstm.sqhstl[6] = (unsigned int  )14;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_hdr_narration;
   sqlstm.sqhstl[7] = (unsigned int  )53;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_payable_amt;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&l_hdr_cust_ref;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&l_hdr_post_month;
   sqlstm.sqhstl[10] = (unsigned int  )5;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&l_hdr_post_year;
   sqlstm.sqhstl[11] = (unsigned int  )7;
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
         err_mesg("INSERT failed on table AR_CUST_TRN",0,"");

   /* EXEC SQL INSERT INTO SY_DOC_CONTROL
      (
         ACC_ENTITY_CODE,
         MODULE_ID,
         DOC_TYPE_CODE,
         DOC_NUM,
         DOC_DATE,
         POSTED_DATE,
         DOC_STATUS,
         NARRATION,
         POST_MONTH,
         POST_YEAR,
         ADDED_BY_ID,
         MODIFIED_BY_ID,
         ADDED_DATE,
         MODIFIED_DATE
      )
   VALUES 
      (
         :l_hdr_acc_entity_code,
         'AR',
         :l_doc_type_code,
         :l_doc_num,
         TO_DATE(:l_doc_date,'DD/MM/YYYY'),
         SYSDATE,
         'P',
         :l_hdr_narration,
         :l_hdr_post_month,
         :l_hdr_post_year,
         USER,
         USER,
         SYSDATE,
         SYSDATE
       ); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 56;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_DOC_CONTROL (ACC_ENTITY_CODE,MODULE_ID,DOC_\
TYPE_CODE,DOC_NUM,DOC_DATE,POSTED_DATE,DOC_STATUS,NARRATION,POST_MONTH,POST_YE\
AR,ADDED_BY_ID,MODIFIED_BY_ID,ADDED_DATE,MODIFIED_DATE) values (:b0,'AR',:b1,:\
b2,TO_DATE(:b3,'DD/MM/YYYY'),SYSDATE,'P',:b4,:b5,:b6,USER,USER,SYSDATE,SYSDATE\
)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )307;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_hdr_acc_entity_code;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_hdr_narration;
   sqlstm.sqhstl[4] = (unsigned int  )53;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_hdr_post_month;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_hdr_post_year;
   sqlstm.sqhstl[6] = (unsigned int  )7;
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
         err_mesg("INSERT failed on table SY_DOC_CONTROL",0,"");

   if (atol(nd_last_inv_doc_date.arr) > atol(l_doc_date_chking.arr))
   {
      /* EXEC SQL UPDATE AR_CUSTOMER
                  SET OUTSTANDING_BALANCE_AMT = 
                           NVL(OUTSTANDING_BALANCE_AMT,0) +  :l_payable_amt,
                      CUMULATIVE_SALES_AMT = 
                           NVL(CUMULATIVE_SALES_AMT,0) + :l_payable_amt,
                      MTD_SALES_AMT =
                           NVL(MTD_SALES_AMT,0) + :l_payable_amt,
                      YTD_SALES_AMT = 
                           NVL(YTD_SALES_AMT,0) + :l_payable_amt
                WHERE CUST_CODE = :l_cust_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 56;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "update AR_CUSTOMER  set OUTSTANDING_BALANCE_AMT=(NVL(OU\
TSTANDING_BALANCE_AMT,0)+:b0),CUMULATIVE_SALES_AMT=(NVL(CUMULATIVE_SALES_AMT,0\
)+:b0),MTD_SALES_AMT=(NVL(MTD_SALES_AMT,0)+:b0),YTD_SALES_AMT=(NVL(YTD_SALES_A\
MT,0)+:b0) where CUST_CODE=:b4";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )350;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_payable_amt;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_payable_amt;
      sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_payable_amt;
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&l_payable_amt;
      sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&l_cust_code;
      sqlstm.sqhstl[4] = (unsigned int  )11;
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


    }
    else
    {
      /* EXEC SQL UPDATE AR_CUSTOMER
                  SET OUTSTANDING_BALANCE_AMT = 
                           NVL(OUTSTANDING_BALANCE_AMT,0) +  :l_payable_amt,
                      CUMULATIVE_SALES_AMT = 
                           NVL(CUMULATIVE_SALES_AMT,0) + :l_payable_amt,
                      MTD_SALES_AMT =
                           NVL(MTD_SALES_AMT,0) + :l_payable_amt,
                      YTD_SALES_AMT = 
                           NVL(YTD_SALES_AMT,0) + :l_payable_amt,
                      LAST_INV_DOC_TYPE  = :l_doc_type_code,
                      LAST_INV_DOC_NUM   = :l_doc_num,
                      LAST_INV_DOC_DATE  = TO_DATE(:l_doc_date,'DD/MM/YYYY')
                WHERE CUST_CODE = :l_cust_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 56;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "update AR_CUSTOMER  set OUTSTANDING_BALANCE_AMT=(NVL(OU\
TSTANDING_BALANCE_AMT,0)+:b0),CUMULATIVE_SALES_AMT=(NVL(CUMULATIVE_SALES_AMT,0\
)+:b0),MTD_SALES_AMT=(NVL(MTD_SALES_AMT,0)+:b0),YTD_SALES_AMT=(NVL(YTD_SALES_A\
MT,0)+:b0),LAST_INV_DOC_TYPE=:b4,LAST_INV_DOC_NUM=:b5,LAST_INV_DOC_DATE=TO_DAT\
E(:b6,'DD/MM/YYYY') where CUST_CODE=:b7";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )385;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&l_payable_amt;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&l_payable_amt;
      sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_payable_amt;
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&l_payable_amt;
      sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&l_doc_type_code;
      sqlstm.sqhstl[4] = (unsigned int  )9;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&l_doc_num;
      sqlstm.sqhstl[5] = (unsigned int  )11;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&l_doc_date;
      sqlstm.sqhstl[6] = (unsigned int  )14;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&l_cust_code;
      sqlstm.sqhstl[7] = (unsigned int  )11;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
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
         err_mesg("UPDATE failed on table AR_CUSTOMER",0,"");
/**********************
  EXEC SQL DELETE FROM AR_INV_LINE 
                 WHERE DOC_TYPE_CODE = :l_doc_type_code
                   AND DOC_NUM       = :l_doc_num;

  if (OERROR)
        err_mesg("DELETE failed on table AR_INV_LINE",0,"");

  EXEC SQL DELETE FROM AR_INV_HDR
                 WHERE ROWID = :hdr_rowid_passed;

  if (OERROR)
        err_mesg("DELETE failed on table AR_INV_HDR",0,"");
*****************************/

  /* EXEC SQL UPDATE AR_INV_HDR
              SET POSTED_FLAG               = 'Y',
                  INTERFACE_FLAG            = 
                        DECODE(:l_ar_interface_code,'O','Y','N'),
                  POSTED_DATE               = SYSDATE,
                  POSTED_BY_ID              = USER
            WHERE ROWID = :hdr_rowid_passed; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 56;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update AR_INV_HDR  set POSTED_FLAG='Y',INTERFACE_FLAG=DECOD\
E(:b0,'O','Y','N'),POSTED_DATE=SYSDATE,POSTED_BY_ID=USER where ROWID=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )432;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_ar_interface_code;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&hdr_rowid_passed;
  sqlstm.sqhstl[1] = (unsigned int  )33;
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
        err_mesg("UPDATE failed on table AR_INV_HDR - AR Posting",0,"");

}

select_rec()
{
   l_doc_type_code.arr[0]         = '\0';
   l_doc_num.arr[0]               = '\0';

   l_cust_code.arr[0]         = '\0';
   l_pmnt_terms_code.arr[0]   = '\0';
   l_billing_group.arr[0]     = '\0';
   l_patient_id.arr[0]        = '\0';
   l_episode_type.arr[0]      = '\0';
   l_episode_id.arr[0]        = '\0';
   l_visit_id.arr[0]          = '\0';

   l_hdr_main_acc1_code.arr[0]       = '\0';
   l_hdr_main_acc2_code.arr[0]       = '\0';
   l_hdr_dept_code.arr[0]            = '\0';
   l_hdr_product_group_code.arr[0]   = '\0';
   l_hdr_product_line_code.arr[0]    = '\0';
   l_hdr_subledger_group_code.arr[0] = '\0';
   l_hdr_subledger_line_code.arr[0]  = '\0';

   l_doc_date.arr[0]               = '\0';
   l_doc_date_chking.arr[0]        = '\0';
   l_markup_amt.arr[0] = '\0';

   l_doc_type_code.len            = 0;
   l_doc_num.len                  = 0;

   l_cust_code.len            = 0;
   l_pmnt_terms_code.len      = 0;
   l_billing_group.len        = 0;
   l_patient_id.len           = 0;
   l_episode_type.len         = 0;
   l_episode_id.len           = 0;
   l_visit_id.len             = 0;
   
   l_hdr_main_acc1_code.len       = 0;
   l_hdr_main_acc2_code.len       = 0;
   l_hdr_dept_code.len            = 0;
   l_hdr_product_group_code.len   = 0;
   l_hdr_product_line_code.len    = 0;
   l_hdr_subledger_group_code.len = 0;
   l_hdr_subledger_line_code.len  = 0;
   l_doc_date.len               = 0;
   l_doc_date_chking.len        = 0;

   l_payable_amt                = 0;

   l_hdr_acc_entity_code.arr[0]   = '\0';
   l_hdr_last_line_num.arr[0]   = '\0';
   l_hdr_narration.arr[0]   = '\0';
   l_hdr_base_date.arr[0]   = '\0';
   l_hdr_due_date.arr[0]   = '\0';
   l_hdr_gross_amt.arr[0]   = '\0';
   l_hdr_discount_amt.arr[0]   = '\0';
   l_hdr_currency_code.arr[0]   = '\0';
   l_hdr_exchg_rate.arr[0]   = '\0';
   l_hdr_settlement_date.arr[0]   = '\0';
   l_hdr_settlement_perc.arr[0]   = '\0';
   l_hdr_cust_ref.arr[0]   = '\0';
   l_hdr_bill_doc_type_code.arr[0]   = '\0';
   l_hdr_bill_num.arr[0]   = '\0';
   l_hdr_bill_date.arr[0]   = '\0';
   l_hdr_doctor_fee_amt.arr[0]   = '\0';
   l_hdr_post_month.arr[0]   = '\0';
   l_hdr_post_year.arr[0]   = '\0';
   l_hdr_misc_cust_long_name.arr[0]   = '\0';
   l_hdr_misc_cust_short_name.arr[0]   = '\0';
   l_hdr_misc_cust_add1_desc.arr[0]   = '\0';
   l_hdr_misc_cust_add2_desc.arr[0]   = '\0';
   l_hdr_misc_cust_add3_desc.arr[0]   = '\0';
   l_hdr_misc_cust_zip_desc.arr[0]   = '\0';
   l_hdr_cust_long_name_locl.arr[0]   = '\0';
   l_hdr_cust_short_name_locl.arr[0]   = '\0';
   l_hdr_cust_add1_desc_locl.arr[0]   = '\0';
   l_hdr_cust_add2_desc_locl.arr[0]   = '\0';
   l_hdr_cust_add3_desc_locl.arr[0]   = '\0';
   l_hdr_cust_zip_desc_locl.arr[0]   = '\0';
   l_hdr_tel_num.arr[0]   = '\0';
   l_hdr_contact_name.arr[0]   = '\0';
   l_hdr_contact_name_title.arr[0]   = '\0';
   l_hdr_error_flag.arr[0]   = '\0';
   l_hdr_bill_type_code.arr[0] = '\0';
   l_consolidated_yn.arr[0] = '\0';
   l_module_id.arr[0] = '\0';

   l_hdr_acc_entity_code.len     = 0;
   l_hdr_last_line_num.len     = 0;
   l_hdr_narration.len     = 0;
   l_hdr_base_date.len     = 0;
   l_hdr_due_date.len     = 0;
   l_hdr_gross_amt.len     = 0;
   l_hdr_discount_amt.len     = 0;
   l_hdr_currency_code.len     = 0;
   l_hdr_exchg_rate.len     = 0;
   l_hdr_settlement_date.len     = 0;
   l_hdr_settlement_perc.len     = 0;
   l_hdr_cust_ref.len     = 0;
   l_hdr_bill_doc_type_code.len     = 0;
   l_hdr_bill_num.len     = 0;
   l_hdr_bill_date.len     = 0;
   l_hdr_doctor_fee_amt.len     = 0;
   l_hdr_post_month.len     = 0;
   l_hdr_post_year.len     = 0;
   l_hdr_misc_cust_long_name.len     = 0;
   l_hdr_misc_cust_short_name.len     = 0;
   l_hdr_misc_cust_add1_desc.len     = 0;
   l_hdr_misc_cust_add2_desc.len     = 0;
   l_hdr_misc_cust_add3_desc.len     = 0;
   l_hdr_misc_cust_zip_desc.len     = 0;
   l_hdr_cust_long_name_locl.len     = 0;
   l_hdr_cust_short_name_locl.len     = 0;
   l_hdr_cust_add1_desc_locl.len     = 0;
   l_hdr_cust_add2_desc_locl.len     = 0;
   l_hdr_cust_add3_desc_locl.len     = 0;
   l_hdr_cust_zip_desc_locl.len     = 0;
   l_hdr_tel_num.len     = 0;
   l_hdr_contact_name.len     = 0;
   l_hdr_contact_name_title.len     = 0;
   l_hdr_error_flag.len     = 0;
   l_hdr_bill_type_code.len = 0;
   l_consolidated_yn.len = 0;
   l_module_id.len = 0;
   l_markup_amt.len = 0;


   /* EXEC SQL SELECT  DOC_TYPE_CODE,
                    DOC_NUM,  
                    TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
                    TO_CHAR(DOC_DATE,'YYYYMMDD'),
                    NVL(CUST_CODE,' '),
                    NVL(PMNT_TERMS_CODE,' '),
                    NVL(BILLING_GROUP,' '),
		    NVL(EPISODE_TYPE,' '),
		    NVL(EPISODE_ID,0),
    		NVL(VISIT_ID,0),
                    NVL(PATIENT_ID,' '),
                    NVL(PAYABLE_AMT,0),
                    NVL(MAIN_ACC1_CODE,' '),
                    NVL(MAIN_ACC2_CODE,' '),
                    NVL(DEPT_CODE,' '),
                    NVL(PRODUCT_GROUP_CODE,' '),
                    NVL(PRODUCT_LINE_CODE,' '),
                    NVL(SUBLEDGER_GROUP_CODE,' '),
                    NVL(SUBLEDGER_LINE_CODE,' '),
                    NVL(ACC_ENTITY_CODE,' '),
                    NVL(LAST_LINE_NUM,0),
                    NVL(NARRATION,' '),
                    TO_CHAR(BASE_DATE,'DD/MM/YYYY'),
                    TO_CHAR(DUE_DATE,'DD/MM/YYYY'),
                    NVL(GROSS_AMT,0),
                    NVL(DISCOUNT_AMT,0),
                    NVL(CURRENCY_CODE,' '),
                    NVL(EXCHG_RATE,0),
                    TO_CHAR(SETTLEMENT_DATE,'DD/MM/YYYY'),
                    NVL(SETTLEMENT_PERC ,0),
                    NVL(CUST_REF,' '),
                    NVL(BILL_DOC_TYPE_CODE ,' '),
                    NVL(BILL_NUM ,0),
                    TO_CHAR(BILL_DATE,'DD/MM/YYYY'),
                    NVL(DOCTOR_FEE_AMT,0),
                    NVL(POST_MONTH,0),
                    NVL(POST_YEAR,0),
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
                    NVL(TEL_NUM, ' '),
                    NVL(CONTACT_NAME,' '),
                    NVL(CONTACT_NAME_TITLE,' '),
                    NVL(ERROR_FLAG,' '),
                    NVL(BILL_TYPE_CODE, ' '),
					nvl(CONSOLIDATED_INV_YN, ' '),
					MODULE_ID,
					MARKUP_AMT
             INTO :l_doc_type_code,
                  :l_doc_num,
                  :l_doc_date,
                  :l_doc_date_chking,
                  :l_cust_code,
                  :l_pmnt_terms_code,
                  :l_billing_group,
                  :l_episode_type,
                  :l_episode_id,
                  :l_visit_id,
                  :l_patient_id,
                  :l_payable_amt,
                  :l_hdr_main_acc1_code,
                  :l_hdr_main_acc2_code,
                  :l_hdr_dept_code,
                  :l_hdr_product_group_code,
                  :l_hdr_product_line_code,
                  :l_hdr_subledger_group_code,
                  :l_hdr_subledger_line_code, 
                  :l_hdr_acc_entity_code                   ,
                  :l_hdr_last_line_num                     ,
                  :l_hdr_narration                         ,
                  :l_hdr_base_date,
                  :l_hdr_due_date,
                  :l_hdr_gross_amt                          ,
                  :l_hdr_discount_amt                       ,
                  :l_hdr_currency_code                     ,
                  :l_hdr_exchg_rate                         ,
                  :l_hdr_settlement_date,
                  :l_hdr_settlement_perc                   ,
                  :l_hdr_cust_ref                           ,
                  :l_hdr_bill_doc_type_code                ,
                  :l_hdr_bill_num                          ,
                  :l_hdr_bill_date,
                  :l_hdr_doctor_fee_amt                     ,
                  :l_hdr_post_month                        ,
                  :l_hdr_post_year                         ,
                  :l_hdr_misc_cust_long_name                ,
                  :l_hdr_misc_cust_short_name               ,
                  :l_hdr_misc_cust_add1_desc                ,
                  :l_hdr_misc_cust_add2_desc                ,
                  :l_hdr_misc_cust_add3_desc                ,
                  :l_hdr_misc_cust_zip_desc                 ,
                  :l_hdr_cust_long_name_locl        ,
                  :l_hdr_cust_short_name_locl       ,
                  :l_hdr_cust_add1_desc_locl        ,
                  :l_hdr_cust_add2_desc_locl        ,
                  :l_hdr_cust_add3_desc_locl        ,
                  :l_hdr_cust_zip_desc_locl         ,
                  :l_hdr_tel_num                            ,
                  :l_hdr_contact_name                       ,
                  :l_hdr_contact_name_title                 ,
                  :l_hdr_error_flag,
                  :l_hdr_bill_type_code,
				  :l_consolidated_yn,
				  :l_module_id,
				  :l_markup_amt
               FROM AR_INV_HDR
              WHERE ROWID = :hdr_rowid_passed; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 58;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE,'DD/MM/YYYY') ,TO_CHAR\
(DOC_DATE,'YYYYMMDD') ,NVL(CUST_CODE,' ') ,NVL(PMNT_TERMS_CODE,' ') ,NVL(BIL\
LING_GROUP,' ') ,NVL(EPISODE_TYPE,' ') ,NVL(EPISODE_ID,0) ,NVL(VISIT_ID,0) ,\
NVL(PATIENT_ID,' ') ,NVL(PAYABLE_AMT,0) ,NVL(MAIN_ACC1_CODE,' ') ,NVL(MAIN_A\
CC2_CODE,' ') ,NVL(DEPT_CODE,' ') ,NVL(PRODUCT_GROUP_CODE,' ') ,NVL(PRODUCT_\
LINE_CODE,' ') ,NVL(SUBLEDGER_GROUP_CODE,' ') ,NVL(SUBLEDGER_LINE_CODE,' ') \
,NVL(ACC_ENTITY_CODE,' ') ,NVL(LAST_LINE_NUM,0) ,NVL(NARRATION,' ') ,TO_CHAR\
(BASE_DATE,'DD/MM/YYYY') ,TO_CHAR(DUE_DATE,'DD/MM/YYYY') ,NVL(GROSS_AMT,0) ,\
NVL(DISCOUNT_AMT,0) ,NVL(CURRENCY_CODE,' ') ,NVL(EXCHG_RATE,0) ,TO_CHAR(SETT\
LEMENT_DATE,'DD/MM/YYYY') ,NVL(SETTLEMENT_PERC,0) ,NVL(CUST_REF,' ') ,NVL(BI\
LL_DOC_TYPE_CODE,' ') ,NVL(BILL_NUM,0) ,TO_CHAR(BILL_DATE,'DD/MM/YYYY') ,NVL\
(DOCTOR_FEE_AMT,0) ,NVL(POST_MONTH,0) ,NVL(POST_YEAR,0) ,NVL(MISC_CUST_LONG_\
NAME,' ') ,NVL(MISC_CUST_SHORT_NAME,' ') ,NVL(MISC_CUST_ADD1_DESC,' ') ,NVL(\
MISC_CUST_ADD2_DESC,' ') ,NVL(MISC_CUST_AD");
   sqlstm.stmt = "D3_DESC,' ') ,NVL(MISC_CUST_ZIP_DESC,' ') ,NVL(MISC_CUST_L\
ONG_NAME_CHINESE,' ') ,NVL(MISC_CUST_SHORT_NAME_CHINESE,' ') ,NVL(MISC_CUST_AD\
D1_DESC_CHINESE,' ') ,NVL(MISC_CUST_ADD2_DESC_CHINESE,' ') ,NVL(MISC_CUST_ADD3\
_DESC_CHINESE,' ') ,NVL(MISC_CUST_ZIP_DESC_CHINESE,' ') ,NVL(TEL_NUM,' ') ,NVL\
(CONTACT_NAME,' ') ,NVL(CONTACT_NAME_TITLE,' ') ,NVL(ERROR_FLAG,' ') ,NVL(BILL\
_TYPE_CODE,' ') ,nvl(CONSOLIDATED_INV_YN,' ') ,MODULE_ID ,MARKUP_AMT into :b0,\
:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b\
18,:b19,:b20,:b21,:b22,:b23,:b24,:b25,:b26,:b27,:b28,:b29,:b30,:b31,:b32,:b33,\
:b34,:b35,:b36,:b37,:b38,:b39,:b40,:b41,:b42,:b43,:b44,:b45,:b46,:b47,:b48,:b4\
9,:b50,:b51,:b52,:b53,:b54,:b55,:b56  from AR_INV_HDR where ROWID=:b57";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )455;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_doc_num;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_doc_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_doc_date_chking;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_cust_code;
   sqlstm.sqhstl[4] = (unsigned int  )11;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&l_pmnt_terms_code;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&l_billing_group;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&l_episode_type;
   sqlstm.sqhstl[7] = (unsigned int  )4;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&l_episode_id;
   sqlstm.sqhstl[8] = (unsigned int  )11;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&l_visit_id;
   sqlstm.sqhstl[9] = (unsigned int  )7;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&l_patient_id;
   sqlstm.sqhstl[10] = (unsigned int  )23;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&l_payable_amt;
   sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&l_hdr_main_acc1_code;
   sqlstm.sqhstl[12] = (unsigned int  )10;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&l_hdr_main_acc2_code;
   sqlstm.sqhstl[13] = (unsigned int  )10;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&l_hdr_dept_code;
   sqlstm.sqhstl[14] = (unsigned int  )10;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&l_hdr_product_group_code;
   sqlstm.sqhstl[15] = (unsigned int  )6;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&l_hdr_product_line_code;
   sqlstm.sqhstl[16] = (unsigned int  )10;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&l_hdr_subledger_group_code;
   sqlstm.sqhstl[17] = (unsigned int  )6;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&l_hdr_subledger_line_code;
   sqlstm.sqhstl[18] = (unsigned int  )14;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&l_hdr_acc_entity_code;
   sqlstm.sqhstl[19] = (unsigned int  )7;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&l_hdr_last_line_num;
   sqlstm.sqhstl[20] = (unsigned int  )7;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&l_hdr_narration;
   sqlstm.sqhstl[21] = (unsigned int  )53;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&l_hdr_base_date;
   sqlstm.sqhstl[22] = (unsigned int  )14;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&l_hdr_due_date;
   sqlstm.sqhstl[23] = (unsigned int  )14;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&l_hdr_gross_amt;
   sqlstm.sqhstl[24] = (unsigned int  )18;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&l_hdr_discount_amt;
   sqlstm.sqhstl[25] = (unsigned int  )18;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&l_hdr_currency_code;
   sqlstm.sqhstl[26] = (unsigned int  )10;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&l_hdr_exchg_rate;
   sqlstm.sqhstl[27] = (unsigned int  )18;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&l_hdr_settlement_date;
   sqlstm.sqhstl[28] = (unsigned int  )14;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&l_hdr_settlement_perc;
   sqlstm.sqhstl[29] = (unsigned int  )8;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&l_hdr_cust_ref;
   sqlstm.sqhstl[30] = (unsigned int  )18;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&l_hdr_bill_doc_type_code;
   sqlstm.sqhstl[31] = (unsigned int  )9;
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&l_hdr_bill_num;
   sqlstm.sqhstl[32] = (unsigned int  )11;
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&l_hdr_bill_date;
   sqlstm.sqhstl[33] = (unsigned int  )15;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&l_hdr_doctor_fee_amt;
   sqlstm.sqhstl[34] = (unsigned int  )18;
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&l_hdr_post_month;
   sqlstm.sqhstl[35] = (unsigned int  )5;
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&l_hdr_post_year;
   sqlstm.sqhstl[36] = (unsigned int  )7;
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqhstv[37] = (         void  *)&l_hdr_misc_cust_long_name;
   sqlstm.sqhstl[37] = (unsigned int  )43;
   sqlstm.sqhsts[37] = (         int  )0;
   sqlstm.sqindv[37] = (         void  *)0;
   sqlstm.sqinds[37] = (         int  )0;
   sqlstm.sqharm[37] = (unsigned int  )0;
   sqlstm.sqadto[37] = (unsigned short )0;
   sqlstm.sqtdso[37] = (unsigned short )0;
   sqlstm.sqhstv[38] = (         void  *)&l_hdr_misc_cust_short_name;
   sqlstm.sqhstl[38] = (unsigned int  )18;
   sqlstm.sqhsts[38] = (         int  )0;
   sqlstm.sqindv[38] = (         void  *)0;
   sqlstm.sqinds[38] = (         int  )0;
   sqlstm.sqharm[38] = (unsigned int  )0;
   sqlstm.sqadto[38] = (unsigned short )0;
   sqlstm.sqtdso[38] = (unsigned short )0;
   sqlstm.sqhstv[39] = (         void  *)&l_hdr_misc_cust_add1_desc;
   sqlstm.sqhstl[39] = (unsigned int  )33;
   sqlstm.sqhsts[39] = (         int  )0;
   sqlstm.sqindv[39] = (         void  *)0;
   sqlstm.sqinds[39] = (         int  )0;
   sqlstm.sqharm[39] = (unsigned int  )0;
   sqlstm.sqadto[39] = (unsigned short )0;
   sqlstm.sqtdso[39] = (unsigned short )0;
   sqlstm.sqhstv[40] = (         void  *)&l_hdr_misc_cust_add2_desc;
   sqlstm.sqhstl[40] = (unsigned int  )33;
   sqlstm.sqhsts[40] = (         int  )0;
   sqlstm.sqindv[40] = (         void  *)0;
   sqlstm.sqinds[40] = (         int  )0;
   sqlstm.sqharm[40] = (unsigned int  )0;
   sqlstm.sqadto[40] = (unsigned short )0;
   sqlstm.sqtdso[40] = (unsigned short )0;
   sqlstm.sqhstv[41] = (         void  *)&l_hdr_misc_cust_add3_desc;
   sqlstm.sqhstl[41] = (unsigned int  )33;
   sqlstm.sqhsts[41] = (         int  )0;
   sqlstm.sqindv[41] = (         void  *)0;
   sqlstm.sqinds[41] = (         int  )0;
   sqlstm.sqharm[41] = (unsigned int  )0;
   sqlstm.sqadto[41] = (unsigned short )0;
   sqlstm.sqtdso[41] = (unsigned short )0;
   sqlstm.sqhstv[42] = (         void  *)&l_hdr_misc_cust_zip_desc;
   sqlstm.sqhstl[42] = (unsigned int  )33;
   sqlstm.sqhsts[42] = (         int  )0;
   sqlstm.sqindv[42] = (         void  *)0;
   sqlstm.sqinds[42] = (         int  )0;
   sqlstm.sqharm[42] = (unsigned int  )0;
   sqlstm.sqadto[42] = (unsigned short )0;
   sqlstm.sqtdso[42] = (unsigned short )0;
   sqlstm.sqhstv[43] = (         void  *)&l_hdr_cust_long_name_locl;
   sqlstm.sqhstl[43] = (unsigned int  )43;
   sqlstm.sqhsts[43] = (         int  )0;
   sqlstm.sqindv[43] = (         void  *)0;
   sqlstm.sqinds[43] = (         int  )0;
   sqlstm.sqharm[43] = (unsigned int  )0;
   sqlstm.sqadto[43] = (unsigned short )0;
   sqlstm.sqtdso[43] = (unsigned short )0;
   sqlstm.sqhstv[44] = (         void  *)&l_hdr_cust_short_name_locl;
   sqlstm.sqhstl[44] = (unsigned int  )18;
   sqlstm.sqhsts[44] = (         int  )0;
   sqlstm.sqindv[44] = (         void  *)0;
   sqlstm.sqinds[44] = (         int  )0;
   sqlstm.sqharm[44] = (unsigned int  )0;
   sqlstm.sqadto[44] = (unsigned short )0;
   sqlstm.sqtdso[44] = (unsigned short )0;
   sqlstm.sqhstv[45] = (         void  *)&l_hdr_cust_add1_desc_locl;
   sqlstm.sqhstl[45] = (unsigned int  )33;
   sqlstm.sqhsts[45] = (         int  )0;
   sqlstm.sqindv[45] = (         void  *)0;
   sqlstm.sqinds[45] = (         int  )0;
   sqlstm.sqharm[45] = (unsigned int  )0;
   sqlstm.sqadto[45] = (unsigned short )0;
   sqlstm.sqtdso[45] = (unsigned short )0;
   sqlstm.sqhstv[46] = (         void  *)&l_hdr_cust_add2_desc_locl;
   sqlstm.sqhstl[46] = (unsigned int  )33;
   sqlstm.sqhsts[46] = (         int  )0;
   sqlstm.sqindv[46] = (         void  *)0;
   sqlstm.sqinds[46] = (         int  )0;
   sqlstm.sqharm[46] = (unsigned int  )0;
   sqlstm.sqadto[46] = (unsigned short )0;
   sqlstm.sqtdso[46] = (unsigned short )0;
   sqlstm.sqhstv[47] = (         void  *)&l_hdr_cust_add3_desc_locl;
   sqlstm.sqhstl[47] = (unsigned int  )33;
   sqlstm.sqhsts[47] = (         int  )0;
   sqlstm.sqindv[47] = (         void  *)0;
   sqlstm.sqinds[47] = (         int  )0;
   sqlstm.sqharm[47] = (unsigned int  )0;
   sqlstm.sqadto[47] = (unsigned short )0;
   sqlstm.sqtdso[47] = (unsigned short )0;
   sqlstm.sqhstv[48] = (         void  *)&l_hdr_cust_zip_desc_locl;
   sqlstm.sqhstl[48] = (unsigned int  )33;
   sqlstm.sqhsts[48] = (         int  )0;
   sqlstm.sqindv[48] = (         void  *)0;
   sqlstm.sqinds[48] = (         int  )0;
   sqlstm.sqharm[48] = (unsigned int  )0;
   sqlstm.sqadto[48] = (unsigned short )0;
   sqlstm.sqtdso[48] = (unsigned short )0;
   sqlstm.sqhstv[49] = (         void  *)&l_hdr_tel_num;
   sqlstm.sqhstl[49] = (unsigned int  )33;
   sqlstm.sqhsts[49] = (         int  )0;
   sqlstm.sqindv[49] = (         void  *)0;
   sqlstm.sqinds[49] = (         int  )0;
   sqlstm.sqharm[49] = (unsigned int  )0;
   sqlstm.sqadto[49] = (unsigned short )0;
   sqlstm.sqtdso[49] = (unsigned short )0;
   sqlstm.sqhstv[50] = (         void  *)&l_hdr_contact_name;
   sqlstm.sqhstl[50] = (unsigned int  )43;
   sqlstm.sqhsts[50] = (         int  )0;
   sqlstm.sqindv[50] = (         void  *)0;
   sqlstm.sqinds[50] = (         int  )0;
   sqlstm.sqharm[50] = (unsigned int  )0;
   sqlstm.sqadto[50] = (unsigned short )0;
   sqlstm.sqtdso[50] = (unsigned short )0;
   sqlstm.sqhstv[51] = (         void  *)&l_hdr_contact_name_title;
   sqlstm.sqhstl[51] = (unsigned int  )43;
   sqlstm.sqhsts[51] = (         int  )0;
   sqlstm.sqindv[51] = (         void  *)0;
   sqlstm.sqinds[51] = (         int  )0;
   sqlstm.sqharm[51] = (unsigned int  )0;
   sqlstm.sqadto[51] = (unsigned short )0;
   sqlstm.sqtdso[51] = (unsigned short )0;
   sqlstm.sqhstv[52] = (         void  *)&l_hdr_error_flag;
   sqlstm.sqhstl[52] = (unsigned int  )4;
   sqlstm.sqhsts[52] = (         int  )0;
   sqlstm.sqindv[52] = (         void  *)0;
   sqlstm.sqinds[52] = (         int  )0;
   sqlstm.sqharm[52] = (unsigned int  )0;
   sqlstm.sqadto[52] = (unsigned short )0;
   sqlstm.sqtdso[52] = (unsigned short )0;
   sqlstm.sqhstv[53] = (         void  *)&l_hdr_bill_type_code;
   sqlstm.sqhstl[53] = (unsigned int  )5;
   sqlstm.sqhsts[53] = (         int  )0;
   sqlstm.sqindv[53] = (         void  *)0;
   sqlstm.sqinds[53] = (         int  )0;
   sqlstm.sqharm[53] = (unsigned int  )0;
   sqlstm.sqadto[53] = (unsigned short )0;
   sqlstm.sqtdso[53] = (unsigned short )0;
   sqlstm.sqhstv[54] = (         void  *)&l_consolidated_yn;
   sqlstm.sqhstl[54] = (unsigned int  )4;
   sqlstm.sqhsts[54] = (         int  )0;
   sqlstm.sqindv[54] = (         void  *)0;
   sqlstm.sqinds[54] = (         int  )0;
   sqlstm.sqharm[54] = (unsigned int  )0;
   sqlstm.sqadto[54] = (unsigned short )0;
   sqlstm.sqtdso[54] = (unsigned short )0;
   sqlstm.sqhstv[55] = (         void  *)&l_module_id;
   sqlstm.sqhstl[55] = (unsigned int  )5;
   sqlstm.sqhsts[55] = (         int  )0;
   sqlstm.sqindv[55] = (         void  *)0;
   sqlstm.sqinds[55] = (         int  )0;
   sqlstm.sqharm[55] = (unsigned int  )0;
   sqlstm.sqadto[55] = (unsigned short )0;
   sqlstm.sqtdso[55] = (unsigned short )0;
   sqlstm.sqhstv[56] = (         void  *)&l_markup_amt;
   sqlstm.sqhstl[56] = (unsigned int  )18;
   sqlstm.sqhsts[56] = (         int  )0;
   sqlstm.sqindv[56] = (         void  *)0;
   sqlstm.sqinds[56] = (         int  )0;
   sqlstm.sqharm[56] = (unsigned int  )0;
   sqlstm.sqadto[56] = (unsigned short )0;
   sqlstm.sqtdso[56] = (unsigned short )0;
   sqlstm.sqhstv[57] = (         void  *)&hdr_rowid_passed;
   sqlstm.sqhstl[57] = (unsigned int  )33;
   sqlstm.sqhsts[57] = (         int  )0;
   sqlstm.sqindv[57] = (         void  *)0;
   sqlstm.sqinds[57] = (         int  )0;
   sqlstm.sqharm[57] = (unsigned int  )0;
   sqlstm.sqadto[57] = (unsigned short )0;
   sqlstm.sqtdso[57] = (unsigned short )0;
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
         err_mesg("SELECT failed on table AR_INV_HDR - ar post\n",0,"");

   l_doc_type_code.arr[l_doc_type_code.len]     = '\0';
   l_doc_num.arr[l_doc_num.len]                 = '\0';
   l_cust_code.arr[l_cust_code.len]             = '\0';
   l_pmnt_terms_code.arr[l_pmnt_terms_code.len] = '\0';
   l_billing_group.arr[l_billing_group.len]     =  '\0';
   l_patient_id.arr[l_patient_id.len]           =  '\0';
   l_episode_type.arr[l_episode_type.len]       =  '\0';
   l_episode_id.arr[l_episode_id.len]           =  '\0';
   l_visit_id.arr[l_visit_id.len]               =  '\0';

   l_hdr_main_acc1_code.arr[l_hdr_main_acc1_code.len]             = '\0';
   l_hdr_main_acc2_code.arr[l_hdr_main_acc2_code.len]             = '\0';
   l_hdr_dept_code.arr[l_hdr_dept_code.len]                       = '\0';
   l_hdr_product_group_code.arr[l_hdr_product_group_code.len]     = '\0';
   l_hdr_product_line_code.arr[l_hdr_product_line_code.len]       = '\0';
   l_hdr_subledger_group_code.arr[l_hdr_subledger_group_code.len] = '\0';
   l_hdr_subledger_line_code.arr[l_hdr_subledger_line_code.len]   = '\0';

   l_hdr_post_month.arr[l_hdr_post_month.len]                     = '\0';
   l_hdr_post_year.arr[l_hdr_post_year.len]                       = '\0';
   l_doc_date.arr[l_doc_date.len]                                     = '\0';
   l_doc_date_chking.arr[l_doc_date_chking.len]                       = '\0';
   l_hdr_bill_type_code.arr[l_hdr_bill_type_code.len]             = '\0';
   l_consolidated_yn.arr[l_consolidated_yn.len] = '\0';
   l_module_id.arr[l_module_id.len] = '\0';
   l_markup_amt.arr[l_markup_amt.len] = '\0';


   if (NOT_FOUND)
   {
      err_mesg("Record not found in AR_INV_HDR - Inv post - AR \n",0,"");
   }
       
}
