
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/blrbarcs.pc"
};


static unsigned int sqlctx = 1288465891;


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
            void  *sqhstv[20];
   unsigned int   sqhstl[20];
            int   sqhsts[20];
            void  *sqindv[20];
            int   sqinds[20];
   unsigned int   sqharm[20];
   unsigned int   *sqharc[20];
   unsigned short  sqadto[20];
   unsigned short  sqtdso[20];
} sqlstm = {12,20};

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

 static const char *sq0006 = 
"select A.REV_CUST_CODE ,A.BLNG_GRP_ID ,SUBSTR(B.BLNG_SERV_CODE,1,2) ,SUBSTR(\
B.BLNG_SERV_CODE,1,3) ,B.BLNG_SERV_CODE ,B.ORG_GROSS_CHARGE_AMT ,B.ORG_DISC_AM\
T ,B.ORG_NET_CHARGE_AMT  from BL_BILL_HDR A ,BL_PATIENT_CHARGES_FOLIO B where \
(((((((((((((A.DOC_TYPE_CODE=B.BILL_DOC_TYPE_CODE and A.DOC_NUM=B.BILL_DOC_NUM\
) and A.BLNG_GRP_ID=:b0) and A.REV_CUST_CODE=:b1) and A.PATIENT_ID between :b2\
 and :b3) and A.DOC_TYPE_CODE between :b4 and :b5) and A.DOC_NUM between :b6 a\
nd :b7) and TRUNC(A.DOC_DATE) between to_date(:b8,'DD/MM/YYYY') and to_date(:b\
9,'DD/MM/YYYY')) and B.BLNG_SERV_CODE between :b10 and :b11) and NVL(B.PACKAGE\
_TRX_IND,'X')='N') and NVL(A.BILL_STATUS,'X')<>'C') and NVL(A.BILL_TRX_TYPE_CO\
DE,'X')<>'I') and NVL(a.operating_facility_id,'X')=NVL(:b12,'X')) and NVL(b.op\
erating_facility_id,'X')=NVL(:b12,'X')) order by A.BLNG_GRP_ID,A.REV_CUST_CODE\
,B.BLNG_SERV_CODE            ";

 static const char *sq0007 = 
"select A.REV_CUST_CODE ,A.BLNG_GRP_ID ,SUBSTR(B.BLNG_SERV_CODE,1,2) ,SUBSTR(\
B.BLNG_SERV_CODE,1,3) ,B.BLNG_SERV_CODE ,B.ORG_GROSS_CHARGE_AMT ,B.ORG_DISC_AM\
T ,B.ORG_NET_CHARGE_AMT  from BL_BILL_HDR A ,BL_PATIENT_CHARGES_FOLIO B where \
((((((((((((A.DOC_TYPE_CODE=B.BILL_DOC_TYPE_CODE and A.DOC_NUM=B.BILL_DOC_NUM)\
 and A.BLNG_GRP_ID=:b0) and A.PATIENT_ID between :b1 and :b2) and A.DOC_TYPE_C\
ODE between :b3 and :b4) and A.DOC_NUM between :b5 and :b6) and TRUNC(A.DOC_DA\
TE) between to_date(:b7,'DD/MM/YYYY') and to_date(:b8,'DD/MM/YYYY')) and B.BLN\
G_SERV_CODE between :b9 and :b10) and NVL(B.PACKAGE_TRX_IND,'X')='N') and NVL(\
A.BILL_STATUS,'X')<>'C') and NVL(A.BILL_TRX_TYPE_CODE,'X')<>'I') and NVL(a.ope\
rating_facility_id,'X')=NVL(:b11,'X')) and NVL(b.operating_facility_id,'X')=NV\
L(:b11,'X')) order by A.BLNG_GRP_ID,A.REV_CUST_CODE,B.BLNG_SERV_CODE          \
  ";

 static const char *sq0008 = 
"select A.REV_CUST_CODE ,A.BLNG_GRP_ID ,SUBSTR(B.BLNG_SERV_CODE,1,2) ,SUBSTR(\
B.BLNG_SERV_CODE,1,3) ,B.BLNG_SERV_CODE ,B.ORG_GROSS_CHARGE_AMT ,B.ORG_DISC_AM\
T ,B.ORG_NET_CHARGE_AMT  from BL_BILL_HDR A ,BL_PATIENT_CHARGES_FOLIO B where \
((((((((((((((A.DOC_TYPE_CODE=B.BILL_DOC_TYPE_CODE and A.DOC_NUM=B.BILL_DOC_NU\
M) and A.BLNG_GRP_ID=:b0) and A.REV_CUST_CODE=:b1) and A.EPISODE_TYPE=:b2) and\
 A.PATIENT_ID between :b3 and :b4) and A.DOC_TYPE_CODE between :b5 and :b6) an\
d A.DOC_NUM between :b7 and :b8) and TRUNC(A.DOC_DATE) between to_date(:b9,'DD\
/MM/YYYY') and to_date(:b10,'DD/MM/YYYY')) and B.BLNG_SERV_CODE between :b11 a\
nd :b12) and NVL(B.PACKAGE_TRX_IND,'X')='N') and NVL(A.BILL_STATUS,'X')<>'C') \
and NVL(A.BILL_TRX_TYPE_CODE,'X')<>'I') and NVL(a.operating_facility_id,'X')=N\
VL(:b13,'X')) and NVL(b.operating_facility_id,'X')=NVL(:b13,'X')) order by A.B\
LNG_GRP_ID,A.REV_CUST_CODE,B.BLNG_SERV_CODE            ";

 static const char *sq0009 = 
"select A.REV_CUST_CODE ,A.BLNG_GRP_ID ,SUBSTR(B.BLNG_SERV_CODE,1,2) ,SUBSTR(\
B.BLNG_SERV_CODE,1,3) ,B.BLNG_SERV_CODE ,B.ORG_GROSS_CHARGE_AMT ,B.ORG_DISC_AM\
T ,B.ORG_NET_CHARGE_AMT  from BL_BILL_HDR A ,BL_PATIENT_CHARGES_FOLIO B where \
(((((((((((((A.DOC_TYPE_CODE=B.BILL_DOC_TYPE_CODE and A.DOC_NUM=B.BILL_DOC_NUM\
) and A.BLNG_GRP_ID=:b0) and A.EPISODE_TYPE=:b1) and A.PATIENT_ID between :b2 \
and :b3) and A.DOC_TYPE_CODE between :b4 and :b5) and A.DOC_NUM between :b6 an\
d :b7) and TRUNC(A.DOC_DATE) between to_date(:b8,'DD/MM/YYYY') and to_date(:b9\
,'DD/MM/YYYY')) and B.BLNG_SERV_CODE between :b10 and :b11) and NVL(B.PACKAGE_\
TRX_IND,'X')='N') and NVL(A.BILL_STATUS,'X')<>'C') and NVL(A.BILL_TRX_TYPE_COD\
E,'X')<>'I') and NVL(a.operating_facility_id,'X')=NVL(:b12,'X')) and NVL(b.ope\
rating_facility_id,'X')=NVL(:b12,'X')) order by A.BLNG_GRP_ID,A.REV_CUST_CODE,\
B.BLNG_SERV_CODE            ";

 static const char *sq0010 = 
"select LONG_DESC  from BL_BLNG_GRP_LANG_VW where (BLNG_GRP_ID=:b0 and langua\
ge_id=:b1)           ";

 static const char *sq0013 = 
"select LONG_DESC  from BL_BLNG_SERV_GRP_LANG_VW where (SERV_GRP_CODE=:b0 and\
 language_id=:b1)           ";

 static const char *sq0014 = 
"select LONG_DESC  from BL_SERV_CLASSIFICATION_LANG_VW where (SERV_CLASSIFICA\
TION_CODE=:b0 and language_id=:b1)           ";

 static const char *sq0012 = 
"select LONG_DESC  from BL_BLNG_SERV_LANG_VW where (BLNG_SERV_CODE=:b0 and la\
nguage_id=:b1)           ";

 static const char *sq0011 = 
"select LONG_NAME  from AR_CUSTOMER_LANG_VW where (CUST_CODE=:b0 and language\
_id=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,379,0,4,249,0,0,20,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
100,0,0,2,91,0,2,309,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
123,0,0,3,0,0,30,319,0,0,0,0,0,1,0,
138,0,0,0,0,0,27,325,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
169,0,0,5,0,0,17,375,0,0,1,1,0,1,0,1,9,0,0,
188,0,0,5,0,0,45,563,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
259,0,0,5,0,0,45,581,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
326,0,0,5,0,0,45,602,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
401,0,0,5,0,0,45,621,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
472,0,0,6,885,0,9,706,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
543,0,0,7,858,0,9,708,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
610,0,0,8,911,0,9,713,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
685,0,0,9,884,0,9,715,0,0,14,14,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
756,0,0,6,0,0,15,851,0,0,0,0,0,1,0,
771,0,0,7,0,0,15,853,0,0,0,0,0,1,0,
786,0,0,8,0,0,15,858,0,0,0,0,0,1,0,
801,0,0,9,0,0,15,860,0,0,0,0,0,1,0,
816,0,0,5,0,0,13,893,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
843,0,0,6,0,0,13,937,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,
890,0,0,7,0,0,13,949,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,
937,0,0,8,0,0,13,964,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,
984,0,0,9,0,0,13,976,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,
1031,0,0,10,97,0,9,1009,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1054,0,0,10,0,0,13,1016,0,0,1,0,0,1,0,2,9,0,0,
1073,0,0,13,104,0,9,1030,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1096,0,0,13,0,0,13,1037,0,0,1,0,0,1,0,2,9,0,0,
1115,0,0,14,121,0,9,1050,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1138,0,0,14,0,0,13,1057,0,0,1,0,0,1,0,2,9,0,0,
1157,0,0,12,101,0,9,1071,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1180,0,0,12,0,0,13,1078,0,0,1,0,0,1,0,2,9,0,0,
1199,0,0,11,95,0,9,1091,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1222,0,0,11,0,0,13,1098,0,0,1,0,0,1,0,2,9,0,0,
1241,0,0,15,144,0,4,3556,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
1264,0,0,16,158,0,4,3636,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1299,0,0,17,716,0,4,3661,0,0,15,14,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
1374,0,0,18,689,0,4,3686,0,0,14,13,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1445,0,0,19,742,0,4,3713,0,0,16,15,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,
1524,0,0,20,715,0,4,3739,0,0,15,14,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
1599,0,0,21,96,0,4,3774,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
1622,0,0,22,165,0,6,3781,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
1653,0,0,23,140,0,6,3802,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1680,0,0,24,94,0,4,3904,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
1703,0,0,25,39,0,4,3936,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
1726,0,0,26,35,0,4,3938,0,0,2,1,0,1,0,1,3,0,0,2,3,0,0,
1749,0,0,27,43,0,4,3955,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
1772,0,0,28,49,0,4,3958,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
1799,0,0,29,43,0,4,3985,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
1822,0,0,30,49,0,4,3988,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
};


/************************************************************************/  
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRBARCU.PC                                  */
/* AUTHOR                : V.SRIKANTH                                   */
/* DATE WRITTEN          : 04/02/2001								    */
/*                                                                      */
/* FUNCTION              : BUSINESS ANALYSIS BY REVENUE CUSTOMER (SUMRY)*/
/*                                                                      */
/* TABLE DETAILS         : BL_BILL_HDR                                  */
/*                         BL_PATIENT_CHARGES_FOLIO                     */
/*                         BL_BLNG_GRP                                  */
/*                         AR_CUSTOMER                                  */  
/*                         SY_ACC_ENTITY                                */
/*                         SY_PROG_PARAM                                */
/*                                                                      */
/*                                                                      */
/* FUNCTIONS             : print_summary()                              */
/*						   fetch_bl_bill_hdr()							*/
/*						   fetch_folio()								*/
/*						   fetch_blng_grp_desc()						*/
/*						   fetch_customer_name()						*/
/*						   fetch_patient_name()							*/
/*						   print_title()								*/
/*						   print_page_head()							*/
/*						   print_end()									*/
/*						   print_folio_record()							*/	
/*						   print_break_blng_grp()						*/
/*						   print_break_cust_code()						*/
/*						   check_folio_record()                         */
/*                                                                      */
/*                                                                      */
/************************************************************************/

#include <stdio.h>         
#include <string.h>         
#include <bl.h>  
 
#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define RESOURCE_BUSY (sqlca.sqlcode == -54)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define INIT_MESG "Report Generation In Progress..."

#define DEST_NAME "blrbarcs.lis"

#define HSKIP_10 2
#define HSKIP_11 20
#define HSKIP_12 15

#define MAX_LINES 43  //55

#define DEBUG 1
#define ESC 0x1B 

