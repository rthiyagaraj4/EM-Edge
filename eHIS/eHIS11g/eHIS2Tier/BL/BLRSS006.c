
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLRSS006.PC"
};


static unsigned int sqlctx = 1288467595;


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
            void  *sqhstv[19];
   unsigned int   sqhstl[19];
            int   sqhsts[19];
            void  *sqindv[19];
            int   sqinds[19];
   unsigned int   sqharm[19];
   unsigned int   *sqharc[19];
   unsigned short  sqadto[19];
   unsigned short  sqtdso[19];
} sqlstm = {12,19};

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

 static const char *sq0002 = 
"select DOC_TYPE_CODE ,DOC_NUM  from BL_SS_PAYMENT_REF_RCPT_HDR where ((DOC_T\
YPE_CODE||'/')||DOC_NUM) in (select ((SLMT_DOC_TYPE_CODE||'/')||SLMT_DOC_NUM) \
 from BL_SS_PAYMENT_REF_INV_DTL where PMNT_REF_NUM=:b0)           ";

 static const char *sq0012 = 
"select A.PMNT_REF_NUM ,A.DOC_TYPE_CODE ,A.DOC_NUM ,to_char(A.DOC_DATE,'DD/MM\
/YYYY HH24:MI') ,nvl(A.DOC_AMT,0) ,B.PAYER_NAME ,A.ADDED_BY_ID ,A.PRINT_FLAG ,\
B.RECEIPT_BY_INV_YN ,A.CASH_COUNTER_CODE  from BL_SS_PAYMENT_REF_RCPT_HDR A ,B\
L_SS_PAYMENT_REF_HDR B where ((((A.COMP_CODE=B.COMP_CODE and A.PMNT_REF_NUM=B.\
PMNT_REF_NUM) and ((:b0='R' and exists (select 'x'  from BL_SS_INV_INT_TEMP_BI\
LL C where (((A.DOC_TYPE_CODE=C.DOC_TYPE_CODE and A.DOC_NUM=C.DOC_NUM) and C.P\
ROCESS_SESSION_ID=:b1) and C.PROCESS_PGM_ID in ('BLTSS009','BLRSS006')))) or (\
:b0='P' and A.PMNT_REF_NUM=:b3))) and NVL(A.CANCEL_IND,'N')='N') and NVL(B.REC\
EIPT_GEN_YN,'N')='Y')           ";

 static const char *sq0013 = 
"select A.DOC_AMT ,A.SLMT_TYPE_CODE ,B.SHORT_DESC ,B.CASH_SLMT_FLAG ,A.SLMT_D\
OC_REF_DESC ,A.BANK_CODE ,trim(A.PAYER_NAME) ,A.RCPT_RFND_ID_NO ,A.SLMT_DOC_RE\
F_DATE ,C.CASHIER_CHEQUE_YN  from BL_SS_PAYMENT_REF_RCPT_DTL A ,BL_SLMT_TYPE_L\
ANG_VW B ,BL_SLMT_TYPE C where ((((A.DOC_TYPE_CODE=:b0 and A.DOC_NUM=:b1) and \
A.SLMT_TYPE_CODE=B.SLMT_TYPE_CODE) and B.SLMT_TYPE_CODE=C.SLMT_TYPE_CODE) and \
LANGUAGE_ID=:b2)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,305,0,6,472,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,
0,0,
44,0,0,2,220,0,9,536,0,0,1,1,0,1,0,1,9,0,0,
63,0,0,2,0,0,13,556,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
86,0,0,3,95,0,5,584,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
109,0,0,4,0,0,29,589,0,0,0,0,0,1,0,
124,0,0,2,0,0,15,598,0,0,0,0,0,1,0,
139,0,0,5,225,0,6,617,0,0,9,9,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,
9,0,0,1,3,0,0,2,9,0,0,2,9,0,0,
190,0,0,6,88,0,4,633,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
213,0,0,7,94,0,4,746,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
240,0,0,8,347,0,4,831,0,0,9,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
291,0,0,9,341,0,6,864,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,2,
9,0,0,3,9,0,0,2,9,0,0,
338,0,0,10,108,0,4,1193,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
365,0,0,11,559,0,6,1220,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
392,0,0,12,654,0,9,1303,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
423,0,0,12,0,0,13,1338,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
478,0,0,12,0,0,15,1380,0,0,0,0,0,1,0,
493,0,0,13,415,0,9,1426,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
520,0,0,13,0,0,13,1460,0,0,10,0,0,1,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
575,0,0,13,0,0,15,1503,0,0,0,0,0,1,0,
590,0,0,14,123,0,4,1516,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
617,0,0,15,365,0,6,1546,0,0,5,5,0,1,0,1,9,0,0,3,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,
652,0,0,16,292,0,6,1588,0,0,5,5,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,
687,0,0,17,184,0,6,1627,0,0,3,3,0,1,0,1,9,0,0,3,9,0,0,3,9,0,0,
714,0,0,18,125,0,4,1655,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
741,0,0,19,120,0,4,1677,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
772,0,0,20,212,0,6,1859,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
799,0,0,21,196,0,6,1883,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
826,0,0,22,232,0,4,1955,0,0,9,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
877,0,0,23,126,0,4,2033,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
908,0,0,24,126,0,4,2071,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
939,0,0,25,397,0,4,2225,0,0,12,3,0,1,0,1,3,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1002,0,0,26,248,0,4,2249,0,0,9,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1053,0,0,27,896,0,4,2284,0,0,19,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1144,0,0,28,1354,0,6,2428,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,3,3,0,0,3,3,0,0,1,9,
0,0,2,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1203,0,0,0,0,0,27,2516,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
1234,0,0,30,60,0,4,2596,0,0,1,0,0,1,0,2,9,0,0,
1253,0,0,31,96,0,4,2615,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
1276,0,0,32,162,0,6,2622,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};



/************************************************************************/
/* PROGRAM NAME          : BLRSS006.PC                                  */
/* AUTHOR                : RAGHAVA S                                    */
/* DATE WRITTEN          : 13/03/2009                                   */
/*																		*/
/* FUNCTION				 : TO PRINT SS INVOICE RECEIPT					*/
/************************************************************************/
    
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <bl.h>

#define INIT_MESG		"Printing Receipt in progress...."
#define NODATAFOUND		sqlca.sqlcode == 1403
#define OERROR			(sqlca.sqlcode < 0)
#define LAST_ROW		(sqlca.sqlcode == 1403)
#define NOT_FOUND		(sqlca.sqlerrd[2] == 0)
#define NODATAFOUND		sqlca.sqlcode == 1403
#define RESOURCE_BUSY	(sqlca.sqlcode == -54)
#define ESC			0x1B
#define ONLINE_PRINTING 1
#define ERR_MESG  4

#define LENGTH_WORDS 80

//#define MAX_LINES 40
//#define DEBUG 1


/* EXEC SQL BEGIN DECLARE SECTION; */ 



/* VARCHAR	uid_pwd					[132],
		date_time				[20],
		user_id					[20],
		nd_pgm_date				[35],
		nd_facility_name		[31],
		nd_hcard_status			[12],	
		l_errortext				[1000],
		l_logo_yniflaser		[1000],
		LOGO_DIR				[1000],
		l_logo_name				[1000],
		l_errorlevel			[10],
		l_sysmessageid			[10],
		nd_hosp_name			[1000],
		nd_hosp_name1			[1000],
		nd_tel					[500],
		nd_use_in_hosp			[500],
		nd_hosp_add				[1000],
		nd_hosp_add1			[1000],
		nd_fax					[500],
		curr_date				[20]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[12]; } nd_hcard_status;

struct { unsigned short len; unsigned char arr[1000]; } l_errortext;

struct { unsigned short len; unsigned char arr[1000]; } l_logo_yniflaser;

struct { unsigned short len; unsigned char arr[1000]; } LOGO_DIR;

struct { unsigned short len; unsigned char arr[1000]; } l_logo_name;

struct { unsigned short len; unsigned char arr[10]; } l_errorlevel;

struct { unsigned short len; unsigned char arr[10]; } l_sysmessageid;

struct { unsigned short len; unsigned char arr[1000]; } nd_hosp_name;

struct { unsigned short len; unsigned char arr[1000]; } nd_hosp_name1;

struct { unsigned short len; unsigned char arr[500]; } nd_tel;

struct { unsigned short len; unsigned char arr[500]; } nd_use_in_hosp;

struct { unsigned short len; unsigned char arr[1000]; } nd_hosp_add;

struct { unsigned short len; unsigned char arr[1000]; } nd_hosp_add1;

struct { unsigned short len; unsigned char arr[500]; } nd_fax;

struct { unsigned short len; unsigned char arr[20]; } curr_date;



/* VARCHAR	d_settlement_type_code	[7],
        d_settlement_desc		[46],
		d_cash_slmt_flag		[2],
		d_slmnt_doc_ref			[61],
		d_bank_code				[25],
		d_rcpt_rfnd_id_no		[31],
		d_slmt_doc_ref_date		[20],
		d_bank_name				[60],
		d_receipt_nature_code	[9],
		d_receipt_type_code		[10],
		d_cash_counter_code		[5],
		nd_counter_name			[500],
		d_doc_type_code1    	[10],		
		d_doc_number1		    [50],
		d_print_yn				[5],
		d_cashier_cheque            [2]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_settlement_type_code;

struct { unsigned short len; unsigned char arr[46]; } d_settlement_desc;

struct { unsigned short len; unsigned char arr[2]; } d_cash_slmt_flag;

struct { unsigned short len; unsigned char arr[61]; } d_slmnt_doc_ref;

struct { unsigned short len; unsigned char arr[25]; } d_bank_code;

struct { unsigned short len; unsigned char arr[31]; } d_rcpt_rfnd_id_no;

struct { unsigned short len; unsigned char arr[20]; } d_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[60]; } d_bank_name;

struct { unsigned short len; unsigned char arr[9]; } d_receipt_nature_code;

struct { unsigned short len; unsigned char arr[10]; } d_receipt_type_code;

struct { unsigned short len; unsigned char arr[5]; } d_cash_counter_code;

struct { unsigned short len; unsigned char arr[500]; } nd_counter_name;

struct { unsigned short len; unsigned char arr[10]; } d_doc_type_code1;

struct { unsigned short len; unsigned char arr[50]; } d_doc_number1;

struct { unsigned short len; unsigned char arr[5]; } d_print_yn;

struct { unsigned short len; unsigned char arr[2]; } d_cashier_cheque;


/* VARCHAR	nd_session_id			[16],
		nd_facility_id			[3] ,
		nd_fm_doc_type			[7],
		nd_to_doc_type			[7],
		nd_nationality			[5],
		nd_fm_doc_num			[10],
		nd_to_doc_num			[10],
		nd_fm_doc_date			[12],
		nd_detail_type_yn		[3],
		nd_option				[3],
		cur_str					[8],
		sub_cur_str				[8],	   
		nd_ws_no				[50]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[5]; } nd_nationality;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[10]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[3]; } nd_detail_type_yn;

struct { unsigned short len; unsigned char arr[3]; } nd_option;

struct { unsigned short len; unsigned char arr[8]; } cur_str;

struct { unsigned short len; unsigned char arr[8]; } sub_cur_str;

struct { unsigned short len; unsigned char arr[50]; } nd_ws_no;


//char	amt_in_words	[10][133];

int		v_lno = 0,i;

long	MAX_LINES=40;

int     len_desc=0,r_ctrdesc=0,l_ctr=1;
char     cl_string_desc[500];
/* VARCHAR	d_episode_type          [2],
		d_patient_name          [61],
		d_date_of_birth			[31],
		d_org_dept				[100],
		d_patient_name_loc_lang [61],
		d_acc_int_code			[7],
		d_ac_code				[51],
		d_nric_no				[21],
		d_receipt_type			[10],
		d_receipt_desc			[16],
		nd_logo_pgm_id			[1000],
		l_online_print_yn		[5],
		l_fr_date				[30],
		l_to_date				[30],
		l_curr_date				[30],
		d_customer_name			[101]; */ 
struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[31]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[100]; } d_org_dept;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[7]; } d_acc_int_code;

struct { unsigned short len; unsigned char arr[51]; } d_ac_code;

struct { unsigned short len; unsigned char arr[21]; } d_nric_no;

struct { unsigned short len; unsigned char arr[10]; } d_receipt_type;

struct { unsigned short len; unsigned char arr[16]; } d_receipt_desc;

struct { unsigned short len; unsigned char arr[1000]; } nd_logo_pgm_id;

struct { unsigned short len; unsigned char arr[5]; } l_online_print_yn;

struct { unsigned short len; unsigned char arr[30]; } l_fr_date;

struct { unsigned short len; unsigned char arr[30]; } l_to_date;

struct { unsigned short len; unsigned char arr[30]; } l_curr_date;

struct { unsigned short len; unsigned char arr[101]; } d_customer_name;


/* VARCHAR	l_printer_ids		[1000],
	    l_printer_names		[1000],
	    l_printer_types		[1000],
	    l_queue_names		[1000],
	    l_no_of_copies		[1000],
		l_file_name			[50]; */ 
struct { unsigned short len; unsigned char arr[1000]; } l_printer_ids;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_names;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_types;

struct { unsigned short len; unsigned char arr[1000]; } l_queue_names;

struct { unsigned short len; unsigned char arr[1000]; } l_no_of_copies;

struct { unsigned short len; unsigned char arr[50]; } l_file_name;



/* VARCHAR	p_err_level			[10],
		p_sys_message_id	[10],
		p_error_text		[200]; */ 
struct { unsigned short len; unsigned char arr[10]; } p_err_level;

struct { unsigned short len; unsigned char arr[10]; } p_sys_message_id;

struct { unsigned short len; unsigned char arr[200]; } p_error_text;



/* VARCHAR nd_cashier_name		[500],
        nd_cahier_position	[500],
		nd_pmnt_ref_num		[100],
        nd_comp_code        [11],
		nd_acc_entity_code	[5],
		nd_temp_date		[20],
		nd_temp_date1		[20],
		nd_loc_date1		[20],
		nd_loc_date			[20],
		date_convert		[20],
		nd_preprint_flag	[3]; */ 
struct { unsigned short len; unsigned char arr[500]; } nd_cashier_name;

struct { unsigned short len; unsigned char arr[500]; } nd_cahier_position;

struct { unsigned short len; unsigned char arr[100]; } nd_pmnt_ref_num;

struct { unsigned short len; unsigned char arr[11]; } nd_comp_code;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[20]; } date_convert;

struct { unsigned short len; unsigned char arr[3]; } nd_preprint_flag;


/* VARCHAR d_pmnt_ref_num		[51],
		d_doc_type_code		[6],
		d_doc_num			[50],
		d_doc_date			[20],
		d_payer_name		[500],
		d_added_by_id		[31],
		d_print_flag		[2],
		d_receipt_by_inv_yn [2],
		nd_calling_pgm_id	[20],
		nd_rcpt_by_inv_yn	[2],
		nd_rprint_yn	    [2],
		nd_print_legend_yn	[2],
		nd_doc_type			[7],
		nd_doc_num			[9],
		nd_reportid			[20]; */ 
