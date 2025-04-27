
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
           char  filnam[51];
};
static const struct sqlcxp sqlfpn =
{
    50,
    "T:\\BL\\Facility Change Modifications\\BL\\Blrbilld.pc"
};


static unsigned long sqlctx = 464688955;


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
            void  *sqhstv[27];
   unsigned int   sqhstl[27];
            int   sqhsts[27];
            void  *sqindv[27];
            int   sqinds[27];
   unsigned int   sqharm[27];
   unsigned int   *sqharc[27];
   unsigned short  sqadto[27];
   unsigned short  sqtdso[27];
} sqlstm = {10,27};

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

 static const char *sq0007 = 
"select ADMISSION_DATE_TIME ,CUR_WARD_CODE ,CUR_ROOM_NUM ,CUR_BED_NUM ,CUR_PH\
YSICIAN_ID  from IP_EPISODE where (EPISODE_ID=:b0 and FACILITY_ID=:b1)        \
   ";

 static const char *sq0008 = 
"nd nvl(billed_flag,'N') in ('N','Y')))) and ((:b18='Y' and NVL(PACKAGE_TRX_I\
ND,'X')='N') or (:b18='N' and (NVL(PACKAGE_IND,'X')='S' or (NVL(PACKAGE_TRX_IN\
D,'X')='Y' and NVL(PACKAGE_IND,'X')='P'))))) group by TRX_DOC_REF,TRX_DOC_REF_\
LINE_NUM,PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,TRUNC(SERVICE_DATE),BLNG_SERV_CODE\
,SUBSTR(SERV_ITEM_CODE,1,10),SERV_ITEM_DESC,PACKAGE_IND,SERV_QTY,BLNG_GRP_ID,C\
UST_CODE,OPERATING_FACILITY_ID order by PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,TRU\
NC(SERVICE_DATE),BLNG_SERV_CODE            ";

 static const char *sq0009 = 
"5='B' and BILL_DOC_TYPE_CODE=:b16) and BILL_DOC_NUM=:b17) and BILLED_FLAG='Y\
') or (:b15 is null  and nvl(billed_flag,'N') in ('N','Y')))) and ((:b19='Y' a\
nd NVL(PACKAGE_TRX_IND,'X')='N') or (:b19='N' and (NVL(PACKAGE_IND,'X')='S' or\
 (NVL(PACKAGE_TRX_IND,'X')='Y' and NVL(PACKAGE_IND,'X')='P'))))) order by PRT_\
GRP_HDR_CODE,PRT_GRP_LINE_CODE,TRUNC(SERVICE_DATE),BLNG_SERV_CODE            ";

 static const char *sq0010 = 
"select LONG_DESC  from BL_BLNG_GRP where BLNG_GRP_ID=:b0           ";

 static const char *sq0011 = 
"select SUBSTR(SHORT_NAME_LOC_LANG,1,16) ,SEX ,NATIONALITY_CODE ,short_name  \
from MP_PATIENT_MAST where PATIENT_ID=:b0           ";

 static const char *sq0012 = 
"select FULL_NAME  from SY_PHYSICIAN_MAST where PHYSICIAN_ID=:b0           ";

 static const char *sq0013 = 
"select LONG_DESC ,LOC_LANG_SHORT_DESC  from BL_BLNG_PRT_GRP_HDR where PRT_GR\
P_HDR_CODE=:b0           ";

 static const char *sq0014 = 
"select LONG_DESC ,LOC_LANG_SHORT_DESC  from BL_BLNG_PRT_GRP_LINE where (PRT_\
GRP_HDR_CODE=:b0 and PRT_GRP_LINE_CODE=:b1)           ";

 static const char *sq0015 = 
"select CREDIT_DOC_REF_DESC ,CREDIT_DOC_REF_DATE  from BL_EPISODE_FIN_DTLS wh\
ere (((OPERATING_FACILITY_ID=:b0 and EPISODE_TYPE=:b1) and EPISODE_ID=:b2) and\
 PATIENT_ID=:b3)           ";

 static const char *sq0016 = 
"select SHORT_NAME  from AR_CUSTOMER where (CUST_CODE=:b0 and ACC_ENTITY_CODE\
 in (select ACC_ENTITY_CODE  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b1))     \
      ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,500,0,4,318,0,0,27,2,0,1,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,
1,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
1,9,0,0,1,9,0,0,
128,0,0,2,124,0,4,392,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
159,0,0,3,91,0,2,410,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
182,0,0,4,0,0,30,420,0,0,0,0,0,1,0,
197,0,0,5,0,0,32,425,0,0,0,0,0,1,0,
212,0,0,6,0,0,27,432,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
243,0,0,7,157,0,9,621,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
266,0,0,8,1533,0,9,639,0,0,20,20,0,1,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,9,0,
0,1,9,0,0,1,3,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
361,0,0,9,1411,0,9,641,0,0,21,21,0,1,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,1,0,
0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,1,0,0,1,1,0,0,
460,0,0,17,220,0,4,719,0,0,6,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
499,0,0,18,321,0,4,747,0,0,10,4,0,1,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
554,0,0,19,71,0,4,766,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
577,0,0,20,63,0,4,778,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
600,0,0,21,134,0,4,796,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
635,0,0,7,157,0,9,908,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
658,0,0,7,0,0,13,913,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
693,0,0,22,199,0,4,944,0,0,7,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
736,0,0,8,0,0,13,996,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,
4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
807,0,0,9,0,0,13,1013,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,
4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
878,0,0,23,103,0,4,1054,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,1,0,0,1,9,0,0,
909,0,0,24,121,0,4,1067,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,1,0,0,1,9,0,0,
940,0,0,10,67,0,9,1105,0,0,1,1,0,1,0,1,9,0,0,
959,0,0,10,0,0,13,1112,0,0,1,0,0,1,0,2,9,0,0,
978,0,0,11,128,0,9,1125,0,0,1,1,0,1,0,1,9,0,0,
997,0,0,11,0,0,13,1142,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1028,0,0,25,535,0,6,1161,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
1055,0,0,12,74,0,9,1197,0,0,1,1,0,1,0,1,9,0,0,
1074,0,0,12,0,0,13,1206,0,0,1,0,0,1,0,2,9,0,0,
1093,0,0,13,101,0,9,1226,0,0,1,1,0,1,0,1,9,0,0,
1112,0,0,13,0,0,13,1231,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
1135,0,0,14,130,0,9,1253,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1158,0,0,14,0,0,13,1258,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
1181,0,0,15,181,0,9,1273,0,0,4,4,0,1,0,1,9,0,0,1,1,0,0,1,9,0,0,1,9,0,0,
1212,0,0,15,0,0,13,1284,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
1235,0,0,16,160,0,9,1298,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1258,0,0,16,0,0,13,1307,0,0,1,0,0,1,0,2,9,0,0,
1277,0,0,26,284,0,4,1759,0,0,7,3,0,1,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,1,9,0,0,
1,3,0,0,1,9,0,0,
1320,0,0,27,190,0,4,1784,0,0,6,4,0,1,0,2,4,0,0,2,4,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
1,9,0,0,
1359,0,0,28,173,0,4,1798,0,0,5,3,0,1,0,2,4,0,0,2,4,0,0,1,9,0,0,1,1,0,0,1,9,0,0,
1394,0,0,29,126,0,4,1813,0,0,3,1,0,1,0,2,4,0,0,2,4,0,0,1,9,0,0,
1421,0,0,30,96,0,4,1834,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
1444,0,0,31,165,0,6,1842,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
1475,0,0,32,140,0,6,1886,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                    */
/************************************************************************/
/* PROGRAM NAME          : BLRBILLD.PC                                  */
/* AUTHOR                : M.NITIN KUMAR                                */
/* Converted To Windows  : Prasad B G S     4/7/96                      */
/* DATE WRITTEN          : 10-JUL-1993                                  */
/*                                                                      */
/* MODIFIED              : PVSS PRASAD/21-JUL-97/FOR AMH                */
/* MODIFIED              : VSK / 14/12/2000 / BLENH PURPOSE             */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */ 
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*                                                                      */
/************************************************************************/
/*
   All reference to HK$ change to Dhs
   -  For American Hospital Implementation. -- G. Viswanath/31/7/1996
*/          
         
#include <stdio.h>   
#include <string.h>
#include <bl.h>

#define OERROR (sqlca.sqlcode < 0)
#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define RESOURCE_BUSY (sqlca.sqlcode == -54)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define INIT_MESG "Report Generation In Progress..."

#define HSKIP_10 2
#define HSKIP_11 75
#define HSKIP_12 101
#define HSKIP_13 118

#define VSKIP_1 2
#define VSKIP_2 3
#define VSKIP_3 5

#define MAX_LINES 50

#define LEGEND 1

#define LENGTH_WORDS 65 

/*
#define DEBUG 
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd      [132],
	   hosp_name    [60],
	   date_time    [20],
	   user_id      [91],
	   nd_pgm_date  [35],
	   cur_str      [8],
	   sub_cur_str  [8],
	   nd_session_id[16],
	   nd_operating_facility_id [3],
	   l_pk_value		    [100],
	    l_translated_value	    [201],
	    nd_facility_id	    [3],
		p_language_id [3]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[60]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[8]; } cur_str;

struct { unsigned short len; unsigned char arr[8]; } sub_cur_str;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;


   /* VARCHAR nd_episode_id              [11],
		   nd_visit_id                [5],
	   nd_fm_date                 [13],
	   nd_to_date                 [13],
/o            Modified by Madesh--------->        o/
	   nd_doc_type                            [7],
//	   nd_doc_num                             [9],  changed to long vsk 14/03/2000
		   nd_stat                                        [2],
/o  <---------Modified by Madesh                o/                                 
		   prt_grp_fm                 [3],                 
		   prt_line_fm                [3],
		   prt_grp_to                 [3],
		   prt_line_to                [3],
		   			date_convert				[21],
			nd_loc_date					[21],
			nd_temp_date				[21]; */ 
struct { unsigned short len; unsigned char arr[11]; } nd_episode_id;

struct { unsigned short len; unsigned char arr[5]; } nd_visit_id;

struct { unsigned short len; unsigned char arr[13]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[13]; } nd_to_date;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type;

struct { unsigned short len; unsigned char arr[2]; } nd_stat;

struct { unsigned short len; unsigned char arr[3]; } prt_grp_fm;

struct { unsigned short len; unsigned char arr[3]; } prt_line_fm;

struct { unsigned short len; unsigned char arr[3]; } prt_grp_to;

struct { unsigned short len; unsigned char arr[3]; } prt_line_to;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;


   char    nd_episode_type,nd_ins_pat, 
		   nd_rep_opt,
/*            Modified by Madesh--------->        */               
		   nd_canc_chrg,                            
