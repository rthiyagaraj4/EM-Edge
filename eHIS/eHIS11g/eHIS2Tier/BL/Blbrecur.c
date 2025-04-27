
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blbrecur.pc"
};


static unsigned int sqlctx = 1288463899;


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
            void  *sqhstv[27];
   unsigned int   sqhstl[27];
            int   sqhsts[27];
            void  *sqindv[27];
            int   sqinds[27];
   unsigned int   sqharm[27];
   unsigned int   *sqharc[27];
   unsigned short  sqadto[27];
   unsigned short  sqtdso[27];
} sqlstm = {12,27};

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

 static const char *sq0010 = 
"select distinct EPISODE_TYPE ,EPISODE_ID  from BL_RECURRING_HDR where (NVL(R\
ECUR_TRN_STATUS,'X')<>'Z' and OPERATING_FACILITY_ID=:b0) order by EPISODE_TYPE\
,EPISODE_ID            ";

 static const char *sq0011 = 
"select RECUR_TRN_REF ,TO_CHAR(RECUR_TRN_DATE,'DD/MM/YYYY') ,PATIENT_ID  from\
 BL_RECURRING_HDR where ((((EPISODE_TYPE=:b0 and EPISODE_ID=:b1) and NVL(LAST_\
GEN_DATE,RECUR_TRN_DATE)<TO_date(:b2,'DD/MM/YYYY')) and ((TRUNC(LAST_GEN_DATE)\
<TRUNC(TO_DATE(:b3,'DD/MM/YYYY HH24:MI:SS')) and LAST_GEN_DATE is  not null ) \
or (LAST_GEN_DATE is null  and TRUNC(RECUR_TRN_DATE)<=TRUNC(TO_DATE(:b3,'DD/MM\
/YYYY HH24:MI:SS'))))) and OPERATING_FACILITY_ID=:b5) order by RECUR_TRN_REF  \
for update of RECUR_TRN_REF ";

 static const char *sq0012 = 
"select BLNG_SERV_CODE ,PANEL_CODE ,NVL(SERV_QTY,1) ,NVL(CHARGE_AMT,0) ,NVL(S\
ERVICE_PANEL_IND,'N')  from BL_RECURRING_LINE where ((RECUR_TRN_REF=:b0 and TR\
UNC(TO_DATE(:b1,'DD/MM/YYYY HH24:MI:SS')) between trunc(START_DATE) and END_DA\
TE) and OPERATING_FACILITY_ID=:b2) order by BLNG_SERV_CODE            ";

 static const char *sq0013 = 
"select 'X'  from IP_OPEN_EPISODE where (OPEN_EPISODE_ID=:b0 and FACILITY_ID=\
:b1)           ";

 static const char *sq0015 = 
"select B.BLNG_CLASS_CODE ,A.TO_PHYSICIAN_ID ,A.TO_BED_CLASS_CODE ,C.BILL_TYP\
E_CODE ,A.ORIG_DEPT_CODE ,A.TRN_SRL_NUM ,A.TO_BED_TYPE_CODE  from BL_IP_ADT_TR\
N_VW A ,BL_IP_BED_TYPE B ,BL_IP_NURSING_UNIT C where (((((A.TRN_SRL_NUM=(selec\
t max(TRN_SRL_NUM)  from BL_IP_ADT_TRN_VW where ((((NVL(ADT_TRN_STATUS,'0')<>'\
9' and NVL(TRN_CODE,'X')<>'D') and EPISODE_ID=:b0) and FACILITY_ID=:b1) and tr\
n_date_time<=TO_DATE(:b2,'DD/MM/YYYY HH24:MI:SS'))) and B.BED_TYPE_CODE=A.TO_B\
ED_TYPE_CODE) and C.NURSING_UNIT_CODE=A.TO_WARD_CODE) and C.FACILITY_ID=:b1) a\
nd A.FACILITY_ID=C.FACILITY_ID) and A.EPISODE_ID=:b0)           ";

 static const char *sq0016 = 
"select NVL(PRT_GRP_HDR_CODE,:b0) ,NVL(PRT_GRP_LINE_CODE,:b1) ,NVL(SOURCE_MOD\
ULE_DEPT_FLAG,'N') ,DEPT_CODE ,RATE_ENTRY_BY_USER_FLAG ,DEF_CHARGE ,MIN_CHARGE\
_AMT ,SERV_LOCN_CODE ,UOM_CODE  from BL_BLNG_SERV where BLNG_SERV_CODE=:b2    \
       ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,352,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,29,420,0,0,0,0,0,1,0,
51,0,0,3,22,0,1,438,0,0,0,0,0,1,0,
66,0,0,4,0,0,29,461,0,0,0,0,0,1,0,
81,0,0,5,121,0,5,466,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
104,0,0,6,0,0,30,476,0,0,0,0,0,1,0,
119,0,0,7,194,0,4,503,0,0,10,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
174,0,0,8,84,0,2,536,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
201,0,0,9,115,0,4,552,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
228,0,0,10,177,0,9,697,0,0,1,1,0,1,0,1,9,0,0,
247,0,0,11,494,0,9,704,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
286,0,0,12,302,0,9,715,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
313,0,0,10,0,0,13,728,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
336,0,0,11,0,0,13,754,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
363,0,0,18,78,0,6,769,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
386,0,0,12,0,0,13,799,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,
421,0,0,13,91,0,9,819,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
444,0,0,13,0,0,13,827,0,0,1,0,0,1,0,2,9,0,0,
463,0,0,15,608,0,9,971,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
498,0,0,15,0,0,13,993,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
541,0,0,19,117,0,6,1045,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
564,0,0,16,239,0,9,1062,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
591,0,0,16,0,0,13,1089,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,
634,0,0,20,251,0,5,1349,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
673,0,0,21,0,0,29,1362,0,0,0,0,0,1,0,
688,0,0,22,30,0,43,1382,0,0,0,0,0,1,0,
703,0,0,23,254,0,6,1720,0,0,5,5,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
738,0,0,24,771,0,6,1746,0,0,27,27,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,
0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,
0,0,2,9,0,0,1,9,0,0,1,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,2,9,0,0,
861,0,0,25,792,0,6,1803,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,
0,1,3,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,3,9,0,0,2,9,0,0,2,9,0,0,
956,0,0,26,399,0,6,1889,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,3,9,0,0,2,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLBRECUR.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 27-AUG-1993                                  */   
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*                                                                      */
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/* UPGRADED TO 4.1                                                      */
/************************************************************************/

#include <stdio.h>
#include <string.h>
#include <gl.h>
#include <bl.h>

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])
/*
#define DEBUG 0
*/
#define VIEW_LOG_FILE    1

extern double l_floor(),l_ceil();


/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            date_time                                  [20],
            user_id                                    [40],
			nd_user				                       [31],
            nd_session_id                              [26],
            nd_pgm_date                                [25],
            d_curr_pgm_name                            [15],

			nd_ws_no			 					   [31],
			nd_facility_id  						   [3],

            nd_process_date                            [16],
            nd_service_time                            [21],
            nd_day_type                                [3],
            nd_time_type                               [3],
			nd_panel_code			                   [11],
            nd_sysdate                                 [21],
	        nd_pwd 				                       [95],  
	        dummy                                      [2],
	        m_service_panel_ind                        [2]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[40]; } user_id;

struct { unsigned short len; unsigned char arr[31]; } nd_user;

struct { unsigned short len; unsigned char arr[26]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[31]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[16]; } nd_process_date;

struct { unsigned short len; unsigned char arr[21]; } nd_service_time;

struct { unsigned short len; unsigned char arr[3]; } nd_day_type;

struct { unsigned short len; unsigned char arr[3]; } nd_time_type;

struct { unsigned short len; unsigned char arr[11]; } nd_panel_code;

struct { unsigned short len; unsigned char arr[21]; } nd_sysdate;

struct { unsigned short len; unsigned char arr[95]; } nd_pwd;

struct { unsigned short len; unsigned char arr[2]; } dummy;

struct { unsigned short len; unsigned char arr[2]; } m_service_panel_ind;
         /* Added on 31-JAN-2007 */


	   /* VARCHAR  m_str							[21],
				m_charge_based_yn				[2],	
				m_excl_incl_action_ind			[2],
				m_action_reason_code			[5],
				m_language_id					[3],
				m_error_level					[10],
				m_sys_message_id				[21],
				m_charged_yn					[2],		
				m_pat_billed_yn                 [2]; */ 
struct { unsigned short len; unsigned char arr[21]; } m_str;

struct { unsigned short len; unsigned char arr[2]; } m_charge_based_yn;

struct { unsigned short len; unsigned char arr[2]; } m_excl_incl_action_ind;

struct { unsigned short len; unsigned char arr[5]; } m_action_reason_code;

struct { unsigned short len; unsigned char arr[3]; } m_language_id;

struct { unsigned short len; unsigned char arr[10]; } m_error_level;

struct { unsigned short len; unsigned char arr[21]; } m_sys_message_id;

struct { unsigned short len; unsigned char arr[2]; } m_charged_yn;

struct { unsigned short len; unsigned char arr[2]; } m_pat_billed_yn;



   /* VARCHAR  nd_error_id				       [10],
	    nd_error_code		               [11],
	    nd_error_text		               [100]; */ 
struct { unsigned short len; unsigned char arr[10]; } nd_error_id;

struct { unsigned short len; unsigned char arr[11]; } nd_error_code;

struct { unsigned short len; unsigned char arr[100]; } nd_error_text;


   /* VARCHAR bl_param_prt_grp_hdr_code                   [6],
           bl_param_prt_grp_line_code                  [4]; */ 
struct { unsigned short len; unsigned char arr[6]; } bl_param_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[4]; } bl_param_prt_grp_line_code;


   /* VARCHAR bl_hdr_recur_trn_ref                        [21],
           bl_hdr_recur_trn_date                       [13],
           bl_hdr_episode_type                         [2],
           bl_hdr_episode_id                           [9],
           bl_hdr_patient_id                           [21],
	       bl_reln_code								   [30]; */ 
struct { unsigned short len; unsigned char arr[21]; } bl_hdr_recur_trn_ref;

struct { unsigned short len; unsigned char arr[13]; } bl_hdr_recur_trn_date;

struct { unsigned short len; unsigned char arr[2]; } bl_hdr_episode_type;

struct { unsigned short len; unsigned char arr[9]; } bl_hdr_episode_id;

struct { unsigned short len; unsigned char arr[21]; } bl_hdr_patient_id;

struct { unsigned short len; unsigned char arr[30]; } bl_reln_code;



   /* VARCHAR bl_line_blng_serv_code                      [11],
	       nd_bl_serv_code			                   [11]; */ 
struct { unsigned short len; unsigned char arr[11]; } bl_line_blng_serv_code;

struct { unsigned short len; unsigned char arr[11]; } nd_bl_serv_code;


   /* VARCHAR blng_serv_code_old                          [11],
           blng_serv_code_spl                          [11]; */ 
struct { unsigned short len; unsigned char arr[11]; } blng_serv_code_old;

struct { unsigned short len; unsigned char arr[11]; } blng_serv_code_spl;


   double  bl_line_charge_amt;

   char    p_levy_appl_yn;

  /* VARCHAR  p_char1[100],
	   p_char2[100]; */ 
struct { unsigned short len; unsigned char arr[100]; } p_char1;

struct { unsigned short len; unsigned char arr[100]; } p_char2;

	   
  double   p_levy_amt,	
	   p_num2;


   double  bl_line_serv_qty;

   /* VARCHAR bl_adt_blng_class_code                      [3],
           bl_adt_to_physician_id                      [16],
           bl_adt_to_bed_class_code                    [3],
           bl_adt_bill_type_code                       [3],
           bl_adt_orig_dept_code                       [11],
           bl_adt_trn_srl_num                          [5],
	   bl_bed_type_code			       [5],
	   bl_blng_class_code			       [3],
           bl_epi_status                               [2],
           bl_epi_disch_bill                           [2],
           bl_epi_disch_yn                             [2],
           bl_epi_blng_grp_id                          [3]; */ 
struct { unsigned short len; unsigned char arr[3]; } bl_adt_blng_class_code;

struct { unsigned short len; unsigned char arr[16]; } bl_adt_to_physician_id;

struct { unsigned short len; unsigned char arr[3]; } bl_adt_to_bed_class_code;

struct { unsigned short len; unsigned char arr[3]; } bl_adt_bill_type_code;

struct { unsigned short len; unsigned char arr[11]; } bl_adt_orig_dept_code;

struct { unsigned short len; unsigned char arr[5]; } bl_adt_trn_srl_num;

struct { unsigned short len; unsigned char arr[5]; } bl_bed_type_code;

struct { unsigned short len; unsigned char arr[3]; } bl_blng_class_code;

struct { unsigned short len; unsigned char arr[2]; } bl_epi_status;

struct { unsigned short len; unsigned char arr[2]; } bl_epi_disch_bill;

struct { unsigned short len; unsigned char arr[2]; } bl_epi_disch_yn;

struct { unsigned short len; unsigned char arr[3]; } bl_epi_blng_grp_id;


   /* VARCHAR bl_srv_prt_grp_hdr_code                     [3],
           bl_srv_prt_grp_line_code                    [3],
           bl_srv_source_module_dpt_flg                [2],
           bl_srv_dept_code                            [11],
           bl_srv_rate_entry_by_usr_flg                [2],
           bl_srv_serv_locn_code                       [5]; */ 
struct { unsigned short len; unsigned char arr[3]; } bl_srv_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } bl_srv_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[2]; } bl_srv_source_module_dpt_flg;

struct { unsigned short len; unsigned char arr[11]; } bl_srv_dept_code;

struct { unsigned short len; unsigned char arr[2]; } bl_srv_rate_entry_by_usr_flg;

