
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
           char  filnam[44];
};
static const struct sqlcxp sqlfpn =
{
    43,
    "D:\\BLTEST\\12X\\LEAP-INT-SCF-9462\\BLRDISCL.PC"
};


static unsigned long sqlctx = 2098890549;


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
            void  *sqhstv[22];
   unsigned int   sqhstl[22];
            int   sqhsts[22];
            void  *sqindv[22];
            int   sqinds[22];
   unsigned int   sqharm[22];
   unsigned int   *sqharc[22];
   unsigned short  sqadto[22];
   unsigned short  sqtdso[22];
} sqlstm = {10,22};

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

 static const char *sq0019 = 
"select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,'Y'  from SY_PROG_PARAM where ((PGM_I\
D='BLRDISCL' and SESSION_ID=:b0) and PGM_DATE=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,47,0,4,400,0,0,4,3,0,1,0,1,9,0,0,1,3,0,0,1,3,0,0,2,9,0,0,
36,0,0,2,355,0,4,526,0,0,17,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
119,0,0,3,150,0,5,613,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
146,0,0,4,0,0,29,619,0,0,0,0,0,1,0,
161,0,0,5,305,0,6,638,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,
9,0,0,
200,0,0,6,365,0,6,700,0,0,5,5,0,1,0,1,9,0,0,3,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,
235,0,0,7,292,0,6,742,0,0,5,5,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,
270,0,0,8,184,0,6,781,0,0,3,3,0,1,0,1,9,0,0,3,9,0,0,3,9,0,0,
297,0,0,9,197,0,6,965,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
324,0,0,10,216,0,6,994,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
351,0,0,11,222,0,6,1023,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
378,0,0,12,222,0,6,1051,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
405,0,0,13,196,0,6,1080,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
432,0,0,14,177,0,4,1230,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1,9,0,0,
471,0,0,15,91,0,2,1261,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
494,0,0,16,126,0,4,1288,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
525,0,0,17,1435,0,6,1439,0,0,12,12,0,1,0,1,9,0,0,1,9,0,0,3,3,0,0,3,3,0,0,2,9,0,
0,1,9,0,0,2,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
588,0,0,18,0,0,27,1530,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
619,0,0,19,137,0,9,1675,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
642,0,0,20,91,0,2,1683,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
665,0,0,19,0,0,15,1693,0,0,0,0,0,1,0,
680,0,0,21,338,0,4,1919,0,0,4,2,0,1,0,1,3,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
711,0,0,22,61,0,6,2026,0,0,2,2,0,1,0,1,97,0,0,2,9,0,0,
734,0,0,23,38,0,4,2054,0,0,1,0,0,1,0,2,9,0,0,
753,0,0,24,108,0,4,2076,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
780,0,0,25,43,0,4,2095,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
803,0,0,26,105,0,4,2104,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
830,0,0,27,122,0,4,2127,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
857,0,0,28,57,0,4,2138,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
880,0,0,29,55,0,4,2147,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
903,0,0,30,47,0,4,2355,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
930,0,0,31,47,0,4,2373,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
957,0,0,32,47,0,4,2391,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
984,0,0,33,47,0,4,2408,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
1011,0,0,34,47,0,4,2425,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
1038,0,0,35,47,0,4,2442,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
1065,0,0,36,47,0,4,2459,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
1092,0,0,37,46,0,4,2475,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
1119,0,0,38,47,0,4,2492,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
1142,0,0,39,46,0,4,2534,0,0,4,3,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,2,3,0,0,
1173,0,0,40,212,0,4,2645,0,0,6,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1,9,0,0,
1212,0,0,41,507,0,4,2662,0,0,22,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */ 
/************************************************************************/
/* PROGRAM NAME          : BLRDISCL.PC                                  */
/* AUTHOR                : HARISH                                       */
/************************************************************************/

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <bl.h>

#define NODATAFOUND sqlca.sqlcode == 1403
#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
//#define MAX_LINES 40
#define ESC     0x1B
#define INIT_MESG       "Printing Discharge Clearance in progress"
#define ONLINE_PRINTING 1
/*
#define DEBUG 1
*/
#define ERR_MESG  4
#define NODATAFOUND sqlca.sqlcode == 1403
#define RESOURCE_BUSY (sqlca.sqlcode == -54)
#define SKIP_1 3
#define SKIP_2 64
#define SKIP_3 3
#define SKIP_4 10
#define SKIP_4_1 2
#define SKIP_5 22
#define SKIP_6 15
#define SKIP_6_1 15
#define SKIP_7 3
#define SKIP_8 13
#define SKIP_9 10
#define LENGTH_WORDS 80

/* EXEC SQL BEGIN DECLARE SECTION; */ 



/* VARCHAR	uid_pwd					[132],
		date_time				[20],
		user_id					[91],
		nd_pgm_date				[35],
		nd_facility_name		[31],
		nd_hcard_status			[12],
		nd_file_name            [50],	
		l_errortext				[1000],
		l_logo_yniflaser		[1000],
		LOGO_DIR				[1000],
		l_logo_name				[1000],
		nd_cashier_name         [50],
		l_errorlevel			[10],
		l_sysmessageid			[10],
		l_printer_ids		[1000],
	    l_printer_names		[1000],
	    l_printer_types		[1000],
	    l_queue_names		[1000],
	    l_no_of_copies		[1000],
		d1_patient_id       [21],
		l_file_name			[50],
		d_ward_code              [10],
		d_bed_num		 [10],
		d_room_num			  [11],
		d_auth_by_id		  [31],
		d_bed_class_code	  [10],
		d_auth_remarks	      [202],
		curr_date				[20]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[12]; } nd_hcard_status;

struct { unsigned short len; unsigned char arr[50]; } nd_file_name;

struct { unsigned short len; unsigned char arr[1000]; } l_errortext;

struct { unsigned short len; unsigned char arr[1000]; } l_logo_yniflaser;

struct { unsigned short len; unsigned char arr[1000]; } LOGO_DIR;

struct { unsigned short len; unsigned char arr[1000]; } l_logo_name;

struct { unsigned short len; unsigned char arr[50]; } nd_cashier_name;

struct { unsigned short len; unsigned char arr[10]; } l_errorlevel;

struct { unsigned short len; unsigned char arr[10]; } l_sysmessageid;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_ids;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_names;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_types;

struct { unsigned short len; unsigned char arr[1000]; } l_queue_names;

struct { unsigned short len; unsigned char arr[1000]; } l_no_of_copies;

struct { unsigned short len; unsigned char arr[21]; } d1_patient_id;

struct { unsigned short len; unsigned char arr[50]; } l_file_name;

struct { unsigned short len; unsigned char arr[10]; } d_ward_code;

struct { unsigned short len; unsigned char arr[10]; } d_bed_num;

struct { unsigned short len; unsigned char arr[11]; } d_room_num;

struct { unsigned short len; unsigned char arr[31]; } d_auth_by_id;

struct { unsigned short len; unsigned char arr[10]; } d_bed_class_code;

struct { unsigned short len; unsigned char arr[202]; } d_auth_remarks;

struct { unsigned short len; unsigned char arr[20]; } curr_date;


/* VARCHAR	d_bill_doc_type_code	[18],
		d2_bill_doc_type_code	[18],
		d_bill_doc_num			[9],
		d2_bill_doc_num			[20],
		d2_doc_date				[35],
		d_bill_format			[2],
		sub_print_text			[70],
		sub_print_text1			[100]; */ 
struct { unsigned short len; unsigned char arr[18]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[18]; } d2_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_bill_doc_num;

struct { unsigned short len; unsigned char arr[20]; } d2_bill_doc_num;

struct { unsigned short len; unsigned char arr[35]; } d2_doc_date;

struct { unsigned short len; unsigned char arr[2]; } d_bill_format;

struct { unsigned short len; unsigned char arr[70]; } sub_print_text;

struct { unsigned short len; unsigned char arr[100]; } sub_print_text1;


/* VARCHAR	d_added_by_id			[50],
		d_receipt_type_code		[10],
		d_doc_type_code1    	[10],		
		d_doc_number1           [10],
		d3_bill_doc_type_code	[50],
		d3_bill_doc_number		[50],
		d2_episode_type			[2],
		d2_episode_id			[9],
		d_print_copy_num    [10],
		d2_visit_id				[5],
		d2_customer_code		[25],
		d_print_yn				[5],
		d_oth_rec_desc			[50],
		d_cashier_cheque_yn     [3],
		d_rcpt_nat_desc         [500]; */ 
struct { unsigned short len; unsigned char arr[50]; } d_added_by_id;

struct { unsigned short len; unsigned char arr[10]; } d_receipt_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_doc_type_code1;

struct { unsigned short len; unsigned char arr[10]; } d_doc_number1;

struct { unsigned short len; unsigned char arr[50]; } d3_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[50]; } d3_bill_doc_number;

struct { unsigned short len; unsigned char arr[2]; } d2_episode_type;

struct { unsigned short len; unsigned char arr[9]; } d2_episode_id;

struct { unsigned short len; unsigned char arr[10]; } d_print_copy_num;

struct { unsigned short len; unsigned char arr[5]; } d2_visit_id;

struct { unsigned short len; unsigned char arr[25]; } d2_customer_code;

struct { unsigned short len; unsigned char arr[5]; } d_print_yn;

struct { unsigned short len; unsigned char arr[50]; } d_oth_rec_desc;

struct { unsigned short len; unsigned char arr[3]; } d_cashier_cheque_yn;

struct { unsigned short len; unsigned char arr[500]; } d_rcpt_nat_desc;

			   


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
		nd_to_doc_date			[12],
		nd_lang_id               [3],
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

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[3]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[50]; } nd_ws_no;


char	print_y,
        rec_out, 
		grp_out, 
		
		sec_box_out;

char	st_var[50]; 
/* VARCHAR	st_tel_fax[100]; */ 
struct { unsigned short len; unsigned char arr[100]; } st_tel_fax;


//char	amt_in_words	[10][133],
//		amt_in_words1	[10][133];

/* VARCHAR	amt_in_words	  [2000],
		amt_in_words_Sep  [2000],
		amt_in_words_Sep1 [2000]; */ 
struct { unsigned short len; unsigned char arr[2000]; } amt_in_words;

struct { unsigned short len; unsigned char arr[2000]; } amt_in_words_Sep;

struct { unsigned short len; unsigned char arr[2000]; } amt_in_words_Sep1;


int		v_lno = 0,
		v_pno = 0,
		v_lnum =0,
		print_hdr_cnt=0,
		refidcnt=0,
		filecount=0;  

int		ccnt=0,ccnt1=0,
		rcnt=0,
		oth_cnt=0,k=1,i=0,p=1,
		othp_cnt=0,
		legend_cnt=0,
		lcol_cnt=0,r_ctr,
		l_cnt_no_of_legends=0;

long	MAX_LINES=40;