/*  <---------Modified by Madesh                */                                 
		   explode_pkg,
		   item_print_yn,
		   d_misc_serv_yn,
		   d_package_ind;

   /* VARCHAR d_doc_type_code            [7],
		   d_doc_date                 [13],
		   nd_sys_date                [13],
		   d_ins_pkg_pat_ind		  [2],	
		   d_admission_date           [20],
		   d_ward_code                [5],
		   d_room_num                 [5],
		   d_bed_num                  [9],
		   d_physician_id             [16],
		   d_physician_name           [31],
		   d_blng_grp_id              [3],
		   d_prt_grp_hdr_code         [3],
		   d_prt_grp_line_code        [3],
		   d_blng_grp_desc            [31],  
		   d_patient_id               [21],
		   d_patient_short_name       [61],
		   d_patient_short_name1      [61],
               mp_pat_short_name          [61],
               d_short_name_full          [61],
		   d_short_name_loc_lang      [61],
		   d_sex                      [2],
		   d_nationality_code         [5],
		   d_hdr_long_desc            [41],
		   d_hdr_loc_lang_short_desc  [17],
		   d_line_long_desc           [41],
		   d_line_loc_lang_short_desc [17],  
		   d_doc_num_prt              [9],
		   d_episode_id_prt           [9],
		   d_prv_doc_type_code        [7],
		   d_prv_doc_num              [9],    
		   d_prv_doc_date             [13],
		   d_bill_fm_date             [13],
		   d_bill_to_date             [13],
		   d_last_doc_type_code       [7],
		   d_last_doc_num             [9],
		   d_last_doc_date            [13],
		   d_pkg_serv_code            [11],
	       d_pkg_serv_desc            [41],
	       d_pkg_serv_desc_loc_lang   [17],
		   d_blng_serv_code           [11],
		   d_blng_serv_desc           [41],
		   d_serv_item_desc           [41],
		   d_serv_item_code           [11],
		   d_blng_serv_desc_loc_lang  [16],
		   d_service_date             [13],
		   d_clinic_code              [5],
		   d_visit_date_time          [17],
		   d_cust_code                [9],
		   v_package_bill_doc_type	  [7],
		   v_package_bill_doc_num	  [9],
		   v_non_ins_blng_grp_id	  [3],
		   v_blng_grp_id			  [3],
		   v_cust_code				  [9],
		   w_cust_code				  [9],
		   v_ins_pkg_pat_ind		  [2],
		   v_package_code			  [11],
		   v_pkg_long_desc			  [41],
		   v_cust_long_name			  [41],
		   d_operating_facility_id    [3],
		   d_cust_name                [16],
		   d_credit_doc_ref_desc      [31],
		   d_credit_doc_ref_date      [13]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[13]; } d_doc_date;

struct { unsigned short len; unsigned char arr[13]; } nd_sys_date;

struct { unsigned short len; unsigned char arr[2]; } d_ins_pkg_pat_ind;

struct { unsigned short len; unsigned char arr[20]; } d_admission_date;

struct { unsigned short len; unsigned char arr[5]; } d_ward_code;

struct { unsigned short len; unsigned char arr[5]; } d_room_num;

struct { unsigned short len; unsigned char arr[9]; } d_bed_num;

struct { unsigned short len; unsigned char arr[16]; } d_physician_id;

struct { unsigned short len; unsigned char arr[31]; } d_physician_name;

struct { unsigned short len; unsigned char arr[3]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[31]; } d_blng_grp_desc;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_short_name;

struct { unsigned short len; unsigned char arr[61]; } d_patient_short_name1;

struct { unsigned short len; unsigned char arr[61]; } mp_pat_short_name;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_loc_lang;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[5]; } d_nationality_code;

struct { unsigned short len; unsigned char arr[41]; } d_hdr_long_desc;

struct { unsigned short len; unsigned char arr[17]; } d_hdr_loc_lang_short_desc;

struct { unsigned short len; unsigned char arr[41]; } d_line_long_desc;

struct { unsigned short len; unsigned char arr[17]; } d_line_loc_lang_short_desc;

struct { unsigned short len; unsigned char arr[9]; } d_doc_num_prt;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id_prt;

struct { unsigned short len; unsigned char arr[7]; } d_prv_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_prv_doc_num;

struct { unsigned short len; unsigned char arr[13]; } d_prv_doc_date;

struct { unsigned short len; unsigned char arr[13]; } d_bill_fm_date;

struct { unsigned short len; unsigned char arr[13]; } d_bill_to_date;

struct { unsigned short len; unsigned char arr[7]; } d_last_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_last_doc_num;

struct { unsigned short len; unsigned char arr[13]; } d_last_doc_date;

struct { unsigned short len; unsigned char arr[11]; } d_pkg_serv_code;

struct { unsigned short len; unsigned char arr[41]; } d_pkg_serv_desc;

struct { unsigned short len; unsigned char arr[17]; } d_pkg_serv_desc_loc_lang;

struct { unsigned short len; unsigned char arr[11]; } d_blng_serv_code;

struct { unsigned short len; unsigned char arr[41]; } d_blng_serv_desc;

struct { unsigned short len; unsigned char arr[41]; } d_serv_item_desc;

struct { unsigned short len; unsigned char arr[11]; } d_serv_item_code;

struct { unsigned short len; unsigned char arr[16]; } d_blng_serv_desc_loc_lang;

struct { unsigned short len; unsigned char arr[13]; } d_service_date;

struct { unsigned short len; unsigned char arr[5]; } d_clinic_code;

struct { unsigned short len; unsigned char arr[17]; } d_visit_date_time;

struct { unsigned short len; unsigned char arr[9]; } d_cust_code;

struct { unsigned short len; unsigned char arr[7]; } v_package_bill_doc_type;

struct { unsigned short len; unsigned char arr[9]; } v_package_bill_doc_num;

struct { unsigned short len; unsigned char arr[3]; } v_non_ins_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } v_blng_grp_id;

struct { unsigned short len; unsigned char arr[9]; } v_cust_code;

struct { unsigned short len; unsigned char arr[9]; } w_cust_code;

struct { unsigned short len; unsigned char arr[2]; } v_ins_pkg_pat_ind;

struct { unsigned short len; unsigned char arr[11]; } v_package_code;

struct { unsigned short len; unsigned char arr[41]; } v_pkg_long_desc;

struct { unsigned short len; unsigned char arr[41]; } v_cust_long_name;

struct { unsigned short len; unsigned char arr[3]; } d_operating_facility_id;

struct { unsigned short len; unsigned char arr[16]; } d_cust_name;

struct { unsigned short len; unsigned char arr[31]; } d_credit_doc_ref_desc;

struct { unsigned short len; unsigned char arr[13]; } d_credit_doc_ref_date;


char       d_package_ind;

int        d_num_of_deps_paid;
float      d_qty;

long       d_doc_num,nd_doc_num,
		   d_episode_id;

double     d_serv_disc_amt,
		   d_man_disc_amt,
		   d_overall_disc_amt,
		   d_prepay_adj_amt,
		   d_deposit_adj_amt,
		   d_bill_paid_amt,
		   d_gross_amt,
		   d_prv_amt,
		   d_prv_outst_amt,
		   d_tot_dep_paid_amt,
/*            Modified by Madesh--------->        */
	   d_man_disc,
	   d_dep_amt,
	   d_pre_amt,
	   d_bill_amt,
	   v_package_price,
	   v_patient_payable,
	   v_insurance_payable,
	   v_ins_amt,
	   v_pat_amt,
	   bl_hdr_bill_tot_adjust_amt             , //EPNH 29/10/2004
	   bl_hdr_bill_tot_exempt_amt             ,
           bl_hdr_bill_tot_write_off_amt ;        
	   
/*  <---------Modified by Madesh                */                                                 
	char string_var[70];

	int i;
	
	char g_facility_id[3];

    char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];

/* EXEC SQL END DECLARE SECTION; */ 



// EXEC ORACLE OPTION(HOLD_CURSOR = YES);
// EXEC ORACLE OPTION(REBIND = NO);



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

char g_prt_grp_hdr_code[3];
char g_prt_grp_line_code[3];

int  g_first_break ;
int  g_print_line_desc;
int g_print_subtot;
int lno = 0, pno = 0;


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

   strcpy(g_pgm_id,"BLRBILL1");

   strcpy(nd_facility_id.arr,argv[4]);
   nd_facility_id.len = strlen(nd_facility_id.arr);
   strcpy(g_facility_id,nd_facility_id.arr);

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

   
   fetch_legend_value();
   

   /***** CHECKING FOR ACTIVE FLAG IN SY_PROG_CONTROL *****/
   strcpy(g_pgm_date,argv[3]);


   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   nd_episode_id.arr[0]    = '\0';
   d_episode_id_prt.arr[0] = '\0';
   nd_visit_id.arr[0]      = '\0';
   d_patient_id.arr[0]     = '\0';
   nd_fm_date.arr[0]       = '\0';
   nd_to_date.arr[0]       = '\0';
   prt_grp_fm.arr[0]       = '\0';
   prt_line_fm.arr[0]      = '\0';
   prt_grp_to.arr[0]       = '\0';
   prt_line_to.arr[0]      = '\0';
   d_doc_date.arr[0]       = '\0';
   nd_sys_date.arr[0]	   = '\0';
   nd_operating_facility_id.arr[0] = '\0';

   nd_episode_id.len       = 0;
   d_episode_id_prt.len    = 0;
   nd_visit_id.len         = 0;
   d_patient_id.len        = 0;
   nd_fm_date.len          = 0;
   nd_to_date.len          = 0;
   prt_grp_fm.len          = 0;
   prt_line_fm.len         = 0;
   prt_grp_to.len          = 0;
   prt_line_to.len         = 0;
   d_doc_date.len          = 0;
   nd_sys_date.len		   = 0;
   nd_operating_facility_id.len = 0;

   nd_episode_type = '\0';
   nd_rep_opt      = '\0';
   explode_pkg     = '\0';
   item_print_yn   = '\0';
   nd_ins_pat      = '\0';

   nd_doc_num = 0;

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,PARAM2,
				   LTRIM(TO_CHAR(TO_NUMBER(PARAM2),'00000009')),
				   PARAM3,PARAM4,PARAM5,PARAM6,
				   PARAM7,PARAM8,PARAM9,PARAM10,PARAM11,PARAM12,PARAM13,
				   PARAM14,PARAM15,PARAM16,PARAM17,PARAM18,PARAM19,     
				   TO_CHAR(SYSDATE,'DD/MM/YYYY'),PARAM20,PARAM21,PARAM22
	      INTO		:nd_operating_facility_id,
					:nd_episode_type,
					:nd_episode_id,
				    :d_episode_id_prt,
					:nd_visit_id,
				    :d_patient_id,
					:nd_fm_date,
					:nd_to_date,
					:prt_grp_fm,
					:prt_line_fm,
					:prt_grp_to,
					:prt_line_to,
					:nd_rep_opt,
					:explode_pkg,
					:item_print_yn,                  
/o            Modified by Madesh--------->        o/                   
		   :nd_canc_chrg,
		   :nd_doc_type,
		   :nd_doc_num,
		   :nd_stat,                        
/o  <---------Modified by Madesh                o/                                                                    
		   :d_doc_date,
/o  <---------Modified by VSK 17/10/1998        o/  
		   :nd_ins_pat,
		   :nd_sys_date,
		   :bl_hdr_bill_tot_adjust_amt             , //EPNH 29/10/2004
	           :bl_hdr_bill_tot_exempt_amt             ,
                   :bl_hdr_bill_tot_write_off_amt            
	      FROM SY_PROG_PARAM
	     WHERE PGM_ID     = 'BLRBILL1'
	       AND SESSION_ID = :nd_session_id
	       AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,LTRIM(TO_CHA\
R(TO_NUMBER(PARAM2),'00000009')) ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARA\
M8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 ,PARAM15 ,PARAM16 ,PAR\
AM17 ,PARAM18 ,PARAM19 ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,PARAM20 ,PARAM21 ,PARAM\
22 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,\
:b16,:b17,:b18,:b19,:b20,:b21,:b22,:b23,:b24  from SY_PROG_PARAM where ((PGM_I\
D='BLRBILL1' and SESSION_ID=:b25) and PGM_DATE=:b26)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
   sqlstm.sqhstl[1] = (unsigned int  )1;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_episode_id;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_episode_id_prt;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_visit_id;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[6] = (unsigned int  )15;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[7] = (unsigned int  )15;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&prt_grp_fm;
   sqlstm.sqhstl[8] = (unsigned int  )5;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&prt_line_fm;
   sqlstm.sqhstl[9] = (unsigned int  )5;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&prt_grp_to;
   sqlstm.sqhstl[10] = (unsigned int  )5;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&prt_line_to;
   sqlstm.sqhstl[11] = (unsigned int  )5;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_rep_opt;
   sqlstm.sqhstl[12] = (unsigned int  )1;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&explode_pkg;
   sqlstm.sqhstl[13] = (unsigned int  )1;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&item_print_yn;
   sqlstm.sqhstl[14] = (unsigned int  )1;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_canc_chrg;
   sqlstm.sqhstl[15] = (unsigned int  )1;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_doc_type;
   sqlstm.sqhstl[16] = (unsigned int  )9;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_doc_num;
   sqlstm.sqhstl[17] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_stat;
   sqlstm.sqhstl[18] = (unsigned int  )4;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_doc_date;
   sqlstm.sqhstl[19] = (unsigned int  )15;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_ins_pat;
   sqlstm.sqhstl[20] = (unsigned int  )1;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_sys_date;
   sqlstm.sqhstl[21] = (unsigned int  )15;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&bl_hdr_bill_tot_adjust_amt;
   sqlstm.sqhstl[22] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&bl_hdr_bill_tot_exempt_amt;
   sqlstm.sqhstl[23] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&bl_hdr_bill_tot_write_off_amt;
   sqlstm.sqhstl[24] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[25] = (unsigned int  )18;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[26] = (unsigned int  )37;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
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

   nd_episode_id.arr[nd_episode_id.len]  = '\0';
   d_episode_id_prt.arr[d_episode_id_prt.len]  = '\0';
   nd_visit_id.arr[nd_visit_id.len]  = '\0';
   d_patient_id.arr[d_patient_id.len]  = '\0';
   nd_fm_date.arr[nd_fm_date.len]  = '\0';
   nd_to_date.arr[nd_to_date.len]  = '\0';
   prt_grp_fm.arr[prt_grp_fm.len]  = '\0';
   prt_line_fm.arr[prt_line_fm.len]  = '\0';
   prt_grp_to.arr[prt_grp_to.len]  = '\0';
   prt_line_to.arr[prt_line_to.len]  = '\0';
   d_doc_date.arr[d_doc_date.len]  = '\0';          
   nd_sys_date.arr[nd_sys_date.len]  = '\0';          
/*            Modified by Madesh--------->        */                      
   nd_doc_type.arr[nd_doc_type.len]= '\0';
//   nd_doc_num.arr[nd_doc_num.len]= '\0';
   nd_stat.arr[nd_stat.len]='\0';
