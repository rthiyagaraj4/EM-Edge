
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
           char  filnam[77];
};
static const struct sqlcxp sqlfpn =
{
    76,
    "e:\\ravis\\rl10x\\21304_25183_label_darkness_increase\\kdah-crf-0608\\rlrlbprn.pc"
};


static unsigned long sqlctx = 1587717205;


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
            void  *sqhstv[46];
   unsigned int   sqhstl[46];
            int   sqhsts[46];
            void  *sqindv[46];
            int   sqinds[46];
   unsigned int   sqharm[46];
   unsigned int   *sqharc[46];
   unsigned short  sqadto[46];
   unsigned short  sqtdso[46];
} sqlstm = {10,46};

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

 static const char *sq0011 = 
"select QUEUE_NAME  from sm_print_routing a ,sm_printer b where ((((a.report_\
id=:b0 and a.printer_id1=b.printer_id) and a.dest_locn_type=DECODE(:b1,'!','O'\
,:b2)) and a.dest_locn_code=DECODE(:b1,'!',a.dest_locn_code,NVL(LTRIM(RTRIM(:b\
4)),a.dest_locn_code))) and NVL(a.ws_no,'!!!')=NVL(:b5,'!!!'))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,453,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,48,0,4,463,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
59,0,0,3,0,0,30,479,0,0,0,0,0,1,0,
74,0,0,4,0,0,30,491,0,0,0,0,0,1,0,
89,0,0,5,119,0,4,502,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
112,0,0,6,76,0,4,651,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
135,0,0,7,1712,0,6,891,0,0,38,38,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
302,0,0,8,111,0,4,986,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
325,0,0,9,60,0,4,1012,0,0,1,0,0,1,0,2,9,0,0,
344,0,0,10,6994,0,6,1052,0,0,46,46,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,
543,0,0,11,305,0,9,2129,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
582,0,0,11,0,0,13,2145,0,0,1,0,0,1,0,2,9,0,0,
601,0,0,11,0,0,15,2164,0,0,0,0,0,1,0,
616,0,0,12,64,0,4,2176,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
639,0,0,13,224,0,3,2252,0,0,3,3,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,
666,0,0,14,58,0,4,2649,0,0,1,0,0,1,0,2,9,0,0,
};


/*****************************************************************************************************************/
/* PROGRAM NAME          : RLRLBPRN                                                                              */
/* DESCRIPTION		     : Lab Label Processing n Printing 					                                     */
/* MODIFIED BY           MODIFIED ON       REASON			                                                     */
/* Srinivasarao V        20/02/2012        Specimen n Collection Label printing in Report writer                 */
/*                                         against the Jordan CRF                                                */
/*****************************************************************************************************************/
#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1
#define OERROR 		  (sqlca.sqlcode < 0)
#define INIT_MESG "Label Printing"
#define ESC 0x1B
#define NODATAFOUND (sqlca.sqlcode == 1403)

#include <stdio.h>  
#include <string.h> 
#include <math.h>
#include <malloc.h>  
#include <rl.h>
#include <windows.h>  
 
int BVLanguageIsAPL; /*-- Addded by Gopikannan for online_barcode_label --*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 
                  

/* VARCHAR uid_pwd                 [120],     
		nd_source_type	        [2],
		nd_fm_source	        [7],
        d_no_copy				[2],
        nd_facility_id			[3],
		nd_session_id           [50],
		nd_ws_no                [50],
		nd_test_code            [51],
		nd_pgm_dt               [50],
		nd_trx_ind				[2],
		nd_printer_type         [2],
		nd_thai_lang_yn         [2],
		d_patient_id            [21], 
		d_section_code          [3],
		d_specimen_type_code    [21],
		d_specimen_type_desc    [41],
		d_episode_type			[2],
		d_order_id				[21],
		d_order_type_code	    [5],
		d_order_catalog_code    [21],
		nd_catalog_code			[21],
		d_test_code             [21],
		d_test_code1            [21],
		d_specimen_no			[21], 
		d_urgent_indicator		[3],
		d_request_num			[21],
		d_flag					[2],
		d_pat_name              [61],
		d_source_type			[2],
		d_source_code			[7],
		d_patient_class			[5],	
		er_msg                  [171], 
		nd_interval_specimen_yn [2],
		language_id			    [5],

/o**************** variables added for label_cur cursor **********o/

		a_ws_no					[41],
		a_cmd_line_arg			[500],
		a_rowid					[41],
		a_pgm_id				[41],

/o**************** variables added for enhancement **********o/
        d_facility_name			[40],
		d_dob					[17],
		d_start_date_time		[17],
		d_start_date_time1		[17],
		d_actual_patient_id		[21],
		d_description			[21],
		d_desc_on_label			[31],
		d_ref_location			[21],
		nd_file_no				[100],
		d_container_code		[5],
		vol_specimen_no			[21],
		d_volume_unit			[5],
		d_prep_text				[41],
		d_pat_dob_no_of_days	[10],
		d_sex					[2],
		d_unit					[6],
		nd_print_source_type	[2],
		v_text                  [2001],
		o_rem_splitting_text	[500],
		o_rem_splitting_text1	[500],
		o_rem_splitting_text2	[500],
		o_rem_splitting_text3	[500],
		o_rem_splitting_text4	[500],
		nd_print_source			[2]; */ 
struct { unsigned short len; unsigned char arr[120]; } uid_pwd;

struct { unsigned short len; unsigned char arr[2]; } nd_source_type;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_source;

struct { unsigned short len; unsigned char arr[2]; } d_no_copy;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[50]; } nd_session_id;

struct { unsigned short len; unsigned char arr[50]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[51]; } nd_test_code;

struct { unsigned short len; unsigned char arr[50]; } nd_pgm_dt;

struct { unsigned short len; unsigned char arr[2]; } nd_trx_ind;

struct { unsigned short len; unsigned char arr[2]; } nd_printer_type;

struct { unsigned short len; unsigned char arr[2]; } nd_thai_lang_yn;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[3]; } d_section_code;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_type_code;

struct { unsigned short len; unsigned char arr[41]; } d_specimen_type_desc;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } d_order_id;

struct { unsigned short len; unsigned char arr[5]; } d_order_type_code;

struct { unsigned short len; unsigned char arr[21]; } d_order_catalog_code;

struct { unsigned short len; unsigned char arr[21]; } nd_catalog_code;

struct { unsigned short len; unsigned char arr[21]; } d_test_code;

struct { unsigned short len; unsigned char arr[21]; } d_test_code1;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[3]; } d_urgent_indicator;

struct { unsigned short len; unsigned char arr[21]; } d_request_num;

struct { unsigned short len; unsigned char arr[2]; } d_flag;

struct { unsigned short len; unsigned char arr[61]; } d_pat_name;

struct { unsigned short len; unsigned char arr[2]; } d_source_type;

struct { unsigned short len; unsigned char arr[7]; } d_source_code;

struct { unsigned short len; unsigned char arr[5]; } d_patient_class;

struct { unsigned short len; unsigned char arr[171]; } er_msg;

struct { unsigned short len; unsigned char arr[2]; } nd_interval_specimen_yn;

struct { unsigned short len; unsigned char arr[5]; } language_id;

struct { unsigned short len; unsigned char arr[41]; } a_ws_no;

struct { unsigned short len; unsigned char arr[500]; } a_cmd_line_arg;

struct { unsigned short len; unsigned char arr[41]; } a_rowid;

struct { unsigned short len; unsigned char arr[41]; } a_pgm_id;

struct { unsigned short len; unsigned char arr[40]; } d_facility_name;

struct { unsigned short len; unsigned char arr[17]; } d_dob;

struct { unsigned short len; unsigned char arr[17]; } d_start_date_time;

struct { unsigned short len; unsigned char arr[17]; } d_start_date_time1;

struct { unsigned short len; unsigned char arr[21]; } d_actual_patient_id;

struct { unsigned short len; unsigned char arr[21]; } d_description;

struct { unsigned short len; unsigned char arr[31]; } d_desc_on_label;

struct { unsigned short len; unsigned char arr[21]; } d_ref_location;

struct { unsigned short len; unsigned char arr[100]; } nd_file_no;

struct { unsigned short len; unsigned char arr[5]; } d_container_code;

struct { unsigned short len; unsigned char arr[21]; } vol_specimen_no;

struct { unsigned short len; unsigned char arr[5]; } d_volume_unit;

struct { unsigned short len; unsigned char arr[41]; } d_prep_text;

struct { unsigned short len; unsigned char arr[10]; } d_pat_dob_no_of_days;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[6]; } d_unit;

struct { unsigned short len; unsigned char arr[2]; } nd_print_source_type;

struct { unsigned short len; unsigned char arr[2001]; } v_text;

struct { unsigned short len; unsigned char arr[500]; } o_rem_splitting_text;

struct { unsigned short len; unsigned char arr[500]; } o_rem_splitting_text1;

struct { unsigned short len; unsigned char arr[500]; } o_rem_splitting_text2;

struct { unsigned short len; unsigned char arr[500]; } o_rem_splitting_text3;

struct { unsigned short len; unsigned char arr[500]; } o_rem_splitting_text4;

struct { unsigned short len; unsigned char arr[2]; } nd_print_source;



/***************** variables added for call_main_report() ***********/
	
/* VARCHAR	a_pwd_id                [41],
        a_session_id            [41],
        a_facility_id           [41],
	    a_spec_ord_no	        [31],
        a_sec_ord_type          [21],
	    a_test_code             [31],
        a_cmd_line 	            [500],
        a_source_type		    [3],
        a_source_code		    [11]; */ 
struct { unsigned short len; unsigned char arr[41]; } a_pwd_id;

struct { unsigned short len; unsigned char arr[41]; } a_session_id;

struct { unsigned short len; unsigned char arr[41]; } a_facility_id;

struct { unsigned short len; unsigned char arr[31]; } a_spec_ord_no;

struct { unsigned short len; unsigned char arr[21]; } a_sec_ord_type;

struct { unsigned short len; unsigned char arr[31]; } a_test_code;

struct { unsigned short len; unsigned char arr[500]; } a_cmd_line;

struct { unsigned short len; unsigned char arr[3]; } a_source_type;

struct { unsigned short len; unsigned char arr[11]; } a_source_code;


/***************** end of variables added for call_main_report() ***********/

		int  d_container_volume ,
		     d_test_volume = 0,
			 d_volume	   = 0,
			 d_no_labels   = 0,
			 d_total       = 0,
			 d_NumOfCopies = 1,
			 d_con_count   = 0,
			 d_label_cnt   = 1,
			 prev_last_comma = 0,	 
			 d_req_volume	,
			 d_testvolume     ;

/***************** variables added  label_r PL/SQL table ***********/

 int  lr_cont_volume[100];
 int  lr_no_of_labels[100];
 /* VARCHAR lr_facility_name[100][141],
		 lr_label_desc[100][3950],
 		 lr_volume_unit[100][111],
 		 lr_specimen_no[100][81],
		 lr_patient_high_risk_ind[100][11],//13.09.2008
 		 lr_sample_id[100][21],
 		 lr_category_code[100][21],
 		 lr_category_year[100][21],
 		 lr_category_no[100][41],
 		 lr_priority[100][21],
 		 lr_spec_date_time[100][41],
 		 lr_patient_name[100][161],
 		 lr_source_code[100][41],
		 lr_episode_type[100][41], //-- 13.03.2006
		 lr_source_type[100][41], //-- 13.03.2006
		 lr_source_desc[100][101], //-- 13.03.2006
		 lr_source_desc_on_label[100][101], //-- 13.03.2006
 		 lr_anatomy_site[100][41],
 		 lr_anatomy_site_desc[100][3950],
 		 lr_tissue_desc[100][3950],
 		 lr_histo_yn[100][4],
 		 lr_patient_id[100][141],
 		 lr_sex[100][11],
 		 lr_dob[100][41],
 		 lr_alternate_id_type[100][101],
 		 lr_alternate_id[100][141],
 		 lr_unit_no[100][141],
 		 lr_ord_date_time[100][141],
 		 lr_test_code[100][3950],
 		 lr_test_name[100][3950],
 		 lr_test_desc[100][3950],
 		 lr_pgm_id[100][21],
  		 lr_spec_type_code[100][241],
  		 lr_test_name_ar[100][241],
  		 lr_module_id[100][11],
		 lr_customer_id[150][140]; */ 
struct { unsigned short len; unsigned char arr[142]; } lr_facility_name[100];

struct { unsigned short len; unsigned char arr[3950]; } lr_label_desc[100];

struct { unsigned short len; unsigned char arr[114]; } lr_volume_unit[100];

struct { unsigned short len; unsigned char arr[82]; } lr_specimen_no[100];

struct { unsigned short len; unsigned char arr[14]; } lr_patient_high_risk_ind[100];

struct { unsigned short len; unsigned char arr[22]; } lr_sample_id[100];

struct { unsigned short len; unsigned char arr[22]; } lr_category_code[100];

struct { unsigned short len; unsigned char arr[22]; } lr_category_year[100];

struct { unsigned short len; unsigned char arr[42]; } lr_category_no[100];

struct { unsigned short len; unsigned char arr[22]; } lr_priority[100];

struct { unsigned short len; unsigned char arr[42]; } lr_spec_date_time[100];

struct { unsigned short len; unsigned char arr[162]; } lr_patient_name[100];

struct { unsigned short len; unsigned char arr[42]; } lr_source_code[100];

struct { unsigned short len; unsigned char arr[42]; } lr_episode_type[100];

struct { unsigned short len; unsigned char arr[42]; } lr_source_type[100];

struct { unsigned short len; unsigned char arr[102]; } lr_source_desc[100];

struct { unsigned short len; unsigned char arr[102]; } lr_source_desc_on_label[100];

struct { unsigned short len; unsigned char arr[42]; } lr_anatomy_site[100];

struct { unsigned short len; unsigned char arr[3950]; } lr_anatomy_site_desc[100];

struct { unsigned short len; unsigned char arr[3950]; } lr_tissue_desc[100];

struct { unsigned short len; unsigned char arr[6]; } lr_histo_yn[100];

struct { unsigned short len; unsigned char arr[142]; } lr_patient_id[100];

struct { unsigned short len; unsigned char arr[14]; } lr_sex[100];

struct { unsigned short len; unsigned char arr[42]; } lr_dob[100];

struct { unsigned short len; unsigned char arr[102]; } lr_alternate_id_type[100];

struct { unsigned short len; unsigned char arr[142]; } lr_alternate_id[100];

struct { unsigned short len; unsigned char arr[142]; } lr_unit_no[100];

struct { unsigned short len; unsigned char arr[142]; } lr_ord_date_time[100];

struct { unsigned short len; unsigned char arr[3950]; } lr_test_code[100];

struct { unsigned short len; unsigned char arr[3950]; } lr_test_name[100];

struct { unsigned short len; unsigned char arr[3950]; } lr_test_desc[100];

struct { unsigned short len; unsigned char arr[22]; } lr_pgm_id[100];

struct { unsigned short len; unsigned char arr[242]; } lr_spec_type_code[100];

struct { unsigned short len; unsigned char arr[242]; } lr_test_name_ar[100];

struct { unsigned short len; unsigned char arr[14]; } lr_module_id[100];

struct { unsigned short len; unsigned char arr[142]; } lr_customer_id[150];


/***************** END of variables added  label_r PL/SQL table ***********/
 int h_no_of_rec = 0;
 int printcopies_rw = 0; /// added on 20/02/12 for Jordan CRF
 char string_var[100];
 short d_specimen_type_ind;       

/*tern  char WORKING_DIR_NAME [75];*/

       		int d_count = 0;
			int i_count = 0;
			int c_count = 0;
			int er_msg_type = 0;	
			int err_flag = 0;
  
int v_index	= 0,  
    v_interval_index = 0,
    v_i;
char string_char[100];

/* VARCHAR l_temp1  [121]; */ 
struct { unsigned short len; unsigned char arr[121]; } l_temp1;


/**------------***** ADDED ON 19/08/2011 AGAINST SIRIRAJ REQUIRMENT to increase the height of barcode in
	Intermec printer, hence the test name line wants to comment ----------------------******/
/* VARCHAR l_customer_id [50]; */ 
struct { unsigned short len; unsigned char arr[50]; } l_customer_id;
	

/* VARCHAR l_user[300]; */ 
struct { unsigned short len; unsigned char arr[300]; } l_user;


/* VARCHAR  rep_specimen_no     [21],
	     rep_pat_name        [161],
         rep_facility_name   [141],
		 rep_label_desc      [3950],
 		 rep_patient_high_risk_ind[11], 
 		 rep_sample_id[21],
 		 rep_category_code[21],
 		 rep_category_year[21],
 		 rep_category_no[41],
 		 rep_priority[21],
 		 rep_source_code[41],
		 rep_source_type[41], 
		 rep_source_desc[101],  
		 rep_source_desc_on_label[101],  
 		 rep_anatomy_site[41],
 		 rep_anatomy_site_desc[3950],
 		 rep_tissue_type_desc[3950],
 		 rep_histo_yn[4],
 		 rep_patient_id[141],
 		 rep_alternate_id_type[101],
 		 rep_alternate_id[141],
 		 rep_unit_no[141],
 		 rep_ord_date_time[141],
 		 rep_test_code[3950],
 		 rep_test_name[3950],
 		 rep_test_desc[3950],
 		 rep_pgm_id[21],
  		 rep_spec_type_code[241],
		 rep_customer_id[140],
		 rep_volume_unit[111],
		 rep_spec_regd_date[41],
 		 rep_sex[11],
 		 rep_dob[41],
		 rep_episode_type[41],
		 rep_rowid[41],   /// added on 20/02/12 for report writer printing for Jordan CRF
		 nd_printer_queue[200], /o-- Addded by Gopikannan for online_barcode_label --o/
		 
		 nd_printer_id	[100], //added for ML-MMOH-CRF-0578
		 nd_printer_queue1	[100]; */ 
struct { unsigned short len; unsigned char arr[21]; } rep_specimen_no;

struct { unsigned short len; unsigned char arr[161]; } rep_pat_name;

struct { unsigned short len; unsigned char arr[141]; } rep_facility_name;

struct { unsigned short len; unsigned char arr[3950]; } rep_label_desc;

struct { unsigned short len; unsigned char arr[11]; } rep_patient_high_risk_ind;

struct { unsigned short len; unsigned char arr[21]; } rep_sample_id;

struct { unsigned short len; unsigned char arr[21]; } rep_category_code;

struct { unsigned short len; unsigned char arr[21]; } rep_category_year;

struct { unsigned short len; unsigned char arr[41]; } rep_category_no;

struct { unsigned short len; unsigned char arr[21]; } rep_priority;

struct { unsigned short len; unsigned char arr[41]; } rep_source_code;

struct { unsigned short len; unsigned char arr[41]; } rep_source_type;

