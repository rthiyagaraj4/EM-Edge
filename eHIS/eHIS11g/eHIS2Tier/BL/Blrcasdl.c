
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
           char  filnam[41];
};
static const struct sqlcxp sqlfpn =
{
    40,
    "D:\\work\\october\\kauh_scf\\11g\\Blrcasdl.pc"
};


static unsigned long sqlctx = 507111003;


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

 static const char *sq0006 = 
") and B.CASH_COUNTER_CODE between NVL(:b19,'  ') and NVL(:b20,'~~')) and B.S\
HIFT_ID between NVL(:b21,' ') and NVL(:b22,'~')) and B.RECPT_NATURE_CODE betwe\
en NVL(:b23,'  ') and NVL(:b24,'~~')) and NVL(B.RECPT_TYPE_CODE,'   ') between\
 NVL(:b25,'   ') and NVL(:b26,'~~~')) and NVL(B.SLMT_TYPE_CODE,'  ') between N\
VL(:b27,'  ') and NVL(:b28,'~~')) and NVL(B.CANCELLED_IND,'X')=DECODE(:b29,'Y'\
,'Y',NVL(CANCELLED_IND,'X'))) and B.RECPT_REFUND_IND=DECODE(:b30,'R','R','E','\
F',B.RECPT_REFUND_IND)) and :b31 not like (('%['||B.RECPT_NATURE_CODE)||'[%'))\
 and :b32 not like (('%['||B.SLMT_TYPE_CODE)||'[%')) and A.OPERATING_FACILITY_\
ID(+)=B.OPERATING_FACILITY_ID) and A.DOC_TYPE_CODE(+)=B.BILL_DOC_TYPE_CODE) an\
d A.DOC_NUM(+)=B.BILL_DOC_NUMBER) and NVL(A.BLNG_GRP_ID,'  ') between NVL(ltri\
m(rtrim(:b33)),'  ') and NVL(ltrim(rtrim(:b34)),'~~')) order by B.CASH_COUNTER\
_CODE,B.SHIFT_ID,B.RECPT_REFUND_IND,A.BLNG_GRP_ID,DEBTOR_CATEGORY_CODE,B.DOC_T\
YPE_CODE,B.DOC_NUMBER            ";

 static const char *sq0008 = 
"select LONG_DESC  from BL_CASH_COUNTER_LANG_VW where ((CASH_COUNTER_CODE=:b0\
 and OPERATING_FACILITY_ID=:b1) and language_id=:b2)           ";

 static const char *sq0009 = 
"select LONG_DESC  from BL_BLNG_GRP_LANG_VW where (BLNG_GRP_ID=:b0 and langua\
ge_id=:b1)           ";

 static const char *sq0010 = 
"select LONG_DESC  from BL_RECEIPT_TYPE_LANG_VW where (RECEIPT_TYPE_CODE=:b0 \
and language_id=:b1)           ";

 static const char *sq0011 = 
"select null  ,decode(:b0,'en',substr(short_name_loc_lang,31,60),null ) ,deco\
de(:b0,'en',substr(short_name,1,30),substr(SHORT_NAME_LOC_LANG,1,30))  from MP\
_PATIENT_MAST where PATIENT_ID=:b2           ";

 static const char *sq0012 = 
"select LONG_NAME  from AR_CUSTOMER_LANG_VW where (CUST_CODE=:b0 and language\
_id=:b1)           ";

 static const char *sq0013 = 
"select LONG_DESC  from BL_SLMT_TYPE_LANG_VW where (SLMT_TYPE_CODE=:b0 and la\
nguage_id=:b1)           ";

 static const char *sq0007 = 
"select A.SLMT_TYPE_CODE ,B.SHORT_DESC ,NVL(sum(DOC_AMT),0) ,NVL(sum(DOC_AMT)\
,0)  from BL_RECEIPT_REFUND_hdrDTL_vw A ,BL_SLMT_TYPE_LANG_VW B where ((((((((\
((((TRUNC(A.DOC_DATE)=TO_DATE(:b0,'DD/MM/YYYY') and :b1 not like (('%['||a.REC\
PT_NATURE_CODE)||'[%')) and :b2 not like (('%['||a.SLMT_TYPE_CODE)||'[%')) and\
 CASH_COUNTER_CODE between NVL(:b3,'!!') and NVL(:b4,'~~')) and SHIFT_ID betwe\
en NVL(:b5,'!') and NVL(:b6,'~')) and RECPT_NATURE_CODE between NVL(:b7,'  ') \
and NVL(:b8,'~~')) and NVL(RECPT_TYPE_CODE,'   ') between NVL(:b9,'   ') and N\
VL(:b10,'~~~')) and A.SLMT_TYPE_CODE between NVL(:b11,'!!') and NVL(:b12,'~~')\
) and NVL(CANCELLED_IND,'N')=DECODE(:b13,'Y','Y','N')) and A.RECPT_REFUND_IND=\
DECODE(:b14,'R','R','E','F',A.RECPT_REFUND_IND)) and A.CASH_COUNTER_FACILITY_I\
D=:b15) and A.SLMT_TYPE_CODE=B.SLMT_TYPE_CODE(+)) and language_id=:b16) group \
by A.SLMT_TYPE_CODE,B.SHORT_DESC           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4146,0,0,0,
5,0,0,1,0,0,27,182,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,335,0,4,232,0,0,18,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,
123,0,0,3,158,0,4,303,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
158,0,0,4,0,0,30,335,0,0,0,0,0,1,0,
173,0,0,5,91,0,2,343,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
196,0,0,6,1991,0,9,591,0,0,35,35,0,1,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,
1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,
0,1,1,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
351,0,0,6,0,0,13,671,0,0,33,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
498,0,0,6,0,0,15,755,0,0,0,0,0,1,0,
513,0,0,7,0,0,13,779,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,
544,0,0,8,139,0,9,809,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
571,0,0,8,0,0,13,817,0,0,1,0,0,1,0,2,9,0,0,
590,0,0,9,97,0,9,830,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
613,0,0,9,0,0,13,838,0,0,1,0,0,1,0,2,9,0,0,
632,0,0,10,107,0,9,851,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
655,0,0,10,0,0,13,859,0,0,1,0,0,1,0,2,9,0,0,
674,0,0,11,199,0,9,879,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
701,0,0,11,0,0,13,884,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
728,0,0,12,95,0,9,901,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
751,0,0,12,0,0,13,909,0,0,1,0,0,1,0,2,9,0,0,
770,0,0,13,101,0,9,922,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
793,0,0,13,0,0,13,930,0,0,1,0,0,1,0,2,9,0,0,
812,0,0,7,899,0,9,1205,0,0,17,17,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
895,0,0,7,0,0,15,1226,0,0,0,0,0,1,0,
910,0,0,14,96,0,4,1564,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
933,0,0,15,165,0,6,1571,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
964,0,0,16,140,0,6,1592,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
991,0,0,17,135,0,6,1649,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/*****************************************************************************/
/*                           BLRCASDL.PC                                       */
/*****************************************************************************/
/*  Converted To Windows : Prasad B G S   4/7/96                             */
/*
#define DEBUG
*/

#define ESC 0x1B
   
#include <stdio.h>          
#include <string.h>        
#include <bl.h>       
  
                              
/* EXEC SQL BEGIN DECLARE SECTION; */ 
        

    /* VARCHAR uid_pwd[91],
			d_session_id[16],
			nd_temp_date[21],
			p_language_id[3],
			date_convert[21],
			nd_loc_date[21],
			nd_facility_id[3],
			d_pgm_date[14],
            rep_date[20],
            comp_name[50],  
			oper_id[21],
			//----------
			nd_temp_date1[21],
			date_convert1[21],
			nd_loc_date1[21]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[21]; } date_convert1;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date1;

			//---------------

    /* VARCHAR report_date          [13],
			cash_counter_fm      [5],
	    cash_counter_to          [5],
	    shift_no_fm              [2],
	    shift_no_to              [2],
	    receipt_nature_fm        [3],
	    receipt_nature_to        [3],
	    receipt_type_fm          [4],
	    receipt_type_to          [4],
	    slmt_type_fm             [3],
	    slmt_type_to             [3],
		blng_grp_fm              [5],
		blng_grp_to				 [5],
	    cancelled_docs           [2],
	    print_flag               [2],
		nd_operating_facility_id [3],
		nd_not_in_string		 [200],
		nd_exclude_cr_trn		 [200],
		nd_statement_rn          [200],
		nd_statement_sn          [200]; */ 
struct { unsigned short len; unsigned char arr[13]; } report_date;

struct { unsigned short len; unsigned char arr[5]; } cash_counter_fm;

struct { unsigned short len; unsigned char arr[5]; } cash_counter_to;

struct { unsigned short len; unsigned char arr[2]; } shift_no_fm;

struct { unsigned short len; unsigned char arr[2]; } shift_no_to;

struct { unsigned short len; unsigned char arr[3]; } receipt_nature_fm;

struct { unsigned short len; unsigned char arr[3]; } receipt_nature_to;

struct { unsigned short len; unsigned char arr[4]; } receipt_type_fm;

struct { unsigned short len; unsigned char arr[4]; } receipt_type_to;

struct { unsigned short len; unsigned char arr[3]; } slmt_type_fm;

struct { unsigned short len; unsigned char arr[3]; } slmt_type_to;

struct { unsigned short len; unsigned char arr[5]; } blng_grp_fm;

struct { unsigned short len; unsigned char arr[5]; } blng_grp_to;

struct { unsigned short len; unsigned char arr[2]; } cancelled_docs;

struct { unsigned short len; unsigned char arr[2]; } print_flag;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[200]; } nd_not_in_string;

struct { unsigned short len; unsigned char arr[200]; } nd_exclude_cr_trn;

struct { unsigned short len; unsigned char arr[200]; } nd_statement_rn;

struct { unsigned short len; unsigned char arr[200]; } nd_statement_sn;

		

   /* VARCHAR d_recpt_refund_ind                          [2],
           d_recpt_refund_desc                         [31],
           d_doc_type_code                             [7],
           d_doc_number                                [9],
		   d_doc_srno		                           [7],
           d_recpt_nature_code                         [3],
           d_recpt_nature_desc                         [16],
           d_debtor_category_code                      [2],
           d_debtor_category_desc                      [61],
           d_doc_date                                  [13],
           d_trx_date_time                             [17],
           d_episode_type                              [2],
           d_patient_id                                [21],
           d_patient_name                              [61],
		   d_patient_name1                             [61],
           d_patient_name_loc_lang                     [61],  
           d_episode_id                                [9],
           d_visit_id                                  [5],
           d_bill_doc_type_code                        [7],
           d_bill_doc_number                           [9],
		   d_bill_doc_srno                             [7],
           d_customer_code                             [9],
           d_cust_name                                 [71],
           d_cash_counter_code                         [5],
		   d_blng_grp_id                               [5],
           d_counter_desc                              [101],
		   d_blnggrp_desc                              [101],
           d_shift_id                                  [2],
           d_doc_amt                                   [23],
           d_recpt_type_code                           [4],
           d_recpt_desc                                [101],
           d_slmt_type_code                            [3],
           d_slmt_type_desc                            [41],
           d_slmt_doc_ref_desc                         [21],
           d_slmt_doc_ref_date                         [21],
           d_slmt_doc_remarks                          [31],
           d_cancelled_ind                             [2],
           d_narration                                 [81],
           d_ip_adm_trf_dep_ind                        [2],
		   d_cancel_reason							   [51]; */ 
