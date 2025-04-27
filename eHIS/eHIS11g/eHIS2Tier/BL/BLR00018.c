
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00018.pc"
};


static unsigned int sqlctx = 1288460907;


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
            void  *sqhstv[16];
   unsigned int   sqhstl[16];
            int   sqhsts[16];
            void  *sqindv[16];
            int   sqinds[16];
   unsigned int   sqharm[16];
   unsigned int   *sqharc[16];
   unsigned short  sqadto[16];
   unsigned short  sqtdso[16];
} sqlstm = {12,16};

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

 static const char *sq0074 = 
"nd f.BLNG_GRP_ID between NVL(:b6,'!!!!') and NVL(:b7,'~~~~')) and c.cur_bed_\
class_code between NVL(:b8,'!!!!') and NVL(:b9,'~~~~'))           ";

 static const char *sq0077 = 
"select TO_CHAR(ROWNUM) ,((doc_type_code||'/')||doc_number) ,TO_CHAR(doc_date\
,'DD/MM/YYYY') ,doc_amt  from bl_receipt_refund_dtl_VW where ((((operating_fac\
ility_id=:b0 and episode_id=:b1) and patient_id=:b2) and recpt_nature_code in \
('AD','PR')) and NVL(cancelled_ind,'N')<>'Y')           ";

 static const char *sq0078 = 
"select prt_grp_hdr_code ,prt_grp_line_code ,sum(upd_net_charge_amt)  from bl\
_patient_charges_folio where ((((operating_facility_id=:b0 and episode_id=:b1)\
 and patient_id=:b2) and trx_status is null ) and bill_doc_type_code is null )\
 group by prt_grp_hdr_code,prt_grp_line_code           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,124,0,4,223,0,0,4,2,0,1,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,
36,0,0,2,0,0,30,347,0,0,0,0,0,1,0,
51,0,0,3,269,0,4,388,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
74,0,0,4,92,0,4,401,0,0,1,0,0,1,0,2,9,0,0,
93,0,0,5,269,0,4,412,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
116,0,0,6,92,0,4,425,0,0,1,0,0,1,0,2,9,0,0,
135,0,0,7,269,0,4,437,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
158,0,0,8,92,0,4,450,0,0,1,0,0,1,0,2,9,0,0,
177,0,0,9,269,0,4,461,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
200,0,0,10,92,0,4,474,0,0,1,0,0,1,0,2,9,0,0,
219,0,0,11,269,0,4,485,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
242,0,0,12,92,0,4,498,0,0,1,0,0,1,0,2,9,0,0,
261,0,0,13,269,0,4,509,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
284,0,0,14,92,0,4,522,0,0,1,0,0,1,0,2,9,0,0,
303,0,0,15,269,0,4,533,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
326,0,0,16,92,0,4,546,0,0,1,0,0,1,0,2,9,0,0,
345,0,0,17,271,0,4,558,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
368,0,0,18,94,0,4,573,0,0,1,0,0,1,0,2,9,0,0,
387,0,0,19,269,0,4,586,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
410,0,0,20,92,0,4,599,0,0,1,0,0,1,0,2,9,0,0,
429,0,0,21,269,0,4,610,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
452,0,0,22,92,0,4,623,0,0,1,0,0,1,0,2,9,0,0,
471,0,0,23,269,0,4,634,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
494,0,0,24,92,0,4,647,0,0,1,0,0,1,0,2,9,0,0,
513,0,0,25,269,0,4,659,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
536,0,0,26,92,0,4,672,0,0,1,0,0,1,0,2,9,0,0,
555,0,0,27,269,0,4,683,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
578,0,0,28,92,0,4,696,0,0,1,0,0,1,0,2,9,0,0,
597,0,0,29,269,0,4,708,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
620,0,0,30,92,0,4,721,0,0,1,0,0,1,0,2,9,0,0,
639,0,0,31,269,0,4,732,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
662,0,0,32,91,0,4,745,0,0,1,0,0,1,0,2,9,0,0,
681,0,0,33,268,0,4,756,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
704,0,0,34,91,0,4,768,0,0,1,0,0,1,0,2,9,0,0,
723,0,0,35,269,0,4,778,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
746,0,0,36,92,0,4,791,0,0,1,0,0,1,0,2,9,0,0,
765,0,0,37,269,0,4,802,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
788,0,0,38,92,0,4,815,0,0,1,0,0,1,0,2,9,0,0,
807,0,0,39,269,0,4,826,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
830,0,0,40,92,0,4,839,0,0,1,0,0,1,0,2,9,0,0,
849,0,0,41,269,0,4,850,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
872,0,0,42,92,0,4,863,0,0,1,0,0,1,0,2,9,0,0,
891,0,0,43,269,0,4,875,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
914,0,0,44,92,0,4,888,0,0,1,0,0,1,0,2,9,0,0,
933,0,0,45,269,0,4,899,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
956,0,0,46,92,0,4,912,0,0,1,0,0,1,0,2,9,0,0,
975,0,0,47,269,0,4,923,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
998,0,0,48,92,0,4,936,0,0,1,0,0,1,0,2,9,0,0,
1017,0,0,49,269,0,4,947,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1040,0,0,50,92,0,4,960,0,0,1,0,0,1,0,2,9,0,0,
1059,0,0,51,269,0,4,971,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1082,0,0,52,92,0,4,984,0,0,1,0,0,1,0,2,9,0,0,
1101,0,0,53,269,0,4,996,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1124,0,0,54,92,0,4,1009,0,0,1,0,0,1,0,2,9,0,0,
1143,0,0,55,269,0,4,1020,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1166,0,0,56,92,0,4,1033,0,0,1,0,0,1,0,2,9,0,0,
1185,0,0,57,269,0,4,1044,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1208,0,0,58,92,0,4,1057,0,0,1,0,0,1,0,2,9,0,0,
1227,0,0,59,269,0,4,1068,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1250,0,0,60,92,0,4,1081,0,0,1,0,0,1,0,2,9,0,0,
1269,0,0,61,269,0,4,1092,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1292,0,0,62,92,0,4,1105,0,0,1,0,0,1,0,2,9,0,0,
1311,0,0,63,269,0,4,1116,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1334,0,0,64,92,0,4,1129,0,0,1,0,0,1,0,2,9,0,0,
1353,0,0,65,269,0,4,1140,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1376,0,0,66,92,0,4,1153,0,0,1,0,0,1,0,2,9,0,0,
1395,0,0,67,269,0,4,1164,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1418,0,0,68,92,0,4,1176,0,0,1,0,0,1,0,2,9,0,0,
1437,0,0,69,269,0,4,1188,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1460,0,0,70,92,0,4,1200,0,0,1,0,0,1,0,2,9,0,0,
1479,0,0,0,0,0,27,1251,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
1510,0,0,72,223,0,4,1269,0,0,11,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1569,0,0,73,91,0,2,1314,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1592,0,0,74,1166,0,9,1383,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1647,0,0,74,0,0,13,1396,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1674,0,0,75,144,0,4,1420,0,0,2,1,0,1,0,2,3,0,0,1,9,0,0,
1697,0,0,76,219,0,4,1526,0,0,8,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,
1744,0,0,77,288,0,9,1678,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1771,0,0,77,0,0,13,1692,0,0,4,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,
1802,0,0,78,287,0,9,1734,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1829,0,0,78,0,0,13,1748,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,
1856,0,0,79,187,0,4,1764,0,0,4,3,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1887,0,0,74,0,0,15,1781,0,0,0,0,0,1,0,
1902,0,0,77,0,0,15,1789,0,0,0,0,0,1,0,
1917,0,0,78,0,0,15,1794,0,0,0,0,0,1,0,
1932,0,0,80,221,0,4,1832,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1,9,0,0,1,9,0,0,
1975,0,0,81,681,0,4,1862,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
2026,0,0,82,374,0,6,1909,0,0,16,16,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,
2105,0,0,83,72,0,6,1955,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
2128,0,0,84,223,0,6,1971,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,
2179,0,0,85,283,0,6,2006,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,2,4,0,0,2,4,0,0,2,9,0,0,
2238,0,0,86,129,0,6,2132,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2265,0,0,87,96,0,4,2187,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
2288,0,0,88,162,0,6,2194,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* PROGRAM NAME          : BLR00018.PC                                  */
/* AUTHOR                : HARISH A                                     */
/* DATE WRITTEN          : 22/11/2003                                   */
/************************************************************************/
                                             
#include <string.h>
#include <math.h>
#include <stdio.h>
#include <bl.h>
  
#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define MAX_LINES 80
#define INIT_MESG       "Top Up Deposit Letter Printing in progress"
#define ESC     0x1B
/*
#define ONLINE_PRINTING 1
#define DEBUG 1
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR	uid_pwd				[132],
			hosp_name			[120],
			l_pk_value          [100],
			l_len_value	        [3],
			date_time			[20],
			l_translated_value	    [201],
			user_id				[20],
			nd_pgm_date			[35],
			nd_facility_name	[31],
			nd_session_id		[16],
			nd_calling_pgm_id	[20],
			nd_facility_id		[3],
			nd_temp_date								[21],
		    date_convert								[21],
			nd_loc_date									[21]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[3]; } l_len_value;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_calling_pgm_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;

		

	/* VARCHAR	nd_file_name [50],
			nd_lang_id	[4],
			loc_legend1	[201],
			loc_legend2	[201],
			loc_legend3	[201],
			loc_legend4	[201],
			loc_legend5	[201],
			loc_legend6	[201],
			loc_legend7	[201],
			loc_legend7_1	[201],
			loc_legend8	[201],
			loc_legend9	[201],
			loc_legend10[201],
			loc_legend11[201],
			loc_legend12[201],
			loc_legend13[201],
			loc_legend14[201],
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
			loc_legend29[201],
			loc_legend30[201],
			loc_legend31[201],
			loc_legend32[201],
			loc_legend33[201]; */ 
