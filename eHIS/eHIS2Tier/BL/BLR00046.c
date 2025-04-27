
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
           char  filnam[18];
};
static const struct sqlcxp sqlfpn =
{
    17,
    "T:\\BL\\BLR00046.PC"
};


static unsigned long sqlctx = 10093195;


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
            void  *sqhstv[36];
   unsigned int   sqhstl[36];
            int   sqhsts[36];
            void  *sqindv[36];
            int   sqinds[36];
   unsigned int   sqharm[36];
   unsigned int   *sqharc[36];
   unsigned short  sqadto[36];
   unsigned short  sqtdso[36];
} sqlstm = {10,36};

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

 static const char *sq0006 = 
"y NVL(a.episode_type,'R'),a.patient_id,blcommon.get_reln_code(a.patient_id),\
nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE),nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER),CEIL(\
(NVL(TO_DATE(:b0,'DD/MM/YYYY'),SYSDATE)-nvl(b.DOC_DATE,a.doc_date))) having ((\
sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT))+(sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT\
_AMT,'CANC-WRITEOFF',a.CREDIT_AMT,0))-sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT\
_AMT,'CANC-WRITEOFF',a.DEBIT_AMT,0))))>0 order by a.patient_id            ";

 static const char *sq0007 = 
"DJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE),nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER),CEIL((NVL(\
TO_DATE(:b0,'DD/MM/YYYY'),SYSDATE)-nvl(b.DOC_DATE,a.doc_date))) having ((sum(a\
.DEBIT_AMT)-sum(a.CREDIT_AMT))+(sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,\
'CANC-WRITEOFF',a.CREDIT_AMT,0))-sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,\
'CANC-WRITEOFF',a.DEBIT_AMT,0))))>0 order by a.patient_id            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,370,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,159,0,4,408,0,0,9,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,
87,0,0,3,84,0,2,433,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
114,0,0,4,457,0,4,1701,0,0,26,16,0,1,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,
97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,
1,97,0,0,1,97,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,1,9,0,0,
233,0,0,5,1777,0,4,1758,0,0,36,31,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,3,0,0,2,3,0,0,2,3,0,0,2,3,0,0,
2,3,0,0,1,9,0,0,
392,0,0,6,1486,0,9,1864,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
419,0,0,6,0,0,15,1872,0,0,0,0,0,1,0,
434,0,0,7,1403,0,9,1879,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
461,0,0,7,0,0,15,1887,0,0,0,0,0,1,0,
476,0,0,6,0,0,13,1908,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,
3,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
527,0,0,7,0,0,13,1947,0,0,8,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,3,0,0,2,
4,0,0,2,4,0,0,2,4,0,0,
574,0,0,8,188,0,4,1985,0,0,6,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,
9,0,0,
613,0,0,9,0,0,32,2002,0,0,0,0,0,1,0,
628,0,0,10,96,0,4,4498,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
651,0,0,11,162,0,6,4505,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 4.1                                                  */
/************************************************************************/
/* PROGRAM NAME          : BLR00046.PC                                  */
/* AUTHOR                : Robert Joseph                               */  
/* DATE WRITTEN          : 28/04/2005                                   */      
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
#define REP_WIDTH 132
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
	    nd_as_on_date					[15],
	    nd_br_episode_type				[2],
	    nd_br_citizen					[2],
	    nd_sumdet						[2],
	    d_tre_chk						[2],
	    nd_age_analysis_code	        [11],
	    d_episode_type					[2],
	    d_patient_id					[21],
	    nd_patient_id                   [21],
	    d_doc_type_code					[6],
	    d_citizen						[10],          
	    l_translated_value				[201],	
		p_language_id					[3],
	    l_pk_value						[100]; */ 
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

struct { unsigned short len; unsigned char arr[15]; } nd_as_on_date;

struct { unsigned short len; unsigned char arr[2]; } nd_br_episode_type;

struct { unsigned short len; unsigned char arr[2]; } nd_br_citizen;

struct { unsigned short len; unsigned char arr[2]; } nd_sumdet;

struct { unsigned short len; unsigned char arr[2]; } d_tre_chk;

struct { unsigned short len; unsigned char arr[11]; } nd_age_analysis_code;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[21]; } nd_patient_id;

struct { unsigned short len; unsigned char arr[6]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } d_citizen;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;


/* VARCHAR			age_1_value			[11],
			age_2_value			[11],
			age_3_value			[11],
			age_4_value			[11],
			age_5_value			[11],
			age_1_ind			[8],
			age_2_ind			[8],
			age_3_ind			[8],
			age_4_ind			[8],
			age_5_ind			[8]; */ 
struct { unsigned short len; unsigned char arr[11]; } age_1_value;

struct { unsigned short len; unsigned char arr[11]; } age_2_value;

struct { unsigned short len; unsigned char arr[11]; } age_3_value;

struct { unsigned short len; unsigned char arr[11]; } age_4_value;

struct { unsigned short len; unsigned char arr[11]; } age_5_value;

struct { unsigned short len; unsigned char arr[8]; } age_1_ind;

struct { unsigned short len; unsigned char arr[8]; } age_2_ind;

struct { unsigned short len; unsigned char arr[8]; } age_3_ind;

struct { unsigned short len; unsigned char arr[8]; } age_4_ind;

struct { unsigned short len; unsigned char arr[8]; } age_5_ind;


/* VARCHAR			nd1_ni_pat_id	[21],	
			nd1_oi_pat_id	[21],
			nd1_no_pat_id	[21],
			nd1_oo_pat_id	[21],
			nd1_nd_pat_id	[21],
			nd1_od_pat_id	[21],
			nd1_ne_pat_id	[21],
			nd1_oe_pat_id	[21],
			nd1_nr_pat_id	[21],
			nd1_or_pat_id	[21],
			nd2_ni_pat_id	[21],
	        nd2_oi_pat_id	[21],
			nd2_no_pat_id	[21],
	        nd2_oo_pat_id	[21],
			nd2_nd_pat_id	[21],
	        nd2_od_pat_id	[21],
			nd2_ne_pat_id	[21],
	        nd2_oe_pat_id	[21],
			nd2_nr_pat_id	[21],
	        nd2_or_pat_id	[21],
			nd3_ni_pat_id	[21],
			nd3_oi_pat_id	[21],
			nd3_no_pat_id	[21],
			nd3_oo_pat_id	[21],
			nd3_nd_pat_id	[21],
			nd3_od_pat_id	[21],
			nd3_ne_pat_id	[21],
			nd3_oe_pat_id	[21],
			nd3_nr_pat_id	[21],
			nd3_or_pat_id	[21],
			nd4_ni_pat_id	[21],
	        nd4_oi_pat_id	[21],
			nd4_no_pat_id	[21],
			nd4_oo_pat_id	[21],
			nd4_nd_pat_id	[21],
	        nd4_od_pat_id	[21],
			nd4_ne_pat_id	[21],
	        nd4_oe_pat_id	[21],
			nd4_nr_pat_id	[21],
	        nd4_or_pat_id	[21],
			nd5_ni_pat_id	[21],
	        nd5_oi_pat_id	[21],
			nd5_no_pat_id	[21],
	        nd5_oo_pat_id	[21],
			nd5_nd_pat_id	[21],
	        nd5_od_pat_id	[21],
			nd5_ne_pat_id	[21],
	        nd5_oe_pat_id	[21],
			nd5_nr_pat_id	[21],
	        nd5_or_pat_id	[21],	
			nd6_ni_pat_id	[21],
	        nd6_oi_pat_id	[21],
			nd6_no_pat_id	[21],
	        nd6_oo_pat_id	[21],
			nd6_nd_pat_id	[21],
	        nd6_od_pat_id	[21],
			nd6_ne_pat_id	[21],
	        nd6_oe_pat_id	[21],
			nd6_nr_pat_id	[21],
	        nd6_or_pat_id	[21]; */ 
struct { unsigned short len; unsigned char arr[21]; } nd1_ni_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_oi_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_no_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_oo_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_nd_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_od_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_ne_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_oe_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_nr_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_or_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_ni_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_oi_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_no_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_oo_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_nd_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_od_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_ne_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_oe_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_nr_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_or_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_ni_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_oi_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_no_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_oo_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_nd_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_od_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_ne_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_oe_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_nr_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_or_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_ni_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_oi_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_no_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_oo_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_nd_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_od_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_ne_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_oe_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_nr_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_or_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_ni_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_oi_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_no_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_oo_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_nd_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_od_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_ne_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_oe_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_nr_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_or_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_ni_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_oi_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_no_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_oo_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_nd_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_od_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_ne_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_oe_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_nr_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_or_pat_id;
 

/* VARCHAR		nd1_n_pat_id	[21],
			nd1_o_pat_id	[21],
			nd2_n_pat_id	[21],
			nd2_o_pat_id	[21],
			nd3_n_pat_id	[21],
			nd3_o_pat_id	[21],
			nd4_n_pat_id	[21],
			nd4_o_pat_id	[21],
			nd5_n_pat_id	[21],
			nd5_o_pat_id	[21],
			nd6_n_pat_id	[21],
			nd6_o_pat_id	[21]; */ 
struct { unsigned short len; unsigned char arr[21]; } nd1_n_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_o_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_n_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_o_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_n_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_o_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_n_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_o_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_n_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_o_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_n_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_o_pat_id;


  char l_str1[1000];

  /* VARCHAR   nd1_ip_pat_id	[21],
			nd1_op_pat_id	[21],
			nd1_dy_pat_id	[21],
			nd1_em_pat_id	[21],
			nd1_ex_pat_id	[21],
			nd2_ip_pat_id	[21],
			nd2_op_pat_id	[21],
			nd2_dy_pat_id	[21],
			nd2_em_pat_id	[21],
			nd2_ex_pat_id	[21],
			nd3_ip_pat_id	[21],
			nd3_op_pat_id	[21],
			nd3_dy_pat_id	[21],
			nd3_em_pat_id	[21],
			nd3_ex_pat_id	[21],
			nd4_ip_pat_id	[21],
			nd4_op_pat_id	[21],
			nd4_dy_pat_id	[21],
			nd4_em_pat_id	[21],
			nd4_ex_pat_id	[21],
			nd5_ip_pat_id	[21],
			nd5_op_pat_id	[21],
			nd5_dy_pat_id	[21],
			nd5_em_pat_id	[21],
			nd5_ex_pat_id	[21],
			nd6_ip_pat_id	[21],
			nd6_op_pat_id	[21],
			nd6_dy_pat_id	[21],
			nd6_em_pat_id	[21],
			nd6_ex_pat_id	[21]; */ 
struct { unsigned short len; unsigned char arr[21]; } nd1_ip_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_op_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_dy_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_em_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd1_ex_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_ip_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_op_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_dy_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_em_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_ex_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_ip_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_op_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_dy_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_em_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_ex_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_ip_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_op_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_dy_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_em_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_ex_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_ip_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_op_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_dy_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_em_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_ex_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_ip_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_op_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_dy_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_em_pat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_ex_pat_id;


  /* VARCHAR   nd1_spat_id	[21],
			nd2_spat_id	[21],
			nd3_spat_id	[21],
			nd4_spat_id	[21],
			nd5_spat_id	[21],
			nd6_spat_id	[21]; */ 
struct { unsigned short len; unsigned char arr[21]; } nd1_spat_id;

struct { unsigned short len; unsigned char arr[21]; } nd2_spat_id;

struct { unsigned short len; unsigned char arr[21]; } nd3_spat_id;

struct { unsigned short len; unsigned char arr[21]; } nd4_spat_id;

struct { unsigned short len; unsigned char arr[21]; } nd5_spat_id;

struct { unsigned short len; unsigned char arr[21]; } nd6_spat_id;


	int i,sl_no=1,page_no=0;
	long   	nd_days1=0,
			nd_days2=0,
			nd_days3=0,
			nd_days4=0,
            nd_days5=0,
			doc_date=0;

	double d_episode_id,d_visit_id,d_doc_num ;

    double  d_bil_out_amt=0,d_bil_write_off_amt=0,d_bil_tot_ot_amt=0;

    double	nd_cd1_rev_outamt=0,nd_cd2_rev_outamt=0,nd_cd3_rev_outamt=0,nd_cd4_rev_outamt=0,nd_cd5_rev_outamt=0,nd_cd6_rev_outamt=0,
			nd_cd1_writeoff_amt=0,nd_cd2_writeoff_amt=0,nd_cd3_writeoff_amt=0,nd_cd4_writeoff_amt=0,nd_cd5_writeoff_amt=0,nd_cd6_writeoff_amt=0,
			nd_cd1_tot_outamt=0,nd_cd2_tot_outamt=0,nd_cd3_tot_outamt=0,nd_cd4_tot_outamt=0,nd_cd5_tot_outamt=0,nd_cd6_tot_outamt=0,
			nd_ncd1_rev_outamt=0,nd_ncd2_rev_outamt=0,nd_ncd3_rev_outamt=0,nd_ncd4_rev_outamt=0,nd_ncd5_rev_outamt=0,nd_ncd6_rev_outamt=0,
			nd_ncd1_writeoff_amt=0,nd_ncd2_writeoff_amt=0,nd_ncd3_writeoff_amt=0,nd_ncd4_writeoff_amt=0,nd_ncd5_writeoff_amt=0,nd_ncd6_writeoff_amt=0,
			nd_ncd1_tot_outamt=0,nd_ncd2_tot_outamt=0,nd_ncd3_tot_outamt=0,nd_ncd4_tot_outamt=0,nd_ncd5_tot_outamt=0,nd_ncd6_tot_outamt=0;

double nd_d1_ctz_epi_outamt=0,nd_d2_ctz_epi_outamt=0,nd_d3_ctz_epi_outamt=0,nd_d4_ctz_epi_outamt=0,nd_d5_ctz_epi_outamt=0,nd_d6_ctz_epi_outamt=0,
nd_d1_ctz_epd_outamt=0,nd_d2_ctz_epd_outamt=0,nd_d3_ctz_epd_outamt=0,nd_d4_ctz_epd_outamt=0,nd_d5_ctz_epd_outamt=0,nd_d6_ctz_epd_outamt=0,
nd_d1_ctz_epe_outamt=0,nd_d2_ctz_epe_outamt=0,nd_d3_ctz_epe_outamt=0,nd_d4_ctz_epe_outamt=0,nd_d5_ctz_epe_outamt=0,nd_d6_ctz_epe_outamt=0,
nd_d1_ctz_epo_outamt=0,nd_d2_ctz_epo_outamt=0,nd_d3_ctz_epo_outamt=0,nd_d4_ctz_epo_outamt=0,nd_d5_ctz_epo_outamt=0,nd_d6_ctz_epo_outamt=0,
nd_d1_ctz_epr_outamt=0,nd_d2_ctz_epr_outamt=0,nd_d3_ctz_epr_outamt=0,nd_d4_ctz_epr_outamt=0,nd_d5_ctz_epr_outamt=0,nd_d6_ctz_epr_outamt=0,
nd_d1_ctz_epi_writeoff_amt=0,nd_d2_ctz_epi_writeoff_amt=0,nd_d3_ctz_epi_writeoff_amt=0,nd_d4_ctz_epi_writeoff_amt=0,nd_d5_ctz_epi_writeoff_amt=0,nd_d6_ctz_epi_writeoff_amt=0,
nd_d1_ctz_epd_writeoff_amt=0,nd_d2_ctz_epd_writeoff_amt=0,nd_d3_ctz_epd_writeoff_amt=0,nd_d4_ctz_epd_writeoff_amt=0,nd_d5_ctz_epd_writeoff_amt=0,nd_d6_ctz_epd_writeoff_amt=0,
nd_d1_ctz_epe_writeoff_amt=0,nd_d2_ctz_epe_writeoff_amt=0,nd_d3_ctz_epe_writeoff_amt=0,nd_d4_ctz_epe_writeoff_amt=0,nd_d5_ctz_epe_writeoff_amt=0,nd_d6_ctz_epe_writeoff_amt=0,
nd_d1_ctz_epo_writeoff_amt=0,nd_d2_ctz_epo_writeoff_amt=0,nd_d3_ctz_epo_writeoff_amt=0,nd_d4_ctz_epo_writeoff_amt=0,nd_d5_ctz_epo_writeoff_amt=0,nd_d6_ctz_epo_writeoff_amt=0,
nd_d1_ctz_epr_writeoff_amt=0,nd_d2_ctz_epr_writeoff_amt=0,nd_d3_ctz_epr_writeoff_amt=0,nd_d4_ctz_epr_writeoff_amt=0,nd_d5_ctz_epr_writeoff_amt=0,nd_d6_ctz_epr_writeoff_amt=0,
nd_d1_ctz_epi_tot_outamt=0,nd_d2_ctz_epi_tot_outamt=0,nd_d3_ctz_epi_tot_outamt=0,nd_d4_ctz_epi_tot_outamt=0,nd_d5_ctz_epi_tot_outamt=0,nd_d6_ctz_epi_tot_outamt=0,
nd_d1_ctz_epd_tot_outamt=0,nd_d2_ctz_epd_tot_outamt=0,nd_d3_ctz_epd_tot_outamt=0,nd_d4_ctz_epd_tot_outamt=0,nd_d5_ctz_epd_tot_outamt=0,nd_d6_ctz_epd_tot_outamt=0,
nd_d1_ctz_epe_tot_outamt=0,nd_d2_ctz_epe_tot_outamt=0,nd_d3_ctz_epe_tot_outamt=0,nd_d4_ctz_epe_tot_outamt=0,nd_d5_ctz_epe_tot_outamt=0,nd_d6_ctz_epe_tot_outamt=0,
nd_d1_ctz_epo_tot_outamt=0,nd_d2_ctz_epo_tot_outamt=0,nd_d3_ctz_epo_tot_outamt=0,nd_d4_ctz_epo_tot_outamt=0,nd_d5_ctz_epo_tot_outamt=0,nd_d6_ctz_epo_tot_outamt=0,
nd_d1_ctz_epr_tot_outamt=0,nd_d2_ctz_epr_tot_outamt=0,nd_d3_ctz_epr_tot_outamt=0,nd_d4_ctz_epr_tot_outamt=0,nd_d5_ctz_epr_tot_outamt=0,nd_d6_ctz_epr_tot_outamt=0,
nd_d1_nctz_epi_outamt=0,nd_d2_nctz_epi_outamt=0,nd_d3_nctz_epi_outamt=0,nd_d4_nctz_epi_outamt=0,nd_d5_nctz_epi_outamt=0,nd_d6_nctz_epi_outamt=0,
nd_d1_nctz_epd_outamt=0,nd_d2_nctz_epd_outamt=0,nd_d3_nctz_epd_outamt=0,nd_d4_nctz_epd_outamt=0,nd_d5_nctz_epd_outamt=0,nd_d6_nctz_epd_outamt=0,
nd_d1_nctz_epe_outamt=0,nd_d2_nctz_epe_outamt=0,nd_d3_nctz_epe_outamt=0,nd_d4_nctz_epe_outamt=0,nd_d5_nctz_epe_outamt=0,nd_d6_nctz_epe_outamt=0,
nd_d1_nctz_epr_outamt=0,nd_d2_nctz_epr_outamt=0,nd_d3_nctz_epr_outamt=0,nd_d4_nctz_epr_outamt=0,nd_d5_nctz_epr_outamt=0,nd_d6_nctz_epr_outamt=0,
nd_d1_nctz_epo_outamt=0,nd_d2_nctz_epo_outamt=0,nd_d3_nctz_epo_outamt=0,nd_d4_nctz_epo_outamt=0,nd_d5_nctz_epo_outamt=0,nd_d6_nctz_epo_outamt=0,
nd_d1_nctz_epi_writeoff_amt=0,nd_d2_nctz_epi_writeoff_amt=0,nd_d3_nctz_epi_writeoff_amt=0,nd_d4_nctz_epi_writeoff_amt=0,nd_d5_nctz_epi_writeoff_amt=0,nd_d6_nctz_epi_writeoff_amt=0,
nd_d1_nctz_epd_writeoff_amt=0,nd_d2_nctz_epd_writeoff_amt=0,nd_d3_nctz_epd_writeoff_amt=0,nd_d4_nctz_epd_writeoff_amt=0,nd_d5_nctz_epd_writeoff_amt=0,nd_d6_nctz_epd_writeoff_amt=0,
nd_d1_nctz_epo_writeoff_amt=0,nd_d2_nctz_epo_writeoff_amt=0,nd_d3_nctz_epo_writeoff_amt=0,nd_d4_nctz_epo_writeoff_amt=0,nd_d5_nctz_epo_writeoff_amt=0,nd_d6_nctz_epo_writeoff_amt=0,
nd_d1_nctz_epe_writeoff_amt=0,nd_d2_nctz_epe_writeoff_amt=0,nd_d3_nctz_epe_writeoff_amt=0,nd_d4_nctz_epe_writeoff_amt=0,nd_d5_nctz_epe_writeoff_amt=0,nd_d6_nctz_epe_writeoff_amt=0,
nd_d1_nctz_epr_writeoff_amt=0,nd_d2_nctz_epr_writeoff_amt=0,nd_d3_nctz_epr_writeoff_amt=0,nd_d4_nctz_epr_writeoff_amt=0,nd_d5_nctz_epr_writeoff_amt=0,nd_d6_nctz_epr_writeoff_amt=0,
nd_d1_nctz_epi_tot_outamt=0,nd_d2_nctz_epi_tot_outamt=0,nd_d3_nctz_epi_tot_outamt=0,nd_d4_nctz_epi_tot_outamt=0,nd_d5_nctz_epi_tot_outamt=0,nd_d6_nctz_epi_tot_outamt=0,
nd_d1_nctz_epd_tot_outamt=0,nd_d2_nctz_epd_tot_outamt=0,nd_d3_nctz_epd_tot_outamt=0,nd_d4_nctz_epd_tot_outamt=0,nd_d5_nctz_epd_tot_outamt=0,nd_d6_nctz_epd_tot_outamt=0,
nd_d1_nctz_epo_tot_outamt=0,nd_d2_nctz_epo_tot_outamt=0,nd_d3_nctz_epo_tot_outamt=0,nd_d4_nctz_epo_tot_outamt=0,nd_d5_nctz_epo_tot_outamt=0,nd_d6_nctz_epo_tot_outamt=0,
nd_d1_nctz_epe_tot_outamt=0,nd_d2_nctz_epe_tot_outamt=0,nd_d3_nctz_epe_tot_outamt=0,nd_d4_nctz_epe_tot_outamt=0,nd_d5_nctz_epe_tot_outamt=0,nd_d6_nctz_epe_tot_outamt=0,
nd_d1_nctz_epr_tot_outamt=0,nd_d2_nctz_epr_tot_outamt=0,nd_d3_nctz_epr_tot_outamt=0,nd_d4_nctz_epr_tot_outamt=0,nd_d5_nctz_epr_tot_outamt=0,nd_d6_nctz_epr_tot_outamt=0;

double  nd_d1_epi_outamt=0,nd_d2_epi_outamt=0,nd_d3_epi_outamt=0,nd_d4_epi_outamt=0,nd_d5_epi_outamt=0,nd_d6_epi_outamt=0,
nd_d1_epo_outamt=0,nd_d2_epo_outamt=0,nd_d3_epo_outamt=0,nd_d4_epo_outamt=0,nd_d5_epo_outamt,nd_d6_epo_outamt=0,
nd_d1_epe_outamt=0,nd_d2_epe_outamt=0,nd_d3_epe_outamt=0,nd_d4_epe_outamt=0,nd_d5_epe_outamt,nd_d6_epe_outamt=0,
nd_d1_epd_outamt=0,nd_d2_epd_outamt=0,nd_d3_epd_outamt=0,nd_d4_epd_outamt=0,nd_d5_epd_outamt,nd_d6_epd_outamt=0,
nd_d1_epr_outamt=0,nd_d2_epr_outamt=0,nd_d3_epr_outamt=0,nd_d4_epr_outamt=0,nd_d5_epr_outamt,nd_d6_epr_outamt=0,
nd_d1_epi_writeoff_amt=0,nd_d2_epi_writeoff_amt=0,nd_d3_epi_writeoff_amt=0,nd_d4_epi_writeoff_amt=0,nd_d5_epi_writeoff_amt=0,nd_d6_epi_writeoff_amt=0,
nd_d1_epd_writeoff_amt=0,nd_d2_epd_writeoff_amt=0,nd_d3_epd_writeoff_amt=0,nd_d4_epd_writeoff_amt=0,nd_d5_epd_writeoff_amt=0,nd_d6_epd_writeoff_amt=0,
nd_d1_epe_writeoff_amt=0,nd_d2_epe_writeoff_amt=0,nd_d3_epe_writeoff_amt=0,nd_d4_epe_writeoff_amt=0,nd_d5_epe_writeoff_amt=0,nd_d6_epe_writeoff_amt=0,
nd_d1_epo_writeoff_amt=0,nd_d2_epo_writeoff_amt=0,nd_d3_epo_writeoff_amt=0,nd_d4_epo_writeoff_amt=0,nd_d5_epo_writeoff_amt=0,nd_d6_epo_writeoff_amt=0,
nd_d1_epr_writeoff_amt=0,nd_d2_epr_writeoff_amt=0,nd_d3_epr_writeoff_amt=0,nd_d4_epr_writeoff_amt=0,nd_d5_epr_writeoff_amt=0,nd_d6_epr_writeoff_amt=0,
nd_d1_epi_tot_outamt=0,nd_d2_epi_tot_outamt=0,nd_d3_epi_tot_outamt=0,nd_d4_epi_tot_outamt=0,nd_d5_epi_tot_outamt=0,nd_d6_epi_tot_outamt=0,
nd_d1_epd_tot_outamt=0,nd_d2_epd_tot_outamt=0,nd_d3_epd_tot_outamt=0,nd_d4_epd_tot_outamt=0,nd_d5_epd_tot_outamt=0,nd_d6_epd_tot_outamt=0,
nd_d1_epe_tot_outamt=0,nd_d2_epe_tot_outamt=0,nd_d3_epe_tot_outamt=0,nd_d4_epe_tot_outamt=0,nd_d5_epe_tot_outamt=0,nd_d6_epe_tot_outamt=0,
nd_d1_epo_tot_outamt=0,nd_d2_epo_tot_outamt=0,nd_d3_epo_tot_outamt=0,nd_d4_epo_tot_outamt=0,nd_d5_epo_tot_outamt=0,nd_d6_epo_tot_outamt=0,
nd_d1_epr_tot_outamt=0,nd_d2_epr_tot_outamt=0,nd_d3_epr_tot_outamt=0,nd_d4_epr_tot_outamt=0,nd_d5_epr_tot_outamt=0,nd_d6_epr_tot_outamt=0;



 double	   nd_tot_malay_revamt=0, nd_tot_malay_writeoffamt=0, nd_tot_malay_outamt=0,
	   nd_tot_fore_revamt=0,nd_tot_fore_writeoffamt=0,nd_tot_fore_outamt=0;
  double nd_grand_tot_revamt=0, nd_grand_tot_writeoffamt=0, nd_grand_tot_outamt=0;	


  double nd_tot_malay_d1_revamt=0,nd_tot_malay_d2_revamt=0,nd_tot_malay_d3_revamt=0,nd_tot_malay_d4_revamt=0,nd_tot_malay_d5_revamt=0,nd_tot_malay_d6_revamt=0,
nd_tot_mal_ip_revamt=0,nd_tot_mal_op_revamt=0,nd_tot_mal_dy_revamt=0,nd_tot_mal_em_revamt=0,nd_tot_mal_ex_revamt=0,
nd_tot_malay_eps_revamt=0,
nd_tot_for_d1_revamt=0,nd_tot_for_d2_revamt=0,nd_tot_for_d3_revamt=0,nd_tot_for_d4_revamt=0,nd_tot_for_d5_revamt=0,nd_tot_for_d6_revamt=0,
nd_tot_for_ip_revamt=0,nd_tot_for_op_revamt=0,nd_tot_for_ex_revamt=0,nd_tot_for_dy_revamt=0,nd_tot_for_em_revamt=0,
nd_tot_for_eps_revamt=0,
nd_tot_malay_d1_writeoff_amt=0,nd_tot_malay_d2_writeoff_amt=0,nd_tot_malay_d3_writeoff_amt=0,nd_tot_malay_d4_writeoff_amt=0,nd_tot_malay_d5_writeoff_amt=0,nd_tot_malay_d6_writeoff_amt=0,
nd_tot_mal_ip_writeoff_amt=0,nd_tot_mal_op_writeoff_amt=0,nd_tot_mal_em_writeoff_amt=0,nd_tot_mal_ex_writeoff_amt=0,nd_tot_mal_dy_writeoff_amt=0,
nd_tot_malay_eps_writeoff_amt=0,
nd_tot_for_d1_writeoff_amt=0,nd_tot_for_d2_writeoff_amt=0,nd_tot_for_d3_writeoff_amt=0,nd_tot_for_d4_writeoff_amt=0,nd_tot_for_d5_writeoff_amt=0,nd_tot_for_d6_writeoff_amt=0,
nd_tot_for_ip_writeoff_amt=0,nd_tot_for_op_writeoff_amt=0,nd_tot_for_em_writeoff_amt=0,nd_tot_for_dy_writeoff_amt=0,nd_tot_for_ex_writeoff_amt=0,
nd_tot_for_eps_writeoff_amt=0,
nd_tot_malay_d1_outamt=0,nd_tot_malay_d2_outamt=0,nd_tot_malay_d3_outamt=0,nd_tot_malay_d4_outamt=0,nd_tot_malay_d5_outamt=0,nd_tot_malay_d6_outamt=0,
nd_tot_mal_ip_outamt=0,nd_tot_mal_op_outamt=0,nd_tot_mal_dy_outamt=0,nd_tot_mal_em_outamt=0,nd_tot_mal_ex_outamt=0,
nd_tot_malay_eps_outamt=0,
nd_tot_for_d1_outamt=0,nd_tot_for_d2_outamt=0,nd_tot_for_d3_outamt=0,nd_tot_for_d4_outamt=0,nd_tot_for_d5_outamt=0,nd_tot_for_d6_outamt=0,
nd_tot_for_ip_outamt=0,nd_tot_for_op_outamt=0,nd_tot_for_dy_outamt=0,nd_tot_for_em_outamt=0,nd_tot_for_ex_outamt=0,
nd_tot_for_eps_outamt=0;

double nd_tot_d1_ep_outamt=0,nd_tot_d2_ep_outamt=0,nd_tot_d3_ep_outamt=0,nd_tot_d4_ep_outamt=0,nd_tot_d5_ep_outamt=0,nd_tot_d6_ep_outamt=0,
nd_tot_ip_outamt=0,nd_tot_dy_outamt=0,nd_tot_op_outamt=0,nd_tot_em_outamt=0,nd_tot_ex_outamt=0,
nd_tot_eps_outamt=0,
nd_tot_d1_ep_writeoff_amt=0,nd_tot_d2_ep_writeoff_amt=0,nd_tot_d3_ep_writeoff_amt=0,nd_tot_d4_ep_writeoff_amt=0,nd_tot_d5_ep_writeoff_amt=0,nd_tot_d6_ep_writeoff_amt=0,
nd_tot_ip_writeoff_amt=0,nd_tot_op_writeoff_amt=0,nd_tot_em_writeoff_amt=0,nd_tot_ex_writeoff_amt=0,nd_tot_dy_writeoff_amt=0,
nd_tot_eps_writeoff_amt=0,
nd_tot_d1_ep_tot_outamt=0,nd_tot_d2_ep_tot_outamt=0,nd_tot_d3_ep_tot_outamt=0,nd_tot_d4_ep_tot_outamt=0,nd_tot_d5_ep_tot_outamt=0,nd_tot_d6_ep_tot_outamt=0,
nd_tot_ip_tot_outamt=0,nd_tot_op_tot_outamt=0,nd_tot_dy_tot_outamt=0,nd_tot_em_tot_outamt=0,nd_tot_ex_tot_outamt=0,
nd_tot_eps_tot_outamt=0;

double   nd_d1_outamt=0,nd_d1_writeoff_amt=0,nd_d1_tot_outamt=0,
		 nd_d2_outamt=0,nd_d2_writeoff_amt=0,nd_d2_tot_outamt=0,
		 nd_d3_outamt=0,nd_d3_writeoff_amt=0,nd_d3_tot_outamt=0,
		 nd_d4_outamt=0,nd_d4_writeoff_amt=0,nd_d4_tot_outamt=0,
		 nd_d5_outamt=0,nd_d5_writeoff_amt=0,nd_d5_tot_outamt=0,
	     nd_d6_outamt=0,nd_d6_writeoff_amt=0,nd_d6_tot_outamt=0;

