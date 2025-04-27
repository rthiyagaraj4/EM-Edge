
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/blrvsbl6.pc"
};


static unsigned int sqlctx = 1288469003;


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
            void  *sqhstv[22];
   unsigned int   sqhstl[22];
            int   sqhsts[22];
            void  *sqindv[22];
            int   sqinds[22];
   unsigned int   sqharm[22];
   unsigned int   *sqharc[22];
   unsigned short  sqadto[22];
   unsigned short  sqtdso[22];
} sqlstm = {12,22};

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

 static const char *sq0021 = 
"f_seq_num)))) or (orig_doc_ref is  not null  and 0=(select count(1)  from bl\
_patient_charges_folio where (((((operating_facility_id=:b0 and bill_doc_type_\
code=:b1) and to_char(bill_doc_num)=:b2) and trx_doc_ref=b.orig_doc_ref) and t\
rx_doc_ref_line_num=b.orig_doc_ref_line_num) and trx_doc_ref_seq_num=b.orig_do\
c_ref_seq_num)))))))) order by 3,1            ";

 static const char *sq0035 = 
"select policy_type_code  from bl_encounter_payer_priority where ((((patient_\
id=:b0 and episode_type=:b1) and nvl(episode_id,0)=nvl(:b2,0)) and nvl(visit_i\
d,0)=nvl(:b3,0)) and nvl(acct_seq_no,0)=nvl(:b4,0)) order by priority,policy_t\
ype_code            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,377,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,85,0,4,392,0,0,4,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,
67,0,0,3,91,0,2,407,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
90,0,0,4,383,0,4,461,0,0,10,3,0,1,0,1,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
145,0,0,5,421,0,4,474,0,0,10,4,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
200,0,0,6,104,0,4,567,0,0,5,4,0,1,0,1,3,0,0,1,3,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
235,0,0,7,104,0,4,577,0,0,5,4,0,1,0,1,3,0,0,1,3,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
270,0,0,8,71,0,4,760,0,0,1,0,0,1,0,2,9,0,0,
289,0,0,9,0,0,29,779,0,0,0,0,0,1,0,
304,0,0,10,0,0,30,786,0,0,0,0,0,1,0,
319,0,0,11,115,0,6,793,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
346,0,0,12,124,0,6,806,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
373,0,0,13,47,0,4,836,0,0,1,0,0,1,0,2,9,0,0,
392,0,0,14,120,0,6,840,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
419,0,0,15,129,0,6,853,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
446,0,0,16,108,0,4,890,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
473,0,0,17,506,0,6,914,0,0,4,4,0,1,0,3,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
504,0,0,18,1517,0,6,951,0,0,13,13,0,1,0,1,9,0,0,1,9,0,0,2,1,0,0,3,3,0,0,3,3,0,
0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
571,0,0,19,169,0,4,1062,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,
1,9,0,0,1,9,0,0,
614,0,0,20,97,0,4,1087,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
637,0,0,21,3428,0,9,1258,0,0,22,22,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
740,0,0,21,0,0,13,1294,0,0,17,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,
2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,3,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,9,0,
0,2,3,0,0,2,9,0,0,
823,0,0,22,102,0,4,1335,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
850,0,0,23,164,0,4,1340,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
885,0,0,21,0,0,15,1355,0,0,0,0,0,1,0,
900,0,0,24,96,0,4,1364,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
923,0,0,25,165,0,6,1371,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
954,0,0,26,339,0,4,1412,0,0,11,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,
2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1013,0,0,27,74,0,4,1434,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1036,0,0,28,140,0,4,1615,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1067,0,0,29,46,0,4,1702,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
1094,0,0,30,255,0,4,1780,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,
1137,0,0,31,95,0,4,1811,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
1164,0,0,32,106,0,4,1845,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
1191,0,0,33,199,0,6,1935,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1218,0,0,34,227,0,6,1959,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1245,0,0,35,252,0,9,2051,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,3,0,0,
1280,0,0,35,0,0,13,2068,0,0,1,0,0,1,0,2,9,0,0,
1299,0,0,35,0,0,15,2093,0,0,0,0,0,1,0,
1314,0,0,36,185,0,4,2100,0,0,4,3,0,1,0,2,4,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
1345,0,0,37,180,0,4,2114,0,0,4,3,0,1,0,2,4,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
1376,0,0,38,389,0,6,2153,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,
1435,0,0,39,76,0,4,2230,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,3,0,0,
1462,0,0,40,176,0,4,2239,0,0,12,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1525,0,0,41,194,0,4,2251,0,0,12,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1588,0,0,42,140,0,4,2299,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1619,0,0,43,127,0,4,2331,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/*  OCS MEDICOM VER 1.10                                                */
/************************************************************************/
/* PROGRAM NAME          :	BLRVSBL6.PC                                 */
/* AUTHOR                :	K.SARAVANAN                                 */
/* DATE WRITTEN          :	14-AUG-2003                                 */
/* DATE MODIFIED         :						                        */
/* CALLED FROM           :						                        */
/*                                                                      */
/* FUNCTION              :	TO PRINT CASH BILL CUM RECEIPT,             */
/*				PRINT_VISIT_BILL, PRINT_VISIT_BILL_NO_DISC,             */
/*				PRINT VISIT BILL - NO SETTLEMENT DTLS	                */
/************************************************************************/
/* UPGRADED TO 4.1 */

#include <stdio.h>     
#include <string.h>       
#include <bl.h> 



#define OERROR (sqlca.sqlcode < 0)

#define NODATAFOUND sqlca.sqlcode == 1403
#define RESOURCE_BUSY (sqlca.sqlcode == -54)


#define INIT_MESG "Specific Serv Item list Process in Progress..." 

#define ONLINE_PRINTING 1

#define DEBUG  1
        
#define maxlines 11

#define LEGEND 1

#define LENGTH_WORDS 80 

#define ERR_MESG  4

#define ESC     0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 

		
/* VARCHAR p_language_id   [3],
		l_pk_value		[100],
		l_translated_value[201],
		nd_fm_doc_type  [31],
		trx_type 		[2],
		uid_pwd      	[132],	
		uid				[132],	
		nd_fm_doc_num   [31],
		nd_to_doc_type  [31],  
		nd_to_doc_num   [31],
		nd_fm_doc_date  [31],
		d_cashfacility_id [3],
		nd_to_doc_date  [31],
		nd_facility_name[31],
		nd_acc_name	[31],
		nd_facility	[31],
		p_cash_counter	[3],
		p_document_id	[31],
		p_shift		[2],
		nd_pgm_date	[13],
		nd_session_id	[16],
		nd_ws_no	[40],
		nd_hosp_add [500],
		l_printer_ids		[1000],
		l_printer_names		[1000],
		l_printer_types		[1000],
	    l_queue_names		[1000],
	    l_no_of_copies		[1000],
		l_errortext			[1000],
		l_logo_yniflaser[1000],
		
  	      currency 	[16],
	      sub_cur  	[10],
	      nn_cc_code      [3],
	      nd_curr_date    [20],
          nn_shift_id     [2],
		  comp_name [50],
		  rep_date  [20],
		  oper_id   [21],
		nd_calling_pgm_id[10],
		nd_logo_pgm_id[1000],
		P_START_TIME  [60],
		bill_title[40]; */ 
struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[31]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[2]; } trx_type;

struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[132]; } uid;

struct { unsigned short len; unsigned char arr[31]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[31]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[31]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[31]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[3]; } d_cashfacility_id;

struct { unsigned short len; unsigned char arr[31]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[31]; } nd_acc_name;

struct { unsigned short len; unsigned char arr[31]; } nd_facility;

struct { unsigned short len; unsigned char arr[3]; } p_cash_counter;

struct { unsigned short len; unsigned char arr[31]; } p_document_id;

struct { unsigned short len; unsigned char arr[2]; } p_shift;

struct { unsigned short len; unsigned char arr[13]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[40]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[500]; } nd_hosp_add;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_ids;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_names;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_types;

struct { unsigned short len; unsigned char arr[1000]; } l_queue_names;

struct { unsigned short len; unsigned char arr[1000]; } l_no_of_copies;

struct { unsigned short len; unsigned char arr[1000]; } l_errortext;

struct { unsigned short len; unsigned char arr[1000]; } l_logo_yniflaser;

struct { unsigned short len; unsigned char arr[16]; } currency;

struct { unsigned short len; unsigned char arr[10]; } sub_cur;

struct { unsigned short len; unsigned char arr[3]; } nn_cc_code;

struct { unsigned short len; unsigned char arr[20]; } nd_curr_date;

struct { unsigned short len; unsigned char arr[2]; } nn_shift_id;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[10]; } nd_calling_pgm_id;

struct { unsigned short len; unsigned char arr[1000]; } nd_logo_pgm_id;

struct { unsigned short len; unsigned char arr[60]; } P_START_TIME;

struct { unsigned short len; unsigned char arr[40]; } bill_title;


/* VARCHAR dc_doc_type_code [7],
        nd_Serv_Group    [3],
	    nd_patient_id	 [17],
		nd_patient_name1 [500],
		nd_patient_name2 [500],
		nd_patient_name3 [500],
		nd_episode_type	 [15],
		nd_episode_type1 [2],
		nd_map_code      [30],
		nd_map_ind       [1],
		nd_map_desc      [100],
		nd_blng_grp_id   [4],
		d_added_by_id	 [100],
		nd_blng_Grp_Desc [500],
		nd_episode_id	 [10],
	    d_doc_date		 [11],
	    d_doc_num [9],
		d_service_code[12],
	    d_service_date[12],
	    d_service_desc[300],
		d_dis_date[17],
		l_bill_contact_name [60],
		l_bill_contact_name_title [60],
		l_bill_long_desc [60],
		l_bill_add1_desc [60],
		l_bill_add2_desc [60],
		l_bill_add3_desc [60],
		l_bill_add3_desc_temp [60],
		l_dflt_bill_print_in_summ_yn[5],
		l_detail_report_flag[3],
		l_print_without_disc_func[4],
		l_no_settlement_details[5],
		l_credit_doc_ref_desc[30],
		l_credit_doc_ref_desc1[30],
		l_credit_doc_ref_desc2[30],
		nd_acc_entity_code[5],
		nd_temp_date	[30],
		nd_loc_date		[30],
		date_convert	[30],
		nd_policy_type_code[25],
		nd_prev_policy_desc[101],
		nd_all_policy_desc[2000],
		nd_policy_desc[101],
		nd_print_policy_desc[100],
		nd_cust_code[10],
		d_mpi_id[100],
		d_cust_doc_type_code[8],
		d_cust_doc_num[10],
		nd_trx_doc_ref[100],
		nd_facility_id[3]; */ 
struct { unsigned short len; unsigned char arr[7]; } dc_doc_type_code;

struct { unsigned short len; unsigned char arr[3]; } nd_Serv_Group;

struct { unsigned short len; unsigned char arr[17]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[500]; } nd_patient_name1;

struct { unsigned short len; unsigned char arr[500]; } nd_patient_name2;

struct { unsigned short len; unsigned char arr[500]; } nd_patient_name3;

struct { unsigned short len; unsigned char arr[15]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type1;

struct { unsigned short len; unsigned char arr[30]; } nd_map_code;

struct { unsigned short len; unsigned char arr[1]; } nd_map_ind;

struct { unsigned short len; unsigned char arr[100]; } nd_map_desc;

struct { unsigned short len; unsigned char arr[4]; } nd_blng_grp_id;

struct { unsigned short len; unsigned char arr[100]; } d_added_by_id;

struct { unsigned short len; unsigned char arr[500]; } nd_blng_Grp_Desc;

struct { unsigned short len; unsigned char arr[10]; } nd_episode_id;

struct { unsigned short len; unsigned char arr[11]; } d_doc_date;

struct { unsigned short len; unsigned char arr[9]; } d_doc_num;

struct { unsigned short len; unsigned char arr[12]; } d_service_code;

struct { unsigned short len; unsigned char arr[12]; } d_service_date;

struct { unsigned short len; unsigned char arr[300]; } d_service_desc;

struct { unsigned short len; unsigned char arr[17]; } d_dis_date;

struct { unsigned short len; unsigned char arr[60]; } l_bill_contact_name;

struct { unsigned short len; unsigned char arr[60]; } l_bill_contact_name_title;

struct { unsigned short len; unsigned char arr[60]; } l_bill_long_desc;

struct { unsigned short len; unsigned char arr[60]; } l_bill_add1_desc;

struct { unsigned short len; unsigned char arr[60]; } l_bill_add2_desc;

struct { unsigned short len; unsigned char arr[60]; } l_bill_add3_desc;

struct { unsigned short len; unsigned char arr[60]; } l_bill_add3_desc_temp;

struct { unsigned short len; unsigned char arr[5]; } l_dflt_bill_print_in_summ_yn;

struct { unsigned short len; unsigned char arr[3]; } l_detail_report_flag;

struct { unsigned short len; unsigned char arr[4]; } l_print_without_disc_func;

struct { unsigned short len; unsigned char arr[5]; } l_no_settlement_details;

struct { unsigned short len; unsigned char arr[30]; } l_credit_doc_ref_desc;

struct { unsigned short len; unsigned char arr[30]; } l_credit_doc_ref_desc1;

struct { unsigned short len; unsigned char arr[30]; } l_credit_doc_ref_desc2;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[30]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[30]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[30]; } date_convert;

struct { unsigned short len; unsigned char arr[25]; } nd_policy_type_code;

struct { unsigned short len; unsigned char arr[101]; } nd_prev_policy_desc;

struct { unsigned short len; unsigned char arr[2000]; } nd_all_policy_desc;

struct { unsigned short len; unsigned char arr[101]; } nd_policy_desc;

struct { unsigned short len; unsigned char arr[100]; } nd_print_policy_desc;

struct { unsigned short len; unsigned char arr[10]; } nd_cust_code;

struct { unsigned short len; unsigned char arr[100]; } d_mpi_id;

struct { unsigned short len; unsigned char arr[8]; } d_cust_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_cust_doc_num;

struct { unsigned short len; unsigned char arr[100]; } nd_trx_doc_ref;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;


/* VARCHAR	nd_blng_grp			[31],
		nd_nationality		[16],
		nd_cash_counter		[16],
		nd_base_rate_qty	[50],
		nd_cashier_name		[500],
		nd_cahier_position  [500],
		nd_func_role        [500],
		nd_print_date       [50],
		nd_dup_cash_name    [300]; */ 
struct { unsigned short len; unsigned char arr[31]; } nd_blng_grp;

struct { unsigned short len; unsigned char arr[16]; } nd_nationality;

struct { unsigned short len; unsigned char arr[16]; } nd_cash_counter;

struct { unsigned short len; unsigned char arr[50]; } nd_base_rate_qty;

struct { unsigned short len; unsigned char arr[500]; } nd_cashier_name;

struct { unsigned short len; unsigned char arr[500]; } nd_cahier_position;

