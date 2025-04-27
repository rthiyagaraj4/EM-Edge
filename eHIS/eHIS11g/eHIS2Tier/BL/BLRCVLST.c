
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLRCVLST.pc"
};


static unsigned int sqlctx = 1288467435;


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
            void  *sqhstv[39];
   unsigned int   sqhstl[39];
            int   sqhsts[39];
            void  *sqindv[39];
            int   sqinds[39];
   unsigned int   sqharm[39];
   unsigned int   *sqharc[39];
   unsigned short  sqadto[39];
   unsigned short  sqtdso[39];
} sqlstm = {12,39};

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

 static const char *sq0004 = 
"ere ((((((I.doc_type_code=A.doc_type_code and I.doc_number=A.doc_num) and J.\
operating_facility_id=:b0) and I.operating_facility_id=J.operating_facility_id\
) and nvl(I.cancelled_yn,'N')='N') and nvl(J.cancelled_yn,'N')='N') and I.doc_\
ref_num=J.doc_ref_num))))  order by DECODE(:b19,'B',BLNG_GRP_ID,'C',CUST_CODE,\
'P',PATIENT_ID,'E',EPISODE)            ";

 static const char *sq0005 = 
"doc_number=A.doc_num) and J.operating_facility_id=:b16) and I.operating_faci\
lity_id=J.operating_facility_id) and nvl(I.cancelled_yn,'N')='N') and nvl(J.ca\
ncelled_yn,'N')='N') and I.doc_ref_num=J.doc_ref_num))) and  not exists (selec\
t I.DOC_TYPE_CODE ,I.DOC_NUMBER  from BL_COVERING_LET_DETAIL I ,BL_COVERING_LE\
T_HEADER J where ((((((I.doc_type_code=A.bill_doc_type_code and I.doc_number=A\
.bill_num) and J.operating_facility_id=:b16) and I.operating_facility_id=J.ope\
rating_facility_id) and nvl(I.cancelled_yn,'N')='N') and nvl(J.cancelled_yn,'N\
')='N') and I.doc_ref_num=J.doc_ref_num))))  order by DECODE(:b19,'B',BLNG_GRP\
_ID,'C',CUST_CODE,'P',PATIENT_ID,'E',EPISODE)            ";

 static const char *sq0006 = 
"PE_CODE ,I.DOC_NUMBER  from BL_COVERING_LET_DETAIL I ,BL_COVERING_LET_HEADER\
 J where ((((((I.doc_type_code=A.doc_type_code and I.doc_number=A.doc_num) and\
 J.operating_facility_id=:b0) and I.operating_facility_id=J.operating_facility\
_id) and nvl(I.cancelled_yn,'N')='N') and nvl(J.cancelled_yn,'N')='N') and I.d\
oc_ref_num=J.doc_ref_num))) and  not exists (select I.DOC_TYPE_CODE ,I.DOC_NUM\
BER  from BL_COVERING_LET_DETAIL I ,BL_COVERING_LET_HEADER J where ((((((I.doc\
_type_code=A.bill_doc_type_code and I.doc_number=A.bill_num) and J.operating_f\
acility_id=:b0) and I.operating_facility_id=J.operating_facility_id) and nvl(I\
.cancelled_yn,'N')='N') and nvl(J.cancelled_yn,'N')='N') and I.doc_ref_num=J.d\
oc_ref_num))))  order by DECODE(:b38,'B',BLNG_GRP_ID,'C',CUST_CODE,'P',PATIENT\
_ID,'E',EPISODE)            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,159,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,323,0,4,209,0,0,21,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
135,0,0,3,84,0,2,266,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
162,0,0,4,2397,0,9,624,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
257,0,0,5,2727,0,9,632,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
352,0,0,6,4902,0,9,640,0,0,39,39,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
523,0,0,4,0,0,15,650,0,0,0,0,0,1,0,
538,0,0,5,0,0,15,653,0,0,0,0,0,1,0,
553,0,0,6,0,0,15,656,0,0,0,0,0,1,0,
568,0,0,4,0,0,13,694,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,
627,0,0,5,0,0,13,714,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,
686,0,0,6,0,0,13,734,0,0,11,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,
745,0,0,7,96,0,4,752,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
772,0,0,8,94,0,4,761,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
799,0,0,9,218,0,4,853,0,0,7,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,1,9,0,0,
842,0,0,10,0,0,32,875,0,0,0,0,0,1,0,
857,0,0,11,96,0,4,1208,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
880,0,0,12,162,0,6,1215,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
911,0,0,13,199,0,6,1250,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLRCVLST.PC                                  */
/* AUTHOR                : Deepali Gosavi                               */  
/* DATE WRITTEN          : 11/10/2005                                   */      
/************************************************************************/
 
          
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
#define MAX_LINES 44
#define REP_WIDTH 170
#define VER  "VER : 4.10\n"
#define ESC  0x1B
/*
#define DEBUG 0
*/


/* EXEC SQL BEGIN DECLARE SECTION; */ 



/* VARCHAR     hosp_name                       [120],
			date							[20],
            date_time                       [20],
			d_acc_entity_name				[61],
			d_user							[31],
			d_head_name						[31],
			d_sysdate						[20],
			d_curr_date						[20],
			nd_facility_id					[3],
            user_id                         [91],
	        nd_pwd 							[91],
            nd_session_id                   [16],
            nd_pgm_date                     [25],
            d_curr_pgm_name                 [15],
            nd_facility				        [3],
			nd_module_id					[3],    
			nd_cut_off_date					[15], 
			nd_blng_grp_from				[7],
			nd_blng_grp_to					[7], 
			nd_cust_from					[9],    
			nd_cust_to						[9], 
			nd_patient_from					[21], 
			nd_patient_to					[21],
			nd_doc_type_from				[7],
			nd_doc_num_from					[9],
			nd_doc_type_to					[7],  
			nd_doc_num_to					[9],
			nd_episode_from					[9], 
			nd_episode_to					[9],
			nd_visit_from					[5],   
			nd_visit_to						[5],
			nd_episode_type					[2],
			nd_sort_order					[2],
			d_episode_type					[20],
			d_sort_order					[50],
			d_patient_id					[21],
			d_patient_name					[61],
			nd_patient_id                   [21],
			d_doc_type_code					[6],
			l_translated_value				[201],	
			l_pk_value						[100],
			d_receipt_no					[17],
			d_rcpt_date						[20],
			d_bill_no						[17],
			d_refund_no						[17],
			d_bill_date						[20],
			d_bill_date1					[20],
			d_blng_grp						[5],
			d_cust							[9],
			d_episode						[20],
			d_doc_ref_num					[30],
			d_module_id						[50],
			d_cancelled_by					[31],
			d_cancelled_date				[21],
			d_trx_type_ind					[2],
			d_bill_status					[5],
			d_blng_grp_desc					[41],
			d_cust_name						[41],
			nd_temp_date					[20],
			nd_loc_date						[20],
			date_convert					[20],
			p_language_id					[3],
            nd_blng_grp_from1				[7],
			nd_blng_grp_to1					[7],
			nd_cust_from1					[7], 
			nd_cust_to1						[7],
			nd_patient_from1				[7],
			nd_patient_to1					[7],
			nd_doc_type_from1				[7],
			nd_doc_type_to1					[7],
			nd_doc_num_from1				[7],
			nd_doc_num_to1					[7],
			nd_episode_from1				[7],
			nd_episode_to1					[7],
			nd_visit_from1					[7],
			nd_visit_to1					[7]; */ 
struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[61]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[31]; } d_head_name;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate;

struct { unsigned short len; unsigned char arr[20]; } d_curr_date;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[91]; } user_id;

struct { unsigned short len; unsigned char arr[91]; } nd_pwd;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[25]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[15]; } d_curr_pgm_name;

struct { unsigned short len; unsigned char arr[3]; } nd_facility;

struct { unsigned short len; unsigned char arr[3]; } nd_module_id;

struct { unsigned short len; unsigned char arr[15]; } nd_cut_off_date;

struct { unsigned short len; unsigned char arr[7]; } nd_blng_grp_from;

struct { unsigned short len; unsigned char arr[7]; } nd_blng_grp_to;

struct { unsigned short len; unsigned char arr[9]; } nd_cust_from;

struct { unsigned short len; unsigned char arr[9]; } nd_cust_to;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_from;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_to;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type_from;

struct { unsigned short len; unsigned char arr[9]; } nd_doc_num_from;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type_to;

struct { unsigned short len; unsigned char arr[9]; } nd_doc_num_to;

struct { unsigned short len; unsigned char arr[9]; } nd_episode_from;

struct { unsigned short len; unsigned char arr[9]; } nd_episode_to;

struct { unsigned short len; unsigned char arr[5]; } nd_visit_from;

struct { unsigned short len; unsigned char arr[5]; } nd_visit_to;

struct { unsigned short len; unsigned char arr[2]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[2]; } nd_sort_order;

struct { unsigned short len; unsigned char arr[20]; } d_episode_type;

struct { unsigned short len; unsigned char arr[50]; } d_sort_order;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[6]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[17]; } d_receipt_no;

struct { unsigned short len; unsigned char arr[20]; } d_rcpt_date;

struct { unsigned short len; unsigned char arr[17]; } d_bill_no;

struct { unsigned short len; unsigned char arr[17]; } d_refund_no;

struct { unsigned short len; unsigned char arr[20]; } d_bill_date;

struct { unsigned short len; unsigned char arr[20]; } d_bill_date1;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp;

struct { unsigned short len; unsigned char arr[9]; } d_cust;

struct { unsigned short len; unsigned char arr[20]; } d_episode;

struct { unsigned short len; unsigned char arr[30]; } d_doc_ref_num;

struct { unsigned short len; unsigned char arr[50]; } d_module_id;

struct { unsigned short len; unsigned char arr[31]; } d_cancelled_by;

struct { unsigned short len; unsigned char arr[21]; } d_cancelled_date;

struct { unsigned short len; unsigned char arr[2]; } d_trx_type_ind;

struct { unsigned short len; unsigned char arr[5]; } d_bill_status;

struct { unsigned short len; unsigned char arr[41]; } d_blng_grp_desc;

struct { unsigned short len; unsigned char arr[41]; } d_cust_name;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[20]; } date_convert;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[7]; } nd_blng_grp_from1;

struct { unsigned short len; unsigned char arr[7]; } nd_blng_grp_to1;

struct { unsigned short len; unsigned char arr[7]; } nd_cust_from1;

struct { unsigned short len; unsigned char arr[7]; } nd_cust_to1;

struct { unsigned short len; unsigned char arr[7]; } nd_patient_from1;

struct { unsigned short len; unsigned char arr[7]; } nd_patient_to1;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type_from1;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_type_to1;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_num_from1;

struct { unsigned short len; unsigned char arr[7]; } nd_doc_num_to1;

struct { unsigned short len; unsigned char arr[7]; } nd_episode_from1;

struct { unsigned short len; unsigned char arr[7]; } nd_episode_to1;

struct { unsigned short len; unsigned char arr[7]; } nd_visit_from1;

struct { unsigned short len; unsigned char arr[7]; } nd_visit_to1;



	int i,sl_no=1,page_no=0;
	
	
	double d_episode_id,d_visit_id,d_doc_num ;

    double  d_patient_dep_amt=0,d_bill_amt=0, d_bill_outst_amt=0, d_tot_bill_outst_amt=0,
			d_patient_dep_amt_tot=0, d_bill_amt_tot=0,
			d_refund_amt=0, d_amt_adjusted=0, d_refund_amt_tot=0, d_amt_adjusted_tot=0;

	char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];

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

char string_var [100];