int d1_ctz_epi_pat_cnt=0,d2_ctz_epi_pat_cnt=0,d3_ctz_epi_pat_cnt=0,d4_ctz_epi_pat_cnt=0,d5_ctz_epi_pat_cnt=0,d6_ctz_epi_pat_cnt=0,
d1_ctz_epd_pat_cnt=0,d2_ctz_epd_pat_cnt=0,d3_ctz_epd_pat_cnt=0,d4_ctz_epd_pat_cnt=0,d5_ctz_epd_pat_cnt=0,d6_ctz_epd_pat_cnt=0,
d1_ctz_epe_pat_cnt=0,d2_ctz_epe_pat_cnt=0,d3_ctz_epe_pat_cnt=0,d4_ctz_epe_pat_cnt=0,d5_ctz_epe_pat_cnt=0,d6_ctz_epe_pat_cnt=0,
d1_ctz_epr_pat_cnt=0,d2_ctz_epr_pat_cnt=0,d3_ctz_epr_pat_cnt=0,d4_ctz_epr_pat_cnt=0,d5_ctz_epr_pat_cnt=0,d6_ctz_epr_pat_cnt=0,
d1_ctz_epo_pat_cnt=0,d2_ctz_epo_pat_cnt=0,d3_ctz_epo_pat_cnt=0,d4_ctz_epo_pat_cnt=0,d5_ctz_epo_pat_cnt=0,d6_ctz_epo_pat_cnt=0,
d1_nctz_epi_pat_cnt=0,d2_nctz_epi_pat_cnt=0,d3_nctz_epi_pat_cnt=0,d4_nctz_epi_pat_cnt=0,d5_nctz_epi_pat_cnt=0,d6_nctz_epi_pat_cnt=0,
d1_nctz_epo_pat_cnt=0,d2_nctz_epo_pat_cnt=0,d3_nctz_epo_pat_cnt=0,d4_nctz_epo_pat_cnt=0,d5_nctz_epo_pat_cnt=0,d6_nctz_epo_pat_cnt=0,
d1_nctz_epd_pat_cnt=0,d2_nctz_epd_pat_cnt=0,d3_nctz_epd_pat_cnt=0,d4_nctz_epd_pat_cnt=0,d5_nctz_epd_pat_cnt=0,d6_nctz_epd_pat_cnt=0,
d1_nctz_epe_pat_cnt=0,d2_nctz_epe_pat_cnt=0,d3_nctz_epe_pat_cnt=0,d4_nctz_epe_pat_cnt=0,d5_nctz_epe_pat_cnt=0,d6_nctz_epe_pat_cnt=0,
d1_nctz_epr_pat_cnt=0,d2_nctz_epr_pat_cnt=0,d3_nctz_epr_pat_cnt=0,d4_nctz_epr_pat_cnt=0,d5_nctz_epr_pat_cnt=0,d6_nctz_epr_pat_cnt=0;


int d1_pat_cnt=0,d2_pat_cnt=0,d3_pat_cnt=0,d4_pat_cnt=0,d5_pat_cnt=0,d6_pat_cnt=0,
nd1_pat_cnt=0,nd2_pat_cnt=0,nd3_pat_cnt=0,nd4_pat_cnt=0,nd5_pat_cnt=0,nd6_pat_cnt=0;

int d1_epi_pat_cnt=0,d1_epo_pat_cnt=0,d1_epd_pat_cnt=0,d1_epe_pat_cnt=0,d1_epr_pat_cnt=0,
d2_epi_pat_cnt=0,d2_epo_pat_cnt=0,d2_epd_pat_cnt=0,d2_epe_pat_cnt=0,d2_epr_pat_cnt=0,
d3_epi_pat_cnt=0,d3_epo_pat_cnt=0,d3_epd_pat_cnt=0,d3_epe_pat_cnt=0,d3_epr_pat_cnt=0,
d4_epi_pat_cnt=0,d4_epo_pat_cnt=0,d4_epd_pat_cnt=0,d4_epe_pat_cnt=0,d4_epr_pat_cnt=0,
d5_epi_pat_cnt=0,d5_epo_pat_cnt=0,d5_epd_pat_cnt=0,d5_epe_pat_cnt=0,d5_epr_pat_cnt=0,
d6_epi_pat_cnt=0,d6_epo_pat_cnt=0,d6_epd_pat_cnt=0,d6_epe_pat_cnt=0,d6_epr_pat_cnt=0;


 int nd_tot_malay_pat1=0,nd_tot_malay_pat2=0,nd_tot_malay_pat3=0,nd_tot_malay_pat4=0,nd_tot_malay_pat5=0,nd_tot_malay_pat6=0,
nd_tot_for_pat1=0,nd_tot_for_pat2=0,nd_tot_for_pat3=0,nd_tot_for_pat4=0,nd_tot_for_pat5=0,nd_tot_for_pat6=0,
nd_tot_mal_ip_pat=0,nd_tot_mal_op_pat=0,nd_tot_mal_dy_pat=0,nd_tot_mal_em_pat=0,nd_tot_mal_ex_pat=0,
nd_tot_for_ip_pat=0,nd_tot_for_op_pat=0,nd_tot_for_dy_pat=0,nd_tot_for_em_pat=0,nd_tot_for_ex_pat=0;

int nd_tot_d1_ep_pat=0,nd_tot_d2_ep_pat=0,nd_tot_d3_ep_pat=0,nd_tot_d4_ep_pat=0,nd_tot_d5_ep_pat=0,nd_tot_d6_ep_pat=0,
nd_tot_ip_pat=0,nd_tot_op_pat=0,nd_tot_dy_pat=0,nd_tot_em_pat=0,nd_tot_ex_pat=0;

int nd_tot_malay_pat=0,nd_tot_fore_pat=0,nd_grand_tot_pat=0;
int d1_spat_cnt=0,d2_spat_cnt=0,d3_spat_cnt=0,d4_spat_cnt=0,d5_spat_cnt=0,d6_spat_cnt=0,nd_tot_sm_pat=0;

int nd_tot_malay_eps_pat=0,nd_tot_for_eps_pat=0,nd_tot_eps_pat=0;
	double 	 nd_tot_sm_outamt,
	nd_tot_sm_writeoff_amt,
	nd_tot_sm_tot_outamt;

	char filename[150];
	char x_msg[200];
	char loc_legend[999][201];
	char l_mesg[200];

 /* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLR00046.c-arc   1.0   Apr 19 2007 17:05:02   vcm_th  $ sqlca.h 
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
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/BLR00046.c-arc   1.0   Apr 19 2007 17:05:02   vcm_th  $ sqlda.h 
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


	strcpy(g_pgm_id,"BLR00046");
    strcpy(nd_pwd.arr,argv[1]);
    nd_pwd.len = strlen(nd_pwd.arr);
	 

    /* EXEC sql connect :nd_pwd; */ 

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
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


  
   
  
	  
    if (sqlca.sqlcode < 0 )
	   {
        disp_message(ORA_MESG,"Error in connecting to Oracle");
        proc_exit();
       }

		set_meduser_role(); 

		strcpy(p_language_id.arr,l_language_id.arr);

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


	nd_as_on_date.arr[0]				= '\0';				
        nd_br_episode_type.arr[0]			= '\0';			
	nd_br_citizen.arr[0]				= '\0';					
	nd_age_analysis_code.arr[0]			= '\0';	
	nd_sumdet.arr[0]				= '\0';				
	d_tre_chk.arr[0]				= '\0';	           		
			
        /* EXEC SQL SELECT	PARAM1,PARAM2,PARAM3,PARAM4,PARAM5,PARAM6
		 INTO :nd_as_on_date,
			:nd_br_episode_type,
			:nd_br_citizen,
			:nd_age_analysis_code,
			:nd_sumdet,
			:d_tre_chk	
		FROM SY_PROG_PARAM
                WHERE PGM_ID   = :d_curr_pgm_name
                AND SESSION_ID = :nd_session_id
                AND PGM_DATE   = :nd_pgm_date; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 9;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,PARAM4 ,PARAM5 ,PARAM6\
 into :b0,:b1,:b2,:b3,:b4,:b5  from SY_PROG_PARAM where ((PGM_ID=:b6 and SESSI\
ON_ID=:b7) and PGM_DATE=:b8)";
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )36;
        sqlstm.selerr = (unsigned short)1;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlstm.sqhstv[0] = (         void  *)&nd_as_on_date;
        sqlstm.sqhstl[0] = (unsigned int  )17;
        sqlstm.sqhsts[0] = (         int  )0;
        sqlstm.sqindv[0] = (         void  *)0;
        sqlstm.sqinds[0] = (         int  )0;
        sqlstm.sqharm[0] = (unsigned int  )0;
        sqlstm.sqadto[0] = (unsigned short )0;
        sqlstm.sqtdso[0] = (unsigned short )0;
        sqlstm.sqhstv[1] = (         void  *)&nd_br_episode_type;
        sqlstm.sqhstl[1] = (unsigned int  )4;
        sqlstm.sqhsts[1] = (         int  )0;
        sqlstm.sqindv[1] = (         void  *)0;
        sqlstm.sqinds[1] = (         int  )0;
        sqlstm.sqharm[1] = (unsigned int  )0;
        sqlstm.sqadto[1] = (unsigned short )0;
        sqlstm.sqtdso[1] = (unsigned short )0;
        sqlstm.sqhstv[2] = (         void  *)&nd_br_citizen;
        sqlstm.sqhstl[2] = (unsigned int  )4;
        sqlstm.sqhsts[2] = (         int  )0;
        sqlstm.sqindv[2] = (         void  *)0;
        sqlstm.sqinds[2] = (         int  )0;
        sqlstm.sqharm[2] = (unsigned int  )0;
        sqlstm.sqadto[2] = (unsigned short )0;
        sqlstm.sqtdso[2] = (unsigned short )0;
        sqlstm.sqhstv[3] = (         void  *)&nd_age_analysis_code;
        sqlstm.sqhstl[3] = (unsigned int  )13;
        sqlstm.sqhsts[3] = (         int  )0;
        sqlstm.sqindv[3] = (         void  *)0;
        sqlstm.sqinds[3] = (         int  )0;
        sqlstm.sqharm[3] = (unsigned int  )0;
        sqlstm.sqadto[3] = (unsigned short )0;
        sqlstm.sqtdso[3] = (unsigned short )0;
        sqlstm.sqhstv[4] = (         void  *)&nd_sumdet;
        sqlstm.sqhstl[4] = (unsigned int  )4;
        sqlstm.sqhsts[4] = (         int  )0;
        sqlstm.sqindv[4] = (         void  *)0;
        sqlstm.sqinds[4] = (         int  )0;
        sqlstm.sqharm[4] = (unsigned int  )0;
        sqlstm.sqadto[4] = (unsigned short )0;
        sqlstm.sqtdso[4] = (unsigned short )0;
        sqlstm.sqhstv[5] = (         void  *)&d_tre_chk;
        sqlstm.sqhstl[5] = (unsigned int  )4;
        sqlstm.sqhsts[5] = (         int  )0;
        sqlstm.sqindv[5] = (         void  *)0;
        sqlstm.sqinds[5] = (         int  )0;
        sqlstm.sqharm[5] = (unsigned int  )0;
        sqlstm.sqadto[5] = (unsigned short )0;
        sqlstm.sqtdso[5] = (unsigned short )0;
        sqlstm.sqhstv[6] = (         void  *)&d_curr_pgm_name;
        sqlstm.sqhstl[6] = (unsigned int  )17;
        sqlstm.sqhsts[6] = (         int  )0;
        sqlstm.sqindv[6] = (         void  *)0;
        sqlstm.sqinds[6] = (         int  )0;
        sqlstm.sqharm[6] = (unsigned int  )0;
        sqlstm.sqadto[6] = (unsigned short )0;
        sqlstm.sqtdso[6] = (unsigned short )0;
        sqlstm.sqhstv[7] = (         void  *)&nd_session_id;
        sqlstm.sqhstl[7] = (unsigned int  )18;
        sqlstm.sqhsts[7] = (         int  )0;
        sqlstm.sqindv[7] = (         void  *)0;
        sqlstm.sqinds[7] = (         int  )0;
        sqlstm.sqharm[7] = (unsigned int  )0;
        sqlstm.sqadto[7] = (unsigned short )0;
        sqlstm.sqtdso[7] = (unsigned short )0;
        sqlstm.sqhstv[8] = (         void  *)&nd_pgm_date;
        sqlstm.sqhstl[8] = (unsigned int  )27;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NODATAFOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");


			nd_as_on_date.arr[nd_as_on_date.len]		='\0';			
            nd_br_episode_type.arr[nd_br_episode_type.len]		='\0';		
			nd_br_citizen.arr[nd_br_citizen.len]				='\0';				
			nd_age_analysis_code.arr[nd_age_analysis_code.len]					='\0';				
		    nd_sumdet.arr[nd_sumdet.len]		='\0';
          
	/* EXEC SQL DELETE SY_PROG_PARAM
              WHERE PGM_ID   = :d_curr_pgm_name
              AND SESSION_ID = :nd_session_id
              AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 9;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID=:b0 and SESSION_I\
D=:b1) and PGM_DATE=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )87;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
   
    fetch_param();

    open_files();

    fetch_legend_value();

    age_value();

    declare_cur();

   if(strcmp(nd_sumdet.arr,"D")==0) 
	process_det();
   else
    process_sum();

    get_header_dtls();

    //fetch_legend_value();

	 fprintf(fp,"%c&l1O",ESC); /* Set Landscape*/ 
 	 fprintf(fp, "%c(s12.5H", ESC);/* Reduce the font size*/
	 fprintf(fp,"%c&a4L",ESC); 	/* To Set the Left margin  		*/

	print_param();

   if(strcmp(nd_sumdet.arr,"D")==0) 
	print_header();
   else
    print_sum();
 	 
    print_end();

	 fprintf(fp,"%cE",ESC); /* To Reset the Printer */
 }

process_det()
{
 open_AGE_DET_CUR() ;
  		
 while(fetch_age_det_cur())
  {      
  if(nd_days1 !=0 ) 
    {
	
	/************************* Break Up By CITIZEN & EPISODE *******************/         
             
   if(strcmp(nd_br_episode_type.arr,"Y")==0 && strcmp(nd_br_citizen.arr,"Y")==0)
	  {
	                          /******---Day 1 -----****/
	 if(doc_date<=nd_days1) 
		{

		if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"I")==0)
		      {
			   if(strcmp(nd1_ni_pat_id.arr,d_patient_id.arr) != 0)
				    d1_ctz_epi_pat_cnt=	d1_ctz_epi_pat_cnt+1;
                 nd_d1_ctz_epi_outamt=nd_d1_ctz_epi_outamt+d_bil_out_amt;
			     nd_d1_ctz_epi_writeoff_amt=nd_d1_ctz_epi_writeoff_amt+d_bil_write_off_amt;
				 nd_d1_ctz_epi_tot_outamt = nd_d1_ctz_epi_tot_outamt+ d_bil_tot_ot_amt; 
			   	    strcpy(nd1_ni_pat_id.arr,d_patient_id.arr);
			  }
         
  else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"I")==0)
              {
			   if(strcmp(nd1_oi_pat_id.arr,d_patient_id.arr)!=0)
				  d1_nctz_epi_pat_cnt=d1_nctz_epi_pat_cnt+1;
			   nd_d1_nctz_epi_outamt=nd_d1_nctz_epi_outamt+d_bil_out_amt;
			   nd_d1_nctz_epi_writeoff_amt=nd_d1_nctz_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_nctz_epi_tot_outamt = nd_d1_nctz_epi_tot_outamt+ d_bil_tot_ot_amt; 
			   	  strcpy(nd1_oi_pat_id.arr,d_patient_id.arr);
              } 
  else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"O")==0)
              {
			   if(strcmp(nd1_no_pat_id.arr,d_patient_id.arr) != 0)
				  d1_ctz_epo_pat_cnt=	d1_ctz_epo_pat_cnt+1;
               nd_d1_ctz_epo_outamt=nd_d1_ctz_epo_outamt+d_bil_out_amt;
			   nd_d1_ctz_epo_writeoff_amt=nd_d1_ctz_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_ctz_epo_tot_outamt = nd_d1_ctz_epo_tot_outamt+ d_bil_tot_ot_amt; 
               	  strcpy(nd1_no_pat_id.arr,d_patient_id.arr);
			  }
  else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"O")==0)
              {
			   if(strcmp(nd1_oo_pat_id.arr,d_patient_id.arr) != 0)
				  d1_nctz_epo_pat_cnt=d1_nctz_epo_pat_cnt+1;
			   nd_d1_nctz_epo_outamt=nd_d1_nctz_epo_outamt+d_bil_out_amt;
			   nd_d1_nctz_epo_writeoff_amt=nd_d1_nctz_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_nctz_epo_tot_outamt = nd_d1_nctz_epo_tot_outamt+ d_bil_tot_ot_amt; 
			   	  strcpy(nd1_oo_pat_id.arr,d_patient_id.arr);
               } 

  else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"D")==0)
               {
				if(strcmp(nd1_nd_pat_id.arr,d_patient_id.arr) != 0)
				  d1_ctz_epd_pat_cnt=	d1_ctz_epd_pat_cnt+1;
               nd_d1_ctz_epd_outamt=nd_d1_ctz_epd_outamt+d_bil_out_amt;
			   nd_d1_ctz_epd_writeoff_amt=nd_d1_ctz_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_ctz_epd_tot_outamt = nd_d1_ctz_epd_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd1_nd_pat_id.arr,d_patient_id.arr);
               }
  else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"D")==0)
               {
				if(strcmp(d_patient_id.arr,nd1_od_pat_id.arr)!=0)
				  d1_nctz_epd_pat_cnt=d1_nctz_epd_pat_cnt+1;
			   nd_d1_nctz_epd_outamt=nd_d1_nctz_epd_outamt+d_bil_out_amt;
			   nd_d1_nctz_epd_writeoff_amt=nd_d1_nctz_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_nctz_epd_tot_outamt = nd_d1_nctz_epd_tot_outamt+ d_bil_tot_ot_amt; 
			   	strcpy(nd1_od_pat_id.arr,d_patient_id.arr);
               } 
   
  else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"E")==0)
               {
				if(strcmp(d_patient_id.arr,nd1_ne_pat_id.arr)!=0)
				  d1_ctz_epe_pat_cnt=	d1_ctz_epe_pat_cnt+1;
               nd_d1_ctz_epe_outamt=nd_d1_ctz_epe_outamt+d_bil_out_amt;
			   nd_d1_ctz_epe_writeoff_amt=nd_d1_ctz_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_ctz_epe_tot_outamt = nd_d1_ctz_epe_tot_outamt+ d_bil_tot_ot_amt; 
			    	strcpy(nd1_ne_pat_id.arr,d_patient_id.arr);
               }
  else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"E")==0)
               {
				if(strcmp(d_patient_id.arr,nd1_oe_pat_id.arr)!=0)
				    d1_nctz_epe_pat_cnt=d1_nctz_epe_pat_cnt+1;
			   nd_d1_nctz_epe_outamt=nd_d1_nctz_epe_outamt+d_bil_out_amt;
			   nd_d1_nctz_epe_writeoff_amt=nd_d1_nctz_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_nctz_epe_tot_outamt = nd_d1_nctz_epe_tot_outamt+ d_bil_tot_ot_amt; 
			   	   strcpy(nd1_oe_pat_id.arr,d_patient_id.arr);
               } 

       	else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"R")==0)
               {
				if(strcmp(d_patient_id.arr,nd1_nr_pat_id.arr)!=0)
				  d1_ctz_epr_pat_cnt=	d1_ctz_epr_pat_cnt+1;
               nd_d1_ctz_epr_outamt=nd_d1_ctz_epr_outamt+d_bil_out_amt;
			   nd_d1_ctz_epr_writeoff_amt=nd_d1_ctz_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_ctz_epr_tot_outamt = nd_d1_ctz_epr_tot_outamt+ d_bil_tot_ot_amt; 
			    	strcpy(nd1_nr_pat_id.arr,d_patient_id.arr);
               }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"R")==0)
                {
				  if(strcmp(d_patient_id.arr,nd1_or_pat_id.arr)!=0)
				  d1_nctz_epr_pat_cnt=d1_nctz_epr_pat_cnt+1;
			   nd_d1_nctz_epr_outamt=nd_d1_nctz_epr_outamt+d_bil_out_amt;
			   nd_d1_nctz_epr_writeoff_amt=nd_d1_nctz_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_nctz_epr_tot_outamt = nd_d1_nctz_epr_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd1_or_pat_id.arr,d_patient_id.arr);
                }    

	  }

							 /******------Day 2 ------****/

 else if (((doc_date >= nd_days1+1) && (doc_date <= nd_days2))|| ((doc_date >= nd_days1+1) && (nd_days2 == 0 )))
		 {
		if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"I")==0)
			{
			 if(strcmp(d_patient_id.arr,nd2_ni_pat_id.arr)!=0)
					d2_ctz_epi_pat_cnt=	d2_ctz_epi_pat_cnt+1;
				 nd_d2_ctz_epi_outamt=nd_d2_ctz_epi_outamt+d_bil_out_amt;
				 nd_d2_ctz_epi_writeoff_amt=nd_d2_ctz_epi_writeoff_amt+d_bil_write_off_amt;
				 nd_d2_ctz_epi_tot_outamt = nd_d2_ctz_epi_tot_outamt+ d_bil_tot_ot_amt; 
					strcpy(nd2_ni_pat_id.arr,d_patient_id.arr);
			}

	    else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"I")==0)
            {
			 if(strcmp(d_patient_id.arr,nd2_oi_pat_id.arr)!=0)
				  d2_nctz_epi_pat_cnt=d2_nctz_epi_pat_cnt+1;
			   nd_d2_nctz_epi_outamt=nd_d2_nctz_epi_outamt+d_bil_out_amt;
			   nd_d2_nctz_epi_writeoff_amt=nd_d2_nctz_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_nctz_epi_tot_outamt = nd_d2_nctz_epi_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd2_oi_pat_id.arr,d_patient_id.arr);
            } 
        else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"O")==0)
            {
			 if(strcmp(d_patient_id.arr,nd2_no_pat_id.arr)!=0)
				  d2_ctz_epo_pat_cnt=d2_ctz_epo_pat_cnt+1;
               nd_d2_ctz_epo_outamt=nd_d2_ctz_epo_outamt+d_bil_out_amt;
			   nd_d2_ctz_epo_writeoff_amt=nd_d2_ctz_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_ctz_epo_tot_outamt = nd_d2_ctz_epo_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd2_no_pat_id.arr,d_patient_id.arr);
            }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"O")==0)
            {
			 if(strcmp(d_patient_id.arr,nd2_oo_pat_id.arr)!=0)
				  d2_nctz_epo_pat_cnt=d2_nctz_epo_pat_cnt+1;
			   nd_d2_nctz_epo_outamt=nd_d2_nctz_epo_outamt+d_bil_out_amt;
			   nd_d2_nctz_epo_writeoff_amt=nd_d2_nctz_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_nctz_epo_tot_outamt = nd_d2_nctz_epo_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd2_oo_pat_id.arr,d_patient_id.arr);
            } 

		else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"D")==0)
            {
			 if(strcmp(d_patient_id.arr,nd2_nd_pat_id.arr)!=0)
				  d2_ctz_epd_pat_cnt=d2_ctz_epd_pat_cnt+1;
			   nd_d2_ctz_epd_outamt=nd_d2_ctz_epd_outamt+d_bil_out_amt;
			   nd_d2_ctz_epd_writeoff_amt=nd_d2_ctz_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_ctz_epd_tot_outamt = nd_d2_ctz_epd_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd2_nd_pat_id.arr,d_patient_id.arr);
            }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"D")==0)
            {
			 if(strcmp(d_patient_id.arr,nd2_od_pat_id.arr)!=0)
				  d2_nctz_epd_pat_cnt=d2_nctz_epd_pat_cnt+1;
			   nd_d2_nctz_epd_outamt=nd_d2_nctz_epd_outamt+d_bil_out_amt;
			   nd_d2_nctz_epd_writeoff_amt=nd_d2_nctz_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_nctz_epd_tot_outamt = nd_d2_nctz_epd_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd2_od_pat_id.arr,d_patient_id.arr);
            } 
   
		else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"E")==0)
            {
			 if(strcmp(d_patient_id.arr,nd2_ne_pat_id.arr)!=0)
				  d2_ctz_epe_pat_cnt=d2_ctz_epe_pat_cnt+1;
               nd_d2_ctz_epe_outamt=nd_d2_ctz_epe_outamt+d_bil_out_amt;
			   nd_d2_ctz_epe_writeoff_amt=nd_d2_ctz_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_ctz_epe_tot_outamt = nd_d2_ctz_epe_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd2_ne_pat_id.arr,d_patient_id.arr);
             }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"E")==0)
             {
			  if(strcmp(d_patient_id.arr,nd2_oe_pat_id.arr)!=0)
				  d2_nctz_epe_pat_cnt=d2_nctz_epe_pat_cnt+1;
			   nd_d2_nctz_epe_outamt=nd_d2_nctz_epe_outamt+d_bil_out_amt;
			   nd_d2_nctz_epe_writeoff_amt=nd_d2_nctz_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_nctz_epe_tot_outamt = nd_d2_nctz_epe_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd2_oe_pat_id.arr,d_patient_id.arr);
             } 

       	else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"R")==0)
                {
				if(strcmp(d_patient_id.arr,nd2_nr_pat_id.arr)!=0)
				    d2_ctz_epr_pat_cnt=d2_ctz_epr_pat_cnt+1;
               nd_d2_ctz_epr_outamt=nd_d2_ctz_epr_outamt+d_bil_out_amt;
			   nd_d2_ctz_epr_writeoff_amt=nd_d2_ctz_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_ctz_epr_tot_outamt = nd_d2_ctz_epr_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd2_nr_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"R")==0)
                {
				if(strcmp(d_patient_id.arr,nd2_or_pat_id.arr)!=0)
				    d2_nctz_epr_pat_cnt=d2_nctz_epr_pat_cnt+1;
			   nd_d2_nctz_epr_outamt=nd_d2_nctz_epr_outamt+d_bil_out_amt;
			   nd_d2_nctz_epr_writeoff_amt=nd_d2_nctz_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_nctz_epr_tot_outamt = nd_d2_nctz_epr_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd2_or_pat_id.arr,d_patient_id.arr);
                }    

         }

     /******------------------------Day 3 ------------------------****/

        
  else if (((doc_date >= nd_days2+1) && (doc_date <= nd_days3)) ||((doc_date >= nd_days2+1) && (nd_days3 == 0) && (nd_days2 != 0)))
		{
		if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"I")==0)
		      {
			  if(strcmp(d_patient_id.arr,nd3_ni_pat_id.arr)!=0)
				    d3_ctz_epi_pat_cnt=d3_ctz_epi_pat_cnt+1;
               nd_d3_ctz_epi_outamt=nd_d3_ctz_epi_outamt+d_bil_out_amt;
			   nd_d3_ctz_epi_writeoff_amt=nd_d3_ctz_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_ctz_epi_tot_outamt = nd_d3_ctz_epi_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd3_ni_pat_id.arr,d_patient_id.arr);
			  }
         
	    else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"I")==0)
                {
				  if(strcmp(d_patient_id.arr,nd3_oi_pat_id.arr)!=0)
				    d3_nctz_epi_pat_cnt=d3_nctz_epi_pat_cnt+1;
			   nd_d3_nctz_epi_outamt=nd_d3_nctz_epi_outamt+d_bil_out_amt;
			   nd_d3_nctz_epi_writeoff_amt=nd_d3_nctz_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_nctz_epi_tot_outamt = nd_d3_nctz_epi_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd3_oi_pat_id.arr,d_patient_id.arr);
                } 
        else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"O")==0)
                {
				  if(strcmp(d_patient_id.arr,nd3_no_pat_id.arr)!=0)
				    d3_ctz_epo_pat_cnt=d3_ctz_epo_pat_cnt+1;
               nd_d3_ctz_epo_outamt=nd_d3_ctz_epo_outamt+d_bil_out_amt;
			   nd_d3_ctz_epo_writeoff_amt=nd_d3_ctz_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_ctz_epo_tot_outamt = nd_d3_ctz_epo_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd3_no_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"O")==0)
                {
				 if(strcmp(d_patient_id.arr,nd3_oo_pat_id.arr)!=0)
				    d3_nctz_epo_pat_cnt=d3_nctz_epo_pat_cnt+1;
			   nd_d3_nctz_epo_outamt=nd_d3_nctz_epo_outamt+d_bil_out_amt;
			   nd_d3_nctz_epo_writeoff_amt=nd_d3_nctz_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_nctz_epo_tot_outamt = nd_d3_nctz_epo_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd3_oo_pat_id.arr,d_patient_id.arr);
                } 

		else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"D")==0)
                {
				  if(strcmp(d_patient_id.arr,nd3_nd_pat_id.arr)!=0)
				    d3_ctz_epd_pat_cnt=d3_ctz_epd_pat_cnt+1;
               nd_d3_ctz_epd_outamt=nd_d3_ctz_epd_outamt+d_bil_out_amt;
			   nd_d3_ctz_epd_writeoff_amt=nd_d3_ctz_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_ctz_epd_tot_outamt = nd_d3_ctz_epd_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd3_nd_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"D")==0)
                {
				  if(strcmp(d_patient_id.arr,nd3_od_pat_id.arr)!=0)
				    d3_nctz_epd_pat_cnt=d3_nctz_epd_pat_cnt+1;
			   nd_d3_nctz_epd_outamt=nd_d3_nctz_epd_outamt+d_bil_out_amt;
			   nd_d3_nctz_epd_writeoff_amt=nd_d3_nctz_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_nctz_epd_tot_outamt = nd_d3_nctz_epd_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd3_od_pat_id.arr,d_patient_id.arr);
                } 
   
		else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"E")==0)
                {
				  if(strcmp(d_patient_id.arr,nd3_ne_pat_id.arr)!=0)
				    d3_ctz_epe_pat_cnt=d3_ctz_epe_pat_cnt+1;
               nd_d3_ctz_epe_outamt=nd_d3_ctz_epe_outamt+d_bil_out_amt;
			   nd_d3_ctz_epe_writeoff_amt=nd_d3_ctz_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_ctz_epe_tot_outamt = nd_d3_ctz_epe_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd3_ne_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"E")==0)
                {
				  if(strcmp(d_patient_id.arr,nd3_oe_pat_id.arr)!=0)
				    d3_nctz_epe_pat_cnt=d3_nctz_epe_pat_cnt+1;
			   nd_d3_nctz_epe_outamt=nd_d3_nctz_epe_outamt+d_bil_out_amt;
			   nd_d3_nctz_epe_writeoff_amt=nd_d3_nctz_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_nctz_epe_tot_outamt = nd_d3_nctz_epe_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd3_oe_pat_id.arr,d_patient_id.arr);
                } 

       	else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"R")==0)
                {
				  if(strcmp(d_patient_id.arr,nd3_nr_pat_id.arr)!=0)
				    d3_ctz_epr_pat_cnt=d3_ctz_epr_pat_cnt+1;
               nd_d3_ctz_epr_outamt=nd_d3_ctz_epr_outamt+d_bil_out_amt;
			   nd_d3_ctz_epr_writeoff_amt=nd_d3_ctz_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_ctz_epr_tot_outamt = nd_d3_ctz_epr_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd3_nr_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"R")==0)
                {
				  if(strcmp(d_patient_id.arr,nd3_or_pat_id.arr)!=0)
				    d3_nctz_epr_pat_cnt=d3_nctz_epr_pat_cnt+1;
			   nd_d3_nctz_epr_outamt=nd_d3_nctz_epr_outamt+d_bil_out_amt;
			   nd_d3_nctz_epr_writeoff_amt=nd_d3_nctz_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_nctz_epr_tot_outamt = nd_d3_nctz_epr_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd3_or_pat_id.arr,d_patient_id.arr);
                }    

         }

 /******------------------------Day 4 ------------------------****/
 
 else if (((doc_date >= nd_days3+1) && (doc_date <= nd_days4)) || ((doc_date >= nd_days3+1) && (nd_days4 == 0) && (nd_days3 != 0)))
		{
		if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"I")==0)
		      {
			    if(strcmp(d_patient_id.arr,nd4_ni_pat_id.arr)!=0)
				    d4_ctz_epi_pat_cnt=d4_ctz_epi_pat_cnt+1;
               nd_d4_ctz_epi_outamt=nd_d4_ctz_epi_outamt+d_bil_out_amt;
			   nd_d4_ctz_epi_writeoff_amt=nd_d4_ctz_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_ctz_epi_tot_outamt = nd_d4_ctz_epi_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd4_ni_pat_id.arr,d_patient_id.arr);
			  }
         
	    else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"I")==0)
                {
				if(strcmp(d_patient_id.arr,nd4_oi_pat_id.arr)!=0)
				    d4_nctz_epi_pat_cnt=d4_nctz_epi_pat_cnt+1;
			   nd_d4_nctz_epi_outamt=nd_d4_nctz_epi_outamt+d_bil_out_amt;
			   nd_d4_nctz_epi_writeoff_amt=nd_d4_nctz_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_nctz_epi_tot_outamt = nd_d4_nctz_epi_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd4_oi_pat_id.arr,d_patient_id.arr);
                } 
        else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"O")==0)
                {
			  if(strcmp(d_patient_id.arr,nd4_no_pat_id.arr)!=0)
				  d4_ctz_epo_pat_cnt=d4_ctz_epo_pat_cnt+1;
               nd_d4_ctz_epo_outamt=nd_d4_ctz_epo_outamt+d_bil_out_amt;
			   nd_d4_ctz_epo_writeoff_amt=nd_d4_ctz_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_ctz_epo_tot_outamt = nd_d4_ctz_epo_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd4_no_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"O")==0)
                {
			   if(strcmp(d_patient_id.arr,nd4_oo_pat_id.arr)!=0)
				    d4_nctz_epo_pat_cnt=d4_nctz_epo_pat_cnt+1;
			   nd_d4_nctz_epo_outamt=nd_d4_nctz_epo_outamt+d_bil_out_amt;
			   nd_d4_nctz_epo_writeoff_amt=nd_d4_nctz_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_nctz_epo_tot_outamt = nd_d4_nctz_epo_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd4_oo_pat_id.arr,d_patient_id.arr);
                } 

		else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"D")==0)
                {
			if(strcmp(d_patient_id.arr,nd4_nd_pat_id.arr)!=0)
				d4_ctz_epd_pat_cnt=d4_ctz_epd_pat_cnt+1;
               nd_d4_ctz_epd_outamt=nd_d4_ctz_epd_outamt+d_bil_out_amt;
			   nd_d4_ctz_epd_writeoff_amt=nd_d4_ctz_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_ctz_epd_tot_outamt = nd_d4_ctz_epd_tot_outamt+ d_bil_tot_ot_amt; 
			        strcpy(nd4_nd_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"D")==0)
                {
			if(strcmp(d_patient_id.arr,nd4_od_pat_id.arr)!=0)
				 d4_nctz_epd_pat_cnt=d4_nctz_epd_pat_cnt+1;
			   nd_d4_nctz_epd_outamt=nd_d4_nctz_epd_outamt+d_bil_out_amt;
			   nd_d4_nctz_epd_writeoff_amt=nd_d4_nctz_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_nctz_epd_tot_outamt = nd_d4_nctz_epd_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd4_od_pat_id.arr,d_patient_id.arr);
                } 
   
		else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"E")==0)
                {
			if(strcmp(d_patient_id.arr,nd4_ne_pat_id.arr)!=0)
				    d4_ctz_epe_pat_cnt=d4_ctz_epe_pat_cnt+1;
               nd_d4_ctz_epe_outamt=nd_d4_ctz_epe_outamt+d_bil_out_amt;
			   nd_d4_ctz_epe_writeoff_amt=nd_d4_ctz_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_ctz_epe_tot_outamt = nd_d4_ctz_epe_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd4_ne_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"E")==0)
                {
				if(strcmp(d_patient_id.arr,nd4_oe_pat_id.arr)!=0)
				d4_nctz_epe_pat_cnt=d4_nctz_epe_pat_cnt+1;
			   nd_d4_nctz_epe_outamt=nd_d4_nctz_epe_outamt+d_bil_out_amt;
			   nd_d4_nctz_epe_writeoff_amt=nd_d4_nctz_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_nctz_epe_tot_outamt = nd_d4_nctz_epe_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd4_oe_pat_id.arr,d_patient_id.arr);
                } 

       	else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"R")==0)
                {
			 if(strcmp(d_patient_id.arr,nd4_nr_pat_id.arr)!=0)
				 d4_ctz_epr_pat_cnt=d4_ctz_epr_pat_cnt+1;
               nd_d4_ctz_epr_outamt=nd_d4_ctz_epr_outamt+d_bil_out_amt;
			   nd_d4_ctz_epr_writeoff_amt=nd_d4_ctz_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_ctz_epr_tot_outamt = nd_d4_ctz_epr_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd4_nr_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"R")==0)
                {
					if(strcmp(d_patient_id.arr,nd4_or_pat_id.arr)!=0)
				    d4_nctz_epr_pat_cnt=d4_nctz_epr_pat_cnt+1;
			   nd_d4_nctz_epr_outamt=nd_d4_nctz_epr_outamt+d_bil_out_amt;
			   nd_d4_nctz_epr_writeoff_amt=nd_d4_nctz_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_nctz_epr_tot_outamt = nd_d4_nctz_epr_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd4_or_pat_id.arr,d_patient_id.arr);
                }    

         }

 /******------------------------Day 5 ------------------------****/

  else if (((doc_date >= nd_days4+1) && (doc_date <= nd_days5)) || ((doc_date >= nd_days4+1) && (nd_days5 == 0) && (nd_days4 != 0)))
		{
		if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"I")==0)
		      {
			  	if(strcmp(d_patient_id.arr,nd5_ni_pat_id.arr)!=0)
				 d5_ctz_epi_pat_cnt=d5_ctz_epi_pat_cnt+1;
               nd_d5_ctz_epi_outamt=nd_d5_ctz_epi_outamt+d_bil_out_amt;
			   nd_d5_ctz_epi_writeoff_amt=nd_d5_ctz_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_ctz_epi_tot_outamt = nd_d5_ctz_epi_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd5_ni_pat_id.arr,d_patient_id.arr);
			  }
         
	    else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"I")==0)
                {
				if(strcmp(d_patient_id.arr,nd5_oi_pat_id.arr)!=0)
				 d5_nctz_epi_pat_cnt=d5_nctz_epi_pat_cnt+1;
			   nd_d5_nctz_epi_outamt=nd_d5_nctz_epi_outamt+d_bil_out_amt;
			   nd_d5_nctz_epi_writeoff_amt=nd_d5_nctz_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_nctz_epi_tot_outamt = nd_d5_nctz_epi_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd5_oi_pat_id.arr,d_patient_id.arr);
                } 
        else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"O")==0)
                {
				if(strcmp(d_patient_id.arr,nd5_no_pat_id.arr)!=0)
				 d5_ctz_epo_pat_cnt=d5_ctz_epo_pat_cnt+1;
               nd_d5_ctz_epo_outamt=nd_d5_ctz_epo_outamt+d_bil_out_amt;
			   nd_d5_ctz_epo_writeoff_amt=nd_d5_ctz_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_ctz_epo_tot_outamt = nd_d5_ctz_epo_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd5_no_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"O")==0)
                {
				if(strcmp(d_patient_id.arr,nd5_oo_pat_id.arr)!=0)
				 d5_nctz_epo_pat_cnt=d5_nctz_epo_pat_cnt+1;
			   nd_d5_nctz_epo_outamt=nd_d5_nctz_epo_outamt+d_bil_out_amt;
			   nd_d5_nctz_epo_writeoff_amt=nd_d5_nctz_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_nctz_epo_tot_outamt = nd_d5_nctz_epo_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd5_oo_pat_id.arr,d_patient_id.arr);
                } 

		else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"D")==0)
                {
				if(strcmp(d_patient_id.arr,nd5_nd_pat_id.arr)!=0)
				 d5_ctz_epd_pat_cnt=d5_ctz_epd_pat_cnt+1;
               nd_d5_ctz_epd_outamt=nd_d5_ctz_epd_outamt+d_bil_out_amt;
			   nd_d5_ctz_epd_writeoff_amt=nd_d5_ctz_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_ctz_epd_tot_outamt = nd_d5_ctz_epd_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd5_nd_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"D")==0)
                {
				if(strcmp(d_patient_id.arr,nd5_od_pat_id.arr)!=0)
				 d5_nctz_epd_pat_cnt=d5_nctz_epd_pat_cnt+1;
			   nd_d5_nctz_epd_outamt=nd_d5_nctz_epd_outamt+d_bil_out_amt;
			   nd_d5_nctz_epd_writeoff_amt=nd_d5_nctz_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_nctz_epd_tot_outamt = nd_d5_nctz_epd_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd5_od_pat_id.arr,d_patient_id.arr);
                } 
   
		else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"E")==0)
                {
				if(strcmp(d_patient_id.arr,nd5_ne_pat_id.arr)!=0)
				 d5_ctz_epe_pat_cnt=d5_ctz_epe_pat_cnt+1;
               nd_d5_ctz_epe_outamt=nd_d5_ctz_epe_outamt+d_bil_out_amt;
			   nd_d5_ctz_epe_writeoff_amt=nd_d5_ctz_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_ctz_epe_tot_outamt = nd_d5_ctz_epe_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd5_ne_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"E")==0)
                {
				if(strcmp(d_patient_id.arr,nd5_oe_pat_id.arr)!=0)
				 d5_nctz_epe_pat_cnt=d5_nctz_epe_pat_cnt+1;
			   nd_d5_nctz_epe_outamt=nd_d5_nctz_epe_outamt+d_bil_out_amt;
			   nd_d5_nctz_epe_writeoff_amt=nd_d5_nctz_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_nctz_epe_tot_outamt = nd_d5_nctz_epe_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd5_oe_pat_id.arr,d_patient_id.arr);
                } 

       	else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"R")==0)
                {
				if(strcmp(d_patient_id.arr,nd5_nr_pat_id.arr)!=0)
				 d5_ctz_epr_pat_cnt=d5_ctz_epr_pat_cnt+1;
               nd_d5_ctz_epr_outamt=nd_d5_ctz_epr_outamt+d_bil_out_amt;
			   nd_d5_ctz_epr_writeoff_amt=nd_d5_ctz_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_ctz_epr_tot_outamt = nd_d5_ctz_epr_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd5_nr_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"R")==0)
                {
				if(strcmp(d_patient_id.arr,nd5_or_pat_id.arr)!=0)
				 d5_nctz_epr_pat_cnt=d5_nctz_epr_pat_cnt+1;
			   nd_d5_nctz_epr_outamt=nd_d5_nctz_epr_outamt+d_bil_out_amt;
			   nd_d5_nctz_epr_writeoff_amt=nd_d5_nctz_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_nctz_epr_tot_outamt = nd_d5_nctz_epr_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd5_or_pat_id.arr,d_patient_id.arr);
                }    

         }

 /******------------------------Day 6 ------------------------****/

  else if ((doc_date >= nd_days5+1) || ((doc_date >= nd_days5+1) && (nd_days5 != 0)))
		{
		if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"I")==0)
		      {
			  if(strcmp(d_patient_id.arr,nd6_ni_pat_id.arr)!=0)
				 d6_ctz_epi_pat_cnt=d6_ctz_epi_pat_cnt+1;
               nd_d6_ctz_epi_outamt=nd_d6_ctz_epi_outamt+d_bil_out_amt;
			   nd_d6_ctz_epi_writeoff_amt=nd_d6_ctz_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_ctz_epi_tot_outamt = nd_d6_ctz_epi_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd6_ni_pat_id.arr,d_patient_id.arr);
			  }
         
	    else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"I")==0)
                {
					  if(strcmp(d_patient_id.arr,nd6_oi_pat_id.arr)!=0)
				 d6_nctz_epi_pat_cnt=d6_nctz_epi_pat_cnt+1;
			   nd_d6_nctz_epi_outamt=nd_d6_nctz_epi_outamt+d_bil_out_amt;
			   nd_d6_nctz_epi_writeoff_amt=nd_d6_nctz_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_nctz_epi_tot_outamt = nd_d6_nctz_epi_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd6_oi_pat_id.arr,d_patient_id.arr);
                } 
        else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"O")==0)
                {
					  if(strcmp(d_patient_id.arr,nd6_no_pat_id.arr)!=0)
				 d6_ctz_epo_pat_cnt=d6_ctz_epo_pat_cnt+1;
               nd_d6_ctz_epo_outamt=nd_d6_ctz_epo_outamt+d_bil_out_amt;
			   nd_d6_ctz_epo_writeoff_amt=nd_d6_ctz_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_ctz_epo_tot_outamt = nd_d6_ctz_epo_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd6_no_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"O")==0)
                {
					  if(strcmp(d_patient_id.arr,nd6_oo_pat_id.arr)!=0)
				 d6_nctz_epo_pat_cnt=d6_nctz_epo_pat_cnt+1;
			   nd_d6_nctz_epo_outamt=nd_d6_nctz_epo_outamt+d_bil_out_amt;
			   nd_d6_nctz_epo_writeoff_amt=nd_d6_nctz_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_nctz_epo_tot_outamt = nd_d6_nctz_epo_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd6_oo_pat_id.arr,d_patient_id.arr);
                } 

		else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"D")==0)
                {
					  if(strcmp(d_patient_id.arr,nd6_nd_pat_id.arr)!=0)
				 d6_ctz_epd_pat_cnt=d6_ctz_epd_pat_cnt+1;
               nd_d6_ctz_epd_outamt=nd_d6_ctz_epd_outamt+d_bil_out_amt;
			   nd_d6_ctz_epd_writeoff_amt=nd_d6_ctz_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_ctz_epd_tot_outamt = nd_d6_ctz_epd_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd6_nd_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"D")==0)
                {
					  if(strcmp(d_patient_id.arr,nd6_od_pat_id.arr)!=0)
				 d6_nctz_epd_pat_cnt=d6_nctz_epd_pat_cnt+1;
			   nd_d6_nctz_epd_outamt=nd_d6_nctz_epd_outamt+d_bil_out_amt;
			   nd_d6_nctz_epd_writeoff_amt=nd_d6_nctz_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_nctz_epd_tot_outamt = nd_d6_nctz_epd_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd6_od_pat_id.arr,d_patient_id.arr);
                } 
   
		else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"E")==0)
                {
					  if(strcmp(d_patient_id.arr,nd6_ne_pat_id.arr)!=0)
				 d6_ctz_epe_pat_cnt=d6_ctz_epe_pat_cnt+1;
               nd_d6_ctz_epe_outamt=nd_d6_ctz_epe_outamt+d_bil_out_amt;
			   nd_d6_ctz_epe_writeoff_amt=nd_d6_ctz_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_ctz_epe_tot_outamt = nd_d6_ctz_epe_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd6_ne_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"E")==0)
                {
					  if(strcmp(d_patient_id.arr,nd6_oe_pat_id.arr)!=0)
				 d6_nctz_epe_pat_cnt=d6_nctz_epe_pat_cnt+1;
			   nd_d6_nctz_epe_outamt=nd_d6_nctz_epe_outamt+d_bil_out_amt;
			   nd_d6_nctz_epe_writeoff_amt=nd_d6_nctz_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_nctz_epe_tot_outamt = nd_d6_nctz_epe_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd6_oe_pat_id.arr,d_patient_id.arr);
                } 

       	else if(strcmp(d_citizen.arr,"NATIONALS")==0 && strcmp(d_episode_type.arr,"R")==0)
                {
					  if(strcmp(d_patient_id.arr,nd6_nr_pat_id.arr)!=0)
				 d6_ctz_epr_pat_cnt=d6_ctz_epr_pat_cnt+1;
               nd_d6_ctz_epr_outamt=nd_d6_ctz_epr_outamt+d_bil_out_amt;
			   nd_d6_ctz_epr_writeoff_amt=nd_d6_ctz_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_ctz_epr_tot_outamt = nd_d6_ctz_epr_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd6_nr_pat_id.arr,d_patient_id.arr);
                }
        else if(strcmp(d_citizen.arr,"OTHERS")==0 && strcmp(d_episode_type.arr,"R")==0)
                {
					  if(strcmp(d_patient_id.arr,nd6_or_pat_id.arr)!=0)
				 d6_nctz_epr_pat_cnt=d6_nctz_epr_pat_cnt+1;
			   nd_d6_nctz_epr_outamt=nd_d6_nctz_epr_outamt+d_bil_out_amt;
			   nd_d6_nctz_epr_writeoff_amt=nd_d6_nctz_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_nctz_epr_tot_outamt = nd_d6_nctz_epr_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd6_or_pat_id.arr,d_patient_id.arr);
                }    

         }
	
    }
  /*************************END OF Break Up By CITIZEN&EPISODE*******************/

 
  /*************************   Break Up By CITIZEN   *******************/


