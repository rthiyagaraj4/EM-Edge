
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
           char  filnam[31];
};
static const struct sqlcxp sqlfpn =
{
    30,
    "e:\\ravis\\test\\isbt\\bdrlbprn.pc"
};


static unsigned long sqlctx = 1899770965;


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
            void  *sqhstv[16];
   unsigned int   sqhstl[16];
            int   sqhsts[16];
            void  *sqindv[16];
            int   sqinds[16];
   unsigned int   sqharm[16];
   unsigned int   *sqharc[16];
   unsigned short  sqadto[16];
   unsigned short  sqtdso[16];
} sqlstm = {10,16};

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

 static const char *sq0008 = 
"roup(+) and a.language_id=b.language_id(+)) and a.language_id=:b3)) d where \
((a.rhesus_code=b.rhesus_code and a.volume_units=c.uom_code(+)) and a.blood_gr\
oup=d.blood_group(+))           ";

 static const char *sq0009 = 
"up) blood_group ,NVL(b.blood_grp_for_disp,a.blood_group) blood_grp_for_disp \
,NVL(b.disp_long_desc,a.long_desc) blood_group_desc  from BT_BLOOD_GROUP_MAST_\
LANG_VW a ,BD_BLOOD_GRP_DESC_MAST_LANG_VW b where ((a.blood_group=b.blood_grou\
p(+) and a.language_id=b.language_id(+)) and a.language_id=:b8)) d where ((a.r\
hesus_code=b.rhesus_code and a.volume_units=c.uom_code(+)) and a.blood_group=d\
.blood_group(+)) order by a_unit_no,a_product_code            ";

 static const char *sq0010 = 
"d (((:b0='BDRSCRLB' and NVL(add_to_stock_yn,'N')=NVL(:b8,NVL(add_to_stock_yn\
,'N'))) or (:b0='BDRUSRLB' and 1=1)) or (:b0='BDRUNTLB' and 1=1))) and product\
_code=nvl(:b11,product_code))) A ,(select RHESUS_CODE ,LONG_DESC  from BT_RHES\
US_CODE_MAST_LANg_vW where Language_id=:b12) B ,(select UOM_CODE ,SHORT_DESC  \
from BT_UOM_MAST_LANG_VW where language_id=:b12) C ,(select NVL(b.blood_group,\
a.blood_group) blood_group ,NVL(b.blood_grp_for_disp,a.blood_group) blood_grp_\
for_disp ,NVL(b.disp_long_desc,a.long_desc) blood_group_desc  from BT_BLOOD_GR\
OUP_MAST_LANG_VW a ,BD_BLOOD_GRP_DESC_MAST_LANG_VW b where ((a.blood_group=b.b\
lood_group(+) and a.language_id=b.language_id(+)) and a.language_id=:b12)) D w\
here ((A.RHESUS_CODE=B.RHESUS_CODE(+) and A.VOLUME_UNITS=C.UOM_CODE(+)) and A.\
blood_group=D.blood_group(+)) order by A.unit_no,A.product_code            ";

 static const char *sq0058 = 
"select QUEUE_NAME  from sm_print_routing a ,sm_printer b where ((((a.report_\
id=:b0 and a.printer_id1=b.printer_id) and a.dest_locn_type=DECODE(:b1,'!','O'\
,:b2)) and a.dest_locn_code=DECODE(:b1,'!',a.dest_locn_code,NVL(LTRIM(RTRIM(:b\
4)),a.dest_locn_code))) and NVL(a.ws_no,'!!!')=NVL(:b5,'!!!'))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,438,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,172,0,6,447,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
59,0,0,3,0,0,30,580,0,0,0,0,0,1,0,
74,0,0,4,0,0,30,588,0,0,0,0,0,1,0,
89,0,0,5,86,0,4,626,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
112,0,0,6,109,0,6,713,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
135,0,0,7,136,0,6,722,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
158,0,0,8,1210,0,9,797,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
197,0,0,9,1474,0,9,878,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
256,0,0,10,1877,0,9,974,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
331,0,0,10,0,0,13,1042,0,0,16,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,
410,0,0,11,194,0,6,1125,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
437,0,0,12,494,0,6,1195,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
472,0,0,9,0,0,13,1298,0,0,13,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
539,0,0,13,193,0,6,1384,0,0,2,2,0,1,0,3,9,0,0,1,9,0,0,
562,0,0,14,494,0,6,1424,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
597,0,0,8,0,0,13,1530,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
660,0,0,15,193,0,6,1605,0,0,2,2,0,1,0,3,9,0,0,1,9,0,0,
683,0,0,16,494,0,6,1644,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
718,0,0,17,105,0,4,1695,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
745,0,0,18,1494,0,6,1744,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,
820,0,0,19,115,0,4,1902,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
847,0,0,20,173,0,4,1936,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
874,0,0,21,213,0,4,1944,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
909,0,0,22,135,0,4,1977,0,0,1,0,0,1,0,2,9,0,0,
928,0,0,23,136,0,4,1989,0,0,1,0,0,1,0,2,9,0,0,
947,0,0,24,98,0,4,1997,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
970,0,0,25,380,0,4,2038,0,0,10,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1025,0,0,26,155,0,4,2048,0,0,10,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1080,0,0,27,504,0,4,2059,0,0,15,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,
1155,0,0,28,167,0,4,2073,0,0,11,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1214,0,0,29,117,0,4,2086,0,0,8,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,
1261,0,0,30,380,0,4,2097,0,0,10,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1316,0,0,31,155,0,4,2108,0,0,10,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1371,0,0,32,464,0,4,2122,0,0,13,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1438,0,0,33,155,0,4,2137,0,0,10,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1493,0,0,34,387,0,4,2151,0,0,13,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1560,0,0,35,171,0,4,2162,0,0,11,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1619,0,0,36,117,0,4,2176,0,0,8,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,
1666,0,0,37,347,0,4,2187,0,0,11,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1725,0,0,38,155,0,4,2198,0,0,10,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1780,0,0,39,347,0,4,2210,0,0,11,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1839,0,0,40,155,0,4,2221,0,0,10,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1894,0,0,41,195,0,4,2237,0,0,12,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1957,0,0,42,117,0,4,2250,0,0,8,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,
2004,0,0,43,155,0,4,2261,0,0,10,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2059,0,0,44,155,0,4,2272,0,0,10,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2114,0,0,45,187,0,4,2326,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
2149,0,0,46,210,0,4,2334,0,0,6,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
2188,0,0,47,173,0,4,2342,0,0,6,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
2227,0,0,48,192,0,4,2350,0,0,6,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
2266,0,0,49,489,0,6,2361,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,2,9,0,0,
2297,0,0,50,210,0,4,2389,0,0,6,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
2336,0,0,51,213,0,6,2407,0,0,2,2,0,1,0,3,9,0,0,1,9,0,0,
2359,0,0,52,245,0,4,2686,0,0,8,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,
2406,0,0,53,111,0,4,2747,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2433,0,0,54,119,0,4,2780,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2456,0,0,55,111,0,4,2995,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2479,0,0,56,120,0,4,3027,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2510,0,0,57,125,0,4,3035,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2537,0,0,58,305,0,9,3517,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
2576,0,0,58,0,0,13,3529,0,0,1,0,0,1,0,2,9,0,0,
2595,0,0,58,0,0,15,3547,0,0,0,0,0,1,0,
2610,0,0,59,224,0,3,3803,0,0,3,3,0,1,0,1,9,0,0,1,3,0,0,1,9,0,0,
2637,0,0,60,154,0,4,4028,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2668,0,0,61,58,0,4,4056,0,0,1,0,0,1,0,2,9,0,0,
};


/********************************************************************************/
/* PROGRAM NAME          : BDRLBPRN                                             */
/* DESCRIPTION		     : BD Label Processing & Printing 					    */
/* MODIFIED BY			 : Gopikannan P		                                    */
/* MODIFIED ON			 : 23-OCT-2013		                                    */
/*                       : 07-Jun-2014                                          */
/* MODIFIED REASON       : Added Online_Barcode_Label() Function only for       */ 
/*                         MEDICITY for Screend label Printing Performance      */         
/********************************************************************************/

#define NO_DATA_FOUND (sqlca.sqlcode == 1403)
#define VIEW_LOG_FILE 1
#define ONLINE_PRINTING 1
#define OERROR 		  (sqlca.sqlcode < 0)
#define INIT_MESG "Label Printing"
#define ESC 0x1B

#include <stdio.h>  
#include <string.h>
#include <math.h>
#include <malloc.h>   
#include <rl.h> 

int BVLanguageIsAPL;  /*-- Addded by Gopikannan for online_barcode_label for MEDICITY --*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 
                  

/* VARCHAR		uid_pwd			    [500],     
		nd_source_type	        [10],
		nd_fm_source	        [500],
		d_no_copy				[4],
		nd_facility_id			[30],
		nd_session_id           [500],
		nd_ws_no                [500],
		nd_trx_ind				[20],
		nd_printer_type         [20],

		d_sample_ind	        [410],
		d_fm_unit_no	        [410],
		d_fm_product_code       [410],
		d_fm_ch_product_code    [410],// added by sunil  on 08-Aug-2008 against CRF
		d_fm_ch_unit_no		    [410],// corrected/added on 20/06/2012 against the issue reported from SRR for reprinting of Aliquot labels
		d_add_stock_yn			[41],// added by sunil  on 08-Aug-2008 against CRF
		d_facility_id           [41],
		d_facility_name         [1010],
	    d_antigen_date			[500],// added by sunil  on 08-Aug-2008 against CRF
		d_antigen_desc			[500],// added by sunil  on 05/01/2010
		d_antigen_desc2			[500],// added by sunil  on 05/01/2010
		d_antigen_desc3			[500],// added by sunil  on 05/01/2010
		d_antigen_desc4			[500],// added by sunil  on 05/01/2010
		d_antigen_desc5			[500],// added by sunil  on 05/01/2010
		d_antigen_desc6			[500],// added by sunil  on 05/01/2010
		d_antigen_desc7			[500],// added by sunil  on 05/01/2010
		d_antigen_desc8			[500],// added by sunil  on 05/01/2010
		d_antigen_desc9			[500],// added by sunil  on 05/01/2010
		d_antigen_desc10		[500],// added by sunil  on 05/01/2010
		d_unit_barcode_value    [1010],
		d_product_code_temp     [41], 
		d_product_desc_temp     [1010],
		d_store_instr_code      [110],
		d_store_instr_desc_temp [1000],

		nd_donation_date        [51],
		nd_donation_date1       [51], //added for globalisation
		nd_donor_product_code   [410], 
		nd_donor_unit_no        [410],
		nd_product_code         [410], 
//Dhana changes
		nd_bld_grp_rh_barcode	[500],	
		nd_prod_barcode_msg1	[2500],
		nd_prod_barcode_msg2	[2500],
		nd_donor_id				[200],
		nd_center_code			[40],
		nd_center_desc			[400], // added by sunil 
		nd_product_barcode_value [450],
		nd_product_long_desc	 [410], // added by sunil
		nd_donation_process		[20],	
		nd_collection_date		[41], // added by sunil 0n 01-Jun-2008 against CRF	
		nd_volume_units			[410], // added by sunil 0n 08-aug-2008 against CRF	
		nd_volume_unit			[410], // added by sunil 0n 16-dec-2008 against SCF	

		d_bld_grp_rh_barcode	 [20][350],	
		d_prod_barcode_msg1		 [20][2500],
		d_prod_barcode_msg2		 [20][2500],
		split_text               [4000],   //added by sunil
		d_donor_id				 [20][200],
		d_center_code			 [20][40],
		d_center_desc			 [40][400], // added by sunil
		d_product_barcode_value	 [20][1500],
		d_product_long_desc		 [45][550], // added by sunil
		d_donation_process		 [20][20],	
		
		isb_value				 [40],
		isb_unit_no_format       [20],
		nd_sys_date              [41],   // added by sunil
		d_collection_date        [500][41], // added by sunil on 01-Jun-2008 against CRF	
		d_volume_units			 [500][41], // added by sunil 0n 08-aug-2008 against CRF	
		d_volume_unit			 [500][41], // added by sunil 0n 16-dec-2008 against SCF	

		nd_product_desc          [1010], 
		nd_unit_no               [410],
		nd_unit_no_split         [410],// added by sunil
		nd_unit_no_split1        [410],// added by sunil
		nd_unit_no_split2        [410],// added by sunil
		nd_unit_no_seq	         [410],// added by sunil
		nd_rownum_ali			 [410],// added by sunil
		nd_unit_no_gen_yn		 [41],// added by sunil
		nd_blood_group           [41], 
		nd_blood_grp_for_disp    [41],  // added by sunil on 05/01/2010
		nd_blood_group_desc		 [410], // added by sunil on 05/01/2010 
		nd_rhesus_code           [41], 
		nd_rhesus_desc           [410], // added by sunil
		nd_expiry_date           [41],
		nd_expiry_date1          [41], // added by sunil  on 01-Jun-2008 against CRF
		nd_expiry_date2          [41], // added by sunil  on 01-Jun-2008 against CRF
		nd_expiry_date3          [41], // added by sunil  on 01-Jun-2008 against CRF
		nd_screened_legend       [410],
		nd_add_to_stock_yn       [41], // added by sunil  on 01-Jun-2008 against CRF

		d_donation_date         [500][210],
		d_donor_product_code    [500][41], 
		d_donor_unit_no         [500][410],
		d_product_code          [500][41], 
		d_store_instr_desc      [500][1010], 
		d_product_desc          [500][1010], 
		d_unit_no               [500][41],
		d_unit_no_split         [500][41], // added by sunil
		d_unit_no_split1        [500][41], // added by sunil
		d_unit_no_split2        [500][41], // added by sunil
		d_unit_no_seq	        [500][41], // added by sunil
		d_rownum_ali	        [500][410], // added by sunil
		d_unit_no_gen_yn		[500][41],// added by sunil
		d_blood_group           [500][41], 
		d_blood_grp_for_disp    [500][41], 
		d_blood_group_desc		[500][410],// added by sunil on 05/01/2010 
		d_rhesus_code           [500][41], 
		d_rhesus_desc           [500][410],  // added by sunil
		d_expiry_date           [500][41],
		d_expiry_date1          [500][41], // added by sunil  on 01-Jun-2008 against CRF
		d_expiry_date2          [500][41], // added by sunil  on 01-Jun-2008 against CRF
		d_expiry_date3          [500][41],
		d_screened_legend       [500][41],
		d_add_to_stock_yn		[500][41], // added by sunil  on 01-Jun-2008 against CRF

		d_flag					[20],
		er_msg                  [3710], 

/o**************** variables added for label_cur cursor **********o/

		a_ws_no				[410],
		a_cmd_line_arg		[500],
		a_rowid				[410],
		a_pgm_id			[41],
		b_pgm_id			[41], //added by sunil on 18-08-2008
		l_translated_value	[2500],
		language_id			[25],
	
/o**************** variables added for enhancement **********o/

//		nd_file_no				[100],
		nd_print_source_type	[20],
		nd_print_source			[50]; */ 
struct { unsigned short len; unsigned char arr[500]; } uid_pwd;

struct { unsigned short len; unsigned char arr[10]; } nd_source_type;

struct { unsigned short len; unsigned char arr[500]; } nd_fm_source;

struct { unsigned short len; unsigned char arr[4]; } d_no_copy;

struct { unsigned short len; unsigned char arr[30]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[500]; } nd_session_id;

struct { unsigned short len; unsigned char arr[500]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[20]; } nd_trx_ind;

struct { unsigned short len; unsigned char arr[20]; } nd_printer_type;

struct { unsigned short len; unsigned char arr[410]; } d_sample_ind;

struct { unsigned short len; unsigned char arr[410]; } d_fm_unit_no;

struct { unsigned short len; unsigned char arr[410]; } d_fm_product_code;

struct { unsigned short len; unsigned char arr[410]; } d_fm_ch_product_code;

struct { unsigned short len; unsigned char arr[410]; } d_fm_ch_unit_no;

struct { unsigned short len; unsigned char arr[41]; } d_add_stock_yn;

struct { unsigned short len; unsigned char arr[41]; } d_facility_id;

struct { unsigned short len; unsigned char arr[1010]; } d_facility_name;

struct { unsigned short len; unsigned char arr[500]; } d_antigen_date;

struct { unsigned short len; unsigned char arr[500]; } d_antigen_desc;

struct { unsigned short len; unsigned char arr[500]; } d_antigen_desc2;

struct { unsigned short len; unsigned char arr[500]; } d_antigen_desc3;

struct { unsigned short len; unsigned char arr[500]; } d_antigen_desc4;

struct { unsigned short len; unsigned char arr[500]; } d_antigen_desc5;

struct { unsigned short len; unsigned char arr[500]; } d_antigen_desc6;

struct { unsigned short len; unsigned char arr[500]; } d_antigen_desc7;

struct { unsigned short len; unsigned char arr[500]; } d_antigen_desc8;

struct { unsigned short len; unsigned char arr[500]; } d_antigen_desc9;

struct { unsigned short len; unsigned char arr[500]; } d_antigen_desc10;

struct { unsigned short len; unsigned char arr[1010]; } d_unit_barcode_value;

struct { unsigned short len; unsigned char arr[41]; } d_product_code_temp;

struct { unsigned short len; unsigned char arr[1010]; } d_product_desc_temp;

struct { unsigned short len; unsigned char arr[110]; } d_store_instr_code;

struct { unsigned short len; unsigned char arr[1000]; } d_store_instr_desc_temp;

struct { unsigned short len; unsigned char arr[51]; } nd_donation_date;

struct { unsigned short len; unsigned char arr[51]; } nd_donation_date1;

struct { unsigned short len; unsigned char arr[410]; } nd_donor_product_code;

struct { unsigned short len; unsigned char arr[410]; } nd_donor_unit_no;

struct { unsigned short len; unsigned char arr[410]; } nd_product_code;

struct { unsigned short len; unsigned char arr[500]; } nd_bld_grp_rh_barcode;

struct { unsigned short len; unsigned char arr[2500]; } nd_prod_barcode_msg1;

struct { unsigned short len; unsigned char arr[2500]; } nd_prod_barcode_msg2;

struct { unsigned short len; unsigned char arr[200]; } nd_donor_id;

struct { unsigned short len; unsigned char arr[40]; } nd_center_code;

struct { unsigned short len; unsigned char arr[400]; } nd_center_desc;

struct { unsigned short len; unsigned char arr[450]; } nd_product_barcode_value;

struct { unsigned short len; unsigned char arr[410]; } nd_product_long_desc;

struct { unsigned short len; unsigned char arr[20]; } nd_donation_process;

struct { unsigned short len; unsigned char arr[41]; } nd_collection_date;

struct { unsigned short len; unsigned char arr[410]; } nd_volume_units;

struct { unsigned short len; unsigned char arr[410]; } nd_volume_unit;

struct { unsigned short len; unsigned char arr[350]; } d_bld_grp_rh_barcode[20];

struct { unsigned short len; unsigned char arr[2502]; } d_prod_barcode_msg1[20];

struct { unsigned short len; unsigned char arr[2502]; } d_prod_barcode_msg2[20];

struct { unsigned short len; unsigned char arr[4000]; } split_text;

struct { unsigned short len; unsigned char arr[202]; } d_donor_id[20];

struct { unsigned short len; unsigned char arr[42]; } d_center_code[20];

struct { unsigned short len; unsigned char arr[402]; } d_center_desc[40];

struct { unsigned short len; unsigned char arr[1502]; } d_product_barcode_value[20];

struct { unsigned short len; unsigned char arr[550]; } d_product_long_desc[45];

struct { unsigned short len; unsigned char arr[22]; } d_donation_process[20];

struct { unsigned short len; unsigned char arr[40]; } isb_value;

struct { unsigned short len; unsigned char arr[20]; } isb_unit_no_format;

struct { unsigned short len; unsigned char arr[41]; } nd_sys_date;

struct { unsigned short len; unsigned char arr[42]; } d_collection_date[500];

struct { unsigned short len; unsigned char arr[42]; } d_volume_units[500];

struct { unsigned short len; unsigned char arr[42]; } d_volume_unit[500];

struct { unsigned short len; unsigned char arr[1010]; } nd_product_desc;

struct { unsigned short len; unsigned char arr[410]; } nd_unit_no;

struct { unsigned short len; unsigned char arr[410]; } nd_unit_no_split;

struct { unsigned short len; unsigned char arr[410]; } nd_unit_no_split1;

struct { unsigned short len; unsigned char arr[410]; } nd_unit_no_split2;

struct { unsigned short len; unsigned char arr[410]; } nd_unit_no_seq;

struct { unsigned short len; unsigned char arr[410]; } nd_rownum_ali;

struct { unsigned short len; unsigned char arr[41]; } nd_unit_no_gen_yn;

struct { unsigned short len; unsigned char arr[41]; } nd_blood_group;

struct { unsigned short len; unsigned char arr[41]; } nd_blood_grp_for_disp;

struct { unsigned short len; unsigned char arr[410]; } nd_blood_group_desc;

struct { unsigned short len; unsigned char arr[41]; } nd_rhesus_code;

struct { unsigned short len; unsigned char arr[410]; } nd_rhesus_desc;

struct { unsigned short len; unsigned char arr[41]; } nd_expiry_date;

struct { unsigned short len; unsigned char arr[41]; } nd_expiry_date1;

struct { unsigned short len; unsigned char arr[41]; } nd_expiry_date2;

struct { unsigned short len; unsigned char arr[41]; } nd_expiry_date3;

struct { unsigned short len; unsigned char arr[410]; } nd_screened_legend;

struct { unsigned short len; unsigned char arr[41]; } nd_add_to_stock_yn;

struct { unsigned short len; unsigned char arr[210]; } d_donation_date[500];

struct { unsigned short len; unsigned char arr[42]; } d_donor_product_code[500];

struct { unsigned short len; unsigned char arr[410]; } d_donor_unit_no[500];

struct { unsigned short len; unsigned char arr[42]; } d_product_code[500];

struct { unsigned short len; unsigned char arr[1010]; } d_store_instr_desc[500];

struct { unsigned short len; unsigned char arr[1010]; } d_product_desc[500];

struct { unsigned short len; unsigned char arr[42]; } d_unit_no[500];

struct { unsigned short len; unsigned char arr[42]; } d_unit_no_split[500];

struct { unsigned short len; unsigned char arr[42]; } d_unit_no_split1[500];

struct { unsigned short len; unsigned char arr[42]; } d_unit_no_split2[500];

struct { unsigned short len; unsigned char arr[42]; } d_unit_no_seq[500];

struct { unsigned short len; unsigned char arr[410]; } d_rownum_ali[500];

struct { unsigned short len; unsigned char arr[42]; } d_unit_no_gen_yn[500];

struct { unsigned short len; unsigned char arr[42]; } d_blood_group[500];

struct { unsigned short len; unsigned char arr[42]; } d_blood_grp_for_disp[500];

struct { unsigned short len; unsigned char arr[410]; } d_blood_group_desc[500];

struct { unsigned short len; unsigned char arr[42]; } d_rhesus_code[500];

struct { unsigned short len; unsigned char arr[410]; } d_rhesus_desc[500];

struct { unsigned short len; unsigned char arr[42]; } d_expiry_date[500];

struct { unsigned short len; unsigned char arr[42]; } d_expiry_date1[500];

struct { unsigned short len; unsigned char arr[42]; } d_expiry_date2[500];

struct { unsigned short len; unsigned char arr[42]; } d_expiry_date3[500];

struct { unsigned short len; unsigned char arr[42]; } d_screened_legend[500];

struct { unsigned short len; unsigned char arr[42]; } d_add_to_stock_yn[500];

struct { unsigned short len; unsigned char arr[20]; } d_flag;

struct { unsigned short len; unsigned char arr[3710]; } er_msg;

struct { unsigned short len; unsigned char arr[410]; } a_ws_no;

struct { unsigned short len; unsigned char arr[500]; } a_cmd_line_arg;

struct { unsigned short len; unsigned char arr[410]; } a_rowid;

struct { unsigned short len; unsigned char arr[41]; } a_pgm_id;

struct { unsigned short len; unsigned char arr[41]; } b_pgm_id;

struct { unsigned short len; unsigned char arr[2500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[25]; } language_id;

struct { unsigned short len; unsigned char arr[20]; } nd_print_source_type;

struct { unsigned short len; unsigned char arr[50]; } nd_print_source;


  int  d_volume[500],
	nd_volume,
	d_NumOfCopies = 1, // added by sunil  on 27-Aug-2008 against CRF
	d_tot_no_products,
	a = 0,		//added by sunil to use in splitting
	b = 0,		//added by sunil to use in splitting
	h_no_of_rec = 0;

  char string_var	[2000],
	string_var1		[2000],
	v_out_string1	[200],
	v_out_string2	[200],
	v_out_string3	[200],
	v_out_string4	[200],
  	chk_unit		[240],   //added by sunil
	chk_sum			[24];   //added by sunil

	char v_delimeter = ' ';
	
	/* VARCHAR l_temp1  [2100]; */ 
struct { unsigned short len; unsigned char arr[2100]; } l_temp1;

// Added on 28/04/2011 for controlling the printing of previously aliquoted units
/* VARCHAR d_sequence_no [20]; */ 
struct { unsigned short len; unsigned char arr[20]; } d_sequence_no;


/* ADDED ON 04/03/2010 */
  /* VARCHAR	temp_unit_no [100]; */ 
struct { unsigned short len; unsigned char arr[100]; } temp_unit_no;


/*tern  char WORKING_DIR_NAME [75];*/

  int er_msg_type = 0;	
  int err_flag = 0;

  int isb_flag = 0;

  int	i,
  err_flag_sql; //added by sunil 0n 280Mar 2008
  char string_char[2500];
  
  /* VARCHAR l_customer_id [50]; */ 
struct { unsigned short len; unsigned char arr[50]; } l_customer_id;
	 /*-- Addded by Gopikannan for online_barcode_label for MEDICITY --*/ 
  /* VARCHAR nd_printer_queue[200]; */ 
struct { unsigned short len; unsigned char arr[200]; } nd_printer_queue;
 /*-- Addded by Gopikannan for online_barcode_label for MEDICITY --*/
  	
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

FILE *f1,*f2;
char filename[500];
char filename1[500];

char filename2[500];// added by sunil on 18-08-2008
char filename3[500];// added by sunil on 18-08-2008
char ZPLFileName[500];

char *command;  
char gtt_yn = 'N';

char stock_reprint_yn[10];
char nd_stock_product[50];
char nd_stock_unit[50];

char local_legend[20][100];

void proc_main(argc,argv)
int argc;
char *argv[];
{
	//sprintf(string_var,"online_barcode_label");
	//ins_message(ORA_MESG, string_var);	
	
 err_flag = 0;

  if(argc <= 7) 
  {
     ins_message(ERR_MESG,"bdrlabel : Usage - BDRUNTLB UID_PWD SESSION_ID PGM_ID UNIT_NO PRODUCT_CODE FACILITY_ID WS_NO arguments wrong\n");
  }
	
    strcpy(filename,WORKING_DIR);

    strcpy(filename3,WORKING_DIR);// added by sunil on 18-08-2008

    strcpy(a_pgm_id.arr,argv[0]);
    a_pgm_id.len = strlen(a_pgm_id.arr); 

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr); 

	extract_act_user(argv[1]); // added on 27 Mar 2008

