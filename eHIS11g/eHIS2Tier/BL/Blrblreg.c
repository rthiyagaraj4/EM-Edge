
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blrblreg.pc"
};


static unsigned int sqlctx = 1288466531;


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
            void  *sqhstv[24];
   unsigned int   sqhstl[24];
            int   sqhsts[24];
            void  *sqindv[24];
            int   sqinds[24];
   unsigned int   sqharm[24];
   unsigned int   *sqharc[24];
   unsigned short  sqadto[24];
   unsigned short  sqtdso[24];
} sqlstm = {12,24};

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
"CODE(:b14,'C','C','A',NVL(BILL_STATUS,'X')) or (NVL(BILL_STATUS,'X')=DECODE(\
:b14,'V',NVL(BILL_STATUS,'X')) and NVL(BILL_STATUS,'X')<>'C'))) and NVL(BILL_S\
TATUS,'X')<>'S') and CASH_COUNTER_CODE between NVL(ltrim(rtrim(substr(:b16,1,2\
))),'  ') and NVL(ltrim(rtrim(substr(:b17,1,2))),'~~')) and OPERATING_FACILITY\
_ID between NVL(ltrim(rtrim(substr(:b18,1,2))),'  ') and NVL(ltrim(rtrim(subst\
r(:b19,1,2))),'~~')) order by OPERATING_FACILITY_ID,CASH_COUNTER_CODE,EPISODE_\
TYPE,PATIENT_ID,TRUNC(DOC_DATE),DOC_TYPE_CODE,DOC_NUM            ";

 static const char *sq0006 = 
"im(rtrim(substr(:b17,1,2))),'~~')) and OPERATING_FACILITY_ID between NVL(ltr\
im(rtrim(substr(:b18,1,2))),'  ') and NVL(ltrim(rtrim(substr(:b19,1,2))),'~~')\
) group by OPERATING_FACILITY_ID,CASH_COUNTER_CODE,DOC_TYPE_CODE,BILL_NATURE_C\
ODE,NVL(BILL_STATUS,'X')           ";

 static const char *sq0007 = 
"select SUBSTR(SHORT_NAME_LOC_LANG,1,16) ,short_name  from MP_PATIENT_MAST wh\
ere PATIENT_ID=:b0           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,197,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,253,0,0,0,0,0,1,0,
51,0,0,3,377,0,4,315,0,0,24,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
162,0,0,4,84,0,2,372,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
189,0,0,5,1555,0,9,496,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
284,0,0,5,0,0,13,546,0,0,18,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,4,0,0,2,4,0,0,2,4,0,0,
371,0,0,6,1291,0,9,601,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
466,0,0,6,0,0,13,620,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,9,0,0,2,9,
0,0,
505,0,0,7,105,0,9,640,0,0,1,1,0,1,0,1,9,0,0,
524,0,0,7,0,0,13,652,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
547,0,0,8,515,0,6,666,0,0,3,3,0,1,0,1,9,0,0,2,9,0,0,3,9,0,0,
574,0,0,9,128,0,4,1152,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
605,0,0,10,144,0,6,1239,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
632,0,0,11,140,0,6,1264,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
659,0,0,12,215,0,6,1303,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 2.0                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRBLREG.PC                                  */
/* AUTHOR                : S. SRIRAM                                    */
/* DATE WRITTEN          : 26-AUG-1993                                  */
/* Converted To Windows  : Prasad B G S          4/7/96                 */
/* Modified by / Date    : V. Srikanth           12/04/1999             */
/* Modified by / Date    : Irfan J.S             06/03/2000             */
/* Modified by / Date    : Irfan J.S             28/03/2000             */
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
            user_id                                    [91],
			nd_pwd [91],
            nd_session_id                              [16],
            nd_pgm_date                                [25],
            d_curr_pgm_name                            [15],
			nd_cc_facility_id						   [3],
			nd_pre_facility_id						   [3],
			nd_op_facility_id							[3],
			nd_cash_counter_code						[3],
			nd_pre_cash_counter_code					[3],
			nd_prd_fm                                  [11],
			nd_prd_to									[11],
            nd_epi_type                                [2],
            nd_fm_date                                 [12],
            nd_to_date                                 [12],
            nd_fm_date_prn                             [12],
            nd_to_date_prn                             [12],
            nd_fm_doc_type_code                        [7],
            nd_to_doc_type_code                        [7],
            nd_fm_doc_num                              [9],
            nd_to_doc_num                              [9],
			nd_fm_cust_code							   [9],
			nd_to_cust_code							   [9],
			nd_fm_blng_grp							   [3],
			nd_to_blng_grp							   [3],
			nd_patient_no_fm						   [21],
		    nd_patient_no_to						   [21],
            nd_show_bill                               [2],  
			nd_operating_facility_id				   [3],
			nd_fr_cashcounter						   [3],
			nd_to_cashcounter                          [3],
			nd_fr_facility							   [3],  
			nd_to_facility							   [3],
            d_short_name_full                          [61],
            bl_patient_name_loc_lang                   [61],
            bl_patient_name                            [61],  
            bl_patient_name1                           [61],
            bl_locn_desc                               [41],  
            bl_prt_grp_desc                            [41]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_cc_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_pre_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_op_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_cash_counter_code;

struct { unsigned short len; unsigned char arr[3]; } nd_pre_cash_counter_code;

struct { unsigned short len; unsigned char arr[11]; } nd_prd_fm;

struct { unsigned short len; unsigned char arr[11]; } nd_prd_to;

struct { unsigned short len; unsigned char arr[2]; } nd_epi_type;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_date;

struct { unsigned short len; unsigned char arr[12]; } nd_to_date;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_date_prn;

struct { unsigned short len; unsigned char arr[12]; } nd_to_date_prn;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[9]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[9]; } nd_fm_cust_code;

struct { unsigned short len; unsigned char arr[9]; } nd_to_cust_code;

struct { unsigned short len; unsigned char arr[3]; } nd_fm_blng_grp;

struct { unsigned short len; unsigned char arr[3]; } nd_to_blng_grp;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_no_fm;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_no_to;

struct { unsigned short len; unsigned char arr[2]; } nd_show_bill;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[3]; } nd_fr_cashcounter;

struct { unsigned short len; unsigned char arr[3]; } nd_to_cashcounter;

struct { unsigned short len; unsigned char arr[3]; } nd_fr_facility;

struct { unsigned short len; unsigned char arr[3]; } nd_to_facility;

struct { unsigned short len; unsigned char arr[61]; } d_short_name_full;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name;

struct { unsigned short len; unsigned char arr[61]; } bl_patient_name1;

struct { unsigned short len; unsigned char arr[41]; } bl_locn_desc;

struct { unsigned short len; unsigned char arr[41]; } bl_prt_grp_desc;
   
            
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
           bl_hdr_patient_id                           [21],
		   bl_hdr_shift_id							   [2]; */ 
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

struct { unsigned short len; unsigned char arr[2]; } bl_hdr_shift_id;


   /* VARCHAR bl_line_prt_grp_hdr_code                    [3],
           bl_line_prt_grp_line_code                   [3],
           bl_line_gross_amt                           [23],
           bl_line_serv_disc_amt                       [23],
           bl_line_man_disc_amt                        [23],
           bl_line_man_disc_perc                       [15],
           bl_line_net_amt                             [23],
		   			nd_temp_date				[21],
			p_language_id				[3],
			date_convert				[21],
			nd_loc_date					[21]; */ 
struct { unsigned short len; unsigned char arr[3]; } bl_line_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } bl_line_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[23]; } bl_line_gross_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_line_serv_disc_amt;

struct { unsigned short len; unsigned char arr[23]; } bl_line_man_disc_amt;

struct { unsigned short len; unsigned char arr[15]; } bl_line_man_disc_perc;

struct { unsigned short len; unsigned char arr[23]; } bl_line_net_amt;

struct { unsigned short len; unsigned char arr[21]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[21]; } date_convert;

struct { unsigned short len; unsigned char arr[21]; } nd_loc_date;


/*------------ 
  SCF 355 VARIABLES 
-------------------*/

	/* VARCHAR m_doc_type_code								[7],
			d_doc_type_code								[7],
            d_bill_nature_code							[2],
			d_bill_status								[2],
			nd_bill_status								[2]; */ 
struct { unsigned short len; unsigned char arr[7]; } m_doc_type_code;

struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[2]; } d_bill_nature_code;

struct { unsigned short len; unsigned char arr[2]; } d_bill_status;

struct { unsigned short len; unsigned char arr[2]; } nd_bill_status;

    
	double  d_bill_tot_amt;

	int     first;