/* EXEC SQL BEGIN DECLARE SECTION; */ 



   /* VARCHAR uid_pwd						[132],
		   hosp_name					[41], //changed from 31 to 41
		   date_time					[20],
		   user_id						[20],
		   cur_str						[8],
		   sub_cur_str					[8],
		   d_facility_id				[10],
		   nd_facility_id               [3],
		   nd_pgm_date					[35],
		   nd_temp_date					[21],
		   p_language_id				[3],
		   date_convert					[21],
		   nd_loc_date					[21],
		   nd_session_id				[16]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[41]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[8]; } cur_str;

struct { unsigned short len; unsigned char arr[8]; } sub_cur_str;

struct { unsigned short len; unsigned char arr[10]; } d_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;


   /* VARCHAR nd_episode_type				[2],
		   nd_fr_pat_id					[21],
		   nd_to_pat_id					[21],
		   nd_fr_blng_grp				[5],
		   nd_to_blng_grp				[5],
		   nd_fr_cust_code				[9],
		   nd_to_cust_code				[9],
		   nd_fr_doc_type_code			[7],
		   nd_to_doc_type_code			[7],
		   nd_fr_doc_number				[9],
		   nd_to_doc_number				[9],
		   nd_fr_bill_date				[11],
		   nd_to_bill_date				[11],
		   nd_fr_blng_serv				[11],
		   nd_to_blng_serv				[11],
		   nd_report_type				[2],
		   nd_report_opt				[2],
		   nd_bill_nat					[2],
		   d_curs						[3000]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[21]; } nd_fr_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_pat_id;

struct { unsigned short len; unsigned char arr[5]; } nd_fr_blng_grp;

struct { unsigned short len; unsigned char arr[5]; } nd_to_blng_grp;

struct { unsigned short len; unsigned char arr[9]; } nd_fr_cust_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[7]; } nd_fr_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_fr_doc_number;

struct { unsigned short len; unsigned char arr[9]; } nd_to_doc_number;

struct { unsigned short len; unsigned char arr[11]; } nd_fr_bill_date;

struct { unsigned short len; unsigned char arr[11]; } nd_to_bill_date;

struct { unsigned short len; unsigned char arr[11]; } nd_fr_blng_serv;

struct { unsigned short len; unsigned char arr[11]; } nd_to_blng_serv;

struct { unsigned short len; unsigned char arr[2]; } nd_report_type;

struct { unsigned short len; unsigned char arr[2]; } nd_report_opt;

struct { unsigned short len; unsigned char arr[2]; } nd_bill_nat;

struct { unsigned short len; unsigned char arr[3000]; } d_curs;

		   

   /* VARCHAR d_blng_grp_id				[5],
		   d_cust_code					[9],
		   d_blng_serv_code				[11],
		   d_blng_serv_grp_code			[3],
		   d_blng_serv_clasfn_code		[4],
		   d_blng_serv_grp_desc			[41],
		   d_blng_serv_clasfn_desc		[41],
		   d_blng_serv_desc				[41],
		   g_blng_grp_id				[3],
		   g_cust_code					[9],
		   g_cust_code_1				[9],
		   g_blng_serv_code				[11],
		   g_blng_serv_grp_code			[3],
		   g_blng_serv_clasfn_code		[4],
		   g_blng_grp_desc				[41],
		   g_cust_name					[41], 
		   xx_grp_id					[5],
		   xx_grp_desc					[41],
		   xx_clasfn_id					[4],
		   xx_clasfn_desc				[41],
		   xx_serv_id					[11],
		   xx_serv_desc					[41],
		   xx_bl_grp		            [5],
		   xx_bl_grp_desc				[41],
		   xx_cust						[9],
		   l_pk_value				    [100],
		   l_translated_value	        [201],
		   xx_cust_name					[41]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[9]; } d_cust_code;

struct { unsigned short len; unsigned char arr[11]; } d_blng_serv_code;

struct { unsigned short len; unsigned char arr[3]; } d_blng_serv_grp_code;

struct { unsigned short len; unsigned char arr[4]; } d_blng_serv_clasfn_code;

struct { unsigned short len; unsigned char arr[41]; } d_blng_serv_grp_desc;

struct { unsigned short len; unsigned char arr[41]; } d_blng_serv_clasfn_desc;

struct { unsigned short len; unsigned char arr[41]; } d_blng_serv_desc;

struct { unsigned short len; unsigned char arr[3]; } g_blng_grp_id;

struct { unsigned short len; unsigned char arr[9]; } g_cust_code;

struct { unsigned short len; unsigned char arr[9]; } g_cust_code_1;

struct { unsigned short len; unsigned char arr[11]; } g_blng_serv_code;

struct { unsigned short len; unsigned char arr[3]; } g_blng_serv_grp_code;

struct { unsigned short len; unsigned char arr[4]; } g_blng_serv_clasfn_code;

struct { unsigned short len; unsigned char arr[41]; } g_blng_grp_desc;

struct { unsigned short len; unsigned char arr[41]; } g_cust_name;

struct { unsigned short len; unsigned char arr[5]; } xx_grp_id;

struct { unsigned short len; unsigned char arr[41]; } xx_grp_desc;

struct { unsigned short len; unsigned char arr[4]; } xx_clasfn_id;

struct { unsigned short len; unsigned char arr[41]; } xx_clasfn_desc;

struct { unsigned short len; unsigned char arr[11]; } xx_serv_id;

struct { unsigned short len; unsigned char arr[41]; } xx_serv_desc;

struct { unsigned short len; unsigned char arr[5]; } xx_bl_grp;

struct { unsigned short len; unsigned char arr[41]; } xx_bl_grp_desc;

struct { unsigned short len; unsigned char arr[9]; } xx_cust;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[41]; } xx_cust_name;


	double d_gross_amt,
		   d_disc_amt,
		   d_net_amt,
		   b_gross_amt,
		   b_disc_amt,
		   b_net_amt,
		   g_gross_amt,
		   g_disc_amt,
		   g_net_amt,
		   c_gross_amt,
		   c_disc_amt,
		   c_net_amt;        
		    
	int	   cnt;

	char   filename[150],
		   string_var[100];
	
	char loc_legend[999][201];
	int i;
	int v_no_of_decimal=0;
	int s_amt_len = 0;
	int nd_length_of_string=0,nd_length_of_string1=0,nd_length_of_string2=0;

/* VARCHAR nd_batch_filename		    [20],
		   nd_report_option		        [3],
		   orig_desc_string             [2000],
		   orig_desc_string1		    [2000],
		   nd_desc_with_spl_chr	        [2000],
		   nd_pad_req_yn			    [3],nd_print_option              [12],
		   nd_temp_str                  [2000]; */ 
struct { unsigned short len; unsigned char arr[20]; } nd_batch_filename;

struct { unsigned short len; unsigned char arr[3]; } nd_report_option;

struct { unsigned short len; unsigned char arr[2000]; } orig_desc_string;

struct { unsigned short len; unsigned char arr[2000]; } orig_desc_string1;

struct { unsigned short len; unsigned char arr[2000]; } nd_desc_with_spl_chr;

struct { unsigned short len; unsigned char arr[3]; } nd_pad_req_yn;

struct { unsigned short len; unsigned char arr[12]; } nd_print_option;

struct { unsigned short len; unsigned char arr[2000]; } nd_temp_str;


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

int  g_first_bgrp;
int  g_first_break ;
int  lno = 0, pno = 0;

double g_cum_amt = 0,g_sub_tot = 0;
double tot_disc_amt = 0;

FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{
   if (argc != 5)
   {
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"BLRBARCU");

   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle");
      if (uid_pwd.len == 0)
			disp_message(ERR_MESG,"Null oracle uid/pwd");
      proc_exit();
   }

	set_meduser_role();
   
   strcpy(p_language_id.arr,l_language_id.arr);
   p_language_id.len = l_language_id.len;

   strcpy(g_pgm_date,argv[3]);
   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);
 fun_Pad_desc_with_spl_char_yn(); 
   nd_episode_type.arr[0]		= '\0';
   nd_fr_pat_id.arr[0]			= '\0';	
   nd_to_pat_id.arr[0]			= '\0';	
   nd_fr_blng_grp.arr[0]		= '\0';
   nd_to_blng_grp.arr[0]		= '\0';
   nd_fr_cust_code.arr[0]		= '\0';
   nd_to_cust_code.arr[0]		= '\0';
   nd_fr_doc_type_code.arr[0]	= '\0';
   nd_to_doc_type_code.arr[0]	= '\0';
   nd_fr_doc_number.arr[0]		= '\0';
   nd_to_doc_number.arr[0]		= '\0';
   nd_fr_bill_date.arr[0]		= '\0';
   nd_to_bill_date.arr[0]		= '\0';
   nd_fr_blng_serv.arr[0]		= '\0';
   nd_to_blng_serv.arr[0]		= '\0';
   nd_report_type.arr[0]		= '\0';
   nd_report_opt.arr[0]			= '\0';
   nd_bill_nat.arr[0]			= '\0';


   nd_episode_type.len			=	0;
   nd_fr_pat_id.len				=	0;	
   nd_to_pat_id.len				=	0;	
   nd_fr_blng_grp.len			=	0;
   nd_to_blng_grp.len			=	0;
   nd_fr_cust_code.len			=	0;
   nd_to_cust_code.len			=	0;
   nd_fr_doc_type_code.len		=	0;
   nd_to_doc_type_code.len		=	0;
   nd_fr_doc_number.len			=	0;
   nd_to_doc_number.len			=	0;
   nd_fr_bill_date.len			=	0;
   nd_to_bill_date.len			=	0;
   nd_fr_blng_serv.len			=	0;
   nd_to_blng_serv.len			=	0;
   nd_report_type.len			=	0;
   nd_report_opt.len			=	0;
   nd_bill_nat.len				=	0;

  
   
   /* EXEC SQL SELECT PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6,PARAM7,
				   PARAM8,PARAM9,PARAM10,PARAM11,NVL(PARAM12,'01/01/1800'),
				   NVL(PARAM13,'31/12/4712'),
				   PARAM14,PARAM15,PARAM16,PARAM17, operating_facility_id
  	        INTO   :nd_episode_type,
				   :nd_fr_pat_id,
				   :nd_to_pat_id,
				   :nd_fr_blng_grp,
				   :nd_to_blng_grp,
				   :nd_fr_cust_code,
				   :nd_to_cust_code,
				   :nd_fr_doc_type_code,
				   :nd_to_doc_type_code,
				   :nd_fr_doc_number,
				   :nd_to_doc_number,
				   :nd_fr_bill_date,
				   :nd_to_bill_date,
				   :nd_fr_blng_serv,
				   :nd_to_blng_serv,
				   :nd_report_opt,
				   :nd_bill_nat,
				   :d_facility_id
	      FROM SY_PROG_PARAM
	      WHERE PGM_ID     = 'BLRBARCU'  AND 
		        SESSION_ID = :nd_session_id AND 
				PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 20;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PAR\
AM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,NVL(PARAM12,'01/01/1800') ,NVL(PARAM13,\
'31/12/4712') ,PARAM14 ,PARAM15 ,PARAM16 ,PARAM17 ,operating_facility_id into \
:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b1\
7  from SY_PROG_PARAM where ((PGM_ID='BLRBARCU' and SESSION_ID=:b18) and PGM_D\
ATE=:b19)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_episode_type;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fr_pat_id;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_to_pat_id;
   sqlstm.sqhstl[2] = (unsigned int  )23;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_fr_blng_grp;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_to_blng_grp;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fr_cust_code;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_fr_doc_type_code;
   sqlstm.sqhstl[7] = (unsigned int  )9;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_to_doc_type_code;
   sqlstm.sqhstl[8] = (unsigned int  )9;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_fr_doc_number;
   sqlstm.sqhstl[9] = (unsigned int  )11;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_to_doc_number;
   sqlstm.sqhstl[10] = (unsigned int  )11;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_fr_bill_date;
   sqlstm.sqhstl[11] = (unsigned int  )13;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_to_bill_date;
   sqlstm.sqhstl[12] = (unsigned int  )13;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_fr_blng_serv;
   sqlstm.sqhstl[13] = (unsigned int  )13;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_to_blng_serv;
   sqlstm.sqhstl[14] = (unsigned int  )13;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_report_opt;
   sqlstm.sqhstl[15] = (unsigned int  )4;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_bill_nat;
   sqlstm.sqhstl[16] = (unsigned int  )4;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[17] = (unsigned int  )12;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[18] = (unsigned int  )18;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[19] = (unsigned int  )37;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
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


   nd_episode_type.arr[nd_episode_type.len]			=	'\0';
   nd_fr_pat_id.arr[nd_fr_pat_id.len]				=	'\0';	
   nd_to_pat_id.arr[nd_to_pat_id.len]				=	'\0';	
   nd_fr_blng_grp.arr[nd_fr_blng_grp.len]			=	'\0';
   nd_to_blng_grp.arr[nd_to_blng_grp.len]			=	'\0';
   nd_fr_cust_code.arr[nd_fr_cust_code.len]			=	'\0';
   nd_to_cust_code.arr[nd_to_cust_code.len]			=	'\0';
   nd_fr_doc_type_code.arr[nd_fr_doc_type_code.len]	=	'\0';
   nd_to_doc_type_code.arr[nd_to_doc_type_code.len]	=	'\0';
   nd_fr_doc_number.arr[nd_fr_doc_number.len]		=	'\0';
   nd_to_doc_number.arr[nd_to_doc_number.len]		=	'\0';
   nd_fr_bill_date.arr[nd_fr_bill_date.len]			=	'\0';
   nd_to_bill_date.arr[nd_to_bill_date.len]			=	'\0';
   nd_fr_blng_serv.arr[nd_fr_blng_serv.len]			=	'\0';
   nd_to_blng_serv.arr[nd_to_blng_serv.len]			=	'\0';
   nd_report_type.arr[nd_report_type.len]			=	'\0';
   nd_report_opt.arr[nd_report_opt.len]				=	'\0';
   nd_bill_nat.arr[nd_bill_nat.len]					=	'\0';

   d_facility_id.arr[d_facility_id.len]				=	'\0';

   start_prog_msg();
   fetch_desc();

   print_summary();

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
		  WHERE PGM_ID     = 'BLRBARCU'
		    AND SESSION_ID = :nd_session_id
		    AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 20;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRBARCU' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )100;
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


   end_prog_msg();
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 20;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )123;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   return ;
}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )138;
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
      return(-1);
  return(0);
}

declare_cursors()
{

d_curs.arr[0] = '\0';
d_curs.len = 0;


/*--- Bill Header Cursor (Dynamic SQL) ---------------------------------*/

 strcpy(d_curs.arr,"SELECT DISTINCT BLNG_GRP_ID, REV_CUST_CODE, NVL(REV_CUST_CODE,'f') FROM BL_BILL_HDR WHERE ");

 strcat(d_curs.arr," DOC_TYPE_CODE BETWEEN  :nd_fr_doc_type_code and \
									  :nd_to_doc_type_code AND \
			   NVL(operating_facility_id ,'X') = :d_facility_id AND \
			   DOC_NUM    BETWEEN     :nd_fr_doc_number and \
									  :nd_to_doc_number AND \
			   TRUNC(DOC_DATE) BETWEEN to_date(:nd_fr_bill_date,'DD/MM/YYYY') and \
									   to_date(:nd_to_bill_date,'DD/MM/YYYY') AND \
				BLNG_GRP_ID BETWEEN    :nd_fr_blng_grp and \
									   :nd_to_blng_grp AND \
			   (REV_CUST_CODE IS NULL OR (REV_CUST_CODE IS NOT NULL AND \
			    REV_CUST_CODE BETWEEN      :nd_fr_cust_code and \
									  :nd_to_cust_code)) AND \
				PATIENT_ID BETWEEN     :nd_fr_pat_id and \
								      :nd_to_pat_id AND \
			   NVL(BILL_STATUS,'X')        != 'C' AND \
			   NVL(BILL_TRX_TYPE_CODE,'X') != 'I' ");

if (nd_episode_type.arr[0] != 'A')
	strcat(d_curs.arr," AND EPISODE_TYPE = :nd_episode_type ");
 
 if (nd_bill_nat.arr[0] != 'B')
 {
	 strcat(d_curs.arr," AND NVL(BILL_NATURE_CODE,'X') = :nd_bill_nat \
						ORDER BY BLNG_GRP_ID, REV_CUST_CODE ");
 }
 else
 {
	 strcat(d_curs.arr," ORDER BY BLNG_GRP_ID, REV_CUST_CODE ");
 }

 d_curs.len = strlen(d_curs.arr);

 /* EXEC SQL PREPARE BILL_HEADER_LIST FROM :d_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )169;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_curs;
 sqlstm.sqhstl[0] = (unsigned int  )3002;
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
	err_mesg("PREPARE failed on BILL_HEADER_LIST",0,"");

 /* EXEC SQL DECLARE BILL_HDR_CUR CURSOR FOR BILL_HEADER_LIST; */ 


 if(OERROR)
	err_mesg("DECLARE failed on BILL_HDR_CUR",0,"");

/*---------------------------------------------------------------------*/