/*  <---------Modified by Madesh                */                                                 
   start_prog_msg();

   hosp_name.arr[0]  = '\0';
   hosp_name.len     = 0;
   cur_str.arr[0]    = '\0';
   cur_str.len       = 0;
   sub_cur_str.arr[0]   = '\0';
   sub_cur_str.len      = 0;

   strcpy(g_facility_id, nd_operating_facility_id.arr);

   /* EXEC SQL SELECT ACC_ENTITY_NAME,
				   RTRIM(BASE_CURRENCY),
				   BASE_CURRENCY_DEC
		    INTO   :hosp_name,
					cur_str,
					sub_cur_str
		    FROM   SY_ACC_ENTITY
			WHERE  ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,RTRIM(BASE_CURRENCY) ,BASE_CURRENC\
Y_DEC into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )128;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&hosp_name;
   sqlstm.sqhstl[0] = (unsigned int  )62;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&cur_str;
   sqlstm.sqhstl[1] = (unsigned int  )10;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&sub_cur_str;
   sqlstm.sqhstl[2] = (unsigned int  )10;
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



    if(OERROR)
	err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

   hosp_name.arr[hosp_name.len]  = '\0';
   cur_str.arr[cur_str.len]      = '\0';
   sub_cur_str.arr[sub_cur_str.len] = '\0';
 
   prt_bill();

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
		  WHERE PGM_ID     = 'BLRBILL1'
		    AND SESSION_ID = :nd_session_id
		    AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRBILL1' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )159;
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
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )182;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
    if (sqlca.sqlcode < 0) goto err_exit;
}


   return;   
   
err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )197;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ORA_MESG, "Oracle error occured in proc_main() function.");
    proc_exit();   
}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )212;
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

declare_cursors()
{
    /* EXEC SQL DECLARE IP_EPISODE_CUR CURSOR FOR
	     SELECT  ADMISSION_DATE_TIME,
			     CUR_WARD_CODE,
			     CUR_ROOM_NUM,
			     CUR_BED_NUM,
				 CUR_PHYSICIAN_ID
	     FROM    IP_EPISODE
	     WHERE   EPISODE_ID = :nd_episode_id
		 AND     FACILITY_ID = :nd_operating_facility_id; */ 


 if(nd_ins_pat == 'S')    
	{ /* EXEC SQL DECLARE BL_PAT_FOLIO_CUR_S CURSOR FOR
	     SELECT   PRT_GRP_HDR_CODE,
				  PRT_GRP_LINE_CODE,
				  TRUNC(SERVICE_DATE),
				  BLNG_SERV_CODE,
				  SUM(NVL(UPD_GROSS_CHARGE_AMT,0)),			 
				  NVL(SERV_QTY,0.00),
				  SUM(NVL(UPD_DISC_AMT,0)),
				  SUBSTR(SERV_ITEM_CODE,1,10),		     		     		     
				  SERV_ITEM_DESC,
				  PACKAGE_IND,
				  NULL,
				  BLNG_GRP_ID,
				  CUST_CODE,
				  OPERATING_FACILITY_ID
		  FROM    BL_PATIENT_CHARGES_FOLIO
	     WHERE    EPISODE_TYPE = :nd_episode_type
		   AND    PATIENT_ID   = :d_patient_id
		   AND    EPISODE_ID   = :nd_episode_id
		   AND	  OPERATING_FACILITY_ID = :nd_operating_facility_id
		   AND    VISIT_ID     = DECODE(:nd_episode_type,
						   'I',VISIT_ID,'D',VISIT_ID,:nd_visit_id) //EPNH 29/10/2004 
		   AND    TRUNC(TRX_DATE) BETWEEN
			     TO_DATE(NVL(:nd_fm_date,'01/01/1000'),'DD/MM/YYYY') AND
			     TO_DATE(NVL(:nd_to_date,'01/01/3000'),'DD/MM/YYYY')
		   AND   RPAD(PRT_GRP_HDR_CODE,2,' ')||PRT_GRP_LINE_CODE BETWEEN 
			     RPAD(NVL(:prt_grp_fm,'!!'),2,' ')||NVL(:prt_line_fm,'!!') AND
			     RPAD(NVL(:prt_grp_to,'~~'),2,' ')||NVL(:prt_line_to,'~~')
   /o	 AND    NVL(INS_PKG_PAT_IND,'X') = DECODE(:nd_ins_pat,'I','I','P','P','A',NVL(INS_PKG_PAT_IND,'X')) o/
   /o BLENH o/  AND     NVL(INS_PKG_PAT_IND,'X') != 'K'
		     AND     NVL(TRX_FINALIZE_IND,'X') = 'Y'			 
   /o            Modified by Madesh--------->        o/                                 
	     AND ((TRX_STATUS IS NULL AND :nd_canc_chrg = 'N')
					     OR
			 ((TRX_STATUS LIKE '%' OR TRX_STATUS IS NULL) AND :nd_canc_chrg = 'Y'))
	     AND ((:nd_stat = 'B' AND BILL_DOC_TYPE_CODE = :nd_doc_type AND 
				 BILL_DOC_NUM = :nd_doc_num AND BILLED_FLAG = 'Y')
					 OR
			 (:nd_stat is null and nvl(billed_flag,'N') in ('N','Y')))      
/o           <------Modified by Madesh                o/                                                                                          
	     AND ((:explode_pkg = 'Y' AND NVL(PACKAGE_TRX_IND,'X')  = 'N')
						     OR        
			       (:explode_pkg = 'N' AND 
				   (NVL(PACKAGE_IND,'X')      = 'S' OR
				     (NVL(PACKAGE_TRX_IND,'X')  = 'Y' AND
				       NVL(PACKAGE_IND,'X')      = 'P'
				     )
				   )
			       )
			     )
        GROUP BY TRX_DOC_REF,TRX_DOC_REF_LINE_NUM,PRT_GRP_HDR_CODE,PRT_GRP_LINE_CODE,
                 TRUNC(SERVICE_DATE),BLNG_SERV_CODE,SUBSTR(SERV_ITEM_CODE,1,10),
                 SERV_ITEM_DESC,PACKAGE_IND,SERV_QTY,BLNG_GRP_ID,
				 CUST_CODE, OPERATING_FACILITY_ID
		ORDER BY PRT_GRP_HDR_CODE, PRT_GRP_LINE_CODE,TRUNC(SERVICE_DATE),
			   BLNG_SERV_CODE; */ 

	    }
    else   
    {/* EXEC SQL DECLARE BL_PAT_FOLIO_CUR CURSOR FOR 
	     SELECT  PRT_GRP_HDR_CODE,
				 PRT_GRP_LINE_CODE,
				 TRUNC(SERVICE_DATE),
				 BLNG_SERV_CODE,
				 NVL(UPD_GROSS_CHARGE_AMT,0),
				 NVL(SERV_QTY,0.00),
				 NVL(UPD_DISC_AMT,0),
				 SUBSTR(SERV_ITEM_CODE,1,10),
				 SERV_ITEM_DESC,
				 PACKAGE_IND,
			 NVL(INS_PKG_PAT_IND,'N'),
			 BLNG_GRP_ID,
			 CUST_CODE,
			 OPERATING_FACILITY_ID
		  FROM    BL_PATIENT_CHARGES_FOLIO
	     WHERE   EPISODE_TYPE = :nd_episode_type
		     AND     PATIENT_ID   = :d_patient_id
		     AND     EPISODE_ID   = :nd_episode_id
			 AND OPERATING_FACILITY_ID  = :nd_operating_facility_id
		     AND     VISIT_ID     = DECODE(:nd_episode_type,
						   'I',VISIT_ID,'D',VISIT_ID,:nd_visit_id) //EPNH 29/10/2004
		     AND     TRUNC(TRX_DATE) BETWEEN TO_DATE(NVL(:nd_fm_date,'01/01/1000'),'DD/MM/YYYY') AND
			 			  TO_DATE(NVL(:nd_to_date,'01/01/3000'),'DD/MM/YYYY')
		     AND     RPAD(PRT_GRP_HDR_CODE,2,' ')||PRT_GRP_LINE_CODE BETWEEN 
			     RPAD(NVL(:prt_grp_fm,'!!'),2,' ')||NVL(:prt_line_fm,'!!') AND
			     RPAD(NVL(:prt_grp_to,'~~'),2,' ')||NVL(:prt_line_to,'~~')
/o BLENH o/	 AND    NVL(INS_PKG_PAT_IND,'X') = DECODE(:nd_ins_pat,'I','I','P','P','A',NVL(INS_PKG_PAT_IND,'X'))
/o BLENH o/  AND     NVL(INS_PKG_PAT_IND,'X') != 'K'
		     AND     NVL(TRX_FINALIZE_IND,'X') = 'Y'			 
/o            Modified by Madesh--------->        o/                                 
	     AND ((TRX_STATUS IS NULL AND :nd_canc_chrg = 'N')
					     OR
			 ((TRX_STATUS LIKE '%' OR TRX_STATUS IS NULL) AND :nd_canc_chrg = 'Y'))
	     AND ((:nd_stat = 'B' AND BILL_DOC_TYPE_CODE = :nd_doc_type AND 
				 BILL_DOC_NUM = :nd_doc_num AND BILLED_FLAG = 'Y')
					 OR
			 (:nd_stat is null and nvl(billed_flag,'N') in ('N','Y')))      
/o           <------Modified by Madesh                o/                                                                                          
	     AND ((:explode_pkg = 'Y' AND NVL(PACKAGE_TRX_IND,'X')  = 'N')
						     OR        
			       (:explode_pkg = 'N' AND 
				   (NVL(PACKAGE_IND,'X')      = 'S' OR
				     (NVL(PACKAGE_TRX_IND,'X')  = 'Y' AND
				       NVL(PACKAGE_IND,'X')      = 'P'
				     )
				   )
			       )
			     )
		     ORDER BY PRT_GRP_HDR_CODE, PRT_GRP_LINE_CODE,TRUNC(SERVICE_DATE),
			   BLNG_SERV_CODE; */ 

	   }
   
    /* EXEC SQL DECLARE BL_BLNG_GRP_CUR CURSOR FOR
	     SELECT  LONG_DESC
	     FROM    BL_BLNG_GRP
	     WHERE   BLNG_GRP_ID = :d_blng_grp_id; */ 


    /* EXEC SQL DECLARE MP_PATIENT_MAST_CUR CURSOR FOR
	     SELECT  /osubstr(SHORT_NAME,1,30),
				 decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,
			     o/
				 SUBSTR(SHORT_NAME_LOC_LANG,1,16),
			     SEX,
				 NATIONALITY_CODE,short_name       
	     FROM    MP_PATIENT_MAST
	     WHERE   PATIENT_ID = :d_patient_id; */ 


    /* EXEC SQL DECLARE SY_PHYSICIAN_MAST_CUR CURSOR FOR
	     SELECT  FULL_NAME
	     FROM    SY_PHYSICIAN_MAST
	     WHERE   PHYSICIAN_ID = :d_physician_id; */ 


    /* EXEC SQL DECLARE PRT_GRP_HDR_CUR CURSOR FOR
	     SELECT  LONG_DESC,
			     LOC_LANG_SHORT_DESC
	     FROM   BL_BLNG_PRT_GRP_HDR
	     WHERE  PRT_GRP_HDR_CODE = :d_prt_grp_hdr_code; */ 


    /* EXEC SQL DECLARE PRT_GRP_LINE_CUR CURSOR FOR
	     SELECT  LONG_DESC,
			     LOC_LANG_SHORT_DESC
	     FROM   BL_BLNG_PRT_GRP_LINE
	     WHERE  PRT_GRP_HDR_CODE  = :d_prt_grp_hdr_code
	     AND    PRT_GRP_LINE_CODE = :d_prt_grp_line_code; */ 



    /* EXEC SQL DECLARE BL_EPISODE_FIN_DTLS_CUR CURSOR FOR
		 SELECT CREDIT_DOC_REF_DESC,
				CREDIT_DOC_REF_DATE
		 FROM   BL_EPISODE_FIN_DTLS 
		 WHERE  OPERATING_FACILITY_ID = :d_operating_facility_id
		 AND    EPISODE_TYPE          = :nd_episode_type           
		 AND    EPISODE_ID            = :nd_episode_id                    
		 AND    PATIENT_ID            = :d_patient_id; */ 


    /* EXEC SQL DECLARE AR_CUSTOMER_CUR CURSOR FOR
		 SELECT SHORT_NAME
		 FROM   AR_CUSTOMER
		 WHERE  CUST_CODE =  :d_cust_code
		 AND    ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_CODE FROM SY_ACC_ENTITY 
									WHERE ACC_ENTITY_ID = :d_operating_facility_id); */ 

}