    strcpy(nd_session_id.arr, argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
	

    strcpy(a_pgm_id.arr,argv[3]);
    a_pgm_id.len = strlen(a_pgm_id.arr); 


//commented on 29/09/2008    strcpy(filename1, a_pgm_id.arr);
//commented on 29/09/2008    strcat(filename, strcat(filename1, ".lis"));

    if (strcmp(strupr(a_pgm_id.arr), "BDRUNTLB") == 0)
    {

		strcpy(d_fm_unit_no.arr,argv[4]);
		d_fm_unit_no.len = strlen(d_fm_unit_no.arr);
		
    
		strcpy(d_fm_product_code.arr,argv[5]);
		d_fm_product_code.len = strlen(d_fm_product_code.arr);
		

		strcpy(d_facility_id.arr,argv[6]);
		d_facility_id.len = strlen(d_facility_id.arr);

		
		strcpy(nd_ws_no.arr, argv[7]);
		nd_ws_no.len = strlen(nd_ws_no.arr);


		d_NumOfCopies = atoi(argv[8]);

		if (argv[9])
		{
			if (strcmp(argv[9],"AD") == 0) 
			{
				strcpy(d_sample_ind.arr,"AD");
				d_sample_ind.len = strlen(d_sample_ind.arr);

			}
			else
			{
				strcpy(d_sample_ind.arr,"DO");
				d_sample_ind.len = strlen(d_sample_ind.arr);
			}
		}
    }
    else if (strcmp(strupr(a_pgm_id.arr), "BDRSCRLB") == 0)
    {
	strcpy(d_fm_unit_no.arr,argv[4]);
	d_fm_unit_no.len = strlen(d_fm_unit_no.arr);

	strcpy(d_fm_product_code.arr,argv[5]);
	d_fm_product_code.len = strlen(d_fm_product_code.arr);

	strcpy(d_facility_id.arr,argv[6]);
	d_facility_id.len = strlen(d_facility_id.arr);

	strcpy(nd_ws_no.arr, argv[7]);
	nd_ws_no.len = strlen(nd_ws_no.arr);

	d_NumOfCopies = atoi(argv[8]);

		if (strcmp(argv[9],"!!") == 0) // checking for argv from reprint or stock entry
		{
			strcpy(d_add_stock_yn.arr,"Y");
			d_add_stock_yn.len = strlen(d_add_stock_yn.arr);

		}
		else
		{
			strcpy(d_fm_ch_product_code.arr,argv[9]);
			d_fm_ch_product_code.len = strlen(d_fm_ch_product_code.arr);
		}
	}
    else if (strcmp(strupr(a_pgm_id.arr), "BDRUSRLB") == 0)
    {

	strcpy(d_fm_unit_no.arr,argv[4]);
	d_fm_unit_no.len = strlen(d_fm_unit_no.arr);

	strcpy(d_fm_product_code.arr,argv[5]);
	d_fm_product_code.len = strlen(d_fm_product_code.arr);

	strcpy(d_facility_id.arr,argv[6]);
	d_facility_id.len = strlen(d_facility_id.arr);

	strcpy(nd_ws_no.arr, argv[7]);
	nd_ws_no.len = strlen(nd_ws_no.arr);

	d_NumOfCopies = atoi(argv[8]);

    }
//added for aliquot labels
	else if ((strcmp(strupr(a_pgm_id.arr), "BDRALILB") == 0))
    {
	strcpy(d_fm_unit_no.arr,argv[4]);
	d_fm_unit_no.len = strlen(d_fm_unit_no.arr);

	strcpy(d_fm_product_code.arr,argv[5]);
	d_fm_product_code.len = strlen(d_fm_product_code.arr);

	strcpy(d_facility_id.arr,argv[6]);
	d_facility_id.len = strlen(d_facility_id.arr);

	strcpy(nd_ws_no.arr, argv[7]);
	nd_ws_no.len = strlen(nd_ws_no.arr);

	d_NumOfCopies = atoi(argv[8]);
// checking for argv from reprint or stock entry
		if (strcmp(argv[9],"!!")==0) 
		{
			strcpy(stock_reprint_yn,"N");
		}
		else
		{
			strcpy(stock_reprint_yn,"Y");

			strcpy(d_fm_ch_product_code.arr,argv[9]);
			d_fm_ch_product_code.len = strlen(d_fm_ch_product_code.arr);

			strcpy(nd_stock_product, argv[9]);
		}
// checking for argv from reprint or stock entry
		if (strcmp(argv[10],"!!")==0) 
		{
			strcpy(stock_reprint_yn,"N");
		}
		else
		{
			strcpy(stock_reprint_yn,"Y");
			strcpy(nd_stock_unit, argv[10]);

			strcpy(d_fm_ch_unit_no.arr,argv[10]);
			d_fm_ch_unit_no.len = strlen(d_fm_ch_unit_no.arr);
		}

 // Added on 28/04/2011 for controlling the printing of previously aliquoted units
		if (argv[11])
		{
			strcpy(d_sequence_no.arr, argv[11]);
			d_sequence_no.len = strlen(d_sequence_no.arr);
		}

	//	sprintf(string_var, "Sequence    [%s]", d_sequence_no.arr);

    }
//added for screend lables
	else if ((strcmp(strupr(a_pgm_id.arr), "BDRSPRLB") == 0))
    {
	
	strcpy(d_fm_unit_no.arr,argv[4]);
	d_fm_unit_no.len = strlen(d_fm_unit_no.arr);

	strcpy(d_fm_product_code.arr,argv[5]);
	d_fm_product_code.len = strlen(d_fm_product_code.arr);

	strcpy(d_facility_id.arr,argv[6]);
	d_facility_id.len = strlen(d_facility_id.arr);

	strcpy(nd_ws_no.arr, argv[7]);
	nd_ws_no.len = strlen(nd_ws_no.arr);

 	d_NumOfCopies = atoi(argv[8]);
   }
	//added for BT functionality lables
	else if ((strcmp(strupr(a_pgm_id.arr), "BDRCONVL") == 0))
    {
	
	strcpy(d_fm_unit_no.arr,argv[4]);
	d_fm_unit_no.len = strlen(d_fm_unit_no.arr);

	strcpy(d_fm_product_code.arr,argv[5]);
	d_fm_product_code.len = strlen(d_fm_product_code.arr);

	strcpy(d_facility_id.arr,argv[6]);
	d_facility_id.len = strlen(d_facility_id.arr);

	strcpy(nd_ws_no.arr, argv[7]);
	nd_ws_no.len = strlen(nd_ws_no.arr);

	d_NumOfCopies = atoi(argv[8]);
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
    sqlstm.sqhstl[0] = (unsigned int  )502;
    sqlstm.sqhsts[0] = (         int  )502;
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

	//from here added by sunil on 03/12/2007
	/* EXEC SQL EXECUTE
	DECLARE
	t_date   VARCHAR2(50);
	BEGIN
	
		t_date := NVL(GET_LOCALE_DATE_2T.GET_CURRENT_DATE (:language_id, 'MONTH DD YYYY' ),SYSDATE);
 	:nd_sys_date := t_date;
	END;
    END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date VARCHAR2 ( 50 ) ; BEGIN t_date := NVL ( GET_L\
OCALE_DATE_2T . GET_CURRENT_DATE ( :language_id , 'MONTH DD YYYY' ) , SYSDATE \
) ; :nd_sys_date := t_date ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&language_id;
 sqlstm.sqhstl[0] = (unsigned int  )27;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_sys_date;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



    //upto here added by sunil on 03/12/2007

	get_legend_value(14);

	get_site_customer_id();  /*-- Addded by Gopikannan for online_barcode_label for MEDICITY --*/

	get_isb_status();
	
    get_facility_name();

    get_antigen_name();

    get_printer_type();

	get_trans_ind();
	
	

    if (strcmp(strupr(a_pgm_id.arr), "BDRSCRLB") == 0)
    {
      dclr_un_screened_cur();
      while(fetch_un_screened_cur())
	  {
	    get_product_desc();
		if(isb_flag == 1)
		  {
			get_graph_barcode();
			get_center_code();		
			get_donation_details();
			get_label_gen_yn();
			get_unit_no();  		
		   }
        h_no_of_rec = h_no_of_rec + 1;
       }
     }  

    if (strcmp(strupr(a_pgm_id.arr), "BDRCONVL") == 0)
    {
	  dclr_screened_cur();
      while(fetch_screened_cur())
	  {
	    get_product_desc();
		if(isb_flag == 1)
		{
			get_graph_barcode();
			get_center_code();		
			get_donation_details(); 
			get_label_gen_yn(); 		
			get_unit_no();  		
		}
        h_no_of_rec = h_no_of_rec + 1;
      }
     }  

	if (strcmp(strupr(a_pgm_id.arr),"BDRALILB") == 0)
    {

	  dclr_un_screenedali_cur();

      while(fetch_un_screenedali_cur())
	  {
//sprintf(string_var, "3-----> [%s] [%s] - [%s]  [%s] - [%s]", stock_reprint_yn, nd_unit_no.arr, nd_stock_unit,
//						nd_product_code.arr, nd_stock_product);


		if  ( (strcmp(stock_reprint_yn, "N") == 0) || 
			( (strcmp(stock_reprint_yn, "Y") ==0) && (strcmp(nd_unit_no.arr, nd_stock_unit) ==0) &&
				(strcmp(nd_product_code.arr, nd_stock_product) ==0)) )
		{

			get_product_desc();

			if(isb_flag == 1)
			{
				get_graph_barcode();
				get_center_code();		
				get_donation_details();
				get_label_gen_yn();  		
				get_unit_no();  		
			}

	        h_no_of_rec = h_no_of_rec + 1;
		}
      }
    }  

	if (strcmp(strupr(a_pgm_id.arr),"BDRSPRLB") == 0)
    {
	  dclr_screened_cur();
      while(fetch_screened_cur())
	  {
	    get_product_desc();
		if(isb_flag == 1)
		{
			get_graph_barcode();
			get_center_code();		
			get_donation_details();  		
			get_label_gen_yn();
			get_unit_no();  		
		}
        h_no_of_rec = h_no_of_rec + 1;
      }
    } 

	if (strcmp(strupr(a_pgm_id.arr), "BDRUSRLB") == 0)
    {
      dclr_un_screened_cur();
      while(fetch_un_screened_cur())
	  {
	    get_product_desc();
		if(isb_flag == 1)
		  {
			get_graph_barcode();
			get_center_code();		
			get_donation_details();
			get_label_gen_yn();
			get_unit_no();  		
		   }
        h_no_of_rec = h_no_of_rec + 1;
       }
     }  
	
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


    return;

	err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	fclose(f1);
    sprintf(string_var,"%s -> %s\n",d_fm_unit_no.arr, sqlca.sqlerrm.sqlerrmc);
    ins_message(ORA_MESG,string_var);
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


CalculateChecksum(char *inputString)
{
	int ch, sum, charValue, isDigit, isUpperAlpha;
	static char iso7064ValueToCharTable[] ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ*";
	for (sum = 0; ch = *inputString; inputString++)
	{
		isDigit = ((ch >= '0') && (ch <= '9'));
		isUpperAlpha = ((ch >= 'A') && (ch <= 'Z'));
		if (isDigit || isUpperAlpha)
		{
			if (isDigit)
				charValue = ch - '0';
			else
				charValue = ch - 'A' + 10;
		sum = ((sum + charValue) * 2) % 37;
		}
	}
charValue = (38 - sum) % 37;
sprintf(chk_sum,"%c",iso7064ValueToCharTable[charValue]);
}


get_isb_status()
 {

	isb_value.arr[0]	= '\0';
	isb_value.len		= 0;

	isb_unit_no_format.arr[0]	= '\0';/* added on 17/11/2008*/
	isb_unit_no_format.len		= 0;/*added on 17/11/2008*/



	/* EXEC SQL  SELECT USE_ISBT_NUMBERING_YN,nvl(UNIT_NO_FORMAT_IND, 'S') /o added on 17/11/2008o/
	            INTO :isb_value, :isb_unit_no_format /o added on 17/11/2008o/
	            FROM BD_PARAM; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select USE_ISBT_NUMBERING_YN ,nvl(UNIT_NO_FORMAT_IND,'S') in\
to :b0,:b1  from BD_PARAM ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )89;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&isb_value;
 sqlstm.sqhstl[0] = (unsigned int  )42;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&isb_unit_no_format;
 sqlstm.sqhstl[1] = (unsigned int  )22;
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

              

	isb_value.arr[isb_value.len]   = '\0';
	isb_value.len = strlen(isb_value.arr);

	isb_unit_no_format.arr[isb_unit_no_format.len]   = '\0';
	isb_unit_no_format.len = strlen(isb_unit_no_format.arr);

    if(isb_value.arr[0] == 'Y')
	{		
/*from here added by sunil on 29-09-2008*/
	    if (strcmp(strupr(a_pgm_id.arr), "BDRUNTLB") == 0)
		{
			
			//Ravi Shankar, 27/02/2020, GHL-CRF-0580
			if (strcmp(l_customer_id.arr,"MC") == 0) 
			{
				strcpy(filename1, a_pgm_id.arr);
				strcat(filename, strcat(filename1, ".lis"));
			}
			else
			/////////////
			{
				if (strcmp(isb_unit_no_format.arr,"P") == 0)
				{
				strcpy(b_pgm_id.arr,"BDRUNIBT"); 
				b_pgm_id.len = strlen(b_pgm_id.arr); 
				strcpy(filename1, "BDRUNIBP");
				strcat(filename, strcat(filename1, ".lis"));
				}
				else 
				{
					strcpy(b_pgm_id.arr,"BDRUNIBT"); 
					b_pgm_id.len = strlen(b_pgm_id.arr); 
					strcpy(filename1, b_pgm_id.arr);
					strcat(filename, strcat(filename1, ".lis"));
				}
			}

		}
		else if (strcmp(strupr(a_pgm_id.arr), "BDRUSRLB") == 0)
		{
			strcpy(filename1, a_pgm_id.arr);
			strcat(filename, strcat(filename1, ".lis"));
			strcpy(b_pgm_id.arr,"BDRUSRLB");
			b_pgm_id.len = strlen(b_pgm_id.arr); 
		}
		else
		{
			strcpy(b_pgm_id.arr,"BDRSCIBT");
			b_pgm_id.len = strlen(b_pgm_id.arr); 
			strcpy(filename1, b_pgm_id.arr);
			strcat(filename, strcat(filename1, ".lis"));
		}
/*upto here added by sunil on 29-09-2008*/
		//Ravi Shankar, 27/02/2020, GHL-CRF-0580
		if ( (strcmp(strupr(a_pgm_id.arr), "BDRUNTLB") == 0) && (strcmp(l_customer_id.arr,"MC") == 0) )
			isb_flag= 0;
		else
		//////////////
			isb_flag = 1;
	}
	else
	{
		strcpy(filename1, a_pgm_id.arr);// added by sunil on 29-09-2008
		strcat(filename, strcat(filename1, ".lis"));// added by sunil on 29-09-2008
		isb_flag= 0;
	}
	if(OERROR)
	{
		sprintf(string_var,"%s get_isb_status()-> %s\n", isb_value, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
    {
      isb_value.arr[isb_value.len]   = '\0';
      isb_value.len = strlen(isb_value.arr);
    }

 }


get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:d_facility_id,:language_id,'BDRLBPRN.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :d_facility\
_id , :language_id , 'BDRLBPRN.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )112;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&language_id;
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



	for (i=1; i<=cou; i++)
	{
		l_translated_value.arr[0]		= '\0';
		/* EXEC SQL EXECUTE
		BEGIN
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('BDRLBPRN.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 4;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( '\
BDRLBPRN.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )135;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
  sqlstm.sqhstl[0] = (unsigned int  )2502;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&i;
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


	
		l_translated_value.arr[l_translated_value.len] = '\0';
		
		
		strcpy(local_legend[i],l_translated_value.arr);
		
	}
 }

//ADDED FOR SCREENED CURSOR
dclr_screened_cur()
{
		/* EXEC SQL DECLARE c_screen CURSOR FOR
                       SELECT a.donation_date,
							  a.product_code, 
                              a.unit_no,
							  a.blood_group,
                              NVL(d.blood_grp_for_disp, a.blood_group) blood_grp_for_disp, /o added by sunil on 05/01/2010o/
							  NVL(d.blood_group_desc, ' ') blood_group_desc, /o added by sunil on 05/01/2010o/
                  	          a.rhesus_code,
							  b.long_desc,
                              a.Current_Volume,
							  c.short_desc volume_units,
							  a.volume_units volume_unit,
                              a.expiry_date
							  FROM
							  (SELECT TO_CHAR(donation_date, 'DD/MM/YYYY') donation_date,
							  		  product_code, 
									  unit_no,
                              		  blood_group,
                  	          		  rhesus_code,
							  		  Current_Volume,
							  		  volume_units,
                              		  TO_CHAR(expiry_date, 'DDMMYYYY HH24:MI') expiry_date
                       			FROM   BD_BLOOD_UNITS_MAST
		                        WHERE  unit_no = :d_fm_unit_no
							    AND    Product_code = :d_fm_product_code
							    AND    operating_facility_id = :d_facility_id) a, 
								(SELECT rhesus_code, long_desc 
								from BT_RHESUS_CODE_MAST_LANG_VW
								WHERE language_id = :language_id) b,
								(SELECT uom_code, short_desc
								FROM BT_UOM_MAST_LANG_VW
								WHERE language_id = :language_id) c,
								(SELECT NVL(b.blood_group, a.blood_group) blood_group, NVL(b.blood_grp_for_disp, a.blood_group) blood_grp_for_disp, NVL(b.disp_long_desc, a.long_desc) blood_group_desc
								FROM BT_BLOOD_GROUP_MAST_LANG_VW a, BD_BLOOD_GRP_DESC_MAST_LANG_VW b
								WHERE a.blood_group = b.blood_group(+)
								AND a.language_id = b.language_id(+)
								AND a.language_id = :language_id) d /o added by sunil on 05/01/2010 o/
								WHERE  a.rhesus_code = b.rhesus_code
					   			AND a.volume_units = c.uom_code(+)
								AND	a.blood_group = d.blood_group(+); */ 
 /* added by sunil on 05/01/2010 */

/* above code added on 19/09/2008 for picking up volume desc
                      SELECT a.donation_date,
							  a.product_code, 
                              a.unit_no,
                              a.blood_group,
                  	          a.rhesus_code,
							  b.long_desc,
                              a.Current_Volume,
							  a.volume_units,
                              TO_CHAR(a.expiry_date, 'DDMMYYYY HH24:MI')
                       FROM   BD_BLOOD_UNITS_MAST  a, BT_RHESUS_CODE_MAST_LANG_VW b
                       WHERE  a.unit_no = :d_fm_unit_no
                       AND    a.Product_code = :d_fm_product_code
                       AND    a.operating_facility_id = :d_facility_id
					   AND	  a.rhesus_code = b.rhesus_code
					   AND	  b.language_id= :language_id;
*/					   
		/* EXEC SQL OPEN c_screen; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select a.donation_date ,a.product_code ,a.unit_no ,a.blood_group ,NVL(d\
.blood_grp_for_disp,a.blood_group) blood_grp_for_disp ,NVL(d.blood_group_des\
c,' ') blood_group_desc ,a.rhesus_code ,b.long_desc ,a.Current_Volume ,c.sho\
rt_desc volume_units ,a.volume_units volume_unit ,a.expiry_date  from (selec\
t TO_CHAR(donation_date,'DD/MM/YYYY') donation_date ,product_code ,unit_no ,\
blood_group ,rhesus_code ,Current_Volume ,volume_units ,TO_CHAR(expiry_date,\
'DDMMYYYY HH24:MI') expiry_date  from BD_BLOOD_UNITS_MAST where ((unit_no=:b\
0 and Product_code=:b1) and operating_facility_id=:b2)) a ,(select rhesus_co\
de ,long_desc  from BT_RHESUS_CODE_MAST_LANG_VW where language_id=:b3) b ,(s\
elect uom_code ,short_desc  from BT_UOM_MAST_LANG_VW where language_id=:b3) \
c ,(select NVL(b.blood_group,a.blood_group) blood_group ,NVL(b.blood_grp_for\
_disp,a.blood_group) blood_grp_for_disp ,NVL(b.disp_long_desc,a.long_desc) b\
lood_group_desc  from BT_BLOOD_GROUP_MAST_LANG_VW a ,BD_BLOOD_GRP_DESC_MAST_\
LANG_VW b where ((a.blood_group=b.blood_g");
  sqlstm.stmt = sq0008;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )158;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_fm_unit_no;
  sqlstm.sqhstl[0] = (unsigned int  )412;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_fm_product_code;
  sqlstm.sqhstl[1] = (unsigned int  )412;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&language_id;
  sqlstm.sqhstl[3] = (unsigned int  )27;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&language_id;
  sqlstm.sqhstl[4] = (unsigned int  )27;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&language_id;
  sqlstm.sqhstl[5] = (unsigned int  )27;
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
        ins_message (ORA_MESG, "OPEN Cursor c_scr Failed ");
    }
}

dclr_un_screenedali_cur()
{

//sprintf(string_var, "[%s]  [%s]  [%s] ", d_sequence_no.arr, d_fm_ch_unit_no.arr, d_fm_ch_product_code.arr);

		/* EXEC SQL DECLARE c_scr_ali CURSOR FOR
                       SELECT A.donation_date, 
					          A.A_product_code, 
                              A.A_unit_no,
							  A.blood_group,
                              NVL(D.blood_grp_for_disp, A.blood_group) blood_grp_for_disp, /o added by sunil on 05/01/2010o/
							  NVL(D.blood_group_desc, ' ') blood_group_desc, /o added by sunil on 05/01/2010o/
                  	          A.rhesus_code,
							  B.long_desc,
                              A.A_Volume,
							  C.short_desc volume_units,
							  A.volume_units volume_unit,
                              A.expiry_date,
							  rownum
					   FROM
					   (SELECT TO_CHAR(B.donation_date, 'DD/MM/YYYY') donation_date,
					          A.A_product_code, 
                              A.A_unit_no,
                              B.blood_group,
                  	          B.rhesus_code,
							  A.A_Volume,
							  b.volume_units,
                              TO_CHAR(B.expiry_date, 'DDMMYYYY HH24:MI') expiry_date
						FROM   BD_ALIQUOT_UNITS A,BD_BLOOD_UNITS_MAST B
						WHERE  A.unit_no = :d_fm_unit_no
                        AND    A.Product_code = :d_fm_product_code
                        AND    A.operating_facility_id = :d_facility_id
						AND ( ( :a_pgm_id = 'BDRALILB') AND ( (:d_sequence_no IS NOT NULL AND A.seq_no = TO_NUMBER(:d_sequence_no) )
		                                                  OR (A_unit_no = :d_fm_ch_unit_no AND A_product_code = :d_fm_ch_product_code) ) )
//			AND  ((:a_pgm_id = 'BDRALILB') AND A.seq_no = NVL(TO_NUMBER(:d_sequence_no), 0))
					    AND    A.Product_code=B.Product_code
					    AND    A.Unit_no=B.unit_no ) a,
						(SELECT rhesus_code, long_desc 
								from BT_RHESUS_CODE_MAST_LANG_VW
								WHERE language_id = :language_id) b,
						(SELECT uom_code, short_desc
								FROM BT_UOM_MAST_LANG_VW
								WHERE language_id = :language_id) c,
						(SELECT NVL(b.blood_group, a.blood_group) blood_group, NVL(b.blood_grp_for_disp, a.blood_group) blood_grp_for_disp, NVL(b.disp_long_desc, a.long_desc) blood_group_desc
								FROM BT_BLOOD_GROUP_MAST_LANG_VW a, BD_BLOOD_GRP_DESC_MAST_LANG_VW b
								WHERE a.blood_group = b.blood_group(+)
								AND a.language_id = b.language_id(+)
								AND a.language_id = :language_id) d /o added by sunil on 05/01/2010 o/
						WHERE  a.rhesus_code = b.rhesus_code
			   			AND	a.volume_units= c.uom_code(+)
						AND	a.blood_group = d.blood_group(+) /o added by sunil on 05/01/2010 o/
						ORDER BY a_unit_no, a_product_code; */ 
		

/* below code commented and above code added on 19-09-2008 to pich up volume unit short desc
                       SELECT TO_CHAR(B.donation_date, 'DD/MM/YYYY'),
					          A.A_product_code, 
                              A.A_unit_no,
                              B.blood_group,
                  	          B.rhesus_code,
							  C.long_desc,
                              A.A_Volume,
							  b.volume_units,
                              TO_CHAR(B.expiry_date, 'DDMMYYYY HH24:MI'),
							  rownum
                       FROM   BD_ALIQUOT_UNITS A,BD_BLOOD_UNITS_MAST B, BT_RHESUS_CODE_MAST_LANG_VW C
                       WHERE  A.unit_no = :d_fm_unit_no
                       AND    A.Product_code = :d_fm_product_code
                       AND    A.operating_facility_id = :d_facility_id
					   AND    A.Product_code=B.Product_code
					   AND    A.Unit_no=B.unit_no
					   AND	  B.rhesus_code = C.rhesus_code
					   AND	  C.Language_id = :language_id;
*/
		/* EXEC SQL OPEN c_scr_ali; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 11;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select A.donation_date ,A.A_product_code ,A.A_unit_no ,A.blood_group ,N\
VL(D.blood_grp_for_disp,A.blood_group) blood_grp_for_disp ,NVL(D.blood_group\
_desc,' ') blood_group_desc ,A.rhesus_code ,B.long_desc ,A.A_Volume ,C.short\
_desc volume_units ,A.volume_units volume_unit ,A.expiry_date ,rownum  from \
(select TO_CHAR(B.donation_date,'DD/MM/YYYY') donation_date ,A.A_product_cod\
e ,A.A_unit_no ,B.blood_group ,B.rhesus_code ,A.A_Volume ,b.volume_units ,TO\
_CHAR(B.expiry_date,'DDMMYYYY HH24:MI') expiry_date  from BD_ALIQUOT_UNITS A\
 ,BD_BLOOD_UNITS_MAST B where (((((A.unit_no=:b0 and A.Product_code=:b1) and\
 A.operating_facility_id=:b2) and (:b3='BDRALILB' and ((:b4 is  not null  an\
d A.seq_no=TO_NUMBER(:b4)) or (A_unit_no=:b6 and A_product_code=:b7)))) and \
A.Product_code=B.Product_code) and A.Unit_no=B.unit_no)) a ,(select rhesus_c\
ode ,long_desc  from BT_RHESUS_CODE_MAST_LANG_VW where language_id=:b8) b ,(\
select uom_code ,short_desc  from BT_UOM_MAST_LANG_VW where language_id=:b8)\
 c ,(select NVL(b.blood_group,a.blood_gro");
  sqlstm.stmt = sq0009;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )197;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_fm_unit_no;
  sqlstm.sqhstl[0] = (unsigned int  )412;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_fm_product_code;
  sqlstm.sqhstl[1] = (unsigned int  )412;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&a_pgm_id;
  sqlstm.sqhstl[3] = (unsigned int  )43;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_sequence_no;
  sqlstm.sqhstl[4] = (unsigned int  )22;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_sequence_no;
  sqlstm.sqhstl[5] = (unsigned int  )22;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_fm_ch_unit_no;
  sqlstm.sqhstl[6] = (unsigned int  )412;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_fm_ch_product_code;
  sqlstm.sqhstl[7] = (unsigned int  )412;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&language_id;
  sqlstm.sqhstl[8] = (unsigned int  )27;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&language_id;
  sqlstm.sqhstl[9] = (unsigned int  )27;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&language_id;
  sqlstm.sqhstl[10] = (unsigned int  )27;
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


  
    if (OERROR) 
	{
        ins_message (ORA_MESG, "OPEN Cursor c_scr Failed ");
    }

}


dclr_un_screened_cur()
{
		/* EXEC SQL DECLARE c_scr CURSOR FOR
                       SELECT A.donation_date,
                              A.donor_product_code, 
                              A.donor_unit_no,
                              A.product_code, 
                              A.unit_no, 
							  A.blood_group,
                              NVL(D.blood_grp_for_disp, A.blood_group) blood_grp_for_disp, /o added by sunil on 05/01/2010o/
							  NVL(D.blood_group_desc, ' ') blood_group_desc, /o added by sunil on 05/01/2010o/
							  A.rhesus_code,
							  B.long_desc,
                              A.unit_measured_wt,
							  C.short_desc volume_units,
							  A.volume_units volume_unit,
                              A.expiry_date,
                              A.accepted_yn,
							  A.add_to_stock_yn
					   FROM 
					   (      SELECT TO_CHAR(donation_date, 'DD/MM/YYYY') donation_date,
                              donor_product_code, 
                              donor_unit_no,
                              product_code, 
                              unit_no, 
							  Decode (:a_pgm_id, 'BDRSCRLB', rlst_blood_group,  blood_group) blood_group, 
							  Decode (:a_pgm_id, 'BDRSCRLB', rlst_rhesus_code,  rhesus_code) rhesus_code, 
							  nvl(Decode (:a_pgm_id, 'BDRUSRLB',unit_measured_wt, volume),0) unit_measured_wt,
							  Decode (:a_pgm_id, 'BDRUSRLB','', volume_units) volume_units,
                              TO_CHAR(expiry_date, 'DDMMYYYYHH24:MI') expiry_date,
                              DECODE( NVL(accepted_yn, 'N'), 'N', 'Unscreened', 'Y', 'Screened') accepted_yn,
							  NVL(add_to_stock_yn, 'N') add_to_stock_yn
                       		  FROM   bd_component_label_vw
                       		  WHERE  donor_unit_no = :d_fm_unit_no
                       		  AND    donor_product_code = :d_fm_product_code 
                       		  AND    operating_facility_id = :d_facility_id
					   		  AND    ( ( :a_pgm_id = 'BDRSCRLB' AND NVL(add_to_stock_yn, 'N') = NVL(:d_add_stock_yn,NVL(add_to_stock_yn, 'N')) )
					          		   OR (  :a_pgm_id = 'BDRUSRLB' AND 1=1)
					          		   OR (  :a_pgm_id = 'BDRUNTLB' AND 1=1)
					          		   )
							  AND product_code = nvl(:d_fm_ch_product_code, product_code)		   
						) A,  
						(SELECT RHESUS_CODE , LONG_DESC FROM BT_RHESUS_CODE_MAST_LANg_vW 
								WHERE    Language_id = :language_id
						)B,
						(SELECT UOM_CODE, SHORT_DESC FROM BT_UOM_MAST_LANG_VW
								WHERE language_id = :language_id
						) C,
						(SELECT NVL(b.blood_group, a.blood_group) blood_group, NVL(b.blood_grp_for_disp, a.blood_group) blood_grp_for_disp, NVL(b.disp_long_desc, a.long_desc) blood_group_desc
								FROM BT_BLOOD_GROUP_MAST_LANG_VW a, BD_BLOOD_GRP_DESC_MAST_LANG_VW b
								WHERE a.blood_group = b.blood_group(+)
								AND a.language_id = b.language_id(+)
								AND a.language_id = :language_id
						) D /o added by sunil on 05/01/2010 o/
						WHERE A.RHESUS_CODE = B.RHESUS_CODE(+)
						AND	A.VOLUME_UNITS = C.UOM_CODE(+)
						AND	A.blood_group = D.blood_group(+) /o added by sunil on 05/01/2010 o/
						ORDER BY A.unit_no, A.product_code; */ 
	
									
/*
                       SELECT TO_CHAR(A.donation_date, 'DD/MM/YYYY'),
                              A.donor_product_code, 
                              A.donor_unit_no,
                              A.product_code, 
                              A.unit_no, 
*/							  /*A.blood_group,  --commented on 10-Mar -2008 by sunil 
							  A.rhesus_code,   -- below code added to fetch resultant blood group and rhesus code */
/*							  Decode (:a_pgm_id, 'BDRSCRLB', A.rlst_blood_group, A.blood_group) blood_group, 
							  Decode (:a_pgm_id, 'BDRSCRLB',A.rlst_rhesus_code, A.rhesus_code) rhesus_code,
							  B.long_desc,
                              A.unit_measured_wt,
                              TO_CHAR(A.expiry_date, 'DD/MM/YYYY'),
                              DECODE( NVL(A.accepted_yn, 'N'), 'N', 'Unscreened', 'Y', 'Screened')
                       FROM   bd_component_label_vw A, BT_RHESUS_CODE_MAST_LANg_vW b
                       WHERE  Decode (:a_pgm_id, 'BDRSCRLB',A.rlst_rhesus_code, A.rhesus_code) = B.rhesus_code(+)
					   AND	  A.donor_unit_no = :d_fm_unit_no
                       AND    A.donor_product_code = :d_fm_product_code 
                       AND    A.operating_facility_id = :d_facility_id
					   AND    ( ( :a_pgm_id = 'BDRSCRLB' AND NVL(A.add_to_stock_yn, 'N') = 'Y' )
					          OR (  :a_pgm_id = 'BDRUSRLB' AND 1=1)
					          OR (  :a_pgm_id = 'BDRUNTLB' AND 1=1)
					          )
					   --AND    B.Language_id = :language_id
					   AND  ( ( Nvl(B.Language_id,'!!') = Nvl(:language_id,'!!') AND B.LANGUAGE_ID IS NOT NULL) OR B.LANGUAGE_ID IS NULL) ; 

*/
		/* EXEC SQL OPEN c_scr; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 15;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlbuft((void **)0, 
    "select A.donation_date ,A.donor_product_code ,A.donor_unit_no ,A.produc\
t_code ,A.unit_no ,A.blood_group ,NVL(D.blood_grp_for_disp,A.blood_group) bl\
ood_grp_for_disp ,NVL(D.blood_group_desc,' ') blood_group_desc ,A.rhesus_cod\
e ,B.long_desc ,A.unit_measured_wt ,C.short_desc volume_units ,A.volume_unit\
s volume_unit ,A.expiry_date ,A.accepted_yn ,A.add_to_stock_yn  from (select\
 TO_CHAR(donation_date,'DD/MM/YYYY') donation_date ,donor_product_code ,dono\
r_unit_no ,product_code ,unit_no ,Decode(:b0,'BDRSCRLB',rlst_blood_group,blo\
od_group) blood_group ,Decode(:b0,'BDRSCRLB',rlst_rhesus_code,rhesus_code) r\
hesus_code ,nvl(Decode(:b0,'BDRUSRLB',unit_measured_wt,volume),0) unit_measu\
red_wt ,Decode(:b0,'BDRUSRLB','',volume_units) volume_units ,TO_CHAR(expiry_\
date,'DDMMYYYYHH24:MI') expiry_date ,DECODE(NVL(accepted_yn,'N'),'N','Unscre\
ened','Y','Screened') accepted_yn ,NVL(add_to_stock_yn,'N') add_to_stock_yn \
 from bd_component_label_vw where ((((donor_unit_no=:b4 and donor_product_co\
de=:b5) and operating_facility_id=:b6) an");
  sqlstm.stmt = sq0010;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )256;
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
  sqlstm.sqhstv[1] = (         void  *)&a_pgm_id;
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
  sqlstm.sqhstv[3] = (         void  *)&a_pgm_id;
  sqlstm.sqhstl[3] = (unsigned int  )43;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_fm_unit_no;
  sqlstm.sqhstl[4] = (unsigned int  )412;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_fm_product_code;
  sqlstm.sqhstl[5] = (unsigned int  )412;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[6] = (unsigned int  )43;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&a_pgm_id;
  sqlstm.sqhstl[7] = (unsigned int  )43;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_add_stock_yn;
  sqlstm.sqhstl[8] = (unsigned int  )43;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&a_pgm_id;
  sqlstm.sqhstl[9] = (unsigned int  )43;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&a_pgm_id;
  sqlstm.sqhstl[10] = (unsigned int  )43;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_fm_ch_product_code;
  sqlstm.sqhstl[11] = (unsigned int  )412;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&language_id;
  sqlstm.sqhstl[12] = (unsigned int  )27;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&language_id;
  sqlstm.sqhstl[13] = (unsigned int  )27;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&language_id;
  sqlstm.sqhstl[14] = (unsigned int  )27;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
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
        ins_message (ORA_MESG, "OPEN Cursor c_scr Failed ");
    }
}

int fetch_un_screened_cur()
{

  nd_donation_date.arr[0] = '\0';
  nd_donation_date.len = 0;

  nd_donor_product_code.arr[0] = '\0';
  nd_donor_product_code.len = 0;


  nd_donor_unit_no.arr[0] = '\0';
  nd_donor_unit_no.len = 0;

  nd_product_code.arr[0] = '\0';
  nd_product_code.len = 0;

  nd_unit_no.arr[0] = '\0';
  nd_unit_no.len = 0;


  nd_blood_group.arr[0] = '\0';
  nd_blood_group.len = 0;

  nd_blood_grp_for_disp.arr[0] = '\0'; /*added by sunil on 05/01/2010 */
  nd_blood_grp_for_disp.len = 0; /*added by sunil on 05/01/2010 */

  nd_blood_group_desc.arr[0] = '\0'; /*added by sunil on 05/01/2010 */
  nd_blood_group_desc.len = 0; /*added by sunil on 05/01/2010 */

  nd_rhesus_code.arr[0] = '\0';
  nd_rhesus_code.len = 0;

  nd_rhesus_desc.arr[0] = '\0';
  nd_rhesus_desc.len = 0;

  nd_expiry_date.arr[0] = '\0';
  nd_expiry_date.len = 0;

  nd_expiry_date1.arr[0] = '\0';
  nd_expiry_date1.len = 0;

  nd_expiry_date2.arr[0] = '\0';
  nd_expiry_date2.len = 0;

  nd_expiry_date3.arr[0] = '\0';
  nd_expiry_date3.len = 0;

  nd_screened_legend.arr[0] = '\0';
  nd_screened_legend.len = 0;

  nd_volume_units.arr[0] = '\0';
  nd_volume_units.len = 0;
 
  nd_volume_unit.arr[0] = '\0';
  nd_volume_unit.len = 0;

  nd_add_to_stock_yn.arr[0] = '\0';
  nd_add_to_stock_yn.len = 0;


  /* EXEC SQL FETCH c_scr INTO
                        :nd_donation_date,
                        :nd_donor_product_code,
                        :nd_donor_unit_no,
                        :nd_product_code,
                        :nd_unit_no,
                        :nd_blood_group,
						:nd_blood_grp_for_disp, /oadded by sunil on 05/01/2010o/
						:nd_blood_group_desc, /oadded by sunil on 05/01/2010o/
                        :nd_rhesus_code,
						:nd_rhesus_desc,
						:nd_volume,
						:nd_volume_units,
						:nd_volume_unit,
                        :nd_expiry_date,
                        :nd_screened_legend,
						:nd_add_to_stock_yn; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )331;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_donation_date;
  sqlstm.sqhstl[0] = (unsigned int  )53;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_donor_product_code;
  sqlstm.sqhstl[1] = (unsigned int  )412;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_donor_unit_no;
  sqlstm.sqhstl[2] = (unsigned int  )412;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_product_code;
  sqlstm.sqhstl[3] = (unsigned int  )412;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_unit_no;
  sqlstm.sqhstl[4] = (unsigned int  )412;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_blood_group;
  sqlstm.sqhstl[5] = (unsigned int  )43;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_blood_grp_for_disp;
  sqlstm.sqhstl[6] = (unsigned int  )43;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_blood_group_desc;
  sqlstm.sqhstl[7] = (unsigned int  )412;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_rhesus_code;
  sqlstm.sqhstl[8] = (unsigned int  )43;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_rhesus_desc;
  sqlstm.sqhstl[9] = (unsigned int  )412;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_volume;
  sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_volume_units;
  sqlstm.sqhstl[11] = (unsigned int  )412;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&nd_volume_unit;
  sqlstm.sqhstl[12] = (unsigned int  )412;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&nd_expiry_date;
  sqlstm.sqhstl[13] = (unsigned int  )43;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&nd_screened_legend;
  sqlstm.sqhstl[14] = (unsigned int  )412;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&nd_add_to_stock_yn;
  sqlstm.sqhstl[15] = (unsigned int  )43;
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
	{
//		sprintf(string_var,"%s get_facility_name()-> %s\n", d_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
        ins_message (ORA_MESG, "FETCH failed c2 ");
		return 0;
      }

    if (NO_DATA_FOUND)
       return 0;
	   
 
  nd_donation_date.arr[nd_donation_date.len] = '\0';
  nd_donation_date.len = strlen(nd_donation_date.arr);

  nd_donor_product_code.arr[nd_donor_product_code.len] = '\0';
  nd_donor_product_code.len = strlen(nd_donor_product_code.arr);

  nd_donor_unit_no.arr[nd_donor_unit_no.len] = '\0';
  nd_donor_unit_no.len = strlen(nd_donor_product_code.arr);

  nd_product_code.arr[nd_product_code.len] = '\0';
  nd_product_code.len = strlen(nd_product_code.arr);

  nd_unit_no.arr[nd_unit_no.len] = '\0';
  nd_unit_no.len = strlen(nd_unit_no.arr);

  nd_blood_group.arr[nd_blood_group.len] = '\0';
  nd_blood_group.len = strlen(nd_blood_group.arr);

  nd_blood_grp_for_disp.arr[nd_blood_grp_for_disp.len] = '\0';/*added by sunil on 05/01/2010*/
  nd_blood_grp_for_disp.len = strlen(nd_blood_grp_for_disp.arr);/*added by sunil on 05/01/2010*/

  nd_blood_group_desc.arr[nd_blood_group_desc.len] = '\0';/*added by sunil on 05/01/2010*/
  nd_blood_group_desc.len = strlen(nd_blood_group_desc.arr);/*added by sunil on 05/01/2010*/

  nd_rhesus_code.arr[nd_rhesus_code.len] = '\0';
  nd_rhesus_code.len = strlen(nd_rhesus_code.arr);

  nd_rhesus_desc.arr[nd_rhesus_desc.len] = '\0';
  nd_rhesus_desc.len = strlen(nd_rhesus_desc.arr);

  nd_expiry_date.arr[nd_expiry_date.len] = '\0';
  nd_expiry_date.len = strlen(nd_expiry_date.arr);

  nd_expiry_date1.arr[nd_expiry_date1.len] = '\0';
  nd_expiry_date1.len = strlen(nd_expiry_date1.arr);

  nd_expiry_date2.arr[nd_expiry_date2.len] = '\0';
  nd_expiry_date2.len = strlen(nd_expiry_date2.arr);

  nd_expiry_date3.arr[nd_expiry_date3.len] = '\0';
  nd_expiry_date3.len = strlen(nd_expiry_date3.arr);

  nd_screened_legend.arr[nd_screened_legend.len] = '\0';
  nd_screened_legend.len = strlen(nd_screened_legend.arr);

  nd_volume_units.arr[nd_volume_units.len] = '\0';
  nd_volume_units.len = strlen(nd_volume_units.arr);

  nd_volume_unit.arr[nd_volume_unit.len] = '\0';
  nd_volume_unit.len = strlen(nd_volume_unit.arr);

  nd_add_to_stock_yn.arr[nd_add_to_stock_yn.len] = '\0';
  nd_add_to_stock_yn.len = strlen(nd_add_to_stock_yn.arr);

/* EXEC SQL EXECUTE
	DECLARE
	t_date   VARCHAR2(50);
	BEGIN
	GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (to_date(:nd_donation_date,'DD/MM/YYYY'), :language_id , t_date);
	:nd_donation_date1 := t_date;
	END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 16;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare t_date VARCHAR2 ( 50 ) ; BEGIN GET_LOCALE_DATE_2T . C\
ONVERT_TO_LOCALE_DATE ( to_date ( :nd_donation_date , 'DD/MM/YYYY' ) , :langua\
ge_id , t_date ) ; :nd_donation_date1 := t_date ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )410;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_donation_date;
sqlstm.sqhstl[0] = (unsigned int  )53;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&language_id;
sqlstm.sqhstl[1] = (unsigned int  )27;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_donation_date1;
sqlstm.sqhstl[2] = (unsigned int  )53;
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




/*
  sprintf(d_donation_date[h_no_of_rec].arr,"%s", nd_donation_date1.arr);
  d_donation_date[h_no_of_rec].len = strlen(d_donation_date[h_no_of_rec].arr);

  sprintf(d_donor_product_code[h_no_of_rec].arr,"%s", nd_donor_product_code.arr);
  d_donor_product_code[h_no_of_rec].len = strlen(d_donor_product_code[h_no_of_rec].arr);

  sprintf(d_donor_unit_no[h_no_of_rec].arr,"%s", nd_donor_unit_no.arr);
  d_donor_unit_no[h_no_of_rec].len = strlen(d_donor_product_code[h_no_of_rec].arr);

  sprintf(d_product_code[h_no_of_rec].arr,"%s", nd_product_code.arr);
  d_product_code[h_no_of_rec].len = strlen(d_product_code[h_no_of_rec].arr);

  sprintf(d_unit_no[h_no_of_rec].arr,"%s", nd_unit_no.arr);
  d_unit_no[h_no_of_rec].len = strlen(d_unit_no[h_no_of_rec].arr);

  sprintf(d_blood_group[h_no_of_rec].arr,"%s", nd_blood_group.arr);
  d_blood_group[h_no_of_rec].len = strlen(d_blood_group[h_no_of_rec].arr);

  sprintf(d_rhesus_code[h_no_of_rec].arr,"%s", nd_rhesus_code.arr);
  d_rhesus_code[h_no_of_rec].len = strlen(d_rhesus_code[h_no_of_rec].arr);

  sprintf(d_rhesus_desc[h_no_of_rec].arr,"%s", nd_rhesus_desc.arr);
  d_rhesus_desc[h_no_of_rec].len = strlen(d_rhesus_desc[h_no_of_rec].arr);
*/



  strcpy(d_donation_date[h_no_of_rec].arr, nd_donation_date1.arr);
  d_donation_date[h_no_of_rec].len = strlen(d_donation_date[h_no_of_rec].arr);

  strcpy(d_donor_product_code[h_no_of_rec].arr, nd_donor_product_code.arr);
  d_donor_product_code[h_no_of_rec].len = strlen(d_donor_product_code[h_no_of_rec].arr);

  strcpy(d_donor_unit_no[h_no_of_rec].arr, nd_donor_unit_no.arr);
  d_donor_unit_no[h_no_of_rec].len = strlen(d_donor_product_code[h_no_of_rec].arr);

  strcpy(d_product_code[h_no_of_rec].arr, nd_product_code.arr);
  d_product_code[h_no_of_rec].len = strlen(d_product_code[h_no_of_rec].arr);

  strcpy(d_unit_no[h_no_of_rec].arr, nd_unit_no.arr);
  d_unit_no[h_no_of_rec].len = strlen(d_unit_no[h_no_of_rec].arr);

  strcpy(d_blood_group[h_no_of_rec].arr, nd_blood_group.arr);
  d_blood_group[h_no_of_rec].len = strlen(d_blood_group[h_no_of_rec].arr);

  strcpy(d_blood_grp_for_disp[h_no_of_rec].arr, nd_blood_grp_for_disp.arr);/*added by sunil on 05/01/2010*/
  d_blood_grp_for_disp[h_no_of_rec].len = strlen(d_blood_grp_for_disp[h_no_of_rec].arr);/*added by sunil on 05/01/2010*/

  strcpy(d_blood_group_desc[h_no_of_rec].arr, nd_blood_group_desc.arr);/*added by sunil on 05/01/2010*/
  d_blood_group_desc[h_no_of_rec].len = strlen(d_blood_group_desc[h_no_of_rec].arr);/*added by sunil on 05/01/2010*/

  strcpy(d_rhesus_code[h_no_of_rec].arr, nd_rhesus_code.arr);
  d_rhesus_code[h_no_of_rec].len = strlen(d_rhesus_code[h_no_of_rec].arr);

  strcpy(d_rhesus_desc[h_no_of_rec].arr, nd_rhesus_desc.arr);
  d_rhesus_desc[h_no_of_rec].len = strlen(d_rhesus_desc[h_no_of_rec].arr);



/* EXEC SQL EXECUTE
	DECLARE
	s_date   VARCHAR2(50);
	l_date date;
	BEGIN
	l_date := to_date(:nd_expiry_date,'DD/MM/YYYY HH24:MI');

	GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (l_date, :language_id , s_date);
	:nd_expiry_date1 := s_date;

	GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (l_date, :language_id , s_date, 'DDMMYYYYHH24MI');
	:nd_expiry_date2 := s_date;

	GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (l_date, :language_id , s_date, 'DD Mon YYYY HH24:MI');
	:nd_expiry_date3 := s_date;

	END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 16;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare s_date VARCHAR2 ( 50 ) ; l_date date ; BEGIN l_date :\
= to_date ( :nd_expiry_date , 'DD/MM/YYYY HH24:MI' ) ; GET_LOCALE_DATE_2T . CO\
NVERT_TO_LOCALE_DATE ( l_date , :language_id , s_date ) ; :nd_expiry_date1 := \
s_date ; GET_LOCALE_DATE_2T . CONVERT_TO_LOCALE_DATE ( l_date , :language_id ,\
 s_date , 'DDMMYYYYHH24MI' ) ; :nd_expiry_date2 := s_date ; GET_LOCALE_DATE_2T\
 . CONVERT_TO_LOCALE_DATE ( l_date , :language_id , s_date , 'DD Mon YYYY HH24\
:MI' ) ; :nd_expiry_date3 := s_date ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )437;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_expiry_date;
sqlstm.sqhstl[0] = (unsigned int  )43;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&language_id;
sqlstm.sqhstl[1] = (unsigned int  )27;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_expiry_date1;
sqlstm.sqhstl[2] = (unsigned int  )43;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nd_expiry_date2;
sqlstm.sqhstl[3] = (unsigned int  )43;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&nd_expiry_date3;
sqlstm.sqhstl[4] = (unsigned int  )43;
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



  strcpy(d_expiry_date[h_no_of_rec].arr, nd_expiry_date.arr);
  d_expiry_date[h_no_of_rec].len = strlen(d_expiry_date[h_no_of_rec].arr);

  strcpy(d_expiry_date1[h_no_of_rec].arr, nd_expiry_date1.arr);
  d_expiry_date1[h_no_of_rec].len = strlen(d_expiry_date1[h_no_of_rec].arr);

  strcpy(d_expiry_date2[h_no_of_rec].arr, nd_expiry_date2.arr);
  d_expiry_date2[h_no_of_rec].len = strlen(d_expiry_date2[h_no_of_rec].arr);

  strcpy(d_expiry_date3[h_no_of_rec].arr, nd_expiry_date3.arr);
  d_expiry_date3[h_no_of_rec].len = strlen(d_expiry_date3[h_no_of_rec].arr);

  strcpy(d_screened_legend[h_no_of_rec].arr, nd_screened_legend.arr);
  d_screened_legend[h_no_of_rec].len = strlen(d_screened_legend[h_no_of_rec].arr);

  strcpy(d_volume_units[h_no_of_rec].arr, nd_volume_units.arr);
  d_volume_units[h_no_of_rec].len = strlen(d_volume_units[h_no_of_rec].arr);

  strcpy(d_volume_unit[h_no_of_rec].arr, nd_volume_unit.arr);
  d_volume_unit[h_no_of_rec].len = strlen(d_volume_unit[h_no_of_rec].arr);

  strcpy(d_add_to_stock_yn[h_no_of_rec].arr, nd_add_to_stock_yn.arr);
  d_add_to_stock_yn[h_no_of_rec].len = strlen(d_add_to_stock_yn[h_no_of_rec].arr);

  d_volume[h_no_of_rec] = nd_volume;

  return 1;
  
}

//added for  aliquot 
int fetch_un_screenedali_cur()
{
  nd_donation_date.arr[0] = '\0';
  nd_donation_date.len = 0;
  
  nd_product_code.arr[0] = '\0';
  nd_product_code.len = 0;

  nd_unit_no.arr[0] = '\0';
  nd_unit_no.len = 0;

  nd_blood_group.arr[0] = '\0';
  nd_blood_group.len = 0;

  nd_blood_grp_for_disp.arr[0] = '\0'; /*added by sunil on 05/01/2010 */
  nd_blood_grp_for_disp.len = 0; /*added by sunil on 05/01/2010 */

  nd_blood_group_desc.arr[0] = '\0'; /*added by sunil on 05/01/2010 */
  nd_blood_group_desc.len = 0; /*added by sunil on 05/01/2010 */

  nd_rhesus_code.arr[0] = '\0';
  nd_rhesus_code.len = 0;

  nd_rhesus_desc.arr[0] = '\0';
  nd_rhesus_desc.len = 0;

  nd_expiry_date.arr[0] = '\0';
  nd_expiry_date.len = 0;


  nd_expiry_date1.arr[0] = '\0';
  nd_expiry_date1.len = 0;

  nd_expiry_date2.arr[0] = '\0';
  nd_expiry_date2.len = 0;

  nd_expiry_date3.arr[0] = '\0';
  nd_expiry_date3.len = 0;

  nd_screened_legend.arr[0] = '\0';
  nd_screened_legend.len = 0;


  nd_volume_units.arr[0] = '\0';
  nd_volume_units.len = 0;

  nd_volume_unit.arr[0] = '\0';
  nd_volume_unit.len = 0;

  nd_rownum_ali.arr[0] = '\0';
  nd_rownum_ali.len = 0;


	  /* EXEC SQL FETCH c_scr_ali INTO
                        :nd_donation_date,
						:nd_product_code,
                        :nd_unit_no,
                        :nd_blood_group,
						:nd_blood_grp_for_disp, /oadded by sunil on 05/01/2010o/
						:nd_blood_group_desc, /oadded by sunil on 05/01/2010o/
                        :nd_rhesus_code,
						:nd_rhesus_desc,
						:nd_volume,
						:nd_volume_units,
						:nd_volume_unit,
                        :nd_expiry_date,
						:nd_rownum_ali; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )472;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_donation_date;
   sqlstm.sqhstl[0] = (unsigned int  )53;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_product_code;
   sqlstm.sqhstl[1] = (unsigned int  )412;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_unit_no;
   sqlstm.sqhstl[2] = (unsigned int  )412;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_blood_group;
   sqlstm.sqhstl[3] = (unsigned int  )43;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_blood_grp_for_disp;
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_blood_group_desc;
   sqlstm.sqhstl[5] = (unsigned int  )412;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_rhesus_code;
   sqlstm.sqhstl[6] = (unsigned int  )43;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_rhesus_desc;
   sqlstm.sqhstl[7] = (unsigned int  )412;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_volume;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_volume_units;
   sqlstm.sqhstl[9] = (unsigned int  )412;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_volume_unit;
   sqlstm.sqhstl[10] = (unsigned int  )412;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_expiry_date;
   sqlstm.sqhstl[11] = (unsigned int  )43;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_rownum_ali;
   sqlstm.sqhstl[12] = (unsigned int  )412;
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


                         

    if (OERROR)
	{
//		sprintf(string_var,"%s get_facility_name()-> %s\n", d_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
        ins_message (ORA_MESG, "FETCH failed c2 ");
		return 0;
      }

    if (NO_DATA_FOUND)
      return 0;
  nd_donation_date.arr[nd_donation_date.len] = '\0';
  nd_donation_date.len = strlen(nd_donation_date.arr);

  nd_product_code.arr[nd_product_code.len] = '\0';
  nd_product_code.len = strlen(nd_product_code.arr);

  nd_unit_no.arr[nd_unit_no.len] = '\0';
  nd_unit_no.len = strlen(nd_unit_no.arr);

  nd_blood_group.arr[nd_blood_group.len] = '\0';
  nd_blood_group.len = strlen(nd_blood_group.arr);

  nd_blood_grp_for_disp.arr[nd_blood_grp_for_disp.len] = '\0';/*added by sunil on 05/01/2010*/
  nd_blood_grp_for_disp.len = strlen(nd_blood_grp_for_disp.arr);/*added by sunil on 05/01/2010*/

  nd_blood_group_desc.arr[nd_blood_group_desc.len] = '\0';/*added by sunil on 05/01/2010*/
  nd_blood_group_desc.len = strlen(nd_blood_group_desc.arr);/*added by sunil on 05/01/2010*/

  nd_rhesus_code.arr[nd_rhesus_code.len] = '\0';
  nd_rhesus_code.len = strlen(nd_rhesus_code.arr);

  nd_rhesus_desc.arr[nd_rhesus_desc.len] = '\0';
  nd_rhesus_desc.len = strlen(nd_rhesus_desc.arr);

  nd_expiry_date.arr[nd_expiry_date.len] = '\0';
  nd_expiry_date.len = strlen(nd_expiry_date.arr);

  /********** added against SRR SCF - 5675 to print the actual expiry date for units */
  get_expiry_for_ali_cur();
  /************************/ 

  nd_expiry_date1.arr[nd_expiry_date1.len] = '\0';
  nd_expiry_date1.len = strlen(nd_expiry_date1.arr);

  nd_expiry_date2.arr[nd_expiry_date2.len] = '\0';
  nd_expiry_date2.len = strlen(nd_expiry_date2.arr);

  nd_expiry_date3.arr[nd_expiry_date3.len] = '\0';
  nd_expiry_date3.len = strlen(nd_expiry_date3.arr);

  nd_screened_legend.arr[nd_screened_legend.len] = '\0';
  nd_screened_legend.len = strlen(nd_screened_legend.arr);

  nd_rownum_ali.arr[nd_rownum_ali.len] = '\0';
  nd_rownum_ali.len = strlen(nd_rownum_ali.arr);

  nd_volume_units.arr[nd_volume_units.len] = '\0';
  nd_volume_units.len = strlen(nd_volume_units.arr);

  nd_volume_unit.arr[nd_volume_unit.len] = '\0';
  nd_volume_unit.len = strlen(nd_volume_unit.arr);

//sprintf(string_var," in loop %s %s %s  [%d]",stock_reprint_yn, nd_stock_unit, nd_stock_product, h_no_of_rec);

if  ( (strcmp(stock_reprint_yn, "N") == 0) || 
	( (strcmp(stock_reprint_yn, "Y") ==0) && (strcmp(nd_unit_no.arr, nd_stock_unit) ==0) &&
			(strcmp(nd_product_code.arr, nd_stock_product) ==0)) )
{



/* EXEC SQL EXECUTE
	DECLARE
	t_date   VARCHAR2(50);
	BEGIN
	GET_LOCALE_DATE_2t.CONVERT_TO_LOCALE_DATE (to_date(:nd_donation_date,'DD/MM/YYYY'), :language_id , t_date);
	:nd_donation_date := t_date;
	END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 16;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare t_date VARCHAR2 ( 50 ) ; BEGIN GET_LOCALE_DATE_2t . C\
ONVERT_TO_LOCALE_DATE ( to_date ( :nd_donation_date , 'DD/MM/YYYY' ) , :langua\
ge_id , t_date ) ; :nd_donation_date := t_date ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )539;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_donation_date;
sqlstm.sqhstl[0] = (unsigned int  )53;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&language_id;
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



  strcpy (d_donation_date[h_no_of_rec].arr, nd_donation_date.arr);
  d_donation_date[h_no_of_rec].len = strlen(d_donation_date[h_no_of_rec].arr);

  strcpy (d_donor_product_code[h_no_of_rec].arr, nd_donor_product_code.arr);
  d_donor_product_code[h_no_of_rec].len = strlen(d_donor_product_code[h_no_of_rec].arr);

  strcpy(d_donor_unit_no[h_no_of_rec].arr, nd_donor_unit_no.arr);
  d_donor_unit_no[h_no_of_rec].len = strlen(d_donor_product_code[h_no_of_rec].arr);

  strcpy (d_product_code[h_no_of_rec].arr, nd_product_code.arr);
  d_product_code[h_no_of_rec].len = strlen(d_product_code[h_no_of_rec].arr);

  strcpy(d_unit_no[h_no_of_rec].arr, nd_unit_no.arr);
  d_unit_no[h_no_of_rec].len = strlen(d_unit_no[h_no_of_rec].arr);

  strcpy (d_blood_group[h_no_of_rec].arr, nd_blood_group.arr);
  d_blood_group[h_no_of_rec].len = strlen(d_blood_group[h_no_of_rec].arr);

  strcpy(d_blood_grp_for_disp[h_no_of_rec].arr, nd_blood_grp_for_disp.arr);/*added by sunil on 05/01/2010*/
  d_blood_grp_for_disp[h_no_of_rec].len = strlen(d_blood_grp_for_disp[h_no_of_rec].arr);/*added by sunil on 05/01/2010*/

  strcpy(d_blood_group_desc[h_no_of_rec].arr, nd_blood_group_desc.arr);/*added by sunil on 05/01/2010*/
  d_blood_group_desc[h_no_of_rec].len = strlen(d_blood_group_desc[h_no_of_rec].arr);/*added by sunil on 05/01/2010*/

  strcpy(d_rhesus_code[h_no_of_rec].arr, nd_rhesus_code.arr);
  d_rhesus_code[h_no_of_rec].len = strlen(d_rhesus_code[h_no_of_rec].arr);

  strcpy(d_rhesus_desc[h_no_of_rec].arr, nd_rhesus_desc.arr);
  d_rhesus_desc[h_no_of_rec].len = strlen(d_rhesus_desc[h_no_of_rec].arr);


/* EXEC SQL EXECUTE
	DECLARE
	s_date   VARCHAR2(50);
	l_date date;
	BEGIN
	l_date := to_date(:nd_expiry_date,'DD/MM/YYYY HH24:MI');

	GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (l_date, :language_id , s_date);
	:nd_expiry_date1 := s_date;

	GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (l_date, :language_id , s_date, 'DDMMYYYYHH24MI');
	:nd_expiry_date2 := s_date;

	GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (l_date, :language_id , s_date, 'DD Mon YYYY HH24:MI');
	:nd_expiry_date3 := s_date;
	END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 16;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare s_date VARCHAR2 ( 50 ) ; l_date date ; BEGIN l_date :\
= to_date ( :nd_expiry_date , 'DD/MM/YYYY HH24:MI' ) ; GET_LOCALE_DATE_2T . CO\
NVERT_TO_LOCALE_DATE ( l_date , :language_id , s_date ) ; :nd_expiry_date1 := \
s_date ; GET_LOCALE_DATE_2T . CONVERT_TO_LOCALE_DATE ( l_date , :language_id ,\
 s_date , 'DDMMYYYYHH24MI' ) ; :nd_expiry_date2 := s_date ; GET_LOCALE_DATE_2T\
 . CONVERT_TO_LOCALE_DATE ( l_date , :language_id , s_date , 'DD Mon YYYY HH24\
:MI' ) ; :nd_expiry_date3 := s_date ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )562;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_expiry_date;
sqlstm.sqhstl[0] = (unsigned int  )43;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&language_id;
sqlstm.sqhstl[1] = (unsigned int  )27;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_expiry_date1;
sqlstm.sqhstl[2] = (unsigned int  )43;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nd_expiry_date2;
sqlstm.sqhstl[3] = (unsigned int  )43;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&nd_expiry_date3;
sqlstm.sqhstl[4] = (unsigned int  )43;
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



  strcpy(d_expiry_date[h_no_of_rec].arr, nd_expiry_date.arr);
  d_expiry_date[h_no_of_rec].len = strlen(d_expiry_date[h_no_of_rec].arr);

  strcpy (d_expiry_date1[h_no_of_rec].arr, nd_expiry_date1.arr);
  d_expiry_date1[h_no_of_rec].len = strlen(d_expiry_date1[h_no_of_rec].arr);

  strcpy (d_expiry_date2[h_no_of_rec].arr, nd_expiry_date2.arr);
  d_expiry_date2[h_no_of_rec].len = strlen(d_expiry_date2[h_no_of_rec].arr);

  strcpy (d_expiry_date3[h_no_of_rec].arr, nd_expiry_date3.arr);
  d_expiry_date3[h_no_of_rec].len = strlen(d_expiry_date3[h_no_of_rec].arr);

  strcpy (d_screened_legend[h_no_of_rec].arr, nd_screened_legend.arr);
  d_screened_legend[h_no_of_rec].len = strlen(d_screened_legend[h_no_of_rec].arr);

  strcpy (d_volume_units[h_no_of_rec].arr, nd_volume_units.arr);
  d_volume_units[h_no_of_rec].len = strlen(d_volume_units[h_no_of_rec].arr);

  strcpy (d_volume_unit[h_no_of_rec].arr, nd_volume_unit.arr);
  d_volume_unit[h_no_of_rec].len = strlen(d_volume_unit[h_no_of_rec].arr);

  strcpy (d_rownum_ali[h_no_of_rec].arr, nd_rownum_ali.arr);
  d_rownum_ali[h_no_of_rec].len = strlen(d_rownum_ali[h_no_of_rec].arr);

  d_volume[h_no_of_rec] = nd_volume;


}
  return 1;
  
}
//ADDED FOR SCREENED LABEL
int fetch_screened_cur()
{


  nd_donation_date.arr[0] = '\0';
  nd_donation_date.len = 0;

  nd_donor_product_code.arr[0] = '\0';
  nd_donor_product_code.len = 0;

  nd_donor_unit_no.arr[0] = '\0';
  nd_donor_unit_no.len = 0;

  nd_product_code.arr[0] = '\0';
  nd_product_code.len = 0;

  nd_unit_no.arr[0] = '\0';
  nd_unit_no.len = 0;

  nd_blood_group.arr[0] = '\0';
  nd_blood_group.len = 0;

  nd_blood_grp_for_disp.arr[0] = '\0'; /*added by sunil on 05/01/2010 */
  nd_blood_grp_for_disp.len = 0; /*added by sunil on 05/01/2010 */

  nd_blood_group_desc.arr[0] = '\0'; /*added by sunil on 05/01/2010 */
  nd_blood_group_desc.len = 0; /*added by sunil on 05/01/2010 */

  nd_rhesus_code.arr[0] = '\0';
  nd_rhesus_code.len = 0;

  nd_rhesus_desc.arr[0] = '\0';
  nd_rhesus_desc.len = 0;

  nd_expiry_date.arr[0] = '\0';
  nd_expiry_date.len = 0;

  nd_expiry_date1.arr[0] = '\0';
  nd_expiry_date1.len = 0;

  nd_expiry_date2.arr[0] = '\0';
  nd_expiry_date2.len = 0;

  nd_expiry_date3.arr[0] = '\0';
  nd_expiry_date3.len = 0;

  nd_screened_legend.arr[0] = '\0';
  nd_screened_legend.len = 0;

  nd_volume_units.arr[0] = '\0';
  nd_volume_units.len = 0;

  nd_volume_unit.arr[0] = '\0';
  nd_volume_unit.len = 0;

      
	  /* EXEC SQL FETCH c_screen INTO
						:nd_donation_date,
                        :nd_product_code,
                        :nd_unit_no,
                        :nd_blood_group,
						:nd_blood_grp_for_disp, /oadded by sunil on 05/01/2010o/
						:nd_blood_group_desc, /oadded by sunil on 05/01/2010o/
                        :nd_rhesus_code,
						:nd_rhesus_desc,
						:nd_volume,
						:nd_volume_units,
						:nd_volume_unit,
                        :nd_expiry_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )597;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_donation_date;
   sqlstm.sqhstl[0] = (unsigned int  )53;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_product_code;
   sqlstm.sqhstl[1] = (unsigned int  )412;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_unit_no;
   sqlstm.sqhstl[2] = (unsigned int  )412;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_blood_group;
   sqlstm.sqhstl[3] = (unsigned int  )43;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_blood_grp_for_disp;
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_blood_group_desc;
   sqlstm.sqhstl[5] = (unsigned int  )412;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_rhesus_code;
   sqlstm.sqhstl[6] = (unsigned int  )43;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_rhesus_desc;
   sqlstm.sqhstl[7] = (unsigned int  )412;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_volume;
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_volume_units;
   sqlstm.sqhstl[9] = (unsigned int  )412;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_volume_unit;
   sqlstm.sqhstl[10] = (unsigned int  )412;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_expiry_date;
   sqlstm.sqhstl[11] = (unsigned int  )43;
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


                         

    if (OERROR)
	{
//		sprintf(string_var,"%s get_facility_name()-> %s\n", d_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
        ins_message (ORA_MESG, "FETCH failed c2 ");
		return 0;
      }

    if (NO_DATA_FOUND)
      return 0;
  nd_donation_date.arr[nd_donation_date.len] = '\0';
  nd_donation_date.len = strlen(nd_donation_date.arr);

  nd_donor_product_code.arr[nd_donor_product_code.len] = '\0';
  nd_donor_product_code.len = strlen(nd_donor_product_code.arr);

  nd_donor_unit_no.arr[nd_donor_unit_no.len] = '\0';
  nd_donor_unit_no.len = strlen(nd_donor_product_code.arr);

  nd_product_code.arr[nd_product_code.len] = '\0';
  nd_product_code.len = strlen(nd_product_code.arr);

  nd_unit_no.arr[nd_unit_no.len] = '\0';
  nd_unit_no.len = strlen(nd_unit_no.arr);

  nd_blood_group.arr[nd_blood_group.len] = '\0';
  nd_blood_group.len = strlen(nd_blood_group.arr);

  nd_blood_grp_for_disp.arr[nd_blood_grp_for_disp.len] = '\0';/*added by sunil on 05/01/2010*/
  nd_blood_grp_for_disp.len = strlen(nd_blood_grp_for_disp.arr);/*added by sunil on 05/01/2010*/

  nd_blood_group_desc.arr[nd_blood_group_desc.len] = '\0';/*added by sunil on 05/01/2010*/
  nd_blood_group_desc.len = strlen(nd_blood_group_desc.arr);/*added by sunil on 05/01/2010*/

  nd_rhesus_code.arr[nd_rhesus_code.len] = '\0';
  nd_rhesus_code.len = strlen(nd_rhesus_code.arr);

  nd_rhesus_desc.arr[nd_rhesus_desc.len] = '\0';
  nd_rhesus_desc.len = strlen(nd_rhesus_desc.arr);

  nd_expiry_date.arr[nd_expiry_date.len] = '\0';
  nd_expiry_date.len = strlen(nd_expiry_date.arr);

  nd_expiry_date1.arr[nd_expiry_date1.len] = '\0';
  nd_expiry_date1.len = strlen(nd_expiry_date1.arr);

  nd_expiry_date2.arr[nd_expiry_date2.len] = '\0';
  nd_expiry_date2.len = strlen(nd_expiry_date2.arr);
 
  nd_expiry_date3.arr[nd_expiry_date3.len] = '\0';
  nd_expiry_date3.len = strlen(nd_expiry_date3.arr);

  nd_screened_legend.arr[nd_screened_legend.len] = '\0';
  nd_screened_legend.len = strlen(nd_screened_legend.arr);

  nd_volume_units.arr[nd_volume_units.len] = '\0';
  nd_volume_units.len = strlen(nd_volume_units.arr);

  nd_volume_unit.arr[nd_volume_unit.len] = '\0';
  nd_volume_unit.len = strlen(nd_volume_unit.arr);

/* EXEC SQL EXECUTE
	DECLARE
	t_date   VARCHAR2(50);
	BEGIN
	GET_LOCALE_DATE_2t.CONVERT_TO_LOCALE_DATE (to_date(:nd_donation_date,'DD/MM/YYYY'), :language_id , t_date);
	:nd_donation_date := t_date;
	END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 16;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare t_date VARCHAR2 ( 50 ) ; BEGIN GET_LOCALE_DATE_2t . C\
ONVERT_TO_LOCALE_DATE ( to_date ( :nd_donation_date , 'DD/MM/YYYY' ) , :langua\
ge_id , t_date ) ; :nd_donation_date := t_date ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )660;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_donation_date;
sqlstm.sqhstl[0] = (unsigned int  )53;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&language_id;
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



  strcpy (d_donation_date[h_no_of_rec].arr, nd_donation_date.arr);
  d_donation_date[h_no_of_rec].len = strlen(d_donation_date[h_no_of_rec].arr);

  strcpy (d_donor_product_code[h_no_of_rec].arr, nd_donor_product_code.arr);
  d_donor_product_code[h_no_of_rec].len = strlen(d_donor_product_code[h_no_of_rec].arr);

  strcpy(d_donor_unit_no[h_no_of_rec].arr, nd_donor_unit_no.arr);
  d_donor_unit_no[h_no_of_rec].len = strlen(d_donor_product_code[h_no_of_rec].arr);

  strcpy(d_product_code[h_no_of_rec].arr, nd_product_code.arr);
  d_product_code[h_no_of_rec].len = strlen(d_product_code[h_no_of_rec].arr);

  strcpy(d_unit_no[h_no_of_rec].arr, nd_unit_no.arr);
  d_unit_no[h_no_of_rec].len = strlen(d_unit_no[h_no_of_rec].arr);

  strcpy(d_blood_group[h_no_of_rec].arr, nd_blood_group.arr);
  d_blood_group[h_no_of_rec].len = strlen(d_blood_group[h_no_of_rec].arr);

  strcpy(d_blood_grp_for_disp[h_no_of_rec].arr, nd_blood_grp_for_disp.arr);/*added by sunil on 05/01/2010*/
  d_blood_grp_for_disp[h_no_of_rec].len = strlen(d_blood_grp_for_disp[h_no_of_rec].arr);/*added by sunil on 05/01/2010*/

  strcpy(d_blood_group_desc[h_no_of_rec].arr, nd_blood_group_desc.arr);/*added by sunil on 05/01/2010*/
  d_blood_group_desc[h_no_of_rec].len = strlen(d_blood_group_desc[h_no_of_rec].arr);/*added by sunil on 05/01/2010*/

  strcpy(d_rhesus_code[h_no_of_rec].arr, nd_rhesus_code.arr);
  d_rhesus_code[h_no_of_rec].len = strlen(d_rhesus_code[h_no_of_rec].arr);

  strcpy(d_rhesus_desc[h_no_of_rec].arr, nd_rhesus_desc.arr);
  d_rhesus_desc[h_no_of_rec].len = strlen(d_rhesus_desc[h_no_of_rec].arr);

/* EXEC SQL EXECUTE
	DECLARE
	s_date   VARCHAR2(50);
	l_date	 date;
	BEGIN

	l_date :=to_date(:nd_expiry_date,'DD/MM/YYYY HH24:MI'); 

	GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (l_date, :language_id , s_date);
	:nd_expiry_date1 := s_date;

	GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (l_date, :language_id , s_date, 'DDMMYYYYHH24MI');
	:nd_expiry_date2 := s_date;

	GET_LOCALE_DATE_2T.CONVERT_TO_LOCALE_DATE (l_date, :language_id , s_date, 'DD Mon YYYY HH24:MI');
	:nd_expiry_date3 := s_date;
	END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 16;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare s_date VARCHAR2 ( 50 ) ; l_date date ; BEGIN l_date :\
= to_date ( :nd_expiry_date , 'DD/MM/YYYY HH24:MI' ) ; GET_LOCALE_DATE_2T . CO\
NVERT_TO_LOCALE_DATE ( l_date , :language_id , s_date ) ; :nd_expiry_date1 := \
s_date ; GET_LOCALE_DATE_2T . CONVERT_TO_LOCALE_DATE ( l_date , :language_id ,\
 s_date , 'DDMMYYYYHH24MI' ) ; :nd_expiry_date2 := s_date ; GET_LOCALE_DATE_2T\
 . CONVERT_TO_LOCALE_DATE ( l_date , :language_id , s_date , 'DD Mon YYYY HH24\
:MI' ) ; :nd_expiry_date3 := s_date ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )683;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_expiry_date;
sqlstm.sqhstl[0] = (unsigned int  )43;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&language_id;
sqlstm.sqhstl[1] = (unsigned int  )27;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_expiry_date1;
sqlstm.sqhstl[2] = (unsigned int  )43;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nd_expiry_date2;
sqlstm.sqhstl[3] = (unsigned int  )43;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&nd_expiry_date3;
sqlstm.sqhstl[4] = (unsigned int  )43;
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



  strcpy(d_expiry_date[h_no_of_rec].arr, nd_expiry_date.arr);
  d_expiry_date[h_no_of_rec].len = strlen(d_expiry_date[h_no_of_rec].arr);

  strcpy(d_expiry_date1[h_no_of_rec].arr, nd_expiry_date1.arr);
  d_expiry_date1[h_no_of_rec].len = strlen(d_expiry_date1[h_no_of_rec].arr);

  strcpy(d_expiry_date2[h_no_of_rec].arr, nd_expiry_date2.arr);
  d_expiry_date2[h_no_of_rec].len = strlen(d_expiry_date2[h_no_of_rec].arr);

  strcpy(d_expiry_date3[h_no_of_rec].arr, nd_expiry_date3.arr);
  d_expiry_date3[h_no_of_rec].len = strlen(d_expiry_date3[h_no_of_rec].arr);

  strcpy(d_screened_legend[h_no_of_rec].arr, nd_screened_legend.arr);
  d_screened_legend[h_no_of_rec].len = strlen(d_screened_legend[h_no_of_rec].arr);

  strcpy(d_volume_units[h_no_of_rec].arr, nd_volume_units.arr);
  d_volume_units[h_no_of_rec].len = strlen(d_volume_units[h_no_of_rec].arr);

  strcpy(d_volume_unit[h_no_of_rec].arr, nd_volume_unit.arr);
  d_volume_unit[h_no_of_rec].len = strlen(d_volume_unit[h_no_of_rec].arr);

  d_volume[h_no_of_rec] = nd_volume;

  return 1;
  
}

get_facility_name()
{
	d_facility_name.arr[0]		= '\0';
	d_facility_name.len		= 0;

	/* EXEC SQL  SELECT facility_name
	            INTO :d_facility_name
	            FROM sm_facility_param_lang_vw
               WHERE facility_id = :d_facility_id
	       and language_id=:language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select facility_name into :b0  from sm_facility_param_lang_v\
w where (facility_id=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )718;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_facility_name;
 sqlstm.sqhstl[0] = (unsigned int  )1012;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[1] = (unsigned int  )43;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&language_id;
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



	if(OERROR)
	{
		sprintf(string_var,"%s get_facility_name()-> %s\n", d_facility_id.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	d_facility_name.arr[d_facility_name.len]   = '\0';
	d_facility_name.len = strlen(d_facility_name.arr);

    if(NO_DATA_FOUND)
    {
      d_facility_name.arr[d_facility_name.len]   = '\0';
      d_facility_name.len = strlen(d_facility_name.arr);
    }
}

/*js*/
get_antigen_name()
{
	d_antigen_desc.arr[0]		= '\0';
	d_antigen_desc.len		= 0;
	d_antigen_desc2.arr[0]		= '\0';// added by sunil on 05/01/2010
	d_antigen_desc2.len		= 0;// added by sunil on 05/01/2010
	d_antigen_desc3.arr[0]		= '\0';// added by sunil on 05/01/2010
	d_antigen_desc3.len		= 0;// added by sunil on 05/01/2010
	d_antigen_desc4.arr[0]		= '\0';// added by sunil on 05/01/2010
	d_antigen_desc4.len		= 0;// added by sunil on 05/01/2010
	d_antigen_desc5.arr[0]		= '\0';// added by sunil on 05/01/2010
	d_antigen_desc5.len		= 0;// added by sunil on 05/01/2010
	d_antigen_desc6.arr[0]		= '\0';// added by sunil on 05/01/2010
	d_antigen_desc6.len		= 0;// added by sunil on 05/01/2010
	d_antigen_desc7.arr[0]		= '\0';// added by sunil on 05/01/2010
	d_antigen_desc7.len		= 0;// added by sunil on 05/01/2010
	d_antigen_desc8.arr[0]		= '\0';// added by sunil on 05/01/2010
	d_antigen_desc8.len		= 0;// added by sunil on 05/01/2010
	d_antigen_desc9.arr[0]		= '\0';// added by sunil on 05/01/2010
	d_antigen_desc9.len		= 0;// added by sunil on 05/01/2010
	d_antigen_desc10.arr[0]		= '\0';// added by sunil on 05/01/2010
	d_antigen_desc10.len		= 0;// added by sunil on 05/01/2010

	d_antigen_date.arr[0]		= '\0';
	d_antigen_date.len		= 0;

	/* EXEC SQL EXECUTE
		DECLARE
	 		CURSOR c1 is SELECT DISTINCT b.short_desc ANTIGEN_DESC, a.last_reported_date
					FROM BT_DONOR_ANTIGEN A, BT_ANTIGEN_CODE_MAST_LANG_VW B  
					WHERE A.antigen_code = B.antigen_code
					AND ((:a_pgm_id in ('BDRALILB', 'BDRSPRLB', 'BDRCONVL') AND A.unit_no = :d_fm_unit_no 
							AND A.product_code = :d_fm_product_code)
						OR (:a_pgm_id in ('BDRSCRLB') AND A.donor_id = (SELECT donor_id FROM BD_DONOR_Q_P_HDR 
									WHERE unit_no = :d_fm_unit_no AND product_code = :d_fm_product_code)))
					AND A.operating_facility_id = :d_facility_id
					AND B.language_id = :language_id
					ORDER BY A.last_reported_date DESC;

			l_cnt	NUMBER:=0;

		BEGIN
/o			For r1 in c1 Loop
				:d_antigen_desc := r1.ANTIGEN_DESC;
				Exit;
			End Loop;
	commented on 05/01/2010 and below for loop added for multiple antigens by sunil
o/
			For r1 in c1 Loop
				IF l_cnt = 0 THEN
					:d_antigen_desc := r1.ANTIGEN_DESC;
					l_cnt := l_cnt + 1;
				ELSIF l_cnt = 1 THEN
					:d_antigen_desc2 := r1.ANTIGEN_DESC;
					l_cnt := l_cnt + 1;
				ELSIF l_cnt = 2 THEN
					:d_antigen_desc3 := r1.ANTIGEN_DESC;
					l_cnt := l_cnt + 1;
				ELSIF l_cnt = 3 THEN
					:d_antigen_desc4 := r1.ANTIGEN_DESC;
					l_cnt := l_cnt + 1;
				ELSIF l_cnt = 4 THEN
					:d_antigen_desc5 := r1.ANTIGEN_DESC;
					l_cnt := l_cnt + 1;
				ELSIF l_cnt = 5 THEN
					:d_antigen_desc6 := r1.ANTIGEN_DESC;
					l_cnt := l_cnt + 1;
				ELSIF l_cnt = 6 THEN
					:d_antigen_desc7 := r1.ANTIGEN_DESC;
					l_cnt := l_cnt + 1;
				ELSIF l_cnt = 7 THEN
					:d_antigen_desc8 := r1.ANTIGEN_DESC;
					l_cnt := l_cnt + 1;
				ELSIF l_cnt = 8 THEN
					:d_antigen_desc9 := r1.ANTIGEN_DESC;
					l_cnt := l_cnt + 1;
				ELSIF l_cnt = 9 THEN
					:d_antigen_desc10 := '**';
					l_cnt := l_cnt + 1;
					EXIT;
				END IF;
			End Loop;
		END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "declare CURSOR c1 is SELECT DISTINCT b . short_desc ANTIGEN_DESC , a . l\
ast_reported_date FROM BT_DONOR_ANTIGEN A , BT_ANTIGEN_CODE_MAST_LANG_VW B W\
HERE A . antigen_code = B . antigen_code AND ( ( :a_pgm_id in ( 'BDRALILB' ,\
 'BDRSPRLB' , 'BDRCONVL' ) AND A . unit_no = :d_fm_unit_no AND A . product_c\
ode = :d_fm_product_code ) OR ( :a_pgm_id in ( 'BDRSCRLB' ) AND A . donor_id\
 = ( SELECT donor_id FROM BD_DONOR_Q_P_HDR WHERE unit_no = :d_fm_unit_no AND\
 product_code = :d_fm_product_code ) ) ) AND A . operating_facility_id = :d_\
facility_id AND B . language_id = :language_id ORDER BY A . last_reported_da\
te DESC ; l_cnt NUMBER := 0 ; BEGIN For r1 in c1 Loop IF l_cnt = 0 THEN :d_a\
ntigen_desc := r1 . ANTIGEN_DESC ; l_cnt := l_cnt + 1 ; ELSIF l_cnt = 1 THEN\
 :d_antigen_desc2 := r1 . ANTIGEN_DESC ; l_cnt := l_cnt + 1 ; ELSIF l_cnt = \
2 THEN :d_antigen_desc3 := r1 . ANTIGEN_DESC ; l_cnt := l_cnt + 1 ; ELSIF l_\
cnt = 3 THEN :d_antigen_desc4 := r1 . ANTIGEN_DESC ; l_cnt := l_cnt + 1 ; EL\
SIF l_cnt = 4 THEN :d_antigen_desc5 := r");
 sqlstm.stmt = "1 . ANTIGEN_DESC ; l_cnt := l_cnt + 1 ; ELSIF l_cnt = 5 THEN\
 :d_antigen_desc6 := r1 . ANTIGEN_DESC ; l_cnt := l_cnt + 1 ; ELSIF l_cnt = 6 \
THEN :d_antigen_desc7 := r1 . ANTIGEN_DESC ; l_cnt := l_cnt + 1 ; ELSIF l_cnt \
= 7 THEN :d_antigen_desc8 := r1 . ANTIGEN_DESC ; l_cnt := l_cnt + 1 ; ELSIF l_\
cnt = 8 THEN :d_antigen_desc9 := r1 . ANTIGEN_DESC ; l_cnt := l_cnt + 1 ; ELSI\
F l_cnt = 9 THEN :d_antigen_desc10 := '**' ; l_cnt := l_cnt + 1 ; EXIT ; END I\
F ; End Loop ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )745;
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
 sqlstm.sqhstv[1] = (         void  *)&d_fm_unit_no;
 sqlstm.sqhstl[1] = (unsigned int  )412;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_fm_product_code;
 sqlstm.sqhstl[2] = (unsigned int  )412;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[3] = (unsigned int  )43;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&language_id;
 sqlstm.sqhstl[4] = (unsigned int  )27;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_antigen_desc;
 sqlstm.sqhstl[5] = (unsigned int  )502;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_antigen_desc2;
 sqlstm.sqhstl[6] = (unsigned int  )502;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_antigen_desc3;
 sqlstm.sqhstl[7] = (unsigned int  )502;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_antigen_desc4;
 sqlstm.sqhstl[8] = (unsigned int  )502;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_antigen_desc5;
 sqlstm.sqhstl[9] = (unsigned int  )502;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&d_antigen_desc6;
 sqlstm.sqhstl[10] = (unsigned int  )502;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&d_antigen_desc7;
 sqlstm.sqhstl[11] = (unsigned int  )502;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&d_antigen_desc8;
 sqlstm.sqhstl[12] = (unsigned int  )502;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&d_antigen_desc9;
 sqlstm.sqhstl[13] = (unsigned int  )502;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&d_antigen_desc10;
 sqlstm.sqhstl[14] = (unsigned int  )502;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
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
		sprintf(string_var,"%s fetch_un_screened_cur()-> %s\n", d_fm_unit_no.arr, sqlca.sqlerrm.sqlerrmc);
	}

    if(NO_DATA_FOUND)
    {
      d_antigen_desc.arr[d_antigen_desc.len]   = '\0';
      d_antigen_desc.len = strlen(d_antigen_desc.arr);
      d_antigen_date.arr[d_antigen_date.len]   = '\0';
      d_antigen_date.len = strlen(d_antigen_date.arr);
    }

    d_antigen_desc.arr[d_antigen_desc.len]   = '\0';
    d_antigen_desc.len = strlen(d_antigen_desc.arr);

    d_antigen_desc2.arr[d_antigen_desc2.len]   = '\0';// added by sunil on 05/01/2010
    d_antigen_desc2.len = strlen(d_antigen_desc2.arr);// added by sunil on 05/01/2010

    d_antigen_desc3.arr[d_antigen_desc3.len]   = '\0';// added by sunil on 05/01/2010
    d_antigen_desc3.len = strlen(d_antigen_desc3.arr);// added by sunil on 05/01/2010

    d_antigen_desc4.arr[d_antigen_desc4.len]   = '\0';// added by sunil on 05/01/2010
    d_antigen_desc4.len = strlen(d_antigen_desc4.arr);// added by sunil on 05/01/2010

    d_antigen_desc5.arr[d_antigen_desc5.len]   = '\0';// added by sunil on 05/01/2010
    d_antigen_desc5.len = strlen(d_antigen_desc5.arr);// added by sunil on 05/01/2010

    d_antigen_desc6.arr[d_antigen_desc6.len]   = '\0';// added by sunil on 05/01/2010
    d_antigen_desc6.len = strlen(d_antigen_desc6.arr);// added by sunil on 05/01/2010

    d_antigen_desc7.arr[d_antigen_desc7.len]   = '\0';// added by sunil on 05/01/2010
    d_antigen_desc7.len = strlen(d_antigen_desc7.arr);// added by sunil on 05/01/2010

    d_antigen_desc8.arr[d_antigen_desc8.len]   = '\0';// added by sunil on 05/01/2010
    d_antigen_desc8.len = strlen(d_antigen_desc8.arr);// added by sunil on 05/01/2010

    d_antigen_desc9.arr[d_antigen_desc9.len]   = '\0';// added by sunil on 05/01/2010
    d_antigen_desc9.len = strlen(d_antigen_desc9.arr);// added by sunil on 05/01/2010

    d_antigen_desc10.arr[d_antigen_desc10.len]   = '\0';// added by sunil on 05/01/2010
    d_antigen_desc10.len = strlen(d_antigen_desc10.arr);// added by sunil on 05/01/2010


    d_antigen_date.arr[d_antigen_date.len]   = '\0';
    d_antigen_date.len = strlen(d_antigen_date.arr);

	if (strlen(d_antigen_desc.arr) == 0)
	{
		strcpy(d_antigen_desc.arr, " ");
	}
	if (strlen(d_antigen_desc2.arr) == 0)
	{
		strcpy(d_antigen_desc2.arr, " ");
	}
	if (strlen(d_antigen_desc3.arr) == 0)
	{
		strcpy(d_antigen_desc3.arr, " ");
	}
	if (strlen(d_antigen_desc4.arr) == 0)
	{
		strcpy(d_antigen_desc4.arr, " ");
	}
	if (strlen(d_antigen_desc5.arr) == 0)
	{
		strcpy(d_antigen_desc5.arr, " ");
	}
	if (strlen(d_antigen_desc6.arr) == 0)
	{
		strcpy(d_antigen_desc6.arr, " ");
	}
	if (strlen(d_antigen_desc7.arr) == 0)
	{
		strcpy(d_antigen_desc7.arr, " ");
	}
	if (strlen(d_antigen_desc8.arr) == 0)
	{
		strcpy(d_antigen_desc8.arr, " ");
	}
	if (strlen(d_antigen_desc9.arr) == 0)
	{
		strcpy(d_antigen_desc9.arr, " ");
	}
	if (strlen(d_antigen_desc10.arr) == 0)
	{
		strcpy(d_antigen_desc10.arr, " ");
	}



}

get_graph_barcode()
{

	nd_bld_grp_rh_barcode.arr[0]='\0';
	nd_bld_grp_rh_barcode.len=0;


	/* EXEC SQL	SELECT BLOOD_GRP_RH_BARCODE_CODE 
			INTO :nd_bld_grp_rh_barcode
			FROM BT_BLOOD_GRP_RH_BARCODE  
			WHERE 	BLOOD_GROUP=:d_blood_group[h_no_of_rec]
			AND RHESUS_CODE=:d_rhesus_code[h_no_of_rec]; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select BLOOD_GRP_RH_BARCODE_CODE into :b0  from BT_BLOOD_GRP\
_RH_BARCODE where (BLOOD_GROUP=:b1 and RHESUS_CODE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )820;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_bld_grp_rh_barcode;
 sqlstm.sqhstl[0] = (unsigned int  )502;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_blood_group[h_no_of_rec];
 sqlstm.sqhstl[1] = (unsigned int  )43;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_rhesus_code[h_no_of_rec];
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



	nd_bld_grp_rh_barcode.arr[nd_bld_grp_rh_barcode.len]='\0';



  strcpy(d_bld_grp_rh_barcode[h_no_of_rec].arr, nd_bld_grp_rh_barcode.arr);
  d_bld_grp_rh_barcode[h_no_of_rec].len = strlen(d_bld_grp_rh_barcode[h_no_of_rec].arr);



if(OERROR)
	{
		sprintf(string_var,"%s and %s and %s  get_graph_barcode-> %s\n", d_product_code[h_no_of_rec].arr,d_blood_group[h_no_of_rec].arr,d_rhesus_code[h_no_of_rec].arr,sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}
}


get_center_code()
 {
	nd_center_code.arr[0]='\0';
	nd_center_code.len=0;
	nd_center_desc.arr[0]='\0'; // added by sunil
	nd_center_desc.len=0;  // added by sunil


/*below if condition added by sunil on 27-08-2008 against CRF */
    if ((strcmp(a_pgm_id.arr,"BDRSCRLB") == 0) && (strcmp(d_add_to_stock_yn[h_no_of_rec].arr,"N") == 0)) /* if condition added by sunil on 13-aug-2008*/
	{
		/* EXEC SQL SELECT a.DEFAULT_COLL_CENTRE,  b.desc_on_label
			into :nd_center_code, :nd_center_desc
			FROM BD_PARAM a, BT_COLLECTION_CENTRE_LANG_VW b
			WHERE a.DEFAULT_COLL_CENTRE = b.centre_code
			and b.LANGUAGE_ID= :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select a.DEFAULT_COLL_CENTRE ,b.desc_on_label into :b0,:b1 \
 from BD_PARAM a ,BT_COLLECTION_CENTRE_LANG_VW b where (a.DEFAULT_COLL_CENTRE=\
b.centre_code and b.LANGUAGE_ID=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )847;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_center_code;
  sqlstm.sqhstl[0] = (unsigned int  )42;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_center_desc;
  sqlstm.sqhstl[1] = (unsigned int  )402;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&language_id;
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


	} 
	else
	{
		/* EXEC SQL SELECT a.CENTRE_CODE,  b.desc_on_label
			into :nd_center_code, :nd_center_desc
			FROM BD_BLOOD_UNITS_MAST a, BT_COLLECTION_CENTRE_LANG_VW b
			WHERE a.centre_code = b.centre_code
			and a.UNIT_NO=:d_unit_no[h_no_of_rec]
			and a.product_code=:d_product_code[h_no_of_rec]
			and b.LANGUAGE_ID= :language_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select a.CENTRE_CODE ,b.desc_on_label into :b0,:b1  from BD\
_BLOOD_UNITS_MAST a ,BT_COLLECTION_CENTRE_LANG_VW b where (((a.centre_code=b.c\
entre_code and a.UNIT_NO=:b2) and a.product_code=:b3) and b.LANGUAGE_ID=:b4)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )874;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_center_code;
  sqlstm.sqhstl[0] = (unsigned int  )42;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_center_desc;
  sqlstm.sqhstl[1] = (unsigned int  )402;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_product_code[h_no_of_rec];
  sqlstm.sqhstl[3] = (unsigned int  )43;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&language_id;
  sqlstm.sqhstl[4] = (unsigned int  )27;
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

	nd_center_code.arr[nd_center_code.len] = '\0';
	nd_center_desc.arr[nd_center_desc.len] = '\0';

	strcpy(d_center_code[h_no_of_rec].arr, nd_center_code.arr);
	d_center_code[h_no_of_rec].len = strlen(d_center_code[h_no_of_rec].arr);
	
	strcpy(d_center_desc[h_no_of_rec].arr, nd_center_desc.arr);
	d_center_desc[h_no_of_rec].len = strlen(d_center_desc[h_no_of_rec].arr);

	if(OERROR)
	{
		sprintf(string_var,"%s get_center_code-> %s\n", d_unit_no[h_no_of_rec].arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

 }

get_label_gen_yn()
 {
	nd_unit_no_gen_yn.arr[0] = '\0';
	nd_unit_no_gen_yn.len = 0;

	if (strcmp(a_pgm_id.arr,"BDRSPRLB") == 0)
	{
		/* EXEC SQL 
			SELECT 'C' into :nd_unit_no_gen_yn
			FROM BD_PARAM a, BT_Collection_Centre b
			where a.CENTRE_CODE_POOLED = b.CENTRE_CODE
			and nvl(UNIT_NO_GEN_YN,'N') = 'Y'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select 'C' into :b0  from BD_PARAM a ,BT_Collection_Centre \
b where (a.CENTRE_CODE_POOLED=b.CENTRE_CODE and nvl(UNIT_NO_GEN_YN,'N')='Y')";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )909;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_unit_no_gen_yn;
  sqlstm.sqhstl[0] = (unsigned int  )43;
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


		if(NO_DATA_FOUND)
		{
			strcpy(d_unit_no_gen_yn[h_no_of_rec].arr, "C");
		}
	}
	else
	{
		/* EXEC SQL 
			SELECT 'C' into :nd_unit_no_gen_yn
			FROM BD_PARAM a, BT_Collection_Centre b
			where a.DEFAULT_COLL_CENTRE = b.CENTRE_CODE
			and nvl(UNIT_NO_GEN_YN,'N') = 'Y'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select 'C' into :b0  from BD_PARAM a ,BT_Collection_Centre \
b where (a.DEFAULT_COLL_CENTRE=b.CENTRE_CODE and nvl(UNIT_NO_GEN_YN,'N')='Y')";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )928;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_unit_no_gen_yn;
  sqlstm.sqhstl[0] = (unsigned int  )43;
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



		if(NO_DATA_FOUND)
		{
		/* EXEC SQL 
			SELECT 'P' into :nd_unit_no_gen_yn
			FROM bt_product_mast
			where PRODUCT_CODE = :d_fm_product_code
			and nvl(UNIT_NO_GEN_YN,'N') = 'Y'; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select 'P' into :b0  from bt_product_mast where (PRODUCT_CO\
DE=:b1 and nvl(UNIT_NO_GEN_YN,'N')='Y')";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )947;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_unit_no_gen_yn;
  sqlstm.sqhstl[0] = (unsigned int  )43;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_fm_product_code;
  sqlstm.sqhstl[1] = (unsigned int  )412;
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
	}

	nd_unit_no_gen_yn.arr[nd_unit_no_gen_yn.len] = '\0';

	strcpy(d_unit_no_gen_yn[h_no_of_rec].arr, nd_unit_no_gen_yn.arr);
	d_unit_no_gen_yn[h_no_of_rec].len = strlen(d_unit_no_gen_yn[h_no_of_rec].arr);

	if(OERROR)
	{
		sprintf(string_var,"%s get_center_code-> %s\n", d_unit_no[h_no_of_rec].arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

 }

get_unit_no()
 {

	nd_unit_no_split.arr[0] = '\0';
	nd_unit_no_split.len = 0;

	nd_unit_no_split1.arr[0] = '\0';
	nd_unit_no_split1.len = 0;

	nd_unit_no_split2.arr[0] = '\0';
	nd_unit_no_split2.len = 0;

	nd_unit_no_seq.arr[0] = '\0';
	nd_unit_no_seq.len = 0;


	if(strcmp(d_unit_no_gen_yn[h_no_of_rec].arr,"C") == 0) 
	{
		if ((strcmp(a_pgm_id.arr,"BDRSCRLB") == 0) && (strcmp(d_add_to_stock_yn[h_no_of_rec].arr,"N") == 0)) /* if condition added by sunil on 13-aug-2008*/
		{
			/* EXEC SQL SELECT (substr(:d_unit_no[h_no_of_rec],1,length(b.UNIT_NO_PREFIX))||Substr(:d_unit_no[h_no_of_rec],length(b.UNIT_NO_PREFIX)+1,2)||' '||substr(:d_unit_no[h_no_of_rec],length(b.UNIT_NO_PREFIX)+3)) ,
			'00' ,
			substr(:d_unit_no[h_no_of_rec],1,length(b.UNIT_NO_PREFIX))||Substr(:d_unit_no[h_no_of_rec],length(b.UNIT_NO_PREFIX)+1,2),
			substr(:d_unit_no[h_no_of_rec],length(b.UNIT_NO_PREFIX)+3)
				into :nd_unit_no_split, :nd_unit_no_seq, :nd_unit_no_split1, :nd_unit_no_split2
				FROM BD_PARAM a, BT_COLLECTION_CENTRE b
				where a.DEFAULT_COLL_CENTRE = b.CENTRE_CODE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select (((substr(:b0,1,length(b.UNIT_NO_PREFIX))||Substr(:\
b0,(length(b.UNIT_NO_PREFIX)+1),2))||' ')||substr(:b0,(length(b.UNIT_NO_PREFIX\
)+3))) ,'00' ,(substr(:b0,1,length(b.UNIT_NO_PREFIX))||Substr(:b0,(length(b.UN\
IT_NO_PREFIX)+1),2)) ,substr(:b0,(length(b.UNIT_NO_PREFIX)+3)) into :b6,:b7,:b\
8,:b9  from BD_PARAM a ,BT_COLLECTION_CENTRE b where a.DEFAULT_COLL_CENTRE=b.C\
ENTRE_CODE";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )970;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[1] = (unsigned int  )43;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[2] = (unsigned int  )43;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[3] = (unsigned int  )43;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[5] = (unsigned int  )43;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split;
   sqlstm.sqhstl[6] = (unsigned int  )412;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_seq;
   sqlstm.sqhstl[7] = (unsigned int  )412;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split1;
   sqlstm.sqhstl[8] = (unsigned int  )412;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split2;
   sqlstm.sqhstl[9] = (unsigned int  )412;
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



			if(NO_DATA_FOUND)
			{
				/* EXEC SQL SELECT (substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2)||' '||substr(:d_unit_no[h_no_of_rec],8)),  
				'00',
				substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2),
				substr(:d_unit_no[h_no_of_rec],8)
				into :nd_unit_no_split, :nd_unit_no_seq,
						:nd_unit_no_split1, :nd_unit_no_split2
				FROM dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (((substr(:b0,1,5)||substr(:b0,6,2))||' ')||substr\
(:b0,8)) ,'00' ,(substr(:b0,1,5)||substr(:b0,6,2)) ,substr(:b0,8) into :b6,:b7\
,:b8,:b9  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1025;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[1] = (unsigned int  )43;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[2] = (unsigned int  )43;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[3] = (unsigned int  )43;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[4] = (unsigned int  )43;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[5] = (unsigned int  )43;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split;
    sqlstm.sqhstl[6] = (unsigned int  )412;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_seq;
    sqlstm.sqhstl[7] = (unsigned int  )412;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split1;
    sqlstm.sqhstl[8] = (unsigned int  )412;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split2;
    sqlstm.sqhstl[9] = (unsigned int  )412;
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


			}
		} 
		else if (strcmp(a_pgm_id.arr,"BDRALILB") == 0)
		{
			/* EXEC SQL SELECT (substr(:d_unit_no[h_no_of_rec],1,length(b.UNIT_NO_PREFIX))||substr(:d_unit_no[h_no_of_rec],length(b.UNIT_NO_PREFIX)+1,2)||' '||substr(:d_unit_no[h_no_of_rec],length(b.UNIT_NO_PREFIX)+3))  ,
				lpad(substr(:d_unit_no[h_no_of_rec],instr(:d_unit_no[h_no_of_rec],'-')+1),2,'0'),
				substr(:d_unit_no[h_no_of_rec],1,length(b.UNIT_NO_PREFIX))||Substr(:d_unit_no[h_no_of_rec],length(b.UNIT_NO_PREFIX)+1,2),
				substr(:d_unit_no[h_no_of_rec],length(b.UNIT_NO_PREFIX)+3)
				into :nd_unit_no_split, :nd_unit_no_seq,
						:nd_unit_no_split1, :nd_unit_no_split2
				FROM BD_BLOOD_UNITS_MAST a, BT_COLLECTION_CENTRE b
				WHERE a.CENTRE_CODE = b.CENTRE_CODE
				and a.UNIT_NO=:d_unit_no[h_no_of_rec]
				and a.product_code=:d_product_code[h_no_of_rec]
				AND a.operating_facility_id = :d_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select (((substr(:b0,1,length(b.UNIT_NO_PREFIX))||substr(:\
b0,(length(b.UNIT_NO_PREFIX)+1),2))||' ')||substr(:b0,(length(b.UNIT_NO_PREFIX\
)+3))) ,lpad(substr(:b0,(instr(:b0,'-')+1)),2,'0') ,(substr(:b0,1,length(b.UNI\
T_NO_PREFIX))||Substr(:b0,(length(b.UNIT_NO_PREFIX)+1),2)) ,substr(:b0,(length\
(b.UNIT_NO_PREFIX)+3)) into :b8,:b9,:b10,:b11  from BD_BLOOD_UNITS_MAST a ,BT_\
COLLECTION_CENTRE b where (((a.CENTRE_CODE=b.CENTRE_CODE and a.UNIT_NO=:b0) an\
d a.product_code=:b13) and a.operating_facility_id=:b14)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1080;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[1] = (unsigned int  )43;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[2] = (unsigned int  )43;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[3] = (unsigned int  )43;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[5] = (unsigned int  )43;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[6] = (unsigned int  )43;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[7] = (unsigned int  )43;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split;
   sqlstm.sqhstl[8] = (unsigned int  )412;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_seq;
   sqlstm.sqhstl[9] = (unsigned int  )412;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_unit_no_split1;
   sqlstm.sqhstl[10] = (unsigned int  )412;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_unit_no_split2;
   sqlstm.sqhstl[11] = (unsigned int  )412;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[12] = (unsigned int  )43;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_product_code[h_no_of_rec];
   sqlstm.sqhstl[13] = (unsigned int  )43;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[14] = (unsigned int  )43;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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
				/* EXEC SQL SELECT (substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2)||' '||substr(:d_unit_no[h_no_of_rec],8)) , 
				lpad(:d_rownum_ali[h_no_of_rec],2,'0'),
				substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2),
				substr(:d_unit_no[h_no_of_rec],8)
				into :nd_unit_no_split, :nd_unit_no_seq,
					:nd_unit_no_split1, :nd_unit_no_split2
				FROM dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (((substr(:b0,1,5)||substr(:b0,6,2))||' ')||substr\
(:b0,8)) ,lpad(:b3,2,'0') ,(substr(:b0,1,5)||substr(:b0,6,2)) ,substr(:b0,8) i\
nto :b7,:b8,:b9,:b10  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1155;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[1] = (unsigned int  )43;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[2] = (unsigned int  )43;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_rownum_ali[h_no_of_rec];
    sqlstm.sqhstl[3] = (unsigned int  )412;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[4] = (unsigned int  )43;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[5] = (unsigned int  )43;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[6] = (unsigned int  )43;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_split;
    sqlstm.sqhstl[7] = (unsigned int  )412;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_seq;
    sqlstm.sqhstl[8] = (unsigned int  )412;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split1;
    sqlstm.sqhstl[9] = (unsigned int  )412;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_unit_no_split2;
    sqlstm.sqhstl[10] = (unsigned int  )412;
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


			}
		}
		else if (strcmp(a_pgm_id.arr,"BDRUNTLB") == 0)
		{
			if (strcmp(d_sample_ind.arr,"AD") == 0)
			{
				/* EXEC SQL SELECT (substr(:d_fm_unit_no,1,8)||' '||substr(:d_fm_unit_no,9)) , 
				'00',
				substr(:d_fm_unit_no,1,8),
				substr(:d_fm_unit_no,9)				
				into :nd_unit_no_split, :nd_unit_no_seq,
						:nd_unit_no_split1, :nd_unit_no_split2
				FROM dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ((substr(:b0,1,8)||' ')||substr(:b0,9)) ,'00' ,sub\
str(:b0,1,8) ,substr(:b0,9) into :b4,:b5,:b6,:b7  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1214;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[0] = (unsigned int  )412;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[1] = (unsigned int  )412;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[2] = (unsigned int  )412;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[3] = (unsigned int  )412;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_unit_no_split;
    sqlstm.sqhstl[4] = (unsigned int  )412;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_unit_no_seq;
    sqlstm.sqhstl[5] = (unsigned int  )412;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split1;
    sqlstm.sqhstl[6] = (unsigned int  )412;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_split2;
    sqlstm.sqhstl[7] = (unsigned int  )412;
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


			
			}
			else
			{
				/* EXEC SQL SELECT (substr(:d_fm_unit_no,1,length(b.UNIT_NO_PREFIX))||substr(:d_fm_unit_no,length(b.UNIT_NO_PREFIX)+1,2)||' '||substr(:d_fm_unit_no,length(b.UNIT_NO_PREFIX)+3))  ,
					'00',
						substr(:d_fm_unit_no,1,length(b.UNIT_NO_PREFIX))||Substr(:d_fm_unit_no,length(b.UNIT_NO_PREFIX)+1,2),
						substr(:d_fm_unit_no,length(b.UNIT_NO_PREFIX)+3)
					into :nd_unit_no_split, :nd_unit_no_seq,
							:nd_unit_no_split1, :nd_unit_no_split2
					FROM BD_PARAM A, BT_COLLECTION_CENTRE b
					WHERE a.DEFAULT_COLL_CENTRE = b.CENTRE_CODE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (((substr(:b0,1,length(b.UNIT_NO_PREFIX))||substr(\
:b0,(length(b.UNIT_NO_PREFIX)+1),2))||' ')||substr(:b0,(length(b.UNIT_NO_PREFI\
X)+3))) ,'00' ,(substr(:b0,1,length(b.UNIT_NO_PREFIX))||Substr(:b0,(length(b.U\
NIT_NO_PREFIX)+1),2)) ,substr(:b0,(length(b.UNIT_NO_PREFIX)+3)) into :b6,:b7,:\
b8,:b9  from BD_PARAM A ,BT_COLLECTION_CENTRE b where a.DEFAULT_COLL_CENTRE=b.\
CENTRE_CODE";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1261;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[0] = (unsigned int  )412;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[1] = (unsigned int  )412;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[2] = (unsigned int  )412;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[3] = (unsigned int  )412;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[4] = (unsigned int  )412;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[5] = (unsigned int  )412;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split;
    sqlstm.sqhstl[6] = (unsigned int  )412;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_seq;
    sqlstm.sqhstl[7] = (unsigned int  )412;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split1;
    sqlstm.sqhstl[8] = (unsigned int  )412;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split2;
    sqlstm.sqhstl[9] = (unsigned int  )412;
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



				if(NO_DATA_FOUND)
				{
					/* EXEC SQL SELECT (substr(:d_fm_unit_no,1,5)||substr(:d_fm_unit_no,6,2)||' '||substr(:d_fm_unit_no,8)) , 
					'00',
					substr(:d_fm_unit_no,1,5)||substr(:d_fm_unit_no,6,2),
					substr(:d_fm_unit_no,8)				
					into :nd_unit_no_split, :nd_unit_no_seq,
							:nd_unit_no_split1, :nd_unit_no_split2
					FROM dual; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 16;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select (((substr(:b0,1,5)||substr(:b0,6,2))||' ')||subst\
r(:b0,8)) ,'00' ,(substr(:b0,1,5)||substr(:b0,6,2)) ,substr(:b0,8) into :b6,:b\
7,:b8,:b9  from dual ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1316;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_fm_unit_no;
     sqlstm.sqhstl[0] = (unsigned int  )412;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_fm_unit_no;
     sqlstm.sqhstl[1] = (unsigned int  )412;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_fm_unit_no;
     sqlstm.sqhstl[2] = (unsigned int  )412;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_fm_unit_no;
     sqlstm.sqhstl[3] = (unsigned int  )412;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_fm_unit_no;
     sqlstm.sqhstl[4] = (unsigned int  )412;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_fm_unit_no;
     sqlstm.sqhstl[5] = (unsigned int  )412;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split;
     sqlstm.sqhstl[6] = (unsigned int  )412;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_seq;
     sqlstm.sqhstl[7] = (unsigned int  )412;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split1;
     sqlstm.sqhstl[8] = (unsigned int  )412;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split2;
     sqlstm.sqhstl[9] = (unsigned int  )412;
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


				}
			}
		}
		else
		{


			/* EXEC SQL SELECT (substr(:d_unit_no[h_no_of_rec],1,length(b.UNIT_NO_PREFIX))||substr(:d_unit_no[h_no_of_rec],length(b.UNIT_NO_PREFIX)+1,2)||' '||substr(:d_unit_no[h_no_of_rec],length(b.UNIT_NO_PREFIX)+3))  ,
				'00',
				substr(:d_unit_no[h_no_of_rec],1,length(b.UNIT_NO_PREFIX))||Substr(:d_unit_no[h_no_of_rec],length(b.UNIT_NO_PREFIX)+1,2),
				substr(:d_unit_no[h_no_of_rec],length(b.UNIT_NO_PREFIX)+3)
				into :nd_unit_no_split, :nd_unit_no_seq,
						:nd_unit_no_split1, :nd_unit_no_split2
				FROM BD_BLOOD_UNITS_MAST a, BT_COLLECTION_CENTRE b
				WHERE a.CENTRE_CODE = b.CENTRE_CODE
				and a.UNIT_NO=:d_unit_no[h_no_of_rec]
				and a.product_code=:d_product_code[h_no_of_rec]
				AND a.operating_facility_id = :d_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select (((substr(:b0,1,length(b.UNIT_NO_PREFIX))||substr(:\
b0,(length(b.UNIT_NO_PREFIX)+1),2))||' ')||substr(:b0,(length(b.UNIT_NO_PREFIX\
)+3))) ,'00' ,(substr(:b0,1,length(b.UNIT_NO_PREFIX))||Substr(:b0,(length(b.UN\
IT_NO_PREFIX)+1),2)) ,substr(:b0,(length(b.UNIT_NO_PREFIX)+3)) into :b6,:b7,:b\
8,:b9  from BD_BLOOD_UNITS_MAST a ,BT_COLLECTION_CENTRE b where (((a.CENTRE_CO\
DE=b.CENTRE_CODE and a.UNIT_NO=:b0) and a.product_code=:b11) and a.operating_f\
acility_id=:b12)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1371;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[1] = (unsigned int  )43;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[2] = (unsigned int  )43;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[3] = (unsigned int  )43;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[5] = (unsigned int  )43;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split;
   sqlstm.sqhstl[6] = (unsigned int  )412;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_seq;
   sqlstm.sqhstl[7] = (unsigned int  )412;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split1;
   sqlstm.sqhstl[8] = (unsigned int  )412;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split2;
   sqlstm.sqhstl[9] = (unsigned int  )412;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[10] = (unsigned int  )43;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_product_code[h_no_of_rec];
   sqlstm.sqhstl[11] = (unsigned int  )43;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[12] = (unsigned int  )43;
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

 

			if(NO_DATA_FOUND)
			{

				/* EXEC SQL SELECT (substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2)||' '||substr(:d_unit_no[h_no_of_rec],8))  ,
				'00',
				substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2),
				substr(:d_unit_no[h_no_of_rec],8)
				into :nd_unit_no_split, :nd_unit_no_seq,
						:nd_unit_no_split1, :nd_unit_no_split2
				FROM dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (((substr(:b0,1,5)||substr(:b0,6,2))||' ')||substr\
(:b0,8)) ,'00' ,(substr(:b0,1,5)||substr(:b0,6,2)) ,substr(:b0,8) into :b6,:b7\
,:b8,:b9  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1438;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[1] = (unsigned int  )43;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[2] = (unsigned int  )43;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[3] = (unsigned int  )43;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[4] = (unsigned int  )43;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[5] = (unsigned int  )43;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split;
    sqlstm.sqhstl[6] = (unsigned int  )412;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_seq;
    sqlstm.sqhstl[7] = (unsigned int  )412;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split1;
    sqlstm.sqhstl[8] = (unsigned int  )412;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split2;
    sqlstm.sqhstl[9] = (unsigned int  )412;
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


			}
		}
	}
	else if (strcmp(d_unit_no_gen_yn[h_no_of_rec].arr,"P") == 0)  
	{
		if (strcmp(a_pgm_id.arr,"BDRALILB") == 0)
		{
			/* EXEC SQL SELECT (substr(:d_unit_no[h_no_of_rec],1,length(a.UNIT_NO_PREFIX))||substr(:d_unit_no[h_no_of_rec],length(a.UNIT_NO_PREFIX)+1,2)||' '||substr(:d_unit_no[h_no_of_rec],length(a.UNIT_NO_PREFIX)+3))  ,
			lpad(substr(:d_unit_no[h_no_of_rec],instr(:d_unit_no[h_no_of_rec],'-')+1),2,'0'),
			substr(:d_unit_no[h_no_of_rec],1,length(a.UNIT_NO_PREFIX))||substr(:d_unit_no[h_no_of_rec],length(a.UNIT_NO_PREFIX)+1,2),
			substr(:d_unit_no[h_no_of_rec],length(a.UNIT_NO_PREFIX)+3)
			into :nd_unit_no_split, :nd_unit_no_seq,
				:nd_unit_no_split1, :nd_unit_no_split2
			FROM BT_PRODUCT_MAST a
			WHERE a.product_code=:d_fm_product_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select (((substr(:b0,1,length(a.UNIT_NO_PREFIX))||substr(:\
b0,(length(a.UNIT_NO_PREFIX)+1),2))||' ')||substr(:b0,(length(a.UNIT_NO_PREFIX\
)+3))) ,lpad(substr(:b0,(instr(:b0,'-')+1)),2,'0') ,(substr(:b0,1,length(a.UNI\
T_NO_PREFIX))||substr(:b0,(length(a.UNIT_NO_PREFIX)+1),2)) ,substr(:b0,(length\
(a.UNIT_NO_PREFIX)+3)) into :b8,:b9,:b10,:b11  from BT_PRODUCT_MAST a where a.\
product_code=:b12";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1493;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[1] = (unsigned int  )43;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[2] = (unsigned int  )43;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[3] = (unsigned int  )43;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[5] = (unsigned int  )43;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[6] = (unsigned int  )43;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[7] = (unsigned int  )43;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split;
   sqlstm.sqhstl[8] = (unsigned int  )412;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_seq;
   sqlstm.sqhstl[9] = (unsigned int  )412;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_unit_no_split1;
   sqlstm.sqhstl[10] = (unsigned int  )412;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_unit_no_split2;
   sqlstm.sqhstl[11] = (unsigned int  )412;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_fm_product_code;
   sqlstm.sqhstl[12] = (unsigned int  )412;
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



			if(NO_DATA_FOUND)
			{
				/* EXEC SQL SELECT (substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2)||' '||substr(:d_unit_no[h_no_of_rec],8))  ,
				lpad(:d_rownum_ali[h_no_of_rec]+1,2,'0'),
				substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2),
				substr(:d_unit_no[h_no_of_rec],8)
				into :nd_unit_no_split, :nd_unit_no_seq,
						:nd_unit_no_split1, :nd_unit_no_split2
				FROM dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (((substr(:b0,1,5)||substr(:b0,6,2))||' ')||substr\
(:b0,8)) ,lpad((:b3+1),2,'0') ,(substr(:b0,1,5)||substr(:b0,6,2)) ,substr(:b0,\
8) into :b7,:b8,:b9,:b10  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1560;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[1] = (unsigned int  )43;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[2] = (unsigned int  )43;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_rownum_ali[h_no_of_rec];
    sqlstm.sqhstl[3] = (unsigned int  )412;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[4] = (unsigned int  )43;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[5] = (unsigned int  )43;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[6] = (unsigned int  )43;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_split;
    sqlstm.sqhstl[7] = (unsigned int  )412;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_seq;
    sqlstm.sqhstl[8] = (unsigned int  )412;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split1;
    sqlstm.sqhstl[9] = (unsigned int  )412;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_unit_no_split2;
    sqlstm.sqhstl[10] = (unsigned int  )412;
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


			}

		}
		else if (strcmp(a_pgm_id.arr,"BDRUNTLB") == 0)
		{
			if (strcmp(d_sample_ind.arr,"AD") == 0)
			{
				/* EXEC SQL SELECT (substr(:d_fm_unit_no,1,8)||' '||substr(:d_fm_unit_no,9)) , 
				'00',
				substr(:d_fm_unit_no,1,8),
				substr(:d_fm_unit_no,9)				
				into :nd_unit_no_split, :nd_unit_no_seq,
						:nd_unit_no_split1, :nd_unit_no_split2
				FROM dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ((substr(:b0,1,8)||' ')||substr(:b0,9)) ,'00' ,sub\
str(:b0,1,8) ,substr(:b0,9) into :b4,:b5,:b6,:b7  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1619;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[0] = (unsigned int  )412;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[1] = (unsigned int  )412;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[2] = (unsigned int  )412;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[3] = (unsigned int  )412;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_unit_no_split;
    sqlstm.sqhstl[4] = (unsigned int  )412;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_unit_no_seq;
    sqlstm.sqhstl[5] = (unsigned int  )412;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split1;
    sqlstm.sqhstl[6] = (unsigned int  )412;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_split2;
    sqlstm.sqhstl[7] = (unsigned int  )412;
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


			
			}
			else
			{
				/* EXEC SQL SELECT (substr(:d_fm_unit_no,1,length(a.UNIT_NO_PREFIX))||substr(:d_fm_unit_no,length(a.UNIT_NO_PREFIX)+1,2)||' '||substr(:d_fm_unit_no,length(a.UNIT_NO_PREFIX)+3))  ,
				'00',
				substr(:d_fm_unit_no,1,length(a.UNIT_NO_PREFIX))||substr(:d_fm_unit_no,length(a.UNIT_NO_PREFIX)+1,2),
				substr(:d_fm_unit_no,length(a.UNIT_NO_PREFIX)+3)
				into :nd_unit_no_split, :nd_unit_no_seq,
					:nd_unit_no_split1, :nd_unit_no_split2
				FROM BT_PRODUCT_MAST a
				WHERE a.product_code=:d_fm_product_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (((substr(:b0,1,length(a.UNIT_NO_PREFIX))||substr(\
:b0,(length(a.UNIT_NO_PREFIX)+1),2))||' ')||substr(:b0,(length(a.UNIT_NO_PREFI\
X)+3))) ,'00' ,(substr(:b0,1,length(a.UNIT_NO_PREFIX))||substr(:b0,(length(a.U\
NIT_NO_PREFIX)+1),2)) ,substr(:b0,(length(a.UNIT_NO_PREFIX)+3)) into :b6,:b7,:\
b8,:b9  from BT_PRODUCT_MAST a where a.product_code=:b10";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1666;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[0] = (unsigned int  )412;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[1] = (unsigned int  )412;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[2] = (unsigned int  )412;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[3] = (unsigned int  )412;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[4] = (unsigned int  )412;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[5] = (unsigned int  )412;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split;
    sqlstm.sqhstl[6] = (unsigned int  )412;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_seq;
    sqlstm.sqhstl[7] = (unsigned int  )412;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split1;
    sqlstm.sqhstl[8] = (unsigned int  )412;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split2;
    sqlstm.sqhstl[9] = (unsigned int  )412;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_fm_product_code;
    sqlstm.sqhstl[10] = (unsigned int  )412;
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



				if(NO_DATA_FOUND)
				{
					/* EXEC SQL SELECT (substr(:d_fm_unit_no,1,5)||substr(:d_fm_unit_no,6,2)||' '||substr(:d_fm_unit_no,8)) ,
					'00',
					substr(:d_fm_unit_no,1,5)||substr(:d_fm_unit_no,6,2),
					substr(:d_fm_unit_no,8)				
					into :nd_unit_no_split, :nd_unit_no_seq,
							:nd_unit_no_split1, :nd_unit_no_split2
					FROM dual; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 16;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select (((substr(:b0,1,5)||substr(:b0,6,2))||' ')||subst\
r(:b0,8)) ,'00' ,(substr(:b0,1,5)||substr(:b0,6,2)) ,substr(:b0,8) into :b6,:b\
7,:b8,:b9  from dual ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1725;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_fm_unit_no;
     sqlstm.sqhstl[0] = (unsigned int  )412;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_fm_unit_no;
     sqlstm.sqhstl[1] = (unsigned int  )412;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_fm_unit_no;
     sqlstm.sqhstl[2] = (unsigned int  )412;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&d_fm_unit_no;
     sqlstm.sqhstl[3] = (unsigned int  )412;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&d_fm_unit_no;
     sqlstm.sqhstl[4] = (unsigned int  )412;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&d_fm_unit_no;
     sqlstm.sqhstl[5] = (unsigned int  )412;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split;
     sqlstm.sqhstl[6] = (unsigned int  )412;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_seq;
     sqlstm.sqhstl[7] = (unsigned int  )412;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split1;
     sqlstm.sqhstl[8] = (unsigned int  )412;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split2;
     sqlstm.sqhstl[9] = (unsigned int  )412;
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


				}
			}
		}
		else
		{
			/* EXEC SQL SELECT (substr(:d_unit_no[h_no_of_rec],1,length(a.UNIT_NO_PREFIX))||substr(:d_unit_no[h_no_of_rec],length(a.UNIT_NO_PREFIX)+1,2)||' '||substr(:d_unit_no[h_no_of_rec],length(a.UNIT_NO_PREFIX)+3))  ,
			'00',
			substr(:d_fm_unit_no,1,length(a.UNIT_NO_PREFIX))||substr(:d_fm_unit_no,length(a.UNIT_NO_PREFIX)+1,2),
			substr(:d_fm_unit_no,length(a.UNIT_NO_PREFIX)+3)
			into :nd_unit_no_split, :nd_unit_no_seq,
						:nd_unit_no_split1, :nd_unit_no_split2
			FROM BT_PRODUCT_MAST a
			WHERE a.product_code=:d_fm_product_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select (((substr(:b0,1,length(a.UNIT_NO_PREFIX))||substr(:\
b0,(length(a.UNIT_NO_PREFIX)+1),2))||' ')||substr(:b0,(length(a.UNIT_NO_PREFIX\
)+3))) ,'00' ,(substr(:b3,1,length(a.UNIT_NO_PREFIX))||substr(:b3,(length(a.UN\
IT_NO_PREFIX)+1),2)) ,substr(:b3,(length(a.UNIT_NO_PREFIX)+3)) into :b6,:b7,:b\
8,:b9  from BT_PRODUCT_MAST a where a.product_code=:b10";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1780;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[1] = (unsigned int  )43;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[2] = (unsigned int  )43;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_fm_unit_no;
   sqlstm.sqhstl[3] = (unsigned int  )412;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_fm_unit_no;
   sqlstm.sqhstl[4] = (unsigned int  )412;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_fm_unit_no;
   sqlstm.sqhstl[5] = (unsigned int  )412;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split;
   sqlstm.sqhstl[6] = (unsigned int  )412;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_seq;
   sqlstm.sqhstl[7] = (unsigned int  )412;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split1;
   sqlstm.sqhstl[8] = (unsigned int  )412;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split2;
   sqlstm.sqhstl[9] = (unsigned int  )412;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_fm_product_code;
   sqlstm.sqhstl[10] = (unsigned int  )412;
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



			if(NO_DATA_FOUND)
			{
				/* EXEC SQL SELECT (substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2)||' '||substr(:d_unit_no[h_no_of_rec],8)) ,
				'00',
				substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2),
				substr(:d_unit_no[h_no_of_rec],8)
				into :nd_unit_no_split, :nd_unit_no_seq,
						:nd_unit_no_split1, :nd_unit_no_split2
				FROM dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (((substr(:b0,1,5)||substr(:b0,6,2))||' ')||substr\
(:b0,8)) ,'00' ,(substr(:b0,1,5)||substr(:b0,6,2)) ,substr(:b0,8) into :b6,:b7\
,:b8,:b9  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1839;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[1] = (unsigned int  )43;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[2] = (unsigned int  )43;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[3] = (unsigned int  )43;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[4] = (unsigned int  )43;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_unit_no[h_no_of_rec];
    sqlstm.sqhstl[5] = (unsigned int  )43;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split;
    sqlstm.sqhstl[6] = (unsigned int  )412;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_seq;
    sqlstm.sqhstl[7] = (unsigned int  )412;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split1;
    sqlstm.sqhstl[8] = (unsigned int  )412;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split2;
    sqlstm.sqhstl[9] = (unsigned int  )412;
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


			}
		}
	}

	else
	{

		if (strcmp(a_pgm_id.arr,"BDRALILB") == 0)
		{	
			/* EXEC SQL SELECT (substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2)||' '||substr(:d_unit_no[h_no_of_rec],8))  ,
			lpad(substr(:d_unit_no[h_no_of_rec],instr(:d_unit_no[h_no_of_rec],'-')+1),2,'0'),
//			lpad(:d_rownum_ali[h_no_of_rec],2,'0'),
			substr(:d_unit_no[h_no_of_rec],1, 5)||substr(:d_unit_no[h_no_of_rec],6,2),
			substr(:d_unit_no[h_no_of_rec],8)
			into :nd_unit_no_split, :nd_unit_no_seq,
					:nd_unit_no_split1, :nd_unit_no_split2
			FROM dual; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select (((substr(:b0,1,5)||substr(:b0,6,2))||' ')||substr(\
:b0,8)) ,lpad(substr(:b0,(instr(:b0,'-')+1)),2,'0') ,(substr(:b0,1,5)||substr(\
:b0,6,2)) ,substr(:b0,8) into :b8,:b9,:b10,:b11  from dual ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1894;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[1] = (unsigned int  )43;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[2] = (unsigned int  )43;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[3] = (unsigned int  )43;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[5] = (unsigned int  )43;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[6] = (unsigned int  )43;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[7] = (unsigned int  )43;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split;
   sqlstm.sqhstl[8] = (unsigned int  )412;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_seq;
   sqlstm.sqhstl[9] = (unsigned int  )412;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_unit_no_split1;
   sqlstm.sqhstl[10] = (unsigned int  )412;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_unit_no_split2;
   sqlstm.sqhstl[11] = (unsigned int  )412;
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


		}
		else if (strcmp(a_pgm_id.arr,"BDRUNTLB") == 0)
		{
			if (strcmp(d_sample_ind.arr,"AD") == 0)
			{
				/* EXEC SQL SELECT (substr(:d_fm_unit_no,1,8)||' '||substr(:d_fm_unit_no,9)) , 
				'00',
				substr(:d_fm_unit_no,1,8),
				substr(:d_fm_unit_no,9)				
				into :nd_unit_no_split, :nd_unit_no_seq,
						:nd_unit_no_split1, :nd_unit_no_split2
				FROM dual; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ((substr(:b0,1,8)||' ')||substr(:b0,9)) ,'00' ,sub\
str(:b0,1,8) ,substr(:b0,9) into :b4,:b5,:b6,:b7  from dual ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1957;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[0] = (unsigned int  )412;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[1] = (unsigned int  )412;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[2] = (unsigned int  )412;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[3] = (unsigned int  )412;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_unit_no_split;
    sqlstm.sqhstl[4] = (unsigned int  )412;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_unit_no_seq;
    sqlstm.sqhstl[5] = (unsigned int  )412;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split1;
    sqlstm.sqhstl[6] = (unsigned int  )412;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_split2;
    sqlstm.sqhstl[7] = (unsigned int  )412;
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


			
			}
			else
			{
				/* EXEC SQL SELECT (substr(:d_fm_unit_no,1,5)||substr(:d_fm_unit_no,6,2)||' '||substr(:d_fm_unit_no,8))  ,
					'00',
						substr(:d_fm_unit_no,1,5)||Substr(:d_fm_unit_no,6,2),
						substr(:d_fm_unit_no,8)
					into :nd_unit_no_split, :nd_unit_no_seq,
							:nd_unit_no_split1, :nd_unit_no_split2
					FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select (((substr(:b0,1,5)||substr(:b0,6,2))||' ')||substr\
(:b0,8)) ,'00' ,(substr(:b0,1,5)||Substr(:b0,6,2)) ,substr(:b0,8) into :b6,:b7\
,:b8,:b9  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2004;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[0] = (unsigned int  )412;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[1] = (unsigned int  )412;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[2] = (unsigned int  )412;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[3] = (unsigned int  )412;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[4] = (unsigned int  )412;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[5] = (unsigned int  )412;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split;
    sqlstm.sqhstl[6] = (unsigned int  )412;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_seq;
    sqlstm.sqhstl[7] = (unsigned int  )412;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split1;
    sqlstm.sqhstl[8] = (unsigned int  )412;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split2;
    sqlstm.sqhstl[9] = (unsigned int  )412;
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


			}				
		}
		else
		{	
			/* EXEC SQL SELECT (substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2)||' '||substr(:d_unit_no[h_no_of_rec],8))  ,
			'00',
			substr(:d_unit_no[h_no_of_rec],1,5)||substr(:d_unit_no[h_no_of_rec],6,2),
			substr(:d_unit_no[h_no_of_rec],8)
			into :nd_unit_no_split, :nd_unit_no_seq,
					:nd_unit_no_split1, :nd_unit_no_split2
			FROM dual; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select (((substr(:b0,1,5)||substr(:b0,6,2))||' ')||substr(\
:b0,8)) ,'00' ,(substr(:b0,1,5)||substr(:b0,6,2)) ,substr(:b0,8) into :b6,:b7,\
:b8,:b9  from dual ";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2059;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[1] = (unsigned int  )43;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[2] = (unsigned int  )43;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[3] = (unsigned int  )43;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[4] = (unsigned int  )43;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_unit_no[h_no_of_rec];
   sqlstm.sqhstl[5] = (unsigned int  )43;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_unit_no_split;
   sqlstm.sqhstl[6] = (unsigned int  )412;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_unit_no_seq;
   sqlstm.sqhstl[7] = (unsigned int  )412;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_unit_no_split1;
   sqlstm.sqhstl[8] = (unsigned int  )412;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_unit_no_split2;
   sqlstm.sqhstl[9] = (unsigned int  )412;
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


		}
	}

	nd_unit_no_split.arr[nd_unit_no_split.len]	= '\0';
	nd_unit_no_split1.arr[nd_unit_no_split1.len]	= '\0';
	nd_unit_no_split2.arr[nd_unit_no_split2.len]	= '\0';
	nd_unit_no_seq.arr[nd_unit_no_seq.len]		= '\0';

//sprintf(string_var, "Split value  %s", nd_unit_no_split.arr);

	strcpy(d_unit_no_split[h_no_of_rec].arr, nd_unit_no_split.arr);
	d_unit_no_split[h_no_of_rec].len = strlen(d_unit_no_split[h_no_of_rec].arr);

	strcpy(d_unit_no_split1[h_no_of_rec].arr, nd_unit_no_split1.arr);
	d_unit_no_split1[h_no_of_rec].len = strlen(d_unit_no_split1[h_no_of_rec].arr);

	strcpy(d_unit_no_split2[h_no_of_rec].arr, nd_unit_no_split2.arr);
	d_unit_no_split2[h_no_of_rec].len = strlen(d_unit_no_split2[h_no_of_rec].arr);

	strcpy(d_unit_no_seq[h_no_of_rec].arr, nd_unit_no_seq.arr);
	d_unit_no_seq[h_no_of_rec].len = strlen(d_unit_no_seq[h_no_of_rec].arr);

	if(OERROR)
	{
		sprintf(string_var,"%s get_center_code-> %s\n", d_unit_no[h_no_of_rec].arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

 }

get_donation_details()
  {

	nd_donor_id.arr[0]='\0';
	nd_donor_id.len=0;

	nd_donation_process.arr[0]='\0';
	nd_donation_process.len=0;

	nd_collection_date.arr[0]='\0';
	nd_collection_date.len=0;

	temp_unit_no.arr[0]	=	'\0';
	temp_unit_no.len	= 0;

    if ((strcmp(a_pgm_id.arr,"BDRALILB") == 0) && (isb_flag == 1)) /* if condition added by sunil on 13-aug-2008*/
	{
		/* EXEC SQL 	 SELECT DONOR_ID,NVL(DONATION_PROCESS, DONATION_TYPE), to_char(BLEEDING_END_DATETIME, 'DD/MM/YYYY')
				 INTO :nd_donor_id,:nd_donation_process, :nd_collection_date
				 FROM BD_DONOR_Q_P_HDR
				 WHERE UNIT_NO=:d_fm_unit_no
				 AND operating_facility_id = :d_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DONOR_ID ,NVL(DONATION_PROCESS,DONATION_TYPE) ,to_ch\
ar(BLEEDING_END_DATETIME,'DD/MM/YYYY') into :b0,:b1,:b2  from BD_DONOR_Q_P_HDR\
 where (UNIT_NO=:b3 and operating_facility_id=:b4)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2114;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_donor_id;
  sqlstm.sqhstl[0] = (unsigned int  )202;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_donation_process;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_collection_date;
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_fm_unit_no;
  sqlstm.sqhstl[3] = (unsigned int  )412;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[4] = (unsigned int  )43;
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
	else if ((strcmp(a_pgm_id.arr,"BDRSCRLB") == 0) && (isb_flag == 1)) /* if condition added by sunil on 13-aug-2008*/
	{
		/* EXEC SQL 	 SELECT DONOR_ID,NVL(DONATION_PROCESS, DONATION_TYPE), to_char(BLEEDING_END_DATETIME, 'DD/MM/YYYY')
				 INTO :nd_donor_id,:nd_donation_process, :nd_collection_date
				 FROM BD_DONOR_Q_P_HDR
				 WHERE UNIT_NO=:d_unit_no[h_no_of_rec] AND PRODUCT_CODE=:d_fm_product_code
				 AND operating_facility_id = :d_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DONOR_ID ,NVL(DONATION_PROCESS,DONATION_TYPE) ,to_ch\
ar(BLEEDING_END_DATETIME,'DD/MM/YYYY') into :b0,:b1,:b2  from BD_DONOR_Q_P_HDR\
 where ((UNIT_NO=:b3 and PRODUCT_CODE=:b4) and operating_facility_id=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2149;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_donor_id;
  sqlstm.sqhstl[0] = (unsigned int  )202;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_donation_process;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_collection_date;
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
  sqlstm.sqhstl[3] = (unsigned int  )43;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_fm_product_code;
  sqlstm.sqhstl[4] = (unsigned int  )412;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[5] = (unsigned int  )43;
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

  
	}        
	else if ( ( (strcmp(a_pgm_id.arr,"BDRSPRLB") == 0) ) && (isb_flag == 1)) /* if condition added by sunil on 13-aug-2008*/
	{
		/* EXEC SQL 	 SELECT DONOR_ID,'R', to_char(DONATION_DATE, 'DD/MM/YYYY')
				 INTO :nd_donor_id,:nd_donation_process, :nd_collection_date
				 FROM BD_BLOOD_UNITS_MAST
				 WHERE UNIT_NO=:d_unit_no[h_no_of_rec] AND PRODUCT_CODE=:d_fm_product_code
				 AND operating_facility_id = :d_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DONOR_ID ,'R' ,to_char(DONATION_DATE,'DD/MM/YYYY') i\
nto :b0,:b1,:b2  from BD_BLOOD_UNITS_MAST where ((UNIT_NO=:b3 and PRODUCT_CODE\
=:b4) and operating_facility_id=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2188;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_donor_id;
  sqlstm.sqhstl[0] = (unsigned int  )202;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_donation_process;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_collection_date;
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
  sqlstm.sqhstl[3] = (unsigned int  )43;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_fm_product_code;
  sqlstm.sqhstl[4] = (unsigned int  )412;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[5] = (unsigned int  )43;
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

 
	}        
	else if (((strcmp(a_pgm_id.arr,"BDRCONVL") == 0) ) && (isb_flag == 1)) /* if condition added by sunil on 13-aug-2008*/
	{
		/* EXEC SQL 	 SELECT DONOR_ID,NVL(donation_type, 'R'), to_char(DONATION_DATE, 'DD/MM/YYYY')
				 INTO :nd_donor_id,:nd_donation_process, :nd_collection_date
				 FROM BD_BLOOD_UNITS_MAST
				 WHERE UNIT_NO = :d_unit_no[h_no_of_rec] AND PRODUCT_CODE=:d_fm_product_code
				 AND operating_facility_id = :d_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DONOR_ID ,NVL(donation_type,'R') ,to_char(DONATION_D\
ATE,'DD/MM/YYYY') into :b0,:b1,:b2  from BD_BLOOD_UNITS_MAST where ((UNIT_NO=:\
b3 and PRODUCT_CODE=:b4) and operating_facility_id=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2227;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_donor_id;
  sqlstm.sqhstl[0] = (unsigned int  )202;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_donation_process;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_collection_date;
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
  sqlstm.sqhstl[3] = (unsigned int  )43;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_fm_product_code;
  sqlstm.sqhstl[4] = (unsigned int  )412;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[5] = (unsigned int  )43;
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

  
		
				
				strcpy(temp_unit_no.arr, d_unit_no[h_no_of_rec].arr);
				temp_unit_no.len = strlen(temp_unit_no.arr);


			/* EXEC SQL EXECUTE
				DECLARE
					p_out_unit_no			VARCHAR2(100);
					p_out_product_code		VARCHAR2(100);
					p_out_convert_ind		VARCHAR2(10);
					p_actual_donation_proc	VARCHAR2(20);
					p_out_donation_proc		VARCHAR2(20);
					p_unit_no				VARCHAR2(100);

				BEGIN

				
						BD_PARENT_UNIT_PROCESS(:d_facility_id, :temp_unit_no,
									:d_fm_product_code, 'CO', p_out_unit_no,
									p_out_product_code, p_out_convert_ind, 
									p_actual_donation_proc,
									p_out_donation_proc);

						:nd_donation_process := NVL(p_actual_donation_proc, 'R');

				END;
			END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "declare p_out_unit_no VARCHAR2 ( 100 ) ; p_out_product_cod\
e VARCHAR2 ( 100 ) ; p_out_convert_ind VARCHAR2 ( 10 ) ; p_actual_donation_pro\
c VARCHAR2 ( 20 ) ; p_out_donation_proc VARCHAR2 ( 20 ) ; p_unit_no VARCHAR2 (\
 100 ) ; BEGIN BD_PARENT_UNIT_PROCESS ( :d_facility_id , :temp_unit_no , :d_fm\
_product_code , 'CO' , p_out_unit_no , p_out_product_code , p_out_convert_ind \
, p_actual_donation_proc , p_out_donation_proc ) ; :nd_donation_process := NVL\
 ( p_actual_donation_proc , 'R' ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2266;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&temp_unit_no;
   sqlstm.sqhstl[1] = (unsigned int  )102;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_fm_product_code;
   sqlstm.sqhstl[2] = (unsigned int  )412;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_donation_process;
   sqlstm.sqhstl[3] = (unsigned int  )22;
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

	else
	{
		/* EXEC SQL 	 SELECT DONOR_ID, NVL(DONATION_PROCESS, DONATION_TYPE), to_char(BLEEDING_END_DATETIME, 'DD/MM/YYYY')
				 INTO :nd_donor_id,:nd_donation_process, :nd_collection_date
				 FROM BD_DONOR_Q_P_HDR
				 WHERE UNIT_NO=:d_unit_no[h_no_of_rec] AND PRODUCT_CODE=:d_fm_product_code
				 AND operating_facility_id = :d_facility_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 16;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select DONOR_ID ,NVL(DONATION_PROCESS,DONATION_TYPE) ,to_ch\
ar(BLEEDING_END_DATETIME,'DD/MM/YYYY') into :b0,:b1,:b2  from BD_DONOR_Q_P_HDR\
 where ((UNIT_NO=:b3 and PRODUCT_CODE=:b4) and operating_facility_id=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2297;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_donor_id;
  sqlstm.sqhstl[0] = (unsigned int  )202;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_donation_process;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_collection_date;
  sqlstm.sqhstl[2] = (unsigned int  )43;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_unit_no[h_no_of_rec];
  sqlstm.sqhstl[3] = (unsigned int  )43;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_fm_product_code;
  sqlstm.sqhstl[4] = (unsigned int  )412;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[5] = (unsigned int  )43;
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

 
	}        
	
	//fprintf(f2,"\nDONOR_ID = %s  DONATION_PROCESS=%s",nd_donor_id.arr,nd_donation_process.arr);
	nd_donor_id.arr[nd_donor_id.len]='\0';
	nd_donation_process.arr[nd_donation_process.len]	= '\0';
	nd_collection_date.arr[nd_collection_date.len]		= '\0';

	strcpy(d_donor_id[h_no_of_rec].arr, nd_donor_id.arr);
	d_donor_id[h_no_of_rec].len = strlen(d_donor_id[h_no_of_rec].arr);
	
	strcpy(d_donation_process[h_no_of_rec].arr, nd_donation_process.arr);
	d_donation_process[h_no_of_rec].len = strlen(d_donation_process[h_no_of_rec].arr);

/* EXEC SQL EXECUTE
	DECLARE
	s_date   VARCHAR2(50);
	BEGIN
	GET_LOCALE_DATE_2t.CONVERT_TO_LOCALE_DATE (to_date(:nd_collection_date,'DD/MM/YYYY'), :language_id , s_date, 'DD Mon YYYY');
	:nd_collection_date := s_date;
	END;
END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 16;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "declare s_date VARCHAR2 ( 50 ) ; BEGIN GET_LOCALE_DATE_2t . C\
ONVERT_TO_LOCALE_DATE ( to_date ( :nd_collection_date , 'DD/MM/YYYY' ) , :lang\
uage_id , s_date , 'DD Mon YYYY' ) ; :nd_collection_date := s_date ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2336;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&nd_collection_date;
sqlstm.sqhstl[0] = (unsigned int  )43;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&language_id;
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



	strcpy(d_collection_date[h_no_of_rec].arr, nd_collection_date.arr);
	d_collection_date[h_no_of_rec].len = strlen(d_collection_date[h_no_of_rec].arr);
	
	if(OERROR)
	{
		sprintf(string_var,"%s get_center_code-> %s\n", d_unit_no[h_no_of_rec].arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}
  }

print_isb_label(int position)
{
int kl =0;

//Barcode
/*	if ((strcmp(a_pgm_id.arr,"BDRSCRLB") == 0) && (isb_flag == 1)) /* if condition added by sunil on 18-aug-2008*/
/*	{
		if ( ( f1 = fopen ( filename3, "w" ) ) == NULL ) 
		{	
		ins_message(ERR_MESG,"Error in opening output file...\n");  
		}
	}
	else
	{
		if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
		{	
		ins_message(ERR_MESG,"Error in opening output file...\n");  
		}
	}
    if (strcmp(nd_printer_type.arr,"3")!= 0)
    {
      fprintf(f1, "%cE", ESC);
      set_fonts();
    }
*/	
//atoi(nd_printer_type.arr)
	
	nd_printer_type.arr[0]='3';
	nd_printer_type.arr[1]='\0';

	print_barcode(f1,d_unit_no[position].arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
	fprintf(f1,"\n"); 
	print_barcode(f1,d_bld_grp_rh_barcode[position].arr, 0,0,  40, 250,atoi(nd_printer_type.arr));
	fprintf(f1,"\n"); 
	
//	fprintf(f1,"%s\n",d_unit_no[position].arr);
//	fprintf(f1,"%s\n",d_unit_no_split[position].arr);
	fprintf(f1,"%s\n",d_unit_no_split1[position].arr);
	fprintf(f1,"%s\n",d_unit_no_split2[position].arr);

/*	if (strcmp(a_pgm_id.arr,"BDRALILB") == 0)
	{
		kl = position;
		kl++;
		if (kl <=9)
		{
		fprintf(f1,"0%d\n",kl);
		}
		else
		fprintf(f1,"%d\n",kl);
	}
	else
	{
		fprintf(f1,"%s\n","00");
	}
*/
	fprintf(f1,"%s\n",d_unit_no_seq[position].arr);
	strcpy(chk_unit,d_unit_no[position].arr);
	CalculateChecksum(chk_unit);
	fprintf(f1,"%s\n",chk_sum);
	fprintf(f1,"%s\n",d_bld_grp_rh_barcode[position].arr);
	
//Value
	 
	fprintf(f1,"____________________\n");
	// commented by sunil  fprintf(f1,"%-s\n",d_center_code[position].arr);

	
	initialize_out_var();

	
	rl_split_text(d_center_desc[position].arr, ' ', 35, v_out_string1,
			v_out_string2, v_out_string3, v_out_string4);

	fprintf(f1,"%-s\n",v_out_string1);
	if (strlen(v_out_string2) == 0)
	{
		strcpy(v_out_string2, " ");
	}

	fprintf(f1,"%-s\n",v_out_string2);

	
	
	//fprintf(f1,"%s\n"," ");

	fprintf(f1, "%s:\n",local_legend[10]); /*	added by sunil on 01-Jun-2006 against CRF */
	fprintf(f1, "%-s\n",d_collection_date[position].arr); /*	added by sunil on 01-Jun-2006 against CRF */
	fprintf(f1,"____________________\n");
	//fprintf(f1,"%s\n",d_blood_group[position].arr);
	fprintf(f1,"%s\n",d_blood_grp_for_disp[position].arr);/*above line commented and this added by sunil on 05/01/2010*/
	// fprintf(f1,"%-s\n",d_prod_barcode_msg1[position].arr);
	strcpy(split_text.arr, d_prod_barcode_msg1[position].arr);
	split_text.arr[strlen(split_text.arr)]='\0';
	split_text.len = strlen(split_text.arr); 
	splitting();
/*	sprintf(string_var,"value of b : %d",b);
	for(i=1;i <= (65-a) ;i++)
	{
		fprintf(f1,"%s"," ");
	}	
*/	//fprintf(f1,"%-65.15s","               ");
	for (i=b; i< 5; i++)
	{
		fprintf(f1,"%s\n"," "); 
	}
//sprintf(string_var, "proces type   %s  ---- %s", d_donation_process[position].arr, local_legend[14]);

	//fprintf(f1,"%s\n",d_blood_group_desc[position].arr);/*added by sunil on 05/01/2010 and commented as per dineshs intructions and below line added*/
	fprintf(f1,"%s\n"," ");/*added by sunil on 05/01/2010*/
	fprintf(f1,"%s\n",d_rhesus_desc[position].arr);
	//commented by sunilfprintf(f1,"%-s\n",d_blood_group[position].arr);
	//fprintf(f1,"%-s\n",d_donation_process[position].arr);
	if (strcmp(d_donation_process[position].arr,"R") == 0 )
		fprintf(f1, "%-s\n",local_legend[6]);
	else if (strcmp(d_donation_process[position].arr,"P") == 0 )
		fprintf(f1, "%-s\n",local_legend[7]);
	else if (strcmp(d_donation_process[position].arr,"C") == 0 )
		fprintf(f1, "%-s\n",local_legend[8]);
	else if (strcmp(d_donation_process[position].arr,"D") == 0 )
		fprintf(f1, "%-s\n",local_legend[9]);
	else if (strcmp(d_donation_process[position].arr,"T") == 0 )
		fprintf(f1, "%-s\n",local_legend[14]);
	
	// commented by sunil fprintf(f1,"%-s\n",d_rhesus_code[position].arr);
	
//Barcode

//atoi(nd_printer_type.arr)

//	print_barcode(f1,d_donor_id[position].arr,0,0,  40, 250,atoi(nd_printer_type.arr));
	print_barcode(f1,d_product_code[position].arr,0,0,  40, 250,atoi(nd_printer_type.arr));
	fprintf(f1,"\n");
	//fprintf(f1,"\nX%-sX",d_donor_id[position].arr,135,135);
	
	print_barcode(f1,d_expiry_date2[position].arr, 0,0,  40, 250,atoi(nd_printer_type.arr));
	fprintf(f1,"\n");
	
//	fprintf(f1,"%s",d_donor_id[position].arr); 
	fprintf(f1,"%s",d_product_code[position].arr); 
	fprintf(f1,"\n");
	fprintf(f1,"%s\n",d_expiry_date2[position].arr);
	fprintf(f1, "%s\n",local_legend[12]);/*added by sunil 0n 13-Aug-2008 against CRF*/
	fprintf(f1, "%s\n",local_legend[13]);/*added by sunil 0n 13-Aug-2008 against CRF*/
	fprintf(f1,"%s\n",d_expiry_date3[position].arr);
	
//	fprintf(f1,"%-s\n",d_product_long_desc[position].arr);
	strcpy(split_text.arr, d_product_long_desc[position].arr);
	split_text.arr[strlen(split_text.arr)]='\0';
	split_text.len = strlen(split_text.arr);


	initialize_out_var();

	rl_split_text(split_text.arr, ' ', 20, v_out_string1,
			v_out_string2, v_out_string3, v_out_string4);


		fprintf(f1,"%-20.20s\n", v_out_string1);
		if (strlen(v_out_string2) == 0)
		{
				strcpy(v_out_string2, " ");
		}
		fprintf(f1,"%-20.20s\n", v_out_string2);


/*	for (i=b; i< 2; i++)
	{
		fprintf(f1,"%s\n"," "); 
	}
*/	

	fprintf(f1, "%-s\n", d_antigen_desc.arr);/* added sunil js on 08/08/2008*/
	fprintf(f1, "%-s\n", d_antigen_desc2.arr);/* added by sunil on 05/01/2010*/
	fprintf(f1, "%-s\n", d_antigen_desc3.arr);/* added by sunil on 05/01/2010*/
	fprintf(f1, "%-s\n", d_antigen_desc4.arr);/* added by sunil on 05/01/2010*/
	fprintf(f1, "%-s\n", d_antigen_desc5.arr);/* added by sunil on 05/01/2010*/
	fprintf(f1, "%-s\n", d_antigen_desc6.arr);/* added by sunil on 05/01/2010*/
	fprintf(f1, "%-s\n", d_antigen_desc7.arr);/* added by sunil on 05/01/2010*/
	fprintf(f1, "%-s\n", d_antigen_desc8.arr);/* added by sunil on 05/01/2010*/
	fprintf(f1, "%-s\n", d_antigen_desc9.arr);/* added by sunil on 05/01/2010*/
	fprintf(f1, "%-s\n", d_antigen_desc10.arr);/*added by sunil on 05/01/2010*/
/*
	initialize_out_var();

	rl_split_text(d_antigen_desc.arr, ' ', 32, v_out_string1,
			v_out_string2, v_out_string3, v_out_string4);

		if (strlen(v_out_string1) == 0)
		{
				strcpy(v_out_string1, " ");
		}
		fprintf(f1,"%-s\n", v_out_string1);

		if (strlen(v_out_string2) == 0)
		{
				strcpy(v_out_string2, " ");
		}
		fprintf(f1,"%-s\n", v_out_string2);
		if (strlen(v_out_string3) == 0)
		{
				strcpy(v_out_string3, " ");
		}
		fprintf(f1,"%-s\n", v_out_string3);
		if (strlen(v_out_string4) == 0)
		{
				strcpy(v_out_string4, " ");
		}
		fprintf(f1,"%-s\n", v_out_string4);
to be uncommented for multiple antigen codes 02/12/2009 sunil */

	//fprintf(f1, "%s: %-s\n",local_legend[1], d_store_instr_desc[position].arr);/*added by sunil 0n 01-Jun-2008 against CRF*/
		/*above line commented and moved down on 05/01/2010*/
	
	// fprintf(f1,"%s\n",d_prod_barcode_msg2[position].arr);
	strcpy(split_text.arr, d_prod_barcode_msg2[position].arr);
	split_text.arr[strlen(split_text.arr)]='\0';
	split_text.len = strlen(split_text.arr);
	splitting();
	for (i=b; i< 5; i++)
	{
		fprintf(f1,"%s\n"," "); 
	}
	fprintf(f1, "%s: %-s\n",local_legend[1], d_store_instr_desc[position].arr);/*added by sunil on 05/01/2010*/
	fprintf(f1,"%s: %-4d %s",local_legend[11], d_volume[position], d_volume_units[position].arr);

	fclose(f1);
//	print_barcode_label(1);
}

get_product_desc()
{

	nd_prod_barcode_msg1.arr[0]	= '\0';
	nd_prod_barcode_msg1.len	= 0;

	nd_prod_barcode_msg2.arr[0]	= '\0';
	nd_prod_barcode_msg2.len	= 0;

	nd_product_barcode_value.arr[0]	= '\0';
	nd_product_barcode_value.len	= 0;

	nd_product_long_desc.arr[0]	= '\0';
	nd_product_long_desc.len	= 0;

        d_store_instr_code.arr[0]		     = '\0';
	d_store_instr_code.len		         = 0;

        d_store_instr_desc_temp.arr[0]	     = '\0';
	d_store_instr_desc_temp.len		     = 0;

	d_product_desc[h_no_of_rec].arr[0]	 = '\0';
	d_product_desc[h_no_of_rec].len		 = 0;

	d_store_instr_desc[h_no_of_rec].arr[0]	 = '\0';
	d_store_instr_desc[h_no_of_rec].len		 = 0;

	strcpy(d_product_code_temp.arr, d_product_code[h_no_of_rec].arr);
	d_product_code_temp.len = strlen(d_product_code_temp.arr);

	/* EXEC SQL  SELECT store_instr_code, long_desc,
					SUBSTR(PRODUCT_BARCODE_MESS1, 1, 200),
					SUBSTR(PRODUCT_BARCODE_MESS2, 1, 200),
					PRODUCT_BARCODE_CODE, long_desc
	            INTO :d_store_instr_code, :d_product_desc_temp,:nd_prod_barcode_msg1,
			:nd_prod_barcode_msg2,:nd_product_barcode_value, :nd_product_long_desc 
	            FROM bt_product_mast_lang_vw
               WHERE product_code = :d_product_code_temp
	       and language_id= :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select store_instr_code ,long_desc ,SUBSTR(PRODUCT_BARCODE_M\
ESS1,1,200) ,SUBSTR(PRODUCT_BARCODE_MESS2,1,200) ,PRODUCT_BARCODE_CODE ,long_d\
esc into :b0,:b1,:b2,:b3,:b4,:b5  from bt_product_mast_lang_vw where (product_\
code=:b6 and language_id=:b7)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2359;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_store_instr_code;
 sqlstm.sqhstl[0] = (unsigned int  )112;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_product_desc_temp;
 sqlstm.sqhstl[1] = (unsigned int  )1012;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_prod_barcode_msg1;
 sqlstm.sqhstl[2] = (unsigned int  )2502;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_prod_barcode_msg2;
 sqlstm.sqhstl[3] = (unsigned int  )2502;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_product_barcode_value;
 sqlstm.sqhstl[4] = (unsigned int  )452;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_product_long_desc;
 sqlstm.sqhstl[5] = (unsigned int  )412;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_product_code_temp;
 sqlstm.sqhstl[6] = (unsigned int  )43;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&language_id;
 sqlstm.sqhstl[7] = (unsigned int  )27;
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
	{
		sprintf(string_var,"%s get_product_desc()-> %s\n", d_fm_unit_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
    {
      d_product_desc[h_no_of_rec].arr[d_product_desc[h_no_of_rec].len]   = '\0';
      d_product_desc[h_no_of_rec].len = strlen(d_product_desc[h_no_of_rec].arr);

    }

	d_store_instr_code.arr[d_store_instr_code.len]   = '\0';
	d_product_desc_temp.arr[d_product_desc_temp.len] = '\0';
	
		
	nd_prod_barcode_msg1.arr[nd_prod_barcode_msg1.len]   = '\0';
//	nd_prod_barcode_msg1.len = strlen(nd_prod_barcode_msg1.arr);
	
	nd_prod_barcode_msg2.arr[nd_prod_barcode_msg2.len]   = '\0';
//	nd_prod_barcode_msg2.len = strlen(nd_prod_barcode_msg2.arr);
	
	nd_product_barcode_value.arr[nd_product_barcode_value.len]   = '\0';
//	nd_product_barcode_value.len = strlen(nd_product_barcode_value.arr);
	
	nd_product_long_desc.arr[nd_product_long_desc.len]   = '\0';
//	nd_product_long_desc.len = strlen(nd_product_long_desc.arr);
	
	strcpy(d_prod_barcode_msg1[h_no_of_rec].arr, nd_prod_barcode_msg1.arr);
        d_prod_barcode_msg1[h_no_of_rec].len = strlen(d_prod_barcode_msg1[h_no_of_rec].arr);
	
    	strcpy(d_prod_barcode_msg2[h_no_of_rec].arr,nd_prod_barcode_msg2.arr);
	d_prod_barcode_msg2[h_no_of_rec].len = strlen(d_prod_barcode_msg2[h_no_of_rec].arr);
	

	strcpy(d_product_barcode_value[h_no_of_rec].arr, nd_product_barcode_value.arr);
	d_product_barcode_value[h_no_of_rec].len = strlen(d_product_barcode_value[h_no_of_rec].arr);
	
	strcpy(d_product_long_desc[h_no_of_rec].arr,nd_product_long_desc.arr);
	d_product_long_desc[h_no_of_rec].len = strlen(d_product_long_desc[h_no_of_rec].arr);
	
	strcpy(d_product_desc[h_no_of_rec].arr, d_product_desc_temp.arr );
	d_product_desc[h_no_of_rec].len = strlen(d_product_desc[h_no_of_rec].arr);
	

	d_store_instr_desc_temp.arr[0] = '\0';
	d_store_instr_desc_temp.len = 0;
	
	/* EXEC SQL  SELECT long_desc
	            INTO :d_store_instr_desc_temp
	            FROM bd_storage_instruction_lang_vw
               WHERE store_instr_code = :d_store_instr_code
	       and language_id=:language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from bd_storage_instruction_lang_\
vw where (store_instr_code=:b1 and language_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2406;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_store_instr_desc_temp;
 sqlstm.sqhstl[0] = (unsigned int  )1002;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_store_instr_code;
 sqlstm.sqhstl[1] = (unsigned int  )112;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&language_id;
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


	
	if(OERROR)
	{
		sprintf(string_var,"%s get_product_desc()-> %s\n", d_fm_unit_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

    if(NO_DATA_FOUND)
    {
		d_store_instr_desc_temp.arr[0] = '\0';
		d_store_instr_desc_temp.len = 0;
      
    }

    d_store_instr_desc_temp.arr[d_store_instr_desc_temp.len]   = '\0';

    strcpy(d_store_instr_desc[h_no_of_rec].arr, d_store_instr_desc_temp.arr );
    d_store_instr_desc[h_no_of_rec].len = strlen(d_store_instr_desc[h_no_of_rec].arr);

}
	
/**************************select transaction based or not ***************/
get_trans_ind()
{
	
	nd_trx_ind.arr[0]		= '\0';
	nd_trx_ind.len		= 0;

	/* EXEC SQL  SELECT NVL(TRANSACTION_BASED_YN, 'N')
	            INTO :nd_trx_ind
	            FROM sy_online_print_id
               WHERE MODULE_ID = 'BD'
   		         AND ONLINE_PRINT_NAME = :a_pgm_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(TRANSACTION_BASED_YN,'N') into :b0  from sy_onlin\
e_print_id where (MODULE_ID='BD' and ONLINE_PRINT_NAME=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2433;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_trx_ind;
 sqlstm.sqhstl[0] = (unsigned int  )22;
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
		sprintf(string_var,"%s get_trans_ind()-> %s\n", d_fm_unit_no.arr, sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
	}

	nd_trx_ind.arr[nd_trx_ind.len]   = '\0';

    if(NO_DATA_FOUND)
	  nd_trx_ind.arr[nd_trx_ind.len]   = '\0';
		
       if (strcmp(nd_trx_ind.arr, "Y") == 0)
	 {
		strcpy(nd_print_source_type.arr, nd_source_type.arr);
		strcpy(nd_print_source.arr, nd_fm_source.arr);

	 }
	 else
	 {
	        strcpy(nd_print_source_type.arr, "O");
        	strcpy(nd_print_source.arr, " ");
	 }
	 nd_print_source_type.len = strlen(nd_print_source_type.arr);
	 nd_print_source.len = strlen(nd_print_source.arr);


}

call_main_report()
{
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
  int v_i = 0;

  if (strcmp(a_pgm_id.arr,"BDRUNTLB") == 0 )
  {

    if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
    {
      ins_message(ERR_MESG,"Error in opening output file...\n");  
    }

    if (strcmp(nd_printer_type.arr,"3")!= 0)
    {	
      fprintf(f1, "%cE", ESC);
      set_fonts();
    }
	get_label_gen_yn(); // added by sunil 0n 03032009
	get_unit_no();	// added by sunil 0n 03032009
    print_unit_label(v_i);
    fclose(f1);

    if (strcmp(nd_printer_type.arr,"3")!= 0)
    {	
      fprintf(f1, "%cE", ESC);
      set_fonts();
    }

    if (err_flag == 0)
    {      
	  /*-- Addded by Gopikannan for online_barcode_label for MEDICITY on 05/06/2014 --*/
	  // print_barcode_label(1); 
	  //sprintf(string_var,"2 - [%d]  [%s]  [%s]  [%s]",isb_flag, a_pgm_id.arr, nd_print_source_type.arr, nd_print_source.arr );
	  //disp_message(ERR_MESG,string_var); 
	  
		if ((strcmp(l_customer_id.arr,"MC") == 0) && (strcmp(a_pgm_id.arr,"BDRSCRLB") == 0))
		{			
			online_barcode_label(1); 
		}
		else
		{
			print_barcode_label(1); 
		}
    }
  }


  for (v_i=0;v_i<h_no_of_rec;v_i++)
  {
//	if (((strcmp(a_pgm_id.arr,"BDRSCRLB") == 0)||(strcmp(a_pgm_id.arr,"BDRSPRLB") == 0)||(strcmp(a_pgm_id.arr,"BDRALILB") == 0)||(strcmp(a_pgm_id.arr,"BDRCONVL") == 0) ) && (isb_flag == 1)) /* if condition added by sunil on 18-aug-2008*/
/*	{
		if ( ( f1 = fopen ( filename3, "w" ) ) == NULL ) 
		{	
		ins_message(ERR_MESG,"Error in opening output file...\n");  
		}
	}
	else
	{
		if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
		{	
		ins_message(ERR_MESG,"Error in opening output file...\n");  
		}
	}
upto here commented on 29/09/2008	*/


    if ( ( f1 = fopen ( filename, "w" ) ) == NULL ) 
    {
      ins_message(ERR_MESG,"Error in opening output file...\n");  
    }

    if (strcmp(nd_printer_type.arr,"3")!= 0)
    {
      fprintf(f1, "%cE", ESC);
      set_fonts();
    }

    if (strcmp(a_pgm_id.arr,"BDRUSRLB") == 0 )
    {
      print_unscreened_label(v_i);
    }
    else if (strcmp(a_pgm_id.arr,"BDRSCRLB") == 0 )
    {
	  if(isb_flag == 1)
		{
		   print_isb_label(v_i);
		   }
	  else
		
	      print_screened_label(v_i);
    }
    else if (strcmp(a_pgm_id.arr,"BDRSCIBT") == 0 )
    {
	  if(isb_flag == 1)
		{
		   print_isb_label(v_i);
		   }
	  else
	      print_screened_label(v_i);
    }
//added for aliquot 
	else if (strcmp(a_pgm_id.arr,"BDRALILB") == 0 )
    {
	   if(isb_flag == 1) 
		  
		   print_isb_label(v_i);
	  else

		  print_screened_label(v_i);

    }
    
//added by for screened LABEL
    else if (strcmp(a_pgm_id.arr,"BDRSPRLB") == 0 )
    {
	   if(isb_flag == 1) 
		   print_isb_label(v_i);
	  else

	      print_screened_label(v_i);
    }
    else if (strcmp(a_pgm_id.arr,"BDRCONVL") == 0 )
    {
	   if(isb_flag == 1) 
		   print_isb_label(v_i);
	  else

	      print_screened_label(v_i);
    }
	fclose(f1);

    if (strcmp(nd_printer_type.arr,"3")!= 0)
    {	
      fprintf(f1, "%cE", ESC);
      set_fonts();
    }

    if (err_flag == 0)
    {
	  /*-- Addded by Gopikannan for online_barcode_label for MEDICITY on 05/06/2014 --*/
	  // print_barcode_label(1); 
	  //sprintf(string_var,"2 - [%d]  [%s]  [%s]  [%s]",isb_flag, a_pgm_id.arr, nd_print_source_type.arr, nd_print_source.arr );
	  //disp_message(ERR_MESG,string_var); 
	  
		if ((strcmp(l_customer_id.arr,"MC") == 0) && (strcmp(a_pgm_id.arr,"BDRSCRLB") == 0))
		{
			online_barcode_label(1); 
		}
		else
		{
			print_barcode_label(1); 
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
	           WHERE  module_id = 'BD'
	           AND    online_print_name = :a_pgm_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(printer_type,'1') into :b0  from SY_ONLINE_PRIN\
T_ID where (module_id='BD' and online_print_name=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2456;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_printer_type;
   sqlstm.sqhstl[0] = (unsigned int  )22;
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

}


print_unit_label(int v_ind)
{
int aa=0; 

	strcpy(chk_unit,d_fm_unit_no.arr);
	CalculateChecksum(chk_unit);
/*
sprintf(string_var,"[%d]  [%s]  [%s]  [%s]  [%s]",isb_flag, a_pgm_id.arr, b_pgm_id.arr, 
			filename1, filename2 );

*/
   if (strcmp(strupr(filename1), "BDRUNTLB.LIS") == 0)
   {
   
   /* EXEC SQL 	 SELECT DONOR_ID
				 INTO :nd_donor_id
				 FROM BD_DONOR_Q_P_HDR
				 WHERE UNIT_NO=:d_fm_unit_no AND PRODUCT_CODE=:d_fm_product_code
				 AND operating_facility_id = :d_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select DONOR_ID into :b0  from BD_DONOR_Q_P_HDR where ((UN\
IT_NO=:b1 and PRODUCT_CODE=:b2) and operating_facility_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2479;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_donor_id;
   sqlstm.sqhstl[0] = (unsigned int  )202;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_fm_unit_no;
   sqlstm.sqhstl[1] = (unsigned int  )412;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_fm_product_code;
   sqlstm.sqhstl[2] = (unsigned int  )412;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[3] = (unsigned int  )43;
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


				 
				 if (NO_DATA_FOUND)
	{
		  /* EXEC SQL 	 SELECT DONOR_ID
				 INTO :nd_donor_id
				 FROM BD_DONOR_DEFER_MGMT
				 WHERE SAMPLE_NO=:d_fm_unit_no  and sample_type='AM'
				 AND operating_facility_id = :d_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 16;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select DONOR_ID into :b0  from BD_DONOR_DEFER_MGMT where \
((SAMPLE_NO=:b1 and sample_type='AM') and operating_facility_id=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2510;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_donor_id;
    sqlstm.sqhstl[0] = (unsigned int  )202;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_fm_unit_no;
    sqlstm.sqhstl[1] = (unsigned int  )412;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
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


	}
				 				 
		print_barcode(f1, d_fm_unit_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
		fprintf(f1,"\n");
		fprintf(f1, "%s\n", d_fm_unit_no.arr);
		if (strcmp(l_customer_id.arr,"KDAH") == 0)
		{		
		fprintf(f1,"%s\n","");//added for to avoid overlap issue
		fprintf(f1,"%s\n",nd_donor_id.arr); /*Added by Nandhini against KDAH-CRF-375*/ 
		}
   }
   else
   {
		if (strcmp(isb_unit_no_format.arr,"P") == 0)
		{
			while(d_NumOfCopies > aa)
			{
				if ((d_NumOfCopies - aa) ==1)
				{
					print_barcode(f1, d_fm_unit_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
					fprintf(f1,"~");
					fprintf(f1,"\n");
//					fprintf(f1, "%s~\n", d_fm_unit_no.arr);
//					fprintf(f1, "%s~\n",d_unit_no_split[h_no_of_rec].arr);
					fprintf(f1, "%s~\n",d_unit_no_split1[h_no_of_rec].arr);
					fprintf(f1, "%s~\n",d_unit_no_split2[h_no_of_rec].arr);
					if(isb_flag == 1) // added on 29/09/2008
					{
						fprintf(f1,"00~\n");
						fprintf(f1,"%s~\n",chk_sum);
					}
					aa++;
				}
				else
				{
					print_barcode(f1, d_fm_unit_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
					fprintf(f1,"~");
					print_barcode(f1, d_fm_unit_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
					fprintf(f1,"\n");
//					fprintf(f1, "%s~", d_fm_unit_no.arr);
//					fprintf(f1, "%s\n", d_fm_unit_no.arr);
//					fprintf(f1, "%s~",d_unit_no_split[h_no_of_rec].arr);
//					fprintf(f1, "%s~\n",d_unit_no_split[h_no_of_rec].arr);
					fprintf(f1, "%s~",d_unit_no_split1[h_no_of_rec].arr);
					fprintf(f1, "%s\n",d_unit_no_split1[h_no_of_rec].arr);
					fprintf(f1, "%s~",d_unit_no_split2[h_no_of_rec].arr);
					fprintf(f1, "%s\n",d_unit_no_split2[h_no_of_rec].arr);
					if(isb_flag == 1) // added on 29/09/2008
					{
						fprintf(f1,"00~");
						fprintf(f1,"00\n");
						fprintf(f1,"%s~",chk_sum);
						fprintf(f1,"%s\n",chk_sum);
					}
					aa++;aa++;
				}
			}
			if (d_NumOfCopies>1)
			{
				d_NumOfCopies =1;
			}
		}
		else
		{
			print_barcode(f1, d_fm_unit_no.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
			fprintf(f1,"\n");
//			fprintf(f1, "%s\n", d_fm_unit_no.arr);
//			fprintf(f1, "%s\n",d_unit_no_split[h_no_of_rec].arr);
			fprintf(f1, "%s\n",d_unit_no_split1[h_no_of_rec].arr);
			fprintf(f1, "%s\n",d_unit_no_split2[h_no_of_rec].arr);
			if(isb_flag == 1) // added on 29/09/2008
			{
				fprintf(f1,"00\n");
				fprintf(f1,"%s\n",chk_sum);
			}
		}
	}
}

print_unscreened_label(int v_ind)
{

	fprintf(f1, "%-13s", d_donation_date[v_ind].arr);
	fprintf(f1, "%-s\n", d_product_desc[v_ind].arr);
	sprintf(d_unit_barcode_value.arr,"%s %s ", d_unit_no[v_ind].arr, d_product_code[v_ind].arr);
//	sprintf(d_unit_barcode_value.arr,"%s %s %d/%d", d_unit_no[v_ind].arr, d_product_code[v_ind].arr, v_ind+1, h_no_of_rec);

	if (strcmp(nd_printer_type.arr,"3")!=0)	
	  {
	     print_barcode(f1,d_unit_barcode_value.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
	     fprintf(f1,"\n");  
	  }
	else
	 {
	     print_barcode(f1, d_unit_barcode_value.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
	     fprintf(f1,"\n");
	 }
	//fprintf(f1, "%-s\n", d_blood_group[v_ind].arr);
	fprintf(f1, "%-s\n", d_blood_grp_for_disp[v_ind].arr);/*above line commented and this line added by sunil on 05/01/2010*/
	fprintf(f1, "%-s\n", d_rhesus_code[v_ind].arr);
	fprintf(f1, "%-d", d_volume[v_ind]);
	fprintf(f1, " %s\n", d_volume_unit[v_ind].arr);
	fprintf(f1, "%-s %d/%d\n", d_unit_barcode_value.arr,v_ind+1,h_no_of_rec);
	//fprintf(f1, "%-s\n", "UNSCREENED");
	fprintf(f1, "%-s\n",local_legend[5]);
	
}

print_screened_label(int v_ind)
{
   	//sprintf(string_var,"print_screened_label() - v_ind[%d] h_no_of_rec[%d]",v_ind,h_no_of_rec);
	//disp_message(ERR_MESG,string_var); 

	fprintf(f1, "%-s\n", d_facility_name.arr);
	fprintf(f1, "%-s\n", d_product_desc[v_ind].arr);
	fprintf(f1, "%s: %-s\n",local_legend[1], d_store_instr_desc[v_ind].arr);


	fprintf(f1, "%s: %-s\n",local_legend[2], d_donation_date[v_ind].arr);
	fprintf(f1, "%s: %-s\n",local_legend[3], d_expiry_date1[v_ind].arr);
//	fprintf(f1, "FOR FRACTIONATION\n");
	//fprintf(f1, "%-s\n", d_blood_group[v_ind].arr);
	fprintf(f1, "%-s\n", d_blood_grp_for_disp[v_ind].arr);/*above line commented and this line added by sunil on 05/01/2010*/
	fprintf(f1, "%-d", d_volume[v_ind]);
	fprintf(f1, " %s\n", d_volume_unit[v_ind].arr);
	fprintf(f1, "%-s\n", d_rhesus_code[v_ind].arr);
	sprintf(d_unit_barcode_value.arr,"%s %s", d_unit_no[v_ind].arr, d_product_code[v_ind].arr);
//	sprintf(d_unit_barcode_value.arr,"%s %s %d/%d", d_unit_no[v_ind].arr, d_product_code[v_ind].arr, v_ind+1, h_no_of_rec);
	if (strcmp(nd_printer_type.arr,"3")!=0)	
	  {
	     print_barcode(f1,d_unit_barcode_value.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));
	     fprintf(f1,"\n");  
	  }
	else
	 {
	     print_barcode(f1, d_unit_barcode_value.arr, 0, 0, 40, 250,atoi(nd_printer_type.arr));		
	     fprintf(f1,"\n");
	 }
	fprintf(f1, "%-s %d/%d\n", d_unit_barcode_value.arr,v_ind+1,h_no_of_rec);
//	fprintf(f1, "    SCREENED");
	fprintf(f1, "%s \n",local_legend[4]);
}


/***************** Print BarCode Label ********************/
print_barcode_label(int nolabel)
 {
    int i;
    int WSPrintstatus;

	//sprintf(string_var,"print_barcode_label() - nolabel[%d]",nolabel);
	//disp_message(ERR_MESG,string_var); 
	
    for(i=0;i<nolabel;i++)
		  {
/*
sprintf(string_var,"[%d]  [%s]  [%s]  [%s]",isb_flag, a_pgm_id.arr,  
			nd_print_source_type.arr, nd_print_source.arr );


*/


//commented on 29/09/2008		    if (((strcmp(a_pgm_id.arr,"BDRSCRLB") == 0)||(strcmp(a_pgm_id.arr,"BDRSPRLB") == 0)||(strcmp(a_pgm_id.arr,"BDRALILB") == 0)||(strcmp(a_pgm_id.arr,"BDRCONVL") == 0)) && (isb_flag == 1)) /* if condition added by sunil on 13-aug-2008*/
		    if (isb_flag == 1) /*  added by sunil on 29/092008*/
			{ 
		 		if (nd_source_type.arr[0]	== '!')
				{	
					 WSPrintDocument 
						   (
							uid_pwd.arr,		//char	*PUidPwd;
							nd_session_id.arr,	//char	*PSessionID;
							d_facility_id.arr,	//char	*PFacilityID;
							"BD",				//char	*PModuleID;
							b_pgm_id.arr,		//char	*PDocumentID;
							filename,	    	//char	*POnlinePrintFileNames;
							"O",				//char	*PLocationTypes;
							" ",				//char	*PLocationCodes;
							d_NumOfCopies,		//int	PNumOfCopies;
							1,				    //int	PPageFrom;
							9999,				//int	PPageTo;
							nd_ws_no.arr,		//char	*PWorkstationID
							WORKING_DIR			//char	*PReportOutputDir
						   );
				}						   
				else
				{
					WSPrintstatus =		 WSPrintDocument
						   (
							uid_pwd.arr,				//char	*PUidPwd;
							nd_session_id.arr,			//char	*PSessionID;
							d_facility_id.arr,			//char	*PFacilityID;
							"BD",						//char	*PModuleID;
							b_pgm_id.arr,				//char	*PDocumentID;
							filename,	    			//char	*POnlinePrintFileNames;
							nd_print_source_type.arr,	//char	*PLocationTypes;
							nd_print_source.arr,	    //char	*PLocationCodes;
							d_NumOfCopies,				//int	PNumOfCopies;
							1,							//int	PPageFrom;
							9999,						//int	PPageTo;
							nd_ws_no.arr,				//char	*PWorkstationID
							WORKING_DIR					//char	*PReportOutputDir
						   );
				}
			}
			else
			{ 

				if (nd_source_type.arr[0]	== '!')
				{					
					 WSPrintDocument 
						   (
							uid_pwd.arr,		//char	*PUidPwd;
							nd_session_id.arr,	//char	*PSessionID;
							d_facility_id.arr,	//char	*PFacilityID;
							"BD",				//char	*PModuleID;
							a_pgm_id.arr,			//char	*PDocumentID;
							filename,	    	//char	*POnlinePrintFileNames;
							"O",				//char	*PLocationTypes;
							" ",				//char	*PLocationCodes;
							d_NumOfCopies,		//int	PNumOfCopies;
							1,				    //int	PPageFrom;
							9999,				//int	PPageTo;
							nd_ws_no.arr,		//char	*PWorkstationID
							WORKING_DIR			//char	*PReportOutputDir
						   );
				}						   
				else
				{
					WSPrintstatus =		 WSPrintDocument
						   (
							uid_pwd.arr,				//char	*PUidPwd;
							nd_session_id.arr,			//char	*PSessionID;
							d_facility_id.arr,			//char	*PFacilityID;
							"BD",						//char	*PModuleID;
							a_pgm_id.arr,					//char	*PDocumentID;
							filename,	    			//char	*POnlinePrintFileNames;
							nd_print_source_type.arr,	//char	*PLocationTypes;
							nd_print_source.arr,	    //char	*PLocationCodes;
							d_NumOfCopies,				//int	PNumOfCopies;
							1,							//int	PPageFrom;
							9999,						//int	PPageTo;
							nd_ws_no.arr,				//char	*PWorkstationID
							WORKING_DIR					//char	*PReportOutputDir
						   );
				}
			}	  					   
		  }
 }

/*----------------------------------------------------------------------------- 
FUNCTION NAME			: online_barcode_label()
DESCRIPTION            	: This functions will convert .LIS files to .ZPL files
						  and Print the ZPL file.
						  Using the TYPE command print the file using system()
						  function.
TABLES USED            	: SM_PRINT_ROUTING, SM_PRINTER 
MODIFIED BY				: Gopikannan P
MODIFIED ON				: 07-Jun-2014	
REASON					: Fine Tuned for Better Performance
-----------------------------------------------------------------------------*/
online_barcode_label(int nolabel1)
{
	char l_comm_line[1000];
	int  status;
	FILE *ifp,*ofp;
	int  i,col,row,line_no,rot,font,horm,verm,spec_flag=0;
	char buffer[200],imag;	
	char *tmp_buf;
	int  bldline = 0;
	int  printcopies1;	
	int	 LVLen;
	
	//printcopies1 = d_NumOfCopies;
	
	sprintf(string_var,"online_barcode_label()") ;
	//ins_message(ORA_MESG, string_var);	
	//disp_message(ERR_MESG,string_var); 

	
	ifp = fopen(filename,"r");
	if (ifp==NULL)
	{
		sprintf(string_var,"File Opening-r Error");
		ins_message(ORA_MESG, string_var);
	    //disp_message(ERR_MESG,string_var); 
		return 0;
	}
	
	strcpy(ZPLFileName,filename);
	LVLen = strlen(filename);
	strncpy(ZPLFileName+(LVLen-3),"ZPL",3);	
	
	ofp = fopen(ZPLFileName,"w");  
	if (ofp==NULL)
	{
		sprintf(string_var,"File Opening-w Error");
		ins_message(ORA_MESG, string_var);
	    //disp_message(ERR_MESG,string_var); 
		return 0;
	}		
		
	fprintf(ofp,"\nN\n");           //To initialize EPL interprter in the printer.

	if (BVLanguageIsAPL == 1)
		fprintf(ofp,"D8\n");		//For Argox printer
	else
		fprintf(ofp,"D2\n");        //stating line

 	col = 25;  
	row = 20; 
    rot =  0;
	font=  2;
	horm=  1;
	verm=  2;
	imag= 'N';
	line_no = 1;  
	
	for(;fgets(buffer,200,ifp);)
	{

      if (buffer[0] == '') 
	  { 
		// begin of barcode //     	
		tmp_buf = strtok(buffer+1,"\n");
     	strcpy(buffer,tmp_buf);       

          	col = 25;  
	        row = 300; 
			
			fprintf(ofp, "B%d,%d,%d,%d,%d,%d,%d,%c,\"%s\"\n",col ,row, rot, 1, 2, 4, 60,imag, buffer);  
	  }
      else     
	  {  
          if (line_no == 1)
          {
          	col = 25;  
	        row = 20; 
            font=  2;
            horm=  1;
            verm=  1;
            imag= 'R';
          }
          else if (line_no == 2) 
          {
          	col = 25;  
            row = 40; 
            font=  3;
            horm=  1;
            verm=  2;
            imag= 'N';
          }
          else if (line_no == 3)
          {
          	col = 25;  
            row = 75; 
            font=  1;
            horm=  1;
            verm=  2;
            imag= 'N';
          }
          else if (line_no == 4)
          {
          	col = 25;  
            row = 100; 
            font=  1;
            horm=  1;
            verm=  2;
            imag= 'N';
          }
          else if (line_no == 5)
          {
          	col = 25;  
            row = 125; 
            font=  1;
            horm=  1;
            verm=  2;
            imag= 'N';
          }
          else if (line_no == 6)
          {
          	col = 90;  
            row = 150; 
            font=  5;
            horm=  4;
            verm=  3;
            imag= 'R';
          }
          else if (line_no == 7)
          {
          	col = 380;  
            row = 175; 
            font=  1;
            horm=  1;
            verm=  1;
            imag= 'N';
          }
          else if (line_no == 8)
          {
          	col = 380;  
            row = 195; 
            font=  1;
            horm=  3;
            verm=  8;
            imag= 'R';
          }
          else if (line_no == 9) //barcode no need of this else if but for knowing fonts sizes
          {
          	col = 25;  
            row = 300; 
            font=  3;
            horm=  2;
            verm=  4;
          }
          else if (line_no == 10)
          {
          	col = 25;  
            row = 365; 
            font=  2;
            horm=  1;
            verm=  2;
            imag= 'N';
          }
          else if (line_no == 11)
          {
          	col = 25;  
            row = 400; 
            font=  3;
            horm=  2;
            verm=  2;
            imag= 'N';
          }

	     tmp_buf = strtok(buffer,"\n");
		 
			if (tmp_buf) 
			{
				strcpy(buffer,tmp_buf);         
				if (line_no == bldline)                                      // Make Bold 
					fprintf(ofp, "A%d,%d,%d,%d,%d,%d,%c,\"%s\"\n", col, row, rot, font, horm, verm, imag, buffer);
				else 
					fprintf(ofp, "A%d,%d,%d,%d,%d,%d,%c,\"%s\"\n", col, row, rot, font, horm, verm, imag, buffer);
            }
			else
			{
				fprintf(ofp, "A%d,%d,%d,%d,%d,%d,%c,\"%s\"\n", col, row, rot, font, horm, verm, imag, "");
		    }
			
			row = row + 20;                                            // Next line 		
	  }
		line_no = line_no+1;
	} 

	fprintf(ofp,"P%d\n",nolabel1);  /* Number of labels format  */	
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
		//disp_message(ERR_MESG,string_var); 
	}
	
	/* EXEC SQL OPEN PRINTER_ID_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0058;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2537;
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
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_print_source_type;
 sqlstm.sqhstl[2] = (unsigned int  )22;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_source_type;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_print_source;
 sqlstm.sqhstl[4] = (unsigned int  )52;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[5] = (unsigned int  )502;
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
		//disp_message(ERR_MESG,string_var); 
	}

	nd_printer_queue.arr[0] ='\0';
	nd_printer_queue.len	 = 0;

	/* EXEC SQL FETCH PRINTER_ID_CUR INTO :nd_printer_queue; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2576;
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
		//disp_message(ERR_MESG,string_var); 
	}

	if (NO_DATA_FOUND)
	{
		sprintf(string_var,"NO_DATA_FOUND PRINTER_ID_CUR %s",sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
		//disp_message(ERR_MESG,string_var); 
	}
		
	nd_printer_queue.arr[nd_printer_queue.len]   = '\0';	

	/* EXEC SQL CLOSE PRINTER_ID_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2595;
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
		//disp_message(ERR_MESG,string_var); 
	}			
		
	if (strlen(nd_printer_queue.arr) > 0)
	{
		sprintf(l_comm_line,"TYPE %s > %s",ZPLFileName, nd_printer_queue.arr);		
		//ins_message(ORA_MESG, l_comm_line);		
	    //disp_message(ERR_MESG,l_comm_line); 
		
		for (i=1;i<=nolabel1;i++)
		{				
			status = system(l_comm_line);			
		}
		
			if (status == 0) 
			{
				sprintf(string_var, "Printed Sucessfully");
				//ins_message(ORA_MESG, string_var);				
				//disp_message(ERR_MESG,string_var); 
			}
			else
			{		
				sprintf(string_var, "Invalid Printed/Path");
				ins_message(ORA_MESG, string_var);				
				//disp_message(ERR_MESG,string_var); 
			}	
	}
	else
	{
		sprintf(string_var, "Invalid Printed_ID");
		ins_message(ORA_MESG, string_var);		
		//disp_message(ERR_MESG,string_var); 
		
	}
}	

/*-- Commented for Screend Label for MEDICITY --
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

	//sprintf(string_var,"online_barcode_label()");
	//ins_message(ORA_MESG, string_var);	
	//disp_message(ERR_MESG,string_var); 

	ifp = fopen(filename,"r");
	if (ifp==NULL)
	{
		sprintf(string_var,"File Opening-r Error");
		ins_message(ORA_MESG, string_var);
	   //disp_message(ERR_MESG,string_var); 
		return 0;
	}

	sprintf(filename, "%s%s%s", filename3, a_pgm_id.arr, ".zpl");	

	ofp = fopen(filename,"w");  
	if (ofp==NULL)
	{
		sprintf(string_var,"File Opening-w Error");
		ins_message(ORA_MESG, string_var);
	    //disp_message(ERR_MESG,string_var); 
		return 0;
	}	

	fprintf(ofp,"\nN\n");           //To initialize ZBL interprter in the printer.

	if (BVLanguageIsAPL == 1)
		fprintf(ofp,"D8\n");		//For Argox printer
	else
		fprintf(ofp,"D8\n");        //stating line         
	
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
		if (buffer[0] == '') 		    
	  {              
		// begin of barcode //
		
		tmp_buf = strtok(buffer+1,"\n");		
	
    	strcpy(buffer,tmp_buf);       
		row = row + 10;
		
			fprintf(ofp, "B%d,%d,%d,%d,%d,%d,%d,%c,\"%s\"\n",col ,row, rot, 3, 2, 5, 65,imag, buffer);  		
			row = row + 75;
			spec_flag = 1;  
	  }
      else     
	  {  
	     tmp_buf = strtok(buffer,"\n");
		 
		 if (spec_flag == 1)  // to print the specimen no in big.
		   {font = 3; spec_flag=0;}           
		 else
			font = 2;

			 if (tmp_buf) 
			 {
				 strcpy(buffer,tmp_buf);         

				 if (line_no == bldline)   // Make Bold 
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

	fprintf(ofp,"P%d\n",nolabel1);  
	fclose(ofp);
	fclose(ifp);	

    nd_print_source_type.len = strlen(nd_print_source_type.arr);
	nd_print_source.len = strlen(nd_print_source.arr);
	nd_source_type.len = strlen(nd_source_type.arr);

	EXEC SQL DECLARE PRINTER_ID_CUR CURSOR FOR
	SELECT QUEUE_NAME
	  FROM sm_print_routing a, sm_printer b 
	   WHERE a.report_id = :a_pgm_id
	   AND a.printer_id1 = b.printer_id
	   AND a.dest_locn_type =  DECODE (:nd_source_type,'!', 'O',:nd_print_source_type)
       AND a.dest_locn_code =  DECODE (:nd_source_type,'!', a.dest_locn_code, NVL(LTRIM(RTRIM(:nd_print_source)),a.dest_locn_code))
       AND NVL (a.ws_no, '!!!') = NVL (:nd_ws_no, '!!!');

	if (OERROR)
	{
		sprintf(string_var,"ERROR IN PRINTER_ID_CUR %s",sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
		//disp_message(ERR_MESG,string_var); 
	}
	
	EXEC SQL OPEN PRINTER_ID_CUR;

	if (OERROR)
	{
		sprintf(string_var,"ERROR WHILE OPENING PRINTER_ID_CUR %s",sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
		//disp_message(ERR_MESG,string_var); 
	}

	nd_printer_queue.arr[0] ='\0';
	nd_printer_queue.len	 = 0;

	EXEC SQL FETCH PRINTER_ID_CUR INTO :nd_printer_queue;
	
	if (OERROR)
	{
		sprintf(string_var,"ERROR WHILE FETCHING PRINTER_ID_CUR %s",sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
		//disp_message(ERR_MESG,string_var); 
	}

	if (NO_DATA_FOUND)
	{
		sprintf(string_var,"NO_DATA_FOUND PRINTER_ID_CUR %s",sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
		//disp_message(ERR_MESG,string_var); 
	}
		
	nd_printer_queue.arr[nd_printer_queue.len]   = '\0';
	

	EXEC SQL CLOSE PRINTER_ID_CUR;

	if (OERROR)
	{
		sprintf(string_var,"ERROR WHILE CLOSING PRINTER_ID_CUR %s",sqlca.sqlerrm.sqlerrmc);
		ins_message(ORA_MESG, string_var);
		//disp_message(ERR_MESG,string_var); 
	}			
		
	if (strlen(nd_printer_queue.arr) > 0)
	{
		sprintf(l_comm_line,"TYPE %s > %s",filename, nd_printer_queue.arr);		
		//ins_message(ORA_MESG, l_comm_line);		
	    //disp_message(ERR_MESG,l_comm_line); 
		
		for (i=1;i<=nolabel1;i++)
		{				
			status = system(l_comm_line);			
		}

			if (status == 0) 
			{
				sprintf(string_var, "Printed Sucessfully");
				ins_message(ORA_MESG, string_var);				
				//disp_message(ERR_MESG,string_var); 
			}
			else
			{		
				sprintf(string_var, "Invalid Printed/Path");
				ins_message(ORA_MESG, string_var);				
				//disp_message(ERR_MESG,string_var); 
			}	
	}
	else
	{
		sprintf(string_var, "Invalid Printed_ID");
		ins_message(ORA_MESG, string_var);		
		//disp_message(ERR_MESG,string_var); 
		
	}
} --*/

/*-- End Addded by Gopikannan for Screend Label Performance Issue for MEDICITY --*/

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
         (:nd_facility_id,'BDRLBPRN',:er_msg_type,NULL, SUBSTR(:er_msg, 1, 70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/MM/YYYY')); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "insert into SY_PROG_MSG (OPERATING_FACILITY_ID,PGM_ID,MSG_\
TYPE,MSG_NUM,MSG_DESC,MSG_DATE_TIME,SESSION_ID,PGM_DATE) values (:b0,'BDRLBPRN\
',:b1,null ,SUBSTR(:b2,1,70),SYSDATE,USERENV('sessionid'),TO_CHAR(SYSDATE,'DD/\
MM/YYYY'))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2610;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )32;
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
   sqlstm.sqhstl[2] = (unsigned int  )3712;
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


splitting()
{
  
   	char word[2];
	int qq = 0, cntr = 0, z = 0, hell = 0, clt = 0, cmp = 0, t_rue = 0;
	char word1[2];
	strcpy(word1,"F");	
	a = 0; // added by sunl on 04/12/2007 
	b = 0;	// added by sunil on 13-08-2008

    _flushall(); 

     hell = strlen(split_text.arr);
		  

	     z = 0;
	     clt = 0;
	     strcpy(word1,"F");
	     cntr = 1;
	     qq = 0;

         while (z < hell)
         {
		     word[0] = split_text.arr[z];
 		     word[1] = '\0';

		     if (strcmp(word,"\n") == 0)
		     {
		       cntr = 0;

		       strcpy(word1,"N");
		       qq = z ;

			   b++; //added on 30/09/2008
		      }

  		      if(cntr >= 40)
		      {
			     cmp = cntr;
			     while((split_text.arr[z] != 32) && (cmp > 1))
			     {
			         z--;
				     cmp--;
			      }

				  qq = z;
				  			   
			      word[0] = split_text.arr[z];
   			      word[1] = '\0';
		
		  	      if (cmp == 1)
				     strcpy(word1,"W");
			      else
			         strcpy(word1,"T");
		       }
			   if (((z == hell) || (z == hell - 1)) && (strcmp(word1,"F") == 0))
			   {
				   for(i=clt;i < z + 1;i++)
		           {
		              fprintf(f1,"%c",split_text.arr[i]);
					  a++;
			       }
//			       fprintf	(f1,"\n"); COMMENTED NOW
//			       fprintf	(f1,"\n"); 
//				b++;
				   cntr = 0 ;

				   clt = clt + 40 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");
				}
			
		       if (strcmp(word1,"N") == 0) 
		       {
				  for(i=clt;i<=qq;i++)
		          {
			         fprintf(f1,"%c",split_text.arr[i]);
					
			      }
			      strcpy(word1,"F");
			      cntr = 0 ;
			      clt = qq + 1;
		          qq = 0;
	   	       }

			   if (strcmp(word1,"T") == 0)
		       {
				  for(i=clt;i<= qq;i++)
		          {
		             fprintf(f1,"%c",split_text.arr[i]);
			      }
			       fprintf	(f1,"\n");
					b++;	// added by sunil on 13-08-2008
			       cntr = 0 ;
				   clt = qq + 1 ;
			       qq = 0;
				   strcpy(word1,"F");
		        }

		        if (strcmp(word1,"W") == 0)
		        {

				   for(i=clt;i < clt + 40;i++)
		           {
		              fprintf(f1,"%c",split_text.arr[i]);
			       }

			       fprintf(f1,"\n");
					b++;	// added by sunil on 13-08-2008
				   cntr = 0 ;

				   clt = clt + 40 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");
		        }
		  
            cntr += 1;
	        z++ ;
			if (b >= 5) // added by sunil on 13-08-2008
			{
				z = hell;
				break;
			}
          }

  
       fflush(f1);

#ifdef DEBUG
   printf("split_text = %s\n", split_text.arr);
#endif

if (OERROR)
   ins_message(ORA_MESG,"Error occurred at splitting()");

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   ins_message(ORA_MESG,"Error occurred at splitting()");
   return 0;

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

}

initialize_out_var()
{

	strcpy(v_out_string1, "");
	strcpy(v_out_string2, "");
	strcpy(v_out_string3, "");
	strcpy(v_out_string4, "");

}

get_expiry_for_ali_cur()
{

  nd_expiry_date.arr[0] = '\0';
  nd_expiry_date.len = 0;



	  /* EXEC SQL SELECT TO_CHAR(expiry_date, 'DDMMYYYY HH24:MI')
			   INTO :nd_expiry_date
		       FROM BD_BLOOD_UNITS_MAST
		       WHERE unit_no = :nd_unit_no
		       AND product_code = :nd_product_code
		       AND operating_facility_id = :d_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 16;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select TO_CHAR(expiry_date,'DDMMYYYY HH24:MI') into :b0  f\
rom BD_BLOOD_UNITS_MAST where ((unit_no=:b1 and product_code=:b2) and operatin\
g_facility_id=:b3)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2637;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_expiry_date;
   sqlstm.sqhstl[0] = (unsigned int  )43;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_unit_no;
   sqlstm.sqhstl[1] = (unsigned int  )412;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_product_code;
   sqlstm.sqhstl[2] = (unsigned int  )412;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[3] = (unsigned int  )43;
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
	        ins_message (ORA_MESG, "FETCH failed c2 ");
		return 0;
      }

    if (NO_DATA_FOUND);

    nd_expiry_date.arr[nd_expiry_date.len] 	= '\0';


}

/*-- Addded by Gopikannan for online_barcode_label for MEDICITY --*/
/*-- ADDED ON 05/06/2014 For MEDICITY Label Printer Performance --*/
	
get_site_customer_id()
{
	l_customer_id.arr[0]	= '\0';
	l_customer_id.len		= 0;

	/* EXEC SQL SELECT NVL(customer_id, '!!')
		     INTO 	l_customer_id
		     FROM 	SM_SITE_PARAM; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 16;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(customer_id,'!!') into :b0  from SM_SITE_PARAM ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2668;
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