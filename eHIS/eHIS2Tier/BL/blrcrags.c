
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
           char  filnam[22];
};
static const struct sqlcxp sqlfpn =
{
    21,
    "C:\\10xdev\\Blrcrags.pc"
};


static unsigned long sqlctx = 139598019;


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
            void  *sqhstv[13];
   unsigned int   sqhstl[13];
            int   sqhsts[13];
            void  *sqindv[13];
            int   sqinds[13];
   unsigned int   sqharm[13];
   unsigned int   *sqharc[13];
   unsigned short  sqadto[13];
   unsigned short  sqtdso[13];
} sqlstm = {10,13};

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
"select distinct C.SPONSOR_ID  from MP_PATIENT_MAST A ,MP_PAT_OTHER_DTLS B ,B\
L_CREDIT_AGREEMENT C where (((A.PATIENT_ID=B.PATIENT_ID and A.PATIENT_ID=C.PAT\
IENT_ID) and C.PATIENT_ID=:b0) and nvl(C.sponsor_id,'~~~~~~~~')=nvl(nvl(:b1,C.\
sponsor_id),'~~~~~~~~'))           ";

 static const char *sq0007 = 
"select DECODE(:b0,'en',SHORT_NAME,SHORT_NAME_LOC_LANG) ,LN1_RES_ADD ,LN2_RES\
_ADD ,LN3_RES_ADD ,LN4_RES_ADD ,CONTACT_TEL_NUM  from MP_PATIENT_MAST A ,MP_PA\
T_OTHER_DTLS B where (A.PATIENT_ID=B.PATIENT_ID and A.PATIENT_ID=:b1)         \
  ";

 static const char *sq0009 = 
"select distinct A.AGGR_DOC_TYPE_CODE ,A.AGGR_DOC_NUM ,to_char(A.AGGR_DOC_DAT\
E,'dd/mm/yyyy')  from BL_INST_PMNT_PLAN A ,bl_credit_agreement B where ((((((a\
.patient_id=b.patient_id and A.patient_id=:b0) and A.AGGR_DOC_TYPE_CODE=B.AGGR\
_DOC_TYPE_CODE) and A.AGGR_DOC_NUM=B.AGGR_DOC_NUM) and A.INST_PMNT_AMT>nvl(A.T\
OT_INST_PAID_AMT,0)) and A.INST_DUE_DATE<=TO_DATE(:b1,'dd/mm/yyyy')) and nvl(B\
.sponsor_id,'!#')=nvl(nvl(:b2,B.sponsor_id),'!#')) order by 1,2            ";

 static const char *sq0010 = 
"select A.PATIENT_ID ,B.DOC_TYPE_CODE ,B.DOC_NUM ,to_char(B.doc_date) ,B.BILL\
_TOT_OUTST_AMT  from BL_CREDIT_AGREEMENT A ,BL_BILL_DCP_DTL_VW B ,BL_BILLS_FOR\
_INST_PMNT C where ((((((A.AGGR_DOC_TYPE_CODE=C.AGGR_DOC_TYPE_CODE and A.AGGR_\
DOC_NUM=C.AGGR_DOC_NUM) and C.BILL_DOC_TYPE_CODE=B.DOC_TYPE_CODE) and C.BILL_D\
OC_NUM=B.DOC_NUM) and A.AGGR_DOC_TYPE_CODE=:b0) and A.AGGR_DOC_NUM=:b1) and B.\
BILL_TOT_OUTST_AMT>0)           ";

 static const char *sq0011 = 
"select A.AGGR_DOC_TYPE_CODE ,A.AGGR_DOC_NUM ,to_char(A.AGGR_DOC_DATE,'dd/mm/\
yyyy') ,to_char(INST_DUE_DATE,'dd/mm/yyyy') ,AGGR_INST_NO ,INST_PMNT_AMT ,(nvl\
(A.INST_PMNT_AMT,0)-nvl(A.TOT_INST_PAID_AMT,0)) REMAINING_AMOUNT ,A.TOT_INST_P\
AID_AMT  from BL_INST_PMNT_PLAN A ,bl_credit_agreement B where (((((((a.patien\
t_id=b.patient_id(+) and A.patient_id=:b0) and A.AGGR_DOC_TYPE_CODE=B.AGGR_DOC\
_TYPE_CODE) and A.AGGR_DOC_NUM=B.AGGR_DOC_NUM) and A.INST_DUE_DATE<TO_DATE(:b1\
,'dd/mm/yyyy')) and nvl(B.sponsor_id,'!#')=nvl(nvl(:b2,B.sponsor_id),'!#')) an\
d A.AGGR_DOC_TYPE_CODE=:b3) and A.AGGR_DOC_NUM=:b4) order by 1,2,5            ";

 static const char *sq0012 = 
"select count(*)   from BL_DCP_PENDING_DOC where (((operating_facility_id=:b0\
 and PATIENT_ID=:b1) and ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NUMBER=:b3)       \
    ";

 static const char *sq0013 = 
"select sum(DOC_AMT)  from BL_DCP_TRN where (((operating_facility_id=:b0 and \
PATIENT_ID=:b1) and ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NUMBER=:b3)           ";

 static const char *sq0014 = 
"select sum(DOC_AMT)  from BL_DCP_TRN where ((((operating_facility_id=:b0 and\
 PATIENT_ID=:b1) and ORG_DOC_TYPE_CODE=:b2) and ORG_DOC_NUMBER=:b3) and TRX_TY\
PE_CODE<>'1')           ";

 static const char *sq0015 = 
"select TRUNC(A.DOC_DATE) ,(CEIL(MONTHS_BETWEEN(TO_DATE(:b0,'DD/MM/YYYY'),(B.\
INST_START_DATE-1)))* B.INST_AMT_MONTHLY)  from BL_DCP_TRN A ,BL_CREDIT_AGREEM\
ENT B ,BL_BILLS_FOR_INST_PMNT C where ((((((((((((a.operating_facility_id=b.op\
erating_facility_id and B.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID) and A\
.PATIENT_ID=B.PATIENT_ID) and B.PATIENT_ID=C.PATIENT_ID) and A.ORG_DOC_TYPE_CO\
DE=C.BILL_DOC_TYPE_CODE) and A.ORG_DOC_NUMBER=C.BILL_DOC_NUM) and TRUNC(A.DOC_\
DATE)<=TO_DATE(:b0,'DD/MM/YYYY')) and b.operating_facility_id=:b2) and B.PATIE\
NT_ID=:b3) and B.SPONSOR_ID=NVL(:b4,B.SPONSOR_ID)) and A.TRX_TYPE_CODE='1') an\
d A.ORG_DOC_TYPE_CODE=:b5) and A.ORG_DOC_NUMBER=:b6) order by TRUNC(A.DOC_DATE\
),A.ORG_DOC_TYPE_CODE,A.ORG_DOC_NUMBER            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,181,0,4,150,0,0,8,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,1,9,0,0,1,9,0,0,
52,0,0,2,280,0,4,203,0,0,13,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
119,0,0,3,99,0,4,212,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
142,0,0,4,91,0,2,251,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
165,0,0,5,0,0,30,260,0,0,0,0,0,1,0,
180,0,0,6,267,0,9,502,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
203,0,0,6,0,0,13,528,0,0,1,0,0,1,0,2,9,0,0,
222,0,0,7,234,0,9,550,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
245,0,0,7,0,0,13,555,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,
284,0,0,6,0,0,15,592,0,0,0,0,0,1,0,
299,0,0,9,463,0,9,603,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
326,0,0,9,0,0,13,618,0,0,3,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,
353,0,0,9,0,0,15,643,0,0,0,0,0,1,0,
368,0,0,10,420,0,9,657,0,0,2,2,0,1,0,1,9,0,0,1,3,0,0,
391,0,0,10,0,0,13,671,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,4,0,0,
426,0,0,10,0,0,15,699,0,0,0,0,0,1,0,
441,0,0,11,622,0,9,711,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
476,0,0,11,0,0,13,731,0,0,8,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,
4,0,0,2,4,0,0,2,4,0,0,
523,0,0,11,0,0,15,763,0,0,0,0,0,1,0,
538,0,0,16,106,0,4,863,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
565,0,0,12,158,0,9,957,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
596,0,0,12,0,0,13,962,0,0,1,0,0,1,0,2,3,0,0,
615,0,0,13,153,0,9,976,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
646,0,0,14,178,0,9,981,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
677,0,0,15,750,0,9,986,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,3,0,0,
720,0,0,13,0,0,13,1014,0,0,1,0,0,1,0,2,4,0,0,
739,0,0,14,0,0,13,1037,0,0,1,0,0,1,0,2,4,0,0,
758,0,0,15,0,0,13,1064,0,0,2,0,0,1,0,2,9,0,0,2,4,0,0,
781,0,0,17,0,0,27,1227,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
812,0,0,18,96,0,4,1284,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
835,0,0,19,162,0,6,1291,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
866,0,0,20,197,0,6,1311,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
893,0,0,21,193,0,6,1333,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
920,0,0,22,196,0,6,1356,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/*  Date :- 24-MAR-98  */ 