else if(strcmp(nd_br_episode_type.arr,"N")==0 && strcmp(nd_br_citizen.arr,"Y")==0)
        {

         /***---------------  day 1 ----------------***/

	  if(doc_date<=nd_days1) 
		  { 
            if(strcmp(d_citizen.arr,"NATIONALS")==0)
			    {	
				  if(strcmp(d_patient_id.arr,nd1_n_pat_id.arr)!=0)
				    d1_pat_cnt=	d1_pat_cnt+1;		  
		          nd_cd1_rev_outamt = nd_cd1_rev_outamt+d_bil_out_amt;
				  nd_cd1_writeoff_amt =nd_cd1_writeoff_amt+d_bil_write_off_amt;
				  nd_cd1_tot_outamt = nd_cd1_tot_outamt+d_bil_tot_ot_amt	;
				   strcpy(nd1_n_pat_id.arr,d_patient_id.arr);
				  
				  }
               else
			     {
				 if(strcmp(d_patient_id.arr,nd1_o_pat_id.arr)!=0)
				    nd1_pat_cnt=nd1_pat_cnt+1;
				  nd_ncd1_rev_outamt = nd_ncd1_rev_outamt+d_bil_out_amt;
				  nd_ncd1_writeoff_amt =nd_ncd1_writeoff_amt+d_bil_write_off_amt;
				  nd_ncd1_tot_outamt = nd_ncd1_tot_outamt+d_bil_tot_ot_amt	;
				   strcpy(nd1_o_pat_id.arr,d_patient_id.arr);
                 } 

            }
   else if (((doc_date >= nd_days1+1) && (doc_date <= nd_days2))|| ((doc_date >= nd_days1+1) && (nd_days2 == 0) ))
		     {
                if(strcmp(d_citizen.arr,"NATIONALS")==0)
			     {
				 if(strcmp(d_patient_id.arr,nd2_n_pat_id.arr)!=0)
				    d2_pat_cnt=	d2_pat_cnt+1;				  
		          nd_cd2_rev_outamt = nd_cd2_rev_outamt+d_bil_out_amt;
				  nd_cd2_writeoff_amt =nd_cd2_writeoff_amt+d_bil_write_off_amt;
				  nd_cd2_tot_outamt = nd_cd2_tot_outamt+d_bil_tot_ot_amt	;
				   strcpy(nd2_n_pat_id.arr,d_patient_id.arr);
				  
				  }
               else
			     {
				 if(strcmp(d_patient_id.arr,nd2_o_pat_id.arr)!=0)
				    nd2_pat_cnt=	nd2_pat_cnt+1;
				  nd_ncd2_rev_outamt = nd_ncd2_rev_outamt+d_bil_out_amt;
				  nd_ncd2_writeoff_amt =nd_ncd2_writeoff_amt+d_bil_write_off_amt;
				  nd_ncd2_tot_outamt = nd_ncd2_tot_outamt+d_bil_tot_ot_amt	;
				   strcpy(nd2_o_pat_id.arr,d_patient_id.arr);
                 }            
              }
          
  else if (((doc_date >= nd_days2+1) && (doc_date <= nd_days3)) ||((doc_date >= nd_days2+1) && (nd_days3 == 0) && (nd_days2 != 0)))
             {
              if(strcmp(d_citizen.arr,"NATIONALS")==0)
			    {
				if(strcmp(d_patient_id.arr,nd3_n_pat_id.arr)!=0)
				    d3_pat_cnt=	d3_pat_cnt+1;				  
		          nd_cd3_rev_outamt = nd_cd3_rev_outamt+d_bil_out_amt;
				  nd_cd3_writeoff_amt =nd_cd3_writeoff_amt+d_bil_write_off_amt;
				  nd_cd3_tot_outamt = nd_cd3_tot_outamt+d_bil_tot_ot_amt	;
				   strcpy(nd3_n_pat_id.arr,d_patient_id.arr);
				  
				  }
               else
			     {
				 if(strcmp(d_patient_id.arr,nd3_o_pat_id.arr)!=0)
				    nd3_pat_cnt=nd3_pat_cnt+1;
				  nd_ncd3_rev_outamt = nd_ncd3_rev_outamt+d_bil_out_amt;
				  nd_ncd3_writeoff_amt = nd_ncd3_writeoff_amt+d_bil_write_off_amt;
				  nd_ncd3_tot_outamt = nd_ncd3_tot_outamt+d_bil_tot_ot_amt	;
				   strcpy(nd3_o_pat_id.arr,d_patient_id.arr);
                 }            
              }
      else if (((doc_date >= nd_days3+1) && (doc_date <= nd_days4)) || ((doc_date >= nd_days3+1) && (nd_days4 == 0) && (nd_days3 != 0)))
             {
              if(strcmp(d_citizen.arr,"NATIONALS")==0)
			    {
				if(strcmp(d_patient_id.arr,nd4_n_pat_id.arr)!=0)
				    d4_pat_cnt=	d4_pat_cnt+1;				  
		          nd_cd4_rev_outamt = nd_cd4_rev_outamt+d_bil_out_amt;
				  nd_cd4_writeoff_amt = nd_cd4_writeoff_amt+d_bil_write_off_amt;
				  nd_cd4_tot_outamt = nd_cd4_tot_outamt+d_bil_tot_ot_amt	;
				  	   strcpy(nd4_n_pat_id.arr,d_patient_id.arr);
				  }
               else
			     {
				 if(strcmp(d_patient_id.arr,nd4_o_pat_id.arr)!=0)
				    nd4_pat_cnt=	nd4_pat_cnt+1;
				  nd_ncd4_rev_outamt = nd_ncd4_rev_outamt+d_bil_out_amt;
				  nd_ncd4_writeoff_amt =nd_ncd4_writeoff_amt+d_bil_write_off_amt;
				  nd_ncd4_tot_outamt = nd_ncd4_tot_outamt+d_bil_tot_ot_amt	;
				 strcpy(nd4_o_pat_id.arr,d_patient_id.arr);
                 }            
              }

     else if (((doc_date >= nd_days4+1) && (doc_date <= nd_days5)) || ((doc_date >= nd_days4+1 )&& (nd_days5 == 0) && (nd_days4 != 0)))
             {
              if(strcmp(d_citizen.arr,"NATIONALS")==0)
			    {
				if(strcmp(d_patient_id.arr,nd5_n_pat_id.arr)!=0)
				    d5_pat_cnt=	d5_pat_cnt+1;				  
		          nd_cd5_rev_outamt = nd_cd5_rev_outamt+d_bil_out_amt;
				  nd_cd5_writeoff_amt = nd_cd5_writeoff_amt+d_bil_write_off_amt;
				  nd_cd5_tot_outamt = nd_cd5_tot_outamt+d_bil_tot_ot_amt	;
				   strcpy(nd5_n_pat_id.arr,d_patient_id.arr);
				  }
               else
			     {
				 if(strcmp(d_patient_id.arr,nd5_o_pat_id.arr)!=0)
				    nd5_pat_cnt=nd5_pat_cnt+1;
				  nd_ncd5_rev_outamt = nd_ncd5_rev_outamt+d_bil_out_amt;
				  nd_ncd5_writeoff_amt = nd_ncd5_writeoff_amt+d_bil_write_off_amt;
				  nd_ncd5_tot_outamt = nd_ncd5_tot_outamt+d_bil_tot_ot_amt	;
				    strcpy(nd5_o_pat_id.arr,d_patient_id.arr);
                 }            
              }
     else if ((doc_date >= nd_days5+1) || (doc_date >= nd_days5+1 && nd_days5 != 0))
		       {
              if(strcmp(d_citizen.arr,"NATIONALS")==0)
			    {
				if(strcmp(d_patient_id.arr,nd6_n_pat_id.arr)!=0)
				    d6_pat_cnt=	d6_pat_cnt+1;				  
		          nd_cd6_rev_outamt = nd_cd6_rev_outamt+d_bil_out_amt;
				  nd_cd6_writeoff_amt =nd_cd6_writeoff_amt+d_bil_write_off_amt;
				  nd_cd6_tot_outamt = nd_cd6_tot_outamt+d_bil_tot_ot_amt	;
				    strcpy(nd6_n_pat_id.arr,d_patient_id.arr);
				  }
               else
			     {
				 if(strcmp(d_patient_id.arr,nd6_o_pat_id.arr)!=0)
				    nd6_pat_cnt=nd6_pat_cnt+1;
				  nd_ncd6_rev_outamt = nd_ncd6_rev_outamt+d_bil_out_amt;
				  nd_ncd6_writeoff_amt =nd_ncd6_writeoff_amt+d_bil_write_off_amt;
				  nd_ncd6_tot_outamt = nd_ncd6_tot_outamt+d_bil_tot_ot_amt	;
				   strcpy(nd6_o_pat_id.arr,d_patient_id.arr);
                 }   
              }


           }

        

   /*************************  End Of  Break Up By CITIZEN   *******************/
            
   /*************************       Break Up By EPISODE      *******************/

           
  else if(strcmp(nd_br_episode_type.arr,"Y")==0 && strcmp(nd_br_citizen.arr,"N")==0)
         {

      if(doc_date<=nd_days1) 
		   {          
          		   
          if(strcmp(d_episode_type.arr,"I")==0)
		     {
			   if(strcmp(d_patient_id.arr,nd1_ip_pat_id.arr)!=0)
				    d1_epi_pat_cnt=	d1_epi_pat_cnt+1;
			   nd_d1_epi_outamt=nd_d1_epi_outamt+d_bil_out_amt;
			   nd_d1_epi_writeoff_amt=nd_d1_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_epi_tot_outamt = nd_d1_epi_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd1_ip_pat_id.arr,d_patient_id.arr);
             }   
          else if(strcmp(d_episode_type.arr,"O")==0)
		     {
			 if(strcmp(d_patient_id.arr,nd1_op_pat_id.arr)!=0)
				d1_epo_pat_cnt=	d1_epo_pat_cnt+1;
			   nd_d1_epo_outamt=nd_d1_epo_outamt+d_bil_out_amt;
			   nd_d1_epo_writeoff_amt=nd_d1_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_epo_tot_outamt = nd_d1_epo_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd1_op_pat_id.arr,d_patient_id.arr);
             }            
          else if(strcmp(d_episode_type.arr,"E")==0)
		     {
			  if(strcmp(d_patient_id.arr,nd1_em_pat_id.arr)!=0)
				    d1_epe_pat_cnt=	d1_epe_pat_cnt+1;
			   nd_d1_epe_outamt=nd_d1_epe_outamt+d_bil_out_amt;
			   nd_d1_epe_writeoff_amt=nd_d1_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_epe_tot_outamt = nd_d1_epe_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd1_em_pat_id.arr,d_patient_id.arr);
             }            
          else if(strcmp(d_episode_type.arr,"D")==0)
		     {
			   if(strcmp(d_patient_id.arr,nd1_dy_pat_id.arr)!=0)
				 d1_epd_pat_cnt=	d1_epd_pat_cnt+1;
			   nd_d1_epd_outamt=nd_d1_epd_outamt+d_bil_out_amt;
			   nd_d1_epd_writeoff_amt=nd_d1_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_epd_tot_outamt = nd_d1_epd_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd1_dy_pat_id.arr,d_patient_id.arr);
             } 
         else if(strcmp(d_episode_type.arr,"R")==0)
		     {
			 	if(strcmp(d_patient_id.arr,nd1_ex_pat_id.arr)!=0)
				    d1_epr_pat_cnt=	d1_epr_pat_cnt+1;
			   nd_d1_epr_outamt=nd_d1_epr_outamt+d_bil_out_amt;
			   nd_d1_epr_writeoff_amt=nd_d1_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_epr_tot_outamt = nd_d1_epr_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd1_ex_pat_id.arr,d_patient_id.arr);
             } 

          }
      //end of day1//

  else if (((doc_date >= nd_days1+1) && (doc_date <= nd_days2))|| ((doc_date >= nd_days1+1) && (nd_days2 == 0) ))
       {
   		   
          if(strcmp(d_episode_type.arr,"I")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd2_ip_pat_id.arr)!=0)
				    d2_epi_pat_cnt=	d2_epi_pat_cnt+1;
			   nd_d2_epi_outamt=nd_d2_epi_outamt+d_bil_out_amt;
			   nd_d2_epi_writeoff_amt=nd_d2_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_epi_tot_outamt = nd_d2_epi_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd2_ip_pat_id.arr,d_patient_id.arr);
             }   
          else if(strcmp(d_episode_type.arr,"O")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd2_op_pat_id.arr)!=0)
				    d2_epo_pat_cnt=	d2_epo_pat_cnt+1;
			   nd_d2_epo_outamt=nd_d2_epo_outamt+d_bil_out_amt;
			   nd_d2_epo_writeoff_amt=nd_d2_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_epo_tot_outamt = nd_d2_epo_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd2_op_pat_id.arr,d_patient_id.arr);
             }            
          else if(strcmp(d_episode_type.arr,"E")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd2_em_pat_id.arr)!=0)
				    d2_epe_pat_cnt=	d2_epe_pat_cnt+1;
			   nd_d2_epe_outamt=nd_d2_epe_outamt+d_bil_out_amt;
			   nd_d2_epe_writeoff_amt=nd_d2_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_epe_tot_outamt = nd_d2_epe_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd2_em_pat_id.arr,d_patient_id.arr);
             }            
          else if(strcmp(d_episode_type.arr,"D")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd2_dy_pat_id.arr)!=0)
				    d2_epd_pat_cnt=	d2_epd_pat_cnt+1;
			   nd_d2_epd_outamt=nd_d2_epd_outamt+d_bil_out_amt;
			   nd_d2_epd_writeoff_amt=nd_d2_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_epd_tot_outamt = nd_d2_epd_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd2_dy_pat_id.arr,d_patient_id.arr);
             } 
         else if(strcmp(d_episode_type.arr,"R")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd2_ex_pat_id.arr)!=0)
				    d2_epr_pat_cnt=	d2_epr_pat_cnt+1;
			   nd_d2_epr_outamt=nd_d2_epr_outamt+d_bil_out_amt;
			   nd_d2_epr_writeoff_amt=nd_d2_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_epr_tot_outamt = nd_d2_epr_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd2_ex_pat_id.arr,d_patient_id.arr);
             } 

          }

//end of day2

 else if (((doc_date >= nd_days2+1) && (doc_date <= nd_days3)) ||((doc_date >= nd_days2+1) && (nd_days3 == 0) && (nd_days2 != 0)))
       {
   		   
          if(strcmp(d_episode_type.arr,"I")==0)
		     {
			 	 if(strcmp(d_patient_id.arr,nd3_ip_pat_id.arr)!=0)
				 d3_epi_pat_cnt=d3_epi_pat_cnt+1;
			   nd_d3_epi_outamt=nd_d3_epi_outamt+d_bil_out_amt;
			   nd_d3_epi_writeoff_amt=nd_d3_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_epi_tot_outamt = nd_d3_epi_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd3_ip_pat_id.arr,d_patient_id.arr);
             }   
          else if(strcmp(d_episode_type.arr,"O")==0)
		     {
			 	 if(strcmp(d_patient_id.arr,nd3_op_pat_id.arr)!=0)
				   d3_epo_pat_cnt=	d3_epo_pat_cnt+1;
			   nd_d3_epo_outamt=nd_d3_epo_outamt+d_bil_out_amt;
			   nd_d3_epo_writeoff_amt=nd_d3_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_epo_tot_outamt = nd_d3_epo_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd3_op_pat_id.arr,d_patient_id.arr);
             }            
          else if(strcmp(d_episode_type.arr,"E")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd3_em_pat_id.arr)!=0)
				    d3_epe_pat_cnt=	d3_epe_pat_cnt+1;
			   nd_d3_epe_outamt=nd_d3_epe_outamt+d_bil_out_amt;
			   nd_d3_epe_writeoff_amt=nd_d3_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_epe_tot_outamt = nd_d3_epe_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd3_em_pat_id.arr,d_patient_id.arr);
             }            
          else if(strcmp(d_episode_type.arr,"D")==0)
		     {
			 	 if(strcmp(d_patient_id.arr,nd3_dy_pat_id.arr)!=0)
				  d3_epd_pat_cnt=d3_epd_pat_cnt+1;
			   nd_d3_epd_outamt=nd_d3_epd_outamt+d_bil_out_amt;
			   nd_d3_epd_writeoff_amt=nd_d3_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_epd_tot_outamt = nd_d3_epd_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd3_dy_pat_id.arr,d_patient_id.arr);
             } 
         else if(strcmp(d_episode_type.arr,"R")==0)
		     {
			 	 if(strcmp(d_patient_id.arr,nd3_ex_pat_id.arr)!=0)
				    d3_epr_pat_cnt=	d3_epr_pat_cnt+1;
			   nd_d3_epr_outamt=nd_d3_epr_outamt+d_bil_out_amt;
			   nd_d3_epr_writeoff_amt=nd_d3_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_epr_tot_outamt = nd_d3_epr_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd3_ex_pat_id.arr,d_patient_id.arr);
             } 

          }
//end of day3


else if (((doc_date >= nd_days3+1) && (doc_date <= nd_days4)) || ((doc_date >= nd_days3+1) && (nd_days4 == 0) && (nd_days3 != 0)))
       {
   		   
          if(strcmp(d_episode_type.arr,"I")==0)
		     {
			 	  if(strcmp(d_patient_id.arr,nd4_ip_pat_id.arr)!=0)
				    d4_epi_pat_cnt=	d4_epi_pat_cnt+1;
			   nd_d4_epi_outamt=nd_d4_epi_outamt+d_bil_out_amt;
			   nd_d4_epi_writeoff_amt=nd_d4_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_epi_tot_outamt = nd_d4_epi_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd4_ip_pat_id.arr,d_patient_id.arr);
             }   
          else if(strcmp(d_episode_type.arr,"O")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd4_op_pat_id.arr)!=0)
				    d4_epo_pat_cnt=	d4_epo_pat_cnt+1;
			   nd_d4_epo_outamt=nd_d4_epo_outamt+d_bil_out_amt;
			   nd_d4_epo_writeoff_amt=nd_d4_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_epo_tot_outamt = nd_d4_epo_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd4_op_pat_id.arr,d_patient_id.arr);
             }            
          else if(strcmp(d_episode_type.arr,"E")==0)
		     {
			 	 if(strcmp(d_patient_id.arr,nd4_em_pat_id.arr)!=0)
				   d4_epe_pat_cnt=	d4_epe_pat_cnt+1;
			   nd_d4_epe_outamt=nd_d4_epe_outamt+d_bil_out_amt;
			   nd_d4_epe_writeoff_amt=nd_d4_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_epe_tot_outamt = nd_d4_epe_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd4_em_pat_id.arr,d_patient_id.arr);
             }            
          else if(strcmp(d_episode_type.arr,"D")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd4_dy_pat_id.arr)!=0)
				    d4_epd_pat_cnt=	d4_epd_pat_cnt+1;
			   nd_d4_epd_outamt=nd_d4_epd_outamt+d_bil_out_amt;
			   nd_d4_epd_writeoff_amt=nd_d4_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_epd_tot_outamt = nd_d4_epd_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd4_dy_pat_id.arr,d_patient_id.arr);
             } 
         else if(strcmp(d_episode_type.arr,"R")==0)
		     {
			 	 if(strcmp(d_patient_id.arr,nd4_ex_pat_id.arr)!=0)
				   d4_epr_pat_cnt=d4_epr_pat_cnt+1;
			   nd_d4_epr_outamt=nd_d4_epr_outamt+d_bil_out_amt;
			   nd_d4_epr_writeoff_amt=nd_d4_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_epr_tot_outamt = nd_d4_epr_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd4_ex_pat_id.arr,d_patient_id.arr);
             } 

          }

