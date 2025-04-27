
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00084.PC"
};


static unsigned int sqlctx = 1288460987;


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
            void  *sqhstv[23];
   unsigned int   sqhstl[23];
            int   sqhsts[23];
            void  *sqindv[23];
            int   sqinds[23];
   unsigned int   sqharm[23];
   unsigned int   *sqharc[23];
   unsigned short  sqadto[23];
   unsigned short  sqtdso[23];
} sqlstm = {12,23};

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
"HAR(SYSDATE,'YYYY') TRXYER ,TO_CHAR(SYSDATE,'MON-YYYY') ORGMTH ,TO_CHAR(SYSD\
ATE,'YYYY') ORGYER ,'N'  from bl_blng_grp_catg a ,ip_bed_class b where :b0='DI\
' union all select a.blng_grp_catg ,b.clinic_code ,'O' ,'0' ,'0' ,'~~~' ,0 ,'~\
~~' ,SYSDATE ,SYSDATE ,SYSDATE ,'~~~' ,'~~~' ,0 ,0 ,'~~~' ,TO_CHAR(SYSDATE,'MO\
N-YYYY') MTH ,TO_CHAR(SYSDATE,'YYYY') YER ,TO_CHAR(SYSDATE,'MON-YYYY') TRXMTH \
,TO_CHAR(SYSDATE,'YYYY') TRXYER ,TO_CHAR(SYSDATE,'MON-YYYY') ORGMTH ,TO_CHAR(S\
YSDATE,'YYYY') ORGYER ,'N'  from bl_blng_grp_catg a ,op_clinic_his_vw b where \
:b0='EM' order by 1,2,3,4,5,6,7,8            ";

 static const char *sq0011 = 
"code(:b0,'DI','D','EM','E','R'))) and B.document_nature in ('BI','DC')) and \
TRX_NATURE_CODE not  in (DECODE(:b7,'Y','AD','XX'),DECODE(:b7,'Y','PR','XX')))\
 and B.TRX_TYPE not  in (DECODE(:b9,'Y','REFUND','XX'),DECODE(:b9,'Y','CANC-RE\
FUND','XX'))) and ((nvL(:b11,'Y')='Y' and NVL(BILL_TOT_ADJUST_AMT,0)=0) or NVL\
(:b11,'Y')='N')) and ((NVL(:b13,'Y')='Y' and NVL(BILL_TOT_EXEMPT_AMT,0)=0) or \
NVL(:b13,'Y')='N')) and ((NVL(:b15,'Y')='Y' and NVL(BILL_TOT_WRITE_OFF_AMT,0)=\
0) or NVL(:b15,'Y')='N')) order by 1,2,3,4,5,6,7,8            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,298,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,340,0,4,339,0,0,16,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
115,0,0,3,91,0,2,382,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
138,0,0,4,81,0,4,2140,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
161,0,0,5,104,0,4,2145,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
188,0,0,6,204,0,3,2221,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,3,0,0,1,4,0,0,1,3,0,0,1,4,0,0,1,3,0,0,1,3,0,0,1,4,0,0,1,4,0,0,
255,0,0,7,0,0,29,2245,0,0,0,0,0,1,0,
270,0,0,8,338,0,3,2349,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,4,0,0,1,3,0,0,1,4,0,0,1,3,0,0,1,4,0,0,1,3,0,
0,1,4,0,0,1,3,0,0,1,4,0,0,1,3,0,0,1,4,0,0,
365,0,0,9,0,0,29,2389,0,0,0,0,0,1,0,
380,0,0,10,2637,0,9,2642,0,0,19,19,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
471,0,0,11,1552,0,9,2650,0,0,17,17,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,
554,0,0,10,0,0,15,2658,0,0,0,0,0,1,0,
569,0,0,11,0,0,15,2664,0,0,0,0,0,1,0,
584,0,0,10,0,0,13,2709,0,0,23,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
691,0,0,11,0,0,13,2793,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,
0,2,9,0,0,2,9,0,0,
774,0,0,12,98,0,4,2841,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
797,0,0,13,98,0,4,2860,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
820,0,0,14,162,0,4,2883,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
855,0,0,15,0,0,32,2899,0,0,0,0,0,1,0,
870,0,0,16,96,0,4,3087,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
893,0,0,17,162,0,6,3094,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00084.PC                                  */
/* AUTHOR                : Robert Joseph                               */  
/* DATE WRITTEN          : 07/05/2005                                   */      
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
#define NODATAFOUND sqlca.sqlcode == 1403
#define OERROR          (sqlca.sqlcode < 0)
#define MAX_LINES 42
#define REP_WIDTH 156
//#define VER  "VER : 4.10\n"
#define ESC  0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 



/* VARCHAR     hosp_name           [120],
	        date			    [20],
            date_time           [20],
			d_acc_entity_name	[61],
			d_user			    [31],
			d_sysdate			[20],
			d_curr_date			[20],
			nd_facility_id		[3],
	        user_id             [91],
		    nd_pwd 			    [91],
            nd_session_id       [16],
            nd_pgm_date         [25],
            d_curr_pgm_name     [15],
			nd_facility			[3],
			l_translated_value	[201],
			p_language_id		[3],
			l_pk_value			[100]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[61]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate;

struct { unsigned short len; unsigned char arr[20]; } d_curr_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;



/* VARCHAR	    nd_month_year		    [9],
			nd_det_option		    [3],
		    nd_sum_option		    [3],
			nd_year				    [5],
			nd_break_up				[2],
			nd_excl_dep				[2],
			nd_excl_ref				[2],
			nd_inc_exadwo			[2],
			nd_pg_month				[30],
			nd_exc_adj              [2],
			nd_exc_exmp				[2],
			nd_exc_writeoff			[2]; */ 
struct { unsigned short len; unsigned char arr[9]; } nd_month_year;

struct { unsigned short len; unsigned char arr[3]; } nd_det_option;

struct { unsigned short len; unsigned char arr[3]; } nd_sum_option;

struct { unsigned short len; unsigned char arr[5]; } nd_year;

struct { unsigned short len; unsigned char arr[2]; } nd_break_up;

struct { unsigned short len; unsigned char arr[2]; } nd_excl_dep;

struct { unsigned short len; unsigned char arr[2]; } nd_excl_ref;

struct { unsigned short len; unsigned char arr[2]; } nd_inc_exadwo;

struct { unsigned short len; unsigned char arr[30]; } nd_pg_month;

struct { unsigned short len; unsigned char arr[2]; } nd_exc_adj;

struct { unsigned short len; unsigned char arr[2]; } nd_exc_exmp;

struct { unsigned short len; unsigned char arr[2]; } nd_exc_writeoff;



/* VARCHAR		d_blng_grp_catg		[5],
			trx_nature_code     [3],
			d_patient_id		[21],
			d_doc_type_code		[7],
			d_doc_date			[16],
			d_trx_type			[14],
			d_episode_type		[2],
			d_bed_clinic_code	[8],
			nd_bed_clinic_code  [8],
			d_clinic_code		[5],
			nd_clinic_code      [5],
			d_adj_date			[16],
			d_bill_date		    [16],
			d_bill_year			[5],
			d_bill_mth			[9],
			d_trx_year			[5],
			d_trx_mth			[9],
			d_org_year			[5],
			d_org_mth			[9],
			d_episode_id		[9],
			d_valid_for_out		[2],
			nd1_episode_id		[9],
			nd2_episode_id		[9],
			nd_episode_id		[9],
			ndr_episode_id		[9],
		    ndo_episode_id		[9],
			ndcly_episode_id	[9],
			ndcyr_episode_id	[9],
			ndrpc_episode_id	[9],
			ndadj_episode_id	[9],
			ndbr_episode_id		[9],
			ndpm_episode_id		[9],
			ndlyr_episode_id	[9],
			ndawe_episode_id	[9],
			ndb_episode_id		[9],
			ndc_episode_id		[9],
			ndlc_episode_id		[9],
			d_visit_id          [5],
			nd_visit_id         [5],
			ndr_visit_id        [5],
			ndcyr_visit_id      [5],
			ndrpc_visit_id		[5],
			ndbr_visit_id		[5],
			ndlyr_visit_id      [5],
			ndadj_visit_id	    [5],
			ndpm_visit_id       [5],
			ndcly_visit_id      [5],
			nd1_visit_id        [5],
		    nd2_visit_id        [5],
            ndb_visit_id        [5],
			ndlc_visit_id		[5],
            ndawe_visit_id      [5],
			nd1_patient_id		[21],
			nd2_patient_id		[21],
			nd_patient_id		[21],
			ndr_patient_id		[21],
			ndcly_patient_id	[21],
			ndcyr_patient_id	[21],
			ndrpc_patient_id	[21],
			ndadj_patient_id	[21],
			ndbr_patient_id		[21],
			ndpm_patient_id		[21],
			ndlyr_patient_id	[21],
			ndawe_patient_id	[21],
			ndb_patient_id		[21],
			ndlc_patient_id		[21],
			d_national			[10]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_catg;

struct { unsigned short len; unsigned char arr[3]; } trx_nature_code;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_doc_date;

struct { unsigned short len; unsigned char arr[14]; } d_trx_type;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[8]; } d_bed_clinic_code;

struct { unsigned short len; unsigned char arr[8]; } nd_bed_clinic_code;

struct { unsigned short len; unsigned char arr[5]; } d_clinic_code;

struct { unsigned short len; unsigned char arr[5]; } nd_clinic_code;

struct { unsigned short len; unsigned char arr[16]; } d_adj_date;

struct { unsigned short len; unsigned char arr[16]; } d_bill_date;

struct { unsigned short len; unsigned char arr[5]; } d_bill_year;

struct { unsigned short len; unsigned char arr[9]; } d_bill_mth;

struct { unsigned short len; unsigned char arr[5]; } d_trx_year;

struct { unsigned short len; unsigned char arr[9]; } d_trx_mth;

struct { unsigned short len; unsigned char arr[5]; } d_org_year;

struct { unsigned short len; unsigned char arr[9]; } d_org_mth;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[2]; } d_valid_for_out;

struct { unsigned short len; unsigned char arr[9]; } nd1_episode_id;

struct { unsigned short len; unsigned char arr[9]; } nd2_episode_id;

struct { unsigned short len; unsigned char arr[9]; } nd_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndr_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndo_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndcly_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndcyr_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndrpc_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndadj_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndbr_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndpm_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndlyr_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndawe_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndb_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndc_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndlc_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[5]; } nd_visit_id;

struct { unsigned short len; unsigned char arr[5]; } ndr_visit_id;

struct { unsigned short len; unsigned char arr[5]; } ndcyr_visit_id;

struct { unsigned short len; unsigned char arr[5]; } ndrpc_visit_id;

struct { unsigned short len; unsigned char arr[5]; } ndbr_visit_id;

struct { unsigned short len; unsigned char arr[5]; } ndlyr_visit_id;

struct { unsigned short len; unsigned char arr[5]; } ndadj_visit_id;

struct { unsigned short len; unsigned char arr[5]; } ndpm_visit_id;

struct { unsigned short len; unsigned char arr[5]; } ndcly_visit_id;

struct { unsigned short len; unsigned char arr[5]; } nd1_visit_id;

struct { unsigned short len; unsigned char arr[5]; } nd2_visit_id;

struct { unsigned short len; unsigned char arr[5]; } ndb_visit_id;

struct { unsigned short len; unsigned char arr[5]; } ndlc_visit_id;

struct { unsigned short len; unsigned char arr[5]; } ndawe_visit_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[21]; } ndr_patient_id;

struct { unsigned short len; unsigned char arr[21]; } ndcly_patient_id;

struct { unsigned short len; unsigned char arr[21]; } ndcyr_patient_id;

struct { unsigned short len; unsigned char arr[21]; } ndrpc_patient_id;

struct { unsigned short len; unsigned char arr[21]; } ndadj_patient_id;

struct { unsigned short len; unsigned char arr[21]; } ndbr_patient_id;

struct { unsigned short len; unsigned char arr[21]; } ndpm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } ndlyr_patient_id;

struct { unsigned short len; unsigned char arr[21]; } ndawe_patient_id;

struct { unsigned short len; unsigned char arr[21]; } ndb_patient_id;

struct { unsigned short len; unsigned char arr[21]; } ndlc_patient_id;

struct { unsigned short len; unsigned char arr[10]; } d_national;


/* VARCHAR		d_sum_blng_grp_catg		[5],
			d_sum_bed_clinic_code	[8],
			d_sum_episode_type		[2],
			d_sum_episode_id		[9],
			ndo_sum_episode_id		[9],
			ndc_sum_episode_id		[9],
			d_sum_visit_id			[5],
			d_sum_doc_type_code		[7],
			d_sum_trx_type	        [14],
			d_sum_doc_date			[16],
			d_sum_adj_date			[16],
			d_sum_bill_date			[16],
			d_sum_patient_id		[21],
			d_sum_national			[10],
			trx_sum_nature_code	    [3],	
			d_sum_valid_for_out   [2]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_sum_blng_grp_catg;

struct { unsigned short len; unsigned char arr[8]; } d_sum_bed_clinic_code;

struct { unsigned short len; unsigned char arr[2]; } d_sum_episode_type;

struct { unsigned short len; unsigned char arr[9]; } d_sum_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndo_sum_episode_id;

struct { unsigned short len; unsigned char arr[9]; } ndc_sum_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_sum_visit_id;

struct { unsigned short len; unsigned char arr[7]; } d_sum_doc_type_code;

struct { unsigned short len; unsigned char arr[14]; } d_sum_trx_type;

struct { unsigned short len; unsigned char arr[16]; } d_sum_doc_date;

struct { unsigned short len; unsigned char arr[16]; } d_sum_adj_date;

struct { unsigned short len; unsigned char arr[16]; } d_sum_bill_date;

struct { unsigned short len; unsigned char arr[21]; } d_sum_patient_id;

struct { unsigned short len; unsigned char arr[10]; } d_sum_national;

struct { unsigned short len; unsigned char arr[3]; } trx_sum_nature_code;

struct { unsigned short len; unsigned char arr[2]; } d_sum_valid_for_out;




/* VARCHAR         nd_blng_grp_catg	[5],
				nd1_blng_grp_catg	[5],
                nd_bed_class_code	[3],
				bed_clin_desc		[16],
				d_bed_clin_desc		[16],
				nd_description      [31],
				d_description       [31]; */ 
struct { unsigned short len; unsigned char arr[5]; } nd_blng_grp_catg;

struct { unsigned short len; unsigned char arr[5]; } nd1_blng_grp_catg;

struct { unsigned short len; unsigned char arr[3]; } nd_bed_class_code;

struct { unsigned short len; unsigned char arr[16]; } bed_clin_desc;

struct { unsigned short len; unsigned char arr[16]; } d_bed_clin_desc;

struct { unsigned short len; unsigned char arr[31]; } nd_description;

struct { unsigned short len; unsigned char arr[31]; } d_description;



int d_doc_num,d_sum_doc_num;


int i,lctr=0,page_no=0,print_blflag=0;
int	d_doc_num;

int prn_bl_ind=0,l_count=0,lc_count =0;

int	cur_mth_bill_cnt=0,
	cur_mth_bill_canc_cnt=0,
	cur_mth_bill_rec_cnt=0,
	cur_mth_bill_outcnt=0,
	prev_rec_cur_can_cnt=0,
	prev_mth_curyr_out_cnt=0,
	cmth_rec_cyr_pmth_bl_cnt=0,
	curyr_prev_mth_rec_canc_curmth_cnt=0,
	lastyr_bill_rec_curmth_cnt=0,
	lastyr_rec_canc_curmth_cnt=0,
	adj_wrt_exm_cnt=0,
	sum_no_enctr_cnt=0,
	sum_ot_enctr_cnt=0;


double  d_bill_amt,d_outst_amt,d_bill_tot_amt,d_debit_amt,d_credit_amt;

double d_sum_bill_tot_amt,d_sum_outst_amt;

double  cur_mth_bill_amt=0,
		cur_mth_bill_canc_amt=0,
		cur_mth_bill_rec_amt=0,
		cur_mth_bill_outamt=0,
		prev_rec_cur_can_amt=0,
		prev_mth_curyr_out_amt=0,
		curmth_rec_for_curyr_prevmth_bill=0,
		curyr_prev_mth_rec_canc_curmth=0,
		lastyr_bill_rec_curmth_amt=0,
		lastyr_rec_canc_curmth_amt=0,
		prev_mth_curyr_out_cntamt=0,
		cmth_rec_cyr_pmth_bl_cntamt=0,
		curyr_prev_mth_rec_canc_curmth_cntamt=0,
		lastyr_bill_rec_curmth_cntamt=0,
		lastyr_rec_canc_curmth_cntamt=0,
		prev_rec_cur_can_cntamt=0,
		cur_mth_bill_out_cntamt=0,
		adj_wrt_exm_cntamt=0,
		cur_mth_bill_rec_cntamt=0,
		cur_mth_bill_canc_cntamt=0,
		cur_mth_bill_cntamt=0,
		adj_wrt_exm_amt=0,
		sum_no_enctr_amt=0,
		sum_ot_enctr_amt=0;

char string_var[100];

int tot_cur_mth_bill_cnt=0,
	tot_cur_mth_bill_canc_cnt=0,
	tot_cur_mth_bill_rec_cnt=0,
	tot_prev_rec_cur_can_cnt=0,
	tot_adj_wrt_exm_cnt=0,
	tot_cur_mth_bill_outcnt=0,
	tot_prev_mth_curyr_out_cnt=0,
	tot_cmth_rec_cyr_pmth_bl_cnt=0,
	tot_curyr_prev_mth_rec_canc_curmth_cnt=0,
	tot_lastyr_bill_rec_curmth_cnt=0,
	tot_lastyr_rec_canc_curmth_cnt=0;




double   tot_cur_mth_bill_amt=0,
	tot_cur_mth_bill_canc_amt=0,
	tot_cur_mth_bill_rec_amt=0,
	tot_prev_rec_cur_can_amt=0,
	tot_adj_wrt_exm_amt=0,
	tot_cur_mth_bill_outamt=0,
	tot_prev_mth_curyr_out_amt=0,
	tot_curmth_rec_for_curyr_prevmth_bill=0,
	tot_curyr_prev_mth_rec_canc_curmth=0,
	tot_lastyr_bill_rec_curmth_amt=0,
	tot_lastyr_rec_canc_curmth_amt=0;

int gd_tot_cur_mth_bill_cnt=0,
	gd_tot_cur_mth_bill_canc_cnt=0,
	gd_tot_cur_mth_bill_rec_cnt=0,
	gd_tot_prev_rec_cur_can_cnt=0,
	gd_tot_adj_wrt_exm_cnt=0,
	gd_tot_cur_mth_bill_outcnt=0,
	gd_tot_prev_mth_curyr_out_cnt=0,
	gd_tot_cmth_rec_cyr_pmth_bl_cnt=0,
	gd_tot_curyr_prev_mth_rec_canc_curmth_cnt=0,
	gd_tot_lastyr_bill_rec_curmth_cnt=0,
	gd_tot_lastyr_rec_canc_curmth_cnt=0;

	
double   gd_tot_cur_mth_bill_amt=0,
		 gd_tot_cur_mth_bill_canc_amt=0,
		 gd_tot_cur_mth_bill_rec_amt=0,
		 gd_tot_prev_rec_cur_can_amt=0,
		 gd_tot_adj_wrt_exm_amt=0,
		 gd_tot_cur_mth_bill_outamt=0,
		 gd_tot_prev_mth_curyr_out_amt=0,
		 gd_tot_curmth_rec_for_curyr_prevmth_bill=0,
		 gd_tot_curyr_prev_mth_rec_canc_curmth=0,
		 gd_tot_lastyr_bill_rec_curmth_amt=0,
		 gd_tot_lastyr_rec_canc_curmth_amt=0;

char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[200];
char fm_date[11],to_date[11];
 char nd_proc_yn;
