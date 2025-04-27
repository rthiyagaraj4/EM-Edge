
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blrblgen.pc"
};


static unsigned int sqlctx = 1288466235;


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
            void  *sqhstv[37];
   unsigned int   sqhstl[37];
            int   sqhsts[37];
            void  *sqindv[37];
            int   sqinds[37];
   unsigned int   sqharm[37];
   unsigned int   *sqharc[37];
   unsigned short  sqadto[37];
   unsigned short  sqtdso[37];
} sqlstm = {12,37};

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

 static const char *sq0005 = 
"ING_FACILITY_ID between NVL(ltrim(rtrim(substr(:b16,1,2))),'  ') and NVL(ltr\
im(rtrim(substr(:b17,1,2))),'~~')) order by OPERATING_FACILITY_ID,CASH_COUNTER\
_CODE,EPISODE_TYPE,DOC_TYPE_CODE,DOC_NUM            ";

 static const char *sq0006 = 
"select PRT_GRP_HDR_CODE ,PRT_GRP_LINE_CODE ,TO_CHAR(NVL(GROSS_AMT,0),'999,99\
9,990.99') ,TO_CHAR(NVL(SERV_DISC_AMT,0),'999,999,990.99') ,TO_CHAR(NVL(MAN_DI\
SC_AMT,0),'999,999,990.99') ,TO_CHAR(NVL(MAN_DISC_PERC,0),'990.99') ,TO_CHAR(N\
VL(NET_AMT,0),'999,999,990.99') ,NVL(GROSS_AMT,0) ,NVL(SERV_DISC_AMT,0) ,NVL(M\
AN_DISC_AMT,0) ,NVL(NET_AMT,0)  from BL_BILL_LINE where ((DOC_TYPE_CODE=:b0 an\
d DOC_NUM=:b1) and OPERATING_FACILITY_ID between NVL(ltrim(rtrim(substr(:b2,1,\
2))),'  ') and NVL(ltrim(rtrim(substr(:b3,1,2))),'~~')) order by PRT_GRP_HDR_C\
ODE,PRT_GRP_LINE_CODE            ";

 static const char *sq0007 = 
"select SUBSTR(SHORT_NAME_LOC_LANG,1,16) ,short_name  from MP_PATIENT_MAST wh\
ere PATIENT_ID=:b0           ";

 static const char *sq0008 = 
"select SHORT_DESC  from BL_SERVICE_LOCN where SERV_LOCN_CODE=:b0           ";

 static const char *sq0009 = 
"select LONG_DESC  from BL_BLNG_PRT_GRP_LINE where (PRT_GRP_HDR_CODE=:b0 and \
PRT_GRP_LINE_CODE=:b1)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,198,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,309,0,0,0,0,0,1,0,
51,0,0,3,378,0,4,355,0,0,22,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
154,0,0,4,84,0,2,413,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
181,0,0,5,2254,0,9,539,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
268,0,0,6,577,0,9,546,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
299,0,0,5,0,0,13,603,0,0,37,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,
2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,
0,0,2,4,0,0,2,4,0,0,
462,0,0,6,0,0,13,695,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
521,0,0,7,105,0,9,724,0,0,1,1,0,1,0,1,9,0,0,
540,0,0,7,0,0,13,738,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
563,0,0,10,515,0,6,752,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
590,0,0,8,75,0,9,784,0,0,1,1,0,1,0,1,9,0,0,
609,0,0,8,0,0,13,791,0,0,1,0,0,1,0,2,9,0,0,
628,0,0,9,109,0,9,801,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
651,0,0,9,0,0,13,808,0,0,1,0,0,1,0,2,9,0,0,
670,0,0,11,128,0,4,1308,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
701,0,0,12,96,0,4,1375,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
724,0,0,13,165,0,6,1382,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
755,0,0,14,110,0,6,1400,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
782,0,0,15,122,0,6,1442,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
809,0,0,16,110,0,6,1473,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRBLGEN.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* Converted To Windows  : Prasad B G S          4/7/96                 */
/* DATE WRITTEN          : 26-AUG-1993                                  */
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*                                                                      */  
/*  PARAMETERS           :            -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/*                                                                      */
/************************************************************************/

#include <stdio.h>
#include <string.h>        
#include <bl.h>  

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY        (sqlca.sqlcode == -54)
#define DUPLICATE_KEY        (sqlca.sqlcode == -1)
#define ROW_COUNT            (sqlca.sqlerrd[2])


/*
#define DEBUG 0
*/
   
/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* VARCHAR hosp_name                                  [120],
            date_time                                  [20],
            user_id                                    [80],
			p_language_id								[4],
            nd_session_id                              [32],
            nd_pgm_date                                [50],
			nd_pwd									   [91],
            d_curr_pgm_name                            [30],
			nd_cc_facility_id						   [9],
			nd_pre_facility_id						   [9],
			nd_op_facility_id						   [9],
			nd_cash_counter_code					   [9],
			nd_pre_cash_counter_code				   [9],
			local_date_convert							[20],
            nd_epi_type                                [9],
            nd_fm_date                                 [30],
            nd_to_date                                 [30],
			nd_fm_cr_date							   [30],	
			nd_to_cr_date							   [30],
			nd_fm_cr_date_prn						   [30],	
			nd_to_cr_date_prn						   [30],
            nd_fm_date_prn                             [30],
            nd_to_date_prn                             [30],
			nd_fm_cr_dt_prn                            [30],
            nd_to_cr_dt_prn                            [30],
            nd_fm_doc_type_code                        [14],
            nd_to_doc_type_code                        [14],
            nd_fm_doc_num                              [18],
            nd_to_doc_num                              [18],
            nd_show_bill                               [5],
			nd_fr_cashcounter						   [9],
			nd_temp_date                               [16],
			date_convert                               [16],
			nd_loc_date                                [16],
			nd_to_cashcounter						   [9],
   			nd_fr_facility							   [9],
			nd_to_facility							   [9],    
			nd_operating_facility_id				   [9],
            d_short_name_full                          [150],
            bl_patient_name_loc_lang                   [150],
            bl_patient_name                            [150],
			bl_patient_name1                           [200],
            bl_locn_desc                               [200],
			nd_show_bill_desc						   [200],   
			bl_hdr_added_date						   [36],		
            bl_prt_grp_desc                            [260],
			l_pk_value								   [500],
			l_translated_value						   [500],
			nd_facility_id								[50]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[80]; } user_id;

struct { unsigned short len; unsigned char arr[4]; } p_language_id;

struct { unsigned short len; unsigned char arr[32]; } nd_session_id;

struct { unsigned short len; unsigned char arr[50]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[30]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[9]; } nd_cc_facility_id;

struct { unsigned short len; unsigned char arr[9]; } nd_pre_facility_id;

struct { unsigned short len; unsigned char arr[9]; } nd_op_facility_id;

struct { unsigned short len; unsigned char arr[9]; } nd_cash_counter_code;

struct { unsigned short len; unsigned char arr[9]; } nd_pre_cash_counter_code;

struct { unsigned short len; unsigned char arr[20]; } local_date_convert;

struct { unsigned short len; unsigned char arr[9]; } nd_epi_type;

struct { unsigned short len; unsigned char arr[30]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[30]; } nd_to_date;

struct { unsigned short len; unsigned char arr[30]; } nd_fm_cr_date;

struct { unsigned short len; unsigned char arr[30]; } nd_to_cr_date;

struct { unsigned short len; unsigned char arr[30]; } nd_fm_cr_date_prn;

struct { unsigned short len; unsigned char arr[30]; } nd_to_cr_date_prn;

struct { unsigned short len; unsigned char arr[30]; } nd_fm_date_prn;

struct { unsigned short len; unsigned char arr[30]; } nd_to_date_prn;

struct { unsigned short len; unsigned char arr[30]; } nd_fm_cr_dt_prn;

struct { unsigned short len; unsigned char arr[30]; } nd_to_cr_dt_prn;

struct { unsigned short len; unsigned char arr[14]; } nd_fm_doc_type_code;

struct { unsigned short len; unsigned char arr[14]; } nd_to_doc_type_code;

struct { unsigned short len; unsigned char arr[18]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[18]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[5]; } nd_show_bill;

struct { unsigned short len; unsigned char arr[9]; } nd_fr_cashcounter;

struct { unsigned short len; unsigned char arr[16]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[16]; } date_convert;

struct { unsigned short len; unsigned char arr[16]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cashcounter;

struct { unsigned short len; unsigned char arr[9]; } nd_fr_facility;

struct { unsigned short len; unsigned char arr[9]; } nd_to_facility;

struct { unsigned short len; unsigned char arr[9]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[150]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[150]; } bl_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[150]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[200]; } bl_patient_name1;

struct { unsigned short len; unsigned char arr[200]; } bl_locn_desc;

struct { unsigned short len; unsigned char arr[200]; } nd_show_bill_desc;

struct { unsigned short len; unsigned char arr[36]; } bl_hdr_added_date;

struct { unsigned short len; unsigned char arr[260]; } bl_prt_grp_desc;

struct { unsigned short len; unsigned char arr[500]; } l_pk_value;

struct { unsigned short len; unsigned char arr[500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[50]; } nd_facility_id;


   /* VARCHAR bl_hdr_episode_type                         [2],
           bl_hdr_doc_type_code                        [7],
           bl_hdr_doc_num                              [9],
           bl_hdr_doc_date                             [13],
           bl_hdr_bill_trx_type_code                   [2],
           bl_hdr_bill_nature_code                     [2],
           bl_hdr_bill_status                          [2],
           bl_hdr_overall_disc_amt                     [23],
           bl_hdr_bill_amt                             [23],
           bl_hdr_bill_prv_outst_amt                   [23],
           bl_hdr_bill_tot_amt                         [23],
           bl_hdr_bill_hosp_tot_amt                    [23],
           bl_hdr_bill_drfee_tot_amt                   [23],
           bl_hdr_prepay_adj_amt                       [23],
           bl_hdr_deposit_adj_amt                      [23],
           bl_hdr_serv_locn_code                       [5],
           bl_hdr_episode_id                           [9],
           bl_hdr_visit_id                             [5],
           bl_hdr_patient_id                           [21]; */ 
struct { unsigned short len; unsigned char arr[2]; } bl_hdr_episode_type;

struct { unsigned short len; unsigned char arr[7]; } bl_hdr_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } bl_hdr_doc_num;

struct { unsigned short len; unsigned char arr[13]; } bl_hdr_doc_date;

struct { unsigned short len; unsigned char arr[2]; } bl_hdr_bill_trx_type_code;

struct { unsigned short len; unsigned char arr[2]; } bl_hdr_bill_nature_code;

struct { unsigned short len; unsigned char arr[2]; } bl_hdr_bill_status;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_overall_disc_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_bill_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_bill_prv_outst_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_bill_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_bill_hosp_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_bill_drfee_tot_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_prepay_adj_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_hdr_deposit_adj_amt;

struct { unsigned short len; unsigned char arr[5]; } bl_hdr_serv_locn_code;

struct { unsigned short len; unsigned char arr[9]; } bl_hdr_episode_id;

struct { unsigned short len; unsigned char arr[5]; } bl_hdr_visit_id;