int    lctr = 0,pctr = 0,nvalid = 0,ncancel = 0, recctr = 1, ftime = 0, bgftime = 0;


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

	strcpy(g_pgm_id,"BLRCVLST");
	
	

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

		
		strcpy(d_curr_pgm_name.arr,g_pgm_id); 
    	d_curr_pgm_name.len = strlen(d_curr_pgm_name.arr); 

    	strcpy(nd_session_id.arr,argv[2]);
    	nd_session_id.len = strlen(nd_session_id.arr);
    	strcpy(g_session_id,nd_session_id.arr);

    	strcpy(nd_pgm_date.arr,argv[3]);
    	nd_pgm_date.len = strlen(nd_pgm_date.arr);
    	strcpy(g_pgm_date,nd_pgm_date.arr);

    	strcpy(nd_facility.arr,argv[4]);
    	nd_facility.len = strlen(nd_facility.arr);
    	strcpy(g_facility_id,nd_facility.arr);


	nd_module_id.arr[0]		= '\0';	
	nd_cut_off_date.arr[0]	= '\0';	
	nd_blng_grp_from.arr[0]	= '\0';	
	nd_blng_grp_to.arr[0]	= '\0';	 
	nd_cust_from.arr[0]		= '\0';	
	nd_cust_to.arr[0]		= '\0';	 
	nd_patient_from.arr[0]	= '\0';	
	nd_patient_to.arr[0]	= '\0';	
	nd_doc_type_from.arr[0]	= '\0';	
	nd_doc_num_from.arr[0]	= '\0';	
	nd_doc_type_to.arr[0]	= '\0';	
	nd_doc_num_to.arr[0]	= '\0';	
	nd_episode_from.arr[0]	= '\0';	
	nd_episode_to.arr[0]	= '\0';	
	nd_visit_from.arr[0]	= '\0';	
	nd_visit_to.arr[0]		= '\0';	
	nd_episode_type.arr[0]	= '\0';	
	nd_sort_order.arr[0]	= '\0';	

    /* EXEC SQL SELECT	PARAM1, PARAM2, 
					PARAM3, PARAM4, 
					PARAM5, PARAM6, 
					PARAM7, PARAM8, 
					PARAM9, PARAM10,
					PARAM11,PARAM12,
					PARAM13,PARAM14,
					PARAM15,PARAM16,
					PARAM17,PARAM18
			 INTO :nd_module_id,    :nd_cut_off_date, 
				  :nd_blng_grp_from,:nd_blng_grp_to, 
				  :nd_cust_from,    :nd_cust_to, 
				  :nd_patient_from, :nd_patient_to,
				  :nd_doc_type_from,:nd_doc_num_from,
				  :nd_doc_type_to,  :nd_doc_num_to,
				  :nd_episode_from, :nd_episode_to,
				  :nd_visit_from,   :nd_visit_to,
				  :nd_episode_type, :nd_sort_order
			 FROM SY_PROG_PARAM
			 WHERE PGM_ID     = :d_curr_pgm_name
			 AND   SESSION_ID = :nd_session_id
			 AND   PGM_DATE   = :nd_pgm_date; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6 ,PA\
RAM7 ,PARAM8 ,PARAM9 ,PARAM10 ,PARAM11 ,PARAM12 ,PARAM13 ,PARAM14 ,PARAM15 ,PA\
RAM16 ,PARAM17 ,PARAM18 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11\
,:b12,:b13,:b14,:b15,:b16,:b17  from SY_PROG_PARAM where ((PGM_ID=:b18 and SES\
SION_ID=:b19) and PGM_DATE=:b20)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )36;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_module_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_cut_off_date;
    sqlstm.sqhstl[1] = (unsigned int  )17;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_blng_grp_from;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_blng_grp_to;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_cust_from;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_cust_to;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_patient_from;
    sqlstm.sqhstl[6] = (unsigned int  )23;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_patient_to;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_doc_type_from;
    sqlstm.sqhstl[8] = (unsigned int  )9;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_doc_num_from;
    sqlstm.sqhstl[9] = (unsigned int  )11;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_doc_type_to;
    sqlstm.sqhstl[10] = (unsigned int  )9;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_doc_num_to;
    sqlstm.sqhstl[11] = (unsigned int  )11;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_episode_from;
    sqlstm.sqhstl[12] = (unsigned int  )11;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_episode_to;
    sqlstm.sqhstl[13] = (unsigned int  )11;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_visit_from;
    sqlstm.sqhstl[14] = (unsigned int  )7;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_visit_to;
    sqlstm.sqhstl[15] = (unsigned int  )7;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[16] = (unsigned int  )4;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_sort_order;
    sqlstm.sqhstl[17] = (unsigned int  )4;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_curr_pgm_name;
    sqlstm.sqhstl[18] = (unsigned int  )17;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_session_id;
    sqlstm.sqhstl[19] = (unsigned int  )18;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&nd_pgm_date;
    sqlstm.sqhstl[20] = (unsigned int  )27;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	/*sprintf(string_var , "nd fromdays %4d" , nd_from_days);
	disp_message(ERR_MESG, string_var);

	sprintf(string_var , "nd to days %4d" , nd_to_days);
	disp_message(ERR_MESG, string_var);*/


   if (OERROR)
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");


	nd_module_id.arr[nd_module_id.len]			= '\0';	
	nd_cut_off_date.arr[nd_cut_off_date.len]	= '\0';	
	nd_blng_grp_from.arr[nd_blng_grp_from.len]	= '\0';	
	nd_blng_grp_to.arr[nd_blng_grp_to.len]		= '\0';	 
	nd_cust_from.arr[nd_cust_from.len]			= '\0';	
	nd_cust_to.arr[nd_cust_to.len]				= '\0';	 
	nd_patient_from.arr[nd_patient_from.len]	= '\0';	
	nd_patient_to.arr[nd_patient_to.len]		= '\0';	
	nd_doc_type_from.arr[nd_doc_type_from.len]	= '\0';	
	nd_doc_num_from.arr[nd_doc_num_from.len]	= '\0';	
	nd_doc_type_to.arr[nd_doc_type_to.len]		= '\0';	
	nd_doc_num_to.arr[nd_doc_num_to.len]		= '\0';	
	nd_episode_from.arr[nd_episode_from.len]	= '\0';	
	nd_episode_to.arr[nd_episode_to.len]		= '\0';	
	nd_visit_from.arr[nd_visit_from.len]		= '\0';	
	nd_visit_to.arr[nd_visit_to.len]			= '\0';	
	nd_episode_type.arr[nd_episode_type.len]	= '\0';	
	nd_sort_order.arr[nd_sort_order.len]		= '\0';	

         
   /* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 21;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION\
_ID=:b1) and PGM_DATE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )135;
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
    open_files();

    declare_cur();
	get_header_dtls();
	//get_language_id();

	fetch_legend_value();

	fprintf(fp,"%c&l1O",ESC);				/* Set Landscape*/ 
 	fprintf(fp, "%c(s17H", ESC);			/* Reduce the font size*/
	fprintf(fp,"%c&a4L",ESC); 				/* To Set the Left margin*/

    print_param();
     open_det_cur();
 
    while(fetch_det_cur())
    {										
		print_rec();  								
    }	

    print_tot();
    print_end();

	fprintf(fp,"%cE",ESC); /* To Reset the Printer */
 }

 
open_files()
{

    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLRCVLST.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLRCVLST.lis");
       proc_exit();
    }

}

