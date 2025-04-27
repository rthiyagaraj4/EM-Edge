
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
           char  filnam[42];
};
static const struct sqlcxp sqlfpn =
{
    41,
    "C:\\temp\\Online_ Receipt_ Bill\\blrcoupn.pc"
};


static unsigned long sqlctx = 2070190827;


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
            void  *sqhstv[11];
   unsigned int   sqhstl[11];
            int   sqhsts[11];
            void  *sqindv[11];
            int   sqinds[11];
   unsigned int   sqharm[11];
   unsigned int   *sqharc[11];
   unsigned short  sqadto[11];
   unsigned short  sqtdso[11];
} sqlstm = {10,11};

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

 static const char *sq0012 = 
"select DOC_TYPE_CODE ,DOC_NUMBER ,DOC_SRNO ,EPISODE_TYPE ,PATIENT_ID ,EPISOD\
E_ID ,VISIT_ID ,DOC_AMT ,TO_CHAR(DOC_DATE,'DD-MON-YYYY') ,PRINT_FLAG  from BL_\
RECEIPT_REFUND_HDRDTL_VW where ((DOC_TYPE_CODE=:b0 and DOC_NUMBER between to_n\
umber(:b1) and to_number(:b2)) and REC_REF_FORMAT_IND='C')           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,109,0,6,287,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,1,0,0,2,9,0,0,
36,0,0,2,150,0,4,309,0,0,5,4,0,1,0,1,3,0,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
71,0,0,3,305,0,6,380,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,
0,0,
110,0,0,4,0,0,30,423,0,0,0,0,0,1,0,
125,0,0,5,0,0,27,430,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
156,0,0,6,190,0,4,474,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,
9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
207,0,0,7,365,0,6,518,0,0,5,5,0,1,0,1,9,0,0,3,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,
242,0,0,8,292,0,6,559,0,0,5,5,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,
277,0,0,9,184,0,6,598,0,0,3,3,0,1,0,1,9,0,0,3,9,0,0,3,9,0,0,
304,0,0,10,1366,0,6,624,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,3,3,0,0,3,3,0,0,1,9,0,
0,2,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
363,0,0,11,267,0,4,740,0,0,6,2,0,1,0,1,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
402,0,0,12,301,0,9,786,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
429,0,0,12,0,0,13,813,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,1,0,0,
484,0,0,13,254,0,4,1174,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
507,0,0,14,90,0,4,1186,0,0,1,0,0,1,0,2,9,0,0,
526,0,0,15,192,0,4,1201,0,0,2,1,0,1,0,2,9,0,0,1,4,0,0,
549,0,0,16,267,0,4,1217,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
572,0,0,17,90,0,4,1229,0,0,1,0,0,1,0,2,9,0,0,
591,0,0,18,267,0,4,1240,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
614,0,0,19,90,0,4,1252,0,0,1,0,0,1,0,2,9,0,0,
633,0,0,20,267,0,4,1262,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
656,0,0,21,90,0,4,1274,0,0,1,0,0,1,0,2,9,0,0,
675,0,0,22,267,0,4,1284,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
698,0,0,23,90,0,4,1296,0,0,1,0,0,1,0,2,9,0,0,
717,0,0,24,267,0,4,1307,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
740,0,0,25,90,0,4,1319,0,0,1,0,0,1,0,2,9,0,0,
759,0,0,26,267,0,4,1329,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
782,0,0,27,90,0,4,1341,0,0,1,0,0,1,0,2,9,0,0,
801,0,0,28,267,0,4,1351,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
824,0,0,29,90,0,4,1363,0,0,1,0,0,1,0,2,9,0,0,
843,0,0,30,267,0,4,1373,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
866,0,0,31,90,0,4,1385,0,0,1,0,0,1,0,2,9,0,0,
885,0,0,32,254,0,4,1396,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
908,0,0,33,90,0,4,1408,0,0,1,0,0,1,0,2,9,0,0,
927,0,0,34,254,0,4,1419,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
950,0,0,35,90,0,4,1431,0,0,1,0,0,1,0,2,9,0,0,
969,0,0,36,349,0,4,1442,0,0,3,2,0,1,0,1,3,0,0,2,9,0,0,1,9,0,0,
996,0,0,37,197,0,4,1456,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
1019,0,0,38,349,0,4,1470,0,0,3,2,0,1,0,1,3,0,0,2,9,0,0,1,9,0,0,
1046,0,0,39,197,0,4,1484,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
1069,0,0,40,247,0,4,1497,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1092,0,0,41,90,0,4,1509,0,0,1,0,0,1,0,2,9,0,0,
1111,0,0,42,247,0,4,1520,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1134,0,0,43,90,0,4,1532,0,0,1,0,0,1,0,2,9,0,0,
1153,0,0,44,247,0,4,1543,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1176,0,0,45,90,0,4,1555,0,0,1,0,0,1,0,2,9,0,0,
1195,0,0,46,247,0,4,1566,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1218,0,0,47,90,0,4,1578,0,0,1,0,0,1,0,2,9,0,0,
1237,0,0,48,247,0,4,1589,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1260,0,0,49,90,0,4,1601,0,0,1,0,0,1,0,2,9,0,0,
1279,0,0,50,247,0,4,1612,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1302,0,0,51,90,0,4,1624,0,0,1,0,0,1,0,2,9,0,0,
1321,0,0,52,247,0,4,1637,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1344,0,0,53,90,0,4,1649,0,0,1,0,0,1,0,2,9,0,0,
1363,0,0,54,247,0,4,1661,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1386,0,0,55,90,0,4,1673,0,0,1,0,0,1,0,2,9,0,0,
1405,0,0,56,247,0,4,1686,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1428,0,0,57,90,0,4,1698,0,0,1,0,0,1,0,2,9,0,0,
1447,0,0,58,247,0,4,1712,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1470,0,0,59,90,0,4,1724,0,0,1,0,0,1,0,2,9,0,0,
1489,0,0,60,247,0,4,1736,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1512,0,0,61,90,0,4,1748,0,0,1,0,0,1,0,2,9,0,0,
1531,0,0,62,247,0,4,1761,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1554,0,0,63,90,0,4,1773,0,0,1,0,0,1,0,2,9,0,0,
1573,0,0,64,247,0,4,1787,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1596,0,0,65,90,0,4,1799,0,0,1,0,0,1,0,2,9,0,0,
1615,0,0,66,247,0,4,1812,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1638,0,0,67,90,0,4,1824,0,0,1,0,0,1,0,2,9,0,0,
1657,0,0,68,247,0,4,1837,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1680,0,0,69,90,0,4,1849,0,0,1,0,0,1,0,2,9,0,0,
1699,0,0,70,247,0,4,1861,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1722,0,0,71,90,0,4,1873,0,0,1,0,0,1,0,2,9,0,0,
1741,0,0,72,247,0,4,1884,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1764,0,0,73,90,0,4,1896,0,0,1,0,0,1,0,2,9,0,0,
1783,0,0,74,93,0,5,1968,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRCOUPN.PC                                  */
/* AUTHOR                : K.SARAVANAN                                  */
/* DATE WRITTEN          : 13-AUG-2003                                  */
/*                                                                      */
/* CALLED FROM           :                                              */ 
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */ 
/*                                                                      */
/*        S. No.     TABLENAMES             INPUT/OUTPUT                */
/*                                                                      */
/*         1.        BL_RECEIPT_REFUND_DTL     Query/Update             */
/*         2.        SY_PROG_CONTROL           Update/Lookup            */
/*         3.        SY_PROG_MESG                Insert                 */
/*                                                                      */
/*  PARAMETERS           :             -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/*                                                                      */
/*                                                                      */
/************************************************************************/

