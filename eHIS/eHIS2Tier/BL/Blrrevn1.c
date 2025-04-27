
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
           char  filnam[22];
};
static const struct sqlcxp sqlfpn =
{
    21,
    "E:\\MLVER2\\Blrrevn1.pc"
};


static unsigned long sqlctx = 147111683;


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
            void  *sqhstv[31];
   unsigned int   sqhstl[31];
            int   sqhsts[31];
            void  *sqindv[31];
            int   sqinds[31];
   unsigned int   sqharm[31];
   unsigned int   *sqharc[31];
   unsigned short  sqadto[31];
   unsigned short  sqtdso[31];
} sqlstm = {10,31};

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

 static const char *sq0009 = 
"select TO_CHAR(A.TRX_DATE,'YYYY/MM') ,NVL(sum(UPD_NET_CHARGE_AMT),0) ,count(\
distinct PATIENT_ID) ,(sum(UPD_NET_CHARGE_AMT)/count(distinct PATIENT_ID))  fr\
om BL_PATIENT_CHARGES_FOLIO A ,BL_BLNG_PRT_GRP_HDR B ,BL_BLNG_GRP C where ((((\
((((A.TRX_DATE>=to_date((((('01/'||:b0)||'/')||:b1)||' 00:00:00'),'DD/MM/YYYY \
HH24:MI:SS') and A.TRX_DATE<=last_day(to_date((((('01/'||:b2)||'/')||:b3)||' 2\
3:59:59'),'DD/MM/YYYY HH24:MI:SS'))) and A.EPISODE_TYPE=DECODE(:b4,'A',EPISODE\
_TYPE,:b4)) and A.TRX_FINALIZE_IND='Y') and B.INCOME_YN='Y') and C.SETTLEMENT_\
IND='C') and A.OPERATING_FACILITY_ID between nvl(ltrim(rtrim(:b6)),'  ') and n\
vl(ltrim(rtrim(:b7)),'~~')) and A.PRT_GRP_HDR_CODE=B.PRT_GRP_HDR_CODE) and A.B\
LNG_GRP_ID=C.BLNG_GRP_ID) group by TO_CHAR(A.TRX_DATE,'YYYY/MM')           ";

 static const char *sq0010 = 
"select TO_CHAR(A.TRX_DATE,'YYYY/MM') ,NVL(sum(UPD_NET_CHARGE_AMT),0) ,count(\
distinct PATIENT_ID) ,(sum(UPD_NET_CHARGE_AMT)/count(distinct PATIENT_ID))  fr\
om BL_PATIENT_CHARGES_FOLIO A ,BL_BLNG_PRT_GRP_HDR B where (((((((A.TRX_DATE>=\
to_date((((('01/'||:b0)||'/')||:b1)||' 00:00:00'),'DD/MM/YYYY HH24:MI:SS') and\
 A.TRX_DATE<=last_day(to_date((((('01/'||:b2)||'/')||:b3)||' 23:59:59'),'DD/MM\
/YYYY HH24:MI:SS'))) and B.INCOME_YN='Y') and A.EPISODE_TYPE=DECODE(:b4,'A',EP\
ISODE_TYPE,:b4)) and A.TRX_FINALIZE_IND='Y') and A.CUST_CODE=:b6) and A.OPERAT\
ING_FACILITY_ID between nvl(ltrim(rtrim(:b7)),'  ') and nvl(ltrim(rtrim(:b8)),\
'~~')) and A.PRT_GRP_HDR_CODE=B.PRT_GRP_HDR_CODE) group by TO_CHAR(A.TRX_DATE,\
'YYYY/MM')           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,539,429,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,542,459,0,0,0,0,0,1,0,
51,0,0,3,329,0,516,556,0,0,19,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
142,0,0,4,498,0,516,696,0,0,31,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
281,0,0,5,259,0,516,762,0,0,14,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
352,0,0,6,128,0,516,841,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
383,0,0,7,118,0,514,877,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
406,0,0,8,0,0,529,919,0,0,1,1,0,1,0,1,9,0,0,
425,0,0,8,0,0,557,932,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,
472,0,0,8,0,0,525,1392,0,0,5,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
507,0,0,9,775,0,521,1439,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,
554,0,0,10,721,0,521,1467,0,0,9,9,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
605,0,0,9,0,0,525,1479,0,0,4,0,0,1,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
636,0,0,10,0,0,525,1509,0,0,4,0,0,1,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
667,0,0,11,664,0,516,1669,0,0,8,6,0,1,0,2,4,0,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
714,0,0,12,608,0,516,1734,0,0,9,7,0,1,0,2,4,0,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
765,0,0,13,544,0,516,1760,0,0,7,6,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
808,0,0,14,490,0,516,1781,0,0,8,7,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
};


 
/************************************************************************/
/* CSS MEDICOM VER 2.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRREVNU.PC                                  */
/* AUTHOR                : V.SRIKANTH                                   */
/* DATE WRITTEN          : 25/04/1999                                   */
/* DATE MODIFIED         : 02/06/1999 V.SRIKANTH                        */
/* DATE MODIFIED         : 08/02/2000 Irfan                             */
/*                                                                       */ 
/* FUNCTION              : REVENUE ANALYSIS REPORT                      */
/*                                                                      */
/* TABLE DETAILS         : BL_BLNG_GRP                                  */
/*                         BL_PATIENT_CHARGES_FOLIO                     */ 
/*                         SY_ACC_ENTITY                                */
/*                         SY_PROG_PARAM                                */
/*                                                                      */
/*                                                                      */
/* FUNCTIONS            : fetch_prm()                                  */
/*						   fetch_param()							    */
/*						   select_acc_entity()						    */
/*						   open_files()									*/
/*						   del_parm()						            */
/*						   decl_curs() 								    */
/*						   do_report()						            */
/*						   fetch_blng_grp_cur()						    */
/*						   fetch_period_values()					    */	
/*						   put_hdr()						            */
/*						   put_rec() 									*/
/*						   print_grand_total() 						    */
/*						   chk_break() 									*/
/*						   put_inp_parm() 						        */
/*						   print_end_of_rep() 						    */
/*                                                                      */
/************************************************************************/
                     
#include <stdio.h>
#include <string.h>         
#include <bl.h>                

#define NODATAFOUND sqlca.sqlcode == 1403
#define RESOURCE_BUSY (sqlca.sqlcode == -54)

#define  INIT_MESG "Report Generation In Progress"

#define DOUBLE_WIDTH 0x0E
#define EMPHASIZED_START 0x45
#define EMPHASIZED_END 0x46
#define ESC 0x1B
//#define VIEW_LOG_FILE   1

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR uid_pwd					    [91],
  	        d_session_id			    [16],
	        d_pgm_date				    [14],
	        rep_date				    [20],
	        comp_name				    [50],
	        oper_id					    [21],
			nd_operating_facility_id    [3],
			nd_pre_facility_id		    [3],
			nd_op_facility_id			[3],
			nd_cash_counter_code		[3],
			nd_pre_cash_counter_code	[3],
			nd_fr_facility              [3],
			nd_to_facility              [3],
			nd_option                   [2]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } rep_date;

struct { unsigned short len; unsigned char arr[50]; } comp_name;

struct { unsigned short len; unsigned char arr[21]; } oper_id;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_pre_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_op_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_cash_counter_code;

struct { unsigned short len; unsigned char arr[3]; } nd_pre_cash_counter_code;

struct { unsigned short len; unsigned char arr[3]; } nd_fr_facility;

struct { unsigned short len; unsigned char arr[3]; } nd_to_facility;

struct { unsigned short len; unsigned char arr[2]; } nd_option;



/*-- SY_PROG_PARAM VARIABLES */

	/* VARCHAR p_per_1				[8],
			p_per_1_1			[8],
			p_per_1_2			[8],

			p_per_2				[8],
			p_per_21			[8],
			p_per_22			[8],

			p_per_3				[8],
			p_per_31			[8],
			p_per_32			[8],

			p_per_4				[8],
			p_per_41			[8],
			p_per_42			[8],

			p_per_5				[8],
			p_per_51			[8],
			p_per_52			[8],

			p_per_6				[8],
			p_per_61			[8],
			p_per_62			[8],

			p_per_7				[8],
			p_per_71			[8],
			p_per_72			[8],

			p_per_8				[8],
			p_per_81			[8],
			p_per_82			[8],

			p_per_9				[8],
			p_per_91			[8],
			p_per_92			[8],

			p_per_10			[8],
			p_per_101			[8],
			p_per_102			[8],

			p_per_11			[8],
			p_per_111			[8],
			p_per_112			[8],

			p_per_12			[8],
			p_per_121			[8],
			p_per_122			[8]; */ 
struct { unsigned short len; unsigned char arr[8]; } p_per_1;

struct { unsigned short len; unsigned char arr[8]; } p_per_1_1;

struct { unsigned short len; unsigned char arr[8]; } p_per_1_2;

struct { unsigned short len; unsigned char arr[8]; } p_per_2;

struct { unsigned short len; unsigned char arr[8]; } p_per_21;

struct { unsigned short len; unsigned char arr[8]; } p_per_22;

struct { unsigned short len; unsigned char arr[8]; } p_per_3;

struct { unsigned short len; unsigned char arr[8]; } p_per_31;

struct { unsigned short len; unsigned char arr[8]; } p_per_32;

struct { unsigned short len; unsigned char arr[8]; } p_per_4;

struct { unsigned short len; unsigned char arr[8]; } p_per_41;

struct { unsigned short len; unsigned char arr[8]; } p_per_42;

struct { unsigned short len; unsigned char arr[8]; } p_per_5;

struct { unsigned short len; unsigned char arr[8]; } p_per_51;

struct { unsigned short len; unsigned char arr[8]; } p_per_52;

struct { unsigned short len; unsigned char arr[8]; } p_per_6;

struct { unsigned short len; unsigned char arr[8]; } p_per_61;

struct { unsigned short len; unsigned char arr[8]; } p_per_62;

struct { unsigned short len; unsigned char arr[8]; } p_per_7;

struct { unsigned short len; unsigned char arr[8]; } p_per_71;

struct { unsigned short len; unsigned char arr[8]; } p_per_72;

struct { unsigned short len; unsigned char arr[8]; } p_per_8;

struct { unsigned short len; unsigned char arr[8]; } p_per_81;

struct { unsigned short len; unsigned char arr[8]; } p_per_82;

struct { unsigned short len; unsigned char arr[8]; } p_per_9;

struct { unsigned short len; unsigned char arr[8]; } p_per_91;

struct { unsigned short len; unsigned char arr[8]; } p_per_92;

struct { unsigned short len; unsigned char arr[8]; } p_per_10;

struct { unsigned short len; unsigned char arr[8]; } p_per_101;

struct { unsigned short len; unsigned char arr[8]; } p_per_102;

struct { unsigned short len; unsigned char arr[8]; } p_per_11;

struct { unsigned short len; unsigned char arr[8]; } p_per_111;

struct { unsigned short len; unsigned char arr[8]; } p_per_112;

struct { unsigned short len; unsigned char arr[8]; } p_per_12;

struct { unsigned short len; unsigned char arr[8]; } p_per_121;

struct { unsigned short len; unsigned char arr[8]; } p_per_122;



    /* VARCHAR p_cat_type						[2],
			p_epsd_type						[2],
			p_inc_no_pat					[2],
			p_fm_post_mth					[3],
			p_to_post_mth					[3],
			p_fm_post_yr					[5],
			p_to_post_yr					[5],
			p_fm_cust_cd					[9],
			p_to_cust_cd					[9],
			p_fm_dt_1						[11],
			p_to_dt_1						[11],
			p_fm_dt_2						[11],
			p_to_dt_2						[11],
			p_fm_dt_3						[11],
			p_to_dt_3						[11],
			p_fm_dt_4						[11],
			p_to_dt_4						[11],
			p_fm_dt_5						[11],
			p_to_dt_5						[11],
			p_fm_dt_6						[11],
			p_to_dt_6						[11],
			p_fm_dt_7						[11],
			p_to_dt_7						[11],
			p_fm_dt_8						[11],
			p_to_dt_8						[11],
			p_fm_dt_9						[11],
			p_to_dt_9						[11],
			p_fm_dt_10						[11],
			p_to_dt_10						[11],
			p_fm_dt_11						[11],
			p_to_dt_11						[11],
			p_fm_dt_12						[11],
			p_to_dt_12						[11],
			p_lst_fm_dt						[11],
			p_lst_to_dt						[11],
			p_prin_lst_fm_dt				[11],
			p_prin_lst_to_dt				[11],
			print_rep_yn					[2],
			year_mon						[8],
			d_curs							[3000],
			d_mth_Sql						[3000]; */ 
struct { unsigned short len; unsigned char arr[2]; } p_cat_type;

struct { unsigned short len; unsigned char arr[2]; } p_epsd_type;

struct { unsigned short len; unsigned char arr[2]; } p_inc_no_pat;

struct { unsigned short len; unsigned char arr[3]; } p_fm_post_mth;

struct { unsigned short len; unsigned char arr[3]; } p_to_post_mth;

struct { unsigned short len; unsigned char arr[5]; } p_fm_post_yr;

struct { unsigned short len; unsigned char arr[5]; } p_to_post_yr;

struct { unsigned short len; unsigned char arr[9]; } p_fm_cust_cd;

struct { unsigned short len; unsigned char arr[9]; } p_to_cust_cd;

struct { unsigned short len; unsigned char arr[11]; } p_fm_dt_1;

struct { unsigned short len; unsigned char arr[11]; } p_to_dt_1;

struct { unsigned short len; unsigned char arr[11]; } p_fm_dt_2;

struct { unsigned short len; unsigned char arr[11]; } p_to_dt_2;

struct { unsigned short len; unsigned char arr[11]; } p_fm_dt_3;

struct { unsigned short len; unsigned char arr[11]; } p_to_dt_3;

struct { unsigned short len; unsigned char arr[11]; } p_fm_dt_4;

struct { unsigned short len; unsigned char arr[11]; } p_to_dt_4;

struct { unsigned short len; unsigned char arr[11]; } p_fm_dt_5;

struct { unsigned short len; unsigned char arr[11]; } p_to_dt_5;

struct { unsigned short len; unsigned char arr[11]; } p_fm_dt_6;

struct { unsigned short len; unsigned char arr[11]; } p_to_dt_6;

struct { unsigned short len; unsigned char arr[11]; } p_fm_dt_7;

struct { unsigned short len; unsigned char arr[11]; } p_to_dt_7;

struct { unsigned short len; unsigned char arr[11]; } p_fm_dt_8;

struct { unsigned short len; unsigned char arr[11]; } p_to_dt_8;

struct { unsigned short len; unsigned char arr[11]; } p_fm_dt_9;

struct { unsigned short len; unsigned char arr[11]; } p_to_dt_9;

struct { unsigned short len; unsigned char arr[11]; } p_fm_dt_10;

struct { unsigned short len; unsigned char arr[11]; } p_to_dt_10;

struct { unsigned short len; unsigned char arr[11]; } p_fm_dt_11;

struct { unsigned short len; unsigned char arr[11]; } p_to_dt_11;

struct { unsigned short len; unsigned char arr[11]; } p_fm_dt_12;

struct { unsigned short len; unsigned char arr[11]; } p_to_dt_12;

struct { unsigned short len; unsigned char arr[11]; } p_lst_fm_dt;

struct { unsigned short len; unsigned char arr[11]; } p_lst_to_dt;

struct { unsigned short len; unsigned char arr[11]; } p_prin_lst_fm_dt;

struct { unsigned short len; unsigned char arr[11]; } p_prin_lst_to_dt;

struct { unsigned short len; unsigned char arr[2]; } print_rep_yn;

struct { unsigned short len; unsigned char arr[8]; } year_mon;

struct { unsigned short len; unsigned char arr[3000]; } d_curs;

struct { unsigned short len; unsigned char arr[3000]; } d_mth_Sql;


/*-- BILLING GROUP CURSOR VARIABLES */

	/* VARCHAR //d_blng_grp_id  					[3],
			cd_blng_grp_id					[3],
			d_sett_ind						[2],
			d_adm_rec_flag					[2],
			d_cust_code						[9],
			cd_cust_code					[9],
			d_cust_name						[41],
			cd_cust_name					[41],
			nd_adm_rec_flag					[41],
			nd_cust_code					[9],
			nd_cust_name					[41],
			nd_sett_ind						[2]; */ 
struct { unsigned short len; unsigned char arr[3]; } cd_blng_grp_id;

struct { unsigned short len; unsigned char arr[2]; } d_sett_ind;

struct { unsigned short len; unsigned char arr[2]; } d_adm_rec_flag;

struct { unsigned short len; unsigned char arr[9]; } d_cust_code;

struct { unsigned short len; unsigned char arr[9]; } cd_cust_code;

struct { unsigned short len; unsigned char arr[41]; } d_cust_name;

struct { unsigned short len; unsigned char arr[41]; } cd_cust_name;

struct { unsigned short len; unsigned char arr[41]; } nd_adm_rec_flag;

struct { unsigned short len; unsigned char arr[9]; } nd_cust_code;

struct { unsigned short len; unsigned char arr[41]; } nd_cust_name;

struct { unsigned short len; unsigned char arr[2]; } nd_sett_ind;



int			p_no_of_mth,nom, rec_cnt,
			i;

/*-- AMOUNT HOLDING VARIABLES */

    double  d_per_1,
			d_per_1_1,
			d_per_1_2,

			d_per_2,
			d_per_21,
			d_per_22,

			d_per_3,
			d_per_31,
			d_per_32,

			d_per_4,
			d_per_41,
			d_per_42,

			d_per_5,
			d_per_51,
			d_per_52,

			d_per_6,
			d_per_61,
			d_per_62,

			d_per_7,
			d_per_71,
			d_per_72,

			d_per_8,
			d_per_81,
			d_per_82,

			d_per_9,
			d_per_91,
			d_per_92,

			d_per_10,
			d_per_101,
			d_per_102,

			d_per_11,
			d_per_111,
			d_per_112,

			d_per_12,
			d_per_121,
			d_per_122,

			d_per_sum,
			d_per_sum1,
			d_per_sum2,

			d_per_lst_sum,
			d_per_lst_sum1,
			d_per_lst_sum2,

			d_pri_lst_sum,
			d_pri_lst_sum1,
			d_pri_lst_sum2,
			
			c_d_per_1,
			c_d_per_1_1,
			c_d_per_1_2,
			c_d_per_2,
			c_d_per_21,
			c_d_per_22,
			c_d_per_3,
			c_d_per_31,
			c_d_per_32,
			c_d_per_4,
			c_d_per_41,
			c_d_per_42,
			c_d_per_5,
			c_d_per_51,
			c_d_per_52,
			c_d_per_6,
			c_d_per_61,
			c_d_per_62,
			c_d_per_7,
			c_d_per_71,
			c_d_per_72,
			c_d_per_8,
			c_d_per_81,
			c_d_per_82,
			c_d_per_9,
			c_d_per_91,
			c_d_per_92,
			c_d_per_10,
			c_d_per_101,
			c_d_per_102,
			c_d_per_11,
			c_d_per_111,
			c_d_per_112,
			c_d_per_12,
			c_d_per_121,
			c_d_per_122,
			c_d_per_sum,
			c_d_per_sum1,
			c_d_per_sum2,
			c_d_per_lst_sum,
			c_d_per_lst_sum1,
			c_d_per_lst_sum2,
			d_per_tot_1,
			d_per_tot_1_1,
			d_per_tot_1_2,
			d_per_tot_2,
			d_per_tot_21,
			d_per_tot_22,
			d_per_tot_3,
			d_per_tot_31,
			d_per_tot_32,
			d_per_tot_4,
			d_per_tot_41,
			d_per_tot_42,
			d_per_tot_5,
			d_per_tot_51,
			d_per_tot_52,
			d_per_tot_6,
			d_per_tot_61,
			d_per_tot_62,
			d_per_tot_7,
			d_per_tot_71,
			d_per_tot_72,
			d_per_tot_8,
			d_per_tot_81,
			d_per_tot_82,
			d_per_tot_9,
			d_per_tot_91,
			d_per_tot_92,
			d_per_tot_10,
			d_per_tot_101,
			d_per_tot_102,
			d_per_tot_11,
			d_per_tot_111,
			d_per_tot_112,
			d_per_tot_12,
			d_per_tot_121,
			d_per_tot_122,
			d_per_tot_sum,
			d_per_tot_sum1,
			d_per_tot_sum2,
			d_per_tot_lst_sum,
			d_per_tot_lst_sum1,
			d_per_tot_lst_sum2,
			d_per_gtot_1,
			d_per_gtot_1_1,
			d_per_gtot_1_2,
			d_per_gtot_2,
			d_per_gtot_21,
			d_per_gtot_22,
			d_per_gtot_3,
			d_per_gtot_31,
			d_per_gtot_32,
			d_per_gtot_4,
			d_per_gtot_41,
			d_per_gtot_42,
			d_per_gtot_5,
			d_per_gtot_51,
			d_per_gtot_52,
			d_per_gtot_6,
			d_per_gtot_61,
			d_per_gtot_62,
			d_per_gtot_7,
			d_per_gtot_71,
			d_per_gtot_72,
			d_per_gtot_8,
			d_per_gtot_81,
			d_per_gtot_82,
			d_per_gtot_9,
			d_per_gtot_91,
			d_per_gtot_92,
			d_per_gtot_10,
			d_per_gtot_101,
			d_per_gtot_102,
			d_per_gtot_11,
			d_per_gtot_111,
			d_per_gtot_112,
			d_per_gtot_12,
			d_per_gtot_121,
			d_per_gtot_122,
			d_per_gtot_sum,
			d_per_gtot_sum1,
			d_per_gtot_sum2,
			d_per_gtot_lst_sum,
			d_per_gtot_lst_sum1,
			d_per_gtot_lst_sum2,
			
			d_sum,
			d_tot_pat,
			d_average;



	char	filename						[150],
			string_var						[150];