prt_bill()
{

    open_files();
    declare_cursors();

    /* EXEC SQL OPEN IP_EPISODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0007;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )243;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[0] = (unsigned int  )13;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor IP_EPISODE_CUR",0,"");
     print_page_head();
	   
    if(fetch_ip_episode()) {

		pno = 1;
		g_cum_amt = 0;
		tot_disc_amt = 0;
	
		fetch_blng_grp_desc();
		fetch_patient_name();
		fetch_physician_name();
	//	print_page_head();

	if(nd_ins_pat == 'S') 
		/* EXEC SQL OPEN BL_PAT_FOLIO_CUR_S; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select PRT_GRP_HDR_CODE ,PRT_GRP_LINE_CODE ,TRUNC(SERVICE_DATE) ,BLNG_S\
ERV_CODE ,sum(NVL(UPD_GROSS_CHARGE_AMT,0)) ,NVL(SERV_QTY,0.00) ,sum(NVL(UPD_\
DISC_AMT,0)) ,SUBSTR(SERV_ITEM_CODE,1,10) ,SERV_ITEM_DESC ,PACKAGE_IND ,null\
  ,BLNG_GRP_ID ,CUST_CODE ,OPERATING_FACILITY_ID  from BL_PATIENT_CHARGES_FO\
LIO where (((((((((((EPISODE_TYPE=:b0 and PATIENT_ID=:b1) and EPISODE_ID=:b2\
) and OPERATING_FACILITY_ID=:b3) and VISIT_ID=DECODE(:b0,'I',VISIT_ID,'D',VI\
SIT_ID,:b5)) and TRUNC(TRX_DATE) between TO_DATE(NVL(:b6,'01/01/1000'),'DD/M\
M/YYYY') and TO_DATE(NVL(:b7,'01/01/3000'),'DD/MM/YYYY')) and (RPAD(PRT_GRP_\
HDR_CODE,2,' ')||PRT_GRP_LINE_CODE) between (RPAD(NVL(:b8,'!!'),2,' ')||NVL(\
:b9,'!!')) and (RPAD(NVL(:b10,'~~'),2,' ')||NVL(:b11,'~~'))) and NVL(INS_PKG\
_PAT_IND,'X')<>'K') and NVL(TRX_FINALIZE_IND,'X')='Y') and ((TRX_STATUS is n\
ull  and :b12='N') or ((TRX_STATUS like '%' or TRX_STATUS is null ) and :b12\
='Y'))) and ((((:b14='B' and BILL_DOC_TYPE_CODE=:b15) and BILL_DOC_NUM=:b16)\
 and BILLED_FLAG='Y') or (:b14 is null  a");
  sqlstm.stmt = sq0008;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )266;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[0] = (unsigned int  )1;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )13;
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
  sqlstm.sqhstv[4] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[4] = (unsigned int  )1;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_visit_id;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[6] = (unsigned int  )15;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[7] = (unsigned int  )15;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&prt_grp_fm;
  sqlstm.sqhstl[8] = (unsigned int  )5;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&prt_line_fm;
  sqlstm.sqhstl[9] = (unsigned int  )5;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&prt_grp_to;
  sqlstm.sqhstl[10] = (unsigned int  )5;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&prt_line_to;
  sqlstm.sqhstl[11] = (unsigned int  )5;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_canc_chrg;
  sqlstm.sqhstl[12] = (unsigned int  )1;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_canc_chrg;
  sqlstm.sqhstl[13] = (unsigned int  )1;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_stat;
  sqlstm.sqhstl[14] = (unsigned int  )4;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_doc_type;
  sqlstm.sqhstl[15] = (unsigned int  )9;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_doc_num;
  sqlstm.sqhstl[16] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&nd_stat;
  sqlstm.sqhstl[17] = (unsigned int  )4;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&explode_pkg;
  sqlstm.sqhstl[18] = (unsigned int  )1;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)&explode_pkg;
  sqlstm.sqhstl[19] = (unsigned int  )1;
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


    else
		/* EXEC SQL OPEN BL_PAT_FOLIO_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select PRT_GRP_HDR_CODE ,PRT_GRP_LINE_CODE ,TRUNC(SERVICE_DATE) ,BLNG_S\
ERV_CODE ,NVL(UPD_GROSS_CHARGE_AMT,0) ,NVL(SERV_QTY,0.00) ,NVL(UPD_DISC_AMT,\
0) ,SUBSTR(SERV_ITEM_CODE,1,10) ,SERV_ITEM_DESC ,PACKAGE_IND ,NVL(INS_PKG_PA\
T_IND,'N') ,BLNG_GRP_ID ,CUST_CODE ,OPERATING_FACILITY_ID  from BL_PATIENT_C\
HARGES_FOLIO where ((((((((((((EPISODE_TYPE=:b0 and PATIENT_ID=:b1) and EPIS\
ODE_ID=:b2) and OPERATING_FACILITY_ID=:b3) and VISIT_ID=DECODE(:b0,'I',VISIT\
_ID,'D',VISIT_ID,:b5)) and TRUNC(TRX_DATE) between TO_DATE(NVL(:b6,'01/01/10\
00'),'DD/MM/YYYY') and TO_DATE(NVL(:b7,'01/01/3000'),'DD/MM/YYYY')) and (RPA\
D(PRT_GRP_HDR_CODE,2,' ')||PRT_GRP_LINE_CODE) between (RPAD(NVL(:b8,'!!'),2,\
' ')||NVL(:b9,'!!')) and (RPAD(NVL(:b10,'~~'),2,' ')||NVL(:b11,'~~'))) and N\
VL(INS_PKG_PAT_IND,'X')=DECODE(:b12,'I','I','P','P','A',NVL(INS_PKG_PAT_IND,\
'X'))) and NVL(INS_PKG_PAT_IND,'X')<>'K') and NVL(TRX_FINALIZE_IND,'X')='Y')\
 and ((TRX_STATUS is null  and :b13='N') or ((TRX_STATUS like '%' or TRX_STA\
TUS is null ) and :b13='Y'))) and ((((:b1");
  sqlstm.stmt = sq0009;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )361;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[0] = (unsigned int  )1;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )13;
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
  sqlstm.sqhstv[4] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[4] = (unsigned int  )1;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_visit_id;
  sqlstm.sqhstl[5] = (unsigned int  )7;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_fm_date;
  sqlstm.sqhstl[6] = (unsigned int  )15;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_to_date;
  sqlstm.sqhstl[7] = (unsigned int  )15;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&prt_grp_fm;
  sqlstm.sqhstl[8] = (unsigned int  )5;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&prt_line_fm;
  sqlstm.sqhstl[9] = (unsigned int  )5;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&prt_grp_to;
  sqlstm.sqhstl[10] = (unsigned int  )5;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&prt_line_to;
  sqlstm.sqhstl[11] = (unsigned int  )5;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_ins_pat;
  sqlstm.sqhstl[12] = (unsigned int  )1;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_canc_chrg;
  sqlstm.sqhstl[13] = (unsigned int  )1;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_canc_chrg;
  sqlstm.sqhstl[14] = (unsigned int  )1;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_stat;
  sqlstm.sqhstl[15] = (unsigned int  )4;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_doc_type;
  sqlstm.sqhstl[16] = (unsigned int  )9;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&nd_doc_num;
  sqlstm.sqhstl[17] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&nd_stat;
  sqlstm.sqhstl[18] = (unsigned int  )4;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)&explode_pkg;
  sqlstm.sqhstl[19] = (unsigned int  )1;
  sqlstm.sqhsts[19] = (         int  )0;
  sqlstm.sqindv[19] = (         void  *)0;
  sqlstm.sqinds[19] = (         int  )0;
  sqlstm.sqharm[19] = (unsigned int  )0;
  sqlstm.sqadto[19] = (unsigned short )0;
  sqlstm.sqtdso[19] = (unsigned short )0;
  sqlstm.sqhstv[20] = (         void  *)&explode_pkg;
  sqlstm.sqhstl[20] = (unsigned int  )1;
  sqlstm.sqhsts[20] = (         int  )0;
  sqlstm.sqindv[20] = (         void  *)0;
  sqlstm.sqinds[20] = (         int  )0;
  sqlstm.sqharm[20] = (unsigned int  )0;
  sqlstm.sqadto[20] = (unsigned short )0;
  sqlstm.sqtdso[20] = (unsigned short )0;
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
	    err_mesg("OPEN failed on cursor BL_PAT_FOLIO_CUR",0,"");

		g_prt_grp_line_code[0] = '\0';
		g_first_break  = 1;
		g_print_subtot = 0;

		while(fetch_folio()) {


			/*          if(strcmp(g_prt_grp_hdr_code,d_prt_grp_hdr_code.arr)) 
				print_break_hdr();  */
	
	
		    if((strcmp(g_prt_grp_line_code,d_prt_grp_line_code.arr) != 0) ||
		       (strcmp(g_prt_grp_hdr_code,d_prt_grp_hdr_code.arr) != 0)) 
			print_break_line();

	       if(g_print_subtot) {
		  fprintf(fp,"\n");
		  lno++;
	       }
		    print_line();
			fetch_credit_doc_ref();
			fetch_customer_name();

		    strcpy(g_prt_grp_hdr_code,d_prt_grp_hdr_code.arr);
		    strcpy(g_prt_grp_line_code,d_prt_grp_line_code.arr);
	
		    g_cum_amt += d_gross_amt;
		    g_sub_tot += d_gross_amt;
		    tot_disc_amt += d_serv_disc_amt;
		    g_print_subtot = 1; 
		    fprintf(fp,"\n            %-2s         %-5s      %-8s  %-15s  %-30s \n",
	                d_blng_grp_id.arr, d_nationality_code.arr, d_cust_code.arr, d_cust_name.arr, 
		            d_credit_doc_ref_desc.arr);
		
		 	init_date_temp_var();
			if (d_credit_doc_ref_date.arr[0]!='\0')
			{
			  strcpy(date_convert.arr,d_credit_doc_ref_date.arr);
			  fun_change_loc_date();
			 fprintf(fp,"          %-10.10s",date_convert.arr);
			}

			init_date_temp_var();
			if (d_admission_date.arr[0]!='\0')
			{
			  strcpy(date_convert.arr,d_admission_date.arr);
			  fun_change_loc_date();
			 fprintf(fp," %-10.10s                                                                     ",date_convert.arr);
			} 


		 	 /*fprintf(fp,"          %-18s %-20s                                                                     ",
			d_credit_doc_ref_date.arr,d_admission_date.arr); */

			   lno++;

		}      /* end of while fetch_bill_line() */
	
		if(g_print_subtot == 1) {
		    print_subtot();
		print_balance_due();

		v_ins_amt	= 0;
		v_pat_amt	= 0;

		v_package_bill_doc_type.arr[0]  = '\0';
		v_package_bill_doc_num.arr[0]   = '\0';
		v_non_ins_blng_grp_id.arr[0]    = '\0';
		
		v_package_bill_doc_type.len     = 0;
		v_package_bill_doc_num.len      = 0;
		v_non_ins_blng_grp_id.len       = 0;

		/* EXEC SQL select package_bill_doc_type,package_bill_doc_num,non_ins_blng_grp_id
		into  :v_package_bill_doc_type,:v_package_bill_doc_num,:v_non_ins_blng_grp_id
		from  bl_episode_fin_dtls
		where patient_id   =   :d_patient_id
		and   episode_id   =   :nd_episode_id
		and   episode_type  in ('I','D') //EPNH 29/10/2004
		and   operating_facility_id = :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select package_bill_doc_type ,package_bill_doc_num ,non_ins\
_blng_grp_id into :b0,:b1,:b2  from bl_episode_fin_dtls where (((patient_id=:b\
3 and episode_id=:b4) and episode_type in ('I','D')) and operating_facility_id\
=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )460;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&v_package_bill_doc_type;
  sqlstm.sqhstl[0] = (unsigned int  )9;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&v_package_bill_doc_num;
  sqlstm.sqhstl[1] = (unsigned int  )11;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&v_non_ins_blng_grp_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[3] = (unsigned int  )23;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_episode_id;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[5] = (unsigned int  )5;
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



		v_package_bill_doc_type.arr[v_package_bill_doc_type.len]       = '\0';
		v_package_bill_doc_num.arr[v_package_bill_doc_num.len]         = '\0';
		v_non_ins_blng_grp_id.arr[v_non_ins_blng_grp_id.len]           = '\0';

		
   if (v_package_bill_doc_type.arr[0] != '\0' && v_package_bill_doc_num.arr[0] != '\0')
	   {    
		v_ins_pkg_pat_ind.arr[0]  = '\0';
		v_ins_pkg_pat_ind.len     = 0;
		
		v_package_code.arr[0]  = '\0';
		v_package_code.len     = 0;

		w_cust_code.arr[0]  = '\0';
		w_cust_code.len     = 0;

		v_package_price		= 0;
		v_patient_payable	= 0;
		v_insurance_payable = 0;
		 
		/* EXEC SQL select package_code,nvl(package_price,0),nvl(patient_payable,0),nvl(insurance_payable,0),ins_pkg_pat_ind,cust_code
		into  :v_package_code,:v_package_price,:v_patient_payable,:v_insurance_payable,:v_ins_pkg_pat_ind,:w_cust_code
		from   bl_package_trn_hdr
		where  patient_id =  :d_patient_id
		and    package_bill_doc_type  = :v_package_bill_doc_type 
		and    package_bill_doc_num   = :v_package_bill_doc_num
		and    nvl(bill_status,'X')  != 'C'
		and    operating_facility_id = :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select package_code ,nvl(package_price,0) ,nvl(patient_paya\
ble,0) ,nvl(insurance_payable,0) ,ins_pkg_pat_ind ,cust_code into :b0,:b1,:b2,\
:b3,:b4,:b5  from bl_package_trn_hdr where ((((patient_id=:b6 and package_bill\
_doc_type=:b7) and package_bill_doc_num=:b8) and nvl(bill_status,'X')<>'C') an\
d operating_facility_id=:b9)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )499;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&v_package_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&v_package_price;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&v_patient_payable;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&v_insurance_payable;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&v_ins_pkg_pat_ind;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&w_cust_code;
  sqlstm.sqhstl[5] = (unsigned int  )11;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&v_package_bill_doc_type;
  sqlstm.sqhstl[7] = (unsigned int  )9;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&v_package_bill_doc_num;
  sqlstm.sqhstl[8] = (unsigned int  )11;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_operating_facility_id;
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



		v_ins_pkg_pat_ind.arr[v_ins_pkg_pat_ind.len]       = '\0';
		v_package_code.arr[v_package_code.len]			   = '\0';
		w_cust_code.arr[w_cust_code.len]				   = '\0';
		

		if (v_package_code.arr[0]  != '\0')		

			v_pkg_long_desc.arr[0]  = '\0';
			v_pkg_long_desc.len     = 0; 
           
			/* EXEC SQL select long_desc into :v_pkg_long_desc
			from  bl_package_codes
			where  package_code = :v_package_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select long_desc into :b0  from bl_package_codes where pac\
kage_code=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )554;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&v_pkg_long_desc;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&v_package_code;
   sqlstm.sqhstl[1] = (unsigned int  )13;
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



			v_pkg_long_desc.arr[v_pkg_long_desc.len]	   = '\0';
	

		if (w_cust_code.arr[0]  != '\0')		
		   {
			v_cust_long_name.arr[0]  = '\0';
			v_cust_long_name.len     = 0; 
           
			/* EXEC SQL select long_name into :v_cust_long_name
			from  ar_customer
			where  cust_code = :w_cust_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select long_name into :b0  from ar_customer where cust_cod\
e=:b1";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )577;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&v_cust_long_name;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&w_cust_code;
   sqlstm.sqhstl[1] = (unsigned int  )11;
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



			v_cust_long_name.arr[v_cust_long_name.len]				   = '\0';
			}



	//if (nd_doc_type == '\0' && nd_doc_num == '\0')
	if (nd_doc_type.arr[0]  != '\0')		
		{
			v_blng_grp_id.arr[0] = '\0';
			v_cust_code.arr[0]   = '\0';
			
			v_blng_grp_id.len    = 0;
			v_cust_code.len      = 0;
			
		    /* EXEC SQL select blng_grp_id,cust_code 
			into   :v_blng_grp_id,:v_cust_code 
			from   bl_bill_hdr
			where  doc_type_code = :nd_doc_type
			and    doc_num       = :nd_doc_num
			and    operating_facility_id = :nd_operating_facility_id; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 27;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select blng_grp_id ,cust_code into :b0,:b1  from bl_bil\
l_hdr where ((doc_type_code=:b2 and doc_num=:b3) and operating_facility_id=:b4\
)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )600;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&v_blng_grp_id;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&v_cust_code;
      sqlstm.sqhstl[1] = (unsigned int  )11;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_doc_type;
      sqlstm.sqhstl[2] = (unsigned int  )9;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&nd_doc_num;
      sqlstm.sqhstl[3] = (unsigned int  )sizeof(long);
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
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


		
			v_blng_grp_id.arr[v_blng_grp_id.len]     = '\0';
			v_cust_code .arr[v_cust_code .len]       = '\0';

		if (v_blng_grp_id.arr[0]  != '\0' && v_cust_code.arr[0] != '\0' && v_ins_pkg_pat_ind.arr[0]  == 'I')
		     {
			   if (v_insurance_payable > 0) 
			      { v_ins_amt = v_insurance_payable;
				    v_pat_amt = 0;
				  }
			  
			  if (v_insurance_payable == 0) 
				 { v_ins_amt = v_package_price;
				   v_pat_amt = 0;
				 }

			 }

		if (v_blng_grp_id.arr[0]  != '\0' && v_cust_code.arr[0] == '\0' && v_ins_pkg_pat_ind.arr[0]  == 'P') 
			{
			   if (v_patient_payable > 0) 
			      { v_pat_amt = v_patient_payable;
				    v_ins_amt = 0;
				  }
			  
			  if (v_insurance_payable == 0) 
				 { v_pat_amt = v_package_price;
				   v_ins_amt = 0;
				 }
			 }

		if (v_blng_grp_id.arr[0]  != '\0' && v_cust_code.arr[0] != '\0' && v_ins_pkg_pat_ind.arr[0]  == 'P') 
			 {v_pat_amt = v_package_price;
			  v_ins_amt = 0;
			 }
			
	  }

	if (nd_doc_type.arr[0]  == '\0')
		 { if (v_ins_pkg_pat_ind.arr[0]  == 'P' && v_patient_payable == 0)
		       {v_pat_amt = v_package_price;
			    v_ins_amt = 0;
			   }
		   if (v_ins_pkg_pat_ind.arr[0]  == 'P' && v_patient_payable > 0)
		       {v_pat_amt = v_patient_payable;
			    v_ins_amt = v_insurance_payable;
			   }
		      
		   if (v_ins_pkg_pat_ind.arr[0]  == 'I' && v_patient_payable == 0)
		       {v_ins_amt = v_package_price;
			    v_pat_amt = 0;
			   }
		   if (v_ins_pkg_pat_ind.arr[0] == 'I' && v_insurance_payable > 0)
		       {v_pat_amt = v_patient_payable;
			    v_ins_amt = v_insurance_payable;
			   }

		}

  if (v_ins_amt >0 || v_pat_amt >0)
	  print_pkg();

	 } 


	}       
    }      /* end of while fetch_bill_hdr()  */

    fflush(fp);
    fclose(fp);
    return 1;

}

