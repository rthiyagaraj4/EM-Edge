
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
    "E:\\Desktop\\CRF-120\\5343\\BLRCVREG\\BLRCVREG.PC"
};


static unsigned long sqlctx = 1541887133;


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
            void  *sqhstv[21];
   unsigned int   sqhstl[21];
            int   sqhsts[21];
            void  *sqindv[21];
            int   sqinds[21];
   unsigned int   sqharm[21];
   unsigned int   *sqharc[21];
   unsigned short  sqadto[21];
   unsigned short  sqtdso[21];
} sqlstm = {10,21};

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
"'~~~~~~~~~~~~~~~~~~~~')) and NVL(A.GROUP_CODE,'!!!!!!') between nvl(:b13,'!!\
!!!!') and nvl(:b14,'~~~~~~')) and NVL(B.EPISODE_TYPE,'A')=DECODE(:b15,'A',NVL\
(B.EPISODE_TYPE,'A'),:b15)) and NVL(B.EPISODE_ID,0)=nvl(to_number(:b17),NVL(B.\
EPISODE_ID,0))) and NVL(B.VISIT_ID,0)=nvl(to_number(:b18),NVL(B.VISIT_ID,0))) \
order by TO_CHAR(A.DOC_REF_DATE,'YYYYMM'),A.DOC_REF_NUM            ";

 static const char *sq0006 = 
"(:b10,'~~~~~~~~')) and NVL(A.PATIENT_ID,'!!!!!!!!!!!!!!!!!!!!') between nvl(\
:b11,'!!!!!!!!!!!!!!!!!!!!') and nvl(:b12,'~~~~~~~~~~~~~~~~~~~~')) and NVL(A.G\
ROUP_CODE,'!!!!!!') between nvl(:b13,'!!!!!!') and nvl(:b14,'~~~~~~')) and NVL\
(C.EPISODE_TYPE,'A')=DECODE(:b15,'A',NVL(C.EPISODE_TYPE,'A'),:b15)) and NVL(C.\
EPISODE_ID,0)=nvl(to_number(:b17),NVL(C.EPISODE_ID,0))) and NVL(C.VISIT_ID,0)=\
nvl(to_number(:b18),NVL(C.VISIT_ID,0))) order by A.DOC_REF_NUM,B.DOC_REF_SLNO \
           ";

 static const char *sq0007 = 
"(:b10,'~~~~~~~~')) and NVL(B.PATIENT_ID,'!!!!!!!!!!!!!!!!!!!!') between nvl(\
:b11,'!!!!!!!!!!!!!!!!!!!!') and nvl(:b12,'~~~~~~~~~~~~~~~~~~~~')) and NVL(B.G\
ROUP_CODE,'!!!!!!') between nvl(:b13,'!!!!!!') and nvl(:b14,'~~~~~~')) and NVL\
(B.EPISODE_TYPE,'A')=DECODE(:b15,'A',NVL(B.EPISODE_TYPE,'A'),:b15)) and NVL(B.\
EPISODE_ID,0)=nvl(to_number(:b17),NVL(B.EPISODE_ID,0))) and NVL(B.VISIT_ID,0)=\
nvl(to_number(:b18),NVL(B.VISIT_ID,0))) order by A.DOC_REF_NUM,B.DOC_REF_SLNO \
           ";

 static const char *sq0008 = 
"select A.DOC_REF_NUM ,TO_CHAR(A.DOC_REF_DATE,'DD/MM/YYYY') ,A.BLNG_GRP_ID ,A\
.CUST_CODE ,A.GROUP_CODE ,A.PATIENT_ID ,B.EPISODE_TYPE ,B.EPISODE_ID ,B.VISIT_\
ID ,TO_CHAR(B.CUT_OFF_DATE,'DD/MM/YYYY') ,A.CANCELLED_YN ,A.TOT_OUTST_AMT ,A.C\
ONTACT_NAME ,TO_CHAR(A.DOC_REF_DATE,'YYYYMM')  from BL_COVERING_LET_HEADER_T A\
 ,BL_COVERING_LET_GEN_CRIT_T B where ((A.OPERATING_FACILITY_ID=B.OPERATING_FAC\
ILITY_ID and A.DOC_REF_NUM between B.DOC_REF_NUM_START and B.DOC_REF_NUM_END) \
and A.OPERATING_FACILITY_ID=:b0) order by TO_CHAR(A.DOC_REF_DATE,'YYYYMM'),A.D\
OC_REF_NUM            ";

 static const char *sq0009 = 
"select A.DOC_REF_NUM ,TO_CHAR(A.DOC_REF_DATE,'DD/MM/YYYY') ,B.DOC_REF_SLNO ,\
B.BLNG_GRP_ID ,B.CUST_CODE ,B.GROUP_CODE ,B.PATIENT_ID ,B.EPISODE_TYPE ,B.EPIS\
ODE_ID ,B.VISIT_ID ,TO_CHAR(C.CUT_OFF_DATE,'DD/MM/YYYY') ,A.CANCELLED_YN ,A.TO\
T_OUTST_AMT ,B.DOC_TYPE_CODE ,B.DOC_NUMBER ,B.CANCELLED_YN ,B.EDITED_YN ,B.APP\
ENDED_YN ,B.DOC_OUTST_AMT  from BL_COVERING_LET_HEADER_T A ,BL_COVERING_LET_DE\
TAIL_T B ,BL_COVERING_LET_GEN_CRIT_T C where (((A.OPERATING_FACILITY_ID=B.OPER\
ATING_FACILITY_ID and A.DOC_REF_NUM=B.DOC_REF_NUM) and A.DOC_REF_NUM between C\
.DOC_REF_NUM_START and C.DOC_REF_NUM_END) and A.OPERATING_FACILITY_ID=:b0) ord\
er by A.DOC_REF_NUM,B.DOC_REF_SLNO            ";

 static const char *sq0010 = 
"select A.DOC_REF_NUM ,TO_CHAR(A.DOC_REF_DATE,'DD/MM/YYYY') ,B.DOC_REF_SLNO ,\
B.BLNG_GRP_ID ,B.CUST_CODE ,B.GROUP_CODE ,B.PATIENT_ID ,B.EPISODE_TYPE ,B.EPIS\
ODE_ID ,B.VISIT_ID ,TO_CHAR(C.CUT_OFF_DATE,'DD/MM/YYYY') ,A.CANCELLED_YN ,A.TO\
T_OUTST_AMT ,B.DOC_TYPE_CODE ,B.DOC_NUMBER ,B.CANCELLED_YN ,B.EDITED_YN ,B.APP\
ENDED_YN ,B.DOC_OUTST_AMT  from BL_COVERING_LET_HEADER_T A ,BL_COVERING_LET_DE\
TAIL_T B ,BL_COVERING_LET_GEN_CRIT_T C where (((A.OPERATING_FACILITY_ID=B.OPER\
ATING_FACILITY_ID and A.DOC_REF_NUM=B.DOC_REF_NUM) and A.DOC_REF_NUM between C\
.DOC_REF_NUM_START and C.DOC_REF_NUM_END) and A.OPERATING_FACILITY_ID=:b0) ord\
er by A.DOC_REF_NUM,B.DOC_REF_SLNO            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,157,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,342,0,4,185,0,0,21,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
135,0,0,3,84,0,2,258,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
162,0,0,4,445,0,4,268,0,0,19,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
253,0,0,5,1401,0,9,536,0,0,19,19,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,1,0,0,1,1,0,0,1,9,0,0,1,9,0,0,
344,0,0,6,1501,0,9,542,0,0,19,19,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,1,0,0,1,1,0,0,1,9,0,0,1,9,0,0,
435,0,0,7,1501,0,9,548,0,0,19,19,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,1,0,0,1,1,0,0,1,9,0,0,1,9,0,0,
526,0,0,8,566,0,9,554,0,0,1,1,0,1,0,1,9,0,0,
545,0,0,9,668,0,9,560,0,0,1,1,0,1,0,1,9,0,0,
564,0,0,10,668,0,9,566,0,0,1,1,0,1,0,1,9,0,0,
583,0,0,5,0,0,15,576,0,0,0,0,0,1,0,
598,0,0,6,0,0,15,582,0,0,0,0,0,1,0,
613,0,0,7,0,0,15,588,0,0,0,0,0,1,0,
628,0,0,8,0,0,15,594,0,0,0,0,0,1,0,
643,0,0,9,0,0,15,600,0,0,0,0,0,1,0,
658,0,0,10,0,0,15,606,0,0,0,0,0,1,0,
673,0,0,5,0,0,13,648,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
744,0,0,6,0,0,13,671,0,0,19,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
2,1,0,0,2,1,0,0,2,1,0,0,2,4,0,0,
835,0,0,7,0,0,13,700,0,0,19,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
2,1,0,0,2,1,0,0,2,1,0,0,2,4,0,0,
926,0,0,8,0,0,13,726,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
997,0,0,9,0,0,13,747,0,0,19,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
2,1,0,0,2,1,0,0,2,1,0,0,2,4,0,0,
1088,0,0,10,0,0,13,774,0,0,19,0,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,4,0,0,2,9,0,0,2,9,0,
0,2,1,0,0,2,1,0,0,2,1,0,0,2,4,0,0,
1179,0,0,11,70,0,4,964,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1206,0,0,12,218,0,4,1068,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,1,9,0,0,
1249,0,0,13,0,0,32,1093,0,0,0,0,0,1,0,
1264,0,0,14,96,0,4,1508,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
1287,0,0,15,162,0,6,1515,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
1318,0,0,16,200,0,6,1568,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1345,0,0,17,199,0,6,1596,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRCVREG.PC                                  */
/* AUTHOR                : Robert Joseph                                */  
/* DATE WRITTEN          : 05/10/2005                                   */      
/************************************************************************/
          

#include <stdio.h>         
#include <string.h> 
#include <bl.h>       
#include <math.h> 

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
#define NODATAFOUND			  (sqlca.sqlcode == 1403)
#define OERROR          (sqlca.sqlcode < 0)
#define MAX_LINES 42
#define VER  "VER : 4.10\n"
#define ESC  0x1B
/*
#define DEBUG 0
*/


/* EXEC SQL BEGIN DECLARE SECTION; */ 



/* VARCHAR     d_acc_entity_name				[61],
			d_user							[31],
			d_head_name						[31],
			d_sysdate						[21],
			d_curr_date						[20],
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
            nd_facility				        [3],
			nd_module_id					[3],
			nd_fm_doc_ref_date				[12],
			nd_fm_doc_ref_date1				[12],
			date_convert                    [21],
			nd_to_doc_ref_date				[12],
			nd_to_doc_ref_date1				[12],
			nd_fm_doc_ref_num				[31],
			nd_to_doc_ref_num				[31],
			nd_fm_blng_grp_id				[5],
			nd_to_blng_grp_id				[5],
			nd_fm_cust_code					[9],
			nd_to_cust_code					[9],
			nd_fm_patient_id				[21],
			nd_to_patient_id				[21],
			nd_fm_group_code				[7],
			nd_to_group_code				[7],
			nd_episode_id					[9],
			nd_visit_id						[5],
			d_doc_ref_num					[31],
			d_doc_ref_date					[12],
			d_doc_ref_date1					[12],
			d_doc_ref_date_ord				[7],
			d_cut_off_date					[12],
			d_cut_off_date1					[12],
			d_blng_grp_id					[5],
			d_cust_code						[9],
			d_group_code					[7],
			d_patient_id					[21],
			d_episode_id					[9],
			d_visit_id						[5],
			d_bill_doc_type					[7],
			d_bill_doc_num					[8],
			d_contact_name					[101],

			preview_doc_ref_num				[21],
			
			temp_doc_ref_num				[21],
			temp_date_yyyymm				[7],

			l_translated_value				[201],
			l_pk_value						[100],
			
			pv_cut_off_date					[12],
			pv_module_id					[3],
			pv_blng_grp_id					[5],
			pv_fm_cust_code					[9],
			pv_to_cust_code					[9],
			pv_fm_patient_id				[21],
			pv_to_patient_id				[21],
			pv_group_code					[7],
			pv_episode_id					[9],
			pv_visit_id						[5],
			language_id						[3],
			p_language_id					[3],
			nd_temp_date					[12],
			nd_loc_date						[12],
			nd_temp_date1					[12],
			nd_loc_date1					[12]; */ 