struct { unsigned short len; unsigned char arr[2]; } d_recpt_refund_ind;

struct { unsigned short len; unsigned char arr[31]; } d_recpt_refund_desc;

struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_number;

struct { unsigned short len; unsigned char arr[7]; } d_doc_srno;

struct { unsigned short len; unsigned char arr[3]; } d_recpt_nature_code;

struct { unsigned short len; unsigned char arr[16]; } d_recpt_nature_desc;

struct { unsigned short len; unsigned char arr[2]; } d_debtor_category_code;

struct { unsigned short len; unsigned char arr[61]; } d_debtor_category_desc;

struct { unsigned short len; unsigned char arr[13]; } d_doc_date;

struct { unsigned short len; unsigned char arr[17]; } d_trx_date_time;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name1;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[7]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_bill_doc_number;

struct { unsigned short len; unsigned char arr[7]; } d_bill_doc_srno;

struct { unsigned short len; unsigned char arr[9]; } d_customer_code;

struct { unsigned short len; unsigned char arr[71]; } d_cust_name;

struct { unsigned short len; unsigned char arr[5]; } d_cash_counter_code;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[101]; } d_counter_desc;

struct { unsigned short len; unsigned char arr[101]; } d_blnggrp_desc;

struct { unsigned short len; unsigned char arr[2]; } d_shift_id;

struct { unsigned short len; unsigned char arr[23]; } d_doc_amt;

struct { unsigned short len; unsigned char arr[4]; } d_recpt_type_code;

struct { unsigned short len; unsigned char arr[101]; } d_recpt_desc;

struct { unsigned short len; unsigned char arr[3]; } d_slmt_type_code;

struct { unsigned short len; unsigned char arr[41]; } d_slmt_type_desc;

struct { unsigned short len; unsigned char arr[21]; } d_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[21]; } d_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[31]; } d_slmt_doc_remarks;

struct { unsigned short len; unsigned char arr[2]; } d_cancelled_ind;

struct { unsigned short len; unsigned char arr[81]; } d_narration;

struct { unsigned short len; unsigned char arr[2]; } d_ip_adm_trf_dep_ind;

struct { unsigned short len; unsigned char arr[51]; } d_cancel_reason;


  /* VARCHAR  d_prv_cash_counter_code                      [5],
           d_prv_shift_id                               [2],
		   d_prv_blng_grp_id                            [5],
           d_prv_recpt_refund_ind                       [2],
           d_prv_debtor_category_code                   [2],
           d_prv_debtor_category_desc                   [61],
		   l_pk_value		    [100],
		   l_translated_value	    [201]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_prv_cash_counter_code;

struct { unsigned short len; unsigned char arr[2]; } d_prv_shift_id;

struct { unsigned short len; unsigned char arr[5]; } d_prv_blng_grp_id;

struct { unsigned short len; unsigned char arr[2]; } d_prv_recpt_refund_ind;

struct { unsigned short len; unsigned char arr[2]; } d_prv_debtor_category_code;

struct { unsigned short len; unsigned char arr[61]; } d_prv_debtor_category_desc;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;


   int     nd_rn_length,nd_sn_length;

    double d_doc_amt_num,
		   nd_doc_amt,
		   tot_doc_amt;


char filename[150];
	char loc_legend[999][201];
	int i;	
	char str_var[50];
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

FILE *f1;

int page_no,           
    line_no,
    first_line,
    g_hdr_cnt,
    g_err_typ,
    g_page_break,
	new_length;
    d_srlno=0;
char file_name[15],
string_var [100],
     g_acct_code[41],
     g_err_id[8],
     g_err_msg[72];

double g_tot_debtor,
       g_tot_recpt,
       g_tot_shift,
       g_tot_counter,
       g_tot_void,
	   g_tot_blngrp,
       g_grand_tot;
  
void proc_main(argc,argv)
int argc;
char *argv[];     
{ 

    if(argc < 5) {
        disp_message(ERR_MESG,"BLRCASDL : Usage BLRCASDL userid/password session_id pgm_date facility_id");
        proc_exit(); 
    }
 

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);
	
    strcpy(nd_operating_facility_id.arr, argv[4]);
    nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);

    strcpy(nd_statement_rn.arr,argv[5]);
	nd_statement_rn.len = strlen(nd_statement_rn.arr);

    strcpy(nd_statement_sn.arr,argv[6]);
	nd_statement_sn.len = strlen(nd_statement_sn.arr);
  	    
    strcpy(g_pgm_id,"BLRCASDL");
    strcpy(g_pgm_date,argv[3]);

    /* EXEC SQL CONNECT :uid_pwd; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )10;
    sqlstm.offset = (unsigned int  )5;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
    sqlstm.sqhstl[0] = (unsigned int  )93;
    sqlstm.sqhsts[0] = (         int  )93;
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



    if(OERROR) {
		disp_message(ORA_MESG,"Unable to connect to oracle.");
		proc_exit();
    }

   set_meduser_role();
   
   strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;

   start_prog_msg();

   report_date.arr[0]              = '\0';
   cash_counter_fm.arr[0]          = '\0';
   cash_counter_to.arr[0]          = '\0';
   shift_no_fm.arr[0]              = '\0';
   shift_no_to.arr[0]              = '\0';
   receipt_nature_fm.arr[0]        = '\0';
   receipt_nature_to.arr[0]        = '\0';
   receipt_type_fm.arr[0]          = '\0';
   receipt_type_to.arr[0]          = '\0';
   slmt_type_fm.arr[0]             = '\0';
   slmt_type_to.arr[0]             = '\0';
   blng_grp_fm.arr[0]			   = '\0';
   blng_grp_to.arr[0]			   = '\0';
   cancelled_docs.arr[0]           = '\0';
   print_flag.arr[0]               = '\0';
   nd_operating_facility_id.arr[0] = '\0';
  

   report_date.len                 = 0;
   cash_counter_fm.len             = 0;
   cash_counter_to.len             = 0;
   shift_no_fm.len                 = 0;
   shift_no_to.len                 = 0;
   receipt_nature_fm.len           = 0;
   receipt_nature_to.len           = 0;
   receipt_type_fm.len             = 0;
   receipt_type_to.len             = 0;
   cancelled_docs.len              = 0;
   print_flag.len                  = 0;
   slmt_type_fm.len                = 0;
   slmt_type_to.len                = 0;
   blng_grp_fm.len				   = 0;
   blng_grp_to.len				   = 0;
   nd_operating_facility_id.len	   = 0;
 
 
	/* EXEC SQL SELECT 
			OPERATING_FACILITY_ID,
			PARAM1,            /o REP_DATE                   o/
			PARAM2,            /o CASH_COUNTER_FM            o/
			PARAM3,            /o CASH_COUNTER_TO            o/
			PARAM4,            /o SHIFT_NO_FM                o/
			PARAM5,            /o SHIFT_NO_TO                o/
			PARAM6,            /o RECEIPT_NATURE_FM          o/
			PARAM7,            /o RECEIPT_NATURE_TO          o/
			PARAM8,            /o RECEIPT_TYPE_FM            o/
			PARAM9,            /o RECEIPT_TYPE_TO            o/
			PARAM10,           /o SLMT_TYPE_FM               o/
			PARAM11,           /o SLMT_TYPE_TO               o/
			nvl(PARAM12,'N'),           /o CANCELLED_DOCS             o/
			PARAM13,           /o PRINT_FLAG                 o/
			PARAM14,           /o BLNG_GRP_FM                o/
			PARAM15           /o BLNG_GRP_TO                o/
//			PARAM16,		   /o NOT_IN_STRING(RCPT_NATURE) o/
//			PARAM17            /o EXCLUDE CR.CARD TRNSN.     o/
		 INTO			:nd_operating_facility_id,
						:report_date,
                        :cash_counter_fm,
                        :cash_counter_to,
                        :shift_no_fm,
                        :shift_no_to,
                        :receipt_nature_fm,
                        :receipt_nature_to,
                        :receipt_type_fm,
                        :receipt_type_to,
						:slmt_type_fm,
						:slmt_type_to,
                        :cancelled_docs,
                        :print_flag,
						:blng_grp_fm,
						:blng_grp_to
//						:nd_not_in_string,
//						:nd_exclude_cr_trn
		 FROM   SY_PROG_PARAM
		 WHERE  PGM_ID     = 'BLRCASDL'
		 AND    PGM_DATE   = :d_pgm_date
		 AND    SESSION_ID = TO_NUMBER(:d_session_id); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 18;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,nvl(PARAM12,'N') ,\
PARAM13 ,PARAM14 ,PARAM15 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b\
11,:b12,:b13,:b14,:b15  from SY_PROG_PARAM where ((PGM_ID='BLRCASDL' and PGM_D\
ATE=:b16) and SESSION_ID=TO_NUMBER(:b17))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
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
 sqlstm.sqhstv[1] = (         void  *)&report_date;
 sqlstm.sqhstl[1] = (unsigned int  )15;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&cash_counter_fm;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&cash_counter_to;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&shift_no_fm;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&shift_no_to;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&receipt_nature_fm;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&receipt_nature_to;
 sqlstm.sqhstl[7] = (unsigned int  )5;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&receipt_type_fm;
 sqlstm.sqhstl[8] = (unsigned int  )6;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&receipt_type_to;
 sqlstm.sqhstl[9] = (unsigned int  )6;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&slmt_type_fm;
 sqlstm.sqhstl[10] = (unsigned int  )5;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&slmt_type_to;
 sqlstm.sqhstl[11] = (unsigned int  )5;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&cancelled_docs;
 sqlstm.sqhstl[12] = (unsigned int  )4;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&print_flag;
 sqlstm.sqhstl[13] = (unsigned int  )4;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&blng_grp_fm;
 sqlstm.sqhstl[14] = (unsigned int  )7;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&blng_grp_to;
 sqlstm.sqhstl[15] = (unsigned int  )7;
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

   report_date.arr[report_date.len]                        = '\0';    
   cash_counter_fm.arr[cash_counter_fm.len]          = '\0';
   cash_counter_to.arr[cash_counter_to.len]          = '\0';
   shift_no_fm.arr[shift_no_fm.len]                  = '\0';
   shift_no_to.arr[shift_no_to.len]                  = '\0';
   receipt_nature_fm.arr[receipt_nature_fm.len]      = '\0';
   receipt_nature_to.arr[receipt_nature_to.len]      = '\0';
   receipt_type_fm.arr[receipt_type_fm.len]          = '\0';
   receipt_type_to.arr[receipt_type_to.len]          = '\0';
   cancelled_docs.arr[cancelled_docs.len]            = '\0';
   print_flag.arr[print_flag.len]                    = '\0';
   slmt_type_fm.arr[slmt_type_fm.len]                = '\0';
   slmt_type_to.arr[slmt_type_to.len]                = '\0';
   
   nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
  

    strcpy(g_facility_id,nd_operating_facility_id.arr);
    strcpy(filename,WORKING_DIR);
    strcat(filename,"blrcasdl.lis");

    if( (f1=fopen(filename,"w")) == NULL) {
        disp_message(ERR_MESG,"Error in opening output file...BLRCASDL.LIS");
	proc_exit();
    }

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
					TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER 
			 INTO   :comp_name,
					:rep_date,
					:oper_id
			 FROM   SY_ACC_ENTITY_lang_vw
			 WHERE  ACC_ENTITY_ID = :nd_operating_facility_id
			 AND		language_id=:p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:\
b3 and language_id=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )123;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
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

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';

    page_no=1;
    line_no=1;

	fetch_legend_value();
    decl_curs();

    put_inp_parm();

    do_report();

    fclose(f1);

    del_parm();
    end_prog_msg();

    /* EXEC SQL COMMIT RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )158;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    return;
}

del_parm()
{

    /* EXEC SQL DELETE SY_PROG_PARAM
         WHERE  PGM_ID     = 'BLRCASDL' 
         AND    PGM_DATE   = :d_pgm_date
         AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 18;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRCASDL' and\
 PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )173;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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
  char nd_str[200];
   
   /*   nd_rn_length = strlen(nd_not_in_string.arr);

	    strcpy(nd_statement.arr,"select '");

	  for (i;i< nd_rn_length;i++)
	  { 
	    if nd_not_in_string.arr[i] <> '|'
		    strcat(nd_statement.arr,nd_not_in_string.arr[i]);
		else
			{strcat(nd_statement.arr, "' from dual union select ' ");}
		
	  }
	  nd_rn_length = strlen(nd_not_in_string.arr);
      
	  if (nd_rn_length > 3)
	  {

      EXEC SQL SELECT REPLACE(:nd_not_in_string,'-',' ')
	           INTO   :nd_not_in_string from dual;

	  nd_rn_length = nd_rn_length-2;

	  EXEC SQL SELECT SUBSTR(:nd_not_in_string,2,:nd_rn_length) 
			   INTO   :nd_statement_rn from dual;
    
      //disp_message(ERR_MESG,nd_statement_rn.arr);

      }

      nd_sn_length = strlen(nd_exclude_cr_trn.arr);

      if (nd_sn_length > 3)
	  {
      EXEC SQL SELECT REPLACE(:nd_exclude_cr_trn,'-',' ')
	           INTO   :nd_exclude_cr_trn from dual;

      nd_sn_length = nd_sn_length-2;

	  EXEC SQL SELECT SUBSTR(:nd_exclude_cr_trn,2,:nd_sn_length) 
			   INTO   :nd_statement_sn from dual;

	  //disp_message(ERR_MESG,nd_statement_sn.arr);

      }

*/
 
      /* EXEC SQL DECLARE BL_REC_REF_CUR CURSOR FOR
           SELECT B.RECPT_REFUND_IND, 
				   //DECODE(B.RECPT_REFUND_IND,'R','Receipts','Payments / Refunds'), COMMENTED BY SAIKIRAN FOR 19587
				  DECODE(B.RECPT_REFUND_IND,'R',:loc_legend[58],:loc_legend[59]),
                  B.DOC_TYPE_CODE, B.DOC_NUMBER, B.DOC_SRNO,B.RECPT_NATURE_CODE,
                  /oDECODE(B.RECPT_NATURE_CODE,
						   'AD','Adjustable Dep ',
					       'RD','Refundable Dep ',
					       'PR','Prepayments',
					       'MI','Miscellaneous',
					       'DC','Def. Cash Pat.',
					       'BI','Against Bill',
					       'CU','Customers',
						   'CR','Credit Card',
						   'HC','Health Card'),COMMENTED BY SAIKIRAN FOR 19587 o/
                    DECODE(B.RECPT_NATURE_CODE,
						   'AD',:loc_legend[60],
					       'RD',:loc_legend[61],
					       'PR',:loc_legend[62],
					       'MI',:loc_legend[63],
					       'DC',:loc_legend[64],
					       'BI',:loc_legend[65],
					       'CU',:loc_legend[66],
						   'CR',:loc_legend[67],
						   'HC',:loc_legend[68]),
                  DEBTOR_CATEGORY_CODE,
		          /oDECODE(DEBTOR_CATEGORY_CODE,
							'I','Inpatients',
							'D','Daycare',			//31/10/2004
						    'O','Outpatients',
							'E','Emergency',
							'R','Referal Patients',
							'Miscellaneous (Deferred cash patients, Customers, Others)'),COMMENTED BY SAIKIRAN FOR 19587 o/
					DECODE(DEBTOR_CATEGORY_CODE,
							'I',:loc_legend[69],
							'D',:loc_legend[70],		 
						    'O',:loc_legend[71],
							'E',:loc_legend[72],
							'R',:loc_legend[73],
							:loc_legend[74]),
                      TRUNC(B.DOC_DATE),
                      TO_CHAR(B.TRX_DATE_TIME,'DD/MM/YYYY HH24:MI'),
                      B.EPISODE_TYPE,
                      B.PATIENT_ID,
                      B.EPISODE_ID,
                      B.VISIT_ID,
                      B.BILL_DOC_TYPE_CODE, 
                      LTRIM(TO_CHAR(B.BILL_DOC_NUMBER,'00000009')),
					  B.BILL_DOC_SRNO,
                      B.CUSTOMER_CODE,
                      B.CASH_COUNTER_CODE,
                      B.SHIFT_ID,
                      TO_CHAR(B.DOC_AMT,'999,999,990.99'),
					  /o   DECODE(RECPT_REFUND_IND,'R',DOC_AMT, -DOC_AMT),   o/
                      B.DOC_AMT,
                      B.RECPT_TYPE_CODE,
                      B.SLMT_TYPE_CODE,
                      B.SLMT_DOC_REF_DESC,
                      TRUNC(B.SLMT_DOC_REF_DATE),
                      B.SLMT_DOC_REMARKS,
                      DECODE(CANCELLED_IND,'N',' ',CANCELLED_IND),
                      SUBSTR(NARRATION,1,40),
                      IP_ADM_TRF_DEP_IND,
					  CANCEL_REASON,
					  A.BLNG_GRP_ID
         FROM BL_RECEIPT_REFUND_hdrdtl_vw B,        
		      BL_BILL_HDR  A
		WHERE TRUNC(B.DOC_DATE)  =TO_DATE(:report_date,'DD/MM/YYYY')
		  AND B.CASH_COUNTER_FACILITY_ID = :nd_operating_facility_id
		  AND B.CASH_COUNTER_CODE BETWEEN
			  NVL(:cash_counter_fm,'  ') AND NVL(:cash_counter_to,'~~')
		  AND B.SHIFT_ID BETWEEN    
			  NVL(:shift_no_fm,' ') AND NVL(:shift_no_to,'~')
		  AND B.RECPT_NATURE_CODE BETWEEN
			  NVL(:receipt_nature_fm,'  ') AND NVL(:receipt_nature_to,'~~')
		  AND NVL(B.RECPT_TYPE_CODE,'   ') BETWEEN
			  NVL(:receipt_type_fm,'   ') AND NVL(:receipt_type_to,'~~~')
		  AND NVL(B.SLMT_TYPE_CODE,'  ') BETWEEN
			  NVL(:slmt_type_fm,'  ') AND NVL(:slmt_type_to,'~~')
		  AND NVL(B.CANCELLED_IND,'X') =   DECODE(:cancelled_docs,'Y','Y',NVL(CANCELLED_IND,'X'))
		   /o AND B.RECPT_REFUND_IND =  DECODE(:print_flag,'1','R','2','F',B.RECPT_REFUND_IND) o/
		  AND B.RECPT_REFUND_IND =  DECODE(:print_flag,'R','R','E','F',B.RECPT_REFUND_IND)
//		  AND B.RECPT_NATURE_CODE NOT IN ( :nd_statement_rn )
		  AND :nd_statement_rn  NOT LIKE '%['||B.RECPT_NATURE_CODE||'[%' 
		  AND :nd_statement_sn NOT LIKE '%['||B.SLMT_TYPE_CODE||'[%'
		  AND A.OPERATING_FACILITY_ID(+) = B.OPERATING_FACILITY_ID
		  AND A.DOC_TYPE_CODE(+) = B.BILL_DOC_TYPE_CODE
		  AND A.DOC_NUM(+)= B.BILL_DOC_NUMBER
		  AND NVL(A.BLNG_GRP_ID,'  ') BETWEEN 
			  NVL(ltrim(rtrim(:blng_grp_fm)),'  ')  AND     NVL(ltrim(rtrim(:blng_grp_to)),'~~')
		ORDER BY B.CASH_COUNTER_CODE, B.SHIFT_ID, B.RECPT_REFUND_IND,
			 A.BLNG_GRP_ID, DEBTOR_CATEGORY_CODE, B.DOC_TYPE_CODE, B.DOC_NUMBER; */ 