struct { unsigned short len; unsigned char arr[21]; } bl_hdr_patient_id;


   /* VARCHAR bl_line_prt_grp_hdr_code                    [3],
           bl_line_prt_grp_line_code                   [3],
           bl_line_gross_amt                           [23],
           bl_line_serv_disc_amt                       [23],
           bl_line_man_disc_amt                        [23],
           bl_line_man_disc_perc                       [15],
           bl_line_net_amt                             [23]; */ 
struct { unsigned short len; unsigned char arr[3]; } bl_line_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } bl_line_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[23]; } bl_line_gross_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_line_serv_disc_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_line_man_disc_amt;

struct { unsigned short len; unsigned char arr[15]; } bl_line_man_disc_perc;

struct { unsigned short len; unsigned char arr[23]; } bl_line_net_amt;


double     bl_hdr_bill_tot_amt_db      ,
           bl_hdr_bill_hosp_tot_amt_db ,
           bl_hdr_bill_drfee_tot_amt_db,

		   bl_hdr_overall_disc_amt_db  ,
           bl_hdr_bill_amt_db          ,
           bl_hdr_bill_prv_outst_amt_db,
           bl_hdr_bill_tot_amt_db      ,
           bl_hdr_bill_hosp_tot_amt_db ,
           bl_hdr_bill_drfee_tot_amt_db,
           bl_hdr_prepay_adj_amt_db    ,
           bl_hdr_deposit_adj_amt_db   ,

           epi_tot_tot_amt_db      ,
           epi_tot_hosp_tot_amt_db ,
           epi_tot_drfee_tot_amt_db,

           grn_tot_tot_amt_db      ,
           grn_tot_hosp_tot_amt_db ,
           grn_tot_drfee_tot_amt_db,

           bl_line_gross_amt_db,
           bl_line_serv_disc_amt_db,
           bl_line_man_disc_amt_db,
           bl_line_net_amt_db,

           tot_line_gross_amt,
           tot_line_serv_disc_amt,
           tot_line_man_disc_amt,
           tot_line_net_amt,
   	   bl_hdr_bill_tot_adjust_amt             ,
	   bl_hdr_bill_tot_exempt_amt             ,
           bl_hdr_bill_write_off_amt               ; 


	int i;
	
	char g_facility_id[3];

    char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];
	
char string_var [100];
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

char       store_episode_type                          [2];

int    lctr = 0,pctr = 0;

FILE *fp;

int hdr_ctr = 0, dtl_ctr = 0;

void proc_main(argc,argv)
char *argv[];
int argc;
{

    if (argc < 5)
    {
     int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
       proc_exit();  
    }
 
    strcpy(g_pgm_id,"BLRBLGEN");
     strcpy(nd_pwd.arr,argv[1]);
	 nd_pwd.len = strlen(nd_pwd.arr);

	 /* EXEC sql connect :nd_pwd; */ 

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
  sqlstm.sqhstv[0] = (         void  *)&nd_pwd;
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
  sqlstm.sqlcmax = (unsigned int )100;
  sqlstm.sqlcmin = (unsigned int )2;
  sqlstm.sqlcincr = (unsigned int )1;
  sqlstm.sqlctimeout = (unsigned int )0;
  sqlstm.sqlcnowait = (unsigned int )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	  
	  if (sqlca.sqlcode < 0 )
	   {
        disp_message(ORA_MESG,"Error in connecting to Oracle");
        proc_exit();
        }
	set_meduser_role(); 
    		strcpy(p_language_id.arr,l_language_id.arr);
		p_language_id.len = l_language_id.len;

 
/*    if (sql_connect(argv[1]) == -1)
    {
        disp_message(ORA_MESG,"Error in connecting to Oracle");
        proc_exit();
    }

 */   
    strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    strcpy(nd_session_id.arr,argv[2]);
    nd_session_id.len = strlen(nd_session_id.arr);
    strcpy(g_session_id,nd_session_id.arr);

    strcpy(nd_pgm_date.arr,argv[3]);
    nd_pgm_date.len = strlen(nd_pgm_date.arr);
    strcpy(g_pgm_date,nd_pgm_date.arr);

	strcpy(nd_facility_id.arr,argv[4]);
    nd_facility_id.len = strlen(nd_facility_id.arr);
    strcpy(g_facility_id,nd_facility_id.arr);

 
    start_prog_msg();

    fetch_prog_param(); 

	fetch_legend_value();

    declare_cur();
    fetch_hosp_name();
    open_file();
    
    open_hdr();

    hdr_ctr = 0;
    epi_tot_tot_amt_db = epi_tot_hosp_tot_amt_db = epi_tot_drfee_tot_amt_db = 0;
    nd_pre_facility_id.arr[0] = '\0';
    nd_pre_cash_counter_code.arr[0] = '\0';
    while(fetch_hdr())
    {
          /*  if (lctr > 51)
               print_head(1);*/

       if (!nd_pre_facility_id.arr)
         {
          strcpy(nd_pre_facility_id.arr,nd_op_facility_id.arr);
          strcpy(nd_pre_cash_counter_code.arr,nd_cash_counter_code.arr);
         }
       if (strcmp(nd_pre_facility_id.arr,nd_op_facility_id.arr)!=0) 
          {
           /* print_head(1); */
            strcpy(nd_pre_facility_id.arr,nd_op_facility_id.arr);
            fprintf(fp,"Facility Id :  %2s\n" ,nd_op_facility_id.arr);          
            lctr++;
            nd_pre_cash_counter_code.arr[0] = '\0';	    
          }

       if (strcmp(nd_pre_cash_counter_code.arr,nd_cash_counter_code.arr)!=0)
          {
            strcpy(nd_pre_cash_counter_code.arr,nd_cash_counter_code.arr);
            fprintf(fp,"Cash Counter Code  :  %2s\n" ,nd_cash_counter_code.arr);          
            lctr++;
          }

       hdr_ctr++;
       if (hdr_ctr == 1)
       {
           strcpy(store_episode_type,bl_hdr_episode_type.arr);
           print_rec(0);
       }
       if (strcmp(store_episode_type,bl_hdr_episode_type.arr))
       {
          print_epi_tot();
          print_head(1);
          strcpy(store_episode_type,bl_hdr_episode_type.arr);
       }
       print_rec(1);
       dtl_ctr = 0;
       tot_line_gross_amt = 0;
       tot_line_serv_disc_amt = tot_line_man_disc_amt = tot_line_net_amt = 0;

       open_line();
       while (fetch_line())
       {
          dtl_ctr++;
          if (dtl_ctr == 1)
             print_line_head();
          print_rec(2);
       }
       if (dtl_ctr)
           print_line_tot();
     }
     if (hdr_ctr)
        print_grand_tot();

    end_of_rep();
    end_prog_msg();

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


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");

}