int cnt=0,rcnt=0,dcnt=0,lstrcnt=0,ndpm_ind=0,bcnt=0,ccnt=0 ,brcnt=0,adjcnt=0,rpcnt=0,cpcnt=0,crcmcnt=0,lstcnt=0;

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
//#include <DyWinInit.h>

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
 
    strcpy(g_pgm_id,"BLR00084");
    strcpy(nd_pwd.arr,argv[1]);
    nd_pwd.len = strlen(nd_pwd.arr);

    /* EXEC sql connect :nd_pwd; */ 

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
    sqlstm.sqlcmax = (unsigned int )100;
    sqlstm.sqlcmin = (unsigned int )2;
    sqlstm.sqlcincr = (unsigned int )1;
    sqlstm.sqlctimeout = (unsigned int )0;
    sqlstm.sqlcnowait = (unsigned int )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


  
	  
    if (sqlca.sqlcode < 0 )
	{
        disp_message(ORA_MESG,"Error in connecting to Oracle");
        proc_exit();
        }

		set_meduser_role(); 

		strcpy(p_language_id.arr,l_language_id.arr);

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
      
	    nd_month_year.arr[0]	     = '\0';				
        nd_det_option.arr[0]		 = '\0';			
	    nd_sum_option.arr[0]		 = '\0';					
		nd_year.arr[0]				 = '\0';
        nd_break_up.arr[0]			 = '\0';
        nd_excl_dep.arr[0]			 = '\0';
        nd_excl_ref.arr[0]			 = '\0';
        nd_inc_exadwo.arr[0]	     = '\0';
		nd_pg_month.arr[0]			 = '\0';
		nd_exc_exmp.arr[0]			 = '\0';
		nd_exc_writeoff.arr[0]		 = '\0';
		nd_exc_adj.arr[0]			 = '\0';

        /* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,to_char(to_date(PARAM1,'MON-YYYY'),'YYYY'),
		          PARAM4,PARAM5,PARAM6,PARAM7,to_char(to_date(PARAM1,'MON-YYYY'),'fmMonth YYYY'),
				  PARAM8,PARAM9,PARAM10,nvl(PARAM11,'C')
		              INTO 
					:nd_month_year,
				    :nd_det_option,
				    :nd_sum_option,
				    :nd_year,
					:nd_break_up,
					:nd_excl_dep,
					:nd_excl_ref,
					:nd_inc_exadwo,
					:nd_pg_month, 
					:nd_exc_adj,
					:nd_exc_exmp,
					:nd_exc_writeoff,:nd_proc_yn
			    FROM SY_PROG_PARAM
                 WHERE PGM_ID   = :d_curr_pgm_name
                 AND SESSION_ID = :nd_session_id
                 AND PGM_DATE   = :nd_pgm_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 16;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,to_char(to_date(PARAM1\
,'MON-YYYY'),'YYYY') ,PARAM4 ,PARAM5 ,PARAM6 ,PARAM7 ,to_char(to_date(PARAM1,'\
MON-YYYY'),'fmMonth YYYY') ,PARAM8 ,PARAM9 ,PARAM10 ,nvl(PARAM11,'C') into :b0\
,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12  from SY_PROG_PARAM where \
((PGM_ID=:b13 and SESSION_ID=:b14) and PGM_DATE=:b15)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )36;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)4352;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_month_year;
        sqlstm.sqhstl[0] = (unsigned int  )11;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_det_option;
        sqlstm.sqhstl[1] = (unsigned int  )5;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_sum_option;
        sqlstm.sqhstl[2] = (unsigned int  )5;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_year;
        sqlstm.sqhstl[3] = (unsigned int  )7;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&nd_break_up;
        sqlstm.sqhstl[4] = (unsigned int  )4;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&nd_excl_dep;
        sqlstm.sqhstl[5] = (unsigned int  )4;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&nd_excl_ref;
        sqlstm.sqhstl[6] = (unsigned int  )4;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&nd_inc_exadwo;
        sqlstm.sqhstl[7] = (unsigned int  )4;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&nd_pg_month;
        sqlstm.sqhstl[8] = (unsigned int  )32;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&nd_exc_adj;
        sqlstm.sqhstl[9] = (unsigned int  )4;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&nd_exc_exmp;
        sqlstm.sqhstl[10] = (unsigned int  )4;
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&nd_exc_writeoff;
        sqlstm.sqhstl[11] = (unsigned int  )4;
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&nd_proc_yn;
        sqlstm.sqhstl[12] = (unsigned int  )1;
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&d_curr_pgm_name;
        sqlstm.sqhstl[13] = (unsigned int  )17;
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
        sqlstm.sqhstv[14] = (         void  *)&nd_session_id;
        sqlstm.sqhstl[14] = (unsigned int  )18;
        sqlstm.sqhsts[14] = (         int  )0;
        sqlstm.sqindv[14] = (         void  *)0;
        sqlstm.sqinds[14] = (         int  )0;
        sqlstm.sqharm[14] = (unsigned int  )0;
        sqlstm.sqadto[14] = (unsigned short )0;
        sqlstm.sqtdso[14] = (unsigned short )0;
        sqlstm.sqhstv[15] = (         void  *)&nd_pgm_date;
        sqlstm.sqhstl[15] = (unsigned int  )27;
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



   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");


		 nd_month_year.arr[nd_month_year.len]		='\0';			
		 nd_det_option.arr[nd_det_option.len]		='\0';		
		 nd_sum_option.arr[nd_sum_option.len]		='\0';				
		 nd_year.arr[nd_year.len]					='\0';	
		nd_break_up.arr[nd_break_up.len]			 = '\0';
        nd_excl_dep.arr[nd_excl_dep.len]			 = '\0';
        nd_excl_ref.arr[nd_excl_ref.len]			 = '\0';
        nd_inc_exadwo.arr[nd_inc_exadwo.len]	     = '\0';
		nd_pg_month.arr[nd_pg_month.len]			= '\0';	
		nd_exc_exmp.arr[nd_exc_exmp.len]			= '\0';
		nd_exc_adj.arr[nd_exc_adj.len]				= '\0';
		nd_exc_writeoff.arr[nd_exc_writeoff.len]	= '\0';
          
 if(nd_proc_yn=='C')
 {
	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = 'BLR00084'
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLR00084' and SE\
SSION_ID=:b0) and PGM_DATE=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )115;
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
 sqlstm.sqhstl[1] = (unsigned int  )27;
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
    }

    	declare_cursor();

    	get_header_dtls();

	   fetch_legend_value();

	    

	   

		 open_file();

		 open_pat_dis_cur();
		        
         fprintf(fp,"%c&l1O",ESC); /* Set Landscape*/ 
		 fprintf(fp,"%c&a4L",ESC); 	/* To Set the Left margin  		*/
		 fprintf(fp,"%c(s14H",ESC); 	/* To set the font 	*/
		   //print_head();
		   print_first_page();
		 initialise_var(); 

		 initialise_tot();
       
	     do_dtl_report();
	        		  
        close_pat_dis_cur();


        open_pat_sum_cur();
		do_summary();
		close_pat_sum_cur();
		fclose(fp);
		print_end_of_rep();
 }


  do_dtl_report()
   {            
while(fetch_bill_dtl_cur())
   {
     fetch_blng_grp_catg();

     	if(strcmp(nd_sum_option.arr,"DI")==0 )
		   calc_summary_in();
        else if(strcmp(nd_sum_option.arr,"EM")==0 )
		   calc_summary_out();
		else
		   calc_summary_ref();
       if(cnt==0)
	    {
			initialise_var();
			initialise_tot();        
			//print_blng_cat();   --commented for Zero
		//	print_bed_clinic();
			  rcnt=0;
			  dcnt=0;
			  lstrcnt=0;
			  lstcnt=0;
			  cpcnt=0;
			  rpcnt=0;
			  crcmcnt=0;
			  bcnt=0;
			  ccnt=0;
			  brcnt=0;
			  adjcnt=0;
			  if(strcmp(nd_det_option.arr,"DI")==0)
			   calc_amount();
			  else if(strcmp(nd_det_option.arr,"EM")==0)
                calc_amount_out();
               else 
			    calc_amount_ext();
			rcnt=rcnt+1;
			dcnt=dcnt+1;
			lstrcnt=lstrcnt+1;
			lstcnt=lstcnt+1;
			crcmcnt=crcmcnt+1;
			cpcnt=cpcnt+1;
			rpcnt=rpcnt+1;
			adjcnt=adjcnt+1;
			bcnt=bcnt+1;
			ccnt=ccnt+1;
			brcnt=brcnt+1;
	    }
       else  
        {
	      if(strcmp(d_blng_grp_catg.arr,nd_blng_grp_catg.arr)==0)
	       {
             if(strcmp(d_bed_clinic_code.arr,nd_bed_clinic_code.arr)==0) 
		  	   {
			    if(strcmp(nd_det_option.arr,"DI")==0)
			 	 calc_amount();
			    else if(strcmp(nd_det_option.arr,"EM")==0)
                calc_amount_out();
                else 
			     calc_amount_ext();
			rcnt=rcnt+1;
			dcnt=dcnt+1;
			lstrcnt=lstrcnt+1;
			lstcnt=lstcnt+1;
			crcmcnt=crcmcnt+1;
			cpcnt=cpcnt+1;
			rpcnt=rpcnt+1;
			adjcnt=adjcnt+1;
			bcnt=bcnt+1;
			ccnt=ccnt+1;
			brcnt=brcnt+1;

	  			   }
			 else
	           {
			     if(prev_mth_curyr_out_cntamt !=0)
				   	prev_mth_curyr_out_cnt=prev_mth_curyr_out_cnt+1;

				 if(cur_mth_bill_out_cntamt !=0)
				   	cur_mth_bill_outcnt=cur_mth_bill_outcnt+1;

                  if(cur_mth_bill_cntamt !=0)
				   	cur_mth_bill_cnt=cur_mth_bill_cnt+1; 
					 
				   if(cur_mth_bill_canc_cntamt !=0)
				   	cur_mth_bill_canc_cnt=cur_mth_bill_canc_cnt+1; 	
			   
			   	   if(cur_mth_bill_rec_cntamt !=0)
				   	cur_mth_bill_rec_cnt=cur_mth_bill_rec_cnt+1; 
                
				 if(adj_wrt_exm_cntamt !=0)
				   	adj_wrt_exm_cnt=adj_wrt_exm_cnt+1; 
                   
				 if(prev_rec_cur_can_cntamt !=0)
				   	prev_rec_cur_can_cnt=prev_rec_cur_can_cnt+1; 
			     
			      	 if(cmth_rec_cyr_pmth_bl_cntamt !=0)
				   	cmth_rec_cyr_pmth_bl_cnt=cmth_rec_cyr_pmth_bl_cnt+1; 

			     if(curyr_prev_mth_rec_canc_curmth_cntamt !=0)
				   	curyr_prev_mth_rec_canc_curmth_cnt=curyr_prev_mth_rec_canc_curmth_cnt+1;
              
			   if(lastyr_bill_rec_curmth_cntamt !=0)
				   	lastyr_bill_rec_curmth_cnt=lastyr_bill_rec_curmth_cnt+1;
              
			   
			   if(lastyr_rec_canc_curmth_cntamt !=0)
				   lastyr_rec_canc_curmth_cnt=lastyr_rec_canc_curmth_cnt+1;
             

				 calc_total();
                 


			//modified 03/12/2005	 if(cur_mth_bill_amt !=0 || cur_mth_bill_rec_amt !=0 || cur_mth_bill_outamt !=0 || prev_mth_curyr_out_amt !=0 || curmth_rec_for_curyr_prevmth_bill !=0 ||lastyr_bill_rec_curmth_amt != 0)
		          //modified 03/12/2005 {
			   if(prn_bl_ind == 0)
			       print_blng_cat();

				    // disp_message(ERR_MESG,nd_description.arr);
					// disp_message(ERR_MESG,"FIRST");
				      
		           print_bed_clinic();

				   print_det();
                
				   prn_bl_ind=1;


				//modified 03/12/2005   }
				 initialise_var(); 
			   //  print_bed_clinic();   
			  rcnt=0; 
			  dcnt=0; 	
			  lstrcnt=0;
			  lstcnt=0;
			  crcmcnt=0;
			  cpcnt=0;
			  rpcnt=0;
			  adjcnt=0;
			  bcnt=0;	
			  ccnt=0;
			  brcnt=0;
				 if(strcmp(nd_det_option.arr,"DI")==0)
					calc_amount();
			     else if(strcmp(nd_det_option.arr,"EM")==0)
                calc_amount_out();
               else 
			    calc_amount_ext();
			  rcnt=rcnt+1; 
			  dcnt=dcnt+1;  
			  lstrcnt=lstrcnt+1;
			  lstcnt=lstcnt+1;
			  crcmcnt=crcmcnt+1;
			  cpcnt=cpcnt+1;
			  rpcnt=rpcnt+1;
			  adjcnt=adjcnt+1;
			  brcnt=brcnt+1;
			  ccnt=ccnt+1;
			  bcnt=bcnt+1;  
	
		                
		
			   }

           }    
	   
          else
		   {
		    if(prev_mth_curyr_out_cntamt !=0)
			   	prev_mth_curyr_out_cnt=prev_mth_curyr_out_cnt+1;

             if(cur_mth_bill_out_cntamt !=0)
				   	cur_mth_bill_outcnt=cur_mth_bill_outcnt+1;
			  if(cur_mth_bill_cntamt !=0)
				   	cur_mth_bill_cnt=cur_mth_bill_cnt+1;
			
                if(cur_mth_bill_canc_cntamt !=0)
				   	cur_mth_bill_canc_cnt=cur_mth_bill_canc_cnt+1;

			 if(cur_mth_bill_rec_cntamt !=0)
				   	cur_mth_bill_rec_cnt=cur_mth_bill_rec_cnt+1;

			if(adj_wrt_exm_cntamt !=0)
				   	adj_wrt_exm_cnt=adj_wrt_exm_cnt+1;
                    
			if(prev_rec_cur_can_cntamt !=0)
				prev_rec_cur_can_cnt=prev_rec_cur_can_cnt+1;
			
				if(cmth_rec_cyr_pmth_bl_cntamt !=0)
				cmth_rec_cyr_pmth_bl_cnt=cmth_rec_cyr_pmth_bl_cnt+1;
             
			 	if(curyr_prev_mth_rec_canc_curmth_cntamt !=0)
				curyr_prev_mth_rec_canc_curmth_cnt=curyr_prev_mth_rec_canc_curmth_cnt+1;
			
              	if(lastyr_bill_rec_curmth_cntamt !=0)
				lastyr_bill_rec_curmth_cnt=lastyr_bill_rec_curmth_cnt+1;
			
				if(lastyr_rec_canc_curmth_cntamt !=0)
				lastyr_rec_canc_curmth_cnt=lastyr_rec_canc_curmth_cnt+1;
			



			 //calc_total();

		//modified 03/12/2005 if(cur_mth_bill_amt !=0 || cur_mth_bill_rec_amt !=0 || cur_mth_bill_outamt !=0 || prev_mth_curyr_out_amt !=0 || curmth_rec_for_curyr_prevmth_bill !=0 ||lastyr_bill_rec_curmth_amt != 0)
		//modified 03/12/2005		  {
               if(prn_bl_ind ==0)
			    {
			    //next_line(1);
				
                print_blng_cat();
				  //next_line(1); 

				print_bed_clinic();
				
				calc_total();   //RELEASED  FOR TEST/

               print_det(); 

			  next_line(3);
			  check_line(3);
			   print_line('-',REP_WIDTH); 

			  //disp_message(ERR_MESG,nd_description.arr);
			  //disp_message(ERR_MESG,"SEC");
			  
			  print_total();
			  next_line(1);
			   print_line('-',REP_WIDTH); 

				}
			
			   else
			     {
				   if(strcmp(d_bed_clinic_code.arr,nd_bed_clinic_code.arr)==0) 
					 {
                        //calc_total();

                          next_line(3);

						  	check_line(3);

						 print_line('-',REP_WIDTH); 

						//disp_message(ERR_MESG,nd_description.arr);
						//disp_message(ERR_MESG,"THIRD");
					
						print_total();
						next_line(1);
						print_line('-',REP_WIDTH); 

                     
					//next_line(1);
					  print_blng_cat(); 
					  
			        }
				  
				print_bed_clinic(); 

			    calc_total();
			   
		      print_det(); 
			  next_line(3);
			  check_line(3);

			   print_line('-',REP_WIDTH); 

		     
			  print_total();
			  next_line(1);

			   print_line('-',REP_WIDTH); 

			  			   
			 }	 

			   prn_bl_ind=0;
              
		
 //modified 03/12/2005 }
			
			 //initialise_tot();  //commented for test//
	         initialise_var();  
             //print_blng_cat();     
             //print_bed_clinic(); 
		  rcnt=0;
		  dcnt=0;
		  lstrcnt=0;
		  lstcnt=0;
		  crcmcnt=0;
		  cpcnt=0;
		  rpcnt=0;
		  adjcnt=0;
		  brcnt=0;
		  ccnt=0;
		  bcnt=0;
		     if(strcmp(nd_det_option.arr,"DI")==0)
			   calc_amount();
			 else if(strcmp(nd_det_option.arr,"EM")==0)
                calc_amount_out();
               else 
			    calc_amount_ext();
		  rcnt=rcnt+1; 
		  dcnt=dcnt+1;
		  lstrcnt=lstrcnt+1;
		  lstcnt=lstcnt+1;
		  crcmcnt=crcmcnt+1;
		  cpcnt=cpcnt+1;
		  rpcnt=rpcnt+1;
		  adjcnt=adjcnt+1;
		  brcnt=brcnt+1;
		  ccnt=ccnt+1;
		  bcnt=bcnt+1;          
		 } 
     
	 }
       
       strcpy(nd_blng_grp_catg.arr,d_blng_grp_catg.arr);
	nd_blng_grp_catg.len = strlen(nd_blng_grp_catg.arr);

        strcpy(nd_bed_clinic_code.arr,d_bed_clinic_code.arr);
	nd_bed_clinic_code.len = strlen(nd_bed_clinic_code.arr);

        strcpy(nd_episode_id.arr,d_episode_id.arr);
		strcpy(nd1_episode_id.arr,d_episode_id.arr);
		//strcpy(nd2_episode_id.arr,d_episode_id.arr);
		strcpy(nd_visit_id.arr,d_visit_id.arr);
		strcpy(nd1_visit_id.arr,d_visit_id.arr);
		//strcpy(nd2_visit_id.arr,d_visit_id.arr);

		  strcpy(nd_patient_id.arr,d_patient_id.arr);
		strcpy(nd1_patient_id.arr,d_patient_id.arr);
		strcpy(nd2_patient_id.arr,d_patient_id.arr);

		strcpy(nd_description.arr,d_description.arr);	
		nd_description.len = strlen(nd_description.arr);
	
    	cnt=cnt+1; 
        
  }
  //--------------
 /* if(strcmp(nd_det_option.arr,"DI")==0)
			   calc_amount();
			  else if(strcmp(nd_det_option.arr,"EM")==0)
                calc_amount_out();
               else 
			    calc_amount_ext();
		     if(prev_mth_curyr_out_cntamt !=0)
		 	   	prev_mth_curyr_out_cnt=prev_mth_curyr_out_cnt+1;

             if(cur_mth_bill_out_cntamt !=0)
				   	cur_mth_bill_outcnt=cur_mth_bill_outcnt+1;

              if(cur_mth_bill_cntamt !=0)
				   	cur_mth_bill_cnt=cur_mth_bill_cnt+1;

			 if(cur_mth_bill_canc_cntamt !=0)
				   	cur_mth_bill_canc_cnt=cur_mth_bill_canc_cnt+1;
			
			if(cur_mth_bill_rec_cntamt !=0)
				   	cur_mth_bill_rec_cnt=cur_mth_bill_rec_cnt+1;
					
             		if(adj_wrt_exm_cntamt !=0)
				   	adj_wrt_exm_cnt	=adj_wrt_exm_cnt+1;

			if(prev_rec_cur_can_cntamt!=0)
				   	prev_rec_cur_can_cnt=prev_rec_cur_can_cnt+1;

			 	if(cmth_rec_cyr_pmth_bl_cntamt!=0)
				   	cmth_rec_cyr_pmth_bl_cnt=cmth_rec_cyr_pmth_bl_cnt+1;
					
				
					if(curyr_prev_mth_rec_canc_curmth_cntamt !=0)
				   	curyr_prev_mth_rec_canc_curmth_cnt=curyr_prev_mth_rec_canc_curmth_cnt+1;
				
					if(lastyr_bill_rec_curmth_cntamt !=0)
				   	lastyr_bill_rec_curmth_cnt=lastyr_bill_rec_curmth_cnt+1;
				  
					if(lastyr_rec_canc_curmth_cntamt !=0)
				   	lastyr_rec_canc_curmth_cnt=lastyr_rec_canc_curmth_cnt+1;
											
					
*/
					
//-----------------------------------------
          calc_total();

		// modified 03/12/2005 if(cur_mth_bill_amt !=0 || cur_mth_bill_rec_amt !=0 || cur_mth_bill_outamt !=0 || prev_mth_curyr_out_amt !=0 || curmth_rec_for_curyr_prevmth_bill !=0 ||lastyr_bill_rec_curmth_amt != 0)
		//modified 03/12/2005		{
		   if(prn_bl_ind ==0)
                print_blng_cat();

			print_bed_clinic(); 
            print_det(); 
			     

			  next_line(3);
			  check_line(3);
			   print_line('-',REP_WIDTH); 
			   
			  print_total();
			  next_line(1);
			   print_line('-',REP_WIDTH); 

			//modified 03/12/2005  }

			check_line(2);


                 fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 			*/

			   
			   print_grand_total();
			   fprintf(fp,"%c(s14H",ESC); 	/* To set the font 	*/
			   fprintf(fp,"%c(s-3B",ESC); /* release bold style */
			   next_line(1);
			   print_line('-',REP_WIDTH); 
			 

  /*if (nd_proc_yn == 'C') 
	{
		Show_Window();
	}
	else
	{
		VIEW_OUTPUT = 0;
	}*/

}