/*--------------
  SCF 355 VARIABLES OVER
  ------------------------*/

double     bl_hdr_bill_tot_amt_db,
           bl_hdr_bill_hosp_tot_amt_db,
           bl_hdr_bill_drfee_tot_amt_db,

           epi_tot_tot_amt_db,
           epi_tot_hosp_tot_amt_db,
           epi_tot_drfee_tot_amt_db,

           grn_tot_tot_amt_db,
           grn_tot_hosp_tot_amt_db,
           grn_tot_drfee_tot_amt_db,

           bl_line_gross_amt_db,
           bl_line_serv_disc_amt_db,
           bl_line_man_disc_amt_db,
           bl_line_net_amt_db,

           tot_valid_cash,
           tot_valid_credit,
           tot_cancel_cash,
           tot_cancel_credit,
	   bl_hdr_bill_tot_adjust_amt  , //EPNH 28/10/2004
           bl_hdr_bill_tot_exempt_amt  ,
           bl_hdr_bill_tot_write_off_amt    ; 

char filename[150];
char string_var[200];
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

int    lctr = 0,pctr = 0,nvalid = 0,ncancel = 0;

FILE *fp;

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
 
    
	
    strcpy(g_pgm_id,"BLRBLREG");
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

/*

    if (sql_connect(argv[1]) == -1)
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

 
    start_prog_msg();

    fetch_prog_param();
    declare_cur();
    fetch_hosp_name();
    open_file();
     
    open_hdr();

    tot_valid_cash   = 0;
    tot_valid_credit = 0;
    tot_cancel_cash  = 0;
    tot_cancel_credit  = 0;
	

    while(fetch_hdr())
    {
     print_rec(1);
    }  
	open_doc_hdr();
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

    nd_epi_type.arr[0]                  = '\0';
    nd_fm_date.arr[0]                   = '\0';
    nd_to_date.arr[0]                   = '\0';
    nd_fm_doc_type_code.arr[0]          = '\0';
    nd_to_doc_type_code.arr[0]          = '\0';
    nd_fm_doc_num.arr[0]                = '\0';
    nd_to_doc_num.arr[0]                = '\0';
    nd_fm_date_prn.arr[0]               = '\0';
    nd_to_date_prn.arr[0]               = '\0';
	nd_fm_cust_code.arr[0]				= '\0';
	nd_to_cust_code.arr[0]				= '\0';
	nd_fm_blng_grp.arr[0]				= '\0';
	nd_to_blng_grp.arr[0]				= '\0';
	nd_patient_no_fm.arr[0]				= '\0';			  
	nd_patient_no_to.arr[0]				= '\0';		
	nd_fr_facility.arr[0]				= '\0';			  
	nd_to_facility.arr[0]				= '\0';		
	nd_fr_cashcounter.arr[0]			= '\0';
	nd_to_cashcounter.arr[0]			= '\0';
	nd_operating_facility_id.arr[0]     = '\0';
	nd_prd_fm.arr[0]					= '\0';
	nd_prd_to.arr[0]                    = '\0';

    nd_epi_type.len                     = 0;
    nd_fm_date.len                      = 0;
    nd_to_date.len                      = 0;
    nd_fm_doc_type_code.len             = 0;
    nd_to_doc_type_code.len             = 0;
    nd_fm_doc_num.len                   = 0;
    nd_to_doc_num.len                   = 0;
    nd_fm_date_prn.len                  = 0;
    nd_to_date_prn.len                  = 0;
	nd_fm_cust_code.len					= 0;
	nd_to_cust_code.len					= 0;
	nd_fm_blng_grp.len					= 0;
	nd_to_blng_grp.len					= 0;
	nd_patient_no_fm.len				= 0;
	nd_patient_no_to.len				= 0;
	nd_fr_facility.len					= 0;			  
	nd_to_facility.len					= 0;		
	nd_fr_cashcounter.len				= 0;
	nd_to_cashcounter.len				= 0;
	nd_operating_facility_id.len        = 0;
	nd_prd_fm.len                       = 0;
	nd_prd_to.len                       = 0;


/*-- Y2K correction. Format introduced for 'FROM AND TO' Date prn variable
     as DD/MM/YYYY in form itself. So, no need to format again below also
	 VSK 14/11/1999 */
/*   Added addtl paramerts to cater for patients range Irfan.J.S 06/03/2000 */

   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
				   PARAM1,PARAM2,PARAM3,PARAM4,
                   PARAM5,PARAM6,PARAM7,PARAM2,PARAM3,
//                 TO_CHAR(TO_DATE(PARAM2,'DD-MON-YY'),'DD/MM/YYYY'),
//                 TO_CHAR(TO_DATE(PARAM3,'DD-MON-YY'),'DD/MM/YYYY'),
				   PARAM8,PARAM9,PARAM10,PARAM11,PARAM12,PARAM13,PARAM14,
				   PARAM15, PARAM16, PARAM17, PARAM18
              INTO :nd_operating_facility_id,
				   :nd_epi_type, 
                   :nd_fm_date,          :nd_to_date,
                   :nd_fm_doc_type_code, :nd_to_doc_type_code,
                   :nd_fm_doc_num,       :nd_to_doc_num,
                   :nd_fm_date_prn,      :nd_to_date_prn,
				   :nd_fm_cust_code,	 :nd_to_cust_code,
				   :nd_fm_blng_grp,		 :nd_to_blng_grp,
				   :nd_patient_no_fm,    :nd_patient_no_to,
				   :nd_bill_status,
				   :nd_fr_cashcounter,   :nd_to_cashcounter,
				   :nd_fr_facility,      :nd_to_facility

              FROM SY_PROG_PARAM
             WHERE PGM_ID     = :d_curr_pgm_name
               AND SESSION_ID = :nd_session_id
               AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM2 ,PARAM3 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,\