fetch_prog_param()
{
		   bl_hdr_overall_disc_amt_db  = 0;
           bl_hdr_bill_amt_db           =0;
           bl_hdr_bill_prv_outst_amt_db =0;
           bl_hdr_bill_tot_amt_db       =0;
           bl_hdr_bill_hosp_tot_amt_db  =0;
           bl_hdr_bill_drfee_tot_amt_db =0;
           bl_hdr_prepay_adj_amt_db     =0;
           bl_hdr_deposit_adj_amt_db    =0;


    nd_epi_type.arr[0]                  = '\0';
    nd_fm_date.arr[0]                   = '\0';
    nd_to_date.arr[0]                   = '\0';
    nd_fm_doc_type_code.arr[0]          = '\0';
    nd_to_doc_type_code.arr[0]          = '\0';
    nd_fm_doc_num.arr[0]                = '\0';
    nd_to_doc_num.arr[0]                = '\0';
    nd_show_bill.arr[0]                 = '\0';
    nd_fm_date_prn.arr[0]                   = '\0';
    nd_to_date_prn.arr[0]                   = '\0';


    nd_epi_type.len                     = 0;
    nd_fm_date.len                      = 0;
    nd_to_date.len                      = 0;
    nd_fm_doc_type_code.len             = 0;
    nd_to_doc_type_code.len             = 0;
    nd_fm_doc_num.len                   = 0;
    nd_to_doc_num.len                   = 0;
    nd_show_bill.len                    = 0;
    nd_fm_date_prn.len                  = 0;
    nd_to_date_prn.len                  = 0;


/*-- Y2K correction. Format introduced for 'FROM AND TO' Date 
     as DD/MM/YYYY in the form. So, no need to format it here 
	 while selecting. VSK 14/11/1999 */

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,PARAM2,PARAM3,PARAM4,
                   PARAM5,PARAM6,PARAM7,PARAM8,
				   PARAM9,PARAM10,  /o 9 & 10 Added on 11/3/1999 o/
				   NVL(PARAM2,'LOWEST'),
				   NVL(PARAM3,'HIGHEST'),  
//                 NVL(TO_CHAR(TO_DATE(PARAM2,'DD-MON-YY'),'DD/MM/YYYY'),'LOWEST'),
//                 NVL(TO_CHAR(TO_DATE(PARAM3,'DD-MON-YY'),'DD/MM/YYYY'),'HIGHEST'),
				   PARAM11,
				   PARAM12,
				   PARAM13,
				   PARAM14,
				   PARAM15,
				   PARAM16
              INTO	:nd_operating_facility_id,
					:nd_epi_type, 
                   :nd_fm_date,          :nd_to_date,
                   :nd_fm_doc_type_code, :nd_to_doc_type_code,
                   :nd_fm_doc_num,       :nd_to_doc_num,
                   :nd_show_bill,
				   :nd_fm_cr_date,      /o Added on 11/3/1999 o/
				   :nd_to_cr_date,      /o Added on 11/3/1999 o/
                   :nd_fm_date_prn,      :nd_to_date_prn,
				   :nd_fm_cr_date_prn,
				   :nd_to_cr_date_prn,
				   :nd_fr_cashcounter,
				   :nd_to_cashcounter,
   				   :nd_fr_facility,
				   :nd_to_facility

              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,NVL(PARAM2,'LOWEST') ,NVL\
(PARAM3,'HIGHEST') ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 ,PARAM15 ,PARAM16 into \
:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b1\
7,:b18  from SY_PROG_PARAM where ((PGM_ID=:b19 and SESSION_ID=:b20) and PGM_DA\
TE=:b21)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )11;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_epi_type;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[2] = (unsigned int  )32;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[3] = (unsigned int  )32;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_type_code;
   sqlstm.sqhstl[4] = (unsigned int  )16;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )16;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[6] = (unsigned int  )20;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[7] = (unsigned int  )20;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_show_bill;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_fm_cr_date;
   sqlstm.sqhstl[9] = (unsigned int  )32;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_to_cr_date;
   sqlstm.sqhstl[10] = (unsigned int  )32;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_fm_date_prn;
   sqlstm.sqhstl[11] = (unsigned int  )32;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_to_date_prn;
   sqlstm.sqhstl[12] = (unsigned int  )32;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_fm_cr_date_prn;
   sqlstm.sqhstl[13] = (unsigned int  )32;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_to_cr_date_prn;
   sqlstm.sqhstl[14] = (unsigned int  )32;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_fr_cashcounter;
   sqlstm.sqhstl[15] = (unsigned int  )11;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_to_cashcounter;
   sqlstm.sqhstl[16] = (unsigned int  )11;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_fr_facility;
   sqlstm.sqhstl[17] = (unsigned int  )11;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_to_facility;
   sqlstm.sqhstl[18] = (unsigned int  )11;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[19] = (unsigned int  )32;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[20] = (unsigned int  )34;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[21] = (unsigned int  )52;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

   nd_epi_type.arr[nd_epi_type.len]                   = '\0';
   nd_fm_date.arr[nd_fm_date.len]                     = '\0';
   nd_to_date.arr[nd_to_date.len]                     = '\0';
   nd_fm_cr_date.arr[nd_fm_cr_date.len]               = '\0';
   nd_to_cr_date.arr[nd_to_cr_date.len]               = '\0';
   nd_fm_doc_type_code.arr[nd_fm_doc_type_code.len]   = '\0';
   nd_to_doc_type_code.arr[nd_to_doc_type_code.len]   = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]               = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]               = '\0';
   nd_show_bill.arr[nd_show_bill.len]                 = '\0';
   nd_fm_date_prn.arr[nd_fm_date_prn.len]                     = '\0';
   nd_to_date_prn.arr[nd_to_date_prn.len]                     = '\0';

   strcpy(g_facility_id,nd_operating_facility_id.arr);

   /* EXEC SQL DELETE SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 22;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )154;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[0] = (unsigned int  )32;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[1] = (unsigned int  )34;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[2] = (unsigned int  )52;
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
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");
   
}

declare_cur()
{

/*-- Y2K correction. Format introduced for 'FROM AND TO' Date 
     as DD/MM/YYYY VSK 14/11/1999 */

     /* EXEC SQL DECLARE BL_BILL_HDR_CUR CURSOR FOR
               SELECT EPISODE_TYPE,
                      DOC_TYPE_CODE,
                      DOC_NUM,
                      to_char(TRUNC(DOC_DATE),'DD-MON-RRRR'),
                      BILL_TRX_TYPE_CODE,
                      BILL_NATURE_CODE,
                      BILL_STATUS,
					  NVL(OVERALL_DISC_AMT,0),
                      TO_CHAR(NVL(OVERALL_DISC_AMT,0),'999,999,990.99'),
					  NVL(BILL_AMT,0),
                      TO_CHAR(NVL(BILL_AMT,0),'999,999,990.99'),
					  NVL(BILL_PRV_OUTST_AMT,0),
                      TO_CHAR(NVL(BILL_PRV_OUTST_AMT,0),'999,999,990.99'),
					  NVL(BILL_TOT_AMT,0),
                      TO_CHAR(NVL(BILL_TOT_AMT,0),'999,999,990.99'),
					  NVL(BILL_HOSP_TOT_AMT,0),
                      TO_CHAR(NVL(BILL_HOSP_TOT_AMT,0),'999,999,990.99'),
					  nvl(BILL_DRFEE_TOT_AMT,0),
                      TO_CHAR(NVL(BILL_DRFEE_TOT_AMT,0),'999,999,990.99'),
					  nvl(PREPAY_ADJ_AMT,0),
                      TO_CHAR(NVL(PREPAY_ADJ_AMT,0),'999,999,990.99'),
					  NVL(DEPOSIT_ADJ_AMT,0),
                      TO_CHAR(NVL(DEPOSIT_ADJ_AMT,0),'999,999,990.99'),
                      SERV_LOCN_CODE,
                      EPISODE_ID,
                      VISIT_ID,
                      PATIENT_ID,
                      NVL(BILL_TOT_AMT,0),
                      NVL(BILL_HOSP_TOT_AMT,0),
                      NVL(BILL_DRFEE_TOT_AMT,0),
					  TO_CHAR(NVL(ADDED_DATE,SYSDATE),'DD/MM/YYYY HH24:MI'),
  					  CASH_COUNTER_CODE,
					  CASH_COUNTER_FACILITY_ID,
					  OPERATING_FACILITY_ID,
                      NVL(BILL_TOT_ADJUST_AMT,0),   // EPNH 28/10/2004  
                      NVL(BILL_TOT_EXEMPT_AMT,0),    
                      NVL(BILL_TOT_WRITE_OFF_AMT,0)                        
                 FROM BL_BILL_HDR  
                WHERE EPISODE_TYPE = decode(:nd_epi_type, 'A', EPISODE_TYPE, :nd_epi_type)		//CHANGED ON 9/5/2005
				AND   TRUNC(NVL(DOC_DATE,SYSDATE))  BETWEEN
                        NVL(TO_DATE(:nd_fm_date,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))    
						AND 
                        NVL(TO_DATE(:nd_to_date,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))
				AND	TO_DATE(TO_CHAR(NVL(ADDED_DATE,SYSDATE),'DD/MM/YYYY HH24:MI'),'DD/MM/YYYY HH24:MI')  BETWEEN
                        TO_DATE(:nd_fm_cr_date,'DD/MM/YYYY HH24:MI')  AND 
                        TO_DATE(:nd_to_cr_date,'DD/MM/YYYY HH24:MI')
	            AND RPAD(DOC_TYPE_CODE,6,' ')|| LPAD(DOC_NUM,8,'0') BETWEEN
                         RPAD(NVL(:nd_fm_doc_type_code,' '),6,' ')||LPAD(NVL(:nd_fm_doc_num,0),8,'0')
                     AND
                         RPAD(NVL(:nd_to_doc_type_code,'~~~~~~'),6,' ')||LPAD(NVL(:nd_to_doc_num,99999999),8,'0')
                 AND ((:nd_show_bill = 'V' AND (BILL_STATUS IS NULL OR
                       BILL_STATUS = 'D')) OR
                     (:nd_show_bill = 'C' AND BILL_STATUS = 'C') OR
                     (:nd_show_bill = 'N' AND 
                         BILL_STATUS IS NULL AND
                          (OVERALL_DISC_AMT != 0 OR
                           MAN_DISC_AMT != 0 )
                        )                        OR
                      (:nd_show_bill = 'A' AND (BILL_STATUS IS NULL OR
                       BILL_STATUS = 'C' OR BILL_STATUS = 'D'))
                     )
                 AND  CASH_COUNTER_CODE BETWEEN NVL(ltrim(rtrim(substr(:nd_fr_cashcounter,1,2))),'  ')
				                        AND NVL(ltrim(rtrim(substr(:nd_to_cashcounter,1,2))),'~~')
				 AND OPERATING_FACILITY_ID  BETWEEN NVL(ltrim(rtrim(substr(:nd_fr_facility,1,2))),'  ')
				                        AND  NVL(ltrim(rtrim(substr(:nd_to_facility,1,2))),'~~')
				 ORDER BY OPERATING_FACILITY_ID,CASH_COUNTER_CODE,EPISODE_TYPE,DOC_TYPE_CODE,DOC_NUM; */ 


     /* EXEC SQL DECLARE BL_BILL_LINE_CUR CURSOR FOR
               SELECT PRT_GRP_HDR_CODE,
                      PRT_GRP_LINE_CODE,
                      TO_CHAR(NVL(GROSS_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(SERV_DISC_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(MAN_DISC_AMT,0),'999,999,990.99'),
                      TO_CHAR(NVL(MAN_DISC_PERC,0),'990.99'),   
                      TO_CHAR(NVL(NET_AMT,0),'999,999,990.99'),
                      NVL(GROSS_AMT,0),
                      NVL(SERV_DISC_AMT,0),
                      NVL(MAN_DISC_AMT,0),
                      NVL(NET_AMT,0)
                 FROM BL_BILL_LINE
                WHERE DOC_TYPE_CODE = :bl_hdr_doc_type_code
                  AND DOC_NUM       = :bl_hdr_doc_num
				  AND OPERATING_FACILITY_ID  BETWEEN NVL(ltrim(rtrim(substr(:nd_fr_facility,1,2))),'  ')
				                      AND  NVL(ltrim(rtrim(substr(:nd_to_facility,1,2))),'~~')
                ORDER BY PRT_GRP_HDR_CODE, PRT_GRP_LINE_CODE; */ 


    /* EXEC SQL DECLARE BL_PAT_NAME_CUR CURSOR FOR
              SELECT SUBSTR(SHORT_NAME_LOC_LANG,1,16),
                     /osubstr(SHORT_NAME,1,30),
					 decode(substr(short_name,31,60),NULL,' ',substr(short_name,31,60)) shortname1 ,
                      o/
					  short_name 
                FROM MP_PATIENT_MAST
               WHERE PATIENT_ID = :bl_hdr_patient_id; */ 
  

    /* EXEC SQL DECLARE BL_SERV_LOCN_CUR CURSOR FOR
              SELECT SHORT_DESC
                FROM BL_SERVICE_LOCN
               WHERE SERV_LOCN_CODE = :bl_hdr_serv_locn_code; */ 


    /* EXEC SQL DECLARE BL_BLNG_PRT_GRP_LINE CURSOR FOR
              SELECT LONG_DESC
                FROM BL_BLNG_PRT_GRP_LINE
               WHERE PRT_GRP_HDR_CODE  = :bl_line_prt_grp_hdr_code
                 AND PRT_GRP_LINE_CODE = :bl_line_prt_grp_line_code; */ 

}