do_summary()
{

while(fetch_bill_dtl_sum_cur())
  {

	if(strcmp(nd_sum_option.arr,"DI")==0 )
		   calc_summary_in();
        else if(strcmp(nd_sum_option.arr,"EM")==0 )
		  calc_summary_out();
		else
		   calc_summary_ref();
   }
               sum_header();
			   print_sum();

}			   


 
	/*-------------------------------------------------------------------
				CALCULATION OF BLNG GROUP TOTAL
    -------------------------------------------------------------------*/
 calc_total()
    {
                 /*====== BILLED AMOUNT OF CURRENT MONTH=======*/
	    tot_cur_mth_bill_cnt=tot_cur_mth_bill_cnt+cur_mth_bill_cnt;
		tot_cur_mth_bill_amt=tot_cur_mth_bill_amt+cur_mth_bill_amt;
	
          gd_tot_cur_mth_bill_cnt=gd_tot_cur_mth_bill_cnt+cur_mth_bill_cnt;
		  gd_tot_cur_mth_bill_amt=gd_tot_cur_mth_bill_amt+cur_mth_bill_amt;
		  
				/*====== BILLED TILL LAST MONTH AND CANCELLED THIS MONTH=======*/
		tot_cur_mth_bill_canc_cnt=tot_cur_mth_bill_canc_cnt+cur_mth_bill_canc_cnt;
		tot_cur_mth_bill_canc_amt=tot_cur_mth_bill_canc_amt+cur_mth_bill_canc_amt;
        
		gd_tot_cur_mth_bill_canc_cnt=gd_tot_cur_mth_bill_canc_cnt+cur_mth_bill_canc_cnt;
		gd_tot_cur_mth_bill_canc_amt=gd_tot_cur_mth_bill_canc_amt+cur_mth_bill_canc_amt;


				/*======BILLED THIS MONTH AND RECEIPT THIS MONTH=======*/
		tot_cur_mth_bill_rec_cnt=tot_cur_mth_bill_rec_cnt+cur_mth_bill_rec_cnt;
		tot_cur_mth_bill_rec_amt=tot_cur_mth_bill_rec_amt+cur_mth_bill_rec_amt;

        gd_tot_cur_mth_bill_rec_cnt=gd_tot_cur_mth_bill_rec_cnt+cur_mth_bill_rec_cnt;
		gd_tot_cur_mth_bill_rec_amt=gd_tot_cur_mth_bill_rec_amt+cur_mth_bill_rec_amt;

				/*======RECEIPT TILL PREVIOUS MONTH AND CANCELLED THIS MONTH=======*/
		tot_prev_rec_cur_can_cnt=tot_prev_rec_cur_can_cnt+prev_rec_cur_can_cnt;
		tot_prev_rec_cur_can_amt=tot_prev_rec_cur_can_amt+prev_rec_cur_can_amt;

        gd_tot_prev_rec_cur_can_cnt=gd_tot_prev_rec_cur_can_cnt+prev_rec_cur_can_cnt;
		gd_tot_prev_rec_cur_can_amt=gd_tot_prev_rec_cur_can_amt+prev_rec_cur_can_amt;

				/*======EXEMPTION-ADJUSTMENT-WRITEOFF=======*/
		tot_adj_wrt_exm_cnt=tot_adj_wrt_exm_cnt+adj_wrt_exm_cnt;
		tot_adj_wrt_exm_cnt=tot_adj_wrt_exm_cnt+adj_wrt_exm_amt;

       	gd_tot_adj_wrt_exm_cnt=gd_tot_adj_wrt_exm_cnt+adj_wrt_exm_cnt;
		gd_tot_adj_wrt_exm_cnt=gd_tot_adj_wrt_exm_cnt+adj_wrt_exm_amt;

				/*======CURR MONTH OUTSTANDING(BILL&RECEIPT CURRENT MONTH)=====*/
		tot_cur_mth_bill_outcnt=tot_cur_mth_bill_outcnt+cur_mth_bill_outcnt;
		tot_cur_mth_bill_outamt=tot_cur_mth_bill_outamt+cur_mth_bill_outamt;

        gd_tot_cur_mth_bill_outcnt=gd_tot_cur_mth_bill_outcnt+cur_mth_bill_outcnt;
		gd_tot_cur_mth_bill_outamt=gd_tot_cur_mth_bill_outamt+cur_mth_bill_outamt;

               /*========PREVIOUS MONTHS BILLS IN CURRENT YEAR--OUTSTANDING=====*/
		tot_prev_mth_curyr_out_cnt=tot_prev_mth_curyr_out_cnt+prev_mth_curyr_out_cnt;
		tot_prev_mth_curyr_out_amt=tot_prev_mth_curyr_out_amt+prev_mth_curyr_out_amt;

	    gd_tot_prev_mth_curyr_out_cnt=gd_tot_prev_mth_curyr_out_cnt+prev_mth_curyr_out_cnt;
		gd_tot_prev_mth_curyr_out_amt=gd_tot_prev_mth_curyr_out_amt+prev_mth_curyr_out_amt;

				/*========AMOUNT COLLECTED THIS MTH FOR BILLS TILL PREVIOUS MONTH OF CURR YEAR-=====*/             
		tot_cmth_rec_cyr_pmth_bl_cnt=tot_cmth_rec_cyr_pmth_bl_cnt+cmth_rec_cyr_pmth_bl_cnt;
		tot_curmth_rec_for_curyr_prevmth_bill=tot_curmth_rec_for_curyr_prevmth_bill+curmth_rec_for_curyr_prevmth_bill;

 	    gd_tot_cmth_rec_cyr_pmth_bl_cnt=gd_tot_cmth_rec_cyr_pmth_bl_cnt+cmth_rec_cyr_pmth_bl_cnt;
		gd_tot_curmth_rec_for_curyr_prevmth_bill=gd_tot_curmth_rec_for_curyr_prevmth_bill+curmth_rec_for_curyr_prevmth_bill;

				/*========RECEIPT CANCELLED THIS MTH FOR RECEIPTS TILL LAST MTH OF CURR YEAR ========*/
		tot_curyr_prev_mth_rec_canc_curmth_cnt=tot_curyr_prev_mth_rec_canc_curmth_cnt+curyr_prev_mth_rec_canc_curmth_cnt;
		tot_curyr_prev_mth_rec_canc_curmth=tot_curyr_prev_mth_rec_canc_curmth+curyr_prev_mth_rec_canc_curmth;

        gd_tot_curyr_prev_mth_rec_canc_curmth_cnt=gd_tot_curyr_prev_mth_rec_canc_curmth_cnt+curyr_prev_mth_rec_canc_curmth_cnt;
		gd_tot_curyr_prev_mth_rec_canc_curmth=gd_tot_curyr_prev_mth_rec_canc_curmth+curyr_prev_mth_rec_canc_curmth;


				/*========AMOUNT COLLECTED THIS MONTH FOR BILLS TILL LAST YEAR========*/
		tot_lastyr_bill_rec_curmth_cnt=tot_lastyr_bill_rec_curmth_cnt+lastyr_bill_rec_curmth_cnt;
		tot_lastyr_bill_rec_curmth_amt=tot_lastyr_bill_rec_curmth_amt+lastyr_bill_rec_curmth_amt;

        gd_tot_lastyr_bill_rec_curmth_cnt=gd_tot_lastyr_bill_rec_curmth_cnt+lastyr_bill_rec_curmth_cnt;
		gd_tot_lastyr_bill_rec_curmth_amt=gd_tot_lastyr_bill_rec_curmth_amt+lastyr_bill_rec_curmth_amt;

				/*========AMOUNT CANCELLED THIS MONTH FOR RECEIPT DATE LAST YEAR========*/
		tot_lastyr_rec_canc_curmth_cnt=tot_lastyr_rec_canc_curmth_cnt+lastyr_rec_canc_curmth_cnt;
		tot_lastyr_rec_canc_curmth_amt=tot_lastyr_rec_canc_curmth_amt+lastyr_rec_canc_curmth_amt;
         
		gd_tot_lastyr_rec_canc_curmth_cnt=gd_tot_lastyr_rec_canc_curmth_cnt+lastyr_rec_canc_curmth_cnt;
		gd_tot_lastyr_rec_canc_curmth_amt=gd_tot_lastyr_rec_canc_curmth_amt+lastyr_rec_canc_curmth_amt;




 }

print_total()
  {
			 if (nd_proc_yn == 'C') 
			 {
                        /*====== BILLED AMOUNT OF CURRENT MONTH=======*/
	fprintf(fp,"%15s%7d",loc_legend[23],tot_cur_mth_bill_cnt);
	print_formated(tot_cur_mth_bill_amt);
	 
	 if(strcmp(nd_break_up.arr,"P")==0)
	    {  
                 /*====== BILLED TILL LAST MONTH AND CANCELLED THIS MONTH=======*/
	fprintf(fp,"%8d",tot_cur_mth_bill_canc_cnt);
	print_formated(tot_cur_mth_bill_canc_amt);

	     }
                      /*======BILLED THIS MONTH AND RECEIPT THIS MONTH=======*/
	fprintf(fp,"%8d",tot_cur_mth_bill_rec_cnt);
	print_formated(tot_cur_mth_bill_rec_amt);

	 if(strcmp(nd_break_up.arr,"P")==0)
	    {  
                /*======RECEIPT TILL PREVIOUS MONTH AND CANCELLED THIS MONTH=======*/
	fprintf(fp,"%8d",tot_prev_rec_cur_can_cnt);
	print_formated(tot_prev_rec_cur_can_amt);
	     } 

if(strcmp(nd_inc_exadwo.arr,"Y")==0)
	    {  
		 
                             /*======EXEMPTION-ADJUSTMENT-WRITEOFF=======*/
	fprintf(fp,"%8d",tot_adj_wrt_exm_cnt);
	print_formated(tot_adj_wrt_exm_amt);
	  }
				/*---------------------------------------------------
				    --------****OUTSTANDING BILLS****--------
				--------------------------------------------------*/
                  /*======CURR MONTH OUTSTANDING(BILL&RECEIPT CURRENT MONTH)=====*/
	fprintf(fp,"%8d",tot_cur_mth_bill_outcnt);
	print_formated(tot_cur_mth_bill_outamt);
				/*========PREVIOUS MONTHS BILLS IN CURRENT YEAR--OUTSTANDING=====*/
	fprintf(fp,"%8d",tot_prev_mth_curyr_out_cnt);
	print_formated(tot_prev_mth_curyr_out_amt);                   
                  /*========AMOUNT COLLECTED THIS MTH FOR BILLS TILL PREVIOUS MONTH OF CURR YEAR-=====*/             
	fprintf(fp,"%8d",tot_cmth_rec_cyr_pmth_bl_cnt);
	print_formated(tot_curmth_rec_for_curyr_prevmth_bill);

	   if(strcmp(nd_break_up.arr,"P")==0)
	    {  
				/*========RECEIPT CANCELLED THIS MTH FOR RECEIPTS TILL LAST MTH OF CURR YEAR ========*/
	fprintf(fp,"%8d",tot_curyr_prev_mth_rec_canc_curmth_cnt);
	print_formated(tot_curyr_prev_mth_rec_canc_curmth);
	    }
                       /*========AMOUNT COLLECTED THIS MONTH FOR BILLS TILL LAST YEAR========*/
	fprintf(fp,"%8d",tot_lastyr_bill_rec_curmth_cnt);
	print_formated(tot_lastyr_bill_rec_curmth_amt);

	   if(strcmp(nd_break_up.arr,"P")==0)
	    {  
                      /*========AMOUNT CANCELLED THIS MONTH FOR RECEIPT DATE LAST YEAR========*/
	fprintf(fp,"%8d",tot_lastyr_rec_canc_curmth_cnt);
	print_formated(tot_lastyr_rec_canc_curmth_amt);
	   }
	    next_line(1);
			   print_line('-',REP_WIDTH); 

    }
   initialise_tot();
 }
print_grand_total()
  {
  			 if (nd_proc_yn == 'C') 
			 {
                        /*====== BILLED AMOUNT OF CURRENT MONTH=======*/
	fprintf(fp,"%-15s%7d",loc_legend[24],gd_tot_cur_mth_bill_cnt);
	print_formated(gd_tot_cur_mth_bill_amt);
	 
	 if(strcmp(nd_break_up.arr,"P")==0)
	    {  
                 /*====== BILLED TILL LAST MONTH AND CANCELLED THIS MONTH=======*/
	fprintf(fp,"%8d",gd_tot_cur_mth_bill_canc_cnt);
	print_formated(gd_tot_cur_mth_bill_canc_amt);

	     }
                      /*======BILLED THIS MONTH AND RECEIPT THIS MONTH=======*/
	fprintf(fp,"%8d",gd_tot_cur_mth_bill_rec_cnt);
	print_formated(gd_tot_cur_mth_bill_rec_amt);

	 if(strcmp(nd_break_up.arr,"P")==0)
	    {  
                /*======RECEIPT TILL PREVIOUS MONTH AND CANCELLED THIS MONTH=======*/
	fprintf(fp,"%8d",gd_tot_prev_rec_cur_can_cnt);
	print_formated(gd_tot_prev_rec_cur_can_amt);
	     } 

if(strcmp(nd_inc_exadwo.arr,"Y")==0)
	    {  
		 
                             /*======EXEMPTION-ADJUSTMENT-WRITEOFF=======*/
	fprintf(fp,"%8d",gd_tot_adj_wrt_exm_cnt);
	print_formated(gd_tot_adj_wrt_exm_amt);
	  }
				/*---------------------------------------------------
				    --------****OUTSTANDING BILLS****--------
				--------------------------------------------------*/
                  /*======CURR MONTH OUTSTANDING(BILL&RECEIPT CURRENT MONTH)=====*/
	fprintf(fp,"%8d",gd_tot_cur_mth_bill_outcnt);
	print_formated(gd_tot_cur_mth_bill_outamt);
				/*========PREVIOUS MONTHS BILLS IN CURRENT YEAR--OUTSTANDING=====*/
	fprintf(fp,"%8d",gd_tot_prev_mth_curyr_out_cnt);
	print_formated(gd_tot_prev_mth_curyr_out_amt);                   
                  /*========AMOUNT COLLECTED THIS MTH FOR BILLS TILL PREVIOUS MONTH OF CURR YEAR-=====*/             
	fprintf(fp,"%8d",gd_tot_cmth_rec_cyr_pmth_bl_cnt);
	print_formated(gd_tot_curmth_rec_for_curyr_prevmth_bill);

	   if(strcmp(nd_break_up.arr,"P")==0)
	    {  
				/*========RECEIPT CANCELLED THIS MTH FOR RECEIPTS TILL LAST MTH OF CURR YEAR ========*/
	fprintf(fp,"%8d",gd_tot_curyr_prev_mth_rec_canc_curmth_cnt);
	print_formated(gd_tot_curyr_prev_mth_rec_canc_curmth);
	    }
                       /*========AMOUNT COLLECTED THIS MONTH FOR BILLS TILL LAST YEAR========*/
	fprintf(fp,"%8d",gd_tot_lastyr_bill_rec_curmth_cnt);
	print_formated(gd_tot_lastyr_bill_rec_curmth_amt);

	   if(strcmp(nd_break_up.arr,"P")==0)
	    {  
                      /*========AMOUNT CANCELLED THIS MONTH FOR RECEIPT DATE LAST YEAR========*/
	fprintf(fp,"%8d",gd_tot_lastyr_rec_canc_curmth_cnt);
	print_formated(gd_tot_lastyr_rec_canc_curmth_amt);
	   }

	   }
  }

        
calc_summary_out()
  {
 if(strcmp(d_sum_episode_type.arr,"O")==0 || strcmp(d_sum_episode_type.arr,"E")==0)
   {
    if(strcmp(d_sum_national.arr,"NATIONALS")==0)
	     {
		   
		  if(strcmp(d_sum_trx_type.arr,"RECEIPT")==0 || strcmp(d_sum_trx_type.arr,"REFUND")==0)
			   sum_no_enctr_amt=sum_no_enctr_amt+d_sum_outst_amt;
          
		      if(strcmp(d_sum_episode_id.arr,ndc_sum_episode_id.arr)!=0)
			     sum_no_enctr_cnt=sum_no_enctr_cnt+1;
	          strcpy(ndc_sum_episode_id.arr,d_sum_episode_id.arr);
          }

		  else
		    {	
			 
		    if(strcmp(d_sum_trx_type.arr,"RECEIPT")==0 || strcmp(d_sum_trx_type.arr,"REFUND")==0)
			   sum_ot_enctr_amt=sum_ot_enctr_amt+d_sum_outst_amt;
       
		      if(strcmp(d_sum_episode_id.arr,ndo_sum_episode_id.arr)!=0)
			     sum_ot_enctr_cnt=sum_ot_enctr_cnt+1;
	          strcpy(ndo_sum_episode_id.arr,d_sum_episode_id.arr);
			}  
   }

}


calc_summary_in()
  {

 if(strcmp(d_sum_episode_type.arr,"I")==0 || strcmp(d_sum_episode_type.arr,"D")==0)
   {

    if(strcmp(d_sum_national.arr,"NATIONALS")==0)
	     {
		   
		  if(strcmp(d_sum_trx_type.arr,"RECEIPT")==0 || strcmp(d_sum_trx_type.arr,"REFUND")==0 )
			   sum_no_enctr_amt=sum_no_enctr_amt+d_sum_outst_amt;
                 if(strcmp(d_sum_episode_id.arr,ndc_sum_episode_id.arr)!=0)
			     sum_no_enctr_cnt=sum_no_enctr_cnt+1;
	          strcpy(ndc_sum_episode_id.arr,d_sum_episode_id.arr);
          }
		  else
		    {	
			 
		    if(strcmp(d_sum_trx_type.arr,"RECEIPT")==0 || strcmp(d_sum_trx_type.arr,"REFUND")==0)
			   sum_ot_enctr_amt=sum_ot_enctr_amt+d_sum_outst_amt;
       
		      if(strcmp(d_sum_episode_id.arr,ndo_sum_episode_id.arr)!=0)
			     sum_ot_enctr_cnt=sum_ot_enctr_cnt+1;
	          strcpy(ndo_sum_episode_id.arr,d_sum_episode_id.arr);
			}  
   }

}


calc_summary_ref()
  {
 if(strcmp(d_sum_episode_type.arr,"R")==0 )
   {
    if(strcmp(d_sum_national.arr,"NATIONALS")==0)
	     {
		   
		  if(strcmp(d_sum_trx_type.arr,"RECEIPT")==0 || strcmp(d_sum_trx_type.arr,"REFUND")==0)
			   sum_no_enctr_amt=sum_no_enctr_amt+d_sum_outst_amt;
          
		      if(strcmp(d_sum_episode_id.arr,ndc_sum_episode_id.arr)!=0)
			     sum_no_enctr_cnt=sum_no_enctr_cnt+1;
	          strcpy(ndc_sum_episode_id.arr,d_sum_episode_id.arr);
          }
		  else
		    {	
			 
		    if(strcmp(d_sum_trx_type.arr,"RECEIPT")==0 || strcmp(d_sum_trx_type.arr,"REFUND")==0)
			   sum_ot_enctr_amt=sum_ot_enctr_amt+d_sum_outst_amt;
       
		      if(strcmp(d_sum_episode_id.arr,ndo_sum_episode_id.arr)!=0)
			     sum_ot_enctr_cnt=sum_ot_enctr_cnt+1;
	          strcpy(ndo_sum_episode_id.arr,d_sum_episode_id.arr);
			}  
   }

}

