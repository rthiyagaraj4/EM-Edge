
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00077.PC"
};


static unsigned int sqlctx = 1288460995;


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
            void  *sqhstv[34];
   unsigned int   sqhstl[34];
            int   sqhsts[34];
            void  *sqindv[34];
            int   sqinds[34];
   unsigned int   sqharm[34];
   unsigned int   *sqharc[34];
   unsigned short  sqadto[34];
   unsigned short  sqtdso[34];
} sqlstm = {12,34};

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

 static const char *sq0008 = 
"')) and ORIG_DOC_NUM between to_number(nvl(:b13,0)) and to_number(nvl(:b14,9\
9999999))) and ORIG_DOC_DATE between to_date((nvl(:b15,'01/01/0001')||' 00:00:\
00'),'dd/mm/yyyy hh24:mi:ss') and to_date((nvl(:b16,'31/12/4712')||' 23:59:59'\
),'dd/mm/yyyy hh24:mi:ss'))           ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,27,158,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,237,0,0,0,0,0,1,0,
51,0,0,3,295,0,4,280,0,0,19,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
142,0,0,4,84,0,2,321,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
169,0,0,5,64,0,4,339,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
192,0,0,6,224,0,4,381,0,0,10,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
247,0,0,7,233,0,4,403,0,0,10,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
302,0,0,8,1294,0,9,477,0,0,17,17,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
385,0,0,8,0,0,13,487,0,0,26,0,0,1,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,4,0,0,
504,0,0,9,106,0,4,531,0,0,3,2,0,1,0,1,9,0,0,2,9,0,0,1,9,0,0,
531,0,0,10,131,0,4,542,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
566,0,0,11,134,0,4,569,0,0,4,2,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
597,0,0,12,471,0,3,873,0,0,34,34,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,1,0,0,1,9,0,0,1,97,0,0,1,4,0,0,1,4,0,0,
748,0,0,13,0,0,29,888,0,0,0,0,0,1,0,
763,0,0,14,77,0,2,903,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
786,0,0,15,127,0,4,916,0,0,4,3,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
817,0,0,16,113,0,4,926,0,0,3,2,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,
844,0,0,17,75,0,4,1013,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
867,0,0,18,63,0,4,1055,0,0,2,1,0,1,0,1,9,0,0,2,97,0,0,
890,0,0,19,121,0,4,1068,0,0,2,1,0,1,0,2,9,0,0,1,97,0,0,
913,0,0,20,274,0,4,1075,0,0,3,2,0,1,0,2,9,0,0,1,97,0,0,1,9,0,0,
940,0,0,21,96,0,4,1098,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
963,0,0,22,162,0,6,1106,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
994,0,0,23,69,0,4,1188,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1017,0,0,24,196,0,6,1220,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
};


#include <stdio.h>         
#include <string.h> 
#include <bl.h>        

#define OERROR (sqlca.sqlcode < 0)
#define LAST_ROW (sqlca.sqlcode == 1403)
#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

//#define ONLINE_PRINTING 1

#define ESC 0x1B

/* EXEC SQL BEGIN DECLARE SECTION; */ 



	/* VARCHAR  lv_user_id       [91],
			 lv_pword 	      [91],
			 lv_session_id    [16],
	         lv_pgm_date      [25],
			 lv_pgm_id		  [10],
			 lv_facility_id	   [3],
			 lv_report_desc   [61],

			 lv_hosp_name     [100],
			 lv_hosp_addr1    [31],
			 lv_hosp_addr2    [31],
			 lv_hosp_addr3    [31],
			 lv_hosp_tel_num  [21],
			 lv_hosp_fax_num  [21],
			 lv_sysdate		  [20],
			 date_convert	  [20],

			 lv_payer_name	  [41],
			 lv_mail_addr1    [31],
			 lv_mail_addr2    [31],
			 lv_mail_addr3    [31],
			 lv_mail_po_code  [10],

			 lv_base_currency [10],
			 lv_ref_desc	  [21],
			 lv_ref_date	  [31],
			 
			 lv_patient_id    [21],
			 lv_patient_name  [61],


			 lv_lang_id        [5],
			 lv_lgnd_id        [5],
			 lv_lgnd_val       [51],

			 p_fm_doc_date		[21],
			 p_to_doc_date		[21],
			 p_fm_doc_type		[7],
			 p_to_doc_type		[7],
			 p_fm_orig_doc_date	[21],
			 p_to_orig_doc_date	[21],
			 p_fm_orig_doc_type	[7],
			 p_to_orig_doc_type	[7],
			 
			 lv_episode_id		[9], 
			 lv_visit_id		[5],
			 lv_payee_name		[41],
			 lv_payee_nric_no	[21], 
			 lv_bank_name		[102], 
			 lv_payee_bank_acc_num [21],  
			 lv_payee_bank_oth_dtl	[102], 
			 lv_payee_addr_line1	[31], 
			 lv_payee_addr_line2	[31], 
			 lv_payee_addr_line3	[31], 
			 lv_payee_addr_line4	[31],
			 lv_payee_post_box		[31], 
			 lv_payee_postal_code	[31],
			 lv_payee_country_code	[31],
			 country_name			[16],
			 lv_doc_type			[7], 
			 lv_doc_date			[20],
			 lv_orig_doc_type		[7],
			 lv_orig_doc_srno		[9],
			 lv_orig_doc_date		[21],
			 loc_leg_12             [80],         
			 lv_cur_bed_num			[9],
			 lv_cur_bed_class		[3],
			 p_fm_doc_num			[9], 
			 p_to_doc_num			[9], 
			 p_fm_srl_num			[9], 
			 p_to_srl_num			[9], 
			 p_fm_orig_doc_num		[9], 
			 p_to_orig_doc_num		[9],
			 lv_doc_num				[9], 
			 lv_doc_srl_num			[9], 
			 lv_orig_doc_num		[9],
			 leg11_leg28			[200],
             leg_5_26			    [200],
			 leg_15					[200],
			 legend_cat				[200],
			 legend_cat1			[200],
			 l_translated_value		[201],	 	
			 l_pk_value				[100],
			 nd_temp_date			[20],
			 nd_loc_date			[20],
			 nd_proc_yn				[2]; */ 
struct { unsigned short len; unsigned char arr[91]; } lv_user_id;

struct { unsigned short len; unsigned char arr[91]; } lv_pword;

struct { unsigned short len; unsigned char arr[16]; } lv_session_id;

struct { unsigned short len; unsigned char arr[25]; } lv_pgm_date;

struct { unsigned short len; unsigned char arr[10]; } lv_pgm_id;

struct { unsigned short len; unsigned char arr[3]; } lv_facility_id;

struct { unsigned short len; unsigned char arr[61]; } lv_report_desc;

struct { unsigned short len; unsigned char arr[100]; } lv_hosp_name;

struct { unsigned short len; unsigned char arr[31]; } lv_hosp_addr1;

struct { unsigned short len; unsigned char arr[31]; } lv_hosp_addr2;

struct { unsigned short len; unsigned char arr[31]; } lv_hosp_addr3;

struct { unsigned short len; unsigned char arr[21]; } lv_hosp_tel_num;

struct { unsigned short len; unsigned char arr[21]; } lv_hosp_fax_num;

struct { unsigned short len; unsigned char arr[20]; } lv_sysdate;

struct { unsigned short len; unsigned char arr[20]; } date_convert;

struct { unsigned short len; unsigned char arr[41]; } lv_payer_name;

struct { unsigned short len; unsigned char arr[31]; } lv_mail_addr1;

struct { unsigned short len; unsigned char arr[31]; } lv_mail_addr2;

struct { unsigned short len; unsigned char arr[31]; } lv_mail_addr3;

struct { unsigned short len; unsigned char arr[10]; } lv_mail_po_code;

struct { unsigned short len; unsigned char arr[10]; } lv_base_currency;

struct { unsigned short len; unsigned char arr[21]; } lv_ref_desc;

struct { unsigned short len; unsigned char arr[31]; } lv_ref_date;

struct { unsigned short len; unsigned char arr[21]; } lv_patient_id;

struct { unsigned short len; unsigned char arr[61]; } lv_patient_name;

struct { unsigned short len; unsigned char arr[5]; } lv_lang_id;

struct { unsigned short len; unsigned char arr[5]; } lv_lgnd_id;

struct { unsigned short len; unsigned char arr[51]; } lv_lgnd_val;

struct { unsigned short len; unsigned char arr[21]; } p_fm_doc_date;

struct { unsigned short len; unsigned char arr[21]; } p_to_doc_date;

struct { unsigned short len; unsigned char arr[7]; } p_fm_doc_type;

struct { unsigned short len; unsigned char arr[7]; } p_to_doc_type;

struct { unsigned short len; unsigned char arr[21]; } p_fm_orig_doc_date;

struct { unsigned short len; unsigned char arr[21]; } p_to_orig_doc_date;

struct { unsigned short len; unsigned char arr[7]; } p_fm_orig_doc_type;

struct { unsigned short len; unsigned char arr[7]; } p_to_orig_doc_type;

struct { unsigned short len; unsigned char arr[9]; } lv_episode_id;

struct { unsigned short len; unsigned char arr[5]; } lv_visit_id;

struct { unsigned short len; unsigned char arr[41]; } lv_payee_name;

struct { unsigned short len; unsigned char arr[21]; } lv_payee_nric_no;

struct { unsigned short len; unsigned char arr[102]; } lv_bank_name;

struct { unsigned short len; unsigned char arr[21]; } lv_payee_bank_acc_num;

struct { unsigned short len; unsigned char arr[102]; } lv_payee_bank_oth_dtl;

struct { unsigned short len; unsigned char arr[31]; } lv_payee_addr_line1;