struct { unsigned short len; unsigned char arr[50]; } nd_file_name;

struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[201]; } loc_legend1;

struct { unsigned short len; unsigned char arr[201]; } loc_legend2;

struct { unsigned short len; unsigned char arr[201]; } loc_legend3;

struct { unsigned short len; unsigned char arr[201]; } loc_legend4;

struct { unsigned short len; unsigned char arr[201]; } loc_legend5;

struct { unsigned short len; unsigned char arr[201]; } loc_legend6;

struct { unsigned short len; unsigned char arr[201]; } loc_legend7;

struct { unsigned short len; unsigned char arr[201]; } loc_legend7_1;

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

struct { unsigned short len; unsigned char arr[201]; } loc_legend29;

struct { unsigned short len; unsigned char arr[201]; } loc_legend30;

struct { unsigned short len; unsigned char arr[201]; } loc_legend31;

struct { unsigned short len; unsigned char arr[201]; } loc_legend32;

struct { unsigned short len; unsigned char arr[201]; } loc_legend33;


	/* VARCHAR l_fr_ward_code			[6],
			l_to_ward_code			[6],
			l_fr_episode_id			[15],
			l_to_episode_id			[15],
			l_episode_id			[12],
			l_patient_id			[22],
			l_short_name			[65],
			l_address_line1			[33],
			l_address_line2			[33],
			l_address_line3			[33],
			l_tel_number			[33],
			l_sysdate			[20],
			l_hospital_name			[50],
			l_doc_type_code			[16],
			l_doc_date			[15],
			l_short_desc			[17],
			l_prt_grp_hdr_code		[5],
			l_prt_grp_line_code		[5],
			l_encounter_id			[15],
			l_blng_grp_id			[15],
			l_cust_code			[15],
			l_non_ins_blng_grp_id		[15],
			l_non_ins_cust_code		[15],
			l_settlement_ind		[15],
			l_cur_ward_code			[15],
			l_cur_bed_num			[15],
			l_cur_physician_id		[15],
			l_admission_type_code		[15],
			l_cur_bed_class_code		[15],
			l_to_bed_type_code		[15],
			l_to_nursing_unit		[15],
			l_nursing_unit_type		[25],
			l_blng_class			[25],
			l_dummy					[25],
			l_bill_type			[25],
			l_SERVICE_PANEL_IND  [25],
			l_blng_serv			[25],
			l_deposit_reqd_yn		[25],
			l_addl_dep_reqd_yn		[25],
			l_dept_code			[25],
			l_sys_message_id		[25],
			l_reln_code			[25],
			l_dep_defined			[10],
			l_message_text			[500],
			l_row_num			[11],
			v_error_text			[500],
			l_fr_blng_grp           [5],
			l_to_blng_grp           [5],
			l_fr_bed_class      [5],
			l_to_bed_class      [5]; */ 
struct { unsigned short len; unsigned char arr[6]; } l_fr_ward_code;

struct { unsigned short len; unsigned char arr[6]; } l_to_ward_code;

struct { unsigned short len; unsigned char arr[15]; } l_fr_episode_id;

struct { unsigned short len; unsigned char arr[15]; } l_to_episode_id;

struct { unsigned short len; unsigned char arr[12]; } l_episode_id;

struct { unsigned short len; unsigned char arr[22]; } l_patient_id;

struct { unsigned short len; unsigned char arr[65]; } l_short_name;

struct { unsigned short len; unsigned char arr[33]; } l_address_line1;

struct { unsigned short len; unsigned char arr[33]; } l_address_line2;

struct { unsigned short len; unsigned char arr[33]; } l_address_line3;

struct { unsigned short len; unsigned char arr[33]; } l_tel_number;

struct { unsigned short len; unsigned char arr[20]; } l_sysdate;

struct { unsigned short len; unsigned char arr[50]; } l_hospital_name;

struct { unsigned short len; unsigned char arr[16]; } l_doc_type_code;

struct { unsigned short len; unsigned char arr[15]; } l_doc_date;

struct { unsigned short len; unsigned char arr[17]; } l_short_desc;

struct { unsigned short len; unsigned char arr[5]; } l_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[5]; } l_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[15]; } l_encounter_id;

struct { unsigned short len; unsigned char arr[15]; } l_blng_grp_id;

struct { unsigned short len; unsigned char arr[15]; } l_cust_code;

struct { unsigned short len; unsigned char arr[15]; } l_non_ins_blng_grp_id;

struct { unsigned short len; unsigned char arr[15]; } l_non_ins_cust_code;

struct { unsigned short len; unsigned char arr[15]; } l_settlement_ind;

struct { unsigned short len; unsigned char arr[15]; } l_cur_ward_code;

struct { unsigned short len; unsigned char arr[15]; } l_cur_bed_num;

struct { unsigned short len; unsigned char arr[15]; } l_cur_physician_id;

struct { unsigned short len; unsigned char arr[15]; } l_admission_type_code;

struct { unsigned short len; unsigned char arr[15]; } l_cur_bed_class_code;

struct { unsigned short len; unsigned char arr[15]; } l_to_bed_type_code;

struct { unsigned short len; unsigned char arr[15]; } l_to_nursing_unit;

struct { unsigned short len; unsigned char arr[25]; } l_nursing_unit_type;

struct { unsigned short len; unsigned char arr[25]; } l_blng_class;

struct { unsigned short len; unsigned char arr[25]; } l_dummy;

struct { unsigned short len; unsigned char arr[25]; } l_bill_type;

struct { unsigned short len; unsigned char arr[25]; } l_SERVICE_PANEL_IND;

struct { unsigned short len; unsigned char arr[25]; } l_blng_serv;

struct { unsigned short len; unsigned char arr[25]; } l_deposit_reqd_yn;

struct { unsigned short len; unsigned char arr[25]; } l_addl_dep_reqd_yn;

struct { unsigned short len; unsigned char arr[25]; } l_dept_code;

struct { unsigned short len; unsigned char arr[25]; } l_sys_message_id;

struct { unsigned short len; unsigned char arr[25]; } l_reln_code;

struct { unsigned short len; unsigned char arr[10]; } l_dep_defined;

struct { unsigned short len; unsigned char arr[500]; } l_message_text;

struct { unsigned short len; unsigned char arr[11]; } l_row_num;

struct { unsigned short len; unsigned char arr[500]; } v_error_text;

struct { unsigned short len; unsigned char arr[5]; } l_fr_blng_grp;

struct { unsigned short len; unsigned char arr[5]; } l_to_blng_grp;

struct { unsigned short len; unsigned char arr[5]; } l_fr_bed_class;

struct { unsigned short len; unsigned char arr[5]; } l_to_bed_class;



	char	l_sql_stmt[3000];
	char    nd_lang_ind;
	char    l_temp_line2[300],	loc_legend[999][201];
	char	l_mesg[300];

	double	d_doc_amt_num, 
			nd_dep_amt,
			l_doc_amt=0,
			l_total_deposit_amount=0,
			l_total_folio = 0,
			l_next_deposit = 0,
			l_total_amount_to_pay = 0,
		  	l_upd_net_charge_amt=0,
			l_outstanding_amount=0,
			l_dep_amt = 0,
			l_dly_charge = 0,
			l_tot_dep_amt = 0;
 		

	int     l_line_no = 0,v_no_of_decimal,e_exist_or_not,
			l_temp_line_no = 0;
	int		l_page_no = 0;
	int		nd_no_of_decimal;
	int		i,j;

	long    l_bill_doc_number;

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
int		lctr = 0,
		pctr =0;

char filename[150];