if (nd_episode_type.arr[0] == 'A')
  {			
    if (g_cust_code.arr[0] != 'f')
	{
    /* EXEC SQL DECLARE FOLIO_CHG_CUR_1A CURSOR FOR    
			 SELECT  
				 A.REV_CUST_CODE,A.BLNG_GRP_ID,
				 SUBSTR(B.BLNG_SERV_CODE,1,2),
				 SUBSTR(B.BLNG_SERV_CODE,1,3),
				 B.BLNG_SERV_CODE,
				 B.ORG_GROSS_CHARGE_AMT,
				 B.ORG_DISC_AMT,
				 B.ORG_NET_CHARGE_AMT 
	     FROM    BL_BILL_HDR A,BL_PATIENT_CHARGES_FOLIO B
	     WHERE   A.DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE AND
				 A.DOC_NUM = B.BILL_DOC_NUM AND
				 A.BLNG_GRP_ID = :g_blng_grp_id AND
				 A.REV_CUST_CODE = :g_cust_code AND
			     A.PATIENT_ID BETWEEN     :nd_fr_pat_id and 
								          :nd_to_pat_id AND
			     A.DOC_TYPE_CODE BETWEEN  :nd_fr_doc_type_code and
									      :nd_to_doc_type_code AND
			     A.DOC_NUM    BETWEEN     :nd_fr_doc_number and
				  					      :nd_to_doc_number AND
			     TRUNC(A.DOC_DATE) BETWEEN to_date(:nd_fr_bill_date,'DD/MM/YYYY') and
									       to_date(:nd_to_bill_date,'DD/MM/YYYY') AND
			     B.BLNG_SERV_CODE BETWEEN :nd_fr_blng_serv and
									      :nd_to_blng_serv AND
				 NVL(B.PACKAGE_TRX_IND,'X') = 'N' AND
  			     NVL(A.BILL_STATUS,'X')        != 'C' AND
			     NVL(A.BILL_TRX_TYPE_CODE,'X') != 'I' AND
				 NVL(a.operating_facility_id,'X') = NVL(:d_facility_id,'X') AND
				 NVL(b.operating_facility_id,'X') = NVL(:d_facility_id,'X')
		 ORDER BY A.BLNG_GRP_ID,A.REV_CUST_CODE,B.BLNG_SERV_CODE; */ 

		}
		else
		{
		/* EXEC SQL   DECLARE FOLIO_CHG_CUR_2A CURSOR FOR    
		  SELECT  A.REV_CUST_CODE,A.BLNG_GRP_ID,
				 SUBSTR(B.BLNG_SERV_CODE,1,2),
				 SUBSTR(B.BLNG_SERV_CODE,1,3),
				 B.BLNG_SERV_CODE,
				 B.ORG_GROSS_CHARGE_AMT,
				 B.ORG_DISC_AMT,
				 B.ORG_NET_CHARGE_AMT 
	     FROM    BL_BILL_HDR A,BL_PATIENT_CHARGES_FOLIO B
	     WHERE   A.DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE AND
				 A.DOC_NUM = B.BILL_DOC_NUM AND 
				 A.BLNG_GRP_ID = :g_blng_grp_id AND
			     A.PATIENT_ID BETWEEN     :nd_fr_pat_id and 
								          :nd_to_pat_id AND
			     A.DOC_TYPE_CODE BETWEEN  :nd_fr_doc_type_code and
									      :nd_to_doc_type_code AND
			     A.DOC_NUM    BETWEEN     :nd_fr_doc_number and
				  					      :nd_to_doc_number AND
			     TRUNC(A.DOC_DATE) BETWEEN to_date(:nd_fr_bill_date,'DD/MM/YYYY') and
									       to_date(:nd_to_bill_date,'DD/MM/YYYY') AND
			     B.BLNG_SERV_CODE BETWEEN :nd_fr_blng_serv and
									      :nd_to_blng_serv AND
				 NVL(B.PACKAGE_TRX_IND,'X') = 'N' AND
  			     NVL(A.BILL_STATUS,'X')        != 'C' AND
			     NVL(A.BILL_TRX_TYPE_CODE,'X') != 'I' AND
				 NVL(a.operating_facility_id,'X') = NVL(:d_facility_id,'X') AND
				 NVL(b.operating_facility_id,'X') = NVL(:d_facility_id,'X')
		 ORDER BY A.BLNG_GRP_ID,A.REV_CUST_CODE,B.BLNG_SERV_CODE; */ 

		}
  }
  else
  {
    if (g_cust_code.arr[0] != 'f')
	{
      /* EXEC SQL   DECLARE FOLIO_CHG_CUR_1 CURSOR FOR    
	    SELECT  A.REV_CUST_CODE,A.BLNG_GRP_ID,
				 SUBSTR(B.BLNG_SERV_CODE,1,2),
				 SUBSTR(B.BLNG_SERV_CODE,1,3),
				 B.BLNG_SERV_CODE,
				 B.ORG_GROSS_CHARGE_AMT,
				 B.ORG_DISC_AMT,
				 B.ORG_NET_CHARGE_AMT 
	     FROM    BL_BILL_HDR A,BL_PATIENT_CHARGES_FOLIO B
	     WHERE   A.DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE AND
				 A.DOC_NUM = B.BILL_DOC_NUM AND
				 A.BLNG_GRP_ID = :g_blng_grp_id AND
				 A.REV_CUST_CODE = :g_cust_code AND
				 A.EPISODE_TYPE = :nd_episode_type AND
			     A.PATIENT_ID BETWEEN     :nd_fr_pat_id and 
								          :nd_to_pat_id AND
			     A.DOC_TYPE_CODE BETWEEN  :nd_fr_doc_type_code and
									      :nd_to_doc_type_code AND
			     A.DOC_NUM    BETWEEN     :nd_fr_doc_number and
				  					      :nd_to_doc_number AND
			     TRUNC(A.DOC_DATE) BETWEEN to_date(:nd_fr_bill_date,'DD/MM/YYYY') and
									       to_date(:nd_to_bill_date,'DD/MM/YYYY') AND
			     B.BLNG_SERV_CODE BETWEEN :nd_fr_blng_serv and
									      :nd_to_blng_serv AND
				 NVL(B.PACKAGE_TRX_IND,'X') = 'N' AND
  			     NVL(A.BILL_STATUS,'X')        != 'C' AND
			     NVL(A.BILL_TRX_TYPE_CODE,'X') != 'I' AND
				 NVL(a.operating_facility_id,'X') = NVL(:d_facility_id,'X') AND
				 NVL(b.operating_facility_id,'X') = NVL(:d_facility_id,'X')
		 ORDER BY A.BLNG_GRP_ID,A.REV_CUST_CODE,B.BLNG_SERV_CODE; */ 

	}
	else
	{
	     /* EXEC SQL   DECLARE FOLIO_CHG_CUR_2 CURSOR FOR    
		   SELECT  A.REV_CUST_CODE,A.BLNG_GRP_ID,
				 SUBSTR(B.BLNG_SERV_CODE,1,2),
				 SUBSTR(B.BLNG_SERV_CODE,1,3),
				 B.BLNG_SERV_CODE,
				 B.ORG_GROSS_CHARGE_AMT,
				 B.ORG_DISC_AMT,
				 B.ORG_NET_CHARGE_AMT 
	     FROM    BL_BILL_HDR A,BL_PATIENT_CHARGES_FOLIO B
	     WHERE   A.DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE AND
				 A.DOC_NUM = B.BILL_DOC_NUM AND
				 A.BLNG_GRP_ID = :g_blng_grp_id AND
				 A.EPISODE_TYPE = :nd_episode_type AND
			     A.PATIENT_ID BETWEEN     :nd_fr_pat_id and 
								          :nd_to_pat_id AND
			     A.DOC_TYPE_CODE BETWEEN  :nd_fr_doc_type_code and
									      :nd_to_doc_type_code AND
			     A.DOC_NUM    BETWEEN     :nd_fr_doc_number and
				  					      :nd_to_doc_number AND
			     TRUNC(A.DOC_DATE) BETWEEN to_date(:nd_fr_bill_date,'DD/MM/YYYY') and
									       to_date(:nd_to_bill_date,'DD/MM/YYYY') AND
			     B.BLNG_SERV_CODE BETWEEN :nd_fr_blng_serv and
									      :nd_to_blng_serv AND
				 NVL(B.PACKAGE_TRX_IND,'X') = 'N' AND
  			     NVL(A.BILL_STATUS,'X')        != 'C' AND
			     NVL(A.BILL_TRX_TYPE_CODE,'X') != 'I' AND
				 NVL(a.operating_facility_id,'X') = NVL(:d_facility_id,'X') AND
				 NVL(b.operating_facility_id,'X') = NVL(:d_facility_id,'X')
		 ORDER BY A.BLNG_GRP_ID,A.REV_CUST_CODE,B.BLNG_SERV_CODE; */ 

	}

  }
/*----------------------------------------------------------------------*/

    /* EXEC SQL DECLARE BL_BLNG_GRP_CUR CURSOR FOR
	     SELECT  LONG_DESC
	     FROM    BL_BLNG_GRP_LANG_VW
	     WHERE   BLNG_GRP_ID = :g_blng_grp_id
		 AND		language_id=:p_language_id; */ 


    /* EXEC SQL DECLARE CUSTOMER_CUR CURSOR FOR
	     SELECT  LONG_NAME
	     FROM    AR_CUSTOMER_LANG_VW
	     WHERE   CUST_CODE = :g_cust_code
		 AND		language_id=:p_language_id; */ 


    /* EXEC SQL DECLARE BL_BLNG_SERV_CUR CURSOR FOR
	     SELECT  LONG_DESC
	     FROM    BL_BLNG_SERV_LANG_VW
	     WHERE   BLNG_SERV_CODE = :d_blng_serv_code
		 AND		language_id=:p_language_id; */ 


	/* EXEC SQL DECLARE BL_BLNG_SERV_GRP_CUR CURSOR FOR
	     SELECT  LONG_DESC
	     FROM    BL_BLNG_SERV_GRP_LANG_VW
	     WHERE   SERV_GRP_CODE = :d_blng_serv_grp_code
		 AND		language_id=:p_language_id; */ 


    /* EXEC SQL DECLARE BL_BLNG_SERV_CLASFN_CUR CURSOR FOR
	     SELECT  LONG_DESC
	     FROM    BL_SERV_CLASSIFICATION_LANG_VW
	     WHERE   SERV_CLASSIFICATION_CODE = :d_blng_serv_clasfn_code
		 AND		language_id=:p_language_id; */ 



/*------------ Open the Prepared cursor Bill hdr and Folio ----------*/