#include <stdio.h>
#include <string.h>         
#include <bl.h>

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define ESC 0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 
 

   /* VARCHAR uid_pwd                    [132],
           hosp_name                  [61],
		   nd_facility_id		      [3],
		   h_practice_num			  [31],
		    h_ln1_add				  [31],
			h_ln2_add				  [31],
			h_ln3_add				  [31],
			h_zip_code				  [31],
			h_tel_num				  [31],
			h_fax_num			      [31],
		   h_email_id				  [31],
           nd_date                    [11],
           user_id                    [30],
           nd_pgm_date                [35],
           nd_session_id              [16],
           nd_sponsor_id              [21],
           fr_sponsor_id              [21],
           to_sponsor_id              [21],
		   nd_cutoff_date             [11],
		   nd_cutoff_date1            [11],
		   nd_sponsor_name            [31],
		   nd_sponsor_address1        [31],
		   nd_sponsor_address2        [31],
		   nd_sponsor_address3        [31],
		   nd_sponsor_address4        [31],
           nd_sponsor_tel_num         [19],
		   nd_patient_id              [21],
		   fr_patient_id              [21],
		   to_patient_id              [21],
           nd_patient_name            [61],
		   nd_bill_doc_type_code      [9],
		   nd_doc_type_code			  [9],
		   nd_AGGR_DOC_TYPE_CODE	  [9],
		   nd_bill_doc_date           [11],
		   nd_AGGR_DOC_DATE			  [11],
		   nd_INST_DUE_DATE			  [11],
		   nd_bill_doc_date1          [11],
		   nd_temp_date1				  [11],
		   nd_lang_id				  [4]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[61]; } hosp_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[31]; } h_practice_num;

struct { unsigned short len; unsigned char arr[31]; } h_ln1_add;

struct { unsigned short len; unsigned char arr[31]; } h_ln2_add;

struct { unsigned short len; unsigned char arr[31]; } h_ln3_add;

struct { unsigned short len; unsigned char arr[31]; } h_zip_code;

struct { unsigned short len; unsigned char arr[31]; } h_tel_num;

struct { unsigned short len; unsigned char arr[31]; } h_fax_num;

struct { unsigned short len; unsigned char arr[31]; } h_email_id;

struct { unsigned short len; unsigned char arr[11]; } nd_date;

struct { unsigned short len; unsigned char arr[30]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[21]; } nd_sponsor_id;

struct { unsigned short len; unsigned char arr[21]; } fr_sponsor_id;

struct { unsigned short len; unsigned char arr[21]; } to_sponsor_id;

struct { unsigned short len; unsigned char arr[11]; } nd_cutoff_date;

struct { unsigned short len; unsigned char arr[11]; } nd_cutoff_date1;

struct { unsigned short len; unsigned char arr[31]; } nd_sponsor_name;

struct { unsigned short len; unsigned char arr[31]; } nd_sponsor_address1;

struct { unsigned short len; unsigned char arr[31]; } nd_sponsor_address2;

struct { unsigned short len; unsigned char arr[31]; } nd_sponsor_address3;

struct { unsigned short len; unsigned char arr[31]; } nd_sponsor_address4;

struct { unsigned short len; unsigned char arr[19]; } nd_sponsor_tel_num;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[21]; } fr_patient_id;

struct { unsigned short len; unsigned char arr[21]; } to_patient_id;

struct { unsigned short len; unsigned char arr[61]; } nd_patient_name;

struct { unsigned short len; unsigned char arr[9]; } nd_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_AGGR_DOC_TYPE_CODE;

struct { unsigned short len; unsigned char arr[11]; } nd_bill_doc_date;

struct { unsigned short len; unsigned char arr[11]; } nd_AGGR_DOC_DATE;

struct { unsigned short len; unsigned char arr[11]; } nd_INST_DUE_DATE;

struct { unsigned short len; unsigned char arr[11]; } nd_bill_doc_date1;

struct { unsigned short len; unsigned char arr[11]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;


   /* VARCHAR  l_pk_value		         [100],
		    l_translated_value	     [201],
			nd_temp_date			 [20],
		    nd_loc_date				 [20],
		    date_convert			 [20]; */ 
struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[20]; } date_convert;


	char loc_legend[999][201];


   int     nd_bill_doc_num,
 		   nd_doc_num, 
		   nd_AGGR_DOC_NUM,
		   nd_AGGR_INST_NO,
		   nd_hosp_name_len,
		   cnt,
		   bl,
		   amt,i;

   double  nd_bill_outst_amt,
			nd_INST_PMNT_AMT,
			nd_TOT_INST_PAID_AMT,
			nd_inst_amt_due,
			nd_tot_inst_amt_due,
           nd_dcp_outst_amt,
		   nd_total_bill_outst_amt,
		   nd_total_dcp_outst_amt,
		   nd_total_inst_amt_due,
		   nd_document_amount,
		   nd_paid_amt,
		   nd_instalment_amount;

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
char string_var[100];
char filename[150];

FILE *f1;
int lctr = 0,pctr =1;
int first_time,
    count=0;//by saikiran for 18154 on 19/1/2010