struct { unsigned short len; unsigned char arr[51]; } d_pmnt_ref_num;

struct { unsigned short len; unsigned char arr[6]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[50]; } d_doc_num;

struct { unsigned short len; unsigned char arr[20]; } d_doc_date;

struct { unsigned short len; unsigned char arr[500]; } d_payer_name;

struct { unsigned short len; unsigned char arr[31]; } d_added_by_id;

struct { unsigned short len; unsigned char arr[2]; } d_print_flag;

struct { unsigned short len; unsigned char arr[2]; } d_receipt_by_inv_yn;

struct { unsigned short len; unsigned char arr[20]; } nd_calling_pgm_id;

struct { unsigned short len; unsigned char arr[2]; } nd_rcpt_by_inv_yn;

struct { unsigned short len; unsigned char arr[2]; } nd_rprint_yn;

struct { unsigned short len; unsigned char arr[2]; } nd_print_legend_yn;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type;

struct { unsigned short len; unsigned char arr[9]; } nd_doc_num;

struct { unsigned short len; unsigned char arr[20]; } nd_reportid;


/* VARCHAR d_inv_doc_type_code		[10],
		d_inv_doc_number		[20],
		d_drg_inv_yn			[2],
		d_inv_cust_grp			[5],
		d_inv_cust_code			[15],
		d_inv_policy_type_code	[50],
		d_inv_patient			[21],
		d_print_text_for_rcpt	[150]; */ 
struct { unsigned short len; unsigned char arr[10]; } d_inv_doc_type_code;

struct { unsigned short len; unsigned char arr[20]; } d_inv_doc_number;

struct { unsigned short len; unsigned char arr[2]; } d_drg_inv_yn;

struct { unsigned short len; unsigned char arr[5]; } d_inv_cust_grp;

struct { unsigned short len; unsigned char arr[15]; } d_inv_cust_code;

struct { unsigned short len; unsigned char arr[50]; } d_inv_policy_type_code;

struct { unsigned short len; unsigned char arr[21]; } d_inv_patient;

struct { unsigned short len; unsigned char arr[150]; } d_print_text_for_rcpt;

        
/* VARCHAR nd_addr_line1[500],
		nd_addr_line2[500],
		nd_addr_line3[500],
		nd_addr_line4[500],
		nd_area_desc[500],
		nd_town_desc[500],
		nd_postal_desc[500],
		nd_region_desc[500],
		nd_country_desc[500],
		d_addr_line1_prompt     [500],
		d_addr_line2_prompt		[500],
		d_addr_line3_prompt		[500],
		d_addr_line4_prompt		[500],
		d_res_area_prompt		[500],
		d_res_town_prompt		[500],
		d_postal_code_prompt	[500],
		d_region_prompt			[500]; */ 
struct { unsigned short len; unsigned char arr[500]; } nd_addr_line1;

struct { unsigned short len; unsigned char arr[500]; } nd_addr_line2;

struct { unsigned short len; unsigned char arr[500]; } nd_addr_line3;

struct { unsigned short len; unsigned char arr[500]; } nd_addr_line4;

struct { unsigned short len; unsigned char arr[500]; } nd_area_desc;

struct { unsigned short len; unsigned char arr[500]; } nd_town_desc;

struct { unsigned short len; unsigned char arr[500]; } nd_postal_desc;

struct { unsigned short len; unsigned char arr[500]; } nd_region_desc;

struct { unsigned short len; unsigned char arr[500]; } nd_country_desc;

struct { unsigned short len; unsigned char arr[500]; } d_addr_line1_prompt;

struct { unsigned short len; unsigned char arr[500]; } d_addr_line2_prompt;

struct { unsigned short len; unsigned char arr[500]; } d_addr_line3_prompt;

struct { unsigned short len; unsigned char arr[500]; } d_addr_line4_prompt;

struct { unsigned short len; unsigned char arr[500]; } d_res_area_prompt;

struct { unsigned short len; unsigned char arr[500]; } d_res_town_prompt;

struct { unsigned short len; unsigned char arr[500]; } d_postal_code_prompt;

struct { unsigned short len; unsigned char arr[500]; } d_region_prompt;


/* VARCHAR	l_translated_value	[201],
		l_pk_value			[100]; */ 
struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;


/* VARCHAR	 nd_file_name [50],
		 nd_lang_id	  [4]; */ 
struct { unsigned short len; unsigned char arr[50]; } nd_file_name;

struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;


/* VARCHAR	amt_in_words	  [2000],
		amt_in_words_Sep  [2000],
		amt_in_words_Sep1 [2000]; */ 
struct { unsigned short len; unsigned char arr[2000]; } amt_in_words;

struct { unsigned short len; unsigned char arr[2000]; } amt_in_words_Sep;

struct { unsigned short len; unsigned char arr[2000]; } amt_in_words_Sep1;


double  d_doc_amt=0,
		d_pay_amt=0;
   	
char    loc_legend[1500][201];


char	l_sql_stmt[3000];
char    l_temp_line1[300];
char    l_temp_line2[300];
char	l_mesg[1000];
char	msg_str_var[1000];

int		no_of_lines,no_of_char=0,
	    page_no			= 1,
	    nd_no_of_decimal, 
		line_no			= 0,
		l_no_of_page	= 0,
		l_dmp			= 0, 
		l_lsr			= 0,
		l_margin_len	= 30;

int		string_var[10];
int     l_num_rec=1;
int		hl	 = 196,
		//vl	 = 179,
		vl	 = 179,
		tlc	 = 218,
		trc	 = 191,
		blc	 = 192,
		brc	 = 217,
		vlti	 = 195,
		vrti	 = 180,
		htti	 = 194,
		hbti	 = 193,
		plus	 = 197;

char    ar_amt[30][30],amt[30],temp[200]; 

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

FILE *fp;
int lctr = 0,pctr =0;

char filename[150];
char l_epi_barcode[50],
     l_rec_barcode[50];