if (nd_episode_type.arr[0] == 'A')
{

 if (nd_bill_nat.arr[0] != 'B')
 {
		/* EXEC SQL OPEN BILL_HDR_CUR USING
	             :nd_fr_doc_type_code,
				 :nd_to_doc_type_code,
				 :d_facility_id,
				 :nd_fr_doc_number,
				 :nd_to_doc_number,
				 :nd_fr_bill_date,
				 :nd_to_bill_date,
				 :nd_fr_blng_grp,
                 :nd_to_blng_grp,
                 :nd_fr_cust_code,
                 :nd_to_cust_code,
                 :nd_fr_pat_id,
				 :nd_to_pat_id,
				 :nd_bill_nat; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )188;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_fr_doc_type_code;
  sqlstm.sqhstl[0] = (unsigned int  )9;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )12;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_fr_doc_number;
  sqlstm.sqhstl[3] = (unsigned int  )11;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_number;
  sqlstm.sqhstl[4] = (unsigned int  )11;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fr_bill_date;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_bill_date;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fr_blng_grp;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_blng_grp;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_fr_cust_code;
  sqlstm.sqhstl[9] = (unsigned int  )11;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_to_cust_code;
  sqlstm.sqhstl[10] = (unsigned int  )11;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_fr_pat_id;
  sqlstm.sqhstl[11] = (unsigned int  )23;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_to_pat_id;
  sqlstm.sqhstl[12] = (unsigned int  )23;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_bill_nat;
  sqlstm.sqhstl[13] = (unsigned int  )4;
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


 }
 else
 {
		/* EXEC SQL OPEN BILL_HDR_CUR USING
				 :nd_fr_doc_type_code,
				 :nd_to_doc_type_code,
				 :d_facility_id,
				 :nd_fr_doc_number,
				 :nd_to_doc_number,
				 :nd_fr_bill_date,
				 :nd_to_bill_date,
				 :nd_fr_blng_grp,
                 :nd_to_blng_grp,
                 :nd_fr_cust_code,
                 :nd_to_cust_code,
                 :nd_fr_pat_id,
				 :nd_to_pat_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
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
  sqlstm.sqhstv[0] = (         void  *)&nd_fr_doc_type_code;
  sqlstm.sqhstl[0] = (unsigned int  )9;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )12;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_fr_doc_number;
  sqlstm.sqhstl[3] = (unsigned int  )11;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_number;
  sqlstm.sqhstl[4] = (unsigned int  )11;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fr_bill_date;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_bill_date;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fr_blng_grp;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_blng_grp;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_fr_cust_code;
  sqlstm.sqhstl[9] = (unsigned int  )11;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_to_cust_code;
  sqlstm.sqhstl[10] = (unsigned int  )11;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_fr_pat_id;
  sqlstm.sqhstl[11] = (unsigned int  )23;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_to_pat_id;
  sqlstm.sqhstl[12] = (unsigned int  )23;
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



 }
}
else
{
 if (nd_bill_nat.arr[0] != 'B')
 {
		/* EXEC SQL OPEN BILL_HDR_CUR USING
                 :nd_fr_doc_type_code,
				 :nd_to_doc_type_code,
				 :d_facility_id,
				 :nd_fr_doc_number,
				 :nd_to_doc_number,
				 :nd_fr_bill_date,
				 :nd_to_bill_date,
				 :nd_fr_blng_grp,
                 :nd_to_blng_grp,
                 :nd_fr_cust_code,
                 :nd_to_cust_code,
				 :nd_fr_pat_id,
				 :nd_to_pat_id,
	             :nd_episode_type,
				 :nd_bill_nat; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )326;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_fr_doc_type_code;
  sqlstm.sqhstl[0] = (unsigned int  )9;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )12;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_fr_doc_number;
  sqlstm.sqhstl[3] = (unsigned int  )11;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_number;
  sqlstm.sqhstl[4] = (unsigned int  )11;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fr_bill_date;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_bill_date;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fr_blng_grp;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_blng_grp;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_fr_cust_code;
  sqlstm.sqhstl[9] = (unsigned int  )11;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_to_cust_code;
  sqlstm.sqhstl[10] = (unsigned int  )11;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_fr_pat_id;
  sqlstm.sqhstl[11] = (unsigned int  )23;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_to_pat_id;
  sqlstm.sqhstl[12] = (unsigned int  )23;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[13] = (unsigned int  )4;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_bill_nat;
  sqlstm.sqhstl[14] = (unsigned int  )4;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
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
		/* EXEC SQL OPEN BILL_HDR_CUR USING
				 :nd_fr_doc_type_code,
				 :nd_to_doc_type_code,
				 :d_facility_id,
				 :nd_fr_doc_number,
				 :nd_to_doc_number,
				 :nd_fr_bill_date,
				 :nd_to_bill_date,
				 :nd_fr_blng_grp,
                 :nd_to_blng_grp,
                 :nd_fr_cust_code,
                 :nd_to_cust_code,
				 :nd_fr_pat_id,
				 :nd_to_pat_id,
	             :nd_episode_type; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )401;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_fr_doc_type_code;
  sqlstm.sqhstl[0] = (unsigned int  )9;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_to_doc_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )12;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_fr_doc_number;
  sqlstm.sqhstl[3] = (unsigned int  )11;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_number;
  sqlstm.sqhstl[4] = (unsigned int  )11;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_fr_bill_date;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_to_bill_date;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fr_blng_grp;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_blng_grp;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_fr_cust_code;
  sqlstm.sqhstl[9] = (unsigned int  )11;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_to_cust_code;
  sqlstm.sqhstl[10] = (unsigned int  )11;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_fr_pat_id;
  sqlstm.sqhstl[11] = (unsigned int  )23;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_to_pat_id;
  sqlstm.sqhstl[12] = (unsigned int  )23;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[13] = (unsigned int  )4;
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


  }
} 

if(OERROR)
	err_mesg("OPEN failed on cursor TRANS_LIST_CUR",0,"");

/*-------------------------------------------------------------------*/

}


print_summary()
{

pno = 1;
fetch_legend_value();
open_files();

/** for printing in A4 size landsacpe  given by vani**/
fprintf(fp,"%c&l1O",ESC);   /* To Print Landscape           */
fprintf(fp,"%c&a7L",ESC); 	/* To Set the Left margin  		*/
fprintf(fp,"%c(s14H",ESC); 	/* To set the font size			*/


print_title();
declare_cursors();
g_first_bgrp = 1;


/*-- Fetch distinct Blng grp id/Customer from bl_bill_hdr table */

while(fetch_bl_bill_hdr()) 
{
		
		/*-- Check any folio record available for blng grp / Customer */		

		check_folio_record();
		if (cnt == 0)
			continue; 

		/*-- Billing Group Total */

		if (g_first_bgrp == 0)
		{
			strcpy(d_blng_grp_id.arr,g_blng_grp_id.arr);
			g_first_bgrp = 0;
		}
		
		if(strcmp(g_blng_grp_id.arr,d_blng_grp_id.arr)) 
		{
				if (c_gross_amt != 0 || c_disc_amt != 0 || c_net_amt != 0)
				{
					/*-- Print the Billing Group total */
					print_break_blng_grp();
					c_gross_amt = 0;
					c_disc_amt  = 0;
					c_net_amt   = 0;
				}
 		}
		

		fetch_blng_grp_desc();
		if (g_cust_code.arr[0] != 'f')
				fetch_customer_name();
		print_page_head();		

		/*-- Open Folio Cursor --------------------------*/	    				
		if (nd_episode_type.arr[0] == 'A')
		{			
			if (g_cust_code.arr[0] != 'f')
				/* EXEC SQL OPEN FOLIO_CHG_CUR_1A; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )472;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&g_blng_grp_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&g_cust_code;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fr_pat_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_pat_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_fr_doc_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_type_code;
    sqlstm.sqhstl[5] = (unsigned int  )9;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_fr_doc_number;
    sqlstm.sqhstl[6] = (unsigned int  )11;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_to_doc_number;
    sqlstm.sqhstl[7] = (unsigned int  )11;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_fr_bill_date;
    sqlstm.sqhstl[8] = (unsigned int  )13;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_to_bill_date;
    sqlstm.sqhstl[9] = (unsigned int  )13;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_fr_blng_serv;
    sqlstm.sqhstl[10] = (unsigned int  )13;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_to_blng_serv;
    sqlstm.sqhstl[11] = (unsigned int  )13;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[12] = (unsigned int  )12;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[13] = (unsigned int  )12;
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


			else
				/* EXEC SQL OPEN FOLIO_CHG_CUR_2A; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )543;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&g_blng_grp_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_fr_pat_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_pat_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fr_doc_type_code;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_fr_doc_number;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_number;
    sqlstm.sqhstl[6] = (unsigned int  )11;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_fr_bill_date;
    sqlstm.sqhstl[7] = (unsigned int  )13;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_to_bill_date;
    sqlstm.sqhstl[8] = (unsigned int  )13;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_fr_blng_serv;
    sqlstm.sqhstl[9] = (unsigned int  )13;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_to_blng_serv;
    sqlstm.sqhstl[10] = (unsigned int  )13;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[11] = (unsigned int  )12;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[12] = (unsigned int  )12;
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


		}
		else
		{
			if (g_cust_code.arr[0] != 'f')
				/* EXEC SQL OPEN FOLIO_CHG_CUR_1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )610;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&g_blng_grp_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&g_cust_code;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fr_pat_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_pat_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_fr_doc_type_code;
    sqlstm.sqhstl[5] = (unsigned int  )9;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_type_code;
    sqlstm.sqhstl[6] = (unsigned int  )9;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_fr_doc_number;
    sqlstm.sqhstl[7] = (unsigned int  )11;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_to_doc_number;
    sqlstm.sqhstl[8] = (unsigned int  )11;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_fr_bill_date;
    sqlstm.sqhstl[9] = (unsigned int  )13;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_to_bill_date;
    sqlstm.sqhstl[10] = (unsigned int  )13;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_fr_blng_serv;
    sqlstm.sqhstl[11] = (unsigned int  )13;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_to_blng_serv;
    sqlstm.sqhstl[12] = (unsigned int  )13;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[13] = (unsigned int  )12;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[14] = (unsigned int  )12;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
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


			else
				/* EXEC SQL OPEN FOLIO_CHG_CUR_2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )685;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&g_blng_grp_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fr_pat_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_pat_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_fr_doc_type_code;
    sqlstm.sqhstl[4] = (unsigned int  )9;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_type_code;
    sqlstm.sqhstl[5] = (unsigned int  )9;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_fr_doc_number;
    sqlstm.sqhstl[6] = (unsigned int  )11;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_to_doc_number;
    sqlstm.sqhstl[7] = (unsigned int  )11;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_fr_bill_date;
    sqlstm.sqhstl[8] = (unsigned int  )13;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_to_bill_date;
    sqlstm.sqhstl[9] = (unsigned int  )13;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_fr_blng_serv;
    sqlstm.sqhstl[10] = (unsigned int  )13;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_to_blng_serv;
    sqlstm.sqhstl[11] = (unsigned int  )13;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[12] = (unsigned int  )12;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[13] = (unsigned int  )12;
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


		}

		if(OERROR)
				err_mesg("OPEN failed on cursor FOLIO_CHG_CUR",0,"");


		/*-- Fetch folio Records ----------------------*/

		g_first_break = 1;

		/*-- Fetch folio records for blng grp id / Customer -----*/

		while(fetch_folio()) 
		{
			if (g_first_break)
			{
					
  			   if(nd_report_opt.arr[0] == 'G')
					strcpy(g_blng_serv_grp_code.arr,d_blng_serv_grp_code.arr);
			   else if (nd_report_opt.arr[0] == 'C')
					strcpy(g_blng_serv_clasfn_code.arr,d_blng_serv_clasfn_code.arr);
			   else 
					strcpy(g_blng_serv_code.arr,d_blng_serv_code.arr);
			   
			   g_first_break = 0;
			}

			/* -- Print Serv Grp / Clasfn / Service Break Total */
			if(nd_report_opt.arr[0] == 'G')
			{
				if(strcmp(g_blng_serv_grp_code.arr,d_blng_serv_grp_code.arr)) 
				{
					print_break_serv_grp();
					strcpy(g_blng_serv_grp_code.arr,d_blng_serv_grp_code.arr);
					g_gross_amt += b_gross_amt;
					g_disc_amt  += b_disc_amt;
					g_net_amt   += b_net_amt;
					b_gross_amt = 0;
					b_disc_amt  = 0;
					b_net_amt   = 0;
				}
			}
			else if (nd_report_opt.arr[0] == 'C')
			{
				if(strcmp(g_blng_serv_clasfn_code.arr,d_blng_serv_clasfn_code.arr)) 
				{
					print_break_serv_clasfn();
					strcpy(g_blng_serv_clasfn_code.arr,d_blng_serv_clasfn_code.arr);
					g_gross_amt += b_gross_amt;
					g_disc_amt  += b_disc_amt;
					g_net_amt   += b_net_amt;
					b_gross_amt = 0;
					b_disc_amt  = 0;
					b_net_amt   = 0;
				}
			}
			else 
			{
				if(strcmp(g_blng_serv_code.arr,d_blng_serv_code.arr)) 
				{
					
					print_break_blng_serv();
					strcpy(g_blng_serv_code.arr,d_blng_serv_code.arr);
					g_gross_amt += b_gross_amt;
					g_disc_amt  += b_disc_amt;
					g_net_amt   += b_net_amt;
					b_gross_amt = 0;
					b_disc_amt  = 0;
					b_net_amt   = 0;
				}
			}

			/*-- To record the code and description of every folio record */
			if(nd_report_opt.arr[0] == 'G')
			{
				fetch_blng_serv_grp_desc();
				strcpy(xx_grp_id.arr,d_blng_serv_grp_code.arr);
				strcpy(xx_grp_desc.arr,d_blng_serv_grp_desc.arr);
			}
			else if (nd_report_opt.arr[0] == 'C')
			{
				fetch_blng_serv_clasfn_desc();
				strcpy(xx_clasfn_id.arr,d_blng_serv_clasfn_code.arr);
				strcpy(xx_clasfn_desc.arr,d_blng_serv_clasfn_desc.arr);
			}
			else 
			{
				fetch_blng_serv_desc();
				strcpy(xx_serv_id.arr,d_blng_serv_code.arr);
				strcpy(xx_serv_desc.arr,d_blng_serv_desc.arr);
			}

			
		    b_gross_amt += d_gross_amt;
	        b_disc_amt  += d_disc_amt;
	        b_net_amt   += d_net_amt;
	    
	   } 
		g_gross_amt += b_gross_amt;
		g_disc_amt  += b_disc_amt;
		g_net_amt   += b_net_amt;
		
		/*-- Print Blng grp total */
		if (g_gross_amt != 0 || g_disc_amt != 0 || g_net_amt != 0)
		{

			/*-- Print the final row belongs to the present blng grp.*/
			if(nd_report_opt.arr[0] == 'G')
				print_break_serv_grp();
			else if (nd_report_opt.arr[0] == 'C')
				print_break_serv_clasfn();
			else 
				print_break_blng_serv();
				
			/*-- Print the Present Customer total */
			if (g_cust_code.arr[0] != 'f')
				print_break_cust_code();
			else
				print_break_cash_pat();
		}
		b_gross_amt = 0;
		b_disc_amt  = 0;
		b_net_amt   = 0;
		c_gross_amt += g_gross_amt;
		c_disc_amt  += g_disc_amt;
		c_net_amt   += g_net_amt;
		g_gross_amt = 0;
		g_disc_amt  = 0;
		g_net_amt   = 0;

		strcpy(d_blng_grp_id.arr,g_blng_grp_id.arr);

		if (nd_episode_type.arr[0] == 'A')
		{			
			if (g_cust_code.arr[0] != 'f')
				/* EXEC SQL CLOSE FOLIO_CHG_CUR_1A; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )756;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			else
				/* EXEC SQL CLOSE FOLIO_CHG_CUR_2A; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )771;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		}
		else
		{
			if (g_cust_code.arr[0] != 'f')
				/* EXEC SQL CLOSE FOLIO_CHG_CUR_1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )786;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			else
				/* EXEC SQL CLOSE FOLIO_CHG_CUR_2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )801;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		}

} 
print_end();
fflush(fp);
fclose(fp);
return 1;
}

open_files()
{
  strcpy(filename,WORKING_DIR);
  strcat(filename,"blrbarcs.lis");
   
   if ((fp = fopen(filename,"w")) == NULL)
   {
	err_mesg("\nError while opening File blrbarcs.lis\n",0,"");
	proc_exit();
   }

}

fetch_bl_bill_hdr()
{
	g_cust_code.arr[0]       = '\0';
	g_cust_code_1.arr[0]     = '\0';
	g_blng_grp_id.arr[0]     = '\0';

	g_cust_code.len          = 0;
	g_cust_code_1.len        = 0;
	g_blng_grp_id.len        = 0;

	/* EXEC SQL FETCH BILL_HDR_CUR INTO 
		       :g_blng_grp_id,
			   :g_cust_code_1,
			   :g_cust_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )816;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&g_blng_grp_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&g_cust_code_1;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&g_cust_code;
 sqlstm.sqhstl[2] = (unsigned int  )11;
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
			err_mesg("FETCH failed on cursor BILL_HDR_CUR",0,"");
	
    
	if(NO_DATA_FOUND)
	    return 0;
    
	g_cust_code.arr[g_cust_code.len]            = '\0';
	g_blng_grp_id.arr[g_blng_grp_id.len]        = '\0';
	g_cust_code_1.arr[g_cust_code_1.len]        = '\0';
	return 1;
}



fetch_folio()
{
    d_cust_code.arr[0]				  = '\0';
	d_blng_grp_id.arr[0]			  = '\0';
	d_blng_serv_grp_code.arr[0]       = '\0';
    d_blng_serv_clasfn_code.arr[0]    = '\0';
    d_blng_serv_code.arr[0]           = '\0';

    d_blng_grp_id.len			 = 0;
	d_cust_code.len				 = 0;
	d_blng_serv_grp_code.len     = 0;
    d_blng_serv_clasfn_code.len  = 0;
    d_blng_serv_code.len         = 0;
    
    d_gross_amt     = 0;
    d_disc_amt      = 0;
    d_net_amt       = 0;

/*------------------------------------------------------------------*/

	if (nd_episode_type.arr[0] == 'A')
	{			
			if (g_cust_code.arr[0] != 'f')
			{
				/* EXEC SQL FETCH FOLIO_CHG_CUR_1A
			    INTO  :d_cust_code,
			   :d_blng_grp_id,
			   :d_blng_serv_grp_code,
		       :d_blng_serv_clasfn_code,
		       :d_blng_serv_code,
		       :d_gross_amt,
		       :d_disc_amt,
		       :d_net_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )843;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_code;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_blng_serv_grp_code;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_clasfn_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_gross_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_disc_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_net_amt;
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


			}
			else
			{
				/* EXEC SQL FETCH FOLIO_CHG_CUR_2A
				INTO  :d_cust_code,
			   :d_blng_grp_id,
			   :d_blng_serv_grp_code,
		       :d_blng_serv_clasfn_code,
		       :d_blng_serv_code,
		       :d_gross_amt,
		       :d_disc_amt,
		       :d_net_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )890;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_code;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_blng_serv_grp_code;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_clasfn_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_gross_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_disc_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_net_amt;
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


			}
	}
	else
	{
			if (g_cust_code.arr[0] != 'f')
			{
				/* EXEC SQL FETCH FOLIO_CHG_CUR_1
			    INTO  :d_cust_code,
			   :d_blng_grp_id,
			   :d_blng_serv_grp_code,
		       :d_blng_serv_clasfn_code,
		       :d_blng_serv_code,
		       :d_gross_amt,
		       :d_disc_amt,
		       :d_net_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )937;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_code;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_blng_serv_grp_code;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_clasfn_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_gross_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_disc_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_net_amt;
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


			}
			else
			{
				/* EXEC SQL FETCH FOLIO_CHG_CUR_2
				INTO  :d_cust_code,
			   :d_blng_grp_id,
			   :d_blng_serv_grp_code,
		       :d_blng_serv_clasfn_code,
		       :d_blng_serv_code,
		       :d_gross_amt,
		       :d_disc_amt,
		       :d_net_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )984;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_code;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_blng_serv_grp_code;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_clasfn_code;
    sqlstm.sqhstl[3] = (unsigned int  )6;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_gross_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_disc_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_net_amt;
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


			}
	}

/*------------------------------------------------------------------*/

	if(OERROR)
		  err_mesg("FETCH failed on cursor FOLIO_CHG_CUR",0,"");

    if(NO_DATA_FOUND)
	  	  return 0;
	

    d_cust_code.arr[d_cust_code.len]						 = '\0';
	d_blng_grp_id.arr[d_blng_grp_id.len]				     = '\0';
	d_blng_serv_grp_code.arr[d_blng_serv_grp_code.len]       = '\0';
    d_blng_serv_clasfn_code.arr[d_blng_serv_clasfn_code.len] = '\0';
    d_blng_serv_code.arr[d_blng_serv_code.len]               = '\0';

    return 1;
}

fetch_blng_grp_desc()
{

    /* EXEC SQL OPEN BL_BLNG_GRP_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0010;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1031;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&g_blng_grp_id;
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
		err_mesg("OPEN failed on cursor BL_BLNG_GRP_CUR",0,"");

    g_blng_grp_desc.arr[0] = '\0';

    /* EXEC SQL FETCH BL_BLNG_GRP_CUR INTO
		   :g_blng_grp_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1054;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&g_blng_grp_desc;
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
		err_mesg("FETCH failed on cursor BL_BLNG_GRP_CUR",0,"");

    g_blng_grp_desc.arr[g_blng_grp_desc.len] = '\0';

}


fetch_blng_serv_grp_desc()
{

    /* EXEC SQL OPEN BL_BLNG_SERV_GRP_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0013;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1073;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_grp_code;
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
		err_mesg("OPEN failed on cursor BL_BLNG_SERV_GRP_CUR",0,"");

    d_blng_serv_grp_desc.arr[0] = '\0';

    /* EXEC SQL FETCH BL_BLNG_SERV_GRP_CUR INTO
		   :d_blng_serv_grp_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1096;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_grp_desc;
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
		err_mesg("FETCH failed on cursor BL_BLNG_SERV_GRP_CUR",0,"");

    d_blng_serv_grp_desc.arr[d_blng_serv_grp_desc.len] = '\0';
}


fetch_blng_serv_clasfn_desc()
{

    /* EXEC SQL OPEN BL_BLNG_SERV_CLASFN_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0014;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1115;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_clasfn_code;
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
		err_mesg("OPEN failed on cursor BL_BLNG_SERV_CLASFN_CUR",0,"");

    d_blng_serv_clasfn_desc.arr[0] = '\0';

    /* EXEC SQL FETCH BL_BLNG_SERV_CLASFN_CUR INTO
		   :d_blng_serv_clasfn_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1138;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_clasfn_desc;
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
		err_mesg("FETCH failed on cursor BL_BLNG_SERV_CLASFN_CUR",0,"");

    d_blng_serv_clasfn_desc.arr[d_blng_serv_clasfn_desc.len] = '\0';

}


fetch_blng_serv_desc()
{

    /* EXEC SQL OPEN BL_BLNG_SERV_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0012;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1157;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
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
		err_mesg("OPEN failed on cursor BL_BLNG_SERV_CUR",0,"");

    d_blng_serv_desc.arr[0] = '\0';

    /* EXEC SQL FETCH BL_BLNG_SERV_CUR INTO
		   :d_blng_serv_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1180;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_desc;
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
		err_mesg("FETCH failed on cursor BL_BLNG_SERV_CUR",0,"");

    d_blng_serv_desc.arr[d_blng_serv_desc.len] = '\0';

}

fetch_customer_name()
{

    /* EXEC SQL OPEN CUSTOMER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0011;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1199;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&g_cust_code;
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

    g_cust_name.arr[0] = '\0';

    /* EXEC SQL FETCH CUSTOMER_CUR INTO
		   :g_cust_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1222;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&g_cust_name;
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
		err_mesg("FETCH failed on cursor CUSTOMER_CUR",0,"");

    g_cust_name.arr[g_cust_name.len] = '\0';

}


print_title()
{
	  init_date_temp_var();                           
	  strcpy(date_convert.arr,date_time.arr);   
	  fun_change_loc_date();
 /* fprintf(fp, "\n\n%-5.5s : %-2.2s %39s %-30s %34s  %-16s\n",loc_legend[10],loc_legend[390],
      " ", hosp_name.arr," ", date_convert.arr);
	  commented by saikiran
	  */

	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[10]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"\n\n%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"\n\n%-5.5s : ",loc_legend[10]);
        }

	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[390]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s %39s ",nd_desc_with_spl_chr.arr," ");				
																																																					
	}
	else
	   {
         fprintf(fp,"%-2.2s %39s ",loc_legend[390]," ");
        }

	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-36.36s",hosp_name.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-36.36s %34s  ",nd_desc_with_spl_chr.arr," ");				
																																																					
	}
	else
	   {
         fprintf(fp,"%-30s %34s  ",hosp_name.arr," ");
        }

         fprintf(fp,"%-16s\n",date_convert.arr);


 /* fprintf(fp, "%-5.5s : %-10s                      %s\n",loc_legend[20],
     user_id.arr,loc_legend[30]);
     commented by saikiran */

	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[20]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[20]);
        }

	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10s                      ",user_id.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10s                      ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10s                      ",user_id.arr);
        }
	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-50.50s",loc_legend[30]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-50.50s\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%s\n",loc_legend[30]);
        }

 /* fprintf(fp, "%-5.5s : %-8s %26s  %-28s %39s   %-5.5s : %4d\n",loc_legend[400],loc_legend[50],
     " ", "                              ", " ",loc_legend[40], pno);
     COMMENTED BY SAIKIRAN */


	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[400]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[400]);
        }
	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-9.9s",loc_legend[50]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-9.9s ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-8s ",loc_legend[50]);
        }

		fprintf(fp,"%26s  %-28s %39s   "," ", "                              ", " ");

	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[40]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : %4d\n",nd_desc_with_spl_chr.arr,pno);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : %4d\n",loc_legend[40],pno);
        }



  
  pno++;

  fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
  //fprintf(fp,"VER : 4.1\n");
  	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-4.4s",loc_legend[460]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-4.4s :4.1\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-4.4s :4.1\n",loc_legend[460]);
        }

  fflush(fp);

  //fprintf(fp,"\n\n        %-15.15s \n        ----------------\n\n",loc_legend[60]);
  	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-17.17s",loc_legend[60]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"\n\n        %-17.17s \n        ----------------\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"\n\n        %-15.15s \n        ----------------\n\n",loc_legend[60]);
        }


  
  if (nd_episode_type.arr[0] == 'I')
  {
    //fprintf(fp," %14s %-25.25s     : %s\n\n"," ",loc_legend[70], loc_legend[80]);
	  	  fprintf(fp," %14s "," ");
		  
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[70]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s        : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-25.25s     : ",loc_legend[70]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[80]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s\n\n",loc_legend[80]);
        }
	}
  else if (nd_episode_type.arr[0] == 'D')
  {
   // fprintf(fp," %14s %-25.25s     : %s\n\n"," ",loc_legend[70], loc_legend[90]);
	  	  fprintf(fp," %14s "," ");
		  
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[70]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s        : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-25.25s     : ",loc_legend[70]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[90]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s\n\n",loc_legend[90]);
        }

   }
  else if (nd_episode_type.arr[0] == 'O')
   {
    //fprintf(fp," %14s %-25.25s     : %s\n\n"," ",loc_legend[70], loc_legend[100]);
	  	  fprintf(fp," %14s "," ");
		  
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[70]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s        : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-25.25s     : ",loc_legend[70]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-11.11s",loc_legend[100]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-11.11s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-11.11s\n\n",loc_legend[100]);
        }

	}
  else if (nd_episode_type.arr[0] == 'E')
    {
	 //fprintf(fp," %14s %-25.25s     : %s\n\n"," ",loc_legend[70], loc_legend[110]);
  	  fprintf(fp," %14s "," ");
		  
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[70]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s        : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-25.25s     : ",loc_legend[70]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[110]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s\n\n",loc_legend[110]);
        }
	 }
  else if (nd_episode_type.arr[0] == 'R')
  {
   // fprintf(fp," %14s %-25.25s     : %s\n\n"," ",loc_legend[70], loc_legend[120]);
	  fprintf(fp," %14s "," ");
		  
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[70]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s        : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-25.25s     : ",loc_legend[70]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-20.20s",loc_legend[120]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-20.20s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-20.20s\n\n",loc_legend[120]);
        }
   }
  else 
  {
   // fprintf(fp," %14s %-25.25s     : %s\n\n"," ",loc_legend[70], loc_legend[130]);

	  fprintf(fp," %14s "," ");
		  
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[70]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s        : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-25.25s     : ",loc_legend[70]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[130]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s\n\n",loc_legend[130]);
        }
   }
  

  if ((strcmp(nd_fr_pat_id.arr,"!!!!!!!!!!") == 0) && (strcmp(nd_to_pat_id.arr,"~~~~~~~~~~") == 0))
  {
	//fprintf(fp," %14s %-22.22s  %-5.5s : %-10s\n"," ",loc_legend[140],loc_legend[150], loc_legend[170]);              
	
		fprintf(fp," %14s "," ");
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[140]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-25.25s  ",loc_legend[140]);
        }

		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }


		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[170]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10s\n",loc_legend[170]);
        }

	//fprintf(fp," %14s                         %-3.3s   : %-10s\n\n"," ",loc_legend[160],loc_legend[410]);            
      fprintf(fp," %14s                          "," ");
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[410]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10s\n\n",loc_legend[410]);
        }

  }
  else
  {     
	//fprintf(fp," %14s %-22.22s  %-5.5s : %-10s\n"," ",loc_legend[140],loc_legend[150],nd_fr_pat_id.arr); 
		fprintf(fp," %14s "," ");
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[140]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-25.25s  ",loc_legend[140]);
        }

		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }


         fprintf(fp,"%-10s\n",nd_fr_pat_id.arr);
      

	//fprintf(fp," %14s                         %-3.3s   : %-10s\n\n"," ",loc_legend[160],nd_to_pat_id.arr); 
	fprintf(fp," %14s                         "," ");
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }

         fprintf(fp,"%-10s\n\n",nd_to_pat_id.arr);
      

  }  


  if ((strcmp(nd_fr_blng_grp.arr,"!!") == 0) && (strcmp(nd_to_blng_grp.arr,"~~") == 0))
  {
	//fprintf(fp," %14s %-22.22s  %-5.5s : %-10s\n"," ",loc_legend[180],loc_legend[150], loc_legend[170]);              
	 fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[180]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s  ",loc_legend[180]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }

	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[170]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10s\n",loc_legend[170]);
        }

	//fprintf(fp," %14s                         %-3.3s   : %-10s\n\n"," ",loc_legend[160],loc_legend[410]);            
	fprintf(fp," %14s                          "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[410]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10s\n\n",loc_legend[410]);
        }
  }
  else
  {     
	//fprintf(fp," %14s %-22.22s  %-5.5s : %-3s\n"," ",loc_legend[180],loc_legend[150],nd_fr_blng_grp.arr); 
fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[180]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s  ",loc_legend[180]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }

	fprintf(fp,"%-3s\n",nd_fr_blng_grp.arr);


	//fprintf(fp," %14s                         %-3.3s   : %-3s\n\n"," ",loc_legend[160],nd_to_blng_grp.arr); 
fprintf(fp," %14s                          "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }
 
         fprintf(fp,"%-3s\n\n",nd_to_blng_grp.arr);
         
  }


  if ((strcmp(nd_fr_cust_code.arr,"!!!!!!!!") == 0) && (strcmp(nd_to_cust_code.arr,"~~~~~~~~") == 0))
  {
	//fprintf(fp," %14s %-22.22s  %-5.5s : %-10s\n"," ",loc_legend[190],loc_legend[150],loc_legend[170]);              
	fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[190]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s  ",loc_legend[190]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }

	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[170]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s\n",loc_legend[170]);
        }

	//fprintf(fp," %14s                         %-3.3s   : %-10s\n\n"," ",loc_legend[160],loc_legend[410]);            
	fprintf(fp," %14s                          "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[410]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s\n\n",loc_legend[410]);
        }

  }
  else
  {     
	//fprintf(fp," %14s %-22.22s  %-5.5s : %-8s\n"," ",loc_legend[190],loc_legend[150],nd_fr_cust_code.arr); 
    fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[190]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s  ",loc_legend[190]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }

		fprintf(fp,"%-11.11s\n",nd_fr_cust_code.arr);

//	fprintf(fp," %14s                         %-3.3s   : %-8s\n\n"," ",loc_legend[160],nd_to_cust_code.arr); 
		fprintf(fp," %14s                          "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }
		fprintf(fp,"%-11.11s\n\n",nd_to_cust_code.arr);

  }

  if ((strcmp(nd_fr_doc_type_code.arr,"!!!!!!") == 0) && (strcmp(nd_to_doc_type_code.arr,"~~~~~~") == 0))
  {
//	fprintf(fp," %14s %-22.22s  %-5.5s : %-10s\n"," ",loc_legend[200],loc_legend[150],loc_legend[170]);              
	fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[200]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s  ",loc_legend[200]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }

	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[170]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10s\n",loc_legend[170]);
        }

	//fprintf(fp," %14s                         %-3.3s   : %-10s\n\n"," ",loc_legend[160],loc_legend[410]);            
      fprintf(fp," %14s                          "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[410]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10s\n\n",loc_legend[410]);
        }

  }
  else
  {     
	//fprintf(fp," %14s %-22.22s  %-5.5s : %-6s\n"," ",loc_legend[200],loc_legend[150],nd_fr_doc_type_code.arr); 
	fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[200]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s  ",loc_legend[200]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-8.8s",nd_fr_doc_type_code.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-8.8s\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-6s\n",nd_fr_doc_type_code.arr);
        }


	//fprintf(fp," %14s                         %-3.3s   : %-6s\n\n"," ",loc_legend[160],nd_to_doc_type_code.arr); 
      fprintf(fp," %14s                          "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-8.8s",nd_to_doc_type_code.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-8.8s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-6s\n\n",nd_to_doc_type_code.arr);
        }

  }
									   
  if ((strcmp(nd_fr_doc_number.arr,"0") == 0) && (strcmp(nd_to_doc_number.arr,"99999999") == 0))
  {
	//fprintf(fp," %14s %-22.22s  %-5.5s : %-10s\n"," ", loc_legend[210],loc_legend[150],loc_legend[170]);              
      fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[210]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s  ",loc_legend[210]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[170]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10s\n",loc_legend[170]);
        }


	//fprintf(fp," %14s                         %-3.3s   : %-10s\n\n"," ",loc_legend[160],loc_legend[410]);            
	fprintf(fp," %14s                          "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[410]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s\n\n",loc_legend[410]);
        }

  }
  else
  {     
	//fprintf(fp," %14s %-22.22s  %-5.5s : %-8s\n"," ",loc_legend[210],loc_legend[150],nd_fr_doc_number.arr); 
	 fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[210]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s  ",loc_legend[210]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-11.11s\n",nd_fr_doc_number.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-11.11s\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-8s\n",nd_fr_doc_number.arr);
        }

	//fprintf(fp," %14s                         %-3.3s   : %-8s\n\n"," ",loc_legend[160],nd_to_doc_number.arr); 
	fprintf(fp," %14s                          "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-11.11s",nd_to_doc_number.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-11.11s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-8s\n\n",nd_to_doc_number.arr);
        }

  }                                                            

  if ((strcmp(nd_fr_bill_date.arr,"01/01/1800") == 0) && (strcmp(nd_to_bill_date.arr,"31/12/4712") == 0))
  {
	//fprintf(fp," %14s %-22.22s  %-5.5s : %-10s\n"," ",loc_legend[220],loc_legend[150],loc_legend[170]);              
    fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[220]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s  ",loc_legend[220]);
        }

	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s : ",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[170]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s\n",loc_legend[170]);
        }


	//fprintf(fp," %14s                         %-3.3s   : %-10s\n\n"," ",loc_legend[160],loc_legend[410]);            
	fprintf(fp," %14s                          "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[410]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10s\n\n",loc_legend[410]);
        }

  }
  else
  {     
      init_date_temp_var();                           
	  strcpy(date_convert.arr,nd_fr_bill_date.arr);   
	  fun_change_loc_date();
	  //fprintf(fp," %14s %-22.22s  %-5.5s : %-10s\n"," ",loc_legend[220],loc_legend[150],date_convert.arr); 
      fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[220]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s  ",loc_legend[220]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }

         fprintf(fp,"%-10s\n",date_convert.arr);


	  init_date_temp_var();                           
	  strcpy(date_convert.arr,nd_to_bill_date.arr);   
	  fun_change_loc_date();
	//fprintf(fp," %14s                         %-3.3s   : %-10s\n\n"," ",loc_legend[160],date_convert.arr); 
		fprintf(fp," %14s                          "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }
         fprintf(fp,"%-10s\n\n",date_convert.arr);

  }     
  
  if ((strcmp(nd_fr_blng_serv.arr,"!!!!!!") == 0) && (strcmp(nd_to_blng_serv.arr,"~~~~~~") == 0))
  {
	//fprintf(fp," %14s %-22.22s  %-5.5s : %-10s\n"," ",loc_legend[230],loc_legend[150],loc_legend[170]);              
	 fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[230]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s  ",loc_legend[230]);
        }

	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }

	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[170]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10s\n",loc_legend[170]);
        }

	//fprintf(fp," %14s                         %-3.3s   : %-10s\n\n"," ",loc_legend[160],loc_legend[410]);            
	fprintf(fp," %14s                          "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }

	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[410]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10s\n\n",loc_legend[410]);
        }

  }
  else
  {     
	//fprintf(fp," %14s %-22.22s  %-5.5s : %-6s\n"," ",loc_legend[230],loc_legend[150],nd_fr_blng_serv.arr); 
	fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[230]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s  ",loc_legend[230]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[150]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[150]);
        }

         fprintf(fp,"%-11.11s",nd_fr_blng_serv.arr);

	//fprintf(fp," %14s                         %-3.3s   : %-6s\n\n"," ",loc_legend[160],nd_to_blng_serv.arr); 
	fprintf(fp," %14s                          "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[160]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s   : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-3.3s   : ",loc_legend[160]);
        }
         fprintf(fp," %-11.11s\n\n",nd_to_blng_serv.arr);

  }     
  
  //fprintf(fp,  " %14s %-22.22s        : %s\n\n"," ",loc_legend[240],loc_legend[420]);