struct { unsigned short len; unsigned char arr[61]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[31]; } d_head_name;

struct { unsigned short len; unsigned char arr[21]; } d_sysdate;

struct { unsigned short len; unsigned char arr[20]; } d_curr_date;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[3]; } nd_module_id;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_ref_date;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_ref_date1;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_ref_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_ref_date1;

struct { unsigned short len; unsigned char arr[31]; } nd_fm_doc_ref_num;

struct { unsigned short len; unsigned char arr[31]; } nd_to_doc_ref_num;

struct { unsigned short len; unsigned char arr[5]; } nd_fm_blng_grp_id;

struct { unsigned short len; unsigned char arr[5]; } nd_to_blng_grp_id;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_cust_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[21]; } nd_fm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_to_patient_id;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_group_code;

struct { unsigned short len; unsigned char arr[7]; } nd_to_group_code;

struct { unsigned short len; unsigned char arr[9]; } nd_episode_id;

struct { unsigned short len; unsigned char arr[5]; } nd_visit_id;

struct { unsigned short len; unsigned char arr[31]; } d_doc_ref_num;

struct { unsigned short len; unsigned char arr[12]; } d_doc_ref_date;

struct { unsigned short len; unsigned char arr[12]; } d_doc_ref_date1;

struct { unsigned short len; unsigned char arr[7]; } d_doc_ref_date_ord;

struct { unsigned short len; unsigned char arr[12]; } d_cut_off_date;

struct { unsigned short len; unsigned char arr[12]; } d_cut_off_date1;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[9]; } d_cust_code;

struct { unsigned short len; unsigned char arr[7]; } d_group_code;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[7]; } d_bill_doc_type;

struct { unsigned short len; unsigned char arr[8]; } d_bill_doc_num;

struct { unsigned short len; unsigned char arr[101]; } d_contact_name;

struct { unsigned short len; unsigned char arr[21]; } preview_doc_ref_num;

struct { unsigned short len; unsigned char arr[21]; } temp_doc_ref_num;

struct { unsigned short len; unsigned char arr[7]; } temp_date_yyyymm;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[12]; } pv_cut_off_date;

struct { unsigned short len; unsigned char arr[3]; } pv_module_id;

struct { unsigned short len; unsigned char arr[5]; } pv_blng_grp_id;

struct { unsigned short len; unsigned char arr[9]; } pv_fm_cust_code;

struct { unsigned short len; unsigned char arr[9]; } pv_to_cust_code;

struct { unsigned short len; unsigned char arr[21]; } pv_fm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } pv_to_patient_id;

struct { unsigned short len; unsigned char arr[7]; } pv_group_code;

struct { unsigned short len; unsigned char arr[9]; } pv_episode_id;

struct { unsigned short len; unsigned char arr[5]; } pv_visit_id;

struct { unsigned short len; unsigned char arr[3]; } language_id;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[12]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[12]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[12]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[12]; } nd_loc_date1;


	/* VARCHAR	nd_rep_type						[2], 
			nd_rep_preview_ind				[2],
			pv_episode_type					[2], 
			pv_break_by						[2],
			pv_body_hdr_yn					[2], 
			pv_body_foot_yn					[2], 
			pv_print_text_yn				[2],
			pv_foreign_curr_yn				[2], 
			pv_foot_note_yn					[2], 
			pv_sign_yn						[2]; */ 
struct { unsigned short len; unsigned char arr[2]; } nd_rep_type;

struct { unsigned short len; unsigned char arr[2]; } nd_rep_preview_ind;

struct { unsigned short len; unsigned char arr[2]; } pv_episode_type;

struct { unsigned short len; unsigned char arr[2]; } pv_break_by;

struct { unsigned short len; unsigned char arr[2]; } pv_body_hdr_yn;

struct { unsigned short len; unsigned char arr[2]; } pv_body_foot_yn;

struct { unsigned short len; unsigned char arr[2]; } pv_print_text_yn;

struct { unsigned short len; unsigned char arr[2]; } pv_foreign_curr_yn;

struct { unsigned short len; unsigned char arr[2]; } pv_foot_note_yn;

struct { unsigned short len; unsigned char arr[2]; } pv_sign_yn;


	char    nd_episode_type,  d_episode_type, d_cl_cancelled_yn, 
			d_bill_cancelled_yn, d_edited_yn, d_appended_yn; 

	int		i,d_sl_no=0,page_no=0, REP_WIDTH = 146;
	
	double	d_outst_amt				= 0,
			d_tot_outst_amt			= 0,
			d_sub_tot_outst_amt		= 0,
			d_grand_tot_outst_amt	= 0;

	char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];

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

char string_var [100];

int    lctr = 0,pctr = 0,nvalid = 0,ncancel = 0, recctr = 1, ftime = 0, bgftime = 0;

FILE *fp;

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

	strcpy(g_pgm_id,"BLRCVREG");
    strcpy(nd_pwd.arr,argv[1]);
    nd_pwd.len = strlen(nd_pwd.arr);
	 
    /* EXEC sql connect :nd_pwd; */ 

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
    sqlstm.sqhstv[0] = (         void  *)&nd_pwd;
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


  	  
    if (sqlca.sqlcode < 0 )
	{
        disp_message(ORA_MESG,"Error in connecting to Oracle");
        proc_exit();
    }

		set_meduser_role();
		
		strcpy(p_language_id.arr,l_language_id.arr);
		p_language_id.len = l_language_id.len;
 
    	strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    	d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    	strcpy(nd_session_id.arr,argv[2]);
    	nd_session_id.len = strlen(nd_session_id.arr);
    	strcpy(g_session_id,nd_session_id.arr);

    	strcpy(nd_pgm_date.arr,argv[3]);
    	nd_pgm_date.len = strlen(nd_pgm_date.arr);
    	strcpy(g_pgm_date,nd_pgm_date.arr);

    	strcpy(nd_facility.arr,argv[4]);
    	nd_facility.len = strlen(nd_facility.arr);
    	strcpy(g_facility_id,nd_facility.arr);

    /* EXEC SQL SELECT	nvl(param1,'**'),
					param2,
					param3,
					param4,
					param5,
					param6,
					param7,
					param8,
					param9,
					param10,
					param11,
					param12,
					param13,
					nvl(param14,'A'),
					param15,
					param16,
					param17,
					param18
			 INTO	:nd_module_id,
					:nd_fm_doc_ref_date,
					:nd_to_doc_ref_date,
					:nd_fm_doc_ref_num,
					:nd_to_doc_ref_num,
					:nd_fm_blng_grp_id,
					:nd_to_blng_grp_id,
					:nd_fm_cust_code,
					:nd_to_cust_code,
					:nd_fm_patient_id,
					:nd_to_patient_id,
					:nd_fm_group_code,
					:nd_to_group_code,
					:nd_episode_type,
					:nd_episode_id,
					:nd_visit_id,
					:nd_rep_type,
					:nd_rep_preview_ind
			 FROM	SY_PROG_PARAM
			 WHERE PGM_ID		= :d_curr_pgm_name
			 AND   SESSION_ID	= :nd_session_id
			 AND   PGM_DATE		= :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select nvl(param1,'**') ,param2 ,param3 ,param4 ,param5 ,\
param6 ,param7 ,param8 ,param9 ,param10 ,param11 ,param12 ,param13 ,nvl(param1\
4,'A') ,param15 ,param16 ,param17 ,param18 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b\
7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17  from SY_PROG_PARAM where ((\
PGM_ID=:b18 and SESSION_ID=:b19) and PGM_DATE=:b20)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_module_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_ref_date;
    sqlstm.sqhstl[1] = (unsigned int  )14;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_ref_date;
    sqlstm.sqhstl[2] = (unsigned int  )14;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_ref_num;
    sqlstm.sqhstl[3] = (unsigned int  )33;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_ref_num;
    sqlstm.sqhstl[4] = (unsigned int  )33;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_fm_blng_grp_id;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_to_blng_grp_id;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_fm_cust_code;
    sqlstm.sqhstl[7] = (unsigned int  )11;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_to_cust_code;
    sqlstm.sqhstl[8] = (unsigned int  )11;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_fm_patient_id;
    sqlstm.sqhstl[9] = (unsigned int  )23;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_to_patient_id;
    sqlstm.sqhstl[10] = (unsigned int  )23;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_fm_group_code;
    sqlstm.sqhstl[11] = (unsigned int  )9;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_to_group_code;
    sqlstm.sqhstl[12] = (unsigned int  )9;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[13] = (unsigned int  )1;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[14] = (unsigned int  )11;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_visit_id;
    sqlstm.sqhstl[15] = (unsigned int  )7;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_rep_type;
    sqlstm.sqhstl[16] = (unsigned int  )4;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_rep_preview_ind;
    sqlstm.sqhstl[17] = (unsigned int  )4;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_curr_pgm_name;
    sqlstm.sqhstl[18] = (unsigned int  )17;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[19] = (unsigned int  )18;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[20] = (unsigned int  )27;
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



			 
			 								

   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

	
	//sprintf(string_var,"01 %c %c",nd_rep_type, nd_rep_preview_ind);
	//disp_message(ERR_MESG,string_var);

	nd_module_id.arr[nd_module_id.len]					= '\0';
	nd_fm_doc_ref_date.arr[nd_fm_doc_ref_date.len]		= '\0';
	nd_to_doc_ref_date.arr[nd_to_doc_ref_date.len]		= '\0';
	nd_fm_doc_ref_num.arr[nd_fm_doc_ref_num.len]		= '\0';
	nd_to_doc_ref_num.arr[nd_to_doc_ref_num.len]		= '\0';
	nd_fm_blng_grp_id.arr[nd_fm_blng_grp_id.len]		= '\0';
	nd_to_blng_grp_id.arr[nd_to_blng_grp_id.len]		= '\0';
	nd_fm_cust_code.arr[nd_fm_cust_code.len]			= '\0';
	nd_to_cust_code.arr[nd_to_cust_code.len]			= '\0';
	nd_fm_patient_id.arr[nd_fm_patient_id.len]			= '\0';
	nd_to_patient_id.arr[nd_to_patient_id.len]			= '\0';
	nd_fm_group_code.arr[nd_fm_group_code.len]			= '\0';
	nd_to_group_code.arr[nd_to_group_code.len]			= '\0';
	nd_episode_id.arr[nd_episode_id.len]				= '\0';
	nd_visit_id.arr[nd_visit_id.len]					= '\0';
	nd_rep_type.arr[nd_rep_type.len]					= '\0';
	nd_rep_preview_ind.arr[nd_rep_preview_ind.len]		= '\0';

    
   /* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )135;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[0] = (unsigned int  )17;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[2] = (unsigned int  )27;
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
        err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");

   if (nd_rep_preview_ind.arr[0] == 'P')
   {
		/* EXEC SQL select cut_off_date, nvl(module_id,'**'), blng_grp_id,
						cust_code_from, cust_code_to,
						patient_id_from, patient_id_to,
						group_code, nvl(episode_type,'A'), episode_id,
						visit_id, break_by_cust_grp_yn,
						body_header_yn, body_foot_yn,
						foot_note_yn, foreign_currency_yn,
						authorized_sign_yn, print_text_yn
				 into	:pv_cut_off_date, :pv_module_id, :pv_blng_grp_id,
						:pv_fm_cust_code, :pv_to_cust_code, 
						:pv_fm_patient_id, :pv_to_patient_id,
						:pv_group_code, :pv_episode_type,
						:pv_episode_id, :pv_visit_id,
						:pv_break_by, :pv_body_hdr_yn, 
						:pv_body_foot_yn, :pv_foot_note_yn,
						:pv_foreign_curr_yn,  :pv_sign_yn, 
						:pv_print_text_yn
				from bl_covering_let_gen_crit_t
				where operating_facility_id = :nd_facility; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select cut_off_date ,nvl(module_id,'**') ,blng_grp_id ,cust\
_code_from ,cust_code_to ,patient_id_from ,patient_id_to ,group_code ,nvl(epis\
ode_type,'A') ,episode_id ,visit_id ,break_by_cust_grp_yn ,body_header_yn ,bod\
y_foot_yn ,foot_note_yn ,foreign_currency_yn ,authorized_sign_yn ,print_text_y\
n into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:\
b16,:b17  from bl_covering_let_gen_crit_t where operating_facility_id=:b18";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )162;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&pv_cut_off_date;
  sqlstm.sqhstl[0] = (unsigned int  )14;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&pv_module_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&pv_blng_grp_id;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&pv_fm_cust_code;
  sqlstm.sqhstl[3] = (unsigned int  )11;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&pv_to_cust_code;
  sqlstm.sqhstl[4] = (unsigned int  )11;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&pv_fm_patient_id;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&pv_to_patient_id;
  sqlstm.sqhstl[6] = (unsigned int  )23;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&pv_group_code;
  sqlstm.sqhstl[7] = (unsigned int  )9;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&pv_episode_type;
  sqlstm.sqhstl[8] = (unsigned int  )4;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&pv_episode_id;
  sqlstm.sqhstl[9] = (unsigned int  )11;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&pv_visit_id;
  sqlstm.sqhstl[10] = (unsigned int  )7;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&pv_break_by;
  sqlstm.sqhstl[11] = (unsigned int  )4;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&pv_body_hdr_yn;
  sqlstm.sqhstl[12] = (unsigned int  )4;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&pv_body_foot_yn;
  sqlstm.sqhstl[13] = (unsigned int  )4;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&pv_foot_note_yn;
  sqlstm.sqhstl[14] = (unsigned int  )4;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&pv_foreign_curr_yn;
  sqlstm.sqhstl[15] = (unsigned int  )4;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&pv_sign_yn;
  sqlstm.sqhstl[16] = (unsigned int  )4;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&pv_print_text_yn;
  sqlstm.sqhstl[17] = (unsigned int  )4;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&nd_facility;
  sqlstm.sqhstl[18] = (unsigned int  )5;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
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



		pv_cut_off_date.arr[pv_cut_off_date.len]		= '\0';
		pv_module_id.arr[pv_module_id.len]				= '\0';
		pv_blng_grp_id.arr[pv_blng_grp_id.len]			= '\0';
		pv_fm_cust_code.arr[pv_fm_cust_code.len]		= '\0';
		pv_to_cust_code.arr[pv_to_cust_code.len]		= '\0';
		pv_fm_patient_id.arr[pv_fm_patient_id.len]		= '\0';
		pv_to_patient_id.arr[pv_to_patient_id.len]		= '\0';
		pv_group_code.arr[pv_group_code.len]			= '\0';
		pv_episode_type.arr[pv_episode_type.len]		= '\0';
		pv_episode_id.arr[pv_episode_id.len]			= '\0';
		pv_visit_id.arr[pv_visit_id.len]				= '\0';
		pv_break_by.arr[pv_break_by.len]				= '\0';
		pv_body_hdr_yn.arr[pv_body_hdr_yn.len]			= '\0';
		pv_body_foot_yn.arr[pv_body_foot_yn.len]		= '\0';
		pv_print_text_yn.arr[pv_print_text_yn.len]		= '\0';
		pv_foreign_curr_yn.arr[pv_foreign_curr_yn.len]	= '\0';
		pv_foot_note_yn.arr[pv_foot_note_yn.len]		= '\0';
		pv_sign_yn.arr[pv_sign_yn.len]					= '\0';
   }

    open_files();

    declare_cur();

	get_header_dtls();
	
	//get_language_id();

	fetch_legend_value();

	fprintf(fp,"%c&l1O",ESC);	/* Set Landscape*/ 
	fprintf(fp,"%c(s13.5H", ESC); /* Reduce the font size*/
	fprintf(fp,"%c&a3L",ESC); 	/* To Set the Left margin*/
	next_line(1);

	print_param();

	open_cur();

	ftime = 0;
   
  	while(fetch_cur())
	{
		
		print_rec();
	}

	if (ftime != 0)
	{
		check_line(7);

		print_sub_tot();
		print_grand_tot();
	}	

    print_end();

	fprintf(fp,"%cE",ESC); /* To Reset the Printer */
}

