
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
           char  filnam[29];
};
static const struct sqlcxp sqlfpn =
{
    28,
    "C:\\TEMP\\DISPATCH\\BLRDSPLT.PC"
};


static unsigned long sqlctx = 1442937787;


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
            void  *sqhstv[41];
   unsigned int   sqhstl[41];
            int   sqhsts[41];
            void  *sqindv[41];
            int   sqinds[41];
   unsigned int   sqharm[41];
   unsigned int   *sqharc[41];
   unsigned short  sqadto[41];
   unsigned short  sqtdso[41];
} sqlstm = {10,41};

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
"3,'!!!!!!!!!!!!!!!!!!!!') and nvl(:b\
4,'~~~~~~~~~~~~~~~~~~~~')) and nvl(FINALIZED_YN,'N')=Decode(:b5,'N','N',Decod\
e(:b6,'BLTCVFNL','N','Y'))) and nvl(CANCELLED_YN,'N')<>'Y')           ";

 static const char *sq0019 = 
"select RMRK_SRNO ,REMARKS_TEXT  from BL_COVERING_LET_HEADER_RMRKS where ((O\
PERATING_FACILITY_ID=:b0 and DOC_REF_NUM=:b1) and action_type='P')           ";

 static const char *sq0021 = 
"select B.DOC_TYPE_CODE ,B.DOC_NUMBER ,((B.DOC_TYPE_CODE||'/')||TO_CHAR(B.DO\
C_NUMBER)) ,to_char(B.DOC_DATE,'DD/MM/YYYY') ,B.DOC_AMT ,substr(B.PRINT_TEXT,\
1,45)  from BL_CUST_DISPATCH_LET_DETAIL B where (((B.OPERATING_FACILITY_ID=:b\
0 and DOC_REF_NUM=:b1) and NVL(CANCELLED_YN,'N')<>'Y') and NVL(REJECTED_BY_PA\
YER_YN,'N')<>'Y') order by to_char(B.DOC_DATE,'DD/MM/YYYY'),B.DOC_TYPE_CODE,B\
.DOC_NUMBER            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,233,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,290,0,0,0,0,0,1,0,
51,0,0,3,93,0,4,301,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
78,0,0,4,205,0,4,333,0,0,10,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
133,0,0,5,84,0,2,375,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
160,0,0,6,218,0,4,413,0,0,8,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,1,9,0,0,
207,0,0,7,1207,0,9,502,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
250,0,0,7,0,0,15,509,0,0,0,0,0,1,0,
265,0,0,7,0,0,13,626,0,0,41,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,
444,0,0,8,96,0,4,783,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
471,0,0,9,185,0,4,805,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
506,0,0,10,189,0,4,811,0,0,5,4,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
541,0,0,11,188,0,4,821,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
572,0,0,12,192,0,4,828,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
603,0,0,13,152,0,4,840,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
638,0,0,14,120,0,4,865,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
669,0,0,15,110,0,4,887,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
696,0,0,16,169,0,4,1271,0,0,5,4,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
731,0,0,17,166,0,4,1281,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
762,0,0,18,49,0,4,1779,0,0,1,0,0,1,0,2,3,0,0,
781,0,0,20,135,0,4,1805,0,0,3,2,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,
808,0,0,19,152,0,9,1817,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
831,0,0,19,0,0,15,1824,0,0,0,0,0,1,0,
846,0,0,19,0,0,13,1838,0,0,2,0,0,1,0,2,3,0,0,2,9,0,0,
869,0,0,21,406,0,9,1956,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
892,0,0,21,0,0,15,1964,0,0,0,0,0,1,0,
907,0,0,22,132,0,4,1974,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
934,0,0,21,0,0,13,2089,0,0,6,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,
9,0,0,
973,0,0,23,96,0,4,2368,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
996,0,0,24,165,0,6,2375,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
1027,0,0,25,46,0,4,2529,0,0,4,3,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,2,3,0,0,
1058,0,0,26,47,0,4,2553,0,0,4,3,0,1,0,1,9,0,0,1,3,0,0,1,3,0,0,2,9,0,0,
1089,0,0,27,47,0,4,2725,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
1116,0,0,28,47,0,4,2743,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
1143,0,0,29,47,0,4,2761,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
1170,0,0,30,47,0,4,2778,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
1197,0,0,31,47,0,4,2795,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
1224,0,0,32,46,0,4,2812,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,3,0,0,
1251,0,0,33,47,0,4,2829,0,0,2,1,0,1,0,1,9,0,0,2,3,0,0,
1274,0,0,34,658,0,6,2853,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
1301,0,0,35,219,0,6,2986,0,0,9,9,0,1,0,2,3,0,0,1,9,0,0,1,4,0,0,1,3,0,0,1,9,0,0,
1,9,0,0,1,3,0,0,2,9,0,0,2,9,0,0,
1352,0,0,36,52,0,4,3002,0,0,2,1,0,1,0,1,9,0,0,2,9,0,0,
1375,0,0,37,69,0,4,3052,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1398,0,0,38,199,0,6,3085,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
1425,0,0,39,200,0,6,3110,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};



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
#define ONLINE_PRINTING 1
#define MAX_LINES 41
#define LENGTH_WORDS 150
#define REP_WIDTH 180
#define VER  "VER : 4.10\n"
#define ESC  0x1B
   

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

//#define ONLINE_PRINTING 0

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR	 lv_user_id       [91],
			 lv_pword 		  [91],
			 lv_session_id    [16],
			 lv_pgm_date      [25],
			 lv_pgm_id		  [10],
			 lv_facility_id	   [3],
			 nd_facility_id	   [3],
			 lv_smcheck        [2],
			 lv_report_desc   [61],
			 hosp_name		  [60],
			 p_fr_dt          [30],
			 p_to_dt          [30],
			 p_from_doc	      [31],
			 p_to_doc         [31],
			 p_print_ind	   [2],
			 p_finalize_yn     [2],
			 p_policy          [2],	
			 p_print_opt	   [2],
			 p_sort_order	   [2],
			 d_user			   [40],
			 d_date_time	   [22],
			 d_doc_ref_num     [31],
			 d_doc_ref_date    [41],
 			 d_mail_addr1	   [41],
			 d_mail_addr2      [41],
			 d_mail_addr3      [41],
			 d_mail_addr4      [41],
			 d_postal_code	   [21],
			 d_post_box        [21],
			 d_country_code    [10],
			 d_country         [50],
			 d_tel_num         [31],
			 d_fax_num         [31],
			 d_email_id        [31],
			 d_body_header_yn  [2],
			 d_doc_type        [7],
			 d_group_code      [7],
			 d_cust_code	   [9],
			 d_cust_pat		   [45],
			 d_cust_pat_title  [50],
			 d_base_currency   [25],
		     subcur			   [7],

			 d_contact_name	       [50],
			 d_contact_name_title  [60],
			 d_comp_name		   [300],

			 d_let_bd_hd_ln01		 [101],
			 d_let_bd_hd_ln02		 [101],
			 d_let_body_header_ln03  [101],
			 d_let_body_header_ln04  [101],
			 d_let_bd_hd_ln05        [101],

			 d_patient_id		[21],
			 nd_patient_id		[21],
			 nd_patient		    [41],
			 d_doc_type_code	[9],
			 d_doc_number		[16],
			 d_doc_date		    [16],

			 d_body_foot_yn		[2],
			 d_let_body_footer_ln01 [101],
			 d_let_body_footer_ln02 [101],
			 d_let_body_footer_ln03 [101],
			 d_let_body_footer_ln04 [101],
			 d_let_body_footer_ln05 [101],

			 d_authorized_sign_yn	    [2],
			 d_authorized_signatory	    [41],
			 d_authorized_signatory_desg[31],

			 d_foot_note_yn		      [2],
			 d_foreign_currency_yn	  [2],
			 d_foreign_currency_desc  [16],
			 d_foreign_sub_currency	  [16],
			 d_foreign_currency_note  [301],

			 d_let_foot_note_ln01		[101],
			 d_let_foot_note_ln02		[101],
			 d_let_foot_note_ln03		[101],
			 d_let_foot_note_ln04		[101],
			 d_let_foot_note_ln05		[101],

			 d_print_text_yn		[2],
			 d_cancelled_yn			[2],
			 d_finalized_yn			[2],
			 d_printed_yn			[2],
			 d_policy_type          [51],
			 d_policy_code			[21],
			 d_policy_num			[31],
			 d_print_text           [61],
			 d_print_ins_yn			[2],
			 l_translated_value	    [201],
			 l_pk_value			    [100],
			 nd_let_bd_hd_ln02_final[201],
			 d_remark_text		    [201],
			 p_language_id			[3],
			 nd_temp_date			[41],
			 nd_loc_date			[41]; */ 
struct { unsigned short len; unsigned char arr[91]; } lv_user_id;

struct { unsigned short len; unsigned char arr[91]; } lv_pword;

struct { unsigned short len; unsigned char arr[16]; } lv_session_id;

struct { unsigned short len; unsigned char arr[25]; } lv_pgm_date;

struct { unsigned short len; unsigned char arr[10]; } lv_pgm_id;

struct { unsigned short len; unsigned char arr[3]; } lv_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[2]; } lv_smcheck;

struct { unsigned short len; unsigned char arr[61]; } lv_report_desc;

struct { unsigned short len; unsigned char arr[60]; } hosp_name;

struct { unsigned short len; unsigned char arr[30]; } p_fr_dt;

struct { unsigned short len; unsigned char arr[30]; } p_to_dt;

struct { unsigned short len; unsigned char arr[31]; } p_from_doc;

struct { unsigned short len; unsigned char arr[31]; } p_to_doc;

struct { unsigned short len; unsigned char arr[2]; } p_print_ind;

struct { unsigned short len; unsigned char arr[2]; } p_finalize_yn;

struct { unsigned short len; unsigned char arr[2]; } p_policy;

struct { unsigned short len; unsigned char arr[2]; } p_print_opt;

struct { unsigned short len; unsigned char arr[2]; } p_sort_order;

struct { unsigned short len; unsigned char arr[40]; } d_user;

struct { unsigned short len; unsigned char arr[22]; } d_date_time;

struct { unsigned short len; unsigned char arr[31]; } d_doc_ref_num;

struct { unsigned short len; unsigned char arr[41]; } d_doc_ref_date;

struct { unsigned short len; unsigned char arr[41]; } d_mail_addr1;

struct { unsigned short len; unsigned char arr[41]; } d_mail_addr2;

struct { unsigned short len; unsigned char arr[41]; } d_mail_addr3;

struct { unsigned short len; unsigned char arr[41]; } d_mail_addr4;

struct { unsigned short len; unsigned char arr[21]; } d_postal_code;

struct { unsigned short len; unsigned char arr[21]; } d_post_box;

struct { unsigned short len; unsigned char arr[10]; } d_country_code;

struct { unsigned short len; unsigned char arr[50]; } d_country;

struct { unsigned short len; unsigned char arr[31]; } d_tel_num;

struct { unsigned short len; unsigned char arr[31]; } d_fax_num;

struct { unsigned short len; unsigned char arr[31]; } d_email_id;

struct { unsigned short len; unsigned char arr[2]; } d_body_header_yn;

struct { unsigned short len; unsigned char arr[7]; } d_doc_type;

struct { unsigned short len; unsigned char arr[7]; } d_group_code;

struct { unsigned short len; unsigned char arr[9]; } d_cust_code;

struct { unsigned short len; unsigned char arr[45]; } d_cust_pat;

struct { unsigned short len; unsigned char arr[50]; } d_cust_pat_title;

struct { unsigned short len; unsigned char arr[25]; } d_base_currency;

struct { unsigned short len; unsigned char arr[7]; } subcur;

struct { unsigned short len; unsigned char arr[50]; } d_contact_name;

struct { unsigned short len; unsigned char arr[60]; } d_contact_name_title;

struct { unsigned short len; unsigned char arr[300]; } d_comp_name;

struct { unsigned short len; unsigned char arr[101]; } d_let_bd_hd_ln01;

struct { unsigned short len; unsigned char arr[101]; } d_let_bd_hd_ln02;

struct { unsigned short len; unsigned char arr[101]; } d_let_body_header_ln03;

struct { unsigned short len; unsigned char arr[101]; } d_let_body_header_ln04;

struct { unsigned short len; unsigned char arr[101]; } d_let_bd_hd_ln05;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[41]; } nd_patient;

struct { unsigned short len; unsigned char arr[9]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_doc_number;

struct { unsigned short len; unsigned char arr[16]; } d_doc_date;

struct { unsigned short len; unsigned char arr[2]; } d_body_foot_yn;

struct { unsigned short len; unsigned char arr[101]; } d_let_body_footer_ln01;

struct { unsigned short len; unsigned char arr[101]; } d_let_body_footer_ln02;

struct { unsigned short len; unsigned char arr[101]; } d_let_body_footer_ln03;

struct { unsigned short len; unsigned char arr[101]; } d_let_body_footer_ln04;

struct { unsigned short len; unsigned char arr[101]; } d_let_body_footer_ln05;

struct { unsigned short len; unsigned char arr[2]; } d_authorized_sign_yn;

struct { unsigned short len; unsigned char arr[41]; } d_authorized_signatory;

struct { unsigned short len; unsigned char arr[31]; } d_authorized_signatory_desg;

struct { unsigned short len; unsigned char arr[2]; } d_foot_note_yn;

struct { unsigned short len; unsigned char arr[2]; } d_foreign_currency_yn;

struct { unsigned short len; unsigned char arr[16]; } d_foreign_currency_desc;

struct { unsigned short len; unsigned char arr[16]; } d_foreign_sub_currency;

struct { unsigned short len; unsigned char arr[301]; } d_foreign_currency_note;

struct { unsigned short len; unsigned char arr[101]; } d_let_foot_note_ln01;

struct { unsigned short len; unsigned char arr[101]; } d_let_foot_note_ln02;

struct { unsigned short len; unsigned char arr[101]; } d_let_foot_note_ln03;

struct { unsigned short len; unsigned char arr[101]; } d_let_foot_note_ln04;

struct { unsigned short len; unsigned char arr[101]; } d_let_foot_note_ln05;

struct { unsigned short len; unsigned char arr[2]; } d_print_text_yn;

struct { unsigned short len; unsigned char arr[2]; } d_cancelled_yn;

struct { unsigned short len; unsigned char arr[2]; } d_finalized_yn;

struct { unsigned short len; unsigned char arr[2]; } d_printed_yn;

struct { unsigned short len; unsigned char arr[51]; } d_policy_type;

struct { unsigned short len; unsigned char arr[21]; } d_policy_code;

struct { unsigned short len; unsigned char arr[31]; } d_policy_num;

struct { unsigned short len; unsigned char arr[61]; } d_print_text;

struct { unsigned short len; unsigned char arr[2]; } d_print_ins_yn;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } nd_let_bd_hd_ln02_final;

struct { unsigned short len; unsigned char arr[201]; } d_remark_text;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[41]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[41]; } nd_loc_date;

		  

/* VARCHAR     str_var					[201],
			str_var2				[201],
			line_var				[201],
			dup_var					[201],
			lc_str_val				[201],
			lc_str_var				[201],
			tab_name				[31],
			ls_str_var				[201],
			lc_var					[3],
			ls_char_var				[3],
			ls_str					[201],
			ls_var					[201],
			lc_splch_var			[201],
			amtword					[999],
			amtwordanx              [999]; */ 
struct { unsigned short len; unsigned char arr[201]; } str_var;

struct { unsigned short len; unsigned char arr[201]; } str_var2;

struct { unsigned short len; unsigned char arr[201]; } line_var;

struct { unsigned short len; unsigned char arr[201]; } dup_var;

struct { unsigned short len; unsigned char arr[201]; } lc_str_val;

struct { unsigned short len; unsigned char arr[201]; } lc_str_var;

struct { unsigned short len; unsigned char arr[31]; } tab_name;

struct { unsigned short len; unsigned char arr[201]; } ls_str_var;

struct { unsigned short len; unsigned char arr[3]; } lc_var;

struct { unsigned short len; unsigned char arr[3]; } ls_char_var;

struct { unsigned short len; unsigned char arr[201]; } ls_str;