fprintf(fp,  " %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[240]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s        : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s        : ",loc_legend[240]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-15.15s",loc_legend[420]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-15.15s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%s\n\n",loc_legend[420]);
        }
  
  if (nd_report_opt.arr[0] == 'G')
    {
	  //fprintf(fp," %14s %-22.22s        : %s\n\n"," ",loc_legend[240],loc_legend[290]);
		fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[240]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s        : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s        : ",loc_legend[240]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-15.15s",loc_legend[290]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-15.15s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%s\n\n",loc_legend[290]);
        }


	  }
  else if (nd_report_opt.arr[0] == 'C')
  {
   // fprintf(fp," %14s %-22.22s        : %s\n\n"," ",loc_legend[240],loc_legend[430]);
   	fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[240]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s        : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s        : ",loc_legend[240]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-21.21s",loc_legend[430]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-21.21s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%s\n\n",loc_legend[430]);
        }
   }
  else 
    {
	  //fprintf(fp," %14s %-22.22s        : %s\n\n"," ",loc_legend[240],loc_legend[230]);
	     	fprintf(fp," %14s "," ");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-23.23s",loc_legend[240]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-23.23s        : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-22.22s        : ",loc_legend[240]);
        }
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-16.16s",loc_legend[230]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-16.16s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%s\n\n",loc_legend[230]);
        }
	  }
  
  fflush(fp);
}
 