#include <stdio.h>
#include <string.h>
#include <math.h>

//#include <sqlca.h>
//#include <sqlda.h>
#include <bl.h>


/*
#define OERROR (sqlca.sqlcode < 0)
*/

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define MAX_LINES 80

#define INIT_MESG       "Printing Coupon in progress"
#define ONLINE_PRINTING 1
/*
#define DEBUG 1
*/

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
#define ESC    0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 



   /* VARCHAR uid_pwd      [132],
           hosp_name    [120],
           date_time    [20],
           user_id      [20],
           nd_pgm_date  [35],
	   nd_facility_name[31],
	   nd_calling_pgm_id[51],
	   nd_logo_pgm_id[1000],
	   nd_service_desc[41],
	   nd_recpt_nature_code[3],
	   nd_blng_grp   [3],
	   nd_hcard_status[12],	
	   nd_service_code[11],
	   nd_hcard_num[21],
	   
	   nd_hcard_expiry_date[15],
	   nd_cash_counter_desc [16],
	   l_printer_ids[1000],
	   l_printer_names[1000],
	   l_printer_types[1000],
	   l_queue_names[1000],
	   l_no_of_copies[1000],
	   l_errortext[1000],
	   l_logo_yniflaser[2],
	   LOGO_DIR[1000],
	   l_logo_name[1000],
	   l_errorlevel[10],
	   l_sysmessageid[10],
	   nd_hosp_name[1000],
	   nd_hosp_name1[1000]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[51]; } nd_calling_pgm_id;

struct { unsigned short len; unsigned char arr[1000]; } nd_logo_pgm_id;

struct { unsigned short len; unsigned char arr[41]; } nd_service_desc;

struct { unsigned short len; unsigned char arr[3]; } nd_recpt_nature_code;

struct { unsigned short len; unsigned char arr[3]; } nd_blng_grp;

struct { unsigned short len; unsigned char arr[12]; } nd_hcard_status;

struct { unsigned short len; unsigned char arr[11]; } nd_service_code;

struct { unsigned short len; unsigned char arr[21]; } nd_hcard_num;

struct { unsigned short len; unsigned char arr[15]; } nd_hcard_expiry_date;

struct { unsigned short len; unsigned char arr[16]; } nd_cash_counter_desc;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_ids;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_names;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_types;

struct { unsigned short len; unsigned char arr[1000]; } l_queue_names;

struct { unsigned short len; unsigned char arr[1000]; } l_no_of_copies;

struct { unsigned short len; unsigned char arr[1000]; } l_errortext;

struct { unsigned short len; unsigned char arr[2]; } l_logo_yniflaser;

struct { unsigned short len; unsigned char arr[1000]; } LOGO_DIR;

struct { unsigned short len; unsigned char arr[1000]; } l_logo_name;

struct { unsigned short len; unsigned char arr[10]; } l_errorlevel;

struct { unsigned short len; unsigned char arr[10]; } l_sysmessageid;

struct { unsigned short len; unsigned char arr[1000]; } nd_hosp_name;

struct { unsigned short len; unsigned char arr[1000]; } nd_hosp_name1;

   /* VARCHAR nd_session_id    [16],
	   nd_facility_id	[3] ,
           nd_fm_doc_type   [7],
           nd_to_doc_type   [7],
           nd_fm_doc_num    [10],
           nd_to_doc_num    [10],
           nd_fm_doc_date   [12],
		   cur_str          [8],
		   sub_cur_str      [8],	   
           nd_to_doc_date   [12]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[10]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[8]; } cur_str;

struct { unsigned short len; unsigned char arr[8]; } sub_cur_str;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_date;


   /* VARCHAR fm_doc_type_code                             [7],
           fm_doc_number                                [9],
		   to_doc_type_code                             [7],
           to_doc_number                                [9],
           d_doc_date                                  [13],
           d_trx_date_time                             [17],
           d_patient_id                                [21],
           d_patient_name                              [201],
           d_patient_name_loc_lang                     [61],
           d_episode_id									[9],
           d_visit_id									[5],
           d_doc_type_code								[7],
           d_doc_number									[9],
		   d_doc_srno								[3],
	   nd_reportid									[20],
	   nd_ws_no[30]; */ 
struct { unsigned short len; unsigned char arr[7]; } fm_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } fm_doc_number;

struct { unsigned short len; unsigned char arr[7]; } to_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } to_doc_number;

struct { unsigned short len; unsigned char arr[13]; } d_doc_date;

struct { unsigned short len; unsigned char arr[17]; } d_trx_date_time;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[201]; } d_patient_name;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_number;

struct { unsigned short len; unsigned char arr[3]; } d_doc_srno;

struct { unsigned short len; unsigned char arr[20]; } nd_reportid;

struct { unsigned short len; unsigned char arr[30]; } nd_ws_no;


   char		d_episode_type,
			nd_print_flag,
			nd_lang_ind,
			nd_rec_ref_flag,
			online_batch_flag,
			nd_online_print_yn,
			d_err_code[30];

   double	d_doc_amt,
			nd_dep_amt;

   int	nd_no_of_decimal,
		nd_dep_status = 0,l_dmp = 0, l_lsr = 0,
		l_margin_len= 30;

	/* VARCHAR		nd_file_name [50],
				nd_lang_id	[4],
				l_temp_loc_legend[201],
				loc_legend1	[201],
				loc_legend2	[201],
				loc_legend3	[201],
				loc_legend4	[201],
				loc_legend5	[201],
				loc_legend6	[201],
				loc_legend7	[201],
				loc_legend8	[201],
				loc_legend9	[201],
				loc_legend10[201],
				loc_legend11[201],
				loc_legend12[201],
				loc_legend13[201],
				loc_legend14[201],
				                       /o--------20/09/2005----o/
				loc_legend15[201],
				loc_legend16[201],
				loc_legend17[201],
				loc_legend18[201],
				loc_legend19[201],
				loc_legend20[201],
				loc_legend21[201],
				loc_legend22[201],
				loc_legend23[201],
				loc_legend24[201],
				loc_legend25[201],
				loc_legend26[201],
				loc_legend27[201],
				loc_legend28[201],
				loc_legend35[201],
				loc_legend36[201]; */ 
struct { unsigned short len; unsigned char arr[50]; } nd_file_name;

struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[201]; } l_temp_loc_legend;

struct { unsigned short len; unsigned char arr[201]; } loc_legend1;

struct { unsigned short len; unsigned char arr[201]; } loc_legend2;

struct { unsigned short len; unsigned char arr[201]; } loc_legend3;

struct { unsigned short len; unsigned char arr[201]; } loc_legend4;

struct { unsigned short len; unsigned char arr[201]; } loc_legend5;

struct { unsigned short len; unsigned char arr[201]; } loc_legend6;

struct { unsigned short len; unsigned char arr[201]; } loc_legend7;

struct { unsigned short len; unsigned char arr[201]; } loc_legend8;

struct { unsigned short len; unsigned char arr[201]; } loc_legend9;

struct { unsigned short len; unsigned char arr[201]; } loc_legend10;

struct { unsigned short len; unsigned char arr[201]; } loc_legend11;

struct { unsigned short len; unsigned char arr[201]; } loc_legend12;

struct { unsigned short len; unsigned char arr[201]; } loc_legend13;

