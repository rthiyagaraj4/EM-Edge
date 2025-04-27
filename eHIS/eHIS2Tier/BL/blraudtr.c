
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
    "T:\\temp\\Bl\\robert\\Proc\\blraudtr\\blraudtr.pc"
};


static unsigned long sqlctx = 2024457813;


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
            void  *sqhstv[27];
   unsigned int   sqhstl[27];
            int   sqhsts[27];
            void  *sqindv[27];
            int   sqinds[27];
   unsigned int   sqharm[27];
   unsigned int   *sqharc[27];
   unsigned short  sqadto[27];
   unsigned short  sqtdso[27];
} sqlstm = {10,27};

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
"select audit_trail_no ,module_id ,added_facility_id ,function_id ,patient_id\
 ,episode_type ,trunc(episode_id) ,trunc(visit_id) ,prv_blng_grp_id ,chg_blng_\
grp_id ,prv_settlement_ind ,chg_settlement_ind ,prv_cust_code ,chg_cust_code ,\
prv_credit_doc_ref_desc ,chg_credit_doc_ref_desc ,prv_credit_doc_ref_date ,chg\
_credit_doc_ref_date ,prv_modified_by_id ,chg_modified_by_id ,prv_modified_dat\
e ,chg_modified_date ,trn_type ,charge_adj_trx_dt_fr ,charge_adj_trx_dt_to ,se\
rv_date_fr ,serv_date_to  from bl_fin_dtls_audit_trail where (((patient_id bet\
ween NVL(:b0,'!!!!!!!!!!!!!!!!!!!!') and NVL(:b1,'~~~~~~~~~~~~~~~~~~~~') and a\
dded_date between TO_DATE(NVL(:b2,'01/01/1000 00:00'),'DD/MM/YYYY HH24:MI') an\
d TO_DATE(NVL(:b3,'01/01/4713 23:59'),'DD/MM/YYYY HH24:MI')) and trn_type=DECO\
DE(:b4,'L',trn_type,:b4)) and module_id='BL')           ";

 static const char *sq0010 = 
"select blng_serv_code ,physician_id ,serv_qty ,trx_doc_ref ,trunc(trx_doc_re\
f_line_num) ,source_doc_ref ,source_doc_ref_line_num ,sum(upd_net_charge_amt) \
 from bl_patient_charges_folio where (((((episode_type=:b0 and patient_id=:b1)\
 and episode_id=:b2) and audit_trail_no=:b3) and audit_trail_no is  not null )\
 and added_facility_id=:b4) group by blng_serv_code,physician_id,serv_qty,trx_\
doc_ref,trx_doc_ref_line_num,source_doc_ref,source_doc_ref_line_num           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,170,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,181,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,187,0,0,0,0,0,1,0,
66,0,0,4,192,0,4,209,0,0,8,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,1,9,0,0,1,9,0,0,
113,0,0,5,91,0,2,238,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
136,0,0,6,0,0,32,247,0,0,0,0,0,1,0,
151,0,0,7,128,0,4,257,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
182,0,0,8,0,0,32,274,0,0,0,0,0,1,0,
197,0,0,9,834,0,9,328,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
236,0,0,11,0,0,32,364,0,0,0,0,0,1,0,
251,0,0,9,0,0,13,406,0,0,27,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,
374,0,0,12,0,0,32,469,0,0,0,0,0,1,0,
389,0,0,10,0,0,13,492,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,
9,0,0,2,4,0,0,2,4,0,0,
436,0,0,13,152,0,4,515,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,4,0,0,
463,0,0,14,0,0,32,527,0,0,0,0,0,1,0,
478,0,0,10,466,0,9,541,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,0,
513,0,0,10,0,0,15,568,0,0,0,0,0,1,0,
528,0,0,9,0,0,15,570,0,0,0,0,0,1,0,
543,0,0,15,350,0,4,586,0,0,9,3,0,1,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,
4,0,0,1,9,0,0,1,4,0,0,1,9,0,0,
594,0,0,16,0,0,32,618,0,0,0,0,0,1,0,
609,0,0,17,274,0,4,634,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
648,0,0,18,511,0,6,650,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
675,0,0,19,0,0,32,684,0,0,0,0,0,1,0,
690,0,0,20,95,0,4,697,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
717,0,0,21,70,0,4,707,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
740,0,0,22,0,0,32,721,0,0,0,0,0,1,0,
755,0,0,23,89,0,4,735,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
782,0,0,24,0,0,32,747,0,0,0,0,0,1,0,
797,0,0,25,90,0,4,763,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
824,0,0,26,183,0,4,772,0,0,7,5,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,
3,0,0,1,9,0,0,
867,0,0,27,166,0,4,785,0,0,6,4,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,
9,0,0,
906,0,0,28,0,0,32,803,0,0,0,0,0,1,0,
921,0,0,29,66,0,4,817,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
944,0,0,30,66,0,4,826,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
967,0,0,31,0,0,32,842,0,0,0,0,0,1,0,
982,0,0,32,0,0,32,872,0,0,0,0,0,1,0,
997,0,0,33,64,0,4,886,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1020,0,0,34,0,0,32,899,0,0,0,0,0,1,0,
1035,0,0,35,64,0,4,913,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1058,0,0,36,0,0,32,925,0,0,0,0,0,1,0,
};


/*************************************************************

Author    :  Harish A   24/12/2002
Name      :  Audit Trail of Financial Details.
Project   :  HMC

*************************************************************/
#include <stdio.h> 
#include <string.h>
#include <math.h>
#include <bl.h>                   
        
#define MAX_LINES 55
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403  
#define VER  "VER : 4.1\n"     
                          
/* EXEC SQL BEGIN DECLARE SECTION; */ 


	/* VARCHAR uid_pwd							[91],
			nd_session_id        			[16],
			nd_pgm_date	    				[20],

			//input parameters through from SY_PROG_PARAM 
			l_fm_trx_date					[30],
			l_to_trx_date					[30],
			l_fm_patient_id					[21],
			l_to_patient_id					[21],
			l_report_option					[30],
			d_facility_id					[10],

			//for audit trail cursor
			l_adt_module_id                 [5],
			l_adt_function_id               [31],
			l_adt_patient_id                [21],
			l_adt_episode_type              [10],
			l_adt_prv_blng_grp_id           [5],
			l_adt_chg_blng_grp_id           [5],
			l_adt_prv_settlement_ind        [5],
			l_adt_chg_settlement_ind        [5],
			l_adt_prv_cust_code             [10],
			l_adt_chg_cust_code             [10],
			l_adt_prv_credit_doc_ref_desc   [32],
			l_adt_chg_credit_doc_ref_desc   [32],
			l_adt_prv_credit_doc_ref_date   [30],
			l_adt_chg_credit_doc_ref_date   [30],
			l_adt_prv_modified_by_id        [32],
			l_adt_chg_modified_by_id        [32],
			l_adt_prv_modified_date         [30],
			l_adt_chg_modified_date         [30],
			l_adt_trn_type					[3],
			l_adt_added_facility_id			[20],
			l_charge_adj_trx_dt_fr          [11],
			l_charge_adj_trx_dt_to          [11],
			l_serv_date_fr                  [11],
			l_serv_date_to                  [11],
			l_adt_audit_trail_no            [20],	
     		

			l_before_blng_grp_desc          [16],
			l_after_blng_grp_desc			[16], 
            l_before_stlmt_ind_desc         [10],
			l_after_stlmt_ind_desc			[10],
			l_before_cust_name              [16],
			l_after_cust_name				[16],

			//for folio record
			l_folio_trx_date				[32],
			l_folio_blng_serv_code			[11],
			l_folio_physician_id			[16],
			l_folio_trx_doc_ref				[25],
			l_folio_source_doc_ref			[25],

			//for previous folio
			l_prev_trx_date					[32],
			l_prev_blng_serv_code			[11],
			l_prev_physician_id				[16],
			l_prev_trx_doc_ref				[25],


			//Temp variables used in the program
			l_folio_physician_name			[20],
			l_blng_serv_desc				[20],
                  d_short_name_full                         [60],
                  mp_pat_short_name                         [61],
			l_patient_name					[61],
			l_patient_name1 				[61],
			l_sex							[10],
			l_function_name					[35],
			l_fin_dtl_added_by_id			[35],
			l_fin_dtl_added_date            [20],
			l_blng_grp_desc                 [31],

			//for header routine
			d_acc_entity_name				[41],
			d_user							[21],
			d_sysdate						[17]; */ 
struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[30]; } l_fm_trx_date;

struct { unsigned short len; unsigned char arr[30]; } l_to_trx_date;

struct { unsigned short len; unsigned char arr[21]; } l_fm_patient_id;

struct { unsigned short len; unsigned char arr[21]; } l_to_patient_id;

struct { unsigned short len; unsigned char arr[30]; } l_report_option;

struct { unsigned short len; unsigned char arr[10]; } d_facility_id;

struct { unsigned short len; unsigned char arr[5]; } l_adt_module_id;

struct { unsigned short len; unsigned char arr[31]; } l_adt_function_id;

struct { unsigned short len; unsigned char arr[21]; } l_adt_patient_id;

struct { unsigned short len; unsigned char arr[10]; } l_adt_episode_type;

struct { unsigned short len; unsigned char arr[5]; } l_adt_prv_blng_grp_id;

struct { unsigned short len; unsigned char arr[5]; } l_adt_chg_blng_grp_id;

struct { unsigned short len; unsigned char arr[5]; } l_adt_prv_settlement_ind;

struct { unsigned short len; unsigned char arr[5]; } l_adt_chg_settlement_ind;

struct { unsigned short len; unsigned char arr[10]; } l_adt_prv_cust_code;

struct { unsigned short len; unsigned char arr[10]; } l_adt_chg_cust_code;

struct { unsigned short len; unsigned char arr[32]; } l_adt_prv_credit_doc_ref_desc;

struct { unsigned short len; unsigned char arr[32]; } l_adt_chg_credit_doc_ref_desc;

struct { unsigned short len; unsigned char arr[30]; } l_adt_prv_credit_doc_ref_date;

struct { unsigned short len; unsigned char arr[30]; } l_adt_chg_credit_doc_ref_date;

struct { unsigned short len; unsigned char arr[32]; } l_adt_prv_modified_by_id;

struct { unsigned short len; unsigned char arr[32]; } l_adt_chg_modified_by_id;

struct { unsigned short len; unsigned char arr[30]; } l_adt_prv_modified_date;

struct { unsigned short len; unsigned char arr[30]; } l_adt_chg_modified_date;

struct { unsigned short len; unsigned char arr[3]; } l_adt_trn_type;

struct { unsigned short len; unsigned char arr[20]; } l_adt_added_facility_id;

struct { unsigned short len; unsigned char arr[11]; } l_charge_adj_trx_dt_fr;

struct { unsigned short len; unsigned char arr[11]; } l_charge_adj_trx_dt_to;

struct { unsigned short len; unsigned char arr[11]; } l_serv_date_fr;

struct { unsigned short len; unsigned char arr[11]; } l_serv_date_to;

struct { unsigned short len; unsigned char arr[20]; } l_adt_audit_trail_no;

struct { unsigned short len; unsigned char arr[16]; } l_before_blng_grp_desc;

struct { unsigned short len; unsigned char arr[16]; } l_after_blng_grp_desc;

struct { unsigned short len; unsigned char arr[10]; } l_before_stlmt_ind_desc;

struct { unsigned short len; unsigned char arr[10]; } l_after_stlmt_ind_desc;

struct { unsigned short len; unsigned char arr[16]; } l_before_cust_name;

struct { unsigned short len; unsigned char arr[16]; } l_after_cust_name;

struct { unsigned short len; unsigned char arr[32]; } l_folio_trx_date;

struct { unsigned short len; unsigned char arr[11]; } l_folio_blng_serv_code;

struct { unsigned short len; unsigned char arr[16]; } l_folio_physician_id;

struct { unsigned short len; unsigned char arr[25]; } l_folio_trx_doc_ref;

struct { unsigned short len; unsigned char arr[25]; } l_folio_source_doc_ref;

struct { unsigned short len; unsigned char arr[32]; } l_prev_trx_date;

struct { unsigned short len; unsigned char arr[11]; } l_prev_blng_serv_code;

struct { unsigned short len; unsigned char arr[16]; } l_prev_physician_id;

struct { unsigned short len; unsigned char arr[25]; } l_prev_trx_doc_ref;

struct { unsigned short len; unsigned char arr[20]; } l_folio_physician_name;

struct { unsigned short len; unsigned char arr[20]; } l_blng_serv_desc;

struct { unsigned short len; unsigned char arr[60]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } mp_pat_short_name;

struct { unsigned short len; unsigned char arr[61]; } l_patient_name;

struct { unsigned short len; unsigned char arr[61]; } l_patient_name1;

struct { unsigned short len; unsigned char arr[10]; } l_sex;

struct { unsigned short len; unsigned char arr[35]; } l_function_name;

struct { unsigned short len; unsigned char arr[35]; } l_fin_dtl_added_by_id;

struct { unsigned short len; unsigned char arr[20]; } l_fin_dtl_added_date;

struct { unsigned short len; unsigned char arr[31]; } l_blng_grp_desc;

struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;


	double	l_folio_trx_doc_ref_line_num	,
			l_folio_upd_net_charge_amt		,
 			l_folio_serv_qty				,
			l_folio_source_doc_ref_line_num	,
			l_prev_trx_doc_ref_line_num		,
			l_prev_upd_net_charge_amt		,
			g_prev_upd_net_charge_amt       ,
			g_folio_upd_net_charge_amt      ,
			g_diff_upd_net_amt				,
			l_prev_serv_qty					,
			l_total_org_amt					,
			l_total_new_amt					,
			l_total_diff_amt				,
			l_diff_upd_net_amt				,
			l_diff_serv_qty					;

	char	filename[10];
	char    aMesg[300];
	int     l_flag=0,
			l_adt_episode_id                ,
			l_adt_visit_id                  ,
	        l_patient_age;
	
/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/blraudtr.c-arc   1.0   Apr 19 2007 17:05:26   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/blraudtr.c-arc   1.0   Apr 19 2007 17:05:26   vcm_th  $ sqlda.h 
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

int  line_no=0, 
	 page_no=0;

void proc_main(argc, argv)
int argc;
char *argv[];
{
	void	get_params(),
  			get_header_dtls(),
  			do_report();
 
	if(argc != 5)
	{
		disp_message(ERR_MESG,"Usage BLRAUDTR uid/passwd session_id pgm_date");
		proc_exit();
	}

    strcpy(uid_pwd.arr,argv[1]);
    uid_pwd.len = strlen(uid_pwd.arr);

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,argv[2]);
    
    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);

    strcpy(g_pgm_id,"BLRAUDTR");
    strcpy(g_pgm_date,argv[3]);

	strcpy(filename,WORKING_DIR);
	strcat(filename,"blraudtr.lis");

	if((f1 = fopen(filename, "w")) == NULL) 
	{
		disp_message(ERR_MESG,".... Error opening output file ....");
		proc_exit();
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
 if (sqlca.sqlcode < 0) goto err_exit;
}

  

	set_meduser_role();

	get_params();
	get_header_dtls();
	declare_cursor();
	do_report();
	end_prog_msg();
	fclose(f1);

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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	return;
   
	err_exit:
	   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 4;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )51;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   disp_message(ERR_MESG,"Oracle error at main() occured....");
	   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
	   proc_exit();
}