void proc_main(argc,argv)
char *argv[];
int argc;
{
	char lv_msg[1024];

	if (argc != 6) 
	{
        disp_message (ERR_MESG,"Usage : BLR00018 username/pwd@connect_string session_id pgm_date facility_id calling_pgm_id [filename]\n");
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

	if(sql_connect() == -1)
	{
		disp_message(ERR_MESG,"Error in connecting to Oracle\n");
		if (uid_pwd.len == 0)
			disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
		proc_exit();
	}

	set_meduser_role();
  	
		strcpy(nd_lang_id.arr,l_language_id.arr);
		nd_lang_id.len = strlen(nd_lang_id.arr);
		nd_lang_id.arr[nd_lang_id.len]='\0';
	get_sy_prog_param();


	/* EXEC SQL SELECT acc_entity_name,
					no_of_decimal
			   INTO :nd_facility_name,
					:nd_no_of_decimal
 			   FROM sy_acc_entity_lang_vw
			  WHERE acc_entity_id = :nd_facility_id
			  and language_id= :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select acc_entity_name ,no_of_decimal into :b0,:b1  from sy_\
acc_entity_lang_vw where (acc_entity_id=:b2 and language_id=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_name;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_no_of_decimal;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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




	if (OERROR)
         err_mesg("SELECT failed on cursor SY_ACC_ENTITY",0,"");

    nd_facility_name.arr[nd_facility_name.len] = '\0';

    open_files(); 

	declare_top_up_deposit();


/*
	nd_lang_id.arr[0] = '\0';
	nd_lang_id.len = 0;

	EXEC SQL EXECUTE
	BEGIN
		blcommon.get_language_ind_id(:nd_facility_id,
									:l_patient_id,
									:nd_lang_ind,
									:nd_lang_id);
	END;
	END-EXEC;
 
	nd_lang_id.arr[strlen(nd_lang_id.arr)] = '\0';
	
*/
	fetch_legend_value();	

	declare_top_up_deposit();
    
	j=0;
    
	print_page_title();
    fetch_legend_value1();
	fprintf(fp,"\n\n\n\n\n\n\n\n");
	fprintf(fp,"\t%17s\n",loc_legend[34]);
    fprintf(fp,"\t---------------------\n\n");
     
     if(l_fr_blng_grp.arr[0]== '\0')
	   	fprintf(fp,"\t\t %20s  %10s : %-10.10s \n",loc_legend[35],loc_legend[39],loc_legend[41]);
	else
		fprintf(fp,"\t\t %20s  %10s : %s\n",loc_legend[35],loc_legend[39],l_fr_blng_grp.arr);  
 
    if(l_to_blng_grp.arr[0] == '\0')
	   	fprintf(fp,"\t\t %20s  %10s : %-10.10s \n","",loc_legend[40],loc_legend[42]);
	else
		fprintf(fp,"\t\t %20s  %10s : %s\n","",loc_legend[40],l_to_blng_grp.arr);  
   
    if(l_fr_ward_code.arr[0] == '\0')
	   	fprintf(fp,"\t\t %20s  %10s : %-10.10s \n",loc_legend[36],loc_legend[39],loc_legend[41]);
	else
		fprintf(fp,"\t\t %20s  %10s : %s\n",loc_legend[36],loc_legend[39],l_fr_ward_code.arr);  
 
    if(l_to_ward_code.arr[0] =='\0')
	   	fprintf(fp,"\t\t %20s  %10s : %-10.10s \n","",loc_legend[40],loc_legend[42]);
	else
		fprintf(fp,"\t\t %20s  %10s : %s\n","",loc_legend[40],l_to_ward_code.arr);  
	  
    if(l_fr_bed_class.arr[0] == '\0')
	   	fprintf(fp,"\t\t %20s  %10s : %-10.10s \n",loc_legend[37],loc_legend[39],loc_legend[41]);
	else
		fprintf(fp,"\t\t %20s  %10s : %s\n",loc_legend[37],loc_legend[39],l_fr_bed_class.arr);  
 
    if(l_to_bed_class.arr[0] == '\0')
	   	fprintf(fp,"\t\t %20s  %10s : %-10.10s \n","",loc_legend[40],loc_legend[42]);
	else
		fprintf(fp,"\t\t %20s  %10s : %s\n","",loc_legend[40],l_to_bed_class.arr);  

    if(l_fr_episode_id.arr[0] == '\0')
	   	fprintf(fp,"\t\t %20s  %10s : %-10.10s \n",loc_legend[38],loc_legend[39],loc_legend[41]);
	else
		fprintf(fp,"\t\t %20s  %10s : %s\n",loc_legend[38],loc_legend[39],l_fr_episode_id.arr);  
 
    if(l_to_episode_id.arr[0] == '\0')
	   	fprintf(fp,"\t\t %20s  %10s : %-10.10s \n","",loc_legend[40],loc_legend[42]);
	else
		fprintf(fp,"\t\t %20s  %10s : %s\n","",loc_legend[40],l_to_episode_id.arr);  
	  	
	 delete_sy_prog(); 	
  fprintf(fp,"");


	while(fetch_top_up_deposit())
	{
	   
	    
		print_page_title();
		print_hospital_address();
	   
		print_letter_body();
		print_letter_deposit_detail();
		print_letter_total();
		print_letter_footer();
	}

	close_top_up_deposit();


	fprintf(fp,"%cE",ESC); /* To Reset the Printer */
    fclose(fp);

	/*PrintDocument(	uid_pwd.arr,		//char	*PUidPwd;
					nd_session_id.arr,	//char	*PSessionID;
					nd_facility_id.arr,	//char	*PFacilityID;
					"BL",				//char	*PModuleID;
					"BLR00018",			//char	*PDocumentID;
					filename,			//char	*POnlinePrintFileNames;
					"O",				//char	*PLocationTypes;
					" ",				//char	*PLocationCodes;
					1,					//int		PNumOfCopies;
					1,					//int		PPageFrom;
					999					//int		PPageTo;
				);*/


	/* EXEC SQL COMMIT WORK RELEASE; */ 

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


	return;
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
	loc_legend7_1.arr[0]		= '\0';
	loc_legend8.arr[0]		= '\0';
	loc_legend9.arr[0]		= '\0';
	loc_legend10.arr[0]		= '\0';
	loc_legend11.arr[0]		= '\0';
	loc_legend12.arr[0]		= '\0';
	loc_legend13.arr[0]		= '\0';
	loc_legend14.arr[0]		= '\0';
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
	loc_legend29.arr[0]		= '\0';
	loc_legend30.arr[0]		= '\0';
	loc_legend31.arr[0]		= '\0';
	loc_legend32.arr[0]		= '\0';
	loc_legend33.arr[0]		= '\0';

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend1
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_001' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_001') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend1
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_001'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_001'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )74;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend2
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_002' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_002') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )93;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend2
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_002'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_002'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )116;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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


	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend3
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_003' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_003') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )135;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend3
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_003'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_003'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )158;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend4
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_004' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_004') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )177;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend4
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_004'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_004'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )200;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend5
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_005' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_005') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )219;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend5
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_005'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_005'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )242;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend6
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_006' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_006') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )261;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend6
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_006'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_006'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )284;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend7
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_007' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_007') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )303;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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

	

	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend7
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_007'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_007'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )326;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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


/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend7_1
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_007.1' 
				AND language_id = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 4;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_rec\