/* VARCHAR	d_doc_type_code         [7],
		d_doc_number            [9],
		nd_doc_type				[7],
		nd_doc_num				[19],
		nd_doc_num_ccc				[19],
		d_episode_type          [2],
		d_patient_id            [21],
		d_patient_name          [61],
		d_patient_name_loc_lang [61],
		d_episode_id            [9],
		d_visit_id              [5],
		d_doc_amt               [23],
		d_acc_int_code			[7],
		d_ac_code				[51],
		d_nric_no				[21],
		nd_reportid				[20],
		nd_logo_pgm_id			[1000],
		l_to_doc_type_code		[10],
		l_to_doc_type_num		[10],
		l_online_print_yn		[5],
		l_fr_date				[30],
		l_arg_patient_id		[25],
		l_to_date				[30],
		l_curr_date				[30],
		l_episode_type          [2],
		nd_episode_type			[5],
		nd_reprint_yn			[2],
		leg_cust				[70]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_number;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type;

struct { unsigned short len; unsigned char arr[19]; } nd_doc_num;

struct { unsigned short len; unsigned char arr[19]; } nd_doc_num_ccc;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[23]; } d_doc_amt;

struct { unsigned short len; unsigned char arr[7]; } d_acc_int_code;

struct { unsigned short len; unsigned char arr[51]; } d_ac_code;

struct { unsigned short len; unsigned char arr[21]; } d_nric_no;

struct { unsigned short len; unsigned char arr[20]; } nd_reportid;

struct { unsigned short len; unsigned char arr[1000]; } nd_logo_pgm_id;

struct { unsigned short len; unsigned char arr[10]; } l_to_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } l_to_doc_type_num;

struct { unsigned short len; unsigned char arr[5]; } l_online_print_yn;

struct { unsigned short len; unsigned char arr[30]; } l_fr_date;

struct { unsigned short len; unsigned char arr[25]; } l_arg_patient_id;

struct { unsigned short len; unsigned char arr[30]; } l_to_date;

struct { unsigned short len; unsigned char arr[30]; } l_curr_date;

struct { unsigned short len; unsigned char arr[2]; } l_episode_type;

struct { unsigned short len; unsigned char arr[5]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[2]; } nd_reprint_yn;

struct { unsigned short len; unsigned char arr[70]; } leg_cust;


/* VARCHAR	d_encounter_id			[13],
		d_cust_code1			[25],
		nd_cust_code1			[25],
		nd_cust_cd1				[25],
		d_cust_code				[25],
		nd_cust_code			[25],
		nd_acc_entity_code		[5]; */ 
struct { unsigned short len; unsigned char arr[13]; } d_encounter_id;

struct { unsigned short len; unsigned char arr[25]; } d_cust_code1;

struct { unsigned short len; unsigned char arr[25]; } nd_cust_code1;

struct { unsigned short len; unsigned char arr[25]; } nd_cust_cd1;

struct { unsigned short len; unsigned char arr[25]; } d_cust_code;

struct { unsigned short len; unsigned char arr[25]; } nd_cust_code;

struct { unsigned short len; unsigned char arr[5]; } nd_acc_entity_code;

				


/* VARCHAR nd_temp_date[20],
		nd_temp_date1[20],
		nd_loc_date1[20],
		nd_loc_date[20],
		date_convert[20],
		nd_preprint_flag[3]; */ 
struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date1;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date1;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[20]; } date_convert;

struct { unsigned short len; unsigned char arr[3]; } nd_preprint_flag;
 //added by raghava as per kuila sir instructions
/*********CRF-656*******/
/* VARCHAR     date							[20],
            nd_pwd 							[91],
		    nd_pwd1 						[91],
            d_curr_pgm_name                 [15],
			nd_report	         		    [20],
			nd_facility				        [3],
			nd_REGION_CODE					[100],
			nd_RES_AREA_CODE				[100],
			nd_RES_TOWN_CODE				[100],
			nd_CASH_SLMT_FLAG				[4],
			nd_reminder_format_id			[21],
			bl_reminder_format_id			[21],
			bl_report_title_text			[101],
			bl_header_line_01				[101],
			bl_header_line_02				[101],
			bl_header_line_03				[101],
			bl_header_line_04				[101],
			bl_header_line_05				[101],
			bl_header_line_06				[101],
			bl_header_line_07				[101],
			bl_header_line_08				[101],
			bl_header_line_09				[101],
			bl_header_line_10				[101],
			bl_body_line_01					[101],
			bl_body_line_02					[101],
			bl_body_line_03					[101],
			bl_body_line_04					[101],
			bl_body_line_05					[101],
			bl_body_line_06					[101],
			bl_body_line_07					[101],
			bl_body_line_08					[101],
			bl_body_line_09					[101],
			bl_body_line_10					[101],
			bl_body_line_11					[101],
			bl_body_line_12					[101],
			bl_body_line_13					[101],
			bl_body_line_14					[101],
			bl_body_line_15					[101],
			bl_body_line_16					[101],
			bl_body_line_17					[101],
			bl_body_line_18					[101],
			bl_body_line_19					[101],
			bl_body_line_20					[101],
			bl_footer_line_01				[101],
			bl_footer_line_02				[101],
			bl_footer_line_03				[101],
			bl_footer_line_04				[101],
			bl_footer_line_05				[101],
			bl_footer_line_06				[101],
			bl_footer_line_07				[101],
			bl_footer_line_08				[101],
			bl_footer_line_09				[101],
			bl_footer_line_10				[101],
			bl_copy_text				    [101],
			bl_original_text				[101],
			nd_doc_type_code				[17],
			nd_doc_type_code_ccc				[17],
			nd_patient_id					[21],
			nd_reminder_no					[4],
			column_var						[101],
			nd_patient_id_loc_desc			[200],
			nd_column_val					[1000],
			str_var							[101],
			str_var2						[101],
			line_var						[101],
			dup_var							[101],
			lc_str_val						[101],
			lc_str_var						[101],
			tab_name						[31],
			ls_str_var						[101],
			lc_var							[3],
			ls_char_var						[3],
			ls_str							[101],
			ls_var							[101],
			lc_splch_var					[101]; */ 
struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd1;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[20]; } nd_report;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[100]; } nd_REGION_CODE;

struct { unsigned short len; unsigned char arr[100]; } nd_RES_AREA_CODE;

struct { unsigned short len; unsigned char arr[100]; } nd_RES_TOWN_CODE;

struct { unsigned short len; unsigned char arr[4]; } nd_CASH_SLMT_FLAG;

struct { unsigned short len; unsigned char arr[21]; } nd_reminder_format_id;

struct { unsigned short len; unsigned char arr[21]; } bl_reminder_format_id;

struct { unsigned short len; unsigned char arr[101]; } bl_report_title_text;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_01;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_02;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_03;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_04;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_05;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_06;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_07;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_08;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_09;

struct { unsigned short len; unsigned char arr[101]; } bl_header_line_10;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_01;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_02;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_03;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_04;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_05;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_06;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_07;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_08;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_09;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_10;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_11;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_12;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_13;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_14;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_15;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_16;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_17;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_18;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_19;

struct { unsigned short len; unsigned char arr[101]; } bl_body_line_20;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_01;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_02;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_03;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_04;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_05;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_06;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_07;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_08;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_09;

struct { unsigned short len; unsigned char arr[101]; } bl_footer_line_10;

struct { unsigned short len; unsigned char arr[101]; } bl_copy_text;

struct { unsigned short len; unsigned char arr[101]; } bl_original_text;

struct { unsigned short len; unsigned char arr[17]; } nd_doc_type_code;

struct { unsigned short len; unsigned char arr[17]; } nd_doc_type_code_ccc;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[4]; } nd_reminder_no;

struct { unsigned short len; unsigned char arr[101]; } column_var;

struct { unsigned short len; unsigned char arr[200]; } nd_patient_id_loc_desc;

struct { unsigned short len; unsigned char arr[1000]; } nd_column_val;

struct { unsigned short len; unsigned char arr[101]; } str_var;

struct { unsigned short len; unsigned char arr[101]; } str_var2;

struct { unsigned short len; unsigned char arr[101]; } line_var;

struct { unsigned short len; unsigned char arr[101]; } dup_var;

struct { unsigned short len; unsigned char arr[101]; } lc_str_val;

struct { unsigned short len; unsigned char arr[101]; } lc_str_var;

struct { unsigned short len; unsigned char arr[31]; } tab_name;

struct { unsigned short len; unsigned char arr[101]; } ls_str_var;

struct { unsigned short len; unsigned char arr[3]; } lc_var;

struct { unsigned short len; unsigned char arr[3]; } ls_char_var;

struct { unsigned short len; unsigned char arr[101]; } ls_str;

struct { unsigned short len; unsigned char arr[101]; } ls_var;

struct { unsigned short len; unsigned char arr[101]; } lc_splch_var;

		 

	char	sql_stmt             [5000]; 			
 /* varchar    sql_stmt1            [1000],
			sql_stmt2            [1000]; */ 
struct { unsigned short len; unsigned char arr[1000]; } sql_stmt1;

struct { unsigned short len; unsigned char arr[1000]; } sql_stmt2;


	char   string_arr	[1000], 
		   new_str		[1001];	
char st_var[50]; 

int date_yn = 0,line_ctr = 0;
int splch_pos,st_pos,spchar_type,bold_st = 0,font_st = 0,uline_st=1;
int spchar_pos = 0,spchar_pos1,ctr;
int i,bl_doc_srl_no,pos_var,pos_var1,pos_var2,print_upto,pos_length,var_length;
int l_pos,lv_var,j,len_lc_str_val,prt_len,print_upto_c,ld_var,char_pos;
int ld_pos,ld_length,len=0;

char nd_order_by;
char filename[150];
char x_msg[200];
char loc_legend[999][201];
char fm_date[11],to_date[11];

/********UPTO HERE**********/

        
				   
char	nd_print_flag,
		nd_lang_ind,			
		nd_printed_yn,
		v_c_billed_serv, 
		d_summary_yn,
		d_err_code[30];
char	l_sql_stmt[3000];
char    l_temp_line1[300];
char    l_temp_line2[300];
char	l_mesg[1000];
char	msg_str_var[1000];

char l_filename[300][300];

int		no_of_lines,end_of_report,no_of_char=0;
int     l_bill_print_opt_for_disc_print,
		cnt				= 0;
		int	l_page_no	= 0,
		l_bill_page_no  = 0,
		page_no			= 1,
		l_main_hdr		= 1,
		three_tier		= 0;



int		nd_no_of_decimal, 
		dep_cnt			= 0, 
		rec_cnt			= 0,
		line_no			= 0,
		nd_dep_status	= 0, 
		l_tier_arch, 
		l_no_of_page	= 0,
		l_dmp			= 0, 
		l_lsr			= 0,
		l_margin_len	= 30,
		print_deposit_header_flag=0;

int		string_var[10],
		l_dtl_receipt_cnt=0,
		l_depos_cnt=0,
		l_receipt_cnt=0,
		l_invoice_cnt=0,
		l_receipt_type=0,
		flag=0,end_of_subsidy=0;

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




long	d_age;
char	d_summary_yn,
		nd_lang_ind, 
		nd_online_print_yn,
		l_print_option;
long	rcheck			= 0,
		last_line_check = 0,
		d_service_qty,
		d_base_rate,
		d_base_qty;
char    ar_cust_amt[45][30];	 
char    ar_amt[30][30],amt[30],temp[200]; 

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

FILE *fp;

int    lctr = 0,pctr = 1,nvalid = 0,ncancel = 0;
int    first = 1;

char filename[150];
char dep_filename[150];

char l_epi_barcode[50],
     l_rec_barcode[50];