open_hdr()
{
    /* EXEC SQL OPEN BL_BILL_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select EPISODE_TYPE ,DOC_TYPE_CODE ,DOC_NUM ,to_char(TRUNC(DOC_DATE),\
'DD-MON-RRRR') ,BILL_TRX_TYPE_CODE ,BILL_NATURE_CODE ,BILL_STATUS ,NVL(OVERA\
LL_DISC_AMT,0) ,TO_CHAR(NVL(OVERALL_DISC_AMT,0),'999,999,990.99') ,NVL(BILL_\
AMT,0) ,TO_CHAR(NVL(BILL_AMT,0),'999,999,990.99') ,NVL(BILL_PRV_OUTST_AMT,0)\
 ,TO_CHAR(NVL(BILL_PRV_OUTST_AMT,0),'999,999,990.99') ,NVL(BILL_TOT_AMT,0) ,\
TO_CHAR(NVL(BILL_TOT_AMT,0),'999,999,990.99') ,NVL(BILL_HOSP_TOT_AMT,0) ,TO_\
CHAR(NVL(BILL_HOSP_TOT_AMT,0),'999,999,990.99') ,nvl(BILL_DRFEE_TOT_AMT,0) ,\
TO_CHAR(NVL(BILL_DRFEE_TOT_AMT,0),'999,999,990.99') ,nvl(PREPAY_ADJ_AMT,0) ,\
TO_CHAR(NVL(PREPAY_ADJ_AMT,0),'999,999,990.99') ,NVL(DEPOSIT_ADJ_AMT,0) ,TO_\
CHAR(NVL(DEPOSIT_ADJ_AMT,0),'999,999,990.99') ,SERV_LOCN_CODE ,EPISODE_ID ,V\
ISIT_ID ,PATIENT_ID ,NVL(BILL_TOT_AMT,0) ,NVL(BILL_HOSP_TOT_AMT,0) ,NVL(BILL\
_DRFEE_TOT_AMT,0) ,TO_CHAR(NVL(ADDED_DATE,SYSDATE),'DD/MM/YYYY HH24:MI') ,CA\
SH_COUNTER_CODE ,CASH_COUNTER_FACILITY_ID ,OPERATING_FACILITY_ID ,NVL(BILL_T\
OT_ADJUST_AMT,0) ,NVL(BILL_TOT_EXEMPT_AMT,0");
    sqlbuft((void **)0, 
      ") ,NVL(BILL_TOT_WRITE_OFF_AMT,0)  from BL_BILL_HDR where ((((((EPISOD\
E_TYPE=decode(:b0,'A',EPISODE_TYPE,:b0) and TRUNC(NVL(DOC_DATE,SYSDATE)) bet\
ween NVL(TO_DATE(:b2,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM')) and NVL(T\
O_DATE(:b3,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))) and TO_DATE(TO_CHA\
R(NVL(ADDED_DATE,SYSDATE),'DD/MM/YYYY HH24:MI'),'DD/MM/YYYY HH24:MI') betwee\
n TO_DATE(:b4,'DD/MM/YYYY HH24:MI') and TO_DATE(:b5,'DD/MM/YYYY HH24:MI')) a\
nd (RPAD(DOC_TYPE_CODE,6,' ')||LPAD(DOC_NUM,8,'0')) between (RPAD(NVL(:b6,' \
'),6,' ')||LPAD(NVL(:b7,0),8,'0')) and (RPAD(NVL(:b8,'~~~~~~'),6,' ')||LPAD(\
NVL(:b9,99999999),8,'0'))) and ((((:b10='V' and (BILL_STATUS is null  or BIL\
L_STATUS='D')) or (:b10='C' and BILL_STATUS='C')) or ((:b10='N' and BILL_STA\
TUS is null ) and (OVERALL_DISC_AMT<>0 or MAN_DISC_AMT<>0))) or (:b10='A' an\
d ((BILL_STATUS is null  or BILL_STATUS='C') or BILL_STATUS='D')))) and CASH\
_COUNTER_CODE between NVL(ltrim(rtrim(substr(:b14,1,2))),'  ') and NVL(ltrim\
(rtrim(substr(:b15,1,2))),'~~')) and OPERAT");
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )181;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_epi_type;
    sqlstm.sqhstl[0] = (unsigned int  )11;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_epi_type;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[2] = (unsigned int  )32;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[3] = (unsigned int  )32;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_fm_cr_date;
    sqlstm.sqhstl[4] = (unsigned int  )32;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_to_cr_date;
    sqlstm.sqhstl[5] = (unsigned int  )32;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_fm_doc_type_code;
    sqlstm.sqhstl[6] = (unsigned int  )16;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_fm_doc_num;
    sqlstm.sqhstl[7] = (unsigned int  )20;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_to_doc_type_code;
    sqlstm.sqhstl[8] = (unsigned int  )16;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_to_doc_num;
    sqlstm.sqhstl[9] = (unsigned int  )20;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_show_bill;
    sqlstm.sqhstl[10] = (unsigned int  )7;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_show_bill;
    sqlstm.sqhstl[11] = (unsigned int  )7;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_show_bill;
    sqlstm.sqhstl[12] = (unsigned int  )7;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_show_bill;
    sqlstm.sqhstl[13] = (unsigned int  )7;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_fr_cashcounter;
    sqlstm.sqhstl[14] = (unsigned int  )11;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_to_cashcounter;
    sqlstm.sqhstl[15] = (unsigned int  )11;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_fr_facility;
    sqlstm.sqhstl[16] = (unsigned int  )11;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_to_facility;
    sqlstm.sqhstl[17] = (unsigned int  )11;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
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
         err_mesg("OPEN failed on cursor BL_BILL_HDR_CUR",0,"");
}

open_line()
{
    /* EXEC SQL OPEN BL_BILL_LINE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 22;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )268;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_hdr_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_hdr_doc_num;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fr_facility;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_facility;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_BILL_LINE_CUR",0,"");
}

fetch_hdr()
{
bl_hdr_episode_type.arr[0]                                        = '\0';
bl_hdr_doc_type_code.arr[0]                                       = '\0';
bl_hdr_doc_num.arr[0]                                             = '\0';
bl_hdr_doc_date.arr[0]                                            = '\0';
bl_hdr_bill_trx_type_code.arr[0]                                  = '\0';
bl_hdr_bill_nature_code.arr[0]                                    = '\0';
bl_hdr_bill_status.arr[0]                                         = '\0';
bl_hdr_overall_disc_amt.arr[0]                                    = '\0';
bl_hdr_bill_amt.arr[0]                                            = '\0';
bl_hdr_bill_prv_outst_amt.arr[0]                                  = '\0';
bl_hdr_bill_tot_amt.arr[0]                                        = '\0';
bl_hdr_bill_hosp_tot_amt.arr[0]                                   = '\0';
bl_hdr_bill_drfee_tot_amt.arr[0]                                  = '\0';
bl_hdr_prepay_adj_amt.arr[0]                                      = '\0';
bl_hdr_deposit_adj_amt.arr[0]                                     = '\0';
bl_hdr_serv_locn_code.arr[0]                                      = '\0';
bl_hdr_episode_id.arr[0]                                          = '\0';
bl_hdr_visit_id.arr[0]                                            = '\0';
bl_hdr_patient_id.arr[0]                                          = '\0';


bl_hdr_episode_type.len                                           = 0;
bl_hdr_doc_type_code.len                                          = 0;
bl_hdr_doc_num.len                                                = 0;
bl_hdr_doc_date.len                                               = 0;
bl_hdr_bill_trx_type_code.len                                     = 0;
bl_hdr_bill_nature_code.len                                       = 0;
bl_hdr_bill_status.len                                            = 0;
bl_hdr_overall_disc_amt.len                                       = 0;
bl_hdr_bill_amt.len                                               = 0;
bl_hdr_bill_prv_outst_amt.len                                     = 0;
bl_hdr_bill_tot_amt.len                                           = 0;
bl_hdr_bill_hosp_tot_amt.len                                      = 0;
bl_hdr_bill_drfee_tot_amt.len                                     = 0;
bl_hdr_prepay_adj_amt.len                                         = 0;
bl_hdr_deposit_adj_amt.len                                        = 0;
bl_hdr_serv_locn_code.len                                         = 0;
bl_hdr_episode_id.len                                             = 0;
bl_hdr_visit_id.len                                               = 0;
bl_hdr_patient_id.len                                             = 0;

bl_hdr_bill_tot_amt_db                                            = 0;
bl_hdr_bill_hosp_tot_amt_db                                       = 0;
bl_hdr_bill_drfee_tot_amt_db                                      = 0;
bl_hdr_bill_tot_adjust_amt                                        = 0; // EPNH 28/10/2004
bl_hdr_bill_tot_exempt_amt                                        = 0;
bl_hdr_bill_write_off_amt                                         = 0;



     /* EXEC SQL FETCH BL_BILL_HDR_CUR
               INTO :bl_hdr_episode_type,
                    :bl_hdr_doc_type_code,
                    :bl_hdr_doc_num,
                    :bl_hdr_doc_date,
                    :bl_hdr_bill_trx_type_code,
                    :bl_hdr_bill_nature_code,
                    :bl_hdr_bill_status,
					:bl_hdr_overall_disc_amt_db,
                    :bl_hdr_overall_disc_amt,
					:bl_hdr_bill_amt_db,
                    :bl_hdr_bill_amt,
					:bl_hdr_bill_prv_outst_amt_db,
                    :bl_hdr_bill_prv_outst_amt,
					:bl_hdr_bill_tot_amt_db,
                    :bl_hdr_bill_tot_amt,
					:bl_hdr_bill_hosp_tot_amt_db,
                    :bl_hdr_bill_hosp_tot_amt,
					:bl_hdr_bill_drfee_tot_amt_db,
                    :bl_hdr_bill_drfee_tot_amt,
					:bl_hdr_prepay_adj_amt_db,
                    :bl_hdr_prepay_adj_amt,
					:bl_hdr_deposit_adj_amt_db,
                    :bl_hdr_deposit_adj_amt,
                    :bl_hdr_serv_locn_code,
                    :bl_hdr_episode_id,
                    :bl_hdr_visit_id,
                    :bl_hdr_patient_id,
                    :bl_hdr_bill_tot_amt_db,
                    :bl_hdr_bill_hosp_tot_amt_db,
                    :bl_hdr_bill_drfee_tot_amt_db,
					:bl_hdr_added_date,
		    :nd_cash_counter_code,
		    :nd_cc_facility_id,
		    :nd_op_facility_id,
		    :bl_hdr_bill_tot_adjust_amt, // EPNH 28/10/2004
                    :bl_hdr_bill_tot_exempt_amt,
                    :bl_hdr_bill_write_off_amt; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 37;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )299;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_hdr_episode_type;
     sqlstm.sqhstl[0] = (unsigned int  )4;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_hdr_doc_type_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_hdr_doc_num;
     sqlstm.sqhstl[2] = (unsigned int  )11;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_hdr_doc_date;
     sqlstm.sqhstl[3] = (unsigned int  )15;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_hdr_bill_trx_type_code;
     sqlstm.sqhstl[4] = (unsigned int  )4;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_hdr_bill_nature_code;
     sqlstm.sqhstl[5] = (unsigned int  )4;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_hdr_bill_status;
     sqlstm.sqhstl[6] = (unsigned int  )4;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_hdr_overall_disc_amt_db;
     sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_hdr_overall_disc_amt;
     sqlstm.sqhstl[8] = (unsigned int  )25;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_hdr_bill_amt_db;
     sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_hdr_bill_amt;
     sqlstm.sqhstl[10] = (unsigned int  )25;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
     sqlstm.sqhstv[11] = (         void  *)&bl_hdr_bill_prv_outst_amt_db;
     sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[11] = (         int  )0;
     sqlstm.sqindv[11] = (         void  *)0;
     sqlstm.sqinds[11] = (         int  )0;
     sqlstm.sqharm[11] = (unsigned int  )0;
     sqlstm.sqadto[11] = (unsigned short )0;
     sqlstm.sqtdso[11] = (unsigned short )0;
     sqlstm.sqhstv[12] = (         void  *)&bl_hdr_bill_prv_outst_amt;
     sqlstm.sqhstl[12] = (unsigned int  )25;
     sqlstm.sqhsts[12] = (         int  )0;
     sqlstm.sqindv[12] = (         void  *)0;
     sqlstm.sqinds[12] = (         int  )0;
     sqlstm.sqharm[12] = (unsigned int  )0;
     sqlstm.sqadto[12] = (unsigned short )0;
     sqlstm.sqtdso[12] = (unsigned short )0;
     sqlstm.sqhstv[13] = (         void  *)&bl_hdr_bill_tot_amt_db;
     sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[13] = (         int  )0;
     sqlstm.sqindv[13] = (         void  *)0;
     sqlstm.sqinds[13] = (         int  )0;
     sqlstm.sqharm[13] = (unsigned int  )0;
     sqlstm.sqadto[13] = (unsigned short )0;
     sqlstm.sqtdso[13] = (unsigned short )0;
     sqlstm.sqhstv[14] = (         void  *)&bl_hdr_bill_tot_amt;
     sqlstm.sqhstl[14] = (unsigned int  )25;
     sqlstm.sqhsts[14] = (         int  )0;
     sqlstm.sqindv[14] = (         void  *)0;
     sqlstm.sqinds[14] = (         int  )0;
     sqlstm.sqharm[14] = (unsigned int  )0;
     sqlstm.sqadto[14] = (unsigned short )0;
     sqlstm.sqtdso[14] = (unsigned short )0;
     sqlstm.sqhstv[15] = (         void  *)&bl_hdr_bill_hosp_tot_amt_db;
     sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[15] = (         int  )0;
     sqlstm.sqindv[15] = (         void  *)0;
     sqlstm.sqinds[15] = (         int  )0;
     sqlstm.sqharm[15] = (unsigned int  )0;
     sqlstm.sqadto[15] = (unsigned short )0;
     sqlstm.sqtdso[15] = (unsigned short )0;
     sqlstm.sqhstv[16] = (         void  *)&bl_hdr_bill_hosp_tot_amt;
     sqlstm.sqhstl[16] = (unsigned int  )25;
     sqlstm.sqhsts[16] = (         int  )0;
     sqlstm.sqindv[16] = (         void  *)0;
     sqlstm.sqinds[16] = (         int  )0;
     sqlstm.sqharm[16] = (unsigned int  )0;
     sqlstm.sqadto[16] = (unsigned short )0;
     sqlstm.sqtdso[16] = (unsigned short )0;
     sqlstm.sqhstv[17] = (         void  *)&bl_hdr_bill_drfee_tot_amt_db;
     sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[17] = (         int  )0;
     sqlstm.sqindv[17] = (         void  *)0;
     sqlstm.sqinds[17] = (         int  )0;
     sqlstm.sqharm[17] = (unsigned int  )0;
     sqlstm.sqadto[17] = (unsigned short )0;
     sqlstm.sqtdso[17] = (unsigned short )0;
     sqlstm.sqhstv[18] = (         void  *)&bl_hdr_bill_drfee_tot_amt;
     sqlstm.sqhstl[18] = (unsigned int  )25;
     sqlstm.sqhsts[18] = (         int  )0;
     sqlstm.sqindv[18] = (         void  *)0;
     sqlstm.sqinds[18] = (         int  )0;
     sqlstm.sqharm[18] = (unsigned int  )0;
     sqlstm.sqadto[18] = (unsigned short )0;
     sqlstm.sqtdso[18] = (unsigned short )0;
     sqlstm.sqhstv[19] = (         void  *)&bl_hdr_prepay_adj_amt_db;
     sqlstm.sqhstl[19] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[19] = (         int  )0;
     sqlstm.sqindv[19] = (         void  *)0;
     sqlstm.sqinds[19] = (         int  )0;
     sqlstm.sqharm[19] = (unsigned int  )0;
     sqlstm.sqadto[19] = (unsigned short )0;
     sqlstm.sqtdso[19] = (unsigned short )0;
     sqlstm.sqhstv[20] = (         void  *)&bl_hdr_prepay_adj_amt;
     sqlstm.sqhstl[20] = (unsigned int  )25;
     sqlstm.sqhsts[20] = (         int  )0;
     sqlstm.sqindv[20] = (         void  *)0;
     sqlstm.sqinds[20] = (         int  )0;
     sqlstm.sqharm[20] = (unsigned int  )0;
     sqlstm.sqadto[20] = (unsigned short )0;
     sqlstm.sqtdso[20] = (unsigned short )0;
     sqlstm.sqhstv[21] = (         void  *)&bl_hdr_deposit_adj_amt_db;
     sqlstm.sqhstl[21] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[21] = (         int  )0;
     sqlstm.sqindv[21] = (         void  *)0;
     sqlstm.sqinds[21] = (         int  )0;
     sqlstm.sqharm[21] = (unsigned int  )0;
     sqlstm.sqadto[21] = (unsigned short )0;
     sqlstm.sqtdso[21] = (unsigned short )0;
     sqlstm.sqhstv[22] = (         void  *)&bl_hdr_deposit_adj_amt;
     sqlstm.sqhstl[22] = (unsigned int  )25;
     sqlstm.sqhsts[22] = (         int  )0;
     sqlstm.sqindv[22] = (         void  *)0;
     sqlstm.sqinds[22] = (         int  )0;
     sqlstm.sqharm[22] = (unsigned int  )0;
     sqlstm.sqadto[22] = (unsigned short )0;
     sqlstm.sqtdso[22] = (unsigned short )0;
     sqlstm.sqhstv[23] = (         void  *)&bl_hdr_serv_locn_code;
     sqlstm.sqhstl[23] = (unsigned int  )7;
     sqlstm.sqhsts[23] = (         int  )0;
     sqlstm.sqindv[23] = (         void  *)0;
     sqlstm.sqinds[23] = (         int  )0;
     sqlstm.sqharm[23] = (unsigned int  )0;
     sqlstm.sqadto[23] = (unsigned short )0;
     sqlstm.sqtdso[23] = (unsigned short )0;
     sqlstm.sqhstv[24] = (         void  *)&bl_hdr_episode_id;
     sqlstm.sqhstl[24] = (unsigned int  )11;
     sqlstm.sqhsts[24] = (         int  )0;
     sqlstm.sqindv[24] = (         void  *)0;
     sqlstm.sqinds[24] = (         int  )0;
     sqlstm.sqharm[24] = (unsigned int  )0;
     sqlstm.sqadto[24] = (unsigned short )0;
     sqlstm.sqtdso[24] = (unsigned short )0;
     sqlstm.sqhstv[25] = (         void  *)&bl_hdr_visit_id;
     sqlstm.sqhstl[25] = (unsigned int  )7;
     sqlstm.sqhsts[25] = (         int  )0;
     sqlstm.sqindv[25] = (         void  *)0;
     sqlstm.sqinds[25] = (         int  )0;
     sqlstm.sqharm[25] = (unsigned int  )0;
     sqlstm.sqadto[25] = (unsigned short )0;
     sqlstm.sqtdso[25] = (unsigned short )0;
     sqlstm.sqhstv[26] = (         void  *)&bl_hdr_patient_id;
     sqlstm.sqhstl[26] = (unsigned int  )23;
     sqlstm.sqhsts[26] = (         int  )0;
     sqlstm.sqindv[26] = (         void  *)0;
     sqlstm.sqinds[26] = (         int  )0;
     sqlstm.sqharm[26] = (unsigned int  )0;
     sqlstm.sqadto[26] = (unsigned short )0;
     sqlstm.sqtdso[26] = (unsigned short )0;
     sqlstm.sqhstv[27] = (         void  *)&bl_hdr_bill_tot_amt_db;
     sqlstm.sqhstl[27] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[27] = (         int  )0;
     sqlstm.sqindv[27] = (         void  *)0;
     sqlstm.sqinds[27] = (         int  )0;
     sqlstm.sqharm[27] = (unsigned int  )0;
     sqlstm.sqadto[27] = (unsigned short )0;
     sqlstm.sqtdso[27] = (unsigned short )0;
     sqlstm.sqhstv[28] = (         void  *)&bl_hdr_bill_hosp_tot_amt_db;
     sqlstm.sqhstl[28] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[28] = (         int  )0;
     sqlstm.sqindv[28] = (         void  *)0;
     sqlstm.sqinds[28] = (         int  )0;
     sqlstm.sqharm[28] = (unsigned int  )0;
     sqlstm.sqadto[28] = (unsigned short )0;
     sqlstm.sqtdso[28] = (unsigned short )0;
     sqlstm.sqhstv[29] = (         void  *)&bl_hdr_bill_drfee_tot_amt_db;
     sqlstm.sqhstl[29] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[29] = (         int  )0;
     sqlstm.sqindv[29] = (         void  *)0;
     sqlstm.sqinds[29] = (         int  )0;
     sqlstm.sqharm[29] = (unsigned int  )0;
     sqlstm.sqadto[29] = (unsigned short )0;
     sqlstm.sqtdso[29] = (unsigned short )0;
     sqlstm.sqhstv[30] = (         void  *)&bl_hdr_added_date;
     sqlstm.sqhstl[30] = (unsigned int  )38;
     sqlstm.sqhsts[30] = (         int  )0;
     sqlstm.sqindv[30] = (         void  *)0;
     sqlstm.sqinds[30] = (         int  )0;
     sqlstm.sqharm[30] = (unsigned int  )0;
     sqlstm.sqadto[30] = (unsigned short )0;
     sqlstm.sqtdso[30] = (unsigned short )0;
     sqlstm.sqhstv[31] = (         void  *)&nd_cash_counter_code;
     sqlstm.sqhstl[31] = (unsigned int  )11;
     sqlstm.sqhsts[31] = (         int  )0;
     sqlstm.sqindv[31] = (         void  *)0;
     sqlstm.sqinds[31] = (         int  )0;
     sqlstm.sqharm[31] = (unsigned int  )0;
     sqlstm.sqadto[31] = (unsigned short )0;
     sqlstm.sqtdso[31] = (unsigned short )0;
     sqlstm.sqhstv[32] = (         void  *)&nd_cc_facility_id;
     sqlstm.sqhstl[32] = (unsigned int  )11;
     sqlstm.sqhsts[32] = (         int  )0;
     sqlstm.sqindv[32] = (         void  *)0;
     sqlstm.sqinds[32] = (         int  )0;
     sqlstm.sqharm[32] = (unsigned int  )0;
     sqlstm.sqadto[32] = (unsigned short )0;
     sqlstm.sqtdso[32] = (unsigned short )0;
     sqlstm.sqhstv[33] = (         void  *)&nd_op_facility_id;
     sqlstm.sqhstl[33] = (unsigned int  )11;
     sqlstm.sqhsts[33] = (         int  )0;
     sqlstm.sqindv[33] = (         void  *)0;
     sqlstm.sqinds[33] = (         int  )0;
     sqlstm.sqharm[33] = (unsigned int  )0;
     sqlstm.sqadto[33] = (unsigned short )0;
     sqlstm.sqtdso[33] = (unsigned short )0;
     sqlstm.sqhstv[34] = (         void  *)&bl_hdr_bill_tot_adjust_amt;
     sqlstm.sqhstl[34] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[34] = (         int  )0;
     sqlstm.sqindv[34] = (         void  *)0;
     sqlstm.sqinds[34] = (         int  )0;
     sqlstm.sqharm[34] = (unsigned int  )0;
     sqlstm.sqadto[34] = (unsigned short )0;
     sqlstm.sqtdso[34] = (unsigned short )0;
     sqlstm.sqhstv[35] = (         void  *)&bl_hdr_bill_tot_exempt_amt;
     sqlstm.sqhstl[35] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[35] = (         int  )0;
     sqlstm.sqindv[35] = (         void  *)0;
     sqlstm.sqinds[35] = (         int  )0;
     sqlstm.sqharm[35] = (unsigned int  )0;
     sqlstm.sqadto[35] = (unsigned short )0;
     sqlstm.sqtdso[35] = (unsigned short )0;
     sqlstm.sqhstv[36] = (         void  *)&bl_hdr_bill_write_off_amt;
     sqlstm.sqhstl[36] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[36] = (         int  )0;
     sqlstm.sqindv[36] = (         void  *)0;
     sqlstm.sqinds[36] = (         int  )0;
     sqlstm.sqharm[36] = (unsigned int  )0;
     sqlstm.sqadto[36] = (unsigned short )0;
     sqlstm.sqtdso[36] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
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
            err_mesg("FETCH failed on cursor BL_BILL_HDR_CUR",0,"");

nd_cash_counter_code.arr[nd_cash_counter_code.len]                       = '\0';
nd_cc_facility_id.arr[nd_cc_facility_id.len]							 = '\0';
nd_op_facility_id.arr[nd_op_facility_id.len]							 = '\0';

bl_hdr_episode_type.arr[bl_hdr_episode_type.len]                         = '\0';
bl_hdr_doc_type_code.arr[bl_hdr_doc_type_code.len]                       = '\0';
bl_hdr_doc_num.arr[bl_hdr_doc_num.len]                                   = '\0';
bl_hdr_doc_date.arr[bl_hdr_doc_date.len]                                 = '\0';
bl_hdr_bill_trx_type_code.arr[bl_hdr_bill_trx_type_code.len]             = '\0';
bl_hdr_bill_nature_code.arr[bl_hdr_bill_nature_code.len]                 = '\0';
bl_hdr_bill_status.arr[bl_hdr_bill_status.len]                           = '\0';
bl_hdr_overall_disc_amt.arr[bl_hdr_overall_disc_amt.len]                 = '\0';
bl_hdr_bill_amt.arr[bl_hdr_bill_amt.len]                                 = '\0';
bl_hdr_bill_prv_outst_amt.arr[bl_hdr_bill_prv_outst_amt.len]             = '\0';
bl_hdr_bill_tot_amt.arr[bl_hdr_bill_tot_amt.len]                         = '\0';
bl_hdr_bill_hosp_tot_amt.arr[bl_hdr_bill_hosp_tot_amt.len]               = '\0';
bl_hdr_bill_drfee_tot_amt.arr[bl_hdr_bill_drfee_tot_amt.len]             = '\0';
bl_hdr_prepay_adj_amt.arr[bl_hdr_prepay_adj_amt.len]                     = '\0';
bl_hdr_deposit_adj_amt.arr[bl_hdr_deposit_adj_amt.len]                   = '\0';
bl_hdr_serv_locn_code.arr[bl_hdr_serv_locn_code.len]                     = '\0';
bl_hdr_episode_id.arr[bl_hdr_episode_id.len]                             = '\0';
bl_hdr_visit_id.arr[bl_hdr_visit_id.len]                                 = '\0';
bl_hdr_patient_id.arr[bl_hdr_patient_id.len]                             = '\0';

    return(LAST_ROW?0:1);
}

fetch_line()
{
bl_line_prt_grp_hdr_code.arr[0]                                   = '\0';
bl_line_prt_grp_line_code.arr[0]                                  = '\0';
bl_line_gross_amt.arr[0]                                          = '\0';
bl_line_serv_disc_amt.arr[0]                                      = '\0';
bl_line_man_disc_amt.arr[0]                                       = '\0';
bl_line_man_disc_perc.arr[0]                                      = '\0';
bl_line_net_amt.arr[0]                                            = '\0';

bl_line_prt_grp_hdr_code.len                                      = 0;
bl_line_prt_grp_line_code.len                                     = 0;
bl_line_gross_amt.len                                             = 0;
bl_line_serv_disc_amt.len                                         = 0;
bl_line_man_disc_amt.len                                          = 0;
bl_line_man_disc_perc.len                                         = 0;
bl_line_net_amt.len                                               = 0;

bl_line_gross_amt_db                                              = 0;
bl_line_serv_disc_amt_db                                          = 0;
bl_line_man_disc_amt_db                                           = 0;
bl_line_net_amt_db                                                = 0;

     /* EXEC SQL FETCH BL_BILL_LINE_CUR
               INTO :bl_line_prt_grp_hdr_code,
                    :bl_line_prt_grp_line_code,
                    :bl_line_gross_amt,
                    :bl_line_serv_disc_amt,
                    :bl_line_man_disc_amt,
                    :bl_line_man_disc_perc,
                    :bl_line_net_amt,
                    :bl_line_gross_amt_db,
                    :bl_line_serv_disc_amt_db,
                    :bl_line_man_disc_amt_db,
                    :bl_line_net_amt_db; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 37;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )462;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&bl_line_prt_grp_hdr_code;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&bl_line_prt_grp_line_code;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&bl_line_gross_amt;
     sqlstm.sqhstl[2] = (unsigned int  )25;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&bl_line_serv_disc_amt;
     sqlstm.sqhstl[3] = (unsigned int  )25;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&bl_line_man_disc_amt;
     sqlstm.sqhstl[4] = (unsigned int  )25;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&bl_line_man_disc_perc;
     sqlstm.sqhstl[5] = (unsigned int  )17;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&bl_line_net_amt;
     sqlstm.sqhstl[6] = (unsigned int  )25;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&bl_line_gross_amt_db;
     sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&bl_line_serv_disc_amt_db;
     sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&bl_line_man_disc_amt_db;
     sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&bl_line_net_amt_db;
     sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
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
         err_mesg("FETCH failed on cursor BL_BILL_LINE_CUR",0,"");

bl_line_prt_grp_hdr_code.arr[bl_line_prt_grp_hdr_code.len]               = '\0';
bl_line_prt_grp_line_code.arr[bl_line_prt_grp_line_code.len]             = '\0';
bl_line_gross_amt.arr[bl_line_gross_amt.len]                             = '\0';
bl_line_serv_disc_amt.arr[bl_line_serv_disc_amt.len]                     = '\0';
bl_line_man_disc_amt.arr[bl_line_man_disc_amt.len]                       = '\0';
bl_line_man_disc_perc.arr[bl_line_man_disc_perc.len]                     = '\0';
bl_line_net_amt.arr[bl_line_net_amt.len]                                 = '\0';

    return(LAST_ROW?0:1);
}

fetch_dtls()
{
   /* EXEC SQL OPEN BL_PAT_NAME_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 37;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )521;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&bl_hdr_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )23;
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
        err_mesg("OPEN failed on cursor BL_PAT_NAME_CUR",0,"");

   bl_patient_name_loc_lang.arr[0]           = '\0';
   bl_patient_name.arr[0]                    = '\0';
   bl_patient_name1.arr[0]                    = '\0';


   bl_patient_name_loc_lang.len              = 0;
   bl_patient_name.len                       = 0;
   bl_patient_name1.len                       = 0;


    /* EXEC SQL FETCH BL_PAT_NAME_CUR
              INTO :bl_patient_name_loc_lang,
                  /o :bl_patient_name,
				   :bl_patient_name1,o/
                   :d_short_name_full; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )540;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_patient_name_loc_lang;
    sqlstm.sqhstl[0] = (unsigned int  )152;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_short_name_full;
    sqlstm.sqhstl[1] = (unsigned int  )152;
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
         err_mesg("FETCH failed on cursor BL_PAT_NAME_CUR",0,"");

    bl_patient_name_loc_lang.arr[bl_patient_name_loc_lang.len] = '\0';
    bl_patient_name.arr[bl_patient_name.len] = '\0';
	bl_patient_name1.arr[bl_patient_name1.len] = '\0';
    d_short_name_full.arr[d_short_name_full.len]               = '\0';
 
/* EXEC SQL EXECUTE
 BEGIN
 declare
      str1   varchar2(100);
     str2   varchar2(60);
     
    
   BEGIN
     blcommon.split_words(:d_short_name_full,30,'*',1,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_patient_name   :=str2;
       END IF;
    blcommon.split_words(:d_short_name_full,30,'*',2,str1,str2);
       IF str2 IS NOT NULL THEN
         :bl_patient_name1  := str2;
      END IF;
    blcommon.split_words(:d_short_name_full,30,'*',3,str1,str2);
        IF str2 IS NOT NULL THEN
         :bl_patient_name1    := :bl_patient_name1 || str2;
       end if;

	 
     
 END;
  END;
       
   END-EXEC; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 37;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "begin declare str1 varchar2 ( 100 ) ; str2 varchar2 ( 60 ) ; \
BEGIN blcommon . split_words ( :d_short_name_full , 30 , '*' , 1 , str1 , str2\
 ) ; IF str2 IS NOT NULL THEN :bl_patient_name := str2 ; END IF ; blcommon . s\
plit_words ( :d_short_name_full , 30 , '*' , 2 , str1 , str2 ) ; IF str2 IS NO\
T NULL THEN :bl_patient_name1 := str2 ; END IF ; blcommon . split_words ( :d_s\
hort_name_full , 30 , '*' , 3 , str1 , str2 ) ; IF str2 IS NOT NULL THEN :bl_p\
atient_name1 := :bl_patient_name1 || str2 ; end if ; END ; END ;";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )563;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
sqlstm.sqhstl[0] = (unsigned int  )152;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&bl_patient_name;
sqlstm.sqhstl[1] = (unsigned int  )152;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&bl_patient_name1;
sqlstm.sqhstl[2] = (unsigned int  )202;
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


       bl_patient_name.arr[bl_patient_name.len]  = '\0';
       bl_patient_name1.arr[bl_patient_name1.len]  = '\0';



    /* EXEC SQL OPEN BL_SERV_LOCN_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0008;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )590;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_hdr_serv_locn_code;
    sqlstm.sqhstl[0] = (unsigned int  )7;
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
         err_mesg("OPEN failed on cursor BL_SERV_LOCN_CUR",0,"");

    bl_locn_desc.arr[0] = '\0';
    bl_locn_desc.len    = 0;

    /* EXEC SQL FETCH BL_SERV_LOCN_CUR
              INTO :bl_locn_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )609;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_locn_desc;
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
         err_mesg("FETCH failed on cursor BL_SERV_LOCN_CUR",0,"");
    bl_locn_desc.arr[bl_locn_desc.len] = '\0';
}

fetch_dtls1()
{
    /* EXEC SQL OPEN BL_BLNG_PRT_GRP_LINE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0009;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )628;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&bl_line_prt_grp_hdr_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&bl_line_prt_grp_line_code;
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


    if (OERROR)
         err_mesg("OPEN failed on cursor BL_BLNG_PRT_GRP_LINE",0,"");

    bl_prt_grp_desc.arr[0]                                          = '\0';
    bl_prt_grp_desc.len                                             = 0;

    /* EXEC SQL FETCH BL_BLNG_PRT_GRP_LINE
              INTO :bl_prt_grp_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )651;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_prt_grp_desc;
    sqlstm.sqhstl[0] = (unsigned int  )262;
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
         err_mesg("FETCH failed on cursor BL_BLNG_PRT_GRP_LINE",0,"");

   bl_prt_grp_desc.arr[bl_prt_grp_desc.len] = '\0';
}

print_rec(ind)
int ind;
{
  if (ind == 0)
  {
      if (lctr > 53)
          print_head(1);

      fprintf(fp,"%12s  :  %1s ",loc_legend[90],bl_hdr_episode_type.arr);
      switch (bl_hdr_episode_type.arr[0])
      {
         case 'I' : fprintf(fp,"%3s",loc_legend[570]);
                    break;

         case 'O' : fprintf(fp,"%3s",loc_legend[580]);
                    break;

         case 'R' : fprintf(fp,"%3s",loc_legend[590]);
                    break;

         case 'E' : fprintf(fp,"%3s",loc_legend[600]); // EPNH 28/10/2004
                    break;

         case 'D' : fprintf(fp,"%3s",loc_legend[610]);
                    break;
         

         default  : fprintf(fp,"   ");
                    break;
      }
      fprintf(fp,"\n");
      lctr++;
  }
  else if (ind == 1)
  {
      if (lctr > 51)
          print_head(1);
      fetch_dtls();
     /* fprintf(fp,"%2s %-6s/%8s %10s   ",
	  // %s %s %s %s %s %s\n",
                    nd_op_facility_id.arr,
                    bl_hdr_doc_type_code.arr,
                    bl_hdr_doc_num.arr,
                    bl_hdr_doc_date.arr);*/
						init_date_temp_var();                              
              
					  strcpy(date_convert.arr,bl_hdr_doc_date.arr);            
 					  fun_change_loc_date(); 

      fprintf(fp,"%2s %-6s/%-8s %10.10s   ",
	  // %s %s %s %s %s %s\n",
                    nd_op_facility_id.arr,
                    bl_hdr_doc_type_code.arr,
                    bl_hdr_doc_num.arr,
                    date_convert.arr);

					print_formated(bl_hdr_overall_disc_amt_db);
					fprintf(fp,"  ");
					print_formated(bl_hdr_bill_amt_db);
					fprintf(fp,"  ");
					print_formated(bl_hdr_bill_prv_outst_amt_db);
					fprintf(fp,"  ");
					print_formated(bl_hdr_bill_tot_amt_db);
					fprintf(fp,"  ");
					print_formated(bl_hdr_bill_hosp_tot_amt_db);
					fprintf(fp,"  ");
					print_formated(bl_hdr_bill_drfee_tot_amt_db);
	  fprintf(fp,"\n");

/*                    bl_hdr_overall_disc_amt.arr,
                    bl_hdr_bill_amt.arr,
                    bl_hdr_bill_prv_outst_amt.arr,
                    bl_hdr_bill_tot_amt.arr,
                    bl_hdr_bill_hosp_tot_amt.arr,
                    bl_hdr_bill_drfee_tot_amt.arr);*/

/*-- Patient details is printing as 
     < patient id -- patient local name -- short name(english) >
	 Patient local name is mostly blank.
	 Short name will have value.
	 Most of the time it gives a look that a lot of gap there between the 
	 patient id and short name because the local name has no value. 
	 To avoid this I have shifted the short name after the patient id 
	 and the local language name printing is after the short name.
	 VSK 02/05/1999 */
     

      fprintf(fp,"       %1s   %1s   %1s ",
	  //  %s %s %-4s %-15s %-8s %-4s %-10s %-30s %-16s\n",
                    bl_hdr_bill_trx_type_code.arr,
                    bl_hdr_bill_nature_code.arr,
                    bl_hdr_bill_status.arr);
		print_formated(bl_hdr_prepay_adj_amt_db);
        print_formated(bl_hdr_deposit_adj_amt_db);
	  fprintf(fp," %-4s %-15s %-8s %-4s %-20s %-30.30s %-16.16s\n",
                    bl_hdr_serv_locn_code.arr,
                    bl_locn_desc.arr,
                    bl_hdr_episode_id.arr,
                    bl_hdr_visit_id.arr,
                    bl_hdr_patient_id.arr,
                    bl_patient_name.arr,
					bl_patient_name_loc_lang.arr);
   
if(strlen(bl_patient_name1.arr) > 2)
{
 fprintf(fp,"%103s %s \n"," ",bl_patient_name1.arr);
 lctr++;
}
     epi_tot_tot_amt_db       += bl_hdr_bill_tot_amt_db;
     epi_tot_hosp_tot_amt_db  += bl_hdr_bill_hosp_tot_amt_db;
     epi_tot_drfee_tot_amt_db += bl_hdr_bill_drfee_tot_amt_db;

// EPNH 28/10/2004
print_formated(bl_hdr_bill_tot_adjust_amt);
fprintf(fp,"  ");
print_formated(bl_hdr_bill_tot_exempt_amt);
print_formated(bl_hdr_bill_write_off_amt);
fprintf(fp,"  ");

// fprintf(fp,"   %s\n",bl_hdr_added_date.arr);
						init_date_temp_var();                              

					  strcpy(date_convert.arr,bl_hdr_added_date.arr);            
 					  fun_change_loc_date_time(); 

 fprintf(fp,"   %s\n",date_convert.arr);


     lctr+=2;    
   }
   else if (ind == 2)
   {
     if (lctr > 53)
     {
          print_head(1);
          print_line_head();
     }

     fetch_dtls1();

     fprintf(fp,"%-12s%-2s-%-2s %-40s  ",
	 // %s %s %s %s %s\n",
                     " ",
                     bl_line_prt_grp_hdr_code.arr,
                     bl_line_prt_grp_line_code.arr,
                     bl_prt_grp_desc.arr);
	  print_formated(bl_line_gross_amt_db);
	  fprintf(fp," ");
	  print_formated(bl_line_serv_disc_amt_db);
  	  fprintf(fp," ");
	  print_formated(bl_line_man_disc_amt_db);
	  fprintf(fp," ");
	  fprintf(fp," %s", bl_line_man_disc_perc.arr);
	  print_formated(bl_line_net_amt_db);
	  fprintf(fp,"\n");
/*
                     bl_line_gross_amt.arr,
                     bl_line_serv_disc_amt.arr,
                     bl_line_man_disc_amt.arr,
                     bl_line_man_disc_perc.arr,
                     bl_line_net_amt.arr);*/
     lctr++;

     tot_line_gross_amt       += bl_line_gross_amt_db;
     tot_line_serv_disc_amt   += bl_line_serv_disc_amt_db;
     tot_line_man_disc_amt    += bl_line_man_disc_amt_db;
     tot_line_net_amt         += bl_line_net_amt_db;

   }
  
  

   fflush(fp);
}