void proc_main(argc,argv)
char *argv[];
int argc;
{
    char lv_msg[1024];

 
   if (argc < 6) 
   {
		disp_message(ERR_MESG,"BLRSS006 : Usage Error - Check Command Line Parameter\n");
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

	strcpy(nd_reportid.arr,argv[5]);		
	nd_reportid.len = strlen(nd_reportid.arr);	
	nd_reportid.arr[nd_reportid.len] = '\0';

	if (argc > 6) 
	{
	 strcpy(nd_pmnt_ref_num.arr,argv[6]);
	 nd_pmnt_ref_num.len = strlen(nd_pmnt_ref_num.arr);
	 nd_pmnt_ref_num.arr[nd_pmnt_ref_num.len] ='\0';
   
	}
	else
	{
			  
	  strcpy(l_file_name.arr,"BLRSS006.lis");
	  l_file_name.len = strlen(l_file_name.arr);
	  l_file_name.arr[l_file_name.len] ='\0';
	}
	/*
    strcpy(nd_rcpt_by_inv_yn.arr,argv[7]);
	nd_rcpt_by_inv_yn.len = strlen(nd_rcpt_by_inv_yn.arr);
	nd_rcpt_by_inv_yn.arr[nd_rcpt_by_inv_yn.len] = '\0';
    */


    strcpy(nd_rprint_yn.arr,argv[7]);
	nd_rprint_yn.len = strlen(nd_rprint_yn.arr);
	nd_rprint_yn.arr[nd_rprint_yn.len] = '\0';
	
	if (nd_rprint_yn.arr[0]=='\0')
	nd_rprint_yn.arr[0]='P';
	   
  
   if(sql_connect() == -1)
   {
    disp_message(ERR_MESG,"Error in connecting to Oracle\n");
    if (uid_pwd.len == 0)
    disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
    proc_exit();
   }
       
	set_meduser_role();

	strcpy(nd_lang_id.arr,l_language_id.arr);
    nd_lang_id.len = l_language_id.len;
	nd_lang_id.arr[nd_lang_id.len] = '\0';

	
	open_files();
	//print_recpt();
	get_currency();	 
     
	get_print_type();

	l_logo_yniflaser.arr[0] = 'N';
	l_online_print_yn.arr[0] ='Y';
	get_left_margin();	
    fetch_legend_value();
	get_hosp_name();
	declare_inv_receipt_cur(); 
	get_print_legend_yn();
	open_inv_receipt_cur();

while(fetch_inv_receipt_cur())
 {
  
   page_no=1;

   if (l_lsr != 0 && l_dmp == 0)
	{

		if ( l_logo_yniflaser.arr[0] != 'Y')
		{
			fprintf(fp,"%c&a1L",ESC);    /* To Set the Left margin */ 
			fprintf(fp,"%c(s14H",ESC); 	 /* To set the font size   */	
	 		fprintf(fp,"\n"); 
		}
	}
	else
	{
		fprintf(fp,"%cg",ESC); 		      /* To Set compressed mode */
		fprintf(fp,"\n");
	}
	  	 	      	   

	if(d_receipt_by_inv_yn.arr[0]=='Y')
	{
	 get_inv_dtls();
	 get_patient_name();
	 fetch_customer();
	 get_txt_for_inv_rcpt();
	}
	print_invoice_receipt();

	if(d_receipt_by_inv_yn.arr[0]=='Y')
	fprintf(fp," %-s:%-s/%-s\n",loc_legend[20],d_inv_doc_type_code.arr,d_inv_doc_number.arr);
	else
    fprintf(fp," %-s:%-s\n",loc_legend[20],d_pmnt_ref_num.arr);

	if (nd_print_legend_yn.arr[0]=='Y') 
	fprintf(fp," %-s(%-s%): ",loc_legend[21],loc_legend[22]);
	else
    fprintf(fp," %-24.24s "," ");
	/* Commented by raghava at BKK 
	no_of_lines = print_in_words(d_doc_amt,LENGTH_WORDS,sub_cur_str.arr,amt_in_words,nd_no_of_decimal);
	fprintf(fp,"(%c",'-');
  	for (i =0;i<no_of_lines;i++)
	{

   	  no_of_char=no_of_char+strlen(amt_in_words[i]);
     
	  if(no_of_char>=70)
	  {
	   fprintf(fp,"\n%-32.32s"," ");
	   no_of_char=0;
	  }
	
	  fprintf(fp," %s",amt_in_words[i]);
	 
	}
	  fprintf(fp,"%s",")");
	*/
	  fun_amt_in_words();
	  fprintf(fp,"%s ","(");
	  fprintf(fp,"%-s",amt_in_words_Sep.arr);
	  fprintf(fp,"%s",")");
	  
	  fprintf(fp,"\n");
	  fun_payment_det();
	  fprintf(fp,"\n");
	 
	  
	  get_cashier_name();
	  get_cashier_designation();
     if (nd_print_legend_yn.arr[0]=='Y') 
	 {
	  fprintf(fp," %-27.27s %23.23s---------------------------- %-28.28s"," ",loc_legend[23],loc_legend[24]);
      fprintf(fp,"\n");
      fprintf(fp," %-55.55s (%-s%-s"," ",nd_cashier_name.arr,")");
	  fprintf(fp,"\n");
	  fprintf(fp," %58.58s %-s\n\n",loc_legend[26],nd_cahier_position.arr);
	 }
	 else
	 {
	  //fprintf(fp," %-27.27s %23.23s---------------------------- %-28.28s",loc_legend[25],loc_legend[23],loc_legend[24]);
      fprintf(fp,"\n");
      fprintf(fp," %-55.55s %-s\n"," ",nd_cashier_name.arr);
	  fprintf(fp," %58.58s %-s\n\n"," ",nd_cahier_position.arr);
	 }
	  fprintf(fp," %75.75s %-s %-s\n",loc_legend[28],curr_date.arr,loc_legend[29]);
	  	 
fprintf(fp,"\f");  	
fprintf(fp,"\n"); 
   
}// outer while end brace
fflush(fp);
fclose(fp);   

if (l_online_print_yn.arr[0] == 'Y')
	{
		if (l_logo_yniflaser.arr[0] != 'Y')
		{
			  
		      PrintDocument (uid_pwd.arr,				//char	*PUidPwd;
							nd_session_id.arr,	        //char	*PSessionID;
							nd_facility_id.arr,		    //char	*PFacilityID;
							"BL",						//char	*PModuleID;
							nd_reportid.arr,		    //char	*PDocumentID;
							filename,					//char	*POnlinePrintFileNames;
							"O",						//char	*PLocationTypes;
							" ",						//char	*PLocationCodes;
							1,							//int		PNumOfCopies;
							1,							//int		PPageFrom;
							9999);						//int		PPageTo;);
		     
			
			declare_print_yn_cur();
			open_print_yn_cur();
			while(fetch_print_yn_cur())
			{
			update_print_yn_cur();
			}
			close_print_yn_cur();

					
		}
	}
	else
	{
		if (l_lsr != 0 && l_dmp == 0 && l_logo_yniflaser.arr[0] == 'Y')
		{		

		l_errortext.arr[0] = '\0';
		l_errortext.len = 0;			

		/* EXEC SQL EXECUTE
		DECLARE
			l_print_status BOOLEAN;
		BEGIN		
	
			 
			APPPRINT.SUBMIT_ORACLE_REPORT
				 (:nd_ws_no,
				  :nd_facility_id,
				  'BL',
				  :nd_logo_pgm_id,
				  'P', --p_report_option
				  '',  --p_outputfile_format
				  '',  --p_outputfile_name
				  'O',
				  ' ', --p_location_code
				  NULL, --:l_printer_names,
				  NULL,
				  NULL, --p_page_from
				  NULL, --p_page_to
				  NULL, --p_print_mode
				  'P_FILE_NAME='||:nd_file_name||'+'||'P_LOGO_NAME='||:l_logo_name, --p_param_list
				  l_print_status, --OUT BOOLEAN,
				 :l_errortext);			  
		
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare l_print_status BOOLEAN ; BEGIN APPPRINT . SUBMIT_OR\
ACLE_REPORT ( :nd_ws_no , :nd_facility_id , 'BL' , :nd_logo_pgm_id , 'P' , '' \
, '' , 'O' , ' ' , NULL , NULL , NULL , NULL , NULL , 'P_FILE_NAME=' || :nd_fi\
le_name || '+' || 'P_LOGO_NAME=' || :l_logo_name , l_print_status , :l_errorte\
xt ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[0] = (unsigned int  )52;
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
  sqlstm.sqhstv[2] = (         void  *)&nd_logo_pgm_id;
  sqlstm.sqhstl[2] = (unsigned int  )1002;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_file_name;
  sqlstm.sqhstl[3] = (unsigned int  )52;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_logo_name;
  sqlstm.sqhstl[4] = (unsigned int  )1002;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_errortext;
  sqlstm.sqhstl[5] = (unsigned int  )1002;
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



		if (l_errortext.arr[0] != '\0')
		{
			disp_message(ERR_MESG,l_errortext.arr);			
			proc_exit(0);
			
		}

	  }
	}
  
}// Main end braces

declare_print_yn_cur()
{



	/* EXEC SQL DECLARE BL_INV_RECEIPT_HDR_CUR CURSOR FOR
		SELECT DOC_TYPE_CODE,DOC_NUM
		FROM BL_SS_PAYMENT_REF_RCPT_HDR
		WHERE DOC_TYPE_CODE||'/'||DOC_NUM IN
		(
		SELECT SLMT_DOC_TYPE_CODE||'/'||SLMT_DOC_NUM
		FROM BL_SS_PAYMENT_REF_INV_DTL
		WHERE PMNT_REF_NUM = :nd_pmnt_ref_num
		); */ 
   

    if (OERROR)
		{ 
			disp_message (ERR_MESG,"declare failed FROM BL_INV_RECEIPT_HDR_CUR TABLE");
			proc_exit();
		}
}

open_print_yn_cur()
{ 
	    /* EXEC SQL OPEN BL_INV_RECEIPT_HDR_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 6;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0002;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )44;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_pmnt_ref_num;
     sqlstm.sqhstl[0] = (unsigned int  )102;
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
		{ 
		disp_message (ERR_MESG,"Open BL_INV_RECEIPT_HDR_CUR cursor failed");
		proc_exit();
		}
	return;
}

fetch_print_yn_cur()
{
  	
	nd_doc_type.arr[0] ='\0';
	nd_doc_num.arr[0]  ='\0';
	nd_doc_type.len		=0;
	nd_doc_num.len		=0;
	


  /* EXEC SQL FETCH BL_INV_RECEIPT_HDR_CUR
		   INTO :nd_doc_type,
				:nd_doc_num; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )63;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&nd_doc_type;
  sqlstm.sqhstl[0] = (unsigned int  )9;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_doc_num;
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





	if(OERROR)
	{ 
		disp_message(ERR_MESG,"FETCH FAILED IN BL_INV_RECEIPT_HDR_CUR");
		
	}

	if(NODATAFOUND)
	{
		return 0;
	}

	nd_doc_type.arr[nd_doc_type.len]  ='\0';
	nd_doc_num.arr[nd_doc_num.len]	  ='\0';
    
   return 1;
 
}

update_print_yn_cur()
{
	
 
	/* EXEC SQL UPDATE BL_SS_PAYMENT_REF_RCPT_HDR SET
		PRINT_FLAG ='Y' 
		WHERE DOC_TYPE_CODE=:nd_doc_type
		and DOC_NUM=:nd_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_SS_PAYMENT_REF_RCPT_HDR  set PRINT_FLAG='Y' where \
(DOC_TYPE_CODE=:b0 and DOC_NUM=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )86;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_doc_type;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_doc_num;
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


		
	/* EXEC SQL COMMIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )109;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 

	return 1;
		
}

close_print_yn_cur()
{ 
	
   /* EXEC SQL CLOSE BL_INV_RECEIPT_HDR_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )124;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




	if (OERROR) 
	{
	disp_message (ERR_MESG,"Close BL_INV_RECEIPT_HDR_CUR failed");
	proc_exit();
	}
	return;
}
/*** The below function added by raghava at BKK for printing Amount In Words ***/
fun_amt_in_words()
{
 	amt_in_words.arr[0]='\0';
	amt_in_words.len=0;
	
	amt_in_words_Sep.arr[0]='\0';
	amt_in_words_Sep.len=0;

	/* EXEC SQL EXECUTE
	BEGIN		
	:no_of_lines:=bl_spell_number.print_in_words
						(:nd_facility_id||'|'||:nd_lang_id,
						 abs(nvl(:d_doc_amt,0)),
						  70,
						 :cur_str,
						 :sub_cur_str,
						 :nd_no_of_decimal,
						 :amt_in_words,
						 :amt_in_words_Sep1);
  	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :no_of_lines := bl_spell_number . print_in_words ( :nd\
_facility_id || '|' || :nd_lang_id , abs ( nvl ( :d_doc_amt , 0 ) ) , 70 , :cu\
r_str , :sub_cur_str , :nd_no_of_decimal , :amt_in_words , :amt_in_words_Sep1 \
) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )139;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&no_of_lines;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[2] = (unsigned int  )6;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_doc_amt;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&cur_str;
 sqlstm.sqhstl[4] = (unsigned int  )10;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&sub_cur_str;
 sqlstm.sqhstl[5] = (unsigned int  )10;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_no_of_decimal;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&amt_in_words;
 sqlstm.sqhstl[7] = (unsigned int  )2002;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&amt_in_words_Sep1;
 sqlstm.sqhstl[8] = (unsigned int  )2002;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	amt_in_words.arr[amt_in_words.len]='\0';
	amt_in_words_Sep1.arr[amt_in_words_Sep1.len]='\0';

/* EXEC SQL SELECT REPLACE(:amt_in_words_Sep1,'~',CHR(10)||'                              ') 
		 INTO :amt_in_words_Sep
		 FROM DUAL; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 9;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select REPLACE(:b0,'~',(CHR(10)||'                           \
   ')) into :b1  from DUAL ";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )190;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&amt_in_words_Sep1;
sqlstm.sqhstl[0] = (unsigned int  )2002;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&amt_in_words_Sep;
sqlstm.sqhstl[1] = (unsigned int  )2002;
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


	amt_in_words_Sep.arr[amt_in_words_Sep.len]='\0';

}
fun_payment_det()
{
  
  declare_payment_type_det();
  open_payment_cur();
 if (nd_print_legend_yn.arr[0]=='Y') 
 {
  fprintf(fp," %-s ",loc_legend[25]);
  fprintf(fp,"\n");
 }
 else
 {
   fprintf(fp,"\n");
 }
 while(fetch_payment_det_cur())
   {
    
	  
	  if(l_num_rec==1)
	  {
	      if (l_lsr!= 0 && l_dmp== 0) 
		  fprintf(fp,"%c(s3B",ESC); 
		  if (l_lsr== 0 && l_dmp!= 0) 
		  fprintf(fp,"%cE",ESC); 		          /* To Set Bold For Dotmatrix*/
		  fprintf(fp," %-20.20s ",loc_legend[27]);
		  if (l_lsr!= 0 && l_dmp== 0) 
		  fprintf(fp,"%c(s-3B",ESC); 
		  if (l_lsr== 0 && l_dmp!= 0) 
		  fprintf(fp,"%cF",ESC); 		          /* To Set Bold For Dotmatrix*/
	  }
	  if(l_num_rec>1)
	  {
	 	   fprintf(fp,"%-15.15s "," ");
	  }
	  fprintf(fp," %-15.15s",d_settlement_desc.arr);
	  if (l_lsr!= 0 && l_dmp== 0) 
	  fprintf(fp,"%c(s3B",ESC); 
	  if (l_lsr== 0 && l_dmp!= 0) 
	  fprintf(fp,"%cE",ESC); 		          /* To Set Bold For Dotmatrix*/
	   print_formated_amt(d_pay_amt);
	  if (l_lsr!= 0 && l_dmp== 0) 
	  fprintf(fp,"%c(s-3B",ESC); 
	  if (l_lsr== 0 && l_dmp!= 0) 
	  fprintf(fp,"%cF",ESC); 		          /* To Set Bold For Dotmatrix*/
      fprintf(fp,"%-s ",cur_str.arr); 
      if (strcmp(d_cash_slmt_flag.arr,"D")==0) 
	  {
	     /* 
		  if(d_slmt_doc_ref_date.arr[0]!='\0')
		  {
			init_date_temp_var();
			strcpy(date_convert.arr,d_slmt_doc_ref_date.arr);
			fun_change_loc_date1();
			strcpy(d_slmt_doc_ref_date.arr,nd_loc_date1.arr);
		  }

		 
		  
		 fprintf(fp,"%-s: %-s %-s: %-s ",loc_legend[31],d_rcpt_rfnd_id_no.arr,loc_legend[10],d_slmt_doc_ref_date.arr);
		  commented for ICN-313*/
		 

        //fprintf(fp,"%-s ",loc_legend[31],d_rcpt_rfnd_id_no.arr); // for ICN-313
		fprintf(fp," %-s ",d_slmnt_doc_ref.arr); //modified by anandhi for scf 7307
	  }
	  else 
	  if (strcmp(d_cash_slmt_flag.arr,"B")==0) 
	  {
	    /*
		  if(d_slmt_doc_ref_date.arr[0]!='\0')
		  {
			init_date_temp_var();
			strcpy(date_convert.arr,d_slmt_doc_ref_date.arr);
			fun_change_loc_date1();
			strcpy(d_slmt_doc_ref_date.arr,nd_loc_date1.arr);
		  }
		
		fprintf(fp,"%-s %-s",d_slmnt_doc_ref.arr,d_slmt_doc_ref_date.arr);
		commented for ICN-313*/

		
	   // fprintf(fp,"%-s ",d_slmnt_doc_ref.arr); //for ICN-313  // COMMENTED BY ANANDHI FOR SCF 7307
           fprintf(fp,"%-s  %-s",loc_legend[38],d_slmnt_doc_ref.arr);
	  }
/*** The below code modified by anandhi for SCF-7307 ****/
	 
	   else 
	     if (strcmp(d_cash_slmt_flag.arr,"Y")==0)
		 {
		 if(strcmp(d_cashier_cheque.arr,"Y")==0)
                    {
		     fprintf(fp,"%-s  %-s",loc_legend[38],d_slmnt_doc_ref.arr);
                     }
                    else{
		       fprintf(fp,"%-s ",d_slmnt_doc_ref.arr);
		    }
		  }
	   else
	       {
	        
	       fprintf(fp,"%-s ",d_slmnt_doc_ref.arr);
	       }
         /**** upto here ****/

      d_bank_name.arr[0] = '\0';
      d_bank_name.len =0;

      /* EXEC SQL SELECT BANK_NAME 
	  INTO :d_bank_name 
	  FROM BL_BANK_NAME_LANG_VW
      WHERE bank_code=:d_bank_code
	  AND language_id=:nd_lang_id; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 9;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select BANK_NAME into :b0  from BL_BANK_NAME_LANG_VW wh\
ere (bank_code=:b1 and language_id=:b2)";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )213;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&d_bank_name;
      sqlstm.sqhstl[0] = (unsigned int  )62;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_bank_code;
      sqlstm.sqhstl[1] = (unsigned int  )27;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
      sqlstm.sqhstl[2] = (unsigned int  )6;
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


       
     d_bank_name.arr[d_bank_name.len] =0;
     //fprintf(fp,"%-s ",d_bank_code.arr); for ICN-313

	 //fprintf(fp,"%-20.20s ",d_bank_name.arr); //for ICN-313

	 /*** The below code added for ICN-313 ****/
	  /*** The below code modified by anandhi for SCF-7307 ****/
	   	  if(d_slmt_doc_ref_date.arr[0]!='\0')
		  {
			init_date_temp_var();
			strcpy(date_convert.arr,d_slmt_doc_ref_date.arr);
			fun_change_loc_date1();
			strcpy(d_slmt_doc_ref_date.arr,nd_loc_date1.arr);
		  }

		 if (strcmp(d_cash_slmt_flag.arr,"D")==0)
		  {
		  fprintf(fp," %-s ",d_bank_code.arr);  //anandhi
	       fprintf(fp,"  %-s ",d_slmt_doc_ref_date.arr);
               }
	       else
	     if (strcmp(d_cash_slmt_flag.arr,"B")==0)
	     {
	      fprintf(fp," %-s ",d_bank_code.arr);  //anandhi
	       fprintf(fp,"  %-s ",d_slmt_doc_ref_date.arr);
               }
               else
		if (strcmp(d_cash_slmt_flag.arr,"Y")==0)
		 {
		 if(strcmp(d_cashier_cheque.arr,"Y")==0)
                    {
		      fprintf(fp," %-s ",d_bank_code.arr);  //anandhi
	            fprintf(fp,"  %-s ",d_slmt_doc_ref_date.arr);
                     }
                    else{
		       fprintf(fp," %-s ",d_slmt_doc_ref_date.arr);
		    }
		  }
		  else
		  if (strcmp(d_cash_slmt_flag.arr,"A")==0)
		  {
		  fprintf(fp," %-s ",d_bank_code.arr);
		  }
		  else
		  {fprintf(fp," %-s ",d_bank_code.arr);  //anandhi
	       fprintf(fp,"  %-s ",d_slmt_doc_ref_date.arr);
	       }
        // fprintf(fp," %-s ",d_bank_code.arr); 
     /**** upto here ****/
     /**** upto here ****/
	fprintf(fp,"\n");

   l_num_rec++;

   }// while end brces
 
     
	 close_payment_cur();
 }

get_inv_dtls()
{
  
  d_inv_doc_type_code.arr[0]	='\0';
  d_inv_doc_number.arr[0]		='\0';
  d_inv_cust_grp.arr[0]			='\0';
  d_inv_cust_code.arr[0]		='\0';
  d_inv_policy_type_code.arr[0] ='\0';
  d_inv_patient.arr[0]			='\0';

  d_inv_doc_type_code.len	=0;
  d_inv_doc_number.len		=0;
  d_inv_cust_grp.len		=0;
  d_inv_cust_code.len		=0;
  d_inv_policy_type_code.len=0;
  d_inv_patient.len			=0;


  
  /* EXEC SQL SELECT DOC_TYPE_CODE,DOC_NUM,PAYER_GROUP_CODE,
		PAYER_CODE,POLICY_TYPE_CODE,PATIENT_ID
		INTO :d_inv_doc_type_code,:d_inv_doc_number,:d_inv_cust_grp,
		:d_inv_cust_code,:d_inv_policy_type_code,:d_inv_patient
		FROM BL_SS_INV_DBN_CRN_HDR
		WHERE (DOC_TYPE_CODE,DOC_NUM) IN
		(SELECT DOC_TYPE_CODE,DOC_NUM FROM BL_SS_PAYMENT_REF_INV_DTL
		WHERE SLMT_DOC_TYPE_CODE=:d_doc_type_code
		AND SLMT_DOC_NUM=:d_doc_num
		AND PMNT_REF_NUM=:d_pmnt_ref_num)
		AND NVL(CANCEL_YN,'N')='N'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DOC_TYPE_CODE ,DOC_NUM ,PAYER_GROUP_CODE ,PAYER_CODE\
 ,POLICY_TYPE_CODE ,PATIENT_ID into :b0,:b1,:b2,:b3,:b4,:b5  from BL_SS_INV_DB\
N_CRN_HDR where ((DOC_TYPE_CODE,DOC_NUM) in (select DOC_TYPE_CODE ,DOC_NUM  fr\
om BL_SS_PAYMENT_REF_INV_DTL where ((SLMT_DOC_TYPE_CODE=:b6 and SLMT_DOC_NUM=:\
b7) and PMNT_REF_NUM=:b8)) and NVL(CANCEL_YN,'N')='N')";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )240;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_inv_doc_type_code;
  sqlstm.sqhstl[0] = (unsigned int  )12;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_inv_doc_number;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_inv_cust_grp;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_inv_cust_code;
  sqlstm.sqhstl[3] = (unsigned int  )17;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_inv_policy_type_code;
  sqlstm.sqhstl[4] = (unsigned int  )52;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_inv_patient;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_doc_type_code;
  sqlstm.sqhstl[6] = (unsigned int  )8;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_doc_num;
  sqlstm.sqhstl[7] = (unsigned int  )52;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_pmnt_ref_num;
  sqlstm.sqhstl[8] = (unsigned int  )53;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
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
		disp_message (ERR_MESG,"Select Failed from BL_SS_INV_DBN_CRN_HDR Table");
	  }
 
  d_inv_doc_type_code.arr[d_inv_doc_type_code.len]		='\0';
  d_inv_doc_number.arr[d_inv_doc_number.len]			='\0';
  d_inv_cust_grp.arr[d_inv_cust_grp.len]				='\0';
  d_inv_cust_code.arr[d_inv_cust_code.len]				='\0';
  d_inv_policy_type_code.arr[d_inv_policy_type_code.len]='\0';
  d_inv_patient.arr[d_inv_patient.len]					='\0';


}
get_txt_for_inv_rcpt()
{

d_print_text_for_rcpt.arr[0]='\0';
d_print_text_for_rcpt.len=0;


/* EXEC SQL EXECUTE

	BEGIN

		 bl_ss_inv_settlement.get_recpt_text
				(:nd_facility_id,                
				:d_inv_cust_grp,
				:d_inv_cust_code,
				:d_inv_policy_type_code,       
				:d_print_text_for_rcpt,
   				:l_errorlevel,
				:l_sysmessageid,
				:l_errortext);
  
		if :l_sysmessageid is not null then
			:l_errorlevel := '10';
			:l_errortext := blcommon.get_error_text(:l_sysmessageid);
		end if;

	END;
	END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 9;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin bl_ss_inv_settlement . get_recpt_text ( :nd_facility_id\
 , :d_inv_cust_grp , :d_inv_cust_code , :d_inv_policy_type_code , :d_print_tex\
t_for_rcpt , :l_errorlevel , :l_sysmessageid , :l_errortext ) ; if :l_sysmessa\
geid is not null then :l_errorlevel := '10' ; :l_errortext := blcommon . get_e\
rror_text ( :l_sysmessageid ) ; end if ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )291;
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
sqlstm.sqhstv[1] = (         void  *)&d_inv_cust_grp;
sqlstm.sqhstl[1] = (unsigned int  )7;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&d_inv_cust_code;
sqlstm.sqhstl[2] = (unsigned int  )17;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&d_inv_policy_type_code;
sqlstm.sqhstl[3] = (unsigned int  )52;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&d_print_text_for_rcpt;
sqlstm.sqhstl[4] = (unsigned int  )152;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&l_errorlevel;
sqlstm.sqhstl[5] = (unsigned int  )12;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&l_sysmessageid;
sqlstm.sqhstl[6] = (unsigned int  )12;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&l_errortext;
sqlstm.sqhstl[7] = (unsigned int  )1002;
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



		if(strcmp(l_errorlevel.arr,"10") == 0 && l_errortext.arr[0] != '\0')
		{
		   proc_exit(0);
		}

		l_errorlevel.arr[0] = '\0';
		l_errorlevel.len = 0;

		l_sysmessageid.arr[0] = '\0';
		l_sysmessageid.len = 0;

		l_errortext.arr[0] = '\0';
		l_errortext.len = 0;

			
		d_print_text_for_rcpt.arr[d_print_text_for_rcpt.len]='\0';
}
print_invoice_receipt()
{

	 get_counter_location();
	 if(d_doc_date.arr[0]!='\0')
	 {
	  init_date_temp_var();
	  strcpy(date_convert.arr,d_doc_date.arr);
	  fun_change_loc_date();
	  strcpy(d_doc_date.arr,nd_loc_date.arr);
	 }	


	//fprintf(fp," %-50.50s%-17.17s%-s %d\n"," "," ",loc_legend[2],page_no);  
	if(strcmp(d_print_flag.arr,"Y")==0)
	{
	 	if (l_lsr!= 0 && l_dmp== 0)
		{
		  fprintf(fp,"%c&a4L",ESC); 	/* To Set the Left margin */
		  fprintf(fp,"%c(s10H",ESC);	
		  fprintf(fp,"%c(s3B",ESC); 
		  fprintf(fp,"%-68.68s%-10.10s\n"," ",loc_legend[30]);
		  fprintf(fp,"%c(s-3B",ESC);
		}
	   if (l_lsr== 0 && l_dmp!= 0)	
	   {
	     fprintf(fp,"%-68.68s"," ");
		 fprintf(fp,"%cE",ESC); 		          /* To Set Bold For Dotmatrix*/
		 fprintf(fp,"%cW1",ESC); 		      /* To Set doble width For Dotmatrix*/ 
		 //fprintf(fp,"%cw1",ESC); 		      /* To Set double height For Dotmatrix*/ 
		 fprintf(fp,"%-10.10s",loc_legend[30]);
		 //fprintf(fp,"%cw0",ESC); 		      /* To Set double height For Dotmatrix*/ 
		 fprintf(fp,"%cW0",ESC); 		      /* To Set doble width  For Dotmatrix*/ 
		 fprintf(fp,"%cF",ESC);				  /* To Set Realse the Bold For Dotmatrix*/
		 fprintf(fp,"\n");
	   }
	}
	
	if (nd_print_legend_yn.arr[0]=='Y') 
	{
 
	  if (l_lsr!= 0 && l_dmp== 0)
	  fprintf(fp,"%c(s3B",ESC);				  /* To Set Bold For Laser*/
	  if (l_lsr== 0 && l_dmp!= 0)
	  fprintf(fp,"%cE",ESC); 		          /* To Set Bold For Dotmatrix*/
	  fun_centre(loc_legend[1],105);
	  fprintf(fp,"%s",loc_legend[1]);
	  if (l_lsr!= 0 && l_dmp== 0)
	  fprintf(fp,"%c(s-3B",ESC);			  /* To Set Bold For Laser*/
	  if (l_lsr== 0 && l_dmp!= 0)
	  fprintf(fp,"%cF",ESC); 		          /* To Release Bold For Dotmatrix*/
	  fprintf(fp,"\n");

	
	  //fprintf(fp," %-50.50s%-17.17s%-s %d\n",loc_legend[3]," ",loc_legend[2],page_no);
      
  	  //fprintf(fp," %-60.60s%-7.7s",loc_legend[4]," ");
    	  
	      
      //fprintf(fp," %-14.14s, %-11.11s, %-7.7s, %-8.8s %-20.20s%-5.5s %-s %-s\n\n",loc_legend[5],loc_legend[6],loc_legend[7],loc_legend[8]," ",loc_legend[10],curr_date.arr,loc_legend[29]);
	  
	 
	  fprintf(fp," %-67.67s",nd_facility_name.arr);
	  if (l_lsr!= 0 && l_dmp== 0)
	  fprintf(fp,"%c(s3B",ESC);				  /* To Set Bold For Laser*/
	  if (l_lsr== 0 && l_dmp!= 0)
	  fprintf(fp,"%cE",ESC); 		          /* To Set Bold For Dotmatrix*/
	  fprintf(fp,"%-s:",loc_legend[37]);
	  if (l_lsr!= 0 && l_dmp== 0)
	  fprintf(fp,"%c(s-3B",ESC);			  /* To Set Bold For Laser*/
	  if (l_lsr== 0 && l_dmp!= 0)
	  fprintf(fp,"%cF",ESC); 		          /* To Release Bold For Dotmatrix*/
	  fprintf(fp," %-s",nd_counter_name.arr);
	  fprintf(fp,"\n");
	  fprintf(fp," %-67.67s",nd_hosp_add.arr);

      if (l_lsr!= 0 && l_dmp== 0)
	  fprintf(fp,"%c(s3B",ESC);				  /* To Set Bold For Laser*/
	  if (l_lsr== 0 && l_dmp!= 0)
      fprintf(fp,"%cE",ESC); 		          /* To Set Bold For Dotmatrix*/
	  fprintf(fp,"%-8.8s:",loc_legend[9]);
      if (l_lsr!= 0 && l_dmp== 0)
	  fprintf(fp,"%c(s-3B",ESC);			  /* To Set Bold For Laser*/
	  if (l_lsr== 0 && l_dmp!= 0)
	  fprintf(fp,"%cF",ESC); 		          /* To Release Bold For Dotmatrix*/
      fprintf(fp,"%-s/%-s\n",d_doc_type_code.arr,d_doc_num.arr);
    

      fprintf(fp," %-67.67s",nd_hosp_add1.arr);
	  if (l_lsr!= 0 && l_dmp== 0)
	  fprintf(fp,"%c(s3B",ESC);				  // To Set Bold For Laser
	  if (l_lsr== 0 && l_dmp!= 0)
      fprintf(fp,"%cE",ESC); 		          // To Set Bold For Dotmatrix
	 // fprintf(fp,"%-5.5s ",loc_legend[10]);  
	  if (l_lsr!= 0 && l_dmp== 0)
	  fprintf(fp,"%c(s-3B",ESC);			  // To Set Bold For Laser
	  if (l_lsr== 0 && l_dmp!= 0)
	  fprintf(fp,"%cF",ESC); 		          //To Release Bold For Dotmatrix
	  fprintf(fp,"%-s %-s\n\n",d_doc_date.arr,loc_legend[29]);
	 /*
	 
	  len_desc = strlen(nd_hosp_add.arr);
	  while(r_ctrdesc < len_desc)
	  {	
		split_text(nd_hosp_add.arr,58,cl_string_desc,&r_ctrdesc);
		if(l_ctr==1)
		{
		  fprintf(fp," %-60.60s %-6.6s",cl_string_desc," ");
		  fprintf(fp,"%cE",ESC); 		          // To Set Bold For Dotmatrix
		 // fprintf(fp,"%-5.5s ",loc_legend[10]);  
		  fprintf(fp,"%cF",ESC); 		          // To Set Release the Bold For Dotmatrix
		 // fprintf(fp,"%-s %-s",d_doc_date.arr,loc_legend[29]); 
		}
		else
		fprintf(fp," %-60.60s %-10.10s",cl_string_desc," ");
		strcpy(cl_string_desc,"");  
		fprintf(fp,"\n");line_no = line_no + 1;
		l_ctr++;
	  } 
	  r_ctrdesc=0;
	  */
	  if(d_payer_name.arr[0]!='\0')
	  {
	   if(d_receipt_by_inv_yn.arr[0]=='Y')
	   {
	    fprintf(fp," %-6.6s %-44.44s",loc_legend[11],d_payer_name.arr);
	    if (l_lsr!= 0 && l_dmp== 0)
		{
		 fprintf(fp,"%c(s8H",ESC);
		 fprintf(fp,"%c(s3B",ESC); 
		}
		if (l_lsr== 0 && l_dmp!= 0)
	    fprintf(fp,"%cE",ESC); 		          /* To Release Bold For Dotmatrix*/
		fprintf(fp,"%-s:%-s",loc_legend[12],d_inv_patient.arr);
		fprintf(fp," %-s\n",d_patient_name.arr);
		if (l_lsr!= 0 && l_dmp== 0)
		{
		 fprintf(fp,"%c(s-3B",ESC);
		 fprintf(fp,"%c(s14H",ESC);
        }
		if (l_lsr== 0 && l_dmp!= 0)
	    fprintf(fp,"%cF",ESC); 		          /* To Release Bold For Dotmatrix*/
		fprintf(fp,"\n");
	   }
	   else
	   fprintf(fp," %-6.6s %-s\n\n",loc_legend[11],d_payer_name.arr);
	  }
	  else
	  {
	   if(d_receipt_by_inv_yn.arr[0]=='Y')
	   {
	    fprintf(fp," %-6.6s %-s(%-s)  ",loc_legend[11],d_customer_name.arr,d_inv_cust_code.arr);
	    if (l_lsr!= 0 && l_dmp== 0)
		{
		 fprintf(fp,"%c(s8H",ESC);
		 fprintf(fp,"%c(s3B",ESC); 
		}
		fprintf(fp,"%-s:%-s\n",loc_legend[12],d_inv_patient.arr);
		fprintf(fp," %-s\n",d_patient_name.arr);
		if (l_lsr!= 0 && l_dmp== 0)
		{
		 fprintf(fp,"%c(s-3B",ESC);
		 fprintf(fp,"%c(s14H",ESC);
        }
		if (l_lsr== 0 && l_dmp!= 0)
	    fprintf(fp,"%cF",ESC); 		          /* To Release Bold For Dotmatrix*/
	   }
	   else
	   fprintf(fp," %-6.6s %-s\n\n",loc_legend[11],d_customer_name.arr);
	  }	
	  fprintf(fp,"%-10.10s%-42.42s%12.12s(%-4.4s) %16.16s(%-4.4s)\n"," ",loc_legend[13],loc_legend[14],cur_str.arr,loc_legend[15],cur_str.arr);
	  //fprintf(fp,"%-65.65s    %16.16s\n"," ",loc_legend[16]);
	  if (d_print_text_for_rcpt.arr[0]!='\0')
	  fprintf(fp,"%-10.10s%-44.44s"," ",d_print_text_for_rcpt.arr);
	  else
	  fprintf(fp,"%-10.10s%-44.44s"," ",loc_legend[17]);
	  print_formated_amt(d_doc_amt);
	  fprintf(fp,"\n\n\n");
      fprintf(fp,"%54.54s",loc_legend[18]);
	  //fprintf(fp,"%c&d#D",ESC);
	  print_formated_amt(d_doc_amt);
	  //fprintf(fp,"%c&d@",ESC);
	  fprintf(fp,"\n");
	  fprintf(fp,"%40.40s",loc_legend[19]);
	  if (l_lsr!= 0 && l_dmp== 0)
	  fprintf(fp,"%c(s3B",ESC); 
	  if (l_lsr== 0 && l_dmp!= 0)
	  fprintf(fp,"%cE",ESC); 		          /* To Release Bold For Dotmatrix*/
	  //fprintf(fp,"%c&d#D",ESC);
	  print_formated_amt(d_doc_amt);
	  if (l_lsr!= 0 && l_dmp== 0)
	  fprintf(fp,"%c(s-3B",ESC); 
	  if (l_lsr== 0 && l_dmp!= 0)
	  fprintf(fp,"%cF",ESC); 		          /* To Release Bold For Dotmatrix*/
	  //fprintf(fp,"%c&d@",ESC);
	  fprintf(fp,"\n\n");
	}
	if (nd_print_legend_yn.arr[0]=='N') 
	{

 	 // fprintf(fp," %-67.67s%-s %d\n"," ",loc_legend[2],page_no);  
      fprintf(fp," %-83.83s%-s/%-s\n"," ",d_doc_type_code.arr,d_doc_num.arr);
      fprintf(fp," %-73.73s%-s %-s\n\n"," ",curr_date.arr,loc_legend[29]);
	  if(d_payer_name.arr[0]!='\0')
	  {
	   if(d_receipt_by_inv_yn.arr[0]=='Y')
	   {
	    fprintf(fp," %-6.6s %-44.44s"," ",d_payer_name.arr);
	    if (l_lsr!= 0 && l_dmp== 0)
		{
		 fprintf(fp,"%c(s8H",ESC);
		 fprintf(fp,"%c(s3B",ESC); 
		}
		if (l_lsr== 0 && l_dmp!= 0)
	    fprintf(fp,"%cE",ESC); 		          /* To Release Bold For Dotmatrix*/
		fprintf(fp,"%-s\n\n\n",d_inv_patient.arr);
		fprintf(fp," %-s\n",d_patient_name.arr);
		if (l_lsr!= 0 && l_dmp== 0)
		{
		 fprintf(fp,"%c(s-3B",ESC);
		 fprintf(fp,"%c(s14H",ESC);
		}
		if (l_lsr== 0 && l_dmp!= 0)
	    fprintf(fp,"%cF",ESC); 		          /* To Release Bold For Dotmatrix*/
	   }
	   else
	   fprintf(fp," %-6.6s %-s\n\n\n\n"," ",d_payer_name.arr);	
	  }
	  else
	  {
	   if(d_receipt_by_inv_yn.arr[0]=='Y')
	   {
	    fprintf(fp," %-6.6s %-44.44s"," ",d_customer_name.arr);
	    if (l_lsr!= 0 && l_dmp== 0)
		{
		 fprintf(fp,"%c(s8H",ESC);
		 fprintf(fp,"%c(s3B",ESC); 
		}
		if (l_lsr== 0 && l_dmp!= 0)
	    fprintf(fp,"%cE",ESC); 		          /* To Release Bold For Dotmatrix*/
		fprintf(fp,"%-s\n\n\n",d_inv_patient.arr);
		fprintf(fp," %-s\n",d_patient_name.arr);
		if (l_lsr!= 0 && l_dmp== 0)
		{
		 fprintf(fp,"%c(s-3B",ESC);
		 fprintf(fp,"%c(s14H",ESC);
		}
		if (l_lsr== 0 && l_dmp!= 0)
	    fprintf(fp,"%cF",ESC); 		          /* To Release Bold For Dotmatrix*/
	   }
	   else
	   fprintf(fp," %-6.6s %-s\n\n\n\n"," ",d_customer_name.arr);
	  }	
	  //fprintf(fp,"%-10.10s%-42.42s%12.12s(%-4.4s) %16.16s(%-4.4s)\n"," ",loc_legend[13],loc_legend[14],cur_str.arr,loc_legend[15],cur_str.arr);
	  //fprintf(fp,"%-65.65s    %16.16s\n"," ",loc_legend[16]);
	  if (d_print_text_for_rcpt.arr[0]!='\0')
	  fprintf(fp,"%-10.10s%-44.44s"," ",d_print_text_for_rcpt.arr);
	  else
	  fprintf(fp,"%-10.10s%-44.44s"," ",loc_legend[17]);
	  print_formated_amt(d_doc_amt);
	  fprintf(fp,"\n\n\n");
      fprintf(fp,"%54.54s"," ");
	  //fprintf(fp,"%c&d3D",ESC);
	  print_formated_amt(d_doc_amt);
	  //fprintf(fp,"%c&d@",ESC);
	  fprintf(fp,"\n");
	  fprintf(fp,"%40.40s"," ");
	  if (l_lsr!= 0 && l_dmp== 0)
	  fprintf(fp,"%c(s3B",ESC); 
	  if (l_lsr== 0 && l_dmp!= 0)
	  fprintf(fp,"%cE",ESC); 		          /* To Release Bold For Dotmatrix*/
	  //fprintf(fp,"%c&d3D",ESC);
	  print_formated_amt(d_doc_amt);
	  if (l_lsr!= 0 && l_dmp== 0)
	  fprintf(fp,"%c(s-3B",ESC); 
	  if (l_lsr== 0 && l_dmp!= 0)
	  fprintf(fp,"%cF",ESC); 		          /* To Release Bold For Dotmatrix*/
	  //fprintf(fp,"%c&d@",ESC);
	  fprintf(fp,"\n\n");
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
  AND	 LANGUAGE_ID  =:nd_lang_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select distinct APPL_USER_NAME into :b0  from SM_APPL_USER_\
LANG where (APPL_USER_ID=:b1 and LANGUAGE_ID=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )338;
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
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
  sqlstm.sqhstl[2] = (unsigned int  )6;
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

/* Getting designation of cashier */

get_cashier_designation()
{
 
 
 nd_cahier_position.arr[0] ='\0';
 nd_cahier_position.len	   = 0;


 /* EXEC SQL EXECUTE
    
	DECLARE
    nd_func_role  VARCHAR2(3);
	
	BEGIN
		
		SELECT FUNC_ROLE 
		INTO nd_func_role
        FROM SM_APPL_USER_LANG_VW 
		WHERE  APPL_USER_ID=:d_added_by_id
        AND	 LANGUAGE_ID  =:nd_lang_id;

		IF nd_func_role='O' THEN

			SELECT long_desc 
			INTO :nd_cahier_position
			FROM sm_appl_user_lang_vw a,am_other_staff b,am_other_staff_type_lang_vw C
			WHERE a.appl_user_id=:d_added_by_id
			AND a.FUNC_ROLE='O'
			AND b.OTHER_STAFF_ID = a.FUNC_ROLE_ID
			AND c.OTHER_STAFF_TYPE = b.OTHER_STAFF_TYPE
			AND c.language_id=:nd_lang_id
			AND a.language_id=:nd_lang_id;

		END IF;



	END;

END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare nd_func_role VARCHAR2 ( 3 ) ; BEGIN SELECT FUNC_ROLE\
 INTO nd_func_role FROM SM_APPL_USER_LANG_VW WHERE APPL_USER_ID = :d_added_by_\
id AND LANGUAGE_ID = :nd_lang_id ; IF nd_func_role = 'O' THEN SELECT long_desc\
 INTO :nd_cahier_position FROM sm_appl_user_lang_vw a , am_other_staff b , am_\
other_staff_type_lang_vw C WHERE a . appl_user_id = :d_added_by_id AND a . FUN\
C_ROLE = 'O' AND b . OTHER_STAFF_ID = a . FUNC_ROLE_ID AND c . OTHER_STAFF_TYP\
E = b . OTHER_STAFF_TYPE AND c . language_id = :nd_lang_id AND a . language_id\
 = :nd_lang_id ; END IF ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )365;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_added_by_id;
 sqlstm.sqhstl[0] = (unsigned int  )33;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_cahier_position;
 sqlstm.sqhstl[2] = (unsigned int  )502;
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


 
    
    nd_cahier_position.arr[nd_cahier_position.len]='\0';

	if (OERROR)
	  { 
		disp_message (ERR_MESG,"FETCH FAILED FROM SM_APPL_USER TABLE");
	  }

 
}

declare_inv_receipt_cur()
 {

   /* EXEC SQL DECLARE inv_receipt_cursor CURSOR FOR
		SELECT A.PMNT_REF_NUM,A.DOC_TYPE_CODE,A.DOC_NUM, 
		to_char(A.DOC_DATE,'DD/MM/YYYY HH24:MI'),nvl(A.DOC_AMT,0),B.PAYER_NAME,A.ADDED_BY_ID,
		A.PRINT_FLAG,B.RECEIPT_BY_INV_YN,A.CASH_COUNTER_CODE
		FROM  BL_SS_PAYMENT_REF_RCPT_HDR A,BL_SS_PAYMENT_REF_HDR B
		WHERE A.COMP_CODE=B.COMP_CODE
		AND   A.PMNT_REF_NUM=B.PMNT_REF_NUM
		AND ( ( (:nd_rprint_yn='R')
				  and
				  Exists
				   (select 'x' from BL_SS_INV_INT_TEMP_BILL C
					Where A.DOC_TYPE_CODE=C.DOC_TYPE_CODE
					And   A.DOC_NUM=C.DOC_NUM
					And   C.PROCESS_SESSION_ID=:nd_session_id
					And	  C.PROCESS_PGM_ID IN ('BLTSS009','BLRSS006')
					--And   A.PMNT_REF_NUM = :nd_pmnt_ref_num
				   )
		        )
			 or	 
		      ((:nd_rprint_yn='P') and A.PMNT_REF_NUM = :nd_pmnt_ref_num)
		    )
		AND NVL(A.CANCEL_IND,'N')='N'
		AND NVL(B.RECEIPT_GEN_YN,'N')='Y'; */ 
 

	 if (OERROR)
	  { 
			disp_message (ERR_MESG,"Declare inv_receipt_cursor failed");
			proc_exit();
	  }

 
 }

 open_inv_receipt_cur()
 { 

	/* EXEC SQL OPEN inv_receipt_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0012;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )392;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_rprint_yn;
 sqlstm.sqhstl[0] = (unsigned int  )4;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_rprint_yn;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_pmnt_ref_num;
 sqlstm.sqhstl[3] = (unsigned int  )102;
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
	    disp_message (ERR_MESG,"Open inv_receipt_cursor failed");
		proc_exit();
	}
	
	return;
 }

fetch_inv_receipt_cur()
  {

	d_pmnt_ref_num.arr[0]		='\0';
    d_doc_type_code.arr[0]		='\0';
    d_doc_num.arr[0]			='\0';
    d_doc_date.arr[0]			='\0';
    d_payer_name.arr[0]			='\0';
    d_added_by_id.arr[0]		='\0';
    d_print_flag.arr[0]			='\0';
    d_receipt_by_inv_yn.arr[0]	='\0';
	d_cash_counter_code.arr[0]	='\0';

	d_pmnt_ref_num.len		=0;
    d_doc_type_code.len		=0;
    d_doc_num.len			=0;
    d_doc_date.len			=0;
    d_payer_name.len		=0;
    d_added_by_id.len		=0;
    d_print_flag.len		=0;
    d_receipt_by_inv_yn.len	=0;
	d_cash_counter_code.len =0;


	/* EXEC SQL FETCH inv_receipt_cursor INTO 
		d_pmnt_ref_num,
		d_doc_type_code,
		d_doc_num,
		d_doc_date,
		d_doc_amt,
		d_payer_name,
		d_added_by_id,
		d_print_flag,
		d_receipt_by_inv_yn,
		d_cash_counter_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )423;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_pmnt_ref_num;
 sqlstm.sqhstl[0] = (unsigned int  )53;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )8;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[2] = (unsigned int  )52;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_doc_date;
 sqlstm.sqhstl[3] = (unsigned int  )22;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_doc_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_payer_name;
 sqlstm.sqhstl[5] = (unsigned int  )502;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_added_by_id;
 sqlstm.sqhstl[6] = (unsigned int  )33;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_print_flag;
 sqlstm.sqhstl[7] = (unsigned int  )4;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_receipt_by_inv_yn;
 sqlstm.sqhstl[8] = (unsigned int  )4;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_cash_counter_code;
 sqlstm.sqhstl[9] = (unsigned int  )7;
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



    if(NODATAFOUND)
	{
	  return 0;
	 }
	
	if(OERROR)
	{ 
		err_mesg("Fetch Failed in inv_receipt_cursor",0,"");
		proc_exit();
	}



	d_pmnt_ref_num.arr[d_pmnt_ref_num.len]				='\0';
	d_doc_type_code.arr[d_doc_type_code.len]			='\0';
	d_doc_num.arr[d_doc_num.len]						='\0';
	d_doc_date.arr[d_doc_date.len]						='\0';
    d_payer_name.arr[d_payer_name.len]					='\0';
	d_added_by_id.arr[d_added_by_id.len]				='\0';
	d_print_flag.arr[d_print_flag.len]					='\0';	
	d_receipt_by_inv_yn.arr[d_receipt_by_inv_yn.len]	='\0';
    d_cash_counter_code.arr[d_cash_counter_code.len]	='\0';
  
   return 1;
			
  }

close_inv_receipt_cur()
{ 
	
    /* EXEC SQL CLOSE inv_receipt_cursor; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )478;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR) 
	{
		disp_message (ERR_MESG,"Close inv_receipt_cursor failed");
		proc_exit();
	}

   return;
}

declare_payment_type_det()
{

	/* EXEC SQL DECLARE PAYMENT_CUR CURSOR FOR
		SELECT
		A.DOC_AMT,
		A.SLMT_TYPE_CODE,
		B.SHORT_DESC,
		B.CASH_SLMT_FLAG,
		A.SLMT_DOC_REF_DESC,
		A.BANK_CODE,
		TRIM(A.PAYER_NAME),
		A.RCPT_RFND_ID_NO,
		A.SLMT_DOC_REF_DATE,
		C.CASHIER_CHEQUE_YN
		FROM BL_SS_PAYMENT_REF_RCPT_DTL A,BL_SLMT_TYPE_LANG_VW B,BL_SLMT_TYPE C  
		WHERE A.DOC_TYPE_CODE=:d_doc_type_code
		AND A.DOC_NUM=:d_doc_num
		AND A.SLMT_TYPE_CODE=B.SLMT_TYPE_CODE
		AND B.SLMT_TYPE_CODE=C.SLMT_TYPE_CODE
		AND LANGUAGE_ID=:nd_lang_id; */ 

	


	if (OERROR) 
	{
		disp_message (ERR_MESG,"Failed to Declare Pyament Type Cursor");
		proc_exit;
	}
	
	return;
}

open_payment_cur()
{ 
	/* EXEC SQL OPEN PAYMENT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0013;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )493;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )8;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[1] = (unsigned int  )52;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[2] = (unsigned int  )6;
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
		disp_message (ERR_MESG,"Open payment_det_cur cursor failed");
		proc_exit();
	}
	return;
}


fetch_payment_det_cur()
{

	d_settlement_type_code.arr[0]   = '\0'; 
	d_settlement_desc.arr[0]		= '\0';
	d_cash_slmt_flag.arr[0]			= '\0';
	d_slmnt_doc_ref.arr[0]          = '\0';
	d_bank_code.arr[0]				= '\0';
	d_payer_name.arr[0]			    = '\0';
	d_rcpt_rfnd_id_no.arr[0]		= '\0';
	d_slmt_doc_ref_date.arr[0]		= '\0';
	d_cashier_cheque.arr[0]			= '\0';

	d_settlement_type_code.len		= 0;
	d_settlement_desc.len			= 0;
	d_cash_slmt_flag.len			= 0;
	d_slmnt_doc_ref.len				= 0;
	d_bank_code.len					= 0;
	d_payer_name.len				= 0;
	d_rcpt_rfnd_id_no.len			= 0;
	d_slmt_doc_ref_date.len			= 0;
	d_cashier_cheque.len			=0;

	/* EXEC SQL FETCH PAYMENT_CUR INTO 
	  d_pay_amt,
	  d_settlement_type_code,
	  d_settlement_desc,
	  d_cash_slmt_flag,
	  d_slmnt_doc_ref,
	  d_bank_code,
	  d_payer_name,
	  d_rcpt_rfnd_id_no,
	  d_slmt_doc_ref_date,
	  d_cashier_cheque; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )520;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_pay_amt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_settlement_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_settlement_desc;
 sqlstm.sqhstl[2] = (unsigned int  )48;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_cash_slmt_flag;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_slmnt_doc_ref;
 sqlstm.sqhstl[4] = (unsigned int  )63;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_bank_code;
 sqlstm.sqhstl[5] = (unsigned int  )27;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_payer_name;
 sqlstm.sqhstl[6] = (unsigned int  )502;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_rcpt_rfnd_id_no;
 sqlstm.sqhstl[7] = (unsigned int  )33;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_slmt_doc_ref_date;
 sqlstm.sqhstl[8] = (unsigned int  )22;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_cashier_cheque;
 sqlstm.sqhstl[9] = (unsigned int  )4;
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




	d_settlement_type_code.arr[d_settlement_type_code.len]	= '\0'; 
	d_settlement_desc.arr[d_settlement_desc.len]			= '\0';
	d_cash_slmt_flag.arr[d_cash_slmt_flag.len]				= '\0';
	d_slmnt_doc_ref.arr[d_slmnt_doc_ref.len]				= '\0';
	d_bank_code.arr[d_bank_code.len]						= '\0';
	d_payer_name.arr[d_payer_name.len]					    = '\0';
	d_rcpt_rfnd_id_no.arr[d_rcpt_rfnd_id_no.len]			= '\0';
	d_slmt_doc_ref_date.arr[d_slmt_doc_ref_date.len]		= '\0';
        d_cashier_cheque.arr[d_cashier_cheque.len]                      ='\0';

  if(NODATAFOUND)
	{
		return 0;
	}
  

  if(OERROR)
	{ 
		err_mesg("FETCH FAILED IN PAYMENT_CUR",0,"");
		proc_exit();
	}

	

    return 1;

}

close_payment_cur()
{ 
	/* EXEC SQL CLOSE PAYMENT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )575;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR) 
	{
		disp_message (ERR_MESG,"Close header cursor failed");
		proc_exit();
	}
	return;
}
get_counter_location()
{
   nd_counter_name.arr[0]='\0';
   nd_counter_name.len=0;

   /* EXEC SQL Select SHORT_DESC
            Into   nd_counter_name
            From   BL_SS_CASH_COUNTER_LANG_VW
			Where  CASH_COUNTER_CODE=:d_cash_counter_code
			And    Upper(LANGUAGE_ID)=Upper(:nd_lang_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_DESC into :b0  from BL_SS_CASH_COUNTER_LANG_V\
W where (CASH_COUNTER_CODE=:b1 and Upper(LANGUAGE_ID)=Upper(:b2))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )590;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_counter_name;
   sqlstm.sqhstl[0] = (unsigned int  )502;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_cash_counter_code;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[2] = (unsigned int  )6;
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
        err_mesg("SELECT failed on get_counter_location Function",0,"");
   nd_counter_name.arr[nd_counter_name.len]='\0';


}

get_logo_dtl()
{
	
	  l_logo_yniflaser.arr[0] = 'N';

	  l_errorlevel.arr[0] = '\0';
	  l_errorlevel.len = 0;

	  l_sysmessageid.arr[0] = '\0';
	  l_sysmessageid.len = 0;

	  l_errortext.arr[0] = '\0';
	  l_errortext.len = 0;
			

	   if (l_lsr != 0 && l_dmp == 0)
	   {
		/* EXEC SQL EXECUTE	
		BEGIN					
			
			BLOPIN.GET_PRINT_SETUP_COL_VALUE(
				:nd_facility_id,
				'BLRVSBL1',
				'PRINT_LOGO_YN_IF_LASER',
				:l_logo_yniflaser,
				:l_errorlevel,
				:l_sysmessageid,
				:l_errortext) ;

				
				
			:l_logo_yniflaser := nvl(:l_logo_yniflaser,'N');

			if :l_sysmessageid is not null then
				:l_errorlevel := '10';
				:l_errortext := blcommon.get_error_text(:l_sysmessageid);
			end if;

		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin BLOPIN . GET_PRINT_SETUP_COL_VALUE ( :nd_facility_id \
, 'BLRVSBL1' , 'PRINT_LOGO_YN_IF_LASER' , :l_logo_yniflaser , :l_errorlevel , \
:l_sysmessageid , :l_errortext ) ; :l_logo_yniflaser := nvl ( :l_logo_yniflase\
r , 'N' ) ; if :l_sysmessageid is not null then :l_errorlevel := '10' ; :l_err\
ortext := blcommon . get_error_text ( :l_sysmessageid ) ; end if ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )617;
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
  sqlstm.sqhstv[1] = (         void  *)&l_logo_yniflaser;
  sqlstm.sqhstl[1] = (unsigned int  )1002;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_errorlevel;
  sqlstm.sqhstl[2] = (unsigned int  )12;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_sysmessageid;
  sqlstm.sqhstl[3] = (unsigned int  )12;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_errortext;
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



		if (strcmp(l_errorlevel.arr,"10") == 0 && l_errortext.arr[0] != '\0')
		{
			
			proc_exit(0);
		}

		l_errorlevel.arr[0] = '\0';
		l_errorlevel.len = 0;

		l_sysmessageid.arr[0] = '\0';
		l_sysmessageid.len = 0;

		l_errortext.arr[0] = '\0';
		l_errortext.len = 0;
	
		
		if (l_logo_yniflaser.arr[0] == 'Y')
		{
			/* EXEC SQL EXECUTE	
			BEGIN				
				BLOPIN.GET_PRINT_SETUP_COL_VALUE(
					:nd_facility_id,
					'BLRBILLO',
					'LOGO_NAME',
					:l_logo_name,
					:l_errorlevel,
					:l_sysmessageid,
					:l_errortext) ;
				

				if :l_sysmessageid is not null then
					:l_errorlevel := '10';
					:l_errortext := blcommon.get_error_text(:l_sysmessageid);
				end if;

			END;
			END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin BLOPIN . GET_PRINT_SETUP_COL_VALUE ( :nd_facility_id\
 , 'BLRBILLO' , 'LOGO_NAME' , :l_logo_name , :l_errorlevel , :l_sysmessageid ,\
 :l_errortext ) ; if :l_sysmessageid is not null then :l_errorlevel := '10' ; \
:l_errortext := blcommon . get_error_text ( :l_sysmessageid ) ; end if ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )652;
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
   sqlstm.sqhstv[1] = (         void  *)&l_logo_name;
   sqlstm.sqhstl[1] = (unsigned int  )1002;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_errorlevel;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_sysmessageid;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_errortext;
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


			if (strcmp(l_errorlevel.arr,"10") == 0 && l_errortext.arr[0] != '\0')
			{
			
				proc_exit(0);
			}

			LOGO_DIR.arr[0] = '\0';
			LOGO_DIR.len = 0;

		       l_errorlevel.arr[0] = '\0';
		       l_errorlevel.len = 0;

		       l_sysmessageid.arr[0] = '\0';
		       l_sysmessageid.len = 0;

		       l_errortext.arr[0] = '\0';
		       l_errortext.len = 0;	

			if (l_online_print_yn.arr[0] == 'N')
			{			
				/* EXEC SQL EXECUTE	
				BEGIN				
					WORKSTATION.GET_WS_PARAM(
						:nd_ws_no,				
						'BLLOGODIR',
						:LOGO_DIR,
						:l_errortext);			
					if :l_errortext is not null then 
						:l_errortext	:= 'BLLOGODIR:'||:l_errortext;
					end if;

				END;
				END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin WORKSTATION . GET_WS_PARAM ( :nd_ws_no , 'BLLOGODIR\
' , :LOGO_DIR , :l_errortext ) ; if :l_errortext is not null then :l_errortext\
 := 'BLLOGODIR:' || :l_errortext ; end if ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )687;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )52;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&LOGO_DIR;
    sqlstm.sqhstl[1] = (unsigned int  )1002;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&l_errortext;
    sqlstm.sqhstl[2] = (unsigned int  )1002;
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


				if (l_errortext.arr[0] != '\0')
				{
					
					proc_exit(0);
				}		
			}
		}
	    }
   }

get_payer_name()
{
   d_customer_name.arr[0] = '\0';
   d_customer_name.len=0;

   /* EXEC SQL SELECT PAYER_NAME INTO :d_customer_name
		    FROM BL_CUST_PAYMENT_REF_HDR 
		    WHERE UPPER(OPERATING_FACILITY_ID) = UPPER(:nd_facility_id)
		    AND   PMNT_REF_NUM = :nd_pmnt_ref_num; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select PAYER_NAME into :b0  from BL_CUST_PAYMENT_REF_HDR w\
here (UPPER(OPERATING_FACILITY_ID)=UPPER(:b1) and PMNT_REF_NUM=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )714;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_customer_name;
   sqlstm.sqhstl[0] = (unsigned int  )103;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_pmnt_ref_num;
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


   
   d_customer_name.arr[d_customer_name.len] = '\0';

   if(NODATAFOUND)
   {
	fetch_customer();
   }
   if (OERROR)
    err_mesg("SELECT failed on table  BL_CUST_PAYMENT_REF_HDR",0,"");
     

}
fetch_customer()
{

   d_customer_name.arr[0] = '\0';
   d_customer_name.len=0;

   /* EXEC SQL  SELECT SHORT_NAME into :d_customer_name
			 FROM	AR_CUSTOMER_LANG_VW 
			 WHERE  CUST_CODE = :d_inv_cust_code
			 AND  acc_entity_code = :nd_acc_entity_code
			 AND LANGUAGE_ID=:nd_lang_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_NAME into :b0  from AR_CUSTOMER_LANG_VW where\
 ((CUST_CODE=:b1 and acc_entity_code=:b2) and LANGUAGE_ID=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )741;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_customer_name;
   sqlstm.sqhstl[0] = (unsigned int  )103;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_inv_cust_code;
   sqlstm.sqhstl[1] = (unsigned int  )17;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_acc_entity_code;
   sqlstm.sqhstl[2] = (unsigned int  )7;
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



  d_customer_name.arr[d_customer_name.len] = '\0';
  
  if (OERROR)
	{	
	 disp_message(ERR_MESG,"Fetch Customer Cursor0 Failed");
	 proc_exit();
	}
 }

prt_line()
{
  int i;
  {
     for (i=0;i<105;i++)
     {
	if ( l_logo_yniflaser.arr[0] == 'Y')	
		fprintf(fp,"%c",175);
	else
		fprintf(fp,"_");		     
     }
  } 	      
}

prt_line_uc()
{
  int i;
  {
     for (i=0;i<105;i++)
     {
	  fprintf(fp,"_");		     
     }
  } 	      
}

print_formated_amt(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30], fstr_amt[30];

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        
        sprintf(str_amt,"%14s",s_amt);				
		ltrim (str_amt);		
		rtrim (str_amt);		
		//strcpy(fstr_amt,"CR ");
		//strcat(fstr_amt,str_amt);		
		//ltrim (fstr_amt);		
		//rtrim (fstr_amt);
		//sprintf(str_amt,"%15s",str_amt);		
        fprintf(fp,"%15s CR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15s   ",str_amt);
     }
 


}                        
print_formated(loc_amount)
double loc_amount;
{
    char s_amt[30], str_amt[30], fstr_amt[30];

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);        
        sprintf(str_amt,"%14s",s_amt);				
		ltrim (str_amt);		
		rtrim (str_amt);
		sprintf(str_amt,"%sCR",str_amt);
		return str_amt;
 
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%sDR",s_amt);
	return str_amt;
     }
}                        

print_next_page1()
{
	int i;
	
	while(v_lno <= MAX_LINES)
	{
		fprintf(fp,"\n");
		v_lno++;
	}	

	if (l_lsr != 0 && l_dmp == 0)
	{	 
		fprintf(fp,"\n\n");
	}
	else
	{
		fprintf(fp,"\n\n\n\n");
	}

	if ( l_logo_yniflaser.arr[0] != 'Y')
	{
		fprintf(fp,""); /* To Eject Page */ 
	
	}
    fprintf(fp,"\n");

	if (l_lsr != 0 && l_dmp == 0 )
	{
		if ( l_logo_yniflaser.arr[0] == 'Y')
		{
			fprintf(fp,"\n\n");
		}
	}
	v_lno=0;
	print_recpt();
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
print_formated_amt_varstr(loc_amount_varstr,loc_amount)
char loc_amount_varstr[100];
double loc_amount;
{
    char s_amt[30], str_amt[30], fstr_amt[30];    

    if(loc_amount < 0)
	{
        put_val(loc_amount_varstr,-loc_amount);        
        format_amt(loc_amount_varstr);                
		ltrim (loc_amount_varstr);		
		rtrim (loc_amount_varstr);		
		strcpy(fstr_amt,"(-)");
		strcat(fstr_amt,loc_amount_varstr);		
		ltrim (fstr_amt);		
		rtrim (fstr_amt);
		sprintf(loc_amount_varstr,"%s",fstr_amt);		  
     }
    else 
	{
        put_val(loc_amount_varstr,loc_amount);         	
		format_amt(loc_amount_varstr);		
		ltrim (loc_amount_varstr);		
		rtrim (loc_amount_varstr);		
     }

}                        

get_local_date()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:nd_lang_id,t_date);

		 :nd_loc_date:= to_char(t_date,'DD/MM/YYYY HH24:MI');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :nd_lang_id , t_\
date ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY HH24:MI' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )772;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date1,'DD/MM/YY'),:nd_lang_id,t_date);

		 :nd_loc_date1:= to_char(t_date,'DD/MM/YYYY');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date1 , 'DD/MM/YY' ) , :nd_lang_id , t_date ) ; \