char put_string(ls_var,ld_pos,ld_length)
char ls_var[101];
int ld_pos,ld_length;
{
 ls_str_var.arr[0] = '\0';
 ls_str_var.len = 0;

 strcpy(ls_str_var.arr,ls_var);
 ls_str_var.len = strlen(ls_str_var.arr);

 /* EXEC SQL select substr(:ls_str_var,:ld_pos,:ld_length)
	         into :ls_str
			 from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select substr(:b0,:b1,:b2) into :b3  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ls_str_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ld_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ld_length;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&ls_str;
 sqlstm.sqhstl[3] = (unsigned int  )103;
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



 ls_str.arr[ls_str.len] = '\0';

 if (OERROR)
        err_mesg("SELECT failed on table DUAL",0,"");

 return(ls_str.arr);
 
}


void proc_main(argc,argv)
char *argv[];
int argc;
{
    char lv_msg[1024];
	
  
   if (argc < 6) 
   {
		disp_message(ERR_MESG,"BLRDISCL : Usage Error - Check Command Line Parameter\n");
        proc_exit();
   } 
    
   if (argc >= 10)
   {
       
		strcpy(nd_reportid.arr,argv[9]);
		nd_reportid.len = strlen(nd_reportid.arr);
		
   }
 
      
   if (argc < 8)
   {
	
		strcpy(nd_reportid.arr,"BLRDISCL");
		nd_reportid.len = strlen(nd_reportid.arr);
   }
  
   
        strcpy(uid_pwd.arr,argv[1]);
        uid_pwd.len = strlen(uid_pwd.arr);
		strcpy(g_session_id,argv[2]);
		strcpy(nd_session_id.arr,argv[2]);
		nd_session_id.len = strlen(nd_session_id.arr);
		strcpy(g_pgm_id,"BLRDISCL");


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
	strcpy(g_pgm_date,argv[3]);
	strcpy(nd_pgm_date.arr,argv[3]);
	nd_pgm_date.len = strlen(nd_pgm_date.arr);
	
	get_param();

	strcpy(nd_facility_id.arr,argv[8]);
	nd_facility_id.len  = strlen(nd_facility_id.arr);
	strcpy(g_facility_id,nd_facility_id.arr);
	nd_facility_name.arr[0] = '\0';
	nd_facility_name.len	 = 0;

	strcpy(d_doc_type_code.arr, argv[5]);
	strcpy(d_doc_number.arr, argv[6]);
    d_doc_type_code.len = strlen(d_doc_type_code.arr);
	d_doc_number.len    = strlen(d_doc_number.arr);


      get_print_type();


	 l_logo_yniflaser.arr[0] = 'N';
	 //get_logo_dtl(); 
	 //sprintf(l_mesg,"Dotmatrix : %d; Laser: %d",l_dmp,l_lsr);
	 get_left_margin();	
  	open_files();	

/*-----------------*/

	d_added_by_id.arr[0]		 ='\0';
	d_doc_type_code1.arr[0]		 ='\0';
	d_doc_number1.arr[0]	     ='\0';
    d2_doc_date.arr[0]			 ='\0';
	d1_patient_id.arr[0]         ='\0';
	d2_episode_type.arr[0]		 ='\0';
	d2_episode_id.arr[0]		 ='\0';
	d_ward_code.arr[0]			 ='\0';
	d_bed_num.arr[0]			 ='\0';
	d_room_num.arr[0]			 ='\0';
	d_auth_by_id.arr[0]			 ='\0';
	d_bed_class_code.arr[0]		 ='\0';
	d_auth_remarks.arr[0]			 ='\0';
	d_print_copy_num.arr[0]			 ='\0';
	
	      	
	d_added_by_id.len		  =0;
	d_doc_type_code1.len	  =0;
	d_doc_number1.len		  =0;
	d2_doc_date.len			  =0;
	d1_patient_id.len         =0;
	d2_episode_type.len		  =0;
	d2_episode_id.len		  =0;
	d_ward_code.len			  =0;
	d_bed_num.len			  =0;
	d_room_num.len			  =0;
	d_auth_by_id.len		  =0;
	d_bed_class_code.len	  =0;
	d_auth_remarks.len	      =0; 
	d_print_copy_num.len      =0; 


		/* EXEC SQL 
			SELECT DOC_TYPE_CODE,DOC_NUM, DOC_DATE,
			EPISODE_TYPE, PATIENT_ID, EPISODE_ID, WARD_CODE, 
			BED_CLASS_CODE, ROOM_NUM, BED_NUM, AUTH_BY_ID, AUTH_REMARKS, 
			ADDED_BY_ID,REPRINT_COPY_NUM
			into 
			:d_doc_type_code1,
			:d_doc_number1,
			:d2_doc_date,
			:d2_episode_type,
			:d1_patient_id,
			:d2_episode_id,
			:d_ward_code,
			:d_bed_class_code,
			:d_room_num,
			:d_bed_num,
			:d_auth_by_id,
			:d_auth_remarks,
			:d_added_by_id,
			:d_print_copy_num
			FROM  BL_ENC_DISCHARGE_CLEARANCE
			WHERE 
			operating_facility_id=:nd_facility_id
			AND DOC_TYPE_CODE = :d_doc_type_code
			and DOC_NUM =   :d_doc_number; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DOC_TYPE_CODE ,DOC_NUM ,DOC_DATE ,EPISODE_TYPE ,PATI\
ENT_ID ,EPISODE_ID ,WARD_CODE ,BED_CLASS_CODE ,ROOM_NUM ,BED_NUM ,AUTH_BY_ID ,\
AUTH_REMARKS ,ADDED_BY_ID ,REPRINT_COPY_NUM into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:\
b7,:b8,:b9,:b10,:b11,:b12,:b13  from BL_ENC_DISCHARGE_CLEARANCE where ((operat\
ing_facility_id=:b14 and DOC_TYPE_CODE=:b15) and DOC_NUM=:b16)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )36;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code1;
  sqlstm.sqhstl[0] = (unsigned int  )12;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_doc_number1;
  sqlstm.sqhstl[1] = (unsigned int  )12;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d2_doc_date;
  sqlstm.sqhstl[2] = (unsigned int  )37;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d2_episode_type;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d1_patient_id;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d2_episode_id;
  sqlstm.sqhstl[5] = (unsigned int  )11;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_ward_code;
  sqlstm.sqhstl[6] = (unsigned int  )12;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_bed_class_code;
  sqlstm.sqhstl[7] = (unsigned int  )12;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_room_num;
  sqlstm.sqhstl[8] = (unsigned int  )13;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_bed_num;
  sqlstm.sqhstl[9] = (unsigned int  )12;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_auth_by_id;
  sqlstm.sqhstl[10] = (unsigned int  )33;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_auth_remarks;
  sqlstm.sqhstl[11] = (unsigned int  )204;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_added_by_id;
  sqlstm.sqhstl[12] = (unsigned int  )52;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_print_copy_num;
  sqlstm.sqhstl[13] = (unsigned int  )12;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[14] = (unsigned int  )5;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&d_doc_type_code;
  sqlstm.sqhstl[15] = (unsigned int  )9;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&d_doc_number;
  sqlstm.sqhstl[16] = (unsigned int  )11;
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


			

	if(OERROR)
	{ 

		err_mesg("FETCH FAILED IN discharge_clearance_cur",0,"");
		proc_exit();
	}

	d_auth_by_id.arr[d_auth_by_id.len]	='\0';
	d_added_by_id.arr[d_added_by_id.len]					='\0';
	d_auth_remarks.arr[d_auth_remarks.len]		='\0';
	d_doc_type_code1.arr[d_doc_type_code1.len]				='\0';
    d_doc_number1.arr[d_doc_number1.len]					='\0';
	d2_doc_date.arr[d2_doc_date.len]						='\0';
	d1_patient_id.arr[d1_patient_id.len]					='\0';	
	d_ward_code.arr[d_ward_code.len]	='\0';
	d_bed_num.arr[d_bed_num.len]			='\0';
	d2_episode_type.arr[d2_episode_type.len]				='\0';
	d2_episode_id.arr[d2_episode_id.len]					='\0';
	d_room_num.arr[d_room_num.len]						='\0';
	d_bed_class_code.arr[d_bed_class_code.len]				='\0';
	d_auth_remarks.arr[d_auth_remarks.len]							='\0';
	d_print_copy_num.arr[d_print_copy_num.len]							='\0';



/*-----------------*/
	print_body(); 
	fflush(fp);

	
if (l_online_print_yn.arr[0] == 'Y')
	{
		if (l_logo_yniflaser.arr[0] != 'Y')
		{
		
		int l=0;
									
				for(l=1;l<=filecount;l++)  //11793
				 {	
							
				
			 	PrintDocument(uid_pwd.arr,				//char	*PUidPwd;
							nd_session_id.arr,	        //char	*PSessionID;
							nd_facility_id.arr,		    //char	*PFacilityID;
							"BL",						//char	*PModuleID;
							nd_reportid.arr,		    //char	*PDocumentID;
							l_filename[l],
							//filename,					//char	*POnlinePrintFileNames;  //11793
							"O",						//char	*PLocationTypes;         //11793
							" ",						//char	*PLocationCodes;
							1,							//int		PNumOfCopies;
							1,							//int		PPageFrom;
							9999);						//int		PPageTo;);
			}		       

					
		}



	/* EXEC SQL UPDATE BL_ENC_DISCHARGE_CLEARANCE SET
		REPRINT_COPY_NUM=REPRINT_COPY_NUM+1
		WHERE operating_facility_id=:nd_facility_id
		AND DOC_TYPE_CODE = :d_doc_type_code
		AND DOC_NUM =   :d_doc_number; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "update BL_ENC_DISCHARGE_CLEARANCE  set REPRINT_COPY_NUM=(REP\
RINT_COPY_NUM+1) where ((operating_facility_id=:b0 and DOC_TYPE_CODE=:b1) and \
DOC_NUM=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )119;
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
 sqlstm.sqhstv[1] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )9;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_doc_number;
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


		
	/* EXEC SQL COMMIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )146;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 

	if(OERROR)
	{ 

		err_mesg("UPDATE FAILED IN BL_ENC_DISCHARGE_CLEARANCE",0,"");
		proc_exit();
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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare l_print_status BOOLEAN ; BEGIN APPPRINT . SUBMIT_OR\
ACLE_REPORT ( :nd_ws_no , :nd_facility_id , 'BL' , :nd_logo_pgm_id , 'P' , '' \
, '' , 'O' , ' ' , NULL , NULL , NULL , NULL , NULL , 'P_FILE_NAME=' || :nd_fi\
le_name || '+' || 'P_LOGO_NAME=' || :l_logo_name , l_print_status , :l_errorte\
xt ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )161;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin BLOPIN . GET_PRINT_SETUP_COL_VALUE ( :nd_facility_id \
, 'BLRVSBL1' , 'PRINT_LOGO_YN_IF_LASER' , :l_logo_yniflaser , :l_errorlevel , \
:l_sysmessageid , :l_errortext ) ; :l_logo_yniflaser := nvl ( :l_logo_yniflase\
r , 'N' ) ; if :l_sysmessageid is not null then :l_errorlevel := '10' ; :l_err\
ortext := blcommon . get_error_text ( :l_sysmessageid ) ; end if ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )200;
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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin BLOPIN . GET_PRINT_SETUP_COL_VALUE ( :nd_facility_id\
 , 'BLRBILLO' , 'LOGO_NAME' , :l_logo_name , :l_errorlevel , :l_sysmessageid ,\
 :l_errortext ) ; if :l_sysmessageid is not null then :l_errorlevel := '10' ; \
:l_errortext := blcommon . get_error_text ( :l_sysmessageid ) ; end if ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )235;
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
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin WORKSTATION . GET_WS_PARAM ( :nd_ws_no , 'BLLOGODIR\
' , :LOGO_DIR , :l_errortext ) ; if :l_errortext is not null then :l_errortext\
 := 'BLLOGODIR:' || :l_errortext ; end if ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )270;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
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


prt_line_uc_wide()
{
  int i;
  {
     for (i=0;i<105;i++)
     {
	   fprintf(fp,"_");		     
     }
  } 	      
}

prt_line_uc_wide1()
{
  int i;
  {
     for (i=0;i<120;i++)
     {
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

prt_line_uc1()
{
  int i;
  {
     for (i=0;i<96;i++)
     {
	fprintf(fp,"_");		     
     }
  } 	      
}

last_line_prt()
{	
	fprintf(fp,"\n");
	last_line_check = 0;
	rec_out = 'Y';
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

	//fprintf(fp,"%-80.80s %s %d\n"," ",loc_legend21.arr,l_bill_page_no);
	//fprintf(fp,"%80.80s %d\n",loc_legend21.arr,l_bill_page_no);

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
	print_discharge_Clearance();
	//print_report_header();

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




















/* Added by Raghava.S for Thai date conversion on 06/07/2007 */

get_local_date()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	//t_date  date;--Leap Year Changes for SCF 9462
	t_date  varchar2(20);
	BEGIN
		--Leap Year Changes for SCF 9462
		/oget_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YY'),:nd_lang_id,t_date);

		 
		 :nd_loc_date:= to_char(t_date,'DD Mon.YYYY');o/
   get_locale_date_2t.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YY'),:nd_lang_id,t_date,'DD Mon.YYYY');
   :nd_loc_date:= t_date;


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date varchar2 ( 20 ) ; BEGIN get_locale_date_2t . \
convert_to_locale_date ( to_date ( :nd_temp_date , 'DD/MM/YY' ) , :nd_lang_id \
, t_date , 'DD Mon.YYYY' ) ; :nd_loc_date := t_date ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )297;
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
 sqlstm.sqhstl[1] = (unsigned int  )5;
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

//:nd_loc_date:= to_char(t_date,'DD/MM/YYYY');
}