struct { unsigned short len; unsigned char arr[31]; } lv_payee_addr_line2;

struct { unsigned short len; unsigned char arr[31]; } lv_payee_addr_line3;

struct { unsigned short len; unsigned char arr[31]; } lv_payee_addr_line4;

struct { unsigned short len; unsigned char arr[31]; } lv_payee_post_box;

struct { unsigned short len; unsigned char arr[31]; } lv_payee_postal_code;

struct { unsigned short len; unsigned char arr[31]; } lv_payee_country_code;

struct { unsigned short len; unsigned char arr[16]; } country_name;

struct { unsigned short len; unsigned char arr[7]; } lv_doc_type;

struct { unsigned short len; unsigned char arr[20]; } lv_doc_date;

struct { unsigned short len; unsigned char arr[7]; } lv_orig_doc_type;

struct { unsigned short len; unsigned char arr[9]; } lv_orig_doc_srno;

struct { unsigned short len; unsigned char arr[21]; } lv_orig_doc_date;

struct { unsigned short len; unsigned char arr[80]; } loc_leg_12;

struct { unsigned short len; unsigned char arr[9]; } lv_cur_bed_num;

struct { unsigned short len; unsigned char arr[3]; } lv_cur_bed_class;

struct { unsigned short len; unsigned char arr[9]; } p_fm_doc_num;

struct { unsigned short len; unsigned char arr[9]; } p_to_doc_num;

struct { unsigned short len; unsigned char arr[9]; } p_fm_srl_num;

struct { unsigned short len; unsigned char arr[9]; } p_to_srl_num;

struct { unsigned short len; unsigned char arr[9]; } p_fm_orig_doc_num;

struct { unsigned short len; unsigned char arr[9]; } p_to_orig_doc_num;

struct { unsigned short len; unsigned char arr[9]; } lv_doc_num;

struct { unsigned short len; unsigned char arr[9]; } lv_doc_srl_num;

struct { unsigned short len; unsigned char arr[9]; } lv_orig_doc_num;

struct { unsigned short len; unsigned char arr[200]; } leg11_leg28;

struct { unsigned short len; unsigned char arr[200]; } leg_5_26;

struct { unsigned short len; unsigned char arr[200]; } leg_15;

struct { unsigned short len; unsigned char arr[200]; } legend_cat;

struct { unsigned short len; unsigned char arr[200]; } legend_cat1;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[100]; } l_pk_value;

struct { unsigned short len; unsigned char arr[20]; } nd_temp_date;

struct { unsigned short len; unsigned char arr[20]; } nd_loc_date;

struct { unsigned short len; unsigned char arr[2]; } nd_proc_yn;


	
	int		 i, first = 0;

	char	 lc_filename	 [150],
			 lc_actl_amt      [30],
			 lc_char_amt      [30],
			 lc_doc_num        [9],
			 lc_lgnd_id        [5],
			 loc_legend[999][201],
			 
			 lc_episode_type,
			 p_orig_doc_ind,
			 lc_bill_rcpt_ind;
			 

	double   ld_doc_amt,
			 ld_orig_doc_outst_amt,
			 ld_balance_amt;

int ctr = 0,  len = 0;
int r_ctr = 0,r1_ctr = 0,r_ctr6 = 0,r_ctr1 = 0,r_ctr3=0;
char l_string[300];
char cl_string[300];
char cl_string1[300];
char  cl_string6[300];
char cl_string3[300];

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
//#include <DyWinInit.h>

FILE *fp;

void proc_main(argc,argv)
	char *argv[];
	int	 argc;
{
   
       if (argc < 5)
    {
		disp_message(ERR_MESG, "Not enough Parameters to run this program.");
		proc_exit();
    }

    strcpy(g_pgm_id, "BLR00077");

    strcpy(lv_pword.arr, argv[1]);

   lv_pword.len = strlen(lv_pword.arr);
   /* EXEC SQL CONNECT :lv_pword; */ 

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
   sqlstm.sqhstv[0] = (         void  *)&lv_pword;
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



    set_meduser_role(); 
	  
    if (sqlca.sqlcode < 0 )
	{
        disp_message(ORA_MESG, "Error in connecting to Oracle.");
        proc_exit();
    }

    	
	strcpy(lv_pgm_id.arr, g_pgm_id); 
    lv_pgm_id.len = strlen(lv_pgm_id.arr); 

    strcpy(lv_session_id.arr, argv[2]);
    lv_session_id.len = strlen(lv_session_id.arr);
    strcpy(g_session_id, lv_session_id.arr);

    strcpy(lv_pgm_date.arr, argv[3]);
    lv_pgm_date.len = strlen(lv_pgm_date.arr);
    strcpy(g_pgm_date, lv_pgm_date.arr);

    strcpy(lv_facility_id.arr, argv[4]);
    lv_facility_id.len = strlen(lv_facility_id.arr);
    strcpy(g_facility_id, lv_facility_id.arr);
    		
	fn_fetch_parameters();
	
	fn_fetch_user();

    get_language_id();
	
	fn_fetch_hosp_name();

	decl_request_cur();
	open_request_cur();

	fetch_legend_value();

	//delete_bl_temp_report();

	if (strcmp(nd_proc_yn.arr,"C") == 0)
	{ 
		fn_open_file();
		fn_print_settings();
	}
	 
	while(fn_fetch_request_cur())
	{
		if (first == 1)
			fprintf(fp,"\n\f");

			fn_fetch_patient_name();
			fn_fetch_patient_dtls();
			fn_fetch_bed_dtls();

   	   		fn_print_letter();
	}

   /*
	if (strcmp(nd_proc_yn.arr,"C") == 0) 
	{
		Show_Window();
	}
	else
	{
		VIEW_OUTPUT = 0;
	}
	*/
	//fprintf(fp,"%cE",ESC);		// To reset the printer
	
	if (strcmp(nd_proc_yn.arr,"C") == 0)
	{ 
		fflush(fp);
		fclose(fp);

	//fn_print_online();
	}

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
		err_mesg("COMMIT WORK RELEASE failed.",0,"");
}