struct { unsigned short len; unsigned char arr[101]; } rep_source_desc;

struct { unsigned short len; unsigned char arr[101]; } rep_source_desc_on_label;

struct { unsigned short len; unsigned char arr[41]; } rep_anatomy_site;

struct { unsigned short len; unsigned char arr[3950]; } rep_anatomy_site_desc;

struct { unsigned short len; unsigned char arr[3950]; } rep_tissue_type_desc;

struct { unsigned short len; unsigned char arr[4]; } rep_histo_yn;

struct { unsigned short len; unsigned char arr[141]; } rep_patient_id;

struct { unsigned short len; unsigned char arr[101]; } rep_alternate_id_type;

struct { unsigned short len; unsigned char arr[141]; } rep_alternate_id;

struct { unsigned short len; unsigned char arr[141]; } rep_unit_no;

struct { unsigned short len; unsigned char arr[141]; } rep_ord_date_time;

struct { unsigned short len; unsigned char arr[3950]; } rep_test_code;

struct { unsigned short len; unsigned char arr[3950]; } rep_test_name;

struct { unsigned short len; unsigned char arr[3950]; } rep_test_desc;

struct { unsigned short len; unsigned char arr[21]; } rep_pgm_id;

struct { unsigned short len; unsigned char arr[241]; } rep_spec_type_code;

struct { unsigned short len; unsigned char arr[140]; } rep_customer_id;

struct { unsigned short len; unsigned char arr[111]; } rep_volume_unit;

struct { unsigned short len; unsigned char arr[41]; } rep_spec_regd_date;

struct { unsigned short len; unsigned char arr[11]; } rep_sex;

struct { unsigned short len; unsigned char arr[41]; } rep_dob;

struct { unsigned short len; unsigned char arr[41]; } rep_episode_type;

struct { unsigned short len; unsigned char arr[41]; } rep_rowid;

struct { unsigned short len; unsigned char arr[200]; } nd_printer_queue;

struct { unsigned short len; unsigned char arr[100]; } nd_printer_id;

struct { unsigned short len; unsigned char arr[100]; } nd_printer_queue1;
 //added for ML-MMOH-CRF-0578
		 

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
char filename[150];
char filename_ap[150];
char filename1[150];
char filenamezpl[150];
 
char *command;  
char gtt_yn = 'N';
char reprint_yn[3] ;

void proc_main(argc,argv)
int argc;
char *argv[];
{
 err_flag = 0;

//ins_message(ERR_MESG,"rlrlbprn : Start");
//disp_message(ERR_MESG,"Start"); 

  if(argc < 9)  
  {
        ins_message(ERR_MESG,"rlrlbprn : Usage -  arguments wrong\n");
   }

    strcpy(filename,WORKING_DIR);
    strcpy(filename_ap,WORKING_DIR);

    strcpy(a_pgm_id.arr,argv[0]);
    a_pgm_id.len = strlen(a_pgm_id.arr); 

    strcpy(uid_pwd.arr,argv[1]); 
    uid_pwd.len = strlen(uid_pwd.arr); 

	extract_act_user(argv[1]); // added on 27 Mar 2008

    strcpy(nd_session_id.arr, argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);

    strcpy(nd_pgm_dt.arr, argv[3]);
    nd_pgm_dt.len = strlen(nd_pgm_dt.arr);

	if (strcmp(strupr(argv[6]), "RLRCOLBL") == 0)
	{
	    strcpy(a_pgm_id.arr,argv[6]);
		a_pgm_id.len = strlen(a_pgm_id.arr); 
	}
	else 
	{
	    strcpy(a_pgm_id.arr,argv[5]);
	    a_pgm_id.len = strlen(a_pgm_id.arr); 
	}
    strcpy(filename1, a_pgm_id.arr);

    strcat(filename, strcat(filename1, ".lis"));


	if (strcmp(strupr(a_pgm_id.arr), "RLRCOLBL") == 0)
	{
		strcpy(nd_facility_id.arr, argv[5]);
		nd_facility_id.len = strlen(nd_facility_id.arr);

		strcpy(d_order_type_code.arr,argv[7]);
		d_order_type_code.len = strlen(d_order_type_code.arr);

		strcpy(d_order_id.arr,argv[8]);
		d_order_id.len = strlen(d_order_id.arr);

		strcpy(nd_source_type.arr, argv[9]);
		nd_source_type.len = strlen(nd_source_type.arr);

		strcpy(nd_fm_source.arr, argv[10]);
		nd_fm_source.len = strlen(nd_fm_source.arr);

		strcpy(nd_ws_no.arr, argv[11]);
		nd_ws_no.len = strlen(nd_ws_no.arr);
		
		//added for ML-MMOH-CRF-0578
			if (argv[12])
			{
			//disp_message(ERR_MESG, argv[13]);
			strcpy(nd_printer_id.arr, argv[12]); 
			nd_printer_id.len = strlen(nd_printer_id.arr);
			//disp_message(ERR_MESG, nd_printer_id.arr);
			}
			
			//end added for ML-MMOH-CRF-0578
		
		
	}
	else
	{
		strcpy(nd_facility_id.arr, argv[4]);
		nd_facility_id.len = strlen(nd_facility_id.arr);

		strcpy(d_order_id.arr,argv[6]);
		d_order_id.len = strlen(d_order_id.arr);

		strcpy(d_order_type_code.arr,argv[7]);
		d_order_type_code.len = strlen(d_order_type_code.arr);

		d_NumOfCopies = atoi(argv[8]);

		strcpy(nd_source_type.arr, "O");
		nd_source_type.len = strlen(nd_source_type.arr);

		strcpy(nd_fm_source.arr, d_order_type_code.arr);
		nd_fm_source.len = strlen(nd_fm_source.arr);

		strcpy(nd_ws_no.arr, argv[10]);
		nd_ws_no.len = strlen(nd_ws_no.arr);

	    if ( strcmp(strupr(a_pgm_id.arr), "RLRSLILB") == 0 || strcmp(strupr(a_pgm_id.arr), "RLRALILB") == 0 )  
		{
			strcpy(nd_test_code.arr, argv[11]);
			nd_test_code.len = strlen(nd_test_code.arr);
             
			if (argv[12])
			strcpy(reprint_yn, argv[12]);
			
			
			
			//added for ML-MMOH-CRF-0578
			if (argv[13])
			{
			//disp_message(ERR_MESG, argv[13]);
			strcpy(nd_printer_id.arr, argv[13]); 
			nd_printer_id.len = strlen(nd_printer_id.arr);
			//disp_message(ERR_MESG, nd_printer_id.arr);
			}
			
			//end added for ML-MMOH-CRF-0578
		

		}
		else
		{
		   
		   if (argv[11])
			  strcpy(reprint_yn, argv[11]);
			  
			//added for ML-MMOH-CRF-0578
			if (argv[12])
			{
			//disp_message(ERR_MESG, argv[12]);
			strcpy(nd_printer_id.arr, argv[12]); 
			nd_printer_id.len = strlen(nd_printer_id.arr);
			//disp_message(ERR_MESG, nd_printer_id.arr);
			}
			//end added for ML-MMOH-CRF-0578

		}


	}

	if (strcmp(strupr(a_pgm_id.arr), "RLRCOLBL") != 0)
	{
	    strcpy(a_session_id.arr, nd_session_id.arr);	
		a_session_id.len = strlen(a_session_id.arr);

		strcpy(a_facility_id.arr, nd_facility_id.arr);	
		a_facility_id.len = strlen(a_facility_id.arr);

		strcpy(a_spec_ord_no.arr, d_order_id.arr);	
		a_spec_ord_no.len = strlen(a_spec_ord_no.arr);

		strcpy(a_sec_ord_type.arr, d_order_type_code.arr);	
		a_sec_ord_type.len = strlen(a_sec_ord_type.arr);

	    strcpy(a_source_type.arr, "O");	
		a_source_type.len = strlen(a_source_type.arr);

	    strcpy(a_source_code.arr, a_sec_ord_type.arr);
		a_source_code.len = strlen(a_source_code.arr);
			
	    if ( strcmp(strupr(a_pgm_id.arr), "RLRSLILB") == 0 || strcmp(strupr(a_pgm_id.arr), "RLRALILB") == 0 )  
		{
			strcpy(a_test_code.arr, nd_test_code.arr);	
			a_test_code.len = strlen(a_test_code.arr);
		}
	    else
		{
			strcpy(a_test_code.arr, "");
			a_test_code.len = strlen(a_test_code.arr);
		}
		strcpy(a_ws_no.arr, nd_ws_no.arr);
		a_ws_no.len = strlen(a_ws_no.arr);

	}
	else
	{
	    strcpy(a_session_id.arr, nd_session_id.arr); 
		a_session_id.len = strlen(a_session_id.arr);

	    strcpy(a_facility_id.arr, nd_facility_id.arr);	
		a_facility_id.len = strlen(a_facility_id.arr);

		strcpy(a_sec_ord_type.arr, d_order_type_code.arr);	
		a_sec_ord_type.len = strlen(a_sec_ord_type.arr);

	    strcpy(a_spec_ord_no.arr, d_order_id.arr);	
		a_spec_ord_no.len = strlen(a_spec_ord_no.arr);

	    strcpy(a_source_type.arr, nd_source_type.arr);
		a_source_type.len = strlen(a_source_type.arr);
			
		strcpy(a_source_code.arr, nd_fm_source.arr);
		a_source_code.len = strlen(a_source_code.arr);
			
		strcpy(a_ws_no.arr, nd_ws_no.arr);	
		a_ws_no.len = strlen(a_ws_no.arr);
	}



    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

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
    sqlstm.sqhstl[0] = (unsigned int  )122;
    sqlstm.sqhsts[0] = (         int  )122;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}




    set_meduser_role();
	strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
	
	
    //added for ML-MMOH-CRF-0578
	/* EXEC SQL  SELECT replace(:nd_printer_id,'!',' ') 
			INTO :nd_printer_id from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select replace(:b0,'!',' ') into :b0  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_printer_id;
 sqlstm.sqhstl[0] = (unsigned int  )102;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_printer_id;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


	nd_printer_id.len = strlen(nd_printer_id.arr);
	//end ML-MMOH-CRF-0578
    
	
	get_printer_type();

    get_thai_lang();
	
	get_site_customer_id();  /// added on 20/02/12 for report writer printing for Jordan CRF
	 
	call_main_report();
	


    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )59;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
    if (sqlca.sqlcode < 0) goto err_exit;
}



//	fclose(f1);

    return;

err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	fclose(f1);
    sprintf(string_var,"%s -> %s\n",a_spec_ord_no.arr, sqlca.sqlerrm.sqlerrmc);
    ins_message(ORA_MESG,string_var);
//	disp_message(ERR_MESG, string_var);
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )74;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

/**************************select transaction based or not ***************/
get_trans_ind()
{
	
	nd_trx_ind.arr[0]		= '\0';
	nd_trx_ind.len		= 0;

	/* EXEC SQL  SELECT NVL(TRANSACTION_BASED_YN, 'N')
	            INTO :nd_trx_ind
	            FROM sy_online_print_id
               WHERE MODULE_ID = 'RL'
   		         AND ONLINE_PRINT_NAME = :a_pgm_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(TRANSACTION_BASED_YN,'N') into :b0  from sy_onlin\
e_print_id where (MODULE_ID='RL' and ONLINE_PRINT_NAME=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )89;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_trx_ind;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&a_pgm_id;
 sqlstm.sqhstl[1] = (unsigned int  )43;
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
		sprintf(string_var,"%s get_trans_ind()-> %s\n", a_spec_ord_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	nd_trx_ind.arr[nd_trx_ind.len]   = '\0';

      if(NO_DATA_FOUND)
		return 0;
		
					 if (strcmp(nd_trx_ind.arr, "Y") == 0)
					 {

						strcpy(nd_print_source_type.arr, nd_source_type.arr);
						strcpy(nd_print_source.arr, nd_fm_source.arr);

//				sprintf(string_char,"nd_print_source_type.arr nd_source_type %s", nd_print_source_type.arr, nd_source_type.arr);
//				disp_message(ERR_MESG, string_char);

					 }
					 else
					 {
						strcpy(nd_print_source_type.arr, "O");
						strcpy(nd_print_source.arr, " ");
					 }


	return 1; 

}

call_main_report()
{

    get_trans_ind();
	//disp_message(ERR_MESG,"BEFORE CALLING123");
	call_pkg_rllabels();
	call_print_label();
}

set_fonts()
{

/*	fprintf(f1,"%c&k4S",ESC); This will make the font condensed */	
/*  fprintf(fp,"%c(s4B",ESC); This will make the font bold      */
	fprintf(f1, "%c(s15H", ESC);/* Reduce the font size*/
	fprintf(f1,"%c&a0L",ESC);/* This will make the left margin to reduce to 0 */
	fprintf(f1,"%c&l0E\n",ESC);	/* This will make the top margin to reduce to 0 */
	fprintf(f1,"%c&l12D",ESC);/* This will make no. of lines per inch to 8 */
}