PARAM12 ,PARAM13 ,PARAM14 ,PARAM15 ,PARAM16 ,PARAM17 ,PARAM18 into :b0,:b1,:b2\
,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19\
,:b20  from SY_PROG_PARAM where ((PGM_ID=:b21 and SESSION_ID=:b22) and PGM_DAT\
E=:b23)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_epi_type;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_fm_date;
   sqlstm.sqhstl[2] = (unsigned int  )14;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_to_date;
   sqlstm.sqhstl[3] = (unsigned int  )14;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_fm_doc_type_code;
   sqlstm.sqhstl[4] = (unsigned int  )9;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_to_doc_type_code;
   sqlstm.sqhstl[5] = (unsigned int  )9;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fm_doc_num;
   sqlstm.sqhstl[6] = (unsigned int  )11;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_doc_num;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_fm_date_prn;
   sqlstm.sqhstl[8] = (unsigned int  )14;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_to_date_prn;
   sqlstm.sqhstl[9] = (unsigned int  )14;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_fm_cust_code;
   sqlstm.sqhstl[10] = (unsigned int  )11;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_to_cust_code;
   sqlstm.sqhstl[11] = (unsigned int  )11;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_fm_blng_grp;
   sqlstm.sqhstl[12] = (unsigned int  )5;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_to_blng_grp;
   sqlstm.sqhstl[13] = (unsigned int  )5;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_patient_no_fm;
   sqlstm.sqhstl[14] = (unsigned int  )23;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_patient_no_to;
   sqlstm.sqhstl[15] = (unsigned int  )23;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_bill_status;
   sqlstm.sqhstl[16] = (unsigned int  )4;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_fr_cashcounter;
   sqlstm.sqhstl[17] = (unsigned int  )5;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_to_cashcounter;
   sqlstm.sqhstl[18] = (unsigned int  )5;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_fr_facility;
   sqlstm.sqhstl[19] = (unsigned int  )5;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_to_facility;
   sqlstm.sqhstl[20] = (unsigned int  )5;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[21] = (unsigned int  )17;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[22] = (unsigned int  )18;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[23] = (unsigned int  )27;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
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
   nd_fm_doc_type_code.arr[nd_fm_doc_type_code.len]   = '\0';
   nd_to_doc_type_code.arr[nd_to_doc_type_code.len]   = '\0';
   nd_fm_doc_num.arr[nd_fm_doc_num.len]               = '\0';
   nd_to_doc_num.arr[nd_to_doc_num.len]               = '\0';
   nd_fm_date_prn.arr[nd_fm_date_prn.len]             = '\0';
   nd_to_date_prn.arr[nd_to_date_prn.len]             = '\0';
   nd_fm_cust_code.arr[nd_fm_cust_code.len]			  = '\0';
   nd_to_cust_code.arr[nd_to_cust_code.len]			  = '\0';
   nd_fm_blng_grp.arr[nd_fm_blng_grp.len]			  = '\0';
   nd_to_blng_grp.arr[nd_to_blng_grp.len]			  = '\0';
   nd_patient_no_fm.arr[nd_patient_no_fm.len]		  = '\0';
   nd_patient_no_to.arr[nd_patient_no_to.len]		  = '\0';
   nd_operating_facility_id.arr[nd_operating_facility_id.len]='\0';
   nd_fr_facility.arr[nd_fr_facility.len]             = '\0';
   nd_to_facility.arr[nd_to_facility.len]             = '\0';   
   nd_fr_cashcounter.arr[nd_fr_cashcounter.len]       = '\0';   
   nd_fr_cashcounter.arr[nd_fr_cashcounter.len]       = '\0';
   nd_prd_fm.arr[nd_prd_fm.len]						  = '\0';
   nd_prd_to.arr[nd_prd_to.len]						  = '\0';


   strcpy(g_facility_id, nd_operating_facility_id.arr);

   /* EXEC SQL DELETE SY_PROG_PARAM
            WHERE PGM_ID     = :d_curr_pgm_name
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )162;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_curr_pgm_name;
   sqlstm.sqhstl[0] = (unsigned int  )17;
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
   sqlstm.sqhstv[2] = (         void  *)&nd_pgm_date;
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
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");
   
}

declare_cur()
{

/*-- Y2K correction. Format introduced for 'FROM AND TO' Date 
     as DD/MM/YYYY VSK 15/11/1999 */

     /* EXEC SQL DECLARE BL_BILL_HDR_CUR CURSOR FOR
               SELECT EPISODE_TYPE,
			          PATIENT_ID,
					  SHIFT_ID,
					  to_char(TRUNC(DOC_DATE),'DD-MON-YY'),
					  DOC_TYPE_CODE,
                      DOC_NUM,
                      BILL_TRX_TYPE_CODE,
                      BILL_NATURE_CODE,
                      NVL(BILL_STATUS,'X'),
                      EPISODE_ID,
                      VISIT_ID,
					  NVL(BILL_AMT,0),
					  CASH_COUNTER_CODE,
					  CASH_COUNTER_FACILITY_ID,
					  OPERATING_FACILITY_ID,
					  NVL(BILL_TOT_ADJUST_AMT,0),   // EPNH 28/10/2004  
                                          NVL(BILL_TOT_EXEMPT_AMT,0),    
                                          NVL(BILL_TOT_WRITE_OFF_AMT,0)  


                 FROM BL_BILL_HDR
/o -- SCF 86 VSK 12/04/1999 New parameters in Where clause (Custcode/Blng grp id) o/
/o -- SCF 355 Irfan.J.S 06/03/2000 New parameters in Where clause (Patient id and to include all episodes) o/
                 WHERE BLNG_GRP_ID BETWEEN :nd_fm_blng_grp AND :nd_to_blng_grp AND 
					   (CUST_CODE IS NULL OR (CUST_CODE IS NOT NULL AND CUST_CODE BETWEEN :nd_fm_cust_code AND :nd_to_cust_code)) AND
					   TRUNC(DOC_DATE)  BETWEEN
                       NVL(TO_DATE(:nd_fm_date,'DD/MM/YYYY'),to_date('00010101',
                                    'YYYYDDMM'))          AND 
                       NVL(TO_DATE(:nd_to_date,'DD/MM/YYYY'),to_date('47123112',
                                    'YYYYDDMM'))     AND 
					   EPISODE_TYPE = DECODE(:nd_epi_type,'A',EPISODE_TYPE,:nd_epi_type) AND
					   PATIENT_ID  BETWEEN NVL(:nd_patient_no_fm,'!!!!!!!!!!!!!!!!!!!!') AND  NVL(:nd_patient_no_to,'~~~~~~~~~~~~~~~~~~~~') AND
					   RPAD(DOC_TYPE_CODE,6,' ')|| LPAD(DOC_NUM,8,'0')
                       BETWEEN
                       RPAD(NVL(:nd_fm_doc_type_code,' '),6,' ')||
                       LPAD(NVL(:nd_fm_doc_num,0),8,'0')      AND
                       RPAD(NVL(:nd_to_doc_type_code,'~~~~~~'),6,' ')||
                       LPAD(NVL(:nd_to_doc_num,99999999),8,'0')   AND 
					   (NVL(BILL_STATUS,'X') =  DECODE(:nd_bill_status,'C','C','A',NVL(BILL_STATUS,'X'))
					     OR ((NVL(BILL_STATUS,'X') =  DECODE(:nd_bill_status,'V',NVL(BILL_STATUS,'X')) AND  NVL(BILL_STATUS,'X') != 'C') ))
				       AND NVL(BILL_STATUS,'X') != 'S'
					   AND  CASH_COUNTER_CODE BETWEEN NVL(ltrim(rtrim(substr(:nd_fr_cashcounter,1,2))),'  ')
				                        AND NVL(ltrim(rtrim(substr(:nd_to_cashcounter,1,2))),'~~')
					   AND OPERATING_FACILITY_ID  BETWEEN NVL(ltrim(rtrim(substr(:nd_fr_facility,1,2))),'  ')
				                        AND  NVL(ltrim(rtrim(substr(:nd_to_facility,1,2))),'~~')
					   /o 6/8/2001 Irfan corrected for valid,canceled,all bill 
					   (BILL_STATUS IS NULL
                        OR  BILL_STATUS = 'C' OR BILL_STATUS = 'D' OR
                        BILL_STATUS = 'A')  o/
				ORDER BY OPERATING_FACILITY_ID, CASH_COUNTER_CODE,
					   EPISODE_TYPE,PATIENT_ID,TRUNC(DOC_DATE),DOC_TYPE_CODE,DOC_NUM; */ 

                 //ORDER BY DOC_DATE,DOC_TYPE_CODE,DOC_NUM;
  
/*-- CURSOR TO PRINT THE DOCUMENT WISE BREAK TOTAL ALONG WITH GRAND TOTAL
     AHD REQUIREMENT ON SCF 355 */

     /* EXEC SQL DECLARE BL_BILL_HDR_DOC_CUR CURSOR FOR
		SELECT  DOC_TYPE_CODE,
				BILL_NATURE_CODE,
				NVL(BILL_STATUS,'X'),
				SUM(NVL(BILL_AMT,0)),
				CASH_COUNTER_CODE,
				OPERATING_FACILITY_ID
				//SUM(NVL(BILL_TOT_AMT,0))
		FROM    BL_BILL_HDR
		WHERE 	BLNG_GRP_ID BETWEEN :nd_fm_blng_grp AND :nd_to_blng_grp AND 
				(CUST_CODE IS NULL OR (CUST_CODE IS NOT NULL AND CUST_CODE BETWEEN :nd_fm_cust_code AND :nd_to_cust_code)) AND
				TRUNC(DOC_DATE)  BETWEEN
                   NVL(TO_DATE(:nd_fm_date,'DD/MM/YYYY'),to_date('00010101',
                                'YYYYDDMM'))          AND 
                   NVL(TO_DATE(:nd_to_date,'DD/MM/YYYY'),to_date('47123112',
                                'YYYYDDMM'))     AND 
				EPISODE_TYPE = DECODE(:nd_epi_type,'A',EPISODE_TYPE,:nd_epi_type) AND
				PATIENT_ID  BETWEEN NVL(:nd_patient_no_fm,'!!!!!!!!!!') AND     NVL(:nd_patient_no_to,'~~~~~~~~~~') AND
			    RPAD(DOC_TYPE_CODE,6,' ')|| LPAD(DOC_NUM,8,'0')
                       BETWEEN
                       RPAD(NVL(:nd_fm_doc_type_code,' '),6,' ')||
                       LPAD(NVL(:nd_fm_doc_num,0),8,'0')      AND
                       RPAD(NVL(:nd_to_doc_type_code,'~~~~~~'),6,' ')||
                       LPAD(NVL(:nd_to_doc_num,99999999),8,'0')   AND 
					   (NVL(BILL_STATUS,'X') =  DECODE(:nd_bill_status,'C','C','A',NVL(BILL_STATUS,'X'))
					     OR ((NVL(BILL_STATUS,'X') =  DECODE(:nd_bill_status,'V',NVL(BILL_STATUS,'X')) AND  NVL(BILL_STATUS,'X') != 'C') ) )
				        AND NVL(BILL_STATUS,'X') != 'S'
						AND  CASH_COUNTER_CODE BETWEEN NVL(ltrim(rtrim(substr(:nd_fr_cashcounter,1,2))),'  ')
				                        AND NVL(ltrim(rtrim(substr(:nd_to_cashcounter,1,2))),'~~')
						AND  OPERATING_FACILITY_ID  BETWEEN NVL(ltrim(rtrim(substr(:nd_fr_facility,1,2))),'  ')
				                        AND  NVL(ltrim(rtrim(substr(:nd_to_facility,1,2))),'~~')
						/o 6/8/2001 Irfan corrected for valid,canceled,all bill 
					    (BILL_STATUS IS NULL
                        OR  BILL_STATUS = 'C' OR BILL_STATUS = 'D' OR
                        BILL_STATUS = 'A')  o/ 
                 GROUP BY OPERATING_FACILITY_ID, CASH_COUNTER_CODE,
					   DOC_TYPE_CODE,BILL_NATURE_CODE,NVL(BILL_STATUS,'X'); */ 


   
    /* EXEC SQL DECLARE BL_PAT_NAME_CUR CURSOR FOR
              SELECT SUBSTR(SHORT_NAME_LOC_LANG,1,16),
                     /oSUBSTR(SHORT_NAME,1,25),
					 decode(substr(short_name,26,60),NULL,' ',substr(short_name,28,60)) shortname2 ,
                    o/
					short_name
                FROM MP_PATIENT_MAST
                WHERE PATIENT_ID = :bl_hdr_patient_id; */ 

}