struct { unsigned short len; unsigned char arr[201]; } ls_var;

struct { unsigned short len; unsigned char arr[201]; } lc_splch_var;

struct { unsigned short len; unsigned char arr[999]; } amtword;

struct { unsigned short len; unsigned char arr[999]; } amtwordanx;


/* VARCHAR	    amt_in_words1	[2000],
			amt_in_words_Sep [2000],
			amt_in_words_Sep1 [2000]; */ 
struct { unsigned short len; unsigned char arr[2000]; } amt_in_words1;

struct { unsigned short len; unsigned char arr[2000]; } amt_in_words_Sep;

struct { unsigned short len; unsigned char arr[2000]; } amt_in_words_Sep1;


int         no_of_lines,no_of_characts;

/* varchar		p_org_str				[100],
			p_add_str				[100],
			p_search_string			[3],
			p_ret_str				[201],
			p_calling_pgm_id		[9]; */ 
struct { unsigned short len; unsigned char arr[100]; } p_org_str;

struct { unsigned short len; unsigned char arr[100]; } p_add_str;

struct { unsigned short len; unsigned char arr[3]; } p_search_string;

struct { unsigned short len; unsigned char arr[201]; } p_ret_str;

struct { unsigned short len; unsigned char arr[9]; } p_calling_pgm_id;


char num_var[5];
	 
char sql_stmt						[1000], 			
     sql_stmt1						[1000],
     sql_stmt2						[1000],
	 string_arr						[1000], 
	 new_str						[201];	

int date_yn = 0,line_ctr = 0,lskip =0;
int splch_pos,st_pos,spchar_type,bold_st = 0,font_st = 0;
int spchar_pos = 0,spchar_pos1,ctr;
int i,bl_doc_srl_no,pos_var,pos_var1,pos_var2,print_upto,pos_length,var_length;
int l_pos,lv_var,j,len_lc_str_val,prt_len,print_upto_c,ld_var,char_pos;
int ld_pos,ld_length;
int sl_no=0,cnt_rem=0;
			              
int i,lno,lctr,bill_cnt,l_decimal,d_doc_num,d_rmrk_srno,d_print_count=0;

double   d_doc_amt,d_bill_amt,nd_tot_bill_amt,
	 d_outst_amt,nd_tot_outst_amt,d_tot_outst_amt=0;

int bill_cnt1=0;
int bill_cnt2=0;
int no_of_docs_in_cl = 0, tot_rows=0;
int page_no=0;
int d_pat_id_len=0;

char s_var[100];
char filename[150];
char x_msg[200];
char loc_legend[999][201];
char l_mesg[200];
char   amt_in_words	[10][133]; 
char  p_amt_in_words [10][133];
char hdr_amt_in_words [10][133];

int ctr = 0,  len = 0,lenamt=0,lenamtanx=0,len_desc=0;
int r_ctr = 0;
int r_ctr_rem = 0;
int r_ctramt = 0;
int r_ctramtanx = 0;
int r_ctrdesc=0;
int r_ctr_anx = 0;
char l_string[300];
char cl_string[300];
char cl_string_rem[300];
char cl_string_anx[300];
char cl_stringamt[300];
char cl_stringamtanx[300];
char cl_string_desc[500];

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

void proc_main(argc,argv)
	char *argv[];
	int	 argc;
{
    if (argc < 5)
    {
		disp_message(ERR_MESG, "Not enough Parameters to run this program.");
		proc_exit();
    }

    strcpy(g_pgm_id, "BLRDSPLT");

    strcpy(lv_pword.arr, argv[1]);

	lv_pword.len = strlen(lv_pword.arr);
	/* EXEC SQL CONNECT :lv_pword; */ 

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
 sqlstm.sqhstv[0] = (         void  *)&lv_pword;
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



	strcpy(lv_smcheck.arr, argv[5]);
	lv_smcheck.len = strlen(lv_smcheck.arr);

    if(strcmp(lv_smcheck.arr,"Y")==0)
	
	set_meduser_role(); 
	strcpy(p_language_id.arr,l_language_id.arr);
    p_language_id.len = l_language_id.len;

		
	if (sqlca.sqlcode < 0 )
	{
        disp_message(ORA_MESG, "Error in connecting to Oracle.");
        proc_exit();
    }

    strcpy(lv_pgm_id.arr, g_pgm_id); 
    lv_pgm_id.len = strlen(lv_pgm_id.arr); 

    strcpy(lv_session_id.arr, argv[2]);
    lv_session_id.len = strlen(lv_session_id.arr);
    strcpy(g_session_id, lv_session_id.arr);

    strcpy(lv_pgm_date.arr, argv[3]);
    lv_pgm_date.len = strlen(lv_pgm_date.arr);
    strcpy(g_pgm_date, lv_pgm_date.arr);

    strcpy(lv_facility_id.arr, argv[4]);
    lv_facility_id.len = strlen(lv_facility_id.arr);
    strcpy(g_facility_id, lv_facility_id.arr);
    fn_open_file();
    
    
	//get_language_id(); commented on 1/4/2008
	
	fn_fetch_parameters();

	fn_fetch_hosp_name();
	
	declare_cursor();

    //fn_open_file(); //pradeep

	fetch_legend_value();
 
	open_head_cur();
 	fprintf(fp,"%c&l0O",ESC); 		// To print in portrait mode
     do_report();
 	//fn_print_settings();
 	close_head_cur();
     //fprintf(fp,"%c&l26A",ESC); //A4Size  //commented for 19366 because of this line extra blan page is printing
 	//fprintf(fp,"%cE",ESC);		// To reset the printer

	fclose(fp);
 	//fn_print_online();
     /* EXEC SQL COMMIT WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 4;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )36;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
		err_mesg("COMMIT WORK RELEASE failed.",0,"");
}

fn_fetch_parameters()
{
	lv_report_desc.arr[0] = '\0';
	lv_report_desc.len    =   0 ;


	/* EXEC SQL SELECT report_desc 
			 INTO   lv_report_desc
			 FROM   sm_report_lang_vw 
			 WHERE  report_id  = :lv_pgm_id
			 AND    language_id= :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select report_desc into :b0  from sm_report_lang_vw where (\
report_id=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_report_desc;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lv_pgm_id;
 sqlstm.sqhstl[1] = (unsigned int  )12;
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
		err_mesg("SELECT failed on table SM_REPORT.", 0, "");

	lv_report_desc.arr[lv_report_desc.len] = '\0';

	p_fr_dt.arr[0]			= '\0';
	p_to_dt.arr[0]			= '\0';
	p_from_doc.arr[0]       = '\0';
	p_to_doc.arr[0]			= '\0';
	p_print_ind.arr[0]  	= '\0'; 
	p_policy.arr[0]  		= '\0'; 
	p_print_opt.arr[0]		= '\0';
	p_calling_pgm_id.arr[0] = '\0';
	p_finalize_yn.arr[0]    = '\0';
	
	p_fr_dt.len				= 0;
	p_to_dt.len				= 0;
	p_from_doc.len          = 0;
	p_to_doc.len	        = 0;
	p_print_opt.len			= 0;
	p_print_ind.len			= 0;
	p_policy.len			= 0;
	p_calling_pgm_id.len	= 0;
	p_finalize_yn.len		= 0;


	/* EXEC SQL SELECT param1,
					param2,
					param3,
					param4,
					NVL(param5,'N'),
					NVL(param6,'Y'),
					--Nvl(param7,'Y'),
					--nvl(param8,'N'),
					nvl(param9,'BLRDSPLT')
				INTO   
					:p_from_doc,
					:p_to_doc,
					:p_fr_dt,
					:p_to_dt,
					:p_print_ind,
					:p_finalize_yn,
					--:p_policy,
					--:p_print_opt,
					--:p_sort_order,
					:p_calling_pgm_id
			 FROM   sy_prog_param
             WHERE  pgm_id     = :lv_pgm_id
             AND	session_id = :lv_session_id
             AND	pgm_date   = :lv_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select param1 ,param2 ,param3 ,param4 ,NVL(param5,'N') ,NVL\
(param6,'Y') ,nvl(param9,'BLRDSPLT') into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from s\
y_prog_param where ((pgm_id=:b7 and session_id=:b8) and pgm_date=:b9)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )78;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_from_doc;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_to_doc;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_fr_dt;
 sqlstm.sqhstl[2] = (unsigned int  )32;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&p_to_dt;
 sqlstm.sqhstl[3] = (unsigned int  )32;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&p_print_ind;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&p_finalize_yn;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&p_calling_pgm_id;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&lv_pgm_id;
 sqlstm.sqhstl[7] = (unsigned int  )12;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&lv_session_id;
 sqlstm.sqhstl[8] = (unsigned int  )18;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&lv_pgm_date;
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
		err_mesg("SELECT failed on table SY_PROG_PARAM.", 0, "");

	if (NOT_FOUND)
        err_mesg("No record found in SY_PROG_PARAM.", 0, "");

	p_fr_dt.arr[p_fr_dt.len]					= '\0';
	p_to_dt.arr[p_to_dt.len]					= '\0';
	p_from_doc.arr[p_from_doc.len]				= '\0';
	p_to_doc.arr[p_to_doc.len]					= '\0';
	p_print_opt.arr[p_print_opt.len]			= '\0';
	p_print_ind.arr[p_print_ind.len] 			= '\0'; 
	p_policy.arr[p_policy.len]  				= '\0'; 
	p_sort_order.arr[p_sort_order.len]			= '\0';
	p_calling_pgm_id.arr[p_calling_pgm_id.len]	= '\0';
	p_finalize_yn.arr[p_finalize_yn.len]	= '\0';

	/* EXEC SQL DELETE sy_prog_param
             WHERE  pgm_id     = :lv_pgm_id
             AND	session_id = :lv_session_id
             AND	pgm_date   = :lv_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from sy_prog_param  where ((pgm_id=:b0 and session_\
id=:b1) and pgm_date=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )133;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_pgm_id;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lv_session_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&lv_pgm_date;
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
		err_mesg("DELETE failed on table SY_PROG_PARAM.", 0, "");

/*
	EXEC SQL select decode(outstd_doc_in_annex_only_yn, 'Y',0,5)
			 into :no_of_docs_in_cl
			 from bl_cust_dispatch_let_param;

	if (OERROR)
		err_mesg("SELECT failed on table BL_CUST_DISPATCH_LET_PARAM.", 0, "");

	if (NOT_FOUND)
        err_mesg("No record found in BL_CUST_DISPATCH_LET_PARAM.", 0, "");
	*/
}

fn_fetch_hosp_name()
{
	hosp_name.arr[0] = '\0';		
	hosp_name.len    = 0;

	d_base_currency.arr[0] = '\0';	
	subcur.arr[0] = '\0';	

	d_base_currency.len    = 0;
	subcur.len				= 0;

	d_user.arr[0]     ='\0';
	d_user.len		 =0;

	d_date_time.arr[0]  ='\0';
	d_date_time.len     =0;
	
	/* EXEC SQL SELECT acc_entity_name,
					BASE_CURRENCY,
					BASE_CURRENCY_DEC,Nvl(NO_OF_DECIMAL,2),
					USER,
					--TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')
					TO_CHAR(SYSDATE,'DD/MM/YYYY')
			 INTO   :hosp_name,
					:d_base_currency,
					:subcur,
					:l_decimal,
					:d_user,
					:d_date_time
			 FROM   sy_acc_entity_lang_vw
			 WHERE  acc_entity_id = :lv_facility_id
			 AND	LANGUAGE_ID   = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 10;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select acc_entity_name ,BASE_CURRENCY ,BASE_CURRENCY_DEC ,N\
vl(NO_OF_DECIMAL,2) ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY') into :b0,:b1,:b2,:b3\
,:b4,:b5  from sy_acc_entity_lang_vw where (acc_entity_id=:b6 and LANGUAGE_ID\
=:b7)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )160;
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
 sqlstm.sqhstv[1] = (         void  *)&d_base_currency;
 sqlstm.sqhstl[1] = (unsigned int  )27;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&subcur;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_decimal;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_user;
 sqlstm.sqhstl[4] = (unsigned int  )42;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_date_time;
 sqlstm.sqhstl[5] = (unsigned int  )24;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&lv_facility_id;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
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
		err_mesg("SELECT failed while fetching hospital name.", 0, "");

	hosp_name.arr[hosp_name.len]				= '\0';
	d_base_currency.arr[d_base_currency.len]	= '\0';
	subcur.arr[subcur.len]						= '\0';	
	d_user.arr[d_user.len]						= '\0';
	d_date_time.arr[d_date_time.len]			= '\0';
			
}

declare_cursor()
{
  
  /* EXEC SQL DECLARE HEAD_CUR CURSOR FOR
	SELECT 	TO_CHAR(DOC_REF_DATE,'DD/MM/YYYY'),
			DOC_REF_NUM,
			--GROUP_CODE,	
			CUST_CODE,
			CONTACT_NAME,
			CONTACT_NAME_TITLE,     
			MAIL_ADDR_LINE_1,	
			MAIL_ADDR_LINE_2,	
			MAIL_ADDR_LINE_3,	
			MAIL_ADDR_LINE_4,	
			POSTAL_CODE,		
			POST_BOX,		
			COUNTRY_CODE,		
			TEL_NUM,                
			FAX_NUM ,               
			EMAIL_ID ,  
			TOT_OUTST_AMT,            
			--BODY_HEADER_YN,		
			LET_BODY_HEADER_LN01,	
			LET_BODY_HEADER_LN02,	
			LET_BODY_HEADER_LN03,	
			LET_BODY_HEADER_LN04,	
			LET_BODY_HEADER_LN05,	
			--BODY_FOOT_YN,		
			LET_BODY_FOOTER_LN01,	
			LET_BODY_FOOTER_LN02,	
			LET_BODY_FOOTER_LN03,	
			LET_BODY_FOOTER_LN04,	
			LET_BODY_FOOTER_LN05,	
		    --FOOT_NOTE_YN,		
			LET_FOOT_NOTE_LN01,	
			LET_FOOT_NOTE_LN02,	
			LET_FOOT_NOTE_LN03,	
			LET_FOOT_NOTE_LN04,	
			LET_FOOT_NOTE_LN05,	
			FOREIGN_CURRENCY_YN,	
			FOREIGN_CURRENCY_NOTE,	
			AUTHORIZED_SIGNATORY,
			AUTHORIZED_SIGNATORY_DESG,	
			PRINT_TEXT_YN,		
			CANCELLED_YN,		
			FINALIZED_YN,		
			PRINTED_YN,	
		    nvl(PRINT_COUNT,0),
			DECODE(OUTSTD_DOC_IN_ANNEX_ONLY_YN, 'Y',0,5)
			FROM BL_CUST_DISPATCH_LET_HEADER 
		    WHERE OPERATING_FACILITY_ID=:lv_facility_id
	        AND TRUNC(DOC_REF_DATE)  BETWEEN  trunc(to_date(NVL(:p_fr_dt,'01/01/1000'),'DD/MM/YYYY')) AND trunc(to_date(NVL(:p_to_dt,'31/12/4000'),'DD/MM/YYYY'))
	        AND DOC_REF_NUM   BETWEEN nvl(:p_from_doc,'!!!!!!!!!!!!!!!!!!!!') AND nvl(:p_to_doc,'~~~~~~~~~~~~~~~~~~~~')
			AND nvl(FINALIZED_YN,'N')= Decode(:p_finalize_yn,'N','N',Decode(:p_calling_pgm_id,'BLTCVFNL','N','Y'))
																
			AND nvl(CANCELLED_YN,'N') <> 'Y'; */ 



}