calc_amount()
  {

       /*---------------------BILLED AMOUNT OF CURRENT MONTH--------------------------*/ 

   if(strcmp(d_episode_type.arr,"I")==0 || strcmp(d_episode_type.arr,"D")==0)
    {
	   		

     
		  			  
	  if(strcmp(d_bill_mth.arr,nd_month_year.arr)==0 && strcmp(d_trx_type.arr,"BILL")==0)
			   {
				  if(strcmp(d_valid_for_out.arr,"Y")==0)
				   {
		             cur_mth_bill_amt=cur_mth_bill_amt+d_bill_tot_amt; 
					
			   	if(strcmp(d_episode_id.arr,ndb_episode_id.arr)==0 )
					 cur_mth_bill_cntamt =  cur_mth_bill_cntamt+d_bill_tot_amt; 
					else
				      {	   
                         if(cur_mth_bill_cntamt !=0 && bcnt >0)
						  {
					      cur_mth_bill_cnt=cur_mth_bill_cnt+1;
						  cur_mth_bill_cntamt=0;
						   }
				         cur_mth_bill_cntamt = cur_mth_bill_cntamt+d_bill_tot_amt; 
				      }
					   strcpy(ndb_episode_id.arr,d_episode_id.arr);  
                    }

	  	          }
      /*--------------BILLED TILL LAST MONTH AND CANCELLED THIS MONTH----------------*/
      if(strcmp(d_bill_mth.arr,nd_month_year.arr)!=0 && strcmp(d_trx_mth.arr,nd_month_year.arr)==0 && strcmp(d_trx_type.arr,"CANC-BILL")==0)
              {
	           cur_mth_bill_canc_amt=cur_mth_bill_canc_amt+d_bill_tot_amt;    
	       
			   if(strcmp(d_episode_id.arr,ndlc_episode_id.arr)==0 )
					 cur_mth_bill_canc_cntamt =  cur_mth_bill_canc_cntamt+d_bill_tot_amt; 
					else
				      {	   
                         if(cur_mth_bill_canc_cntamt !=0 && ccnt >0)
						  {
					      cur_mth_bill_canc_cnt=cur_mth_bill_canc_cnt+1;
						  cur_mth_bill_canc_cntamt=0;
						   }
				         cur_mth_bill_canc_cntamt =cur_mth_bill_canc_cntamt+d_bill_tot_amt; 
				      }
					   strcpy(ndlc_episode_id.arr,d_episode_id.arr);  
                   }

        /*--------------BILLED THIS MONTH AND RECEIPT THIS MONTH-------------------------*/
       if(strcmp(d_bill_mth.arr,nd_month_year.arr)==0 && strcmp(d_trx_mth.arr,nd_month_year.arr)==0 )                                                          
              {
			   if(strcmp(d_valid_for_out.arr,"Y")==0)
				 {
				  if(strcmp(d_trx_type.arr,"RECEIPT")==0 || strcmp(d_trx_type.arr,"REFUND")==0)
					{
	                  cur_mth_bill_rec_amt=cur_mth_bill_rec_amt+d_outst_amt;    
	                
			     if(strcmp(d_episode_id.arr,ndr_episode_id.arr)==0)
			         cur_mth_bill_rec_cntamt =  cur_mth_bill_rec_cntamt+d_outst_amt; 
     			  else
				    {
						if(cur_mth_bill_rec_cntamt !=0 && brcnt>0)
						{
						  cur_mth_bill_rec_cnt=cur_mth_bill_rec_cnt+1;
						  cur_mth_bill_rec_cntamt=0;
						}
				       cur_mth_bill_rec_cntamt = cur_mth_bill_rec_cntamt+d_outst_amt; 
				     }
	             	 strcpy(ndr_episode_id.arr,d_episode_id.arr);
					
				   }

		        /*--------------OutStanding Amount-----------*/
           		   cur_mth_bill_outamt= cur_mth_bill_outamt+d_outst_amt;
                  if(strcmp(d_episode_id.arr,ndbr_episode_id.arr)==0)
				      cur_mth_bill_out_cntamt =  cur_mth_bill_out_cntamt+d_outst_amt; 
     			  else
				    {
						if(cur_mth_bill_out_cntamt !=0 && dcnt>0)
						{
						  cur_mth_bill_outcnt=cur_mth_bill_outcnt+1;
						  cur_mth_bill_out_cntamt=0;
						}
				    cur_mth_bill_out_cntamt = cur_mth_bill_out_cntamt+d_outst_amt; 
				   }
                  
				     strcpy(ndbr_episode_id.arr,d_episode_id.arr);
					               
	             }      
		     }
						/*===========ADJ EXM WRITE OFF=======*/
        if( strcmp(d_trx_mth.arr,nd_month_year.arr)==0 )                    
	     {
		   if(strcmp(d_valid_for_out.arr,"Y")==0)  
	         {
	            if( strcmp(d_trx_type.arr,"ADJ-BILL")==0 || strcmp(d_trx_type.arr,"CANC-ADJ-BILL")==0 || strcmp(d_trx_type.arr,"EXM-BILL")==0 || strcmp(d_trx_type.arr,"CAN-EXM-BILL")==0 || strcmp(d_trx_type.arr,"WRITEOFF")==0 || strcmp(d_trx_type.arr,"CAN-WRITEOFF")==0)
			   	{
	                  adj_wrt_exm_amt=adj_wrt_exm_amt+d_outst_amt; 

			     if(strcmp(d_episode_id.arr,ndawe_episode_id.arr)==0 )
				      adj_wrt_exm_cntamt =  adj_wrt_exm_cntamt+d_outst_amt; 
     			  else
				   {
						if(adj_wrt_exm_cntamt !=0 && adjcnt>0)
						{
						  adj_wrt_exm_cnt=adj_wrt_exm_cnt+1;
						  adj_wrt_exm_cntamt=0;
						}
				     adj_wrt_exm_cntamt = adj_wrt_exm_cntamt+d_outst_amt; 
				   }

                     strcpy(ndadj_episode_id.arr,d_episode_id.arr);
					
				}

             }
        }
      /*---------------RECEIPT TILL PREVIOUS MONTH AND CANCELLED THIS MONTH--------------*/
         if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 &&  strcmp(d_org_mth.arr,nd_month_year.arr)!=0 && (strcmp(d_trx_type.arr,"RECEIPT-CANC")==0 || strcmp(d_trx_type.arr,"REFUND-CANC")==0) )                                                        
              {
	              prev_rec_cur_can_amt=prev_rec_cur_can_amt+d_bill_tot_amt;    
	           
				  
				if(strcmp(d_episode_id.arr,ndrpc_episode_id.arr)==0 )
					prev_rec_cur_can_cntamt = prev_rec_cur_can_cntamt+d_outst_amt; 
				  else
				   {
				      if(prev_mth_curyr_out_cntamt!=0 && rpcnt>0)
						{
						 prev_rec_cur_can_cnt=prev_rec_cur_can_cnt+1;
						 prev_rec_cur_can_cntamt=0;
		   				}
					prev_rec_cur_can_cntamt = prev_rec_cur_can_cntamt+d_outst_amt; 
				  }

                strcpy(ndrpc_episode_id.arr,d_episode_id.arr);
			      
		       }             
      /*---------------PREVIOUS MONTHS BILLS IN CURRENT YEAR--OUTSTANDING-----------------------*/
         if(strcmp(d_bill_mth.arr,nd_month_year.arr)!=0 &&  strcmp(d_bill_year.arr,nd_year.arr)==0 &&  strcmp(d_trx_mth.arr,nd_month_year.arr)!=0 )
           {
		     if(strcmp(d_valid_for_out.arr,"Y")==0)
		       {
				prev_mth_curyr_out_amt=prev_mth_curyr_out_amt+d_outst_amt;
	 			  if(strcmp(d_episode_id.arr,nd2_episode_id.arr)==0 )
					prev_mth_curyr_out_cntamt =  prev_mth_curyr_out_cntamt+d_outst_amt; 
				  else
				   {
				      if(prev_mth_curyr_out_cntamt!=0 && rcnt>0)
						{
						 prev_mth_curyr_out_cnt=prev_mth_curyr_out_cnt+1;
						 prev_mth_curyr_out_cntamt=0;
		   				}
					prev_mth_curyr_out_cntamt =  prev_mth_curyr_out_cntamt+d_outst_amt; 
				  }
				   strcpy(nd2_episode_id.arr,d_episode_id.arr);
			    
			  }  
		   }
        /*------------AMOUNT COLLECTED THIS MTH FOR BILLS TILL PREVIOUS MONTH OF CURR YEAR--------- */                                             
         if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 &&  strcmp(d_bill_year.arr,nd_year.arr)==0 && strcmp(d_bill_mth.arr,nd_month_year.arr)!=0  && (strcmp(d_trx_type.arr,"RECEIPT")==0|| strcmp(d_trx_type.arr,"REFUND")==0 ))
             {
			   
				if(strcmp(d_valid_for_out.arr,"Y")==0)
				  {
				  
				 // disp_message(ERR_MESG,d_episode_id.arr);
				 // disp_message(ERR_MESG,d_doc_type_code.arr);
				 // sprintf(string_var," d_doc_num = <%d> %s ", d_doc_num,d_doc_type_code.arr);
				 // disp_message(INFO_MESG,string_var);

                 //  disp_message(ERR_MESG,d_trx_type.arr);

				
	                curmth_rec_for_curyr_prevmth_bill=curmth_rec_for_curyr_prevmth_bill+d_outst_amt;    

		       if(strcmp(d_episode_id.arr,ndpm_episode_id.arr)==0 )
					cmth_rec_cyr_pmth_bl_cntamt = cmth_rec_cyr_pmth_bl_cntamt+d_outst_amt; 
				  else
				   {
				      if(cmth_rec_cyr_pmth_bl_cntamt !=0 && cpcnt>0)
						{
						cmth_rec_cyr_pmth_bl_cnt=cmth_rec_cyr_pmth_bl_cnt+1;
						 cmth_rec_cyr_pmth_bl_cntamt=0;
		   				}
					cmth_rec_cyr_pmth_bl_cntamt = cmth_rec_cyr_pmth_bl_cntamt+d_outst_amt; 
				  }

					strcpy(ndpm_episode_id.arr,d_episode_id.arr);
					
				  }
             } 
        /*---------RECEIPT CANCELLED THIS MTH FOR RECEIPTS TILL LAST MTH OF CURR YEAR-------------*/
         if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 &&  strcmp(d_org_year.arr,nd_year.arr)==0 && strcmp(d_org_mth.arr,nd_month_year.arr)!=0 && (strcmp(d_trx_type.arr,"CANC-RECEIPT")==0 || strcmp(d_trx_type.arr,"CANC-REFUND")==0))
                {
	             curyr_prev_mth_rec_canc_curmth=curyr_prev_mth_rec_canc_curmth+d_outst_amt;    


                  if(strcmp(d_episode_id.arr,ndcyr_episode_id.arr)==0 )
					curyr_prev_mth_rec_canc_curmth_cntamt = curyr_prev_mth_rec_canc_curmth_cntamt+d_outst_amt; 
				  else
				   {
				      if(curyr_prev_mth_rec_canc_curmth_cntamt !=0 && crcmcnt>0)
						{
						curyr_prev_mth_rec_canc_curmth_cnt=curyr_prev_mth_rec_canc_curmth_cnt+1;
						 curyr_prev_mth_rec_canc_curmth_cntamt=0;
		   				}
					curyr_prev_mth_rec_canc_curmth_cntamt = curyr_prev_mth_rec_canc_curmth_cntamt+d_outst_amt; 
				  }

                 strcpy(ndcyr_episode_id.arr,d_episode_id.arr);
					             
	         	}

       /*---------AMOUNT COLLECTED THIS MONTH FOR BILLS TILL LAST YEAR---------------------------*/
                                                             
	     if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 && strcmp(d_bill_year.arr,nd_year.arr)!=0 && (strcmp(d_trx_type.arr,"RECEIPT")==0 || strcmp(d_trx_type.arr,"REFUND")==0 ))
           {
			  if(strcmp(d_valid_for_out.arr,"Y")==0)
			   {
	          lastyr_bill_rec_curmth_amt=lastyr_bill_rec_curmth_amt+d_outst_amt;    
	            if(strcmp(d_episode_id.arr,ndlyr_episode_id.arr)==0 )
					lastyr_bill_rec_curmth_cntamt = lastyr_bill_rec_curmth_cntamt+d_outst_amt; 
				  else
				   {
				      if( lastyr_bill_rec_curmth_cntamt !=0 && lstcnt>0)
						{
						 lastyr_bill_rec_curmth_cnt= lastyr_bill_rec_curmth_cnt+1;
						  lastyr_bill_rec_curmth_cntamt=0;
		   				}
					 lastyr_bill_rec_curmth_cntamt =  lastyr_bill_rec_curmth_cntamt+d_outst_amt;
				  }

				strcpy(ndlyr_episode_id.arr,d_episode_id.arr); 
				}
			}
        /*--------AMOUNT CANCELLED THIS MONTH FOR RECEIPT DATE LAST YEAR----------------------------*/
        if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 && strcmp(d_org_year.arr,nd_year.arr)!=0 && (strcmp(d_trx_type.arr,"CANC_RECEIPT")==0 || strcmp(d_trx_type.arr,"CANC_REFUND")==0 ))
           {
	         lastyr_rec_canc_curmth_amt=lastyr_rec_canc_curmth_amt+d_outst_amt;    
	         
			 	 if(strcmp(d_episode_id.arr,ndcly_episode_id.arr)==0 )
					lastyr_rec_canc_curmth_cntamt = lastyr_rec_canc_curmth_cntamt+d_outst_amt; 
				  else
				   {
				      if( lastyr_rec_canc_curmth_cntamt !=0 && lstrcnt>0)
						{
						 lastyr_rec_canc_curmth_cnt= lastyr_rec_canc_curmth_cnt+1;
						 lastyr_rec_canc_curmth_cntamt=0;
		   				}
					 lastyr_rec_canc_curmth_cntamt = lastyr_rec_canc_curmth_cntamt+d_outst_amt;
				  }

				   strcpy(ndcly_episode_id.arr,d_episode_id.arr);
				

	       }  	        
                            
  }   

}