print_page_head()
{
	  init_date_temp_var();                           
	  strcpy(date_convert.arr,date_time.arr);   
	  fun_change_loc_date();
 /* fprintf(fp, "\f\n%-5.5s : %-2.2s %39s %-30s %34s  %-16s\n",loc_legend[10],loc_legend[390],
      " ", hosp_name.arr," ", date_convert.arr);
 commented by saikiran */
fprintf(fp, "\f\n");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[10]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"\n\n%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"\n\n%-5.5s : ",loc_legend[10]);
        }

	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-3.3s",loc_legend[390]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-3.3s %39s ",nd_desc_with_spl_chr.arr," ");				
																																																					
	}
	else
	   {
         fprintf(fp,"%-2.2s %39s ",loc_legend[390]," ");
        }

	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-36.36s",hosp_name.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-36.36s %34s  ",nd_desc_with_spl_chr.arr," ");				
																																																					
	}
	else
	   {
         fprintf(fp,"%-30s %34s  ",hosp_name.arr," ");
        }

         fprintf(fp,"%-16s\n",date_convert.arr);




 /* fprintf(fp, "%-5.5s : %-10s                      %s",loc_legend[20],
     user_id.arr,loc_legend[30]);
  commented by saikiran*/


	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[20]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[20]);
        }

	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s                      ",user_id.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s                      ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10s                      ",user_id.arr);
        }
	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-50.50s",loc_legend[30]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-50.50s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%s",loc_legend[30]);
        }



  if (nd_episode_type.arr[0] == 'I')
  {
//	fprintf(fp, " -- %-13.13s : %s",loc_legend[70],loc_legend[80]);
 
		  
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-13.13s",loc_legend[70]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp," -- %-13.13s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp," -- %-13.13s : ",loc_legend[70]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[80]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s",loc_legend[80]);
        }
}
  else if (nd_episode_type.arr[0] == 'D')
  {
	//fprintf(fp, " -- %-13.13s : %s",loc_legend[70],loc_legend[90]);
		  
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-13.13s",loc_legend[70]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp," -- %-13.13s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp," -- %-13.13s : ",loc_legend[70]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[90]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s",loc_legend[90]);
        }
	}
  else if (nd_episode_type.arr[0] == 'O')
  {
//	fprintf(fp, " -- %-13.13s : %s",loc_legend[70],loc_legend[100]);
	  
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-13.13s",loc_legend[70]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp," -- %-13.13s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp," -- %-13.13s : ",loc_legend[70]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-11.11s",loc_legend[100]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-11.11s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s",loc_legend[100]);
        }
}
  else if (nd_episode_type.arr[0] == 'E')
  {
	//fprintf(fp, " -- %-13.13s : %s",loc_legend[70],loc_legend[110]);
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-13.13s",loc_legend[70]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp," -- %-13.13s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp," -- %-13.13s : ",loc_legend[70]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[110]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-10.10s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s",loc_legend[110]);
        }
	}
  else if (nd_episode_type.arr[0] == 'R')
  {
//	fprintf(fp, " -- %-13.13s : %s",loc_legend[70],loc_legend[120]);
  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-13.13s",loc_legend[70]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp," -- %-13.13s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp," -- %-13.13s : ",loc_legend[70]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-17.17s",loc_legend[120]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-17.17s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s",loc_legend[120]);
        }
}
  else if (nd_episode_type.arr[0] == 'A')
  {
//	fprintf(fp, " -- %-13.13s : %s",loc_legend[70],loc_legend[440]);
 if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-13.13s",loc_legend[70]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp," -- %-13.13s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp," -- %-13.13s : ",loc_legend[70]);
        }
		  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-13.13s",loc_legend[440]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-13.13s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-10.10s",loc_legend[440]);
        }
}

  fprintf(fp,"\n");

/*  fprintf(fp, "%-5.5s : %-8s %26s  %-28s %39s   %-5.5s : %4d\n",loc_legend[400],
    loc_legend[50], " ", "                              ", " ",loc_legend[40], pno);
commented by saikiran */


	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[400]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[400]);
        }
	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-9.9s",loc_legend[50]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-9.9s ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-8s ",loc_legend[50]);
        }

		fprintf(fp,"%26s  %-28s %39s   "," ", "                              ", " ");

	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[40]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : %4d\n",nd_desc_with_spl_chr.arr,pno);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : %4d\n",loc_legend[40],pno);
        }



  pno++;

  fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");

  /*
  fprintf(fp,"%-15.15s : %-10s  %-5.5s : %-40s  \n",loc_legend[260],
								g_blng_grp_id.arr,loc_legend[270], g_blng_grp_desc.arr);
commented by saikiran */
	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-15.15s",loc_legend[260]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-15.15s : %-10s  ",nd_desc_with_spl_chr.arr,g_blng_grp_id.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-15.15s : %-10s  ",loc_legend[260],g_blng_grp_id.arr);
        }
	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[270]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[270]);
        }
	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-40.40s",g_blng_grp_desc.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-40.40s  \n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-40s  \n",g_blng_grp_desc.arr);
        }


  if (g_cust_code.arr[0] != 'f')
  {
   //fprintf(fp,"%-15.15s : %-10s  %-5.5s : %-40s  \n",loc_legend[450],
   //								g_cust_code.arr,loc_legend[270], g_cust_name.arr);

	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-15.15s",loc_legend[450]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-15.15s : %-10s  ",nd_desc_with_spl_chr.arr,g_cust_code.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-15.15s : %-10s  ",loc_legend[450],g_cust_code.arr);
        }
	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-5.5s",loc_legend[270]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-5.5s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-5.5s : ",loc_legend[270]);
        }
	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-40s",g_cust_code.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-40s  \n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-40s  \n",g_cust_code.arr);
        }


  }
  else
  {
 // fprintf(fp,"%-15.15s : %-50s\n\n",loc_legend[450],loc_legend[280]);
	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-15.15s",loc_legend[450]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-15.15s : ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-15.15s : ",loc_legend[450]);
        }

	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-50.50s",loc_legend[280]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-50.50s\n\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-50s\n\n",loc_legend[280]);
        }
  }
  
  fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");

  if (nd_report_opt.arr[0] == 'G')
  {
	//fprintf(fp,"%-15.15s    %-25.25s                      %14.14s  %14.14s   %15.15s\n",	loc_legend[290],loc_legend[300],loc_legend[310],loc_legend[320],loc_legend[330]);

  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-15.15s",loc_legend[290]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-15.15s    ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-15.15s    ",loc_legend[290]);
        }
  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-40.40s",loc_legend[300]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-40.40s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-25.25s                      ",loc_legend[300]);
        }
  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[310]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"          %-10.10s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%14.14s  ",loc_legend[310]);
        }
  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-9.9s",loc_legend[320]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"       %-9.9s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%14.14s   ",loc_legend[320]);
        }
  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-8.8s",loc_legend[330]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"           %-8.8s\n",nd_desc_with_spl_chr.arr);				
																																																					
	} 
	else
	   {
         fprintf(fp,"%15.15s\n",loc_legend[330]);
        }


	}
	//fprintf(fp,"Service Group     Description                                      Gross Amt.        Discount           Net Amt.\n");
  else if (nd_report_opt.arr[0] == 'C')
  {
   // fprintf(fp,"%-15.15s    %-25.25s                      %14.14s  %14.14s   %15.15s\n",   loc_legend[340],loc_legend[300],loc_legend[310],loc_legend[320],loc_legend[330]);
	//fprintf(fp,"Service Clasfn.   Description                                      Gross Amt.        Discount           Net Amt.\n");
	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-15.15s",loc_legend[340]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-15.15s   ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-15.15s    ",loc_legend[340]);
        }
  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-40.40s",loc_legend[300]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-40.40s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-25.25s                      ",loc_legend[300]);
        }
  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[310]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"          %-10.10s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%14.14s  ",loc_legend[310]);
        }
  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-9.9s",loc_legend[320]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"       %-9.9s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%14.14s   ",loc_legend[320]);
        }
  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-8.8s",loc_legend[330]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"           %-8.8s\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%15.15s\n",loc_legend[330]);
        }
	}
  else
  {
    //fprintf(fp,"%-15.15s    %-25.25s                      %14.14s  %14.14s   %15.15s\n",	loc_legend[230],loc_legend[300],loc_legend[310],loc_legend[320],loc_legend[330]);
	//fprintf(fp,"Billing Service   Description                                      Gross Amt.        Discount           Net Amt.\n");

  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-16.16s",loc_legend[230]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-16.16s  ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-15.15s    ",loc_legend[230]);
        }
  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-40.40s",loc_legend[300]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-40.40s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-25.25s                      ",loc_legend[300]);
        }
  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-10.10s",loc_legend[310]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"          %-10.10s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%14.14s  ",loc_legend[310]);
        }
  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-9.9s",loc_legend[320]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"       %-9.9s",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%14.14s   ",loc_legend[320]);
        }
  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-8.8s",loc_legend[330]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"           %-8.8s\n",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%15.15s\n",loc_legend[330]);
        }
   }
  fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
  
  fflush(fp);
  lno = 12;
}


print_end()
{
  if (lno > MAX_LINES) print_page_head();

  if (c_gross_amt != 0 || c_disc_amt != 0 || c_net_amt != 0)
  {
		print_break_blng_grp();
  }
  c_gross_amt = 0;
  c_disc_amt  = 0;
  c_net_amt   = 0;

 // fprintf(fp, "\n\n\n %52s **   %-15s   ** \n\n\f", " ",loc_legend[350]);
 fprintf(fp, "\n\n\n %52s **   "," ");

 	if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-18.18s",loc_legend[350]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-18.18s   ** \n\n\f",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-15s   ** \n\n\f",loc_legend[350]);
        }
  fflush(fp);
  fclose(fp);
}



print_break_serv_grp()
{
	if (lno > MAX_LINES) print_page_head();

	fprintf(fp,"  %-4s",xx_grp_id.arr); fprintf(fp,"%13s"," ");
	//fprintf(fp,"%-40.40s     ",xx_grp_desc.arr);
	if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-40.40s",xx_grp_desc.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-40.40s    ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-40.40s    ",xx_grp_desc.arr);
        }
	print_formated(b_gross_amt); fprintf(fp,"%1s"," ");
	print_formated(b_disc_amt); fprintf(fp,"%4s"," ");
	print_formated(b_net_amt); fprintf(fp,"\n");
       
    lno++;
}