open_hdr()
{
    /* EXEC SQL OPEN BL_BILL_HDR_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select EPISODE_TYPE ,PATIENT_ID ,SHIFT_ID ,to_char(TRUNC(DOC_DATE),'D\
D-MON-YY') ,DOC_TYPE_CODE ,DOC_NUM ,BILL_TRX_TYPE_CODE ,BILL_NATURE_CODE ,NV\
L(BILL_STATUS,'X') ,EPISODE_ID ,VISIT_ID ,NVL(BILL_AMT,0) ,CASH_COUNTER_CODE\
 ,CASH_COUNTER_FACILITY_ID ,OPERATING_FACILITY_ID ,NVL(BILL_TOT_ADJUST_AMT,0\
) ,NVL(BILL_TOT_EXEMPT_AMT,0) ,NVL(BILL_TOT_WRITE_OFF_AMT,0)  from BL_BILL_H\
DR where (((((((((BLNG_GRP_ID between :b0 and :b1 and (CUST_CODE is null  or\
 (CUST_CODE is  not null  and CUST_CODE between :b2 and :b3))) and TRUNC(DOC\
_DATE) between NVL(TO_DATE(:b4,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM'))\
 and NVL(TO_DATE(:b5,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))) and EPIS\
ODE_TYPE=DECODE(:b6,'A',EPISODE_TYPE,:b6)) and PATIENT_ID between NVL(:b8,'!\
!!!!!!!!!!!!!!!!!!!') and NVL(:b9,'~~~~~~~~~~~~~~~~~~~~')) and (RPAD(DOC_TYP\
E_CODE,6,' ')||LPAD(DOC_NUM,8,'0')) between (RPAD(NVL(:b10,' '),6,' ')||LPAD\
(NVL(:b11,0),8,'0')) and (RPAD(NVL(:b12,'~~~~~~'),6,' ')||LPAD(NVL(:b13,9999\
9999),8,'0'))) and (NVL(BILL_STATUS,'X')=DE");
    sqlstm.stmt = sq0005;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )189;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_blng_grp;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_blng_grp;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fm_cust_code;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_cust_code;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[4] = (unsigned int  )14;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[5] = (unsigned int  )14;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_epi_type;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_epi_type;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_patient_no_fm;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_patient_no_to;
    sqlstm.sqhstl[9] = (unsigned int  )23;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_fm_doc_type_code;
    sqlstm.sqhstl[10] = (unsigned int  )9;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_fm_doc_num;
    sqlstm.sqhstl[11] = (unsigned int  )11;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_to_doc_type_code;
    sqlstm.sqhstl[12] = (unsigned int  )9;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_to_doc_num;
    sqlstm.sqhstl[13] = (unsigned int  )11;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_bill_status;
    sqlstm.sqhstl[14] = (unsigned int  )4;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_bill_status;
    sqlstm.sqhstl[15] = (unsigned int  )4;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_fr_cashcounter;
    sqlstm.sqhstl[16] = (unsigned int  )5;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_to_cashcounter;
    sqlstm.sqhstl[17] = (unsigned int  )5;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_fr_facility;
    sqlstm.sqhstl[18] = (unsigned int  )5;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_to_facility;
    sqlstm.sqhstl[19] = (unsigned int  )5;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
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
bl_hdr_shift_id.arr[0]                                            = '\0';

bl_hdr_episode_type.len                                           = 0;
bl_hdr_doc_type_code.len                                          = 0;
bl_hdr_doc_num.len                                                = 0;
bl_hdr_doc_date.len                                               = 0;
bl_hdr_bill_trx_type_code.len                                     = 0;
bl_hdr_bill_nature_code.len                                       = 0;
bl_hdr_bill_status.len                                            = 0;
bl_hdr_overall_disc_amt.len                                       = 0;
bl_hdr_bill_amt.len                                              = 0;
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
bl_hdr_shift_id.len												  =0;

      /* EXEC SQL FETCH BL_BILL_HDR_CUR
               INTO :bl_hdr_episode_type,
			        :bl_hdr_patient_id,
					:bl_hdr_shift_id,
					:bl_hdr_doc_date,
                    :bl_hdr_doc_type_code,
                    :bl_hdr_doc_num,
                    :bl_hdr_bill_trx_type_code,
                    :bl_hdr_bill_nature_code,
                    :bl_hdr_bill_status,
                    :bl_hdr_episode_id,
                    :bl_hdr_visit_id,
                    :bl_hdr_bill_tot_amt_db,
					:nd_cash_counter_code,
					:nd_cc_facility_id,
					:nd_op_facility_id,
      			   	        :bl_hdr_bill_tot_adjust_amt , //EPNH 28/10/2004
                                	:bl_hdr_bill_tot_exempt_amt  ,
                                        :bl_hdr_bill_tot_write_off_amt               ; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 24;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )284;
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
      sqlstm.sqhstv[1] = (         void  *)&bl_hdr_patient_id;
      sqlstm.sqhstl[1] = (unsigned int  )23;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&bl_hdr_shift_id;
      sqlstm.sqhstl[2] = (unsigned int  )4;
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
      sqlstm.sqhstv[4] = (         void  *)&bl_hdr_doc_type_code;
      sqlstm.sqhstl[4] = (unsigned int  )9;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&bl_hdr_doc_num;
      sqlstm.sqhstl[5] = (unsigned int  )11;
      sqlstm.sqhsts[5] = (         int  )0;
      sqlstm.sqindv[5] = (         void  *)0;
      sqlstm.sqinds[5] = (         int  )0;
      sqlstm.sqharm[5] = (unsigned int  )0;
      sqlstm.sqadto[5] = (unsigned short )0;
      sqlstm.sqtdso[5] = (unsigned short )0;
      sqlstm.sqhstv[6] = (         void  *)&bl_hdr_bill_trx_type_code;
      sqlstm.sqhstl[6] = (unsigned int  )4;
      sqlstm.sqhsts[6] = (         int  )0;
      sqlstm.sqindv[6] = (         void  *)0;
      sqlstm.sqinds[6] = (         int  )0;
      sqlstm.sqharm[6] = (unsigned int  )0;
      sqlstm.sqadto[6] = (unsigned short )0;
      sqlstm.sqtdso[6] = (unsigned short )0;
      sqlstm.sqhstv[7] = (         void  *)&bl_hdr_bill_nature_code;
      sqlstm.sqhstl[7] = (unsigned int  )4;
      sqlstm.sqhsts[7] = (         int  )0;
      sqlstm.sqindv[7] = (         void  *)0;
      sqlstm.sqinds[7] = (         int  )0;
      sqlstm.sqharm[7] = (unsigned int  )0;
      sqlstm.sqadto[7] = (unsigned short )0;
      sqlstm.sqtdso[7] = (unsigned short )0;
      sqlstm.sqhstv[8] = (         void  *)&bl_hdr_bill_status;
      sqlstm.sqhstl[8] = (unsigned int  )4;
      sqlstm.sqhsts[8] = (         int  )0;
      sqlstm.sqindv[8] = (         void  *)0;
      sqlstm.sqinds[8] = (         int  )0;
      sqlstm.sqharm[8] = (unsigned int  )0;
      sqlstm.sqadto[8] = (unsigned short )0;
      sqlstm.sqtdso[8] = (unsigned short )0;
      sqlstm.sqhstv[9] = (         void  *)&bl_hdr_episode_id;
      sqlstm.sqhstl[9] = (unsigned int  )11;
      sqlstm.sqhsts[9] = (         int  )0;
      sqlstm.sqindv[9] = (         void  *)0;
      sqlstm.sqinds[9] = (         int  )0;
      sqlstm.sqharm[9] = (unsigned int  )0;
      sqlstm.sqadto[9] = (unsigned short )0;
      sqlstm.sqtdso[9] = (unsigned short )0;
      sqlstm.sqhstv[10] = (         void  *)&bl_hdr_visit_id;
      sqlstm.sqhstl[10] = (unsigned int  )7;
      sqlstm.sqhsts[10] = (         int  )0;
      sqlstm.sqindv[10] = (         void  *)0;
      sqlstm.sqinds[10] = (         int  )0;
      sqlstm.sqharm[10] = (unsigned int  )0;
      sqlstm.sqadto[10] = (unsigned short )0;
      sqlstm.sqtdso[10] = (unsigned short )0;
      sqlstm.sqhstv[11] = (         void  *)&bl_hdr_bill_tot_amt_db;
      sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[11] = (         int  )0;
      sqlstm.sqindv[11] = (         void  *)0;
      sqlstm.sqinds[11] = (         int  )0;
      sqlstm.sqharm[11] = (unsigned int  )0;
      sqlstm.sqadto[11] = (unsigned short )0;
      sqlstm.sqtdso[11] = (unsigned short )0;
      sqlstm.sqhstv[12] = (         void  *)&nd_cash_counter_code;
      sqlstm.sqhstl[12] = (unsigned int  )5;
      sqlstm.sqhsts[12] = (         int  )0;
      sqlstm.sqindv[12] = (         void  *)0;
      sqlstm.sqinds[12] = (         int  )0;
      sqlstm.sqharm[12] = (unsigned int  )0;
      sqlstm.sqadto[12] = (unsigned short )0;
      sqlstm.sqtdso[12] = (unsigned short )0;
      sqlstm.sqhstv[13] = (         void  *)&nd_cc_facility_id;
      sqlstm.sqhstl[13] = (unsigned int  )5;
      sqlstm.sqhsts[13] = (         int  )0;
      sqlstm.sqindv[13] = (         void  *)0;
      sqlstm.sqinds[13] = (         int  )0;
      sqlstm.sqharm[13] = (unsigned int  )0;
      sqlstm.sqadto[13] = (unsigned short )0;
      sqlstm.sqtdso[13] = (unsigned short )0;
      sqlstm.sqhstv[14] = (         void  *)&nd_op_facility_id;
      sqlstm.sqhstl[14] = (unsigned int  )5;
      sqlstm.sqhsts[14] = (         int  )0;
      sqlstm.sqindv[14] = (         void  *)0;
      sqlstm.sqinds[14] = (         int  )0;
      sqlstm.sqharm[14] = (unsigned int  )0;
      sqlstm.sqadto[14] = (unsigned short )0;
      sqlstm.sqtdso[14] = (unsigned short )0;
      sqlstm.sqhstv[15] = (         void  *)&bl_hdr_bill_tot_adjust_amt;
      sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[15] = (         int  )0;
      sqlstm.sqindv[15] = (         void  *)0;
      sqlstm.sqinds[15] = (         int  )0;
      sqlstm.sqharm[15] = (unsigned int  )0;
      sqlstm.sqadto[15] = (unsigned short )0;
      sqlstm.sqtdso[15] = (unsigned short )0;
      sqlstm.sqhstv[16] = (         void  *)&bl_hdr_bill_tot_exempt_amt;
      sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[16] = (         int  )0;
      sqlstm.sqindv[16] = (         void  *)0;
      sqlstm.sqinds[16] = (         int  )0;
      sqlstm.sqharm[16] = (unsigned int  )0;
      sqlstm.sqadto[16] = (unsigned short )0;
      sqlstm.sqtdso[16] = (unsigned short )0;
      sqlstm.sqhstv[17] = (         void  *)&bl_hdr_bill_tot_write_off_amt;
      sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
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
            err_mesg("FETCH failed on cursor BL_BILL_HDR_CUR",0,"");

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
bl_hdr_shift_id.arr[bl_hdr_shift_id.len]								 = '\0';
nd_cash_counter_code.arr[nd_cash_counter_code.len]                         = '\0';
nd_cc_facility_id.arr[nd_cc_facility_id.len]                         = '\0';
nd_op_facility_id.arr[nd_op_facility_id.len]                         = '\0';


    return(LAST_ROW?0:1);
}

open_doc_hdr()
{
    /* EXEC SQL OPEN BL_BILL_HDR_DOC_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select DOC_TYPE_CODE ,BILL_NATURE_CODE ,NVL(BILL_STATUS,'X') ,sum(NVL\
(BILL_AMT,0)) ,CASH_COUNTER_CODE ,OPERATING_FACILITY_ID  from BL_BILL_HDR wh\
ere (((((((((BLNG_GRP_ID between :b0 and :b1 and (CUST_CODE is null  or (CUS\
T_CODE is  not null  and CUST_CODE between :b2 and :b3))) and TRUNC(DOC_DATE\
) between NVL(TO_DATE(:b4,'DD/MM/YYYY'),to_date('00010101','YYYYDDMM')) and \
NVL(TO_DATE(:b5,'DD/MM/YYYY'),to_date('47123112','YYYYDDMM'))) and EPISODE_T\
YPE=DECODE(:b6,'A',EPISODE_TYPE,:b6)) and PATIENT_ID between NVL(:b8,'!!!!!!\
!!!!') and NVL(:b9,'~~~~~~~~~~')) and (RPAD(DOC_TYPE_CODE,6,' ')||LPAD(DOC_N\
UM,8,'0')) between (RPAD(NVL(:b10,' '),6,' ')||LPAD(NVL(:b11,0),8,'0')) and \
(RPAD(NVL(:b12,'~~~~~~'),6,' ')||LPAD(NVL(:b13,99999999),8,'0'))) and (NVL(B\
ILL_STATUS,'X')=DECODE(:b14,'C','C','A',NVL(BILL_STATUS,'X')) or (NVL(BILL_S\
TATUS,'X')=DECODE(:b14,'V',NVL(BILL_STATUS,'X')) and NVL(BILL_STATUS,'X')<>'\
C'))) and NVL(BILL_STATUS,'X')<>'S') and CASH_COUNTER_CODE between NVL(ltrim\
(rtrim(substr(:b16,1,2))),'  ') and NVL(ltr");
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )371;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fm_blng_grp;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_blng_grp;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_fm_cust_code;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_to_cust_code;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_fm_date;
    sqlstm.sqhstl[4] = (unsigned int  )14;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_to_date;
    sqlstm.sqhstl[5] = (unsigned int  )14;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_epi_type;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_epi_type;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_patient_no_fm;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_patient_no_to;
    sqlstm.sqhstl[9] = (unsigned int  )23;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_fm_doc_type_code;
    sqlstm.sqhstl[10] = (unsigned int  )9;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_fm_doc_num;
    sqlstm.sqhstl[11] = (unsigned int  )11;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_to_doc_type_code;
    sqlstm.sqhstl[12] = (unsigned int  )9;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_to_doc_num;
    sqlstm.sqhstl[13] = (unsigned int  )11;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_bill_status;
    sqlstm.sqhstl[14] = (unsigned int  )4;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_bill_status;
    sqlstm.sqhstl[15] = (unsigned int  )4;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_fr_cashcounter;
    sqlstm.sqhstl[16] = (unsigned int  )5;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_to_cashcounter;
    sqlstm.sqhstl[17] = (unsigned int  )5;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_fr_facility;
    sqlstm.sqhstl[18] = (unsigned int  )5;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_to_facility;
    sqlstm.sqhstl[19] = (unsigned int  )5;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
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
         err_mesg("OPEN failed on cursor BL_BILL_HDR_DOC_CUR",0,"");
}

fetch_doc_hdr()
{

d_doc_type_code.arr[0]                                       = '\0';
d_bill_nature_code.arr[0]                                    = '\0';
d_bill_status.arr[0]                                         = '\0';

d_doc_type_code.len                                          = 0;
d_bill_nature_code.len                                       = 0;
d_bill_status.len                                            = 0;

d_bill_tot_amt = 0.0;


      /* EXEC SQL FETCH BL_BILL_HDR_DOC_CUR
               INTO :d_doc_type_code,
                    :d_bill_nature_code,
                    :d_bill_status,
                    :d_bill_tot_amt,
					:nd_cash_counter_code,
					:nd_op_facility_id; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 24;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )466;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqfoff = (           int )0;
      sqlstm.sqfmod = (unsigned int )2;
      sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
      sqlstm.sqhstl[0] = (unsigned int  )9;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_bill_nature_code;
      sqlstm.sqhstl[1] = (unsigned int  )4;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqhstv[2] = (         void  *)&d_bill_status;
      sqlstm.sqhstl[2] = (unsigned int  )4;
      sqlstm.sqhsts[2] = (         int  )0;
      sqlstm.sqindv[2] = (         void  *)0;
      sqlstm.sqinds[2] = (         int  )0;
      sqlstm.sqharm[2] = (unsigned int  )0;
      sqlstm.sqadto[2] = (unsigned short )0;
      sqlstm.sqtdso[2] = (unsigned short )0;
      sqlstm.sqhstv[3] = (         void  *)&d_bill_tot_amt;
      sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
      sqlstm.sqhsts[3] = (         int  )0;
      sqlstm.sqindv[3] = (         void  *)0;
      sqlstm.sqinds[3] = (         int  )0;
      sqlstm.sqharm[3] = (unsigned int  )0;
      sqlstm.sqadto[3] = (unsigned short )0;
      sqlstm.sqtdso[3] = (unsigned short )0;
      sqlstm.sqhstv[4] = (         void  *)&nd_cash_counter_code;
      sqlstm.sqhstl[4] = (unsigned int  )5;
      sqlstm.sqhsts[4] = (         int  )0;
      sqlstm.sqindv[4] = (         void  *)0;
      sqlstm.sqinds[4] = (         int  )0;
      sqlstm.sqharm[4] = (unsigned int  )0;
      sqlstm.sqadto[4] = (unsigned short )0;
      sqlstm.sqtdso[4] = (unsigned short )0;
      sqlstm.sqhstv[5] = (         void  *)&nd_op_facility_id;
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


                      
       if (OERROR)
            err_mesg("FETCH failed on cursor BL_BILL_HDR_DOC_CUR",0,"");
  
d_doc_type_code.arr[d_doc_type_code.len]                                    = '\0';
d_bill_nature_code.arr[d_bill_nature_code.len]                              = '\0';
d_bill_status.arr[d_bill_status.len]                                        = '\0';
return(LAST_ROW?0:1);
}


fetch_dtls()
{
   /* EXEC SQL OPEN BL_PAT_NAME_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0007;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )505;
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
                  /o:bl_patient_name,
				  :bl_patient_name1,o/
                   :d_short_name_full; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )524;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&bl_patient_name_loc_lang;
    sqlstm.sqhstl[0] = (unsigned int  )63;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_short_name_full;
    sqlstm.sqhstl[1] = (unsigned int  )63;
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
sqlstm.arrsiz = 24;
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
sqlstm.offset = (unsigned int  )547;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&d_short_name_full;
sqlstm.sqhstl[0] = (unsigned int  )63;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&bl_patient_name;
sqlstm.sqhstl[1] = (unsigned int  )63;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&bl_patient_name1;
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
}


       bl_patient_name.arr[bl_patient_name.len]  = '\0';
       bl_patient_name1.arr[bl_patient_name1.len]  = '\0';


}



print_rec(ind)
int ind;
{
  if (lctr > 65) {
     print_head(1);
     //fprintf(fp,"\n");
     lctr = 13;

 
  }
  fetch_dtls();
  /*  fprintf(fp,"%s %s/%-8s/%s  %-20s %-20.20s %s/%s/%s ",
                    bl_hdr_doc_date.arr,
                    bl_hdr_doc_type_code.arr,
                    bl_hdr_doc_num.arr,
                    bl_hdr_bill_trx_type_code.arr,
                    bl_hdr_patient_id.arr,
                    bl_patient_name.arr,
                    bl_hdr_episode_type.arr,
                    bl_hdr_episode_id.arr,
                    bl_hdr_visit_id.arr); */
 
 /*--For notations width spedified to maintain the width even there is 
     less value VSL 08/05/1999 */

  /*       if (lctr > 51)
               print_head(1);
*/
       if (!nd_pre_facility_id.arr)
         {
          strcpy(nd_pre_facility_id.arr,nd_op_facility_id.arr);
          strcpy(nd_pre_cash_counter_code.arr,nd_cash_counter_code.arr);
         }
       if (strcmp(nd_pre_facility_id.arr,nd_op_facility_id.arr)!=0) 
          {
            strcpy(nd_pre_facility_id.arr,nd_op_facility_id.arr);
            fprintf(fp,"\nFacility Id :  %2s\n" ,nd_op_facility_id.arr);          
            lctr++;
			lctr++;
            nd_pre_cash_counter_code.arr[0] = '\0';	    
          }

       if (strcmp(nd_pre_cash_counter_code.arr,nd_cash_counter_code.arr)!=0)
          {
            strcpy(nd_pre_cash_counter_code.arr,nd_cash_counter_code.arr);
            fprintf(fp,"\nCash Counter Code  :  %2s\n" ,nd_cash_counter_code.arr);          
            lctr++;
			lctr++;
          }   
  
   		  init_date_temp_var();                              
	      strcpy(date_convert.arr,bl_hdr_doc_date.arr);    
          fun_change_loc_date_format();
		//fprintf(fp,"%-10s %-6s/%-8s/%-1s %-10s %-27s %-1s/%-9s/%-5s",
	fprintf(fp,"%-2s %-9.9s %-6s/%-8s/%-1s %-20.20s %-25.25s %-s/%-8s/%-4s %-1s",
                    nd_op_facility_id.arr, 
					date_convert.arr,
					//bl_hdr_doc_date.arr, 
                    bl_hdr_doc_type_code.arr, 
                    bl_hdr_doc_num.arr, 
                    bl_hdr_bill_trx_type_code.arr, 
                    bl_hdr_patient_id.arr, 
                    bl_patient_name.arr, 
                    bl_hdr_episode_type.arr,     
                    bl_hdr_episode_id.arr, 
					bl_hdr_visit_id.arr, 
					bl_hdr_shift_id.arr);  

     fprintf(fp,"  ");
     print_formated(bl_hdr_bill_tot_adjust_amt);  //EPNH 28/10/2004
     fprintf(fp," ");
     print_formated(bl_hdr_bill_tot_exempt_amt);
     fprintf(fp," ");
     print_formated(bl_hdr_bill_tot_write_off_amt);

    
    if(strcmp(bl_hdr_bill_status.arr,"C") == 0) 
      {
       ncancel = ncancel + 1;       ;
       if(strcmp(bl_hdr_bill_nature_code.arr,"C")==0) {
          tot_cancel_cash  = tot_cancel_cash + bl_hdr_bill_tot_amt_db;
          fprintf(fp,"                                ");
          print_formated(bl_hdr_bill_tot_amt_db);
          fprintf(fp,"\n");
         }
        else if(strcmp(bl_hdr_bill_nature_code.arr,"A") ==0) {
          tot_cancel_credit  = tot_cancel_credit + bl_hdr_bill_tot_amt_db;
          fprintf(fp,"                                               ");
          print_formated(bl_hdr_bill_tot_amt_db);
          fprintf(fp,"\n");
         }
      }
    else 
      {
       nvalid = nvalid + 1;
       if(strcmp(bl_hdr_bill_nature_code.arr,"C")==0) { 
          tot_valid_cash   = tot_valid_cash + bl_hdr_bill_tot_amt_db;
          print_formated(bl_hdr_bill_tot_amt_db); 
          fprintf(fp,"\n");
         }
       else if(strcmp(bl_hdr_bill_nature_code.arr,"A") ==0)
         {
          tot_valid_credit = tot_valid_credit + bl_hdr_bill_tot_amt_db;
          fprintf(fp,"                ");
          print_formated(bl_hdr_bill_tot_amt_db);
          fprintf(fp,"\n");
         }
       
       } 
if(strlen(bl_patient_name1.arr) > 2)
{
 fprintf(fp,"%52s %s \n"," ",bl_patient_name1.arr);
 lctr++;
}

 

    lctr+=1;  
      
}  
print_grand_tot()
{
    if (lctr > 65)
       print_head(0);

    fprintf(fp,"%140s               -------------  ---------------  --------------  -------------\n"," ");
	fprintf(fp,"%112s %-7s  TOTAL          :            "," "," GRAND");
    print_formated(tot_valid_cash);    
    print_formated(tot_valid_credit);  
    print_formated(tot_cancel_cash);   
    print_formated(tot_cancel_credit); 
    fprintf(fp,"\n");
    fprintf(fp,"%140s               -------------  ---------------  --------------  -------------\n"," ");
    lctr +=3;

	first = 1;
	m_doc_type_code.arr[0] = '\0';
	tot_valid_cash = 0;
	tot_valid_credit = 0;
	tot_cancel_cash = 0;
	tot_cancel_credit = 0;
	
	while(fetch_doc_hdr())
	{
		if (first)
		{
			strcpy(m_doc_type_code.arr,d_doc_type_code.arr);
			first = 0;
		}

	   
	   if(strcmp(m_doc_type_code.arr,d_doc_type_code.arr) != 0) 
	   {
			 if (lctr > 65)
					print_head(0);
    fprintf(fp,"%140s               -------------  ---------------  --------------  -------------\n"," ");
			fprintf(fp,"%112s(%-7s) TOTAL          :            "," ",m_doc_type_code.arr);
			print_formated(tot_valid_cash);   
			print_formated(tot_valid_credit); 
			print_formated(tot_cancel_cash); 
			print_formated(tot_cancel_credit); 
			fprintf(fp,"\n");
    fprintf(fp,"%140s               -------------  ---------------  --------------  -------------\n"," ");
			lctr +=3;
			strcpy(m_doc_type_code.arr,d_doc_type_code.arr);	
			tot_valid_cash = 0;
			tot_valid_credit = 0;
			tot_cancel_cash = 0;
			tot_cancel_credit = 0;

	   }
	   
	    
	    if(strcmp(d_bill_status.arr,"C") == 0) 
		{
			if(strcmp(d_bill_nature_code.arr,"C")==0) 
				tot_cancel_cash  = tot_cancel_cash + d_bill_tot_amt;
			else if(strcmp(d_bill_nature_code.arr,"A") ==0) 
	            tot_cancel_credit  = tot_cancel_credit + d_bill_tot_amt;
		} 
	    else 
		{
	       if(strcmp(d_bill_nature_code.arr,"C")==0)  
				tot_valid_cash   = tot_valid_cash + d_bill_tot_amt;
	       else if(strcmp(d_bill_nature_code.arr,"A") ==0)
		        tot_valid_credit = tot_valid_credit + d_bill_tot_amt;
        }
        
	   
   }

   if (lctr > 65)
		print_head(0);
    fprintf(fp,"%140s               -------------  ---------------  --------------  -------------\n"," ");
			fprintf(fp,"%112s(%-7s) TOTAL          :            "," ",m_doc_type_code.arr);
			print_formated(tot_valid_cash);  
			print_formated(tot_valid_credit);
			print_formated(tot_cancel_cash);  
			print_formated(tot_cancel_credit); 
			fprintf(fp,"\n");
    fprintf(fp,"%140s               -------------  ---------------  --------------  -------------\n"," ");
			lctr +=3;
			strcpy(m_doc_type_code.arr,d_doc_type_code.arr);	
			tot_valid_cash = 0;
			tot_valid_credit = 0;
			tot_cancel_cash = 0;
			tot_cancel_credit = 0;

   fprintf(fp,"\n\n");
   lctr +=2;
   fprintf(fp,"%165sNUMBER OF VALID BILLS    : %d\n"," ",nvalid);
   fprintf(fp,"%165sNUMBER OF CANCELLED BILLS: %d\n"," ",ncancel);
                
}