//End of day 4

 else if (((doc_date >= nd_days4+1) && (doc_date <= nd_days5)) || ((doc_date >= nd_days4+1) && (nd_days5 == 0) && (nd_days4 != 0)))
       {
   		   
          if(strcmp(d_episode_type.arr,"I")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd5_ip_pat_id.arr)!=0)
				    d5_epi_pat_cnt=	d5_epi_pat_cnt+1;
			   nd_d5_epi_outamt=nd_d5_epi_outamt+d_bil_out_amt;
			   nd_d5_epi_writeoff_amt=nd_d5_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_epi_tot_outamt = nd_d5_epi_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd5_ip_pat_id.arr,d_patient_id.arr);
             }   
          else if(strcmp(d_episode_type.arr,"O")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd5_op_pat_id.arr)!=0)
				    d5_epo_pat_cnt=	d5_epo_pat_cnt+1;
			   nd_d5_epo_outamt=nd_d5_epo_outamt+d_bil_out_amt;
			   nd_d5_epo_writeoff_amt=nd_d5_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_epo_tot_outamt = nd_d5_epo_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd5_op_pat_id.arr,d_patient_id.arr);
             }            
          else if(strcmp(d_episode_type.arr,"E")==0)
		     {
			 	if(strcmp(d_patient_id.arr,nd5_em_pat_id.arr)!=0)
				 d5_epe_pat_cnt=d5_epe_pat_cnt+1;
			   nd_d5_epe_outamt=nd_d5_epe_outamt+d_bil_out_amt;
			   nd_d5_epe_writeoff_amt=nd_d5_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_epe_tot_outamt = nd_d5_epe_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd5_em_pat_id.arr,d_patient_id.arr);
             }            
          else if(strcmp(d_episode_type.arr,"D")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd5_dy_pat_id.arr)!=0)
				    d5_epd_pat_cnt=	d5_epd_pat_cnt+1;
			   nd_d5_epd_outamt=nd_d5_epd_outamt+d_bil_out_amt;
			   nd_d5_epd_writeoff_amt=nd_d5_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_epd_tot_outamt = nd_d5_epd_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd5_dy_pat_id.arr,d_patient_id.arr);
             } 
         else if(strcmp(d_episode_type.arr,"R")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd5_ex_pat_id.arr)!=0)
				    d5_epr_pat_cnt=	d5_epr_pat_cnt+1;
			   nd_d5_epr_outamt=nd_d5_epr_outamt+d_bil_out_amt;
			   nd_d5_epr_writeoff_amt=nd_d5_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_epr_tot_outamt = nd_d5_epr_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd5_ex_pat_id.arr,d_patient_id.arr);
             } 

          }
//end of day 5


else if ((doc_date >= nd_days5+1) || (doc_date >= nd_days5+1 && nd_days5 != 0))
       {
   		   
          if(strcmp(d_episode_type.arr,"I")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd6_ip_pat_id.arr)!=0)
				    d6_epi_pat_cnt=	d6_epi_pat_cnt+1;
			   nd_d6_epi_outamt=nd_d6_epi_outamt+d_bil_out_amt;
			   nd_d6_epi_writeoff_amt=nd_d6_epi_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_epi_tot_outamt = nd_d6_epi_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd6_ip_pat_id.arr,d_patient_id.arr);

             }   
          else if(strcmp(d_episode_type.arr,"O")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd6_op_pat_id.arr)!=0)
				    d6_epo_pat_cnt=	d6_epo_pat_cnt+1;
			   nd_d6_epo_outamt=nd_d6_epo_outamt+d_bil_out_amt;
			   nd_d6_epo_writeoff_amt=nd_d6_epo_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_epo_tot_outamt = nd_d6_epo_tot_outamt+ d_bil_tot_ot_amt; 
			   strcpy(nd6_op_pat_id.arr,d_patient_id.arr);
             }            
          else if(strcmp(d_episode_type.arr,"E")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd6_em_pat_id.arr)!=0)
				    d6_epe_pat_cnt=	d6_epe_pat_cnt+1;
			   nd_d6_epe_outamt=nd_d6_epe_outamt+d_bil_out_amt;
			   nd_d6_epe_writeoff_amt=nd_d6_epe_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_epe_tot_outamt = nd_d6_epe_tot_outamt+ d_bil_tot_ot_amt; 
			      strcpy(nd6_em_pat_id.arr,d_patient_id.arr);
             }            
          else if(strcmp(d_episode_type.arr,"D")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd6_dy_pat_id.arr)!=0)
				    d6_epd_pat_cnt=	d6_epd_pat_cnt+1;
			   nd_d6_epd_outamt=nd_d6_epd_outamt+d_bil_out_amt;
			   nd_d6_epd_writeoff_amt=nd_d6_epd_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_epd_tot_outamt = nd_d6_epd_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd6_dy_pat_id.arr,d_patient_id.arr);
             } 
         else if(strcmp(d_episode_type.arr,"R")==0)
		     {
			 	   if(strcmp(d_patient_id.arr,nd6_ex_pat_id.arr)!=0)
				    d6_epr_pat_cnt=	d6_epr_pat_cnt+1;
			   nd_d6_epr_outamt=nd_d6_epr_outamt+d_bil_out_amt;
			   nd_d6_epr_writeoff_amt=nd_d6_epr_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_epr_tot_outamt = nd_d6_epr_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd6_ex_pat_id.arr,d_patient_id.arr);
             } 

          }

      }

/************************* End Of  Break Up By EPISODE      *******************/

	
            }
	
	
		}


	}	
			  	   
	/**************************         End Of  process det  	*********************/

 process_sum()
   {
  open_AGE_SUM_CUR();
  		
   while(fetch_age_sum_cur())
      {
		      
       if(nd_days1 != 0 ) 
          {
      if(doc_date<=nd_days1) 
		 {
		   if(strcmp(d_patient_id.arr,nd1_spat_id.arr)!=0)
				 d1_spat_cnt=d1_spat_cnt+1;
               nd_d1_outamt=nd_d1_outamt+d_bil_out_amt;
			   nd_d1_writeoff_amt=nd_d1_writeoff_amt+d_bil_write_off_amt;
			   nd_d1_tot_outamt = nd_d1_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd1_spat_id.arr,d_patient_id.arr);
	     }
     else if (((doc_date >= nd_days1+1) && (doc_date <= nd_days2))|| ((doc_date >= nd_days1+1) && (nd_days2 == 0) ))
	    {
		 if(strcmp(d_patient_id.arr,nd2_spat_id.arr)!=0)
				 d2_spat_cnt=d2_spat_cnt+1;
               nd_d2_outamt=nd_d2_outamt+d_bil_out_amt;
			   nd_d2_writeoff_amt=nd_d2_writeoff_amt+d_bil_write_off_amt;
			   nd_d2_tot_outamt = nd_d2_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd2_spat_id.arr,d_patient_id.arr);
	     }
     else if (((doc_date >= nd_days2+1) && (doc_date <= nd_days3)) ||((doc_date >= nd_days2+1) && (nd_days3 == 0) && (nd_days2 != 0)))
       {
	    if(strcmp(d_patient_id.arr,nd3_spat_id.arr)!=0)
				 d3_spat_cnt=d3_spat_cnt+1;
   	           nd_d3_outamt=nd_d3_outamt+d_bil_out_amt;
			   nd_d3_writeoff_amt=nd_d3_writeoff_amt+d_bil_write_off_amt;
			   nd_d3_tot_outamt = nd_d3_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd3_spat_id.arr,d_patient_id.arr);
	     }
	 
	 
	 else if (((doc_date >= nd_days3+1) && (doc_date <= nd_days4)) || ((doc_date >= nd_days3+1) && (nd_days4 == 0) && (nd_days3 != 0)))
       {
	    if(strcmp(d_patient_id.arr,nd4_spat_id.arr)!=0)
				 d4_spat_cnt=d4_spat_cnt+1;
			   nd_d4_outamt=nd_d4_outamt+d_bil_out_amt;
			   nd_d4_writeoff_amt=nd_d4_writeoff_amt+d_bil_write_off_amt;
			   nd_d4_tot_outamt = nd_d4_tot_outamt+ d_bil_tot_ot_amt; 
			     strcpy(nd4_spat_id.arr,d_patient_id.arr);
	     }
	 
	 else if (((doc_date >= nd_days4+1) && (doc_date <= nd_days5)) || ((doc_date >= nd_days4+1) && (nd_days5 == 0) && (nd_days4 != 0)))
       {
	  if(strcmp(d_patient_id.arr,nd5_spat_id.arr)!=0)
				 d5_spat_cnt=d5_spat_cnt+1;
	 	       nd_d5_outamt=nd_d5_outamt+d_bil_out_amt;
			   nd_d5_writeoff_amt=nd_d5_writeoff_amt+d_bil_write_off_amt;
			   nd_d5_tot_outamt = nd_d5_tot_outamt+ d_bil_tot_ot_amt; 
			    strcpy(nd5_spat_id.arr,d_patient_id.arr);
	     }
	 else if ((doc_date >= nd_days5+1) || (doc_date >= nd_days5+1 && nd_days5 != 0))
       {
	    if(strcmp(d_patient_id.arr,nd6_spat_id.arr)!=0)
				 d6_spat_cnt=d6_spat_cnt+1;
   			   nd_d6_outamt=nd_d6_outamt+d_bil_out_amt;
			   nd_d6_writeoff_amt=nd_d6_writeoff_amt+d_bil_write_off_amt;
			   nd_d6_tot_outamt = nd_d6_tot_outamt+ d_bil_tot_ot_amt; 
			       strcpy(nd6_spat_id.arr,d_patient_id.arr);
	     } 
	 
	  } 
 
   }	     


  }

/**************************         End Of  process SUM  	*********************/

 open_files()
{

 strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00046.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00046.lis");
       proc_exit();
    }

}

age_value()
  {
    age_1_value.arr[0]	= '\0';
	age_2_value.arr[0]	= '\0';
	age_3_value.arr[0]	= '\0';
	age_4_value.arr[0]	= '\0';
	age_5_value.arr[0]	= '\0';
	
    age_1_ind.arr[0]	= '\0';
	age_2_ind.arr[0]	= '\0';
	age_3_ind.arr[0]	= '\0';
	age_4_ind.arr[0]	= '\0';
	age_5_ind.arr[0]	= '\0';

   age_1_value.len		= 0;
   age_2_value.len		= 0;
   age_3_value.len		= 0;
   age_4_value.len		= 0;
   age_5_value.len		= 0;
   
   age_1_ind.len		= 0;
   age_2_ind.len		= 0;
   age_3_ind.len		= 0;
   age_4_ind.len		= 0;
   age_5_ind.len		= 0;

/* EXEC SQL SELECT AGE_RANGE_1_VALUE,AGE_RANGE_2_VALUE,AGE_RANGE_3_VALUE,AGE_RANGE_4_VALUE,
                AGE_RANGE_5_VALUE,
		/o
		//DECODE(AGE_RANGE_1_IND,'D','Day(s)','M','Month(s)','Y','Year(s)'),
		//DECODE(AGE_RANGE_2_IND,'D','Day(s)','M','Month(s)','Y','Year(s)'),
		//DECODE(AGE_RANGE_3_IND,'D','Day(s)','M','Month(s)','Y','Year(s)'),
		//DECODE(AGE_RANGE_4_IND,'D','Day(s)','M','Month(s)','Y','Year(s)'),
		//DECODE(AGE_RANGE_5_IND,'D','Day(s)','M','Month(s)','Y','Year(s) ')
		o/
		DECODE(AGE_RANGE_1_IND,'D',:loc_legend[38],'M',:loc_legend[39],'Y',:loc_legend[40]),
		DECODE(AGE_RANGE_2_IND,'D',:loc_legend[38],'M',:loc_legend[39],'Y',:loc_legend[40]),
		DECODE(AGE_RANGE_3_IND,'D',:loc_legend[38],'M',:loc_legend[39],'Y',:loc_legend[40]),
		DECODE(AGE_RANGE_4_IND,'D',:loc_legend[38],'M',:loc_legend[39],'Y',:loc_legend[40]),
		DECODE(AGE_RANGE_5_IND,'D',:loc_legend[38],'M',:loc_legend[39],'Y',:loc_legend[40])

	INTO
		:age_1_value,
		:age_2_value,
		:age_3_value,
		:age_4_value,
		:age_5_value,
		:age_1_ind,
		:age_2_ind,
		:age_3_ind,
		:age_4_ind,
		:age_5_ind
         FROM BL_OUTST_AGEING_PARAM
	 WHERE  AGE_ANALYSIS_CODE=:nd_age_analysis_code; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 26;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select AGE_RANGE_1_VALUE ,AGE_RANGE_2_VALUE ,AGE_RANGE_3_VALU\
E ,AGE_RANGE_4_VALUE ,AGE_RANGE_5_VALUE ,DECODE(AGE_RANGE_1_IND,'D',:b0,'M',:b\
1,'Y',:b2) ,DECODE(AGE_RANGE_2_IND,'D',:b0,'M',:b1,'Y',:b2) ,DECODE(AGE_RANGE_\
3_IND,'D',:b0,'M',:b1,'Y',:b2) ,DECODE(AGE_RANGE_4_IND,'D',:b0,'M',:b1,'Y',:b2\
) ,DECODE(AGE_RANGE_5_IND,'D',:b0,'M',:b1,'Y',:b2) into :b15,:b16,:b17,:b18,:b\
19,:b20,:b21,:b22,:b23,:b24  from BL_OUTST_AGEING_PARAM where AGE_ANALYSIS_COD\
E=:b25";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )114;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)loc_legend[38];
sqlstm.sqhstl[0] = (unsigned int  )201;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)loc_legend[39];
sqlstm.sqhstl[1] = (unsigned int  )201;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)loc_legend[40];
sqlstm.sqhstl[2] = (unsigned int  )201;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)loc_legend[38];
sqlstm.sqhstl[3] = (unsigned int  )201;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)loc_legend[39];
sqlstm.sqhstl[4] = (unsigned int  )201;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)loc_legend[40];
sqlstm.sqhstl[5] = (unsigned int  )201;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)loc_legend[38];
sqlstm.sqhstl[6] = (unsigned int  )201;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)loc_legend[39];
sqlstm.sqhstl[7] = (unsigned int  )201;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)loc_legend[40];
sqlstm.sqhstl[8] = (unsigned int  )201;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)loc_legend[38];
sqlstm.sqhstl[9] = (unsigned int  )201;
sqlstm.sqhsts[9] = (         int  )0;
sqlstm.sqindv[9] = (         void  *)0;
sqlstm.sqinds[9] = (         int  )0;
sqlstm.sqharm[9] = (unsigned int  )0;
sqlstm.sqadto[9] = (unsigned short )0;
sqlstm.sqtdso[9] = (unsigned short )0;
sqlstm.sqhstv[10] = (         void  *)loc_legend[39];
sqlstm.sqhstl[10] = (unsigned int  )201;
sqlstm.sqhsts[10] = (         int  )0;
sqlstm.sqindv[10] = (         void  *)0;
sqlstm.sqinds[10] = (         int  )0;
sqlstm.sqharm[10] = (unsigned int  )0;
sqlstm.sqadto[10] = (unsigned short )0;
sqlstm.sqtdso[10] = (unsigned short )0;
sqlstm.sqhstv[11] = (         void  *)loc_legend[40];
sqlstm.sqhstl[11] = (unsigned int  )201;
sqlstm.sqhsts[11] = (         int  )0;
sqlstm.sqindv[11] = (         void  *)0;
sqlstm.sqinds[11] = (         int  )0;
sqlstm.sqharm[11] = (unsigned int  )0;
sqlstm.sqadto[11] = (unsigned short )0;
sqlstm.sqtdso[11] = (unsigned short )0;
sqlstm.sqhstv[12] = (         void  *)loc_legend[38];
sqlstm.sqhstl[12] = (unsigned int  )201;
sqlstm.sqhsts[12] = (         int  )0;
sqlstm.sqindv[12] = (         void  *)0;
sqlstm.sqinds[12] = (         int  )0;
sqlstm.sqharm[12] = (unsigned int  )0;
sqlstm.sqadto[12] = (unsigned short )0;
sqlstm.sqtdso[12] = (unsigned short )0;
sqlstm.sqhstv[13] = (         void  *)loc_legend[39];
sqlstm.sqhstl[13] = (unsigned int  )201;
sqlstm.sqhsts[13] = (         int  )0;
sqlstm.sqindv[13] = (         void  *)0;
sqlstm.sqinds[13] = (         int  )0;
sqlstm.sqharm[13] = (unsigned int  )0;
sqlstm.sqadto[13] = (unsigned short )0;
sqlstm.sqtdso[13] = (unsigned short )0;
sqlstm.sqhstv[14] = (         void  *)loc_legend[40];
sqlstm.sqhstl[14] = (unsigned int  )201;
sqlstm.sqhsts[14] = (         int  )0;
sqlstm.sqindv[14] = (         void  *)0;
sqlstm.sqinds[14] = (         int  )0;
sqlstm.sqharm[14] = (unsigned int  )0;
sqlstm.sqadto[14] = (unsigned short )0;
sqlstm.sqtdso[14] = (unsigned short )0;
sqlstm.sqhstv[15] = (         void  *)&age_1_value;
sqlstm.sqhstl[15] = (unsigned int  )13;
sqlstm.sqhsts[15] = (         int  )0;
sqlstm.sqindv[15] = (         void  *)0;
sqlstm.sqinds[15] = (         int  )0;
sqlstm.sqharm[15] = (unsigned int  )0;
sqlstm.sqadto[15] = (unsigned short )0;
sqlstm.sqtdso[15] = (unsigned short )0;
sqlstm.sqhstv[16] = (         void  *)&age_2_value;
sqlstm.sqhstl[16] = (unsigned int  )13;
sqlstm.sqhsts[16] = (         int  )0;
sqlstm.sqindv[16] = (         void  *)0;
sqlstm.sqinds[16] = (         int  )0;
sqlstm.sqharm[16] = (unsigned int  )0;
sqlstm.sqadto[16] = (unsigned short )0;
sqlstm.sqtdso[16] = (unsigned short )0;
sqlstm.sqhstv[17] = (         void  *)&age_3_value;
sqlstm.sqhstl[17] = (unsigned int  )13;
sqlstm.sqhsts[17] = (         int  )0;
sqlstm.sqindv[17] = (         void  *)0;
sqlstm.sqinds[17] = (         int  )0;
sqlstm.sqharm[17] = (unsigned int  )0;
sqlstm.sqadto[17] = (unsigned short )0;
sqlstm.sqtdso[17] = (unsigned short )0;
sqlstm.sqhstv[18] = (         void  *)&age_4_value;
sqlstm.sqhstl[18] = (unsigned int  )13;
sqlstm.sqhsts[18] = (         int  )0;
sqlstm.sqindv[18] = (         void  *)0;
sqlstm.sqinds[18] = (         int  )0;
sqlstm.sqharm[18] = (unsigned int  )0;
sqlstm.sqadto[18] = (unsigned short )0;
sqlstm.sqtdso[18] = (unsigned short )0;
sqlstm.sqhstv[19] = (         void  *)&age_5_value;
sqlstm.sqhstl[19] = (unsigned int  )13;
sqlstm.sqhsts[19] = (         int  )0;
sqlstm.sqindv[19] = (         void  *)0;
sqlstm.sqinds[19] = (         int  )0;
sqlstm.sqharm[19] = (unsigned int  )0;
sqlstm.sqadto[19] = (unsigned short )0;
sqlstm.sqtdso[19] = (unsigned short )0;
sqlstm.sqhstv[20] = (         void  *)&age_1_ind;
sqlstm.sqhstl[20] = (unsigned int  )10;
sqlstm.sqhsts[20] = (         int  )0;
sqlstm.sqindv[20] = (         void  *)0;
sqlstm.sqinds[20] = (         int  )0;
sqlstm.sqharm[20] = (unsigned int  )0;
sqlstm.sqadto[20] = (unsigned short )0;
sqlstm.sqtdso[20] = (unsigned short )0;
sqlstm.sqhstv[21] = (         void  *)&age_2_ind;
sqlstm.sqhstl[21] = (unsigned int  )10;
sqlstm.sqhsts[21] = (         int  )0;
sqlstm.sqindv[21] = (         void  *)0;
sqlstm.sqinds[21] = (         int  )0;
sqlstm.sqharm[21] = (unsigned int  )0;
sqlstm.sqadto[21] = (unsigned short )0;
sqlstm.sqtdso[21] = (unsigned short )0;
sqlstm.sqhstv[22] = (         void  *)&age_3_ind;
sqlstm.sqhstl[22] = (unsigned int  )10;
sqlstm.sqhsts[22] = (         int  )0;
sqlstm.sqindv[22] = (         void  *)0;
sqlstm.sqinds[22] = (         int  )0;
sqlstm.sqharm[22] = (unsigned int  )0;
sqlstm.sqadto[22] = (unsigned short )0;
sqlstm.sqtdso[22] = (unsigned short )0;
sqlstm.sqhstv[23] = (         void  *)&age_4_ind;
sqlstm.sqhstl[23] = (unsigned int  )10;
sqlstm.sqhsts[23] = (         int  )0;
sqlstm.sqindv[23] = (         void  *)0;
sqlstm.sqinds[23] = (         int  )0;
sqlstm.sqharm[23] = (unsigned int  )0;
sqlstm.sqadto[23] = (unsigned short )0;
sqlstm.sqtdso[23] = (unsigned short )0;
sqlstm.sqhstv[24] = (         void  *)&age_5_ind;
sqlstm.sqhstl[24] = (unsigned int  )10;
sqlstm.sqhsts[24] = (         int  )0;
sqlstm.sqindv[24] = (         void  *)0;
sqlstm.sqinds[24] = (         int  )0;
sqlstm.sqharm[24] = (unsigned int  )0;
sqlstm.sqadto[24] = (unsigned short )0;
sqlstm.sqtdso[24] = (unsigned short )0;
sqlstm.sqhstv[25] = (         void  *)&nd_age_analysis_code;
sqlstm.sqhstl[25] = (unsigned int  )13;
sqlstm.sqhsts[25] = (         int  )0;
sqlstm.sqindv[25] = (         void  *)0;
sqlstm.sqinds[25] = (         int  )0;
sqlstm.sqharm[25] = (unsigned int  )0;
sqlstm.sqadto[25] = (unsigned short )0;
sqlstm.sqtdso[25] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	age_1_value.arr[age_1_value.len]	= '\0';
	age_2_value.arr[age_2_value.len]	= '\0';
	age_3_value.arr[age_3_value.len]	= '\0';
	age_4_value.arr[age_4_value.len]	= '\0';
	age_5_value.arr[age_5_value.len]	= '\0';
	
	age_1_ind.arr[age_1_ind.len]	= '\0';
	age_2_ind.arr[age_2_ind.len]	= '\0';
	age_3_ind.arr[age_3_ind.len]	= '\0';
	age_4_ind.arr[age_4_ind.len]	= '\0';
	age_5_ind.arr[age_5_ind.len]	= '\0';  
	   
   if (OERROR)
        err_mesg("SELECT failed on table BL_OUTST_AGEING_PARAM1",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in BL_OUTST_AGEING_PARAM1",0,"");   
		          
}

fetch_param()
{
			nd_days1        = 0;
			nd_days2        = 0;
			nd_days3       = 0;
			nd_days4       = 0;
	   	        nd_days5       = 0;

 /* EXEC SQL  SELECT 
   NVL(CEIL(TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-(TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-(DECODE(AGE_RANGE_1_IND,'D',TO_NUMBER(AGE_RANGE_1_VALUE),'M',TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),-(TO_NUMBER(AGE_RANGE_1_VALUE))),'Y',TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),-(TO_NUMBER(AGE_RANGE_1_VALUE)*12)))))),0),
   NVL(CEIL(TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-(TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-(DECODE(AGE_RANGE_2_IND,'D',TO_NUMBER(AGE_RANGE_2_VALUE),'M',TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),-(TO_NUMBER(AGE_RANGE_2_VALUE))),'Y',TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),-(TO_NUMBER(AGE_RANGE_2_VALUE)*12)))))),0),
   NVL(CEIL(TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-(TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-(DECODE(AGE_RANGE_3_IND,'D',TO_NUMBER(AGE_RANGE_3_VALUE),'M',TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),-(TO_NUMBER(AGE_RANGE_3_VALUE))),'Y',TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),-(TO_NUMBER(AGE_RANGE_3_VALUE)*12)))))),0),
   NVL(CEIL(TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-(TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-(DECODE(AGE_RANGE_4_IND,'D',TO_NUMBER(AGE_RANGE_4_VALUE),'M',TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),-(TO_NUMBER(AGE_RANGE_4_VALUE))),'Y',TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),-(TO_NUMBER(AGE_RANGE_4_VALUE)*12)))))),0),
   NVL(CEIL(TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-(TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-(DECODE(AGE_RANGE_5_IND,'D',TO_NUMBER(AGE_RANGE_5_VALUE),'M',TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),-(TO_NUMBER(AGE_RANGE_5_VALUE))),'Y',TO_DATE(:nd_as_on_date,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),-(TO_NUMBER(AGE_RANGE_5_VALUE)*12)))))),0)
       	   INTO
			:nd_days1,
			:nd_days2,
			:nd_days3,
			:nd_days4,
		    :nd_days5
		FROM  BL_OUTST_AGEING_PARAM
		WHERE AGE_ANALYSIS_CODE=:nd_age_analysis_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 36;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select NVL(CEIL((TO_DATE(:b0,'DD/MM/YYYY')-(TO_DATE(:b0,'DD/MM/YYYY')-DE\
CODE(AGE_RANGE_1_IND,'D',TO_NUMBER(AGE_RANGE_1_VALUE),'M',(TO_DATE(:b0,'DD/M\
M/YYYY')-ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY'),(-TO_NUMBER(AGE_RANGE_1_VALUE)\
))),'Y',(TO_DATE(:b0,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY'),(-(T\
O_NUMBER(AGE_RANGE_1_VALUE)* 12)))))))),0) ,NVL(CEIL((TO_DATE(:b0,'DD/MM/YYY\
Y')-(TO_DATE(:b0,'DD/MM/YYYY')-DECODE(AGE_RANGE_2_IND,'D',TO_NUMBER(AGE_RANG\
E_2_VALUE),'M',(TO_DATE(:b0,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY\
'),(-TO_NUMBER(AGE_RANGE_2_VALUE)))),'Y',(TO_DATE(:b0,'DD/MM/YYYY')-ADD_MONT\
HS(TO_DATE(:b0,'DD/MM/YYYY'),(-(TO_NUMBER(AGE_RANGE_2_VALUE)* 12)))))))),0) \
,NVL(CEIL((TO_DATE(:b0,'DD/MM/YYYY')-(TO_DATE(:b0,'DD/MM/YYYY')-DECODE(AGE_R\
ANGE_3_IND,'D',TO_NUMBER(AGE_RANGE_3_VALUE),'M',(TO_DATE(:b0,'DD/MM/YYYY')-A\
DD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY'),(-TO_NUMBER(AGE_RANGE_3_VALUE)))),'Y',(T\
O_DATE(:b0,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY'),(-(TO_NUMBER(A\
GE_RANGE_3_VALUE)* 12)))))))),0) ,NVL(CE");
 sqlstm.stmt = "IL((TO_DATE(:b0,'DD/MM/YYYY')-(TO_DATE(:b0,'DD/MM/YYYY')-DEC\
ODE(AGE_RANGE_4_IND,'D',TO_NUMBER(AGE_RANGE_4_VALUE),'M',(TO_DATE(:b0,'DD/MM/Y\
YYY')-ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY'),(-TO_NUMBER(AGE_RANGE_4_VALUE)))),'\
Y',(TO_DATE(:b0,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY'),(-(TO_NUMBE\
R(AGE_RANGE_4_VALUE)* 12)))))))),0) ,NVL(CEIL((TO_DATE(:b0,'DD/MM/YYYY')-(TO_D\
ATE(:b0,'DD/MM/YYYY')-DECODE(AGE_RANGE_5_IND,'D',TO_NUMBER(AGE_RANGE_5_VALUE),\
'M',(TO_DATE(:b0,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY'),(-TO_NUMBE\
R(AGE_RANGE_5_VALUE)))),'Y',(TO_DATE(:b0,'DD/MM/YYYY')-ADD_MONTHS(TO_DATE(:b0,\
'DD/MM/YYYY'),(-(TO_NUMBER(AGE_RANGE_5_VALUE)* 12)))))))),0) into :b30,:b31,:b\
32,:b33,:b34  from BL_OUTST_AGEING_PARAM where AGE_ANALYSIS_CODE=:b35";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )233;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[0] = (unsigned int  )17;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[1] = (unsigned int  )17;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[2] = (unsigned int  )17;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[3] = (unsigned int  )17;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[4] = (unsigned int  )17;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[5] = (unsigned int  )17;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[6] = (unsigned int  )17;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[7] = (unsigned int  )17;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[8] = (unsigned int  )17;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[9] = (unsigned int  )17;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[10] = (unsigned int  )17;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[11] = (unsigned int  )17;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[12] = (unsigned int  )17;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[13] = (unsigned int  )17;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[14] = (unsigned int  )17;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[15] = (unsigned int  )17;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[16] = (unsigned int  )17;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[17] = (unsigned int  )17;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[18] = (unsigned int  )17;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[19] = (unsigned int  )17;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[20] = (unsigned int  )17;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[21] = (unsigned int  )17;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[22] = (unsigned int  )17;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[23] = (unsigned int  )17;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[24] = (unsigned int  )17;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[25] = (unsigned int  )17;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[26] = (unsigned int  )17;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[27] = (unsigned int  )17;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[28] = (unsigned int  )17;
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[29] = (unsigned int  )17;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&nd_days1;
 sqlstm.sqhstl[30] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)&nd_days2;
 sqlstm.sqhstl[31] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[31] = (         int  )0;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
 sqlstm.sqhstv[32] = (         void  *)&nd_days3;
 sqlstm.sqhstl[32] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[32] = (         int  )0;
 sqlstm.sqindv[32] = (         void  *)0;
 sqlstm.sqinds[32] = (         int  )0;
 sqlstm.sqharm[32] = (unsigned int  )0;
 sqlstm.sqadto[32] = (unsigned short )0;
 sqlstm.sqtdso[32] = (unsigned short )0;
 sqlstm.sqhstv[33] = (         void  *)&nd_days4;
 sqlstm.sqhstl[33] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[33] = (         int  )0;
 sqlstm.sqindv[33] = (         void  *)0;
 sqlstm.sqinds[33] = (         int  )0;
 sqlstm.sqharm[33] = (unsigned int  )0;
 sqlstm.sqadto[33] = (unsigned short )0;
 sqlstm.sqtdso[33] = (unsigned short )0;
 sqlstm.sqhstv[34] = (         void  *)&nd_days5;
 sqlstm.sqhstl[34] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[34] = (         int  )0;
 sqlstm.sqindv[34] = (         void  *)0;
 sqlstm.sqinds[34] = (         int  )0;
 sqlstm.sqharm[34] = (unsigned int  )0;
 sqlstm.sqadto[34] = (unsigned short )0;
 sqlstm.sqtdso[34] = (unsigned short )0;
 sqlstm.sqhstv[35] = (         void  *)&nd_age_analysis_code;
 sqlstm.sqhstl[35] = (unsigned int  )13;
 sqlstm.sqhsts[35] = (         int  )0;
 sqlstm.sqindv[35] = (         void  *)0;
 sqlstm.sqinds[35] = (         int  )0;
 sqlstm.sqharm[35] = (unsigned int  )0;
 sqlstm.sqadto[35] = (unsigned short )0;
 sqlstm.sqtdso[35] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
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
        err_mesg("SELECT failed on table BL_OUTST_AGEING_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in BL_OUTST_AGEING_PARAM",0,"");

		
}

 declare_cur()
{

  if(strcmp(nd_sumdet.arr,"D")==0) 
  {
       /* EXEC SQL DECLARE AGE_DET_CUR CURSOR FOR
       select blcommon.get_reln_code(a.patient_id) citizen,a.patient_id,
       NVL(a.episode_type,'R'),
       nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE) Bill_doc_type,
       nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER) bill_doc_num,
       CEIL(NVL(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),SYSDATE) - 
       nvl(b.DOC_DATE,a.doc_date)) ageing_period,
       sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT) Bill_Outst_amt,
       sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,
                        'CANC-WRITEOFF',a.CREDIT_AMT,0)) -
       sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,
                           'CANC-WRITEOFF',a.DEBIT_AMT,0)) WO_Amt,
      (sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT)
       + (sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,
                           'CANC-WRITEOFF',a.CREDIT_AMT,0)) -
       sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,
                           'CANC-WRITEOFF',a.DEBIT_AMT,0))))TOT_AMT
from BL_PATIENT_STATEMENT_VW a, bl_bill_dcp_dtl_vw b
where nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE) = b.doc_type_code
and nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER) = b.doc_num
and a.DOCUMENT_NATURE IN('BI','DC')
AND B.BILL_TOT_AMT>0
and a.doc_date <= nvl(to_date(:nd_as_on_date||' 23:59:59','DD/MM/YYYY hh24:mi:ss'),sysdate)
group by NVL(a.episode_type,'R'),a.patient_id,
  blcommon.get_reln_code(a.patient_id),
  nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE),
  nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER),
  CEIL(NVL(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),SYSDATE) - nvl(b.DOC_DATE,a.doc_date))
having (sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT)
       + (sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,
                           'CANC-WRITEOFF',a.CREDIT_AMT,0)) -
       sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,
                           'CANC-WRITEOFF',a.DEBIT_AMT,0)))) > 0
						   ORDER BY a.patient_id; */ 


			}