open_head_cur()
{
  /* EXEC SQL OPEN HEAD_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0,
    "select TO_CHAR(DOC_REF_DATE,'DD/MM/YYYY') ,DOC_REF_NUM ,CUST_CODE ,CONT\
ACT_NAME ,CONTACT_NAME_TITLE ,MAIL_ADDR_LINE_1 ,MAIL_ADDR_LINE_2 ,MAIL_ADDR_\
LINE_3 ,MAIL_ADDR_LINE_4 ,POSTAL_CODE ,POST_BOX ,COUNTRY_CODE ,TEL_NUM ,FAX_\
NUM ,EMAIL_ID ,TOT_OUTST_AMT ,LET_BODY_HEADER_LN01 ,LET_BODY_HEADER_LN02 ,LE\
T_BODY_HEADER_LN03 ,LET_BODY_HEADER_LN04 ,LET_BODY_HEADER_LN05 ,LET_BODY_FOO\
TER_LN01 ,LET_BODY_FOOTER_LN02 ,LET_BODY_FOOTER_LN03 ,LET_BODY_FOOTER_LN04 ,\
LET_BODY_FOOTER_LN05 ,LET_FOOT_NOTE_LN01 ,LET_FOOT_NOTE_LN02 ,LET_FOOT_NOTE_\
LN03 ,LET_FOOT_NOTE_LN04 ,LET_FOOT_NOTE_LN05 ,FOREIGN_CURRENCY_YN ,FOREIGN_C\
URRENCY_NOTE ,AUTHORIZED_SIGNATORY ,AUTHORIZED_SIGNATORY_DESG ,PRINT_TEXT_YN\
 ,CANCELLED_YN ,FINALIZED_YN ,PRINTED_YN ,nvl(PRINT_COUNT,0) ,DECODE(OUTSTD_\
DOC_IN_ANNEX_ONLY_YN,'Y',0,5)  from BL_CUST_DISPATCH_LET_HEADER where ((((OP\
ERATING_FACILITY_ID=:b0 and TRUNC(DOC_REF_DATE) between trunc(to_date(NVL(:b\
1,'01/01/1000'),'DD/MM/YYYY')) and trunc(to_date(NVL(:b2,'31/12/4000'),'DD/M\
M/YYYY'))) and DOC_REF_NUM between nvl(:b");
  sqlstm.stmt = sq0007;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )207;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&p_fr_dt;
  sqlstm.sqhstl[1] = (unsigned int  )32;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&p_to_dt;
  sqlstm.sqhstl[2] = (unsigned int  )32;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&p_from_doc;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&p_to_doc;
  sqlstm.sqhstl[4] = (unsigned int  )33;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&p_finalize_yn;
  sqlstm.sqhstl[5] = (unsigned int  )4;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&p_calling_pgm_id;
  sqlstm.sqhstl[6] = (unsigned int  )11;
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
         err_mesg("OPEN failed on cursor HEAD_CUR",0,"");
}

close_head_cur()
{
  /* EXEC SQL CLOSE HEAD_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 10;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )250;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fn_open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLRDSPLT.lis");

    if ((fp = fopen(filename, "w")) == NULL)
    {
		
		disp_message(ERR_MESG, "Error in opening file BLRDSPLT.lis");
		proc_exit();
    }
}

fetch_header_cur()
{

	 
	 d_doc_ref_date.arr[0]		='\0';
	 d_doc_ref_num.arr[0]		='\0';
	 d_contact_name.arr[0]		='\0'; 
	 d_group_code.arr[0]		='\0';
	 d_cust_code.arr[0]			='\0';
	 d_contact_name_title.arr[0]='\0';  
	 d_mail_addr1.arr[0]		='\0';   
	 d_mail_addr2.arr[0]		='\0';    
	 d_mail_addr3.arr[0]		='\0';   
     d_mail_addr4.arr[0]		='\0'; 
	 d_postal_code.arr[0]		='\0';	
	 d_post_box.arr[0]			='\0';     
	 d_country_code.arr[0]		='\0'; 
	 d_tel_num.arr[0]			='\0';  
	 d_fax_num.arr[0]			='\0';   
	 d_email_id.arr[0]			='\0'; 
	 d_body_header_yn.arr[0]	='\0';	 
	 d_let_bd_hd_ln01.arr[0]    ='\0';
	 d_let_bd_hd_ln02.arr[0]    ='\0'; 
	 d_let_body_header_ln03.arr[0]    ='\0'; 
	 d_let_body_header_ln04.arr[0]    ='\0';  
	 d_let_bd_hd_ln05.arr[0]		  ='\0'; 
     d_body_foot_yn.arr[0]			  ='\0';
	 d_let_body_footer_ln01.arr[0]    ='\0'; 
	 d_let_body_footer_ln02.arr[0]    ='\0'; 
	 d_let_body_footer_ln03.arr[0]    ='\0'; 
	 d_let_body_footer_ln04.arr[0]    ='\0'; 
	 d_let_body_footer_ln05.arr[0]    ='\0'; 
     d_foot_note_yn.arr[0]			  ='\0';
     d_let_foot_note_ln01.arr[0]		='\0'; 
	 d_let_foot_note_ln02.arr[0]		='\0';   
	 d_let_foot_note_ln03.arr[0]		='\0';  
	 d_let_foot_note_ln04.arr[0]		='\0';  
	 d_let_foot_note_ln05.arr[0]		='\0';  
	 d_foreign_currency_yn.arr[0]		='\0';	
	 d_foreign_currency_desc.arr[0]     ='\0';
	 d_foreign_currency_note.arr[0]		='\0';
	 d_foreign_sub_currency.arr[0]		='\0';
	 d_authorized_sign_yn.arr[0]		='\0';	
     d_authorized_signatory.arr[0]		='\0';
     d_authorized_signatory_desg.arr[0]	='\0';
	 d_print_text_yn.arr[0]				='\0';	
     d_cancelled_yn.arr[0]				='\0';
	 d_finalized_yn.arr[0]				='\0';
	 d_printed_yn.arr[0]				='\0';
	 d_print_ins_yn.arr[0]				='\0';

	 d_doc_ref_date.len						=0;
	 d_doc_ref_num.len						=0;
	 d_group_code.len						=0;
	 d_cust_code.len						=0;
	 d_contact_name.len						=0;
	 d_contact_name_title.len				=0;
	 d_mail_addr1.len						=0;
	 d_mail_addr2.len						=0;   
	 d_mail_addr3.len						=0;   
     d_mail_addr4.len						=0;
	 d_postal_code.len						=0;	
	 d_post_box.len							=0;     
	 d_country_code.len						=0; 
	 d_tel_num.len							=0;  
	 d_fax_num.len							=0;   
	 d_email_id.len							=0; 
	 d_body_header_yn.len					=0;	 
	 d_let_bd_hd_ln01.len					=0;
	 d_let_bd_hd_ln02.len					=0; 
	 d_let_body_header_ln03.len				=0; 
	 d_let_body_header_ln04.len				=0;
	 d_let_bd_hd_ln05.len					=0; 
     d_body_foot_yn.len						=0;
	 d_let_body_footer_ln01.len				=0; 
	 d_let_body_footer_ln02.len				=0; 
	 d_let_body_footer_ln03.len				=0; 
	 d_let_body_footer_ln04.len				=0; 
	 d_let_body_footer_ln05.len				=0; 
     d_foot_note_yn.len						=0;
     d_let_foot_note_ln01.len				=0; 
	 d_let_foot_note_ln02.len				=0;   
	 d_let_foot_note_ln03.len				=0;  
	 d_let_foot_note_ln04.len				=0;  
	 d_let_foot_note_ln05.len				=0;  
	 d_foreign_currency_yn.len				=0;	
	 d_foreign_currency_desc.len			=0;
	 d_foreign_sub_currency.len				=0;
	 d_foreign_currency_note.len			=0;
	 d_authorized_sign_yn.len				=0;	
     d_authorized_signatory.len				=0;
	 d_authorized_signatory_desg.len		=0;
	 d_cancelled_yn.len						=0;
	 d_finalized_yn.len						=0;
	 d_printed_yn.len						=0;
	 d_print_text_yn.len                    =0;
	 d_print_ins_yn.len						=0;
	 d_tot_outst_amt						=0;
	 d_print_count							=0;


    /* EXEC SQL FETCH HEAD_CUR INTO  
	 :d_doc_ref_date ,
	 :d_doc_ref_num,
	 --:d_group_code,
	 :d_cust_code,
	 :d_contact_name, 
	 :d_contact_name_title  ,
	 :d_mail_addr1   ,
	 :d_mail_addr2    ,
	 :d_mail_addr3   ,
	 :d_mail_addr4 ,
	 :d_postal_code	, 
	 :d_post_box     , 
	 :d_country_code  ,
	 :d_tel_num  ,     
	 :d_fax_num   ,  
	 :d_email_id ,
	 :d_tot_outst_amt,
	 --:d_body_header_yn	 ,
	 :d_let_bd_hd_ln01,
	 :d_let_bd_hd_ln02 ,
	 :d_let_body_header_ln03 ,
	 :d_let_body_header_ln04  ,
	 :d_let_bd_hd_ln05 ,
	 --:d_body_foot_yn,
	 :d_let_body_footer_ln01 ,
	 :d_let_body_footer_ln02 ,
	 :d_let_body_footer_ln03 ,
	 :d_let_body_footer_ln04 ,
	 :d_let_body_footer_ln05 ,
	 --:d_foot_note_yn,
	 :d_let_foot_note_ln01  ,
	 :d_let_foot_note_ln02   ,
	 :d_let_foot_note_ln03  ,
	 :d_let_foot_note_ln04  ,
	 :d_let_foot_note_ln05  ,
	 :d_foreign_currency_yn	,		
	 :d_foreign_currency_note,	
	 :d_authorized_signatory,
	 :d_authorized_signatory_desg,
	 :d_print_text_yn		,	
	 :d_cancelled_yn,			
	 :d_finalized_yn,			
	 :d_printed_yn,
	 :d_print_count,
	 :no_of_docs_in_cl; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 41;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )265;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_doc_ref_date;
    sqlstm.sqhstl[0] = (unsigned int  )43;
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
    sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_contact_name;
    sqlstm.sqhstl[3] = (unsigned int  )52;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_contact_name_title;
    sqlstm.sqhstl[4] = (unsigned int  )62;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_mail_addr1;
    sqlstm.sqhstl[5] = (unsigned int  )43;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_mail_addr2;
    sqlstm.sqhstl[6] = (unsigned int  )43;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_mail_addr3;
    sqlstm.sqhstl[7] = (unsigned int  )43;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_mail_addr4;
    sqlstm.sqhstl[8] = (unsigned int  )43;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_postal_code;
    sqlstm.sqhstl[9] = (unsigned int  )23;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_post_box;
    sqlstm.sqhstl[10] = (unsigned int  )23;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_country_code;
    sqlstm.sqhstl[11] = (unsigned int  )12;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_tel_num;
    sqlstm.sqhstl[12] = (unsigned int  )33;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_fax_num;
    sqlstm.sqhstl[13] = (unsigned int  )33;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_email_id;
    sqlstm.sqhstl[14] = (unsigned int  )33;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_tot_outst_amt;
    sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_let_bd_hd_ln01;
    sqlstm.sqhstl[16] = (unsigned int  )103;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&d_let_bd_hd_ln02;
    sqlstm.sqhstl[17] = (unsigned int  )103;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_let_body_header_ln03;
    sqlstm.sqhstl[18] = (unsigned int  )103;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&d_let_body_header_ln04;
    sqlstm.sqhstl[19] = (unsigned int  )103;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&d_let_bd_hd_ln05;
    sqlstm.sqhstl[20] = (unsigned int  )103;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&d_let_body_footer_ln01;
    sqlstm.sqhstl[21] = (unsigned int  )103;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&d_let_body_footer_ln02;
    sqlstm.sqhstl[22] = (unsigned int  )103;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&d_let_body_footer_ln03;
    sqlstm.sqhstl[23] = (unsigned int  )103;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&d_let_body_footer_ln04;
    sqlstm.sqhstl[24] = (unsigned int  )103;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&d_let_body_footer_ln05;
    sqlstm.sqhstl[25] = (unsigned int  )103;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&d_let_foot_note_ln01;
    sqlstm.sqhstl[26] = (unsigned int  )103;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&d_let_foot_note_ln02;
    sqlstm.sqhstl[27] = (unsigned int  )103;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&d_let_foot_note_ln03;
    sqlstm.sqhstl[28] = (unsigned int  )103;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&d_let_foot_note_ln04;
    sqlstm.sqhstl[29] = (unsigned int  )103;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&d_let_foot_note_ln05;
    sqlstm.sqhstl[30] = (unsigned int  )103;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&d_foreign_currency_yn;
    sqlstm.sqhstl[31] = (unsigned int  )4;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqhstv[32] = (         void  *)&d_foreign_currency_note;
    sqlstm.sqhstl[32] = (unsigned int  )303;
    sqlstm.sqhsts[32] = (         int  )0;
    sqlstm.sqindv[32] = (         void  *)0;
    sqlstm.sqinds[32] = (         int  )0;
    sqlstm.sqharm[32] = (unsigned int  )0;
    sqlstm.sqadto[32] = (unsigned short )0;
    sqlstm.sqtdso[32] = (unsigned short )0;
    sqlstm.sqhstv[33] = (         void  *)&d_authorized_signatory;
    sqlstm.sqhstl[33] = (unsigned int  )43;
    sqlstm.sqhsts[33] = (         int  )0;
    sqlstm.sqindv[33] = (         void  *)0;
    sqlstm.sqinds[33] = (         int  )0;
    sqlstm.sqharm[33] = (unsigned int  )0;
    sqlstm.sqadto[33] = (unsigned short )0;
    sqlstm.sqtdso[33] = (unsigned short )0;
    sqlstm.sqhstv[34] = (         void  *)&d_authorized_signatory_desg;
    sqlstm.sqhstl[34] = (unsigned int  )33;
    sqlstm.sqhsts[34] = (         int  )0;
    sqlstm.sqindv[34] = (         void  *)0;
    sqlstm.sqinds[34] = (         int  )0;
    sqlstm.sqharm[34] = (unsigned int  )0;
    sqlstm.sqadto[34] = (unsigned short )0;
    sqlstm.sqtdso[34] = (unsigned short )0;
    sqlstm.sqhstv[35] = (         void  *)&d_print_text_yn;
    sqlstm.sqhstl[35] = (unsigned int  )4;
    sqlstm.sqhsts[35] = (         int  )0;
    sqlstm.sqindv[35] = (         void  *)0;
    sqlstm.sqinds[35] = (         int  )0;
    sqlstm.sqharm[35] = (unsigned int  )0;
    sqlstm.sqadto[35] = (unsigned short )0;
    sqlstm.sqtdso[35] = (unsigned short )0;
    sqlstm.sqhstv[36] = (         void  *)&d_cancelled_yn;
    sqlstm.sqhstl[36] = (unsigned int  )4;
    sqlstm.sqhsts[36] = (         int  )0;
    sqlstm.sqindv[36] = (         void  *)0;
    sqlstm.sqinds[36] = (         int  )0;
    sqlstm.sqharm[36] = (unsigned int  )0;
    sqlstm.sqadto[36] = (unsigned short )0;
    sqlstm.sqtdso[36] = (unsigned short )0;
    sqlstm.sqhstv[37] = (         void  *)&d_finalized_yn;
    sqlstm.sqhstl[37] = (unsigned int  )4;
    sqlstm.sqhsts[37] = (         int  )0;
    sqlstm.sqindv[37] = (         void  *)0;
    sqlstm.sqinds[37] = (         int  )0;
    sqlstm.sqharm[37] = (unsigned int  )0;
    sqlstm.sqadto[37] = (unsigned short )0;
    sqlstm.sqtdso[37] = (unsigned short )0;
    sqlstm.sqhstv[38] = (         void  *)&d_printed_yn;
    sqlstm.sqhstl[38] = (unsigned int  )4;
    sqlstm.sqhsts[38] = (         int  )0;
    sqlstm.sqindv[38] = (         void  *)0;
    sqlstm.sqinds[38] = (         int  )0;
    sqlstm.sqharm[38] = (unsigned int  )0;
    sqlstm.sqadto[38] = (unsigned short )0;
    sqlstm.sqtdso[38] = (unsigned short )0;
    sqlstm.sqhstv[39] = (         void  *)&d_print_count;
    sqlstm.sqhstl[39] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[39] = (         int  )0;
    sqlstm.sqindv[39] = (         void  *)0;
    sqlstm.sqinds[39] = (         int  )0;
    sqlstm.sqharm[39] = (unsigned int  )0;
    sqlstm.sqadto[39] = (unsigned short )0;
    sqlstm.sqtdso[39] = (unsigned short )0;
    sqlstm.sqhstv[40] = (         void  *)&no_of_docs_in_cl;
    sqlstm.sqhstl[40] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[40] = (         int  )0;
    sqlstm.sqindv[40] = (         void  *)0;
    sqlstm.sqinds[40] = (         int  )0;
    sqlstm.sqharm[40] = (unsigned int  )0;
    sqlstm.sqadto[40] = (unsigned short )0;
    sqlstm.sqtdso[40] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	 //:d_print_ins_yn
	 

//    if Front end doesn't pass policy printing ie. from other functions, 
//    Then header Insurance policy printing flag value will be considered

   //-- if( strcmp(p_policy.arr,"\0") ==0)
   //if( strcmp(p_policy.arr,"null") ==0)
   //--  strcpy(p_policy.arr,d_print_ins_yn.arr);

   //--	if( strcmp(p_policy.arr,"Z") ==0)
   //--    strcpy(p_policy.arr,d_print_ins_yn.arr);


if (OERROR)
          err_mesg("FETCH failed on cursor HEAD_CUR",0,"");

	 d_doc_ref_date.arr[d_doc_ref_date.len]					='\0';
	 d_doc_ref_num.arr[d_doc_ref_num.len]					='\0';
	 d_cust_code.arr[d_cust_code.len]						='\0';
     //--d_group_code.arr[d_group_code.len]					='\0';
	 d_contact_name.arr[d_contact_name.len]					='\0'; 
	 d_contact_name_title.arr[d_contact_name_title.len]		='\0';  
	 d_mail_addr1.arr[d_mail_addr1.len]						='\0';   
	 d_mail_addr2.arr[d_mail_addr2.len]						='\0';    
	 d_mail_addr3.arr[d_mail_addr3.len]						='\0';   
     d_mail_addr4.arr[d_mail_addr4.len]						='\0'; 
	 d_postal_code.arr[d_postal_code.len]					='\0';	
	 d_post_box.arr[d_post_box.len]							='\0';     
	 d_country_code.arr[d_country_code.len]					='\0'; 
	 d_tel_num.arr[d_tel_num.len]							='\0';  
	 d_fax_num.arr[d_fax_num.len]							='\0';   
	 d_email_id.arr[d_email_id.len]							='\0'; 
	 d_body_header_yn.arr[ d_body_header_yn.len]			='\0';	 
	 d_let_bd_hd_ln01.arr[d_let_bd_hd_ln01.len]				='\0';
	 d_let_bd_hd_ln02.arr[d_let_bd_hd_ln02.len]				='\0'; 
	 d_let_body_header_ln03.arr[d_let_body_header_ln03.len] ='\0'; 
	 d_let_body_header_ln04.arr[d_let_body_header_ln04.len] ='\0';  
	 d_let_bd_hd_ln05.arr[d_let_bd_hd_ln05.len]				='\0'; 
     d_body_foot_yn.arr[d_body_foot_yn.len]					='\0';
	 d_let_body_footer_ln01.arr[d_let_body_footer_ln01.len] ='\0'; 
	 d_let_body_footer_ln02.arr[d_let_body_footer_ln02.len] ='\0'; 
	 d_let_body_footer_ln03.arr[d_let_body_footer_ln03.len] ='\0'; 
	 d_let_body_footer_ln04.arr[d_let_body_footer_ln04.len] ='\0'; 
	 d_let_body_footer_ln05.arr[d_let_body_footer_ln05.len] ='\0'; 
     d_foot_note_yn.arr[d_foot_note_yn.len]					='\0';
     d_let_foot_note_ln01.arr[d_let_foot_note_ln01.len]		='\0'; 
	 d_let_foot_note_ln02.arr[d_let_foot_note_ln02.len]		='\0';   
	 d_let_foot_note_ln03.arr[d_let_foot_note_ln03.len]		='\0';  
	 d_let_foot_note_ln04.arr[d_let_foot_note_ln04.len]		='\0';  
	 d_let_foot_note_ln05.arr[d_let_foot_note_ln05.len]		='\0';  
	 d_foreign_currency_yn.arr[d_foreign_currency_yn.len]	='\0';	
	 d_foreign_currency_desc.arr[d_foreign_currency_desc.len]			='\0';
	 d_foreign_sub_currency.arr[d_foreign_sub_currency.len]				='\0';
	 d_foreign_currency_note.arr[d_foreign_currency_note.len]			= '\0';
	 d_authorized_sign_yn.arr[d_authorized_sign_yn.len]					='\0';	
     d_authorized_signatory.arr[d_authorized_signatory.len]				='\0';
	 d_authorized_signatory_desg.arr[d_authorized_signatory_desg.len]	='\0';
	 d_cancelled_yn.arr[d_cancelled_yn.len]								='\0';
	 d_finalized_yn.arr[d_finalized_yn.len]								='\0';
	 d_printed_yn.arr[d_printed_yn.len]									='\0';
	 d_print_text_yn.arr[d_print_text_yn.len]							='\0';
     //--d_print_ins_yn.arr[d_print_ins_yn.len]							='\0';

	return(LAST_ROW?0:1);
	
}

do_report()
 {
 
   while(fetch_header_cur())
	 {
	      
		  get_country_det();
		  get_cust_pat();

		  fprintf(fp,"%cE",ESC);				// To reset the printer //fprints
		  fprintf(fp,"%c&l0O",ESC); 			// To print in portait mode//fprintf
		   
		  if(strcmp(p_print_opt.arr,"Y")==0)
		  fprintf(fp,"%c&l2A",ESC);				//Letter Size
		  else
		  fprintf(fp,"%c&l26A",ESC);			//A4Size
			 
		  fprintf(fp,"%c&l1H",ESC);				//tray 2 //fprint
		  //fprintf(fp,"%c&l6E",ESC); 			//To set the top margin
		  fprintf(fp,"%c(s12.5H",ESC); 			// To set the font //fprint
		  fprintf(fp,"%c&a4L",ESC); 			// To set the left margin//fprintf

	      fn_print_header();

	      fn_print_body();

		  page_no=0;

		//fprintf(fp,"%c(s12.5H",ESC); 			// To set the font 
        //fprintf(fp,"%c&a2L",ESC); 			// To set the left margin

	 }
 }


/**********------------COUNTRY DETAILS---------**********/

get_country_det()
 {

  d_country.arr[0]		= '\0';
  d_country.len			= 0;

	 /* EXEC SQL Select SHORT_NAME into :d_country 
	 From  MP_COUNTRY_LANG_VW
		  Where COUNTRY_CODE=:d_country_code
		  AND LANGUAGE_ID   =:p_language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 41;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SHORT_NAME into :b0  from MP_COUNTRY_LANG_VW where \
(COUNTRY_CODE=:b1 and LANGUAGE_ID=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )444;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_country;
  sqlstm.sqhstl[0] = (unsigned int  )52;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_country_code;
  sqlstm.sqhstl[1] = (unsigned int  )12;
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




  d_country.arr[d_country.len]		='\0'; 

 }

/**********-------CUSTOMER/PATNAME FOR FIRST COLUMN------**********/

get_cust_pat()
{

  if(strcmp(d_group_code.arr,"\0")!=0)
  {
   d_cust_pat.arr[0]  = '\0';
   d_cust_pat.len     = 0;
   d_comp_name.arr[0]  = '\0';
   d_comp_name.len      =0;

    /* EXEC SQL  Select CONTACT_NAME,CONTACT_NAME_TITLE into :d_cust_pat,:d_cust_pat_title
	From 	 BL_COVERING_LET_GROUP           //table
	  Where OPERATING_FACILITY_ID=:lv_facility_id
      and nvl(CUST_CODE,'XXXXXXXX')=nvl(:d_cust_code,'XXXXXXXX')
	  and GROUP_CODE=:d_group_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 41;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select CONTACT_NAME ,CONTACT_NAME_TITLE into :b0,:b1  fr\
om BL_COVERING_LET_GROUP where ((OPERATING_FACILITY_ID=:b2 and nvl(CUST_CODE,\
'XXXXXXXX')=nvl(:b3,'XXXXXXXX')) and GROUP_CODE=:b4)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )471;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_pat;
    sqlstm.sqhstl[0] = (unsigned int  )47;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_cust_pat_title;
    sqlstm.sqhstl[1] = (unsigned int  )52;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&lv_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
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
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	/* EXEC SQL SELECT GROUP_DESC INTO :d_comp_name
	FROM BL_COVERING_LET_GROUP_LANG_VW      //table
	WHERE OPERATING_FACILITY_ID=:lv_facility_id
	AND   nvl(CUST_CODE,'XXXXXXXX')=nvl(:d_cust_code,'XXXXXXXX')
	AND   GROUP_CODE=:d_group_code
	AND   LANGUAGE_ID=:p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select GROUP_DESC into :b0  from BL_COVERING_LET_GROUP_LANG\
_VW where (((OPERATING_FACILITY_ID=:b1 and nvl(CUST_CODE,'XXXXXXXX')=nvl(:b2,\
'XXXXXXXX')) and GROUP_CODE=:b3) and LANGUAGE_ID=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )506;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_comp_name;
 sqlstm.sqhstl[0] = (unsigned int  )302;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lv_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_group_code;
 sqlstm.sqhstl[3] = (unsigned int  )9;
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



   
if (NODATAFOUND)                       /***added on 15/2/2006 as per the suggestion frm Gshankar**/
    {
     /* EXEC SQL  Select CONTACT_NAME,CONTACT_NAME_TITLE into :d_cust_pat,:d_cust_pat_title
	  From  BL_COVERING_LET_GROUP             //table
	     Where OPERATING_FACILITY_ID=:lv_facility_id
          and nvl(CUST_CODE,'XXXXXXXX')=nvl(:d_cust_code,'XXXXXXXX')
	      and GROUP_CODE='*ALL'; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 41;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select CONTACT_NAME ,CONTACT_NAME_TITLE into :b0,:b1  f\
rom BL_COVERING_LET_GROUP where ((OPERATING_FACILITY_ID=:b2 and nvl(CUST_CODE\
,'XXXXXXXX')=nvl(:b3,'XXXXXXXX')) and GROUP_CODE='*ALL')";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )541;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_cust_pat;
     sqlstm.sqhstl[0] = (unsigned int  )47;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_cust_pat_title;
     sqlstm.sqhstl[1] = (unsigned int  )52;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&lv_facility_id;
     sqlstm.sqhstl[2] = (unsigned int  )5;
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
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		 
	 /* EXEC SQL SELECT GROUP_DESC INTO :d_comp_name
	 FROM BL_COVERING_LET_GROUP_LANG_VW          //table
	 WHERE OPERATING_FACILITY_ID=:lv_facility_id
          and nvl(CUST_CODE,'XXXXXXXX')=nvl(:d_cust_code,'XXXXXXXX')
	      and GROUP_CODE='*ALL'
		  AND LANGUAGE_ID=:p_language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 41;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select GROUP_DESC into :b0  from BL_COVERING_LET_GROUP_LAN\
G_VW where (((OPERATING_FACILITY_ID=:b1 and nvl(CUST_CODE,'XXXXXXXX')=nvl(:b2\
,'XXXXXXXX')) and GROUP_CODE='*ALL') and LANGUAGE_ID=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )572;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_comp_name;
  sqlstm.sqhstl[0] = (unsigned int  )302;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lv_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
  sqlstm.sqhstl[2] = (unsigned int  )11;
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


		  } 
		  
       if (NODATAFOUND)
	     {
	     if(strcmp(d_cust_code.arr,"\0")!=0)
		   {
	      	  /* EXEC SQL  Select CONTACT_NAME,CONTACT_NAME_TITLE,NVL(DETAIL_DESC,LONG_NAME) --Instead of LONG_NAME using DETAIL_DESC for IN13922 done by raghava
			  INTO :d_cust_pat,:d_cust_pat_title,:d_comp_name
			  From  AR_CUSTOMER_LANG_VW
			  Where   CUST_CODE=:d_cust_code
			  AND     LANGUAGE_ID=:p_language_id; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 41;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.stmt = "select CONTACT_NAME ,CONTACT_NAME_TITLE ,NVL(DETAI\
L_DESC,LONG_NAME) into :b0,:b1,:b2  from AR_CUSTOMER_LANG_VW where (CUST_CODE\
=:b3 and LANGUAGE_ID=:b4)";
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )603;
          sqlstm.selerr = (unsigned short)1;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlstm.sqhstv[0] = (         void  *)&d_cust_pat;
          sqlstm.sqhstl[0] = (unsigned int  )47;
          sqlstm.sqhsts[0] = (         int  )0;
          sqlstm.sqindv[0] = (         void  *)0;
          sqlstm.sqinds[0] = (         int  )0;
          sqlstm.sqharm[0] = (unsigned int  )0;
          sqlstm.sqadto[0] = (unsigned short )0;
          sqlstm.sqtdso[0] = (unsigned short )0;
          sqlstm.sqhstv[1] = (         void  *)&d_cust_pat_title;
          sqlstm.sqhstl[1] = (unsigned int  )52;
          sqlstm.sqhsts[1] = (         int  )0;
          sqlstm.sqindv[1] = (         void  *)0;
          sqlstm.sqinds[1] = (         int  )0;
          sqlstm.sqharm[1] = (unsigned int  )0;
          sqlstm.sqadto[1] = (unsigned short )0;
          sqlstm.sqtdso[1] = (unsigned short )0;
          sqlstm.sqhstv[2] = (         void  *)&d_comp_name;
          sqlstm.sqhstl[2] = (unsigned int  )302;
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


			 }
          }

                                /***up to here**/

     d_cust_pat.arr[d_cust_pat.len]='\0';
	 d_comp_name.arr[d_comp_name.len] = '\0';

    



   }
   else if(strcmp(d_group_code.arr,"\0")==0 && strcmp(d_cust_code.arr,"\0")!=0)
    {

		d_cust_pat.arr[0]  = '\0';
		d_cust_pat.len     = 0;

   
		/* EXEC SQL  Select CONTACT_NAME,CONTACT_NAME_TITLE 
				  into :d_cust_pat,:d_cust_pat_title 
			      From  AR_CUSTOMER_LANG_VW
				  Where  Cust_Code=:d_cust_code
				  And Language_id=:p_language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 41;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select CONTACT_NAME ,CONTACT_NAME_TITLE into :b0,:b1  from\
 AR_CUSTOMER_LANG_VW where (Cust_Code=:b2 and Language_id=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )638;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_cust_pat;
  sqlstm.sqhstl[0] = (unsigned int  )47;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_cust_pat_title;
  sqlstm.sqhstl[1] = (unsigned int  )52;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_cust_code;
  sqlstm.sqhstl[2] = (unsigned int  )11;
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



		d_cust_pat.arr[d_cust_pat.len]='\0';

        d_comp_name.arr[0]  = '\0';
	    d_comp_name.len  =0;
                         
						 /***added on 15/2/2006 as per the suggestion frm Gshankar**/

     /* EXEC SQL  Select GROUP_DESC into :d_comp_name From 
	  BL_COVERING_LET_GROUP_LANG_VW      //table
	  Where OPERATING_FACILITY_ID=:lv_facility_id
      and CUST_CODE=:d_cust_code
	  and GROUP_CODE='*ALL'
	  AND LANGUAGE_ID=:p_language_id;

    if (NODATAFOUND)
	 {*/
       	/* EXEC SQL  Select NVL(DETAIL_DESC,LONG_NAME) --LONG_NAME 
		          Into :d_comp_name 
				   From  AR_CUSTOMER_LANG_VW
			      Where Cust_Code=:d_cust_code
			      And Language_Id=:p_language_id; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 41;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select NVL(DETAIL_DESC,LONG_NAME) into :b0  from AR_\
CUSTOMER_LANG_VW where (Cust_Code=:b1 and Language_Id=:b2)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )669;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&d_comp_name;
        sqlstm.sqhstl[0] = (unsigned int  )302;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&d_cust_code;
        sqlstm.sqhstl[1] = (unsigned int  )11;
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


			// }

	d_comp_name.arr[d_comp_name.len]  ='\0';

	                   /***up to here**/

	}

  else if(strcmp(d_group_code.arr,"\0")==0 && strcmp(d_cust_code.arr,"\0")==0)

   {
   	d_cust_pat.arr[0]  = '\0';
	d_cust_pat.len     = 0;

    strcpy(d_cust_pat.arr,d_contact_name.arr);

	strcpy(d_cust_pat_title.arr,d_contact_name_title.arr);


  	//d_cust_pat.arr[d_cust_pat.len]='\0';
     
    }

  }


/*********----------HEADER-----------------************/

fn_print_header()
{
  
  int l_page_width=0,s1,s2,sc=0,l_report_width,l_acc_entity_length;
  lctr=0;
  l_report_width=98; 

	 fprintf(fp,"%c(s10H",ESC); 		// To set the font 
	 fprintf(fp,"%c(s3B",ESC); 

  
	 if(strcmp(p_print_opt.arr,"Y") !=0) //pradeep !=0
	  {
	  
         l_acc_entity_length = strlen(hosp_name.arr);
		 
		 
	  	 s1 = (l_report_width-l_acc_entity_length)/2;
	     horz_skip(s1-16);
	     fprintf(fp,"%s \n",hosp_name.arr);
	     fprintf(fp,"%c(s12.5H",ESC); 		// To set the font 
	     fprintf(fp,"%c(s-3B",ESC); //fprintf
		 
	     s2 = (l_report_width-l_acc_entity_length);
         horz_skip(s2-s1-20);

    
	  if(strcmp(p_print_ind.arr,"C")==0)
      { 

	   	fprintf(fp,"%c(s8H",ESC); 		
		fprintf(fp,"%c(s3B",ESC); 	
		
		if(d_print_count!=0) 
		//fprintf(fp,"%s","COPY");
		fprintf(fp,"%s",loc_legend[001]);
		
		fprintf(fp,"%c(s12.5H",ESC); 	
		fprintf(fp,"%c(s-3B",ESC); //fprintf
	  }
    if(strcmp(p_print_ind.arr,"N")==0)
      {

	  	fprintf(fp,"%c(s8H",ESC); 		
		fprintf(fp,"%c(s3B",ESC);
		
	   if(d_print_count!=0) 
	      //fprintf(fp,"%s","COPY");
		  fprintf(fp,"%s",loc_legend[001]);
		  
		
	     fprintf(fp,"%c(s12.5H",ESC); 	
		 fprintf(fp,"%c(s-3B",ESC);//fprintf
		

      }


   }

  else
   {
   sc = (l_report_width-30)/2;
	  horz_skip(sc);
   if(strcmp(p_print_ind.arr,"C")==0)
      { 

	   	fprintf(fp,"%c(s8H",ESC); 		
		fprintf(fp,"%c(s3B",ESC); 	
       
		if(d_print_count!=0) 
		      fprintf(fp,"%s","COPY");

		  fprintf(fp,"%c(s12.5H",ESC); 	
		  fprintf(fp,"%c(s-3B",ESC); 
	  }

  if(strcmp(p_print_ind.arr,"N")==0)
    {
		  
			fprintf(fp,"%c(s8H",ESC); 		
		    fprintf(fp,"%c(s3B",ESC); 
				

	 if(d_print_count!=0)
	  fprintf(fp,"%s","COPY");
							

		fprintf(fp,"%c(s12.5H",ESC); 	
		fprintf(fp,"%c(s-3B",ESC); 
		
	    
   }	  
	
 } 
	   lctr=1;
	   next_line_f(1);
	   next_line_f(1);
       fprintf(fp,"%c(s3B",ESC); //bold
	   fprintf(fp,"%c(s12.5H",ESC); 	
		        fprintf(fp,"%51s"," ");
	   fprintf(fp," %-10.10s : %-31s",loc_legend[3],d_doc_ref_num.arr);

		
       next_line_f(1);
       fprintf(fp,"%52s"," ");
		

	 get_initialize();
	 strcpy(nd_temp_date.arr,d_doc_ref_date.arr);
	 if(d_doc_ref_date.arr[0]!='\0')
	 {
		get_local_date_convn1();

		strcpy(d_doc_ref_date.arr,nd_loc_date.arr); 

		//d_doc_ref_date.arr[d_doc_ref_date.len] = '\0';
	 }

     fprintf(fp,"%-10.10s : %-31s\n",loc_legend[4],d_doc_ref_date.arr);	
		
		
	 fprintf(fp,"%c(s-3B",ESC);//release bold // MODIFIED 08/12/2005 
     next_line_f(1);
     next_line_f(1);


 fprintf(fp,"%-41s",d_contact_name.arr);

  next_line_f(1);

  if(strcmp(d_contact_name_title.arr,"\0")!=0)
  {
	fprintf(fp,"%s",d_contact_name_title.arr);
	
	next_line_f(1);
  }

  if(strcmp(d_comp_name.arr,"\0")!=0)  
  {
	//fprintf(fp,"%-41s",d_comp_name.arr); commented by raghava on 28/10/2009 for IN13922
    //Below Code Added by Raghava on 28/10/2009 for IN13922
	len_desc = strlen(d_comp_name.arr);
	while(r_ctrdesc < len_desc)
	{	
		split_text(d_comp_name.arr,100,cl_string_desc,&r_ctrdesc);
		fprintf(fp,"%-100.100s",cl_string_desc);
		strcpy(cl_string_desc,"");  
		next_line(1); 
	} 
	r_ctrdesc=0;
	//for IN13922
   	//next_line_f(1); 
  }	
		                
       if(strcmp(d_mail_addr1.arr,"\0")!=0)  
	    {
		fprintf(fp,"%-41s",d_mail_addr1.arr);
  next_line_f(1);
        } 
		if(strcmp(d_mail_addr2.arr,"\0")!=0)  
		 { 
		fprintf(fp,"%-41s",d_mail_addr2.arr);	
  next_line_f(1);
         }
		 if(strcmp(d_mail_addr3.arr,"\0")!=0)  
		 {
		fprintf(fp,"%-41s",d_mail_addr3.arr);	
  next_line_f(1);
         }
		if(strcmp(d_mail_addr4.arr,"\0")!=0)  
		 {
		fprintf(fp,"%-41s",d_mail_addr4.arr);	
  next_line_f(1);
         }

		if(strcmp(d_postal_code.arr,"\0")!=0)  
		 {
		fprintf(fp,"%-s %-21s",loc_legend[19],d_postal_code.arr);	
  next_line_f(1);
         }
      if(strcmp(d_post_box.arr,"\0")!=0) 
	    { 
		fprintf(fp,"%-s %-21s",loc_legend[20],d_post_box.arr);	
  next_line_f(1);
         }

	if(strcmp(d_tel_num.arr,"\0")!=0)  
		 {
		fprintf(fp,"%-s %-31s",loc_legend[21],d_tel_num.arr);	
  next_line_f(1);
         }
      if(strcmp(d_fax_num.arr,"\0")!=0) 
	    { 
		fprintf(fp,"%-s %-31s",loc_legend[22],d_fax_num.arr);	
  next_line_f(1);
         }

	  if(strcmp(d_country.arr,"\0")!=0) 
	    { 
		fprintf(fp,"%-41s",d_country.arr);
  next_line_f(1);
        }
  next_line_f(1);

      check_splch(d_let_bd_hd_ln01.arr);
	 //fprintf(fp,"%c(s-3B",ESC);//release bold	
	 //fprintf(fp,"%-90s", d_let_bd_hd_ln01.arr);	
       next_line_f(1);
     //next_line_f(1);

 /*
  if(strcmp(d_contact_name.arr,"\0")!=0 || strcmp(d_contact_name_title.arr,"\0")!=0)
		fprintf(fp,"%-41s", d_contact_name.arr,d_contact_name_title.arr);
  */

  //next_line_f(1);
  //next_line_f(1);

/*
     if(strcmp(d_let_bd_hd_ln02.arr,"\0")!=0) 
	    { 

		 if(strcmp(d_cust_pat.arr,"\0")!=0 || strcmp(d_cust_pat_title.arr,"\0")!=0)
		 {


         strcpy(p_org_str.arr,d_let_bd_hd_ln02.arr);

        p_org_str.len=strlen(p_org_str.arr);

        strcpy(p_search_string.arr,"\n");
	//	p_search_string.len=strlen(p_search_string.arr);
    
	//p_search_string.len=strlen(p_search_string.arr);
       
	      strcpy(d_cust_pat.arr,strcat(d_cust_pat.arr," "));

       p_add_str.arr[0]  ='\0';

        strcpy(p_add_str.arr,strcat(d_cust_pat.arr,d_cust_pat_title.arr));
       
	
	    p_add_str.len =strlen(p_add_str.arr);

		insert_string();
	
		 check_splch(p_ret_str.arr);

            d_cust_pat.arr[0]  = '\0';
			d_cust_pat.len     = 0;
			d_comp_name.arr[0]  = '\0';
			d_comp_name.len      =0;
			p_ret_str.arr[0]  = '\0';
			d_contact_name_title.arr[0]  ='\0';
			p_add_str.arr[0]    =  '\0';


			//strcpy(nd_let_bd_hd_ln02_final.arr,d_let_bd_hd_ln02.arr);
			//strcat(nd_let_bd_hd_ln02_final.arr,strcat(d_contact_name.arr,d_contact_name_title.arr));
		//	check_splch(nd_let_bd_hd_ln02_final.arr);
			next_line_f(1);

      	 }
		 
		}
          
*/
    
if(strcmp(d_let_bd_hd_ln02.arr,"\0")!=0) 
	    {
		check_splch(d_let_bd_hd_ln02.arr);
         next_line_f(1);
		 }

       if(strcmp(d_let_body_header_ln03.arr,"\0")!=0) 
	    {
		check_splch(d_let_body_header_ln03.arr);
		//fprintf(fp,"%-90s", d_let_body_header_ln03.arr);
   next_line_f(1);
         }
       if(strcmp(d_let_body_header_ln04.arr,"\0")!=0) 
	    {
		check_splch(d_let_body_header_ln04.arr);
		//fprintf(fp,"%-90s", d_let_body_header_ln04.arr);	
  next_line_f(1);
         }
	   if(strcmp(d_let_bd_hd_ln05.arr,"\0")!=0) 
	    {
		check_splch(d_let_bd_hd_ln05.arr);
		//fprintf(fp,"%-90s", d_let_bd_hd_ln05.arr);	
  next_line_f(1);
         }
 
  fprintf(fp,"%s ",d_base_currency.arr);
  print_formated_hdr(d_tot_outst_amt);
  print_hdr_amt_in_words();
  next_line_f(1);


 }

 fn_print_annax_header()
 {
   int l1,l2,l_report_width,l_head_length;

   l_report_width=162;
   lctr=0;
   l_head_length = strlen(loc_legend[15]);

	 l1 = (l_report_width-l_head_length)/2;
	  horz_skip(l1);

	  fprintf(fp,"%c(s10H",ESC); 		// To set the font 
	  fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style */


	  fprintf(fp,"%s",loc_legend[15]);
	  fprintf(fp,"%c(s12.5H",ESC); 		// To set the font 

	  //l2 = (l_report_width-l_head_length);
	  //horz_skip(l2-l1-20);
	 // fprintf(fp,"%-10.10s : %d\n",loc_legend[14],++page_no);

	 next_line(1);

	      

	 //l2 = (l_report_width-l_head_length);
	 //horz_skip(l2-l1-30);

    fprintf(fp,"%88s"," ");
	    fprintf(fp,"     %-10.10s : %-31s",loc_legend[3],d_doc_ref_num.arr);
    next_line(1);
	fprintf(fp,"%88s"," ");
		fprintf(fp,"     %-10.10s : %-31s",loc_legend[4],d_doc_ref_date.arr);	
        next_line(1);
		fprintf(fp,"%c(s-3B",ESC); 	/* To set Bold style */
		fprintf(fp,"%c(s15H",ESC); 		// To set the font //fprintf


 }


/************-----------------BODY-------------------********/
fn_print_body()
{
	  	 // tot_rows=0;
		  bill_cnt1=0;
		  bill_cnt2=0;
   
		/* EXEC SQL  Select count(rowid) into bill_cnt1  From BL_CUST_DISPATCH_LET_DETAIL
		 Where OPERATING_FACILITY_ID=:lv_facility_id
		 And DOC_REF_NUM=:d_doc_ref_num
		 and (:d_print_text_yn ='N' OR (:d_print_text_yn='Y' AND  print_text is NULL)); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 41;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(rowid) into :b0  from BL_CUST_DISPATCH_LET_DE\
TAIL where ((OPERATING_FACILITY_ID=:b1 and DOC_REF_NUM=:b2) and (:b3='N' or (\
:b3='Y' and print_text is null )))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )696;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bill_cnt1;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lv_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_doc_ref_num;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_print_text_yn;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_print_text_yn;
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


		
		//AND (:p_policy ='N' or (:p_policy='Y' and  POLICY_NUMBER is null)
		 // OR (:p_policy ='Z'  and :d_print_ins_yn= 'N')
		//	  OR (:p_policy ='Z'  and :d_print_ins_yn= 'Y' and POLICY_NUMBER is null) 
		//	  );
  
		/* EXEC SQL  Select count(rowid)*2 into bill_cnt2  From BL_CUST_DISPATCH_LET_DETAIL
		 Where OPERATING_FACILITY_ID=:lv_facility_id
		 And DOC_REF_NUM=:d_doc_ref_num
		 and ( (:d_print_text_yn='Y' AND  print_text is not NULL)
		 //	   or( :p_policy='Y' and   POLICY_NUMBER is not null)
		 //	   OR (:p_policy ='Z'  and :d_print_ins_yn= 'Y' and POLICY_NUMBER is not null)
		) ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 41;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select (count(rowid)* 2) into :b0  from BL_CUST_DISPATCH_L\
ET_DETAIL where ((OPERATING_FACILITY_ID=:b1 and DOC_REF_NUM=:b2) and (:b3='Y'\
 and print_text is  not null ))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )731;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&bill_cnt2;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lv_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_doc_ref_num;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_print_text_yn;
  sqlstm.sqhstl[3] = (unsigned int  )4;
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



		tot_rows = bill_cnt1+bill_cnt2;

		open_bill_cur();

		get_bill_details();

		count_remarks();

		get_remarks();
		      
   
  if(tot_rows > no_of_docs_in_cl) 
  {
		/*fprintf(fp,"%c(s15H",ESC); 	// To set the font 
		fprintf(fp,"%c&a3L",ESC); 		// To set the left margin

		fn_print_leg_hdr();

		vert_skip(2);

		horz_skip(102);
		print_line('_',15);*/

		if(strcmp(d_foreign_currency_yn.arr,"Y")==0) 
		{
			//next_line(1);

			len = strlen(d_foreign_currency_note.arr);
				while(r_ctr < len)
				{	
					split_text(d_foreign_currency_note.arr,75,cl_string,&r_ctr);
					fprintf(fp,"%-75.75s",cl_string);
					strcpy(cl_string,"");  
					next_line(1);
				}
		}

		vert_skip(1);

		fprintf(fp,"%-94s",loc_legend[18]);
		
		/*horz_skip(7);
   
		print_formated(d_tot_outst_amt);

		next_line_f(1);
		horz_skip(102);
		print_line('_',15);

		fprintf(fp,"%c(s12.5H",ESC); 		// To set the font 
		fprintf(fp,"%c&a4L",ESC); 		// To set the left margin//fprintf

		print_amt_in_words();
		//	next_line_f(1);

		// fprintf(fp,"%-s",loc_legend[10]);

		vert_skip(2);
		print_line('_',96);*/

		next_line_f(1);

		//fprintf(fp,"%c(s12.5H",ESC); 		// To set the font 
		//fprintf(fp,"%c&a2L",ESC); 		// To set the left margin

		fn_print_footer();

		/* if(lctr<=56)
		{
			vert_skip(58-(lctr+2));
			print_line('_',115);
			fprintf(fp,"%-s : %s %-s : %s ",loc_legend[24],d_user.arr,loc_legend[4],d_date_time.arr); 
		}
		*/

		fprintf(fp,"%cE",ESC);		// To reset the printer
		fprintf(fp,"%c&l1O",ESC); 		// To print in land scape mode
		fprintf(fp,"%c&l26A",ESC); //A4Size

		//fprintf(fp,"%c&l4H",ESC); //1 tray

		fprintf(fp,"%c(s15H",ESC); 		// To set the font 
		fprintf(fp,"%c&a4L",ESC); 		// To set the left margin

		lctr=0;
		//next_page();
		next_line(1);

		//data in a4 page------

		fn_print_annax_header();

		next_line(1);
		next_line(1);

		//fn_print_leg_hdr();
		get_pat_id_length();
		fn_print_leg_hdr_anx();

		print_data_anx();

		//print_line('_',101);

		nd_tot_outst_amt=0;

		if(cnt_rem>0)
		{	    
			fprintf(fp,"%cE",ESC);		// To reset the printer
			fprintf(fp,"%c&l0O",ESC); 		// To print in portait mode
			fprintf(fp,"%c&l26A",ESC); //A4Size
			fprintf(fp,"%c(s12.5H",ESC); 		// To set the font 
			fprintf(fp,"%c&a4L",ESC); 		// To set the left margin
			print_remarks();   
		}
	}
   else 
	{
		fprintf(fp,"%c(s15H",ESC); 		// To set the font 
		fprintf(fp,"%c&a3L",ESC); 		// To set the left margin //fprintf

		fn_print_leg_hdr();

		print_data();

		if(lctr+23<58)
		 vert_skip(58-(lctr+23));

		horz_skip(1);
		print_line('_',115);

		fprintf(fp,"%c(s12.5H",ESC); 		// To set the font 
		fprintf(fp,"%c&a4L",ESC); 			// To set the left margin
		fn_print_footer();

		nd_tot_outst_amt=0;

		if(cnt_rem>0)
		  {	
			 fprintf(fp,"%cE",ESC);			// To reset the printer
			 fprintf(fp,"%c&l0O",ESC); 		// To print in portait mode
			 fprintf(fp,"%c&l26A",ESC);		// A4Size
			 fprintf(fp,"%c(s12.5H",ESC); 	// To set the font 
			 fprintf(fp,"%c&a4L",ESC); 		// To set the left margin
					 
			 print_remarks();
		  }
    }

	bill_cnt1=0;
	bill_cnt2=0;
	tot_rows=0;  
}

print_data()
{
   sl_no=0;
	   while(fetch_bill_cur())
		 {
		   sl_no=sl_no+1;
             //fn_get_pat_name();

			 /****MODIFIED ON 30/11/2005 AS PER REQUIRMENT (Always Print Patient No&Name)****/
        
	        /*
			 if(strcmp(nd_patient_id.arr,d_patient_id.arr)==0)
	           {
                fprintf(fp,"%-30s %-20s %-15s %-10s"," "," ",d_doc_number.arr,d_doc_date.arr );
	           }
	         else
	           {
                fprintf(fp,"%-30s %-20s %-15s %-10s",nd_patient.arr,d_patient_id.arr,d_doc_number.arr,d_doc_date.arr );
	           }

              */
get_initialize();

strcpy(nd_temp_date.arr,d_doc_date.arr);

get_local_date_convn2();

strcpy(d_doc_date.arr,nd_loc_date.arr); 
d_doc_date.arr[d_doc_date.len] = '\0';


			   //fprintf(fp,"%-4d     %-26s %-14s %-15s %-10s ",sl_no,nd_patient.arr,d_patient_id.arr,d_doc_number.arr,d_doc_date.arr );
			     fprintf(fp,"%-4d      %-20s %-20s ",sl_no,d_doc_number.arr,d_doc_date.arr );
 
			   //fprintf(fp," %-4d %-30s %-20s %-15s %-10s",sl_no,nd_patient.arr,d_patient_id.arr,d_doc_number.arr,d_doc_date.arr );



       /*****up to here ****/
	          //print_formated(d_bill_amt);
			  //hh--print_formated(d_doc_amt);
			  fprintf(fp,"                    ");
	          //hh--print_formated(d_outst_amt);
               print_formated(d_doc_amt);

            if( strcmp(p_policy.arr,"Y")==0)
			  {
  
				if(strcmp(d_policy_code.arr,"\0") !=0 || strcmp(d_policy_num.arr,"\0") !=0 )
				 {
			   next_line(1);
		  
					fprintf(fp,"%-53s ",d_policy_type.arr);
					//fprintf(fp," %-55s ",d_policy_type.arr);

					if(strcmp(d_print_text_yn.arr,"Y")==0)    //  CHANGED 24/01/06
					fprintf(fp,"%-s",d_print_text.arr);
				 }
				else
				 {
					if( strcmp(d_print_text.arr,"\0")!=0)
					  {
						next_line(1);
						horz_skip(53);
						fprintf(fp,"%-s",d_print_text.arr);
					  }
				 }
			  }

			else
			 {
				if(strcmp(d_print_text.arr,"\0")!=0)
				{
					next_line(1);
					horz_skip(57);
					fprintf(fp,"%-s",d_print_text.arr);
				}
		     }

			//hh--nd_tot_outst_amt=nd_tot_outst_amt+d_outst_amt;
		    nd_tot_outst_amt=nd_tot_outst_amt+d_doc_amt;

			strcpy(nd_patient_id.arr,d_patient_id.arr);

			next_line(1);
			if(lctr==55)
			{ 
			print_line('_',113);
			print_page_num();
			next_line(1);
			}

	    }


		horz_skip(72); //98
		print_line('_',15);
 
		fprintf(fp,"%60s %-11.11s"," ",loc_legend[9]);
		print_formated(nd_tot_outst_amt);
		next_line(1);
		horz_skip(72);//98
		print_line('_',15);

		next_line(1);

		print_amt_in_words();

		if(lctr<54 && tot_rows> no_of_docs_in_cl)
		{ 
			vert_skip(57-(lctr+3));
			horz_skip(1);
			print_line('_',113);
			print_page_num();
			next_line(1);
		}

        close_bill_cur();
      
     }
  




  ////////////
  
print_data_anx()
   {
       //get_pat_id_length();
	   sl_no=0;
	   while(fetch_bill_cur())
		 {
		 sl_no=sl_no+1;
             //fn_get_pat_name();

			 /****Modified on 30/11/2005 as per requirment(Always print patient name&No.)***/

			 /*
        
	         if(strcmp(nd_patient_id.arr,d_patient_id.arr)==0)
	           {

			    if(d_pat_id_len <=10)
                 fprintf(fp,"%-3d %-30s %-10s %-15s %-10s"," "," ",sl_no,d_doc_number.arr,d_doc_date.arr );
				else
                fprintf(fp,"%-3d %-30s %-20s %-15s %-10s"," "," ",sl_no,d_doc_number.arr,d_doc_date.arr );
	           }
	         else
	           {
			   if(d_pat_id_len <=10)
			      fprintf(fp,"%-4d %-30s %-10s %-15s %-10s",sl_no,nd_patient.arr,d_patient_id.arr,d_doc_number.arr,d_doc_date.arr );
			   else
			      fprintf(fp,"%-4d %-30s %-20s %-15s %-10s",sl_no,nd_patient.arr,d_patient_id.arr,d_doc_number.arr,d_doc_date.arr );
	           }

                */

				/*****Up to Here *******/
get_initialize();
strcpy(nd_temp_date.arr,d_doc_date.arr);

get_local_date_convn2();

strcpy(d_doc_date.arr,nd_loc_date.arr); 
d_doc_date.arr[d_doc_date.len] = '\0';


                 if(d_pat_id_len <=10)
				  
			      //fprintf(fp,"%-4d     %-26s %-14s %-15s %-10s ",sl_no,nd_patient.arr,d_patient_id.arr,d_doc_number.arr,d_doc_date.arr );
				    fprintf(fp,"%-4d      %-20s %-20s ",sl_no,d_doc_number.arr,d_doc_date.arr );

				  //fprintf(fp,"%-4d %-30s %-10s %-15s %-10s",sl_no,nd_patient.arr,d_patient_id.arr,d_doc_number.arr,d_doc_date.arr );
			   else
			      //fprintf(fp,"%-4d     %-26s %-14s %-15s %-10s ",sl_no,nd_patient.arr,d_patient_id.arr,d_doc_number.arr,d_doc_date.arr );
				    fprintf(fp,"%-4d      %-20s %-20s ",sl_no,d_doc_number.arr,d_doc_date.arr );

				  //fprintf(fp,"%-4d %-30s %-20s %-15s %-10s",sl_no,nd_patient.arr,d_patient_id.arr,d_doc_number.arr,d_doc_date.arr );
	           
	          //print_formated(d_bill_amt);
			  //hh--print_formated(d_doc_amt);
			  fprintf(fp,"                    ");
	          //hh--print_formated(d_outst_amt);
              print_formated(d_doc_amt);

          /* //--  if( strcmp(p_policy.arr,"Y")==0)
			  {
  
				if(strcmp(d_policy_code.arr,"\0") !=0 || strcmp(d_policy_num.arr,"\0") !=0 )
				 {
			   //next_line(1);
		  
					fprintf(fp,"%-53s ",d_policy_type.arr);
					//fprintf(fp," %-55s ",d_policy_type.arr);
         
					if(strcmp(d_print_text_yn.arr,"Y")!=0)
					 {
					  if(d_pat_id_len <=10)
					  fprintf(fp,"%-27s",d_print_text.arr);
					  else
					fprintf(fp,"%-17s",d_print_text.arr);
					 }
				 }
				else
				 {
					if( strcmp(d_print_text.arr,"\0")!=0)
					  {
					//	next_line(1);
						horz_skip(52);
                        if(d_pat_id_len <=10)
						fprintf(fp," %-27s",d_print_text.arr);
						else
						fprintf(fp," %-17s",d_print_text.arr);
					  }
				 }
			  }

			else
			 {
				if(strcmp(d_print_text.arr,"\0")!=0)
				{
				//	next_line(1);
				//	horz_skip(51);
					fprintf(fp," %-61s",d_print_text.arr);
				}
		     } */

			//hh--nd_tot_outst_amt=nd_tot_outst_amt+d_outst_amt;
		    nd_tot_outst_amt=nd_tot_outst_amt+d_doc_amt;

			strcpy(nd_patient_id.arr,d_patient_id.arr);

			next_line(1);
			if(lctr==39)
			{ 
			print_line('_',184);
			print_page_num();
			//next_line(1);
			next_page();
			}

	    }


       if(d_pat_id_len <=10)
	    { 
		 //horz_skip(98);
		 horz_skip(73);  
	   print_line('_',15);

                  
		 //fprintf(fp,"%82s %15s"," ",loc_legend[9]);
		  fprintf(fp,"%60s %-11.11s"," ",loc_legend[9]);

         print_formated(nd_tot_outst_amt);
      next_line(1);
         //horz_skip(98);
		 horz_skip(73);
	  print_line('_',15);
	   }
	   else
	    { 
       	 //horz_skip(103);
		  horz_skip(73);

	   print_line('_',15);

          
         //fprintf(fp,"%88s %15s"," ",loc_legend[9]);
		   fprintf(fp,"%-60s %-11.11s"," ",loc_legend[9]);

         print_formated(nd_tot_outst_amt);
      next_line(1);
         //horz_skip(103);
		 horz_skip(73);
	  print_line('_',15);
		}

 
	  next_line(1);

       // print_amt_in_words_anx();

			if(lctr<37 && tot_rows > no_of_docs_in_cl) 
			{ 
				print_amt_in_words_anx();
				vert_skip(41-(lctr+3));
				print_line('_',184);
				print_page_num();
				next_line(1);
			}
			else
			{
				print_line('_',184);
				print_page_num();
				next_page();
           		print_amt_in_words_anx();
				vert_skip(41-(lctr+3));
				print_line('_',184);
				print_page_num();
			}
            


        close_bill_cur();
      
     }
	 ////////////////
print_page_num()
{
int p1,p2,l_report_width,l_length,l_start_point,l_comp_name_end_point,l_data_len;

   l_report_width=180;

  l_start_point=0;

	l_start_point=(l_report_width/2);


//fprintf(fp,"%-s : %s %-s : %s ",loc_legend[24],d_user.arr,loc_legend[4],d_date_time.arr); 

l_data_len = (strlen(loc_legend[24])+strlen(d_user.arr)+strlen(loc_legend[4])+strlen(d_date_time.arr)+8);

   l_length = strlen(loc_legend[14]);


	 p1 = (l_report_width-l_length-l_data_len);
	  horz_skip(p1-10);

 fprintf(fp,"%-10.10s : %d",loc_legend[14],++page_no);

  }
get_pat_id_length()
{
  d_pat_id_len =0;

  /* EXEC SQL Select PATIENT_ID_LENGTH into :d_pat_id_len from MP_PARAM; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 41;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select PATIENT_ID_LENGTH into :b0  from MP_PARAM ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )762;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_pat_id_len;
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


}

get_remarks()
 {
  

 /* EXEC SQL DECLARE REM_CUR CURSOR FOR
	 Select RMRK_SRNO,REMARKS_TEXT from BL_COVERING_LET_HEADER_RMRKS   //table
			  Where  OPERATING_FACILITY_ID = :lv_facility_id
			  and		DOC_REF_NUM = :d_doc_ref_num
			  and		action_type = 'P'; */ 




	if (OERROR)
        err_mesg("Select failed on table BL_COVERING_LET_HEADER_RMRKS",0,"");

 }


count_remarks()
 {
  
  cnt_rem=0;

 /* EXEC SQL Select count(1) into :cnt_rem from BL_COVERING_LET_HEADER_RMRKS   //table
			  Where  OPERATING_FACILITY_ID = :lv_facility_id
			  and		DOC_REF_NUM = :d_doc_ref_num
			  and		action_type = 'P'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select count(1) into :b0  from BL_COVERING_LET_HEADER_RMRKS\
 where ((OPERATING_FACILITY_ID=:b1 and DOC_REF_NUM=:b2) and action_type='P')";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )781;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&cnt_rem;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lv_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_doc_ref_num;
 sqlstm.sqhstl[2] = (unsigned int  )33;
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
        err_mesg("Select failed on table BL_COVERING_LET_HEADER_RMRKS",0,"");

 }

 open_rem_cur()
		{
			/* EXEC SQL OPEN REM_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 41;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0019;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )808;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&lv_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
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
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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
			err_mesg("OPEN failed on cursor REM_CUR",0,"");
		}

	 close_rem_cur()
		{
		/* EXEC SQL CLOSE REM_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 41;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )831;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		}




 fetch_remarks()
 {   
  d_remark_text.arr[0]  = '\0';
  d_remark_text.len     =0;
  d_rmrk_srno =0;


  	    /* EXEC SQL FETCH REM_CUR INTO
	        :d_rmrk_srno,
		    :d_remark_text; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 41;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )846;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&d_rmrk_srno;
       sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_remark_text;
       sqlstm.sqhstl[1] = (unsigned int  )203;
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


	
		d_remark_text.arr[d_remark_text.len] = '\0';

		if (OERROR)
            err_mesg("FETCH failed on cursor REM_CUR",0,"");

				return(LAST_ROW?0:1);

}




print_remarks()
 {
   
   int l1,l2,l_report_width,l_head_length;

   l_report_width=98;
   l_head_length = strlen(loc_legend[16]);

   lctr=0;

	 l1 = (l_report_width-l_head_length)/2;
	  horz_skip(l1-5);

	  fprintf(fp,"%c(s10H",ESC); 		// To set the font 
	  fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style */


	  fprintf(fp,"%-s",loc_legend[16]);
	  fprintf(fp,"%c(s12.5H",ESC); 		// To set the font 

	 next_line(1);
	 next_line(1);

      fprintf(fp,"%45s"," "); 
	    fprintf(fp," %-14.14s : %-31s",loc_legend[3],d_doc_ref_num.arr); 
    next_line(1);
	 fprintf(fp,"%45s"," "); 
		fprintf(fp,"%-14.14s : %-31s",loc_legend[4],d_doc_ref_date.arr);	
    next_line(1);
	next_line(1);
	print_line('_',113);
	next_line(1);
		fprintf(fp,"%c(s-3B",ESC); 	/* To release Bold style */


  open_rem_cur();

     while(fetch_remarks())
	  {

      fprintf(fp,"%3d ",d_rmrk_srno);
	  len = strlen(d_remark_text.arr);
          
			
				while(r_ctr_rem < len)
					{	
						split_text(d_remark_text.arr,71,cl_string_rem,&r_ctr_rem);
						fprintf(fp,"%-71.71s",cl_string_rem);
						strcpy(cl_string_rem,"");  
						next_line(1);
					} 

					r_ctr_rem=0;

			
       }




    close_rem_cur();
 
 }



get_bill_details()
{
           
		   /* EXEC SQL DECLARE BILL_CUR CURSOR FOR
				SELECT
				      --B.PATIENT_ID,
				      --DECODE(:p_language_id,'en',SUBSTR(M.SHORT_NAME,1,30),SUBSTR(M.SHORT_NAME_LOC_LANG,1,30)),
				      B.DOC_TYPE_CODE,
					  B.DOC_NUMBER,
					  B.DOC_TYPE_CODE||'/'||TO_CHAR(B.DOC_NUMBER),
					  to_char(B.DOC_DATE,'DD/MM/YYYY') ,
					  B.DOC_AMT,
					  --B.BILL_AMT,       
					  --B.DOC_OUTST_AMT,
                      --B.POLICY_TYPE_CODE||'/'||B.POLICY_NUMBER,
					  --B.POLICY_TYPE_CODE,
					  --B.POLICY_NUMBER,
					  substr(B.PRINT_TEXT,1,45)						        
			    From    BL_CUST_DISPATCH_LET_DETAIL B //--,MP_PATIENT_MAST M
			    Where   B.OPERATING_FACILITY_ID=:lv_facility_id
				--and     B.PATIENT_ID=M.PATIENT_ID
				And	   DOC_REF_NUM=:d_doc_ref_num
				AND    NVL(CANCELLED_YN,'N')<>'Y'
				and    NVL(REJECTED_BY_PAYER_YN,'N') <>'Y'
				order by //--decode(:p_sort_order,'P',SUBSTR(M.SHORT_NAME,1,30),'D',to_char(B.DOC_DATE,'DD/MM/YYYY'),B.PATIENT_ID),
				to_char(B.DOC_DATE,'DD/MM/YYYY'),B.DOC_TYPE_CODE,B.DOC_NUMBER; */ 

 
				
	if (OERROR)
        err_mesg("DECLARE failed on cursor BILL_CUR",0,"");


}

open_bill_cur()
{
	/* EXEC SQL OPEN BILL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0021;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )869;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
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
	err_mesg("OPEN failed on cursor BILL_CUR",0,"");
}

close_bill_cur()
{
/* EXEC SQL CLOSE BILL_CUR; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 41;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )892;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}


fn_get_pat_name()
{

nd_patient.arr[0]='\0';
nd_patient.len=0;
 /* EXEC SQL
      SELECT decode(:p_language_id,'en',substr(short_name,1,30),substr(short_name_loc_lang,1,30))
	  INTO   :nd_patient
	  FROM   MP_Patient_Mast
	  WHERE  patient_id = :d_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select decode(:b0,'en',substr(short_name,1,30),substr(short\
_name_loc_lang,1,30)) into :b1  from MP_Patient_Mast where patient_id=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )907;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_language_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_patient;
 sqlstm.sqhstl[1] = (unsigned int  )43;
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


	  

nd_patient.arr[nd_patient.len] ='\0';

}

/************************LEGEND HEAD *****************************/

fn_print_leg_hdr()
{
	    
		  fprintf(fp,"%c&a4L",ESC); 		// To set the left margin

		  print_line('_',115);

			//fprintf(fp,"%-8s %-26s %-14s %-15s %-10s %15s  %18s",loc_legend[23],loc_legend[5],loc_legend[17],loc_legend[6],loc_legend[4],loc_legend[7],loc_legend[8]);
			fprintf(fp,"%-8.8s  %-20.20s %-17.17s %38.38s  ",loc_legend[23],loc_legend[6],loc_legend[4],loc_legend[8]);

			//fprintf(fp,"%-8s %-21s %-14s %-15s %-10s %15s  %18s",loc_legend[23],loc_legend[5],loc_legend[17],loc_legend[6],loc_legend[4],loc_legend[7],loc_legend[8]);
			//fprintf(fp," %-4s %-30s %-20s %-15s %-10s %14s   %14s",loc_legend[23],loc_legend[5],loc_legend[17],loc_legend[6],loc_legend[4],loc_legend[8]);
			
		   if(strcmp(p_policy.arr,"Y")==0)
		    {
		next_line_f(1);
			 //fprintf(fp,"  %-50.50s %-s",loc_legend[11],loc_legend[13]);
			 //hh--fprintf(fp,"  %-80.50s %-s",loc_legend[13]);			 
			 //fprintf(fp," %-55s %-s",loc_legend[11],loc_legend[13]);
		    }
		   else
		    {
		next_line_f(1);
			//	fprintf(fp,"  %-50.50s %-s",loc_legend[11],loc_legend[13]);
			//hh--	fprintf(fp,"  %-75.50s %-s",loc_legend[13]);				
				
		        //fprintf(fp," %-55s %-s"," ",loc_legend[13]);
		    }

        next_line_f(1);
		horz_skip(1);
		print_line('_',117);

}



fn_print_leg_hdr_anx()
{
	  fprintf(fp,"%c(s16.5H",ESC); 
	      print_line('_',184);
		     if(d_pat_id_len <=10)
			  
			  //fprintf(fp,"%-8s %-26s %-14s %-15s %-10s %15s  %18s",loc_legend[23],loc_legend[5],loc_legend[17],loc_legend[6],loc_legend[4],loc_legend[7],loc_legend[8]);
			   fprintf(fp,"%-8.8s  %-20.20s %-17.17s %38.38s  ",loc_legend[23],loc_legend[6],loc_legend[4],loc_legend[7],loc_legend[8]);

			  //fprintf(fp,"%-4s %-30s %-10s %-15s %-10s %14s   %14s",loc_legend[23],loc_legend[5],loc_legend[17],loc_legend[6],loc_legend[4],loc_legend[7],loc_legend[8]);
			  else
               //fprintf(fp,"%-8s %-26s %-14s %-15s %-10s %15s  %18s",loc_legend[23],loc_legend[5],loc_legend[17],loc_legend[6],loc_legend[4],loc_legend[7],loc_legend[8]);
			    fprintf(fp,"%-8.8s  %-20.20s %-17.17s %38.38s  ",loc_legend[23],loc_legend[6],loc_legend[4],loc_legend[7],loc_legend[8]);

			  //fprintf(fp,"%-4s %-30s %-20s %-15s %-10s %14s   %14s",loc_legend[23],loc_legend[5],loc_legend[17],loc_legend[6],loc_legend[4],loc_legend[7],loc_legend[8]);

		   if(strcmp(p_policy.arr,"Y")==0)
		    {
		//next_line(1);
		           /*hh-- if(d_pat_id_len <=10)
					   //fprintf(fp,"  %-50s %-25s",loc_legend[11],loc_legend[13]);
					   fprintf(fp,"  %-80s %-25s"," ",loc_legend[13]);
					  //fprintf(fp,"   %-55s %-25s",loc_legend[11],loc_legend[13]);
					 else
					  //fprintf(fp,"%-50s %-15s",loc_legend[11],loc_legend[13]);
					  fprintf(fp,"%-85s %-15s",loc_legend[13]);
				      //fprintf(fp,"   %-55s %-15s",loc_legend[11],loc_legend[13]); hh--*/
		    }
		   else
		    {
		//next_line(1);
		     //hh--   fprintf(fp,"   %-59s",loc_legend[13]);
		    }

        next_line(1);
		print_line('_',184);

 }

fetch_bill_cur()
{
			//--d_patient_id.arr[0]		='\0';
			d_doc_type.arr[0]		= '\0';		
			d_doc_number.arr[0]		='\0';
			//--nd_patient.arr[0]		='\0';
			d_doc_date.arr[0]		='\0';	
			//--d_policy_type.arr[0]		='\0';	
			//--d_policy_code.arr[0]		='\0';			
			//--d_policy_num.arr[0]		='\0';
			d_doc_amt=0;	
			//--d_bill_amt=0;
			//hh--d_outst_amt=0;
			d_print_text.arr[0]  ='\0';

        	//--d_patient_id.len	=0;
			d_doc_type_code.len	=0;	
			d_doc_number.len	=0;
			d_doc_date.len		=0;
			//--d_policy_type.len   =0;
			//--d_policy_code.len   =0;			
			//--d_policy_num.len    =0;
			d_print_text.len    =0;
			//--nd_patient.len		=0;
			d_doc_type.len		=0;

		/* EXEC SQL FETCH BILL_CUR INTO
		    //--:d_patient_id,
			//--:nd_patient,
            :d_doc_type,
			:d_doc_num,
			:d_doc_number,
			:d_doc_date,
			:d_doc_amt,
			//:d_bill_amt,
			//--:d_outst_amt,
			//--:d_policy_type,
			//--:d_policy_code,
			//--:d_policy_num,
			:d_print_text; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 41;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )934;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_doc_type;
  sqlstm.sqhstl[0] = (unsigned int  )9;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_doc_num;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_doc_number;
  sqlstm.sqhstl[2] = (unsigned int  )18;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_doc_date;
  sqlstm.sqhstl[3] = (unsigned int  )18;
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
  sqlstm.sqhstv[5] = (         void  *)&d_print_text;
  sqlstm.sqhstl[5] = (unsigned int  )63;
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
            err_mesg("FETCH failed on cursor BILL_CUR",0,"");

			//--d_patient_id.arr[d_patient_id.len]		='\0';		
			d_doc_number.arr[d_doc_number.len]		='\0';		
			d_doc_date.arr[d_doc_date.len]		='\0';
			//--d_policy_type.arr[d_policy_type.len]		='\0';	
			d_print_text.arr[d_print_text.len] 	 	='\0';
			//--d_policy_code.arr[d_policy_code.len]		='\0';			
			//--d_policy_num.arr[d_policy_num.len]		='\0';
			//--nd_patient.arr[nd_patient.len]			= '\0';	
			d_doc_type.arr[d_doc_type.len]          ='\0';	

			return(LAST_ROW?0:1);


}


//----------------------UP TO HERE -------------------------------------------

fn_print_footer()
{
    
	next_line_f(1);
	   if(strcmp(d_let_body_footer_ln01.arr,"\0")!=0) 
	    {
		check_splch(d_let_body_footer_ln01.arr);
	//	fprintf(fp,"%-90s", d_let_body_footer_ln01.arr);
	// disp_message(ERR_MESG,d_let_body_footer_ln01.arr);
	next_line_f(1);
	    }

        if(strcmp(d_let_body_footer_ln02.arr,"\0")!=0) 
	    {
		check_splch(d_let_body_footer_ln02.arr);
		//fprintf(fp,"%-90s", d_let_body_footer_ln02.arr);
	    next_line_f(1);
	    }
	if(strcmp(d_let_body_footer_ln03.arr,"\0")!=0) 
	    {
		check_splch(d_let_body_footer_ln03.arr);

		//fprintf(fp,"%-90s", d_let_body_footer_ln03.arr);
	    next_line_f(1);
	    }
	if(strcmp(d_let_body_footer_ln04.arr,"\0")!=0) 
	    {
		check_splch(d_let_body_footer_ln04.arr);

		//fprintf(fp,"%-90s", d_let_body_footer_ln04.arr);
	next_line_f(1);
	    }
		if(strcmp(d_let_body_footer_ln05.arr,"\0")!=0) 
	    {
		check_splch(d_let_body_footer_ln05.arr);	

		//fprintf(fp,"%-90s", d_let_body_footer_ln05.arr);	
	next_line_f(1);
	    }
	   //fprintf(fp,"Regards,");	
	//next_line_f(1);
	//next_line_f(1);
	//next_line_f(1);

 fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style */

	 check_splch(d_authorized_signatory.arr);
			//fprintf(fp,"%-41s",d_authorized_signatory.arr);
    next_line_f(1);
	   check_splch(d_authorized_signatory_desg.arr);
          	//fprintf(fp,"%-41s",d_authorized_signatory_desg.arr);
    next_line_f(1);

 fprintf(fp,"%c(s-3B",ESC); 	/* To release Bold style */

	//next_line_f(1);

      if(strcmp(d_let_foot_note_ln01.arr,"\0")!=0) 
	    {
		fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style */
       check_splch(d_let_foot_note_ln01.arr);
	   fprintf(fp,"%c(s-3B",ESC); 	/* To release Bold style */
		//fprintf(fp,"%-90s", d_let_foot_note_ln01.arr);
	//next_line_f(1);
	    }
	   if(strcmp(d_let_foot_note_ln02.arr,"\0")!=0) 
	    {
		check_splch(d_let_foot_note_ln02.arr);
		//fprintf(fp,"%-90s", d_let_foot_note_ln02.arr);
	next_line_f(1);
	    }
    if(strcmp(d_let_foot_note_ln03.arr,"\0")!=0) 
	    {
		check_splch(d_let_foot_note_ln03.arr);
		//fprintf(fp,"%-90s", d_let_foot_note_ln03.arr);
	next_line_f(1);
	    }
      if(strcmp(d_let_foot_note_ln04.arr,"\0")!=0) 
	    {
			check_splch(d_let_foot_note_ln04.arr);
	//	fprintf(fp,"%-90s", d_let_foot_note_ln04.arr);
	next_line_f(1);
	   }
	    if(strcmp(d_let_foot_note_ln05.arr,"\0")!=0) 
	    {
		check_splch(d_let_foot_note_ln05.arr);
		//fprintf(fp,"%-90s", d_let_foot_note_ln05.arr);
	next_line_f(1);
	    }
  


}

print_amt_in_words()
{
   
   int no_of_lines;
  /** Below code Added by raghava on 7/1/2009 for printing Amount In words **/ 
   
    no_of_characts=75;
	fprintf(fp,"%s","(");
	fun_print_amt_in_words();
	fprintf(fp," %s",amt_in_words_Sep.arr);
	fprintf(fp,"%s",")");
 /** on 7/1/2009 **/

/* Commented by raghava on 7/1/2009 b/z for printing Amount In Words we are calling
   new procedure --bl_spell_number.print_in_words

   //fprintf(fp,"(%s ",d_foreign_currency_note.arr);
    // strcpy(subcur.arr,d_foreign_sub_currency.arr);
 
    fprintf(fp," (%s ",d_base_currency.arr);

     if(equal(d_tot_outst_amt,0.00)) 
			no_of_lines=0;
     if(d_tot_outst_amt>0)
		   	no_of_lines = print_in_words(d_tot_outst_amt,LENGTH_WORDS,subcur.arr,amt_in_words,l_decimal);

	 if(d_tot_outst_amt<0)
		   	no_of_lines = print_in_words(d_tot_outst_amt*-1,LENGTH_WORDS,subcur.arr,amt_in_words,l_decimal);
      
  	for (i =0;i<no_of_lines;i++)
	       	fprintf(fp," %s ",amt_in_words[i]); 
			 fprintf(fp,")");

	next_line(1);

 if(strcmp(d_foreign_currency_yn.arr,"Y")==0) 
  {
     next_line(1);
	 horz_skip(1);

   	len = strlen(d_foreign_currency_note.arr);
	while(r_ctr < len)
		{	
			split_text(d_foreign_currency_note.arr,75,cl_string,&r_ctr);
			fprintf(fp,"%-75.75s",cl_string);
			
			strcpy(cl_string,"");  
			next_line(1);
		}

   }

on 7/1/2009  */
}

print_amt_in_words_anx()
{
int no_of_lines;
   /** Below code Added by raghava on 7/1/2009 for printing Amount In words **/ 

    no_of_characts=175;
    fprintf(fp,"%s","(");
	fun_print_amt_in_words();
	fprintf(fp," %s",amt_in_words_Sep.arr);
	fprintf(fp,"%s",")");

  /** on 7/1/2009  **/

/* Commented by raghava on 7/1/2009 b/z for printing Amount In Words we are calling
   new procedure --bl_spell_number.print_in_words

    fprintf(fp,"(%s ",d_base_currency.arr);

     if(equal(d_tot_outst_amt,0.00)) 
			no_of_lines=0;
     if(d_tot_outst_amt>0)
		   	no_of_lines = print_in_words(d_tot_outst_amt,175,subcur.arr,amt_in_words,l_decimal);
      
	 if(d_tot_outst_amt<0)
		   	no_of_lines = print_in_words(d_tot_outst_amt*-1,175,subcur.arr,amt_in_words,l_decimal);
      
  	for (i =0;i<no_of_lines;i++)
	 strcat(amtwordanx.arr,amt_in_words[i]); 
	 strcat(amtwordanx.arr,")");
	      //fprintf(fp," %s ",amt_in_words[i]);


		  	 lenamtanx = strlen(amtwordanx.arr);
				while(r_ctramtanx < lenamtanx)
				{	
					split_text(amtwordanx.arr,155,cl_stringamtanx,&r_ctramtanx);
					fprintf(fp,"%-s",cl_stringamtanx);
					strcpy(cl_stringamtanx,"");
					next_line(1);
				}
r_ctramtanx=r_ctramtanx-1;   // added by hari 20/11/2007		  
		    //fprintf(fp,")");
     
	next_line(1);

	if(strcmp(d_foreign_currency_yn.arr,"Y")==0) 
  {
     
   	len = strlen(d_foreign_currency_note.arr);
				while(r_ctr_anx < len)
					{	
						split_text(d_foreign_currency_note.arr,175,cl_string_anx,&r_ctr_anx);
						fprintf(fp,"%-175.175s",cl_string_anx);
						strcpy(cl_string_anx,"");  
						next_line(1);
					}


   //fprintf(fp,"(%s ",d_foreign_currency_note.arr);
    // strcpy(subcur.arr,d_foreign_sub_currency.arr);
   }

on 7/1/2009  */    

}

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[15], str_amt[15];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15s  ",str_amt);
        }

}

fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRDSPLT.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 41;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRDSPLT.LEGEND_'||LTRIM(RTRIM(TO_CHA\
R(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )973;
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
			blcommon.get_local_lang_desc(:lv_facility_id,
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
  sqlstm.arrsiz = 41;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :lv_facility_id , '\
SM' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_va\
lue , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )996;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_facility_id;
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


/*
fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		EXEC SQL SELECT LTRIM(RTRIM('BLRDSPLT.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual;

		l_pk_value.arr[l_pk_value.len]	= '\0';
		l_translated_value.arr[0]		= '\0';

		EXEC SQL EXECUTE
		BEGIN
			blcommon.get_local_lang_desc(:lv_facility_id,
										'SM',
										'SM_LANG_LEGEND',
										'DFLT_LEGEND_VALUE',
										:l_pk_value,
										:l_translated_value,
										:p_language_id);

		END;
		END-EXEC;

		l_translated_value.arr[l_translated_value.len] = '\0';
		strcpy(loc_legend[i],l_translated_value.arr);
	}
}


*/


next_line(skip) /* will check for MAX LINE before printing totals */		
int skip;
 {
	if ((lctr + skip) >= 41)
	{
		next_page(); 
	}
	else
	{
		fprintf(fp,"\n"); ++lctr;
		// fprintf(fp,"LNNO:%2d",lctr); 
	}
 }
   

next_line_f(skip) /* will check for MAX LINE before printing totals */		
int skip;
 {
	if ((lctr + skip) >= 57)
	{
	   // print_line('_',115);
       // fprintf(fp,"%-s : %s %-s : %s ",loc_legend[24],d_user.arr,loc_legend[4],d_date_time.arr); 
		fprintf(fp,"\f"); 
			lctr=0;
	    fprintf(fp,"\n"); 
			lctr=1;
	}
	else
	{
		fprintf(fp,"\n"); ++lctr;
		    // fprintf(fp,"LNNO:%2d",lctr); 
	}
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

vert_skip(num)
int num;
	{
	int i;
	for(i=0;i<num;i++)fprintf(fp,"\n");lctr=lctr+num;
	}


next_page() /* will move the cursor to next page */
{
  
	fprintf(fp,"\n");
	fprintf(fp,"\f");
	lctr=0;
	fprintf(fp,"\n"); 
	 

    fn_print_annax_header();
    fn_print_leg_hdr_anx();

//	print_page_title();
	//print_column_title();  	
}

/*****added 29/11/2005 ****/


int char_position(ls_var,lc_var,ld_var)
char ls_var[201];
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
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,:b1,:b2) into :b3  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1027;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ls_str_var;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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

char put_string(ls_var,ld_pos,ld_length)
char ls_var[201];
int ld_pos,ld_length;
{
 ls_str_var.arr[0] = '\0';
 ls_str_var.len = 0;

 strcpy(ls_str_var.arr,ls_var);
 ls_str_var.len = strlen(ls_str_var.arr);

// ls_str_var.arr[ls_str_var.len] = '\0';

 /* EXEC SQL select substr(:ls_str_var,:ld_pos,:ld_length)
	         into :ls_str
			 from dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select substr(:b0,:b1,:b2) into :b3  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1058;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&ls_str_var;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqhstl[3] = (unsigned int  )203;
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

 if (spchar_pos == 0)   
 {
 lc_str_var.arr[0]	='\0';
 lc_str_var.len		= 0;
 prt_len = len_lc_str_val - print_upto_c ;

 put_string(lc_str_val.arr,print_upto_c + 1,prt_len);
 strcpy(lc_str_var.arr,ls_str.arr);

 lc_str_var.len=strlen(lc_str_var.arr);

 fprintf(fp,"%s",lc_str_var.arr);
 lc_str_var.arr[0] ='\0';

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

  lc_str_var.arr[0] ='\0';
  
  if (spchar_type == 1)
  {
  next_line_f(1);
  }

  if (spchar_type == 2)
  {
 // fprintf(fp,"\n");
 // line_ctr++;
 next_line_f(1);
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
	fprintf(fp,"%c(s13H",ESC); 	/* To set the font 			*/
	font_st = 0;
	}
    else
	{
	fprintf(fp,"%c(s10H",ESC); 	/* To set the font 			*/
	font_st = 1;
	}
  }


  ctr = spchar_pos+2;
  print_upto_c = spchar_pos+1;
  }  


 }


}