fn_fetch_parameters()
{
	p_fm_doc_date.arr[0]		= '\0';
	p_to_doc_date.arr[0]		= '\0';
	p_fm_doc_type.arr[0]		= '\0';
	p_to_doc_type.arr[0]		= '\0';
	p_fm_orig_doc_type.arr[0]	= '\0';
	p_to_orig_doc_type.arr[0]	= '\0';
	p_fm_orig_doc_date.arr[0]	= '\0';
	p_to_orig_doc_date.arr[0]	= '\0';
	p_fm_doc_num.arr[0]			= '\0';  
	p_to_doc_num.arr[0]			= '\0';
	p_fm_srl_num.arr[0]			= '\0';
	p_to_srl_num.arr[0]			= '\0';
	p_fm_orig_doc_num.arr[0]	= '\0';
	p_to_orig_doc_num.arr[0]	= '\0';
	nd_proc_yn.arr[0]			= '\0';
	
	p_fm_doc_date.len			= 0;
	p_to_doc_date.len			= 0;
	p_fm_doc_type.len			= 0;
	p_to_doc_type.len			= 0;
	p_fm_orig_doc_type.len		= 0;
	p_to_orig_doc_type.len		= 0;
	p_fm_orig_doc_date.len		= 0;
	p_to_orig_doc_date.len		= 0;
	p_fm_doc_num.len			= 0;
	p_to_doc_num.len			= 0;
	p_fm_srl_num.len			= 0;
	p_to_srl_num.len			= 0;
	p_fm_orig_doc_num.len		= 0;
	p_to_orig_doc_num.len		= 0;
	nd_proc_yn.len				= 0;

//disp_message(ERR_MESG,lv_session_id);

//disp_message(ERR_MESG,lv_pgm_id);

	/* EXEC SQL SELECT param1, param2,	param3,	param4, param5,
					param6, param7, param8, 
					param9, param10, param11, param12, param13, 
					param14, param15,param16
			 INTO   :p_fm_doc_date, :p_to_doc_date, :p_fm_doc_type,
					:p_to_doc_type, :p_fm_doc_num,  :p_to_doc_num,
					:p_fm_srl_num,  :p_to_srl_num,  :p_orig_doc_ind,
					:p_fm_orig_doc_date,
					:p_to_orig_doc_date, :p_fm_orig_doc_type,
					:p_to_orig_doc_type, :p_fm_orig_doc_num,
					:p_to_orig_doc_num,:nd_proc_yn
			 FROM   sy_prog_param
             WHERE  pgm_id     = :lv_pgm_id
             AND	session_id = :lv_session_id
             AND	pgm_date   = :lv_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select param1 ,param2 ,param3 ,param4 ,param5 ,param6 ,param\
7 ,param8 ,param9 ,param10 ,param11 ,param12 ,param13 ,param14 ,param15 ,param\
16 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15 \
 from sy_prog_param where ((pgm_id=:b16 and session_id=:b17) and pgm_date=:b18\
)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )51;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&p_fm_doc_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_to_doc_date;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_fm_doc_type;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&p_to_doc_type;
 sqlstm.sqhstl[3] = (unsigned int  )9;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&p_fm_doc_num;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&p_to_doc_num;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&p_fm_srl_num;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&p_to_srl_num;
 sqlstm.sqhstl[7] = (unsigned int  )11;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&p_orig_doc_ind;
 sqlstm.sqhstl[8] = (unsigned int  )1;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&p_fm_orig_doc_date;
 sqlstm.sqhstl[9] = (unsigned int  )23;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&p_to_orig_doc_date;
 sqlstm.sqhstl[10] = (unsigned int  )23;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&p_fm_orig_doc_type;
 sqlstm.sqhstl[11] = (unsigned int  )9;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&p_to_orig_doc_type;
 sqlstm.sqhstl[12] = (unsigned int  )9;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&p_fm_orig_doc_num;
 sqlstm.sqhstl[13] = (unsigned int  )11;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&p_to_orig_doc_num;
 sqlstm.sqhstl[14] = (unsigned int  )11;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_proc_yn;
 sqlstm.sqhstl[15] = (unsigned int  )4;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&lv_pgm_id;
 sqlstm.sqhstl[16] = (unsigned int  )12;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&lv_session_id;
 sqlstm.sqhstl[17] = (unsigned int  )18;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&lv_pgm_date;
 sqlstm.sqhstl[18] = (unsigned int  )27;
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


		
	if (OERROR)
		err_mesg("SELECT failed on table SY_PROG_PARAM.", 0, "");

	if (NOT_FOUND)
        err_mesg("No record found in SY_PROG_PARAM.", 0, "");

	p_fm_doc_date.arr[p_fm_doc_date.len]		= '\0';
	p_to_doc_date.arr[p_to_doc_date.len]		= '\0';
	p_fm_doc_type.arr[p_fm_doc_type.len]		= '\0';
	p_to_doc_type.arr[p_to_doc_type.len]		= '\0';
	p_fm_orig_doc_type.arr[p_fm_orig_doc_type.len]	= '\0';
	p_to_orig_doc_type.arr[p_to_orig_doc_type.len]	= '\0';
	p_fm_orig_doc_date.arr[p_fm_orig_doc_date.len]	= '\0';
	p_to_orig_doc_date.arr[p_to_orig_doc_date.len]	= '\0';
	p_fm_doc_num.arr[p_fm_doc_num.len]				= '\0';  
	p_to_doc_num.arr[p_to_doc_num.len]				= '\0';
	p_fm_srl_num.arr[p_fm_srl_num.len]				= '\0';
	p_to_srl_num.arr[p_to_srl_num.len]				= '\0';
	p_fm_orig_doc_num.arr[p_fm_orig_doc_num.len]	= '\0';
	p_to_orig_doc_num.arr[p_to_orig_doc_num.len]	= '\0';
	nd_proc_yn.arr[nd_proc_yn.len]					= '\0';
	
//disp_message(ERR_MESG,nd_proc_yn);


	/* EXEC SQL DELETE sy_prog_param
             WHERE  pgm_id     = :lv_pgm_id
             AND	session_id = :lv_session_id
             AND	pgm_date   = :lv_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from sy_prog_param  where ((pgm_id=:b0 and session_i\
d=:b1) and pgm_date=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )142;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_pgm_id;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lv_session_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&lv_pgm_date;
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
		err_mesg("DELETE failed on table SY_PROG_PARAM.", 0, "");

		
}
fn_fetch_user()
{
  
  
   lv_user_id.arr[0] = '\0';
   lv_user_id.len    =  0;
   	
	/* EXEC SQL SELECT 	USER
				 INTO   :lv_user_id
				 FROM   SY_ACC_ENTITY
				 WHERE  acc_entity_id = :lv_facility_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select USER into :b0  from SY_ACC_ENTITY where acc_entity_id\
=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )169;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_user_id;
 sqlstm.sqhstl[0] = (unsigned int  )93;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lv_facility_id;
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
		err_mesg("SELECT failed while fetching user.", 0, "");
	
	

	lv_user_id.arr[lv_user_id.len]   = '\0';

}

fn_fetch_hosp_name()
{


	lv_hosp_name.arr[0] = '\0';		
	lv_hosp_name.len    = 0;
	lv_hosp_addr1.arr[0]    = '\0';
	lv_hosp_addr2.arr[0]    = '\0';
	lv_hosp_addr3.arr[0]    = '\0';
	lv_hosp_tel_num.arr[0]  = '\0';
	lv_hosp_fax_num.arr[0]  = '\0';
	lv_sysdate.arr[0]       = '\0';
	lv_base_currency.arr[0] = '\0';

	lv_hosp_addr1.len    = 0;
	lv_hosp_addr2.len    = 0;
	lv_hosp_addr3.len    = 0;
	lv_hosp_tel_num.len  = 0;
	lv_hosp_fax_num.len  = 0;
	lv_sysdate.len       = 0;
	lv_base_currency.len = 0;
	
	

	if (strcmp(lv_lang_id.arr, "US") == 0) 
	{
		/* EXEC SQL SELECT acc_entity_name,
						ln1_add,
						ln2_add,
						ln3_add,
						tel_num,
						fax_num,
						TO_CHAR(sysdate, 'dd/mm/yyyy'),
						base_currency
				 INTO   :lv_hosp_name,
						:lv_hosp_addr1,
						:lv_hosp_addr2,
						:lv_hosp_addr3,
						:lv_hosp_tel_num,
						:lv_hosp_fax_num,
						:lv_sysdate,
						:lv_base_currency
				 FROM   SY_ACC_ENTITY_LANG_VW
				 WHERE  acc_entity_id = :lv_facility_id
				 AND    LANGUAGE_ID   = :lv_lang_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 19;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select acc_entity_name ,ln1_add ,ln2_add ,ln3_add ,tel_num \
,fax_num ,TO_CHAR(sysdate,'dd/mm/yyyy') ,base_currency into :b0,:b1,:b2,:b3,:b\
4,:b5,:b6,:b7  from SY_ACC_ENTITY_LANG_VW where (acc_entity_id=:b8 and LANGUAG\
E_ID=:b9)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )192;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_hosp_name;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lv_hosp_addr1;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&lv_hosp_addr2;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&lv_hosp_addr3;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&lv_hosp_tel_num;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&lv_hosp_fax_num;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&lv_sysdate;
  sqlstm.sqhstl[6] = (unsigned int  )22;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&lv_base_currency;
  sqlstm.sqhstl[7] = (unsigned int  )12;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&lv_facility_id;
  sqlstm.sqhstl[8] = (unsigned int  )5;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&lv_lang_id;
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


	}
	else
	{
		/* EXEC SQL SELECT acc_entity_name_loc_lang,
						ln1_add,
						ln2_add,
						ln3_add,
						tel_num,
						fax_num,
						TO_CHAR(sysdate, 'dd/mm/yyyy'),
						base_currency
				 INTO   :lv_hosp_name,
						:lv_hosp_addr1,
						:lv_hosp_addr2,
						:lv_hosp_addr3,
						:lv_hosp_tel_num,
						:lv_hosp_fax_num,
						:lv_sysdate,
						:lv_base_currency
						
				 FROM   SY_ACC_ENTITY_LANG_VW
				 WHERE  acc_entity_id = :lv_facility_id
				 AND    LANGUAGE_ID   = :lv_lang_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 19;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select acc_entity_name_loc_lang ,ln1_add ,ln2_add ,ln3_add \
,tel_num ,fax_num ,TO_CHAR(sysdate,'dd/mm/yyyy') ,base_currency into :b0,:b1,:\
b2,:b3,:b4,:b5,:b6,:b7  from SY_ACC_ENTITY_LANG_VW where (acc_entity_id=:b8 an\
d LANGUAGE_ID=:b9)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )247;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_hosp_name;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lv_hosp_addr1;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&lv_hosp_addr2;
  sqlstm.sqhstl[2] = (unsigned int  )33;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&lv_hosp_addr3;
  sqlstm.sqhstl[3] = (unsigned int  )33;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&lv_hosp_tel_num;
  sqlstm.sqhstl[4] = (unsigned int  )23;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&lv_hosp_fax_num;
  sqlstm.sqhstl[5] = (unsigned int  )23;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&lv_sysdate;
  sqlstm.sqhstl[6] = (unsigned int  )22;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&lv_base_currency;
  sqlstm.sqhstl[7] = (unsigned int  )12;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&lv_facility_id;
  sqlstm.sqhstl[8] = (unsigned int  )5;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&lv_lang_id;
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


	}

	if (OERROR)
		err_mesg("SELECT failed while fetching hospital Details.", 0, "");
	
	

	lv_hosp_name.arr[lv_hosp_name.len]		   = '\0';
	lv_hosp_addr1.arr[lv_hosp_addr1.len]       = '\0';
	lv_hosp_addr2.arr[lv_hosp_addr2.len]       = '\0';
	lv_hosp_addr3.arr[lv_hosp_addr3.len]       = '\0';
	lv_hosp_tel_num.arr[lv_hosp_tel_num.len]   = '\0';
	lv_hosp_fax_num.arr[lv_hosp_fax_num.len]   = '\0';
	lv_sysdate.arr[lv_sysdate.len]             = '\0';
	lv_base_currency.arr[lv_base_currency.len] = '\0';
}

decl_request_cur()
{
	/* EXEC SQL DECLARE REQUEST_CUR CURSOR FOR
		SELECT PATIENT_ID, episode_type, episode_id, visit_id,
		PAYEE_NAME, PAYEE_NRIC_NO, BANK_NAME, 
		PAYEE_BANK_ACC_NUM,  PAYEE_BANK_OTH_DTL, PAYEE_ADDR_LINE1, 
		PAYEE_ADDR_LINE2, PAYEE_ADDR_LINE3, PAYEE_ADDR_LINE4, 
		PAYEE_POST_BOX, PAYEE_POSTAL_CODE,PAYEE_COUNTRY_CODE,
		DOC_TYPE_CODE,  DOC_NUM ,
		TO_CHAR(DOC_DATE,'DD/MM/YYYY'),
		DOC_SRL_NUM,    
		BILL_RCPT_IND   ,
		ORIG_DOC_TYPE_CODE     ,
		ORIG_DOC_NUM           ,
		ORIG_DOC_SRNO  ,
		TO_CHAR(ORIG_DOC_DATE,'DD/MM/YYYY HH24:MI:SS') ,
		ORIG_DOC_OUTST_AMT
		FROM BL_REFUND_REQUEST_DTL
		WHERE DOC_DATE  >= to_date(nvl(:p_fm_doc_date,'01/01/0001'),'dd/mm/yyyy')
		and DOC_DATE <= to_date(nvl(:p_to_doc_date,'31/12/4712'),'dd/mm/yyyy') 
		and DOC_TYPE_CODE between nvl(:p_fm_doc_type,'!!!!!!') and nvl(:p_to_doc_type,'~~~~~~') 
		and	DOC_NUM between to_number(nvl(:p_fm_doc_num,0)) and to_number(nvl(:p_to_doc_num,99999999))
		and DOC_SRL_NUM  between  to_number(nvl(:p_fm_srl_num,0)) and to_number(nvl(:p_to_srl_num,9999))
		and  ( (:p_orig_doc_ind = 'A' and BILL_RCPT_IND in  ('B', 'R')) 
			or (:p_orig_doc_ind = 'B' and BILL_RCPT_IND = 'B')
			or (:p_orig_doc_ind = 'R' and BILL_RCPT_IND = 'R'))
		and  ORIG_DOC_TYPE_CODE between  nvl(:p_fm_orig_doc_type,'!!!!!!') and nvl(:p_to_orig_doc_type,'~~~~~~')
		and  ORIG_DOC_NUM between to_number(nvl(:p_fm_orig_doc_num,0)) and to_number(nvl(:p_to_orig_doc_num,99999999))
		and  ORIG_DOC_DATE between to_date(nvl(:p_fm_orig_doc_date,'01/01/0001')||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
			 and to_date(nvl(:p_to_orig_doc_date,'31/12/4712')||' 23:59:59','dd/mm/yyyy hh24:mi:ss'); */ 


	if (OERROR)
		err_mesg("DECLARE failed on REQUEST_CUR", 0, "");
}