open_files()
{
   strcpy(filename,WORKING_DIR);
   strcat(filename,"blrbilld.lis");
   if ((fp = fopen(filename,"w")) == NULL)
   {
	err_mesg("\nError while opening File blrbilld.lis\n",0,"");
	proc_exit();
   }

}

fetch_ip_episode()
{

    if(nd_episode_type == 'R')
	return 1;

    if(nd_episode_type == 'I' || nd_episode_type == 'D' ) { //EPNH 29/10/2004

	d_admission_date.arr[0]    = '\0';
	d_ward_code.arr[0]         = '\0';
	d_room_num.arr[0]          = '\0';
	d_bed_num.arr[0]           = '\0';
	d_physician_id.arr[0]      = '\0';
    
	d_admission_date.len       = 0;
	d_ward_code.len            = 0;
	d_room_num.len             = 0;
	d_bed_num.len              = 0;
	d_physician_id.len         = 0;

	/* EXEC SQL OPEN IP_EPISODE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0007;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )635;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_episode_id;
 sqlstm.sqhstl[0] = (unsigned int  )13;
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


    
	if(OERROR)
	    err_mesg("OPEN failed on cursor IP_EPISODE_CUR",0,"");
    
	/* EXEC SQL FETCH IP_EPISODE_CUR INTO 
		       :d_admission_date,
		       :d_ward_code,
		       :d_room_num,
		       :d_bed_num,
		       :d_physician_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )658;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_admission_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_ward_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_room_num;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_bed_num;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_physician_id;
 sqlstm.sqhstl[4] = (unsigned int  )18;
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
	    err_mesg("FETCH failed on cursor IP_EPISODE_CUR",0,"");
    
	if(NO_DATA_FOUND) //err_mesg("space",0);
	    return 0;
    
	d_admission_date.arr[d_admission_date.len]            = '\0';
	d_ward_code.arr[d_ward_code.len]              = '\0';
	d_room_num.arr[d_room_num.len]                = '\0';
	d_bed_num.arr[d_bed_num.len]                  = '\0';
	d_physician_id.arr[d_physician_id.len]        = '\0';
    
	return 1;
    }
    else if(nd_episode_type == 'O' || nd_episode_type == 'E') { //EPNH 29/10/2004

	d_clinic_code.arr[0]       = '\0';
	d_physician_id.arr[0]      = '\0';
	d_visit_date_time.arr[0]   = '\0';

	d_clinic_code.len          = 0;
	d_physician_id.len         = 0;
	d_visit_date_time.len      = 0;

	/* EXEC SQL SELECT CLINIC_CODE,
			PHYSICIAN_ID,
			TO_CHAR(VISIT_REGN_DATE_TIME,'DD/MM/YYYY HH24:MI')
		   INTO :d_clinic_code,
			:d_physician_id,
			:d_visit_date_time
		   FROM OP_VISIT
		  WHERE EPISODE_ID = :nd_episode_id
		    AND PATIENT_ID = :d_patient_id
		    AND VISIT_ID   = :nd_visit_id
			AND FACILITY_ID = :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select CLINIC_CODE ,PHYSICIAN_ID ,TO_CHAR(VISIT_REGN_DATE_TI\
ME,'DD/MM/YYYY HH24:MI') into :b0,:b1,:b2  from OP_VISIT where (((EPISODE_ID=:\
b3 and PATIENT_ID=:b4) and VISIT_ID=:b5) and FACILITY_ID=:b6)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )693;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_clinic_code;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_physician_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_visit_date_time;
 sqlstm.sqhstl[2] = (unsigned int  )19;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_episode_id;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_visit_id;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
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



	if(OERROR)
	    err_mesg("FETCH failed on cursor IP_EPISODE_CUR",0,"");
    
	if(NO_DATA_FOUND) //err_mesg("space",0);
	    return 0;

	d_clinic_code.arr[d_clinic_code.len]           = '\0';
	d_physician_id.arr[d_physician_id.len]         = '\0';
	d_visit_date_time.arr[d_visit_date_time.len]   = '\0';

	return 1;

    }

}

fetch_folio()
{

    d_prt_grp_hdr_code.arr[0]  = '\0';
    d_prt_grp_line_code.arr[0] = '\0';
    d_blng_serv_code.arr[0]    = '\0';
    d_serv_item_desc.arr[0]    = '\0';
    d_serv_item_code.arr[0]    = '\0';
    d_service_date.arr[0]      = '\0';

    d_prt_grp_hdr_code.len     = 0;
    d_prt_grp_line_code.len    = 0;
    d_blng_serv_code.len       = 0;
    d_serv_item_code.len       = 0;
    d_serv_item_desc.len       = 0;
    d_service_date.len         = 0;

    d_gross_amt     = 0;
    d_qty           = 0;
    d_serv_disc_amt = 0;
    d_ins_pkg_pat_ind.arr[0] = '\0';
    d_package_ind   = '\0';

	if(nd_ins_pat == 'S') 
       { /* EXEC SQL FETCH BL_PAT_FOLIO_CUR_S
		     INTO  :d_prt_grp_hdr_code,
				   :d_prt_grp_line_code,
				   :d_service_date,
				   :d_blng_serv_code,
				   :d_gross_amt,
				   :d_qty,
				   :d_serv_disc_amt,
		           :d_serv_item_code,
		           :d_serv_item_desc,
				   :d_package_ind,
				   :d_ins_pkg_pat_ind,
				   :d_blng_grp_id,
				   :d_cust_code,
				   :d_operating_facility_id; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 27;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )736;
         sqlstm.cud = sqlcud0;
         sqlstm.sqlest = (unsigned char  *)&sqlca;
         sqlstm.sqlety = (unsigned short)256;
         sqlstm.occurs = (unsigned int  )0;
         sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_hdr_code;
         sqlstm.sqhstl[0] = (unsigned int  )5;
         sqlstm.sqhsts[0] = (         int  )0;
         sqlstm.sqindv[0] = (         void  *)0;
         sqlstm.sqinds[0] = (         int  )0;
         sqlstm.sqharm[0] = (unsigned int  )0;
         sqlstm.sqadto[0] = (unsigned short )0;
         sqlstm.sqtdso[0] = (unsigned short )0;
         sqlstm.sqhstv[1] = (         void  *)&d_prt_grp_line_code;
         sqlstm.sqhstl[1] = (unsigned int  )5;
         sqlstm.sqhsts[1] = (         int  )0;
         sqlstm.sqindv[1] = (         void  *)0;
         sqlstm.sqinds[1] = (         int  )0;
         sqlstm.sqharm[1] = (unsigned int  )0;
         sqlstm.sqadto[1] = (unsigned short )0;
         sqlstm.sqtdso[1] = (unsigned short )0;
         sqlstm.sqhstv[2] = (         void  *)&d_service_date;
         sqlstm.sqhstl[2] = (unsigned int  )15;
         sqlstm.sqhsts[2] = (         int  )0;
         sqlstm.sqindv[2] = (         void  *)0;
         sqlstm.sqinds[2] = (         int  )0;
         sqlstm.sqharm[2] = (unsigned int  )0;
         sqlstm.sqadto[2] = (unsigned short )0;
         sqlstm.sqtdso[2] = (unsigned short )0;
         sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_code;
         sqlstm.sqhstl[3] = (unsigned int  )13;
         sqlstm.sqhsts[3] = (         int  )0;
         sqlstm.sqindv[3] = (         void  *)0;
         sqlstm.sqinds[3] = (         int  )0;
         sqlstm.sqharm[3] = (unsigned int  )0;
         sqlstm.sqadto[3] = (unsigned short )0;
         sqlstm.sqtdso[3] = (unsigned short )0;
         sqlstm.sqhstv[4] = (         void  *)&d_gross_amt;
         sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[4] = (         int  )0;
         sqlstm.sqindv[4] = (         void  *)0;
         sqlstm.sqinds[4] = (         int  )0;
         sqlstm.sqharm[4] = (unsigned int  )0;
         sqlstm.sqadto[4] = (unsigned short )0;
         sqlstm.sqtdso[4] = (unsigned short )0;
         sqlstm.sqhstv[5] = (         void  *)&d_qty;
         sqlstm.sqhstl[5] = (unsigned int  )sizeof(float);
         sqlstm.sqhsts[5] = (         int  )0;
         sqlstm.sqindv[5] = (         void  *)0;
         sqlstm.sqinds[5] = (         int  )0;
         sqlstm.sqharm[5] = (unsigned int  )0;
         sqlstm.sqadto[5] = (unsigned short )0;
         sqlstm.sqtdso[5] = (unsigned short )0;
         sqlstm.sqhstv[6] = (         void  *)&d_serv_disc_amt;
         sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
         sqlstm.sqhsts[6] = (         int  )0;
         sqlstm.sqindv[6] = (         void  *)0;
         sqlstm.sqinds[6] = (         int  )0;
         sqlstm.sqharm[6] = (unsigned int  )0;
         sqlstm.sqadto[6] = (unsigned short )0;
         sqlstm.sqtdso[6] = (unsigned short )0;
         sqlstm.sqhstv[7] = (         void  *)&d_serv_item_code;
         sqlstm.sqhstl[7] = (unsigned int  )13;
         sqlstm.sqhsts[7] = (         int  )0;
         sqlstm.sqindv[7] = (         void  *)0;
         sqlstm.sqinds[7] = (         int  )0;
         sqlstm.sqharm[7] = (unsigned int  )0;
         sqlstm.sqadto[7] = (unsigned short )0;
         sqlstm.sqtdso[7] = (unsigned short )0;
         sqlstm.sqhstv[8] = (         void  *)&d_serv_item_desc;
         sqlstm.sqhstl[8] = (unsigned int  )43;
         sqlstm.sqhsts[8] = (         int  )0;
         sqlstm.sqindv[8] = (         void  *)0;
         sqlstm.sqinds[8] = (         int  )0;
         sqlstm.sqharm[8] = (unsigned int  )0;
         sqlstm.sqadto[8] = (unsigned short )0;
         sqlstm.sqtdso[8] = (unsigned short )0;
         sqlstm.sqhstv[9] = (         void  *)&d_package_ind;
         sqlstm.sqhstl[9] = (unsigned int  )1;
         sqlstm.sqhsts[9] = (         int  )0;
         sqlstm.sqindv[9] = (         void  *)0;
         sqlstm.sqinds[9] = (         int  )0;
         sqlstm.sqharm[9] = (unsigned int  )0;
         sqlstm.sqadto[9] = (unsigned short )0;
         sqlstm.sqtdso[9] = (unsigned short )0;
         sqlstm.sqhstv[10] = (         void  *)&d_ins_pkg_pat_ind;
         sqlstm.sqhstl[10] = (unsigned int  )4;
         sqlstm.sqhsts[10] = (         int  )0;
         sqlstm.sqindv[10] = (         void  *)0;
         sqlstm.sqinds[10] = (         int  )0;
         sqlstm.sqharm[10] = (unsigned int  )0;
         sqlstm.sqadto[10] = (unsigned short )0;
         sqlstm.sqtdso[10] = (unsigned short )0;
         sqlstm.sqhstv[11] = (         void  *)&d_blng_grp_id;
         sqlstm.sqhstl[11] = (unsigned int  )5;
         sqlstm.sqhsts[11] = (         int  )0;
         sqlstm.sqindv[11] = (         void  *)0;
         sqlstm.sqinds[11] = (         int  )0;
         sqlstm.sqharm[11] = (unsigned int  )0;
         sqlstm.sqadto[11] = (unsigned short )0;
         sqlstm.sqtdso[11] = (unsigned short )0;
         sqlstm.sqhstv[12] = (         void  *)&d_cust_code;
         sqlstm.sqhstl[12] = (unsigned int  )11;
         sqlstm.sqhsts[12] = (         int  )0;
         sqlstm.sqindv[12] = (         void  *)0;
         sqlstm.sqinds[12] = (         int  )0;
         sqlstm.sqharm[12] = (unsigned int  )0;
         sqlstm.sqadto[12] = (unsigned short )0;
         sqlstm.sqtdso[12] = (unsigned short )0;
         sqlstm.sqhstv[13] = (         void  *)&d_operating_facility_id;
         sqlstm.sqhstl[13] = (unsigned int  )5;
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
	   { /* EXEC SQL FETCH BL_PAT_FOLIO_CUR
		     INTO  :d_prt_grp_hdr_code,
				   :d_prt_grp_line_code,
				   :d_service_date,
				   :d_blng_serv_code,
				   :d_gross_amt,
				   :d_qty,
				   :d_serv_disc_amt,
		           :d_serv_item_code,
		           :d_serv_item_desc,
				   :d_package_ind,
				   :d_ins_pkg_pat_ind,
				   :d_blng_grp_id,
				   :d_cust_code,
				   :d_operating_facility_id; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 27;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )807;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_hdr_code;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_prt_grp_line_code;
      sqlstm.sqhstl[1] = (unsigned int  )5;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_service_date;
      sqlstm.sqhstl[2] = (unsigned int  )15;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_code;
      sqlstm.sqhstl[3] = (unsigned int  )13;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&d_gross_amt;
      sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&d_qty;
      sqlstm.sqhstl[5] = (unsigned int  )sizeof(float);
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&d_serv_disc_amt;
      sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&d_serv_item_code;
      sqlstm.sqhstl[7] = (unsigned int  )13;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&d_serv_item_desc;
      sqlstm.sqhstl[8] = (unsigned int  )43;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&d_package_ind;
      sqlstm.sqhstl[9] = (unsigned int  )1;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&d_ins_pkg_pat_ind;
      sqlstm.sqhstl[10] = (unsigned int  )4;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&d_blng_grp_id;
      sqlstm.sqhstl[11] = (unsigned int  )5;
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&d_cust_code;
      sqlstm.sqhstl[12] = (unsigned int  )11;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&d_operating_facility_id;
      sqlstm.sqhstl[13] = (unsigned int  )5;
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
	err_mesg("FETCH failed on cursor BL_PAT_FOLIO_CUR",0,"");

    if(NO_DATA_FOUND) //err_mesg("space",0);
	return 0;

    d_prt_grp_hdr_code.arr[d_prt_grp_hdr_code.len]   = '\0';
    d_prt_grp_line_code.arr[d_prt_grp_line_code.len] = '\0';
    d_service_date.arr[d_service_date.len]           = '\0';
    d_blng_serv_code.arr[d_blng_serv_code.len]       = '\0';
    d_serv_item_code.arr[d_serv_item_code.len]       = '\0';
    d_serv_item_desc.arr[d_serv_item_desc.len]       = '\0';
    d_ins_pkg_pat_ind.arr[d_ins_pkg_pat_ind.len]     = '\0';


    d_blng_serv_desc.arr[0]  = '\0';
    d_blng_serv_desc_loc_lang.arr[0]  = '\0';

    d_blng_serv_desc.len     = 0;
    d_blng_serv_desc_loc_lang.len     = 0;

    if(d_package_ind == 'P'&& explode_pkg == 'N') 
{
	/* EXEC SQL SELECT LONG_DESC,
					LOC_LANG_SHORT_DESC,
					'N'
			 INTO   :d_blng_serv_desc,
			    :d_blng_serv_desc_loc_lang,
					:d_misc_serv_yn
			 FROM   BL_PACKAGE_HDR
		 WHERE  PACKAGE_CODE = :d_blng_serv_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_DESC ,LOC_LANG_SHORT_DESC ,'N' into :b0,:b1,:b2 \
 from BL_PACKAGE_HDR where PACKAGE_CODE=:b3";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )878;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_blng_serv_desc_loc_lang;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_misc_serv_yn;
 sqlstm.sqhstl[2] = (unsigned int  )1;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_code;
 sqlstm.sqhstl[3] = (unsigned int  )13;
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



	if(OERROR)
	    err_mesg("SELECT failed on table BL_PACKAGE_HDR",0,"");
    }
    else {
	/* EXEC SQL SELECT LONG_DESC,
					LOC_LANG_SHORT_DESC,
					NVL(MISC_SERV_YN,'N')
			 INTO   :d_blng_serv_desc,
			:d_blng_serv_desc_loc_lang,
					:d_misc_serv_yn
		 FROM   BL_BLNG_SERV
		 WHERE  BLNG_SERV_CODE = :d_blng_serv_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LONG_DESC ,LOC_LANG_SHORT_DESC ,NVL(MISC_SERV_YN,'N')\
 into :b0,:b1,:b2  from BL_BLNG_SERV where BLNG_SERV_CODE=:b3";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )909;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_blng_serv_desc;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_blng_serv_desc_loc_lang;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_misc_serv_yn;
 sqlstm.sqhstl[2] = (unsigned int  )1;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_blng_serv_code;
 sqlstm.sqhstl[3] = (unsigned int  )13;
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



	if(OERROR)
	    err_mesg("SELECT failed on table BL_BLNG_SERV",0,"");
    }

    d_blng_serv_desc.arr[d_blng_serv_desc.len]  = '\0';
    d_blng_serv_desc_loc_lang.arr[d_blng_serv_desc_loc_lang.len]  = '\0';

    if(d_misc_serv_yn == 'Y') {
	strcpy(d_blng_serv_desc.arr, d_serv_item_desc.arr);
	d_blng_serv_desc_loc_lang.arr[0] = '\0';
    }

    if(item_print_yn == 'Y')
    {
      if(d_serv_item_code.arr[0]) 
      {
	strcpy(d_blng_serv_code.arr, d_serv_item_code.arr);
	strcpy(d_blng_serv_desc.arr, d_serv_item_desc.arr);
	d_blng_serv_desc_loc_lang.arr[0] = '\0';
      }
    }

    return 1;

}

fetch_blng_grp_desc()
{

    /* EXEC SQL OPEN BL_BLNG_GRP_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0010;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )940;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_id;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor BL_BLNG_GRP_CUR",0,"");

    d_blng_grp_desc.arr[0] = '\0';

    /* EXEC SQL FETCH BL_BLNG_GRP_CUR INTO
		   :d_blng_grp_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )959;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_desc;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor BL_BLNG_GRP_CUR",0,"");

    d_blng_grp_desc.arr[d_blng_grp_desc.len] = '\0';

}

fetch_patient_name()
{

    /* EXEC SQL OPEN MP_PATIENT_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0011;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )978;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor MP_PATIENT_MAST_CUR",0,"");

    d_patient_short_name.arr[0]   = '\0';
	d_patient_short_name1.arr[0]  = '\0';
    d_short_name_loc_lang.arr[0]  = '\0';
    d_sex.arr[0]                  = '\0';
	d_nationality_code.arr[0]     = '\0';

    d_patient_short_name.len    = 0;
	d_patient_short_name1.len    = 0;
    d_short_name_loc_lang.len   = 0;
    d_sex.len                   = 0;
	d_nationality_code.len      = 0;

    /* EXEC SQL FETCH MP_PATIENT_MAST_CUR
		     INTO  /o:d_patient_short_name,
				   :d_patient_short_name1,o/
				   :d_short_name_loc_lang,
				   :d_sex,
				   :d_nationality_code,
                           :d_short_name_full; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )997;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_short_name_loc_lang;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_sex;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_nationality_code;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_short_name_full;
    sqlstm.sqhstl[3] = (unsigned int  )63;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor MP_PATIENT_MAST_CUR",0,"");

    d_patient_short_name.arr[d_patient_short_name.len]    = '\0';
	d_patient_short_name1.arr[d_patient_short_name1.len]    = '\0';
    d_short_name_loc_lang.arr[d_short_name_loc_lang.len]  = '\0';
    d_sex.arr[d_sex.len]                                  = '\0';
	d_nationality_code.arr[d_nationality_code.len]        = '\0';

    d_short_name_full.arr[d_short_name_full.len]     = '\0';

   /* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_patient_short_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :d_patient_short_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :d_patient_short_name1    := :d_patient_short_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 27;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 )\
 ; BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , s\
tr2 ) ; IF str2 IS NOT NULL THEN :d_patient_short_name := str2 ; END IF ; blco\
mmon . split_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF st\
r2 IS NOT NULL THEN :d_patient_short_name1 := str2 ; END IF ; blcommon . split\
_words ( :d_short_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NU\
LL THEN :d_patient_short_name1 := :d_patient_short_name1 || str2 ; end if ; EN\
D ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1028;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_patient_short_name;
   sqlstm.sqhstl[1] = (unsigned int  )63;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_patient_short_name1;
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


       d_patient_short_name.arr[d_patient_short_name.len]  = '\0';
       d_patient_short_name1.arr[d_patient_short_name1.len]  = '\0';


}

fetch_physician_name()
{

    /* EXEC SQL OPEN SY_PHYSICIAN_MAST_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0012;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1055;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_physician_id;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor SY_PHYSICIAN_MAST_CUR",0,"");

    d_physician_name.arr[0] = '\0';

    d_physician_name.len    = 0;

    /* EXEC SQL FETCH SY_PHYSICIAN_MAST_CUR
	     INTO  :d_physician_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1074;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_physician_name;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor SY_PHYSICIAN_MAST_CUR",0,"");

    d_physician_name.arr[d_physician_name.len] = '\0';

}


fetch_prt_grp_hdr_desc()
{

    d_hdr_long_desc.arr[0]           = '\0';
    d_hdr_loc_lang_short_desc.arr[0] = '\0';

    d_hdr_long_desc.len              = 0;
    d_hdr_loc_lang_short_desc.len    = 0;

    /* EXEC SQL OPEN PRT_GRP_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0013;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1093;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_hdr_code;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor PRT_GRP_HDR_CUR",0,"");

    /* EXEC SQL FETCH PRT_GRP_HDR_CUR INTO
	     :d_hdr_long_desc,
	     :d_hdr_loc_lang_short_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1112;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_hdr_long_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_hdr_loc_lang_short_desc;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor PRT_GRP_HDR_CUR",0,"");

    d_hdr_long_desc.arr[d_hdr_long_desc.len]                     = '\0';
    d_hdr_loc_lang_short_desc.arr[d_hdr_loc_lang_short_desc.len] = '\0';


}

fetch_prt_grp_line_desc()
{

    d_line_long_desc.arr[0]           = '\0';
    d_line_loc_lang_short_desc.arr[0] = '\0';

    d_line_long_desc.len              = 0;
    d_line_loc_lang_short_desc.len    = 0;

    /* EXEC SQL OPEN PRT_GRP_LINE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0014;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1135;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_hdr_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prt_grp_line_code;
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
	err_mesg("OPEN failed on cursor PRT_GRP_LINE_CUR",0,"");

    /* EXEC SQL FETCH PRT_GRP_LINE_CUR INTO
	     :d_line_long_desc,
	     :d_line_loc_lang_short_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1158;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_line_long_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_line_loc_lang_short_desc;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor PRT_GRP_LINE_CUR",0,"");

    d_line_long_desc.arr[d_line_long_desc.len]                     = '\0';
    d_line_loc_lang_short_desc.arr[d_line_loc_lang_short_desc.len] = '\0';


}

fetch_credit_doc_ref()
{
    /* EXEC SQL OPEN BL_EPISODE_FIN_DTLS_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0015;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1181;
    sqlstm.selerr = (unsigned short)1;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )1;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
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



    if(OERROR)
	err_mesg("OPEN failed on cursor BL_EPISODE_FIN_DTLS_CUR",0,"");

    d_credit_doc_ref_desc.arr[0] ='\0';
	d_credit_doc_ref_date.arr[0] = '\0';

    d_credit_doc_ref_desc.len    = 0;
	d_credit_doc_ref_date.len    = 0;

    /* EXEC SQL FETCH BL_EPISODE_FIN_DTLS_CUR
			 INTO  :d_credit_doc_ref_desc,
			       :d_credit_doc_ref_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1212;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_credit_doc_ref_desc;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_credit_doc_ref_date;
    sqlstm.sqhstl[1] = (unsigned int  )15;
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
	err_mesg("FETCH failed on cursor BL_EPISODE_FIN_DTLS_CUR",0,"");

    d_credit_doc_ref_desc.arr[d_credit_doc_ref_desc.len] = '\0';
    d_credit_doc_ref_date.arr[d_credit_doc_ref_date.len] = '\0';
}

fetch_customer_name()
{

    /* EXEC SQL OPEN AR_CUSTOMER_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0016;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1235;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_code;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_operating_facility_id;
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
	err_mesg("OPEN failed on cursor AR_CUSTOMER_CUR ",0,"");

    d_cust_name.arr[0] = '\0';

    d_cust_name.len    = 0;

    /* EXEC SQL FETCH AR_CUSTOMER_CUR 
	     INTO  :d_cust_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 27;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1258;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_name;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor AR_CUSTOMER_CUR ",0,"");

    d_cust_name.arr[d_cust_name.len] = '\0';

}

print_page_head()
{
    int i;
    static int g_first = 1;

    if(!g_first) 
      fprintf(fp,"\n\f");

    g_first = 0;

    for(i = 0; i < VSKIP_1; i++) fprintf(fp,"\n");

fprintf(fp,"%-s%70s%7s        : %-3d\n",hosp_name.arr," ",loc_legend[30],pno);
/*fprintf(fp,"%-16s : %18s%60s%s : %10s - %10s\n",
	loc_legend[410],loc_legend[100]," ",loc_legend[450],nd_fm_date.arr,
						    nd_to_date.arr);*/

init_date_temp_var();
if (nd_fm_date.arr[0]!='\0')
{
  strcpy(date_convert.arr,nd_fm_date.arr);
  fun_change_loc_date();
  fprintf(fp,"%-16s : %18s%60s%s : %10.10s - ",
	loc_legend[410],loc_legend[100]," ",loc_legend[450],date_convert.arr);
}
init_date_temp_var();
if (nd_to_date.arr[0]!='\0')
{
  strcpy(date_convert.arr,nd_to_date.arr);
  fun_change_loc_date();
  fprintf(fp,"%10.10s\n",date_convert.arr);
}


/* nd_sys_date given instead nd_doc_date vsk 17/10/1998 */


/*fprintf(fp,"%100s%4s           : %s\n\n"," ",loc_legend[300],nd_sys_date.arr);*/

init_date_temp_var();
  strcpy(date_convert.arr,nd_sys_date.arr);
  fun_change_loc_date();
  fprintf(fp,"%100s%4s           : %s\n\n"," ",loc_legend[300],date_convert.arr);



fprintf(fp,"%10s : %-20s  %4s : %-30.30s  %-16.16s\n",loc_legend[110],
	    d_patient_id.arr,loc_legend[120], d_patient_short_name.arr,
	    d_short_name_loc_lang.arr);

if (strlen(d_patient_short_name1.arr) > 2)
{
  fprintf(fp,"%42s %s \n\n"," ",d_patient_short_name1.arr);
}
else
{  
  fprintf(fp,"\n");
}
if(nd_episode_type == 'I' || nd_episode_type == 'D' ) //EPNH 29/10/2004
    fprintf(fp,"%9s   : %-8s    %4s : %-4s    %4s : %-4s  %3s : %-8s\n\n",loc_legend[130],
		d_episode_id_prt.arr,loc_legend[140], d_ward_code.arr,loc_legend[160], d_room_num.arr, 
		loc_legend[170],d_bed_num.arr);
else if(nd_episode_type == 'O' || nd_episode_type == 'E' ) //EPNH 29/10/2004
    fprintf(fp,"%11s   : %-8s    %8s : %-4s              %6s : %-4s \n\n",loc_legend[180],
		nd_episode_id.arr,loc_legend[190], nd_visit_id.arr,loc_legend[210], d_clinic_code.arr);

/*      Modified By Madesh -----------> */ //EPNH 29/10/2004
if (strcmp(nd_stat.arr,"B")==0) 
{
    //fprintf(fp,"%11s   : %-4s / %d / %-4s\n",loc_legend[260], nd_doc_type.arr, nd_doc_num, d_doc_date.arr);
 	fprintf(fp,"%11s   : %-4s / %d",loc_legend[260], nd_doc_type.arr, nd_doc_num);

	  init_date_temp_var();
	  strcpy(date_convert.arr,d_doc_date.arr);
	  if(date_convert.arr[0]!='\0')
	  {
	  fun_change_loc_date();
	  fprintf(fp," / %-4s\n",date_convert.arr);
	  }
    fprintf(fp,"%s :",loc_legend[270]);
    print_formated(bl_hdr_bill_tot_adjust_amt,0);
    fprintf(fp," %s :",loc_legend[280]);
    print_formated(bl_hdr_bill_tot_exempt_amt,0);
    fprintf(fp," %s :",loc_legend[290]);
    print_formated(bl_hdr_bill_tot_write_off_amt,0);
    fprintf(fp,"\n");
}




/*      <----------- Modified By Madesh  */
fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"                       %7s    %7s                                                                   \n",loc_legend[310],loc_legend[310]);
fprintf(fp,"            %4s       %4s       %11s                                         %9s   %3s         %4s %s       %6s  %s\n",loc_legend[300],loc_legend[320],loc_legend[330],loc_legend[200],loc_legend[340],loc_legend[220],cur_str.arr,loc_legend[560],cur_str.arr);
fprintf(fp,"            %9s  %11s %9s  %4s          %20s \n",loc_legend[240],loc_legend[270],loc_legend[350],loc_legend[120],loc_legend[420]);
fprintf(fp,"            %15s   %23s  \n",loc_legend[460],loc_legend[470]);
fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------\n");

if(nd_episode_type == 'R')
    lno = 15;
else
    lno = 17;

}