end_of_rep()
{
fprintf(fp,"\n\n                                                      ***  END OF REPORT ***\n\f");
fflush(fp);
}

open_file()
{

    strcpy(filename,WORKING_DIR);
	strcat(filename,"blrblreg.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file blrblreg.lis");
       proc_exit();
    }
    print_title();
    print_head(0);
}

print_title()
{
/*fprintf(fp,
"MDL : BL                                         %-30s                                       %-16s\n",
hosp_name.arr,date_time.arr);*/
		  init_date_temp_var();                              
	      strcpy(date_convert.arr,date_time.arr);      
	      fun_change_loc_date_time();

fprintf(fp,
"MDL : BL                                         %-30s                                       %-16s\n",
hosp_name.arr,date_convert.arr);

fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                       %s                                PAGE : %4d\n",
"BLRBLREG","                   BILL REGISTER                     ",++pctr);
fprintf(fp,
"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"VER : 4.1\n");
fflush(fp);

fprintf(fp,"\n\n\n\n        INPUT PARAMETERS :\n        ----------------\n\n");
if (nd_epi_type.arr[0] == 'I') 
    fprintf(fp,"\t\t        EPISODE TYPE          :%s\n"," INPATIENTS");
	else if (nd_epi_type.arr[0] == 'O') 
    fprintf(fp,"\t\t        EPISODE TYPE          :%s\n"," OUTPATIENTS");
	else if (nd_epi_type.arr[0] == 'R') 
    fprintf(fp,"\t\t        EPISODE TYPE          :%s\n"," REFERRALS");
	else if (nd_epi_type.arr[0] == 'A') 
    fprintf(fp,"\t\t        EPISODE TYPE          :%s\n"," ALL PATIENTS");
	else if (nd_epi_type.arr[0] == 'D')   //EPNH 28/10/2004
    fprintf(fp,"\t\t        EPISODE TYPE          :%s\n"," DAY CARE");
	else if (nd_epi_type.arr[0] == 'E')   //EPNH 28/10/2004
    fprintf(fp,"\t\t        EPISODE TYPE          :%s\n"," EMERGENCY");


fprintf(fp,"\n");
	
if (nd_fm_date_prn.arr[0] == '\0') 
	fprintf(fp,"\t\t        BILL DATE        FROM :%s\n"," LOWEST");
	else
	{
		  init_date_temp_var();                              
	      strcpy(date_convert.arr,nd_fm_date_prn.arr);      
	      fun_change_loc_date();

	//fprintf(fp,"\t\t        BILL DATE        FROM :%-10s\n",nd_fm_date_prn.arr);
	fprintf(fp,"\t\t        BILL DATE        FROM :%-10.10s\n",date_convert.arr);
	}
	if (nd_to_date_prn.arr[0] == '\0') 
    fprintf(fp,"\t\t                         TO   :%s\n\n"," HIGHEST");
	else
	{
		  init_date_temp_var();                              
	      strcpy(date_convert.arr,nd_to_date_prn.arr);      
	      fun_change_loc_date();
//	fprintf(fp,"\t\t                         TO   :%-10s\n\n",nd_to_date_prn.arr);
	fprintf(fp,"\t\t                         TO   :%-10.10s\n\n",date_convert.arr);
    }
if (nd_fm_doc_type_code.arr[0] == '\0' ||  nd_fm_doc_num.arr[0] == '\0' ) 
	fprintf(fp,"\t\t        DOC TYPE/NUMBER  FROM : %s\n","LOWEST");
	else
	fprintf(fp,"\t\t        DOC TYPE/NUMBER  FROM : %4s - %4s\n",nd_fm_doc_type_code.arr,nd_fm_doc_num.arr);
	
	if (nd_to_doc_type_code.arr[0] == '\0' || nd_to_doc_num.arr[0] == '\0') 
    fprintf(fp,"\t\t                         TO   : %s\n\n","HIGHEST");
	else
	fprintf(fp,"\t\t                         TO   : %4s - %4s\n",nd_to_doc_type_code.arr,nd_to_doc_num.arr);
	

//fprintf(fp,"                  EPISODE TYPE         : %s\n\n",nd_epi_type.arr);
//fprintf(fp,"                  BILL DATE       FROM : %s\n",nd_fm_date_prn.arr);
//fprintf(fp,"                                  TO   : %s\n\n",nd_to_date_prn.arr);
//fprintf(fp,"                  BILL DOC TYPE   FROM : %s\n",nd_fm_doc_type_code.arr);
//fprintf(fp,"                                  TO   : %s\n\n",nd_to_doc_type_code.arr);
//fprintf(fp,"                  BILL NUMBER     FROM : %s\n",nd_fm_doc_num.arr);
//fprintf(fp,"                                  TO   : %s\n\n",nd_to_doc_num.arr);

/* -- SCF 86 VSK 12/04/1999 New parameters in front sheet */

if (nd_fm_cust_code.arr[0] == '!')
	fprintf(fp,"\t\t        CUSTOMER CODE    FROM : %s\n","LOWEST ");
else
	fprintf(fp,"\t\t        CUSTOMER CODE    FROM : %s\n",nd_fm_cust_code.arr);

if (nd_to_cust_code.arr[0] == '~')
	fprintf(fp,"\t\t                         TO   : %s\n\n","HIGHEST");
else
	fprintf(fp,"\t\t                         TO   : %s\n\n",nd_to_cust_code.arr);

if (nd_fm_blng_grp.arr[0] == '!')
	fprintf(fp,"\t\t        BILLING GROUP    FROM : %s\n","LOWEST");
else
	fprintf(fp,"\t\t        BILLING GROUP    FROM : %s\n",nd_fm_blng_grp.arr);

if (nd_to_blng_grp.arr[0] == '~')
	fprintf(fp,"\t\t                         TO   : %s\n\n","HIGHEST");
else
	fprintf(fp,"\t\t                         TO   : %s\n\n",nd_to_blng_grp.arr);

if (nd_patient_no_fm.arr[0] == '\0') 
	fprintf(fp,"\t\t        PATIENT NO       FROM : %s\n","LOWEST");
else
	fprintf(fp,"\t\t        PATIENT NO       FROM : %-12s\n",nd_patient_no_fm.arr);
	
if (nd_patient_no_to.arr[0] == '\0') 
    fprintf(fp,"\t\t                         TO   : %s\n\n","HIGHEST");
else
    fprintf(fp,"\t\t                         TO   : %-12s\n\n",nd_patient_no_to.arr);

if (nd_fr_facility.arr[0] == '\0') 
	fprintf(fp,"\t\t        FACILITY ID      FROM : %s\n","LOWEST");
else
	fprintf(fp,"\t\t        FACILITY ID      FROM : %-12s\n",nd_fr_facility.arr);
	
if (nd_to_facility.arr[0] == '\0') 
    fprintf(fp,"\t\t                         TO   : %s\n\n","HIGHEST");
else
    fprintf(fp,"\t\t                         TO   : %-12s\n\n",nd_to_facility.arr);

if (nd_fr_cashcounter.arr[0] == '\0') 
	fprintf(fp,"\t\t        CASH COUNTER     FROM : %s\n","LOWEST");
else
	fprintf(fp,"\t\t        CASH COUNTER     FROM : %-12s\n",nd_fr_cashcounter.arr);
	
if (nd_fr_cashcounter.arr[0] == '\0') 
    fprintf(fp,"\t\t                         TO   : %s\n\n","HIGHEST");
else
    fprintf(fp,"\t\t                         TO   : %-12s\n\n",nd_fr_cashcounter.arr);

if (nd_bill_status.arr[0] == 'C') 
	fprintf(fp,"\t\t        BILLS                 : %s\n","CANCELLED BILLS");

if (nd_bill_status.arr[0] == 'V') 
	fprintf(fp,"\t\t        BILLS                 : %s\n","VALID BILLS");

if (nd_bill_status.arr[0] == 'A') 
	fprintf(fp,"\t\t        BILLS                 : %s\n","ALL BILLS");


fprintf(fp,"\n");

}