declare_cur()
{

    if (strcmp(nd_module_id.arr, "BL") == 0)
	{

	   /* EXEC SQL DECLARE DET_CUR_BL CURSOR FOR
	   SELECT BLNG_GRP_ID, CUST_CODE, PATIENT_ID, TRX_TYPE_IND, MODULE_ID,
			  BILL_NO, BILL_DATE, EPISODE, BILL_STATUS,
			  BILL_AMT, BILL_TOT_OUTST_AMT	
	   FROM
	   (
	   SELECT A.BLNG_GRP_ID, A.CUST_CODE, A.PATIENT_ID,D.TRX_TYPE_CODE TRX_TYPE_IND, 'BL' MODULE_ID,		//B.GROUP_CODE,
              A.DOC_TYPE_CODE||'/'||to_char(A.DOC_NUM) BILL_NO, TO_CHAR(A.DOC_DATE, 'DD/MM/YYYY') BILL_DATE, 
  			  DECODE(EPISODE_TYPE, 'I', EPISODE_TYPE||'/'||to_char(EPISODE_ID),
								   'D', EPISODE_TYPE||'/'||to_char(EPISODE_ID),
								   'E', EPISODE_TYPE||'/'||to_char(EPISODE_ID)||'/'||to_char(VISIT_ID),		
								   'O', EPISODE_TYPE||'/'||to_char(EPISODE_ID)||'/'||to_char(VISIT_ID),		
								   'R', EPISODE_TYPE)	EPISODE,	
              decode(nvl(BILL_STATUS,'B'), 'B', 'Bill',
										   'D', 'DCP',
										   'A', 'INV') BILL_STATUS, 
              BILL_AMT, BILL_TOT_OUTST_AMT
       FROM   BL_BILL_DCP_DTL_VW A, BL_COVERING_LET_SETUP B, 
			  BL_TRN_DOC_TYPE D
       WHERE  A.OPERATING_FACILITY_ID = :nd_facility
	   AND    A.DOC_DATE <= TO_DATE(:nd_cut_off_date,'DD/MM/YYYY')
	   AND    BLNG_GRP_ID BETWEEN NVL(:nd_blng_grp_from,'!!')
						   AND     NVL(:nd_blng_grp_to, '~~') 
	   AND    nvl(A.CUST_CODE, '!!!!!!!!') BETWEEN NVL(:nd_cust_from, '!!!!!!!!')    
									     AND     NVL(:nd_cust_to, '~~~~~~~~')
	   AND    EPISODE_TYPE = DECODE(:nd_episode_type, 'I', 'I',
													   'D', 'D',
													   'O', 'O',
													   'E', 'E',
													   'R', 'R',
													   'A', EPISODE_TYPE)	
	   AND    A.PATIENT_ID BETWEEN NVL(:nd_patient_from, '!!!!!!!!!!!!!!!!!!!!')
						 AND     NVL(:nd_patient_to, '~~~~~~~~~~~~~~~~~~~~')
	   AND    ((EPISODE_TYPE = 'R') or
				(EPISODE_TYPE IN ('I', 'D', 'O', 'E') AND 
				to_char(EPISODE_ID) BETWEEN NVL(:nd_episode_from, '!!!!!!!!')
								    AND     NVL(:nd_episode_to, '~~~~~~~~')
				)
			   )	
	   AND    ( EPISODE_TYPE IN ('R', 'I', 'D') or
                (EPISODE_TYPE IN ('O', 'E') AND
				 to_char(VISIT_ID) BETWEEN NVL(:nd_visit_from, '!!!!')
						           AND     NVL(:nd_visit_to, '~~~~')
			    ) 	
			   )
	   AND    RPAD(A.DOC_TYPE_CODE,6,' ')|| LPAD(A.DOC_NUM,8,'0') BETWEEN
              RPAD(NVL(:nd_doc_type_from,' '),6,' ')||LPAD(NVL(:nd_doc_num_from,0),8,'0') AND
              RPAD(NVL(:nd_doc_type_to,'~~~~~~'),6,' ')||LPAD(NVL(:nd_doc_num_to,99999999),8,'0')   
	   AND    b.operating_facility_id (+) = :nd_facility
	   AND    A.PATIENT_ID = B.PATIENT_ID(+)
	   AND    NVL(A.CUST_CODE, '$#$#$#$#') = NVL(B.CUST_CODE(+), '$#$#$#$#')		//28/11/2005
       AND    A.DOC_TYPE_CODE = D.DOC_TYPE_CODE
       AND    NVL(BILL_TOT_OUTST_AMT,0) <> 0
       AND    nvl(BILL_STATUS,'X') not in ('C','S','A')
       and    Not Exists 
					( select I.DOC_TYPE_CODE,I.DOC_NUMBER 
					  from   BL_COVERING_LET_DETAIL I, BL_COVERING_LET_HEADER J
					  where  I.doc_type_code = A.doc_type_code
					  and	 I.doc_number = A.doc_num
					  and	 J.operating_facility_id = :nd_facility
					  and    I.operating_facility_id = J.operating_facility_id 
					  and    nvl(I.cancelled_yn,'N') = 'N'
					  and    nvl(J.cancelled_yn,'N') = 'N'
					  and    I.doc_ref_num = J.doc_ref_num
					 )
	   )
	   ORDER BY DECODE(:nd_sort_order, 'B', BLNG_GRP_ID,
										'C', CUST_CODE,
										'P', PATIENT_ID,
										'E', EPISODE); */ 
	   
	}

   if (strcmp(nd_module_id.arr, "AR") == 0)
   {
	   /* EXEC SQL DECLARE DET_CUR_AR CURSOR FOR
	   SELECT BLNG_GRP_ID, CUST_CODE, PATIENT_ID, TRX_TYPE_IND, MODULE_ID,
			  BILL_NO, BILL_DATE, EPISODE, BILL_STATUS,
			  BILL_AMT, BILL_TOT_OUTST_AMT	
	   FROM
	   (
	   Select A.BILLING_GROUP BLNG_GRP_ID, A.CUST_CODE, A.PATIENT_ID,TRN_TYPE_CODE TRX_TYPE_IND, 'AR' MODULE_ID,
              A.DOC_TYPE_CODE||'-'||TO_CHAR(A.DOC_NUM) BILL_NO, TO_CHAR(A.DOC_DATE, 'DD/MM/YYYY') BILL_DATE, 
   			  DECODE(EPISODE_TYPE, 'I', EPISODE_TYPE||'/'||to_char(EPISODE_ID),
								   'D', EPISODE_TYPE||'/'||to_char(EPISODE_ID),
								   'E', EPISODE_TYPE||'/'||to_char(EPISODE_ID)||'/'||to_char(VISIT_ID),		
								   'O', EPISODE_TYPE||'/'||to_char(EPISODE_ID)||'/'||to_char(VISIT_ID),		
								   'R', EPISODE_TYPE)	EPISODE,	
              'INV' BILL_STATUS ,
			  A.PAYABLE_AMT BILL_AMT,A.PENDING_AMT BILL_TOT_OUTST_AMT
	   FROM   AR_PENDING_DOC A, BL_COVERING_LET_SETUP B
	   WHERE  A.DOC_DATE <= TO_DATE(:nd_cut_off_date,'DD/MM/YYYY')
	   AND    A.BILLING_GROUP BETWEEN NVL(:nd_blng_grp_from,'!!')
						      AND     NVL(:nd_blng_grp_to, '~~') 
	   AND    nvl(A.CUST_CODE, '!!!!!!!!') BETWEEN NVL(:nd_cust_from, '!!!!!!!!')    
										   AND     NVL(:nd_cust_to, '~~~~~~~~')
	   AND    nvl(EPISODE_TYPE, 'R') = DECODE(:nd_episode_type, 'I', 'I',
													   'D', 'D',
													   'O', 'O',
													   'E', 'E',
													   'R', 'R',
													   ' ', 'R',			
													   'A', nvl(EPISODE_TYPE, 'R'))	
	   AND    A.PATIENT_ID BETWEEN NVL(:nd_patient_from, '!!!!!!!!!!!!!!!!!!!!')
						 AND     NVL(:nd_patient_to, '~~~~~~~~~~~~~~~~~~~~')
	   AND    ((nvl(EPISODE_TYPE, 'R') in ('R', ' ')) or
				(nvl(EPISODE_TYPE, 'R') IN ('I', 'D', 'O', 'E') AND 
				to_char(EPISODE_ID) BETWEEN NVL(:nd_episode_from, '!!!!!!!!')
								    AND     NVL(:nd_episode_to, '~~~~~~~~')
				)
			   )	
	   AND    ( nvl(EPISODE_TYPE, 'R') IN ('R', 'I', 'D', ' ') or
                (nvl(EPISODE_TYPE, 'R') IN ('O', 'E') AND
				 to_char(VISIT_ID) BETWEEN NVL(:nd_visit_from, '!!!!')
						           AND     NVL(:nd_visit_to, '~~~~')
			    ) 	
			   )
	   AND    RPAD(A.DOC_TYPE_CODE,6,' ')|| LPAD(A.DOC_NUM,8,'0') BETWEEN
              RPAD(NVL(:nd_doc_type_from,' '),6,' ')||LPAD(NVL(:nd_doc_num_from,0),8,'0') AND
              RPAD(NVL(:nd_doc_type_to,'~~~~~~'),6,' ')||LPAD(NVL(:nd_doc_num_to,99999999),8,'0')   
	   AND    b.operating_facility_id (+) = :nd_facility
	   AND    A.PATIENT_ID = B.PATIENT_ID(+)
	   AND    NVL(A.CUST_CODE, '$#$#$#$#') = NVL(B.CUST_CODE(+), '$#$#$#$#')		//28/11/2005
       AND    NVL(A.PENDING_AMT ,0) <> 0
	   AND    A.TRN_TYPE_CODE  IN ('1','3')
	   AND    Not Exists (
							Select I.DOC_TYPE_CODE,I.DOC_NUMBER 
							from BL_COVERING_LET_DETAIL I, BL_COVERING_LET_HEADER J
							where I.doc_type_code = A.doc_type_code
							and   I.doc_number = A.doc_num
							and   J.operating_facility_id = :nd_facility
							and   I.operating_facility_id = J.operating_facility_id 
							and   nvl(I.cancelled_yn,'N') = 'N'
							and   nvl(J.cancelled_yn,'N') = 'N'
							and   I.doc_ref_num = J.doc_ref_num
						  )
		AND    Not Exists (
							Select I.DOC_TYPE_CODE,I.DOC_NUMBER 
							from BL_COVERING_LET_DETAIL I, BL_COVERING_LET_HEADER J
							where I.doc_type_code = A.bill_doc_type_code
							and   I.doc_number = A.bill_num
							and   J.operating_facility_id = :nd_facility
							and   I.operating_facility_id = J.operating_facility_id 
							and   nvl(I.cancelled_yn,'N') = 'N'
							and   nvl(J.cancelled_yn,'N') = 'N'
							and   I.doc_ref_num = J.doc_ref_num
						  )
	   ) 
	   ORDER BY DECODE(:nd_sort_order, 'B', BLNG_GRP_ID,
										'C', CUST_CODE,
										'P', PATIENT_ID,
										'E', EPISODE); */ 

   }

   if (strcmp(nd_module_id.arr, "**")==0)
   {
	   
	   /* EXEC SQL DECLARE DET_CUR CURSOR FOR
	   SELECT BLNG_GRP_ID, CUST_CODE, PATIENT_ID, TRX_TYPE_IND, MODULE_ID,
			  BILL_NO, BILL_DATE, EPISODE, BILL_STATUS,
			  BILL_AMT, BILL_TOT_OUTST_AMT	
	   FROM
	   (
	   SELECT A.BLNG_GRP_ID, A.CUST_CODE, A.PATIENT_ID,D.TRX_TYPE_CODE TRX_TYPE_IND, 'BL' MODULE_ID,		//B.GROUP_CODE,
              A.DOC_TYPE_CODE||'-'||to_char(A.DOC_NUM) BILL_NO, TO_CHAR(A.DOC_DATE, 'DD/MM/YYYY') BILL_DATE, 
  			  DECODE(EPISODE_TYPE, 'I', EPISODE_TYPE||'/'||to_char(EPISODE_ID),
								   'D', EPISODE_TYPE||'/'||to_char(EPISODE_ID),
								   'E', EPISODE_TYPE||'/'||to_char(EPISODE_ID)||'/'||to_char(VISIT_ID),		
								   'O', EPISODE_TYPE||'/'||to_char(EPISODE_ID)||'/'||to_char(VISIT_ID),		
								   'R', EPISODE_TYPE)	EPISODE,	
              decode(nvl(BILL_STATUS,'B'), 'B', 'Bill',
										   'D', 'DCP',
										   'A', 'INV') BILL_STATUS, 
              BILL_AMT, BILL_TOT_OUTST_AMT
       FROM   BL_BILL_DCP_DTL_VW A, BL_COVERING_LET_SETUP B, 
			  BL_TRN_DOC_TYPE D
       WHERE  A.OPERATING_FACILITY_ID = :nd_facility
	   AND    A.DOC_DATE <= TO_DATE(:nd_cut_off_date,'DD/MM/YYYY')
	   AND    BLNG_GRP_ID BETWEEN NVL(:nd_blng_grp_from,'!!')
						   AND     NVL(:nd_blng_grp_to, '~~') 
	   AND    nvl(A.CUST_CODE, '!!!!!!!!') BETWEEN NVL(:nd_cust_from, '!!!!!!!!')    
									     AND     NVL(:nd_cust_to, '~~~~~~~~')
	   AND    EPISODE_TYPE = DECODE(:nd_episode_type, 'I', 'I',
													   'D', 'D',
													   'O', 'O',
													   'E', 'E',
													   'R', 'R',
													   ' ', 'R',			
													   'A', EPISODE_TYPE)		
	   AND    A.PATIENT_ID BETWEEN NVL(:nd_patient_from, '!!!!!!!!!!!!!!!!!!!!')
						 AND     NVL(:nd_patient_to, '~~~~~~~~~~~~~~~~~~~~')
	   AND    ((EPISODE_TYPE = 'R') or
				(EPISODE_TYPE IN ('I', 'D', 'O', 'E') AND 
				to_char(EPISODE_ID) BETWEEN NVL(:nd_episode_from, '!!!!!!!!')
								    AND     NVL(:nd_episode_to, '~~~~~~~~')
				)
			   )	
	   AND    ( EPISODE_TYPE IN ('R', 'I', 'D') or
                (EPISODE_TYPE IN ('O', 'E') AND
				 to_char(VISIT_ID) BETWEEN NVL(:nd_visit_from, '!!!!')
						           AND     NVL(:nd_visit_to, '~~~~')
			    ) 	
			   )
	   AND    RPAD(A.DOC_TYPE_CODE,6,' ')|| LPAD(A.DOC_NUM,8,'0') BETWEEN
              RPAD(NVL(:nd_doc_type_from,' '),6,' ')||LPAD(NVL(:nd_doc_num_from,0),8,'0') AND
              RPAD(NVL(:nd_doc_type_to,'~~~~~~'),6,' ')||LPAD(NVL(:nd_doc_num_to,99999999),8,'0')   
	   AND    b.operating_facility_id (+) = :nd_facility
	   AND    A.PATIENT_ID = B.PATIENT_ID(+)
	   AND    NVL(A.CUST_CODE, '$#$#$#$#') = NVL(B.CUST_CODE(+), '$#$#$#$#')		//28/11/2005
       AND    A.DOC_TYPE_CODE = D.DOC_TYPE_CODE
       AND    NVL(BILL_TOT_OUTST_AMT,0) <> 0
       AND    nvl(BILL_STATUS,'X') not in ('C','S','A')
       and    Not Exists 
					( select I.DOC_TYPE_CODE,I.DOC_NUMBER 
					  from   BL_COVERING_LET_DETAIL I, BL_COVERING_LET_HEADER J
					  where  I.doc_type_code = A.doc_type_code
					  and	 I.doc_number = A.doc_num
					  and	 J.operating_facility_id = :nd_facility
					  and    I.operating_facility_id = J.operating_facility_id 
					  and    nvl(I.cancelled_yn,'N') = 'N'
					  and    nvl(J.cancelled_yn,'N') = 'N'
					  and    I.doc_ref_num = J.doc_ref_num
					 )
	   Union all
	   Select A.BILLING_GROUP BLNG_GRP_ID, A.CUST_CODE, A.PATIENT_ID,TRN_TYPE_CODE TRX_TYPE_IND, 'AR' MODULE_ID,
              A.DOC_TYPE_CODE||'-'||TO_CHAR(A.DOC_NUM) BILL_NO, TO_CHAR(A.DOC_DATE, 'DD/MM/YYYY') BILL_DATE, 
   			  DECODE(EPISODE_TYPE, 'I', EPISODE_TYPE||'/'||to_char(EPISODE_ID),
								   'D', EPISODE_TYPE||'/'||to_char(EPISODE_ID),
								   'E', EPISODE_TYPE||'/'||to_char(EPISODE_ID)||'/'||to_char(VISIT_ID),		
								   'O', EPISODE_TYPE||'/'||to_char(EPISODE_ID)||'/'||to_char(VISIT_ID),		
								   'R', EPISODE_TYPE)	EPISODE,	
              'INV' BILL_STATUS ,
			  A.PAYABLE_AMT BILL_AMT,A.PENDING_AMT BILL_TOT_OUTST_AMT
	   FROM   AR_PENDING_DOC A, BL_COVERING_LET_SETUP B
	   WHERE  A.DOC_DATE <= TO_DATE(:nd_cut_off_date,'DD/MM/YYYY')
	   AND    A.BILLING_GROUP BETWEEN NVL(:nd_blng_grp_from,'!!')
						      AND     NVL(:nd_blng_grp_to, '~~') 
	   AND    nvl(A.CUST_CODE, '!!!!!!!!') BETWEEN NVL(:nd_cust_from, '!!!!!!!!')    
										   AND     NVL(:nd_cust_to, '~~~~~~~~')
	   AND    nvl(EPISODE_TYPE, 'R') = DECODE(:nd_episode_type, 'I', 'I',
													   'D', 'D',
													   'O', 'O',
													   'E', 'E',
													   'R', 'R',
													   ' ', 'R',			
													   'A', nvl(EPISODE_TYPE, 'R'))	
	   AND    A.PATIENT_ID BETWEEN NVL(:nd_patient_from, '!!!!!!!!!!!!!!!!!!!!')
						 AND     NVL(:nd_patient_to, '~~~~~~~~~~~~~~~~~~~~')
	   AND    ((nvl(EPISODE_TYPE, 'R') in ('R', ' ')) or
				(nvl(EPISODE_TYPE, 'R') IN ('I', 'D', 'O', 'E') AND 
				to_char(EPISODE_ID) BETWEEN NVL(:nd_episode_from, '!!!!!!!!')
								    AND     NVL(:nd_episode_to, '~~~~~~~~')
				)
			   )	
	   AND    ( nvl(EPISODE_TYPE, 'R') IN ('R', 'I', 'D', ' ') or
                (nvl(EPISODE_TYPE, 'R') IN ('O', 'E') AND
				 to_char(VISIT_ID) BETWEEN NVL(:nd_visit_from, '!!!!')
						           AND     NVL(:nd_visit_to, '~~~~')
			    ) 	
			   )
	   AND    RPAD(A.DOC_TYPE_CODE,6,' ')|| LPAD(A.DOC_NUM,8,'0') BETWEEN
              RPAD(NVL(:nd_doc_type_from,' '),6,' ')||LPAD(NVL(:nd_doc_num_from,0),8,'0') AND
              RPAD(NVL(:nd_doc_type_to,'~~~~~~'),6,' ')||LPAD(NVL(:nd_doc_num_to,99999999),8,'0')   
	   AND    b.operating_facility_id (+) = :nd_facility
	   AND    A.PATIENT_ID = B.PATIENT_ID(+)
	   AND    NVL(A.CUST_CODE, '$#$#$#$#') = NVL(B.CUST_CODE(+), '$#$#$#$#')		//28/11/2005
       AND    NVL(A.PENDING_AMT ,0) <> 0
	   AND    A.TRN_TYPE_CODE  IN ('1','3')
	   AND    Not Exists (
							Select I.DOC_TYPE_CODE,I.DOC_NUMBER 
							from BL_COVERING_LET_DETAIL I, BL_COVERING_LET_HEADER J
							where I.doc_type_code = A.doc_type_code
							and   I.doc_number = A.doc_num
							and   J.operating_facility_id = :nd_facility
							and   I.operating_facility_id = J.operating_facility_id 
							and   nvl(I.cancelled_yn,'N') = 'N'
							and   nvl(J.cancelled_yn,'N') = 'N'
							and   I.doc_ref_num = J.doc_ref_num
						  )
		AND    Not Exists (
							Select I.DOC_TYPE_CODE,I.DOC_NUMBER 
							from BL_COVERING_LET_DETAIL I, BL_COVERING_LET_HEADER J
							where I.doc_type_code = A.bill_doc_type_code
							and   I.doc_number = A.bill_num
							and   J.operating_facility_id = :nd_facility
							and   I.operating_facility_id = J.operating_facility_id 
							and   nvl(I.cancelled_yn,'N') = 'N'
							and   nvl(J.cancelled_yn,'N') = 'N'
							and   I.doc_ref_num = J.doc_ref_num
						  )
	   )  	
	   ORDER BY DECODE(:nd_sort_order, 'B', BLNG_GRP_ID,
										'C', CUST_CODE,
										'P', PATIENT_ID,
										'E', EPISODE); */ 

   }
		     
}


