
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
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/BL/BLR00061.PC"
};


static unsigned int sqlctx = 1288460931;


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
            void  *sqhstv[20];
   unsigned int   sqhstl[20];
            int   sqhsts[20];
            void  *sqindv[20];
            int   sqinds[20];
   unsigned int   sqharm[20];
   unsigned int   *sqharc[20];
   unsigned short  sqadto[20];
   unsigned short  sqtdso[20];
} sqlstm = {12,20};

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
"D_CLASS_CODE,to_char(B.ADMISSION_DATE_TIME,'dd/mm/yyyy') order by 1,3,9     \
       ";

 static const char *sq0005 = 
"select ((a.doc_type_code||'/')||a.doc_num) bill_num ,TO_CHAR(a.doc_date,'DD/\
MM/YYYY') bill_date  from bl_bill_dcp_dtl_vw a ,bl_blng_grp_by_catg d where ((\
((((((a.operating_facility_id=:b0 and a.episode_type=:b1) and a.episode_id=:b2\
) and a.patient_id=:b3) and a.blng_grp_id=d.blng_grp_id(+)) and nvl(a.bill_sta\
tus,'X')<>'C') and a.bed_class_code=:b4) and nvl(d.blng_grp_catg,'**')=:b5) an\
d a.ward_code=:b6) order by a.doc_date            ";

 static const char *sq0006 = 
"select ((a.doc_type_code||'/')||a.doc_number) dep_receipt ,TO_CHAR(a.doc_Dat\
e,'DD/MM/YYYY') dep_receipt_date  from bl_receipt_refund_hdr a where ((((((a.o\
perating_facility_id=:b0 and a.recpt_nature_code in ('AD','PR')) and a.patient\
_id=:b1) and a.episode_id=:b2) and a.episode_type=:b3) and nvl(a.cancelled_ind\
,'N')<>'Y') and a.recpt_refund_ind='R') order by a.doc_date            ";

 static const char *sq0007 = 
"select ((a.doc_type_code||'/')||a.doc_number) receipt_no ,TO_CHAR(a.doc_Date\
,'DD/MM/YYYY') receipt_date  from bl_receipt_refund_hdr a ,bl_bill_hdr b ,bl_b\
lng_grp_by_catg c where (((((((((((a.recpt_nature_code in ('BI') and a.patient\
_id=:b0) and a.episode_id=:b1) and a.episode_type=:b2) and nvl(a.cancelled_ind\
,'N')<>'Y') and a.recpt_refund_ind='R') and a.bill_doc_type_code=b.doc_type_co\
de) and a.bill_doc_number=b.doc_num) and b.blng_grp_id=c.blng_grp_id(+)) and b\
.bed_class_code=:b3) and b.ward_code=:b4) and nvl(c.blng_grp_catg,'**')=:b5) o\
rder by 2            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,1,91,0,2,308,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
28,0,0,2,0,0,30,317,0,0,0,0,0,1,0,
43,0,0,0,0,0,27,326,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
74,0,0,4,3155,0,9,449,0,0,20,20,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
169,0,0,5,438,0,9,502,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
212,0,0,6,381,0,9,503,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
243,0,0,7,565,0,9,504,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,
282,0,0,5,0,0,13,522,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
305,0,0,6,0,0,13,540,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
328,0,0,7,0,0,13,559,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
351,0,0,5,0,0,15,578,0,0,0,0,0,1,0,
366,0,0,6,0,0,15,579,0,0,0,0,0,1,0,
381,0,0,7,0,0,15,580,0,0,0,0,0,1,0,
396,0,0,4,0,0,13,622,0,0,20,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,2,4,0,0,
491,0,0,8,73,0,4,668,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
514,0,0,9,271,0,4,708,0,0,11,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
573,0,0,10,269,0,4,854,0,0,5,4,0,1,0,2,4,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
608,0,0,11,128,0,4,1167,0,0,4,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
639,0,0,12,96,0,4,1230,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
662,0,0,13,165,0,6,1237,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,1,9,0,0,
693,0,0,14,73,0,4,1297,0,0,5,4,0,1,0,1,97,0,0,1,9,0,0,1,97,0,0,1,9,0,0,2,9,0,0,
728,0,0,15,231,0,4,1456,0,0,7,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,1,9,0,0,
771,0,0,16,0,0,32,1481,0,0,0,0,0,1,0,
};


/************************************************************************/
/* PROGRAM NAME          : BLR00061.PC                                  */
/* AUTHOR                : D Ganesh Murthi                              */
/* DATE WRITTEN          : 15/02/2005                                	*/
/*                                                                      */
/* CALLED FROM           :                                              */
/*                                                                      */
/************************************************************************/

#include <stdio.h>  
#include <string.h>
#include <bl.h>   

#define OERROR				(sqlca.sqlcode < 0)
#define LAST_ROW			(sqlca.sqlcode == 1403)
#define NO_DATA_FOUND		(sqlca.sqlcode == 1403)
#define NOT_FOUND			(sqlca.sqlerrd[2] == 0)
#define RESOURCE_BUSY			(sqlca.sqlcode == -54)
#define DUPLICATE_KEY			(sqlca.sqlcode == -1)
#define	MAX_LINES			60
#define ESC				0x1B
#define INIT_MESG			"Report Generation is in progress"

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* VARCHAR		uid_pwd					[132],
			hosp_name				[120],
			date_time				[20],
			user_id					[20],
			nd_pgm_date				[35],
			nd_facility_name		[100],
			nd_session_id			[16],
			nd_facility_id			[3],
			d_acc_entity_name		[41],
			d_user					[21],
			d_sysdate				[17],
			date					[20]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[100]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[41]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[20]; } date;

            
/* VARCHAR		nd_lang_id				[4],
			l_pk_value				[200],
			l_translated_value		[201],
			l_from_and_to_date		[71]; */ 
struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[200]; } l_pk_value;

struct { unsigned short len; unsigned char arr[201]; } l_translated_value;

struct { unsigned short len; unsigned char arr[71]; } l_from_and_to_date;


/* VARCHAR 	nd_fr_date				[20],
			nd_to_date				[20],
			l_sysdate				[20],
			l_hospital_name			[50],
			d_base_currency			[9],
			nd_episode_type			[3],	
			nd_blng_grp_fr_catg		[5],
			nd_blng_grp_to_catg		[5],
			nd_fr_nur_unit			[5],
			nd_to_nur_unit			[5],
			nd_fr_bed_class			[3],
			nd_to_bed_class			[3]; */ 
struct { unsigned short len; unsigned char arr[20]; } nd_fr_date;

struct { unsigned short len; unsigned char arr[20]; } nd_to_date;

struct { unsigned short len; unsigned char arr[20]; } l_sysdate;

struct { unsigned short len; unsigned char arr[50]; } l_hospital_name;

struct { unsigned short len; unsigned char arr[9]; } d_base_currency;

struct { unsigned short len; unsigned char arr[3]; } nd_episode_type;

struct { unsigned short len; unsigned char arr[5]; } nd_blng_grp_fr_catg;

struct { unsigned short len; unsigned char arr[5]; } nd_blng_grp_to_catg;

struct { unsigned short len; unsigned char arr[5]; } nd_fr_nur_unit;

struct { unsigned short len; unsigned char arr[5]; } nd_to_nur_unit;

struct { unsigned short len; unsigned char arr[3]; } nd_fr_bed_class;

struct { unsigned short len; unsigned char arr[3]; } nd_to_bed_class;
	

/* VARCHAR		d_blng_grp_catg			[5],
            d_nur_unit  			[5], 
		    d_blng_grp_catg_desc	[40],
			d_prv_blng_grp_catg		[5],
    		d_blng_grp_id			[5],
    		d_short_name			[61],
    		d_patient_id			[21],
    		d_episode_type			[3],
    		d_episode_id			[9],
    		d_visit_id				[5],
    		d_bed_class_code		[3],
    		d_admission_date		[20],
			
			p_language_id			[3],

    		d_discharge_date_time	[20]; */ 
struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_catg;

struct { unsigned short len; unsigned char arr[5]; } d_nur_unit;

struct { unsigned short len; unsigned char arr[40]; } d_blng_grp_catg_desc;

struct { unsigned short len; unsigned char arr[5]; } d_prv_blng_grp_catg;

struct { unsigned short len; unsigned char arr[5]; } d_blng_grp_id;

struct { unsigned short len; unsigned char arr[61]; } d_short_name;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[3]; } d_episode_type;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[3]; } d_bed_class_code;

struct { unsigned short len; unsigned char arr[20]; } d_admission_date;

struct { unsigned short len; unsigned char arr[3]; } p_language_id;

struct { unsigned short len; unsigned char arr[20]; } d_discharge_date_time;


double		d_deposit_adj_amt_pd ,
			d_bill_amt ,
			d_disc_amt ,
			d_tot_adj_amt ,
			d_tot_exempt_amt ,
			d_tot_paid_amt ,
			d_tot_efund_amt ,
			d_tot_write_off_amt ,
			d_bill_tot_outst_amt;

/* Pradeep 23-10-2006 */
double		l_sub_deposit_total,
			l_sub_bill_total,
			l_sub_exemption_total,
			l_sub_paid_total,
			l_sub_refund_total,
			l_sub_reconsilation_total,
			l_sub_writeoff_total,
			l_sub_outst_total,
			l_grand_deposit_total,
			l_grand_bill_total,
			l_grand_exemption_total,
			l_grand_paid_total,
			l_grand_refund_total,
			l_grand_reconsilation_total,
			l_grand_writeoff_total,
			l_grand_outst_total;

int len29,r_ctr29;
int len2,r_ctr2;
int len3,r_ctr3;
int len4,r_ctr4;
int len8,r_ctr8;
int len17,r_ctr17;
int len18,r_ctr18;

int len19,r_ctr19;
int len20,r_ctr20;
int len21,r_ctr21;
int len22,r_ctr22;
int len23,r_ctr23;
int len24,r_ctr24;
int len25,r_ctr25;
int len26,r_ctr26;

int len32,r_ctr32;
int len45,r_ctr45;
int len46,r_ctr46;
int len47,r_ctr47;