open_request_cur()
{
	/* EXEC SQL OPEN REQUEST_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 19;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select PATIENT_ID ,episode_type ,episode_id ,visit_id ,PAYEE_NAME ,PAYEE\
_NRIC_NO ,BANK_NAME ,PAYEE_BANK_ACC_NUM ,PAYEE_BANK_OTH_DTL ,PAYEE_ADDR_LINE\
1 ,PAYEE_ADDR_LINE2 ,PAYEE_ADDR_LINE3 ,PAYEE_ADDR_LINE4 ,PAYEE_POST_BOX ,PAY\
EE_POSTAL_CODE ,PAYEE_COUNTRY_CODE ,DOC_TYPE_CODE ,DOC_NUM ,TO_CHAR(DOC_DATE\
,'DD/MM/YYYY') ,DOC_SRL_NUM ,BILL_RCPT_IND ,ORIG_DOC_TYPE_CODE ,ORIG_DOC_NUM\
 ,ORIG_DOC_SRNO ,TO_CHAR(ORIG_DOC_DATE,'DD/MM/YYYY HH24:MI:SS') ,ORIG_DOC_OU\
TST_AMT  from BL_REFUND_REQUEST_DTL where ((((((((DOC_DATE>=to_date(nvl(:b0,\
'01/01/0001'),'dd/mm/yyyy') and DOC_DATE<=to_date(nvl(:b1,'31/12/4712'),'dd/\
mm/yyyy')) and DOC_TYPE_CODE between nvl(:b2,'!!!!!!') and nvl(:b3,'~~~~~~')\
) and DOC_NUM between to_number(nvl(:b4,0)) and to_number(nvl(:b5,99999999))\
) and DOC_SRL_NUM between to_number(nvl(:b6,0)) and to_number(nvl(:b7,9999))\
) and (((:b8='A' and BILL_RCPT_IND in ('B','R')) or (:b8='B' and BILL_RCPT_I\
ND='B')) or (:b8='R' and BILL_RCPT_IND='R'))) and ORIG_DOC_TYPE_CODE between\
 nvl(:b11,'!!!!!!') and nvl(:b12,'~~~~~~");
 sqlstm.stmt = sq0008;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )302;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&p_fm_doc_date;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&p_to_doc_date;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&p_fm_doc_type;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&p_to_doc_type;
 sqlstm.sqhstl[3] = (unsigned int  )9;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&p_fm_doc_num;
 sqlstm.sqhstl[4] = (unsigned int  )11;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&p_to_doc_num;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&p_fm_srl_num;
 sqlstm.sqhstl[6] = (unsigned int  )11;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&p_to_srl_num;
 sqlstm.sqhstl[7] = (unsigned int  )11;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&p_orig_doc_ind;
 sqlstm.sqhstl[8] = (unsigned int  )1;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&p_orig_doc_ind;
 sqlstm.sqhstl[9] = (unsigned int  )1;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&p_orig_doc_ind;
 sqlstm.sqhstl[10] = (unsigned int  )1;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&p_fm_orig_doc_type;
 sqlstm.sqhstl[11] = (unsigned int  )9;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&p_to_orig_doc_type;
 sqlstm.sqhstl[12] = (unsigned int  )9;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&p_fm_orig_doc_num;
 sqlstm.sqhstl[13] = (unsigned int  )11;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&p_to_orig_doc_num;
 sqlstm.sqhstl[14] = (unsigned int  )11;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&p_fm_orig_doc_date;
 sqlstm.sqhstl[15] = (unsigned int  )23;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&p_to_orig_doc_date;
 sqlstm.sqhstl[16] = (unsigned int  )23;
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



	if (OERROR)
		err_mesg("OPEN failed on REQUEST_CUR", 0, "");
}

fn_fetch_request_cur()
{
	fn_init_request_dtls_var();

	/* EXEC SQL FETCH REQUEST_CUR INTO   
					lv_patient_id,
					lc_episode_type,
					lv_episode_id,
					lv_visit_id,
					lv_payee_name,
					lv_payee_nric_no,
					lv_bank_name,
					lv_payee_bank_acc_num,
					lv_payee_bank_oth_dtl,
					lv_payee_addr_line1,
					lv_payee_addr_line2,
					lv_payee_addr_line3,
					lv_payee_addr_line4,
					lv_payee_post_box,
					lv_payee_postal_code,
					lv_payee_country_code,
					lv_doc_type,
					lv_doc_num ,
					lv_doc_date       ,
					lv_doc_srl_num,
					lc_bill_rcpt_ind   ,
					lv_orig_doc_type    ,
					lv_orig_doc_num    ,
					lv_orig_doc_srno,
					lv_orig_doc_date  ,
					ld_orig_doc_outst_amt; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 26;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )385;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&lv_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )23;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lc_episode_type;
 sqlstm.sqhstl[1] = (unsigned int  )1;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&lv_episode_id;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&lv_visit_id;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&lv_payee_name;
 sqlstm.sqhstl[4] = (unsigned int  )43;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&lv_payee_nric_no;
 sqlstm.sqhstl[5] = (unsigned int  )23;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&lv_bank_name;
 sqlstm.sqhstl[6] = (unsigned int  )104;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&lv_payee_bank_acc_num;
 sqlstm.sqhstl[7] = (unsigned int  )23;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&lv_payee_bank_oth_dtl;
 sqlstm.sqhstl[8] = (unsigned int  )104;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&lv_payee_addr_line1;
 sqlstm.sqhstl[9] = (unsigned int  )33;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&lv_payee_addr_line2;
 sqlstm.sqhstl[10] = (unsigned int  )33;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&lv_payee_addr_line3;
 sqlstm.sqhstl[11] = (unsigned int  )33;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&lv_payee_addr_line4;
 sqlstm.sqhstl[12] = (unsigned int  )33;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&lv_payee_post_box;
 sqlstm.sqhstl[13] = (unsigned int  )33;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&lv_payee_postal_code;
 sqlstm.sqhstl[14] = (unsigned int  )33;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&lv_payee_country_code;
 sqlstm.sqhstl[15] = (unsigned int  )33;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&lv_doc_type;
 sqlstm.sqhstl[16] = (unsigned int  )9;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&lv_doc_num;
 sqlstm.sqhstl[17] = (unsigned int  )11;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&lv_doc_date;
 sqlstm.sqhstl[18] = (unsigned int  )22;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&lv_doc_srl_num;
 sqlstm.sqhstl[19] = (unsigned int  )11;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&lc_bill_rcpt_ind;
 sqlstm.sqhstl[20] = (unsigned int  )1;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&lv_orig_doc_type;
 sqlstm.sqhstl[21] = (unsigned int  )9;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&lv_orig_doc_num;
 sqlstm.sqhstl[22] = (unsigned int  )11;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&lv_orig_doc_srno;
 sqlstm.sqhstl[23] = (unsigned int  )11;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&lv_orig_doc_date;
 sqlstm.sqhstl[24] = (unsigned int  )23;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&ld_orig_doc_outst_amt;
 sqlstm.sqhstl[25] = (unsigned int  )sizeof(double);
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



			 
	if (OERROR)
		err_mesg("fetch failed while fetching request details.", 0, "");
		

	fn_fix_request_dtls_var();	

	return(LAST_ROW?0:1);
		 
}

fn_fetch_patient_name()
{
	lv_patient_name.arr[0] = '\0';
	lv_patient_name.len		= 0;

	/* EXEC SQL SELECT decode(:lv_lang_id,'en',SHORT_NAME,SHORT_NAME_LOC_LANG) INTO :lv_patient_name
	FROM MP_PATIENT_MAST
	WHERE PATIENT_ID= :lv_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 26;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select decode(:b0,'en',SHORT_NAME,SHORT_NAME_LOC_LANG) into \
:b1  from MP_PATIENT_MAST where PATIENT_ID=:b2";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )504;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_lang_id;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lv_patient_name;
 sqlstm.sqhstl[1] = (unsigned int  )63;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&lv_patient_id;
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
}



	lv_patient_name.arr[lv_patient_name.len] = '\0';
}

fn_fetch_patient_dtls()
{
	fn_init_patient_dtls_var();

	/* EXEC SQL SELECT ln1_mail_add,
					ln2_mail_add,
					ln3_mail_add,
					mail_postal_code
			 INTO	:lv_mail_addr1,
					:lv_mail_addr2,
					:lv_mail_addr3,
					:lv_mail_po_code
			 FROM   mp_pat_other_dtls
			 WHERE  patient_id = :lv_patient_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 26;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ln1_mail_add ,ln2_mail_add ,ln3_mail_add ,mail_postal\
_code into :b0,:b1,:b2,:b3  from mp_pat_other_dtls where patient_id=:b4";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )531;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_mail_addr1;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lv_mail_addr2;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&lv_mail_addr3;
 sqlstm.sqhstl[2] = (unsigned int  )33;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&lv_mail_po_code;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&lv_patient_id;
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



	if (OERROR)
		err_mesg("SELECT failed on table MP_PAT_OTHER_DTLS.", 0, "");

	fn_fix_patient_dtls_var();
}

fn_fetch_bed_dtls()
{
	lv_cur_bed_num.arr[0]	= '\0';
	lv_cur_bed_class.arr[0]	= '\0';

	lv_cur_bed_num.len		= 0;
	lv_cur_bed_class.len	= 0;

	if (lc_episode_type == 'I')
	{
		/* EXEC SQL Select CUR_BED_NUM, CUR_BED_CLASS_CODE
		into :lv_cur_bed_num, :lv_cur_bed_class
		From ip_episode
		where facility_id= :lv_facility_id 
		and episode_type = 'I' 
		and episode_id = :lv_episode_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 26;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select CUR_BED_NUM ,CUR_BED_CLASS_CODE into :b0,:b1  from i\
p_episode where ((facility_id=:b2 and episode_type='I') and episode_id=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )566;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_cur_bed_num;
  sqlstm.sqhstl[0] = (unsigned int  )11;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lv_cur_bed_class;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&lv_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&lv_episode_id;
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


	}

	if (OERROR)
		err_mesg("SELECT failed on table IP_EPISODE.", 0, "");

	lv_cur_bed_num.arr[lv_cur_bed_num.len]		= '\0';
	lv_cur_bed_class.arr[lv_cur_bed_class.len]	= '\0';
}

fn_open_file()
{
	if (strcmp(nd_proc_yn.arr,"C") == 0)
	{ 

		strcpy(lc_filename, WORKING_DIR);
		strcat(lc_filename, "BLR00077.lis");

		if ((fp = fopen(lc_filename, "w")) == NULL)
		{
			disp_message(ERR_MESG, "Error in opening file BLR00077.lis");
			proc_exit();
		}
	}
}

fn_print_letter()
{
	if (strcmp(nd_proc_yn.arr,"C") == 0)
	{ 
		r_ctr = 0;
		r_ctr6 =0;
		r_ctr1 =0;
		r_ctr3 =0;

		fprintf(fp,"%c(s3B",ESC); 	// To set bold style
		fprintf(fp, "\n %30s%s \n", "", loc_legend[1]); 
		for(i=0;i<90;i++) fprintf(fp,"-");

		fprintf(fp,"\n%c(s-3B",ESC);	// To release bold style
		
		fprintf(fp,"\n\n %-60s%12s: %s \n",loc_legend[2],loc_legend[3], lv_hosp_tel_num.arr);
		
		//fprintf(fp, "\n\n %s%24s%15.15s: %s \n", loc_legend[2]," ", loc_legend[3], lv_hosp_tel_num.arr);
		
		fprintf(fp, " %-60s%12s: %s \n", lv_hosp_name.arr,loc_legend[30],lv_hosp_fax_num.arr);
	
		//fprintf(fp, " %s%45s%15.15s: %s \n", lv_hosp_name.arr," ",loc_legend[30], lv_hosp_fax_num.arr);
		fprintf(fp, " %s \n", lv_hosp_addr1.arr);
		fprintf(fp, " %s \n", lv_hosp_addr2.arr);
		fprintf(fp, " %-40.40s \n",lv_hosp_addr3.arr);

		//fprintf(fp, "%10s %15.15s: %s \n"," ", loc_legend[3], lv_hosp_tel_num.arr);
		//fprintf(fp, "%10s %15.15s: %s \n"," ",loc_legend[30], lv_hosp_fax_num.arr); 

		fprintf(fp,"%c(s3B",ESC);
		for(i=0;i<90;i++) fprintf(fp,"-");
		fprintf(fp,"%c(s-3B\n\n",ESC);

	  
	  if(lv_sysdate.arr[0]!='\0')
	   {
		  init_date_temp_var();
		  strcpy(nd_temp_date.arr,lv_sysdate.arr);
		  fun_change_loc_date();
		  strcpy(date_convert.arr,nd_loc_date.arr);
	   }

		fprintf(fp,"%71s: %s \n\n",loc_legend[4], date_convert.arr);
		//fprintf(fp, "%52s %15.15s: %s \n\n", " ", loc_legend[4], lv_sysdate.arr);

		fprintf(fp,"%c(s3B",ESC); 

		/********* modified 23/11/2005 for truncating report  *******/
		

	   		
	leg_5_26.arr[0] = '\0';
	leg_5_26.len=0;

		   strcpy(leg_5_26.arr,loc_legend[5]);
		   strcat(leg_5_26.arr,loc_legend[26]);


		len = strlen(leg_5_26.arr);
					while(r_ctr < len)
						{	
							split_text(leg_5_26.arr,80,cl_string,&r_ctr);
							fprintf(fp,"%-80.80s",cl_string);
							strcpy(cl_string,"");  
							fprintf(fp,"\n");
						}



			//fprintf(fp, "%s%s \n", loc_legend[5],loc_legend[26]);

			  /***************up to here **********/

		fprintf(fp,"%c(s-3B\n",ESC);

		fprintf(fp, "%s \n", loc_legend[6]);

		fprintf(fp, "%9s %-20.20s: %-55.55s\n\n"," ", loc_legend[7], lv_patient_name.arr);

		fprintf(fp, "%9s %-20.20s: %-55.55s\n\n"," ", loc_legend[8], lv_patient_id.arr);

		if (lc_episode_type == 'I')
		{
			fprintf(fp, "%9s %-20.20s: %-10.10s      "," ", loc_legend[9], lv_cur_bed_num.arr);

			fprintf(fp, "%-10.10s: %-10.10s\n\n",loc_legend[10], lv_cur_bed_class.arr);
		}
		else
		{
			fprintf(fp,"\n\n");
		}
		
		fn_format_doc_num();


	  /*******modified 23/11/2005 for truncation*******/

	leg11_leg28.arr[0] = '\0';
	leg11_leg28.len=0;

		if (lc_bill_rcpt_ind == 'R')
		 {
  
		 strcpy(leg11_leg28.arr,loc_legend[11]);
		 strcat(leg11_leg28.arr,loc_legend[28]);
		 }
		 else
		 {
		 strcpy(leg11_leg28.arr,loc_legend[11]);
		 strcat(leg11_leg28.arr,loc_legend[29]);
		 }

	  /////////////////////////////////////


			   len = strlen(leg11_leg28.arr);
					  if(len>62)
						{
					while(r_ctr6 < len)
						  {	
							split_text(leg11_leg28.arr,80,cl_string6,&r_ctr6);
							fprintf(fp,"%-s",cl_string6);
							if(strlen(cl_string6)>62)
							fprintf(fp,"\n");
							strcpy(cl_string6,"");  
						   }

						 }
						else
					  		fprintf(fp,"%-s",leg11_leg28.arr);

 
	 /////////////////////////////
	   

		fprintf(fp, " %-6.6s/%-10s/%-5s\n",lv_orig_doc_type.arr,lc_doc_num,lv_orig_doc_srno.arr);




		//else
		//fprintf(fp, "%s%s %-6.6s/%-10s/%s ",loc_legend[11],loc_legend[29], lv_orig_doc_type.arr,lc_doc_num,lv_orig_doc_srno);
		
       
	   
	   if(lv_doc_date.arr[0]!='\0')
	   {
	    init_date_temp_var();
	    strcpy(nd_temp_date.arr,lv_doc_date.arr);
        fun_change_loc_date();
	    strcpy(date_convert.arr,nd_loc_date.arr);
	   }
  
		fprintf(fp, "%-15.15s %-12s ",loc_legend[12],date_convert.arr);

   
		fprintf(fp, "%-15s%s",loc_legend[13],lv_base_currency.arr);
		
		print_formated(ld_orig_doc_outst_amt);
		fprintf(fp,"\n\n");


		fn_calc_bal_amt();

    
		fprintf(fp,"%-35s%s ",loc_legend[14],lv_base_currency.arr);
		print_formated(ld_balance_amt);
		fprintf(fp,"\n\n");

		
		
	leg_15.arr[0] = '\0';
	leg_15.len=0;

		strcpy(leg_15.arr,loc_legend[15]);


		len = strlen(leg_15.arr);
		
			while(r_ctr1 < len)
						  {	
							split_text(leg_15.arr,80,cl_string1,&r_ctr1);
							fprintf(fp,"%-s",cl_string1);
							strcpy(cl_string1,""); 
							fprintf(fp,"\n");
							 
						   }

         		fprintf(fp,"\n");

		//fprintf(fp, "%s \n",loc_legend[15]);





		fprintf(fp, "%9s %-20.20s: %-40.40s \n\n"," ",loc_legend[16], lv_payee_name.arr);

		fprintf(fp, "%9s %-20.20s: %-30.30s \n\n"," ",loc_legend[17], lv_payee_nric_no.arr);

		fprintf(fp,"%c(s3B",ESC); 
		fprintf(fp, "%14s %s "," ",loc_legend[18]);
		fprintf(fp,"%c(s-3B\n",ESC);

		fprintf(fp, "%14s %-20.20s: %-30.30s \n"," ",loc_legend[19], lv_bank_name.arr);

		fprintf(fp, "%14s %-20.20s: %-30.30s \n"," ",loc_legend[20], lv_payee_bank_acc_num.arr);

		fprintf(fp, "%14s %-20.20s: %-30.30s \n\n"," ",loc_legend[21], lv_payee_bank_oth_dtl.arr);

		fprintf(fp,"%9s %-70s\n"," ",loc_legend[22]);
		fprintf(fp,"%14s %-66s\n"," ",lv_payee_addr_line1.arr);
		fprintf(fp,"%14s %-66s\n"," ",lv_payee_addr_line2.arr);
		fprintf(fp,"%14s %-66s\n"," ",lv_payee_addr_line3.arr);
		fprintf(fp,"%14s %-66s\n"," ",lv_payee_addr_line4.arr);
		fprintf(fp,"%14s %-66s\n"," ",lv_payee_post_box.arr);
		fprintf(fp,"%14s %-66s\n"," ",lv_payee_postal_code.arr);



		fetch_country(); 

		fprintf(fp,"%14s %-66s\n\n\n"," ",country_name.arr);

    


	legend_cat.arr[0] = '\0';
	legend_cat.len=0;


	  strcpy(legend_cat.arr,loc_legend[23]);
	  strcat(legend_cat.arr,loc_legend[27]);

  		len = strlen(legend_cat.arr);
					while(r_ctr3 < len)
						{	
							split_text(legend_cat.arr,80,cl_string3,&r_ctr3);
							fprintf(fp,"%-s",cl_string3);
							strcpy(cl_string3,"");  
							fprintf(fp,"\n");
						}




		//fprintf(fp, "%s%s \n\n\n\n\n\n%55s ",loc_legend[23],loc_legend[27]," ");

		/////

		fprintf(fp, "\n\n\n\n\n\n%50s "," ");


		for(i=0;i<30;i++) fprintf(fp,".");
		fprintf(fp,"\n");

		fprintf(fp, "%50s %-35.35s \n"," ",loc_legend[24]);

		fprintf(fp, "%50s %-35.35s \n"," ",loc_legend[25]);

		fprintf(fp, "%50s %-35.35s \n"," ",lv_hosp_name.arr);	

		first = 1;
	}	

	else
	{

		
		fn_format_doc_num();
		fn_calc_bal_amt();
		fetch_country();

		/* EXEC SQL INSERT INTO BL_TEMP_REPORT(OPERATING_FACILITY_ID,PGM_ID,SESSION_ID,
						 	PGM_DATE, REC_TYPE,LINE_NUM,desc1,desc2,desc3,desc4,desc5,desc6,desc7,desc8,
							desc9,desc10,desc11,desc12,desc13,desc14,desc15,desc16,desc17,desc18,desc19,desc20,
							desc21,desc22,desc23,desc24,desc25,desc26,desc27,
						 	value1,value2,value3)
						VALUES(:lv_facility_id,:lv_pgm_id,:lv_session_id,:lv_pgm_date,'1',
				  		  1,:lv_hosp_name,:lv_hosp_addr1,:lv_hosp_addr2,:lv_hosp_addr3,:lv_hosp_tel_num,
				      	 :lv_sysdate,:lv_patient_name,:lv_patient_id,
						 :lv_cur_bed_num,:lv_cur_bed_class,:lv_orig_doc_type, 
						 :lv_doc_date,:lv_base_currency,:lv_payee_name,:lv_payee_nric_no,
						 :lv_bank_name,:lv_payee_bank_acc_num,
						 :lv_payee_bank_oth_dtl,:lv_payee_addr_line1,:lv_payee_addr_line2,:lv_payee_addr_line3,
						 :lv_payee_addr_line4,:lv_payee_post_box,:lv_payee_postal_code,:country_name,:lc_bill_rcpt_ind,
						 :lv_hosp_fax_num,:lc_doc_num,:ld_orig_doc_outst_amt,:ld_balance_amt); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 34;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into BL_TEMP_REPORT (OPERATING_FACILITY_ID,PGM_ID,SE\
SSION_ID,PGM_DATE,REC_TYPE,LINE_NUM,desc1,desc2,desc3,desc4,desc5,desc6,desc7,\
desc8,desc9,desc10,desc11,desc12,desc13,desc14,desc15,desc16,desc17,desc18,des\
c19,desc20,desc21,desc22,desc23,desc24,desc25,desc26,desc27,value1,value2,valu\
e3) values (:b0,:b1,:b2,:b3,'1',1,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,\
:b14,:b15,:b16,:b17,:b18,:b19,:b20,:b21,:b22,:b23,:b24,:b25,:b26,:b27,:b28,:b2\
9,:b30,:b31,:b32,:b33)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )597;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lv_pgm_id;
  sqlstm.sqhstl[1] = (unsigned int  )12;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&lv_session_id;
  sqlstm.sqhstl[2] = (unsigned int  )18;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&lv_pgm_date;
  sqlstm.sqhstl[3] = (unsigned int  )27;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&lv_hosp_name;
  sqlstm.sqhstl[4] = (unsigned int  )102;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&lv_hosp_addr1;
  sqlstm.sqhstl[5] = (unsigned int  )33;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&lv_hosp_addr2;
  sqlstm.sqhstl[6] = (unsigned int  )33;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&lv_hosp_addr3;
  sqlstm.sqhstl[7] = (unsigned int  )33;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&lv_hosp_tel_num;
  sqlstm.sqhstl[8] = (unsigned int  )23;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&lv_sysdate;
  sqlstm.sqhstl[9] = (unsigned int  )22;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&lv_patient_name;
  sqlstm.sqhstl[10] = (unsigned int  )63;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&lv_patient_id;
  sqlstm.sqhstl[11] = (unsigned int  )23;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&lv_cur_bed_num;
  sqlstm.sqhstl[12] = (unsigned int  )11;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&lv_cur_bed_class;
  sqlstm.sqhstl[13] = (unsigned int  )5;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)&lv_orig_doc_type;
  sqlstm.sqhstl[14] = (unsigned int  )9;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)&lv_doc_date;
  sqlstm.sqhstl[15] = (unsigned int  )22;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)&lv_base_currency;
  sqlstm.sqhstl[16] = (unsigned int  )12;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)&lv_payee_name;
  sqlstm.sqhstl[17] = (unsigned int  )43;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)&lv_payee_nric_no;
  sqlstm.sqhstl[18] = (unsigned int  )23;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)&lv_bank_name;
  sqlstm.sqhstl[19] = (unsigned int  )104;
  sqlstm.sqhsts[19] = (         int  )0;
  sqlstm.sqindv[19] = (         void  *)0;
  sqlstm.sqinds[19] = (         int  )0;
  sqlstm.sqharm[19] = (unsigned int  )0;
  sqlstm.sqadto[19] = (unsigned short )0;
  sqlstm.sqtdso[19] = (unsigned short )0;
  sqlstm.sqhstv[20] = (         void  *)&lv_payee_bank_acc_num;
  sqlstm.sqhstl[20] = (unsigned int  )23;
  sqlstm.sqhsts[20] = (         int  )0;
  sqlstm.sqindv[20] = (         void  *)0;
  sqlstm.sqinds[20] = (         int  )0;
  sqlstm.sqharm[20] = (unsigned int  )0;
  sqlstm.sqadto[20] = (unsigned short )0;
  sqlstm.sqtdso[20] = (unsigned short )0;
  sqlstm.sqhstv[21] = (         void  *)&lv_payee_bank_oth_dtl;
  sqlstm.sqhstl[21] = (unsigned int  )104;
  sqlstm.sqhsts[21] = (         int  )0;
  sqlstm.sqindv[21] = (         void  *)0;
  sqlstm.sqinds[21] = (         int  )0;
  sqlstm.sqharm[21] = (unsigned int  )0;
  sqlstm.sqadto[21] = (unsigned short )0;
  sqlstm.sqtdso[21] = (unsigned short )0;
  sqlstm.sqhstv[22] = (         void  *)&lv_payee_addr_line1;
  sqlstm.sqhstl[22] = (unsigned int  )33;
  sqlstm.sqhsts[22] = (         int  )0;
  sqlstm.sqindv[22] = (         void  *)0;
  sqlstm.sqinds[22] = (         int  )0;
  sqlstm.sqharm[22] = (unsigned int  )0;
  sqlstm.sqadto[22] = (unsigned short )0;
  sqlstm.sqtdso[22] = (unsigned short )0;
  sqlstm.sqhstv[23] = (         void  *)&lv_payee_addr_line2;
  sqlstm.sqhstl[23] = (unsigned int  )33;
  sqlstm.sqhsts[23] = (         int  )0;
  sqlstm.sqindv[23] = (         void  *)0;
  sqlstm.sqinds[23] = (         int  )0;
  sqlstm.sqharm[23] = (unsigned int  )0;
  sqlstm.sqadto[23] = (unsigned short )0;
  sqlstm.sqtdso[23] = (unsigned short )0;
  sqlstm.sqhstv[24] = (         void  *)&lv_payee_addr_line3;
  sqlstm.sqhstl[24] = (unsigned int  )33;
  sqlstm.sqhsts[24] = (         int  )0;
  sqlstm.sqindv[24] = (         void  *)0;
  sqlstm.sqinds[24] = (         int  )0;
  sqlstm.sqharm[24] = (unsigned int  )0;
  sqlstm.sqadto[24] = (unsigned short )0;
  sqlstm.sqtdso[24] = (unsigned short )0;
  sqlstm.sqhstv[25] = (         void  *)&lv_payee_addr_line4;
  sqlstm.sqhstl[25] = (unsigned int  )33;
  sqlstm.sqhsts[25] = (         int  )0;
  sqlstm.sqindv[25] = (         void  *)0;
  sqlstm.sqinds[25] = (         int  )0;
  sqlstm.sqharm[25] = (unsigned int  )0;
  sqlstm.sqadto[25] = (unsigned short )0;
  sqlstm.sqtdso[25] = (unsigned short )0;
  sqlstm.sqhstv[26] = (         void  *)&lv_payee_post_box;
  sqlstm.sqhstl[26] = (unsigned int  )33;
  sqlstm.sqhsts[26] = (         int  )0;
  sqlstm.sqindv[26] = (         void  *)0;
  sqlstm.sqinds[26] = (         int  )0;
  sqlstm.sqharm[26] = (unsigned int  )0;
  sqlstm.sqadto[26] = (unsigned short )0;
  sqlstm.sqtdso[26] = (unsigned short )0;
  sqlstm.sqhstv[27] = (         void  *)&lv_payee_postal_code;
  sqlstm.sqhstl[27] = (unsigned int  )33;
  sqlstm.sqhsts[27] = (         int  )0;
  sqlstm.sqindv[27] = (         void  *)0;
  sqlstm.sqinds[27] = (         int  )0;
  sqlstm.sqharm[27] = (unsigned int  )0;
  sqlstm.sqadto[27] = (unsigned short )0;
  sqlstm.sqtdso[27] = (unsigned short )0;
  sqlstm.sqhstv[28] = (         void  *)&country_name;
  sqlstm.sqhstl[28] = (unsigned int  )18;
  sqlstm.sqhsts[28] = (         int  )0;
  sqlstm.sqindv[28] = (         void  *)0;
  sqlstm.sqinds[28] = (         int  )0;
  sqlstm.sqharm[28] = (unsigned int  )0;
  sqlstm.sqadto[28] = (unsigned short )0;
  sqlstm.sqtdso[28] = (unsigned short )0;
  sqlstm.sqhstv[29] = (         void  *)&lc_bill_rcpt_ind;
  sqlstm.sqhstl[29] = (unsigned int  )1;
  sqlstm.sqhsts[29] = (         int  )0;
  sqlstm.sqindv[29] = (         void  *)0;
  sqlstm.sqinds[29] = (         int  )0;
  sqlstm.sqharm[29] = (unsigned int  )0;
  sqlstm.sqadto[29] = (unsigned short )0;
  sqlstm.sqtdso[29] = (unsigned short )0;
  sqlstm.sqhstv[30] = (         void  *)&lv_hosp_fax_num;
  sqlstm.sqhstl[30] = (unsigned int  )23;
  sqlstm.sqhsts[30] = (         int  )0;
  sqlstm.sqindv[30] = (         void  *)0;
  sqlstm.sqinds[30] = (         int  )0;
  sqlstm.sqharm[30] = (unsigned int  )0;
  sqlstm.sqadto[30] = (unsigned short )0;
  sqlstm.sqtdso[30] = (unsigned short )0;
  sqlstm.sqhstv[31] = (         void  *)lc_doc_num;
  sqlstm.sqhstl[31] = (unsigned int  )9;
  sqlstm.sqhsts[31] = (         int  )0;
  sqlstm.sqindv[31] = (         void  *)0;
  sqlstm.sqinds[31] = (         int  )0;
  sqlstm.sqharm[31] = (unsigned int  )0;
  sqlstm.sqadto[31] = (unsigned short )0;
  sqlstm.sqtdso[31] = (unsigned short )0;
  sqlstm.sqhstv[32] = (         void  *)&ld_orig_doc_outst_amt;
  sqlstm.sqhstl[32] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[32] = (         int  )0;
  sqlstm.sqindv[32] = (         void  *)0;
  sqlstm.sqinds[32] = (         int  )0;
  sqlstm.sqharm[32] = (unsigned int  )0;
  sqlstm.sqadto[32] = (unsigned short )0;
  sqlstm.sqtdso[32] = (unsigned short )0;
  sqlstm.sqhstv[33] = (         void  *)&ld_balance_amt;
  sqlstm.sqhstl[33] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[33] = (         int  )0;
  sqlstm.sqindv[33] = (         void  *)0;
  sqlstm.sqinds[33] = (         int  )0;
  sqlstm.sqharm[33] = (unsigned int  )0;
  sqlstm.sqadto[33] = (unsigned short )0;
  sqlstm.sqtdso[33] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



						 /* EXEC SQL COMMIT; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 34;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )748;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	
		
		if (OERROR)
		err_mesg("INSERT failed on table BL_TEMP_REPORT.", 0, "");
				
	}
	

		  /*******modified 27/12/2006 *******/
}