calc_amount_out()
  {

   if(strcmp(d_episode_type.arr,"O")==0 || strcmp(d_episode_type.arr,"E")==0)
    {

       /*---------------------BILLED AMOUNT OF CURRENT MONTH--------------------------*/ 
	  if(strcmp(d_bill_mth.arr,nd_month_year.arr)==0 && strcmp(d_trx_type.arr,"BILL")==0)
			   {
				  if(strcmp(d_valid_for_out.arr,"Y")==0)
				   {
		             cur_mth_bill_amt=cur_mth_bill_amt+d_bill_tot_amt; 
					
			   	if(strcmp(d_episode_id.arr,ndb_episode_id.arr)==0 && strcmp(d_visit_id.arr,ndb_visit_id.arr)==0)
					 cur_mth_bill_cntamt =  cur_mth_bill_cntamt+d_bill_tot_amt; 
					else
				      {	   
                         if(cur_mth_bill_cntamt !=0 && bcnt >0)
						  {
					      cur_mth_bill_cnt=cur_mth_bill_cnt+1;
						  cur_mth_bill_cntamt=0;
						   }
				         cur_mth_bill_cntamt = cur_mth_bill_cntamt+d_bill_tot_amt; 
				      }
					   strcpy(ndb_episode_id.arr,d_episode_id.arr);  
                        strcpy(ndb_visit_id.arr,d_visit_id.arr);
                    }

	  	          }
      /*--------------BILLED TILL LAST MONTH AND CANCELLED THIS MONTH----------------*/
      if(strcmp(d_bill_mth.arr,nd_month_year.arr)!=0 && strcmp(d_trx_mth.arr,nd_month_year.arr)==0 && strcmp(d_trx_type.arr,"CANC-BILL")==0)
              {
	           cur_mth_bill_canc_amt=cur_mth_bill_canc_amt+d_bill_tot_amt;    
	            /*
				if(strcmp(d_episode_id.arr,nd_episode_id.arr)!=0 || strcmp(d_visit_id.arr,nd_visit_id.arr)!=0)
	              cur_mth_bill_canc_cnt=cur_mth_bill_canc_cnt+1;     
		      }*/
			   if(strcmp(d_episode_id.arr,ndlc_episode_id.arr)==0 && strcmp(d_visit_id.arr,ndlc_visit_id.arr)==0)
					 cur_mth_bill_canc_cntamt =  cur_mth_bill_canc_cntamt+d_bill_tot_amt; 
					else
				      {	   
                         if(cur_mth_bill_canc_cntamt !=0 && ccnt >0)
						  {
					      cur_mth_bill_canc_cnt=cur_mth_bill_canc_cnt+1;
						  cur_mth_bill_canc_cntamt=0;
						   }
				         cur_mth_bill_canc_cntamt =cur_mth_bill_canc_cntamt+d_bill_tot_amt; 
				      }
					   strcpy(ndlc_episode_id.arr,d_episode_id.arr);  
                        strcpy(ndlc_visit_id.arr,d_visit_id.arr);
              }

        /*--------------BILLED THIS MONTH AND RECEIPT THIS MONTH-------------------------*/
       if(strcmp(d_bill_mth.arr,nd_month_year.arr)==0 && strcmp(d_trx_mth.arr,nd_month_year.arr)==0 )                                                          
              {
			   if(strcmp(d_valid_for_out.arr,"Y")==0)
				 {
				  if(strcmp(d_trx_type.arr,"RECEIPT")==0 || strcmp(d_trx_type.arr,"REFUND")==0)
					{
	                  cur_mth_bill_rec_amt=cur_mth_bill_rec_amt+d_outst_amt;    
	                 /*  if(strcmp(d_episode_id.arr,ndr_episode_id.arr)!=0 || strcmp(d_visit_id.arr,ndr_visit_id.arr)!=0)
	                    cur_mth_bill_rec_cnt=cur_mth_bill_rec_cnt+1; 
					 strcpy(ndr_episode_id.arr,d_episode_id.arr);
					 strcpy(ndr_visit_id.arr,d_visit_id.arr);
					 */

			     if(strcmp(d_episode_id.arr,ndr_episode_id.arr)==0 && strcmp(d_visit_id.arr,ndr_visit_id.arr)==0)
			         cur_mth_bill_rec_cntamt =  cur_mth_bill_rec_cntamt+d_outst_amt; 
     			  else
				    {
						if(cur_mth_bill_rec_cntamt !=0 && brcnt>0)
						{
						  cur_mth_bill_rec_cnt=cur_mth_bill_rec_cnt+1;
						  cur_mth_bill_rec_cntamt=0;
						}
				       cur_mth_bill_rec_cntamt = cur_mth_bill_rec_cntamt+d_outst_amt; 
				     }
	             	 strcpy(ndr_episode_id.arr,d_episode_id.arr);
					 strcpy(ndr_visit_id.arr,d_visit_id.arr);
				   }

		        /*--------------OutStanding Amount-----------*/
           		   cur_mth_bill_outamt= cur_mth_bill_outamt+d_outst_amt;
                  if(strcmp(d_episode_id.arr,ndbr_episode_id.arr)==0 && strcmp(d_visit_id.arr,ndbr_visit_id.arr)==0)
				      cur_mth_bill_out_cntamt =  cur_mth_bill_out_cntamt+d_outst_amt; 
     			  else
				    {
						if(cur_mth_bill_out_cntamt !=0 && dcnt>0)
						{
						  cur_mth_bill_outcnt=cur_mth_bill_outcnt+1;
						  cur_mth_bill_out_cntamt=0;
						}
				    cur_mth_bill_out_cntamt = cur_mth_bill_out_cntamt+d_outst_amt; 
				   }
                  
				     strcpy(ndbr_episode_id.arr,d_episode_id.arr);
					 strcpy(ndbr_visit_id.arr,d_visit_id.arr);
               
	             }      
		     }
						/*===========ADJ EXM WRITE OFF=======*/
        if( strcmp(d_trx_mth.arr,nd_month_year.arr)==0 )                    
	     {
		   if(strcmp(d_valid_for_out.arr,"Y")==0)  
	         {
	            if( strcmp(d_trx_type.arr,"ADJ-BILL")==0 || strcmp(d_trx_type.arr,"CANC-ADJ-BILL")==0 || strcmp(d_trx_type.arr,"EXM-BILL")==0 || strcmp(d_trx_type.arr,"CAN-EXM-BILL")==0 || strcmp(d_trx_type.arr,"WRITEOFF")==0 || strcmp(d_trx_type.arr,"CAN-WRITEOFF")==0)
			   	{
	                  adj_wrt_exm_amt=adj_wrt_exm_amt+d_outst_amt; 

			     if(strcmp(d_episode_id.arr,ndawe_episode_id.arr)==0 && strcmp(d_visit_id.arr,ndawe_visit_id.arr)==0)
				      adj_wrt_exm_cntamt =  adj_wrt_exm_cntamt+d_outst_amt; 
     			  else
				   {
						if(adj_wrt_exm_cntamt !=0 && adjcnt>0)
						{
						  adj_wrt_exm_cnt=adj_wrt_exm_cnt+1;
						  adj_wrt_exm_cntamt=0;
						}
				     adj_wrt_exm_cntamt = adj_wrt_exm_cntamt+d_outst_amt; 
				   }

                     strcpy(ndadj_episode_id.arr,d_episode_id.arr);
					 strcpy(ndadj_visit_id.arr,d_visit_id.arr);
				}

             }
        }
      /*---------------RECEIPT TILL PREVIOUS MONTH AND CANCELLED THIS MONTH--------------*/
         if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 &&  strcmp(d_org_mth.arr,nd_month_year.arr)!=0 && (strcmp(d_trx_type.arr,"RECEIPT-CANC")==0 || strcmp(d_trx_type.arr,"REFUND-CANC")==0))                                                         
              {
	              prev_rec_cur_can_amt=prev_rec_cur_can_amt+d_outst_amt;    
	           
				  
				if(strcmp(d_episode_id.arr,ndrpc_episode_id.arr)==0 && strcmp(d_visit_id.arr,ndrpc_visit_id.arr)==0)
					prev_rec_cur_can_cntamt = prev_rec_cur_can_cntamt+d_outst_amt; 
				  else
				   {
				      if(prev_mth_curyr_out_cntamt!=0 && rpcnt>0)
						{
						 prev_rec_cur_can_cnt=prev_rec_cur_can_cnt+1;
						 prev_rec_cur_can_cntamt=0;
		   				}
					prev_rec_cur_can_cntamt = prev_rec_cur_can_cntamt+d_outst_amt; 
				  }

                strcpy(ndrpc_episode_id.arr,d_episode_id.arr);
			    strcpy(ndrpc_visit_id.arr,d_visit_id.arr);
    
		       }             
      /*---------------PREVIOUS MONTHS BILLS IN CURRENT YEAR--OUTSTANDING-----------------------*/
         if(strcmp(d_bill_mth.arr,nd_month_year.arr)!=0 &&  strcmp(d_bill_year.arr,nd_year.arr)==0 &&  strcmp(d_trx_mth.arr,nd_month_year.arr)!=0 )
           {
		     if(strcmp(d_valid_for_out.arr,"Y")==0)
		       {
				prev_mth_curyr_out_amt=prev_mth_curyr_out_amt+d_outst_amt;
	 			  if(strcmp(d_episode_id.arr,nd2_episode_id.arr)==0 && strcmp(d_visit_id.arr,nd2_visit_id.arr)==0)
					prev_mth_curyr_out_cntamt =  prev_mth_curyr_out_cntamt+d_outst_amt; 
				  else
				   {
				      if(prev_mth_curyr_out_cntamt!=0 && rcnt>0)
						{
						 prev_mth_curyr_out_cnt=prev_mth_curyr_out_cnt+1;
						 prev_mth_curyr_out_cntamt=0;
		   				}
					prev_mth_curyr_out_cntamt =  prev_mth_curyr_out_cntamt+d_outst_amt; 
				  }
				   strcpy(nd2_episode_id.arr,d_episode_id.arr);
			       strcpy(nd2_visit_id.arr,d_visit_id.arr);
			  }  
		   }
        /*------------AMOUNT COLLECTED THIS MTH FOR BILLS TILL PREVIOUS MONTH OF CURR YEAR--------- */                                             
         if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 &&  strcmp(d_bill_year.arr,nd_year.arr)==0 && strcmp(d_bill_mth.arr,nd_month_year.arr)!=0  && (strcmp(d_trx_type.arr,"RECEIPT")==0 || strcmp(d_trx_type.arr,"REFUND")==0 ))
             {
				if(strcmp(d_valid_for_out.arr,"Y")==0)
				  {
	                curmth_rec_for_curyr_prevmth_bill=curmth_rec_for_curyr_prevmth_bill+d_outst_amt;    

		       if(strcmp(d_episode_id.arr,ndpm_episode_id.arr)==0 && strcmp(d_visit_id.arr,ndpm_visit_id.arr)==0)
					cmth_rec_cyr_pmth_bl_cntamt = cmth_rec_cyr_pmth_bl_cntamt+d_outst_amt; 
				  else
				   {
				      if(cmth_rec_cyr_pmth_bl_cntamt !=0 && cpcnt>0)
						{
						cmth_rec_cyr_pmth_bl_cnt=cmth_rec_cyr_pmth_bl_cnt+1;
						 cmth_rec_cyr_pmth_bl_cntamt=0;
		   				}
					cmth_rec_cyr_pmth_bl_cntamt = cmth_rec_cyr_pmth_bl_cntamt+d_outst_amt; 
				  }

					strcpy(ndpm_episode_id.arr,d_episode_id.arr);
					strcpy(ndpm_visit_id.arr,d_visit_id.arr);
				  }
             } 
        /*---------RECEIPT CANCELLED THIS MTH FOR RECEIPTS TILL LAST MTH OF CURR YEAR-------------*/
         if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 &&  strcmp(d_org_year.arr,nd_year.arr)==0 && strcmp(d_org_mth.arr,nd_month_year.arr)!=0 && (strcmp(d_trx_type.arr,"CANC-RECEIPT")==0 || strcmp(d_trx_type.arr,"CANC-REFUND")==0))
                {
	             curyr_prev_mth_rec_canc_curmth=curyr_prev_mth_rec_canc_curmth+d_outst_amt;    


                  if(strcmp(d_episode_id.arr,ndcyr_episode_id.arr)==0 && strcmp(d_visit_id.arr,ndcyr_visit_id.arr)==0)
					curyr_prev_mth_rec_canc_curmth_cntamt = curyr_prev_mth_rec_canc_curmth_cntamt+d_outst_amt; 
				  else
				   {
				      if(curyr_prev_mth_rec_canc_curmth_cntamt !=0 && crcmcnt>0)
						{
						curyr_prev_mth_rec_canc_curmth_cnt=curyr_prev_mth_rec_canc_curmth_cnt+1;
						 curyr_prev_mth_rec_canc_curmth_cntamt=0;
		   				}
					curyr_prev_mth_rec_canc_curmth_cntamt = curyr_prev_mth_rec_canc_curmth_cntamt+d_outst_amt; 
				  }

                 strcpy(ndcyr_episode_id.arr,d_episode_id.arr);
					strcpy(ndcyr_visit_id.arr,d_visit_id.arr);

	             
	         	}

       /*---------AMOUNT COLLECTED THIS MONTH FOR BILLS TILL LAST YEAR---------------------------*/
                                                             
	     if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 && strcmp(d_bill_year.arr,nd_year.arr)!=0 && (strcmp(d_trx_type.arr,"RECEIPT")==0 || strcmp(d_trx_type.arr,"REFUND")==0 ))
           {
			  if(strcmp(d_valid_for_out.arr,"Y")==0)
			   {
	          lastyr_bill_rec_curmth_amt=lastyr_bill_rec_curmth_amt+d_outst_amt;    
	            if(strcmp(d_episode_id.arr,ndlyr_episode_id.arr)==0 && strcmp(d_visit_id.arr,ndlyr_visit_id.arr)==0)
					lastyr_bill_rec_curmth_cntamt = lastyr_bill_rec_curmth_cntamt+d_outst_amt; 
				  else
				   {
				      if( lastyr_bill_rec_curmth_cntamt !=0 && lstcnt>0)
						{
						 lastyr_bill_rec_curmth_cnt= lastyr_bill_rec_curmth_cnt+1;
						  lastyr_bill_rec_curmth_cntamt=0;
		   				}
					 lastyr_bill_rec_curmth_cntamt =  lastyr_bill_rec_curmth_cntamt+d_outst_amt;
				  }

				strcpy(ndlyr_episode_id.arr,d_episode_id.arr); 
				strcpy(ndlyr_visit_id.arr,d_visit_id.arr);
	           }
			}
        /*--------AMOUNT CANCELLED THIS MONTH FOR RECEIPT DATE LAST YEAR----------------------------*/
        if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 && strcmp(d_org_year.arr,nd_year.arr)!=0 && ( strcmp(d_trx_type.arr,"CANC_RECEIPT")==0 || strcmp(d_trx_type.arr,"CANC_REFUND")==0))
           {
	         lastyr_rec_canc_curmth_amt=lastyr_rec_canc_curmth_amt+d_outst_amt;    
	         
			 	 if(strcmp(d_episode_id.arr,ndcly_episode_id.arr)==0 && strcmp(d_visit_id.arr,ndcly_visit_id.arr)==0)
					lastyr_rec_canc_curmth_cntamt = lastyr_rec_canc_curmth_cntamt+d_outst_amt; 
				  else
				   {
				      if( lastyr_rec_canc_curmth_cntamt !=0 && lstrcnt>0)
						{
						 lastyr_rec_canc_curmth_cnt= lastyr_rec_canc_curmth_cnt+1;
						 lastyr_rec_canc_curmth_cntamt=0;
		   				}
					 lastyr_rec_canc_curmth_cntamt = lastyr_rec_canc_curmth_cntamt+d_outst_amt;
				  }

				   strcpy(ndcly_episode_id.arr,d_episode_id.arr);
					strcpy(ndcly_visit_id.arr,d_visit_id.arr);

	       }  	        
                            
     }   
  }

/*--------------------------------end of calc-amt-out---------------------------*/



calc_amount_ext()
  {
   if(strcmp(d_episode_type.arr,"R")==0 )
     {
     
       /*---------------------BILLED AMOUNT OF CURRENT MONTH--------------------------*/ 
	  if(strcmp(d_bill_mth.arr,nd_month_year.arr)==0 && strcmp(d_trx_type.arr,"BILL")==0)
			   {
				  if(strcmp(d_valid_for_out.arr,"Y")==0)
				   {
		             cur_mth_bill_amt=cur_mth_bill_amt+d_bill_tot_amt; 

  	    if(strcmp(d_patient_id.arr,ndb_patient_id.arr)==0 )
					 cur_mth_bill_cntamt =  cur_mth_bill_cntamt+d_bill_tot_amt; 
					else
				      {	   
                         if(cur_mth_bill_cntamt !=0 && bcnt >0)
						  {
					      cur_mth_bill_cnt=cur_mth_bill_cnt+1;
						  cur_mth_bill_cntamt=0;
						   }
				         cur_mth_bill_cntamt = cur_mth_bill_cntamt+d_bill_tot_amt; 
				      }
					   strcpy(d_patient_id.arr,ndb_patient_id.arr);  

	  	           }
			   }
      /*--------------BILLED TILL LAST MONTH AND CANCELLED THIS MONTH----------------*/
      if(strcmp(d_bill_mth.arr,nd_month_year.arr)!=0 && strcmp(d_trx_mth.arr,nd_month_year.arr)==0 && strcmp(d_trx_type.arr,"CANC-BILL")==0)
              {
	           cur_mth_bill_canc_amt=cur_mth_bill_canc_amt+d_bill_tot_amt;   
			   
			    if(strcmp(d_patient_id.arr,ndlc_patient_id.arr)==0 )
					 cur_mth_bill_canc_cntamt =  cur_mth_bill_canc_cntamt+d_bill_tot_amt; 
					else
				      {	   
                         if(cur_mth_bill_canc_cntamt !=0 && ccnt >0)
						  {
					      cur_mth_bill_canc_cnt=cur_mth_bill_canc_cnt+1;
						  cur_mth_bill_canc_cntamt=0;
						   }
				         cur_mth_bill_canc_cntamt =cur_mth_bill_canc_cntamt+d_bill_tot_amt; 
				      }
					   strcpy(ndlc_patient_id.arr,d_patient_id.arr);  

		      }
        /*--------------BILLED THIS MONTH AND RECEIPT THIS MONTH-------------------------*/
       if(strcmp(d_bill_mth.arr,nd_month_year.arr)==0 && strcmp(d_trx_mth.arr,nd_month_year.arr)==0 )                                                          
              {
			   if(strcmp(d_valid_for_out.arr,"Y")==0)
				 {
				  if(strcmp(d_trx_type.arr,"RECEIPT")==0 || strcmp(d_trx_type.arr,"REFUND")==0)
					{
	                  cur_mth_bill_rec_amt=cur_mth_bill_rec_amt+d_outst_amt;   		  

				if(strcmp(d_patient_id.arr,ndr_patient_id.arr)==0)
			         cur_mth_bill_rec_cntamt =  cur_mth_bill_rec_cntamt+d_outst_amt; 
     			  else
				    {
						if(cur_mth_bill_rec_cntamt !=0 && brcnt>0)
						{
						  cur_mth_bill_rec_cnt=cur_mth_bill_rec_cnt+1;
						  cur_mth_bill_rec_cntamt=0;
						}
				       cur_mth_bill_rec_cntamt = cur_mth_bill_rec_cntamt+d_outst_amt; 
				     }
	             	 strcpy(ndr_patient_id.arr,d_patient_id.arr);

	    		 }
		        /*--------------OutStanding Amount-----------*/
           		   cur_mth_bill_outamt= cur_mth_bill_outamt+d_outst_amt;

                      if(strcmp(d_patient_id.arr,ndbr_patient_id.arr)==0)
				      cur_mth_bill_out_cntamt =  cur_mth_bill_out_cntamt+d_outst_amt; 
     			  else
				    {
						if(cur_mth_bill_out_cntamt !=0 && dcnt>0)
						{
						  cur_mth_bill_outcnt=cur_mth_bill_outcnt+1;
						  cur_mth_bill_out_cntamt=0;
						}
				    cur_mth_bill_out_cntamt = cur_mth_bill_out_cntamt+d_outst_amt; 
				   }
                  
				     strcpy(ndbr_patient_id.arr,d_patient_id.arr);

	             }      
		     }
						/*===========ADJ EXM WRITE OFF=======*/
     
	 if( strcmp(d_trx_mth.arr,nd_month_year.arr)==0 )                    
	     {
		   if(strcmp(d_valid_for_out.arr,"Y")==0)  
	         {
	            if( strcmp(d_trx_type.arr,"ADJ-BILL")==0 || strcmp(d_trx_type.arr,"CANC-ADJ-BILL")==0 || strcmp(d_trx_type.arr,"EXM-BILL")==0 || strcmp(d_trx_type.arr,"CAN-EXM-BILL")==0 || strcmp(d_trx_type.arr,"WRITEOFF")==0 || strcmp(d_trx_type.arr,"CAN-WRITEOFF")==0)
			   	{
	                  adj_wrt_exm_amt=adj_wrt_exm_amt+d_outst_amt;  
					  
                    if(strcmp(d_patient_id.arr,ndawe_patient_id.arr)==0 )
				      adj_wrt_exm_cntamt =  adj_wrt_exm_cntamt+d_outst_amt; 
     			  else
				   {
						if(adj_wrt_exm_cntamt !=0 && adjcnt>0)
						{
						  adj_wrt_exm_cnt=adj_wrt_exm_cnt+1;
						  adj_wrt_exm_cntamt=0;
						}
				     adj_wrt_exm_cntamt = adj_wrt_exm_cntamt+d_outst_amt; 
				   }

                     strcpy(ndadj_patient_id.arr,d_patient_id.arr);

				}

             }
        }
      /*---------------RECEIPT TILL PREVIOUS MONTH AND CANCELLED THIS MONTH--------------*/
         if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 &&  strcmp(d_org_mth.arr,nd_month_year.arr)!=0 && (strcmp(d_trx_type.arr,"RECEIPT-CANC")==0 || strcmp(d_trx_type.arr,"REFUND-CANC")==0))                                                         
              {
	              prev_rec_cur_can_amt=prev_rec_cur_can_amt+d_outst_amt; 
		  
           if(strcmp(d_patient_id.arr,ndrpc_patient_id.arr)==0 )
					prev_rec_cur_can_cntamt = prev_rec_cur_can_cntamt+d_outst_amt; 
				  else
				   {
				      if(prev_mth_curyr_out_cntamt!=0 && rpcnt>0)
						{
						 prev_rec_cur_can_cnt=prev_rec_cur_can_cnt+1;
						 prev_rec_cur_can_cntamt=0;
		   				}
					 prev_rec_cur_can_cntamt = prev_rec_cur_can_cntamt+d_outst_amt; 
				  }

                strcpy(ndrpc_patient_id.arr,d_patient_id.arr);
  
		       }      
			   
      /*---------------PREVIOUS MONTHS BILLS IN CURRENT YEAR--OUTSTANDING-----------------------*/
         if(strcmp(d_bill_mth.arr,nd_month_year.arr)!=0 &&  strcmp(d_bill_year.arr,nd_year.arr)==0 &&  strcmp(d_trx_mth.arr,nd_month_year.arr)!=0 )
           {
		     if(strcmp(d_valid_for_out.arr,"Y")==0)
		       {
				prev_mth_curyr_out_amt=prev_mth_curyr_out_amt+d_outst_amt;
	 			  if(strcmp(d_patient_id.arr,nd2_patient_id.arr)==0)
					prev_mth_curyr_out_cntamt =  prev_mth_curyr_out_cntamt+d_outst_amt; 
				  else
				   {
				      if(prev_mth_curyr_out_cntamt!=0 && rcnt>0)
						{
						 prev_mth_curyr_out_cnt=prev_mth_curyr_out_cnt+1;
						 prev_mth_curyr_out_cntamt=0;
		   				}
					prev_mth_curyr_out_cntamt =  prev_mth_curyr_out_cntamt+d_outst_amt; 
				  }
			  }  
		   }
        /*------------AMOUNT COLLECTED THIS MTH FOR BILLS TILL PREVIOUS MONTH OF CURR YEAR--------- */                                             
         if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 &&  strcmp(d_bill_year.arr,nd_year.arr)==0 && strcmp(d_bill_mth.arr,nd_month_year.arr)!=0  && (strcmp(d_trx_type.arr,"RECEIPT")==0 || strcmp(d_trx_type.arr,"REFUND")==0 ))
             {
				if(strcmp(d_valid_for_out.arr,"Y")==0)
				  {
	                curmth_rec_for_curyr_prevmth_bill=curmth_rec_for_curyr_prevmth_bill+d_outst_amt;
					
           if(strcmp(d_patient_id.arr,ndpm_patient_id.arr)==0 )
					cmth_rec_cyr_pmth_bl_cntamt = cmth_rec_cyr_pmth_bl_cntamt+d_outst_amt; 
				  else
				   {
				      if(cmth_rec_cyr_pmth_bl_cntamt !=0 && cpcnt>0)
						{
						cmth_rec_cyr_pmth_bl_cnt=cmth_rec_cyr_pmth_bl_cnt+1;
						 cmth_rec_cyr_pmth_bl_cntamt=0;
		   				}
					cmth_rec_cyr_pmth_bl_cntamt = cmth_rec_cyr_pmth_bl_cntamt+d_outst_amt; 
				  }

					strcpy(ndpm_patient_id.arr,d_patient_id.arr);

				  }
             } 
        /*---------RECEIPT CANCELLED THIS MTH FOR RECEIPTS TILL LAST MTH OF CURR YEAR-------------*/
         if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 &&  strcmp(d_org_year.arr,nd_year.arr)==0 && strcmp(d_org_mth.arr,nd_month_year.arr)!=0 && (strcmp(d_trx_type.arr,"CANC-RECEIPT")==0  || strcmp(d_trx_type.arr,"CANC-REFUND")==0 )) 
                {
	             curyr_prev_mth_rec_canc_curmth=curyr_prev_mth_rec_canc_curmth+d_outst_amt;  
				 
          if(strcmp(d_patient_id.arr,ndcyr_patient_id.arr)==0 )
					curyr_prev_mth_rec_canc_curmth_cntamt = curyr_prev_mth_rec_canc_curmth_cntamt+d_outst_amt; 
				  else
				   {
				      if(curyr_prev_mth_rec_canc_curmth_cntamt !=0 && crcmcnt>0)
						{
						curyr_prev_mth_rec_canc_curmth_cnt=curyr_prev_mth_rec_canc_curmth_cnt+1;
						 curyr_prev_mth_rec_canc_curmth_cntamt=0;
		   				}
					curyr_prev_mth_rec_canc_curmth_cntamt = curyr_prev_mth_rec_canc_curmth_cntamt+d_outst_amt; 
				  }

                 strcpy(ndcyr_patient_id.arr,d_patient_id.arr);
  
	         	}
       /*---------AMOUNT COLLECTED THIS MONTH FOR BILLS TILL LAST YEAR---------------------------*/
                                                             
	     if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 && strcmp(d_bill_year.arr,nd_year.arr)!=0 &&( strcmp(d_trx_type.arr,"RECEIPT")==0 || strcmp(d_trx_type.arr,"REFUND")==0))
           {
			  if(strcmp(d_valid_for_out.arr,"Y")==0)
			   {
	            lastyr_bill_rec_curmth_amt=lastyr_bill_rec_curmth_amt+d_outst_amt; 
				
              if(strcmp(d_patient_id.arr,ndlyr_patient_id.arr)==0 )
					lastyr_bill_rec_curmth_cntamt = lastyr_bill_rec_curmth_cntamt+d_outst_amt; 
				  else
				   {
				      if( lastyr_bill_rec_curmth_cntamt !=0 && lstcnt>0)
						{
						 lastyr_bill_rec_curmth_cnt= lastyr_bill_rec_curmth_cnt+1;
						  lastyr_bill_rec_curmth_cntamt=0;
		   				}
					 lastyr_bill_rec_curmth_cntamt =  lastyr_bill_rec_curmth_cntamt+d_outst_amt;
				  }

				strcpy(ndlyr_patient_id.arr,d_patient_id.arr); 

	           }
			}
        /*--------AMOUNT CANCELLED THIS MONTH FOR RECEIPT DATE LAST YEAR----------------------------*/
        if(strcmp(d_trx_mth.arr,nd_month_year.arr)==0 && strcmp(d_org_year.arr,nd_year.arr)!=0 && (strcmp(d_trx_type.arr,"CANC_RECEIPT")==0 || strcmp(d_trx_type.arr,"CANC_REFUND")==0) )
           {
	         lastyr_rec_canc_curmth_amt=lastyr_rec_canc_curmth_amt+d_outst_amt;  
			 
           if(strcmp(d_patient_id.arr,ndcly_patient_id.arr)==0 )
					lastyr_rec_canc_curmth_cntamt = lastyr_rec_canc_curmth_cntamt+d_outst_amt; 
				  else
				   {
				      if( lastyr_rec_canc_curmth_cntamt !=0 && lstrcnt>0)
						{
						 lastyr_rec_canc_curmth_cnt= lastyr_rec_canc_curmth_cnt+1;
						 lastyr_rec_canc_curmth_cntamt=0;
		   				}
					 lastyr_rec_canc_curmth_cntamt = lastyr_rec_canc_curmth_cntamt+d_outst_amt;
				  }

				   strcpy(ndcly_patient_id.arr,d_patient_id.arr);

  
	       }  	        
                            
     } 
 }

    /*---------------------End External patients Calculation-------------*/