int foot_ind, no_of_time_exec = 0;

/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/Blrrevn1.c-arc   1.0   Apr 19 2007 17:07:00   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/Blrrevn1.c-arc   1.0   Apr 19 2007 17:07:00   vcm_th  $ sqlda.h 
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

int		page_no,
		lno,
		g_hdr_cnt;
	
void proc_main(argc,argv)
int argc;
char *argv[];
{
	
    if(argc < 8) 
	{
		disp_message(ERR_MESG,"BLRREVN1 : Usage BLRREVN1 userid/password session_id pgm_date facility_id ");
		proc_exit();
    }

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(d_session_id.arr,argv[2]);
    d_session_id.len = strlen(d_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(d_pgm_date.arr,argv[3]);
    d_pgm_date.len = strlen(d_pgm_date.arr);

    strcpy(nd_fr_facility.arr,argv[5]);
	nd_fr_facility.len = strlen(nd_fr_facility.arr);

    strcpy(nd_to_facility.arr,argv[6]);
	nd_to_facility.len = strlen(nd_to_facility.arr);
 	
	strcpy(nd_option.arr,argv[7]);
	nd_option.len = strlen(nd_option.arr);


    strcpy(g_pgm_id,"BLRREVN1");
    strcpy(g_pgm_date,argv[3]);

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



    if(OERROR) 
	{
		disp_message(ORA_MESG,"Unable to connect to oracle.");
		proc_exit();
    }

    set_meduser_role();

	fetch_prm();
    fetch_param();
	select_acc_entity();
	open_files();	  

    page_no=1;
    lno=1;

	if (p_cat_type.arr[0] != 'C')
	{
		decl_curs();
	}

    put_inp_parm();

	do_report();

    fclose(f1);
    del_parm();
    end_prog_msg();
    /* EXEC SQL COMMIT RELEASE; */ 

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



    return;
}
            

fetch_prm()
{

	p_per_1.arr[0]			=	'\0';	
	p_per_1_1.arr[0]		=	'\0';	
	p_per_1_2.arr[0]		=	'\0';	

	p_per_2.arr[0]			=	'\0';	
	p_per_21.arr[0]			=	'\0';	
	p_per_22.arr[0]			=	'\0';	

	p_per_3.arr[0]			=	'\0';	
	p_per_31.arr[0]			=	'\0';	
	p_per_32.arr[0]			=	'\0';	

	p_per_4.arr[0]			=	'\0';	
	p_per_41.arr[0]			=	'\0';	
	p_per_42.arr[0]			=	'\0';	

	p_per_5.arr[0]			=	'\0';	
	p_per_51.arr[0]			=	'\0';	
	p_per_52.arr[0]			=	'\0';	

	p_per_6.arr[0]			=	'\0';	
	p_per_61.arr[0]			=	'\0';	
	p_per_62.arr[0]			=	'\0';	

	p_per_7.arr[0]			=	'\0';	
	p_per_71.arr[0]			=	'\0';	
	p_per_72.arr[0]			=	'\0';	

	p_per_8.arr[0]			=	'\0';	
	p_per_81.arr[0]			=	'\0';	
	p_per_82.arr[0]			=	'\0';	

	p_per_9.arr[0]			=	'\0';	
	p_per_91.arr[0]			=	'\0';	
	p_per_92.arr[0]			=	'\0';	

	p_per_10.arr[0]			=	'\0';	
	p_per_101.arr[0]		=	'\0';	
	p_per_102.arr[0]		=	'\0';	

	p_per_11.arr[0]			=	'\0';	
	p_per_111.arr[0]		=	'\0';	
	p_per_112.arr[0]		=	'\0';	

	p_per_12.arr[0]			=	'\0';	
	p_per_121.arr[0]		=	'\0';	
	p_per_122.arr[0]		=	'\0';	



	p_per_1.len				=	0;	
	p_per_1_1.len			=	0;	
	p_per_1_2.len			=	0;	
	p_per_2.len				=	0;	
	p_per_21.len			=	0;	
	p_per_22.len			=	0;	
	p_per_3.len				=	0;	
	p_per_31.len			=	0;	
	p_per_32.len			=	0;	
	p_per_4.len				=	0;		
	p_per_41.len			=	0;		
	p_per_42.len			=	0;		
	p_per_5.len				=	0;		
	p_per_51.len			=	0;		
	p_per_52.len			=	0;		
	p_per_6.len				=	0;		
	p_per_61.len			=	0;		
	p_per_62.len			=	0;		
	p_per_7.len				=	0;		
	p_per_71.len			=	0;		
	p_per_72.len			=	0;		
	p_per_8.len				=	0;		
	p_per_81.len			=	0;		
	p_per_82.len			=	0;		
	p_per_9.len				=	0;		
	p_per_91.len			=	0;		
	p_per_92.len			=	0;		
	p_per_10.len			=	0;		
	p_per_101.len			=	0;		
	p_per_102.len			=	0;		
	p_per_11.len			=	0;		
	p_per_111.len			=	0;		
	p_per_112.len			=	0;		
	p_per_12.len			=	0;		
	p_per_121.len			=	0;		
	p_per_122.len			=	0;		


	/* EXEC SQL SELECT OPERATING_FACILITY_ID,
					PARAM1,
					PARAM2, 
					PARAM3, 
					PARAM4, 
					PARAM5, 
					PARAM6, 
					PARAM7,
					PARAM8,
					PARAM9, 
					PARAM10, 
					PARAM11,
					PARAM12,
					PARAM13,
					PARAM14,
					PARAM15,
					PARAM16

		 INTO		:nd_operating_facility_id,
					:p_per_1,
					:p_per_2,
					:p_per_3,
					:p_per_4,
					:p_per_5,
					:p_per_6,
					:p_per_7,
					:p_per_8,
					:p_per_9,
					:p_per_10,
					:p_per_11,
					:p_per_12,
					:print_rep_yn,
					:nd_fr_facility,
					:nd_to_facility,
					:nd_option
		 FROM   SY_PROG_PARAM
		 WHERE  PGM_ID     = 'BLRREVN1'
		 AND    PGM_DATE   = :d_pgm_date
		 AND    SESSION_ID = :d_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,\
PARAM14 ,PARAM15 ,PARAM16 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b\
11,:b12,:b13,:b14,:b15,:b16  from SY_PROG_PARAM where ((PGM_ID='BLRREVN1' and \
PGM_DATE=:b17) and SESSION_ID=:b18)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_per_1;
 sqlstm.sqhstl[1] = (unsigned int  )10;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_per_2;
 sqlstm.sqhstl[2] = (unsigned int  )10;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&p_per_3;
 sqlstm.sqhstl[3] = (unsigned int  )10;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&p_per_4;
 sqlstm.sqhstl[4] = (unsigned int  )10;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&p_per_5;
 sqlstm.sqhstl[5] = (unsigned int  )10;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&p_per_6;
 sqlstm.sqhstl[6] = (unsigned int  )10;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&p_per_7;
 sqlstm.sqhstl[7] = (unsigned int  )10;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&p_per_8;
 sqlstm.sqhstl[8] = (unsigned int  )10;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&p_per_9;
 sqlstm.sqhstl[9] = (unsigned int  )10;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&p_per_10;
 sqlstm.sqhstl[10] = (unsigned int  )10;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&p_per_11;
 sqlstm.sqhstl[11] = (unsigned int  )10;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&p_per_12;
 sqlstm.sqhstl[12] = (unsigned int  )10;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&print_rep_yn;
 sqlstm.sqhstl[13] = (unsigned int  )4;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_fr_facility;
 sqlstm.sqhstl[14] = (unsigned int  )5;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_to_facility;
 sqlstm.sqhstl[15] = (unsigned int  )5;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_option;
 sqlstm.sqhstl[16] = (unsigned int  )4;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[17] = (unsigned int  )16;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&d_session_id;
 sqlstm.sqhstl[18] = (unsigned int  )18;
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



    if(OERROR || NO_DATA_FOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM_0",0,"");

	p_per_1.arr[p_per_1.len]					=	'\0' ;	
	p_per_2.arr[p_per_2.len]					=	'\0' ;	
	p_per_3.arr[p_per_3.len]					=	'\0' ;	
	p_per_4.arr[p_per_4.len]					=	'\0' ;	
	p_per_5.arr[p_per_5.len]					=	'\0' ;	
	p_per_6.arr[p_per_6.len]					=	'\0' ;	
	p_per_7.arr[p_per_7.len]					=	'\0' ;	
	p_per_8.arr[p_per_8.len]					=	'\0' ;	
	p_per_9.arr[p_per_9.len]					=	'\0' ;	
	p_per_10.arr[p_per_10.len]					=	'\0' ;	
	p_per_11.arr[p_per_11.len]					=	'\0' ;	
	p_per_12.arr[p_per_12.len]					=	'\0' ;	
	nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';

	strcpy(g_facility_id, nd_operating_facility_id.arr);
}

fetch_param()
{

	p_no_of_mth					=	0;

    p_cat_type.arr[0]			=	'\0';	
	p_epsd_type.arr[0]			=	'\0';	
	p_inc_no_pat.arr[0]			=	'\0';	
	p_fm_post_mth.arr[0]		=	'\0';	
	p_to_post_mth.arr[0]		=	'\0';	
	p_fm_post_yr.arr[0]			=	'\0';	
	p_to_post_yr.arr[0]			=	'\0';	
	p_fm_cust_cd.arr[0]			=	'\0';	
	p_to_cust_cd.arr[0]			=	'\0';	
	p_fm_dt_1.arr[0]			=	'\0';	
	p_to_dt_1.arr[0]			=	'\0';	
	p_fm_dt_2.arr[0]			=	'\0';	
	p_to_dt_2.arr[0]			=	'\0';	
	p_fm_dt_3.arr[0]			=	'\0';	
	p_to_dt_3.arr[0]			=	'\0';	
	p_fm_dt_4.arr[0]			=	'\0';	
	p_to_dt_4.arr[0]			=	'\0';	
	p_fm_dt_5.arr[0]			=	'\0';	
	p_to_dt_5.arr[0]			=	'\0';	
	p_fm_dt_6.arr[0]			=	'\0';	
	p_to_dt_6.arr[0]			=	'\0';	
	p_fm_dt_7.arr[0]			=	'\0';	
	p_to_dt_7.arr[0]			=	'\0';	
	p_lst_fm_dt.arr[0]			=	'\0';
	p_lst_to_dt.arr[0]			=	'\0';
	p_prin_lst_fm_dt.arr[0]		=	'\0';
	p_prin_lst_to_dt.arr[0]		=	'\0';
	p_fm_dt_8.arr[0]			=	'\0';	
	p_to_dt_8.arr[0]			=	'\0';	
	p_fm_dt_9.arr[0]			=	'\0';	
	p_to_dt_9.arr[0]			=	'\0';	
	p_fm_dt_10.arr[0]			=	'\0';	
	p_to_dt_10.arr[0]			=	'\0';	
	p_fm_dt_11.arr[0]			=	'\0';	
	p_to_dt_11.arr[0]			=	'\0';	
	p_fm_dt_12.arr[0]			=	'\0';	
	p_to_dt_12.arr[0]			=	'\0';	
    p_cat_type.len				=	0;	
	p_epsd_type.len				=	0;	
    p_inc_no_pat.len			=	0;	
	p_fm_post_mth.len			=	0;	
	p_to_post_mth.len			=	0;	
	p_fm_post_yr.len			=	0;	
	p_to_post_yr.len			=	0;	
	p_fm_cust_cd.len			=	0;
	p_to_cust_cd.len			=	0;	
	p_fm_dt_1.len				=	0;	
	p_to_dt_1.len				=	0;	
	p_fm_dt_2.len				=	0;	
	p_to_dt_2.len				=	0;		
	p_fm_dt_3.len				=	0;		
	p_to_dt_3.len				=	0;		
	p_fm_dt_4.len				=	0;		
	p_to_dt_4.len				=	0;		
	p_fm_dt_5.len				=	0;		
	p_to_dt_5.len				=	0;		
	p_fm_dt_6.len				=	0;		
	p_to_dt_6.len				=	0;		
	p_fm_dt_7.len				=	0;		
	p_to_dt_7.len				=	0;		
	p_lst_fm_dt.len				=	0;
	p_lst_to_dt.len				=	0;
	p_prin_lst_fm_dt.len		=	0;
	p_prin_lst_to_dt.len		=	0;
	p_fm_dt_8.len				=	0;		
	p_to_dt_8.len				=	0;		
	p_fm_dt_9.len				=	0;		
	p_to_dt_9.len				=	0;		
	p_fm_dt_10.len				=	0;		
	p_to_dt_10.len				=	0;		
	p_fm_dt_11.len				=	0;		
	p_to_dt_11.len				=	0;		
	p_fm_dt_12.len				=	0;		
	p_to_dt_12.len				=	0;		

	/* EXEC SQL SELECT OPERATING_FACILITY_ID,
					PARAM1,
					PARAM2, 
					PARAM3, 
					PARAM4, 
					PARAM5, 
					PARAM6, 
					PARAM7,
					PARAM8,
					PARAM11,
					PARAM12,
					PARAM13,
					PARAM14,
					PARAM15,
					PARAM16,
					PARAM17,
					PARAM18,
					PARAM19,
					PARAM20,
					PARAM21,
					PARAM22,
					PARAM23,
					PARAM24,
					PARAM27,
					PARAM28,
					PARAM25,
					PARAM26,
					PARAM29,
					PARAM30
		 INTO		:nd_operating_facility_id,
					:p_cat_type,
					:p_fm_post_mth,
					:p_to_post_mth,
					:p_fm_post_yr,
					:p_to_post_yr,
					:p_fm_cust_cd,
					:p_to_cust_cd,
					:p_no_of_mth,
					:p_fm_dt_1,
					:p_to_dt_1,
					:p_fm_dt_2,
					:p_to_dt_2,
					:p_fm_dt_3,
					:p_to_dt_3,
					:p_fm_dt_4,
					:p_to_dt_4,
					:p_fm_dt_5,
					:p_to_dt_5,
					:p_fm_dt_6,
					:p_to_dt_6,
					:p_fm_dt_7,
					:p_to_dt_7,
					:p_fm_dt_8,
					:p_to_dt_8,
					:p_lst_fm_dt,
					:p_lst_to_dt,
					:p_epsd_type,
					:p_inc_no_pat		
		 FROM   SY_PROG_PARAM
		 WHERE  PGM_ID     = 'BLRREVNU'
		 AND    PGM_DATE   = :d_pgm_date
		 AND    SESSION_ID = :d_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 31;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM4\
 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 ,PARAM15 \
,PARAM16 ,PARAM17 ,PARAM18 ,PARAM19 ,PARAM20 ,PARAM21 ,PARAM22 ,PARAM23 ,PARAM\
24 ,PARAM27 ,PARAM28 ,PARAM25 ,PARAM26 ,PARAM29 ,PARAM30 into :b0,:b1,:b2,:b3,\
:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19,:b20\
,:b21,:b22,:b23,:b24,:b25,:b26,:b27,:b28  from SY_PROG_PARAM where ((PGM_ID='B\
LRREVNU' and PGM_DATE=:b29) and SESSION_ID=:b30)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )142;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_cat_type;
 sqlstm.sqhstl[1] = (unsigned int  )4;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_fm_post_mth;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&p_to_post_mth;
 sqlstm.sqhstl[3] = (unsigned int  )5;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&p_fm_post_yr;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&p_to_post_yr;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&p_fm_cust_cd;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&p_to_cust_cd;
 sqlstm.sqhstl[7] = (unsigned int  )11;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&p_no_of_mth;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&p_fm_dt_1;
 sqlstm.sqhstl[9] = (unsigned int  )13;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&p_to_dt_1;
 sqlstm.sqhstl[10] = (unsigned int  )13;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&p_fm_dt_2;
 sqlstm.sqhstl[11] = (unsigned int  )13;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&p_to_dt_2;
 sqlstm.sqhstl[12] = (unsigned int  )13;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&p_fm_dt_3;
 sqlstm.sqhstl[13] = (unsigned int  )13;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&p_to_dt_3;
 sqlstm.sqhstl[14] = (unsigned int  )13;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&p_fm_dt_4;
 sqlstm.sqhstl[15] = (unsigned int  )13;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&p_to_dt_4;
 sqlstm.sqhstl[16] = (unsigned int  )13;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&p_fm_dt_5;
 sqlstm.sqhstl[17] = (unsigned int  )13;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&p_to_dt_5;
 sqlstm.sqhstl[18] = (unsigned int  )13;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&p_fm_dt_6;
 sqlstm.sqhstl[19] = (unsigned int  )13;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&p_to_dt_6;
 sqlstm.sqhstl[20] = (unsigned int  )13;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&p_fm_dt_7;
 sqlstm.sqhstl[21] = (unsigned int  )13;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&p_to_dt_7;
 sqlstm.sqhstl[22] = (unsigned int  )13;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&p_fm_dt_8;
 sqlstm.sqhstl[23] = (unsigned int  )13;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&p_to_dt_8;
 sqlstm.sqhstl[24] = (unsigned int  )13;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&p_lst_fm_dt;
 sqlstm.sqhstl[25] = (unsigned int  )13;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&p_lst_to_dt;
 sqlstm.sqhstl[26] = (unsigned int  )13;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&p_epsd_type;
 sqlstm.sqhstl[27] = (unsigned int  )4;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&p_inc_no_pat;
 sqlstm.sqhstl[28] = (unsigned int  )4;
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[29] = (unsigned int  )16;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&d_session_id;
 sqlstm.sqhstl[30] = (unsigned int  )18;
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR || NO_DATA_FOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM_1",0,"");

		/* EXEC SQL SELECT 
					OPERATING_FACILITY_ID,
					PARAM1,
					PARAM2, 
					PARAM3, 
					PARAM4, 
					PARAM5, 
					PARAM6, 
					PARAM7,
					PARAM8,
					PARAM9,
					PARAM10,
					PARAM11					
					
		 INTO		:nd_operating_facility_id,
					:p_fm_dt_9,
					:p_to_dt_9,
					:p_fm_dt_10,
					:p_to_dt_10,
					:p_fm_dt_11,
					:p_to_dt_11,
					:p_fm_dt_12,
					:p_to_dt_12,
					:nd_fr_facility,
					:nd_to_facility,
					:nd_option
		 FROM   SY_PROG_PARAM
		 WHERE  PGM_ID     = 'BLRREVN2'
		 AND    PGM_DATE   = :d_pgm_date
		 AND    SESSION_ID = :d_session_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 31;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARAM\
4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 into :b0,:b1,:b2,:\
b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11  from SY_PROG_PARAM where ((PGM_ID='BLRRE\
VN2' and PGM_DATE=:b12) and SESSION_ID=:b13)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )281;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&p_fm_dt_9;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&p_to_dt_9;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&p_fm_dt_10;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&p_to_dt_10;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&p_fm_dt_11;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&p_to_dt_11;
  sqlstm.sqhstl[6] = (unsigned int  )13;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&p_fm_dt_12;
  sqlstm.sqhstl[7] = (unsigned int  )13;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&p_to_dt_12;
  sqlstm.sqhstl[8] = (unsigned int  )13;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_fr_facility;
  sqlstm.sqhstl[9] = (unsigned int  )5;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&nd_to_facility;
  sqlstm.sqhstl[10] = (unsigned int  )5;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&nd_option;
  sqlstm.sqhstl[11] = (unsigned int  )4;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_pgm_date;
  sqlstm.sqhstl[12] = (unsigned int  )16;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_session_id;
  sqlstm.sqhstl[13] = (unsigned int  )18;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR || NO_DATA_FOUND)
	    err_mesg("SELECT failed on table  SY_PROG_PARAM_2",0,"");

	p_cat_type.arr[p_cat_type.len]					=	'\0' ;	
	p_epsd_type.arr[p_epsd_type.len]				=	'\0' ;	
	p_fm_post_mth.arr[p_fm_post_mth.len]			=	'\0' ;	
	p_to_post_mth.arr[p_to_post_mth.len]			=	'\0' ;	
	p_fm_post_yr.arr[p_fm_post_yr.len]				=	'\0' ;	
	p_to_post_yr.arr[p_to_post_yr.len]				=	'\0' ;	
	p_fm_cust_cd.arr[p_fm_cust_cd.len]				=	'\0' ;	
	p_to_cust_cd.arr[p_to_cust_cd.len]				=	'\0' ;	
	p_fm_dt_1.arr[p_fm_dt_1.len]					=	'\0' ;	
	p_to_dt_1.arr[p_to_dt_1.len]					=	'\0' ;	
	p_fm_dt_2.arr[p_fm_dt_2.len]					=	'\0' ;	
	p_to_dt_2.arr[p_to_dt_2.len]					=	'\0' ;	
	p_fm_dt_3.arr[p_fm_dt_3.len]					=	'\0' ;	
	p_to_dt_3.arr[p_to_dt_3.len]					=	'\0' ;	
	p_fm_dt_4.arr[p_fm_dt_4.len]					=	'\0' ;	
	p_to_dt_4.arr[p_to_dt_4.len]					=	'\0' ;	
	p_fm_dt_5.arr[p_fm_dt_5.len]					=	'\0' ;	
	p_to_dt_5.arr[p_to_dt_5.len]					=	'\0' ;	
	p_fm_dt_6.arr[p_fm_dt_6.len]					=	'\0' ;	
	p_to_dt_6.arr[p_to_dt_6.len]					=	'\0' ;	
	p_fm_dt_7.arr[p_fm_dt_7.len]					=	'\0' ;	
	p_to_dt_7.arr[p_to_dt_7.len]					=	'\0' ;	
	p_lst_fm_dt.arr[p_lst_fm_dt.len]				=	'\0' ;
	p_lst_to_dt.arr[p_lst_to_dt.len]				=	'\0' ;
	p_fm_dt_8.arr[p_fm_dt_8.len]					=	'\0' ;	
	p_to_dt_8.arr[p_to_dt_8.len]					=	'\0' ;	
	p_fm_dt_9.arr[p_fm_dt_9.len]					=	'\0' ;	
	p_to_dt_9.arr[p_to_dt_9.len]					=	'\0' ;	
	p_fm_dt_10.arr[p_fm_dt_10.len]					=	'\0' ;	
	p_to_dt_10.arr[p_to_dt_10.len]					=	'\0' ;	
	p_fm_dt_11.arr[p_fm_dt_11.len]					=	'\0' ;	
	p_to_dt_11.arr[p_to_dt_11.len]					=	'\0' ;	
	p_fm_dt_12.arr[p_fm_dt_12.len]					=	'\0' ;	
	p_to_dt_12.arr[p_to_dt_12.len]					=	'\0' ;	
	nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
	   strcpy(g_facility_id, nd_operating_facility_id.arr);
}

select_acc_entity()
{

	comp_name.arr[0]		=		'\0';
	rep_date.arr[0]			=		'\0';
	oper_id.arr[0]			=		'\0';

	/* EXEC SQL SELECT ACC_ENTITY_NAME,
					TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
					USER 
	     INTO		:comp_name,
					:rep_date,
					:oper_id
	     FROM		SY_ACC_ENTITY
		 WHERE      ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 31;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'\
) ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )352;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&comp_name;
 sqlstm.sqhstl[0] = (unsigned int  )52;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&rep_date;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&oper_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
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



    if(OERROR)
	    err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");

    comp_name.arr[comp_name.len] = '\0';
    rep_date.arr [rep_date.len]  = '\0';
    oper_id.arr  [oper_id.len]	 = '\0';

}

open_files()
{
	strcpy(filename,WORKING_DIR);
    strcat(filename,"BLRREVN1.lis");

    if( (f1=fopen(filename,"w")) == NULL) 
	{
		disp_message(ERR_MESG,"Error in opening output file...");
		proc_exit();
    }
}

del_parm()
{

/* Added the pgmid BLRREVN2 by irfan on 03/01/2000 to pass the additional
   parameter upto 12 periods instead of 8 periods */

    /* EXEC SQL DELETE SY_PROG_PARAM
	 WHERE  PGM_ID     IN  ('BLRREVNU','BLRREVN1','BLRREVN2')  
	 AND    PGM_DATE   = :d_pgm_date
	 AND    SESSION_ID = :d_session_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 31;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID in ('BLRREVNU'\
,'BLRREVN1','BLRREVN2') and PGM_DATE=:b0) and SESSION_ID=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )383;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_pgm_date;
    sqlstm.sqhstl[0] = (unsigned int  )16;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_session_id;
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
	err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 
}


decl_curs()
{
	/*-- A NEW DYNAMIC CURSOR IS ADDED TO PRINT ALL THE CUSTOMER REVENUE FOR
		 RESPECTIVE BILLING GRP FROM BILL HDR TABLE. VSK 19/06/1999 */
   
	strcpy(d_curs.arr,"SELECT DISTINCT A.CUST_CODE,B.SHORT_NAME,C.SETTLEMENT_IND,C.ADM_REC_FLAG, A.OPERATING_FACILITY_ID \
		 FROM BL_PATIENT_CHARGES_FOLIO A, AR_CUSTOMER B, BL_BLNG_GRP C , BL_BLNG_PRT_GRP_HDR D \
		 WHERE  (A.TRX_DATE >= to_date(('01/'||:p_fm_post_mth||'/'||:p_fm_post_yr||' 00:00'),'dd/mm/yyyy HH24:MI') AND \
				 A.TRX_DATE <=  last_day(to_date(('01/'||:p_to_post_mth||'/'||:p_to_post_yr||' 23:59'),'dd/mm/yyyy HH24:MI'))) AND \
				A.PRT_GRP_HDR_CODE =  D.PRT_GRP_HDR_CODE AND \
		        D.INCOME_YN = 'Y' AND \
				A.OPERATING_FACILITY_ID BETWEEN nvl(ltrim(rtrim(:nd_fr_facility)),'  ') \
		        AND     nvl(ltrim(rtrim(:nd_to_facility)),'~~') AND \
			    A.CUST_CODE = B.CUST_CODE AND \
				(A.CUST_CODE IS NOT NULL AND A.CUST_CODE BETWEEN NVL(:p_fm_cust_cd,'!!!!!!!!') AND NVL(:p_to_cust_cd,'~~~~~~~~')) ");

    if (p_cat_type.arr[0] == 'R')
	    strcat(d_curs.arr," AND A.BLNG_GRP_ID = C.BLNG_GRP_ID AND C.SETTLEMENT_IND = 'R'   ");			
	else if (p_cat_type.arr[0] == 'I')
	    strcat(d_curs.arr," AND A.BLNG_GRP_ID = C.BLNG_GRP_ID AND C.SETTLEMENT_IND = 'X' AND C.ADM_REC_FLAG = '2'  ");			
	else if (p_cat_type.arr[0] == 'O')
	    strcat(d_curs.arr," AND A.BLNG_GRP_ID = C.BLNG_GRP_ID AND C.SETTLEMENT_IND = 'X' AND C.ADM_REC_FLAG = '1'  ");			
	else if (p_cat_type.arr[0] == 'A')
		strcat(d_curs.arr," AND A.BLNG_GRP_ID = C.BLNG_GRP_ID  ");			
	
	strcat(d_curs.arr," ORDER BY A.OPERATING_FACILITY_ID, C.SETTLEMENT_IND DESC ,C.ADM_REC_FLAG DESC,B.SHORT_NAME  " );
	
    d_curs.len = strlen(d_curs.arr);

	d_curs.arr[d_curs.len] = '\0';


	/* EXEC SQL PREPARE TRANS_LIST FROM :d_curs; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 31;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )406;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_curs;
 sqlstm.sqhstl[0] = (unsigned int  )3002;
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



	if(OERROR)
		err_mesg("PREPARE failed on TRANS_LIST",0,"");


    		
	/* EXEC SQL DECLARE TRANS_LIST_CUR CURSOR FOR TRANS_LIST; */ 


	if(OERROR)
		err_mesg("DECLARE failed on TRANS_LIST_CUR",0,"");


	/* EXEC SQL OPEN TRANS_LIST_CUR USING
						:p_fm_post_mth,
						:p_fm_post_yr,
						:p_to_post_mth,
						:p_to_post_yr,
						:nd_fr_facility,
						:nd_to_facility,
						:p_fm_cust_cd,
						:p_to_cust_cd; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 31;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )425;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_fm_post_mth;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_fm_post_yr;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_to_post_mth;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&p_to_post_yr;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_fr_facility;
 sqlstm.sqhstl[4] = (unsigned int  )5;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_to_facility;
 sqlstm.sqhstl[5] = (unsigned int  )5;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&p_fm_cust_cd;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&p_to_cust_cd;
 sqlstm.sqhstl[7] = (unsigned int  )11;
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
		err_mesg("OPEN failed on cursor TRANS_LIST_CUR",0,""); 
}

do_report()
{
  

int cnt, d_cnt;
char s_amt[20];
lno = 0;
g_hdr_cnt = 0;
cnt = 0;
d_cnt = 0;
foot_ind = 0;

if (p_cat_type.arr[0] != 'C')
{
  
    while(fetch_blng_grp_cur()) 
	{
		if (!g_hdr_cnt)
		{
		    g_hdr_cnt = 1;
			put_hdr();
			foot_ind = 1;
			strcpy(nd_sett_ind.arr,d_sett_ind.arr);
			strcpy(nd_adm_rec_flag.arr,d_adm_rec_flag.arr);
			/*-- Storing the customer info for break */
			strcpy(cd_cust_code.arr,d_cust_code.arr);
			strcpy(cd_cust_name.arr,d_cust_name.arr);

    if (strcmp(nd_option.arr,"B")== 0)
	{

       if (!nd_pre_facility_id.arr)
         {
          strcpy(nd_pre_facility_id.arr,nd_op_facility_id.arr);
          strcpy(nd_pre_cash_counter_code.arr,nd_cash_counter_code.arr);
         }
       if (strcmp(nd_pre_facility_id.arr,nd_op_facility_id.arr)!=0) 
          {
            strcpy(nd_pre_facility_id.arr,nd_op_facility_id.arr);
            fprintf(f1,"\nOperating Facility  :  %2s\n" ,nd_op_facility_id.arr);          
            lno++;
			lno++;
               
          }
	  }

			if (d_sett_ind.arr[0] == 'X')
			{
				if (d_adm_rec_flag.arr[0] == '2')
				{
					fprintf(f1,"CATEGORY : INSURANCE COMPANIES\n\n");
				}
				else if (d_adm_rec_flag.arr[0] == '1')
				{
					fprintf(f1,"CATEGORY : OTHER COMPANIES\n\n");
				}

				lno += 2;
			}
			else if (d_sett_ind.arr[0] == 'R')
			{	
				fprintf(f1,"CATEGORY : CREDIT PATIENTS\n\n");
				lno += 2;
			}

		}
		
		/*-- Check for the customer change, If so print the record ---- */
		/*-- For 1 customer there can be only one record vsk 30/06/1999 */
		if (nd_sett_ind.arr[0] != 'C')
		{
			if (strcmp(cd_cust_code.arr,d_cust_code.arr))
			{
				put_rec();
				c_d_per_1 = 0;
				c_d_per_1_1 = 0;
				c_d_per_1_2 = 0;
				c_d_per_2 = 0;
				c_d_per_21 = 0;
				c_d_per_22 = 0;
				c_d_per_3 = 0;
				c_d_per_31 = 0;
				c_d_per_32 = 0;
				c_d_per_4 = 0;
				c_d_per_41 = 0;
				c_d_per_42 = 0;
				c_d_per_5 = 0;
				c_d_per_51 = 0;
				c_d_per_52 = 0;
				c_d_per_6 = 0;
				c_d_per_61 = 0;
				c_d_per_62 = 0;
				c_d_per_7 = 0;
				c_d_per_71 = 0;
				c_d_per_72 = 0;
				c_d_per_8 = 0;
				c_d_per_81 = 0;
				c_d_per_82 = 0;
				c_d_per_9 = 0;
				c_d_per_91 = 0;
				c_d_per_92 = 0;
				c_d_per_10  = 0;
				c_d_per_101  = 0;
				c_d_per_102  = 0;
				c_d_per_11  = 0;
				c_d_per_111  = 0;
				c_d_per_112  = 0;
				c_d_per_12  = 0;
				c_d_per_121  = 0;
				c_d_per_122  = 0;
				c_d_per_sum = 0;
				c_d_per_sum1 = 0;
				c_d_per_sum2 = 0;
				c_d_per_lst_sum = 0;
				c_d_per_lst_sum1 = 0;
				c_d_per_lst_sum2 = 0;
				strcpy(cd_cust_code.arr,d_cust_code.arr);
				strcpy(cd_cust_name.arr,d_cust_name.arr);
				chk_break(1);
			}
		}
				
		if (strcmp(nd_sett_ind.arr,d_sett_ind.arr))
		{
			prt_tot();
			strcpy(nd_sett_ind.arr,d_sett_ind.arr);
			
			if (d_sett_ind.arr[0] == 'X')
			{
				if (d_adm_rec_flag.arr[0] == '2')
				{
					fprintf(f1,"CATEGORY : INSURANCE COMPANIES\n\n");
				}
				else if (d_adm_rec_flag.arr[0] == '1')
				{
					fprintf(f1,"CATEGORY : OTHER COMPANIES\n\n");
				}

				lno += 2;
			}
			else if (d_sett_ind.arr[0] == 'R')
			{
				fprintf(f1,"CATEGORY : CREDIT PATIENTS\n\n");
				lno += 2;
			}
			
		}
		cnt = 1;
		
		if (d_sett_ind.arr[0] == 'X')	
		{
				if (strcmp(nd_adm_rec_flag.arr,d_adm_rec_flag.arr))
				{
						prt_tot();
						strcpy(nd_adm_rec_flag.arr,d_adm_rec_flag.arr);
						if (d_adm_rec_flag.arr[0] == '2')
						{
							fprintf(f1,"CATEGORY : INSURANCE COMPANIES\n\n");
						}
						else if (d_adm_rec_flag.arr[0] == '1')
						{
							fprintf(f1,"CATEGORY : OTHER COMPANIES\n\n");
						}

						lno += 2;
				}
		}
		
		if (d_sett_ind.arr[0] != 'C')
		{
			fetch_period_values();		
			/* If same customer repeats accumulate the values */
			c_d_per_1 = c_d_per_1 + d_per_1;
			c_d_per_1_1 = c_d_per_1_1 + d_per_1_1;
			c_d_per_1_2 = c_d_per_1_2 + d_per_1_2;

			c_d_per_2 = c_d_per_2 + d_per_2;
			c_d_per_21 = c_d_per_21 + d_per_21;
			c_d_per_22 = c_d_per_22 + d_per_22;

			c_d_per_3 = c_d_per_3 + d_per_3;
			c_d_per_31 = c_d_per_31 + d_per_31;
			c_d_per_32 = c_d_per_32 + d_per_32;

			c_d_per_4 = c_d_per_4 + d_per_4;
			c_d_per_41 = c_d_per_41 + d_per_41;
			c_d_per_42 = c_d_per_42 + d_per_42;

			c_d_per_5 = c_d_per_5 + d_per_5;
			c_d_per_51 = c_d_per_51 + d_per_51;
			c_d_per_52 = c_d_per_52 + d_per_52;

			c_d_per_6 = c_d_per_6 + d_per_6;
			c_d_per_61 = c_d_per_61 + d_per_61;
			c_d_per_62 = c_d_per_62 + d_per_62;

			c_d_per_7 = c_d_per_7 + d_per_7;
			c_d_per_71 = c_d_per_71 + d_per_71;
			c_d_per_72 = c_d_per_72 + d_per_72;

			c_d_per_8 = c_d_per_8 + d_per_8;
			c_d_per_81 = c_d_per_81+ d_per_81;
			c_d_per_82 = c_d_per_82 + d_per_82;

			c_d_per_9 = c_d_per_9 + d_per_9;
			c_d_per_91 = c_d_per_91 + d_per_91;
			c_d_per_92 = c_d_per_92 + d_per_92;

			c_d_per_10 = c_d_per_10 + d_per_10;
			c_d_per_101 = c_d_per_101 + d_per_101;
			c_d_per_102 = c_d_per_102 + d_per_102;

			c_d_per_11 = c_d_per_11 + d_per_11;
			c_d_per_111 = c_d_per_111 + d_per_111;
			c_d_per_112 = c_d_per_112 + d_per_112;

			c_d_per_12 = c_d_per_12 + d_per_12;
			c_d_per_121 = c_d_per_121 + d_per_121;
			c_d_per_122 = c_d_per_122 + d_per_122;

			c_d_per_sum = c_d_per_sum + d_per_sum;
			c_d_per_sum1 = c_d_per_sum1 + d_per_sum1;
			
			c_d_per_lst_sum = c_d_per_lst_sum + d_per_lst_sum;
			c_d_per_lst_sum1 = c_d_per_lst_sum1 + d_per_lst_sum1;

		}
		else
		{
			d_cnt = 1;
			break;
		}
	}
	/*-- Cash case along with credit VSK 30/06/1999 */
	if (d_cnt == 1)
	{
		print_credit_total();
		fetch_period_values();		
		put_rec();
		chk_break(1);
	}

}
else
{
	/*-- Cash Only Case VSK 30/06/1999 */
	foot_ind = 1;
    d_cnt = 1;
	d_sett_ind.arr[0] = 'C';
	d_adm_rec_flag.arr[0] = '0';
	strcpy(nd_sett_ind.arr,d_sett_ind.arr);
	strcpy(nd_adm_rec_flag.arr,d_adm_rec_flag.arr);
	put_hdr();
	fetch_period_values();		
	put_rec();
	chk_break(1);
	cnt = 1;
}