open_files()
{
	strcpy(filename,WORKING_DIR);
	strcat(filename,"BLRCVREG.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLRCVREG.lis");
       proc_exit();
    }

}

declare_cur()
{
	
	if ((nd_rep_type.arr[0] == 'S') && (nd_rep_preview_ind.arr[0] == 'R'))
	{
	/* EXEC SQL DECLARE SUMMARY_CUR CURSOR FOR
	SELECT	A.DOC_REF_NUM, TO_CHAR(A.DOC_REF_DATE,'DD/MM/YYYY'), A.BLNG_GRP_ID,
			A.CUST_CODE, A.GROUP_CODE, A.PATIENT_ID,
			B.EPISODE_TYPE, B.EPISODE_ID, B.VISIT_ID,
			TO_CHAR(B.CUT_OFF_DATE,'DD/MM/YYYY'), A.CANCELLED_YN, A.TOT_OUTST_AMT, A.CONTACT_NAME,
			TO_CHAR(A.DOC_REF_DATE,'YYYYMM')
	FROM	BL_COVERING_LET_HEADER A, BL_COVERING_LET_GEN_CRIT B
	WHERE	A.OPERATING_FACILITY_ID = :nd_facility
	AND		A.DOC_REF_NUM BETWEEN nvl(:nd_fm_doc_ref_num,'!!!!!!!!!!!!!!!!!!!!')
				AND nvl(:nd_to_doc_ref_num, '~~~~~~~~~~~~~~~~~~~~')
	AND		A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	AND		A.DOC_REF_NUM BETWEEN B.DOC_REF_NUM_START AND B.DOC_REF_NUM_END
	AND		A.DOC_REF_DATE BETWEEN to_date(nvl(:nd_fm_doc_ref_date,'01/01/0001'),'dd/mm/yyyy')
			AND to_date(nvl(:nd_to_doc_ref_date,'31/12/4712'),'dd/mm/yyyy')
	AND		B.MODULE_ID = DECODE(:nd_module_id, '**',B.MODULE_ID,:nd_module_id)
	AND		NVL(A.BLNG_GRP_ID,'!!') BETWEEN nvl(:nd_fm_blng_grp_id,'!!') AND
				nvl(:nd_to_blng_grp_id,'~~')
	AND		NVL(A.CUST_CODE,'!!!!!!!!') BETWEEN nvl(:nd_fm_cust_code, '!!!!!!!!')
			AND nvl(:nd_to_cust_code,'~~~~~~~~')
	AND		NVL(A.PATIENT_ID,'!!!!!!!!!!!!!!!!!!!!') BETWEEN nvl(:nd_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!')
				AND nvl(:nd_to_patient_id, '~~~~~~~~~~~~~~~~~~~~')
	AND		NVL(A.GROUP_CODE,'!!!!!!') BETWEEN nvl(:nd_fm_group_code,'!!!!!!')
				AND nvl(:nd_to_group_code,'~~~~~~')
	AND		NVL(B.EPISODE_TYPE,'A') = DECODE(:nd_episode_type,'A',NVL(B.EPISODE_TYPE,'A'),:nd_episode_type)
	AND		NVL(B.EPISODE_ID,0) = nvl(to_number(:nd_episode_id),NVL(B.EPISODE_ID,0))
	AND		NVL(B.VISIT_ID,0) = nvl(to_number(:nd_visit_id),NVL(B.VISIT_ID,0))
	ORDER BY TO_CHAR(A.DOC_REF_DATE,'YYYYMM'), A.DOC_REF_NUM; */ 


	if (OERROR)
        err_mesg("DECLARE failed on cursor SUMMARY_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'D') && (nd_rep_preview_ind.arr[0] == 'R'))
	{
	 

	/* EXEC SQL DECLARE DETAIL_CUR CURSOR FOR
	SELECT	A.DOC_REF_NUM, TO_CHAR(A.DOC_REF_DATE,'DD/MM/YYYY'), B.DOC_REF_SLNO,
			B.BLNG_GRP_ID, B.CUST_CODE, B.GROUP_CODE, B.PATIENT_ID,
			B.EPISODE_TYPE, B.EPISODE_ID, B.VISIT_ID,
			TO_CHAR(C.CUT_OFF_DATE,'DD/MM/YYYY'), A.CANCELLED_YN, A.TOT_OUTST_AMT, 
			B.DOC_TYPE_CODE, B.DOC_NUMBER, B.CANCELLED_YN, 
			B.EDITED_YN, B.APPENDED_YN, B.DOC_OUTST_AMT
	FROM	BL_COVERING_LET_HEADER A, BL_COVERING_LET_DETAIL B, BL_COVERING_LET_GEN_CRIT C
	WHERE	A.OPERATING_FACILITY_ID = :nd_facility
	AND		A.DOC_REF_NUM BETWEEN nvl(:nd_fm_doc_ref_num,'!!!!!!!!!!!!!!!!!!!!')
				AND nvl(:nd_to_doc_ref_num, '~~~~~~~~~~~~~~~~~~~~')
	AND		A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	AND		A.DOC_REF_NUM = B.DOC_REF_NUM
	AND		A.DOC_REF_NUM BETWEEN C.DOC_REF_NUM_START AND C.DOC_REF_NUM_END
	AND		A.DOC_REF_DATE BETWEEN to_date(nvl(:nd_fm_doc_ref_date,'01/01/0001'),'dd/mm/yyyy')
			AND to_date(nvl(:nd_to_doc_ref_date,'31/12/4712'),'dd/mm/yyyy')
	AND		C.MODULE_ID = DECODE(:nd_module_id, '**',C.MODULE_ID,:nd_module_id)
	AND		NVL(A.BLNG_GRP_ID,'!!') BETWEEN nvl(:nd_fm_blng_grp_id,'!!') AND
				nvl(:nd_to_blng_grp_id,'~~')
	AND		NVL(A.CUST_CODE,'!!!!!!!!') BETWEEN nvl(:nd_fm_cust_code, '!!!!!!!!')
			AND nvl(:nd_to_cust_code,'~~~~~~~~')
	AND		NVL(A.PATIENT_ID,'!!!!!!!!!!!!!!!!!!!!') BETWEEN nvl(:nd_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!')
				AND nvl(:nd_to_patient_id, '~~~~~~~~~~~~~~~~~~~~')
	AND		NVL(A.GROUP_CODE,'!!!!!!') BETWEEN nvl(:nd_fm_group_code,'!!!!!!')
				AND nvl(:nd_to_group_code,'~~~~~~')
	AND		NVL(C.EPISODE_TYPE,'A') = DECODE(:nd_episode_type,'A',NVL(C.EPISODE_TYPE,'A'),:nd_episode_type)
	AND		NVL(C.EPISODE_ID,0) = nvl(to_number(:nd_episode_id),NVL(C.EPISODE_ID,0))
	AND		NVL(C.VISIT_ID,0) = nvl(to_number(:nd_visit_id),NVL(C.VISIT_ID,0))
	ORDER BY A.DOC_REF_NUM, B.DOC_REF_SLNO; */ 



	if (OERROR)
        err_mesg("DECLARE failed on cursor DETAIL_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'O') && (nd_rep_preview_ind.arr[0] == 'R'))
	{
	/* EXEC SQL DECLARE OUTST_CUR CURSOR FOR
	SELECT	A.DOC_REF_NUM, TO_CHAR(A.DOC_REF_DATE,'DD/MM/YYYY'),  B.DOC_REF_SLNO,
			B.BLNG_GRP_ID, B.CUST_CODE, B.GROUP_CODE, B.PATIENT_ID,
			B.EPISODE_TYPE, B.EPISODE_ID, B.VISIT_ID,
			TO_CHAR(C.CUT_OFF_DATE,'DD/MM/YYYY'), A.CANCELLED_YN, A.TOT_OUTST_AMT, 
			B.DOC_TYPE_CODE, B.DOC_NUMBER, B.CANCELLED_YN, 
			B.EDITED_YN, B.APPENDED_YN, B.DOC_OUTST_AMT
	FROM	BL_COVERING_LET_HEADER A, BL_COVERING_LET_DETAIL B, BL_COVERING_LET_GEN_CRIT C
	WHERE	A.OPERATING_FACILITY_ID = :nd_facility
	AND		A.DOC_REF_NUM BETWEEN nvl(:nd_fm_doc_ref_num,'!!!!!!!!!!!!!!!!!!!!')
				AND nvl(:nd_to_doc_ref_num, '~~~~~~~~~~~~~~~~~~~~')
	AND		A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	AND		A.DOC_REF_NUM = B.DOC_REF_NUM
	AND		A.DOC_REF_NUM BETWEEN C.DOC_REF_NUM_START AND C.DOC_REF_NUM_END
	AND		A.DOC_REF_DATE BETWEEN to_date(nvl(:nd_fm_doc_ref_date,'01/01/0001'),'dd/mm/yyyy')
			AND to_date(nvl(:nd_to_doc_ref_date,'31/12/4712'),'dd/mm/yyyy')
	AND		B.MODULE_ID = DECODE(:nd_module_id, '**',B.MODULE_ID,:nd_module_id)
	AND		NVL(B.BLNG_GRP_ID,'!!') BETWEEN nvl(:nd_fm_blng_grp_id,'!!') AND
				nvl(:nd_to_blng_grp_id,'~~')
	AND		NVL(B.CUST_CODE,'!!!!!!!!') BETWEEN nvl(:nd_fm_cust_code, '!!!!!!!!')
			AND nvl(:nd_to_cust_code,'~~~~~~~~')
	AND		NVL(B.PATIENT_ID,'!!!!!!!!!!!!!!!!!!!!') BETWEEN nvl(:nd_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!')
				AND nvl(:nd_to_patient_id, '~~~~~~~~~~~~~~~~~~~~')
	AND		NVL(B.GROUP_CODE,'!!!!!!') BETWEEN nvl(:nd_fm_group_code,'!!!!!!')
				AND nvl(:nd_to_group_code,'~~~~~~')
	AND		NVL(B.EPISODE_TYPE,'A') = DECODE(:nd_episode_type,'A',NVL(B.EPISODE_TYPE,'A'),:nd_episode_type)
	AND		NVL(B.EPISODE_ID,0) = nvl(to_number(:nd_episode_id),NVL(B.EPISODE_ID,0))
	AND		NVL(B.VISIT_ID,0) = nvl(to_number(:nd_visit_id),NVL(B.VISIT_ID,0))
	ORDER BY A.DOC_REF_NUM,  B.DOC_REF_SLNO; */ 



	if (OERROR)
        err_mesg("DECLARE failed on cursor OUTST_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'S') && (nd_rep_preview_ind.arr[0] == 'P'))
	{
	/* EXEC SQL DECLARE SUMMARY_PV_CUR CURSOR FOR
	SELECT	A.DOC_REF_NUM, TO_CHAR(A.DOC_REF_DATE,'DD/MM/YYYY'), A.BLNG_GRP_ID,
			A.CUST_CODE, A.GROUP_CODE, A.PATIENT_ID,
			B.EPISODE_TYPE, B.EPISODE_ID, B.VISIT_ID,
			TO_CHAR(B.CUT_OFF_DATE,'DD/MM/YYYY'), A.CANCELLED_YN, A.TOT_OUTST_AMT, A.CONTACT_NAME,
			TO_CHAR(A.DOC_REF_DATE,'YYYYMM')
	FROM	BL_COVERING_LET_HEADER_T A, BL_COVERING_LET_GEN_CRIT_T B
	WHERE	A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	AND		A.DOC_REF_NUM BETWEEN B.DOC_REF_NUM_START AND B.DOC_REF_NUM_END
	AND		A.OPERATING_FACILITY_ID = :nd_facility
	ORDER BY TO_CHAR(A.DOC_REF_DATE,'YYYYMM'), A.DOC_REF_NUM; */ 


	if (OERROR)
        err_mesg("DECLARE failed on cursor SUMMARY_PV_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'D') && (nd_rep_preview_ind.arr[0] == 'P'))
	{
	  
	/* EXEC SQL DECLARE DETAIL_PV_CUR CURSOR FOR
	SELECT	A.DOC_REF_NUM, TO_CHAR(A.DOC_REF_DATE,'DD/MM/YYYY'), B.DOC_REF_SLNO,
			B.BLNG_GRP_ID, B.CUST_CODE, B.GROUP_CODE, B.PATIENT_ID,
			B.EPISODE_TYPE, B.EPISODE_ID, B.VISIT_ID,
			TO_CHAR(C.CUT_OFF_DATE,'DD/MM/YYYY'), A.CANCELLED_YN, A.TOT_OUTST_AMT, 
			B.DOC_TYPE_CODE, B.DOC_NUMBER, B.CANCELLED_YN, 
			B.EDITED_YN, B.APPENDED_YN, B.DOC_OUTST_AMT
	FROM	BL_COVERING_LET_HEADER_T A, BL_COVERING_LET_DETAIL_T B, BL_COVERING_LET_GEN_CRIT_T C
	WHERE	A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	AND		A.DOC_REF_NUM = B.DOC_REF_NUM
	AND		A.DOC_REF_NUM BETWEEN C.DOC_REF_NUM_START AND C.DOC_REF_NUM_END
	AND		A.OPERATING_FACILITY_ID = :nd_facility
	ORDER BY A.DOC_REF_NUM, B.DOC_REF_SLNO; */ 



	if (OERROR)
        err_mesg("DECLARE failed on cursor DETAIL_PV_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'O') && (nd_rep_preview_ind.arr[0] == 'P'))
	{
	/* EXEC SQL DECLARE OUTST_PV_CUR CURSOR FOR
	SELECT	A.DOC_REF_NUM, TO_CHAR(A.DOC_REF_DATE,'DD/MM/YYYY'),  B.DOC_REF_SLNO,
			B.BLNG_GRP_ID, B.CUST_CODE, B.GROUP_CODE, B.PATIENT_ID,
			B.EPISODE_TYPE, B.EPISODE_ID, B.VISIT_ID,
			TO_CHAR(C.CUT_OFF_DATE,'DD/MM/YYYY'), A.CANCELLED_YN, A.TOT_OUTST_AMT, 
			B.DOC_TYPE_CODE, B.DOC_NUMBER, B.CANCELLED_YN, 
			B.EDITED_YN, B.APPENDED_YN, B.DOC_OUTST_AMT
	FROM	BL_COVERING_LET_HEADER_T A, BL_COVERING_LET_DETAIL_T B, BL_COVERING_LET_GEN_CRIT_T C
	WHERE	A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	AND		A.DOC_REF_NUM = B.DOC_REF_NUM
	AND		A.DOC_REF_NUM BETWEEN C.DOC_REF_NUM_START AND C.DOC_REF_NUM_END
	AND		A.OPERATING_FACILITY_ID = :nd_facility
	ORDER BY A.DOC_REF_NUM,  B.DOC_REF_SLNO; */ 



	if (OERROR)
        err_mesg("DECLARE failed on cursor OUTST_PV_CUR",0,"");
	}
	
}

open_cur()
{
	if ((nd_rep_type.arr[0] == 'S') && (nd_rep_preview_ind.arr[0] == 'R'))
	{
		/* EXEC SQL OPEN SUMMARY_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select A.DOC_REF_NUM ,TO_CHAR(A.DOC_REF_DATE,'DD/MM/YYYY') ,A.BLNG_GRP_\
ID ,A.CUST_CODE ,A.GROUP_CODE ,A.PATIENT_ID ,B.EPISODE_TYPE ,B.EPISODE_ID ,B\
.VISIT_ID ,TO_CHAR(B.CUT_OFF_DATE,'DD/MM/YYYY') ,A.CANCELLED_YN ,A.TOT_OUTST\
_AMT ,A.CONTACT_NAME ,TO_CHAR(A.DOC_REF_DATE,'YYYYMM')  from BL_COVERING_LET\
_HEADER A ,BL_COVERING_LET_GEN_CRIT B where ((((((((((((A.OPERATING_FACILITY\
_ID=:b0 and A.DOC_REF_NUM between nvl(:b1,'!!!!!!!!!!!!!!!!!!!!') and nvl(:b\
2,'~~~~~~~~~~~~~~~~~~~~')) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_\
ID) and A.DOC_REF_NUM between B.DOC_REF_NUM_START and B.DOC_REF_NUM_END) and\
 A.DOC_REF_DATE between to_date(nvl(:b3,'01/01/0001'),'dd/mm/yyyy') and to_d\
ate(nvl(:b4,'31/12/4712'),'dd/mm/yyyy')) and B.MODULE_ID=DECODE(:b5,'**',B.M\
ODULE_ID,:b5)) and NVL(A.BLNG_GRP_ID,'!!') between nvl(:b7,'!!') and nvl(:b8\
,'~~')) and NVL(A.CUST_CODE,'!!!!!!!!') between nvl(:b9,'!!!!!!!!') and nvl(\
:b10,'~~~~~~~~')) and NVL(A.PATIENT_ID,'!!!!!!!!!!!!!!!!!!!!') between nvl(:\
b11,'!!!!!!!!!!!!!!!!!!!!') and nvl(:b12,");
  sqlstm.stmt = sq0005;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )253;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_ref_num;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_ref_num;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_ref_date;
  sqlstm.sqhstl[3] = (unsigned int  )14;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_ref_date;
  sqlstm.sqhstl[4] = (unsigned int  )14;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_module_id;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_module_id;
  sqlstm.sqhstl[6] = (unsigned int  )5;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fm_blng_grp_id;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_blng_grp_id;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_fm_cust_code;
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
  sqlstm.sqhstv[11] = (         void  *)&nd_fm_patient_id;
  sqlstm.sqhstl[11] = (unsigned int  )23;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_to_patient_id;
  sqlstm.sqhstl[12] = (unsigned int  )23;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_fm_group_code;
  sqlstm.sqhstl[13] = (unsigned int  )9;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_to_group_code;
  sqlstm.sqhstl[14] = (unsigned int  )9;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[15] = (unsigned int  )1;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[16] = (unsigned int  )1;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&nd_episode_id;
  sqlstm.sqhstl[17] = (unsigned int  )11;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&nd_visit_id;
  sqlstm.sqhstl[18] = (unsigned int  )7;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
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
        err_mesg("OPEN failed on cursor SUMMARY_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'D') && (nd_rep_preview_ind.arr[0] == 'R'))
	{
		/* EXEC SQL OPEN DETAIL_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select A.DOC_REF_NUM ,TO_CHAR(A.DOC_REF_DATE,'DD/MM/YYYY') ,B.DOC_REF_S\
LNO ,B.BLNG_GRP_ID ,B.CUST_CODE ,B.GROUP_CODE ,B.PATIENT_ID ,B.EPISODE_TYPE \
,B.EPISODE_ID ,B.VISIT_ID ,TO_CHAR(C.CUT_OFF_DATE,'DD/MM/YYYY') ,A.CANCELLED\
_YN ,A.TOT_OUTST_AMT ,B.DOC_TYPE_CODE ,B.DOC_NUMBER ,B.CANCELLED_YN ,B.EDITE\
D_YN ,B.APPENDED_YN ,B.DOC_OUTST_AMT  from BL_COVERING_LET_HEADER A ,BL_COVE\
RING_LET_DETAIL B ,BL_COVERING_LET_GEN_CRIT C where (((((((((((((A.OPERATING\
_FACILITY_ID=:b0 and A.DOC_REF_NUM between nvl(:b1,'!!!!!!!!!!!!!!!!!!!!') a\
nd nvl(:b2,'~~~~~~~~~~~~~~~~~~~~')) and A.OPERATING_FACILITY_ID=B.OPERATING_\
FACILITY_ID) and A.DOC_REF_NUM=B.DOC_REF_NUM) and A.DOC_REF_NUM between C.DO\
C_REF_NUM_START and C.DOC_REF_NUM_END) and A.DOC_REF_DATE between to_date(nv\
l(:b3,'01/01/0001'),'dd/mm/yyyy') and to_date(nvl(:b4,'31/12/4712'),'dd/mm/y\
yyy')) and C.MODULE_ID=DECODE(:b5,'**',C.MODULE_ID,:b5)) and NVL(A.BLNG_GRP_\
ID,'!!') between nvl(:b7,'!!') and nvl(:b8,'~~')) and NVL(A.CUST_CODE,'!!!!!\
!!!') between nvl(:b9,'!!!!!!!!') and nvl");
  sqlstm.stmt = sq0006;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )344;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_ref_num;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_ref_num;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_ref_date;
  sqlstm.sqhstl[3] = (unsigned int  )14;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_ref_date;
  sqlstm.sqhstl[4] = (unsigned int  )14;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_module_id;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_module_id;
  sqlstm.sqhstl[6] = (unsigned int  )5;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fm_blng_grp_id;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_blng_grp_id;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_fm_cust_code;
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
  sqlstm.sqhstv[11] = (         void  *)&nd_fm_patient_id;
  sqlstm.sqhstl[11] = (unsigned int  )23;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_to_patient_id;
  sqlstm.sqhstl[12] = (unsigned int  )23;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_fm_group_code;
  sqlstm.sqhstl[13] = (unsigned int  )9;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_to_group_code;
  sqlstm.sqhstl[14] = (unsigned int  )9;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[15] = (unsigned int  )1;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[16] = (unsigned int  )1;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&nd_episode_id;
  sqlstm.sqhstl[17] = (unsigned int  )11;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&nd_visit_id;
  sqlstm.sqhstl[18] = (unsigned int  )7;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
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
        err_mesg("OPEN failed on cursor DETAIL_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'O') && (nd_rep_preview_ind.arr[0] == 'R'))
	{
		/* EXEC SQL OPEN OUTST_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select A.DOC_REF_NUM ,TO_CHAR(A.DOC_REF_DATE,'DD/MM/YYYY') ,B.DOC_REF_S\
LNO ,B.BLNG_GRP_ID ,B.CUST_CODE ,B.GROUP_CODE ,B.PATIENT_ID ,B.EPISODE_TYPE \
,B.EPISODE_ID ,B.VISIT_ID ,TO_CHAR(C.CUT_OFF_DATE,'DD/MM/YYYY') ,A.CANCELLED\
_YN ,A.TOT_OUTST_AMT ,B.DOC_TYPE_CODE ,B.DOC_NUMBER ,B.CANCELLED_YN ,B.EDITE\
D_YN ,B.APPENDED_YN ,B.DOC_OUTST_AMT  from BL_COVERING_LET_HEADER A ,BL_COVE\
RING_LET_DETAIL B ,BL_COVERING_LET_GEN_CRIT C where (((((((((((((A.OPERATING\
_FACILITY_ID=:b0 and A.DOC_REF_NUM between nvl(:b1,'!!!!!!!!!!!!!!!!!!!!') a\
nd nvl(:b2,'~~~~~~~~~~~~~~~~~~~~')) and A.OPERATING_FACILITY_ID=B.OPERATING_\
FACILITY_ID) and A.DOC_REF_NUM=B.DOC_REF_NUM) and A.DOC_REF_NUM between C.DO\
C_REF_NUM_START and C.DOC_REF_NUM_END) and A.DOC_REF_DATE between to_date(nv\
l(:b3,'01/01/0001'),'dd/mm/yyyy') and to_date(nvl(:b4,'31/12/4712'),'dd/mm/y\
yyy')) and B.MODULE_ID=DECODE(:b5,'**',B.MODULE_ID,:b5)) and NVL(B.BLNG_GRP_\
ID,'!!') between nvl(:b7,'!!') and nvl(:b8,'~~')) and NVL(B.CUST_CODE,'!!!!!\
!!!') between nvl(:b9,'!!!!!!!!') and nvl");
  sqlstm.stmt = sq0007;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )435;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_fm_doc_ref_num;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_to_doc_ref_num;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_fm_doc_ref_date;
  sqlstm.sqhstl[3] = (unsigned int  )14;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_to_doc_ref_date;
  sqlstm.sqhstl[4] = (unsigned int  )14;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_module_id;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_module_id;
  sqlstm.sqhstl[6] = (unsigned int  )5;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fm_blng_grp_id;
  sqlstm.sqhstl[7] = (unsigned int  )7;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_blng_grp_id;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_fm_cust_code;
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
  sqlstm.sqhstv[11] = (         void  *)&nd_fm_patient_id;
  sqlstm.sqhstl[11] = (unsigned int  )23;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_to_patient_id;
  sqlstm.sqhstl[12] = (unsigned int  )23;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_fm_group_code;
  sqlstm.sqhstl[13] = (unsigned int  )9;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_to_group_code;
  sqlstm.sqhstl[14] = (unsigned int  )9;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[15] = (unsigned int  )1;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&nd_episode_type;
  sqlstm.sqhstl[16] = (unsigned int  )1;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&nd_episode_id;
  sqlstm.sqhstl[17] = (unsigned int  )11;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&nd_visit_id;
  sqlstm.sqhstl[18] = (unsigned int  )7;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
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
        err_mesg("OPEN failed on cursor OUTST_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'S') && (nd_rep_preview_ind.arr[0] == 'P'))
	{
		/* EXEC SQL OPEN SUMMARY_PV_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0008;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )526;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
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
        err_mesg("OPEN failed on cursor SUMMARY_PV_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'D') && (nd_rep_preview_ind.arr[0] == 'P'))
	{
		/* EXEC SQL OPEN DETAIL_PV_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0009;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )545;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
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
        err_mesg("OPEN failed on cursor DETAIL_PV_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'O') && (nd_rep_preview_ind.arr[0] == 'P'))
	{
		/* EXEC SQL OPEN OUTST_PV_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0010;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )564;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
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
        err_mesg("OPEN failed on cursor OUTST_PV_CUR",0,"");
	}
}

close_cur()
{
	if ((nd_rep_type.arr[0] == 'S') && (nd_rep_preview_ind.arr[0] == 'R'))
	{
		/* EXEC SQL CLOSE SUMMARY_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )583;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
        err_mesg("CLOSE failed on cursor SUMMARY_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'D') && (nd_rep_preview_ind.arr[0] == 'R'))
	{
		/* EXEC SQL CLOSE DETAIL_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )598;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
        err_mesg("CLOSE failed on cursor DETAIL_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'O') && (nd_rep_preview_ind.arr[0] == 'R'))
	{
		/* EXEC SQL CLOSE OUTST_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )613;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
        err_mesg("CLOSE failed on cursor OUTST_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'S') && (nd_rep_preview_ind.arr[0] == 'P'))
	{
		/* EXEC SQL CLOSE SUMMARY_PV_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )628;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
        err_mesg("CLOSE failed on cursor SUMMARY_PV_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'D') && (nd_rep_preview_ind.arr[0] == 'P'))
	{
		/* EXEC SQL CLOSE DETAIL_PV_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )643;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
        err_mesg("CLOSE failed on cursor DETAIL_PV_CUR",0,"");
	}
	else if ((nd_rep_type.arr[0] == 'O') && (nd_rep_preview_ind.arr[0] == 'P'))
	{
		/* EXEC SQL CLOSE OUTST_PV_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )658;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
        err_mesg("CLOSE failed on cursor OUTST_PV_CUR",0,"");
	}
}

fetch_cur()
{ 
	
	d_doc_ref_num.arr[0]		= '\0';
	d_doc_ref_date.arr[0]		= '\0';
	d_blng_grp_id.arr[0]		= '\0';
	d_cust_code.arr[0]			= '\0';
	d_group_code.arr[0]			= '\0';
	d_cut_off_date.arr[0]		= '\0';
	d_episode_id.arr[0]			= '\0';
	d_visit_id.arr[0]			= '\0';
	d_patient_id.arr[0]			= '\0';
	d_bill_doc_type.arr[0]		= '\0';
	d_bill_doc_num.arr[0]		= '\0';
	d_contact_name.arr[0]		= '\0';
	d_doc_ref_date_ord.arr[0]	= '\0';

	d_doc_ref_num.len			= 0;
	d_doc_ref_date.len			= 0;
	d_blng_grp_id.len			= 0;
	d_cust_code.len				= 0;
	d_group_code.len			= 0;
	d_cut_off_date.len			= 0;
	d_episode_id.len			= 0;
	d_visit_id.len				= 0;
	d_patient_id.len			= 0;
	d_bill_doc_type.len			= 0;
	d_bill_doc_num.len			= 0;
	d_contact_name.len			= 0;
	d_doc_ref_date_ord.arr[0]	= '\0';

	d_outst_amt		= 0;
	d_tot_outst_amt = 0;
		
	if ((nd_rep_type.arr[0] == 'S') && (nd_rep_preview_ind.arr[0] == 'R'))
	{
		/* EXEC SQL FETCH  SUMMARY_CUR INTO 
			:d_doc_ref_num,
			:d_doc_ref_date,
			:d_blng_grp_id,
			:d_cust_code,
			:d_group_code,
			:d_patient_id, 
			:d_episode_type,
			:d_episode_id,
			:d_visit_id,
			:d_cut_off_date,
			:d_cl_cancelled_yn,
			:d_tot_outst_amt,
			:d_contact_name,
			:d_doc_ref_date_ord; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )673;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_doc_ref_num;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_doc_ref_date;
  sqlstm.sqhstl[1] = (unsigned int  )14;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_blng_grp_id;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_cust_code;
  sqlstm.sqhstl[3] = (unsigned int  )11;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_group_code;
  sqlstm.sqhstl[4] = (unsigned int  )9;
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
  sqlstm.sqhstv[6] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[6] = (unsigned int  )1;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[7] = (unsigned int  )11;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_visit_id;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_cut_off_date;
  sqlstm.sqhstl[9] = (unsigned int  )14;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_cl_cancelled_yn;
  sqlstm.sqhstl[10] = (unsigned int  )1;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_tot_outst_amt;
  sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_contact_name;
  sqlstm.sqhstl[12] = (unsigned int  )103;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_doc_ref_date_ord;
  sqlstm.sqhstl[13] = (unsigned int  )9;
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
		err_mesg("FETCH failed on cursor SUMMARY_CUR ",0,"");	 
	}
	else if ((nd_rep_type.arr[0] == 'D') && (nd_rep_preview_ind.arr[0] == 'R'))
	{
	    
		
		/* EXEC SQL FETCH  DETAIL_CUR INTO 
			:d_doc_ref_num,
			:d_doc_ref_date,
			:d_sl_no,
			:d_blng_grp_id,
			:d_cust_code,
			:d_group_code,
			:d_patient_id, 
			:d_episode_type,
			:d_episode_id,
			:d_visit_id,
			:d_cut_off_date,
			:d_cl_cancelled_yn,
			:d_tot_outst_amt,
			:d_bill_doc_type,
			:d_bill_doc_num,
			:d_bill_cancelled_yn,
			:d_edited_yn,
			:d_appended_yn,
			:d_outst_amt; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )744;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_doc_ref_num;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_doc_ref_date;
  sqlstm.sqhstl[1] = (unsigned int  )14;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_sl_no;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_blng_grp_id;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_cust_code;
  sqlstm.sqhstl[4] = (unsigned int  )11;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_group_code;
  sqlstm.sqhstl[5] = (unsigned int  )9;
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
  sqlstm.sqhstv[7] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[7] = (unsigned int  )1;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[8] = (unsigned int  )11;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_visit_id;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_cut_off_date;
  sqlstm.sqhstl[10] = (unsigned int  )14;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_cl_cancelled_yn;
  sqlstm.sqhstl[11] = (unsigned int  )1;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_tot_outst_amt;
  sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_bill_doc_type;
  sqlstm.sqhstl[13] = (unsigned int  )9;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_bill_doc_num;
  sqlstm.sqhstl[14] = (unsigned int  )10;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&d_bill_cancelled_yn;
  sqlstm.sqhstl[15] = (unsigned int  )1;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_edited_yn;
  sqlstm.sqhstl[16] = (unsigned int  )1;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&d_appended_yn;
  sqlstm.sqhstl[17] = (unsigned int  )1;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&d_outst_amt;
  sqlstm.sqhstl[18] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
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
		err_mesg("FETCH failed on cursor DETAIL_CUR ",0,"");	
	}
	else if ((nd_rep_type.arr[0] == 'O') && (nd_rep_preview_ind.arr[0] == 'R'))
	{
	
		/* EXEC SQL FETCH  OUTST_CUR INTO
			:d_doc_ref_num,
			:d_doc_ref_date,
			:d_sl_no,
			:d_blng_grp_id,
			:d_cust_code,
			:d_group_code,
			:d_patient_id, 
			:d_episode_type,
			:d_episode_id,
			:d_visit_id,
			:d_cut_off_date,
			:d_cl_cancelled_yn,
			:d_tot_outst_amt,
			:d_bill_doc_type,
			:d_bill_doc_num,
			:d_bill_cancelled_yn,
			:d_edited_yn,
			:d_appended_yn,
			:d_outst_amt; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )835;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_doc_ref_num;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_doc_ref_date;
  sqlstm.sqhstl[1] = (unsigned int  )14;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_sl_no;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_blng_grp_id;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_cust_code;
  sqlstm.sqhstl[4] = (unsigned int  )11;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_group_code;
  sqlstm.sqhstl[5] = (unsigned int  )9;
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
  sqlstm.sqhstv[7] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[7] = (unsigned int  )1;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[8] = (unsigned int  )11;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_visit_id;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_cut_off_date;
  sqlstm.sqhstl[10] = (unsigned int  )14;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_cl_cancelled_yn;
  sqlstm.sqhstl[11] = (unsigned int  )1;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_tot_outst_amt;
  sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_bill_doc_type;
  sqlstm.sqhstl[13] = (unsigned int  )9;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_bill_doc_num;
  sqlstm.sqhstl[14] = (unsigned int  )10;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&d_bill_cancelled_yn;
  sqlstm.sqhstl[15] = (unsigned int  )1;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_edited_yn;
  sqlstm.sqhstl[16] = (unsigned int  )1;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&d_appended_yn;
  sqlstm.sqhstl[17] = (unsigned int  )1;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&d_outst_amt;
  sqlstm.sqhstl[18] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
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
		err_mesg("FETCH failed on cursor OUTST_CUR ",0,"");	
	}
	else if ((nd_rep_type.arr[0] == 'S') && (nd_rep_preview_ind.arr[0] == 'P'))
	{
		/* EXEC SQL FETCH  SUMMARY_PV_CUR INTO 
			:d_doc_ref_num,
			:d_doc_ref_date,
			:d_blng_grp_id,
			:d_cust_code,
			:d_group_code,
			:d_patient_id, 
			:d_episode_type,
			:d_episode_id,
			:d_visit_id,
			:d_cut_off_date,
			:d_cl_cancelled_yn,
			:d_tot_outst_amt,
			:d_contact_name,
			:d_doc_ref_date_ord; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )926;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_doc_ref_num;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_doc_ref_date;
  sqlstm.sqhstl[1] = (unsigned int  )14;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_blng_grp_id;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_cust_code;
  sqlstm.sqhstl[3] = (unsigned int  )11;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_group_code;
  sqlstm.sqhstl[4] = (unsigned int  )9;
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
  sqlstm.sqhstv[6] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[6] = (unsigned int  )1;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[7] = (unsigned int  )11;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_visit_id;
  sqlstm.sqhstl[8] = (unsigned int  )7;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_cut_off_date;
  sqlstm.sqhstl[9] = (unsigned int  )14;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_cl_cancelled_yn;
  sqlstm.sqhstl[10] = (unsigned int  )1;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_tot_outst_amt;
  sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_contact_name;
  sqlstm.sqhstl[12] = (unsigned int  )103;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_doc_ref_date_ord;
  sqlstm.sqhstl[13] = (unsigned int  )9;
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
		err_mesg("FETCH failed on cursor SUMMARY_PV_CUR ",0,"");	 
	}
	else if ((nd_rep_type.arr[0] == 'D') && (nd_rep_preview_ind.arr[0] == 'P'))
	{
		/* EXEC SQL FETCH  DETAIL_PV_CUR INTO 
			:d_doc_ref_num,
			:d_doc_ref_date,
			:d_sl_no,
			:d_blng_grp_id,
			:d_cust_code,
			:d_group_code,
			:d_patient_id, 
			:d_episode_type,
			:d_episode_id,
			:d_visit_id,
			:d_cut_off_date,
			:d_cl_cancelled_yn,
			:d_tot_outst_amt,
			:d_bill_doc_type,
			:d_bill_doc_num,
			:d_bill_cancelled_yn,
			:d_edited_yn,
			:d_appended_yn,
			:d_outst_amt; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )997;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_doc_ref_num;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_doc_ref_date;
  sqlstm.sqhstl[1] = (unsigned int  )14;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_sl_no;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_blng_grp_id;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_cust_code;
  sqlstm.sqhstl[4] = (unsigned int  )11;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_group_code;
  sqlstm.sqhstl[5] = (unsigned int  )9;
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
  sqlstm.sqhstv[7] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[7] = (unsigned int  )1;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[8] = (unsigned int  )11;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_visit_id;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_cut_off_date;
  sqlstm.sqhstl[10] = (unsigned int  )14;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_cl_cancelled_yn;
  sqlstm.sqhstl[11] = (unsigned int  )1;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_tot_outst_amt;
  sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_bill_doc_type;
  sqlstm.sqhstl[13] = (unsigned int  )9;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_bill_doc_num;
  sqlstm.sqhstl[14] = (unsigned int  )10;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&d_bill_cancelled_yn;
  sqlstm.sqhstl[15] = (unsigned int  )1;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_edited_yn;
  sqlstm.sqhstl[16] = (unsigned int  )1;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&d_appended_yn;
  sqlstm.sqhstl[17] = (unsigned int  )1;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&d_outst_amt;
  sqlstm.sqhstl[18] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
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
		err_mesg("FETCH failed on cursor DETAIL_PV_CUR ",0,"");	
	}
	else if ((nd_rep_type.arr[0] == 'O') && (nd_rep_preview_ind.arr[0] == 'P'))
	{
	
		/* EXEC SQL FETCH  OUTST_PV_CUR INTO
			:d_doc_ref_num,
			:d_doc_ref_date,
			:d_sl_no,
			:d_blng_grp_id,
			:d_cust_code,
			:d_group_code,
			:d_patient_id, 
			:d_episode_type,
			:d_episode_id,
			:d_visit_id,
			:d_cut_off_date,
			:d_cl_cancelled_yn,
			:d_tot_outst_amt,
			:d_bill_doc_type,
			:d_bill_doc_num,
			:d_bill_cancelled_yn,
			:d_edited_yn,
			:d_appended_yn,
			:d_outst_amt; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1088;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_doc_ref_num;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_doc_ref_date;
  sqlstm.sqhstl[1] = (unsigned int  )14;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_sl_no;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_blng_grp_id;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_cust_code;
  sqlstm.sqhstl[4] = (unsigned int  )11;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_group_code;
  sqlstm.sqhstl[5] = (unsigned int  )9;
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
  sqlstm.sqhstv[7] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[7] = (unsigned int  )1;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[8] = (unsigned int  )11;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_visit_id;
  sqlstm.sqhstl[9] = (unsigned int  )7;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_cut_off_date;
  sqlstm.sqhstl[10] = (unsigned int  )14;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_cl_cancelled_yn;
  sqlstm.sqhstl[11] = (unsigned int  )1;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_tot_outst_amt;
  sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_bill_doc_type;
  sqlstm.sqhstl[13] = (unsigned int  )9;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&d_bill_doc_num;
  sqlstm.sqhstl[14] = (unsigned int  )10;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&d_bill_cancelled_yn;
  sqlstm.sqhstl[15] = (unsigned int  )1;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_edited_yn;
  sqlstm.sqhstl[16] = (unsigned int  )1;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&d_appended_yn;
  sqlstm.sqhstl[17] = (unsigned int  )1;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&d_outst_amt;
  sqlstm.sqhstl[18] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
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
		err_mesg("FETCH failed on cursor OUTST_PV_CUR ",0,"");	
	}


    d_doc_ref_num.arr[d_doc_ref_num.len]		= '\0';
	d_doc_ref_date.arr[d_doc_ref_date.len]		= '\0';
	d_blng_grp_id.arr[d_blng_grp_id.len]		= '\0';
	d_cust_code.arr[d_cust_code.len]			= '\0';
	d_group_code.arr[d_group_code.len]			= '\0';
	d_cut_off_date.arr[d_cut_off_date.len]		= '\0';
	d_episode_id.arr[d_episode_id.len]			= '\0';
	d_visit_id.arr[d_visit_id.len]				= '\0';
	d_patient_id.arr[d_patient_id.len]			= '\0';
	d_bill_doc_type.arr[d_bill_doc_type.len]	= '\0';
	d_bill_doc_num.arr[d_bill_doc_num.len]		= '\0';
	d_contact_name.arr[d_contact_name.len]		= '\0';
	d_doc_ref_date_ord.arr[d_doc_ref_date_ord.len]	= '\0';

	return(LAST_ROW?0:1);   
}

print_rec()
{
    check_line(1);

	

	if (d_doc_ref_date.arr[0] !='\0')
	{ 
		get_initialize();

		strcpy(nd_temp_date.arr,d_doc_ref_date.arr);

		get_local_date_convn2();

		strcpy(d_doc_ref_date.arr,nd_loc_date.arr);

		d_doc_ref_date.arr[d_doc_ref_date.len] = '\0';
  
    }
	if (d_cut_off_date.arr[0] != '\0')
	{ 

		get_initialize();

		strcpy(nd_temp_date.arr,d_cut_off_date.arr);

		get_local_date_convn2();

		strcpy(d_cut_off_date.arr,nd_loc_date.arr);

		d_cut_off_date.arr[d_cut_off_date.len] = '\0';
	}

	if(nd_rep_type.arr[0] == 'S')
	{
	
		if (strcmp(temp_date_yyyymm.arr, d_doc_ref_date_ord.arr) != 0)
		{
			if (ftime == 1)
			{
				print_sub_tot();
				next_line(1);
			}
			
			strcpy(temp_date_yyyymm.arr,d_doc_ref_date_ord.arr);
			temp_date_yyyymm.len = strlen(d_doc_ref_date_ord.arr);
			temp_date_yyyymm.arr[temp_date_yyyymm.len]	= '\0';
		}

		if (nd_rep_preview_ind.arr[0] == 'P')
		{
			print_next_num();
			fprintf(fp,"%-28s ",preview_doc_ref_num.arr);
			
		}
		else
			fprintf(fp,"%-28s ",d_doc_ref_num.arr);
			//fprintf(fp,"%-30s ",d_doc_ref_num.arr);		//25/11/2005

		
		fprintf(fp,"%-10s %-8s %-12s %-9s %-14s %-11s    ",d_doc_ref_date.arr,d_blng_grp_id.arr,d_cust_code.arr,d_group_code.arr,d_patient_id.arr,d_cut_off_date.arr);
		
		
		print_formated(d_tot_outst_amt);

		if(d_cl_cancelled_yn == 'Y')
			fprintf(fp," %-10.10s",loc_legend[70]);
			
		else
			fprintf(fp," %-10.10s",loc_legend[61]);
			//fprintf(fp," %-6s","Active");
	
		fprintf(fp," %17.17s",d_contact_name.arr);

		if(d_cl_cancelled_yn != 'Y')
		{
			d_sub_tot_outst_amt		+= d_tot_outst_amt;
			d_grand_tot_outst_amt	+= d_tot_outst_amt;
		}
	}
	else
	{
		if (strcmp(temp_doc_ref_num.arr, d_doc_ref_num.arr) != 0)
		{
			if (ftime == 1)
			{
				print_sub_tot();
				next_line(1);
			}

			check_line(2);

			if (nd_rep_preview_ind.arr[0] == 'P')
			{
				print_next_num();
				fprintf(fp,"%-19.19s: %-28s ",preview_doc_ref_num.arr);	//25/11/2005
			}
			else
				fprintf(fp,"%-19.19s: %-28s",loc_legend[8],d_doc_ref_num.arr); //DOC_REF_NUM print Here Pradeep 
			
			  //fprintf(fp,"Covering Letter No: %-31s ",d_doc_ref_num.arr);			//25/11/2005

			fprintf(fp," %-4.4s: %-10s: %-12.12s: %-10s %-18.18s:",loc_legend[3],d_doc_ref_date.arr,loc_legend[66],d_cut_off_date.arr,loc_legend[64]);
			
			
			//fprintf(fp,"Date: %-11s Cut-off Date: %-11s Total Outst Amount: ",d_doc_ref_date.arr, d_cut_off_date.arr);
			print_formated(d_tot_outst_amt);
			if (d_cl_cancelled_yn == 'Y')
			fprintf(fp," %-8.8s:%-10.10s",loc_legend[67],loc_legend[60]);
			else
			fprintf(fp," %-8.8s:%-10.10s",loc_legend[67],loc_legend[60]);
			next_line(1);
			next_line(1);

			strcpy(temp_doc_ref_num.arr,d_doc_ref_num.arr);
			temp_doc_ref_num.len = strlen(d_doc_ref_num.arr);
			temp_doc_ref_num.arr[temp_doc_ref_num.len]	= '\0';
		}

		fprintf(fp,"%-7d %-8s %-12s %-9s %-14s %c/%-8s/%-4s %-6s/%-10s ",d_sl_no,d_blng_grp_id.arr,d_cust_code.arr,d_group_code.arr,d_patient_id.arr,d_episode_type,d_episode_id.arr,d_visit_id.arr,d_bill_doc_type.arr,d_bill_doc_num.arr);
		print_formated(d_outst_amt);

		if (d_bill_cancelled_yn == 'Y')
		fprintf(fp," %s",loc_legend[60]);
		else if (d_appended_yn == 'Y')
		fprintf(fp," %s",loc_legend[62]);
		else if(d_edited_yn == 'Y')
		fprintf(fp," %s",loc_legend[63]);
		

		if ((d_cl_cancelled_yn != 'Y') && (d_bill_cancelled_yn != 'Y'))
		{
			d_sub_tot_outst_amt		+= d_outst_amt;
			d_grand_tot_outst_amt	+= d_outst_amt;
		}
	}

	ftime = 1;
	next_line(1);

}

print_next_num()
{
	preview_doc_ref_num.arr[0]	= '\0';
	preview_doc_ref_num.len		= 0;

	/* EXEC SQL select substr(:d_doc_ref_num,1,instr(:d_doc_ref_num,'/'))||'Next No.'
	into :preview_doc_ref_num
	from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 21;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (substr(:b0,1,instr(:b0,'/'))||'Next No.') into :b2  \
from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1179;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_ref_num;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_ref_num;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&preview_doc_ref_num;
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



	preview_doc_ref_num.arr[preview_doc_ref_num.len] = '\0';
}

print_sub_tot()
{
	check_line(4);

	if (nd_rep_type.arr[0] == 'S')
	{
		fprintf(fp,"%101s"," ");
		print_line('-',15);
		next_line(1);
		fprintf(fp,"%95s%-7s",loc_legend[25]," ");
		
		print_formated(d_sub_tot_outst_amt);
		next_line(1);
		fprintf(fp,"%101s"," ");
		print_line('-',15);
		next_line(1);
	}
	else
	{
		fprintf(fp,"%88s"," ");
		print_line('-',15);
		next_line(1);
		fprintf(fp,"%87s  ",loc_legend[65]);//loc_legend[63]
		print_formated(d_sub_tot_outst_amt);
		next_line(1);
		fprintf(fp,"%88s"," ");
		print_line('-',15);
		next_line(1);
	}	
	d_sub_tot_outst_amt = 0;
}

print_grand_tot()
{
	if (nd_rep_type.arr[0] == 'S')
	{
		fprintf(fp,"%95s%-7s",loc_legend[69]," ");//loc_legend[65]
		//fprintf(fp,"%65s Grand Total %7s"," "," ");		//25/11/2005
		print_formated(d_grand_tot_outst_amt);
		next_line(1);
		fprintf(fp,"%101s"," ");
		print_line('-',15);
		next_line(1);
	}
	else
	{
		
		fprintf(fp,"%87s  ",loc_legend[69]);//loc_legend[65]
		print_formated(d_grand_tot_outst_amt);
		next_line(1);
		fprintf(fp,"%88s"," ");
		print_line('-',15);
		next_line(1);
	}	
}

print_column_title()
{
	if (nd_rep_type.arr[0] == 'S') 
	{
		
		fprintf(fp,"%-28.28s %-10.10s %-8.8s %-12.12s %-9.9s %-14.14s %-11.11s %17.17s   %-10.10s %s",loc_legend[8],loc_legend[3],loc_legend[18],loc_legend[10],loc_legend[11],loc_legend[12],loc_legend[14],loc_legend[15],loc_legend[23],loc_legend[24]);	
		//fprintf(fp,"%-30s %-10s %-4s %-8s %-6s %-10s %-10s %16s %-6s %-40s",loc_legend[8],loc_legend[3],loc_legend[18],loc_legend[10],loc_legend[11],loc_legend[12],loc_legend[14],loc_legend[15],loc_legend[23],loc_legend[24]);		//25/11/2005
		next_line(1);
	    fprintf(fp,"%-39.39s %-8.8s %-12.12s %-9.9s %-14.14s %s"," ",loc_legend[19],loc_legend[20],loc_legend[20]," ",loc_legend[3]);
	    //fprintf(fp,"%41s %-4s %-8s %-6s %10s %-10s"," ",loc_legend[19],loc_legend[20], loc_legend[20]," ",loc_legend[3]);
		next_line(1);
	}
	else
	{
		
		fprintf(fp,"%-7.7s %-8.8s %-12.12s %-9.9s %-14.14s %-15.15s %-16.16s %15.15s   %s",loc_legend[16],loc_legend[18], loc_legend[10], loc_legend[11], loc_legend[12], loc_legend[13],loc_legend[21], loc_legend[22],loc_legend[23]);
		next_line(1);
		fprintf(fp,"%-7.7s %-8.8s %-12.12s %s",loc_legend[17], loc_legend[19],loc_legend[20], loc_legend[20]);
		next_line(1);
	}
  
  print_line('-',REP_WIDTH);
  fprintf(fp,"%s","--");
  next_line(1);

}

get_header_dtls()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    d_acc_entity_name.arr[0] ='\0';
    d_curr_date.arr[0]   ='\0';
	d_user.arr[0] ='\0';
    d_sysdate.arr[0] ='\0';
	d_head_name.arr[0] ='\0';
    d_acc_entity_name.len =0;
    d_curr_date.len   =0;
	d_user.len =0;
    d_sysdate.len =0;
	d_head_name.len=0;

	/* EXEC SQL SELECT upper(ACC_ENTITY_NAME), /o description of the institution o/
				    USER, 
					TO_CHAR(SYSDATE, 'DD/MM/YYYY'),
					TO_CHAR(SYSDATE, 'HH24:MI:SS'),
					HEAD_OF_COMPANY_NAME
             INTO :d_acc_entity_name,
				  :d_user,
				  :d_sysdate,
				  :d_curr_date,
				  :d_head_name
			 FROM SY_ACC_ENTITY_LANG_VW
			 WHERE acc_entity_id = :nd_facility
			 AND   LANGUAGE_ID   = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 21;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,USER ,TO_CHAR(SYSDATE,'DD/MM/\
YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') ,HEAD_OF_COMPANY_NAME into :b0,:b1,:b2,:\
b3,:b4  from SY_ACC_ENTITY_LANG_VW where (acc_entity_id=:b5 and LANGUAGE_ID=:b\
6)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1206;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_user;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_sysdate;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_curr_date;
 sqlstm.sqhstl[3] = (unsigned int  )22;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_head_name;
 sqlstm.sqhstl[4] = (unsigned int  )33;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_facility;
 sqlstm.sqhstl[5] = (unsigned int  )5;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&p_language_id;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


			
    
	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len]                       = '\0';
	d_sysdate.arr[d_sysdate.len]                 = '\0';
	d_curr_date.arr[d_curr_date.len]			 = '\0';
	d_head_name.arr[d_head_name.len]			 = '\0';

   
	return;
	err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 21;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1249;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	proc_exit();
}

print_page_title()
{

	
	int hosp_nm_len,date1_len, rep_title_len = 10,v_title_len,v_title1_len, s1, s2,date_len,user_len,pgm_len,sub_title_len;
	char v_rep_title[200],v_as_on_date[12],v_sub_title[200],v_title[200],v_title1[200];
   
   //LINE 1

	fprintf(fp,"%-13.13s : BL",loc_legend[41]);//loc_legend[41]
	//fprintf(fp,"MDL : BL");
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(fp,"%s", d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	date1_len=strlen(loc_legend[3]);
	horz_skip(s2-date1_len-23);

	fprintf(fp,"%s : %s", loc_legend[3],d_sysdate.arr);
    
	next_line(1);
	
	//LINE 2

	fprintf(fp,"%-13.13s : %s",loc_legend[42],d_user.arr);
    user_len=strlen(d_user.arr);
	s1 = (REP_WIDTH)/2;
	horz_skip(s1-user_len-6);
   	s2 = (REP_WIDTH-s1);
	horz_skip(s2-32);
	fprintf(fp,"%9.9s : %10s",loc_legend[2],d_curr_date.arr);
	next_line(1);

    //LINE 3

	fprintf(fp,"%-13.13s : %s",loc_legend[68],d_curr_pgm_name.arr);//loc_legend[64]
    pgm_len=strlen(d_curr_pgm_name.arr);
	if ((nd_rep_type.arr[0] == 'D') && (nd_rep_preview_ind.arr[0] == 'R'))
		strcpy(v_rep_title,loc_legend[1]);
	else if ((nd_rep_type.arr[0] == 'S') && (nd_rep_preview_ind.arr[0] == 'R'))
		strcpy(v_rep_title,loc_legend[5]);
	else if ((nd_rep_type.arr[0] == 'O') && (nd_rep_preview_ind.arr[0] == 'R'))
		strcpy(v_rep_title,loc_legend[32]);
	else 
		strcpy(v_rep_title,loc_legend[33]);
	
	rep_title_len = strlen(v_rep_title);
	
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-6-pgm_len);

	if ((nd_rep_type.arr[0] == 'D') && (nd_rep_preview_ind.arr[0] == 'R'))
		fprintf(fp,"%s",loc_legend[1]);
	else if ((nd_rep_type.arr[0] == 'S') && (nd_rep_preview_ind.arr[0] == 'R'))
		fprintf(fp,"%s",loc_legend[5]);
	else if ((nd_rep_type.arr[0] == 'O') && (nd_rep_preview_ind.arr[0] == 'R'))
		fprintf(fp,"%s",loc_legend[32]);
	else
		fprintf(fp,"%s",loc_legend[33]);

    s2 = (REP_WIDTH-s1-rep_title_len);
    horz_skip(s2-34);
	fprintf(fp,"%11.11s : %10d",loc_legend[4],++page_no);
	next_line(1);

	print_line('-',REP_WIDTH); 
	fprintf(fp,"%s","--");
	next_line(1);
	lctr = 5;

}

print_param()
{
  

	if(d_sysdate.arr[0] != 0)
	{
       
		get_initialize();

		strcpy(nd_temp_date.arr,d_sysdate.arr);

		get_local_date_convn2();

		strcpy(d_sysdate.arr,nd_loc_date.arr);
		d_sysdate.arr[d_sysdate.len] = '\0';
	}

  print_page_title();

  fprintf(fp,"VER 4.1\n");
 
  fprintf(fp,"\n\n\n");
  fprintf(fp,"%-9s%s :\n"," ",loc_legend[47]);
  fprintf(fp,"        ---------------------\n\n");


 
  if (nd_fm_doc_ref_date.arr[0]!= 0 )
  {
	 
	  get_initialize();
	  strcpy(nd_temp_date1.arr,nd_fm_doc_ref_date.arr);
	  get_local_date_convn1();
	  strcpy(nd_fm_doc_ref_date.arr,nd_loc_date1.arr);
	  //nd_fm_doc_ref_date1.arr[nd_fm_doc_ref_date1.len] = '\0';
	  		 
	  
      
   }

 
 if (nd_to_doc_ref_date.arr[0]!= 0 )
 {
    
  get_initialize();
  strcpy(nd_temp_date1.arr,nd_to_doc_ref_date.arr);
  get_local_date_convn1();
  strcpy(nd_to_doc_ref_date.arr,nd_loc_date1.arr);
  //nd_to_doc_ref_date.arr[nd_to_doc_ref_date.len] = '\0';
}


if (pv_cut_off_date.arr[0]!= 0 )
{
 
  get_initialize();
  strcpy(nd_temp_date1.arr,pv_cut_off_date.arr);
  get_local_date_convn1();
  strcpy(pv_cut_off_date.arr,nd_loc_date1.arr);
  //pv_cut_off_date1.arr[pv_cut_off_date1.len] = '\0';

}

if (nd_rep_preview_ind.arr[0] == 'P')
{
	
	fprintf(fp,"%50.50s %10.10s : %s\n\n",loc_legend[14],loc_legend[3],pv_cut_off_date.arr);/*pending*/

	if (strcmp(pv_module_id.arr,"**") == 0)
	fprintf(fp,"%61.61s : %s\n\n",loc_legend[27],loc_legend[48]);
	else
	fprintf(fp,"%61.61s : %s\n\n",loc_legend[27],pv_module_id.arr);

	fprintf(fp,"%61.61s : %s\n\n",loc_legend[9],pv_blng_grp_id.arr);

	if (pv_break_by.arr[0] == 'Y')
    fprintf(fp,"%61.61s : %s\n\n",loc_legend[34],loc_legend[49]);
	else
    fprintf(fp,"%61.61s : %s\n\n",loc_legend[34],loc_legend[50]);
	
	fprintf(fp,"%50.50s %10.10s : %s\n",loc_legend[10],loc_legend[6],pv_fm_cust_code.arr);
	fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],pv_to_cust_code.arr);

	fprintf(fp,"%50.50s %10.10s : %s\n",loc_legend[12],loc_legend[6],pv_fm_patient_id.arr);
	fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],pv_to_patient_id.arr);

	fprintf(fp,"%50.50s %10.10s : %s\n\n",loc_legend[11],loc_legend[20],pv_group_code.arr);

	if (pv_episode_type.arr[0] == 'O')
    fprintf(fp,"%61.61s : %s\n\n",loc_legend[28],loc_legend[51]);
	
	if (pv_episode_type.arr[0] == 'E')
    fprintf(fp,"%61.61s : %s\n\n",loc_legend[28],loc_legend[52]);
	
	if (pv_episode_type.arr[0] == 'R')
    fprintf(fp,"%61.61s : %s\n\n",loc_legend[28],loc_legend[53]);
	
	if (pv_episode_type.arr[0] == 'I')
    fprintf(fp,"%61.61s : %s\n\n",loc_legend[28],loc_legend[54]);
	
	if (pv_episode_type.arr[0] == 'D')
    fprintf(fp,"%61.61s : %s\n\n",loc_legend[28],loc_legend[55]);
	
	if (pv_episode_type.arr[0] == 'A')
    fprintf(fp,"%61.61s : %s\n\n",loc_legend[28],loc_legend[56]);
	
	fprintf(fp,"%61.61s : %s\n\n",loc_legend[29],pv_episode_id.arr);

	fprintf(fp,"%61.61s : %s\n\n",loc_legend[30],pv_visit_id.arr);

	if (pv_body_hdr_yn.arr[0] == 'Y')
	fprintf(fp,"%61.61s : %s\n",loc_legend[35],loc_legend[49]);
	else
	fprintf(fp,"%61.61s : %s\n",loc_legend[35],loc_legend[50]);
	
	if (pv_body_foot_yn.arr[0] == 'Y')
    fprintf(fp,"%61.61s : %s\n",loc_legend[36],loc_legend[49]);
	else
    fprintf(fp,"%61.61s : %s\n",loc_legend[35],loc_legend[50]);
	
	if (pv_print_text_yn.arr[0] == 'Y')
    fprintf(fp,"%61.61s : %s\n",loc_legend[37],loc_legend[49]);
	else
	fprintf(fp,"%61.61s : %s\n",loc_legend[37],loc_legend[50]);
	
	if (pv_foreign_curr_yn.arr[0] == 'Y')
    fprintf(fp,"%61.61s : %s\n",loc_legend[38],loc_legend[49]);
	else
    fprintf(fp,"%61.61s : %s\n",loc_legend[38],loc_legend[50]);
	
	if (pv_foot_note_yn.arr[0] == 'Y')
    fprintf(fp,"%61.61s : %s\n",loc_legend[39],loc_legend[49]);
	else
	fprintf(fp,"%61.61s : %s\n",loc_legend[39],loc_legend[50]);
	
	if (pv_sign_yn.arr[0] == 'Y')
    fprintf(fp,"%61.61s : %s\n",loc_legend[40],loc_legend[49]);
	else
	fprintf(fp,"%61.61s : %s\n",loc_legend[40],loc_legend[50]);
	

}
else
{
  
  if(nd_rep_type.arr[0] == 'S')
  fprintf(fp,"%61.61s : %-s \n\n",loc_legend[31],loc_legend[57]);
  
  else if (nd_rep_type.arr[0] == 'D')
  fprintf(fp,"%61.61s : %-s\n\n",loc_legend[31],loc_legend[58]);
  else
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[31],loc_legend[59]);
  /////////

if(nd_fm_doc_ref_date.arr[0] !='\0')
  fprintf(fp,"%50.50s %10.10s : %s\n",loc_legend[3],loc_legend[6],nd_fm_doc_ref_date.arr);
  else
  fprintf(fp,"%50.50s %10.10s : %s\n",loc_legend[3],loc_legend[6],loc_legend[71]);
/////

if(nd_to_doc_ref_date.arr[0] !='\0')

  fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],nd_to_doc_ref_date.arr);
  else
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],loc_legend[72]);	
  ///
if(nd_fm_doc_ref_num.arr[0] !='\0')
  fprintf(fp,"%50.50s %10.10s : %s\n",loc_legend[8],loc_legend[6],nd_fm_doc_ref_num.arr);
  else
  fprintf(fp,"%50.50s %10.10s : %s\n",loc_legend[8],loc_legend[6],loc_legend[71]);
  /////
	if(nd_to_doc_ref_num.arr[0] !='\0')
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],nd_to_doc_ref_num.arr);
  else
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],loc_legend[72]);
  /////////
		if(nd_fm_blng_grp_id.arr[0] !='\0')
  fprintf(fp,"%50.50s %10.10s : %s\n",loc_legend[9],loc_legend[6],nd_fm_blng_grp_id.arr);
  else
  fprintf(fp,"%50.50s %10.10s : %s\n",loc_legend[9],loc_legend[6],loc_legend[71]);	
  /////////
			if(nd_to_blng_grp_id.arr[0] !='\0')
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],nd_to_blng_grp_id.arr);
  else
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],loc_legend[72]); 	

  ///////////
	if(nd_fm_cust_code.arr[0] !='\0')
  fprintf(fp,"%50.50s %10.10s : %s\n",loc_legend[10],loc_legend[6],nd_fm_cust_code.arr);
  else
  fprintf(fp,"%50.50s %10.10s : %s\n",loc_legend[10],loc_legend[6],loc_legend[71]);

  /////////////
		if(nd_to_cust_code.arr[0] !='\0')
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],nd_to_cust_code.arr);
  else
	fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],loc_legend[72]);

  //////////
	if(nd_fm_patient_id.arr[0] !='\0')
  fprintf(fp,"%50.50s %10.10s : %s\n",loc_legend[12],loc_legend[6],nd_fm_patient_id.arr);
  else
  fprintf(fp,"%50.50s %10.10s : %s\n",loc_legend[12],loc_legend[6],loc_legend[71]);	

  /////////////
		if(nd_to_patient_id.arr[0] !='\0')
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],nd_to_patient_id.arr);
  else
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],loc_legend[72]);
  
  ////////////////////	