initialise_var()
{

ndpm_ind=0;

	cur_mth_bill_cnt=0;
	cur_mth_bill_canc_cnt=0;
	cur_mth_bill_rec_cnt=0;
	cur_mth_bill_outcnt=0;
	prev_rec_cur_can_cnt=0;
	prev_mth_curyr_out_cnt=0;
	cmth_rec_cyr_pmth_bl_cnt=0;
	curyr_prev_mth_rec_canc_curmth_cnt=0;
	lastyr_bill_rec_curmth_cnt=0;
	lastyr_rec_canc_curmth_cnt=0;
	adj_wrt_exm_cnt=0;
     	


        cur_mth_bill_amt=0;
		cur_mth_bill_canc_amt=0;
		cur_mth_bill_rec_amt=0;
		cur_mth_bill_outamt=0;
		prev_rec_cur_can_amt=0;
		prev_mth_curyr_out_amt=0;
		curmth_rec_for_curyr_prevmth_bill=0;
		curyr_prev_mth_rec_canc_curmth=0;
		lastyr_bill_rec_curmth_amt=0;
		lastyr_rec_canc_curmth_amt=0;
		adj_wrt_exm_amt=0;

	    prev_mth_curyr_out_cntamt=0;
		cmth_rec_cyr_pmth_bl_cntamt=0;
		curyr_prev_mth_rec_canc_curmth_cntamt=0;
		lastyr_bill_rec_curmth_cntamt=0;
		lastyr_rec_canc_curmth_cntamt=0;
		prev_rec_cur_can_cntamt=0;
		cur_mth_bill_out_cntamt=0;
		adj_wrt_exm_cntamt=0;
		cur_mth_bill_rec_cntamt=0;
		cur_mth_bill_canc_cntamt=0;
		cur_mth_bill_cntamt=0;
	




            strcpy(nd1_patient_id.arr," ");		
			strcpy(nd2_patient_id.arr," ");		
			strcpy(nd_patient_id.arr," ");			
			strcpy(ndr_patient_id.arr," ");			
			strcpy(ndcly_patient_id.arr," ");		
			strcpy(ndcyr_patient_id.arr," ");		
			strcpy(ndrpc_patient_id.arr," ");		
			strcpy(ndadj_patient_id.arr," ");		
			strcpy(ndbr_patient_id.arr," ");			
			strcpy(ndpm_patient_id.arr," ");			
			strcpy(ndlyr_patient_id.arr," ");		
			strcpy(ndawe_patient_id.arr," ");		
			strcpy(ndb_patient_id.arr," ");		
			strcpy(ndlc_patient_id.arr," ");
			
			
			strcpy(nd1_episode_id.arr," ");		
			strcpy(nd2_episode_id.arr," ");		
			strcpy(nd_episode_id.arr," ");			
			strcpy(ndr_episode_id.arr," ");			
			strcpy(ndcly_episode_id.arr," ");		
			strcpy(ndcyr_episode_id.arr," ");		
			strcpy(ndrpc_episode_id.arr," ");		
			strcpy(ndadj_episode_id.arr," ");		
			strcpy(ndbr_episode_id.arr," ");			
			strcpy(ndpm_episode_id.arr," ");			
			strcpy(ndlyr_episode_id.arr," ");		
			strcpy(ndawe_episode_id.arr," ");		
			strcpy(ndb_episode_id.arr," ");		
			strcpy(ndlc_episode_id.arr," ");
			
			strcpy(nd1_visit_id.arr," ");		
			strcpy(nd2_visit_id.arr," ");		
			strcpy(nd_visit_id.arr," ");			
			strcpy(ndr_visit_id.arr," ");			
			strcpy(ndcly_visit_id.arr," ");		
			strcpy(ndcyr_visit_id.arr," ");		
			strcpy(ndrpc_visit_id.arr," ");		
			strcpy(ndadj_visit_id.arr," ");		
			strcpy(ndbr_visit_id.arr," ");			
			strcpy(ndpm_visit_id.arr," ");			
			strcpy(ndlyr_visit_id.arr," ");		
			strcpy(ndawe_visit_id.arr," ");		
			strcpy(ndb_visit_id.arr," ");		
			strcpy(ndlc_visit_id.arr," ");		

//ndr_visit_id=0;

}


initialise_tot()
 {
 
tot_cur_mth_bill_cnt=0;
tot_cur_mth_bill_amt=0;

tot_cur_mth_bill_canc_cnt=0;
tot_cur_mth_bill_canc_amt=0;

tot_cur_mth_bill_rec_cnt=0;
tot_cur_mth_bill_rec_amt=0;

tot_prev_rec_cur_can_cnt=0;
tot_prev_rec_cur_can_amt=0;

tot_adj_wrt_exm_cnt=0;
tot_adj_wrt_exm_amt=0;

tot_cur_mth_bill_outcnt=0;
tot_cur_mth_bill_outamt=0;

tot_prev_mth_curyr_out_cnt=0;
tot_prev_mth_curyr_out_amt=0;

tot_cmth_rec_cyr_pmth_bl_cnt=0;
tot_curmth_rec_for_curyr_prevmth_bill=0;

tot_curyr_prev_mth_rec_canc_curmth_cnt=0;
tot_curyr_prev_mth_rec_canc_curmth=0;

tot_lastyr_bill_rec_curmth_cnt=0;
tot_lastyr_bill_rec_curmth_amt=0;

tot_lastyr_rec_canc_curmth_cnt=0;
tot_lastyr_rec_canc_curmth_amt=0;
}

 print_blng_cat()
  {
   //l_count += 1;
  //fetch_blng_grp_catg();
  check_line(2);
   if (nd_proc_yn == 'C') 
	fprintf(fp,"%-30s",nd_description.arr);
	//else
	//{

    /*EXEC SQL insert into bl_temp_report(OPERATING_FACILITY_ID,PGM_ID,SESSION_ID,
						 	PGM_DATE, REC_TYPE,LINE_NUM,desc1)
						values(:nd_facility,:d_curr_pgm_name,:nd_session_id,:nd_pgm_date,2,
				  		 :l_count,:nd_description);
						 EXEC SQL COMMIT;*/
	//}
 
  }

 print_blng_cat1()
  {
  fetch_blng_grp_catg1();
	fprintf(fp,"%-30s",nd_description.arr);
  }