int len33,r_ctr33;
int len34,r_ctr34;
int len36,r_ctr36;
int len37,r_ctr37;
int len38,r_ctr38;
int len40,r_ctr40;
int len42,r_ctr42;
int len43,r_ctr43;
int len44,r_ctr44;

char		filename[200];

char		string_var[200];

char		loc_legend[100][201],		
		
		loc_legend2_1[201],
		loc_legend2_2[201],
		
		loc_legend3_1[201],
		loc_legend3_2[201],
		
		loc_legend4_1[201],
		loc_legend4_2[201],
		
		loc_legend8_1[201],
		loc_legend8_2[201],
		
		loc_legend17_1[201],
		loc_legend17_2[201],
		
		loc_legend18_1[201],
		loc_legend18_2[201],

		loc_legend19_1[201],
		loc_legend19_2[201],

		loc_legend20_1[201],
		loc_legend20_2[201],

		loc_legend21_1[201],
		loc_legend21_2[201],

		loc_legend22_1[201],
		loc_legend22_2[201],

		loc_legend23_1[201],
		loc_legend23_2[201],

		loc_legend24_1[201],
		loc_legend24_2[201],

		loc_legend25_1[201],
		loc_legend25_2[201],

		loc_legend26_1[201],
		loc_legend26_2[201],

		loc_legend29_1[201],
		loc_legend29_2[201],
         
        loc_legend32_1[201],
		loc_legend32_2[201],
		loc_legend45_1[201],
		loc_legend46_1[201],
		loc_legend47_1[201],
        loc_legend45_2[201],
		loc_legend46_2[201],
		loc_legend47_2[201], 

		loc_legend33_1[201],
		loc_legend33_2[201],
		loc_legend34_1[201],
		loc_legend34_2[201],
		loc_legend36_1[201],
		loc_legend36_2[201],
		loc_legend37_1[201],
		loc_legend37_2[201],
		loc_legend38_1[201],
		loc_legend38_2[201],
		loc_legend40_1[201],
		loc_legend40_2[201],
		loc_legend42_1[201],
		loc_legend42_2[201],
		loc_legend43_1[201],
		loc_legend43_2[201],
		loc_legend44_1[201],
		loc_legend44_2[201],
         
		l_mesg[100],
		l_mesg1[100];

//char		loc_legend17_1[100],loc_legend17_2[100];

int			l_line_no =0;
int			l_page_no =0;
int			i;
int			d_srlno = 1;
int			first;

/* VARCHAR 	bill_num				[100],
			bill_date				[20],
			dep_receipt				[100],
			dep_receipt_date		[20],
			receipt_no				[100],
			receipt_date			[20]; */ 
struct { unsigned short len; unsigned char arr[100]; } bill_num;

struct { unsigned short len; unsigned char arr[20]; } bill_date;

struct { unsigned short len; unsigned char arr[100]; } dep_receipt;

struct { unsigned short len; unsigned char arr[20]; } dep_receipt_date;

struct { unsigned short len; unsigned char arr[100]; } receipt_no;

struct { unsigned short len; unsigned char arr[20]; } receipt_date;


int no_more_bills, no_more_receipts, no_more_deposits;


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

int    lctr = 0,pctr = 0;

FILE *fp;