struct { unsigned short len; unsigned char arr[500]; } nd_func_role;

struct { unsigned short len; unsigned char arr[50]; } nd_print_date;

struct { unsigned short len; unsigned char arr[300]; } nd_dup_cash_name;
 	


		
/* VARCHAR	nd_file_name [50],
		nd_hosp_name[1000],
		nd_add		[1000],
		nd_add_ln	[1000],
		nd_add_ln1	[1000],
		nd_add_ln2	[1000],
		nd_add_ln3	[1000],
		nd_add_ln4	[1000],
		nd_area_desc[1000],
		nd_town_desc[1000],
	    nd_tel_fax	[1000],
		nd_telfax	[1000],

		nd_lang_id	[4]; */ 
struct { unsigned short len; unsigned char arr[50]; } nd_file_name;

struct { unsigned short len; unsigned char arr[1000]; } nd_hosp_name;

struct { unsigned short len; unsigned char arr[1000]; } nd_add;

struct { unsigned short len; unsigned char arr[1000]; } nd_add_ln;

struct { unsigned short len; unsigned char arr[1000]; } nd_add_ln1;

struct { unsigned short len; unsigned char arr[1000]; } nd_add_ln2;

struct { unsigned short len; unsigned char arr[1000]; } nd_add_ln3;

struct { unsigned short len; unsigned char arr[1000]; } nd_add_ln4;

struct { unsigned short len; unsigned char arr[1000]; } nd_area_desc;

struct { unsigned short len; unsigned char arr[1000]; } nd_town_desc;

struct { unsigned short len; unsigned char arr[1000]; } nd_tel_fax;

struct { unsigned short len; unsigned char arr[1000]; } nd_telfax;

struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

		

char loc_legend[999][201];
/* VARCHAR rep_title[500]; */ 
struct { unsigned short len; unsigned char arr[500]; } rep_title;
					
char nd_reprint_yn, discount_print_yn, sett_print_yn, l_include_refund,st_var[100];
char print_y, rec_out, grp_out, sec_box_out,st_var[100];
		
char    filename[300];
char	l_mesg[300];
char    d_summary_yn, nd_lang_ind, nd_online_print_yn,l_print_option;

long    d_age, max_lines = 11;
int     d_max_line =37,
        d_cur_line =0,
		m_length=0;

int i;
int nd_visit_id,nd_acct_seq_no,nd_priority,nd_cnt_policy,nd_trx_doc_ref_line_num;

int l_lno = 0,policy_len=0,line_cnt=0,
    slno  = 0;

int     l_bill_print_opt_for_disc_print,cnt=0;
int	    l_page_no = 0,l_dmp = 0, l_lsr = 0,l_margin_len= 30,l_bill_page_no = 0,
        l_main_hdr = 1;

int r_ctr = 0;
		
double     d_serv_disc_amt = 0,
		   d_service_amt = 0,
		   d_upd_net_charge_amt=0,
		   d_upd_disc_amt=0,
		   d_service_net = 0,
		   d_service_disc = 0,
		   d_service_qty,
		   nd_tot_spl_agency_amt = 0,
		   nd_spl_agency_amt = 0,
		   d_service_amt_tot = 0,
		   deposit_tot		 = 0,
		   bi_tot			 = 0,
		   amt_payable		 = 0,
		   nd_base_charge	 = 0,
		   nd_addl_charge	 = 0,
		   nd_tot_base_charge =0,
		   nd_tot_pat_payble  =0,
		   nd_tot_cust_payble =0,
		   nd_pat_payble	 = 0,
		   nd_cust_payble	 = 0,
		   d_base_rate,
		   less_billed_amt;

char	l_bill_tot_adjust_amt_str[100];
char	l_bill_tot_exempt_amt_str[100];
char	l_bill_tot_write_off_amt_str[100];
char	l_less_amt_str[1000],l_less_ins_amt_str[1000],l_less_ins_amt_dtl[1000]; 		   



long 	ccount  = 0,
		glcheck = 1,
		gcount  = 0,
		rcheck	= 0,
		last_line_check = 0,
		d_base_qty;

//Added by Rudradip for Package Billing Start

/* VARCHAR p_pkg_amt_str	    [200],
		p_pkg_dep_str	    [200],
		p_dep_str			[200],
		p_pkg_seq_num_str   [200],
		temp_pkg_amt_str	[200],
		temp_pkg_dep_str	[200],
		temp_dep_str		[200],
		temp_pkg_seq_num_str[200],
		nd_package_code		[10],
		nd_package_desc		[100],
		l_pkg_seq_num		[50],
		p_no_of_pkgs		[50],
		nd_round_flag		[2],
		p_err_level			[10],
		p_sys_message_id	[10],
		p_error_text		[200]; */ 
struct { unsigned short len; unsigned char arr[200]; } p_pkg_amt_str;

struct { unsigned short len; unsigned char arr[200]; } p_pkg_dep_str;

struct { unsigned short len; unsigned char arr[200]; } p_dep_str;

struct { unsigned short len; unsigned char arr[200]; } p_pkg_seq_num_str;

struct { unsigned short len; unsigned char arr[200]; } temp_pkg_amt_str;

struct { unsigned short len; unsigned char arr[200]; } temp_pkg_dep_str;

struct { unsigned short len; unsigned char arr[200]; } temp_dep_str;

struct { unsigned short len; unsigned char arr[200]; } temp_pkg_seq_num_str;

struct { unsigned short len; unsigned char arr[10]; } nd_package_code;

struct { unsigned short len; unsigned char arr[100]; } nd_package_desc;

struct { unsigned short len; unsigned char arr[50]; } l_pkg_seq_num;

struct { unsigned short len; unsigned char arr[50]; } p_no_of_pkgs;

struct { unsigned short len; unsigned char arr[2]; } nd_round_flag;

struct { unsigned short len; unsigned char arr[10]; } p_err_level;

struct { unsigned short len; unsigned char arr[10]; } p_sys_message_id;

struct { unsigned short len; unsigned char arr[200]; } p_error_text;

		

int l_pkg_len;

double  l_pkg_amt=0,
		l_pkg_dep_amt=0,l_pkg_dep_exist=0,l_pkg_qty = 0,l_payer_amt = 0;



char    p_pkg_seq_num       [1500][201],
		p_pkg_amt			[1500][201],
		p_pkg_dep_amt		[1500][201],
		p_dep_amt			[1500][201];


//Added by Rudradip for Package Billing End


int mcount = 0, nd_decimal = 0,l_tit_len=0;

//char WORKING_DIR [300];

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

char string_var[200], font_wide_on[200], font_wide_off[200], buf[200];

int v_lno = 0,  v_pno = 0;  

FILE *f1;

CHAR nd_str[1000];

/* Main Part */