/*-- Category ALL End print VSK 30/06/1999 */

if (p_cat_type.arr[0] == 'A')
{
  if (d_cnt != 1)
  {
		if (cnt == 1)
		{
			put_rec();
			c_d_per_1 = 0;
			c_d_per_1_1 = 0;
			c_d_per_1_2 = 0;

			c_d_per_2 = 0;
			c_d_per_21 = 0;
			c_d_per_22 = 0;

			c_d_per_3 = 0;
			c_d_per_31 = 0;
			c_d_per_32 = 0;

			c_d_per_4 = 0;
			c_d_per_41 = 0;
			c_d_per_42 = 0;

			c_d_per_5 = 0;
			c_d_per_51 = 0;
			c_d_per_52 = 0;

			c_d_per_6 = 0;
			c_d_per_61 = 0;
			c_d_per_62 = 0;

			c_d_per_7 = 0;
			c_d_per_71 = 0;
			c_d_per_72 = 0;

			c_d_per_8 = 0;
			c_d_per_81 = 0;
			c_d_per_82 = 0;

			c_d_per_9 = 0;
			c_d_per_91 = 0;
			c_d_per_92 = 0;

			c_d_per_10 = 0;
			c_d_per_101 = 0;
			c_d_per_102 = 0;

			c_d_per_11 = 0;
			c_d_per_111 = 0;
			c_d_per_112 = 0;

			c_d_per_12 = 0;
			c_d_per_121 = 0;
			c_d_per_122 = 0;

			c_d_per_sum = 0;
			c_d_per_sum1 = 0;
			c_d_per_sum2 = 0;

			c_d_per_lst_sum = 0;
			c_d_per_lst_sum1 = 0;
			c_d_per_lst_sum2 = 0;
			chk_break(1);
			prt_tot();
		}
	    print_credit_total();
		d_sett_ind.arr[0] = 'C';
		d_adm_rec_flag.arr[0] = '0';
		strcpy(nd_sett_ind.arr,d_sett_ind.arr);
		strcpy(nd_adm_rec_flag.arr,d_adm_rec_flag.arr);
		fetch_period_values();		
		put_rec();
		chk_break(1);
  }
}