int chk_tab_pos(str_var2,st_pos)
char str_var2[201];
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
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\t',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1089;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
char str_var2[201];
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
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\n',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1116;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
char str_var2[201];
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
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\N',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1143;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
char str_var2[201];
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
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\b',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1170;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
char str_var2[201];
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
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\f',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1197;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
char str_var2[201];
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
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'\\',:b1) into :b2  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1224;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
char str_var2[201];
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
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select instr(:b0,'DATE',1) into :b1  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1251;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lc_splch_var;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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



print_spaces(l_length)
double l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(fp," ");
	}
}


/****************/

insert_string()
{

/* EXEC SQL EXECUTE
declare
	k number :=0; //-- Search String Position		
	c1 number := 0; //   -- Counter 
 begin

	if substr(:p_org_str,-length('\n')) = '\n' then 	

	loop	
		if instr(:p_org_str,'\n',1,c1+1) > 0 then 		
			c1 := c1 + 1;
			k := instr(:p_org_str,'\n',1,c1);						
		else
			exit;
		end if;		
	end loop;
	

	
	
	if nvl(k,0) = 0 then 
			return; 
	end if;	
	
	loop		
		if c1 > 1 and instr(:p_org_str,'\n',1,c1-1) = 
			k - length('\n')  
		then 
			k := instr(:p_org_str,'\n',1,c1-1);
			c1 := c1-1;
						
			if c1 <= 1 then 
				exit;			
			end if;				
		else
			exit;		
		end if;
	end loop;
	
	:p_ret_str := substr(:p_org_str,1,k-1) || :p_add_str || substr(:p_org_str,k);	
	
 else
		:p_ret_str := :p_org_str|| :p_add_str;	
						
  end if;
end;

END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 41;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare k number := 0 ; c1 number := 0 ; begin if substr ( :\
p_org_str , -length ( '\\n' ) ) = '\\n' then loop if instr ( :p_org_str , '\\\
n' , 1 , c1 + 1 ) > 0 then c1 := c1 + 1 ; k := instr ( :p_org_str , '\\n' , 1\
 , c1 ) ; else exit ; end if ; end loop ; if nvl ( k , 0 ) = 0 then return ; \
end if ; loop if c1 > 1 and instr ( :p_org_str , '\\n' , 1 , c1 -1 ) = k -len\
gth ( '\\n' ) then k := instr ( :p_org_str , '\\n' , 1 , c1 -1 ) ; c1 := c1 -\
1 ; if c1 <= 1 then exit ; end if ; else exit ; end if ; end loop ; :p_ret_st\
r := substr ( :p_org_str , 1 , k -1 ) || :p_add_str || substr ( :p_org_str , \
k ) ; else :p_ret_str := :p_org_str || :p_add_str ; end if ; end ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1274;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&p_org_str;
sqlstm.sqhstl[0] = (unsigned int  )102;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&p_ret_str;
sqlstm.sqhstl[1] = (unsigned int  )203;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&p_add_str;
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

	

}

print_formated_hdr(loc_amount)
double loc_amount;
{
	char s_amt[15], str_amt[15];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%-s",s_amt);
        fprintf(fp,"%-sCR",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%s",s_amt);
        fprintf(fp,"%-s  ",str_amt);
        }

}


print_hdr_amt_in_words()
{
int no_of_lines;
 
    //fprintf(fp," (%s ",d_base_currency.arr);
  /** Below code Added by raghava on 7/1/2009 for printing Amount In words **/ 
    no_of_characts=60;
    fprintf(fp,"%s","(");
	fun_print_amt_in_words();
	fprintf(fp," %s",amt_in_words_Sep.arr);
	fprintf(fp,"%s",")");
  /** 07/1/2009 **/

/* Commented by raghava on 7/1/2009 b/z for printing Amount In Words we are calling
   new procedure --bl_spell_number.print_in_words

    fprintf(fp," (%s ",d_base_currency.arr);
	
     if(equal(d_tot_outst_amt,0.00)) 
			no_of_lines=0;
     if(d_tot_outst_amt>0)
		   	no_of_lines = print_in_words(d_tot_outst_amt,LENGTH_WORDS,subcur.arr,hdr_amt_in_words,l_decimal);
      
	 if(d_tot_outst_amt<0)
		   	no_of_lines = print_in_words(d_tot_outst_amt*-1,LENGTH_WORDS,subcur.arr,hdr_amt_in_words,l_decimal);
      
  	for (i =0;i<no_of_lines;i++)
	   strcat(amtword.arr,hdr_amt_in_words[i]); 
	   strcat(amtword.arr,")");

	     	//fprintf(fp," %s ",hdr_amt_in_words[i]); 
			 //fprintf(fp,")");
//-----------------------

			 lenamt = strlen(amtword.arr);
				while(r_ctramt < lenamt+1)
				{	
					split_text(amtword.arr,60,cl_stringamt,&r_ctramt);
					fprintf(fp,"%-s",cl_stringamt);
					strcpy(cl_stringamt,"");
					next_line(1);
				}
r_ctramt=r_ctramt-1;   // added by hari 20/11/2007	

    // fprintf(fp,")");
//------------------------
on 7/1/2009 */

 }