else
  {
    /* EXEC SQL DECLARE AGE_SUM_CUR CURSOR FOR
   select 
       NVL(a.episode_type,'R'),a.patient_id,
       nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE) Bill_doc_type,
       nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER) bill_doc_num,
       CEIL(NVL(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),SYSDATE) - nvl(b.DOC_DATE,a.doc_date)) ageing_period,
       sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT) Bill_Outst_amt,
       sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,
                           'CANC-WRITEOFF',a.CREDIT_AMT,0)) -
       sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,
                           'CANC-WRITEOFF',a.DEBIT_AMT,0)) WO_Amt,
	   (sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT)
       + (sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,
                           'CANC-WRITEOFF',a.CREDIT_AMT,0)) -
       sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,
                           'CANC-WRITEOFF',a.DEBIT_AMT,0))))TOT_AMT
from  BL_PATIENT_STATEMENT_VW a, bl_bill_dcp_dtl_vw b
where nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE) = b.doc_type_code
and nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER) = b.doc_num
and a.DOCUMENT_NATURE IN('BI','DC')
   AND B.BILL_TOT_AMT>0
and a.doc_date <= nvl(to_date(:nd_as_on_date||' 23:59:59','DD/MM/YYYY HH24:MI:SS'),sysdate)
group by NVL(a.episode_type,'R'),a.patient_id,
    nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE),
  nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER),
  CEIL(NVL(TO_DATE(:nd_as_on_date,'DD/MM/YYYY'),SYSDATE) - nvl(b.DOC_DATE,a.doc_date))
having (sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT)
       + (sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,
                           'CANC-WRITEOFF',a.CREDIT_AMT,0)) -
       sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,
                           'CANC-WRITEOFF',a.DEBIT_AMT,0)))) > 0
						   ORDER BY a.patient_id; */ 

			}
}

open_AGE_DET_CUR() 
  {

	/* EXEC SQL OPEN AGE_DET_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 36;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select blcommon.get_reln_code(a.patient_id) citizen ,a.patient_id ,NVL(a\
.episode_type,'R') ,nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE) Bill_doc_type ,\
nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER) bill_doc_num ,CEIL((NVL(TO_DATE(:b0,'DD/MM/Y\
YYY'),SYSDATE)-nvl(b.DOC_DATE,a.doc_date))) ageing_period ,(sum(a.DEBIT_AMT)\
-sum(a.CREDIT_AMT)) Bill_Outst_amt ,(sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CRED\
IT_AMT,'CANC-WRITEOFF',a.CREDIT_AMT,0))-sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.D\
EBIT_AMT,'CANC-WRITEOFF',a.DEBIT_AMT,0))) WO_Amt ,((sum(a.DEBIT_AMT)-sum(a.C\
REDIT_AMT))+(sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,'CANC-WRITEOFF',a\
.CREDIT_AMT,0))-sum(DECODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,'CANC-WRITEOFF'\
,a.DEBIT_AMT,0)))) TOT_AMT  from BL_PATIENT_STATEMENT_VW a ,bl_bill_dcp_dtl_\
vw b where ((((nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_TYPE_CODE)=b.doc_type_code and \
nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER)=b.doc_num) and a.DOCUMENT_NATURE in ('BI','D\
C')) and B.BILL_TOT_AMT>0) and a.doc_date<=nvl(to_date((:b0||' 23:59:59'),'D\
D/MM/YYYY hh24:mi:ss'),sysdate)) group b");
 sqlstm.stmt = sq0006;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )392;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[0] = (unsigned int  )17;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[1] = (unsigned int  )17;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[2] = (unsigned int  )17;
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
        err_mesg("OPEN failed on cursor AGE_DET_CUR",0,"");
   }

close_AGE_DET_CUR()
   {

	/* EXEC SQL CLOSE AGE_DET_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 36;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )419;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
	}

open_AGE_SUM_CUR() 
  {

	/* EXEC SQL OPEN AGE_SUM_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 36;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select NVL(a.episode_type,'R') ,a.patient_id ,nvl(a.ADJ_DOC_TYPE_CODE,a.\
DOC_TYPE_CODE) Bill_doc_type ,nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER) bill_doc_num ,\
CEIL((NVL(TO_DATE(:b0,'DD/MM/YYYY'),SYSDATE)-nvl(b.DOC_DATE,a.doc_date))) ag\
eing_period ,(sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT)) Bill_Outst_amt ,(sum(DECOD\
E(a.TRX_TYPE,'WRITEOFF',a.CREDIT_AMT,'CANC-WRITEOFF',a.CREDIT_AMT,0))-sum(DE\
CODE(a.TRX_TYPE,'WRITEOFF',a.DEBIT_AMT,'CANC-WRITEOFF',a.DEBIT_AMT,0))) WO_A\
mt ,((sum(a.DEBIT_AMT)-sum(a.CREDIT_AMT))+(sum(DECODE(a.TRX_TYPE,'WRITEOFF',\
a.CREDIT_AMT,'CANC-WRITEOFF',a.CREDIT_AMT,0))-sum(DECODE(a.TRX_TYPE,'WRITEOF\
F',a.DEBIT_AMT,'CANC-WRITEOFF',a.DEBIT_AMT,0)))) TOT_AMT  from BL_PATIENT_ST\
ATEMENT_VW a ,bl_bill_dcp_dtl_vw b where ((((nvl(a.ADJ_DOC_TYPE_CODE,a.DOC_T\
YPE_CODE)=b.doc_type_code and nvl(a.ADJ_DOC_NUM,a.DOC_NUMBER)=b.doc_num) and\
 a.DOCUMENT_NATURE in ('BI','DC')) and B.BILL_TOT_AMT>0) and a.doc_date<=nvl\
(to_date((:b0||' 23:59:59'),'DD/MM/YYYY HH24:MI:SS'),sysdate)) group by NVL(\
a.episode_type,'R'),a.patient_id,nvl(a.A");
 sqlstm.stmt = sq0007;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )434;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[0] = (unsigned int  )17;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[1] = (unsigned int  )17;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_as_on_date;
 sqlstm.sqhstl[2] = (unsigned int  )17;
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
        err_mesg("OPEN failed on cursor AGE_SUM_CUR",0,"");
   }

close_AGE_SUM_CUR()
   {

	/* EXEC SQL CLOSE AGE_SUM_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 36;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )461;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    
	}


fetch_age_det_cur()
     { 
		    d_episode_type.arr[0]		= '\0';	
			d_doc_type_code.arr[0]		= '\0';	
            d_citizen.arr[0]			= '\0';	   
            d_patient_id.arr[0]			= '\0';	  

			d_episode_type.len		= 0;	
			d_doc_type_code.len		= 0;	
            d_citizen.len			= 0;
			d_patient_id.len		= 0;
			d_bil_out_amt=0;
			d_bil_write_off_amt=0;
		d_bil_tot_ot_amt=0;	   
		 doc_date=0;

 /* EXEC SQL FETCH  AGE_DET_CUR 
                 INTO 
				:d_citizen,
				:d_patient_id,
                :d_episode_type,
				:d_doc_type_code,
				:d_doc_num,
				:doc_date,
				:d_bil_out_amt,
				:d_bil_write_off_amt,
				:d_bil_tot_ot_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 36;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )476;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_citizen;
 sqlstm.sqhstl[0] = (unsigned int  )12;
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
 sqlstm.sqhstv[2] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[2] = (unsigned int  )4;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[3] = (unsigned int  )8;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&doc_date;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_bil_out_amt;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_bil_write_off_amt;
 sqlstm.sqhstl[7] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&d_bil_tot_ot_amt;
 sqlstm.sqhstl[8] = (unsigned int  )sizeof(double);
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
       err_mesg("FETCH failed on cursor AGE_DET_CUR ",0,"");	


			d_episode_type.arr[d_episode_type.len]			= '\0';	
			d_doc_type_code.arr[d_doc_type_code.len]		= '\0';	
            d_citizen.arr[d_citizen.len]					= '\0';	
			d_patient_id.arr[d_patient_id.len]				= '\0';

		return(LAST_ROW?0:1);   
}



fetch_age_sum_cur()
     { 
		    d_episode_type.arr[0]		= '\0';	
			d_patient_id.arr[0]			= '\0';	
			d_doc_type_code.arr[0]		= '\0';	
           	d_episode_type.len		= 0;	
			d_doc_type_code.len		= 0;
			d_patient_id.len		= 0;	
            d_bil_out_amt=0;
			d_bil_write_off_amt=0;
		d_bil_tot_ot_amt=0;	   
		 doc_date=0;

 /* EXEC SQL FETCH  AGE_SUM_CUR 
                 INTO 
                :d_episode_type,
				:d_patient_id,
				:d_doc_type_code,
				:d_doc_num,
				:doc_date,
				:d_bil_out_amt,
				:d_bil_write_off_amt,
				:d_bil_tot_ot_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 36;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )527;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[0] = (unsigned int  )4;
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
 sqlstm.sqhstv[2] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )8;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_doc_num;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&doc_date;
 sqlstm.sqhstl[4] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_bil_out_amt;
 sqlstm.sqhstl[5] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_bil_write_off_amt;
 sqlstm.sqhstl[6] = (unsigned int  )sizeof(double);
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_bil_tot_ot_amt;
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
}



			 if (OERROR)
       err_mesg("FETCH failed on cursor AGE_SUM_CUR ",0,"");	


			d_episode_type.arr[d_episode_type.len]			= '\0';	
			d_doc_type_code.arr[d_doc_type_code.len]		= '\0';	
			d_patient_id.arr[d_patient_id.len]				= '\0';
           

		return(LAST_ROW?0:1);   
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
		   USER, TO_CHAR(SYSDATE, 'DD/MM/YYYY'),TO_CHAR(SYSDATE, 'HH24:MI:SS'),HEAD_OF_COMPANY_NAME
      INTO :d_acc_entity_name,
		   :d_user, :d_sysdate,:d_curr_date,d_head_name
      FROM SY_ACC_ENTITY
	 WHERE acc_entity_id = :nd_facility; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 36;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select upper(ACC_ENTITY_NAME) ,USER ,TO_CHAR(SYSDATE,'DD/MM/\
YYYY') ,TO_CHAR(SYSDATE,'HH24:MI:SS') ,HEAD_OF_COMPANY_NAME into :b0,:b1,:b2,:\
b3,:b4  from SY_ACC_ENTITY where acc_entity_id=:b5";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )574;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
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
 sqlstm.sqphsv = sqlstm.sqhstv;
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
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 36;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )613;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	proc_exit();
}
print_page_title()
  {

	int hosp_nm_len,date1_len, rep_title_len = 10,v_title_len,v_title1_len, s1, s2,date_len,user_len,pgm_len,sub_title_len;
	char v_rep_title[200],v_as_on_date[12],v_sub_title[200],v_title[200],v_title1[200];
   
	fprintf(fp,"MDL : BL");
	hosp_nm_len  =  d_acc_entity_name.len;
	s1 = (REP_WIDTH-hosp_nm_len)/2;
	horz_skip(s1-8);
	fprintf(fp,"%s", d_acc_entity_name.arr);
	s2 = (REP_WIDTH-s1-hosp_nm_len);
	date1_len=strlen(loc_legend[8]);
	horz_skip(s2-date1_len-12);
	fprintf(fp,"%s: %s", loc_legend[8],d_sysdate.arr);
    
	next_line(1);

	
	fprintf(fp,"OPR : %s", d_user.arr); 	
        user_len=strlen(d_user.arr);
	strcpy(v_rep_title,loc_legend[4]);
	rep_title_len = strlen(v_rep_title);
	s1 = (REP_WIDTH-rep_title_len)/2;
	 strcpy(v_as_on_date,nd_as_on_date.arr);
	date_len= strlen(v_as_on_date);
	horz_skip(s1-user_len-6);
	fprintf(fp,"%s  %10s",v_rep_title,v_as_on_date);
   	s2 = (REP_WIDTH-s1-rep_title_len-date_len);
	horz_skip(s2-24);
	fprintf(fp,"%9s : %10s",loc_legend[22],d_curr_date.arr);
	next_line(1);

	fprintf(fp,"REP : %s",d_curr_pgm_name.arr);
        pgm_len=strlen(d_curr_pgm_name.arr);
	 
	strcpy(v_sub_title,d_head_name.arr);

	sub_title_len = strlen(v_sub_title);
	s1 = (REP_WIDTH-sub_title_len)/2;
   	horz_skip(s1-pgm_len-6);
    fprintf(fp,"%s",v_sub_title);

        s2 = (REP_WIDTH-s1-sub_title_len-5);
	    horz_skip(s2-19);
		fprintf(fp,"%11s : %10d",loc_legend[9],++page_no);
	next_line(1);
	fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 			*/

  if(strcmp(nd_sumdet.arr,"D")==0 && strcmp(d_tre_chk.arr,"Y")==0)
  {
	strcpy(v_title,loc_legend[7]);
    strcpy(v_title1,loc_legend[21]);
   v_title_len =strlen(v_title);
   v_title1_len =strlen(v_title1);
   s1=(REP_WIDTH-(v_title_len+v_title1_len))/2;
   	horz_skip(s1);
   fprintf(fp,"%s%-s",v_title,v_title1);
   	next_line(1);
  }
  else if(strcmp(nd_sumdet.arr,"S")==0 && strcmp(d_tre_chk.arr,"Y")==0)
   {
   strcpy(v_title1,loc_legend[21]);
     v_title1_len =strlen(v_title1);
   s1=(REP_WIDTH-(v_title1_len))/2;
   	horz_skip(s1);
   fprintf(fp,"%s",v_title1);
   	next_line(1);
    }
fprintf(fp,"%c(s-3B",ESC); /* release bold style */
   
	lctr = 6;
	print_line('-',REP_WIDTH); next_line(1);

	
}


print_column_title()
 {
 if(strcmp(nd_sumdet.arr,"D")==0)
   {
     if(strcmp(nd_br_episode_type.arr,"Y")==0 && strcmp(nd_br_citizen.arr,"N")==0)
      fprintf(fp, "%-4s%-23s %-12s%20s %15s  %15s %15s %-s",loc_legend[10],loc_legend[11],loc_legend[37],loc_legend[13],loc_legend[14],loc_legend[15],loc_legend[16],loc_legend[23]);
     else
      fprintf(fp, "%-4s%-24s   %-10s%20s %15s  %15s %15s %-s",loc_legend[10],loc_legend[11],loc_legend[12],loc_legend[13],loc_legend[14],loc_legend[15],loc_legend[16],loc_legend[23]);
    }
   else
   fprintf(fp, "%-4s%-24s%20s %15s  %15s %15s %-s",loc_legend[10],loc_legend[11],loc_legend[13],loc_legend[14],loc_legend[15],loc_legend[16],loc_legend[23]);
   	next_line(1);

	print_line('-',REP_WIDTH);
 next_line(1);

 }
print_param()
{
print_page_title();

  fprintf(fp,"VER 4.1\n");
 
  fprintf(fp,"\n\n\n\n");
  fprintf(fp,"        ");
  fprintf(fp,"INPUT PARAMETERS :\n");
  fprintf(fp,"        ");
  fprintf(fp,"------------------\n\n");
  fprintf(fp,"                        REPORT TYPE   : ");
   if(strcmp(nd_sumdet.arr,"D")==0)
  fprintf(fp,"DETAIL");
   else
  fprintf(fp,"SUMMARY");
  fprintf(fp,"\n");
  fprintf(fp,"                AGEING CUT-OFF DATE   : %s\n",nd_as_on_date.arr);
  fprintf(fp,"\n");
  fprintf(fp,"                        BREAK UP BY   : ");
    if(strcmp(nd_br_episode_type.arr,"Y")==0 && strcmp(nd_br_citizen.arr,"Y")==0)
  fprintf(fp,"CITIZEN AND EPISODE TYPE \n");
    else if(strcmp(nd_br_episode_type.arr,"Y")==0 && strcmp(nd_br_citizen.arr,"N")==0)
  fprintf(fp,"EPISODE TYPE \n");
     else if(strcmp(nd_br_episode_type.arr,"N")==0 && strcmp(nd_br_citizen.arr,"Y")==0)
  fprintf(fp,"CITIZEN \n");
  else if(strcmp(nd_br_episode_type.arr,"N")==0 && strcmp(nd_br_citizen.arr,"N")==0)
  fprintf(fp,"NOT APPLICABLE \n");


  //fprintf(fp,"               AGEING ANALYSIS CODE   : %s\n\n",nd_age_analysis_code.arr);
  fprintf(fp,"                         AGEING SLOTS    \n");
  fprintf(fp,"                                      : Up to %-3s%-6s\n",age_1_value.arr,age_1_ind.arr);
   if (nd_days2 == 0) 
  fprintf(fp, "                                      : Above %-3s%-6s\n",age_1_value.arr,age_1_ind.arr);
   else
  fprintf(fp, "                                      : %-3s%-6s TO %-3s%-6s\n",age_1_value.arr,age_1_ind.arr,age_2_value.arr,age_2_ind.arr );
  if (((nd_days3==0) && (nd_days2 > 0))|| (nd_days3 > 0))
  {
  if (nd_days3==0) 
  fprintf(fp, "                                      : Above %-3s%-6s\n",age_2_value.arr,age_2_ind.arr);
     else
  fprintf(fp, "                                      : %-3s%-6s TO %-3s%-6s\n",age_2_value.arr,age_2_ind.arr,age_3_value.arr,age_3_ind.arr) ;	           
  }
   if (((nd_days4 == 0)&&(nd_days3 != 0)) || (nd_days4 != 0)) 
   {
  if (nd_days4 == 0) 
  fprintf(fp, "                                      : Above %-3s%-6s\n",age_3_value.arr,age_3_ind.arr);
        else
  fprintf(fp, "                                      : %-3s%-6s TO %-3s%-6s\n",age_3_value.arr,age_3_ind.arr,age_4_value.arr,age_4_ind.arr);	           
   }
  if (((nd_days5 == 0)&&(nd_days4 != 0))|| (nd_days5 != 0))
   {
   if(nd_days5 == 0)
  fprintf(fp, "                                      : Above %-3s%-6s\n",age_4_value.arr,age_4_ind.arr);
     else
  fprintf(fp, "                                      : %-3s%-6s TO %-3s%-6s\n",age_4_value.arr,age_4_ind.arr,age_5_value.arr,age_5_ind.arr);	           
   }

if ((nd_days5 != 0))
  fprintf(fp, "                                      : Above %-3s%-6s \n",age_5_value.arr,age_5_ind.arr);	           

next_page();
}


//-----------------------------------------------

print_header()
 {
//print_page_title();
//print_column_title();

 
 if(strcmp(nd_br_episode_type.arr,"N")==0 && strcmp(nd_br_citizen.arr,"Y")==0)
    {
    nd_tot_malay_revamt=nd_cd1_rev_outamt+nd_cd2_rev_outamt+nd_cd3_rev_outamt+nd_cd4_rev_outamt+nd_cd5_rev_outamt+nd_cd6_rev_outamt;
	nd_tot_malay_writeoffamt=nd_cd1_writeoff_amt+nd_cd2_writeoff_amt+nd_cd3_writeoff_amt+nd_cd4_writeoff_amt+nd_cd5_writeoff_amt+nd_cd6_writeoff_amt;
    nd_tot_malay_outamt=nd_cd1_tot_outamt+nd_cd2_tot_outamt+nd_cd3_tot_outamt+nd_cd4_tot_outamt+nd_cd5_tot_outamt+nd_cd6_tot_outamt;

    nd_tot_malay_pat=d1_pat_cnt+d2_pat_cnt+d3_pat_cnt+d4_pat_cnt+d5_pat_cnt+d6_pat_cnt;

	nd_tot_fore_revamt=nd_ncd1_rev_outamt+nd_ncd2_rev_outamt+nd_ncd3_rev_outamt+nd_ncd4_rev_outamt+nd_ncd5_rev_outamt+nd_ncd6_rev_outamt;
	nd_tot_fore_writeoffamt=nd_ncd1_writeoff_amt+nd_ncd2_writeoff_amt+nd_ncd3_writeoff_amt+nd_ncd4_writeoff_amt+nd_ncd5_writeoff_amt+nd_ncd6_writeoff_amt;
    nd_tot_fore_outamt=nd_ncd1_tot_outamt+nd_ncd2_tot_outamt+nd_ncd3_tot_outamt+nd_ncd4_tot_outamt+nd_ncd5_tot_outamt+nd_ncd6_tot_outamt;
	nd_tot_fore_pat=nd1_pat_cnt+nd2_pat_cnt+nd3_pat_cnt+nd4_pat_cnt+nd5_pat_cnt+nd6_pat_cnt;

    nd_grand_tot_revamt=nd_tot_malay_revamt+nd_tot_fore_revamt;
	nd_grand_tot_writeoffamt=nd_tot_malay_writeoffamt+nd_tot_fore_writeoffamt;
	nd_grand_tot_outamt =nd_tot_malay_outamt+nd_tot_fore_outamt;
	nd_grand_tot_pat=nd_tot_malay_pat+nd_tot_fore_pat;
   

// fprintf(fp, "1.  Up to %-3s%-9s%-6s   %-10.10s%5s ",age_1_value.arr,age_1_ind.arr," ",loc_legend[17]," ");
	
	sprintf(l_str1,"1. %-s %-s %-s",   	
	        loc_legend[41],age_1_value.arr,age_1_ind.arr);

	fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]);

	print_formated(nd_cd1_tot_outamt);	
	print_formated(nd_cd1_writeoff_amt);
	print_formated(nd_cd1_rev_outamt);

	fprintf(fp,"%15d",d1_pat_cnt);
	next_line(1);

	fprintf(fp, "%-24.24s       %-10.10s%5s "," ",loc_legend[18]," ") ;
	print_formated(nd_ncd1_tot_outamt);
	print_formated(nd_ncd1_writeoff_amt);
	print_formated(nd_ncd1_rev_outamt);

	fprintf(fp,"%15d",nd1_pat_cnt);
  next_line(1);
  horz_skip(31);
  print_line('-',REP_WIDTH-31);
  next_line(1);

 fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;

	print_formated(nd_cd1_tot_outamt+nd_ncd1_tot_outamt);
	print_formated(nd_cd1_writeoff_amt+nd_ncd1_writeoff_amt);
	print_formated(nd_cd1_rev_outamt+nd_ncd1_rev_outamt);
	fprintf(fp,"%15d",d1_pat_cnt+nd1_pat_cnt);
   next_line(1);
   horz_skip(31);
   print_line('-',REP_WIDTH-31);
   next_line(1);


 if (nd_days2 == 0) 
 {
   //fprintf(fp, "2.  Above %-3s%-9s%-6s   %-10.10s%5s ",age_1_value.arr,age_1_ind.arr," ",loc_legend[17]," ");

   sprintf(l_str1,"2. %-s %-s %-s",loc_legend[42],age_1_value.arr,age_1_ind.arr);
   fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 

  }
 else
 {
   //fprintf(fp, "2.  %-3s%-9sTO%3s%9s %-10.10s%5s ",age_1_value.arr,age_1_ind.arr,age_2_value.arr,age_2_ind.arr ,loc_legend[17]," ");

   sprintf(l_str1,"2. %-s %-s %s %-s %-s",
		age_1_value.arr,age_1_ind.arr,loc_legend[44],
		age_2_value.arr,age_2_ind.arr);

   fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
  }

	print_formated(nd_cd2_tot_outamt);
	print_formated(nd_cd2_writeoff_amt);
	print_formated(nd_cd2_rev_outamt);
	fprintf(fp,"%15d",d2_pat_cnt);
   next_line(1);

  fprintf(fp, "%-24.24s       %-10.10s%5s "," ",loc_legend[18]," ") ;
	print_formated(nd_ncd2_tot_outamt);
	print_formated(nd_ncd2_writeoff_amt);
	print_formated(nd_ncd2_rev_outamt);
    fprintf(fp,"%15d",nd2_pat_cnt);
  next_line(1);
  horz_skip(31);
  print_line('-',REP_WIDTH-31);
  next_line(1);

  fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;
 
	print_formated(nd_cd2_tot_outamt+nd_ncd2_tot_outamt);
	print_formated(nd_cd2_writeoff_amt+nd_ncd2_writeoff_amt);
	print_formated(nd_cd2_rev_outamt+nd_ncd2_rev_outamt);
	fprintf(fp,"%15d",d2_pat_cnt+nd2_pat_cnt);
  next_line(1);
  horz_skip(31);
  print_line('-',REP_WIDTH-31);
  next_line(1);
  
  
 if (((nd_days3==0) && (nd_days2 > 0))|| (nd_days3 > 0))
  {
   if (nd_days3==0) 
   {
     //fprintf(fp, "3.  Above %-3s%-9s%-6s   %-10.10s%5s ",age_2_value.arr,age_2_ind.arr," ",loc_legend[17]," ");
     
       sprintf(l_str1,"3. %-s %-s %-s",loc_legend[42],age_2_value.arr,age_2_ind.arr);
       fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
   } 
   else
   {
     //fprintf(fp, "3.  %-3s%-9sTO%3s%9s %-10.10s%5s ",age_2_value.arr,age_2_ind.arr,age_3_value.arr,age_3_ind.arr, loc_legend[17]," ") ;	           

     sprintf(l_str1,"3.%-s %-s %s %-s %-s",
		age_2_value.arr,age_2_ind.arr,loc_legend[44],
		age_3_value.arr,age_3_ind.arr);

     fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
   }

	print_formated(nd_cd3_tot_outamt);
	print_formated(nd_cd3_writeoff_amt);
	print_formated(nd_cd3_rev_outamt);
    fprintf(fp,"%15d",d3_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24.24s       %-10.10s%5s "," ",loc_legend[18]," ") ;

	print_formated(nd_ncd3_tot_outamt);
	print_formated(nd_ncd3_writeoff_amt);
	print_formated(nd_ncd3_rev_outamt);

    fprintf(fp,"%15d",nd3_pat_cnt);
  next_line(1);
  horz_skip(31);
  print_line('-',REP_WIDTH-31);
  next_line(1);
 fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;
 
	print_formated(nd_cd3_tot_outamt+nd_ncd3_tot_outamt);
	print_formated(nd_cd3_writeoff_amt+nd_ncd3_writeoff_amt);
	print_formated(nd_cd3_rev_outamt+nd_ncd3_rev_outamt);

    fprintf(fp,"%15d",d3_pat_cnt+nd3_pat_cnt);
  next_line(1);
  horz_skip(31);
  print_line('-',REP_WIDTH-31);
  next_line(1);

 }

  if (((nd_days4 == 0)&&(nd_days3 != 0)) || (nd_days4 != 0)) 
   {
     if (nd_days4 == 0)
     {
        //fprintf(fp, "4.  Above %-3s%-9s%-6s   %-10.10s%5s ",age_3_value.arr,age_3_ind.arr," ",loc_legend[17]," ");
	sprintf(l_str1,"4. %-s %-s %-s",loc_legend[42],age_3_value.arr,age_3_ind.arr);
        fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
     }
     else
     {
        //fprintf(fp, "4.  %-3s%-9sTO%3s%9s %-10.10s%5s ",age_3_value.arr,age_3_ind.arr,age_4_value.arr,age_4_ind.arr, loc_legend[17]," ");	           
	sprintf(l_str1,"4.%-s %-s %s %-s %-s",
		age_3_value.arr,age_3_ind.arr,loc_legend[44],
		age_4_value.arr,age_4_ind.arr);
	fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
     }


		print_formated(nd_cd4_tot_outamt);
		print_formated(nd_cd4_writeoff_amt);
		print_formated(nd_cd4_rev_outamt);

		fprintf(fp,"%15d",d4_pat_cnt);
   next_line(1);
  fprintf(fp, "%-24.24s       %-10.10s%5s "," ",loc_legend[18]," ") ;

		print_formated(nd_ncd4_tot_outamt);
		print_formated(nd_ncd4_writeoff_amt);
		print_formated(nd_ncd4_rev_outamt);

		fprintf(fp,"%15d",nd4_pat_cnt);
	next_line(1);
 	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;
 
		print_formated(nd_cd4_tot_outamt+nd_ncd4_tot_outamt);
		print_formated(nd_cd4_writeoff_amt+nd_ncd4_writeoff_amt);
		print_formated(nd_cd4_rev_outamt+nd_ncd4_rev_outamt);

		fprintf(fp,"%15d",d4_pat_cnt+nd4_pat_cnt);
	 next_line(1);
	 horz_skip(31);
	 print_line('-',REP_WIDTH-31);
	 next_line(1);

 }


   if (((nd_days5 == 0)&&(nd_days4 != 0))|| (nd_days5 != 0))
   {
     if(nd_days5 == 0)
     {
	//fprintf(fp, "5.  Above %-3s%-9s%-6s   %-10.10s%5s ",age_4_value.arr,age_4_ind.arr," ",loc_legend[17]," ");
	sprintf(l_str1,"5. %-s %-s %-s",loc_legend[42],age_4_value.arr,age_4_ind.arr);
        fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 

     }
     else
     {
	//fprintf(fp, "5.  %-3s%-9sTO%3s%9s %-10.10s%5s ",age_4_value.arr,age_4_ind.arr,age_5_value.arr,age_5_ind.arr ,loc_legend[17]," ");	           
	sprintf(l_str1,"5.%-s %-s %s %-s %-s",
		age_4_value.arr,age_4_ind.arr,loc_legend[44],
		age_5_value.arr,age_5_ind.arr);
	fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
     }

		print_formated(nd_cd5_tot_outamt);
		print_formated(nd_cd5_writeoff_amt);
		print_formated(nd_cd5_rev_outamt);
		fprintf(fp,"%15d",d5_pat_cnt);
	 next_line(1);
	 fprintf(fp, "%-24.24s       %-10s%5s "," ",loc_legend[18]," ") ;

		print_formated(nd_ncd5_tot_outamt);
		print_formated(nd_ncd5_writeoff_amt);
		print_formated(nd_ncd5_rev_outamt);

		fprintf(fp,"%15d",nd5_pat_cnt);
	 next_line(1);
	 horz_skip(31);
	 print_line('-',REP_WIDTH-31);
     next_line(1);

	 fprintf(fp, "%-24s       %-10s%5s "," ",loc_legend[19]," ") ;

		print_formated(nd_cd5_tot_outamt+nd_ncd5_tot_outamt);
		print_formated(nd_cd5_writeoff_amt+nd_ncd5_writeoff_amt);
	    print_formated(nd_cd5_rev_outamt+nd_ncd5_rev_outamt);

		fprintf(fp,"%15d",d5_pat_cnt+nd5_pat_cnt);
	 next_line(1);
	 horz_skip(31);
	 print_line('-',REP_WIDTH-31);
	 next_line(1);

  }
 if ((nd_days5 != 0))
     {
	//fprintf(fp, "6.  Above %-3s%-9s%-6s   %-10.10s%5s ",age_5_value.arr,age_5_ind.arr," ", loc_legend[17]," ");	           
	sprintf(l_str1,"6. %-s %-s %-s",loc_legend[42],age_5_value.arr,age_5_ind.arr);
        fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 

	print_formated(nd_cd6_tot_outamt);
	print_formated(nd_cd6_writeoff_amt);
	print_formated(nd_cd6_rev_outamt);

	fprintf(fp,"%15d",d6_pat_cnt);
	next_line(1);

	fprintf(fp, "%-24.24s       %-10.10s%5s "," ",loc_legend[18]," ") ;
		print_formated(nd_ncd6_tot_outamt);
		print_formated(nd_ncd6_writeoff_amt);
		print_formated(nd_ncd6_rev_outamt);

		fprintf(fp,"%15d",nd6_pat_cnt);
	
	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);

    fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;
 
		print_formated(nd_cd6_tot_outamt+nd_ncd6_tot_outamt);
		print_formated(nd_cd6_writeoff_amt+nd_ncd6_writeoff_amt);
		print_formated(nd_cd6_rev_outamt+nd_ncd6_rev_outamt);
		fprintf(fp,"%15d",d6_pat_cnt+nd6_pat_cnt);
	 next_line(1);
	 horz_skip(31);
	 print_line('-',REP_WIDTH-31);
	next_line(1);
  }
	 //next_line(7);
	 fprintf(fp, "    %-10s%10s       %-10.10s%5s ",loc_legend[19]," ",loc_legend[17]," ") ;

		print_formated(nd_tot_malay_outamt);
		print_formated(nd_tot_malay_writeoffamt);
		print_formated(nd_tot_malay_revamt);
		fprintf(fp,"%15d",nd_tot_malay_pat);
	 next_line(1);
	 fprintf(fp, "%-24.24s       %-10.10s%5s "," ",loc_legend[18]," ") ;

		print_formated(nd_tot_fore_outamt);
		print_formated(nd_tot_fore_writeoffamt);
		print_formated(nd_tot_fore_revamt);
		fprintf(fp,"%15d",nd_tot_fore_pat);
	 next_line(1);
	 print_line('-',REP_WIDTH);
	 next_line(1);
 
	 fprintf(fp, "      %15.15s%23s   ",loc_legend[20]," ") ;

		 print_formated(nd_grand_tot_outamt);
		 print_formated(nd_grand_tot_writeoffamt);
		 print_formated(nd_grand_tot_revamt);

		 fprintf(fp,"%15d",nd_grand_tot_pat);
     next_line(1);
     print_line('-',REP_WIDTH);
 }


///*************************************/

else if(strcmp(nd_br_episode_type.arr,"Y")==0 && strcmp(nd_br_citizen.arr,"Y")==0)