void proc_main(argc,argv)
char *argv[];
int argc;
{
		
   if (argc < 6)
	{    
		disp_message (ERR_MESG,"Usage : blrvsbl1 username/pwd@connect_string session_id pgm_date facility_id calling_pgm_id [filename]\n");
		proc_exit();
	}
   
   
   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   nd_session_id.len = 0;
   nd_session_id.arr[nd_session_id.len] = '\0';

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);
   nd_session_id.arr[nd_session_id.len] = '\0'; 

   nd_pgm_date.len = 0;
   nd_pgm_date.arr[nd_pgm_date.len] = '\0';
   
   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);
   nd_pgm_date.arr[nd_pgm_date.len] = '\0';

   strcpy(nd_facility_id.arr,argv[4]);
   nd_facility_id.len = strlen(nd_facility_id.arr);
   nd_facility_id.arr[nd_facility_id.len] = '\0';

   strcpy(nd_calling_pgm_id.arr,argv[5]);		
	nd_calling_pgm_id.len = strlen(nd_calling_pgm_id.arr);	
	nd_calling_pgm_id.arr[nd_calling_pgm_id.len] = '\0';

   if (argc > 6) 
   strcpy(nd_file_name.arr,argv[6]);
   else 
   strcpy(nd_file_name.arr,"blrvsbl6.lis");
   
   nd_file_name.len = strlen(nd_file_name.arr);
   nd_file_name.arr[nd_file_name.len] = '\0';  
   
    strcpy(filename,WORKING_DIR);
	
	/****added for for IN16542***/

   if(strcmp(nd_calling_pgm_id.arr,"BLRVSBL5")==0)
   strcat(filename,"BLRVSBL5.lis");
   
   if(strcmp(nd_calling_pgm_id.arr,"BLRVSBL6")==0)
   strcat(filename,"BLRVSBL6.lis");

   /*****end of IN16542****/

       
   //strcat(filename,"BLRVSBL6.lis"); //commented for IN16542

   if( (f1=fopen(filename,"w")) == NULL) 
   {
	disp_message(ERR_MESG,"Error in opening output file...\n");
	proc_exit();
   } 

   nd_fm_doc_type.arr[0]    = '\0';
   nd_fm_doc_num.arr[0]     = '\0';
   nd_fm_doc_date.arr[0]    = '\0';
   nd_to_doc_type.arr[0]    = '\0';
   nd_to_doc_num.arr[0]     = '\0';
   nd_to_doc_date.arr[0]    = '\0';
   trx_type.arr[0]			= '\0';

   nd_fm_doc_type.len       = 0;
   nd_fm_doc_num.len        = 0;
   nd_fm_doc_date.len       = 0;
   nd_to_doc_type.len       = 0;
   nd_to_doc_num.len        = 0;
   nd_to_doc_date.len       = 0;

   trx_type.len				= 0;

      nd_dup_cash_name.arr[0]='\0';
	  nd_dup_cash_name.len=0;



   /* EXEC SQL CONNECT :uid_pwd; */ 

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


	
  if(OERROR)
   {
      disp_message (ORA_MESG,"Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
         disp_message (ERR_MESG,"Null oracle uid/pwd\n\n\n");
         proc_exit();
   }
 
   set_meduser_role();

   uid.arr[0] = '\0';
		uid.len	   =	0;

		/* EXEC SQL select GET_TRACE_TIMESTAMP,substr(:uid_pwd,0,instr(:uid_pwd,'/')-1)
			 into P_START_TIME,
				  :uid
			  from dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select GET_TRACE_TIMESTAMP ,substr(:b0,0,(instr(:b0,'/')-1)\
) into :b2,:b3  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )134;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[1] = (unsigned int  )134;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&P_START_TIME;
  sqlstm.sqhstl[2] = (unsigned int  )62;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&uid;
  sqlstm.sqhstl[3] = (unsigned int  )134;
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



		 uid.arr[uid.len] = '\0';


	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len;

	fetch_legend_value();
 
    fetch_sy_prog_param(); 

   /* EXEC SQL DELETE FROM SY_PROG_PARAM
			  WHERE PGM_ID     = 'BLRVSBL6'
				AND SESSION_ID = :nd_session_id
				AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRVSBL6' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )67;
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



   l_logo_yniflaser.arr[0] = 'N';

   nd_hosp_name.arr[0] = '\0';
   nd_hosp_name.len = 0;            

   nd_acc_entity_code.arr[0] = '\0';
   nd_acc_entity_code.len = 0;

   nd_add_ln1.arr[0] = '\0';
   nd_add_ln1.len = 0;
   
   nd_add_ln2.arr[0] = '\0';
   nd_add_ln2.len = 0;

   nd_add_ln3.arr[0] = '\0';
   nd_add_ln3.len = 0;

   nd_add_ln4.arr[0] = '\0';
   nd_add_ln4.len = 0;
   
   nd_area_desc.arr[0] = '\0';
   nd_area_desc.len = 0;

   nd_town_desc.arr[0] = '\0';
   nd_town_desc.len = 0;

   nd_tel_fax.arr[0] = '\0';
   nd_tel_fax.len = 0;


   comp_name.arr[0] = '\0';
	rep_date.arr[0]  = '\0';
	oper_id.arr[0]	 = '\0';
	currency.arr[0] = '\0';
		
	currency.len = 0;
	comp_name.len	= 0;
	rep_date.len	= 0;
	oper_id.len		= 0;

/*
   strcpy(filename,WORKING_DIR);
   strcat(filename,"BLRVSBL6.lis");

   if( (f1=fopen(filename,"w")) == NULL) {
	disp_message(ERR_MESG,"Error in opening output file...\n");
	proc_exit();
    }
*/
	/* EXEC SQL select acc_entity_code,
            ltrim(lpad(' ',round((:l_margin_len-length(rtrim(substr(UPPER(ACC_ENTITY_NAME),1,50))))/2),' ')||UPPER(rtrim(substr(UPPER(ACC_ENTITY_NAME),1,50)))),
			--LN1_ADD,LN2_ADD,LN3_ADD,
			'TEL:'||TEL_NUM ||'  FAX:'||FAX_NUM,ACC_ENTITY_NAME,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),USER,base_currency
            INTO :nd_acc_entity_code ,
	             :nd_hosp_name,
	             --:nd_add_ln1,:nd_add_ln2,:nd_add_ln3,
	             :nd_tel_fax,:comp_name,:rep_date,:oper_id,:currency
	        from sy_acc_entity 
	        where acc_entity_id = :nd_facility_id and
			language_id=:p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select acc_entity_code ,ltrim((lpad(' ',round(((:b0-length(r\
trim(substr(UPPER(ACC_ENTITY_NAME),1,50))))/2)),' ')||UPPER(rtrim(substr(UPPER\
(ACC_ENTITY_NAME),1,50))))) ,((('TEL:'||TEL_NUM)||'  FAX:')||FAX_NUM) ,ACC_ENT\
ITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') ,USER ,base_currency into :b1,\
:b2,:b3,:b4,:b5,:b6,:b7  from sy_acc_entity where (acc_entity_id=:b8 and langu\
age_id=:b9)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )90;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_acc_entity_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_hosp_name;
 sqlstm.sqhstl[2] = (unsigned int  )1002;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_tel_fax;
 sqlstm.sqhstl[3] = (unsigned int  )1002;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&comp_name;
 sqlstm.sqhstl[4] = (unsigned int  )52;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&rep_date;
 sqlstm.sqhstl[5] = (unsigned int  )22;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&oper_id;
 sqlstm.sqhstl[6] = (unsigned int  )23;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&currency;
 sqlstm.sqhstl[7] = (unsigned int  )18;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[8] = (unsigned int  )5;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&p_language_id;
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



	
	 /* EXEC SQL select 
			ADDR_LINE1,ADDR_LINE2,ADDR_LINE3,ADDR_LINE4,
			e.SHORT_DESC AREA_CODE,d.SHORT_DESC TWN_CODE
			into :nd_add_ln1,:nd_add_ln2,:nd_add_ln3,:nd_add_ln4,
				 :nd_area_desc,:nd_town_desc
			from SM_FACILITY_PARAM_LANG_VW A,mp_res_town_lang_vw D,
			mp_res_area_lang_vw E
			where FACILITY_ID=:nd_facility_id
			--and a.ADDR_POSTAL_CODE=c.POSTAL_CODE
			and a.RES_AREA_CODE =e.RES_AREA_CODE
			and a.RES_TOWN_CODE=d.RES_TOWN_CODE
			and upper(a.language_id)=upper(:p_language_id)
			and upper(d.language_id)=upper(:p_language_id)
			and upper(e.language_id)=upper(:p_language_id); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select ADDR_LINE1 ,ADDR_LINE2 ,ADDR_LINE3 ,ADDR_LINE4 ,e.SH\
ORT_DESC AREA_CODE ,d.SHORT_DESC TWN_CODE into :b0,:b1,:b2,:b3,:b4,:b5  from S\
M_FACILITY_PARAM_LANG_VW A ,mp_res_town_lang_vw D ,mp_res_area_lang_vw E where\
 (((((FACILITY_ID=:b6 and a.RES_AREA_CODE=e.RES_AREA_CODE) and a.RES_TOWN_CODE\
=d.RES_TOWN_CODE) and upper(a.language_id)=upper(:b7)) and upper(d.language_id\
)=upper(:b7)) and upper(e.language_id)=upper(:b7))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )145;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_add_ln1;
  sqlstm.sqhstl[0] = (unsigned int  )1002;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_add_ln2;
  sqlstm.sqhstl[1] = (unsigned int  )1002;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_add_ln3;
  sqlstm.sqhstl[2] = (unsigned int  )1002;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_add_ln4;
  sqlstm.sqhstl[3] = (unsigned int  )1002;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_area_desc;
  sqlstm.sqhstl[4] = (unsigned int  )1002;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_town_desc;
  sqlstm.sqhstl[5] = (unsigned int  )1002;
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
  sqlstm.sqhstv[7] = (         void  *)&p_language_id;
  sqlstm.sqhstl[7] = (unsigned int  )5;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&p_language_id;
  sqlstm.sqhstl[8] = (unsigned int  )5;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&p_language_id;
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


	
	if (OERROR)
	{ 
	    disp_message (ERR_MESG,"Select failed in SY_ACC_ENTITY");
	    proc_exit();
	}

	comp_name.arr[comp_name.len] = '\0';
    rep_date.arr[rep_date.len] = '\0';
    oper_id.arr[oper_id.len] = '\0';
	currency.arr[currency.len] = '\0';

	nd_acc_entity_code.arr[nd_acc_entity_code.len] = '\0';
	nd_hosp_name.arr[nd_hosp_name.len] = '\0';

	nd_add_ln1.arr[nd_add_ln1.len] = '\0';
	nd_add_ln2.arr[nd_add_ln2.len] = '\0';
	nd_add_ln3.arr[nd_add_ln3.len] = '\0';
	nd_add_ln4.arr[nd_add_ln4.len] = '\0';
    nd_area_desc.arr[nd_area_desc.len] = '\0';
	nd_town_desc.arr[nd_town_desc.len] = '\0';

	nd_tel_fax.arr[nd_tel_fax.len] = '\0';

	nd_add_ln.arr[0] = '\0';
	nd_add_ln.len = 0;
	
	if (nd_add_ln1.arr[0] != '\0')
	{
		strcpy(nd_add_ln.arr,nd_add_ln1.arr);
		nd_add_ln.len = strlen(nd_add_ln.arr);
	}

	if (nd_add_ln1.arr[0] == '\0' && nd_add_ln2.arr[0] != '\0')
	{
		strcpy(nd_add_ln.arr,nd_add_ln2.arr);
		nd_add_ln.len = strlen(nd_add_ln.arr);
	}
	else if (nd_add_ln1.arr[0] != '\0' && nd_add_ln2.arr[0] != '\0')
	{
		strcat(nd_add_ln.arr,", ");
		nd_add_ln.len = strlen(nd_add_ln.arr);

		strcat(nd_add_ln.arr,nd_add_ln2.arr);
		nd_add_ln.len = strlen(nd_add_ln.arr);
	}

	if (nd_add_ln1.arr[0] == '\0' && nd_add_ln2.arr[0] == '\0' && nd_add_ln3.arr[0] != '\0')
	{
		strcpy(nd_add_ln.arr,nd_add_ln2.arr);
		nd_add_ln.len = strlen(nd_add_ln.arr);
	}
	else if ((nd_add_ln1.arr[0] != '\0' || nd_add_ln2.arr[0] != '\0') && 
				nd_add_ln3.arr[0] != '\0')
	{
		strcat(nd_add_ln.arr,", ");
		nd_add_ln.len = strlen(nd_add_ln.arr);

		strcat(nd_add_ln.arr,nd_add_ln3.arr);
		nd_add_ln.len = strlen(nd_add_ln.arr);
	}
    
	get_print_routing();


	if (l_lsr != 0 && l_dmp == 0)
	{
	    d_max_line=65;
		if ( l_logo_yniflaser.arr[0] == 'Y')	
	    l_tit_len = 0;
	    else
		l_tit_len = 32;
	}
    if (l_lsr == 0 && l_dmp!= 0) 
	d_max_line=30;
 
	nd_add.arr[0] = '\0';
	nd_add.len = 0;

	/* EXEC SQL SELECT lpad(' ',round((:l_margin_len+:l_tit_len-length(rtrim(:nd_add_ln)))/2),' ')||UPPER(rtrim(:nd_add_ln))
	into :nd_add from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (lpad(' ',round((((:b0+:b1)-length(rtrim(:b2)))/2)),'\
 ')||UPPER(rtrim(:b2))) into :b4  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )200;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_tit_len;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_add_ln;
 sqlstm.sqhstl[2] = (unsigned int  )1002;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_add_ln;
 sqlstm.sqhstl[3] = (unsigned int  )1002;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_add;
 sqlstm.sqhstl[4] = (unsigned int  )1002;
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



	nd_add.arr[nd_add.len] = '\0';


	nd_telfax.arr[0] = '\0';
	nd_telfax.len = 0;
	

	/* EXEC SQL SELECT lpad(' ',round((:l_margin_len+:l_tit_len-length(rtrim(:nd_tel_fax)))/2),' ')||UPPER(rtrim(:nd_tel_fax))
	into :nd_telfax from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (lpad(' ',round((((:b0+:b1)-length(rtrim(:b2)))/2)),'\
 ')||UPPER(rtrim(:b2))) into :b4  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )235;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_tit_len;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_tel_fax;
 sqlstm.sqhstl[2] = (unsigned int  )1002;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_tel_fax;
 sqlstm.sqhstl[3] = (unsigned int  )1002;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_telfax;
 sqlstm.sqhstl[4] = (unsigned int  )1002;
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



	nd_telfax.arr[nd_telfax.len] = '\0';
	
   	

	nd_tot_spl_agency_amt = 0;

	print_hdr();
	
	//close_get_privilige();sai

	declare_service_line_cur();

    //added by rudradip for Package Billing Start

	get_closed_packages();

	l_pkg_qty = 1;

	for(i=1;i<=l_pkg_len;i++)
	{
		
		slno++;
		print_next_page();
		fprintf(f1,"  %3.3d   ",slno); 

		strcpy(l_pkg_seq_num.arr,p_pkg_seq_num[i]); //rudra
		l_pkg_seq_num.len = strlen(p_pkg_seq_num[i]);
		l_pkg_seq_num.arr[l_pkg_seq_num.len] = '\0';
        
		get_pkg_name(); //rudra
	
		fprintf(f1,"%-10.10s",nd_package_code.arr);
		fprintf(f1," %-23.23s",nd_package_desc.arr);
		
		print_formated_amt1(l_pkg_qty);


		l_pkg_amt=atoi(p_pkg_amt[i]);	
		print_formated_amt(l_pkg_amt);

		l_pkg_dep_amt=atoi(p_pkg_dep_amt[i]);
		print_formated_amt(l_pkg_dep_amt);

        l_payer_amt = l_pkg_amt - l_pkg_dep_amt;

		print_formated_amt(l_payer_amt);

		nd_tot_base_charge = nd_tot_base_charge+l_pkg_amt;
		nd_tot_pat_payble  = nd_tot_pat_payble+l_pkg_dep_amt;
		nd_tot_cust_payble = nd_tot_cust_payble+l_payer_amt ;
		
		fprintf(f1,"\n");
		
	}

	//added by rudradip for Package Billing End

	while(fetch_service_line_cur())
	 {
		slno++;
		print_next_page();
		fprintf(f1,"  %3.3d   ",slno); 

 		if (nd_map_code.arr[0]!='\0')
		{
		 fprintf(f1,"%-10.10s",nd_map_code.arr);
		 fprintf(f1," %-23.23s",nd_map_desc.arr);
		}
		else
		{
		fprintf(f1,"%-10.10s",d_service_code.arr);
        fprintf(f1," %-23.23s",d_service_desc.arr);
        }
		print_formated_amt1(d_service_qty);
				
		/*print_formated_amt(d_service_amt); commenetd by raghava on 14/07/2008 as per kuila sir instructions 
										      instead of service amt we are displaying upd_net_charge_amt*/
		

		/***added for IN13918****/
		print_formated_amt(nd_base_charge);

		if(strcmp(nd_cust_code.arr,"\0")==0)
		{
		nd_pat_payble=d_upd_net_charge_amt;
		get_payer_Payable();
		}
		else
		{
			nd_cust_payble=d_upd_net_charge_amt;
			get_patient_payable();
		}

		//print_formated_amt(d_upd_net_charge_amt); //commented for IN13918
		
		print_formated_amt(nd_pat_payble);
		
		print_formated_amt(nd_cust_payble);

		/****** END OF IN13918***/

		fprintf(f1,"\n");
				
		nd_tot_base_charge = nd_tot_base_charge+nd_base_charge;
		nd_tot_pat_payble  = nd_tot_pat_payble+nd_pat_payble;
		nd_tot_cust_payble = nd_tot_cust_payble+nd_cust_payble;

		
		//d_service_amt_tot = d_service_amt_tot+d_upd_net_charge_amt; //commentd for IN13918
		//d_service_amt_tot = d_service_amt_tot+d_service_amt;
		  
	 }

	 close_service_line_cur();

	fprintf(f1,"--------------------------------------------------------------------------------------------------------\n");
	
	fprintf(f1,"%47.47s :  ",loc_legend[10]);

	/****IN13918***/

	print_formated_amt(nd_tot_base_charge);
	print_formated_amt(nd_tot_pat_payble);
	print_formated_amt(nd_tot_cust_payble);

	/****** END OF IN13918***/


	//print_formated_amt(d_service_amt_tot); //comented for IN13918
	      
	fprintf(f1,"\n %s",loc_legend[21]);
	//fprintf(f1,"\n                                                                         %s\n",loc_legend[20]);    
	fprintf(f1,"\n%-65s %-s\n"," ",loc_legend[20]);    
	
	    
	get_cashier_name();
	get_cashier_designation();

	//fprintf(f1,"                                                                                   (%s)\n",nd_cashier_name.arr);
	  
	  fprintf(f1,"%-66s"," "); 

      strcpy(nd_dup_cash_name.arr, "(");
      strcat(nd_dup_cash_name.arr, nd_cashier_name.arr);

      m_length=0;
	  m_length=strlen(nd_dup_cash_name.arr); 

	  if(m_length<=23)
	  {
	  strcat(nd_dup_cash_name.arr,")");
	  m_length=strlen(loc_legend[20]); 
	  fun_centre(nd_dup_cash_name.arr,m_length);
	  fprintf(f1,"%-24.24s",nd_dup_cash_name.arr);
 
      }
      else
	  {
	  m_length=0;  
	  m_length=strlen(loc_legend[20]); 
	  fun_centre(nd_dup_cash_name.arr,m_length);
	  fprintf(f1,"%-23.23s)",nd_dup_cash_name.arr);
	  }

	  fprintf(f1,"\n");

   // fprintf(f1,"                                                                                 %s\n",nd_cahier_position.arr);
   	  
	  m_length=0;
	  fprintf(f1,"%-66s"," ");
	  m_length=strlen(loc_legend[20]);
	  fun_centre(nd_cahier_position.arr,m_length);
	  fprintf(f1,"%-30.30s",nd_cahier_position.arr);
	  fprintf(f1,"\n");

 	
    fprintf(f1,"\n%79.79s ",loc_legend[22]); 
	nd_curr_date.arr[0] = '\0';
	nd_curr_date.len = 0;

	/* EXEC SQL SELECT to_Char(Sysdate,'dd/mm/rrrr hh12:mi:ss AM')
	         Into :nd_curr_date
			 From dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select to_Char(Sysdate,'dd/mm/rrrr hh12:mi:ss AM') into :b0 \
 from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )270;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_curr_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
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


    nd_curr_date.arr[nd_curr_date.len] = '\0';

    if(nd_curr_date.arr[0]!='\0')
	{
		init_date_temp_var();
		strcpy(date_convert.arr,nd_curr_date.arr);
		fun_change_loc_date();
    }


	fprintf(f1,"%s",date_convert.arr);

	fflush(f1);
	
	fclose(f1);  

	/* EXEC SQL COMMIT WORK; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )289;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



       if (OERROR)
	 err_mesg("COMMIT failed",0,""); 
    
    end_prog_msg();

    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )304;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
	 err_mesg("COMMIT WORK RELEASE failed REA",0,"");


	if(strcmp(nd_calling_pgm_id.arr,"BLRVSBL5")==0)
	{
		/* EXEC SQL EXECUTE
	    BEGIN
	        TRACE_DURATION_BL(
			 :nd_calling_pgm_id ,
			 'Service Item List Report Spooling' ,
			 :P_START_TIME ,
			 :uid );
	     END;
	    END-EXEC ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin TRACE_DURATION_BL ( :nd_calling_pgm_id , 'Service Ite\
m List Report Spooling' , :P_START_TIME , :uid ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )319;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_calling_pgm_id;
  sqlstm.sqhstl[0] = (unsigned int  )12;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&P_START_TIME;
  sqlstm.sqhstl[1] = (unsigned int  )62;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&uid;
  sqlstm.sqhstl[2] = (unsigned int  )134;
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
	
	if(strcmp(nd_calling_pgm_id.arr,"BLRVSBL6")==0)
	{
		/* EXEC SQL EXECUTE
	    BEGIN
	        TRACE_DURATION_BL(
			 :nd_calling_pgm_id ,
			 'Specific Service Item List Report Spooling' ,
			 :P_START_TIME ,
			 :uid );
	     END;
	    END-EXEC ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin TRACE_DURATION_BL ( :nd_calling_pgm_id , 'Specific Se\
rvice Item List Report Spooling' , :P_START_TIME , :uid ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )346;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_calling_pgm_id;
  sqlstm.sqhstl[0] = (unsigned int  )12;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&P_START_TIME;
  sqlstm.sqhstl[1] = (unsigned int  )62;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&uid;
  sqlstm.sqhstl[2] = (unsigned int  )134;
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


   //get_print_routing(); Commented by raghava 

   if (nd_online_print_yn == 'Y')
	{
		       
				PrintDocument(uid_pwd.arr,			 //char	*PUidPwd;
						nd_session_id.arr,			//char	*PSessionID;
						nd_facility_id.arr,			//char	*PFacilityID;
						"BL",						//char	*PModuleID;
						nd_calling_pgm_id.arr,		//char	*PDocumentID;
						filename,			        //char	*POnlinePrintFileNames;
						"O",						//char	*PLocationTypes;
						" ",						//char	*PLocationCodes;
						1,							//int		PNumOfCopies;
						1,							//int		PPageFrom;
						9999);						//int		PPageTo;);


		/* EXEC SQL select GET_TRACE_TIMESTAMP into :P_START_TIME  from dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select GET_TRACE_TIMESTAMP into :b0  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )373;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&P_START_TIME;
  sqlstm.sqhstl[0] = (unsigned int  )62;
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



		if(strcmp(nd_calling_pgm_id.arr,"BLRVSBL5")==0)
	{
		/* EXEC SQL EXECUTE
	    BEGIN
	        TRACE_DURATION_BL(
			 :nd_calling_pgm_id ,
			 'Service Item List Report Print Routing' ,
			 :P_START_TIME ,
			 :uid );
	     END;
	    END-EXEC ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin TRACE_DURATION_BL ( :nd_calling_pgm_id , 'Service Ite\
m List Report Print Routing' , :P_START_TIME , :uid ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )392;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_calling_pgm_id;
  sqlstm.sqhstl[0] = (unsigned int  )12;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&P_START_TIME;
  sqlstm.sqhstl[1] = (unsigned int  )62;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&uid;
  sqlstm.sqhstl[2] = (unsigned int  )134;
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
	
	if(strcmp(nd_calling_pgm_id.arr,"BLRVSBL6")==0)
	{
		/* EXEC SQL EXECUTE
	    BEGIN
	        TRACE_DURATION_BL(
			 :nd_calling_pgm_id ,
			 'Specific Service Item List Report Print Routing' ,
			 :P_START_TIME ,
			 :uid );
	     END;
	    END-EXEC ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin TRACE_DURATION_BL ( :nd_calling_pgm_id , 'Specific Se\
rvice Item List Report Print Routing' , :P_START_TIME , :uid ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )419;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_calling_pgm_id;
  sqlstm.sqhstl[0] = (unsigned int  )12;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&P_START_TIME;
  sqlstm.sqhstl[1] = (unsigned int  )62;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&uid;
  sqlstm.sqhstl[2] = (unsigned int  )134;
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
			    
			   
	} 



	return 1;
}

print_next_page()
{
    d_cur_line++;
 if(d_cur_line==d_max_line) 
  {
   //l_page_no++;
   fprintf(f1,"\f");
   fprintf(f1,"\n");
   //fprintf(f1,"\n%97.97s %d\n",loc_legend[17],l_page_no);
   print_hdr();
  }
}
get_cashier_name()
{

  nd_cashier_name.arr[0]='\0';
  nd_cashier_name.len	  =0; 

  /* EXEC SQL SELECT DISTINCT APPL_USER_NAME
  INTO  :nd_cashier_name
  FROM   SM_APPL_USER_LANG 
  WHERE  APPL_USER_ID=:d_added_by_id
  AND	 LANGUAGE_ID  =:p_language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select distinct APPL_USER_NAME into :b0  from SM_APPL_USER_\
LANG where (APPL_USER_ID=:b1 and LANGUAGE_ID=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )446;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_cashier_name;
  sqlstm.sqhstl[0] = (unsigned int  )502;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_added_by_id;
  sqlstm.sqhstl[1] = (unsigned int  )102;
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
	  { 
		disp_message (ERR_MESG,"FETCH FAILED FROM SM_APPL_USER TABLE");
	  }
 
  nd_cashier_name.arr[nd_cashier_name.len]='\0';
   
}


get_cashier_designation()
{
 
 
 nd_cahier_position.arr[0] ='\0';
 nd_cahier_position.len	   = 0;
 nd_func_role.len=0;

 /* EXEC SQL EXECUTE
    
	BEGIN
		
		SELECT FUNC_ROLE 
		INTO :nd_func_role
        FROM SM_APPL_USER_LANG_VW 
		WHERE  APPL_USER_ID=:d_added_by_id
        AND	 LANGUAGE_ID  =:p_language_id;

		SELECT long_desc 
		INTO :nd_cahier_position
		FROM sm_appl_user_lang_vw a,am_other_staff b,am_other_staff_type_lang_vw C
		WHERE a.appl_user_id=:d_added_by_id
		AND a.FUNC_ROLE=:nd_func_role
		AND b.OTHER_STAFF_ID = a.FUNC_ROLE_ID
		AND c.OTHER_STAFF_TYPE = b.OTHER_STAFF_TYPE
		AND c.language_id=:p_language_id
		AND a.language_id=c.language_id;

	END;

END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SELECT FUNC_ROLE INTO :nd_func_role FROM SM_APPL_USER_\
LANG_VW WHERE APPL_USER_ID = :d_added_by_id AND LANGUAGE_ID = :p_language_id ;\
 SELECT long_desc INTO :nd_cahier_position FROM sm_appl_user_lang_vw a , am_ot\
her_staff b , am_other_staff_type_lang_vw C WHERE a . appl_user_id = :d_added_\
by_id AND a . FUNC_ROLE = :nd_func_role AND b . OTHER_STAFF_ID = a . FUNC_ROLE\
_ID AND c . OTHER_STAFF_TYPE = b . OTHER_STAFF_TYPE AND c . language_id = :p_l\
anguage_id AND a . language_id = c . language_id ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )473;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_func_role;
 sqlstm.sqhstl[0] = (unsigned int  )502;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_added_by_id;
 sqlstm.sqhstl[1] = (unsigned int  )102;
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
 sqlstm.sqhstv[3] = (         void  *)&nd_cahier_position;
 sqlstm.sqhstl[3] = (unsigned int  )502;
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


 
    
    nd_cahier_position.arr[nd_cahier_position.len]='\0';

 if (OERROR)
	  { 
		disp_message (ERR_MESG,"FETCH FAILED FROM SM_APPL_USER TABLE");
	  }

 
}

get_print_routing()
{
	/* EXEC SQL EXECUTE
	DECLARE
		l_sys_mesg_id VARCHAR2(10);
		l_err_level VARCHAR2(10);
		l_err_text VARCHAR2(1000);
		l_document_value blcommon.rectype_Tab;
		l_format_type VARCHAR2(200);
		l_report_tool_ind VARCHAR2(1);
	BEGIN
	
		blcommon.get_doc_print_format_Tab(
     			:nd_facility_id,
			:nd_calling_pgm_id,
			l_document_value,
			l_sys_mesg_id,
			l_err_level,
			l_err_text);						

		FOR i IN l_document_value.FIRST..l_document_value.LAST LOOP
			if  l_document_value(i).id = 'FORMAT_TYPE' then
				l_format_type := l_document_value(i).value;
			end if;				
			
			if l_document_value(i).id = 'REPORT_TOOL_IND' then 
				l_report_tool_ind := l_document_value(i).value;
			end if;		 	

			if l_document_value(i).id = 'INCL_PRV_RFND_AMT_IN_TOT_OUTST' then 
				:l_include_refund := NVL(l_document_value(i).value,'N');
			end if;		 			
		END LOOP;		

		if l_format_type = 'DMP_PREPRINTED' then
			:l_dmp := 1;
			:l_lsr := 0;
		elsif l_format_type in('LASER_WITH_LOGO','LASER_WITHOUT_LOGO') then
			:l_dmp := 0;
			:l_lsr := 1;
		else
			:l_dmp := 0;
			:l_lsr := 0;
		end if;
		
		if :l_dmp = 0 and :l_lsr = 0 then

			APPPRINT.GET_ROUTING_PRINTERS(
			 :nd_ws_no,
			 :d_cashfacility_id,
			 'BL',
			 :nd_calling_pgm_id,
			 'O',
			 ' ',
			 :l_printer_ids,
			 :l_printer_names,
			 :l_printer_types, 
			 :l_queue_names,
			 :l_no_of_copies,
			 :l_errortext);

			 :l_dmp := NVL(instr(:l_printer_types,'D'),0);
			 :l_lsr := NVL(instr(:l_printer_types,'S'),0);			 

			 if :l_dmp != 0 and :l_lsr != 0 then 
			    :l_dmp := 0;
			    --if there is a laser setup, then output format will be laser
			 end if;	

			 if :l_dmp = 0 and :l_lsr = 0 then 
			    :l_lsr := 1;
			    --Default is Laser Format
			 end if;	 		 
		end if;

END;
END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 13;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "declare l_sys_mesg_id VARCHAR2 ( 10 ) ; l_err_level VARCHAR2 ( 10 ) ; l_\
err_text VARCHAR2 ( 1000 ) ; l_document_value blcommon . rectype_Tab ; l_for\
mat_type VARCHAR2 ( 200 ) ; l_report_tool_ind VARCHAR2 ( 1 ) ; BEGIN blcommo\
n . get_doc_print_format_Tab ( :nd_facility_id , :nd_calling_pgm_id , l_docu\
ment_value , l_sys_mesg_id , l_err_level , l_err_text ) ; FOR i IN l_documen\
t_value . FIRST .. l_document_value . LAST LOOP if l_document_value ( i ) . \
id = 'FORMAT_TYPE' then l_format_type := l_document_value ( i ) . value ; en\
d if ; if l_document_value ( i ) . id = 'REPORT_TOOL_IND' then l_report_tool\
_ind := l_document_value ( i ) . value ; end if ; if l_document_value ( i ) \
. id = 'INCL_PRV_RFND_AMT_IN_TOT_OUTST' then :l_include_refund := NVL ( l_do\
cument_value ( i ) . value , 'N' ) ; end if ; END LOOP ; if l_format_type = \
'DMP_PREPRINTED' then :l_dmp := 1 ; :l_lsr := 0 ; elsif l_format_type in ( '\
LASER_WITH_LOGO' , 'LASER_WITHOUT_LOGO' ) then :l_dmp := 0 ; :l_lsr := 1 ; e\
lse :l_dmp := 0 ; :l_lsr := 0 ; end if ;");
 sqlstm.stmt = " if :l_dmp = 0 and :l_lsr = 0 then APPPRINT . GET_ROUTING_PR\
INTERS ( :nd_ws_no , :d_cashfacility_id , 'BL' , :nd_calling_pgm_id , 'O' , ' \
' , :l_printer_ids , :l_printer_names , :l_printer_types , :l_queue_names , :l\
_no_of_copies , :l_errortext ) ; :l_dmp := NVL ( instr ( :l_printer_types , 'D\
' ) , 0 ) ; :l_lsr := NVL ( instr ( :l_printer_types , 'S' ) , 0 ) ; if :l_dmp\
 != 0 and :l_lsr != 0 then :l_dmp := 0 ; end if ; if :l_dmp = 0 and :l_lsr = 0\
 then :l_lsr := 1 ; end if ; end if ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )504;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_calling_pgm_id;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_include_refund;
 sqlstm.sqhstl[2] = (unsigned int  )1;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_dmp;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_lsr;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[5] = (unsigned int  )42;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_cashfacility_id;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_printer_ids;
 sqlstm.sqhstl[7] = (unsigned int  )1002;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_printer_names;
 sqlstm.sqhstl[8] = (unsigned int  )1002;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_printer_types;
 sqlstm.sqhstl[9] = (unsigned int  )1002;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_queue_names;
 sqlstm.sqhstl[10] = (unsigned int  )1002;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&l_no_of_copies;
 sqlstm.sqhstl[11] = (unsigned int  )1002;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&l_errortext;
 sqlstm.sqhstl[12] = (unsigned int  )1002;
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



		if ( l_errortext.arr[0] != '\0')
		{
			l_errortext.arr[0] = '\0';
			l_errortext.len = 0;
		}

}
	



/* Procedure Part */