ord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM_\
LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and l\
egend_id='BLR00018.LEGEND_007.1') and language_id=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )345;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend7_1;
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



	

	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend7_1
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_007.1'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_007.1'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )368;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend7_1;
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
		err_mesg("SELECT failed on LEGEND 7.1",0,"");
	}



	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend8
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_008' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_008') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )387;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend8
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_008'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_008'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )410;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend9
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_009' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_009') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )429;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend9
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_009'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_009'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )452;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend10
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_010' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_010') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )471;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend10
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_010'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_010'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )494;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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


	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend11
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_011' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_011') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )513;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend11
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_011'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_011'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )536;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend12
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_012' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_012') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )555;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend12;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend12
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_012'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_012'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )578;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend12;
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
		err_mesg("SELECT failed on LEGEND 12",0,"");
	}


	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend13
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_013' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_013') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )597;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend13;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend13
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_013'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_013'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )620;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend13;
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
		err_mesg("SELECT failed on LEGEND 13",0,"");
	}

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend14
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_014' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_014') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )639;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend14
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_14'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_14'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )662;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL select rtrim(substr(column_value,1,80))
				into :loc_legend15
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_015' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_015') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )681;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if (sqlca.sqlcode == 1403)
	{
		/* EXEC SQL select dflt_legend_value into :loc_legend15
					from sm_lang_legend
					where LEGEND_ID = 'RECEIPT.LEGEND_015'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e LEGEND_ID='RECEIPT.LEGEND_015'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )704;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend16
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_016' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_016') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )723;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend16
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_016'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_016'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )746;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend17
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_017' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_017') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )765;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend17
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_017'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_017'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )788;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend18
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_018' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_018') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )807;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend18
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_018'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_018'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )830;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend19
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_019' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_019') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )849;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend19
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_019'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_019'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )872;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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


	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend20
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_020' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_020') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )891;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend20
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_020'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_020'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )914;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
		err_mesg("SELECT failed on LEGEND 020",0,"");
	}

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend21
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_021' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_021') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )933;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend21
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_021'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_021'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )956;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend22
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_022' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_022') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )975;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend22
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_022'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_022'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )998;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend23
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_023' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_023') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1017;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend23
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_023'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_023'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1040;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend24
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_024' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_024') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1059;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend24
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_024'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_024'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1082;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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


	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend25
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_025' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_025') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1101;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend25
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_025'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_025'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1124;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend26
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_026' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_026') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1143;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend26
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_026'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_026'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1166;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend27
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_027' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_027') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1185;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend26
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_027'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_027'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1208;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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
		err_mesg("SELECT failed on LEGEND 27",0,"");
	}

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend28
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_028' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_028') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1227;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend28
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_028'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_028'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1250;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
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

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend29
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_029' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_029') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1269;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend29;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend29
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_029'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_029'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1292;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend29;
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
		err_mesg("SELECT failed on LEGEND 29",0,"");
	}

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend30
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_030' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_030') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1311;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend30;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend30
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_030'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_030'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1334;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend30;
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
		err_mesg("SELECT failed on LEGEND 30",0,"");
	}	
	
	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend31
		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_031' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_031') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1353;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend31;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend31
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_031'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_031'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1376;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend31;
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
		err_mesg("SELECT failed on LEGEND 31",0,"");
	}

	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend32		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_032' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_032') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1395;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend32;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend32
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_032'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_032'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1418;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend32;
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
		err_mesg("SELECT failed on LEGEND 32",0,"");
	}


	/* EXEC SQL SELECT rtrim(substr(column_value,1,80))
			   INTO :loc_legend33		       FROM sm_record_trans_data a,
                    sm_lang_legend b
		      WHERE module_id   = 'SM' 
				AND	table_id    = 'SM_LANG_LEGEND'
				AND column_id   = 'DFLT_LEGEND_VALUE'
				AND pk_value    = legend_id
				AND legend_id   = 'BLR00018.LEGEND_033' 
				AND language_id = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(column_value,1,80)) into :b0  from sm_re\
cord_trans_data a ,sm_lang_legend b where (((((module_id='SM' and table_id='SM\
_LANG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and \
legend_id='BLR00018.LEGEND_033') and language_id=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1437;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend33;
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



	if(sqlca.sqlcode == 1403)
	{
		/* EXEC SQL SELECT dflt_legend_value 
                   INTO :loc_legend33
  			       FROM sm_lang_legend
			      WHERE legend_id = 'BLR00018.LEGEND_032'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend wher\
e legend_id='BLR00018.LEGEND_032'";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1460;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend33;
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
		err_mesg("SELECT failed on LEGEND 33",0,"");
	}



	loc_legend1.arr[loc_legend1.len]		= '\0';
	loc_legend2.arr[loc_legend2.len]		= '\0';
	loc_legend3.arr[loc_legend3.len]		= '\0';
	loc_legend4.arr[loc_legend4.len]		= '\0';
	loc_legend5.arr[loc_legend5.len]		= '\0';
	loc_legend6.arr[loc_legend6.len]		= '\0';
	loc_legend7.arr[loc_legend7.len]		= '\0';
	loc_legend7_1.arr[loc_legend7_1.len]		= '\0';
	loc_legend8.arr[loc_legend8.len]		= '\0';
	loc_legend9.arr[loc_legend9.len]		= '\0';
	loc_legend10.arr[loc_legend10.len]		= '\0';
	loc_legend11.arr[loc_legend11.len]		= '\0';
	loc_legend12.arr[loc_legend12.len]		= '\0';
	loc_legend13.arr[loc_legend13.len]		= '\0';
	loc_legend14.arr[loc_legend14.len]		= '\0';
	loc_legend15.arr[loc_legend15.len]		= '\0';
	loc_legend16.arr[loc_legend16.len]		= '\0';
	loc_legend17.arr[loc_legend17.len]		= '\0';
	loc_legend18.arr[loc_legend28.len]		= '\0';
	loc_legend19.arr[loc_legend29.len]		= '\0';
	loc_legend20.arr[loc_legend20.len]		= '\0';
	loc_legend21.arr[loc_legend21.len]		= '\0';
	loc_legend22.arr[loc_legend22.len]		= '\0';
	loc_legend23.arr[loc_legend23.len]		= '\0';
	loc_legend24.arr[loc_legend24.len]		= '\0';
	loc_legend25.arr[loc_legend25.len]		= '\0';
	loc_legend26.arr[loc_legend26.len]		= '\0';
	loc_legend27.arr[loc_legend27.len]		= '\0';
	loc_legend28.arr[loc_legend28.len]		= '\0';
	loc_legend29.arr[loc_legend29.len]		= '\0';
	loc_legend30.arr[loc_legend30.len]		= '\0';
	loc_legend31.arr[loc_legend31.len]		= '\0';
	loc_legend32.arr[loc_legend32.len]		= '\0';
	loc_legend33.arr[loc_legend33.len]		= '\0';
}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )1479;
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

get_sy_prog_param()
{
	l_fr_ward_code.arr[0]   = '\0';
	l_to_ward_code.arr[0]	= '\0';
	l_fr_episode_id.arr[0]	= '\0';
	l_to_episode_id.arr[0]	= '\0';
	l_fr_blng_grp.arr[0]    = '\0';
	l_to_blng_grp.arr[0]	= '\0';
	l_fr_bed_class.arr[0]	= '\0';
	l_to_bed_class.arr[0]	= '\0';

	/* EXEC SQL SELECT param1, 
					param2, 
					param3, 
					param4,
					param5,
					param6,
					param7,
					param8
			   INTO	:l_fr_ward_code,
					:l_to_ward_code,
					:l_fr_episode_id,
					:l_to_episode_id,
					:l_fr_blng_grp,
					:l_to_blng_grp,
					:l_fr_bed_class,
					:l_to_bed_class
			   FROM sy_prog_param
			  WHERE operating_facility_id = :nd_facility_id
			    AND pgm_id     = 'BLR00018'
	            AND PGM_DATE   = :nd_pgm_date
	            AND SESSION_ID = :nd_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select param1 ,param2 ,param3 ,param4 ,param5 ,param6 ,param\
7 ,param8 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7  from sy_prog_param where (((op\
erating_facility_id=:b8 and pgm_id='BLR00018') and PGM_DATE=:b9) and SESSION_I\
D=:b10)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1510;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_fr_ward_code;
 sqlstm.sqhstl[0] = (unsigned int  )8;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_to_ward_code;
 sqlstm.sqhstl[1] = (unsigned int  )8;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_fr_episode_id;
 sqlstm.sqhstl[2] = (unsigned int  )17;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_to_episode_id;
 sqlstm.sqhstl[3] = (unsigned int  )17;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_fr_blng_grp;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_to_blng_grp;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_fr_bed_class;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_to_bed_class;
 sqlstm.sqhstl[7] = (unsigned int  )7;
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
 sqlstm.sqhstv[9] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[9] = (unsigned int  )37;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[10] = (unsigned int  )18;
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



	if(OERROR)
		err_mesg("SELECT failed on SY_PROG_PARAM",0,"");
 	l_fr_ward_code.arr[l_fr_ward_code.len]  = '\0';   
	l_to_ward_code.arr[l_to_ward_code.len]	= '\0';   
	l_fr_episode_id.arr[l_fr_episode_id.len]= '\0';   
	l_to_episode_id.arr[l_to_episode_id.len]= '\0';
	   
	l_fr_blng_grp.arr[l_fr_blng_grp.len]  = '\0';   
	l_to_blng_grp.arr[l_to_blng_grp.len]	= '\0';   
	l_fr_bed_class.arr[l_fr_bed_class.len]= '\0';   
	l_to_bed_class.arr[l_to_bed_class.len]= '\0';   
/*	EXEC SQL DELETE 
	           FROM sy_prog_param
			  WHERE pgm_id     = 'BLR00018'
	            AND PGM_DATE   = :nd_pgm_date
	            AND SESSION_ID = :nd_session_id;

	if(OERROR)
		err_mesg("DELETE failed on SY_PROG_PARAM",0,"");*/
}