/*-- For Case  ALL and CASH VSK 30/06/1999 */
if (cnt == 1)
{
	if (p_cat_type.arr[0] != 'A' && p_cat_type.arr[0] != 'C')
	{
			put_rec();
			c_d_per_1 = 0;
			c_d_per_1_1 = 0;
			c_d_per_1_2 = 0;

			c_d_per_2 = 0;
			c_d_per_21 = 0;
			c_d_per_22 = 0;

			c_d_per_3 = 0;
			c_d_per_31 = 0;
			c_d_per_32 = 0;

			c_d_per_4 = 0;
			c_d_per_41 = 0;
			c_d_per_42 = 0;

			c_d_per_5 = 0;
			c_d_per_51 = 0;
			c_d_per_52 = 0;

			c_d_per_6 = 0;
			c_d_per_61 = 0;
			c_d_per_62 = 0;

			c_d_per_7 = 0;
			c_d_per_71 = 0;
			c_d_per_72 = 0;

			c_d_per_8 = 0;
			c_d_per_81 = 0;
			c_d_per_82 = 0;

			c_d_per_9 = 0;
			c_d_per_91 = 0;
			c_d_per_92 = 0;

			c_d_per_10 = 0;
			c_d_per_101 = 0;
			c_d_per_102 = 0;

			c_d_per_11 = 0;
			c_d_per_111 = 0;
			c_d_per_112 = 0;

			c_d_per_12 = 0;
			c_d_per_121 = 0;
			c_d_per_122 = 0;

			c_d_per_sum = 0;
			c_d_per_sum1 = 0;
			c_d_per_sum2 = 0;

			c_d_per_lst_sum = 0;
			c_d_per_lst_sum1 = 0;
			c_d_per_lst_sum2 = 0;
			chk_break(1);
			prt_tot();
		    print_credit_total();
	}
}

/*-- For Case other than ALL and CASH VSK 30/06/1999 */

if (cnt == 1)
{
	if(p_cat_type.arr[0] == 'A' || p_cat_type.arr[0] == 'C')
	{
		prt_tot();
		print_grand_total();
		//print_end_of_rep();
	}
	else
	{
		print_grand_total();
		//print_end_of_rep();
	}
}

if (foot_ind != 0)
	print_end_of_rep();


} 


fetch_blng_grp_cur()
{
	//d_blng_grp_id.arr[0]		=		'\0';
	d_sett_ind.arr[0]			=		'\0';	
	d_adm_rec_flag.arr[0]		=		'\0';
	d_cust_code.arr[0]			=		'\0';	
	d_cust_name.arr[0]			=		'\0';	
	nd_op_facility_id.arr[0]		=       '\0';

	//d_blng_grp_id.len			=		0;
	d_sett_ind.len				=		0;
	d_adm_rec_flag.len			=		0;
	d_cust_code.len				=		0;
	d_cust_name.len				=		0;
	nd_op_facility_id.len			=       0;
	

    /* EXEC SQL FETCH TRANS_LIST_CUR
	     //INTO   :d_blng_grp_id,
		 INTO	:d_cust_code,
				:d_cust_name,
				:d_sett_ind,
				:d_adm_rec_flag,
				:nd_op_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 31;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )472;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_code;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_cust_name;
    sqlstm.sqhstl[1] = (unsigned int  )43;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_sett_ind;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_adm_rec_flag;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_op_facility_id;
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



    if(OERROR)
		err_mesg("FETCH failed on cursor TRANS_LIST_CUR",0,"");

	if(NO_DATA_FOUND)
	{
	return 0;}

    //d_blng_grp_id.arr[d_blng_grp_id.len]		=		'\0';
	d_sett_ind.arr[d_sett_ind.len]				=		'\0';	
	d_adm_rec_flag.arr[d_adm_rec_flag.len]		=		'\0';
	d_cust_code.arr[d_cust_code.len]			=		'\0';	
	d_cust_name.arr[d_cust_name.len]			=		'\0';	

/*--Please do not remove the below sprintf statement VSK 08/02/2000 */	
//	sprintf(string_var,"%s -- %s -- %s",d_blng_grp_id.arr,d_cust_name.arr,d_cust_code.arr);
//	disp_message(ERR_MESG,string_var);
}

decl_cash_cur()
{
	/* EXEC SQL DECLARE cash_cur CURSOR FOR
	SELECT TO_CHAR(A.TRX_DATE,'YYYY/MM'),NVL(SUM(UPD_NET_CHARGE_AMT),0),COUNT(DISTINCT(PATIENT_ID)),
			 SUM(UPD_NET_CHARGE_AMT)/COUNT(DISTINCT(PATIENT_ID)) 
			 FROM BL_PATIENT_CHARGES_FOLIO A,BL_BLNG_PRT_GRP_HDR B, BL_BLNG_GRP C 
			 WHERE	A.TRX_DATE >= to_date('01/'||:p_fm_post_mth||'/'||:p_fm_post_yr||' 00:00:00','DD/MM/YYYY HH24:MI:SS')
			 AND	A.TRX_DATE <= last_day(to_date('01/'||:p_to_post_mth||'/'||:p_to_post_yr||' 23:59:59','DD/MM/YYYY HH24:MI:SS'))
			 AND	A.EPISODE_TYPE = DECODE(:p_epsd_type,'A',EPISODE_TYPE,:p_epsd_type) 
			 AND	A.TRX_FINALIZE_IND = 'Y' 
		     AND    B.INCOME_YN = 'Y'  
			 AND	C.SETTLEMENT_IND = 'C'
			 AND	A.OPERATING_FACILITY_ID BETWEEN nvl(ltrim(rtrim(:nd_fr_facility)),'  ') 
		                                    AND     nvl(ltrim(rtrim(:nd_to_facility)),'~~') 
			 AND    A.PRT_GRP_HDR_CODE = B.PRT_GRP_HDR_CODE 			 
			 AND	A.BLNG_GRP_ID = C.BLNG_GRP_ID
			 GROUP BY TO_CHAR(A.TRX_DATE,'YYYY/MM'); */ 


			 if(OERROR)
				err_mesg("DECLARE failed on cash_cur",0,"");

	/* EXEC SQL OPEN cash_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 31;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0009;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )507;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_fm_post_mth;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_fm_post_yr;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_to_post_mth;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&p_to_post_yr;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&p_epsd_type;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&p_epsd_type;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_fr_facility;
 sqlstm.sqhstl[6] = (unsigned int  )5;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_to_facility;
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
	 disp_message(ERR_MESG,"Open cash_cur cursor failed");
}

decl_non_cash_cur()
{
	/* EXEC SQL DECLARE non_cash_cur CURSOR FOR
	SELECT TO_CHAR(A.TRX_DATE,'YYYY/MM'),NVL(SUM(UPD_NET_CHARGE_AMT),0),COUNT(DISTINCT(PATIENT_ID)),
			 SUM(UPD_NET_CHARGE_AMT)/COUNT(DISTINCT(PATIENT_ID))  
			 FROM BL_PATIENT_CHARGES_FOLIO A,BL_BLNG_PRT_GRP_HDR B 
			 WHERE	A.TRX_DATE >= to_date('01/'||:p_fm_post_mth||'/'||:p_fm_post_yr||' 00:00:00','DD/MM/YYYY HH24:MI:SS')
			 AND	A.TRX_DATE <= last_day(to_date('01/'||:p_to_post_mth||'/'||:p_to_post_yr||' 23:59:59','DD/MM/YYYY HH24:MI:SS'))
		     AND    B.INCOME_YN = 'Y' 
			 AND	A.EPISODE_TYPE = DECODE(:p_epsd_type,'A',EPISODE_TYPE,:p_epsd_type) 
			 AND	A.TRX_FINALIZE_IND = 'Y' 
			 //AND	A.BLNG_GRP_ID = :d_blng_grp_id 
			 AND	A.CUST_CODE = :d_cust_code
             AND	A.OPERATING_FACILITY_ID BETWEEN nvl(ltrim(rtrim(:nd_fr_facility)),'  ') 
		                          AND     nvl(ltrim(rtrim(:nd_to_facility)),'~~') 
			 AND    A.PRT_GRP_HDR_CODE =  B.PRT_GRP_HDR_CODE
			 GROUP BY TO_CHAR(A.TRX_DATE,'YYYY/MM'); */ 


			 if(OERROR)
				err_mesg("DECLARE failed on non_cash_cur",0,"");


	/* EXEC SQL OPEN non_cash_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 31;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0010;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )554;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_fm_post_mth;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_fm_post_yr;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_to_post_mth;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&p_to_post_yr;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&p_epsd_type;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&p_epsd_type;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_cust_code;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_fr_facility;
 sqlstm.sqhstl[7] = (unsigned int  )5;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_to_facility;
 sqlstm.sqhstl[8] = (unsigned int  )5;
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
	 disp_message(ERR_MESG,"Open non_cash_cur cursor failed");

}

fetch_cash_cur()
{
	year_mon.arr[0] = '\0';
	year_mon.len = 0;

	/* EXEC SQL FETCH cash_cur INTO
		:year_mon,
		:d_sum,
		:d_tot_pat,
		:d_average; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 31;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )605;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&year_mon;
 sqlstm.sqhstl[0] = (unsigned int  )10;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_sum;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_tot_pat;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_average;
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


	
	year_mon.arr[year_mon.len] = '\0';

/*	sprintf(string_var,"  %15.2f",d_sum);
	disp_message(ERR_MESG,string_var);
*/

	if(OERROR)
	{ 
		disp_message(ERR_MESG,"FETCH FAILED IN CASH_CUR");
	}

	if(NODATAFOUND)
		{
			return 0;
		}

	return 1;
}