print_epi_tot()
{
    if (lctr > 52)
       print_head(1);

    fprintf(fp,"%69s              --------------   ---------------    ---------------\n"," ");
    fprintf(fp,"%33s%13s                                     "," ",loc_legend[560]);
    print_formated(epi_tot_tot_amt_db); fprintf(fp,"  ");
    print_formated(epi_tot_hosp_tot_amt_db); fprintf(fp,"  ");
    print_formated(epi_tot_drfee_tot_amt_db);
    fprintf(fp,"\n");
    fprintf(fp,"%69s              --------------   ---------------    --------------\n"," ");
    lctr +=3;

     grn_tot_tot_amt_db       += epi_tot_tot_amt_db;
     grn_tot_hosp_tot_amt_db  += epi_tot_hosp_tot_amt_db;
     grn_tot_drfee_tot_amt_db += epi_tot_drfee_tot_amt_db;

     epi_tot_tot_amt_db        = 0;
     epi_tot_hosp_tot_amt_db   = 0;
     epi_tot_drfee_tot_amt_db  = 0;
}
        
print_grand_tot()
{
    print_epi_tot();

    if (lctr > 52)
       print_head(0);

    fprintf(fp,"%69s              --------------   ---------------    ---------------\n"," ");
    fprintf(fp,"%33s%11s                                       "," ",loc_legend[550]);
    print_formated(grn_tot_tot_amt_db); fprintf(fp,"  ");
    print_formated(grn_tot_hosp_tot_amt_db); fprintf(fp,"  ");
    print_formated(grn_tot_drfee_tot_amt_db);
    fprintf(fp,"\n");
    fprintf(fp,"%69s              --------------   ---------------    ---------------\n"," ");
    lctr +=3;
}
         