open_det_cur()
{
   
   if (strcmp(nd_module_id.arr, "BL") == 0)
   {
 	  /* EXEC SQL OPEN DET_CUR_BL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 21;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select BLNG_GRP_ID ,CUST_CODE ,PATIENT_ID ,TRX_TYPE_IND ,MODULE_ID ,B\
ILL_NO ,BILL_DATE ,EPISODE ,BILL_STATUS ,BILL_AMT ,BILL_TOT_OUTST_AMT  from \
(select A.BLNG_GRP_ID ,A.CUST_CODE ,A.PATIENT_ID ,D.TRX_TYPE_CODE TRX_TYPE_I\
ND ,'BL' MODULE_ID ,((A.DOC_TYPE_CODE||'/')||to_char(A.DOC_NUM)) BILL_NO ,TO\
_CHAR(A.DOC_DATE,'DD/MM/YYYY') BILL_DATE ,DECODE(EPISODE_TYPE,'I',((EPISODE_\
TYPE||'/')||to_char(EPISODE_ID)),'D',((EPISODE_TYPE||'/')||to_char(EPISODE_I\
D)),'E',((((EPISODE_TYPE||'/')||to_char(EPISODE_ID))||'/')||to_char(VISIT_ID\
)),'O',((((EPISODE_TYPE||'/')||to_char(EPISODE_ID))||'/')||to_char(VISIT_ID)\
),'R',EPISODE_TYPE) EPISODE ,decode(nvl(BILL_STATUS,'B'),'B','Bill','D','DCP\
','A','INV') BILL_STATUS ,BILL_AMT ,BILL_TOT_OUTST_AMT  from BL_BILL_DCP_DTL\
_VW A ,BL_COVERING_LET_SETUP B ,BL_TRN_DOC_TYPE D where (((((((((((((((A.OPE\
RATING_FACILITY_ID=:b0 and A.DOC_DATE<=TO_DATE(:b1,'DD/MM/YYYY')) and BLNG_G\
RP_ID between NVL(:b2,'!!') and NVL(:b3,'~~')) and nvl(A.CUST_CODE,'!!!!!!!!\
') between NVL(:b4,'!!!!!!!!') and NVL(:b5,");
    sqlbuft((void **)0, 
      "'~~~~~~~~')) and EPISODE_TYPE=DECODE(:b6,'I','I','D','D','O','O','E',\
'E','R','R','A',EPISODE_TYPE)) and A.PATIENT_ID between NVL(:b7,'!!!!!!!!!!!\
!!!!!!!!!') and NVL(:b8,'~~~~~~~~~~~~~~~~~~~~')) and (EPISODE_TYPE='R' or (E\
PISODE_TYPE in ('I','D','O','E') and to_char(EPISODE_ID) between NVL(:b9,'!!\
!!!!!!') and NVL(:b10,'~~~~~~~~')))) and (EPISODE_TYPE in ('R','I','D') or (\
EPISODE_TYPE in ('O','E') and to_char(VISIT_ID) between NVL(:b11,'!!!!') and\
 NVL(:b12,'~~~~')))) and (RPAD(A.DOC_TYPE_CODE,6,' ')||LPAD(A.DOC_NUM,8,'0')\
) between (RPAD(NVL(:b13,' '),6,' ')||LPAD(NVL(:b14,0),8,'0')) and (RPAD(NVL\
(:b15,'~~~~~~'),6,' ')||LPAD(NVL(:b16,99999999),8,'0'))) and b.operating_fac\
ility_id(+)=:b0) and A.PATIENT_ID=B.PATIENT_ID(+)) and NVL(A.CUST_CODE,'$#$#\
$#$#')=NVL(B.CUST_CODE(+),'$#$#$#$#')) and A.DOC_TYPE_CODE=D.DOC_TYPE_CODE) \
and NVL(BILL_TOT_OUTST_AMT,0)<>0) and nvl(BILL_STATUS,'X') not  in ('C','S',\
'A')) and  not exists (select I.DOC_TYPE_CODE ,I.DOC_NUMBER  from BL_COVERIN\
G_LET_DETAIL I ,BL_COVERING_LET_HEADER J wh");
    sqlstm.stmt = sq0004;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )162;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_facility;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_cut_off_date;
    sqlstm.sqhstl[1] = (unsigned int  )17;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_blng_grp_from;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_blng_grp_to;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_cust_from;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_cust_to;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_patient_from;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_patient_to;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_episode_from;
    sqlstm.sqhstl[9] = (unsigned int  )11;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_episode_to;
    sqlstm.sqhstl[10] = (unsigned int  )11;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_visit_from;
    sqlstm.sqhstl[11] = (unsigned int  )7;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_visit_to;
    sqlstm.sqhstl[12] = (unsigned int  )7;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_doc_type_from;
    sqlstm.sqhstl[13] = (unsigned int  )9;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_doc_num_from;
    sqlstm.sqhstl[14] = (unsigned int  )11;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_doc_type_to;
    sqlstm.sqhstl[15] = (unsigned int  )9;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_doc_num_to;
    sqlstm.sqhstl[16] = (unsigned int  )11;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_facility;
    sqlstm.sqhstl[17] = (unsigned int  )5;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_facility;
    sqlstm.sqhstl[18] = (unsigned int  )5;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_sort_order;
    sqlstm.sqhstl[19] = (unsigned int  )4;
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
          err_mesg("OPEN failed on cursor DET_CUR_BL",0,"");

   }

   if (strcmp(nd_module_id.arr, "AR") == 0)
   {
       /* EXEC SQL OPEN DET_CUR_AR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 21;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlbuft((void **)0, 
         "select BLNG_GRP_ID ,CUST_CODE ,PATIENT_ID ,TRX_TYPE_IND ,MODULE_ID\
 ,BILL_NO ,BILL_DATE ,EPISODE ,BILL_STATUS ,BILL_AMT ,BILL_TOT_OUTST_AMT  fr\
om (select A.BILLING_GROUP BLNG_GRP_ID ,A.CUST_CODE ,A.PATIENT_ID ,TRN_TYPE_\
CODE TRX_TYPE_IND ,'AR' MODULE_ID ,((A.DOC_TYPE_CODE||'-')||TO_CHAR(A.DOC_NU\
M)) BILL_NO ,TO_CHAR(A.DOC_DATE,'DD/MM/YYYY') BILL_DATE ,DECODE(EPISODE_TYPE\
,'I',((EPISODE_TYPE||'/')||to_char(EPISODE_ID)),'D',((EPISODE_TYPE||'/')||to\
_char(EPISODE_ID)),'E',((((EPISODE_TYPE||'/')||to_char(EPISODE_ID))||'/')||t\
o_char(VISIT_ID)),'O',((((EPISODE_TYPE||'/')||to_char(EPISODE_ID))||'/')||to\
_char(VISIT_ID)),'R',EPISODE_TYPE) EPISODE ,'INV' BILL_STATUS ,A.PAYABLE_AMT\
 BILL_AMT ,A.PENDING_AMT BILL_TOT_OUTST_AMT  from AR_PENDING_DOC A ,BL_COVER\
ING_LET_SETUP B where ((((((((((((((A.DOC_DATE<=TO_DATE(:b0,'DD/MM/YYYY') an\
d A.BILLING_GROUP between NVL(:b1,'!!') and NVL(:b2,'~~')) and nvl(A.CUST_CO\
DE,'!!!!!!!!') between NVL(:b3,'!!!!!!!!') and NVL(:b4,'~~~~~~~~')) and nvl(\
EPISODE_TYPE,'R')=DECODE(:b5,'I','I','D','D','");
       sqlbuft((void **)0, 
         "O','O','E','E','R','R',' ','R','A',nvl(EPISODE_TYPE,'R'))) and A.P\
ATIENT_ID between NVL(:b6,'!!!!!!!!!!!!!!!!!!!!') and NVL(:b7,'~~~~~~~~~~~~~\
~~~~~~~')) and (nvl(EPISODE_TYPE,'R') in ('R',' ') or (nvl(EPISODE_TYPE,'R')\
 in ('I','D','O','E') and to_char(EPISODE_ID) between NVL(:b8,'!!!!!!!!') an\
d NVL(:b9,'~~~~~~~~')))) and (nvl(EPISODE_TYPE,'R') in ('R','I','D',' ') or \
(nvl(EPISODE_TYPE,'R') in ('O','E') and to_char(VISIT_ID) between NVL(:b10,'\
!!!!') and NVL(:b11,'~~~~')))) and (RPAD(A.DOC_TYPE_CODE,6,' ')||LPAD(A.DOC_\
NUM,8,'0')) between (RPAD(NVL(:b12,' '),6,' ')||LPAD(NVL(:b13,0),8,'0')) and\
 (RPAD(NVL(:b14,'~~~~~~'),6,' ')||LPAD(NVL(:b15,99999999),8,'0'))) and b.ope\
rating_facility_id(+)=:b16) and A.PATIENT_ID=B.PATIENT_ID(+)) and NVL(A.CUST\
_CODE,'$#$#$#$#')=NVL(B.CUST_CODE(+),'$#$#$#$#')) and NVL(A.PENDING_AMT,0)<>\
0) and A.TRN_TYPE_CODE in ('1','3')) and  not exists (select I.DOC_TYPE_CODE\
 ,I.DOC_NUMBER  from BL_COVERING_LET_DETAIL I ,BL_COVERING_LET_HEADER J wher\
e ((((((I.doc_type_code=A.doc_type_code and I.");
       sqlstm.stmt = sq0005;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )257;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&nd_cut_off_date;
       sqlstm.sqhstl[0] = (unsigned int  )17;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_blng_grp_from;
       sqlstm.sqhstl[1] = (unsigned int  )9;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&nd_blng_grp_to;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&nd_cust_from;
       sqlstm.sqhstl[3] = (unsigned int  )11;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
       sqlstm.sqhstv[4] = (         void  *)&nd_cust_to;
       sqlstm.sqhstl[4] = (unsigned int  )11;
       sqlstm.sqhsts[4] = (         int  )0;
       sqlstm.sqindv[4] = (         void  *)0;
       sqlstm.sqinds[4] = (         int  )0;
       sqlstm.sqharm[4] = (unsigned int  )0;
       sqlstm.sqadto[4] = (unsigned short )0;
       sqlstm.sqtdso[4] = (unsigned short )0;
       sqlstm.sqhstv[5] = (         void  *)&nd_episode_type;
       sqlstm.sqhstl[5] = (unsigned int  )4;
       sqlstm.sqhsts[5] = (         int  )0;
       sqlstm.sqindv[5] = (         void  *)0;
       sqlstm.sqinds[5] = (         int  )0;
       sqlstm.sqharm[5] = (unsigned int  )0;
       sqlstm.sqadto[5] = (unsigned short )0;
       sqlstm.sqtdso[5] = (unsigned short )0;
       sqlstm.sqhstv[6] = (         void  *)&nd_patient_from;
       sqlstm.sqhstl[6] = (unsigned int  )23;
       sqlstm.sqhsts[6] = (         int  )0;
       sqlstm.sqindv[6] = (         void  *)0;
       sqlstm.sqinds[6] = (         int  )0;
       sqlstm.sqharm[6] = (unsigned int  )0;
       sqlstm.sqadto[6] = (unsigned short )0;
       sqlstm.sqtdso[6] = (unsigned short )0;
       sqlstm.sqhstv[7] = (         void  *)&nd_patient_to;
       sqlstm.sqhstl[7] = (unsigned int  )23;
       sqlstm.sqhsts[7] = (         int  )0;
       sqlstm.sqindv[7] = (         void  *)0;
       sqlstm.sqinds[7] = (         int  )0;
       sqlstm.sqharm[7] = (unsigned int  )0;
       sqlstm.sqadto[7] = (unsigned short )0;
       sqlstm.sqtdso[7] = (unsigned short )0;
       sqlstm.sqhstv[8] = (         void  *)&nd_episode_from;
       sqlstm.sqhstl[8] = (unsigned int  )11;
       sqlstm.sqhsts[8] = (         int  )0;
       sqlstm.sqindv[8] = (         void  *)0;
       sqlstm.sqinds[8] = (         int  )0;
       sqlstm.sqharm[8] = (unsigned int  )0;
       sqlstm.sqadto[8] = (unsigned short )0;
       sqlstm.sqtdso[8] = (unsigned short )0;
       sqlstm.sqhstv[9] = (         void  *)&nd_episode_to;
       sqlstm.sqhstl[9] = (unsigned int  )11;
       sqlstm.sqhsts[9] = (         int  )0;
       sqlstm.sqindv[9] = (         void  *)0;
       sqlstm.sqinds[9] = (         int  )0;
       sqlstm.sqharm[9] = (unsigned int  )0;
       sqlstm.sqadto[9] = (unsigned short )0;
       sqlstm.sqtdso[9] = (unsigned short )0;
       sqlstm.sqhstv[10] = (         void  *)&nd_visit_from;
       sqlstm.sqhstl[10] = (unsigned int  )7;
       sqlstm.sqhsts[10] = (         int  )0;
       sqlstm.sqindv[10] = (         void  *)0;
       sqlstm.sqinds[10] = (         int  )0;
       sqlstm.sqharm[10] = (unsigned int  )0;
       sqlstm.sqadto[10] = (unsigned short )0;
       sqlstm.sqtdso[10] = (unsigned short )0;
       sqlstm.sqhstv[11] = (         void  *)&nd_visit_to;
       sqlstm.sqhstl[11] = (unsigned int  )7;
       sqlstm.sqhsts[11] = (         int  )0;
       sqlstm.sqindv[11] = (         void  *)0;
       sqlstm.sqinds[11] = (         int  )0;
       sqlstm.sqharm[11] = (unsigned int  )0;
       sqlstm.sqadto[11] = (unsigned short )0;
       sqlstm.sqtdso[11] = (unsigned short )0;
       sqlstm.sqhstv[12] = (         void  *)&nd_doc_type_from;
       sqlstm.sqhstl[12] = (unsigned int  )9;
       sqlstm.sqhsts[12] = (         int  )0;
       sqlstm.sqindv[12] = (         void  *)0;
       sqlstm.sqinds[12] = (         int  )0;
       sqlstm.sqharm[12] = (unsigned int  )0;
       sqlstm.sqadto[12] = (unsigned short )0;
       sqlstm.sqtdso[12] = (unsigned short )0;
       sqlstm.sqhstv[13] = (         void  *)&nd_doc_num_from;
       sqlstm.sqhstl[13] = (unsigned int  )11;
       sqlstm.sqhsts[13] = (         int  )0;
       sqlstm.sqindv[13] = (         void  *)0;
       sqlstm.sqinds[13] = (         int  )0;
       sqlstm.sqharm[13] = (unsigned int  )0;
       sqlstm.sqadto[13] = (unsigned short )0;
       sqlstm.sqtdso[13] = (unsigned short )0;
       sqlstm.sqhstv[14] = (         void  *)&nd_doc_type_to;
       sqlstm.sqhstl[14] = (unsigned int  )9;
       sqlstm.sqhsts[14] = (         int  )0;
       sqlstm.sqindv[14] = (         void  *)0;
       sqlstm.sqinds[14] = (         int  )0;
       sqlstm.sqharm[14] = (unsigned int  )0;
       sqlstm.sqadto[14] = (unsigned short )0;
       sqlstm.sqtdso[14] = (unsigned short )0;
       sqlstm.sqhstv[15] = (         void  *)&nd_doc_num_to;
       sqlstm.sqhstl[15] = (unsigned int  )11;
       sqlstm.sqhsts[15] = (         int  )0;
       sqlstm.sqindv[15] = (         void  *)0;
       sqlstm.sqinds[15] = (         int  )0;
       sqlstm.sqharm[15] = (unsigned int  )0;
       sqlstm.sqadto[15] = (unsigned short )0;
       sqlstm.sqtdso[15] = (unsigned short )0;
       sqlstm.sqhstv[16] = (         void  *)&nd_facility;
       sqlstm.sqhstl[16] = (unsigned int  )5;
       sqlstm.sqhsts[16] = (         int  )0;
       sqlstm.sqindv[16] = (         void  *)0;
       sqlstm.sqinds[16] = (         int  )0;
       sqlstm.sqharm[16] = (unsigned int  )0;
       sqlstm.sqadto[16] = (unsigned short )0;
       sqlstm.sqtdso[16] = (unsigned short )0;
       sqlstm.sqhstv[17] = (         void  *)&nd_facility;
       sqlstm.sqhstl[17] = (unsigned int  )5;
       sqlstm.sqhsts[17] = (         int  )0;
       sqlstm.sqindv[17] = (         void  *)0;
       sqlstm.sqinds[17] = (         int  )0;
       sqlstm.sqharm[17] = (unsigned int  )0;
       sqlstm.sqadto[17] = (unsigned short )0;
       sqlstm.sqtdso[17] = (unsigned short )0;
       sqlstm.sqhstv[18] = (         void  *)&nd_facility;
       sqlstm.sqhstl[18] = (unsigned int  )5;
       sqlstm.sqhsts[18] = (         int  )0;
       sqlstm.sqindv[18] = (         void  *)0;
       sqlstm.sqinds[18] = (         int  )0;
       sqlstm.sqharm[18] = (unsigned int  )0;
       sqlstm.sqadto[18] = (unsigned short )0;
       sqlstm.sqtdso[18] = (unsigned short )0;
       sqlstm.sqhstv[19] = (         void  *)&nd_sort_order;
       sqlstm.sqhstl[19] = (unsigned int  )4;
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
          err_mesg("OPEN failed on cursor DET_CUR_AR",0,"");

   }

   if (strcmp(nd_module_id.arr, "**") == 0)
   {
 	  /* EXEC SQL OPEN DET_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 39;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select BLNG_GRP_ID ,CUST_CODE ,PATIENT_ID ,TRX_TYPE_IND ,MODULE_ID ,B\
ILL_NO ,BILL_DATE ,EPISODE ,BILL_STATUS ,BILL_AMT ,BILL_TOT_OUTST_AMT  from \
(select A.BLNG_GRP_ID ,A.CUST_CODE ,A.PATIENT_ID ,D.TRX_TYPE_CODE TRX_TYPE_I\
ND ,'BL' MODULE_ID ,((A.DOC_TYPE_CODE||'-')||to_char(A.DOC_NUM)) BILL_NO ,TO\
_CHAR(A.DOC_DATE,'DD/MM/YYYY') BILL_DATE ,DECODE(EPISODE_TYPE,'I',((EPISODE_\
TYPE||'/')||to_char(EPISODE_ID)),'D',((EPISODE_TYPE||'/')||to_char(EPISODE_I\
D)),'E',((((EPISODE_TYPE||'/')||to_char(EPISODE_ID))||'/')||to_char(VISIT_ID\
)),'O',((((EPISODE_TYPE||'/')||to_char(EPISODE_ID))||'/')||to_char(VISIT_ID)\
),'R',EPISODE_TYPE) EPISODE ,decode(nvl(BILL_STATUS,'B'),'B','Bill','D','DCP\
','A','INV') BILL_STATUS ,BILL_AMT ,BILL_TOT_OUTST_AMT  from BL_BILL_DCP_DTL\
_VW A ,BL_COVERING_LET_SETUP B ,BL_TRN_DOC_TYPE D where (((((((((((((((A.OPE\
RATING_FACILITY_ID=:b0 and A.DOC_DATE<=TO_DATE(:b1,'DD/MM/YYYY')) and BLNG_G\
RP_ID between NVL(:b2,'!!') and NVL(:b3,'~~')) and nvl(A.CUST_CODE,'!!!!!!!!\
') between NVL(:b4,'!!!!!!!!') and NVL(:b5,");
    sqlbuft((void **)0, 
      "'~~~~~~~~')) and EPISODE_TYPE=DECODE(:b6,'I','I','D','D','O','O','E',\
'E','R','R',' ','R','A',EPISODE_TYPE)) and A.PATIENT_ID between NVL(:b7,'!!!\
!!!!!!!!!!!!!!!!!') and NVL(:b8,'~~~~~~~~~~~~~~~~~~~~')) and (EPISODE_TYPE='\
R' or (EPISODE_TYPE in ('I','D','O','E') and to_char(EPISODE_ID) between NVL\
(:b9,'!!!!!!!!') and NVL(:b10,'~~~~~~~~')))) and (EPISODE_TYPE in ('R','I','\
D') or (EPISODE_TYPE in ('O','E') and to_char(VISIT_ID) between NVL(:b11,'!!\
!!') and NVL(:b12,'~~~~')))) and (RPAD(A.DOC_TYPE_CODE,6,' ')||LPAD(A.DOC_NU\
M,8,'0')) between (RPAD(NVL(:b13,' '),6,' ')||LPAD(NVL(:b14,0),8,'0')) and (\
RPAD(NVL(:b15,'~~~~~~'),6,' ')||LPAD(NVL(:b16,99999999),8,'0'))) and b.opera\
ting_facility_id(+)=:b0) and A.PATIENT_ID=B.PATIENT_ID(+)) and NVL(A.CUST_CO\
DE,'$#$#$#$#')=NVL(B.CUST_CODE(+),'$#$#$#$#')) and A.DOC_TYPE_CODE=D.DOC_TYP\
E_CODE) and NVL(BILL_TOT_OUTST_AMT,0)<>0) and nvl(BILL_STATUS,'X') not  in (\
'C','S','A')) and  not exists (select I.DOC_TYPE_CODE ,I.DOC_NUMBER  from BL\
_COVERING_LET_DETAIL I ,BL_COVERING_LET_HEA");
    sqlbuft((void **)0, 
      "DER J where ((((((I.doc_type_code=A.doc_type_code and I.doc_number=A.\
doc_num) and J.operating_facility_id=:b0) and I.operating_facility_id=J.oper\
ating_facility_id) and nvl(I.cancelled_yn,'N')='N') and nvl(J.cancelled_yn,'\
N')='N') and I.doc_ref_num=J.doc_ref_num))) union all select A.BILLING_GROUP\
 BLNG_GRP_ID ,A.CUST_CODE ,A.PATIENT_ID ,TRN_TYPE_CODE TRX_TYPE_IND ,'AR' MO\
DULE_ID ,((A.DOC_TYPE_CODE||'-')||TO_CHAR(A.DOC_NUM)) BILL_NO ,TO_CHAR(A.DOC\
_DATE,'DD/MM/YYYY') BILL_DATE ,DECODE(EPISODE_TYPE,'I',((EPISODE_TYPE||'/')|\
|to_char(EPISODE_ID)),'D',((EPISODE_TYPE||'/')||to_char(EPISODE_ID)),'E',(((\
(EPISODE_TYPE||'/')||to_char(EPISODE_ID))||'/')||to_char(VISIT_ID)),'O',((((\
EPISODE_TYPE||'/')||to_char(EPISODE_ID))||'/')||to_char(VISIT_ID)),'R',EPISO\
DE_TYPE) EPISODE ,'INV' BILL_STATUS ,A.PAYABLE_AMT BILL_AMT ,A.PENDING_AMT B\
ILL_TOT_OUTST_AMT  from AR_PENDING_DOC A ,BL_COVERING_LET_SETUP B where ((((\
((((((((((A.DOC_DATE<=TO_DATE(:b1,'DD/MM/YYYY') and A.BILLING_GROUP between \
NVL(:b2,'!!') and NVL(:b3,'~~')) and nvl(A.");
    sqlbuft((void **)0, 
      "CUST_CODE,'!!!!!!!!') between NVL(:b4,'!!!!!!!!') and NVL(:b5,'~~~~~~\
~~')) and nvl(EPISODE_TYPE,'R')=DECODE(:b6,'I','I','D','D','O','O','E','E','\
R','R',' ','R','A',nvl(EPISODE_TYPE,'R'))) and A.PATIENT_ID between NVL(:b7,\
'!!!!!!!!!!!!!!!!!!!!') and NVL(:b8,'~~~~~~~~~~~~~~~~~~~~')) and (nvl(EPISOD\
E_TYPE,'R') in ('R',' ') or (nvl(EPISODE_TYPE,'R') in ('I','D','O','E') and \
to_char(EPISODE_ID) between NVL(:b9,'!!!!!!!!') and NVL(:b10,'~~~~~~~~')))) \
and (nvl(EPISODE_TYPE,'R') in ('R','I','D',' ') or (nvl(EPISODE_TYPE,'R') in\
 ('O','E') and to_char(VISIT_ID) between NVL(:b11,'!!!!') and NVL(:b12,'~~~~\
')))) and (RPAD(A.DOC_TYPE_CODE,6,' ')||LPAD(A.DOC_NUM,8,'0')) between (RPAD\
(NVL(:b13,' '),6,' ')||LPAD(NVL(:b14,0),8,'0')) and (RPAD(NVL(:b15,'~~~~~~')\
,6,' ')||LPAD(NVL(:b16,99999999),8,'0'))) and b.operating_facility_id(+)=:b0\
) and A.PATIENT_ID=B.PATIENT_ID(+)) and NVL(A.CUST_CODE,'$#$#$#$#')=NVL(B.CU\
ST_CODE(+),'$#$#$#$#')) and NVL(A.PENDING_AMT,0)<>0) and A.TRN_TYPE_CODE in \
('1','3')) and  not exists (select I.DOC_TY");
    sqlstm.stmt = sq0006;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )352;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_facility;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_cut_off_date;
    sqlstm.sqhstl[1] = (unsigned int  )17;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_blng_grp_from;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_blng_grp_to;
    sqlstm.sqhstl[3] = (unsigned int  )9;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_cust_from;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_cust_to;
    sqlstm.sqhstl[5] = (unsigned int  )11;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[6] = (unsigned int  )4;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_patient_from;
    sqlstm.sqhstl[7] = (unsigned int  )23;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_patient_to;
    sqlstm.sqhstl[8] = (unsigned int  )23;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_episode_from;
    sqlstm.sqhstl[9] = (unsigned int  )11;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_episode_to;
    sqlstm.sqhstl[10] = (unsigned int  )11;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_visit_from;
    sqlstm.sqhstl[11] = (unsigned int  )7;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_visit_to;
    sqlstm.sqhstl[12] = (unsigned int  )7;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_doc_type_from;
    sqlstm.sqhstl[13] = (unsigned int  )9;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_doc_num_from;
    sqlstm.sqhstl[14] = (unsigned int  )11;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&nd_doc_type_to;
    sqlstm.sqhstl[15] = (unsigned int  )9;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_doc_num_to;
    sqlstm.sqhstl[16] = (unsigned int  )11;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_facility;
    sqlstm.sqhstl[17] = (unsigned int  )5;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_facility;
    sqlstm.sqhstl[18] = (unsigned int  )5;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_cut_off_date;
    sqlstm.sqhstl[19] = (unsigned int  )17;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&nd_blng_grp_from;
    sqlstm.sqhstl[20] = (unsigned int  )9;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&nd_blng_grp_to;
    sqlstm.sqhstl[21] = (unsigned int  )9;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&nd_cust_from;
    sqlstm.sqhstl[22] = (unsigned int  )11;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&nd_cust_to;
    sqlstm.sqhstl[23] = (unsigned int  )11;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&nd_episode_type;
    sqlstm.sqhstl[24] = (unsigned int  )4;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&nd_patient_from;
    sqlstm.sqhstl[25] = (unsigned int  )23;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&nd_patient_to;
    sqlstm.sqhstl[26] = (unsigned int  )23;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&nd_episode_from;
    sqlstm.sqhstl[27] = (unsigned int  )11;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&nd_episode_to;
    sqlstm.sqhstl[28] = (unsigned int  )11;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&nd_visit_from;
    sqlstm.sqhstl[29] = (unsigned int  )7;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
    sqlstm.sqhstv[30] = (         void  *)&nd_visit_to;
    sqlstm.sqhstl[30] = (unsigned int  )7;
    sqlstm.sqhsts[30] = (         int  )0;
    sqlstm.sqindv[30] = (         void  *)0;
    sqlstm.sqinds[30] = (         int  )0;
    sqlstm.sqharm[30] = (unsigned int  )0;
    sqlstm.sqadto[30] = (unsigned short )0;
    sqlstm.sqtdso[30] = (unsigned short )0;
    sqlstm.sqhstv[31] = (         void  *)&nd_doc_type_from;
    sqlstm.sqhstl[31] = (unsigned int  )9;
    sqlstm.sqhsts[31] = (         int  )0;
    sqlstm.sqindv[31] = (         void  *)0;
    sqlstm.sqinds[31] = (         int  )0;
    sqlstm.sqharm[31] = (unsigned int  )0;
    sqlstm.sqadto[31] = (unsigned short )0;
    sqlstm.sqtdso[31] = (unsigned short )0;
    sqlstm.sqhstv[32] = (         void  *)&nd_doc_num_from;
    sqlstm.sqhstl[32] = (unsigned int  )11;
    sqlstm.sqhsts[32] = (         int  )0;
    sqlstm.sqindv[32] = (         void  *)0;
    sqlstm.sqinds[32] = (         int  )0;
    sqlstm.sqharm[32] = (unsigned int  )0;
    sqlstm.sqadto[32] = (unsigned short )0;
    sqlstm.sqtdso[32] = (unsigned short )0;
    sqlstm.sqhstv[33] = (         void  *)&nd_doc_type_to;
    sqlstm.sqhstl[33] = (unsigned int  )9;
    sqlstm.sqhsts[33] = (         int  )0;
    sqlstm.sqindv[33] = (         void  *)0;
    sqlstm.sqinds[33] = (         int  )0;
    sqlstm.sqharm[33] = (unsigned int  )0;
    sqlstm.sqadto[33] = (unsigned short )0;
    sqlstm.sqtdso[33] = (unsigned short )0;
    sqlstm.sqhstv[34] = (         void  *)&nd_doc_num_to;
    sqlstm.sqhstl[34] = (unsigned int  )11;
    sqlstm.sqhsts[34] = (         int  )0;
    sqlstm.sqindv[34] = (         void  *)0;
    sqlstm.sqinds[34] = (         int  )0;
    sqlstm.sqharm[34] = (unsigned int  )0;
    sqlstm.sqadto[34] = (unsigned short )0;
    sqlstm.sqtdso[34] = (unsigned short )0;
    sqlstm.sqhstv[35] = (         void  *)&nd_facility;
    sqlstm.sqhstl[35] = (unsigned int  )5;
    sqlstm.sqhsts[35] = (         int  )0;
    sqlstm.sqindv[35] = (         void  *)0;
    sqlstm.sqinds[35] = (         int  )0;
    sqlstm.sqharm[35] = (unsigned int  )0;
    sqlstm.sqadto[35] = (unsigned short )0;
    sqlstm.sqtdso[35] = (unsigned short )0;
    sqlstm.sqhstv[36] = (         void  *)&nd_facility;
    sqlstm.sqhstl[36] = (unsigned int  )5;
    sqlstm.sqhsts[36] = (         int  )0;
    sqlstm.sqindv[36] = (         void  *)0;
    sqlstm.sqinds[36] = (         int  )0;
    sqlstm.sqharm[36] = (unsigned int  )0;
    sqlstm.sqadto[36] = (unsigned short )0;
    sqlstm.sqtdso[36] = (unsigned short )0;
    sqlstm.sqhstv[37] = (         void  *)&nd_facility;
    sqlstm.sqhstl[37] = (unsigned int  )5;
    sqlstm.sqhsts[37] = (         int  )0;
    sqlstm.sqindv[37] = (         void  *)0;
    sqlstm.sqinds[37] = (         int  )0;
    sqlstm.sqharm[37] = (unsigned int  )0;
    sqlstm.sqadto[37] = (unsigned short )0;
    sqlstm.sqtdso[37] = (unsigned short )0;
    sqlstm.sqhstv[38] = (         void  *)&nd_sort_order;
    sqlstm.sqhstl[38] = (unsigned int  )4;
    sqlstm.sqhsts[38] = (         int  )0;
    sqlstm.sqindv[38] = (         void  *)0;
    sqlstm.sqinds[38] = (         int  )0;
    sqlstm.sqharm[38] = (unsigned int  )0;
    sqlstm.sqadto[38] = (unsigned short )0;
    sqlstm.sqtdso[38] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
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
          err_mesg("OPEN failed on cursor DET_CUR",0,"");
   }

}

close_det_cur()
{
	if (strcmp(nd_module_id.arr, "BL") == 0)
       /* EXEC SQL CLOSE DET_CUR_BL; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 39;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )523;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

   
	
	if (strcmp(nd_module_id.arr, "AR") == 0)
       /* EXEC SQL CLOSE DET_CUR_AR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 39;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )538;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

   

	if (strcmp(nd_module_id.arr, "**") == 0)
       /* EXEC SQL CLOSE DET_CUR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 39;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )553;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

  
  
}

fetch_det_cur()
{ 

		d_blng_grp.arr[0]		= '\0';	 
		d_blng_grp_desc.arr[0]  = '\0';	   
		d_cust.arr[0]			= '\0';
		d_cust_name.arr[0]		= '\0';	  
		d_patient_id.arr[0]		= '\0';	  
		d_trx_type_ind.arr[0]   = '\0';	  
		d_module_id.arr[0]		= '\0';	  
		d_bill_no.arr[0]		= '\0';	  
		d_bill_date.arr[0]		= '\0';	  
		d_episode.arr[0]		= '\0';	  
		d_bill_status.arr[0]	= '\0';	 

		d_blng_grp.len			= 0;
		d_blng_grp_desc.len		= 0;
		d_cust.len				= 0;
		d_cust_name.len			= 0;
		d_patient_id.len		= 0;
		d_trx_type_ind.len		= 0;
		d_module_id.len			= 0;		
		d_bill_no.len			= 0;
		d_bill_date.len  		= 0;
		d_episode.len			= 0;
		d_bill_status.len		= 0;

		d_bill_amt				= 0;
		d_bill_outst_amt		= 0;


    if (strcmp(nd_module_id.arr, "BL") == 0)
	{
	   
	   /* EXEC SQL FETCH  DET_CUR_BL INTO 
		:d_blng_grp,
		:d_cust,
		:d_patient_id,
		:d_trx_type_ind,
		:d_module_id,
		:d_bill_no,
		:d_bill_date,		
		:d_episode,
		:d_bill_status,
		:d_bill_amt,
		:d_bill_outst_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 39;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )568;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_grp;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_cust;
    sqlstm.sqhstl[1] = (unsigned int  )11;
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
    sqlstm.sqhstv[3] = (         void  *)&d_trx_type_ind;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_module_id;
    sqlstm.sqhstl[4] = (unsigned int  )52;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_bill_no;
    sqlstm.sqhstl[5] = (unsigned int  )19;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_bill_date;
    sqlstm.sqhstl[6] = (unsigned int  )22;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_episode;
    sqlstm.sqhstl[7] = (unsigned int  )22;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_bill_status;
    sqlstm.sqhstl[8] = (unsigned int  )7;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_bill_amt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_bill_outst_amt;
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
		  err_mesg("FETCH failed on cursor DET_CUR_BL ",0,"");	

	}

    if (strcmp(nd_module_id.arr, "AR") == 0)
	{
	   /* EXEC SQL FETCH  DET_CUR_AR INTO 
		:d_blng_grp,
		:d_cust,
		:d_patient_id,
		:d_trx_type_ind,
		:d_module_id,
		:d_bill_no,
		:d_bill_date,		
		:d_episode,
		:d_bill_status,
		:d_bill_amt,
		:d_bill_outst_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 39;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )627;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_grp;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_cust;
    sqlstm.sqhstl[1] = (unsigned int  )11;
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
    sqlstm.sqhstv[3] = (         void  *)&d_trx_type_ind;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_module_id;
    sqlstm.sqhstl[4] = (unsigned int  )52;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_bill_no;
    sqlstm.sqhstl[5] = (unsigned int  )19;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_bill_date;
    sqlstm.sqhstl[6] = (unsigned int  )22;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_episode;
    sqlstm.sqhstl[7] = (unsigned int  )22;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_bill_status;
    sqlstm.sqhstl[8] = (unsigned int  )7;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_bill_amt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_bill_outst_amt;
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
		  err_mesg("FETCH failed on cursor DET_CUR_AR ",0,"");	

    }

    if (strcmp(nd_module_id.arr, "**") == 0)
	{
	   /* EXEC SQL FETCH  DET_CUR INTO 
		:d_blng_grp,
		:d_cust,
		:d_patient_id,
		:d_trx_type_ind,
		:d_module_id,
		:d_bill_no,
		:d_bill_date,		
		:d_episode,
		:d_bill_status,
		:d_bill_amt,
		:d_bill_outst_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 39;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )686;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_grp;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_cust;
    sqlstm.sqhstl[1] = (unsigned int  )11;
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
    sqlstm.sqhstv[3] = (         void  *)&d_trx_type_ind;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_module_id;
    sqlstm.sqhstl[4] = (unsigned int  )52;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_bill_no;
    sqlstm.sqhstl[5] = (unsigned int  )19;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_bill_date;
    sqlstm.sqhstl[6] = (unsigned int  )22;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_episode;
    sqlstm.sqhstl[7] = (unsigned int  )22;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_bill_status;
    sqlstm.sqhstl[8] = (unsigned int  )7;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_bill_amt;
    sqlstm.sqhstl[9] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_bill_outst_amt;
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
		  err_mesg("FETCH failed on cursor DET_CUR ",0,"");	

    }

    /* EXEC SQL SELECT SHORT_DESC 
		     INTO   :d_blng_grp_desc
			 FROM   BL_BLNG_GRP_LANG_VW
			 WHERE  BLNG_GRP_ID = :d_blng_grp
			 AND    LANGUAGE_ID = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 39;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_DESC into :b0  from BL_BLNG_GRP_LANG_VW wher\
e (BLNG_GRP_ID=:b1 and LANGUAGE_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )745;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_desc;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_grp;
    sqlstm.sqhstl[1] = (unsigned int  )7;
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

			   


    if (strcmp(d_cust.arr,"")!=0)
	{
	   /* EXEC SQL SELECT SHORT_NAME
			    INTO   :d_cust_name
				FROM   AR_CUSTOMER_LANG_VW
				WHERE  CUST_CODE   = :d_cust
				AND    LANGUAGE_ID = :p_language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 39;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SHORT_NAME into :b0  from AR_CUSTOMER_LANG_VW wher\
e (CUST_CODE=:b1 and LANGUAGE_ID=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )772;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_cust_name;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_cust;
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

			   
	   d_cust_name.arr[d_cust_name.len]	= '\0';	
	}
    

    d_blng_grp.arr[d_blng_grp.len]					= '\0';
	d_blng_grp_desc.arr[d_blng_grp_desc.len]		= '\0';
	d_cust.arr[d_cust.len]							= '\0';
	d_patient_id.arr[d_patient_id.len]				= '\0';
	d_trx_type_ind.arr[d_trx_type_ind.len]			= '\0';
	d_module_id.arr[d_module_id.len]				= '\0';
    d_bill_no.arr[d_bill_no.len]					= '\0';
	d_bill_date.arr[d_bill_date.len]				= '\0';
	d_episode.arr[d_episode.len]					= '\0';
	d_bill_status.arr[d_bill_status.len]			= '\0';


	return(LAST_ROW?0:1);   
}

print_rec()
{



     int first_ref=1; 
    if(d_bill_date.arr[0]!='\0')
	{
	init_date_temp_var();
	strcpy(date_convert.arr,d_bill_date.arr);
	fun_change_loc_date();	
	strcpy(d_bill_date1.arr,date_convert.arr);
	} 
    if (lctr > 40)
	next_page();
    fprintf(fp,"%8d ",recctr);
	fprintf(fp,"%-4.4s %-15.15s %-9.9s %-15.15s ",d_blng_grp.arr,d_blng_grp_desc.arr,d_cust.arr,d_cust_name.arr);
    fprintf(fp,"%-21.21s%-19.19s%-18.18s%-17.17s%-10.10s",d_patient_id.arr,d_episode.arr,d_bill_no.arr,d_bill_date1.arr,d_bill_status.arr);
	print_formated(d_bill_amt);
	fprintf(fp," ");
	print_formated(d_bill_outst_amt);
	fprintf(fp," ");
	fprintf(fp,"%-27.27s ",d_doc_ref_num.arr);
    fprintf(fp,"\n");
	
	lctr++;
	recctr++;
	d_tot_bill_outst_amt    += d_bill_outst_amt;
	d_bill_amt_tot          += d_bill_amt;

	/*declare_can_cur();
	open_can_cur(); 
	while(fetch_can_cur())
	{
		fprintf(fp, "                    %-39s %-20s\n", d_cancelled_by.arr, d_cancelled_date.arr);
		lctr++;	
	}

	close_can_cur();*/

}

print_tot()
{
   fprintf(fp,"%126s                --------------   --------------\n"," ");
   fprintf(fp,"%129s            ",loc_legend[16]);
   print_formated(d_bill_amt_tot);    
   fprintf(fp, " ");
   print_formated(d_tot_bill_outst_amt);    
   next_line(1);
   fprintf(fp,"%126s                --------------   --------------\n"," ");
   next_line(1);
}

get_header_dtls()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    d_acc_entity_name.arr[0] ='\0';
    d_curr_date.arr[0]   ='\0';
	d_user.arr[0] ='\0';
    d_sysdate.arr[0] ='\0';
	d_head_name.arr[0] ='\0';
    d_acc_entity_name.len =0;
    d_curr_date.len   =0;
	d_user.len =0;
    d_sysdate.len =0;
	d_head_name.len=0;

	/* EXEC SQL SELECT upper(ACC_ENTITY_NAME), /o description of the institution o/
				   USER, TO_CHAR(SYSDATE, 'DD/MM/YYYY'),
				   TO_CHAR(SYSDATE, 'HH24:MI:SS'),
				   HEAD_OF_COMPANY_NAME
             INTO :d_acc_entity_name,
				  :d_user, :d_sysdate,
				  :d_curr_date,
				  :d_head_name
			 FROM SY_ACC_ENTITY_LANG_VW
			 WHERE acc_entity_id = :nd_facility
			 AND   LANGUAGE_ID   = :p_language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 39;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,USER ,TO_CHAR(SYSDATE,'DD/MM/\
YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') ,HEAD_OF_COMPANY_NAME into :b0,:b1,:b2,:\
b3,:b4  from SY_ACC_ENTITY_LANG_VW where (acc_entity_id=:b5 and LANGUAGE_ID=:b\
6)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )799;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
 sqlstm.sqhstl[0] = (unsigned int  )63;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_user;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_sysdate;
 sqlstm.sqhstl[2] = (unsigned int  )22;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_curr_date;
 sqlstm.sqhstl[3] = (unsigned int  )22;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_head_name;
 sqlstm.sqhstl[4] = (unsigned int  )33;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_facility;
 sqlstm.sqhstl[5] = (unsigned int  )5;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&p_language_id;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
	d_user.arr[d_user.len]                       = '\0';
	d_sysdate.arr[d_sysdate.len]                 = '\0';
	d_curr_date.arr[d_curr_date.len]			 = '\0';
	d_head_name.arr[d_head_name.len]			 = '\0';

   
	return;
	err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 39;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )842;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	proc_exit();
}


print_page_title()
{

	int hosp_nm_len,date1_len, rep_title_len = 10,v_title_len,v_title1_len, s1, s2,date_len,user_len,pgm_len,sub_title_len;
	char v_rep_title[200],v_as_on_date[12],v_sub_title[200],v_title[200],v_title1[200];
   
	//Line 1

	fprintf(fp,"%-13.13s : BL",loc_legend[18]);//loc_legend[19]
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-11);
	fprintf(fp,"%s   ", d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	//date1_len=strlen(loc_legend[3]);
	horz_skip(s2-31);
	//horz_skip(s2-date1_len-12);
	
	init_date_temp_var();
	strcpy(date_convert.arr,d_sysdate.arr);
	fun_change_loc_date();
	fprintf(fp,"%-8.8s :   %s", loc_legend[3],date_convert.arr);
	    
	next_line(1);
	
	//Line 2

	fprintf(fp,"%-13.13s : %s",loc_legend[19],d_user.arr); //loc_legend[20]	
    user_len=strlen(d_user.arr);
	strcpy(v_rep_title,loc_legend[1]);
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	//strcpy(v_as_on_date,nd_as_on_date.arr);
	//date_len= strlen(v_as_on_date);
	horz_skip(s1-user_len-6);
	fprintf(fp,"%s    ",v_rep_title);
   	s2 = (REP_WIDTH-s1-rep_title_len);
	horz_skip(s2-36);
	fprintf(fp," %-8.8s :   %-10s",loc_legend[2],d_curr_date.arr);
	next_line(1);

	//Line 3

	fprintf(fp,"%-13.13s : %s",loc_legend[49],d_curr_pgm_name.arr);//loc_legend[18]
    pgm_len=strlen(d_curr_pgm_name.arr);
	s2 = (REP_WIDTH-5);
	horz_skip(s2-43);
	//horz_skip(s2-28);
	fprintf(fp,"%-11.11s :  %9d",loc_legend[4],++page_no);
	next_line(1);
	//fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 			*/
    //fprintf(fp,"%c(s-3B",ESC); /* release bold style */
   	lctr = 6;
	print_line('-',REP_WIDTH);
	fprintf(fp,"--");
	 next_line(1);
}