fetch_non_cash_cur()
{
	year_mon.arr[0] = '\0';
	year_mon.len = 0;

	/* EXEC SQL FETCH non_cash_cur INTO
		:year_mon,
		:d_sum,
		:d_tot_pat,
		:d_average; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 31;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )636;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&year_mon;
 sqlstm.sqhstl[0] = (unsigned int  )10;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_sum;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_tot_pat;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_average;
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


	
	year_mon.arr[year_mon.len] = '\0';

	if(OERROR)
	{ 
		disp_message(ERR_MESG,"FETCH FAILED IN NON_CASH_CUR");
	}

	if(NODATAFOUND)
		{
			return 0;
		}

return 1;
}

fetch_period_values()
{
	nom = 1;
	rec_cnt = 1;
	
	d_sum = 0;
	d_tot_pat = 0;
	d_average = 0;
	
	d_per_1 = 0;
	d_per_1_1 = 0;
	d_per_1_2 = 0;

	d_per_2 = 0;
	d_per_21 = 0;
	d_per_22 = 0;

	d_per_3 = 0;
	d_per_31 = 0;
	d_per_32 = 0;

	d_per_4 = 0;
	d_per_41 = 0;
	d_per_42 = 0;

	d_per_5 = 0;
	d_per_51 = 0;
	d_per_52 = 0;

	d_per_6 = 0;
	d_per_61 = 0;
	d_per_62 = 0;

	d_per_7 = 0;
	d_per_71 = 0;
	d_per_72 = 0;

	d_per_8 = 0;
	d_per_81 = 0;
	d_per_82 = 0;

	d_per_9 = 0;
	d_per_91 = 0;
	d_per_92 = 0;

	d_per_10 = 0;
	d_per_101 = 0;
	d_per_102 = 0;

	d_per_11 = 0;
	d_per_111 = 0;
	d_per_112 = 0;

	d_per_12 = 0;
	d_per_121 = 0;
	d_per_122 = 0;

	d_per_sum = 0;
	d_per_sum1 = 0;
	d_per_sum2 = 0;

	d_per_lst_sum = 0;
	d_per_lst_sum1 = 0;
	d_per_lst_sum2 = 0;

	if (d_sett_ind.arr[0] == 'C')
	{
		decl_cash_cur();
		while(fetch_cash_cur())
		{
			assign_mth_rec();
			//rec_cnt++;
		}
	}
	else
	{	
		decl_non_cash_cur();
		while(fetch_non_cash_cur())
		{
			assign_mth_rec();
			//rec_cnt++;
		}
	}


/*--Every record, All period total	*/

	d_per_tot_sum = d_per_tot_sum + d_per_sum;
	d_per_tot_sum1 = d_per_tot_sum1 + d_per_sum1;


/*--Every record, All period total (previous year) */

	if ((d_sett_ind.arr[0] == 'C') && (p_inc_no_pat.arr[0] == 'Y'))
	{
	   if (no_of_time_exec == 0) 
		{

		d_pri_lst_sum = 0;
		d_pri_lst_sum1 = 0;
		
		strcpy(p_prin_lst_fm_dt.arr,p_lst_fm_dt.arr);
		p_prin_lst_fm_dt.len = strlen(p_prin_lst_fm_dt.arr);
		
		/* Commented by Saravanan on 03/11/2002 and rewritten as below */
		/*for(i = 1; i <= p_no_of_mth; i++)
		{

			EXEC SQL SELECT TO_CHAR(ADD_MONTHS(TO_DATE(:p_prin_lst_fm_dt,'DD/MM/YYYY'),1) - 1, 'DD/MM/YYYY')
					   INTO :p_prin_lst_to_dt
					   FROM DUAL;

			p_prin_lst_to_dt.arr[strlen(p_prin_lst_to_dt.arr)]='\0' ;

		   
			EXEC SQL SELECT SUM(NVL(UPD_NET_CHARGE_AMT,0)),COUNT(DISTINCT(PATIENT_ID))
					 INTO	:d_per_lst_sum,:d_per_lst_sum1
					 FROM	BL_PATIENT_CHARGES_FOLIO A,BL_BLNG_PRT_GRP_HDR B, BL_BLNG_GRP C 
					 WHERE	TRX_DATE BETWEEN to_date(:p_prin_lst_fm_dt||' 00:00','DD/MM/YYYY HH24:MI')
					 AND	TO_DATE(:p_prin_lst_to_dt||' 23:59','DD/MM/YYYY HH24:MI') 
					 AND    B.INCOME_YN = 'Y' 
					 AND	A.EPISODE_TYPE = DECODE(:p_epsd_type,'A',A.EPISODE_TYPE,:p_epsd_type) 
					 AND	A.TRX_FINALIZE_IND = 'Y' 
					 AND	C.SETTLEMENT_IND = 'C'
                     AND	A.OPERATING_FACILITY_ID BETWEEN nvl(ltrim(rtrim(:nd_fr_facility)),'  ') 
		                          AND     nvl(ltrim(rtrim(:nd_to_facility)),'~~') 
					 AND	A.BLNG_GRP_ID = C.BLNG_GRP_ID
					 AND    A.PRT_GRP_HDR_CODE =  B.PRT_GRP_HDR_CODE;
					
					 d_pri_lst_sum = d_per_lst_sum + d_pri_lst_sum;
					 d_pri_lst_sum1 = d_per_lst_sum1 + d_pri_lst_sum1;
	
			EXEC SQL SELECT TO_CHAR(TO_DATE(:p_prin_lst_to_dt,'DD/MM/YYYY') + 1,'DD/MM/YYYY')
						INTO :p_prin_lst_fm_dt
						FROM DUAL;

			p_prin_lst_fm_dt.arr[strlen(p_prin_lst_fm_dt.arr)]	=	'\0';
		} */

		/* EXEC SQL SELECT SUM(F1), SUM(F2) 
					INTO	:d_per_lst_sum,:d_per_lst_sum1
					FROM
					 (SELECT SUM(NVL(UPD_NET_CHARGE_AMT,0)) F1,COUNT(DISTINCT(PATIENT_ID)) F2
					 FROM	BL_PATIENT_CHARGES_FOLIO A,BL_BLNG_PRT_GRP_HDR B, BL_BLNG_GRP C 
					 WHERE	A.TRX_DATE >= to_date(:p_lst_fm_dt||' 00:00','DD/MM/YYYY HH24:MI')
					 AND	A.TRX_DATE <= TO_DATE(:p_lst_to_dt||' 23:59','DD/MM/YYYY HH24:MI') 
					 AND    B.INCOME_YN = 'Y' 
					 AND	A.EPISODE_TYPE = DECODE(:p_epsd_type,'A',A.EPISODE_TYPE,:p_epsd_type) 
					 AND	A.TRX_FINALIZE_IND = 'Y' 
					 AND	C.SETTLEMENT_IND = 'C'
					 AND	A.BLNG_GRP_ID = C.BLNG_GRP_ID
					 AND	A.OPERATING_FACILITY_ID BETWEEN nvl(ltrim(rtrim(:nd_fr_facility)),'  ') 
		                          AND     nvl(ltrim(rtrim(:nd_to_facility)),'~~') 
					 AND    A.PRT_GRP_HDR_CODE =  B.PRT_GRP_HDR_CODE
					 GROUP BY TO_CHAR(A.TRX_DATE,'YYYYMM')); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 31;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(F1) ,sum(F2) into :b0,:b1  from (select sum(NVL(\
UPD_NET_CHARGE_AMT,0)) F1 ,count(distinct PATIENT_ID) F2  from BL_PATIENT_CHAR\
GES_FOLIO A ,BL_BLNG_PRT_GRP_HDR B ,BL_BLNG_GRP C where ((((((((A.TRX_DATE>=to\
_date((:b2||' 00:00'),'DD/MM/YYYY HH24:MI') and A.TRX_DATE<=TO_DATE((:b3||' 23\
:59'),'DD/MM/YYYY HH24:MI')) and B.INCOME_YN='Y') and A.EPISODE_TYPE=DECODE(:b\
4,'A',A.EPISODE_TYPE,:b4)) and A.TRX_FINALIZE_IND='Y') and C.SETTLEMENT_IND='C\
') and A.BLNG_GRP_ID=C.BLNG_GRP_ID) and A.OPERATING_FACILITY_ID between nvl(lt\
rim(rtrim(:b6)),'  ') and nvl(ltrim(rtrim(:b7)),'~~')) and A.PRT_GRP_HDR_CODE=\
B.PRT_GRP_HDR_CODE) group by TO_CHAR(A.TRX_DATE,'YYYYMM')) ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )667;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_per_lst_sum;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_per_lst_sum1;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&p_lst_fm_dt;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&p_lst_to_dt;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&p_epsd_type;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&p_epsd_type;
  sqlstm.sqhstl[5] = (unsigned int  )4;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_fr_facility;
  sqlstm.sqhstl[6] = (unsigned int  )5;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_to_facility;
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


	  
		}
		no_of_time_exec++;
	}
	if ((d_sett_ind.arr[0] != 'C') && (p_inc_no_pat.arr[0] == 'Y'))
	{
		d_pri_lst_sum = 0;
		d_pri_lst_sum1 = 0;

		strcpy(p_prin_lst_fm_dt.arr,p_lst_fm_dt.arr);
		p_prin_lst_fm_dt.len = strlen(p_prin_lst_fm_dt.arr);


		/*for(i = 1; i <= p_no_of_mth; i++)
		{

			EXEC SQL SELECT TO_CHAR(ADD_MONTHS(TO_DATE(:p_prin_lst_fm_dt,'DD/MM/YYYY'),1) - 1, 'DD/MM/YYYY')
					   INTO :p_prin_lst_to_dt
					   FROM DUAL;

			p_prin_lst_to_dt.arr[p_prin_lst_to_dt.len]	=	'\0' ;

			EXEC SQL SELECT SUM(NVL(UPD_NET_CHARGE_AMT,0)), COUNT(DISTINCT(PATIENT_ID))
				 INTO	:d_per_lst_sum,:d_per_lst_sum1
				 FROM	BL_PATIENT_CHARGES_FOLIO A,BL_BLNG_PRT_GRP_HDR B 
				 WHERE	TRX_DATE BETWEEN to_date(:p_prin_lst_fm_dt||' 00:00','DD/MM/YYYY HH24:MI')
				 AND	TO_DATE(:p_prin_lst_to_dt||' 23:59','DD/MM/YYYY HH24:MI') 
			     AND    B.INCOME_YN = 'Y' 
				 AND 	A.EPISODE_TYPE = DECODE(:p_epsd_type,'A',EPISODE_TYPE,:p_epsd_type) 
				 AND	A.TRX_FINALIZE_IND = 'Y' 
				 //AND	A.BLNG_GRP_ID = :d_blng_grp_id 
                 AND	A.OPERATING_FACILITY_ID BETWEEN nvl(ltrim(rtrim(:nd_fr_facility)),'  ') 
		                          AND     nvl(ltrim(rtrim(:nd_to_facility)),'~~') 
				 AND	A.CUST_CODE = :d_cust_code 
				 AND    A.PRT_GRP_HDR_CODE =  B.PRT_GRP_HDR_CODE;

					 d_pri_lst_sum = d_per_lst_sum + d_pri_lst_sum;
					 d_pri_lst_sum1 = d_per_lst_sum1 + d_pri_lst_sum1;

			EXEC SQL SELECT TO_DATE(:p_prin_lst_to_dt,'DD/MM/YYYY') + 1
						INTO :p_prin_lst_fm_dt
						FROM DUAL;

			p_prin_lst_fm_dt.arr[p_prin_lst_fm_dt.len]	=	'\0';

		}
		d_per_lst_sum = d_pri_lst_sum;
		d_per_lst_sum1 = d_pri_lst_sum1;*/

		/* EXEC SQL SELECT SUM(F1), SUM(F2) 
				 INTO :d_per_lst_sum, :d_per_lst_sum1
				 FROM
				 (SELECT SUM(NVL(UPD_NET_CHARGE_AMT,0)) F1, COUNT(DISTINCT(PATIENT_ID)) F2
				 FROM	BL_PATIENT_CHARGES_FOLIO A,BL_BLNG_PRT_GRP_HDR B 
				 WHERE	A.TRX_DATE >= to_date(:p_lst_fm_dt||' 00:00','DD/MM/YYYY HH24:MI')
				 AND	A.TRX_DATE <= TO_DATE(:p_lst_to_dt||' 23:59','DD/MM/YYYY HH24:MI') 
			     AND    B.INCOME_YN = 'Y' 
				 AND 	A.EPISODE_TYPE = DECODE(:p_epsd_type,'A',EPISODE_TYPE,:p_epsd_type) 
				 AND	A.TRX_FINALIZE_IND = 'Y' 
				 //AND	A.BLNG_GRP_ID = :d_blng_grp_id 
				 AND	A.CUST_CODE = :d_cust_code 
				 AND	A.OPERATING_FACILITY_ID BETWEEN nvl(ltrim(rtrim(:nd_fr_facility)),'  ') 
		                          AND     nvl(ltrim(rtrim(:nd_to_facility)),'~~') 
				 AND    A.PRT_GRP_HDR_CODE =  B.PRT_GRP_HDR_CODE
				 GROUP BY TO_CHAR(A.TRX_DATE,'YYYYMM')); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 31;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(F1) ,sum(F2) into :b0,:b1  from (select sum(NVL(\
UPD_NET_CHARGE_AMT,0)) F1 ,count(distinct PATIENT_ID) F2  from BL_PATIENT_CHAR\
GES_FOLIO A ,BL_BLNG_PRT_GRP_HDR B where (((((((A.TRX_DATE>=to_date((:b2||' 00\
:00'),'DD/MM/YYYY HH24:MI') and A.TRX_DATE<=TO_DATE((:b3||' 23:59'),'DD/MM/YYY\
Y HH24:MI')) and B.INCOME_YN='Y') and A.EPISODE_TYPE=DECODE(:b4,'A',EPISODE_TY\
PE,:b4)) and A.TRX_FINALIZE_IND='Y') and A.CUST_CODE=:b6) and A.OPERATING_FACI\
LITY_ID between nvl(ltrim(rtrim(:b7)),'  ') and nvl(ltrim(rtrim(:b8)),'~~')) a\
nd A.PRT_GRP_HDR_CODE=B.PRT_GRP_HDR_CODE) group by TO_CHAR(A.TRX_DATE,'YYYYMM'\
)) ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )714;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_per_lst_sum;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_per_lst_sum1;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&p_lst_fm_dt;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&p_lst_to_dt;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&p_epsd_type;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&p_epsd_type;
  sqlstm.sqhstl[5] = (unsigned int  )4;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_cust_code;
  sqlstm.sqhstl[6] = (unsigned int  )11;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_fr_facility;
  sqlstm.sqhstl[7] = (unsigned int  )5;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_to_facility;
  sqlstm.sqhstl[8] = (unsigned int  )5;
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


	}

	/*Calculating the sum of amount and Average for the person
	during the same period last year*/
	
	if ((d_sett_ind.arr[0] == 'C') && (p_inc_no_pat.arr[0] != 'Y'))
	{	
		if (no_of_time_exec == 0) 
		{
		
			/* EXEC SQL SELECT SUM(NVL(UPD_NET_CHARGE_AMT,0))							
					 INTO	:d_per_lst_sum
					 FROM	BL_PATIENT_CHARGES_FOLIO A,BL_BLNG_PRT_GRP_HDR B, BL_BLNG_GRP C
					 WHERE	TRX_DATE BETWEEN to_date(:p_lst_fm_dt||' 00:00','DD/MM/YYYY HH24:MI')
					 AND	TO_DATE(:p_lst_to_dt||' 23:59','DD/MM/YYYY HH24:MI') 
					 AND    B.INCOME_YN = 'Y' 
					 AND	A.EPISODE_TYPE = DECODE(:p_epsd_type,'A',EPISODE_TYPE,:p_epsd_type) 
					 AND	A.TRX_FINALIZE_IND = 'Y'
					 AND	C.SETTLEMENT_IND = 'C'
					 AND    A.PRT_GRP_HDR_CODE =  B.PRT_GRP_HDR_CODE
                     AND	A.OPERATING_FACILITY_ID BETWEEN nvl(ltrim(rtrim(:nd_fr_facility)),'  ') 
		                          AND     nvl(ltrim(rtrim(:nd_to_facility)),'~~') 
					 AND	A.BLNG_GRP_ID = C.BLNG_GRP_ID; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 31;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select sum(NVL(UPD_NET_CHARGE_AMT,0)) into :b0  from BL_PA\
TIENT_CHARGES_FOLIO A ,BL_BLNG_PRT_GRP_HDR B ,BL_BLNG_GRP C where (((((((TRX_D\
ATE between to_date((:b1||' 00:00'),'DD/MM/YYYY HH24:MI') and TO_DATE((:b2||' \
23:59'),'DD/MM/YYYY HH24:MI') and B.INCOME_YN='Y') and A.EPISODE_TYPE=DECODE(:\
b3,'A',EPISODE_TYPE,:b3)) and A.TRX_FINALIZE_IND='Y') and C.SETTLEMENT_IND='C'\
) and A.PRT_GRP_HDR_CODE=B.PRT_GRP_HDR_CODE) and A.OPERATING_FACILITY_ID betwe\
en nvl(ltrim(rtrim(:b5)),'  ') and nvl(ltrim(rtrim(:b6)),'~~')) and A.BLNG_GRP\
_ID=C.BLNG_GRP_ID)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )765;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_per_lst_sum;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&p_lst_fm_dt;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_lst_to_dt;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&p_epsd_type;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&p_epsd_type;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_fr_facility;
   sqlstm.sqhstl[5] = (unsigned int  )5;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_to_facility;
   sqlstm.sqhstl[6] = (unsigned int  )5;
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


			
			/* If No of patient not included, d_per_lst_sum1 is not required, so it is assigned by value 1 */
			d_per_lst_sum1 = 1;
		}
		no_of_time_exec++;
	}
	if ((d_sett_ind.arr[0] != 'C') && (p_inc_no_pat.arr[0] != 'Y'))
	{
			/* EXEC SQL SELECT SUM(NVL(UPD_NET_CHARGE_AMT,0))   
				 INTO	:d_per_lst_sum
				 FROM	BL_PATIENT_CHARGES_FOLIO A,BL_BLNG_PRT_GRP_HDR B 
				 WHERE	TRX_DATE BETWEEN to_date(:p_lst_fm_dt||' 00:00','DD/MM/YYYY HH24:MI')
				 AND	TO_DATE(:p_lst_to_dt||' 23:59','DD/MM/YYYY HH24:MI') 
			     AND    B.INCOME_YN = 'Y' 
				 AND	A.EPISODE_TYPE = DECODE(:p_epsd_type,'A',EPISODE_TYPE,:p_epsd_type) 
				 AND	A.TRX_FINALIZE_IND = 'Y' 
				 //AND	A.BLNG_GRP_ID = :d_blng_grp_id  
				 AND	A.CUST_CODE = :d_cust_code
                 AND	A.OPERATING_FACILITY_ID BETWEEN nvl(ltrim(rtrim(:nd_fr_facility)),'  ') 
		                          AND     nvl(ltrim(rtrim(:nd_to_facility)),'~~') 
				 AND    A.PRT_GRP_HDR_CODE =  B.PRT_GRP_HDR_CODE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 31;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select sum(NVL(UPD_NET_CHARGE_AMT,0)) into :b0  from BL_PA\
TIENT_CHARGES_FOLIO A ,BL_BLNG_PRT_GRP_HDR B where ((((((TRX_DATE between to_d\
ate((:b1||' 00:00'),'DD/MM/YYYY HH24:MI') and TO_DATE((:b2||' 23:59'),'DD/MM/Y\
YYY HH24:MI') and B.INCOME_YN='Y') and A.EPISODE_TYPE=DECODE(:b3,'A',EPISODE_T\
YPE,:b3)) and A.TRX_FINALIZE_IND='Y') and A.CUST_CODE=:b5) and A.OPERATING_FAC\
ILITY_ID between nvl(ltrim(rtrim(:b6)),'  ') and nvl(ltrim(rtrim(:b7)),'~~')) \
and A.PRT_GRP_HDR_CODE=B.PRT_GRP_HDR_CODE)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )808;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_per_lst_sum;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&p_lst_fm_dt;
   sqlstm.sqhstl[1] = (unsigned int  )13;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_lst_to_dt;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&p_epsd_type;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&p_epsd_type;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_cust_code;
   sqlstm.sqhstl[5] = (unsigned int  )11;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fr_facility;
   sqlstm.sqhstl[6] = (unsigned int  )5;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_facility;
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



			d_per_lst_sum1 = 1;
	}

	d_per_tot_lst_sum = d_per_tot_lst_sum + d_per_lst_sum;
	d_per_tot_lst_sum1 = d_per_tot_lst_sum1 + d_per_lst_sum1;
	//strcpy(cd_blng_grp_id.arr,d_blng_grp_id.arr);
}

assign_mth_rec()
{
	if (strcmp(p_per_1.arr,year_mon.arr) == 0)
	{
	if (p_fm_dt_1.arr[0] != '\0')
	{
		d_per_1 = d_sum;
		d_per_1_1 = d_tot_pat;
		d_per_1_2 = d_average;
	}
	else
	{
		d_per_1 = 0.0;
		d_per_1_1 = 0.0;
		d_per_1_2 = 0.0;
	}
	d_per_tot_1 += d_per_1;
	d_per_sum    = d_per_1;

	d_per_tot_1_1 += d_per_1_1;
	d_per_sum1    = d_per_1_1;

	d_per_tot_1_2 += d_per_1_2;
	d_per_sum2    = d_per_1_2;
	}

	if (strcmp(p_per_2.arr,year_mon.arr) == 0)
	{
	if (p_fm_dt_2.arr[0] != '\0')
	{
		d_per_2 = d_sum;
		d_per_21 = d_tot_pat;
		d_per_22 = d_average;
	}
	else
	{
		d_per_2 = 0.0;
		d_per_21 = 0.0;
		d_per_22 = 0.0;
	}
	d_per_tot_2 += d_per_2;
	d_per_sum   += d_per_2;
	
	d_per_tot_21 += d_per_21;
	d_per_sum1   += d_per_21;

	d_per_tot_22 += d_per_22;
	d_per_sum2   += d_per_22;
	}
	
	if (strcmp(p_per_3.arr,year_mon.arr) == 0)
	{
	if (p_fm_dt_3.arr[0] != '\0')
	{
		d_per_3 = d_sum;
		d_per_31 = d_tot_pat;
		d_per_32 = d_average;
	}
	else
	{
		d_per_3 = 0.0;
		d_per_31 = 0.0;
		d_per_32 = 0.0;
	}

	d_per_tot_3 += d_per_3;
	d_per_sum   += d_per_3;

	d_per_tot_31 += d_per_31;
	d_per_sum1   += d_per_31;

	d_per_tot_32 += d_per_32;
	d_per_sum2   += d_per_32;
	}

	if (strcmp(p_per_4.arr,year_mon.arr) == 0)
	{
	if (p_fm_dt_4.arr[0] != '\0')
	{
		d_per_4 = d_sum;
		d_per_41 = d_tot_pat;
		d_per_42 = d_average;
	}
	else
	{
		d_per_4 = 0.0;
		d_per_41 = 0.0;
		d_per_42 = 0.0;
		
	}
	d_per_tot_4 += d_per_4;
	d_per_sum   += d_per_4;

	d_per_tot_41 += d_per_41;
	d_per_sum1   += d_per_41;

	d_per_tot_42 += d_per_42;
	d_per_sum2   += d_per_42;
	}
	
	if (strcmp(p_per_5.arr,year_mon.arr) == 0)
	{
	if (p_fm_dt_5.arr[0] != '\0')
	{
		d_per_5 = d_sum;
		d_per_51 = d_tot_pat;
		d_per_52 = d_average;
	}
	else
	{
		d_per_5 = 0.0;
		d_per_51 = 0.0;
		d_per_52 = 0.0;

	}
	d_per_tot_5 += d_per_5;
	d_per_sum   += d_per_5;

	d_per_tot_51 += d_per_51;
	d_per_sum1   += d_per_51;

	d_per_tot_52 += d_per_52;
	d_per_sum2   += d_per_52;
	}

	if (strcmp(p_per_6.arr,year_mon.arr) == 0)
	{
	if (p_fm_dt_6.arr[0] != '\0')
	{
		d_per_6 = d_sum;
		d_per_61 = d_tot_pat;
		d_per_62 = d_average;
	}
	else
	{
		d_per_6 = 0.0;
		d_per_61 = 0.0;
		d_per_62 = 0.0;

	}
	d_per_tot_6 += d_per_6;
	d_per_sum   += d_per_6;

	d_per_tot_61 += d_per_61;
	d_per_sum1   += d_per_61;

	d_per_tot_62 += d_per_62;
	d_per_sum2   += d_per_62;
	}

	if (strcmp(p_per_7.arr,year_mon.arr) == 0)
	{
	if (p_fm_dt_7.arr[0] != '\0')
	{
		d_per_7 = d_sum;
		d_per_71 = d_tot_pat;
		d_per_72 = d_average;
	}
	else
	{
		d_per_7 = 0.0;
		d_per_71 = 0.0;
		d_per_72 = 0.0;
	}
	d_per_tot_7 += d_per_7;
	d_per_sum   += d_per_7;
	
	d_per_tot_71 += d_per_71;
	d_per_sum1   += d_per_71;

	d_per_tot_72 += d_per_72;
	d_per_sum2   += d_per_72;
	}

	if (strcmp(p_per_8.arr,year_mon.arr) == 0)
	{
	if (p_fm_dt_8.arr[0] != '\0')
	{
		d_per_8 = d_sum;
		d_per_81 = d_tot_pat;
		d_per_82 = d_average;
	}
	else
	{
		d_per_8 = 0.0;
		d_per_81 = 0.0;
		d_per_82 = 0.0;
	}
	d_per_tot_8 += d_per_8;
	d_per_sum   += d_per_8;

	d_per_tot_81 += d_per_81;
	d_per_sum1   += d_per_81;

	d_per_tot_82 += d_per_82;
	d_per_sum2   += d_per_82;
	}

	if (strcmp(p_per_9.arr,year_mon.arr) == 0)
	{
	if (p_fm_dt_9.arr[0] != '\0')
	{
		d_per_9 = d_sum;
		d_per_91 = d_tot_pat;
		d_per_92 = d_average;
	}
	else
	{
		d_per_9 = 0.0;
		d_per_91 = 0.0;
		d_per_92 = 0.0;
	}

	d_per_tot_9 += d_per_9;
	d_per_sum   += d_per_9;

	d_per_tot_91 += d_per_91;
	d_per_sum1   += d_per_91;

	d_per_tot_92 += d_per_92;
	d_per_sum2   += d_per_92;
	}

	if (strcmp(p_per_10.arr,year_mon.arr) == 0)
	{
	if (p_fm_dt_10.arr[0] != '\0')
	{
		d_per_10 = d_sum;
		d_per_101 = d_tot_pat;
		d_per_102 = d_average;
	}
	else
	{
		d_per_10  = 0.0;
		d_per_101 = 0.0;
		d_per_102 = 0.0;
	}
	d_per_tot_10 += d_per_10;
	d_per_sum   += d_per_10;
	
	d_per_tot_101 += d_per_101;
	d_per_sum1   += d_per_101;

	d_per_tot_102 += d_per_102;
	d_per_sum2   += d_per_102;
	}

	if (strcmp(p_per_11.arr,year_mon.arr) == 0)
	{	
	if (p_fm_dt_11.arr[0] != '\0')
	{
		d_per_11 = d_sum;
		d_per_111 = d_tot_pat;
		d_per_112 = d_average;
	}
	else
	{
		d_per_11 = 0.0;
		d_per_111 = 0.0;
		d_per_112 = 0.0;
	}
	d_per_tot_11 += d_per_11;
	d_per_sum   += d_per_11;

	d_per_tot_111 += d_per_111;
	d_per_sum1   += d_per_111;

	d_per_tot_112 += d_per_112;
	d_per_sum2   += d_per_112;
	}

	if (strcmp(p_per_12.arr,year_mon.arr) == 0)
	{
	if (p_fm_dt_12.arr[0] != '\0')
	{
		d_per_12 = d_sum;
		d_per_121 = d_tot_pat;
		d_per_122 = d_average;
	}
	else
	{
		d_per_12 = 0.0;
		d_per_121 = 0.0;
		d_per_122 = 0.0;
	}
	
	d_per_tot_12 += d_per_12;
	d_per_sum   += d_per_12;
	
	d_per_tot_121 += d_per_121;
	d_per_sum1   += d_per_121;

	d_per_tot_122 += d_per_122;
	d_per_sum2   += d_per_122;
	}
}

put_hdr()
{

	int nom;
	nom = 1;

//  commented this statements because the same command already
//  available with chk_break() function which calls put_hdr vsk 5/6/99
//	if (g_hdr_cnt)
//		fprintf(f1,"%c",0x12); /**** Set Printer to Normal Mode ****/

    fprintf(f1,"MDL : BL %30s%34s%35s            %s\n"," ",comp_name.arr," ",rep_date.arr);
	fprintf(f1,"OPR : %s                                       REVENUE ANALYSIS REPORT \n",oper_id.arr);
	fprintf(f1,"REP : BLRREVN1                         (Period  From %2s / %4s   To  %2s / %4s )                                         PAGE : %4d\n",p_fm_post_mth.arr, p_fm_post_yr.arr,p_to_post_mth.arr, p_to_post_yr.arr,page_no);
    fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------\n");
	
	/* added by IRFAN to cater for comp printing */

		if (print_rep_yn.arr[0] == 'Y')
			fprintf(f1,"%c",0x0F); /*** set printer to compressed mode ***/

/*-- Heading Line 1 */

	fprintf(f1,"Customer Name                       Billing Customer             ");
	
	if (nom <= p_no_of_mth)
	{
		{fprintf(f1,"%s",p_per_1.arr);
		if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"                                     ");
		}
	}

	nom++;
	
	if (nom <= p_no_of_mth)
	{	
		{fprintf(f1,"          %s",p_per_2.arr);
		if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"                                  ");
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		{fprintf(f1,"          %s",p_per_3.arr);
		if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"                                  ");
		}
	}
		
	nom++;

	if (nom <= p_no_of_mth)
	{
		{fprintf(f1,"          %s",p_per_4.arr);
		if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"                                  ");
		}
	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		{fprintf(f1,"          %s",p_per_5.arr);
		if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"                                  ");
		}
	}
	nom++;

	if (nom <= p_no_of_mth)
	{
		{fprintf(f1,"          %s",p_per_6.arr);
		if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"                                  ");
		}
	}
	nom++;

	if (nom <= p_no_of_mth)
	{
		{fprintf(f1,"          %s",p_per_7.arr);
		if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"                                  ");
		}
	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		{fprintf(f1,"          %s",p_per_8.arr);
		if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"                                  ");
		}
	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		{fprintf(f1,"          %s",p_per_9.arr);
		if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"                                  ");
		}
	}
	
	nom++;
	
	if (nom <= p_no_of_mth)
	{
		{fprintf(f1,"          %s",p_per_10.arr);
		if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"                                  ");
		}
	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		{fprintf(f1,"          %s",p_per_11.arr);
		if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"			                      ");
		}
	}
	
	nom++;

	if (nom <= p_no_of_mth)
	{
		{fprintf(f1,"          %s",p_per_12.arr);
		if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"                                  ");
		}
	 }
	nom++;


	if (p_inc_no_pat.arr[0] != 'Y')
	   fprintf(f1,"           Period         Same Period\n"); 
			
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	fprintf(f1,"           Period	                                    Same Period           No of Patient     Avg Per Patient\n");
	}

//	fprintf(f1,"\n");
	
/*-- Heading Line 2 */
	nom = 1;

    fprintf(f1,"                                    Group   Code                 ");
		
	if (nom <= p_no_of_mth)
	{
	  {if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"    Amt          No of Patient    Ave Per Patient");
		else
		fprintf(f1,"  %s","     ");
		}
	}
		
	nom++;
	
	if (nom <= p_no_of_mth)
	{
		{if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"         Amt        No of Patient  Ave Per Patient");
		else
		fprintf(f1,"          %s","       ");
		}
	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		{if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"          Amt        No of Patient  Ave Per Patient      ");
		else
		fprintf(f1,"          %s","       ");
		}
		
	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		{if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"    Amt        No of Patient  Ave Per Patient");
		else
		fprintf(f1,"          %s","       "); 
		}
	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		{if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"          Amt        No of Patient  Ave Per Patient");
		else
		fprintf(f1,"          %s","       "); 
		}
	}
		


	nom++;

	if (nom <= p_no_of_mth)
	{
		{if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"          Amt        No of Patient  Ave Per Patient");
		else
		 fprintf(f1,"          %s","       "); 
		}
	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		{if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"          Amt        No of Patient  Ave Per Patient");
		else
		fprintf(f1,"          %s","       "); 
		}
	}
		 

	nom++;

	if (nom <= p_no_of_mth)
	{
		{if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"          Amt        No of Patient  Ave Per Patient");
		else
		fprintf(f1,"          %s","       "); 
		}
	}
	

	nom++;

	if (nom <= p_no_of_mth)
	 {
		{if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"          Amt        No of Patient  Ave Per Patient");
		else
		fprintf(f1,"          %s","       "); 
		}
	 }
		
		 
	nom++;

	if (nom <= p_no_of_mth)
	 {
	   {if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"          Amt        No of Patient  Ave Per Patient");
		else
		fprintf(f1,"          %s","       "); 		
		}
	 }	

	nom++;

	if (nom <= p_no_of_mth)
	 {
	   {if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"          Amt        No of Patient   Ave Per Patient");
		else
		fprintf(f1,"          %s","       "); 
		}
	  }
	
	nom++;

	if (nom <= p_no_of_mth)
	 {
		{if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"      Amt        No of Patient    Ave Per Patient");
		else
		fprintf(f1,"          %s","       "); 
		}
	  }
	  	
	nom++;

	if (p_inc_no_pat.arr[0] != 'Y')
	 fprintf(f1,"            Total           Last Year"); 
	
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	fprintf(f1,"        Total     No of Patient     Ave Per Patient        Last Year");
	}

	fprintf(f1,"\n");
	nom = 0;
	
/*-- Heading Line over */	
	/* added by IRFAN to cater for comp printing */

		if (print_rep_yn.arr[0] == 'Y')
			fprintf(f1,"%c",0x12); /**** Set Printer to Normal Mode ****/

	fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------\n");
	fprintf(f1,"\n");
    lno=10;
	/* added by IRFAN to cater for comp printing */

		if (print_rep_yn.arr[0] == 'Y')
			fprintf(f1,"%c",0x0F); /*** set printer to compressed mode ***/

			

}


put_rec() 
{
    char s_amt_1[20],
		 s_amt_1_1[20],
		 s_amt_1_2[20],

	     s_amt_2[20],
		 s_amt_21[20],
		 s_amt_22[20],

		 s_amt_3[20],
		 s_amt_31[20],
		 s_amt_32[20],

		 s_amt_4[20],
		 s_amt_41[20],
		 s_amt_42[20],

		 s_amt_5[20],
		 s_amt_51[20],
		 s_amt_52[20],

		 s_amt_6[20],
		 s_amt_61[20],
		 s_amt_62[20],

		 s_amt_7[20],
		 s_amt_71[20],
		 s_amt_72[20],

		 s_amt_8[20],
		 s_amt_81[20],
		 s_amt_82[20],

		 s_amt_9[20],
		 s_amt_91[20],
		 s_amt_92[20],

		 s_amt_10[20],
		 s_amt_101[20],
		 s_amt_102[20],

		 s_amt_11[20],
		 s_amt_111[20],
		 s_amt_112[20],

		 s_amt_12[20],
		 s_amt_121[20],
		 s_amt_122[20],

		 s_amt_per[20],
		 s_amt_per1[20],
		 s_amt_per2[20],

		 s_amt_lst_per[20],
		 s_amt_lst_per1[20],
		 s_amt_lst_per2[20];

	int  nom;
    nom = 1;





if (nd_sett_ind.arr[0] != 'C')
{


if (c_d_per_sum == 0 && c_d_per_sum1 == 0)
	c_d_per_sum2 = 0;
else
	c_d_per_sum2 =  (c_d_per_sum / c_d_per_sum1);

if (c_d_per_lst_sum == 0 && c_d_per_lst_sum1 == 0)
	c_d_per_lst_sum2 = 0;
else
	c_d_per_lst_sum2 = (c_d_per_lst_sum / c_d_per_lst_sum1);

d_per_tot_sum2 = d_per_tot_sum2 + c_d_per_sum2;
d_per_tot_lst_sum2 = d_per_tot_lst_sum2 + c_d_per_lst_sum2;

	put_val(s_amt_1,c_d_per_1);
    format_amt(s_amt_1);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_1_1,c_d_per_1_1);
    format_amt(s_amt_1_1);
	put_val(s_amt_1_2,c_d_per_1_2);
    format_amt(s_amt_1_2);
	}

	put_val(s_amt_2,c_d_per_2);
    format_amt(s_amt_2);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_21,c_d_per_21);
    format_amt(s_amt_21);
	put_val(s_amt_22,c_d_per_22);
    format_amt(s_amt_22);
	}

	put_val(s_amt_3,c_d_per_3);
    format_amt(s_amt_3);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_31,c_d_per_31);
    format_amt(s_amt_31);
	put_val(s_amt_32,c_d_per_32);
    format_amt(s_amt_32);
	}

	put_val(s_amt_4,c_d_per_4);
	format_amt(s_amt_4);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_41,c_d_per_41);
    format_amt(s_amt_41);
	put_val(s_amt_42,c_d_per_42);
    format_amt(s_amt_42);
	}

	put_val(s_amt_5,c_d_per_5);
    format_amt(s_amt_5);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_51,c_d_per_51);
    format_amt(s_amt_51);
	put_val(s_amt_52,c_d_per_52);
    format_amt(s_amt_52);
	}

	put_val(s_amt_6,c_d_per_6);
    format_amt(s_amt_6);	
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_61,c_d_per_61);
    format_amt(s_amt_61);
	put_val(s_amt_62,c_d_per_62);
    format_amt(s_amt_62);
	}

	put_val(s_amt_7,c_d_per_7);
    format_amt(s_amt_7);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_71,c_d_per_71);
    format_amt(s_amt_71);
	put_val(s_amt_72,c_d_per_72);
    format_amt(s_amt_72);
	}

	put_val(s_amt_8,c_d_per_8);
    format_amt(s_amt_8);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_81,c_d_per_81);
    format_amt(s_amt_81);
	put_val(s_amt_82,c_d_per_82);
    format_amt(s_amt_82);
	}

	put_val(s_amt_9,c_d_per_9);
    format_amt(s_amt_9);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_91,c_d_per_91);
    format_amt(s_amt_91);
	put_val(s_amt_92,c_d_per_92);
    format_amt(s_amt_92);
	}

	put_val(s_amt_10,c_d_per_10);
    format_amt(s_amt_10);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_101,c_d_per_101);
    format_amt(s_amt_101);
	put_val(s_amt_102,c_d_per_102);
    format_amt(s_amt_102);
	}

	put_val(s_amt_11,c_d_per_11);
    format_amt(s_amt_11);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_111,c_d_per_111);
    format_amt(s_amt_111);
	put_val(s_amt_112,c_d_per_112);
    format_amt(s_amt_112);
	}

	put_val(s_amt_12,c_d_per_12);
    format_amt(s_amt_12);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_121,c_d_per_121);
    format_amt(s_amt_121);
	put_val(s_amt_122,c_d_per_122);
    format_amt(s_amt_122);
	}

	put_val(s_amt_per,c_d_per_sum);
    format_amt(s_amt_per);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_per1,c_d_per_sum1);
    format_amt(s_amt_per1);
	put_val(s_amt_per2,c_d_per_sum2);
    format_amt(s_amt_per2);
	}

	put_val(s_amt_lst_per,c_d_per_lst_sum);
    format_amt(s_amt_lst_per);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_lst_per1,c_d_per_lst_sum1);
    format_amt(s_amt_lst_per1);
	put_val(s_amt_lst_per2,c_d_per_lst_sum2);
    format_amt(s_amt_lst_per2);
	}
}
else
{

if (d_per_sum == 0 && d_per_sum1 == 0)
	d_per_sum2 = 0;
else
	d_per_sum2 =  (d_per_sum / d_per_sum1);

if (d_per_lst_sum == 0 && d_per_lst_sum1 == 0)
	d_per_lst_sum2 = 0;
else
	d_per_lst_sum2 = (d_per_lst_sum / d_per_lst_sum1);

d_per_tot_sum2 = d_per_tot_sum2 + d_per_sum2;
d_per_tot_lst_sum2 = d_per_tot_lst_sum2 + d_per_lst_sum2;


	put_val(s_amt_1,d_per_1);
    format_amt(s_amt_1);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_1_1,d_per_1_1);
    format_amt(s_amt_1_1);
	put_val(s_amt_1_1,d_per_1_2);
    format_amt(s_amt_1_2);
	}

	put_val(s_amt_2,d_per_2);
    format_amt(s_amt_2);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_21,d_per_21);
    format_amt(s_amt_21);
	put_val(s_amt_22,d_per_22);
    format_amt(s_amt_22);
	}

	put_val(s_amt_3,d_per_3);
    format_amt(s_amt_3);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_31,d_per_31);
    format_amt(s_amt_31);
	put_val(s_amt_32,d_per_32);
    format_amt(s_amt_32);
	}

	put_val(s_amt_4,d_per_4);
    format_amt(s_amt_4);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_41,d_per_41);
    format_amt(s_amt_41);
	put_val(s_amt_42,d_per_42);
    format_amt(s_amt_42);
	}

	put_val(s_amt_5,d_per_5);
    format_amt(s_amt_5);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_51,d_per_51);
    format_amt(s_amt_51);
	put_val(s_amt_52,d_per_52);
    format_amt(s_amt_52);
	}

	put_val(s_amt_6,d_per_6);
    format_amt(s_amt_6);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_61,d_per_61);
    format_amt(s_amt_61);
	put_val(s_amt_62,d_per_62);
    format_amt(s_amt_62);
	}

	put_val(s_amt_7,d_per_7);
    format_amt(s_amt_7);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_71,d_per_71);
    format_amt(s_amt_71);
	put_val(s_amt_72,d_per_72);
    format_amt(s_amt_72);
	}

	put_val(s_amt_8,d_per_8);
    format_amt(s_amt_8);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_81,d_per_81);
    format_amt(s_amt_81);
	put_val(s_amt_82,d_per_82);
    format_amt(s_amt_82);
	}

	put_val(s_amt_9,d_per_9);
    format_amt(s_amt_9);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_91,d_per_91);
    format_amt(s_amt_91);
	put_val(s_amt_92,d_per_92);
    format_amt(s_amt_92);
	}

	put_val(s_amt_10,d_per_10);
    format_amt(s_amt_10);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_101,d_per_101);
    format_amt(s_amt_101);
	put_val(s_amt_102,d_per_102);
    format_amt(s_amt_102);
	}

	put_val(s_amt_11,d_per_11);
    format_amt(s_amt_11);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_111,d_per_111);
    format_amt(s_amt_111);
	put_val(s_amt_112,d_per_112);
    format_amt(s_amt_112);
	}

	put_val(s_amt_12,d_per_12);
    format_amt(s_amt_12);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_121,d_per_121);
    format_amt(s_amt_121);
	put_val(s_amt_122,d_per_122);
    format_amt(s_amt_122);
	}

	put_val(s_amt_per,d_per_sum);
    format_amt(s_amt_per);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_per1,d_per_sum1);
    format_amt(s_amt_per1);
	put_val(s_amt_per2,d_per_sum2);
    format_amt(s_amt_per2);
	}

	put_val(s_amt_lst_per,d_per_lst_sum);
    format_amt(s_amt_lst_per);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_lst_per1,d_per_lst_sum1);
    format_amt(s_amt_lst_per1);
	put_val(s_amt_lst_per2,d_per_lst_sum2);
    format_amt(s_amt_lst_per2);
	}

}

/*-- If there is value in current periods total or last period total
     The records should get printed. VSK 06/07/1999  */

//Not displaying if bill amt is zero and patients are there, so the average per
//patient is not matching
//if (nd_sett_ind.arr[0] != 'C' && (c_d_per_sum != 0 || c_d_per_lst_sum != 0))
if (nd_sett_ind.arr[0] != 'C')
{
	fprintf(f1,"%-40s %-2s  %-8s",cd_cust_name.arr,cd_blng_grp_id.arr,cd_cust_code.arr); 
    
	if (nom <= p_no_of_mth)
	  {
		fprintf(f1,"    %15s",s_amt_1);
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		fprintf(f1,"    %15s",s_amt_1_1);
		fprintf(f1,"    %15s",s_amt_1_2);
		}
	  }

	nom++;
	
	if (nom <= p_no_of_mth)
	  {
		fprintf(f1,"  %15s",s_amt_2);
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		fprintf(f1,"  %15s",s_amt_21);
		fprintf(f1,"  %15s",s_amt_22);
		}
	  }
	nom++;

	if (nom <= p_no_of_mth)
	  {
		fprintf(f1,"  %15s",s_amt_3);
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		fprintf(f1,"  %15s",s_amt_31);
		fprintf(f1,"  %15s",s_amt_32);
		}
	   }
	nom++;

	if (nom <= p_no_of_mth)
	  {
		fprintf(f1,"  %15s",s_amt_4);
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		fprintf(f1,"  %15s",s_amt_41);
		fprintf(f1,"  %15s",s_amt_42);
		}
	   }
	nom++;

	if (nom <= p_no_of_mth)
	  {
		fprintf(f1,"  %15s",s_amt_5);
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		fprintf(f1,"  %15s",s_amt_51);
		fprintf(f1,"  %15s",s_amt_52);
		}
	  }
	nom++;

	if (nom <= p_no_of_mth)
	  {
		fprintf(f1,"  %15s",s_amt_6);
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		fprintf(f1,"  %15s",s_amt_61);
		fprintf(f1,"  %15s",s_amt_62);
		}
	   }
	nom++;

	if (nom <= p_no_of_mth)
      {
		fprintf(f1,"  %15s",s_amt_7);
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		fprintf(f1,"  %15s",s_amt_71);
		fprintf(f1,"  %15s",s_amt_72);
		}
	   }
	nom++;

	if (nom <= p_no_of_mth)
	  {
		fprintf(f1,"  %15s",s_amt_8);
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		fprintf(f1,"  %15s",s_amt_81);
		fprintf(f1,"  %15s",s_amt_82);
		}
	   }
	nom++;
	
	if (nom <= p_no_of_mth)
	  {
		fprintf(f1,"  %15s",s_amt_9);
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		fprintf(f1,"  %15s",s_amt_91);
		fprintf(f1,"  %15s",s_amt_92);
		}
	   }
	nom++;

	if (nom <= p_no_of_mth)
	  {
		fprintf(f1,"  %15s",s_amt_10);
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		fprintf(f1,"  %15s",s_amt_101);
		fprintf(f1,"  %15s",s_amt_102);
		}
	   }
	nom++;

	if (nom <= p_no_of_mth)
	   {
		fprintf(f1,"  %15s",s_amt_11);
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		fprintf(f1,"  %15s",s_amt_111);
		fprintf(f1,"  %15s",s_amt_112);
		}
	   }
	nom++;

	if (nom <= p_no_of_mth)
	  {
		fprintf(f1,"  %15s",s_amt_12);
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		fprintf(f1,"  %15s",s_amt_121);
		fprintf(f1,"  %15s",s_amt_122);
		}
	   }
	nom++;

	fprintf(f1,"  %15s",s_amt_per);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	fprintf(f1,"  %15s",s_amt_per1);
	fprintf(f1,"  %15s",s_amt_per2);
	}

	fprintf(f1,"     %15s",s_amt_lst_per);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	fprintf(f1,"     %15s",s_amt_lst_per1);
	fprintf(f1,"     %15s",s_amt_lst_per2);
	}

	nom = 0;
	fprintf(f1,"\n\n");	

	lno +=2;
}

}

prt_tot()
{
    char s_amt_1[20],
		 s_amt_1_1[20],
		 s_amt_1_2[20],

	     s_amt_2[20],
		 s_amt_21[20],
		 s_amt_22[20],

		 s_amt_3[20],
		 s_amt_31[20],
		 s_amt_32[20],

		 s_amt_4[20],
		 s_amt_41[20],
		 s_amt_42[20],

		 s_amt_5[20],
		 s_amt_51[20],
		 s_amt_52[20],

		 s_amt_6[20],
		 s_amt_61[20],
		 s_amt_62[20],

		 s_amt_7[20],
		 s_amt_71[20],
		 s_amt_72[20],

		 s_amt_8[20],
		 s_amt_81[20],
		 s_amt_82[20],

		 s_amt_9[20],
		 s_amt_91[20],
		 s_amt_92[20],

		 s_amt_10[20],
		 s_amt_101[20],
		 s_amt_102[20],

		 s_amt_11[20],
		 s_amt_111[20],
		 s_amt_112[20],

		 s_amt_12[20],
		 s_amt_121[20],
		 s_amt_122[20],

		 s_amt_per[20],
		 s_amt_per1[20],
		 s_amt_per2[20],

		 s_amt_lst_per[20],
		 s_amt_lst_per1[20],
		 s_amt_lst_per2[20];

	int nom;
	nom = 1;

	if (nd_sett_ind.arr[0] == 'X')
	{
		if (nd_adm_rec_flag.arr[0] == '2')
			strcpy(nd_cust_name.arr,"CATEGORY : INSURANCE COMPANIES TOTAL");
		else if (nd_adm_rec_flag.arr[0] == '1')
			 strcpy(nd_cust_name.arr,"CATEGORY : OTHER COMPANIES TOTAL");
			  
	}
	else if (nd_sett_ind.arr[0] == 'R')
			strcpy(nd_cust_name.arr,"CATEGORY : CREDIT PATIENT TOTAL");
	else if (nd_sett_ind.arr[0] == 'C')
	     strcpy(nd_cust_name.arr,"*******CASH TOTAL**********");
		  			  
	strcpy(nd_cust_code.arr," ");

/*-- Category Totals  */

	 fprintf(f1,"%-40s     %-8s    ",nd_cust_name.arr,nd_cust_code.arr); 

	 if (nom <= p_no_of_mth)
	 {
		put_val(s_amt_1,d_per_tot_1);
		format_amt(s_amt_1);
		fprintf(f1,"%15s",s_amt_1);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_1_1,d_per_tot_1_1);
		format_amt(s_amt_1_1);
		fprintf(f1,"    ");
		fprintf(f1,"%15s",s_amt_1_1);

		if (d_per_tot_1 == 0 && d_per_tot_1_1 == 0)
			d_per_tot_1_2 = 0;
		else
			d_per_tot_1_2 = d_per_tot_1 / d_per_tot_1_1;

		put_val(s_amt_1_2,d_per_tot_1_2);
		format_amt(s_amt_1_2);
		fprintf(f1,"    ");
		fprintf(f1,"%15s",s_amt_1_2);
		
		}

	 } 

	nom++;
	
	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_2,d_per_tot_2);
		format_amt(s_amt_2);
		fprintf(f1,"  %15s",s_amt_2);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_21,d_per_tot_21);
		format_amt(s_amt_21);
		fprintf(f1,"  %15s",s_amt_21);

		if (d_per_tot_2 == 0 && d_per_tot_21 == 0)
			d_per_tot_22 = 0;
		else
			d_per_tot_22 = d_per_tot_2 / d_per_tot_21;


		put_val(s_amt_22,d_per_tot_22);
		format_amt(s_amt_22);
		
		fprintf(f1,"  %15s",s_amt_22);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_3,d_per_tot_3);
		format_amt(s_amt_3);
		fprintf(f1,"  %15s",s_amt_3);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_31,d_per_tot_31);
		format_amt(s_amt_31);
		fprintf(f1,"  %15s",s_amt_31);

		if (d_per_tot_3 == 0 && d_per_tot_31 == 0)
			d_per_tot_32 = 0;
		else
			d_per_tot_32 = d_per_tot_3 / d_per_tot_31;

		put_val(s_amt_32,d_per_tot_32);
		format_amt(s_amt_32);
		
		fprintf(f1,"  %15s",s_amt_32);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_4,d_per_tot_4);
		format_amt(s_amt_4);
		fprintf(f1,"  %15s",s_amt_4);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_41,d_per_tot_41);
		format_amt(s_amt_41);
		
		fprintf(f1,"  %15s",s_amt_41);

		if (d_per_tot_4 == 0 && d_per_tot_41 == 0)
			d_per_tot_42 = 0;
		else
			d_per_tot_42 = d_per_tot_4 / d_per_tot_41;

		put_val(s_amt_42,d_per_tot_42);
		format_amt(s_amt_4);
		
		fprintf(f1,"  %15s",s_amt_42);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_5,d_per_tot_5);
		format_amt(s_amt_5);
		fprintf(f1,"  %15s",s_amt_5);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_51,d_per_tot_51);
		format_amt(s_amt_51);
		
		fprintf(f1,"  %15s",s_amt_51);

		if (d_per_tot_5 == 0 && d_per_tot_51 == 0)
			d_per_tot_52 = 0;
		else
			d_per_tot_52 = d_per_tot_5 / d_per_tot_51;

		put_val(s_amt_52,d_per_tot_52);
		format_amt(s_amt_52);
		
		fprintf(f1,"  %15s",s_amt_52);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_6,d_per_tot_6);
		format_amt(s_amt_6);
		fprintf(f1,"  %15s",s_amt_6);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_61,d_per_tot_61);
		format_amt(s_amt_61);
		
		fprintf(f1,"  %15s",s_amt_61);

		if (d_per_tot_6 == 0 && d_per_tot_61 == 0)
			d_per_tot_62 = 0;
		else
			d_per_tot_62 = d_per_tot_6 / d_per_tot_61;

		put_val(s_amt_62,d_per_tot_62);
		format_amt(s_amt_62);
		
		fprintf(f1,"  %15s",s_amt_62);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_7,d_per_tot_7);
		format_amt(s_amt_7);
		fprintf(f1,"  %15s",s_amt_7);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_71,d_per_tot_71);
		format_amt(s_amt_71);
		
		fprintf(f1,"  %15s",s_amt_71);

		if (d_per_tot_7 == 0 && d_per_tot_71 == 0)
			d_per_tot_72 = 0;
		else
			d_per_tot_72 = d_per_tot_7 / d_per_tot_71;

		put_val(s_amt_72,d_per_tot_72);
		format_amt(s_amt_72);
		
		fprintf(f1,"  %15s",s_amt_72);
		}


	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_8,d_per_tot_8);
		format_amt(s_amt_8);
		fprintf(f1,"  %15s",s_amt_8);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{		
		put_val(s_amt_81,d_per_tot_81);
		format_amt(s_amt_81);
		
		fprintf(f1,"  %15s",s_amt_81);

		if (d_per_tot_8 == 0 && d_per_tot_81 == 0)
			d_per_tot_82 = 0;
		else
			d_per_tot_82 = d_per_tot_8 / d_per_tot_81;

		put_val(s_amt_82,d_per_tot_82);
		format_amt(s_amt_82);
		
		fprintf(f1,"  %15s",s_amt_82);
		}

	}

	nom++;

/* Start of Addition by Irfan on 3/01/2000 to cater for 12 periods */

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_9,d_per_tot_9);
		format_amt(s_amt_9);
		fprintf(f1,"  %15s",s_amt_9);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_91,d_per_tot_91);
		format_amt(s_amt_91);
		
		fprintf(f1,"  %15s",s_amt_91);

		if (d_per_tot_9 == 0 && d_per_tot_91 == 0)
			d_per_tot_92 = 0;
		else
			d_per_tot_92 = d_per_tot_9 / d_per_tot_91;

		put_val(s_amt_92,d_per_tot_92);
		format_amt(s_amt_92);
		
		fprintf(f1,"  %15s",s_amt_92);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_10,d_per_tot_10);
		format_amt(s_amt_10);
		fprintf(f1,"  %15s",s_amt_10);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_101,d_per_tot_101);
		format_amt(s_amt_101);
		
		fprintf(f1,"  %15s",s_amt_101);


		if (d_per_tot_10 == 0 && d_per_tot_101 == 0)
			d_per_tot_102 = 0;
		else
			d_per_tot_102 = d_per_tot_10 / d_per_tot_101;

		put_val(s_amt_102,d_per_tot_102);
		format_amt(s_amt_102);
					
		fprintf(f1,"  %15s",s_amt_102);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_11,d_per_tot_11);
		format_amt(s_amt_11);
		fprintf(f1,"  %15s",s_amt_11);

		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_111,d_per_tot_111);
		format_amt(s_amt_111);
		
		fprintf(f1,"  %15s",s_amt_111);


		if (d_per_tot_11 == 0 && d_per_tot_111 == 0)
			d_per_tot_112 = 0;
		else
			d_per_tot_112 = d_per_tot_11 / d_per_tot_111;

		put_val(s_amt_112,d_per_tot_112);
		format_amt(s_amt_112);
		
		fprintf(f1,"  %15s",s_amt_112);
		}

	}

	nom++;


	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_12,d_per_tot_12);
		format_amt(s_amt_12);
		fprintf(f1,"  %15s",s_amt_12);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_121,d_per_tot_121);
		format_amt(s_amt_121);
		
		fprintf(f1,"  %15s",s_amt_121);

		if (d_per_tot_12 == 0 && d_per_tot_121 == 0)
			d_per_tot_122 = 0;
		else
			d_per_tot_122 = d_per_tot_12 / d_per_tot_121;

		put_val(s_amt_122,d_per_tot_122);
		format_amt(s_amt_122);
		
		fprintf(f1,"  %15s",s_amt_122);
		}

	}

	nom++;

/* End of addition by Irfan on 3/1/2000 */

	put_val(s_amt_per,d_per_tot_sum);
    format_amt(s_amt_per);
	
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_per1,d_per_tot_sum1);
    format_amt(s_amt_per1);

	if (d_per_tot_sum == 0 && d_per_tot_sum1 == 0)
			d_per_tot_sum2 = 0;
		else
	d_per_tot_sum2 = d_per_tot_sum / d_per_tot_sum1;

	put_val(s_amt_per2,d_per_tot_sum2);
    format_amt(s_amt_per2);
	}

	put_val(s_amt_lst_per,d_per_tot_lst_sum);
    format_amt(s_amt_lst_per);	
	
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_lst_per1,d_per_tot_lst_sum1);
    format_amt(s_amt_lst_per1);	

	if (d_per_tot_lst_sum == 0 && d_per_tot_lst_sum1 == 0)
		d_per_tot_lst_sum2 = 0;
	else
		d_per_tot_lst_sum2 = d_per_tot_lst_sum / d_per_tot_lst_sum1;

	put_val(s_amt_lst_per2,d_per_tot_lst_sum2);
    format_amt(s_amt_lst_per2);	
	}

	fprintf(f1,"  %15s",s_amt_per);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	fprintf(f1,"  %15s",s_amt_per1);
	fprintf(f1,"  %15s",s_amt_per2);
	}

	fprintf(f1,"     %15s",s_amt_lst_per);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	fprintf(f1,"     %15s",s_amt_lst_per1);
	
	fprintf(f1,"     %15s",s_amt_lst_per2);
	}

	nom = 0;
	
	fprintf(f1,"\n\n");	

	lno +=2;

/*--- Category Totals over */

	d_per_gtot_1 += d_per_tot_1;
	d_per_gtot_1_1 += d_per_tot_1_1;
	d_per_gtot_1_2 += d_per_tot_1_2;

	d_per_gtot_2 += d_per_tot_2;
	d_per_gtot_21 += d_per_tot_21;
	d_per_gtot_22 += d_per_tot_22;

	d_per_gtot_3 += d_per_tot_3;
	d_per_gtot_31 += d_per_tot_31;
	d_per_gtot_32 += d_per_tot_32;

	d_per_gtot_4 += d_per_tot_4;
	d_per_gtot_41 += d_per_tot_41;
	d_per_gtot_42 += d_per_tot_42;

	d_per_gtot_5 += d_per_tot_5;
	d_per_gtot_51 += d_per_tot_51;
	d_per_gtot_52 += d_per_tot_52;

	d_per_gtot_6 += d_per_tot_6;
	d_per_gtot_61 += d_per_tot_61;
	d_per_gtot_62 += d_per_tot_62;

	d_per_gtot_7 += d_per_tot_7;
	d_per_gtot_71 += d_per_tot_71;	
	d_per_gtot_72 += d_per_tot_72;	
		
	d_per_gtot_8 += d_per_tot_8;
	d_per_gtot_81 += d_per_tot_81;	
	d_per_gtot_82 += d_per_tot_82;	
		
	d_per_gtot_9 += d_per_tot_9;
	d_per_gtot_91 += d_per_tot_91;
	d_per_gtot_92 += d_per_tot_92;

	d_per_gtot_10 += d_per_tot_10;
	d_per_gtot_101 += d_per_tot_101;
	d_per_gtot_102 += d_per_tot_102;

	d_per_gtot_11 += d_per_tot_11;
	d_per_gtot_111 += d_per_tot_111;	
	d_per_gtot_112 += d_per_tot_112;	
		
	d_per_gtot_12 += d_per_tot_12;
	d_per_gtot_121 += d_per_tot_121;	
	d_per_gtot_122 += d_per_tot_122;	
		
	d_per_gtot_sum += d_per_tot_sum;
	d_per_gtot_sum1 += d_per_tot_sum1;
	d_per_gtot_sum2 += d_per_tot_sum2;

	d_per_gtot_lst_sum += d_per_tot_lst_sum;
	d_per_gtot_lst_sum1 += d_per_tot_lst_sum1;
	d_per_gtot_lst_sum2 += d_per_tot_lst_sum2;

	d_per_tot_1 = 0;
	d_per_tot_1_1 = 0;
	d_per_tot_1_2 = 0;
	
	d_per_tot_2 = 0;
	d_per_tot_21 = 0;
	d_per_tot_22 = 0;

	d_per_tot_3 = 0;
	d_per_tot_31 = 0;
	d_per_tot_32 = 0;

	d_per_tot_4 = 0;
	d_per_tot_41 = 0;
	d_per_tot_42 = 0;

	d_per_tot_5 = 0;
	d_per_tot_51 = 0;
	d_per_tot_52 = 0;

	d_per_tot_6 = 0;
	d_per_tot_61 = 0;
	d_per_tot_62 = 0;

	d_per_tot_7 = 0;
	d_per_tot_71 = 0;
	d_per_tot_72 = 0;

	d_per_tot_8 = 0;
	d_per_tot_81 = 0;
	d_per_tot_82 = 0;

	d_per_tot_9 = 0;
	d_per_tot_91 = 0;
	d_per_tot_92 = 0;

	d_per_tot_10 = 0;
	d_per_tot_101 = 0;
	d_per_tot_102 = 0;

	d_per_tot_11 = 0;
	d_per_tot_111 = 0;
	d_per_tot_112 = 0;
	
	d_per_tot_12 = 0;
	d_per_tot_121 = 0;
	d_per_tot_122 = 0;

	d_per_tot_sum = 0;
	d_per_tot_sum1 = 0;
	d_per_tot_sum2 = 0;

	d_per_tot_lst_sum = 0;
	d_per_tot_lst_sum1 = 0;
	d_per_tot_lst_sum2 = 0;


}

print_credit_total()
{
	char s_amt_1[20],
		 s_amt_1_1[20],
		 s_amt_1_2[20],
	     s_amt_2[20],
		 s_amt_21[20],
		 s_amt_22[20],
		 s_amt_3[20],
		 s_amt_31[20],
		 s_amt_32[20],
		 s_amt_4[20],
		 s_amt_41[20],
		 s_amt_42[20],
		 s_amt_5[20],
		 s_amt_51[20],
		 s_amt_52[20],
		 s_amt_6[20],
		 s_amt_61[20],
		 s_amt_62[20],
		 s_amt_7[20],
		 s_amt_71[20],
		 s_amt_72[20],
		 s_amt_8[20],
		 s_amt_81[20],
		 s_amt_82[20],
		 s_amt_9[20],
		 s_amt_91[20],
		 s_amt_92[20],
		 s_amt_10[20],
		 s_amt_101[20],
		 s_amt_102[20],
		 s_amt_11[20],
		 s_amt_111[20],
		 s_amt_112[20],
		 s_amt_12[20],
		 s_amt_121[20],
		 s_amt_122[20],
		 s_amt_per[20],
		 s_amt_per1[20],
		 s_amt_per2[20],
		 s_amt_lst_per[20],
		 s_amt_lst_per1[20],
		 s_amt_lst_per2[20];

	int  nom;
    
	    
	strcpy(nd_cust_code.arr," ");
	strcpy(nd_cust_name.arr,"*******CREDIT TOTAL********");
	
	
/*-- Grand Totals (Credits) 
     ie. Sponsor / Other Company / Credit Patients */

	nom = 1;
    
	fprintf(f1,"%-40s     %-8s    ",nd_cust_name.arr,nd_cust_code.arr);
	
	if (nom <= p_no_of_mth)
	{
		
    	put_val(s_amt_1,d_per_gtot_1);
		format_amt(s_amt_1);
		fprintf(f1,"%15s",s_amt_1);


		if (p_inc_no_pat.arr[0] == 'Y')
		{fprintf(f1,"    ");
		put_val(s_amt_1_1,d_per_gtot_1_1);
		format_amt(s_amt_1_1);
		fprintf(f1,"%15s",s_amt_1_1);
		fprintf(f1,"    ");

		if (d_per_gtot_1 == 0 && d_per_gtot_1_1 == 0)
			d_per_gtot_1_2 = 0;
		else
			d_per_gtot_1_2 = d_per_gtot_1 / d_per_gtot_1_1;

		put_val(s_amt_1_2,d_per_gtot_1_2);
		format_amt(s_amt_1_2);
		fprintf(f1,"%15s",s_amt_1_2);
		}

	}

	nom++;
	
	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_2,d_per_gtot_2);
		format_amt(s_amt_2);
		fprintf(f1,"  %15s",s_amt_2);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{/*fprintf(f1,"   "); */
		put_val(s_amt_21,d_per_gtot_21);
		format_amt(s_amt_21);
		fprintf(f1,"  %15s",s_amt_21);

		if (d_per_gtot_2 == 0 && d_per_gtot_21 == 0)
			d_per_gtot_22 = 0;
		else
			d_per_gtot_22 = d_per_gtot_2 / d_per_gtot_21;

		put_val(s_amt_22,d_per_gtot_22);
		format_amt(s_amt_22);
		/*fprintf(f1,"     "); */
		fprintf(f1,"  %15s",s_amt_22);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_3,d_per_gtot_3);
		format_amt(s_amt_3);
		fprintf(f1,"  %15s",s_amt_3);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_31,d_per_gtot_31);
		format_amt(s_amt_31);
		fprintf(f1,"  %15s",s_amt_31);

		if (d_per_gtot_3 == 0 && d_per_gtot_31 == 0)
			d_per_gtot_32 = 0;
		else
			d_per_gtot_32 = d_per_gtot_3 / d_per_gtot_31;

		put_val(s_amt_32,d_per_gtot_32);
		format_amt(s_amt_32);
		fprintf(f1,"  %15s",s_amt_32);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_4,d_per_gtot_4);
		format_amt(s_amt_4);
		fprintf(f1,"  %15s",s_amt_4);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_41,d_per_gtot_41);
		format_amt(s_amt_41);
		fprintf(f1,"  %15s",s_amt_41);


		if (d_per_gtot_4 == 0 && d_per_gtot_41 == 0)
			d_per_gtot_42 = 0;
		else
			d_per_gtot_42 = d_per_gtot_4 / d_per_gtot_41;

		put_val(s_amt_42,d_per_gtot_42);
		format_amt(s_amt_42);
		fprintf(f1,"  %15s",s_amt_42);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_5,d_per_gtot_5);
		format_amt(s_amt_5);
		fprintf(f1,"  %15s",s_amt_5);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_51,d_per_gtot_51);
		format_amt(s_amt_51);
		fprintf(f1,"  %15s",s_amt_51);

		if (d_per_gtot_5 == 0 && d_per_gtot_51 == 0)
			d_per_gtot_52 = 0;
		else
			d_per_gtot_52 = d_per_gtot_5 / d_per_gtot_51;

		put_val(s_amt_52,d_per_gtot_52);
		format_amt(s_amt_52);
		fprintf(f1,"  %15s",s_amt_52);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_6,d_per_gtot_6);
		format_amt(s_amt_6);
		fprintf(f1,"  %15s",s_amt_6);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{	
		put_val(s_amt_61,d_per_gtot_61);
		format_amt(s_amt_61);
		fprintf(f1,"  %15s",s_amt_61);

		if (d_per_gtot_6 == 0 && d_per_gtot_61 == 0)
			d_per_gtot_62 = 0;
		else
			d_per_gtot_62 = d_per_gtot_6 / d_per_gtot_61;

		put_val(s_amt_62,d_per_gtot_62);
		format_amt(s_amt_62);
		fprintf(f1,"  %15s",s_amt_62);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_7,d_per_gtot_7);
		format_amt(s_amt_7);
		fprintf(f1,"  %15s",s_amt_7);

		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_71,d_per_gtot_71);
		format_amt(s_amt_71);
		fprintf(f1,"  %15s",s_amt_71);

		if (d_per_gtot_7 == 0 && d_per_gtot_71 == 0)
			d_per_gtot_72 = 0;
		else
			d_per_gtot_72 = d_per_gtot_7 / d_per_gtot_71;

		put_val(s_amt_72,d_per_gtot_72);
		format_amt(s_amt_72);
		fprintf(f1,"  %15s",s_amt_72);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_8,d_per_gtot_8);
		format_amt(s_amt_8);
		fprintf(f1,"  %15s",s_amt_8);

		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_81,d_per_gtot_81);
		format_amt(s_amt_81);
		fprintf(f1,"  %15s",s_amt_81);

		if (d_per_gtot_8 == 0 && d_per_gtot_81 == 0)
			d_per_gtot_82 = 0;
		else
			d_per_gtot_82 = d_per_gtot_8 / d_per_gtot_81;

		put_val(s_amt_82,d_per_gtot_82);
		format_amt(s_amt_82);
		fprintf(f1,"  %15s",s_amt_82);
		
		}

	}

	nom++;

/* Start of addition by Irfan on 3/1/2000 to cater for 12 periods */

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_9,d_per_gtot_9);
		format_amt(s_amt_9);
		fprintf(f1,"  %15s",s_amt_9);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_91,d_per_gtot_91);
		format_amt(s_amt_91);
		fprintf(f1,"  %15s",s_amt_91);

		if (d_per_gtot_9 == 0 && d_per_gtot_91 == 0)
			d_per_gtot_92 = 0;
		else
			d_per_gtot_92 = d_per_gtot_9 / d_per_gtot_91;

		put_val(s_amt_92,d_per_gtot_92);
		format_amt(s_amt_92);
		fprintf(f1,"  %15s",s_amt_92);

		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_10,d_per_gtot_10);
		format_amt(s_amt_10);
		fprintf(f1,"  %15s",s_amt_10);

		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_101,d_per_gtot_101);
		format_amt(s_amt_101);
		fprintf(f1,"  %15s",s_amt_101);

		if (d_per_gtot_10 == 0 && d_per_gtot_101 == 0)
			d_per_gtot_102 = 0;
		else
			d_per_gtot_102 = d_per_gtot_10 / d_per_gtot_101;

		put_val(s_amt_102,d_per_gtot_102);
		format_amt(s_amt_102);
		fprintf(f1,"  %15s",s_amt_102);
		}


	}

	nom++;

		if (nom <= p_no_of_mth)
	{
		put_val(s_amt_11,d_per_gtot_11);
		format_amt(s_amt_11);
		fprintf(f1,"  %15s",s_amt_11);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_111,d_per_gtot_111);
		format_amt(s_amt_111);
		fprintf(f1,"  %15s",s_amt_111);

		if (d_per_gtot_11 == 0 && d_per_gtot_111 == 0)
			d_per_gtot_112 = 0;
		else
			d_per_gtot_112 = d_per_gtot_11 / d_per_gtot_111;

		put_val(s_amt_112,d_per_gtot_112);
		format_amt(s_amt_112);
		fprintf(f1,"  %15s",s_amt_112);
		}

	}

	nom++;

		if (nom <= p_no_of_mth)
	{
		put_val(s_amt_12,d_per_gtot_12);
		format_amt(s_amt_12);
		fprintf(f1,"  %15s",s_amt_12);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_121,d_per_gtot_121);
		format_amt(s_amt_121);
		fprintf(f1,"  %15s",s_amt_121);

		if (d_per_gtot_12 == 0 && d_per_gtot_121 == 0)
			d_per_gtot_122 = 0;
		else
			d_per_gtot_122 = d_per_gtot_12 / d_per_gtot_121;

		put_val(s_amt_122,d_per_gtot_122);
		format_amt(s_amt_122);
		fprintf(f1,"  %15s",s_amt_122);
		}
	}

	nom++;

/* End of addition by Irfan on 3/1/2000 */

	put_val(s_amt_per,d_per_gtot_sum);
    format_amt(s_amt_per);
	
	if (p_inc_no_pat.arr[0] == 'Y')
	{	
	put_val(s_amt_per1,d_per_gtot_sum1);
    format_amt(s_amt_per1);
	
	if (d_per_gtot_sum == 0 && d_per_gtot_sum1 == 0)
		d_per_gtot_sum2 = 0;
	else
		d_per_gtot_sum2 = d_per_gtot_sum / d_per_gtot_sum1;

	put_val(s_amt_per2,d_per_gtot_sum2);
    format_amt(s_amt_per2);
	}

	put_val(s_amt_lst_per,d_per_gtot_lst_sum);
    format_amt(s_amt_lst_per);	

	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_lst_per1,d_per_gtot_lst_sum1);
    format_amt(s_amt_lst_per1);	

	if (d_per_gtot_lst_sum == 0 && d_per_gtot_lst_sum1 == 0)
		d_per_gtot_lst_sum2 = 0;
	else
		d_per_gtot_lst_sum2 = d_per_gtot_lst_sum / d_per_gtot_lst_sum1;

	put_val(s_amt_lst_per2,d_per_gtot_lst_sum2);
    format_amt(s_amt_lst_per2);	
	}
	
	fprintf(f1,"  %15s",s_amt_per);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	fprintf(f1,"  %15s",s_amt_per1);
	fprintf(f1,"  %15s",s_amt_per2);
	}

	fprintf(f1,"     %15s",s_amt_lst_per);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	fprintf(f1,"     %15s",s_amt_lst_per1);
	fprintf(f1,"     %15s",s_amt_lst_per2);
	}

	nom = 0;
	
	fprintf(f1,"\n\n");	

	lno +=2;

/*--- Credit Grand Totals over */

}


print_grand_total()
{
    char s_amt_1[20],
		 s_amt_1_1[20],
		 s_amt_1_2[20],

	     s_amt_2[20],
		 s_amt_21[20],
		 s_amt_22[20],

		 s_amt_3[20],
		 s_amt_31[20],
		 s_amt_32[20],

		 s_amt_4[20],
		 s_amt_41[20],
		 s_amt_42[20],

		 s_amt_5[20],
		 s_amt_51[20],
		 s_amt_52[20],

		 s_amt_6[20],
		 s_amt_61[20],
		 s_amt_62[20],

		 s_amt_7[20],
		 s_amt_71[20],
		 s_amt_72[20],

		 s_amt_8[20],
		 s_amt_81[20],
		 s_amt_82[20],

		 s_amt_9[20],
		 s_amt_91[20],
		 s_amt_92[20],

		 s_amt_10[20],
		 s_amt_101[20],
		 s_amt_102[20],

		 s_amt_11[20],
		 s_amt_111[20],
		 s_amt_112[20],

		 s_amt_12[20],
		 s_amt_121[20],
		 s_amt_122[20],

		 s_amt_per[20],
		 s_amt_per1[20],
		 s_amt_per2[20],

		 s_amt_lst_per[20],
		 s_amt_lst_per1[20],
		 s_amt_lst_per2[20];


	int  nom;
	nom = 1;

	strcpy(nd_cust_name.arr,"*******REVENUE TOTAL*******");
	
	strcpy(nd_cust_code.arr," ");


/*-- Grand Totals  (Credit + Cash) */
	if (p_inc_no_pat.arr[0] != 'Y')
		{
			fprintf(f1,"%-40s     %-8s    ",nd_cust_name.arr,nd_cust_code.arr);
		}

	if (p_inc_no_pat.arr[0] == 'Y')
	fprintf(f1,"%-40s     %-4s    ",nd_cust_name.arr,nd_cust_code.arr);
	
	if (p_inc_no_pat.arr[0] == 'Y')
		fprintf(f1,"    ");

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_1,d_per_gtot_1);
		format_amt(s_amt_1);
		fprintf(f1,"%15s",s_amt_1);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_1_1,d_per_gtot_1_1);
		format_amt(s_amt_1_1);
		fprintf(f1,"    ");
		fprintf(f1,"%15s",s_amt_1_1);
		fprintf(f1,"    ");

		if (d_per_gtot_1 == 0 && d_per_gtot_1_1 == 0)
			d_per_gtot_1_2 = 0;
		else
			d_per_gtot_1_2 = d_per_gtot_1 / d_per_gtot_1_1;

		put_val(s_amt_1_2,d_per_gtot_1_2);
		format_amt(s_amt_1_2);
		fprintf(f1,"%15s",s_amt_1_2);
		}

	}

	nom++;
	
	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_2,d_per_gtot_2);
		format_amt(s_amt_2);
		fprintf(f1,"  %15s",s_amt_2);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_21,d_per_gtot_21);
		format_amt(s_amt_21);
		fprintf(f1,"  %15s",s_amt_21);

		if (d_per_gtot_2 == 0 && d_per_gtot_21 == 0)
			d_per_gtot_22 = 0;
		else
			d_per_gtot_22 = d_per_gtot_2 / d_per_gtot_21;

		put_val(s_amt_22,d_per_gtot_22);
		format_amt(s_amt_22);
		fprintf(f1,"  %15s",s_amt_22);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_3,d_per_gtot_3);
		format_amt(s_amt_3);
		fprintf(f1,"  %15s",s_amt_3);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_31,d_per_gtot_31);
		format_amt(s_amt_31);
		fprintf(f1,"  %15s",s_amt_31);

		if (d_per_gtot_3 == 0 && d_per_gtot_31 == 0)
			d_per_gtot_32 = 0;
		else
			d_per_gtot_32 = d_per_gtot_3 / d_per_gtot_31;

		put_val(s_amt_32,d_per_gtot_32);
		format_amt(s_amt_32);
		fprintf(f1,"  %15s",s_amt_32);
		}
	
	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_4,d_per_gtot_4);
		format_amt(s_amt_4);
		fprintf(f1,"  %15s",s_amt_4);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_41,d_per_gtot_41);
		format_amt(s_amt_41);
		fprintf(f1,"  %15s",s_amt_41);

		if (d_per_gtot_4 == 0 && d_per_gtot_41 == 0)
			d_per_gtot_42 = 0;
		else
			d_per_gtot_42 = d_per_gtot_4 / d_per_gtot_41;

		put_val(s_amt_42,d_per_gtot_42);
		format_amt(s_amt_42);
		fprintf(f1,"  %15s",s_amt_42);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_5,d_per_gtot_5);
		format_amt(s_amt_5);
		fprintf(f1,"  %15s",s_amt_5);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_51,d_per_gtot_51);
		format_amt(s_amt_51);
		fprintf(f1,"  %15s",s_amt_51);

		if (d_per_gtot_5 == 0 && d_per_gtot_51 == 0)
			d_per_gtot_52 = 0;
		else
			d_per_gtot_52 = d_per_gtot_5 / d_per_gtot_51;

		put_val(s_amt_52,d_per_gtot_52);
		format_amt(s_amt_52);
		fprintf(f1,"  %15s",s_amt_52);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_6,d_per_gtot_6);
		format_amt(s_amt_6);
		fprintf(f1,"  %15s",s_amt_6);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_61,d_per_gtot_61);
		format_amt(s_amt_61);
		fprintf(f1,"  %15s",s_amt_61);

		if (d_per_gtot_6 == 0 && d_per_gtot_61 == 0)
			d_per_gtot_62 = 0;
		else
			d_per_gtot_62 = d_per_gtot_6 / d_per_gtot_61;

		put_val(s_amt_62,d_per_gtot_62);
		format_amt(s_amt_62);
		fprintf(f1,"  %15s",s_amt_62);
		}


	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_7,d_per_gtot_7);
		format_amt(s_amt_7);
		fprintf(f1,"  %15s",s_amt_7);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_71,d_per_gtot_71);
		format_amt(s_amt_71);
		fprintf(f1,"  %15s",s_amt_71);

		if (d_per_gtot_7 == 0 && d_per_gtot_71 == 0)
			d_per_gtot_72 = 0;
		else
			d_per_gtot_72 = d_per_gtot_7 / d_per_gtot_71;

		put_val(s_amt_72,d_per_gtot_72);
		format_amt(s_amt_72);
		fprintf(f1,"  %15s",s_amt_72);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_8,d_per_gtot_8);
		format_amt(s_amt_8);
		fprintf(f1,"  %15s",s_amt_8);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_81,d_per_gtot_81);
		format_amt(s_amt_81);
		fprintf(f1,"  %15s",s_amt_81);

		if (d_per_gtot_8 == 0 && d_per_gtot_81 == 0)
			d_per_gtot_82 = 0;
		else
			d_per_gtot_82 = d_per_gtot_8 / d_per_gtot_81;

		put_val(s_amt_82,d_per_gtot_82);
		format_amt(s_amt_82);
		fprintf(f1,"  %15s",s_amt_82);
		}

	}

	nom++;

/* Start of addition by Irfan on 3/1/2000 to cater for 12 periods */

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_9,d_per_gtot_9);
		format_amt(s_amt_9);
		fprintf(f1,"  %15s",s_amt_9);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_91,d_per_gtot_91);
		format_amt(s_amt_91);
		fprintf(f1,"  %15s",s_amt_91);

		if (d_per_gtot_9 == 0 && d_per_gtot_91 == 0)
			d_per_gtot_92 = 0;
		else
			d_per_gtot_92 = d_per_gtot_9 / d_per_gtot_91;

		put_val(s_amt_92,d_per_gtot_92);
		format_amt(s_amt_92);
		fprintf(f1,"  %15s",s_amt_92);
		}


	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_10,d_per_gtot_10);
		format_amt(s_amt_10);
		fprintf(f1,"  %15s",s_amt_10);

		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_101,d_per_gtot_101);
		format_amt(s_amt_101);
		fprintf(f1,"  %15s",s_amt_101);

		if (d_per_gtot_10 == 0 && d_per_gtot_101 == 0)
			d_per_gtot_102 = 0;
		else
			d_per_gtot_102 = d_per_gtot_10 / d_per_gtot_101;

		put_val(s_amt_102,d_per_gtot_102);
		format_amt(s_amt_102);
		fprintf(f1,"  %15s",s_amt_102);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_11,d_per_gtot_11);
		format_amt(s_amt_11);
		fprintf(f1,"  %15s",s_amt_11);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_111,d_per_gtot_111);
		format_amt(s_amt_111);
		fprintf(f1,"  %15s",s_amt_111);

		if (d_per_gtot_11 == 0 && d_per_gtot_111 == 0)
			d_per_gtot_112 = 0;
		else
			d_per_gtot_112 = d_per_gtot_11 / d_per_gtot_111;

		put_val(s_amt_112,d_per_gtot_112);
		format_amt(s_amt_112);
		fprintf(f1,"  %15s",s_amt_112);
		}

	}

	nom++;

	if (nom <= p_no_of_mth)
	{
		put_val(s_amt_12,d_per_gtot_12);
		format_amt(s_amt_12);
		fprintf(f1,"  %15s",s_amt_12);
		
		if (p_inc_no_pat.arr[0] == 'Y')
		{
		put_val(s_amt_121,d_per_gtot_121);
		format_amt(s_amt_121);
		fprintf(f1,"  %15s",s_amt_121);

		if (d_per_gtot_12 == 0 && d_per_gtot_121 == 0)
			d_per_gtot_122 = 0;
		else
			d_per_gtot_122 = d_per_gtot_12 / d_per_gtot_121;

		put_val(s_amt_122,d_per_gtot_122);
		format_amt(s_amt_122);
		fprintf(f1,"  %15s",s_amt_122);
		}

	}

	nom++;

/* End of Addition by Irfan on 3/1/2000 */

	put_val(s_amt_per,d_per_gtot_sum);
    format_amt(s_amt_per);
	
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_per1,d_per_gtot_sum1);
    format_amt(s_amt_per1);

	if (d_per_gtot_sum == 0 && d_per_gtot_sum1 == 0)
		d_per_gtot_sum2 = 0;
	else
		d_per_gtot_sum2 = d_per_gtot_sum / d_per_gtot_sum1;

	put_val(s_amt_per2,d_per_gtot_sum2);
    format_amt(s_amt_per2);
	}

	put_val(s_amt_lst_per,d_per_gtot_lst_sum);
    format_amt(s_amt_lst_per);
	
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	put_val(s_amt_lst_per1,d_per_gtot_lst_sum1);
    format_amt(s_amt_lst_per1);

	if (d_per_gtot_lst_sum == 0 && d_per_gtot_lst_sum1 == 0)
		d_per_gtot_lst_sum2 = 0;
	else
		d_per_gtot_lst_sum2 = d_per_gtot_lst_sum / d_per_gtot_lst_sum1;

	put_val(s_amt_lst_per2,d_per_gtot_lst_sum2);
    format_amt(s_amt_lst_per2);
	}

	fprintf(f1,"  %15s",s_amt_per);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	fprintf(f1,"  %15s",s_amt_per1);
	fprintf(f1,"  %15s",s_amt_per2);
	}

	fprintf(f1,"     %15s",s_amt_lst_per);
	if (p_inc_no_pat.arr[0] == 'Y')
	{
	fprintf(f1,"     %15s",s_amt_lst_per1);
	fprintf(f1,"     %15s",s_amt_lst_per2);
	}

	nom = 0;
	
	fprintf(f1,"\n\n");	

	lno +=2;

/*--- Grand Totals over */

	d_per_gtot_1 = 0;
	d_per_gtot_1_1 = 0;
	d_per_gtot_1_2 = 0;

	d_per_gtot_2 = 0;
	d_per_gtot_21 = 0;
	d_per_gtot_22 = 0;

	d_per_gtot_3 = 0;
	d_per_gtot_31 = 0;
	d_per_gtot_32 = 0;

	d_per_gtot_4 = 0;
	d_per_gtot_41 = 0;
	d_per_gtot_42 = 0;

	d_per_gtot_5 = 0;
	d_per_gtot_51 = 0;
	d_per_gtot_52 = 0;

	d_per_gtot_6 = 0;
	d_per_gtot_61 = 0;
	d_per_gtot_62 = 0;

	d_per_gtot_7 = 0;
	d_per_gtot_71 = 0;
	d_per_gtot_72 = 0;

	d_per_gtot_8 = 0;
	d_per_gtot_81 = 0;
	d_per_gtot_82 = 0;

	d_per_gtot_9 = 0;
	d_per_gtot_91 = 0;
	d_per_gtot_92 = 0;

	d_per_gtot_10 = 0;
	d_per_gtot_101 = 0;
	d_per_gtot_102 = 0;

	d_per_gtot_11 = 0;
	d_per_gtot_111 = 0;
	d_per_gtot_112 = 0;

	d_per_gtot_12 = 0;
	d_per_gtot_121 = 0;
	d_per_gtot_122 = 0;

	d_per_gtot_sum = 0;
	d_per_gtot_sum1 = 0;
	d_per_gtot_sum2 = 0;

	d_per_gtot_lst_sum = 0;
	d_per_gtot_lst_sum1 = 0;
	d_per_gtot_lst_sum2 = 0;

	d_per_tot_1 = 0;
	d_per_tot_11 = 0;
	d_per_tot_12 = 0;

	d_per_tot_2 = 0;
	d_per_tot_21 = 0;
	d_per_tot_22 = 0;

	d_per_tot_3 = 0;
	d_per_tot_31 = 0;
	d_per_tot_32 = 0;

	d_per_tot_4 = 0;
	d_per_tot_41 = 0;
	d_per_tot_42 = 0;

	d_per_tot_5 = 0;
	d_per_tot_51 = 0;
	d_per_tot_52 = 0;

	d_per_tot_6 = 0;
	d_per_tot_61 = 0;
	d_per_tot_62 = 0;

	d_per_tot_7 = 0;
	d_per_tot_71 = 0;
	d_per_tot_72 = 0;

	d_per_tot_8 = 0;
	d_per_tot_81 = 0;
	d_per_tot_82 = 0;

	d_per_tot_9 = 0;
	d_per_tot_91 = 0;
	d_per_tot_92 = 0;

	d_per_tot_10 = 0;
	d_per_tot_101 = 0;
	d_per_tot_102 = 0;

	d_per_tot_11 = 0;
	d_per_tot_111 = 0;
	d_per_tot_112 = 0;

	d_per_tot_12 = 0;
	d_per_tot_121 = 0;
	d_per_tot_122 = 0;

	d_per_tot_sum = 0;
	d_per_tot_sum1 = 0;
	d_per_tot_sum2 = 0;

	d_per_tot_lst_sum = 0;
	d_per_tot_lst_sum1 = 0;
	d_per_tot_lst_sum2 = 0;

}


chk_break(nol)
int nol;
{
	if(lno+nol >= 55) 
	{
		/* added by IRFAN to cater for comp printing */
		if (print_rep_yn.arr[0] == 'Y')
			fprintf(f1,"%c",0x12); /**** Set Printer to Normal Mode ****/

	   fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------\n");
	   fprintf(f1,"");
	   lno = 1;
	   ++page_no;
	   put_hdr();
	}
}

put_inp_parm()
{
    fprintf(f1,"MDL : BL      %30s%30s%24s                %s\n"," ",comp_name.arr," ",rep_date.arr);
    fprintf(f1,"OPR : %s\n",oper_id.arr);
    fprintf(f1,"REP : BLRREVN1                                     REVENUE ANALYSIS REPORT                                             PAGE : %4d\n",page_no);
    fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"VER : 4.1\n");
    fprintf(f1,"\n\n\n\n");
    fprintf(f1,"\tINPUT PARAMETERS\n");
    fprintf(f1,"\t----------------\n\n");


	fprintf(f1,"\t\t        PERIOD        FROM :%2s / %4s \n", p_fm_post_mth.arr, p_fm_post_yr.arr);
	fprintf(f1,"\t\t                        TO :%2s / %4s\n\n",p_to_post_mth.arr,p_to_post_yr.arr);

    
	if (p_fm_cust_cd.arr[0] == '!') 
	  fprintf(f1,"\t\t        CUSTOMER      FROM : %s\n","LOWEST");
	else
	  fprintf(f1,"\t\t        CUSTOMER      FROM : %s\n",p_fm_cust_cd.arr);
	
	if (p_to_cust_cd.arr[0] == '~') 
      fprintf(f1,"\t\t                        TO : %s\n\n","HIGHEST");
	else
	  fprintf(f1,"\t\t                        TO : %s\n\n",p_to_cust_cd.arr);
     
	  fprintf(f1,"\t\t        FACILITY      FROM : %s\n",nd_fr_facility.arr);
	  fprintf(f1,"\t\t                        TO : %s\n\n",nd_to_facility.arr);
      fprintf(f1,"\t\t                    OPTION : %s\n\n", nd_option.arr);
	 
	if (p_cat_type.arr[0] == 'C')
        fprintf(f1,"\t\t        CATEGORY TYPE      : Cash Patient   \n\n");
	else if (p_cat_type.arr[0] == 'R')
	    fprintf(f1,"\t\t        CATEGORY TYPE      : Credit Patient \n\n");
// for insurance it was X before which has been changed to I vsk 5/6/99
	else if (p_cat_type.arr[0] == 'I')
	    fprintf(f1,"\t\t        CATEGORY TYPE      : Insurance Company \n\n");
	else if (p_cat_type.arr[0] == 'O')
	    fprintf(f1,"\t\t        CATEGORY TYPE      : Other Company \n\n");
	else if (p_cat_type.arr[0] == 'A')
	    fprintf(f1,"\t\t        CATEGORY TYPE      : All Category \n\n");

		if (p_epsd_type.arr[0] == 'A')
        fprintf(f1,"\t\t        EPISODE TYPE	   : All Patients  \n\n");
	else if (p_epsd_type.arr[0] == 'I')
	    fprintf(f1,"\t\t        EPISODE TYPE	   : Inpatient Only \n\n");
	else if (p_epsd_type.arr[0] == 'D')
	    fprintf(f1,"\t\t        EPISODE TYPE	   : Daycare  Only \n\n");        
	else if (p_epsd_type.arr[0] == 'O')
	    fprintf(f1,"\t\t        EPISODE TYPE	   : Outpatient Only \n\n");
	else if (p_epsd_type.arr[0] == 'E')
	    fprintf(f1,"\t\t        EPISODE TYPE	   : Emergency Only \n\n");       
	else if (p_epsd_type.arr[0] == 'R')
	    fprintf(f1,"\t\t        EPISODE TYPE	   : Referal Patient Only \n\n");
	
	if (p_inc_no_pat.arr[0] == 'Y')
        fprintf(f1,"\t\t        INCLUDE NO OF PATIENT: Yes  \n\n");
	else fprintf(f1,"\t\t        INCLUDE NO OF PATIENT: No  \n\n");
	    
	fprintf(f1,"");
    ++page_no;
}


print_end_of_rep()
{	/* added by IRFAN to cater for comp printing */
		if (print_rep_yn.arr[0] == 'Y')
			fprintf(f1,"%c",0x12); /**** Set Printer to Normal Mode ****/

	fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------\n");
    fprintf(f1,"\n\n                                                    ** END OF REPORT **                                                             \n\f");
	//disp_message(INFO_MESG,"The Generated output file name is : blrrevnu.lis \n");
}

/****************************** O  V  E  R *******************************/   