delete_sy_prog()
{
	/* EXEC SQL DELETE 
	           FROM sy_prog_param
			  WHERE pgm_id     = 'BLR00018'
	            AND PGM_DATE   = :nd_pgm_date
	            AND SESSION_ID = :nd_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from sy_prog_param  where ((pgm_id='BLR00018' and PG\
M_DATE=:b0) and SESSION_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1569;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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



	if(OERROR)
		err_mesg("DELETE failed on SY_PROG_PARAM",0,"");
}

open_files()
{
   strcpy(filename,WORKING_DIR);

   strcat(filename,"blr00018.lis");

   //strcpy(OUTPUT_FILE_NAME,filename );
   if ((fp = fopen(filename,"w")) == NULL)
   {
        err_mesg("Error while opening output file",0,"");
        proc_exit();
   }
}

declare_top_up_deposit()
{
	/* EXEC SQL DECLARE top_up_deposit_cur CURSOR    //PP
	             FOR
				  SELECT a.episode_id,
						 a.patient_id,
						 decode(:nd_lang_id,'en', substr(b.short_name,1,60),substr(nvl(b.SHORT_NAME_LOC_LANG,b.short_name),1,60))
					FROM ip_open_episode e,
						 bl_episode_fin_dtls a,
      					 mp_patient_mast b,
   						 ip_episode c,
   						 bl_parameters d,
						 BL_BLNG_GRP f
				   WHERE e.facility_id  = :nd_facility_id
					 AND a.patient_id     = b.patient_id
					 AND a.operating_facility_id = e.facility_id     			     
					 AND a.episode_type   in ('I','D')   //EPNH 30/10/2004
					 AND a.episode_id = e.open_episode_id
					 AND a.episode_id     = c.episode_id			     
					 AND a.episode_status = '0'
					 AND f.blng_grp_id=a.blng_grp_id
					 AND a.operating_facility_id  = c.facility_id
					 AND a.operating_facility_id  = d.operating_facility_id
					 AND ((d.discharge_billing_stage='1' and NVL(discharge_bill_gen_ind,'N') = 'N') 
						   OR
						  (d.discharge_billing_stage='2' and NVL(discharged_yn,'N') = 'N'))
					 AND (nvl(tot_unadj_dep_amt,0)+nvl(tot_unadj_prep_amt,0)) < ((nvl(tot_unbld_amt,0) + nvl(tot_outst_amt,0)) * (nvl(d.ip_deposit_top_up_perc,0)/100)) 
					 AND a.episode_id
				 BETWEEN NVL(:l_fr_episode_id,0)	
					 AND NVL(:l_to_episode_id,99999999)
					 AND c.cur_Ward_code
				 BETWEEN NVL(:l_fr_ward_code,'!!!!')
					 AND NVL(:l_to_ward_code,'~~~~')
					 AND f.BLNG_GRP_ID
				 BETWEEN NVL(:l_fr_blng_grp,'!!!!')
					 AND NVL(:l_to_blng_grp,'~~~~')
					 AND c.cur_bed_class_code
				 BETWEEN NVL(:l_fr_bed_class,'!!!!')
					 AND NVL(:l_to_bed_class,'~~~~'); */ 



	if(OERROR)
		err_mesg("DECLARE failed while PREPARING cursor top_up_deposit_cur",0,"");


	/* EXEC SQL OPEN top_up_deposit_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.episode_id ,a.patient_id ,decode(:b0,'en',substr(b.short_name,1\
,60),substr(nvl(b.SHORT_NAME_LOC_LANG,b.short_name),1,60))  from ip_open_epi\
sode e ,bl_episode_fin_dtls a ,mp_patient_mast b ,ip_episode c ,bl_parameter\
s d ,BL_BLNG_GRP f where (((((((((((((((e.facility_id=:b1 and a.patient_id=b\
.patient_id) and a.operating_facility_id=e.facility_id) and a.episode_type i\
n ('I','D')) and a.episode_id=e.open_episode_id) and a.episode_id=c.episode_\
id) and a.episode_status='0') and f.blng_grp_id=a.blng_grp_id) and a.operati\
ng_facility_id=c.facility_id) and a.operating_facility_id=d.operating_facili\
ty_id) and ((d.discharge_billing_stage='1' and NVL(discharge_bill_gen_ind,'N\
')='N') or (d.discharge_billing_stage='2' and NVL(discharged_yn,'N')='N'))) \
and (nvl(tot_unadj_dep_amt,0)+nvl(tot_unadj_prep_amt,0))<((nvl(tot_unbld_amt\
,0)+nvl(tot_outst_amt,0))* (nvl(d.ip_deposit_top_up_perc,0)/100))) and a.epi\
sode_id between NVL(:b2,0) and NVL(:b3,99999999)) and c.cur_Ward_code betwee\
n NVL(:b4,'!!!!') and NVL(:b5,'~~~~')) a");
 sqlstm.stmt = sq0074;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1592;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[0] = (unsigned int  )6;
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
 sqlstm.sqhstv[2] = (         void  *)&l_fr_episode_id;
 sqlstm.sqhstl[2] = (unsigned int  )17;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_to_episode_id;
 sqlstm.sqhstl[3] = (unsigned int  )17;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_fr_ward_code;
 sqlstm.sqhstl[4] = (unsigned int  )8;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_to_ward_code;
 sqlstm.sqhstl[5] = (unsigned int  )8;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_fr_blng_grp;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_to_blng_grp;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_fr_bed_class;
 sqlstm.sqhstl[8] = (unsigned int  )7;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_to_bed_class;
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



	if(OERROR)	   
		err_mesg("OPEN failed on cursor top_up_deposit_cur",0,"");
}

fetch_top_up_deposit()
{

	l_episode_id.arr[0] = '\0';
	l_patient_id.arr[0] = '\0';
	l_short_name.arr[0] = '\0';

	/* EXEC SQL FETCH top_up_deposit_cur
	          INTO :l_episode_id,
				   :l_patient_id,
				   :l_short_name; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1647;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&l_episode_id;
 sqlstm.sqhstl[0] = (unsigned int  )14;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )24;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_short_name;
 sqlstm.sqhstl[2] = (unsigned int  )67;
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
		err_mesg("FETCH failed on cursor deposit_cursor",0,"");

    if (sqlca.sqlcode == 1403 )	
	  	return 0;

	l_episode_id.arr[l_episode_id.len] = '\0';
	l_patient_id.arr[l_patient_id.len] = '\0';
	l_short_name.arr[l_short_name.len] = '\0';
    
	return 1;
}

print_formated(loc_amount)
double loc_amount;
{  
	char s_amt[40], str_amt[40];
    int s_amt_len=0;
	
   /* EXEC SQL SELECT no_of_decimal
               INTO :v_no_of_decimal
	  		   FROM sm_acc_entity_param
              WHERE acc_entity_id = (SELECT acc_entity_code 
									   FROM sy_acc_entity
									  WHERE acc_entity_id = :nd_facility_id); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 11;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select no_of_decimal into :b0  from sm_acc_entity_param wh\
ere acc_entity_id=(select acc_entity_code  from sy_acc_entity where acc_entity\
_id=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1674;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&v_no_of_decimal;
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
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



 



if(loc_amount < 0)
		{

            put_val(s_amt,-loc_amount);        
	 		u_ltrim(s_amt);
			s_amt_len = strlen(s_amt);
			if (s_amt_len>=14)
				{
					strcat(s_amt,"-");
					sprintf(str_amt,"%14s",s_amt);  
					fprintf(fp,"%14s",s_amt);
				}
				else if ((v_no_of_decimal==2 && s_amt_len>12) ||(v_no_of_decimal==3 && s_amt_len>13))
				{  
				   strcat(s_amt,"-");
				   sprintf(str_amt,"%14s",s_amt);  
				   fprintf(fp,"%14s",s_amt);
				}
				else 
				{   
				   format_amt(s_amt);
				   strcat(s_amt,"-");
			       sprintf(str_amt,"%14s",s_amt);  
				   fprintf(fp,"%14s",s_amt); 
				} 
					 
		}
		else 
		{ 
        put_val(s_amt,loc_amount); 
		u_ltrim(s_amt);

		s_amt_len = strlen(s_amt);
	    	    		
		if (s_amt_len>=14)
		{ 
		sprintf(str_amt,"%14s",s_amt);  
		fprintf(fp,"%14s",s_amt);
		}
		else if ((v_no_of_decimal==2 && s_amt_len>12) ||(v_no_of_decimal==3 && s_amt_len>13))
		{
 
		   sprintf(str_amt,"%14s",s_amt);  
		   fprintf(fp,"%14s",s_amt);
		   }
		else 
		{   
            sprintf(str_amt,"%14s",s_amt);  
		   format_amt(s_amt); 
		   fprintf(fp,"%14s",s_amt); 
		}
		

	}
 
 
}

print_page_title()
{
 
	double l_report_width;
	double l_letter_heading_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width; 	

	l_line_no=0;
	l_page_no++;

	fprintf(fp,"%c&k4S",ESC); 	/* To Set compressed mode */
	
	l_report_width=85;
	l_letter_heading_length = strlen(loc_legend1.arr);

	//Code for Line 1
	l_start_point=ceill((l_report_width/2)-(l_letter_heading_length/2));
	fprintf(fp,"\n");	
	print_spaces(l_start_point);
	fprintf(fp,"%s \n\n",loc_legend1.arr);
	l_line_no = l_line_no + 4;
 }