if(nd_fm_group_code.arr[0] !='\0')
  fprintf(fp,"%41.41s %8.8s   %8.8s : %s\n",loc_legend[11],loc_legend[20],loc_legend[6],nd_fm_group_code.arr);
  else
  fprintf(fp,"%41.41s %8.8s   %8.8s : %s\n",loc_legend[11],loc_legend[20],loc_legend[6],loc_legend[71]);	

  ///////////////
if(nd_to_group_code.arr[0] !='\0')
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],nd_to_group_code.arr);
  else
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[7],loc_legend[72]);

  if (strcmp(nd_module_id.arr,"**") == 0)
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[27],loc_legend[48]);
  else
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[27],nd_module_id.arr);

  if (nd_episode_type == 'O')
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[28],loc_legend[51]);
  if (nd_episode_type == 'E')
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[28],loc_legend[52]);
  
  if (nd_episode_type == 'R')
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[28],loc_legend[53]);
 

  if (nd_episode_type == 'I')
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[28],loc_legend[54]);
  
  if (nd_episode_type == 'D')
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[28],loc_legend[55]);
 
  if (nd_episode_type == 'A')
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[28],loc_legend[56]);
  
  fprintf(fp,"%61.61s : %s\n\n",loc_legend[29],nd_episode_id.arr);

  fprintf(fp,"%61.61s : %s\n\n",loc_legend[30],nd_visit_id.arr);
}
  
  next_page();
}