fetch_sy_prog_param()
{
	l_detail_report_flag.arr[0] = '\0';
   l_print_without_disc_func.arr[0] = '\0';
   l_no_settlement_details.arr[0] = '\0';   
   nd_ws_no.arr[0] = '\0';
   nd_ws_no.len = 0;
   nd_logo_pgm_id.arr[0]	= '\0';

   nd_logo_pgm_id.len	= 0;


   dc_doc_type_code.arr[0] ='\0';
   d_doc_num.arr[0]		   ='\0';
   nd_Serv_Group.arr[0]    ='\0';
   rep_title.arr[0]        ='\0';
   
   dc_doc_type_code.len = 0;
   d_doc_num.len			= 0;
   nd_Serv_Group.len =0;
   rep_title.len =0;
   
   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
					PARAM1,
					PARAM2,
					PARAM3,
					PARAM4
				   // PARAM5 
			  INTO  :nd_facility_id,
			  :dc_doc_type_code,
			  :d_doc_num,
			  :nd_Serv_Group,
			  :nd_online_print_yn
			  //,:rep_title commneted by vani
              FROM SY_PROG_PARAM
              WHERE PGM_ID     = 'BLRVSBL6'
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 13;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 into :b0,:b1,:b2,:b3,:b4  from SY_PROG_PARAM where ((PGM_ID='BLRVSBL6' and \
SESSION_ID=:b5) and PGM_DATE=:b6)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )571;
   sqlstm.selerr = (unsigned short)1;
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
   sqlstm.sqhstv[1] = (         void  *)&dc_doc_type_code;
   sqlstm.sqhstl[1] = (unsigned int  )9;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_doc_num;
   sqlstm.sqhstl[2] = (unsigned int  )11;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_Serv_Group;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_online_print_yn;
   sqlstm.sqhstl[4] = (unsigned int  )1;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[5] = (unsigned int  )18;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[6] = (unsigned int  )15;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

	//added by vani
		/* EXEC SQL Select Short_Desc ||' Service Item List'
		Into :rep_title
		From  BL_BLNG_SERV_GRP
		Where SERV_GRP_CODE=:nd_Serv_Group; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 13;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select (Short_Desc||' Service Item List') into :b0  from BL\
_BLNG_SERV_GRP where SERV_GRP_CODE=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )614;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&rep_title;
  sqlstm.sqhstl[0] = (unsigned int  )502;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_Serv_Group;
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


	//upto here
		
	if (OERROR)
    err_mesg("SELECT failed on table BL_BLNG_SERV_GRP",0,"");

   if (NODATAFOUND)
			strcpy(rep_title.arr,"Service Item List");
        

strcpy(loc_legend[2],rep_title.arr);

	dc_doc_type_code.arr[dc_doc_type_code.len]			= '\0';
	d_doc_num.arr[d_doc_num.len]						= '\0';
	nd_Serv_Group.arr[nd_Serv_Group.len]                = '\0';
	rep_title.arr[rep_title.len]                        = '\0';
   nd_facility_id.arr[nd_facility_id.len]				= '\0';
      	
	strcpy(g_facility_id,nd_facility_id.arr);


}



declare_service_line_cur()

{
		

    /* EXEC SQL DECLARE BL_BILL_SERV_LINE_CUR CURSOR FOR
         SELECT    B.PACKAGE_SERVICE_CODE,
            NVL(b.serv_item_desc,c.long_desc),
            TO_CHAR(B.SERVICE_DATE,'DD/MM/YYYY'),
            NVL(B.SERV_QTY,0), 
            NVL(B.ORG_GROSS_CHARGE_AMT,0),
            NVL(B.ORG_NET_CHARGE_AMT,0),
            NVL(B.ORG_DISC_AMT,0),
            NVL(B.UPD_NET_CHARGE_AMT,0),
            NVL(B.UPD_DISC_AMT,0),
            B.BASE_RATE,
            B.BASE_QTY,
            TO_CHAR(B.BASE_RATE)||'/'||TO_CHAR(B.BASE_QTY),
            BASE_CHARGE_AMT,
            ADDL_CHARGE_AMT_IN_CHARGE,
            TRX_DOC_REF    ,
            TRX_DOC_REF_LINE_NUM,
            CUST_CODE
         FROM  BL_PATIENT_CHARGES_FOLIO B,
                    BL_BLNG_SERV  C
         WHERE            
            B.OPERATING_FACILITY_ID = :nd_facility_id     AND
            B.BILL_DOC_TYPE_CODE        =:dc_doc_type_code      AND
            to_char(B.BILL_DOC_NUM)              = :d_doc_num           AND
            nvl(b.package_trx_yn,'N')='N' and //Added by Rudradip for Package Billing 
            B.BLNG_SERV_CODE    = C.BLNG_SERV_CODE (+)    AND
            nvl(:nd_Serv_Group,BLCOMMON.GET_SERVICE_GROUP_HDR_CODE(B.BLNG_SERV_CODE)) = BLCOMMON.GET_SERVICE_GROUP_HDR_CODE(B.BLNG_SERV_CODE) AND
        (
        trx_status is null 
        OR 
        ( 
            trx_status = 'C' and (
                        orig_doc_ref is null 
                        and 0 = ( select count(1) from bl_patient_charges_folio
                              where operating_facility_id = :nd_facility_id
                              and bill_doc_type_code =:dc_doc_type_code
                              and to_char(bill_doc_num) =:d_doc_num
                              and orig_doc_ref = b.trx_doc_ref
                              and orig_doc_ref_line_num = b.trx_doc_ref_line_num
                              and orig_doc_ref_seq_num = b.trx_doc_ref_seq_num
                             )
                         )
                     OR
                             (
                        orig_doc_ref is not null 
                        and 0 = ( select count(1) from bl_patient_charges_folio
                              where operating_facility_id =:nd_facility_id
                              and bill_doc_type_code =:dc_doc_type_code
                              and to_char(bill_doc_num) =:d_doc_num
                              and trx_doc_ref = b.orig_doc_ref
                              and trx_doc_ref_line_num = b.orig_doc_ref_line_num
                              and trx_doc_ref_seq_num = b.orig_doc_ref_seq_num
                             )
                         )
        )
               )
UNION ALL  //Added by Rudradip for Package Billing Start              
SELECT    B.BLNG_SERV_CODE,
            c.long_desc,
            TO_CHAR(B.SERVICE_DATE,'DD/MM/YYYY'),
            NVL(B.SERV_QTY,0), 
            NVL(B.ORG_GROSS_CHARGE_AMT,0),
            NVL(B.ORG_NET_CHARGE_AMT,0),
            NVL(B.ORG_DISC_AMT,0),
            NVL(B.UPD_NET_CHARGE_AMT,0),
            NVL(B.UPD_DISC_AMT,0),
            a.BASE_RATE,
            a.BASE_QTY,
            TO_CHAR(a.BASE_RATE)||'/'||TO_CHAR(a.BASE_QTY),
            a.BASE_CHARGE_AMT,
            a.ADDL_CHARGE_AMT_IN_CHARGE,
            b.TRX_DOC_REF    ,
            b.TRX_DOC_REF_LINE_NUM,
            b.CUST_CODE
         from
          BL_PAckage_FOLIO B, bl_patient_charges_folio a,
          BL_BLNG_SERV  C
         WHERE            
            B.OPERATING_FACILITY_ID = :nd_facility_id     AND
            b.package_trx_yn='N' and
            B.BLNG_SERV_CODE    = C.BLNG_SERV_CODE     AND
            a.trx_doc_ref = b.trx_doc_ref and
            a.trx_doc_ref_line_num=b.trx_doc_ref_line_num and
            a.trx_doc_ref_seq_num=b.trx_doc_ref_seq_num and
            nvl(:nd_Serv_Group,BLCOMMON.GET_SERVICE_GROUP_HDR_CODE(B.BLNG_SERV_CODE)) = BLCOMMON.GET_SERVICE_GROUP_HDR_CODE(B.BLNG_SERV_CODE) AND 
          (b.TRX_DOC_REF    , b.TRX_DOC_REF_LINE_NUM) in
         (select TRX_DOC_REF    , TRX_DOC_REF_LINE_NUM
         FROM  BL_PATIENT_CHARGES_FOLIO B,
                    BL_BLNG_SERV  C
         WHERE            
            B.OPERATING_FACILITY_ID = :nd_facility_id     AND
            B.BILL_DOC_TYPE_CODE        =:dc_doc_type_code      AND
            to_char(B.BILL_DOC_NUM)              = :d_doc_num           AND
            nvl(b.package_trx_yn,'N')='P'  and
            B.BLNG_SERV_CODE    = C.BLNG_SERV_CODE (+)    AND
            nvl(:nd_Serv_Group,BLCOMMON.GET_SERVICE_GROUP_HDR_CODE(B.BLNG_SERV_CODE)) = BLCOMMON.GET_SERVICE_GROUP_HDR_CODE(B.BLNG_SERV_CODE) 
        and 
        (
        trx_status is null 
        OR 
        ( 
            trx_status = 'C' and (
                        orig_doc_ref is null 
                        and 0 = ( select count(1) from bl_patient_charges_folio
                              where operating_facility_id = :nd_facility_id
                              and bill_doc_type_code =:dc_doc_type_code
                              and to_char(bill_doc_num) =:d_doc_num
                              and orig_doc_ref = b.trx_doc_ref
                              and orig_doc_ref_line_num = b.trx_doc_ref_line_num
                              and orig_doc_ref_seq_num = b.trx_doc_ref_seq_num
                             )
                         )
                     OR
                             (
                        orig_doc_ref is not null 
                        and 0 = ( select count(1) from bl_patient_charges_folio
                              where operating_facility_id =:nd_facility_id
                              and bill_doc_type_code =:dc_doc_type_code
                              and to_char(bill_doc_num) =:d_doc_num
                              and trx_doc_ref = b.orig_doc_ref
                              and trx_doc_ref_line_num = b.orig_doc_ref_line_num
                              and trx_doc_ref_seq_num = b.orig_doc_ref_seq_num
                             )
                         )
        )
               ))
ORDER BY   3,1; */ 