print_hospital_address()
{
 
	l_hospital_name.arr[0] = '\0';
	l_address_line1.arr[0] = '\0';
	l_address_line2.arr[0] = '\0';
	l_address_line3.arr[0] = '\0';
	l_tel_number.arr[0]    = '\0';
	l_sysdate.arr[0]	   = '\0';
	l_sysdate.len          = 0;

	/* EXEC SQL SELECT acc_entity_name,
					ln1_add,
					ln2_add, 
					ln3_add||' '||zip_code ln4_add,
					tel_num,
					TO_CHAR(SYSDATE,'DD/MM/YYYY') 
               INTO :l_hospital_name,
					:l_address_line1,
				    :l_address_line2,
					:l_address_line3,
					:l_tel_number,
					:l_sysdate
			   FROM sy_acc_entity_lang_vw 
			  WHERE acc_entity_id = :nd_facility_id
			  and language_id =:nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select acc_entity_name ,ln1_add ,ln2_add ,((ln3_add||' ')||z\
ip_code) ln4_add ,tel_num ,TO_CHAR(SYSDATE,'DD/MM/YYYY') into :b0,:b1,:b2,:b3,\
:b4,:b5  from sy_acc_entity_lang_vw where (acc_entity_id=:b6 and language_id=:\
b7)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1697;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_hospital_name;
 sqlstm.sqhstl[0] = (unsigned int  )52;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_address_line1;
 sqlstm.sqhstl[1] = (unsigned int  )35;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_address_line2;
 sqlstm.sqhstl[2] = (unsigned int  )35;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_address_line3;
 sqlstm.sqhstl[3] = (unsigned int  )35;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_tel_number;
 sqlstm.sqhstl[4] = (unsigned int  )35;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_sysdate;
 sqlstm.sqhstl[5] = (unsigned int  )22;
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
 sqlstm.sqhstv[7] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[7] = (unsigned int  )6;
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


	if(OERROR)
		err_mesg("SELECT failed on sy_acc_entity",0,"");

	l_hospital_name.arr[l_hospital_name.len] = '\0';
	l_address_line1.arr[l_address_line1.len] = '\0';
	l_address_line2.arr[l_address_line2.len] = '\0';
	l_address_line3.arr[l_address_line3.len] = '\0';
	l_tel_number.arr[l_tel_number.len]		  = '\0';
	l_sysdate.arr[l_sysdate.len]			  = '\0';

	fprintf(fp,"     %-s\n",l_hospital_name.arr);
	fprintf(fp,"     %-s\n",l_address_line1.arr);
	fprintf(fp,"     %-s\n",l_address_line2.arr);
	fprintf(fp,"     %-s\n",l_address_line3.arr);
	fprintf(fp,"     %-s %s\n",loc_legend2.arr, l_tel_number.arr);
 		init_date_temp_var();
		strcpy(date_convert.arr,l_sysdate.arr);
		fun_change_loc_date();
	fprintf(fp,"     %61s%s %-s\n"," ",loc_legend3.arr,date_convert.arr);
	
	l_line_no=l_line_no+6;
 
}

print_letter_body()
{
 
	fprintf(fp,"     %-s, \n\n",loc_legend4.arr);
	fprintf(fp,"     %-80.80s\n",loc_legend5.arr);
	fprintf(fp,"     %-80.80s\n",loc_legend6.arr);
	fprintf(fp,"     %-80.80s\n",loc_legend7.arr);
	fprintf(fp,"     %-80.80s\n",loc_legend7_1.arr);
	fprintf(fp,"\n");	
	fprintf(fp,"     %-s\n",loc_legend8.arr);
	fprintf(fp,"\n");	
	fprintf(fp,"     %-s %s\n",loc_legend9.arr,l_short_name.arr);
 		init_date_temp_var();
		strcpy(date_convert.arr,l_sysdate.arr);
		fun_change_loc_date();
	fprintf(fp,"     %-s %-s %-s %-s %-s %-s\n",
	                 loc_legend10.arr,l_patient_id.arr,loc_legend11.arr,l_episode_id.arr,loc_legend12.arr,date_convert.arr);
	l_line_no = l_line_no+11;
 
}

print_letter_deposit_detail()
{
 
	fprintf(fp,"\n");
	fprintf(fp,"     %-s\n",loc_legend13.arr);

	declare_receipt_refund_cursor();

	l_temp_line_no = l_line_no;
	
	while(fetch_receipt_Refund_cur())
	{
		if(l_line_no == l_temp_line_no)
		{
			fprintf(fp,"     %6s%-11.11s %-21.21s %-15.15s %14.14s\n"," ",loc_legend14.arr,loc_legend15.arr,loc_legend16.arr,loc_legend17.arr);
			fprintf(fp,"     %6s----------------------------------------------------------------\n"," ");
		if (l_doc_date.arr[0] != '\0') 
{
	init_date_temp_var();
	strcpy(date_convert.arr,l_doc_date.arr);
	fun_change_loc_date();
	fprintf(fp,"     %6s%-11.11s %-21.21s %-15.15s "," ",l_row_num.arr,l_doc_type_code.arr,date_convert.arr);
}
		}
		else
		{
				if (l_doc_date.arr[0] != '\0') 
{
	init_date_temp_var();
	strcpy(date_convert.arr,l_doc_date.arr);
	fun_change_loc_date();
			fprintf(fp,"     %6s%-11.11s %-21.21s %-15.15s "," ",l_row_num.arr,l_doc_type_code.arr,date_convert.arr);
}
		}
 		print_formated(l_doc_amt);
 		fprintf(fp,"\n");
		l_total_deposit_amount = l_total_deposit_amount + l_doc_amt;
		l_line_no++;
		check_page_break();
	}
	fprintf(fp,"\n");
	l_line_no++;
	check_page_break();

	l_temp_line_no = 0;
    l_temp_line_no = l_line_no;

	declare_folio_cursor();
	while(fetch_folio_cursor())
	{
		if (l_temp_line_no==l_line_no)
		{
			fprintf(fp,"     %-17.17s %-2s / %-2s      %-24.24s ",loc_legend18.arr,l_prt_grp_hdr_code.arr,l_prt_grp_line_code.arr,l_short_desc.arr);
		}
		else
		{
			fprintf(fp,"     %-17.17s %-2s / %-2s      %-24.24s "," ",l_prt_grp_hdr_code.arr,l_prt_grp_line_code.arr,l_short_desc.arr);
		}
 		print_formated(l_upd_net_charge_amt);
 		fprintf(fp,"\n");
		l_total_folio = l_total_folio + l_upd_net_charge_amt;
		l_line_no++;
		check_page_break();
	}
	close_internal_body_cursor();

	fprintf(fp,"\n");
	l_line_no++;
	check_page_break();
 
}

declare_receipt_refund_cursor()
{
	//sprintf(l_mesg,"Facility Id   %s    Episode Id   %s    Pat Id   %s",nd_facility_id.arr,l_episode_id.arr,l_patient_id.arr);
	//disp_message(ERR_MESG,l_mesg);
	/* EXEC SQL DECLARE receipt_refund_cur CURSOR 
	             FOR
		      SELECT TO_CHAR(ROWNUM),
			         doc_type_code||'/'||doc_number,
					 TO_CHAR(doc_date,'DD/MM/YYYY'),
					 doc_amt
				FROM bl_receipt_refund_dtl_VW
			   WHERE operating_facility_id = :nd_facility_id 
			     AND episode_id            = :l_episode_id    
				 AND patient_id            = :l_patient_id
				 AND recpt_nature_code     IN ('AD','PR')     
				 AND NVL(cancelled_ind,'N')  != 'Y'; */ 


	if(OERROR)	   
		err_mesg("SELECT failed on cursor receipt_refund_cur",0,"");

	/* EXEC SQL OPEN receipt_refund_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0077;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1744;
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
 sqlstm.sqhstv[1] = (         void  *)&l_episode_id;
 sqlstm.sqhstl[1] = (unsigned int  )14;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )24;
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
		err_mesg("SELECT failed on cursor receipt_refund_cur",0,"");
}

fetch_receipt_Refund_cur()
{
 
	l_doc_type_code.arr[0]	= '\0';
	l_row_num.arr[0] = '\0';
	l_doc_date.arr[0]		= '\0';
	l_doc_amt = 0;

	/* EXEC SQL FETCH receipt_refund_cur
	          INTO :l_row_num,
				   :l_doc_type_code,
				   :l_doc_date,
				   :l_doc_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1771;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&l_row_num;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_doc_date;
 sqlstm.sqhstl[2] = (unsigned int  )17;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_doc_amt;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
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



    if (sqlca.sqlcode == 1403 )	
		return 0;

	if(OERROR)	   
		err_mesg("SELECT failed on cursor receipt_refund_cur",0,"");

	l_row_num.arr[l_row_num.len] = '\0';
	l_doc_type_code.arr[l_doc_type_code.len]	= '\0';
	l_doc_date.arr[l_doc_date.len]				= '\0';

	return 1;
 
}


declare_folio_cursor()
{
 
	/* EXEC SQL DECLARE folio_cursor CURSOR
	             FOR
			  SELECT prt_grp_hdr_code,
       				 prt_grp_line_code,
       				 sum(upd_net_charge_amt)
                FROM bl_patient_charges_folio 
			   WHERE operating_facility_id = :nd_facility_id
				 AND episode_id            = :l_episode_id
				 AND patient_id            = :l_patient_id
				 AND trx_status         IS NULL
				 AND bill_doc_type_code IS NULL
			   GROUP 
				  BY prt_grp_hdr_code,
       				 prt_grp_line_code; */ 


	if(OERROR)	   
		err_mesg("DECLARE failed on cursor folio_cursor",0,"");

	/* EXEC SQL OPEN folio_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0078;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1802;
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
 sqlstm.sqhstv[1] = (         void  *)&l_episode_id;
 sqlstm.sqhstl[1] = (unsigned int  )14;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )24;
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
		err_mesg("OPEN failed on cursor folio_cursor",0,"");
 
}


fetch_folio_cursor()
{ 
	l_prt_grp_hdr_code.arr[0]  = '\0';
    l_prt_grp_line_code.arr[0] = '\0';
    l_upd_net_charge_amt=0;

	/* EXEC SQL FETCH folio_cursor 
	          INTO :l_prt_grp_hdr_code,
				   :l_prt_grp_line_code,
				   :l_upd_net_charge_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1829;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&l_prt_grp_hdr_code;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_prt_grp_line_code;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_upd_net_charge_amt;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
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
		return 0;

	if(OERROR)	   
		err_mesg("FETCH failed on cursor folio_cursor",0,"");

 	l_prt_grp_hdr_code.arr[l_prt_grp_hdr_code.len]  = '\0';
    l_prt_grp_line_code.arr[l_prt_grp_line_code.len] = '\0';

	l_short_desc.arr[0] = '\0';

	/* EXEC SQL SELECT decode(:nd_lang_id,'en', substr(short_desc,1,16),substr(nvl(LOC_LANG_SHORT_DESC,short_desc),1,16))
	           INTO :l_short_desc
			   FROM bl_blng_prt_grp_line
			  WHERE prt_grp_hdr_code = :l_prt_grp_hdr_code
                AND prt_grp_line_code= :l_prt_grp_line_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select decode(:b0,'en',substr(short_desc,1,16),substr(nvl(LO\
C_LANG_SHORT_DESC,short_desc),1,16)) into :b1  from bl_blng_prt_grp_line where\
 (prt_grp_hdr_code=:b2 and prt_grp_line_code=:b3)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1856;
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
 sqlstm.sqhstv[1] = (         void  *)&l_short_desc;
 sqlstm.sqhstl[1] = (unsigned int  )19;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_prt_grp_hdr_code;
 sqlstm.sqhstl[2] = (unsigned int  )7;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_prt_grp_line_code;
 sqlstm.sqhstl[3] = (unsigned int  )7;
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
		err_mesg("SELECT failed on bl_blng_prt_grp_line",0,"");

	l_short_desc.arr[l_short_desc.len] = '\0';

	return 1;
 
}

close_top_up_deposit()
{
	/* EXEC SQL CLOSE top_up_deposit_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1887;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)	   
		err_mesg("CLOSE failed on cursor top_up_deposit_cur",0,"");
}

close_internal_body_cursor()
{
	/* EXEC SQL CLOSE receipt_refund_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1902;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)	   
		err_mesg("CLOSE failed on cursor receipt_refund_cur",0,"");

	/* EXEC SQL CLOSE folio_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1917;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)	   
		err_mesg("CLOSE failed on cursor folio_cursor",0,"");
}

print_letter_total()
{
 
	fprintf(fp,"     %55.55s ",loc_legend19.arr);
 	print_formated(l_total_folio);
 	fprintf(fp,"\n");
	l_line_no++;
	check_page_break();

	fprintf(fp,"     %55.55s ",loc_legend20.arr);
 	print_formated(l_total_deposit_amount);
 	fprintf(fp,"\n");
	l_line_no++;
	check_page_break();

	//l_outstanding_amount = l_total_folio;

	l_outstanding_amount = l_total_folio - l_total_deposit_amount;

	fprintf(fp,"     %55.55s ",loc_legend21.arr);
 	print_formated(l_outstanding_amount);
 	fprintf(fp,"\n");
	l_line_no++;

	check_page_break();

	l_blng_grp_id.arr[0] = '\0';
	l_cust_code.arr[0] = '\0';
	l_non_ins_blng_grp_id.arr[0] = '\0';
	l_non_ins_cust_code.arr[0] = '\0';
	l_settlement_ind.arr[0] = '\0';

	/* EXEC SQL SELECT blng_grp_id,
					cust_code,
					non_ins_blng_grp_id,
					non_ins_cust_code,
					settlement_ind
			   INTO :l_blng_grp_id,
					:l_cust_code,
					:l_non_ins_blng_grp_id,
					:l_non_ins_cust_code,
					:l_settlement_ind
			   FROM bl_episode_fin_dtls
			  WHERE operating_facility_id	= :nd_facility_id
			    AND episode_type			in ('I'	,'D') //EPNH 30/10/2004
				AND episode_id				= :l_episode_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select blng_grp_id ,cust_code ,non_ins_blng_grp_id ,non_ins_\
cust_code ,settlement_ind into :b0,:b1,:b2,:b3,:b4  from bl_episode_fin_dtls w\
here ((operating_facility_id=:b5 and episode_type in ('I','D')) and episode_id\
=:b6)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1932;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_blng_grp_id;
 sqlstm.sqhstl[0] = (unsigned int  )17;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_cust_code;
 sqlstm.sqhstl[1] = (unsigned int  )17;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_non_ins_blng_grp_id;
 sqlstm.sqhstl[2] = (unsigned int  )17;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_non_ins_cust_code;
 sqlstm.sqhstl[3] = (unsigned int  )17;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_settlement_ind;
 sqlstm.sqhstl[4] = (unsigned int  )17;
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
 sqlstm.sqhstv[6] = (         void  *)&l_episode_id;
 sqlstm.sqhstl[6] = (unsigned int  )14;
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
		err_mesg("SELECT failed on table bl_episode_fin_dtls",0,"");

	l_blng_grp_id.arr[l_encounter_id.len]				= '\0';
	l_cust_code.arr[l_cust_code.len]					= '\0';
	l_non_ins_blng_grp_id.arr[l_non_ins_blng_grp_id.len]= '\0';
	l_non_ins_cust_code.arr[l_non_ins_cust_code.len]	= '\0';
	l_settlement_ind.arr[l_settlement_ind.len]			= '\0';

	l_encounter_id.arr[0]			= '\0';
	l_cur_ward_code.arr[0]			= '\0';
	l_cur_bed_num.arr[0]			= '\0';
	l_admission_type_code.arr[0]	= '\0';
	l_cur_bed_class_code.arr[0]		= '\0';
	l_to_nursing_unit.arr[0]		= '\0';

	/* EXEC SQL SELECT distinct a.encounter_id,
					cur_ward_code,
					cur_bed_num,
					cur_physician_id, 
					a.admission_type_code,
					e.bed_class_code,
					to_nursing_unit
			   INTO :l_encounter_id,
					:l_cur_ward_code,
					:l_cur_bed_num,
					:l_cur_physician_id, 
					:l_admission_type_code,
					:l_cur_bed_class_code,
					:l_to_nursing_unit
			   FROM ip_episode			a, 
					bl_episode_fin_dtls b, 
					ip_adt_trn_his_vw	d,
					ip_bed_type			e,
					ip_ward				g
			  WHERE b.operating_facility_id  = a.facility_id 
				AND	b.episode_id			 = a.episode_id 
				AND	d.episode_id			 = a.episode_id 
				AND e.bed_type_code			 = d.to_bed_type_code
				AND g.facility_id			 = a.facility_id
				AND g.ward_code				 = a.cur_ward_code
				AND a.facility_id			 = :nd_facility_id
				AND	a.episode_id			 = :l_episode_id
				AND d.srl_no				 = ( SELECT max(srl_no)
												   FROM ip_adt_trn_his_vw f 
												  WHERE f.episode_id = a.episode_id 
								   					AND f.trn_code in ('A','T') 
													AND nvl(f.adt_trn_status,'0') <> '9'); */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 11;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select distinct a.encounter_id ,cur_ward_code ,cur_bed_num ,\
cur_physician_id ,a.admission_type_code ,e.bed_class_code ,to_nursing_unit int\
o :b0,:b1,:b2,:b3,:b4,:b5,:b6  from ip_episode a ,bl_episode_fin_dtls b ,ip_ad\
t_trn_his_vw d ,ip_bed_type e ,ip_ward g where ((((((((b.operating_facility_id\
=a.facility_id and b.episode_id=a.episode_id) and d.episode_id=a.episode_id) a\
nd e.bed_type_code=d.to_bed_type_code) and g.facility_id=a.facility_id) and g.\
ward_code=a.cur_ward_code) and a.facility_id=:b7) and a.episode_id=:b8) and d.\
srl_no=(select max(srl_no)  from ip_adt_trn_his_vw f where ((f.episode_id=a.ep\
isode_id and f.trn_code in ('A','T')) and nvl(f.adt_trn_status,'0')<>'9')))";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1975;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_encounter_id;
 sqlstm.sqhstl[0] = (unsigned int  )17;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_cur_ward_code;
 sqlstm.sqhstl[1] = (unsigned int  )17;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_cur_bed_num;
 sqlstm.sqhstl[2] = (unsigned int  )17;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_cur_physician_id;
 sqlstm.sqhstl[3] = (unsigned int  )17;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_admission_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )17;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_cur_bed_class_code;
 sqlstm.sqhstl[5] = (unsigned int  )17;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_to_nursing_unit;
 sqlstm.sqhstl[6] = (unsigned int  )17;
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
 sqlstm.sqhstv[8] = (         void  *)&l_episode_id;
 sqlstm.sqhstl[8] = (unsigned int  )14;
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



