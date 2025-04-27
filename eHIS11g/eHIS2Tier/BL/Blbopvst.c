
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/Blbopvst.pc"
};


static unsigned int sqlctx = 1288464811;


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
            void  *sqhstv[35];
   unsigned int   sqhstl[35];
            int   sqhsts[35];
            void  *sqindv[35];
            int   sqinds[35];
   unsigned int   sqharm[35];
   unsigned int   *sqharc[35];
   unsigned short  sqadto[35];
   unsigned short  sqtdso[35];
} sqlstm = {12,35};

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

 static const char *sq0003 = 
"select PRT_GRP_HDR_CODE ,PRT_GRP_LINE_CODE ,PACKAGE_IND ,PACKAGE_SERVICE_COD\
E ,BLNG_SERV_CODE ,UPD_GROSS_CHARGE_AMT ,UPD_DISC_AMT ,UPD_NET_CHARGE_AMT ,DF_\
SERVICE_IND ,BILL_DOC_TYPE_CODE ,CHARGE_TYPE_CODE ,DF_PHYSICIAN_ID  from BL_PA\
TIENT_CHARGES_FOLIO where (((((((OPERATING_FACILITY_ID=:b0 and EPISODE_TYPE='O\
') and EPISODE_ID=:b1) and VISIT_ID=:b2) and PATIENT_ID=:b3) and TRX_FINALIZE_\
IND='Y') and (NVL(PACKAGE_IND,'X')='S' or (NVL(PACKAGE_IND,'X')='P' and NVL(PA\
CKAGE_TRX_IND,'X')<>'Y'))) and NVL(SETTLEMENT_IND,'A')=DECODE(:b4,'C','C','A',\
'A',NVL(SETTLEMENT_IND,'A'))) order by CHARGE_TYPE_CODE,PRT_GRP_HDR_CODE,DF_PH\
YSICIAN_ID,PRT_GRP_LINE_CODE,PACKAGE_IND,PACKAGE_SERVICE_CODE,BLNG_SERV_CODE  \
          ";

 static const char *sq0002 = 
"select PATIENT_ID ,BLNG_GRP_ID ,SETTLEMENT_IND ,TOT_DEP_PAID_AMT ,TOT_PREP_P\
AID_AMT ,(TOT_BILLED_AMT-TOT_OUTST_AMT) ,CUST_CODE ,TOT_BILLED_AMT ,TOT_OUTST_\
AMT ,TOT_UNBLD_AMT ,TOT_UNBLD_CASH_SETT_AMT ,'N' ,NVL(TOT_BUS_MAN_DISC_AMT,0) \
,BILL_DOC_TYPE_CODE ,BILL_DOC_NUMBER ,BILL_DOC_DATE ,0 ,CLINIC_CODE ,PHYSICIAN\
_ID ,BILL_TYPE_CODE  from BL_VISIT_FIN_DTLS where (((OPERATING_FACILITY_ID=:b0\
 and EPISODE_TYPE='O') and EPISODE_ID=:b1) and VISIT_ID=:b2)           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,0,0,30,216,0,0,0,0,0,1,0,
20,0,0,3,710,0,9,333,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,
55,0,0,4,72,0,4,418,0,0,2,1,0,1,0,2,1,0,0,1,9,0,0,
78,0,0,2,459,0,9,476,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
105,0,0,2,0,0,13,481,0,0,20,0,0,1,0,2,9,0,0,2,9,0,0,2,1,0,0,2,4,0,0,2,4,0,0,2,
4,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,1,0,0,2,4,0,0,2,9,0,0,2,3,0,0,
2,9,0,0,2,4,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
200,0,0,3,0,0,13,553,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
4,0,0,2,4,0,0,2,4,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
263,0,0,5,519,0,3,662,0,0,17,17,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,3,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
346,0,0,6,543,0,3,740,0,0,18,18,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,3,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
433,0,0,7,530,0,3,811,0,0,15,15,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
1,9,0,0,1,9,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
508,0,0,8,955,0,3,918,0,0,35,35,0,1,0,1,9,0,0,1,3,0,0,1,4,0,0,1,4,0,0,1,4,0,0,
1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,
0,1,4,0,0,1,4,0,0,1,4,0,0,1,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,4,0,0,1,9,0,0,1,
9,0,0,
663,0,0,0,0,0,27,1024,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
694,0,0,2,0,0,15,1033,0,0,0,0,0,1,0,
709,0,0,3,0,0,15,1034,0,0,0,0,0,1,0,
724,0,0,10,142,0,2,1041,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
755,0,0,11,143,0,2,1051,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
786,0,0,12,148,0,2,1061,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
817,0,0,13,152,0,2,1071,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
848,0,0,14,310,0,4,1100,0,0,11,3,0,1,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
2,4,0,0,2,9,0,0,2,3,0,0,1,9,0,0,1,9,0,0,1,3,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.10                                                 */
/************************************************************************/
/* PROGRAM NAME          : BLBOPVST.PC                                  */
/* AUTHOR                : M.NITIN KUMAR                                */
/* Converted To Windows  : Prasad B G S */
/* DATE WRITTEN          : 01-AUG-1993                                  */
/*                                                                      */  
/* CALLED FROM           :                                              */
/*                                                                      */
/*  FUNCTION             : TO GENERATE DISCHARGE BILL                   */
/*                                                                      */
/*  TABLE DETAILS                                                       */
/*                                                                      */
/*        S. No.       TABLENAMES             INPUT/OUTPUT              */
/*                                                                      */
/*         1.      SY_ACC_ENTITY_DOC_TYPE     QUERY/UPDATE              */
/*         2.      BL_EPISODE_FIN_DTLS        QUERY/UPDATE              */
/*         5.      BL_BLNG_GRP                QUERY                     */
/*         6.      BL_PATIENT_FOLIO_CHARGES   QUERY/UPDATE              */
/*         7.      BL_PATIENT_FIN_DTLS        UPDATE                    */
/*         8.      BL_OUTST_SERVICE_LINE      UPDATE                    */
/*         9.      BL_OUTST_HDR               UPDATE                    */
/*         10.     BL_OUTST_LINE              UPDATE                    */
/*                                                                      */
/*  PARAMETERS           :   PARAM1   -    EPISODE_ID                   */
/*                           PARAM2   -    DOC_TYPE_CODE                */
/*                           PARAM3   -    DOC_DATE                     */
/*                           PARAM4   -    PRINT Y/N                    */
/*                                                                      */
/************************************************************************/
   
#include <stdio.h>
#include <string.h>
#include "bl.h" 

#define RESOURCE_BUSY (sqlca.sqlcode == -54)

/*
#define DEBUG 0
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


   /* VARCHAR uid_pwd      [132],
           nd_pgm_date  [35]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;


   /* VARCHAR nd_session_id                [16],
	   nd_episode_id                [9],
	   nd_visit_id                  [5],
	   nd_operating_facility_id     [3]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[9]; } nd_episode_id;

struct { unsigned short len; unsigned char arr[5]; } nd_visit_id;

struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;



/* VARCHAR     d_patient_id                 [21],
			d_blng_grp_id                [3],
			d_admission_date             [11],
			d_discharge_date             [11],
			d_prt_grp_hdr_code           [3],
            d_prt_grp_line_code          [3],
            d_package_ind                [2],
            d_package_service_code       [11],
            d_blng_serv_code             [11],
            d_charge_type_code           [2],
            d_df_physician_id            [16],
			d_old_prt_grp_hdr_code       [3],
            d_old_prt_grp_line_code      [3],
            d_old_package_ind            [2],
            d_old_package_service_code   [11],
            d_old_blng_serv_code         [11],
            d_old_charge_type_code       [2],
            d_old_df_physician_id        [16],
			d_bill_doc_type_code         [7],
			d_cust_code                  [9],
			d_bill_type_code             [3],
			d_ins_cust_code              [9],
			d_epi_bill_doc_type_code     [7],
			d_epi_bill_doc_date          [10],
			d_clinic_code                [5],
			d_physician_id               [16]; */ 
struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[3]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[11]; } d_admission_date;