void proc_main(argc,argv)
char *argv[];
int argc;
{
   if (argc != 5)
   {
      disp_message(ERR_MESG, "Not enough Parameters for running this program\n");
      proc_exit(0);
   }

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_session_id,argv[2]);

   strcpy(g_pgm_id,"BLRCRAGS");

   if(sql_connect(uid_pwd.arr) == -1)
   {
      disp_message(ORA_MESG, "Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
         disp_message(ORA_MESG, "Null oracle uid/pwd\n\n\n");
      proc_exit(0);
   }

   set_meduser_role(); 
   strcpy(nd_lang_id.arr,l_language_id.arr);
   nd_lang_id.len = l_language_id.len;
   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   nd_facility_id.arr[0]  = '\0';
   fr_patient_id.arr[0]            = '\0';
   to_patient_id.arr[0]            = '\0';
   fr_sponsor_id.arr[0]            = '\0';
   to_sponsor_id.arr[0]            = '\0';
   nd_cutoff_date.arr[0]           = '\0';

   nd_facility_id.len  = 0;
   fr_patient_id.len               = 0;
   to_patient_id.len               = 0;
   fr_sponsor_id.len               = 0;
   to_sponsor_id.len               = 0;
   nd_cutoff_date.len              = 0;

   /* EXEC SQL SELECT operating_facility_id,PARAM1, PARAM2, PARAM3, PARAM4, PARAM5
              INTO :nd_facility_id,:fr_patient_id, :to_patient_id,
			       :fr_sponsor_id, :to_sponsor_id,
                   :nd_cutoff_date
              FROM SY_PROG_PARAM
             WHERE PGM_ID     = 'BLRCRAGS'
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 8;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select operating_facility_id ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 into :b0,:b1,:b2,:b3,:b4,:b5  from SY_PROG_PARAM where ((PGM_ID='BL\
RCRAGS' and SESSION_ID=:b6) and PGM_DATE=:b7)";
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
   sqlstm.sqhstv[1] = (         void  *)&fr_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&to_patient_id;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&fr_sponsor_id;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&to_sponsor_id;
   sqlstm.sqhstl[4] = (unsigned int  )23;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_cutoff_date;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[6] = (unsigned int  )18;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[7] = (unsigned int  )37;
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



   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

	nd_facility_id.arr[nd_facility_id.len] = '\0';
   fr_patient_id.arr[fr_patient_id.len]   = '\0';
   to_patient_id.arr[to_patient_id.len]   = '\0';
   fr_sponsor_id.arr[fr_sponsor_id.len]   = '\0';
   to_sponsor_id.arr[to_sponsor_id.len]   = '\0';
   nd_cutoff_date.arr[nd_cutoff_date.len] = '\0';


   strcpy(g_facility_id,nd_facility_id.arr);
   fetch_legend_value();
   start_prog_msg();

   hosp_name.arr[0]      = '\0';
   nd_date.arr[0]        = '\0';
   user_id.arr[0]        = '\0';

   hosp_name.len      = 0;
   nd_date.len        = 0;
   user_id.len        = 0;
	 h_practice_num.len    = 0;
	 h_ln1_add.len		   = 0;
	 h_ln2_add.len		   = 0;
	 h_ln3_add.len		   = 0;
	 h_zip_code.len		   = 0;
	 h_tel_num.len		   = 0;
	 h_fax_num.len		   = 0;
      h_email_id.len	   = 0;

	 h_practice_num.arr [ h_practice_num.len ]		   = '\0';
	 h_ln1_add.arr [ h_ln1_add.len ]		   = '\0';
	 h_ln2_add.arr [ h_ln2_add.len ]		   = '\0';
	 h_ln3_add.arr [ h_ln3_add.len ]		   = '\0';
	 h_zip_code.arr [ h_zip_code.len ]		   = '\0';
	 h_tel_num.arr [ h_tel_num.len ]				   = '\0';
	 h_fax_num.arr [ h_fax_num.len ]				   = '\0';
	 h_email_id.arr [ h_email_id.len ]		   = '\0';


   /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY'), USER, PRACTICE_NUM, LN1_ADD, LN2_ADD, LN3_ADD,
					 TEL_NUM, FAX_NUM, ZIP_CODE, ACC_ENTITY_NAME_LOC_LANG  
              INTO :hosp_name, :nd_date, :user_id, :h_practice_num, :h_ln1_add, :h_ln2_add, :h_ln3_add,
				:h_tel_num, :h_fax_num, :h_zip_code, :h_email_id 
              FROM SY_ACC_ENTITY_LANG_VW
			  WHERE acc_entity_id = :nd_facility_id
 			   AND LANGUAGE_ID = :nd_lang_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,USE\
R ,PRACTICE_NUM ,LN1_ADD ,LN2_ADD ,LN3_ADD ,TEL_NUM ,FAX_NUM ,ZIP_CODE ,ACC_EN\
TITY_NAME_LOC_LANG into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10  from SY_\
ACC_ENTITY_LANG_VW where (acc_entity_id=:b11 and LANGUAGE_ID=:b12)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )52;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&hosp_name;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_date;
   sqlstm.sqhstl[1] = (unsigned int  )13;
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
   sqlstm.sqhstv[3] = (         void  *)&h_practice_num;
   sqlstm.sqhstl[3] = (unsigned int  )33;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&h_ln1_add;
   sqlstm.sqhstl[4] = (unsigned int  )33;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&h_ln2_add;
   sqlstm.sqhstl[5] = (unsigned int  )33;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&h_ln3_add;
   sqlstm.sqhstl[6] = (unsigned int  )33;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&h_tel_num;
   sqlstm.sqhstl[7] = (unsigned int  )33;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&h_fax_num;
   sqlstm.sqhstl[8] = (unsigned int  )33;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&h_zip_code;
   sqlstm.sqhstl[9] = (unsigned int  )33;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&h_email_id;
   sqlstm.sqhstl[10] = (unsigned int  )33;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[11] = (unsigned int  )5;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[12] = (unsigned int  )6;
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




   /* EXEC SQL SELECT round((31-length(ACC_ENTITY_NAME))/2) INTO :nd_hosp_name_len FROM SY_ACC_ENTITY
   			  WHERE acc_entity_id = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select round(((31-length(ACC_ENTITY_NAME))/2)) into :b0  f\
rom SY_ACC_ENTITY where acc_entity_id=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )119;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_hosp_name_len;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
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

;

   if (OERROR)
         err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");
 
     hosp_name.arr[hosp_name.len]               = '\0';
     nd_date.arr[nd_date.len]                   = '\0';
     user_id.arr[user_id.len]                   = '\0';
   	 h_practice_num.arr [ h_practice_num.len ]	= '\0';
	 h_ln1_add.arr [ h_ln1_add.len ]		    = '\0';
	 h_ln2_add.arr [ h_ln2_add.len ]		    = '\0';
	 h_ln3_add.arr [ h_ln3_add.len ]		    = '\0';
     h_tel_num.arr [ h_tel_num.len ]			= '\0';
	 h_fax_num.arr [ h_fax_num.len ]			= '\0';
	 h_zip_code.arr [ h_zip_code.len ]		    = '\0';
     h_email_id.arr[h_email_id.len]	            = '\0';

	 init_date_temp_var();
	 strcpy(date_convert.arr,nd_date.arr);
     fun_change_loc_date();
     strcpy(nd_date.arr,date_convert.arr);


   open_files();
   
   declare_sponsor_cur();
   declare_cursors();

   nd_bill_outst_amt = 0;
   nd_inst_amt_due = 0;
   nd_total_bill_outst_amt = 0;
   nd_total_inst_amt_due = 0;
   nd_paid_amt = 0;
   nd_document_amount = 0;

  fetch_sponsor_cur();
  

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
                  WHERE PGM_ID     = 'BLRCRAGS'
                    AND SESSION_ID = :nd_session_id
                    AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRCRAGS' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )142;
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
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )165;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   fclose(f1);
   return;
}

open_files()
{
   strcpy(filename, WORKING_DIR);
   strcat(filename, "blrcrags.lis"); 

   if ((f1 = fopen(filename,"w")) == NULL)
   {
        err_mesg("\nError while opening File blrcrags.lis\n",0,"");
        proc_exit();
   }
}

declare_sponsor_cur()
{
      /*     to select the sponsor details     */
	  
   /* EXEC SQL DECLARE BL_CR_AGR_SPONSOR_CUR CURSOR FOR
             SELECT DISTINCT C.SPONSOR_ID
	       FROM MP_PATIENT_MAST A, 
	            MP_PAT_OTHER_DTLS B, 
		    BL_CREDIT_AGREEMENT C
              WHERE A.PATIENT_ID = B.PATIENT_ID
	        AND A.PATIENT_ID = C.PATIENT_ID
			AND	C.PATIENT_ID=:fr_patient_id
			AND nvl(C.sponsor_id,'~~~~~~~~')=nvl(nvl(:fr_sponsor_id,C.sponsor_id),'~~~~~~~~'); */ 

		


              /*  AND C.PATIENT_ID BETWEEN
			 NVL(:fr_patient_id, '!!!!!!!!') AND 
			 NVL(:fr_patient_id, '~~~~~~~~')
	        AND C.SPONSOR_ID BETWEEN
 			 NVL(:fr_sponsor_id, '!!!!!!!!') AND 
			 NVL(:to_sponsor_id, '~~~~~~~~')
	   ORDER BY C.SPONSOR_ID;*/

   if (OERROR)
         err_mesg("SELECT failed on cursor BL_CR_AGR_SPONSOR_CUR",0,"");


	/*EXEC SQL OPEN BL_CR_AGR_SPONSOR_CUR;

  if (OERROR)
	err_mesg("OPEN failed on cursor BL_CR_AGR_SPONSOR_CUR",0,"");*/

  }