//	if (OERROR)
if(sqlca.sqlcode < 0)
	{
         err_mesg("SELECT failed on IP EPISODE",0,"");
	 }

	l_encounter_id.arr[l_encounter_id.len]				= '\0';
	l_cur_ward_code.arr[l_cur_ward_code.len]			= '\0';
	l_cur_bed_num.arr[l_cur_bed_num.len]				= '\0';
	l_admission_type_code.arr[l_admission_type_code.len]= '\0';
	l_cur_bed_class_code.arr[l_cur_bed_class_code.len]	= '\0';
	l_to_nursing_unit.arr[l_to_nursing_unit.len]		= '\0';
	v_error_text.arr[0]									= '\0';

	/* EXEC SQL EXECUTE
	BEGIN

		bl_ip_interface.proc_get_ip_billing_details(:nd_facility_id,
									:l_to_nursing_unit ,
									:l_cur_bed_class_code,
									:l_admission_type_code,
									:l_cur_bed_num,         //In 
									:l_to_bed_type_code,    //Out
									:l_nursing_unit_type,
									:l_blng_class ,
									:l_bill_type ,		
									:l_SERVICE_PANEL_IND,						
									:l_blng_serv ,
									:l_deposit_reqd_yn ,
									:l_addl_dep_reqd_yn,
									:l_dept_code,
									:l_sys_message_id ,
									:v_error_text);
	
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin bl_ip_interface . proc_get_ip_billing_details ( :nd_fa\
cility_id , :l_to_nursing_unit , :l_cur_bed_class_code , :l_admission_type_cod\
e , :l_cur_bed_num , :l_to_bed_type_code , :l_nursing_unit_type , :l_blng_clas\
s , :l_bill_type , :l_SERVICE_PANEL_IND , :l_blng_serv , :l_deposit_reqd_yn , \
:l_addl_dep_reqd_yn , :l_dept_code , :l_sys_message_id , :v_error_text ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2026;
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
 sqlstm.sqhstv[1] = (         void  *)&l_to_nursing_unit;
 sqlstm.sqhstl[1] = (unsigned int  )17;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_cur_bed_class_code;
 sqlstm.sqhstl[2] = (unsigned int  )17;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_admission_type_code;
 sqlstm.sqhstl[3] = (unsigned int  )17;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_cur_bed_num;
 sqlstm.sqhstl[4] = (unsigned int  )17;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_to_bed_type_code;
 sqlstm.sqhstl[5] = (unsigned int  )17;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_nursing_unit_type;
 sqlstm.sqhstl[6] = (unsigned int  )27;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_blng_class;
 sqlstm.sqhstl[7] = (unsigned int  )27;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_bill_type;
 sqlstm.sqhstl[8] = (unsigned int  )27;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_SERVICE_PANEL_IND;
 sqlstm.sqhstl[9] = (unsigned int  )27;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_blng_serv;
 sqlstm.sqhstl[10] = (unsigned int  )27;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&l_deposit_reqd_yn;
 sqlstm.sqhstl[11] = (unsigned int  )27;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&l_addl_dep_reqd_yn;
 sqlstm.sqhstl[12] = (unsigned int  )27;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&l_dept_code;
 sqlstm.sqhstl[13] = (unsigned int  )27;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&l_sys_message_id;
 sqlstm.sqhstl[14] = (unsigned int  )27;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&v_error_text;
 sqlstm.sqhstl[15] = (unsigned int  )502;
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



	l_to_bed_type_code.arr[strlen(l_to_bed_type_code.arr)]	= '\0';
	l_nursing_unit_type.arr[strlen(l_nursing_unit_type.arr)]= '\0';
	l_blng_class.arr[strlen(l_blng_class.arr)]				= '\0';
	l_bill_type.arr[strlen(l_bill_type.arr)]				= '\0';
	l_blng_serv.arr[strlen(l_blng_serv.arr)]				= '\0';
	l_deposit_reqd_yn.arr[strlen(l_deposit_reqd_yn.arr)]	= '\0';
	l_addl_dep_reqd_yn.arr[strlen(l_addl_dep_reqd_yn.arr)]	= '\0';
	l_dept_code.arr[strlen(l_dept_code.arr)]				= '\0';
	l_sys_message_id.arr[strlen(l_sys_message_id.arr)]		= '\0';
	v_error_text.arr[strlen(v_error_text.arr)]				= '\0';

	if(v_error_text.len > 0)
	{
		sprintf(l_mesg,"Error : proc_get_ip_billing_details : %s",v_error_text.arr);
		disp_message(ERR_MESG,l_mesg);
		proc_exit;
	}	

	//sprintf(l_mesg,"l_to_bed_type_code  %s   l_nursing_unit_type   %s   l_blng_class   %s   l_bill_type    %s   l_blng_serv   %s   l_deposit_reqd_yn   %s   l_addl_dep_reqd_yn   %s   l_dept_code   %s   ",l_to_bed_type_code.arr,l_nursing_unit_type.arr,l_blng_class.arr,l_bill_type.arr,l_blng_serv.arr,l_deposit_reqd_yn.arr,l_addl_dep_reqd_yn.arr,l_dept_code.arr);
	//disp_message(ERR_MESG,l_mesg);

	l_reln_code.arr[0]	= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN

	:l_reln_code := blcommon.get_reln_code(:l_patient_id);

	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_reln_code := blcommon . get_reln_code ( :l_patient_\
id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2105;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_reln_code;
 sqlstm.sqhstl[0] = (unsigned int  )27;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )24;
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


	
	//sprintf(l_mesg,"l_reln_code %s",l_reln_code.arr);
	//disp_message(ERR_MESG,l_mesg);


	l_reln_code.arr[strlen(l_reln_code.arr)]	= '\0';

	v_error_text.arr[0]				= '\0';

	/* EXEC SQL EXECUTE
	BEGIN

		bl_ip_interface.bl_blng_grp_adm_prepayment( :nd_facility_id,
								    :l_blng_grp_id,
								    :l_nursing_unit_type,
								    :l_cur_bed_class_code,
								    :l_settlement_ind,
								    :l_reln_code,        //In
								    :l_dep_amt,           //Out
								    :l_dep_defined,
								    :v_error_text);
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin bl_ip_interface . bl_blng_grp_adm_prepayment ( :nd_fac\
ility_id , :l_blng_grp_id , :l_nursing_unit_type , :l_cur_bed_class_code , :l_\
settlement_ind , :l_reln_code , :l_dep_amt , :l_dep_defined , :v_error_text ) \
; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2128;
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
 sqlstm.sqhstv[1] = (         void  *)&l_blng_grp_id;
 sqlstm.sqhstl[1] = (unsigned int  )17;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_nursing_unit_type;
 sqlstm.sqhstl[2] = (unsigned int  )27;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_cur_bed_class_code;
 sqlstm.sqhstl[3] = (unsigned int  )17;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_settlement_ind;
 sqlstm.sqhstl[4] = (unsigned int  )17;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_reln_code;
 sqlstm.sqhstl[5] = (unsigned int  )27;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_dep_amt;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_dep_defined;
 sqlstm.sqhstl[7] = (unsigned int  )12;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&v_error_text;
 sqlstm.sqhstl[8] = (unsigned int  )502;
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



	l_dep_defined.arr[strlen(l_dep_defined.arr)]	= '\0';
	v_error_text.arr[strlen(v_error_text.arr)]		= '\0';

	if(v_error_text.len > 0)
	{
		sprintf(l_mesg,"Error : bl_blng_grp_adm_prepayment : %s",v_error_text.arr);
		disp_message(ERR_MESG,l_mesg);
		proc_exit;
	}	

	//sprintf(l_mesg,"Dep_Amt %f   l_dep_defined   %s",l_dep_amt,l_dep_defined.arr);
	//disp_message(ERR_MESG,l_mesg);


	l_next_deposit = l_dep_amt;

	if(strcmp(l_dep_defined.arr,"N")==0)
	{
		v_error_text.arr[0]		= '\0';  

		/* EXEC SQL EXECUTE
		BEGIN
			bl_ip_interface.bl_calculate_tot_dep_amt(:l_to_nursing_unit,
									 :l_nursing_unit_type,
									 :l_cur_bed_class_code ,
									 :l_to_bed_type_code,
									 :l_cur_bed_num,
									 :l_settlement_ind,
									 :l_deposit_reqd_yn,
									 :l_addl_dep_reqd_yn,   
									 0,
									 0,
									 :l_dep_amt,			//Out	
									 :l_next_deposit,
									 :v_error_text);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin bl_ip_interface . bl_calculate_tot_dep_amt ( :l_to_nu\
rsing_unit , :l_nursing_unit_type , :l_cur_bed_class_code , :l_to_bed_type_cod\
e , :l_cur_bed_num , :l_settlement_ind , :l_deposit_reqd_yn , :l_addl_dep_reqd\
_yn , 0 , 0 , :l_dep_amt , :l_next_deposit , :v_error_text ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2179;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_to_nursing_unit;
  sqlstm.sqhstl[0] = (unsigned int  )17;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_nursing_unit_type;
  sqlstm.sqhstl[1] = (unsigned int  )27;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_cur_bed_class_code;
  sqlstm.sqhstl[2] = (unsigned int  )17;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_to_bed_type_code;
  sqlstm.sqhstl[3] = (unsigned int  )17;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_cur_bed_num;
  sqlstm.sqhstl[4] = (unsigned int  )17;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_settlement_ind;
  sqlstm.sqhstl[5] = (unsigned int  )17;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&l_deposit_reqd_yn;
  sqlstm.sqhstl[6] = (unsigned int  )27;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&l_addl_dep_reqd_yn;
  sqlstm.sqhstl[7] = (unsigned int  )27;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&l_dep_amt;
  sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&l_next_deposit;
  sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&v_error_text;
  sqlstm.sqhstl[10] = (unsigned int  )502;
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



		v_error_text.arr[strlen(v_error_text.arr)]		= '\0';

		if(v_error_text.len > 0)
		{
			sprintf(l_mesg,"Error : bl_calculate_tot_dep_amt : %s",v_error_text.arr);
			disp_message(ERR_MESG,l_mesg);
			proc_exit;
		}	

	}

	fprintf(fp,"     %55.55s ",loc_legend22.arr);
 	print_formated(l_next_deposit);
 	fprintf(fp,"\n");
	l_line_no++;
	check_page_break();

	l_total_amount_to_pay = l_next_deposit + l_outstanding_amount;

	fprintf(fp,"     %55.55s ",loc_legend23.arr);
 	print_formated(l_total_amount_to_pay);
 
	fprintf(fp,"\n");
	l_line_no++;
	check_page_break();

	l_total_folio			=0;
	l_total_deposit_amount	=0;
	l_outstanding_amount	=0;
	l_total_amount_to_pay	=0;
	l_next_deposit			=0;
	l_dep_amt				=0;	
	
	fprintf(fp,"\n");
}

print_letter_footer()
{
	fprintf(fp,"     %-s\n",loc_legend24.arr);
	l_line_no++;
	check_page_break();

	fprintf(fp,"     %-s\n",loc_legend25.arr);
	l_line_no++;
	check_page_break();

	fprintf(fp,"     %-s\n",loc_legend26.arr);
	l_line_no++;
	check_page_break();

	fprintf(fp,"     %-s\n",loc_legend27.arr);
	l_line_no++;
	check_page_break();

	fprintf(fp,"     %-s\n",loc_legend28.arr);
	l_line_no++;
	check_page_break();

	fprintf(fp,"     %-s\n",loc_legend29.arr);
	l_line_no++;
	check_page_break();

	fprintf(fp,"     %-s\n",loc_legend30.arr);
	l_line_no++;
	check_page_break();

	fprintf(fp,"\n     %-s\n\n\n",loc_legend31.arr);
	l_line_no=l_line_no + 4;
	check_page_break();

	fprintf(fp,"     %-s\n",loc_legend32.arr);
	l_line_no++;
	check_page_break();

	fprintf(fp,"     %-s\n",nd_facility_name.arr);
	l_line_no++;


	fprintf(fp,"\n\n");	

	fprintf(fp,"     %-s\n",loc_legend33.arr);
	l_line_no++;
	

	fprintf(fp,"%\f");
}

print_spaces(l_length)
double l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(fp," ");
	}
}

check_page_break()
{
	if (l_line_no >= 60)	
	{
		print_page_title();
	}
}

get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	  
      // 	get_locale_date.CONVERT_TO_LOCALE_DATE(to_date(:nd_temp_date,'DD/MM/RRRR HH24:MI'),:nd_lang_id,t_date);  
	 :nd_loc_date :=  	sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/RRRR'),:nd_lang_id);  

      
 	

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/RRRR' ) , :nd_lang_id ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2238;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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

  
fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);
nd_temp_date.arr[nd_temp_date.len]='\0';

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}
fetch_legend_value1()
{
	for(i=34;i<=100;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00018.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00018.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2265;
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
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :nd_lang_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2288;
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