get_local_date1()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	//t_date  date;--Leap Year Changes for SCF 9462
	t_date  varchar2(20);
	BEGIN
		--Leap Year Changes for SCF 9462
		/oget_locale_date.convert_to_locale_date(to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:nd_lang_id,t_date);

		 :nd_loc_date1:= to_char(t_date,'DD/MM/YYYY HH24:MI');o/

		 get_locale_date_2t.convert_to_locale_date(to_date(:nd_temp_date1,'DD/MM/YYYY HH24:MI'),:nd_lang_id,t_date,'DD/MM/YYYY HH24:MI');
     	 :nd_loc_date1:= t_date;


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date varchar2 ( 20 ) ; BEGIN get_locale_date_2t . \
convert_to_locale_date ( to_date ( :nd_temp_date1 , 'DD/MM/YYYY HH24:MI' ) , :\
nd_lang_id , t_date , 'DD/MM/YYYY HH24:MI' ) ; :nd_loc_date1 := t_date ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )324;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqhstl[1] = (unsigned int  )5;
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


}

get_local_date3()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	//t_date  date;--Leap Year Changes for SCF 9462
	t_date  varchar2(20);
	BEGIN
		--Leap Year Changes for SCF 9462
		/oget_locale_date.convert_to_locale_date(to_date(:nd_temp_date1,'DD/MM/YYYY HH12:MI AM'),:nd_lang_id,t_date);

		 :nd_loc_date1:= to_char(t_date,'DD/MM/YYYY HH12:MI AM');o/
		get_locale_date_2t.convert_to_locale_date(to_date(:nd_temp_date1,'DD/MM/YYYY HH12:MI AM'),:nd_lang_id,t_date,'DD/MM/YYYY HH12:MI AM');
		:nd_loc_date1:= t_date;		 


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date varchar2 ( 20 ) ; BEGIN get_locale_date_2t . \
convert_to_locale_date ( to_date ( :nd_temp_date1 , 'DD/MM/YYYY HH12:MI AM' ) \
, :nd_lang_id , t_date , 'DD/MM/YYYY HH12:MI AM' ) ; :nd_loc_date1 := t_date ;\
 END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )351;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqhstl[1] = (unsigned int  )5;
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


}

get_local_date4()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	//t_date  date;--Leap Year Changes for SCF 9462
	t_date  varchar2(20);
	
	BEGIN
		--Leap Year Changes for SCF 9462
		/oget_locale_date.convert_to_locale_date(to_date(:nd_temp_date1,'dd/mm/yyyy HH24:MI:SS'),:nd_lang_id,t_date);

		 :nd_loc_date1:= to_char(t_date,'dd/mm/yyyy HH24:MI:SS');o/
		 
		get_locale_date_2t.convert_to_locale_date(to_date(:nd_temp_date1,'dd/mm/yyyy HH24:MI:SS'),:nd_lang_id,t_date,'dd/mm/yyyy HH24:MI:SS');
		 :nd_loc_date1:= t_date;

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date varchar2 ( 20 ) ; BEGIN get_locale_date_2t . \
convert_to_locale_date ( to_date ( :nd_temp_date1 , 'dd/mm/yyyy HH24:MI:SS' ) \
, :nd_lang_id , t_date , 'dd/mm/yyyy HH24:MI:SS' ) ; :nd_loc_date1 := t_date ;\
 END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )378;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqhstl[1] = (unsigned int  )5;
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


}

get_local_date2()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	//t_date  date;
	t_date  varchar2(20);--Leap Year Changes for SCF 9462
	
	BEGIN
		--Leap Year Changes for SCF 9462
		/oget_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YY'),:nd_lang_id,t_date);

		 :nd_loc_date:= to_char(t_date,'DD/MM/YYYY');o/
		get_locale_date_2t.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YY'),:nd_lang_id,t_date,'DD/MM/YYYY');
     	 :nd_loc_date:= t_date;		 


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date varchar2 ( 20 ) ; BEGIN get_locale_date_2t . \
convert_to_locale_date ( to_date ( :nd_temp_date , 'DD/MM/YY' ) , :nd_lang_id \
, t_date , 'DD/MM/YYYY' ) ; :nd_loc_date := t_date ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )405;
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
 sqlstm.sqhstl[1] = (unsigned int  )5;
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

/*---06/07/2007----*/

init_date_temp_var()
{
nd_temp_date.arr[0] =  '\0';
nd_temp_date1.arr[0]=  '\0';
nd_loc_date1.arr[0] =  '\0';
nd_loc_date.arr[0]  =  '\0';
date_convert.arr[0] =  '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
date_convert.len = 0;
nd_temp_date1.len= 0;
nd_loc_date1.len  =0;

}

/*---06/07/2007----*/

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

fun_change_loc_date3()
{

strcpy(nd_temp_date1.arr,date_convert.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);

get_local_date3();
nd_loc_date1.arr[nd_loc_date1.len]='\0';

}

fun_change_loc_date4()
{

strcpy(nd_temp_date1.arr,date_convert.arr);
nd_temp_date1.len = strlen(nd_temp_date1.arr);

get_local_date4();
nd_loc_date1.arr[nd_loc_date1.len]='\0';

}


fun_change_loc_date2()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date2();
nd_loc_date.arr[nd_loc_date.len]='\0';

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

get_left_margin_rec()
{

	if (l_lsr != 0 && l_dmp == 0)
	  {
		if (l_logo_yniflaser.arr[0] == 'Y')			    
			l_margin_len = 40;				
		else
			l_margin_len = 55;

	  }
}

get_param()
{
	

	d_doc_type_code.arr[0]    = '\0';
	l_to_doc_type_code.arr[0] = '\0';
	d_doc_number.arr[0]       = '\0'; 
	l_to_doc_type_num.arr[0]  = '\0';
	l_online_print_yn.arr[0] = '\0';
	l_episode_type.arr[0] = '\0';

	nd_logo_pgm_id.arr[0]	= '\0';
	nd_logo_pgm_id.len	= 0;

	nd_reprint_yn.arr[0] = '\0';
	nd_reprint_yn.len = 0;

	curr_date.arr[0] = '\0';
	curr_date.len = 0;

	/* EXEC SQL SELECT param1, 
					param2, 
					param28,
					to_char(sysdate,'DD/MM/YYYY HH24:MI:SS')
			   INTO	:d_doc_type_code,
					:d_doc_number ,
					:nd_logo_pgm_id,
					:curr_date
			   FROM sy_prog_param
			  WHERE pgm_id     = 'BLRDISCL'
	           AND PGM_DATE   = :nd_pgm_date 
	            AND SESSION_ID = :nd_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select param1 ,param2 ,param28 ,to_char(sysdate,'DD/MM/YYYY \
HH24:MI:SS') into :b0,:b1,:b2,:b3  from sy_prog_param where ((pgm_id='BLRDISCL\
' and PGM_DATE=:b4) and SESSION_ID=:b5)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )432;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_number;
 sqlstm.sqhstl[1] = (unsigned int  )11;
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
 sqlstm.sqhstv[3] = (         void  *)&curr_date;
 sqlstm.sqhstl[3] = (unsigned int  )22;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[4] = (unsigned int  )37;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




		strcpy(l_online_print_yn.arr,"Y");
		l_online_print_yn.len = strlen(l_online_print_yn.arr);

	if(OERROR)
		err_mesg("SELECT failed on SY_PROG_PARAM",0,"");

	d_doc_type_code.arr[d_doc_type_code.len]		= '\0';
	l_to_doc_type_code.arr[l_to_doc_type_code.len]	= '\0';
	d_doc_number.arr[d_doc_number.len]				= '\0'; 
	l_to_doc_type_num.arr[l_to_doc_type_num.len]	= '\0';
	l_online_print_yn.arr[l_online_print_yn.len]	= '\0';
    l_episode_type.arr[l_episode_type.len]			='\0';
	nd_reprint_yn.arr[nd_reprint_yn.len]			= '\0';
	nd_logo_pgm_id.arr[nd_logo_pgm_id.len]			= '\0';
	curr_date.arr[curr_date.len]					= '\0';


	/* EXEC SQL DELETE 
	           FROM sy_prog_param
			  WHERE pgm_id     = 'BLRDISCL'
	            AND PGM_DATE   = :nd_pgm_date
	            AND SESSION_ID = :nd_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from sy_prog_param  where ((pgm_id='BLRDISCL' and PG\
M_DATE=:b0) and SESSION_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )471;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[0] = (unsigned int  )37;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
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


print_discharge_Clearance()
{
   char out_str[10][133];
   char s_amt[20];
   int  length_str[10];
   int  l_no_of_deposit=0;
   int  i = 0,no_of_lines = 0;
   char epi_visit[14];
  

   line_no = 0;


   //Added by MRAMESH. Date : 31-dec-1997
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
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select base_currency ,base_currency_dec into :b0,:b1  from\
 sy_acc_entity_lang_vw where (acc_entity_id=:b2 and language_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )494;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
		//line_no = line_no + 1;
	  }
    }
    else
    {
	if(l_no_of_page > 1)
	{
		fprintf(fp,"\n");
		//line_no = line_no + 1;
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
	      //fprintf(fp,"%-s",loc_legend20.arr); 
		      	      
	     
	   if ( l_logo_yniflaser.arr[0] != 'Y')
	   {
	      fprintf(fp,"%c(s14H",ESC); /* To set the font size	  */
	      //fprintf(fp,"%c&d@",ESC); 	 /* release underline mode    */
	   }

	     /* len1 = 19 - loc_legend20.len;

	     if (len1 > 0)
	     {
	         for (i=0;i<len1;i++)
		 {
		     fprintf(fp,"%-s"," ");		     
		 }
	      }	      
		*/

		fprintf(fp,"\n");

		
		if (l_lsr!= 0 && l_dmp== 0)
		{
	   if ( l_logo_yniflaser.arr[0] != 'Y')
		{
			fprintf(fp,"%c(s8H",ESC);	
			fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 	  */	      
		}
		}

		//prt_space_hdr();
		//fprintf(fp,"%-50.50s\n",loc_legend24.arr);
		//prt_space_hdr();
		//fprintf(fp,"%-50.50s\n",loc_legend22.arr);
		fprintf(fp,"\n");
		/*prt_space_hdr();
		fprintf(fp,"%-50.50s",nd_hosp_name1.arr);

		line_no = line_no + 1;*/



	    //if ( l_logo_yniflaser.arr[0] != 'Y')
		//	fprintf(fp,"%c(s12H",ESC);	

	}
	

  //print_report_header();

}
  