print_column_title()
 {

 //no.ID, name
  //fprintf(fp, "%4s %4s %4s %15s %17s%20s    %15s       %15s  %15s",loc_legend[5],loc_legend[6],loc_legend[8],loc_legend[10],loc_legend[11], loc_legend[12],loc_legend[13],loc_legend[14], loc_legend[15]);
  //fprintf(fp, "%4s %-19s %-25s %-20s %-18s %-17s %-13s %-5s %15s  %15s",loc_legend[5],loc_legend[6],loc_legend[8],loc_legend[10],loc_legend[11], loc_legend[12],loc_legend[13],loc_legend[17], loc_legend[14], loc_legend[15]);
  
  fprintf(fp," %8.8s %-20.20s%-26.26s%-21.21s%-19.19s%-18.18s%-17.17s%-10.10s  %12.12s%17.17s",loc_legend[5],loc_legend[6],loc_legend[8],loc_legend[10],loc_legend[11], loc_legend[12],loc_legend[13],loc_legend[17], loc_legend[14], loc_legend[15]);
  next_line(1);

  //fprintf(fp, "     %-4s %-9s ",loc_legend[7], loc_legend[9]);
  //next_line(1);
  print_line('-',REP_WIDTH);
  fprintf(fp,"--");
  next_line(1);

 }