//Added by Rudradip for Package Billing End

	if (OERROR)
	{ 
		disp_message(ERR_MESG,"SELECT FAILED ON BL_BILL_SERV_LINE_CUR ");
		proc_exit();
	}
	

	
	/* EXEC SQL OPEN BL_BILL_SERV_LINE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select B.PACKAGE_SERVICE_CODE ,NVL(b.serv_item_desc,c.long_desc) ,TO_CHA\
R(B.SERVICE_DATE,'DD/MM/YYYY') ,NVL(B.SERV_QTY,0) ,NVL(B.ORG_GROSS_CHARGE_AM\
T,0) ,NVL(B.ORG_NET_CHARGE_AMT,0) ,NVL(B.ORG_DISC_AMT,0) ,NVL(B.UPD_NET_CHAR\
GE_AMT,0) ,NVL(B.UPD_DISC_AMT,0) ,B.BASE_RATE ,B.BASE_QTY ,((TO_CHAR(B.BASE_\
RATE)||'/')||TO_CHAR(B.BASE_QTY)) ,BASE_CHARGE_AMT ,ADDL_CHARGE_AMT_IN_CHARG\
E ,TRX_DOC_REF ,TRX_DOC_REF_LINE_NUM ,CUST_CODE  from BL_PATIENT_CHARGES_FOL\
IO B ,BL_BLNG_SERV C where ((((((B.OPERATING_FACILITY_ID=:b0 and B.BILL_DOC_\
TYPE_CODE=:b1) and to_char(B.BILL_DOC_NUM)=:b2) and nvl(b.package_trx_yn,'N'\
)='N') and B.BLNG_SERV_CODE=C.BLNG_SERV_CODE(+)) and nvl(:b3,BLCOMMON.GET_SE\
RVICE_GROUP_HDR_CODE(B.BLNG_SERV_CODE))=BLCOMMON.GET_SERVICE_GROUP_HDR_CODE(\
B.BLNG_SERV_CODE)) and (trx_status is null  or ((trx_status='C' and (orig_do\
c_ref is null  and 0=(select count(1)  from bl_patient_charges_folio where (\
((((operating_facility_id=:b0 and bill_doc_type_code=:b1) and to_char(bill_d\
oc_num)=:b2) and orig_doc_ref=b.trx_doc_");
 sqlbuft((void **)0, 
   "ref) and orig_doc_ref_line_num=b.trx_doc_ref_line_num) and orig_doc_ref_\
seq_num=b.trx_doc_ref_seq_num)))) or (orig_doc_ref is  not null  and 0=(sele\
ct count(1)  from bl_patient_charges_folio where (((((operating_facility_id=\
:b0 and bill_doc_type_code=:b1) and to_char(bill_doc_num)=:b2) and trx_doc_r\
ef=b.orig_doc_ref) and trx_doc_ref_line_num=b.orig_doc_ref_line_num) and trx\
_doc_ref_seq_num=b.orig_doc_ref_seq_num)))))) union all select B.BLNG_SERV_C\
ODE ,c.long_desc ,TO_CHAR(B.SERVICE_DATE,'DD/MM/YYYY') ,NVL(B.SERV_QTY,0) ,N\
VL(B.ORG_GROSS_CHARGE_AMT,0) ,NVL(B.ORG_NET_CHARGE_AMT,0) ,NVL(B.ORG_DISC_AM\
T,0) ,NVL(B.UPD_NET_CHARGE_AMT,0) ,NVL(B.UPD_DISC_AMT,0) ,a.BASE_RATE ,a.BAS\
E_QTY ,((TO_CHAR(a.BASE_RATE)||'/')||TO_CHAR(a.BASE_QTY)) ,a.BASE_CHARGE_AMT\
 ,a.ADDL_CHARGE_AMT_IN_CHARGE ,b.TRX_DOC_REF ,b.TRX_DOC_REF_LINE_NUM ,b.CUST\
_CODE  from BL_PAckage_FOLIO B ,bl_patient_charges_folio a ,BL_BLNG_SERV C w\
here (((((((B.OPERATING_FACILITY_ID=:b0 and b.package_trx_yn='N') and B.BLNG\
_SERV_CODE=C.BLNG_SERV_CODE) and a.trx_d");
 sqlbuft((void **)0, 
   "oc_ref=b.trx_doc_ref) and a.trx_doc_ref_line_num=b.trx_doc_ref_line_num)\
 and a.trx_doc_ref_seq_num=b.trx_doc_ref_seq_num) and nvl(:b3,BLCOMMON.GET_S\
ERVICE_GROUP_HDR_CODE(B.BLNG_SERV_CODE))=BLCOMMON.GET_SERVICE_GROUP_HDR_CODE\
(B.BLNG_SERV_CODE)) and (b.TRX_DOC_REF,b.TRX_DOC_REF_LINE_NUM) in (select TR\
X_DOC_REF ,TRX_DOC_REF_LINE_NUM  from BL_PATIENT_CHARGES_FOLIO B ,BL_BLNG_SE\
RV C where ((((((B.OPERATING_FACILITY_ID=:b0 and B.BILL_DOC_TYPE_CODE=:b1) a\
nd to_char(B.BILL_DOC_NUM)=:b2) and nvl(b.package_trx_yn,'N')='P') and B.BLN\
G_SERV_CODE=C.BLNG_SERV_CODE(+)) and nvl(:b3,BLCOMMON.GET_SERVICE_GROUP_HDR_\
CODE(B.BLNG_SERV_CODE))=BLCOMMON.GET_SERVICE_GROUP_HDR_CODE(B.BLNG_SERV_CODE\
)) and (trx_status is null  or ((trx_status='C' and (orig_doc_ref is null  a\
nd 0=(select count(1)  from bl_patient_charges_folio where (((((operating_fa\
cility_id=:b0 and bill_doc_type_code=:b1) and to_char(bill_doc_num)=:b2) and\
 orig_doc_ref=b.trx_doc_ref) and orig_doc_ref_line_num=b.trx_doc_ref_line_nu\
m) and orig_doc_ref_seq_num=b.trx_doc_re");
 sqlstm.stmt = sq0021;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )637;
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
 sqlstm.sqhstv[1] = (         void  *)&dc_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_Serv_Group;
 sqlstm.sqhstl[3] = (unsigned int  )5;
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
 sqlstm.sqhstv[5] = (         void  *)&dc_doc_type_code;
 sqlstm.sqhstl[5] = (unsigned int  )9;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[7] = (unsigned int  )5;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&dc_doc_type_code;
 sqlstm.sqhstl[8] = (unsigned int  )9;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[9] = (unsigned int  )11;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[10] = (unsigned int  )5;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_Serv_Group;
 sqlstm.sqhstl[11] = (unsigned int  )5;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[12] = (unsigned int  )5;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&dc_doc_type_code;
 sqlstm.sqhstl[13] = (unsigned int  )9;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[14] = (unsigned int  )11;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_Serv_Group;
 sqlstm.sqhstl[15] = (unsigned int  )5;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[16] = (unsigned int  )5;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&dc_doc_type_code;
 sqlstm.sqhstl[17] = (unsigned int  )9;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[18] = (unsigned int  )11;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[19] = (unsigned int  )5;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&dc_doc_type_code;
 sqlstm.sqhstl[20] = (unsigned int  )9;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[21] = (unsigned int  )11;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
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
	{
		disp_message(ERR_MESG,"Open failed on Cursor declare_service_line_cur");
		proc_exit();
	}	
  
						
}



int fetch_service_line_cur()
{

  d_service_code.arr[0] = '\0';
  d_service_code.len = 0;
  
  nd_map_code.arr[0]= '\0';
  nd_map_ind.arr[0]='\0';
  nd_map_desc.arr[0]='\0';

  d_service_desc.arr[0] = '\0';
  d_service_desc.len = 0;

  d_service_date.arr[0] = '\0';
  d_service_date.len = 0;

  nd_base_rate_qty.arr[0] = '\0';
  nd_base_rate_qty.len = 0;
  
  nd_cust_code.arr[0] = '\0';
  nd_cust_code.len = 0;


   /* EXEC SQL FETCH BL_BILL_SERV_LINE_CUR 
	    INTO 
		  :d_service_code,
		  :d_service_desc,
		  :d_service_date,
		  :d_service_qty,
		  :d_service_amt,
		  :d_service_net,
		  :d_service_disc,
		  :d_upd_net_charge_amt,
		  :d_upd_disc_amt,
		  :d_base_rate,
		  :d_base_qty,
		  :nd_base_rate_qty,
		  :nd_base_charge,
		  :nd_addl_charge,
		  :nd_trx_doc_ref,
		  :nd_trx_doc_ref_line_num,
		  :nd_cust_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )740;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_service_code;
   sqlstm.sqhstl[0] = (unsigned int  )14;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_service_desc;
   sqlstm.sqhstl[1] = (unsigned int  )302;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_service_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_service_qty;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_service_amt;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_service_net;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_service_disc;
   sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_upd_net_charge_amt;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_upd_disc_amt;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_base_rate;
   sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_base_qty;
   sqlstm.sqhstl[10] = (unsigned int  )sizeof(long);
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_base_rate_qty;
   sqlstm.sqhstl[11] = (unsigned int  )52;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_base_charge;
   sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_addl_charge;
   sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_trx_doc_ref;
   sqlstm.sqhstl[14] = (unsigned int  )102;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_trx_doc_ref_line_num;
   sqlstm.sqhstl[15] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_cust_code;
   sqlstm.sqhstl[16] = (unsigned int  )12;
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
	{ 
		disp_message(ERR_MESG,"FETCH FAILED IN BL_BILL_SERV_LINE_CUR ");
		proc_exit();
	}

    if(NODATAFOUND)
	{
	
		return 0; 
	}

	d_service_code.arr[d_service_code.len] = '\0';
	d_service_code.arr[d_service_code.len] = '\0';
	d_service_desc.arr[d_service_desc.len] = '\0';
	d_service_date.arr[d_service_date.len] = '\0';   
	nd_base_rate_qty.arr[nd_base_rate_qty.len] = '\0';
	nd_cust_code.arr[nd_cust_code.len] = '\0';

    /* EXEC SQL SELECT MAPPING_CODE,MAPPING_CODE_IND
	         Into :nd_map_code,:nd_map_ind
			 From BL_ITEMS_FOR_MAPPING_CODE
			 Where ITEM_CODE = :d_service_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select MAPPING_CODE ,MAPPING_CODE_IND into :b0,:b1  from \
BL_ITEMS_FOR_MAPPING_CODE where ITEM_CODE=:b2";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )823;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_map_code;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_map_ind;
    sqlstm.sqhstl[1] = (unsigned int  )3;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_service_code;
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



    /* EXEC SQL SELECT LONG_DESC
	         INTO   :nd_map_desc
			 From   BL_SERV_MAPPING_CODE_lang_vw
			 where  OPERATING_FACILITY_ID = :nd_facility_id
			   and  MAPPING_CODE_IND = :nd_map_ind
			   and  MAPPING_CODE = :nd_map_code
			   and	LANGUAGE_ID	 = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LONG_DESC into :b0  from BL_SERV_MAPPING_CODE_lang\
_vw where (((OPERATING_FACILITY_ID=:b1 and MAPPING_CODE_IND=:b2) and MAPPING_C\
ODE=:b3) and LANGUAGE_ID=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )850;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_map_desc;
    sqlstm.sqhstl[0] = (unsigned int  )102;
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
    sqlstm.sqhstv[2] = (         void  *)&nd_map_ind;
    sqlstm.sqhstl[2] = (unsigned int  )3;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_map_code;
    sqlstm.sqhstl[3] = (unsigned int  )32;
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



	
	return 1;
}

close_service_line_cur()
{

	/* EXEC SQL CLOSE BL_BILL_SERV_LINE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )885;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRVSBL6.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRVSBL6.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )900;
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
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )923;
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


print_hdr()
{

nd_patient_id.arr[0]    = '\0';
nd_episode_type.arr[0]  = '\0';
nd_episode_type1.arr[0] = '\0';
nd_episode_id.arr[0]	= '\0';
//nd_visit_id.arr[0]		= '\0';
d_doc_date.arr[0]		= '\0';


nd_patient_id.len   = 0;
nd_episode_type.len = 0;
nd_episode_type1.len= 0;
nd_episode_id.len	= 0;
nd_blng_grp_id.len      = 0;
d_added_by_id.len  =0;
nd_blng_Grp_Desc.len =0;


//nd_visit_id.len		= 0;
d_doc_date.len		= 0;

			/* EXEC SQL SELECT patient_id,
							decode(UPPER(episode_type),'O','OutPatient','I','InPatient','D','Daycare','E','Emergency','R','External',NULL),
							episode_type,
							episode_id,
							visit_id,
							to_char(doc_date,'dd/mm/yyyy'),
							blng_grp_id,
							ACCT_SEQ_NO,
							ADDED_BY_ID
						  INTO  :nd_patient_id,
								:nd_episode_type,
								:nd_episode_type1,
								:nd_episode_id,
								:nd_visit_id,
								:d_doc_date,
								:nd_blng_grp_id,
								:nd_acct_seq_no,
								:d_added_by_id
						  FROM BL_BILL_HDR
						  WHERE doc_type_code=:dc_doc_type_code AND
	    					doc_num	= :d_doc_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select patient_id ,decode(UPPER(episode_type),'O','OutPati\
ent','I','InPatient','D','Daycare','E','Emergency','R','External',null ) ,epis\
ode_type ,episode_id ,visit_id ,to_char(doc_date,'dd/mm/yyyy') ,blng_grp_id ,A\
CCT_SEQ_NO ,ADDED_BY_ID into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  from BL_BILL\
_HDR where (doc_type_code=:b9 and doc_num=:b10)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )954;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )19;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_episode_type;
   sqlstm.sqhstl[1] = (unsigned int  )17;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_episode_type1;
   sqlstm.sqhstl[2] = (unsigned int  )4;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_episode_id;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_visit_id;
   sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_doc_date;
   sqlstm.sqhstl[5] = (unsigned int  )13;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_blng_grp_id;
   sqlstm.sqhstl[6] = (unsigned int  )6;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_acct_seq_no;
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_added_by_id;
   sqlstm.sqhstl[8] = (unsigned int  )102;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&dc_doc_type_code;
   sqlstm.sqhstl[9] = (unsigned int  )9;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_doc_num;
   sqlstm.sqhstl[10] = (unsigned int  )11;
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



           /* EXEC SQL SELECT SHORT_DESC 
		            INTO :nd_blng_Grp_Desc
				    FROM bl_blng_grp_lang_vw
					Where Blng_Grp_Id = :nd_blng_grp_id; */ 