print_line_tot()
{
    if (lctr > 52)
       print_head(1);

    fprintf(fp,"%57s  ---------------  --------------  --------------          --------------\n"," ");
    fprintf(fp,"%33s        %5s              "," ",loc_legend[540]);
    print_formated(tot_line_gross_amt); fprintf(fp," ");
    print_formated(tot_line_serv_disc_amt); fprintf(fp," ");
    print_formated(tot_line_man_disc_amt); fprintf(fp,"         ");
    print_formated(tot_line_net_amt);
    fprintf(fp,"\n");   
/* -- one more new line added to give a space line after the total.
	  line counter also incremented by more 1 to move parellel with
	  the physical line increment.  VSK 02/05/1999 */
    fprintf(fp,"%57s  ---------------  --------------  --------------          --------------\n\n"," ");
    lctr +=4;

}
end_of_rep()
{
fprintf(fp,"\n\n                                                      %22s\n",loc_legend[620]);
fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"blrblgen.lis");   
    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrblgen.lis");
       proc_exit();
    }
    print_title();
    print_head(0);
}

print_title()
{


 
  /*----------End Of Addition --------------------------------*/
/*fprintf(fp,
"\fMDL : %2s                                         %-s                                        %-16s\n",loc_legend[150],
hosp_name.arr,date_time.arr);*/

					 init_date_temp_var();                              

					  strcpy(date_convert.arr,date_time.arr);            
 					  fun_change_loc_date_time(); 

fprintf(fp,
"\fMDL : %2s                                         %-s                                        %-16s\n",loc_legend[150],
hosp_name.arr,date_convert.arr);



fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                       %s                                %4s : %4d\n",
loc_legend[40],loc_legend[50],loc_legend[30],++pctr);
fprintf(fp,
"-------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        %16s :\n        ----------------\n\n",loc_legend[80]);
fprintf(fp,"                  %12s           : %s\n\n",loc_legend[90],nd_epi_type.arr);