struct { unsigned short len; unsigned char arr[11]; } d_discharge_date;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } d_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[2]; } d_package_ind;

struct { unsigned short len; unsigned char arr[11]; } d_package_service_code;

struct { unsigned short len; unsigned char arr[11]; } d_blng_serv_code;

struct { unsigned short len; unsigned char arr[2]; } d_charge_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_df_physician_id;

struct { unsigned short len; unsigned char arr[3]; } d_old_prt_grp_hdr_code;

struct { unsigned short len; unsigned char arr[3]; } d_old_prt_grp_line_code;

struct { unsigned short len; unsigned char arr[2]; } d_old_package_ind;

struct { unsigned short len; unsigned char arr[11]; } d_old_package_service_code;

struct { unsigned short len; unsigned char arr[11]; } d_old_blng_serv_code;

struct { unsigned short len; unsigned char arr[2]; } d_old_charge_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_old_df_physician_id;

struct { unsigned short len; unsigned char arr[7]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_cust_code;

struct { unsigned short len; unsigned char arr[3]; } d_bill_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_ins_cust_code;

struct { unsigned short len; unsigned char arr[7]; } d_epi_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_epi_bill_doc_date;

struct { unsigned short len; unsigned char arr[5]; } d_clinic_code;

struct { unsigned short len; unsigned char arr[16]; } d_physician_id;



char		nd_dummy,
			nd_print_yn,
			nd_bill_nat_code,
			d_bill_nat_code,
			d_settlement_ind,
			d_doc_num_gen_flag,
			d_bl_valid_flag,
			d_status,
			d_df_service_ind,
			d_cons_invoice_ind,
			d_drfee_rec_upd_flag,
			d_take_home_med,
			d_discharge_med,
            d_discharge_bill_gen_ind;

long       d_next_doc_no,
		   d_epi_bill_doc_number;

double      d_tot_unadj_dep_amt,
            d_tot_unadj_prep_amt,
            d_fin_unadj_dep_amt,
            d_fin_unadj_prep_amt,
            d_tot_paid_amt,
            d_tot_bus_man_disc_amt,
            d_upd_gross_charge_amt,
            d_upd_disc_amt,
            d_upd_net_charge_amt,
			srvlin_gross_amt,
			srvlin_disc_amt,
			srvlin_net_amt,
			billin_gross_amt,
			billin_disc_amt,
			billin_net_amt,
			biltot_gross_amt,
			biltot_disc_amt,
			biltot_net_amt,
			biltot_drfee_amt,
			biltot_hosp_amt,
			pkg_serv_gross_amt,
			pkg_serv_disc_amt,
			pkg_serv_net_amt,
			d_bill_amt,
            d_tot_billed_amt,
            d_tot_outst_amt,
            d_tot_unbld_amt,
            d_tot_unbld_cash_sett_amt,
			d_final_bill_amt,
			d_reduction_amt,
			d_hosp_outst_amt,
			d_drfee_outst_amt,
			d_drfee_receipt_amt,
			diff_amt,
			boun_clr_paid_amt;

long		d_serv_line_num,
			d_pkg_line_num,
			d_bill_line_num;

double		t_bill_amt,
			t_bill_paid_amt,
			t_prepay_adj_amt,
			t_man_disc_amt,
			t_overall_disc_amt,
			t_refund_amt;

/* VARCHAR		t_doc_type_code    [7]; */ 
struct { unsigned short len; unsigned char arr[7]; } t_doc_type_code;

long		t_doc_num;

/* EXEC SQL END DECLARE SECTION; */ 

/*
EXEC ORACLE OPTION(HOLD_CURSOR = YES);
EXEC ORACLE OPTION(REBIND = NO);
*/
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

int g_first;

void proc_main(argc,argv)
char *argv[];
int argc;
{
   if (argc < 6)
   {
      disp_message(ERR_MESG,"Not enough Parameters for running this program");
      proc_exit();
   }

   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);


   strcpy(g_pgm_id,"BLBOPVST");

   if(sql_connect() == -1)
   {
      disp_message(ORA_MESG,"Error in connecting to Oracle");
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd");
      proc_exit();
   }

   set_meduser_role();

   g_pgm_date[0] = '\0';

   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);

   strcpy(nd_episode_id.arr, argv[5]);
   nd_episode_id.len = strlen(nd_episode_id.arr);

   strcpy(nd_visit_id.arr, argv[6]);
   nd_visit_id.len = strlen(nd_visit_id.arr);

   strcpy(nd_operating_facility_id.arr, argv[4]);
   nd_operating_facility_id.len = strlen(nd_operating_facility_id.arr);

   start_prog_msg();

   decl_curs();

   gen_discharge_bill();

   close_curs();

   end_prog_msg();

   strcpy(g_facility_id, nd_operating_facility_id.arr);

   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 0;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   return;
}

decl_curs()
{

    /* EXEC SQL DECLARE BL_VISIT_CUR CURSOR FOR
	     SELECT  PATIENT_ID,
		     BLNG_GRP_ID,
             SETTLEMENT_IND,
             TOT_DEP_PAID_AMT,
             TOT_PREP_PAID_AMT,
             (TOT_BILLED_AMT  - TOT_OUTST_AMT),
		     CUST_CODE,
		     TOT_BILLED_AMT,
		     TOT_OUTST_AMT,
		     TOT_UNBLD_AMT,
		     TOT_UNBLD_CASH_SETT_AMT ,
             'N',              /oNVL(DISCHARGE_BILL_GEN_IND,'N')o/
             NVL(TOT_BUS_MAN_DISC_AMT,0),
		     BILL_DOC_TYPE_CODE,
		     BILL_DOC_NUMBER,
		     BILL_DOC_DATE,
		     0,                /oNVL(AFT_DISCH_PMNT_BOUN_CLR,0)o/
		     CLINIC_CODE,
		     PHYSICIAN_ID,
		     BILL_TYPE_CODE
	     FROM    BL_VISIT_FIN_DTLS
	     WHERE   OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND     EPISODE_TYPE = 'O'
	     AND     EPISODE_ID   = :nd_episode_id
	     AND     VISIT_ID     = :nd_visit_id; */ 


    /* EXEC SQL DECLARE BL_PAT_CHRGS_FOLIO_CUR CURSOR FOR
	     SELECT PRT_GRP_HDR_CODE,
                    PRT_GRP_LINE_CODE,
                    PACKAGE_IND,
                    PACKAGE_SERVICE_CODE,
                    BLNG_SERV_CODE,
                    UPD_GROSS_CHARGE_AMT,
                    UPD_DISC_AMT,
                    UPD_NET_CHARGE_AMT,
					DF_SERVICE_IND,
					BILL_DOC_TYPE_CODE,
					CHARGE_TYPE_CODE,
					DF_PHYSICIAN_ID  
	     FROM   BL_PATIENT_CHARGES_FOLIO
	     WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND    EPISODE_TYPE = 'O'
	     AND    EPISODE_ID   = :nd_episode_id
	     AND    VISIT_ID     = :nd_visit_id
	     AND    PATIENT_ID   = :d_patient_id
	     AND    TRX_FINALIZE_IND = 'Y'  
	     AND    (NVL(PACKAGE_IND,'X') = 'S' OR
		    (NVL(PACKAGE_IND,'X') = 'P' AND 
		     NVL(PACKAGE_TRX_IND,'X') <> 'Y'))
	     AND    NVL(SETTLEMENT_IND,'A') = DECODE(:nd_bill_nat_code,
		       'C','C','A','A',NVL(SETTLEMENT_IND,'A'))
/o
	     AND    NVL(BILL_DOC_TYPE_CODE,'!!!!!!') = 
		     DECODE(:d_discharge_bill_gen_ind,'Y','!!!!!!',
			    NVL(BILL_DOC_TYPE_CODE,'!!!!!!'))
o/
	     ORDER BY CHARGE_TYPE_CODE,PRT_GRP_HDR_CODE, 
		      DF_PHYSICIAN_ID,PRT_GRP_LINE_CODE,
                      PACKAGE_IND, PACKAGE_SERVICE_CODE,
                      BLNG_SERV_CODE; */ 


}