/*------ Added on 14/03/1999 to Print Slmt Totals --------*/
  
    /* EXEC SQL DECLARE BL_SLMT_TOTALS CURSOR FOR    
               SELECT A.SLMT_TYPE_CODE,   
		              B.SHORT_DESC,          
					  NVL(SUM(DOC_AMT),0),
				      NVL(SUM(DOC_AMT),0)
                 //FROM BL_RECEIPT_REFUND_hdrDTL_vw A, BL_SLMT_TYPE B commented by saikiran for 19587
                   FROM BL_RECEIPT_REFUND_hdrDTL_vw A, BL_SLMT_TYPE_LANG_VW B

		  WHERE TRUNC(A.DOC_DATE)  = TO_DATE(:report_date,'DD/MM/YYYY')
		  
		  AND :nd_statement_rn  NOT LIKE '%['||a.RECPT_NATURE_CODE||'[%' 
		  AND :nd_statement_sn NOT LIKE '%['||a.SLMT_TYPE_CODE||'[%'
		  /o
		  BETWEEN 
					TO_DATE(:report_date,'DD/MM/YYYY')
		  		AND TO_DATE(:report_date,'DD/MM/YYYY')
		  o/
		  AND CASH_COUNTER_CODE BETWEEN
			  NVL(:cash_counter_fm,'!!') AND NVL(:cash_counter_to,'~~')
		  AND SHIFT_ID BETWEEN
			  NVL(:shift_no_fm,'!') AND NVL(:shift_no_to,'~')
			  /o------ Added for Daily Report ------------o/
		  AND RECPT_NATURE_CODE BETWEEN
			  NVL(:receipt_nature_fm,'  ') AND NVL(:receipt_nature_to,'~~')
		  AND NVL(RECPT_TYPE_CODE,'   ') BETWEEN
			  NVL(:receipt_type_fm,'   ') AND NVL(:receipt_type_to,'~~~') 
		   AND  A.SLMT_TYPE_CODE BETWEEN
			  NVL(:slmt_type_fm,'!!') AND NVL(:slmt_type_to,'~~') 
		  AND NVL(CANCELLED_IND,'N') = 
//			  DECODE(:cancelled_docs,'Y','Y',NVL(CANCELLED_IND,'X'))
			  /o WHILE PRINTING THE FINAL TOTAL THE CANCELLED DOCUMENT AMOUNTS
			     SHOULD NOT BE CONSIDERED o/ 
			  DECODE(:cancelled_docs,'Y','Y','N')

		 /o AND A.RECPT_REFUND_IND = 
			  DECODE(:print_flag,'1','R','2','F',A.RECPT_REFUND_IND)
		  and A.CASH_COUNTER_FACILITY_ID = :nd_operating_facility_id o/
		    AND A.RECPT_REFUND_IND = 
			  DECODE(:print_flag,'R','R','E','F',A.RECPT_REFUND_IND)
		  and A.CASH_COUNTER_FACILITY_ID = :nd_operating_facility_id 
/o------------------------------------------o/
		  AND A.SLMT_TYPE_CODE = B.SLMT_TYPE_CODE(+)
		  	 and language_id=:p_language_id//ADDED BY SAIKIRAN FOR 19587
		GROUP BY A.SLMT_TYPE_CODE,B.SHORT_DESC; */ 