:nd_loc_date1 := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )799;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date1;
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
 sqlstm.sqhstv[2] = (         void  *)&nd_loc_date1;
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


}init_date_temp_var()
{
nd_temp_date.arr[0] =  '\0';
nd_loc_date.arr[0]  =  '\0';
date_convert.arr[0] =  '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;


}

fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);
get_local_date();
nd_loc_date.arr[nd_loc_date.len]='\0';

}
fun_change_loc_date1()
{

strcpy(nd_temp_date1.arr,date_convert.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);

get_local_date1();
nd_loc_date1.arr[nd_loc_date1.len]='\0';

}

get_patient_name()
 {
		
		if(strlen(d_inv_patient.arr) != 0) 
			{ 
				d_patient_name.arr[0]			= '\0';
				d_patient_name_loc_lang.arr[0]  = '\0';
				nd_nationality.arr[0]			= '\0';
				d_nric_no.arr[0]				= '\0';
				d_date_of_birth.arr[0]			= '\0';
				d_org_dept.arr[0]				= '\0';
					
				d_patient_name.len			 = 0;
				d_patient_name_loc_lang.len  = 0;
				nd_nationality.len			 = 0;
				d_nric_no.len				 = 0;
				d_date_of_birth.len			 = 0;
				d_org_dept.len				 = 0;

				/* EXEC SQL SELECT decode(:nd_lang_id,'en',SHORT_NAME,SHORT_NAME_loc_lang),
	       						NATIONALITY_CODE,
								NATIONAL_ID_NUM,
								to_char(DATE_OF_BIRTH,'dd/mm/yyyy'),
								BLCOMMON.get_pat_EmpOrgDept(:d_inv_patient,:nd_lang_id)
						   INTO :d_patient_name,
								:nd_nationality,
								:d_nric_no,
								:d_date_of_birth,
								:d_org_dept
						   FROM MP_PATIENT_MAST
						  WHERE PATIENT_ID = :d_inv_patient; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 10;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select decode(:b0,'en',SHORT_NAME,SHORT_NAME_loc_lang) ,N\
ATIONALITY_CODE ,NATIONAL_ID_NUM ,to_char(DATE_OF_BIRTH,'dd/mm/yyyy') ,BLCOMMO\
N.get_pat_EmpOrgDept(:b1,:b0) into :b3,:b4,:b5,:b6,:b7  from MP_PATIENT_MAST w\
here PATIENT_ID=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )826;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_lang_id;
    sqlstm.sqhstl[0] = (unsigned int  )6;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_inv_patient;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
    sqlstm.sqhstl[2] = (unsigned int  )6;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_patient_name;
    sqlstm.sqhstl[3] = (unsigned int  )63;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_nationality;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_nric_no;
    sqlstm.sqhstl[5] = (unsigned int  )23;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_date_of_birth;
    sqlstm.sqhstl[6] = (unsigned int  )33;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_org_dept;
    sqlstm.sqhstl[7] = (unsigned int  )102;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_inv_patient;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
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
					err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");
				 }

				 d_patient_name.arr[d_patient_name.len]						= '\0';
				 d_patient_name_loc_lang.arr[d_patient_name_loc_lang.len]   = '\0';
				 nd_nationality.arr[nd_nationality.len]						= '\0';
				 d_nric_no.arr[d_nric_no.len]								= '\0';
				 d_date_of_birth.arr[d_date_of_birth.len]					= '\0';
				 d_org_dept.arr[d_org_dept.len]								= '\0';
			}

/*			
			d_receipt_desc.arr[0]	= '\0';
			d_acc_int_code.arr[0]	= '\0';
			d_ac_code.arr[0]		= '\0';

			d_receipt_desc.len  = 0;
			d_acc_int_code.len  = 0;
			d_ac_code.len		= 0;

			EXEC SQL select long_desc, 
							receipt_acc_int_code 
					   INTO :d_receipt_desc, 
							:d_acc_int_code
					   FROM BL_RECEIPT_TYPE
					  WHERE RECEIPT_TYPE_CODE = :d_receipt_type;

			d_receipt_desc.arr[d_receipt_desc.len]	= '\0';
			d_acc_int_code.arr[d_acc_int_code.len]	= '\0';

			EXEC SQL SELECT MAIN_ACC1_CODE||' '||MAIN_ACC2_CODE||' '||
							DEPT_CODE||' '||SUBLEDGER_GROUP_CODE||' '||
							SUBLEDGER_LINE_CODE||' '||PRODUCT_GROUP_CODE||' '||
							PRODUCT_LINE_CODE      
					   INTO :d_ac_code
					   FROM BL_GL_ACCOUNT
					  WHERE ACC_INT_CODE =:d_acc_int_code;

			d_ac_code.arr[d_ac_code.len]	= '\0';

*/
 }

get_left_margin()
{

	if (l_lsr != 0 && l_dmp == 0)
	  {
		if (l_logo_yniflaser.arr[0] == 'Y')			    
			l_margin_len = 40;				
		else
			l_margin_len = 27;
			

	  }
}
get_currency()
{
   cur_str.arr[0]	  = '\0';
   sub_cur_str.arr[0] = '\0';
   cur_str.len		  =  0;   
   sub_cur_str.len    =  0;

   /* EXEC SQL SELECT BASE_CURRENCY,
			BASE_CURRENCY_DEC 
			INTO :cur_str,
			:sub_cur_str
			FROM SY_ACC_ENTITY_LANG_VW
			WHERE ACC_ENTITY_ID = :nd_facility_id
			AND LANGUAGE_ID =:nd_lang_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select BASE_CURRENCY ,BASE_CURRENCY_DEC into :b0,:b1  from\
 SY_ACC_ENTITY_LANG_VW where (ACC_ENTITY_ID=:b2 and LANGUAGE_ID=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )877;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&cur_str;
   sqlstm.sqhstl[0] = (unsigned int  )10;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&sub_cur_str;
   sqlstm.sqhstl[1] = (unsigned int  )10;
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



   if(sqlca.sqlcode == 1403)
   { 
	    err_mesg("No base currency in table SY_ACC_ENTITY",0,"");
   }
   
   if (sqlca.sqlcode < 0)
   {   
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");
   }
   
   cur_str.arr[cur_str.len]  = '\0';
   sub_cur_str.arr[sub_cur_str.len] = '\0';

}
print_recpt()
{
   char out_str[10][133];
   char s_amt[20];
   int  length_str[10];
   int  l_no_of_deposit=0;
   int  i = 0,no_of_lines = 0;
   char epi_visit[14];
  
   line_no = 0;

   cur_str.arr[0]   = '\0';
   cur_str.len      =  0;   
   sub_cur_str.arr[0]   = '\0';
   sub_cur_str.len      = 0;

   /* exec sql select base_currency,
                   base_currency_dec 
            into :cur_str,
		   :sub_cur_str
  	    from sy_acc_entity_lang_vw
	    where acc_entity_id = :nd_facility_id
		and language_id =:nd_lang_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 10;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select base_currency ,base_currency_dec into :b0,:b1  from\
 sy_acc_entity_lang_vw where (acc_entity_id=:b2 and language_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )908;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&cur_str;
   sqlstm.sqhstl[0] = (unsigned int  )10;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&sub_cur_str;
   sqlstm.sqhstl[1] = (unsigned int  )10;
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



   if(sqlca.sqlcode == 1403)
   { 
	    err_mesg("No base currency in table SY_ACC_ENTITY",0,"");
   }
   
   if (sqlca.sqlcode < 0)
   {   
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");
   }
   
   cur_str.arr[cur_str.len]  = '\0';
   sub_cur_str.arr[sub_cur_str.len] = '\0';


   if (l_lsr != 0 && l_dmp == 0)
    {
	if ( l_logo_yniflaser.arr[0] != 'Y')
	  {
		 if(l_no_of_page > 1)
		 fprintf(fp,"\n");
	  }
    }
    else
    {
	if(l_no_of_page > 1)
	{
		fprintf(fp,"\n");
	}
    }

   if (l_lsr != 0 && l_dmp == 0)
	{	
	   
	   if ( l_logo_yniflaser.arr[0] != 'Y')
	   {
	      //fprintf(fp,"%c&d0D",ESC);   /* set Underline mode      */
	      fprintf(fp,"%c(s11H",ESC);  /* To set the font size	  */
	   }
	    
	      prt_space();	
	      	      
	     
	   if ( l_logo_yniflaser.arr[0] != 'Y')
	   {
	      fprintf(fp,"%c(s14H",ESC); /* To set the font size	  */
	      //fprintf(fp,"%c&d@",ESC); 	 /* release underline mode    */
	   }

	   fprintf(fp,"\n");

	   if ( l_logo_yniflaser.arr[0] != 'Y')
		{
			fprintf(fp,"%c(s8H",ESC);	
			fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 	  */	      
		}

		fprintf(fp,"\n");
	}
	

}
  