struct { unsigned short len; unsigned char arr[201]; } loc_legend14;

struct { unsigned short len; unsigned char arr[201]; } loc_legend15;

struct { unsigned short len; unsigned char arr[201]; } loc_legend16;

struct { unsigned short len; unsigned char arr[201]; } loc_legend17;

struct { unsigned short len; unsigned char arr[201]; } loc_legend18;

struct { unsigned short len; unsigned char arr[201]; } loc_legend19;

struct { unsigned short len; unsigned char arr[201]; } loc_legend20;

struct { unsigned short len; unsigned char arr[201]; } loc_legend21;

struct { unsigned short len; unsigned char arr[201]; } loc_legend22;

struct { unsigned short len; unsigned char arr[201]; } loc_legend23;

struct { unsigned short len; unsigned char arr[201]; } loc_legend24;

struct { unsigned short len; unsigned char arr[201]; } loc_legend25;

struct { unsigned short len; unsigned char arr[201]; } loc_legend26;

struct { unsigned short len; unsigned char arr[201]; } loc_legend27;

struct { unsigned short len; unsigned char arr[201]; } loc_legend28;

struct { unsigned short len; unsigned char arr[201]; } loc_legend35;

struct { unsigned short len; unsigned char arr[201]; } loc_legend36;

				

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/blrcoupn.c-arc   1.0   Apr 19 2007 17:05:54   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/blrcoupn.c-arc   1.0   Apr 19 2007 17:05:54   vcm_th  $ sqlda.h 
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
int lctr = 0,pctr =0;

char filename[150];
char l_epi_barcode[50],
     l_rec_barcode[50];

void proc_main(argc,argv)
char *argv[];
int argc;
{

   char lv_msg[1024];

   disp_message(ERR_MESG," caliing BLRCOUPON");

   if (argc < 6) {
        disp_message(ERR_MESG,"BLRCOUPN : Usage BLRCOUPN userid/password session_id pgm_date facility_id nd_calling_pgm_id [filename]\n");
        proc_exit();
    } 
    
   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(g_session_id,argv[2]);
   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"BLRCOUPN"); 

   if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
      proc_exit();
   }

   set_meduser_role();
   

   strcpy(g_pgm_date,argv[3]);
   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   strcpy(nd_facility_id.arr,argv[4]);

   nd_facility_id.len  = strlen(nd_facility_id.arr);
   strcpy(g_facility_id,nd_facility_id.arr);

   strcpy(nd_calling_pgm_id.arr,argv[5]);

   nd_calling_pgm_id.len  = strlen(nd_calling_pgm_id.arr);
   nd_calling_pgm_id.arr[nd_calling_pgm_id.len] = '\0';


   if (argc > 6) 
		strcpy(nd_file_name.arr,argv[6]);
   else
		strcpy(nd_file_name.arr,"blrcoupn.lis");
	
	nd_file_name.len  = strlen(nd_file_name.arr);

  


	//open_files(); 

	fetch_prog_param();

	//fetch_currency();

	get_printer_type();	

	l_logo_yniflaser.arr[0] = 'N';

	//get_logo_dtl();	
	
	//This logic is shifted to Report Writer

	get_left_margin();	

	fetch_currency();

        open_files(); 	

 disp_message(ERR_MESG," caliing decl_coupon_cur");
	decl_coupon_cur();

	disp_message(ERR_MESG," after caliing decl_coupon_cur");

	while(fetch_coupon_cur())
	{

	   disp_message(ERR_MESG," enter in while");

		disp_message(ERR_MESG,d_doc_srno.arr);

		nd_lang_id.arr[0] = '\0';
		nd_lang_id.len = 0;

		/* EXEC SQL EXECUTE
			BEGIN
			blcommon.get_language_ind_id
				(
					:nd_facility_id,
					:d_patient_id,
					:nd_lang_ind,
					:nd_lang_id				
				);
			END;
			END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_language_ind_id ( :nd_facility_id , :d\
_patient_id , :nd_lang_ind , :nd_lang_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )5;
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
  sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_lang_ind;
  sqlstm.sqhstl[2] = (unsigned int  )1;
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


 
		nd_lang_id.arr[strlen(nd_lang_id.arr)] = '\0';

		fetch_legend_value();		

		if (loc_legend36.arr[0] != '\0')
		{
			d_patient_name.arr[0] = '\0';
			d_patient_name.len  = 0;        			
			

			/* EXEC SQL SELECT lpad(' ',round((:l_margin_len-length(rtrim(:loc_legend36||short_name)))/2),' ')||(rtrim(:loc_legend36||short_name))
			INTO :d_patient_name
			FROM MP_PATIENT_MAST
			WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim((:b1||short_name\
))))/2)),' ')||rtrim((:b1||short_name))) into :b3  from MP_PATIENT_MAST where \
PATIENT_ID=:b4";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )36;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&loc_legend36;
   sqlstm.sqhstl[1] = (unsigned int  )203;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&loc_legend36;
   sqlstm.sqhstl[2] = (unsigned int  )203;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_patient_name;
   sqlstm.sqhstl[3] = (unsigned int  )203;
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
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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
	    
			 d_patient_name.arr[d_patient_name.len]  = '\0';
			 
		}

		if (l_lsr != 0 && l_dmp == 0)
			{
			    if ( l_logo_yniflaser.arr[0] != 'Y')			    
			    {
			      fprintf(fp,"%c&a20L",ESC); 	/* To Set the Left margin */
			      fprintf(fp,"%c(s12H",ESC); 	/* To set the font size	  */
			      fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 	  */	      
			     }
			}		
			else
			{
				fprintf(fp,"%cM",ESC); 	/* To Set compressed mode */
			}			

		//fprintf(fp,"%cM",ESC); 	/* To Set compressed mode */
		print_coupon();
		if ( l_logo_yniflaser.arr[0] != 'Y')			    
			fprintf(fp,""); /* Page break  */

		if (l_lsr != 0 && l_dmp == 0)
			{
			     if ( l_logo_yniflaser.arr[0] != 'Y')			    
				fprintf(fp,"%cE",ESC);  /* To Reset Printer */			
			}
	}
       
	fclose(fp);	
     
        
	if (nd_online_print_yn == 'Y')
	{
		if (l_logo_yniflaser.arr[0] != 'Y')
		{
		   PrintDocument
		   (
			uid_pwd.arr,		//char	*PUidPwd;
			nd_session_id.arr,	//char	*PSessionID;
			nd_facility_id.arr,	//char	*PFacilityID;
			"BL",				//char	*PModuleID;
			nd_calling_pgm_id.arr,			//char	*PDocumentID;
			filename,			//char	*POnlinePrintFileNames;
			"O",				//char	*PLocationTypes;
			" ",				//char	*PLocationCodes;
			1,					//int		PNumOfCopies;
			1,					//int		PPageFrom;
			9999					//int		PPageTo;
			);
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
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare l_print_status BOOLEAN ; BEGIN APPPRINT . SUBMIT_OR\
ACLE_REPORT ( :nd_ws_no , :nd_facility_id , 'BL' , :nd_logo_pgm_id , 'P' , '' \
, '' , 'O' , ' ' , NULL , NULL , NULL , NULL , NULL , 'P_FILE_NAME=' || :nd_fi\
le_name || '+' || 'P_LOGO_NAME=' || :l_logo_name , l_print_status , :l_errorte\
xt ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )71;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[0] = (unsigned int  )32;
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

	

 
   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )110;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   return;
}


sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )125;
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

open_files()
{
  
if (LOGO_DIR.arr[0] != '\0') 
   strcpy(filename,LOGO_DIR.arr);
else 
   strcpy(filename,WORKING_DIR);

   strcat(filename,nd_file_name.arr);

   strcpy ( OUTPUT_FILE_NAME, filename );

   if ((fp = fopen(filename,"w")) == NULL)
   {
        err_mesg("Error while opening output file",0,"");
        proc_exit();
   }

}

fetch_prog_param()
{
	fm_doc_type_code.arr[0]	= '\0';
	fm_doc_number.arr[0]	= '\0';
	to_doc_type_code.arr[0]	= '\0';
	to_doc_number.arr[0]	= '\0';
	nd_ws_no.arr[0]		= '\0';
	nd_logo_pgm_id.arr[0]	= '\0';

	fm_doc_type_code.len	= 0;
	fm_doc_number.len	= 0;
	to_doc_type_code.len	= 0;
	to_doc_number.len	= 0;
	nd_ws_no.len		= 0;
	nd_logo_pgm_id.len	= 0;

	/* EXEC SQL SELECT PARAM1, PARAM2, PARAM3, PARAM4, NVL(PARAM30,'Y'),
			PARAM29,PARAM28
	INTO	:fm_doc_type_code, :fm_doc_number, :to_doc_type_code,
			:to_doc_number, :nd_online_print_yn,
			:nd_ws_no,
			:nd_logo_pgm_id
	FROM SY_PROG_PARAM
	WHERE PGM_ID = 'BLRCOUPN'
	AND PGM_DATE = :nd_pgm_date
	AND SESSION_ID = :nd_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,NVL(PARAM30,'Y') ,PAR\
AM29 ,PARAM28 into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from SY_PROG_PARAM where ((PGM\
_ID='BLRCOUPN' and PGM_DATE=:b7) and SESSION_ID=:b8)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )156;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&fm_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&fm_doc_number;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&to_doc_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&to_doc_number;
 sqlstm.sqhstl[3] = (unsigned int  )11;
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
 sqlstm.sqhstv[5] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[5] = (unsigned int  )32;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_logo_pgm_id;
 sqlstm.sqhstl[6] = (unsigned int  )1002;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[7] = (unsigned int  )37;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[8] = (unsigned int  )18;
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



	fm_doc_type_code.arr[fm_doc_type_code.len]	= '\0';
	fm_doc_number.arr[fm_doc_number.len]		= '\0';
	to_doc_type_code.arr[to_doc_type_code.len]	= '\0';
	to_doc_number.arr[to_doc_number.len]		= '\0';
	nd_ws_no.arr[nd_ws_no.len] = '\0';
	nd_logo_pgm_id.arr[nd_logo_pgm_id.len]		= '\0';

	if (strlen(to_doc_number.arr) == 0)
		strcpy(to_doc_number.arr,fm_doc_number.arr);

	to_doc_number.len = strlen(to_doc_number.arr);

	disp_message(ERR_MESG," In sy_prog_param");

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
				'BLRCOUPN',
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
  sqlstm.arrsiz = 9;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin BLOPIN . GET_PRINT_SETUP_COL_VALUE ( :nd_facility_id \
, 'BLRCOUPN' , 'PRINT_LOGO_YN_IF_LASER' , :l_logo_yniflaser , :l_errorlevel , \
:l_sysmessageid , :l_errortext ) ; :l_logo_yniflaser := nvl ( :l_logo_yniflase\
r , 'N' ) ; if :l_sysmessageid is not null then :l_errorlevel := '10' ; :l_err\
ortext := blcommon . get_error_text ( :l_sysmessageid ) ; end if ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )207;
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
  sqlstm.sqhstl[1] = (unsigned int  )4;
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
			disp_message(ERR_MESG,l_errortext.arr);
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
					'BLRRECLO',
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
   sqlstm.arrsiz = 9;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin BLOPIN . GET_PRINT_SETUP_COL_VALUE ( :nd_facility_id\
 , 'BLRRECLO' , 'LOGO_NAME' , :l_logo_name , :l_errorlevel , :l_sysmessageid ,\
 :l_errortext ) ; if :l_sysmessageid is not null then :l_errorlevel := '10' ; \
:l_errortext := blcommon . get_error_text ( :l_sysmessageid ) ; end if ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )242;
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
				disp_message(ERR_MESG,l_errortext.arr);
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

			if (nd_online_print_yn == 'N')
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
    sqlstm.arrsiz = 9;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin WORKSTATION . GET_WS_PARAM ( :nd_ws_no , 'BLLOGODIR\
' , :LOGO_DIR , :l_errortext ) ; if :l_errortext is not null then :l_errortext\
 := 'BLLOGODIR:' || :l_errortext ; end if ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )277;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )32;
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
					disp_message(ERR_MESG,l_errortext.arr);
					proc_exit(0);
				}		
			}
		}
	    }
   }


get_printer_type()
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
				 :nd_calling_pgm_id,
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
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
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
_ind := l_document_value ( i ) . value ; end if ; END LOOP ; if l_format_typ\
e = 'DMP_PREPRINTED' then :l_dmp := 1 ; :l_lsr := 0 ; elsif l_format_type in\
 ( 'LASER_WITH_LOGO' , 'LASER_WITHOUT_LOGO' ) then :l_dmp := 0 ; :l_lsr := 1\
 ; else :l_dmp := 0 ; :l_lsr := 0 ; end if ; if :l_dmp = 0 and :l_lsr = 0 th\
en APPPRINT . GET_ROUTING_PRINTERS ( :nd_ws_no , :nd_facility_id , 'BL' , :n\
d_calling_pgm_id , 'O' , ' ' , :l_printe");
 sqlstm.stmt = "r_ids , :l_printer_names , :l_printer_types , :l_queue_names\
 , :l_no_of_copies , :l_errortext ) ; :l_dmp := NVL ( instr ( :l_printer_types\
 , 'D' ) , 0 ) ; :l_lsr := NVL ( instr ( :l_printer_types , 'S' ) , 0 ) ; if :\
l_dmp != 0 and :l_lsr != 0 then :l_dmp := 0 ; end if ; if :l_dmp = 0 and :l_ls\
r = 0 then :l_lsr := 1 ; end if ; end if ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )304;
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
 sqlstm.sqhstv[1] = (         void  *)&nd_calling_pgm_id;
 sqlstm.sqhstl[1] = (unsigned int  )53;
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
 sqlstm.sqhstl[4] = (unsigned int  )32;
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

get_left_margin()
{

	if (l_lsr != 0 && l_dmp == 0)
	  {
		if (l_logo_yniflaser.arr[0] == 'Y')			    
			l_margin_len = 40;				
		else
			l_margin_len = 30;

	  }
}


fetch_currency()
{
	char out_str[10][133];
   char s_amt[20];
   int  length_str[10];
   int  i = 0,no_of_lines = 0;
   char epi_visit[14];

   cur_str.arr[0]   = '\0';
   cur_str.len      =  0;   
   sub_cur_str.arr[0]   = '\0';
   sub_cur_str.len      = 0;

   nd_hosp_name.arr[0] = '\0';
   nd_hosp_name.len = 0;            

   nd_hosp_name1.arr[0] = '\0';
   nd_hosp_name1.len = 0;            

   
   /* exec sql select	base_currency,
					base_currency_dec ,
	lpad(' ',round((46-length(ACC_ENTITY_NAME))/2),' ')||UPPER(ACC_ENTITY_NAME) ,
	lpad(' ',round((:l_margin_len-length(ACC_ENTITY_NAME))/2),' ')||UPPER(ACC_ENTITY_NAME) 
            into	:cur_str,
					:sub_cur_str
					,:nd_hosp_name,:nd_hosp_name1
  	    from sy_acc_entity
	    where acc_entity_id = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select base_currency ,base_currency_dec ,(lpad(' ',round((\
(46-length(ACC_ENTITY_NAME))/2)),' ')||UPPER(ACC_ENTITY_NAME)) ,(lpad(' ',roun\
d(((:b0-length(ACC_ENTITY_NAME))/2)),' ')||UPPER(ACC_ENTITY_NAME)) into :b1,:b\
2,:b3,:b4  from sy_acc_entity where acc_entity_id=:b5";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )363;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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
   sqlstm.sqhstv[3] = (         void  *)&nd_hosp_name;
   sqlstm.sqhstl[3] = (unsigned int  )1002;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_hosp_name1;
   sqlstm.sqhstl[4] = (unsigned int  )1002;
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



   if (sqlca.sqlcode == 1403)
	{ 
		err_mesg("No base currency in table SY_ACC_ENTITY",0,"");
	}

   if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");
	}
   
   cur_str.arr[cur_str.len]  = '\0';
   sub_cur_str.arr[sub_cur_str.len] = '\0';
   nd_hosp_name.arr[nd_hosp_name.len] = '\0';
    nd_hosp_name1.arr[nd_hosp_name1.len] = '\0';
}

decl_coupon_cur()
{
	
	/* EXEC SQL DECLARE COUPON_REC CURSOR FOR
	 SELECT DOC_TYPE_CODE, DOC_NUMBER,DOC_SRNO, EPISODE_TYPE, PATIENT_ID, 
			EPISODE_ID, VISIT_ID, DOC_AMT, TO_CHAR(DOC_DATE,'DD-MON-YYYY'), PRINT_FLAG
	 FROM	BL_RECEIPT_REFUND_HDRDTL_VW
	 WHERE	DOC_TYPE_CODE = :fm_doc_type_code
	 AND	DOC_NUMBER BETWEEN to_number(:fm_doc_number) AND to_number(:to_doc_number)
	 AND	REC_REF_FORMAT_IND = 'C'; */ 


	/*
	if (sqlca.sqlcode < 0)
	{   
		err_mesg("DECLARE CURSOR failed on table BL_RECEIPT_REFUND_DTL",0,"");
	}
	*/

disp_message(ERR_MESG," in declare cursor ");

	/* EXEC SQL OPEN COUPON_REC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0012;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )402;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&fm_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&fm_doc_number;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&to_doc_number;
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


	
	if (sqlca.sqlcode < 0)
	{   
		err_mesg("OPEN CURSOR failed on table BL_RECEIPT_REFUND_DTL",0,"");
	}

}

fetch_coupon_cur()
{
	d_doc_type_code.arr[0]	= '\0';
	d_doc_number.arr[0]		= '\0';
	d_doc_srno.arr[0]		= '\0';
	d_patient_id.arr[0]		= '\0';
	d_episode_id.arr[0]		= '\0';
	d_visit_id.arr[0]		= '\0';
	d_doc_date.arr[0]		= '\0';

	d_doc_type_code.len		= 0;
	d_doc_number.len		= 0;
	d_doc_srno.len			= 0;
	d_patient_id.len		= 0;
	d_episode_id.len		= 0;
	d_visit_id.len			= 0;
	d_doc_date.len			= 0;

	/* EXEC SQL FETCH COUPON_REC INTO	
			:d_doc_type_code,
			:d_doc_number,
			:d_doc_srno,
			:d_episode_type,
			:d_patient_id, 
			:d_episode_id, 
			:d_visit_id,
			:d_doc_amt, 
			:d_doc_date,
			:nd_print_flag; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )429;
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
 sqlstm.sqhstv[2] = (         void  *)&d_doc_srno;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[3] = (unsigned int  )1;
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
 sqlstm.sqhstv[5] = (         void  *)&d_episode_id;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_visit_id;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_doc_amt;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_doc_date;
 sqlstm.sqhstl[8] = (unsigned int  )15;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_print_flag;
 sqlstm.sqhstl[9] = (unsigned int  )1;
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
		err_mesg("FETCH failed on cursor COUPON_REC"," ",0);
	
	d_doc_type_code.arr[d_doc_type_code.len]= '\0';
	d_doc_number.arr[d_doc_number.len]		= '\0';
	d_doc_srno.arr[d_doc_srno.len]			= '\0';
	d_patient_id.arr[d_patient_id.len]		= '\0';
	d_episode_id.arr[d_episode_id.len]		= '\0';
	d_visit_id.arr[d_visit_id.len]			= '\0';
	d_doc_date.arr[d_doc_date.len]			= '\0';

	disp_message(ERR_MESG,d_doc_srno.arr);
	disp_message(ERR_MESG,d_doc_number.arr);
		disp_message(ERR_MESG,"in fetch");

	return(LAST_ROW?0:1);	 
}

print_coupon()
{
	int len1 = 0, i=0;;
	if (l_lsr != 0 && l_dmp == 0)
	{
	   //if (l_lsr != 0 && l_dmp == 0)
	   //{	
		if (l_logo_yniflaser.arr[0] != 'Y')			    
			fprintf(fp,"%c(s8H",ESC);		
		
		prt_space();
		fprintf(fp,"%-50.50s\n",loc_legend13.arr);

		prt_space();
		fprintf(fp,"%-50.50s\n",loc_legend12.arr);

		prt_space();
		fprintf(fp,"%-50.50s\n\n\n\n",nd_hosp_name1.arr);		

		if (l_logo_yniflaser.arr[0] != 'Y')			    
			fprintf(fp,"%c(s12H",ESC);
	   //}      

	   if ( l_logo_yniflaser.arr[0] != 'Y')			    
	   {
	      fprintf(fp,"%c&a28L",ESC); 	/* To Set the Left margin */

	      //fprintf(fp,"%c&d0D",ESC);	/* set Underline mode   */
	      fprintf(fp,"%c(s11H",ESC); 	/* To set the font size	*/
	    }
	      prt_space();
	      fprintf(fp,"%-s",loc_legend10.arr);		     

	     if ( l_logo_yniflaser.arr[0] != 'Y')			    
	     {
	      fprintf(fp,"%c(s12H",ESC); 	/* To set the font size	*/
	      //fprintf(fp,"%c&d@",ESC); 		/* release underline mode */
	     }

	      /*
	      len1 = 19 - loc_legend10.len;

	      if (len1 > 0)
	      {
	         for (i=0;i<len1;i++)
		 {
		     fprintf(fp,"%-s"," ");		     
		 }
	      }            	  
	      fprintf(fp," %-17.17s %-20.20s\n"," ",loc_legend11.arr);		     
	      */	      
	      

	      fprintf(fp," %-s\n",loc_legend11.arr);		     
	}
	if (l_lsr != 0 && l_dmp == 0)
	{
		prt_space();
		fprintf(fp,"%-s\n",loc_legend1.arr);
	}
	else
	{
		fprintf(fp,"   %-s\n",loc_legend1.arr);
	}

	/*if (nd_print_flag == 'Y')
		fprintf(fp,"     %-s\n\n\n\n\n\n\n\n\n",loc_legend9.arr);
	else
		fprintf(fp,"\n\n\n\n\n\n\n\n\n");*/

	//COPY not required and hence commented.

	if (l_lsr != 0 && l_dmp == 0)
	{

		fprintf(fp,"\n\n\n\n\n");
	}
	else
	{
		fprintf(fp,"\n\n\n\n\n\n\n\n\n");
	}

	// Shifted above as per phase-3 ench
	/*
	if (l_lsr != 0 && l_dmp == 0)
	{	
		if (l_logo_yniflaser.arr[0] != 'Y')			    
			fprintf(fp,"%c(s8H",ESC);

		fprintf(fp,"%-80.80s\n",loc_legend13.arr);
		fprintf(fp,"%-80.80s\n",loc_legend12.arr);
		fprintf(fp,"%-80.80s\n\n",nd_hosp_name1.arr);		

		if (l_logo_yniflaser.arr[0] != 'Y')			    
			fprintf(fp,"%c(s12H",ESC);
	}
	*/

	if (l_lsr != 0 && l_dmp == 0)
	{	 
	   if ( l_logo_yniflaser.arr[0] != 'Y')			    
	     fprintf(fp,"%c&a28L",ESC); 	/* To Set the Left margin */
	}	
	
	prt_space();

	disp_message(ERR_MESG,d_doc_srno.arr);
	fprintf(fp,"%15.15s : %-s/%-s/%-s\n",loc_legend2.arr, d_doc_type_code.arr,d_doc_number.arr,d_doc_srno.arr);
	
	prt_space();
	
	fprintf(fp,"%15.15s : %-s\n\n\n",loc_legend3.arr, d_doc_date.arr);

	
	if (l_lsr != 0 && l_dmp == 0)
	{
		prt_space();
		fprintf(fp,"%s %s",loc_legend35.arr,cur_str.arr);
	}
	else
	{
		fprintf(fp,"          ** %s",cur_str.arr);
	}

	print_formated(d_doc_amt);

	if (l_lsr != 0 && l_dmp == 0)
	{
		fprintf(fp,"\n\n\n");
	}
	else
	{
		fprintf(fp,"** \n\n\n");
	}
	
	prt_space();
	fprintf(fp,"%-50.50s\n",loc_legend4.arr);

	prt_space();
	fprintf(fp,"%-50.50s\n",loc_legend5.arr);

	prt_space();
	fprintf(fp,"%-50.50s\n\n\n",loc_legend6.arr);

	if (d_patient_name.arr[0] != '\0')
	{
		prt_space();
		fprintf(fp,"%-s\n",d_patient_name.arr);		
	}
	else
	{
		fprintf(fp,"\n");
	}

	prt_space();
	fprintf(fp,"%15.15s : %-20s\n",loc_legend7.arr, d_patient_id.arr);

	prt_space();
	fprintf(fp,"%15.15s : %-8s",loc_legend8.arr, d_episode_id.arr);

	if (d_episode_type == 'O' || d_episode_type == 'E' ) // EPNH 14/10/2004 
		fprintf(fp,"/%-4s\n",d_visit_id.arr);
	else
		fprintf(fp,"\n");

	if (l_lsr != 0 && l_dmp == 0)
	{
	    if( loc_legend15.arr[0] != '\0' || loc_legend16.arr[0] != '\0' ||
	        loc_legend17.arr[0] != '\0' || loc_legend18.arr[0] != '\0' || 
	        loc_legend19.arr[0] != '\0' || loc_legend20.arr[0] != '\0' ||
	        loc_legend21.arr[0] != '\0' || loc_legend22.arr[0] != '\0' ||
	        loc_legend23.arr[0] != '\0' || loc_legend24.arr[0] != '\0' ||
	        loc_legend25.arr[0] != '\0' || loc_legend26.arr[0] != '\0' ||
	        loc_legend27.arr[0] != '\0' || loc_legend28.arr[0] != '\0' )
	       {
		 
	              /*--------20/09/2005----*/

		      if ( l_logo_yniflaser.arr[0] != 'Y')
		      {
 				fprintf(fp,"%c9",ESC);          /* To Release the margin */		
				fprintf(fp,"%c(s8H",ESC); 	/* To set the font size	  */
				fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 	  */
		      }

				    fprintf(fp,"\n\n\n\n\n\n\n\n\n\n\n\n"); 

			            fprintf(fp,"\n"); 

				    if(loc_legend15.arr[0] != '\0' )
			            fprintf(fp,"%-s\n\n",loc_legend15.arr);    
		     if ( l_logo_yniflaser.arr[0] != 'Y')
		     {
				fprintf(fp,"%c(s12.5H",ESC); 	/* To set the font size	  */
		     }

		      			if(loc_legend16.arr[0] != '\0')
			    		fprintf(fp,"%-s\n",loc_legend16.arr);

					if(loc_legend17.arr[0] != '\0')
		  			fprintf(fp,"%-s\n",loc_legend17.arr);

					if(loc_legend18.arr[0] != '\0' )
					fprintf(fp,"%-s\n",loc_legend18.arr);

					if(loc_legend19.arr[0] != '\0' )
					fprintf(fp,"%-s\n",loc_legend19.arr);

					if(loc_legend20.arr[0] != '\0' )
					fprintf(fp,"%-s\n",loc_legend20.arr);

					if(loc_legend21.arr[0] != '\0' )
					fprintf(fp,"%-s\n",loc_legend21.arr);

					if(loc_legend22.arr[0] != '\0' )
					fprintf(fp,"%-s\n",loc_legend22.arr);
                           
	                                //fprintf(fp,"\n"); 
			  
					if(loc_legend23.arr[0] != '\0' )
                    			fprintf(fp,"%-s\n",loc_legend23.arr);

					if(loc_legend24.arr[0] != '\0' )
					fprintf(fp,"%-s\n",loc_legend24.arr);

					if(loc_legend25.arr[0] != '\0' )
					fprintf(fp,"%-s\n",loc_legend25.arr);

					if(loc_legend26.arr[0] != '\0' )
					fprintf(fp,"%-s\n",loc_legend26.arr);

					if(loc_legend27.arr[0] != '\0' )
					fprintf(fp,"%-s\n",loc_legend27.arr);

					if(loc_legend28.arr[0] != '\0' )
					fprintf(fp,"%-s\n",loc_legend28.arr);
			if ( l_logo_yniflaser.arr[0] != 'Y')
			{			
				fprintf(fp,"%c(s12H",ESC); 	/* To set the font size	  */			
			}

				fprintf(fp,"\n");

              }

            else
	      {
	      		fprintf(fp,"\n\n\n\n\n\n\n\n\n\n");
              }
		 fprintf(fp,"\n");
		 fprintf(fp,"%-s\n",loc_legend14.arr);
		 fprintf(fp,"\n");
  	    }
       
	
	if (nd_print_flag != 'Y')
		update_rec();
	
}