print_param()
{
 
  fprintf(fp,"\n");
  print_page_title();

  fprintf(fp,"VER 4.1\n");
 
  fprintf(fp,"\n\n\n\n");
  fprintf(fp,"        %s :\n",loc_legend[25]);//loc_legend[24]
  fprintf(fp,"        ");
  fprintf(fp,"--------------------\n\n");

  d_episode_type.arr[0]		= '\0';	  
  d_episode_type.len		= 0;

  if (strcmp(nd_episode_type.arr,"I")==0)
	// strcpy(d_episode_type.arr, "Inpatient");
	strcpy(d_episode_type.arr, loc_legend[26]);
  else if (strcmp(nd_episode_type.arr,"D")==0)
	 strcpy(d_episode_type.arr,loc_legend[27]);	
  else if (strcmp(nd_episode_type.arr,"O")==0)
	 strcpy(d_episode_type.arr,loc_legend[28]);	
  else if (strcmp(nd_episode_type.arr,"E")==0)
	 strcpy(d_episode_type.arr,loc_legend[29]);	
  else if (strcmp(nd_episode_type.arr,"R")==0)
	 strcpy(d_episode_type.arr,loc_legend[30]);	
  else if (strcmp(nd_episode_type.arr,"A")==0)
	 strcpy(d_episode_type.arr,loc_legend[31]);	

  d_episode_type.len = strlen(d_episode_type.arr);


  d_sort_order.arr[0]		= '\0';	  
  d_sort_order.len			= 0;

  if (strcmp(nd_sort_order.arr,"B")==0)
	 strcpy(d_sort_order.arr,loc_legend[32]);
  else if (strcmp(nd_sort_order.arr,"C")==0)
	 strcpy(d_sort_order.arr,loc_legend[8]);	
  else if (strcmp(nd_sort_order.arr,"P")==0)
	 strcpy(d_sort_order.arr,loc_legend[10]);	
  else if (strcmp(nd_sort_order.arr,"E")==0)
	 strcpy(d_sort_order.arr,loc_legend[33]);	

  d_sort_order.len = strlen(d_sort_order.arr);

  d_module_id.arr[0]		= '\0';	  
  d_module_id.len			= 0;

  if (strcmp(nd_module_id.arr,"BL")==0)
	 strcpy(d_module_id.arr,loc_legend[34]);
  else if (strcmp(nd_module_id.arr,"AR")==0)
	 strcpy(d_module_id.arr,loc_legend[35]);	
  else if (strcmp(nd_module_id.arr,"**")==0)
	 //strcpy(d_module_id.arr, "Patient Billing & Accounts Receivable");	
	 strcpy(d_module_id.arr, loc_legend[52]);	

  d_module_id.len = strlen(d_module_id.arr);

  
  fprintf(fp,"%-16s%-28s : %s\n"," ",loc_legend[36],d_module_id.arr); 
   
  init_date_temp_var();
  strcpy(date_convert.arr,nd_cut_off_date.arr);
  fun_change_loc_date();
  fprintf(fp,"%-16s%-28s : %s\n"," ",loc_legend[37],date_convert.arr); 
  
  if(nd_blng_grp_from.arr[0]=='\0')
  strcpy(nd_blng_grp_from1.arr,loc_legend[51]);
  else
  strcpy(nd_blng_grp_from1.arr,nd_blng_grp_from.arr);

  if(nd_blng_grp_to.arr[0]=='\0')
  strcpy(nd_blng_grp_to1.arr,loc_legend[50]);
  else
  strcpy(nd_blng_grp_to1.arr,nd_blng_grp_to.arr);

 if(nd_cust_from.arr[0]=='\0')
  strcpy(nd_cust_from1.arr,loc_legend[51]);
  else
  strcpy(nd_cust_from1.arr,nd_cust_from.arr);

  if(nd_cust_to.arr[0]=='\0')
  strcpy(nd_cust_to1.arr,loc_legend[50]);
  else
  strcpy(nd_cust_to1.arr,nd_cust_to.arr);

  if(nd_patient_from.arr[0]=='\0')
  strcpy(nd_patient_from1.arr,loc_legend[51]);
  else
  strcpy(nd_patient_from1.arr,nd_patient_from.arr);

  if(nd_patient_to.arr[0]=='\0')
  strcpy(nd_patient_to1.arr,loc_legend[50]);
  else
  strcpy(nd_patient_to1.arr,nd_patient_to.arr);

   if(nd_doc_type_from.arr[0]=='\0')
  strcpy(nd_doc_type_from1.arr,loc_legend[51]);
  else
  strcpy(nd_doc_type_from1.arr,nd_doc_type_from.arr);

  if(nd_doc_type_to.arr[0]=='\0')
  strcpy(nd_doc_type_to1.arr,loc_legend[50]); 
  else
  strcpy(nd_doc_type_to1.arr,nd_doc_type_to.arr);

   if(nd_doc_num_from.arr[0]=='\0')
  strcpy(nd_doc_num_from1.arr,loc_legend[51]);
  else
  strcpy(nd_doc_num_from1.arr,nd_doc_num_from.arr);

  if(nd_doc_num_to.arr[0]=='\0')
  strcpy(nd_doc_num_to1.arr,loc_legend[50]);
  else
  strcpy(nd_doc_num_to1.arr,nd_doc_num_to.arr);

   if(nd_episode_from.arr[0]=='\0')
  strcpy(nd_episode_from1.arr,loc_legend[51]);
  else
  strcpy(nd_episode_from1.arr,nd_episode_from.arr);

  if(nd_episode_to.arr[0]=='\0')
  strcpy(nd_episode_to1.arr,loc_legend[50]);
  else
  strcpy(nd_episode_to1.arr,nd_episode_to.arr);

   if(nd_visit_from.arr[0]=='\0')
  strcpy(nd_visit_from1.arr,loc_legend[51]);
  else
  strcpy(nd_visit_from1.arr,nd_visit_from.arr);

  if(nd_visit_to.arr[0]=='\0')
  strcpy(nd_visit_to1.arr,loc_legend[50]);
  else
  strcpy(nd_visit_to1.arr,nd_visit_to.arr);
           
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," ",loc_legend[32],loc_legend[39],nd_blng_grp_from1.arr); 
  fprintf(fp,"%-16.16s%-19s %-8.8s : %s\n"," "," ",loc_legend[40],nd_blng_grp_to1.arr);
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," ",loc_legend[41],loc_legend[39],nd_cust_from1.arr); 
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," "," ",loc_legend[40],nd_cust_to1.arr);
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," ",loc_legend[42],loc_legend[39],nd_patient_from1.arr);
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," "," ",loc_legend[40],nd_patient_to1.arr);
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," ",loc_legend[43],loc_legend[39],nd_doc_type_from1.arr);
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," "," ",loc_legend[40],nd_doc_type_to1.arr);
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," ",loc_legend[44],loc_legend[39],nd_doc_num_from1.arr); 
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," "," ",loc_legend[40],nd_doc_num_to1.arr);
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," ",loc_legend[45],loc_legend[39],nd_episode_from1.arr); 
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," "," ",loc_legend[40],nd_episode_to1.arr);    
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," ",loc_legend[46],loc_legend[39],nd_visit_from1.arr);
  fprintf(fp,"%-16.16s%-19.19s %-8.8s : %s\n"," "," ",loc_legend[40],nd_visit_to1.arr); 
  fprintf(fp,"%-16.16s%-28.28s : %s\n"," ",loc_legend[47],d_episode_type.arr); 
  fprintf(fp,"%-16.16s%-28.28s : %s\n"," ",loc_legend[48],d_sort_order.arr); 
    
  next_page();
}