void proc_main(argc,argv)
char *argv[];
int argc;
{
    if (argc < 4)
    {
       int i = 0;
       disp_message(ERR_MESG,"Not enough Parameters for running this program");
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

	if(sql_connect() == -1)
	{
		disp_message(ERR_MESG,"Error in connecting to Oracle\n");
		if (uid_pwd.len == 0)
			disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
		proc_exit();
	}

    set_meduser_role();
	strcpy(p_language_id.arr,l_language_id.arr);
	p_language_id.len = l_language_id.len; 
	p_language_id.arr[p_language_id.len]='\0';

    fetch_prog_param();  

    fetch_hosp_name();
    
	declare_cursors();
   
	open_file();

	first = 0;

	fetch_legend_value();

	split_legend();

    print_report();

    end_of_rep();

	/* EXEC SQL DELETE SY_PROG_PARAM
            WHERE PGM_ID   = 'BLR00061'
            AND SESSION_ID = :nd_session_id
            AND PGM_DATE   = :nd_pgm_date; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 2;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='BLR00061' and SE\
SSION_ID=:b0) and PGM_DATE=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
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
 sqlstm.sqhstl[1] = (unsigned int  )37;
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
         err_mesg("DELETE failed on table SY_PROG_PARAM",0,"");

    
    /* EXEC SQL COMMIT WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 2;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )28;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if (OERROR)
         err_mesg("COMMIT WORK RELEASE failed",0,"");

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
  sqlstm.offset = (unsigned int  )43;
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

declare_cursors()
{


/* EXEC SQL DECLARE IP_LIST CURSOR FOR 
select 		nvl(d.blng_grp_catg,'**'),
		a.BLNG_GRP_ID,
		a.PATIENT_ID,
		a.EPISODE_TYPE,
		a.EPISODE_ID,
		nvl(a.VISIT_ID,0), 
		b.short_name,  
		a.ward_code,
		nvl(a.BED_CLASS_CODE,c.CUR_BED_CLASS_CODE),
       	to_char(a.ADMISSION_DATE,'dd/mm/yyyy'), 
		to_char(c.discharge_date_time,'dd/mm/yyyy'),
		sum(nvl(a.PREPAY_ADJ_AMT,0)+nvl(a.DEPOSIT_ADJ_AMT,0)),        
		sum(nvl(a.BILL_AMT,0)),
		sum(nvl(a.MAN_DISC_AMT,0))+sum(nvl(a.OVERALL_DISC_AMT,0)) disc_amt,
		sum(nvl(a.BILL_TOT_ADJUST_AMT,0)),
		sum(nvl(a.BILL_TOT_EXEMPT_AMT,0)),
		sum(nvl(a.BILL_PAID_AMT,0))  tot_paid_amt,
		sum(nvl(a.TOT_REFUND_AMT,0)) tot_efund_amt,
		sum(nvl(a.BILL_TOT_WRITE_OFF_AMT,0)),
		sum(nvl(a.BILL_TOT_OUTST_AMT,0)) 
		
from 		bl_bill_dcp_dtl_vw a, 
		mp_patient_mast b,   
		bl_encounter_for_qry_vw c, 
		bl_blng_grp_by_catg d
where 	a.operating_facility_id = :nd_facility_id
and 	a.admission_date between to_date(nvl(:nd_fr_date,'01/01/1900')||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
		and 	to_date(nvl(:nd_to_date,'31/12/2300')||' 23:59:59','dd/mm/yyyy hh24:mi:ss')
and	a.patient_id		= b.patient_id
and 	a.episode_type		= c.episode_type
and 	a.episode_id		= c.episode_id
and 	a.blng_grp_id		= d.blng_grp_id(+)
and	nvl(a.bill_status,'X') != 'C'
and nvl(a.BED_CLASS_CODE,c.CUR_BED_CLASS_CODE) 
                between nvl(:nd_fr_bed_class,'!!') and nvl(:nd_to_bed_class,'~~')
and nvl(d.blng_grp_catg,'!!!!') between nvl(:nd_blng_grp_fr_catg,'!!!!') and nvl(:nd_blng_grp_to_catg,'~~~~')
and nvl(a.ward_code,'!!!!') between nvl(:nd_fr_nur_unit,'!!!!') and nvl(:nd_to_nur_unit,'~~~~')
and a.episode_type = :nd_episode_type
and c.language_id=:p_language_id
group by	d.blng_grp_catg,
		a.BLNG_GRP_ID,
		a.PATIENT_ID,
		a.EPISODE_TYPE, 
		a.EPISODE_ID,
		nvl(a.VISIT_ID,0), 
		b.short_name,
		a.ward_code,
		nvl(a.BED_CLASS_CODE,c.CUR_BED_CLASS_CODE),
		to_char(a.ADMISSION_DATE,'dd/mm/yyyy'), 
		to_char(c.discharge_date_time,'dd/mm/yyyy')

UNION 
select 
       nvl(d.blng_grp_catg,'**'),
       b.BLNG_GRP_ID,
       b.patient_id,
       b.EPISODE_TYPE,
       b.EPISODE_ID,
       0,
       null,
	   c.cur_ward_code,
       b.BED_BILL_BED_CLASS_CODE,
	   null,
       null,
	   SUM(DOC_AMT),
       0,
	   0,
	   0,
	   0,
	   0,
	   0,
	   0,
	   0
	   
from   
bl_receipt_refund_hdr a,
bl_episode_fin_dtls b,
ip_episode c,
bl_blng_grp_by_catg d
where 	b.operating_facility_id = :nd_facility_id
and 	b.ADMISSION_DATE_TIME between to_date(nvl(:nd_fr_date,'01/01/1900')||' 00:00:00','dd/mm/yyyy hh24:mi:ss') 
and 	to_date(nvl(:nd_to_date,'31/12/2300')||' 23:59:59','dd/mm/yyyy hh24:mi:ss')
and a.recpt_nature_code in ('AD','PR')
and		a.episode_type in ('I','D')
and nvl(b.bed_bill_bed_class_code,'!!')
                between nvl(:nd_fr_bed_class,'!!') and nvl(:nd_to_bed_class,'~~') 
and d.blng_grp_catg between nvl(:nd_blng_grp_fr_catg,'!!!!') and nvl(:nd_blng_grp_to_catg,'~~~~') 
and nvl(c.cur_ward_code,'!!!!') between nvl(:nd_fr_nur_unit,'!!!!') and nvl(:nd_to_nur_unit,'~~~~')
and   a.patient_id   = b.patient_id
and   a.episode_id   = b.episode_id
and   a.episode_type   = b.episode_type
and   a.patient_id   = c.patient_id
and   a.episode_id   = c.episode_id
and   a.episode_type   = c.episode_type
and 	b.blng_grp_id		= d.blng_grp_id(+)
and   nvl(a.cancelled_ind,'N') <> 'Y'
and   a.recpt_refund_ind='R'
and NOT EXISTS (SELECT 1 FROM bl_bill_dcp_dtl_vw x WHERE x.PATIENT_ID=b.PATIENT_ID 
			   	and 	b.episode_type		= x.episode_type
				and 	b.episode_id		= x.episode_id
				and	nvl(x.bill_status,'X') != 'C')
group by	d.blng_grp_catg,
		b.BLNG_GRP_ID,
		b.PATIENT_ID,
		b.EPISODE_TYPE, 
		b.EPISODE_ID,
		c.cur_ward_code,
    b.BED_BILL_BED_CLASS_CODE,
	to_char(B.ADMISSION_DATE_TIME,'dd/mm/yyyy')
		order by 1,3, 9; */ 

		
/* EXEC SQL OPEN IP_LIST; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 20;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlbuft((void **)0, 
  "select nvl(d.blng_grp_catg,'**') ,a.BLNG_GRP_ID ,a.PATIENT_ID ,a.EPISODE_\
TYPE ,a.EPISODE_ID ,nvl(a.VISIT_ID,0) ,b.short_name ,a.ward_code ,nvl(a.BED_\
CLASS_CODE,c.CUR_BED_CLASS_CODE) ,to_char(a.ADMISSION_DATE,'dd/mm/yyyy') ,to\
_char(c.discharge_date_time,'dd/mm/yyyy') ,sum((nvl(a.PREPAY_ADJ_AMT,0)+nvl(\
a.DEPOSIT_ADJ_AMT,0))) ,sum(nvl(a.BILL_AMT,0)) ,(sum(nvl(a.MAN_DISC_AMT,0))+\
sum(nvl(a.OVERALL_DISC_AMT,0))) disc_amt ,sum(nvl(a.BILL_TOT_ADJUST_AMT,0)) \
,sum(nvl(a.BILL_TOT_EXEMPT_AMT,0)) ,sum(nvl(a.BILL_PAID_AMT,0)) tot_paid_amt\
 ,sum(nvl(a.TOT_REFUND_AMT,0)) tot_efund_amt ,sum(nvl(a.BILL_TOT_WRITE_OFF_A\
MT,0)) ,sum(nvl(a.BILL_TOT_OUTST_AMT,0))  from bl_bill_dcp_dtl_vw a ,mp_pati\
ent_mast b ,bl_encounter_for_qry_vw c ,bl_blng_grp_by_catg d where (((((((((\
((a.operating_facility_id=:b0 and a.admission_date between to_date((nvl(:b1,\
'01/01/1900')||' 00:00:00'),'dd/mm/yyyy hh24:mi:ss') and to_date((nvl(:b2,'3\
1/12/2300')||' 23:59:59'),'dd/mm/yyyy hh24:mi:ss')) and a.patient_id=b.patie\
nt_id) and a.episode_type=c.episode_typ");
sqlbuft((void **)0, 
  "e) and a.episode_id=c.episode_id) and a.blng_grp_id=d.blng_grp_id(+)) and\
 nvl(a.bill_status,'X')<>'C') and nvl(a.BED_CLASS_CODE,c.CUR_BED_CLASS_CODE)\
 between nvl(:b3,'!!') and nvl(:b4,'~~')) and nvl(d.blng_grp_catg,'!!!!') be\
tween nvl(:b5,'!!!!') and nvl(:b6,'~~~~')) and nvl(a.ward_code,'!!!!') betwe\
en nvl(:b7,'!!!!') and nvl(:b8,'~~~~')) and a.episode_type=:b9) and c.langua\
ge_id=:b10) group by d.blng_grp_catg,a.BLNG_GRP_ID,a.PATIENT_ID,a.EPISODE_TY\
PE,a.EPISODE_ID,nvl(a.VISIT_ID,0),b.short_name,a.ward_code,nvl(a.BED_CLASS_C\
ODE,c.CUR_BED_CLASS_CODE),to_char(a.ADMISSION_DATE,'dd/mm/yyyy'),to_char(c.d\
ischarge_date_time,'dd/mm/yyyy') union select nvl(d.blng_grp_catg,'**') ,b.B\
LNG_GRP_ID ,b.patient_id ,b.EPISODE_TYPE ,b.EPISODE_ID ,0 ,null  ,c.cur_ward\
_code ,b.BED_BILL_BED_CLASS_CODE ,null  ,null  ,sum(DOC_AMT) ,0 ,0 ,0 ,0 ,0 \
,0 ,0 ,0  from bl_receipt_refund_hdr a ,bl_episode_fin_dtls b ,ip_episode c \
,bl_blng_grp_by_catg d where ((((((((((((((((b.operating_facility_id=:b0 and\
 b.ADMISSION_DATE_TIME between to_date(");
sqlbuft((void **)0, 
  "(nvl(:b1,'01/01/1900')||' 00:00:00'),'dd/mm/yyyy hh24:mi:ss') and to_date\
((nvl(:b2,'31/12/2300')||' 23:59:59'),'dd/mm/yyyy hh24:mi:ss')) and a.recpt_\
nature_code in ('AD','PR')) and a.episode_type in ('I','D')) and nvl(b.bed_b\
ill_bed_class_code,'!!') between nvl(:b3,'!!') and nvl(:b4,'~~')) and d.blng\
_grp_catg between nvl(:b5,'!!!!') and nvl(:b6,'~~~~')) and nvl(c.cur_ward_co\
de,'!!!!') between nvl(:b7,'!!!!') and nvl(:b8,'~~~~')) and a.patient_id=b.p\
atient_id) and a.episode_id=b.episode_id) and a.episode_type=b.episode_type)\
 and a.patient_id=c.patient_id) and a.episode_id=c.episode_id) and a.episode\
_type=c.episode_type) and b.blng_grp_id=d.blng_grp_id(+)) and nvl(a.cancelle\
d_ind,'N')<>'Y') and a.recpt_refund_ind='R') and  not exists (select 1  from\
 bl_bill_dcp_dtl_vw x where (((x.PATIENT_ID=b.PATIENT_ID and b.episode_type=\
x.episode_type) and b.episode_id=x.episode_id) and nvl(x.bill_status,'X')<>'\
C'))) group by d.blng_grp_catg,b.BLNG_GRP_ID,b.PATIENT_ID,b.EPISODE_TYPE,b.E\
PISODE_ID,c.cur_ward_code,b.BED_BILL_BE");
sqlstm.stmt = sq0004;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )74;
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
sqlstm.sqhstv[1] = (         void  *)&nd_fr_date;
sqlstm.sqhstl[1] = (unsigned int  )22;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_to_date;
sqlstm.sqhstl[2] = (unsigned int  )22;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&nd_fr_bed_class;
sqlstm.sqhstl[3] = (unsigned int  )5;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&nd_to_bed_class;
sqlstm.sqhstl[4] = (unsigned int  )5;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&nd_blng_grp_fr_catg;
sqlstm.sqhstl[5] = (unsigned int  )7;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&nd_blng_grp_to_catg;
sqlstm.sqhstl[6] = (unsigned int  )7;
sqlstm.sqhsts[6] = (         int  )0;
sqlstm.sqindv[6] = (         void  *)0;
sqlstm.sqinds[6] = (         int  )0;
sqlstm.sqharm[6] = (unsigned int  )0;
sqlstm.sqadto[6] = (unsigned short )0;
sqlstm.sqtdso[6] = (unsigned short )0;
sqlstm.sqhstv[7] = (         void  *)&nd_fr_nur_unit;
sqlstm.sqhstl[7] = (unsigned int  )7;
sqlstm.sqhsts[7] = (         int  )0;
sqlstm.sqindv[7] = (         void  *)0;
sqlstm.sqinds[7] = (         int  )0;
sqlstm.sqharm[7] = (unsigned int  )0;
sqlstm.sqadto[7] = (unsigned short )0;
sqlstm.sqtdso[7] = (unsigned short )0;
sqlstm.sqhstv[8] = (         void  *)&nd_to_nur_unit;
sqlstm.sqhstl[8] = (unsigned int  )7;
sqlstm.sqhsts[8] = (         int  )0;
sqlstm.sqindv[8] = (         void  *)0;
sqlstm.sqinds[8] = (         int  )0;
sqlstm.sqharm[8] = (unsigned int  )0;
sqlstm.sqadto[8] = (unsigned short )0;
sqlstm.sqtdso[8] = (unsigned short )0;
sqlstm.sqhstv[9] = (         void  *)&nd_episode_type;
sqlstm.sqhstl[9] = (unsigned int  )5;
sqlstm.sqhsts[9] = (         int  )0;
sqlstm.sqindv[9] = (         void  *)0;
sqlstm.sqinds[9] = (         int  )0;
sqlstm.sqharm[9] = (unsigned int  )0;
sqlstm.sqadto[9] = (unsigned short )0;
sqlstm.sqtdso[9] = (unsigned short )0;
sqlstm.sqhstv[10] = (         void  *)&p_language_id;
sqlstm.sqhstl[10] = (unsigned int  )5;
sqlstm.sqhsts[10] = (         int  )0;
sqlstm.sqindv[10] = (         void  *)0;
sqlstm.sqinds[10] = (         int  )0;
sqlstm.sqharm[10] = (unsigned int  )0;
sqlstm.sqadto[10] = (unsigned short )0;
sqlstm.sqtdso[10] = (unsigned short )0;
sqlstm.sqhstv[11] = (         void  *)&nd_facility_id;
sqlstm.sqhstl[11] = (unsigned int  )5;
sqlstm.sqhsts[11] = (         int  )0;
sqlstm.sqindv[11] = (         void  *)0;
sqlstm.sqinds[11] = (         int  )0;
sqlstm.sqharm[11] = (unsigned int  )0;
sqlstm.sqadto[11] = (unsigned short )0;
sqlstm.sqtdso[11] = (unsigned short )0;
sqlstm.sqhstv[12] = (         void  *)&nd_fr_date;
sqlstm.sqhstl[12] = (unsigned int  )22;
sqlstm.sqhsts[12] = (         int  )0;
sqlstm.sqindv[12] = (         void  *)0;
sqlstm.sqinds[12] = (         int  )0;
sqlstm.sqharm[12] = (unsigned int  )0;
sqlstm.sqadto[12] = (unsigned short )0;
sqlstm.sqtdso[12] = (unsigned short )0;
sqlstm.sqhstv[13] = (         void  *)&nd_to_date;
sqlstm.sqhstl[13] = (unsigned int  )22;
sqlstm.sqhsts[13] = (         int  )0;
sqlstm.sqindv[13] = (         void  *)0;
sqlstm.sqinds[13] = (         int  )0;
sqlstm.sqharm[13] = (unsigned int  )0;
sqlstm.sqadto[13] = (unsigned short )0;
sqlstm.sqtdso[13] = (unsigned short )0;
sqlstm.sqhstv[14] = (         void  *)&nd_fr_bed_class;
sqlstm.sqhstl[14] = (unsigned int  )5;
sqlstm.sqhsts[14] = (         int  )0;
sqlstm.sqindv[14] = (         void  *)0;
sqlstm.sqinds[14] = (         int  )0;
sqlstm.sqharm[14] = (unsigned int  )0;
sqlstm.sqadto[14] = (unsigned short )0;
sqlstm.sqtdso[14] = (unsigned short )0;
sqlstm.sqhstv[15] = (         void  *)&nd_to_bed_class;
sqlstm.sqhstl[15] = (unsigned int  )5;
sqlstm.sqhsts[15] = (         int  )0;
sqlstm.sqindv[15] = (         void  *)0;
sqlstm.sqinds[15] = (         int  )0;
sqlstm.sqharm[15] = (unsigned int  )0;
sqlstm.sqadto[15] = (unsigned short )0;
sqlstm.sqtdso[15] = (unsigned short )0;
sqlstm.sqhstv[16] = (         void  *)&nd_blng_grp_fr_catg;
sqlstm.sqhstl[16] = (unsigned int  )7;
sqlstm.sqhsts[16] = (         int  )0;
sqlstm.sqindv[16] = (         void  *)0;
sqlstm.sqinds[16] = (         int  )0;
sqlstm.sqharm[16] = (unsigned int  )0;
sqlstm.sqadto[16] = (unsigned short )0;
sqlstm.sqtdso[16] = (unsigned short )0;
sqlstm.sqhstv[17] = (         void  *)&nd_blng_grp_to_catg;
sqlstm.sqhstl[17] = (unsigned int  )7;
sqlstm.sqhsts[17] = (         int  )0;
sqlstm.sqindv[17] = (         void  *)0;
sqlstm.sqinds[17] = (         int  )0;
sqlstm.sqharm[17] = (unsigned int  )0;
sqlstm.sqadto[17] = (unsigned short )0;
sqlstm.sqtdso[17] = (unsigned short )0;
sqlstm.sqhstv[18] = (         void  *)&nd_fr_nur_unit;
sqlstm.sqhstl[18] = (unsigned int  )7;
sqlstm.sqhsts[18] = (         int  )0;
sqlstm.sqindv[18] = (         void  *)0;
sqlstm.sqinds[18] = (         int  )0;
sqlstm.sqharm[18] = (unsigned int  )0;
sqlstm.sqadto[18] = (unsigned short )0;
sqlstm.sqtdso[18] = (unsigned short )0;
sqlstm.sqhstv[19] = (         void  *)&nd_to_nur_unit;
sqlstm.sqhstl[19] = (unsigned int  )7;
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
	  err_mesg("OPEN failed on cursor IP_LIST",0,"");

/* EXEC SQL DECLARE IP_BILLS CURSOR FOR 
select a.doc_type_code||'/'||a.doc_num bill_num, TO_CHAR(a.doc_date,'DD/MM/YYYY') bill_date
from 	bl_bill_dcp_dtl_vw a,bl_blng_grp_by_catg d
where 	a.operating_facility_id = :nd_facility_id
and     a.episode_type = :d_episode_type
and     a.episode_id   = :d_episode_id
and     a.patient_id   = :d_patient_id
and 	a.blng_grp_id		= d.blng_grp_id(+)
and	nvl(a.bill_status,'X') != 'C'
and  a.bed_class_code=:d_bed_class_code
and  nvl(d.blng_grp_catg,'**')=:d_blng_grp_catg
and  a.ward_code=:d_nur_unit
order by a.doc_date; */ 



/* EXEC SQL DECLARE IP_DEPOSITS CURSOR FOR 
select a.doc_type_code||'/'||a.doc_number dep_receipt, TO_CHAR(a.doc_Date,'DD/MM/YYYY') dep_receipt_date
from   bl_receipt_refund_hdr a
where a.operating_facility_id = :nd_facility_id
and a.recpt_nature_code in ('AD','PR')
and   a.patient_id   = :d_patient_id
and   a.episode_id   = :d_episode_id
and   a.episode_type = :d_episode_type
and   nvl(a.cancelled_ind,'N') <> 'Y'
and   a.recpt_refund_ind='R'
order by a.doc_date; */ 


/* EXEC SQL DECLARE IP_RECEIPTS CURSOR FOR 
select a.doc_type_code||'/'||a.doc_number receipt_no, TO_CHAR(a.doc_Date,'DD/MM/YYYY') receipt_date
from   bl_receipt_refund_hdr a, bl_bill_hdr b,bl_blng_grp_by_catg c 
where a.recpt_nature_code in ('BI')
and   a.patient_id   = :d_patient_id
and   a.episode_id   = :d_episode_id
and   a.episode_type = :d_episode_type
and   nvl(a.cancelled_ind,'N') <> 'Y'
and   a.recpt_refund_ind='R'
and   a.bill_doc_type_code=b.doc_type_code
and   a.bill_doc_number=b.doc_num
and 	b.blng_grp_id		= c.blng_grp_id(+)
and  b.bed_class_code=:d_bed_class_code 
and  b.ward_code=:d_nur_unit
and  nvl(c.blng_grp_catg,'**')=:d_blng_grp_catg
order by 2; */ 


}

open_detail_cursors()
{
/* EXEC SQL OPEN IP_BILLS; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 20;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = sq0005;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )169;
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
sqlstm.sqhstv[1] = (         void  *)&d_episode_type;
sqlstm.sqhstl[1] = (unsigned int  )5;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
sqlstm.sqhstl[2] = (unsigned int  )11;
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
sqlstm.sqhstv[4] = (         void  *)&d_bed_class_code;
sqlstm.sqhstl[4] = (unsigned int  )5;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&d_blng_grp_catg;
sqlstm.sqhstl[5] = (unsigned int  )7;
sqlstm.sqhsts[5] = (         int  )0;
sqlstm.sqindv[5] = (         void  *)0;
sqlstm.sqinds[5] = (         int  )0;
sqlstm.sqharm[5] = (unsigned int  )0;
sqlstm.sqadto[5] = (unsigned short )0;
sqlstm.sqtdso[5] = (unsigned short )0;
sqlstm.sqhstv[6] = (         void  *)&d_nur_unit;
sqlstm.sqhstl[6] = (unsigned int  )7;
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


/* EXEC SQL OPEN IP_DEPOSITS; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 20;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = sq0006;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )212;
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
sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
sqlstm.sqhstl[1] = (unsigned int  )23;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
sqlstm.sqhstl[2] = (unsigned int  )11;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&d_episode_type;
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


/* EXEC SQL OPEN IP_RECEIPTS; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 20;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = sq0007;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )243;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqcmod = (unsigned int )0;
sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
sqlstm.sqhstl[0] = (unsigned int  )23;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&d_episode_id;
sqlstm.sqhstl[1] = (unsigned int  )11;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&d_episode_type;
sqlstm.sqhstl[2] = (unsigned int  )5;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqhstv[3] = (         void  *)&d_bed_class_code;
sqlstm.sqhstl[3] = (unsigned int  )5;
sqlstm.sqhsts[3] = (         int  )0;
sqlstm.sqindv[3] = (         void  *)0;
sqlstm.sqinds[3] = (         int  )0;
sqlstm.sqharm[3] = (unsigned int  )0;
sqlstm.sqadto[3] = (unsigned short )0;
sqlstm.sqtdso[3] = (unsigned short )0;
sqlstm.sqhstv[4] = (         void  *)&d_nur_unit;
sqlstm.sqhstl[4] = (unsigned int  )7;
sqlstm.sqhsts[4] = (         int  )0;
sqlstm.sqindv[4] = (         void  *)0;
sqlstm.sqinds[4] = (         int  )0;
sqlstm.sqharm[4] = (unsigned int  )0;
sqlstm.sqadto[4] = (unsigned short )0;
sqlstm.sqtdso[4] = (unsigned short )0;
sqlstm.sqhstv[5] = (         void  *)&d_blng_grp_catg;
sqlstm.sqhstl[5] = (unsigned int  )7;
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



no_more_bills    = 0;
no_more_receipts = 0;
no_more_deposits = 0;

}

fetch_detail_cursors()
{

    bill_num.arr[0]			= '\0';    
    bill_date.arr[0]		= '\0';
    bill_num.len  = 0;
	bill_date.len = 0;

	if (no_more_bills==0)
	{
		/* EXEC SQL FETCH IP_BILLS INTO  :bill_num,:bill_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )282;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&bill_num;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&bill_date;
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


		bill_num.arr[bill_num.len]   = '\0';
		bill_date.arr[bill_date.len] = '\0';

		if(OERROR)
		  err_mesg("FETCH failed on cursor IP_BILLS",0,"");

		if(NO_DATA_FOUND)
		  no_more_bills =1;
	 }

    dep_receipt.arr[0]			= '\0';    
    dep_receipt_date.arr[0]		= '\0';
    dep_receipt.len      = 0;
	dep_receipt_date.len = 0;

	if (no_more_deposits==0)
	{
		/* EXEC SQL FETCH IP_DEPOSITS INTO  :dep_receipt,:dep_receipt_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )305;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&dep_receipt;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&dep_receipt_date;
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


		dep_receipt.arr[dep_receipt.len]   = '\0';
		dep_receipt_date.arr[dep_receipt_date.len] = '\0';

		if(OERROR)
		  err_mesg("FETCH failed on cursor IP_DEPOSITS",0,"");

		if(NO_DATA_FOUND)
		  no_more_deposits =1;
	}


    receipt_no.arr[0]		= '\0';    
    receipt_date.arr[0]		= '\0';
    receipt_no.len			= 0;
	receipt_date.len		= 0;

	if (no_more_receipts==0)
	{
		/* EXEC SQL FETCH IP_RECEIPTS INTO  :receipt_no,:receipt_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )328;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&receipt_no;
  sqlstm.sqhstl[0] = (unsigned int  )102;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&receipt_date;
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


		receipt_no.arr[receipt_no.len]   = '\0';
		receipt_date.arr[receipt_date.len] = '\0';

		if(OERROR)
		  err_mesg("FETCH failed on cursor IP_RECEIPTS",0,"");

		if(NO_DATA_FOUND)
		  no_more_receipts =1;
	}

    if (no_more_bills==1 && no_more_deposits==1 && no_more_receipts==1)
      return 0;
	else
	  return 1;
}

close_detail_cursors()
{
/* EXEC SQL CLOSE IP_BILLS; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 20;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )351;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


/* EXEC SQL CLOSE IP_DEPOSITS; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 20;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )366;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


/* EXEC SQL CLOSE IP_RECEIPTS; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 12;
sqlstm.arrsiz = 20;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )381;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)4352;
sqlstm.occurs = (unsigned int  )0;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

fetch_cursors()
{
    d_blng_grp_catg.arr[0]			= '\0'; 
	d_nur_unit.arr[0]               = '\0';    
    d_blng_grp_id.arr[0]			= '\0';
    d_short_name.arr[0]				= '\0';
    d_patient_id.arr[0]				= '\0';
    d_episode_type.arr[0]			= '\0';
    d_episode_id.arr[0]				= '\0';
    d_visit_id.arr[0]				= '\0';
    d_bed_class_code.arr[0]			= '\0';
    d_admission_date.arr[0]			= '\0';
    d_discharge_date_time.arr[0]	= '\0';

    d_blng_grp_catg.len				= 0;  
	d_nur_unit.len                  = 0;
    d_blng_grp_id.len				= 0;
    d_short_name.len				= 0;
    d_patient_id.len				= 0;
    d_episode_type.len				= 0;
    d_episode_id.len				= 0;
    d_visit_id.len					= 0;
    d_bed_class_code.len			= 0;
    d_admission_date.len			= 0;
    d_discharge_date_time.len		= 0;


    d_deposit_adj_amt_pd			=0;
    d_bill_amt						=0;
    d_disc_amt						=0;
    d_tot_adj_amt					=0;
    d_tot_exempt_amt				=0;
    d_tot_paid_amt					=0;
    d_tot_efund_amt					=0;
    d_tot_write_off_amt				=0;
    d_bill_tot_outst_amt			=0;


    /* EXEC SQL FETCH IP_LIST 
	     INTO  
		:d_blng_grp_catg,		
		:d_blng_grp_id,
		:d_patient_id,
		:d_episode_type,
		:d_episode_id ,
		:d_visit_id , 
		:d_short_name,
		:d_nur_unit,
		:d_bed_class_code,
		:d_admission_date, 
		:d_discharge_date_time,
		:d_deposit_adj_amt_pd,
		:d_bill_amt ,
		:d_disc_amt,
		:d_tot_adj_amt,
		:d_tot_exempt_amt,
		:d_tot_paid_amt,
		:d_tot_efund_amt,
		:d_tot_write_off_amt,
		:d_bill_tot_outst_amt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )396;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_catg;
    sqlstm.sqhstl[0] = (unsigned int  )7;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_id;
    sqlstm.sqhstl[1] = (unsigned int  )7;
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
    sqlstm.sqhstv[3] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[4] = (unsigned int  )11;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_visit_id;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_short_name;
    sqlstm.sqhstl[6] = (unsigned int  )63;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_nur_unit;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_bed_class_code;
    sqlstm.sqhstl[8] = (unsigned int  )5;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_admission_date;
    sqlstm.sqhstl[9] = (unsigned int  )22;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_discharge_date_time;
    sqlstm.sqhstl[10] = (unsigned int  )22;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_deposit_adj_amt_pd;
    sqlstm.sqhstl[11] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_bill_amt;
    sqlstm.sqhstl[12] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_disc_amt;
    sqlstm.sqhstl[13] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_tot_adj_amt;
    sqlstm.sqhstl[14] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_tot_exempt_amt;
    sqlstm.sqhstl[15] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_tot_paid_amt;
    sqlstm.sqhstl[16] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&d_tot_efund_amt;
    sqlstm.sqhstl[17] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_tot_write_off_amt;
    sqlstm.sqhstl[18] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&d_bill_tot_outst_amt;
    sqlstm.sqhstl[19] = (unsigned int  )sizeof(double);
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
	err_mesg("FETCH failed on cursor IP_LIST",0,"");

    if(NO_DATA_FOUND)
	return 0;

    d_blng_grp_catg.arr[d_blng_grp_catg.len]            = '\0';
	d_nur_unit.arr[d_nur_unit.len]                      = '\0';
    
    d_blng_grp_id.arr[d_blng_grp_id.len]				= '\0';
    d_short_name.arr[d_short_name.len]					= '\0';
    d_patient_id.arr[d_patient_id.len]    				= '\0';
    d_episode_type.arr[d_episode_type.len]				= '\0';
    d_episode_id.arr[d_episode_id.len]                  = '\0';
    d_visit_id.arr[d_visit_id.len]						= '\0';
    d_bed_class_code.arr[d_bed_class_code.len]			= '\0';
    d_admission_date.arr[d_admission_date.len]			= '\0';
    d_discharge_date_time.arr[d_discharge_date_time.len]= '\0';


    d_blng_grp_catg_desc.arr[0]			= '\0';
    d_blng_grp_catg_desc.len			= 0;
	
    /* EXEC SQL SELECT short_desc into :d_blng_grp_catg_desc
    FROM BL_BLNG_GRP_CATG
    WHERE BLNG_GRP_CATG = :d_blng_grp_catg; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select short_desc into :b0  from BL_BLNG_GRP_CATG where B\
LNG_GRP_CATG=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )491;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_blng_grp_catg_desc;
    sqlstm.sqhstl[0] = (unsigned int  )42;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_blng_grp_catg;
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
}



    if(NO_DATA_FOUND)
    {
	strcpy(d_blng_grp_catg_desc.arr,"NOT SPECIFIED");	
	d_blng_grp_catg_desc.len = strlen(d_blng_grp_catg_desc.arr);
	
    }


    d_blng_grp_catg_desc.arr[d_blng_grp_catg_desc.len]  = '\0';

    return 1;
}

fetch_prog_param()
{
    nd_fr_date.arr[0]     ='\0'; 
    nd_to_date.arr[0]     ='\0';
		nd_episode_type.arr[0]='\0';
	nd_blng_grp_fr_catg.arr[0]='\0';
	nd_blng_grp_to_catg.arr[0]='\0';
		 nd_fr_nur_unit.arr[0]='\0';
		 nd_to_nur_unit.arr[0]='\0';
		nd_fr_bed_class.arr[0]='\0';
		nd_to_bed_class.arr[0]='\0';

    nd_fr_date.len        = 0;
    nd_to_date.len        = 0;
		    nd_episode_type.len = 0;
	nd_blng_grp_fr_catg.len = 0;
	nd_blng_grp_to_catg.len = 0;
		 nd_fr_nur_unit.len = 0;
		 nd_to_nur_unit.len = 0;
		nd_fr_bed_class.len = 0;
		nd_to_bed_class.len = 0;

 
     /* EXEC SQL SELECT  PARAM1,PARAM2,
						PARAM3,
						nvl(PARAM4,'!!!!'),
						nvl(PARAM5,'~~~~'),
						nvl(PARAM6,'!!'),
						nvl(PARAM7,'~~'),
						nvl(PARAM8,'!!!!'),
						nvl(PARAM9,'~~~~')
          
            INTO     :nd_fr_date, :nd_to_date,
			           :nd_episode_type,
					 :nd_blng_grp_fr_catg,
					 :nd_blng_grp_to_catg,
					 :nd_fr_bed_class,
					 :nd_to_bed_class,
					  :nd_fr_nur_unit,
					  :nd_to_nur_unit
            FROM	 SY_PROG_PARAM
            WHERE	 PGM_ID   = 'BLR00061'
            AND		 SESSION_ID = :nd_session_id
            AND		 PGM_DATE   = :nd_pgm_date; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 20;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select PARAM1 ,PARAM2 ,PARAM3 ,nvl(PARAM4,'!!!!') ,nvl(P\
ARAM5,'~~~~') ,nvl(PARAM6,'!!') ,nvl(PARAM7,'~~') ,nvl(PARAM8,'!!!!') ,nvl(PAR\
AM9,'~~~~') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8  from SY_PROG_PARAM where\
 ((PGM_ID='BLR00061' and SESSION_ID=:b9) and PGM_DATE=:b10)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )514;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&nd_fr_date;
     sqlstm.sqhstl[0] = (unsigned int  )22;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&nd_to_date;
     sqlstm.sqhstl[1] = (unsigned int  )22;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_episode_type;
     sqlstm.sqhstl[2] = (unsigned int  )5;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_blng_grp_fr_catg;
     sqlstm.sqhstl[3] = (unsigned int  )7;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_blng_grp_to_catg;
     sqlstm.sqhstl[4] = (unsigned int  )7;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_fr_bed_class;
     sqlstm.sqhstl[5] = (unsigned int  )5;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_to_bed_class;
     sqlstm.sqhstl[6] = (unsigned int  )5;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_fr_nur_unit;
     sqlstm.sqhstl[7] = (unsigned int  )7;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_to_nur_unit;
     sqlstm.sqhstl[8] = (unsigned int  )7;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_session_id;
     sqlstm.sqhstl[9] = (unsigned int  )18;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&nd_pgm_date;
     sqlstm.sqhstl[10] = (unsigned int  )37;
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
        err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");

   if (NOT_FOUND)
        err_mesg("No Record found in SY_PROG_PARAM",0,"");

	nd_fr_date.arr[nd_fr_date.len]	= '\0';
	nd_to_date.arr[nd_to_date.len]	= '\0';
		nd_episode_type.arr[nd_episode_type.len]		= '\0';
	nd_blng_grp_fr_catg.arr[nd_blng_grp_fr_catg.len]= '\0';
	nd_blng_grp_to_catg.arr[nd_blng_grp_to_catg.len]= '\0';
	nd_fr_nur_unit.arr[nd_fr_nur_unit.len]			= '\0';
	nd_to_nur_unit.arr[nd_to_nur_unit.len]			= '\0';
	nd_fr_bed_class.arr[nd_fr_bed_class.len]		= '\0';
	nd_to_bed_class.arr[nd_to_bed_class.len]		= '\0';


}

end_of_rep()
{   
    fprintf(fp,"\n");
    fprintf(fp,"%105s***  END OF REPORT ***\n\f"," ");

    fprintf(fp,"%c",0x12); /*** Set Dot-matrix Printer to Normal Mode ***/

    
	fflush(fp);
}

open_file()
{
    strcpy(filename,WORKING_DIR);
	strcat(filename,"BLR00061.lis");

    if ((fp = fopen(filename,"w")) == NULL)
    {
       disp_message(ERR_MESG,"Error in opening file BLR00061.lis");
       proc_exit();
    }
}



print_letter_deposit_detail()
{

	   if ((d_prv_blng_grp_catg.arr[0]== '\0') &&  (d_blng_grp_catg.arr[0] != '\0'))
	   {
		   strcpy(d_prv_blng_grp_catg.arr,d_blng_grp_catg.arr);
		   fprintf(fp,"%-3.3s %-30.30s\n\n",d_blng_grp_catg.arr,d_blng_grp_catg_desc.arr);
		   d_srlno = 1;
		   l_line_no++;
		   l_line_no++;

		}

	   else
	   {
   		if ((strcmp(d_prv_blng_grp_catg.arr,d_blng_grp_catg.arr) == 0) && (d_blng_grp_catg.arr[0] != '\0')) 
				{
				 // fprintf(fp,"%-3.3s ","");
				
				 d_srlno++;

				}
				

		else
		{
			
		if ((strcmp(d_prv_blng_grp_catg.arr,d_blng_grp_catg.arr) != 0) && (d_blng_grp_catg.arr[0] != '\0')) 
		{
			if (first != 0)
			{
				get_sub_totals();
			}
			 strcpy(d_prv_blng_grp_catg.arr,d_blng_grp_catg.arr);
			 if (l_line_no == 0)
			 {
				fprintf(fp,"%-3.3s %-30.30s\n\n",d_blng_grp_catg.arr,d_blng_grp_catg_desc.arr);
			 }
			 else
			 {
				fprintf(fp,"\n%-3.3s %-30.30s\n\n",d_blng_grp_catg.arr,d_blng_grp_catg_desc.arr);
				l_line_no++;
				l_line_no++;
			 }
				 d_srlno = 1;			 
				 l_line_no++;
		}
				
	}
	}

	   if((d_blng_grp_catg.arr[0] == '\0') && (d_prv_blng_grp_catg.arr[0] != '\0'))
		  {  
			d_prv_blng_grp_catg.arr[0] = '\0';
			if (l_line_no == 0)
			{
			//	fprintf(fp,"%-3.3s "," ");
					if (first != 0)
					{
						get_sub_totals();
					}
				
			}
			else
			{
				fprintf(fp,"\n");
				l_line_no++;  
			}
     			d_srlno =1;
						
		   }
	   else
	   {
	   if((d_blng_grp_catg.arr[0] == '\0') && (d_prv_blng_grp_catg.arr[0] == '\0'))
		 {
			//fprintf(fp,"%-3.3s "," ");
     			d_srlno++;
		  }
    
    /* EXEC SQL  select sum(doc_amt) into d_deposit_adj_amt_pd
          from   bl_receipt_refund_hdr a
          where a.operating_facility_id = :nd_facility_id
          and a.recpt_nature_code in ('AD','PR')
          and   a.patient_id   = :d_patient_id
          and   a.episode_id   = :d_episode_id
          and   a.episode_type = :d_episode_type
          and   nvl(a.cancelled_ind,'N') <> 'Y'
          and   a.recpt_refund_ind='R'; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select sum(doc_amt) into :b0  from bl_receipt_refund_hdr \
a where ((((((a.operating_facility_id=:b1 and a.recpt_nature_code in ('AD','PR\
')) and a.patient_id=:b2) and a.episode_id=:b3) and a.episode_type=:b4) and nv\
l(a.cancelled_ind,'N')<>'Y') and a.recpt_refund_ind='R')";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )573;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_deposit_adj_amt_pd;
    sqlstm.sqhstl[0] = (unsigned int  )sizeof(double);
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
    sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_episode_id;
    sqlstm.sqhstl[3] = (unsigned int  )11;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_episode_type;
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



		fprintf(fp,"%5d %-20.20s %-10.10s %-40.40s %-5.5s %-12.12s %-13.13s",
		d_srlno, d_patient_id.arr,d_episode_id.arr,d_short_name.arr,d_bed_class_code.arr,
			d_admission_date.arr,d_discharge_date_time.arr);
			print_formated(d_deposit_adj_amt_pd);
			print_formated(d_bill_amt);	
			print_formated(d_tot_exempt_amt);
			print_formated(d_tot_paid_amt);
			print_formated(d_tot_efund_amt);
			print_formated(d_tot_adj_amt);
			print_formated(d_tot_write_off_amt);
			print_formated(d_bill_tot_outst_amt);
		fprintf(fp,"\n");
		l_line_no++;
		first = 1;
		
		
			l_sub_deposit_total += d_deposit_adj_amt_pd;
			l_sub_bill_total += d_bill_amt;
			l_sub_exemption_total += d_tot_exempt_amt;
			l_sub_paid_total += d_tot_paid_amt;
			l_sub_refund_total += d_tot_efund_amt;
			l_sub_reconsilation_total += d_tot_adj_amt;
			l_sub_writeoff_total += d_tot_write_off_amt;
			l_sub_outst_total += d_bill_tot_outst_amt;

			l_grand_deposit_total += l_sub_deposit_total;
			l_grand_bill_total += l_sub_bill_total;
			l_grand_exemption_total += l_sub_exemption_total;
			l_grand_paid_total += l_sub_paid_total;
			l_grand_refund_total += l_sub_refund_total;
			l_grand_reconsilation_total += l_sub_reconsilation_total;
			l_grand_writeoff_total += l_sub_writeoff_total;
			l_grand_outst_total += l_sub_outst_total;
		
		check_page_break();
        
		open_detail_cursors();
		while (fetch_detail_cursors())
		{


		fprintf(fp,"%5s %-20.20s %-10.10s %-40.40s %-5.5s %-12.12s %-13.13s %-15.15s %-15.15s %-14.14s %-15.15s",
		"", "","","","","","",dep_receipt.arr,bill_num.arr,"",receipt_no.arr);
		fprintf(fp,"\n");
		l_line_no++;

		check_page_break();

		fprintf(fp,"%5s %-20.20s %-10.10s %-40.40s %-5.5s %-12.12s %-13.13s %-15.15s %-15.15s %-14.14s %-15.15s",
		"", "","","","","","",dep_receipt_date.arr,bill_date.arr,"",receipt_date.arr);
		fprintf(fp,"\n");
		l_line_no++;

		check_page_break();
			
		}
		close_detail_cursors();
		

		}
   	}



split_legend()
{
		len29 = strlen(loc_legend[29]);
		split_text(loc_legend[29],5,loc_legend29_1,&r_ctr29);
		if (len29 >= 5)
		split_text(loc_legend[29],5,loc_legend29_2,&r_ctr29);

		len2 = strlen(loc_legend[2]);
		split_text(loc_legend[2],20,loc_legend2_1,&r_ctr2);
		if (len2 >= 20)
		split_text(loc_legend[2],20,loc_legend2_2,&r_ctr2);

		len3 = strlen(loc_legend[3]);
		split_text(loc_legend[3],10,loc_legend3_1,&r_ctr3);
		if (len3 >= 10)
		split_text(loc_legend[3],10,loc_legend3_2,&r_ctr3);

		len4 = strlen(loc_legend[4]);
		split_text(loc_legend[4],40,loc_legend4_1,&r_ctr4);
		if (len4 >= 40)
		split_text(loc_legend[4],40,loc_legend4_2,&r_ctr4);

		len8 = strlen(loc_legend[8]);
		split_text(loc_legend[8],5,loc_legend8_1,&r_ctr8);
		if (len8 >= 5)
		split_text(loc_legend[8],5,loc_legend8_2,&r_ctr8);

		len17 = strlen(loc_legend[17]);
		split_text(loc_legend[17],12,loc_legend17_1,&r_ctr17);
		if (len17 >= 12)
		split_text(loc_legend[17],12,loc_legend17_2,&r_ctr17);

		len18 = strlen(loc_legend[18]);
		split_text(loc_legend[18],13,loc_legend18_1,&r_ctr18);
		if (len18 >= 13)
		split_text(loc_legend[18],13,loc_legend18_2,&r_ctr18);				

		len19 = strlen(loc_legend[19]);
		split_text(loc_legend[19],10,loc_legend19_1,&r_ctr19);
		if (len19 >= 10)
		split_text(loc_legend[19],14,loc_legend19_2,&r_ctr19);


        
		len32 = strlen(loc_legend[32]);
		split_text(loc_legend[32],20,loc_legend32_1,&r_ctr32);
		if (len32 >= 20)
		split_text(loc_legend[32],14,loc_legend32_2,&r_ctr32);

		len46 = strlen(loc_legend[46]);
		split_text(loc_legend[46],20,loc_legend46_1,&r_ctr46);
		if (len46 >= 20)
		split_text(loc_legend[46],14,loc_legend46_2,&r_ctr46);

		len45 = strlen(loc_legend[45]);
		split_text(loc_legend[45],20,loc_legend45_1,&r_ctr45);
		if (len45 >= 20)
		split_text(loc_legend[45],14,loc_legend45_2,&r_ctr45);
		
		len47 = strlen(loc_legend[47]);
		split_text(loc_legend[47],10,loc_legend47_1,&r_ctr47);
		//if (len47 >= 20)
		//split_text(loc_legend[47],40,loc_legend47_2,&r_ctr47);

		len20 = strlen(loc_legend[20]);
		split_text(loc_legend[20],10,loc_legend20_1,&r_ctr20);
		if (len20 >= 10)
		split_text(loc_legend[20],14,loc_legend20_2,&r_ctr20);

		len21 = strlen(loc_legend[21]);
		split_text(loc_legend[21],10,loc_legend21_1,&r_ctr21);
		if (len21 >= 10)
		split_text(loc_legend[21],14,loc_legend21_2,&r_ctr21);

		len22 = strlen(loc_legend[22]);
		split_text(loc_legend[22],10,loc_legend22_1,&r_ctr22);
		if (len22 >= 10)
		split_text(loc_legend[22],14,loc_legend22_2,&r_ctr22);

		len23 = strlen(loc_legend[23]);
		split_text(loc_legend[23],10,loc_legend23_1,&r_ctr23);
		if (len23 >= 10)
		split_text(loc_legend[23],14,loc_legend23_2,&r_ctr23);		

		len24 = strlen(loc_legend[24]);
		split_text(loc_legend[24],10,loc_legend24_1,&r_ctr24);
		if (len24 >= 10)
		split_text(loc_legend[24],14,loc_legend24_2,&r_ctr24);		

		len25 = strlen(loc_legend[25]);
		split_text(loc_legend[25],10,loc_legend25_1,&r_ctr25);
		if (len25 >= 10)
		split_text(loc_legend[25],14,loc_legend25_2,&r_ctr25);		

		len26 = strlen(loc_legend[26]);
		split_text(loc_legend[26],10,loc_legend26_1,&r_ctr26);
		if (len26 >= 10)
		split_text(loc_legend[26],14,loc_legend26_2,&r_ctr26);
		
		len44 = strlen(loc_legend[44]);
		split_text(loc_legend[44],20,loc_legend44_1,&r_ctr44);
		if (len44 >= 10)
		split_text(loc_legend[44],14,loc_legend44_2,&r_ctr44);	
		
		len42 = strlen(loc_legend[42]);
		split_text(loc_legend[42],20,loc_legend42_1,&r_ctr42);
		if (len42 >= 10)
		split_text(loc_legend[42],14,loc_legend42_2,&r_ctr42);	
			
                len43 = strlen(loc_legend[43]);
		split_text(loc_legend[43],20,loc_legend43_1,&r_ctr43);
		if (len43 >= 10)
		split_text(loc_legend[43],14,loc_legend43_2,&r_ctr43);	

		len38 = strlen(loc_legend[38]);
		split_text(loc_legend[38],30,loc_legend38_1,&r_ctr38);
		if (len38 >= 10)
		split_text(loc_legend[38],14,loc_legend38_2,&r_ctr38);	

		len36 = strlen(loc_legend[36]);
		split_text(loc_legend[36],30,loc_legend36_1,&r_ctr36);
		if (len36 >= 10)
		split_text(loc_legend[36],14,loc_legend36_2,&r_ctr36);	

		len37 = strlen(loc_legend[37]);
		split_text(loc_legend[37],30,loc_legend37_1,&r_ctr37);
		if (len37 >= 10)
		split_text(loc_legend[37],14,loc_legend37_2,&r_ctr37);	

		len40 = strlen(loc_legend[40]);
		split_text(loc_legend[40],30,loc_legend40_1,&r_ctr40);
		if (len40 >= 10)
		split_text(loc_legend[40],14,loc_legend40_2,&r_ctr40);	

		len33 = strlen(loc_legend[33]);
		split_text(loc_legend[33],30,loc_legend33_1,&r_ctr33);
		if (len33 >= 10)
		split_text(loc_legend[33],14,loc_legend33_2,&r_ctr33);	

		len34 = strlen(loc_legend[34]);
		split_text(loc_legend[34],30,loc_legend34_1,&r_ctr34);
		if (len34 >= 10)
		split_text(loc_legend[34],14,loc_legend34_2,&r_ctr34);	
               
	

}
/* Pradeep 23-10-2006 */
get_sub_totals()
{
	fprintf(fp,"%119s"," ");
	for(i=0;i<112;i++)
	fprintf(fp,"%s","_");
	fprintf(fp,"\n%85s%9s%17s"," ",loc_legend[30]," ");
	print_formated(l_sub_deposit_total);
	print_formated(l_sub_bill_total);
	print_formated(l_sub_exemption_total);
	print_formated(l_sub_paid_total);
	print_formated(l_sub_refund_total);
	print_formated(l_sub_reconsilation_total);
	print_formated(l_sub_writeoff_total);
	print_formated(l_sub_outst_total);
	fprintf(fp,"\n");
	fprintf(fp,"%119s"," ");
	for(i=0;i<112;i++)
	fprintf(fp,"%s","_");
	fprintf(fp,"\n");
		
	l_sub_deposit_total			= 0;
	l_sub_bill_total			= 0;
	l_sub_exemption_total		= 0;
	l_sub_paid_total			= 0;
	l_sub_refund_total			= 0;
	l_sub_reconsilation_total	= 0;
	l_sub_writeoff_total		= 0;
	l_sub_outst_total			= 0;
}

get_grand_totals()
{
	fprintf(fp,"%112s"," ");
	for(i=0;i<120;i++)
	fprintf(fp,"%s","_");
	fprintf(fp,"\n%82s%8s%-6s%15s"," ",loc_legend[31],d_base_currency.arr," ");
	print_formated(l_grand_deposit_total);
	print_formated(l_grand_bill_total);
	print_formated(l_grand_exemption_total);
	print_formated(l_grand_paid_total);
	print_formated(l_grand_refund_total);
	print_formated(l_grand_reconsilation_total);
	print_formated(l_grand_writeoff_total);
	print_formated(l_grand_outst_total);
	fprintf(fp,"\n");
	fprintf(fp,"%112s"," ");
	for(i=0;i<120;i++)
	fprintf(fp,"%s","_");
	fprintf(fp,"\n");
	
	l_grand_deposit_total		= 0;
	l_grand_bill_total			= 0;
	l_grand_exemption_total		= 0;
	l_grand_paid_total			= 0;
	l_grand_refund_total		= 0;
	l_grand_reconsilation_total	= 0;
	l_grand_writeoff_total		= 0;
	l_grand_outst_total			= 0;
}
/* Pradeep 23-10-2006 */

print_report()
{
    print_page_title();

    d_prv_blng_grp_catg.arr[0]='\0';
	d_prv_blng_grp_catg.len=0;

	while(fetch_cursors())
	{
	     
	  print_letter_deposit_detail();
	  
	     
	}
	 
	get_sub_totals();
	 
	get_grand_totals();
	
}    
  
fetch_hosp_name()
{
    hosp_name.arr[0] = '\0';
    date_time.arr[0] = '\0';
    user_id.arr[0]   = '\0';
    hosp_name.len    = 0;
    date_time.len    = 0;
    user_id.len      = 0;

    /* EXEC SQL   SELECT ACC_ENTITY_NAME, 
			   TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
			   USER
         INTO  :hosp_name, :date_time, :user_id
         FROM  SY_ACC_ENTITY
		 WHERE  ACC_ENTITY_ID = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:\
MI') ,USER into :b0,:b1,:b2  from SY_ACC_ENTITY where ACC_ENTITY_ID=:b3";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )608;
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
    sqlstm.sqhstl[2] = (unsigned int  )22;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_facility_id;
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


print_formated(loc_amount)
double loc_amount;
{
    char s_amt[30], str_amt[30];	
    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
	    //strcat(s_amt,"-");
        sprintf(str_amt,"-%s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%15s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%14s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%15s",str_amt);
    }
}

check_page_break()
{
	if (l_line_no >= 60)	
	{
	        l_line_no = 0;
		fprintf(fp,"\f\n");
		print_page_title();
	}
}


print_spaces(l_length)
double l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(fp," ");
	}
}

fetch_legend_value()
{
    for(i=1;i<100;i++)
	{	l_pk_value.arr[0] = '\0';

		/* EXEC SQL SELECT LTRIM(RTRIM('BLR00061.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009')))))
		         INTO :l_pk_value
				 FROM dual; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select LTRIM(RTRIM(('BLR00061.LEGEND_'||LTRIM(RTRIM(TO_CHAR\
(:b0,'009')))))) into :b1  from dual ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )639;
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
  sqlstm.sqhstl[1] = (unsigned int  )202;
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
			blcommon.get_local_lang_desc(	
							:nd_facility_id,
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
  sqlstm.arrsiz = 20;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_local_lang_desc ( :nd_facility_id , 'S\
M' , 'SM_LANG_LEGEND' , 'DFLT_LEGEND_VALUE' , :l_pk_value , :l_translated_valu\
e , :p_language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )662;
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
  sqlstm.sqhstl[1] = (unsigned int  )202;
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

print_page_title()
{
	double l_report_width;
	double l_acc_entity_length;
	double l_start_point;
	double l_comp_name_end_point;
	int	   l_page_width;
	
	l_report_width=228;

	get_header_dtls();

	fprintf(fp,"%c",0x0F); // set printer to compressed mode 

	l_acc_entity_length = strlen(d_acc_entity_name.arr);

	//Code for Line 1
	l_start_point=(l_report_width/2)-(l_acc_entity_length/2);
	fprintf(fp,"MDL           : BL");
	l_start_point=l_start_point-18;
	print_spaces(l_start_point);
	fprintf(fp,"%s",d_acc_entity_name.arr);
	l_comp_name_end_point=l_start_point+18+l_acc_entity_length;
	l_start_point=(l_report_width-(15+strlen(date.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %s\n",loc_legend[11],date.arr);

	//Code for Line 2  
	l_start_point=0;
	l_start_point=(l_report_width/2)-((strlen(loc_legend[1]))/2);
	fprintf(fp,"OPR           : %s",d_user.arr);
	l_start_point=l_start_point-(strlen(d_user.arr)+16);
	print_spaces(l_start_point);
	fprintf(fp,"%s",loc_legend[1]);
	l_comp_name_end_point=l_start_point+(strlen(d_user.arr)+16)+strlen(loc_legend[1]);
	l_start_point=(l_report_width-(17+strlen(date_time.arr))-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp," %-15.15s : %s\n",loc_legend[12],date_time.arr);

	//Code for Line 3
	l_start_point=0;
		l_from_and_to_date.arr[0] = '\0';
	/* EXEC SQL SELECT :loc_legend[27]||' '||:nd_fr_date ||' '|| :loc_legend[28] ||' '|| :nd_to_date
	           INTO :l_from_and_to_date
	           FROM dual; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 20;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select ((((((:b0||' ')||:b1)||' ')||:b2)||' ')||:b3) into :b\
4  from dual ";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )693;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)loc_legend[27];
 sqlstm.sqhstl[0] = (unsigned int  )201;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_fr_date;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)loc_legend[28];
 sqlstm.sqhstl[2] = (unsigned int  )201;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_to_date;
 sqlstm.sqhstl[3] = (unsigned int  )22;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_from_and_to_date;
 sqlstm.sqhstl[4] = (unsigned int  )73;
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


	l_from_and_to_date.arr[l_from_and_to_date.len] = '\0';

	l_start_point=(l_report_width/2)-((strlen(l_from_and_to_date.arr))/2);
	fprintf(fp,"%-14.14s: BLR00061",loc_legend[14]);
	l_start_point=l_start_point-24;
	print_spaces(l_start_point);
	fprintf(fp,"%s",l_from_and_to_date.arr);
	l_comp_name_end_point=l_start_point+24+strlen(l_from_and_to_date.arr);
	l_start_point=(l_report_width-(17+7)-l_comp_name_end_point);
	print_spaces(l_start_point);
	fprintf(fp,"%-15.15s : %d\n",loc_legend[13],++l_page_no);	
		
	l_line_no= l_line_no + 3;
	print_page_header();	
}  

print_page_header()
{	
	int k = 0;
	char from_blg_cat[21],  to_blg_cat[21];
	char fr_bed_class[21],  to_bed_class[21];
	char fr_nur[21],  to_nur[21];
   	print_line(233);   
	fprintf(fp,"\n");  

	if (l_page_no == 1)
	{
	//	fprintf(fp,"VER		: 10.3\n\n\n\n");
	fprintf(fp,"\n\n\n\n");
		fprintf(fp,"		INPUT PARAMETER\n");	
		fprintf(fp,"		---------------\n\n");	
/* 		fprintf(fp,"			FROM DATE	: %s\n",nd_fr_date.arr);	
		fprintf(fp,"			  TO DATE	: %s\n",nd_to_date.arr); 
		COMMENTED BY SAIKIRAN ON IN13000 TO ALIGN ALL THE LEGENDS PROPERLY 
		*/
 	
 		fprintf(fp,"%-19s     FROM DATE       : %s\n"," ",nd_fr_date.arr);	
		fprintf(fp,"%-19s       TO DATE       : %s\n"," ",nd_to_date.arr); 
     
/*		if (nd_episode_type.arr[0] == 'I')
		fprintf(fp,"		     %-s       : %s\n",loc_legend[44],loc_legend[42]);
		else
		fprintf(fp,"%-15s: %s\n",loc_legend[44],loc_legend[43]);
		COMMENTED BY SAIKIRAN ON IN13000 TO ALIGN ALL THE LEGENDS PROPERLY 
*/
       
		if (nd_episode_type.arr[0] == 'I')
		fprintf(fp,"%-20s %-s       : %s\n"," ",loc_legend[44],loc_legend[42]);
		else
		fprintf(fp,"%-20s %-s       : %-s\n"," ",loc_legend[44],loc_legend[43]);


	if(strcmp(nd_blng_grp_fr_catg.arr,"!!!!")==0)
			strcpy(from_blg_cat, loc_legend[33]);
		else
			strcpy(from_blg_cat, nd_blng_grp_fr_catg.arr);
		

		if(strcmp(nd_blng_grp_to_catg.arr,"~~~~")==0)
			strcpy(to_blg_cat, loc_legend[34]);
		else
			strcpy(to_blg_cat, nd_blng_grp_to_catg.arr);

fprintf(fp,"%10.10s %-28.30s : %-8s %-8s %-4s %-8s\n"," ",loc_legend[38],loc_legend[36],from_blg_cat,loc_legend[37],to_blg_cat);  


		if(strcmp(nd_fr_nur_unit.arr,"!!!!")==0)
			strcpy(fr_nur, loc_legend[33]);
		else
			strcpy(fr_nur, nd_fr_nur_unit.arr);
		

		if(strcmp(nd_to_nur_unit.arr,"~~~~")==0)
			strcpy(to_nur, loc_legend[34]);
		else
			strcpy(to_nur, nd_to_nur_unit.arr);

fprintf(fp,"%20.20s %-18.18s : %-8s %-8s %-4s %-8s\n"," ",loc_legend[50],loc_legend[36],fr_nur,loc_legend[37],to_nur);  




  
		if(strcmp(nd_fr_bed_class.arr,"!!")==0)
			strcpy(fr_bed_class, loc_legend[33]);
		else
			strcpy(fr_bed_class, nd_fr_bed_class.arr);

		if(strcmp(nd_to_bed_class.arr,"~~")==0)
			strcpy(to_bed_class, loc_legend[34]);
		else
			strcpy(to_bed_class,nd_to_bed_class.arr);

 fprintf(fp,"%23.10s %-15.15s : %-8s %-8s %-4s %-8s \n"," ",loc_legend[40],loc_legend[36],fr_bed_class,loc_legend[37],to_bed_class);	
 //fprintf(fp,"%23.10s %-30.30s : %-8s %-8s %-4s %-8s\n"," ",loc_legend[101],loc_legend[101],fr_bed_class,loc_legend[37],to_bed_class);  

		l_line_no = 60;
		check_page_break();
	}
	else
	{	
		//fprintf(fp,"%5.5s %-20.20s %-10.10s %-40.40s %-5.5s %-12.12s %-13.13s",
		//loc_legend[29],loc_legend[2],loc_legend[3],loc_legend[4],loc_legend[8],loc_legend[17],loc_legend[18]);

		//fprintf(fp," %14.14s %14.14s %14.14s %14.14s %14.14s %14.14s %14.14s %14.14s\n",
		//loc_legend[19],loc_legend[20],loc_legend[21],loc_legend[22],loc_legend[23],loc_legend[24],loc_legend[25],loc_legend[26]);	

		

		fprintf(fp,"%5.5s %-20.20s %-10.10s %-40.40s %-5.5s %-12.12s %-13.13s",
		loc_legend29_1,loc_legend2_1,loc_legend3_1,loc_legend4_1,loc_legend8_1,loc_legend17_1,loc_legend18_1);

		fprintf(fp," %14.14s %14.14s %14.14s %14.14s %14.14s %14.14s %14.14s %14.14s\n",
		loc_legend19_1,loc_legend20_1,loc_legend21_1,loc_legend22_1,loc_legend23_1,loc_legend24_1,loc_legend25_1,loc_legend26_1);	


		fprintf(fp,"%5.5s %-20.20s %-10.10s %-40.40s %-5.5s %-12.12s %-13.13s",
		loc_legend29_2	,loc_legend2_2,loc_legend3_2,loc_legend4_2,loc_legend8_2,loc_legend17_2,loc_legend18_2);
						
		fprintf(fp," %14.14s %14.14s %14.14s %14.14s %14.14s %14.14s %14.14s %14.14s\n",
		loc_legend19_2,loc_legend20_2,loc_legend21_2,loc_legend22_2,loc_legend23_2,loc_legend24_2,loc_legend25_2,loc_legend26_2);	
         
		fprintf(fp," %125s",loc_legend32_1);
		fprintf(fp," %14s",loc_legend46_1);
		fprintf(fp," %31s",loc_legend32_1);
        fprintf(fp,"\n");
        fprintf(fp," %125s",loc_legend45_1);
        fprintf(fp," %14.14s",loc_legend47_1);
		fprintf(fp," %31.31s",loc_legend45_1);
		fprintf(fp,"\n");
         

		//fprintf(fp," %133s       %20s %30s\n",loc_legend45_1,loc_legend47_1,loc_legend45_1);
		  

		//fprintf(fp,"%5.5s %-72.72s %-9.9s %-10.10s\n"," "," ", "", loc_legend17_2);		

		print_line(233);

		fprintf(fp,"\n");
		l_line_no = l_line_no+5;
	}
}


print_line(l_length)
int l_length;
{
	for(i=0;i<l_length;i++)
	{
		fprintf(fp,"-");
	}
}
get_header_dtls()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT ACC_ENTITY_NAME,
					'('||BASE_CURRENCY||')',
				    USER,
				    TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI'),
					TO_CHAR(SYSDATE,'DD/MM/YYYY'),
					TO_CHAR(SYSDATE,'HH24:MI:SS')
		      INTO :d_acc_entity_name,
				   :d_base_currency,
			  	   :d_user,
				   :d_sysdate,
				   :date,
				   :date_time
              FROM SY_ACC_ENTITY
			 WHERE acc_entity_id = :nd_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ACC_ENTITY_NAME ,(('('||BASE_CURRENCY)||')') ,USER\
 ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,TO_CHA\
R(SYSDATE,'HH24:MI:SS') into :b0,:b1,:b2,:b3,:b4,:b5  from SY_ACC_ENTITY where\
 acc_entity_id=:b6";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )728;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
    sqlstm.sqhstl[0] = (unsigned int  )43;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_base_currency;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_user;
    sqlstm.sqhstl[2] = (unsigned int  )23;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_sysdate;
    sqlstm.sqhstl[3] = (unsigned int  )19;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&date;
    sqlstm.sqhstl[4] = (unsigned int  )22;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&date_time;
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
    sqlstm.sqphsv = sqlstm.sqhstv;
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
    date.arr[date.len]							 = '\0';
    date_time.arr[date_time.len]				 = '\0';	

	return;    

	err_exit:
	   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 20;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )771;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	   disp_message(ERR_MESG,"Oracle error at get_header_dtls() occured....");
	   disp_message(ERR_MESG, sqlca.sqlerrm.sqlerrmc);
	   proc_exit();
}