struct { unsigned short len; unsigned char arr[5]; } bl_srv_serv_locn_code;


   double  bl_srv_def_charge,
           bl_srv_min_charge_amt;

   double  bl_srv_ip_rate,
           bl_srv_base_qty;

   double  bl_rule_addl_factor_num;

   /* VARCHAR bl_blng_settlement_ind                      [2]; */ 
struct { unsigned short len; unsigned char arr[2]; } bl_blng_settlement_ind;


   double  bl_blng_ip_disc_perc;

   long    bl_pat_run_line_num = 0;

   /* VARCHAR store_patient_id                            [21],
           store_episode_type                          [2],
           store_episode_id                            [9]; */ 
struct { unsigned short len; unsigned char arr[21]; } store_patient_id;

struct { unsigned short len; unsigned char arr[2]; } store_episode_type;

struct { unsigned short len; unsigned char arr[9]; } store_episode_id;


  double   nd_base_charge,
           nd_gross_charge,
	   net_charge_amt,
	   gross_charge_amt,
	   disc_amt,
	   base_charge_amt,
           nd_disc_amt,
           nd_net_amt,

           epi_tot_gross_charge,
           epi_tot_disc_amt,
           epi_tot_net_amt;

double	   m_pat_base_qty,
	   m_pat_min_charge_amt,
	   m_base_rate,
	   m_pat_serv_price,
	   m_cust_base_charge_amt,
	   m_base_charge_amt,
	   m_pat_serv_disc;

double	   bedcls_dly_charge,
	   m_addl_factor_num,	   
	   m_pat_min_charge_amt,
	   epfndt_bed_bill_rate,
	   copay_perc,
	   m_pat_serv_disc,
	   m_pat_base_charge_amt,
	   m_disc_perc;


/* VARCHAR	   epfndt_blng_grp_id            [3],
	   epfndt_slmt_type_code         [3],
	   epfndt_bill_doc_type_code     [7],
	   epfndt_bill_doc_number        [9],
	   epfndt_bill_doc_date          [13],
	   epfndt_trx_doc_ref            [21],
	   patfolio_trx_doc_ref          [21]; */ 
struct { unsigned short len; unsigned char arr[3]; } epfndt_blng_grp_id;

struct { unsigned short len; unsigned char arr[3]; } epfndt_slmt_type_code;

struct { unsigned short len; unsigned char arr[7]; } epfndt_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } epfndt_bill_doc_number;

struct { unsigned short len; unsigned char arr[13]; } epfndt_bill_doc_date;

struct { unsigned short len; unsigned char arr[21]; } epfndt_trx_doc_ref;

struct { unsigned short len; unsigned char arr[21]; } patfolio_trx_doc_ref;


/* VARCHAR    mpi_date[30],
	   m_pat_cust_code[10],
	   m_pat_ins_cust_code[10]; */ 
struct { unsigned short len; unsigned char arr[30]; } mpi_date;

struct { unsigned short len; unsigned char arr[10]; } m_pat_cust_code;

struct { unsigned short len; unsigned char arr[10]; } m_pat_ins_cust_code;


/* VARCHAR	  epfndt_cust_code			[9],
	  epfndt_pkg_bill_doc_type		[7],
	  epfndt_policy_type_code		[21],
	  epfndt_policy_exp_date		[11],
	  epfndt_credit_auth_ref		[20],
	  epfndt_credit_auth_date		[11],
	  epfndt_effective_date			[11],
	  epfndt_emp_code			[9],
	  epfndt_non_ins_blng_grp_id		[3],
	  epfndt_non_ins_cust_code		[9],
	  epfndt_employer_code			[9],	  
	  m_copay_yn				[2],
	  pkg_qv_ind				[3],
	  pkg_addl_qty_flag			[3],
	  pkg_apply_to				[3],
	  pkg_serv_code				[11],
	  pkg_exp_date_ymd			[9],
	  pkg_closed_yn				[3],
	  pkg_bill_date				[11],
	  pkg_flag				[3],
	  cust_yn				[3],
	  pc_yn					[3],
	  std_yn				[3], 
	  m_pc_code				[9],
	  m_excl_incl_ind			[2],
	  m_copay_ind				[2],
	  m_prepay_yn				[2],
	  m_preapp_status			[2],
	  ins_flag				[2],
	  m_rate_flag				[2],
	  m_apply_disc_yn			[2],
	  m_df_flag				[2],
	  m_misc_flag				[2],
	  m_app_rate_ind			[2],
	  ins_pkg_pat_ind			[2],
	  epfndt_policy_number			[31],
	  m_preapp_yn				[2],
	  m_uom_code                [5]; */ 
struct { unsigned short len; unsigned char arr[9]; } epfndt_cust_code;

struct { unsigned short len; unsigned char arr[7]; } epfndt_pkg_bill_doc_type;

struct { unsigned short len; unsigned char arr[21]; } epfndt_policy_type_code;

struct { unsigned short len; unsigned char arr[11]; } epfndt_policy_exp_date;

struct { unsigned short len; unsigned char arr[20]; } epfndt_credit_auth_ref;

struct { unsigned short len; unsigned char arr[11]; } epfndt_credit_auth_date;

struct { unsigned short len; unsigned char arr[11]; } epfndt_effective_date;

struct { unsigned short len; unsigned char arr[9]; } epfndt_emp_code;

struct { unsigned short len; unsigned char arr[3]; } epfndt_non_ins_blng_grp_id;

struct { unsigned short len; unsigned char arr[9]; } epfndt_non_ins_cust_code;

struct { unsigned short len; unsigned char arr[9]; } epfndt_employer_code;

struct { unsigned short len; unsigned char arr[2]; } m_copay_yn;

struct { unsigned short len; unsigned char arr[3]; } pkg_qv_ind;

struct { unsigned short len; unsigned char arr[3]; } pkg_addl_qty_flag;

struct { unsigned short len; unsigned char arr[3]; } pkg_apply_to;

struct { unsigned short len; unsigned char arr[11]; } pkg_serv_code;

struct { unsigned short len; unsigned char arr[9]; } pkg_exp_date_ymd;

struct { unsigned short len; unsigned char arr[3]; } pkg_closed_yn;

struct { unsigned short len; unsigned char arr[11]; } pkg_bill_date;

struct { unsigned short len; unsigned char arr[3]; } pkg_flag;

struct { unsigned short len; unsigned char arr[3]; } cust_yn;

struct { unsigned short len; unsigned char arr[3]; } pc_yn;

struct { unsigned short len; unsigned char arr[3]; } std_yn;

struct { unsigned short len; unsigned char arr[9]; } m_pc_code;

struct { unsigned short len; unsigned char arr[2]; } m_excl_incl_ind;

struct { unsigned short len; unsigned char arr[2]; } m_copay_ind;

struct { unsigned short len; unsigned char arr[2]; } m_prepay_yn;

struct { unsigned short len; unsigned char arr[2]; } m_preapp_status;

struct { unsigned short len; unsigned char arr[2]; } ins_flag;

struct { unsigned short len; unsigned char arr[2]; } m_rate_flag;

struct { unsigned short len; unsigned char arr[2]; } m_apply_disc_yn;

struct { unsigned short len; unsigned char arr[2]; } m_df_flag;

struct { unsigned short len; unsigned char arr[2]; } m_misc_flag;

struct { unsigned short len; unsigned char arr[2]; } m_app_rate_ind;

struct { unsigned short len; unsigned char arr[2]; } ins_pkg_pat_ind;

struct { unsigned short len; unsigned char arr[31]; } epfndt_policy_number;

struct { unsigned short len; unsigned char arr[2]; } m_preapp_yn;

struct { unsigned short len; unsigned char arr[5]; } m_uom_code;


double	  m_pat_base_amt			[16],
	  m_pat_gross_amt			[16],
	  m_pat_dis_amt				[16],
	  m_pat_net_amt 			[16],
	  m_cust_base_amt			[16],
	  m_cust_gross_amt			[16],
	  m_cust_dis_amt			[16],
	  m_cust_net_amt 			[16];
	  

double	  epfndt_app_amt,
	  epfndt_ill_ded_amt,
	  epfndt_vst_ded_amt,
	  pkg_serv_price,
	  pkg_serv_disc,
	  pkg_qv_val,
	  pkg_qv_availed,
	  pkg_addl_qty,
	  pkg_addl_qty_availed,
	  pkg_addl_serv_price,
	  copay_perc,
	  m_copay_val,
	  m_availed_amt,
	  m_approved_amt,
	  m_ca_diff,
	  m_curr_availed,
	  m_def_charge,
	  m_ip_rate,
	  m_min_charge_amt,
	  m_base_qty,
	  m_serv_price,
	  m_ip_disc,
	  m_serv_disc,
	  m_serv_qty,
	  m_diff_qty,
	  m_addl_diff_qty,
	  m_req_pkg_qty,
	  m_req_addl_qty,
	  m_req_std_qty,
	  m_pat_base_qty,
	  m_pat_base_rate,
	  m_pat_serv_qty,
	  m_pat_gross_charge_amt,
	  m_pat_disc_amt,
	  m_pat_net_charge_amt,
	  m_cust_base_qty,
	  m_cust_base_rate,
	  m_cust_serv_qty,
	  m_cust_gross_charge_amt,
	  m_cust_disc_amt,
	  m_cust_net_charge_amt,
	  m_pkg_price,				
	  m_pkg_val,
	  m_pkg_price_availed;

int	  epfndt_app_days,
  	  epfndt_pkg_bill_doc_num,
	  err_flg,
	  m_flag,
	  m_canadj,
	  split,
	  k_flag,
	  m_stat,
	  m_cur_acct_seq_no,  /* Added on 31-JAN-2007 */
	  m_encounter_id,      
	  l_trx_doc_ref_line_num,
	  m_tot_amt,
	  m_pat_payable_amt,
	  m_pat_paid_amt;
/*	  bl_hdr_episode_id;*/

char      m_split_ind,
	  pkg_ind,
	  auto_confirm_yn = 'N',
	  m_app_dic_ind,
	  m_op_cover,
	  m_pkg_ins_pat_ind,
	  m_canadj_alert_ind,
	  nd_package_ind,
	  d_hosp_transfer;

char	  m_serv_status,
	  m_pat_app_rate_ind,
	  m_pat_app_dic_ind;

char	  v_msg[100];
char	  string_var[1000];

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

int hdr_ctr = 0, hdr1_ctr = 0, dtl_ctr = 0, skip_flag = 0;

int err_ctr = 0;