open_files()
{
   
   if (LOGO_DIR.arr[0] != '\0') 
	strcpy(filename,LOGO_DIR.arr);
   else 
	strcpy(filename,WORKING_DIR);
   
	

	l_receipt_cnt=l_receipt_cnt+1;
	strcat(filename,"BLRDISCL.lis");
	flag=l_receipt_cnt;



   strcpy(OUTPUT_FILE_NAME,filename );

  
   if(flag>1)
   {
     
	 if ((fp = fopen(filename,"a")) == NULL)
	   {
			err_mesg("Error while opening output file",0,"");
			proc_exit();
	   }

   }
   else
   {
	   if ((fp = fopen(filename,"w")) == NULL)
	   {
			
			err_mesg("Error while opening output file",0,"");
			proc_exit();
	   }
   }
   
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
			:nd_preprint_flag:='Y';
				
		elsif l_format_type in('LASER_WITH_LOGO','LASER_WITHOUT_LOGO') then
		    
			:l_dmp := 0;
			:l_lsr := 1;
			:nd_preprint_flag:='N';
			
		else
			
			:l_dmp := 0;
			:l_lsr := 0;
			:nd_preprint_flag:='N';
			
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
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
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
MP_PREPRINTED' then :l_dmp := 1 ; :l_lsr := 0 ; :nd_preprint_flag := 'Y' ; e\
lsif l_format_type in ( 'LASER_WITH_LOGO' , 'LASER_WITHOUT_LOGO' ) then :l_d\
mp := 0 ; :l_lsr := 1 ; :nd_preprint_flag := 'N' ; else :l_dmp := 0 ; :l_lsr\
 := 0 ; :nd_preprint_flag := 'N' ; end if ; if :l_dmp = 0 and :l_lsr = 0 the\
n APPPRINT . GET_ROUTING_PRINTERS ( :nd_");
 sqlstm.stmt = "ws_no , :nd_facility_id , 'BL' , :nd_reportid , 'O' , ' ' , \
:l_printer_ids , :l_printer_names , :l_printer_types , :l_queue_names , :l_no_\
of_copies , :l_errortext ) ; :l_dmp := NVL ( instr ( :l_printer_types , 'D' ) \
, 0 ) ; :l_lsr := NVL ( instr ( :l_printer_types , 'S' ) , 0 ) ; if :l_dmp != \
0 and :l_lsr != 0 then :l_dmp := 0 ; end if ; if :l_dmp = 0 and :l_lsr = 0 the\
n :l_lsr := 1 ; end if ; end if ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )525;
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
 sqlstm.sqhstv[4] = (         void  *)&nd_preprint_flag;
 sqlstm.sqhstl[4] = (unsigned int  )5;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[5] = (unsigned int  )52;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_printer_ids;
 sqlstm.sqhstl[6] = (unsigned int  )1002;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_printer_names;
 sqlstm.sqhstl[7] = (unsigned int  )1002;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_printer_types;
 sqlstm.sqhstl[8] = (unsigned int  )1002;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_queue_names;
 sqlstm.sqhstl[9] = (unsigned int  )1002;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_no_of_copies;
 sqlstm.sqhstl[10] = (unsigned int  )1002;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&l_errortext;
 sqlstm.sqhstl[11] = (unsigned int  )1002;
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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )588;
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

print_bold_underline()
{
	fprintf(fp,"%c(s12H",ESC);	/*SIZE*/
	fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style  */
	fprintf(fp,"%c&d0D",ESC);   /* set Underline mode */
}
Release_bold_underline()
{
	fprintf(fp,"%c(s14H",ESC); 
	fprintf(fp,"%c&d@",ESC); 
	fprintf(fp,"%c(s-3B",ESC);
}

print_underline()
{
	fprintf(fp,"%c&d0D",ESC);   /* set Underline mode */
}
Release_underline()
{
	
	fprintf(fp,"%c&d@",ESC); 
	
}

print_bold()
{

	fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style  */
	
}
Release_bold()
{
	fprintf(fp,"%c(s-3B",ESC);
}

/*get_Receipt_Format()
{
	EXEC SQL select RECEIPT_FORMAT_IND,SLMT_MODE_WISE_RCPT_YN
				 into :nd_receipt_format_id,:nd_slmt_mode_yn
				from bl_parameters
				where operating_facility_id=:nd_facility_id;

}*/

declare_cur()
{  

    /* EXEC SQL DECLARE BL_clearance_FORMAT_CUR CURSOR FOR 
		SELECT	
				PARAM1,
				PARAM2,
				PARAM3,
				PARAM4,
				'Y'
				FROM SY_PROG_PARAM
				WHERE   PGM_ID   = 'BLRDISCL' AND
						 SESSION_ID = :nd_session_id
						AND PGM_DATE  = :nd_pgm_date; */ 


		if (OERROR)
			err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");
  
}