open_files()
{
   
   if (LOGO_DIR.arr[0] != '\0') 
	strcpy(filename,LOGO_DIR.arr);
   else 
	strcpy(filename,WORKING_DIR);

	strcat(filename,"BLRSS006.lis");

    strcpy(OUTPUT_FILE_NAME,filename );
  
   if ((fp = fopen(filename,"w")) == NULL)
   {
	 err_mesg("Error while opening output file",0,"");
	 proc_exit();
   }
   
}

get_hosp_name()
{
   
   nd_hosp_name.arr[0]  ='\0';
   nd_hosp_name.len     =  0;            
   nd_hosp_name1.arr[0] ='\0';
   nd_hosp_name1.len    =  0;    
   curr_date.arr[0]     ='\0';
   curr_date.len        =  0; 
   nd_tel.arr[0]	    ='\0';
   nd_tel.len		    =  0;
   nd_fax.arr[0]	    ='\0';
   nd_fax.len		    =  0;
   nd_use_in_hosp.arr[0]='\0';
   nd_use_in_hosp.len	=  0;
   nd_hosp_add.arr[0]	= '\0';
   nd_hosp_add.len      = 0;
   nd_hosp_add1.arr[0]	= '\0';
   nd_hosp_add1.len      = 0;
   nd_addr_line1.arr[0] ='\0';
   nd_addr_line2.arr[0] ='\0';
   nd_addr_line3.arr[0] ='\0';
   nd_addr_line4.arr[0] ='\0';
   nd_area_desc.arr[0] ='\0';
   nd_town_desc.arr[0] ='\0';
   nd_country_desc.arr[0] ='\0';
   nd_postal_desc.arr[0]='\0';

   nd_addr_line1.len=0;
   nd_addr_line2.len=0;
   nd_addr_line3.len=0;
   nd_addr_line4.len=0;
   nd_area_desc.len=0;
   nd_town_desc.len=0;
   nd_country_desc.len=0;
   nd_postal_desc.len=0;

   d_addr_line1_prompt.arr[0] = '\0';
   d_addr_line1_prompt.len    = 0;

   d_addr_line2_prompt.arr[0] = '\0';
   d_addr_line2_prompt.len    = 0;

   d_addr_line3_prompt.arr[0] = '\0';
   d_addr_line3_prompt.len    = 0;

   d_addr_line4_prompt.arr[0] = '\0';
   d_addr_line4_prompt.len    = 0;
  
   d_res_area_prompt.arr[0] = '\0';
   d_res_area_prompt.len    = 0;

   d_res_town_prompt.arr[0] = '\0';
   d_res_town_prompt.len    = 0;

   d_postal_code_prompt.arr[0] = '\0';
   d_postal_code_prompt.len    = 0;

   d_region_prompt.arr[0] = '\0';
   d_region_prompt.len    = 0;
 
   nd_acc_entity_code.arr[0] ='\0';
   nd_acc_entity_code.len    =  0;     

    /* EXEC SQL SELECT acc_entity_code,
					acc_entity_name,
					no_of_decimal, 
					--lpad(' ',round((46-length(ACC_ENTITY_NAME))/2),' ')||UPPER(ACC_ENTITY_NAME) ,
					UPPER(ACC_ENTITY_NAME),
					lpad(' ',round((:l_margin_len-length(ACC_ENTITY_NAME))/2),' ')||UPPER(ACC_ENTITY_NAME),
					to_char(sysdate,'DD/MM/RRRR HH24:MI'),
					TEL_NUM,
					FAX_NUM,
					INITCAP('use in '||LOWER(ACC_ENTITY_NAME)||' '||'only')
		INTO		:nd_acc_entity_code,
					:nd_facility_name,
					:nd_no_of_decimal,
					:nd_hosp_name,
					:nd_hosp_name1,
					:curr_date,
					:nd_tel,
					:nd_fax,
					:nd_use_in_hosp
    FROM sy_acc_entity_lang_vw
    WHERE acc_entity_id = :nd_facility_id
	AND   LANGUAGE_ID   = :nd_lang_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 12;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select acc_entity_code ,acc_entity_name ,no_of_decimal ,U\
PPER(ACC_ENTITY_NAME) ,(lpad(' ',round(((:b0-length(ACC_ENTITY_NAME))/2)),' ')\
||UPPER(ACC_ENTITY_NAME)) ,to_char(sysdate,'DD/MM/RRRR HH24:MI') ,TEL_NUM ,FAX\
_NUM ,INITCAP(((('use in '||LOWER(ACC_ENTITY_NAME))||' ')||'only')) into :b1,:\
b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9  from sy_acc_entity_lang_vw where (acc_entity_i\
d=:b10 and LANGUAGE_ID=:b11)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )939;
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
    sqlstm.sqhstv[2] = (         void  *)&nd_facility_name;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_no_of_decimal;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_hosp_name;
    sqlstm.sqhstl[4] = (unsigned int  )1002;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_hosp_name1;
    sqlstm.sqhstl[5] = (unsigned int  )1002;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&curr_date;
    sqlstm.sqhstl[6] = (unsigned int  )22;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_tel;
    sqlstm.sqhstl[7] = (unsigned int  )502;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_fax;
    sqlstm.sqhstl[8] = (unsigned int  )502;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_use_in_hosp;
    sqlstm.sqhstl[9] = (unsigned int  )502;
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
    sqlstm.sqhstv[11] = (         void  *)&nd_lang_id;
    sqlstm.sqhstl[11] = (unsigned int  )6;
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



   
   /* EXEC SQL select  ADDR_LINE1_PROMPT,
					 ADDR_LINE2_PROMPT,
					 ADDR_LINE3_PROMPT,
					 ADDR_LINE4_PROMPT,
					 RES_AREA_PROMPT,
					 RES_TOWN_PROMPT,
					 POSTAL_CODE_PROMPT,
					 REGION_PROMPT
			 into    :d_addr_line1_prompt,
					 :d_addr_line2_prompt,
					 :d_addr_line3_prompt,
					 :d_addr_line4_prompt,
					 :d_res_area_prompt,
					 :d_res_town_prompt,
					 :d_postal_code_prompt,
					 :d_region_prompt
	         from    SM_SITE_PARAM_LANG
             where upper(language_id)=upper(:nd_lang_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 12;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ADDR_LINE1_PROMPT ,ADDR_LINE2_PROMPT ,ADDR_LINE3_PR\
OMPT ,ADDR_LINE4_PROMPT ,RES_AREA_PROMPT ,RES_TOWN_PROMPT ,POSTAL_CODE_PROMPT \
,REGION_PROMPT into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from SM_SITE_PARAM_LANG w\
here upper(language_id)=upper(:b8)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1002;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_addr_line1_prompt;
   sqlstm.sqhstl[0] = (unsigned int  )502;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_addr_line2_prompt;
   sqlstm.sqhstl[1] = (unsigned int  )502;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_addr_line3_prompt;
   sqlstm.sqhstl[2] = (unsigned int  )502;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_addr_line4_prompt;
   sqlstm.sqhstl[3] = (unsigned int  )502;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_res_area_prompt;
   sqlstm.sqhstl[4] = (unsigned int  )502;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_res_town_prompt;
   sqlstm.sqhstl[5] = (unsigned int  )502;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_postal_code_prompt;
   sqlstm.sqhstl[6] = (unsigned int  )502;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_region_prompt;
   sqlstm.sqhstl[7] = (unsigned int  )502;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[8] = (unsigned int  )6;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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
	 disp_message (ERR_MESG,"Select failed in SM_SITE_PARAM_LANG");
	 proc_exit();
	}
   
   	d_addr_line1_prompt.arr[d_addr_line1_prompt.len]= '\0';
	d_addr_line2_prompt.arr[d_addr_line2_prompt.len]= '\0';
	d_addr_line3_prompt.arr[d_addr_line3_prompt.len]= '\0';
	d_addr_line4_prompt.arr[d_addr_line4_prompt.len]= '\0';
	d_res_area_prompt.arr[d_res_area_prompt.len]= '\0';
	d_res_town_prompt.arr[d_res_town_prompt.len]= '\0';
	d_postal_code_prompt.arr[d_postal_code_prompt.len]= '\0';
	d_region_prompt.arr[d_region_prompt.len]= '\0';

   
   /* EXEC SQL select 
	Decode(:nd_lang_id,'en',ADDR_LINE1,nvl(ADDR_LINE1_LOC_LANG,ADDR_LINE1)),
	Decode(:nd_lang_id,'en',ADDR_LINE2,nvl(ADDR_LINE2_LOC_LANG,ADDR_LINE2)),
	Decode(:nd_lang_id,'en',ADDR_LINE3,nvl(ADDR_LINE3_LOC_LANG,ADDR_LINE3)),
	Decode(:nd_lang_id,'en',ADDR_LINE4,nvl(ADDR_LINE4_LOC_LANG,ADDR_LINE4)),
	e.SHORT_DESC AREA_CODE,d.SHORT_DESC TWN_CODE,f.SHORT_DESC REGION_CODE,
	g.SHORT_DESC,a.TEL_NO1
	into :nd_addr_line1,nd_addr_line2,nd_addr_line3,nd_addr_line4,
	     nd_area_desc,nd_town_desc,:nd_region_desc,:nd_postal_desc,:nd_tel
	from SM_FACILITY_PARAM_LANG_VW A,mp_res_town_lang_vw D,
	mp_res_area_lang_vw E,mp_region_lang_vw F,
	mp_postal_code_lang_vw G
	where FACILITY_ID=:nd_facility_id
	and a.RES_AREA_CODE =e.RES_AREA_CODE
	and a.RES_TOWN_CODE=d.RES_TOWN_CODE
	and a.REGION_CODE=f.REGION_CODE
	and a.ADDR_POSTAL_CODE=g.POSTAL_CODE
	and upper(a.language_id)=upper(:nd_lang_id)
	and upper(d.language_id)=upper(:nd_lang_id)
	and upper(f.language_id)=upper(:nd_lang_id)
	and upper(e.language_id)=upper(:nd_lang_id)
	and upper(g.language_id)=upper(:nd_lang_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 19;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select Decode(:b0,'en',ADDR_LINE1,nvl(ADDR_LINE1_LOC_LANG,\
ADDR_LINE1)) ,Decode(:b0,'en',ADDR_LINE2,nvl(ADDR_LINE2_LOC_LANG,ADDR_LINE2)) \
,Decode(:b0,'en',ADDR_LINE3,nvl(ADDR_LINE3_LOC_LANG,ADDR_LINE3)) ,Decode(:b0,'\
en',ADDR_LINE4,nvl(ADDR_LINE4_LOC_LANG,ADDR_LINE4)) ,e.SHORT_DESC AREA_CODE ,d\
.SHORT_DESC TWN_CODE ,f.SHORT_DESC REGION_CODE ,g.SHORT_DESC ,a.TEL_NO1 into :\
b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12  from SM_FACILITY_PARAM_LANG_VW A ,mp_re\
s_town_lang_vw D ,mp_res_area_lang_vw E ,mp_region_lang_vw F ,mp_postal_code_l\
ang_vw G where (((((((((FACILITY_ID=:b13 and a.RES_AREA_CODE=e.RES_AREA_CODE) \
and a.RES_TOWN_CODE=d.RES_TOWN_CODE) and a.REGION_CODE=f.REGION_CODE) and a.AD\
DR_POSTAL_CODE=g.POSTAL_CODE) and upper(a.language_id)=upper(:b0)) and upper(d\
.language_id)=upper(:b0)) and upper(f.language_id)=upper(:b0)) and upper(e.lan\
guage_id)=upper(:b0)) and upper(g.language_id)=upper(:b0))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1053;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[0] = (unsigned int  )6;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[2] = (unsigned int  )6;
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
   sqlstm.sqhstv[4] = (         void  *)&nd_addr_line1;
   sqlstm.sqhstl[4] = (unsigned int  )502;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_addr_line2;
   sqlstm.sqhstl[5] = (unsigned int  )502;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_addr_line3;
   sqlstm.sqhstl[6] = (unsigned int  )502;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_addr_line4;
   sqlstm.sqhstl[7] = (unsigned int  )502;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_area_desc;
   sqlstm.sqhstl[8] = (unsigned int  )502;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_town_desc;
   sqlstm.sqhstl[9] = (unsigned int  )502;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_region_desc;
   sqlstm.sqhstl[10] = (unsigned int  )502;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_postal_desc;
   sqlstm.sqhstl[11] = (unsigned int  )502;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_tel;
   sqlstm.sqhstl[12] = (unsigned int  )502;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[13] = (unsigned int  )5;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[14] = (unsigned int  )6;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[15] = (unsigned int  )6;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[16] = (unsigned int  )6;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[17] = (unsigned int  )6;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[18] = (unsigned int  )6;
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
    {
         err_mesg("SELECT failed on cursor SY_ACC_ENTITY",0,"");
    }
    nd_acc_entity_code.arr[nd_acc_entity_code.len] ='\0';
	nd_facility_name.arr[nd_facility_name.len]     ='\0';
    nd_hosp_name.arr[nd_hosp_name.len]             ='\0';
    nd_hosp_name1.arr[nd_hosp_name1.len]           ='\0';
	curr_date.arr[curr_date.len]                   ='\0';
	nd_use_in_hosp.arr[nd_use_in_hosp.len]		   ='\0';
	nd_hosp_add.arr[nd_hosp_add.len]			   ='\0';
    nd_addr_line1.arr[nd_addr_line1.len]		   ='\0';
	nd_addr_line2.arr[nd_addr_line2.len]		   ='\0';
	nd_addr_line3.arr[nd_addr_line3.len]		   ='\0';
	nd_addr_line4.arr[nd_addr_line4.len]		   ='\0';
	nd_area_desc.arr[nd_area_desc.len]		       ='\0';
	nd_town_desc.arr[nd_town_desc.len]		       ='\0';
	nd_country_desc.arr[nd_country_desc.len]       ='\0';
	nd_postal_desc.arr[nd_postal_desc.len]='\0';
	nd_tel.arr[nd_tel.len]						   ='\0';
	

	if(nd_addr_line1.arr[0]!='\0')
	{
		//if(d_addr_line1_prompt.arr[0]!='\0')
		//{
		 strcat(nd_hosp_add.arr,loc_legend[33]);
		 strcat(nd_hosp_add.arr," ");
		//}
	 
	 strcat(nd_hosp_add.arr,nd_addr_line1.arr);
	 strcat(nd_hosp_add.arr," ");
	}

	if(nd_addr_line2.arr[0]!='\0')
	{
	 	if(d_addr_line2_prompt.arr[0]!='\0')
		{
		 strcat(nd_hosp_add.arr,d_addr_line2_prompt.arr);
		 strcat(nd_hosp_add.arr," ");
		}
	 strcat(nd_hosp_add.arr,nd_addr_line2.arr);
	 strcat(nd_hosp_add.arr," ");
	}
	if(nd_addr_line3.arr[0]!='\0')
	{
	 
	 	if(d_addr_line3_prompt.arr[0]!='\0')
		{
		 strcat(nd_hosp_add.arr,d_addr_line3_prompt.arr);
		 strcat(nd_hosp_add.arr," ");
		}
	 strcat(nd_hosp_add.arr,nd_addr_line3.arr);
	 strcat(nd_hosp_add.arr," ");
	}
	if(nd_addr_line4.arr[0]!='\0')
	{
	 	//if(d_addr_line4_prompt.arr[0]!='\0')
		//{
		 strcat(nd_hosp_add.arr,loc_legend[34]);
		 strcat(nd_hosp_add.arr," ");
		//}
	 
	 strcat(nd_hosp_add.arr,nd_addr_line4.arr);
	 strcat(nd_hosp_add.arr," ");
	}
	
	if(nd_town_desc.arr[0]!='\0')
	{
	 	//if(d_res_town_prompt.arr[0]!='\0')
		//{
		 strcat(nd_hosp_add.arr,loc_legend[35]);
		 strcat(nd_hosp_add.arr," ");
		//}
	 
	 strcat(nd_hosp_add.arr,nd_town_desc.arr);
	 strcat(nd_hosp_add.arr," ");
	} 
	if(nd_area_desc.arr[0]!='\0')
	{
	 	//if(d_res_area_prompt.arr[0]!='\0')
		//{
		 strcat(nd_hosp_add.arr,loc_legend[36]);
		 strcat(nd_hosp_add.arr," ");
		//}
	 
	 strcat(nd_hosp_add.arr,nd_area_desc.arr);
	 strcat(nd_hosp_add.arr," ");
	} 
	if(nd_region_desc.arr[0]!='\0')
	{
	 	/*
		if(d_region_prompt.arr[0]!='\0')
		{
		 strcat(nd_hosp_add.arr,d_region_prompt.arr);
		 strcat(nd_hosp_add.arr," ");
		}*/

	 strcat(nd_hosp_add1.arr,nd_region_desc.arr);
	 strcat(nd_hosp_add1.arr," ");
	} 
	if(nd_postal_desc.arr[0]!='\0')
	{
	 strcat(nd_hosp_add1.arr,nd_postal_desc.arr);
	 strcat(nd_hosp_add1.arr," ");
	} 
	if(nd_tel.arr[0]!='\0')
	{
	  strcat(nd_hosp_add1.arr,loc_legend[32]);
	  strcat(nd_hosp_add1.arr,".");
	  strcat(nd_hosp_add1.arr,nd_tel.arr);
	}
   nd_hosp_add1.arr[strlen(nd_hosp_add1.arr)]='\0';	  
 
}