print_break_hdr()
{

    int i;
    char s_amt[20];

    fetch_prt_grp_hdr_desc();

    if(lno > MAX_LINES)  print_next_page();

    for(i = 0; i < HSKIP_10; i++) fprintf(fp," ");
    fprintf(fp,"%-2s        %-40s  %21s%-16s\n",d_prt_grp_hdr_code.arr,
	       d_hdr_long_desc.arr, " ",d_hdr_loc_lang_short_desc.arr);

    lno++;
    /*
    g_prt_grp_line_code[0] = '\0';
    */

}

print_break_line()
{

    int i;
    char s_amt[20];

    fetch_prt_grp_line_desc();

    if(!g_first_break) {
       print_subtot();       /** Added by Aldrin **/
       if(lno+3 > MAX_LINES)  print_next_page();
//        print_subtot();   Commented by Aldrin

       fprintf(fp,"\n\n");
       lno=lno+2;
    }

//    if(strcmp(g_prt_grp_hdr_code,d_prt_grp_hdr_code.arr)) 
       print_break_hdr();
 
    g_first_break = 0;
    if(lno > MAX_LINES)  print_next_page();

    for(i = 0; i < HSKIP_10; i++) fprintf(fp," ");
    fprintf(fp,"      %-2s  %-40s  %21s%-16s  \n",d_prt_grp_line_code.arr,
		 d_line_long_desc.arr, " ",d_line_loc_lang_short_desc.arr);
    lno++;

}