open_cur() 
{

	/* EXEC SQL OPEN BL_clearance_FORMAT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0019;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )619;
 sqlstm.selerr = (unsigned short)1;
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
         err_mesg("OPEN failed on cursor BL_clearance_FORMAT_CUR",0,"");
}


close_cur() 
{
    /* EXEC SQL DELETE SY_PROG_PARAM
					    WHERE 
						PGM_ID   = 'BLRRPREC'	AND
						 SESSION_ID = :nd_session_id
						AND PGM_DATE  = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRRPREC' and\
 SESSION_ID=:b0) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )642;
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
   

	/* EXEC SQL CLOSE BL_clearance_FORMAT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )665;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
}

print_body()
{


bold_st = 0;
font_st = 0;
uline_st= 1;
    fetch_dtl();
	print_head();
    /*----------------------*/

   	if (bl_body_line_01.arr[0] != '\0')
      {
		print_line(bl_body_line_01.arr);
		
		fprintf(fp,"\n");
		line_ctr++;

		check_page_end(1,0);
       }

	if (bl_body_line_02.arr[0] != '\0')
      {

		print_line(bl_body_line_02.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_03.arr[0] != '\0')
      {
		print_line(bl_body_line_03.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_04.arr[0] != '\0')
      {
		print_line(bl_body_line_04.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_05.arr[0] != '\0')
      {
		print_line(bl_body_line_05.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_body_line_06.arr[0] != '\0')
      {
		print_line(bl_body_line_06.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	
	if (bl_footer_line_01.arr[0] != '\0')
      {
		print_line(bl_footer_line_01.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_02.arr[0] != '\0')
      {
		print_line(bl_footer_line_02.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_03.arr[0] != '\0')
      {
		print_line(bl_footer_line_03.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_04.arr[0] != '\0')
      {
		print_line(bl_footer_line_04.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_05.arr[0] != '\0')
      {
		print_line(bl_footer_line_05.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }
	if (bl_footer_line_06.arr[0] != '\0')
      {
		print_line(bl_footer_line_06.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
		check_page_end(1,0);
       }

   fprintf(fp,"\f");
   pctr = 1;
   line_ctr = 2;
   
 
}     /* end of procedure   */


print_line(line_var) varchar line_var[101];

{
	dup_var.arr[0] = '\0';
	dup_var.len = 0;
    pos_var  = 0;
	pos_var1 = 0;
	pos_var2 = 0;
	print_upto = 0;
	lv_var  = 1;
	i = 0;
	
	strcpy(dup_var.arr,line_var);
	dup_var.len = strlen(dup_var.arr);
	var_length = strlen(dup_var.arr);
	pos_var = char_position(dup_var.arr,"+",1);
    sprintf(st_var,"%d",var_length);
    
    nd_column_val.arr[0] = '\0';
	nd_column_val.len = 0;
	column_var.arr[0] = '\0';
	column_var.len = 0;
	tab_name.arr[0] = '\0';
	tab_name.len = 0;

sql_stmt1.arr[0] = '\0';
sql_stmt1.len = 0;
sql_stmt2.arr[0] = '\0';
sql_stmt2.len = 0;
	while(i < var_length)
	{ 
	if (pos_var == 0)
	{
    pos_length = var_length - i + 2;

	put_string(dup_var.arr,i,pos_length);
	
	strcpy(str_var.arr,ls_str.arr);

	str_var.len= strlen(str_var.arr);
	
	check_splch(str_var.arr);
	pos_var1 = 0;
	pos_var2 = 0;
	i = var_length;
	}

	if (pos_var != 0 && pos_var1 == 0)
	{	    
	pos_var1 = pos_var;

	pos_length = pos_var1-print_upto-1;	

    put_string(dup_var.arr,print_upto+1,pos_length);
    strcpy(str_var.arr,ls_str.arr);
	str_var.len = strlen(str_var.arr);
	check_splch(str_var.arr);

    print_upto = pos_var1 - 1;
	i = pos_var1+1;
    

	pos_var2 = char_position(dup_var.arr,"+",i);

     if (pos_var2 == 0)
	 {
	  pos_length = var_length - pos_var1 + 1;
      put_string(dup_var.arr,pos_var1,pos_length);
      strcpy(str_var.arr,ls_str.arr);
	  str_var.len = strlen(str_var.arr);

	  check_splch(str_var.arr);
	  print_upto = var_length+1;
	  i = var_length+1;
     }

    }

    if (pos_var2 != 0)
	{
    nd_column_val.arr[0] = '\0';
	nd_column_val.len = 0;
	column_var.arr[0] = '\0';
	column_var.len = 0;
	tab_name.arr[0] = '\0';
	tab_name.len = 0;

sql_stmt1.arr[0] = '\0';
sql_stmt1.len = 0;
sql_stmt2.arr[0] = '\0';
sql_stmt2.len = 0;

	pos_length = pos_var2 - pos_var1 - 1;

    column_var.arr[0] = '\0';
	column_var.len = 0;
	
	 put_string(dup_var.arr,pos_var1+1,pos_length);
     strcpy(column_var.arr,ls_str.arr);
	 column_var.len = strlen(column_var.arr);
	 date_yn = chk_date_yn(column_var.arr);

	  /* EXEC SQL SELECT  decode(:date_yn,0,'select to_char(ltrim('|| LET_MAPPED_COL_NAME || ')) from '|| LET_MAPPED_TABLE_NAME ||' WHERE ',
										 'select to_char('|| LET_MAPPED_COL_NAME || ',''DD/MM/YYYY'') from '|| LET_MAPPED_TABLE_NAME ||' WHERE '),LET_MAPPED_TABLE_NAME
					into  :sql_stmt1,tab_name
                    FROM BL_RECEIPT_MAPPING_COL
                    WHERE LET_COLUMN_ID = :column_var
					AND APPL_TRX_IND = 'D'; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select decode(:b0,0,(((('select to_char(ltrim('||LET_MAPPE\
D_COL_NAME)||')) from ')||LET_MAPPED_TABLE_NAME)||' WHERE '),(((('select to_ch\
ar('||LET_MAPPED_COL_NAME)||',''DD/MM/YYYY'') from ')||LET_MAPPED_TABLE_NAME)|\
|' WHERE ')) ,LET_MAPPED_TABLE_NAME into :b1,:b2  from BL_RECEIPT_MAPPING_COL \
where (LET_COLUMN_ID=:b3 and APPL_TRX_IND='D')";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )680;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&date_yn;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&sql_stmt1;
   sqlstm.sqhstl[1] = (unsigned int  )1002;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&tab_name;
   sqlstm.sqhstl[2] = (unsigned int  )33;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&column_var;
   sqlstm.sqhstl[3] = (unsigned int  )103;
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



	len = strlen(sql_stmt1.arr);
		sql_stmt1.arr[sql_stmt1.len]  ='\0';


    tab_name.arr[tab_name.len] = '\0';

	//disp_message(ERR_MESG,tab_name.arr);
	//disp_message(ERR_MESG,column_var.arr);	

	if(strcmp(tab_name.arr,"BL_ENC_DISCHARGE_CLEARANCE") == 0 ) 
	{
    
	strcpy(sql_stmt2.arr, "DOC_TYPE_CODE = "); //:nd_facility");
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr,d_doc_type_code1.arr);
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr," and to_char(DOC_NUM) =");
	strcat(sql_stmt2.arr,d_doc_number1.arr);


	if((strcmp(column_var.arr,"CASHIER_NAME")==0))
	{
		strcat(sql_stmt2.arr," AND ROWNUM=1");
	}
      
	}

	
 
	if(strcmp(tab_name.arr,"MP_PATIENT_MAST") == 0 || strcmp(tab_name.arr,"MP_PATIENT") == 0)
	{ 
	strcpy(sql_stmt2.arr, "PATIENT_ID = "); ;
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr,nd_patient_id.arr);
	strcat(sql_stmt2.arr,"'");
   
	}
	
	if(strcmp(tab_name.arr,"MP_REGION") == 0) 
	{
	strcpy(sql_stmt2.arr, "REGION_CODE = "); 
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr,nd_REGION_CODE.arr);
	strcat(sql_stmt2.arr,"'");
    
	}
	
	if(strcmp(tab_name.arr,"SY_ACC_ENTITY") == 0) 
	{
	strcpy(sql_stmt2.arr, "ACC_ENTITY_ID = "); 
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr,nd_facility_id.arr);
	strcat(sql_stmt2.arr,"'");
    
	}
	

	if(strcmp(tab_name.arr,"MP_PAT_OTHER_DTLS") == 0) 
	{
	strcpy(sql_stmt2.arr, "PATIENT_ID = "); 
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr,nd_patient_id.arr);
	strcat(sql_stmt2.arr,"'");
    
	}


    if(strcmp(tab_name.arr,"MP_RES_AREA") == 0) 
	{
	strcpy(sql_stmt2.arr, "RES_AREA_CODE = "); 
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr,nd_RES_AREA_CODE.arr);
	strcat(sql_stmt2.arr,"'");
    
	}

	if(strcmp(tab_name.arr,"MP_RES_TOWN") == 0) 
	{
	strcpy(sql_stmt2.arr, "RES_TOWN_CODE = "); 
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr,nd_RES_TOWN_CODE.arr);
	strcat(sql_stmt2.arr,"'");
    
	}

	if(strcmp(tab_name.arr,"SM_FACILITY_PARAM") == 0) 
	{
    strcpy(sql_stmt2.arr, "FACILITY_ID = "); 
	strcat(sql_stmt2.arr,"'");
	strcat(sql_stmt2.arr,nd_facility_id.arr);
	strcat(sql_stmt2.arr,"'");
	}

	strcpy(sql_stmt,sql_stmt1.arr);

	strcat(sql_stmt,sql_stmt2.arr); 

  //disp_message(ERR_MESG,sql_stmt);


/* EXEC SQL EXECUTE
	BEGIN
	 EXECUTE IMMEDIATE :sql_stmt INTO :nd_column_val;
	END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 17;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin EXECUTE IMMEDIATE :sql_stmt INTO :nd_column_val ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )711;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)sql_stmt;
sqlstm.sqhstl[0] = (unsigned int  )5000;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_column_val;
sqlstm.sqhstl[1] = (unsigned int  )1002;
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



nd_column_val.arr[nd_column_val.len]  ='\0';

sprintf(st_var,"%d",sqlca.sqlcode);
//disp_message(ERR_MESG,st_var);


	if (OERROR)
	 {
			column_var.arr[0] = '\0';
		  column_var.len = 0;
		 pos_length = pos_var2 - pos_var1 + 1;
		  put_string(dup_var.arr,pos_var1,pos_length);
		  strcpy(column_var.arr,ls_str.arr);
		  column_var.len = strlen(column_var.arr);

            if((strcmp(st_var,"-1405")!=0))
			fprintf(fp,"%s",column_var.arr);
			else
			{
				
				if (strcmp(column_var.arr,"+BED_NUM+")==0)
				 {
					/* EXEC SQL SELECT '........' into :nd_column_val from dual; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select '........' into :b0  from dual ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )734;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_column_val;
     sqlstm.sqhstl[0] = (unsigned int  )1002;
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


						nd_column_val.arr[nd_column_val.len]='\0';
						fprintf(fp,"%s",nd_column_val.arr);
						
				 }
			
			 }



	  }  
    else  
	{
                nd_column_val.arr[nd_column_val.len] = '\0';

			if (strcmp(column_var.arr,"CASHIER_NAME")==0)
			{
				nd_cashier_name.arr[0]='\0';
				nd_cashier_name.len	  =0; 

  

			  /* EXEC SQL SELECT DISTINCT APPL_USER_NAME
			  INTO  :nd_column_val
			  FROM   SM_APPL_USER_LANG 
			  WHERE  APPL_USER_ID=:nd_column_val
			  AND	 LANGUAGE_ID  =:nd_lang_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select distinct APPL_USER_NAME into :b0  from SM_APPL_US\
ER_LANG where (APPL_USER_ID=:b0 and LANGUAGE_ID=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )753;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_column_val;
     sqlstm.sqhstl[0] = (unsigned int  )1002;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_column_val;
     sqlstm.sqhstl[1] = (unsigned int  )1002;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
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


				
				nd_column_val.arr[nd_column_val.len]='\0';

				 if (OERROR)
					  { 
						disp_message (ERR_MESG,"SELECT FAILED FROM SM_APPL_USER TABLE");
					  }
 
	   
	      }
		
			 if (strcmp(column_var.arr,"PAT_PREFIX")==0)
			 {
			
				/* EXEC SQL SELECT substr(:nd_column_val,1,5) into :nd_column_val from dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select substr(:b0,1,5) into :b0  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )780;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_column_val;
    sqlstm.sqhstl[0] = (unsigned int  )1002;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_column_val;
    sqlstm.sqhstl[1] = (unsigned int  )1002;
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


				strcat(nd_column_val.arr,". ");
			 }

			 if (strcmp(column_var.arr,"HOSP_NAME")==0)
			 {
				nd_column_val.arr[0]  ='\0';
				nd_column_val.len	  =0;

				/* EXEC SQL select  ACC_ENTITY_NAME
								into
								:nd_column_val
							   from sy_acc_entity_lang_vw
							   where acc_entity_id = :nd_facility_id
							   and	  language_id   = :nd_lang_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME into :b0  from sy_acc_entity_lang_\
vw where (acc_entity_id=:b1 and language_id=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )803;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_column_val;
    sqlstm.sqhstl[0] = (unsigned int  )1002;
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


				
				nd_column_val.arr[nd_column_val.len] = '\0';
				
			 }

			 if (strcmp(column_var.arr,"PATIENT_NAME")==0)
			 {
				/*EXEC SQL SELECT rpad(substr(:nd_column_val,1,32),32,'.') into :nd_column_val from dual;
					nd_column_val.arr[nd_column_val.len]='\0';*/ //commented by vani

					nd_patient_id_loc_desc.arr[0] ='\0';
					nd_patient_id_loc_desc.len	= 0;

					nd_column_val.arr[0]  ='\0';
					nd_column_val.len	  =0;
					
				
					/* EXEC SQL select nvl(decode(:nd_lang_id,'en',short_name,SHORT_NAME_LOC_LANG),short_name)  into :nd_patient_id_loc_desc 
					 from mp_patient_mast
					 where patient_id=:d1_patient_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select nvl(decode(:b0,'en',short_name,SHORT_NAME_LOC_LAN\
G),short_name) into :b1  from mp_patient_mast where patient_id=:b2";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )830;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_lang_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_patient_id_loc_desc;
     sqlstm.sqhstl[1] = (unsigned int  )202;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d1_patient_id;
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


						
					nd_patient_id_loc_desc.len = strlen(nd_patient_id_loc_desc.arr);

					nd_patient_id_loc_desc.arr[nd_patient_id_loc_desc.len] = '\0';

					//disp_message(ERR_MESG,nd_patient_id_loc_desc.arr);


					/* EXEC SQL SELECT RPAD(SUBSTR(:nd_patient_id_loc_desc,1,32),32,'.') INTO :nd_column_val  FROM DUAL; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 17;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select RPAD(SUBSTR(:b0,1,32),32,'.') into :b1  from DUAL\
 ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )857;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_patient_id_loc_desc;
     sqlstm.sqhstl[0] = (unsigned int  )202;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_column_val;
     sqlstm.sqhstl[1] = (unsigned int  )1002;
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



					nd_column_val.arr[nd_column_val.len] = '\0';

			 }


			 if (strcmp(column_var.arr,"BED_NUM")==0)
			 {
				/* EXEC SQL SELECT rpad(substr(:nd_column_val,1,8),8,'.') into :nd_column_val from dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 17;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select rpad(substr(:b0,1,8),8,'.') into :b0  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )880;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_column_val;
    sqlstm.sqhstl[0] = (unsigned int  )1002;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_column_val;
    sqlstm.sqhstl[1] = (unsigned int  )1002;
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


					nd_column_val.arr[nd_column_val.len]='\0';
					
			 }
		
			
			fprintf(fp,"%-s",nd_column_val.arr);
   }



	print_upto = pos_var2;
	i = pos_var2+1;  
	
    pos_var1 = 0;
	pos_var2 = 0;

	pos_var = char_position(dup_var.arr,"+",i);

}
}
}


check_splch(str_var1)
char str_var1[101];
{
 prt_len = 0;
 spchar_pos = 0;
 spchar_pos1 = 0;
 lc_str_val.arr[0]	='\0';
 lc_str_val.len		= 0;
 lc_str_var.arr[0]	='\0';
 lc_str_var.len		= 0;
 
 ctr = 1;
 print_upto_c = 0;
 strcpy(lc_str_val.arr,str_var1);
 lc_str_val.len = strlen(lc_str_val.arr);
 len_lc_str_val = strlen(lc_str_val.arr);

 while(ctr <= len_lc_str_val)
 {
 prt_len = 0;
 spchar_pos = 0;
 spchar_pos1 = 0;
 
 
 spchar_pos = chk_esc_pos(lc_str_val.arr,ctr);
 
 spchar_pos1 = chk_nwln_pos(lc_str_val.arr,ctr);
 if (spchar_pos1 > 0  && spchar_pos1 <= spchar_pos)
   {
   spchar_pos = spchar_pos1;
   spchar_type = 1;
   }

 spchar_pos1 = chk_cp_nwln_pos(lc_str_val.arr,ctr);
 if (spchar_pos1 > 0 && spchar_pos1 <= spchar_pos)
   {
   spchar_pos = spchar_pos1;
   spchar_type = 2;
   }

 
 spchar_pos1 = chk_tab_pos(lc_str_val.arr,ctr);
 if (spchar_pos1 > 0 && spchar_pos1 <= spchar_pos)
   {
   spchar_pos = spchar_pos1;
   spchar_type = 3;
   }

 spchar_pos1 = chk_bold_pos(lc_str_val.arr,ctr);
 if (spchar_pos1 > 0 && spchar_pos1 <= spchar_pos)
   {
   spchar_pos = spchar_pos1;
   spchar_type = 4;
   }

 spchar_pos1 = chk_font_pos(lc_str_val.arr,ctr);
 if (spchar_pos1 > 0 && spchar_pos1 <= spchar_pos)
   {
   spchar_pos = spchar_pos1;
   spchar_type = 5;
   }

spchar_pos1 = chk_line_pos(lc_str_val.arr,ctr);
 if (spchar_pos1 > 0 && spchar_pos1 <= spchar_pos)
   {
   spchar_pos = spchar_pos1;
   spchar_type = 6;
   }

spchar_pos1 = chk_uline_pos(lc_str_val.arr,ctr);
 if (spchar_pos1 > 0 && spchar_pos1 <= spchar_pos)
   {
   spchar_pos = spchar_pos1;
   spchar_type = 7;
   }


 if (spchar_pos == 0)   
 {
 lc_str_var.arr[0]	='\0';
 lc_str_var.len		= 0;
 prt_len = len_lc_str_val - print_upto_c ;

 put_string(lc_str_val.arr,print_upto_c + 1,prt_len);
 strcpy(lc_str_var.arr,ls_str.arr);

 lc_str_var.len=strlen(lc_str_var.arr);

 fprintf(fp,"%s",lc_str_var.arr);

 ctr = len_lc_str_val+1;
 print_upto_c = len_lc_str_val;
 }
 else
 {
 lc_str_var.arr[0]	='\0';
 lc_str_var.len		= 0;

 prt_len = spchar_pos - print_upto_c -1;
 
 put_string(lc_str_val.arr,print_upto_c+1,prt_len);
 strcpy(lc_str_var.arr,ls_str.arr);
 lc_str_var.len = strlen(lc_str_var.arr);

  fprintf(fp,"%s",lc_str_var.arr);
  
  if (spchar_type == 1)
  {
  fprintf(fp,"\n");
  line_ctr++;
  }

  if (spchar_type == 2)
  {
  fprintf(fp,"\n");
  line_ctr++;
  }

  if (spchar_type == 3)
  fprintf(fp,"        ");

  if (spchar_type == 4)
  {
	if (bold_st)
	{
	fprintf(fp,"%c(s-3B",ESC); /* release bold style */
	bold_st = 0;
	}
    else
	{
	fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 			*/
	bold_st = 1;
	}
  }

  if (spchar_type == 5)
  {
	if (font_st)
	{
	fprintf(fp,"%c(s10H",ESC); 	/* To set the font 			*/
	font_st = 0;
	}
    else
	{
	fprintf(fp,"%c(s8H",ESC); 	/* To set the font 			*/
	font_st = 1;
	}
  }
if (spchar_type == 6)
  {
	prt_line_uc_wide1();
  }

  if (spchar_type == 7)
  {
	if (uline_st)
	{
	
	fprintf (fp,"%c&d0D",ESC); 	/* To set the underline 			*/
	uline_st = 0;
	}
    else
	{
	fprintf (fp,"%c&d@",ESC); 	/* To set the underline 			*/
	uline_st = 1;
	}
  }

  ctr = spchar_pos+2;
  print_upto_c = spchar_pos+1;
  }  
 }
}

int chk_tab_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;
splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\t',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\t',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )903;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
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


 
 return(splch_pos);
}

int chk_nwln_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;

splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\n',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\n',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )930;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
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


 
 return(splch_pos);
}

int chk_cp_nwln_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;

splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\N',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\N',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )957;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
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


 
 return(splch_pos);
}

int chk_bold_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;
splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\b',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\b',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )984;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
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


 
 return(splch_pos);
}

int chk_font_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;
splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\f',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\f',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1011;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
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


 
 return(splch_pos);
}

int chk_line_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;
splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\l',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\l',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1038;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
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


 
 return(splch_pos);
}