check_line(skip) /* will check for MAX LINE before printing totals */
int skip;
{
	if ((lctr + skip) >= MAX_LINES)
	{
		next_page(); 
	}
}

next_line(skip) /* will check for MAX LINE before printing totals */		
int skip;
{
	if ((lctr + skip) >= MAX_LINES)
	{
		next_page(); 
	}
	else
	{
		fprintf(fp,"\n"); ++lctr; 
	}
}

next_page() /* will move the cursor to next page */
{
	fprintf(fp,"\f");
	lctr=0;
	next_line(1);
	 
	print_page_title();
	if(d_sysdate.arr[0] != 0)

	print_column_title();  	
}

print_line(ch,n) /* this is to obtain required characters */
  char ch;
  int n;
{
	int i;
	for(i=0;i<n;i++)
	fprintf(fp,"%c",ch);  
}

horz_skip(num) /* this is to obtain required blank space */
int num;
{
	int i;
	for(i=0;i<num;i++)fprintf(fp," ");
}

print_end()
{
  fprintf(fp,"\n%85s\n",loc_legend[44]);
  fflush(fp);
  fclose(fp);
}


print_formated(loc_amount)
double loc_amount;
{
	char s_amt[15], str_amt[15];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%14sCR",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%14s  ",str_amt);
    }
}  

fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRCVREG.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))) 
				   INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRCVREG.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1264;
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
			blcommon.get_local_lang_desc(:nd_facility,
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
  sqlstm.arrsiz = 21;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1287;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
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

get_initialize()
{
nd_temp_date.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';
nd_loc_date1.arr[0]  = '\0';
date_convert.arr[0]  = '\0';
nd_temp_date1.arr[0] = '\0';

nd_loc_date1.len = 0;
nd_temp_date.len = 0;
nd_temp_date1.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;


}
get_local_date_convn1()
{

nd_temp_date1.len = strlen(nd_temp_date1.arr);
get_local_date();

}

get_local_date_convn2()
{

nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date2();

}
get_local_date()
{


	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	    
		 
		 get_locale_date.convert_to_locale_date(to_date(:nd_temp_date1,'dd/mm/yy'),:p_language_id,t_date);
													    

	    :nd_loc_date1:= to_char(t_date,'DD-MON-YYYY');
        

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 21;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date1 , 'dd/mm/yy' ) , :p_language_id , t_date )\
 ; :nd_loc_date1 := to_char ( t_date , 'DD-MON-YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1318;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date1;
 sqlstm.sqhstl[0] = (unsigned int  )14;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date1;
 sqlstm.sqhstl[2] = (unsigned int  )14;
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
get_local_date2()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	
		
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'dd/mm/yyyy'),:p_language_id,t_date);

		:nd_loc_date := to_char(t_date,'dd/mm/yyyy');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 21;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'dd/mm/yyyy' ) , :p_language_id , t_date \
) ; :nd_loc_date := to_char ( t_date , 'dd/mm/yyyy' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1345;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )14;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date;
 sqlstm.sqhstl[2] = (unsigned int  )14;
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


/*get_language_id()
{
	language_id.arr[0] = '\0';
	language_id.len = 0;
	

	EXEC SQL SELECT LANGUAGE_ID INTO :language_id FROM SM_APPL_USER where APPL_USER_ID = :d_user;

	if (OERROR)
        err_mesg("SELECTING LANGUAGE_ID failed",0,"");

}*/