call_print_label()
{

//sprintf(string_var,"no of labels=%d",h_no_of_rec);
//disp_message(ERR_MESG,string_var);


    for (v_i=0;v_i<h_no_of_rec;v_i++)
	{

	    if ( strcmp(lr_histo_yn[v_i].arr, "N") != 0)
	    {
 		  strcpy(a_pgm_id.arr, "RLRSPCHS");
		  a_pgm_id.len = strlen(a_pgm_id.arr); 
		  sprintf(filename, "%s%s", filename_ap, "RLRSPCHS.lis");
	    }


	    if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
	    { 

	 	   ins_message(ERR_MESG,"Error in opening output file...\n");  
	    }

		if (strcmp(nd_printer_type.arr,"3")!= 0)
		{
		   fprintf(f1, "%cE", ESC);
  		   set_fonts();
		}




		if (strcmp(l_customer_id.arr,"MOHBR") == 0 && strcmp(a_pgm_id.arr,"RLRALILB") == 0)
		{
			print_label_mohbr(v_i);  ///added against Bru-HIMS-CRF-389 & bru-hims-crf-420 
		}
		else if (strcmp(a_pgm_id.arr,"RLRSPCLB") == 0 || strcmp(a_pgm_id.arr,"RLRCOLBL") == 0 || strcmp(a_pgm_id.arr,"RLRSPCHS") == 0)
		{

		  if (strcmp(l_customer_id.arr,"KAUH") != 0) /// added on 20/02/12 for report writer printing for Jordan CRF
		  {
		    if (strcmp(l_customer_id.arr,"MOHBR") == 0)
			{
			////s	print_label_mohbr(v_i); ///commented against Bru-HIMS-CRF-389 & bru-hims-crf-420 

				print_label_mohbr(v_i);  ///added against Bru-HIMS-CRF-389 & bru-hims-crf-420 
			}
            else
			{
				print_label(v_i);  
			
			}
		  }
		 }
		else if (strcmp(a_pgm_id.arr,"RLRALILB") == 0 )
		{
			print_aliquot_label(v_i);
		}
		else if (strcmp(a_pgm_id.arr,"RLRSLILB") == 0 )
		{
			print_slide_label(v_i);
		}

		fclose(f1);		
	
		if (strcmp(nd_printer_type.arr,"3")!= 0)
		{	
			fprintf(f1, "%cE", ESC);
			set_fonts();
		}

		if (err_flag == 0)
		{
			if (strcmp(nd_trx_ind.arr, "Y") == 0)
			{
			  if (strcmp(strupr(a_pgm_id.arr), "RLRCOLBL") == 0)
			  {
			    if (strcmp(strupr(nd_print_source_type.arr), "N") == 0 || strcmp(strupr(lr_source_type[v_i].arr), "E") != 0) //21.09.2006 as the command line arg passing locn type as "N" , "R" 
				{
			      strcpy(nd_print_source_type.arr, lr_source_type[v_i].arr);
			      strcpy(nd_print_source.arr, lr_source_code[v_i].arr);
				}
				else
				{
//			disp_message(ERR_MESG, d_order_type_code.arr);
				  strcpy(nd_print_source_type.arr, "O");
				  nd_print_source_type.len = strlen(nd_print_source_type.arr);
				  strcpy(nd_print_source.arr, "");
				  nd_print_source.len = strlen(nd_print_source.arr);
				  /* EXEC SQL SELECT section_code
			               INTO   :nd_print_source
	                       FROM   rl_section_code
                           WHERE  order_type_code = :d_order_type_code; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 10;
      sqlstm.arrsiz = 4;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = "select section_code into :b0  from rl_section_code wher\
e order_type_code=:b1";
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )112;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)256;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqhstv[0] = (         void  *)&nd_print_source;
      sqlstm.sqhstl[0] = (unsigned int  )4;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_order_type_code;
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



		          if(NO_DATA_FOUND)
				  { 
//				    disp_message(ERR_MESG, "ndf");
   		            strcpy(nd_print_source.arr, " ");
                    nd_print_source.len = strlen(nd_print_source.arr);
				  }


               	  if(OERROR)
				  {
//				   disp_message(ERR_MESG, "ssss");
   		            strcpy(nd_print_source.arr, " ");
		            nd_print_source.len = strlen(nd_print_source.arr);
				  }

                  nd_print_source.arr[nd_print_source.len]  = '\0';
             	  nd_printer_type.len = 0;
//				  disp_message(ERR_MESG, nd_print_source.arr);
				}
			  }
			}
			else
			{
			  strcpy(nd_print_source_type.arr, "O");
			  strcpy(nd_print_source.arr, " ");
			}
			
			//// print_barcode_label(lr_no_of_labels[v_i]); commented this and added the below code against the Jordan CRF 20/02/12
			
			if ((strcmp(a_pgm_id.arr,"RLRSPCLB") == 0 || strcmp(a_pgm_id.arr,"RLRCOLBL") == 0 
			        || strcmp(a_pgm_id.arr,"RLRSPCHS") == 0) && (strcmp(l_customer_id.arr,"KAUH") == 0) )  /// added on 20/02/12 for report writer printing for Jordan CRF
	     	{
				rep_specimen_no.arr[0] = '\0';
				rep_specimen_no.len    = 0;
				rep_pat_name.arr[0] = '\0';
				rep_pat_name.len    = 0;
				rep_facility_name.arr[0] = '\0';
				rep_facility_name.len    = 0;
				rep_priority.arr[0] = '\0';
				rep_priority.len    = 0;
				rep_patient_id.arr[0] = '\0';
				rep_patient_id.len    = 0;
				rep_sample_id.arr[0] = '\0';
				rep_sample_id.len    = 0;
				rep_category_code.arr[0] = '\0';
				rep_category_code.len    = 0;
				rep_category_year.arr[0] = '\0';
				rep_category_year.len    = 0;
				rep_category_no.arr[0] = '\0';
				rep_category_no.len    = 0;
				rep_unit_no.arr[0] = '\0';
				rep_unit_no.len    = 0;
				rep_patient_high_risk_ind.arr[0] = '\0';
				rep_patient_high_risk_ind.len    = 0;
				rep_customer_id.arr[0] = '\0';
				rep_customer_id.len    = 0;
				rep_source_desc_on_label.arr[0] = '\0';
				rep_source_desc_on_label.len    = 0;
				rep_alternate_id.arr[0] = '\0';
				rep_alternate_id.len    = 0;
				rep_ord_date_time.arr[0] = '\0';
				rep_ord_date_time.len    = 0;
				rep_source_code.arr[0] = '\0';
				rep_source_code.len    = 0;
				rep_histo_yn.arr[0] = '\0';
				rep_histo_yn.len    = 0;
				rep_test_desc.arr[0] = '\0';
				rep_test_desc.len    = 0;
				rep_label_desc.arr[0] = '\0';
				rep_label_desc.len    = 0;
				rep_anatomy_site_desc.arr[0] = '\0';
				rep_anatomy_site_desc.len    = 0;
				rep_tissue_type_desc.arr[0] = '\0';
				rep_tissue_type_desc.len    = 0;

				rep_volume_unit.arr[0] = '\0';
				rep_volume_unit.len    = 0;
				rep_test_code.arr[0] = '\0';
				rep_test_code.len    = 0;
				rep_spec_type_code.arr[0] = '\0';
				rep_spec_type_code.len    = 0;
				rep_spec_regd_date.arr[0] = '\0';
				rep_spec_regd_date.len    = 0;
				rep_sex.arr[0] = '\0';
				rep_sex.len    = 0;
				rep_rowid.arr[0] = '\0';
				rep_rowid.len    = 0;
				rep_pgm_id.arr[0] = '\0';
				rep_pgm_id.len    = 0;
				rep_dob.arr[0] = '\0';
				rep_dob.len    = 0;
				rep_episode_type.arr[0] = '\0';
				rep_episode_type.len    = 0;				


				strcpy(rep_specimen_no.arr,lr_specimen_no[v_i].arr);
				rep_specimen_no.len = strlen(rep_specimen_no.arr);
				rep_specimen_no.arr[rep_specimen_no.len] = '\0';

				strcpy(rep_pat_name.arr,lr_patient_name[v_i].arr);
				rep_pat_name.len = strlen(rep_pat_name.arr);
				rep_pat_name.arr[rep_pat_name.len] = '\0';

				strcpy(rep_facility_name.arr,lr_facility_name[v_i].arr);
				rep_facility_name.len = strlen(rep_facility_name.arr);
				rep_facility_name.arr[rep_facility_name.len] = '\0';

				strcpy(rep_priority.arr,lr_priority[v_i].arr);
				rep_priority.len = strlen(rep_priority.arr);
				rep_priority.arr[rep_priority.len] = '\0';

				strcpy(rep_patient_id.arr,lr_patient_id[v_i].arr);
				rep_patient_id.len = strlen(rep_patient_id.arr);
				rep_patient_id.arr[rep_patient_id.len] = '\0';

				strcpy(rep_sample_id.arr,lr_sample_id[v_i].arr);
				rep_sample_id.len = strlen(rep_sample_id.arr);
				rep_sample_id.arr[rep_sample_id.len] = '\0';

				strcpy(rep_category_code.arr,lr_category_code[v_i].arr);
				rep_category_code.len = strlen(rep_category_code.arr);
				rep_category_code.arr[rep_category_code.len] = '\0';

				strcpy(rep_category_year.arr,lr_category_year[v_i].arr);
				rep_category_year.len = strlen(rep_category_year.arr);
				rep_category_year.arr[rep_category_year.len] = '\0';

				strcpy(rep_category_no.arr,lr_category_no[v_i].arr);
				rep_category_no.len = strlen(rep_category_no.arr);
				rep_category_no.arr[rep_category_no.len] = '\0';

				strcpy(rep_unit_no.arr,lr_unit_no[v_i].arr);
				rep_unit_no.len = strlen(rep_unit_no.arr);
				rep_unit_no.arr[rep_unit_no.len] = '\0';

				strcpy(rep_patient_high_risk_ind.arr,lr_patient_high_risk_ind[v_i].arr);
				rep_patient_high_risk_ind.len = strlen(rep_patient_high_risk_ind.arr);
				rep_patient_high_risk_ind.arr[rep_patient_high_risk_ind.len] = '\0';

				strcpy(rep_customer_id.arr,lr_customer_id[v_i].arr);
				rep_customer_id.len = strlen(rep_customer_id.arr);
				rep_customer_id.arr[rep_customer_id.len] = '\0';

				strcpy(rep_source_desc_on_label.arr,lr_source_desc_on_label[v_i].arr);
				rep_source_desc_on_label.len = strlen(rep_source_desc_on_label.arr);
				rep_source_desc_on_label.arr[rep_source_desc_on_label.len] = '\0';

				strcpy(rep_alternate_id.arr,lr_alternate_id[v_i].arr);
				rep_alternate_id.len = strlen(rep_alternate_id.arr);
				rep_alternate_id.arr[rep_alternate_id.len] = '\0';

				strcpy(rep_ord_date_time.arr,lr_ord_date_time[v_i].arr);
				rep_ord_date_time.len = strlen(rep_ord_date_time.arr);
				rep_ord_date_time.arr[rep_ord_date_time.len] = '\0';

				strcpy(rep_source_code.arr,lr_source_code[v_i].arr);
				rep_source_code.len = strlen(rep_source_code.arr);
				rep_source_code.arr[rep_source_code.len] = '\0';

				strcpy(rep_histo_yn.arr,lr_histo_yn[v_i].arr);
				rep_histo_yn.len = strlen(rep_histo_yn.arr);
				rep_histo_yn.arr[rep_histo_yn.len] = '\0';

				strcpy(rep_test_desc.arr,lr_test_name[v_i].arr);
				rep_test_desc.len = strlen(rep_test_desc.arr);
				rep_test_desc.arr[rep_test_desc.len] = '\0';

				strcpy(rep_label_desc.arr,lr_label_desc[v_i].arr);
				rep_label_desc.len = strlen(rep_label_desc.arr);
				rep_label_desc.arr[rep_label_desc.len] = '\0';

				strcpy(rep_anatomy_site_desc.arr,lr_anatomy_site_desc[v_i].arr);
				rep_anatomy_site_desc.len = strlen(rep_anatomy_site_desc.arr);
				rep_anatomy_site_desc.arr[rep_anatomy_site_desc.len] = '\0';

				strcpy(rep_tissue_type_desc.arr,lr_tissue_desc[v_i].arr);
				rep_tissue_type_desc.len = strlen(rep_tissue_type_desc.arr);
				rep_tissue_type_desc.arr[rep_tissue_type_desc.len] = '\0';

				strcpy(rep_volume_unit.arr,lr_volume_unit[v_i].arr);
				rep_volume_unit.len = strlen(rep_volume_unit.arr);
				rep_volume_unit.arr[rep_volume_unit.len] = '\0';

				strcpy(rep_test_code.arr,lr_test_code[v_i].arr);
				rep_test_code.len = strlen(rep_test_code.arr);
				rep_test_code.arr[rep_test_code.len] = '\0';

				strcpy(rep_spec_type_code.arr,lr_spec_type_code[v_i].arr);
				rep_spec_type_code.len = strlen(rep_spec_type_code.arr);
				rep_spec_type_code.arr[rep_spec_type_code.len] = '\0';

				strcpy(rep_spec_regd_date.arr,lr_spec_date_time[v_i].arr);
				rep_spec_regd_date.len = strlen(rep_spec_regd_date.arr);
				rep_spec_regd_date.arr[rep_spec_regd_date.len] = '\0';

				strcpy(rep_sex.arr,lr_sex[v_i].arr);
				rep_sex.len = strlen(rep_sex.arr);
				rep_sex.arr[rep_sex.len] = '\0';   

				strcpy(rep_pgm_id.arr,lr_pgm_id[v_i].arr);
				rep_pgm_id.len = strlen(rep_pgm_id.arr);
				rep_pgm_id.arr[rep_pgm_id.len] = '\0';

				strcpy(rep_dob.arr,lr_dob[v_i].arr);
				rep_dob.len = strlen(rep_dob.arr);
				rep_dob.arr[rep_dob.len] = '\0';

				strcpy(rep_episode_type.arr,lr_episode_type[v_i].arr);
				rep_episode_type.len = strlen(rep_episode_type.arr);
				rep_episode_type.arr[rep_episode_type.len] = '\0';

				printcopies_rw = lr_no_of_labels[v_i];


				if (strcmp(reprint_yn,"Y") == 0)
				{
					printcopies_rw = d_NumOfCopies;
				}

    nd_print_source_type.len = strlen(nd_print_source_type.arr);
    nd_print_source_type.arr[nd_print_source_type.len] = '\0';

    nd_print_source.len = strlen(nd_print_source.arr);
    nd_print_source.arr[nd_print_source.len] = '\0';

///	disp_message(ERR_MESG,"b4 submitting oracle report");
	sprintf(string_var,"print source type=%s=print source code=%s=",nd_print_source_type.arr,nd_print_source.arr);
//	disp_message(ERR_MESG,string_var);

///	sprintf(string_var,"package pgmid=%s=facilityname=%s,numcopies=%d,apgmid=%s",rep_pgm_id.arr,rep_facility_name.arr,printcopies_rw,a_pgm_id.arr);
///	disp_message(ERR_MESG,string_var);

///	sprintf(string_var,"package episodetype=%s=rep episode type=%s",lr_episode_type[v_i].arr,rep_episode_type);
///	disp_message(ERR_MESG,string_var);

				/* EXEC SQL EXECUTE 
				DECLARE
					v_cnt NUMBER := 1;
					p_print_status Boolean;
					p_error_text VARCHAR2(800);
				BEGIN 

					APPPRINT.SUBMIT_ORACLE_REPORT 
					 (:a_ws_no,						//P_WORKSTATION_ID
					  :a_facility_id,				//P_FACILITY_ID
					  'RL',							//P_MODULE_ID
					  :a_pgm_id,					//P_DOCUMENT_ID
					  'P',							//P_REPORT_OPTION
					  NULL,							//P_OUTPUTFILE_FORMAT
					  NULL,							//P_OUTPUTFILE_NAME
					  :nd_print_source_type,		//P_LOCATION_TYPE
					  :nd_print_source,				//P_LOCATION_CODE
					  null,							//P_PRINTER_NAME
					  :printcopies_rw,				//P_NUMBER_OF_COPIES
					  NULL,							//P_PAGE_FROM
					  NULL,							//P_PAGE_TO 
					  NULL,							//P_PRINT_MODE
					  'SESSION_ID='||:nd_session_id
					  ||'+REQ_DATE='||to_char(sysdate,'ddmmyyyyhh24miss')  
					  ||'+OPERATING_FACILITY_ID='||:a_facility_id
					  ||'+USER_ID=' ||:l_user
					  ||'+P_SPECIMEN_NO='||:rep_specimen_no
					  ||'+P_PATIENT_NAME='||:rep_pat_name
					  ||'+P_FACILITY='||:rep_facility_name 
					  ||'+P_PRIORITY='||:rep_priority
					  ||'+P_PATIENT_ID='||:rep_patient_id
					  ||'+P_SAMPLE_ID='||:rep_sample_id
					  ||'+P_CATEGORY_CODE='||:rep_category_code
					  ||'+P_CATEGORY_YEAR='||:rep_category_year
					  ||'+P_CATEGORY_NO='||:rep_category_no
					  ||'+P_UNIT_NO='||:rep_unit_no
					  ||'+P_PATIENT_HIGH_RISK_IND='||:rep_patient_high_risk_ind
					  ||'+P_CUSTOMER_ID='||:rep_customer_id
					  ||'+P_SOURCE_DESC_ON_LABEL='||:rep_source_desc_on_label
					  ||'+P_ALTERNATE_ID='||:rep_alternate_id
					  ||'+P_ORD_DATE_TIME='||:rep_ord_date_time
					  ||'+P_SOURCE_CODE='||:rep_source_code
					  ||'+P_HISTO_YN='||:rep_histo_yn
					  ||'+P_TEST_DESC='||:rep_test_desc
					  ||'+P_LABEL_DESC='||:rep_label_desc
					  ||'+P_ANATOMY_SITE_DESC='||:rep_anatomy_site_desc
					  ||'+P_TISSUE_TYPE_DESC='||:rep_tissue_type_desc
					  ||'+P_VOLUME_UNIT='||:rep_volume_unit
					  ||'+P_TEST_CODE='||:rep_test_code
					  ||'+P_SPEC_TYPE_CODE='||:rep_spec_type_code
					  ||'+P_SPEC_REGD_DATE='||:rep_spec_regd_date
					  ||'+P_SEX='||:rep_sex
					  ||'+P_ROWID='||:rep_rowid
					  ||'+P_PGM_ID='||:rep_pgm_id
					  ||'+P_DOB='||:rep_dob
					  ||'+P_EPISODE_TYPE='||:rep_episode_type,		//P_PARAM_LIST  
					  p_print_status,				//P_PRINT_STATUS   out
					  p_error_text);				//P_ERROR_TEXT     out 

				END; 
				END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 38;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "declare v_cnt NUMBER := 1 ; p_print_status Boolean ; p_error_text VAR\
CHAR2 ( 800 ) ; BEGIN APPPRINT . SUBMIT_ORACLE_REPORT ( :a_ws_no , :a_facili\
ty_id , 'RL' , :a_pgm_id , 'P' , NULL , NULL , :nd_print_source_type , :nd_p\
rint_source , null , :printcopies_rw , NULL , NULL , NULL , 'SESSION_ID=' ||\
 :nd_session_id || '+REQ_DATE=' || to_char ( sysdate , 'ddmmyyyyhh24miss' ) \
|| '+OPERATING_FACILITY_ID=' || :a_facility_id || '+USER_ID=' || :l_user || \
'+P_SPECIMEN_NO=' || :rep_specimen_no || '+P_PATIENT_NAME=' || :rep_pat_name\
 || '+P_FACILITY=' || :rep_facility_name || '+P_PRIORITY=' || :rep_priority \
|| '+P_PATIENT_ID=' || :rep_patient_id || '+P_SAMPLE_ID=' || :rep_sample_id \
|| '+P_CATEGORY_CODE=' || :rep_category_code || '+P_CATEGORY_YEAR=' || :rep_\
category_year || '+P_CATEGORY_NO=' || :rep_category_no || '+P_UNIT_NO=' || :\
rep_unit_no || '+P_PATIENT_HIGH_RISK_IND=' || :rep_patient_high_risk_ind || \
'+P_CUSTOMER_ID=' || :rep_customer_id || '+P_SOURCE_DESC_ON_LABEL=' || :rep_\
source_desc_on_label || '+P_ALTERNATE_ID=' ");
    sqlstm.stmt = "|| :rep_alternate_id || '+P_ORD_DATE_TIME=' || :rep_ord_d\
ate_time || '+P_SOURCE_CODE=' || :rep_source_code || '+P_HISTO_YN=' || :rep_hi\
sto_yn || '+P_TEST_DESC=' || :rep_test_desc || '+P_LABEL_DESC=' || :rep_label_\
desc || '+P_ANATOMY_SITE_DESC=' || :rep_anatomy_site_desc || '+P_TISSUE_TYPE_D\
ESC=' || :rep_tissue_type_desc || '+P_VOLUME_UNIT=' || :rep_volume_unit || '+P\
_TEST_CODE=' || :rep_test_code || '+P_SPEC_TYPE_CODE=' || :rep_spec_type_code \
|| '+P_SPEC_REGD_DATE=' || :rep_spec_regd_date || '+P_SEX=' || :rep_sex || '+P\
_ROWID=' || :rep_rowid || '+P_PGM_ID=' || :rep_pgm_id || '+P_DOB=' || :rep_dob\
 || '+P_EPISODE_TYPE=' || :rep_episode_type , p_print_status , p_error_text ) \
; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )135;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&a_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&a_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )43;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&a_pgm_id;
    sqlstm.sqhstl[2] = (unsigned int  )43;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_print_source_type;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_print_source;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&printcopies_rw;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[6] = (unsigned int  )52;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&l_user;
    sqlstm.sqhstl[7] = (unsigned int  )302;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&rep_specimen_no;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&rep_pat_name;
    sqlstm.sqhstl[9] = (unsigned int  )163;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&rep_facility_name;
    sqlstm.sqhstl[10] = (unsigned int  )143;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&rep_priority;
    sqlstm.sqhstl[11] = (unsigned int  )23;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&rep_patient_id;
    sqlstm.sqhstl[12] = (unsigned int  )143;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&rep_sample_id;
    sqlstm.sqhstl[13] = (unsigned int  )23;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&rep_category_code;
    sqlstm.sqhstl[14] = (unsigned int  )23;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&rep_category_year;
    sqlstm.sqhstl[15] = (unsigned int  )23;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&rep_category_no;
    sqlstm.sqhstl[16] = (unsigned int  )43;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&rep_unit_no;
    sqlstm.sqhstl[17] = (unsigned int  )143;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&rep_patient_high_risk_ind;
    sqlstm.sqhstl[18] = (unsigned int  )13;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&rep_customer_id;
    sqlstm.sqhstl[19] = (unsigned int  )142;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&rep_source_desc_on_label;
    sqlstm.sqhstl[20] = (unsigned int  )103;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&rep_alternate_id;
    sqlstm.sqhstl[21] = (unsigned int  )143;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&rep_ord_date_time;
    sqlstm.sqhstl[22] = (unsigned int  )143;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&rep_source_code;
    sqlstm.sqhstl[23] = (unsigned int  )43;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&rep_histo_yn;
    sqlstm.sqhstl[24] = (unsigned int  )6;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&rep_test_desc;
    sqlstm.sqhstl[25] = (unsigned int  )3952;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&rep_label_desc;
    sqlstm.sqhstl[26] = (unsigned int  )3952;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&rep_anatomy_site_desc;
    sqlstm.sqhstl[27] = (unsigned int  )3952;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&rep_tissue_type_desc;
    sqlstm.sqhstl[28] = (unsigned int  )3952;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&rep_volume_unit;
    sqlstm.sqhstl[29] = (unsigned int  )113;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&rep_test_code;
    sqlstm.sqhstl[30] = (unsigned int  )3952;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&rep_spec_type_code;
    sqlstm.sqhstl[31] = (unsigned int  )243;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqhstv[32] = (         void  *)&rep_spec_regd_date;
    sqlstm.sqhstl[32] = (unsigned int  )43;
    sqlstm.sqhsts[32] = (         int  )0;
    sqlstm.sqindv[32] = (         void  *)0;
    sqlstm.sqinds[32] = (         int  )0;
    sqlstm.sqharm[32] = (unsigned int  )0;
    sqlstm.sqadto[32] = (unsigned short )0;
    sqlstm.sqtdso[32] = (unsigned short )0;
    sqlstm.sqhstv[33] = (         void  *)&rep_sex;
    sqlstm.sqhstl[33] = (unsigned int  )13;
    sqlstm.sqhsts[33] = (         int  )0;
    sqlstm.sqindv[33] = (         void  *)0;
    sqlstm.sqinds[33] = (         int  )0;
    sqlstm.sqharm[33] = (unsigned int  )0;
    sqlstm.sqadto[33] = (unsigned short )0;
    sqlstm.sqtdso[33] = (unsigned short )0;
    sqlstm.sqhstv[34] = (         void  *)&rep_rowid;
    sqlstm.sqhstl[34] = (unsigned int  )43;
    sqlstm.sqhsts[34] = (         int  )0;
    sqlstm.sqindv[34] = (         void  *)0;
    sqlstm.sqinds[34] = (         int  )0;
    sqlstm.sqharm[34] = (unsigned int  )0;
    sqlstm.sqadto[34] = (unsigned short )0;
    sqlstm.sqtdso[34] = (unsigned short )0;
    sqlstm.sqhstv[35] = (         void  *)&rep_pgm_id;
    sqlstm.sqhstl[35] = (unsigned int  )23;
    sqlstm.sqhsts[35] = (         int  )0;
    sqlstm.sqindv[35] = (         void  *)0;
    sqlstm.sqinds[35] = (         int  )0;
    sqlstm.sqharm[35] = (unsigned int  )0;
    sqlstm.sqadto[35] = (unsigned short )0;
    sqlstm.sqtdso[35] = (unsigned short )0;
    sqlstm.sqhstv[36] = (         void  *)&rep_dob;
    sqlstm.sqhstl[36] = (unsigned int  )43;
    sqlstm.sqhsts[36] = (         int  )0;
    sqlstm.sqindv[36] = (         void  *)0;
    sqlstm.sqinds[36] = (         int  )0;
    sqlstm.sqharm[36] = (unsigned int  )0;
    sqlstm.sqadto[36] = (unsigned short )0;
    sqlstm.sqtdso[36] = (unsigned short )0;
    sqlstm.sqhstv[37] = (         void  *)&rep_episode_type;
    sqlstm.sqhstl[37] = (unsigned int  )43;
    sqlstm.sqhsts[37] = (         int  )0;
    sqlstm.sqindv[37] = (         void  *)0;
    sqlstm.sqinds[37] = (         int  )0;
    sqlstm.sqharm[37] = (unsigned int  )0;
    sqlstm.sqadto[37] = (unsigned short )0;
    sqlstm.sqtdso[37] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

  

////				disp_message(ERR_MESG,"after submitting oracle report");
			}
			else
			{	
				/*-- Addded by Gopikannan for online_barcode_label --*/
				
			
			   if (strcmp(l_customer_id.arr,"MC") == 0 || strcmp(l_customer_id.arr,"KDAH") == 0 || strcmp(l_customer_id.arr,"MOHBR") == 0)
			    {
					online_barcode_label(lr_no_of_labels[v_i]); 
			    }
			    else
			    { 
//disp_message(ERR_MESG,"before calling print barcode label");
					print_barcode_label(lr_no_of_labels[v_i]); 					
//disp_message(ERR_MESG,"after calling print barcode label");
  			    }
			  
			}

		}

	}

}

/******************* added on 28.07.2003 ********/
get_printer_type()
{

	  strcpy(nd_printer_type.arr, "3");
	  nd_printer_type.len = strlen(nd_printer_type.arr);

	  /* EXEC SQL SELECT NVL(printer_type, '1')
  	           INTO  :nd_printer_type
  	           FROM   SY_ONLINE_PRINT_ID
	           WHERE  module_id = 'RL'
	           AND    online_print_name = :a_pgm_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 38;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(printer_type,'1') into :b0  from SY_ONLINE_PRIN\
T_ID where (module_id='RL' and online_print_name=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )302;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_printer_type;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&a_pgm_id;
   sqlstm.sqhstl[1] = (unsigned int  )43;
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

 

        if(NO_DATA_FOUND)
   		strcpy(nd_printer_type.arr, "3");
		nd_printer_type.len = strlen(nd_printer_type.arr);
  	  if(OERROR)
   		strcpy(nd_printer_type.arr, "3");
		nd_printer_type.len = strlen(nd_printer_type.arr);

	  nd_printer_type.arr[nd_printer_type.len]  = '\0';
	  nd_printer_type.len = 0;

}
get_thai_lang()
{

	nd_thai_lang_yn.arr[0]	=	'\0';
	nd_thai_lang_yn.len		= 0;

	  strcpy(nd_thai_lang_yn.arr, "N");
	  nd_thai_lang_yn.len = strlen(nd_thai_lang_yn.arr);

	  /* EXEC SQL SELECT 'Y'
  	           INTO  :nd_thai_lang_yn
  	           FROM   SM_LANGUAGE
	           WHERE  language_id = 'th'; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 38;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select 'Y' into :b0  from SM_LANGUAGE where language_id='t\
h'";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )325;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_thai_lang_yn;
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

 

        if(NO_DATA_FOUND);

	    if(OERROR);

	  nd_thai_lang_yn.arr[nd_thai_lang_yn.len]  = '\0';
	  nd_thai_lang_yn.len = 0;

}

call_pkg_rllabels()
{

/*
    sprintf(string_char,"a_pgm_id %s ", a_pgm_id.arr);
	disp_message(INFO_MESG, string_char);
    sprintf(string_char,"a_session_id %s ", a_session_id.arr);
	disp_message(INFO_MESG, string_char);
    sprintf(string_char,"a_facility_id %s ", a_facility_id.arr);
	disp_message(INFO_MESG, string_char);
    sprintf(string_char,"a_spec_ord_no %s ", a_spec_ord_no.arr);
	disp_message(INFO_MESG, string_char);
    sprintf(string_char,"a_sec_ord_type %s ", a_sec_ord_type.arr);
	disp_message(INFO_MESG, string_char);
    sprintf(string_char,"a_test_code %s ", a_test_code.arr);
	disp_message(INFO_MESG, string_char);
    sprintf(string_char,"a_ws_no %s ", a_ws_no.arr);
	disp_message(INFO_MESG, string_char);
    sprintf(string_char,"BEFORE no of labels %d ", h_no_of_rec);
	disp_message(INFO_MESG, string_char);

*/
//// modified on 06.07.2015 against HSA-CRF-0274 time part added to the spec collected date.

/// disp_message(ERR_MESG,"after calling the pacakge");

	/* EXEC SQL EXECUTE 
	DECLARE
		label_r rllabels.label_tab_type;
		v_cnt NUMBER := 1;
	BEGIN 
			rllabels.GENERATE_LABEL( :a_pgm_id,
									 :a_session_id,
									 :a_facility_id,
									 :a_spec_ord_no,
								     :a_sec_ord_type,
									 :a_test_code,
									 :a_ws_no,
									 :language_id,          /o Added by Durai Rajkumar for Thai Conv o/
									 label_r);
	  :h_no_of_rec := label_r.COUNT;

///disp_message(INFO_MESG,"after calling the pacakge");

	  FOR i in 1..label_r.COUNT
	  LOOP
		:lr_facility_name(v_cnt) := label_r(v_cnt).facility_name;
		IF label_r(v_cnt).label_desc IS NOT NULL THEN
			:lr_label_desc(v_cnt)    := label_r(v_cnt).label_desc;
		ELSE
				:lr_label_desc(v_cnt)    := ' ';
		END IF;
		IF label_r(v_cnt).cont_volume IS NOT NULL THEN
			:lr_cont_volume(v_cnt)   := label_r(v_cnt).cont_volume;
		ELSE
			:lr_cont_volume(v_cnt)   := -1;
		END IF;
		IF label_r(v_cnt).volume_unit IS NOT NULL THEN
			:lr_volume_unit(v_cnt)   := label_r(v_cnt).volume_unit;
		ELSE
			:lr_volume_unit(v_cnt)   := ' ';
		END IF;
		IF label_r(v_cnt).specimen_no IS NOT NULL THEN
			:lr_specimen_no(v_cnt)   := label_r(v_cnt).specimen_no;
		ELSE
			:lr_specimen_no(v_cnt)   := ' ';
		END IF;

		IF label_r(v_cnt).patient_high_risk_ind IS NOT NULL THEN   ///13.09.2008 against ML-SD-CRF-20232
			:lr_patient_high_risk_ind(v_cnt)   := label_r(v_cnt).patient_high_risk_ind;
		ELSE
			:lr_patient_high_risk_ind(v_cnt)   := ' ';
		END IF;
		
		IF label_r(v_cnt).sample_id IS NOT NULL THEN
			:lr_sample_id(v_cnt)     := label_r(v_cnt).sample_id;
		ELSE
			:lr_sample_id(v_cnt)     := ' ';
		END IF;
		IF label_r(v_cnt).category_code IS NOT NULL THEN
			:lr_category_code(v_cnt) := label_r(v_cnt).category_code;
		ELSE
			:lr_category_code(v_cnt) := ' ';
		END IF;
		IF label_r(v_cnt).category_year IS NOT NULL THEN
			:lr_category_year(v_cnt) := label_r(v_cnt).category_year;
		ELSE
			:lr_category_year(v_cnt) := ' ';
		END IF;
		IF label_r(v_cnt).category_no IS NOT NULL THEN
			:lr_category_no(v_cnt)   := label_r(v_cnt).category_no;
		ELSE
			:lr_category_no(v_cnt)   := ' '; 
		END IF;
		IF label_r(v_cnt).priority IS NOT NULL THEN
			:lr_priority(v_cnt)      := INITCAP(label_r(v_cnt).priority);
		ELSE
			:lr_priority(v_cnt)      := ' ';
		END IF;
		IF label_r(v_cnt).spec_date_time IS NOT NULL THEN
			:lr_spec_date_time(v_cnt) := label_r(v_cnt).spec_date_time;
		ELSE
			:lr_spec_date_time(v_cnt) := ' ';
		END IF;
		IF label_r(v_cnt).patient_name IS NOT NULL THEN
			:lr_patient_name(v_cnt)  := label_r(v_cnt).patient_name;
		ELSE
			:lr_patient_name(v_cnt)  := ' '; 
		END IF;
		IF label_r(v_cnt).source_code IS NOT NULL THEN
			:lr_source_code(v_cnt)   := label_r(v_cnt).source_code;
		ELSE
			:lr_source_code(v_cnt)   := ' ';
		END IF;
		IF label_r(v_cnt).episode_type IS NOT NULL THEN
			:lr_episode_type(v_cnt)   := label_r(v_cnt).episode_type;
		ELSE
			:lr_episode_type(v_cnt)   := ' ';
		END IF;

		IF label_r(v_cnt).source_type IS NOT NULL THEN
			:lr_source_type(v_cnt)   := label_r(v_cnt).source_type;
		ELSE
			:lr_source_type(v_cnt)   := ' ';
		END IF;

		IF label_r(v_cnt).source_desc IS NOT NULL THEN
			:lr_source_desc(v_cnt)   := label_r(v_cnt).source_desc;
		ELSE
			:lr_source_desc(v_cnt)   := ' ';
		END IF;

		IF label_r(v_cnt).source_desc_on_label IS NOT NULL THEN
			:lr_source_desc_on_label(v_cnt)   := label_r(v_cnt).source_desc_on_label;
		ELSE
			:lr_source_desc_on_label(v_cnt)   := ' ';
		END IF;

		IF label_r(v_cnt).anatomy_site IS NOT NULL THEN
			:lr_anatomy_site(v_cnt)  := label_r(v_cnt).anatomy_site;
		ELSE
			:lr_anatomy_site(v_cnt)  := ' ';
		END IF;
		IF label_r(v_cnt).anatomy_site_desc IS NOT NULL THEN
			:lr_anatomy_site_desc(v_cnt) := label_r(v_cnt).anatomy_site_desc;
		ELSE
			:lr_anatomy_site_desc(v_cnt) := ' ';
		END IF;
		IF label_r(v_cnt).tissue_desc IS NOT NULL THEN
			:lr_tissue_desc(v_cnt)   := label_r(v_cnt).tissue_desc;
		ELSE
			:lr_tissue_desc(v_cnt)   := ' ';
		END IF;
		IF label_r(v_cnt).histo_yn IS NOT NULL THEN
			:lr_histo_yn(v_cnt)   := label_r(v_cnt).histo_yn;
		ELSE
			:lr_histo_yn(v_cnt)   := ' ';
		END IF;
		IF label_r(v_cnt).patient_id IS NOT NULL THEN
			:lr_patient_id(v_cnt)       := label_r(v_cnt).patient_id;
		ELSE
			:lr_patient_id(v_cnt)       := ' ';
		END IF;
		IF label_r(v_cnt).sex IS NOT NULL THEN
			:lr_sex(v_cnt)           := label_r(v_cnt).sex;
		ELSE
			:lr_sex(v_cnt)           := ' ';
		END IF;
		IF label_r(v_cnt).dob IS NOT NULL THEN
			:lr_dob(v_cnt)           := label_r(v_cnt).dob;
		ELSE
			:lr_dob(v_cnt)           := ' ';
		END IF;
		IF label_r(v_cnt).alternate_id IS NOT NULL THEN
			:lr_alternate_id(v_cnt)  := label_r(v_cnt).alternate_id;
		ELSE
			:lr_alternate_id(v_cnt)  := ' ';
		END IF;
		IF label_r(v_cnt).unit_no IS NOT NULL THEN
			:lr_unit_no(v_cnt)  := label_r(v_cnt).unit_no;
		ELSE
			:lr_unit_no(v_cnt)  := ' ';
		END IF;

		IF label_r(v_cnt).ord_date_time IS NOT NULL THEN
			:lr_ord_date_time(v_cnt)  := label_r(v_cnt).ord_date_time;
			
			IF label_r(v_cnt).customer_id = 'SHALM' THEN
				:lr_ord_date_time(v_cnt)  := TO_CHAR(TO_DATE(label_r(v_cnt).spec_date_time1,'DD/MM/YYYY HH24:MI'),'DD/MM/YY HH24:MI');
			END IF;
			
		ELSE
			:lr_ord_date_time(v_cnt)  := ' ';

			IF :a_pgm_id = 'RLRSPCLB' THEN  /// 13.09.2008 against ML-SD-CRF-20282
			    :lr_ord_date_time(v_cnt)  := TO_CHAR(TO_DATE(label_r(v_cnt).spec_date_time,'DD/MM/YYYY HH24:MI'),'DD/MM/YY HH24:MI');
				
				IF label_r(v_cnt).customer_id = 'SHALM' THEN
					:lr_ord_date_time(v_cnt)  := TO_CHAR(TO_DATE(label_r(v_cnt).spec_date_time1,'DD/MM/YYYY HH24:MI'),'DD/MM/YY HH24:MI');
				END IF;

			END IF;

		END IF;
		IF label_r(v_cnt).alternate_id_type IS NOT NULL THEN
			:lr_alternate_id_type(v_cnt)  := label_r(v_cnt).alternate_id_type;
		ELSE
			:lr_alternate_id_type(v_cnt)  := ' ';
		END IF;
		IF label_r(v_cnt).test_code IS NOT NULL THEN
			:lr_test_code(v_cnt)     := label_r(v_cnt).test_code;
		ELSE
			:lr_test_code(v_cnt)     := ' ';
		END IF;
		IF label_r(v_cnt).test_name IS NOT NULL THEN
			:lr_test_name(v_cnt)     := label_r(v_cnt).test_name;
		ELSE
			:lr_test_name(v_cnt)     := ' ';
		END IF;
		IF label_r(v_cnt).test_desc IS NOT NULL THEN
			:lr_test_desc(v_cnt)     := label_r(v_cnt).test_desc;
		ELSE
			:lr_test_desc(v_cnt)     := ' ';
		END IF;
		IF label_r(v_cnt).no_of_labels IS NOT NULL THEN
			:lr_no_of_labels(v_cnt)  := label_r(v_cnt).no_of_labels;
			IF label_r(v_cnt).no_of_labels = 0 THEN
				:lr_no_of_labels(v_cnt)  := 1;
			END IF;
		ELSE
			:lr_no_of_labels(v_cnt)  := -1;
		END IF;
		IF label_r(v_cnt).pgm_id IS NOT NULL THEN
			:lr_pgm_id(v_cnt)        := label_r(v_cnt).pgm_id;
		ELSE
			:lr_pgm_id(v_cnt)        := ' ';
		END IF;
		IF label_r(v_cnt).spec_type_code IS NOT NULL THEN
			:lr_spec_type_code(v_cnt) := label_r(v_cnt).spec_type_code;
		ELSE
			:lr_spec_type_code(v_cnt) := ' ';
		END IF;
		IF label_r(v_cnt).module_id IS NOT NULL THEN
			:lr_module_id(v_cnt) := label_r(v_cnt).module_id;
		ELSE
			:lr_module_id(v_cnt) := ' ';
		END IF;

		IF label_r(v_cnt).customer_id IS NOT NULL THEN
			:lr_customer_id(v_cnt) := label_r(v_cnt).customer_id;
		ELSE
			:lr_customer_id(v_cnt) := ' ';
		END IF;

		v_cnt := v_cnt  + 1;
	  END LOOP;
	END; 
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "declare label_r rllabels . label_tab_type ; v_cnt NUMBER := 1 ; BEGIN rl\
labels . GENERATE_LABEL ( :a_pgm_id , :a_session_id , :a_facility_id , :a_sp\
ec_ord_no , :a_sec_ord_type , :a_test_code , :a_ws_no , :language_id , label\
_r ) ; :h_no_of_rec := label_r . COUNT ; FOR i in 1 .. label_r . COUNT LOOP \
:lr_facility_name ( v_cnt ) := label_r ( v_cnt ) . facility_name ; IF label_\
r ( v_cnt ) . label_desc IS NOT NULL THEN :lr_label_desc ( v_cnt ) := label_\
r ( v_cnt ) . label_desc ; ELSE :lr_label_desc ( v_cnt ) := ' ' ; END IF ; I\
F label_r ( v_cnt ) . cont_volume IS NOT NULL THEN :lr_cont_volume ( v_cnt )\
 := label_r ( v_cnt ) . cont_volume ; ELSE :lr_cont_volume ( v_cnt ) := -1 ;\
 END IF ; IF label_r ( v_cnt ) . volume_unit IS NOT NULL THEN :lr_volume_uni\
t ( v_cnt ) := label_r ( v_cnt ) . volume_unit ; ELSE :lr_volume_unit ( v_cn\
t ) := ' ' ; END IF ; IF label_r ( v_cnt ) . specimen_no IS NOT NULL THEN :l\
r_specimen_no ( v_cnt ) := label_r ( v_cnt ) . specimen_no ; ELSE :lr_specim\
en_no ( v_cnt ) := ' ' ; END IF ; IF lab");
 sqlbuft((void **)0, 
   "el_r ( v_cnt ) . patient_high_risk_ind IS NOT NULL THEN :lr_patient_high\
_risk_ind ( v_cnt ) := label_r ( v_cnt ) . patient_high_risk_ind ; ELSE :lr_\
patient_high_risk_ind ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . sam\
ple_id IS NOT NULL THEN :lr_sample_id ( v_cnt ) := label_r ( v_cnt ) . sampl\
e_id ; ELSE :lr_sample_id ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) .\
 category_code IS NOT NULL THEN :lr_category_code ( v_cnt ) := label_r ( v_c\
nt ) . category_code ; ELSE :lr_category_code ( v_cnt ) := ' ' ; END IF ; IF\
 label_r ( v_cnt ) . category_year IS NOT NULL THEN :lr_category_year ( v_cn\
t ) := label_r ( v_cnt ) . category_year ; ELSE :lr_category_year ( v_cnt ) \
:= ' ' ; END IF ; IF label_r ( v_cnt ) . category_no IS NOT NULL THEN :lr_ca\
tegory_no ( v_cnt ) := label_r ( v_cnt ) . category_no ; ELSE :lr_category_n\
o ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . priority IS NOT NULL TH\
EN :lr_priority ( v_cnt ) := INITCAP ( label_r ( v_cnt ) . priority ) ; ELSE\
 :lr_priority ( v_cnt ) := ' ' ; END IF ");
 sqlbuft((void **)0, 
   "; IF label_r ( v_cnt ) . spec_date_time IS NOT NULL THEN :lr_spec_date_t\
ime ( v_cnt ) := label_r ( v_cnt ) . spec_date_time ; ELSE :lr_spec_date_tim\
e ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . patient_name IS NOT NUL\
L THEN :lr_patient_name ( v_cnt ) := label_r ( v_cnt ) . patient_name ; ELSE\
 :lr_patient_name ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . source_\
code IS NOT NULL THEN :lr_source_code ( v_cnt ) := label_r ( v_cnt ) . sourc\
e_code ; ELSE :lr_source_code ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt\
 ) . episode_type IS NOT NULL THEN :lr_episode_type ( v_cnt ) := label_r ( v\
_cnt ) . episode_type ; ELSE :lr_episode_type ( v_cnt ) := ' ' ; END IF ; IF\
 label_r ( v_cnt ) . source_type IS NOT NULL THEN :lr_source_type ( v_cnt ) \
:= label_r ( v_cnt ) . source_type ; ELSE :lr_source_type ( v_cnt ) := ' ' ;\
 END IF ; IF label_r ( v_cnt ) . source_desc IS NOT NULL THEN :lr_source_des\
c ( v_cnt ) := label_r ( v_cnt ) . source_desc ; ELSE :lr_source_desc ( v_cn\
t ) := ' ' ; END IF ; IF label_r ( v_cnt");
 sqlbuft((void **)0, 
   " ) . source_desc_on_label IS NOT NULL THEN :lr_source_desc_on_label ( v_\
cnt ) := label_r ( v_cnt ) . source_desc_on_label ; ELSE :lr_source_desc_on_\
label ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . anatomy_site IS NOT\
 NULL THEN :lr_anatomy_site ( v_cnt ) := label_r ( v_cnt ) . anatomy_site ; \
ELSE :lr_anatomy_site ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . ana\
tomy_site_desc IS NOT NULL THEN :lr_anatomy_site_desc ( v_cnt ) := label_r (\
 v_cnt ) . anatomy_site_desc ; ELSE :lr_anatomy_site_desc ( v_cnt ) := ' ' ;\
 END IF ; IF label_r ( v_cnt ) . tissue_desc IS NOT NULL THEN :lr_tissue_des\
c ( v_cnt ) := label_r ( v_cnt ) . tissue_desc ; ELSE :lr_tissue_desc ( v_cn\
t ) := ' ' ; END IF ; IF label_r ( v_cnt ) . histo_yn IS NOT NULL THEN :lr_h\
isto_yn ( v_cnt ) := label_r ( v_cnt ) . histo_yn ; ELSE :lr_histo_yn ( v_cn\
t ) := ' ' ; END IF ; IF label_r ( v_cnt ) . patient_id IS NOT NULL THEN :lr\
_patient_id ( v_cnt ) := label_r ( v_cnt ) . patient_id ; ELSE :lr_patient_i\
d ( v_cnt ) := ' ' ; END IF ; IF label_r");
 sqlbuft((void **)0, 
   " ( v_cnt ) . sex IS NOT NULL THEN :lr_sex ( v_cnt ) := label_r ( v_cnt )\
 . sex ; ELSE :lr_sex ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . dob\
 IS NOT NULL THEN :lr_dob ( v_cnt ) := label_r ( v_cnt ) . dob ; ELSE :lr_do\
b ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . alternate_id IS NOT NUL\
L THEN :lr_alternate_id ( v_cnt ) := label_r ( v_cnt ) . alternate_id ; ELSE\
 :lr_alternate_id ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . unit_no\
 IS NOT NULL THEN :lr_unit_no ( v_cnt ) := label_r ( v_cnt ) . unit_no ; ELS\
E :lr_unit_no ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . ord_date_ti\
me IS NOT NULL THEN :lr_ord_date_time ( v_cnt ) := label_r ( v_cnt ) . ord_d\
ate_time ; IF label_r ( v_cnt ) . customer_id = 'SHALM' THEN :lr_ord_date_ti\
me ( v_cnt ) := TO_CHAR ( TO_DATE ( label_r ( v_cnt ) . spec_date_time1 , 'D\
D/MM/YYYY HH24:MI' ) , 'DD/MM/YY HH24:MI' ) ; END IF ; ELSE :lr_ord_date_tim\
e ( v_cnt ) := ' ' ; IF :a_pgm_id = 'RLRSPCLB' THEN :lr_ord_date_time ( v_cn\
t ) := TO_CHAR ( TO_DATE ( label_r ( v_c");
 sqlbuft((void **)0, 
   "nt ) . spec_date_time , 'DD/MM/YYYY HH24:MI' ) , 'DD/MM/YY HH24:MI' ) ; \
IF label_r ( v_cnt ) . customer_id = 'SHALM' THEN :lr_ord_date_time ( v_cnt \
) := TO_CHAR ( TO_DATE ( label_r ( v_cnt ) . spec_date_time1 , 'DD/MM/YYYY H\
H24:MI' ) , 'DD/MM/YY HH24:MI' ) ; END IF ; END IF ; END IF ; IF label_r ( v\
_cnt ) . alternate_id_type IS NOT NULL THEN :lr_alternate_id_type ( v_cnt ) \
:= label_r ( v_cnt ) . alternate_id_type ; ELSE :lr_alternate_id_type ( v_cn\
t ) := ' ' ; END IF ; IF label_r ( v_cnt ) . test_code IS NOT NULL THEN :lr_\
test_code ( v_cnt ) := label_r ( v_cnt ) . test_code ; ELSE :lr_test_code ( \
v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . test_name IS NOT NULL THEN \
:lr_test_name ( v_cnt ) := label_r ( v_cnt ) . test_name ; ELSE :lr_test_nam\
e ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . test_desc IS NOT NULL T\
HEN :lr_test_desc ( v_cnt ) := label_r ( v_cnt ) . test_desc ; ELSE :lr_test\
_desc ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . no_of_labels IS NOT\
 NULL THEN :lr_no_of_labels ( v_cnt ) :=");
 sqlstm.stmt = " label_r ( v_cnt ) . no_of_labels ; IF label_r ( v_cnt ) . n\
o_of_labels = 0 THEN :lr_no_of_labels ( v_cnt ) := 1 ; END IF ; ELSE :lr_no_of\
_labels ( v_cnt ) := -1 ; END IF ; IF label_r ( v_cnt ) . pgm_id IS NOT NULL T\
HEN :lr_pgm_id ( v_cnt ) := label_r ( v_cnt ) . pgm_id ; ELSE :lr_pgm_id ( v_c\
nt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . spec_type_code IS NOT NULL THEN \
:lr_spec_type_code ( v_cnt ) := label_r ( v_cnt ) . spec_type_code ; ELSE :lr_\
spec_type_code ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . module_id IS\
 NOT NULL THEN :lr_module_id ( v_cnt ) := label_r ( v_cnt ) . module_id ; ELSE\
 :lr_module_id ( v_cnt ) := ' ' ; END IF ; IF label_r ( v_cnt ) . customer_id \
IS NOT NULL THEN :lr_customer_id ( v_cnt ) := label_r ( v_cnt ) . customer_id \
; ELSE :lr_customer_id ( v_cnt ) := ' ' ; END IF ; v_cnt := v_cnt + 1 ; END LO\
OP ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )344;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&a_pgm_id;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&a_session_id;
 sqlstm.sqhstl[1] = (unsigned int  )43;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&a_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )43;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&a_spec_ord_no;
 sqlstm.sqhstl[3] = (unsigned int  )33;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&a_sec_ord_type;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&a_test_code;
 sqlstm.sqhstl[5] = (unsigned int  )33;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&a_ws_no;
 sqlstm.sqhstl[6] = (unsigned int  )43;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&language_id;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&h_no_of_rec;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)lr_facility_name;
 sqlstm.sqhstl[9] = (unsigned int  )143;
 sqlstm.sqhsts[9] = (         int  )144;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )100;
 sqlstm.sqharc[9] = (unsigned int   *)0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)lr_label_desc;
 sqlstm.sqhstl[10] = (unsigned int  )3952;
 sqlstm.sqhsts[10] = (         int  )3952;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )100;
 sqlstm.sqharc[10] = (unsigned int   *)0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)lr_cont_volume;
 sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[11] = (         int  )sizeof(int);
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )100;
 sqlstm.sqharc[11] = (unsigned int   *)0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)lr_volume_unit;
 sqlstm.sqhstl[12] = (unsigned int  )113;
 sqlstm.sqhsts[12] = (         int  )116;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )100;
 sqlstm.sqharc[12] = (unsigned int   *)0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)lr_specimen_no;
 sqlstm.sqhstl[13] = (unsigned int  )83;
 sqlstm.sqhsts[13] = (         int  )84;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )100;
 sqlstm.sqharc[13] = (unsigned int   *)0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)lr_patient_high_risk_ind;
 sqlstm.sqhstl[14] = (unsigned int  )13;
 sqlstm.sqhsts[14] = (         int  )16;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )100;
 sqlstm.sqharc[14] = (unsigned int   *)0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)lr_sample_id;
 sqlstm.sqhstl[15] = (unsigned int  )23;
 sqlstm.sqhsts[15] = (         int  )24;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )100;
 sqlstm.sqharc[15] = (unsigned int   *)0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)lr_category_code;
 sqlstm.sqhstl[16] = (unsigned int  )23;
 sqlstm.sqhsts[16] = (         int  )24;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )100;
 sqlstm.sqharc[16] = (unsigned int   *)0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)lr_category_year;
 sqlstm.sqhstl[17] = (unsigned int  )23;
 sqlstm.sqhsts[17] = (         int  )24;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )100;
 sqlstm.sqharc[17] = (unsigned int   *)0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)lr_category_no;
 sqlstm.sqhstl[18] = (unsigned int  )43;
 sqlstm.sqhsts[18] = (         int  )44;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )100;
 sqlstm.sqharc[18] = (unsigned int   *)0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)lr_priority;
 sqlstm.sqhstl[19] = (unsigned int  )23;
 sqlstm.sqhsts[19] = (         int  )24;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )100;
 sqlstm.sqharc[19] = (unsigned int   *)0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)lr_spec_date_time;
 sqlstm.sqhstl[20] = (unsigned int  )43;
 sqlstm.sqhsts[20] = (         int  )44;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )100;
 sqlstm.sqharc[20] = (unsigned int   *)0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)lr_patient_name;
 sqlstm.sqhstl[21] = (unsigned int  )163;
 sqlstm.sqhsts[21] = (         int  )164;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )100;
 sqlstm.sqharc[21] = (unsigned int   *)0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)lr_source_code;
 sqlstm.sqhstl[22] = (unsigned int  )43;
 sqlstm.sqhsts[22] = (         int  )44;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )100;
 sqlstm.sqharc[22] = (unsigned int   *)0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)lr_episode_type;
 sqlstm.sqhstl[23] = (unsigned int  )43;
 sqlstm.sqhsts[23] = (         int  )44;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )100;
 sqlstm.sqharc[23] = (unsigned int   *)0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)lr_source_type;
 sqlstm.sqhstl[24] = (unsigned int  )43;
 sqlstm.sqhsts[24] = (         int  )44;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )100;
 sqlstm.sqharc[24] = (unsigned int   *)0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)lr_source_desc;
 sqlstm.sqhstl[25] = (unsigned int  )103;
 sqlstm.sqhsts[25] = (         int  )104;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )100;
 sqlstm.sqharc[25] = (unsigned int   *)0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)lr_source_desc_on_label;
 sqlstm.sqhstl[26] = (unsigned int  )103;
 sqlstm.sqhsts[26] = (         int  )104;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )100;
 sqlstm.sqharc[26] = (unsigned int   *)0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)lr_anatomy_site;
 sqlstm.sqhstl[27] = (unsigned int  )43;
 sqlstm.sqhsts[27] = (         int  )44;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )100;
 sqlstm.sqharc[27] = (unsigned int   *)0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)lr_anatomy_site_desc;
 sqlstm.sqhstl[28] = (unsigned int  )3952;
 sqlstm.sqhsts[28] = (         int  )3952;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )100;
 sqlstm.sqharc[28] = (unsigned int   *)0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)lr_tissue_desc;
 sqlstm.sqhstl[29] = (unsigned int  )3952;
 sqlstm.sqhsts[29] = (         int  )3952;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )100;
 sqlstm.sqharc[29] = (unsigned int   *)0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)lr_histo_yn;
 sqlstm.sqhstl[30] = (unsigned int  )6;
 sqlstm.sqhsts[30] = (         int  )8;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )100;
 sqlstm.sqharc[30] = (unsigned int   *)0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)lr_patient_id;
 sqlstm.sqhstl[31] = (unsigned int  )143;
 sqlstm.sqhsts[31] = (         int  )144;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )100;
 sqlstm.sqharc[31] = (unsigned int   *)0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
 sqlstm.sqhstv[32] = (         void  *)lr_sex;
 sqlstm.sqhstl[32] = (unsigned int  )13;
 sqlstm.sqhsts[32] = (         int  )16;
 sqlstm.sqindv[32] = (         void  *)0;
 sqlstm.sqinds[32] = (         int  )0;
 sqlstm.sqharm[32] = (unsigned int  )100;
 sqlstm.sqharc[32] = (unsigned int   *)0;
 sqlstm.sqadto[32] = (unsigned short )0;
 sqlstm.sqtdso[32] = (unsigned short )0;
 sqlstm.sqhstv[33] = (         void  *)lr_dob;
 sqlstm.sqhstl[33] = (unsigned int  )43;
 sqlstm.sqhsts[33] = (         int  )44;
 sqlstm.sqindv[33] = (         void  *)0;
 sqlstm.sqinds[33] = (         int  )0;
 sqlstm.sqharm[33] = (unsigned int  )100;
 sqlstm.sqharc[33] = (unsigned int   *)0;
 sqlstm.sqadto[33] = (unsigned short )0;
 sqlstm.sqtdso[33] = (unsigned short )0;
 sqlstm.sqhstv[34] = (         void  *)lr_alternate_id;
 sqlstm.sqhstl[34] = (unsigned int  )143;
 sqlstm.sqhsts[34] = (         int  )144;
 sqlstm.sqindv[34] = (         void  *)0;
 sqlstm.sqinds[34] = (         int  )0;
 sqlstm.sqharm[34] = (unsigned int  )100;
 sqlstm.sqharc[34] = (unsigned int   *)0;
 sqlstm.sqadto[34] = (unsigned short )0;
 sqlstm.sqtdso[34] = (unsigned short )0;
 sqlstm.sqhstv[35] = (         void  *)lr_unit_no;
 sqlstm.sqhstl[35] = (unsigned int  )143;
 sqlstm.sqhsts[35] = (         int  )144;
 sqlstm.sqindv[35] = (         void  *)0;
 sqlstm.sqinds[35] = (         int  )0;
 sqlstm.sqharm[35] = (unsigned int  )100;
 sqlstm.sqharc[35] = (unsigned int   *)0;
 sqlstm.sqadto[35] = (unsigned short )0;
 sqlstm.sqtdso[35] = (unsigned short )0;
 sqlstm.sqhstv[36] = (         void  *)lr_ord_date_time;
 sqlstm.sqhstl[36] = (unsigned int  )143;
 sqlstm.sqhsts[36] = (         int  )144;
 sqlstm.sqindv[36] = (         void  *)0;
 sqlstm.sqinds[36] = (         int  )0;
 sqlstm.sqharm[36] = (unsigned int  )100;
 sqlstm.sqharc[36] = (unsigned int   *)0;
 sqlstm.sqadto[36] = (unsigned short )0;
 sqlstm.sqtdso[36] = (unsigned short )0;
 sqlstm.sqhstv[37] = (         void  *)lr_alternate_id_type;
 sqlstm.sqhstl[37] = (unsigned int  )103;
 sqlstm.sqhsts[37] = (         int  )104;
 sqlstm.sqindv[37] = (         void  *)0;
 sqlstm.sqinds[37] = (         int  )0;
 sqlstm.sqharm[37] = (unsigned int  )100;
 sqlstm.sqharc[37] = (unsigned int   *)0;
 sqlstm.sqadto[37] = (unsigned short )0;
 sqlstm.sqtdso[37] = (unsigned short )0;
 sqlstm.sqhstv[38] = (         void  *)lr_test_code;
 sqlstm.sqhstl[38] = (unsigned int  )3952;
 sqlstm.sqhsts[38] = (         int  )3952;
 sqlstm.sqindv[38] = (         void  *)0;
 sqlstm.sqinds[38] = (         int  )0;
 sqlstm.sqharm[38] = (unsigned int  )100;
 sqlstm.sqharc[38] = (unsigned int   *)0;
 sqlstm.sqadto[38] = (unsigned short )0;
 sqlstm.sqtdso[38] = (unsigned short )0;
 sqlstm.sqhstv[39] = (         void  *)lr_test_name;
 sqlstm.sqhstl[39] = (unsigned int  )3952;
 sqlstm.sqhsts[39] = (         int  )3952;
 sqlstm.sqindv[39] = (         void  *)0;
 sqlstm.sqinds[39] = (         int  )0;
 sqlstm.sqharm[39] = (unsigned int  )100;
 sqlstm.sqharc[39] = (unsigned int   *)0;
 sqlstm.sqadto[39] = (unsigned short )0;
 sqlstm.sqtdso[39] = (unsigned short )0;
 sqlstm.sqhstv[40] = (         void  *)lr_test_desc;
 sqlstm.sqhstl[40] = (unsigned int  )3952;
 sqlstm.sqhsts[40] = (         int  )3952;
 sqlstm.sqindv[40] = (         void  *)0;
 sqlstm.sqinds[40] = (         int  )0;
 sqlstm.sqharm[40] = (unsigned int  )100;
 sqlstm.sqharc[40] = (unsigned int   *)0;
 sqlstm.sqadto[40] = (unsigned short )0;
 sqlstm.sqtdso[40] = (unsigned short )0;
 sqlstm.sqhstv[41] = (         void  *)lr_no_of_labels;
 sqlstm.sqhstl[41] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[41] = (         int  )sizeof(int);
 sqlstm.sqindv[41] = (         void  *)0;
 sqlstm.sqinds[41] = (         int  )0;
 sqlstm.sqharm[41] = (unsigned int  )100;
 sqlstm.sqharc[41] = (unsigned int   *)0;
 sqlstm.sqadto[41] = (unsigned short )0;
 sqlstm.sqtdso[41] = (unsigned short )0;
 sqlstm.sqhstv[42] = (         void  *)lr_pgm_id;
 sqlstm.sqhstl[42] = (unsigned int  )23;
 sqlstm.sqhsts[42] = (         int  )24;
 sqlstm.sqindv[42] = (         void  *)0;
 sqlstm.sqinds[42] = (         int  )0;
 sqlstm.sqharm[42] = (unsigned int  )100;
 sqlstm.sqharc[42] = (unsigned int   *)0;
 sqlstm.sqadto[42] = (unsigned short )0;
 sqlstm.sqtdso[42] = (unsigned short )0;
 sqlstm.sqhstv[43] = (         void  *)lr_spec_type_code;
 sqlstm.sqhstl[43] = (unsigned int  )243;
 sqlstm.sqhsts[43] = (         int  )244;
 sqlstm.sqindv[43] = (         void  *)0;
 sqlstm.sqinds[43] = (         int  )0;
 sqlstm.sqharm[43] = (unsigned int  )100;
 sqlstm.sqharc[43] = (unsigned int   *)0;
 sqlstm.sqadto[43] = (unsigned short )0;
 sqlstm.sqtdso[43] = (unsigned short )0;
 sqlstm.sqhstv[44] = (         void  *)lr_module_id;
 sqlstm.sqhstl[44] = (unsigned int  )13;
 sqlstm.sqhsts[44] = (         int  )16;
 sqlstm.sqindv[44] = (         void  *)0;
 sqlstm.sqinds[44] = (         int  )0;
 sqlstm.sqharm[44] = (unsigned int  )100;
 sqlstm.sqharc[44] = (unsigned int   *)0;
 sqlstm.sqadto[44] = (unsigned short )0;
 sqlstm.sqtdso[44] = (unsigned short )0;
 sqlstm.sqhstv[45] = (         void  *)lr_customer_id;
 sqlstm.sqhstl[45] = (unsigned int  )142;
 sqlstm.sqhsts[45] = (         int  )144;
 sqlstm.sqindv[45] = (         void  *)0;
 sqlstm.sqinds[45] = (         int  )0;
 sqlstm.sqharm[45] = (unsigned int  )150;
 sqlstm.sqharc[45] = (unsigned int   *)0;
 sqlstm.sqadto[45] = (unsigned short )0;
 sqlstm.sqtdso[45] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 



    for (v_i=0;v_i<h_no_of_rec;v_i++)
	{

	lr_facility_name[v_i].len = strlen(lr_facility_name[v_i].arr);
	lr_label_desc[v_i].len = strlen(lr_label_desc[v_i].arr);
	lr_volume_unit[v_i].len = strlen(lr_volume_unit[v_i].arr);
	lr_specimen_no[v_i].len = strlen(lr_specimen_no[v_i].arr);
	lr_patient_high_risk_ind[v_i].len = strlen(lr_patient_high_risk_ind[v_i].arr);  // 11.09.2008
	lr_sample_id[v_i].len = strlen(lr_sample_id[v_i].arr);
	lr_category_code[v_i].len = strlen(lr_category_code[v_i].arr);
	lr_category_year[v_i].len = strlen(lr_category_year[v_i].arr);
	lr_category_no[v_i].len = strlen(lr_category_no[v_i].arr);
	lr_priority[v_i].len = strlen(lr_priority[v_i].arr);
	lr_spec_date_time[v_i].len = strlen(lr_spec_date_time[v_i].arr);
	lr_patient_name[v_i].len = strlen(lr_patient_name[v_i].arr);
	lr_source_code[v_i].len = strlen(lr_source_code[v_i].arr); //-- 13.03.2006
	lr_episode_type[v_i].len = strlen(lr_episode_type[v_i].arr); //-- 13.03.2006
	lr_source_type[v_i].len = strlen(lr_source_type[v_i].arr); //-- 13.03.2006
	lr_source_desc[v_i].len = strlen(lr_source_desc[v_i].arr); //-- 13.03.2006
	lr_source_desc_on_label[v_i].len = strlen(lr_source_desc_on_label[v_i].arr); //-- 13.03.2006
	lr_anatomy_site[v_i].len = strlen(lr_anatomy_site[v_i].arr);
	lr_anatomy_site_desc[v_i].len = strlen(lr_anatomy_site_desc[v_i].arr);
	lr_tissue_desc[v_i].len = strlen(lr_tissue_desc[v_i].arr);
	lr_histo_yn[v_i].len = strlen(lr_histo_yn[v_i].arr);
	lr_patient_id[v_i].len = strlen(lr_patient_id[v_i].arr);
	lr_sex[v_i].len = strlen(lr_sex[v_i].arr);
	lr_dob[v_i].len = strlen(lr_dob[v_i].arr);
	lr_alternate_id[v_i].len = strlen(lr_alternate_id[v_i].arr);
	lr_unit_no[v_i].len = strlen(lr_unit_no[v_i].arr);
	lr_alternate_id_type[v_i].len = strlen(lr_alternate_id_type[v_i].arr);
	lr_test_code[v_i].len = strlen(lr_test_code[v_i].arr);
	lr_test_desc[v_i].len = strlen(lr_test_desc[v_i].arr);
	lr_pgm_id[v_i].len = strlen(lr_pgm_id[v_i].arr);
	lr_spec_type_code[v_i].len = strlen(lr_spec_type_code[v_i].arr);
	lr_module_id[v_i].len = strlen(lr_module_id[v_i].arr);
	lr_customer_id[v_i].len = strlen(lr_customer_id[v_i].arr);
	lr_ord_date_time[v_i].len = strlen(lr_ord_date_time[v_i].arr);

///sprintf(string_var,"package orddate=%s, customer=%s",lr_ord_date_time[v_i].arr,lr_customer_id[v_i].arr);
///disp_message(ERR_MESG,string_var);


	}

}

print_label(int v_ind)
{

char l_temp_specimen_no[25];

//	fprintf(f1, "%14.14s ", lr_facility_name[v_ind].arr);  BSP30453-SCF-0176
//	fprintf(f1,"%-2.2s %12.12s\n", lr_priority[v_ind].arr, lr_patient_id[v_ind].arr);  BSP30453-SCF-0176
	fprintf(f1, "%12.12s ", lr_facility_name[v_ind].arr);  //MODIFIED AGAINST BSP30453-SCF-0176
	fprintf(f1,"%-2.2s %14.14s\n", lr_priority[v_ind].arr, lr_patient_id[v_ind].arr);  //MODIFIED AGAINST BSP30453-SCF-0176
//	   strcpy(nd_printer_type.arr,"3");

	if (strcmp(nd_thai_lang_yn.arr,"Y") == 0)	
	{
		strcpy(l_temp_specimen_no, "*");
		strcat(l_temp_specimen_no, lr_specimen_no[v_ind].arr);
		strcat(l_temp_specimen_no, "*");

		if (strcmp(nd_printer_type.arr,"3")!=0)	
		{
			 print_barcode(f1, l_temp_specimen_no, 0, 0, 40, 250,atoi(nd_printer_type.arr));
			fprintf(f1,"\n");  
		}
		else
		{
			 print_barcode(f1, l_temp_specimen_no, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
			fprintf(f1,"\n");
		}
	 } 
	else
	 {
		if (strcmp(nd_printer_type.arr,"3")!=0)	
		{
			 print_barcode(f1,lr_specimen_no[v_ind].arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
			fprintf(f1,"\n");  
		}
		else
		{
			 print_barcode(f1, lr_specimen_no[v_ind].arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
			fprintf(f1,"\n");
		}
     }  
	fprintf(f1, "%-10s", lr_specimen_no[v_ind].arr);
	/////Ravi Shankar, 04/01/2021, TFS ID 12315, GHL-SCF-1543
	//fprintf(f1, "%-3s", lr_sample_id[v_ind].arr);
	if ( (strcmp(lr_unit_no[v_ind].arr, " ") != 0) ) 
	{
		fprintf(f1, "%-1s", lr_sample_id[v_ind].arr);
	}
	else
	{
		fprintf(f1, "%-3s", lr_sample_id[v_ind].arr);
	}
	//////////////

    if ( (strcmp(lr_category_code[v_ind].arr, " ") != 0)  && (strcmp(lr_category_year[v_ind].arr, " ") != 0) ) 
    {
	  fprintf(f1,"%-s-%-s-%-10.10s", lr_category_code[v_ind].arr, lr_category_year[v_ind].arr, lr_category_no[v_ind].arr);
    }
    else
	{
      if ( (strcmp(lr_unit_no[v_ind].arr, " ") != 0) ) 
      {
	    fprintf(f1,"%-18.18s", lr_unit_no[v_ind].arr);
      }
	}
	fprintf(f1, "%-2s", lr_patient_high_risk_ind[v_ind].arr);  /// 11.09.2008

	fprintf(f1, "%\n");

	fprintf(f1, "%-30s\n",  lr_patient_name[v_ind].arr);

    if (strcmp(lr_customer_id[v_ind].arr, "SRR") != 0)
    {
	    if ( (strcmp(lr_unit_no[v_ind].arr, " ") != 0) ) 
	    {
		  if ( (strcmp(lr_source_desc_on_label[v_ind].arr, " ") != 0) ) 
		  {
			if (strcmp(lr_customer_id[v_ind].arr, "SHALM") != 0)
			{
				fprintf(f1,"%-13.13s %-8.8s %-6.6s\n",  lr_alternate_id[v_ind].arr, 
										lr_ord_date_time[v_ind].arr, lr_source_desc_on_label[v_ind].arr);
			}
			else
			{
				fprintf(f1,"%-13.13s %-15.15s\n",  lr_alternate_id[v_ind].arr,lr_ord_date_time[v_ind].arr);
			}
		  }
		  else
		  {
			if (strcmp(lr_customer_id[v_ind].arr, "SHALM") != 0)
			{
				fprintf(f1,"%-13.13s %-8.8s %-6.6s\n",  lr_alternate_id[v_ind].arr, 
										lr_ord_date_time[v_ind].arr, lr_source_code[v_ind].arr);
			}
			else
			{
				fprintf(f1,"%-13.13s %-15.15s\n",  lr_alternate_id[v_ind].arr,lr_ord_date_time[v_ind].arr);
			}
		  }
		}
		else
		{
		  if ( (strcmp(lr_source_desc_on_label[v_ind].arr, " ") != 0) ) 
		  {
			if (strcmp(lr_customer_id[v_ind].arr, "SHALM") != 0)
			{
				fprintf(f1,"%-13.13s %-8.8s %-6.6s\n",  lr_alternate_id[v_ind].arr, 
										lr_ord_date_time[v_ind].arr, lr_source_desc_on_label[v_ind].arr);
			}
			else
			{
				fprintf(f1,"%-13.13s %-15.15s\n",  lr_alternate_id[v_ind].arr,lr_ord_date_time[v_ind].arr);
			}
		  }
		  else
		  {
			if (strcmp(lr_customer_id[v_ind].arr, "SHALM") != 0)
			{
				fprintf(f1,"%-13.13s %-8.8s %-6.6s\n",  lr_alternate_id[v_ind].arr, 
										lr_ord_date_time[v_ind].arr, lr_source_code[v_ind].arr);
			}
			else
			{
				fprintf(f1,"%-13.13s %-15.15s\n",  lr_alternate_id[v_ind].arr,lr_ord_date_time[v_ind].arr);
			}
		  }
		}
    }
    else
    {
		fprintf(f1,"%-13.13s %-8.8s %-15.15s\n",  lr_alternate_id[v_ind].arr, 
					lr_ord_date_time[v_ind].arr, lr_source_desc[v_ind].arr);

    }


  
    if ( strcmp(lr_histo_yn[v_ind].arr, "N") == 0)
	{

//		get_site_customer_id();

		if (strcmp(lr_customer_id[v_ind].arr, "SRR") != 0)
		{
			// test short names
			if (strlen(lr_test_name[v_ind].arr) > 1) 
			{	
				split_test_code(v_ind);
			} 
		}

		// specimen type short 
/* ************************************ commented and modified as below on 04.09.2015 against issue raised by alpha against hsa-crf-274.
		if (strlen(lr_label_desc[v_ind].arr) > 1) 
		{
		  if (strcmp(lr_customer_id[v_ind].arr, "SHALM") != 0)
				fprintf(f1,"%s", lr_label_desc[v_ind].arr);
		  else
		  {
		   if ((strcmp(lr_source_desc_on_label[v_ind].arr, " ") != 0)) 
			  fprintf(f1,"%-22.22s   %-6.6s", lr_label_desc[v_ind].arr,lr_source_desc_on_label[v_ind].arr);
		   else
			  fprintf(f1,"%-22.22s   %-6.6s", lr_label_desc[v_ind].arr,lr_source_code[v_ind].arr);
		  }
		}
****************************************************/

		
		
		  if (strcmp(lr_customer_id[v_ind].arr, "SHALM") != 0)
		  {
				if (strlen(lr_label_desc[v_ind].arr) > 1) 
						fprintf(f1,"%s", lr_label_desc[v_ind].arr);
          }
		  else
		  {
		   if ((strcmp(lr_source_desc_on_label[v_ind].arr, " ") != 0)) 
			  fprintf(f1,"%-22.22s   %-6.6s", lr_label_desc[v_ind].arr,lr_source_desc_on_label[v_ind].arr);
		   else
			  fprintf(f1,"%-22.22s   %-6.6s", lr_label_desc[v_ind].arr,lr_source_code[v_ind].arr);
		  } 
		

		fprintf(f1,"\n");	 

		if (strcmp(lr_customer_id[v_ind].arr, "SRR") != 0)
		{

			  // interval test short desc
			if (strlen(lr_test_desc[v_ind].arr) > 1) 
			{	
				split_test_code1(v_ind);
			} 
			fprintf(f1,"\n");	
		}
	}
	else
	{
	  if (strcmp(lr_customer_id[v_ind].arr, "SHALM") != 0)
		fprintf(f1, "%-s\n", lr_anatomy_site_desc[v_ind].arr);
	  else
	  {
		if ((strcmp(lr_source_desc_on_label[v_ind].arr, " ") != 0)) 
			  fprintf(f1,"%-20.20s   %-6.6s\n", lr_anatomy_site_desc[v_ind].arr,lr_source_desc_on_label[v_ind].arr);
		else
			  fprintf(f1,"%-20.20s   %-6.6s\n", lr_anatomy_site_desc[v_ind].arr,lr_source_code[v_ind].arr);
	  }
	  fprintf(f1, "%-s\n", lr_tissue_desc[v_ind].arr);
		// The below comment has to be removed while despatching and 
		// routing has to be defined for "RLRSPCHS".  
		//  comments removed for below 2 lines

		strcpy(a_pgm_id.arr, "RLRSPCHS");
		a_pgm_id.len = strlen(a_pgm_id.arr); 
	}

//	fprintf(f1, "\n");
}

///// added the below procedure against Bru-HIMS-CRF-389 & 420.

print_label_mohbr(int v_ind)
{

char l_temp_specimen_no[25];

//	fprintf(f1, "%14.14s ", lr_facility_name[v_ind].arr);  BSP30453-SCF-0176
//	fprintf(f1,"%-2.2s %12.12s\n", lr_priority[v_ind].arr, lr_patient_id[v_ind].arr);  BSP30453-SCF-0176

	fprintf(f1, "%10.10s ", lr_facility_name[v_ind].arr);  //MODIFIED AGAINST BSP30453-SCF-0176

//sprintf(string_char,"priority %s", lr_priority[v_ind].arr);
//disp_message(ERR_MESG, string_char);

	if (strcmp(lr_priority[v_ind].arr,"Ro") == 0)
		strcpy(lr_priority[v_ind].arr,"RT");
	

	fprintf(f1,"%-2.2s %-2.2s %14.14s\n", lr_priority[v_ind].arr, lr_patient_high_risk_ind[v_ind].arr, lr_patient_id[v_ind].arr);  //MODIFIED AGAINST BSP30453-SCF-0176

//	   strcpy(nd_printer_type.arr,"3");

	if (strcmp(nd_thai_lang_yn.arr,"Y") == 0)	
	{
		strcpy(l_temp_specimen_no, "*");
		strcat(l_temp_specimen_no, lr_specimen_no[v_ind].arr);
		strcat(l_temp_specimen_no, "*");

		if (strcmp(nd_printer_type.arr,"3")!=0)	
		{
			 print_barcode(f1, l_temp_specimen_no, 0, 0, 40, 250,atoi(nd_printer_type.arr));
			fprintf(f1,"\n");  
		}
		else
		{
			 print_barcode(f1, l_temp_specimen_no, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
			fprintf(f1,"\n");
		}
	 } 
	else
	 {
		if (strcmp(nd_printer_type.arr,"3")!=0)	
		{
			 print_barcode(f1,lr_specimen_no[v_ind].arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
			fprintf(f1,"\n");  
		}
		else
		{
			 print_barcode(f1, lr_specimen_no[v_ind].arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
			fprintf(f1,"\n");
		}
     }  
	fprintf(f1, "%-10s", lr_specimen_no[v_ind].arr);
	fprintf(f1, "%-3s", lr_sample_id[v_ind].arr);

    if ( (strcmp(lr_category_code[v_ind].arr, " ") != 0)  && (strcmp(lr_category_year[v_ind].arr, " ") != 0) ) 
    {
	  fprintf(f1,"%-s-%-s-%-10.10s", lr_category_code[v_ind].arr, lr_category_year[v_ind].arr, lr_category_no[v_ind].arr);
    }
    else
	{
      if ( (strcmp(lr_unit_no[v_ind].arr, " ") != 0) ) 
      {
	    fprintf(f1,"%-18.18s", lr_unit_no[v_ind].arr);
      }
	}
//////	fprintf(f1, "%-2s", lr_patient_high_risk_ind[v_ind].arr);  /// 11.09.2008

	fprintf(f1, "%\n");

	fprintf(f1, "%-30s\n",  lr_patient_name[v_ind].arr);

    if (strcmp(lr_customer_id[v_ind].arr, "SRR") != 0)
    {
	    if ( (strcmp(lr_unit_no[v_ind].arr, " ") != 0) ) 
	    {
		  if ( (strcmp(lr_source_desc_on_label[v_ind].arr, " ") != 0) ) 
		  {
			fprintf(f1,"%-13.13s %-8.8s %-6.6s\n",  lr_alternate_id[v_ind].arr, 
						lr_ord_date_time[v_ind].arr, lr_source_desc_on_label[v_ind].arr);
		  }
		  else
		  {
			fprintf(f1,"%-13.13s %-8.8s %-6.6s\n",  lr_alternate_id[v_ind].arr, 
						lr_ord_date_time[v_ind].arr, lr_source_code[v_ind].arr);
		  }
		}
		else
		{
		  if ( (strcmp(lr_source_desc_on_label[v_ind].arr, " ") != 0) ) 
		  {
			fprintf(f1,"%-13.13s %-8.8s %-6.6s\n",  lr_alternate_id[v_ind].arr, 
					lr_ord_date_time[v_ind].arr, lr_source_desc_on_label[v_ind].arr);
		  }
		  else
		  {
			fprintf(f1,"%-13.13s %-8.8s %-6.6s\n",  lr_alternate_id[v_ind].arr, 
					lr_ord_date_time[v_ind].arr, lr_source_code[v_ind].arr);
		  }
		}
    }
    else
    {
		fprintf(f1,"%-13.13s %-8.8s %-15.15s\n",  lr_alternate_id[v_ind].arr, 
					lr_ord_date_time[v_ind].arr, lr_source_desc[v_ind].arr);

    }

 
  
    if ( strcmp(lr_histo_yn[v_ind].arr, "N") == 0)
	{

//		get_site_customer_id();

		if (strcmp(lr_customer_id[v_ind].arr, "SRR") != 0)
		{
			// test short names
			if (strlen(lr_test_name[v_ind].arr) > 1) 
			{	
				split_test_code(v_ind);
			} 
		}

		// specimen type short 

//sprintf(string_char,"specimentype %s", lr_label_desc[v_ind].arr);
//disp_message(ERR_MESG, string_char);

		if (strlen(lr_label_desc[v_ind].arr) > 1) 
		{
			fprintf(f1,"%30s", lr_label_desc[v_ind].arr);
		}
		fprintf(f1,"\n");	

		if (strcmp(lr_customer_id[v_ind].arr, "SRR") != 0)
		{

			  // interval test short desc
			if (strlen(lr_test_desc[v_ind].arr) > 1) 
			{	
				split_test_code1(v_ind);
			} 
			fprintf(f1,"\n");	
		}
	}
	else
	{
//sprintf(string_char,"anatomy site desc=%s,tissue desc=%s", lr_anatomy_site_desc[v_ind].arr,lr_tissue_desc[v_ind].arr);
//disp_message(ERR_MESG, string_char);

		fprintf(f1, "%-s\n", lr_anatomy_site_desc[v_ind].arr);
		fprintf(f1, "%-s\n", lr_tissue_desc[v_ind].arr);
		// The below comment has to be removed while despatching and 
		// routing has to be defined for "RLRSPCHS".  
		//  comments removed for below 2 lines

		strcpy(a_pgm_id.arr, "RLRSPCHS");
		a_pgm_id.len = strlen(a_pgm_id.arr); 
	}

//	fprintf(f1, "\n");
}


split_test_code1(int v_ind)
{

  char buff[100];
  int  ix = 0; 
  int  ln = 0; 
  int  ct = 0;

  strcpy(v_text.arr, lr_test_desc[v_ind].arr);
  v_text.len = strlen(v_text.arr);
  v_text.len = strlen(v_text.arr);
  strcpy(o_rem_splitting_text.arr,"");
  o_rem_splitting_text.len = strlen(o_rem_splitting_text.arr);
  strcpy(buff,"");
  while (ix < strlen(v_text.arr) )
  {
    strcpy(buff,"");
    splitting_text(v_text.arr,52,buff,&ix);
	
    strcpy(o_rem_splitting_text.arr,buff);
	o_rem_splitting_text.len = strlen(o_rem_splitting_text.arr);
    fprintf(f1,"%-52.52s",o_rem_splitting_text.arr);

	fprintf(f1, "\n");	
	/* chk_break(1); */
  }

}

split_test_code(int v_ind)
{

  char buff[100];
  int  ix = 0; 
  int  ln = 0; 
  int  ct = 0;

  int  xx = 0;
  int  no_of_lines1 = 0;
  int  last_pos_comma = 0;

	strcpy(v_text.arr, lr_test_name[v_ind].arr);
	v_text.len = strlen(v_text.arr);
	v_text.len = strlen(v_text.arr);
	strncpy(o_rem_splitting_text.arr, v_text.arr, 47);
	o_rem_splitting_text.len = strlen(o_rem_splitting_text.arr);
	strcpy(buff,"");

    strcpy(o_rem_splitting_text4.arr, "");
    o_rem_splitting_text4.len = strlen(o_rem_splitting_text4.arr);
    o_rem_splitting_text4.arr[o_rem_splitting_text4.len] = '\0';

    last_pos_comma = find_last_comma(o_rem_splitting_text.arr, last_pos_comma);

	split_into_words(o_rem_splitting_text.arr);

/* commented as the below logic is not used. the whole logic is in split_into_words sub routine
	if ((strlen(v_text.arr)) > 32)
	{

//	  strncpy(o_rem_splitting_text1.arr, o_rem_splitting_text.arr, 30);
//	  o_rem_splitting_text1.len = strlen(o_rem_splitting_text1.arr);
//	  strcat(o_rem_splitting_text1.arr, "..");
//	  o_rem_splitting_text1.len = strlen(o_rem_splitting_text1.arr);

	  sprintf(string_char, "test , last_commma_pos %sQ %d %d %d %d", o_rem_splitting_text1.arr, last_pos_comma, prev_last_comma, (32- last_pos_comma ) ,((last_pos_comma - prev_last_comma)/ 2) );
	  disp_message(ERR_MESG, string_char);
	  if ( abs(32- last_pos_comma ) < ((last_pos_comma - prev_last_comma) / 2) )
	  {
		  strncpy(o_rem_splitting_text1.arr, o_rem_splitting_text.arr, 30);
		  o_rem_splitting_text1.len = strlen(o_rem_splitting_text1.arr);
		  strcat(o_rem_splitting_text1.arr, "..");
		  o_rem_splitting_text1.len = strlen(o_rem_splitting_text1.arr);

	  sprintf(string_char, "test , last_commma_pos %s11 %d %d", o_rem_splitting_text1.arr, last_pos_comma, prev_last_comma);
	  disp_message(ERR_MESG, string_char);

	  }
	  else
	  {
		  strncpy(o_rem_splitting_text1.arr, o_rem_splitting_text.arr, prev_last_comma + 1 );
		  o_rem_splitting_text1.len = strlen(o_rem_splitting_text1.arr);
		  strcat(o_rem_splitting_text1.arr, "..");
		  o_rem_splitting_text1.len = strlen(o_rem_splitting_text1.arr);

		  sprintf(string_char, "test , last_commma_pos %s12 %d %d", o_rem_splitting_text1.arr, last_pos_comma, prev_last_comma);
		  disp_message(ERR_MESG, string_char);

	  }

	  sprintf(string_char, "test , last_commma_pos %sMid %d %d", o_rem_splitting_text1.arr, last_pos_comma, prev_last_comma);
	  disp_message(ERR_MESG, string_char);

  	  convert_sin_chstr(o_rem_splitting_text1.arr);
	  fprintf(f1,"%-32.32s", o_rem_splitting_text2.arr);
	  fprintf(f1, "\n");	
	  sprintf(string_char, "test , last_commma_pos %sQ %d %d", o_rem_splitting_text2.arr, last_pos_comma, prev_last_comma);
	  disp_message(ERR_MESG, string_char);
	}
*/

}



print_aliquot_label(int v_ind)
{

//	fprintf(f1, "%s\n", lr_facility_name[v_ind].arr);


    fprintf(f1, "%-15s\n", lr_patient_id[v_ind].arr);

	if (strcmp(l_customer_id.arr,"SHALM") == 0)
		fprintf(f1, "%-26.26s\n",  lr_patient_name[v_ind].arr);  /// added against ML-MMOH-CRF-0324

	strcpy(nd_printer_type.arr, "3");
	if (strcmp(nd_printer_type.arr,"3")!=0)	
	  {
	     print_barcode(f1,lr_specimen_no[v_ind].arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
	     fprintf(f1,"\n");  
	  }
	else
	 {
	     print_barcode(f1, lr_specimen_no[v_ind].arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
	     fprintf(f1,"\n");
	 }

	fprintf(f1, "%-11s\n", lr_specimen_no[v_ind].arr);
	fprintf(f1, "%-11s\n", lr_test_code[v_ind].arr);
//    split_test_code(v_ind);

}

print_slide_label(int v_ind)
{

//	fprintf(f1, "%s\n", lr_facility_name[v_ind].arr);

    fprintf(f1, "%-15s\n", lr_patient_id[v_ind].arr);
	strcpy(nd_printer_type.arr, "3");
	if (strcmp(nd_printer_type.arr,"3")!=0)	
	  {
	     print_barcode(f1,lr_specimen_no[v_ind].arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
	     fprintf(f1,"\n");  
	  }
	else
	 {
	     print_barcode(f1, lr_specimen_no[v_ind].arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
	     fprintf(f1,"\n");
	 }

	fprintf(f1, "%-11s\n", lr_specimen_no[v_ind].arr);
	fprintf(f1, "%-11s\n", lr_test_code[v_ind].arr);
//    split_test_code(v_ind);

}

/***************** Print BarCode Label ********************/
print_barcode_label(int nolabel)
 {
    int i;
    int WSPrintstatus;
    int printcopies = 0;

	
    printcopies = nolabel;

//disp_message(ERR_MESG,"sss");

    if (strcmp(reprint_yn,"Y") == 0)
    {
		printcopies = d_NumOfCopies;
    }

//    for(i=0;i<nolabel;i++)
//		  {
		 		if (nd_source_type.arr[0]	== '!')
				{					

					
					WSPrintDocument 
						   (
							uid_pwd.arr,		//char	*PUidPwd;
							nd_session_id.arr,	//char	*PSessionID;
							nd_facility_id.arr,	//char	*PFacilityID;
							"RL",				//char	*PModuleID;
							a_pgm_id.arr,			//char	*PDocumentID;
							filename,	    	//char	*POnlinePrintFileNames;
							"O",				//char	*PLocationTypes;
							" ",				//char	*PLocationCodes;
////18.04.2007 srini		1,					//int	PNumOfCopies;
						    printcopies,		//int	PNumOfCopies;
							1,				    //int	PPageFrom;
							9999,				//int	PPageTo;
							nd_ws_no.arr,		//char	*PWorkstationID
							WORKING_DIR,			//char	*PReportOutputDir
							nd_printer_id.arr         // char *PRndprinterid  //added for ML-MMOH-CRF-0578
						
						   );
				}						   
				else
				{
					 
			    //disp_message(ERR_MESG,"");
				 WSPrintstatus =		 WSPrintDocument
						   (
							uid_pwd.arr,				//char	*PUidPwd;
							nd_session_id.arr,			//char	*PSessionID;
							nd_facility_id.arr,			//char	*PFacilityID;
							"RL",						//char	*PModuleID;
							a_pgm_id.arr,					//char	*PDocumentID;
							filename,	    			//char	*POnlinePrintFileNames;
							nd_print_source_type.arr,	//char	*PLocationTypes;
							nd_print_source.arr,	    //char	*PLocationCodes;
////18.04.2007 srini		1,							//int	PNumOfCopies;
							printcopies,				//int	PNumOfCopies;
							1,							//int	PPageFrom;
							9999,						//int	PPageTo;
							nd_ws_no.arr,				//char	*PWorkstationID
							WORKING_DIR,					//char	*PReportOutputDir
							nd_printer_id.arr               // char *PRndprinterid  //added for ML-MMOH-CRF-0578
							
						   );

				}	  					   
//		  }
 
 }

/*-----------------------------------------------------------------------------  
FUNCTION NAME			: online_barcode_label()
DESCRIPTION            	: This functions will convert .LIS files to .ZPL files
						  and Print the ZPL file.
						  using the TYPE command print the file using system()
						  function.
TABLES USED            	: SM_PRINT_ROUTING, SM_PRINTER 
MODIFIED BY				: Gopikannan P
MODIFIED ON				: 20-SEP-2013	
REASON					: Fine Tuned for Better Performance
-----------------------------------------------------------------------------*/
online_barcode_label(int nolabel1)
{
	char l_comm_line[1000];
	int status;
	FILE *ifp,*ofp;
	int i,col,row,line_no,rot,font,horm,verm,spec_flag=0;
	char buffer[200],imag;
	char *tmp_buf;
	int bldline;
	int printcopies1 = 0;
	
	BVLanguageIsAPL = 0;
	bldline = 3;
		
	printcopies1 = nolabel1;

    if (strcmp(reprint_yn,"Y") == 0)
    {
		printcopies1 = d_NumOfCopies;
    }	

//sprintf(string_var,"online_barcode_label..1..filename=%s,apgmid=%s",filename,a_pgm_id.arr);
//disp_message(ERR_MESG,string_var); 

	ifp = fopen(filename,"r");
	if (ifp==NULL)
	{
		sprintf(string_var,"File Opening-r Error");
		ins_message(ORA_MESG, string_var);
		return 0;
	}

	sprintf(filenamezpl, "%s%s%s", filename_ap, a_pgm_id.arr, ".zpl");	

	ofp = fopen(filenamezpl,"w");  
	if (ofp==NULL)
	{
		sprintf(string_var,"File ZPL Opening-w Error");
		ins_message(ORA_MESG, string_var);
		return 0;
	}	

//	sprintf(string_var,"online_barcode_label..2..filenamezpl=%s",filenamezpl);
//    disp_message(ERR_MESG,string_var); 


	fprintf(ofp,"\nN\n");           //To initialize ZBL interprter in the printer.

	//Ravi Shankar, 08/07/2021, RBU-GHL-CRF-0006, KDAH-CRF-0608
	if (strcmp(l_customer_id.arr,"MC") == 0 || strcmp(l_customer_id.arr,"KDAH") == 0)	
		fprintf(ofp,"D15\n");
	else
	{
	//////////////
		if (BVLanguageIsAPL == 1)
			fprintf(ofp,"D8\n");		//For Argox printer
		else
			fprintf(ofp,"D8\n");        //stating line         
	}
 	col = 25;   
	row = 20; 
    rot =  0;
	font=  2;
	horm=  1;
	verm=  1;
	imag= 'N';
	line_no = 1;  

	for(;fgets(buffer,200,ifp);) 
	{
//	sprintf(string_var,"online_barcode_label..3..buffer=%s",buffer);
//    disp_message(ERR_MESG,string_var); 
     


		if (buffer[0] == '') 
        {              
		// begin of barcode //

		tmp_buf = strtok(buffer+1,"\n");
		strcpy(buffer,tmp_buf);       
		row = row + 10;
		   if (strcmp(l_customer_id.arr,"MOHBR") == 0 )
		   {
			fprintf(ofp, "B%d,%d,%d,%d,%d,%d,%d,%c,\"%s\"\n",col ,row, rot, 3, 2, 4, 65,imag, buffer);  		
		   }
		   else
		   {
			if (strcmp(l_customer_id.arr,"MC") == 0) // added against GHL-CRF-398 on 23.03.2016
			{
			 // Ravi Shankar, 19/10/2017, ICN-Collection/Specimen-Label-Barcode-with-Code128
			 //fprintf(ofp, "B%d,%d,%d,%d,%d,%d,%d,%c,\"%s\"\n",20 ,row, rot, 3, 2, 4, 70,imag, buffer);  		
			 fprintf(ofp, "B%d,%d,%d,%d,%d,%d,%d,%c,\"%s\"\n",100 ,row, rot, 1, 2, 4, 70,imag, buffer);  		
			 ////////////////////
			}
			else
			{
			fprintf(ofp, "B%d,%d,%d,%d,%d,%d,%d,%c,\"%s\"\n",col ,row, rot, 3, 2, 5, 65,imag, buffer); 
			}
		   }

			row = row + 75;
			spec_flag = 1;  
	  }
      else     
	  {  
	     tmp_buf = strtok(buffer,"\n");
		 
		 if (spec_flag == 1)  // to print the specimen no in big.
		   {font = 3; spec_flag=0;}           
		 else
		 {
		   if (line_no == 4 && strcmp(l_customer_id.arr,"MC") == 0 ) 
				font = 3;
		   else
				font = 2; 
		 }

			 if (tmp_buf) 
			 {
				 strcpy(buffer,tmp_buf);         

//disp_message(ERR_MESG,"sss");

				if ( (line_no == bldline)  )  // Make Bold 
					 fprintf(ofp, "A%d,%d,%d,%d,%d,%d,%c,\"%s\"\n", col, row, rot, font, horm, verm, imag, buffer);
					
				else 
					fprintf(ofp, "A%d,%d,%d,%d,%d,%d,%c,\"%s\"\n", col, row, rot, font, horm, verm, imag, buffer);
				
			}
			else             	
			{
			  fprintf(ofp, "A%d,%d,%d,%d,%d,%d,%c,\"%s\"\n", col, row, rot, font, horm, verm, imag, "");
		    }
			
			row = row + 20;  // Next line 		
	  } 

		line_no = line_no+1;
	 } 

///	fprintf(ofp,"P%d\n",nolabel1);  //commented and modified as below on 24.02.2016 against ML-BRU-SCF-1503

	fprintf(ofp,"P%d\n",printcopies1);  // modified on 24.02.2016 against ML-BRU-SCF-1503


	fclose(ofp);
	fclose(ifp);	

    nd_print_source_type.len = strlen(nd_print_source_type.arr);
	nd_print_source.len = strlen(nd_print_source.arr);
	nd_source_type.len = strlen(nd_source_type.arr);
	

	/* EXEC SQL DECLARE PRINTER_ID_CUR CURSOR FOR
	SELECT QUEUE_NAME
	  FROM sm_print_routing a, sm_printer b 
	   WHERE a.report_id = :a_pgm_id
	   AND a.printer_id1 = b.printer_id
	   AND a.dest_locn_type =  DECODE (:nd_source_type,'!', 'O',:nd_print_source_type)
       AND a.dest_locn_code =  DECODE (:nd_source_type,'!', a.dest_locn_code, NVL(LTRIM(RTRIM(:nd_print_source)),a.dest_locn_code))
       AND NVL (a.ws_no, '!!!') = NVL (:nd_ws_no, '!!!'); */ 


	if (OERROR)
	{
		sprintf(string_var,"ERROR IN PRINTER_ID_CUR %s",sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}
	
	/* EXEC SQL OPEN PRINTER_ID_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0011;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )543;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&a_pgm_id;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_source_type;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_print_source_type;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_source_type;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_print_source;
 sqlstm.sqhstl[4] = (unsigned int  )4;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
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
		sprintf(string_var,"ERROR WHILE OPENING PRINTER_ID_CUR %s",sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	nd_printer_queue.arr[0] ='\0';
	nd_printer_queue.len	 = 0;
	
	//ADDED FOR ml-mmoh-crf-0578 
	nd_printer_queue1.arr[0] ='\0';
	nd_printer_queue1.len	 = 0;
	//end ml-mmoh-crf-0578 

	/* EXEC SQL FETCH PRINTER_ID_CUR INTO :nd_printer_queue; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )582;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_printer_queue;
 sqlstm.sqhstl[0] = (unsigned int  )202;
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
		sprintf(string_var,"ERROR WHILE FETCHING PRINTER_ID_CUR %s",sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	if (NODATAFOUND)
	{
		sprintf(string_var,"NODATAFOUND PRINTER_ID_CUR %s",sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}
		
	nd_printer_queue.arr[nd_printer_queue.len]   = '\0';
	
	nd_printer_queue1.arr[nd_printer_queue1.len]   = '\0';//ADDED FOR ml-mmoh-crf-0578 
	

	/* EXEC SQL CLOSE PRINTER_ID_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )601;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
	{
		sprintf(string_var,"ERROR WHILE CLOSING PRINTER_ID_CUR %s",sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}		


    //ADDED FOR ml-mmoh-crf-0578 
	if (strlen(nd_printer_id.arr)>0)
	{
	 /* EXEC SQL
		SELECT QUEUE_NAME 
		INTO   :nd_printer_queue1
		FROM   SM_PRINTER
		WHERE  PRINTER_ID = :nd_printer_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 46;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select QUEUE_NAME into :b0  from SM_PRINTER where PRINTER_I\
D=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )616;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_printer_queue1;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_printer_id;
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


		
		strcpy(nd_printer_queue.arr,nd_printer_queue1.arr);
		
		if (OERROR)
	{
		sprintf(string_var,"SELECTING FROM SM_PRINTER %s",sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}		
	}
	
	//disp_message(ERR_MESG,"sss");
	//disp_message(ERR_MESG,nd_printer_queue.arr);
	
	//end ml-mmoh-crf-0578
		
	if (strlen(nd_printer_queue.arr) > 0)
	{
		sprintf(l_comm_line,"TYPE %s > %s",filenamezpl, nd_printer_queue.arr);		

///	disp_message(ERR_MESG,l_comm_line); 		
		
		//commented the code for ML-BRU-SCF-0683-1 by krishnamoorthy
		
		/*
		for (i=1;i<=printcopies1;i++)
		{				
			status = system(l_comm_line);			
		}
		*/
		
		
		status = system(l_comm_line);	//added the code for ML-BRU-SCF-0683-1 by krishnamoorthys
		

			if (status == 0) 
			{
				sprintf(string_char, "Printed Sucessfully");
///	disp_message(ERR_MESG,string_char);
			//	ins_message(ORA_MESG, string_var);				
			}
			else
			{		
				sprintf(string_char, "Invalid Printed/Path");
				ins_message(ORA_MESG, l_comm_line);				
///	disp_message(ERR_MESG,string_char);
				ins_message(ORA_MESG, string_var);				
			}	
	}
	else
	{
		sprintf(string_char, "Invalid Printed_ID");
		ins_message(ORA_MESG, string_var);		
		
	}
}
/*-- END Addded by Gopikannan for online_barcode_label --*/

/*--------------------------------------------------*/
ins_message(int msg_type,char msg[])
{
   er_msg.arr[0] = '\0';
   er_msg.len = 0;
   
   er_msg_type = 0;

   strcpy(er_msg.arr,msg);
   er_msg.len = strlen(er_msg.arr);
 
   er_msg_type = msg_type;   


   /* EXEC SQL

   INSERT INTO SY_PROG_MSG
         (OPERATING_FACILITY_ID,PGM_ID,MSG_TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE)
   VALUES 
         (:nd_facility_id,'RLRLBPRN',:er_msg_type,NULL, SUBSTR(:er_msg, 1, 70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/MM/YYYY')); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 46;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_MSG (OPERATING_FACILITY_ID,PGM_ID,MSG_\
TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) values (:b0,'RLRLBPRN\
',:b1,null ,SUBSTR(:b2,1,70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/\
MM/YYYY'))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )639;
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
   sqlstm.sqhstv[1] = (         void  *)&er_msg_type;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&er_msg;
   sqlstm.sqhstl[2] = (unsigned int  )173;
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



   err_flag = 1;
}

/**************************************/
// -- This procedure is used to split the text 
splitting_text2(in_str,max_no,l_long_out_str,l_st_no)
char *in_str,*l_long_out_str;
int max_no,*l_st_no;
{
   
   int j = 0,k = 0,splt = 0,last = 0,l = 0;
   char out_str[100],loc_str[100];
   in_str += (*l_st_no);
   k = last = 0;
   while (1)
   {
       for (j = k;j<k+max_no;j++)
       {
           if (in_str[j] == '\0')
           {
                last = 1;
                break;
           }
       }
       if (last == 1)
       {
           for (l=k;l<k+max_no;l++)
           {
              if (in_str[l] == '\0')
              {
                   if (in_str[l-1] != '\n')
                   {
                       *l_st_no += (strlen(l_long_out_str) + 1);
                       if (l_long_out_str[0] == ' ' && l_long_out_str[1] != ' ')
                              strcpy(l_long_out_str,l_long_out_str+1);
                       return(strlen(l_long_out_str));
                   }
                   break;
              }
              if (in_str[l] != '\n')
                    sprintf(l_long_out_str,"%s%c",l_long_out_str,in_str[l]);
              else
              {
                   *l_st_no += (strlen(l_long_out_str) + 1);
                   if (l_long_out_str[0] == ' ' && l_long_out_str[1] != ' ')
                         strcpy(l_long_out_str,l_long_out_str+1);
                   return(strlen(l_long_out_str));
              }
           }
           break;
       }
       strncpy(loc_str,in_str+k,max_no);
       loc_str[max_no] = '\0';
       splt = find_next_split2(loc_str,max_no);
       strncpy(out_str,loc_str,splt);
       out_str[splt] = '\0';
       sprintf(l_long_out_str,"%s%s",l_long_out_str,out_str);
       *l_st_no += strlen(l_long_out_str);
       if (loc_str[splt] == '\n') (*l_st_no)++;
       if (l_long_out_str[0] == ' ' && l_long_out_str[1] != ' ')
            strcpy(l_long_out_str,l_long_out_str+1);
       return (strlen(l_long_out_str));
       k+=(splt+1);
   }
  
}

find_next_split2(str,max_no)
char str[];
int max_no;
{
   int k = 0,spc = 0,j = 0;
   for (k=0;((k<max_no) && (str[k] != '\0'));k++)
   {
       if (str[k] == '\n')
            return (k);
       if (str[k] == '`' && k >= (max_no/2))
             spc = 1;
   }
   if (spc)
   {
      for (j=k;j>=(max_no/2);j--)
           if (str[j] == '`')
                 return (j+1);
   }
   return(max_no);
}

/**************************************/
// -- This procedure is used to split the text 
splitting_text(in_str,max_no,l_long_out_str,l_st_no)
char *in_str,*l_long_out_str;
int max_no,*l_st_no;
{
   
   int j = 0,k = 0,splt = 0,last = 0,l = 0;
   char out_str[100],loc_str[100];
   in_str += (*l_st_no);
   k = last = 0;
   while (1)
   {
       for (j = k;j<k+max_no;j++)
       {
           if (in_str[j] == '\0')
           {
                last = 1;
                break;
           }
       }
       if (last == 1)
       {
           for (l=k;l<k+max_no;l++)
           {
              if (in_str[l] == '\0')
              {
                   if (in_str[l-1] != '\n')
                   {
                       *l_st_no += (strlen(l_long_out_str) + 1);
                       if (l_long_out_str[0] == ' ' && l_long_out_str[1] != ' ')
                              strcpy(l_long_out_str,l_long_out_str+1);
                       return(strlen(l_long_out_str));
                   }
                   break;
              }
              if (in_str[l] != '\n')
                    sprintf(l_long_out_str,"%s%c",l_long_out_str,in_str[l]);
              else
              {
                   *l_st_no += (strlen(l_long_out_str) + 1);
                   if (l_long_out_str[0] == ' ' && l_long_out_str[1] != ' ')
                         strcpy(l_long_out_str,l_long_out_str+1);
                   return(strlen(l_long_out_str));
              }
           }
           break;
       }
       strncpy(loc_str,in_str+k,max_no);
       loc_str[max_no] = '\0';
       splt = find_next_split1(loc_str,max_no);
       strncpy(out_str,loc_str,splt);
       out_str[splt] = '\0';
       sprintf(l_long_out_str,"%s%s",l_long_out_str,out_str);
       *l_st_no += strlen(l_long_out_str);
       if (loc_str[splt] == '\n') (*l_st_no)++;
       if (l_long_out_str[0] == ' ' && l_long_out_str[1] != ' ')
            strcpy(l_long_out_str,l_long_out_str+1);
       return (strlen(l_long_out_str));
       k+=(splt+1);
   }
  
}

find_next_split1(str,max_no)
char str[];
int max_no;
{
   int k = 0,spc = 0,j = 0;
   for (k=0;((k<max_no) && (str[k] != '\0'));k++)
   {
       if (str[k] == '\n')
            return (k);
       if (str[k] == ',' && k >= (max_no/2))
             spc = 1;
   }
   if (spc)
   {
      for (j=k;j>=(max_no/2);j--)
           if (str[j] == ',')
                 return (j+1);
   }
   return(max_no);
}

convert_sin_chstr(str)
char str[];
{
   int k = 0,spc = 0,j = 0;

   strcpy(o_rem_splitting_text2.arr, "");
   o_rem_splitting_text2.arr[0] = '\0';
   o_rem_splitting_text2.len = strlen(o_rem_splitting_text2.arr);
   for (k=0;((k<32) && (str[k] != '\0'));k++)
   {
    if (str[k] == '`')
	{
      strcat(o_rem_splitting_text2.arr, ",");
	}
	else
	{
    sprintf(o_rem_splitting_text2.arr,"%s%c", o_rem_splitting_text2.arr, str[k]);
	}
   }
   o_rem_splitting_text2.len = strlen(o_rem_splitting_text2.arr);
   o_rem_splitting_text2.arr[o_rem_splitting_text2.len] = '\0';
//   return(o_rem_splitting_text2.arr);
}

//lr_test_name_ar

split_into_words(str)
char str[];
{
   int k = 0,spc = 0,j = 0, arr_ind = 0, xx = 0, l_pos_comma = 0, lp_pos_comma = 0;

   strcpy(o_rem_splitting_text3.arr, "");
   o_rem_splitting_text3.arr[0] = '\0';
   o_rem_splitting_text3.len = strlen(o_rem_splitting_text3.arr);

   strcpy(o_rem_splitting_text4.arr, "");
   o_rem_splitting_text4.len = strlen(o_rem_splitting_text4.arr);
   o_rem_splitting_text4.arr[o_rem_splitting_text4.len] = '\0';

   for (k=0;((k<47) && (str[k] != '\0'));k++)
   {

    if (str[k] == '`')
	{
      strcat(o_rem_splitting_text3.arr, ",");
      o_rem_splitting_text3.len = strlen(o_rem_splitting_text3.arr);
      o_rem_splitting_text3.arr[o_rem_splitting_text3.len] = '\0';

	  strcpy(lr_test_name_ar[arr_ind].arr, o_rem_splitting_text3.arr);
	  arr_ind = arr_ind + 1;
      lr_test_name_ar[arr_ind].len = strlen(lr_test_name_ar[arr_ind].arr);
      lr_test_name_ar[arr_ind].arr[lr_test_name_ar[arr_ind].len] = '\0';

      strcpy(o_rem_splitting_text3.arr, "");
      o_rem_splitting_text3.arr[0] = '\0';
      o_rem_splitting_text3.len = strlen(o_rem_splitting_text3.arr);
	}
	else
	{
      sprintf(o_rem_splitting_text3.arr,"%s%c", o_rem_splitting_text3.arr, str[k]);
	}
   }
   o_rem_splitting_text3.len = strlen(o_rem_splitting_text3.arr);
   o_rem_splitting_text3.arr[o_rem_splitting_text3.len] = '\0';

   strcpy(lr_test_name_ar[arr_ind].arr, o_rem_splitting_text3.arr);
   arr_ind = arr_ind + 1;
   lr_test_name_ar[arr_ind].len = strlen(lr_test_name_ar[arr_ind].arr);
   lr_test_name_ar[arr_ind].arr[lr_test_name_ar[arr_ind].len] = '\0';

   strcpy(o_rem_splitting_text2.arr, "");
   o_rem_splitting_text2.len = strlen(o_rem_splitting_text2.arr);
   o_rem_splitting_text2.arr[o_rem_splitting_text2.len] = '\0';

   strcpy(o_rem_splitting_text4.arr, "");
   o_rem_splitting_text4.len = strlen(o_rem_splitting_text4.arr);
   o_rem_splitting_text4.arr[o_rem_splitting_text4.len] = '\0';

    for(xx=0; xx < arr_ind ; xx++)
	{

      lp_pos_comma = l_pos_comma;

	  l_pos_comma  = l_pos_comma  + strlen(lr_test_name_ar[xx].arr);

      strcat(o_rem_splitting_text2.arr, lr_test_name_ar[xx].arr);
      o_rem_splitting_text2.len = strlen(o_rem_splitting_text2.arr);
      o_rem_splitting_text2.arr[o_rem_splitting_text2.len] = '\0';

//	  sprintf(string_char, "lr_test_name_ar[xx].arr %s %d %d ", lr_test_name_ar[xx].arr, xx, arr_ind );
//	  disp_message(ERR_MESG, string_char);

//	  sprintf(string_char, "test , last_commma_pos %s %d %d %d %d", o_rem_splitting_text2.arr, l_pos_comma, lp_pos_comma, (32 - lp_pos_comma ) , strlen(lr_test_name_ar[xx].arr) );
//	  disp_message(ERR_MESG, string_char);

	  if ( l_pos_comma > 31) 
      {

		  strncpy(o_rem_splitting_text4.arr, o_rem_splitting_text2.arr, 27);
		  o_rem_splitting_text4.len = strlen(o_rem_splitting_text4.arr);
		  o_rem_splitting_text4.arr[o_rem_splitting_text4.len] = '\0';
		  strcat(o_rem_splitting_text4.arr, "...");
		  o_rem_splitting_text4.len = strlen(o_rem_splitting_text4.arr);
		  o_rem_splitting_text4.arr[o_rem_splitting_text4.len] = '\0';
		 if (l_pos_comma > 31)
		 {
		   break;
		 }
	  }
	  else
	  {

		if( strlen(o_rem_splitting_text.arr) < 32)
		{
		  strncpy(o_rem_splitting_text4.arr, o_rem_splitting_text2.arr, 30 );
          o_rem_splitting_text4.len = strlen(o_rem_splitting_text4.arr);
		  o_rem_splitting_text4.arr[o_rem_splitting_text4.len] = '\0';

//		  sprintf(string_char, "ELSE, last_commma_pos %s %sQ %d %d ", o_rem_splitting_text4.arr, o_rem_splitting_text2.arr, l_pos_comma, lp_pos_comma  );
//		  disp_message(ERR_MESG, string_char);
		}
	  }

	}


//	  sprintf(string_char, "LAST , last_commma_pos %s ", o_rem_splitting_text4.arr);
//	  disp_message(ERR_MESG, string_char);

	  fprintf(f1,"%-30.30s", o_rem_splitting_text4.arr);
	  fprintf(f1, "\n");	

	  strcpy(o_rem_splitting_text4.arr, o_rem_splitting_text2.arr);
      o_rem_splitting_text4.len = strlen(o_rem_splitting_text4.arr);
	  o_rem_splitting_text4.arr[o_rem_splitting_text4.len] = '\0';

//   return(o_rem_splitting_text2.arr);
}


find_last_comma(str, last_comma)
char str[];
int last_comma;
{
   int k = 0,spc = 0,j = 0;

   for (k=0;((k<52) && (str[k] != '\0'));k++)
   {
    if (str[k] == '`')
	{
		
       last_comma = k;
	   if (last_comma >= 29)
	     last_comma = k;
	   else
		prev_last_comma = k;
	}
   }
   return(last_comma);
}

// below program added on 27 Mar 2008 
extract_act_user(char l_user_str[])
{

	char dup_user[100];
	char l_act_string[200];
	int i = 0;

	strcpy(dup_user, "");
    dup_user[0] = '\0';

    l_temp1.arr[0] = '\0';
	l_temp1.len = 0;


	strcpy(l_act_string, "");
    l_act_string[0] = '\0';

	strcpy(l_act_string, l_user_str);

	strcpy (dup_user, strtok (l_act_string, "/"));


	if (strcmp(strupr(dup_user),"APPLUSER") == 0)
	{
		for ( i = 0 ; i < strlen(l_user_str); i++)
		{
			if ( l_user_str[i] == '#' )
			{
				break;
			}
			else
			{
				//l_temp[i] = l_user_str[i];			
				l_temp1.arr[i] = l_user_str[i];			
//				strcpy(l_temp.arr[i],l_user_str[i]);
				l_temp1.len = strlen(l_temp1.arr);
				l_temp1.arr[l_temp1.len] = '\0';
			}
		    
		}
	
		strcpy(uid_pwd.arr,l_temp1.arr);
		uid_pwd.len = strlen(uid_pwd.arr); 
        uid_pwd.arr[uid_pwd.len] = '\0';
	}
//disp_message(ERR_MESG, "end of extract_act_user()");
}

/**------------***** ADDED ON 19/08/2011 AGAINST SIRIRAJ REQUIRMENT to increase the height of barcode in
	Intermec printer, hence the test name line wants to comment ----------------------******/
get_site_customer_id()
{
	l_customer_id.arr[0]		= '\0';
	l_customer_id.len		= 0;

	/* EXEC SQL SELECT NVL(customer_id, '!!')
		INTO l_customer_id
		FROM SM_SITE_PARAM; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 46;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(customer_id,'!!') into :b0  from SM_SITE_PARAM ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )666;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_customer_id;
 sqlstm.sqhstl[0] = (unsigned int  )52;
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


		
	

	l_customer_id.arr[l_customer_id.len]	= '\0';

	if (NO_DATA_FOUND);

	if (OERROR);

}