check_line(skip) /* will check for MAX LINE before printing totals */
int skip;
{
	if ((lctr + skip) >= MAX_LINES)
	{
		next_page(); 
	}
}

next_line(skip) /* will check for MAX LINE before printing totals */		
int skip;
{
	if ((lctr + skip) > MAX_LINES)
	{
		next_page(); 
	}
	else
	{
		fprintf(fp,"\n"); ++lctr; 
	}
}

next_page() /* will move the cursor to next page */
{
  
	fprintf(fp,"\n");
	fprintf(fp,"\f");
	lctr=0;
	fprintf(fp,"\n"); 
	 
	print_page_title();
	print_column_title();  	
}

print_line(ch,n) /* this is to obtain required characters */
  char ch;
  int n;
{
	int i;
	for(i=0;i<n;i++)
	fprintf(fp,"%c",ch);  
}

horz_skip(num) /* this is to obtain required blank space */
int num;
{
	int i;
	for(i=0;i<num;i++)fprintf(fp," ");
}

print_end()
{
  fprintf(fp,"\n \n");
  fprintf(fp,"%75s",loc_legend[21]);//loc_legend[23]
  //next_line(1);
  fflush(fp);
  fclose(fp);
}


print_formated(loc_amount)
double loc_amount;
{
	//char s_amt[15], str_amt[15];	
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%14sCR",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
        fprintf(fp,"%14s  ",str_amt);
    }
}  