/*--------------------------------------------------------*/  
  
    /* EXEC SQL DECLARE CASH_COUNTER_CUR CURSOR FOR
	     SELECT  LONG_DESC 
	     FROM    BL_CASH_COUNTER_LANG_VW
	     WHERE   CASH_COUNTER_CODE = :d_cash_counter_code
		 AND     OPERATING_FACILITY_ID = :nd_operating_facility_id
		 and language_id=:p_language_id; */ 


	/* EXEC SQL DECLARE BLNG_GRP_ID_CUR CURSOR FOR
	     SELECT  LONG_DESC
		 FROM    BL_BLNG_GRP_LANG_VW
		 WHERE   BLNG_GRP_ID = :d_blng_grp_id
		 and language_id=:p_language_id; */ 


 
    /* EXEC SQL DECLARE RECPT_TYPE_CUR CURSOR FOR
	     SELECT  LONG_DESC 
	     FROM    BL_RECEIPT_TYPE_LANG_VW
	     WHERE   RECEIPT_TYPE_CODE = :d_recpt_type_code
		 and language_id=:p_language_id; */ 


    /* EXEC SQL DECLARE MP_PATIENT_MAST_CUR CURSOR FOR
	     /oSELECT 
		 SUBSTR(SHORT_NAME,1,30),
				 decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,
		         SHORT_NAME_LOC_LANGo/
		SELECT  
			null, 
			decode(:p_language_id,'en', substr(short_name_loc_lang,31,60),null),
			decode(:p_language_id,'en', substr(short_name,1,30),substr(SHORT_NAME_LOC_LANG,1,30))
	     FROM    MP_PATIENT_MAST
	     WHERE   PATIENT_ID = :d_patient_id; */ 


    /* EXEC SQL DECLARE CUSTOMER_CUR CURSOR FOR
	     SELECT  LONG_NAME
	     FROM    AR_CUSTOMER_LANG_VW
	     WHERE   CUST_CODE = :d_customer_code
		 and language_id=:p_language_id; */ 


    /* EXEC SQL DECLARE SLMT_TYPE_CUR CURSOR FOR
	     SELECT  LONG_DESC
	     FROM    BL_SLMT_TYPE_LANG_VW
	     WHERE   SLMT_TYPE_CODE = :d_slmt_type_code
		 and language_id=:p_language_id; */ 


    /* EXEC SQL OPEN BL_REC_REF_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select B.RECPT_REFUND_IND ,DECODE(B.RECPT_REFUND_IND,'R',:b0,:b1) ,B.\
DOC_TYPE_CODE ,B.DOC_NUMBER ,B.DOC_SRNO ,B.RECPT_NATURE_CODE ,DECODE(B.RECPT\
_NATURE_CODE,'AD',:b2,'RD',:b3,'PR',:b4,'MI',:b5,'DC',:b6,'BI',:b7,'CU',:b8,\
'CR',:b9,'HC',:b10) ,DEBTOR_CATEGORY_CODE ,DECODE(DEBTOR_CATEGORY_CODE,'I',:\
b11,'D',:b12,'O',:b13,'E',:b14,'R',:b15,:b16) ,TRUNC(B.DOC_DATE) ,TO_CHAR(B.\
TRX_DATE_TIME,'DD/MM/YYYY HH24:MI') ,B.EPISODE_TYPE ,B.PATIENT_ID ,B.EPISODE\
_ID ,B.VISIT_ID ,B.BILL_DOC_TYPE_CODE ,LTRIM(TO_CHAR(B.BILL_DOC_NUMBER,'0000\
0009')) ,B.BILL_DOC_SRNO ,B.CUSTOMER_CODE ,B.CASH_COUNTER_CODE ,B.SHIFT_ID ,\
TO_CHAR(B.DOC_AMT,'999,999,990.99') ,B.DOC_AMT ,B.RECPT_TYPE_CODE ,B.SLMT_TY\
PE_CODE ,B.SLMT_DOC_REF_DESC ,TRUNC(B.SLMT_DOC_REF_DATE) ,B.SLMT_DOC_REMARKS\
 ,DECODE(CANCELLED_IND,'N',' ',CANCELLED_IND) ,SUBSTR(NARRATION,1,40) ,IP_AD\
M_TRF_DEP_IND ,CANCEL_REASON ,A.BLNG_GRP_ID  from BL_RECEIPT_REFUND_hdrdtl_v\
w B ,BL_BILL_HDR A where ((((((((((((((TRUNC(B.DOC_DATE)=TO_DATE(:b17,'DD/MM\
/YYYY') and B.CASH_COUNTER_FACILITY_ID=:b18");
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )196;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)loc_legend[58];
    sqlstm.sqhstl[0] = (unsigned int  )201;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)loc_legend[59];
    sqlstm.sqhstl[1] = (unsigned int  )201;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)loc_legend[60];
    sqlstm.sqhstl[2] = (unsigned int  )201;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)loc_legend[61];
    sqlstm.sqhstl[3] = (unsigned int  )201;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)loc_legend[62];
    sqlstm.sqhstl[4] = (unsigned int  )201;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)loc_legend[63];
    sqlstm.sqhstl[5] = (unsigned int  )201;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)loc_legend[64];
    sqlstm.sqhstl[6] = (unsigned int  )201;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)loc_legend[65];
    sqlstm.sqhstl[7] = (unsigned int  )201;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)loc_legend[66];
    sqlstm.sqhstl[8] = (unsigned int  )201;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)loc_legend[67];
    sqlstm.sqhstl[9] = (unsigned int  )201;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)loc_legend[68];
    sqlstm.sqhstl[10] = (unsigned int  )201;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)loc_legend[69];
    sqlstm.sqhstl[11] = (unsigned int  )201;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)loc_legend[70];
    sqlstm.sqhstl[12] = (unsigned int  )201;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)loc_legend[71];
    sqlstm.sqhstl[13] = (unsigned int  )201;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)loc_legend[72];
    sqlstm.sqhstl[14] = (unsigned int  )201;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)loc_legend[73];
    sqlstm.sqhstl[15] = (unsigned int  )201;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)loc_legend[74];
    sqlstm.sqhstl[16] = (unsigned int  )201;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&report_date;
    sqlstm.sqhstl[17] = (unsigned int  )15;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[18] = (unsigned int  )5;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&cash_counter_fm;
    sqlstm.sqhstl[19] = (unsigned int  )7;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&cash_counter_to;
    sqlstm.sqhstl[20] = (unsigned int  )7;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&shift_no_fm;
    sqlstm.sqhstl[21] = (unsigned int  )4;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&shift_no_to;
    sqlstm.sqhstl[22] = (unsigned int  )4;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&receipt_nature_fm;
    sqlstm.sqhstl[23] = (unsigned int  )5;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&receipt_nature_to;
    sqlstm.sqhstl[24] = (unsigned int  )5;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&receipt_type_fm;
    sqlstm.sqhstl[25] = (unsigned int  )6;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&receipt_type_to;
    sqlstm.sqhstl[26] = (unsigned int  )6;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&slmt_type_fm;
    sqlstm.sqhstl[27] = (unsigned int  )5;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&slmt_type_to;
    sqlstm.sqhstl[28] = (unsigned int  )5;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&cancelled_docs;
    sqlstm.sqhstl[29] = (unsigned int  )4;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&print_flag;
    sqlstm.sqhstl[30] = (unsigned int  )4;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&nd_statement_rn;
    sqlstm.sqhstl[31] = (unsigned int  )202;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqhstv[32] = (         void  *)&nd_statement_sn;
    sqlstm.sqhstl[32] = (unsigned int  )202;
    sqlstm.sqhsts[32] = (         int  )0;
    sqlstm.sqindv[32] = (         void  *)0;
    sqlstm.sqinds[32] = (         int  )0;
    sqlstm.sqharm[32] = (unsigned int  )0;
    sqlstm.sqadto[32] = (unsigned short )0;
    sqlstm.sqtdso[32] = (unsigned short )0;
    sqlstm.sqhstv[33] = (         void  *)&blng_grp_fm;
    sqlstm.sqhstl[33] = (unsigned int  )7;
    sqlstm.sqhsts[33] = (         int  )0;
    sqlstm.sqindv[33] = (         void  *)0;
    sqlstm.sqinds[33] = (         int  )0;
    sqlstm.sqharm[33] = (unsigned int  )0;
    sqlstm.sqadto[33] = (unsigned short )0;
    sqlstm.sqtdso[33] = (unsigned short )0;
    sqlstm.sqhstv[34] = (         void  *)&blng_grp_to;
    sqlstm.sqhstl[34] = (unsigned int  )7;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor BL_REC_REF_CUR",0,"");

}

fetch_bl_rec()
{

    d_recpt_refund_ind.arr[0]                                         = '\0';
    d_doc_type_code.arr[0]                                            = '\0';
    d_doc_number.arr[0]                                               = '\0';
	d_doc_srno.arr[0]		                                          = '\0';
    d_recpt_nature_code.arr[0]                                        = '\0';
    d_debtor_category_code.arr[0]                                     = '\0';
    d_doc_date.arr[0]                                                 = '\0';
    d_trx_date_time.arr[0]                                            = '\0';
    d_episode_type.arr[0]                                             = '\0';
    d_patient_id.arr[0]                                               = '\0';
    d_episode_id.arr[0]                                               = '\0';
    d_visit_id.arr[0]                                                 = '\0';
    d_bill_doc_type_code.arr[0]                                       = '\0';
    d_bill_doc_number.arr[0]                                          = '\0';
	d_bill_doc_srno.arr[0]                                            = '\0';
    d_customer_code.arr[0]                                            = '\0';
    d_cash_counter_code.arr[0]                                        = '\0';
    d_blng_grp_id.arr[0]											  = '\0';
	d_shift_id.arr[0]                                                 = '\0';
    d_doc_amt.arr[0]                                                  = '\0';
    d_recpt_type_code.arr[0]                                          = '\0';
    d_slmt_type_code.arr[0]                                           = '\0';
    d_slmt_doc_ref_desc.arr[0]                                        = '\0';
    d_slmt_doc_ref_date.arr[0]                                        = '\0';
    d_slmt_doc_remarks.arr[0]                                         = '\0';
    d_cancelled_ind.arr[0]                                            = '\0';
    d_narration.arr[0]                                                = '\0';
    d_recpt_refund_desc.arr[0]                                        = '\0';
    d_recpt_nature_desc.arr[0]                                        = '\0';
    d_debtor_category_desc.arr[0]                                     = '\0';
    d_ip_adm_trf_dep_ind.arr[0]                                       = '\0';
	
	d_cancel_reason.arr[0]                                            = '\0';

    d_recpt_refund_ind.len                                            = 0;
    d_doc_type_code.len                                               = 0;
    d_doc_number.len                                                  = 0;
	d_doc_srno.len		                                              = 0;
    d_recpt_nature_code.len                                           = 0;
    d_debtor_category_code.len                                        = 0;
    d_doc_date.len                                                    = 0;
    d_trx_date_time.len                                               = 0;
    d_episode_type.len                                                = 0;
    d_patient_id.len                                                  = 0;
    d_episode_id.len                                                  = 0;
    d_visit_id.len                                                    = 0;
    d_bill_doc_type_code.len                                          = 0;
    d_bill_doc_number.len                                             = 0;
	d_bill_doc_srno.len                                               = 0;
    d_customer_code.len                                               = 0;
    d_cash_counter_code.len                                           = 0;
	d_blng_grp_id.len												  = 0;
    d_shift_id.len                                                    = 0;
    d_doc_amt.len                                                     = 0;
    d_recpt_type_code.len                                             = 0;
    d_slmt_type_code.len                                              = 0;
    d_slmt_doc_ref_desc.len                                           = 0;
    d_slmt_doc_ref_date.len                                           = 0;
    d_slmt_doc_remarks.len                                            = 0;
    d_cancelled_ind.len                                               = 0;
    d_narration.len                                                   = 0;
    d_recpt_refund_desc.len                                           = 0;
    d_recpt_nature_desc.len                                           = 0;
    d_debtor_category_desc.len                                        = 0;
    d_ip_adm_trf_dep_ind.len                                          = 0;

	d_cancel_reason.len                                               = 0;
    
    d_doc_amt_num = 0;

     /* EXEC SQL FETCH BL_REC_REF_CUR
               INTO :d_recpt_refund_ind,
		    :d_recpt_refund_desc,
                    :d_doc_type_code,
                    :d_doc_number,
					:d_doc_srno,
                    :d_recpt_nature_code,
                    :d_recpt_nature_desc,
                    :d_debtor_category_code,
                    :d_debtor_category_desc,
                    :d_doc_date,
                    :d_trx_date_time,
                    :d_episode_type,
                    :d_patient_id,
                    :d_episode_id,
                    :d_visit_id,
                    :d_bill_doc_type_code,
                    :d_bill_doc_number,
					:d_bill_doc_srno,
                    :d_customer_code,
                    :d_cash_counter_code,
                    :d_shift_id,
                    :d_doc_amt,
                    :d_doc_amt_num,
                    :d_recpt_type_code,
                    :d_slmt_type_code,
                    :d_slmt_doc_ref_desc,
                    :d_slmt_doc_ref_date,
                    :d_slmt_doc_remarks,
                    :d_cancelled_ind,
                    :d_narration,
                    :d_ip_adm_trf_dep_ind,
					:d_cancel_reason,
					:d_blng_grp_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 35;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )351;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_recpt_refund_ind;
     sqlstm.sqhstl[0] = (unsigned int  )4;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_recpt_refund_desc;
     sqlstm.sqhstl[1] = (unsigned int  )33;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_doc_type_code;
     sqlstm.sqhstl[2] = (unsigned int  )9;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_doc_number;
     sqlstm.sqhstl[3] = (unsigned int  )11;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_doc_srno;
     sqlstm.sqhstl[4] = (unsigned int  )9;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_recpt_nature_code;
     sqlstm.sqhstl[5] = (unsigned int  )5;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&d_recpt_nature_desc;
     sqlstm.sqhstl[6] = (unsigned int  )18;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&d_debtor_category_code;
     sqlstm.sqhstl[7] = (unsigned int  )4;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&d_debtor_category_desc;
     sqlstm.sqhstl[8] = (unsigned int  )63;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&d_doc_date;
     sqlstm.sqhstl[9] = (unsigned int  )15;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&d_trx_date_time;
     sqlstm.sqhstl[10] = (unsigned int  )19;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&d_episode_type;
     sqlstm.sqhstl[11] = (unsigned int  )4;
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&d_patient_id;
     sqlstm.sqhstl[12] = (unsigned int  )23;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&d_episode_id;
     sqlstm.sqhstl[13] = (unsigned int  )11;
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&d_visit_id;
     sqlstm.sqhstl[14] = (unsigned int  )7;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&d_bill_doc_type_code;
     sqlstm.sqhstl[15] = (unsigned int  )9;
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&d_bill_doc_number;
     sqlstm.sqhstl[16] = (unsigned int  )11;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&d_bill_doc_srno;
     sqlstm.sqhstl[17] = (unsigned int  )9;
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&d_customer_code;
     sqlstm.sqhstl[18] = (unsigned int  )11;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&d_cash_counter_code;
     sqlstm.sqhstl[19] = (unsigned int  )7;
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&d_shift_id;
     sqlstm.sqhstl[20] = (unsigned int  )4;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&d_doc_amt;
     sqlstm.sqhstl[21] = (unsigned int  )25;
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&d_doc_amt_num;
     sqlstm.sqhstl[22] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&d_recpt_type_code;
     sqlstm.sqhstl[23] = (unsigned int  )6;
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&d_slmt_type_code;
     sqlstm.sqhstl[24] = (unsigned int  )5;
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqhstv[25] = (         void  *)&d_slmt_doc_ref_desc;
     sqlstm.sqhstl[25] = (unsigned int  )23;
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
     sqlstm.sqhstv[26] = (         void  *)&d_slmt_doc_ref_date;
     sqlstm.sqhstl[26] = (unsigned int  )23;
     sqlstm.sqhsts[26] = (         int  )0;
     sqlstm.sqindv[26] = (         void  *)0;
     sqlstm.sqinds[26] = (         int  )0;
     sqlstm.sqharm[26] = (unsigned int  )0;
     sqlstm.sqadto[26] = (unsigned short )0;
     sqlstm.sqtdso[26] = (unsigned short )0;
     sqlstm.sqhstv[27] = (         void  *)&d_slmt_doc_remarks;
     sqlstm.sqhstl[27] = (unsigned int  )33;
     sqlstm.sqhsts[27] = (         int  )0;
     sqlstm.sqindv[27] = (         void  *)0;
     sqlstm.sqinds[27] = (         int  )0;
     sqlstm.sqharm[27] = (unsigned int  )0;
     sqlstm.sqadto[27] = (unsigned short )0;
     sqlstm.sqtdso[27] = (unsigned short )0;
     sqlstm.sqhstv[28] = (         void  *)&d_cancelled_ind;
     sqlstm.sqhstl[28] = (unsigned int  )4;
     sqlstm.sqhsts[28] = (         int  )0;
     sqlstm.sqindv[28] = (         void  *)0;
     sqlstm.sqinds[28] = (         int  )0;
     sqlstm.sqharm[28] = (unsigned int  )0;
     sqlstm.sqadto[28] = (unsigned short )0;
     sqlstm.sqtdso[28] = (unsigned short )0;
     sqlstm.sqhstv[29] = (         void  *)&d_narration;
     sqlstm.sqhstl[29] = (unsigned int  )83;
     sqlstm.sqhsts[29] = (         int  )0;
     sqlstm.sqindv[29] = (         void  *)0;
     sqlstm.sqinds[29] = (         int  )0;
     sqlstm.sqharm[29] = (unsigned int  )0;
     sqlstm.sqadto[29] = (unsigned short )0;
     sqlstm.sqtdso[29] = (unsigned short )0;
     sqlstm.sqhstv[30] = (         void  *)&d_ip_adm_trf_dep_ind;
     sqlstm.sqhstl[30] = (unsigned int  )4;
     sqlstm.sqhsts[30] = (         int  )0;
     sqlstm.sqindv[30] = (         void  *)0;
     sqlstm.sqinds[30] = (         int  )0;
     sqlstm.sqharm[30] = (unsigned int  )0;
     sqlstm.sqadto[30] = (unsigned short )0;
     sqlstm.sqtdso[30] = (unsigned short )0;
     sqlstm.sqhstv[31] = (         void  *)&d_cancel_reason;
     sqlstm.sqhstl[31] = (unsigned int  )53;
     sqlstm.sqhsts[31] = (         int  )0;
     sqlstm.sqindv[31] = (         void  *)0;
     sqlstm.sqinds[31] = (         int  )0;
     sqlstm.sqharm[31] = (unsigned int  )0;
     sqlstm.sqadto[31] = (unsigned short )0;
     sqlstm.sqtdso[31] = (unsigned short )0;
     sqlstm.sqhstv[32] = (         void  *)&d_blng_grp_id;
     sqlstm.sqhstl[32] = (unsigned int  )7;
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


					
				
d_srlno=d_srlno+1;
    if(OERROR)
	err_mesg("FETCH failed on cursor BL_REC_REF_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_recpt_refund_ind.arr[d_recpt_refund_ind.len]                       = '\0';
    d_doc_type_code.arr[d_doc_type_code.len]                             = '\0';
    d_doc_number.arr[d_doc_number.len]                                   = '\0';
	d_doc_srno.arr[d_doc_srno.len]					                     = '\0';
    d_recpt_nature_code.arr[d_recpt_nature_code.len]                     = '\0';
    d_debtor_category_code.arr[d_debtor_category_code.len]               = '\0';
    d_doc_date.arr[d_doc_date.len]                                       = '\0';
    d_trx_date_time.arr[d_trx_date_time.len]                             = '\0';
    d_episode_type.arr[d_episode_type.len]                               = '\0';
    d_patient_id.arr[d_patient_id.len]                                   = '\0';
    d_episode_id.arr[d_episode_id.len]                                   = '\0';
    d_visit_id.arr[d_visit_id.len]                                       = '\0';
    d_bill_doc_type_code.arr[d_bill_doc_type_code.len]                   = '\0';
    d_bill_doc_number.arr[d_bill_doc_number.len]                         = '\0';
	d_bill_doc_srno.arr[d_bill_doc_srno.len]                             = '\0';
    d_customer_code.arr[d_customer_code.len]                             = '\0';
    d_cash_counter_code.arr[d_cash_counter_code.len]                     = '\0';
    d_shift_id.arr[d_shift_id.len]                                       = '\0';
    d_doc_amt.arr[d_doc_amt.len]                                         = '\0';
    d_recpt_type_code.arr[d_recpt_type_code.len]                         = '\0';
    d_slmt_type_code.arr[d_slmt_type_code.len]                           = '\0';
    d_slmt_doc_ref_desc.arr[d_slmt_doc_ref_desc.len]                     = '\0';
    d_slmt_doc_ref_date.arr[d_slmt_doc_ref_date.len]                     = '\0';
    d_slmt_doc_remarks.arr[d_slmt_doc_remarks.len]                       = '\0';
    d_cancelled_ind.arr[d_cancelled_ind.len]                             = '\0';
    d_narration.arr[d_narration.len]                                     = '\0';
    d_recpt_refund_desc.arr[d_recpt_refund_desc.len]                     = '\0';
    d_recpt_nature_desc.arr[d_recpt_nature_desc.len]                     = '\0';
    d_debtor_category_desc.arr[d_debtor_category_desc.len]               = '\0';
    d_ip_adm_trf_dep_ind.arr[d_ip_adm_trf_dep_ind.len]                   = '\0';
	d_blng_grp_id.arr[d_blng_grp_id.len]								 = '\0';
	
	d_cancel_reason.arr[d_cancel_reason.len]                             = '\0';

    return 1;

}


close_bl_rec_ref_cur()
{
    /* EXEC SQL CLOSE BL_REC_REF_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )498;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if(ERROR)
	err_mesg("CLOSE failed on cursor BL_REC_REF_CUR",0,"");
}


/*-------- Added on 14/3/1999 to Print Slmt Totals ---------*/