// get the parameters from the SY_PROG_PARM table and
// delete the record after reading it.
void get_params()
{
  

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	l_fm_trx_date.arr[0]		='\0';		
	l_to_trx_date.arr[0]		='\0';
	l_fm_patient_id.arr[0]		='\0';
	l_to_patient_id.arr[0]		='\0';
	l_report_option.arr[0]		='\0';
	d_facility_id.arr[0]		='\0';

	/* EXEC SQL SELECT PARAM1,
			 	    PARAM2,
				    PARAM3,
				    PARAM4,
				    PARAM5,
				    operating_facility_id
            INTO    :l_fm_trx_date,
					:l_to_trx_date,
					:l_fm_patient_id,
					:l_to_patient_id,
					:l_report_option,
					:d_facility_id
			   FROM SY_PROG_PARAM
			  WHERE PGM_ID		= 'BLRAUDTR'
		        AND	SESSION_ID	=  TO_NUMBER(:nd_session_id)
		        AND PGM_DATE	=  :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,operating_fac\
ility_id into :b0,:b1,:b2,:b3,:b4,:b5  from SY_PROG_PARAM where ((PGM_ID='BLRA\
UDTR' and SESSION_ID=TO_NUMBER(:b6)) and PGM_DATE=:b7)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )66;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_fm_trx_date;
 sqlstm.sqhstl[0] = (unsigned int  )32;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_to_trx_date;
 sqlstm.sqhstl[1] = (unsigned int  )32;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_fm_patient_id;
 sqlstm.sqhstl[2] = (unsigned int  )23;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_to_patient_id;
 sqlstm.sqhstl[3] = (unsigned int  )23;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_report_option;
 sqlstm.sqhstl[4] = (unsigned int  )32;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[5] = (unsigned int  )12;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[6] = (unsigned int  )18;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[7] = (unsigned int  )22;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	l_fm_trx_date.arr[l_fm_trx_date.len]		='\0';		
	l_to_trx_date.arr[l_to_trx_date.len]		='\0';
	l_fm_patient_id.arr[l_fm_patient_id.len]	='\0';
	l_to_patient_id.arr[l_to_patient_id.len]	='\0';
	l_report_option.arr[l_report_option.len]	='\0';
	d_facility_id.arr[d_facility_id.len]		='\0';

	strcpy(g_facility_id, d_facility_id.arr);

    
    //delete the parameter record
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DELETE SY_PROG_PARAM
	 		  WHERE PGM_ID		= 'BLRAUDTR'
	            AND SESSION_ID	= :nd_session_id
		        AND PGM_DATE	= :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLRAUDTR' and\
 SESSION_ID=:b0) and PGM_DATE=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )113;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


	return;

  err_exit:

	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )136;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ERR_MESG,"Oracle error at get_params() occured....");
	disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
	proc_exit();
}
 
//get the header details
void get_header_dtls()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT ACCOUNTING_NAME,
				    USER,
				    TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
		      INTO :d_acc_entity_name,
			  	   :d_user,
				   :d_sysdate
              FROM SY_ACC_ENTITY
			 WHERE acc_entity_id = :d_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY\
 HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY where acc_entity_id=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )151;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_user;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_sysdate;
    sqlstm.sqhstl[2] = (unsigned int  )19;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_facility_id;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len]                       = '\0';
	d_sysdate.arr[d_sysdate.len]                 = '\0';

	return;

	err_exit:
	   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )182;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   disp_message(ERR_MESG,"Oracle error at get_header_dtls() occured....");
	   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
	   proc_exit();
}
 
declare_cursor()
{
/*	sprintf(aMesg,"Fm PatID  %s  To PatID  %s  ",l_fm_patient_id.arr,l_to_patient_id.arr);
	disp_message(ERR_MESG,aMesg);
*/
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	
	/* EXEC SQL DECLARE	audit_trail_cur
	          CURSOR	
			     FOR	
			  SELECT	audit_trail_no                 ,
						module_id                      ,
						added_facility_id			   ,	
						function_id                    ,
						patient_id                     ,
						episode_type                   ,
						trunc(episode_id)              ,
						trunc(visit_id)                ,
						prv_blng_grp_id                ,
						chg_blng_grp_id                ,
						prv_settlement_ind             ,
						chg_settlement_ind             ,
						prv_cust_code                  ,
						chg_cust_code                  ,
						prv_credit_doc_ref_desc        ,
						chg_credit_doc_ref_desc        ,
						prv_credit_doc_ref_date        ,
						chg_credit_doc_ref_date        ,
						prv_modified_by_id             ,
						chg_modified_by_id             ,
						prv_modified_date              ,
						chg_modified_date              ,
						trn_type                       ,
						charge_adj_trx_dt_fr           ,
						charge_adj_trx_dt_to           ,
						serv_date_fr                   ,
						serv_date_to                   
				FROM	bl_fin_dtls_audit_trail
			   WHERE	patient_id 
			 BETWEEN	NVL(:l_fm_patient_id,'!!!!!!!!!!!!!!!!!!!!')
			     AND	NVL(:l_to_patient_id,'~~~~~~~~~~~~~~~~~~~~')
				 AND	added_date 
			 BETWEEN	TO_DATE(NVL(:l_fm_trx_date,'01/01/1000 00:00'),'DD/MM/YYYY HH24:MI')
			     AND	TO_DATE(NVL(:l_to_trx_date,'01/01/4713 23:59'),'DD/MM/YYYY HH24:MI')
				 AND    trn_type  = DECODE(:l_report_option,'L',trn_type,:l_report_option)
				 AND	module_id = 'BL'; */ 
   
 

	/* EXEC SQL OPEN audit_trail_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0009;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )197;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_fm_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_to_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_fm_trx_date;
 sqlstm.sqhstl[2] = (unsigned int  )32;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_to_trx_date;
 sqlstm.sqhstl[3] = (unsigned int  )32;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_report_option;
 sqlstm.sqhstl[4] = (unsigned int  )32;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_report_option;
 sqlstm.sqhstl[5] = (unsigned int  )32;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}

  
	

	/* EXEC SQL DECLARE	patient_charges_folio_cur
	          CURSOR	
			     FOR	
			  SELECT	blng_serv_code,
						physician_id,
						serv_qty,
						trx_doc_ref,
						trunc(trx_doc_ref_line_num),
						source_doc_ref,
						source_doc_ref_line_num,
						sum(upd_net_charge_amt)
			    FROM	bl_patient_charges_folio
			   WHERE	episode_type			= :l_adt_episode_type
				 AND	patient_id				= :l_adt_patient_id
				 AND	episode_id				= :l_adt_episode_id
				 AND	audit_trail_no			= :l_adt_audit_trail_no
				 AND    audit_trail_no			IS NOT NULL
				 AND    added_facility_id       = :l_adt_added_facility_id
			   GROUP    
			      BY	blng_serv_code,
						physician_id,
						serv_qty,
						trx_doc_ref,
						trx_doc_ref_line_num,
						source_doc_ref,
						source_doc_ref_line_num; */ 


	return;

  
	err_exit:
	
		   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )236;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
		   disp_message(ERR_MESG,"Oracle error at declare_cursor() occured....");
		   proc_exit();
}