declare_cursors()
{

   /* EXEC SQL DECLARE BL_SPONSOR_NAME CURSOR FOR
             SELECT DECODE(:nd_lang_id,'en',SHORT_NAME,SHORT_NAME_LOC_LANG), 
                    LN1_RES_ADD, 
				    LN2_RES_ADD,
					LN3_RES_ADD, 
					LN4_RES_ADD, 
					CONTACT_TEL_NUM
	          FROM MP_PATIENT_MAST A, 
	            MP_PAT_OTHER_DTLS B
              WHERE A.PATIENT_ID = B.PATIENT_ID
                AND A.PATIENT_ID = :nd_sponsor_id; */ 


      /*     to select the credit agreement details     */

  /* EXEC SQL DECLARE BL_CREDIT_AGREEMENT_CUR CURSOR FOR
            SELECT A.PATIENT_ID,
		   B.BILL_DOC_TYPE_CODE,
		   B.BILL_DOC_NUM
              FROM BL_CREDIT_AGREEMENT A,BL_BILLS_FOR_INST_PMNT B
             WHERE 
			 A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID
			AND B.operating_facility_id = :nd_facility_id 
			AND A.PATIENT_ID=B.PATIENT_ID
			AND B.AGGR_DOC_TYPE_CODE = A.AGGR_DOC_TYPE_CODE
			AND B.AGGR_DOC_NUM =A.AGGR_DOC_NUM 
			AND A.PATIENT_ID BETWEEN
	                 NVL(:fr_patient_id, '!!!!!!!!') AND 
			 NVL(:fr_patient_id, '~~~~~~~~')
	       AND A.SPONSOR_ID  = NVL(:nd_sponsor_id,A.SPONSOR_ID)
	      // AND A.STATUS = 'P'
	  ORDER BY B.PATIENT_ID; */ 


   if (OERROR)
         err_mesg("SELECT failed on cursor BL_CREDIT_AGREEMENT_CUR",0,"");

//added by Vani dated on 23/07/2008 regarding SPR-3659

		/* Main cursor to fetch agreement bills*/
/* EXEC SQL DECLARE BL_CREDIT_AGREEMENT_CUR1 CURSOR FOR
           SELECT Distinct A.AGGR_DOC_TYPE_CODE, A.AGGR_DOC_NUM,to_char(A.AGGR_DOC_DATE,'dd/mm/yyyy')
			FROM BL_INST_PMNT_PLAN A,bl_credit_agreement B 
			WHERE a.patient_id =b.patient_id
			AND A.patient_id=:fr_patient_id
			AND A.AGGR_DOC_TYPE_CODE=B.AGGR_DOC_TYPE_CODE
			AND A.AGGR_DOC_NUM = B.AGGR_DOC_NUM
			AND A.INST_PMNT_AMT>nvl(A.TOT_INST_PAID_AMT,0)
			AND A.INST_DUE_DATE<=TO_DATE(:nd_cutoff_date,'dd/mm/yyyy')
			AND nvl(B.sponsor_id,'!#')=nvl(nvl(:nd_sponsor_id,B.sponsor_id),'!#')
			order by 1,2; */ 

			

   if (OERROR)
         err_mesg("SELECT failed on cursor BL_CREDIT_AGREEMENT_CUR1",0,"");


		/* cursor to fetch outsating amount for agreement bill*/
/* EXEC SQL DECLARE BL_CR_AGREEMENT_CUR_BILL CURSOR FOR
		SELECT A.PATIENT_ID, B.DOC_TYPE_CODE, B.DOC_NUM,to_char(B.doc_date),B.BILL_TOT_OUTST_AMT
		FROM BL_CREDIT_AGREEMENT A,BL_BILL_DCP_DTL_VW B, BL_BILLS_FOR_INST_PMNT C
		WHERE 
		A.AGGR_DOC_TYPE_CODE = C.AGGR_DOC_TYPE_CODE
		AND	   A.AGGR_DOC_NUM =C.AGGR_DOC_NUM
		AND	   C.BILL_DOC_TYPE_CODE = B.DOC_TYPE_CODE
		AND	   C.BILL_DOC_NUM       = B.DOC_NUM
		and A.AGGR_DOC_TYPE_CODE =:nd_bill_doc_type_code
		and A.AGGR_DOC_NUM  =:nd_bill_doc_num
		AND B.BILL_TOT_OUTST_AMT>0; */ 


   if (OERROR)
         err_mesg("SELECT failed on cursor BL_CR_AGREEMENT_CUR_BILL",0,"");


			/* Cursor to fetch installment dues*/
/* EXEC SQL DECLARE BL_CR_AGREEMENT_INST_DTL CURSOR FOR
		SELECT  A.AGGR_DOC_TYPE_CODE, A.AGGR_DOC_NUM,to_char(A.AGGR_DOC_DATE,'dd/mm/yyyy'),
		to_char(INST_DUE_DATE,'dd/mm/yyyy'), AGGR_INST_NO,INST_PMNT_AMT, nvl(A.INST_PMNT_AMT,0)-nvl(A.TOT_INST_PAID_AMT,0) REMAINING_AMOUNT, A.TOT_INST_PAID_AMT
		FROM BL_INST_PMNT_PLAN A,bl_credit_agreement B 
		WHERE a.patient_id =b.patient_id(+)
		AND A.patient_id=:fr_patient_id
		AND A.AGGR_DOC_TYPE_CODE=B.AGGR_DOC_TYPE_CODE
		AND A.AGGR_DOC_NUM = B.AGGR_DOC_NUM
		/oAND A.INST_PMNT_AMT>nvl(A.TOT_INST_PAID_AMT,0)o/
		AND A.INST_DUE_DATE<TO_DATE(:nd_cutoff_date,'dd/mm/yyyy')
		AND nvl(B.sponsor_id,'!#')=nvl(nvl(:nd_sponsor_id,B.sponsor_id),'!#')
		and A.AGGR_DOC_TYPE_CODE =:nd_bill_doc_type_code
		and A.AGGR_DOC_NUM  =:nd_bill_doc_num
		order by 1,2,5; */ 

   if (OERROR)
         err_mesg("SELECT failed on cursor BL_CR_AGREEMENT_INST_DTL",0,"");





      /*     to select count of rec's from bl_dcp_pending_doc    */

  /* EXEC SQL DECLARE BL_DCP_PENDING_DOC_CUR CURSOR FOR
           SELECT COUNT(*)
		   FROM   BL_DCP_PENDING_DOC
		   WHERE  operating_facility_id = :nd_facility_id AND
		   PATIENT_ID		= :nd_patient_id
		   AND    ORG_DOC_TYPE_CODE = :nd_bill_doc_type_code
		   AND    ORG_DOC_NUMBER    = :nd_bill_doc_num; */ 


   if (OERROR)
         err_mesg("SELECT failed on cursor BL_DCP_PENDING_DOC_CUR",0,"");

/*     to select the sum of doc_amt from bl_dcp_trn, if count > 0    */

  /* EXEC SQL DECLARE BL_DOC_AMT_CUR CURSOR FOR
           SELECT SUM(DOC_AMT)
		   FROM   BL_DCP_TRN
		   WHERE  operating_facility_id = :nd_facility_id AND
		   PATIENT_ID        = :nd_patient_id
		   AND    ORG_DOC_TYPE_CODE = :nd_bill_doc_type_code
		   AND    ORG_DOC_NUMBER    = :nd_bill_doc_num; */ 


   if (OERROR)
         err_mesg("SELECT failed on cursor BL_DOC_AMT_CUR",0,"");

/*     to select the total amount paid from bl_dcp_trn, if count > 0 */

  /* EXEC SQL DECLARE BL_TOT_PAID_AMT_CUR CURSOR FOR
           SELECT SUM(DOC_AMT)
		   FROM   BL_DCP_TRN
		   WHERE  operating_facility_id = :nd_facility_id AND
		   PATIENT_ID        = :nd_patient_id
		   AND    ORG_DOC_TYPE_CODE = :nd_bill_doc_type_code
		   AND    ORG_DOC_NUMBER    = :nd_bill_doc_num
		   AND    TRX_TYPE_CODE		!= '1'; */ 


   if (OERROR)
         err_mesg("SELECT failed on cursor BL_DOC_AMT_CUR",0,"");

      /*     to select the details from bl_dcp_trn, if count > 0    */

  /* EXEC SQL DECLARE BL_DCP_TRN_CUR CURSOR FOR
            SELECT TRUNC(A.DOC_DATE),
		   CEIL(MONTHS_BETWEEN(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'), 
                         B.INST_START_DATE-1)) * B.INST_AMT_MONTHLY
 	     FROM BL_DCP_TRN A, BL_CREDIT_AGREEMENT B,BL_BILLS_FOR_INST_PMNT C
            WHERE a.operating_facility_id = b.operating_facility_id 
			AND B.OPERATING_FACILITY_ID=C.OPERATING_FACILITY_ID
			AND	A.PATIENT_ID         = B.PATIENT_ID
			AND B.PATIENT_ID=C.PATIENT_ID
		  AND A.ORG_DOC_TYPE_CODE  = C.BILL_DOC_TYPE_CODE
		  AND A.ORG_DOC_NUMBER     = C.BILL_DOC_NUM
		  AND TRUNC(A.DOC_DATE)   <= 
                                        TO_DATE(:nd_cutoff_date,'DD/MM/YYYY')
		  AND	b.operating_facility_id = :nd_facility_id 
		  AND B.PATIENT_ID        = :nd_patient_id
		  AND B.SPONSOR_ID        = NVL(:nd_sponsor_id,B.SPONSOR_ID)
		  AND A.TRX_TYPE_CODE     = '1'
		  AND A.ORG_DOC_TYPE_CODE = :nd_bill_doc_type_code
		  AND A.ORG_DOC_NUMBER    = :nd_bill_doc_num
	     ORDER BY TRUNC(A.DOC_DATE), A.ORG_DOC_TYPE_CODE, A.ORG_DOC_NUMBER; */ 


   if (OERROR)
         err_mesg("SELECT failed on cursor BL_DCP_TRN_CUR",0,"");

      /*     to select the details from bl_bill_hdr, if count = 0    

   EXEC SQL DECLARE BL_CR_AGR_STAT_CUR CURSOR FOR
           SELECT  TRUNC(A.DOC_DATE),
				   A.BILL_TOT_OUTST_AMT,
                   ((TRUNC(MONTHS_BETWEEN(TO_DATE(:nd_cutoff_date,'DD/MM/YYYY'), B.INST_START_DATE)) * B.INST_AMT_MONTHLY) - (B.BILL_OUTSTANDING_AMT - A.BILL_TOT_OUTST_AMT))
  	       FROM    BL_BILL_HDR A, BL_CREDIT_AGREEMENT B
		   WHERE a.operating_facility_id = b.operating_facility_id AND
		   A.PATIENT_ID    = B.PATIENT_ID
		   AND	   A.DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE
		   AND	   A.DOC_NUM       = B.BILL_DOC_NUM
		   AND     a.operating_facility_id  = :nd_facility_id 
		   AND	   B.PATIENT_ID  = :nd_patient_id
		   AND	   B.SPONSOR_ID  = :nd_sponsor_id 
		   AND     A.DOC_TYPE_CODE = :nd_bill_doc_type_code
		   AND     A.DOC_NUM    = :nd_bill_doc_num
		   ORDER BY TRUNC(A.DOC_DATE), A.DOC_TYPE_CODE, A.DOC_NUM;

   if (OERROR)
         err_mesg("SELECT failed on cursor BL_CR_AGR_STAT_CUR",0,"");
*/
}