print_head(l_flg)
int l_flg;
{
/*fprintf(fp,
"\fMDL : BL                                         %-30s                                       %-16s\n",
hosp_name.arr,date_time.arr);*/
		  init_date_temp_var();                              
	      strcpy(date_convert.arr,date_time.arr);      
	      fun_change_loc_date_time();

fprintf(fp,
"\fMDL : BL                                         %-30s                                       %-16s\n",
hosp_name.arr,date_convert.arr);

fprintf(fp,"OPR : %-10s \n", user_id.arr);
fprintf(fp,
"REP : %-8s                       %s                                PAGE : %4d\n",
"BLRBLREG","                     BILL REGISTER                   ",++pctr);

 if (nd_fm_date_prn.arr[0] == '\0') 
     strcpy(nd_prd_fm.arr,"LOWEST");
 else
 {
     		  init_date_temp_var();                              
	      strcpy(date_convert.arr,nd_fm_date_prn.arr);      
	      fun_change_loc_date(); 
	 //strcpy(nd_prd_fm.arr,nd_fm_date_prn.arr);
   }
fprintf(fp,"                                           FOR THE PERIOD (%-10.10s TO", 
               date_convert.arr);


  if (nd_fm_date_prn.arr[0] == '\0') 
      strcpy(nd_prd_to.arr,"HIGHEST");
  else
  {     		  init_date_temp_var();                              
	      strcpy(date_convert.arr,nd_to_date_prn.arr);      
	      fun_change_loc_date();

      //strcpy(nd_prd_to.arr,date_convert.arr);
	 }
fprintf(fp," %-10.10s)\n",date_convert.arr);

//fprintf(fp,"                                           FOR THE PERIOD (%-10.10s TO %-10.10s)\n",
/*             nd_fm_date_prn.arr,nd_to_date_prn.arr);*/
             //  date_convert.arr, nd_prd_to.arr);

fprintf(fp,"---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
fprintf(fp,"FAC. BILL       BILL NUMBER       PATIENT NO & NAME                            EPISODE TYPE  SHIFT    BILL ADJ AMT    BILL EXM AMT        BILL WRT OFF       VALID BILLS --------->      CANCELLED BILLS ------------>\n");
fprintf(fp,"ID   DATE       NUMBER & TYPE                                                  /ID VISIT NO   NO                                                               CASH         CREDIT            CASH            CREDIT  \n");
fprintf(fp,"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
fflush(fp);
lctr = 13;
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
     VSK 14/11/1999 */

    /* EXEC SQL SELECT ACCOUNTING_NAME, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                    USER
             INTO :hosp_name, :date_time, :user_id
             FROM SY_ACC_ENTITY
			 WHERE ACC_ENTITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 24;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACCOUNTING_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )574;
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
    sqlstm.sqhstl[2] = (unsigned int  )93;
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



       if (OERROR) err_mesg("SELECT failed on table SY_ACC_ENTITY",0,"");

hosp_name.arr[hosp_name.len]           = '\0';
date_time.arr[date_time.len]           = '\0';
user_id.arr[user_id.len]               = '\0';
}
/*
print_formated(loc_amount)
double loc_amount;
{
   char out_str[15],out_str1[15];

   if (loc_amount >= 0)
   {
      sprintf(out_str,"%15.2f",loc_amount);
      str_comma(out_str);
      sprintf(out_str1,"%15s",out_str);
      fprintf(fp,"%-15s",out_str1);
   }
   else
   {
      sprintf(out_str,"%15.2f",loc_amount);
      str_comma(out_str);
      sprintf(out_str1,"%15s",out_str);
      fprintf(fp,"%-15s",out_str1);
   }
}
*/
print_formated(loc_amount)
double loc_amount;
{
	char s_amt[15], str_amt[15];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        strcat(s_amt,"-");
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15s ",str_amt);
        }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%15s",s_amt);
        fprintf(fp,"%15s ",str_amt);
        }

}                        

fun_change_loc_date_time()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);