gen_discharge_bill()
{

   if(fetch_bl_visit()) {

       delete_recs();

       d_final_bill_amt = 0;
       d_next_doc_no    = 0;

       if(d_settlement_ind EQ  'C') {
           d_ins_cust_code.arr[0] = '\0';
           d_ins_cust_code.len = strlen(d_ins_cust_code.arr);
	   nd_bill_nat_code = 'B'; /* process both C and NULL types */
	   d_bill_nat_code = 'C';
	   process_recs();  
       }
       else {
	   /*
	   nd_bill_nat_code = 'C';
	   d_bill_nat_code = 'C';
           d_ins_cust_code.arr[0] = '\0';
           d_ins_cust_code.len = strlen(d_ins_cust_code.arr);
	   process_recs(); 
	   */
	   nd_bill_nat_code = 'B'; /* process both C and NULL types */
	   d_bill_nat_code = 'A';
	   d_next_doc_no = 1;
           strcpy(d_ins_cust_code.arr,d_cust_code.arr);
           d_ins_cust_code.len = strlen(d_ins_cust_code.arr);
	   process_recs();
      }

   }
   else
       disp_message(ERR_MESG,"No record selected from bl_visit_fin_dtls");

}


process_recs()
{

    int ctr = 0;
    d_next_doc_no ++;

    /* EXEC SQL OPEN BL_PAT_CHRGS_FOLIO_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0003;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )20;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_visit_id;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_bill_nat_code;
    sqlstm.sqhstl[4] = (unsigned int  )1;
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
	err_mesg("OPEN failed on cursor BL_PAT_CHRGS_FOILO_CUR",0,"");

    d_old_prt_grp_hdr_code.arr[0]      = '\0';
    d_old_prt_grp_line_code.arr[0]     = '\0';
    d_old_package_ind.arr[0]           = '\0';
    d_old_package_service_code.arr[0]  = '\0';
    d_old_blng_serv_code.arr[0]        = '\0';
    d_old_charge_type_code.arr[0]      = '\0';
    d_old_df_physician_id.arr[0]       = '\0';

    g_first = 1;

    srvlin_gross_amt   = 0;
    srvlin_disc_amt    = 0;
    srvlin_net_amt     = 0;

    pkg_serv_gross_amt = 0;
    pkg_serv_disc_amt  = 0;
    pkg_serv_net_amt   = 0;

    billin_gross_amt   = 0;
    billin_disc_amt    = 0;
    billin_net_amt     = 0;

    biltot_gross_amt  = 0;
    biltot_disc_amt   = 0;
    biltot_net_amt    = 0;

    biltot_drfee_amt  = 0;
    biltot_hosp_amt   = 0;

    d_serv_line_num   = 0;
    d_pkg_line_num    = 0;
    d_bill_line_num   = 0;

    while (fetch_pat_chrgs()) {
	
	if(prt_grp_change()) {
	    insrt_service_dtls();
	    insrt_bill_line();
	}
	else if(pkg_serv_change()) 
	    insrt_service_dtls();
	else if(blng_serv_change())
	    insrt_bill_pkg();

	srvlin_gross_amt += d_upd_gross_charge_amt;
	srvlin_disc_amt  += d_upd_disc_amt;
	srvlin_net_amt   += d_upd_net_charge_amt;

	pkg_serv_gross_amt += d_upd_gross_charge_amt;
	pkg_serv_disc_amt  += d_upd_disc_amt;
	pkg_serv_net_amt   += d_upd_net_charge_amt;

	billin_gross_amt += d_upd_gross_charge_amt;
	billin_disc_amt  += d_upd_disc_amt;
	billin_net_amt   += d_upd_net_charge_amt;

	biltot_gross_amt += d_upd_gross_charge_amt;
	biltot_disc_amt  += d_upd_disc_amt;
	biltot_net_amt   += d_upd_net_charge_amt;

	if(d_df_service_ind EQ 'D' || d_df_service_ind EQ 'R')
	    biltot_drfee_amt  +=  d_upd_gross_charge_amt;
	else
	    biltot_hosp_amt   +=  d_upd_gross_charge_amt;

	copy_val();

	ctr = 1;

    }

    if(ctr) {
        insrt_service_dtls();
        insrt_bill_line();
    }

    d_cons_invoice_ind = 'N';

    if(d_bill_nat_code != 'C') {

	/* EXEC SQL SELECT CONS_INVOICE_IND
		 INTO   :d_cons_invoice_ind
		 FROM   BL_BLNG_GRP
		 WHERE  BLNG_GRP_ID = :d_blng_grp_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select CONS_INVOICE_IND into :b0  from BL_BLNG_GRP where BLN\
G_GRP_ID=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )55;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_cons_invoice_ind;
 sqlstm.sqhstl[0] = (unsigned int  )1;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_id;
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


	
        if(OERROR)
	    err_mesg("SELECT failed on table BL_BLNG_GRP",0,"");

    }

    insrt_bill_hdr();

    d_tot_unadj_dep_amt            = 0;
    d_tot_unadj_prep_amt           = 0;
    d_tot_paid_amt                 = 0;

}


fetch_bl_visit()
{

    d_patient_id.arr[0]      = '\0';
    d_blng_grp_id.arr[0]     = '\0';
    d_cust_code.arr[0]       = '\0';
    d_ins_cust_code.arr[0]   = '\0';
    d_settlement_ind         = '\0';
    d_epi_bill_doc_type_code.arr[0]  = '\0';
    d_epi_bill_doc_date.arr[0]       = '\0';
    d_clinic_code.arr[0]             = '\0';
    d_physician_id.arr[0]            = '\0';
    d_bill_type_code.arr[0]          = '\0';

    d_discharge_bill_gen_ind = '\0';

    d_patient_id.len         = 0;
    d_blng_grp_id.len        = 0;
    d_cust_code.len          = 0;
    d_ins_cust_code.len      = 0;
    d_epi_bill_doc_type_code.len = 0;
    d_epi_bill_doc_date.len      = 0;
    d_clinic_code.len            = 0;
    d_physician_id.len           = 0;
    d_bill_type_code.len         = 0;

    d_tot_unadj_dep_amt            = 0;
    d_tot_unadj_prep_amt           = 0;
    d_fin_unadj_dep_amt            = 0;
    d_fin_unadj_prep_amt           = 0;
    d_tot_paid_amt                 = 0;
    d_tot_billed_amt               = 0;
    d_tot_outst_amt                = 0;
    d_tot_unbld_amt                = 0;
    d_tot_unbld_cash_sett_amt      = 0;
    d_tot_bus_man_disc_amt         = 0;
    d_epi_bill_doc_number          = 0;
    boun_clr_paid_amt              = 0;

    /* EXEC SQL OPEN BL_VISIT_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0002;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )78;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_visit_id;
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
}



    if(OERROR)
	err_mesg("OPEN failed on cursor BL_VISIT_CUR",0,"");

    /* EXEC SQL FETCH BL_VISIT_CUR INTO
                   :d_patient_id,
                   :d_blng_grp_id,
                   :d_settlement_ind,
                   :d_tot_unadj_dep_amt,
                   :d_tot_unadj_prep_amt,
                   :d_tot_paid_amt,
				   :d_cust_code,
                   :d_tot_billed_amt,
                   :d_tot_outst_amt,
                   :d_tot_unbld_amt,
                   :d_tot_unbld_cash_sett_amt,
                   :d_discharge_bill_gen_ind,
                   :d_tot_bus_man_disc_amt,
                   :d_epi_bill_doc_type_code,
                   :d_epi_bill_doc_number,
                   :d_epi_bill_doc_date,
				   :boun_clr_paid_amt,
                   :d_clinic_code,
                   :d_physician_id,
                   :d_bill_type_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )105;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_settlement_ind;
    sqlstm.sqhstl[2] = (unsigned int  )1;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_tot_unadj_dep_amt;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_tot_unadj_prep_amt;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_tot_paid_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
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
    sqlstm.sqhstv[7] = (         void  *)&d_tot_billed_amt;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_tot_outst_amt;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_tot_unbld_amt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_tot_unbld_cash_sett_amt;
    sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_discharge_bill_gen_ind;
    sqlstm.sqhstl[11] = (unsigned int  )1;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_tot_bus_man_disc_amt;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_epi_bill_doc_type_code;
    sqlstm.sqhstl[13] = (unsigned int  )9;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_epi_bill_doc_number;
    sqlstm.sqhstl[14] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_epi_bill_doc_date;
    sqlstm.sqhstl[15] = (unsigned int  )12;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&boun_clr_paid_amt;
    sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&d_clinic_code;
    sqlstm.sqhstl[17] = (unsigned int  )7;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_physician_id;
    sqlstm.sqhstl[18] = (unsigned int  )18;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&d_bill_type_code;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor BL_VISIT_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_patient_id.arr[d_patient_id.len]    = '\0';
    d_blng_grp_id.arr[d_blng_grp_id.len]        = '\0';
    d_cust_code.arr[d_cust_code.len]      = '\0';
    d_epi_bill_doc_type_code.arr[d_epi_bill_doc_type_code.len]  = '\0';
    d_epi_bill_doc_date.arr[d_epi_bill_doc_date.len]            = '\0';
    d_clinic_code.arr[d_clinic_code.len]                        = '\0';
    d_physician_id.arr[d_physician_id.len]                      = '\0';
    d_bill_type_code.arr[d_bill_type_code.len]                  = '\0';

    d_fin_unadj_dep_amt = d_tot_unadj_dep_amt ;
    d_fin_unadj_prep_amt = d_tot_unadj_prep_amt;

    if(d_epi_bill_doc_type_code.arr[0])
	   get_prv_amts();

    return 1;
}

fetch_pat_chrgs()
{
    d_prt_grp_hdr_code.arr[0]        = '\0';
    d_prt_grp_line_code.arr[0]       = '\0';
    d_package_ind.arr[0]             = '\0';
    d_package_service_code.arr[0]    = '\0';
    d_blng_serv_code.arr[0]          = '\0';
    d_bill_doc_type_code.arr[0]      = '\0';
    d_charge_type_code.arr[0]        = '\0';
    d_df_physician_id.arr[0]         = '\0';

    d_prt_grp_hdr_code.len        = 0;
    d_prt_grp_line_code.len       = 0;
    d_package_ind.len             = 0;
    d_package_service_code.len    = 0;
    d_blng_serv_code.len          = 0;
    d_bill_doc_type_code.len      = 0;
    d_charge_type_code.len        = 0;
    d_df_physician_id.len         = 0;

    d_df_service_ind  = '\0';

    d_upd_gross_charge_amt   = 0;
    d_upd_disc_amt           = 0;
    d_upd_net_charge_amt     = 0;

    /* EXEC SQL FETCH BL_PAT_CHRGS_FOLIO_CUR 
				INTO
					:d_prt_grp_hdr_code,
                    :d_prt_grp_line_code,
                    :d_package_ind,
                    :d_package_service_code,
                    :d_blng_serv_code,
                    :d_upd_gross_charge_amt,
                    :d_upd_disc_amt,
                    :d_upd_net_charge_amt,
					:d_df_service_ind,
					:d_bill_doc_type_code,
					:d_charge_type_code,
					:d_df_physician_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )200;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_grp_hdr_code;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prt_grp_line_code;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_package_ind;
    sqlstm.sqhstl[2] = (unsigned int  )4;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_package_service_code;
    sqlstm.sqhstl[3] = (unsigned int  )13;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_blng_serv_code;
    sqlstm.sqhstl[4] = (unsigned int  )13;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_upd_gross_charge_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_upd_disc_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_upd_net_charge_amt;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_df_service_ind;
    sqlstm.sqhstl[8] = (unsigned int  )1;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_bill_doc_type_code;
    sqlstm.sqhstl[9] = (unsigned int  )9;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_charge_type_code;
    sqlstm.sqhstl[10] = (unsigned int  )4;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_df_physician_id;
    sqlstm.sqhstl[11] = (unsigned int  )18;
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



    if(OERROR)
	err_mesg("FETCH failed on cursor BL_PAT_CHRGS_FOILO_CUR",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_prt_grp_hdr_code.arr[d_prt_grp_hdr_code.len]         = '\0';
    d_prt_grp_line_code.arr[d_prt_grp_line_code.len]       = '\0';
    d_package_ind.arr[d_package_ind.len]                 = '\0';
    d_package_service_code.arr[d_package_service_code.len] = '\0';
    d_blng_serv_code.arr[d_blng_serv_code.len]             = '\0';
    d_bill_doc_type_code.arr[d_bill_doc_type_code.len]     = '\0';
    d_charge_type_code.arr[d_charge_type_code.len]         = '\0';
    d_df_physician_id.arr[d_df_physician_id.len]           = '\0';

    if(g_first) {

        copy_val();

	g_first = 0;
    }
    return 1;
}

copy_val()
{
    strcpy(d_old_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr);
    strcpy(d_old_prt_grp_line_code.arr,d_prt_grp_line_code.arr);
    strcpy(d_old_package_ind.arr,d_package_ind.arr);
    strcpy(d_old_package_service_code.arr,d_package_service_code.arr);
    strcpy(d_old_blng_serv_code.arr,d_blng_serv_code.arr);
    strcpy(d_old_charge_type_code.arr,d_charge_type_code.arr);
    strcpy(d_old_df_physician_id.arr,d_df_physician_id.arr);

    d_old_prt_grp_hdr_code.len     = strlen(d_old_prt_grp_hdr_code.arr);
    d_old_prt_grp_line_code.len    = strlen(d_old_prt_grp_line_code.arr);
    d_old_package_ind.len          = strlen(d_old_package_ind.arr);
    d_old_package_service_code.len = strlen(d_old_package_service_code.arr);
    d_old_blng_serv_code.len       = strlen(d_old_blng_serv_code.arr);
    d_old_charge_type_code.len     = strlen(d_old_charge_type_code.arr);
    d_old_df_physician_id.len      = strlen(d_old_df_physician_id.arr);
}

change()
{
    if(!strcmp(d_old_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr) &&
       !strcmp(d_old_prt_grp_line_code.arr,d_prt_grp_line_code.arr) &&
       !strcmp(d_old_package_ind.arr,d_package_ind.arr) &&
       !strcmp(d_old_package_service_code.arr,d_package_service_code.arr) &&
       !strcmp(d_old_blng_serv_code.arr,d_blng_serv_code.arr))

	   return 0;
    else
	   return 1;
}

prt_grp_change()
{

    if(!strcmp(d_old_prt_grp_hdr_code.arr,d_prt_grp_hdr_code.arr)     &&
       !strcmp(d_old_prt_grp_line_code.arr,d_prt_grp_line_code.arr)   &&
       !strcmp(d_old_charge_type_code.arr,d_charge_type_code.arr)     &&
       !strcmp(d_old_df_physician_id.arr,d_df_physician_id.arr))

	   return 0;
    else
	   return 1;

}

pkg_serv_change()
{
    if(!strcmp(d_old_package_ind.arr,d_package_ind.arr) &&
       !strcmp(d_old_package_service_code.arr,d_package_service_code.arr))

	   return 0;
    else
	   return 1;
}

blng_serv_change()
{
    if(!strcmp(d_old_blng_serv_code.arr,d_blng_serv_code.arr))

	   return 0;
    else
	   return 1;
}


insrt_service_dtls()
{
    d_serv_line_num ++;
    
    /* EXEC SQL INSERT INTO BL_OUTST_SERV_LINE 
                       (  OPERATING_FACILITY_ID,
						  EPISODE_TYPE,
                          PATIENT_ID,
                          EPISODE_ID,
                          VISIT_ID,
                          OUTST_TMP_NUM,
                          PRT_GRP_HDR_CODE,
                          PRT_GRP_LINE_CODE,
                          PACKAGE_IND,
                          PACKAGE_SERVICE_CODE,
                          GROSS_AMT,
                          SERV_DISC_AMT,
                          NET_AMT,
                          ADDED_BY_ID,
                          ADDED_DATE,
                          MODIFIED_BY_ID,
                          MODIFIED_DATE,
						  LINE_NUM,
						  CHARGE_TYPE_CODE,
						  DF_PHYSICIAN_ID, 
						  AMT_SIGN_IND,
						  ADDED_AT_WS_NO,
						  ADDED_FACILITY_ID,
						  MODIFIED_AT_WS_NO,
						  MODIFIED_FACILITY_ID
                       )
               VALUES  ( 
						 :nd_operating_facility_id,
						 'O',
						 :d_patient_id,
						 :nd_episode_id,
						 :nd_visit_id,
						 :d_next_doc_no,
                         :d_old_prt_grp_hdr_code,
                         :d_old_prt_grp_line_code,
                         :d_old_package_ind,
                         :d_old_package_service_code,
                         :srvlin_gross_amt,
                         :srvlin_disc_amt,
                         :srvlin_net_amt,
                         USER,
                         SYSDATE,
                         user,
                         sysdate,
						 :d_serv_line_num,
						 :d_old_charge_type_code,
						 :d_old_df_physician_id,
						 0,
						'DFLT',
						:nd_operating_facility_id,
						'DFLT',
						:nd_operating_facility_id
                      ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into BL_OUTST_SERV_LINE (OPERATING_FACILITY_ID,EPI\
SODE_TYPE,PATIENT_ID,EPISODE_ID,VISIT_ID,OUTST_TMP_NUM,PRT_GRP_HDR_CODE,PRT_GR\
P_LINE_CODE,PACKAGE_IND,PACKAGE_SERVICE_CODE,GROSS_AMT,SERV_DISC_AMT,NET_AMT,A\
DDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,LINE_NUM,CHARGE_TYPE_CODE,D\
F_PHYSICIAN_ID,AMT_SIGN_IND,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO\
,MODIFIED_FACILITY_ID) values (:b0,'O',:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b1\
0,:b11,USER,SYSDATE,user,sysdate,:b12,:b13,:b14,0,'DFLT',:b0,'DFLT',:b0)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )263;
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
    sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_visit_id;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_next_doc_no;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_old_prt_grp_hdr_code;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_old_prt_grp_line_code;
    sqlstm.sqhstl[6] = (unsigned int  )5;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_old_package_ind;
    sqlstm.sqhstl[7] = (unsigned int  )4;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_old_package_service_code;
    sqlstm.sqhstl[8] = (unsigned int  )13;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&srvlin_gross_amt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&srvlin_disc_amt;
    sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&srvlin_net_amt;
    sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_serv_line_num;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_old_charge_type_code;
    sqlstm.sqhstl[13] = (unsigned int  )4;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_old_df_physician_id;
    sqlstm.sqhstl[14] = (unsigned int  )18;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[15] = (unsigned int  )5;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[16] = (unsigned int  )5;
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
         err_mesg("INSERT failed on table BL_OUTST_SERV_LINE",0,"");

		srvlin_gross_amt       = 0;
		srvlin_disc_amt        = 0;
		srvlin_net_amt         = 0;

    if(d_old_package_ind.arr[0] EQ 'P')
	insrt_bill_pkg();
    else {

        pkg_serv_gross_amt       = 0;
        pkg_serv_disc_amt        = 0;
        pkg_serv_net_amt         = 0;

    }
    
}

insrt_bill_pkg()
{
		d_pkg_line_num ++;

        /* EXEC SQL INSERT INTO BL_OUTST_PKG_SERV_LINE 
                          (  OPERATING_FACILITY_ID,
							 EPISODE_TYPE,
                             PATIENT_ID,
                             EPISODE_ID,
                             VISIT_ID,
                             OUTST_TMP_NUM,
							 PRT_GRP_HDR_CODE,
							 PRT_GRP_LINE_CODE,
							 PACKAGE_IND,
							 PACKAGE_SERVICE_CODE,
							 BLNG_SERV_CODE,
							 GROSS_AMT,
							 SERV_DISC_AMT,
							 NET_AMT,
							 ADDED_BY_ID,
							 ADDED_DATE,
							 MODIFIED_BY_ID,
							 MODIFIED_DATE,
							 LINE_NUM,
							 CHARGE_TYPE_CODE,
							 DF_PHYSICIAN_ID, 
							 AMT_SIGN_IND,
							 ADDED_AT_WS_NO,
							 ADDED_FACILITY_ID,
							 MODIFIED_AT_WS_NO,
							 MODIFIED_FACILITY_ID
		         )
               VALUES    (   
			     :nd_operating_facility_id,
				 'O',
			     :d_patient_id,
			     :nd_episode_id,
			     :nd_visit_id,
			     :d_next_doc_no,
			     :d_old_prt_grp_hdr_code,
			     :d_old_prt_grp_line_code,
			     :d_old_package_ind,
			     :d_old_package_service_code,
			     :d_old_blng_serv_code,
			     :pkg_serv_gross_amt,
			     :pkg_serv_disc_amt,
			     :pkg_serv_net_amt,
			     USER,
			     SYSDATE,
			     user,
			     sysdate,
			     :d_pkg_line_num,
			     :d_old_charge_type_code,
			     :d_old_df_physician_id,
			     0,
				 'DFLT',
				:nd_operating_facility_id,
				'DFLT',
				:nd_operating_facility_id
			 ); */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 12;
        sqlstm.arrsiz = 20;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "insert into BL_OUTST_PKG_SERV_LINE (OPERATING_FACILIT\
Y_ID,EPISODE_TYPE,PATIENT_ID,EPISODE_ID,VISIT_ID,OUTST_TMP_NUM,PRT_GRP_HDR_COD\
E,PRT_GRP_LINE_CODE,PACKAGE_IND,PACKAGE_SERVICE_CODE,BLNG_SERV_CODE,GROSS_AMT,\
SERV_DISC_AMT,NET_AMT,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,LINE\
_NUM,CHARGE_TYPE_CODE,DF_PHYSICIAN_ID,AMT_SIGN_IND,ADDED_AT_WS_NO,ADDED_FACILI\
TY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (:b0,'O',:b1,:b2,:b3,:b4,\
:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,USER,SYSDATE,user,sysdate,:b13,:b14,:b15,0,\
'DFLT',:b0,'DFLT',:b0)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )346;
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
        sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
        sqlstm.sqhstl[1] = (unsigned int  )23;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_episode_id;
        sqlstm.sqhstl[2] = (unsigned int  )11;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_visit_id;
        sqlstm.sqhstl[3] = (unsigned int  )7;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&d_next_doc_no;
        sqlstm.sqhstl[4] = (unsigned int  )sizeof(long);
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&d_old_prt_grp_hdr_code;
        sqlstm.sqhstl[5] = (unsigned int  )5;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&d_old_prt_grp_line_code;
        sqlstm.sqhstl[6] = (unsigned int  )5;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&d_old_package_ind;
        sqlstm.sqhstl[7] = (unsigned int  )4;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&d_old_package_service_code;
        sqlstm.sqhstl[8] = (unsigned int  )13;
        sqlstm.sqhsts[8] = (         int  )0;
        sqlstm.sqindv[8] = (         void  *)0;
        sqlstm.sqinds[8] = (         int  )0;
        sqlstm.sqharm[8] = (unsigned int  )0;
        sqlstm.sqadto[8] = (unsigned short )0;
        sqlstm.sqtdso[8] = (unsigned short )0;
        sqlstm.sqhstv[9] = (         void  *)&d_old_blng_serv_code;
        sqlstm.sqhstl[9] = (unsigned int  )13;
        sqlstm.sqhsts[9] = (         int  )0;
        sqlstm.sqindv[9] = (         void  *)0;
        sqlstm.sqinds[9] = (         int  )0;
        sqlstm.sqharm[9] = (unsigned int  )0;
        sqlstm.sqadto[9] = (unsigned short )0;
        sqlstm.sqtdso[9] = (unsigned short )0;
        sqlstm.sqhstv[10] = (         void  *)&pkg_serv_gross_amt;
        sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[10] = (         int  )0;
        sqlstm.sqindv[10] = (         void  *)0;
        sqlstm.sqinds[10] = (         int  )0;
        sqlstm.sqharm[10] = (unsigned int  )0;
        sqlstm.sqadto[10] = (unsigned short )0;
        sqlstm.sqtdso[10] = (unsigned short )0;
        sqlstm.sqhstv[11] = (         void  *)&pkg_serv_disc_amt;
        sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[11] = (         int  )0;
        sqlstm.sqindv[11] = (         void  *)0;
        sqlstm.sqinds[11] = (         int  )0;
        sqlstm.sqharm[11] = (unsigned int  )0;
        sqlstm.sqadto[11] = (unsigned short )0;
        sqlstm.sqtdso[11] = (unsigned short )0;
        sqlstm.sqhstv[12] = (         void  *)&pkg_serv_net_amt;
        sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
        sqlstm.sqhsts[12] = (         int  )0;
        sqlstm.sqindv[12] = (         void  *)0;
        sqlstm.sqinds[12] = (         int  )0;
        sqlstm.sqharm[12] = (unsigned int  )0;
        sqlstm.sqadto[12] = (unsigned short )0;
        sqlstm.sqtdso[12] = (unsigned short )0;
        sqlstm.sqhstv[13] = (         void  *)&d_pkg_line_num;
        sqlstm.sqhstl[13] = (unsigned int  )sizeof(long);
        sqlstm.sqhsts[13] = (         int  )0;
        sqlstm.sqindv[13] = (         void  *)0;
        sqlstm.sqinds[13] = (         int  )0;
        sqlstm.sqharm[13] = (unsigned int  )0;
        sqlstm.sqadto[13] = (unsigned short )0;
        sqlstm.sqtdso[13] = (unsigned short )0;
        sqlstm.sqhstv[14] = (         void  *)&d_old_charge_type_code;
        sqlstm.sqhstl[14] = (unsigned int  )4;
        sqlstm.sqhsts[14] = (         int  )0;
        sqlstm.sqindv[14] = (         void  *)0;
        sqlstm.sqinds[14] = (         int  )0;
        sqlstm.sqharm[14] = (unsigned int  )0;
        sqlstm.sqadto[14] = (unsigned short )0;
        sqlstm.sqtdso[14] = (unsigned short )0;
        sqlstm.sqhstv[15] = (         void  *)&d_old_df_physician_id;
        sqlstm.sqhstl[15] = (unsigned int  )18;
        sqlstm.sqhsts[15] = (         int  )0;
        sqlstm.sqindv[15] = (         void  *)0;
        sqlstm.sqinds[15] = (         int  )0;
        sqlstm.sqharm[15] = (unsigned int  )0;
        sqlstm.sqadto[15] = (unsigned short )0;
        sqlstm.sqtdso[15] = (unsigned short )0;
        sqlstm.sqhstv[16] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[16] = (unsigned int  )5;
        sqlstm.sqhsts[16] = (         int  )0;
        sqlstm.sqindv[16] = (         void  *)0;
        sqlstm.sqinds[16] = (         int  )0;
        sqlstm.sqharm[16] = (unsigned int  )0;
        sqlstm.sqadto[16] = (unsigned short )0;
        sqlstm.sqtdso[16] = (unsigned short )0;
        sqlstm.sqhstv[17] = (         void  *)&nd_operating_facility_id;
        sqlstm.sqhstl[17] = (unsigned int  )5;
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


    
        if(OERROR)
	    err_mesg("INSERT failed on table BL_OUTST_PKG_SERVICE_LINE",0,"");

        pkg_serv_gross_amt       = 0;
        pkg_serv_disc_amt        = 0;
        pkg_serv_net_amt         = 0;
    
}