fetch_sponsor_cur()
{

	/* EXEC SQL OPEN BL_CR_AGR_SPONSOR_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )180;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&fr_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&fr_sponsor_id;
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
	err_mesg("OPEN failed on cursor BL_CR_AGR_SPONSOR_CUR",0,"");

 
for(; ;)
{
	
nd_sponsor_id.arr[0]         = '\0';
nd_sponsor_name.arr[0]       = '\0';
nd_sponsor_address1.arr[0]   = '\0';
nd_sponsor_address2.arr[0]   = '\0';
nd_sponsor_address3.arr[0]   = '\0';
nd_sponsor_address4.arr[0]   = '\0';
nd_sponsor_tel_num.arr[0]    = '\0';

nd_sponsor_id.len            = 0;
nd_sponsor_name.len          = 0;
nd_sponsor_address1.len      = 0;
nd_sponsor_address2.len      = 0;
nd_sponsor_address3.len      = 0;
nd_sponsor_address4.len      = 0;
nd_sponsor_tel_num.len       = 0;


   /* EXEC SQL FETCH BL_CR_AGR_SPONSOR_CUR
			INTO  :nd_sponsor_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )203;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_sponsor_id;
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
      err_mesg("FETCH failed on cursor BL_CR_AGR_SPONSOR_CUR",0,"");

   if (LAST_ROW)
   {
       /* condition added by saikiran for 18154 on 19/1/2010 */
	   if (count<1)
	   {
	     print_title();
		 
		}
		/* condition over */

		return (0);
	}

	nd_sponsor_id.arr[nd_sponsor_id.len]             = '\0';


   /* EXEC SQL OPEN BL_SPONSOR_NAME; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )222;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_sponsor_id;
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



   if(OERROR)
       err_mesg("OPEN failed on cursor BL_SPONSOR_NAME",0,"");

    /* EXEC SQL FETCH BL_SPONSOR_NAME
              INTO :nd_sponsor_name, 
		   :nd_sponsor_address1,
		   :nd_sponsor_address2,
		   :nd_sponsor_address3,
		   :nd_sponsor_address4,
		   :nd_sponsor_tel_num; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )245;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_sponsor_name;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_sponsor_address1;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_sponsor_address2;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_sponsor_address3;
    sqlstm.sqhstl[3] = (unsigned int  )33;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_sponsor_address4;
    sqlstm.sqhstl[4] = (unsigned int  )33;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_sponsor_tel_num;
    sqlstm.sqhstl[5] = (unsigned int  )21;
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



   if(OERROR)
       err_mesg("FETCH failed on cursor BL_SPONSOR_NAME",0,"");
 
   nd_sponsor_name.arr[nd_sponsor_name.len]         = '\0';
   nd_sponsor_address1.arr[nd_sponsor_address1.len] = '\0';
   nd_sponsor_address2.arr[nd_sponsor_address2.len] = '\0';
   nd_sponsor_address3.arr[nd_sponsor_address3.len] = '\0';
   nd_sponsor_address4.arr[nd_sponsor_address4.len] = '\0';
   nd_sponsor_tel_num.arr[nd_sponsor_tel_num.len]   = '\0';

   print_title();
   print_hdr();
   dtl_title_print();
 
   fetch_credit_agreement_cur();

   for(lctr;lctr<56;lctr++){ fprintf(f1,"\n"); } 
 

	fprintf(f1,"                                                         ____________________\n\n");

	fprintf(f1,"                                                           %-16.16s\n\f\n\n",loc_legend[20]);

	for(lctr;lctr<=60;lctr++){ fprintf(f1,"\n"); } 
    
	count = count+1;//by saikiran for 18154 on 19/1/2010

  }

/* EXEC SQL CLOSE BL_CR_AGR_SPONSOR_CUR; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 13;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )284;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
		   err_mesg("CLOSE failed on cursor BL_CR_AGR_SPONSOR_CUR",0,"");

}




fetch_credit_agreement_cur()
{
   /* EXEC SQL OPEN BL_CREDIT_AGREEMENT_CUR1; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0009;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )299;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&fr_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_cutoff_date;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_sponsor_id;
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



   if (OERROR)
         err_mesg("OPEN failed on cursor BL_CREDIT_AGREEMENT_CUR1",0,"");
for(;;)
{

	nd_bill_doc_type_code.arr[0] = '\0';
	nd_bill_doc_date1.arr[0]	='\0';


	nd_bill_doc_type_code.len    = 0;
	nd_bill_doc_num  = 0;
	nd_bill_doc_date1.len		=0;

    /* EXEC SQL FETCH BL_CREDIT_AGREEMENT_CUR1
             INTO :nd_bill_doc_type_code,
                  :nd_bill_doc_num,
				  :nd_bill_doc_date1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )326;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_bill_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_bill_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_bill_doc_date1;
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


	

	if (LAST_ROW)
       {
	    return (0);
	   }
			

    if (OERROR)
       err_mesg("FETCH failed on cursor BL_CREDIT_AGREEMENT_CUR1",0,"");

	   nd_bill_doc_type_code.arr[nd_bill_doc_type_code.len] = '\0';
	   nd_bill_doc_date1.arr[nd_bill_doc_date1.len] = '\0';

	   
	
		fetch_credit_cusror_bill();
		

}

	/* EXEC SQL CLOSE BL_CREDIT_AGREEMENT_CUR1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )353;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
		   err_mesg("CLOSE failed on cursor BL_CREDIT_AGREEMENT_CUR1",0,"");

		return (1);

}


fetch_credit_cusror_bill()
{

	nd_tot_inst_amt_due = 0;

/* EXEC SQL OPEN BL_CR_AGREEMENT_CUR_BILL; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 13;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = sq0010;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )368;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_bill_doc_type_code;
sqlstm.sqhstl[0] = (unsigned int  )11;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_bill_doc_num;
sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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
         err_mesg("OPEN failed on cursor BL_CR_AGREEMENT_CUR_BILL",0,"");
	
	for(; ;) {
	nd_patient_id.arr[0]         = '\0';
	nd_doc_type_code.arr[0] = '\0';
	nd_bill_doc_date.arr[0] = '\0';

	nd_patient_id.len            = 0;
	nd_doc_type_code.len    = 0;
	nd_bill_doc_date.len	=0;

    /* EXEC SQL FETCH BL_CR_AGREEMENT_CUR_BILL
             INTO :nd_patient_id,
				  :nd_doc_type_code,
                  :nd_doc_num,
				  :nd_bill_doc_date,
				  :nd_bill_outst_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )391;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_doc_type_code;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_doc_num;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_bill_doc_date;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_bill_outst_amt;
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
       err_mesg("FETCH failed on cursor BL_CR_AGREEMENT_CUR_BILL",0,"");
		
				
    if (LAST_ROW)
       {
       return (0);
	   }

	nd_patient_id.arr[nd_patient_id.len] = '\0';
    nd_doc_type_code.arr[nd_doc_type_code.len] = '\0';
	nd_bill_doc_date.arr[nd_bill_doc_date.len] = '\0';

		
		print_dtl();
		print_inst_title();
		fetch_bl_cr_agreement_inst_dtl();
		print_total_due();
		
	}

	/* EXEC SQL CLOSE BL_CR_AGREEMENT_CUR_BILL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )426;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
       err_mesg("CLOSE failed on cursor BL_CR_AGREEMENT_CUR_BILL",0,"");

	return (1);

}


fetch_bl_cr_agreement_inst_dtl()
{
	
	/* EXEC SQL OPEN BL_CR_AGREEMENT_INST_DTL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0011;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )441;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&fr_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_cutoff_date;
 sqlstm.sqhstl[1] = (unsigned int  )13;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_sponsor_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_bill_doc_type_code;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_bill_doc_num;
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
         err_mesg("OPEN failed on cursor BL_CR_AGREEMENT_INST_DTL",0,"");

	for(;;)
	{

		nd_AGGR_DOC_TYPE_CODE.arr[0]         = '\0';
		nd_AGGR_DOC_DATE.arr[0] = '\0';
		nd_INST_DUE_DATE.arr[0] = '\0';

		nd_AGGR_DOC_TYPE_CODE.len            = 0;
		nd_AGGR_DOC_DATE.len    = 0;
		nd_INST_DUE_DATE.len	=0;

		nd_INST_PMNT_AMT	=0;
		nd_TOT_INST_PAID_AMT	= 0;
		nd_inst_amt_due	=0;	

		/* EXEC SQL FETCH BL_CR_AGREEMENT_INST_DTL
				 INTO :nd_AGGR_DOC_TYPE_CODE,
					  :nd_AGGR_DOC_NUM,
					  :nd_AGGR_DOC_DATE,
					  :nd_INST_DUE_DATE,
					  :nd_AGGR_INST_NO,
					  :nd_INST_PMNT_AMT,
					  :nd_inst_amt_due,
					  :nd_TOT_INST_PAID_AMT; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )476;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_AGGR_DOC_TYPE_CODE;
  sqlstm.sqhstl[0] = (unsigned int  )11;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_AGGR_DOC_NUM;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_AGGR_DOC_DATE;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_INST_DUE_DATE;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_AGGR_INST_NO;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_INST_PMNT_AMT;
  sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_inst_amt_due;
  sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_TOT_INST_PAID_AMT;
  sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
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



		if (OERROR)
		   err_mesg("FETCH failed on cursor BL_CR_AGREEMENT_INST_DTL",0,"");
			
			if (LAST_ROW)
		   {
		   return (0);
		   }


		nd_AGGR_DOC_TYPE_CODE.arr[nd_AGGR_DOC_TYPE_CODE.len] = '\0';
		nd_AGGR_DOC_DATE.arr[nd_AGGR_DOC_DATE.len] = '\0';
		nd_INST_DUE_DATE.arr[nd_INST_DUE_DATE.len] = '\0';

		
		print_inst_dtls();
		

		
	
	}


	/* EXEC SQL CLOSE BL_CR_AGREEMENT_INST_DTL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )523;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
       err_mesg("CLOSE failed on cursor BL_CR_AGREEMENT_INST_DTL",0,"");

	return (1);

}


print_title()
{

int spc=0;

int i=0;

    fprintf(f1,"                         ");

	for (i=0;i<(40-hosp_name.len)/2;i++)
		fprintf(f1," ");
fprintf(f1,"%c(s3B",ESC);
fprintf(f1,"%s", hosp_name.arr);
fprintf(f1,"%c(s0B",ESC);

     spc = strlen(h_ln1_add.arr) ; 
	 if(spc>0) 
	 {
	     fprintf(f1,"%c(s12H",ESC);
	 	 for(i=1;i<(96-spc)/2;i++) fprintf(f1," ");
		 fprintf(f1,"\n\t\t\t\t\t  %s", h_ln1_add.arr); 
 		 fprintf(f1,"%c(s10H \n",ESC);
	 }
	 spc = strlen(h_ln2_add.arr) ; 
	 if(spc>0) 
	 {
	     fprintf(f1,"%c(s12H",ESC);
		 for(i=1;i<(96-spc)/2;i++) fprintf(f1," ");
		 fprintf(f1,"%s", h_ln2_add.arr); 
		 fprintf(f1,"%c(s10H \n",ESC);
	 }
	 spc = strlen(h_ln3_add.arr); 
	 if(spc>0) 
	 {
	    fprintf(f1,"%c(s12H",ESC);
		for(i=1;i<(96-spc)/2;i++) fprintf(f1," ");
		fprintf(f1,"%s", h_ln3_add.arr); 
		fprintf(f1,"%c(s10H \n",ESC);
	 }
	 spc = strlen(h_zip_code.arr); 
	 if(spc>0) 
	 {
	    fprintf(f1,"%c(s12H",ESC);
		for(i=1;i<(96-spc)/2;i++) fprintf(f1," ");
		fprintf(f1,"%s", h_zip_code.arr); 
		fprintf(f1,"%c(s10H \n",ESC);
	 }
     fprintf(f1,"%c(s12H",ESC);
	 fprintf(f1,"%-11.11s : %s \n",loc_legend[1],h_email_id.arr);
	 fprintf(f1,"%-11.11s : %s \n",loc_legend[2],h_tel_num.arr);
	 fprintf(f1,"%-11.11s : %s \n",loc_legend[3],h_fax_num.arr);
	 fprintf(f1,"%-11.11s : %s ",loc_legend[4],h_practice_num.arr);
	 fprintf(f1, " %c(s10H",ESC);
	 fprintf(f1,"\n________________________________________________________________________________");

     fprintf(f1,"\n\n");




fprintf(f1,"\n\n");
fprintf(f1,"                           %-26.26s\n\n",loc_legend[5]);
fprintf(f1,"                                                           %-4.4s : %10s\n",loc_legend[6],nd_date.arr);
}

print_hdr()
{

 if(nd_cutoff_date.arr[0]!='\0')
 {
 init_date_temp_var();
 strcpy(date_convert.arr,nd_cutoff_date.arr);
 fun_change_loc_date2();
 strcpy(nd_cutoff_date1.arr,date_convert.arr);
 }

fprintf(f1, "%-14.14s :  %-11.11s\n",loc_legend[7],nd_sponsor_id.arr);
fprintf(f1, "%-14.14s :  %-31.31s\n",loc_legend[8],nd_sponsor_name.arr);
fprintf(f1, "%-14.14s :  %-31.31s\n",loc_legend[9],nd_sponsor_address1.arr);
fprintf(f1, "                  %-31.31s\n", nd_sponsor_address2.arr);
fprintf(f1, "                  %-31.31s\n", nd_sponsor_address3.arr);
fprintf(f1, "                  %-31.31s\n", nd_sponsor_address4.arr);
fprintf(f1, "%-14.14s :  %-31.31s\n\n\n",loc_legend[10],nd_sponsor_tel_num.arr);
fprintf(f1, "    %-50.50s %10s.\n",loc_legend[11],nd_cutoff_date1.arr);
fprintf(f1, "    %-s\n\n\n",loc_legend[12]);

nd_sponsor_name.arr[nd_sponsor_name.len] = '\0';

lctr = 18;


   /* EXEC SQL SELECT DECODE(:nd_lang_id,'en',SHORT_NAME, SHORT_NAME_LOC_LANG)
			  INTO :nd_patient_name
              FROM MP_PATIENT_MAST
             WHERE PATIENT_ID = :fr_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DECODE(:b0,'en',SHORT_NAME,SHORT_NAME_LOC_LANG) int\
o :b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )538;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[0] = (unsigned int  )6;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_patient_name;
   sqlstm.sqhstl[1] = (unsigned int  )63;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&fr_patient_id;
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



      if (OERROR)
         err_mesg("SELECT failed on MP_PATIENT_MAST.SHORT_NAME selection 1",0,"");

nd_patient_name.arr[nd_patient_name.len] = '\0';


fprintf(f1,"%-10.10s : %-20.20s	 %-4.4s:%-50.50s \n",loc_legend[13],fr_patient_id.arr,loc_legend[18],nd_patient_name.arr);
}


dtl_title_print()
{
fprintf(f1,"_____________________________________________________________________________________________\n");
fprintf(f1," %-13.13s       %-4.4s              %-20.20s   %-15.15s    %-11.11s    \n",loc_legend[23],loc_legend[24],loc_legend[14],loc_legend[15],loc_legend[16],loc_legend[17]);
fprintf(f1,"										 %-14.14s  \n",loc_legend[19],loc_legend[22]);
fprintf(f1,"_____________________________________________________________________________________________\n\n");
lctr += 4;
}



print_dtl()
{

	
	 if(nd_bill_doc_date.arr[0]!='\0')
	 {
	 init_date_temp_var();
	 strcpy(date_convert.arr,nd_bill_doc_date.arr);
     fun_change_loc_date1();
     strcpy(nd_temp_date1.arr,date_convert.arr);
	 }

fprintf(f1," %-6s/%-8d     %-11s",nd_bill_doc_type_code.arr,nd_bill_doc_num,nd_bill_doc_date1.arr);
fprintf(f1, "   %-6s / %-8d      %-10s   ",  nd_doc_type_code.arr, nd_doc_num, nd_temp_date1.arr);
print_formated(nd_bill_outst_amt); fprintf(f1,"\n");


lctr += 3;
chk_break(1);
}

print_inst_title()
{
fprintf(f1,"\n		             %-13.13s				\n",loc_legend[25]);
fprintf(f1,"\n%-15.15s	%-14.14s    %-15.15s		%-10.10s    %-13.13s\n",loc_legend[26],loc_legend[27],loc_legend[28],loc_legend[29],loc_legend[30]);

}
print_inst_dtls()
{
//fprintf(f1,"%8d        %11s       %8d         %8d    %8d\n",nd_AGGR_INST_NO,nd_INST_DUE_DATE.arr,nd_INST_PMNT_AMT,nd_TOT_INST_PAID_AMT,nd_inst_amt_due );
fprintf(f1,"%8d        %11s  ",nd_AGGR_INST_NO,nd_INST_DUE_DATE.arr);
nd_tot_inst_amt_due = 	nd_tot_inst_amt_due+nd_inst_amt_due;
print_formated(nd_INST_PMNT_AMT); fprintf(f1,"	        ");
print_formated(nd_TOT_INST_PAID_AMT); fprintf(f1,"	 ");
print_formated(nd_inst_amt_due); fprintf(f1,"\n");

lctr=lctr++;
if (lctr>60)
lctr=1;
}

print_total_due()
{
fprintf(f1,"								              ------------\n");
fprintf(f1,"							      %-9.9s",loc_legend[31]);
print_formated(nd_tot_inst_amt_due); fprintf(f1,"\n");
fprintf(f1,"								    	      ------------\n\n");

lctr=lctr++;
if (lctr>60)
lctr=1;
}




print_dtl_title()
{
fprintf(f1,"________________________________________________________________________________\n");
fprintf(f1,"%-10.10s  %-8.8s           %-9.9s   %-11.11s     %-15.15s\n",loc_legend[13],loc_legend[14],loc_legend[15],loc_legend[16],loc_legend[17]);
fprintf(f1,"%-4.4s                                      %-14.14s  %-17.17s\n",loc_legend[18],loc_legend[19],loc_legend[22]);
fprintf(f1,"________________________________________________________________________________\n\n");
lctr += 4;
}


fetch_dcp_pending_doc_cur()
{
   /* EXEC SQL OPEN BL_DCP_PENDING_DOC_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0012;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )565;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_bill_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_bill_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
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
         err_mesg("OPEN failed on cursor BL_DCP_PENDING_DOC_CUR",0,"");

    /* EXEC SQL FETCH BL_DCP_PENDING_DOC_CUR
             INTO :cnt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )596;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&cnt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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
       err_mesg("FETCH failed on cursor BL_DCP_PENDING_DOC_CUR",0,"");

    if (LAST_ROW)
       {
       return (0);
	   }

	if (cnt > 0)
	   {

   /* EXEC SQL OPEN BL_DOC_AMT_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0013;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )615;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_bill_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_bill_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
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
         err_mesg("OPEN failed on cursor BL_DOC_AMT_CUR",0,"");

   /* EXEC SQL OPEN BL_TOT_PAID_AMT_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0014;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )646;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_bill_doc_type_code;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_bill_doc_num;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
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
         err_mesg("OPEN failed on cursor BL_TOT_PAID_AMT_CUR",0,"");

   /* EXEC SQL OPEN BL_DCP_TRN_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0015;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )677;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_cutoff_date;
   sqlstm.sqhstl[0] = (unsigned int  )13;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_cutoff_date;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_sponsor_id;
   sqlstm.sqhstl[4] = (unsigned int  )23;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_bill_doc_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_bill_doc_num;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
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
         err_mesg("OPEN failed on cursor BL_DCP_TRN_CUR",0,"");

	    fetch_doc_amt_cur();

		fetch_tot_paid_amt_cur();

		fetch_dcp_trn_cur();
	   }
/* sridharan - 21/june/98 
	else
	   {
	   fetch_bill_hdr_cursor();
	   }
*/
	return (1);
}

fetch_doc_amt_cur()
{

//for(;;)
//{

    nd_document_amount = 0;

    /* EXEC SQL FETCH BL_DOC_AMT_CUR
             INTO :nd_document_amount; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )720;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_document_amount;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
       err_mesg("FETCH failed on cursor BL_DOC_AMT_CUR",0,"");

    if (LAST_ROW)
       {
       return (0);
	   }
//}

	return (1);
}

fetch_tot_paid_amt_cur()
{

//for(;;)
//{

    nd_paid_amt = 0;

    /* EXEC SQL FETCH BL_TOT_PAID_AMT_CUR
             INTO :nd_paid_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 13;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )739;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_paid_amt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
       err_mesg("FETCH failed on cursor BL_TOT_PAID_AMT_CUR",0,"");

    if (LAST_ROW)
       {
       return (0);
	   }
//}

	return (1);
}

fetch_dcp_trn_cur()
{

//for(;;)
//{

nd_bill_doc_date.arr[0]         = '\0';
nd_bill_doc_date.len         = 0;
nd_inst_amt_due	      = 0;
nd_instalment_amount  = 0;


   /* EXEC SQL FETCH BL_DCP_TRN_CUR
             INTO :nd_bill_doc_date,
		          :nd_instalment_amount; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )758;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_bill_doc_date;
   sqlstm.sqhstl[0] = (unsigned int  )13;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_instalment_amount;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
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
         err_mesg("FETCH failed on cursor BL_DCP_TRN_CUR",0,"");

   if (LAST_ROW)
       {
       return (0);
	   }

    if(nd_instalment_amount < 0) 
        nd_instalment_amount = 0;

    nd_bill_doc_date.arr[nd_bill_doc_date.len] = '\0';

    nd_inst_amt_due = ((nd_instalment_amount+nd_paid_amt) < nd_document_amount) ? (nd_instalment_amount+nd_paid_amt) : nd_document_amount;


if(nd_inst_amt_due > 0)
{
    nd_total_bill_outst_amt += nd_document_amount;
    nd_total_inst_amt_due   += nd_inst_amt_due;
    print_dtl();
}

//  }
       return (1);
}

/* sridharan - 21/june/98
fetch_bill_hdr_cursor()
{
   EXEC SQL OPEN BL_CR_AGR_STAT_CUR;

   if (OERROR)
         err_mesg("OPEN failed on cursor BL_CR_AGR_STAT_CUR",0,"");

nd_bill_doc_date.arr[0]         = '\0';
nd_bill_doc_date.len         = 0;

nd_bill_outst_amt = 0;
nd_inst_amt_due   = 0;

   EXEC SQL FETCH BL_CR_AGR_STAT_CUR
             INTO :nd_bill_doc_date,
                  :nd_bill_outst_amt,
				  :nd_inst_amt_due;

      if (OERROR)
         err_mesg("FETCH failed on cursor BL_CR_AGR_STAT_CUR",0,"");

   if (LAST_ROW)
       {
       return (0);
	   }

    nd_bill_doc_date.arr[nd_bill_doc_date.len] = '\0';

    nd_total_bill_outst_amt += nd_bill_outst_amt;
    nd_total_inst_amt_due   += nd_inst_amt_due;

	print_bill_hdr_dtl();

       return (1);
}
*/





/*
print_bill_hdr_dtl()
{
   EXEC SQL SELECT SHORT_NAME
			  INTO :nd_patient_name
              FROM MP_PATIENT_MAST
             WHERE PATIENT_ID = :nd_patient_id;

      if (OERROR)
         err_mesg("SELECT failed on MP_PATIENT_MAST.SHORT_NAME selection 2",0,"");

nd_patient_name.arr[nd_patient_name.len] = '\0';

if(first_time) {
   print_title();
   print_hdr();
   print_dtl_title();
   first_time = 0;
}

fprintf(f1, "%-20s  %-6s / %-8d  %-10s  ", nd_patient_id.arr, nd_bill_doc_type_code.arr, nd_bill_doc_num, nd_bill_doc_date.arr);
print_formated(nd_bill_outst_amt); fprintf(f1,"  ");
print_formated(nd_inst_amt_due); fprintf(f1," \n");
fprintf(f1, "%-60.60s\n\n", nd_patient_name.arr);
lctr += 3;
chk_break(1);
}
*/

print_totals()
{
fprintf(f1,"                                           --------------  --------------\n");
fprintf(f1,"                                Total :    ");
print_formated(nd_total_bill_outst_amt); fprintf(f1,"  ");
print_formated(nd_total_inst_amt_due); fprintf(f1," \n");

fprintf(f1,"                                           --------------  --------------\n");

fprintf(f1,"________________________________________________________________________________\n\n\n\n");


nd_total_bill_outst_amt = 0;
nd_total_inst_amt_due   = 0;
}

print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (loc_amount == 0)
	{
      fprintf(f1,"%-14s"," "); }
   else if (loc_amount > 0)
   {
     	  
	  sprintf(out_str,"%11.2f",loc_amount);
      ltrim(out_str);
	  
	  format_amt(out_str);
	  	  
	  sprintf(out_str1,"%14s",out_str);
      fprintf(f1,"%-14s",out_str1);
   }
   else
   {

	  sprintf(out_str,"%11.2f",-loc_amount);
      ltrim(out_str);

	  format_amt(out_str);
      
	  sprintf(out_str1,"%14s",out_str);
      fprintf(f1,"%-14s-",out_str1);
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
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )781;
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

chk_break(nol)
 int nol;
 {
   if (lctr+nol > 60)
    {
	fprintf(f1,"                                                      %-19.19s ...\n",loc_legend[21]);
	fprintf(f1,"\f");
	pctr++;
  	lctr = 0;
	//dtl_title_print();
	}
 }

 /*
sprintf(string_var, "sss nd_sponsor_id = %s", nd_sponsor_id.arr);
disp_message(ERR_MESG, string_var);
sprintf(string_var,"start - doc_num  : %d",nd_bill_doc_num);
disp_message(ERR_MESG,string_var);
sprintf(string_var,"nd_bill_doc_type_code - nd_bill_doc_num - cnt - : %s - %d - %d",nd_bill_doc_type_code.arr, nd_bill_doc_num, cnt);
disp_message(ERR_MESG,string_var);
disp_message(ERR_MESG,"Before fetch_doc_amt_cur");
sprintf(string_var,"nd_document_amount : %f",nd_document_amount);
disp_message(ERR_MESG,string_var);
disp_message(ERR_MESG,"Before fetch_tot_paid_amt_cur");
sprintf(string_var,"nd_paid_amt : %f",nd_paid_amt);
disp_message(ERR_MESG,string_var);
disp_message(ERR_MESG,"Before fetch_dcp_trn_cur");
disp_message(ERR_MESG,"After fetch_dcp_trn_cur");
disp_message(ERR_MESG,"Bill_hdr");
disp_message(ERR_MESG,"Note down");
sprintf(string_var,"nd_inst_amt_due : %f",nd_inst_amt_due);
disp_message(ERR_MESG,string_var);
sprintf(string_var, "nd_inst_amt_due = %f", nd_inst_amt_due);
disp_message(ERR_MESG, string_var);
sprintf(string_var, " > 0 nd_inst_amt_due = %f", nd_inst_amt_due);
disp_message(ERR_MESG, string_var);
*/
 





fetch_legend_value()
{

	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRCRAGS.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRCRAGS.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )812;
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
										:nd_lang_id);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :nd_lang_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )835;
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
  sqlstm.sqhstv[3] = (         void  *)&nd_lang_id;
  sqlstm.sqhstl[3] = (unsigned int  )6;
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
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY'),:nd_lang_id,t_date);

		:nd_loc_date := to_char(t_date,'DD-MON-YYYY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY' ) , :nd_lang_id , t_date ) ;\
 :nd_loc_date := to_char ( t_date , 'DD-MON-YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )866;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[2] = (unsigned int  )22;
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
get_local_date1()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YY'),:nd_lang_id,t_date);

		:nd_loc_date := to_char(t_date,'DD-MON-YY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YY' ) , :nd_lang_id , t_date ) ; :\
nd_loc_date := to_char ( t_date , 'DD-MON-YY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )893;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[2] = (unsigned int  )22;
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


		nd_loc_date.arr[nd_loc_date.len]='\0';
		if (OERROR)
        err_mesg("SELECTING Date failed",0,"");

}

get_local_date2()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY'),:nd_lang_id,t_date);

		:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY' ) , :nd_lang_id , t_date ) ;\
 :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )920;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[2] = (unsigned int  )22;
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


		nd_loc_date.arr[nd_loc_date.len]='\0';
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

fun_change_loc_date1()
{
strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date1();

strcpy(date_convert.arr,nd_loc_date.arr); 
}
fun_change_loc_date2()
{
strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date2();

strcpy(date_convert.arr,nd_loc_date.arr); 
}