char msg_str[132];

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
 
    strcpy(g_pgm_id,"BLBRECUR");

	strcpy(nd_pwd.arr,argv[1]); 
	nd_pwd.len = strlen(nd_pwd.arr); 

    //disp_message(ORA_MESG,"connecting to Oracle");
	/* EXEC SQL CONNECT :nd_pwd; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )10;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_pwd;
 sqlstm.sqhstl[0] = (unsigned int  )97;
 sqlstm.sqhsts[0] = (         int  )97;
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



	if (OERROR)
	{
        disp_message(ERR_MESG,"Error in connecting to Oracle");
        proc_exit();
    }

    /*if (sql_connect(argv[1]) == -1)
    {
        disp_message(ERR_MESG,"Error in connecting to Oracle");
        proc_exit();
    }*/

     set_meduser_role();

	strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

    strcpy(nd_facility_id.arr,argv[4]);
    nd_facility_id.len = strlen(nd_facility_id.arr);
    strcpy(g_facility_id,nd_facility_id.arr);    

    fetch_prog_param();

    start_prog_msg();
    
    fetch_bl_param();

    declare_cur();

    hdr1_ctr  = 0;
    skip_flag = 0;

    open_hdr1();

	//disp_message(ERR_MESG,"Opened fetch hdr1........");

         
    while (fetch_hdr1())
    {
      
     // disp_message(ERR_MESG,bl_hdr_episode_id.arr);
	  hdr1_ctr++;
     
         if (!fetch_on_episode_change())

	  {  
	     //disp_message(ERR_MESG,"Not fetch_on_episode_change ");
          skip_flag = 1;	  	
	  }

      else
	   {
	   //disp_message(ERR_MESG,"fetch_on_episode_change ");
	     skip_flag = 0;
	   }
       
      if (skip_flag)
      {
          /* EXEC SQL COMMIT WORK; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 12;
          sqlstm.arrsiz = 4;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )36;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)4352;
          sqlstm.occurs = (unsigned int  )0;
          sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


          if (OERROR)
              err_mesg("COMMIT failed - 1",0,"");
          continue;
      }
  
      /*epi_tot_gross_charge = epi_tot_disc_amt = epi_tot_net_amt = 0;*/

      bl_pat_run_line_num = 1;
      hdr_ctr = 0;
      err_ctr = 0;
      open_hdr();

      while(fetch_hdr())
      {	
         hdr_ctr++;
         if (hdr_ctr == 1)
         {
             /* EXEC SQL SAVEPOINT LAST_EPISODE; */ 

{
             struct sqlexd sqlstm;
             sqlstm.sqlvsn = 12;
             sqlstm.arrsiz = 4;
             sqlstm.sqladtp = &sqladt;
             sqlstm.sqltdsp = &sqltds;
             sqlstm.stmt = "savepoint LAST_EPISODE";
             sqlstm.iters = (unsigned int  )1;
             sqlstm.offset = (unsigned int  )51;
             sqlstm.cud = sqlcud0;
             sqlstm.sqlest = (unsigned char  *)&sqlca;
             sqlstm.sqlety = (unsigned short)4352;
             sqlstm.occurs = (unsigned int  )0;
             sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



             if (OERROR)
                  err_mesg("SAVEPOINT LAST_EPISODE failed",0,""); 

            strcpy(store_patient_id.arr,bl_hdr_patient_id.arr);
            store_patient_id.len = strlen(store_patient_id.arr);
            strcpy(store_episode_type.arr,bl_hdr_episode_type.arr);
            store_episode_type.len = strlen(store_episode_type.arr);
            strcpy(store_episode_id.arr,bl_hdr_episode_id.arr);
            store_episode_id.len  = strlen(store_episode_id.arr);
         }
         open_line();
         while (fetch_line())
         {

	          insert_patient_charges_folio();
         }
      }
      if (!skip_flag)
      {
         do_episode_change();
      }
      /* EXEC SQL COMMIT WORK; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 4;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )66;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


      if (OERROR)
          err_mesg("COMMIT failed",0,"");
    }

    /* EXEC SQL UPDATE BL_PARAMETERS 
	     SET LAST_RECUR_CHARGE_DATETIME = TO_DATE(:nd_service_time,'DD/MM/YYYY HH24:MI:SS')
	     WHERE OPERATING_FACILITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_PARAMETERS  set LAST_RECUR_CHARGE_DATETIME=TO_D\
ATE(:b0,'DD/MM/YYYY HH24:MI:SS') where OPERATING_FACILITY_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )81;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_service_time;
    sqlstm.sqhstl[0] = (unsigned int  )23;
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

	     
      if (OERROR)
         err_mesg("UPDATE failed on table BL_PARAMETERS",0,"");

    end_prog_msg();



    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )104;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");

    return;
}

/* Main  closes here */

fetch_prog_param()
{
    nd_process_date.arr[0]        = '\0';
    nd_service_time.arr[0]        = '\0';
    nd_day_type.arr[0]            = '\0';
    nd_time_type.arr[0]           = '\0';
    nd_sysdate.arr[0]             = '\0';
    nd_ws_no.arr[0]		  = '\0';
    nd_user.arr[0]		  = '\0';    

    nd_process_date.len           = 0;
    nd_service_time.len           = 0;
    nd_day_type.len               = 0;
    nd_time_type.len              = 0;
    nd_sysdate.len                = 0;
    nd_ws_no.len		  = 0;       
    nd_user.len			  = 0;

   /* EXEC SQL SELECT PARAM1,
                   PARAM2,
		   PARAM3,
		   PARAM4,
           TO_CHAR(SYSDATE,'MMDDHH24MI'),
		   PARAM7,
		   PARAM8		  
              INTO :nd_process_date,
                   :nd_service_time,
                   :nd_day_type,
                   :nd_time_type,
                   :nd_sysdate,
		   :nd_ws_no,		   
		   :nd_user
           FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,TO_CHAR(SYSDATE,'MM\
DDHH24MI') ,PARAM7 ,PARAM8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from SY_PROG_PARA\
M where ((PGM_ID=:b7 and SESSION_ID=:b8) and PGM_DATE=:b9)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )119;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_process_date;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_service_time;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_day_type;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_time_type;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_sysdate;
   sqlstm.sqhstl[4] = (unsigned int  )23;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_ws_no;
   sqlstm.sqhstl[5] = (unsigned int  )33;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_user;
   sqlstm.sqhstl[6] = (unsigned int  )33;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[7] = (unsigned int  )17;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[8] = (unsigned int  )28;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[9] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_process_date.arr[nd_process_date.len] = '\0';
   nd_service_time.arr[nd_service_time.len] = '\0';
   nd_day_type.arr[nd_day_type.len]         = '\0';
   nd_time_type.arr[nd_time_type.len]       = '\0';
   nd_sysdate.arr[nd_sysdate.len]           = '\0';
   nd_ws_no.arr[nd_ws_no.len]	            = '\0';
   nd_user.arr[nd_user.len]		    = '\0';

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )174;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
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
   sqlstm.sqhstl[1] = (unsigned int  )28;
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
   
}

fetch_bl_param()
{

bl_param_prt_grp_hdr_code.arr[0]        = '\0';
bl_param_prt_grp_line_code.len           = 0;

    /* EXEC SQL SELECT DEF_PRT_GRP_HDR_CODE,
                    DEF_PRT_GRP_LINE_CODE
               INTO :bl_param_prt_grp_hdr_code,
                    :bl_param_prt_grp_line_code
               FROM BL_PARAMETERS
	       WHERE OPERATING_FACILITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select DEF_PRT_GRP_HDR_CODE ,DEF_PRT_GRP_LINE_CODE into :\
b0,:b1  from BL_PARAMETERS where OPERATING_FACILITY_ID=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )201;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_param_prt_grp_hdr_code;
    sqlstm.sqhstl[0] = (unsigned int  )8;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_param_prt_grp_line_code;
    sqlstm.sqhstl[1] = (unsigned int  )6;
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
         err_mesg("SELECT failed on table BL_PARAMETERS",0,"");

    if (NOT_FOUND)
         err_mesg("SELECT failed on table BL_PARAMETERS",1,"BL0020");
bl_param_prt_grp_hdr_code.arr[bl_param_prt_grp_hdr_code.len] = '\0';
bl_param_prt_grp_line_code.arr[bl_param_prt_grp_line_code.len] = '\0';

}

declare_cur()
{


     /* EXEC SQL DECLARE BL_RECUR_HDR_CUR1 CURSOR FOR
               SELECT DISTINCT EPISODE_TYPE,
                      EPISODE_ID
                 FROM BL_RECURRING_HDR
                WHERE NVL(RECUR_TRN_STATUS,'X') != 'Z'
		AND OPERATING_FACILITY_ID = :nd_facility_id
                ORDER BY EPISODE_TYPE,EPISODE_ID; */ 


     /* EXEC SQL DECLARE BL_RECURRING_HDR_CUR CURSOR FOR
               SELECT RECUR_TRN_REF,
                      TO_CHAR(RECUR_TRN_DATE,'DD/MM/YYYY'),
                      PATIENT_ID
                 FROM BL_RECURRING_HDR
                WHERE EPISODE_TYPE = :bl_hdr_episode_type
                  AND EPISODE_ID   = :bl_hdr_episode_id
                  AND NVL(LAST_GEN_DATE,RECUR_TRN_DATE) <    TO_date(:nd_process_date,'DD/MM/YYYY')
		  AND ((TRUNC(LAST_GEN_DATE) <    TRUNC(TO_DATE(:nd_service_time,'DD/MM/YYYY HH24:MI:SS'))
			AND LAST_GEN_DATE IS NOT NULL ) OR 
		(LAST_GEN_DATE IS NULL AND TRUNC(RECUR_TRN_DATE) <= TRUNC(TO_DATE(:nd_service_time,'DD/MM/YYYY HH24:MI:SS'))))
		  AND OPERATING_FACILITY_ID = :nd_facility_id
                ORDER BY RECUR_TRN_REF
                FOR UPDATE OF RECUR_TRN_REF; */ 


     /* EXEC SQL DECLARE BL_RECURRING_LINE_CUR CURSOR FOR
               SELECT BLNG_SERV_CODE,
		      PANEL_CODE,
		      NVL(SERV_QTY,1),
                      NVL(CHARGE_AMT,0),
		      NVL(SERVICE_PANEL_IND,'N')
                 FROM BL_RECURRING_LINE
                WHERE RECUR_TRN_REF = :bl_hdr_recur_trn_ref
                  AND TRUNC(TO_DATE(:nd_service_time,'DD/MM/YYYY HH24:MI:SS')) 
                      BETWEEN trunc(START_DATE) AND END_DATE
		  AND OPERATING_FACILITY_ID = :nd_facility_id
                ORDER BY BLNG_SERV_CODE; */ 


     /* EXEC SQL DECLARE IP_OPEN_EPISODE_CUR CURSOR FOR
               SELECT 'X'
                 FROM IP_OPEN_EPISODE
                WHERE OPEN_EPISODE_ID   = :bl_hdr_episode_id
		AND   FACILITY_ID = :nd_facility_id; */ 

 
     /* EXEC SQL DECLARE BL_EPISODE_FIN_DTLS_CUR CURSOR FOR
               SELECT BLNG_GRP_ID, 
		      EPISODE_STATUS, 
                      NVL(DISCHARGE_BILL_GEN_IND,'N'),
                      NVL(DISCHARGED_YN,'N'),
		      CUST_CODE,	
		      NON_INS_BLNG_GRP_ID,
		      NON_INS_CUST_CODE,
		      PACKAGE_BILL_DOC_TYPE,	
		      PACKAGE_BILL_DOC_NUM,	
		      POLICY_TYPE_CODE,
		      CREDIT_AUTH_REF,
		      EFFECTIVE_DATE,
		      NVL(APPROVED_DAYS,0),
		      CUR_ACCT_SEQ_NO,            /o Added on 31-JAN-2007 o/
		      ENCOUNTER_ID                /o Added on 31-JAN-2007 o/ 
                 FROM BL_EPISODE_FIN_DTLS
                WHERE EPISODE_TYPE = :bl_hdr_episode_type
                  AND EPISODE_ID   = :bl_hdr_episode_id
		  AND OPERATING_FACILITY_ID = :nd_facility_id
                FOR UPDATE OF BLNG_GRP_ID; */ 


      /* EXEC SQL DECLARE IP_ADT_TRN_CUR CURSOR FOR
               SELECT B.BLNG_CLASS_CODE,
                      A.TO_PHYSICIAN_ID,
                      A.TO_BED_CLASS_CODE,
                      C.BILL_TYPE_CODE,
                      A.ORIG_DEPT_CODE,
                      A.TRN_SRL_NUM,
		              A.TO_BED_TYPE_CODE
               FROM BL_IP_ADT_TRN_VW A, BL_IP_BED_TYPE B,  BL_IP_NURSING_UNIT C
               WHERE A.TRN_SRL_NUM = 
                      (SELECT MAX(TRN_SRL_NUM) 
                       FROM BL_IP_ADT_TRN_VW
                       WHERE NVL(ADT_TRN_STATUS,'0') != '9'
                       AND NVL(TRN_CODE,'X') != 'D'
                       AND EPISODE_ID = :bl_hdr_episode_id
		       AND FACILITY_ID =  :nd_facility_id  
		       AND trn_date_time <= TO_DATE(:nd_service_time,'DD/MM/YYYY HH24:MI:SS'))                      
		  AND B.BED_TYPE_CODE = A.TO_BED_TYPE_CODE
		  AND C.NURSING_UNIT_CODE = A.TO_WARD_CODE
                  AND C.FACILITY_ID =  :nd_facility_id  
		  AND A.FACILITY_ID =  C.FACILITY_ID
                  AND A.EPISODE_ID = :bl_hdr_episode_id; */ 


     /* EXEC SQL DECLARE BL_BLNG_SERV_CUR CURSOR FOR
               SELECT NVL(PRT_GRP_HDR_CODE,:bl_param_prt_grp_hdr_code),
                      NVL(PRT_GRP_LINE_CODE,:bl_param_prt_grp_line_code),
                      NVL(SOURCE_MODULE_DEPT_FLAG,'N') ,
                      DEPT_CODE,
                      RATE_ENTRY_BY_USER_FLAG,
                      DEF_CHARGE,
                      /oIP_RATE,o/
                      MIN_CHARGE_AMT,
                      /oNVL(BASE_QTY,1.00),o/
                      SERV_LOCN_CODE,
					  UOM_CODE 
                 FROM BL_BLNG_SERV
                WHERE BLNG_SERV_CODE = :bl_line_blng_serv_code; */ 


/*     EXEC SQL DECLARE BL_BLNG_SERV_FOR_GRP_CUR CURSOR FOR
               SELECT NVL(IP_DISC_PERC,0.00),
                      SETTLEMENT_IND
                 FROM BL_BLNG_SERV_FOR_GRP
                WHERE BLNG_GRP_ID = :bl_epi_blng_grp_id
                  AND BLNG_SERV_CODE = :bl_line_blng_serv_code;
		  */

     /* EXEC SQL DECLARE BL_BLNG_RULE_CUR CURSOR FOR
               SELECT NVL(ADDL_FACTOR_NUM,1.0000)
                 FROM BL_BLNG_RULE
                WHERE BLNG_CLASS_CODE = :bl_adt_blng_class_code
                  AND DAY_TYPE_CODE   = :nd_day_type
                  AND TIME_SLAB_CODE  = :nd_time_type
                  AND BLNG_SERV_CODE  = :bl_line_blng_serv_code; */ 

}


open_hdr1()
{

    
    /* EXEC SQL OPEN BL_RECUR_HDR_CUR1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0010;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )228;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
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
         err_mesg("OPEN failed on cursor BL_RECUR_HDR_CUR1",0,"");
}

open_hdr()
{
    /* EXEC SQL OPEN BL_RECURRING_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0011;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )247;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_hdr_episode_type;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_hdr_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_process_date;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_service_time;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_service_time;
    sqlstm.sqhstl[4] = (unsigned int  )23;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_RECURRING_HDR_CUR",0,"");
}

open_line()
{

    //disp_message(ERR_MESG,bl_hdr_recur_trn_ref.arr);
	//disp_message(ERR_MESG,nd_service_time.arr);
	
    /* EXEC SQL OPEN BL_RECURRING_LINE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0012;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )286;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_hdr_recur_trn_ref;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_service_time;
    sqlstm.sqhstl[1] = (unsigned int  )23;
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
         err_mesg("OPEN failed on cursor BL_RECURRING_LINE_CUR",0,"");
}

fetch_hdr1()
{
bl_hdr_episode_type.arr[0]                                        = '\0';
bl_hdr_episode_id.arr[0]                                          = '\0';

bl_hdr_episode_type.len                                           = 0;
bl_hdr_episode_id.len                                             = 0;

     /* EXEC SQL FETCH BL_RECUR_HDR_CUR1
               INTO :bl_hdr_episode_type,
                    :bl_hdr_episode_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 10;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )313;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_hdr_episode_type;
     sqlstm.sqhstl[0] = (unsigned int  )4;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_hdr_episode_id;
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

	
					
         if (OERROR)
         err_mesg("FETCH failed on cursor BL_RECUR_HDR_CUR1",0,"");

bl_hdr_episode_type.arr[bl_hdr_episode_type.len]                         = '\0';
bl_hdr_episode_id.arr[bl_hdr_episode_id.len]                             = '\0';

/*disp_message(ERR_MESG,"In fetch_hdr1()");
disp_message(ERR_MESG,bl_hdr_episode_id.arr);*/

    return(LAST_ROW?0:1);
}

fetch_hdr()
{
bl_hdr_recur_trn_ref.arr[0]                                       = '\0';
bl_hdr_recur_trn_date.arr[0]                                      = '\0';
bl_hdr_patient_id.arr[0]                                          = '\0';

bl_hdr_recur_trn_ref.len                                          = 0;
bl_hdr_recur_trn_date.len                                         = 0;
bl_hdr_patient_id.len                                             = 0;

     /* EXEC SQL FETCH BL_RECURRING_HDR_CUR
               INTO :bl_hdr_recur_trn_ref,
                    :bl_hdr_recur_trn_date,
                    :bl_hdr_patient_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 10;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )336;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_hdr_recur_trn_ref;
     sqlstm.sqhstl[0] = (unsigned int  )23;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_hdr_recur_trn_date;
     sqlstm.sqhstl[1] = (unsigned int  )15;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_hdr_patient_id;
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
         err_mesg("FETCH failed on cursor BL_RECURRING_HDR_CUR",0,"");

bl_hdr_recur_trn_ref.arr[bl_hdr_recur_trn_ref.len]                       = '\0';
bl_hdr_recur_trn_date.arr[bl_hdr_recur_trn_date.len]                     = '\0';
bl_hdr_patient_id.arr[bl_hdr_patient_id.len]                             = '\0';

if (bl_hdr_patient_id.arr[0])
{
	/* EXEC SQL EXECUTE
	BEGIN
		:bl_reln_code := blcommon.get_reln_code(:bl_hdr_patient_id);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :bl_reln_code := blcommon . get_reln_code ( :bl_hdr_pa\
tient_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )363;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_reln_code;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_hdr_patient_id;
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



	if (bl_reln_code.arr[0] == '\0')
	{
		err_mesg("Invalid Nationality",0,"");

	}
}


return(LAST_ROW?0:1);

}

fetch_line()
{
bl_line_blng_serv_code.arr[0]                                     = '\0';
nd_panel_code.arr[0]						  = '\0';

bl_line_blng_serv_code.len                                        = 0;
nd_panel_code.len						  = 0;

bl_line_charge_amt                                                = 0;
bl_line_serv_qty                                                  = 0;


     /* EXEC SQL FETCH BL_RECURRING_LINE_CUR
               INTO :bl_line_blng_serv_code,
		    :nd_panel_code,
		    :bl_line_serv_qty,
                    :bl_line_charge_amt,
		    :m_service_panel_ind; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 10;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )386;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_line_blng_serv_code;
     sqlstm.sqhstl[0] = (unsigned int  )13;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_panel_code;
     sqlstm.sqhstl[1] = (unsigned int  )13;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_line_serv_qty;
     sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_line_charge_amt;
     sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&m_service_panel_ind;
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
         err_mesg("FETCH failed on cursor BL_RECURRING_LINE_CUR",0,"");

      bl_line_blng_serv_code.arr[bl_line_blng_serv_code.len]                   = '\0';      
      nd_panel_code.arr[nd_panel_code.len]	     		               = '\0';      
      

    return(LAST_ROW?0:1);
}

fetch_on_episode_change()
{

     
     /* EXEC SQL OPEN IP_OPEN_EPISODE_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 10;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0013;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )421;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_hdr_episode_id;
     sqlstm.sqhstl[0] = (unsigned int  )11;
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



	 if (OERROR)
         err_mesg("OPEN failed on cursor IP_OPEN_EPISODE_CUR",0,"");

		 			   //disp_message(ERR_MESG,"Before IP_OPEN_EPISODE_CUR");


     /* EXEC SQL FETCH IP_OPEN_EPISODE_CUR
               INTO :dummy; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 10;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )444;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&dummy;
     sqlstm.sqhstl[0] = (unsigned int  )4;
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


			   //disp_message(ERR_MESG,"After IP_OPEN_EPISODE_CUR");

     if (OERROR)
	 {
	      err_mesg("FETCH failed on cursor IP_OPEN_EPISODE_CUR",0,"");
		 }
     if (NOT_FOUND)
     {
         sprintf(msg_str,"Record not found in IP OPEN EPISODE for %s",
                 bl_hdr_episode_id.arr);
         log_err_mesg(msg_str,0,"");
         err_ctr++;
         return (0);

     }

//disp_message(ERR_MESG,"After IP_OPEN_EPISODE_CUR before fin_cur");

  /*   EXEC SQL OPEN BL_EPISODE_FIN_DTLS_CUR;

     if (OERROR)
	 {
    	 //disp_message(ERR_MESG,"After IP_OPEN_EPISODE_CUR before fin_cur1");
         err_mesg("OPEN failed on cursor BL_EPISODE_FIN_DTLS_CUR",0,"");
}
     bl_epi_blng_grp_id.arr[0]		= '\0';
     bl_epi_blng_grp_id.len		= 0;
     bl_epi_status.arr[0]		= '\0';
     bl_epi_status.len			= 0;
     bl_epi_disch_bill.arr[0]		= '\0';
     bl_epi_disch_bill.len		= 0;
     bl_epi_disch_yn.arr[0]		= '\0';
     bl_epi_disch_yn.len		= 0;
     epfndt_cust_code.arr[0]		= '\0';
     epfndt_cust_code.len		= 0;
     epfndt_non_ins_blng_grp_id.arr[0]	= '\0';
     epfndt_non_ins_blng_grp_id.len	= 0;
     epfndt_non_ins_cust_code.arr[0]	= '\0';
     epfndt_non_ins_cust_code.len	= 0;
     epfndt_bill_doc_type_code.arr[0]	= '\0';
     epfndt_bill_doc_type_code.len	= 0;
     epfndt_bill_doc_number.arr[0]	= '\0';
     epfndt_bill_doc_number.len		= 0;
     epfndt_policy_type_code.arr[0]	= '\0';
     epfndt_policy_type_code.len	= 0;
     epfndt_credit_auth_ref.arr[0]	= '\0';
     epfndt_credit_auth_ref.len		= 0;
     epfndt_effective_date.arr[0]	= '\0';
     epfndt_effective_date.len		= 0;
     epfndt_app_days			= 0;
     m_cur_acct_seq_no                  = 0;

//disp_message(ERR_MESG,"After IP_OPEN_EPISODE_CUR before fin_cur2");
	
     EXEC SQL FETCH BL_EPISODE_FIN_DTLS_CUR
               INTO :bl_epi_blng_grp_id,
                    :bl_epi_status,
                    :bl_epi_disch_bill,
                    :bl_epi_disch_yn,
		    :epfndt_cust_code,
		    :epfndt_non_ins_blng_grp_id,
		    :epfndt_non_ins_cust_code,
		    :epfndt_bill_doc_type_code,
		    :epfndt_bill_doc_number,
		    :epfndt_policy_type_code,
		    :epfndt_credit_auth_ref,
		    :epfndt_effective_date,
		    :epfndt_app_days,
		    :m_cur_acct_seq_no,
		    :m_encounter_id;
			

     if (OERROR)
	 {
	 //disp_message(ERR_MESG,"After IP_OPEN_EPISODE_CUR before fin_cur3");
      err_mesg("FETCH failed on cursor BL_EPISODE_FIN_DTLS_CUR",0,"");
	  }

     bl_epi_blng_grp_id.arr[bl_epi_blng_grp_id.len] = '\0';
     bl_epi_status.arr[bl_epi_status.len]           = '\0';
     bl_epi_disch_bill.arr[bl_epi_disch_bill.len]   = '\0';
     bl_epi_disch_yn.arr[bl_epi_disch_yn.len]       = '\0';
     epfndt_cust_code.arr[epfndt_cust_code.len] = '\0';
     epfndt_non_ins_blng_grp_id.arr[epfndt_non_ins_blng_grp_id.len] = '\0';
     epfndt_non_ins_cust_code.arr[epfndt_non_ins_cust_code.len] = '\0';
     epfndt_bill_doc_type_code.arr[epfndt_bill_doc_type_code.len] = '\0';
     epfndt_bill_doc_number.arr[epfndt_bill_doc_number.len] = '\0';
     epfndt_policy_type_code.arr[epfndt_policy_type_code.len] = '\0';
     epfndt_credit_auth_ref.arr[epfndt_credit_auth_ref.len] = '\0';
     epfndt_effective_date.arr[epfndt_effective_date.len] = '\0';

     if (NOT_FOUND)
     {//disp_message(ERR_MESG,"After IP_OPEN_EPISODE_CUR before fin_cur4");

          sprintf(msg_str,"Record not found in BL EPISODE FIN DTLS for %s - %s EPISODE",
                         bl_hdr_episode_type.arr,
                         bl_hdr_episode_id.arr);
          log_err_mesg(msg_str,0,"");
          err_ctr++;
          return (0);
     }


     if (bl_epi_status.arr[0] == '9')
     {
          sprintf(msg_str,"Episode Status is Cancelled for %s - %s EPISODE",
                         bl_hdr_episode_type.arr,
                         bl_hdr_episode_id.arr);
          log_err_mesg(msg_str,0,"");
          err_ctr++;
          return (0);
     }
     if (bl_epi_disch_bill.arr[0] == 'Y')
     {
          sprintf(msg_str,"Active Discharge Bill exist for %s - %s EPISODE",
                         bl_hdr_episode_type.arr,
                         bl_hdr_episode_id.arr);
          log_err_mesg(msg_str,0,"");
          err_ctr++;
          return (0);
     }
	 
     if (bl_epi_disch_yn.arr[0] == 'Y')
     {
          sprintf(msg_str,"Discharge process done for %s - %s EPISODE",
                         bl_hdr_episode_type.arr,
                         bl_hdr_episode_id.arr);
          log_err_mesg(msg_str,0,"");
          err_ctr++;
          return (0);
     }

*/	

   //disp_message(ERR_MESG,"before");
 /*disp_message(ERR_MESG,bl_hdr_episode_id.arr);

    disp_message(ERR_MESG,"In Fetch_on_episode_change");
	disp_message(ERR_MESG,bl_hdr_episode_id.arr);
    disp_message(ERR_MESG,nd_facility_id .arr);
	disp_message(ERR_MESG,nd_service_time.arr);*/

	 /* EXEC SQL OPEN IP_ADT_TRN_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0015;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )463;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&bl_hdr_episode_id;
  sqlstm.sqhstl[0] = (unsigned int  )11;
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
  sqlstm.sqhstv[2] = (         void  *)&nd_service_time;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[3] = (unsigned int  )5;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&bl_hdr_episode_id;
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



     if (OERROR)
	     		 
         err_mesg("OPEN failed on cursor IP_ADT_TRN_CUR",0,"");

bl_adt_blng_class_code.arr[0]                                     = '\0';
bl_adt_to_physician_id.arr[0]                                     = '\0';
bl_adt_to_bed_class_code.arr[0]                                   = '\0';
bl_adt_bill_type_code.arr[0]                                      = '\0';
bl_adt_orig_dept_code.arr[0]                                      = '\0';
bl_adt_trn_srl_num.arr[0]                                         = '\0';
bl_bed_type_code.arr[0]						  = '\0';

bl_adt_blng_class_code.len                                        = 0;
bl_adt_to_physician_id.len                                        = 0;
bl_adt_to_bed_class_code.len                                      = 0;
bl_adt_bill_type_code.len                                         = 0;
bl_adt_orig_dept_code.len                                         = 0;
bl_adt_trn_srl_num.len                                            = 0;
bl_bed_type_code.len						  = 0;

	/* EXEC SQL FETCH IP_ADT_TRN_CUR
        INTO :bl_adt_blng_class_code,
	:bl_adt_to_physician_id,
	:bl_adt_to_bed_class_code,
	:bl_adt_bill_type_code,
	:bl_adt_orig_dept_code,
	:bl_adt_trn_srl_num,
	:bl_bed_type_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )498;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&bl_adt_blng_class_code;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_adt_to_physician_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&bl_adt_to_bed_class_code;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&bl_adt_bill_type_code;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&bl_adt_orig_dept_code;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&bl_adt_trn_srl_num;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&bl_bed_type_code;
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
	 {
	  err_mesg("FETCH failed on cursor IP_ADT_TRN_CUR",0,"");
      }

bl_adt_blng_class_code.arr[bl_adt_blng_class_code.len]                   = '\0';
bl_adt_to_physician_id.arr[bl_adt_to_physician_id.len]                   = '\0';
bl_adt_to_bed_class_code.arr[bl_adt_to_bed_class_code.len]               = '\0';
bl_adt_bill_type_code.arr[bl_adt_bill_type_code.len]                     = '\0';
bl_adt_orig_dept_code.arr[bl_adt_orig_dept_code.len]                     = '\0';
bl_adt_trn_srl_num.arr[bl_adt_trn_srl_num.len]                           = '\0';
bl_bed_type_code.arr[bl_bed_type_code.len]				 = '\0';

//disp_message(ERR_MESG,"Before displaying Values...");

/*disp_message(ERR_MESG,bl_adt_to_physician_id.arr);
disp_message(ERR_MESG,bl_adt_to_bed_class_code.arr);
disp_message(ERR_MESG,bl_bed_type_code.arr);
disp_message(ERR_MESG,bl_adt_blng_class_code.arr);
disp_message(ERR_MESG,bl_adt_orig_dept_code.arr);
disp_message(ERR_MESG,bl_bed_type_code.arr);
disp_message(ERR_MESG,"Before if not found");
*/

 if (NOT_FOUND)
  
  {
     sprintf(msg_str,"Record not found in IP_ADT_TRN for %s - %s EPISODE",
                         bl_hdr_episode_type.arr,
                         bl_hdr_episode_id.arr);
     log_err_mesg(msg_str,0,"");
     err_ctr++;
     return (0);
  }

/*disp_message(ERR_MESG,"Before INVALID ED TYPE");*/
if (bl_bed_type_code.arr[0] == '\0')
	err_mesg("Invalid Bed Type",0,"");

if (bl_bed_type_code.arr[0])
{
	/* EXEC SQL EXECUTE
	BEGIN
		:bl_blng_class_code := null;
		:bl_blng_class_code :=  BLVALID.GET_BED_BLNG_CLASS(:bl_bed_type_code);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :bl_blng_class_code := null ; :bl_blng_class_code := B\
LVALID . GET_BED_BLNG_CLASS ( :bl_bed_type_code ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )541;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&bl_blng_class_code;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&bl_bed_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
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


	if (bl_blng_class_code.arr[0] == '\0')
	{
		err_mesg("Invalid billing class code",0,"");
 	 }
}	

  return (1);
}

fetch_blng_service()
{
     /* EXEC SQL OPEN BL_BLNG_SERV_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 10;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0016;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )564;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&bl_param_prt_grp_hdr_code;
     sqlstm.sqhstl[0] = (unsigned int  )8;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_param_prt_grp_line_code;
     sqlstm.sqhstl[1] = (unsigned int  )6;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_line_blng_serv_code;
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
         err_mesg("OPEN failed on cursor BL_BLNG_SERV_CUR",0,"");

bl_srv_prt_grp_hdr_code.arr[0]                                    = '\0';
bl_srv_prt_grp_line_code.arr[0]                                   = '\0';
bl_srv_source_module_dpt_flg.arr[0]                             = '\0';
bl_srv_dept_code.arr[0]                                           = '\0';
bl_srv_rate_entry_by_usr_flg.arr[0]                             = '\0';
bl_srv_serv_locn_code.arr[0]                                      = '\0';

bl_srv_prt_grp_hdr_code.len                                       = 0;
bl_srv_prt_grp_line_code.len                                      = 0;
bl_srv_source_module_dpt_flg.len                                = 0;
bl_srv_dept_code.len                                              = 0;
bl_srv_rate_entry_by_usr_flg.len                                = 0;
bl_srv_serv_locn_code.len                                         = 0;

bl_srv_def_charge                                                 = 0;
bl_srv_min_charge_amt                                             = 0;
bl_srv_ip_rate                                                    = 0;
bl_srv_base_qty                                                   = 0;


/* Using PL/SQL PKG to get MPI	*/

     /* EXEC SQL FETCH BL_BLNG_SERV_CUR
               INTO :bl_srv_prt_grp_hdr_code,
                    :bl_srv_prt_grp_line_code,
                    :bl_srv_source_module_dpt_flg,
                    :bl_srv_dept_code,
                    :bl_srv_rate_entry_by_usr_flg,					
		            :bl_srv_serv_locn_code,
					:m_uom_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 10;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )591;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_srv_prt_grp_hdr_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_srv_prt_grp_line_code;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_srv_source_module_dpt_flg;
     sqlstm.sqhstl[2] = (unsigned int  )4;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_srv_dept_code;
     sqlstm.sqhstl[3] = (unsigned int  )13;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_srv_rate_entry_by_usr_flg;
     sqlstm.sqhstl[4] = (unsigned int  )4;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_srv_serv_locn_code;
     sqlstm.sqhstl[5] = (unsigned int  )7;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&m_uom_code;
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
         err_mesg("FETCH failed on cursor BL_BLNG_SERV_CUR",0,"");

bl_srv_prt_grp_hdr_code.arr[bl_srv_prt_grp_hdr_code.len]                 = '\0';
bl_srv_prt_grp_line_code.arr[bl_srv_prt_grp_line_code.len]               = '\0';
bl_srv_source_module_dpt_flg.arr[bl_srv_source_module_dpt_flg.len]   = '\0';
bl_srv_dept_code.arr[bl_srv_dept_code.len]                               = '\0';
bl_srv_rate_entry_by_usr_flg.arr[bl_srv_rate_entry_by_usr_flg.len]   = '\0';
bl_srv_serv_locn_code.arr[bl_srv_serv_locn_code.len]                     = '\0';

   if (NOT_FOUND)
   {
       sprintf(msg_str,"Record not found in BL BLNG SERV %s ",
                         bl_line_blng_serv_code.arr);
       loc_log_msg(msg_str,0,"");
       return(0);
   }
   else
   {  /*get_ser_amt();       Added for MPI */
      bl_srv_def_charge		= m_def_charge;
      bl_srv_ip_rate		= m_serv_price;
      bl_srv_min_charge_amt	= m_min_charge_amt;
      bl_srv_base_qty		= m_base_qty;

      return(1);
    }
}

fetch_blng_serv_for_grp()
{
bl_blng_ip_disc_perc	= 0;
bl_blng_ip_disc_perc	= m_disc_perc;
 
}

/*

fetch_blng_serv_for_grp()
{
 
     EXEC SQL OPEN BL_BLNG_SERV_FOR_GRP_CUR;

     if (OERROR)
         err_mesg("OPEN failed on cursor BL_BLNG_SERV_FOR_GRP_CUR",0,"");

bl_blng_settlement_ind.arr[0]                                     = '\0';
bl_blng_settlement_ind.len                                        = 0;

bl_blng_ip_disc_perc                                              = 0;

     EXEC SQL FETCH BL_BLNG_SERV_FOR_GRP_CUR
               INTO :bl_blng_ip_disc_perc,
                    :bl_blng_settlement_ind;

     if (OERROR)
         err_mesg("FETCH failed on cursor BL_BLNG_SERV_FOR_GRP_CUR",0,"");
	 

// Code introduced on 22/01/94 for billing rules change 

     if (NOT_FOUND)
      {
       strcpy(blng_serv_code_old.arr, bl_line_blng_serv_code.arr);
       blng_serv_code_old.len = strlen(blng_serv_code_old.arr);
       blng_serv_code_spl.arr[0] = bl_line_blng_serv_code.arr[0];
       blng_serv_code_spl.arr[1] = bl_line_blng_serv_code.arr[1];
       blng_serv_code_spl.arr[2] = '\0';
       blng_serv_code_spl.len = strlen(blng_serv_code_spl.arr);
       strcpy(bl_line_blng_serv_code.arr, blng_serv_code_spl.arr);
       bl_line_blng_serv_code.len = strlen(bl_line_blng_serv_code.arr);
       EXEC SQL OPEN BL_BLNG_SERV_FOR_GRP_CUR;

        if (OERROR)
         err_mesg("OPEN failed on cursor BL_BLNG_SERV_FOR_GRP_CUR",0,"");

       EXEC SQL FETCH BL_BLNG_SERV_FOR_GRP_CUR
               INTO :bl_blng_ip_disc_perc,
                    :bl_blng_settlement_ind;

        if (OERROR)
         err_mesg("FETCH failed on cursor BL_BLNG_SERV_FOR_GRP_CUR",0,"");

        if (NOT_FOUND)
         {
          strcpy(blng_serv_code_spl.arr, "ALL");
          blng_serv_code_spl.len = strlen(blng_serv_code_spl.arr);
          strcpy(bl_line_blng_serv_code.arr, blng_serv_code_spl.arr);
          bl_line_blng_serv_code.len = strlen(bl_line_blng_serv_code.arr);
          EXEC SQL OPEN BL_BLNG_SERV_FOR_GRP_CUR;

           if (OERROR)
            err_mesg("OPEN failed on cursor BL_BLNG_SERV_FOR_GRP_CUR",0,"");

          EXEC SQL FETCH BL_BLNG_SERV_FOR_GRP_CUR
               INTO :bl_blng_ip_disc_perc,
                    :bl_blng_settlement_ind;

           if (OERROR)
            err_mesg("FETCH failed on cursor BL_BLNG_SERV_FOR_GRP_CUR",0,"");
         }
       strcpy(bl_line_blng_serv_code.arr, blng_serv_code_old.arr);
       bl_line_blng_serv_code.len = strlen(bl_line_blng_serv_code.arr);
      }
// End of Code on 22/01/94 

bl_blng_settlement_ind.arr[bl_blng_settlement_ind.len]                   = '\0';

   if (NOT_FOUND)
   {
       bl_blng_ip_disc_perc = 0;
       return (0);
   }
   else
       return (1);
}
*/


fetch_addl_factor()
{
	bl_rule_addl_factor_num = m_addl_factor_num;
}


/*
fetch_addl_factor()
{
     EXEC SQL OPEN BL_BLNG_RULE_CUR;

     if (OERROR)
         err_mesg("OPEN failed on cursor BL_BLNG_RULE_CUR",0,"");

     bl_rule_addl_factor_num                                           = 0;

     EXEC SQL FETCH BL_BLNG_RULE_CUR
               INTO :bl_rule_addl_factor_num;

     if (OERROR)
         err_mesg("FETCH failed on cursor BL_BLNG_RULE_CUR",0,"");

// Code introduced on 22/01/94 for billing rules change

     if (NOT_FOUND)
      {
       strcpy(blng_serv_code_old.arr, bl_line_blng_serv_code.arr);
       blng_serv_code_old.len = strlen(blng_serv_code_old.arr);
       blng_serv_code_spl.arr[0] = bl_line_blng_serv_code.arr[0];
       blng_serv_code_spl.arr[1] = bl_line_blng_serv_code.arr[1];
       blng_serv_code_spl.arr[2] = '\0';
       blng_serv_code_spl.len = strlen(blng_serv_code_spl.arr);
       strcpy(bl_line_blng_serv_code.arr, blng_serv_code_spl.arr);
       bl_line_blng_serv_code.len = strlen(bl_line_blng_serv_code.arr);
       EXEC SQL OPEN BL_BLNG_RULE_CUR;

       if (OERROR)
         err_mesg("OPEN failed on cursor BL_BLNG_RULE_CUR",0,"");
       EXEC SQL FETCH BL_BLNG_RULE_CUR
               INTO :bl_rule_addl_factor_num;

       if (OERROR)
         err_mesg("FETCH failed on cursor BL_BLNG_RULE_CUR",0,"");

        if (NOT_FOUND)
         {
          strcpy(blng_serv_code_spl.arr, "ALL");
          blng_serv_code_spl.len = strlen(blng_serv_code_spl.arr);
          strcpy(bl_line_blng_serv_code.arr, blng_serv_code_spl.arr);
          bl_line_blng_serv_code.len = strlen(bl_line_blng_serv_code.arr);
          EXEC SQL OPEN BL_BLNG_RULE_CUR;

          if (OERROR)
           err_mesg("OPEN failed on cursor BL_BLNG_RULE_CUR",0,"");
          EXEC SQL FETCH BL_BLNG_RULE_CUR
               INTO :bl_rule_addl_factor_num;

          if (OERROR)
           err_mesg("FETCH failed on cursor BL_BLNG_RULE_CUR",0,"");
         }
       strcpy(bl_line_blng_serv_code.arr, blng_serv_code_old.arr);
       bl_line_blng_serv_code.len = strlen(bl_line_blng_serv_code.arr);
      }
// End of code on 22/01/94 

     if (NOT_FOUND)
     {
        bl_rule_addl_factor_num                                = 1.0000;
        return(0);
     } 
     return(1);
}
*/

compute_charges()
{	nd_gross_charge = gross_charge_amt;
	nd_disc_amt	= disc_amt;
	nd_net_amt	= net_charge_amt;
}

/*
compute_charges(base_qty,base_rate,disc_perc,addl_factor,min_chg_amt)
double base_qty,base_rate,disc_perc,addl_factor,min_chg_amt;
{
   nd_base_charge =  base_rate * bl_line_serv_qty / base_qty;
   nd_gross_charge = nd_base_charge * addl_factor;
   if (nd_gross_charge < min_chg_amt)
      nd_gross_charge = min_chg_amt;
   nd_disc_amt     = nd_gross_charge * (disc_perc/(double)100);
   nd_net_amt      = nd_gross_charge - nd_disc_amt;
}
*/




do_episode_change()
{
/*
      EXEC SQL UPDATE BL_EPISODE_FIN_DTLS
                  SET TOT_BUS_GEN_AMT   = NVL(TOT_BUS_GEN_AMT,0) +
                              :epi_tot_gross_charge,
                      TOT_BUS_DISC_AMT  = NVL(TOT_BUS_DISC_AMT,0) +
                              :epi_tot_disc_amt,
                      TOT_UNBLD_AMT     = NVL(TOT_UNBLD_AMT,0) +
                              :epi_tot_net_amt,
				   MODIFIED_BY_ID = USER ,
				   MODIFIED_DATE  = SYSDATE ,       
				   MODIFIED_AT_WS_NO = :nd_ws_no,     
				   MODIFIED_FACILITY_ID = :nd_facility_id 
                WHERE EPISODE_TYPE = :store_episode_type
                  AND EPISODE_ID   = :store_episode_id
				  AND OPERATING_FACILITY_ID = :nd_facility_id;

     if (OERROR)
         err_mesg("UPDATE failed on table BL_EPISODE_FIN_DTLS",0,"");

      EXEC SQL UPDATE BL_PATIENT_FIN_DTLS
                  SET TOT_BUSINESS_IP_AMT = NVL(TOT_BUSINESS_IP_AMT,0) +
                               :epi_tot_gross_charge,
                      TRX_PROCESSED_IND   = 'Y',
                      TOT_UNBLD_IP_AMT    = NVL(TOT_UNBLD_IP_AMT,0) +
                               :epi_tot_net_amt,
				   MODIFIED_BY_ID = USER ,
				   MODIFIED_DATE  = SYSDATE ,       
				   MODIFIED_AT_WS_NO = :nd_ws_no,     
				   MODIFIED_FACILITY_ID = :nd_facility_id 
                WHERE PATIENT_ID = :store_patient_id;

      if (OERROR)
         err_mesg("UPDATE failed on table BL_PATIENT_FIN_DTLS",0,"");
 */

      /* EXEC SQL UPDATE BL_RECURRING_HDR
                  SET LAST_GEN_DATE = TRUNC(TO_DATE(:nd_service_time,'DD/MM/YYYY HH24:MI:SS')),
				  MODIFIED_BY_ID = USER ,
				   MODIFIED_DATE  = SYSDATE ,       
				   MODIFIED_AT_WS_NO = :nd_ws_no,     
				   MODIFIED_FACILITY_ID = :nd_facility_id 
                WHERE EPISODE_TYPE  = :store_episode_type
                  AND EPISODE_ID    = :store_episode_id
				  AND OPERATING_FACILITY_ID = :nd_facility_id; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 10;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "update BL_RECURRING_HDR  set LAST_GEN_DATE=TRUNC(TO_DAT\
E(:b0,'DD/MM/YYYY HH24:MI:SS')),MODIFIED_BY_ID=USER,MODIFIED_DATE=SYSDATE,MODI\
FIED_AT_WS_NO=:b1,MODIFIED_FACILITY_ID=:b2 where ((EPISODE_TYPE=:b3 and EPISOD\
E_ID=:b4) and OPERATING_FACILITY_ID=:b2)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )634;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_service_time;
      sqlstm.sqhstl[0] = (unsigned int  )23;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&nd_ws_no;
      sqlstm.sqhstl[1] = (unsigned int  )33;
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
      sqlstm.sqhstv[3] = (         void  *)&store_episode_type;
      sqlstm.sqhstl[3] = (unsigned int  )4;
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&store_episode_id;
      sqlstm.sqhstl[4] = (unsigned int  )11;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&nd_facility_id;
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



      if (OERROR)
         err_mesg("UPDATE failed on table BL_RECURRING_HDR",0,"");

      /* EXEC SQL COMMIT WORK; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 10;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )673;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


      if (OERROR)
         err_mesg("COMMIT failed",0,"");
}

loc_log_msg(str)
char str[];
{
  if (strlen(str) > 70)
      str[70] = '\0';
  if (err_ctr == 0)
       continue_to_next_ref();

  disp_message(INFO_MESG,str);
  log_err_mesg(str,0,"");
  err_ctr++;
}

continue_to_next_ref()
{
    /* EXEC SQL ROLLBACK WORK TO SAVEPOINT LAST_EPISODE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "rollback work  to LAST_EPISODE";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )688;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("ROLLBACK TO LAST_EPISODE failed",0,""); 
}

/*get_ser_amt()
{

EXEC SQL EXECUTE    
BEGIN
	:nd_error_id := null;
	:nd_error_code := null;
	:nd_error_text := null;		

BLCORE.BL_MPI_PKG_INS_CHECK
	(:bl_hdr_patient_id,
	 :bl_hdr_episode_id,
	 'I',
	 :bl_adt_trn_srl_num,
	 :bl_epi_blng_grp_id,	 
	 TO_DATE(:nd_service_time,'DD/MM/YYYY HH24:MI:SS'),
	 :bl_line_blng_serv_code,
	 :epfndt_cust_code,
	 :epfndt_non_ins_blng_grp_id,
	 :epfndt_non_ins_cust_code,
	 :bl_blng_class_code,
	 :bl_reln_code,
	 :pkg_serv_code,
	 :epfndt_pkg_bill_doc_type,
	 :epfndt_pkg_bill_doc_num,
	 :pkg_bill_date,
	 :pkg_serv_price,
	 :pkg_serv_disc,
	 :pkg_qv_ind,
	 :pkg_qv_val,
	 :pkg_qv_availed,
	 :pkg_addl_qty_flag,
	 :pkg_addl_qty,
	 :pkg_addl_qty_availed,
	 :pkg_addl_serv_price,
	 :pkg_flag,
	 :ins_flag,
	 :m_df_flag,
	 :m_misc_flag,
	 :m_rate_flag,
	 :m_def_charge,
	 :m_base_qty,
	 :m_min_charge_amt,
	 :m_serv_price,
	 :m_serv_disc,
	 :m_pat_base_qty,
	 :m_pat_min_charge_amt,
	 :m_pat_serv_price,
	 :m_pat_serv_disc,
	 :m_serv_status,
	 :epfndt_policy_type_code,
	 :epfndt_effective_date,
	 :epfndt_credit_auth_ref,
	 :m_approved_amt,
	 :m_availed_amt,
	 :epfndt_app_days,
	 :copay_perc,
	 :m_op_cover,
	 :m_excl_incl_ind,
	 :m_copay_ind,
	 :m_copay_val,
	 :m_preapp_yn,
	 :m_copay_yn,
	 :m_app_rate_ind,
	 :m_app_dic_ind,
	 :m_pat_app_rate_ind,
	 :m_pat_app_dic_ind,
	 :m_pat_cust_code,
	 :m_pat_ins_cust_code,
	 :m_addl_factor_num,
	 '0',
	 :nd_facility_id,
	 'BL',
	 :m_pc_code,
	 :p_levy_appl_yn,
	 :p_char1,
	 :p_char2,
	 :p_levy_amt,
	 :p_num2,
	 :nd_error_id,
	 :nd_error_code,
	 :nd_error_text);

END;
END-EXEC;

     if (nd_error_code.arr[0])		
        err_mesg("SELECT failed on BLCORE.BL_MPI_PKG_INS_CHECK",1,nd_error_code.arr);

     if (nd_error_text.arr[0] && strcmp(nd_error_id.arr,'10') == 0 )
	err_mesg(nd_error_text.arr,0,"");




EXEC SQL EXECUTE
BEGIN
	:nd_error_id := null;
	:nd_error_code := null;
	:nd_error_text := null;
//START OLD COMT

IF :m_rate_flag = 'R' then

BLVALID.BLRUL_GET_BLNG_FCTR(
			  :bl_adt_blng_class_code,
			  :nd_day_type,
                          :nd_time_type,
                          :bl_line_blng_serv_code,
                          :m_addl_factor_num,
                          :nd_error_id,
                          :nd_error_code,
                          :nd_error_text);

End if;
//END OLD COMMENT

END;
END-EXEC;

     if (nd_error_code.arr[0])		
        err_mesg("SELECT failed on BLVALID.BLRUL_GET_BLNG_FCTR",1,nd_error_code.arr);

     if (nd_error_text.arr[0] && strcmp(nd_error_id.arr,'10') == 0 )
	err_mesg(nd_error_text.arr,0,"");


EXEC SQL EXECUTE
BEGIN

	:nd_error_id := null;
	:nd_error_code := null;
	:nd_error_text := null;


IF :epfndt_pkg_bill_doc_type IS NOT NULL THEN
	IF :pkg_qv_ind = 'Q' THEN              
		:m_pkg_price := NVL(:pkg_serv_price / :pkg_qv_val,0);
		:m_pkg_val   := NVL(:pkg_serv_price,0);
	ELSE
		:m_pkg_price := NVL(:m_serv_price,0);
		:m_pkg_val   := NVL(:pkg_serv_price,0);
	END IF;	      
END IF;

:m_serv_qty := nvl(:m_base_qty,1);

IF :m_rate_flag = 'C' then 	

	    if nvl(:m_def_charge,0) < nvl(:m_min_charge_amt,0) then 
		:m_def_charge := :m_min_charge_amt;
	    end if;   	    

            :m_base_rate        := NVL(:m_def_charge,0);
            :m_base_charge_amt  := NVL(:m_def_charge,0);
	    
	    if nvl(:m_def_charge,0) < nvl(:bl_line_charge_amt,0) then 
	        :m_def_charge := nvl(:bl_line_charge_amt,0);
	    end if;

            :net_charge_amt     := NVL(:m_def_charge,0);
            :gross_charge_amt   := NVL(:m_def_charge,0);
            :disc_amt	        := 0.00;
            :m_serv_qty         := nvl(:m_base_qty,1);
END IF;


IF :m_rate_flag = 'C' then 
            :m_serv_qty        :=  :m_base_qty;
            :m_addl_factor_num := 1.0000;
            :m_disc_perc := 0.00;

   BLCORE.BL_MPI_CHARGE_INS (  
	      'I',
	      :epfndt_pkg_bill_doc_type, 
	      :ins_flag,			      
	      :pkg_flag, 
	      :pkg_serv_price,
	      :pkg_serv_disc,
	      :m_pkg_price,
	      :m_pkg_val, 
	      :pkg_qv_ind,
	      :pkg_qv_val, 
	      :pkg_qv_availed,
	      :pkg_addl_qty_flag,
	      :pkg_addl_qty,
	      :pkg_addl_qty_availed,
	      :pkg_addl_serv_price,
	      :m_addl_factor_num,
	      :m_serv_price,
	      :m_serv_disc,
 	      :epfndt_policy_type_code,
	      :m_approved_amt, 
	      :m_availed_amt,
	      :copay_perc, 
	      :m_excl_incl_ind, 
	      :m_copay_ind,   
	      :m_copay_val,
	      :m_preapp_yn,
	      :m_serv_qty,
  	      :m_base_qty,
	      :m_base_rate,
	      :m_base_charge_amt,
	      :m_min_charge_amt,
	      :gross_charge_amt,
	      :disc_amt,
	      :net_charge_amt,
	      :m_pat_base_qty,
	      :m_pat_base_rate,
	      :m_pat_serv_qty,
	      :m_pat_base_charge_amt,
	      :m_pat_gross_charge_amt,
	      :m_pat_disc_amt,
	      :m_pat_net_charge_amt,
	      :m_cust_base_qty,
	      :m_cust_base_rate,
	      :m_cust_serv_qty,
	      :m_cust_base_charge_amt,
	      :m_cust_gross_charge_amt,
	      :m_cust_disc_amt,
	      :m_cust_net_charge_amt,
	      :m_split_ind,
	      :m_pkg_ins_pat_ind,
	      :m_canadj_alert_ind,
	      :m_curr_availed,
	      :m_req_pkg_qty,
	      :m_req_addl_qty,
	      :m_req_std_qty,
	      :nd_facility_id,
	      :p_levy_appl_yn,
	      :p_char1,
	      :p_char2,
	      :p_levy_amt,
	      :p_num2,
	      :nd_error_id,
	      :nd_error_code,
	      :nd_error_text) ;
ELSE  

	:m_disc_perc := :m_serv_disc; 

	IF :pkg_qv_val is null THEN
		:pkg_qv_val := 0;
	 END IF;

	 BLCORE.BL_MPI_CALCULATION(
		 'I', 
		 :epfndt_pkg_bill_doc_type,
		 :pkg_flag,
	         :ins_flag,
		 :m_serv_qty,
		 :m_addl_factor_num,	
		 :pkg_serv_price,
		 :pkg_serv_disc,
		 :m_pkg_price,
	         :m_pkg_val,
		 :pkg_qv_ind,
		 :pkg_qv_val,
		 :m_availed_amt,
		 :pkg_addl_qty_flag,
		 :pkg_addl_qty,
	         :pkg_addl_qty_availed,
		 :pkg_addl_serv_price,
		 :m_base_qty,
	         :m_min_charge_amt,
		 :m_serv_price,
		 :m_serv_disc,
		 :m_pat_base_qty,
		 :m_pat_min_charge_amt,
		 :m_pat_serv_price,
	         :m_pat_serv_disc,
		 :epfndt_policy_type_code,
		 :m_approved_amt,
	         :m_availed_amt,
		 :copay_perc,
		 :m_excl_incl_ind,
		 :m_copay_ind,
		 :m_copay_val,
		 :m_preapp_yn,
	         :m_base_qty,
		 :m_base_rate,
		 :m_base_charge_amt,
		 :gross_charge_amt,
		 :disc_amt,
		 :net_charge_amt,			      
		 :m_pat_base_qty,
		 :m_pat_base_rate,
		 :m_pat_serv_qty,
		 :m_pat_base_charge_amt,
		 :m_pat_gross_charge_amt,
		 :m_pat_disc_amt,
		 :m_pat_net_charge_amt,
		 :m_cust_base_qty,
		 :m_cust_base_rate,
		 :m_cust_serv_qty,
		 :m_cust_base_charge_amt,
		 :m_cust_gross_charge_amt,
	         :m_cust_disc_amt,
		 :m_cust_net_charge_amt,
		 :m_split_ind,
	         :m_pkg_ins_pat_ind,
		 :m_req_pkg_qty,
		 :m_req_addl_qty,
	         :m_req_std_qty,
		 :m_curr_availed,
		 :m_canadj_alert_ind,
	         :nd_facility_id,
		 :p_levy_appl_yn,
		 :p_char1,
		 :p_char2,
		 :p_levy_amt,
		 :p_num2,
		 :nd_error_id,
		 :nd_error_code,
		 :nd_error_text) ;
END IF;
END;
END-EXEC;

	if (nd_error_code.arr[0])	
	 err_mesg("SELECT failed on BL_MPI_CHARGE_INS/BL_MPI_CALCULATION",1,nd_error_code.arr);

	if (nd_error_text.arr[0] && strcmp(nd_error_id.arr,'10') == 0 )
	err_mesg(nd_error_text.arr,0,"");

}
*/

insert_patient_charges_folio()
{ 

//disp_message(ERR_MESG,"Inside patient folio........");

/* EXEC SQL EXECUTE    
BEGIN
	:nd_error_id := null;
	:nd_error_code := null;
	:nd_error_text := null;
		   
	:patfolio_trx_doc_ref := null;

	BLCORE.GENERATE_SEQUENCE_COMMON_PROC
	(:nd_facility_id,'RECU_IP','BL'||'-'||'RECU', :patfolio_trx_doc_ref,:nd_error_text);	
END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 10;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin :nd_error_id := null ; :nd_error_code := null ; :nd_err\
or_text := null ; :patfolio_trx_doc_ref := null ; BLCORE . GENERATE_SEQUENCE_C\
OMMON_PROC ( :nd_facility_id , 'RECU_IP' , 'BL' || '-' || 'RECU' , :patfolio_t\
rx_doc_ref , :nd_error_text ) ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )703;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_error_id;
sqlstm.sqhstl[0] = (unsigned int  )12;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_error_code;
sqlstm.sqhstl[1] = (unsigned int  )13;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_error_text;
sqlstm.sqhstl[2] = (unsigned int  )102;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&patfolio_trx_doc_ref;
sqlstm.sqhstl[3] = (unsigned int  )23;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
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



  /*l_trx_doc_ref_line_num = 0;*/

  l_trx_doc_ref_line_num = 1;

/*disp_message(ERR_MESG,"PROCESSING........");
disp_message(ERR_MESG,m_service_panel_ind.arr);*/

if (strcmp(m_service_panel_ind.arr,"L") == 0)

{

/*disp_message(ERR_MESG,"Inside the L condition"); */

/* EXEC SQL EXECUTE   
BEGIN
BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(:nd_facility_id,				/oP_FACILITY_ID		IN VARCHAR2,o/
												'BL',								/oP_MODULE_ID		IN VARCHAR2,o/
												NULL,								/o'key',o/
												NULL,								/o'key ln no,o/
												:bl_hdr_episode_type,				/oP_EPISODE_TYPE		IN VARCHAR2,o/
												:bl_hdr_patient_id	,				/oP_PATIENT_ID		IN VARCHAR2,o/
												:bl_hdr_episode_id	,				/oP_EPISODE_ID		IN NUMBER,o/
												NULL				,				/oP_VISIT_ID		IN NUMBER,o/
												:m_encounter_id		,				/oP_ENCOUNTER_ID		IN NUMBER,o/
												:m_cur_acct_seq_no	,				/oP_ACCT_SEQ_NO		IN NUMBER,o/
												TO_DATE(:nd_service_time,'DD/MM/YYYY HH24:MI:SS'),							/oP_SERVICE_DATE		IN DATE,o/
												NULL,
												:m_service_panel_ind,				/oP_SERV_PANEL_IND	IN VARCHAR2,o/
												:bl_line_blng_serv_code	,			/oP_SERV_PANEL_CODE	IN VARCHAR2,o/
												:bl_line_serv_qty,					/oP_SERV_QTY		IN NUMBER,o/
												NULL,                                                   /oP_CHARGE_BASED_AMTo/
												'P'		,							/oP_PRACT_STAFF_IND	IN VARCHAR2,o/
												NULL	,							/oP_PRACT_STAFF_ID	IN VARCHAR2,o/
												:m_str	,							/oP_STR			OUT VARCHAR2,o/
												:m_charge_based_yn	,
												:m_tot_amt ,	
												:m_pat_payable_amt	,
												:m_excl_incl_ind		,
												:m_preapp_yn		,
												:m_excl_incl_action_ind	,
												:m_action_reason_code	,
												:m_pat_paid_amt		,
												:m_charged_yn,							/oP_CHARGED_YN		OUT VARCHAR2,o/
												:m_pat_billed_yn,						/oP_PAT_BILLED_YN		OUT VARCHAR2,o/
												:m_language_id		,
												:m_error_level		,
												:m_sys_message_id	,
												:nd_error_text	) ;


	if :nd_error_code is not null then 
			:nd_error_id := '10';
			:nd_error_text := blcommon.get_error_text(:nd_error_code);		
		    end if;


			END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 27;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin BL_PROC_FOR_EXT_SERVICE_MP . GET_SERV_PANEL_DTLS ( :nd_\
facility_id , 'BL' , NULL , NULL , :bl_hdr_episode_type , :bl_hdr_patient_id ,\
 :bl_hdr_episode_id , NULL , :m_encounter_id , :m_cur_acct_seq_no , TO_DATE ( \
:nd_service_time , 'DD/MM/YYYY HH24:MI:SS' ) , NULL , :m_service_panel_ind , :\
bl_line_blng_serv_code , :bl_line_serv_qty , NULL , 'P' , NULL , :m_str , :m_c\
harge_based_yn , :m_tot_amt , :m_pat_payable_amt , :m_excl_incl_ind , :m_preap\
p_yn , :m_excl_incl_action_ind , :m_action_reason_code , :m_pat_paid_amt , :m_\
charged_yn , :m_pat_billed_yn , :m_language_id , :m_error_level , :m_sys_messa\
ge_id , :nd_error_text ) ; if :nd_error_code is not null then :nd_error_id := \
'10' ; :nd_error_text := blcommon . get_error_text ( :nd_error_code ) ; end if\
 ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )738;
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
sqlstm.sqhstv[1] = (         void  *)&bl_hdr_episode_type;
sqlstm.sqhstl[1] = (unsigned int  )4;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&bl_hdr_patient_id;
sqlstm.sqhstl[2] = (unsigned int  )23;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&bl_hdr_episode_id;
sqlstm.sqhstl[3] = (unsigned int  )11;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&m_encounter_id;
sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&m_cur_acct_seq_no;
sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&nd_service_time;
sqlstm.sqhstl[6] = (unsigned int  )23;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&m_service_panel_ind;
sqlstm.sqhstl[7] = (unsigned int  )4;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&bl_line_blng_serv_code;
sqlstm.sqhstl[8] = (unsigned int  )13;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)&bl_line_serv_qty;
sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[9] = (         int  )0;
sqlstm.sqindv[9] = (         void  *)0;
sqlstm.sqinds[9] = (         int  )0;
sqlstm.sqharm[9] = (unsigned int  )0;
sqlstm.sqadto[9] = (unsigned short )0;
sqlstm.sqtdso[9] = (unsigned short )0;
sqlstm.sqhstv[10] = (         void  *)&m_str;
sqlstm.sqhstl[10] = (unsigned int  )23;
sqlstm.sqhsts[10] = (         int  )0;
sqlstm.sqindv[10] = (         void  *)0;
sqlstm.sqinds[10] = (         int  )0;
sqlstm.sqharm[10] = (unsigned int  )0;
sqlstm.sqadto[10] = (unsigned short )0;
sqlstm.sqtdso[10] = (unsigned short )0;
sqlstm.sqhstv[11] = (         void  *)&m_charge_based_yn;
sqlstm.sqhstl[11] = (unsigned int  )4;
sqlstm.sqhsts[11] = (         int  )0;
sqlstm.sqindv[11] = (         void  *)0;
sqlstm.sqinds[11] = (         int  )0;
sqlstm.sqharm[11] = (unsigned int  )0;
sqlstm.sqadto[11] = (unsigned short )0;
sqlstm.sqtdso[11] = (unsigned short )0;
sqlstm.sqhstv[12] = (         void  *)&m_tot_amt;
sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
sqlstm.sqhsts[12] = (         int  )0;
sqlstm.sqindv[12] = (         void  *)0;
sqlstm.sqinds[12] = (         int  )0;
sqlstm.sqharm[12] = (unsigned int  )0;
sqlstm.sqadto[12] = (unsigned short )0;
sqlstm.sqtdso[12] = (unsigned short )0;
sqlstm.sqhstv[13] = (         void  *)&m_pat_payable_amt;
sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
sqlstm.sqhsts[13] = (         int  )0;
sqlstm.sqindv[13] = (         void  *)0;
sqlstm.sqinds[13] = (         int  )0;
sqlstm.sqharm[13] = (unsigned int  )0;
sqlstm.sqadto[13] = (unsigned short )0;
sqlstm.sqtdso[13] = (unsigned short )0;
sqlstm.sqhstv[14] = (         void  *)&m_excl_incl_ind;
sqlstm.sqhstl[14] = (unsigned int  )4;
sqlstm.sqhsts[14] = (         int  )0;
sqlstm.sqindv[14] = (         void  *)0;
sqlstm.sqinds[14] = (         int  )0;
sqlstm.sqharm[14] = (unsigned int  )0;
sqlstm.sqadto[14] = (unsigned short )0;
sqlstm.sqtdso[14] = (unsigned short )0;
sqlstm.sqhstv[15] = (         void  *)&m_preapp_yn;
sqlstm.sqhstl[15] = (unsigned int  )4;
sqlstm.sqhsts[15] = (         int  )0;
sqlstm.sqindv[15] = (         void  *)0;
sqlstm.sqinds[15] = (         int  )0;
sqlstm.sqharm[15] = (unsigned int  )0;
sqlstm.sqadto[15] = (unsigned short )0;
sqlstm.sqtdso[15] = (unsigned short )0;
sqlstm.sqhstv[16] = (         void  *)&m_excl_incl_action_ind;
sqlstm.sqhstl[16] = (unsigned int  )4;
sqlstm.sqhsts[16] = (         int  )0;
sqlstm.sqindv[16] = (         void  *)0;
sqlstm.sqinds[16] = (         int  )0;
sqlstm.sqharm[16] = (unsigned int  )0;
sqlstm.sqadto[16] = (unsigned short )0;
sqlstm.sqtdso[16] = (unsigned short )0;
sqlstm.sqhstv[17] = (         void  *)&m_action_reason_code;
sqlstm.sqhstl[17] = (unsigned int  )7;
sqlstm.sqhsts[17] = (         int  )0;
sqlstm.sqindv[17] = (         void  *)0;
sqlstm.sqinds[17] = (         int  )0;
sqlstm.sqharm[17] = (unsigned int  )0;
sqlstm.sqadto[17] = (unsigned short )0;
sqlstm.sqtdso[17] = (unsigned short )0;
sqlstm.sqhstv[18] = (         void  *)&m_pat_paid_amt;
sqlstm.sqhstl[18] = (unsigned int  )sizeof(int);
sqlstm.sqhsts[18] = (         int  )0;
sqlstm.sqindv[18] = (         void  *)0;
sqlstm.sqinds[18] = (         int  )0;
sqlstm.sqharm[18] = (unsigned int  )0;
sqlstm.sqadto[18] = (unsigned short )0;
sqlstm.sqtdso[18] = (unsigned short )0;
sqlstm.sqhstv[19] = (         void  *)&m_charged_yn;
sqlstm.sqhstl[19] = (unsigned int  )4;
sqlstm.sqhsts[19] = (         int  )0;
sqlstm.sqindv[19] = (         void  *)0;
sqlstm.sqinds[19] = (         int  )0;
sqlstm.sqharm[19] = (unsigned int  )0;
sqlstm.sqadto[19] = (unsigned short )0;
sqlstm.sqtdso[19] = (unsigned short )0;
sqlstm.sqhstv[20] = (         void  *)&m_pat_billed_yn;
sqlstm.sqhstl[20] = (unsigned int  )4;
sqlstm.sqhsts[20] = (         int  )0;
sqlstm.sqindv[20] = (         void  *)0;
sqlstm.sqinds[20] = (         int  )0;
sqlstm.sqharm[20] = (unsigned int  )0;
sqlstm.sqadto[20] = (unsigned short )0;
sqlstm.sqtdso[20] = (unsigned short )0;
sqlstm.sqhstv[21] = (         void  *)&m_language_id;
sqlstm.sqhstl[21] = (unsigned int  )5;
sqlstm.sqhsts[21] = (         int  )0;
sqlstm.sqindv[21] = (         void  *)0;
sqlstm.sqinds[21] = (         int  )0;
sqlstm.sqharm[21] = (unsigned int  )0;
sqlstm.sqadto[21] = (unsigned short )0;
sqlstm.sqtdso[21] = (unsigned short )0;
sqlstm.sqhstv[22] = (         void  *)&m_error_level;
sqlstm.sqhstl[22] = (unsigned int  )12;
sqlstm.sqhsts[22] = (         int  )0;
sqlstm.sqindv[22] = (         void  *)0;
sqlstm.sqinds[22] = (         int  )0;
sqlstm.sqharm[22] = (unsigned int  )0;
sqlstm.sqadto[22] = (unsigned short )0;
sqlstm.sqtdso[22] = (unsigned short )0;
sqlstm.sqhstv[23] = (         void  *)&m_sys_message_id;
sqlstm.sqhstl[23] = (unsigned int  )23;
sqlstm.sqhsts[23] = (         int  )0;
sqlstm.sqindv[23] = (         void  *)0;
sqlstm.sqinds[23] = (         int  )0;
sqlstm.sqharm[23] = (unsigned int  )0;
sqlstm.sqadto[23] = (unsigned short )0;
sqlstm.sqtdso[23] = (unsigned short )0;
sqlstm.sqhstv[24] = (         void  *)&nd_error_text;
sqlstm.sqhstl[24] = (unsigned int  )102;
sqlstm.sqhsts[24] = (         int  )0;
sqlstm.sqindv[24] = (         void  *)0;
sqlstm.sqinds[24] = (         int  )0;
sqlstm.sqharm[24] = (unsigned int  )0;
sqlstm.sqadto[24] = (unsigned short )0;
sqlstm.sqtdso[24] = (unsigned short )0;
sqlstm.sqhstv[25] = (         void  *)&nd_error_code;
sqlstm.sqhstl[25] = (unsigned int  )13;
sqlstm.sqhsts[25] = (         int  )0;
sqlstm.sqindv[25] = (         void  *)0;
sqlstm.sqinds[25] = (         int  )0;
sqlstm.sqharm[25] = (unsigned int  )0;
sqlstm.sqadto[25] = (unsigned short )0;
sqlstm.sqtdso[25] = (unsigned short )0;
sqlstm.sqhstv[26] = (         void  *)&nd_error_id;
sqlstm.sqhstl[26] = (unsigned int  )12;
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



	 if (nd_error_text.arr[0] && strcmp(nd_error_code.arr,"10") == 0 )
	    err_mesg(nd_error_text.arr,0,"");	



}
/*disp_message(ERR_MESG,"Fetched the string");

disp_message(ERR_MESG,m_str.arr);*/


/* EXEC SQL EXECUTE    
BEGIN
BL_PROC_FOR_EXT_SERVICE_MP.POPULATE_INTERFACED_RECS
					('DCF',
					:nd_facility_id,        /oChangedo/
					:bl_hdr_episode_type,   /oChangedo/
					:bl_hdr_patient_id,     /oChangedo/
					:bl_hdr_episode_id,     /oChangedo/
					NULL,                     /oP_TRN_SRL_NO,o/
					:m_encounter_id,         /o Not defined o/
					:m_cur_acct_seq_no,       /oNot defined o/ 
					NULL,
					NULL,
					'BL',
					:patfolio_trx_doc_ref,
					:l_trx_doc_ref_line_num,             /o Hard coded line No for increment o/
					:m_service_panel_ind,                 /o NVL(P_RDNG_SERVICE_PANEL_IND,'S') o/
					:bl_line_blng_serv_code,             /o P_RDNG_BLNG_SERV_CODE o/
					'DCF',
					NULL,
					NULL,
					:bl_line_serv_qty,
					:bl_line_charge_amt,
					:bl_adt_to_physician_id,    /o P_PHYSICIAN_ID Taken from FETCH_BED_BLNG_SERV o/
					TO_DATE(:nd_service_time,'DD/MM/YYYY HH24:MI:SS'),                     /o L_SERV_DATE, Last Bed time or Admsn Time o/
					NULL,
					:m_uom_code,                 /o P_UOM_CODE o/
					'P',
					NULL,
					NULL,
					:nd_user,
					:nd_ws_no,
					'N',
					'N',
					'RECURRING CHARGES',       /oP_FOLIO_REMARKSo/
					'S',
					'R',
					NULL,
					NULL,
					NULL,
					NULL,
					:nd_error_code,             /oP_ERROR_LEVEL,o/
					:nd_error_id,               /oP_SYS_MESSAGE_ID,o/
					:nd_error_text              /oP_ERROR_TEXTo/
					);
			if :nd_error_code is not null then 
			:nd_error_id := '10';
			:nd_error_text := blcommon.get_error_text(:nd_error_code);		
		    end if;


			END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 27;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin BL_PROC_FOR_EXT_SERVICE_MP . POPULATE_INTERFACED_RECS (\
 'DCF' , :nd_facility_id , :bl_hdr_episode_type , :bl_hdr_patient_id , :bl_hdr\
_episode_id , NULL , :m_encounter_id , :m_cur_acct_seq_no , NULL , NULL , 'BL'\
 , :patfolio_trx_doc_ref , :l_trx_doc_ref_line_num , :m_service_panel_ind , :b\
l_line_blng_serv_code , 'DCF' , NULL , NULL , :bl_line_serv_qty , :bl_line_cha\
rge_amt , :bl_adt_to_physician_id , TO_DATE ( :nd_service_time , 'DD/MM/YYYY H\
H24:MI:SS' ) , NULL , :m_uom_code , 'P' , NULL , NULL , :nd_user , :nd_ws_no ,\
 'N' , 'N' , 'RECURRING CHARGES' , 'S' , 'R' , NULL , NULL , NULL , NULL , :nd\
_error_code , :nd_error_id , :nd_error_text ) ; if :nd_error_code is not null \
then :nd_error_id := '10' ; :nd_error_text := blcommon . get_error_text ( :nd_\
error_code ) ; end if ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )861;
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
sqlstm.sqhstv[1] = (         void  *)&bl_hdr_episode_type;
sqlstm.sqhstl[1] = (unsigned int  )4;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&bl_hdr_patient_id;
sqlstm.sqhstl[2] = (unsigned int  )23;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&bl_hdr_episode_id;
sqlstm.sqhstl[3] = (unsigned int  )11;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&m_encounter_id;
sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&m_cur_acct_seq_no;
sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&patfolio_trx_doc_ref;
sqlstm.sqhstl[6] = (unsigned int  )23;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&l_trx_doc_ref_line_num;
sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&m_service_panel_ind;
sqlstm.sqhstl[8] = (unsigned int  )4;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)&bl_line_blng_serv_code;
sqlstm.sqhstl[9] = (unsigned int  )13;
sqlstm.sqhsts[9] = (         int  )0;
sqlstm.sqindv[9] = (         void  *)0;
sqlstm.sqinds[9] = (         int  )0;
sqlstm.sqharm[9] = (unsigned int  )0;
sqlstm.sqadto[9] = (unsigned short )0;
sqlstm.sqtdso[9] = (unsigned short )0;
sqlstm.sqhstv[10] = (         void  *)&bl_line_serv_qty;
sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[10] = (         int  )0;
sqlstm.sqindv[10] = (         void  *)0;
sqlstm.sqinds[10] = (         int  )0;
sqlstm.sqharm[10] = (unsigned int  )0;
sqlstm.sqadto[10] = (unsigned short )0;
sqlstm.sqtdso[10] = (unsigned short )0;
sqlstm.sqhstv[11] = (         void  *)&bl_line_charge_amt;
sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
sqlstm.sqhsts[11] = (         int  )0;
sqlstm.sqindv[11] = (         void  *)0;
sqlstm.sqinds[11] = (         int  )0;
sqlstm.sqharm[11] = (unsigned int  )0;
sqlstm.sqadto[11] = (unsigned short )0;
sqlstm.sqtdso[11] = (unsigned short )0;
sqlstm.sqhstv[12] = (         void  *)&bl_adt_to_physician_id;
sqlstm.sqhstl[12] = (unsigned int  )18;
sqlstm.sqhsts[12] = (         int  )0;
sqlstm.sqindv[12] = (         void  *)0;
sqlstm.sqinds[12] = (         int  )0;
sqlstm.sqharm[12] = (unsigned int  )0;
sqlstm.sqadto[12] = (unsigned short )0;
sqlstm.sqtdso[12] = (unsigned short )0;
sqlstm.sqhstv[13] = (         void  *)&nd_service_time;
sqlstm.sqhstl[13] = (unsigned int  )23;
sqlstm.sqhsts[13] = (         int  )0;
sqlstm.sqindv[13] = (         void  *)0;
sqlstm.sqinds[13] = (         int  )0;
sqlstm.sqharm[13] = (unsigned int  )0;
sqlstm.sqadto[13] = (unsigned short )0;
sqlstm.sqtdso[13] = (unsigned short )0;
sqlstm.sqhstv[14] = (         void  *)&m_uom_code;
sqlstm.sqhstl[14] = (unsigned int  )7;
sqlstm.sqhsts[14] = (         int  )0;
sqlstm.sqindv[14] = (         void  *)0;
sqlstm.sqinds[14] = (         int  )0;
sqlstm.sqharm[14] = (unsigned int  )0;
sqlstm.sqadto[14] = (unsigned short )0;
sqlstm.sqtdso[14] = (unsigned short )0;
sqlstm.sqhstv[15] = (         void  *)&nd_user;
sqlstm.sqhstl[15] = (unsigned int  )33;
sqlstm.sqhsts[15] = (         int  )0;
sqlstm.sqindv[15] = (         void  *)0;
sqlstm.sqinds[15] = (         int  )0;
sqlstm.sqharm[15] = (unsigned int  )0;
sqlstm.sqadto[15] = (unsigned short )0;
sqlstm.sqtdso[15] = (unsigned short )0;
sqlstm.sqhstv[16] = (         void  *)&nd_ws_no;
sqlstm.sqhstl[16] = (unsigned int  )33;
sqlstm.sqhsts[16] = (         int  )0;
sqlstm.sqindv[16] = (         void  *)0;
sqlstm.sqinds[16] = (         int  )0;
sqlstm.sqharm[16] = (unsigned int  )0;
sqlstm.sqadto[16] = (unsigned short )0;
sqlstm.sqtdso[16] = (unsigned short )0;
sqlstm.sqhstv[17] = (         void  *)&nd_error_code;
sqlstm.sqhstl[17] = (unsigned int  )13;
sqlstm.sqhsts[17] = (         int  )0;
sqlstm.sqindv[17] = (         void  *)0;
sqlstm.sqinds[17] = (         int  )0;
sqlstm.sqharm[17] = (unsigned int  )0;
sqlstm.sqadto[17] = (unsigned short )0;
sqlstm.sqtdso[17] = (unsigned short )0;
sqlstm.sqhstv[18] = (         void  *)&nd_error_id;
sqlstm.sqhstl[18] = (unsigned int  )12;
sqlstm.sqhsts[18] = (         int  )0;
sqlstm.sqindv[18] = (         void  *)0;
sqlstm.sqinds[18] = (         int  )0;
sqlstm.sqharm[18] = (unsigned int  )0;
sqlstm.sqadto[18] = (unsigned short )0;
sqlstm.sqtdso[18] = (unsigned short )0;
sqlstm.sqhstv[19] = (         void  *)&nd_error_text;
sqlstm.sqhstl[19] = (unsigned int  )102;
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



	 if (nd_error_text.arr[0] && strcmp(nd_error_id.arr,"10") == 0 )
	    err_mesg(nd_error_text.arr,0,"");	



//disp_message(ERR_MESG,"PROCESSED........");

	if (nd_error_text.arr[0])
	err_mesg(nd_error_text.arr,0,"");

/*	disp_message(ERR_MESG,"Starting PROCESS_INTERFACED_REC........");
disp_message(ERR_MESG,"Before displng variable values........");
disp_message(ERR_MESG,nd_facility_id.arr);
disp_message(ERR_MESG,bl_hdr_patient_id.arr);
disp_message(ERR_MESG,bl_hdr_episode_type.arr);
disp_message(ERR_MESG,bl_hdr_episode_id.arr);
disp_message(ERR_MESG,patfolio_trx_doc_ref.arr);
disp_message(ERR_MESG,nd_user.arr);
disp_message(ERR_MESG,nd_ws_no.arr);
disp_message(ERR_MESG,"After displng variable values........");*/


nd_error_code.arr[0] = '\0';
nd_error_id.arr[0] = '\0';
nd_error_text.arr[0] = '\0';


nd_error_code.len = 0;
nd_error_id.len = 0;
nd_error_text.len = 0;


/* EXEC SQL EXECUTE   
BEGIN

BL_PROC_FOR_EXT_SERVICE_MP.PROCESS_INTERFACED_REC
     (
			:nd_facility_id     ,		/op_facility_id		in varchar2,o/
			:bl_hdr_patient_id	,		/op_patient_id		in varchar2,o/
			:bl_hdr_episode_type,		/op_episode_type		in varchar2,o/
			:bl_hdr_episode_id  ,		/op_episode_id		in number,o/
			NULL				,		/op_visit_id		in number,o/
			NULL	,	                /op_order_id		in varchar2,o/
			'BL'				,		/op_subs_module_id	in varchar2,o/
			:patfolio_trx_doc_ref,		/op_subs_regn_num		in varchar2,o/
			:nd_user,
			:nd_ws_no			,		/op_ws_no			in varchar2,o/
			:nd_error_code,      /oP_ERROR_LEVEL,o/
			:nd_error_id		,      /oP_SYS_MESSAGE_ID,o/
			:nd_error_text      );	   /oP_ERROR_TEXTo/

			if :nd_error_code is not null then 
			:nd_error_id := '10';
			:nd_error_text := blcommon.get_error_text(:nd_error_code);		
		    end if;


			END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 27;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin BL_PROC_FOR_EXT_SERVICE_MP . PROCESS_INTERFACED_REC ( :\
nd_facility_id , :bl_hdr_patient_id , :bl_hdr_episode_type , :bl_hdr_episode_i\
d , NULL , NULL , 'BL' , :patfolio_trx_doc_ref , :nd_user , :nd_ws_no , :nd_er\
ror_code , :nd_error_id , :nd_error_text ) ; if :nd_error_code is not null the\
n :nd_error_id := '10' ; :nd_error_text := blcommon . get_error_text ( :nd_err\
or_code ) ; end if ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )956;
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
sqlstm.sqhstv[1] = (         void  *)&bl_hdr_patient_id;
sqlstm.sqhstl[1] = (unsigned int  )23;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&bl_hdr_episode_type;
sqlstm.sqhstl[2] = (unsigned int  )4;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&bl_hdr_episode_id;
sqlstm.sqhstl[3] = (unsigned int  )11;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&patfolio_trx_doc_ref;
sqlstm.sqhstl[4] = (unsigned int  )23;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&nd_user;
sqlstm.sqhstl[5] = (unsigned int  )33;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&nd_ws_no;
sqlstm.sqhstl[6] = (unsigned int  )33;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&nd_error_code;
sqlstm.sqhstl[7] = (unsigned int  )13;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&nd_error_id;
sqlstm.sqhstl[8] = (unsigned int  )12;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)&nd_error_text;
sqlstm.sqhstl[9] = (unsigned int  )102;
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



	 if (nd_error_text.arr[0] && strcmp(nd_error_code.arr,"10") == 0 )
	   { 
		disp_message(ERR_MESG,nd_error_code.arr);	
		disp_message(ERR_MESG,nd_error_text.arr);	}

}