{

	nd_tot_malay_d1_revamt=nd_d1_ctz_epi_outamt+nd_d1_ctz_epo_outamt+nd_d1_ctz_epd_outamt+nd_d1_ctz_epe_outamt+nd_d1_ctz_epr_outamt;
	nd_tot_malay_d2_revamt=nd_d2_ctz_epi_outamt+nd_d2_ctz_epo_outamt+nd_d2_ctz_epd_outamt+nd_d2_ctz_epe_outamt+nd_d2_ctz_epr_outamt;
	nd_tot_malay_d3_revamt=nd_d3_ctz_epi_outamt+nd_d3_ctz_epo_outamt+nd_d3_ctz_epd_outamt+nd_d3_ctz_epe_outamt+nd_d3_ctz_epr_outamt;
	nd_tot_malay_d4_revamt=nd_d4_ctz_epi_outamt+nd_d4_ctz_epo_outamt+nd_d4_ctz_epd_outamt+nd_d4_ctz_epe_outamt+nd_d4_ctz_epr_outamt;
	nd_tot_malay_d5_revamt=nd_d5_ctz_epi_outamt+nd_d5_ctz_epo_outamt+nd_d5_ctz_epd_outamt+nd_d5_ctz_epe_outamt+nd_d5_ctz_epr_outamt;
	nd_tot_malay_d6_revamt=nd_d6_ctz_epi_outamt+nd_d6_ctz_epo_outamt+nd_d6_ctz_epd_outamt+nd_d6_ctz_epe_outamt+nd_d6_ctz_epr_outamt;

	nd_tot_malay_pat1=d1_ctz_epi_pat_cnt+d1_ctz_epo_pat_cnt+d1_ctz_epd_pat_cnt+d1_ctz_epe_pat_cnt+d1_ctz_epr_pat_cnt;
	nd_tot_malay_pat2=d2_ctz_epi_pat_cnt+d2_ctz_epo_pat_cnt+d2_ctz_epd_pat_cnt+d2_ctz_epe_pat_cnt+d2_ctz_epr_pat_cnt;
	nd_tot_malay_pat3=d3_ctz_epi_pat_cnt+d3_ctz_epo_pat_cnt+d3_ctz_epd_pat_cnt+d3_ctz_epe_pat_cnt+d3_ctz_epr_pat_cnt;
	nd_tot_malay_pat4=d4_ctz_epi_pat_cnt+d4_ctz_epo_pat_cnt+d4_ctz_epd_pat_cnt+d4_ctz_epe_pat_cnt+d4_ctz_epr_pat_cnt;
	nd_tot_malay_pat5=d5_ctz_epi_pat_cnt+d5_ctz_epo_pat_cnt+d5_ctz_epd_pat_cnt+d5_ctz_epe_pat_cnt+d5_ctz_epr_pat_cnt;
	nd_tot_malay_pat6=d6_ctz_epi_pat_cnt+d6_ctz_epo_pat_cnt+d6_ctz_epd_pat_cnt+d6_ctz_epe_pat_cnt+d6_ctz_epr_pat_cnt;
               
	nd_tot_mal_ip_revamt=nd_d1_ctz_epi_outamt+nd_d2_ctz_epi_outamt+nd_d3_ctz_epi_outamt+nd_d4_ctz_epi_outamt+nd_d5_ctz_epi_outamt+nd_d6_ctz_epi_outamt;
	nd_tot_mal_op_revamt=nd_d1_ctz_epo_outamt+nd_d2_ctz_epo_outamt+nd_d3_ctz_epo_outamt+nd_d4_ctz_epo_outamt+nd_d5_ctz_epo_outamt+nd_d6_ctz_epo_outamt;
	nd_tot_mal_dy_revamt=nd_d1_ctz_epd_outamt+nd_d2_ctz_epd_outamt+nd_d3_ctz_epd_outamt+nd_d4_ctz_epd_outamt+nd_d5_ctz_epd_outamt+nd_d6_ctz_epd_outamt;
	nd_tot_mal_em_revamt=nd_d1_ctz_epe_outamt+nd_d2_ctz_epe_outamt+nd_d3_ctz_epe_outamt+nd_d4_ctz_epe_outamt+nd_d5_ctz_epe_outamt+nd_d6_ctz_epe_outamt;
	nd_tot_mal_ex_revamt=nd_d1_ctz_epr_outamt+nd_d2_ctz_epr_outamt+nd_d3_ctz_epr_outamt+nd_d4_ctz_epr_outamt+nd_d5_ctz_epr_outamt+nd_d6_ctz_epr_outamt;

	nd_tot_mal_ip_pat=d1_ctz_epi_pat_cnt+d2_ctz_epi_pat_cnt+d3_ctz_epi_pat_cnt+d4_ctz_epi_pat_cnt+d5_ctz_epi_pat_cnt+d6_ctz_epi_pat_cnt;
	nd_tot_mal_op_pat=d1_ctz_epo_pat_cnt+d2_ctz_epo_pat_cnt+d3_ctz_epo_pat_cnt+d4_ctz_epo_pat_cnt+d5_ctz_epo_pat_cnt+d6_ctz_epo_pat_cnt;
	nd_tot_mal_dy_pat=d1_ctz_epd_pat_cnt+d2_ctz_epd_pat_cnt+d3_ctz_epd_pat_cnt+d4_ctz_epd_pat_cnt+d5_ctz_epd_pat_cnt+d6_ctz_epd_pat_cnt;
	nd_tot_mal_em_pat=d1_ctz_epe_pat_cnt+d2_ctz_epe_pat_cnt+d3_ctz_epe_pat_cnt+d4_ctz_epe_pat_cnt+d5_ctz_epe_pat_cnt+d6_ctz_epe_pat_cnt;
	nd_tot_mal_ex_pat=d1_ctz_epr_pat_cnt+d2_ctz_epr_pat_cnt+d3_ctz_epr_pat_cnt+d4_ctz_epr_pat_cnt+d5_ctz_epr_pat_cnt+d6_ctz_epr_pat_cnt;


	nd_tot_malay_eps_revamt=nd_tot_mal_ip_revamt+nd_tot_mal_op_revamt+nd_tot_mal_dy_revamt+nd_tot_mal_em_revamt+nd_tot_mal_ex_revamt;
	nd_tot_malay_eps_pat=nd_tot_mal_ip_pat+nd_tot_mal_op_pat+nd_tot_mal_dy_pat+nd_tot_mal_em_pat+nd_tot_mal_ex_pat;
	

	nd_tot_for_d1_revamt=nd_d1_nctz_epi_outamt+nd_d1_nctz_epo_outamt+nd_d1_nctz_epd_outamt+nd_d1_nctz_epe_outamt+nd_d1_nctz_epr_outamt;
	nd_tot_for_d2_revamt=nd_d2_nctz_epi_outamt+nd_d2_nctz_epo_outamt+nd_d2_nctz_epd_outamt+nd_d2_nctz_epe_outamt+nd_d2_nctz_epr_outamt;
	nd_tot_for_d3_revamt=nd_d3_nctz_epi_outamt+nd_d3_nctz_epo_outamt+nd_d3_nctz_epd_outamt+nd_d3_nctz_epe_outamt+nd_d3_nctz_epr_outamt;
	nd_tot_for_d4_revamt=nd_d4_nctz_epi_outamt+nd_d4_nctz_epo_outamt+nd_d4_nctz_epd_outamt+nd_d4_nctz_epe_outamt+nd_d4_nctz_epr_outamt;
	nd_tot_for_d5_revamt=nd_d5_nctz_epi_outamt+nd_d5_nctz_epo_outamt+nd_d5_nctz_epd_outamt+nd_d5_nctz_epe_outamt+nd_d5_nctz_epr_outamt;
	nd_tot_for_d6_revamt=nd_d6_nctz_epi_outamt+nd_d6_nctz_epo_outamt+nd_d6_nctz_epd_outamt+nd_d6_nctz_epe_outamt+nd_d6_nctz_epr_outamt;


	nd_tot_for_ip_revamt=nd_d1_nctz_epi_outamt+nd_d2_nctz_epi_outamt+nd_d3_nctz_epi_outamt+nd_d4_nctz_epi_outamt+nd_d5_nctz_epi_outamt+nd_d6_nctz_epi_outamt;
	nd_tot_for_op_revamt=nd_d1_nctz_epo_outamt+nd_d2_nctz_epo_outamt+nd_d3_nctz_epo_outamt+nd_d4_nctz_epo_outamt+nd_d5_nctz_epo_outamt+nd_d6_nctz_epo_outamt;
	nd_tot_for_dy_revamt=nd_d1_nctz_epd_outamt+nd_d2_nctz_epd_outamt+nd_d3_nctz_epd_outamt+nd_d4_nctz_epd_outamt+nd_d5_nctz_epd_outamt+nd_d6_nctz_epd_outamt;
	nd_tot_for_em_revamt=nd_d1_nctz_epe_outamt+nd_d2_nctz_epe_outamt+nd_d3_nctz_epe_outamt+nd_d4_nctz_epe_outamt+nd_d5_nctz_epe_outamt+nd_d6_nctz_epe_outamt;
	nd_tot_for_ex_revamt=nd_d1_nctz_epr_outamt+nd_d2_nctz_epr_outamt+nd_d3_nctz_epr_outamt+nd_d4_nctz_epr_outamt+nd_d5_nctz_epr_outamt+nd_d6_nctz_epr_outamt;

	nd_tot_for_eps_revamt=nd_tot_for_ip_revamt+nd_tot_for_op_revamt+nd_tot_for_dy_revamt+nd_tot_for_em_revamt+nd_tot_for_ex_revamt;
	
	nd_tot_for_pat1=d1_nctz_epi_pat_cnt+d1_nctz_epo_pat_cnt+d1_nctz_epd_pat_cnt+d1_nctz_epe_pat_cnt+d1_nctz_epr_pat_cnt;
	nd_tot_for_pat2=d2_nctz_epi_pat_cnt+d2_nctz_epo_pat_cnt+d2_nctz_epd_pat_cnt+d2_nctz_epe_pat_cnt+d2_nctz_epr_pat_cnt;
	nd_tot_for_pat3=d3_nctz_epi_pat_cnt+d3_nctz_epo_pat_cnt+d3_nctz_epd_pat_cnt+d3_nctz_epe_pat_cnt+d3_nctz_epr_pat_cnt;
	nd_tot_for_pat4=d4_nctz_epi_pat_cnt+d4_nctz_epo_pat_cnt+d4_nctz_epd_pat_cnt+d4_nctz_epe_pat_cnt+d4_nctz_epr_pat_cnt;
	nd_tot_for_pat5=d5_nctz_epi_pat_cnt+d5_nctz_epo_pat_cnt+d5_nctz_epd_pat_cnt+d5_nctz_epe_pat_cnt+d5_nctz_epr_pat_cnt;
	nd_tot_for_pat6=d6_nctz_epi_pat_cnt+d6_nctz_epo_pat_cnt+d6_nctz_epd_pat_cnt+d6_nctz_epe_pat_cnt+d6_nctz_epr_pat_cnt;



	nd_tot_for_ip_pat=d1_nctz_epi_pat_cnt+d2_nctz_epi_pat_cnt+d3_nctz_epi_pat_cnt+d4_nctz_epi_pat_cnt+d5_nctz_epi_pat_cnt+d6_nctz_epi_pat_cnt;
	nd_tot_for_op_pat=d1_nctz_epo_pat_cnt+d2_nctz_epo_pat_cnt+d3_nctz_epo_pat_cnt+d4_nctz_epo_pat_cnt+d5_nctz_epo_pat_cnt+d6_nctz_epo_pat_cnt;
	nd_tot_for_dy_pat=d1_nctz_epd_pat_cnt+d2_nctz_epd_pat_cnt+d3_nctz_epd_pat_cnt+d4_nctz_epd_pat_cnt+d5_nctz_epd_pat_cnt+d6_nctz_epd_pat_cnt;
	nd_tot_for_em_pat=d1_nctz_epe_pat_cnt+d2_nctz_epe_pat_cnt+d3_nctz_epe_pat_cnt+d4_nctz_epe_pat_cnt+d5_nctz_epe_pat_cnt+d6_nctz_epe_pat_cnt;
	nd_tot_for_ex_pat=d1_nctz_epr_pat_cnt+d2_nctz_epr_pat_cnt+d3_nctz_epr_pat_cnt+d4_nctz_epr_pat_cnt+d5_nctz_epr_pat_cnt+d6_nctz_epr_pat_cnt;

	nd_tot_for_eps_pat=nd_tot_for_ip_pat+nd_tot_for_op_pat+nd_tot_for_dy_pat+nd_tot_for_em_pat+nd_tot_for_ex_pat;


	//----------------------------Write offf

	nd_tot_malay_d1_writeoff_amt=nd_d1_ctz_epi_writeoff_amt+nd_d1_ctz_epo_writeoff_amt+nd_d1_ctz_epd_writeoff_amt+nd_d1_ctz_epe_writeoff_amt+nd_d1_ctz_epr_writeoff_amt;
	nd_tot_malay_d2_writeoff_amt=nd_d2_ctz_epi_writeoff_amt+nd_d2_ctz_epo_writeoff_amt+nd_d2_ctz_epd_writeoff_amt+nd_d2_ctz_epe_writeoff_amt+nd_d2_ctz_epr_writeoff_amt;
	nd_tot_malay_d3_writeoff_amt=nd_d3_ctz_epi_writeoff_amt+nd_d3_ctz_epo_writeoff_amt+nd_d3_ctz_epd_writeoff_amt+nd_d3_ctz_epe_writeoff_amt+nd_d3_ctz_epr_writeoff_amt;
	nd_tot_malay_d4_writeoff_amt=nd_d4_ctz_epi_writeoff_amt+nd_d4_ctz_epo_writeoff_amt+nd_d4_ctz_epd_writeoff_amt+nd_d4_ctz_epe_writeoff_amt+nd_d4_ctz_epr_writeoff_amt;
	nd_tot_malay_d5_writeoff_amt=nd_d5_ctz_epi_writeoff_amt+nd_d5_ctz_epo_writeoff_amt+nd_d5_ctz_epd_writeoff_amt+nd_d5_ctz_epe_writeoff_amt+nd_d5_ctz_epr_writeoff_amt;
	nd_tot_malay_d6_writeoff_amt=nd_d6_ctz_epi_writeoff_amt+nd_d6_ctz_epo_writeoff_amt+nd_d6_ctz_epd_writeoff_amt+nd_d6_ctz_epe_writeoff_amt+nd_d6_ctz_epr_writeoff_amt;
	
               
	nd_tot_mal_ip_writeoff_amt=nd_d1_ctz_epi_writeoff_amt+nd_d2_ctz_epi_writeoff_amt+nd_d3_ctz_epi_writeoff_amt+nd_d4_ctz_epi_writeoff_amt+nd_d5_ctz_epi_writeoff_amt+nd_d6_ctz_epi_writeoff_amt;
	nd_tot_mal_op_writeoff_amt=nd_d1_ctz_epo_writeoff_amt+nd_d2_ctz_epo_writeoff_amt+nd_d3_ctz_epo_writeoff_amt+nd_d4_ctz_epo_writeoff_amt+nd_d5_ctz_epo_writeoff_amt+nd_d6_ctz_epo_writeoff_amt;
	nd_tot_mal_dy_writeoff_amt=nd_d1_ctz_epd_writeoff_amt+nd_d2_ctz_epd_writeoff_amt+nd_d3_ctz_epd_writeoff_amt+nd_d4_ctz_epd_writeoff_amt+nd_d5_ctz_epd_writeoff_amt+nd_d6_ctz_epd_writeoff_amt;
	nd_tot_mal_em_writeoff_amt=nd_d1_ctz_epe_writeoff_amt+nd_d2_ctz_epe_writeoff_amt+nd_d3_ctz_epe_writeoff_amt+nd_d4_ctz_epe_writeoff_amt+nd_d5_ctz_epe_writeoff_amt+nd_d6_ctz_epe_writeoff_amt;
	nd_tot_mal_ex_writeoff_amt=nd_d1_ctz_epr_writeoff_amt+nd_d2_ctz_epr_writeoff_amt+nd_d3_ctz_epr_writeoff_amt+nd_d4_ctz_epr_writeoff_amt+nd_d5_ctz_epr_writeoff_amt+nd_d6_ctz_epr_writeoff_amt;
	

	nd_tot_malay_eps_writeoff_amt=nd_tot_mal_ip_writeoff_amt+nd_tot_mal_op_writeoff_amt+nd_tot_mal_dy_writeoff_amt+nd_tot_mal_em_writeoff_amt+nd_tot_mal_ex_writeoff_amt;
	


	nd_tot_for_d1_writeoff_amt=nd_d1_nctz_epi_writeoff_amt+nd_d1_nctz_epo_writeoff_amt+nd_d1_nctz_epd_writeoff_amt+nd_d1_nctz_epe_writeoff_amt+nd_d1_nctz_epr_writeoff_amt;
	nd_tot_for_d2_writeoff_amt=nd_d2_nctz_epi_writeoff_amt+nd_d2_nctz_epo_writeoff_amt+nd_d2_nctz_epd_writeoff_amt+nd_d2_nctz_epe_writeoff_amt+nd_d2_nctz_epr_writeoff_amt;
	nd_tot_for_d3_writeoff_amt=nd_d3_nctz_epi_writeoff_amt+nd_d3_nctz_epo_writeoff_amt+nd_d3_nctz_epd_writeoff_amt+nd_d3_nctz_epe_writeoff_amt+nd_d3_nctz_epr_writeoff_amt;
	nd_tot_for_d4_writeoff_amt=nd_d4_nctz_epi_writeoff_amt+nd_d4_nctz_epo_writeoff_amt+nd_d4_nctz_epd_writeoff_amt+nd_d4_nctz_epe_writeoff_amt+nd_d4_nctz_epr_writeoff_amt;
	nd_tot_for_d5_writeoff_amt=nd_d5_nctz_epi_writeoff_amt+nd_d5_nctz_epo_writeoff_amt+nd_d5_nctz_epd_writeoff_amt+nd_d5_nctz_epe_writeoff_amt+nd_d5_nctz_epr_writeoff_amt;
	nd_tot_for_d6_writeoff_amt=nd_d6_nctz_epi_writeoff_amt+nd_d6_nctz_epo_writeoff_amt+nd_d6_nctz_epd_writeoff_amt+nd_d6_nctz_epe_writeoff_amt+nd_d6_nctz_epr_writeoff_amt;


	nd_tot_for_ip_writeoff_amt=nd_d1_nctz_epi_writeoff_amt+nd_d2_nctz_epi_writeoff_amt+nd_d3_nctz_epi_writeoff_amt+nd_d4_nctz_epi_writeoff_amt+nd_d5_nctz_epi_writeoff_amt+nd_d6_nctz_epi_writeoff_amt;
	nd_tot_for_op_writeoff_amt=nd_d1_nctz_epo_writeoff_amt+nd_d2_nctz_epo_writeoff_amt+nd_d3_nctz_epo_writeoff_amt+nd_d4_nctz_epo_writeoff_amt+nd_d5_nctz_epo_writeoff_amt+nd_d6_nctz_epo_writeoff_amt;
	nd_tot_for_dy_writeoff_amt=nd_d1_nctz_epd_writeoff_amt+nd_d2_nctz_epd_writeoff_amt+nd_d3_nctz_epd_writeoff_amt+nd_d4_nctz_epd_writeoff_amt+nd_d5_nctz_epd_writeoff_amt+nd_d6_nctz_epd_writeoff_amt;
	nd_tot_for_em_writeoff_amt=nd_d1_nctz_epe_writeoff_amt+nd_d2_nctz_epe_writeoff_amt+nd_d3_nctz_epe_writeoff_amt+nd_d4_nctz_epe_writeoff_amt+nd_d5_nctz_epe_writeoff_amt+nd_d6_nctz_epe_writeoff_amt;
	nd_tot_for_ex_writeoff_amt=nd_d1_nctz_epr_writeoff_amt+nd_d2_nctz_epr_writeoff_amt+nd_d3_nctz_epr_writeoff_amt+nd_d4_nctz_epr_writeoff_amt+nd_d5_nctz_epr_writeoff_amt+nd_d6_nctz_epr_writeoff_amt;

	nd_tot_for_eps_writeoff_amt=nd_tot_for_ip_writeoff_amt+nd_tot_for_op_writeoff_amt+nd_tot_for_dy_writeoff_amt+nd_tot_for_em_writeoff_amt+nd_tot_for_ex_writeoff_amt;

//--------------------------tot 


	nd_tot_malay_d1_outamt=nd_d1_ctz_epi_tot_outamt+nd_d1_ctz_epo_tot_outamt+nd_d1_ctz_epd_tot_outamt+nd_d1_ctz_epe_tot_outamt+nd_d1_ctz_epr_tot_outamt;
	nd_tot_malay_d2_outamt=nd_d2_ctz_epi_tot_outamt+nd_d2_ctz_epo_tot_outamt+nd_d2_ctz_epd_tot_outamt+nd_d2_ctz_epe_tot_outamt+nd_d2_ctz_epr_tot_outamt;
	nd_tot_malay_d3_outamt=nd_d3_ctz_epi_tot_outamt+nd_d3_ctz_epo_tot_outamt+nd_d3_ctz_epd_tot_outamt+nd_d3_ctz_epe_tot_outamt+nd_d3_ctz_epr_tot_outamt;
	nd_tot_malay_d4_outamt=nd_d4_ctz_epi_tot_outamt+nd_d4_ctz_epo_tot_outamt+nd_d4_ctz_epd_tot_outamt+nd_d4_ctz_epe_tot_outamt+nd_d4_ctz_epr_tot_outamt;
	nd_tot_malay_d5_outamt=nd_d5_ctz_epi_tot_outamt+nd_d5_ctz_epo_tot_outamt+nd_d5_ctz_epd_tot_outamt+nd_d5_ctz_epe_tot_outamt+nd_d5_ctz_epr_tot_outamt;
	nd_tot_malay_d6_outamt=nd_d6_ctz_epi_tot_outamt+nd_d6_ctz_epo_tot_outamt+nd_d6_ctz_epd_tot_outamt+nd_d6_ctz_epe_tot_outamt+nd_d6_ctz_epr_tot_outamt;

               
	nd_tot_mal_ip_outamt=nd_d1_ctz_epi_tot_outamt+nd_d2_ctz_epi_tot_outamt+nd_d3_ctz_epi_tot_outamt+nd_d4_ctz_epi_tot_outamt+nd_d5_ctz_epi_tot_outamt+nd_d6_ctz_epi_tot_outamt;
	nd_tot_mal_op_outamt=nd_d1_ctz_epo_tot_outamt+nd_d2_ctz_epo_tot_outamt+nd_d3_ctz_epo_tot_outamt+nd_d4_ctz_epo_tot_outamt+nd_d5_ctz_epo_tot_outamt+nd_d6_ctz_epo_tot_outamt;
	nd_tot_mal_dy_outamt=nd_d1_ctz_epd_tot_outamt+nd_d2_ctz_epd_tot_outamt+nd_d3_ctz_epd_tot_outamt+nd_d4_ctz_epd_tot_outamt+nd_d5_ctz_epd_tot_outamt+nd_d6_ctz_epd_tot_outamt;
	nd_tot_mal_em_outamt=nd_d1_ctz_epe_tot_outamt+nd_d2_ctz_epe_tot_outamt+nd_d3_ctz_epe_tot_outamt+nd_d4_ctz_epe_tot_outamt+nd_d5_ctz_epe_tot_outamt+nd_d6_ctz_epe_tot_outamt;
	nd_tot_mal_ex_outamt=nd_d1_ctz_epr_tot_outamt+nd_d2_ctz_epr_tot_outamt+nd_d3_ctz_epr_tot_outamt+nd_d4_ctz_epr_tot_outamt+nd_d5_ctz_epr_tot_outamt+nd_d6_ctz_epr_tot_outamt;




	nd_tot_malay_eps_outamt=nd_tot_mal_ip_outamt+nd_tot_mal_op_outamt+nd_tot_mal_dy_outamt+nd_tot_mal_em_outamt+nd_tot_mal_ex_outamt;


	nd_tot_for_d1_outamt=nd_d1_nctz_epi_tot_outamt+nd_d1_nctz_epo_tot_outamt+nd_d1_nctz_epd_tot_outamt+nd_d1_nctz_epe_tot_outamt+nd_d1_nctz_epr_tot_outamt;
	nd_tot_for_d2_outamt=nd_d2_nctz_epi_tot_outamt+nd_d2_nctz_epo_tot_outamt+nd_d2_nctz_epd_tot_outamt+nd_d2_nctz_epe_tot_outamt+nd_d2_nctz_epr_tot_outamt;
	nd_tot_for_d3_outamt=nd_d3_nctz_epi_tot_outamt+nd_d3_nctz_epo_tot_outamt+nd_d3_nctz_epd_tot_outamt+nd_d3_nctz_epe_tot_outamt+nd_d3_nctz_epr_tot_outamt;
	nd_tot_for_d4_outamt=nd_d4_nctz_epi_tot_outamt+nd_d4_nctz_epo_tot_outamt+nd_d4_nctz_epd_tot_outamt+nd_d4_nctz_epe_tot_outamt+nd_d4_nctz_epr_tot_outamt;
	nd_tot_for_d5_outamt=nd_d5_nctz_epi_tot_outamt+nd_d5_nctz_epo_tot_outamt+nd_d5_nctz_epd_tot_outamt+nd_d5_nctz_epe_tot_outamt+nd_d5_nctz_epr_tot_outamt;
	nd_tot_for_d6_outamt=nd_d6_nctz_epi_tot_outamt+nd_d6_nctz_epo_tot_outamt+nd_d6_nctz_epd_tot_outamt+nd_d6_nctz_epe_tot_outamt+nd_d6_nctz_epr_tot_outamt;

               
	nd_tot_for_ip_outamt=nd_d1_nctz_epi_tot_outamt+nd_d2_nctz_epi_tot_outamt+nd_d3_nctz_epi_tot_outamt+nd_d4_nctz_epi_tot_outamt+nd_d5_nctz_epi_tot_outamt+nd_d6_nctz_epi_tot_outamt;
	nd_tot_for_op_outamt=nd_d1_nctz_epo_tot_outamt+nd_d2_nctz_epo_tot_outamt+nd_d3_nctz_epo_tot_outamt+nd_d4_nctz_epo_tot_outamt+nd_d5_nctz_epo_tot_outamt+nd_d6_nctz_epo_tot_outamt;
	nd_tot_for_dy_outamt=nd_d1_nctz_epd_tot_outamt+nd_d2_nctz_epd_tot_outamt+nd_d3_nctz_epd_tot_outamt+nd_d4_nctz_epd_tot_outamt+nd_d5_nctz_epd_tot_outamt+nd_d6_nctz_epd_tot_outamt;
	nd_tot_for_em_outamt=nd_d1_nctz_epe_tot_outamt+nd_d2_nctz_epe_tot_outamt+nd_d3_nctz_epe_tot_outamt+nd_d4_nctz_epe_tot_outamt+nd_d5_nctz_epe_tot_outamt+nd_d6_nctz_epe_tot_outamt;
	nd_tot_for_ex_outamt=nd_d1_nctz_epr_tot_outamt+nd_d2_nctz_epr_tot_outamt+nd_d3_nctz_epr_tot_outamt+nd_d4_nctz_epr_tot_outamt+nd_d5_nctz_epr_tot_outamt+nd_d6_nctz_epr_tot_outamt;
	
	nd_tot_for_eps_outamt=nd_tot_for_ip_outamt+nd_tot_for_op_outamt+nd_tot_for_dy_outamt+nd_tot_for_em_outamt+nd_tot_for_ex_outamt;
	

	//fprintf(fp, "1.  Up to %-3s%-8.8s%-4s     %-10s%5s ",age_1_value.arr,age_1_ind.arr," ",loc_legend[17]," ");
	sprintf(l_str1,"1. %-s %-s %-s",   	
	        loc_legend[41],age_1_value.arr,age_1_ind.arr);
	fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]);

 	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[31]," ");
 
		print_formated(nd_d1_ctz_epi_tot_outamt);
		print_formated(nd_d1_ctz_epi_writeoff_amt);
		print_formated(nd_d1_ctz_epi_outamt);
		fprintf(fp,"%15d",d1_ctz_epi_pat_cnt);
    next_line(1);

	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");

		print_formated(nd_d1_ctz_epd_tot_outamt);
		print_formated(nd_d1_ctz_epd_writeoff_amt);
		print_formated(nd_d1_ctz_epd_outamt);
		fprintf(fp,"%15d",d1_ctz_epd_pat_cnt);
	next_line(1);

	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[33]," ");
 
		print_formated(nd_d1_ctz_epo_tot_outamt);
		print_formated(nd_d1_ctz_epo_writeoff_amt);
		print_formated(nd_d1_ctz_epo_outamt);
		fprintf(fp,"%15d",d1_ctz_epo_pat_cnt);

	 next_line(1);

	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[34]," ");
 
		print_formated(nd_d1_ctz_epe_tot_outamt);
		print_formated(nd_d1_ctz_epe_writeoff_amt);
		print_formated(nd_d1_ctz_epe_outamt);
	    fprintf(fp,"%15d",d1_ctz_epe_pat_cnt);

	 next_line(1);

    fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[35]," ");
 
		print_formated(nd_d1_ctz_epr_tot_outamt);
		print_formated(nd_d1_ctz_epr_writeoff_amt);
		print_formated(nd_d1_ctz_epr_outamt);
		fprintf(fp,"%15d",d1_ctz_epr_pat_cnt);

	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
    next_line(1);
	fprintf(fp,"%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;

		print_formated(nd_tot_malay_d1_outamt);
		print_formated(nd_tot_malay_d1_writeoff_amt);
		print_formated(nd_tot_malay_d1_revamt);
		fprintf(fp,"%15d",nd_tot_malay_pat1);

	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);

	fprintf(fp, "%-24.24s       %-10.10s%5s  "," ",loc_legend[18]," ") ;	next_line(1);

	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[31]," ");
 
		print_formated(nd_d1_nctz_epi_tot_outamt);
		print_formated(nd_d1_nctz_epi_writeoff_amt);
		print_formated(nd_d1_nctz_epi_outamt);
		fprintf(fp,"%15d",d1_nctz_epi_pat_cnt);

	next_line(1);

	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");
 
		print_formated(nd_d1_nctz_epd_tot_outamt);
		print_formated(nd_d1_nctz_epd_writeoff_amt);
		print_formated(nd_d1_nctz_epd_outamt);
		fprintf(fp,"%15d",d1_nctz_epd_pat_cnt);

	next_line(1);

	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[33]," ");
 
		print_formated(nd_d1_nctz_epo_tot_outamt);
		print_formated(nd_d1_nctz_epo_writeoff_amt);
		print_formated(nd_d1_nctz_epo_outamt);
		fprintf(fp,"%15d",d1_nctz_epo_pat_cnt);

	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[34]," ");
 
		print_formated(nd_d1_nctz_epe_tot_outamt);
		print_formated(nd_d1_nctz_epe_writeoff_amt);
		print_formated(nd_d1_nctz_epe_outamt);
		fprintf(fp,"%15d",d1_nctz_epe_pat_cnt);

	next_line(1);
    fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[35]," ");
 
		print_formated(nd_d1_nctz_epr_tot_outamt);
		print_formated(nd_d1_nctz_epr_writeoff_amt);
	    print_formated(nd_d1_nctz_epr_outamt);
		fprintf(fp,"%15d",d1_nctz_epr_pat_cnt);

	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
    next_line(1);
	fprintf(fp,"%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;

		print_formated(nd_tot_for_d1_outamt);
		print_formated(nd_tot_for_d1_writeoff_amt);
		print_formated(nd_tot_for_d1_revamt);
		fprintf(fp,"%15d",nd_tot_for_pat1);

	next_line(1);
	print_line('-',REP_WIDTH);
	next_line(1);
	fprintf(fp, "%-24s      %-10.10s%6s "," ",loc_legend[36]," ") ;

		print_formated(nd_tot_malay_d1_outamt+nd_tot_for_d1_outamt);
		print_formated(nd_tot_malay_d1_writeoff_amt+nd_tot_for_d1_writeoff_amt);
		print_formated(nd_tot_malay_d1_revamt+nd_tot_for_d1_revamt);
		fprintf(fp,"%15d",nd_tot_malay_pat1+nd_tot_for_pat1);

	next_line(1);
	print_line('-',REP_WIDTH);
	next_line(20);
	next_line(1);

//-------------------------------------------------------------------


 if (nd_days2 == 0)
 {
	//fprintf(fp, "2.  Above %-3s%-8.8s%-4s     %-10s%5s ",age_1_value.arr,age_1_ind.arr," ",loc_legend[17]," ");
	sprintf(l_str1,"2. %-s %-s %-s",loc_legend[42],age_1_value.arr,age_1_ind.arr);
        fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
 }
  else
 {
	//fprintf(fp, "2.  %-3s%-8.8sTO%3s%8.8s  %-10s%5s ",age_1_value.arr,age_1_ind.arr,age_2_value.arr,age_2_ind.arr ,loc_legend[17]," ");
	sprintf(l_str1,"2. %-s %-s %s %-s %-s",
		age_1_value.arr,age_1_ind.arr,loc_legend[44],
		age_2_value.arr,age_2_ind.arr);
	fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
 }
	next_line(1);
   fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[31]," ");
 
		print_formated(nd_d2_ctz_epi_tot_outamt);
		print_formated(nd_d2_ctz_epi_writeoff_amt);
	    print_formated(nd_d2_ctz_epi_outamt);
		fprintf(fp,"%15d",d2_ctz_epi_pat_cnt);

   next_line(1);
   fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");

		 print_formated(nd_d2_ctz_epd_tot_outamt);
         print_formated(nd_d2_ctz_epd_writeoff_amt);
		 print_formated(nd_d2_ctz_epd_outamt);

		 fprintf(fp,"%15d",d2_ctz_epd_pat_cnt);

   next_line(1);
   fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[33]," ");
 
		print_formated(nd_d2_ctz_epo_tot_outamt);
		print_formated(nd_d2_ctz_epo_writeoff_amt);
		print_formated(nd_d2_ctz_epo_outamt);
		fprintf(fp,"%15d",d2_ctz_epo_pat_cnt);

	next_line(1);
    fprintf(fp,"%-24s       %-10.10s%5s "," ",loc_legend[34]," ");
 
		print_formated(nd_d2_ctz_epe_tot_outamt);
		print_formated(nd_d2_ctz_epe_writeoff_amt);
		print_formated(nd_d2_ctz_epe_outamt);
		fprintf(fp,"%15d",d2_ctz_epe_pat_cnt);

	next_line(1);
    fprintf(fp,"%-24s       %-10.10s%5s "," ",loc_legend[35]," ");
 
		print_formated(nd_d2_ctz_epr_tot_outamt);
		print_formated(nd_d2_ctz_epr_writeoff_amt);
	    print_formated(nd_d2_ctz_epr_outamt);
		fprintf(fp,"%15d",d2_ctz_epr_pat_cnt);

	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);

	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;

		print_formated(nd_tot_malay_d2_outamt);
		print_formated(nd_tot_malay_d2_writeoff_amt);
		print_formated(nd_tot_malay_d2_revamt);

		fprintf(fp,"%15d",nd_tot_malay_pat2);

	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);

	fprintf(fp, "%-24.24s       %-10.10s%5s "," ",loc_legend[18]," ") ;
	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[31]," ");
 

		print_formated(nd_d2_nctz_epi_tot_outamt);
		print_formated(nd_d2_nctz_epi_writeoff_amt);
		print_formated(nd_d2_nctz_epi_outamt);
		fprintf(fp,"%15d",d2_nctz_epi_pat_cnt);

	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");
 
		print_formated(nd_d2_nctz_epd_tot_outamt);
		print_formated(nd_d2_nctz_epd_writeoff_amt);
		print_formated(nd_d2_nctz_epd_outamt);
		fprintf(fp,"%15d",d2_nctz_epd_pat_cnt);

	next_line(1);
	fprintf(fp,"%-24s       %-10.10s%5s "," ",loc_legend[33]," ");
 
		print_formated(nd_d2_nctz_epo_tot_outamt);
		print_formated(nd_d2_nctz_epo_writeoff_amt);
		print_formated(nd_d2_nctz_epo_outamt);
		fprintf(fp,"%15d",d2_nctz_epo_pat_cnt);

	next_line(1);
    fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[34]," ");
 
		print_formated(nd_d2_nctz_epe_tot_outamt);
		print_formated(nd_d2_nctz_epe_writeoff_amt);
		print_formated(nd_d2_nctz_epe_outamt);
		fprintf(fp,"%15d",d2_nctz_epe_pat_cnt);

	next_line(1);
     fprintf(fp,"%-24s       %-10.10s%5s "," ",loc_legend[35]," ");
 
		print_formated(nd_d2_nctz_epr_tot_outamt);
		print_formated(nd_d2_nctz_epr_writeoff_amt);
		print_formated(nd_d2_nctz_epr_outamt);
		fprintf(fp,"%15d",d2_nctz_epr_pat_cnt);

	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;

		print_formated(nd_tot_for_d2_outamt);
		print_formated(nd_tot_for_d2_writeoff_amt);
		print_formated(nd_tot_for_d2_revamt);

		fprintf(fp,"%15d",nd_tot_for_pat2);

	next_line(1);
	print_line('-',REP_WIDTH);
	next_line(1);
	fprintf(fp,"%-24s      %-10.10s%6s "," ",loc_legend[36]," ") ;

		print_formated(nd_tot_malay_d2_outamt+nd_tot_for_d2_outamt);
		print_formated(nd_tot_malay_d2_writeoff_amt+nd_tot_for_d2_writeoff_amt);
		print_formated(nd_tot_malay_d2_revamt+nd_tot_for_d2_revamt);
		fprintf(fp,"%15d",nd_tot_malay_pat2+nd_tot_for_pat2);
	next_line(1);
	print_line('-',REP_WIDTH);
	next_line(1);
	next_line(20); next_line(1);

  	
   
 if (((nd_days3==0) && (nd_days2 > 0))|| (nd_days3 > 0))
  {	
     if (nd_days3 == 0) 
     {
	//fprintf(fp, "3.  Above %-3s%-8.8s%-4s     %-10s%5s ",age_2_value.arr,age_2_ind.arr," ",loc_legend[17]," ");
	sprintf(l_str1,"3. %-s %-s %-s",loc_legend[42],age_2_value.arr,age_2_ind.arr);
        fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
     }
     else
     {
	//fprintf(fp, "3.  %-3s%-8.8sTO%3s%8.8s  %-10s%5s ",age_2_value.arr,age_2_ind.arr,age_3_value.arr,age_3_ind.arr, loc_legend[17]," ") ;
	sprintf(l_str1,"3.%-s %-s %s %-s %-s",
		age_2_value.arr,age_2_ind.arr,loc_legend[44],
		age_3_value.arr,age_3_ind.arr);
	fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
     }

	  next_line(1);	           
	  fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[31]," ");
 
		print_formated(nd_d3_ctz_epi_tot_outamt);
		print_formated(nd_d3_ctz_epi_writeoff_amt);
		print_formated(nd_d3_ctz_epi_outamt);
		fprintf(fp,"%15d",d3_ctz_epi_pat_cnt);

	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");
 
		print_formated(nd_d3_ctz_epd_tot_outamt);
		print_formated(nd_d3_ctz_epd_writeoff_amt);
		print_formated(nd_d3_ctz_epd_outamt);

		fprintf(fp,"%15d",d3_ctz_epd_pat_cnt);

	next_line(1);
	fprintf(fp,"%-24s       %-10.10s%5s "," ",loc_legend[33]," ");
 
		print_formated(nd_d3_ctz_epo_tot_outamt);
		print_formated(nd_d3_ctz_epo_writeoff_amt);
		print_formated(nd_d3_ctz_epo_outamt);

		fprintf(fp,"%15d",d3_ctz_epo_pat_cnt);

	next_line(1);
    fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[34]," ");
 
    	print_formated(nd_d3_ctz_epe_tot_outamt);
		print_formated(nd_d3_ctz_epe_writeoff_amt);
		print_formated(nd_d3_ctz_epe_outamt);
	
		fprintf(fp,"%15d",d3_ctz_epe_pat_cnt);

	 next_line(1);
     fprintf(fp,"%-24s       %-10.10s%5s "," ",loc_legend[35]," ");
 
		print_formated(nd_d3_ctz_epr_tot_outamt);
		print_formated(nd_d3_ctz_epr_writeoff_amt);
		print_formated(nd_d3_ctz_epr_outamt);
		fprintf(fp,"%15d",d3_ctz_epr_pat_cnt);

	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);

	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;

		print_formated(nd_tot_malay_d3_outamt);	
		print_formated(nd_tot_malay_d3_writeoff_amt);
		print_formated(nd_tot_malay_d3_revamt);

		fprintf(fp,"%15d",nd_tot_malay_pat3);

	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);