get_local_date_time();


strcpy(date_convert.arr,nd_loc_date.arr);


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

get_local_date_time()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	

	:nd_loc_date :=  	sm_convert_datetime_2t(to_date(:nd_temp_date,'DD/MM/RRRR HH24:MI'),:p_language_id);  

	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_datet\
ime_2t ( to_date ( :nd_temp_date , 'DD/MM/RRRR HH24:MI' ) , :p_language_id ) ;\
 END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )605;
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
        err_mesg("SELECTING Date failed",0,"");

}

get_local_date()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	

	:nd_loc_date :=  	sm_convert_date_2t(to_date(:nd_temp_date,'DD/MM/RRRR HH24:MI'),:p_language_id);  
 	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD/MM/RRRR HH24:MI' ) , :p_language_id ) ; END\
 ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )632;
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
        err_mesg("SELECTING Date failed",0,"");

}

fun_change_loc_date()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);


get_local_date();


strcpy(date_convert.arr,nd_loc_date.arr);


}

get_local_date_format()
{

	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
	

	:nd_loc_date :=  	sm_convert_date_2t(to_date(:nd_temp_date,'DD-MON-rr'),:p_language_id);  
	:nd_loc_date :=     to_char(to_date(:nd_temp_date,'DD-MON-rr'),'DD-MON-rr');
 	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 24;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN :nd_loc_date := sm_convert_date_\
2t ( to_date ( :nd_temp_date , 'DD-MON-rr' ) , :p_language_id ) ; :nd_loc_date\
 := to_char ( to_date ( :nd_temp_date , 'DD-MON-rr' ) , 'DD-MON-rr' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )659;
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
        err_mesg("SELECTING Date failed",0,"");

}

fun_change_loc_date_format()
{

strcpy(nd_temp_date.arr,date_convert.arr);
nd_temp_date.len = strlen(nd_temp_date.arr);


get_local_date_format();


strcpy(date_convert.arr,nd_loc_date.arr);


}

/*--------- OVER -------------*/