fetch_legend_value()
{

	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLRCVLST.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 39;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLRCVLST.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )857;
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
			blcommon.get_local_lang_desc(:nd_facility,
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
  sqlstm.arrsiz = 39;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )880;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility;
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


/*get_language_id()

{
	language_id.arr[0] = '\0';
	language_id.len = 0;
	

	EXEC SQL SELECT LANGUAGE_ID INTO :language_id FROM SM_APPL_USER where APPL_USER_ID = :d_user;
	
	if (OERROR)
        err_mesg("SELECTING LANGUAGE_ID failed",0,"");
}*/

get_local_date()
{
	
	/* EXEC SQL EXECUTE

	DECLARE

	t_date  date;
	
	BEGIN
		get_locale_date.convert_to_locale_date(to_date(:nd_temp_date,'DD/MM/YYYY'),:p_language_id,t_date);

		 :nd_loc_date := to_char(t_date,'DD/MM/YYYY');


	END;

	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 39;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( to_date ( :nd_temp_date , 'DD/MM/YYYY' ) , :p_language_id , t_date \
) ; :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )911;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_temp_date;
 sqlstm.sqhstl[0] = (unsigned int  )22;
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
 sqlstm.sqhstl[2] = (unsigned int  )22;
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

get_local_date();

strcpy(date_convert.arr,nd_loc_date.arr); 
}