fprintf(fp, "%-24.24s       %-10.10s%5s "," ",loc_legend[18]," ") ;	next_line(1);
fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[31]," ");
 
		print_formated(nd_d3_nctz_epi_tot_outamt);
		print_formated(nd_d3_nctz_epi_writeoff_amt);
		print_formated(nd_d3_nctz_epi_outamt);

		fprintf(fp,"%15d",d3_nctz_epi_pat_cnt);

   next_line(1);
   fprintf(fp,"%-24s       %-10.10s%5s "," ",loc_legend[32]," ");
 
		print_formated(nd_d3_nctz_epd_tot_outamt);
		print_formated(nd_d3_nctz_epd_writeoff_amt);
		print_formated(nd_d3_nctz_epd_outamt);

		fprintf(fp,"%15d",d3_nctz_epd_pat_cnt);

	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[33]," ");
 
		print_formated(nd_d3_nctz_epo_tot_outamt);
		print_formated(nd_d3_nctz_epo_writeoff_amt);
		print_formated(nd_d3_nctz_epo_outamt);

	    fprintf(fp,"%15d",d3_nctz_epo_pat_cnt);

   next_line(1);
   fprintf(fp,"%-24s       %-10.10s%5s "," ",loc_legend[34]," ");
 
		print_formated(nd_d3_nctz_epe_tot_outamt);
		print_formated(nd_d3_nctz_epe_writeoff_amt);
		print_formated(nd_d3_nctz_epe_outamt);

		fprintf(fp,"%15d",d3_nctz_epe_pat_cnt);

   next_line(1);
   fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[35]," ");
 
		print_formated(nd_d3_nctz_epr_tot_outamt);
		print_formated(nd_d3_nctz_epr_writeoff_amt);
		print_formated(nd_d3_nctz_epr_outamt);
		fprintf(fp,"%15d",d3_nctz_epr_pat_cnt);

    next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;

		print_formated(nd_tot_for_d3_outamt);
		print_formated(nd_tot_for_d3_writeoff_amt);
		print_formated(nd_tot_for_d3_revamt);

		fprintf(fp,"%15d",nd_tot_for_pat3);
    next_line(1);
	print_line('-',REP_WIDTH);
	next_line(1);
	fprintf(fp, "%-24s      %-10.10s%6s "," ",loc_legend[36]," ") ;

		print_formated(nd_tot_malay_d3_outamt+nd_tot_for_d3_outamt);
		print_formated(nd_tot_malay_d3_writeoff_amt+nd_tot_for_d3_writeoff_amt);
		print_formated(nd_tot_malay_d3_revamt+nd_tot_for_d3_revamt);
		fprintf(fp,"%15d",nd_tot_malay_pat3+nd_tot_for_pat3);
    next_line(1);
    print_line('-',REP_WIDTH);
    next_line(1);
    next_line(20); next_line(1);
 }

if (((nd_days4 == 0)&&(nd_days3 != 0)) || (nd_days4 != 0)) 
   {
  if (nd_days4 == 0) 
  {
     //fprintf(fp, "4.  Above %-3s%-8.8s%-4s     %-10s%5s ",age_3_value.arr,age_3_ind.arr," ",loc_legend[17]," ");
     sprintf(l_str1,"4. %-s %-s %-s",loc_legend[42],age_3_value.arr,age_3_ind.arr);
     fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]);
  }
  else   
  {
     //fprintf(fp, "4.  %-3s%-8.8sTO%3s%8.8s  %-10s%5s ",age_3_value.arr,age_3_ind.arr,age_4_value.arr,age_4_ind.arr, loc_legend[17]," ");
     sprintf(l_str1,"4.%-s %-s %s %-s %-s",
		age_3_value.arr,age_3_ind.arr,loc_legend[44],
		age_4_value.arr,age_4_ind.arr);
     fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
   }
	 
	 next_line(1);	           
	 fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[31]," ");
 
	    print_formated(nd_d4_ctz_epi_tot_outamt);
		print_formated(nd_d4_ctz_epi_writeoff_amt);
	    print_formated(nd_d4_ctz_epi_outamt);
        fprintf(fp,"%15d",d4_ctz_epi_pat_cnt);

   next_line(1);
   fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");
 
		print_formated(nd_d4_ctz_epd_tot_outamt);
		print_formated(nd_d4_ctz_epd_writeoff_amt);
		print_formated(nd_d4_ctz_epd_outamt);

		fprintf(fp,"%15d",d4_ctz_epd_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[33]," ");
 
		print_formated(nd_d4_ctz_epo_tot_outamt);
		print_formated(nd_d4_ctz_epo_writeoff_amt);
		print_formated(nd_d4_ctz_epo_outamt);

		fprintf(fp,"%15d",d4_ctz_epo_pat_cnt);

   next_line(1);
   fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[34]," ");
 
		print_formated(nd_d4_ctz_epe_tot_outamt);
		print_formated(nd_d4_ctz_epe_writeoff_amt);
		print_formated(nd_d4_ctz_epe_outamt);

		fprintf(fp,"%15d",d4_ctz_epe_pat_cnt);

   next_line(1);
   fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[35]," ");
 
		print_formated(nd_d4_ctz_epr_tot_outamt);
		print_formated(nd_d4_ctz_epr_writeoff_amt);
		print_formated(nd_d4_ctz_epr_outamt);

		fprintf(fp,"%15d",d4_ctz_epr_pat_cnt);

    next_line(1);
	horz_skip(31);
    print_line('-',REP_WIDTH-31);
    next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;

		print_formated(nd_tot_malay_d4_outamt);
		print_formated(nd_tot_malay_d4_writeoff_amt);
		print_formated(nd_tot_malay_d4_revamt);

        fprintf(fp,"%15d",nd_tot_malay_pat4);

   next_line(1);
   horz_skip(31);
   print_line('-',REP_WIDTH-31);
   next_line(1);

	fprintf(fp,"%-24.24s       %-10.10s%5s "," ",loc_legend[18]," ") ;	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[31]," ");
 
		print_formated(nd_d4_nctz_epi_tot_outamt);
		print_formated(nd_d4_nctz_epi_writeoff_amt);
		print_formated(nd_d4_nctz_epi_outamt);

		fprintf(fp,"%15d",d4_nctz_epi_pat_cnt);

	 next_line(1);
	 fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");
 
		print_formated(nd_d4_nctz_epd_tot_outamt);
		print_formated(nd_d4_nctz_epd_writeoff_amt);
		print_formated(nd_d4_nctz_epd_outamt);

		fprintf(fp,"%15d",d4_nctz_epd_pat_cnt);

	next_line(1);
    fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[33]," ");
 
		print_formated(nd_d4_nctz_epo_tot_outamt);
		print_formated(nd_d4_nctz_epo_writeoff_amt);
		print_formated(nd_d4_nctz_epo_outamt);

		fprintf(fp,"%15d",d4_nctz_epo_pat_cnt);
  
	next_line(1);
   fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[34]," ");

		print_formated(nd_d4_nctz_epe_tot_outamt);
		print_formated(nd_d4_nctz_epe_writeoff_amt);
		print_formated(nd_d4_nctz_epe_outamt);

		fprintf(fp,"%15d",d4_nctz_epe_pat_cnt);

    next_line(1);
    fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[35]," ");
 
		print_formated(nd_d4_nctz_epr_tot_outamt);
		print_formated(nd_d4_nctz_epr_writeoff_amt);
		print_formated(nd_d4_nctz_epr_outamt);

		fprintf(fp,"%15d",d4_nctz_epr_pat_cnt);

  next_line(1);
  horz_skip(31);
  print_line('-',REP_WIDTH-31);
  next_line(1);

	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;
		print_formated(nd_tot_for_d4_outamt);
		print_formated(nd_tot_for_d4_writeoff_amt);
		print_formated(nd_tot_for_d4_revamt);

		fprintf(fp,"%15d",nd_tot_for_pat4);

	next_line(1);
	print_line('-',REP_WIDTH);
	next_line(1);

	 fprintf(fp, "%-24s      %-10.10s%6s "," ",loc_legend[36]," ") ;
		print_formated(nd_tot_malay_d4_outamt+nd_tot_for_d4_outamt);
		print_formated(nd_tot_malay_d4_writeoff_amt+nd_tot_for_d4_writeoff_amt);
		print_formated(nd_tot_malay_d4_revamt+nd_tot_for_d4_revamt);

		fprintf(fp,"%15d",nd_tot_malay_pat4+nd_tot_for_pat4);
	next_line(1);
	print_line('-',REP_WIDTH);
	next_line(1);
 next_line(20); next_line(1);
 }

 if (((nd_days5 == 0)&&(nd_days4 != 0))|| (nd_days5 != 0))
   {
   if (nd_days5 == 0) 
   {
     //fprintf(fp, "5.  Above %-3s%-8.8s%-4s     %-10s%5s ",age_4_value.arr,age_4_ind.arr," ",loc_legend[17]," "	);
     sprintf(l_str1,"5. %-s %-s %-s",loc_legend[42],age_4_value.arr,age_4_ind.arr);
     fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
   }
   else
   {
      //fprintf(fp, "5.  %-3s%-8.8sTO%3s%8.8s  %-10s%5s ",age_4_value.arr,age_4_ind.arr,age_5_value.arr,age_5_ind.arr ,loc_legend[17]," ");	
      sprintf(l_str1,"4.%-s %-s %s %-s %-s",
		age_4_value.arr,age_4_ind.arr,loc_legend[44],
		age_5_value.arr,age_5_ind.arr);
      fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 
   }
      next_line(1);           

 fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[31]," ");
 
		print_formated(nd_d5_ctz_epi_tot_outamt);
		print_formated(nd_d5_ctz_epi_writeoff_amt);
		print_formated(nd_d5_ctz_epi_outamt);

		fprintf(fp,"%15d",d5_ctz_epi_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");
 
		print_formated(nd_d5_ctz_epd_tot_outamt);
		print_formated(nd_d5_ctz_epd_writeoff_amt);
		print_formated(nd_d5_ctz_epd_outamt);

		fprintf(fp,"%15d",d5_ctz_epd_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[33]," ");
 
		print_formated(nd_d5_ctz_epo_tot_outamt);
		print_formated(nd_d5_ctz_epo_writeoff_amt);
		print_formated(nd_d5_ctz_epo_outamt);
		fprintf(fp,"%15d",d5_ctz_epo_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[34]," ");
 
		print_formated(nd_d5_ctz_epe_tot_outamt);
		print_formated(nd_d5_ctz_epe_writeoff_amt);
		print_formated(nd_d5_ctz_epe_outamt);
		fprintf(fp,"%15d",d5_ctz_epe_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[35]," ");
 
		print_formated(nd_d5_ctz_epr_tot_outamt);
		print_formated(nd_d5_ctz_epr_writeoff_amt);
		print_formated(nd_d5_ctz_epr_outamt);

		fprintf(fp,"%15d",d5_ctz_epr_pat_cnt);

    next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," "	) ;

		print_formated(nd_tot_malay_d5_outamt);
		print_formated(nd_tot_malay_d5_writeoff_amt);
	    print_formated(nd_tot_malay_d5_revamt);

		fprintf(fp,"%15d",nd_tot_malay_pat5);

	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);



  fprintf(fp, "%-24.24s       %-10.10s%5s "," ",loc_legend[18]," ") ;	next_line(1);
  fprintf(fp, "%-24s       %-10.10s%3s "," ",loc_legend[31]," ");
 
	 print_formated(nd_d5_nctz_epi_tot_outamt);
	 print_formated(nd_d5_nctz_epi_writeoff_amt);
	 print_formated(nd_d5_nctz_epi_outamt);

	 fprintf(fp,"%15d",d5_nctz_epi_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");
 
		print_formated(nd_d5_nctz_epd_tot_outamt);
		print_formated(nd_d5_nctz_epd_writeoff_amt);
		print_formated(nd_d5_nctz_epd_outamt);
		fprintf(fp,"%15d",d5_nctz_epd_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[33]," ");
 
		print_formated(nd_d5_nctz_epo_tot_outamt);
		print_formated(nd_d5_nctz_epo_writeoff_amt);
		print_formated(nd_d5_nctz_epo_outamt);

		fprintf(fp,"%15d",d5_nctz_epo_pat_cnt);

	next_line(1);
    fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[34]," ");
 
		print_formated(nd_d5_nctz_epe_tot_outamt);
		print_formated(nd_d5_nctz_epe_writeoff_amt);
		print_formated(nd_d5_nctz_epe_outamt);
		fprintf(fp,"%15d",d5_nctz_epe_pat_cnt);

	next_line(1);
     fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[35]," ");
 
		print_formated(nd_d5_nctz_epr_tot_outamt);
		print_formated(nd_d5_nctz_epr_writeoff_amt);
		print_formated(nd_d5_nctz_epr_outamt);

		fprintf(fp,"%15d",d5_nctz_epr_pat_cnt);

	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);

   fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;
		print_formated(nd_tot_for_d5_outamt);
		print_formated(nd_tot_for_d5_writeoff_amt);
		print_formated(nd_tot_for_d5_revamt);
		fprintf(fp,"%15d",nd_tot_for_pat5);

	next_line(1);
	print_line('-',REP_WIDTH);
	next_line(1);
 fprintf(fp, "%-24s      %-10.10s%6s "," ",loc_legend[36]," ") ;

	  print_formated(nd_tot_malay_d5_outamt+nd_tot_for_d5_outamt);
	  print_formated(nd_tot_malay_d5_writeoff_amt+nd_tot_for_d5_writeoff_amt);
	  print_formated(nd_tot_malay_d5_revamt+nd_tot_for_d5_revamt);

	  fprintf(fp,"%15d",nd_tot_malay_pat5+nd_tot_for_pat5);
   next_line(1);
   print_line('-',REP_WIDTH);
   next_line(1);
   next_line(20); next_line(1);


}

 if ((nd_days5 != 0))
       {
		 //fprintf(fp, "6.  Above %-3s%-8.8s%-4s     %-10s%5s ",age_5_value.arr,age_5_ind.arr," ", loc_legend[17]," ");	
		 sprintf(l_str1,"6. %-s %-s %-s",loc_legend[42],age_5_value.arr,age_5_ind.arr);
		 fprintf(fp,"%-30.30s %-15.15s ",l_str1,loc_legend[17]); 


   			next_line(1);           
		fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[31]," ");
 
		print_formated(nd_d6_ctz_epi_tot_outamt);	
		print_formated(nd_d6_ctz_epi_writeoff_amt);
			print_formated(nd_d6_ctz_epi_outamt);
		fprintf(fp,"%15d",d6_ctz_epi_pat_cnt);

		  next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");
	 
		print_formated(nd_d6_ctz_epd_tot_outamt);
		print_formated(nd_d6_ctz_epd_writeoff_amt);
		print_formated(nd_d6_ctz_epd_outamt);

		fprintf(fp,"%15d",d6_ctz_epd_pat_cnt);

	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[33]," ");
 
		print_formated(nd_d6_ctz_epo_tot_outamt);
		print_formated(nd_d6_ctz_epo_writeoff_amt);
		print_formated(nd_d6_ctz_epo_outamt);

		fprintf(fp,"%15d",d6_ctz_epo_pat_cnt);

	next_line(1);
    fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[34]," ");
 
		print_formated(nd_d6_ctz_epe_tot_outamt);
		print_formated(nd_d6_ctz_epe_writeoff_amt);
		print_formated(nd_d6_ctz_epe_outamt);

		fprintf(fp,"%15d",d6_ctz_epe_pat_cnt);

    next_line(1);
    fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[35]," ");
 
		print_formated(nd_d6_ctz_epr_tot_outamt);
		print_formated(nd_d6_ctz_epr_writeoff_amt);
		print_formated(nd_d6_ctz_epr_outamt);

		fprintf(fp,"%15d",d6_ctz_epr_pat_cnt);

	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);
  fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;
		print_formated(nd_tot_malay_d6_outamt);
		print_formated(nd_tot_malay_d6_writeoff_amt);
		print_formated(nd_tot_malay_d6_revamt);

		fprintf(fp,"%15d",nd_tot_malay_pat6);

   next_line(1);
   horz_skip(31);
   print_line('-',REP_WIDTH-31);
   next_line(1);

	fprintf(fp, "%-24.24s      %-10.10s%5s "," ",loc_legend[18]," ") ;	next_line(1);
	fprintf(fp,"%-24s       %-10.10s%5s "," ",loc_legend[31]," ");
 
		print_formated(nd_d6_nctz_epi_tot_outamt);
		print_formated(nd_d6_nctz_epi_writeoff_amt);
		print_formated(nd_d6_nctz_epi_outamt);

		fprintf(fp,"%15d",d6_nctz_epi_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");
 
		print_formated(nd_d6_nctz_epd_tot_outamt);
		print_formated(nd_d6_nctz_epd_writeoff_amt);
		print_formated(nd_d6_nctz_epd_outamt);

		fprintf(fp,"%15d",d6_nctz_epd_pat_cnt);

	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[33]," ");
 
		print_formated(nd_d6_nctz_epo_tot_outamt);
		print_formated(nd_d6_nctz_epo_writeoff_amt);
		print_formated(nd_d6_nctz_epo_outamt);

		fprintf(fp,"%15d",d6_nctz_epo_pat_cnt);

	next_line(1);
    fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[34]," ");
 
		print_formated(nd_d6_nctz_epe_tot_outamt);
		print_formated(nd_d6_nctz_epe_writeoff_amt);
		print_formated(nd_d6_nctz_epe_outamt);

		fprintf(fp,"%15d",d6_nctz_epe_pat_cnt);

   next_line(1);
   fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[35]," ");
 
		print_formated(nd_d6_nctz_epr_tot_outamt);
		print_formated(nd_d6_nctz_epr_writeoff_amt);
		print_formated(nd_d6_nctz_epr_outamt);

		fprintf(fp,"%15d",d6_nctz_epr_pat_cnt);

	next_line(1);
	horz_skip(31);
	print_line('-',REP_WIDTH-31);
	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[19]," ") ;

		print_formated(nd_tot_for_d6_outamt);
		print_formated(nd_tot_for_d6_writeoff_amt);
		print_formated(nd_tot_for_d6_revamt);

		fprintf(fp,"%15d",nd_tot_for_pat6);

	next_line(1);
	print_line('-',REP_WIDTH);
	next_line(1);
	fprintf(fp, "%-24s      %-10.10s%6s "," ",loc_legend[36]," ") ;

		print_formated(nd_tot_malay_d6_outamt+nd_tot_for_d6_outamt);
		print_formated(nd_tot_malay_d6_writeoff_amt+nd_tot_for_d6_writeoff_amt);
		print_formated(nd_tot_malay_d6_revamt+nd_tot_for_d6_revamt);
		fprintf(fp,"%15d",nd_tot_malay_pat6+nd_tot_for_pat6);
	next_line(1);
	print_line('-',REP_WIDTH);
	next_line(1);
	next_line(20); next_line(1);

//----------------------------


}

	fprintf(fp, " %10.10s %-19s%-10.10s ",loc_legend[19]," ",loc_legend[17]) ;	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[31]," ");

		print_formated(nd_tot_mal_ip_outamt);
		print_formated(nd_tot_mal_ip_writeoff_amt);
		print_formated(nd_tot_mal_ip_revamt);
		fprintf(fp,"%15d",nd_tot_mal_ip_pat);

	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");

		print_formated(nd_tot_mal_dy_outamt);
		print_formated(nd_tot_mal_dy_writeoff_amt);
		print_formated(nd_tot_mal_dy_revamt);

		fprintf(fp,"%15d",nd_tot_mal_dy_pat);

	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[33]," ");

		print_formated(nd_tot_mal_op_outamt);
		print_formated(nd_tot_mal_op_writeoff_amt);
		print_formated(nd_tot_mal_op_revamt);

		fprintf(fp,"%15d",nd_tot_mal_op_pat);

	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[34]," ");

		print_formated(nd_tot_mal_em_outamt);
		print_formated(nd_tot_mal_em_writeoff_amt);
		print_formated(nd_tot_mal_em_revamt);

		fprintf(fp,"%15d",nd_tot_mal_em_pat);

	 next_line(1);
	 fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[35]," ");

		print_formated(nd_tot_mal_ex_outamt);
		print_formated(nd_tot_mal_ex_writeoff_amt);
		print_formated(nd_tot_mal_ex_revamt);
		fprintf(fp,"%15d",nd_tot_mal_ex_pat);
		next_line(1); next_line(1);

	print_line('-',REP_WIDTH);
	next_line(1);
	fprintf(fp, "%-24s      %-10.10s%6s "," ",loc_legend[36]," ") ;

		print_formated(nd_tot_malay_eps_outamt);
		print_formated(nd_tot_malay_eps_writeoff_amt);
		print_formated(nd_tot_malay_eps_revamt);

		fprintf(fp,"%15d",nd_tot_malay_eps_pat);
    next_line(1);
	print_line('-',REP_WIDTH);


//--------------------
	next_line(15); next_line(1);



	fprintf(fp, " %10.10s %-19.19s%-10.10s ",loc_legend[19]," ",loc_legend[18]) ;	next_line(1);
	
	fprintf(fp, "%-24s       %-10s%5s "," ",loc_legend[31]," ");

		print_formated(nd_tot_for_ip_outamt);
		print_formated(nd_tot_for_ip_writeoff_amt);
		print_formated(nd_tot_for_ip_revamt);

		fprintf(fp,"%15d",nd_tot_for_ip_pat);

	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[32]," ");

		print_formated(nd_tot_for_dy_outamt);
		print_formated(nd_tot_for_dy_writeoff_amt);
		print_formated(nd_tot_for_dy_revamt);

		fprintf(fp,"%15d",nd_tot_for_dy_pat);
	next_line(1);
	fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[33]," ");

		print_formated(nd_tot_for_op_outamt);
		print_formated(nd_tot_for_op_writeoff_amt);
		print_formated(nd_tot_for_op_revamt);

		fprintf(fp,"%15d",nd_tot_for_op_pat);
	 next_line(1);
	 fprintf(fp,"%-24s       %-10.10s%5s "," ",loc_legend[34]," ");

		print_formated(nd_tot_for_em_outamt);
		print_formated(nd_tot_for_em_writeoff_amt);
		print_formated(nd_tot_for_em_revamt);

		fprintf(fp,"%15d",nd_tot_for_em_pat);
	next_line(1);
 fprintf(fp, "%-24s       %-10.10s%5s "," ",loc_legend[35]," ");

		print_formated(nd_tot_for_ex_outamt);
		print_formated(nd_tot_for_ex_writeoff_amt);
		print_formated(nd_tot_for_ex_revamt);

		fprintf(fp,"%15d",nd_tot_for_ex_pat);
	next_line(1); next_line(1);

	print_line('-',REP_WIDTH);
	next_line(1);
	fprintf(fp, "%-24s      %-10.10s%6s "," ",loc_legend[36]," ") ;

		print_formated(nd_tot_for_eps_outamt);	
		print_formated(nd_tot_for_eps_writeoff_amt);
	    print_formated(nd_tot_for_eps_revamt);

		fprintf(fp,"%15d",nd_tot_for_eps_pat);

   next_line(1); next_line(1);
   print_line('-',REP_WIDTH);

   next_line(1);
	fprintf(fp, "%24s      %16s ",loc_legend[20]," ") ;
		print_formated(nd_tot_for_eps_outamt+nd_tot_malay_eps_outamt);
		print_formated(nd_tot_for_eps_writeoff_amt+nd_tot_malay_eps_writeoff_amt);

				print_formated(nd_tot_for_eps_revamt+nd_tot_malay_eps_revamt);
		fprintf(fp,"%15d",nd_tot_malay_eps_pat+nd_tot_for_eps_pat);
    next_line(1);
	print_line('-',REP_WIDTH);
  }