//fprintf(fp,"                  %9s       %4s   : %s\n",loc_legend[100],loc_legend[60],nd_fm_date_prn.arr);
//fprintf(fp,"                                  %2s     : %s\n\n",loc_legend[70],nd_to_date_prn.arr);

					 init_date_temp_var();                              

					  strcpy(date_convert.arr,nd_fm_date_prn.arr);            
 					  fun_change_loc_date_fm_prn(); 
 fprintf(fp,"                  %9s       %4s   : %-10.10s\n",loc_legend[100],loc_legend[60],date_convert.arr);
 					 init_date_temp_var();                              

					  strcpy(date_convert.arr,nd_to_date_prn.arr);            
 					  fun_change_loc_date_fm_prn(); 
 
 fprintf(fp,"                                  %2s     : %-10.10s\n\n",loc_legend[70],date_convert.arr);

/*----- Corrected By Venkat on 16/5/1999 to Print the 
  -- LOWEST & HIGHEST if the Accepted Bill dates are NULL-----*/

if(nd_fm_cr_date_prn.arr[0] == '\0')
  fprintf(fp,"                  %17s %4s : %6s\n",loc_legend[110],loc_legend[60],loc_legend[120]);
else
  {
  //fprintf(fp,"                  %17s %4s : %s\n",loc_legend[110],loc_legend[60],nd_fm_cr_date_prn.arr);
					 init_date_temp_var();                              

					  strcpy(date_convert.arr,nd_fm_cr_date_prn.arr);            
 					  fun_change_loc_date_time(); 

  fprintf(fp,"                  %17s %4s : %s\n",loc_legend[110],loc_legend[60],date_convert.arr);

  }
if(nd_to_cr_date_prn.arr[0] == '\0')
  fprintf(fp,"                                  %2s     : %7s\n\n",loc_legend[70],loc_legend[120]);