get_print_type()
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
				:nd_reportid,
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
			 :nd_facility_id,
			 'BL',
			 :nd_reportid,
			 'O',
			 ' ',
			 :l_printer_ids,
			 :l_printer_names,
			 :l_printer_types ,
			 :l_queue_names,
			 :l_no_of_copies,
			 :l_errortext);		 

			 :l_dmp := NVL(instr(:l_printer_types,'D'),0);
			 :l_lsr := NVL(instr(:l_printer_types,'S'),0);			 

			 if :l_dmp != 0 and :l_lsr != 0 then 
			    :l_dmp := 0;
			    --if there is a laser, then output format will be laser
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
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "declare l_sys_mesg_id VARCHAR2 ( 10 ) ; l_err_level VARCHAR2 ( 10 ) ; l_\
err_text VARCHAR2 ( 1000 ) ; l_document_value blcommon . rectype_Tab ; l_for\
mat_type VARCHAR2 ( 200 ) ; l_report_tool_ind VARCHAR2 ( 1 ) ; BEGIN blcommo\
n . get_doc_print_format_Tab ( :nd_facility_id , :nd_reportid , l_document_v\
alue , l_sys_mesg_id , l_err_level , l_err_text ) ; FOR i IN l_document_valu\
e . FIRST .. l_document_value . LAST LOOP if l_document_value ( i ) . id = '\
FORMAT_TYPE' then l_format_type := l_document_value ( i ) . value ; end if ;\
 if l_document_value ( i ) . id = 'REPORT_TOOL_IND' then l_report_tool_ind :\
= l_document_value ( i ) . value ; end if ; END LOOP ; if l_format_type = 'D\
MP_PREPRINTED' then :l_dmp := 1 ; :l_lsr := 0 ; elsif l_format_type in ( 'LA\
SER_WITH_LOGO' , 'LASER_WITHOUT_LOGO' ) then :l_dmp := 0 ; :l_lsr := 1 ; els\
e :l_dmp := 0 ; :l_lsr := 0 ; end if ; if :l_dmp = 0 and :l_lsr = 0 then APP\
PRINT . GET_ROUTING_PRINTERS ( :nd_ws_no , :nd_facility_id , 'BL' , :nd_repo\
rtid , 'O' , ' ' , :l_printer_ids , :l_p");
 sqlstm.stmt = "rinter_names , :l_printer_types , :l_queue_names , :l_no_of_\
copies , :l_errortext ) ; :l_dmp := NVL ( instr ( :l_printer_types , 'D' ) , 0\
 ) ; :l_lsr := NVL ( instr ( :l_printer_types , 'S' ) , 0 ) ; if :l_dmp != 0 a\
nd :l_lsr != 0 then :l_dmp := 0 ; end if ; if :l_dmp = 0 and :l_lsr = 0 then :\
l_lsr := 1 ; end if ; end if ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1144;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_reportid;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_dmp;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_lsr;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[4] = (unsigned int  )52;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_printer_ids;
 sqlstm.sqhstl[5] = (unsigned int  )1002;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_printer_names;
 sqlstm.sqhstl[6] = (unsigned int  )1002;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_printer_types;
 sqlstm.sqhstl[7] = (unsigned int  )1002;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_queue_names;
 sqlstm.sqhstl[8] = (unsigned int  )1002;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_no_of_copies;
 sqlstm.sqhstl[9] = (unsigned int  )1002;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_errortext;
 sqlstm.sqhstl[10] = (unsigned int  )1002;
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



	if ( l_errortext.arr[0] != '\0')
	{
		l_errortext.arr[0] = '\0';
		l_errortext.len = 0;
	}

   
}