fun_print_amt_in_words()
{


 	amt_in_words1.arr[0]='\0';
	amt_in_words1.len=0;
	
	amt_in_words_Sep.arr[0]='\0';
	amt_in_words_Sep.len=0;

	/* EXEC SQL EXECUTE
	BEGIN		
	:no_of_lines:=bl_spell_number.print_in_words
							 (:lv_facility_id,
							  abs(nvl(:d_tot_outst_amt,0)),
							 :no_of_characts,
							 :d_base_currency,
							 :subcur,
							 :l_decimal,
							 :amt_in_words1,
							 :amt_in_words_Sep1);
  	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :no_of_lines := bl_spell_number . print_in_words ( :l\
v_facility_id , abs ( nvl ( :d_tot_outst_amt , 0 ) ) , :no_of_characts , :d_b\
ase_currency , :subcur , :l_decimal , :amt_in_words1 , :amt_in_words_Sep1 ) ;\
 END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1301;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&no_of_lines;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lv_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )5;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_tot_outst_amt;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&no_of_characts;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_base_currency;
 sqlstm.sqhstl[4] = (unsigned int  )27;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&subcur;
 sqlstm.sqhstl[5] = (unsigned int  )9;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_decimal;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&amt_in_words1;
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


	amt_in_words1.arr[amt_in_words1.len]='\0';
	amt_in_words_Sep1.arr[amt_in_words_Sep1.len]='\0';

	/* EXEC SQL SELECT REPLACE(:amt_in_words_Sep1,'~',CHR(10)) 
		 INTO :amt_in_words_Sep
		 FROM DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select REPLACE(:b0,'~',CHR(10)) into :b1  from DUAL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1352;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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

fn_print_online()
{
	PrintDocument(
				  lv_pword.arr,				//char	*PUidPwd;
				  lv_session_id.arr,		//char	*PSessionID;
				  lv_facility_id.arr,		//char	*PFacilityID;
				  "BL",						//char	*PModuleID;
				  lv_pgm_id.arr,			//char	*PDocumentID;
				  filename,				//char	*POnlinePrintFileNames;
				  "O",						//char	*PLocationTypes;
				  " ",						//char	*PLocationCodes;
				  1,						//int	PNumOfCopies;
				  1,						//int	PPageFrom;
				  9999						//int	PPageTo;
				 );
			
}

fn_print_settings()
{
	fprintf(fp,"%c(s0P",ESC);		// To fix the primary spacing
	fprintf(fp,"%c&l0O",ESC); 		// To print in portait mode
	fprintf(fp,"%c(s4099T",ESC);	// To set the font name	
	fprintf(fp,"%c&l8D",ESC); 		// To set vertical lines per inch
	fprintf(fp,"%c&a2L",ESC); 		// To set the left margin
	fprintf(fp,"%c&l6E",ESC); 		// To set the top margin
	fprintf(fp,"%c(s12H",ESC); 		// To set the font
	
	//fprintf(fp,"%c&l0H",ESC);		// To eject page
	//fprintf(fp,"%cE",ESC);		// To reset the printer
	//fprintf(fp,"%c&d0D",ESC);		// To set underline mode
	//fprintf(fp,"%c&d@",ESC);		// To release underline mode
	//fprintf(fp,"%c(s3B",ESC); 	// To set bold style
	//fprintf(fp,"%c(s-3B",ESC);	// To release bold style
}

get_language_id()
{
	p_language_id.arr[0] = '\0';
	p_language_id.len = 0;
     strcpy(p_language_id.arr,l_language_id.arr);
	 p_language_id.len = l_language_id.len;	

	/* EXEC SQL SELECT LANGUAGE_ID INTO :p_language_id FROM SM_APPL_USER where APPL_USER_ID = :d_user; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LANGUAGE_ID into :b0  from SM_APPL_USER where APPL_U\
SER_ID=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1375;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_language_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_user;
 sqlstm.sqhstl[1] = (unsigned int  )42;
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
        err_mesg("SELECTING LANGUAGE_ID failed",0,"");
}
get_initialize()
{
nd_temp_date.arr[0] = '\0';
nd_loc_date.arr[0]  = '\0';

nd_temp_date.len = 0;
nd_loc_date.len  = 0;
}
get_local_date_convn1()
{

nd_temp_date.len = strlen(nd_temp_date.arr);
get_local_date1();

}

get_local_date_convn2()
{

nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date2();

}

get_local_date1()
{

	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY'),
															:p_language_id,
															t_date);

	//	:nd_loc_date := to_char(t_date,'ddth fmMonth YYYY');
		:nd_loc_date := to_char(t_date,'DD/MM/YYYY');

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_lo\
cale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY' ) , :p_language_id , t_dat\
e ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1398;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )43;
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
 sqlstm.sqhstl[2] = (unsigned int  )43;
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
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY '),:p_language_id,t_date);

		:nd_loc_date := to_char(t_date,'DD/MM/YYYY');
	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 41;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_lo\
cale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY ' ) , :p_language_id , t_da\
te ) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1425;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )43;
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
 sqlstm.sqhstl[2] = (unsigned int  )43;
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