int chk_uline_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;
splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\u',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\u',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1065;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
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


 
 return(splch_pos);
}
int chk_esc_pos(str_var2,st_pos)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;
splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'\',:st_pos)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1092;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&st_pos;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&splch_pos;
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


 
 return(splch_pos);
}

int chk_date_yn(str_var2)
char str_var2[101];
{
lc_splch_var.arr[0] = '\0';
lc_splch_var.len = 0;
splch_pos = 0;

 strcpy(lc_splch_var.arr,str_var2);
 lc_splch_var.len = strlen(lc_splch_var.arr);
 
 /* EXEC SQL select instr(:lc_splch_var,'DATE',1)
   into :splch_pos
   from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'DATE',1) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1119;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&splch_pos;
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


 
 return(splch_pos);
}

check_page_end(l_lead_lines, l_print_flag)
int l_lead_lines;
int	l_print_flag;
{
	if(l_print_flag==1)
		l_lead_lines=l_lead_lines+10;

	if((line_ctr+l_lead_lines)> 55) 
	{
		fprintf(fp,"%-70s %s %d\n"," ","Contd...",++pctr);
		fprintf(fp,"\f");
		fprintf(fp,"%-45s Page : %d\n\n"," ",pctr);
		line_ctr = 2;
		print_head();
	}
}

int char_position(ls_var,lc_var,ld_var)
char ls_var[101];
char lc_var[3];
int ld_var;
{
 ls_str_var.arr[0] = '\0';
 ls_str_var.len = 0;

 ls_char_var.arr[0] = '\0';
 ls_char_var.len = 0;

 strcpy(ls_str_var.arr,ls_var);
 strcpy(ls_char_var.arr,lc_var);

 ls_str_var.len = strlen(ls_str_var.arr);
 ls_char_var.len = strlen(ls_char_var.arr);

  
 /* EXEC SQL select instr(:ls_str_var,:ls_char_var,:ld_var)
	         into :char_pos
			 from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 17;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,:b1,:b2) into :b3  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1142;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ls_str_var;
 sqlstm.sqhstl[0] = (unsigned int  )103;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&ls_char_var;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&ld_var;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&char_pos;
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
        err_mesg("SELECT failed on table DUAL",0,"");

 
 ld_var = 0;
 return(char_pos);
}

fetch_dtl()
{
bl_reminder_format_id.arr[0]	= '\0';
bl_report_title_text.arr[0]		= '\0';
bl_header_line_01.arr[0]		= '\0';
bl_header_line_02.arr[0]		= '\0';
bl_header_line_03.arr[0]		= '\0';
bl_header_line_04.arr[0]		= '\0';
bl_header_line_05.arr[0]		= '\0';
bl_header_line_06.arr[0]		= '\0';
bl_header_line_07.arr[0]		= '\0';
bl_header_line_08.arr[0]		= '\0';
bl_header_line_09.arr[0]		= '\0';
bl_header_line_10.arr[0]		= '\0';
bl_body_line_01.arr[0]			= '\0';
bl_body_line_02.arr[0]			= '\0';
bl_body_line_03.arr[0]			= '\0';
bl_body_line_04.arr[0]			= '\0';
bl_body_line_05.arr[0]			= '\0';
bl_body_line_06.arr[0]			= '\0';
bl_body_line_07.arr[0]			= '\0';
bl_body_line_08.arr[0]			= '\0';
bl_body_line_09.arr[0]			= '\0';
bl_body_line_10.arr[0]			= '\0';
bl_body_line_11.arr[0]			= '\0';
bl_body_line_12.arr[0]			= '\0';
bl_body_line_13.arr[0]			= '\0';
bl_body_line_14.arr[0]			= '\0';
bl_body_line_15.arr[0]			= '\0';
bl_body_line_16.arr[0]			= '\0';
bl_body_line_17.arr[0]			= '\0';
bl_body_line_18.arr[0]			= '\0';
bl_body_line_19.arr[0]			= '\0';
bl_body_line_20.arr[0]			= '\0';
bl_footer_line_01.arr[0]		= '\0';
bl_footer_line_02.arr[0]		= '\0';
bl_footer_line_03.arr[0]		= '\0';
bl_footer_line_04.arr[0]		= '\0';
bl_footer_line_05.arr[0]		= '\0';
bl_footer_line_06.arr[0]		= '\0';
bl_footer_line_07.arr[0]		= '\0';
bl_footer_line_08.arr[0]		= '\0';
bl_footer_line_09.arr[0]		= '\0';
bl_footer_line_10.arr[0]		= '\0';
str_var.arr[0]                  = '\0';				
nd_patient_id.arr[0]			= '\0';
nd_cust_code.arr[0]				= '\0';
bl_copy_text.arr[0]		        = '\0';
bl_original_text.arr[0]		    = '\0';

bl_report_title_text.len= 0;
bl_header_line_01.len	= 0;
bl_header_line_02.len	= 0;
bl_header_line_03.len	= 0;
bl_header_line_04.len	= 0;
bl_header_line_05.len	= 0;
bl_header_line_06.len	= 0;
bl_header_line_07.len	= 0;
bl_header_line_08.len	= 0;
bl_header_line_09.len	= 0;
bl_header_line_10.len	= 0;
bl_body_line_01.len		= 0;
bl_body_line_02.len		= 0;
bl_body_line_03.len		= 0;
bl_body_line_04.len		= 0;
bl_body_line_05.len		= 0;
bl_body_line_06.len		= 0;
bl_body_line_07.len		= 0;
bl_body_line_08.len		= 0;
bl_body_line_09.len		= 0;
bl_body_line_10.len		= 0;
bl_body_line_11.len		= 0;
bl_body_line_12.len		= 0;
bl_body_line_13.len		= 0;
bl_body_line_14.len		= 0;
bl_body_line_15.len		= 0;
bl_body_line_16.len		= 0;
bl_body_line_17.len		= 0;
bl_body_line_18.len		= 0;
bl_body_line_19.len		= 0;
bl_body_line_20.len		= 0;
bl_footer_line_01.len	= 0;
bl_footer_line_02.len	= 0;
bl_footer_line_03.len	= 0;
bl_footer_line_04.len	= 0;
bl_footer_line_05.len	= 0;
bl_footer_line_06.len	= 0;
bl_footer_line_07.len	= 0;
bl_footer_line_08.len	= 0;
bl_footer_line_09.len	= 0;
bl_footer_line_10.len	= 0;
str_var.len				= 0;
nd_patient_id.len		= 0;
nd_cust_code.len		= 0; 
bl_copy_text.len	    = 0;
bl_original_text.len	= 0;


     
		/* EXEC SQL SELECT	A.PATIENT_ID,B.REGION_CODE,B.RES_AREA_CODE,B.RES_TOWN_CODE
				INTO :nd_patient_id,
					 :nd_REGION_CODE,
					 :nd_RES_AREA_CODE,
					 :nd_RES_TOWN_CODE
			FROM BL_ENC_DISCHARGE_CLEARANCE A,MP_PATIENT B
            WHERE A.PATIENT_ID=B.PATIENT_ID
			AND DOC_TYPE_CODE = :d_doc_type_code
            AND DOC_NUM = :d_doc_number; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 17;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select A.PATIENT_ID ,B.REGION_CODE ,B.RES_AREA_CODE ,B.RES_\
TOWN_CODE into :b0,:b1,:b2,:b3  from BL_ENC_DISCHARGE_CLEARANCE A ,MP_PATIENT \
B where ((A.PATIENT_ID=B.PATIENT_ID and DOC_TYPE_CODE=:b4) and DOC_NUM=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1173;
  sqlstm.selerr = (unsigned short)1;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_REGION_CODE;
  sqlstm.sqhstl[1] = (unsigned int  )102;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_RES_AREA_CODE;
  sqlstm.sqhstl[2] = (unsigned int  )102;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_RES_TOWN_CODE;
  sqlstm.sqhstl[3] = (unsigned int  )102;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_doc_type_code;
  sqlstm.sqhstl[4] = (unsigned int  )9;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_doc_number;
  sqlstm.sqhstl[5] = (unsigned int  )11;
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
			err_mesg("SELECT failed on table BL_ENC_DISCHARGE_CLEARANCE",0,"");



       
       /* EXEC SQL SELECT HEADER_LINE1, HEADER_LINE2, HEADER_LINE3, HEADER_LINE4, 
					   HEADER_LINE5, HEADER_LINE6, BODY_LINE1, BODY_LINE2, BODY_LINE3, 
					   BODY_LINE4, BODY_LINE5, BODY_LINE6, FOOTER_LINE1, FOOTER_LINE2, 
					   FOOTER_LINE3, FOOTER_LINE4, FOOTER_LINE5, FOOTER_LINE6,
					   ORIGINAL_TEXT,COPY_TEXT
	            into :bl_header_line_01,
				     :bl_header_line_02,
					 :bl_header_line_03,
					 :bl_header_line_04,
					 :bl_header_line_05,
					 :bl_header_line_06,
					 :bl_body_line_01,
                     :bl_body_line_02,
				     :bl_body_line_03,
					 :bl_body_line_04,
					 :bl_body_line_05,
					 :bl_body_line_06,
					 :bl_footer_line_01,
					 :bl_footer_line_02,
					 :bl_footer_line_03,
					 :bl_footer_line_04,
					 :bl_footer_line_05,
					 :bl_footer_line_06,
					 :bl_original_text,
					 :bl_copy_text
                FROM BL_DISC_CLEARANCE_FORMAT
		        WHERE Operating_Facility_Id =:nd_facility_id
				and nvl(format_ind,'1')='1'
				AND UPPER(NVL(LANGUAGE_ID,'en'))=UPPER(:nd_lang_id); */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 22;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select HEADER_LINE1 ,HEADER_LINE2 ,HEADER_LINE3 ,HEADE\
R_LINE4 ,HEADER_LINE5 ,HEADER_LINE6 ,BODY_LINE1 ,BODY_LINE2 ,BODY_LINE3 ,BODY_\
LINE4 ,BODY_LINE5 ,BODY_LINE6 ,FOOTER_LINE1 ,FOOTER_LINE2 ,FOOTER_LINE3 ,FOOTE\
R_LINE4 ,FOOTER_LINE5 ,FOOTER_LINE6 ,ORIGINAL_TEXT ,COPY_TEXT into :b0,:b1,:b2\
,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19\
  from BL_DISC_CLEARANCE_FORMAT where ((Operating_Facility_Id=:b20 and nvl(for\
mat_ind,'1')='1') and UPPER(NVL(LANGUAGE_ID,'en'))=UPPER(:b21))";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1212;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&bl_header_line_01;
       sqlstm.sqhstl[0] = (unsigned int  )103;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&bl_header_line_02;
       sqlstm.sqhstl[1] = (unsigned int  )103;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&bl_header_line_03;
       sqlstm.sqhstl[2] = (unsigned int  )103;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&bl_header_line_04;
       sqlstm.sqhstl[3] = (unsigned int  )103;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&bl_header_line_05;
       sqlstm.sqhstl[4] = (unsigned int  )103;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&bl_header_line_06;
       sqlstm.sqhstl[5] = (unsigned int  )103;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&bl_body_line_01;
       sqlstm.sqhstl[6] = (unsigned int  )103;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&bl_body_line_02;
       sqlstm.sqhstl[7] = (unsigned int  )103;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&bl_body_line_03;
       sqlstm.sqhstl[8] = (unsigned int  )103;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&bl_body_line_04;
       sqlstm.sqhstl[9] = (unsigned int  )103;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&bl_body_line_05;
       sqlstm.sqhstl[10] = (unsigned int  )103;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&bl_body_line_06;
       sqlstm.sqhstl[11] = (unsigned int  )103;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&bl_footer_line_01;
       sqlstm.sqhstl[12] = (unsigned int  )103;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&bl_footer_line_02;
       sqlstm.sqhstl[13] = (unsigned int  )103;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&bl_footer_line_03;
       sqlstm.sqhstl[14] = (unsigned int  )103;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&bl_footer_line_04;
       sqlstm.sqhstl[15] = (unsigned int  )103;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&bl_footer_line_05;
       sqlstm.sqhstl[16] = (unsigned int  )103;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&bl_footer_line_06;
       sqlstm.sqhstl[17] = (unsigned int  )103;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&bl_original_text;
       sqlstm.sqhstl[18] = (unsigned int  )103;
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&bl_copy_text;
       sqlstm.sqhstl[19] = (unsigned int  )103;
       sqlstm.sqhsts[19] = (         int  )0;
       sqlstm.sqindv[19] = (         void  *)0;
       sqlstm.sqinds[19] = (         int  )0;
       sqlstm.sqharm[19] = (unsigned int  )0;
       sqlstm.sqadto[19] = (unsigned short )0;
       sqlstm.sqtdso[19] = (unsigned short )0;
       sqlstm.sqhstv[20] = (         void  *)&nd_facility_id;
       sqlstm.sqhstl[20] = (unsigned int  )5;
       sqlstm.sqhsts[20] = (         int  )0;
       sqlstm.sqindv[20] = (         void  *)0;
       sqlstm.sqinds[20] = (         int  )0;
       sqlstm.sqharm[20] = (unsigned int  )0;
       sqlstm.sqadto[20] = (unsigned short )0;
       sqlstm.sqtdso[20] = (unsigned short )0;
       sqlstm.sqhstv[21] = (         void  *)&nd_lang_id;
       sqlstm.sqhstl[21] = (unsigned int  )5;
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

  

       if (OERROR)
            err_mesg("SELECT failed on cursor BL_DISC_CLEARANCE_FORMAT",0,"");
	

	
			
bl_report_title_text.arr[bl_report_title_text.len]		= '\0';
bl_header_line_01.arr[bl_header_line_01.len]		= '\0';
bl_header_line_02.arr[bl_header_line_02.len]		= '\0';
bl_header_line_03.arr[bl_header_line_03.len]		= '\0';
bl_header_line_04.arr[bl_header_line_04.len]		= '\0';
bl_header_line_05.arr[bl_header_line_05.len]		= '\0';
bl_header_line_06.arr[bl_header_line_06.len]		= '\0';
bl_header_line_07.arr[bl_header_line_07.len]		= '\0';
bl_header_line_08.arr[bl_header_line_08.len]		= '\0';
bl_header_line_09.arr[bl_header_line_09.len]		= '\0';
bl_header_line_10.arr[bl_header_line_10.len]		= '\0';
bl_body_line_01.arr[bl_body_line_01.len]			= '\0';
bl_body_line_02.arr[bl_body_line_02.len]			= '\0';
bl_body_line_03.arr[bl_body_line_03.len]			= '\0';
bl_body_line_04.arr[bl_body_line_04.len]			= '\0';
bl_body_line_05.arr[bl_body_line_05.len]			= '\0';
bl_body_line_06.arr[bl_body_line_06.len]			= '\0';
bl_body_line_07.arr[bl_body_line_07.len]			= '\0';
bl_body_line_08.arr[bl_body_line_08.len]			= '\0';
bl_body_line_09.arr[bl_body_line_09.len]			= '\0';
bl_body_line_10.arr[bl_body_line_10.len]			= '\0';
bl_body_line_11.arr[bl_body_line_11.len]			= '\0';
bl_body_line_12.arr[bl_body_line_12.len]			= '\0';
bl_body_line_13.arr[bl_body_line_13.len]			= '\0';
bl_body_line_14.arr[bl_body_line_14.len]			= '\0';
bl_body_line_15.arr[bl_body_line_15.len]			= '\0';
bl_body_line_16.arr[bl_body_line_16.len]			= '\0';
bl_body_line_17.arr[bl_body_line_17.len]			= '\0';
bl_body_line_18.arr[bl_body_line_18.len]			= '\0';
bl_body_line_19.arr[bl_body_line_19.len]			= '\0';
bl_body_line_20.arr[bl_body_line_20.len]			= '\0';
bl_footer_line_01.arr[bl_footer_line_01.len]		= '\0';
bl_footer_line_02.arr[bl_footer_line_02.len]		= '\0';
bl_footer_line_03.arr[bl_footer_line_03.len]		= '\0';
bl_footer_line_04.arr[bl_footer_line_04.len]		= '\0';
bl_footer_line_05.arr[bl_footer_line_05.len]		= '\0';
bl_footer_line_06.arr[bl_footer_line_06.len]		= '\0';
bl_footer_line_07.arr[bl_footer_line_07.len]		= '\0';
bl_footer_line_08.arr[bl_footer_line_08.len]		= '\0';
bl_footer_line_09.arr[bl_footer_line_09.len]		= '\0';
bl_footer_line_10.arr[bl_footer_line_10.len]		= '\0';
nd_patient_id.arr[nd_patient_id.len]				= '\0';
nd_cust_code.arr[nd_cust_code.len]					= '\0';
bl_copy_text.arr[bl_copy_text.len]		= '\0';
bl_original_text.arr[bl_original_text.len]		= '\0'; 
		
}