fetch_legend_value()
{
	loc_legend1.arr[0]		= '\0';
	loc_legend2.arr[0]		= '\0';
	loc_legend3.arr[0]		= '\0';
	loc_legend4.arr[0]		= '\0';
	loc_legend5.arr[0]		= '\0';
	loc_legend6.arr[0]		= '\0';
	loc_legend7.arr[0]		= '\0';
	loc_legend8.arr[0]		= '\0';
	loc_legend9.arr[0]		= '\0';
	loc_legend10.arr[0]		= '\0';
	loc_legend11.arr[0]		= '\0';
	loc_legend12.arr[0]		= '\0';
	loc_legend13.arr[0]		= '\0';
	loc_legend14.arr[0]		= '\0';
	                                          /*--------20/09/2005----*/
	loc_legend15.arr[0]		= '\0';
	loc_legend16.arr[0]		= '\0';
	loc_legend17.arr[0]		= '\0';
	loc_legend18.arr[0]		= '\0';
	loc_legend19.arr[0]		= '\0';
	loc_legend20.arr[0]		= '\0';
	loc_legend21.arr[0]		= '\0';
	loc_legend22.arr[0]		= '\0';
	loc_legend23.arr[0]		= '\0';
	loc_legend24.arr[0]		= '\0';
	loc_legend25.arr[0]		= '\0';
	loc_legend26.arr[0]		= '\0';
	loc_legend27.arr[0]		= '\0';
	loc_legend28.arr[0]		= '\0';

	loc_legend35.arr[0]		= '\0';
	loc_legend36.arr[0]		= '\0';

                                                   /*--------up to here----*/
	loc_legend1.len			= 0;
	loc_legend2.len			= 0;
	loc_legend3.len			= 0;
	loc_legend4.len			= 0;
	loc_legend5.len			= 0;
	loc_legend6.len			= 0;
	loc_legend7.len			= 0;
	loc_legend8.len			= 0;
	loc_legend9.len			= 0;
	loc_legend10.len		= 0;
	loc_legend11.len		= 0;
	loc_legend12.len		= 0;
	loc_legend13.len		= 0;
	loc_legend14.len		= 0;
						/*--------20/09/2005----*/
	loc_legend15.len		= 0;
	loc_legend16.len		= 0;
	loc_legend17.len		= 0;
	loc_legend18.len		= 0;
	loc_legend19.len		= 0;
	loc_legend20.len		= 0;
	loc_legend21.len		= 0;
	loc_legend22.len		= 0;
	loc_legend23.len		= 0;
	loc_legend24.len		= 0;
	loc_legend25.len		= 0;
	loc_legend26.len		= 0;
	loc_legend27.len		= 0;
	loc_legend28.len		= 0;

	loc_legend35.len		= 0;
	loc_legend36.len		= 0;

						/*--------up to here----*/

	/* EXEC SQL select rtrim(COLUMN_VALUE)
				into :loc_legend1
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_010' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(COLUMN_VALUE) into :b0  from SM_RECORD_TRANS_DA\
TA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND'\
) and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='CO\
UPON.LEGEND_010') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )484;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend1;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend1
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_010'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_010'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )507;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend1;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 1",0,"");
	}

	loc_legend1.arr[loc_legend1.len]		= '\0';

	strcpy(l_temp_loc_legend.arr,loc_legend1.arr);
	l_temp_loc_legend.len = strlen(l_temp_loc_legend.arr);

	/* EXEC SQL SELECT RTRIM(SUBSTR(fee_act_legend_value,1,30))
	           INTO :loc_legend1
			   FROM bl_fee_act_legends
			  WHERE legend_id = 'COUPON.LEGEND_010'
			    AND  report_id = 'BLRCOUPN'
			    AND :d_doc_amt
			BETWEEN amt_range_fr
			    AND amt_range_to; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select RTRIM(SUBSTR(fee_act_legend_value,1,30)) into :b0  fr\
om bl_fee_act_legends where ((legend_id='COUPON.LEGEND_010' and report_id='BLR\
COUPN') and :b1 between amt_range_fr and amt_range_to)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )526;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend1;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_amt;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
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



	if (sqlca.sqlcode == 1403 )
	{
		loc_legend1.arr[0]		= '\0';
		strcpy(loc_legend1.arr,l_temp_loc_legend.arr);
		loc_legend1.len = strlen(loc_legend1.arr);
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend2
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_020' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='COUPON.LEGEND_020') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )549;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend2;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend2
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_020'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_020'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )572;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend2;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 2",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend3
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_030' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='COUPON.LEGEND_030') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )591;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend3;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend3
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_030'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_030'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )614;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend3;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 3",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend4
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_040' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='COUPON.LEGEND_040') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )633;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend4;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend4
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_040'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_040'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )656;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend4;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 4",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend5
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_050' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='COUPON.LEGEND_050') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )675;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend5;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend5
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_050'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_050'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )698;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend5;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 5",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend6
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_060' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='COUPON.LEGEND_060') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )717;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend6;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend6
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_060'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_060'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )740;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend6;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 6",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend7
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_070' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='COUPON.LEGEND_070') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )759;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend7;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend7
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_070'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_070'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )782;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend7;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 7",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend8
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_080' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='COUPON.LEGEND_080') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )801;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend8;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend8
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_080'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_080'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )824;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend8;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 8",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend9
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_999' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='COUPON.LEGEND_999') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )843;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend9;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend9
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_090'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_090'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )866;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend9;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 9",0,"");
	}


	/* EXEC SQL select rtrim(COLUMN_VALUE)
				into :loc_legend10
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_100' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(COLUMN_VALUE) into :b0  from SM_RECORD_TRANS_DA\
TA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND'\
) and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='CO\
UPON.LEGEND_100') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )885;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend10;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend10
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_100'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_100'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )908;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend10;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 10",0,"");
	}


	/* EXEC SQL select rtrim(COLUMN_VALUE)
				into :loc_legend11
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_110' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(COLUMN_VALUE) into :b0  from SM_RECORD_TRANS_DA\
TA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND'\
) and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='CO\
UPON.LEGEND_110') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )927;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend11;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend11
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_110'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_110'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )950;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend11;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 11",0,"");
	}


	/* EXEC SQL select /ortrim(substr(COLUMN_VALUE,1,50))o/
	lpad(' ',round((:l_margin_len-length(rtrim(substr(COLUMN_VALUE,1,50))))/2),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))	
				into :loc_legend12
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_120' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(COLUMN_VALU\
E,1,50))))/2)),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))) into :b1  from S\
M_RECORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID\
='SM_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) \
and LEGEND_ID='COUPON.LEGEND_120') and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )969;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend12;
 sqlstm.sqhstl[1] = (unsigned int  )203;
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



	if (sqlca.sqlcode == 1403 )
	{
	
		/* EXEC SQL select /odflt_legend_valueo/
			lpad(' ',round((:l_margin_len-length(rtrim(substr(dflt_legend_value,1,50))))/2),' ')||UPPER(rtrim(substr(dflt_legend_value,1,50)))			
			into :loc_legend12
			from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_120'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(dflt_legen\
d_value,1,50))))/2)),' ')||UPPER(rtrim(substr(dflt_legend_value,1,50)))) into \
:b1  from sm_lang_legend where LEGEND_ID='COUPON.LEGEND_120'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )996;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&loc_legend12;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 12",0,"");
	}



	/* EXEC SQL select /ortrim(substr(COLUMN_VALUE,1,50))o/
	lpad(' ',round((:l_margin_len-length(rtrim(substr(COLUMN_VALUE,1,50))))/2),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))	
				into :loc_legend13
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_130' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(COLUMN_VALU\
E,1,50))))/2)),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))) into :b1  from S\
M_RECORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID\
='SM_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) \
and LEGEND_ID='COUPON.LEGEND_130') and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1019;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend13;
 sqlstm.sqhstl[1] = (unsigned int  )203;
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



	if (sqlca.sqlcode == 1403 )
	{
	
		/* EXEC SQL select /odflt_legend_valueo/
				lpad(' ',round((:l_margin_len-length(rtrim(substr(dflt_legend_value,1,50))))/2),' ')||UPPER(rtrim(substr(dflt_legend_value,1,50)))				
				into :loc_legend13
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_130'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(dflt_legen\
d_value,1,50))))/2)),' ')||UPPER(rtrim(substr(dflt_legend_value,1,50)))) into \
:b1  from sm_lang_legend where LEGEND_ID='COUPON.LEGEND_130'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1046;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&loc_legend13;
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


	}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 13",0,"");
	}


	/* EXEC SQL select  /ortrim(substr(COLUMN_VALUE,1,60))o/ COLUMN_VALUE
				into :loc_legend14
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_140' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_140') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1069;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend14;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend14
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_140'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_140'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1092;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend14;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 14",0,"");
	}


 /* EXEC SQL select COLUMN_VALUE
				into :loc_legend15
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_150' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_150') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1111;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend15;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend15
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_150'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_150'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1134;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend15;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 15",0,"");
	}


 /* EXEC SQL select COLUMN_VALUE
				into :loc_legend16
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_160' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_160') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1153;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend16;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend16
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_160'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_160'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1176;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend16;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 16",0,"");
	}


 /* EXEC SQL select COLUMN_VALUE
				into :loc_legend17
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_170' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_170') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1195;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend17;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend17
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_170'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_170'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1218;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend17;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 17",0,"");
	}


 /* EXEC SQL select COLUMN_VALUE
				into :loc_legend18
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_180' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_180') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1237;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend18;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend18
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_180'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_180'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1260;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend18;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 18",0,"");
	}


 /* EXEC SQL select COLUMN_VALUE
				into :loc_legend19
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_190' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_190') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1279;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend19;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend19
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_190'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_190'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1302;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend19;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 19",0,"");
	}




 /* EXEC SQL select COLUMN_VALUE
				into :loc_legend20
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_200' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_200') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1321;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend20;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend20
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_200'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_200'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1344;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend20;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 20",0,"");
	}



 /* EXEC SQL select COLUMN_VALUE
				into :loc_legend21
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_210' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_210') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1363;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend21;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend21
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_210'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_210'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1386;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend21;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 21",0,"");
	}




 /* EXEC SQL select COLUMN_VALUE
				into :loc_legend22
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_220' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_220') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1405;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend22;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend22
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_220'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_220'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1428;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend22;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 22",0,"");
	}





 /* EXEC SQL select COLUMN_VALUE
				into :loc_legend23
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_230' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_230') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1447;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend23;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend23
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_230'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_230'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1470;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend23;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 23",0,"");
	}



 /* EXEC SQL select COLUMN_VALUE
				into :loc_legend24
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_240' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_240') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1489;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend24;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend24
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_240'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_240'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1512;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend24;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 24",0,"");
	}




 /* EXEC SQL select COLUMN_VALUE
				into :loc_legend25
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_250' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_250') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1531;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend25;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend25
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_250'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_250'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1554;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend25;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 25",0,"");
	}



	

 /* EXEC SQL select  COLUMN_VALUE
				into :loc_legend26
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_260' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_260') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1573;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend26;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend26
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_260'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_260'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1596;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend26;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 26",0,"");
	}




 /* EXEC SQL select COLUMN_VALUE
				into :loc_legend27
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_270' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_270') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1615;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend27;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend27
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_270'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_270'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1638;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend27;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 27",0,"");
	}




 /* EXEC SQL select  COLUMN_VALUE
				into :loc_legend28
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_280' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_280') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1657;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend28;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend28
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_280'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_280'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1680;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend28;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 28",0,"");
	}



/* EXEC SQL select  COLUMN_VALUE
				into :loc_legend35
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_350' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 11;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LEG\
END_350') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1699;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend35;
sqlstm.sqhstl[0] = (unsigned int  )203;
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
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend35
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_350'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_350'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1722;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend35;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 35",0,"");
	}


	/* EXEC SQL select  COLUMN_VALUE
				into :loc_legend36
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'COUPON.LEGEND_360' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,s\
m_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and C\
OLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='COUPON.LE\
GEND_360') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1741;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend36;
 sqlstm.sqhstl[0] = (unsigned int  )203;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403 )
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend36
					from sm_lang_legend
					where LEGEND_ID = 'COUPON.LEGEND_360'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='COUPON.LEGEND_360'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1764;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend36;
  sqlstm.sqhstl[0] = (unsigned int  )203;
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

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 36",0,"");
	}




	loc_legend1.arr[loc_legend1.len]		= '\0';
	loc_legend2.arr[loc_legend2.len]		= '\0';
	loc_legend3.arr[loc_legend3.len]		= '\0';
	loc_legend4.arr[loc_legend4.len]		= '\0';
	loc_legend5.arr[loc_legend5.len]		= '\0';
	loc_legend6.arr[loc_legend6.len]		= '\0';
	loc_legend7.arr[loc_legend7.len]		= '\0';
	loc_legend8.arr[loc_legend8.len]		= '\0';
	loc_legend9.arr[loc_legend9.len]		= '\0';
	loc_legend10.arr[loc_legend10.len]		= '\0';
	loc_legend11.arr[loc_legend11.len]		= '\0';
	loc_legend12.arr[loc_legend12.len]		= '\0';
	loc_legend13.arr[loc_legend13.len]		= '\0';
	loc_legend14.arr[loc_legend14.len]		= '\0';
									/*--------20/09/2005----*/
	loc_legend15.arr[loc_legend15.len]		= '\0';
	loc_legend16.arr[loc_legend16.len]		= '\0';
	loc_legend17.arr[loc_legend17.len]		= '\0';
	loc_legend18.arr[loc_legend18.len]		= '\0';
	loc_legend19.arr[loc_legend19.len]		= '\0';
	loc_legend20.arr[loc_legend20.len]		= '\0';
	loc_legend21.arr[loc_legend21.len]		= '\0';
	loc_legend22.arr[loc_legend22.len]		= '\0';
	loc_legend23.arr[loc_legend23.len]		= '\0';
	loc_legend24.arr[loc_legend24.len]		= '\0';
	loc_legend25.arr[loc_legend25.len]		= '\0';
	loc_legend26.arr[loc_legend26.len]		= '\0';
	loc_legend27.arr[loc_legend27.len]		= '\0';
	loc_legend28.arr[loc_legend28.len]		= '\0';

	loc_legend35.arr[loc_legend35.len]		= '\0';
	loc_legend36.arr[loc_legend36.len]		= '\0';
								/*--------20/09/2005----*/
}

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
		strcat(s_amt,"-");
        sprintf(str_amt,"%-s",s_amt);
        fprintf(fp,"%-s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%-s",s_amt);
        fprintf(fp,"%-s ",str_amt);
    }
}

update_rec()
{
    /* EXEC SQL UPDATE BL_RECEIPT_REFUND_HDR
             SET PRINT_FLAG = 'Y'
             WHERE DOC_TYPE_CODE = :d_doc_type_code
			 AND DOC_NUMBER	= :d_doc_number; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 11;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_RECEIPT_REFUND_HDR  set PRINT_FLAG='Y' where (D\
OC_TYPE_CODE=:b0 and DOC_NUMBER=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1783;
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
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
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
         err_mesg("UPDATE failed on table BL_RECEIPT_REFUND_HDR",0,"");
	}
}
prt_space()
{
	if (l_lsr != 0 && l_dmp == 0 && l_logo_yniflaser.arr[0] == 'Y')
	{
		fprintf(fp,"                      ");
	}
}