insrt_bill_line()
{

    d_bill_line_num ++;

    /* EXEC SQL INSERT INTO BL_OUTST_LINE
                      (  OPERATING_FACILITY_ID,
						 EPISODE_TYPE,
                         PATIENT_ID,
                         EPISODE_ID,
                         VISIT_ID,
                         OUTST_TMP_NUM,
						 PRT_GRP_HDR_CODE,
						 PRT_GRP_LINE_CODE,
						 GROSS_AMT,
						 SERV_DISC_AMT,
						 NET_AMT,
						 MAN_DISC_PERC,
						 MAN_DISC_AMT,
						 MAN_DISC_ACC_INT_CODE,
						 ADDED_BY_ID,
						 ADDED_DATE,
						 MODIFIED_BY_ID,
						 MODIFIED_DATE,
						 LINE_NUM,
						 CHARGE_TYPE_CODE,
						 DF_PHYSICIAN_ID, 
						 AMT_SIGN_IND,
						 ADDED_AT_WS_NO,
						 ADDED_FACILITY_ID,
						 MODIFIED_AT_WS_NO,
						 MODIFIED_FACILITY_ID

		     )
             VALUES  (  :nd_operating_facility_id, 
						'O',
						:d_patient_id,
						:nd_episode_id,
						:nd_visit_id,
						:d_next_doc_no,
						:d_old_prt_grp_hdr_code,
						:d_old_prt_grp_line_code,
						:billin_gross_amt,
						:billin_disc_amt,
						:billin_net_amt,
						0	,
						0,
						NULL,
						USER,
						SYSDATE,
						USER,
						SYSDATE,
						:d_bill_line_num,
						:d_old_charge_type_code,
						:d_old_df_physician_id,
						0,
						'DFLT',
						:nd_operating_facility_id,
						'DFLT',
						:nd_operating_facility_id
		     ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into BL_OUTST_LINE (OPERATING_FACILITY_ID,EPISODE_\
TYPE,PATIENT_ID,EPISODE_ID,VISIT_ID,OUTST_TMP_NUM,PRT_GRP_HDR_CODE,PRT_GRP_LIN\
E_CODE,GROSS_AMT,SERV_DISC_AMT,NET_AMT,MAN_DISC_PERC,MAN_DISC_AMT,MAN_DISC_ACC\
_INT_CODE,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,LINE_NUM,CHARGE_\
TYPE_CODE,DF_PHYSICIAN_ID,AMT_SIGN_IND,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFI\
ED_AT_WS_NO,MODIFIED_FACILITY_ID) values (:b0,'O',:b1,:b2,:b3,:b4,:b5,:b6,:b7,\
:b8,:b9,0,0,null ,USER,SYSDATE,USER,SYSDATE,:b10,:b11,:b12,0,'DFLT',:b0,'DFLT'\
,:b0)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )433;
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
    sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[2] = (unsigned int  )11;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_visit_id;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_next_doc_no;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_old_prt_grp_hdr_code;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_old_prt_grp_line_code;
    sqlstm.sqhstl[6] = (unsigned int  )5;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&billin_gross_amt;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&billin_disc_amt;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&billin_net_amt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_bill_line_num;
    sqlstm.sqhstl[10] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_old_charge_type_code;
    sqlstm.sqhstl[11] = (unsigned int  )4;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_old_df_physician_id;
    sqlstm.sqhstl[12] = (unsigned int  )18;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[13] = (unsigned int  )5;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[14] = (unsigned int  )5;
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
	err_mesg("INSERT failed on table BL_OUTST_LINE",0,"");

    billin_gross_amt  = 0;
    billin_disc_amt   = 0;
    billin_net_amt   = 0;

}
       
insrt_bill_hdr()
{

   /*
   d_reduction_amt = biltot_disc_amt + d_tot_unadj_prep_amt+
                     d_tot_unadj_dep_amt + d_tot_paid_amt;
   */

   d_reduction_amt = biltot_disc_amt + d_tot_unadj_prep_amt+
                     d_tot_unadj_dep_amt + d_tot_paid_amt +
		     t_man_disc_amt + t_overall_disc_amt - t_refund_amt;

   d_bill_amt = biltot_gross_amt - d_reduction_amt;

   d_final_bill_amt += d_bill_amt;

   diff_amt             = 0;
   d_drfee_rec_upd_flag = '\0';
   d_drfee_receipt_amt  = 0;

   if((biltot_hosp_amt - d_reduction_amt) <= 0 ) {
       d_hosp_outst_amt = 0;
       diff_amt = d_reduction_amt - biltot_hosp_amt;
    }
    else
	d_hosp_outst_amt = biltot_hosp_amt - d_reduction_amt;

    if(diff_amt) {
	if((biltot_drfee_amt - diff_amt) <= 0) {
	    d_drfee_outst_amt = 0;
	    d_drfee_receipt_amt = biltot_drfee_amt;
	}
	else {
	    d_drfee_outst_amt = biltot_drfee_amt - diff_amt;
	    d_drfee_receipt_amt = diff_amt;
	}
       d_drfee_rec_upd_flag='Y';
    }
    else
	d_drfee_outst_amt = biltot_drfee_amt;

    /* EXEC SQL INSERT INTO BL_OUTST_HDR
                      (  OPERATING_FACILITY_ID,
						 OUTST_TMP_NUM,
                         DOC_DATE,
                         GROSS_AMT,
                         SERV_DISC_AMT,
                         MAN_DISC_AMT,
                         OVERALL_DISC_PERC,
                         OVERALL_DISC_AMT,
                         PREPAY_ADJ_AMT,
                         DEPOSIT_ADJ_AMT,
                         TOT_PAID_AMT,
                         BILL_AMT,
                         BILL_HOSP_AMT,
                         BILL_DRFEE_AMT,
                         BILL_TOT_AMT,
                         BILL_HOSP_TOT_AMT,
                         BILL_DRFEE_TOT_AMT,
                         BILL_TOT_OUTST_AMT,
                         BILL_HOSP_TOT_OUTST_AMT,
                         BILL_DRFEE_TOT_OUTST_AMT,
                         BILL_PAID_AMT,
                         EPISODE_TYPE,
                         PATIENT_ID,
                         EPISODE_ID,
                         VISIT_ID,
                         ADMISSION_DATE,
                         PHYSICIAN_ID,
						 CLINIC_CODE,
                         CUST_CODE,
                         BLNG_GRP_ID,
                         BILL_TYPE_CODE,
                         CONS_INVOICE_IND,
						 BILL_PRV_DOC_TYPE_CODE,
						 BILL_PRV_DOC_NUMBER,
						 BILL_PRV_DOC_DATE,
						 TOT_REFUND_AMT,
						 ADDED_BY_ID,
						 ADDED_DATE,
						 MODIFIED_BY_ID,
						 MODIFIED_DATE,
						 ADDED_AT_WS_NO,
						 ADDED_FACILITY_ID,
						 MODIFIED_AT_WS_NO,
						 MODIFIED_FACILITY_ID
		      )
	    VALUES    ( 
					:nd_operating_facility_id,
					:d_next_doc_no,
					SYSDATE,
					:biltot_gross_amt,
					:biltot_disc_amt,
                    :d_tot_bus_man_disc_amt,
					0,
                    :d_tot_bus_man_disc_amt,
                    :d_tot_unadj_prep_amt,
                    :d_tot_unadj_dep_amt,
					:d_tot_paid_amt,
					:biltot_gross_amt - :biltot_disc_amt,
					:biltot_hosp_amt,
					:biltot_drfee_amt,
					:d_bill_amt,
					:biltot_hosp_amt,
					:biltot_drfee_amt,
					:d_bill_amt,
					:d_hosp_outst_amt,
					:d_drfee_outst_amt,
					0,
					'O',
					:d_patient_id,
					:nd_episode_id,
					:nd_visit_id,
					TO_DATE(:d_admission_date,'DD/MM/YYYY'),
                    :d_physician_id,
					:d_clinic_code,
					:d_ins_cust_code,
					:d_blng_grp_id,
					:d_bill_type_code,
					:d_cons_invoice_ind,
					:d_epi_bill_doc_type_code,
					:d_epi_bill_doc_number,
					TO_DATE(:d_epi_bill_doc_date),
					:t_refund_amt,
					USER,
					SYSDATE,
					USER,
					SYSDATE,
					'DFLT',
					:nd_operating_facility_id,
					'DFLT',
					:nd_operating_facility_id
		    ); */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into BL_OUTST_HDR (OPERATING_FACILITY_ID,OUTST_TMP\
_NUM,DOC_DATE,GROSS_AMT,SERV_DISC_AMT,MAN_DISC_AMT,OVERALL_DISC_PERC,OVERALL_D\
ISC_AMT,PREPAY_ADJ_AMT,DEPOSIT_ADJ_AMT,TOT_PAID_AMT,BILL_AMT,BILL_HOSP_AMT,BIL\
L_DRFEE_AMT,BILL_TOT_AMT,BILL_HOSP_TOT_AMT,BILL_DRFEE_TOT_AMT,BILL_TOT_OUTST_A\
MT,BILL_HOSP_TOT_OUTST_AMT,BILL_DRFEE_TOT_OUTST_AMT,BILL_PAID_AMT,EPISODE_TYPE\
,PATIENT_ID,EPISODE_ID,VISIT_ID,ADMISSION_DATE,PHYSICIAN_ID,CLINIC_CODE,CUST_C\
ODE,BLNG_GRP_ID,BILL_TYPE_CODE,CONS_INVOICE_IND,BILL_PRV_DOC_TYPE_CODE,BILL_PR\
V_DOC_NUMBER,BILL_PRV_DOC_DATE,TOT_REFUND_AMT,ADDED_BY_ID,ADDED_DATE,MODIFIED_\
BY_ID,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIE\
D_FACILITY_ID) values (:b0,:b1,SYSDATE,:b2,:b3,:b4,0,:b4,:b6,:b7,:b8,(:b2-:b3)\
,:b11,:b12,:b13,:b11,:b12,:b13,:b17,:b18,0,'O',:b19,:b20,:b21,TO_DATE(:b22,'DD\
/MM/YYYY'),:b23,:b24,:b25,:b26,:b27,:b28,:b29,:b30,TO_DATE(:b31),:b32,USER,SYS\
DATE,USER,SYSDATE,'DFLT',:b0,'DFLT',:b0)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )508;
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
    sqlstm.sqhstv[1] = (         void  *)&d_next_doc_no;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&biltot_gross_amt;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&biltot_disc_amt;
    sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_tot_bus_man_disc_amt;
    sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_tot_bus_man_disc_amt;
    sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_tot_unadj_prep_amt;
    sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_tot_unadj_dep_amt;
    sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_tot_paid_amt;
    sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&biltot_gross_amt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&biltot_disc_amt;
    sqlstm.sqhstl[10] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&biltot_hosp_amt;
    sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&biltot_drfee_amt;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_bill_amt;
    sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&biltot_hosp_amt;
    sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&biltot_drfee_amt;
    sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_bill_amt;
    sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&d_hosp_outst_amt;
    sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_drfee_outst_amt;
    sqlstm.sqhstl[18] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[19] = (unsigned int  )23;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[20] = (unsigned int  )11;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&nd_visit_id;
    sqlstm.sqhstl[21] = (unsigned int  )7;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&d_admission_date;
    sqlstm.sqhstl[22] = (unsigned int  )13;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&d_physician_id;
    sqlstm.sqhstl[23] = (unsigned int  )18;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&d_clinic_code;
    sqlstm.sqhstl[24] = (unsigned int  )7;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&d_ins_cust_code;
    sqlstm.sqhstl[25] = (unsigned int  )11;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[26] = (unsigned int  )5;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&d_bill_type_code;
    sqlstm.sqhstl[27] = (unsigned int  )5;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&d_cons_invoice_ind;
    sqlstm.sqhstl[28] = (unsigned int  )1;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&d_epi_bill_doc_type_code;
    sqlstm.sqhstl[29] = (unsigned int  )9;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&d_epi_bill_doc_number;
    sqlstm.sqhstl[30] = (unsigned int  )sizeof(long);
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&d_epi_bill_doc_date;
    sqlstm.sqhstl[31] = (unsigned int  )12;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqhstv[32] = (         void  *)&t_refund_amt;
    sqlstm.sqhstl[32] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[32] = (         int  )0;
    sqlstm.sqindv[32] = (         void  *)0;
    sqlstm.sqinds[32] = (         int  )0;
    sqlstm.sqharm[32] = (unsigned int  )0;
    sqlstm.sqadto[32] = (unsigned short )0;
    sqlstm.sqtdso[32] = (unsigned short )0;
    sqlstm.sqhstv[33] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[33] = (unsigned int  )5;
    sqlstm.sqhsts[33] = (         int  )0;
    sqlstm.sqindv[33] = (         void  *)0;
    sqlstm.sqinds[33] = (         int  )0;
    sqlstm.sqharm[33] = (unsigned int  )0;
    sqlstm.sqadto[33] = (unsigned short )0;
    sqlstm.sqtdso[33] = (unsigned short )0;
    sqlstm.sqhstv[34] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[34] = (unsigned int  )5;
    sqlstm.sqhsts[34] = (         int  )0;
    sqlstm.sqindv[34] = (         void  *)0;
    sqlstm.sqinds[34] = (         int  )0;
    sqlstm.sqharm[34] = (unsigned int  )0;
    sqlstm.sqadto[34] = (unsigned short )0;
    sqlstm.sqtdso[34] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
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
	err_mesg("INSERT failed on table BL_OUTST_HDR",0,"");

     biltot_gross_amt  = 0;
     biltot_disc_amt   = 0;
     biltot_net_amt    = 0;
     biltot_hosp_amt   = 0;
     biltot_drfee_amt  = 0;

}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 35;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )663;
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