else if(strcmp(nd_br_episode_type.arr,"Y")==0 && strcmp(nd_br_citizen.arr,"N")==0)
         {

	nd_tot_d1_ep_outamt=nd_d1_epi_outamt+nd_d1_epo_outamt+nd_d1_epd_outamt+nd_d1_epe_outamt+nd_d1_epr_outamt;
	nd_tot_d2_ep_outamt=nd_d2_epi_outamt+nd_d2_epo_outamt+nd_d2_epd_outamt+nd_d2_epe_outamt+nd_d2_epr_outamt;
	nd_tot_d3_ep_outamt=nd_d3_epi_outamt+nd_d3_epo_outamt+nd_d3_epd_outamt+nd_d3_epe_outamt+nd_d3_epr_outamt;
	nd_tot_d4_ep_outamt=nd_d4_epi_outamt+nd_d4_epo_outamt+nd_d4_epd_outamt+nd_d4_epe_outamt+nd_d4_epr_outamt;
	nd_tot_d5_ep_outamt=nd_d5_epi_outamt+nd_d5_epo_outamt+nd_d5_epd_outamt+nd_d5_epe_outamt+nd_d5_epr_outamt;
	nd_tot_d6_ep_outamt=nd_d6_epi_outamt+nd_d6_epo_outamt+nd_d6_epd_outamt+nd_d6_epe_outamt+nd_d6_epr_outamt;

	nd_tot_d1_ep_pat=d1_epi_pat_cnt+d1_epo_pat_cnt+d1_epd_pat_cnt+d1_epe_pat_cnt+d1_epr_pat_cnt;
	nd_tot_d2_ep_pat=d2_epi_pat_cnt+d2_epo_pat_cnt+d2_epd_pat_cnt+d2_epe_pat_cnt+d2_epr_pat_cnt;
	nd_tot_d3_ep_pat=d3_epi_pat_cnt+d3_epo_pat_cnt+d3_epd_pat_cnt+d3_epe_pat_cnt+d3_epr_pat_cnt;
	nd_tot_d4_ep_pat=d4_epi_pat_cnt+d4_epo_pat_cnt+d4_epd_pat_cnt+d4_epe_pat_cnt+d4_epr_pat_cnt;
	nd_tot_d5_ep_pat=d5_epi_pat_cnt+d5_epo_pat_cnt+d5_epd_pat_cnt+d5_epe_pat_cnt+d5_epr_pat_cnt;
	nd_tot_d6_ep_pat=d6_epi_pat_cnt+d6_epo_pat_cnt+d6_epd_pat_cnt+d6_epe_pat_cnt+d6_epr_pat_cnt;

               
	nd_tot_ip_outamt=nd_d1_epi_outamt+nd_d2_epi_outamt+nd_d3_epi_outamt+nd_d4_epi_outamt+nd_d5_epi_outamt+nd_d6_epi_outamt;
	nd_tot_op_outamt=nd_d1_epo_outamt+nd_d2_epo_outamt+nd_d3_epo_outamt+nd_d4_epo_outamt+nd_d5_epo_outamt+nd_d6_epo_outamt;
	nd_tot_em_outamt=nd_d1_epe_outamt+nd_d2_epe_outamt+nd_d3_epe_outamt+nd_d4_epe_outamt+nd_d5_epe_outamt+nd_d6_epe_outamt;
	nd_tot_dy_outamt=nd_d1_epd_outamt+nd_d2_epd_outamt+nd_d3_epd_outamt+nd_d4_epd_outamt+nd_d5_epd_outamt+nd_d6_epd_outamt;
	nd_tot_ex_outamt=nd_d1_epr_outamt+nd_d2_epr_outamt+nd_d3_epr_outamt+nd_d4_epr_outamt+nd_d5_epr_outamt+nd_d6_epr_outamt;

	nd_tot_ip_pat=d1_epi_pat_cnt+d2_epi_pat_cnt+d3_epi_pat_cnt+d4_epi_pat_cnt+d5_epi_pat_cnt+d6_epi_pat_cnt;
	nd_tot_op_pat=d1_epo_pat_cnt+d2_epo_pat_cnt+d3_epo_pat_cnt+d4_epo_pat_cnt+d5_epo_pat_cnt+d6_epo_pat_cnt;
	nd_tot_dy_pat=d1_epd_pat_cnt+d2_epd_pat_cnt+d3_epd_pat_cnt+d4_epd_pat_cnt+d5_epd_pat_cnt+d6_epd_pat_cnt;
	nd_tot_em_pat=d1_epe_pat_cnt+d2_epe_pat_cnt+d3_epe_pat_cnt+d4_epe_pat_cnt+d5_epe_pat_cnt+d6_epe_pat_cnt;
	nd_tot_ex_pat=d1_epr_pat_cnt+d2_epr_pat_cnt+d3_epr_pat_cnt+d4_epr_pat_cnt+d5_epr_pat_cnt+d6_epr_pat_cnt;
	

	nd_tot_eps_outamt=nd_tot_ip_outamt+nd_tot_op_outamt+nd_tot_em_outamt+nd_tot_dy_outamt+nd_tot_ex_outamt;
	nd_tot_eps_pat=nd_tot_ip_pat+nd_tot_op_pat+nd_tot_dy_pat+nd_tot_em_pat+nd_tot_ex_pat;
	



//----------------------------Write offf


	nd_tot_d1_ep_writeoff_amt=nd_d1_epi_writeoff_amt+nd_d1_epo_writeoff_amt+nd_d1_epd_writeoff_amt+nd_d1_epe_writeoff_amt+nd_d1_epr_writeoff_amt;
	nd_tot_d2_ep_writeoff_amt=nd_d2_epi_writeoff_amt+nd_d2_epo_writeoff_amt+nd_d2_epd_writeoff_amt+nd_d2_epe_writeoff_amt+nd_d2_epr_writeoff_amt;
	nd_tot_d3_ep_writeoff_amt=nd_d3_epi_writeoff_amt+nd_d3_epo_writeoff_amt+nd_d3_epd_writeoff_amt+nd_d3_epe_writeoff_amt+nd_d3_epr_writeoff_amt;
	nd_tot_d4_ep_writeoff_amt=nd_d4_epi_writeoff_amt+nd_d4_epo_writeoff_amt+nd_d4_epd_writeoff_amt+nd_d4_epe_writeoff_amt+nd_d4_epr_writeoff_amt;
	nd_tot_d5_ep_writeoff_amt=nd_d5_epi_writeoff_amt+nd_d5_epo_writeoff_amt+nd_d5_epd_writeoff_amt+nd_d5_epe_writeoff_amt+nd_d5_epr_writeoff_amt;
	nd_tot_d6_ep_writeoff_amt=nd_d6_epi_writeoff_amt+nd_d6_epo_writeoff_amt+nd_d6_epd_writeoff_amt+nd_d6_epe_writeoff_amt+nd_d6_epr_writeoff_amt;

               
	nd_tot_ip_writeoff_amt=nd_d1_epi_writeoff_amt+nd_d2_epi_writeoff_amt+nd_d3_epi_writeoff_amt+nd_d4_epi_writeoff_amt+nd_d5_epi_writeoff_amt+nd_d6_epi_writeoff_amt;
	nd_tot_op_writeoff_amt=nd_d1_epo_writeoff_amt+nd_d2_epo_writeoff_amt+nd_d3_epo_writeoff_amt+nd_d4_epo_writeoff_amt+nd_d5_epo_writeoff_amt+nd_d6_epo_writeoff_amt;
	nd_tot_em_writeoff_amt=nd_d1_epe_writeoff_amt+nd_d2_epe_writeoff_amt+nd_d3_epe_writeoff_amt+nd_d4_epe_writeoff_amt+nd_d5_epe_writeoff_amt+nd_d6_epe_writeoff_amt;
	nd_tot_dy_writeoff_amt=nd_d1_epd_writeoff_amt+nd_d2_epd_writeoff_amt+nd_d3_epd_writeoff_amt+nd_d4_epd_writeoff_amt+nd_d5_epd_writeoff_amt+nd_d6_epd_writeoff_amt;
	nd_tot_ex_writeoff_amt=nd_d1_epr_writeoff_amt+nd_d2_epr_writeoff_amt+nd_d3_epr_writeoff_amt+nd_d4_epr_writeoff_amt+nd_d5_epr_writeoff_amt+nd_d6_epr_writeoff_amt;



	nd_tot_eps_writeoff_amt=nd_tot_ip_writeoff_amt+nd_tot_op_writeoff_amt+nd_tot_em_writeoff_amt+nd_tot_dy_writeoff_amt+nd_tot_ex_writeoff_amt;


//--------------------------tot 


	nd_tot_d1_ep_tot_outamt=nd_d1_epi_tot_outamt+nd_d1_epo_tot_outamt+nd_d1_epd_tot_outamt+nd_d1_epe_tot_outamt+nd_d1_epr_tot_outamt;
	nd_tot_d2_ep_tot_outamt=nd_d2_epi_tot_outamt+nd_d2_epo_tot_outamt+nd_d2_epd_tot_outamt+nd_d2_epe_tot_outamt+nd_d2_epr_tot_outamt;
	nd_tot_d3_ep_tot_outamt=nd_d3_epi_tot_outamt+nd_d3_epo_tot_outamt+nd_d3_epd_tot_outamt+nd_d3_epe_tot_outamt+nd_d3_epr_tot_outamt;
	nd_tot_d4_ep_tot_outamt=nd_d4_epi_tot_outamt+nd_d4_epo_tot_outamt+nd_d4_epd_tot_outamt+nd_d4_epe_tot_outamt+nd_d4_epr_tot_outamt;
	nd_tot_d5_ep_tot_outamt=nd_d5_epi_tot_outamt+nd_d5_epo_tot_outamt+nd_d5_epd_tot_outamt+nd_d5_epe_tot_outamt+nd_d5_epr_tot_outamt;
	nd_tot_d6_ep_tot_outamt=nd_d6_epi_tot_outamt+nd_d6_epo_tot_outamt+nd_d6_epd_tot_outamt+nd_d6_epe_tot_outamt+nd_d6_epr_tot_outamt;

              
	nd_tot_ip_tot_outamt=nd_d1_epi_tot_outamt+nd_d2_epi_tot_outamt+nd_d3_epi_tot_outamt+nd_d4_epi_tot_outamt+nd_d5_epi_tot_outamt+nd_d6_epi_tot_outamt;
	nd_tot_em_tot_outamt=nd_d1_epe_tot_outamt+nd_d2_epe_tot_outamt+nd_d3_epe_tot_outamt+nd_d4_epe_tot_outamt+nd_d5_epe_tot_outamt+nd_d6_epe_tot_outamt;
	nd_tot_op_tot_outamt=nd_d1_epo_tot_outamt+nd_d2_epo_tot_outamt+nd_d3_epo_tot_outamt+nd_d4_epo_tot_outamt+nd_d5_epo_tot_outamt+nd_d6_epo_tot_outamt;
	nd_tot_dy_tot_outamt=nd_d1_epd_tot_outamt+nd_d2_epd_tot_outamt+nd_d3_epd_tot_outamt+nd_d4_epd_tot_outamt+nd_d5_epd_tot_outamt+nd_d6_epd_tot_outamt;
	nd_tot_ex_tot_outamt=nd_d1_epr_tot_outamt+nd_d2_epr_tot_outamt+nd_d3_epr_tot_outamt+nd_d4_epr_tot_outamt+nd_d5_epr_tot_outamt+nd_d6_epr_tot_outamt;

	nd_tot_eps_tot_outamt=nd_tot_ip_tot_outamt+nd_tot_op_tot_outamt+nd_tot_em_tot_outamt+nd_tot_dy_tot_outamt+nd_tot_ex_tot_outamt;

	//fprintf(fp, "1.  Up to %-3s%-8.8s%-4s   %-10.10s%7s ",age_1_value.arr,age_1_ind.arr," ",loc_legend[31]," ");
 
	sprintf(l_str1,"1. %-s %-s %-s",loc_legend[41],age_1_value.arr,age_1_ind.arr);
	fprintf(fp,"%-27.27s %-17.17s ",l_str1,loc_legend[31]);
 
		print_formated(nd_d1_epi_tot_outamt);
		print_formated(nd_d1_epi_writeoff_amt);
		print_formated(nd_d1_epi_outamt);
		fprintf(fp,"%15d",d1_epi_pat_cnt);

	next_line(1);
    fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[32]," ");
 
		print_formated(nd_d1_epd_tot_outamt);
		print_formated(nd_d1_epd_writeoff_amt);
		print_formated(nd_d1_epd_outamt);

		fprintf(fp,"%15d",d1_epd_pat_cnt);

	  next_line(1);
	  fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[33]," ");
 
		print_formated(nd_d1_epo_tot_outamt);
		print_formated(nd_d1_epo_writeoff_amt);
		print_formated(nd_d1_epo_outamt);

		fprintf(fp,"%15d",d1_epo_pat_cnt);

     next_line(1);
     fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[34]," ");
 
		print_formated(nd_d1_epe_tot_outamt);
		print_formated(nd_d1_epe_writeoff_amt);
		print_formated(nd_d1_epe_outamt);

		fprintf(fp,"%15d",d1_epe_pat_cnt);

	next_line(1);
     fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[35]," ");
 
		print_formated(nd_d1_epr_tot_outamt);
		print_formated(nd_d1_epr_writeoff_amt);
		print_formated(nd_d1_epr_outamt);

		fprintf(fp,"%15d",d1_epr_pat_cnt);

	next_line(1);
	horz_skip(28);
	print_line('-',REP_WIDTH-28);
	next_line(1);
	fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[19]," ") ;

		print_formated(nd_tot_d1_ep_tot_outamt);
		print_formated(nd_tot_d1_ep_writeoff_amt);
		print_formated(nd_tot_d1_ep_outamt);

		fprintf(fp,"%15d",nd_tot_d1_ep_pat);
	next_line(1);
	horz_skip(28);
	print_line('-',REP_WIDTH-28);
	next_line(8);



//-------------day2------------------------------------------------------

 if (nd_days2 == 0) 
 {
	//fprintf(fp, "2.  Above %-3s%-8.8s%-4s   %-10.10s%7s ",age_1_value.arr,age_1_ind.arr," ",loc_legend[31]," ");
	sprintf(l_str1,"2. %-s %-s %-s",loc_legend[42],age_1_value.arr,age_1_ind.arr);
        fprintf(fp,"%-27.27s %-17.17s ",l_str1,loc_legend[31]); 
 }
 else
 {
	//fprintf(fp, "2.  %-3s%-8.8sTO%3s%8.8s%-10.10s%7s ",age_1_value.arr,age_1_ind.arr,age_2_value.arr,age_2_ind.arr ,loc_legend[31]," ");
	sprintf(l_str1,"2. %-s %-s %s %-s %-s",
		age_1_value.arr,age_1_ind.arr,loc_legend[44],
		age_2_value.arr,age_2_ind.arr);
	fprintf(fp,"%-27.27s %-17.17s ",l_str1,loc_legend[31]); 
 }
 
		print_formated(nd_d2_epi_tot_outamt);
		print_formated(nd_d2_epi_writeoff_amt);
		print_formated(nd_d2_epi_outamt);
		fprintf(fp,"%15d",d2_epi_pat_cnt);

	next_line(1);
	fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[32]," ");
 
		print_formated(nd_d2_epd_tot_outamt);
		print_formated(nd_d2_epd_writeoff_amt);
		print_formated(nd_d2_epd_outamt);

		fprintf(fp,"%15d",d2_epd_pat_cnt);

	next_line(1);
	fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[33]," ");
 
		print_formated(nd_d2_epo_tot_outamt);
		print_formated(nd_d2_epo_writeoff_amt);
		print_formated(nd_d2_epo_outamt);

		fprintf(fp,"%15d",d2_epo_pat_cnt);

    next_line(1);
    fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[34]," ");
 
		print_formated(nd_d2_epe_tot_outamt);
		print_formated(nd_d2_epe_writeoff_amt);
	    print_formated(nd_d2_epe_outamt);

		fprintf(fp,"%15d",d2_epe_pat_cnt);

	next_line(1);
    fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[35]," ");
 
		print_formated(nd_d2_epr_tot_outamt);
		print_formated(nd_d2_epr_writeoff_amt);
		print_formated(nd_d2_epr_outamt);

		fprintf(fp,"%15d",d2_epr_pat_cnt);

	next_line(1);
	horz_skip(28);
	print_line('-',REP_WIDTH-28);
	next_line(1);
	fprintf(fp,"%-24s    %-10.10s%7s "," ",loc_legend[19]," ") ;

		print_formated(nd_tot_d2_ep_tot_outamt);
		print_formated(nd_tot_d2_ep_writeoff_amt);
		print_formated(nd_tot_d2_ep_outamt);

		fprintf(fp,"%15d",nd_tot_d2_ep_pat);
	next_line(1);
	horz_skip(28);
	print_line('-',REP_WIDTH-28);
	next_line(8);



//----------------------------day3---------------------------------  	  

	if (((nd_days3==0) && (nd_days2 > 0))|| (nd_days3 > 0))
	{	
     if (nd_days3 == 0) 
     {
	//fprintf(fp, "3.  Above %-3s%-8.8s%-4s   %-10.10s%7s ",age_2_value.arr,age_2_ind.arr," ",loc_legend[31]," ");
	sprintf(l_str1,"3. %-s %-s %-s",loc_legend[42],age_2_value.arr,age_2_ind.arr);
        fprintf(fp,"%-27.27s %-17.17s ",l_str1,loc_legend[31]); 
     }
     else
     {
	//fprintf(fp, "3.  %-3s%-8.8sTO%3s%8.8s%-10.10s%7s ",age_2_value.arr,age_2_ind.arr,age_3_value.arr,age_3_ind.arr, loc_legend[31]," ");                    
	sprintf(l_str1,"3. %-s %-s %s %-s %-s",
		age_2_value.arr,age_2_ind.arr,loc_legend[44],
		age_2_value.arr,age_2_ind.arr);
	fprintf(fp,"%-27.27s %-17.17s ",l_str1,loc_legend[31]); 
     }

		print_formated(nd_d3_epi_tot_outamt);
		print_formated(nd_d3_epi_writeoff_amt);
		print_formated(nd_d3_epi_outamt);

		fprintf(fp,"%15d",d3_epi_pat_cnt);

		next_line(1);

	  fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[32]," ");
 
		print_formated(nd_d3_epd_tot_outamt);
		print_formated(nd_d3_epd_writeoff_amt);
		print_formated(nd_d3_epd_outamt);

		fprintf(fp,"%15d",d3_epd_pat_cnt);

	  next_line(1);
	fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[33]," ");
 
		print_formated(nd_d3_epo_tot_outamt);
		print_formated(nd_d3_epo_writeoff_amt);
		print_formated(nd_d3_epo_outamt);

		fprintf(fp,"%15d",d3_epo_pat_cnt);

	next_line(1);
   fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[34]," ");
 
		print_formated(nd_d3_epe_tot_outamt);
		print_formated(nd_d3_epe_writeoff_amt);
		print_formated(nd_d3_epe_outamt);

		fprintf(fp,"%15d",d3_epe_pat_cnt);

	next_line(1);

    fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[35]," ");
 
		print_formated(nd_d3_epr_tot_outamt);
		print_formated(nd_d3_epr_writeoff_amt);
		print_formated(nd_d3_epr_outamt);

		fprintf(fp,"%15d",d3_epr_pat_cnt);
	next_line(1);
	horz_skip(28);
	print_line('-',REP_WIDTH-28);
	next_line(1);
fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[19]," "	) ;
		print_formated(nd_tot_d3_ep_tot_outamt);
		print_formated(nd_tot_d3_ep_writeoff_amt);
		print_formated(nd_tot_d3_ep_outamt);

		fprintf(fp,"%15d",nd_tot_d3_ep_pat);

	next_line(1);
	horz_skip(28);
	print_line('-',REP_WIDTH-28);
    next_line(8);
  }

//----------------------------------------day4-----------------

if (((nd_days4 == 0)&&(nd_days3 != 0)) || (nd_days4 != 0)) 
   {
  if (nd_days4 == 0)
  {
         //fprintf(fp, "4.  Above %-3s%-8.8s%-4s   %-10.10s%7s ",age_3_value.arr,age_3_ind.arr," ",loc_legend[31]," ");
	 sprintf(l_str1,"4. %-s %-s %-s",loc_legend[42],age_3_value.arr,age_3_ind.arr);
         fprintf(fp,"%-27.27s %-17.17s ",l_str1,loc_legend[31]); 
  }
  else 
  {
	//fprintf(fp, "4.  %-3s%-8.8sTO%3s%8.8s%-10.10s%7s ",age_3_value.arr,age_3_ind.arr,age_4_value.arr,age_4_ind.arr, loc_legend[31]," ");           
	sprintf(l_str1,"4. %-s %-s %s %-s %-s",
		age_3_value.arr,age_3_ind.arr,loc_legend[44],
		age_4_value.arr,age_4_ind.arr);
	fprintf(fp,"%-27.27s %-17.17s ",l_str1,loc_legend[31]); 
  }


 
		print_formated(nd_d4_epi_tot_outamt);
		print_formated(nd_d4_epi_writeoff_amt);
				print_formated(nd_d4_epi_outamt);

		fprintf(fp,"%15d",d4_epi_pat_cnt);

	next_line(1);
	fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[32]," ");
 
		print_formated(nd_d4_epd_tot_outamt);
		print_formated(nd_d4_epd_writeoff_amt);
		print_formated(nd_d4_epd_outamt);

	   fprintf(fp,"%15d",d4_epd_pat_cnt);

	next_line(1);
    fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[33]," ");
 
		print_formated(nd_d4_epo_tot_outamt);
		print_formated(nd_d4_epo_writeoff_amt);
		print_formated(nd_d4_epo_outamt);

		fprintf(fp,"%15d",d4_epo_pat_cnt);

   next_line(1);
   fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[34]," ");
 
		print_formated(nd_d4_epe_tot_outamt);
		print_formated(nd_d4_epe_writeoff_amt);
				print_formated(nd_d4_epe_outamt);

		fprintf(fp,"%15d",d4_epe_pat_cnt);

	  next_line(1);
      fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[35]," ");
 
		print_formated(nd_d4_epr_tot_outamt);
		print_formated(nd_d4_epr_writeoff_amt);
		print_formated(nd_d4_epr_outamt);

		fprintf(fp,"%15d",d4_epr_pat_cnt);
	 next_line(1);
	 horz_skip(28);
	 print_line('-',REP_WIDTH-28);
	 next_line(1);
	fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[19]," ") ;

		print_formated(nd_tot_d4_ep_tot_outamt);
		print_formated(nd_tot_d4_ep_writeoff_amt);
		print_formated(nd_tot_d4_ep_outamt);

		fprintf(fp,"%15d",nd_tot_d4_ep_pat);

	next_line(1);
	horz_skip(28);
	print_line('-',REP_WIDTH-28);
	next_line(8);
  }
//------------------------------day5
 if (((nd_days5 == 0)&&(nd_days4 != 0))|| (nd_days5 != 0))
   {
   if (nd_days5 == 0) 
   {
     //fprintf(fp, "5.  Above %-3s%-8.8s%-4s   %-10.10s%7s ",age_4_value.arr,age_4_ind.arr," ",loc_legend[31]," ");
     sprintf(l_str1,"5. %-s %-s %-s",loc_legend[42],age_4_value.arr,age_4_ind.arr);
     fprintf(fp,"%-27.27s %-17.17s ",l_str1,loc_legend[31]); 
   }
   else
   {
	//fprintf(fp, "5.  %-3s%-8.8sTO%3s%8.8s%-10.10s%7s ",age_4_value.arr,age_4_ind.arr,age_5_value.arr,age_5_ind.arr ,loc_legend[31]," ");         
	sprintf(l_str1,"5. %-s %-s %s %-s %-s",
		age_4_value.arr,age_4_ind.arr,loc_legend[44],
		age_5_value.arr,age_5_ind.arr);
	fprintf(fp,"%-27.27s %-17.17s ",l_str1,loc_legend[31]); 
   }


		print_formated(nd_d5_epi_tot_outamt);
		print_formated(nd_d5_epi_writeoff_amt);
		print_formated(nd_d5_epi_outamt);
		fprintf(fp,"%15d",d5_epi_pat_cnt);

	next_line(1);
	fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[32]," ");
 
		print_formated(nd_d5_epd_tot_outamt);
		print_formated(nd_d5_epd_writeoff_amt);
		print_formated(nd_d5_epd_outamt);

        fprintf(fp,"%15d",d5_epd_pat_cnt);

    next_line(1);
	fprintf(fp,"%-24s    %-10.10s%7s "," ",loc_legend[33]," ");
 
		print_formated(nd_d5_epo_tot_outamt);
		print_formated(nd_d5_epo_writeoff_amt);
		print_formated(nd_d5_epo_outamt);

        fprintf(fp,"%15d",d5_epo_pat_cnt);

    next_line(1);
    fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[34]," ");
 
		print_formated(nd_d5_epe_tot_outamt);
		print_formated(nd_d5_epe_writeoff_amt);
		print_formated(nd_d5_epe_outamt);

        fprintf(fp,"%15d",d5_epe_pat_cnt);

	next_line(1);
     fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[35]," ");
 
		print_formated(nd_d5_epr_tot_outamt);
		print_formated(nd_d5_epr_writeoff_amt);
				  print_formated(nd_d5_epr_outamt);

		fprintf(fp,"%15d",d5_epr_pat_cnt);
	next_line(1);
	horz_skip(28);
	print_line('-',REP_WIDTH-28);
	  next_line(1);


	fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[19]," ") ;
		print_formated(nd_tot_d5_ep_tot_outamt);
		print_formated(nd_tot_d5_ep_writeoff_amt);
		print_formated(nd_tot_d5_ep_outamt);

		fprintf(fp,"%15d",nd_tot_d5_ep_pat);

	next_line(1);
	horz_skip(28);
	print_line('-',REP_WIDTH-28);

  next_line(8);
  }
///--------------------------day6--------------------------

 if ((nd_days5 != 0))
       {
//fprintf(fp, "6.  Above %-3s%-8.8s%-4s   %-10.10s%7s ",age_5_value.arr,age_5_ind.arr," ", loc_legend[31]," ");      
	sprintf(l_str1,"6. %-s %-s %-s",loc_legend[42],age_5_value.arr,age_5_ind.arr);
        fprintf(fp,"%-27.27s %-17.17s ",l_str1,loc_legend[31]); 

 
		print_formated(nd_d6_epi_tot_outamt);
		print_formated(nd_d6_epi_writeoff_amt);
		print_formated(nd_d6_epi_outamt);

		fprintf(fp,"%15d",d6_epi_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[32]," ");
 
		print_formated(nd_d6_epd_tot_outamt);
		print_formated(nd_d6_epd_writeoff_amt);
		print_formated(nd_d6_epd_outamt);

		fprintf(fp,"%15d",d6_epd_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[33]," ");
 
		print_formated(nd_d6_epo_tot_outamt);
		print_formated(nd_d6_epo_writeoff_amt);
		print_formated(nd_d6_epo_outamt);

		fprintf(fp,"%15d",d6_epo_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[34]," ");
 
		print_formated(nd_d6_epe_tot_outamt);
		print_formated(nd_d6_epe_writeoff_amt);
		print_formated(nd_d6_epe_outamt);

		fprintf(fp,"%15d",d6_epe_pat_cnt);

  next_line(1);
  fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[35]," ");
 
		print_formated(nd_d6_epr_tot_outamt);
		print_formated(nd_d6_epr_writeoff_amt);
		print_formated(nd_d6_epr_outamt);

		fprintf(fp,"%15d",d6_epr_pat_cnt);

 next_line(1);
 horz_skip(28);
	print_line('-',REP_WIDTH-28);

next_line(1);
fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[19]," ") ;

		print_formated(nd_tot_d6_ep_tot_outamt);
		print_formated(nd_tot_d6_ep_writeoff_amt);
		print_formated(nd_tot_d6_ep_outamt);

		fprintf(fp,"%15d",nd_tot_d6_ep_pat);


	next_line(1);
	horz_skip(28);
	print_line('-',REP_WIDTH-28); 
	 next_line(9);

}

//----------------------------


fprintf(fp, " %10.10s%-17s%-10.10s%7s ",loc_legend[19]," ",loc_legend[31]," ") ;

		print_formated(nd_tot_ip_tot_outamt);
		print_formated(nd_tot_ip_writeoff_amt);
		print_formated(nd_tot_ip_outamt);

		fprintf(fp,"%15d",nd_tot_ip_pat);

   next_line(1);
   fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[32]," ");

		print_formated(nd_tot_dy_tot_outamt);
		print_formated(nd_tot_dy_writeoff_amt);
				print_formated(nd_tot_dy_outamt);

		fprintf(fp,"%15d",nd_tot_dy_pat);
	next_line(1);
	fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[33]," ");

		print_formated(nd_tot_op_tot_outamt);
		print_formated(nd_tot_op_writeoff_amt);
		print_formated(nd_tot_op_outamt);

		fprintf(fp,"%15d",nd_tot_op_pat);
	
	next_line(1);
   fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[34]," ");
		print_formated(nd_tot_em_tot_outamt);
		print_formated(nd_tot_em_writeoff_amt);
				print_formated(nd_tot_em_outamt);

		fprintf(fp,"%15d",nd_tot_em_pat);
	next_line(1);

 fprintf(fp, "%-24s    %-10.10s%7s "," ",loc_legend[35]," ");

		print_formated(nd_tot_ex_tot_outamt);
		print_formated(nd_tot_ex_writeoff_amt);
				print_formated(nd_tot_ex_outamt);

		fprintf(fp,"%15d",nd_tot_ex_pat);
	next_line(1); 
	print_line('-',REP_WIDTH);
    next_line(1);

 fprintf(fp, "%24s    %15s ",loc_legend[20]," ") ;

		print_formated(nd_tot_eps_tot_outamt);
		print_formated(nd_tot_eps_writeoff_amt);
				print_formated(nd_tot_eps_outamt);

		fprintf(fp,"%15d",nd_tot_eps_pat);
    next_line(1);
	print_line('-',REP_WIDTH);

}

 }

print_sum()
 {	
	//print_page_title();		
	//print_column_title();	
	//next_line(1);

  nd_tot_sm_outamt=nd_d1_outamt+nd_d2_outamt+nd_d3_outamt+nd_d4_outamt+nd_d5_outamt+nd_d6_outamt;
  nd_tot_sm_writeoff_amt=nd_d1_writeoff_amt+nd_d2_writeoff_amt+nd_d3_writeoff_amt+nd_d4_writeoff_amt+nd_d5_writeoff_amt+nd_d6_writeoff_amt;
  nd_tot_sm_tot_outamt =nd_d1_tot_outamt+nd_d2_tot_outamt+nd_d3_tot_outamt+nd_d4_tot_outamt+nd_d5_tot_outamt+nd_d6_tot_outamt;
  nd_tot_sm_pat=d1_spat_cnt+d2_spat_cnt+d3_spat_cnt+d4_spat_cnt+d5_spat_cnt+d6_spat_cnt;

  //fprintf(fp, "1.  Up to %-3s%-8.8s%-4s   %5s ",age_1_value.arr,age_1_ind.arr," "," ");

  sprintf(l_str1,"1. %-s %-s %-s",loc_legend[41],age_1_value.arr,age_1_ind.arr);
  fprintf(fp,"%-34.34s",l_str1);
  
			     
		print_formated(nd_d1_tot_outamt);
		print_formated(nd_d1_writeoff_amt);
		print_formated(nd_d1_outamt);

		fprintf(fp,"%15d",d1_spat_cnt);

  next_line(1);

 if (nd_days2 == 0) 
 {
	//fprintf(fp, "2.  Above %3s%-8.8s%-4s   %5s ",age_1_value.arr,age_1_ind.arr," "," "	);
	
	sprintf(l_str1,"2. %-s %-s %-s",loc_legend[42],age_1_value.arr,age_1_ind.arr);	
	fprintf(fp,"%-34.34s",l_str1);
 }
 else
 {
	//fprintf(fp, "2.  %3s%-8.8sTO%3s%-8.8s%5s ",age_1_value.arr,age_1_ind.arr,age_2_value.arr,age_2_ind.arr ," "	);
	sprintf(l_str1,"2. %-s %-s %-s %-s %-s",
		age_1_value.arr,age_1_ind.arr,loc_legend[44],
		age_2_value.arr,age_2_ind.arr);
	fprintf(fp,"%-34.34s",l_str1);
 }

		print_formated(nd_d2_tot_outamt);
		print_formated(nd_d2_writeoff_amt);
		print_formated(nd_d2_outamt);

		fprintf(fp,"%15d",d2_spat_cnt);

  next_line(1);


  
 if (((nd_days3==0) && (nd_days2 > 0))|| (nd_days3 > 0))
  {	
     if (nd_days3 == 0) 
     {
	//fprintf(fp, "3.  Above %-3s%-8.8s%-4s   %5s ",age_2_value.arr,age_2_ind.arr," "," "	);
	sprintf(l_str1,"3. %-s %-s %-s",loc_legend[42],age_2_value.arr,age_2_ind.arr);	
	fprintf(fp,"%-34.34s",l_str1);
     }
     else
     {
	//fprintf(fp, "3.  %-3s%-8.8sTO%3s%8.8s%5s ",age_2_value.arr,age_2_ind.arr,age_3_value.arr,age_3_ind.arr, " ") ;	           
	
	sprintf(l_str1,"3. %-s %-s %-s %-s %-s",
		age_2_value.arr,age_2_ind.arr,loc_legend[44],
		age_3_value.arr,age_3_ind.arr);
	fprintf(fp,"%-34.34s",l_str1);
     }
 
		print_formated(nd_d3_tot_outamt);
		print_formated(nd_d3_writeoff_amt);
		print_formated(nd_d3_outamt);

		fprintf(fp,"%15d",d3_spat_cnt);

  next_line(1);
     }

if (((nd_days4 == 0)&&(nd_days3 != 0)) || (nd_days4 != 0)) 
   {
  if (nd_days4 == 0) 
  {
	//fprintf(fp, "4.  Above %-3s%-8.8s%-4s   %5s ",age_3_value.arr,age_3_ind.arr," "," ");

	sprintf(l_str1,"4. %-s %-s %-s",loc_legend[42],age_3_value.arr,age_3_ind.arr);	
	fprintf(fp,"%-34.34s",l_str1);
  }
  else
  {
	//fprintf(fp, "4.  %-3s%-8.8sTO%3s%8.8s%5s ",age_3_value.arr,age_3_ind.arr,age_4_value.arr,age_4_ind.arr, " ");	    

	sprintf(l_str1,"4. %-s %-s %-s %-s %-s",
		age_3_value.arr,age_3_ind.arr,loc_legend[44],
		age_4_value.arr,age_4_ind.arr);
	fprintf(fp,"%-34.34s",l_str1);
  }
	        
		print_formated(nd_d4_tot_outamt);
		print_formated(nd_d4_writeoff_amt);
				print_formated(nd_d4_outamt);

		fprintf(fp,"%15d",d4_spat_cnt);

  next_line(1);
 }

 if (((nd_days5 == 0)&&(nd_days4 != 0))|| (nd_days5 != 0))
   {
   if (nd_days5==0) 
   {
	//fprintf(fp, "5.  Above %-3s%-8.8s%-4s   %5s ",age_4_value.arr,age_4_ind.arr," "," ");
	sprintf(l_str1,"5. %-s %-s %-s",loc_legend[42],age_4_value.arr,age_4_ind.arr);	
	fprintf(fp,"%-34.34s",l_str1);
   }
   else
   {
	//fprintf(fp, "5.  %-3s%-8.8sTO%3s%8.8s%5s ",age_4_value.arr,age_4_ind.arr,age_5_value.arr,age_5_ind.arr ," ");	           
	sprintf(l_str1,"5. %-s %-s %-s %-s %-s",
		age_4_value.arr,age_4_ind.arr,loc_legend[44],
		age_5_value.arr,age_5_ind.arr);
	fprintf(fp,"%-34.34s",l_str1);
   }

		print_formated(nd_d5_tot_outamt);
		print_formated(nd_d5_writeoff_amt);
				print_formated(nd_d5_outamt);

		fprintf(fp,"%15d",d5_spat_cnt);

  next_line(1);
  }

 if ((nd_days5 != 0))
       {
		//fprintf(fp, "6.  Above %-3s%-8.8s%-4s   %5s ",age_5_value.arr,age_5_ind.arr," "," ");	           

		sprintf(l_str1,"6. %-s %-s %-s",loc_legend[42],age_5_value.arr,age_5_ind.arr);	
		fprintf(fp,"%-34.34s",l_str1);
  
		print_formated(nd_d6_tot_outamt);
		print_formated(nd_d6_writeoff_amt);
				print_formated(nd_d6_outamt);

		fprintf(fp,"%15d",d6_spat_cnt);
 
   next_line(1); next_line(1);

   }
	print_line('-',REP_WIDTH);
	next_line(1);

 fprintf(fp, "%24s    %5s ",loc_legend[20]," ") ;

		print_formated(nd_tot_sm_tot_outamt);
		print_formated(nd_tot_sm_writeoff_amt);
				print_formated(nd_tot_sm_outamt);

	    fprintf(fp,"%15d",nd_tot_sm_pat);
      next_line(1);
	  print_line('-',REP_WIDTH);
}


/****************************************************************************/
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
		fprintf(fp,"\n"); ++lctr; //fprintf(fp,"LNNO:%2d",lctr); 
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

/*************************************************************************/
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
next_line(6);
fprintf(fp,"%s ",loc_legend[24]);
fprintf(fp,"%-s ",loc_legend[25]);
next_line(1);
fprintf(fp,"%-s ",loc_legend[27]);
next_line(1);
fprintf(fp,"%-s ",loc_legend[28]);
next_line(1);
fprintf(fp,"%-s ",loc_legend[29]);
next_line(1);
fprintf(fp,"%-s : ",loc_legend[8]);
next_line(1);
fprintf(fp,"%-s ",loc_legend[30]);

//fprintf(fp,
 //"                                                   **   END  OF  REPORT   ** ");
//next_line(1);
  fflush(fp);
  fclose(fp);
}


print_formated(loc_amount)
double loc_amount;
{
	char s_amt[15], str_amt[15];	

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

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00046.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 36;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00046.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )628;
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
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 36;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility , 'SM' \
, 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_value ,\
 :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )651;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
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