print_break_serv_clasfn()
{

    if (lno > MAX_LINES) print_page_head();

	fprintf(fp,"  %-2s",xx_clasfn_id.arr); fprintf(fp,"%13s"," ");
	//fprintf(fp,"%-40.40s    ",xx_clasfn_desc.arr);
				  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-40.40s",xx_clasfn_desc.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-40.40s    ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-40.40s    ",xx_clasfn_desc.arr);
        }
	print_formated(b_gross_amt); fprintf(fp,"%1s"," ");
	print_formated(b_disc_amt); fprintf(fp,"%4s"," ");
	print_formated(b_net_amt); fprintf(fp,"\n");
           
    lno++;
}


print_break_blng_serv()
{

    if (lno > MAX_LINES) print_page_head();

    fprintf(fp,"  %-4s",xx_serv_id.arr); fprintf(fp,"%10s"," ");
	//fprintf(fp,"%-40.40s    ",xx_serv_desc.arr);
			  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-40.40s",xx_serv_desc.arr);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-40.40s    ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-40.40s    ",xx_serv_desc.arr);
        }
	print_formated(b_gross_amt); fprintf(fp,"%1s"," ");
	print_formated(b_disc_amt); fprintf(fp,"%4s"," ");
	print_formated(b_net_amt); fprintf(fp,"\n");
	       
    lno++;
}
  
print_break_blng_grp()
{
    fetch_blng_grp_desc();

    if (lno > MAX_LINES) print_page_head();

    fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
  
    fflush(fp);

	fprintf(fp,"  %-4s"," "); //fprintf(fp,"%14s"," ");
	
	  if (nd_report_opt.arr[0] == 'G')
	      fprintf(fp,"%14s"," ");
	  else 
	      fprintf(fp,"%13s"," ");
	//fprintf(fp,"%-40.40s    ",loc_legend[360]);
		  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-39.39s",loc_legend[360]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-39.39s    ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-40.40s    ",loc_legend[360]);
        }
	print_formated(c_gross_amt); fprintf(fp,"%1s"," ");
	print_formated(c_disc_amt); fprintf(fp,"%4s"," ");
	print_formated(c_net_amt); fprintf(fp,"\n");

    
    fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
  
    fflush(fp);
	       
    lno+=3;
}
   

print_break_cash_pat()
{
   fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
  
    fflush(fp);
    
	fprintf(fp,"  %-4s"," "); 

	  if (nd_report_opt.arr[0] == 'G')
	      fprintf(fp,"%14s"," ");
	  else 
	      fprintf(fp,"%13s"," ");

	//fprintf(fp,"%-40.40s    ",loc_legend[370]);

  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-39.39s",loc_legend[370]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-39.39s    ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-40.40s    ",loc_legend[370]);
        }

	print_formated(g_gross_amt); fprintf(fp,"%1s"," ");
	print_formated(g_disc_amt); fprintf(fp,"%4s"," ");
	print_formated(g_net_amt); fprintf(fp,"\n");


    fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
  
    fflush(fp);
	       
    lno+=3;

    if (lno > MAX_LINES) print_page_head();
}


print_break_cust_code()
{

    fetch_customer_name();



    fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
  
    fflush(fp);
    
	fprintf(fp,"  %-4s"," "); //fprintf(fp,"%14s"," ");
	
	  if (nd_report_opt.arr[0] == 'G')
	      fprintf(fp,"%14s"," ");
	  else 
	      fprintf(fp,"%13s"," ");

	//fprintf(fp,"%-40.40s    ",loc_legend[380]);
	  	  if(strcmp(nd_pad_req_yn.arr,"Y")==0)
	{
		nd_temp_str.arr[0]='\0';
		nd_temp_str.len=0;
		sprintf(nd_temp_str.arr,"%-39.39s",loc_legend[380]);
		fun_Pad_desc_with_spl_char(nd_temp_str.arr);
		fprintf(fp,"%-39.39s    ",nd_desc_with_spl_chr.arr);				
																																																					
	}
	else
	   {
         fprintf(fp,"%-40.40s    ",loc_legend[380]);
        }
	print_formated(g_gross_amt); fprintf(fp,"%1s"," ");
	print_formated(g_disc_amt); fprintf(fp,"%4s"," ");
	print_formated(g_net_amt); fprintf(fp,"\n");


    fprintf(fp, "%s%s%s\n",
	    "--------------------------------------------------------",
	    "--------------------------------------------------------",
	    "--------------------");
  
    fflush(fp);
	       
    lno+=3;

    if (lno > MAX_LINES) print_page_head();

}


print_formated(l_amt)
double l_amt;
{
   char s_amt[120];

   /* EXEC SQL SELECT no_of_decimal
				   INTO :v_no_of_decimal
	  			   FROM sm_acc_entity_param
				  WHERE acc_entity_id = (SELECT acc_entity_code 
										   FROM sy_acc_entity
										  WHERE acc_entity_id = :d_facility_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 20;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select no_of_decimal into :b0  from sm_acc_entity_param wh\
ere acc_entity_id=(select acc_entity_code  from sy_acc_entity where acc_entity\
_id=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1241;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&v_no_of_decimal;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_facility_id;
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




/*   sprintf(s_amt,"%15.2f",loc_amount);
   format_amt(s_amt);

   if (loc_amount < 0)
      fprintf(fp,"%15s",s_amt);
   else
      fprintf(fp,"%15s ",s_amt);*/

   
   if(l_amt < 0)
	{
			put_val(s_amt,-l_amt);
		//	-----
		u_ltrim(s_amt);

		s_amt_len = strlen(s_amt);
	    	    		
		if (s_amt_len>=14)
		{
		strcat(s_amt,"-");
		fprintf(fp,"%15s",s_amt);
		}
		else if ((v_no_of_decimal==2 && s_amt_len>12) ||(v_no_of_decimal==3 && s_amt_len>13))
		{  strcat(s_amt,"-");
		   fprintf(fp,"%15s",s_amt);
		}
		else 
		{   
		   format_amt(s_amt);
           strcat(s_amt,"-");
		   fprintf(fp,"%15s",s_amt); 
		}
		//	-----
			 
		}
		else 
		{   
	    
        
        put_val(s_amt,l_amt); 
		u_ltrim(s_amt);

		s_amt_len = strlen(s_amt);
	    	    		
		if (s_amt_len>=14)
		{
		fprintf(fp,"%15s",s_amt);
		}
		else if ((v_no_of_decimal==2 && s_amt_len>12) ||(v_no_of_decimal==3 && s_amt_len>13))
		   fprintf(fp,"%15s",s_amt);
		else 
		{   
		   format_amt(s_amt);
           //strcat(s_amt," ");
		   fprintf(fp,"%15s",s_amt); 
		}
		

	}

}

fetch_desc()
{
   hosp_name.arr[0]      = '\0';
   date_time.arr[0]      = '\0';
   user_id.arr[0]        = '\0';

   hosp_name.len      = 0;
   date_time.len      = 0;
   user_id.len        = 0;

   /* EXEC SQL SELECT ACC_ENTITY_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
		   USER
	      INTO :hosp_name, :date_time, :user_id
	      FROM SY_ACC_ENTITY_lang_vw
		 WHERE acc_entity_id = :d_facility_id
		 AND		language_id=:p_language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 20;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:M\
I') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (acc_entity_id=:b\
3 and language_id=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1264;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&hosp_name;
   sqlstm.sqhstl[0] = (unsigned int  )43;
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
   sqlstm.sqhstl[2] = (unsigned int  )22;
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



   if (OERROR)
	 err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]           = '\0';
   date_time.arr[date_time.len]           = '\0';
   user_id.arr[user_id.len]               = '\0';

}


check_folio_record()
{
  cnt = 0;

  if (nd_episode_type.arr[0] == 'A')
  {			
    if (g_cust_code.arr[0] != 'f')
	{
    /* EXEC SQL     SELECT  COUNT(*) INTO :cnt
	     FROM    BL_BILL_HDR A,BL_PATIENT_CHARGES_FOLIO B
	     WHERE   A.DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE AND
				 A.DOC_NUM = B.BILL_DOC_NUM AND
				 A.BLNG_GRP_ID = :g_blng_grp_id AND
				 A.REV_CUST_CODE = :g_cust_code AND
			     A.PATIENT_ID BETWEEN     :nd_fr_pat_id and 
								          :nd_to_pat_id AND
			     A.DOC_TYPE_CODE BETWEEN  :nd_fr_doc_type_code and
									      :nd_to_doc_type_code AND
			     A.DOC_NUM    BETWEEN     :nd_fr_doc_number and
				  					      :nd_to_doc_number AND
			     A.DOC_DATE   BETWEEN	  to_date(:nd_fr_bill_date,'DD/MM/YYYY') and
									      to_date(:nd_to_bill_date,'DD/MM/YYYY') AND
			     B.BLNG_SERV_CODE BETWEEN :nd_fr_blng_serv and
									      :nd_to_blng_serv AND
				 NVL(B.PACKAGE_TRX_IND,'X') = 'N' AND
  			     NVL(A.BILL_STATUS,'X')        != 'C' AND
			     NVL(A.BILL_TRX_TYPE_CODE,'X') != 'I' AND
				 NVL(a.operating_facility_id,'X') = NVL(:d_facility_id,'X') AND
				 NVL(b.operating_facility_id,'X') = NVL(:d_facility_id,'X')
		 ORDER BY A.BLNG_GRP_ID,A.REV_CUST_CODE,B.BLNG_SERV_CODE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select count(*)  into :b0  from BL_BILL_HDR A ,BL_PATIENT\
_CHARGES_FOLIO B where (((((((((((((A.DOC_TYPE_CODE=B.BILL_DOC_TYPE_CODE and A\
.DOC_NUM=B.BILL_DOC_NUM) and A.BLNG_GRP_ID=:b1) and A.REV_CUST_CODE=:b2) and A\
.PATIENT_ID between :b3 and :b4) and A.DOC_TYPE_CODE between :b5 and :b6) and \
A.DOC_NUM between :b7 and :b8) and A.DOC_DATE between to_date(:b9,'DD/MM/YYYY'\
) and to_date(:b10,'DD/MM/YYYY')) and B.BLNG_SERV_CODE between :b11 and :b12) \
and NVL(B.PACKAGE_TRX_IND,'X')='N') and NVL(A.BILL_STATUS,'X')<>'C') and NVL(A\
.BILL_TRX_TYPE_CODE,'X')<>'I') and NVL(a.operating_facility_id,'X')=NVL(:b13,'\
X')) and NVL(b.operating_facility_id,'X')=NVL(:b13,'X')) order by A.BLNG_GRP_I\
D,A.REV_CUST_CODE,B.BLNG_SERV_CODE ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1299;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&cnt;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&g_blng_grp_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&g_cust_code;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fr_pat_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_pat_id;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_fr_doc_type_code;
    sqlstm.sqhstl[5] = (unsigned int  )9;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_type_code;
    sqlstm.sqhstl[6] = (unsigned int  )9;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_fr_doc_number;
    sqlstm.sqhstl[7] = (unsigned int  )11;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_to_doc_number;
    sqlstm.sqhstl[8] = (unsigned int  )11;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_fr_bill_date;
    sqlstm.sqhstl[9] = (unsigned int  )13;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_to_bill_date;
    sqlstm.sqhstl[10] = (unsigned int  )13;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_fr_blng_serv;
    sqlstm.sqhstl[11] = (unsigned int  )13;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_to_blng_serv;
    sqlstm.sqhstl[12] = (unsigned int  )13;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[13] = (unsigned int  )12;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[14] = (unsigned int  )12;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
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
		/* EXEC SQL     SELECT  COUNT(*) INTO :cnt
	     FROM    BL_BILL_HDR A,BL_PATIENT_CHARGES_FOLIO B
	     WHERE   A.DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE AND
				 A.DOC_NUM = B.BILL_DOC_NUM AND
				 A.BLNG_GRP_ID = :g_blng_grp_id AND
			     A.PATIENT_ID BETWEEN     :nd_fr_pat_id and 
								          :nd_to_pat_id AND
			     A.DOC_TYPE_CODE BETWEEN  :nd_fr_doc_type_code and
									      :nd_to_doc_type_code AND
			     A.DOC_NUM    BETWEEN     :nd_fr_doc_number and
				  					      :nd_to_doc_number AND
			     A.DOC_DATE   BETWEEN	  to_date(:nd_fr_bill_date,'DD/MM/YYYY') and
									      to_date(:nd_to_bill_date,'DD/MM/YYYY') AND
			     B.BLNG_SERV_CODE BETWEEN :nd_fr_blng_serv and
									      :nd_to_blng_serv AND
				 NVL(B.PACKAGE_TRX_IND,'X') = 'N' AND
  			     NVL(A.BILL_STATUS,'X')        != 'C' AND
			     NVL(A.BILL_TRX_TYPE_CODE,'X') != 'I' AND
				 NVL(a.operating_facility_id,'X') = NVL(:d_facility_id,'X') AND
				 NVL(b.operating_facility_id,'X') = NVL(:d_facility_id,'X')
		 ORDER BY A.BLNG_GRP_ID,A.REV_CUST_CODE,B.BLNG_SERV_CODE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(*)  into :b0  from BL_BILL_HDR A ,BL_PATIENT_C\
HARGES_FOLIO B where ((((((((((((A.DOC_TYPE_CODE=B.BILL_DOC_TYPE_CODE and A.DO\
C_NUM=B.BILL_DOC_NUM) and A.BLNG_GRP_ID=:b1) and A.PATIENT_ID between :b2 and \
:b3) and A.DOC_TYPE_CODE between :b4 and :b5) and A.DOC_NUM between :b6 and :b\
7) and A.DOC_DATE between to_date(:b8,'DD/MM/YYYY') and to_date(:b9,'DD/MM/YYY\
Y')) and B.BLNG_SERV_CODE between :b10 and :b11) and NVL(B.PACKAGE_TRX_IND,'X'\
)='N') and NVL(A.BILL_STATUS,'X')<>'C') and NVL(A.BILL_TRX_TYPE_CODE,'X')<>'I'\
) and NVL(a.operating_facility_id,'X')=NVL(:b12,'X')) and NVL(b.operating_faci\
lity_id,'X')=NVL(:b12,'X')) order by A.BLNG_GRP_ID,A.REV_CUST_CODE,B.BLNG_SERV\
_CODE ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1374;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&cnt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&g_blng_grp_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_fr_pat_id;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_to_pat_id;
  sqlstm.sqhstl[3] = (unsigned int  )23;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_fr_doc_type_code;
  sqlstm.sqhstl[4] = (unsigned int  )9;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_type_code;
  sqlstm.sqhstl[5] = (unsigned int  )9;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_fr_doc_number;
  sqlstm.sqhstl[6] = (unsigned int  )11;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_to_doc_number;
  sqlstm.sqhstl[7] = (unsigned int  )11;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_fr_bill_date;
  sqlstm.sqhstl[8] = (unsigned int  )13;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_to_bill_date;
  sqlstm.sqhstl[9] = (unsigned int  )13;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_fr_blng_serv;
  sqlstm.sqhstl[10] = (unsigned int  )13;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_to_blng_serv;
  sqlstm.sqhstl[11] = (unsigned int  )13;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[12] = (unsigned int  )12;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[13] = (unsigned int  )12;
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


		}
  }
  else
  {
    if (g_cust_code.arr[0] != 'f')
	{
      /* EXEC SQL     SELECT  COUNT(*) INTO :cnt 
	     FROM    BL_BILL_HDR A,BL_PATIENT_CHARGES_FOLIO B
	     WHERE   A.DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE AND
				 A.DOC_NUM = B.BILL_DOC_NUM AND
				 A.BLNG_GRP_ID = :g_blng_grp_id AND
				 A.REV_CUST_CODE = :g_cust_code AND
				 A.EPISODE_TYPE = :nd_episode_type AND
			     A.PATIENT_ID BETWEEN     :nd_fr_pat_id and 
								          :nd_to_pat_id AND
			     A.DOC_TYPE_CODE BETWEEN  :nd_fr_doc_type_code and
									      :nd_to_doc_type_code AND
			     A.DOC_NUM    BETWEEN     :nd_fr_doc_number and
				  					      :nd_to_doc_number AND
			     A.DOC_DATE   BETWEEN	  to_date(:nd_fr_bill_date,'DD/MM/YYYY') and
									      to_date(:nd_to_bill_date,'DD/MM/YYYY') AND
			     B.BLNG_SERV_CODE BETWEEN :nd_fr_blng_serv and
									      :nd_to_blng_serv AND
				 NVL(B.PACKAGE_TRX_IND,'X') = 'N' AND
  			     NVL(A.BILL_STATUS,'X')        != 'C' AND
			     NVL(A.BILL_TRX_TYPE_CODE,'X') != 'I' AND
				 NVL(a.operating_facility_id,'X') = NVL(:d_facility_id,'X') AND
				 NVL(b.operating_facility_id,'X') = NVL(:d_facility_id,'X')
		 ORDER BY A.BLNG_GRP_ID,A.REV_CUST_CODE,B.BLNG_SERV_CODE; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 20;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select count(*)  into :b0  from BL_BILL_HDR A ,BL_PATIE\
NT_CHARGES_FOLIO B where ((((((((((((((A.DOC_TYPE_CODE=B.BILL_DOC_TYPE_CODE an\
d A.DOC_NUM=B.BILL_DOC_NUM) and A.BLNG_GRP_ID=:b1) and A.REV_CUST_CODE=:b2) an\
d A.EPISODE_TYPE=:b3) and A.PATIENT_ID between :b4 and :b5) and A.DOC_TYPE_COD\
E between :b6 and :b7) and A.DOC_NUM between :b8 and :b9) and A.DOC_DATE betwe\
en to_date(:b10,'DD/MM/YYYY') and to_date(:b11,'DD/MM/YYYY')) and B.BLNG_SERV_\
CODE between :b12 and :b13) and NVL(B.PACKAGE_TRX_IND,'X')='N') and NVL(A.BILL\
_STATUS,'X')<>'C') and NVL(A.BILL_TRX_TYPE_CODE,'X')<>'I') and NVL(a.operating\
_facility_id,'X')=NVL(:b14,'X')) and NVL(b.operating_facility_id,'X')=NVL(:b14\
,'X')) order by A.BLNG_GRP_ID,A.REV_CUST_CODE,B.BLNG_SERV_CODE ";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1445;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&cnt;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&g_blng_grp_id;
      sqlstm.sqhstl[1] = (unsigned int  )5;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&g_cust_code;
      sqlstm.sqhstl[2] = (unsigned int  )11;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&nd_episode_type;
      sqlstm.sqhstl[3] = (unsigned int  )4;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&nd_fr_pat_id;
      sqlstm.sqhstl[4] = (unsigned int  )23;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&nd_to_pat_id;
      sqlstm.sqhstl[5] = (unsigned int  )23;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&nd_fr_doc_type_code;
      sqlstm.sqhstl[6] = (unsigned int  )9;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&nd_to_doc_type_code;
      sqlstm.sqhstl[7] = (unsigned int  )9;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&nd_fr_doc_number;
      sqlstm.sqhstl[8] = (unsigned int  )11;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&nd_to_doc_number;
      sqlstm.sqhstl[9] = (unsigned int  )11;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&nd_fr_bill_date;
      sqlstm.sqhstl[10] = (unsigned int  )13;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&nd_to_bill_date;
      sqlstm.sqhstl[11] = (unsigned int  )13;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&nd_fr_blng_serv;
      sqlstm.sqhstl[12] = (unsigned int  )13;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&nd_to_blng_serv;
      sqlstm.sqhstl[13] = (unsigned int  )13;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&d_facility_id;
      sqlstm.sqhstl[14] = (unsigned int  )12;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&d_facility_id;
      sqlstm.sqhstl[15] = (unsigned int  )12;
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


	}
	else
	{
	     /* EXEC SQL     SELECT  COUNT(*) INTO :cnt 
	     FROM    BL_BILL_HDR A,BL_PATIENT_CHARGES_FOLIO B
	     WHERE   A.DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE AND
				 A.DOC_NUM = B.BILL_DOC_NUM AND
				 A.BLNG_GRP_ID = :g_blng_grp_id AND
				 A.EPISODE_TYPE = :nd_episode_type AND
			     A.PATIENT_ID BETWEEN     :nd_fr_pat_id and 
								          :nd_to_pat_id AND
			     A.DOC_TYPE_CODE BETWEEN  :nd_fr_doc_type_code and
									      :nd_to_doc_type_code AND
			     A.DOC_NUM    BETWEEN     :nd_fr_doc_number and
				  					      :nd_to_doc_number AND
			     A.DOC_DATE   BETWEEN	  to_date(:nd_fr_bill_date,'DD/MM/YYYY') and
									      to_date(:nd_to_bill_date,'DD/MM/YYYY') AND
			     B.BLNG_SERV_CODE BETWEEN :nd_fr_blng_serv and
									      :nd_to_blng_serv AND
				 NVL(B.PACKAGE_TRX_IND,'X') = 'N' AND
  			     NVL(A.BILL_STATUS,'X')        != 'C' AND
			     NVL(A.BILL_TRX_TYPE_CODE,'X') != 'I' AND
				 NVL(a.operating_facility_id,'X') = NVL(:d_facility_id,'X') AND
				 NVL(b.operating_facility_id,'X') = NVL(:d_facility_id,'X')
		 ORDER BY A.BLNG_GRP_ID,A.REV_CUST_CODE,B.BLNG_SERV_CODE; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 20;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select count(*)  into :b0  from BL_BILL_HDR A ,BL_PATIE\
NT_CHARGES_FOLIO B where (((((((((((((A.DOC_TYPE_CODE=B.BILL_DOC_TYPE_CODE and\
 A.DOC_NUM=B.BILL_DOC_NUM) and A.BLNG_GRP_ID=:b1) and A.EPISODE_TYPE=:b2) and \
A.PATIENT_ID between :b3 and :b4) and A.DOC_TYPE_CODE between :b5 and :b6) and\
 A.DOC_NUM between :b7 and :b8) and A.DOC_DATE between to_date(:b9,'DD/MM/YYYY\
') and to_date(:b10,'DD/MM/YYYY')) and B.BLNG_SERV_CODE between :b11 and :b12)\
 and NVL(B.PACKAGE_TRX_IND,'X')='N') and NVL(A.BILL_STATUS,'X')<>'C') and NVL(\
A.BILL_TRX_TYPE_CODE,'X')<>'I') and NVL(a.operating_facility_id,'X')=NVL(:b13,\
'X')) and NVL(b.operating_facility_id,'X')=NVL(:b13,'X')) order by A.BLNG_GRP_\
ID,A.REV_CUST_CODE,B.BLNG_SERV_CODE ";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1524;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&cnt;
      sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&g_blng_grp_id;
      sqlstm.sqhstl[1] = (unsigned int  )5;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_episode_type;
      sqlstm.sqhstl[2] = (unsigned int  )4;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&nd_fr_pat_id;
      sqlstm.sqhstl[3] = (unsigned int  )23;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&nd_to_pat_id;
      sqlstm.sqhstl[4] = (unsigned int  )23;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&nd_fr_doc_type_code;
      sqlstm.sqhstl[5] = (unsigned int  )9;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&nd_to_doc_type_code;
      sqlstm.sqhstl[6] = (unsigned int  )9;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&nd_fr_doc_number;
      sqlstm.sqhstl[7] = (unsigned int  )11;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&nd_to_doc_number;
      sqlstm.sqhstl[8] = (unsigned int  )11;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&nd_fr_bill_date;
      sqlstm.sqhstl[9] = (unsigned int  )13;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&nd_to_bill_date;
      sqlstm.sqhstl[10] = (unsigned int  )13;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&nd_fr_blng_serv;
      sqlstm.sqhstl[11] = (unsigned int  )13;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&nd_to_blng_serv;
      sqlstm.sqhstl[12] = (unsigned int  )13;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&d_facility_id;
      sqlstm.sqhstl[13] = (unsigned int  )12;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&d_facility_id;
      sqlstm.sqhstl[14] = (unsigned int  )12;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
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

  }

} 


fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRBARCS.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRBARCS.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1599;
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
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1622;
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

get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	
	  
       	//get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id,t_date);  
      
	   //:nd_loc_date := to_char(t_date,'DD/MM/YYYY');
	   :nd_loc_date :=sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id);
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1653;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



fun_Pad_desc_with_spl_char_yn()
{
nd_pad_req_yn.arr[0]		= '\0';
nd_pad_req_yn.len			=	0;
nd_print_option.arr[0]		= '\0';	
nd_print_option.len			=	0;		
    
 
	if (strcmp(p_language_id.arr,"ar")==0 || strcmp(p_language_id.arr,"th")==0)
 	{
		fun_get_batch_filename();

		if( strcmp(nd_batch_filename.arr,"LOCAL")==0) 
			{
				nd_pad_req_yn.arr[0]='Y';
				nd_print_option.arr[0]='N';	
			}
		
		else
			{
				nd_pad_req_yn.arr[0]='N';
				//nd_print_option.arr[0]='R';	
			}	 
		
		
		nd_pad_req_yn.len=strlen(nd_pad_req_yn.arr);
		nd_print_option.len=strlen(nd_print_option.arr);

		nd_pad_req_yn.arr[nd_pad_req_yn.len]	 = '\0';
		nd_print_option.arr[nd_print_option.len] = '\0';
		
	}
	else
    {
	  nd_pad_req_yn.arr[0]='N';
	  nd_print_option.arr[0]='N';	
	}


}

fun_get_batch_filename()
{
	nd_batch_filename.arr[0] = '\0';
	nd_batch_filename.len	= 0;
	nd_report_option.arr[0]	= '\0';
	nd_report_option.len	= 0;


	/* EXEC SQL select batch_file_name ,
					report_tool_ch
			 into :nd_batch_filename,
				  :nd_report_option
			 from sm_report
			 where report_id='BLRSRIND'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select batch_file_name ,report_tool_ch into :b0,:b1  from sm\
_report where report_id='BLRSRIND'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1680;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_batch_filename;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_report_option;
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



	nd_batch_filename.arr[nd_batch_filename.len] = '\0';
	nd_report_option.arr[nd_report_option.len] = '\0';
	  

}

fun_Pad_desc_with_spl_char(orig_string)
char orig_string[1000];
{
	orig_desc_string.arr[0]		= '\0';
	orig_desc_string.len		=	0;
	
	nd_desc_with_spl_chr.arr[0]	= '\0';
	nd_desc_with_spl_chr.len	= 0;

	nd_length_of_string=0;
	

	strcpy(orig_desc_string.arr,orig_string);
	
 
	orig_desc_string.len	= strlen(orig_desc_string.arr);
	orig_desc_string.arr[orig_desc_string.len] = '\0';
	

	/* EXEC SQL select length(:orig_desc_string) into :nd_length_of_string from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select length(:b0) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1703;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&orig_desc_string;
 sqlstm.sqhstl[0] = (unsigned int  )2002;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_length_of_string;
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


 
	/* EXEC SQL select (:nd_length_of_string)-1 into :nd_length_of_string1 from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (:b0-1) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1726;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_length_of_string;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_length_of_string1;
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


 
		orig_desc_string1.arr[0]		= '\0';
		orig_desc_string1.len		=	0;
		orig_desc_string1.arr[orig_desc_string1.len] = '\0';
		
 
	
		strcpy(orig_desc_string1.arr,orig_desc_string.arr);

		orig_desc_string1.arr[nd_length_of_string1]		= '\0';
			
	 		
		orig_desc_string1.len	= strlen(orig_desc_string1.arr);
		orig_desc_string1.arr[orig_desc_string1.len] = '\0';
		
	
	/* EXEC SQL select length(:orig_desc_string1)+1 into :nd_length_of_string2 from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (length(:b0)+1) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1749;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&orig_desc_string1;
 sqlstm.sqhstl[0] = (unsigned int  )2002;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_length_of_string2;
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


	
					
	/* EXEC SQL select rpad(:orig_desc_string1,:nd_length_of_string2,chr(20))
				into :nd_desc_with_spl_chr from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rpad(:b0,:b1,chr(20)) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1772;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&orig_desc_string1;
 sqlstm.sqhstl[0] = (unsigned int  )2002;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_length_of_string2;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_desc_with_spl_chr;
 sqlstm.sqhstl[2] = (unsigned int  )2002;
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


	
		
	nd_desc_with_spl_chr.arr[nd_desc_with_spl_chr.len] = '\0';
	 

	
}


fun_Pad_desc_with_spl_char_1(orig_string)
char orig_string[2000];
{
	

	orig_desc_string.arr[0]		= '\0';
	orig_desc_string.len		=	0;
	nd_desc_with_spl_chr.arr[0]	= '\0';
	nd_desc_with_spl_chr.len	= 0;
	nd_length_of_string=0;

	strcpy(orig_desc_string.arr,orig_string);
		
	orig_desc_string.len	= strlen(orig_desc_string.arr);
	orig_desc_string.arr[orig_desc_string.len] = '\0';
		
	/* EXEC SQL select length(:orig_desc_string)+1 into :nd_length_of_string from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (length(:b0)+1) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1799;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&orig_desc_string;
 sqlstm.sqhstl[0] = (unsigned int  )2002;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_length_of_string;
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



					
	/* EXEC SQL select rpad(:orig_desc_string,:nd_length_of_string,chr(20))
				into :nd_desc_with_spl_chr from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rpad(:b0,:b1,chr(20)) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1822;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&orig_desc_string;
 sqlstm.sqhstl[0] = (unsigned int  )2002;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_length_of_string;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_desc_with_spl_chr;
 sqlstm.sqhstl[2] = (unsigned int  )2002;
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


	
		
		nd_desc_with_spl_chr.arr[nd_desc_with_spl_chr.len] = '\0';


	
}