fetch_slmt_totals()
{
   
    d_slmt_type_code.arr[0]  = '\0';
    d_slmt_type_desc.arr[0]  = '\0';


    d_slmt_type_code.len     = 0;
    d_slmt_type_desc.len     = 0;

    
	nd_doc_amt			     = 0;

    d_doc_amt_num = 0;

		 
     /* EXEC SQL FETCH BL_SLMT_TOTALS
               INTO :d_slmt_type_code,
				    :d_slmt_type_desc,
	                :nd_doc_amt,
                    :d_doc_amt_num; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 35;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )513;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_slmt_type_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_slmt_type_desc;
     sqlstm.sqhstl[1] = (unsigned int  )43;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_doc_amt;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_doc_amt_num;
     sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
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



    if(ERROR)
	err_mesg("FETCH failed on cursor BL_SLMT_TOTALS",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_slmt_type_code.arr[d_slmt_type_code.len]   = '\0';
    d_slmt_type_desc.arr[d_slmt_type_desc.len]   = '\0';

            
       chk_break(1);
  
    tot_doc_amt = tot_doc_amt + nd_doc_amt;


    return 1;
	
}

/*----------------------------------------------------------*/

fetch_counter_desc()
{

    /* EXEC SQL OPEN CASH_COUNTER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )544;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cash_counter_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
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
        err_mesg("OPEN failed on cursor CASH_COUNTER_CUR",0,"");

    d_counter_desc.arr[0]  = '\0';
    d_counter_desc.len  = 0;

    /* EXEC SQL FETCH CASH_COUNTER_CUR 
	     INTO  :d_counter_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )571;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_counter_desc;
    sqlstm.sqhstl[0] = (unsigned int  )103;
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
        err_mesg("FETCH failed on cursor CASH_COUNTER_CUR",0,"");
   
    d_counter_desc.arr[d_counter_desc.len]  = '\0';

}

fetch_blnggrp_desc()
{

    /* EXEC SQL OPEN BLNG_GRP_ID_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )590;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[0] = (unsigned int  )7;
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



    if(OERROR)
        err_mesg("OPEN failed on cursor BLNG_GRP_ID_CUR",0,"");

    d_blnggrp_desc.arr[0]  = '\0';
    d_blnggrp_desc.len  = 0;

    /* EXEC SQL FETCH BLNG_GRP_ID_CUR
	     INTO  :d_blnggrp_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )613;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blnggrp_desc;
    sqlstm.sqhstl[0] = (unsigned int  )103;
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
        err_mesg("FETCH failed on cursor BLNG_GRP_ID_CUR",0,"");
   
    d_blnggrp_desc.arr[d_blnggrp_desc.len]  = '\0';

}

fetch_recpt_desc()
{

    /* EXEC SQL OPEN RECPT_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0010;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )632;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_recpt_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )6;
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



    if(OERROR)
        err_mesg("OPEN failed on cursor RECPT_TYPE_CUR",0,"");

    d_recpt_desc.arr[0]  = '\0';
    d_recpt_desc.len  = 0;

    /* EXEC SQL FETCH RECPT_TYPE_CUR 
	     INTO  :d_recpt_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )655;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_recpt_desc;
    sqlstm.sqhstl[0] = (unsigned int  )103;
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
        err_mesg("FETCH failed on cursor RECPT_TYPE_CUR",0,"");
   
    d_recpt_desc.arr[d_recpt_desc.len]  = '\0';

}
fetch_patient_name()
{

    d_patient_name.arr[0]  = '\0';
	d_patient_name1.arr[0]  = '\0';
    d_patient_name_loc_lang.arr[0]  = '\0';

    d_patient_name.len  = 0;
	d_patient_name1.len  = 0;
    d_patient_name_loc_lang.len  = 0;

    /* EXEC SQL OPEN MP_PATIENT_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0011;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )674;
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
    sqlstm.sqhstv[1] = (         void  *)&p_language_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
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
	err_mesg("OPEN failed on cursor MP_PATIENT_MAST_CUR",0,"");      

    /* EXEC SQL FETCH MP_PATIENT_MAST_CUR 
	     INTO  :d_patient_name,
			   :d_patient_name1,
			   :d_patient_name_loc_lang; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )701;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_name;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_patient_name1;
    sqlstm.sqhstl[1] = (unsigned int  )63;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_patient_name_loc_lang;
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



    if(OERROR)
	err_mesg("FETCH failed on table MP_PATIENT_MAST_CUR",0,"");

    d_patient_name.arr[d_patient_name.len]  = '\0';
	d_patient_name1.arr[d_patient_name1.len]  = '\0';
    d_patient_name_loc_lang.arr[d_patient_name_loc_lang.len]  = '\0';
}


fetch_cust_name()
{

    /* EXEC SQL OPEN CUSTOMER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0012;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )728;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_customer_code;
    sqlstm.sqhstl[0] = (unsigned int  )11;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor CUSTOMER_CUR",0,"");

    d_cust_name.arr[0]  = '\0';
    d_cust_name.len  = 0;

    /* EXEC SQL FETCH CUSTOMER_CUR 
	     INTO  :d_cust_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )751;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_name;
    sqlstm.sqhstl[0] = (unsigned int  )73;
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
	err_mesg("FETCH failed on cursor CUSTOMER_CUR",0,"");
	      
    d_cust_name.arr[d_cust_name.len]  = '\0';

}

fetch_slmt_desc()
{

    /* EXEC SQL OPEN SLMT_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0013;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )770;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_slmt_type_code;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor SLMT_TYPE_CUR",0,"");

    d_slmt_type_desc.arr[0]  = '\0';
    d_slmt_type_desc.len  = 0;

    /* EXEC SQL FETCH SLMT_TYPE_CUR
	     INTO  :d_slmt_type_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )793;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_slmt_type_desc;
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
	err_mesg("FETCH failed on cursor SLMT_TYPE_CUR",0,"");

    d_slmt_type_desc.arr[d_slmt_type_desc.len]  = '\0';

}

do_report()
{

    int cnt,first,brk;
    char s_amt[20];

    g_tot_debtor  = 0;
    g_tot_recpt   = 0;
    g_tot_shift   = 0;
    g_tot_counter = 0;
    g_tot_void    = 0;
    g_tot_blngrp  = 0;

    g_grand_tot = 0;
    line_no = 1;
	
    put_hdr();
   
    g_hdr_cnt = 0;
    init_prv_values();

    while(fetch_bl_rec()) {

	if((brk = change())) {
	    if(g_hdr_cnt)
	        print_totals(brk,1);
            copy_val();
	    put_rec(brk);
	}
	else {
            copy_val(); 
	    put_rec(0);
	}
        g_tot_debtor  += d_cancelled_ind.arr[0]=='Y'?0:d_doc_amt_num;
        g_tot_recpt   += d_cancelled_ind.arr[0]=='Y'?0:d_doc_amt_num;
        g_tot_shift   += d_cancelled_ind.arr[0]=='Y'?0:d_doc_amt_num;
        g_tot_counter += d_cancelled_ind.arr[0]=='Y'?0:d_doc_amt_num;
        g_tot_void    += d_cancelled_ind.arr[0]=='Y'?d_doc_amt_num:0;
		g_tot_blngrp  += d_cancelled_ind.arr[0]=='Y'?0:d_doc_amt_num;

        g_grand_tot   += d_cancelled_ind.arr[0]=='Y'?0:d_doc_amt_num;

        g_hdr_cnt = 1;
    }

     close_bl_rec_ref_cur();//added by saikiran
    if(g_hdr_cnt) {
	print_totals(4,0);
	print_grand_totals();
    }

	/*------ Added on 14/03/1999 to Print Slmt Totals -----*/
	if(g_hdr_cnt) print_slmt_totals();
	/*------------------------------------------------------*/

    print_end_of_rep();

}


put_hdr()
{
	if(rep_date.arr[0]!='\0')
	{
      init_date_temp_var();                              //pradeep

	  strcpy(date_convert.arr,rep_date.arr);            // pradeep
 	  fun_change_loc_date();
	}
     fprintf(f1,"\n");
  //   fprintf(f1,"%5s : %-5s                                      %30s                                       %s\n",loc_legend[46],loc_legend[17],comp_name.arr,date_convert.arr);
      fprintf(f1,"%5s : %-5s                                      %30s                           %11s : %s\n",loc_legend[46],loc_legend[17],comp_name.arr,loc_legend[01],date_convert.arr);
     fprintf(f1,"%5s : %-5s\n",loc_legend[47],oper_id.arr);
	if(report_date.arr[0]!='\0')
	{
      init_date_temp_var();                              //pradeep

	  strcpy(date_convert.arr,report_date.arr);            // pradeep
 
	  fun_change_loc_date();
	}
    fprintf(f1,"%5s : %-5s                               %30s (%10s)                         %-s : %-4d\n",loc_legend[48],loc_legend[4],loc_legend[45],date_convert.arr,loc_legend[3],page_no);
     
    fprintf(f1,"-------------------------------------------------------------------------------------------------------------------------------------\n");
	//fprintf(f1,"    %18s  %13s          %13s                     %13s  %14s  %17s\n",loc_legend[18],loc_legend[19],loc_legend[20],loc_legend[21],loc_legend[22],loc_legend[23]);
	           

    fprintf(f1,"  %-19.19s  %-14.14s       %-32.32s   %-12.12s     %-15.15s       %15.15s\n",loc_legend[18],loc_legend[19],loc_legend[20],loc_legend[21],loc_legend[22],loc_legend[23]);
    fprintf(f1,"      %-13.13s      %-12.12s           %-16.16s                            %-13.13s                 %11.11s\n",loc_legend[24],loc_legend[25],loc_legend[26],loc_legend[27],loc_legend[28]);
/*--------- Added on 14/03/1999 to print Cancel reason ---------*/	
	fprintf(f1,"                       %-14.14s       %-8.8s                                                            %-25.25s\n",loc_legend[29],loc_legend[30],loc_legend[42]);											
	fprintf(f1,"      %17.18s \n",loc_legend[31]);
/*--------------------------------------------------------------*/
	
    fprintf(f1,"-------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n");

    line_no=8;

}

put_carry()
{
	    fetch_counter_desc();
	    fprintf(f1,"%-15.15s : %-2s - %30.30s  %15.15s: %s %25.25s: %-30s\n\n",loc_legend[9],
		    d_cash_counter_code.arr, d_counter_desc.arr,loc_legend[32], 
		    d_shift_id.arr,loc_legend[16],
		    d_recpt_refund_desc.arr);

		fetch_blnggrp_desc();
		fprintf(f1,"%-16.19s  : %-4s - %-40.40s \n",loc_legend[14],d_blng_grp_id.arr, d_blnggrp_desc.arr);

	  //  fprintf(f1,"%-19.19s: %-60s\n",loc_legend[33],
	  fprintf(f1,"%-20.20s:  %-60.60s\n",loc_legend[33],
		    d_prv_debtor_category_desc.arr);

	    line_no +=4;
}

put_rec(flg) 
int flg;
{

    if(flg) {

	if(flg > 1) {
	    fetch_counter_desc();
	    fprintf(f1,"%15.15s     : %-4s - %30.30s     %15.15s     : %s     %16.16s     : %-30s\n\n",loc_legend[9],
		    d_cash_counter_code.arr, d_counter_desc.arr,loc_legend[32], 
		    d_shift_id.arr,loc_legend[51],
		    d_recpt_refund_desc.arr);

        fetch_blnggrp_desc();
		fprintf(f1,"%16.17s    : %-4s - %-40.40s \n",loc_legend[14], d_blng_grp_id.arr, d_blnggrp_desc.arr);

	    fprintf(f1,"%-20.20s: %-60.60s\n",loc_legend[33],
		     d_debtor_category_desc.arr);

	    line_no +=4;
	}
	else {
	    chk_break(3);
	    if(!g_page_break) {
	    fprintf(f1,"\n\n%20s  : %-30s\n",loc_legend[33],
		     d_debtor_category_desc.arr);
	        line_no +=3;
	    }
	}
    }

    chk_break(3);
    fetch_recpt_desc();
    fetch_slmt_desc();
		if(d_trx_date_time.arr[0]!='\0')
		{
	      init_date_temp_var();                              //pradeep

	      strcpy(date_convert.arr,d_trx_date_time.arr);            // pradeep
 
	      fun_change_loc_date();
 
		}
    fprintf(f1,"\n  %-6s/%-8s/%-2s   %-2s %-14.14s   %-3s%-32.32s %-16s %-6s/%-12s/%-2s ",
	//%s    %s\n",
	    d_doc_type_code.arr, d_doc_number.arr,d_doc_srno.arr, d_recpt_nature_code.arr,
	    d_recpt_nature_desc.arr, d_recpt_type_code.arr, 
	    d_recpt_desc.arr, date_convert.arr, 
	    d_bill_doc_type_code.arr, d_bill_doc_number.arr,d_bill_doc_srno.arr);
		print_formated(d_doc_amt_num);
    fprintf(f1,"  %s\n", d_cancelled_ind.arr);
/*	if(d_slmt_doc_ref_date.arr[0]!='\0')
		{
	
		init_date_temp_var1();
		
		strcpy(date_convert1.arr,d_slmt_doc_ref_date.arr);
 
		fun_change_loc_date1();	
		}
		fprintf(f1,"      %-18.18s %-22.22s %-12s %-30.30s %-32.32s%8s\n",
   	    d_slmt_type_desc.arr,
	    d_slmt_doc_ref_desc.arr, date_convert1.arr,
            d_slmt_doc_remarks.arr, d_narration.arr,
            d_ip_adm_trf_dep_ind.arr);
		*/
        fprintf(f1,"      %-18.18s %-22.22s %-42.42s  %-31.31s%8s\n",
   	    d_slmt_type_desc.arr,
	    d_slmt_doc_ref_desc.arr, 
            d_slmt_doc_remarks.arr, d_narration.arr,
            d_ip_adm_trf_dep_ind.arr);  
			

/*
	       "      XXXXXX 99999999  XX XXXXXXXXXXXXXXX XXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XX/XX/XXXX XX:XX XXXXXX/999999999 999,999,999.99    X"
	       "       XX XXXXXXXXXXXXXXX  XXXXXXXXXXXXXXXXXXXX XX/XX/XXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
*/

    line_no += 3;

    if(d_patient_id.arr[0])
	{
	fetch_patient_name();
	//fprintf(f1,"                      %-20s %-16.16s %-30.30s %1s %8s %4s\n",
	
	/*fprintf(f1,"                       %-20s %-30s %-30s %1s %-9s %-3s \n",
		   d_patient_id.arr, d_patient_name_loc_lang.arr,
		   d_patient_name.arr, d_episode_type.arr,d_episode_id.arr,
		   d_visit_id.arr);*/



     fprintf(f1,"                       %-20s %-30s %-30.30s           %1s/%-9s/%-3s \n",
		   d_patient_id.arr, d_patient_name_loc_lang.arr,
		   d_patient_name.arr, d_episode_type.arr,d_episode_id.arr,
		   d_visit_id.arr);
	  
	if(p_language_id.arr[0] != 'th')
	{
	if(strlen(d_patient_name1.arr) > 2)
	{
		fprintf(f1,"%60s %s \n"," ",d_patient_name1.arr);
		line_no++;
	}
	}
	line_no ++;

	fprintf(f1,"      %s\n",d_cancel_reason.arr);
/*
	           "          Patient      :  XXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX X 99999999 9999"
*/   

    }

    if(d_customer_code.arr[0]) {
	fetch_cust_name();
	fprintf(f1,"          Customer     :  %-8s %-30s\n", d_customer_code.arr, d_cust_name.arr);
	line_no ++;

/*
	           "          Customer     :  XXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX "
*/

    }

}

/*----------- Added on 14/3/1999 to Print Slmt Totals ------------------*/

print_slmt_totals()
{
    char s_amt[20];
	tot_doc_amt = 0;

    chk_break(4);
	/*--------- Page Skip Added on 13/3/1999 ----------*/
	 fprintf(f1,"");
           line_no = 1;
           ++page_no;
	   put_hdr();
	/*-------------------------------------------------*/

    fprintf(f1,"\n\n%s\n",loc_legend[34]);
    fprintf(f1,"----------------------------------------------\n\n");
    line_no += 5;

    /* EXEC SQL OPEN BL_SLMT_TOTALS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )812;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&report_date;
    sqlstm.sqhstl[0] = (unsigned int  )15;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_statement_rn;
    sqlstm.sqhstl[1] = (unsigned int  )202;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_statement_sn;
    sqlstm.sqhstl[2] = (unsigned int  )202;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&cash_counter_fm;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&cash_counter_to;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&shift_no_fm;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&shift_no_to;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&receipt_nature_fm;
    sqlstm.sqhstl[7] = (unsigned int  )5;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&receipt_nature_to;
    sqlstm.sqhstl[8] = (unsigned int  )5;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&receipt_type_fm;
    sqlstm.sqhstl[9] = (unsigned int  )6;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&receipt_type_to;
    sqlstm.sqhstl[10] = (unsigned int  )6;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&slmt_type_fm;
    sqlstm.sqhstl[11] = (unsigned int  )5;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&slmt_type_to;
    sqlstm.sqhstl[12] = (unsigned int  )5;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&cancelled_docs;
    sqlstm.sqhstl[13] = (unsigned int  )4;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&print_flag;
    sqlstm.sqhstl[14] = (unsigned int  )4;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[15] = (unsigned int  )5;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&p_language_id;
    sqlstm.sqhstl[16] = (unsigned int  )5;
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


    if(ERROR)
	err_mesg("OPEN failed on cursor BL_SLMT_TOTALS",0,"");
     
    while(fetch_slmt_totals()) {
	  
       chk_break(1);
	   
       fprintf(f1,"%-2s %-16.16s    ", 
		  d_slmt_type_code.arr, d_slmt_type_desc.arr);
       print_formated(nd_doc_amt);
		fprintf(f1,"\n");
       line_no ++;
    }

	 fprintf(f1,"%-18s"," ");
	   fprintf(f1,"-----------------------\n");
	   fprintf(f1,"%9s              ",loc_legend[35]);
	   print_formated(tot_doc_amt);
	   fprintf(f1,"\n%-18s"," ");
	   fprintf(f1,"-----------------------\n");
    /* EXEC SQL CLOSE BL_SLMT_TOTALS; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )895;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if(ERROR)
	err_mesg("CLOSE failed on cursor BL_SLMT_TOTALS",0,"");
}

          
/*----------------------------------------------------------------------*/

print_totals(brk,new_page)
int brk, new_page;
{

    char s_amt[20];

    chk_break(brk+1);

    fprintf(f1,"\n");

    if(brk >= 1) {
	put_val(s_amt,g_tot_debtor);
	format_amt(s_amt);
	fprintf(f1,"%63s ( %-15.15s ) %26s :%15s\n", "",d_blnggrp_desc.arr,loc_legend[44],s_amt);
	g_tot_debtor = 0;
    }

    if(brk >= 2) 
    {
	put_val(s_amt,g_tot_blngrp);
	format_amt(s_amt);
	fprintf(f1,"%83s%25s   :%15s\n", "",loc_legend[36],s_amt);
	g_tot_shift = 0;
    }

    if(brk >= 3) {
	put_val(s_amt,g_tot_recpt);
	format_amt(s_amt);
	fprintf(f1,"%83s%25s   :%15s\n", "",loc_legend[37],s_amt);
	g_tot_recpt = 0;

	put_val(s_amt,g_tot_void);
	format_amt(s_amt);
	fprintf(f1,"%83s%25s   :%15s\n", "",loc_legend[38],s_amt);
	g_tot_void  = 0;
    }

    if(brk >= 4) {
	put_val(s_amt,g_tot_shift);
	format_amt(s_amt);
	fprintf(f1,"%83s%25s   :%15s\n", "",loc_legend[39],s_amt);
	g_tot_shift = 0;
    }


 
    if(brk == 5) 
   {
	put_val(s_amt,g_tot_counter);
	format_amt(s_amt);
	fprintf(f1,"%83s%25s   :%15s\n", "",loc_legend[40],s_amt);
	g_tot_counter = 0;
    }

    line_no += brk+1;
    if(brk > 1 && new_page) {
           fprintf(f1,"");
           line_no = 1;
           ++page_no;
	   put_hdr();
    }

}

print_grand_totals()
{
    char s_amt[20];

    chk_break(2);

    put_val(s_amt,g_grand_tot);
    format_amt(s_amt);
    fprintf(f1,"\n%79s %25s      :%15s\n\n", "",loc_legend[41],s_amt);
    
    line_no += 3;

}

chk_break(nol)
int nol;
{

	g_page_break = 0;

	if(line_no+nol >= 35)   //55 //modified by sai on 21-dec-2009 for 17258
	 {
	   g_page_break = 1;
           fprintf(f1,"");
           line_no = 1;
           ++page_no;
	   put_hdr();
	   put_carry();
	}

}
 
put_inp_parm()
{
	if(rep_date.arr[0]!='\0')
	{
      init_date_temp_var();                              //pradeep

	  strcpy(date_convert.arr,rep_date.arr);            // pradeep
 
	  fun_change_loc_date();                            //pradeep  
 
	} 
	fprintf(f1,"%c&l1O",ESC);   /* To Print Landscape           */
	fprintf(f1,"%c(s14H",ESC); 	/* To set the font size			*/
	fprintf(f1,"%c&a7L",ESC); 	/* To Set the Left margin  		*/
	fprintf(f1,"\n");
 //   fprintf(f1,"%-5.6s : %s                                       %30s                                       %s\n",loc_legend[46],loc_legend[17],comp_name.arr,date_convert.arr);
       fprintf(f1,"%-5.6s : %s                                       %30s                            %11s : %s\n",loc_legend[46],loc_legend[17],comp_name.arr,loc_legend[01],date_convert.arr);

//disp_message(ERR_MESG,rep_date.arr);	
    if(report_date.arr[0]!='\0')
	  {
	   init_date_temp_var();                              //pradeep

	   strcpy(date_convert.arr,report_date.arr);            // pradeep
 
	   fun_change_loc_date();           

		}
    fprintf(f1,"%-5.6s : %s\n",loc_legend[47],oper_id.arr);
    //fprintf(f1,"%-5.6s : %s                         %s (%10s)                                %s : %4d\n",loc_legend[48],loc_legend[4],loc_legend[5],date_convert.arr,loc_legend[3],page_no);
	fprintf(f1,"%-5.6s : %s                         %s (%10s)                          %s : %-4d\n",loc_legend[48],loc_legend[4],loc_legend[5],date_convert.arr,loc_legend[3],page_no);
	
    fprintf(f1,"------------------------------------------------------------------------------------------------------------------------------------\n\n");
    fprintf(f1,"%-5.5s : 4.1\n",loc_legend[57]);
    fprintf(f1,"\n\n\n\n");
    fprintf(f1,"\t%18s\n",loc_legend[49]);
    fprintf(f1,"\t-----------------------------\n\n");
		if(report_date.arr[0]!='\0')
		{
	      init_date_temp_var();
          strcpy(date_convert.arr,report_date.arr);        

	      fun_change_loc_date();            

		}	
        fprintf(f1,"\t\t%20.20s                : %s\n\n",loc_legend[1],date_convert.arr);
		
	if(cash_counter_fm.arr[0] == '\0')
	   	fprintf(f1,"\t\t %20.20s    %10.10s : %-10.10s\n\n",loc_legend[9],loc_legend[6],loc_legend[53]);
	else
		fprintf(f1,"\t\t %20.20s    %10.10s : %s\n",loc_legend[9],loc_legend[6],cash_counter_fm.arr);  
    if(cash_counter_to.arr[0] =='\0')
		fprintf(f1,"\t\t\t       %20.20s : %-10.10s \n\n",loc_legend[7],loc_legend[52]);
	else   
		fprintf(f1,"\t\t\t       %20.20s : %s\n\n",loc_legend[7],cash_counter_to.arr); 
    if(shift_no_fm.arr[0] == '\0')
	   	fprintf(f1,"\t\t %20.20s    %10.10s : %-10.10s \n",loc_legend[10],loc_legend[6],loc_legend[53]);
	else
		fprintf(f1,"\t\t %20.20s    %10.10s : %s\n",loc_legend[10],loc_legend[6],shift_no_fm.arr);  
    if(shift_no_to.arr[0] =='\0')
		fprintf(f1,"\t\t\t       %20.20s : %-10.10s \n\n",loc_legend[7],loc_legend[52]);
	else
		fprintf(f1,"\t\t\t       %20.20s : %s\n\n",loc_legend[7],shift_no_to.arr); 
	if(receipt_nature_fm.arr[0] == '\0')
	   	fprintf(f1,"\t\t  %20.20s  %10.10s : %-10.10s \n",loc_legend[11],loc_legend[6],loc_legend[53]);
	else
		fprintf(f1,"\t\t  %20.20s  %10.10s : %s\n",loc_legend[11],loc_legend[6],receipt_nature_fm.arr);  
    if(receipt_nature_to.arr[0] =='\0')
		fprintf(f1,"\t\t\t      %20.20s : %-10.10s \n\n",loc_legend[7],loc_legend[52]);
	else
		fprintf(f1,"\t\t\t      %20.20s : %s\n\n",loc_legend[7],receipt_nature_to.arr); 
	
	 if(receipt_type_fm.arr[0] == '\0')
	   	fprintf(f1,"\t\t %20.20s    %10.10s : %-10.10s \n",loc_legend[12],loc_legend[6],loc_legend[53]);
	else
		fprintf(f1,"\t\t %20.20s    %10.10s : %s\n",loc_legend[12],loc_legend[6],receipt_type_fm.arr);  
    if(receipt_type_to.arr[0] =='\0')
		fprintf(f1,"\t\t\t       %20.20s : %-10.10s\n\n",loc_legend[7],loc_legend[52]);
	else
		fprintf(f1,"\t\t\t 	     %20.20 : %s\n\n",loc_legend[7],receipt_type_to.arr); 
     if(slmt_type_fm.arr[0] == '\0')
	   	fprintf(f1,"\t\t    %20.20s %10.10s : %-10.10s \n",loc_legend[13],loc_legend[6],loc_legend[53]);
	else
		fprintf(f1,"\t\t    %20.20s %10.10s : %s\n",loc_legend[13],loc_legend[6],slmt_type_fm.arr);  
    if(slmt_type_to.arr[0] =='\0')
		fprintf(f1,"\t\t\t       %20.20s : %-10.10s\n\n",loc_legend[7],loc_legend[52]);
	else
		fprintf(f1,"\t\t\t       %20.20s : %s\n\n",loc_legend[7],slmt_type_to.arr);
     if(blng_grp_fm.arr[0] == '\0')
		fprintf(f1,"\t\t  %20.20s   %10.10s : %-10.10s\n",loc_legend[14],loc_legend[6],loc_legend[53]);
    else
		fprintf(f1,"\t\t  %20.20s   %10.10s : %s\n",loc_legend[14],loc_legend[6],blng_grp_fm.arr);

	if(blng_grp_to.arr[0] == '\0')
		fprintf(f1,"\t\t\t       %20.20s : %-10.10s\n\n",loc_legend[7],loc_legend[52]);
	else
		fprintf(f1,"\t\t\t       %20.20s : %s\n\n",loc_legend[7],blng_grp_to.arr);

      //fprintf(f1,"\t\tCASH COUNTER        FROM : %s\n",cash_counter_fm.arr);
      //fprintf(f1,"\t\t                      TO : %s\n\n",cash_counter_to.arr);
      //fprintf(f1,"\t\tSHIFT NUMBER        FROM : %s\n",shift_no_fm.arr);
      //fprintf(f1,"\t\t                    TO   : %s\n\n",shift_no_to.arr);
      //fprintf(f1,"\t\tRECEIPT NATURE      FROM : %s\n",receipt_nature_fm.arr);
      //fprintf(f1,"\t\t                      TO : %s\n\n",receipt_nature_to.arr); 
      //fprintf(f1,"\t\tRECEIPT TYPE        FROM : %s\n",receipt_type_fm.arr);
     //fprintf(f1,"\t\t                      TO : %s\n\n",receipt_type_to.arr);
     //fprintf(f1,"\t\tSETTLEMENT TYPE       FROM : %s\n",slmt_type_fm.arr);
     //fprintf(f1,"\t\t                        TO : %s\n\n",slmt_type_to.arr);
     //fprintf(f1,"\t\tBILLING GROUP         FROM : %s\n",slmt_type_fm.arr);
     //fprintf(f1,"\t\t                        TO : %s\n\n",slmt_type_to.arr);
    fprintf(f1,"\t\t     %23.20s        : %s\n\n",loc_legend[15],cancelled_docs.arr);
    fprintf(f1,"\t\t     %25.25s      : %s\n\n",loc_legend[16],print_flag.arr);
    fprintf(f1,"\t\t                             (%-15.15s, %-15.15s, %-10.10s)\n",loc_legend[54],loc_legend[55],loc_legend[56]);
    fprintf(f1,"");
    ++page_no;

}


print_end_of_rep()
{
 
    //fprintf(f1,"\n\n                                                    ** %15s **                                                             \n",loc_legend[50]); saikiran
	  fprintf(f1,"\n\n                                                    **%-10s**                                                             \n",loc_legend[50]); //by saikiran for 17459 on 4/01/2010

}

init_prv_values()
{

    d_prv_cash_counter_code.arr[0]     = '\0';
    d_prv_shift_id.arr[0]              = '\0';
    d_prv_recpt_refund_ind.arr[0]      = '\0';
    d_prv_debtor_category_code.arr[0]  = '\0';
	d_prv_blng_grp_id.arr[0]           = '\0';

    d_prv_cash_counter_code.len     = 0;
    d_prv_shift_id.len              = 0;
    d_prv_recpt_refund_ind.len      = 0;
    d_prv_debtor_category_code.len  = 0;
    d_prv_blng_grp_id.len           = 0;
}

change()
{
	if(strcmp(d_prv_cash_counter_code.arr,    d_cash_counter_code.arr))
	return 5;

    if(strcmp(d_prv_shift_id.arr,             d_shift_id.arr))
	return 4;

    if(strcmp(d_prv_recpt_refund_ind.arr,     d_recpt_refund_ind.arr))
	return 3;

	if(strcmp(d_prv_blng_grp_id.arr, d_blng_grp_id.arr))
	return 2;

    if(strcmp(d_prv_debtor_category_code.arr, d_debtor_category_code.arr))
	return 1;
    
    return 0;

/*
    if(!strcmp(d_prv_cash_counter_code.arr,    d_cash_counter_code.arr)&&
       !strcmp(d_prv_shift_id.arr,             d_shift_id.arr)         &&
       !strcmp(d_prv_recpt_refund_ind.arr,     d_recpt_refund_ind.arr) &&
       !strcmp(d_prv_debtor_category_code.arr, d_debtor_category_code.arr))

	   return 0;
    else
	   return 1;
*/

}

copy_val()
{

    strcpy(d_prv_cash_counter_code.arr,    d_cash_counter_code.arr);
    strcpy(d_prv_shift_id.arr,             d_shift_id.arr);
    strcpy(d_prv_recpt_refund_ind.arr,     d_recpt_refund_ind.arr);
    strcpy(d_prv_debtor_category_code.arr, d_debtor_category_code.arr);
    strcpy(d_prv_debtor_category_desc.arr, d_debtor_category_desc.arr);
	strcpy(d_prv_blng_grp_id.arr,          d_blng_grp_id.arr);


    d_prv_cash_counter_code.len     =   strlen(d_cash_counter_code.arr);
    d_prv_shift_id.len              =   strlen(d_shift_id.arr);
    d_prv_recpt_refund_ind.len      =   strlen(d_recpt_refund_ind.arr);
    d_prv_debtor_category_code.len  =   strlen(d_debtor_category_code.arr);
    d_prv_blng_grp_id.len           =   strlen(d_blng_grp_id.arr);
}

/*
print_formated(loc_amount)
double loc_amount;
{
 char s_amt[20];
 sprintf(s_amt,"%15.2f",loc_amount);
 format_amt(s_amt);
 fprintf(f1,"%18s \n",s_amt); 
}                                
 */
print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);
        //ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt,"-");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(f1,"%-14sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);
          //      ltrim(s_amt);
        format_amt(s_amt);
        //strcat(s_amt," ");
      sprintf(str_amt,"%14s",s_amt);
        fprintf(f1,"%-14s ",str_amt);
        }
}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRCASDL.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 35;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRCASDL.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )910;
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
  sqlstm.arrsiz = 35;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )933;
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
	
	  
    //   	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
	   
	   :nd_loc_date :=  	sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id);  

	  // :nd_loc_date := to_char(to_date(:nd_loc_date,'DD/MM/YYYY'),'DD/MM/YYYY');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 35;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )964;
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

//----------------------------------------------------
get_local_date1()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date1  date;
	
	BEGIN
	
	  
      // 	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date1,'DD/MM/RRRR'),:p_language_id,t_date1);  
      
	   :nd_loc_date1 :=  	sm_convert_date_2t(to_date(:nd_temp_date1,'DD/MM/RRRR'),:p_language_id);  

	  // :nd_loc_date := to_char(to_date(:nd_loc_date,'DD/MM/RRRR'),'DD/MM/RRRR');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 35;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date1 date ; BEGIN :nd_loc_date1 := sm_convert_dat\
e_2t ( to_date ( :nd_temp_date1 , 'DD/MM/RRRR' ) , :p_language_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )991;
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

  // HH24:MI                   
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
//--------------------------------------------------------------------------