print_line()
{
    int i;

    if(lno > MAX_LINES) print_next_page();

    for(i = 0; i < HSKIP_10; i++) fprintf(fp," ");
    /*fprintf(fp,"         %10s %-10s %-40s  %-16s ", d_service_date.arr,
		   d_blng_serv_code.arr, d_blng_serv_desc.arr, 
		   d_blng_serv_desc_loc_lang.arr);*/

		  init_date_temp_var();
		  strcpy(date_convert.arr,d_service_date.arr);
		  if(date_convert.arr[0]!='\0') 
		  {
		   fun_change_loc_date();
		   fprintf(fp,"         %10.10s", date_convert.arr);
          }

     fprintf(fp," %-10s %-40s  %-16s ",
		   d_blng_serv_code.arr, d_blng_serv_desc.arr, 
		   d_blng_serv_desc_loc_lang.arr);

 
 

    /* print_formated(d_gross_amt/d_qty,0);*/

   if (strcmp(d_ins_pkg_pat_ind.arr,"N")==0)
    fprintf(fp,"   ");
   else
    fprintf(fp,"%s  ",d_ins_pkg_pat_ind.arr); 
   fprintf(fp,"  %5.2f ",d_qty);

    print_formated(d_gross_amt, 0);

 
    /*
    fprintf(fp,"\n");
    lno++;

    fprintf(fp,"                       %-40s", d_serv_item_desc.arr);
    lno++;
    */                  
    
}