{
           struct sqlexd sqlstm;
           sqlstm.sqlvsn = 12;
           sqlstm.arrsiz = 22;
           sqlstm.sqladtp = &sqladt;
           sqlstm.sqltdsp = &sqltds;
           sqlstm.stmt = "select SHORT_DESC into :b0  from bl_blng_grp_lang_\
vw where Blng_Grp_Id=:b1";
           sqlstm.iters = (unsigned int  )1;
           sqlstm.offset = (unsigned int  )1013;
           sqlstm.selerr = (unsigned short)1;
           sqlstm.cud = sqlcud0;
           sqlstm.sqlest = (unsigned char  *)&sqlca;
           sqlstm.sqlety = (unsigned short)4352;
           sqlstm.occurs = (unsigned int  )0;
           sqlstm.sqhstv[0] = (         void  *)&nd_blng_Grp_Desc;
           sqlstm.sqhstl[0] = (unsigned int  )502;
           sqlstm.sqhsts[0] = (         int  )0;
           sqlstm.sqindv[0] = (         void  *)0;
           sqlstm.sqinds[0] = (         int  )0;
           sqlstm.sqharm[0] = (unsigned int  )0;
           sqlstm.sqadto[0] = (unsigned short )0;
           sqlstm.sqtdso[0] = (unsigned short )0;
           sqlstm.sqhstv[1] = (         void  *)&nd_blng_grp_id;
           sqlstm.sqhstl[1] = (unsigned int  )6;
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



nd_patient_id.arr[nd_patient_id.len]		= '\0';
nd_episode_type.arr[nd_episode_type.len]	= '\0';
nd_episode_id.arr[nd_episode_id.len]		= '\0';
nd_episode_type1.arr[nd_episode_type1.len]	= '\0';
nd_blng_Grp_Desc.arr[nd_blng_Grp_Desc.len]  = '\0';
nd_blng_grp_id.arr[nd_blng_grp_id.len]      = '\0';
d_added_by_id.arr[d_added_by_id.len]        = '\0';
//nd_visit_id.arr[nd_visit_id.len]			= '\0';
d_doc_date.arr[d_doc_date.len]				= '\0';


get_bill_address();


/*	init_date_temp_var();

	strcpy(date_convert.arr,rep_date.arr);

	strcpy(nd_temp_date.arr,date_convert.arr);
	nd_temp_date.len = strlen(nd_temp_date.arr);
	get_local_date1();
	strcpy(date_convert.arr,nd_loc_date.arr); */
	
/* Commented by raghava on 18/3/2008 as per kuila sir instruction
    fprintf(f1,"MDL : %-80.80s     %s\n",comp_name.arr,rep_date.arr);

    fprintf(f1,"OPR : %s\n",oper_id.arr);
	fprintf(f1,"REP : %s\n","BLRVSBL6.lis");

fprintf(f1,"----------------------------------------------------------------------------------------------------\n");

fprintf(f1,"                                  %s\n",loc_legend[1]);
*/

if (l_lsr != 0 && l_dmp == 0)
fprintf(f1,"%c(s14H",ESC);

fprintf(f1,"\n");	
l_page_no++;
fprintf(f1,"                    %73.73s %d\n",loc_legend[17],l_page_no);
if (l_lsr != 0 && l_dmp == 0)
{
 fprintf(f1,"%c(s10H",ESC);
 fprintf(f1,"%c(s3B",ESC); 	/* To set Bold style 	  */
 fun_centre(loc_legend[2],80);
 fprintf(f1,"%s",loc_legend[2]);
}
if (l_lsr == 0 && l_dmp != 0)
{
 fprintf(f1,"%cE",ESC); 		          /* To Set Bold For Dotmatrix*/
 fun_centre(loc_legend[2],100);
 fprintf(f1,"%s",loc_legend[2]);
 
}



if (l_lsr != 0 && l_dmp == 0)
{
 fprintf(f1,"%c(s-3B",ESC);	/* To release bold style   */
 fprintf(f1,"%c(s14H",ESC);	
}
if (l_lsr == 0 && l_dmp != 0)
fprintf(f1,"%cF",ESC); 		          /* To Set Bold For Dotmatrix*/

fprintf(f1,"\n\n");

fprintf(f1,"%-72.72s ",nd_hosp_name.arr); /* Hospital Name */
fprintf(f1,"%s   :%s/%s\n", loc_legend[4],dc_doc_type_code.arr,d_doc_num.arr);

strcat(nd_hosp_add.arr,nd_add_ln1.arr);

if(strcmp(nd_add_ln2.arr,"\0")!=0)
{
strcat(nd_hosp_add.arr,",");
strcat(nd_hosp_add.arr,nd_add_ln2.arr);
}

if(strcmp(nd_add_ln3.arr,"\0")!=0)
{
strcat(nd_hosp_add.arr,",");
strcat(nd_hosp_add.arr,nd_add_ln3.arr);
}

if(strcmp(nd_add_ln4.arr,"\0")!=0)
{
strcat(nd_hosp_add.arr,",");
strcat(nd_hosp_add.arr,nd_add_ln4.arr);
}

if(strcmp(nd_area_desc.arr,"\0")!=0)
{
strcat(nd_hosp_add.arr,",");
strcat(nd_hosp_add.arr,nd_area_desc.arr);
}

if(strcmp(nd_town_desc.arr,"\0")!=0)
{
strcat(nd_hosp_add.arr,",");
strcat(nd_hosp_add.arr,nd_town_desc.arr);
}

//fprintf(f1," %-25.25s,%-20.20s,%-25.25s",nd_add_ln1.arr,nd_add_ln2.arr,nd_add_ln3.arr); /* Address */

fprintf(f1,"%-72.72s ",nd_hosp_add.arr); /* Address */

init_date_temp_var();
strcpy(date_convert.arr,d_doc_date.arr);
fun_change_loc_date1();
init_date_temp_var();
strcpy(date_convert.arr,nd_pgm_date.arr);
fun_change_loc_date1();

fprintf(f1,"%s :%s\n",loc_legend[6],date_convert.arr);

//fprintf(f1,"                         %s\n\n",nd_tel_fax.arr); /* Telephone and Fax Numbers */
if (l_lsr != 0 && l_dmp == 0)
fprintf(f1,"%c(s14H",ESC);	



/* fprintf(f1,"  %s\n",loc_legend[7]); Commented By Kalyan */
fprintf(f1,"--------------------------------------------------------------------------------------------------------\n");

if (l_lsr != 0 && l_dmp == 0)
fprintf(f1,"%c(s3B",ESC); 	/* To set Bold style 	  */
if (l_lsr == 0 && l_dmp != 0)
fprintf(f1,"%cE",ESC); 		          /* To Set Bold For Dotmatrix*/

fprintf(f1,"%-15.15s : ",loc_legend[8]);

if(strcmp(nd_patient_name1.arr,"\0")!=0)
 fprintf(f1,"%s ",nd_patient_name1.arr);

/* commented for SCF-7240
if(strcmp(nd_patient_name2.arr,"\0")!=0)
 fprintf(f1,"%s ",nd_patient_name2.arr);

 if(strcmp(nd_patient_name3.arr,"\0")!=0)
 fprintf(f1,"%s ",nd_patient_name3.arr);
*/

 if (l_lsr != 0 && l_dmp == 0)
 fprintf(f1,"%c(s-3B",ESC);	/* To release bold style   */
 if (l_lsr == 0 && l_dmp != 0)
 fprintf(f1,"%cF",ESC); 		          /* To Set Bold For Dotmatrix*/

/* fprintf(f1,"  %s  : %s\n",loc_legend[9],l_bill_contact_name.arr);
   fprintf(f1,"		%s\n",l_bill_add1_desc.arr);
   fprintf(f1,"		%s\n",l_bill_add2_desc.arr);
   fprintf(f1,"		%s\n\n",l_bill_add3_desc.arr);
*/

fprintf(f1,"\n%-15.15s : %s/%s/%d\n",loc_legend[11],nd_episode_type.arr,nd_episode_id.arr,nd_visit_id);
//fprintf(f1,"%s     : %-40.40s\n",loc_legend[16],nd_blng_Grp_Desc.arr); //comented by vani regarding IN13918



/****IN13918 *** SRR_CRF-517***STARTS HERE****/
fprintf(f1,"%-15.15s : ",loc_legend[16]);


declare_get_privilige();

while(fetch_get_privilige())
{
	
	
	nd_policy_desc.arr[0]		 = '\0';
	nd_policy_desc.len			 =0;
	
	
	if (strcmp(nd_policy_type_code.arr,"\0")!=0) 
	{
				

		/* EXEC SQL select long_desc
				 into :nd_policy_desc
				 from bl_ins_policy_types_lang_vw
				 where policy_type_code=:nd_policy_type_code
				 and operating_facility_id=:nd_facility_id
				 and language_id=:p_language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select long_desc into :b0  from bl_ins_policy_types_lang_vw\
 where ((policy_type_code=:b1 and operating_facility_id=:b2) and language_id=:\
b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1036;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_policy_desc;
  sqlstm.sqhstl[0] = (unsigned int  )103;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_policy_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )27;
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


		
		
		if(NODATAFOUND)
		{
		    
			nd_policy_desc.arr[nd_policy_desc.len]	= '\0';	
		}


		if(OERROR)
		{
			disp_message(ERR_MESG,"Select failed on bl_ins_policy_types_lang_vw");
		}

		nd_policy_desc.arr[nd_policy_desc.len]	= '\0';
	
	}
	else
	{
	
	strcpy(nd_policy_desc.arr,loc_legend[25]);
	nd_policy_desc.len = strlen(nd_policy_desc.arr);
	nd_policy_desc.arr[nd_policy_desc.len]	= '\0';

	}

 	if (nd_cnt_policy<=3)
	{		
		
		//if ( strcmp(nd_prev_policy_desc.arr,nd_policy_desc.arr) !=0 )
		//{
			
			/*if (nd_priority==1) //commented for IN16427
			fprintf(f1,"%d.%-80.80s",nd_priority,nd_policy_desc.arr);
			else
			fprintf(f1,"\n%-17.17s %d.%-80.80s"," ",nd_priority,nd_policy_desc.arr);*/
				
			sprintf(st_var,"%d",nd_priority);
			
			if (nd_priority!=1)
			strcat(nd_all_policy_desc.arr," ");
								
			strcat(nd_all_policy_desc.arr,st_var);
			strcat(nd_all_policy_desc.arr,".");
			strcat(nd_all_policy_desc.arr,nd_policy_desc.arr);
			strcpy(nd_prev_policy_desc.arr,nd_policy_desc.arr);	

			nd_priority++;
		//}

		
	}

	nd_cnt_policy++;

	
}
 
close_get_privilige();

nd_all_policy_desc.len=strlen(nd_all_policy_desc.arr);
nd_all_policy_desc.arr[nd_all_policy_desc.len] = '\0';

if (nd_priority==1)
fprintf(f1,"%d.%-30.30s",nd_priority,loc_legend[25]);
else
{
	/******added for IN16427**********/
	
 
	policy_len = strlen(nd_all_policy_desc.arr);
	line_cnt   = 1;
		
	sprintf(st_var,"%d",policy_len);
	
	while(policy_len>0)
	{
		
		nd_print_policy_desc.arr[0] = '\0';
		nd_print_policy_desc.len	= 0;
	
		/* EXEC SQL select substr(:nd_all_policy_desc,:line_cnt,90)into :nd_print_policy_desc
		         from dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select substr(:b0,:b1,90) into :b2  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1067;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_all_policy_desc;
  sqlstm.sqhstl[0] = (unsigned int  )2002;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&line_cnt;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_print_policy_desc;
  sqlstm.sqhstl[2] = (unsigned int  )102;
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


		
		nd_print_policy_desc.arr[nd_print_policy_desc.len] = '\0';
			

	
		if (line_cnt==1)
		fprintf(f1,"%-90.90s",nd_print_policy_desc.arr);
		else
		fprintf(f1,"\n%-17.17s %-90.90s"," ",nd_print_policy_desc.arr);

		policy_len = policy_len-90;
		line_cnt = line_cnt+90;
		
	}

	/******upto here**********/

}

/****END OF IN13918 *** SRR_CRF-517*******/


	


fprintf(f1,"\n");

fprintf(f1,"--------------------------------------------------------------------------------------------------------\n");

//fprintf(f1,"  %s  %s      %-40.40s    \t           %-8s     %s(%s)\n",loc_legend[15],loc_legend[19],loc_legend[12],loc_legend[13],loc_legend[18],currency.arr); //commented for IN13918

fprintf(f1,"  %-5.5s %-10.10s %-25.25s %3s %17.17s %17.17s  %16.16s \n",loc_legend[15],loc_legend[19],loc_legend[12],loc_legend[13],loc_legend[18],loc_legend[23],loc_legend[24]);

fprintf(f1,"--------------------------------------------------------------------------------------------------------\n");

}



			
fun_centre(v_text,v_size)
{
int l_length,i;

l_length=strlen(v_text);

for (i=0;i<(v_size-l_length)/2;i++)
{

	fprintf(f1," ");
}
 
}			
			

get_bill_address()
{
	l_bill_contact_name.arr[0] = '\0';
	l_bill_contact_name.len = 0;

	l_bill_contact_name_title.arr[0] = '\0';
	l_bill_contact_name_title.len = 0;

	l_bill_long_desc.arr[0] = '\0';
	l_bill_long_desc.len = 0;

	l_bill_add1_desc.arr[0] = '\0';
	l_bill_add1_desc.len = 0;

	l_bill_add2_desc.arr[0] = '\0';
	l_bill_add2_desc.len = 0;

	l_bill_add3_desc.arr[0] = '\0';
	l_bill_add3_desc.len = 0;
	
	
		/* EXEC SQL SELECT substr(mail_contact_name,1,19),
						substr(mail_postal_code,1,20),
						substr(ln1_mail_add,1,40),
						substr(ln2_mail_add,1,40),
						substr(ln3_mail_add,1,40),
						substr(mail_country_code,1,40)						
				   INTO :l_bill_contact_name,
						:l_bill_contact_name_title,
						:l_bill_long_desc,
						:l_bill_add1_desc,
						:l_bill_add2_desc,
						:l_bill_add3_desc
				   FROM mp_pat_other_dtls
				  WHERE patient_id = :nd_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select substr(mail_contact_name,1,19) ,substr(mail_postal_c\
ode,1,20) ,substr(ln1_mail_add,1,40) ,substr(ln2_mail_add,1,40) ,substr(ln3_ma\
il_add,1,40) ,substr(mail_country_code,1,40) into :b0,:b1,:b2,:b3,:b4,:b5  fro\
m mp_pat_other_dtls where patient_id=:b6";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1094;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_bill_contact_name;
  sqlstm.sqhstl[0] = (unsigned int  )62;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_bill_contact_name_title;
  sqlstm.sqhstl[1] = (unsigned int  )62;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_bill_long_desc;
  sqlstm.sqhstl[2] = (unsigned int  )62;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_bill_add1_desc;
  sqlstm.sqhstl[3] = (unsigned int  )62;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_bill_add2_desc;
  sqlstm.sqhstl[4] = (unsigned int  )62;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_bill_add3_desc;
  sqlstm.sqhstl[5] = (unsigned int  )62;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[6] = (unsigned int  )19;
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
					err_mesg("SELECT failed on table MP_PAT_OTHER_DTLS",0,"");
	

	l_bill_contact_name.arr[l_bill_contact_name.len] = '\0';
	l_bill_contact_name_title.arr[l_bill_contact_name_title.len] = '\0';
	l_bill_long_desc.arr[l_bill_long_desc.len] = '\0';
	l_bill_add1_desc.arr[l_bill_add1_desc.len] = '\0';
	l_bill_add2_desc.arr[l_bill_add2_desc.len] = '\0';
	l_bill_add3_desc.arr[l_bill_add3_desc.len] = '\0';

	if(l_bill_add3_desc.len > 0)
	{
		l_bill_add3_desc_temp.arr[0] = '\0';
		l_bill_add3_desc_temp.len = 0;		

		/* EXEC SQL SELECT long_name
				   INTO :l_bill_add3_desc_temp
				   FROM mp_country_lang_vw
				  WHERE country_code = :l_bill_add3_desc
				  and LANGUAGE_ID=:p_language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select long_name into :b0  from mp_country_lang_vw where (c\
ountry_code=:b1 and LANGUAGE_ID=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1137;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_bill_add3_desc_temp;
  sqlstm.sqhstl[0] = (unsigned int  )62;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_bill_add3_desc;
  sqlstm.sqhstl[1] = (unsigned int  )62;
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



		l_bill_add3_desc_temp.arr[l_bill_add3_desc_temp.len] = '\0';

		if((strcmp(l_bill_add3_desc_temp.arr,l_bill_add3_desc.arr)!=0) && (l_bill_add3_desc_temp.len > 0))
		{
			strcpy(l_bill_add3_desc.arr,l_bill_add3_desc_temp.arr);
			l_bill_add3_desc.len = strlen(l_bill_add3_desc.arr);
		}
	}



nd_patient_name1.arr[0]	= '\0'; 
nd_patient_name2.arr[0]	= '\0';
nd_patient_name3.arr[0]	= '\0';

nd_patient_name1.len	= 0;
nd_patient_name2.len	= 0;
nd_patient_name3.len	= 0;

/* commented for SCF-7240
EXEC SQL SELECT first_name,second_name,last_name	
				   INTO :nd_patient_name1,
						:nd_patient_name2,
						:nd_patient_name3
				   FROM mp_patient_mast
				  WHERE patient_id = :nd_patient_id;
*/
/* the below code added for SCF-7240 */
 /* EXEC SQL SELECT decode(:p_language_id,'en',short_name,short_name_loc_lang)	
				   INTO :nd_patient_name1
				   FROM mp_patient_mast
				  WHERE patient_id = :nd_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select decode(:b0,'en',short_name,short_name_loc_lang) into \
:b1  from mp_patient_mast where patient_id=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1164;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_language_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_patient_name1;
 sqlstm.sqhstl[1] = (unsigned int  )502;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )19;
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


/* upto here */

			   if (OERROR)
					err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");

nd_patient_name1.arr[nd_patient_name1.len]	= '\0'; 
nd_patient_name2.arr[nd_patient_name2.len]	= '\0'; 
nd_patient_name3.arr[nd_patient_name3.len]	= '\0'; 

}



print_formated_amt(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30], fstr_amt[30];

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        
        sprintf(str_amt,"%15s",s_amt);				
		ltrim (str_amt);		
		rtrim (str_amt);		
		fprintf(f1,"%15.15s CR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(f1,"%15.15s   ",str_amt);
     }

}                 