else
{
 // fprintf(fp,"                                  %2s     : %s\n\n",loc_legend[70],nd_to_cr_date_prn.arr);
  					 init_date_temp_var();                              

					  strcpy(date_convert.arr,nd_to_cr_date_prn.arr);            
 					  fun_change_loc_date_time(); 

  fprintf(fp,"                                  %2s     : %s\n\n",loc_legend[70],date_convert.arr);
}
fprintf(fp,"                  %13s   %4s   : %s\n",loc_legend[140],loc_legend[60],nd_fm_doc_type_code.arr);
fprintf(fp,"                                  %2s     : %s\n\n",loc_legend[70],nd_to_doc_type_code.arr);
fprintf(fp,"                  %11s     %4s   : %s\n",loc_legend[160],loc_legend[60],nd_fm_doc_num.arr);
fprintf(fp,"                                  %2s     : %s\n\n",loc_legend[70],nd_to_doc_num.arr);
fprintf(fp,"                  %12s    %4s   : %s\n",loc_legend[170],loc_legend[60],nd_fr_cashcounter.arr);
fprintf(fp,"                                  %2s     : %s\n\n",loc_legend[70],nd_to_cashcounter.arr);
fprintf(fp,"                  %11s     %4s   : %s\n",loc_legend[180],loc_legend[60],nd_fr_facility.arr);
fprintf(fp,"                                  %2s     : %s\n\n",loc_legend[70],nd_to_facility.arr);


/*------ Added on 13/3/1999 to display the Input -----------*/
if(strcmp(nd_show_bill.arr,"V")==0)
	strcpy(nd_show_bill_desc.arr,loc_legend[190]);
if(strcmp(nd_show_bill.arr,"C")==0)
	strcpy(nd_show_bill_desc.arr,loc_legend[200]);
if(strcmp(nd_show_bill.arr,"N")==0)
	strcpy(nd_show_bill_desc.arr,loc_legend[210]);
if(strcmp(nd_show_bill.arr,"A")==0)
	strcpy(nd_show_bill_desc.arr,loc_legend[220]);
/*----------------------------------------------------------*/

fprintf(fp,"                  %s ?       : %s\n\n",loc_legend[230],nd_show_bill_desc.arr);

}

print_head(l_flg)
int l_flg;
{
 
/*fprintf(fp,
"\fMDL : %2s                                         %-s                                        %-16s\n",loc_legend[150],
hosp_name.arr,date_time.arr);*/


					 init_date_temp_var();                              

					  strcpy(date_convert.arr,date_time.arr);            
 					  fun_change_loc_date_time(); 

fprintf(fp,
"\fMDL : %2s                                         %-s                                        %-16s\n",loc_legend[150],
hosp_name.arr,date_convert.arr);


fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                       %s                                %4s : %4d\n",
loc_legend[40],loc_legend[50],loc_legend[30],++pctr);

/* -- The following line is commented and given in different way as
      per the requirement of the user after printing the type of the 
	  bill.  VSK 02/05/1999
fprintf(fp,"                                                   (%-10s TO %-10s)\n",
             nd_fm_date_prn.arr,nd_to_date_prn.arr); */


/*** Added by Aldrin on 05/11/1996 for AMH   ***/             
if(nd_show_bill.arr[0] == 'A')
   fprintf(fp,"     %s",loc_legend[240]);
else if (nd_show_bill.arr[0] == 'C')   
   fprintf(fp,"     %s",loc_legend[250]); 
else if (nd_show_bill.arr[0] == 'V')   
   fprintf(fp,"     %s",loc_legend[260]); 
else if (nd_show_bill.arr[0] == 'N')   
   fprintf(fp,"     %s",loc_legend[270]); 

/* -- Instead of printing the above date range the date range is printed 
      as follows as per the AH user requiremnt. Bill date and created 
	  date range is printed after the type of the bill. VSK 02/05/1999 */


/*fprintf(fp,"        Bill date From %-10s TO %-10s      ",
             nd_fm_date_prn.arr,nd_to_date_prn.arr); */


					 init_date_temp_var();                              

					  strcpy(date_convert.arr,nd_fm_date_prn.arr);            
 					  fun_change_loc_date_fm_prn(); 
 
 fprintf(fp,"        Bill date From %-10.10s TO",
             date_convert.arr);

					 init_date_temp_var();                              

					  strcpy(date_convert.arr,nd_to_date_prn.arr);            
 					  fun_change_loc_date_fm_prn(); 
 fprintf(fp," %-10.10s      ",date_convert.arr);


/*----- Corrected By Venkat on 16/5/1999 to Print the 
  -- LOWEST & HIGHEST if the Accepted Bill dates are NULL-----*/

if(nd_fm_cr_date_prn.arr[0] == '\0')
  fprintf(fp,"%17s %4s %6s",loc_legend[110],loc_legend[60],loc_legend[130]);
else 
{
 // fprintf(fp,"%17s %4s %-16s",loc_legend[110],loc_legend[60],nd_fm_cr_date_prn.arr);
 					 init_date_temp_var();                              

					  strcpy(date_convert.arr,nd_fm_cr_date_prn.arr);            
 					  fun_change_loc_date_time(); 

  fprintf(fp,"%17s %4s %-16s",loc_legend[110],loc_legend[60],date_convert.arr);
}
if(nd_to_cr_date_prn.arr[0] == '\0')
  fprintf(fp," %2s %7s\n\n",loc_legend[70],loc_legend[120]);
else 
{
 // fprintf(fp," %2s %-16s\n\n",loc_legend[70],nd_to_cr_date_prn.arr);
 					 init_date_temp_var();                              

					  strcpy(date_convert.arr,nd_to_cr_date_prn.arr);            
 					  fun_change_loc_date_time(); 
  fprintf(fp," %2s %-16s\n\n",loc_legend[70],date_convert.arr);
}
/*-----------------------------------------------------------*/

// Commented by Aldrin on 05/11/1996    // EPNH 28/10/2004         
//fprintf(fp,"     %s\n",
//        (nd_show_bill.arr[0] == 'Y')?loc_legend[240]:loc_legend[280]);
fprintf(fp,
"-----------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,
"%5s %12s     %9s     %12s        %8s  %14s    %12s       %9s        %8s\n",loc_legend[290],loc_legend[160],loc_legend[100],loc_legend[300],loc_legend[310],loc_legend[320],loc_legend[330],loc_legend[340],loc_legend[350]);
fprintf(fp,
"       %7s %6   %8s         %7s %9s & %4s     %12s  %7s\n",loc_legend[360],loc_legend[370],loc_legend[380],loc_legend[390],loc_legend[400],loc_legend[410],loc_legend[420],loc_legend[430]);
fprintf(fp,"  %12s     %12s     %12s     %17s \n",loc_legend[440],loc_legend[450],loc_legend[460],loc_legend[110]);
fprintf(fp,
"-----------------------------------------------------------------------------------------------------------------------------------------\n");
fflush(fp);
lctr = 13;
 if (l_flg)
    print_rec(0);
}

print_line_head()
{
    if (lctr > 50)
       print_head(1);
// fprintf(fp,"%s\n",bl_hdr_added_date.arr);
   fprintf(fp,"%10s-----------------------------------------------------------------------------------------------------------------------\n"," ");
   fprintf(fp,"%12s%10s & %11s                          %12s    %12s %15s  %4s %%      %10s\n"," ",loc_legend[470],loc_legend[480],loc_legend[490],loc_legend[500],loc_legend[510],loc_legend[520],loc_legend[530]);
   fprintf(fp,"%10s-----------------------------------------------------------------------------------------------------------------------\n\n"," ");
  lctr+=4;
}

fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;


/*-- Y2K correction. Format introduced for year as YYYY instead of YY 
     VSK 15/11/1999 */


    /* EXEC SQL SELECT ACCOUNTING_NAME, 
	                TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
               INTO :hosp_name, 
			   :date_time, 
			   :user_id
               FROM SY_ACC_ENTITY
			   WHERE  ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )670;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&hosp_name;
    sqlstm.sqhstl[0] = (unsigned int  )122;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&date_time;
    sqlstm.sqhstl[1] = (unsigned int  )22;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&user_id;
    sqlstm.sqhstl[2] = (unsigned int  )82;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
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



       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

hosp_name.arr[hosp_name.len]           = '\0';
date_time.arr[date_time.len]           = '\0';
user_id.arr[user_id.len]               = '\0';
}

/*print_formated(loc_amount)
double loc_amount;
{
   char out_str[30],out_str1[30];

   if (loc_amount >= 0)
   {
      sprintf(out_str,"%15.2f",loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s ",out_str1);
   }
   else
   {
      sprintf(out_str,"%15.2f",-loc_amount);
      ltrim(out_str);str_comma(out_str);
      sprintf(out_str1,"%14s",out_str);
      fprintf(fp,"%-14s-",out_str1);
   }
} */

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        strcat(s_amt,"-");
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%14s ",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%14s ",str_amt);
        }

}                        


fetch_legend_value()
{
	for(i=1;i<=900;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRBLGEN.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 37;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRBLGEN.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )701;
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
  sqlstm.sqhstl[1] = (unsigned int  )502;
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
  sqlstm.arrsiz = 37;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )724;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )52;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_pk_value;
  sqlstm.sqhstl[1] = (unsigned int  )502;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_translated_value;
  sqlstm.sqhstl[2] = (unsigned int  )502;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&p_language_id;
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
get_local_date()
{
   	/* EXEC SQL EXECUTE
 
 	
	BEGIN
	
	:nd_loc_date :=sm_convert_date_2t(TO_DATE(:nd_temp_date,'DD/MM/RRRR'),:p_language_id); 

  	END;

	END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin :nd_loc_date := sm_convert_date_2t ( TO_DATE ( :nd_\
temp_date , 'DD/MM/RRRR' ) , :p_language_id ) ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )755;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
    sqlstm.sqhstl[0] = (unsigned int  )18;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
    sqlstm.sqhstl[1] = (unsigned int  )18;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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


        

		//if (OERROR)
        //err_mesg("SELECTING Date failed",0,"");

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

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 

}


get_local_date_time()
{

  	/* EXEC SQL EXECUTE
 
 	
	BEGIN
	
	:nd_loc_date :=sm_convert_datetime_2t(TO_DATE(:nd_temp_date,'DD/MM/YYYY HH24:MI'),:p_language_id);  
  	END;

	END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 37;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin :nd_loc_date := sm_convert_datetime_2t ( TO_DATE ( :\
nd_temp_date , 'DD/MM/YYYY HH24:MI' ) , :p_language_id ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )782;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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


        

		//if (OERROR)
       // err_mesg("SELECTING Date failed",0,"");

}

fun_change_loc_date_time()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date_time();

strcpy(date_convert.arr,nd_loc_date.arr); 

}


get_local_date_fm_prn()
{
  	/* EXEC SQL EXECUTE
 
 	
	BEGIN
	
	:nd_loc_date :=sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/YYYY'),:p_language_id);  
     	
	END;

	END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 37;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin :nd_loc_date := sm_convert_date_2t ( to_date ( :nd_t\
emp_date , 'DD/MM/YYYY' ) , :p_language_id ) ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )809;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_loc_date;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_temp_date;
   sqlstm.sqhstl[1] = (unsigned int  )18;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&p_language_id;
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


        

 

		//if (OERROR)
        //err_mesg("SELECTING Date failed",0,"");

}

fun_change_loc_date_fm_prn()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);

get_local_date_fm_prn();

strcpy(date_convert.arr,nd_loc_date.arr); 

}