print_next_page()
{
    int i;
    pno++;
    print_page_head();
}

print_balance_due()
{
    int i;
    int no_of_lines;
    char out_str[10][133]; 
    void calc_disc();

    for(i=0; i<10; i++) out_str[i][0] = '\0';

    if(lno+6 > MAX_LINES) print_next_page();
    fprintf(fp,"  ");
    for(i = 0; i < 15; i++) fprintf(fp,"-"); fprintf(fp,"\n");
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"%9s                                   ",loc_legend[360]);
    print_formated(g_cum_amt,1);   
/*    Modified By Madesh   --------------> */
	calc_disc();

    if ( d_man_disc !=0 ) {
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"%s                        ",loc_legend[370]);
    print_formated(d_man_disc,1);
    g_cum_amt -= d_man_disc; 
    }

    if ( d_dep_amt !=0 ) {
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"%s                      ",loc_legend[380]);
    print_formated(d_dep_amt,1);
    g_cum_amt -= d_dep_amt; 
    }

    if ( d_pre_amt !=0 ) {
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"%s                   ",loc_legend[390]);
    print_formated(d_pre_amt,1);
    g_cum_amt -= d_pre_amt; 
    }
    
/*
    if ( d_bill_amt !=0 ) {
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"%s                      ",loc_legend[230]);
    print_formated(d_bill_amt,1);
    g_cum_amt -= d_bill_amt; 
    }
*/

/*   <------------- Modified By Madesh    */      
/*          
    if ( tot_disc_amt !=0 ) {
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"%s                               ",loc_legend[550]);
    print_formated(tot_disc_amt,1);
    g_cum_amt -= tot_disc_amt; 
    }
*/
/*
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"%s                             ",loc_legend[440]);
    print_formated(d_prepay_adj_amt,1);
    g_cum_amt -= d_prepay_adj_amt;

    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"%s                             ",loc_legend[70]);
    print_formated(g_cum_amt,1);

    for(i = 0; i < HSKIP_13; i++) fprintf(fp," ");
    for(i = 0; i < 15; i++) fprintf(fp,"-"); fprintf(fp,"\n");
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"%s                         ",loc_legend[80]);
    print_formated(d_prv_outst_amt,1);
    g_cum_amt += d_prv_outst_amt;
*/

    for(i = 0; i < HSKIP_13 + 1; i++) fprintf(fp," ");
    for(i = 0; i < 15; i++) fprintf(fp,"-"); fprintf(fp,"\n");
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"%s                           ",loc_legend[400]);
    print_formated(g_cum_amt,1);

    for(i = 0; i < HSKIP_13 + 1; i++) fprintf(fp," ");
    for(i = 0; i < 15; i++) fprintf(fp,"="); fprintf(fp,"\n");

    g_cum_amt = (g_cum_amt < 0) ? g_cum_amt * -1 : g_cum_amt;

 


/********* MODIFIED BY VENKAT  ON 27/04/1998 FOR PRINTING SUB CURRENCY **********/	

	no_of_lines = print_in_words(g_cum_amt,LENGTH_WORDS,sub_cur_str.arr,out_str);

/********************************************************************************/

    if (g_cum_amt != 0) 
    fprintf(fp,"%-6s",cur_str.arr);
	
	for (i =0;i<no_of_lines;i++)
	
	fprintf(fp,"     %s\n",out_str[i]);

}

print_subtot()
{
    int i;

    fprintf(fp," ");
    print_formated(g_sub_tot,1);

    for(i = 0; i < HSKIP_12 + 1; i++) fprintf(fp," ");
    for(i = 0; i < 15; i++) fprintf(fp,"-");

/*
    for(i = 0; i < HSKIP_11; i++) fprintf(fp," ");
    fprintf(fp,"%9s             :  ",loc_legend[430]);
    print_formated(g_sub_tot,1);
    fprintf(fp,"\n");
*/
    g_sub_tot = 0;
    g_print_subtot = 0;
    lno += 1;
}


print_pkg()
{
    int i;



	fprintf(fp,"\n");

	

	fprintf(fp,"%s",loc_legend[480]);
    fprintf(fp,"\n");

	fprintf(fp,"----------------");
    fprintf(fp,"\n");
     
	fprintf(fp,"%12s / %4s : %-10s %-42s",loc_legend[490],loc_legend[250],v_package_code.arr,v_pkg_long_desc.arr);

    fprintf(fp,"\n");
    fprintf(fp,"\n");
   

	if (v_ins_amt > 0) 
       {fprintf(fp,"%10s :%-10s/%-42s   : ",loc_legend[500],w_cust_code.arr,v_cust_long_name.arr);
	    fprintf(fp," ");
        print_formated(v_ins_amt,1);
		fprintf(fp,"\n");
	   }

	if (v_pat_amt > 0) 
       { if (w_cust_code.arr[0]  != '\0' && v_ins_pkg_pat_ind.arr[0]  == 'P')		
	         {fprintf(fp,"%10s :%-10s/%-42s   : ",loc_legend[500],w_cust_code.arr,v_cust_long_name.arr);
			 fprintf(fp," ");
			 }
		 else 
			 {fprintf(fp,"%10s :%7s  ",loc_legend[500],loc_legend[510]);	 
			  fprintf(fp,"                                               :  ");
		     }
		print_formated(v_pat_amt,1);
		fprintf(fp,"\n");
	   }


/*
    if (v_ins_amt > 0) 
       {fprintf(fp,"%s     : ",loc_legend[520]);
	    fprintf(fp," ");
        print_formated(v_ins_amt,1);
		fprintf(fp,"\n");
	   }

	if (v_pat_amt > 0) 
       {fprintf(fp,"%s      : ",loc_legend[530]);
	    fprintf(fp," ");
		print_formated(v_pat_amt,1);
		fprintf(fp,"\n");
	   } */

		  
/*
	 g_cum_amt = g_cum_amt + v_pat_amt + v_ins_amt;

  if (v_ins_amt >0 || v_pat_amt >0)
	 {if (g_cum_amt > 0) 
       {fprintf(fp,"%s  : ",loc_legend[540]);
	    fprintf(fp," ");
		print_formated(g_cum_amt,1);
	   }
	  }

	*/

	   
    //r(i = 0; i < HSKIP_12 + 1; i++) fprintf(fp," ");
    //for(i = 0; i < 15; i++) fprintf(fp,"-");

    
    lno += 1;
}


print_formated(loc_amount,flg)
double loc_amount;
int flg;
{
   char s_amt[20];

   sprintf(s_amt,"%15.2f",loc_amount);
   format_amt(s_amt);

   if (loc_amount < 0)
      fprintf(fp,"%15s",s_amt);
   else                               
      fprintf(fp,"%15s ",s_amt);
 
   if(flg)
       fprintf(fp,"\n");
}
  
  
/*   Added By Madesh  ------------->  */  
void calc_disc()
{
	if (strcmp(nd_stat.arr,"B")==0) 
	{
		/* EXEC SQL SELECT NVL(SERV_DISC_AMT,0)+NVL(MAN_DISC_AMT,0)+NVL(OVERALL_DISC_AMT,0),NVL(DEPOSIT_ADJ_AMT,0),
				  NVL(PREPAY_ADJ_AMT,0),NVL(BILL_TOT_AMT,0) - NVL(BILL_TOT_OUTST_AMT,0) INTO
				  d_man_disc,d_dep_amt,d_pre_amt,d_bill_amt
				 FROM BL_BILL_HDR 
				 WHERE DOC_TYPE_CODE = :nd_doc_type and
					   DOC_NUM       = :nd_doc_num
					   and operating_facility_id = :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select ((NVL(SERV_DISC_AMT,0)+NVL(MAN_DISC_AMT,0))+NVL(OVER\
ALL_DISC_AMT,0)) ,NVL(DEPOSIT_ADJ_AMT,0) ,NVL(PREPAY_ADJ_AMT,0) ,(NVL(BILL_TOT\
_AMT,0)-NVL(BILL_TOT_OUTST_AMT,0)) into :b0,:b1,:b2,:b3  from BL_BILL_HDR wher\
e ((DOC_TYPE_CODE=:b4 and DOC_NUM=:b5) and operating_facility_id=:b6)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1277;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_man_disc;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_dep_amt;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_pre_amt;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_bill_amt;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_doc_type;
  sqlstm.sqhstl[4] = (unsigned int  )9;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_doc_num;
  sqlstm.sqhstl[5] = (unsigned int  )sizeof(long);
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
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


					   
    if(OERROR)
	err_mesg("SELECT failed on BL_BILL_HDR",0,"");
	}
	else 
	{
		d_man_disc=0;
		d_bill_amt=0;
		d_man_disc = tot_disc_amt;

		/* -- BLENH purpose. Dep & prep should be only for I or all case */

//	    sprintf(string_var,"%c -- ins pat ind",nd_ins_pat);
//		disp_message(ERR_MESG,string_var);
		if ((nd_ins_pat == 'A')||(nd_ins_pat == 'I'))
		{
		if (nd_episode_type == 'O' || nd_episode_type == 'E' ) //EPNH 29/10/2004
		{
		/* EXEC SQL SELECT /o NVL(TOT_BUS_DISC_AMT,0)+NVL(TOT_BUS_MAN_DISC_AMT,0), blenh vsko/
						NVL(TOT_UNADJ_DEP_AMT,0),
						NVL(TOT_UNADJ_PREP_AMT,0) 
				 INTO /o d_man_disc,o/ d_dep_amt,d_pre_amt FROM
			 BL_VISIT_FIN_DTLS
				 WHERE EPISODE_ID = :nd_episode_id and
					   VISIT_ID   = :nd_visit_id and
					   EPISODE_TYPE = :nd_episode_type
					   and operating_facility_id = :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(TOT_UNADJ_DEP_AMT,0) ,NVL(TOT_UNADJ_PREP_AMT,0) \
into :b0,:b1  from BL_VISIT_FIN_DTLS where (((EPISODE_ID=:b2 and VISIT_ID=:b3)\
 and EPISODE_TYPE=:b4) and operating_facility_id=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1320;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_dep_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_pre_amt;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_visit_id;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[4] = (unsigned int  )1;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[5] = (unsigned int  )5;
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
	err_mesg("SELECT failed on BL_VISIT_FIN_DTLS",0,"");
		}         
		if (nd_episode_type == 'I' || nd_episode_type == 'D' ) //EPNH 29/10/2004
		{                                    
		/* EXEC SQL SELECT /o NVL(TOT_BUS_DISC_AMT,0)+NVL(TOT_BUS_MAN_DISC_AMT,0), blenh vsk o/
						NVL(TOT_UNADJ_DEP_AMT,0),
						NVL(TOT_UNADJ_PREP_AMT,0) 
				 INTO /od_man_disc , o/d_dep_amt,d_pre_amt FROM
			 BL_EPISODE_FIN_DTLS
				 WHERE EPISODE_ID = :nd_episode_id and
				       EPISODE_TYPE = :nd_episode_type
					   and operating_facility_id = :nd_operating_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(TOT_UNADJ_DEP_AMT,0) ,NVL(TOT_UNADJ_PREP_AMT,0) \
into :b0,:b1  from BL_EPISODE_FIN_DTLS where ((EPISODE_ID=:b2 and EPISODE_TYPE\
=:b3) and operating_facility_id=:b4)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1359;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_dep_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_pre_amt;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[3] = (unsigned int  )1;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
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
	err_mesg("SELECT failed on BL_EPISODE_FIN_DTLS",0,"");
		}         

		}
		if (nd_episode_type == 'R')
		{
		/* EXEC SQL SELECT NVL(TOT_UNADJ_DEP_REF_AMT,0),NVL(TOT_UNADJ_PREP_REF_AMT,0) 
				 INTO d_dep_amt,d_pre_amt FROM
			 BL_PATIENT_FIN_DTLS
				 WHERE PATIENT_ID = :d_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(TOT_UNADJ_DEP_REF_AMT,0) ,NVL(TOT_UNADJ_PREP_REF\
_AMT,0) into :b0,:b1  from BL_PATIENT_FIN_DTLS where PATIENT_ID=:b2";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1394;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_dep_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_pre_amt;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
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
	err_mesg("SELECT failed on BL_EPISODE_FIN_DTLS",0,"");
		}           
	 }      
		
}       
						  
/*   <-----------------Added By Madesh         */   

fetch_legend_value()
{


	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRBILLD.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRBILLD.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1421;
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
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1444;
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
get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	
	  
 
	:nd_loc_date :=sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/RRRR HH24:MI'),:p_language_id);  

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/RRRR HH24:MI' ) , :p_language_id ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1475;
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