print_head()
{
    
		if(strcmp(d_print_copy_num.arr,"0") == 0) 
		{ 
			if (bl_original_text.arr[0] != '\0')
			  {
				print_line(bl_original_text.arr);
				fprintf(fp,"\n");
				line_ctr++;
			   }
		 }
       else
	   {
       if (bl_copy_text.arr[0] != '\0')
		  {
			print_line(bl_copy_text.arr);
			fprintf(fp,"\n");
			line_ctr++;
		   }
        }

    if (bl_header_line_01.arr[0] != '\0')
      {
		print_line(bl_header_line_01.arr); 
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_02.arr[0] != '\0')
      {
		
		
		print_line(bl_header_line_02.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_03.arr[0] != '\0')
      {
		print_line(bl_header_line_03.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_04.arr[0] != '\0')
      {
		print_line(bl_header_line_04.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_05.arr[0] != '\0')
      {
		print_line(bl_header_line_05.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
	if (bl_header_line_06.arr[0] != '\0')
      {
		print_line(bl_header_line_06.arr);
		
		fprintf(fp,"\n");
		line_ctr++;
       }
    
	if (bl_report_title_text.arr[0] != '\0')
      {
        fprintf(fp,"%c(s3B",ESC); 
		
  		print_line(bl_report_title_text.arr);
		
		fprintf(fp,"%c(s-3B",ESC); /* release bold style */
		fprintf(fp,"\n\n");
		
		line_ctr++;
		
		line_ctr++;
		
       }
}