close_curs()
{
    /* EXEC SQL CLOSE BL_VISIT_CUR ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )694;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE BL_PAT_CHRGS_FOLIO_CUR ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )709;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

delete_recs()
{

    /* EXEC SQL DELETE BL_OUTST_HDR 
	     WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND    EPISODE_TYPE = 'O'
	     AND    EPISODE_ID   = :nd_episode_id
	     AND    VISIT_ID     = :nd_visit_id
	     AND    PATIENT_ID   = :d_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from BL_OUTST_HDR  where ((((OPERATING_FACILITY_I\
D=:b0 and EPISODE_TYPE='O') and EPISODE_ID=:b1) and VISIT_ID=:b2) and PATIENT_\
ID=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )724;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_visit_id;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
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
	err_mesg("DELETE failed on table BL_OUTST_HDR",0,"");

    /* EXEC SQL DELETE BL_OUTST_LINE 
	     WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND    EPISODE_TYPE = 'O'
	     AND    EPISODE_ID   = :nd_episode_id
	     AND    VISIT_ID     = :nd_visit_id
	     AND    PATIENT_ID   = :d_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from BL_OUTST_LINE  where ((((OPERATING_FACILITY_\
ID=:b0 and EPISODE_TYPE='O') and EPISODE_ID=:b1) and VISIT_ID=:b2) and PATIENT\
_ID=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )755;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_visit_id;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
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
	err_mesg("DELETE failed on table BL_OUTST_LINE",0,"");

    /* EXEC SQL DELETE BL_OUTST_SERV_LINE 
	     WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND    EPISODE_TYPE = 'O'
	     AND    EPISODE_ID   = :nd_episode_id
	     AND    VISIT_ID     = :nd_visit_id
	     AND    PATIENT_ID   = :d_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from BL_OUTST_SERV_LINE  where ((((OPERATING_FACI\
LITY_ID=:b0 and EPISODE_TYPE='O') and EPISODE_ID=:b1) and VISIT_ID=:b2) and PA\
TIENT_ID=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )786;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_visit_id;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
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
	err_mesg("DELETE failed on table BL_OUTST_SERV_LINE",0,"");

    /* EXEC SQL DELETE BL_OUTST_PKG_SERV_LINE 
	     WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND    EPISODE_TYPE = 'O'
	     AND    EPISODE_ID   = :nd_episode_id
	     AND    VISIT_ID     = :nd_visit_id
	     AND    PATIENT_ID   = :d_patient_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 35;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "delete  from BL_OUTST_PKG_SERV_LINE  where ((((OPERATING_\
FACILITY_ID=:b0 and EPISODE_TYPE='O') and EPISODE_ID=:b1) and VISIT_ID=:b2) an\
d PATIENT_ID=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )817;
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
    sqlstm.sqhstv[1] = (         void  *)&nd_episode_id;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_visit_id;
    sqlstm.sqhstl[2] = (unsigned int  )7;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[3] = (unsigned int  )23;
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
	err_mesg("DELETE failed on table BL_OUTST_PKG_SERV_LINE",0,"");

}

get_prv_amts()
{

    double tot_bill_amt         = 0, 
	   tot_bill_paid_amt    = 0, 
	   tot_prepay_adj_amt   = 0,
	   tot_man_disc_amt     = 0,
	   tot_overall_disc_amt = 0,
	   tot_refund_amt       = 0;

    strcpy(t_doc_type_code.arr, d_epi_bill_doc_type_code.arr);
    t_doc_type_code.len = strlen(t_doc_type_code.arr);

    t_doc_num = d_epi_bill_doc_number;

    while(t_doc_type_code.arr[0]) {

	/* EXEC SQL SELECT NVL(BILL_AMT,0),
			NVL(BILL_PAID_AMT,0),
			NVL(PREPAY_ADJ_AMT,0),
			NVL(MAN_DISC_AMT,0),
			NVL(OVERALL_DISC_AMT,0),
			NVL(TOT_REFUND_AMT,0),
			BILL_PRV_DOC_TYPE_CODE,
			BILL_PRV_DOC_NUMBER
		 INTO   :t_bill_amt,
			:t_bill_paid_amt,
			:t_prepay_adj_amt,
			:t_man_disc_amt,
			:t_overall_disc_amt,
			:t_refund_amt,
			:t_doc_type_code,
			:t_doc_num
		 FROM   BL_BILL_HDR
		 WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND    DOC_TYPE_CODE = :t_doc_type_code
		 AND    DOC_NUM       = :t_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 35;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select NVL(BILL_AMT,0) ,NVL(BILL_PAID_AMT,0) ,NVL(PREPAY_ADJ\
_AMT,0) ,NVL(MAN_DISC_AMT,0) ,NVL(OVERALL_DISC_AMT,0) ,NVL(TOT_REFUND_AMT,0) ,\
BILL_PRV_DOC_TYPE_CODE ,BILL_PRV_DOC_NUMBER into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:\
b7  from BL_BILL_HDR where ((OPERATING_FACILITY_ID=:b8 and DOC_TYPE_CODE=:b6) \
and DOC_NUM=:b7)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )848;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&t_bill_amt;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&t_bill_paid_amt;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&t_prepay_adj_amt;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&t_man_disc_amt;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&t_overall_disc_amt;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&t_refund_amt;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&t_doc_type_code;
 sqlstm.sqhstl[6] = (unsigned int  )9;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&t_doc_num;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[8] = (unsigned int  )5;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&t_doc_type_code;
 sqlstm.sqhstl[9] = (unsigned int  )9;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&t_doc_num;
 sqlstm.sqhstl[10] = (unsigned int  )sizeof(long);
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
    	    err_mesg("SELECT failed on table BL_BILL_HDR",0,"");

        if(NO_DATA_FOUND)
	    break;

	tot_bill_amt         += t_bill_amt;
	tot_bill_paid_amt    += t_bill_paid_amt;
	tot_prepay_adj_amt   += t_prepay_adj_amt;
	tot_man_disc_amt     += t_man_disc_amt;
	tot_overall_disc_amt += t_overall_disc_amt;
	tot_refund_amt       += t_refund_amt;
    }

    t_bill_amt         = tot_bill_amt;
    t_bill_paid_amt    = tot_bill_paid_amt;
    t_prepay_adj_amt   = tot_prepay_adj_amt;
    t_man_disc_amt     = tot_man_disc_amt;
    t_overall_disc_amt = tot_overall_disc_amt;
    t_refund_amt       = tot_refund_amt;

    d_tot_paid_amt = t_bill_paid_amt;

}