print_formated_amt1(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30], fstr_amt[30];

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        
        sprintf(str_amt,"%5s",s_amt);				
		ltrim (str_amt);		
		rtrim (str_amt);		
		fprintf(f1,"%6.6s CR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%5s",s_amt);
        fprintf(f1,"%6.6s   ",str_amt);
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

rtrim(l_str)
char *l_str;
{
  while (*l_str != '\0') *l_str++;
  l_str--;
  while (*l_str == ' ') *l_str--;
  *(l_str+1) = '\0';
}

get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;


	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY'),:p_language_id,t_date);

		:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY' ) , :p_language_id , t_date \
) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1191;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )32;
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
 sqlstm.sqhstl[2] = (unsigned int  )32;
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
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY HH12:MI:SS AM'),:p_language_id,t_date);

		:nd_loc_date := to_char(t_date,'DD/MM/YYYY HH12:MI:SS AM');

		

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH12:MI:SS AM' ) , :p_languag\
e_id , t_date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY HH12:MI:SS AM\
' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1218;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )32;
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
 sqlstm.sqhstl[2] = (unsigned int  )32;
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

fun_change_loc_date1()
{
strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);


get_local_date();
strcpy(date_convert.arr,nd_loc_date.arr); 
}

fun_change_loc_date()
{
strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);


get_local_date1();

strcpy(date_convert.arr,nd_loc_date.arr); 
}