sql_connect()
{
  
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 19;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )1203;
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

prt_space()
{
	if (l_lsr != 0 && l_dmp == 0 && l_logo_yniflaser.arr[0] == 'Y')
	{
		fprintf(fp,"               ");
	}
}


prt_space_hdr()
{
	if (l_lsr != 0 && l_dmp == 0 && l_logo_yniflaser.arr[0] == 'Y')
	{
		fprintf(fp,"                      ");
	}
}

/*--------replicate a print character and changing the font hight  -----*/

replicate(printchar,no_of_times)
int printchar;
int no_of_times;
{
int i;
    for (i = 0; i < no_of_times; i++)
	    
	    fprintf(fp,"%c",printchar);
	   	          
  	return;
}

/*  ------end of replicate prg    ------*/
print_box()
{int i,j;

	replicate(tlc,1);
	replicate(hl,28);
	replicate(trc,1);
	fprintf(fp,"\n");
	v_lno++;
	
	for (i = 0;i < 3;i++)
	{	replicate(vl,1);
		for (j = 0;j < 28; j++) fprintf(fp," ");
		replicate(vl,1);
		fprintf(fp,"\n");  
		v_lno++;
	}
	replicate(blc,1);
	replicate(hl,28);
	replicate(brc,1);
	fprintf(fp,"%c(s12H",ESC);
	fprintf(fp,"\n");
	v_lno++;
}
fun_centre(v_text,v_size)
{
	int l_length,i;

	l_length=strlen(v_text);


	for (i=0;i<(v_size-l_length)/2;i++)
	{

		fprintf(fp," ");
	}
 
}
get_print_legend_yn()
{
 nd_print_legend_yn.arr[0]='\0';
 nd_print_legend_yn.len=0;

 /* EXEC SQL SELECT NVL(PRINT_LEGEND,'N')
          INTO :nd_print_legend_yn
		  FROM BL_SS_INV_PARAM; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(PRINT_LEGEND,'N') into :b0  from BL_SS_INV_PARAM ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1234;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_print_legend_yn;
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


  
  	if (OERROR)
    {
       err_mesg("SELECT failed on cursor BL_SS_INV_PARAM",0,"");
    }
    nd_print_legend_yn.arr[nd_print_legend_yn.len] ='\0';

}
fetch_legend_value()
{
	
	for(i=1;i<=1000;i++)
	{

		l_pk_value.arr[0] = '\0';
 
		/* EXEC SQL SELECT LTRIM(RTRIM('BLRSS006.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
				   INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 19;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRSS006.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1253;
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
										:nd_lang_id);

  

		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 19;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :nd_lang_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1276;
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