delete_bl_temp_report()
{
	/* EXEC SQL DELETE FROM BL_TEMP_REPORT WHERE OPERATING_FACILITY_ID = :lv_facility_id AND
											  PGM_ID = :lv_pgm_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 34;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from BL_TEMP_REPORT  where (OPERATING_FACILITY_ID=:b\
0 and PGM_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )763;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lv_pgm_id;
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
}



		if (OERROR)
		err_mesg("DELETE failed on table BL_TEMP_REPORT.", 0, "");
}

fn_calc_bal_amt()
{
	ld_balance_amt = 0;

	if (lc_bill_rcpt_ind == 'R')
	{
		/* EXEC SQL SELECT sum(nvl(doc_amt,0)) 
		INTO :ld_balance_amt 
		FROM bl_receipt_refund_dtl
		WHERE doc_type_code = :lv_orig_doc_type
		AND doc_number = :lv_orig_doc_num
		AND DOC_SRNO =:lv_orig_doc_srno; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 34;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(nvl(doc_amt,0)) into :b0  from bl_receipt_refund\
_dtl where ((doc_type_code=:b1 and doc_number=:b2) and DOC_SRNO=:b3)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )786;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&ld_balance_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lv_orig_doc_type;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&lv_orig_doc_num;
  sqlstm.sqhstl[2] = (unsigned int  )11;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&lv_orig_doc_srno;
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


	}
	
	if (lc_bill_rcpt_ind == 'B')
	{
		/* EXEC SQL SELECT SUM(nvl(bill_tot_outst_amt,0))
		INTO :ld_balance_amt
		FROM bl_bill_dcp_dtl_vw
		WHERE doc_type_code = :lv_orig_doc_type
		AND doc_num = :lv_orig_doc_num; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 34;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select sum(nvl(bill_tot_outst_amt,0)) into :b0  from bl_bil\
l_dcp_dtl_vw where (doc_type_code=:b1 and doc_num=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )817;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&ld_balance_amt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lv_orig_doc_type;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&lv_orig_doc_num;
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


		
	}
}

fn_init_request_dtls_var()
{
	lv_patient_id.arr[0]			= '\0';
	lv_episode_id.arr[0]			= '\0';
	lv_visit_id.arr[0]				= '\0';
	lv_payee_name.arr[0]			= '\0';
	lv_payee_nric_no.arr[0]			= '\0';
	lv_bank_name.arr[0]				= '\0';
	lv_payee_bank_acc_num.arr[0]	= '\0';
	lv_payee_bank_oth_dtl.arr[0]	= '\0';
	lv_payee_addr_line1.arr[0]		= '\0';
	lv_payee_addr_line2.arr[0]		= '\0';
	lv_payee_addr_line3.arr[0]		= '\0';
	lv_payee_addr_line4.arr[0]		= '\0';
	lv_payee_post_box.arr[0]		= '\0';
	lv_payee_postal_code.arr[0]		= '\0';
	lv_payee_country_code.arr[0]	= '\0';
	lv_doc_type.arr[0]				= '\0';
	lv_doc_date.arr[0]				= '\0';
	lv_orig_doc_type.arr[0]			= '\0';
	lv_orig_doc_num.arr[0]			= '\0';
	lv_orig_doc_srno.arr[0]			= '\0';
	lv_orig_doc_date.arr[0]			= '\0';
	
	lv_patient_id.len			= 0;
	lv_episode_id.len			= 0;
	lv_visit_id.len				= 0;
	lv_payee_name.len			= 0;
	lv_payee_nric_no.len		= 0;
	lv_bank_name.len			= 0;
	lv_payee_bank_acc_num.len	= 0;
	lv_payee_bank_oth_dtl.len	= 0;
	lv_payee_addr_line1.len		= 0;
	lv_payee_addr_line2.len		= 0;
	lv_payee_addr_line3.len		= 0;
	lv_payee_addr_line4.len		= 0;
	lv_payee_post_box.len		= 0;
	lv_payee_postal_code.len	= 0;
	lv_payee_country_code.len	= 0;
	lv_doc_type.len				= 0;
	lv_doc_date.len				= 0;
	lv_orig_doc_type.len		= 0;
	lv_orig_doc_num.len			= 0;
	lv_orig_doc_srno.len		= 0;
	lv_orig_doc_date.len		= 0;

}	

fn_fix_request_dtls_var()
{
	lv_patient_id.arr[lv_patient_id.len]					= '\0';
	lv_episode_id.arr[lv_episode_id.len]					= '\0';
	lv_visit_id.arr[lv_visit_id.len]						= '\0';
	lv_payee_name.arr[lv_payee_name.len]					= '\0';
	lv_payee_nric_no.arr[lv_payee_nric_no.len]				= '\0';
	lv_bank_name.arr[lv_bank_name.len]						= '\0';
	lv_payee_bank_acc_num.arr[lv_payee_bank_acc_num.len]	= '\0';
	lv_payee_bank_oth_dtl.arr[lv_payee_bank_oth_dtl.len]	= '\0';
	lv_payee_addr_line1.arr[lv_payee_addr_line1.len]		= '\0';
	lv_payee_addr_line2.arr[lv_payee_addr_line2.len]		= '\0';
	lv_payee_addr_line3.arr[lv_payee_addr_line3.len]		= '\0';
	lv_payee_addr_line4.arr[lv_payee_addr_line4.len]		= '\0';
	lv_payee_post_box.arr[lv_payee_post_box.len]			= '\0';
	lv_payee_postal_code.arr[lv_payee_postal_code.len]		= '\0';
	lv_payee_country_code.arr[lv_payee_country_code.len]	= '\0';
	lv_doc_type.arr[lv_doc_type.len]						= '\0';
	lv_doc_date.arr[lv_doc_date.len]						= '\0';
	lv_orig_doc_type.arr[lv_orig_doc_type.len]				= '\0';
	lv_orig_doc_num.arr[lv_orig_doc_num.len]				= '\0';
	lv_orig_doc_srno.arr[lv_orig_doc_srno.len]				= '\0';
	lv_orig_doc_date.arr[lv_orig_doc_date.len]				= '\0';
	
}

fetch_country()
{
country_name.arr[0]   ='\0';
country_name.len =0;
  /* EXEC SQL Select COUNTRY_NAME into :country_name From  mp_country_his_vw
  Where country_code=:lv_payee_country_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 34;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select COUNTRY_NAME into :b0  from mp_country_his_vw where \
country_code=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )844;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&country_name;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&lv_payee_country_code;
  sqlstm.sqhstl[1] = (unsigned int  )33;
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
		err_mesg("SELECT failed while fetching from mp_country_his_vw", 0, "");

country_name.arr[country_name.len]   ='\0';


}

fn_init_patient_dtls_var()
{
	lv_mail_addr1.arr[0]   = '\0';
	lv_mail_addr2.arr[0]   = '\0';
	lv_mail_addr3.arr[0]   = '\0';
	lv_mail_po_code.arr[0] = '\0'; 
	
	lv_mail_addr1.len   = 0;
	lv_mail_addr2.len   = 0;
	lv_mail_addr3.len   = 0;
	lv_mail_po_code.len = 0;
}

fn_fix_patient_dtls_var()
{
	lv_mail_addr1.arr[lv_mail_addr1.len]     = '\0';
	lv_mail_addr2.arr[lv_mail_addr2.len]     = '\0';
	lv_mail_addr3.arr[lv_mail_addr3.len]     = '\0';
	lv_mail_po_code.arr[lv_mail_po_code.len] = '\0'; 
}

fn_format_amt_str(ld_get_amt)
	double ld_get_amt;
{
	put_val(lc_actl_amt, ld_get_amt);
    format_amt(lc_actl_amt);
	sprintf(lc_char_amt,"%s",lc_actl_amt);
}

fn_format_doc_num()
{
	/* EXEC SQL SELECT LPAD(to_char(to_number(:lv_orig_doc_num)), 8, '0')
			 INTO   :lc_doc_num
			 FROM   DUAL; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 34;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LPAD(to_char(to_number(:b0)),8,'0') into :b1  from DU\
AL ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )867;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_orig_doc_num;
 sqlstm.sqhstl[0] = (unsigned int  )11;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)lc_doc_num;
 sqlstm.sqhstl[1] = (unsigned int  )9;
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


fn_get_legend()
{
	lv_lgnd_val.arr[0] = '\0';		
	lv_lgnd_val.len    = 0;
	
	if (strcmp(lv_lang_id.arr, "US") == 0) 
	{
		/* EXEC SQL SELECT RTRIM(SUBSTR(dflt_legend_value, 1, 50))
				 INTO   :lv_lgnd_val
				 FROM   sm_lang_legend
				 WHERE  legend_id LIKE 'BLR00077.LEGEND_'||:lc_lgnd_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 34;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select RTRIM(SUBSTR(dflt_legend_value,1,50)) into :b0  from\
 sm_lang_legend where legend_id like ('BLR00077.LEGEND_'||:b1)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )890;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_lgnd_val;
  sqlstm.sqhstl[0] = (unsigned int  )53;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)lc_lgnd_id;
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


	}
	else
	{
		/* EXEC SQL SELECT RTRIM(SUBSTR(column_value, 1, 50))
				 INTO   :lv_lgnd_val
				 FROM   sm_record_trans_data, sm_lang_legend
				 WHERE  module_id    = 'SM' 
				 AND	table_id     = 'SM_LANG_LEGEND'
				 AND    column_id    = 'DFLT_LEGEND_VALUE'
				 AND    pk_value     = legend_id
				 AND    legend_id LIKE 'BLR00077.LEGEND_'||:lc_lgnd_id
				 AND    language_id  = :lv_lang_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 34;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select RTRIM(SUBSTR(column_value,1,50)) into :b0  from sm_r\
ecord_trans_data ,sm_lang_legend where (((((module_id='SM' and table_id='SM_LA\
NG_LEGEND') and column_id='DFLT_LEGEND_VALUE') and pk_value=legend_id) and leg\
end_id like ('BLR00077.LEGEND_'||:b1)) and language_id=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )913;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_lgnd_val;
  sqlstm.sqhstl[0] = (unsigned int  )53;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)lc_lgnd_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&lv_lang_id;
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


	}

	if (OERROR)
		err_mesg("SELECT failed while fetching legend values.", 0, "");

	lv_lgnd_val.arr[lv_lgnd_val.len] = '\0';	
}

fetch_legend_value()
{
	for(i=1;i<=300;i++)
	{
		l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00077.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		           INTO :l_pk_value
				   FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 34;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00077.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )940;
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
			blcommon.get_local_lang_desc(:lv_facility_id,
										'SM',
										'SM_LANG_LEGEND',
										'DFLT_LEGEND_VALUE',
										:l_pk_value,
										:l_translated_value,
										:lv_lang_id);
		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 34;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :lv_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :lv_lang_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )963;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&lv_facility_id;
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
  sqlstm.sqhstv[3] = (         void  *)&lv_lang_id;
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



		l_translated_value.arr[l_translated_value.len] = '\0';
		strcpy(loc_legend[i],l_translated_value.arr);
	}
}



/*fn_print_online()
{
	PrintDocument(
				  lv_pword.arr,				//char	*PUidPwd;
				  lv_session_id.arr,		//char	*PSessionID;
				  lv_facility_id.arr,		//char	*PFacilityID;
				  "BL",						//char	*PModuleID;
				  lv_pgm_id.arr,			//char	*PDocumentID;
				  lc_filename,				//char	*POnlinePrintFileNames;
				  "O",						//char	*PLocationTypes;
				  " ",						//char	*PLocationCodes;
				  1,						//int	PNumOfCopies;
				  1,						//int	PPageFrom;
				  9999						//int	PPageTo;
				 );


}*/

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

fn_print_settings()
{
	fprintf(fp,"%c(s0P",ESC);		// To fix the primary spacing
	fprintf(fp,"%c&l0O",ESC); 		// To print in portait mode
	fprintf(fp,"%c(s4099T",ESC);	// To set the font name	
	fprintf(fp,"%c&l8D",ESC); 		// To set vertical lines per inch
	fprintf(fp,"%c&a4L",ESC); 		// To set the left margin
	fprintf(fp,"%c&l6E",ESC); 		// To set the top margin
	fprintf(fp,"%c(s12.5H",ESC); 		// To set the font
	
	//fprintf(fp,"%c&l0H",ESC);		// To eject page
	//fprintf(fp,"%cE",ESC);		// To reset the printer
	//fprintf(fp,"%c&d0D",ESC);		// To set underline mode
	//fprintf(fp,"%c&d@",ESC);		// To release underline mode
	//fprintf(fp,"%c(s3B",ESC); 	// To set bold style
	//fprintf(fp,"%c(s-3B",ESC);	// To release bold style
}

get_language_id()
{
	lv_lang_id.arr[0] = '\0';
	lv_lang_id.len = 0;
	
	/* EXEC SQL SELECT LANGUAGE_ID INTO :lv_lang_id FROM SM_APPL_USER where APPL_USER_ID = :lv_user_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 34;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select LANGUAGE_ID into :b0  from SM_APPL_USER where APPL_US\
ER_ID=:b1";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )994;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&lv_lang_id;
 sqlstm.sqhstl[0] = (unsigned int  )7;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&lv_user_id;
 sqlstm.sqhstl[1] = (unsigned int  )93;
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
        err_mesg("SELECTING LANGUAGE_ID failed",0,"");
}

init_date_temp_var()

{
	nd_temp_date.arr[0] = '\0';
	nd_loc_date.arr[0]  = '\0';
	date_convert.arr[0]  = '\0';

	nd_temp_date.len = 0;
	nd_loc_date.len  = 0;
	date_convert.len  = 0;

}

fun_change_loc_date()
{

nd_temp_date.len = strlen(nd_temp_date.arr);
nd_temp_date.arr[nd_temp_date.len]='\0';
get_local_date();

}


get_local_date()
{

	/* EXEC SQL EXECUTE
	
	DECLARE
    
	t_date date;	

	BEGIN
		get_locale_date.convert_to_locale_date(TO_DATE(:nd_temp_date,'dd/mm/yyyy'),
					 :lv_lang_id,
					  t_date);

		:nd_loc_date:=to_char(t_date,'DD/MM/YYYY');
	
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 34;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "declare t_date date ; BEGIN get_locale_date . convert_to_loc\
ale_date ( TO_DATE ( :nd_temp_date , 'dd/mm/yyyy' ) , :lv_lang_id , t_date ) ;\
 :nd_loc_date := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1017;
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
 sqlstm.sqhstv[1] = (         void  *)&lv_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )7;
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