declare_get_privilige()
{
	nd_prev_policy_desc.arr[0]	 = '\0';
	nd_prev_policy_desc.len		 =0;
	nd_all_policy_desc.arr[0]	 = '\0';
	nd_all_policy_desc.len		 =0;

	nd_priority =1;

	nd_cnt_policy =1;
    
	

	/* EXEC SQL DECLARE PRIVILIGE_CUR CURSOR FOR
         select policy_type_code
	           	from bl_encounter_payer_priority 
				where patient_id=:nd_patient_id
				and episode_type=:nd_episode_type1
				and nvl(episode_id,0)=nvl(:nd_episode_id,0)
				and nvl(visit_id,0)=nvl(:nd_visit_id,0)
				and nvl(acct_seq_no,0)=nvl(:nd_acct_seq_no,0)
			//	and priority is not null   //commented for IN17380 because non isurance Billing group privilige(cash) also has to print
				order by priority,policy_type_code; */ 


	if (OERROR)
	{ 
		disp_message(ERR_MESG,"SELECT FAILED ON PRIVILIGE_CUR ");
		proc_exit();
	}
	


	/* EXEC SQL OPEN PRIVILIGE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0035;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1245;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )19;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_episode_type1;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_episode_id;
 sqlstm.sqhstl[2] = (unsigned int  )12;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_visit_id;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_acct_seq_no;
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

 	
		
    if(OERROR)
	{
		disp_message(ERR_MESG,"Open failed on Cursor PRIVILIGE_CUR");
		proc_exit();
	}


}

fetch_get_privilige()
{
	nd_policy_type_code.arr[0]	 = '\0';
	nd_policy_type_code.len		 =0;

	
	/* EXEC SQL FETCH PRIVILIGE_CUR INTO
			 :nd_policy_type_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1280;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&nd_policy_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )27;
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


	strcpy(nd_policy_type_code.arr,nd_policy_type_code.arr);
			 
	if (OERROR)
	{ 
		disp_message(ERR_MESG,"FETCH FAILED IN PRIVILIGE_CUR ");
		proc_exit();
	}

	if(NODATAFOUND)
		{
			return 0; 
		
		}
    

nd_policy_type_code.arr[nd_policy_type_code.len] ='\0';	  //added for crf-517 testpatch

	
}	


close_get_privilige()
{
	/* EXEC SQL CLOSE PRIVILIGE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1299;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

get_payer_Payable()
{
	nd_cust_payble= 0;

	/* EXEC SQL select sum(UPD_NET_CHARGE_AMT) into :nd_cust_payble
	  from bl_patient_charges_folio
	  where trx_doc_ref=:nd_trx_doc_ref
			and trx_doc_ref_line_num=:nd_trx_doc_ref_line_num
			and operating_facility_id=:nd_facility_id
			and cust_code is not null; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select sum(UPD_NET_CHARGE_AMT) into :b0  from bl_patient_cha\
rges_folio where (((trx_doc_ref=:b1 and trx_doc_ref_line_num=:b2) and operatin\
g_facility_id=:b3) and cust_code is  not null )";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1314;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_cust_payble;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_trx_doc_ref;
 sqlstm.sqhstl[1] = (unsigned int  )102;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_trx_doc_ref_line_num;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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

get_patient_payable()
{
	nd_pat_payble	=0 ;

	/* EXEC SQL select sum(UPD_NET_CHARGE_AMT) into :nd_pat_payble
	  from bl_patient_charges_folio
	  where trx_doc_ref=:nd_trx_doc_ref
			and trx_doc_ref_line_num=:nd_trx_doc_ref_line_num
			and operating_facility_id=:nd_facility_id
			and cust_code is null; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select sum(UPD_NET_CHARGE_AMT) into :b0  from bl_patient_cha\
rges_folio where (((trx_doc_ref=:b1 and trx_doc_ref_line_num=:b2) and operatin\
g_facility_id=:b3) and cust_code is null )";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1345;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_pat_payble;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_trx_doc_ref;
 sqlstm.sqhstl[1] = (unsigned int  )102;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_trx_doc_ref_line_num;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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


//Added by Rudradip for Package Billing Start
get_closed_packages()
{

  	p_pkg_seq_num_str.arr[0] ='\0';
	p_pkg_seq_num_str.len	 =  0;
	p_pkg_amt_str.arr[0]	 ='\0';
	p_pkg_amt_str.len		 =  0;
	p_pkg_dep_str.arr[0]	 ='\0';
	p_pkg_dep_str.len		 =  0;
	p_dep_str.arr[0]		 ='\0';
	p_dep_str.len			 = 0;

	temp_pkg_seq_num_str.arr[0] ='\0';
	temp_pkg_seq_num_str.len	 =  0;
	temp_pkg_amt_str.arr[0]	 ='\0';
	temp_pkg_amt_str.len	 =  0;
	temp_pkg_dep_str.arr[0]	 ='\0';
	temp_pkg_dep_str.len	 =  0;

	temp_dep_str.arr[0]		='\0';
	temp_dep_str.len		= 0;

	nd_package_code.arr[0]   = '\0';
    nd_package_code.len      = 0;
    nd_package_desc.arr[0]   = '\0';
	nd_package_desc.len      = 0;


  /* EXEC SQL EXECUTE
		
		   BEGIN

			 BL_PROC_FOR_EXT_SERVICE_MP.CLOSED_PKG_BILL_LIST(
			:nd_facility_id,
			:nd_patient_id,
			:dc_doc_type_code,
			:d_doc_num,
		    :p_pkg_seq_num_str,
			:p_pkg_amt_str,
			:p_pkg_dep_str,
			:p_dep_str,
			:p_err_level,
			:p_sys_message_id,
			:p_error_text);

			

			if :p_sys_message_id is not null then
			:p_err_level := '10';
			:p_error_text := blcommon.get_error_text(:p_sys_message_id);
			end if;
			
			
			END;
			END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin BL_PROC_FOR_EXT_SERVICE_MP . CLOSED_PKG_BILL_LIST ( :\
nd_facility_id , :nd_patient_id , :dc_doc_type_code , :d_doc_num , :p_pkg_seq_\
num_str , :p_pkg_amt_str , :p_pkg_dep_str , :p_dep_str , :p_err_level , :p_sys\
_message_id , :p_error_text ) ; if :p_sys_message_id is not null then :p_err_l\
evel := '10' ; :p_error_text := blcommon . get_error_text ( :p_sys_message_id \
) ; end if ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1376;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )19;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&dc_doc_type_code;
  sqlstm.sqhstl[2] = (unsigned int  )9;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_doc_num;
  sqlstm.sqhstl[3] = (unsigned int  )11;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&p_pkg_seq_num_str;
  sqlstm.sqhstl[4] = (unsigned int  )202;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&p_pkg_amt_str;
  sqlstm.sqhstl[5] = (unsigned int  )202;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&p_pkg_dep_str;
  sqlstm.sqhstl[6] = (unsigned int  )202;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&p_dep_str;
  sqlstm.sqhstl[7] = (unsigned int  )202;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&p_err_level;
  sqlstm.sqhstl[8] = (unsigned int  )12;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&p_sys_message_id;
  sqlstm.sqhstl[9] = (unsigned int  )12;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&p_error_text;
  sqlstm.sqhstl[10] = (unsigned int  )202;
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


	
	
			if (strcmp(p_err_level.arr,"10") == 0 && p_error_text.arr[0] != '\0')
			{
			 proc_exit(0);
			}

			p_err_level.arr[0] = '\0';
			p_err_level.len = 0;

			p_sys_message_id.arr[0] = '\0';
			p_sys_message_id.len = 0;

			p_error_text.arr[0] = '\0';
			p_error_text.len = 0;

			p_pkg_seq_num_str.arr[p_pkg_seq_num_str.len]='\0';
			p_pkg_amt_str.arr[p_pkg_amt_str.len]='\0';
			p_pkg_dep_str.arr[p_pkg_dep_str.len]='\0';
			p_dep_str.arr[p_dep_str.len]	   ='\0';
	

			strcpy(temp_pkg_seq_num_str.arr,p_pkg_seq_num_str.arr);
			strcpy(temp_pkg_amt_str.arr,p_pkg_amt_str.arr);
			strcpy(temp_pkg_dep_str.arr,p_pkg_dep_str.arr);
			strcpy(temp_dep_str.arr,p_dep_str.arr);

			
			temp_pkg_seq_num_str.len = strlen(temp_pkg_seq_num_str.arr);
			temp_pkg_seq_num_str.arr[temp_pkg_seq_num_str.len] = '\0';

			temp_pkg_amt_str.len = strlen(temp_pkg_amt_str.arr);
			temp_pkg_amt_str.arr[temp_pkg_amt_str.len] = '\0';

			temp_pkg_dep_str.len = strlen(temp_pkg_dep_str.arr);
			temp_pkg_dep_str.arr[temp_pkg_dep_str.len] = '\0';

			temp_dep_str.len = strlen(temp_dep_str.arr);
			temp_dep_str.arr[temp_dep_str.len] = '\0';


			p_pkg_seq_num_str.arr[0]='\0';
			p_pkg_amt_str.arr[0]='\0';
			p_pkg_dep_str.arr[0]='\0';
			p_dep_str.arr[0]='\0';


			if (temp_pkg_seq_num_str.arr[0] != '\0')
			{
				
				  /* EXEC SQL SELECT length(:temp_pkg_seq_num_str)-length(replace(:temp_pkg_seq_num_str,',',null)) + 1
						   INTO :l_pkg_len
						   FROM DUAL; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 22;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select ((length(:b0)-length(replace(:b0,',',null )))+1)\
 into :b2  from DUAL ";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )1435;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&temp_pkg_seq_num_str;
      sqlstm.sqhstl[0] = (unsigned int  )202;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&temp_pkg_seq_num_str;
      sqlstm.sqhstl[1] = (unsigned int  )202;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&l_pkg_len;
      sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
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

   //PACKAGE LENGTH 
		
				  for(i=1;i<=l_pkg_len;i++)
				  {
					  
					  
					  
					  /* EXEC SQL SELECT SUBSTR(:temp_pkg_seq_num_str,1,INSTR(:temp_pkg_seq_num_str,',')-1),
									  SUBSTR(:temp_pkg_amt_str,1,INSTR(:temp_pkg_amt_str,',')-1),
									  SUBSTR(:temp_pkg_dep_str,1,INSTR(:temp_pkg_dep_str,',')-1),
									  SUBSTR(:temp_dep_str,1,INSTR(:temp_dep_str,',')-1)
							   INTO   :p_pkg_seq_num_str,
									  :p_pkg_amt_str,
									  :p_pkg_dep_str,
									  :p_dep_str
								FROM DUAL; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 22;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select SUBSTR(:b0,1,(INSTR(:b0,',')-1)) ,SUBSTR(:b2,1,\
(INSTR(:b2,',')-1)) ,SUBSTR(:b4,1,(INSTR(:b4,',')-1)) ,SUBSTR(:b6,1,(INSTR(:b6\
,',')-1)) into :b8,:b9,:b10,:b11  from DUAL ";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1462;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&temp_pkg_seq_num_str;
       sqlstm.sqhstl[0] = (unsigned int  )202;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&temp_pkg_seq_num_str;
       sqlstm.sqhstl[1] = (unsigned int  )202;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&temp_pkg_amt_str;
       sqlstm.sqhstl[2] = (unsigned int  )202;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&temp_pkg_amt_str;
       sqlstm.sqhstl[3] = (unsigned int  )202;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&temp_pkg_dep_str;
       sqlstm.sqhstl[4] = (unsigned int  )202;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&temp_pkg_dep_str;
       sqlstm.sqhstl[5] = (unsigned int  )202;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&temp_dep_str;
       sqlstm.sqhstl[6] = (unsigned int  )202;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&temp_dep_str;
       sqlstm.sqhstl[7] = (unsigned int  )202;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&p_pkg_seq_num_str;
       sqlstm.sqhstl[8] = (unsigned int  )202;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&p_pkg_amt_str;
       sqlstm.sqhstl[9] = (unsigned int  )202;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&p_pkg_dep_str;
       sqlstm.sqhstl[10] = (unsigned int  )202;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&p_dep_str;
       sqlstm.sqhstl[11] = (unsigned int  )202;
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



					 

					  /* EXEC SQL SELECT  rtrim(SUBSTR(:temp_pkg_seq_num_str,INSTR(:temp_pkg_seq_num_str,',')+1)),
									   rtrim(SUBSTR(:temp_pkg_amt_str,INSTR(:temp_pkg_amt_str,',')+1)),
									   rtrim(SUBSTR(:temp_pkg_dep_str,INSTR(:temp_pkg_dep_str,',')+1)),
									   rtrim(SUBSTR(:temp_dep_str,INSTR(:temp_dep_str,',')+1))
							   INTO   :temp_pkg_seq_num_str,
									  :temp_pkg_amt_str,
									  :temp_pkg_dep_str,
									  :temp_dep_str
								FROM DUAL; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 22;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select rtrim(SUBSTR(:b0,(INSTR(:b0,',')+1))) ,rtrim(SU\
BSTR(:b2,(INSTR(:b2,',')+1))) ,rtrim(SUBSTR(:b4,(INSTR(:b4,',')+1))) ,rtrim(SU\
BSTR(:b6,(INSTR(:b6,',')+1))) into :b0,:b2,:b4,:b6  from DUAL ";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1525;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&temp_pkg_seq_num_str;
       sqlstm.sqhstl[0] = (unsigned int  )202;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&temp_pkg_seq_num_str;
       sqlstm.sqhstl[1] = (unsigned int  )202;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&temp_pkg_amt_str;
       sqlstm.sqhstl[2] = (unsigned int  )202;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&temp_pkg_amt_str;
       sqlstm.sqhstl[3] = (unsigned int  )202;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&temp_pkg_dep_str;
       sqlstm.sqhstl[4] = (unsigned int  )202;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&temp_pkg_dep_str;
       sqlstm.sqhstl[5] = (unsigned int  )202;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&temp_dep_str;
       sqlstm.sqhstl[6] = (unsigned int  )202;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&temp_dep_str;
       sqlstm.sqhstl[7] = (unsigned int  )202;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&temp_pkg_seq_num_str;
       sqlstm.sqhstl[8] = (unsigned int  )202;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&temp_pkg_amt_str;
       sqlstm.sqhstl[9] = (unsigned int  )202;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&temp_pkg_dep_str;
       sqlstm.sqhstl[10] = (unsigned int  )202;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&temp_dep_str;
       sqlstm.sqhstl[11] = (unsigned int  )202;
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



						
						p_pkg_seq_num_str.arr[p_pkg_seq_num_str.len]='\0';
						p_pkg_amt_str.arr[p_pkg_amt_str.len]='\0';
						p_pkg_dep_str.arr[p_pkg_dep_str.len]='\0';
						p_dep_str.arr[p_dep_str.len]='\0';
						
						strcpy(p_pkg_seq_num[i],p_pkg_seq_num_str.arr);
						strcpy(p_pkg_amt[i],p_pkg_amt_str.arr);
						strcpy(p_pkg_dep_amt[i],p_pkg_dep_str.arr);
						strcpy(p_dep_amt[i],p_dep_str.arr);
					
						temp_pkg_seq_num_str.arr[temp_pkg_seq_num_str.len]='\0';
						temp_pkg_amt_str.arr[temp_pkg_amt_str.len]='\0';
						temp_pkg_dep_str.arr[temp_pkg_dep_str.len]='\0';
						temp_dep_str.arr[temp_dep_str.len]='\0';
											
						
				   }
					
						
						strcpy(p_pkg_seq_num[l_pkg_len],temp_pkg_seq_num_str.arr);
						strcpy(p_pkg_amt[l_pkg_len],temp_pkg_amt_str.arr);
						strcpy(p_pkg_dep_amt[l_pkg_len],temp_pkg_dep_str.arr);
						strcpy(p_dep_amt[l_pkg_len],temp_dep_str.arr);

		        }


}

get_pkg_name() 
{

  nd_package_code.arr[0]='\0';
  nd_package_code.len	  =0; 



	/* EXEC SQL SELECT DISTINCT package_code INTO :nd_package_code
	FROM BL_PACKAGE_SUB_HDR
	WHERE operating_facility_id = :nd_facility_id
	AND patient_id = :nd_patient_id
	AND package_seq_no = :l_pkg_seq_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 22;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select distinct package_code into :b0  from BL_PACKAGE_SUB_H\
DR where ((operating_facility_id=:b1 and patient_id=:b2) and package_seq_no=:b\
3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1588;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_package_code;
 sqlstm.sqhstl[0] = (unsigned int  )12;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )19;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_pkg_seq_num;
 sqlstm.sqhstl[3] = (unsigned int  )52;
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
	  { 
		disp_message (ERR_MESG,"FETCH FAILED FROM BL_PACKAGE_SUB_HDR TABLE");
	  }
 
    nd_package_code.arr[nd_package_code.len]='\0';

	if(nd_package_code.arr[0]!='\0')
	{
    
	  get_package_desc();

	} 

}

get_package_desc() 
{
  nd_package_desc.arr[0]='\0';
  nd_package_desc.len	  =0; 



  /* EXEC SQL SELECT long_desc
  INTO :nd_package_desc
  FROM BL_PACKAGE_LANG_VW
 WHERE operating_facility_id = :nd_facility_id
   AND language_id = :p_language_id
   AND package_code = :nd_package_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 22;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select long_desc into :b0  from BL_PACKAGE_LANG_VW where ((\
operating_facility_id=:b1 and language_id=:b2) and package_code=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1619;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_package_desc;
  sqlstm.sqhstl[0] = (unsigned int  )102;
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
  sqlstm.sqhstv[2] = (         void  *)&p_language_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_package_code;
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
	  { 
		disp_message (ERR_MESG,"FETCH FAILED FROM BL_PACKAGE_LANG_VW TABLE");
	  }
 
  nd_package_desc.arr[nd_package_desc.len]='\0';
}
//Added by Rudradip for Package Billing End