int fetch_audit_trail_cur()
{
/*	
	sprintf(aMesg,"Fm Dt  %s  To Dt  %s  Rep Opt  %s",l_fm_trx_date.arr,l_to_trx_date.arr,l_report_option.arr);
	disp_message(ERR_MESG,aMesg);
*/

    
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	l_adt_module_id.arr[0]                      ='\0';
	l_adt_function_id.arr[0]                    ='\0';
	l_adt_patient_id.arr[0]                     ='\0';
	l_adt_episode_type.arr[0]                   ='\0';
	l_adt_prv_blng_grp_id.arr[0]                ='\0';
	l_adt_chg_blng_grp_id.arr[0]                ='\0';
	l_adt_prv_settlement_ind.arr[0]             ='\0';
	l_adt_chg_settlement_ind.arr[0]             ='\0';
	l_adt_prv_cust_code.arr[0]                  ='\0';
	l_adt_chg_cust_code.arr[0]                  ='\0';
	l_adt_prv_credit_doc_ref_desc.arr[0]        ='\0';	
	l_adt_chg_credit_doc_ref_desc.arr[0]        ='\0';
	l_adt_prv_credit_doc_ref_date.arr[0]        ='\0';
	l_adt_chg_credit_doc_ref_date.arr[0]        ='\0';
	l_adt_prv_modified_by_id.arr[0]             ='\0';
	l_adt_chg_modified_by_id.arr[0]             ='\0';
	l_adt_prv_modified_date.arr[0]              ='\0';
	l_adt_chg_modified_date.arr[0]              ='\0';
	l_adt_added_facility_id.arr[0]				='\0';
	l_adt_trn_type.arr[0]						='\0';
	l_charge_adj_trx_dt_fr.arr[0]               ='\0';
	l_charge_adj_trx_dt_to.arr[0]               ='\0';
	l_serv_date_fr.arr[0]						='\0';
	l_serv_date_to.arr[0]						='\0';
	l_adt_audit_trail_no.arr[0]					='\0';

	/* EXEC SQL FETCH	audit_trail_cur
			  INTO	l_adt_audit_trail_no                 ,
					l_adt_module_id                      ,
					l_adt_added_facility_id				 ,
					l_adt_function_id                    ,
					l_adt_patient_id                     ,
					l_adt_episode_type                   ,
					l_adt_episode_id                     ,
					l_adt_visit_id                       ,
					l_adt_prv_blng_grp_id                ,
					l_adt_chg_blng_grp_id                ,
					l_adt_prv_settlement_ind             ,
					l_adt_chg_settlement_ind             ,
					l_adt_prv_cust_code                  ,
					l_adt_chg_cust_code                  ,
					l_adt_prv_credit_doc_ref_desc        ,
					l_adt_chg_credit_doc_ref_desc        ,
					l_adt_prv_credit_doc_ref_date        ,
					l_adt_chg_credit_doc_ref_date        ,
					l_adt_prv_modified_by_id             ,
					l_adt_chg_modified_by_id             ,
					l_adt_prv_modified_date              ,
					l_adt_chg_modified_date              ,
					l_adt_trn_type						 ,
					l_charge_adj_trx_dt_fr               ,
					l_charge_adj_trx_dt_to               ,
					l_serv_date_fr						 ,
					l_serv_date_to			; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )251;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_adt_audit_trail_no;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_adt_module_id;
 sqlstm.sqhstl[1] = (unsigned int  )7;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_adt_added_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )22;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_adt_function_id;
 sqlstm.sqhstl[3] = (unsigned int  )33;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_adt_patient_id;
 sqlstm.sqhstl[4] = (unsigned int  )23;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_adt_episode_type;
 sqlstm.sqhstl[5] = (unsigned int  )12;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_adt_episode_id;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_adt_visit_id;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_adt_prv_blng_grp_id;
 sqlstm.sqhstl[8] = (unsigned int  )7;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_adt_chg_blng_grp_id;
 sqlstm.sqhstl[9] = (unsigned int  )7;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_adt_prv_settlement_ind;
 sqlstm.sqhstl[10] = (unsigned int  )7;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&l_adt_chg_settlement_ind;
 sqlstm.sqhstl[11] = (unsigned int  )7;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&l_adt_prv_cust_code;
 sqlstm.sqhstl[12] = (unsigned int  )12;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&l_adt_chg_cust_code;
 sqlstm.sqhstl[13] = (unsigned int  )12;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&l_adt_prv_credit_doc_ref_desc;
 sqlstm.sqhstl[14] = (unsigned int  )34;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&l_adt_chg_credit_doc_ref_desc;
 sqlstm.sqhstl[15] = (unsigned int  )34;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&l_adt_prv_credit_doc_ref_date;
 sqlstm.sqhstl[16] = (unsigned int  )32;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&l_adt_chg_credit_doc_ref_date;
 sqlstm.sqhstl[17] = (unsigned int  )32;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&l_adt_prv_modified_by_id;
 sqlstm.sqhstl[18] = (unsigned int  )34;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&l_adt_chg_modified_by_id;
 sqlstm.sqhstl[19] = (unsigned int  )34;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&l_adt_prv_modified_date;
 sqlstm.sqhstl[20] = (unsigned int  )32;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&l_adt_chg_modified_date;
 sqlstm.sqhstl[21] = (unsigned int  )32;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&l_adt_trn_type;
 sqlstm.sqhstl[22] = (unsigned int  )5;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&l_charge_adj_trx_dt_fr;
 sqlstm.sqhstl[23] = (unsigned int  )13;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&l_charge_adj_trx_dt_to;
 sqlstm.sqhstl[24] = (unsigned int  )13;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&l_serv_date_fr;
 sqlstm.sqhstl[25] = (unsigned int  )13;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&l_serv_date_to;
 sqlstm.sqhstl[26] = (unsigned int  )13;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
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



	
	if (NODATAFOUND)
		return 0;

	l_adt_module_id.arr[l_adt_module_id.len]								='\0';
	l_adt_function_id.arr[l_adt_function_id.len]							='\0';
	l_adt_added_facility_id.arr[l_adt_added_facility_id.len]				='\0';
	l_adt_patient_id.arr[l_adt_patient_id.len]								='\0';
	l_adt_episode_type.arr[l_adt_episode_type.len]							='\0';
	l_adt_prv_blng_grp_id.arr[l_adt_prv_blng_grp_id.len]					='\0';
	l_adt_chg_blng_grp_id.arr[l_adt_chg_blng_grp_id.len]					='\0';
	l_adt_prv_settlement_ind.arr[l_adt_prv_settlement_ind.len]				='\0';
	l_adt_chg_settlement_ind.arr[l_adt_chg_settlement_ind.len]				='\0';
	l_adt_prv_cust_code.arr[l_adt_prv_cust_code.len]						='\0';
	l_adt_chg_cust_code.arr[l_adt_chg_cust_code.len]						='\0';
	l_adt_prv_credit_doc_ref_desc.arr[l_adt_prv_credit_doc_ref_desc.len]    ='\0';	
	l_adt_chg_credit_doc_ref_desc.arr[l_adt_chg_credit_doc_ref_desc.len]    ='\0';
	l_adt_prv_credit_doc_ref_date.arr[l_adt_prv_credit_doc_ref_date.len]    ='\0';
	l_adt_chg_credit_doc_ref_date.arr[l_adt_chg_credit_doc_ref_date.len]    ='\0';
	l_adt_prv_modified_by_id.arr[l_adt_prv_modified_by_id.len]				='\0';
	l_adt_chg_modified_by_id.arr[l_adt_chg_modified_by_id.len]				='\0';
	l_adt_prv_modified_date.arr[l_adt_prv_modified_date.len]				='\0';
	l_adt_chg_modified_date.arr[l_adt_chg_modified_date.len]				='\0';
	l_adt_trn_type.arr[l_adt_trn_type.len]									='\0';
	l_charge_adj_trx_dt_fr.arr[l_charge_adj_trx_dt_fr.len]					='\0';
	l_charge_adj_trx_dt_to.arr[l_charge_adj_trx_dt_to.len]					='\0';
	l_serv_date_fr.arr[l_serv_date_fr.len]									='\0';
	l_serv_date_to.arr[l_serv_date_to.len]									='\0';
	l_adt_audit_trail_no.arr[l_adt_audit_trail_no.len]						='\0';
    return 1;


	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )374;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at fetch_audit_trail_cur() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}


int fetch_pat_charges_folio_cur()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	l_folio_trx_date.arr[0]					='\0';	
	l_folio_blng_serv_code.arr[0]			='\0';
	l_folio_physician_id.arr[0]				='\0';
	l_folio_trx_doc_ref.arr[0]				='\0';
	l_folio_source_doc_ref.arr[0]			='\0';

	/*	sprintf(aMesg,"ET %s  EId   %f  PId   %s   AN  %f",
			   l_adt_episode_type.arr,l_adt_episode_id,l_adt_patient_id.arr,l_adt_audit_trail_no);
		disp_message(ERR_MESG,aMesg);
	*/

	/* EXEC SQL FETCH	patient_charges_folio_cur
			  INTO	:l_folio_blng_serv_code			,
					:l_folio_physician_id			,
					:l_folio_serv_qty				,
					:l_folio_trx_doc_ref			,
					:l_folio_trx_doc_ref_line_num	,
					:l_folio_source_doc_ref			,
					:l_folio_source_doc_ref_line_num,
					:l_folio_upd_net_charge_amt		; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )389;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_folio_blng_serv_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_folio_physician_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_folio_serv_qty;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_folio_trx_doc_ref;
 sqlstm.sqhstl[3] = (unsigned int  )27;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_folio_trx_doc_ref_line_num;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_folio_source_doc_ref;
 sqlstm.sqhstl[5] = (unsigned int  )27;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_folio_source_doc_ref_line_num;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_folio_upd_net_charge_amt;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


	
	if (NODATAFOUND)
	{	
		return 0;
		l_flag = 0;
	}
    else
	    l_flag =1;
	
	l_folio_blng_serv_code.arr[l_folio_blng_serv_code.len]					='\0';
	l_folio_physician_id.arr[l_folio_physician_id.len]						='\0';
	l_folio_trx_doc_ref.arr[l_folio_trx_doc_ref.len]						='\0';
	l_folio_source_doc_ref.arr[l_folio_source_doc_ref.len]					='\0';
    
	/* EXEC SQL SELECT TO_CHAR(MIN(finalized_date),'DD/MM/RRRR HH24:MI:SS')
	           INTO :l_folio_trx_date
			   FROM bl_patient_charges_folio
			  WHERE trx_doc_ref				= :l_folio_trx_doc_ref
				AND	trx_doc_ref_line_num	= :l_folio_trx_doc_ref_line_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select TO_CHAR(min(finalized_date),'DD/MM/RRRR HH24:MI:SS') \
into :b0  from bl_patient_charges_folio where (trx_doc_ref=:b1 and trx_doc_ref\
_line_num=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )436;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_folio_trx_date;
 sqlstm.sqhstl[0] = (unsigned int  )34;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_folio_trx_doc_ref;
 sqlstm.sqhstl[1] = (unsigned int  )27;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_folio_trx_doc_ref_line_num;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


	
	l_folio_trx_date.arr[l_folio_trx_date.len]								='\0';	
  
    return 1;
	
	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )463;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at fetch_pat_charges_folio_cur() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}

void do_report()
{

	/*	print_page_title();*/
	while(fetch_audit_trail_cur())
	{

		/* EXEC SQL OPEN patient_charges_folio_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0010;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )478;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_adt_episode_type;
  sqlstm.sqhstl[0] = (unsigned int  )12;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_adt_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_adt_episode_id;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_adt_audit_trail_no;
  sqlstm.sqhstl[3] = (unsigned int  )22;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_adt_added_facility_id;
  sqlstm.sqhstl[4] = (unsigned int  )22;
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


		
		print_page_title();
			
		print_fin_detail_page();

		check_page_end(5);

		print_rec_hdr();

		while(fetch_pat_charges_folio_cur())
		{
			/*	
			sprintf(aMesg,"Tdr  %s   Tdrl  %f",l_folio_trx_doc_ref.arr,l_folio_trx_doc_ref_line_num);
			disp_message(ERR_MESG,aMesg);
			*/
        
			get_source_folio_det();
			get_desc_diff();
			check_page_end(3);
			print_rec();
			check_page_end(4);
		}
        if(l_flag)
		  print_total();

        l_flag = 1;		
		/* EXEC SQL CLOSE patient_charges_folio_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )513;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	}
	/* EXEC SQL CLOSE audit_trail_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )528;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	 print_end_of_rep();	    
}  

get_source_folio_det()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	
	l_prev_trx_date.arr[0]			='\0';			
	l_prev_blng_serv_code.arr[0]	='\0';
	l_prev_physician_id.arr[0]		='\0';	
	l_prev_trx_doc_ref.arr[0]		='\0';
	
	/*	sprintf(aMesg,"Sdr   %s    Sdln  %f",l_folio_source_doc_ref.arr,l_folio_source_doc_ref_line_num);
		disp_message(ERR_MESG,aMesg);
	*/
	/* EXEC SQL SELECT blng_serv_code,
					physician_id,
					serv_qty,
					trx_doc_ref,
					trx_doc_ref_line_num,
					sum(upd_net_charge_amt)
			  INTO  :l_prev_blng_serv_code,
					:l_prev_physician_id,
					:l_prev_serv_qty,
					:l_prev_trx_doc_ref,
					:l_prev_trx_doc_ref_line_num,
					:l_prev_upd_net_charge_amt
			  FROM	bl_patient_charges_folio
			 WHERE	trx_doc_ref 		 = ltrim(rtrim(:l_folio_source_doc_ref))
			   AND  trx_doc_ref_line_num = ROUND(:l_folio_source_doc_ref_line_num)
			   AND	operating_facility_id= :l_adt_added_facility_id
			 GROUP
				BY  blng_serv_code,
					physician_id,
					serv_qty,
					trx_doc_ref,
					trx_doc_ref_line_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select blng_serv_code ,physician_id ,serv_qty ,trx_doc_ref ,\
trx_doc_ref_line_num ,sum(upd_net_charge_amt) into :b0,:b1,:b2,:b3,:b4,:b5  fr\
om bl_patient_charges_folio where ((trx_doc_ref=ltrim(rtrim(:b6)) and trx_doc_\
ref_line_num=ROUND(:b7)) and operating_facility_id=:b8) group by blng_serv_cod\
e,physician_id,serv_qty,trx_doc_ref,trx_doc_ref_line_num";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )543;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_prev_blng_serv_code;
 sqlstm.sqhstl[0] = (unsigned int  )13;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_prev_physician_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_prev_serv_qty;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_prev_trx_doc_ref;
 sqlstm.sqhstl[3] = (unsigned int  )27;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_prev_trx_doc_ref_line_num;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_prev_upd_net_charge_amt;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_folio_source_doc_ref;
 sqlstm.sqhstl[6] = (unsigned int  )27;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_folio_source_doc_ref_line_num;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_adt_added_facility_id;
 sqlstm.sqhstl[8] = (unsigned int  )22;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	l_prev_trx_date.arr[l_prev_trx_date.len]			='\0';			
	l_prev_blng_serv_code.arr[l_prev_blng_serv_code.len]='\0';
	l_prev_physician_id.arr[l_prev_physician_id.len]	='\0';	
	l_prev_trx_doc_ref.arr[l_prev_trx_doc_ref.len]		='\0';

	return;

	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )594;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at get_source_folio_det() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}
      
get_patient_details()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 
	
	
	l_patient_name.arr[0]='\0';
    l_patient_name1.arr[0]='\0';
	l_patient_age= 0;
	l_sex.arr[0]='\0';

	/* EXEC SQL SELECT substr(short_name,1,30),
					decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1,
					round(((sysdate - date_of_birth)/365),0),
					decode(sex,'M','Male','F','Female','Both'),short_name
			   INTO :l_patient_name,
					:l_patient_name1,
					:l_patient_age,
					:l_sex,
					:d_short_name_full
			   FROM mp_patient_mast 
			  WHERE patient_id = :l_adt_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select substr(short_name,1,30) ,decode(substr(short_name,31,\
60),null ,' ',substr(short_name,31,60)) shortname1 ,round(((sysdate-date_of_bi\
rth)/365),0) ,decode(sex,'M','Male','F','Female','Both') ,short_name into :b0,\
:b1,:b2,:b3,:b4  from mp_patient_mast where patient_id=:b5";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )609;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_patient_name;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_patient_name1;
 sqlstm.sqhstl[1] = (unsigned int  )63;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_patient_age;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_sex;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_short_name_full;
 sqlstm.sqhstl[4] = (unsigned int  )62;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_adt_patient_id;
 sqlstm.sqhstl[5] = (unsigned int  )23;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	l_patient_name1.arr[l_patient_name1.len] = '\0';
	l_patient_name.arr[l_patient_name.len] = '\0';
    d_short_name_full.arr[d_short_name_full.len]  ='\0';

/* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :l_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :l_patient_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :l_patient_name1    := :l_patient_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 27;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ; \
BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str2\
 ) ; IF str2 IS NOT NULL THEN :l_patient_name := str2 ; END IF ; blcommon . sp\
lit_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS NOT\
 NULL THEN :l_patient_name1 := str2 ; END IF ; blcommon . split_words ( :d_sho\
rt_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :l_pati\
ent_name1 := :l_patient_name1 || str2 ; end if ; END ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )648;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
sqlstm.sqhstl[0] = (unsigned int  )62;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&l_patient_name;
sqlstm.sqhstl[1] = (unsigned int  )63;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&l_patient_name1;
sqlstm.sqhstl[2] = (unsigned int  )63;
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
if (sqlca.sqlcode < 0) goto err_exit;
}


       l_patient_name.arr[l_patient_name.len]  = '\0';
       l_patient_name1.arr[l_patient_name1.len]  = '\0';

	return;

	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )675;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at get_patient_details() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}
     
get_desc_diff()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	l_folio_physician_name.arr[0] = '\0' ;

	/* EXEC SQL SELECT short_name
	           INTO :l_folio_physician_name
			   FROM sy_physician_mast
			  WHERE physician_id = :l_folio_physician_id
			    AND facility_id  = :d_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_name into :b0  from sy_physician_mast where (ph\
ysician_id=:b1 and facility_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )690;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_folio_physician_name;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_folio_physician_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )12;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	l_folio_physician_name.arr[l_folio_physician_name.len] = '\0';

	l_blng_serv_desc.arr[0] = '\0';

	/* EXEC SQL SELECT short_desc
	           INTO :l_blng_serv_desc
	           FROM bl_blng_serv
              WHERE blng_serv_code = :l_folio_blng_serv_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select short_desc into :b0  from bl_blng_serv where blng_ser\
v_code=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )717;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_blng_serv_desc;
 sqlstm.sqhstl[0] = (unsigned int  )22;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_folio_blng_serv_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
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



	l_blng_serv_desc.arr[l_blng_serv_desc.len] = '\0';

	l_diff_upd_net_amt=(l_folio_upd_net_charge_amt-l_prev_upd_net_charge_amt);
	l_diff_serv_qty=(l_folio_serv_qty-l_prev_serv_qty);

	return;
	
	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )740;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at get_desc_diff() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}


get_function_name()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 
	

	l_function_name.arr[0]='\0';
	
	/* EXEC SQL SELECT function_name
			   INTO :l_function_name
			   FROM sm_function
			  WHERE function_id = :l_adt_function_id
			    AND module_id   = :l_adt_module_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select function_name into :b0  from sm_function where (funct\
ion_id=:b1 and module_id=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )755;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_function_name;
 sqlstm.sqhstl[0] = (unsigned int  )37;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_adt_function_id;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_adt_module_id;
 sqlstm.sqhstl[2] = (unsigned int  )7;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	l_function_name.arr[l_function_name.len]='\0';

	return;
	
	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )782;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at get_function_name() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}

get_fin_dtls_added_by() 
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 
	

	l_fin_dtl_added_by_id.arr[0] = '\0';
	l_fin_dtl_added_date.arr[0] = '\0';

	if(strcmp(l_adt_trn_type.arr,"P")==0)
	{
		/* EXEC SQL SELECT added_by_id,
		                added_date
			       INTO :l_fin_dtl_added_by_id,
				        :l_fin_dtl_added_date
				   FROM bl_patient_fin_dtls
				  WHERE patient_id = :l_adt_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select added_by_id ,added_date into :b0,:b1  from bl_patien\
t_fin_dtls where patient_id=:b2";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )797;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_fin_dtl_added_by_id;
  sqlstm.sqhstl[0] = (unsigned int  )37;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_fin_dtl_added_date;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_adt_patient_id;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


	}
	else if(strcmp(l_adt_trn_type.arr,"O")==0 || strcmp(l_adt_trn_type.arr,"E")==0 ) 
	{
		/* EXEC SQL SELECT added_by_id,
		                added_date
			       INTO :l_fin_dtl_added_by_id,
				        :l_fin_dtl_added_date
				   FROM bl_visit_fin_dtls
				  WHERE operating_facility_id = :l_adt_added_facility_id
				    AND episode_type = :l_adt_episode_type
					AND	episode_id = :l_adt_episode_id
					AND visit_id   = :l_adt_visit_id
				    AND patient_id = :l_adt_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select added_by_id ,added_date into :b0,:b1  from bl_visit_\
fin_dtls where ((((operating_facility_id=:b2 and episode_type=:b3) and episode\
_id=:b4) and visit_id=:b5) and patient_id=:b6)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )824;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_fin_dtl_added_by_id;
  sqlstm.sqhstl[0] = (unsigned int  )37;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_fin_dtl_added_date;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_adt_added_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )22;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_adt_episode_type;
  sqlstm.sqhstl[3] = (unsigned int  )12;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_adt_episode_id;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_adt_visit_id;
  sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&l_adt_patient_id;
  sqlstm.sqhstl[6] = (unsigned int  )23;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


	}
	else if(strcmp(l_adt_trn_type.arr,"I")==0 || strcmp(l_adt_trn_type.arr,"D")==0 ) 
	{
		/* EXEC SQL SELECT added_by_id,
						added_date
			       INTO :l_fin_dtl_added_by_id,
						:l_fin_dtl_added_date
				   FROM bl_episode_fin_dtls
				  WHERE operating_facility_id = :l_adt_added_facility_id
				    AND episode_type = :l_adt_episode_type
					AND	episode_id = :l_adt_episode_id
				    AND patient_id = :l_adt_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select added_by_id ,added_date into :b0,:b1  from bl_episod\
e_fin_dtls where (((operating_facility_id=:b2 and episode_type=:b3) and episod\
e_id=:b4) and patient_id=:b5)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )867;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_fin_dtl_added_by_id;
  sqlstm.sqhstl[0] = (unsigned int  )37;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_fin_dtl_added_date;
  sqlstm.sqhstl[1] = (unsigned int  )22;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_adt_added_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )22;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_adt_episode_type;
  sqlstm.sqhstl[3] = (unsigned int  )12;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_adt_episode_id;
  sqlstm.sqhstl[4] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_adt_patient_id;
  sqlstm.sqhstl[5] = (unsigned int  )23;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


	}

	l_fin_dtl_added_by_id.arr[l_fin_dtl_added_by_id.len]	= '\0';
	l_fin_dtl_added_date.arr[l_fin_dtl_added_date.len]		= '\0';

	return;
	
	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )906;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at get_function_name() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}

int get_blng_grp_desc()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 
	
	
	l_before_blng_grp_desc.arr[0]='\0';
	l_after_blng_grp_desc.arr[0]='\0';

	/* EXEC SQL SELECT SHORT_DESC 
			 INTO   :l_before_blng_grp_desc
			 FROM BL_BLNG_GRP
			 WHERE BLNG_GRP_ID = :l_adt_prv_blng_grp_id ; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_DESC into :b0  from BL_BLNG_GRP where BLNG_GRP_\
ID=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )921;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_before_blng_grp_desc;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_adt_prv_blng_grp_id;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



    if (NODATAFOUND)
		return 0;


	/* EXEC SQL SELECT SHORT_DESC 
			 INTO   :l_after_blng_grp_desc
			 FROM BL_BLNG_GRP
			 WHERE BLNG_GRP_ID = :l_adt_chg_blng_grp_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_DESC into :b0  from BL_BLNG_GRP where BLNG_GRP_\
ID=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )944;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_after_blng_grp_desc;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_adt_chg_blng_grp_id;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	if (NODATAFOUND)
		return 0;


	l_before_blng_grp_desc.arr[l_before_blng_grp_desc.len]='\0';
	l_after_blng_grp_desc.arr[l_after_blng_grp_desc.len]='\0';

	return;

	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )967;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at blng_grp_desc() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}


get_stlmnt_ind_desc()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 
	
	
	l_before_stlmt_ind_desc.arr[0] = '\0'; 
	l_after_stlmt_ind_desc.arr[0]='\0';

	if (strcmp(l_adt_prv_settlement_ind.arr,"R") == 0)
	   strcpy(l_before_stlmt_ind_desc.arr, "Credit");
    else
	   strcpy(l_before_stlmt_ind_desc.arr, "Cash");

	if (strcmp(l_adt_chg_settlement_ind.arr,"R") == 0)
	   strcpy(l_after_stlmt_ind_desc.arr, "Credit");
    else
	   strcpy(l_after_stlmt_ind_desc.arr, "Cash");


	return;

	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )982;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at stlmnt_ind_desc() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}


int get_customer_name()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 
	
	
	l_before_cust_name.arr[0] = '\0'; 

	/* EXEC SQL SELECT SHORT_NAME
			 INTO   :l_before_cust_name
			 FROM   AR_CUSTOMER
			 WHERE  CUST_CODE =:l_adt_prv_cust_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_NAME into :b0  from AR_CUSTOMER where CUST_CODE\
=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )997;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_before_cust_name;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_adt_prv_cust_code;
 sqlstm.sqhstl[1] = (unsigned int  )12;
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

     

	if(NODATAFOUND)
	   return 0;


	return;

	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1020;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at customer_name() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}

int get_customer_name1()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 
	
	
	l_after_cust_name.arr[0]='\0';


	/* EXEC SQL SELECT SHORT_NAME
			 INTO   :l_after_cust_name
			 FROM    AR_CUSTOMER
			 WHERE   CUST_CODE = :l_adt_chg_cust_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 27;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select SHORT_NAME into :b0  from AR_CUSTOMER where CUST_CODE\
=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1035;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_after_cust_name;
 sqlstm.sqhstl[0] = (unsigned int  )18;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_adt_chg_cust_code;
 sqlstm.sqhstl[1] = (unsigned int  )12;
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



	if(NODATAFOUND)
	   return 0;

	return;

	err_exit:
		/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

		/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 27;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1058;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		disp_message(ERR_MESG,"Oracle error at customer_name() occured....");
		sprintf(aMesg,"Error: %-100s",sqlca.sqlerrm.sqlerrmc);
		disp_message(ERR_MESG,aMesg);
		proc_exit();
}

print_fin_detail_page()   
{
	fprintf(f1,"\n");
	line_no=line_no+1;
	check_page_end(5);
	get_patient_details();
	fprintf(f1,"SERIAL NO : %-10s     PATIENT NO : %-20s/-%-30.30s     AGE : %d     SEX : %-6s\n",l_adt_audit_trail_no.arr,l_adt_patient_id.arr,l_patient_name.arr,l_patient_age,l_sex.arr);
	if (strlen(l_patient_name1.arr) > 2)
	{
	  fprintf(f1,"%60s %s\n"," ",l_patient_name1.arr);
	  line_no++;
	}
	line_no=line_no+2;
	check_page_end(5);    
	get_function_name();
	fprintf(f1,"FUNCTION  : %-30s                                   EPISODE DETAILS                : %-10d/%-4d\n",l_function_name.arr,l_adt_episode_id,l_adt_visit_id);
	line_no=line_no+2;
	check_page_end(5);
	get_fin_dtls_added_by();
	fprintf(f1,"ENTERED BY                      : %-25s                    ENTERED DATE                   : %11s\n",l_fin_dtl_added_by_id.arr,l_fin_dtl_added_date.arr);
	fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
	line_no=line_no+5;
	check_page_end(5);

	if (get_blng_grp_desc())   
	   {	
	        fprintf(f1,"BILLING GROUP(BEFORE)           : %-15s                              BILLING GROUP(AFTER)           :   %-15s\n",l_before_blng_grp_desc.arr,l_after_blng_grp_desc.arr);
		    line_no=line_no+2;
		    check_page_end(5);
        }
	else
	   {	fprintf(f1,"BILLING GROUP(BEFORE)           : LOWEST                                 BILLING GROUP(AFTER)           :   HIGHEST \n");
		    line_no=line_no+2;
		    check_page_end(5);
        }

     
	get_stlmnt_ind_desc();  
 
		fprintf(f1,"SETTLEMENT INDICATOR (BEFORE)   : %-15s                              SETTLEMENT INDICATOR (AFTER)   :   %-15s\n",l_before_stlmt_ind_desc.arr, l_after_stlmt_ind_desc.arr);
    line_no=line_no+2;
	check_page_end(5);

	get_customer_name();
	if (l_before_cust_name.arr[0]=='\0')
		 strcpy(l_before_cust_name.arr,"NA");
 
	get_customer_name1();
	if (l_after_cust_name.arr[0]=='\0')
		 strcpy(l_after_cust_name.arr,"NA");
 
	fprintf(f1,"CUSTOMER (BEFORE)               : %-8s/%-15s                     CUSTOMER (AFTER)               : %-8s/%-15s\n",l_adt_prv_cust_code.arr,l_before_cust_name.arr,
					l_adt_chg_cust_code.arr, l_after_cust_name.arr);
		line_no=line_no+2;
		check_page_end(5);
     

	/*    
	if (l_after_cust_name.arr[0]=='\0')
		 strcpy(l_after_cust_name.arr,"NA");

	if (l_before_cust_name.arr[0]=='\0')
		 strcpy(l_before_cust_name.arr,"NA");

	if (get_customer_name())
	{

		fprintf(f1,"CUSTOMER (BEFORE)               : %-8s/%-15s                     CUSTOMER (AFTER)               : %-8s/%-15s\n",l_adt_prv_cust_code.arr,l_before_cust_name.arr,
					l_adt_chg_cust_code.arr, l_after_cust_name.arr);
		line_no=line_no+2;
		check_page_end(5);
	 }
	 else
	{
		fprintf(f1,"CUSTOMER (BEFORE)               : %-8s/%-15s                     CUSTOMER (AFTER)               : %-8s/%-15s\n","NA", "NA", "NA", "NA");
		line_no=line_no+2;
		check_page_end(5);
	 }
	 */
	fprintf(f1,"CREDIT DOC REF (BEFORE)         : %-30s               CREDIT DOC REF (AFTER)         : %-30s\n",
			l_adt_prv_credit_doc_ref_desc.arr,l_adt_chg_credit_doc_ref_desc.arr);
	line_no=line_no+2;
	check_page_end(5);

	fprintf(f1,"CREDIT DOC REF DATE (BEFORE)    : %-10s                                   CREDIT DOC REF DATE (AFTER)    : %-10s\n",
				l_adt_prv_credit_doc_ref_date.arr,
			    l_adt_chg_credit_doc_ref_date.arr);
	line_no=line_no+2;
	check_page_end(5);


	fprintf(f1,"MODIFIED BY (BEFORE)            : %-30s               MODIFIED BY (AFTER)            : %-30s\n",
				l_adt_prv_modified_by_id.arr,
				l_adt_chg_modified_by_id.arr);
	line_no=line_no+2;
	check_page_end(5);

	fprintf(f1,"MODIFIED DATE (BEFORE)          : %-17s                            ENTERED DATE (AFTER)           : %-17s\n",
				l_adt_prv_modified_date.arr,
			l_adt_chg_modified_date.arr);
	line_no=line_no+2;
	check_page_end(5);

	fprintf(f1,"CHARGE ADJUSTMENT - TRANSACTION DATES    :  %11s - %11s          SERVICES   : %11s - %11s\n",
						l_charge_adj_trx_dt_fr.arr,
					    l_charge_adj_trx_dt_to.arr,
						l_serv_date_fr.arr, l_serv_date_to.arr	);
	line_no=line_no+2;
	check_page_end(5);


}