fetch_bed_clinic()
 {
 bed_clin_desc.arr[0] = '\0';
 bed_clin_desc.len    = 0;

  if(strcmp(nd_det_option.arr,"DI")==0)
     {
    /* EXEC SQL Select nvl(SHORT_DESC,'***') into :bed_clin_desc from IP_BED_CLASS where
	 BED_CLASS_CODE =:nd_bed_clinic_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select nvl(SHORT_DESC,'***') into :b0  from IP_BED_CLASS \
where BED_CLASS_CODE=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )138;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&bed_clin_desc;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_bed_clinic_code;
    sqlstm.sqhstl[1] = (unsigned int  )10;
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
  else if(strcmp(nd_det_option.arr,"EM")==0)
     {
	    /* EXEC SQL Select nvl(SHORT_DESC,'***') into :bed_clin_desc from OP_CLINIC_HIS_VW where
	       FACILITY_ID=:nd_facility
		   AND CLINIC_CODE =:nd_bed_clinic_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 16;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select nvl(SHORT_DESC,'***') into :b0  from OP_CLINIC_HI\
S_VW where (FACILITY_ID=:b1 and CLINIC_CODE=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )161;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&bed_clin_desc;
     sqlstm.sqhstl[0] = (unsigned int  )18;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_facility;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_bed_clinic_code;
     sqlstm.sqhstl[2] = (unsigned int  )10;
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


	 }
  else
   strcpy(bed_clin_desc.arr,"***");

 bed_clin_desc.arr[bed_clin_desc.len] = '\0';

 }


 print_bed_clinic()
  {

    next_line(1);

   	 if(strcmp(nd_bed_clinic_code.arr,"**")==0)
	 {
	   			 if (nd_proc_yn == 'C') 
	 fprintf(fp,"%-15s","**");
	 }
	else
	 {
	  fetch_bed_clinic();
	    			 if (nd_proc_yn == 'C') 
			 	  fprintf(fp,"%-15s",bed_clin_desc.arr);
	  }
	
  }

sum_header()
  {
  			 if (nd_proc_yn == 'C') 
			 {
  next_line(8);
    print_line('-',52);
	if(strcmp(nd_sum_option.arr,"DI")==0 )
      fprintf(fp,"%22s",loc_legend[31]);
   else if(strcmp(nd_sum_option.arr,"EM")==0 )
       fprintf(fp,"%22s",loc_legend[30]);
   else
     fprintf(fp,"%22s",loc_legend[32]);

    fprintf(fp,"%15s",loc_legend[17]);
     fprintf(fp,"%15s",loc_legend[18]);
	 next_line(1);
       print_line('-',52);
	   }
   }

print_sum()
 {
 if(nd_proc_yn=='C')
{
     fprintf(fp,"%22s",loc_legend[28]);
    fprintf(fp,"%15d",sum_no_enctr_cnt);
	print_formated(sum_no_enctr_amt);
   next_line(1);
   fprintf(fp,"%22s",loc_legend[29]);
	 fprintf(fp,"%15d",sum_ot_enctr_cnt);
	print_formated(sum_ot_enctr_amt);
     
	next_line(1);
	 print_line('-',52);
     fprintf(fp,"%22s",loc_legend[23]);
	 fprintf(fp,"%15d",sum_ot_enctr_cnt+sum_no_enctr_cnt);
	print_formated(sum_ot_enctr_amt+sum_no_enctr_amt);
	next_line(1);
   print_line('-',52);
}
else
  {
    lc_count += 1;	


    /* EXEC SQL insert into bl_temp_report(OPERATING_FACILITY_ID,
	PGM_ID,
	SESSION_ID,
	PGM_DATE, 
	REC_TYPE,
	LINE_NUM,
	value1,
	value2,
	value3,
	value4,
	value5,
	value6)
	values(:nd_facility,
	:d_curr_pgm_name,
	:nd_session_id,
	:nd_pgm_date,
	1,
	:lc_count,
	:sum_no_enctr_cnt,
	:sum_no_enctr_amt,
	:sum_ot_enctr_cnt,
	:sum_ot_enctr_amt,
	:sum_ot_enctr_cnt+:sum_no_enctr_cnt,
	:sum_ot_enctr_amt+:sum_no_enctr_amt); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into bl_temp_report (OPERATING_FACILITY_ID,PGM_ID,\
SESSION_ID,PGM_DATE,REC_TYPE,LINE_NUM,value1,value2,value3,value4,value5,value\
6) values (:b0,:b1,:b2,:b3,1,:b4,:b5,:b6,:b7,:b8,(:b7+:b5),(:b8+:b6))";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )188;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_facility;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_curr_pgm_name;
    sqlstm.sqhstl[1] = (unsigned int  )17;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[3] = (unsigned int  )27;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&lc_count;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&sum_no_enctr_cnt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&sum_no_enctr_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&sum_ot_enctr_cnt;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&sum_ot_enctr_amt;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&sum_ot_enctr_cnt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&sum_no_enctr_cnt;
    sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&sum_ot_enctr_amt;
    sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&sum_no_enctr_amt;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
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


		/* EXEC SQL COMMIT; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )255;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   	}  
 }


print_det()
{
if(nd_proc_yn=='C')
{
 


                           /*====== BILLED AMOUNT OF CURRENT MONTH=======*/


	fprintf(fp,"%7d",cur_mth_bill_cnt);
	print_formated(cur_mth_bill_amt);

     if(strcmp(nd_break_up.arr,"P")==0)
	    {          
                 /*====== BILLED TILL LAST MONTH AND CANCELLED THIS MONTH=======*/

	fprintf(fp,"%8d",cur_mth_bill_canc_cnt);
	print_formated(cur_mth_bill_canc_amt);
	   }

                      /*======BILLED THIS MONTH AND RECEIPT THIS MONTH=======*/

	fprintf(fp,"%8d",cur_mth_bill_rec_cnt);
	print_formated(cur_mth_bill_rec_amt);


if(strcmp(nd_break_up.arr,"P")==0)
	    { 
                /*======RECEIPT TILL PREVIOUS MONTH AND CANCELLED THIS MONTH=======*/

	fprintf(fp,"%8d",prev_rec_cur_can_cnt);
	print_formated(prev_rec_cur_can_amt);

     }

      
	  if(strcmp(nd_inc_exadwo.arr,"Y")==0)
	    {        
			                 /*======EXEMPTION-ADJUSTMENT-WRITEOFF=======*/

	fprintf(fp,"%8d",adj_wrt_exm_cnt);
	print_formated(adj_wrt_exm_amt);
	    }

				//---------------------------------------------------
				     //---------****OUTSTANDING BILLS****--------
				//---------------------------------------------------

                  /*======CURR MONTH OUTSTANDING(BILL&RECEIPT CURRENT MONTH)=====*/

	fprintf(fp,"%8d",cur_mth_bill_outcnt);
	print_formated(cur_mth_bill_outamt);

				/*========PREVIOUS MONTHS BILLS IN CURRENT YEAR--OUTSTANDING=====*/

	fprintf(fp,"%8d",prev_mth_curyr_out_cnt);
	print_formated(prev_mth_curyr_out_amt);
                       
                  /*========AMOUNT COLLECTED THIS MTH FOR BILLS TILL PREVIOUS MONTH OF CURR YEAR-=====*/             

	fprintf(fp,"%8d",cmth_rec_cyr_pmth_bl_cnt);
	print_formated(curmth_rec_for_curyr_prevmth_bill);

	if(strcmp(nd_break_up.arr,"P")==0)
	    { 

				/*========RECEIPT CANCELLED THIS MTH FOR RECEIPTS TILL LAST MTH OF CURR YEAR ========*/


	fprintf(fp,"%8d",curyr_prev_mth_rec_canc_curmth_cnt);
	print_formated(curyr_prev_mth_rec_canc_curmth);

          }

                       /*========AMOUNT COLLECTED THIS MONTH FOR BILLS TILL LAST YEAR========*/

	fprintf(fp,"%8d",lastyr_bill_rec_curmth_cnt);
	print_formated(lastyr_bill_rec_curmth_amt);
	 

	 if(strcmp(nd_break_up.arr,"P")==0)
	    { 

                      /*========AMOUNT CANCELLED THIS MONTH FOR RECEIPT DATE LAST YEAR========*/

	    fprintf(fp,"%8d",lastyr_rec_canc_curmth_cnt);
	    print_formated(lastyr_rec_canc_curmth_amt);

	   }

  }
  else
  {

    l_count += 1;	


    /* EXEC SQL insert into bl_temp_report(OPERATING_FACILITY_ID,
	PGM_ID,
	SESSION_ID,
	PGM_DATE, 
	REC_TYPE,
	LINE_NUM,
	desc1,
	desc2,
	value1,
	value2,
	value3,
	value4,
	value5,
	value6,
	value7,
	value8,
	value9,
	value10,
	value11,
	value12)
	values(:nd_facility,
	:d_curr_pgm_name,
	:nd_session_id,
	:nd_pgm_date,
	2,
	:l_count,
	:nd_description,
	decode(:nd_bed_clinic_code,'**','**Not Specified**',nvl(:bed_clin_desc,'**')),
	:cur_mth_bill_cnt,
	:cur_mth_bill_amt,
	:cur_mth_bill_rec_cnt,
	:cur_mth_bill_rec_amt,
	:cur_mth_bill_outcnt,
	:cur_mth_bill_outamt,
	:prev_mth_curyr_out_cnt,
	:prev_mth_curyr_out_amt,
	:cmth_rec_cyr_pmth_bl_cnt,
	:curmth_rec_for_curyr_prevmth_bill,
	:lastyr_bill_rec_curmth_cnt,
	:lastyr_bill_rec_curmth_amt); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into bl_temp_report (OPERATING_FACILITY_ID,PGM_ID,\
SESSION_ID,PGM_DATE,REC_TYPE,LINE_NUM,desc1,desc2,value1,value2,value3,value4,\
value5,value6,value7,value8,value9,value10,value11,value12) values (:b0,:b1,:b\
2,:b3,2,:b4,:b5,decode(:b6,'**','**Not Specified**',nvl(:b7,'**')),:b8,:b9,:b1\
0,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )270;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_facility;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_curr_pgm_name;
    sqlstm.sqhstl[1] = (unsigned int  )17;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[3] = (unsigned int  )27;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&l_count;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_description;
    sqlstm.sqhstl[5] = (unsigned int  )33;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_bed_clinic_code;
    sqlstm.sqhstl[6] = (unsigned int  )10;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&bed_clin_desc;
    sqlstm.sqhstl[7] = (unsigned int  )18;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&cur_mth_bill_cnt;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&cur_mth_bill_amt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&cur_mth_bill_rec_cnt;
    sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&cur_mth_bill_rec_amt;
    sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&cur_mth_bill_outcnt;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&cur_mth_bill_outamt;
    sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&prev_mth_curyr_out_cnt;
    sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&prev_mth_curyr_out_amt;
    sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&cmth_rec_cyr_pmth_bl_cnt;
    sqlstm.sqhstl[16] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&curmth_rec_for_curyr_prevmth_bill;
    sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&lastyr_bill_rec_curmth_cnt;
    sqlstm.sqhstl[18] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&lastyr_bill_rec_curmth_amt;
    sqlstm.sqhstl[19] = (unsigned int  )sizeof(double);
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


						 /* EXEC SQL COMMIT; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 20;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )365;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


  }

 }
 
    
print_head()
 {

  fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style */
 
  print_page_title();
   
   fprintf(fp,"%16s%18s      %18s%41s%15s"," ",loc_legend[9],loc_legend[10]," ",loc_legend[11]);
   next_line(1);
   print_line('-',REP_WIDTH); 
   fprintf(fp,"%-12s/%60s%4s%18s%18s%40s",loc_legend[7]," "," ",loc_legend[12]," ",loc_legend[13]);
   next_line(1);
   fprintf(fp,"%c(s14H",ESC); 	
    fprintf(fp,"%60s"," "); print_line('-',REP_WIDTH-60); 
   fprintf(fp,"%-14s%14s%8s%14s  %8s       %14s   %24s  %24s  %20s     ",loc_legend[8],loc_legend[17],loc_legend[18],loc_legend[17],loc_legend[18],loc_legend[19],loc_legend[20],loc_legend[20],loc_legend[22]);
 next_line(1);
   fprintf(fp,"                                                                                              %12s             %12s     ",loc_legend[21],loc_legend[21]);
   next_line(1);
      fprintf(fp,"%60s"," ");print_line('-',REP_WIDTH-60);
   fprintf(fp,"                                                           %14s   %8s%14s  %8s  %14s%8s%14s  %8s  ",loc_legend[17],loc_legend[18],loc_legend[17],loc_legend[18],loc_legend[17],loc_legend[18],loc_legend[17],loc_legend[18]);
   next_line(1);
  print_line('-',REP_WIDTH); 
     
fprintf(fp,"%c(s-3B",ESC); 


 }  


print_first_page()
{
 if (nd_proc_yn == 'C') 
  {
print_page_title();

//    fprintf(fp,"\nVER : 4.1\n");
   	fprintf(fp,"\n\n\n                   INPUT PARAMETERS :\n\n");

  	fprintf(fp,"%35s : %-s\n\n",loc_legend[33],nd_pg_month.arr);

	if(strcmp(nd_det_option.arr,"DI")==0)
	 fprintf(fp,"%35s : %-s\n\n",loc_legend[34],loc_legend[14]); 
	if(strcmp(nd_det_option.arr,"EM")==0)
	 fprintf(fp,"%35s : %-s\n\n",loc_legend[34],loc_legend[15]);
    if(strcmp(nd_det_option.arr,"EX")==0)
	 fprintf(fp,"%35s : %-s\n\n",loc_legend[34],loc_legend[16]);
    
	
	if(strcmp(nd_sum_option.arr,"DI")==0)
	 fprintf(fp,"%35s : %-s\n\n",loc_legend[35],loc_legend[14]); 
	if(strcmp(nd_sum_option.arr,"EM")==0)
	 fprintf(fp,"%35s : %-s\n\n",loc_legend[35],loc_legend[15]);
    if(strcmp(nd_sum_option.arr,"EX")==0)
	 fprintf(fp,"%35s : %-s\n\n",loc_legend[35],loc_legend[16]);

 
	if(strcmp(nd_break_up.arr,"C")==0)
	 fprintf(fp,"%35s : %-s\n\n",loc_legend[36],loc_legend[41]); 
	if(strcmp(nd_break_up.arr,"P")==0)
	 fprintf(fp,"%35s : %-s\n\n",loc_legend[36],loc_legend[39]);
    if(strcmp(nd_break_up.arr,"N")==0)
	 fprintf(fp,"%35s : %-s\n\n",loc_legend[36],loc_legend[40]);

 
   if(strcmp(nd_excl_dep.arr,"Y")==0)
	fprintf(fp,"%35s : %-s\n\n",loc_legend[37],"YES");  
    else
   fprintf(fp,"%35s : %-s\n\n",loc_legend[37],"NO");  


	if(strcmp(nd_excl_ref.arr,"Y")==0)
	fprintf(fp,"%35s : %-s\n\n",loc_legend[38],"YES");
	else
     fprintf(fp,"%35s : %-s\n\n",loc_legend[38],"NO");
   


// ADDED 23/05/06

	if(strcmp(nd_exc_adj.arr,"Y")==0)
	  fprintf(fp,"%35s : %-s\n\n",loc_legend[45],"YES");
	else
      fprintf(fp,"%35s : %-s\n\n",loc_legend[45],"NO");


	if(strcmp(nd_exc_exmp.arr,"Y")==0)
	  fprintf(fp,"%35s : %-s\n\n",loc_legend[46],"YES");
	else
      fprintf(fp,"%35s : %-s\n\n",loc_legend[46],"NO");

	 if(strcmp(nd_exc_writeoff.arr,"Y")==0)
	  fprintf(fp,"%35s : %-s\n\n",loc_legend[47],"YES");
	else
      fprintf(fp,"%35s : %-s\n\n",loc_legend[47],"NO");




//   
	fprintf(fp,"%35s : %-s\n",loc_legend[43],loc_legend[42]);  
  } 
    next_page(); 
	  

}
 	    
declare_cursor()
 {

 /* EXEC SQL DECLARE BILL_DCP_DTL_CUR CURSOR FOR 
 SELECT nvl(c.blng_grp_catg,'**'),
        DECODE(:nd_det_option,'DI',nvl(a.bed_class_code,'**'),'EM',NVL(a.clinic_code,'**'),'**'),
        a.episode_type, to_char(a.episode_id), 
        to_char(a.visit_id),a.doc_type_code,a.doc_num,b.trx_type,b.doc_date trx_date,
        b.org_doc_date,A.DOC_DATE BILL_DATE,
        a.patient_id,blcommon.get_reln_code(a.patient_id) citizen,
        a.bill_amt,nvl(b.debit_amt,0)-nvl(b.credit_amt,0)outst_amt,
	trx_nature_code,
	to_char(a.doc_date,'MON-YYYY')MTH,
        to_char(a.doc_date,'YYYY')YER,
	to_char(B.doc_date,'MON-YYYY')TRXMTH,
        to_char(B.doc_date,'YYYY')TRXYER, 
	to_char(b.org_doc_date,'MON-YYYY')ORGMTH,
        to_char(b.org_doc_date,'YYYY')ORGYER,
	//b.VALID_FOR_OUTSTDG_YN
	DECODE(A.BILL_STATUS,'C','N','Y')
 FROM bl_bill_dcp_dtl_temp a, bl_patient_statement_temp b,
         bl_blng_grp_by_catg c
 WHERE b.operating_facility_id = :nd_facility
 AND   b.doc_date <= TO_DATE(TO_CHAR(LAST_DAY(TO_DATE(:nd_month_year,'MON-YYYY')),'DD/MM/YYYY')||' 23:59:59','DD/MM/YYYY HH24:MI:SS')
 and  a.doc_date <= TO_DATE(TO_CHAR(LAST_DAY(TO_DATE(:nd_month_year,'MON-YYYY')),'DD/MM/YYYY')||' 23:59:59','DD/MM/YYYY HH24:MI:SS')
 AND a.operating_facility_id =  :nd_facility
 AND a.doc_type_code = nvl(b.adj_doc_type_code,b.doc_type_code)
 AND a.doc_num = nvl(b.adj_doc_num,b.doc_number)
 AND a.blng_grp_id = c.blng_grp_id(+)
 AND (A.EPISODE_TYPE =decode(:nd_det_option,'DI','I','EM','O','R')
     OR
      A.EPISODE_TYPE =decode(:nd_det_option,'DI','D','EM','E','R')
      )   
 AND B.document_nature IN('BI','DC')
 AND A.BILL_TOT_AMT>0
 AND TRX_NATURE_CODE NOT IN (DECODE(:nd_excl_dep,'Y','AD','XX'),DECODE(:nd_excl_dep,'Y','PR','XX'))
 //AND DECODE(B.TRX_TYPE,'BILL',SIGN(NVL(b.debit_amt,0)-nvl(b.credit_amt,0)),0) >=0
 AND B.TRX_TYPE NOT IN(DECODE(:nd_excl_ref,'Y','REFUND','XX'),DECODE(:nd_excl_ref,'Y','CANC-REFUND','XX'))
 AND (
       (NVL(:nd_exc_adj,'Y')='Y' and NVL(BILL_TOT_ADJUST_AMT,0) =0)
	   or 
      NVL(:nd_exc_adj,'Y')='N')
 AND  (
       (NVL(:nd_exc_exmp,'Y')='Y' and NVL(BILL_TOT_EXEMPT_AMT,0) =0)
	   or 
      NVL(:nd_exc_exmp,'Y')='N')
 AND  (
       (NVL(:nd_exc_writeoff,'Y')='Y' and NVL(BILL_TOT_WRITE_OFF_AMT,0) =0)
	   or 
      NVL(:nd_exc_writeoff,'Y')='N')
 UNION ALL
      SELECT a.blng_grp_catg,
        b.bed_class_code,
	'I', '0', 
	'0','~~~',0,'~~~',
	SYSDATE,SYSDATE,SYSDATE,
        '~~~','~~~',
        0,0,'~~~',
	TO_CHAR(SYSDATE,'MON-YYYY')MTH,
        TO_CHAR(SYSDATE,'YYYY')YER,
	TO_CHAR(SYSDATE,'MON-YYYY')TRXMTH,
        TO_CHAR(SYSDATE,'YYYY')TRXYER, 
	TO_CHAR(SYSDATE,'MON-YYYY')ORGMTH,
        TO_CHAR(SYSDATE,'YYYY')ORGYER,
	'N'
FROM bl_blng_grp_catg a, ip_bed_class b
WHERE :nd_det_option = 'DI'

UNION ALL

 SELECT a.blng_grp_catg,
        b.clinic_code,
	'O', '0', 
	'0','~~~',0,'~~~',
	SYSDATE,SYSDATE,SYSDATE,
        '~~~','~~~',
        0,0,'~~~',
	TO_CHAR(SYSDATE,'MON-YYYY')MTH,
        TO_CHAR(SYSDATE,'YYYY')YER,
	TO_CHAR(SYSDATE,'MON-YYYY')TRXMTH,
        TO_CHAR(SYSDATE,'YYYY')TRXYER, 
	TO_CHAR(SYSDATE,'MON-YYYY')ORGMTH,
        TO_CHAR(SYSDATE,'YYYY')ORGYER,
	'N'
FROM bl_blng_grp_catg a, op_clinic_his_vw b
WHERE :nd_det_option = 'EM'

ORDER BY 1,2,3,4,5,6,7,8; */ 


/* EXEC SQL DECLARE BILL_DCP_DTL_SUM_CUR CURSOR FOR 
  SELECT nvl(c.blng_grp_catg,'**'),
        DECODE(:nd_sum_option,'DI',nvl(a.bed_class_code,'**'),'EM',NVL(a.clinic_code,'**'),'**'),
	    a.episode_type, to_char(a.episode_id), 
	 to_char(a.visit_id),a.doc_type_code,a.doc_num,b.trx_type,b.doc_date trx_date,
        b.org_doc_date,A.DOC_DATE BILL_DATE,
        a.patient_id,blcommon.get_reln_code(a.patient_id) citizen,
        a.bill_amt,nvl(b.debit_amt,0)-nvl(b.credit_amt,0)outst_amt,
		trx_nature_code,
//	b.VALID_FOR_OUTSTDG_YN
	DECODE(A.BILL_STATUS,'C','N','Y')
 FROM bl_bill_dcp_dtl_temp a, bl_patient_statement_temp b,
         bl_blng_grp_by_catg c
 WHERE b.operating_facility_id = :nd_facility
  // AND   b.doc_date <= TO_DATE(TO_CHAR(LAST_DAY(TO_DATE(:nd_month_year,'MON-YYYY')),'DD/MM/YYYY')||' 23:59:59','DD/MM/YYYY HH24:MI:SS')   ***Commented as request from Lahd datu site*****
   AND   to_char(b.doc_date,'YYYYMM')=TO_CHAR(TO_DATE(:nd_month_year,'MON-YYYY'),'YYYYMM')  // ADDED ON REQUEST FROM SITE
   and  a.doc_date <= TO_DATE(TO_CHAR(LAST_DAY(TO_DATE(:nd_month_year,'MON-YYYY')),'DD/MM/YYYY')||' 23:59:59','DD/MM/YYYY HH24:MI:SS')
   AND a.operating_facility_id =  :nd_facility
   AND a.doc_type_code = nvl(b.adj_doc_type_code,b.doc_type_code)
   AND a.doc_num = nvl(b.adj_doc_num,b.doc_number)
   AND a.blng_grp_id = c.blng_grp_id(+)
   AND (A.EPISODE_TYPE =decode(:nd_sum_option,'DI','I','EM','O','R')
       OR
		A.EPISODE_TYPE =decode(:nd_sum_option,'DI','D','EM','E','R')
	   )  
   AND B.document_nature IN ('BI','DC')
   AND TRX_NATURE_CODE NOT IN (DECODE(:nd_excl_dep,'Y','AD','XX'),DECODE(:nd_excl_dep,'Y','PR','XX'))
   //and  DECODE(B.TRX_TYPE,'BILL',SIGN(NVL(b.debit_amt,0)-nvl(b.credit_amt,0)),0) >=0
   AND B.TRX_TYPE NOT IN(DECODE(:nd_excl_ref,'Y','REFUND','XX'),DECODE(:nd_excl_ref,'Y','CANC-REFUND','XX'))
   AND (
      (nvL(:nd_exc_adj,'Y')='Y' and NVL(BILL_TOT_ADJUST_AMT,0) =0)
	   or 
      NVL(:nd_exc_adj,'Y')='N')
   AND  (
       (NVL(:nd_exc_exmp,'Y')='Y' and NVL(BILL_TOT_EXEMPT_AMT,0) =0)
	   or 
      NVL(:nd_exc_exmp,'Y')='N')
   AND  (
      (NVL(:nd_exc_writeoff,'Y')='Y' and NVL(BILL_TOT_WRITE_OFF_AMT,0) =0)
	   or 
      NVL(:nd_exc_writeoff,'Y')='N')
 ORDER BY 1,2,3,4,5,6,7,8; */ 


 }




open_pat_dis_cur() 
  {


	/* EXEC SQL OPEN BILL_DCP_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select nvl(c.blng_grp_catg,'**') ,DECODE(:b0,'DI',nvl(a.bed_class_code,'\
**'),'EM',NVL(a.clinic_code,'**'),'**') ,a.episode_type ,to_char(a.episode_i\
d) ,to_char(a.visit_id) ,a.doc_type_code ,a.doc_num ,b.trx_type ,b.doc_date \
trx_date ,b.org_doc_date ,A.DOC_DATE BILL_DATE ,a.patient_id ,blcommon.get_r\
eln_code(a.patient_id) citizen ,a.bill_amt ,(nvl(b.debit_amt,0)-nvl(b.credit\
_amt,0)) outst_amt ,trx_nature_code ,to_char(a.doc_date,'MON-YYYY') MTH ,to_\
char(a.doc_date,'YYYY') YER ,to_char(B.doc_date,'MON-YYYY') TRXMTH ,to_char(\
B.doc_date,'YYYY') TRXYER ,to_char(b.org_doc_date,'MON-YYYY') ORGMTH ,to_cha\
r(b.org_doc_date,'YYYY') ORGYER ,DECODE(A.BILL_STATUS,'C','N','Y')  from bl_\
bill_dcp_dtl_temp a ,bl_patient_statement_temp b ,bl_blng_grp_by_catg c wher\
e ((((((((((((((b.operating_facility_id=:b1 and b.doc_date<=TO_DATE((TO_CHAR\
(LAST_DAY(TO_DATE(:b2,'MON-YYYY')),'DD/MM/YYYY')||' 23:59:59'),'DD/MM/YYYY H\
H24:MI:SS')) and a.doc_date<=TO_DATE((TO_CHAR(LAST_DAY(TO_DATE(:b2,'MON-YYYY\
')),'DD/MM/YYYY')||' 23:59:59'),'DD/MM/Y");
 sqlbuft((void **)0, 
   "YYY HH24:MI:SS')) and a.operating_facility_id=:b1) and a.doc_type_code=n\
vl(b.adj_doc_type_code,b.doc_type_code)) and a.doc_num=nvl(b.adj_doc_num,b.d\
oc_number)) and a.blng_grp_id=c.blng_grp_id(+)) and (A.EPISODE_TYPE=decode(:\
b0,'DI','I','EM','O','R') or A.EPISODE_TYPE=decode(:b0,'DI','D','EM','E','R'\
))) and B.document_nature in ('BI','DC')) and A.BILL_TOT_AMT>0) and TRX_NATU\
RE_CODE not  in (DECODE(:b7,'Y','AD','XX'),DECODE(:b7,'Y','PR','XX'))) and B\
.TRX_TYPE not  in (DECODE(:b9,'Y','REFUND','XX'),DECODE(:b9,'Y','CANC-REFUND\
','XX'))) and ((NVL(:b11,'Y')='Y' and NVL(BILL_TOT_ADJUST_AMT,0)=0) or NVL(:\
b11,'Y')='N')) and ((NVL(:b13,'Y')='Y' and NVL(BILL_TOT_EXEMPT_AMT,0)=0) or \
NVL(:b13,'Y')='N')) and ((NVL(:b15,'Y')='Y' and NVL(BILL_TOT_WRITE_OFF_AMT,0\
)=0) or NVL(:b15,'Y')='N')) union all select a.blng_grp_catg ,b.bed_class_co\
de ,'I' ,'0' ,'0' ,'~~~' ,0 ,'~~~' ,SYSDATE ,SYSDATE ,SYSDATE ,'~~~' ,'~~~' \
,0 ,0 ,'~~~' ,TO_CHAR(SYSDATE,'MON-YYYY') MTH ,TO_CHAR(SYSDATE,'YYYY') YER ,\
TO_CHAR(SYSDATE,'MON-YYYY') TRXMTH ,TO_C");
 sqlstm.stmt = sq0010;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )380;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_facility;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_month_year;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_month_year;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_facility;
 sqlstm.sqhstl[4] = (unsigned int  )5;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[5] = (unsigned int  )5;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_excl_dep;
 sqlstm.sqhstl[7] = (unsigned int  )4;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_excl_dep;
 sqlstm.sqhstl[8] = (unsigned int  )4;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_excl_ref;
 sqlstm.sqhstl[9] = (unsigned int  )4;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_excl_ref;
 sqlstm.sqhstl[10] = (unsigned int  )4;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_exc_adj;
 sqlstm.sqhstl[11] = (unsigned int  )4;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_exc_adj;
 sqlstm.sqhstl[12] = (unsigned int  )4;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_exc_exmp;
 sqlstm.sqhstl[13] = (unsigned int  )4;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_exc_exmp;
 sqlstm.sqhstl[14] = (unsigned int  )4;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_exc_writeoff;
 sqlstm.sqhstl[15] = (unsigned int  )4;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_exc_writeoff;
 sqlstm.sqhstl[16] = (unsigned int  )4;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&nd_det_option;
 sqlstm.sqhstl[17] = (unsigned int  )5;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&nd_det_option;
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


		if (OERROR)
        err_mesg("OPEN failed on cursor BILL_DCP_DTL_CUR",0,"");


}
open_pat_sum_cur() 
 {		
	/* EXEC SQL OPEN BILL_DCP_DTL_SUM_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select nvl(c.blng_grp_catg,'**') ,DECODE(:b0,'DI',nvl(a.bed_class_code,'\
**'),'EM',NVL(a.clinic_code,'**'),'**') ,a.episode_type ,to_char(a.episode_i\
d) ,to_char(a.visit_id) ,a.doc_type_code ,a.doc_num ,b.trx_type ,b.doc_date \
trx_date ,b.org_doc_date ,A.DOC_DATE BILL_DATE ,a.patient_id ,blcommon.get_r\
eln_code(a.patient_id) citizen ,a.bill_amt ,(nvl(b.debit_amt,0)-nvl(b.credit\
_amt,0)) outst_amt ,trx_nature_code ,DECODE(A.BILL_STATUS,'C','N','Y')  from\
 bl_bill_dcp_dtl_temp a ,bl_patient_statement_temp b ,bl_blng_grp_by_catg c \
where (((((((((((((b.operating_facility_id=:b1 and to_char(b.doc_date,'YYYYM\
M')=TO_CHAR(TO_DATE(:b2,'MON-YYYY'),'YYYYMM')) and a.doc_date<=TO_DATE((TO_C\
HAR(LAST_DAY(TO_DATE(:b2,'MON-YYYY')),'DD/MM/YYYY')||' 23:59:59'),'DD/MM/YYY\
Y HH24:MI:SS')) and a.operating_facility_id=:b1) and a.doc_type_code=nvl(b.a\
dj_doc_type_code,b.doc_type_code)) and a.doc_num=nvl(b.adj_doc_num,b.doc_num\
ber)) and a.blng_grp_id=c.blng_grp_id(+)) and (A.EPISODE_TYPE=decode(:b0,'DI\
','I','EM','O','R') or A.EPISODE_TYPE=de");
 sqlstm.stmt = sq0011;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )471;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_sum_option;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_facility;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_month_year;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_month_year;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_facility;
 sqlstm.sqhstl[4] = (unsigned int  )5;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_sum_option;
 sqlstm.sqhstl[5] = (unsigned int  )5;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_sum_option;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_excl_dep;
 sqlstm.sqhstl[7] = (unsigned int  )4;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_excl_dep;
 sqlstm.sqhstl[8] = (unsigned int  )4;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_excl_ref;
 sqlstm.sqhstl[9] = (unsigned int  )4;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_excl_ref;
 sqlstm.sqhstl[10] = (unsigned int  )4;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_exc_adj;
 sqlstm.sqhstl[11] = (unsigned int  )4;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_exc_adj;
 sqlstm.sqhstl[12] = (unsigned int  )4;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_exc_exmp;
 sqlstm.sqhstl[13] = (unsigned int  )4;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_exc_exmp;
 sqlstm.sqhstl[14] = (unsigned int  )4;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_exc_writeoff;
 sqlstm.sqhstl[15] = (unsigned int  )4;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_exc_writeoff;
 sqlstm.sqhstl[16] = (unsigned int  )4;
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


		if (OERROR)
        err_mesg("OPEN failed on cursor BILL_DCP_DTL_SUM_CUR",0,"");
   }

close_pat_dis_cur()
   {

	/* EXEC SQL CLOSE BILL_DCP_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )554;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
	}

close_pat_sum_cur()
   {
		/* EXEC SQL CLOSE BILL_DCP_DTL_SUM_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )569;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}
fetch_bill_dtl_cur()
  {

	d_blng_grp_catg.arr[0]		='\0';
	d_patient_id.arr[0]		='\0';
	d_doc_type_code.arr[0]		='\0';
	d_doc_date.arr[0]		='\0';
	d_trx_type.arr[0]		='\0';
	d_episode_type.arr[0]		='\0';
	d_bed_clinic_code.arr[0]		='\0';
	d_adj_date.arr[0]		='\0';
	d_bill_date.arr[0]		='\0';
	d_bill_year.arr[0]		='\0';		
	d_bill_mth.arr[0]		='\0';
	d_trx_year.arr[0]		='\0';		
	d_trx_mth.arr[0]		='\0';
	d_org_year.arr[0]		='\0';		
	d_org_mth.arr[0]		='\0';
	d_episode_id.arr[0]		='\0';
	d_valid_for_out.arr[0]	='\0';
	d_visit_id.arr[0]	='\0';
	d_national.arr[0]	='\0';

	d_blng_grp_catg.len	=0;
	d_patient_id.len	=0;
	d_doc_type_code.len	=0;
	d_doc_date.len		=0;
	d_trx_type.len		=0;
	d_episode_type.len	=0;
	d_bed_clinic_code.len	=0;
	d_adj_date.len		=0;
	d_visit_id.len		=0;		
        d_bill_year.len		=0;
        d_bill_mth.len		=0;
        d_trx_year.len		=0;
        d_trx_mth.len		=0;
		d_org_year.len		=0;
        d_org_mth.len		=0;
		d_bill_date.len		=0;
		d_episode_id.len	=0;
		d_valid_for_out.len =0;
		d_national.len =0;

   /* EXEC SQL FETCH BILL_DCP_DTL_CUR INTO
        :d_blng_grp_catg,
        :d_bed_clinic_code,
        :d_episode_type,
		:d_episode_id,
		:d_visit_id,
		:d_doc_type_code,
        :d_doc_num,
		:d_trx_type,
 		:d_doc_date,
        :d_adj_date,
        :d_bill_date,
        :d_patient_id,
		:d_national,
		:d_bill_tot_amt,
		:d_outst_amt,
        :trx_nature_code,
		:d_bill_mth,
        :d_bill_year,
		:d_trx_mth,
		:d_trx_year,
		:d_org_mth,
		:d_org_year,
		:d_valid_for_out; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )584;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_catg;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_bed_clinic_code;
   sqlstm.sqhstl[1] = (unsigned int  )10;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_episode_type;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_episode_id;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_visit_id;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_doc_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_doc_num;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_trx_type;
   sqlstm.sqhstl[7] = (unsigned int  )16;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_doc_date;
   sqlstm.sqhstl[8] = (unsigned int  )18;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_adj_date;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_bill_date;
   sqlstm.sqhstl[10] = (unsigned int  )18;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[11] = (unsigned int  )23;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_national;
   sqlstm.sqhstl[12] = (unsigned int  )12;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_bill_tot_amt;
   sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_outst_amt;
   sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&trx_nature_code;
   sqlstm.sqhstl[15] = (unsigned int  )5;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_bill_mth;
   sqlstm.sqhstl[16] = (unsigned int  )11;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_bill_year;
   sqlstm.sqhstl[17] = (unsigned int  )7;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&d_trx_mth;
   sqlstm.sqhstl[18] = (unsigned int  )11;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_trx_year;
   sqlstm.sqhstl[19] = (unsigned int  )7;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&d_org_mth;
   sqlstm.sqhstl[20] = (unsigned int  )11;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_org_year;
   sqlstm.sqhstl[21] = (unsigned int  )7;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&d_valid_for_out;
   sqlstm.sqhstl[22] = (unsigned int  )4;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
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
       err_mesg("FETCH failed on cursor	BILL_DCP_DTL_CUR",0,"");	

    d_blng_grp_catg.arr[d_blng_grp_catg.len]	 ='\0';
	d_patient_id.arr[d_patient_id.len]			 ='\0';
	d_doc_type_code.arr[d_doc_type_code.len]	 ='\0';
	d_doc_date.arr[d_doc_date.len]				 ='\0';
	d_trx_type.arr[d_trx_type.len]			     ='\0';
	d_episode_type.arr[d_episode_type.len]		 ='\0';
	d_bed_clinic_code.arr[d_bed_clinic_code.len] ='\0';
	d_adj_date.arr[d_adj_date.len]			     ='\0';
	d_bill_year.arr[d_bill_year.len]			 ='\0';		
	d_bill_mth.arr[d_bill_mth.len]			     ='\0';
	d_trx_year.arr[d_trx_year.len]			     ='\0';		
	d_trx_mth.arr[d_trx_mth.len]			     ='\0';
	d_org_year.arr[d_org_year.len]			     ='\0';		
	d_org_mth.arr[d_org_mth.len]			     ='\0';
	d_bill_date.arr[d_bill_date.len]		     ='\0';
	d_episode_id.arr[d_episode_id.len]			 ='\0';
	d_valid_for_out.arr[d_valid_for_out.len]	 ='\0';
	d_visit_id.arr[d_visit_id.len]				 ='\0';
	d_national.arr[d_national.len]				 ='\0';
   
   	  return(LAST_ROW?0:1);

  }


fetch_bill_dtl_sum_cur()
  {

    d_sum_blng_grp_catg.arr[0]		='\0';
	d_sum_patient_id.arr[0]		='\0';
	d_sum_doc_type_code.arr[0]		='\0';
	d_sum_doc_date.arr[0]		='\0';
	d_sum_trx_type.arr[0]		='\0';
	d_sum_episode_type.arr[0]		='\0';
	d_sum_bed_clinic_code.arr[0]		='\0';

	d_sum_episode_id.arr[0]		='\0';
	d_sum_valid_for_out.arr[0]	='\0';
	d_sum_visit_id.arr[0]	='\0';
	d_sum_national.arr[0]	='\0';

	d_sum_blng_grp_catg.len	=0;
	d_sum_patient_id.len	=0;
	d_sum_doc_type_code.len	=0;
	d_sum_doc_date.len		=0;
	d_sum_trx_type.len		=0;
	d_sum_episode_type.len	=0;
	d_sum_bed_clinic_code.len	=0;
	d_sum_adj_date.len		=0;
	d_sum_visit_id.len		=0;		

		d_sum_episode_id.len	=0;
		d_sum_valid_for_out.len =0;
		d_sum_national.len =0;

   /* EXEC SQL FETCH BILL_DCP_DTL_SUM_CUR INTO
        :d_sum_blng_grp_catg,
        :d_sum_bed_clinic_code,
        :d_sum_episode_type,
		:d_sum_episode_id,
		:d_sum_visit_id,
		:d_sum_doc_type_code,
        :d_sum_doc_num,
		:d_sum_trx_type,
 		:d_sum_doc_date,
        :d_sum_adj_date,
        :d_sum_bill_date,
        :d_sum_patient_id,
		:d_sum_national,
		:d_sum_bill_tot_amt,
		:d_sum_outst_amt,
        :trx_sum_nature_code,
		:d_sum_valid_for_out; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 23;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )691;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_sum_blng_grp_catg;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_sum_bed_clinic_code;
   sqlstm.sqhstl[1] = (unsigned int  )10;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_sum_episode_type;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_sum_episode_id;
   sqlstm.sqhstl[3] = (unsigned int  )11;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_sum_visit_id;
   sqlstm.sqhstl[4] = (unsigned int  )7;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_sum_doc_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_sum_doc_num;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_sum_trx_type;
   sqlstm.sqhstl[7] = (unsigned int  )16;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_sum_doc_date;
   sqlstm.sqhstl[8] = (unsigned int  )18;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_sum_adj_date;
   sqlstm.sqhstl[9] = (unsigned int  )18;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_sum_bill_date;
   sqlstm.sqhstl[10] = (unsigned int  )18;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_sum_patient_id;
   sqlstm.sqhstl[11] = (unsigned int  )23;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_sum_national;
   sqlstm.sqhstl[12] = (unsigned int  )12;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_sum_bill_tot_amt;
   sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_sum_outst_amt;
   sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&trx_sum_nature_code;
   sqlstm.sqhstl[15] = (unsigned int  )5;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_sum_valid_for_out;
   sqlstm.sqhstl[16] = (unsigned int  )4;
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





	 if (OERROR)
       err_mesg("FETCH failed on cursor	BILL_DCP_DTL_SUM_CUR",0,"");	

    d_sum_blng_grp_catg.arr[d_sum_blng_grp_catg.len]	 ='\0';
	d_sum_patient_id.arr[d_sum_patient_id.len]			 ='\0';
	d_sum_doc_type_code.arr[d_sum_doc_type_code.len]	 ='\0';
	d_sum_doc_date.arr[d_sum_doc_date.len]				 ='\0';
	d_sum_trx_type.arr[d_sum_trx_type.len]			     ='\0';
	d_sum_episode_type.arr[d_sum_episode_type.len]		 ='\0';
	d_sum_bed_clinic_code.arr[d_sum_bed_clinic_code.len] ='\0';
	d_sum_adj_date.arr[d_sum_adj_date.len]			     ='\0';

	d_sum_bill_date.arr[d_sum_bill_date.len]		     ='\0';
	d_sum_episode_id.arr[d_sum_episode_id.len]			 ='\0';
	d_sum_valid_for_out.arr[d_sum_valid_for_out.len]	 ='\0';
	d_sum_visit_id.arr[d_sum_visit_id.len]				 ='\0';
	d_sum_national.arr[d_sum_national.len]				 ='\0';
   
   	  return(LAST_ROW?0:1);

  } 

fetch_blng_grp_catg()
	{
		d_description.arr[0]  = '\0';
		d_description.len     = 0;	
		
	          /* EXEC SQL SELECT  nvl(SHORT_DESC,'**Not Specified**') into :d_description FROM BL_BLNG_GRP_CATG 
	          WHERE BLNG_GRP_CATG=:d_blng_grp_catg; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 12;
           sqlstm.arrsiz = 23;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "select nvl(SHORT_DESC,'**Not Specified**') into :b\
0  from BL_BLNG_GRP_CATG where BLNG_GRP_CATG=:b1";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )774;
           sqlstm.selerr = (unsigned short)1;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)4352;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&d_description;
           sqlstm.sqhstl[0] = (unsigned int  )33;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_catg;
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


       
               d_description.arr[d_description.len]	= '\0';
	    if(strcmp(d_blng_grp_catg.arr,"**")==0)
		   strcpy(d_description.arr,"**Not Specified**");		   	
	}



fetch_blng_grp_catg1()
	{
		nd_description.arr[0]  = '\0';
		nd_description.len     = 0;	
      nd1_blng_grp_catg.arr[0]  = '\0';
		nd1_blng_grp_catg.len     = 0;	
	strcpy(nd1_blng_grp_catg.arr,nd_blng_grp_catg.arr);
    nd1_blng_grp_catg.arr[nd1_blng_grp_catg.len]='\0';
	 //disp_message(ERR_MESG,nd_blng_grp_catg.arr);
	 /* EXEC SQL SELECT  nvl(SHORT_DESC,'**Not Specified**') into :nd_description FROM BL_BLNG_GRP_CATG 
	          WHERE BLNG_GRP_CATG=:nd1_blng_grp_catg; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select nvl(SHORT_DESC,'**Not Specified**') into :b0  from B\
L_BLNG_GRP_CATG where BLNG_GRP_CATG=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )797;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_description;
  sqlstm.sqhstl[0] = (unsigned int  )33;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd1_blng_grp_catg;
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


			  //disp_message(ERR_MESG,nd1_blng_grp_catg.arr);
       //disp_message(ERR_MESG,nd_description.arr);
               nd_description.arr[nd_description.len]	= '\0';
	    if(strcmp(nd1_blng_grp_catg.arr,"**")==0)
		   strcpy(nd_description.arr,"**Not Specified**");		   	
	}



get_header_dtls()
  {
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	    d_acc_entity_name.arr[0]	=  '\0';
	    d_curr_date.arr[0]		=  '\0';
	    d_user.arr[0]		=  '\0';
	    d_sysdate.arr[0]		=  '\0';
	    d_acc_entity_name.len	=  0;
	    d_curr_date.len		=  0;
	    d_user.len			=  0;
	    d_sysdate.len		=  0;

	/* EXEC SQL SELECT upper(ACC_ENTITY_NAME), /o description of the institution o/
		   USER, TO_CHAR(SYSDATE, 'DD/MM/YYYY'),TO_CHAR(SYSDATE, 'HH24:MI:SS')
			INTO :d_acc_entity_name,
			     :d_user, :d_sysdate,:d_curr_date
			FROM SY_ACC_ENTITY
			WHERE acc_entity_id = :nd_facility; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,USER ,TO_CHAR(SYSDATE,'DD/MM/\
YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') into :b0,:b1,:b2,:b3  from SY_ACC_ENTITY\
 where acc_entity_id=:b4";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )820;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
 sqlstm.sqhstl[2] = (unsigned int  )22;
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
 sqlstm.sqhstv[4] = (         void  *)&nd_facility;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


    
	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len]                       = '\0';
	d_sysdate.arr[d_sysdate.len]                 = '\0';
	d_curr_date.arr[d_curr_date.len]	     = '\0';

   
	return;
	err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 23;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )855;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	proc_exit();
  }




print_page_title()
  {

	int hosp_nm_len, rep_title_len = 10, s1, s2,date_len,user_len,pgm_len;
	char v_rep_title[200],v_as_on_date[12];
	lctr=0;

// LINE-1
	
	fprintf(fp,"MDL : BL");
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(fp,"%s", d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	horz_skip(s2-24);
	fprintf(fp,"%-12s: %s", loc_legend[2],d_sysdate.arr);
    
	fprintf(fp,"\n");
	
// LINE-2

	fprintf(fp,"OPR : %s", d_user.arr); 	
     user_len=strlen(d_user.arr);
	//if (strcmp(d_discharge_billing_stage.arr,"1")==0)
	//strcpy(v_rep_title,loc_legend[21]);
	//else
    strcpy(v_rep_title,loc_legend[1]);	

	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	horz_skip(s1-user_len-6);
	fprintf(fp,"%s",v_rep_title);


	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-24);
		fprintf(fp,"%-12s:%9s\n",loc_legend[4],d_curr_date.arr);


// LINE-3

  fprintf(fp,"REP : %s",d_curr_pgm_name.arr);
    pgm_len=strlen(d_curr_pgm_name.arr);


    strcpy(v_as_on_date,nd_month_year.arr);	

	date_len= strlen(v_as_on_date);

	s1 = (REP_WIDTH-(date_len+strlen(loc_legend[5])+1))/2;
	horz_skip(s1-(pgm_len+6));
	 fprintf(fp,"%s %s",loc_legend[5],v_as_on_date);

	s2 = (REP_WIDTH-s1-(date_len+1+strlen(loc_legend[5])));
	horz_skip(s2-24);
		fprintf(fp,"%-12s: %-d\n",loc_legend[3],++page_no);

  
  if(strcmp(nd_det_option.arr,"DI")==0)
     {
        s1 = (REP_WIDTH-strlen(loc_legend[14]))/2;
		horz_skip(s1);		
      	fprintf(fp,"%s\n",loc_legend[14]);
      }
   else if(strcmp(nd_det_option.arr,"EM")==0)
      {
        s1 = (REP_WIDTH-strlen(loc_legend[15]))/2;
		horz_skip(s1);		
      	fprintf(fp,"%s\n",loc_legend[15]);
	  }
  else 
      {
        s1 = (REP_WIDTH-strlen(loc_legend[16]))/2;
		horz_skip(s1);		
      	fprintf(fp,"%s\n",loc_legend[16]);
       }


	lctr = 5;

	print_line('-',REP_WIDTH);
	 //next_line(1);

	
}
				
 	open_file()
{

    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00084.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00084.lis");
       proc_exit();
    }
	
}

        
	      

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[50], str_amt[50];	

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
		fprintf(fp,"\n"); ++lctr; /*     fprintf(fp,"LNNO:%2d",lno); */
	}
 }
        
next_page() /* will move the cursor to next page */
{

	fprintf(fp,"\n");
	fprintf(fp,"\f");
	lctr=0;
	fprintf(fp,"\n"); 
	print_head(); 	
}
     
              
print_line(ch,n) /* this is to obtain required characters */
  char ch;
	int n;
	{
	int i;
	for(i=0;i<n;i++)
	fprintf(fp,"%c",ch);  fprintf(fp,"\n");++lctr;
	}
     
horz_skip(num) /* this is to obtain required blank space */
int num;
	{
	int i;
	for(i=0;i<num;i++)fprintf(fp," ");
	}


fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';
     
		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00084.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00084.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )870;
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
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 23;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )893;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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






print_end_of_rep()
{
	int col;
    next_line(1);
	//for (col = 0; col < (90 -23)/2; col++)
	//fprintf(fp," "); 
	horz_skip((REP_WIDTH-23)/2);
	fprintf(fp,"***  END OF REPORT  ***");
	fflush(fp);
    fclose(fp);
  fprintf(fp,"%cE",ESC); /* To Reset the Printer */
}
/****************************************************************************/


         
         
           