print_rec_hdr()
{
	fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	fprintf(f1,"                                                                                ---------ORIGINAL-------  -----------NEW----------  -------DIFFERENCE-------\n");
	fprintf(f1,"TRX DATE               BILLING SERVICE         DOCTOR                              QUANTITY    NET CHARGE     QUANTITY     NET CHARGE  QUANTITY     NET CHARGE  TRX REFERENCE\n");
	fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	line_no=line_no+4;
}

print_rec()
{
	char	f_folio_upd_net_charge_amt[14],
			f_prev_upd_net_charge_amt[14],
			f_diff_upd_net_amt[14];

	print_formated(f_folio_upd_net_charge_amt,l_folio_upd_net_charge_amt);
	print_formated(f_prev_upd_net_charge_amt,l_prev_upd_net_charge_amt);
	print_formated(f_diff_upd_net_amt,l_diff_upd_net_amt);

    
	fprintf(f1,"%-21s  %-10s/%-15s  %-15s/%-15s  %7.2f %14s     %7.2f  %14s  %7.2f  %14s  %20s\n",
	            l_folio_trx_date.arr,l_folio_blng_serv_code.arr,l_blng_serv_desc.arr,l_folio_physician_id.arr,
				l_folio_physician_name.arr,l_prev_serv_qty, f_prev_upd_net_charge_amt,
				l_folio_serv_qty,f_folio_upd_net_charge_amt,l_diff_serv_qty ,f_diff_upd_net_amt,l_folio_trx_doc_ref.arr);
    
	line_no=line_no+1;
	g_prev_upd_net_charge_amt  += l_prev_upd_net_charge_amt; 
	g_folio_upd_net_charge_amt += l_folio_upd_net_charge_amt;
	g_diff_upd_net_amt         += l_diff_upd_net_amt;
}

    
print_total()     
{
	char	gf_folio_upd_net_charge_amt[14],
			gf_prev_upd_net_charge_amt[14],
			gf_diff_upd_net_amt[14];

	print_formated(gf_folio_upd_net_charge_amt,g_folio_upd_net_charge_amt);
	print_formated(gf_prev_upd_net_charge_amt,g_prev_upd_net_charge_amt);
	print_formated(gf_diff_upd_net_amt,g_diff_upd_net_amt);
	fprintf(f1,"\n      TOTAL : %-77s%15s             %15s         %16s ", " ",
			 gf_prev_upd_net_charge_amt,
	         gf_folio_upd_net_charge_amt,
			 gf_diff_upd_net_amt);
		line_no=line_no+2;
		g_folio_upd_net_charge_amt = 0;
		g_prev_upd_net_charge_amt  = 0;
		g_diff_upd_net_amt         = 0;

    

}
print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;

	fprintf(f1,"\f");
	page_no=page_no+1;

	line_no= 0;
	l_report_width=178;
	l_acc_entity_length = strlen(d_acc_entity_name.arr);

	//Code for Line 1
	l_start_point=ceill((l_report_width/2)-(l_acc_entity_length/2));
	fprintf(f1,"MDL : BL");
	l_start_point=l_start_point-8;
	print_spaces(l_start_point);
	fprintf(f1,"%s",d_acc_entity_name.arr);
	l_comp_name_end_point=l_start_point+8+l_acc_entity_length;
	l_start_point=((l_report_width-17)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(f1,"%s\n",d_sysdate.arr);

	//Code for Line 2
	l_start_point=0;
	fprintf(f1,"OPR : %-15s",d_user.arr);
	l_start_point=ceill((l_report_width/2)-22);
	l_start_point=l_start_point-30;
	print_spaces(l_start_point);
	fprintf(f1,"AUDIT TRAIL OF CHANGES MADE IN FINANCIAL DETAILS OF PATIENTS\n");


	//Code for Line 3
	l_start_point=0;
	fprintf(f1,"REP : BLRAUDTR");
	l_start_point=ceill((l_report_width/2)-29);
	l_start_point=l_start_point-14;
	print_spaces(l_start_point);
	fprintf(f1,"TRANSACTION DATE FROM %s TO %s",l_fm_trx_date.arr,l_to_trx_date.arr);
	l_comp_name_end_point=l_start_point+14+58;
	l_start_point=((l_report_width-17)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(f1,"PAGE : %d\n",page_no);
	line_no=3;

	//Code for Line 4
	l_start_point=0;
	l_start_point=ceill((l_report_width/2)-26);
	print_spaces(l_start_point);
	if(l_fm_patient_id.arr[0] =='\0')
	  strcpy(l_fm_patient_id.arr,"LOWEST");
	if(l_to_patient_id.arr[0] =='\0')
	  strcpy(l_to_patient_id.arr,"HIGHEST");
	fprintf(f1,"PATIENT NO FROM %16s TO %16s",l_fm_patient_id.arr,l_to_patient_id.arr);
	fprintf(f1,"\n");

	//Code for Line 5
	l_start_point=0;
	l_start_point=ceill((l_report_width/2)-11);
	print_spaces(l_start_point);
	fprintf(f1,"FUNCTION SELECTED :  %s",l_report_option.arr);
	fprintf(f1,"\n");
	fprintf(f1,"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	line_no=6;
}

print_spaces(l_length)
double l_length;
{
	int i;

	for(i=0;i<l_length;i++)
	{
		fprintf(f1," ");
	}
}

check_page_end()
{
	if ((line_no + 5) >= MAX_LINES)
	{
		line_no=0;
	    print_page_title();
	}	
	return;
}

end_report()
{
	fprintf(f1,"\n\n");
	fprintf(f1,"                                                         ");
	fprintf(f1,"** End of Report **");
	fprintf(f1,"");
}

print_formated(l_char_digit, l_double_digit)
double	l_double_digit;
char	l_char_digit[15];
{
	if(l_double_digit<0)
	{
		put_val(l_char_digit,-l_double_digit);
		format_amt(l_char_digit);
		strcat(l_char_digit,"-");
	}
	else
	{
		put_val(l_char_digit,l_double_digit);
		format_amt(l_char_digit);
		strcat(l_char_digit," ");
	}
	return l_char_digit;
}

print_end_of_rep()
{
    fprintf(f1,"\n\n                                                    ** END OF REPORT **                                                             \n");
}

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER